package com.tencent.youtu.ytfacetrace.manager;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  private volatile boolean isProcessing;
  private Camera mCamera;
  private Camera.Parameters mCameraParameters;
  public Context mContext;
  public int mDesiredPreviewHeight;
  public int mDesiredPreviewWidth;
  private YTFaceTraceJNIInterface mFaceCheck;
  private YTFaceTraceInterface.FaceTraceingNotice mFaceTraceNotice;
  public boolean mIsTracing;
  private YTFaceTraceJNIInterface.FaceStatus status;
  long time_now;
  long time_pre;
  
  public FaceTraceProcessManager()
  {
    AppMethodBeat.i(117812);
    this.mIsTracing = false;
    this.mCamera = null;
    this.mCameraParameters = null;
    this.mFaceCheck = new YTFaceTraceJNIInterface();
    this.isProcessing = false;
    this.status = null;
    this.mDesiredPreviewWidth = 1280;
    this.mDesiredPreviewHeight = 720;
    this.time_pre = 0L;
    this.time_now = 0L;
    AppMethodBeat.o(117812);
  }
  
  private Rect getFaceScreen()
  {
    int i = 0;
    AppMethodBeat.i(117821);
    float f3 = this.status.xys[0];
    float f4 = this.status.xys[0];
    float f2 = this.status.xys[1];
    float f1 = this.status.xys[1];
    if (i < 180)
    {
      if (f3 < this.status.xys[i])
      {
        label72:
        if (f4 <= this.status.xys[i]) {
          break label147;
        }
        label88:
        i += 1;
        if (f2 >= this.status.xys[i]) {
          break label162;
        }
        label109:
        if (f1 <= this.status.xys[i]) {
          break label176;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        f3 = this.status.xys[i];
        break label72;
        label147:
        f4 = this.status.xys[i];
        break label88;
        label162:
        f2 = this.status.xys[i];
        break label109;
        label176:
        f1 = this.status.xys[i];
      }
    }
    Rect localRect = new Rect((int)f3, (int)f2, (int)f4, (int)f1);
    AppMethodBeat.o(117821);
    return localRect;
  }
  
  private YTFaceTraceJNIInterface.FaceStatus getFaceStatus(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117820);
    if (this.isProcessing)
    {
      AppMethodBeat.o(117820);
      return null;
    }
    this.isProcessing = true;
    if (paramArrayOfByte == null)
    {
      YTLogger.w("FaceDetectProcess", "FrameData is null!");
      this.isProcessing = false;
      AppMethodBeat.o(117820);
      return null;
    }
    this.status = this.mFaceCheck.DoDetectionProcess(paramArrayOfByte, paramInt1, paramInt2, false);
    this.isProcessing = false;
    paramArrayOfByte = this.status;
    AppMethodBeat.o(117820);
    return paramArrayOfByte;
  }
  
  private void noticeOnPreviewing(int paramInt, YTFaceTraceJNIInterface.FaceStatus paramFaceStatus, Rect paramRect, byte[] paramArrayOfByte, Camera paramCamera)
  {
    AppMethodBeat.i(117823);
    if (this.mFaceTraceNotice != null) {
      this.mFaceTraceNotice.onTracing(paramInt, paramFaceStatus, paramRect, paramArrayOfByte, paramCamera);
    }
    AppMethodBeat.o(117823);
  }
  
  private void processFaceDetect(byte[] paramArrayOfByte, Camera paramCamera)
  {
    AppMethodBeat.i(117822);
    if (this.status == null)
    {
      noticeOnPreviewing(1, null, null, paramArrayOfByte, paramCamera);
      AppMethodBeat.o(117822);
      return;
    }
    noticeOnPreviewing(1, this.status, getFaceScreen(), paramArrayOfByte, paramCamera);
    AppMethodBeat.o(117822);
  }
  
  private void setCamera(Context paramContext, Camera paramCamera, int paramInt)
  {
    AppMethodBeat.i(117818);
    this.mCamera = paramCamera;
    this.mCameraParameters = paramCamera.getParameters();
    this.mDesiredPreviewHeight = this.mCameraParameters.getPreviewSize().height;
    this.mDesiredPreviewWidth = this.mCameraParameters.getPreviewSize().width;
    AppMethodBeat.o(117818);
  }
  
  public void clearAll()
  {
    AppMethodBeat.i(117813);
    restoreCamera();
    AppMethodBeat.o(117813);
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(117817);
    restoreCamera();
    if (this.mFaceCheck != null) {
      this.mFaceCheck.destroy();
    }
    super.finalize();
    AppMethodBeat.o(117817);
  }
  
  public void initAll() {}
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    AppMethodBeat.i(117816);
    if (this.mIsTracing) {
      YTThreadOperate.runOnSubThread(new FaceTraceProcessManager.1(this, paramArrayOfByte), new FaceTraceProcessManager.2(this, paramArrayOfByte, paramCamera));
    }
    AppMethodBeat.o(117816);
  }
  
  public void restoreCamera()
  {
    AppMethodBeat.i(117819);
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
        this.mFaceTraceNotice = null;
        this.mContext = null;
        AppMethodBeat.o(117819);
      }
    }
    AppMethodBeat.o(117819);
  }
  
  public void start(Context paramContext, Camera paramCamera, int paramInt, YTFaceTraceInterface.FaceDetectResult paramFaceDetectResult, YTFaceTraceInterface.FaceTraceingNotice paramFaceTraceingNotice)
  {
    AppMethodBeat.i(117814);
    if (this.mIsTracing) {
      YTLogger.w("FaceDetectProcess", "Restart FaceDetect process. YTFaceTraceInterface.stop() should be called before the next start, or maybe camera's parameter may be setting wrong.");
    }
    setCamera(paramContext, paramCamera, paramInt);
    this.mIsTracing = true;
    this.mContext = paramContext;
    this.mFaceTraceNotice = paramFaceTraceingNotice;
    paramFaceDetectResult.onSuccess();
    noticeOnPreviewing(0, null, null, null, null);
    AppMethodBeat.o(117814);
  }
  
  public void stop()
  {
    AppMethodBeat.i(117815);
    if (this.mIsTracing)
    {
      this.mIsTracing = false;
      noticeOnPreviewing(2, null, null, null, null);
      restoreCamera();
    }
    AppMethodBeat.o(117815);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.youtu.ytfacetrace.manager.FaceTraceProcessManager
 * JD-Core Version:    0.7.0.1
 */