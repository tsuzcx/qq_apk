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
  private static final ArrayList<String> HSA;
  private static final int[] HSq;
  private static final int[] HSr;
  private static final int[] HSs;
  private static final int[] HSt;
  private static final int[] HSu;
  private static final int[] HSv;
  private static final int[] HSw;
  private static final int[] HSx;
  private static final int[] HSy;
  private static final int[] HSz;
  
  static
  {
    AppMethodBeat.i(192920);
    HSq = new int[] { 10, 20 };
    HSr = new int[] { 11, 21 };
    HSs = new int[] { 12, 22 };
    HSt = new int[] { 13, 23 };
    HSu = new int[] { 14, 24 };
    HSv = new int[] { 15, 25 };
    HSw = new int[] { 16, 26 };
    HSx = new int[] { 17, 27 };
    HSy = new int[] { 18, 28 };
    HSz = new int[] { 19, 29 };
    ArrayList localArrayList = new ArrayList();
    HSA = localArrayList;
    localArrayList.add("attachment");
    HSA.add("Download");
    HSA.add("voice");
    HSA.add("voice2");
    HSA.add("image");
    HSA.add("oldimage2");
    HSA.add("video");
    HSA.add("oneday");
    HSA.add("emoji");
    HSA.add("finder");
    AppMethodBeat.o(192920);
  }
  
  private static final void a(MigrationFileSystem paramMigrationFileSystem)
  {
    AppMethodBeat.i(192919);
    if (paramMigrationFileSystem == null)
    {
      ad.i("MicroMsg.PostTaskVFSStat", "imageMigrationFileSystem is null ");
      AppMethodBeat.o(192919);
      return;
    }
    paramMigrationFileSystem = paramMigrationFileSystem.HSg.iterator();
    for (;;)
    {
      if (!paramMigrationFileSystem.hasNext()) {
        break label148;
      }
      Object localObject = (FileSystem)paramMigrationFileSystem.next();
      ad.i("MicroMsg.PostTaskVFSStat", "List image directory of %s:", new Object[] { localObject });
      localObject = ((FileSystem)localObject).cN("", false);
      if (localObject != null)
      {
        localObject = ((Iterable)localObject).iterator();
        int i = 0;
        if (((Iterator)localObject).hasNext())
        {
          FileSystem.a locala = (FileSystem.a)((Iterator)localObject).next();
          int j = i + 1;
          if (locala != null) {
            ad.i("MicroMsg.PostTaskVFSStat", "--> %s", new Object[] { locala.EQk });
          }
          i = j;
          if (j <= 50) {
            break;
          }
        }
      }
    }
    label148:
    AppMethodBeat.o(192919);
  }
  
  private static final boolean a(DelegateFileSystem paramDelegateFileSystem)
  {
    AppMethodBeat.i(192918);
    paramDelegateFileSystem = paramDelegateFileSystem.fhB();
    if (paramDelegateFileSystem == null)
    {
      AppMethodBeat.o(192918);
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
      if ((bool) && (((MigrationFileSystem)localFileSystem).fhN())) {
        bool = true;
      }
    }
    label91:
    for (;;)
    {
      break;
      bool = false;
      continue;
      AppMethodBeat.o(192918);
      return bool;
    }
  }
  
  public static void run()
  {
    AppMethodBeat.i(192917);
    ax localax = ax.aFC("VFSStatistic");
    long l1 = localax.getLong("VFSReportTime", 0L);
    long l2 = System.currentTimeMillis();
    if (l2 - l1 < 86400000L)
    {
      AppMethodBeat.o(192917);
      return;
    }
    localax.encode("VFSReportTime", l2);
    ArrayList localArrayList = new ArrayList();
    if (!p.fim())
    {
      localArrayList.add(new IDKey(1387, 1, 1));
      e.vIY.b(localArrayList, false);
      ad.i("MicroMsg.PostTaskVFSStat", "VFSSwitch.isPathRemapOpen() is false");
      AppMethodBeat.o(192917);
      return;
    }
    localArrayList.add(new IDKey(1387, 0, 1));
    boolean bool1 = p.fij();
    localArrayList.add(new IDKey(1387, 2, 1));
    if (bool1) {
      localArrayList.add(new IDKey(1387, 3, 1));
    }
    if (p.fik()) {
      localArrayList.add(new IDKey(1387, 4, 1));
    }
    if (!bool1)
    {
      e.vIY.b(localArrayList, false);
      ad.i("MicroMsg.PostTaskVFSStat", "isAsyncMigrationOpened is false");
      AppMethodBeat.o(192917);
      return;
    }
    boolean bool3 = localax.getBoolean("VFSAsyncFinished", false);
    int i;
    label273:
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
      i = HSq[1];
      ad.i("MicroMsg.PostTaskVFSStat", "VFS_ASYNC_KEY_FINISH is %s", new Object[] { Integer.valueOf(i) });
      if (!bool3) {
        break label510;
      }
      i = HSq[1];
      localArrayList.add(new IDKey(1387, i, 1));
      Object localObject1 = a.gap().gau();
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
      if (!HSA.contains(str)) {
        break label1039;
      }
      if (!(localObject2 instanceof MigrationFileSystem)) {
        break label519;
      }
      bool2 = ((MigrationFileSystem)localObject2).fhN();
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
      localArrayList.add(new IDKey(1387, j + HSA.indexOf(str), 1));
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
      i = HSq[0];
      break;
      label510:
      i = HSq[0];
      break label273;
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
        i = HSr[1];
      }
      for (;;)
      {
        ad.i("MicroMsg.PostTaskVFSStat", "DaysKey %s", new Object[] { Integer.valueOf(i) });
        localArrayList.add(new IDKey(1387, i, 1));
        e.vIY.b(localArrayList, false);
        if (bool3) {
          break label1030;
        }
        if (!bool1) {
          break label1020;
        }
        localax.encode("VFSAsyncFinished", true);
        localax.encode("VFSAsyncFinish", j);
        AppMethodBeat.o(192917);
        return;
        j = localax.getInt("VFSAsyncStart", 0) + 1;
        break;
        label788:
        i = HSr[0];
        continue;
        label797:
        if (j <= 2)
        {
          if (bool3) {
            i = HSs[1];
          } else {
            i = HSs[0];
          }
        }
        else if (j <= 3)
        {
          if (bool3) {
            i = HSt[1];
          } else {
            i = HSt[0];
          }
        }
        else if (j <= 5)
        {
          if (bool3) {
            i = HSu[1];
          } else {
            i = HSu[0];
          }
        }
        else if (j <= 10)
        {
          if (bool3) {
            i = HSv[1];
          } else {
            i = HSv[0];
          }
        }
        else if (j <= 15)
        {
          if (bool3) {
            i = HSw[1];
          } else {
            i = HSw[0];
          }
        }
        else if (j <= 20)
        {
          if (bool3) {
            i = HSx[1];
          } else {
            i = HSx[0];
          }
        }
        else if (j <= 30)
        {
          if (bool3) {
            i = HSy[1];
          } else {
            i = HSy[0];
          }
        }
        else if (bool3) {
          i = HSz[1];
        } else {
          i = HSz[0];
        }
      }
      label1020:
      localax.encode("VFSAsyncStart", j);
      AppMethodBeat.o(192917);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.vfs.b
 * JD-Core Version:    0.7.0.1
 */