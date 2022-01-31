package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.c;
import com.tencent.mm.compatible.e.c.a;
import com.tencent.mm.sdk.platformtools.ab;

public final class i
{
  public static int tHA = -1;
  public static int tHB = 0;
  public static int tHC = 0;
  public static int tHD = 0;
  public static boolean tHE = true;
  public static g tHy;
  public static int tHz = -1;
  
  public static boolean cPP()
  {
    return (!ac.eru.enR) || (ac.eru.enQ != 8);
  }
  
  private static boolean cPQ()
  {
    boolean bool = false;
    AppMethodBeat.i(5112);
    try
    {
      if (Class.forName("android.hardware.Camera").getDeclaredMethod("getNumberOfCameras", null) == null) {
        ab.d("GetfcMethod", "GetfcMethod is null");
      }
      for (;;)
      {
        AppMethodBeat.o(5112);
        return bool;
        bool = true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.CameraUtil", "find getNumberOfCameras failed: " + localException.getMessage());
      }
    }
  }
  
  private static void cPR()
  {
    AppMethodBeat.i(5114);
    tHy.enO = Camera.getNumberOfCameras();
    Object localObject = new Camera.CameraInfo();
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < tHy.enO)
        {
          Camera.getCameraInfo(i, (Camera.CameraInfo)localObject);
          if (((Camera.CameraInfo)localObject).facing != 1) {
            continue;
          }
          if (tHz != -1) {
            ab.d("MicroMsg.CameraUtil", "device has other camera id %s in front", new Object[] { Integer.valueOf(i) });
          }
        }
        else
        {
          localObject = System.getProperty("ro.media.enc.camera.platform", null);
          if (localObject != null) {
            continue;
          }
          bool = false;
          if ((tHy.tGj != 270) && ((!bool) || (tHy.tGj != 0))) {
            continue;
          }
          tHB = 1;
          if ((tHy.tGk != 270) && ((!bool) || (tHy.tGk != 0))) {
            continue;
          }
          tHC = 1;
          AppMethodBeat.o(5114);
          return;
        }
        tHz = i;
        tHy.tGj = ((Camera.CameraInfo)localObject).orientation;
        tHy.tGh = true;
        continue;
        if (((Camera.CameraInfo)localObject).facing == 0) {
          if (tHA != -1)
          {
            ab.d("MicroMsg.CameraUtil", "device has other camera id %s in back", new Object[] { Integer.valueOf(i) });
            continue;
          }
        }
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.CameraUtil", "get camera info error: %s", new Object[] { localException.getMessage() });
        continue;
        tHA = i;
        tHy.tGk = localException.orientation;
        tHy.tGi = true;
        continue;
        boolean bool = localException.equalsIgnoreCase("Mediatek");
        continue;
        tHB = 0;
        continue;
        tHC = 0;
        AppMethodBeat.o(5114);
        return;
        i += 1;
      }
    }
  }
  
  public static void fo(Context paramContext)
  {
    AppMethodBeat.i(5113);
    if (tHy != null)
    {
      AppMethodBeat.o(5113);
      return;
    }
    tHy = new g("*");
    boolean bool = cPQ();
    tHE = bool;
    if ((bool) && (!ac.eru.enP))
    {
      cPR();
      if (ac.eru.aBO) {
        tHD = ac.eru.enU;
      }
      ab.i("MicroMsg.CameraUtil", "gCameraNum:" + tHy.enO + "\ngIsHasFrontCamera:" + tHy.tGh + "\ngIsHasBackCamera:" + tHy.tGi + "\ngFrontCameraId:" + tHz + "\ngBackCameraId:" + tHA + "\ngBackOrientation:" + tHy.tGk + "\ngFrontOrientation:" + tHy.tGj + "\ngBestFps:" + tHy.tGg + "\ngFacePreviewSize:" + tHy.tGl + "\ngNonFacePreviewSize:" + tHy.tGm + "\ngFaceCameraIsRotate180:" + tHB + "\ngMainCameraIsRotate180:" + tHC + "\ngCameraFormat:" + tHD + "\ngFaceNotRotate:SDK:" + Build.VERSION.SDK_INT + "\n");
      AppMethodBeat.o(5113);
      return;
    }
    if ((tHE) && (ac.eru.enP)) {
      cPR();
    }
    if (ac.eru.enP) {
      tHy.enO = ac.eru.enO;
    }
    if (ac.eru.enY)
    {
      if (ac.eru.enX.eoD != 0) {
        tHy.tGi = true;
      }
    }
    else {
      label342:
      if (ac.eru.enW) {
        if (ac.eru.enV.eoD == 0) {
          break label718;
        }
      }
    }
    label718:
    for (tHy.tGh = true;; tHy.tGh = false)
    {
      if ((ac.eru.enW) && (ac.eru.enV.eoE >= 0))
      {
        tHy.tGj = ac.eru.enV.eoE;
        tHB = tHy.tGj;
      }
      if ((ac.eru.enY) && (ac.eru.enX.eoE >= 0))
      {
        tHy.tGk = ac.eru.enX.eoE;
        tHC = tHy.tGk;
      }
      if (ac.eru.enW)
      {
        if (tHy.tGl == null) {
          tHy.tGl = new Point(0, 0);
        }
        tHy.tGl = new Point(ac.eru.enV.width, ac.eru.enV.height);
      }
      if (ac.eru.enY)
      {
        if (tHy.tGm == null) {
          tHy.tGm = new Point(0, 0);
        }
        tHy.tGm = new Point(ac.eru.enX.width, ac.eru.enX.height);
      }
      if ((ac.eru.enY) && (ac.eru.enX.fps != 0)) {
        tHy.tGg = ac.eru.enX.fps;
      }
      if ((ac.eru.enW) && (ac.eru.enV.fps != 0)) {
        tHy.tGg = ac.eru.enV.fps;
      }
      paramContext = paramContext.getPackageManager();
      if ((ac.eru.enP) || (paramContext.hasSystemFeature("android.hardware.camera"))) {
        break;
      }
      tHy.enO = 0;
      tHy.tGh = false;
      tHy.tGi = false;
      break;
      tHy.tGi = false;
      break label342;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.i
 * JD-Core Version:    0.7.0.1
 */