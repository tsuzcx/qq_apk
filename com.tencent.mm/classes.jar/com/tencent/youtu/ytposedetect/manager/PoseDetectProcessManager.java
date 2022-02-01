package com.tencent.youtu.ytposedetect.manager;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytcommon.tools.YTCameraSetting;
import com.tencent.youtu.ytcommon.tools.YTException;
import com.tencent.youtu.ytcommon.tools.YTLogger;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface.PoseDetectResult;
import com.tencent.youtu.ytposedetect.jni.YTPoseDetectJNIInterface;

public class PoseDetectProcessManager
{
  private static final String TAG = "FaceDetectProcess";
  private Camera mCamera = null;
  private Camera.Parameters mCameraParameters = null;
  public int mCameraRotate;
  public int mDesiredPreviewHeight = 720;
  public int mDesiredPreviewWidth = 1280;
  public boolean mIsDetecting = false;
  
  private void setCamera(Context paramContext, Camera paramCamera, int paramInt)
  {
    AppMethodBeat.i(62520);
    this.mCamera = paramCamera;
    this.mCameraParameters = paramCamera.getParameters();
    this.mDesiredPreviewHeight = this.mCameraParameters.getPreviewSize().height;
    this.mDesiredPreviewWidth = this.mCameraParameters.getPreviewSize().width;
    YTLogger.i("FaceDetectProcess", "[PoseDetectProcessManager.setCamera] mDesiredPreviewWidth: " + this.mDesiredPreviewWidth + " mDesiredPreviewHeight: " + this.mDesiredPreviewHeight);
    AppMethodBeat.o(62520);
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
    AppMethodBeat.i(195238);
    int i = YTCameraSetting.getRotateTag(this.mCameraRotate, 1);
    paramInt1 = YTPoseDetectJNIInterface.poseDetect(paramArrayOfFloat1, paramArrayOfFloat2, paramInt1, paramArrayOfByte, this.mDesiredPreviewWidth, this.mDesiredPreviewHeight, i, paramFloat1, paramFloat2, paramFloat3, paramInt2);
    AppMethodBeat.o(195238);
    return paramInt1;
  }
  
  public void restoreCamera()
  {
    AppMethodBeat.i(62521);
    if (this.mCamera != null) {
      try
      {
        this.mCamera.setParameters(this.mCameraParameters);
        return;
      }
      catch (Exception localException)
      {
        YTLogger.w("FaceDetectProcess", "restoreCamera failed. ");
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
      YTLogger.w("FaceDetectProcess", "Restart FaceDetect process. YTPoseDetectInterface.stop() should be called before the next start, or maybe camera's parameter may be setting wrong.");
    }
    setCamera(paramContext, paramCamera, paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.youtu.ytposedetect.manager.PoseDetectProcessManager
 * JD-Core Version:    0.7.0.1
 */