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

public final class n
{
  private static final int[] agyG;
  private static final int[] agyH;
  private static final int[] agyI;
  private static final int[] agyJ;
  private static final int[] agyK;
  private static final int[] agyL;
  private static final int[] agyM;
  private static final int[] agyN;
  private static final int[] agyO;
  private static final int[] agyP;
  private static final Map<String, Integer> agyQ;
  
  static
  {
    AppMethodBeat.i(238304);
    agyG = new int[] { 10, 20 };
    agyH = new int[] { 11, 21 };
    agyI = new int[] { 12, 22 };
    agyJ = new int[] { 13, 23 };
    agyK = new int[] { 14, 24 };
    agyL = new int[] { 15, 25 };
    agyM = new int[] { 16, 26 };
    agyN = new int[] { 17, 27 };
    agyO = new int[] { 18, 28 };
    agyP = new int[] { 19, 29 };
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
    agyQ = Collections.unmodifiableMap(localLinkedHashMap);
    AppMethodBeat.o(238304);
  }
  
  private static boolean a(f paramf)
  {
    AppMethodBeat.i(238287);
    paramf = paramf.jKf();
    paramf = paramf.subList(1, paramf.size()).iterator();
    while (paramf.hasNext())
    {
      Iterable localIterable = ((FileSystem.b)paramf.next()).bDW("");
      if ((localIterable != null) && (localIterable.iterator().hasNext()))
      {
        AppMethodBeat.o(238287);
        return false;
      }
    }
    AppMethodBeat.o(238287);
    return true;
  }
  
  private static boolean b(f paramf)
  {
    AppMethodBeat.i(238296);
    paramf = paramf.jKf();
    if (paramf == null)
    {
      AppMethodBeat.o(238296);
      return true;
    }
    paramf = paramf.iterator();
    while (paramf.hasNext())
    {
      FileSystem.b localb = (FileSystem.b)paramf.next();
      if ((localb != null) && ((localb.jKa() instanceof MigrationFileSystem)) && ((localb instanceof f)) && (!a((f)localb)))
      {
        AppMethodBeat.o(238296);
        return false;
      }
    }
    AppMethodBeat.o(238296);
    return true;
  }
  
