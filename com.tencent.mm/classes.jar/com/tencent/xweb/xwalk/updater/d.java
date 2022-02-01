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
    AppMethodBeat.i(208960);
    SchedulerConfig localSchedulerConfig = new SchedulerConfig();
    com.tencent.xweb.internal.a.c.aVf(paramString);
    Object localObject1;
    if ((paramb == null) || (paramb.KHV == null) || (paramb.KHV.length == 0))
    {
      localObject1 = null;
      com.tencent.xweb.internal.a.c.aVf(null);
      if ((localObject1 == null) || (((a.f)localObject1).version <= XWebCoreInfo.getBackupCoreInfo(paramString).ver)) {
        break label518;
      }
      XWalkInitializer.addXWalkInitializeLog("got matched version");
      localSchedulerConfig.KHU = paramb.KHU;
      localSchedulerConfig.KHS = ((a.f)localObject1).KHS;
      localSchedulerConfig.version = ((a.f)localObject1).version;
      localSchedulerConfig.KIs = ((a.f)localObject1).KIa.KIc;
      localSchedulerConfig.KHT = ((a.f)localObject1).KHT;
      localSchedulerConfig.bUseCdn = ((a.f)localObject1).bUseCdn;
      localSchedulerConfig.bTryUseSharedCore = ((a.f)localObject1).bTryUseSharedCore;
      paramb = a((a.f)localObject1, paramString);
      localSchedulerConfig.KIq = ((a.f)localObject1).KHL;
      localSchedulerConfig.strAbi = ((a.f)localObject1).KCh.KCH;
      localSchedulerConfig.KHK = ((a.f)localObject1).KHK;
      localSchedulerConfig.KIv = ((a.f)localObject1).KHM;
      localSchedulerConfig.KIw = ((a.f)localObject1).KHN;
      if (paramb == null) {
        break label499;
      }
      localSchedulerConfig.KIp = true;
      localSchedulerConfig.nPatchTargetVersion = paramb.KHX;
      localSchedulerConfig.KHL = paramb.KHL;
      localSchedulerConfig.patchMd5 = paramb.KHS;
      localSchedulerConfig.KHT = paramb.KHT;
      localSchedulerConfig.bUseCdn = paramb.bUseCdn;
    }
    for (;;)
    {
      localSchedulerConfig.KIr = c.a((a.a)localObject1, "XWebCore");
      AppMethodBeat.o(208960);
      return localSchedulerConfig;
      int i = Build.VERSION.SDK_INT;
      localObject1 = paramb.KHV;
      int j = localObject1.length;
      i = 0;
      if (i < j)
      {
        Object localObject2 = localObject1[i];
        if (localObject2 == null) {
          XWalkInitializer.addXWalkInitializeLog("no matched version  version == null");
        }
        for (;;)
        {
          i += 1;
          break;
          Log.i("VersionMatcher", "try match version = " + localObject2.version + " version runtime abi is " + localObject2.KCh.KCH);
          if (localObject2.version < 49)
          {
            Log.i("VersionMatcher", " apk is not support, below 49");
          }
          else
          {
            int k = XWalkEnvironment.getInstalledNewstVersion(localObject2.KCh.KCH);
            if (localObject2.version <= k)
            {
              Log.i("VersionMatcher", " apk is too old, now installed version ".concat(String.valueOf(k)));
            }
            else
            {
              if (localObject2.KCh.fKi()) {
                break label443;
              }
              Log.i("VersionMatcher", " apk filter out ");
            }
          }
        }
        label443:
        String str = localObject2.KCh.KCH;
        XWalkUpdater.getLastTryInstallVer(str);
        localObject1 = localObject2;
        if ("arm64-v8a".equalsIgnoreCase(str)) {
          break;
        }
        "armeabi-v7a".equalsIgnoreCase(str);
        localObject1 = localObject2;
        break;
      }
      XWalkInitializer.addXWalkInitializeLog("no matched version");
      localObject1 = null;
      break;
      label499:
      localSchedulerConfig.KIp = false;
      localSchedulerConfig.KHL = ((a.f)localObject1).KHL;
    }
    label518:
    AppMethodBeat.o(208960);
    return null;
  }
  
  private static a.c a(a.f paramf, String paramString)
  {
    AppMethodBeat.i(208961);
    if (paramf.KHQ != null)
    {
      paramf = paramf.KHQ;
      int j = paramf.length;
      int i = 0;
      while (i < j)
      {
        a.c localc = paramf[i];
        if (localc.KHX == XWalkEnvironment.getInstalledNewstVersion(paramString))
        {
          XWalkInitializer.addXWalkInitializeLog("got matched patch to upgrade " + localc.KHX);
          AppMethodBeat.o(208961);
          return localc;
        }
        i += 1;
      }
    }
    XWalkInitializer.addXWalkInitializeLog("no matched patch");
    AppMethodBeat.o(208961);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.d
 * JD-Core Version:    0.7.0.1
 */