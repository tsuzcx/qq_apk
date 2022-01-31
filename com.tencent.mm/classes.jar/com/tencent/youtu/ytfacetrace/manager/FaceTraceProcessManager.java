package com.tencent.youtu.ytfacetrace.manager;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import com.tencent.youtu.ytcommon.tools.YTException;
import com.tencent.youtu.ytcommon.tools.YTLogger;
import com.tencent.youtu.ytcommon.tools.YTThreadOperate;
import com.tencent.youtu.ytfacetrace.YTFaceTraceInterface.FaceDetectResult;
import com.tencent.youtu.ytfacetrace.YTFaceTraceInterface.FaceTraceingNotice;
import com.tencent.youtu.ytfacetrace.jni.YTFaceTraceJNIInterface;
import com.tencent.youtu.ytfacetrace.jni.YTFaceTraceJNIInterface.FaceStatus;

public class FaceTraceProcessManager
{
  private static final String TAG = "FaceDetectProcess";
  private static int mCurrentCheckingState;
  private volatile boolean isProcessing = false;
  private Camera mCamera = null;
  private Camera.Parameters mCameraParameters = null;
  public Context mContext;
  public int mDesiredPreviewHeight = 720;
  public int mDesiredPreviewWidth = 1280;
  private YTFaceTraceJNIInterface mFaceCheck = new YTFaceTraceJNIInterface();
  private YTFaceTraceInterface.FaceTraceingNotice mFaceTraceNotice;
  public boolean mIsTracing = false;
  private YTFaceTraceJNIInterface.FaceStatus status = null;
  long time_now = 0L;
  long time_pre = 0L;
  
  private Rect getFaceScreen()
  {
    int i = 0;
    float f3 = this.status.xys[0];
    float f4 = this.status.xys[0];
    float f2 = this.status.xys[1];
    float f1 = this.status.xys[1];
    if (i < 180)
    {
      if (f3 < this.status.xys[i])
      {
        label67:
        if (f4 <= this.status.xys[i]) {
          break label142;
        }
        label83:
        i += 1;
        if (f2 >= this.status.xys[i]) {
          break label157;
        }
        label104:
        if (f1 <= this.status.xys[i]) {
          break label171;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        f3 = this.status.xys[i];
        break label67;
        label142:
        f4 = this.status.xys[i];
        break label83;
        label157:
        f2 = this.status.xys[i];
        break label104;
        label171:
        f1 = this.status.xys[i];
      }
    }
    return new Rect((int)f3, (int)f2, (int)f4, (int)f1);
  }
  
  private YTFaceTraceJNIInterface.FaceStatus getFaceStatus(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.isProcessing) {
      return null;
    }
    this.isProcessing = true;
    if (paramArrayOfByte == null)
    {
      YTLogger.w("FaceDetectProcess", "FrameData is null!");
      this.isProcessing = false;
      return null;
    }
    this.status = this.mFaceCheck.DoDetectionProcess(paramArrayOfByte, paramInt1, paramInt2, false);
    this.isProcessing = false;
    return this.status;
  }
  
  private void noticeOnPreviewing(int paramInt, YTFaceTraceJNIInterface.FaceStatus paramFaceStatus, Rect paramRect, byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (this.mFaceTraceNotice != null) {
      this.mFaceTraceNotice.onTracing(paramInt, paramFaceStatus, paramRect, paramArrayOfByte, paramCamera);
    }
  }
  
  private void processFaceDetect(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (this.status == null)
    {
      noticeOnPreviewing(1, null, null, paramArrayOfByte, paramCamera);
      return;
    }
    noticeOnPreviewing(1, this.status, getFaceScreen(), paramArrayOfByte, paramCamera);
  }
  
  private void setCamera(Context paramContext, Camera paramCamera, int paramInt)
  {
    this.mCamera = paramCamera;
    this.mCameraParameters = paramCamera.getParameters();
    this.mDesiredPreviewHeight = this.mCameraParameters.getPreviewSize().height;
    this.mDesiredPreviewWidth = this.mCameraParameters.getPreviewSize().width;
  }
  
  public void clearAll()
  {
    restoreCamera();
  }
  
  protected void finalize()
  {
    restoreCamera();
    if (this.mFaceCheck != null) {
      this.mFaceCheck.destroy();
    }
    super.finalize();
  }
  
  public void initAll() {}
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (this.mIsTracing) {
      YTThreadOperate.runOnSubThread(new FaceTraceProcessManager.1(this, paramArrayOfByte), new FaceTraceProcessManager.2(this, paramArrayOfByte, paramCamera));
    }
  }
  
  public void restoreCamera()
  {
    if (this.mCamera != null) {}
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
      this.mFaceTraceNotice = null;
      this.mContext = null;
    }
  }
  
  public void start(Context paramContext, Camera paramCamera, int paramInt, YTFaceTraceInterface.FaceDetectResult paramFaceDetectResult, YTFaceTraceInterface.FaceTraceingNotice paramFaceTraceingNotice)
  {
    if (this.mIsTracing) {
      YTLogger.w("FaceDetectProcess", "Restart FaceDetect process. YTFaceTraceInterface.stop() should be called before the next start, or maybe camera's parameter may be setting wrong.");
    }
    setCamera(paramContext, paramCamera, paramInt);
    this.mIsTracing = true;
    this.mContext = paramContext;
    this.mFaceTraceNotice = paramFaceTraceingNotice;
    paramFaceDetectResult.onSuccess();
    noticeOnPreviewing(0, null, null, null, null);
  }
  
  public void stop()
  {
    if (this.mIsTracing)
    {
      this.mIsTracing = false;
      noticeOnPreviewing(2, null, null, null, null);
      restoreCamera();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.youtu.ytfacetrace.manager.FaceTraceProcessManager
 * JD-Core Version:    0.7.0.1
 */