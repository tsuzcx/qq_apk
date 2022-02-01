package com.tencent.mm.vfs;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class b
{
  private static final int[] LkA;
  private static final int[] LkB;
  private static final int[] LkC;
  private static final int[] LkD;
  private static final int[] LkE;
  private static final int[] LkF;
  private static final int[] LkG;
  private static final int[] LkH;
  private static final int[] LkI;
  private static final int[] LkJ;
  private static final ArrayList<String> LkK;
  
  static
  {
    AppMethodBeat.i(189944);
    LkA = new int[] { 10, 20 };
    LkB = new int[] { 11, 21 };
    LkC = new int[] { 12, 22 };
    LkD = new int[] { 13, 23 };
    LkE = new int[] { 14, 24 };
    LkF = new int[] { 15, 25 };
    LkG = new int[] { 16, 26 };
    LkH = new int[] { 17, 27 };
    LkI = new int[] { 18, 28 };
    LkJ = new int[] { 19, 29 };
    ArrayList localArrayList = new ArrayList();
    LkK = localArrayList;
    localArrayList.add("attachment");
    LkK.add("Download");
    LkK.add("voice");
    LkK.add("voice2");
    LkK.add("image");
    LkK.add("oldimage2");
    LkK.add("video");
    LkK.add("oneday");
    LkK.add("emoji");
    LkK.add("finder");
    AppMethodBeat.o(189944);
  }
  
  private static final void a(MigrationFileSystem paramMigrationFileSystem)
  {
    AppMethodBeat.i(189943);
    if (paramMigrationFileSystem == null)
    {
      ad.i("MicroMsg.PostTaskVFSStat", "imageMigrationFileSystem is null ");
      AppMethodBeat.o(189943);
      return;
    }
    paramMigrationFileSystem = paramMigrationFileSystem.Lkq.iterator();
    for (;;)
    {
      if (!paramMigrationFileSystem.hasNext()) {
        break label148;
      }
      Object localObject = (FileSystem)paramMigrationFileSystem.next();
      ad.i("MicroMsg.PostTaskVFSStat", "List image directory of %s:", new Object[] { localObject });
      localObject = ((FileSystem)localObject).cY("", false);
      if (localObject != null)
      {
        localObject = ((Iterable)localObject).iterator();
        int i = 0;
        if (((Iterator)localObject).hasNext())
        {
          FileSystem.a locala = (FileSystem.a)((Iterator)localObject).next();
          int j = i + 1;
          if (locala != null) {
            ad.i("MicroMsg.PostTaskVFSStat", "--> %s", new Object[] { locala.HZk });
          }
          i = j;
          if (j <= 50) {
            break;
          }
        }
      }
    }
    label148:
    AppMethodBeat.o(189943);
  }
  
  private static final boolean a(DelegateFileSystem paramDelegateFileSystem)
  {
    AppMethodBeat.i(189942);
    paramDelegateFileSystem = paramDelegateFileSystem.fOq();
    if (paramDelegateFileSystem == null)
    {
      AppMethodBeat.o(189942);
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
      if ((bool) && (((MigrationFileSystem)localFileSystem).fOB())) {
        bool = true;
      }
    }
    label91:
    for (;;)
    {
      break;
      bool = false;
      continue;
      AppMethodBeat.o(189942);
      return bool;
    }
  }
  
  public static void run()
  {
    AppMethodBeat.i(189941);
    ax localax = ax.aQz("VFSStatistic");
    long l1 = localax.getLong("VFSReportTime", 0L);
    long l2 = System.currentTimeMillis();
    if (l2 - l1 < 86400000L)
    {
      AppMethodBeat.o(189941);
      return;
    }
    localax.encode("VFSReportTime", l2);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new IDKey(1387, 0, 1));
    if (!p.fPt())
    {
      localArrayList.add(new IDKey(1387, 1, 1));
      e.ygI.b(localArrayList, false);
      ad.i("MicroMsg.PostTaskVFSStat", "VFSSwitch.isPathRemapOpen() is false");
      AppMethodBeat.o(189941);
      return;
    }
    p.fPs();
    localArrayList.add(new IDKey(1387, 2, 1));
    localArrayList.add(new IDKey(1387, 3, 1));
    if (p.fPr())
    {
      localArrayList.add(new IDKey(1387, 4, 1));
      if (com.tencent.mm.sdcard_migrate.b.aPQ(com.tencent.mm.loader.j.b.arT())) {
        localArrayList.add(new IDKey(1387, 100, 1));
      }
    }
    boolean bool3 = localax.getBoolean("VFSAsyncFinished", false);
    int i;
    label268:
    boolean bool1;
    MigrationFileSystem localMigrationFileSystem;
    label321:
    Object localObject2;
    String str;
    boolean bool2;
    label396:
    label409:
    int j;
    if (bool3)
    {
      i = LkA[1];
      ad.i("MicroMsg.PostTaskVFSStat", "VFS_ASYNC_KEY_FINISH is %s", new Object[] { Integer.valueOf(i) });
      if (!bool3) {
        break label510;
      }
      i = LkA[1];
      localArrayList.add(new IDKey(1387, i, 1));
      Object localObject1 = a.gzU().gzY().fOD();
      bool1 = true;
      i = 0;
      localMigrationFileSystem = null;
      localObject1 = ((Map)localObject1).entrySet().iterator();
      if (!((Iterator)localObject1).hasNext()) {
        break label577;
      }
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      str = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (FileSystem)((Map.Entry)localObject2).getValue();
      if (!LkK.contains(str)) {
        break label1039;
      }
      if (!(localObject2 instanceof MigrationFileSystem)) {
        break label519;
      }
      bool2 = ((MigrationFileSystem)localObject2).fOB();
      if ((!bool1) || (!bool2)) {
        break label565;
      }
      bool1 = true;
      if (bool3) {
        break label1036;
      }
      if (!bool2) {
        break label571;
      }
      j = 30;
      label422:
      localArrayList.add(new IDKey(1387, j + LkK.indexOf(str), 1));
      ad.i("MicroMsg.PostTaskVFSStat", "FileSystem %s, isMigrationFinished is %s", new Object[] { str, Boolean.valueOf(bool2) });
      if ((!str.equals("image")) || (bool2)) {
        break label1036;
      }
      i = 1;
      localMigrationFileSystem = (MigrationFileSystem)localObject2;
    }
    label519:
    label1036:
    label1039:
    for (;;)
    {
      break label321;
      i = LkA[0];
      break;
      label510:
      i = LkA[0];
      break label268;
      if ((localObject2 instanceof DelegateFileSystem))
      {
        bool2 = a((DelegateFileSystem)localObject2);
        break label396;
      }
      ad.e("MicroMsg.PostTaskVFSStat", "FileSystem %s type error %s", new Object[] { str, localObject2 });
      break label321;
      label565:
      bool1 = false;
      break label409;
      label571:
      j = 40;
      break label422;
      label577:
      if (i != 0)
      {
        localArrayList.add(new IDKey(1387, 90, 1));
        a(localMigrationFileSystem);
      }
      ad.i("MicroMsg.PostTaskVFSStat", "VFSP_REPORT_ASYNC_FINISHED is %s, isMigrationFinished is %s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1) });
      if ((bool3) && (!bool1)) {
        localArrayList.add(new IDKey(1387, 5, 1));
      }
      if (bool3)
      {
        j = localax.getInt("VFSAsyncFinish", 0);
        if (j > 1) {
          break label797;
        }
        if (!bool3) {
          break label788;
        }
        i = LkB[1];
      }
      for (;;)
      {
        ad.i("MicroMsg.PostTaskVFSStat", "DaysKey %s", new Object[] { Integer.valueOf(i) });
        localArrayList.add(new IDKey(1387, i, 1));
        e.ygI.b(localArrayList, false);
        if (bool3) {
          break label1030;
        }
        if (!bool1) {
          break label1020;
        }
        localax.encode("VFSAsyncFinished", true);
        localax.encode("VFSAsyncFinish", j);
        AppMethodBeat.o(189941);
        return;
        j = localax.getInt("VFSAsyncStart", 0) + 1;
        break;
        label788:
        i = LkB[0];
        continue;
        label797:
        if (j <= 2)
        {
          if (bool3) {
            i = LkC[1];
          } else {
            i = LkC[0];
          }
        }
        else if (j <= 3)
        {
          if (bool3) {
            i = LkD[1];
          } else {
            i = LkD[0];
          }
        }
        else if (j <= 5)
        {
          if (bool3) {
            i = LkE[1];
          } else {
            i = LkE[0];
          }
        }
        else if (j <= 10)
        {
          if (bool3) {
            i = LkF[1];
          } else {
            i = LkF[0];
          }
        }
        else if (j <= 15)
        {
          if (bool3) {
            i = LkG[1];
          } else {
            i = LkG[0];
          }
        }
        else if (j <= 20)
        {
          if (bool3) {
            i = LkH[1];
          } else {
            i = LkH[0];
          }
        }
        else if (j <= 30)
        {
          if (bool3) {
            i = LkI[1];
          } else {
            i = LkI[0];
          }
        }
        else if (bool3) {
          i = LkJ[1];
        } else {
          i = LkJ[0];
        }
      }
      label1020:
      localax.encode("VFSAsyncStart", j);
      AppMethodBeat.o(189941);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.vfs.b
 * JD-Core Version:    0.7.0.1
 */