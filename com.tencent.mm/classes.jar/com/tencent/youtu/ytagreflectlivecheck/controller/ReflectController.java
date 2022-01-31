package com.tencent.youtu.ytagreflectlivecheck.controller;

import android.graphics.ColorMatrixColorFilter;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Looper;
import com.tencent.youtu.ytagreflectlivecheck.jni.JNIUtils;
import com.tencent.youtu.ytagreflectlivecheck.jni.YTAGReflectLiveCheckJNIInterface;
import com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager;
import com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager.ProcessResult;
import com.tencent.youtu.ytagreflectlivecheck.ui.YTReflectLayout;
import com.tencent.youtu.ytagreflectlivecheck.worker.CameraWorker;
import com.tencent.youtu.ytagreflectlivecheck.worker.TimerWorker;
import com.tencent.youtu.ytcommon.tools.YTLogger;
import org.json.JSONArray;

public class ReflectController
{
  private static final String CONFIG_ALPHA = "A";
  private static final String CONFIG_BLUE = "B";
  private static final String CONFIG_CONFIGS = "configs";
  private static final String CONFIG_DURATION = "duration";
  private static final String CONFIG_GREEN = "G";
  private static final String CONFIG_RED = "R";
  private static final String CONFIG_UNIT = "unit";
  public static final ColorMatrixColorFilter DEFAULT_MATRIX_COLOR_FILTER = new ColorMatrixColorFilter(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F });
  private static final int DELAY_TIME = 400;
  private static int ERRCODE_CONFIG_DECODE_FAILED = 0;
  private static int ERRCODE_FINISH_FAILED = 0;
  private static int ERRCODE_GET_PARAMS_FAILED = 0;
  private static int ERRCODE_START_FAILED = 0;
  private static int ERRCODE_USER_CANCEL = 1;
  private static final int STATE_DETECT_DELAY = 1;
  private static final int STATE_END = 2;
  private static final int STATE_RGB_CHANGE = 0;
  private static final String TAG = "YoutuLightLiveCheck";
  private static final long deltaTimeThreshold = 30L;
  private static long systemTime;
  private ProcessManager.ProcessResult mCheckResult;
  private int mConfigBegin = 0;
  private int mConfigEnd = 0;
  private int mConfigPoint = 0;
  private TimerWorker mCountDownTimer;
  private int mFrame = 0;
  private YTReflectLayout mReflectLayout;
  private int mState;
  private long time_finish_begin = 0L;
  private long time_finish_end = 0L;
  private long time_now = 0L;
  private long time_pre = 0L;
  private long time_start = 0L;
  
  static
  {
    ERRCODE_GET_PARAMS_FAILED = 2;
    ERRCODE_START_FAILED = 3;
    ERRCODE_FINISH_FAILED = 4;
    systemTime = System.currentTimeMillis();
  }
  
  /* Error */
  private boolean cameraStateControl(int paramInt)
  {
    // Byte code:
    //   0: invokestatic 174	com/tencent/youtu/ytagreflectlivecheck/manager/ProcessManager:cameraWorker	()Lcom/tencent/youtu/ytagreflectlivecheck/worker/CameraWorker;
    //   3: getfield 180	com/tencent/youtu/ytagreflectlivecheck/worker/CameraWorker:mCamera	Landroid/hardware/Camera;
    //   6: astore 20
    //   8: iload_1
    //   9: ifne +26 -> 35
    //   12: aload 20
    //   14: invokevirtual 186	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   17: astore 21
    //   19: aload 21
    //   21: iconst_1
    //   22: invokevirtual 192	android/hardware/Camera$Parameters:setAutoWhiteBalanceLock	(Z)V
    //   25: aload 20
    //   27: aload 21
    //   29: invokevirtual 196	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   32: goto +397 -> 429
    //   35: iload_1
    //   36: iconst_1
    //   37: if_icmpne +355 -> 392
    //   40: invokestatic 86	java/lang/System:currentTimeMillis	()J
    //   43: lstore_2
    //   44: aload 20
    //   46: invokevirtual 186	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   49: astore 21
    //   51: aload 21
    //   53: invokevirtual 199	android/hardware/Camera$Parameters:getExposureCompensation	()I
    //   56: istore_1
    //   57: invokestatic 86	java/lang/System:currentTimeMillis	()J
    //   60: lstore 4
    //   62: invokestatic 205	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface:getInstance	()Lcom/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface;
    //   65: iload_1
    //   66: i2d
    //   67: invokevirtual 209	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface:FRSetISObackup	(D)V
    //   70: invokestatic 86	java/lang/System:currentTimeMillis	()J
    //   73: lstore 6
    //   75: aload 21
    //   77: invokevirtual 212	android/hardware/Camera$Parameters:getMinExposureCompensation	()I
    //   80: istore_1
    //   81: invokestatic 86	java/lang/System:currentTimeMillis	()J
    //   84: lstore 8
    //   86: aload 21
    //   88: iload_1
    //   89: invokevirtual 215	android/hardware/Camera$Parameters:setExposureCompensation	(I)V
    //   92: invokestatic 86	java/lang/System:currentTimeMillis	()J
    //   95: lstore 10
    //   97: aload 20
    //   99: aload 21
    //   101: invokevirtual 196	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   104: invokestatic 86	java/lang/System:currentTimeMillis	()J
    //   107: lstore 12
    //   109: invokestatic 218	java/lang/System:nanoTime	()J
    //   112: ldc2_w 219
    //   115: ldiv
    //   116: lstore 14
    //   118: new 222	com/tencent/youtu/ytagreflectlivecheck/jni/cppDefine/Timeval
    //   121: dup
    //   122: lload 14
    //   124: ldc2_w 223
    //   127: ldiv
    //   128: lload 14
    //   130: ldc2_w 223
    //   133: lrem
    //   134: l2i
    //   135: invokespecial 227	com/tencent/youtu/ytagreflectlivecheck/jni/cppDefine/Timeval:<init>	(JI)V
    //   138: astore 20
    //   140: invokestatic 86	java/lang/System:currentTimeMillis	()J
    //   143: lstore 14
    //   145: invokestatic 205	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface:getInstance	()Lcom/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface;
    //   148: aload 20
    //   150: invokevirtual 231	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface:FRSetISOchangeTime	(Lcom/tencent/youtu/ytagreflectlivecheck/jni/cppDefine/Timeval;)V
    //   153: invokestatic 86	java/lang/System:currentTimeMillis	()J
    //   156: lstore 16
    //   158: invokestatic 205	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface:getInstance	()Lcom/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface;
    //   161: iconst_1
    //   162: invokevirtual 234	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface:FRSetDoingDelayCalc	(Z)V
    //   165: invokestatic 86	java/lang/System:currentTimeMillis	()J
    //   168: lstore 18
    //   170: ldc 235
    //   172: new 237	java/lang/StringBuilder
    //   175: dup
    //   176: ldc 239
    //   178: invokespecial 242	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   181: lload 4
    //   183: lload_2
    //   184: lsub
    //   185: invokevirtual 246	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   188: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokestatic 256	com/tencent/youtu/ytcommon/tools/YTLogger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   194: ldc 235
    //   196: new 237	java/lang/StringBuilder
    //   199: dup
    //   200: ldc_w 258
    //   203: invokespecial 242	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   206: lload 6
    //   208: lload 4
    //   210: lsub
    //   211: invokevirtual 246	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   214: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 256	com/tencent/youtu/ytcommon/tools/YTLogger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   220: ldc 235
    //   222: new 237	java/lang/StringBuilder
    //   225: dup
    //   226: ldc_w 260
    //   229: invokespecial 242	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   232: lload 8
    //   234: lload 6
    //   236: lsub
    //   237: invokevirtual 246	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   240: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: invokestatic 256	com/tencent/youtu/ytcommon/tools/YTLogger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   246: ldc 235
    //   248: new 237	java/lang/StringBuilder
    //   251: dup
    //   252: ldc_w 262
    //   255: invokespecial 242	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   258: lload 10
    //   260: lload 8
    //   262: lsub
    //   263: invokevirtual 246	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   266: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   269: invokestatic 256	com/tencent/youtu/ytcommon/tools/YTLogger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   272: ldc 235
    //   274: new 237	java/lang/StringBuilder
    //   277: dup
    //   278: ldc_w 264
    //   281: invokespecial 242	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   284: lload 12
    //   286: lload 10
    //   288: lsub
    //   289: invokevirtual 246	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   292: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: invokestatic 256	com/tencent/youtu/ytcommon/tools/YTLogger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   298: ldc 235
    //   300: new 237	java/lang/StringBuilder
    //   303: dup
    //   304: ldc_w 266
    //   307: invokespecial 242	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   310: lload 14
    //   312: lload 12
    //   314: lsub
    //   315: invokevirtual 246	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   318: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: invokestatic 256	com/tencent/youtu/ytcommon/tools/YTLogger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   324: ldc 235
    //   326: new 237	java/lang/StringBuilder
    //   329: dup
    //   330: ldc_w 268
    //   333: invokespecial 242	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   336: lload 16
    //   338: lload 14
    //   340: lsub
    //   341: invokevirtual 246	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   344: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   347: invokestatic 256	com/tencent/youtu/ytcommon/tools/YTLogger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   350: ldc 235
    //   352: new 237	java/lang/StringBuilder
    //   355: dup
    //   356: ldc_w 270
    //   359: invokespecial 242	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   362: lload 18
    //   364: lload 16
    //   366: lsub
    //   367: invokevirtual 246	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   370: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: invokestatic 256	com/tencent/youtu/ytcommon/tools/YTLogger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   376: goto +53 -> 429
    //   379: astore 20
    //   381: aload 20
    //   383: invokestatic 276	com/tencent/youtu/ytcommon/tools/YTException:report	(Ljava/lang/Exception;)V
    //   386: iconst_0
    //   387: ireturn
    //   388: astore 20
    //   390: iconst_0
    //   391: ireturn
    //   392: iload_1
    //   393: iconst_2
    //   394: if_icmpne +35 -> 429
    //   397: aload 20
    //   399: invokevirtual 186	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   402: astore 21
    //   404: aload 21
    //   406: invokestatic 205	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface:getInstance	()Lcom/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface;
    //   409: invokevirtual 280	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface:FRGetISObackup	()D
    //   412: d2i
    //   413: invokevirtual 215	android/hardware/Camera$Parameters:setExposureCompensation	(I)V
    //   416: aload 21
    //   418: iconst_0
    //   419: invokevirtual 192	android/hardware/Camera$Parameters:setAutoWhiteBalanceLock	(Z)V
    //   422: aload 20
    //   424: aload 21
    //   426: invokevirtual 196	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   429: iconst_1
    //   430: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	431	0	this	ReflectController
    //   0	431	1	paramInt	int
    //   43	141	2	l1	long
    //   60	149	4	l2	long
    //   73	162	6	l3	long
    //   84	177	8	l4	long
    //   95	192	10	l5	long
    //   107	206	12	l6	long
    //   116	223	14	l7	long
    //   156	209	16	l8	long
    //   168	195	18	l9	long
    //   6	143	20	localObject	Object
    //   379	3	20	localException1	java.lang.Exception
    //   388	35	20	localException2	java.lang.Exception
    //   17	408	21	localParameters	android.hardware.Camera.Parameters
    // Exception table:
    //   from	to	target	type
    //   12	32	379	java/lang/Exception
    //   40	51	379	java/lang/Exception
    //   57	376	379	java/lang/Exception
    //   397	429	379	java/lang/Exception
    //   51	57	388	java/lang/Exception
  }
  
  private void changeState(int paramInt)
  {
    this.mState = paramInt;
    YTLogger.i("YoutuLightLiveCheck", "changeState. state: " + paramInt);
    cameraStateControl(paramInt);
    if (paramInt == 0)
    {
      this.mConfigBegin = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetConfigBegin();
      this.mConfigEnd = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetConfigEnd();
      this.mConfigPoint = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetChangePoint();
      ProcessManager.cameraWorker().setCameraPreviewCallback(new ReflectController.3(this));
    }
    while (paramInt != 2) {
      return;
    }
    YTLogger.i("mCountDownTimer", "cameraStateControl:" + (System.currentTimeMillis() - this.time_finish_begin));
    ProcessManager.cameraWorker().setCameraPreviewCallback(null);
    YTLogger.i("mCountDownTimer", "setCameraPreviewCallback:" + (System.currentTimeMillis() - this.time_finish_begin));
    this.time_finish_end = System.currentTimeMillis();
    YTLogger.i("mCountDownTimer", "onFinish. to finish: " + (this.time_finish_begin - this.time_start) + " to finish_end: " + (this.time_finish_end - this.time_finish_begin));
    this.mCheckResult.onSuccess();
  }
  
  private void innerCancel()
  {
    if (this.mState == 0) {
      setColorMatrixColorFilter(DEFAULT_MATRIX_COLOR_FILTER);
    }
  }
  
  private void onPreviewFrameReceived(byte[] paramArrayOfByte, Camera paramCamera)
  {
    int i = ProcessManager.cameraWorker().getDesiredPreviewWidth();
    int j = ProcessManager.cameraWorker().getDesiredPreviewHeight();
    if (this.mState == 0)
    {
      k = this.mConfigBegin - 3;
      m = this.mConfigEnd + 3;
      n = this.mFrame;
      YTLogger.d("YoutuLightLiveCheck", "onPreviewFrameReceived. beginFrame: " + k + " endFrame: " + m + " currentFrame: " + n);
      if ((n > k) && (n < m))
      {
        l = System.currentTimeMillis();
        YTLogger.d("YoutuLightLiveCheck", "onPreviewFrameReceived. insertYuv and time");
        systemTime = l;
        YTAGReflectLiveCheckJNIInterface.getInstance().FRPushYuv(paramArrayOfByte, i, j);
        YTAGReflectLiveCheckJNIInterface.getInstance().FRPushCaptureTime(JNIUtils.getTimeval());
      }
    }
    while (this.mState != 1)
    {
      int k;
      int m;
      int n;
      long l;
      return;
    }
    YTLogger.d("YoutuLightLiveCheck", "put IOS timeval ");
    YTAGReflectLiveCheckJNIInterface.getInstance().FRPushISOImgYuv(paramArrayOfByte, i, j);
    YTAGReflectLiveCheckJNIInterface.getInstance().FRPushISOCaptureTime(JNIUtils.getTimeval());
  }
  
  private void setColorMatrixColorFilter(final ColorMatrixColorFilter paramColorMatrixColorFilter)
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      this.mReflectLayout.setColorMatrixColorFilter(paramColorMatrixColorFilter);
      return;
    }
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public void run()
      {
        ReflectController.this.mReflectLayout.setColorMatrixColorFilter(paramColorMatrixColorFilter);
      }
    });
  }
  
  private void startTimer(int paramInt1, int paramInt2, JSONArray paramJSONArray)
  {
    YTLogger.i("YoutuLightLiveCheck", "start timer.");
    changeState(0);
    this.mFrame = 0;
    YTLogger.i("mCountDownTimer", "duration:" + paramInt1 + " unit: " + paramInt2);
    this.time_pre = System.currentTimeMillis();
    this.time_start = this.time_pre;
    this.mCountDownTimer = new ReflectController.2(this, paramInt1, paramInt2, paramInt2, paramJSONArray);
    this.mCountDownTimer.start();
  }
  
  private void stopTimer()
  {
    if (this.mCountDownTimer != null)
    {
      this.mCountDownTimer.cancel();
      this.mCountDownTimer = null;
    }
  }
  
  public void cancel()
  {
    innerCancel();
    this.mCheckResult.onFailed(ERRCODE_USER_CANCEL, "User canceled. ", "User actively closes the proccess.");
  }
  
  /* Error */
  public void start(YTReflectLayout paramYTReflectLayout, ProcessManager.ProcessResult paramProcessResult)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: putfield 121	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:mReflectLayout	Lcom/tencent/youtu/ytagreflectlivecheck/ui/YTReflectLayout;
    //   5: aload_0
    //   6: aload_2
    //   7: putfield 136	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:mCheckResult	Lcom/tencent/youtu/ytagreflectlivecheck/manager/ProcessManager$ProcessResult;
    //   10: invokestatic 431	com/tencent/youtu/ytagreflectlivecheck/manager/ProcessManager:dataWorker	()Lcom/tencent/youtu/ytagreflectlivecheck/worker/DataWorker;
    //   13: getfield 436	com/tencent/youtu/ytagreflectlivecheck/worker/DataWorker:mRgbConfigCode	Ljava/lang/String;
    //   16: astore_2
    //   17: new 438	org/json/JSONObject
    //   20: dup
    //   21: invokestatic 205	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface:getInstance	()Lcom/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface;
    //   24: iconst_1
    //   25: aload_2
    //   26: invokevirtual 442	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface:FRInit	(ZLjava/lang/String;)Ljava/lang/String;
    //   29: invokespecial 443	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   32: astore_1
    //   33: aload_1
    //   34: ldc 19
    //   36: invokevirtual 447	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   39: istore 4
    //   41: aload_1
    //   42: ldc 28
    //   44: invokevirtual 447	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   47: istore_3
    //   48: aload_1
    //   49: ldc 16
    //   51: invokevirtual 451	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   54: astore_1
    //   55: aload_0
    //   56: iload 4
    //   58: iload_3
    //   59: aload_1
    //   60: invokespecial 453	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:startTimer	(IILorg/json/JSONArray;)V
    //   63: return
    //   64: astore_1
    //   65: aload_1
    //   66: invokestatic 276	com/tencent/youtu/ytcommon/tools/YTException:report	(Ljava/lang/Exception;)V
    //   69: aload_0
    //   70: getfield 136	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:mCheckResult	Lcom/tencent/youtu/ytagreflectlivecheck/manager/ProcessManager$ProcessResult;
    //   73: getstatic 72	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:ERRCODE_CONFIG_DECODE_FAILED	I
    //   76: ldc_w 455
    //   79: new 237	java/lang/StringBuilder
    //   82: dup
    //   83: ldc_w 457
    //   86: invokespecial 242	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   89: aload_2
    //   90: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokeinterface 424 4 0
    //   101: return
    //   102: astore_1
    //   103: iconst_0
    //   104: istore_3
    //   105: iconst_0
    //   106: istore 4
    //   108: aload_1
    //   109: invokestatic 276	com/tencent/youtu/ytcommon/tools/YTException:report	(Ljava/lang/Exception;)V
    //   112: aload_0
    //   113: getfield 136	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:mCheckResult	Lcom/tencent/youtu/ytagreflectlivecheck/manager/ProcessManager$ProcessResult;
    //   116: getstatic 76	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:ERRCODE_GET_PARAMS_FAILED	I
    //   119: ldc_w 459
    //   122: new 237	java/lang/StringBuilder
    //   125: dup
    //   126: ldc_w 461
    //   129: invokespecial 242	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   132: aload_2
    //   133: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokeinterface 424 4 0
    //   144: aconst_null
    //   145: astore_1
    //   146: goto -91 -> 55
    //   149: astore_1
    //   150: aload_1
    //   151: invokestatic 276	com/tencent/youtu/ytcommon/tools/YTException:report	(Ljava/lang/Exception;)V
    //   154: aload_0
    //   155: invokespecial 416	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:innerCancel	()V
    //   158: aload_0
    //   159: getfield 136	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:mCheckResult	Lcom/tencent/youtu/ytagreflectlivecheck/manager/ProcessManager$ProcessResult;
    //   162: getstatic 78	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:ERRCODE_START_FAILED	I
    //   165: ldc_w 463
    //   168: ldc_w 465
    //   171: invokeinterface 424 4 0
    //   176: return
    //   177: astore_1
    //   178: iconst_0
    //   179: istore_3
    //   180: goto -72 -> 108
    //   183: astore_1
    //   184: goto -76 -> 108
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	187	0	this	ReflectController
    //   0	187	1	paramYTReflectLayout	YTReflectLayout
    //   0	187	2	paramProcessResult	ProcessManager.ProcessResult
    //   47	133	3	i	int
    //   39	68	4	j	int
    // Exception table:
    //   from	to	target	type
    //   17	33	64	org/json/JSONException
    //   33	41	102	org/json/JSONException
    //   55	63	149	java/lang/Exception
    //   41	48	177	org/json/JSONException
    //   48	55	183	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.controller.ReflectController
 * JD-Core Version:    0.7.0.1
 */