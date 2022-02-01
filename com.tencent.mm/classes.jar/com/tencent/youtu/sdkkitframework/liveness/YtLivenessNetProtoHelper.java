package com.tencent.youtu.sdkkitframework.liveness;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper.StateClassName;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKKitFrameworkWorkMode;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKPlatformContext;
import com.tencent.youtu.ytagreflectlivecheck.jni.YTAGReflectLiveCheckJNIInterface;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ReflectColorData;
import com.tencent.youtu.ytcommon.tools.wejson.WeJson;
import com.tencent.youtu.ytfacetrack.YTFaceTrack;
import com.tencent.youtu.ytposedetect.jni.YTPoseDetectJNIInterface;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class YtLivenessNetProtoHelper
{
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(218380);
    TAG = YtLivenessNetProtoHelper.class.getSimpleName();
    AppMethodBeat.o(218380);
  }
  
  public static String makeActionLiveReq(ActionLiveReqData paramActionLiveReqData)
  {
    AppMethodBeat.i(218315);
    ActionLiveReq localActionLiveReq = new ActionLiveReq();
    localActionLiveReq.app_id = paramActionLiveReqData.baseInfo.appId;
    localActionLiveReq.session_id = paramActionLiveReqData.baseInfo.sessionId;
    localActionLiveReq.business_id = paramActionLiveReqData.baseInfo.businessId;
    Object localObject = new Version();
    ((Version)localObject).sdk_version = YtSDKKitFramework.getInstance().version();
    ((Version)localObject).ftrack_sdk_version = YTFaceTrack.Version;
    ((Version)localObject).faction_sdk_version = YTPoseDetectJNIInterface.getVersion();
    localObject = ((Version)localObject).makeVersion();
    localActionLiveReq.select_data = new YtLivenessNetProtoHelper.LiveStyleRequester.SeleceData(paramActionLiveReqData.baseInfo.lux, paramActionLiveReqData.colorNum, paramActionLiveReqData.reflectConfig, (String)localObject, paramActionLiveReqData.controlConfig);
    localActionLiveReq.action_str = paramActionLiveReqData.actionStr;
    localActionLiveReq.action_video = paramActionLiveReqData.actionVideo;
    localActionLiveReq.best_image = paramActionLiveReqData.bestImage;
    localActionLiveReq.do_eye_detect = paramActionLiveReqData.needEyeDetect;
    localActionLiveReq.do_mouth_detect = paramActionLiveReqData.needMouthDetect;
    localActionLiveReq.do_live = true;
    paramActionLiveReqData = YtFSM.getInstance().getContext().imageToCompare;
    if (paramActionLiveReqData != null)
    {
      localObject = new ByteArrayOutputStream();
      paramActionLiveReqData.compress(Bitmap.CompressFormat.JPEG, 95, (OutputStream)localObject);
      localActionLiveReq.compare_image = new String(Base64.encode(((ByteArrayOutputStream)localObject).toByteArray(), 2));
      localActionLiveReq.compare_image_type = YtFSM.getInstance().getContext().imageToComapreType;
    }
    paramActionLiveReqData = new WeJson().toJson(localActionLiveReq);
    AppMethodBeat.o(218315);
    return paramActionLiveReqData;
  }
  
  public static String makeActionReflectLiveReq(ActionReflectLiveReqData paramActionReflectLiveReqData)
  {
    AppMethodBeat.i(218362);
    Object localObject1 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.ACTION_STATE));
    NetLivenessReqResultState.makeActionStr((String[])((YtFSMBaseState)localObject1).getStateDataBy("action_seq"));
    ActionReflectLiveReq localActionReflectLiveReq = new ActionReflectLiveReq();
    localActionReflectLiveReq.app_id = paramActionReflectLiveReqData.baseInfo.appId;
    localActionReflectLiveReq.session_id = paramActionReflectLiveReqData.baseInfo.sessionId;
    localActionReflectLiveReq.business_id = paramActionReflectLiveReqData.baseInfo.businessId;
    localActionReflectLiveReq.platform = 2;
    Object localObject2 = new Version();
    ((Version)localObject2).sdk_version = YtSDKKitFramework.getInstance().version();
    ((Version)localObject2).ftrack_sdk_version = YTFaceTrack.Version;
    ((Version)localObject2).faction_sdk_version = YTPoseDetectJNIInterface.getVersion();
    ((Version)localObject2).freflect_sdk_version = "3.6.9.2";
    localObject2 = ((Version)localObject2).makeVersion();
    localActionReflectLiveReq.select_data = new YtLivenessNetProtoHelper.LiveStyleRequester.SeleceData(paramActionReflectLiveReqData.baseInfo.lux, paramActionReflectLiveReqData.colorNum, paramActionReflectLiveReqData.reflectConfig, (String)localObject2, paramActionReflectLiveReqData.controlConfig);
    localObject2 = paramActionReflectLiveReqData.controlConfig;
    localObject1 = YTPoseDetectJNIInterface.Checksum((byte[])((YtFSMBaseState)localObject1).getStateDataBy("frames"));
    localObject2 = removeKey((String)localObject2, "sdcs").concat("&sdcs=" + YTPoseDetectJNIInterface.getLiveSelectDataChecksum(localActionReflectLiveReq.select_data.toString(), (String)localObject1));
    localActionReflectLiveReq.action_video = paramActionReflectLiveReqData.actionVideo;
    localObject1 = ((String)localObject2).concat("&avcs=".concat(String.valueOf(localObject1)));
    localActionReflectLiveReq.select_data.setConfig((String)localObject1);
    localActionReflectLiveReq.color_data = paramActionReflectLiveReqData.colorData;
    localActionReflectLiveReq.action_str = paramActionReflectLiveReqData.actionStr;
    localObject1 = YtFSM.getInstance().getContext().imageToCompare;
    if (localObject1 != null)
    {
      localObject2 = new ByteArrayOutputStream();
      ((Bitmap)localObject1).compress(Bitmap.CompressFormat.JPEG, 95, (OutputStream)localObject2);
      localActionReflectLiveReq.compare_image = new YtLivenessNetProtoHelper.ImageInfo(((ByteArrayOutputStream)localObject2).toByteArray(), null, null);
      localActionReflectLiveReq.compare_image_type = YtFSM.getInstance().getContext().imageToComapreType;
    }
    localActionReflectLiveReq.live_image = paramActionReflectLiveReqData.liveImage;
    localActionReflectLiveReq.mouth_image = paramActionReflectLiveReqData.mouthImage;
    localActionReflectLiveReq.eye_image = paramActionReflectLiveReqData.eyeImage;
    localActionReflectLiveReq.mode = paramActionReflectLiveReqData.mode;
    localActionReflectLiveReq.reflect_data = paramActionReflectLiveReqData.reflectData;
    localActionReflectLiveReq.config = paramActionReflectLiveReqData.config;
    paramActionReflectLiveReqData = new WeJson().toJson(localActionReflectLiveReq);
    AppMethodBeat.o(218362);
    return paramActionReflectLiveReqData;
  }
  
  public static String makeFourLiveReq(FourLiveReqData paramFourLiveReqData)
  {
    AppMethodBeat.i(218282);
    FourLiveReq localFourLiveReq = new FourLiveReq();
    localFourLiveReq.app_id = paramFourLiveReqData.baseInfoData.appId;
    localFourLiveReq.validate_data = paramFourLiveReqData.validateData;
    localFourLiveReq.video = paramFourLiveReqData.video;
    paramFourLiveReqData = YtFSM.getInstance().getContext().imageToCompare;
    if (paramFourLiveReqData != null)
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      paramFourLiveReqData.compress(Bitmap.CompressFormat.JPEG, 95, localByteArrayOutputStream);
      localFourLiveReq.compare_image = new String(Base64.encode(localByteArrayOutputStream.toByteArray(), 2));
    }
    paramFourLiveReqData = new WeJson().toJson(localFourLiveReq);
    AppMethodBeat.o(218282);
    return paramFourLiveReqData;
  }
  
  public static String makeGetFourLiveReq(GetFourLiveTypeReqData paramGetFourLiveTypeReqData)
  {
    AppMethodBeat.i(218272);
    GetFourLiveTypeReq localGetFourLiveTypeReq = new GetFourLiveTypeReq();
    localGetFourLiveTypeReq.app_id = paramGetFourLiveTypeReqData.baseInfo.appId;
    paramGetFourLiveTypeReqData = new WeJson().toJson(localGetFourLiveTypeReq);
    AppMethodBeat.o(218272);
    return paramGetFourLiveTypeReqData;
  }
  
  public static String makeGetLiveTypeReq(GetLiveTypeReqData paramGetLiveTypeReqData)
  {
    AppMethodBeat.i(218285);
    GetLiveTypeReq localGetLiveTypeReq = new GetLiveTypeReq();
    localGetLiveTypeReq.app_id = paramGetLiveTypeReqData.baseInfo.appId;
    localGetLiveTypeReq.business_name = paramGetLiveTypeReqData.baseInfo.businessId;
    localGetLiveTypeReq.person_id = paramGetLiveTypeReqData.baseInfo.personId;
    localGetLiveTypeReq.platform = 2;
    localGetLiveTypeReq.session_id = paramGetLiveTypeReqData.baseInfo.sessionId;
    Object localObject = new Version();
    ((Version)localObject).sdk_version = YtSDKKitFramework.getInstance().version();
    ((Version)localObject).ftrack_sdk_version = YTFaceTrack.Version;
    if (YtFSM.getInstance().getWorkMode() == YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTREFLECT_TYPE) {
      ((Version)localObject).faction_sdk_version = YTPoseDetectJNIInterface.getVersion();
    }
    ((Version)localObject).freflect_sdk_version = "3.6.9.2";
    localObject = ((Version)localObject).makeVersion();
    localGetLiveTypeReq.select_data = new YtLivenessNetProtoHelper.LiveStyleRequester.SeleceData(paramGetLiveTypeReqData.baseInfo.lux, paramGetLiveTypeReqData.colorNum, paramGetLiveTypeReqData.reflectConfig, (String)localObject, paramGetLiveTypeReqData.controlConfig);
    paramGetLiveTypeReqData = paramGetLiveTypeReqData.controlConfig.concat("&sdcs=" + YTAGReflectLiveCheckJNIInterface.Checksum(localGetLiveTypeReq.select_data.toString()));
    localGetLiveTypeReq.select_data.setConfig(paramGetLiveTypeReqData);
    paramGetLiveTypeReqData = new WeJson().toJson(localGetLiveTypeReq);
    AppMethodBeat.o(218285);
    return paramGetLiveTypeReqData;
  }
  
  public static String makeLipReadReq(LipReadReqData paramLipReadReqData)
  {
    int j = 0;
    AppMethodBeat.i(218305);
    PersonLiveReq localPersonLiveReq = new PersonLiveReq();
    localPersonLiveReq.app_id = paramLipReadReqData.baseInfo.appId;
    localPersonLiveReq.business_name = paramLipReadReqData.baseInfo.businessId;
    localPersonLiveReq.person_id = paramLipReadReqData.baseInfo.personId;
    localPersonLiveReq.livedata = new PersonLive();
    Object localObject = new Version();
    ((Version)localObject).sdk_version = YtSDKKitFramework.getInstance().version();
    ((Version)localObject).ftrack_sdk_version = YTFaceTrack.Version;
    ((Version)localObject).freflect_sdk_version = "3.6.9.2";
    localObject = ((Version)localObject).makeVersion();
    localPersonLiveReq.livedata.select_data = new YtLivenessNetProtoHelper.LiveStyleRequester.SeleceData(paramLipReadReqData.baseInfo.lux, 0, "", (String)localObject, "");
    localPersonLiveReq.livedata.frames = new ArrayList();
    localObject = new FaceFrame();
    ((FaceFrame)localObject).image = paramLipReadReqData.liveImage;
    ((FaceFrame)localObject).x_coordinates = new ArrayList();
    ((FaceFrame)localObject).y_coordinates = new ArrayList();
    int i = 0;
    while (i < 5)
    {
      ((FaceFrame)localObject).x_coordinates.add(Float.valueOf(paramLipReadReqData.liveFivePoint[(i * 2)]));
      ((FaceFrame)localObject).y_coordinates.add(Float.valueOf(paramLipReadReqData.liveFivePoint[(i * 2 + 1)]));
      i += 1;
    }
    localPersonLiveReq.livedata.frames.add(localObject);
    try
    {
      localObject = new JSONObject(paramLipReadReqData.faceExtraInfo);
      FaceFrame localFaceFrame = new FaceFrame();
      localFaceFrame.image = ((JSONObject)localObject).getString("openmouth_img");
      localFaceFrame.x_coordinates = new ArrayList();
      localFaceFrame.y_coordinates = new ArrayList();
      JSONArray localJSONArray = ((JSONObject)localObject).getJSONArray("openmouth_5pts");
      i = 0;
      while (i < 5)
      {
        localFaceFrame.x_coordinates.add(Float.valueOf((float)localJSONArray.optDouble(i * 2)));
        localFaceFrame.y_coordinates.add(Float.valueOf((float)localJSONArray.optDouble(i * 2 + 1)));
        i += 1;
      }
      localPersonLiveReq.livedata.frames.add(localFaceFrame);
      localFaceFrame = new FaceFrame();
      localFaceFrame.image = ((JSONObject)localObject).getString("closeeye_img");
      localFaceFrame.x_coordinates = new ArrayList();
      localFaceFrame.y_coordinates = new ArrayList();
      localObject = ((JSONObject)localObject).getJSONArray("closeeye_5pts");
      i = j;
      while (i < 5)
      {
        localFaceFrame.x_coordinates.add(Float.valueOf((float)((JSONArray)localObject).optDouble(i * 2)));
        localFaceFrame.y_coordinates.add(Float.valueOf((float)((JSONArray)localObject).optDouble(i * 2 + 1)));
        i += 1;
      }
      localPersonLiveReq.livedata.frames.add(localFaceFrame);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        YtLogger.e(TAG, "Failed parse extra face list " + localException.getLocalizedMessage());
      }
    }
    localPersonLiveReq.livedata.validate_data = paramLipReadReqData.validate_data;
    localPersonLiveReq.livedata.voice = paramLipReadReqData.voice;
    localPersonLiveReq.livedata.mouth_move = paramLipReadReqData.mouth_move;
    localPersonLiveReq.livedata.mouth_lip_reading = paramLipReadReqData.mouth_lip_reading;
    localPersonLiveReq.livedata.platform = 2;
    localPersonLiveReq.person_type = paramLipReadReqData.baseInfo.personType;
    localPersonLiveReq.live_type = paramLipReadReqData.baseInfo.liveType;
    localPersonLiveReq.req_type = paramLipReadReqData.baseInfo.reqType;
    paramLipReadReqData = new WeJson().toJson(localPersonLiveReq);
    AppMethodBeat.o(218305);
    return paramLipReadReqData;
  }
  
  public static String makePersonLiveReq(ReflectLiveReqData paramReflectLiveReqData)
  {
    AppMethodBeat.i(218338);
    PersonLiveReq localPersonLiveReq = new PersonLiveReq();
    localPersonLiveReq.app_id = paramReflectLiveReqData.baseInfo.appId;
    localPersonLiveReq.business_name = paramReflectLiveReqData.baseInfo.businessId;
    localPersonLiveReq.person_id = paramReflectLiveReqData.baseInfo.personId;
    localPersonLiveReq.live_type = paramReflectLiveReqData.baseInfo.liveType;
    localPersonLiveReq.req_type = paramReflectLiveReqData.baseInfo.reqType;
    localPersonLiveReq.request_id = paramReflectLiveReqData.baseInfo.sessionId;
    localPersonLiveReq.person_type = paramReflectLiveReqData.baseInfo.personType;
    localPersonLiveReq.livedata = new PersonLive();
    Object localObject = new Version();
    ((Version)localObject).sdk_version = YtSDKKitFramework.getInstance().version();
    ((Version)localObject).ftrack_sdk_version = YTFaceTrack.Version;
    ((Version)localObject).freflect_sdk_version = "3.6.9.2";
    localObject = ((Version)localObject).makeVersion();
    localPersonLiveReq.livedata.select_data = new YtLivenessNetProtoHelper.LiveStyleRequester.SeleceData(paramReflectLiveReqData.baseInfo.lux, paramReflectLiveReqData.colorNum, paramReflectLiveReqData.config, (String)localObject, "");
    localPersonLiveReq.livedata.reflect_data = paramReflectLiveReqData.reflectData;
    localPersonLiveReq.livedata.color_data = paramReflectLiveReqData.colorData;
    localPersonLiveReq.livedata.platform = 2;
    localPersonLiveReq.livedata.frames = new ArrayList();
    localObject = new FaceFrame();
    ((FaceFrame)localObject).image = paramReflectLiveReqData.bestImage.image;
    localPersonLiveReq.livedata.frames.add(localObject);
    localObject = new FaceFrame();
    ((FaceFrame)localObject).image = paramReflectLiveReqData.openMouthImage.image;
    localPersonLiveReq.livedata.frames.add(localObject);
    localObject = new FaceFrame();
    ((FaceFrame)localObject).image = paramReflectLiveReqData.openMouthImage.image;
    localPersonLiveReq.livedata.frames.add(localObject);
    paramReflectLiveReqData = new WeJson().toJson(localPersonLiveReq);
    AppMethodBeat.o(218338);
    return paramReflectLiveReqData;
  }
  
  public static String makePictureLiveReq(PictureLiveReqData paramPictureLiveReqData)
  {
    AppMethodBeat.i(218292);
    PictureLiveDetectReq localPictureLiveDetectReq = new PictureLiveDetectReq();
    localPictureLiveDetectReq.app_id = paramPictureLiveReqData.baseInfo.appId;
    localPictureLiveDetectReq.session_id = paramPictureLiveReqData.baseInfo.sessionId;
    localPictureLiveDetectReq.five_point = paramPictureLiveReqData.imageInfo.five_points;
    localPictureLiveDetectReq.image = paramPictureLiveReqData.imageInfo.image;
    Object localObject = new Version();
    ((Version)localObject).sdk_version = YtSDKKitFramework.getInstance().version();
    ((Version)localObject).ftrack_sdk_version = YTFaceTrack.Version;
    ((Version)localObject).freflect_sdk_version = "3.6.9.2";
    localObject = ((Version)localObject).makeVersion();
    localPictureLiveDetectReq.select_data = new YtLivenessNetProtoHelper.LiveStyleRequester.SeleceData(paramPictureLiveReqData.baseInfo.lux, 0, "", (String)localObject, "");
    paramPictureLiveReqData = new WeJson().toJson(localPictureLiveDetectReq);
    AppMethodBeat.o(218292);
    return paramPictureLiveReqData;
  }
  
  public static String makeReflectLiveReq(ReflectLiveReqData paramReflectLiveReqData)
  {
    AppMethodBeat.i(218324);
    ReflectLiveReq localReflectLiveReq = new ReflectLiveReq();
    localReflectLiveReq.app_id = paramReflectLiveReqData.baseInfo.appId;
    localReflectLiveReq.session_id = paramReflectLiveReqData.baseInfo.sessionId;
    localReflectLiveReq.business_id = paramReflectLiveReqData.baseInfo.businessId;
    localReflectLiveReq.platform = 2;
    localReflectLiveReq.color_data = paramReflectLiveReqData.colorData;
    localReflectLiveReq.live_image = paramReflectLiveReqData.liveImage;
    localReflectLiveReq.reflect_data = paramReflectLiveReqData.reflectData;
    Object localObject = new Version();
    ((Version)localObject).sdk_version = YtSDKKitFramework.getInstance().version();
    ((Version)localObject).ftrack_sdk_version = YTFaceTrack.Version;
    ((Version)localObject).freflect_sdk_version = "3.6.9.2";
    localObject = ((Version)localObject).makeVersion();
    localReflectLiveReq.select_data = new YtLivenessNetProtoHelper.LiveStyleRequester.SeleceData(paramReflectLiveReqData.baseInfo.lux, paramReflectLiveReqData.colorNum, paramReflectLiveReqData.config, (String)localObject, "");
    paramReflectLiveReqData = YtFSM.getInstance().getContext().imageToCompare;
    if (paramReflectLiveReqData != null)
    {
      localObject = new ByteArrayOutputStream();
      paramReflectLiveReqData.compress(Bitmap.CompressFormat.JPEG, 95, (OutputStream)localObject);
      localReflectLiveReq.compare_image = new String(Base64.encode(((ByteArrayOutputStream)localObject).toByteArray(), 2));
      localReflectLiveReq.compare_image_type = YtFSM.getInstance().getContext().imageToComapreType;
    }
    paramReflectLiveReqData = new WeJson().toJson(localReflectLiveReq);
    AppMethodBeat.o(218324);
    return paramReflectLiveReqData;
  }
  
  private static String removeKey(String paramString1, String paramString2)
  {
    AppMethodBeat.i(218350);
    String[] arrayOfString = paramString1.split("&");
    paramString1 = "";
    int i = 0;
    if (i < arrayOfString.length)
    {
      String str = paramString1;
      if (!arrayOfString[i].split("=")[0].equals(paramString2)) {
        if (paramString1.length() != 0) {
          break label92;
        }
      }
      label92:
      for (paramString1 = paramString1.concat(arrayOfString[i]);; paramString1 = paramString1.concat("&").concat(arrayOfString[i]))
      {
        YtLogger.d(TAG, "result: ".concat(String.valueOf(paramString1)));
        str = paramString1;
        i += 1;
        paramString1 = str;
        break;
      }
    }
    AppMethodBeat.o(218350);
    return paramString1;
  }
  
  static class ActionLiveReq
  {
    public String action_str;
    public String action_video;
    public String app_id;
    public String best_image;
    public String business_id;
    public String compare_image;
    public int compare_image_type;
    public boolean do_eye_detect;
    public boolean do_live;
    public boolean do_mouth_detect;
    public boolean get_more_image;
    public YtLivenessNetProtoHelper.LiveStyleRequester.SeleceData select_data;
    public String session_id;
  }
  
  public static class ActionLiveReqData
  {
    public String actionStr;
    public String actionVideo;
    public YtLivenessNetProtoHelper.NetBaseInfoData baseInfo;
    public String bestImage;
    public int colorNum;
    public String config;
    public String controlConfig;
    public boolean needEyeDetect;
    public boolean needMoreImage;
    public boolean needMouthDetect;
    public String reflectConfig;
    public String reservedfield;
    public ArrayList<YtLivenessNetProtoHelper.SensorData> sensorData;
  }
  
  static class ActionReflectLiveReq
  {
    public String action_str;
    public String action_video;
    public String app_id;
    public String business_id;
    public String color_data;
    public YtLivenessNetProtoHelper.ImageInfo compare_image;
    public int compare_image_type;
    public String config;
    public YtLivenessNetProtoHelper.ImageInfo eye_image;
    public YtLivenessNetProtoHelper.ImageInfo live_image;
    public int mode;
    public YtLivenessNetProtoHelper.ImageInfo mouth_image;
    public int platform;
    public ReflectColorData reflect_data;
    public YtLivenessNetProtoHelper.LiveStyleRequester.SeleceData select_data;
    public String session_id;
  }
  
  public static class ActionReflectLiveReqData
  {
    public String actionStr;
    public String actionVideo;
    public YtLivenessNetProtoHelper.NetBaseInfoData baseInfo;
    public String colorData;
    public int colorNum;
    public String config;
    public String controlConfig;
    public YtLivenessNetProtoHelper.ImageInfo eyeImage;
    public YtLivenessNetProtoHelper.ImageInfo liveImage;
    public int mode;
    public YtLivenessNetProtoHelper.ImageInfo mouthImage;
    public String reflectConfig;
    public ReflectColorData reflectData;
    public ArrayList<YtLivenessNetProtoHelper.SensorData> sensorData;
  }
  
  static class FaceFrame
  {
    public String image;
    public ArrayList<Float> x_coordinates;
    public ArrayList<Float> y_coordinates;
  }
  
  static class FourLiveReq
  {
    public String app_id;
    public String compare_image;
    public String validate_data;
    public String video;
  }
  
  public static class FourLiveReqData
  {
    public YtLivenessNetProtoHelper.NetBaseInfoData baseInfoData;
    public String validateData;
    public String video;
  }
  
  static class GetFourLiveTypeReq
  {
    public String app_id;
    public String seq;
  }
  
  public static class GetFourLiveTypeReqData
  {
    public YtLivenessNetProtoHelper.NetBaseInfoData baseInfo;
  }
  
  static class GetLiveTypeReq
  {
    public String app_id;
    public String business_name;
    public String person_id;
    public int platform;
    public YtLivenessNetProtoHelper.LiveStyleRequester.SeleceData select_data;
    public String session_id;
  }
  
  public static class GetLiveTypeReqData
  {
    public YtLivenessNetProtoHelper.NetBaseInfoData baseInfo;
    public int colorNum;
    public String controlConfig;
    public String reflectConfig;
  }
  
  public static class LipReadReqData
  {
    public YtLivenessNetProtoHelper.NetBaseInfoData baseInfo;
    public YtLivenessNetProtoHelper.ImageInfo bestImage;
    public String faceExtraInfo;
    public float[] liveFivePoint;
    public String liveImage;
    public String mouth_lip_reading;
    public String mouth_move;
    public String validate_data;
    public String voice;
  }
  
  public static class NetBaseInfoData
  {
    public String appId;
    public String businessId;
    public int liveType;
    public float lux;
    public String personId;
    public String personType;
    public String reqType;
    public String sessionId;
  }
  
  static class PersonLive
  {
    public String color_data;
    public ArrayList<YtLivenessNetProtoHelper.FaceFrame> frames;
    public String mouth_lip_reading;
    public String mouth_move;
    public int platform;
    public ReflectColorData reflect_data;
    public YtLivenessNetProtoHelper.LiveStyleRequester.SeleceData select_data;
    public ArrayList<YtLivenessNetProtoHelper.SensorData> sensor_data;
    public String validate_data;
    public String voice;
  }
  
  static class PersonLiveReq
  {
    public String app_id;
    public YtLivenessNetProtoHelper.ImageInfo best_image;
    public String business_name;
    public int live_type;
    public YtLivenessNetProtoHelper.PersonLive livedata;
    public String mp_business_buffer;
    public String person_id;
    public String person_type;
    public String req_type;
    public String request_id;
    public int scene;
  }
  
  static class PictureLiveDetectReq
  {
    public String app_id;
    public ArrayList<Float> five_point;
    public String image;
    public YtLivenessNetProtoHelper.LiveStyleRequester.SeleceData select_data;
    public String session_id;
  }
  
  public static class PictureLiveReqData
  {
    public YtLivenessNetProtoHelper.NetBaseInfoData baseInfo;
    public YtLivenessNetProtoHelper.ImageInfo imageInfo;
    public ArrayList<YtLivenessNetProtoHelper.SensorData> sensorData;
  }
  
  static class ReflectLiveReq
  {
    public String app_id;
    public String business_id;
    public String color_data;
    public String compare_image;
    public int compare_image_type;
    public String live_image;
    public int platform;
    public ReflectColorData reflect_data;
    public YtLivenessNetProtoHelper.LiveStyleRequester.SeleceData select_data;
    public String session_id;
  }
  
  public static class ReflectLiveReqData
  {
    public YtLivenessNetProtoHelper.NetBaseInfoData baseInfo;
    public YtLivenessNetProtoHelper.ImageInfo bestImage;
    public YtLivenessNetProtoHelper.ImageInfo closeEyeImage;
    public String colorData;
    public int colorNum;
    public String config;
    public String liveImage;
    public YtLivenessNetProtoHelper.ImageInfo openMouthImage;
    public ReflectColorData reflectData;
    public ArrayList<YtLivenessNetProtoHelper.SensorData> sensorData;
  }
  
  static class Version
  {
    public String faction_sdk_version = "";
    public String freflect_sdk_version = "";
    public String ftrack_sdk_version = "";
    public String sdk_version = "";
    
    public String makeVersion()
    {
      AppMethodBeat.i(218196);
      Object localObject = new StringBuffer();
      ((StringBuffer)localObject).append("sdk_version:");
      ((StringBuffer)localObject).append(this.sdk_version);
      ((StringBuffer)localObject).append(";ftrack_sdk_version:").append(this.ftrack_sdk_version);
      if (this.faction_sdk_version != "") {
        ((StringBuffer)localObject).append(";faction_sdk_version:").append(this.faction_sdk_version);
      }
      if (this.freflect_sdk_version != "") {
        ((StringBuffer)localObject).append(";freflect_sdk_version:").append(this.freflect_sdk_version);
      }
      localObject = ((StringBuffer)localObject).toString();
      AppMethodBeat.o(218196);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.YtLivenessNetProtoHelper
 * JD-Core Version:    0.7.0.1
 */