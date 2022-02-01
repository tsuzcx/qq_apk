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
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
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
import com.tencent.youtu.ytposedetect.jni.YTPoseDetectJNIInterface;
import com.tencent.youtu.ytposedetect.jni.YTPoseDetectJNIInterface.IYtLoggerListener;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
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
  private String anchorWidths;
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
    AppMethodBeat.i(218400);
    TAG = ActionLivenessState.class.getSimpleName();
    AppMethodBeat.o(218400);
  }
  
  public ActionLivenessState()
  {
    AppMethodBeat.i(218189);
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
    AppMethodBeat.o(218189);
  }
  
  private void AddOptPose(byte[] paramArrayOfByte, int paramInt1, int paramInt2, float[] paramArrayOfFloat, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(218231);
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
    AppMethodBeat.o(218231);
  }
  
  private boolean changeToNextAction(String[] paramArrayOfString, int paramInt)
  {
    AppMethodBeat.i(218220);
    YtLogger.d(TAG, "currentIndex: ".concat(String.valueOf(paramInt)));
    if (paramArrayOfString.length == 0)
    {
      AppMethodBeat.o(218220);
      return false;
    }
    this.actionCurrentIndex = paramInt;
    if (this.actionCurrentIndex >= paramArrayOfString.length)
    {
      AppMethodBeat.o(218220);
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
      AppMethodBeat.o(218220);
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
    AppMethodBeat.i(218195);
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
    AppMethodBeat.o(218195);
  }
  
  private String getTipsByPoseType(int paramInt)
  {
    AppMethodBeat.i(218210);
    if (paramInt == 1)
    {
      AppMethodBeat.o(218210);
      return "fl_act_blink";
    }
    if (paramInt == 2)
    {
      AppMethodBeat.o(218210);
      return "fl_act_open_mouth";
    }
    if (paramInt == 4)
    {
      AppMethodBeat.o(218210);
      return "fl_act_shake_head";
    }
    if (paramInt == 3)
    {
      AppMethodBeat.o(218210);
      return "fl_act_nod_head";
    }
    if (paramInt == 5)
    {
      AppMethodBeat.o(218210);
      return "fl_act_silence";
    }
    String str = "fl_act_error".concat(String.valueOf(paramInt));
    AppMethodBeat.o(218210);
    return str;
  }
  
  private String makeActionStr(String[] paramArrayOfString)
  {
    AppMethodBeat.i(218203);
    Object localObject1 = "";
    int i = 0;
    if (i < paramArrayOfString.length)
    {
      switch (Integer.parseInt(paramArrayOfString[i]))
      {
      }
      for (;;)
      {
        Object localObject2 = localObject1;
        if (i != paramArrayOfString.length - 1) {
          localObject2 = (String)localObject1 + ",";
        }
        i += 1;
        localObject1 = localObject2;
        break;
        localObject1 = (String)localObject1 + "blink";
        continue;
        localObject1 = (String)localObject1 + "mouth";
        continue;
        localObject1 = (String)localObject1 + "node";
        continue;
        localObject1 = (String)localObject1 + "shake";
        continue;
        localObject1 = (String)localObject1 + "silence";
      }
    }
    AppMethodBeat.o(218203);
    return localObject1;
  }
  
  private void sendFSMEvent(HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(218222);
    YtFSM.getInstance().sendFSMEvent(paramHashMap);
    AppMethodBeat.o(218222);
  }
  
  private void startPose()
  {
    AppMethodBeat.i(218198);
    this.actionFrameHandler = new YTPoseDetectInterface.PoseDetectOnFrame()
    {
      public void onCanReflect()
      {
        AppMethodBeat.i(218267);
        ActionLivenessState.access$902(ActionLivenessState.this, YTPoseDetectInterface.getActReflectData());
        AppMethodBeat.o(218267);
      }
      
      public void onFailed(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(218263);
        YtSDKStats.getInstance().reportInfo("pose state ".concat(String.valueOf(paramAnonymousInt)));
        YtLogger.d(ActionLivenessState.TAG, "YTPoseDetectInterface.poseDetect.onFailed: " + paramAnonymousInt + " s: " + paramAnonymousString1);
        ActionLivenessState.access$808(ActionLivenessState.this);
        AppMethodBeat.o(218263);
      }
      
      public void onRecordingDone(final byte[][] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(218280);
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
          AppMethodBeat.o(218280);
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
                  AppMethodBeat.i(218249);
                  YtLogger.d(ActionLivenessState.TAG, "获取到最优图. width:" + paramAnonymous2Int1 + " height: " + paramAnonymous2Int2 + " bytes size: " + paramAnonymous2ArrayOfByte.length);
                  new YuvImage(paramAnonymous2ArrayOfByte, 17, paramAnonymous2Int1, paramAnonymous2Int2, null);
                  paramAnonymous2ArrayOfByte = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE));
                  ActionLivenessState.this.stateData.put("best_frame", paramAnonymous2ArrayOfByte.getStateDataBy("best_image"));
                  long l = new Date().getTime();
                  paramAnonymous2ArrayOfByte = ActionLivenessState.access$1800(ActionLivenessState.this, ActionLivenessState.this.actionDataParsed);
                  String[] arrayOfString = YtSDKKitFramework.getInstance().version().split("-");
                  paramAnonymous2ArrayOfByte = YTPoseDetectJNIInterface.getConfigData(paramAnonymousArrayOfByte, paramAnonymous2ArrayOfByte, arrayOfString[0], Long.toString(l));
                  ActionLivenessState.this.stateData.put("config", paramAnonymous2ArrayOfByte);
                  ActionLivenessState.access$2002(ActionLivenessState.this, YtSDKKitCommon.StateNameHelper.StateClassName.NET_LIVENESS_REQ_RESULT_STATE);
                  AppMethodBeat.o(218249);
                }
              }, true);
              AppMethodBeat.o(218280);
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
                  AppMethodBeat.i(218242);
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
                  long l = new Date().getTime();
                  paramAnonymous2ArrayOfByte = ActionLivenessState.access$1800(ActionLivenessState.this, ActionLivenessState.this.actionDataParsed);
                  String[] arrayOfString = YtSDKKitFramework.getInstance().version().split("-");
                  paramAnonymous2ArrayOfByte = YTPoseDetectJNIInterface.getConfigData(paramAnonymousArrayOfByte, paramAnonymous2ArrayOfByte, arrayOfString[0], Long.toString(l));
                  ActionLivenessState.this.stateData.put("config", paramAnonymous2ArrayOfByte);
                  ActionLivenessState.access$2002(ActionLivenessState.this, YtSDKKitCommon.StateNameHelper.StateClassName.REFLECT_STATE);
                  AppMethodBeat.o(218242);
                }
              }, true);
              AppMethodBeat.o(218280);
              return;
            }
            YtLogger.e(ActionLivenessState.TAG, "unimplemented work mode " + YtFSM.getInstance().getWorkMode());
            AppMethodBeat.o(218280);
            return;
          }
        }
      }
      
      public void onSuccess(int paramAnonymousInt)
      {
        AppMethodBeat.i(218260);
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
          AppMethodBeat.o(218260);
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
        AppMethodBeat.i(218262);
        YtSDKStats.getInstance().reportError(paramAnonymousInt, "failed to init pose sdk");
        YtFSM.getInstance().sendFSMEvent(new HashMap() {});
        ActionLivenessState.access$2002(ActionLivenessState.this, YtSDKKitCommon.StateNameHelper.StateClassName.IDLE_STATE);
        AppMethodBeat.o(218262);
      }
      
      public void onSuccess()
      {
        AppMethodBeat.i(218259);
        YtLogger.d(ActionLivenessState.TAG, "start success");
        AppMethodBeat.o(218259);
      }
    });
    AppMethodBeat.o(218198);
  }
  
  public void enter()
  {
    AppMethodBeat.i(218422);
    super.enter();
    for (;;)
    {
      try
      {
        YtFSMBaseState localYtFSMBaseState = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE));
        this.continuousDetectCount = ((Integer)localYtFSMBaseState.getStateDataBy("continuous_detect_count")).intValue();
        this.faceStatus = ((YTFaceTrack.FaceStatus[])localYtFSMBaseState.getStateDataBy("face_status"));
        this.poseState = ((SilentLivenessState.FacePreviewingAdvise)localYtFSMBaseState.getStateDataBy("pose_state"));
        localYtFSMBaseState = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_FETCH_STATE));
        Object localObject;
        int i;
        if ((localYtFSMBaseState != null) && (!this.needLocalConfig))
        {
          localObject = (String)localYtFSMBaseState.getStateDataBy("action_data");
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
          if (YtFSM.getInstance().getWorkMode() == YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTREFLECT_TYPE)
          {
            localObject = YtSDKKitFramework.getInstance().version().split("-");
            String str = NetLivenessReqResultState.makeActionStr(this.actionDataParsed);
            if (localYtFSMBaseState != null) {
              YTPoseDetectJNIInterface.setColorData((String)localYtFSMBaseState.getStateDataBy("color_data"), localObject[0], str);
            }
          }
          AppMethodBeat.o(218422);
          return;
        }
      }
      catch (Exception localException)
      {
        YtLogger.e(TAG, "action enter failed " + localException.getLocalizedMessage());
        CommonUtils.reportException("action enter failed ", localException);
        AppMethodBeat.o(218422);
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
    AppMethodBeat.i(218420);
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
      AppMethodBeat.o(218420);
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
    AppMethodBeat.i(218427);
    super.handleEvent(paramYtFrameworkFireEventType, paramObject);
    if ((this.needManualTrigger) && (paramYtFrameworkFireEventType == YtSDKKitFramework.YtFrameworkFireEventType.YT_EVENT_TRIGGER_CANCEL_LIVENESS)) {
      clearData();
    }
    AppMethodBeat.o(218427);
  }
  
  /* Error */
  public void loadStateWith(final String paramString, org.json.JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: ldc_w 598
    //   3: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: aload_1
    //   8: aload_2
    //   9: invokespecial 600	com/tencent/youtu/sdkkitframework/framework/YtFSMBaseState:loadStateWith	(Ljava/lang/String;Lorg/json/JSONObject;)V
    //   12: invokestatic 362	com/tencent/youtu/sdkkitframework/framework/YtFSM:getInstance	()Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;
    //   15: invokevirtual 434	com/tencent/youtu/sdkkitframework/framework/YtFSM:getContext	()Lcom/tencent/youtu/sdkkitframework/framework/YtSDKKitFramework$YtSDKPlatformContext;
    //   18: getfield 440	com/tencent/youtu/sdkkitframework/framework/YtSDKKitFramework$YtSDKPlatformContext:currentAppContext	Landroid/content/Context;
    //   21: invokevirtual 605	android/content/Context:getFilesDir	()Ljava/io/File;
    //   24: invokevirtual 608	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   27: pop
    //   28: aload_2
    //   29: ldc_w 610
    //   32: invokevirtual 616	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   35: ifeq +14 -> 49
    //   38: aload_0
    //   39: aload_2
    //   40: ldc_w 610
    //   43: invokevirtual 619	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   46: putfield 123	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:isLoadResourceOnline	Z
    //   49: aload_2
    //   50: ldc_w 621
    //   53: invokevirtual 616	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   56: ifeq +14 -> 70
    //   59: aload_0
    //   60: aload_2
    //   61: ldc_w 621
    //   64: invokevirtual 624	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   67: putfield 148	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:innerMp4Path	Ljava/lang/String;
    //   70: aload_2
    //   71: ldc_w 626
    //   74: invokevirtual 616	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   77: ifeq +14 -> 91
    //   80: aload_0
    //   81: aload_2
    //   82: ldc_w 626
    //   85: invokevirtual 619	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   88: putfield 152	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:needLocalConfig	Z
    //   91: aload_2
    //   92: ldc_w 543
    //   95: invokevirtual 616	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   98: ifeq +14 -> 112
    //   101: aload_0
    //   102: aload_2
    //   103: ldc_w 543
    //   106: invokevirtual 629	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   109: putfield 155	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:codecSettingBitRate	I
    //   112: aload_2
    //   113: ldc_w 545
    //   116: invokevirtual 616	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   119: ifeq +14 -> 133
    //   122: aload_0
    //   123: aload_2
    //   124: ldc_w 545
    //   127: invokevirtual 629	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   130: putfield 157	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:codecSettingFrameRate	I
    //   133: aload_2
    //   134: ldc_w 547
    //   137: invokevirtual 616	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   140: ifeq +14 -> 154
    //   143: aload_0
    //   144: aload_2
    //   145: ldc_w 547
    //   148: invokevirtual 629	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   151: putfield 159	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:codecSettingiFrameInterval	I
    //   154: aload_2
    //   155: ldc_w 631
    //   158: invokevirtual 616	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   161: ifeq +14 -> 175
    //   164: aload_0
    //   165: aload_2
    //   166: ldc_w 631
    //   169: invokevirtual 619	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   172: putfield 165	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:needManualTrigger	Z
    //   175: aload_2
    //   176: ldc_w 633
    //   179: invokevirtual 616	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   182: ifeq +14 -> 196
    //   185: aload_0
    //   186: aload_2
    //   187: ldc_w 633
    //   190: invokevirtual 629	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   193: putfield 169	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:stableCountNum	I
    //   196: aload_2
    //   197: ldc_w 549
    //   200: invokevirtual 616	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   203: ifeq +14 -> 217
    //   206: aload_0
    //   207: aload_2
    //   208: ldc_w 549
    //   211: invokevirtual 624	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   214: putfield 171	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:controlConfig	Ljava/lang/String;
    //   217: aload_0
    //   218: aload_2
    //   219: ldc_w 635
    //   222: iconst_0
    //   223: invokevirtual 639	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   226: putfield 175	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:needCheckMultiFaces	Z
    //   229: aload_0
    //   230: aload_2
    //   231: ldc_w 641
    //   234: ldc_w 643
    //   237: invokevirtual 647	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   240: putfield 649	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:anchorWidths	Ljava/lang/String;
    //   243: aload_0
    //   244: getfield 123	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:isLoadResourceOnline	Z
    //   247: ifne +9 -> 256
    //   250: ldc_w 651
    //   253: invokestatic 656	com/tencent/youtu/sdkkitframework/common/FileUtils:loadLibrary	(Ljava/lang/String;)V
    //   256: invokestatic 659	com/tencent/youtu/ytposedetect/jni/YTPoseDetectJNIInterface:getVersion	()Ljava/lang/String;
    //   259: astore_1
    //   260: getstatic 94	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:TAG	Ljava/lang/String;
    //   263: ldc_w 661
    //   266: aload_1
    //   267: invokestatic 486	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   270: invokevirtual 320	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   273: invokestatic 356	com/tencent/youtu/sdkkitframework/common/YtLogger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   276: aload_1
    //   277: ldc_w 663
    //   280: invokevirtual 490	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   283: astore 4
    //   285: aload_0
    //   286: getfield 106	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:legitimatePoseVersion	Ljava/lang/String;
    //   289: astore 5
    //   291: getstatic 94	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:TAG	Ljava/lang/String;
    //   294: ldc_w 665
    //   297: aload 5
    //   299: invokestatic 486	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   302: invokevirtual 320	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   305: invokestatic 356	com/tencent/youtu/sdkkitframework/common/YtLogger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   308: aload 5
    //   310: ldc_w 663
    //   313: invokevirtual 490	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   316: astore 5
    //   318: aload 4
    //   320: iconst_0
    //   321: aaload
    //   322: invokestatic 332	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   325: aload 5
    //   327: iconst_0
    //   328: aaload
    //   329: invokestatic 332	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   332: if_icmpeq +102 -> 434
    //   335: aload_0
    //   336: new 6	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState$1
    //   339: dup
    //   340: aload_0
    //   341: aload_1
    //   342: invokespecial 668	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState$1:<init>	(Lcom/tencent/youtu/sdkkitframework/liveness/ActionLivenessState;Ljava/lang/String;)V
    //   345: invokespecial 669	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:sendFSMEvent	(Ljava/util/HashMap;)V
    //   348: invokestatic 672	com/tencent/youtu/ytposedetect/YTPoseDetectInterface:initModel	()I
    //   351: istore_3
    //   352: iload_3
    //   353: ifeq +149 -> 502
    //   356: getstatic 94	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:TAG	Ljava/lang/String;
    //   359: ldc_w 674
    //   362: iload_3
    //   363: invokestatic 316	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   366: invokevirtual 320	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   369: invokestatic 533	com/tencent/youtu/sdkkitframework/common/YtLogger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   372: invokestatic 679	com/tencent/youtu/sdkkitframework/common/YtSDKStats:getInstance	()Lcom/tencent/youtu/sdkkitframework/common/YtSDKStats;
    //   375: iload_3
    //   376: ldc_w 681
    //   379: invokevirtual 685	com/tencent/youtu/sdkkitframework/common/YtSDKStats:reportError	(ILjava/lang/String;)V
    //   382: invokestatic 362	com/tencent/youtu/sdkkitframework/framework/YtFSM:getInstance	()Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;
    //   385: new 12	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState$4
    //   388: dup
    //   389: aload_0
    //   390: iload_3
    //   391: invokespecial 688	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState$4:<init>	(Lcom/tencent/youtu/sdkkitframework/liveness/ActionLivenessState;I)V
    //   394: invokevirtual 424	com/tencent/youtu/sdkkitframework/framework/YtFSM:sendFSMEvent	(Ljava/util/HashMap;)V
    //   397: ldc_w 598
    //   400: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   403: return
    //   404: astore_1
    //   405: getstatic 94	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:TAG	Ljava/lang/String;
    //   408: new 125	java/lang/StringBuilder
    //   411: dup
    //   412: ldc_w 690
    //   415: invokespecial 348	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   418: aload_1
    //   419: invokevirtual 691	org/json/JSONException:getLocalizedMessage	()Ljava/lang/String;
    //   422: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   428: invokestatic 533	com/tencent/youtu/sdkkitframework/common/YtLogger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   431: goto -188 -> 243
    //   434: aload 4
    //   436: iconst_1
    //   437: aaload
    //   438: invokestatic 332	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   441: aload 5
    //   443: iconst_1
    //   444: aaload
    //   445: invokestatic 332	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   448: if_icmpeq +19 -> 467
    //   451: aload_0
    //   452: new 8	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState$2
    //   455: dup
    //   456: aload_0
    //   457: aload_1
    //   458: invokespecial 692	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState$2:<init>	(Lcom/tencent/youtu/sdkkitframework/liveness/ActionLivenessState;Ljava/lang/String;)V
    //   461: invokespecial 669	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:sendFSMEvent	(Ljava/util/HashMap;)V
    //   464: goto -116 -> 348
    //   467: aload 4
    //   469: iconst_2
    //   470: aaload
    //   471: invokestatic 332	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   474: aload 5
    //   476: iconst_2
    //   477: aaload
    //   478: invokestatic 332	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   481: if_icmpge -133 -> 348
    //   484: invokestatic 362	com/tencent/youtu/sdkkitframework/framework/YtFSM:getInstance	()Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;
    //   487: new 10	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState$3
    //   490: dup
    //   491: aload_0
    //   492: aload_1
    //   493: invokespecial 693	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState$3:<init>	(Lcom/tencent/youtu/sdkkitframework/liveness/ActionLivenessState;Ljava/lang/String;)V
    //   496: invokevirtual 424	com/tencent/youtu/sdkkitframework/framework/YtFSM:sendFSMEvent	(Ljava/util/HashMap;)V
    //   499: goto -151 -> 348
    //   502: aload_0
    //   503: iconst_0
    //   504: putfield 108	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:continuousDetectCount	I
    //   507: aload_0
    //   508: getfield 253	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:stateData	Ljava/util/HashMap;
    //   511: ldc_w 695
    //   514: aload_0
    //   515: getfield 117	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:actionLiveType	I
    //   518: invokestatic 337	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   521: invokevirtual 343	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   524: pop
    //   525: aload_2
    //   526: ldc_w 697
    //   529: invokevirtual 616	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   532: ifeq +14 -> 546
    //   535: aload_0
    //   536: aload_2
    //   537: ldc_w 697
    //   540: invokevirtual 629	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   543: putfield 150	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:securityLevel	I
    //   546: aload_2
    //   547: ldc_w 699
    //   550: invokevirtual 703	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   553: astore_1
    //   554: aload_1
    //   555: ifnonnull +22 -> 577
    //   558: invokestatic 679	com/tencent/youtu/sdkkitframework/common/YtSDKStats:getInstance	()Lcom/tencent/youtu/sdkkitframework/common/YtSDKStats;
    //   561: ldc_w 704
    //   564: ldc_w 706
    //   567: invokevirtual 685	com/tencent/youtu/sdkkitframework/common/YtSDKStats:reportError	(ILjava/lang/String;)V
    //   570: ldc_w 598
    //   573: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   576: return
    //   577: aload_0
    //   578: aload_1
    //   579: invokevirtual 711	org/json/JSONArray:length	()I
    //   582: anewarray 313	java/lang/String
    //   585: putfield 285	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:actionDataParsed	[Ljava/lang/String;
    //   588: iconst_0
    //   589: istore_3
    //   590: iload_3
    //   591: aload_1
    //   592: invokevirtual 711	org/json/JSONArray:length	()I
    //   595: if_icmpge +21 -> 616
    //   598: aload_0
    //   599: getfield 285	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:actionDataParsed	[Ljava/lang/String;
    //   602: iload_3
    //   603: aload_1
    //   604: iload_3
    //   605: invokevirtual 713	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   608: aastore
    //   609: iload_3
    //   610: iconst_1
    //   611: iadd
    //   612: istore_3
    //   613: goto -23 -> 590
    //   616: getstatic 94	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:TAG	Ljava/lang/String;
    //   619: new 125	java/lang/StringBuilder
    //   622: dup
    //   623: ldc_w 715
    //   626: invokespecial 348	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   629: aload_2
    //   630: ldc_w 699
    //   633: invokevirtual 624	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   636: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   639: ldc_w 717
    //   642: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: aload_0
    //   646: getfield 285	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:actionDataParsed	[Ljava/lang/String;
    //   649: arraylength
    //   650: invokevirtual 351	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   653: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   656: invokestatic 326	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
    //   659: aload_2
    //   660: ldc_w 719
    //   663: invokevirtual 616	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   666: ifeq +78 -> 744
    //   669: aload_2
    //   670: ldc_w 719
    //   673: invokevirtual 723	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   676: astore_1
    //   677: aload_1
    //   678: invokevirtual 727	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   681: astore_2
    //   682: aload_2
    //   683: invokeinterface 732 1 0
    //   688: ifeq +56 -> 744
    //   691: aload_2
    //   692: invokeinterface 736 1 0
    //   697: checkcast 313	java/lang/String
    //   700: astore 4
    //   702: aload 4
    //   704: aload_1
    //   705: aload 4
    //   707: invokevirtual 624	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   710: invokestatic 740	com/tencent/youtu/ytposedetect/jni/YTPoseDetectJNIInterface:updateParam	(Ljava/lang/String;Ljava/lang/String;)I
    //   713: pop
    //   714: goto -32 -> 682
    //   717: astore_1
    //   718: getstatic 94	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:TAG	Ljava/lang/String;
    //   721: new 125	java/lang/StringBuilder
    //   724: dup
    //   725: ldc_w 742
    //   728: invokespecial 348	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   731: aload_1
    //   732: invokevirtual 691	org/json/JSONException:getLocalizedMessage	()Ljava/lang/String;
    //   735: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   738: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   741: invokestatic 326	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
    //   744: iconst_1
    //   745: invokestatic 746	com/tencent/youtu/ytposedetect/jni/YTPoseDetectJNIInterface:configNativeLog	(Z)V
    //   748: ldc_w 748
    //   751: ldc_w 750
    //   754: invokestatic 740	com/tencent/youtu/ytposedetect/jni/YTPoseDetectJNIInterface:updateParam	(Ljava/lang/String;Ljava/lang/String;)I
    //   757: pop
    //   758: ldc_w 641
    //   761: aload_0
    //   762: getfield 649	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:anchorWidths	Ljava/lang/String;
    //   765: invokestatic 740	com/tencent/youtu/ytposedetect/jni/YTPoseDetectJNIInterface:updateParam	(Ljava/lang/String;Ljava/lang/String;)I
    //   768: pop
    //   769: new 14	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState$5
    //   772: dup
    //   773: aload_0
    //   774: invokespecial 751	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState$5:<init>	(Lcom/tencent/youtu/sdkkitframework/liveness/ActionLivenessState;)V
    //   777: invokestatic 755	com/tencent/youtu/ytposedetect/jni/YTPoseDetectJNIInterface:setLoggerListener	(Lcom/tencent/youtu/ytposedetect/jni/YTPoseDetectJNIInterface$IYtLoggerListener;)V
    //   780: aload_0
    //   781: invokestatic 362	com/tencent/youtu/sdkkitframework/framework/YtFSM:getInstance	()Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;
    //   784: invokevirtual 434	com/tencent/youtu/sdkkitframework/framework/YtFSM:getContext	()Lcom/tencent/youtu/sdkkitframework/framework/YtSDKKitFramework$YtSDKPlatformContext;
    //   787: getfield 757	com/tencent/youtu/sdkkitframework/framework/YtSDKKitFramework$YtSDKPlatformContext:currentRotateState	I
    //   790: putfield 758	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:currentRotateState	I
    //   793: aload_0
    //   794: getstatic 367	com/tencent/youtu/sdkkitframework/framework/YtSDKKitCommon$StateNameHelper$StateClassName:SILENT_STATE	Lcom/tencent/youtu/sdkkitframework/framework/YtSDKKitCommon$StateNameHelper$StateClassName;
    //   797: putfield 268	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:nextStateName	Lcom/tencent/youtu/sdkkitframework/framework/YtSDKKitCommon$StateNameHelper$StateClassName;
    //   800: aload_0
    //   801: new 387	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder
    //   804: dup
    //   805: aconst_null
    //   806: iconst_1
    //   807: invokespecial 761	com/tencent/youtu/sdkkitframework/common/YtVideoEncoder:<init>	(Lcom/tencent/youtu/sdkkitframework/common/YtVideoEncoder$IYUVToVideoEncoderCallback;Z)V
    //   810: putfield 240	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:videoEncoder	Lcom/tencent/youtu/sdkkitframework/common/YtVideoEncoder;
    //   813: aload_0
    //   814: invokestatic 576	com/tencent/youtu/ytfacetrack/YTFaceTrack:getInstance	()Lcom/tencent/youtu/ytfacetrack/YTFaceTrack;
    //   817: invokevirtual 765	com/tencent/youtu/ytfacetrack/YTFaceTrack:GetFaceTrackParam	()Lcom/tencent/youtu/ytfacetrack/param/YTFaceTrackParam;
    //   820: putfield 566	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:mOriginParam	Lcom/tencent/youtu/ytfacetrack/param/YTFaceTrackParam;
    //   823: aload_0
    //   824: getfield 150	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:securityLevel	I
    //   827: invokestatic 768	com/tencent/youtu/ytposedetect/jni/YTPoseDetectJNIInterface:setSafetyLevel	(I)V
    //   830: aload_0
    //   831: new 221	java/util/ArrayList
    //   834: dup
    //   835: invokespecial 385	java/util/ArrayList:<init>	()V
    //   838: putfield 219	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:bestFrames	Ljava/util/ArrayList;
    //   841: aload_0
    //   842: invokevirtual 771	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:reset	()V
    //   845: ldc_w 598
    //   848: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   851: return
    //   852: astore_1
    //   853: getstatic 94	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:TAG	Ljava/lang/String;
    //   856: new 125	java/lang/StringBuilder
    //   859: dup
    //   860: ldc_w 773
    //   863: invokespecial 348	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   866: aload_1
    //   867: invokevirtual 691	org/json/JSONException:getLocalizedMessage	()Ljava/lang/String;
    //   870: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   873: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   876: invokestatic 533	com/tencent/youtu/sdkkitframework/common/YtLogger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   879: aload_0
    //   880: ldc_w 775
    //   883: ldc_w 777
    //   886: invokevirtual 490	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   889: putfield 285	com/tencent/youtu/sdkkitframework/liveness/ActionLivenessState:actionDataParsed	[Ljava/lang/String;
    //   892: goto -233 -> 659
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	895	0	this	ActionLivenessState
    //   0	895	1	paramString	String
    //   0	895	2	paramJSONObject	org.json.JSONObject
    //   351	262	3	i	int
    //   283	423	4	localObject1	Object
    //   289	186	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   28	49	404	org/json/JSONException
    //   49	70	404	org/json/JSONException
    //   70	91	404	org/json/JSONException
    //   91	112	404	org/json/JSONException
    //   112	133	404	org/json/JSONException
    //   133	154	404	org/json/JSONException
    //   154	175	404	org/json/JSONException
    //   175	196	404	org/json/JSONException
    //   196	217	404	org/json/JSONException
    //   217	243	404	org/json/JSONException
    //   659	682	717	org/json/JSONException
    //   682	714	717	org/json/JSONException
    //   525	546	852	org/json/JSONException
    //   546	554	852	org/json/JSONException
    //   558	570	852	org/json/JSONException
    //   577	588	852	org/json/JSONException
    //   590	609	852	org/json/JSONException
    //   616	659	852	org/json/JSONException
  }
  
  public void moveToNextState()
  {
    AppMethodBeat.i(218430);
    super.moveToNextState();
    if (this.nextStateName == YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE)
    {
      YtFSM.getInstance().transitNextRound(YtSDKKitCommon.StateNameHelper.classNameOfState(this.nextStateName));
      AppMethodBeat.o(218430);
      return;
    }
    YTFaceTrack.getInstance().SetFaceTrackParam(this.mOriginParam);
    YTPoseDetectInterface.stop();
    YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(this.nextStateName));
    AppMethodBeat.o(218430);
  }
  
  public void reset()
  {
    AppMethodBeat.i(218425);
    clearData();
    super.reset();
    AppMethodBeat.o(218425);
  }
  
  public void unload()
  {
    AppMethodBeat.i(218416);
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
    AppMethodBeat.o(218416);
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(218429);
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
        AppMethodBeat.o(218429);
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
    AppMethodBeat.o(218429);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.ActionLivenessState
 * JD-Core Version:    0.7.0.1
 */