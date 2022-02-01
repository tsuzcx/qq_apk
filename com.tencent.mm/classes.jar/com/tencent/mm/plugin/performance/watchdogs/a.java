package com.tencent.mm.plugin.performance.watchdogs;

import android.annotation.SuppressLint;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.wxperf.fd.FDDumpBridge;
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
  private static final a AVV;
  private static final Set<String> AWg;
  private boolean AVW;
  private boolean AVX;
  private boolean AVY;
  @Deprecated
  private boolean AVZ;
  private int AWa;
  private int AWb;
  private final Map<String, Map<String, Integer>> AWc;
  private final Map<String, Integer> AWd;
  public int AWe;
  private boolean AWf;
  
  static
  {
    AppMethodBeat.i(201129);
    AVV = new a();
    HashSet localHashSet = new HashSet();
    AWg = localHashSet;
    localHashSet.add("anon_inode:sync_file");
    AppMethodBeat.o(201129);
  }
  
  private a()
  {
    AppMethodBeat.i(201122);
    this.AWe = 1024;
    this.AWc = new HashMap();
    this.AWd = new HashMap();
    AppMethodBeat.o(201122);
  }
  
  private int a(a parama)
  {
    AppMethodBeat.i(201125);
    parama = (Integer)this.AWd.get(parama.name());
    if (parama == null)
    {
      AppMethodBeat.o(201125);
      return 0;
    }
    int i = parama.intValue();
    AppMethodBeat.o(201125);
    return i;
  }
  
  private static boolean aJZ(String paramString)
  {
    AppMethodBeat.i(201128);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(201128);
      return true;
    }
    Iterator localIterator = AWg.iterator();
    while (localIterator.hasNext()) {
      if (paramString.matches((String)localIterator.next()))
      {
        AppMethodBeat.o(201128);
        return true;
      }
    }
    AppMethodBeat.o(201128);
    return false;
  }
  
  public static a eCE()
  {
    return AVV;
  }
  
  private String eCF()
  {
    AppMethodBeat.i(201124);
    Object localObject2 = new ArrayList(this.AWd.entrySet());
    Collections.sort((List)localObject2, new Comparator() {});
    Object localObject1 = new StringBuilder();
    localObject2 = ((List)localObject2).iterator();
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (Map.Entry)((Iterator)localObject2).next();
      Log.e("MicroMsg.FDWatchDog", ">>>>>>>>>>>> FD SOS: type = %s, count = %s", new Object[] { ((Map.Entry)localObject3).getKey(), ((Map.Entry)localObject3).getValue() });
      localObject3 = (Map)this.AWc.get(((Map.Entry)localObject3).getKey());
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
    AppMethodBeat.o(201124);
    return localObject1;
  }
  
  private int eCG()
  {
    AppMethodBeat.i(201126);
    long l = System.currentTimeMillis();
    int i = 0;
    this.AWa = 0;
    Object localObject1 = new o(String.format("/proc/%s/fd", new Object[] { Integer.valueOf(Process.myPid()) }));
    if (!((o)localObject1).exists())
    {
      e.Cxv.idkeyStat(1031L, 255L, 1L, false);
      Log.e("MicroMsg.FDWatchDog", "file not exists: %s", new Object[] { aa.z(((o)localObject1).mUri) });
      AppMethodBeat.o(201126);
      return 0;
    }
    this.AWc.clear();
    this.AWd.clear();
    int j = i;
    for (;;)
    {
      int m;
      String str;
      int k;
      try
      {
        o[] arrayOfo = ((o)localObject1).het();
        if (arrayOfo == null)
        {
          j = i;
          Log.e("MicroMsg.FDWatchDog", "reading empty dir");
          return 0;
        }
        j = i;
        m = arrayOfo.length;
        if (m < 896)
        {
          j = m;
          Log.i("MicroMsg.FDWatchDog", "skip parsing fd: fd count = %s", new Object[] { Integer.valueOf(m) });
          return m;
        }
        j = m;
        int n = arrayOfo.length;
        i = 0;
        if (i >= n) {
          break label760;
        }
        j = m;
        localObject3 = aa.z(arrayOfo[i].her());
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
        str = FDDumpBridge.brC((String)localObject3);
        j = m;
        localObject1 = str;
        if (!TextUtils.isEmpty(str)) {
          break label774;
        }
        j = m;
        Log.e("MicroMsg.FDWatchDog", "file name is empty %s", new Object[] { localObject3 });
        j = m;
        e.Cxv.idkeyStat(1031L, 252L, 1L, false);
        localObject1 = localObject3;
        j = m;
        if (aJZ((String)localObject1))
        {
          j = m;
          Log.i("MicroMsg.FDWatchDog", "ignore %s", new Object[] { localObject1 });
          j = m;
          this.AWa += 1;
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
        localObject3 = (Map)this.AWc.get(str.name());
        if (localObject3 != null) {
          break label771;
        }
        j = m;
        localObject3 = new HashMap();
        j = m;
        this.AWc.put(str.name(), localObject3);
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
        e.Cxv.idkeyStat(1031L, 254L, 1L, false);
        Log.printErrStackTrace("MicroMsg.FDWatchDog", localException, "", new Object[0]);
        i = j - this.AWa;
        if (i > 0) {
          continue;
        }
        Log.e("MicroMsg.FDWatchDog", "fd dump error");
        e.Cxv.idkeyStat(1031L, 253L, 1L, false);
        Log.i("MicroMsg.FDWatchDog", "dump cost: %d, FDCount = %d, mIgnoredCount = %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(i), Integer.valueOf(this.AWa) });
        return i;
        j = m;
        ((Map)localObject3).put(localException, Integer.valueOf(localInteger.intValue() + 1));
        continue;
      }
      finally
      {
        AppMethodBeat.o(201126);
      }
      j = m;
      localObject1 = (Integer)this.AWd.get(str.name());
      if (localObject1 == null)
      {
        j = m;
        this.AWd.put(str.name(), Integer.valueOf(1));
      }
      else
      {
        j = m;
        this.AWd.put(str.name(), Integer.valueOf(localObject2.intValue() + 1));
        break label777;
        label753:
        k += 1;
        continue;
        label760:
        i = m - this.AWa;
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
  
  private void o(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(201127);
    e.Cxv.a(17899, new Object[] { Integer.valueOf(paramInt1), Long.valueOf(System.currentTimeMillis()), MMApplicationContext.getProcessName(), Integer.valueOf(a(a.AWi)), Integer.valueOf(a(a.AWj)), Integer.valueOf(a(a.AWm)), Integer.valueOf(a(a.AWo)), Integer.valueOf(a(a.AWp)), Integer.valueOf(a(a.AWq)), Integer.valueOf(a(a.AWr)), Integer.valueOf(a(a.AWs)), Integer.valueOf(a(a.AWt)), Integer.valueOf(a(a.AWu)), Integer.valueOf(a(a.AWv)), Integer.valueOf(a(a.AWw)), Integer.valueOf(a(a.AWx)), Integer.valueOf(a(a.AWy)), Integer.valueOf(a(a.AWz)), Integer.valueOf(a(a.AWA)), Integer.valueOf(a(a.AWB)), Integer.valueOf(a(a.AWC)), Integer.valueOf(a(a.AWE)), paramString, Integer.valueOf(this.AWa), Integer.valueOf(a(a.AWk)), Integer.valueOf(a(a.AWn)), Integer.valueOf(a(a.AWl)), Integer.valueOf(paramInt2), Integer.valueOf(this.AWe), Integer.valueOf(a(a.AWD)) });
    AppMethodBeat.o(201127);
  }
  
  public final void run()
  {
    AppMethodBeat.i(201123);
    int i;
    if (MMApplicationContext.isMainProcess()) {
      i = 100;
    }
    for (;;)
    {
      int j = eCG();
      if ((j <= 256) && (j - this.AWb > 32))
      {
        e.Cxv.idkeyStat(1031L, i - 2, 1L, false);
        this.AWb = Math.max(j, this.AWb);
      }
      for (;;)
      {
        if ((j > this.AWe * 0.9D) && (!this.AWf))
        {
          Log.e("MicroMsg.FDWatchDog", ">>>>>>>>>>>> FD SOS: total count = %d", new Object[] { Integer.valueOf(j) });
          this.AWf = true;
          e.Cxv.idkeyStat(1031L, i + 4, 1L, false);
          o(j, eCF(), 1);
        }
        h.RTc.o(this, 1800000L);
        AppMethodBeat.o(201123);
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
        if ((256 < j) && (j <= 512) && (!this.AVW))
        {
          e.Cxv.idkeyStat(1031L, i - 1, 1L, false);
          this.AVW = true;
        }
        else if ((512 < j) && (j <= 768) && (!this.AVX))
        {
          e.Cxv.idkeyStat(1031L, i, 1L, false);
          this.AVX = true;
        }
        else if ((768 < j) && (j <= 896) && (!this.AVY))
        {
          e.Cxv.idkeyStat(1031L, i + 1, 1L, false);
          this.AVY = true;
        }
        else if ((j > 896) && (!this.AVZ))
        {
          e.Cxv.idkeyStat(1031L, i + 2, 1L, false);
          Log.e("MicroMsg.FDWatchDog", ">>>>>>>>>>>> FD SOS: total count = %d", new Object[] { Integer.valueOf(j) });
          o(j, eCF(), 0);
          this.AVZ = true;
        }
      }
      label396:
      i = 0;
    }
  }
  
  @SuppressLint({"SdCardPath"})
  static enum a
  {
    private final String AWF;
    
    static
    {
      AppMethodBeat.i(201121);
      AWi = new a("FD_TYPE_ANNON_INODE_EVENT", 0, "anon_inode:\\[event.*\\]");
      AWj = new a("FD_TYPE_ANNON_INODE_DMABUF", 1, ".*dmabuf.*");
      AWk = new a("FD_TYPE_ANNON_INODE_GRALLOC", 2, "anon_inode:gralloc.*");
      AWl = new a("FD_TYPE_ANNON_INODE_MALITL", 3, "anon_inode:malitl.*");
      AWm = new a("FD_TYPE_SOCKET", 4, ".*socket:.*");
      AWn = new a("FD_TYPE_PIPE", 5, ".*pipe:[0-9]*");
      AWo = new a("FD_TYPE_PATH_DATA_MM_FILES_MMKV", 6, "/data/.*/" + MMApplicationContext.getApplicationId() + "/files/mmkv/.*");
      AWp = new a("FD_TYPE_PATH_DATA_MM_FILES_KVCOMM", 7, "/data/.*/" + MMApplicationContext.getApplicationId() + "/files/kvcomm/.*");
      AWq = new a("FD_TYPE_PATH_DATA_MM_FILES_XLOG", 8, "/data/.*/" + MMApplicationContext.getApplicationId() + "/files/xlog/.*");
      AWr = new a("FD_TYPE_PATH_DATA_MM_FILES_OTHERS", 9, "/data/.*/" + MMApplicationContext.getApplicationId() + "/files/.*");
      AWs = new a("FD_TYPE_PATH_DATA_MM_MICRO_MSG", 10, "/data/.*/" + MMApplicationContext.getApplicationId() + "/MicroMsg/.*");
      AWt = new a("FD_TYPE_PATH_DATA_MM_OTHERS", 11, "/data/.*/" + MMApplicationContext.getApplicationId() + "/.*");
      AWu = new a("FD_TYPE_PATH_EXT_AC_VOICE", 12, ".*/MicroMsg/[0-9a-eA-E]+/voice2/.*");
      AWv = new a("FD_TYPE_PATH_EXT_AC_VIDEO", 13, ".*/MicroMsg/[0-9a-eA-E]+/video/.*");
      AWw = new a("FD_TYPE_PATH_EXT_AC_ATTACHMENT", 14, ".*/MicroMsg/[0-9a-eA-E]+/attachment/.*");
      AWx = new a("FD_TYPE_PATH_EXT_AC_IMAGE", 15, ".*/MicroMsg/[0-9a-eA-E]+/image[2]?/.*");
      AWy = new a("FD_TYPE_PATH_EXT_AC_OTHERS", 16, ".*/MicroMsg/[0-9a-eA-E]+/.*");
      AWz = new a("FD_TYPE_PATH_EXT_OTHERS", 17, ".*/MicroMsg/.*");
      AWA = new a("FD_TYPE_PATH_SYSTEM_FRAMEWORK", 18, "/system/framework/.*");
      AWB = new a("FD_TYPE_PATH_DEV_ASHMEM", 19, "/dev/ashmem");
      AWC = new a("FD_TYPE_PATH_DEV_OTHERS", 20, "/dev/.*");
      AWD = new a("FD_TYPE_RAW_PATH", 21, "/proc/[0-9]*/fd/[0-9]*");
      AWE = new a("FD_TYPE_OTHERS", 22, ".*");
      AWG = new a[] { AWi, AWj, AWk, AWl, AWm, AWn, AWo, AWp, AWq, AWr, AWs, AWt, AWu, AWv, AWw, AWx, AWy, AWz, AWA, AWB, AWC, AWD, AWE };
      AppMethodBeat.o(201121);
    }
    
    private a(String paramString)
    {
      this.AWF = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.watchdogs.a
 * JD-Core Version:    0.7.0.1
 */