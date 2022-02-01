package com.tencent.mm.vfs;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class j
{
  private static final int[] RcI;
  private static final int[] RcJ;
  private static final int[] RcK;
  private static final int[] RcL;
  private static final int[] RcM;
  private static final int[] RcN;
  private static final int[] RcO;
  private static final int[] RcP;
  private static final int[] RcQ;
  private static final int[] RcR;
  private static final Map<String, Integer> RcS;
  
  static
  {
    AppMethodBeat.i(197238);
    RcI = new int[] { 10, 20 };
    RcJ = new int[] { 11, 21 };
    RcK = new int[] { 12, 22 };
    RcL = new int[] { 13, 23 };
    RcM = new int[] { 14, 24 };
    RcN = new int[] { 15, 25 };
    RcO = new int[] { 16, 26 };
    RcP = new int[] { 17, 27 };
    RcQ = new int[] { 18, 28 };
    RcR = new int[] { 19, 29 };
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put("attachment", Integer.valueOf(1966120));
    localLinkedHashMap.put("Download", Integer.valueOf(2031657));
    localLinkedHashMap.put("voice", Integer.valueOf(2097194));
    localLinkedHashMap.put("voice2", Integer.valueOf(2162731));
    localLinkedHashMap.put("image", Integer.valueOf(2228268));
    localLinkedHashMap.put("oldimage2", Integer.valueOf(2293805));
    localLinkedHashMap.put("video", Integer.valueOf(2359342));
    localLinkedHashMap.put("oneday", Integer.valueOf(2424879));
    localLinkedHashMap.put("emoji", Integer.valueOf(2490416));
    localLinkedHashMap.put("finder", Integer.valueOf(2555953));
    localLinkedHashMap.put("CDNDownloadBigFile", Integer.valueOf(9896088));
    localLinkedHashMap.put("CheckResUpdate", Integer.valueOf(10092699));
    RcS = Collections.unmodifiableMap(localLinkedHashMap);
    AppMethodBeat.o(197238);
  }
  
  private static boolean a(c paramc)
  {
    AppMethodBeat.i(197236);
    paramc = paramc.hdS();
    paramc = paramc.subList(1, paramc.size()).iterator();
    while (paramc.hasNext())
    {
      Iterable localIterable = ((FileSystem.b)paramc.next()).dx("", false);
      if ((localIterable != null) && (localIterable.iterator().hasNext()))
      {
        AppMethodBeat.o(197236);
        return false;
      }
    }
    AppMethodBeat.o(197236);
    return true;
  }
  
  private static boolean b(c paramc)
  {
    AppMethodBeat.i(197237);
    paramc = paramc.hdS();
    if (paramc == null)
    {
      AppMethodBeat.o(197237);
      return true;
    }
    paramc = paramc.iterator();
    while (paramc.hasNext())
    {
      FileSystem.b localb = (FileSystem.b)paramc.next();
      if ((localb != null) && ((localb.hdQ() instanceof MigrationFileSystem)) && ((localb instanceof c)) && (!a((c)localb)))
      {
        AppMethodBeat.o(197237);
        return false;
      }
    }
    AppMethodBeat.o(197237);
    return true;
  }
  
  public static void run()
  {
    AppMethodBeat.i(197235);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("VFSStatistic");
    long l1 = localMultiProcessMMKV.getLong("VFSReportTime", 0L);
    long l2 = System.currentTimeMillis();
    if (l2 - l1 < 86400000L)
    {
      AppMethodBeat.o(197235);
      return;
    }
    d.hdU();
    localMultiProcessMMKV.encode("VFSReportTime", l2);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new IDKey(1387, 0, 1));
    localArrayList.add(new IDKey(1387, 2, 1));
    localArrayList.add(new IDKey(1387, 3, 1));
    localArrayList.add(new IDKey(1387, 4, 1));
    if (com.tencent.mm.sdcard_migrate.b.bhQ(com.tencent.mm.loader.j.b.aKI())) {
      localArrayList.add(new IDKey(1387, 100, 1));
    }
    boolean bool1 = localMultiProcessMMKV.getBoolean("VFSAsyncFinished", false);
    boolean bool4 = localMultiProcessMMKV.getBoolean("VFSAsyncFinished3", false);
    int i;
    label223:
    label252:
    Object localObject1;
    label279:
    label324:
    Object localObject2;
    String str;
    FileSystem.b localb;
    boolean bool2;
    boolean bool3;
    label427:
    label440:
    int j;
    if (bool1)
    {
      i = RcI[1];
      Log.i("MicroMsg.PostTaskVFSStat", "VFS_ASYNC_KEY_FINISH is %s", new Object[] { Integer.valueOf(i) });
      if (!bool4) {
        break label560;
      }
      i = 150;
      Log.i("MicroMsg.PostTaskVFSStat", "VFS_ASYNC_KEY_FINISH_3 is %s", new Object[] { Integer.valueOf(i) });
      if (!bool1) {
        break label567;
      }
      i = RcI[1];
      localArrayList.add(new IDKey(1387, i, 1));
      if (!bool4) {
        break label576;
      }
      i = 150;
      localArrayList.add(new IDKey(1387, i, 1));
      localObject1 = g.hRR();
      Iterator localIterator = ((g)localObject1).hec().entrySet().iterator();
      i = 0;
      bool1 = true;
      if (!localIterator.hasNext()) {
        break label636;
      }
      localObject2 = (Map.Entry)localIterator.next();
      str = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (FileSystem)((Map.Entry)localObject2).getValue();
      localb = ((g)localObject1).hRU().boT(str);
      bool2 = bool1;
      if (!RcS.containsKey(str)) {
        break label1145;
      }
      if (!(localb instanceof c)) {
        break label596;
      }
      if (!(localObject2 instanceof MigrationFileSystem)) {
        break label583;
      }
      bool3 = a((c)localb);
      if ((!bool1) || (!bool3)) {
        break label621;
      }
      bool1 = true;
      bool2 = bool1;
      if (bool4) {
        break label1145;
      }
      j = ((Integer)RcS.get(str)).intValue();
      if (!bool3) {
        break label627;
      }
      j = (j & 0xFFFF0000) >> 16;
      label480:
      localArrayList.add(new IDKey(1387, j, 1));
      Log.i("MicroMsg.PostTaskVFSStat", "FileSystem %s, isMigrationFinished is %s", new Object[] { str, Boolean.valueOf(bool3) });
      bool2 = bool1;
      if (!str.equals("image")) {
        break label1145;
      }
      bool2 = bool1;
      if (bool3) {
        break label1145;
      }
      i = 1;
    }
    for (;;)
    {
      break label324;
      i = RcI[0];
      break;
      label560:
      i = 149;
      break label223;
      label567:
      i = RcI[0];
      break label252;
      label576:
      i = 149;
      break label279;
      label583:
      bool3 = b((c)localb);
      break label427;
      label596:
      Log.e("MicroMsg.PostTaskVFSStat", "FileSystem %s type error %s", new Object[] { str, localObject2 });
      break label324;
      label621:
      bool1 = false;
      break label440;
      label627:
      j &= 0xFFFF;
      break label480;
      label636:
      if (i != 0)
      {
        localArrayList.add(new IDKey(1387, 90, 1));
        localObject1 = g.hRR().hRU().boT("image");
        if (!(localObject1 instanceof c)) {
          Log.i("MicroMsg.PostTaskVFSStat", "state is not DelegateFileSystemState");
        }
      }
      else
      {
        Log.i("MicroMsg.PostTaskVFSStat", "VFSP_REPORT_ASYNC_FINISHED is %s, isMigrationFinished is %s", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool1) });
        if ((bool4) && (!bool1)) {
          localArrayList.add(new IDKey(1387, 5, 1));
        }
        if (!bool4) {
          break label882;
        }
        j = localMultiProcessMMKV.getInt("VFSAsyncFinish", 0);
        if (j > 1) {
          break label906;
        }
        if (!bool4) {
          break label897;
        }
        i = RcJ[1];
      }
      for (;;)
      {
        label761:
        Log.i("MicroMsg.PostTaskVFSStat", "DaysKey %s", new Object[] { Integer.valueOf(i) });
        localArrayList.add(new IDKey(1387, i, 1));
        com.tencent.mm.plugin.report.e.Cxv.b(localArrayList, false);
        if (bool4) {
          break label1139;
        }
        if (!bool1) {
          break label1129;
        }
        localMultiProcessMMKV.encode("VFSAsyncFinished", true);
        localMultiProcessMMKV.encode("VFSAsyncFinished3", true);
        localMultiProcessMMKV.encode("VFSAsyncFinish", j);
        AppMethodBeat.o(197235);
        return;
        aa.a((FileSystem.b)localObject1, new aa.b()
        {
          public final boolean a(FileSystem.b paramAnonymousb)
          {
            AppMethodBeat.i(197234);
            if (!(paramAnonymousb instanceof c))
            {
              Log.i("MicroMsg.PostTaskVFSStat", "List image directory of %s:", new Object[] { paramAnonymousb });
              paramAnonymousb = paramAnonymousb.dx("", false);
              if (paramAnonymousb != null)
              {
                paramAnonymousb = paramAnonymousb.iterator();
                int i = 0;
                int j;
                do
                {
                  if (!paramAnonymousb.hasNext()) {
                    break;
                  }
                  e locale = (e)paramAnonymousb.next();
                  j = i + 1;
                  if (locale != null) {
                    Log.i("MicroMsg.PostTaskVFSStat", "--> %s", new Object[] { locale.NGP });
                  }
                  i = j;
                } while (j <= 50);
              }
            }
            AppMethodBeat.o(197234);
            return false;
          }
        });
        break;
        label882:
        j = localMultiProcessMMKV.getInt("VFSAsyncStart", 0) + 1;
        break label761;
        label897:
        i = RcJ[0];
        continue;
        label906:
        if (j <= 2)
        {
          if (bool4) {
            i = RcK[1];
          } else {
            i = RcK[0];
          }
        }
        else if (j <= 3)
        {
          if (bool4) {
            i = RcL[1];
          } else {
            i = RcL[0];
          }
        }
        else if (j <= 5)
        {
          if (bool4) {
            i = RcM[1];
          } else {
            i = RcM[0];
          }
        }
        else if (j <= 10)
        {
          if (bool4) {
            i = RcN[1];
          } else {
            i = RcN[0];
          }
        }
        else if (j <= 15)
        {
          if (bool4) {
            i = RcO[1];
          } else {
            i = RcO[0];
          }
        }
        else if (j <= 20)
        {
          if (bool4) {
            i = RcP[1];
          } else {
            i = RcP[0];
          }
        }
        else if (j <= 30)
        {
          if (bool4) {
            i = RcQ[1];
          } else {
            i = RcQ[0];
          }
        }
        else if (bool4) {
          i = RcR[1];
        } else {
          i = RcR[0];
        }
      }
      label1129:
      localMultiProcessMMKV.encode("VFSAsyncStart", j);
      label1139:
      AppMethodBeat.o(197235);
      return;
      label1145:
      bool1 = bool2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.vfs.j
 * JD-Core Version:    0.7.0.1
 */