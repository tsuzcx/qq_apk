package com.tencent.xweb.xwalk.updater;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkUpdater;
import org.xwalk.core.XWebCoreInfo;

public final class d
{
  private static a.c a(a.f paramf, String paramString)
  {
    AppMethodBeat.i(207622);
    if (paramf.MVu != null)
    {
      paramf = paramf.MVu;
      int j = paramf.length;
      int i = 0;
      while (i < j)
      {
        a.c localc = paramf[i];
        if (localc.MVF == XWalkEnvironment.getInstalledNewstVersion(paramString))
        {
          XWalkInitializer.addXWalkInitializeLog("got matched patch to upgrade " + localc.MVF);
          AppMethodBeat.o(207622);
          return localc;
        }
        i += 1;
      }
    }
    XWalkInitializer.addXWalkInitializeLog("no matched patch");
    AppMethodBeat.o(207622);
    return null;
  }
  
  public static c a(a.b paramb, String paramString)
  {
    AppMethodBeat.i(207621);
    c localc = new c();
    com.tencent.xweb.internal.a.c.bcL(paramString);
    Object localObject;
    if ((paramb == null) || (paramb.MVD == null) || (paramb.MVD.length == 0))
    {
      localObject = null;
      com.tencent.xweb.internal.a.c.bcL(null);
      if ((localObject == null) || (((a.f)localObject).version <= XWebCoreInfo.getBackupCoreInfo(paramString).ver)) {
        break label589;
      }
      XWalkInitializer.addXWalkInitializeLog("got matched version");
      localc.MVC = paramb.MVC;
      localc.MVw = ((a.f)localObject).MVw;
      localc.MVz = ((a.f)localObject).MVz;
      localc.MVA = ((a.f)localObject).MVA;
      localc.MVB = ((a.f)localObject).MVB;
      localc.version = ((a.f)localObject).version;
      localc.MWc = ((a.f)localObject).MVI.MVL;
      localc.MVx = ((a.f)localObject).MVx;
      localc.bUseCdn = ((a.f)localObject).bUseCdn;
      localc.bTryUseSharedCore = ((a.f)localObject).bTryUseSharedCore;
      paramb = a((a.f)localObject, paramString);
      localc.MWa = ((a.f)localObject).MVp;
      localc.strAbi = ((a.f)localObject).MPG.MQk;
      localc.MVo = ((a.f)localObject).MVo;
      localc.MWf = ((a.f)localObject).MVq;
      localc.MWg = ((a.f)localObject).MVr;
      if (paramb == null) {
        break label570;
      }
      localc.MVY = true;
      localc.nPatchTargetVersion = paramb.MVF;
      localc.MVp = paramb.MVp;
      localc.patchMd5 = paramb.MVw;
      localc.MVx = paramb.MVx;
      localc.bUseCdn = paramb.bUseCdn;
    }
    for (;;)
    {
      localc.MWb = Scheduler.a((a.a)localObject, "XWebCore");
      AppMethodBeat.o(207621);
      return localc;
      int i = Build.VERSION.SDK_INT;
      a.f[] arrayOff = paramb.MVD;
      int j = arrayOff.length;
      i = 0;
      label322:
      if (i < j)
      {
        a.f localf = arrayOff[i];
        if (localf == null) {
          XWalkInitializer.addXWalkInitializeLog("no matched version  version == null");
        }
        for (;;)
        {
          i += 1;
          break label322;
          Log.i("VersionMatcher", "try match version = " + localf.version + " version runtime abi is " + localf.MPG.MQk);
          if (localf.version < 49)
          {
            Log.i("VersionMatcher", " apk is not support, below 49");
          }
          else
          {
            int k = XWalkEnvironment.getInstalledNewstVersion(localf.MPG.MQk);
            if (localf.version <= k)
            {
              Log.i("VersionMatcher", " apk is too old, now installed version ".concat(String.valueOf(k)));
            }
            else if (!localf.MPG.gge())
            {
              Log.i("VersionMatcher", " apk filter out ");
            }
            else
            {
              localObject = localf.MPG.MQk;
              XWalkUpdater.getLastTryInstallVer((String)localObject);
              if (!"arm64-v8a".equalsIgnoreCase((String)localObject)) {
                "armeabi-v7a".equalsIgnoreCase((String)localObject);
              }
              localObject = localf;
              if (!com.tencent.xweb.internal.a.c.ggh()) {
                break;
              }
              localObject = localf;
              if (localf.MVJ) {
                break;
              }
              Log.i("VersionMatcher", " version.supportPredown is false, apkver = " + localf.version);
            }
          }
        }
      }
      XWalkInitializer.addXWalkInitializeLog("no matched version");
      localObject = null;
      break;
      label570:
      localc.MVY = false;
      localc.MVp = ((a.f)localObject).MVp;
    }
    label589:
    AppMethodBeat.o(207621);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.d
 * JD-Core Version:    0.7.0.1
 */