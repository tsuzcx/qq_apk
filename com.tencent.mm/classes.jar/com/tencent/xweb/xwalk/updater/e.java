package com.tencent.xweb.xwalk.updater;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.b.a;
import com.tencent.xweb.internal.b.c;
import com.tencent.xweb.internal.b.d;
import com.tencent.xweb.internal.b.e;
import com.tencent.xweb.internal.b.h;
import com.tencent.xweb.internal.b.i;
import com.tencent.xweb.util.b;
import com.tencent.xweb.xwalk.o;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkGrayValueUtil;

public final class e
{
  private String source;
  
  private b.e a(b.h paramh, String paramString)
  {
    AppMethodBeat.i(213030);
    if (paramh.aiiH != null)
    {
      paramh = paramh.aiiH;
      int j = paramh.length;
      int i = 0;
      while (i < j)
      {
        b.e locale = paramh[i];
        if (locale.aijH == XWalkEnvironment.getInstalledNewstVersion(paramString))
        {
          Log.i(getLogTag(), "getMatchedPatch, got matched patch to upgrade to version:" + locale.aijH);
          AppMethodBeat.o(213030);
          return locale;
        }
        i += 1;
      }
    }
    Log.i(getLogTag(), "getMatchedPatch, no matched patch");
    AppMethodBeat.o(213030);
    return null;
  }
  
  private String getLogTag()
  {
    AppMethodBeat.i(213025);
    if (this.source != null)
    {
      String str = "VersionMatcher(" + this.source + "|" + hashCode() + ")";
      AppMethodBeat.o(213025);
      return str;
    }
    AppMethodBeat.o(213025);
    return "VersionMatcher";
  }
  
  public final d a(b.c paramc, String paramString, c paramc1)
  {
    AppMethodBeat.i(213041);
    this.source = paramc1.TAG;
    d locald = new d();
    Object localObject;
    if ((paramc == null) || (paramc.aiiV == null) || (paramc.aiiV.length == 0))
    {
      Log.i(getLogTag(), "invalid config");
      localObject = null;
      if (localObject == null) {
        break label699;
      }
      Log.i(getLogTag(), "getMatchedSchedulerConfig, got matched version:" + ((b.h)localObject).version);
      locald.aiiU = paramc.aiiU;
      locald.aiiJ = ((b.h)localObject).aiiJ;
      locald.aiiN = ((b.h)localObject).aiiN;
      locald.aiiO = ((b.h)localObject).aiiO;
      locald.aiiP = ((b.h)localObject).aiiP;
      locald.version = ((b.h)localObject).version;
      locald.aiqC = ((b.h)localObject).aijK.aijO;
      locald.aiiK = ((b.h)localObject).aiiK;
      locald.aiiL = ((b.h)localObject).aiiL;
      locald.aijL = ((b.h)localObject).aijL;
      paramc = a((b.h)localObject, paramString);
      locald.aiqA = ((b.h)localObject).aiiC;
      locald.strAbi = ((b.h)localObject).aiiB.aijz;
      locald.aiiA = ((b.h)localObject).aiiA;
      locald.aiqF = ((b.h)localObject).aiiD;
      locald.aiqG = ((b.h)localObject).aiiE;
      if (paramc == null) {
        break label680;
      }
      locald.aiqx = true;
      locald.aiqy = paramc.aijH;
      locald.aiiC = paramc.aiiC;
      locald.patchMd5 = paramc.aiiJ;
      locald.aiiK = paramc.aiiK;
      locald.aiiL = paramc.aiiL;
    }
    for (;;)
    {
      locald.aiqB = c.a((b.a)localObject, paramc1.TAG);
      AppMethodBeat.o(213041);
      return locald;
      b.h[] arrayOfh = paramc.aiiV;
      int k = arrayOfh.length;
      int i = 0;
      if (i < k)
      {
        b.h localh = arrayOfh[i];
        if (localh == null) {
          Log.i(getLogTag(), "invalid version");
        }
        for (;;)
        {
          label367:
          i += 1;
          break;
          Log.i(getLogTag(), "try match version:" + localh.version + ", filter:" + localh.aiiB);
          if ((!XWalkGrayValueUtil.hasUin()) && (localh.aiiQ))
          {
            Log.i(getLogTag(), "forbid download when no uin and currently has no uin");
          }
          else if (localh.version < 2000)
          {
            Log.i(getLogTag(), "version is not support, below SDK_SUPPORT_MIN_APKVERSION");
          }
          else
          {
            j = XWalkEnvironment.getInstalledNewstVersion(localh.aiiB.aijz);
            if (localh.version <= j)
            {
              Log.i(getLogTag(), "version is too old, current version:".concat(String.valueOf(j)));
            }
            else
            {
              localh.aiiB.aijG = paramString;
              if (localh.aiiB.g(false, true, paramc1.TAG)) {
                break label546;
              }
              Log.i(getLogTag(), "version filter out");
            }
          }
        }
        label546:
        localObject = localh.aiiB.aijz;
        o.bIo((String)localObject);
        if (!"arm64-v8a".equalsIgnoreCase((String)localObject)) {
          "armeabi-v7a".equalsIgnoreCase((String)localObject);
        }
        localObject = localh.aiiB;
        if (!b.khw().equalsIgnoreCase(((b.d)localObject).aijG)) {}
        for (int j = 1;; j = 0)
        {
          localObject = localh;
          if (j == 0) {
            break;
          }
          localObject = localh;
          if (localh.aijM) {
            break;
          }
          Log.i(getLogTag(), "version.supportPredown is false, version:" + localh.version);
          break label367;
        }
      }
      Log.i(getLogTag(), "getMatchedVersion, no matched version");
      localObject = null;
      break;
      label680:
      locald.aiqx = false;
      locald.aiiC = ((b.h)localObject).aiiC;
    }
    label699:
    AppMethodBeat.o(213041);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.e
 * JD-Core Version:    0.7.0.1
 */