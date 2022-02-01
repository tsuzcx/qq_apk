package com.tencent.youtu.ytagreflectlivecheck.worker;

import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytcommon.tools.YTException;
import com.tencent.youtu.ytcommon.tools.YTLogger;

public class CameraWorker
{
  private static final String TAG = "YoutuLightLiveCheck";
  private static int mDesiredPreviewHeight = 720;
  private static int mDesiredPreviewWidth = 1280;
  private int GET_CAMERA_PARAMETERS_FAILED = 0;
  public Camera mCamera;
  private Camera.Parameters mCameraParameters;
  private boolean mIsCameraOpened = false;
  private Camera.PreviewCallback mPreviewCallback;
  
  public void cleanup()
  {
    AppMethodBeat.i(43411);
    if (this.mCamera != null) {}
    try
    {
      this.mCamera.setParameters(this.mCameraParameters);
      this.mCamera = null;
      this.mIsCameraOpened = false;
      AppMethodBeat.o(43411);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        YTLogger.d("YoutuLightLiveCheck", "[CameraWorker.cleanup] camera is already released.");
      }
    }
  }
  
  public int getDesiredPreviewHeight()
  {
    return mDesiredPreviewHeight;
  }
  
  public int getDesiredPreviewWidth()
  {
    return mDesiredPreviewWidth;
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    AppMethodBeat.i(43410);
    if ((this.mPreviewCallback != null) && (this.mIsCameraOpened)) {
      try
      {
        this.mPreviewCallback.onPreviewFrame(paramArrayOfByte, paramCamera);
        AppMethodBeat.o(43410);
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        YTException.report(paramArrayOfByte);
        AppMethodBeat.o(43410);
        return;
      }
    }
    YTLogger.w("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.onPreviewFrame] ---callback is nil, or mIsCameraOpened: " + this.mIsCameraOpened);
    AppMethodBeat.o(43410);
  }
  
  public void setCamera(Camera paramCamera)
  {
    AppMethodBeat.i(43409);
    this.mCamera = paramCamera;
    this.mCameraParameters = paramCamera.getParameters();
    mDesiredPreviewHeight = this.mCameraParameters.getPreviewSize().height;
    mDesiredPreviewWidth = this.mCameraParameters.getPreviewSize().width;
    this.mIsCameraOpened = true;
    AppMethodBeat.o(43409);
  }
  
  public void setCameraPreviewCallback(Camera.PreviewCallback paramPreviewCallback)
  {
    this.mPreviewCallback = paramPreviewCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.worker.CameraWorker
 * JD-Core Version:    0.7.0.1
 */