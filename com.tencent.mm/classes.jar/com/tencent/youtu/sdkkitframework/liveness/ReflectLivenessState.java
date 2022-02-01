package com.tencent.youtu.sdkkitframework.liveness;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import com.tencent.youtu.sdkkitframework.common.FileUtils;
import com.tencent.youtu.sdkkitframework.common.TimeoutCounter;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.common.YtSDKStats;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper.StateClassName;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYTReflectListener;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtFrameworkFireEventType;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKKitFrameworkWorkMode;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKPlatformContext;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.IYTReflectListener;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.LightLiveCheckResult;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectSettings;
import com.tencent.youtu.ytagreflectlivecheck.data.YTActReflectData;
import com.tencent.youtu.ytagreflectlivecheck.data.YTActReflectImage;
import com.tencent.youtu.ytagreflectlivecheck.jni.YTAGReflectLiveCheckJNIInterface;
import com.tencent.youtu.ytagreflectlivecheck.jni.YTAGReflectLiveCheckJNIInterface.IYtLoggerListener;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.DataPack;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.FullPack;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.RawImgData;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ActionReflectReq;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ColorImgData;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ReflectColorData;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ReflectLiveReq;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.YTImageInfo;
import com.tencent.youtu.ytagreflectlivecheck.notice.YTReflectNotice;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleRequester.SeleceData;
import com.tencent.youtu.ytfacetrack.YTFaceTrack;
import com.tencent.youtu.ytfacetrack.YTFaceTrack.FaceStatus;
import com.tencent.youtu.ytfacetrack.param.YTFaceTrackParam;
import com.tencent.youtu.ytposedetect.data.YTActRefData;
import com.tencent.youtu.ytposedetect.data.YTActRefImage;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class ReflectLivenessState
  extends YtFSMBaseState
{
  private static final String TAG;
  private YTActRefData actRefData;
  private int actReflectUXMode;
  private String appId;
  private int backendProtoType;
  private int changePointNum;
  private String colorData;
  private int continuousDetectCount;
  private String controlConfig;
  private ReflectProcessType currentProcessType;
  private String extraConfig;
  private YTFaceTrack.FaceStatus[] faceStatus;
  private boolean isLoadResourceOnline;
  private String legitimateReflectVersion;
  private YTFaceTrackParam mOriginParam;
  private boolean needCheckFaces;
  private boolean needCheckMultiFaces;
  private boolean needCheckPose;
  private boolean needLocalConfig;
  private boolean needManualTrigger;
  private boolean needRandom;
  private YtSDKKitCommon.StateNameHelper.StateClassName nextStateName;
  private SilentLivenessState.FacePreviewingAdvise poseState;
  private String randomColorData;
  private int securityLevel;
  private LiveStyleRequester.SeleceData seleceData;
  private int simiThreshold;
  private int stableFrameCount;
  private TimeoutCounter tipsTimer;
  
  static
  {
    AppMethodBeat.i(187260);
    TAG = ReflectLivenessState.class.getSimpleName();
    AppMethodBeat.o(187260);
  }
  
  public ReflectLivenessState()
  {
    AppMethodBeat.i(187236);
    this.legitimateReflectVersion = "3.6.2";
    this.poseState = SilentLivenessState.FacePreviewingAdvise.ADVISE_NAN;
    this.currentProcessType = ReflectProcessType.RPT_TIPWAIT;
    this.continuousDetectCount = 0;
    this.nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE;
    this.isLoadResourceOnline = false;
    this.needCheckFaces = true;
    this.simiThreshold = 70;
    this.securityLevel = 2;
    this.needLocalConfig = false;
    this.stableFrameCount = 5;
    this.backendProtoType = 0;
    this.needCheckPose = false;
    this.extraConfig = "";
    this.changePointNum = 2;
    this.needRandom = false;
    this.needManualTrigger = false;
    this.controlConfig = "";
    this.actReflectUXMode = 0;
    this.tipsTimer = new TimeoutCounter("reflect tips timeout counter");
    this.needCheckMultiFaces = false;
    AppMethodBeat.o(187236);
  }
  
  private void clearData()
  {
    AppMethodBeat.i(187240);
    this.currentProcessType = ReflectProcessType.RPT_TIPWAIT;
    this.continuousDetectCount = 0;
    this.poseState = SilentLivenessState.FacePreviewingAdvise.ADVISE_NAN;
    this.needCheckFaces = true;
    YTAGReflectLiveCheckInterface.cancel();
    this.nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE;
    AppMethodBeat.o(187240);
  }
  
  private ActionReflectReq getActionReflectLiveReq(FullPack paramFullPack, YTActReflectData paramYTActReflectData, String paramString)
  {
    AppMethodBeat.i(187254);
    ActionReflectReq localActionReflectReq = new ActionReflectReq();
    localActionReflectReq.app_id = YTAGReflectLiveCheckInterface.mAppId;
    localActionReflectReq.color_data = paramString;
    localActionReflectReq.platform = 2;
    localActionReflectReq.select_data = paramYTActReflectData.select_data;
    if (paramFullPack != null) {
      localActionReflectReq.reflect_data = translation(paramFullPack.AGin);
    }
    localActionReflectReq.live_image = new YTImageInfo(paramYTActReflectData.best);
    localActionReflectReq.eye_image = new YTImageInfo(paramYTActReflectData.eye);
    localActionReflectReq.mouth_image = new YTImageInfo(paramYTActReflectData.mouth);
    localActionReflectReq.compare_image = null;
    localActionReflectReq.mode = 0;
    localActionReflectReq.session_id = null;
    AppMethodBeat.o(187254);
    return localActionReflectReq;
  }
  
  private ReflectLiveReq getReflectLiveReq(FullPack paramFullPack, String paramString)
  {
    AppMethodBeat.i(187255);
    ReflectLiveReq localReflectLiveReq = new ReflectLiveReq();
    localReflectLiveReq.color_data = paramString;
    localReflectLiveReq.platform = 2;
    if (paramFullPack != null)
    {
      localReflectLiveReq.reflect_data = translation(paramFullPack.AGin);
      localReflectLiveReq.live_image = null;
    }
    localReflectLiveReq.compare_image = null;
    localReflectLiveReq.session_id = null;
    localReflectLiveReq.app_id = YTAGReflectLiveCheckInterface.mAppId;
    AppMethodBeat.o(187255);
    return localReflectLiveReq;
  }
  
  private void handleFailure(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(187253);
    paramString2 = "message:" + paramString1 + "\ntips:" + paramString2 + "\ncode:" + paramInt;
    YtLogger.e(TAG, "failed :".concat(String.valueOf(paramString2)));
    paramString2 = SilentLivenessState.convertAdvise(this.poseState);
    paramString1 = CommonUtils.makeMessageJson(4194304, paramString2, paramString1);
    YtSDKStats.getInstance().reportError(paramInt, paramString2);
    paramString2 = new HashMap();
    paramString2.put("ui_tips", "rst_failed");
    paramString2.put("ui_action", "process_finished");
    paramString2.put("process_action", "failed");
    paramString2.put("error_code", Integer.valueOf(4194304));
    paramString2.put("error_reason_code", Integer.valueOf(paramInt));
    paramString2.put("message", paramString1);
    YtFSM.getInstance().sendFSMEvent(paramString2);
    this.currentProcessType = ReflectProcessType.RPT_FINISH;
    AppMethodBeat.o(187253);
  }
  
  private void handleSuccess(FullPack paramFullPack)
  {
    AppMethodBeat.i(187252);
    if (this.currentProcessType == ReflectProcessType.RPT_TIPWAIT)
    {
      AppMethodBeat.o(187252);
      return;
    }
    ByteArrayOutputStream localByteArrayOutputStream;
    int j;
    int k;
    if (YtFSM.getInstance().getWorkMode() == YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTREFLECT_TYPE) {
      for (;;)
      {
        try
        {
          localObject = getActionReflectLiveReq(paramFullPack, new YTActReflectData(new YTActReflectImage(this.actRefData.best.image, this.actRefData.best.xys, this.actRefData.best.checksum), new YTActReflectImage(this.actRefData.eye.image, this.actRefData.eye.xys, this.actRefData.eye.checksum), new YTActReflectImage(this.actRefData.mouth.image, this.actRefData.mouth.xys, this.actRefData.mouth.checksum), this.seleceData), this.colorData);
          ((ActionReflectReq)localObject).app_id = this.appId;
          localBitmap = YtFSM.getInstance().getContext().imageToCompare;
          if (localBitmap != null)
          {
            localByteArrayOutputStream = new ByteArrayOutputStream();
            j = localBitmap.getWidth();
            k = localBitmap.getHeight();
            if (j <= k) {
              continue;
            }
            i = j;
            paramFullPack = localBitmap;
            if (i > 640)
            {
              paramFullPack = imageScale(localBitmap, j * 640 / i, k * 640 / i);
              YtLogger.d(TAG, "resize image. from w:" + j + " h:" + k + " to w:" + paramFullPack.getWidth() + " h:" + paramFullPack.getHeight());
            }
            paramFullPack.compress(Bitmap.CompressFormat.JPEG, 95, localByteArrayOutputStream);
            ((ActionReflectReq)localObject).compare_image = new YTImageInfo(new YTActReflectImage(localByteArrayOutputStream.toByteArray(), null, null));
          }
          ((ActionReflectReq)localObject).color_data = this.colorData;
          this.stateData.put("reflect_request_object", localObject);
        }
        catch (Exception paramFullPack)
        {
          YtLogger.e(TAG, "handle success failed: " + paramFullPack.getLocalizedMessage());
          continue;
        }
        this.nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.NET_LIVENESS_REQ_RESULT_STATE;
        AppMethodBeat.o(187252);
        return;
        i = k;
      }
    }
    Object localObject = getReflectLiveReq(paramFullPack, this.colorData);
    Bitmap localBitmap = YtFSM.getInstance().getContext().imageToCompare;
    if (localBitmap != null)
    {
      localByteArrayOutputStream = new ByteArrayOutputStream();
      j = localBitmap.getWidth();
      k = localBitmap.getHeight();
      if (j <= k) {
        break label648;
      }
    }
    label648:
    for (int i = j;; i = k)
    {
      paramFullPack = localBitmap;
      if (i > 640)
      {
        paramFullPack = imageScale(localBitmap, j * 640 / i, k * 640 / i);
        YtLogger.d(TAG, "resize image. from w:" + j + " h:" + k + " to w:" + paramFullPack.getWidth() + " h:" + paramFullPack.getHeight());
      }
      paramFullPack.compress(Bitmap.CompressFormat.JPEG, 95, localByteArrayOutputStream);
      ((ReflectLiveReq)localObject).compare_image = new String(Base64.encode(localByteArrayOutputStream.toByteArray(), 2));
      YtLogger.d(TAG, "on Request...");
      ((ReflectLiveReq)localObject).color_data = this.colorData;
      ((ReflectLiveReq)localObject).select_data = this.seleceData;
      this.stateData.put("reflect_request_object", localObject);
      break;
    }
  }
  
  private static Bitmap imageScale(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(187250);
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f1 = paramInt1 / i;
    float f2 = paramInt2 / j;
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(f1, f2);
    paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
    AppMethodBeat.o(187250);
    return paramBitmap;
  }
  
  private void setupRequset() {}
  
  private void startReflect()
  {
    boolean bool = false;
    AppMethodBeat.i(187251);
    YtFSM.getInstance().sendFSMEvent(new HashMap() {});
    Object localObject = this.mOriginParam;
    ((YTFaceTrackParam)localObject).detect_interval = -1;
    YTFaceTrack.getInstance().SetFaceTrackParam((YTFaceTrackParam)localObject);
    this.currentProcessType = ReflectProcessType.RPT_REFLECT;
    setupRequset();
    localObject = YTAGReflectLiveCheckInterface.getAGSettings();
    ((YTAGReflectSettings)localObject).safetylevel = this.securityLevel;
    ((YTAGReflectSettings)localObject).isEncodeReflectData = false;
    if (YtFSM.getInstance().getWorkMode() == YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTREFLECT_TYPE) {
      bool = true;
    }
    ((YTAGReflectSettings)localObject).isActionReflect = bool;
    YTAGReflectLiveCheckInterface.setAGSettings((YTAGReflectSettings)localObject);
    YtLogger.i(TAG, "Settings: safetyLevel " + ((YTAGReflectSettings)localObject).safetylevel);
    YtLogger.i(TAG, "Settings: isEncodeReflectData " + ((YTAGReflectSettings)localObject).isEncodeReflectData);
    YtLogger.i(TAG, "Settings: isActionReflect " + ((YTAGReflectSettings)localObject).isActionReflect);
    localObject = YtFSM.getInstance().getContext();
    YTAGReflectLiveCheckInterface.start(((YtSDKKitFramework.YtSDKPlatformContext)localObject).currentAppContext, ((YtSDKKitFramework.YtSDKPlatformContext)localObject).currentCamera, ((YtSDKKitFramework.YtSDKPlatformContext)localObject).currentCameraId, this.colorData, new YTAGReflectLiveCheckInterface.LightLiveCheckResult()
    {
      public void onFailed(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(187221);
        ReflectLivenessState.access$600(ReflectLivenessState.this, paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(187221);
      }
      
      public void onSuccess(FullPack paramAnonymousFullPack)
      {
        AppMethodBeat.i(187220);
        YtLogger.i(ReflectLivenessState.TAG, "on start succeed!!!!!");
        ReflectLivenessState.access$500(ReflectLivenessState.this, paramAnonymousFullPack);
        AppMethodBeat.o(187220);
      }
    });
    AppMethodBeat.o(187251);
  }
  
  private ColorImgData translation(RawImgData paramRawImgData)
  {
    AppMethodBeat.i(187257);
    ColorImgData localColorImgData = new ColorImgData();
    localColorImgData.setImage(new String(Base64.encode(paramRawImgData.frameBuffer, 2)));
    localColorImgData.checksum = paramRawImgData.checksum;
    localColorImgData.setCapture_time(paramRawImgData.captureTime);
    localColorImgData.setX(paramRawImgData.x);
    localColorImgData.setY(paramRawImgData.y);
    AppMethodBeat.o(187257);
    return localColorImgData;
  }
  
  private ReflectColorData translation(DataPack paramDataPack)
  {
    int j = 0;
    AppMethodBeat.i(187256);
    ReflectColorData localReflectColorData = new ReflectColorData();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramDataPack.videoData.length)
    {
      localArrayList.add(translation(paramDataPack.videoData[i]));
      i += 1;
    }
    localReflectColorData.setImages_data(localArrayList);
    localReflectColorData.setBegin_time(paramDataPack.beginTime);
    localReflectColorData.setChangepoint_time(paramDataPack.changePointTime);
    localReflectColorData.changepoint_time_list = new ArrayList();
    i = j;
    while (i < paramDataPack.changePointTimeList.length)
    {
      localReflectColorData.changepoint_time_list.add(Long.valueOf(paramDataPack.changePointTimeList[i]));
      i += 1;
    }
    localReflectColorData.setOffset_sys(paramDataPack.offsetSys);
    localReflectColorData.setFrame_num(paramDataPack.frameNum);
    localReflectColorData.setLandmark_num(paramDataPack.landMarkNum);
    localReflectColorData.setWidth(paramDataPack.width);
    localReflectColorData.setHeight(paramDataPack.height);
    localReflectColorData.version = "3.6.4.3";
    try
    {
      localReflectColorData.setLog(new String(paramDataPack.log, "UTF-8"));
      label205:
      localReflectColorData.setConfig_begin(paramDataPack.config_begin);
      AppMethodBeat.o(187256);
      return localReflectColorData;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      break label205;
    }
  }
  
  public void enter()
  {
    AppMethodBeat.i(187244);
    super.enter();
    Object localObject = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE));
    label388:
    for (;;)
    {
      try
      {
        this.poseState = ((SilentLivenessState.FacePreviewingAdvise)((YtFSMBaseState)localObject).getStateDataBy("pose_state"));
        this.continuousDetectCount = ((Integer)((YtFSMBaseState)localObject).getStateDataBy("continuous_detect_count")).intValue();
        this.faceStatus = ((YTFaceTrack.FaceStatus[])((YtFSMBaseState)localObject).getStateDataBy("face_status"));
        localObject = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_FETCH_STATE));
        if (localObject != null)
        {
          this.seleceData = ((LiveStyleRequester.SeleceData)((YtFSMBaseState)localObject).getStateDataBy("select_data"));
          if (this.needLocalConfig) {
            continue;
          }
          this.colorData = ((String)((YtFSMBaseState)localObject).getStateDataBy("color_data"));
          localObject = (String)((YtFSMBaseState)localObject).getStateDataBy("control_config");
          if (localObject != null) {
            this.controlConfig = ((String)localObject);
          }
        }
        int i;
        if (!this.controlConfig.isEmpty())
        {
          localObject = this.controlConfig.split("&");
          if (localObject.length > 0)
          {
            int j = localObject.length;
            i = 0;
            if (i < j)
            {
              String[] arrayOfString = localObject[i].split("=");
              if ((arrayOfString.length <= 1) || (!arrayOfString[0].equals("actref_ux_mode"))) {
                break label388;
              }
              this.actReflectUXMode = Integer.parseInt(arrayOfString[1]);
            }
          }
        }
        localObject = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.ACTION_STATE));
        if (localObject != null) {
          this.actRefData = ((YTActRefData)((YtFSMBaseState)localObject).getStateDataBy("act_reflect_data"));
        }
        if ((this.continuousDetectCount > this.stableFrameCount) && (this.poseState == SilentLivenessState.FacePreviewingAdvise.ADVISE_PASS) && (this.faceStatus != null) && (this.faceStatus.length > 0)) {
          YtFSM.getInstance().sendFSMEvent(new HashMap() {});
        }
        if (this.actReflectUXMode == 2)
        {
          this.currentProcessType = ReflectProcessType.RPT_FINISH;
          handleSuccess(null);
        }
        AppMethodBeat.o(187244);
        return;
        if (this.needRandom)
        {
          this.colorData = this.randomColorData;
          continue;
          i += 1;
        }
      }
      catch (Exception localException)
      {
        YtLogger.e(TAG, "reflection enter failed " + localException.getLocalizedMessage());
        CommonUtils.reportException("reflection enter failed ", localException);
        AppMethodBeat.o(187244);
        return;
      }
    }
  }
  
  public void enterFirst()
  {
    AppMethodBeat.i(187243);
    YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE)).handleStateAction("reset_timeout", null);
    this.tipsTimer.reset();
    YtFSM.getInstance().cleanUpQueue();
    AppMethodBeat.o(187243);
  }
  
  public void exit()
  {
    AppMethodBeat.i(187246);
    super.exit();
    AppMethodBeat.o(187246);
  }
  
  public void handleEvent(YtSDKKitFramework.YtFrameworkFireEventType paramYtFrameworkFireEventType, Object paramObject)
  {
    AppMethodBeat.i(187242);
    super.handleEvent(paramYtFrameworkFireEventType, paramObject);
    if ((this.needManualTrigger) && (paramYtFrameworkFireEventType == YtSDKKitFramework.YtFrameworkFireEventType.YT_EVENT_TRIGGER_CANCEL_LIVENESS)) {
      clearData();
    }
    AppMethodBeat.o(187242);
  }
  
  public void loadStateWith(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(187237);
    super.loadStateWith(paramString, paramJSONObject);
    for (;;)
    {
      try
      {
        if (paramJSONObject.has("resource_online")) {
          this.isLoadResourceOnline = paramJSONObject.getBoolean("resource_online");
        }
        if (!paramJSONObject.has("similarity_threshold")) {
          continue;
        }
        this.simiThreshold = paramJSONObject.getInt("similarity_threshold");
        if (paramJSONObject.has("reflect_security_level")) {
          this.securityLevel = paramJSONObject.getInt("reflect_security_level");
        }
        if (paramJSONObject.has("local_config_flag")) {
          this.needLocalConfig = paramJSONObject.getBoolean("local_config_flag");
        }
        if (paramJSONObject.has("color_data")) {
          this.colorData = paramJSONObject.getString("color_data");
        }
        if (paramJSONObject.has("stable_frame_num")) {
          this.stableFrameCount = paramJSONObject.getInt("stable_frame_num");
        }
        if (paramJSONObject.has("backend_proto_type")) {
          this.backendProtoType = paramJSONObject.getInt("backend_proto_type");
        }
        if (paramJSONObject.has("force_pose_check")) {
          this.needCheckPose = paramJSONObject.getBoolean("force_pose_check");
        }
        if (paramJSONObject.has("manual_trigger")) {
          this.needManualTrigger = paramJSONObject.getBoolean("manual_trigger");
        }
        if (paramJSONObject.has("reflect_tips_countdown_ms")) {
          this.tipsTimer.init(Math.max(0, Math.min(10000, paramJSONObject.getInt("reflect_tips_countdown_ms"))), false);
        }
        if (paramJSONObject.has("control_config")) {
          this.controlConfig = paramJSONObject.getString("control_config");
        }
      }
      catch (JSONException paramString)
      {
        Object localObject;
        YtLogger.e(TAG, "Failed to parse json:" + paramString.getLocalizedMessage());
        continue;
        if (Integer.parseInt(paramString[1]) == Integer.parseInt(localObject[1])) {
          continue;
        }
        YtFSM.getInstance().sendFSMEvent(new HashMap() {});
        continue;
        if (Integer.parseInt(paramString[2]) >= Integer.parseInt(localObject[2])) {
          continue;
        }
        YtFSM.getInstance().sendFSMEvent(new HashMap() {});
        continue;
      }
      if (!this.isLoadResourceOnline) {
        FileUtils.loadLibrary("YTAGReflectLiveCheck");
      }
      YtLogger.i(TAG, "Reflection version:3.6.4.3");
      paramString = "3.6.4.3".split("\\.");
      localObject = this.legitimateReflectVersion;
      YtLogger.i(TAG, "Wanted Reflection Version: ".concat(String.valueOf(localObject)));
      localObject = ((String)localObject).split("\\.");
      if (Integer.parseInt(paramString[0]) == Integer.parseInt(localObject[0])) {
        continue;
      }
      YtFSM.getInstance().sendFSMEvent(new HashMap() {});
      try
      {
        this.appId = paramJSONObject.getString("app_id");
        if (paramJSONObject.has("extra_config")) {
          this.extraConfig = paramJSONObject.getString("extra_config");
        }
        if (paramJSONObject.has("change_point_num")) {
          this.changePointNum = paramJSONObject.getInt("change_point_num");
        }
        if (paramJSONObject.has("need_random_flag")) {
          this.needRandom = paramJSONObject.getBoolean("need_random_flag");
        }
        this.needCheckMultiFaces = paramJSONObject.optBoolean("need_check_multiface", false);
      }
      catch (JSONException paramString)
      {
        final int i;
        YtLogger.e(TAG, "Failed to parse json:" + paramString.getLocalizedMessage());
        continue;
        YTAGReflectLiveCheckInterface.setReflectListener(null);
        continue;
      }
      i = YTAGReflectLiveCheckInterface.initModel(this.appId);
      if (i != 0)
      {
        YtLogger.e(TAG, "failed to init reflect sdk ".concat(String.valueOf(i)));
        YtSDKStats.getInstance().reportError(i, "failed to init reflect sdk");
        YtFSM.getInstance().sendFSMEvent(new HashMap() {});
      }
      this.mOriginParam = YTFaceTrack.getInstance().GetFaceTrackParam();
      if (this.needRandom) {
        this.randomColorData = YTAGReflectLiveCheckJNIInterface.FRGenConfigData(this.changePointNum, this.extraConfig);
      }
      YTAGReflectLiveCheckInterface.setReflectNotice(new YTReflectNotice()
      {
        public void onDelayCalc()
        {
          AppMethodBeat.i(187226);
          ReflectLivenessState.access$102(ReflectLivenessState.this, false);
          AppMethodBeat.o(187226);
        }
      });
      if (YtFSM.getInstance().getContext().reflectListener == null) {
        break label725;
      }
      YTAGReflectLiveCheckInterface.setReflectListener(new YTAGReflectLiveCheckInterface.IYTReflectListener()
      {
        public float onGetAppBrightness()
        {
          AppMethodBeat.i(187229);
          float f1 = -1.0F;
          try
          {
            float f2 = YtFSM.getInstance().getContext().reflectListener.onGetAppBrightness();
            f1 = f2;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              YtLogger.e(ReflectLivenessState.TAG, localException.getLocalizedMessage());
            }
          }
          AppMethodBeat.o(187229);
          return f1;
        }
        
        public void onReflectEvent(ColorMatrixColorFilter paramAnonymousColorMatrixColorFilter, float paramAnonymousFloat)
        {
          AppMethodBeat.i(187227);
          try
          {
            if (!ReflectLivenessState.this.stateData.containsKey("refcontrol_begin"))
            {
              long l = System.currentTimeMillis();
              ReflectLivenessState.this.stateData.put("refcontrol_begin", String.valueOf(l * 1000L));
            }
            YtFSM.getInstance().getContext().reflectListener.onReflectEvent(paramAnonymousColorMatrixColorFilter, paramAnonymousFloat);
            AppMethodBeat.o(187227);
            return;
          }
          catch (Exception paramAnonymousColorMatrixColorFilter)
          {
            YtLogger.e(ReflectLivenessState.TAG, paramAnonymousColorMatrixColorFilter.getLocalizedMessage());
            AppMethodBeat.o(187227);
          }
        }
        
        public void onReflectStart(long paramAnonymousLong)
        {
          AppMethodBeat.i(187228);
          try
          {
            YtFSM.getInstance().getContext().reflectListener.onReflectStart(paramAnonymousLong);
            AppMethodBeat.o(187228);
            return;
          }
          catch (Exception localException)
          {
            YtLogger.e(ReflectLivenessState.TAG, localException.getLocalizedMessage());
            AppMethodBeat.o(187228);
          }
        }
      });
      YTAGReflectLiveCheckJNIInterface.configNativeLog(true);
      YTAGReflectLiveCheckJNIInterface.updateParam("log_level", "3");
      YTAGReflectLiveCheckJNIInterface.setLoggerListener(new YTAGReflectLiveCheckJNIInterface.IYtLoggerListener()
      {
        public void log(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(187230);
          YtLogger.d(paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(187230);
        }
      });
      AppMethodBeat.o(187237);
      return;
      this.simiThreshold = 70;
    }
  }
  
  public void moveToNextState()
  {
    AppMethodBeat.i(187249);
    super.moveToNextState();
    if (this.nextStateName == YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE)
    {
      YtFSM.getInstance().transitNextRound(YtSDKKitCommon.StateNameHelper.classNameOfState(this.nextStateName));
      AppMethodBeat.o(187249);
      return;
    }
    YTFaceTrack.getInstance().SetFaceTrackParam(this.mOriginParam);
    YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(this.nextStateName));
    AppMethodBeat.o(187249);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(187247);
    super.onPause();
    AppMethodBeat.o(187247);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(187248);
    super.onResume();
    AppMethodBeat.o(187248);
  }
  
  public void reset()
  {
    AppMethodBeat.i(187241);
    clearData();
    super.reset();
    AppMethodBeat.o(187241);
  }
  
  public void unload()
  {
    AppMethodBeat.i(187239);
    super.unload();
    YTAGReflectLiveCheckInterface.cancel();
    YTAGReflectLiveCheckInterface.releaseModel();
    AppMethodBeat.o(187239);
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(187245);
    super.update(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramLong);
    switch (12.$SwitchMap$com$tencent$youtu$sdkkitframework$liveness$ReflectLivenessState$ReflectProcessType[this.currentProcessType.ordinal()])
    {
    default: 
    case 1: 
    case 2: 
      for (;;)
      {
        moveToNextState();
        AppMethodBeat.o(187245);
        return;
        if ((this.tipsTimer.isRunning()) && (!this.tipsTimer.checkTimeout()))
        {
          if (this.continuousDetectCount <= 1) {
            this.tipsTimer.reset();
          } else {
            YtFSM.getInstance().sendFSMEvent(new HashMap() {});
          }
        }
        else
        {
          this.tipsTimer.cancel();
          this.currentProcessType = ReflectProcessType.RPT_INIT;
          continue;
          if ((this.continuousDetectCount > this.stableFrameCount) && ((this.poseState == SilentLivenessState.FacePreviewingAdvise.ADVISE_PASS) || (this.poseState == SilentLivenessState.FacePreviewingAdvise.ADVISE_INBUFFER_PASS)) && (this.faceStatus != null) && (this.faceStatus.length > 0)) {
            startReflect();
          }
          this.nextStateName = YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE;
        }
      }
    }
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("reflect continuous_detect_count ").append(this.continuousDetectCount).append("pass flag ");
    if (this.poseState != SilentLivenessState.FacePreviewingAdvise.ADVISE_PASS) {}
    for (boolean bool = true;; bool = false)
    {
      YtLogger.d(str, bool);
      YtLogger.d(TAG, "reflect pose state " + this.poseState);
      if ((this.needCheckFaces) && (((this.needCheckPose) && (this.poseState != SilentLivenessState.FacePreviewingAdvise.ADVISE_PASS) && (this.poseState != SilentLivenessState.FacePreviewingAdvise.ADVISE_INBUFFER_PASS)) || ((this.needCheckMultiFaces) && (this.poseState == SilentLivenessState.FacePreviewingAdvise.ADVISE_NO_FACE)) || (this.poseState == SilentLivenessState.FacePreviewingAdvise.ADVISE_NO_FACE)))
      {
        YtLogger.i(TAG, "reflect cancel:" + this.continuousDetectCount);
        YTAGReflectLiveCheckInterface.cancel();
        handleFailure(-1, "检测异常", "请保持姿态");
      }
      if (this.faceStatus == null) {
        break;
      }
      YTAGReflectLiveCheckInterface.pushImageData(paramArrayOfByte, paramInt1, paramInt2, paramLong, YtFSM.getInstance().getContext().currentRotateState, this.faceStatus[0].xys, this.faceStatus[0].pitch, this.faceStatus[0].yaw, this.faceStatus[0].roll);
      break;
    }
  }
  
  public void updateSDKSetting(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(187238);
    try
    {
      this.needCheckPose = paramJSONObject.optBoolean("force_pose_check", this.needCheckPose);
      this.needCheckMultiFaces = paramJSONObject.optBoolean("need_check_multiface", this.needCheckMultiFaces);
      AppMethodBeat.o(187238);
      return;
    }
    catch (Exception paramJSONObject)
    {
      YtLogger.e(TAG, paramJSONObject.getLocalizedMessage());
      AppMethodBeat.o(187238);
    }
  }
  
  static enum ReflectProcessType
  {
    static
    {
      AppMethodBeat.i(187235);
      RPT_TIPWAIT = new ReflectProcessType("RPT_TIPWAIT", 0);
      RPT_INIT = new ReflectProcessType("RPT_INIT", 1);
      RPT_REFLECT = new ReflectProcessType("RPT_REFLECT", 2);
      RPT_FINISH = new ReflectProcessType("RPT_FINISH", 3);
      $VALUES = new ReflectProcessType[] { RPT_TIPWAIT, RPT_INIT, RPT_REFLECT, RPT_FINISH };
      AppMethodBeat.o(187235);
    }
    
    private ReflectProcessType() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.ReflectLivenessState
 * JD-Core Version:    0.7.0.1
 */