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

public final class k
{
  private static final int[] YDl;
  private static final int[] YDm;
  private static final int[] YDn;
  private static final int[] YDo;
  private static final int[] YDp;
  private static final int[] YDq;
  private static final int[] YDr;
  private static final int[] YDs;
  private static final int[] YDt;
  private static final int[] YDu;
  private static final Map<String, Integer> YDv;
  
  static
  {
    AppMethodBeat.i(204092);
    YDl = new int[] { 10, 20 };
    YDm = new int[] { 11, 21 };
    YDn = new int[] { 12, 22 };
    YDo = new int[] { 13, 23 };
    YDp = new int[] { 14, 24 };
    YDq = new int[] { 15, 25 };
    YDr = new int[] { 16, 26 };
    YDs = new int[] { 17, 27 };
    YDt = new int[] { 18, 28 };
    YDu = new int[] { 19, 29 };
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
    YDv = Collections.unmodifiableMap(localLinkedHashMap);
    AppMethodBeat.o(204092);
  }
  
  private static boolean a(d paramd)
  {
    AppMethodBeat.i(204089);
    paramd = paramd.ifa();
    paramd = paramd.subList(1, paramd.size()).iterator();
    while (paramd.hasNext())
    {
      Iterable localIterable = ((FileSystem.b)paramd.next()).dJ("", false);
      if ((localIterable != null) && (localIterable.iterator().hasNext()))
      {
        AppMethodBeat.o(204089);
        return false;
      }
    }
    AppMethodBeat.o(204089);
    return true;
  }
  
  private static boolean b(d paramd)
  {
    AppMethodBeat.i(204090);
    paramd = paramd.ifa();
    if (paramd == null)
    {
      AppMethodBeat.o(204090);
      return true;
    }
    paramd = paramd.iterator();
    while (paramd.hasNext())
    {
      FileSystem.b localb = (FileSystem.b)paramd.next();
      if ((localb != null) && ((localb.ieX() instanceof MigrationFileSystem)) && ((localb instanceof d)) && (!a((d)localb)))
      {
        AppMethodBeat.o(204090);
        return false;
      }
    }
    AppMethodBeat.o(204090);
    return true;
  }
  
