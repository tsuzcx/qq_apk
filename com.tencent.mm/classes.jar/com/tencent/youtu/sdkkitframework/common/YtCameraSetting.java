package com.tencent.youtu.sdkkitframework.common;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.media.CamcorderProfile;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

public class YtCameraSetting
{
  private static final String TAG = "YtCameraSetting";
  public static int mCameraFacing = 1;
  static int mDesiredPreviewHeight = 480;
  static int mDesiredPreviewWidth;
  public static int mRotate = 0;
  
  static
  {
    mDesiredPreviewWidth = 640;
  }
  
  private static int chooseFixedPreviewFps(Camera.Parameters paramParameters, int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(192573);
    Object localObject = paramParameters.getSupportedPreviewFpsRange().iterator();
    while (((Iterator)localObject).hasNext())
    {
      int[] arrayOfInt = (int[])((Iterator)localObject).next();
      YtLogger.d("YtCameraSetting", "entry: " + arrayOfInt[0] + " - " + arrayOfInt[1]);
      if ((arrayOfInt[0] == arrayOfInt[1]) && (arrayOfInt[0] == paramInt))
      {
        paramParameters.setPreviewFpsRange(arrayOfInt[0], arrayOfInt[1]);
        YtLogger.d("YtCameraSetting", "use preview fps range: " + arrayOfInt[0] + " " + arrayOfInt[1]);
        paramInt = arrayOfInt[0];
        AppMethodBeat.o(192573);
        return paramInt;
      }
    }
    localObject = new int[2];
    paramParameters.getPreviewFpsRange((int[])localObject);
    int i;
    int k;
    if (localObject[0] == localObject[1])
    {
      paramInt = localObject[0];
      localObject = paramParameters.get("preview-frame-rate-values");
      i = paramInt;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        i = paramInt;
        if (!((String)localObject).contains(paramInt / 1000))
        {
          localObject = ((String)localObject).split(",");
          k = localObject.length;
          i = j;
        }
      }
    }
    else
    {
      for (;;)
      {
        if (i >= k) {
          break label326;
        }
        j = Integer.parseInt(localObject[i]) * 1000;
        if (paramInt < j)
        {
          paramParameters.setPreviewFrameRate(j / 1000);
          AppMethodBeat.o(192573);
          return j;
          i = paramInt;
          if (paramInt > localObject[1]) {
            i = localObject[1];
          }
          paramInt = i;
          if (i >= localObject[0]) {
            break;
          }
          paramInt = localObject[0];
          break;
        }
        i += 1;
      }
      label326:
      i = paramInt;
      if (localObject.length > 0)
      {
        j = Integer.parseInt(localObject[(localObject.length - 1)]) * 1000;
        i = paramInt;
        if (paramInt > j) {
          i = j;
        }
      }
    }
    paramParameters.setPreviewFrameRate(i / 1000);
    AppMethodBeat.o(192573);
    return i;
  }
  
  public static int getDesiredPreviewHeight()
  {
    return mDesiredPreviewHeight;
  }
  
  public static int getDesiredPreviewWidth()
  {
    return mDesiredPreviewWidth;
  }
  
  private static Camera.Size getOptimalPreviewSize(List<Camera.Size> paramList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192572);
    if (paramList == null)
    {
      AppMethodBeat.o(192572);
      return null;
    }
    Object localObject1 = null;
    double d1 = 1.7976931348623157E+308D;
    int i = Math.max(paramInt1, paramInt2);
    paramInt1 = Math.min(paramInt1, paramInt2);
    double d2 = i / paramInt1;
    YtLogger.d("YtCameraSetting", "sizes size=" + paramList.size());
    Iterator localIterator = paramList.iterator();
    Object localObject2;
    if (localIterator.hasNext())
    {
      localObject2 = (Camera.Size)localIterator.next();
      if ((Math.abs(((Camera.Size)localObject2).width / ((Camera.Size)localObject2).height - d2) > 0.001D) || (Math.abs(((Camera.Size)localObject2).height - paramInt1) >= d1)) {
        break label254;
      }
      d1 = Math.abs(((Camera.Size)localObject2).height - paramInt1);
      localObject1 = localObject2;
    }
    label254:
    for (;;)
    {
      break;
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        YtLogger.d("YtCameraSetting", "No preview size match the aspect ratio");
        d1 = 1.7976931348623157E+308D;
        localIterator = paramList.iterator();
        for (;;)
        {
          localObject2 = localObject1;
          if (!localIterator.hasNext()) {
            break;
          }
          paramList = (Camera.Size)localIterator.next();
          if (Math.abs(paramList.height - paramInt1) < d1)
          {
            d1 = Math.abs(paramList.height - paramInt1);
            localObject1 = paramList;
          }
        }
      }
      AppMethodBeat.o(192572);
      return localObject2;
    }
  }
  
  public static int getRotate(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192565);
    paramInt1 = getRotateTag(getVideoRotate(paramContext, paramInt1), paramInt2);
    AppMethodBeat.o(192565);
    return paramInt1;
  }
  
  public static int getRotateTag(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192567);
    if (paramInt1 == 90) {
      paramInt1 = 7;
    }
    while (paramInt2 == 1)
    {
      AppMethodBeat.o(192567);
      return paramInt1;
      if (paramInt1 == 180)
      {
        paramInt1 = 3;
      }
      else if (paramInt1 == 270)
      {
        paramInt1 = 5;
      }
      else
      {
        YtLogger.i("YtCameraSetting", "camera rotate not 90degree or 180degree, input: ".concat(String.valueOf(paramInt1)));
        paramInt1 = 1;
      }
    }
    paramInt1 = transBackFacingCameraRatateTag(paramInt1);
    AppMethodBeat.o(192567);
    return paramInt1;
  }
  
  public static int getVideoRotate(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(192568);
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    Camera.getCameraInfo(paramInt, localCameraInfo);
    switch (((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getRotation())
    {
    default: 
      paramInt = 0;
      if (localCameraInfo.facing != 1) {
        break;
      }
    }
    for (int i = (360 - (localCameraInfo.orientation + paramInt) % 360) % 360;; i = (localCameraInfo.orientation - paramInt + 360) % 360)
    {
      YtLogger.i("YtCameraSetting", "debug camera orientation is " + localCameraInfo.orientation + " ui degrees is " + paramInt);
      AppMethodBeat.o(192568);
      return i;
      paramInt = 0;
      break;
      paramInt = 90;
      break;
      paramInt = 180;
      break;
      paramInt = 270;
      break;
    }
  }
  
  public static int initCamera(Context paramContext, Camera paramCamera, int paramInt)
  {
    AppMethodBeat.i(192569);
    initCamera(paramContext, paramCamera, paramInt, 4);
    AppMethodBeat.o(192569);
    return 0;
  }
  
  public static int initCamera(Context paramContext, Camera paramCamera, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192570);
    Camera.Parameters localParameters1;
    List localList;
    try
    {
      localParameters1 = paramCamera.getParameters();
      localList = localParameters1.getSupportedFocusModes();
      i = 0;
      while (i < localList.size())
      {
        YtLogger.v("YtCameraSetting", "suporrtedFocusModes " + i + " :" + (String)localList.get(i));
        i += 1;
      }
      if (localList == null) {
        break label318;
      }
    }
    catch (Exception paramContext)
    {
      YtLogger.e("YtCameraSetting", "get camera parameters failed. 1. Check Camera.getParameters() interface. 2. Get logs for more detail.");
      AppMethodBeat.o(192570);
      return 1;
    }
    if (localList.indexOf("continuous-video") >= 0)
    {
      localParameters1.setFocusMode("continuous-video");
      YtLogger.d("YtCameraSetting", "set camera focus mode continuous video");
    }
    try
    {
      paramCamera.setParameters(localParameters1);
      localParameters1 = paramCamera.getParameters();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        YtLogger.e("YtCameraSetting", "Camera.setParameters.setPreviewSize failed!!: " + localException.getLocalizedMessage());
        localParameters2 = paramCamera.getParameters();
      }
    }
    finally
    {
      paramCamera.getParameters();
      AppMethodBeat.o(192570);
    }
    int i = getVideoRotate(paramContext, paramInt1);
    paramCamera.setDisplayOrientation(i);
    YtLogger.d("YtCameraSetting", "videoOrietation is".concat(String.valueOf(i)));
    if (CamcorderProfile.hasProfile(paramInt1, paramInt2))
    {
      paramContext = CamcorderProfile.get(paramInt1, paramInt2);
      YtLogger.d("YtCameraSetting", "custom camcorderProfile:" + paramContext.videoFrameWidth + "x" + paramContext.videoFrameHeight);
    }
    Object localObject;
    label318:
    Camera.Parameters localParameters2;
    for (;;)
    {
      localObject = paramCamera.getParameters().getSupportedPictureSizes();
      localList = paramCamera.getParameters().getSupportedPreviewSizes();
      paramInt1 = 0;
      while (paramInt1 < ((List)localObject).size())
      {
        Camera.Size localSize = (Camera.Size)((List)localObject).get(paramInt1);
        YtLogger.d("pictureSize", localSize.width + " x " + localSize.height);
        paramInt1 += 1;
      }
      if ((localList != null) && (localList.indexOf("auto") >= 0))
      {
        localParameters1.setFocusMode("auto");
        YtLogger.d("YtCameraSetting", "set camera focus mode auto");
        break;
      }
      YtLogger.d("YtCameraSetting", "NOT set camera focus mode");
      break;
      if (CamcorderProfile.hasProfile(paramInt1, 4))
      {
        paramContext = CamcorderProfile.get(paramInt1, 4);
        YtLogger.d("YtCameraSetting", "480P camcorderProfile:" + paramContext.videoFrameWidth + "x" + paramContext.videoFrameHeight);
      }
      else if (CamcorderProfile.hasProfile(paramInt1, 5))
      {
        paramContext = CamcorderProfile.get(paramInt1, 5);
        YtLogger.d("YtCameraSetting", "720P camcorderProfile:" + paramContext.videoFrameWidth + "x" + paramContext.videoFrameHeight);
      }
      else
      {
        paramContext = CamcorderProfile.get(paramInt1, 1);
        YtLogger.d("YtCameraSetting", "High camcorderProfile:" + paramContext.videoFrameWidth + "x" + paramContext.videoFrameHeight);
      }
    }
    paramInt1 = 0;
    while (paramInt1 < localList.size())
    {
      localObject = (Camera.Size)localList.get(paramInt1);
      YtLogger.d("previewSize", ((Camera.Size)localObject).width + " x " + ((Camera.Size)localObject).height);
      paramInt1 += 1;
    }
    setVideoSize(localParameters2, paramContext);
    mDesiredPreviewWidth = paramContext.videoFrameWidth;
    mDesiredPreviewHeight = paramContext.videoFrameHeight;
    YtLogger.d("YtCameraSetting", "mDesiredPreviewWidth: " + mDesiredPreviewWidth + ", mDesiredPreviewHeight: " + mDesiredPreviewHeight);
    localParameters2.setPreviewSize(mDesiredPreviewWidth, mDesiredPreviewHeight);
    localParameters2.setPreviewFormat(17);
    try
    {
      paramCamera.setParameters(localParameters2);
      paramContext = paramCamera.getParameters();
      YtLogger.d("YtCameraSetting", "choose camera fps is : ".concat(String.valueOf(chooseFixedPreviewFps(paramContext, 30000))));
    }
    catch (Exception paramContext)
    {
      try
      {
        paramCamera.setParameters(paramContext);
        paramContext = paramCamera.getParameters();
        paramCamera = new int[2];
        paramContext.getPreviewFpsRange(paramCamera);
        paramInt1 = paramContext.getPreviewFrameRate();
        YtLogger.d("YtCameraSetting", "after set parameters getPreviewFpsRange=" + paramCamera[0] + "-" + paramCamera[1] + " ;after set parameter fps=" + paramInt1);
        paramContext = paramContext.getPreviewSize();
        YtLogger.d("YtCameraSetting", "camera preview size is " + paramContext.width + " " + paramContext.height);
        AppMethodBeat.o(192570);
        return 0;
        paramContext = paramContext;
        YtLogger.e("YtCameraSetting", "Camera.setParameters.setPreviewSize failed!!: " + paramContext.getLocalizedMessage());
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          YtLogger.e("YtCameraSetting", "Camera.setParameters.preview fps failed!!: " + paramContext.getLocalizedMessage());
        }
      }
    }
  }
  
  public static void setCameraFacing(int paramInt)
  {
    mCameraFacing = paramInt;
  }
  
  public static void setCameraRotate(int paramInt)
  {
    mRotate = paramInt;
  }
  
  public static void setVideoSize(Camera.Parameters paramParameters, CamcorderProfile paramCamcorderProfile)
  {
    AppMethodBeat.i(192571);
    Object localObject = paramParameters.getSupportedPreviewSizes();
    if (paramParameters.getSupportedVideoSizes() == null)
    {
      YtLogger.d("YtCameraSetting", "video size from profile is : " + paramCamcorderProfile.videoFrameWidth + " " + paramCamcorderProfile.videoFrameHeight);
      if (getOptimalPreviewSize((List)localObject, paramCamcorderProfile.videoFrameWidth, paramCamcorderProfile.videoFrameHeight) == null)
      {
        YtLogger.d("YtCameraSetting", "do not find proper preview size, use default");
        paramCamcorderProfile.videoFrameWidth = 640;
        paramCamcorderProfile.videoFrameHeight = 480;
      }
    }
    paramParameters = paramParameters.getSupportedVideoSizes();
    if (paramParameters != null)
    {
      int i = 0;
      int k;
      for (int j = 0; i < paramParameters.size(); j = k)
      {
        localObject = (Camera.Size)paramParameters.get(i);
        k = j;
        if (((Camera.Size)localObject).width == paramCamcorderProfile.videoFrameWidth)
        {
          k = j;
          if (((Camera.Size)localObject).height == paramCamcorderProfile.videoFrameHeight) {
            k = 1;
          }
        }
        i += 1;
      }
      if (j == 0)
      {
        paramCamcorderProfile.videoFrameWidth = 640;
        paramCamcorderProfile.videoFrameHeight = 480;
      }
    }
    YtLogger.d("YtCameraSetting", "select video size camcorderProfile:" + paramCamcorderProfile.videoFrameWidth + "x" + paramCamcorderProfile.videoFrameHeight);
    AppMethodBeat.o(192571);
  }
  
  public static int transBackFacingCameraRatateTag(int paramInt)
  {
    AppMethodBeat.i(192566);
    if (paramInt == 1)
    {
      AppMethodBeat.o(192566);
      return 2;
    }
    if (paramInt == 2)
    {
      AppMethodBeat.o(192566);
      return 1;
    }
    if (paramInt == 3)
    {
      AppMethodBeat.o(192566);
      return 4;
    }
    if (paramInt == 4)
    {
      AppMethodBeat.o(192566);
      return 3;
    }
    if (paramInt == 5)
    {
      AppMethodBeat.o(192566);
      return 8;
    }
    if (paramInt == 6)
    {
      AppMethodBeat.o(192566);
      return 7;
    }
    if (paramInt == 7)
    {
      AppMethodBeat.o(192566);
      return 6;
    }
    if (paramInt == 8)
    {
      AppMethodBeat.o(192566);
      return 5;
    }
    YtLogger.w("YtCameraSetting", "[YtCameraSetting.transBackFacingCameraRatateTag] unsurported rotateTag: ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(192566);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.common.YtCameraSetting
 * JD-Core Version:    0.7.0.1
 */