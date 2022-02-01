package com.tencent.youtu.sdkkitframework.liveness;

import android.content.Context;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.lipreader.jni.YTLipReader;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import com.tencent.youtu.sdkkitframework.common.FileUtils;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.common.YtSDKStats;
import com.tencent.youtu.sdkkitframework.common.YtVideoEncoder;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper.StateClassName;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYTBaseFunctionListener;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtFrameworkFireEventType;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKPlatformContext;
import com.tencent.youtu.ytfacetrack.YTFaceTrack.FaceStatus;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LipReadLivenessState
  extends YtFSMBaseState
{
  private static final String TAG;
  private String[] actionDataParsed;
  private int audioBitRate;
  private int audioSampleRate;
  private int backendProtoType;
  long beginTimeMs;
  private YTFaceTrack.FaceStatus bestFaceStatus;
  private YuvImage bestFrame;
  private boolean canTransit;
  private int codecSettingBitRate;
  private int codecSettingFrameRate;
  private int codecSettingiFrameInterval;
  private int continuousDetectCount;
  private int currentRotateState;
  long endTimeMs;
  private YTFaceTrack.FaceStatus[] faceStatus;
  private String innerAudioPath;
  private String innerMp4Path;
  private boolean isFinished;
  private boolean isLoadResourceOnline;
  private YuvImage lastFrame;
  private boolean needCheckMultiFaces;
  private boolean needCheckPose;
  private boolean needManualTrigger;
  private YtSDKKitCommon.StateNameHelper.StateClassName nextStateName;
  private int numIntervalMs;
  private SilentLivenessState.FacePreviewingAdvise poseState;
  private YtVideoEncoder videoEncoder;
  YTLipReader ytLipReader;
  
  static
  {
    AppMethodBeat.i(187169);
    TAG = LipReadLivenessState.class.getSimpleName();
    AppMethodBeat.o(187169);
  }
  
  public LipReadLivenessState()
  {
    AppMethodBeat.i(187157);
    this.currentRotateState = YtFSM.getInstance().getContext().currentRotateState;
    this.continuousDetectCount = 0;
    this.innerMp4Path = (Environment.getExternalStorageDirectory().getPath() + "/lipreadtemp.mp4");
    this.poseState = SilentLivenessState.FacePreviewingAdvise.ADVISE_NAN;
    this.isLoadResourceOnline = false;
    this.needCheckPose = true;
    this.numIntervalMs = 1000;
    this.needManualTrigger = false;
    this.codecSettingBitRate = 2097152;
    this.codecSettingFrameRate = 30;
    this.codecSettingiFrameInterval = 1;
    this.audioSampleRate = 44100;
    this.audioBitRate = 64000;
    this.innerAudioPath = (Environment.getExternalStorageDirectory().getPath() + "/tmpaudio.spx");
    this.backendProtoType = 0;
    this.needCheckMultiFaces = false;
    AppMethodBeat.o(187157);
  }
  
  private void clearData()
  {
    AppMethodBeat.i(187161);
    this.isFinished = false;
    this.canTransit = false;
    this.poseState = SilentLivenessState.FacePreviewingAdvise.ADVISE_NAN;
    this.nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE;
    if ((this.backendProtoType != 2) && (this.videoEncoder != null))
    {
      this.videoEncoder.abortEncoding();
      this.videoEncoder = null;
    }
    if (this.ytLipReader != null) {
      this.ytLipReader.reset();
    }
    AppMethodBeat.o(187161);
  }
  
  private void sendCancelFailEvent()
  {
    AppMethodBeat.i(187168);
    Object localObject = SilentLivenessState.convertAdvise(this.poseState);
    String str = CommonUtils.makeMessageJson(4194304, (String)localObject, "LipRead check failed");
    YtSDKStats.getInstance().reportError(4194304, (String)localObject);
    localObject = new HashMap();
    ((HashMap)localObject).put("ui_tips", "rst_failed");
    ((HashMap)localObject).put("ui_action", "process_finished");
    ((HashMap)localObject).put("process_action", "failed");
    ((HashMap)localObject).put("error_code", Integer.valueOf(4194304));
    ((HashMap)localObject).put("error_reason_code", Integer.valueOf(4194304));
    ((HashMap)localObject).put("message", str);
    YtFSM.getInstance().sendFSMEvent((HashMap)localObject);
    AppMethodBeat.o(187168);
  }
  
  public void enter()
  {
    AppMethodBeat.i(187163);
    super.enter();
    try
    {
      Object localObject = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE));
      this.poseState = ((SilentLivenessState.FacePreviewingAdvise)((YtFSMBaseState)localObject).getStateDataBy("pose_state"));
      this.continuousDetectCount = ((Integer)((YtFSMBaseState)localObject).getStateDataBy("continuous_detect_count")).intValue();
      this.faceStatus = ((YTFaceTrack.FaceStatus[])((YtFSMBaseState)localObject).getStateDataBy("face_status"));
      this.bestFaceStatus = ((YTFaceTrack.FaceStatus)((YtFSMBaseState)localObject).getStateDataBy("best_face_status"));
      this.bestFrame = ((YuvImage)((YtFSMBaseState)localObject).getStateDataBy("best_image"));
      this.lastFrame = ((YuvImage)((YtFSMBaseState)localObject).getStateDataBy("last_frame"));
      localObject = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_FETCH_STATE));
      if (localObject != null)
      {
        localObject = (String)((YtFSMBaseState)localObject).getStateDataBy("action_data");
        YtLogger.d(TAG, "action data :".concat(String.valueOf(localObject)));
        this.actionDataParsed = ((String)localObject).split(",");
        this.stateData.put("action_seq", this.actionDataParsed);
      }
      AppMethodBeat.o(187163);
      return;
    }
    catch (Exception localException)
    {
      YtLogger.e(TAG, "lipread enter failed " + localException.getLocalizedMessage());
      CommonUtils.reportException("lipread enter failed ", localException);
      AppMethodBeat.o(187163);
    }
  }
  
  public void enterFirst()
  {
    AppMethodBeat.i(187162);
    this.beginTimeMs = System.currentTimeMillis();
    Camera.Size localSize;
    int i;
    if (this.backendProtoType != 2)
    {
      localSize = YtFSM.getInstance().getContext().currentCamera.getParameters().getPreviewSize();
      if (YtFSM.getInstance().getContext().currentRotateState < 5) {
        break label120;
      }
      i = localSize.height;
    }
    for (int j = localSize.width;; j = localSize.height)
    {
      this.videoEncoder = new YtVideoEncoder(null, true);
      this.videoEncoder.startAudioVideoEncoding(i, j, new File(this.innerMp4Path), this.codecSettingBitRate, this.codecSettingFrameRate, this.codecSettingiFrameInterval, this.audioSampleRate, this.audioBitRate);
      AppMethodBeat.o(187162);
      return;
      label120:
      i = localSize.width;
    }
  }
  
  public void handleEvent(YtSDKKitFramework.YtFrameworkFireEventType paramYtFrameworkFireEventType, Object paramObject)
  {
    AppMethodBeat.i(187167);
    super.handleEvent(paramYtFrameworkFireEventType, paramObject);
    if ((this.needManualTrigger) && (paramYtFrameworkFireEventType == YtSDKKitFramework.YtFrameworkFireEventType.YT_EVENT_TRIGGER_CANCEL_LIVENESS)) {
      clearData();
    }
    AppMethodBeat.o(187167);
  }
  
  public void loadStateWith(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(187158);
    super.loadStateWith(paramString, paramJSONObject);
    for (;;)
    {
      try
      {
        if (paramJSONObject.has("force_pose_check")) {
          this.needCheckPose = paramJSONObject.getBoolean("force_pose_check");
        }
        if (paramJSONObject.has("manual_trigger")) {
          this.needManualTrigger = paramJSONObject.getBoolean("manual_trigger");
        }
        if (paramJSONObject.has("video_path")) {
          this.innerMp4Path = paramJSONObject.getString("video_path");
        }
        if (paramJSONObject.has("backend_proto_type")) {
          this.backendProtoType = paramJSONObject.getInt("backend_proto_type");
        }
        if (paramJSONObject.has("video_bitrate")) {
          this.codecSettingBitRate = paramJSONObject.getInt("video_bitrate");
        }
        if (paramJSONObject.has("video_framerate")) {
          this.codecSettingFrameRate = paramJSONObject.getInt("video_framerate");
        }
        if (paramJSONObject.has("video_iframeinterval")) {
          this.codecSettingiFrameInterval = paramJSONObject.getInt("video_iframeinterval");
        }
        if (paramJSONObject.has("audio_bitrate")) {
          this.audioBitRate = paramJSONObject.getInt("audio_bitrate");
        }
        if (paramJSONObject.has("audio_samplerate")) {
          this.audioSampleRate = paramJSONObject.getInt("audio_samplerate");
        }
        this.needCheckMultiFaces = paramJSONObject.optBoolean("need_check_multiface", false);
        paramString = paramJSONObject.optJSONArray("action_default_seq");
        if (paramString != null) {
          continue;
        }
        YtSDKStats.getInstance().reportError(3145728, "yt_param_error");
        YtLogger.e(TAG, "Failed to load action data");
        this.actionDataParsed = "0".split(",");
        YtLogger.d(TAG, "load action sequence from sdkconfig " + paramJSONObject.getString("action_default_seq") + " size :" + this.actionDataParsed.length);
      }
      catch (JSONException paramString)
      {
        YtLogger.e(TAG, "lipread load failed1:" + paramString.getLocalizedMessage());
        this.actionDataParsed = "0".split(",");
        continue;
      }
      this.isFinished = false;
      this.canTransit = false;
      YtFSM.getInstance().getContext().currentAppContext.getFilesDir().getAbsolutePath();
      try
      {
        if (paramJSONObject.has("resource_online")) {
          this.isLoadResourceOnline = paramJSONObject.getBoolean("resource_online");
        }
        if (paramJSONObject.has("audio_path")) {
          this.innerAudioPath = paramJSONObject.getString("audio_path");
        }
        if (paramJSONObject.has("num_interval_ms")) {
          this.numIntervalMs = paramJSONObject.getInt("num_interval_ms");
        }
      }
      catch (Exception paramString)
      {
        int i;
        YtLogger.e(TAG, "lipread load failed2:" + paramString.getLocalizedMessage());
        continue;
      }
      if (!this.isLoadResourceOnline) {
        FileUtils.loadLibrary("YTLipReader");
      }
      this.ytLipReader = new YTLipReader();
      this.ytLipReader.init();
      YtLogger.i(TAG, "YTLipReader Version: " + this.ytLipReader.getVersion());
      this.nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE;
      this.stateData.put("action_seq", this.actionDataParsed);
      AppMethodBeat.o(187158);
      return;
      this.actionDataParsed = new String[paramString.length()];
      i = 0;
      if (i < paramString.length())
      {
        this.actionDataParsed[i] = paramString.getString(i);
        i += 1;
      }
    }
  }
  
  public void moveToNextState()
  {
    AppMethodBeat.i(187166);
    super.moveToNextState();
    this.endTimeMs = System.currentTimeMillis();
    if (this.endTimeMs - this.beginTimeMs > this.actionDataParsed.length * this.numIntervalMs)
    {
      this.isFinished = true;
      Object localObject3 = null;
      Object localObject5 = null;
      Object localObject1 = null;
      FileInputStream localFileInputStream;
      if (this.backendProtoType == 2)
      {
        if (YtFSM.getInstance().getContext().baseFunctionListener != null)
        {
          localObject1 = YtFSM.getInstance().getContext().baseFunctionListener.getVoiceData();
          localObject3 = localObject1;
          if (localObject1 == null) {
            localObject5 = localObject1;
          }
        }
        try
        {
          localFileInputStream = new FileInputStream(new File(this.innerAudioPath));
          localObject3 = localObject1;
          localObject5 = localObject1;
          if (localFileInputStream.available() != 0)
          {
            localObject5 = localObject1;
            localObject3 = new byte[localFileInputStream.available()];
          }
          localObject5 = localObject3;
          localFileInputStream.read((byte[])localObject3);
          localObject5 = localObject3;
          localFileInputStream.close();
        }
        catch (IOException localIOException1)
        {
          for (;;)
          {
            label153:
            YtLogger.e(TAG, "fetch audio data failed:" + localIOException1.getLocalizedMessage());
            localObject3 = localObject5;
          }
        }
        if (localObject3 == null) {
          YtLogger.e(TAG, "fetch audio data failed");
        }
        this.stateData.put("audio_data", localObject3);
        localObject1 = this.ytLipReader.feature();
        if (localObject1 == null) {
          YtLogger.e(TAG, "feature is null");
        }
        this.stateData.put("feature", localObject1);
        localObject1 = this.ytLipReader.lipReadingFeature();
        if (localObject1 == null) {
          YtLogger.e(TAG, "lipread feature is null");
        }
        this.stateData.put("lipreading_feature", localObject1);
        this.stateData.put("last_frame", this.bestFrame);
        this.stateData.put("face_extra_list", this.ytLipReader.getImageListJsonStr());
        if (this.bestFaceStatus != null) {
          break label449;
        }
        YtLogger.e(TAG, "last frame landmark is null");
      }
      for (;;)
      {
        for (;;)
        {
          this.canTransit = true;
          AppMethodBeat.o(187166);
          return;
          YtLogger.w(TAG, "Base function listener for getting voice data not found");
          break;
          this.videoEncoder.stopEncoding();
          Object localObject2 = localObject5;
          try
          {
            localFileInputStream = new FileInputStream(new File(this.innerMp4Path));
            localObject2 = localObject5;
            if (localFileInputStream.available() != 0)
            {
              localObject2 = localObject5;
              localObject3 = new byte[localFileInputStream.available()];
            }
            localObject2 = localObject3;
            localFileInputStream.read((byte[])localObject3);
            localObject2 = localObject3;
            localFileInputStream.close();
          }
          catch (IOException localIOException2)
          {
            YtLogger.e(TAG, "Failed fetch action video " + localIOException2.getLocalizedMessage());
            Object localObject4 = localObject2;
          }
        }
        break label153;
        label449:
        this.stateData.put("last_frame_landmark", this.bestFaceStatus.xys5p);
      }
    }
    YtFSM.getInstance().transitNextRound(YtSDKKitCommon.StateNameHelper.classNameOfState(this.nextStateName));
    AppMethodBeat.o(187166);
  }
  
  public void reset()
  {
    AppMethodBeat.i(187160);
    clearData();
    super.reset();
    AppMethodBeat.o(187160);
  }
  
  public void unload()
  {
    AppMethodBeat.i(187159);
    if (this.ytLipReader != null) {
      this.ytLipReader = null;
    }
    if ((this.backendProtoType != 2) && (this.videoEncoder != null))
    {
      this.videoEncoder.abortEncoding();
      this.videoEncoder = null;
    }
    super.unload();
    AppMethodBeat.o(187159);
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(187164);
    super.update(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramLong);
    if (this.backendProtoType != 2)
    {
      this.videoEncoder.queueFrame(this.lastFrame);
      this.videoEncoder.encode();
    }
    if (!this.isFinished)
    {
      if (((this.needCheckPose) && (this.poseState != SilentLivenessState.FacePreviewingAdvise.ADVISE_PASS) && (this.poseState != SilentLivenessState.FacePreviewingAdvise.ADVISE_INBUFFER_PASS)) || ((this.needCheckMultiFaces) && (this.poseState == SilentLivenessState.FacePreviewingAdvise.ADVISE_TOO_MANY_FACE)) || (this.poseState == SilentLivenessState.FacePreviewingAdvise.ADVISE_NO_FACE))
      {
        this.nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.IDLE_STATE;
        YtLogger.d(TAG, "lipread cancel with pose type " + this.poseState);
        sendCancelFailEvent();
      }
      for (;;)
      {
        moveToNextState();
        AppMethodBeat.o(187164);
        return;
        this.ytLipReader.feed(this.faceStatus[0].xys, paramArrayOfByte, paramInt1, paramInt2, this.currentRotateState, this.faceStatus[0].pitch, this.faceStatus[0].yaw, this.faceStatus[0].roll);
      }
    }
    if (this.canTransit) {
      YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_LIVENESS_REQ_RESULT_STATE));
    }
    AppMethodBeat.o(187164);
  }
  
  public void updateSDKSetting(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(187165);
    try
    {
      this.needCheckPose = paramJSONObject.optBoolean("force_pose_check", this.needCheckPose);
      this.needCheckMultiFaces = paramJSONObject.optBoolean("need_check_multiface", this.needCheckMultiFaces);
      AppMethodBeat.o(187165);
      return;
    }
    catch (Exception paramJSONObject)
    {
      YtLogger.e(TAG, paramJSONObject.getLocalizedMessage());
      AppMethodBeat.o(187165);
    }
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.LipReadLivenessState
 * JD-Core Version:    0.7.0.1
 */