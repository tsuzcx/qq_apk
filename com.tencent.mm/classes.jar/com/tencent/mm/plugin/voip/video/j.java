package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Build.VERSION;
import com.tencent.mm.compatible.e.c;
import com.tencent.mm.compatible.e.c.a;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.sdk.platformtools.y;

public final class j
{
  public static h qbM;
  public static int qbN = -1;
  public static int qbO = -1;
  public static int qbP = 0;
  public static int qbQ = 0;
  public static int qbR = 0;
  public static boolean qbS = true;
  
  public static boolean bSC()
  {
    return (!q.dyd.dwa) || (q.dyd.dvZ != 8);
  }
  
  private static boolean bSD()
  {
    try
    {
      if (Class.forName("android.hardware.Camera").getDeclaredMethod("getNumberOfCameras", null) == null)
      {
        y.d("GetfcMethod", "GetfcMethod is null");
        return false;
      }
      return true;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.CameraUtil", "find getNumberOfCameras failed: " + localException.getMessage());
    }
    return false;
  }
  
  private static void bSE()
  {
    qbM.dvX = Camera.getNumberOfCameras();
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < qbM.dvX)
        {
          Camera.getCameraInfo(i, localCameraInfo);
          if (localCameraInfo.facing == 1)
          {
            qbN = i;
            qbM.qaJ = localCameraInfo.orientation;
            qbM.qaH = true;
          }
          else if (localCameraInfo.facing == 0)
          {
            qbO = i;
            qbM.qaK = localCameraInfo.orientation;
            qbM.qaI = true;
          }
        }
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.CameraUtil", "get camera info error: %s", new Object[] { localException.getMessage() });
        String str = System.getProperty("ro.media.enc.camera.platform", null);
        boolean bool;
        if (str == null)
        {
          bool = false;
          if ((qbM.qaJ == 270) || ((bool) && (qbM.qaJ == 0)))
          {
            qbP = 1;
            if ((qbM.qaK != 270) && ((!bool) || (qbM.qaK != 0))) {
              continue;
            }
            qbQ = 1;
          }
        }
        else
        {
          bool = str.equalsIgnoreCase("Mediatek");
          continue;
        }
        qbP = 0;
        continue;
        qbQ = 0;
        return;
      }
      i += 1;
    }
  }
  
  public static void er(Context paramContext)
  {
    if (qbM != null) {
      return;
    }
    qbM = new h("*");
    boolean bool = bSD();
    qbS = bool;
    if ((bool) && (!q.dyd.dvY))
    {
      bSE();
      if (q.dyd.aDx) {
        qbR = q.dyd.dwb;
      }
      y.i("MicroMsg.CameraUtil", "gCameraNum:" + qbM.dvX + "\ngIsHasFrontCamera:" + qbM.qaH + "\ngIsHasBackCamera:" + qbM.qaI + "\ngFrontCameraId:" + qbN + "\ngBackCameraId:" + qbO + "\ngBackOrientation:" + qbM.qaK + "\ngFrontOrientation:" + qbM.qaJ + "\ngBestFps:" + qbM.qaG + "\ngFacePreviewSize:" + qbM.qaL + "\ngNonFacePreviewSize:" + qbM.qaM + "\ngFaceCameraIsRotate180:" + qbP + "\ngMainCameraIsRotate180:" + qbQ + "\ngCameraFormat:" + qbR + "\ngFaceNotRotate:SDK:" + Build.VERSION.SDK_INT + "\n");
      return;
    }
    if ((qbS) && (q.dyd.dvY)) {
      bSE();
    }
    if (q.dyd.dvY) {
      qbM.dvX = q.dyd.dvX;
    }
    if (q.dyd.dwf)
    {
      if (q.dyd.dwe.dwF != 0) {
        qbM.qaI = true;
      }
    }
    else {
      label324:
      if (q.dyd.dwd) {
        if (q.dyd.dwc.dwF == 0) {
          break label700;
        }
      }
    }
    label700:
    for (qbM.qaH = true;; qbM.qaH = false)
    {
      if ((q.dyd.dwd) && (q.dyd.dwc.dwG >= 0))
      {
        qbM.qaJ = q.dyd.dwc.dwG;
        qbP = qbM.qaJ;
      }
      if ((q.dyd.dwf) && (q.dyd.dwe.dwG >= 0))
      {
        qbM.qaK = q.dyd.dwe.dwG;
        qbQ = qbM.qaK;
      }
      if (q.dyd.dwd)
      {
        if (qbM.qaL == null) {
          qbM.qaL = new Point(0, 0);
        }
        qbM.qaL = new Point(q.dyd.dwc.width, q.dyd.dwc.height);
      }
      if (q.dyd.dwf)
      {
        if (qbM.qaM == null) {
          qbM.qaM = new Point(0, 0);
        }
        qbM.qaM = new Point(q.dyd.dwe.width, q.dyd.dwe.height);
      }
      if ((q.dyd.dwf) && (q.dyd.dwe.fps != 0)) {
        qbM.qaG = q.dyd.dwe.fps;
      }
      if ((q.dyd.dwd) && (q.dyd.dwc.fps != 0)) {
        qbM.qaG = q.dyd.dwc.fps;
      }
      paramContext = paramContext.getPackageManager();
      if ((q.dyd.dvY) || (paramContext.hasSystemFeature("android.hardware.camera"))) {
        break;
      }
      qbM.dvX = 0;
      qbM.qaH = false;
      qbM.qaI = false;
      break;
      qbM.qaI = false;
      break label324;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.j
 * JD-Core Version:    0.7.0.1
 */