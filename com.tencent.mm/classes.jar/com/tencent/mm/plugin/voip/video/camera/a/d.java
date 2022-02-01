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
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;

public final class d
{
  public static b UOi;
  public static int UOj = -1;
  public static int UOk = -1;
  public static int UOl = 0;
  public static int UOm = 0;
  public static int UOn = 0;
  public static boolean UOo = true;
  public static boolean UOp = false;
  public static int lQG = 0;
  
  public static boolean icD()
  {
    return (!af.lXY.lSS) || (af.lXY.lSR != 8);
  }
  
  public static boolean icE()
  {
    AppMethodBeat.i(292932);
    if (!UOp)
    {
      UOo = icF();
      a locala = a.lQF;
      lQG = a.aOk();
      UOp = true;
    }
    boolean bool = UOo;
    AppMethodBeat.o(292932);
    return bool;
  }
  
  private static boolean icF()
  {
    boolean bool = false;
    AppMethodBeat.i(292937);
    try
    {
      if (Class.forName("android.hardware.Camera").getDeclaredMethod("getNumberOfCameras", null) == null) {
        Log.d("GetfcMethod", "GetfcMethod is null");
      }
      for (;;)
      {
        AppMethodBeat.o(292937);
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
  
  private static void icG()
  {
    AppMethodBeat.i(292953);
    UOi.lSP = lQG;
    Object localObject = new Camera.CameraInfo();
    boolean bool;
    int i;
    if ((MultiProcessMMKV.getDefault().decodeBool("clicfg_voip_camera_info_use_cache_new", true)) || (com.tencent.mm.protocal.d.Yxk) || (BuildInfo.DEBUG))
    {
      bool = true;
      Log.i("MicroMsg.CameraUtil", "mCameraNumber = %d, useCache = %b", new Object[] { Integer.valueOf(lQG), Boolean.valueOf(bool) });
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (i < UOi.lSP)
        {
          if (!bool) {
            continue;
          }
          localObject = a.lQF.qP(i);
          k = ((Camera.CameraInfo)localObject).facing;
          j = ((Camera.CameraInfo)localObject).orientation;
          h.ahAA.g(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(292926);
              Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
              Camera.getCameraInfo(this.vMV, localCameraInfo);
              a locala = a.lQF;
              a.a(this.vMV, localCameraInfo);
              AppMethodBeat.o(292926);
            }
          }, "initDeviceFromAPI-checkCache");
          if (k != 1) {
            continue;
          }
          if (UOj == -1) {
            continue;
          }
          Log.i("MicroMsg.CameraUtil", "device has other camera id %s in front", new Object[] { Integer.valueOf(i) });
        }
      }
      catch (Exception localException)
      {
        int k;
        int j;
        Log.e("MicroMsg.CameraUtil", "get camera info error: %s", new Object[] { localException.getMessage() });
        continue;
        UOk = i;
        UOi.UOM = j;
        UOi.UOK = true;
        continue;
        bool = localException.equalsIgnoreCase("Mediatek");
        continue;
        UOl = 0;
        continue;
        UOm = 0;
        AppMethodBeat.o(292953);
        return;
        i += 1;
      }
      localObject = System.getProperty("ro.media.enc.camera.platform", null);
      if (localObject == null)
      {
        bool = false;
        if ((UOi.UOL != 270) && ((!bool) || (UOi.UOL != 0))) {
          continue;
        }
        UOl = 1;
        if ((UOi.UOM != 270) && ((!bool) || (UOi.UOM != 0))) {
          continue;
        }
        UOm = 1;
        AppMethodBeat.o(292953);
        return;
        bool = false;
        break;
        Camera.getCameraInfo(i, (Camera.CameraInfo)localObject);
        k = ((Camera.CameraInfo)localObject).facing;
        j = ((Camera.CameraInfo)localObject).orientation;
        continue;
        UOj = i;
        UOi.UOL = j;
        UOi.UOJ = true;
        continue;
        if (k != 0) {
          continue;
        }
        if (UOk != -1)
        {
          Log.i("MicroMsg.CameraUtil", "device has other camera id %s in back", new Object[] { Integer.valueOf(i) });
          continue;
        }
      }
    }
  }
  
