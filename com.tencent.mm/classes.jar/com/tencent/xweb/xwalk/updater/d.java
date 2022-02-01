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
    AppMethodBeat.i(207354);
    if (paramf.SIB != null)
    {
      paramf = paramf.SIB;
      int j = paramf.length;
      int i = 0;
      while (i < j)
      {
        a.c localc = paramf[i];
        if (localc.SIM == XWalkEnvironment.getInstalledNewstVersion(paramString))
        {
          XWalkInitializer.addXWalkInitializeLog("got matched patch to upgrade " + localc.SIM);
          AppMethodBeat.o(207354);
          return localc;
        }
        i += 1;
      }
    }
    XWalkInitializer.addXWalkInitializeLog("no matched patch");
    AppMethodBeat.o(207354);
    return null;
  }
  
  public static c a(a.b paramb, String paramString)
  {
    AppMethodBeat.i(207353);
    c localc = new c();
    com.tencent.xweb.internal.a.c.bsv(paramString);
    Object localObject;
    if ((paramb == null) || (paramb.SIK == null) || (paramb.SIK.length == 0))
    {
      localObject = null;
      com.tencent.xweb.internal.a.c.bsv(null);
      if ((localObject == null) || (((a.f)localObject).version <= XWebCoreInfo.getBackupCoreInfo(paramString).ver)) {
        break label589;
      }
      XWalkInitializer.addXWalkInitializeLog("got matched version");
      localc.SIJ = paramb.SIJ;
      localc.SID = ((a.f)localObject).SID;
      localc.SIG = ((a.f)localObject).SIG;
      localc.SIH = ((a.f)localObject).SIH;
      localc.SII = ((a.f)localObject).SII;
      localc.version = ((a.f)localObject).version;
      localc.SJg = ((a.f)localObject).SIP.SIS;
      localc.SIE = ((a.f)localObject).SIE;
      localc.bUseCdn = ((a.f)localObject).bUseCdn;
      localc.bTryUseSharedCore = ((a.f)localObject).bTryUseSharedCore;
      paramb = a((a.f)localObject, paramString);
      localc.SJe = ((a.f)localObject).SIw;
      localc.strAbi = ((a.f)localObject).SCE.SDk;
      localc.SIv = ((a.f)localObject).SIv;
      localc.SJj = ((a.f)localObject).SIx;
      localc.SJk = ((a.f)localObject).SIy;
      if (paramb == null) {
        break label570;
      }
      localc.SJc = true;
      localc.nPatchTargetVersion = paramb.SIM;
      localc.SIw = paramb.SIw;
      localc.patchMd5 = paramb.SID;
      localc.SIE = paramb.SIE;
      localc.bUseCdn = paramb.bUseCdn;
    }
    for (;;)
    {
      localc.SJf = Scheduler.a((a.a)localObject, "XWebCore");
      AppMethodBeat.o(207353);
      return localc;
      int i = Build.VERSION.SDK_INT;
      a.f[] arrayOff = paramb.SIK;
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
          Log.i("VersionMatcher", "try match version = " + localf.version + " version runtime abi is " + localf.SCE.SDk);
          if (localf.version < 49)
          {
            Log.i("VersionMatcher", " apk is not support, below 49");
          }
          else
          {
            int k = XWalkEnvironment.getInstalledNewstVersion(localf.SCE.SDk);
            if (localf.version <= k)
            {
              Log.i("VersionMatcher", " apk is too old, now installed version ".concat(String.valueOf(k)));
            }
            else if (!localf.SCE.htw())
            {
              Log.i("VersionMatcher", " apk filter out ");
            }
            else
            {
              localObject = localf.SCE.SDk;
              XWalkUpdater.getLastTryInstallVer((String)localObject);
              if (!"arm64-v8a".equalsIgnoreCase((String)localObject)) {
                "armeabi-v7a".equalsIgnoreCase((String)localObject);
              }
              localObject = localf;
              if (!com.tencent.xweb.internal.a.c.htz()) {
                break;
              }
              localObject = localf;
              if (localf.SIQ) {
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
      localc.SJc = false;
      localc.SIw = ((a.f)localObject).SIw;
    }
    label589:
    AppMethodBeat.o(207353);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.d
 * JD-Core Version:    0.7.0.1
 */