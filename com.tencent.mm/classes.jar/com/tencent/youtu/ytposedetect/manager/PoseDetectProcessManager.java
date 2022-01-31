package com.tencent.youtu.ytposedetect.manager;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytcommon.tools.CameraSetting;
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
    AppMethodBeat.i(117786);
    this.mCamera = paramCamera;
    this.mCameraParameters = paramCamera.getParameters();
    this.mDesiredPreviewHeight = this.mCameraParameters.getPreviewSize().height;
    this.mDesiredPreviewWidth = this.mCameraParameters.getPreviewSize().width;
    AppMethodBeat.o(117786);
  }
  
  public void clearAll()
  {
    AppMethodBeat.i(117781);
    restoreCamera();
    AppMethodBeat.o(117781);
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(117785);
    super.finalize();
    AppMethodBeat.o(117785);
  }
  
  public void initAll() {}
  
  public int poseDetect(float[] paramArrayOfFloat, int paramInt, byte[] paramArrayOfByte, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(117784);
    int i = CameraSetting.getRotateTag(this.mCameraRotate);
    paramInt = YTPoseDetectJNIInterface.poseDetect(paramArrayOfFloat, paramInt, paramArrayOfByte, this.mDesiredPreviewWidth, this.mDesiredPreviewHeight, i, paramFloat1, paramFloat2, paramFloat3);
    AppMethodBeat.o(117784);
    return paramInt;
  }
  
  public void restoreCamera()
  {
    AppMethodBeat.i(117787);
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
        AppMethodBeat.o(117787);
      }
    }
    AppMethodBeat.o(117787);
  }
  
  public void start(Context paramContext, Camera paramCamera, int paramInt, YTPoseDetectInterface.PoseDetectResult paramPoseDetectResult)
  {
    AppMethodBeat.i(117782);
    if (this.mIsDetecting) {
      YTLogger.w("FaceDetectProcess", "Restart FaceDetect process. YTPoseDetectInterface.stop() should be called before the next start, or maybe camera's parameter may be setting wrong.");
    }
    setCamera(paramContext, paramCamera, paramInt);
    this.mCameraRotate = CameraSetting.getVideoRotate(paramContext, paramInt);
    this.mIsDetecting = true;
    paramPoseDetectResult.onSuccess();
    AppMethodBeat.o(117782);
  }
  
  public void stop()
  {
    AppMethodBeat.i(117783);
    if (this.mIsDetecting)
    {
      this.mIsDetecting = false;
      restoreCamera();
    }
    AppMethodBeat.o(117783);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.youtu.ytposedetect.manager.PoseDetectProcessManager
 * JD-Core Version:    0.7.0.1
 */