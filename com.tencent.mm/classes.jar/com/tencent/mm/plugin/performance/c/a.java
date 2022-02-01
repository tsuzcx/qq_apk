package com.tencent.mm.plugin.performance.c;

import android.annotation.SuppressLint;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.performance.jni.fd.FDDumpBridge;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
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
  private static final a utU;
  private static final Set<String> uub;
  private boolean utV;
  private boolean utW;
  private boolean utX;
  private int utY;
  private Map<String, Map<String, Integer>> utZ;
  private Map<String, Integer> uua;
  
  static
  {
    AppMethodBeat.i(193452);
    utU = new a();
    HashSet localHashSet = new HashSet();
    uub = localHashSet;
    localHashSet.add("anon_inode:sync_file");
    AppMethodBeat.o(193452);
  }
  
  private a()
  {
    AppMethodBeat.i(193448);
    this.utZ = new HashMap();
    this.uua = new HashMap();
    AppMethodBeat.o(193448);
  }
  
  private int a(a parama)
  {
    AppMethodBeat.i(193450);
    parama = (Integer)this.uua.get(parama.name());
    if (parama == null)
    {
      AppMethodBeat.o(193450);
      return 0;
    }
    int i = parama.intValue();
    AppMethodBeat.o(193450);
    return i;
  }
  
  public static a daT()
  {
    return utU;
  }
  
  private int daU()
  {
    AppMethodBeat.i(193451);
    long l = System.currentTimeMillis();
    this.utY = 0;
    Object localObject = new com.tencent.mm.vfs.e(String.format("/proc/%s/fd", new Object[] { Integer.valueOf(Process.myPid()) }));
    if (!((com.tencent.mm.vfs.e)localObject).exists())
    {
      AppMethodBeat.o(193451);
      return 0;
    }
    this.utZ.clear();
    this.uua.clear();
    try
    {
      arrayOfe = ((com.tencent.mm.vfs.e)localObject).fhW();
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
        String str = FDDumpBridge.Bn(q.B(arrayOfe[m].fhU()));
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
            this.utY += 1;
            break label551;
          }
        }
        else
        {
          j = i;
          localObject = uub.iterator();
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
        localObject = (Map)this.utZ.get(locala.name());
        if (localObject != null) {
          break;
        }
        j = i;
        localObject = new HashMap();
        j = i;
        this.utZ.put(locala.name(), localObject);
        j = i;
        Integer localInteger = (Integer)((Map)localObject).get(str);
        if (localInteger == null)
        {
          j = i;
          ((Map)localObject).put(str, Integer.valueOf(1));
          j = i;
          localObject = (Integer)this.uua.get(locala.name());
          if (localObject != null) {
            break label500;
          }
          j = i;
          this.uua.put(locala.name(), Integer.valueOf(1));
          break label551;
        }
        j = i;
        ((Map)localObject).put(str, Integer.valueOf(localInteger.intValue() + 1));
        continue;
        ad.printErrStackTrace("MicroMsg.FDWatchDog", localException1, "", new Object[0]);
      }
      catch (Exception localException1) {}
      ad.i("MicroMsg.FDWatchDog", "dump cost: %d, FDCount = %d, mIgnoredCount = %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(j), Integer.valueOf(this.utY) });
      AppMethodBeat.o(193451);
      return j;
      label500:
      j = i;
      this.uua.put(locala.name(), Integer.valueOf(localException1.intValue() + 1));
      break label551;
      label530:
      n += 1;
    }
  }
  
  public final void run()
  {
    AppMethodBeat.i(193449);
    int i;
    if (aj.cbe()) {
      i = 100;
    }
    for (;;)
    {
      int k = daU();
      if ((512 < k) && (k < 768) && (!this.utV))
      {
        com.tencent.mm.plugin.report.e.vIY.idkeyStat(1031L, i, 1L, false);
        this.utV = true;
      }
      for (;;)
      {
        h.Iye.q(this, 1800000L);
        AppMethodBeat.o(193449);
        return;
        if ((aj.eFJ()) || (aj.eFK()))
        {
          i = 120;
          break;
        }
        if (aj.isAppBrandProcess())
        {
          i = 140;
          break;
        }
        if (!aj.eFH()) {
          break label845;
        }
        i = 150;
        break;
        if ((768 < k) && (k < 896) && (!this.utW))
        {
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(1031L, i + 1, 1L, false);
          this.utW = true;
        }
        else if ((k > 896) && (!this.utX))
        {
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(1031L, i + 2, 1L, false);
          ad.e("MicroMsg.FDWatchDog", ">>>>>>>>>>>> FD SOS: total count = %d", new Object[] { Integer.valueOf(k) });
          Object localObject2 = new ArrayList(this.uua.entrySet());
          Collections.sort((List)localObject2, new Comparator() {});
          Object localObject1 = new StringBuilder();
          localObject2 = ((List)localObject2).iterator();
          i = 0;
          while (((Iterator)localObject2).hasNext())
          {
            Object localObject3 = (Map.Entry)((Iterator)localObject2).next();
            ad.e("MicroMsg.FDWatchDog", ">>>>>>>>>>>> FD SOS: type = %s, count = %s", new Object[] { ((Map.Entry)localObject3).getKey(), ((Map.Entry)localObject3).getValue() });
            localObject3 = (Map)this.utZ.get(((Map.Entry)localObject3).getKey());
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
                ad.e("MicroMsg.FDWatchDog", "-> [%s] %s", new Object[] { localEntry.getValue(), localEntry.getKey() });
                if (j < 20) {
                  ((StringBuilder)localObject1).append("[").append(localEntry.getValue()).append("]").append((String)localEntry.getKey()).append(";");
                }
                j += 1;
              }
            }
          }
          localObject1 = ((StringBuilder)localObject1).toString();
          ad.e("MicroMsg.FDWatchDog", "top path is %s", new Object[] { localObject1 });
          com.tencent.mm.plugin.report.e.vIY.f(17899, new Object[] { Integer.valueOf(k), Long.valueOf(System.currentTimeMillis()), aj.getProcessName(), Integer.valueOf(a(a.uud)), Integer.valueOf(a(a.uue)), Integer.valueOf(a(a.uuf)), Integer.valueOf(a(a.uug)), Integer.valueOf(a(a.uuh)), Integer.valueOf(a(a.uui)), Integer.valueOf(a(a.uuj)), Integer.valueOf(a(a.uuk)), Integer.valueOf(a(a.uul)), Integer.valueOf(a(a.uum)), Integer.valueOf(a(a.uun)), Integer.valueOf(a(a.uuo)), Integer.valueOf(a(a.uup)), Integer.valueOf(a(a.uuq)), Integer.valueOf(a(a.uur)), Integer.valueOf(a(a.uus)), Integer.valueOf(a(a.uut)), Integer.valueOf(a(a.uuu)), Integer.valueOf(a(a.uuv)), localObject1, Integer.valueOf(this.utY) });
          this.utX = true;
        }
      }
      label845:
      i = 0;
    }
  }
  
  @SuppressLint({"SdCardPath"})
  static enum a
  {
    private final String uuw;
    
    static
    {
      AppMethodBeat.i(193447);
      uud = new a("FD_TYPE_ANNON_INODE_EVENT", 0, "anon_inode:\\[event.*\\]");
      uue = new a("FD_TYPE_ANNON_INODE_DMABUF", 1, "anon_inode:dmabuf");
      uuf = new a("FD_TYPE_SOCKET", 2, "socket:.*");
      uug = new a("FD_TYPE_PATH_DATA_MM_FILES_MMKV", 3, "/data/data/com.tencent.mm/files/mmkv/.*");
      uuh = new a("FD_TYPE_PATH_DATA_MM_FILES_KVCOMM", 4, "/data/data/com.tencent.mm/files/kvcomm/.*");
      uui = new a("FD_TYPE_PATH_DATA_MM_FILES_XLOG", 5, "/data/data/com.tencent.mm/files/xlog/.*");
      uuj = new a("FD_TYPE_PATH_DATA_MM_FILES_OTHERS", 6, "/data/data/com.tencent.mm/files/.*");
      uuk = new a("FD_TYPE_PATH_DATA_MM_MICRO_MSG", 7, "/data/data/com.tencent.mm/MicroMsg/.*");
      uul = new a("FD_TYPE_PATH_DATA_MM_OTHERS", 8, "/data/data/com.tencent.mm/.*");
      uum = new a("FD_TYPE_PATH_EXT_AC_VOICE", 9, ".*/tencent/MicroMsg/[0-9a-eA-E]+/voice2/.*");
      uun = new a("FD_TYPE_PATH_EXT_AC_VIDEO", 10, ".*/tencent/MicroMsg/[0-9a-eA-E]+/video/.*");
      uuo = new a("FD_TYPE_PATH_EXT_AC_ATTACHMENT", 11, ".*/tencent/MicroMsg/[0-9a-eA-E]+/attachment/.*");
      uup = new a("FD_TYPE_PATH_EXT_AC_IMAGE", 12, ".*/tencent/MicroMsg/[0-9a-eA-E]+/image[2]?/.*");
      uuq = new a("FD_TYPE_PATH_EXT_AC_OTHERS", 13, ".*/tencent/MicroMsg/[0-9a-eA-E]+/.*");
      uur = new a("FD_TYPE_PATH_EXT_OTHERS", 14, ".*/tencent/MicroMsg/.*");
      uus = new a("FD_TYPE_PATH_SYSTEM_FRAMEWORK", 15, "/system/framework/.*");
      uut = new a("FD_TYPE_PATH_DEV_ASHMEM", 16, "/dev/ashmem");
      uuu = new a("FD_TYPE_PATH_DEV_OTHERS", 17, "/dev/.*");
      uuv = new a("FD_TYPE_OTHERS", 18, ".*");
      uux = new a[] { uud, uue, uuf, uug, uuh, uui, uuj, uuk, uul, uum, uun, uuo, uup, uuq, uur, uus, uut, uuu, uuv };
      AppMethodBeat.o(193447);
    }
    
    private a(String paramString)
    {
      this.uuw = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.c.a
 * JD-Core Version:    0.7.0.1
 */