package com.tencent.mm.plugin.voip.video.camera.a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.c.a;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.c;
import com.tencent.mm.compatible.deviceinfo.c.a;
import com.tencent.mm.plugin.voip.video.camera.prev.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public final class d
{
  public static b Oal;
  public static int Oam = -1;
  public static int Oan = -1;
  public static int Oao = 0;
  public static int Oap = 0;
  public static int Oaq = 0;
  public static boolean Oar = true;
  public static boolean Oas = false;
  public static int jnv = 0;
  
  public static boolean gDJ()
  {
    return (!af.juH.jpK) || (af.juH.jpJ != 8);
  }
  
  public static boolean gDK()
  {
    AppMethodBeat.i(233519);
    if (!Oas)
    {
      Oar = gDL();
      a locala = a.jnC;
      jnv = a.atL();
      Oas = true;
    }
    boolean bool = Oar;
    AppMethodBeat.o(233519);
    return bool;
  }
  
  private static boolean gDL()
  {
    boolean bool = false;
    AppMethodBeat.i(233520);
    try
    {
      if (Class.forName("android.hardware.Camera").getDeclaredMethod("getNumberOfCameras", null) == null) {
        Log.d("GetfcMethod", "GetfcMethod is null");
      }
      for (;;)
      {
        AppMethodBeat.o(233520);
        return bool;
        bool = true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.CameraUtil", "find getNumberOfCameras failed: " + localException.getMessage());
      }
    }
  }
  
  private static void gDM()
  {
    AppMethodBeat.i(233523);
    Oal.jpH = jnv;
    Object localObject = new Camera.CameraInfo();
    boolean bool;
    int i;
    if ((MultiProcessMMKV.getDefault().decodeBool("clicfg_voip_camera_info_use_cache", false)) || (com.tencent.mm.protocal.d.RAG) || (BuildInfo.DEBUG))
    {
      bool = true;
      Log.i("MicroMsg.CameraUtil", "mCameraNumber = %d, useCache = %b", new Object[] { Integer.valueOf(jnv), Boolean.valueOf(bool) });
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (i < Oal.jpH)
        {
          if (!bool) {
            continue;
          }
          localObject = a.jnC.qJ(i);
          if (((Camera.CameraInfo)localObject).facing != 1) {
            continue;
          }
          if (Oam == -1) {
            continue;
          }
          Log.i("MicroMsg.CameraUtil", "device has other camera id %s in front", new Object[] { Integer.valueOf(i) });
        }
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.CameraUtil", "get camera info error: %s", new Object[] { localException.getMessage() });
        continue;
        Oam = i;
        Oal.OaO = localException.orientation;
        Oal.OaM = true;
        continue;
        if (localException.facing != 0) {
          continue;
        }
        if (Oan == -1) {
          continue;
        }
        Log.i("MicroMsg.CameraUtil", "device has other camera id %s in back", new Object[] { Integer.valueOf(i) });
        continue;
        Oan = i;
        Oal.OaP = localException.orientation;
        Oal.OaN = true;
        continue;
        bool = localException.equalsIgnoreCase("Mediatek");
        continue;
        Oao = 0;
        continue;
        Oap = 0;
        AppMethodBeat.o(233523);
        return;
        i += 1;
      }
      localObject = System.getProperty("ro.media.enc.camera.platform", null);
      if (localObject == null)
      {
        bool = false;
        if ((Oal.OaO != 270) && ((!bool) || (Oal.OaO != 0))) {
          continue;
        }
        Oao = 1;
        if ((Oal.OaP != 270) && ((!bool) || (Oal.OaP != 0))) {
          continue;
        }
        Oap = 1;
        AppMethodBeat.o(233523);
        return;
        bool = false;
        break;
        Camera.getCameraInfo(i, (Camera.CameraInfo)localObject);
        continue;
      }
    }
  }
  
  public static void iL(Context paramContext)
  {
    AppMethodBeat.i(233521);
    if (Oal != null)
    {
      AppMethodBeat.o(233521);
      return;
    }
    Oal = new b("*");
    if ((gDK()) && (!af.juH.jpI))
    {
      gDM();
      if (af.juH.aRO) {
        Oaq = af.juH.jpN;
      }
      Log.i("MicroMsg.CameraUtil", "gCameraNum:" + Oal.jpH + "\ngIsHasFrontCamera:" + Oal.OaM + "\ngIsHasBackCamera:" + Oal.OaN + "\ngFrontCameraId:" + Oam + "\ngBackCameraId:" + Oan + "\ngBackOrientation:" + Oal.OaP + "\ngFrontOrientation:" + Oal.OaO + "\ngBestFps:" + Oal.OaL + "\ngFacePreviewSize:" + Oal.OaQ + "\ngNonFacePreviewSize:" + Oal.OaR + "\ngFaceCameraIsRotate180:" + Oao + "\ngMainCameraIsRotate180:" + Oap + "\ngCameraFormat:" + Oaq + "\ngFaceNotRotate:SDK:" + Build.VERSION.SDK_INT + "\n");
      AppMethodBeat.o(233521);
      return;
    }
    if ((gDK()) && (af.juH.jpI)) {
      gDM();
    }
    Log.i("MicroMsg.CameraUtil", "initDeviceFromServerConf");
    if (af.juH.jpI)
    {
      Log.i("MicroMsg.CameraUtil", "initDeviceFromServerConf setCameraNum %d", new Object[] { Integer.valueOf(af.juH.jpH) });
      Oal.jpH = af.juH.jpH;
    }
    if (af.juH.jpR)
    {
      if (af.juH.jpQ.jqz != 0) {
        Oal.OaN = true;
      }
    }
    else {
      label378:
      if (af.juH.jpP) {
        if (af.juH.jpO.jqz == 0) {
          break label754;
        }
      }
    }
    label754:
    for (Oal.OaM = true;; Oal.OaM = false)
    {
      if ((af.juH.jpP) && (af.juH.jpO.jqA >= 0))
      {
        Oal.OaO = af.juH.jpO.jqA;
        Oao = Oal.OaO;
      }
      if ((af.juH.jpR) && (af.juH.jpQ.jqA >= 0))
      {
        Oal.OaP = af.juH.jpQ.jqA;
        Oap = Oal.OaP;
      }
      if (af.juH.jpP)
      {
        if (Oal.OaQ == null) {
          Oal.OaQ = new Point(0, 0);
        }
        Oal.OaQ = new Point(af.juH.jpO.width, af.juH.jpO.height);
      }
      if (af.juH.jpR)
      {
        if (Oal.OaR == null) {
          Oal.OaR = new Point(0, 0);
        }
        Oal.OaR = new Point(af.juH.jpQ.width, af.juH.jpQ.height);
      }
      if ((af.juH.jpR) && (af.juH.jpQ.fps != 0)) {
        Oal.OaL = af.juH.jpQ.fps;
      }
      if ((af.juH.jpP) && (af.juH.jpO.fps != 0)) {
        Oal.OaL = af.juH.jpO.fps;
      }
      paramContext = paramContext.getPackageManager();
      if ((af.juH.jpI) || (paramContext.hasSystemFeature("android.hardware.camera"))) {
        break;
      }
      Oal.jpH = 0;
      Oal.OaM = false;
      Oal.OaN = false;
      break;
      Oal.OaN = false;
      break label378;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.camera.a.d
 * JD-Core Version:    0.7.0.1
 */