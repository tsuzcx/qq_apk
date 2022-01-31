package com.tencent.youtu.ytagreflectlivecheck.manager;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import com.tencent.youtu.ytagreflectlivecheck.controller.FinishController;
import com.tencent.youtu.ytagreflectlivecheck.controller.InitController;
import com.tencent.youtu.ytagreflectlivecheck.controller.ReflectController;
import com.tencent.youtu.ytagreflectlivecheck.worker.CameraWorker;
import com.tencent.youtu.ytagreflectlivecheck.worker.DataWorker;
import com.tencent.youtu.ytcommon.tools.YTLogger;

public class ProcessManager
{
  private static CameraWorker mCameraWorker;
  private static DataWorker mDataWorker;
  private static FinishController mFinishController;
  private static InitController mInitController;
  public static int mProcessState = 0;
  private static ReflectController mReflectController;
  private static int mRetainCount = 0;
  public static long[] t = new long[10];
  
  private static void FinishStart()
  {
    AppMethodBeat.i(123191);
    t[2] = System.currentTimeMillis();
    YTLogger.i("mCountDownTimer", "[ProcessManager.FinishStart] start to reflect: " + (t[1] - t[0]));
    YTLogger.i("mCountDownTimer", "[ProcessManager.FinishStart] reflect to finish: " + (t[2] - t[1]));
    mProcessState = 3;
    mFinishController.start(YTAGReflectLiveCheckInterface.mUploadVideoRequester, new ProcessManager.3());
    AppMethodBeat.o(123191);
  }
  
  private static void ReflectStart()
  {
    AppMethodBeat.i(123190);
    t[1] = System.currentTimeMillis();
    mProcessState = 2;
    mReflectController.start(YTAGReflectLiveCheckInterface.mReflectLayout, new ProcessManager.2());
    AppMethodBeat.o(123190);
  }
  
  public static CameraWorker cameraWorker()
  {
    return mCameraWorker;
  }
  
  public static void cancel()
  {
    AppMethodBeat.i(123192);
    if (mCameraWorker != null) {
      mCameraWorker.cleanup();
    }
    mProcessState = 0;
    AppMethodBeat.o(123192);
  }
  
  public static void clearAll()
  {
    int i = mRetainCount - 1;
    mRetainCount = i;
    if (i == 0)
    {
      mInitController = null;
      mReflectController = null;
      mFinishController = null;
      mDataWorker = null;
      mCameraWorker = null;
      mProcessState = 0;
    }
  }
  
  public static DataWorker dataWorker()
  {
    return mDataWorker;
  }
  
  public static void initAll()
  {
    AppMethodBeat.i(123188);
    mInitController = new InitController();
    mReflectController = new ReflectController();
    mFinishController = new FinishController();
    mDataWorker = new DataWorker();
    mCameraWorker = new CameraWorker();
    mProcessState = 0;
    mRetainCount += 1;
    AppMethodBeat.o(123188);
  }
  
  public static void start()
  {
    AppMethodBeat.i(123189);
    t[0] = System.currentTimeMillis();
    mProcessState = 1;
    mInitController.start(YTAGReflectLiveCheckInterface.mRgbConfigRequester, new ProcessManager.1());
    AppMethodBeat.o(123189);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager
 * JD-Core Version:    0.7.0.1
 */