package com.tencent.mm.plugin.voip.video.camera.a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.c.a;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.c.a;
import com.tencent.mm.plugin.voip.video.camera.prev.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
{
  public static int HjA = 0;
  public static int HjB = 0;
  public static boolean HjC = true;
  public static boolean HjD = false;
  public static b Hjw;
  public static int Hjx = -1;
  public static int Hjy = -1;
  public static int Hjz = 0;
  public static int gDo = 0;
  
  public static boolean fLj()
  {
    return (!ae.gKt.gFA) || (ae.gKt.gFz != 8);
  }
  
  public static boolean fLk()
  {
    AppMethodBeat.i(235840);
    if (!HjD)
    {
      HjC = fLl();
      a locala = a.gDs;
      gDo = a.anJ();
      HjD = true;
    }
    boolean bool = HjC;
    AppMethodBeat.o(235840);
    return bool;
  }
  
  private static boolean fLl()
  {
    boolean bool = false;
    AppMethodBeat.i(235841);
    try
    {
      if (Class.forName("android.hardware.Camera").getDeclaredMethod("getNumberOfCameras", null) == null) {
        Log.d("GetfcMethod", "GetfcMethod is null");
      }
      for (;;)
      {
        AppMethodBeat.o(235841);
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
  
  private static void fLm()
  {
    AppMethodBeat.i(235843);
    Hjw.gFx = gDo;
    Object localObject = new Camera.CameraInfo();
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < Hjw.gFx)
        {
          Camera.getCameraInfo(i, (Camera.CameraInfo)localObject);
          if (((Camera.CameraInfo)localObject).facing != 1) {
            continue;
          }
          if (Hjx != -1) {
            Log.d("MicroMsg.CameraUtil", "device has other camera id %s in front", new Object[] { Integer.valueOf(i) });
          }
        }
        else
        {
          localObject = System.getProperty("ro.media.enc.camera.platform", null);
          if (localObject != null) {
            continue;
          }
          bool = false;
          if ((Hjw.HjZ != 270) && ((!bool) || (Hjw.HjZ != 0))) {
            continue;
          }
          Hjz = 1;
          if ((Hjw.Hka != 270) && ((!bool) || (Hjw.Hka != 0))) {
            continue;
          }
          HjA = 1;
          AppMethodBeat.o(235843);
          return;
        }
        Hjx = i;
        Hjw.HjZ = ((Camera.CameraInfo)localObject).orientation;
        Hjw.HjX = true;
        continue;
        if (((Camera.CameraInfo)localObject).facing == 0) {
          if (Hjy != -1)
          {
            Log.d("MicroMsg.CameraUtil", "device has other camera id %s in back", new Object[] { Integer.valueOf(i) });
            continue;
          }
        }
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.CameraUtil", "get camera info error: %s", new Object[] { localException.getMessage() });
        continue;
        Hjy = i;
        Hjw.Hka = localException.orientation;
        Hjw.HjY = true;
        continue;
        boolean bool = localException.equalsIgnoreCase("Mediatek");
        continue;
        Hjz = 0;
        continue;
        HjA = 0;
        AppMethodBeat.o(235843);
        return;
        i += 1;
      }
    }
  }
  
  public static void hH(Context paramContext)
  {
    AppMethodBeat.i(235842);
    if (Hjw != null)
    {
      AppMethodBeat.o(235842);
      return;
    }
    Hjw = new b("*");
    if ((fLk()) && (!ae.gKt.gFy))
    {
      fLm();
      if (ae.gKt.bik) {
        HjB = ae.gKt.gFD;
      }
      Log.i("MicroMsg.CameraUtil", "gCameraNum:" + Hjw.gFx + "\ngIsHasFrontCamera:" + Hjw.HjX + "\ngIsHasBackCamera:" + Hjw.HjY + "\ngFrontCameraId:" + Hjx + "\ngBackCameraId:" + Hjy + "\ngBackOrientation:" + Hjw.Hka + "\ngFrontOrientation:" + Hjw.HjZ + "\ngBestFps:" + Hjw.HjW + "\ngFacePreviewSize:" + Hjw.Hkb + "\ngNonFacePreviewSize:" + Hjw.Hkc + "\ngFaceCameraIsRotate180:" + Hjz + "\ngMainCameraIsRotate180:" + HjA + "\ngCameraFormat:" + HjB + "\ngFaceNotRotate:SDK:" + Build.VERSION.SDK_INT + "\n");
      AppMethodBeat.o(235842);
      return;
    }
    if ((fLk()) && (ae.gKt.gFy)) {
      fLm();
    }
    if (ae.gKt.gFy) {
      Hjw.gFx = ae.gKt.gFx;
    }
    if (ae.gKt.gFH)
    {
      if (ae.gKt.gFG.gGn != 0) {
        Hjw.HjY = true;
      }
    }
    else {
      label338:
      if (ae.gKt.gFF) {
        if (ae.gKt.gFE.gGn == 0) {
          break label714;
        }
      }
    }
    label714:
    for (Hjw.HjX = true;; Hjw.HjX = false)
    {
      if ((ae.gKt.gFF) && (ae.gKt.gFE.gGo >= 0))
      {
        Hjw.HjZ = ae.gKt.gFE.gGo;
        Hjz = Hjw.HjZ;
      }
      if ((ae.gKt.gFH) && (ae.gKt.gFG.gGo >= 0))
      {
        Hjw.Hka = ae.gKt.gFG.gGo;
        HjA = Hjw.Hka;
      }
      if (ae.gKt.gFF)
      {
        if (Hjw.Hkb == null) {
          Hjw.Hkb = new Point(0, 0);
        }
        Hjw.Hkb = new Point(ae.gKt.gFE.width, ae.gKt.gFE.height);
      }
      if (ae.gKt.gFH)
      {
        if (Hjw.Hkc == null) {
          Hjw.Hkc = new Point(0, 0);
        }
        Hjw.Hkc = new Point(ae.gKt.gFG.width, ae.gKt.gFG.height);
      }
      if ((ae.gKt.gFH) && (ae.gKt.gFG.fps != 0)) {
        Hjw.HjW = ae.gKt.gFG.fps;
      }
      if ((ae.gKt.gFF) && (ae.gKt.gFE.fps != 0)) {
        Hjw.HjW = ae.gKt.gFE.fps;
      }
      paramContext = paramContext.getPackageManager();
      if ((ae.gKt.gFy) || (paramContext.hasSystemFeature("android.hardware.camera"))) {
        break;
      }
      Hjw.gFx = 0;
      Hjw.HjX = false;
      Hjw.HjY = false;
      break;
      Hjw.HjY = false;
      break label338;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.camera.a.c
 * JD-Core Version:    0.7.0.1
 */