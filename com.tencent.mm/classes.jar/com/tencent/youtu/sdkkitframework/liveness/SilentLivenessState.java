package com.tencent.youtu.sdkkitframework.liveness;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import com.tencent.youtu.sdkkitframework.common.FileUtils;
import com.tencent.youtu.sdkkitframework.common.TimeoutCounter;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.common.YtSDKStats;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.ProcessHelper;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper.StateClassName;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtFrameworkFireEventType;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKKitFrameworkWorkMode;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKPlatformContext;
import com.tencent.youtu.ytcommon.tools.YTFaceUtils;
import com.tencent.youtu.ytfacetrack.YTFaceTrack;
import com.tencent.youtu.ytfacetrack.YTFaceTrack.FaceStatus;
import com.tencent.youtu.ytfacetrack.YTFaceTrack.IYtLoggerListener;
import com.tencent.youtu.ytfacetrack.YTFaceTrack.YTImage;
import com.tencent.youtu.ytfacetrack.param.YTFaceAlignParam;
import com.tencent.youtu.ytfacetrack.param.YTFaceDetectParam;
import com.tencent.youtu.ytfacetrack.param.YTFaceTrackParam;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class SilentLivenessState
  extends YtFSMBaseState
{
  private static final int CONTINUOUS_DETECT_COUNT = 3;
  private static int FIX_EYE_MOUTH;
  private static int REFINE_CONFIG_OFF;
  private static final String TAG;
  private float bigFaceThresholdBuffer;
  private float bigfaceThreshold;
  private float blurDetectThreshold;
  private int cameraRotateState;
  private int continueCloseEyeCount;
  private int continueNoValidFaceCount;
  private int continueNovalidFaceCountThreshold;
  private int continueShelterJudgeCount;
  private TimeoutCounter countdowner;
  private FacePreviewingAdvise currentAdviseTip;
  private int currentShelterJudge;
  private int detectAvailableCount;
  private int detectIntervalCount;
  private String extraTips;
  private float eyeOpenThreshold;
  private int frameNum;
  private float inRectThreshold;
  float intersectRatio;
  private int invalidPointCount;
  private boolean isFirstStablePass;
  private boolean isLoadResourceOnline;
  private float maskHeightRatio;
  private float maskWidthRatio;
  private float maxEyeScore;
  private float maxInRectRatio;
  private float maxMouthScore;
  private float maxShelterScore;
  private float minEyeScore;
  private float minMouthScore;
  private boolean needBigFaceMode;
  private boolean needCheckEyeOpen;
  private boolean needCheckMultiFaces;
  private boolean needCheckPose;
  private boolean needCheckShelter;
  private boolean needManualTrigger;
  private boolean needTimeoutTimer;
  private int pitchThreshold;
  private float poseThresholdBuffer;
  private TimeoutCounter predetectCountdowner;
  private FacePreviewingAdvise prevAdvise;
  private int prevJudge;
  private int previewHeight;
  private int previewWidth;
  private Rect previousFaceRect;
  private int previousShelterJudge;
  private String resourceDownloadPath;
  private int rollThreshold;
  private int sameFaceTipCount;
  private float smallFaceThresholdBuffer;
  private float smallfaceThreshold;
  private int stableCountNum;
  private int stableFaceCount;
  private float stableRoiThreshold;
  private boolean tipFilterFlag;
  private boolean triggerLiveBeginEventFlag;
  private int unstableCount;
  private int yawThreshold;
  
  static
  {
    AppMethodBeat.i(218307);
    TAG = SilentLivenessState.class.getSimpleName();
    FIX_EYE_MOUTH = 5;
    REFINE_CONFIG_OFF = 8197;
    AppMethodBeat.o(218307);
  }
  
  public SilentLivenessState()
  {
    AppMethodBeat.i(218213);
    this.detectAvailableCount = 0;
    this.prevAdvise = FacePreviewingAdvise.ADVISE_NAN;
    this.prevJudge = -1;
    this.isLoadResourceOnline = false;
    this.resourceDownloadPath = "";
    this.isFirstStablePass = false;
    this.countdowner = new TimeoutCounter("Liveness timeout counter");
    this.predetectCountdowner = new TimeoutCounter("Predetect timeout counter");
    this.needManualTrigger = false;
    this.eyeOpenThreshold = 0.22F;
    this.needCheckEyeOpen = false;
    this.pitchThreshold = 30;
    this.yawThreshold = 25;
    this.rollThreshold = 25;
    this.blurDetectThreshold = 0.3F;
    this.bigfaceThreshold = 1.0F;
    this.smallfaceThreshold = 0.5F;
    this.needTimeoutTimer = false;
    this.continueCloseEyeCount = 0;
    this.sameFaceTipCount = 0;
    this.triggerLiveBeginEventFlag = false;
    this.needBigFaceMode = true;
    this.detectIntervalCount = 5;
    this.stableCountNum = 5;
    this.maxEyeScore = -1.0E+010F;
    this.minEyeScore = 1.0E+010F;
    this.maxMouthScore = -1.0E+010F;
    this.minMouthScore = 1.0E+010F;
    this.maxInRectRatio = -1.0E+010F;
    this.tipFilterFlag = true;
    this.inRectThreshold = 0.7F;
    this.maxShelterScore = -1.0E+010F;
    this.bigFaceThresholdBuffer = 0.05F;
    this.smallFaceThresholdBuffer = 0.05F;
    this.poseThresholdBuffer = 0.05F;
    this.stableRoiThreshold = 0.9F;
    this.stableFaceCount = 0;
    this.unstableCount = 0;
    this.previousFaceRect = null;
    this.needCheckShelter = true;
    this.needCheckPose = false;
    this.continueNoValidFaceCount = 0;
    this.continueNovalidFaceCountThreshold = 5;
    this.intersectRatio = -1.0E+010F;
    this.currentShelterJudge = -1;
    this.continueShelterJudgeCount = 0;
    this.currentAdviseTip = FacePreviewingAdvise.ADVISE_PASS;
    this.extraTips = "";
    this.frameNum = 0;
    this.needCheckMultiFaces = false;
    this.previousShelterJudge = 0;
    AppMethodBeat.o(218213);
  }
  
  private void checkBestImage(YTFaceTrack.FaceStatus paramFaceStatus, YuvImage paramYuvImage, float paramFloat)
  {
    AppMethodBeat.i(218225);
    float f1 = YtSDKKitCommon.ProcessHelper.calcEyeScore(paramFaceStatus.xys);
    float f2 = YtSDKKitCommon.ProcessHelper.calcMouthScore(paramFaceStatus.xys);
    paramFloat = 0.0F;
    int i = 0;
    while (i < paramFaceStatus.pointsVis.length)
    {
      paramFloat += paramFaceStatus.pointsVis[i];
      i += 1;
    }
    if (this.stableFaceCount < this.stableCountNum)
    {
      YtLogger.e(TAG, "stable count " + this.stableFaceCount);
      AppMethodBeat.o(218225);
      return;
    }
    if (this.intersectRatio >= this.maxInRectRatio - 0.05D)
    {
      this.maxInRectRatio = this.intersectRatio;
      if (this.needCheckShelter)
      {
        if (this.maxShelterScore <= paramFloat) {
          this.maxShelterScore = paramFloat;
        }
      }
      else
      {
        YtLogger.d(TAG, "test2 shelter score " + paramFloat + " inRectThreshold " + this.intersectRatio + " eye " + f1 + " mouth " + f2);
        if ((f1 >= this.maxEyeScore - 0.05D) && (f2 <= Math.max(this.minMouthScore, 15.0F)))
        {
          YtLogger.d(TAG, "best shelter score " + paramFloat + " inRectThreshold " + this.intersectRatio);
          this.maxEyeScore = f1;
          this.minMouthScore = f2;
          this.stateData.put("best_image", paramYuvImage);
          this.stateData.put("best_shape", paramFaceStatus.xys);
          this.stateData.put("best_face_status", paramFaceStatus);
        }
        if (f1 < this.minEyeScore)
        {
          this.minEyeScore = f1;
          this.stateData.put("closeeye_image", paramYuvImage);
          this.stateData.put("closeeye_shape", paramFaceStatus.xys);
          this.stateData.put("closeeye_face_status", paramFaceStatus);
        }
        if (f2 <= this.maxMouthScore) {
          break label575;
        }
        this.maxMouthScore = f2;
        this.stateData.put("openmouth_image", paramYuvImage);
        this.stateData.put("openmouth_shape", paramFaceStatus.xys);
        this.stateData.put("openmouth_face_status", paramFaceStatus);
        AppMethodBeat.o(218225);
        return;
      }
      YtLogger.d(TAG, "test1 shelter score " + paramFloat + " inRectThreshold " + this.intersectRatio + " eye " + f1 + " mouth " + f2);
      AppMethodBeat.o(218225);
    }
    else
    {
      YtLogger.d(TAG, "test3 shelter score " + paramFloat + " inRectThreshold " + this.intersectRatio + " (" + this.maxInRectRatio + ") eye " + f1 + " mouth " + f2);
    }
    label575:
    AppMethodBeat.o(218225);
  }
  
  public static String convertAdvise(FacePreviewingAdvise paramFacePreviewingAdvise)
  {
    if ((paramFacePreviewingAdvise == FacePreviewingAdvise.ADVISE_PASS) || (paramFacePreviewingAdvise == FacePreviewingAdvise.ADVISE_INBUFFER_PASS)) {
      return "fl_pose_keep";
    }
    if (paramFacePreviewingAdvise == FacePreviewingAdvise.ADVISE_NOT_IN_RECT) {
      return "fl_pose_not_in_rect";
    }
    if (paramFacePreviewingAdvise == FacePreviewingAdvise.ADVISE_TOO_FAR) {
      return "fl_pose_closer";
    }
    if (paramFacePreviewingAdvise == FacePreviewingAdvise.ADVISE_TOO_CLOSE) {
      return "fl_pose_farer";
    }
    if (paramFacePreviewingAdvise == FacePreviewingAdvise.ADVISE_INCORRECT_POSTURE) {
      return "fl_pose_incorrect";
    }
    if (paramFacePreviewingAdvise == FacePreviewingAdvise.ADVISE_NO_FACE) {
      return "fl_no_face";
    }
    if (paramFacePreviewingAdvise == FacePreviewingAdvise.ADVISE_EYE_CLOSE) {
      return "fl_pose_open_eye";
    }
    if (paramFacePreviewingAdvise == FacePreviewingAdvise.ADVISE_INCOMPLETE_FACE) {
      return "fl_incomplete_face";
    }
    return "fl_act_silence";
  }
  
  private FacePreviewingAdvise getFacePreviewAdvise(Rect paramRect1, Rect paramRect2, YTFaceTrack.FaceStatus paramFaceStatus)
  {
    int j = 0;
    AppMethodBeat.i(218289);
    if (paramFaceStatus == null)
    {
      paramRect1 = FacePreviewingAdvise.ADVISE_NO_FACE;
      i = j;
      this.currentAdviseTip = paramRect1;
      if (i != 0) {
        paramRect1 = FacePreviewingAdvise.ADVISE_INBUFFER_PASS;
      }
      AppMethodBeat.o(218289);
      return paramRect1;
    }
    Rect localRect = new Rect(0, 0, 0, 0);
    YtLogger.d(TAG, "camera" + this.previewWidth + "x" + this.previewHeight + " ratio " + this.maskWidthRatio + "x" + this.maskHeightRatio);
    YtLogger.d(TAG, "detectrect :" + paramRect1.left + " " + paramRect1.top + " " + paramRect1.right + " " + paramRect1.bottom);
    localRect.left = ((int)(paramRect2.left * this.maskWidthRatio));
    localRect.right = ((int)(paramRect2.right * this.maskWidthRatio));
    localRect.top = ((int)(paramRect2.top * this.maskHeightRatio));
    localRect.bottom = ((int)(paramRect2.bottom * this.maskHeightRatio));
    this.invalidPointCount = 0;
    int i = 0;
    while (i < paramFaceStatus.xys.length / 2)
    {
      if ((paramFaceStatus.xys[(i * 2)] > this.previewWidth) || (paramFaceStatus.xys[(i * 2)] < 0.0F) || (paramFaceStatus.xys[(i * 2 + 1)] < 0.0F) || (paramFaceStatus.xys[(i * 2 + 1)] > this.previewHeight)) {
        this.invalidPointCount += 1;
      }
      i += 1;
    }
    paramRect1 = getIntersectionRect(paramRect1, localRect);
    float f = paramRect1.width();
    this.intersectRatio = Math.abs(paramRect1.height() * f / localRect.width() / localRect.height());
    YtLogger.d(TAG, "faceInMask : " + localRect.left + " " + localRect.top + " " + localRect.right + " " + localRect.bottom + " in rect ratio" + this.intersectRatio);
    f = Math.abs((paramRect2.right - paramRect2.left) / (this.previewWidth * 1.0F));
    paramRect1 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.ACTION_STATE));
    if (paramRect1 != null)
    {
      paramRect1 = paramRect1.getStateDataBy("current_action_type");
      if (paramRect1 != null)
      {
        i = ((Integer)paramRect1).intValue();
        if ((i != 3) && (i != 4)) {}
      }
    }
    for (i = 0;; i = 1)
    {
      YtLogger.d(TAG, "face area ratio:".concat(String.valueOf(f)));
      if (this.invalidPointCount >= 3)
      {
        YtLogger.w(TAG, "face incomplete invalid point count:" + this.invalidPointCount);
        paramRect1 = FacePreviewingAdvise.ADVISE_INCOMPLETE_FACE;
        i = j;
        break;
      }
      if (f > this.bigfaceThreshold)
      {
        YtLogger.w(TAG, "face too big:".concat(String.valueOf(f)));
        paramRect2 = FacePreviewingAdvise.ADVISE_TOO_CLOSE;
        paramRect1 = paramRect2;
        i = j;
        if (f > this.bigfaceThreshold + this.bigFaceThresholdBuffer) {
          break;
        }
        i = 1;
        paramRect1 = paramRect2;
        break;
      }
      if (this.intersectRatio < this.inRectThreshold)
      {
        YtLogger.w(TAG, "face not in rect ratio:" + this.intersectRatio);
        paramRect1 = FacePreviewingAdvise.ADVISE_NOT_IN_RECT;
        i = j;
        break;
      }
      if (f < this.smallfaceThreshold)
      {
        YtLogger.w(TAG, "face too small:".concat(String.valueOf(f)));
        paramRect2 = FacePreviewingAdvise.ADVISE_TOO_FAR;
        paramRect1 = paramRect2;
        i = j;
        if (f < this.smallfaceThreshold - this.smallFaceThresholdBuffer) {
          break;
        }
        i = 1;
        paramRect1 = paramRect2;
        break;
      }
      if ((i != 0) && ((Math.abs(paramFaceStatus.pitch) > this.pitchThreshold) || (Math.abs(paramFaceStatus.yaw) > this.yawThreshold) || (Math.abs(paramFaceStatus.roll) > this.rollThreshold)))
      {
        YtLogger.w(TAG, "face pose not right (" + paramFaceStatus.pitch + "," + paramFaceStatus.yaw + "," + paramFaceStatus.roll + ")");
        paramRect2 = FacePreviewingAdvise.ADVISE_INCORRECT_POSTURE;
        paramRect1 = paramRect2;
        i = j;
        if (Math.abs(paramFaceStatus.pitch) > this.pitchThreshold + this.poseThresholdBuffer) {
          break;
        }
        paramRect1 = paramRect2;
        i = j;
        if (Math.abs(paramFaceStatus.yaw) > this.yawThreshold + this.poseThresholdBuffer) {
          break;
        }
        paramRect1 = paramRect2;
        i = j;
        if (Math.abs(paramFaceStatus.roll) > this.rollThreshold + this.poseThresholdBuffer) {
          break;
        }
        i = 1;
        paramRect1 = paramRect2;
        break;
      }
      if ((this.needCheckEyeOpen) && (!isActionStage()))
      {
        f = YtSDKKitCommon.ProcessHelper.preCheckCloseEyeScore(paramFaceStatus.xys);
        YtLogger.d(TAG, "eye score:" + f + " cnt:" + this.continueCloseEyeCount);
        if (f < this.eyeOpenThreshold)
        {
          this.continueCloseEyeCount += 1;
          this.detectAvailableCount -= 1;
          if (this.detectAvailableCount < 0) {
            this.detectAvailableCount = 0;
          }
          label1096:
          if (YtFSM.getInstance().getWorkMode() == YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_SILENT_TYPE) {
            break label1167;
          }
        }
      }
      label1167:
      for (i = 10;; i = 4)
      {
        if (this.continueCloseEyeCount >= i)
        {
          paramRect1 = FacePreviewingAdvise.ADVISE_EYE_CLOSE;
          this.continueCloseEyeCount = 0;
          i = j;
          break;
          this.continueCloseEyeCount = 0;
          break label1096;
        }
        paramRect1 = FacePreviewingAdvise.ADVISE_PASS;
        i = j;
        break;
        paramRect1 = FacePreviewingAdvise.ADVISE_PASS;
        i = j;
        break;
      }
    }
  }
  
  private Rect getFaceRect(YTFaceTrack.FaceStatus paramFaceStatus)
  {
    int i = 0;
    float f5 = 0.0F;
    AppMethodBeat.i(218248);
    float f4 = paramFaceStatus.xys[0];
    float f3 = paramFaceStatus.xys[0];
    float f2 = paramFaceStatus.xys[1];
    float f1 = paramFaceStatus.xys[1];
    while (i < 180)
    {
      f4 = Math.min(f4, paramFaceStatus.xys[i]);
      f3 = Math.max(f3, paramFaceStatus.xys[i]);
      i += 1;
      f2 = Math.min(f2, paramFaceStatus.xys[i]);
      f1 = Math.max(f1, paramFaceStatus.xys[i]);
      i += 1;
    }
    float f6 = this.previewWidth - 1 - f4;
    f3 = this.previewWidth - 1 - f3;
    f4 = (float)(f3 - (f6 - f3) * 0.1D / 2.0D);
    f3 = (float)(f6 + (f6 - f4) * 0.1D / 2.0D);
    float f7 = (float)(f2 - (f1 - f2) * 0.1D / 2.0D);
    f6 = (float)(f1 + (f1 - f7) * 0.1D / 2.0D);
    f1 = f4;
    if (f4 < 0.0F) {
      f1 = 0.0F;
    }
    f2 = f3;
    if (f3 < 0.0F) {
      f2 = 0.0F;
    }
    f3 = f1;
    if (f1 > this.previewWidth - 1) {
      f3 = this.previewWidth - 1;
    }
    if (f2 > this.previewWidth - 1)
    {
      f4 = this.previewWidth - 1;
      if (f7 >= 0.0F) {
        break label403;
      }
      f1 = 0.0F;
      label298:
      if (f6 >= 0.0F) {
        break label409;
      }
    }
    label403:
    label409:
    for (f2 = f5;; f2 = f6)
    {
      f5 = f1;
      if (f1 > this.previewHeight - 1) {
        f5 = this.previewHeight - 1;
      }
      f1 = f2;
      if (f2 > this.previewHeight - 1) {
        f1 = this.previewHeight - 1;
      }
      paramFaceStatus = new Rect();
      paramFaceStatus.left = ((int)f3);
      paramFaceStatus.top = ((int)f5);
      paramFaceStatus.right = ((int)f4);
      paramFaceStatus.bottom = ((int)f1);
      AppMethodBeat.o(218248);
      return paramFaceStatus;
      f4 = f2;
      break;
      f1 = f7;
      break label298;
    }
  }
  
  private FacePreviewingAdvise getPoseJudge(YTFaceTrack.FaceStatus[] paramArrayOfFaceStatus)
  {
    AppMethodBeat.i(218253);
    paramArrayOfFaceStatus = paramArrayOfFaceStatus[0];
    Rect localRect1 = getFaceRect(paramArrayOfFaceStatus);
    if (this.previousFaceRect == null)
    {
      this.previousFaceRect = localRect1;
      this.stableFaceCount = 0;
      YtLogger.d(TAG, "rect is: " + localRect1.left + ", " + localRect1.top + ", " + localRect1.right + ", " + localRect1.bottom);
      paramArrayOfFaceStatus = getFacePreviewAdvise(YtSDKKitFramework.getInstance().getDetectRect(), localRect1, paramArrayOfFaceStatus);
      AppMethodBeat.o(218253);
      return paramArrayOfFaceStatus;
    }
    Rect localRect2 = getIntersectionRect(localRect1, this.previousFaceRect);
    if ((localRect1.height() != 0) && (localRect1.width() != 0))
    {
      float f = localRect2.width();
      f = Math.abs(localRect2.height() * f / localRect1.height() / localRect1.width());
      YtLogger.d(TAG, "pose ratio ".concat(String.valueOf(f)));
      if (f >= this.stableRoiThreshold) {
        break label220;
      }
      this.extraTips = "fl_act_screen_shaking";
    }
    for (this.stableFaceCount = 0;; this.stableFaceCount += 1)
    {
      this.previousFaceRect = localRect1;
      break;
      label220:
      this.extraTips = "";
    }
  }
  
  private int getShelterJudge(YTFaceTrack.FaceStatus[] paramArrayOfFaceStatus)
  {
    AppMethodBeat.i(218258);
    int i = YTFaceUtils.shelterJudge(paramArrayOfFaceStatus[0].pointsVis);
    if (this.currentShelterJudge != i)
    {
      this.continueShelterJudgeCount = 0;
      this.currentShelterJudge = i;
      if ((this.frameNum < 7) || (this.continueShelterJudgeCount >= 7)) {
        break label78;
      }
      i = this.previousShelterJudge;
    }
    for (;;)
    {
      AppMethodBeat.o(218258);
      return i;
      this.continueShelterJudgeCount += 1;
      break;
      label78:
      this.previousShelterJudge = this.currentShelterJudge;
    }
  }
  
  private void initYoutuInstance()
  {
    int j = 0;
    AppMethodBeat.i(218238);
    YTFaceTrack.setLoggerListener(new YTFaceTrack.IYtLoggerListener()
    {
      public void log(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(218212);
        YtLogger.i(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(218212);
      }
    });
    Context localContext = YtFSM.getInstance().getContext().currentAppContext;
    Object localObject = localContext.getFilesDir().getAbsolutePath();
    if (this.isLoadResourceOnline)
    {
      localObject = this.resourceDownloadPath;
      YtLogger.i(TAG, "Use online path:".concat(String.valueOf(localObject)));
    }
    String str1;
    String str2;
    while (!this.isLoadResourceOnline)
    {
      i = 0;
      while (i < 4)
      {
        str1 = new String[] { "net1_18.rpnmodel", "net1_18_bin.rpnproto", "net2_36.rpnmodel", "net2_36_bin.rpnproto" }[i];
        str2 = (String)localObject + "/" + str1;
        FileUtils.copyAsset(localContext.getAssets(), "FaceTrackModels/detector/".concat(String.valueOf(str1)), str2);
        i += 1;
      }
      YtLogger.i(TAG, "Use local path:".concat(String.valueOf(localObject)));
    }
    if (!this.isLoadResourceOnline)
    {
      i = 0;
      while (i < 5)
      {
        str1 = new String[] { "align.rpdm", "align.stb", "align_bin.rpdc", "eye.rpdm", "eye_bin.rpdc" }[i];
        str2 = (String)localObject + "/" + str1;
        FileUtils.copyAsset(localContext.getAssets(), "FaceTrackModels/ufa/".concat(String.valueOf(str1)), str2);
        i += 1;
      }
    }
    if (!this.isLoadResourceOnline)
    {
      i = j;
      while (i <= 0)
      {
        str1 = new String[] { "rotBasis.bin" }[i];
        str2 = (String)localObject + "/" + str1;
        FileUtils.copyAsset(localContext.getAssets(), "FaceTrackModels/poseest/".concat(String.valueOf(str1)), str2);
        i += 1;
      }
    }
    final int i = YTFaceTrack.GlobalInit((String)localObject + "/");
    if (i != 0)
    {
      YtSDKStats.getInstance().reportError(300101, "模式初始化失败");
      YtFSM.getInstance().sendFSMEvent(new HashMap() {});
      AppMethodBeat.o(218238);
      return;
    }
    localObject = YTFaceTrack.getInstance().GetFaceAlignParam();
    ((YTFaceAlignParam)localObject).net_fix_config = FIX_EYE_MOUTH;
    ((YTFaceAlignParam)localObject).refine_config = REFINE_CONFIG_OFF;
    YTFaceTrack.getInstance().SetFaceAlignParam((YTFaceAlignParam)localObject);
    localObject = YTFaceTrack.getInstance().GetFaceDetectParam();
    YtLogger.i(TAG, "big face mode" + this.needBigFaceMode);
    ((YTFaceDetectParam)localObject).bigger_face_mode = this.needBigFaceMode;
    ((YTFaceDetectParam)localObject).min_face_size = Math.max(Math.min(this.previewWidth, this.previewHeight) / 5, 40);
    YTFaceTrack.getInstance().SetFaceDetectParam((YTFaceDetectParam)localObject);
    localObject = YTFaceTrack.getInstance().GetFaceTrackParam();
    ((YTFaceTrackParam)localObject).need_pose_estimate = true;
    ((YTFaceTrackParam)localObject).detect_interval = this.detectIntervalCount;
    YTFaceTrack.getInstance().SetFaceTrackParam((YTFaceTrackParam)localObject);
    YtLogger.i(TAG, "Detect version:" + YTFaceTrack.Version);
    AppMethodBeat.o(218238);
  }
  
  private boolean isActionStage()
  {
    AppMethodBeat.i(218294);
    if ((YtFSM.getInstance().getWorkMode() == YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTION_TYPE) || (YtFSM.getInstance().getWorkMode() == YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTREFLECT_TYPE))
    {
      AppMethodBeat.o(218294);
      return true;
    }
    AppMethodBeat.o(218294);
    return false;
  }
  
  private void sendFSMEvent(HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(218301);
    YtFSM.getInstance().sendFSMEvent(paramHashMap);
    AppMethodBeat.o(218301);
  }
  
  private void sendFaceStatusUITips(FacePreviewingAdvise paramFacePreviewingAdvise, int paramInt)
  {
    AppMethodBeat.i(218269);
    HashMap localHashMap = new HashMap();
    if (((paramFacePreviewingAdvise != FacePreviewingAdvise.ADVISE_PASS) && (paramFacePreviewingAdvise != FacePreviewingAdvise.ADVISE_INBUFFER_PASS)) || (paramInt != 0))
    {
      localHashMap.put("ui_action", "not_pass");
      this.detectAvailableCount = 0;
      if ((paramFacePreviewingAdvise != this.prevAdvise) || (paramInt != this.prevJudge)) {
        break label117;
      }
    }
    label117:
    for (this.sameFaceTipCount += 1;; this.sameFaceTipCount = 0)
    {
      if ((!this.tipFilterFlag) || (this.sameFaceTipCount <= 3) || (this.currentAdviseTip != paramFacePreviewingAdvise)) {
        break label125;
      }
      AppMethodBeat.o(218269);
      return;
      this.detectAvailableCount += 1;
      break;
    }
    label125:
    this.prevAdvise = paramFacePreviewingAdvise;
    this.prevJudge = paramInt;
    YtLogger.d(TAG, " tips:" + convertAdvise(this.currentAdviseTip));
    if ((this.currentAdviseTip == FacePreviewingAdvise.ADVISE_PASS) || (this.currentAdviseTip == FacePreviewingAdvise.ADVISE_INBUFFER_PASS)) {
      if (paramInt == 1) {
        localHashMap.put("ui_tips", "fl_no_left_face");
      }
    }
    for (;;)
    {
      if (this.extraTips != "") {
        localHashMap.put("ui_extra_tips", this.extraTips);
      }
      sendFSMEvent(localHashMap);
      AppMethodBeat.o(218269);
      return;
      if (paramInt == 2)
      {
        localHashMap.put("ui_tips", "fl_no_chin");
      }
      else if (paramInt == 3)
      {
        localHashMap.put("ui_tips", "fl_no_mouth");
      }
      else if (paramInt == 4)
      {
        localHashMap.put("ui_tips", "fl_no_right_face");
      }
      else if (paramInt == 5)
      {
        localHashMap.put("ui_tips", "fl_no_nose");
      }
      else if (paramInt == 6)
      {
        localHashMap.put("ui_tips", "fl_no_right_eye");
      }
      else if (paramInt == 7)
      {
        localHashMap.put("ui_tips", "fl_no_left_eye");
      }
      else if ((paramInt == 0) && (this.sameFaceTipCount > 2) && (this.sameFaceTipCount < 5))
      {
        localHashMap.put("ui_tips", "fl_pose_keep");
        localHashMap.put("ui_action", "pass");
        continue;
        localHashMap.put("ui_tips", convertAdvise(this.currentAdviseTip));
      }
    }
  }
  
  private void sendUITipEvent(YTFaceTrack.FaceStatus[] paramArrayOfFaceStatus)
  {
    AppMethodBeat.i(218275);
    Object localObject = Boolean.FALSE;
    localObject = new HashMap();
    if (paramArrayOfFaceStatus == null)
    {
      ((HashMap)localObject).put("ui_tips", "fl_no_face");
      ((HashMap)localObject).put("ui_action", "not_pass");
      this.detectAvailableCount = 0;
      paramArrayOfFaceStatus = FacePreviewingAdvise.ADVISE_NO_FACE;
      this.prevAdvise = paramArrayOfFaceStatus;
      this.currentAdviseTip = paramArrayOfFaceStatus;
    }
    for (;;)
    {
      if (((HashMap)localObject).size() > 0) {
        sendFSMEvent((HashMap)localObject);
      }
      AppMethodBeat.o(218275);
      return;
      if (paramArrayOfFaceStatus.length > 1)
      {
        ((HashMap)localObject).put("ui_tips", "fl_too_many_faces");
        ((HashMap)localObject).put("ui_action", "not_pass");
        ((HashMap)localObject).put("ui_error", "Failed");
        if (this.needCheckMultiFaces)
        {
          this.detectAvailableCount = 0;
          this.prevAdvise = FacePreviewingAdvise.ADVISE_TOO_MANY_FACE;
        }
        this.currentAdviseTip = FacePreviewingAdvise.ADVISE_TOO_MANY_FACE;
      }
      else
      {
        FacePreviewingAdvise localFacePreviewingAdvise = getPoseJudge(paramArrayOfFaceStatus);
        YtLogger.i(TAG, "advise ".concat(String.valueOf(localFacePreviewingAdvise)));
        sendFaceStatusUITips(localFacePreviewingAdvise, getShelterJudge(paramArrayOfFaceStatus));
      }
    }
  }
  
  public void enter()
  {
    AppMethodBeat.i(218355);
    super.enter();
    AppMethodBeat.o(218355);
  }
  
  public void enterFirst()
  {
    AppMethodBeat.i(218345);
    if (!this.needManualTrigger)
    {
      this.countdowner.start();
      AppMethodBeat.o(218345);
      return;
    }
    this.predetectCountdowner.start();
    AppMethodBeat.o(218345);
  }
  
  public void exit()
  {
    AppMethodBeat.i(218365);
    super.exit();
    AppMethodBeat.o(218365);
  }
  
  Rect getIntersectionRect(Rect paramRect1, Rect paramRect2)
  {
    AppMethodBeat.i(218418);
    paramRect1 = new Rect(Math.max(paramRect1.left, paramRect2.left), Math.max(paramRect1.top, paramRect2.top), Math.min(paramRect1.right, paramRect2.right), Math.min(paramRect1.bottom, paramRect2.bottom));
    AppMethodBeat.o(218418);
    return paramRect1;
  }
  
  public void handleEvent(YtSDKKitFramework.YtFrameworkFireEventType paramYtFrameworkFireEventType, Object paramObject)
  {
    AppMethodBeat.i(218407);
    super.handleEvent(paramYtFrameworkFireEventType, paramObject);
    if (this.needManualTrigger)
    {
      if (paramYtFrameworkFireEventType == YtSDKKitFramework.YtFrameworkFireEventType.YT_EVENT_TRIGGER_BEGIN_LIVENESS)
      {
        this.detectAvailableCount = 0;
        this.triggerLiveBeginEventFlag = true;
        resetTimeout();
        AppMethodBeat.o(218407);
        return;
      }
      if (paramYtFrameworkFireEventType == YtSDKKitFramework.YtFrameworkFireEventType.YT_EVENT_TRIGGER_CANCEL_LIVENESS)
      {
        this.detectAvailableCount = 0;
        this.triggerLiveBeginEventFlag = false;
        this.countdowner.cancel();
        this.predetectCountdowner.reset();
      }
    }
    AppMethodBeat.o(218407);
  }
  
  public void handleStateAction(String paramString, Object paramObject)
  {
    AppMethodBeat.i(218402);
    super.handleStateAction(paramString, paramObject);
    if (paramString.equals("reset_timeout"))
    {
      YtLogger.d(TAG, "predetect status:" + this.predetectCountdowner.isRunning());
      if (!this.predetectCountdowner.isRunning())
      {
        resetTimeout();
        AppMethodBeat.o(218402);
      }
    }
    else if (paramString.equals("reset_manual_trigger"))
    {
      this.triggerLiveBeginEventFlag = false;
      this.countdowner.cancel();
    }
    AppMethodBeat.o(218402);
  }
  
  public void loadStateWith(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(218316);
    super.loadStateWith(paramString, paramJSONObject);
    for (;;)
    {
      try
      {
        if (paramJSONObject.has("resource_online")) {
          this.isLoadResourceOnline = paramJSONObject.getBoolean("resource_online");
        }
        if (paramJSONObject.has("resource_download_path")) {
          this.resourceDownloadPath = paramJSONObject.getString("resource_download_path");
        }
        if (paramJSONObject.has("timeout_countdown_ms")) {
          this.countdowner.init(Math.max(0, Math.min(30000, paramJSONObject.getInt("timeout_countdown_ms"))), true);
        }
        if (!paramJSONObject.has("predetect_countdown_ms")) {
          continue;
        }
        this.predetectCountdowner.init(paramJSONObject.getInt("predetect_countdown_ms"), true);
        if (paramJSONObject.has("same_tips_filter")) {
          this.tipFilterFlag = paramJSONObject.getBoolean("same_tips_filter");
        }
        if (paramJSONObject.has("manual_trigger")) {
          this.needManualTrigger = paramJSONObject.getBoolean("manual_trigger");
        }
        this.needCheckMultiFaces = paramJSONObject.optBoolean("need_check_multiface", false);
        updateSDKSetting(paramJSONObject);
      }
      catch (JSONException paramString)
      {
        YtLogger.e(TAG, "Failed to parse json:" + paramString.getLocalizedMessage());
        continue;
        this.previewWidth = paramString.width;
        this.previewHeight = paramString.height;
        continue;
      }
      if (!this.isLoadResourceOnline) {
        FileUtils.loadLibrary("YTFaceTrackPro2");
      }
      paramString = YtFSM.getInstance().getContext().currentCamera.getParameters().getPreviewSize();
      this.cameraRotateState = YtFSM.getInstance().getContext().currentRotateState;
      if (this.cameraRotateState < 5) {
        continue;
      }
      this.previewWidth = paramString.height;
      this.previewHeight = paramString.width;
      this.maskWidthRatio = (YtSDKKitFramework.getInstance().getPreviewRect().width() / this.previewWidth);
      this.maskHeightRatio = (YtSDKKitFramework.getInstance().getPreviewRect().height() / this.previewHeight);
      initYoutuInstance();
      reset();
      AppMethodBeat.o(218316);
      return;
      this.predetectCountdowner.init(25000L, true);
    }
  }
  
  public void moveToNextState()
  {
    AppMethodBeat.i(218398);
    super.moveToNextState();
    if ((this.needManualTrigger) && (((this.needCheckPose) && (this.prevAdvise != FacePreviewingAdvise.ADVISE_PASS) && (this.prevAdvise != FacePreviewingAdvise.ADVISE_INBUFFER_PASS)) || ((this.needCheckMultiFaces) && (this.prevAdvise == FacePreviewingAdvise.ADVISE_TOO_MANY_FACE)) || (this.prevAdvise == FacePreviewingAdvise.ADVISE_INCOMPLETE_FACE) || (this.prevAdvise == FacePreviewingAdvise.ADVISE_NO_FACE)))
    {
      this.continueNoValidFaceCount += 1;
      if (this.continueNoValidFaceCount > this.continueNovalidFaceCountThreshold)
      {
        Object localObject = convertAdvise(this.prevAdvise);
        String str = CommonUtils.makeMessageJson(4194304, (String)localObject, "action check failed");
        YtSDKStats.getInstance().reportError(4194304, (String)localObject);
        localObject = new HashMap();
        ((HashMap)localObject).put("ui_tips", "rst_failed");
        ((HashMap)localObject).put("ui_action", "process_finished");
        ((HashMap)localObject).put("process_action", "failed");
        ((HashMap)localObject).put("error_code", Integer.valueOf(4194304));
        ((HashMap)localObject).put("error_reason_code", Integer.valueOf(4194304));
        ((HashMap)localObject).put("message", str);
        YtFSM.getInstance().sendFSMEvent((HashMap)localObject);
        YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.IDLE_STATE));
        AppMethodBeat.o(218398);
      }
    }
    else
    {
      this.continueNoValidFaceCount = 0;
    }
    if ((this.needManualTrigger) && (this.predetectCountdowner.checkTimeout()))
    {
      YtLogger.d(TAG, "predectcountdowner.checkTimeout(): " + this.predetectCountdowner.checkTimeout());
      this.predetectCountdowner.cancel();
      YtSDKStats.getInstance().reportError(4194307, "yt_verify_step_timeout");
      YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.TIMEOUT_STATE));
      AppMethodBeat.o(218398);
      return;
    }
    if (this.countdowner.checkTimeout())
    {
      this.countdowner.cancel();
      YtLogger.d(TAG, "liveness timeout");
      YtSDKStats.getInstance().reportError(4194307, "yt_verify_step_timeout");
      YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.TIMEOUT_STATE));
      AppMethodBeat.o(218398);
      return;
    }
    if ((this.needManualTrigger == true) || (this.isFirstStablePass) || (this.detectAvailableCount > this.stableCountNum))
    {
      this.isFirstStablePass = true;
      this.predetectCountdowner.cancel();
      switch (3.$SwitchMap$com$tencent$youtu$sdkkitframework$framework$YtSDKKitFramework$YtSDKKitFrameworkWorkMode[YtFSM.getInstance().getWorkMode().ordinal()])
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(218398);
      return;
      YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.ACTION_STATE));
      AppMethodBeat.o(218398);
      return;
      YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.REFLECT_STATE));
      AppMethodBeat.o(218398);
      return;
      YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.LIPREAD_STATE));
    }
  }
  
  public void reset()
  {
    AppMethodBeat.i(218336);
    this.prevAdvise = FacePreviewingAdvise.ADVISE_NAN;
    this.detectAvailableCount = 0;
    this.continueCloseEyeCount = 0;
    this.frameNum = 0;
    this.triggerLiveBeginEventFlag = false;
    this.sameFaceTipCount = 0;
    this.maxEyeScore = -1.0E+010F;
    this.minMouthScore = 1.0E+010F;
    this.minEyeScore = 1.0E+010F;
    this.maxMouthScore = -1.0E+010F;
    this.maxShelterScore = -1.0E+010F;
    this.isFirstStablePass = false;
    this.continueNoValidFaceCount = 0;
    this.invalidPointCount = 0;
    this.unstableCount = 0;
    this.maxInRectRatio = -1.0E+010F;
    this.countdowner.cancel();
    this.predetectCountdowner.cancel();
    this.stableFaceCount = 0;
    this.currentShelterJudge = -1;
    this.previousFaceRect = null;
    if (!this.needManualTrigger) {
      this.countdowner.reset();
    }
    for (;;)
    {
      super.reset();
      AppMethodBeat.o(218336);
      return;
      this.predetectCountdowner.reset();
    }
  }
  
  public void resetTimeout()
  {
    AppMethodBeat.i(218409);
    this.countdowner.reset();
    AppMethodBeat.o(218409);
  }
  
  public void unload()
  {
    AppMethodBeat.i(218325);
    super.unload();
    try
    {
      YTFaceTrack.GlobalRelease();
      AppMethodBeat.o(218325);
      return;
    }
    catch (Exception localException)
    {
      YtLogger.e(TAG, "SDK inner bug");
      AppMethodBeat.o(218325);
    }
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(218383);
    super.update(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramLong);
    if ((this.countdowner.checkTimeout()) || ((this.needManualTrigger) && (this.predetectCountdowner.checkTimeout())))
    {
      moveToNextState();
      AppMethodBeat.o(218383);
      return;
    }
    Object localObject2 = YTFaceTrack.getInstance();
    if (localObject2 == null)
    {
      YtLogger.e(TAG, "Tracker is null, please check facetrack init result");
      AppMethodBeat.o(218383);
      return;
    }
    this.frameNum += 1;
    Object localObject1 = new YTFaceTrack.YTImage();
    ((YTFaceTrack.YTImage)localObject1).width = paramInt1;
    ((YTFaceTrack.YTImage)localObject1).height = paramInt2;
    float[] arrayOfFloat = new float[1];
    CommonUtils.benchMarkBegin("detect");
    paramArrayOfByte = ((YTFaceTrack)localObject2).DoDetectionProcessYUVWithBlur(paramArrayOfByte, paramInt1, paramInt2, this.cameraRotateState, true, arrayOfFloat, (YTFaceTrack.YTImage)localObject1);
    CommonUtils.benchMarkEnd("detect");
    YtLogger.d(TAG, CommonUtils.getBenchMarkTime("detect"));
    YtLogger.d(TAG, "Blur score:" + Arrays.toString(arrayOfFloat));
    if (paramArrayOfByte != null)
    {
      YtLogger.i(TAG, "face status count " + paramArrayOfByte.length);
      if (paramArrayOfByte.length > 1)
      {
        int i = -2147483648;
        int k = 0;
        paramInt3 = 0;
        while (paramInt3 < paramArrayOfByte.length)
        {
          localObject2 = getFaceRect(paramArrayOfByte[paramInt3]);
          int j = ((Rect)localObject2).width();
          int m = ((Rect)localObject2).height() * j;
          j = i;
          if (m >= i)
          {
            k = paramInt3;
            j = m;
          }
          paramInt3 += 1;
          i = j;
        }
        if (k != 0)
        {
          YtLogger.i(TAG, "Found max face id:".concat(String.valueOf(k)));
          paramArrayOfByte[0] = paramArrayOfByte[k];
        }
      }
    }
    for (;;)
    {
      sendUITipEvent(paramArrayOfByte);
      this.stateData.put("pose_state", this.prevAdvise);
      this.stateData.put("shelter_state", Integer.valueOf(this.prevJudge));
      this.stateData.put("face_status", paramArrayOfByte);
      this.stateData.put("continuous_detect_count", Integer.valueOf(this.detectAvailableCount));
      localObject1 = new YuvImage(((YTFaceTrack.YTImage)localObject1).data, 17, paramInt2, paramInt1, null);
      this.stateData.put("last_face_status", paramArrayOfByte);
      this.stateData.put("last_frame", localObject1);
      if ((this.prevAdvise == FacePreviewingAdvise.ADVISE_PASS) || (this.prevAdvise == FacePreviewingAdvise.ADVISE_INBUFFER_PASS)) {
        checkBestImage(paramArrayOfByte[0], (YuvImage)localObject1, arrayOfFloat[0]);
      }
      if ((this.stateData.get("best_image") != null) && ((!this.needManualTrigger) || ((this.needManualTrigger == true) && (this.triggerLiveBeginEventFlag == true)))) {
        moveToNextState();
      }
      AppMethodBeat.o(218383);
      return;
      YtLogger.i(TAG, "face status is null");
    }
  }
  
  public void updateSDKSetting(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(218393);
    try
    {
      if (paramJSONObject.has("check_eye_open")) {
        this.needCheckEyeOpen = paramJSONObject.getBoolean("check_eye_open");
      }
      if (paramJSONObject.has("open_eye_threshold")) {
        this.eyeOpenThreshold = ((float)paramJSONObject.getDouble("open_eye_threshold"));
      }
      if (paramJSONObject.has("pitch_threshold")) {
        this.pitchThreshold = paramJSONObject.getInt("pitch_threshold");
      }
      if (paramJSONObject.has("yaw_threshold")) {
        this.yawThreshold = paramJSONObject.getInt("yaw_threshold");
      }
      if (paramJSONObject.has("roll_threshold")) {
        this.rollThreshold = paramJSONObject.getInt("roll_threshold");
      }
      if (paramJSONObject.has("smallface_ratio_threshold")) {
        this.smallfaceThreshold = ((float)paramJSONObject.getDouble("smallface_ratio_threshold"));
      }
      if (paramJSONObject.has("bigface_ratio_threshold")) {
        this.bigfaceThreshold = ((float)paramJSONObject.getDouble("bigface_ratio_threshold"));
      }
      if (paramJSONObject.has("blur_detect_threshold")) {
        this.blurDetectThreshold = ((float)paramJSONObject.getDouble("blur_detect_threshold"));
      }
      if (paramJSONObject.has("need_big_face_mode")) {
        this.needBigFaceMode = paramJSONObject.getBoolean("need_big_face_mode");
      }
      if (paramJSONObject.has("detect_interval")) {
        this.detectIntervalCount = paramJSONObject.getInt("detect_interval");
      }
      if (paramJSONObject.has("stable_frame_num")) {
        this.stableCountNum = paramJSONObject.getInt("stable_frame_num");
      }
      if (paramJSONObject.has("net_request_timeout_ms")) {
        YtSDKKitFramework.getInstance().setNetworkRequestTimeoutMS(paramJSONObject.getInt("net_request_timeout_ms"));
      }
      if (paramJSONObject.has("force_pose_check")) {
        this.needCheckPose = paramJSONObject.getBoolean("force_pose_check");
      }
      if (paramJSONObject.has("novalid_face_count")) {
        this.continueNovalidFaceCountThreshold = paramJSONObject.getInt("novalid_face_count");
      }
      if (paramJSONObject.has("in_rect_ratio_threshold")) {
        this.inRectThreshold = ((float)paramJSONObject.getDouble("in_rect_ratio_threshold"));
      }
      if (paramJSONObject.has("need_check_shelter")) {
        this.needCheckShelter = paramJSONObject.getBoolean("need_check_shelter");
      }
      if (paramJSONObject.has("stable_roi_threshold")) {
        this.stableRoiThreshold = ((float)paramJSONObject.getDouble("stable_roi_threshold"));
      }
      this.bigFaceThresholdBuffer = ((float)paramJSONObject.optDouble("bigface_ratio_buffer", this.bigFaceThresholdBuffer));
      this.smallFaceThresholdBuffer = ((float)paramJSONObject.optDouble("smallface_ratio_buffer", this.smallFaceThresholdBuffer));
      this.poseThresholdBuffer = ((float)paramJSONObject.optDouble("pose_ratio_buffer", this.poseThresholdBuffer));
      this.stableRoiThreshold = ((float)paramJSONObject.optDouble("stable_roi_threshold", this.stableRoiThreshold));
      AppMethodBeat.o(218393);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      YtLogger.e(TAG, "Failed to parse json:" + paramJSONObject.getLocalizedMessage());
      AppMethodBeat.o(218393);
    }
  }
  
  public static enum FacePreviewingAdvise
  {
    static
    {
      AppMethodBeat.i(218236);
      ADVISE_PASS = new FacePreviewingAdvise("ADVISE_PASS", 0);
      ADVISE_NO_FACE = new FacePreviewingAdvise("ADVISE_NO_FACE", 1);
      ADVISE_TOO_FAR = new FacePreviewingAdvise("ADVISE_TOO_FAR", 2);
      ADVISE_TOO_CLOSE = new FacePreviewingAdvise("ADVISE_TOO_CLOSE", 3);
      ADVISE_NOT_IN_RECT = new FacePreviewingAdvise("ADVISE_NOT_IN_RECT", 4);
      ADVISE_INCORRECT_POSTURE = new FacePreviewingAdvise("ADVISE_INCORRECT_POSTURE", 5);
      ADVISE_EYE_CLOSE = new FacePreviewingAdvise("ADVISE_EYE_CLOSE", 6);
      ADVISE_TOO_MANY_FACE = new FacePreviewingAdvise("ADVISE_TOO_MANY_FACE", 7);
      ADVISE_INCOMPLETE_FACE = new FacePreviewingAdvise("ADVISE_INCOMPLETE_FACE", 8);
      ADVISE_INBUFFER_PASS = new FacePreviewingAdvise("ADVISE_INBUFFER_PASS", 9);
      ADVISE_NAN = new FacePreviewingAdvise("ADVISE_NAN", 10);
      $VALUES = new FacePreviewingAdvise[] { ADVISE_PASS, ADVISE_NO_FACE, ADVISE_TOO_FAR, ADVISE_TOO_CLOSE, ADVISE_NOT_IN_RECT, ADVISE_INCORRECT_POSTURE, ADVISE_EYE_CLOSE, ADVISE_TOO_MANY_FACE, ADVISE_INCOMPLETE_FACE, ADVISE_INBUFFER_PASS, ADVISE_NAN };
      AppMethodBeat.o(218236);
    }
    
    private FacePreviewingAdvise() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.SilentLivenessState
 * JD-Core Version:    0.7.0.1
 */