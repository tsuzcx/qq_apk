package com.tencent.mm.vfs;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class b
{
  private static final int[] JsV;
  private static final int[] JsW;
  private static final int[] JsX;
  private static final int[] JsY;
  private static final int[] JsZ;
  private static final int[] Jta;
  private static final int[] Jtb;
  private static final int[] Jtc;
  private static final int[] Jtd;
  private static final int[] Jte;
  private static final ArrayList<String> Jtf;
  
  static
  {
    AppMethodBeat.i(206976);
    JsV = new int[] { 10, 20 };
    JsW = new int[] { 11, 21 };
    JsX = new int[] { 12, 22 };
    JsY = new int[] { 13, 23 };
    JsZ = new int[] { 14, 24 };
    Jta = new int[] { 15, 25 };
    Jtb = new int[] { 16, 26 };
    Jtc = new int[] { 17, 27 };
    Jtd = new int[] { 18, 28 };
    Jte = new int[] { 19, 29 };
    ArrayList localArrayList = new ArrayList();
    Jtf = localArrayList;
    localArrayList.add("attachment");
    Jtf.add("Download");
    Jtf.add("voice");
    Jtf.add("voice2");
    Jtf.add("image");
    Jtf.add("oldimage2");
    Jtf.add("video");
    Jtf.add("oneday");
    Jtf.add("emoji");
    Jtf.add("finder");
    AppMethodBeat.o(206976);
  }
  
  private static final void a(MigrationFileSystem paramMigrationFileSystem)
  {
    AppMethodBeat.i(206975);
    if (paramMigrationFileSystem == null)
    {
      ac.i("MicroMsg.PostTaskVFSStat", "imageMigrationFileSystem is null ");
      AppMethodBeat.o(206975);
      return;
    }
    paramMigrationFileSystem = paramMigrationFileSystem.JsL.iterator();
    for (;;)
    {
      if (!paramMigrationFileSystem.hasNext()) {
        break label148;
      }
      Object localObject = (FileSystem)paramMigrationFileSystem.next();
      ac.i("MicroMsg.PostTaskVFSStat", "List image directory of %s:", new Object[] { localObject });
      localObject = ((FileSystem)localObject).cT("", false);
      if (localObject != null)
      {
        localObject = ((Iterable)localObject).iterator();
        int i = 0;
        if (((Iterator)localObject).hasNext())
        {
          FileSystem.a locala = (FileSystem.a)((Iterator)localObject).next();
          int j = i + 1;
          if (locala != null) {
            ac.i("MicroMsg.PostTaskVFSStat", "--> %s", new Object[] { locala.Gnx });
          }
          i = j;
          if (j <= 50) {
            break;
          }
        }
      }
    }
    label148:
    AppMethodBeat.o(206975);
  }
  
  private static final boolean a(DelegateFileSystem paramDelegateFileSystem)
  {
    AppMethodBeat.i(206974);
    paramDelegateFileSystem = paramDelegateFileSystem.fxD();
    if (paramDelegateFileSystem == null)
    {
      AppMethodBeat.o(206974);
      return true;
    }
    paramDelegateFileSystem = paramDelegateFileSystem.iterator();
    boolean bool = true;
    if (paramDelegateFileSystem.hasNext())
    {
      FileSystem localFileSystem = (FileSystem)paramDelegateFileSystem.next();
      if ((localFileSystem == null) || (!(localFileSystem instanceof MigrationFileSystem))) {
        break label91;
      }
      if ((bool) && (((MigrationFileSystem)localFileSystem).fxO())) {
        bool = true;
      }
    }
    label91:
    for (;;)
    {
      break;
      bool = false;
      continue;
      AppMethodBeat.o(206974);
      return bool;
    }
  }
  
  public static void run()
  {
    AppMethodBeat.i(206973);
    aw localaw = aw.aKT("VFSStatistic");
    long l1 = localaw.getLong("VFSReportTime", 0L);
    long l2 = System.currentTimeMillis();
    if (l2 - l1 < 86400000L)
    {
      AppMethodBeat.o(206973);
      return;
    }
    localaw.encode("VFSReportTime", l2);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new IDKey(1387, 0, 1));
    if (!p.fyz())
    {
      localArrayList.add(new IDKey(1387, 1, 1));
      e.wTc.b(localArrayList, false);
      ac.i("MicroMsg.PostTaskVFSStat", "VFSSwitch.isPathRemapOpen() is false");
      AppMethodBeat.o(206973);
      return;
    }
    boolean bool1 = p.fyw();
    localArrayList.add(new IDKey(1387, 2, 1));
    if (bool1) {
      localArrayList.add(new IDKey(1387, 3, 1));
    }
    if (p.fyx())
    {
      localArrayList.add(new IDKey(1387, 4, 1));
      if (com.tencent.mm.sdcard_migrate.b.aKl(com.tencent.mm.loader.j.b.apg())) {
        localArrayList.add(new IDKey(1387, 100, 1));
      }
    }
    if (!bool1)
    {
      e.wTc.b(localArrayList, false);
      ac.i("MicroMsg.PostTaskVFSStat", "isAsyncMigrationOpened is false");
      AppMethodBeat.o(206973);
      return;
    }
    boolean bool3 = localaw.getBoolean("VFSAsyncFinished", false);
    int i;
    label301:
    MigrationFileSystem localMigrationFileSystem;
    label349:
    Object localObject2;
    String str;
    boolean bool2;
    label424:
    label437:
    int j;
    if (bool3)
    {
      i = JsV[1];
      ac.i("MicroMsg.PostTaskVFSStat", "VFS_ASYNC_KEY_FINISH is %s", new Object[] { Integer.valueOf(i) });
      if (!bool3) {
        break label538;
      }
      i = JsV[1];
      localArrayList.add(new IDKey(1387, i, 1));
      Object localObject1 = a.ghk().gho();
      bool1 = true;
      i = 0;
      localMigrationFileSystem = null;
      localObject1 = ((Map)localObject1).entrySet().iterator();
      if (!((Iterator)localObject1).hasNext()) {
        break label605;
      }
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      str = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (FileSystem)((Map.Entry)localObject2).getValue();
      if (!Jtf.contains(str)) {
        break label1067;
      }
      if (!(localObject2 instanceof MigrationFileSystem)) {
        break label547;
      }
      bool2 = ((MigrationFileSystem)localObject2).fxO();
      if ((!bool1) || (!bool2)) {
        break label593;
      }
      bool1 = true;
      if (bool3) {
        break label1064;
      }
      if (!bool2) {
        break label599;
      }
      j = 30;
      label450:
      localArrayList.add(new IDKey(1387, j + Jtf.indexOf(str), 1));
      ac.i("MicroMsg.PostTaskVFSStat", "FileSystem %s, isMigrationFinished is %s", new Object[] { str, Boolean.valueOf(bool2) });
      if ((!str.equals("image")) || (bool2)) {
        break label1064;
      }
      i = 1;
      localMigrationFileSystem = (MigrationFileSystem)localObject2;
    }
    label538:
    label547:
    label1064:
    label1067:
    for (;;)
    {
      break label349;
      i = JsV[0];
      break;
      i = JsV[0];
      break label301;
      if ((localObject2 instanceof DelegateFileSystem))
      {
        bool2 = a((DelegateFileSystem)localObject2);
        break label424;
      }
      ac.e("MicroMsg.PostTaskVFSStat", "FileSystem %s type error %s", new Object[] { str, localObject2 });
      break label349;
      label593:
      bool1 = false;
      break label437;
      label599:
      j = 40;
      break label450;
      label605:
      if (i != 0)
      {
        localArrayList.add(new IDKey(1387, 90, 1));
        a(localMigrationFileSystem);
      }
      ac.i("MicroMsg.PostTaskVFSStat", "VFSP_REPORT_ASYNC_FINISHED is %s, isMigrationFinished is %s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1) });
      if ((bool3) && (!bool1)) {
        localArrayList.add(new IDKey(1387, 5, 1));
      }
      if (bool3)
      {
        j = localaw.getInt("VFSAsyncFinish", 0);
        if (j > 1) {
          break label825;
        }
        if (!bool3) {
          break label816;
        }
        i = JsW[1];
      }
      for (;;)
      {
        ac.i("MicroMsg.PostTaskVFSStat", "DaysKey %s", new Object[] { Integer.valueOf(i) });
        localArrayList.add(new IDKey(1387, i, 1));
        e.wTc.b(localArrayList, false);
        if (bool3) {
          break label1058;
        }
        if (!bool1) {
          break label1048;
        }
        localaw.encode("VFSAsyncFinished", true);
        localaw.encode("VFSAsyncFinish", j);
        AppMethodBeat.o(206973);
        return;
        j = localaw.getInt("VFSAsyncStart", 0) + 1;
        break;
        label816:
        i = JsW[0];
        continue;
        label825:
        if (j <= 2)
        {
          if (bool3) {
            i = JsX[1];
          } else {
            i = JsX[0];
          }
        }
        else if (j <= 3)
        {
          if (bool3) {
            i = JsY[1];
          } else {
            i = JsY[0];
          }
        }
        else if (j <= 5)
        {
          if (bool3) {
            i = JsZ[1];
          } else {
            i = JsZ[0];
          }
        }
        else if (j <= 10)
        {
          if (bool3) {
            i = Jta[1];
          } else {
            i = Jta[0];
          }
        }
        else if (j <= 15)
        {
          if (bool3) {
            i = Jtb[1];
          } else {
            i = Jtb[0];
          }
        }
        else if (j <= 20)
        {
          if (bool3) {
            i = Jtc[1];
          } else {
            i = Jtc[0];
          }
        }
        else if (j <= 30)
        {
          if (bool3) {
            i = Jtd[1];
          } else {
            i = Jtd[0];
          }
        }
        else if (bool3) {
          i = Jte[1];
        } else {
          i = Jte[0];
        }
      }
      localaw.encode("VFSAsyncStart", j);
      AppMethodBeat.o(206973);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.vfs.b
 * JD-Core Version:    0.7.0.1
 */