package com.tencent.mm.plugin.performance.watchdogs;

import android.annotation.SuppressLint;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.fd.FDDumpBridge;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.q;
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

public final class a
  implements Runnable
{
  private static final Set<String> GPE;
  private static final a GPt;
  private final Map<String, Map<String, Integer>> GPA;
  private final Map<String, Integer> GPB;
  public int GPC;
  private boolean GPD;
  private boolean GPu;
  private boolean GPv;
  private boolean GPw;
  @Deprecated
  private boolean GPx;
  private int GPy;
  private int GPz;
  
  static
  {
    AppMethodBeat.i(200862);
    GPt = new a();
    HashSet localHashSet = new HashSet();
    GPE = localHashSet;
    localHashSet.add("anon_inode:sync_file");
    AppMethodBeat.o(200862);
  }
  
  private a()
  {
    AppMethodBeat.i(200840);
    this.GPC = 1024;
    this.GPA = new HashMap();
    this.GPB = new HashMap();
    AppMethodBeat.o(200840);
  }
  
  private int a(a parama)
  {
    AppMethodBeat.i(200850);
    parama = (Integer)this.GPB.get(parama.name());
    if (parama == null)
    {
      AppMethodBeat.o(200850);
      return 0;
    }
    int i = parama.intValue();
    AppMethodBeat.o(200850);
    return i;
  }
  
  private static boolean aUv(String paramString)
  {
    AppMethodBeat.i(200861);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(200861);
      return true;
    }
    Iterator localIterator = GPE.iterator();
    while (localIterator.hasNext()) {
      if (paramString.matches((String)localIterator.next()))
      {
        AppMethodBeat.o(200861);
        return true;
      }
    }
    AppMethodBeat.o(200861);
    return false;
  }
  
  public static a jdMethod_for()
  {
    return GPt;
  }
  
  private String fos()
  {
    AppMethodBeat.i(200848);
    Object localObject2 = new ArrayList(this.GPB.entrySet());
    Collections.sort((List)localObject2, new Comparator() {});
    Object localObject1 = new StringBuilder();
    localObject2 = ((List)localObject2).iterator();
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (Map.Entry)((Iterator)localObject2).next();
      Log.e("MicroMsg.FDWatchDog", ">>>>>>>>>>>> FD SOS: type = %s, count = %s", new Object[] { ((Map.Entry)localObject3).getKey(), ((Map.Entry)localObject3).getValue() });
      localObject3 = (Map)this.GPA.get(((Map.Entry)localObject3).getKey());
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
    AppMethodBeat.o(200848);
    return localObject1;
  }
  
  private int fot()
  {
    AppMethodBeat.i(200854);
    long l = System.currentTimeMillis();
    int i = 0;
    this.GPy = 0;
    Object localObject1 = new q(String.format("/proc/%s/fd", new Object[] { Integer.valueOf(Process.myPid()) }));
    if (!((q)localObject1).ifE())
    {
      f.Iyx.idkeyStat(1031L, 255L, 1L, false);
      Log.e("MicroMsg.FDWatchDog", "file not exists: %s", new Object[] { ((q)localObject1).getPath() });
      AppMethodBeat.o(200854);
      return 0;
    }
    this.GPA.clear();
    this.GPB.clear();
    int j = i;
    for (;;)
    {
      int m;
      String str;
      int k;
      try
      {
        q[] arrayOfq = ((q)localObject1).ifJ();
        if (arrayOfq == null)
        {
          j = i;
          Log.e("MicroMsg.FDWatchDog", "reading empty dir");
          return 0;
        }
        j = i;
        m = arrayOfq.length;
        if (m < 896)
        {
          j = m;
          Log.i("MicroMsg.FDWatchDog", "skip parsing fd: fd count = %s", new Object[] { Integer.valueOf(m) });
          return m;
        }
        j = m;
        int n = arrayOfq.length;
        i = 0;
        if (i >= n) {
          break label753;
        }
        j = m;
        localObject3 = arrayOfq[i].bOF();
        j = m;
        str = new File((String)localObject3).getCanonicalPath();
        j = m;
        if (!((String)localObject3).equalsIgnoreCase(str))
        {
          j = m;
          localObject1 = str;
          if (!TextUtils.isEmpty(str)) {
            break label767;
          }
        }
        j = m;
        str = FDDumpBridge.fe((String)localObject3);
        j = m;
        localObject1 = str;
        if (!TextUtils.isEmpty(str)) {
          break label767;
        }
        j = m;
        Log.e("MicroMsg.FDWatchDog", "file name is empty %s", new Object[] { localObject3 });
        j = m;
        f.Iyx.idkeyStat(1031L, 252L, 1L, false);
        localObject1 = localObject3;
        j = m;
        if (aUv((String)localObject1))
        {
          j = m;
          Log.i("MicroMsg.FDWatchDog", "ignore %s", new Object[] { localObject1 });
          j = m;
          this.GPy += 1;
          break label770;
        }
        j = m;
        localObject3 = a.values();
        j = m;
        int i1 = localObject3.length;
        k = 0;
        if (k >= i1) {
          break label770;
        }
        str = localObject3[k];
        j = m;
        if (!((String)localObject1).matches(a.b(str))) {
          break label746;
        }
        j = m;
        localObject3 = (Map)this.GPA.get(str.name());
        if (localObject3 != null) {
          break label764;
        }
        j = m;
        localObject3 = new HashMap();
        j = m;
        this.GPA.put(str.name(), localObject3);
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
        f.Iyx.idkeyStat(1031L, 254L, 1L, false);
        Log.printErrStackTrace("MicroMsg.FDWatchDog", localException, "", new Object[0]);
        i = j - this.GPy;
        if (i > 0) {
          continue;
        }
        Log.e("MicroMsg.FDWatchDog", "fd dump error");
        f.Iyx.idkeyStat(1031L, 253L, 1L, false);
        Log.i("MicroMsg.FDWatchDog", "dump cost: %d, FDCount = %d, mIgnoredCount = %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(i), Integer.valueOf(this.GPy) });
        return i;
        j = m;
        ((Map)localObject3).put(localException, Integer.valueOf(localInteger.intValue() + 1));
        continue;
      }
      finally
      {
        AppMethodBeat.o(200854);
      }
      j = m;
      localObject1 = (Integer)this.GPB.get(str.name());
      if (localObject1 == null)
      {
        j = m;
        this.GPB.put(str.name(), Integer.valueOf(1));
      }
      else
      {
        j = m;
        this.GPB.put(str.name(), Integer.valueOf(localObject2.intValue() + 1));
        break label770;
        label746:
        k += 1;
        continue;
        label753:
        i = m - this.GPy;
        continue;
        label764:
        continue;
        label767:
        continue;
      }
      label770:
      i += 1;
    }
  }
  
  private void q(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(200860);
    f.Iyx.a(17899, new Object[] { Integer.valueOf(paramInt1), Long.valueOf(System.currentTimeMillis()), MMApplicationContext.getProcessName(), Integer.valueOf(a(a.GPG)), Integer.valueOf(a(a.GPH)), Integer.valueOf(a(a.GPK)), Integer.valueOf(a(a.GPM)), Integer.valueOf(a(a.GPN)), Integer.valueOf(a(a.GPO)), Integer.valueOf(a(a.GPP)), Integer.valueOf(a(a.GPQ)), Integer.valueOf(a(a.GPR)), Integer.valueOf(a(a.GPT)), Integer.valueOf(a(a.GPU)), Integer.valueOf(a(a.GPV)), Integer.valueOf(a(a.GPW)), Integer.valueOf(a(a.GPX)), Integer.valueOf(a(a.GPY)), Integer.valueOf(a(a.GPZ)), Integer.valueOf(a(a.GQa)), Integer.valueOf(a(a.GQb)), Integer.valueOf(a(a.GQd)), paramString, Integer.valueOf(this.GPy), Integer.valueOf(a(a.GPI)), Integer.valueOf(a(a.GPL)), Integer.valueOf(a(a.GPJ)), Integer.valueOf(paramInt2), Integer.valueOf(this.GPC), Integer.valueOf(a(a.GQc)) });
    AppMethodBeat.o(200860);
  }
  
  public final void run()
  {
    AppMethodBeat.i(200843);
    int i;
    if (MMApplicationContext.isMainProcess()) {
      i = 100;
    }
    for (;;)
    {
      int j = fot();
      if ((j <= 256) && (j - this.GPz > 32))
      {
        f.Iyx.idkeyStat(1031L, i - 2, 1L, false);
        this.GPz = Math.max(j, this.GPz);
      }
      for (;;)
      {
        if ((j > this.GPC * 0.9D) && (!this.GPD))
        {
          Log.e("MicroMsg.FDWatchDog", ">>>>>>>>>>>> FD SOS: total count = %d", new Object[] { Integer.valueOf(j) });
          this.GPD = true;
          f.Iyx.idkeyStat(1031L, i + 4, 1L, false);
          q(j, fos(), 1);
        }
        h.ZvG.o(this, 1800000L);
        AppMethodBeat.o(200843);
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
        if ((256 < j) && (j <= 512) && (!this.GPu))
        {
          f.Iyx.idkeyStat(1031L, i - 1, 1L, false);
          this.GPu = true;
        }
        else if ((512 < j) && (j <= 768) && (!this.GPv))
        {
          f.Iyx.idkeyStat(1031L, i, 1L, false);
          this.GPv = true;
        }
        else if ((768 < j) && (j <= 896) && (!this.GPw))
        {
          f.Iyx.idkeyStat(1031L, i + 1, 1L, false);
          this.GPw = true;
        }
        else if ((j > 896) && (!this.GPx))
        {
          f.Iyx.idkeyStat(1031L, i + 2, 1L, false);
          Log.e("MicroMsg.FDWatchDog", ">>>>>>>>>>>> FD SOS: total count = %d", new Object[] { Integer.valueOf(j) });
          q(j, fos(), 0);
          this.GPx = true;
        }
      }
      label396:
      i = 0;
    }
  }
  
  @SuppressLint({"SdCardPath"})
  static enum a
  {
    private final String GQe;
    
    static
    {
      AppMethodBeat.i(200629);
      GPG = new a("FD_TYPE_ANNON_INODE_EVENT", 0, "anon_inode:\\[event.*\\]");
      GPH = new a("FD_TYPE_ANNON_INODE_DMABUF", 1, ".*dmabuf.*");
      GPI = new a("FD_TYPE_ANNON_INODE_GRALLOC", 2, "anon_inode:gralloc.*");
      GPJ = new a("FD_TYPE_ANNON_INODE_MALITL", 3, "anon_inode:malitl.*");
      GPK = new a("FD_TYPE_SOCKET", 4, ".*socket:.*");
      GPL = new a("FD_TYPE_PIPE", 5, ".*pipe:[0-9]*");
      GPM = new a("FD_TYPE_PATH_DATA_MM_FILES_MMKV", 6, "/data/.*/" + MMApplicationContext.getApplicationId() + "/files/mmkv/.*");
      GPN = new a("FD_TYPE_PATH_DATA_MM_FILES_KVCOMM", 7, "/data/.*/" + MMApplicationContext.getApplicationId() + "/files/kvcomm/.*");
      GPO = new a("FD_TYPE_PATH_DATA_MM_FILES_XLOG", 8, "/data/.*/" + MMApplicationContext.getApplicationId() + "/files/xlog/.*");
      GPP = new a("FD_TYPE_PATH_DATA_MM_FILES_OTHERS", 9, "/data/.*/" + MMApplicationContext.getApplicationId() + "/files/.*");
      GPQ = new a("FD_TYPE_PATH_DATA_MM_MICRO_MSG", 10, "/data/.*/" + MMApplicationContext.getApplicationId() + "/MicroMsg/.*");
      GPR = new a("FD_TYPE_PATH_DATA_MM_OTHERS", 11, "/data/.*/" + MMApplicationContext.getApplicationId() + "/.*");
      GPT = new a("FD_TYPE_PATH_EXT_AC_VOICE", 12, ".*/MicroMsg/[0-9a-eA-E]+/voice2/.*");
      GPU = new a("FD_TYPE_PATH_EXT_AC_VIDEO", 13, ".*/MicroMsg/[0-9a-eA-E]+/video/.*");
      GPV = new a("FD_TYPE_PATH_EXT_AC_ATTACHMENT", 14, ".*/MicroMsg/[0-9a-eA-E]+/attachment/.*");
      GPW = new a("FD_TYPE_PATH_EXT_AC_IMAGE", 15, ".*/MicroMsg/[0-9a-eA-E]+/image[2]?/.*");
      GPX = new a("FD_TYPE_PATH_EXT_AC_OTHERS", 16, ".*/MicroMsg/[0-9a-eA-E]+/.*");
      GPY = new a("FD_TYPE_PATH_EXT_OTHERS", 17, ".*/MicroMsg/.*");
      GPZ = new a("FD_TYPE_PATH_SYSTEM_FRAMEWORK", 18, "/system/framework/.*");
      GQa = new a("FD_TYPE_PATH_DEV_ASHMEM", 19, "/dev/ashmem");
      GQb = new a("FD_TYPE_PATH_DEV_OTHERS", 20, "/dev/.*");
      GQc = new a("FD_TYPE_RAW_PATH", 21, "/proc/[0-9]*/fd/[0-9]*");
      GQd = new a("FD_TYPE_OTHERS", 22, ".*");
      GQf = new a[] { GPG, GPH, GPI, GPJ, GPK, GPL, GPM, GPN, GPO, GPP, GPQ, GPR, GPT, GPU, GPV, GPW, GPX, GPY, GPZ, GQa, GQb, GQc, GQd };
      AppMethodBeat.o(200629);
    }
    
    private a(String paramString)
    {
      this.GQe = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.watchdogs.a
 * JD-Core Version:    0.7.0.1
 */