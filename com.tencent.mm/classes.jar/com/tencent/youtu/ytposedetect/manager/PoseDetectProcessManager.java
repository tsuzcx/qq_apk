package com.tencent.youtu.ytposedetect.manager;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytcommon.tools.YTCameraSetting;
import com.tencent.youtu.ytcommon.tools.YTException;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface.PoseDetectResult;
import com.tencent.youtu.ytposedetect.jni.YTPoseDetectJNIInterface;

public class PoseDetectProcessManager
{
  private static final String TAG = "FaceDetectProcess";
  private Camera mCamera = null;
  private Camera.Parameters mCameraParameters = null;
  public int mCameraRotate;
  public int mDesiredPreviewHeight = 480;
  public int mDesiredPreviewWidth = 640;
  public boolean mIsDetecting = false;
  
  private int setCamera(Context paramContext, Camera paramCamera, int paramInt)
  {
    AppMethodBeat.i(218063);
    this.mCamera = paramCamera;
    int i = 0;
    paramInt = 3;
    for (;;)
    {
      if (paramInt > 0)
      {
        try
        {
          this.mCameraParameters = paramCamera.getParameters();
          this.mDesiredPreviewHeight = this.mCameraParameters.getPreviewSize().height;
          this.mDesiredPreviewWidth = this.mCameraParameters.getPreviewSize().width;
          YTPoseDetectJNIInterface.nativeLog("FaceDetectProcess", "[PoseDetectProcessManager.setCamera] mDesiredPreviewWidth: " + this.mDesiredPreviewWidth + " mDesiredPreviewHeight: " + this.mDesiredPreviewHeight);
          paramInt = 0;
        }
        catch (Exception paramContext)
        {
          YTPoseDetectJNIInterface.nativeLog("FaceDetectProcess", "[PoseDetectProcessManager.setCamera] failed:" + paramContext + " retry " + paramInt);
          paramInt -= 1;
        }
        try
        {
          Thread.sleep(10L);
          if (paramInt == 0) {
            i = 3;
          }
        }
        catch (InterruptedException paramContext)
        {
          for (;;)
          {
            YTPoseDetectJNIInterface.nativeLog("FaceDetectProcess", "[PoseDetectProcessManager.setCamera] sleep failed:".concat(String.valueOf(paramContext)));
          }
        }
      }
    }
    AppMethodBeat.o(218063);
    return i;
  }
  
  public void clearAll()
  {
    AppMethodBeat.i(62515);
    restoreCamera();
    AppMethodBeat.o(62515);
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(62519);
    super.finalize();
    AppMethodBeat.o(62519);
  }
  
  public void initAll() {}
  
  public int poseDetect(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int paramInt1, byte[] paramArrayOfByte, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt2)
  {
    AppMethodBeat.i(218080);
    int i = YTCameraSetting.getRotateTag(this.mCameraRotate, 1);
    paramInt1 = YTPoseDetectJNIInterface.poseDetect(paramArrayOfFloat1, paramArrayOfFloat2, paramInt1, paramArrayOfByte, this.mDesiredPreviewWidth, this.mDesiredPreviewHeight, i, paramFloat1, paramFloat2, paramFloat3, paramInt2);
    AppMethodBeat.o(218080);
    return paramInt1;
  }
  
  public void restoreCamera()
  {
    AppMethodBeat.i(62521);
    if ((this.mCamera != null) && (this.mCameraParameters != null)) {
      try
      {
        this.mCamera.setParameters(this.mCameraParameters);
        return;
      }
      catch (Exception localException)
      {
        YTPoseDetectJNIInterface.nativeLog("FaceDetectProcess", "restoreCamera failed. ");
        YTException.report(localException);
        return;
      }
      finally
      {
        this.mCamera = null;
        this.mCameraParameters = null;
        AppMethodBeat.o(62521);
      }
    }
    AppMethodBeat.o(62521);
  }
  
  public void start(Context paramContext, Camera paramCamera, int paramInt, YTPoseDetectInterface.PoseDetectResult paramPoseDetectResult)
  {
    AppMethodBeat.i(62516);
    if (this.mIsDetecting) {
      YTPoseDetectJNIInterface.nativeLog("FaceDetectProcess", "Restart FaceDetect process. YTPoseDetectInterface.stop() should be called before the next start, or maybe camera's parameter may be setting wrong.");
    }
    int i = setCamera(paramContext, paramCamera, paramInt);
    if (i != 0)
    {
      paramPoseDetectResult.onFailed(i, "set camera failed", "reset again");
      AppMethodBeat.o(62516);
      return;
    }
    this.mCameraRotate = YTCameraSetting.getVideoRotate(paramContext, paramInt);
    this.mIsDetecting = true;
    paramPoseDetectResult.onSuccess();
    AppMethodBeat.o(62516);
  }
  
  public void stop()
  {
    AppMethodBeat.i(62517);
    if (this.mIsDetecting)
    {
      this.mIsDetecting = false;
      restoreCamera();
      YTPoseDetectJNIInterface.resetDetect();
    }
    AppMethodBeat.o(62517);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.youtu.ytposedetect.manager.PoseDetectProcessManager
 * JD-Core Version:    0.7.0.1
 */