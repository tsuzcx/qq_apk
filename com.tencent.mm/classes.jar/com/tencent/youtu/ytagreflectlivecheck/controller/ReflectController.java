package com.tencent.youtu.ytagreflectlivecheck.controller;

import android.graphics.ColorMatrixColorFilter;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectSettings;
import com.tencent.youtu.ytagreflectlivecheck.jni.JNIUtils;
import com.tencent.youtu.ytagreflectlivecheck.jni.YTAGReflectLiveCheckJNIInterface;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.Timeval;
import com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager;
import com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager.ProcessResult;
import com.tencent.youtu.ytagreflectlivecheck.ui.YTReflectLayout;
import com.tencent.youtu.ytagreflectlivecheck.worker.CameraWorker;
import com.tencent.youtu.ytagreflectlivecheck.worker.TimerWorker;
import com.tencent.youtu.ytcommon.tools.YTException;
import com.tencent.youtu.ytcommon.tools.YTLogger;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReflectController
{
  private static final String CONFIG_ALPHA = "A";
  private static final String CONFIG_BLUE = "B";
  private static final String CONFIG_CONFIGS = "configs";
  private static final String CONFIG_DURATION = "duration";
  private static final String CONFIG_GREEN = "G";
  private static final String CONFIG_RED = "R";
  private static final String CONFIG_UNIT = "unit";
  public static final ColorMatrixColorFilter DEFAULT_MATRIX_COLOR_FILTER;
  private static final int DELAY_TIME = 400;
  private static int ERRCODE_CONFIG_DECODE_FAILED = 0;
  private static int ERRCODE_FINISH_FAILED = 0;
  private static int ERRCODE_GET_PARAMS_FAILED = 0;
  private static int ERRCODE_START_FAILED = 0;
  private static int ERRCODE_USER_CANCEL = 0;
  private static int ERRCODE_USER_CANCELED = 0;
  private static final int STATE_DETECT_DELAY = 1;
  private static final int STATE_END = 2;
  private static final int STATE_RGB_CHANGE = 0;
  private static final String TAG = "YoutuLightLiveCheck";
  private static final long deltaTimeThreshold = 30L;
  private static long systemTime;
  private float alphabef = 0.0F;
  private float bluebef = 0.0F;
  private float greenbef = 0.0F;
  private ProcessManager.ProcessResult mCheckResult;
  private int mConfigBegin = 0;
  private int mConfigEnd = 0;
  private int mConfigPoint = 0;
  private TimerWorker mCountDownTimer;
  private int mFrame = 0;
  private YTReflectLayout mReflectLayout;
  private int mState;
  private long mTag;
  private int pushYuvCount = 0;
  private float redbef = 0.0F;
  private long time_finish_begin = 0L;
  private long time_finish_end = 0L;
  private long time_now = 0L;
  private long time_pre = 0L;
  private long time_start = 0L;
  
  static
  {
    AppMethodBeat.i(43364);
    ERRCODE_CONFIG_DECODE_FAILED = 0;
    ERRCODE_USER_CANCEL = 1;
    ERRCODE_GET_PARAMS_FAILED = 2;
    ERRCODE_START_FAILED = 3;
    ERRCODE_FINISH_FAILED = 4;
    ERRCODE_USER_CANCELED = 5;
    systemTime = System.currentTimeMillis();
    DEFAULT_MATRIX_COLOR_FILTER = new ColorMatrixColorFilter(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F });
    AppMethodBeat.o(43364);
  }
  
  private boolean cameraStateControl(int paramInt)
  {
    AppMethodBeat.i(43358);
    Object localObject = ProcessManager.cameraWorker().mCamera;
    if (paramInt == 0) {}
    for (;;)
    {
      Camera.Parameters localParameters;
      try
      {
        this.pushYuvCount = 0;
        localParameters = ((Camera)localObject).getParameters();
        localParameters.setAutoWhiteBalanceLock(true);
        ((Camera)localObject).setParameters(localParameters);
        AppMethodBeat.o(43358);
        return true;
        if (paramInt == 1)
        {
          this.pushYuvCount = 0;
          System.currentTimeMillis();
          localParameters = ((Camera)localObject).getParameters();
        }
      }
      catch (Exception localException1)
      {
        try
        {
          paramInt = localParameters.getExposureCompensation();
          YTAGReflectLiveCheckJNIInterface.getInstance().FRSetISObackup(paramInt);
          localParameters.setExposureCompensation(localParameters.getMinExposureCompensation());
          ((Camera)localObject).setParameters(localParameters);
          localObject = JNIUtils.getTimeval();
          YTAGReflectLiveCheckJNIInterface.getInstance().FRSetISOchangeTime((Timeval)localObject);
          YTAGReflectLiveCheckJNIInterface.getInstance().FRSetDoingDelayCalc(true);
        }
        catch (Exception localException2)
        {
          AppMethodBeat.o(43358);
          return false;
        }
        localException1 = localException1;
        YTException.report(localException1);
        AppMethodBeat.o(43358);
        return false;
      }
      if (paramInt == 2)
      {
        localParameters = localException2.getParameters();
        localParameters.setExposureCompensation((int)YTAGReflectLiveCheckJNIInterface.getInstance().FRGetISObackup());
        localParameters.setAutoWhiteBalanceLock(false);
        localException2.setParameters(localParameters);
      }
    }
  }
  
  private void changeState(int paramInt)
  {
    AppMethodBeat.i(43357);
    this.mState = paramInt;
    YTLogger.i("YoutuLightLiveCheck", "changeState. state: ".concat(String.valueOf(paramInt)));
    cameraStateControl(paramInt);
    if (paramInt == 0)
    {
      this.mConfigBegin = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetConfigBegin();
      this.mConfigEnd = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetConfigEnd();
      this.mConfigPoint = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetChangePoint();
      ProcessManager.cameraWorker().setCameraPreviewCallback(new Camera.PreviewCallback()
      {
        public void onPreviewFrame(byte[] paramAnonymousArrayOfByte, Camera paramAnonymousCamera)
        {
          AppMethodBeat.i(43350);
          ReflectController.access$1900(ReflectController.this, paramAnonymousArrayOfByte, paramAnonymousCamera);
          AppMethodBeat.o(43350);
        }
      });
      AppMethodBeat.o(43357);
      return;
    }
    if (paramInt == 2)
    {
      YTLogger.i("mCountDownTimer", "cameraStateControl:" + (System.currentTimeMillis() - this.time_finish_begin));
      ProcessManager.cameraWorker().setCameraPreviewCallback(null);
      YTLogger.i("mCountDownTimer", "setCameraPreviewCallback:" + (System.currentTimeMillis() - this.time_finish_begin));
      this.time_finish_end = System.currentTimeMillis();
      YTLogger.i("mCountDownTimer", "onFinish. to finish: " + (this.time_finish_begin - this.time_start) + " to finish_end: " + (this.time_finish_end - this.time_finish_begin));
      this.mCheckResult.onSuccess(this.mTag);
    }
    AppMethodBeat.o(43357);
  }
  
  private void innerCancel()
  {
    AppMethodBeat.i(43355);
    if (this.mState == 0) {
      setColorMatrixColorFilter(DEFAULT_MATRIX_COLOR_FILTER);
    }
    AppMethodBeat.o(43355);
  }
  
  private void onPreviewFrameReceived(byte[] paramArrayOfByte, Camera paramCamera)
  {
    int i = 1;
    AppMethodBeat.i(43359);
    int j = ProcessManager.cameraWorker().getDesiredPreviewWidth();
    int k = ProcessManager.cameraWorker().getDesiredPreviewHeight();
    if (this.mState == 0)
    {
      int m = this.mConfigBegin - 3;
      int n = this.mConfigEnd + 3;
      int i1 = this.mFrame;
      YTLogger.d("YoutuLightLiveCheck", "onPreviewFrameReceived. beginFrame: " + m + " endFrame: " + n + " currentFrame: " + i1);
      if ((i1 > m) && (i1 < n))
      {
        long l = System.currentTimeMillis();
        YTLogger.d("YoutuLightLiveCheck", "onPreviewFrameReceived. insertYuv and time");
        systemTime = l;
        if (YTAGReflectLiveCheckInterface.getAGSettings().safetylevel != 2) {
          break label206;
        }
        if (i == 0) {
          break label272;
        }
        YTLogger.i("YoutuLightLiveCheck", "[ReflectController.onPreviewFrameReceived] rgba insert frame: " + this.pushYuvCount);
        YTAGReflectLiveCheckJNIInterface.getInstance().FRPushYuv(paramArrayOfByte, j, k);
        YTAGReflectLiveCheckJNIInterface.getInstance().FRPushCaptureTime(JNIUtils.getTimeval());
      }
      for (;;)
      {
        this.pushYuvCount += 1;
        AppMethodBeat.o(43359);
        return;
        label206:
        if (this.pushYuvCount < 2)
        {
          YTLogger.i("YoutuLightLiveCheck", "[ReflectController.onPreviewFrameReceived] rgba insert frame: " + this.pushYuvCount);
          break;
        }
        YTLogger.i("YoutuLightLiveCheck", "[ReflectController.onPreviewFrameReceived] rgba insert forbit: " + this.pushYuvCount);
        i = 0;
        break;
        label272:
        YTLogger.i("YoutuLightLiveCheck", "[ReflectController.onPreviewFrameReceived] rgba insert forbit: " + this.pushYuvCount);
      }
    }
    if (this.mState == 1)
    {
      YTLogger.d("YoutuLightLiveCheck", "put IOS timeval ");
      if (this.pushYuvCount < 5)
      {
        YTAGReflectLiveCheckJNIInterface.getInstance().FRPushYuv(paramArrayOfByte, j, k);
        YTAGReflectLiveCheckJNIInterface.getInstance().FRPushCaptureTime(JNIUtils.getTimeval());
        this.pushYuvCount += 1;
        YTLogger.i("YoutuLightLiveCheck", "[ReflectController.onPreviewFrameReceived] record ios");
      }
      YTAGReflectLiveCheckJNIInterface.getInstance().FRPushISOImgYuv(paramArrayOfByte, j, k);
      YTAGReflectLiveCheckJNIInterface.getInstance().FRPushISOCaptureTime(JNIUtils.getTimeval());
    }
    AppMethodBeat.o(43359);
  }
  
  private void setColorMatrixColorFilter(ColorMatrixColorFilter paramColorMatrixColorFilter)
  {
    AppMethodBeat.i(43353);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      this.mReflectLayout.setColorMatrixColorFilter(paramColorMatrixColorFilter);
      AppMethodBeat.o(43353);
      return;
    }
    new Handler(Looper.getMainLooper()).post(new ReflectController.1(this, paramColorMatrixColorFilter));
    AppMethodBeat.o(43353);
  }
  
  private void startTimer(int paramInt1, int paramInt2, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(43356);
    YTLogger.i("YoutuLightLiveCheck", "start timer.");
    changeState(0);
    this.mFrame = 0;
    YTLogger.i("mCountDownTimer", "duration:" + paramInt1 + " unit: " + paramInt2);
    this.time_pre = System.currentTimeMillis();
    this.time_start = this.time_pre;
    this.mCountDownTimer = new TimerWorker(paramInt1, paramInt2)
    {
      public void onFinish()
      {
        AppMethodBeat.i(43349);
        try
        {
          YTLogger.i("YoutuLightLiveCheck", "finish timer.");
          ReflectController.access$702(ReflectController.this, 0);
          ReflectController.access$1302(ReflectController.this, System.currentTimeMillis());
          ReflectController.access$1200(ReflectController.this, ReflectController.DEFAULT_MATRIX_COLOR_FILTER);
          YTLogger.i("mCountDownTimer", "setColorMatrixColorFilter:" + (System.currentTimeMillis() - ReflectController.this.time_finish_begin));
          ReflectController.access$1400(ReflectController.this, 1);
          YTLogger.i("mCountDownTimer", "changeState:" + (System.currentTimeMillis() - ReflectController.this.time_finish_begin));
          new Timer().schedule(new TimerTask()
          {
            public void run()
            {
              AppMethodBeat.i(43347);
              YTLogger.i("mCountDownTimer", "change to main:" + (System.currentTimeMillis() - ReflectController.this.time_finish_begin));
              ReflectController.access$1400(ReflectController.this, 2);
              AppMethodBeat.o(43347);
            }
          }, 400L);
          ReflectController.access$1500(ReflectController.this);
          AppMethodBeat.o(43349);
          return;
        }
        catch (Exception localException)
        {
          YTException.report(localException);
          ReflectController.this.mCheckResult.onFailed(ReflectController.ERRCODE_FINISH_FAILED, "Finish check failed. ", "Check error report to get more information.", ReflectController.this.mTag);
          AppMethodBeat.o(43349);
        }
      }
      
      public void onTick(long paramAnonymousLong)
      {
        AppMethodBeat.i(43348);
        ReflectController.access$102(ReflectController.this, System.currentTimeMillis());
        YTLogger.i("mCountDownTimer", "unit:" + this.val$unit + " | real unit:" + (ReflectController.this.time_now - ReflectController.this.time_pre));
        ReflectController.access$202(ReflectController.this, ReflectController.this.time_now);
        for (;;)
        {
          float f1;
          float f2;
          float f3;
          float f4;
          try
          {
            YTLogger.d("YoutuLightLiveCheck", "startTimer.onTick. mFrame: " + ReflectController.this.mFrame);
            if (ReflectController.this.mFrame == ReflectController.this.mConfigBegin)
            {
              Object localObject = JNIUtils.getTimeval();
              YTLogger.i("YoutuLightLiveCheck", "change color begin. mFrame: " + ReflectController.this.mFrame);
              YTAGReflectLiveCheckJNIInterface.getInstance().FRSetBegin((Timeval)localObject);
              localObject = this.val$jsonArray.getJSONObject(ReflectController.this.mFrame);
              f1 = (float)((JSONObject)localObject).getDouble("R");
              f2 = (float)((JSONObject)localObject).getDouble("G");
              f3 = (float)((JSONObject)localObject).getDouble("B");
              f4 = (float)((JSONObject)localObject).getDouble("A");
              ReflectController.access$702(ReflectController.this, 0);
              if ((f1 != ReflectController.this.redbef) || (f2 != ReflectController.this.greenbef) || (f3 != ReflectController.this.bluebef) || (f4 != ReflectController.this.alphabef)) {
                break label423;
              }
              YTLogger.i("YoutuLightLiveCheck", "[ReflectController.onTick] rgba: keep bef");
              ReflectController.access$308(ReflectController.this);
              AppMethodBeat.o(43348);
              return;
            }
            if (ReflectController.this.mFrame == ReflectController.this.mConfigEnd)
            {
              YTLogger.i("YoutuLightLiveCheck", "change color end. mFrame: " + ReflectController.this.mFrame);
              YTAGReflectLiveCheckJNIInterface.getInstance().FRSetEnd(JNIUtils.getTimeval());
              continue;
            }
            if (ReflectController.this.mFrame != ReflectController.this.mConfigPoint) {
              continue;
            }
          }
          catch (JSONException localJSONException)
          {
            YTException.report(localJSONException);
            AppMethodBeat.o(43348);
            return;
          }
          YTLogger.i("YoutuLightLiveCheck", "change color point. mFrame: " + ReflectController.this.mFrame);
          YTAGReflectLiveCheckJNIInterface.getInstance().FRSetChangePointTime(JNIUtils.getTimeval());
          continue;
          label423:
          YTLogger.i("YoutuLightLiveCheck", "[ReflectController.onTick] rgba: " + f1 + " " + f2 + " " + f3 + " " + f4);
          ReflectController.access$1200(ReflectController.this, new ColorMatrixColorFilter(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, f1, 0.0F, 0.0F, 0.0F, 0.0F, f2, 0.0F, 0.0F, 0.0F, 0.0F, f3, 0.0F, 0.0F, 0.0F, f4, 0.0F }));
          ReflectController.access$802(ReflectController.this, f1);
          ReflectController.access$902(ReflectController.this, f2);
          ReflectController.access$1002(ReflectController.this, f3);
          ReflectController.access$1102(ReflectController.this, f4);
        }
      }
    };
    this.mCountDownTimer.start();
    AppMethodBeat.o(43356);
  }
  
  private void stopTimer()
  {
    AppMethodBeat.i(43354);
    if (this.mCountDownTimer != null)
    {
      this.mCountDownTimer.cancel();
      this.mCountDownTimer = null;
    }
    AppMethodBeat.o(43354);
  }
  
  public void cancel()
  {
    AppMethodBeat.i(43352);
    innerCancel();
    stopTimer();
    AppMethodBeat.o(43352);
  }
  
  /* Error */
  public void start(YTReflectLayout paramYTReflectLayout, ProcessManager.ProcessResult paramProcessResult, long paramLong)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: ldc_w 477
    //   6: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: aload_1
    //   11: putfield 155	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:mReflectLayout	Lcom/tencent/youtu/ytagreflectlivecheck/ui/YTReflectLayout;
    //   14: aload_0
    //   15: aload_2
    //   16: putfield 195	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:mCheckResult	Lcom/tencent/youtu/ytagreflectlivecheck/manager/ProcessManager$ProcessResult;
    //   19: aload_0
    //   20: lload_3
    //   21: putfield 191	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:mTag	J
    //   24: aload_0
    //   25: fconst_0
    //   26: putfield 135	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:redbef	F
    //   29: aload_0
    //   30: fconst_0
    //   31: putfield 137	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:greenbef	F
    //   34: aload_0
    //   35: fconst_0
    //   36: putfield 139	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:bluebef	F
    //   39: aload_0
    //   40: fconst_0
    //   41: putfield 141	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:alphabef	F
    //   44: invokestatic 481	com/tencent/youtu/ytagreflectlivecheck/manager/ProcessManager:dataWorker	()Lcom/tencent/youtu/ytagreflectlivecheck/worker/DataWorker;
    //   47: getfield 486	com/tencent/youtu/ytagreflectlivecheck/worker/DataWorker:mRgbConfigCode	Ljava/lang/String;
    //   50: astore_2
    //   51: ldc 52
    //   53: new 331	java/lang/StringBuilder
    //   56: dup
    //   57: ldc_w 488
    //   60: invokespecial 336	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   63: invokestatic 388	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:getAGSettings	()Lcom/tencent/youtu/ytagreflectlivecheck/YTAGReflectSettings;
    //   66: getfield 393	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectSettings:safetylevel	I
    //   69: invokevirtual 373	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   72: invokevirtual 344	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 311	com/tencent/youtu/ytcommon/tools/YTLogger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: new 490	org/json/JSONObject
    //   81: dup
    //   82: invokestatic 258	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface:getInstance	()Lcom/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface;
    //   85: iconst_1
    //   86: aload_2
    //   87: invokestatic 388	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:getAGSettings	()Lcom/tencent/youtu/ytagreflectlivecheck/YTAGReflectSettings;
    //   90: getfield 393	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectSettings:safetylevel	I
    //   93: invokevirtual 494	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface:FRInit	(ZLjava/lang/String;I)Ljava/lang/String;
    //   96: invokespecial 495	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   99: astore_1
    //   100: aload_1
    //   101: ldc 23
    //   103: invokevirtual 499	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   106: istore 5
    //   108: aload_1
    //   109: ldc 32
    //   111: invokevirtual 499	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   114: istore 7
    //   116: iload 7
    //   118: istore 6
    //   120: aload_1
    //   121: ldc 20
    //   123: invokevirtual 503	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   126: astore_1
    //   127: aload_0
    //   128: iload 5
    //   130: iload 7
    //   132: aload_1
    //   133: invokespecial 505	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:startTimer	(IILorg/json/JSONArray;)V
    //   136: ldc_w 477
    //   139: invokestatic 120	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   142: return
    //   143: astore_1
    //   144: aload_1
    //   145: invokestatic 287	com/tencent/youtu/ytcommon/tools/YTException:report	(Ljava/lang/Exception;)V
    //   148: aload_0
    //   149: getfield 195	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:mCheckResult	Lcom/tencent/youtu/ytagreflectlivecheck/manager/ProcessManager$ProcessResult;
    //   152: getstatic 91	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:ERRCODE_CONFIG_DECODE_FAILED	I
    //   155: ldc_w 507
    //   158: ldc_w 509
    //   161: aload_2
    //   162: invokestatic 512	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   165: invokevirtual 306	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   168: lload_3
    //   169: invokeinterface 516 6 0
    //   174: ldc_w 477
    //   177: invokestatic 120	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   180: return
    //   181: astore_1
    //   182: iconst_0
    //   183: istore 6
    //   185: iconst_0
    //   186: istore 5
    //   188: aload_1
    //   189: invokestatic 287	com/tencent/youtu/ytcommon/tools/YTException:report	(Ljava/lang/Exception;)V
    //   192: aload_0
    //   193: getfield 195	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:mCheckResult	Lcom/tencent/youtu/ytagreflectlivecheck/manager/ProcessManager$ProcessResult;
    //   196: getstatic 95	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:ERRCODE_GET_PARAMS_FAILED	I
    //   199: ldc_w 518
    //   202: ldc_w 520
    //   205: aload_2
    //   206: invokestatic 512	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   209: invokevirtual 306	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   212: lload_3
    //   213: invokeinterface 516 6 0
    //   218: aconst_null
    //   219: astore_1
    //   220: iload 6
    //   222: istore 7
    //   224: goto -97 -> 127
    //   227: astore_1
    //   228: aload_1
    //   229: invokestatic 287	com/tencent/youtu/ytcommon/tools/YTException:report	(Ljava/lang/Exception;)V
    //   232: aload_0
    //   233: invokespecial 473	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:innerCancel	()V
    //   236: aload_0
    //   237: getfield 195	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:mCheckResult	Lcom/tencent/youtu/ytagreflectlivecheck/manager/ProcessManager$ProcessResult;
    //   240: getstatic 97	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:ERRCODE_START_FAILED	I
    //   243: ldc_w 522
    //   246: ldc_w 524
    //   249: lload_3
    //   250: invokeinterface 516 6 0
    //   255: ldc_w 477
    //   258: invokestatic 120	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   261: return
    //   262: astore_1
    //   263: goto -75 -> 188
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	266	0	this	ReflectController
    //   0	266	1	paramYTReflectLayout	YTReflectLayout
    //   0	266	2	paramProcessResult	ProcessManager.ProcessResult
    //   0	266	3	paramLong	long
    //   106	81	5	i	int
    //   1	220	6	j	int
    //   114	109	7	k	int
    // Exception table:
    //   from	to	target	type
    //   51	100	143	org/json/JSONException
    //   100	108	181	org/json/JSONException
    //   127	136	227	java/lang/Exception
    //   108	116	262	org/json/JSONException
    //   120	127	262	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.controller.ReflectController
 * JD-Core Version:    0.7.0.1
 */