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
import com.tencent.mm.sdk.platformtools.ac;

public final class j
{
  public static g APb;
  public static int APc = -1;
  public static int APd = -1;
  public static int APe = 0;
  public static int APf = 0;
  public static int APg = 0;
  public static boolean APh = true;
  
  public static boolean emK()
  {
    return (!ae.fJd.fEE) || (ae.fJd.fED != 8);
  }
  
  private static boolean emL()
  {
    boolean bool = false;
    AppMethodBeat.i(115697);
    try
    {
      if (Class.forName("android.hardware.Camera").getDeclaredMethod("getNumberOfCameras", null) == null) {
        ac.d("GetfcMethod", "GetfcMethod is null");
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
        ac.e("MicroMsg.CameraUtil", "find getNumberOfCameras failed: " + localException.getMessage());
      }
    }
  }
  
  private static void emM()
  {
    AppMethodBeat.i(115699);
    APb.fEB = Camera.getNumberOfCameras();
    Object localObject = new Camera.CameraInfo();
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < APb.fEB)
        {
          Camera.getCameraInfo(i, (Camera.CameraInfo)localObject);
          if (((Camera.CameraInfo)localObject).facing != 1) {
            continue;
          }
          if (APc != -1) {
            ac.d("MicroMsg.CameraUtil", "device has other camera id %s in front", new Object[] { Integer.valueOf(i) });
          }
        }
        else
        {
          localObject = System.getProperty("ro.media.enc.camera.platform", null);
          if (localObject != null) {
            continue;
          }
          bool = false;
          if ((APb.ANJ != 270) && ((!bool) || (APb.ANJ != 0))) {
            continue;
          }
          APe = 1;
          if ((APb.ANK != 270) && ((!bool) || (APb.ANK != 0))) {
            continue;
          }
          APf = 1;
          AppMethodBeat.o(115699);
          return;
        }
        APc = i;
        APb.ANJ = ((Camera.CameraInfo)localObject).orientation;
        APb.ANH = true;
        continue;
        if (((Camera.CameraInfo)localObject).facing == 0) {
          if (APd != -1)
          {
            ac.d("MicroMsg.CameraUtil", "device has other camera id %s in back", new Object[] { Integer.valueOf(i) });
            continue;
          }
        }
      }
      catch (Exception localException)
      {
        ac.e("MicroMsg.CameraUtil", "get camera info error: %s", new Object[] { localException.getMessage() });
        continue;
        APd = i;
        APb.ANK = localException.orientation;
        APb.ANI = true;
        continue;
        boolean bool = localException.equalsIgnoreCase("Mediatek");
        continue;
        APe = 0;
        continue;
        APf = 0;
        AppMethodBeat.o(115699);
        return;
        i += 1;
      }
    }
  }
  
  public static void gD(Context paramContext)
  {
    AppMethodBeat.i(115698);
    if (APb != null)
    {
      AppMethodBeat.o(115698);
      return;
    }
    APb = new g("*");
    boolean bool = emL();
    APh = bool;
    if ((bool) && (!ae.fJd.fEC))
    {
      emM();
      if (ae.fJd.aXS) {
        APg = ae.fJd.fEH;
      }
      ac.i("MicroMsg.CameraUtil", "gCameraNum:" + APb.fEB + "\ngIsHasFrontCamera:" + APb.ANH + "\ngIsHasBackCamera:" + APb.ANI + "\ngFrontCameraId:" + APc + "\ngBackCameraId:" + APd + "\ngBackOrientation:" + APb.ANK + "\ngFrontOrientation:" + APb.ANJ + "\ngBestFps:" + APb.ANG + "\ngFacePreviewSize:" + APb.ANL + "\ngNonFacePreviewSize:" + APb.ANM + "\ngFaceCameraIsRotate180:" + APe + "\ngMainCameraIsRotate180:" + APf + "\ngCameraFormat:" + APg + "\ngFaceNotRotate:SDK:" + Build.VERSION.SDK_INT + "\n");
      AppMethodBeat.o(115698);
      return;
    }
    if ((APh) && (ae.fJd.fEC)) {
      emM();
    }
    if (ae.fJd.fEC) {
      APb.fEB = ae.fJd.fEB;
    }
    if (ae.fJd.fEL)
    {
      if (ae.fJd.fEK.fFp != 0) {
        APb.ANI = true;
      }
    }
    else {
      label339:
      if (ae.fJd.fEJ) {
        if (ae.fJd.fEI.fFp == 0) {
          break label715;
        }
      }
    }
    label715:
    for (APb.ANH = true;; APb.ANH = false)
    {
      if ((ae.fJd.fEJ) && (ae.fJd.fEI.fFq >= 0))
      {
        APb.ANJ = ae.fJd.fEI.fFq;
        APe = APb.ANJ;
      }
      if ((ae.fJd.fEL) && (ae.fJd.fEK.fFq >= 0))
      {
        APb.ANK = ae.fJd.fEK.fFq;
        APf = APb.ANK;
      }
      if (ae.fJd.fEJ)
      {
        if (APb.ANL == null) {
          APb.ANL = new Point(0, 0);
        }
        APb.ANL = new Point(ae.fJd.fEI.width, ae.fJd.fEI.height);
      }
      if (ae.fJd.fEL)
      {
        if (APb.ANM == null) {
          APb.ANM = new Point(0, 0);
        }
        APb.ANM = new Point(ae.fJd.fEK.width, ae.fJd.fEK.height);
      }
      if ((ae.fJd.fEL) && (ae.fJd.fEK.fps != 0)) {
        APb.ANG = ae.fJd.fEK.fps;
      }
      if ((ae.fJd.fEJ) && (ae.fJd.fEI.fps != 0)) {
        APb.ANG = ae.fJd.fEI.fps;
      }
      paramContext = paramContext.getPackageManager();
      if ((ae.fJd.fEC) || (paramContext.hasSystemFeature("android.hardware.camera"))) {
        break;
      }
      APb.fEB = 0;
      APb.ANH = false;
      APb.ANI = false;
      break;
      APb.ANI = false;
      break label339;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.j
 * JD-Core Version:    0.7.0.1
 */