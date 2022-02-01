package com.tencent.mm.vfs;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class f
{
  private static final int[] LGV;
  private static final int[] LGW;
  private static final int[] LGX;
  private static final int[] LGY;
  private static final int[] LGZ;
  private static final int[] LHa;
  private static final int[] LHb;
  private static final int[] LHc;
  private static final int[] LHd;
  private static final int[] LHe;
  private static final ArrayList<String> LHf;
  
  static
  {
    AppMethodBeat.i(193649);
    LGV = new int[] { 10, 20 };
    LGW = new int[] { 11, 21 };
    LGX = new int[] { 12, 22 };
    LGY = new int[] { 13, 23 };
    LGZ = new int[] { 14, 24 };
    LHa = new int[] { 15, 25 };
    LHb = new int[] { 16, 26 };
    LHc = new int[] { 17, 27 };
    LHd = new int[] { 18, 28 };
    LHe = new int[] { 19, 29 };
    ArrayList localArrayList = new ArrayList();
    LHf = localArrayList;
    localArrayList.add("attachment");
    LHf.add("Download");
    LHf.add("voice");
    LHf.add("voice2");
    LHf.add("image");
    LHf.add("oldimage2");
    LHf.add("video");
    LHf.add("oneday");
    LHf.add("emoji");
    LHf.add("finder");
    AppMethodBeat.o(193649);
  }
  
  private static void a(MigrationFileSystem paramMigrationFileSystem)
  {
    AppMethodBeat.i(193648);
    Object localObject = e.fSU().gEm().aZO("image");
    if ((paramMigrationFileSystem == null) || (!(localObject instanceof b)))
    {
      ae.i("MicroMsg.PostTaskVFSStat", "imageMigrationFileSystem is null ");
      AppMethodBeat.o(193648);
      return;
    }
    paramMigrationFileSystem = ((b)localObject).fSM().iterator();
    for (;;)
    {
      if (!paramMigrationFileSystem.hasNext()) {
        break label172;
      }
      localObject = (FileSystem.b)paramMigrationFileSystem.next();
      ae.i("MicroMsg.PostTaskVFSStat", "List image directory of %s:", new Object[] { localObject });
      localObject = ((FileSystem.b)localObject).dc("", false);
      if (localObject != null)
      {
        localObject = ((Iterable)localObject).iterator();
        int i = 0;
        if (((Iterator)localObject).hasNext())
        {
          c localc = (c)((Iterator)localObject).next();
          int j = i + 1;
          if (localc != null) {
            ae.i("MicroMsg.PostTaskVFSStat", "--> %s", new Object[] { localc.Itr });
          }
          i = j;
          if (j <= 50) {
            break;
          }
        }
      }
    }
    label172:
    AppMethodBeat.o(193648);
  }
  
  private static boolean a(b paramb)
  {
    AppMethodBeat.i(193646);
    paramb = paramb.fSM();
    paramb = paramb.subList(1, paramb.size()).iterator();
    while (paramb.hasNext())
    {
      Iterable localIterable = ((FileSystem.b)paramb.next()).dc("", false);
      if ((localIterable != null) && (localIterable.iterator().hasNext()))
      {
        AppMethodBeat.o(193646);
        return false;
      }
    }
    AppMethodBeat.o(193646);
    return true;
  }
  
  private static boolean b(b paramb)
  {
    AppMethodBeat.i(193647);
    paramb = paramb.fSM();
    if (paramb == null)
    {
      AppMethodBeat.o(193647);
      return true;
    }
    paramb = paramb.iterator();
    while (paramb.hasNext())
    {
      FileSystem.b localb = (FileSystem.b)paramb.next();
      if ((localb != null) && ((localb.fSK() instanceof MigrationFileSystem)) && ((localb instanceof b)) && (a((b)localb)))
      {
        AppMethodBeat.o(193647);
        return false;
      }
    }
    AppMethodBeat.o(193647);
    return true;
  }
  
  public static void run()
  {
    AppMethodBeat.i(193645);
    ay localay = ay.aRW("VFSStatistic");
    long l1 = localay.getLong("VFSReportTime", 0L);
    long l2 = System.currentTimeMillis();
    if (l2 - l1 < 86400000L)
    {
      AppMethodBeat.o(193645);
      return;
    }
    localay.encode("VFSReportTime", l2);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new IDKey(1387, 0, 1));
    if (!v.fTQ())
    {
      localArrayList.add(new IDKey(1387, 1, 1));
      com.tencent.mm.plugin.report.e.ywz.b(localArrayList, false);
      ae.i("MicroMsg.PostTaskVFSStat", "VFSSwitch.isPathRemapOpen() is false");
      AppMethodBeat.o(193645);
      return;
    }
    v.fTP();
    localArrayList.add(new IDKey(1387, 2, 1));
    localArrayList.add(new IDKey(1387, 3, 1));
    if (v.fTO())
    {
      localArrayList.add(new IDKey(1387, 4, 1));
      if (com.tencent.mm.sdcard_migrate.b.aRn(com.tencent.mm.loader.j.b.asi())) {
        localArrayList.add(new IDKey(1387, 100, 1));
      }
    }
    boolean bool3 = localay.getBoolean("VFSAsyncFinished", false);
    int i;
    label268:
    boolean bool1;
    MigrationFileSystem localMigrationFileSystem;
    label325:
    Object localObject2;
    String str;
    FileSystem.b localb;
    boolean bool2;
    label422:
    label435:
    int j;
    if (bool3)
    {
      i = LGV[1];
      ae.i("MicroMsg.PostTaskVFSStat", "VFS_ASYNC_KEY_FINISH is %s", new Object[] { Integer.valueOf(i) });
      if (!bool3) {
        break label536;
      }
      i = LGV[1];
      localArrayList.add(new IDKey(1387, i, 1));
      e locale = e.fSU();
      Object localObject1 = locale.gEm().fSZ();
      bool1 = true;
      i = 0;
      localMigrationFileSystem = null;
      localObject1 = ((Map)localObject1).entrySet().iterator();
      if (!((Iterator)localObject1).hasNext()) {
        break label595;
      }
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      str = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (FileSystem)((Map.Entry)localObject2).getValue();
      localb = locale.gEm().aZO(str);
      if (!LHf.contains(str)) {
        break label1057;
      }
      if (!(localb instanceof b)) {
        break label558;
      }
      if (!(localObject2 instanceof MigrationFileSystem)) {
        break label545;
      }
      bool2 = a((b)localb);
      if ((!bool1) || (!bool2)) {
        break label583;
      }
      bool1 = true;
      if (bool3) {
        break label1054;
      }
      if (!bool2) {
        break label589;
      }
      j = 30;
      label448:
      localArrayList.add(new IDKey(1387, j + LHf.indexOf(str), 1));
      ae.i("MicroMsg.PostTaskVFSStat", "FileSystem %s, isMigrationFinished is %s", new Object[] { str, Boolean.valueOf(bool2) });
      if ((!str.equals("image")) || (bool2)) {
        break label1054;
      }
      i = 1;
      localMigrationFileSystem = (MigrationFileSystem)localObject2;
    }
    label536:
    label545:
    label1057:
    for (;;)
    {
      break label325;
      i = LGV[0];
      break;
      i = LGV[0];
      break label268;
      bool2 = b((b)localb);
      break label422;
      label558:
      ae.e("MicroMsg.PostTaskVFSStat", "FileSystem %s type error %s", new Object[] { str, localObject2 });
      break label325;
      label583:
      bool1 = false;
      break label435;
      label589:
      j = 40;
      break label448;
      label595:
      if (i != 0)
      {
        localArrayList.add(new IDKey(1387, 90, 1));
        a(localMigrationFileSystem);
      }
      ae.i("MicroMsg.PostTaskVFSStat", "VFSP_REPORT_ASYNC_FINISHED is %s, isMigrationFinished is %s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1) });
      if ((bool3) && (!bool1)) {
        localArrayList.add(new IDKey(1387, 5, 1));
      }
      if (bool3)
      {
        j = localay.getInt("VFSAsyncFinish", 0);
        if (j > 1) {
          break label815;
        }
        if (!bool3) {
          break label806;
        }
        i = LGW[1];
      }
      for (;;)
      {
        ae.i("MicroMsg.PostTaskVFSStat", "DaysKey %s", new Object[] { Integer.valueOf(i) });
        localArrayList.add(new IDKey(1387, i, 1));
        com.tencent.mm.plugin.report.e.ywz.b(localArrayList, false);
        if (bool3) {
          break label1048;
        }
        if (!bool1) {
          break label1038;
        }
        localay.encode("VFSAsyncFinished", true);
        localay.encode("VFSAsyncFinish", j);
        AppMethodBeat.o(193645);
        return;
        j = localay.getInt("VFSAsyncStart", 0) + 1;
        break;
        label806:
        i = LGW[0];
        continue;
        label815:
        if (j <= 2)
        {
          if (bool3) {
            i = LGX[1];
          } else {
            i = LGX[0];
          }
        }
        else if (j <= 3)
        {
          if (bool3) {
            i = LGY[1];
          } else {
            i = LGY[0];
          }
        }
        else if (j <= 5)
        {
          if (bool3) {
            i = LGZ[1];
          } else {
            i = LGZ[0];
          }
        }
        else if (j <= 10)
        {
          if (bool3) {
            i = LHa[1];
          } else {
            i = LHa[0];
          }
        }
        else if (j <= 15)
        {
          if (bool3) {
            i = LHb[1];
          } else {
            i = LHb[0];
          }
        }
        else if (j <= 20)
        {
          if (bool3) {
            i = LHc[1];
          } else {
            i = LHc[0];
          }
        }
        else if (j <= 30)
        {
          if (bool3) {
            i = LHd[1];
          } else {
            i = LHd[0];
          }
        }
        else if (bool3) {
          i = LHe[1];
        } else {
          i = LHe[0];
        }
      }
      localay.encode("VFSAsyncStart", j);
      AppMethodBeat.o(193645);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.f
 * JD-Core Version:    0.7.0.1
 */