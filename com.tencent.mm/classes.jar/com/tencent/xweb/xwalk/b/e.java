package com.tencent.xweb.xwalk.b;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.xwalk.XWalkUpdater;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWebCoreInfo;

public final class e
{
  private static a.c a(a.f paramf, String paramString)
  {
    AppMethodBeat.i(204569);
    if (paramf.aakt != null)
    {
      paramf = paramf.aakt;
      int j = paramf.length;
      int i = 0;
      while (i < j)
      {
        a.c localc = paramf[i];
        if (localc.aakE == XWalkEnvironment.getInstalledNewstVersion(paramString))
        {
          XWalkInitializer.addXWalkInitializeLog("got matched patch to upgrade " + localc.aakE);
          AppMethodBeat.o(204569);
          return localc;
        }
        i += 1;
      }
    }
    XWalkInitializer.addXWalkInitializeLog("no matched patch");
    AppMethodBeat.o(204569);
    return null;
  }
  
  public static d a(a.b paramb, String paramString)
  {
    AppMethodBeat.i(204568);
    d locald = new d();
    com.tencent.xweb.internal.a.c.bFu(paramString);
    Object localObject;
    if ((paramb == null) || (paramb.aakC == null) || (paramb.aakC.length == 0))
    {
      localObject = null;
      com.tencent.xweb.internal.a.c.bFu(null);
      if ((localObject == null) || (((a.f)localObject).version <= XWebCoreInfo.getBackupCoreInfo(paramString).ver)) {
        break label590;
      }
      XWalkInitializer.addXWalkInitializeLog("got matched version");
      locald.aakB = paramb.aakB;
      locald.aakv = ((a.f)localObject).aakv;
      locald.aaky = ((a.f)localObject).aaky;
      locald.aakz = ((a.f)localObject).aakz;
      locald.aakA = ((a.f)localObject).aakA;
      locald.version = ((a.f)localObject).version;
      locald.aakY = ((a.f)localObject).aakH.aakK;
      locald.aakw = ((a.f)localObject).aakw;
      locald.aajx = ((a.f)localObject).aajx;
      locald.aajy = ((a.f)localObject).aajy;
      paramb = a((a.f)localObject, paramString);
      locald.aakW = ((a.f)localObject).aako;
      locald.strAbi = ((a.f)localObject).aadO.aaeu;
      locald.aakn = ((a.f)localObject).aakn;
      locald.aalb = ((a.f)localObject).aakp;
      locald.aalc = ((a.f)localObject).aakq;
      if (paramb == null) {
        break label571;
      }
      locald.aakU = true;
      locald.aajt = paramb.aakE;
      locald.aako = paramb.aako;
      locald.patchMd5 = paramb.aakv;
      locald.aakw = paramb.aakw;
      locald.aajx = paramb.aajx;
    }
    for (;;)
    {
      locald.aakX = c.a((a.a)localObject, "XWebCore");
      AppMethodBeat.o(204568);
      return locald;
      int i = Build.VERSION.SDK_INT;
      a.f[] arrayOff = paramb.aakC;
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
          Log.i("VersionMatcher", "try match version = " + localf.version + " version runtime abi is " + localf.aadO.aaeu);
          if (localf.version < 2000)
          {
            Log.i("VersionMatcher", " apk is not support, below 49");
          }
          else
          {
            int k = XWalkEnvironment.getInstalledNewstVersion(localf.aadO.aaeu);
            if (localf.version <= k)
            {
              Log.i("VersionMatcher", " apk is too old, now installed version ".concat(String.valueOf(k)));
            }
            else if (!localf.aadO.ixf())
            {
              Log.i("VersionMatcher", " apk filter out ");
            }
            else
            {
              localObject = localf.aadO.aaeu;
              XWalkUpdater.bFP((String)localObject);
              if (!"arm64-v8a".equalsIgnoreCase((String)localObject)) {
                "armeabi-v7a".equalsIgnoreCase((String)localObject);
              }
              localObject = localf;
              if (!com.tencent.xweb.internal.a.c.ixi()) {
                break;
              }
              localObject = localf;
              if (localf.aakI) {
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
      label571:
      locald.aakU = false;
      locald.aako = ((a.f)localObject).aako;
    }
    label590:
    AppMethodBeat.o(204568);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.b.e
 * JD-Core Version:    0.7.0.1
 */