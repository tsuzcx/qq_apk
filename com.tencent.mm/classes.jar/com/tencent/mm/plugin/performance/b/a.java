package com.tencent.mm.plugin.performance.b;

import android.annotation.SuppressLint;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.performance.jni.fd.FDDumpBridge;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.vfs.q;
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
  private static final a vBL;
  private static final Set<String> vBS;
  private boolean vBM;
  private boolean vBN;
  private boolean vBO;
  private int vBP;
  private Map<String, Map<String, Integer>> vBQ;
  private Map<String, Integer> vBR;
  
  static
  {
    AppMethodBeat.i(206487);
    vBL = new a();
    HashSet localHashSet = new HashSet();
    vBS = localHashSet;
    localHashSet.add("anon_inode:sync_file");
    AppMethodBeat.o(206487);
  }
  
  private a()
  {
    AppMethodBeat.i(206483);
    this.vBQ = new HashMap();
    this.vBR = new HashMap();
    AppMethodBeat.o(206483);
  }
  
  private int a(a parama)
  {
    AppMethodBeat.i(206485);
    parama = (Integer)this.vBR.get(parama.name());
    if (parama == null)
    {
      AppMethodBeat.o(206485);
      return 0;
    }
    int i = parama.intValue();
    AppMethodBeat.o(206485);
    return i;
  }
  
  public static a dou()
  {
    return vBL;
  }
  
  private int dov()
  {
    AppMethodBeat.i(206486);
    long l = System.currentTimeMillis();
    this.vBP = 0;
    Object localObject = new com.tencent.mm.vfs.e(String.format("/proc/%s/fd", new Object[] { Integer.valueOf(Process.myPid()) }));
    if (!((com.tencent.mm.vfs.e)localObject).exists())
    {
      AppMethodBeat.o(206486);
      return 0;
    }
    this.vBQ.clear();
    this.vBR.clear();
    try
    {
      arrayOfe = ((com.tencent.mm.vfs.e)localObject).fxX();
      i1 = arrayOfe.length;
      m = 0;
      i = 0;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        com.tencent.mm.vfs.e[] arrayOfe;
        int i1;
        int m;
        int k;
        int j = 0;
        continue;
        continue;
        int i = k;
        m += 1;
        continue;
        j = 0;
      }
    }
    j = i;
    if (m < i1) {
      j = i;
    }
    for (;;)
    {
      int n;
      a locala;
      try
      {
        String str = FDDumpBridge.getFdPathName(q.B(arrayOfe[m].fxV()));
        k = i;
        if (str == null) {
          break label549;
        }
        j = i;
        k = i;
        if (str.isEmpty()) {
          break label549;
        }
        j = i;
        if (TextUtils.isEmpty(str))
        {
          j = 1;
          if (j != 0)
          {
            j = i;
            this.vBP += 1;
            break label551;
          }
        }
        else
        {
          j = i;
          localObject = vBS.iterator();
          j = i;
          if (!((Iterator)localObject).hasNext()) {
            break label560;
          }
          j = i;
          if (!str.matches((String)((Iterator)localObject).next())) {
            continue;
          }
          j = 1;
          continue;
        }
        i += 1;
        j = i;
        localObject = a.values();
        j = i;
        int i2 = localObject.length;
        n = 0;
        k = i;
        if (n >= i2) {
          break label549;
        }
        locala = localObject[n];
        j = i;
        if (!str.matches(a.b(locala))) {
          break label530;
        }
        j = i;
        localObject = (Map)this.vBQ.get(locala.name());
        if (localObject != null) {
          break;
        }
        j = i;
        localObject = new HashMap();
        j = i;
        this.vBQ.put(locala.name(), localObject);
        j = i;
        Integer localInteger = (Integer)((Map)localObject).get(str);
        if (localInteger == null)
        {
          j = i;
          ((Map)localObject).put(str, Integer.valueOf(1));
          j = i;
          localObject = (Integer)this.vBR.get(locala.name());
          if (localObject != null) {
            break label500;
          }
          j = i;
          this.vBR.put(locala.name(), Integer.valueOf(1));
          break label551;
        }
        j = i;
        ((Map)localObject).put(str, Integer.valueOf(localInteger.intValue() + 1));
        continue;
        ac.printErrStackTrace("MicroMsg.FDWatchDog", localException1, "", new Object[0]);
      }
      catch (Exception localException1) {}
      ac.i("MicroMsg.FDWatchDog", "dump cost: %d, FDCount = %d, mIgnoredCount = %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(j), Integer.valueOf(this.vBP) });
      AppMethodBeat.o(206486);
      return j;
      label500:
      j = i;
      this.vBR.put(locala.name(), Integer.valueOf(localException1.intValue() + 1));
      break label551;
      label530:
      n += 1;
    }
  }
  
  public final void run()
  {
    AppMethodBeat.i(206484);
    int i;
    if (ai.cin()) {
      i = 100;
    }
    for (;;)
    {
      int k = dov();
      if ((512 < k) && (k < 768) && (!this.vBM))
      {
        com.tencent.mm.plugin.report.e.wTc.idkeyStat(1031L, i, 1L, false);
        this.vBM = true;
      }
      for (;;)
      {
        h.JZN.q(this, 1800000L);
        AppMethodBeat.o(206484);
        return;
        if ((ai.eVd()) || (ai.eVe()))
        {
          i = 120;
          break;
        }
        if (!ai.isAppBrandProcess()) {
          break label832;
        }
        i = 140;
        break;
        if ((768 < k) && (k < 896) && (!this.vBN))
        {
          com.tencent.mm.plugin.report.e.wTc.idkeyStat(1031L, i + 1, 1L, false);
          this.vBN = true;
        }
        else if ((k > 896) && (!this.vBO))
        {
          com.tencent.mm.plugin.report.e.wTc.idkeyStat(1031L, i + 2, 1L, false);
          ac.e("MicroMsg.FDWatchDog", ">>>>>>>>>>>> FD SOS: total count = %d", new Object[] { Integer.valueOf(k) });
          Object localObject2 = new ArrayList(this.vBR.entrySet());
          Collections.sort((List)localObject2, new Comparator() {});
          Object localObject1 = new StringBuilder();
          localObject2 = ((List)localObject2).iterator();
          i = 0;
          while (((Iterator)localObject2).hasNext())
          {
            Object localObject3 = (Map.Entry)((Iterator)localObject2).next();
            ac.e("MicroMsg.FDWatchDog", ">>>>>>>>>>>> FD SOS: type = %s, count = %s", new Object[] { ((Map.Entry)localObject3).getKey(), ((Map.Entry)localObject3).getValue() });
            localObject3 = (Map)this.vBQ.get(((Map.Entry)localObject3).getKey());
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
                ac.e("MicroMsg.FDWatchDog", "-> [%s] %s", new Object[] { localEntry.getValue(), localEntry.getKey() });
                if (j < 20) {
                  ((StringBuilder)localObject1).append("[").append(localEntry.getValue()).append("]").append((String)localEntry.getKey()).append(";");
                }
                j += 1;
              }
            }
          }
          localObject1 = ((StringBuilder)localObject1).toString();
          ac.e("MicroMsg.FDWatchDog", "top path is %s", new Object[] { localObject1 });
          com.tencent.mm.plugin.report.e.wTc.f(17899, new Object[] { Integer.valueOf(k), Long.valueOf(System.currentTimeMillis()), ai.getProcessName(), Integer.valueOf(a(a.vBU)), Integer.valueOf(a(a.vBV)), Integer.valueOf(a(a.vBW)), Integer.valueOf(a(a.vBX)), Integer.valueOf(a(a.vBY)), Integer.valueOf(a(a.vBZ)), Integer.valueOf(a(a.vCa)), Integer.valueOf(a(a.vCb)), Integer.valueOf(a(a.vCc)), Integer.valueOf(a(a.vCd)), Integer.valueOf(a(a.vCe)), Integer.valueOf(a(a.vCf)), Integer.valueOf(a(a.vCg)), Integer.valueOf(a(a.vCh)), Integer.valueOf(a(a.vCi)), Integer.valueOf(a(a.vCj)), Integer.valueOf(a(a.vCk)), Integer.valueOf(a(a.vCl)), Integer.valueOf(a(a.vCm)), localObject1, Integer.valueOf(this.vBP) });
          this.vBO = true;
        }
      }
      label832:
      i = 0;
    }
  }
  
  @SuppressLint({"SdCardPath"})
  static enum a
  {
    private final String vCn;
    
    static
    {
      AppMethodBeat.i(206482);
      vBU = new a("FD_TYPE_ANNON_INODE_EVENT", 0, "anon_inode:\\[event.*\\]");
      vBV = new a("FD_TYPE_ANNON_INODE_DMABUF", 1, "anon_inode:dmabuf");
      vBW = new a("FD_TYPE_SOCKET", 2, "socket:.*");
      vBX = new a("FD_TYPE_PATH_DATA_MM_FILES_MMKV", 3, "/data/data/com.tencent.mm/files/mmkv/.*");
      vBY = new a("FD_TYPE_PATH_DATA_MM_FILES_KVCOMM", 4, "/data/data/com.tencent.mm/files/kvcomm/.*");
      vBZ = new a("FD_TYPE_PATH_DATA_MM_FILES_XLOG", 5, "/data/data/com.tencent.mm/files/xlog/.*");
      vCa = new a("FD_TYPE_PATH_DATA_MM_FILES_OTHERS", 6, "/data/data/com.tencent.mm/files/.*");
      vCb = new a("FD_TYPE_PATH_DATA_MM_MICRO_MSG", 7, "/data/data/com.tencent.mm/MicroMsg/.*");
      vCc = new a("FD_TYPE_PATH_DATA_MM_OTHERS", 8, "/data/data/com.tencent.mm/.*");
      vCd = new a("FD_TYPE_PATH_EXT_AC_VOICE", 9, ".*/tencent/MicroMsg/[0-9a-eA-E]+/voice2/.*");
      vCe = new a("FD_TYPE_PATH_EXT_AC_VIDEO", 10, ".*/tencent/MicroMsg/[0-9a-eA-E]+/video/.*");
      vCf = new a("FD_TYPE_PATH_EXT_AC_ATTACHMENT", 11, ".*/tencent/MicroMsg/[0-9a-eA-E]+/attachment/.*");
      vCg = new a("FD_TYPE_PATH_EXT_AC_IMAGE", 12, ".*/tencent/MicroMsg/[0-9a-eA-E]+/image[2]?/.*");
      vCh = new a("FD_TYPE_PATH_EXT_AC_OTHERS", 13, ".*/tencent/MicroMsg/[0-9a-eA-E]+/.*");
      vCi = new a("FD_TYPE_PATH_EXT_OTHERS", 14, ".*/tencent/MicroMsg/.*");
      vCj = new a("FD_TYPE_PATH_SYSTEM_FRAMEWORK", 15, "/system/framework/.*");
      vCk = new a("FD_TYPE_PATH_DEV_ASHMEM", 16, "/dev/ashmem");
      vCl = new a("FD_TYPE_PATH_DEV_OTHERS", 17, "/dev/.*");
      vCm = new a("FD_TYPE_OTHERS", 18, ".*");
      vCo = new a[] { vBU, vBV, vBW, vBX, vBY, vBZ, vCa, vCb, vCc, vCd, vCe, vCf, vCg, vCh, vCi, vCj, vCk, vCl, vCm };
      AppMethodBeat.o(206482);
    }
    
    private a(String paramString)
    {
      this.vCn = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.b.a
 * JD-Core Version:    0.7.0.1
 */