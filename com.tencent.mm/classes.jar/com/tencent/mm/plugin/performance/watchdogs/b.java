package com.tencent.mm.plugin.performance.watchdogs;

import android.os.Process;
import android.text.TextUtils;
import com.tencent.matrix.fd.FDDumpBridge;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class b
  implements Runnable
{
  private static final b MMK;
  private static final Set<String> MMV;
  private boolean MML;
  private boolean MMM;
  private boolean MMN;
  @Deprecated
  private boolean MMO;
  private int MMP;
  private int MMQ;
  private final Map<String, Map<String, Integer>> MMR;
  private final Map<String, Integer> MMS;
  public int MMT;
  private boolean MMU;
  
  static
  {
    AppMethodBeat.i(301088);
    MMK = new b();
    HashSet localHashSet = new HashSet();
    MMV = localHashSet;
    localHashSet.add("anon_inode:sync_file");
    AppMethodBeat.o(301088);
  }
  
  private b()
  {
    AppMethodBeat.i(301035);
    this.MMT = 1024;
    this.MMR = new HashMap();
    this.MMS = new HashMap();
    AppMethodBeat.o(301035);
  }
  
  private int a(a parama)
  {
    AppMethodBeat.i(301053);
    parama = (Integer)this.MMS.get(parama.name());
    if (parama == null)
    {
      AppMethodBeat.o(301053);
      return 0;
    }
    int i = parama.intValue();
    AppMethodBeat.o(301053);
    return i;
  }
  
  private static boolean aRD(String paramString)
  {
    AppMethodBeat.i(301083);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(301083);
      return true;
    }
    Iterator localIterator = MMV.iterator();
    while (localIterator.hasNext()) {
      if (paramString.matches((String)localIterator.next()))
      {
        AppMethodBeat.o(301083);
        return true;
      }
    }
    AppMethodBeat.o(301083);
    return false;
  }
  
  public static b gzp()
  {
    return MMK;
  }
  
  private String gzq()
  {
    AppMethodBeat.i(301047);
    Object localObject2 = new ArrayList(this.MMS.entrySet());
    Collections.sort((List)localObject2, new Comparator() {});
    Object localObject1 = new StringBuilder();
    localObject2 = ((List)localObject2).iterator();
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (Map.Entry)((Iterator)localObject2).next();
      Log.e("MicroMsg.FDWatchDog", ">>>>>>>>>>>> FD SOS: type = %s, count = %s", new Object[] { ((Map.Entry)localObject3).getKey(), ((Map.Entry)localObject3).getValue() });
      localObject3 = (Map)this.MMR.get(((Map.Entry)localObject3).getKey());
      if (localObject3 != null)
      {
        localObject3 = new ArrayList(((Map)localObject3).entrySet());
        Collections.sort((List)localObject3, new Comparator() {});
        localObject3 = ((List)localObject3).iterator();
        int j = i;
        for (;;)
        {
          i = j;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
          Log.e("MicroMsg.FDWatchDog", "-> [%s] %s", new Object[] { localEntry.getValue(), localEntry.getKey() });
          if (j < 40) {
            ((StringBuilder)localObject1).append("[").append(localEntry.getValue()).append("]").append((String)localEntry.getKey()).append(";");
          }
          j += 1;
        }
      }
    }
    localObject1 = ((StringBuilder)localObject1).toString();
    Log.e("MicroMsg.FDWatchDog", "top path is %s", new Object[] { localObject1 });
    AppMethodBeat.o(301047);
    return localObject1;
  }
  
  private int gzr()
  {
    AppMethodBeat.i(301070);
    long l = System.currentTimeMillis();
    int i = 0;
    this.MMP = 0;
    Object localObject1 = new u(String.format("/proc/%s/fd", new Object[] { Integer.valueOf(Process.myPid()) }));
    if (!((u)localObject1).jKS())
    {
      f.Ozc.idkeyStat(1031L, 255L, 1L, false);
      Log.e("MicroMsg.FDWatchDog", "file not exists: %s", new Object[] { ah.v(((u)localObject1).mUri) });
      AppMethodBeat.o(301070);
      return 0;
    }
    this.MMR.clear();
    this.MMS.clear();
    int j = i;
    for (;;)
    {
      int m;
      String str;
      int k;
      try
      {
        u[] arrayOfu = ((u)localObject1).jKX();
        if (arrayOfu == null)
        {
          j = i;
          Log.e("MicroMsg.FDWatchDog", "reading empty dir");
          return 0;
        }
        j = i;
        m = arrayOfu.length;
        if (m < 896)
        {
          j = m;
          Log.i("MicroMsg.FDWatchDog", "skip parsing fd: fd count = %s", new Object[] { Integer.valueOf(m) });
          return m;
        }
        j = m;
        int n = arrayOfu.length;
        i = 0;
        if (i >= n) {
          break label760;
        }
        j = m;
        localObject3 = ah.v(arrayOfu[i].jKT());
        j = m;
        str = new File((String)localObject3).getCanonicalPath();
        j = m;
        if (!((String)localObject3).equalsIgnoreCase(str))
        {
          j = m;
          localObject1 = str;
          if (!TextUtils.isEmpty(str)) {
            break label774;
          }
        }
        j = m;
        str = FDDumpBridge.gC((String)localObject3);
        j = m;
        localObject1 = str;
        if (!TextUtils.isEmpty(str)) {
          break label774;
        }
        j = m;
        Log.e("MicroMsg.FDWatchDog", "file name is empty %s", new Object[] { localObject3 });
        j = m;
        f.Ozc.idkeyStat(1031L, 252L, 1L, false);
        localObject1 = localObject3;
        j = m;
        if (aRD((String)localObject1))
        {
          j = m;
          Log.i("MicroMsg.FDWatchDog", "ignore %s", new Object[] { localObject1 });
          j = m;
          this.MMP += 1;
          break label777;
        }
        j = m;
        localObject3 = a.values();
        j = m;
        int i1 = localObject3.length;
        k = 0;
        if (k >= i1) {
          break label777;
        }
        str = localObject3[k];
        j = m;
        if (!((String)localObject1).matches(a.b(str))) {
          break label753;
        }
        j = m;
        localObject3 = (Map)this.MMR.get(str.name());
        if (localObject3 != null) {
          break label771;
        }
        j = m;
        localObject3 = new HashMap();
        j = m;
        this.MMR.put(str.name(), localObject3);
        j = m;
        localInteger = (Integer)((Map)localObject3).get(localObject1);
        if (localInteger != null) {
          continue;
        }
        j = m;
        ((Map)localObject3).put(localObject1, Integer.valueOf(1));
      }
      catch (Exception localException)
      {
        Object localObject3;
        Integer localInteger;
        f.Ozc.idkeyStat(1031L, 254L, 1L, false);
        Log.printErrStackTrace("MicroMsg.FDWatchDog", localException, "", new Object[0]);
        i = j - this.MMP;
        if (i > 0) {
          continue;
        }
        Log.e("MicroMsg.FDWatchDog", "fd dump error");
        f.Ozc.idkeyStat(1031L, 253L, 1L, false);
        Log.i("MicroMsg.FDWatchDog", "dump cost: %d, FDCount = %d, mIgnoredCount = %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(i), Integer.valueOf(this.MMP) });
        return i;
        j = m;
        ((Map)localObject3).put(localException, Integer.valueOf(localInteger.intValue() + 1));
        continue;
      }
      finally
      {
        AppMethodBeat.o(301070);
      }
      j = m;
      localObject1 = (Integer)this.MMS.get(str.name());
      if (localObject1 == null)
      {
        j = m;
        this.MMS.put(str.name(), Integer.valueOf(1));
      }
      else
      {
        j = m;
        this.MMS.put(str.name(), Integer.valueOf(localObject2.intValue() + 1));
        break label777;
        label753:
        k += 1;
        continue;
        label760:
        i = m - this.MMP;
        continue;
        label771:
        continue;
        label774:
        continue;
      }
      label777:
      i += 1;
    }
  }
  
  private void u(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(301077);
    f.Ozc.b(17899, new Object[] { Integer.valueOf(paramInt1), Long.valueOf(System.currentTimeMillis()), MMApplicationContext.getProcessName(), Integer.valueOf(a(a.MMX)), Integer.valueOf(a(a.MMY)), Integer.valueOf(a(a.MNb)), Integer.valueOf(a(a.MNd)), Integer.valueOf(a(a.MNe)), Integer.valueOf(a(a.MNf)), Integer.valueOf(a(a.MNg)), Integer.valueOf(a(a.MNh)), Integer.valueOf(a(a.MNi)), Integer.valueOf(a(a.MNj)), Integer.valueOf(a(a.MNk)), Integer.valueOf(a(a.MNl)), Integer.valueOf(a(a.MNm)), Integer.valueOf(a(a.MNn)), Integer.valueOf(a(a.MNo)), Integer.valueOf(a(a.MNp)), Integer.valueOf(a(a.MNq)), Integer.valueOf(a(a.MNr)), Integer.valueOf(a(a.MNt)), paramString, Integer.valueOf(this.MMP), Integer.valueOf(a(a.MMZ)), Integer.valueOf(a(a.MNc)), Integer.valueOf(a(a.MNa)), Integer.valueOf(paramInt2), Integer.valueOf(this.MMT), Integer.valueOf(a(a.MNs)) });
    AppMethodBeat.o(301077);
  }
  
  public final void run()
  {
    AppMethodBeat.i(301092);
    int i;
    if (MMApplicationContext.isMainProcess()) {
      i = 100;
    }
    for (;;)
    {
      int j = gzr();
      if ((j <= 256) && (j - this.MMQ > 32))
      {
        f.Ozc.idkeyStat(1031L, i - 2, 1L, false);
        this.MMQ = Math.max(j, this.MMQ);
      }
      for (;;)
      {
        if ((j > this.MMT * 0.9D) && (!this.MMU))
        {
          Log.e("MicroMsg.FDWatchDog", ">>>>>>>>>>>> FD SOS: total count = %d", new Object[] { Integer.valueOf(j) });
          this.MMU = true;
          f.Ozc.idkeyStat(1031L, i + 4, 1L, false);
          u(j, gzq(), 1);
        }
        h.ahAA.p(this, 1800000L);
        AppMethodBeat.o(301092);
        return;
        if ((MMApplicationContext.isToolsProcess()) || (MMApplicationContext.isToolsMpProcess()))
        {
          i = 120;
          break;
        }
        if (MMApplicationContext.isAppBrandProcess())
        {
          i = 140;
          break;
        }
        if (!MMApplicationContext.isPushProcess()) {
          break label396;
        }
        i = 150;
        break;
        if ((256 < j) && (j <= 512) && (!this.MML))
        {
          f.Ozc.idkeyStat(1031L, i - 1, 1L, false);
          this.MML = true;
        }
        else if ((512 < j) && (j <= 768) && (!this.MMM))
        {
          f.Ozc.idkeyStat(1031L, i, 1L, false);
          this.MMM = true;
        }
        else if ((768 < j) && (j <= 896) && (!this.MMN))
        {
          f.Ozc.idkeyStat(1031L, i + 1, 1L, false);
          this.MMN = true;
        }
        else if ((j > 896) && (!this.MMO))
        {
          f.Ozc.idkeyStat(1031L, i + 2, 1L, false);
          Log.e("MicroMsg.FDWatchDog", ">>>>>>>>>>>> FD SOS: total count = %d", new Object[] { Integer.valueOf(j) });
          u(j, gzq(), 0);
          this.MMO = true;
        }
      }
      label396:
      i = 0;
    }
  }
  
  static enum a
  {
    private final String MNu;
    
    static
    {
      AppMethodBeat.i(301023);
      MMX = new a("FD_TYPE_ANNON_INODE_EVENT", 0, "anon_inode:\\[event.*\\]");
      MMY = new a("FD_TYPE_ANNON_INODE_DMABUF", 1, ".*dmabuf.*");
      MMZ = new a("FD_TYPE_ANNON_INODE_GRALLOC", 2, "anon_inode:gralloc.*");
      MNa = new a("FD_TYPE_ANNON_INODE_MALITL", 3, "anon_inode:malitl.*");
      MNb = new a("FD_TYPE_SOCKET", 4, ".*socket:.*");
      MNc = new a("FD_TYPE_PIPE", 5, ".*pipe:[0-9]*");
      MNd = new a("FD_TYPE_PATH_DATA_MM_FILES_MMKV", 6, "/data/.*/" + MMApplicationContext.getApplicationId() + "/files/mmkv/.*");
      MNe = new a("FD_TYPE_PATH_DATA_MM_FILES_KVCOMM", 7, "/data/.*/" + MMApplicationContext.getApplicationId() + "/files/kvcomm/.*");
      MNf = new a("FD_TYPE_PATH_DATA_MM_FILES_XLOG", 8, "/data/.*/" + MMApplicationContext.getApplicationId() + "/files/xlog/.*");
      MNg = new a("FD_TYPE_PATH_DATA_MM_FILES_OTHERS", 9, "/data/.*/" + MMApplicationContext.getApplicationId() + "/files/.*");
      MNh = new a("FD_TYPE_PATH_DATA_MM_MICRO_MSG", 10, "/data/.*/" + MMApplicationContext.getApplicationId() + "/MicroMsg/.*");
      MNi = new a("FD_TYPE_PATH_DATA_MM_OTHERS", 11, "/data/.*/" + MMApplicationContext.getApplicationId() + "/.*");
      MNj = new a("FD_TYPE_PATH_EXT_AC_VOICE", 12, ".*/MicroMsg/[0-9a-eA-E]+/voice2/.*");
      MNk = new a("FD_TYPE_PATH_EXT_AC_VIDEO", 13, ".*/MicroMsg/[0-9a-eA-E]+/video/.*");
      MNl = new a("FD_TYPE_PATH_EXT_AC_ATTACHMENT", 14, ".*/MicroMsg/[0-9a-eA-E]+/attachment/.*");
      MNm = new a("FD_TYPE_PATH_EXT_AC_IMAGE", 15, ".*/MicroMsg/[0-9a-eA-E]+/image[2]?/.*");
      MNn = new a("FD_TYPE_PATH_EXT_AC_OTHERS", 16, ".*/MicroMsg/[0-9a-eA-E]+/.*");
      MNo = new a("FD_TYPE_PATH_EXT_OTHERS", 17, ".*/MicroMsg/.*");
      MNp = new a("FD_TYPE_PATH_SYSTEM_FRAMEWORK", 18, "/system/framework/.*");
      MNq = new a("FD_TYPE_PATH_DEV_ASHMEM", 19, "/dev/ashmem");
      MNr = new a("FD_TYPE_PATH_DEV_OTHERS", 20, "/dev/.*");
      MNs = new a("FD_TYPE_RAW_PATH", 21, "/proc/[0-9]*/fd/[0-9]*");
      MNt = new a("FD_TYPE_OTHERS", 22, ".*");
      MNv = new a[] { MMX, MMY, MMZ, MNa, MNb, MNc, MNd, MNe, MNf, MNg, MNh, MNi, MNj, MNk, MNl, MNm, MNn, MNo, MNp, MNq, MNr, MNs, MNt };
      AppMethodBeat.o(301023);
    }
    
    private a(String paramString)
    {
      this.MNu = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.watchdogs.b
 * JD-Core Version:    0.7.0.1
 */