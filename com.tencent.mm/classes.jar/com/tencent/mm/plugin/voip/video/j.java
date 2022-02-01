package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.c;
import com.tencent.mm.compatible.deviceinfo.c.a;
import com.tencent.mm.sdk.platformtools.ad;

public final class j
{
  public static g zwk;
  public static int zwl = -1;
  public static int zwm = -1;
  public static int zwn = 0;
  public static int zwo = 0;
  public static int zwp = 0;
  public static boolean zwq = true;
  
  public static boolean dXp()
  {
    return (!ae.fFw.fAX) || (ae.fFw.fAW != 8);
  }
  
  private static boolean dXq()
  {
    boolean bool = false;
    AppMethodBeat.i(115697);
    try
    {
      if (Class.forName("android.hardware.Camera").getDeclaredMethod("getNumberOfCameras", null) == null) {
        ad.d("GetfcMethod", "GetfcMethod is null");
      }
      for (;;)
      {
        AppMethodBeat.o(115697);
        return bool;
        bool = true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.CameraUtil", "find getNumberOfCameras failed: " + localException.getMessage());
      }
    }
  }
  
  private static void dXr()
  {
    AppMethodBeat.i(115699);
    zwk.fAU = Camera.getNumberOfCameras();
    Object localObject = new Camera.CameraInfo();
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < zwk.fAU)
        {
          Camera.getCameraInfo(i, (Camera.CameraInfo)localObject);
          if (((Camera.CameraInfo)localObject).facing != 1) {
            continue;
          }
          if (zwl != -1) {
            ad.d("MicroMsg.CameraUtil", "device has other camera id %s in front", new Object[] { Integer.valueOf(i) });
          }
        }
        else
        {
          localObject = System.getProperty("ro.media.enc.camera.platform", null);
          if (localObject != null) {
            continue;
          }
          bool = false;
          if ((zwk.zuR != 270) && ((!bool) || (zwk.zuR != 0))) {
            continue;
          }
          zwn = 1;
          if ((zwk.zuS != 270) && ((!bool) || (zwk.zuS != 0))) {
            continue;
          }
          zwo = 1;
          AppMethodBeat.o(115699);
          return;
        }
        zwl = i;
        zwk.zuR = ((Camera.CameraInfo)localObject).orientation;
        zwk.zuP = true;
        continue;
        if (((Camera.CameraInfo)localObject).facing == 0) {
          if (zwm != -1)
          {
            ad.d("MicroMsg.CameraUtil", "device has other camera id %s in back", new Object[] { Integer.valueOf(i) });
            continue;
          }
        }
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.CameraUtil", "get camera info error: %s", new Object[] { localException.getMessage() });
        continue;
        zwm = i;
        zwk.zuS = localException.orientation;
        zwk.zuQ = true;
        continue;
        boolean bool = localException.equalsIgnoreCase("Mediatek");
        continue;
        zwn = 0;
        continue;
        zwo = 0;
        AppMethodBeat.o(115699);
        return;
        i += 1;
      }
    }
  }
  
  public static void gr(Context paramContext)
  {
    AppMethodBeat.i(115698);
    if (zwk != null)
    {
      AppMethodBeat.o(115698);
      return;
    }
    zwk = new g("*");
    boolean bool = dXq();
    zwq = bool;
    if ((bool) && (!ae.fFw.fAV))
    {
      dXr();
      if (ae.fFw.aXg) {
        zwp = ae.fFw.fBa;
      }
      ad.i("MicroMsg.CameraUtil", "gCameraNum:" + zwk.fAU + "\ngIsHasFrontCamera:" + zwk.zuP + "\ngIsHasBackCamera:" + zwk.zuQ + "\ngFrontCameraId:" + zwl + "\ngBackCameraId:" + zwm + "\ngBackOrientation:" + zwk.zuS + "\ngFrontOrientation:" + zwk.zuR + "\ngBestFps:" + zwk.zuO + "\ngFacePreviewSize:" + zwk.zuT + "\ngNonFacePreviewSize:" + zwk.zuU + "\ngFaceCameraIsRotate180:" + zwn + "\ngMainCameraIsRotate180:" + zwo + "\ngCameraFormat:" + zwp + "\ngFaceNotRotate:SDK:" + Build.VERSION.SDK_INT + "\n");
      AppMethodBeat.o(115698);
      return;
    }
    if ((zwq) && (ae.fFw.fAV)) {
      dXr();
    }
    if (ae.fFw.fAV) {
      zwk.fAU = ae.fFw.fAU;
    }
    if (ae.fFw.fBe)
    {
      if (ae.fFw.fBd.fBI != 0) {
        zwk.zuQ = true;
      }
    }
    else {
      label339:
      if (ae.fFw.fBc) {
        if (ae.fFw.fBb.fBI == 0) {
          break label715;
        }
      }
    }
    label715:
    for (zwk.zuP = true;; zwk.zuP = false)
    {
      if ((ae.fFw.fBc) && (ae.fFw.fBb.fBJ >= 0))
      {
        zwk.zuR = ae.fFw.fBb.fBJ;
        zwn = zwk.zuR;
      }
      if ((ae.fFw.fBe) && (ae.fFw.fBd.fBJ >= 0))
      {
        zwk.zuS = ae.fFw.fBd.fBJ;
        zwo = zwk.zuS;
      }
      if (ae.fFw.fBc)
      {
        if (zwk.zuT == null) {
          zwk.zuT = new Point(0, 0);
        }
        zwk.zuT = new Point(ae.fFw.fBb.width, ae.fFw.fBb.height);
      }
      if (ae.fFw.fBe)
      {
        if (zwk.zuU == null) {
          zwk.zuU = new Point(0, 0);
        }
        zwk.zuU = new Point(ae.fFw.fBd.width, ae.fFw.fBd.height);
      }
      if ((ae.fFw.fBe) && (ae.fFw.fBd.fps != 0)) {
        zwk.zuO = ae.fFw.fBd.fps;
      }
      if ((ae.fFw.fBc) && (ae.fFw.fBb.fps != 0)) {
        zwk.zuO = ae.fFw.fBb.fps;
      }
      paramContext = paramContext.getPackageManager();
      if ((ae.fFw.fAV) || (paramContext.hasSystemFeature("android.hardware.camera"))) {
        break;
      }
      zwk.fAU = 0;
      zwk.zuP = false;
      zwk.zuQ = false;
      break;
      zwk.zuQ = false;
      break label339;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.j
 * JD-Core Version:    0.7.0.1
 */