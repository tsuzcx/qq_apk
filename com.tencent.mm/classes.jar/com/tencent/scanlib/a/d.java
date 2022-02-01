package com.tencent.scanlib.a;

import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.stubs.logger.Log;

final class d
  implements g.a
{
  public static g.a.a kV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(3544);
    g.a.a locala = new g.a.a();
    locala.gdk = null;
    try
    {
      l = System.currentTimeMillis();
      Log.i("CameraUtilImpl23", "Call Camera.open cameraID ".concat(String.valueOf(paramInt1)));
      locala.gdk = Camera.open(paramInt1);
      Log.i("CameraUtilImpl23", String.format("Call Camera.open back, use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
      if (locala.gdk == null)
      {
        Log.e("CameraUtilImpl23", "open camera error, not exception, but camera null");
        AppMethodBeat.o(3544);
        return null;
      }
    }
    catch (Exception localException)
    {
      Log.e("CameraUtilImpl23", "open camera error " + localException.getMessage());
      AppMethodBeat.o(3544);
      return null;
    }
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    long l = System.currentTimeMillis();
    Log.i("CameraUtilImpl23", "Call Camera.getCameraInfo cameraID ".concat(String.valueOf(paramInt1)));
    Camera.getCameraInfo(paramInt1, localCameraInfo);
    Log.i("CameraUtilImpl23", String.format("Call Camera.getCameraInfo back, use %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
    switch (paramInt2)
    {
    default: 
      paramInt1 = 0;
      if (localCameraInfo.facing != 1) {
        break;
      }
    }
    for (paramInt1 = (360 - localCameraInfo.orientation % 360) % 360;; paramInt1 = (localCameraInfo.orientation - paramInt1 + 360) % 360)
    {
      l = System.currentTimeMillis();
      Log.i("CameraUtilImpl23", "Call Camera.setDisplayOrientation ".concat(String.valueOf(paramInt1)));
      localException.gdk.setDisplayOrientation(paramInt1);
      Log.i("CameraUtilImpl23", String.format("Call Camera.setDisplayOrientation back, use %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
      localException.dHi = paramInt1;
      AppMethodBeat.o(3544);
      return localException;
      paramInt1 = 0;
      break;
      paramInt1 = 90;
      break;
      paramInt1 = 180;
      break;
      paramInt1 = 270;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.scanlib.a.d
 * JD-Core Version:    0.7.0.1
 */