  public static void run()
  {
    AppMethodBeat.i(238281);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("VFSStatistic");
    long l1 = localMultiProcessMMKV.getLong("VFSReportTime", 0L);
    long l2 = System.currentTimeMillis();
    if (l2 - l1 < 86400000L)
    {
      AppMethodBeat.o(238281);
      return;
    }
    g.jKo();
    localMultiProcessMMKV.encode("VFSReportTime", l2);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new IDKey(1387, 0, 1));
    localArrayList.add(new IDKey(1387, 2, 1));
    localArrayList.add(new IDKey(1387, 3, 1));
    localArrayList.add(new IDKey(1387, 4, 1));
    if (com.tencent.mm.sdcard_migrate.b.bui(com.tencent.mm.loader.i.b.bmy())) {
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
      i = agyG[1];
      Log.i("MicroMsg.PostTaskVFSStat", "VFS_ASYNC_KEY_FINISH is %s", new Object[] { Integer.valueOf(i) });
      if (!bool4) {
        break label560;
      }
      i = 150;
      Log.i("MicroMsg.PostTaskVFSStat", "VFS_ASYNC_KEY_FINISH_3 is %s", new Object[] { Integer.valueOf(i) });
      if (!bool1) {
        break label567;
      }
      i = agyG[1];
      localArrayList.add(new IDKey(1387, i, 1));
      if (!bool4) {
        break label576;
      }
      i = 150;
      localArrayList.add(new IDKey(1387, i, 1));
      localObject1 = k.kMs();
      Iterator localIterator = ((k)localObject1).jKz().entrySet().iterator();
      i = 0;
      bool1 = true;
      if (!localIterator.hasNext()) {
        break label636;
      }
      localObject2 = (Map.Entry)localIterator.next();
      str = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (FileSystem)((Map.Entry)localObject2).getValue();
      localb = ((k)localObject1).kMw().bEh(str);
      bool2 = bool1;
      if (!agyQ.containsKey(str)) {
        break label1145;
      }
      if (!(localb instanceof f)) {
        break label596;
      }
      if (!(localObject2 instanceof MigrationFileSystem)) {
        break label583;
      }
      bool3 = a((f)localb);
      if ((!bool1) || (!bool3)) {
        break label621;
      }
      bool1 = true;
      bool2 = bool1;
      if (bool4) {
        break label1145;
      }
      j = ((Integer)agyQ.get(str)).intValue();
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
      i = agyG[0];
      break;
      label560:
      i = 149;
      break label223;
      label567:
      i = agyG[0];
      break label252;
      label576:
      i = 149;
      break label279;
      label583:
      bool3 = b((f)localb);
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
        localObject1 = k.kMs().kMw().bEh("image");
        if (!(localObject1 instanceof f)) {
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
        i = agyH[1];
      }
      for (;;)
      {
        label761:
        Log.i("MicroMsg.PostTaskVFSStat", "DaysKey %s", new Object[] { Integer.valueOf(i) });
        localArrayList.add(new IDKey(1387, i, 1));
        com.tencent.mm.plugin.report.f.Ozc.b(localArrayList, false);
        if (bool4) {
          break label1139;
        }
        if (!bool1) {
          break label1129;
        }
        localMultiProcessMMKV.encode("VFSAsyncFinished", true);
        localMultiProcessMMKV.encode("VFSAsyncFinished3", true);
        localMultiProcessMMKV.encode("VFSAsyncFinish", j);
        AppMethodBeat.o(238281);
        return;
        ah.a((FileSystem.b)localObject1, new ah.d()
        {
          public final boolean a(FileSystem.b paramAnonymousb)
          {
            AppMethodBeat.i(238200);
            if (!(paramAnonymousb instanceof f))
            {
              Log.i("MicroMsg.PostTaskVFSStat", "List image directory of %s:", new Object[] { paramAnonymousb });
              paramAnonymousb = paramAnonymousb.bDW("");
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
                  j localj = (j)paramAnonymousb.next();
                  j = i + 1;
                  if (localj != null) {
                    Log.i("MicroMsg.PostTaskVFSStat", "--> %s", new Object[] { localj.acpB });
                  }
                  i = j;
                } while (j <= 50);
              }
            }
            AppMethodBeat.o(238200);
            return false;
          }
        });
        break;
        label882:
        j = localMultiProcessMMKV.getInt("VFSAsyncStart", 0) + 1;
        break label761;
        label897:
        i = agyH[0];
        continue;
        label906:
        if (j <= 2)
        {
          if (bool4) {
            i = agyI[1];
          } else {
            i = agyI[0];
          }
        }
        else if (j <= 3)
        {
          if (bool4) {
            i = agyJ[1];
          } else {
            i = agyJ[0];
          }
        }
        else if (j <= 5)
        {
          if (bool4) {
            i = agyK[1];
          } else {
            i = agyK[0];
          }
        }
        else if (j <= 10)
        {
          if (bool4) {
            i = agyL[1];
          } else {
            i = agyL[0];
          }
        }
        else if (j <= 15)
        {
          if (bool4) {
            i = agyM[1];
          } else {
            i = agyM[0];
          }
        }
        else if (j <= 20)
        {
          if (bool4) {
            i = agyN[1];
          } else {
            i = agyN[0];
          }
        }
        else if (j <= 30)
        {
          if (bool4) {
            i = agyO[1];
          } else {
            i = agyO[0];
          }
        }
        else if (bool4) {
          i = agyP[1];
        } else {
          i = agyP[0];
        }
      }
      label1129:
      localMultiProcessMMKV.encode("VFSAsyncStart", j);
      label1139:
      AppMethodBeat.o(238281);
      return;
      label1145:
      bool1 = bool2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.n
 * JD-Core Version:    0.7.0.1
 */