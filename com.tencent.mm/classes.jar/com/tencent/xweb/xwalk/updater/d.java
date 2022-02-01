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
  public static SchedulerConfig a(a.b paramb, String paramString)
  {
    AppMethodBeat.i(195600);
    SchedulerConfig localSchedulerConfig = new SchedulerConfig();
    com.tencent.xweb.internal.a.c.bbi(paramString);
    Object localObject;
    if ((paramb == null) || (paramb.Myy == null) || (paramb.Myy.length == 0))
    {
      localObject = null;
      com.tencent.xweb.internal.a.c.bbi(null);
      if ((localObject == null) || (((a.f)localObject).version <= XWebCoreInfo.getBackupCoreInfo(paramString).ver)) {
        break label587;
      }
      XWalkInitializer.addXWalkInitializeLog("got matched version");
      localSchedulerConfig.Myx = paramb.Myx;
      localSchedulerConfig.Mys = ((a.f)localObject).Mys;
      localSchedulerConfig.Myu = ((a.f)localObject).Myu;
      localSchedulerConfig.Myv = ((a.f)localObject).Myv;
      localSchedulerConfig.Myw = ((a.f)localObject).Myw;
      localSchedulerConfig.version = ((a.f)localObject).version;
      localSchedulerConfig.MyX = ((a.f)localObject).MyD.MyG;
      localSchedulerConfig.Myt = ((a.f)localObject).Myt;
      localSchedulerConfig.bUseCdn = ((a.f)localObject).bUseCdn;
      localSchedulerConfig.bTryUseSharedCore = ((a.f)localObject).bTryUseSharedCore;
      paramb = a((a.f)localObject, paramString);
      localSchedulerConfig.MyV = ((a.f)localObject).Myl;
      localSchedulerConfig.strAbi = ((a.f)localObject).MsC.Mtg;
      localSchedulerConfig.Myk = ((a.f)localObject).Myk;
      localSchedulerConfig.Mza = ((a.f)localObject).Mym;
      localSchedulerConfig.Mzb = ((a.f)localObject).Myn;
      if (paramb == null) {
        break label568;
      }
      localSchedulerConfig.MyT = true;
      localSchedulerConfig.nPatchTargetVersion = paramb.MyA;
      localSchedulerConfig.Myl = paramb.Myl;
      localSchedulerConfig.patchMd5 = paramb.Mys;
      localSchedulerConfig.Myt = paramb.Myt;
      localSchedulerConfig.bUseCdn = paramb.bUseCdn;
    }
    for (;;)
    {
      localSchedulerConfig.MyW = c.a((a.a)localObject, "XWebCore");
      AppMethodBeat.o(195600);
      return localSchedulerConfig;
      int i = Build.VERSION.SDK_INT;
      a.f[] arrayOff = paramb.Myy;
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
          Log.i("VersionMatcher", "try match version = " + localf.version + " version runtime abi is " + localf.MsC.Mtg);
          if (localf.version < 49)
          {
            Log.i("VersionMatcher", " apk is not support, below 49");
          }
          else
          {
            int k = XWalkEnvironment.getInstalledNewstVersion(localf.MsC.Mtg);
            if (localf.version <= k)
            {
              Log.i("VersionMatcher", " apk is too old, now installed version ".concat(String.valueOf(k)));
            }
            else if (!localf.MsC.gbC())
            {
              Log.i("VersionMatcher", " apk filter out ");
            }
            else
            {
              localObject = localf.MsC.Mtg;
              XWalkUpdater.getLastTryInstallVer((String)localObject);
              if (!"arm64-v8a".equalsIgnoreCase((String)localObject)) {
                "armeabi-v7a".equalsIgnoreCase((String)localObject);
              }
              localObject = localf;
              if (!com.tencent.xweb.internal.a.c.gbF()) {
                break;
              }
              localObject = localf;
              if (localf.MyE) {
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
      label568:
      localSchedulerConfig.MyT = false;
      localSchedulerConfig.Myl = ((a.f)localObject).Myl;
    }
    label587:
    AppMethodBeat.o(195600);
    return null;
  }
  
  private static a.c a(a.f paramf, String paramString)
  {
    AppMethodBeat.i(195601);
    if (paramf.Myq != null)
    {
      paramf = paramf.Myq;
      int j = paramf.length;
      int i = 0;
      while (i < j)
      {
        a.c localc = paramf[i];
        if (localc.MyA == XWalkEnvironment.getInstalledNewstVersion(paramString))
        {
          XWalkInitializer.addXWalkInitializeLog("got matched patch to upgrade " + localc.MyA);
          AppMethodBeat.o(195601);
          return localc;
        }
        i += 1;
      }
    }
    XWalkInitializer.addXWalkInitializeLog("no matched patch");
    AppMethodBeat.o(195601);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.d
 * JD-Core Version:    0.7.0.1
 */