  public static void kC(Context paramContext)
  {
    AppMethodBeat.i(292948);
    if (UOi != null)
    {
      AppMethodBeat.o(292948);
      return;
    }
    UOi = new b("*");
    if ((icE()) && (!af.lXY.lSQ))
    {
      icG();
      if (af.lXY.cLK) {
        UOn = af.lXY.IX;
      }
      Log.i("MicroMsg.CameraUtil", "gCameraNum:" + UOi.lSP + "\ngIsHasFrontCamera:" + UOi.UOJ + "\ngIsHasBackCamera:" + UOi.UOK + "\ngFrontCameraId:" + UOj + "\ngBackCameraId:" + UOk + "\ngBackOrientation:" + UOi.UOM + "\ngFrontOrientation:" + UOi.UOL + "\ngBestFps:" + UOi.UOI + "\ngFacePreviewSize:" + UOi.UON + "\ngNonFacePreviewSize:" + UOi.UOO + "\ngFaceCameraIsRotate180:" + UOl + "\ngMainCameraIsRotate180:" + UOm + "\ngCameraFormat:" + UOn + "\ngFaceNotRotate:SDK:" + Build.VERSION.SDK_INT + "\n");
      AppMethodBeat.o(292948);
      return;
    }
    if ((icE()) && (af.lXY.lSQ)) {
      icG();
    }
    Log.i("MicroMsg.CameraUtil", "initDeviceFromServerConf");
    if (af.lXY.lSQ)
    {
      Log.i("MicroMsg.CameraUtil", "initDeviceFromServerConf setCameraNum %d", new Object[] { Integer.valueOf(af.lXY.lSP) });
      UOi.lSP = af.lXY.lSP;
    }
    if (af.lXY.lSY)
    {
      if (af.lXY.lSX.lTH != 0) {
        UOi.UOK = true;
      }
    }
    else {
      label380:
      if (af.lXY.lSW) {
        if (af.lXY.lSV.lTH == 0) {
          break label756;
        }
      }
    }
    label756:
    for (UOi.UOJ = true;; UOi.UOJ = false)
    {
      if ((af.lXY.lSW) && (af.lXY.lSV.lTI >= 0))
      {
        UOi.UOL = af.lXY.lSV.lTI;
        UOl = UOi.UOL;
      }
      if ((af.lXY.lSY) && (af.lXY.lSX.lTI >= 0))
      {
        UOi.UOM = af.lXY.lSX.lTI;
        UOm = UOi.UOM;
      }
      if (af.lXY.lSW)
      {
        if (UOi.UON == null) {
          UOi.UON = new Point(0, 0);
        }
        UOi.UON = new Point(af.lXY.lSV.width, af.lXY.lSV.height);
      }
      if (af.lXY.lSY)
      {
        if (UOi.UOO == null) {
          UOi.UOO = new Point(0, 0);
        }
        UOi.UOO = new Point(af.lXY.lSX.width, af.lXY.lSX.height);
      }
      if ((af.lXY.lSY) && (af.lXY.lSX.fps != 0)) {
        UOi.UOI = af.lXY.lSX.fps;
      }
      if ((af.lXY.lSW) && (af.lXY.lSV.fps != 0)) {
        UOi.UOI = af.lXY.lSV.fps;
      }
      paramContext = paramContext.getPackageManager();
      if ((af.lXY.lSQ) || (paramContext.hasSystemFeature("android.hardware.camera"))) {
        break;
      }
      UOi.lSP = 0;
      UOi.UOJ = false;
      UOi.UOK = false;
      break;
      UOi.UOK = false;
      break label380;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.camera.a.d
 * JD-Core Version:    0.7.0.1
 */