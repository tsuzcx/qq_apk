package com.tencent.youtu.sdkkitframework.liveness;

import android.graphics.YuvImage;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.common.YtSDKStats;
import com.tencent.youtu.sdkkitframework.common.YtVideoEncoder;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.ProcessHelper;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper.StateClassName;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtFrameworkFireEventType;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKKitFrameworkWorkMode;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKPlatformContext;
import com.tencent.youtu.ytfacetrack.YTFaceTrack;
import com.tencent.youtu.ytfacetrack.YTFaceTrack.FaceStatus;
import com.tencent.youtu.ytfacetrack.param.YTFaceTrackParam;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface.PoseDetectGetBestImage;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface.PoseDetectOnFrame;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface.PoseDetectResult;
import com.tencent.youtu.ytposedetect.data.YTActRefData;
import com.tencent.youtu.ytposedetect.jni.YTPoseDetectJNIInterface.IYtLoggerListener;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class ActionLivenessState
  extends YtFSMBaseState
{
  private static final String TAG;
  private YTActRefData actReflectData;
  int actReflectUXMode;
  private int actionContinuousFailedCount;
  private int actionCurrentIndex;
  private String[] actionDataParsed;
  private YTPoseDetectInterface.PoseDetectOnFrame actionFrameHandler;
  private int actionLiveType;
  private ArrayList<BestFrame> bestFrames;
  private int codecSettingBitRate;
  private int codecSettingFrameRate;
  private int codecSettingiFrameInterval;
  private int continuousDetectCount;
  private String controlConfig;
  private int currentRotateState;
  private String extraTips;
  private YTFaceTrack.FaceStatus[] faceStatus;
  private String innerMp4Path;
  private boolean isActionFinished;
  private boolean isLoadResourceOnline;
  private String legitimatePoseVersion;
  private YTFaceTrackParam mOriginParam;
  private boolean needCheckMultiFaces;
  private boolean needLocalConfig;
  private boolean needManualTrigger;
  private YtSDKKitCommon.StateNameHelper.StateClassName nextStateName;
  private int poseReadyCount;
  private SilentLivenessState.FacePreviewingAdvise poseState;
  private int securityLevel;
  private int stableCountNum;
  private YtVideoEncoder videoEncoder;
  
  static
  {
    AppMethodBeat.i(247058);
    TAG = ActionLivenessState.class.getSimpleName();
    AppMethodBeat.o(247058);
  }
  
  public ActionLivenessState()
  {
    AppMethodBeat.i(247013);
    this.legitimatePoseVersion = "3.5.4";
    this.continuousDetectCount = 0;
    this.poseState = SilentLivenessState.FacePreviewingAdvise.ADVISE_NAN;
    this.actionLiveType = 1;
    this.actionContinuousFailedCount = 0;
    this.isActionFinished = false;
    this.isLoadResourceOnline = false;
    this.innerMp4Path = (Environment.getExternalStorageDirectory().getPath() + "/temp.mp4");
    this.securityLevel = 1;
    this.needLocalConfig = false;
    this.codecSettingBitRate = 2097152;
    this.codecSettingFrameRate = 30;
    this.codecSettingiFrameInterval = 1;
    this.extraTips = "";
    this.needManualTrigger = false;
    this.poseReadyCount = 0;
    this.stableCountNum = 5;
    this.controlConfig = "";
    this.actReflectUXMode = 0;
    this.needCheckMultiFaces = false;
    AppMethodBeat.o(247013);
  }
  
  private void AddOptPose(byte[] paramArrayOfByte, int paramInt1, int paramInt2, float[] paramArrayOfFloat, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(247035);
    float f = YtSDKKitCommon.ProcessHelper.preCheckCloseEyeScore(paramArrayOfFloat);
    BestFrame localBestFrame = new BestFrame();
    localBestFrame.eyeScore = f;
    localBestFrame.pitch = paramFloat1;
    localBestFrame.yaw = paramFloat2;
    localBestFrame.roll = paramFloat3;
    localBestFrame.f5p = YtSDKKitCommon.ProcessHelper.convert90PTo5P(paramArrayOfFloat);
    localBestFrame.frame = new YuvImage(paramArrayOfByte, 17, paramInt1, paramInt2, null);
    this.bestFrames.add(localBestFrame);
    if (this.bestFrames.size() > 20) {
      this.bestFrames.remove(0);
    }
    AppMethodBeat.o(247035);
  }
  
  private boolean changeToNextAction(String[] paramArrayOfString, int paramInt)
  {
    AppMethodBeat.i(247031);
    if (paramArrayOfString.length == 0)
    {
      AppMethodBeat.o(247031);
      return false;
    }
    this.actionCurrentIndex = paramInt;
    if (this.actionCurrentIndex >= paramArrayOfString.length)
    {
      AppMethodBeat.o(247031);
      return false;
    }
    paramInt = Integer.parseInt(paramArrayOfString[this.actionCurrentIndex]);
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.stateData.put("current_action_type", Integer.valueOf(paramInt));
      YtLogger.i(TAG, "action check rounds: " + this.actionCurrentIndex + "start check pose: " + this.actionLiveType);
      YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE)).handleStateAction("reset_timeout", null);
      this.poseReadyCount = 0;
      AppMethodBeat.o(247031);
      return true;
      this.actionLiveType = 1;
      continue;
      this.actionLiveType = 2;
      continue;
      this.actionLiveType = 3;
      continue;
      this.actionLiveType = 4;
      continue;
      this.actionLiveType = 5;
    }
  }
  
  private void clearData()
  {
    AppMethodBeat.i(247020);
    this.bestFrames = new ArrayList();
    this.actionContinuousFailedCount = 0;
    this.isActionFinished = false;
    this.actionCurrentIndex = -1;
    this.poseReadyCount = 0;
    this.poseState = SilentLivenessState.FacePreviewingAdvise.ADVISE_NAN;
    changeToNextAction(this.actionDataParsed, this.actionCurrentIndex + 1);
    this.nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE;
    this.videoEncoder.abortEncoding();
    startPose();
    AppMethodBeat.o(247020);
  }
  
  private String getTipsByPoseType(int paramInt)
  {
    AppMethodBeat.i(247028);
    if (paramInt == 1)
    {
      AppMethodBeat.o(247028);
      return "fl_act_blink";
    }
    if (paramInt == 2)
    {
      AppMethodBeat.o(247028);
      return "fl_act_open_mouth";
    }
    if (paramInt == 4)
    {
      AppMethodBeat.o(247028);
      return "fl_act_shake_head";
    }
    if (paramInt == 3)
    {
      AppMethodBeat.o(247028);
      return "fl_act_nod_head";
    }
    if (paramInt == 5)
    {
      AppMethodBeat.o(247028);
      return "fl_act_silence";
    }
    String str = "fl_act_error".concat(String.valueOf(paramInt));
    AppMethodBeat.o(247028);
    return str;
  }
  
  private void sendFSMEvent(HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(247033);
    YtFSM.getInstance().sendFSMEvent(paramHashMap);
    AppMethodBeat.o(247033);
  }
  
  private void startPose()
  {
    AppMethodBeat.i(247021);
    this.actionFrameHandler = new YTPoseDetectInterface.PoseDetectOnFrame()
    {
      public void onCanReflect()
      {
        AppMethodBeat.i(246975);
        ActionLivenessState.access$902(ActionLivenessState.this, YTPoseDetectInterface.getActReflectData());
        AppMethodBeat.o(246975);
      }
      
      public void onFailed(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(246972);
        YtSDKStats.getInstance().reportInfo("pose state ".concat(String.valueOf(paramAnonymousInt)));
        YtLogger.d(ActionLivenessState.TAG, "YTPoseDetectInterface.poseDetect.onFailed: " + paramAnonymousInt + " s: " + paramAnonymousString1);
        ActionLivenessState.access$808(ActionLivenessState.this);
        AppMethodBeat.o(246972);
      }
      
      public void onRecordingDone(byte[][] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(246976);
        YtLogger.d(ActionLivenessState.TAG, "收到视频上传通知，帧数：" + paramAnonymousArrayOfByte.length + " 每帧width：" + paramAnonymousInt1 + " 每帧height: " + paramAnonymousInt2);
        if (!ActionLivenessState.this.videoEncoder.isEncodingStarted())
        {
          YtLogger.d(ActionLivenessState.TAG, "??Start encoder");
          YtLogger.i(ActionLivenessState.TAG, "codec info: rotatedWith: " + paramAnonymousInt1 + "rotatedHeight: " + paramAnonymousInt2 + " bitrate: " + ActionLivenessState.this.codecSettingBitRate + " framerate" + ActionLivenessState.this.codecSettingFrameRate + " iframeinterval" + ActionLivenessState.this.codecSettingiFrameInterval);
          ActionLivenessState.this.videoEncoder.startEncoding(paramAnonymousInt1, paramAnonymousInt2, new File(ActionLivenessState.this.innerMp4Path), ActionLivenessState.this.codecSettingBitRate, ActionLivenessState.this.codecSettingFrameRate, ActionLivenessState.this.codecSettingiFrameInterval);
        }
        YtLogger.d(ActionLivenessState.TAG, "action framesize:" + paramAnonymousArrayOfByte.length);
        int i = 0;
        Object localObject;
        while (i < paramAnonymousArrayOfByte.length)
        {
          YtLogger.d(ActionLivenessState.TAG, "Rotate yuv size" + paramAnonymousInt1 + "x" + paramAnonymousInt2 + " rotate:" + YtFSM.getInstance().getContext().currentRotateState);
          localObject = new YuvImage(paramAnonymousArrayOfByte[i], 17, paramAnonymousInt1, paramAnonymousInt2, null);
          ActionLivenessState.this.videoEncoder.queueFrame((YuvImage)localObject);
          ActionLivenessState.this.videoEncoder.encode();
          i += 1;
        }
        if (!ActionLivenessState.this.isActionFinished)
        {
          YTPoseDetectInterface.reset();
          AppMethodBeat.o(246976);
          return;
        }
        ActionLivenessState.this.videoEncoder.stopEncoding();
        for (;;)
        {
          try
          {
            localObject = new FileInputStream(new File(ActionLivenessState.this.innerMp4Path));
            if (((FileInputStream)localObject).available() != 0) {
              paramAnonymousArrayOfByte = new byte[((FileInputStream)localObject).available()];
            }
            paramAnonymousArrayOfByte = null;
          }
          catch (Exception localException1)
          {
            try
            {
              ((FileInputStream)localObject).read(paramAnonymousArrayOfByte);
              ((FileInputStream)localObject).close();
              ActionLivenessState.this.stateData.put("frames", paramAnonymousArrayOfByte);
              ActionLivenessState.this.stateData.put("mediacodec_color_format", Integer.valueOf(ActionLivenessState.this.videoEncoder.getColorFormat()));
              if (YtFSM.getInstance().getWorkMode() == YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTREFLECT_TYPE) {
                continue;
              }
              YTPoseDetectInterface.getBestImage(new YTPoseDetectInterface.PoseDetectGetBestImage()
              {
                public void onGetBestImage(byte[] paramAnonymous2ArrayOfByte, int paramAnonymous2Int1, int paramAnonymous2Int2)
                {
                  AppMethodBeat.i(246963);
                  YtLogger.d(ActionLivenessState.TAG, "获取到最优图. width:" + paramAnonymous2Int1 + " height: " + paramAnonymous2Int2 + " bytes size: " + paramAnonymous2ArrayOfByte.length);
                  paramAnonymous2ArrayOfByte = new YuvImage(paramAnonymous2ArrayOfByte, 17, paramAnonymous2Int1, paramAnonymous2Int2, null);
                  ActionLivenessState.this.stateData.put("best_frame", paramAnonymous2ArrayOfByte);
                  ActionLivenessState.access$1802(ActionLivenessState.this, YtSDKKitCommon.StateNameHelper.StateClassName.NET_LIVENESS_REQ_RESULT_STATE);
                  AppMethodBeat.o(246963);
                }
              }, true);
              AppMethodBeat.o(246976);
              return;
            }
            catch (Exception localException2)
            {
              continue;
            }
            localException1 = localException1;
            paramAnonymousArrayOfByte = null;
            YtLogger.e(ActionLivenessState.TAG, "Failed fetch action video " + localException1.getLocalizedMessage());
            continue;
            if (YtFSM.getInstance().getWorkMode() == YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTREFLECT_TYPE)
            {
              YTPoseDetectInterface.getBestImage(new YTPoseDetectInterface.PoseDetectGetBestImage()
              {
                public void onGetBestImage(byte[] paramAnonymous2ArrayOfByte, int paramAnonymous2Int1, int paramAnonymous2Int2)
                {
                  AppMethodBeat.i(246967);
                  YtLogger.d(ActionLivenessState.TAG, "获取到最优图. width:" + paramAnonymous2Int1 + " height: " + paramAnonymous2Int2 + " bytes size: " + paramAnonymous2ArrayOfByte.length);
                  paramAnonymous2ArrayOfByte = new YuvImage(paramAnonymous2ArrayOfByte, 17, paramAnonymous2Int1, paramAnonymous2Int2, null);
                  ActionLivenessState.this.stateData.put("best_frame", paramAnonymous2ArrayOfByte);
                  Collections.sort(ActionLivenessState.this.bestFrames, new ActionLivenessState.BestFrameEyeRating(ActionLivenessState.this));
                  paramAnonymous2Int2 = Math.min(ActionLivenessState.this.bestFrames.size(), 5);
                  paramAnonymous2ArrayOfByte = new ArrayList();
                  paramAnonymous2Int1 = 0;
                  while (paramAnonymous2Int1 < paramAnonymous2Int2)
                  {
                    paramAnonymous2ArrayOfByte.add(ActionLivenessState.this.bestFrames.get(paramAnonymous2Int1));
                    paramAnonymous2Int1 += 1;
                  }
                  ActionLivenessState.this.stateData.put("frame_list", paramAnonymous2ArrayOfByte);
                  ActionLivenessState.this.stateData.put("act_reflect_data", ActionLivenessState.this.actReflectData);
                  ActionLivenessState.access$1802(ActionLivenessState.this, YtSDKKitCommon.StateNameHelper.StateClassName.REFLECT_STATE);
                  AppMethodBeat.o(246967);
                }
              }, true);
              AppMethodBeat.o(246976);
              return;
            }
            YtLogger.e(ActionLivenessState.TAG, "unimplemented work mode " + YtFSM.getInstance().getWorkMode());
            AppMethodBeat.o(246976);
            return;
          }
        }
      }
      
      public void onSuccess(int paramAnonymousInt)
      {
        AppMethodBeat.i(246970);
        ActionLivenessState.access$102(ActionLivenessState.this, "");
        if (paramAnonymousInt == 1)
        {
          YtLogger.d(ActionLivenessState.TAG, "Detect pose with sequence " + ActionLivenessState.this.actionDataParsed.length);
          if (ActionLivenessState.access$500(ActionLivenessState.this, ActionLivenessState.this.actionDataParsed, ActionLivenessState.this.actionCurrentIndex + 1)) {
            YtLogger.i(ActionLivenessState.TAG, "start check pose: " + ActionLivenessState.this.actionLiveType);
          }
        }
        for (;;)
        {
          YtSDKStats.getInstance().reportInfo("pose state ".concat(String.valueOf(paramAnonymousInt)));
          AppMethodBeat.o(246970);
          return;
          YtLogger.i(ActionLivenessState.TAG, "action seq all done");
          ActionLivenessState.access$702(ActionLivenessState.this, true);
          continue;
          if (paramAnonymousInt == -4)
          {
            YtLogger.w(ActionLivenessState.TAG, "Act failed ".concat(String.valueOf(paramAnonymousInt)));
            ActionLivenessState.access$102(ActionLivenessState.this, "fl_act_light_not_right");
          }
          else if (paramAnonymousInt == -5)
          {
            YtLogger.w(ActionLivenessState.TAG, "Act failed ".concat(String.valueOf(paramAnonymousInt)));
            ActionLivenessState.access$102(ActionLivenessState.this, "fl_act_screen_shaking");
          }
          else if ((paramAnonymousInt != -1) && (paramAnonymousInt != 0))
          {
            YtLogger.w(ActionLivenessState.TAG, "Act failed ".concat(String.valueOf(paramAnonymousInt)));
          }
        }
      }
    };
    YTPoseDetectInterface.start(YtFSM.getInstance().getContext().currentAppContext, YtFSM.getInstance().getContext().currentCamera, YtFSM.getInstance().getContext().currentCameraId, new YTPoseDetectInterface.PoseDetectResult()
    {
      public void onFailed(final int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(246985);
        YtSDKStats.getInstance().reportError(paramAnonymousInt, "failed to init pose sdk");
        YtFSM.getInstance().sendFSMEvent(new HashMap() {});
        ActionLivenessState.access$1802(ActionLivenessState.this, YtSDKKitCommon.StateNameHelper.StateClassName.IDLE_STATE);
        AppMethodBeat.o(246985);
      }
      
      public void onSuccess()
      {
        AppMethodBeat.i(246983);
        YtLogger.d(ActionLivenessState.TAG, "start success");
        AppMethodBeat.o(246983);
      }
    });
    AppMethodBeat.o(247021);
  }
  
  public void enter()
  {
    AppMethodBeat.i(247019);
    super.enter();
    for (;;)
    {
      try
      {
        Object localObject = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE));
        this.continuousDetectCount = ((Integer)((YtFSMBaseState)localObject).getStateDataBy("continuous_detect_count")).intValue();
        this.faceStatus = ((YTFaceTrack.FaceStatus[])((YtFSMBaseState)localObject).getStateDataBy("face_status"));
        this.poseState = ((SilentLivenessState.FacePreviewingAdvise)((YtFSMBaseState)localObject).getStateDataBy("pose_state"));
        localObject = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_FETCH_STATE));
        int i;
        if ((localObject != null) && (!this.needLocalConfig))
        {
          localObject = (String)((YtFSMBaseState)localObject).getStateDataBy("action_data");
          YtLogger.d(TAG, "action data :".concat(String.valueOf(localObject)));
          this.actionDataParsed = ((String)localObject).split(",");
          if (this.actionDataParsed.length > this.actionCurrentIndex) {
            i = Integer.parseInt(this.actionDataParsed[this.actionCurrentIndex]);
          }
        }
        switch (i)
        {
        case 0: 
          this.stateData.put("current_action_type", Integer.valueOf(i));
          if (this.actReflectUXMode == 1)
          {
            this.actionLiveType = 5;
            this.actionDataParsed = new String[] { "5" };
          }
          this.stateData.put("action_seq", this.actionDataParsed);
          AppMethodBeat.o(247019);
          return;
        }
      }
      catch (Exception localException)
      {
        YtLogger.e(TAG, "action enter failed " + localException.getLocalizedMessage());
        CommonUtils.reportException("action enter failed ", localException);
        AppMethodBeat.o(247019);
        return;
      }
      this.actionLiveType = 1;
      continue;
      this.actionLiveType = 2;
      continue;
      this.actionLiveType = 3;
      continue;
      this.actionLiveType = 4;
      continue;
      this.actionLiveType = 5;
    }
  }
  
  public void enterFirst()
  {
    AppMethodBeat.i(247016);
    YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE)).handleStateAction("reset_timeout", null);
    Object localObject1 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_FETCH_STATE));
    if (localObject1 != null) {}
    try
    {
      localObject2 = ((YtFSMBaseState)localObject1).getStateDataBy("video_bitrate");
      if (localObject2 != null) {
        this.codecSettingBitRate = ((Integer)localObject2).intValue();
      }
      localObject2 = ((YtFSMBaseState)localObject1).getStateDataBy("video_framerate");
      if (localObject2 != null) {
        this.codecSettingFrameRate = ((Integer)localObject2).intValue();
      }
      localObject2 = ((YtFSMBaseState)localObject1).getStateDataBy("video_iframeinterval");
      if (localObject2 != null) {
        this.codecSettingiFrameInterval = ((Integer)localObject2).intValue();
      }
      localObject1 = (String)((YtFSMBaseState)localObject1).getStateDataBy("control_config");
      if (localObject1 != null) {
        this.controlConfig = ((String)localObject1);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2;
        int j;
        int i;
        YtLogger.e(TAG, "action enter first failed:" + localException.getLocalizedMessage());
      }
      YTFaceTrackParam localYTFaceTrackParam = this.mOriginParam;
      localYTFaceTrackParam.detect_interval = 30;
      YTFaceTrack.getInstance().SetFaceTrackParam(localYTFaceTrackParam);
      AppMethodBeat.o(247016);
    }
    if (!this.controlConfig.isEmpty())
    {
      localObject1 = this.controlConfig.split("&");
      if (localObject1.length > 0)
      {
        j = localObject1.length;
        i = 0;
        while (i < j)
        {
          localObject2 = localObject1[i].split("=");
          if ((localObject2.length > 1) && (localObject2[0].equals("actref_ux_mode"))) {
            this.actReflectUXMode = Integer.parseInt(localObject2[1]);
          }
          i += 1;
        }
      }
    }
  }
  
  public void handleEvent(YtSDKKitFramework.YtFrameworkFireEventType paramYtFrameworkFireEventType, Object paramObject)
  {
    AppMethodBeat.i(247024);
    super.handleEvent(paramYtFrameworkFireEventType, paramObject);
    if ((this.needManualTrigger) && (paramYtFrameworkFireEventType == YtSDKKitFramework.YtFrameworkFireEventType.YT_EVENT_TRIGGER_CANCEL_LIVENESS)) {
      clearData();
    }
    AppMethodBeat.o(247024);
  }
  
  /* Error */
  public void loadStateWith(final String paramString, org.json.JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: ldc_w 544
    //   3: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: aload_1
    //   8: aload_2
    //   9: invokespecial 546	com/tencent/youtu/sdkkitframework/framework/YtFSMBaseState:loadStateWith	(Ljava/lang/String;Lorg/json/JSONObject;)V
    //   12: invokestatic 338	com/tencent/youtu/sdkkitframework/framework/YtFSM:getInstance	()Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;
    //   15: invokevirtual 406	com/tencent/youtu/sdkkitframework/framework/YtFSM:getContext	()Lcom/tencent/youtu/sdkkitframework/framework/YtSDKKitFramework$YtSDKPlatformContext;
    //   18: getfield 412	com/tencent/youtu/sdkkitframework/framework/YtSDKKitFramework$YtSDKPlatformContext:currentAppContext	Landroid/content/Context;
    //   21: invokevirtual 551	android/content/Context:getFilesDir	()Ljava/io/File;
    //   24: invokevirtual 554	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   27: pop
    //   28: aload_2
    //   29: ldc_w 556
    //   32: invokevirtual 562	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   35: ifeq +14 -> 49
    //   38: aload_0
    //   39: aload_2
    //   40: ldc_w 556
    //   43: invokevirtual 565	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   46: putfield 122	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:isLoadResourceOnline	Z
    //   49: aload_2
    //   50: ldc_w 567
    //   53: invokevirtual 562	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   56: ifeq +14 -> 70
    //   59: aload_0
    //   60: aload_2
    //   61: ldc_w 567
    //   64: invokevirtual 570	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   67: putfield 147	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:innerMp4Path	Ljava/lang/String;
    //   70: aload_2
    //   71: ldc_w 572
    //   74: invokevirtual 562	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   77: ifeq +14 -> 91
    //   80: aload_0
    //   81: aload_2
    //   82: ldc_w 572
    //   85: invokevirtual 565	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   88: putfield 151	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:needLocalConfig	Z
    //   91: aload_2
    //   92: ldc_w 489
    //   95: invokevirtual 562	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   98: ifeq +14 -> 112
    //   101: aload_0
    //   102: aload_2
    //   103: ldc_w 489
    //   106: invokevirtual 575	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   109: putfield 154	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:codecSettingBitRate	I
    //   112: aload_2
    //   113: ldc_w 491
    //   116: invokevirtual 562	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   119: ifeq +14 -> 133
    //   122: aload_0
    //   123: aload_2
    //   124: ldc_w 491
    //   127: invokevirtual 575	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   130: putfield 156	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:codecSettingFrameRate	I
    //   133: aload_2
    //   134: ldc_w 493
    //   137: invokevirtual 562	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   140: ifeq +14 -> 154
    //   143: aload_0
    //   144: aload_2
    //   145: ldc_w 493
    //   148: invokevirtual 575	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   151: putfield 158	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:codecSettingiFrameInterval	I
    //   154: aload_2
    //   155: ldc_w 577
    //   158: invokevirtual 562	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   161: ifeq +14 -> 175
    //   164: aload_0
    //   165: aload_2
    //   166: ldc_w 577
    //   169: invokevirtual 565	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   172: putfield 164	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:needManualTrigger	Z
    //   175: aload_2
    //   176: ldc_w 579
    //   179: invokevirtual 562	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   182: ifeq +14 -> 196
    //   185: aload_0
    //   186: aload_2
    //   187: ldc_w 579
    //   190: invokevirtual 575	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   193: putfield 168	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:stableCountNum	I
    //   196: aload_2
    //   197: ldc_w 495
    //   200: invokevirtual 562	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   203: ifeq +14 -> 217
    //   206: aload_0
    //   207: aload_2
    //   208: ldc_w 495
    //   211: invokevirtual 570	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   214: putfield 170	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:controlConfig	Ljava/lang/String;
    //   217: aload_0
    //   218: aload_2
    //   219: ldc_w 581
    //   222: iconst_0
    //   223: invokevirtual 585	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   226: putfield 174	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:needCheckMultiFaces	Z
    //   229: aload_0
    //   230: getfield 122	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:isLoadResourceOnline	Z
    //   233: ifne +9 -> 242
    //   236: ldc_w 587
    //   239: invokestatic 592	com/tencent/youtu/sdkkitframework/common/FileUtils:loadLibrary	(Ljava/lang/String;)V
    //   242: invokestatic 597	com/tencent/youtu/ytposedetect/jni/YTPoseDetectJNIInterface:getVersion	()Ljava/lang/String;
    //   245: astore_1
    //   246: getstatic 93	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:TAG	Ljava/lang/String;
    //   249: ldc_w 599
    //   252: aload_1
    //   253: invokestatic 458	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   256: invokevirtual 391	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   259: invokestatic 332	com/tencent/youtu/sdkkitframework/common/YtLogger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   262: aload_1
    //   263: ldc_w 601
    //   266: invokevirtual 467	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   269: astore 4
    //   271: aload_0
    //   272: getfield 105	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:legitimatePoseVersion	Ljava/lang/String;
    //   275: astore 5
    //   277: getstatic 93	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:TAG	Ljava/lang/String;
    //   280: ldc_w 603
    //   283: aload 5
    //   285: invokestatic 458	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   288: invokevirtual 391	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   291: invokestatic 332	com/tencent/youtu/sdkkitframework/common/YtLogger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   294: aload 5
    //   296: ldc_w 601
    //   299: invokevirtual 467	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   302: astore 5
    //   304: aload 4
    //   306: iconst_0
    //   307: aaload
    //   308: invokestatic 305	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   311: aload 5
    //   313: iconst_0
    //   314: aaload
    //   315: invokestatic 305	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   318: if_icmpeq +102 -> 420
    //   321: aload_0
    //   322: new 6	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState$1
    //   325: dup
    //   326: aload_0
    //   327: aload_1
    //   328: invokespecial 606	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState$1:<init>	(Lcom/tencent/youtu/sdkkitframework/liveness/ActionLivenessState;Ljava/lang/String;)V
    //   331: invokespecial 607	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:sendFSMEvent	(Ljava/util/HashMap;)V
    //   334: invokestatic 610	com/tencent/youtu/ytposedetect/YTPoseDetectInterface:initModel	()I
    //   337: istore_3
    //   338: iload_3
    //   339: ifeq +149 -> 488
    //   342: getstatic 93	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:TAG	Ljava/lang/String;
    //   345: ldc_w 612
    //   348: iload_3
    //   349: invokestatic 387	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   352: invokevirtual 391	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   355: invokestatic 479	com/tencent/youtu/sdkkitframework/common/YtLogger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   358: invokestatic 617	com/tencent/youtu/sdkkitframework/common/YtSDKStats:getInstance	()Lcom/tencent/youtu/sdkkitframework/common/YtSDKStats;
    //   361: iload_3
    //   362: ldc_w 619
    //   365: invokevirtual 623	com/tencent/youtu/sdkkitframework/common/YtSDKStats:reportError	(ILjava/lang/String;)V
    //   368: invokestatic 338	com/tencent/youtu/sdkkitframework/framework/YtFSM:getInstance	()Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;
    //   371: new 12	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState$4
    //   374: dup
    //   375: aload_0
    //   376: iload_3
    //   377: invokespecial 626	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState$4:<init>	(Lcom/tencent/youtu/sdkkitframework/liveness/ActionLivenessState;I)V
    //   380: invokevirtual 396	com/tencent/youtu/sdkkitframework/framework/YtFSM:sendFSMEvent	(Ljava/util/HashMap;)V
    //   383: ldc_w 544
    //   386: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   389: return
    //   390: astore_1
    //   391: getstatic 93	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:TAG	Ljava/lang/String;
    //   394: new 124	java/lang/StringBuilder
    //   397: dup
    //   398: ldc_w 628
    //   401: invokespecial 322	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   404: aload_1
    //   405: invokevirtual 629	org/json/JSONException:getLocalizedMessage	()Ljava/lang/String;
    //   408: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   414: invokestatic 479	com/tencent/youtu/sdkkitframework/common/YtLogger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   417: goto -188 -> 229
    //   420: aload 4
    //   422: iconst_1
    //   423: aaload
    //   424: invokestatic 305	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   427: aload 5
    //   429: iconst_1
    //   430: aaload
    //   431: invokestatic 305	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   434: if_icmpeq +19 -> 453
    //   437: aload_0
    //   438: new 8	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState$2
    //   441: dup
    //   442: aload_0
    //   443: aload_1
    //   444: invokespecial 630	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState$2:<init>	(Lcom/tencent/youtu/sdkkitframework/liveness/ActionLivenessState;Ljava/lang/String;)V
    //   447: invokespecial 607	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:sendFSMEvent	(Ljava/util/HashMap;)V
    //   450: goto -116 -> 334
    //   453: aload 4
    //   455: iconst_2
    //   456: aaload
    //   457: invokestatic 305	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   460: aload 5
    //   462: iconst_2
    //   463: aaload
    //   464: invokestatic 305	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   467: if_icmpge -133 -> 334
    //   470: invokestatic 338	com/tencent/youtu/sdkkitframework/framework/YtFSM:getInstance	()Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;
    //   473: new 10	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState$3
    //   476: dup
    //   477: aload_0
    //   478: aload_1
    //   479: invokespecial 631	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState$3:<init>	(Lcom/tencent/youtu/sdkkitframework/liveness/ActionLivenessState;Ljava/lang/String;)V
    //   482: invokevirtual 396	com/tencent/youtu/sdkkitframework/framework/YtFSM:sendFSMEvent	(Ljava/util/HashMap;)V
    //   485: goto -151 -> 334
    //   488: aload_0
    //   489: iconst_0
    //   490: putfield 107	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:continuousDetectCount	I
    //   493: aload_0
    //   494: getfield 252	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:stateData	Ljava/util/HashMap;
    //   497: ldc_w 633
    //   500: aload_0
    //   501: getfield 116	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:actionLiveType	I
    //   504: invokestatic 311	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   507: invokevirtual 317	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   510: pop
    //   511: aload_2
    //   512: ldc_w 635
    //   515: invokevirtual 562	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   518: ifeq +14 -> 532
    //   521: aload_0
    //   522: aload_2
    //   523: ldc_w 635
    //   526: invokevirtual 575	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   529: putfield 149	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:securityLevel	I
    //   532: aload_2
    //   533: ldc_w 637
    //   536: invokevirtual 641	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   539: astore_1
    //   540: aload_1
    //   541: ifnonnull +22 -> 563
    //   544: invokestatic 617	com/tencent/youtu/sdkkitframework/common/YtSDKStats:getInstance	()Lcom/tencent/youtu/sdkkitframework/common/YtSDKStats;
    //   547: ldc_w 642
    //   550: ldc_w 644
    //   553: invokevirtual 623	com/tencent/youtu/sdkkitframework/common/YtSDKStats:reportError	(ILjava/lang/String;)V
    //   556: ldc_w 544
    //   559: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   562: return
    //   563: aload_0
    //   564: aload_1
    //   565: invokevirtual 649	org/json/JSONArray:length	()I
    //   568: anewarray 385	java/lang/String
    //   571: putfield 275	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:actionDataParsed	[Ljava/lang/String;
    //   574: iconst_0
    //   575: istore_3
    //   576: iload_3
    //   577: aload_1
    //   578: invokevirtual 649	org/json/JSONArray:length	()I
    //   581: if_icmpge +21 -> 602
    //   584: aload_0
    //   585: getfield 275	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:actionDataParsed	[Ljava/lang/String;
    //   588: iload_3
    //   589: aload_1
    //   590: iload_3
    //   591: invokevirtual 651	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   594: aastore
    //   595: iload_3
    //   596: iconst_1
    //   597: iadd
    //   598: istore_3
    //   599: goto -23 -> 576
    //   602: getstatic 93	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:TAG	Ljava/lang/String;
    //   605: new 124	java/lang/StringBuilder
    //   608: dup
    //   609: ldc_w 653
    //   612: invokespecial 322	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   615: aload_2
    //   616: ldc_w 637
    //   619: invokevirtual 570	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   622: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: ldc_w 655
    //   628: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: aload_0
    //   632: getfield 275	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:actionDataParsed	[Ljava/lang/String;
    //   635: arraylength
    //   636: invokevirtual 325	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   639: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   642: invokestatic 461	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
    //   645: aload_2
    //   646: ldc_w 657
    //   649: invokevirtual 562	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   652: ifeq +78 -> 730
    //   655: aload_2
    //   656: ldc_w 657
    //   659: invokevirtual 661	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   662: astore_1
    //   663: aload_1
    //   664: invokevirtual 665	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   667: astore_2
    //   668: aload_2
    //   669: invokeinterface 670 1 0
    //   674: ifeq +56 -> 730
    //   677: aload_2
    //   678: invokeinterface 674 1 0
    //   683: checkcast 385	java/lang/String
    //   686: astore 4
    //   688: aload 4
    //   690: aload_1
    //   691: aload 4
    //   693: invokevirtual 570	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   696: invokestatic 678	com/tencent/youtu/ytposedetect/jni/YTPoseDetectJNIInterface:updateParam	(Ljava/lang/String;Ljava/lang/String;)I
    //   699: pop
    //   700: goto -32 -> 668
    //   703: astore_1
    //   704: getstatic 93	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:TAG	Ljava/lang/String;
    //   707: new 124	java/lang/StringBuilder
    //   710: dup
    //   711: ldc_w 680
    //   714: invokespecial 322	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   717: aload_1
    //   718: invokevirtual 629	org/json/JSONException:getLocalizedMessage	()Ljava/lang/String;
    //   721: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   724: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   727: invokestatic 461	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
    //   730: iconst_1
    //   731: invokestatic 684	com/tencent/youtu/ytposedetect/jni/YTPoseDetectJNIInterface:configNativeLog	(Z)V
    //   734: ldc_w 686
    //   737: ldc_w 688
    //   740: invokestatic 678	com/tencent/youtu/ytposedetect/jni/YTPoseDetectJNIInterface:updateParam	(Ljava/lang/String;Ljava/lang/String;)I
    //   743: pop
    //   744: new 14	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState$5
    //   747: dup
    //   748: aload_0
    //   749: invokespecial 689	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState$5:<init>	(Lcom/tencent/youtu/sdkkitframework/liveness/ActionLivenessState;)V
    //   752: invokestatic 693	com/tencent/youtu/ytposedetect/jni/YTPoseDetectJNIInterface:setLoggerListener	(Lcom/tencent/youtu/ytposedetect/jni/YTPoseDetectJNIInterface$IYtLoggerListener;)V
    //   755: aload_0
    //   756: invokestatic 338	com/tencent/youtu/sdkkitframework/framework/YtFSM:getInstance	()Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;
    //   759: invokevirtual 406	com/tencent/youtu/sdkkitframework/framework/YtFSM:getContext	()Lcom/tencent/youtu/sdkkitframework/framework/YtSDKKitFramework$YtSDKPlatformContext;
    //   762: getfield 695	com/tencent/youtu/sdkkitframework/framework/YtSDKKitFramework$YtSDKPlatformContext:currentRotateState	I
    //   765: putfield 696	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:currentRotateState	I
    //   768: aload_0
    //   769: getstatic 343	com/tencent/youtu/sdkkitframework/framework/YtSDKKitCommon$StateNameHelper$StateClassName:SILENT_STATE	Lcom/tencent/youtu/sdkkitframework/framework/YtSDKKitCommon$StateNameHelper$StateClassName;
    //   772: putfield 258	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:nextStateName	Lcom/tencent/youtu/sdkkitframework/framework/YtSDKKitCommon$StateNameHelper$StateClassName;
    //   775: aload_0
    //   776: new 364	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder
    //   779: dup
    //   780: aconst_null
    //   781: iconst_1
    //   782: invokespecial 699	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:<init>	(Lcom/tencent/youtu/sdkkitframework/common/YtVideoEncoder$IYUVToVideoEncoderCallback;Z)V
    //   785: putfield 239	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:videoEncoder	Lcom/tencent/youtu/sdkkitframework/common/YtVideoEncoder;
    //   788: aload_0
    //   789: invokestatic 522	com/tencent/youtu/ytfacetrack/YTFaceTrack:getInstance	()Lcom/tencent/youtu/ytfacetrack/YTFaceTrack;
    //   792: invokevirtual 703	com/tencent/youtu/ytfacetrack/YTFaceTrack:GetFaceTrackParam	()Lcom/tencent/youtu/ytfacetrack/param/YTFaceTrackParam;
    //   795: putfield 512	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:mOriginParam	Lcom/tencent/youtu/ytfacetrack/param/YTFaceTrackParam;
    //   798: aload_0
    //   799: getfield 149	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:securityLevel	I
    //   802: invokestatic 706	com/tencent/youtu/ytposedetect/jni/YTPoseDetectJNIInterface:setSafetyLevel	(I)V
    //   805: aload_0
    //   806: new 220	java/util/ArrayList
    //   809: dup
    //   810: invokespecial 362	java/util/ArrayList:<init>	()V
    //   813: putfield 218	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:bestFrames	Ljava/util/ArrayList;
    //   816: aload_0
    //   817: invokevirtual 709	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:reset	()V
    //   820: ldc_w 544
    //   823: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   826: return
    //   827: astore_1
    //   828: getstatic 93	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:TAG	Ljava/lang/String;
    //   831: new 124	java/lang/StringBuilder
    //   834: dup
    //   835: ldc_w 711
    //   838: invokespecial 322	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   841: aload_1
    //   842: invokevirtual 629	org/json/JSONException:getLocalizedMessage	()Ljava/lang/String;
    //   845: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   848: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   851: invokestatic 479	com/tencent/youtu/sdkkitframework/common/YtLogger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   854: aload_0
    //   855: ldc_w 713
    //   858: ldc_w 715
    //   861: invokevirtual 467	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   864: putfield 275	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:actionDataParsed	[Ljava/lang/String;
    //   867: goto -222 -> 645
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	870	0	this	ActionLivenessState
    //   0	870	1	paramString	String
    //   0	870	2	paramJSONObject	org.json.JSONObject
    //   337	262	3	i	int
    //   269	423	4	localObject1	Object
    //   275	186	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   28	49	390	org/json/JSONException
    //   49	70	390	org/json/JSONException
    //   70	91	390	org/json/JSONException
    //   91	112	390	org/json/JSONException
    //   112	133	390	org/json/JSONException
    //   133	154	390	org/json/JSONException
    //   154	175	390	org/json/JSONException
    //   175	196	390	org/json/JSONException
    //   196	217	390	org/json/JSONException
    //   217	229	390	org/json/JSONException
    //   645	668	703	org/json/JSONException
    //   668	700	703	org/json/JSONException
    //   511	532	827	org/json/JSONException
    //   532	540	827	org/json/JSONException
    //   544	556	827	org/json/JSONException
    //   563	574	827	org/json/JSONException
    //   576	595	827	org/json/JSONException
    //   602	645	827	org/json/JSONException
  }
  
  public void moveToNextState()
  {
    AppMethodBeat.i(247027);
    super.moveToNextState();
    if (this.nextStateName == YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE)
    {
      YtFSM.getInstance().transitNextRound(YtSDKKitCommon.StateNameHelper.classNameOfState(this.nextStateName));
      AppMethodBeat.o(247027);
      return;
    }
    YTFaceTrack.getInstance().SetFaceTrackParam(this.mOriginParam);
    YTPoseDetectInterface.stop();
    YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(this.nextStateName));
    AppMethodBeat.o(247027);
  }
  
  public void reset()
  {
    AppMethodBeat.i(247022);
    clearData();
    super.reset();
    AppMethodBeat.o(247022);
  }
  
  public void unload()
  {
    AppMethodBeat.i(247015);
    super.unload();
    if (YTPoseDetectInterface.isDetecting()) {
      YTPoseDetectInterface.stop();
    }
    YTPoseDetectInterface.releaseModel();
    if (this.videoEncoder != null)
    {
      this.videoEncoder.abortEncoding();
      this.videoEncoder = null;
    }
    AppMethodBeat.o(247015);
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(247026);
    super.update(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramLong);
    if ((this.faceStatus != null) && (this.faceStatus.length > 0) && (this.continuousDetectCount > 0))
    {
      if ((this.continuousDetectCount <= 1) || ((this.needCheckMultiFaces) && (this.faceStatus.length > 1)))
      {
        this.poseReadyCount = this.stableCountNum;
        YTPoseDetectInterface.reset();
      }
      if (this.actionFrameHandler == null)
      {
        YtLogger.e(TAG, "FrameHandle is null, check init first");
        AppMethodBeat.o(247026);
        return;
      }
      if ((this.poseReadyCount > this.stableCountNum + 10) && (!this.isActionFinished)) {
        sendFSMEvent(new HashMap() {});
      }
      this.poseReadyCount += 1;
      YTPoseDetectInterface.poseDetect(this.faceStatus[0].xys, this.faceStatus[0].pointsVis, this.actionLiveType, paramArrayOfByte, YtFSM.getInstance().getContext().currentCamera, this.faceStatus[0].pitch, this.faceStatus[0].yaw, this.faceStatus[0].roll, this.actionFrameHandler, 1);
      AddOptPose(paramArrayOfByte, paramInt1, paramInt2, this.faceStatus[0].xys, this.faceStatus[0].pitch, this.faceStatus[0].yaw, this.faceStatus[0].roll);
    }
    moveToNextState();
    AppMethodBeat.o(247026);
  }
  
  public class BestFrame
  {
    public float eyeScore;
    public float[] f5p;
    public YuvImage frame;
    public float pitch;
    public float roll;
    public float yaw;
    
    public BestFrame() {}
  }
  
  class BestFrameEyeRating
    implements Comparator<ActionLivenessState.BestFrame>
  {
    BestFrameEyeRating() {}
    
    public int compare(ActionLivenessState.BestFrame paramBestFrame1, ActionLivenessState.BestFrame paramBestFrame2)
    {
      float f = paramBestFrame2.eyeScore - paramBestFrame1.eyeScore;
      if (f > 0.0F) {
        return 1;
      }
      if (f < 0.0F) {
        return -1;
      }
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.ActionLivenessState
 * JD-Core Version:    0.7.0.1
 */