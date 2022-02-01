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
  public static int CoA = 0;
  public static int CoB = 0;
  public static boolean CoC = true;
  public static g Cow;
  public static int Cox = -1;
  public static int Coy = -1;
  public static int Coz = 0;
  
  public static boolean eAI()
  {
    return (!ae.gcE.fYd) || (ae.gcE.fYc != 8);
  }
  
  private static boolean eAJ()
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
  
  private static void eAK()
  {
    AppMethodBeat.i(115699);
    Cow.fYa = Camera.getNumberOfCameras();
    Object localObject = new Camera.CameraInfo();
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < Cow.fYa)
        {
          Camera.getCameraInfo(i, (Camera.CameraInfo)localObject);
          if (((Camera.CameraInfo)localObject).facing != 1) {
            continue;
          }
          if (Cox != -1) {
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
          if ((Cow.CmW != 270) && ((!bool) || (Cow.CmW != 0))) {
            continue;
          }
          Coz = 1;
          if ((Cow.CmX != 270) && ((!bool) || (Cow.CmX != 0))) {
            continue;
          }
          CoA = 1;
          AppMethodBeat.o(115699);
          return;
        }
        Cox = i;
        Cow.CmW = ((Camera.CameraInfo)localObject).orientation;
        Cow.CmU = true;
        continue;
        if (((Camera.CameraInfo)localObject).facing == 0) {
          if (Coy != -1)
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
        Coy = i;
        Cow.CmX = localException.orientation;
        Cow.CmV = true;
        continue;
        boolean bool = localException.equalsIgnoreCase("Mediatek");
        continue;
        Coz = 0;
        continue;
        CoA = 0;
        AppMethodBeat.o(115699);
        return;
        i += 1;
      }
    }
  }
  
  public static void gH(Context paramContext)
  {
    AppMethodBeat.i(115698);
    if (Cow != null)
    {
      AppMethodBeat.o(115698);
      return;
    }
    Cow = new g("*");
    boolean bool = eAJ();
    CoC = bool;
    if ((bool) && (!ae.gcE.fYb))
    {
      eAK();
      if (ae.gcE.bin) {
        CoB = ae.gcE.fYg;
      }
      ad.i("MicroMsg.CameraUtil", "gCameraNum:" + Cow.fYa + "\ngIsHasFrontCamera:" + Cow.CmU + "\ngIsHasBackCamera:" + Cow.CmV + "\ngFrontCameraId:" + Cox + "\ngBackCameraId:" + Coy + "\ngBackOrientation:" + Cow.CmX + "\ngFrontOrientation:" + Cow.CmW + "\ngBestFps:" + Cow.CmT + "\ngFacePreviewSize:" + Cow.CmY + "\ngNonFacePreviewSize:" + Cow.CmZ + "\ngFaceCameraIsRotate180:" + Coz + "\ngMainCameraIsRotate180:" + CoA + "\ngCameraFormat:" + CoB + "\ngFaceNotRotate:SDK:" + Build.VERSION.SDK_INT + "\n");
      AppMethodBeat.o(115698);
      return;
    }
    if ((CoC) && (ae.gcE.fYb)) {
      eAK();
    }
    if (ae.gcE.fYb) {
      Cow.fYa = ae.gcE.fYa;
    }
    if (ae.gcE.fYk)
    {
      if (ae.gcE.fYj.fYO != 0) {
        Cow.CmV = true;
      }
    }
    else {
      label339:
      if (ae.gcE.fYi) {
        if (ae.gcE.fYh.fYO == 0) {
          break label715;
        }
      }
    }
    label715:
    for (Cow.CmU = true;; Cow.CmU = false)
    {
      if ((ae.gcE.fYi) && (ae.gcE.fYh.fYP >= 0))
      {
        Cow.CmW = ae.gcE.fYh.fYP;
        Coz = Cow.CmW;
      }
      if ((ae.gcE.fYk) && (ae.gcE.fYj.fYP >= 0))
      {
        Cow.CmX = ae.gcE.fYj.fYP;
        CoA = Cow.CmX;
      }
      if (ae.gcE.fYi)
      {
        if (Cow.CmY == null) {
          Cow.CmY = new Point(0, 0);
        }
        Cow.CmY = new Point(ae.gcE.fYh.width, ae.gcE.fYh.height);
      }
      if (ae.gcE.fYk)
      {
        if (Cow.CmZ == null) {
          Cow.CmZ = new Point(0, 0);
        }
        Cow.CmZ = new Point(ae.gcE.fYj.width, ae.gcE.fYj.height);
      }
      if ((ae.gcE.fYk) && (ae.gcE.fYj.fps != 0)) {
        Cow.CmT = ae.gcE.fYj.fps;
      }
      if ((ae.gcE.fYi) && (ae.gcE.fYh.fps != 0)) {
        Cow.CmT = ae.gcE.fYh.fps;
      }
      paramContext = paramContext.getPackageManager();
      if ((ae.gcE.fYb) || (paramContext.hasSystemFeature("android.hardware.camera"))) {
        break;
      }
      Cow.fYa = 0;
      Cow.CmU = false;
      Cow.CmV = false;
      break;
      Cow.CmV = false;
      break label339;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.j
 * JD-Core Version:    0.7.0.1
 */