  public static void run()
  {
    AppMethodBeat.i(204087);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("VFSStatistic");
    long l1 = localMultiProcessMMKV.getLong("VFSReportTime", 0L);
    long l2 = System.currentTimeMillis();
    if (l2 - l1 < 86400000L)
    {
      AppMethodBeat.o(204087);
      return;
    }
    e.ifc();
    localMultiProcessMMKV.encode("VFSReportTime", l2);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new IDKey(1387, 0, 1));
    localArrayList.add(new IDKey(1387, 2, 1));
    localArrayList.add(new IDKey(1387, 3, 1));
    localArrayList.add(new IDKey(1387, 4, 1));
    if (com.tencent.mm.sdcard_migrate.b.buj(com.tencent.mm.loader.j.b.aSK())) {
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
      i = YDl[1];
      Log.i("MicroMsg.PostTaskVFSStat", "VFS_ASYNC_KEY_FINISH is %s", new Object[] { Integer.valueOf(i) });
      if (!bool4) {
        break label560;
      }
      i = 150;
      Log.i("MicroMsg.PostTaskVFSStat", "VFS_ASYNC_KEY_FINISH_3 is %s", new Object[] { Integer.valueOf(i) });
      if (!bool1) {
        break label567;
      }
      i = YDl[1];
      localArrayList.add(new IDKey(1387, i, 1));
      if (!bool4) {
        break label576;
      }
      i = 150;
      localArrayList.add(new IDKey(1387, i, 1));
      localObject1 = h.iWH();
      Iterator localIterator = ((h)localObject1).ifl().entrySet().iterator();
      i = 0;
      bool1 = true;
      if (!localIterator.hasNext()) {
        break label636;
      }
      localObject2 = (Map.Entry)localIterator.next();
      str = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (FileSystem)((Map.Entry)localObject2).getValue();
      localb = ((h)localObject1).iWL().bBL(str);
      bool2 = bool1;
      if (!YDv.containsKey(str)) {
        break label1145;
      }
      if (!(localb instanceof d)) {
        break label596;
      }
      if (!(localObject2 instanceof MigrationFileSystem)) {
        break label583;
      }
      bool3 = a((d)localb);
      if ((!bool1) || (!bool3)) {
        break label621;
      }
      bool1 = true;
      bool2 = bool1;
      if (bool4) {
        break label1145;
      }
      j = ((Integer)YDv.get(str)).intValue();
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
      i = YDl[0];
      break;
      label560:
      i = 149;
      break label223;
      label567:
      i = YDl[0];
      break label252;
      label576:
      i = 149;
      break label279;
      label583:
      bool3 = b((d)localb);
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
        localObject1 = h.iWH().iWL().bBL("image");
        if (!(localObject1 instanceof d)) {
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
        i = YDm[1];
      }
      for (;;)
      {
        label761:
        Log.i("MicroMsg.PostTaskVFSStat", "DaysKey %s", new Object[] { Integer.valueOf(i) });
        localArrayList.add(new IDKey(1387, i, 1));
        com.tencent.mm.plugin.report.f.Iyx.b(localArrayList, false);
        if (bool4) {
          break label1139;
        }
        if (!bool1) {
          break label1129;
        }
        localMultiProcessMMKV.encode("VFSAsyncFinished", true);
        localMultiProcessMMKV.encode("VFSAsyncFinished3", true);
        localMultiProcessMMKV.encode("VFSAsyncFinish", j);
        AppMethodBeat.o(204087);
        return;
        ad.a((FileSystem.b)localObject1, new ad.b()
        {
          public final boolean a(FileSystem.b paramAnonymousb)
          {
            AppMethodBeat.i(194738);
            if (!(paramAnonymousb instanceof d))
            {
              Log.i("MicroMsg.PostTaskVFSStat", "List image directory of %s:", new Object[] { paramAnonymousb });
              paramAnonymousb = paramAnonymousb.dJ("", false);
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
                  f localf = (f)paramAnonymousb.next();
                  j = i + 1;
                  if (localf != null) {
                    Log.i("MicroMsg.PostTaskVFSStat", "--> %s", new Object[] { localf.UUr });
                  }
                  i = j;
                } while (j <= 50);
              }
            }
            AppMethodBeat.o(194738);
            return false;
          }
        });
        break;
        label882:
        j = localMultiProcessMMKV.getInt("VFSAsyncStart", 0) + 1;
        break label761;
        label897:
        i = YDm[0];
        continue;
        label906:
        if (j <= 2)
        {
          if (bool4) {
            i = YDn[1];
          } else {
            i = YDn[0];
          }
        }
        else if (j <= 3)
        {
          if (bool4) {
            i = YDo[1];
          } else {
            i = YDo[0];
          }
        }
        else if (j <= 5)
        {
          if (bool4) {
            i = YDp[1];
          } else {
            i = YDp[0];
          }
        }
        else if (j <= 10)
        {
          if (bool4) {
            i = YDq[1];
          } else {
            i = YDq[0];
          }
        }
        else if (j <= 15)
        {
          if (bool4) {
            i = YDr[1];
          } else {
            i = YDr[0];
          }
        }
        else if (j <= 20)
        {
          if (bool4) {
            i = YDs[1];
          } else {
            i = YDs[0];
          }
        }
        else if (j <= 30)
        {
          if (bool4) {
            i = YDt[1];
          } else {
            i = YDt[0];
          }
        }
        else if (bool4) {
          i = YDu[1];
        } else {
          i = YDu[0];
        }
      }
      label1129:
      localMultiProcessMMKV.encode("VFSAsyncStart", j);
      label1139:
      AppMethodBeat.o(204087);
      return;
      label1145:
      bool1 = bool2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vfs.k
 * JD-Core Version:    0.7.0.1
 */