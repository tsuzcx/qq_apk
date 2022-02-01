package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.c;
import com.tencent.mm.compatible.deviceinfo.c.a;

public final class j
{
  public static g CGa;
  public static int CGb = -1;
  public static int CGc = -1;
  public static int CGd = 0;
  public static int CGe = 0;
  public static int CGf = 0;
  public static boolean CGg = true;
  
  public static boolean eEq()
  {
    return (!com.tencent.mm.compatible.deviceinfo.ae.geM.gaj) || (com.tencent.mm.compatible.deviceinfo.ae.geM.gai != 8);
  }
  
  private static boolean eEr()
  {
    boolean bool = false;
    AppMethodBeat.i(115697);
    try
    {
      if (Class.forName("android.hardware.Camera").getDeclaredMethod("getNumberOfCameras", null) == null) {
        com.tencent.mm.sdk.platformtools.ae.d("GetfcMethod", "GetfcMethod is null");
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
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.CameraUtil", "find getNumberOfCameras failed: " + localException.getMessage());
      }
    }
  }
  
  private static void eEs()
  {
    AppMethodBeat.i(115699);
    CGa.gag = Camera.getNumberOfCameras();
    Object localObject = new Camera.CameraInfo();
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < CGa.gag)
        {
          Camera.getCameraInfo(i, (Camera.CameraInfo)localObject);
          if (((Camera.CameraInfo)localObject).facing != 1) {
            continue;
          }
          if (CGb != -1) {
            com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.CameraUtil", "device has other camera id %s in front", new Object[] { Integer.valueOf(i) });
          }
        }
        else
        {
          localObject = System.getProperty("ro.media.enc.camera.platform", null);
          if (localObject != null) {
            continue;
          }
          bool = false;
          if ((CGa.CEA != 270) && ((!bool) || (CGa.CEA != 0))) {
            continue;
          }
          CGd = 1;
          if ((CGa.CEB != 270) && ((!bool) || (CGa.CEB != 0))) {
            continue;
          }
          CGe = 1;
          AppMethodBeat.o(115699);
          return;
        }
        CGb = i;
        CGa.CEA = ((Camera.CameraInfo)localObject).orientation;
        CGa.CEy = true;
        continue;
        if (((Camera.CameraInfo)localObject).facing == 0) {
          if (CGc != -1)
          {
            com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.CameraUtil", "device has other camera id %s in back", new Object[] { Integer.valueOf(i) });
            continue;
          }
        }
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.CameraUtil", "get camera info error: %s", new Object[] { localException.getMessage() });
        continue;
        CGc = i;
        CGa.CEB = localException.orientation;
        CGa.CEz = true;
        continue;
        boolean bool = localException.equalsIgnoreCase("Mediatek");
        continue;
        CGd = 0;
        continue;
        CGe = 0;
        AppMethodBeat.o(115699);
        return;
        i += 1;
      }
    }
  }
  
  public static void gM(Context paramContext)
  {
    AppMethodBeat.i(115698);
    if (CGa != null)
    {
      AppMethodBeat.o(115698);
      return;
    }
    CGa = new g("*");
    boolean bool = eEr();
    CGg = bool;
    if ((bool) && (!com.tencent.mm.compatible.deviceinfo.ae.geM.gah))
    {
      eEs();
      if (com.tencent.mm.compatible.deviceinfo.ae.geM.bin) {
        CGf = com.tencent.mm.compatible.deviceinfo.ae.geM.gam;
      }
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.CameraUtil", "gCameraNum:" + CGa.gag + "\ngIsHasFrontCamera:" + CGa.CEy + "\ngIsHasBackCamera:" + CGa.CEz + "\ngFrontCameraId:" + CGb + "\ngBackCameraId:" + CGc + "\ngBackOrientation:" + CGa.CEB + "\ngFrontOrientation:" + CGa.CEA + "\ngBestFps:" + CGa.CEx + "\ngFacePreviewSize:" + CGa.CEC + "\ngNonFacePreviewSize:" + CGa.CED + "\ngFaceCameraIsRotate180:" + CGd + "\ngMainCameraIsRotate180:" + CGe + "\ngCameraFormat:" + CGf + "\ngFaceNotRotate:SDK:" + Build.VERSION.SDK_INT + "\n");
      AppMethodBeat.o(115698);
      return;
    }
    if ((CGg) && (com.tencent.mm.compatible.deviceinfo.ae.geM.gah)) {
      eEs();
    }
    if (com.tencent.mm.compatible.deviceinfo.ae.geM.gah) {
      CGa.gag = com.tencent.mm.compatible.deviceinfo.ae.geM.gag;
    }
    if (com.tencent.mm.compatible.deviceinfo.ae.geM.gar)
    {
      if (com.tencent.mm.compatible.deviceinfo.ae.geM.gaq.gaV != 0) {
        CGa.CEz = true;
      }
    }
    else {
      label339:
      if (com.tencent.mm.compatible.deviceinfo.ae.geM.gao) {
        if (com.tencent.mm.compatible.deviceinfo.ae.geM.gan.gaV == 0) {
          break label715;
        }
      }
    }
    label715:
    for (CGa.CEy = true;; CGa.CEy = false)
    {
      if ((com.tencent.mm.compatible.deviceinfo.ae.geM.gao) && (com.tencent.mm.compatible.deviceinfo.ae.geM.gan.gaW >= 0))
      {
        CGa.CEA = com.tencent.mm.compatible.deviceinfo.ae.geM.gan.gaW;
        CGd = CGa.CEA;
      }
      if ((com.tencent.mm.compatible.deviceinfo.ae.geM.gar) && (com.tencent.mm.compatible.deviceinfo.ae.geM.gaq.gaW >= 0))
      {
        CGa.CEB = com.tencent.mm.compatible.deviceinfo.ae.geM.gaq.gaW;
        CGe = CGa.CEB;
      }
      if (com.tencent.mm.compatible.deviceinfo.ae.geM.gao)
      {
        if (CGa.CEC == null) {
          CGa.CEC = new Point(0, 0);
        }
        CGa.CEC = new Point(com.tencent.mm.compatible.deviceinfo.ae.geM.gan.width, com.tencent.mm.compatible.deviceinfo.ae.geM.gan.height);
      }
      if (com.tencent.mm.compatible.deviceinfo.ae.geM.gar)
      {
        if (CGa.CED == null) {
          CGa.CED = new Point(0, 0);
        }
        CGa.CED = new Point(com.tencent.mm.compatible.deviceinfo.ae.geM.gaq.width, com.tencent.mm.compatible.deviceinfo.ae.geM.gaq.height);
      }
      if ((com.tencent.mm.compatible.deviceinfo.ae.geM.gar) && (com.tencent.mm.compatible.deviceinfo.ae.geM.gaq.fps != 0)) {
        CGa.CEx = com.tencent.mm.compatible.deviceinfo.ae.geM.gaq.fps;
      }
      if ((com.tencent.mm.compatible.deviceinfo.ae.geM.gao) && (com.tencent.mm.compatible.deviceinfo.ae.geM.gan.fps != 0)) {
        CGa.CEx = com.tencent.mm.compatible.deviceinfo.ae.geM.gan.fps;
      }
      paramContext = paramContext.getPackageManager();
      if ((com.tencent.mm.compatible.deviceinfo.ae.geM.gah) || (paramContext.hasSystemFeature("android.hardware.camera"))) {
        break;
      }
      CGa.gag = 0;
      CGa.CEy = false;
      CGa.CEz = false;
      break;
      CGa.CEz = false;
      break label339;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.j
 * JD-Core Version:    0.7.0.1
 */