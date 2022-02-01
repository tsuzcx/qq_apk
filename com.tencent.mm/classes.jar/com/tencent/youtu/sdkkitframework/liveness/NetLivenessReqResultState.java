package com.tencent.youtu.sdkkitframework.liveness;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.os.Environment;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.common.YtSDKStats;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper.StateClassName;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYtSDKKitNetResponseParser;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKPlatformContext;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ActionReflectReq;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ReflectLiveReq;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.YTImageInfo;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleRequester.LiveStyleAndroidData;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleRequester.SeleceData;
import com.tencent.youtu.ytcommon.tools.wejson.WeJson;
import com.tencent.youtu.ytfacetrack.YTFaceTrack;
import com.tencent.youtu.ytposedetect.jni.YTPoseDetectJNIInterface;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class NetLivenessReqResultState
  extends YtFSMBaseState
{
  private static final String TAG;
  private int actRefUXMode;
  private int actReflectType;
  private String appId;
  private int backendProtoType;
  private YuvImage bestImage;
  private int changePointNum;
  private String controlConfig;
  private String extraConfig;
  private int finalConfidenceThreshold;
  private boolean needManualTrigger;
  boolean needVideoData;
  private HashMap<String, String> requestOptions;
  private String resultUrl;
  private String secretId;
  private String secretKey;
  private int simiThreshold;
  private String userId;
  
  static
  {
    AppMethodBeat.i(187217);
    TAG = NetLivenessReqResultState.class.getSimpleName();
    AppMethodBeat.o(187217);
  }
  
  public NetLivenessReqResultState()
  {
    AppMethodBeat.i(187201);
    this.needManualTrigger = false;
    this.simiThreshold = 70;
    this.requestOptions = new HashMap();
    this.actReflectType = 0;
    this.backendProtoType = 0;
    this.extraConfig = "";
    this.controlConfig = "";
    this.changePointNum = 2;
    this.actRefUXMode = 0;
    this.needVideoData = true;
    AppMethodBeat.o(187201);
  }
  
  private void handleResponseEvent(HashMap<String, String> paramHashMap, final Exception paramException)
  {
    AppMethodBeat.i(187207);
    YtSDKStats.getInstance().exitState();
    if (paramException != null)
    {
      YtLogger.i(TAG, "failed: error");
      YtSDKStats.getInstance().reportError(2097153, paramException.getMessage());
      localObject = paramException.getMessage();
      paramException = (Exception)localObject;
      if (paramHashMap != null)
      {
        paramException = (Exception)localObject;
        if (paramHashMap.containsKey("response")) {
          paramException = (String)paramHashMap.get("response");
        }
      }
      YtFSM.getInstance().sendFSMEvent(new HashMap() {});
      AppMethodBeat.o(187207);
      return;
    }
    localObject = "rst_failed";
    try
    {
      paramException = new JSONObject((String)paramHashMap.get("response"));
      bool = paramException.has("score");
    }
    catch (JSONException paramException)
    {
      for (;;)
      {
        try
        {
          label152:
          k = paramException.getInt("score");
          n = k;
          m = i;
        }
        catch (JSONException paramException)
        {
          boolean bool;
          j = -1;
          k = -1;
          continue;
        }
        try
        {
          YtLogger.i(TAG, "errorcode: " + i + " score " + k);
          n = k;
          m = i;
          if (!paramException.has("similarity_float")) {
            break label697;
          }
          n = k;
          m = i;
          j = paramException.getInt("similarity_float");
          if (j == -1) {
            break label694;
          }
        }
        catch (JSONException paramException)
        {
          j = -1;
          k = n;
          i = m;
          continue;
          continue;
          j = -1;
          continue;
        }
        try
        {
          if (j > this.simiThreshold)
          {
            paramException = "rst_succeed";
            localObject = new HashMap();
            YtLogger.i(TAG, "errorcode: " + i + " score " + k);
            if ((i != 0) || ((bool) && (k < this.finalConfidenceThreshold))) {
              continue;
            }
            ((HashMap)localObject).put("ui_action", "process_finished");
            ((HashMap)localObject).put("ui_tips", "rst_succeed");
            ((HashMap)localObject).put("process_action", "succeed");
            ((HashMap)localObject).put("error_code", Integer.valueOf(0));
            ((HashMap)localObject).put("message", CommonUtils.makeMessageJson(0, "rst_succeed", (String)paramHashMap.get("response")));
            ((HashMap)localObject).put("extra_message", this.bestImage);
            if (j > 0)
            {
              ((HashMap)localObject).put("cmp_message", paramException);
              ((HashMap)localObject).put("cmp_score", Integer.valueOf(j));
            }
            YtSDKStats.getInstance().reportInfo("errorCode ".concat(String.valueOf(i)));
            YtFSM.getInstance().sendFSMEvent((HashMap)localObject);
            AppMethodBeat.o(187207);
            return;
            if (paramException.has("error_code"))
            {
              i = paramException.getInt("error_code");
              continue;
            }
            if (!paramException.has("errorcode")) {
              break label709;
            }
            i = paramException.getInt("errorcode");
            continue;
            YtLogger.e(TAG, "response not right");
            k = -1;
            i = -1;
            continue;
          }
          paramException = "rst_failed";
          continue;
          paramException = paramException;
          bool = false;
          j = -1;
          k = -1;
          i = -1;
        }
        catch (JSONException paramException)
        {
          continue;
        }
        YtLogger.e(TAG, paramException.getLocalizedMessage());
        paramException = (Exception)localObject;
        continue;
        if ((bool) && (k < this.finalConfidenceThreshold)) {
          ((HashMap)localObject).put("error_reason_code", Integer.valueOf(4194305));
        }
        for (;;)
        {
          ((HashMap)localObject).put("ui_action", "process_finished");
          ((HashMap)localObject).put("ui_tips", "rst_failed");
          ((HashMap)localObject).put("process_action", "failed");
          ((HashMap)localObject).put("error_code", Integer.valueOf(4194304));
          ((HashMap)localObject).put("message", CommonUtils.makeMessageJson(i, "rst_failed", (String)paramHashMap.get("response")));
          break;
          ((HashMap)localObject).put("error_reason_code", Integer.valueOf(i));
        }
      }
    }
    try
    {
      if ((!paramException.has("errorcode")) && (!paramException.has("error_code"))) {
        break label487;
      }
      if (this.backendProtoType != 0) {
        break label449;
      }
      i = paramException.getInt("errorcode");
    }
    catch (JSONException paramException)
    {
      j = -1;
      k = -1;
      i = -1;
      break label522;
      k = -1;
      break label165;
      i = -1;
      break label152;
    }
    if (!bool) {}
  }
  
  private String makeActionStr(String[] paramArrayOfString)
  {
    AppMethodBeat.i(187212);
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
    AppMethodBeat.o(187212);
    return localObject1;
  }
  
  private void onActReflectRequest()
  {
    AppMethodBeat.i(187213);
    try
    {
      YtFSMBaseState localYtFSMBaseState = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_FETCH_STATE));
      Object localObject2 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.ACTION_STATE));
      this.bestImage = ((YuvImage)((YtFSMBaseState)localObject2).getStateDataBy("best_frame"));
      this.stateData.put("best_frame", this.bestImage);
      Object localObject1 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.REFLECT_STATE));
      ActionReflectReq localActionReflectReq = (ActionReflectReq)((YtFSMBaseState)localObject1).getStateDataBy("reflect_request_object");
      byte[] arrayOfByte = Base64.encode((byte[])((YtFSMBaseState)localObject2).getStateDataBy("frames"), 2);
      String str = (String)localYtFSMBaseState.getStateDataBy("control_config");
      if (str != null) {
        this.controlConfig = str;
      }
      str = (String)localYtFSMBaseState.getStateDataBy("extra_config");
      if (str != null)
      {
        this.extraConfig = str;
        YtLogger.d(TAG, "extraconfig:" + this.extraConfig);
      }
      str = (String)((YtFSMBaseState)localObject1).getStateDataBy("refcontrol_begin");
      if (str != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        if (this.extraConfig != null)
        {
          localObject1 = this.extraConfig;
          this.extraConfig = ((String)localObject1 + " refcontrol_begin " + str);
        }
      }
      else
      {
        localObject1 = (String)localYtFSMBaseState.getStateDataBy("cp_num");
        if (localObject1 != null)
        {
          this.changePointNum = Integer.parseInt((String)localObject1);
          YtLogger.d(TAG, "cpnum:" + this.changePointNum);
        }
        parseControlConfig();
        localObject1 = makeActionStr((String[])((YtFSMBaseState)localObject2).getStateDataBy("action_seq"));
        localObject2 = new YtLivenessNetProtoHelper.ActionReflectLiveReqData();
        ((YtLivenessNetProtoHelper.ActionReflectLiveReqData)localObject2).baseInfo = new YtLivenessNetProtoHelper.NetBaseInfoData();
        ((YtLivenessNetProtoHelper.ActionReflectLiveReqData)localObject2).baseInfo.sessionId = UUID.randomUUID().toString();
        ((YtLivenessNetProtoHelper.ActionReflectLiveReqData)localObject2).baseInfo.appId = this.appId;
        ((YtLivenessNetProtoHelper.ActionReflectLiveReqData)localObject2).baseInfo.businessId = "";
        ((YtLivenessNetProtoHelper.ActionReflectLiveReqData)localObject2).colorData = localActionReflectReq.color_data;
        if ((!this.needVideoData) && (this.actRefUXMode == 1)) {
          break label611;
        }
      }
      label611:
      for (((YtLivenessNetProtoHelper.ActionReflectLiveReqData)localObject2).actionVideo = new String(arrayOfByte);; ((YtLivenessNetProtoHelper.ActionReflectLiveReqData)localObject2).actionVideo = "")
      {
        ((YtLivenessNetProtoHelper.ActionReflectLiveReqData)localObject2).actionStr = ((String)localObject1);
        ((YtLivenessNetProtoHelper.ActionReflectLiveReqData)localObject2).eyeImage = new YtLivenessNetProtoHelper.ImageInfo(localActionReflectReq.eye_image.image, localActionReflectReq.eye_image.five_points, localActionReflectReq.eye_image.checksum);
        ((YtLivenessNetProtoHelper.ActionReflectLiveReqData)localObject2).mouthImage = new YtLivenessNetProtoHelper.ImageInfo(localActionReflectReq.mouth_image.image, localActionReflectReq.mouth_image.five_points, localActionReflectReq.mouth_image.checksum);
        ((YtLivenessNetProtoHelper.ActionReflectLiveReqData)localObject2).liveImage = new YtLivenessNetProtoHelper.ImageInfo(localActionReflectReq.live_image.image, localActionReflectReq.live_image.five_points, localActionReflectReq.live_image.checksum);
        ((YtLivenessNetProtoHelper.ActionReflectLiveReqData)localObject2).reflectData = localActionReflectReq.reflect_data;
        ((YtLivenessNetProtoHelper.ActionReflectLiveReqData)localObject2).baseInfo.lux = localActionReflectReq.select_data.android_data.lux;
        ((YtLivenessNetProtoHelper.ActionReflectLiveReqData)localObject2).reflectConfig = this.extraConfig;
        ((YtLivenessNetProtoHelper.ActionReflectLiveReqData)localObject2).controlConfig = this.controlConfig;
        ((YtLivenessNetProtoHelper.ActionReflectLiveReqData)localObject2).colorNum = this.changePointNum;
        localObject1 = YtLivenessNetProtoHelper.makeActionReflectLiveReq((YtLivenessNetProtoHelper.ActionReflectLiveReqData)localObject2);
        YtFSM.getInstance().sendNetworkRequest("net_reporting", this.resultUrl, (String)localObject1, null, new YtSDKKitFramework.IYtSDKKitNetResponseParser()
        {
          public void onNetworkResponseEvent(HashMap<String, String> paramAnonymousHashMap, Exception paramAnonymousException)
          {
            AppMethodBeat.i(187189);
            YtLogger.i(NetLivenessReqResultState.TAG, "handle actreflect response");
            NetLivenessReqResultState.access$100(NetLivenessReqResultState.this, paramAnonymousHashMap, paramAnonymousException);
            NetLivenessReqResultState.access$200(NetLivenessReqResultState.this);
            AppMethodBeat.o(187189);
          }
        });
        AppMethodBeat.o(187213);
        return;
        localObject1 = "";
        break;
      }
      return;
    }
    catch (Exception localException)
    {
      YtLogger.e(TAG, "actrefl request failed" + localException.getLocalizedMessage());
      YtSDKStats.getInstance().reportInfo("actrefl request failed: " + localException.getLocalizedMessage());
      YtFSM.getInstance().sendFSMEvent(new HashMap() {});
      AppMethodBeat.o(187213);
    }
  }
  
  private void onActReflectRequest2()
  {
    AppMethodBeat.i(187214);
    Object localObject3 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.ACTION_STATE));
    this.bestImage = ((YuvImage)((YtFSMBaseState)localObject3).getStateDataBy("best_frame"));
    this.stateData.put("best_frame", this.bestImage);
    ArrayList localArrayList = (ArrayList)((YtFSMBaseState)localObject3).getStateDataBy("frame_list");
    YtLogger.d(TAG, "action request 2 frame size:" + localArrayList.size());
    Object localObject1 = (ActionReflectReq)YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.REFLECT_STATE)).getStateDataBy("reflect_request_object");
    ActionReflectReq2 localActionReflectReq2 = new ActionReflectReq2();
    localObject3 = Base64.encode((byte[])((YtFSMBaseState)localObject3).getStateDataBy("frames"), 2);
    Object localObject4 = new Version();
    ((Version)localObject4).sdk_version = YtSDKKitFramework.getInstance().version();
    ((Version)localObject4).ftrack_sdk_version = YTFaceTrack.Version;
    ((Version)localObject4).faction_sdk_version = YTPoseDetectJNIInterface.getVersion();
    ((Version)localObject4).freflect_sdk_version = "3.6.4.3";
    ((ActionReflectReq)localObject1).action_video = new String((byte[])localObject3);
    new WeJson();
    ((ActionReflectReq)localObject1).client_version = String.format("sdk_version:%s;ftrack_sdk_version:%s;freflect_sdk_version:%s;faction_sdk_version:%s", new Object[] { ((Version)localObject4).sdk_version, ((Version)localObject4).ftrack_sdk_version, ((Version)localObject4).freflect_sdk_version, ((Version)localObject4).faction_sdk_version });
    ((ActionReflectReq)localObject1).session_id = "12345";
    localActionReflectReq2.live_req = ((ActionReflectReq)localObject1);
    localActionReflectReq2.session_id = UUID.randomUUID().toString();
    try
    {
      localObject3 = new FileInputStream(new File(Environment.getExternalStorageDirectory().getPath() + "/test.mp4"));
      YtLogger.d(TAG, "encode video size:" + ((FileInputStream)localObject3).available());
      if (((FileInputStream)localObject3).available() != 0) {
        localObject1 = new byte[((FileInputStream)localObject3).available()];
      }
    }
    catch (IOException localIOException1)
    {
      for (;;)
      {
        try
        {
          ((FileInputStream)localObject3).read((byte[])localObject1);
          ((FileInputStream)localObject3).close();
          int i;
          if (localObject1 == null)
          {
            localActionReflectReq2.video = "";
            YtLogger.d(TAG, "encode video size:" + localActionReflectReq2.video.length());
            localActionReflectReq2.images = new ArrayList();
            localActionReflectReq2.five_points = new ArrayList();
            i = 0;
            if (i >= localArrayList.size()) {
              continue;
            }
            int k = ((ActionLivenessState.BestFrame)localArrayList.get(i)).frame.getWidth();
            j = ((ActionLivenessState.BestFrame)localArrayList.get(i)).frame.getHeight();
            YtLogger.d(TAG, "Eye score " + ((ActionLivenessState.BestFrame)localArrayList.get(i)).eyeScore);
            if (YtFSM.getInstance().getContext().currentRotateState < 5) {
              continue;
            }
            m = k;
            k = j;
            localObject1 = ((ActionLivenessState.BestFrame)localArrayList.get(i)).frame.getYuvData();
            YtLogger.d(TAG, "Rotated size:" + localObject1.length);
            localObject1 = new YuvImage((byte[])localObject1, 17, k, m, null);
            localObject3 = new ByteArrayOutputStream();
            ((YuvImage)localObject1).compressToJpeg(new Rect(0, 0, ((YuvImage)localObject1).getWidth(), ((YuvImage)localObject1).getHeight()), 95, (OutputStream)localObject3);
            localObject4 = ((ByteArrayOutputStream)localObject3).toByteArray();
            localObject1 = Base64.encode((byte[])localObject4, 2);
          }
          try
          {
            localObject3 = BitmapFactory.decodeByteArray((byte[])localObject4, 0, ((ByteArrayOutputStream)localObject3).size());
            localObject4 = new FileOutputStream(new File(Environment.getExternalStorageDirectory().getPath() + "/bestbmp" + i + ".jpg"));
            ((Bitmap)localObject3).compress(Bitmap.CompressFormat.JPEG, 95, (OutputStream)localObject4);
            ((OutputStream)localObject4).flush();
            ((OutputStream)localObject4).close();
            localActionReflectReq2.images.add(new String((byte[])localObject1));
            localObject1 = new FivePoints();
            ((FivePoints)localObject1).points = new ArrayList();
            YtLogger.d(TAG, "f5p size:" + ((ActionLivenessState.BestFrame)localArrayList.get(i)).f5p.length / 2);
            j = 0;
            if (j < ((ActionLivenessState.BestFrame)localArrayList.get(i)).f5p.length / 2)
            {
              localObject3 = new Pointf();
              ((Pointf)localObject3).x = ((ActionLivenessState.BestFrame)localArrayList.get(i)).f5p[(j * 2)];
              ((Pointf)localObject3).y = ((ActionLivenessState.BestFrame)localArrayList.get(i)).f5p[(j * 2 + 1)];
              ((FivePoints)localObject1).points.add(localObject3);
              YtLogger.d(TAG, "f5p[" + j + "] " + ((Pointf)localObject3).x + "," + ((Pointf)localObject3).y);
              j += 1;
              continue;
              localActionReflectReq2.video = new String(Base64.encode((byte[])localObject1, 2));
              continue;
            }
            localActionReflectReq2.five_points.add(localObject1);
            i += 1;
            continue;
            YtLogger.d(TAG, "f5p count" + localActionReflectReq2.five_points.size());
            localObject1 = new WeJson().toJson(localActionReflectReq2);
            YtLogger.d(TAG, "upload string size:" + ((String)localObject1).length());
            YtFSM.getInstance().sendNetworkRequest("net_reporting", this.resultUrl, (String)localObject1, null, new YtSDKKitFramework.IYtSDKKitNetResponseParser()
            {
              public void onNetworkResponseEvent(HashMap<String, String> paramAnonymousHashMap, Exception paramAnonymousException)
              {
                AppMethodBeat.i(187191);
                NetLivenessReqResultState.access$100(NetLivenessReqResultState.this, paramAnonymousHashMap, paramAnonymousException);
                NetLivenessReqResultState.access$200(NetLivenessReqResultState.this);
                AppMethodBeat.o(187191);
              }
            });
            AppMethodBeat.o(187214);
            return;
          }
          catch (Exception localException)
          {
            continue;
          }
          localIOException1 = localIOException1;
          localObject2 = null;
          continue;
        }
        catch (IOException localIOException2)
        {
          int j;
          continue;
          int m = j;
          continue;
        }
        Object localObject2 = null;
      }
    }
  }
  
  private void onActionRequest()
  {
    Object localObject1 = null;
    AppMethodBeat.i(187210);
    for (;;)
    {
      try
      {
        localObject2 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.ACTION_STATE));
        if (localObject2 == null)
        {
          YtSDKStats.getInstance().reportInfo("action request action state is null");
          YtLogger.e(TAG, "action request action state is null");
          AppMethodBeat.o(187210);
          return;
        }
        this.bestImage = ((YuvImage)((YtFSMBaseState)localObject2).getStateDataBy("best_frame"));
        localByteArrayOutputStream = new ByteArrayOutputStream();
        this.bestImage.compressToJpeg(new Rect(0, 0, this.bestImage.getWidth(), this.bestImage.getHeight()), 95, localByteArrayOutputStream);
        localObject3 = (byte[])((YtFSMBaseState)localObject2).getStateDataBy("frames");
        if (localObject3 != null) {
          break label423;
        }
        YtLogger.e(TAG, "action data is null");
      }
      catch (Exception localException)
      {
        Object localObject2;
        ByteArrayOutputStream localByteArrayOutputStream;
        YtLogger.e(TAG, "action request failed" + localException.getLocalizedMessage());
        YtSDKStats.getInstance().reportInfo("action request failed: " + localException.getLocalizedMessage());
        YtFSM.getInstance().sendFSMEvent(new HashMap() {});
        AppMethodBeat.o(187210);
        return;
      }
      localObject2 = makeActionStr((String[])((YtFSMBaseState)localObject2).getStateDataBy("action_seq"));
      parseControlConfig();
      Object localObject3 = new YtLivenessNetProtoHelper.ActionLiveReqData();
      ((YtLivenessNetProtoHelper.ActionLiveReqData)localObject3).baseInfo = new YtLivenessNetProtoHelper.NetBaseInfoData();
      ((YtLivenessNetProtoHelper.ActionLiveReqData)localObject3).baseInfo.appId = this.appId;
      ((YtLivenessNetProtoHelper.ActionLiveReqData)localObject3).baseInfo.sessionId = UUID.randomUUID().toString();
      ((YtLivenessNetProtoHelper.ActionLiveReqData)localObject3).bestImage = new String(Base64.encode(localByteArrayOutputStream.toByteArray(), 2));
      ((YtLivenessNetProtoHelper.ActionLiveReqData)localObject3).actionStr = ((String)localObject2);
      if (this.needVideoData)
      {
        ((YtLivenessNetProtoHelper.ActionLiveReqData)localObject3).actionVideo = new String((byte[])localObject1);
        ((YtLivenessNetProtoHelper.ActionLiveReqData)localObject3).needEyeDetect = true;
        ((YtLivenessNetProtoHelper.ActionLiveReqData)localObject3).needMouthDetect = true;
        ((YtLivenessNetProtoHelper.ActionLiveReqData)localObject3).reflectConfig = this.extraConfig;
        ((YtLivenessNetProtoHelper.ActionLiveReqData)localObject3).controlConfig = this.controlConfig;
        ((YtLivenessNetProtoHelper.ActionLiveReqData)localObject3).colorNum = this.changePointNum;
        localObject1 = YtLivenessNetProtoHelper.makeActionLiveReq((YtLivenessNetProtoHelper.ActionLiveReqData)localObject3);
        YtFSM.getInstance().sendNetworkRequest("net_reporting", this.resultUrl, (String)localObject1, null, new YtSDKKitFramework.IYtSDKKitNetResponseParser()
        {
          public void onNetworkResponseEvent(HashMap<String, String> paramAnonymousHashMap, Exception paramAnonymousException)
          {
            AppMethodBeat.i(187197);
            YtLogger.i(NetLivenessReqResultState.TAG, "Handle action response");
            NetLivenessReqResultState.access$100(NetLivenessReqResultState.this, paramAnonymousHashMap, paramAnonymousException);
            NetLivenessReqResultState.access$200(NetLivenessReqResultState.this);
            AppMethodBeat.o(187197);
          }
        });
        AppMethodBeat.o(187210);
        return;
        localObject1 = Base64.encode((byte[])localObject3, 2);
      }
      else
      {
        ((YtLivenessNetProtoHelper.ActionLiveReqData)localObject3).actionVideo = "";
        continue;
        label423:
        if (localObject3 != null) {}
      }
    }
  }
  
  private void onCheckResponseManual()
  {
    AppMethodBeat.i(187205);
    if (this.needManualTrigger) {
      try
      {
        YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE)).handleStateAction("reset_manual_trigger", null);
        YtFSM.getInstance().transitNextRound(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE));
        AppMethodBeat.o(187205);
        return;
      }
      catch (Exception localException)
      {
        String str = "on Check response manual failed " + localException.getLocalizedMessage();
        YtLogger.e(TAG, str);
        YtSDKStats.getInstance().reportInfo(str);
      }
    }
    AppMethodBeat.o(187205);
  }
  
  private void onLipReadRequest()
  {
    int i = 0;
    int j = 0;
    AppMethodBeat.i(187208);
    for (;;)
    {
      try
      {
        Object localObject5 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE));
        Object localObject3 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.LIPREAD_STATE));
        if (localObject3 == null)
        {
          YtSDKStats.getInstance().reportInfo("lipread request action state is null");
          YtLogger.e(TAG, "lipread request action state is null");
          AppMethodBeat.o(187208);
          return;
        }
        this.bestImage = ((YuvImage)((YtFSMBaseState)localObject3).getStateDataBy("last_frame"));
        Object localObject1 = new ByteArrayOutputStream();
        this.bestImage.compressToJpeg(new Rect(0, 0, this.bestImage.getWidth(), this.bestImage.getHeight()), 95, (OutputStream)localObject1);
        Object localObject6 = Base64.encode(((ByteArrayOutputStream)localObject1).toByteArray(), 2);
        Arrays.toString((String[])((YtFSMBaseState)localObject3).getStateDataBy("action_seq"));
        if (this.backendProtoType == 2)
        {
          localObject4 = new YtLivenessNetProtoHelper.LipReadReqData();
          ((YtLivenessNetProtoHelper.LipReadReqData)localObject4).baseInfo = new YtLivenessNetProtoHelper.NetBaseInfoData();
          ((YtLivenessNetProtoHelper.LipReadReqData)localObject4).baseInfo.appId = this.appId;
          ((YtLivenessNetProtoHelper.LipReadReqData)localObject4).baseInfo.sessionId = UUID.randomUUID().toString();
          YtLivenessNetProtoHelper.NetBaseInfoData localNetBaseInfoData = ((YtLivenessNetProtoHelper.LipReadReqData)localObject4).baseInfo;
          if (!this.requestOptions.containsKey("business_id")) {
            break label1124;
          }
          localObject1 = (String)this.requestOptions.get("business_id");
          localNetBaseInfoData.businessId = ((String)localObject1);
          localNetBaseInfoData = ((YtLivenessNetProtoHelper.LipReadReqData)localObject4).baseInfo;
          if (!this.requestOptions.containsKey("person_id")) {
            break label1132;
          }
          localObject1 = (String)this.requestOptions.get("person_id");
          localNetBaseInfoData.personId = ((String)localObject1);
          localNetBaseInfoData = ((YtLivenessNetProtoHelper.LipReadReqData)localObject4).baseInfo;
          if (!this.requestOptions.containsKey("person_type")) {
            break label1140;
          }
          localObject1 = (String)this.requestOptions.get("person_type");
          localNetBaseInfoData.personType = ((String)localObject1);
          localNetBaseInfoData = ((YtLivenessNetProtoHelper.LipReadReqData)localObject4).baseInfo;
          if (!this.requestOptions.containsKey("req_type")) {
            break label1148;
          }
          localObject1 = (String)this.requestOptions.get("req_type");
          localNetBaseInfoData.reqType = ((String)localObject1);
          localObject1 = ((YtLivenessNetProtoHelper.LipReadReqData)localObject4).baseInfo;
          if (!this.requestOptions.containsKey("live_type")) {
            break label1156;
          }
          i = Integer.parseInt((String)this.requestOptions.get("live_type"));
          ((YtLivenessNetProtoHelper.NetBaseInfoData)localObject1).liveType = i;
          ((YtLivenessNetProtoHelper.LipReadReqData)localObject4).liveImage = new String((byte[])localObject6);
          ((YtLivenessNetProtoHelper.LipReadReqData)localObject4).liveFivePoint = ((float[])((YtFSMBaseState)localObject3).getStateDataBy("last_frame_landmark"));
          ((YtLivenessNetProtoHelper.LipReadReqData)localObject4).faceExtraInfo = ((String)((YtFSMBaseState)localObject3).getStateDataBy("face_extra_list"));
          localObject6 = (String[])((YtFSMBaseState)localObject3).getStateDataBy("action_seq");
          localObject1 = "";
          int k = localObject6.length;
          i = j;
          if (i < k)
          {
            localNetBaseInfoData = localObject6[i];
            localObject1 = (String)localObject1 + localNetBaseInfoData;
            i += 1;
            continue;
          }
          YtLogger.d(TAG, "action_seq: ".concat(String.valueOf(localObject1)));
          ((YtLivenessNetProtoHelper.LipReadReqData)localObject4).validate_data = ((String)localObject1);
          ((YtLivenessNetProtoHelper.LipReadReqData)localObject4).voice = new String(Base64.encode((byte[])((YtFSMBaseState)localObject3).getStateDataBy("audio_data"), 2));
          ((YtLivenessNetProtoHelper.LipReadReqData)localObject4).mouth_lip_reading = ((String)((YtFSMBaseState)localObject3).getStateDataBy("lipreading_feature"));
          ((YtLivenessNetProtoHelper.LipReadReqData)localObject4).mouth_move = ((String)((YtFSMBaseState)localObject3).getStateDataBy("feature"));
          localObject1 = (YuvImage)((YtFSMBaseState)localObject5).getStateDataBy("best_image");
          localObject3 = (float[])((YtFSMBaseState)localObject5).getStateDataBy("best_shape");
          localObject5 = new ByteArrayOutputStream();
          ((YuvImage)localObject1).compressToJpeg(new Rect(0, 0, this.bestImage.getWidth(), this.bestImage.getHeight()), 95, (OutputStream)localObject5);
          ((YtLivenessNetProtoHelper.LipReadReqData)localObject4).bestImage = new YtLivenessNetProtoHelper.ImageInfo(((ByteArrayOutputStream)localObject5).toByteArray(), (float[])localObject3, null);
          localObject1 = YtLivenessNetProtoHelper.makeLipReadReq((YtLivenessNetProtoHelper.LipReadReqData)localObject4);
          YtFSM.getInstance().sendNetworkRequest("net_reporting", this.resultUrl, (String)localObject1, null, new YtSDKKitFramework.IYtSDKKitNetResponseParser()
          {
            public void onNetworkResponseEvent(HashMap<String, String> paramAnonymousHashMap, Exception paramAnonymousException)
            {
              AppMethodBeat.i(187195);
              YtLogger.i(NetLivenessReqResultState.TAG, "Handle lipread response");
              NetLivenessReqResultState.access$100(NetLivenessReqResultState.this, paramAnonymousHashMap, paramAnonymousException);
              NetLivenessReqResultState.access$200(NetLivenessReqResultState.this);
              AppMethodBeat.o(187195);
            }
          });
          AppMethodBeat.o(187208);
          return;
        }
        Object localObject4 = (String[])((YtFSMBaseState)localObject3).getStateDataBy("action_seq");
        localObject1 = "";
        j = localObject4.length;
        if (i < j)
        {
          localObject5 = localObject4[i];
          localObject1 = (String)localObject1 + (String)localObject5;
          i += 1;
          continue;
        }
        YtLogger.d(TAG, "action_seq: ".concat(String.valueOf(localObject1)));
        localObject4 = new YtLivenessNetProtoHelper.FourLiveReqData();
        ((YtLivenessNetProtoHelper.FourLiveReqData)localObject4).baseInfoData = new YtLivenessNetProtoHelper.NetBaseInfoData();
        ((YtLivenessNetProtoHelper.FourLiveReqData)localObject4).baseInfoData.appId = this.appId;
        ((YtLivenessNetProtoHelper.FourLiveReqData)localObject4).validateData = ((String)localObject1);
        ((YtLivenessNetProtoHelper.FourLiveReqData)localObject4).video = new String(Base64.encode((byte[])((YtFSMBaseState)localObject3).getStateDataBy("audio_data"), 2));
        localObject3 = YtLivenessNetProtoHelper.makeFourLiveReq((YtLivenessNetProtoHelper.FourLiveReqData)localObject4);
        i = this.requestOptions.size();
        localObject1 = localObject3;
        if (i <= 0) {
          continue;
        }
        try
        {
          localObject1 = new JSONObject((String)localObject3);
          localObject4 = this.requestOptions.entrySet().iterator();
          if (((Iterator)localObject4).hasNext())
          {
            localObject5 = (Map.Entry)((Iterator)localObject4).next();
            ((JSONObject)localObject1).put((String)((Map.Entry)localObject5).getKey(), ((Map.Entry)localObject5).getValue());
            continue;
          }
        }
        catch (JSONException localJSONException)
        {
          YtLogger.e(TAG, "lipread net request parse json failed " + localJSONException.getLocalizedMessage());
          Object localObject2 = localObject3;
        }
        str = localException.toString();
      }
      catch (Exception localException)
      {
        YtLogger.e(TAG, "lipread request failed" + localException.getLocalizedMessage());
        YtSDKStats.getInstance().reportInfo("lipreading request failed: " + localException.getLocalizedMessage());
        YtFSM.getInstance().sendFSMEvent(new HashMap() {});
        AppMethodBeat.o(187208);
        return;
      }
      continue;
      label1124:
      String str = "wx_default";
      continue;
      label1132:
      str = "wx_default0";
      continue;
      label1140:
      str = "youtu";
      continue;
      label1148:
      str = "live";
      continue;
      label1156:
      i = 0;
    }
  }
  
  private void onReflectRequest()
  {
    AppMethodBeat.i(187211);
    CommonUtils.benchMarkBegin("reflect_request_s1");
    for (;;)
    {
      try
      {
        Object localObject3 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE));
        this.bestImage = ((YuvImage)((YtFSMBaseState)localObject3).getStateDataBy("best_image"));
        Object localObject1 = new ByteArrayOutputStream();
        this.bestImage.compressToJpeg(new Rect(0, 0, this.bestImage.getWidth(), this.bestImage.getHeight()), 95, (OutputStream)localObject1);
        Object localObject4 = Base64.encode(((ByteArrayOutputStream)localObject1).toByteArray(), 2);
        this.stateData.put("best_frame", this.bestImage);
        localObject1 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.REFLECT_STATE));
        Object localObject6 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_FETCH_STATE));
        Object localObject5 = (ReflectLiveReq)((YtFSMBaseState)localObject1).getStateDataBy("reflect_request_object");
        Object localObject7 = (String)((YtFSMBaseState)localObject6).getStateDataBy("extra_config");
        if (localObject7 != null) {
          this.extraConfig = ((String)localObject7);
        }
        localObject7 = (String)((YtFSMBaseState)localObject1).getStateDataBy("refcontrol_begin");
        if (localObject7 != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          if (this.extraConfig != null)
          {
            localObject1 = this.extraConfig;
            this.extraConfig = ((String)localObject1 + " refcontrol_begin " + (String)localObject7);
          }
        }
        else
        {
          localObject1 = (String)((YtFSMBaseState)localObject6).getStateDataBy("cp_num");
          if (localObject1 != null) {
            this.changePointNum = Integer.parseInt((String)localObject1);
          }
          ((ReflectLiveReq)localObject5).session_id = UUID.randomUUID().toString();
          localObject6 = new YtLivenessNetProtoHelper.ReflectLiveReqData();
          ((YtLivenessNetProtoHelper.ReflectLiveReqData)localObject6).baseInfo = new YtLivenessNetProtoHelper.NetBaseInfoData();
          ((YtLivenessNetProtoHelper.ReflectLiveReqData)localObject6).baseInfo.appId = this.appId;
          ((YtLivenessNetProtoHelper.ReflectLiveReqData)localObject6).baseInfo.sessionId = UUID.randomUUID().toString();
          localObject7 = ((YtLivenessNetProtoHelper.ReflectLiveReqData)localObject6).baseInfo;
          if (!this.requestOptions.containsKey("business_id")) {
            break label986;
          }
          localObject1 = (String)this.requestOptions.get("business_id");
          ((YtLivenessNetProtoHelper.NetBaseInfoData)localObject7).businessId = ((String)localObject1);
          localObject7 = ((YtLivenessNetProtoHelper.ReflectLiveReqData)localObject6).baseInfo;
          if (!this.requestOptions.containsKey("person_id")) {
            break label991;
          }
          localObject1 = (String)this.requestOptions.get("person_id");
          ((YtLivenessNetProtoHelper.NetBaseInfoData)localObject7).personId = ((String)localObject1);
          localObject7 = ((YtLivenessNetProtoHelper.ReflectLiveReqData)localObject6).baseInfo;
          if (!this.requestOptions.containsKey("person_type")) {
            break label996;
          }
          localObject1 = (String)this.requestOptions.get("person_type");
          ((YtLivenessNetProtoHelper.NetBaseInfoData)localObject7).personType = ((String)localObject1);
          localObject7 = ((YtLivenessNetProtoHelper.ReflectLiveReqData)localObject6).baseInfo;
          if (!this.requestOptions.containsKey("req_type")) {
            break label1001;
          }
          localObject1 = (String)this.requestOptions.get("req_type");
          ((YtLivenessNetProtoHelper.NetBaseInfoData)localObject7).reqType = ((String)localObject1);
          localObject1 = ((YtLivenessNetProtoHelper.ReflectLiveReqData)localObject6).baseInfo;
          if (!this.requestOptions.containsKey("live_type")) {
            break label1006;
          }
          i = Integer.parseInt((String)this.requestOptions.get("live_type"));
          ((YtLivenessNetProtoHelper.NetBaseInfoData)localObject1).liveType = i;
          ((YtLivenessNetProtoHelper.ReflectLiveReqData)localObject6).colorData = ((ReflectLiveReq)localObject5).color_data;
          ((YtLivenessNetProtoHelper.ReflectLiveReqData)localObject6).liveImage = new String((byte[])localObject4);
          ((YtLivenessNetProtoHelper.ReflectLiveReqData)localObject6).reflectData = ((ReflectLiveReq)localObject5).reflect_data;
          ((YtLivenessNetProtoHelper.ReflectLiveReqData)localObject6).config = this.extraConfig;
          ((YtLivenessNetProtoHelper.ReflectLiveReqData)localObject6).colorNum = this.changePointNum;
          if (this.backendProtoType != 2) {
            continue;
          }
          localObject1 = (YuvImage)((YtFSMBaseState)localObject3).getStateDataBy("best_image");
          localObject4 = (float[])((YtFSMBaseState)localObject3).getStateDataBy("best_shape");
          localObject5 = new ByteArrayOutputStream();
          ((YuvImage)localObject1).compressToJpeg(new Rect(0, 0, this.bestImage.getWidth(), this.bestImage.getHeight()), 95, (OutputStream)localObject5);
          ((YtLivenessNetProtoHelper.ReflectLiveReqData)localObject6).bestImage = new YtLivenessNetProtoHelper.ImageInfo(((ByteArrayOutputStream)localObject5).toByteArray(), (float[])localObject4, null);
          localObject1 = (YuvImage)((YtFSMBaseState)localObject3).getStateDataBy("openmouth_image");
          localObject4 = (float[])((YtFSMBaseState)localObject3).getStateDataBy("openmouth_shape");
          localObject5 = new ByteArrayOutputStream();
          ((YuvImage)localObject1).compressToJpeg(new Rect(0, 0, ((YuvImage)localObject1).getWidth(), ((YuvImage)localObject1).getHeight()), 95, (OutputStream)localObject5);
          ((YtLivenessNetProtoHelper.ReflectLiveReqData)localObject6).openMouthImage = new YtLivenessNetProtoHelper.ImageInfo(((ByteArrayOutputStream)localObject5).toByteArray(), (float[])localObject4, null);
          localObject1 = (YuvImage)((YtFSMBaseState)localObject3).getStateDataBy("closeeye_image");
          localObject3 = (float[])((YtFSMBaseState)localObject3).getStateDataBy("closeeye_shape");
          localObject4 = new ByteArrayOutputStream();
          ((YuvImage)localObject1).compressToJpeg(new Rect(0, 0, ((YuvImage)localObject1).getWidth(), ((YuvImage)localObject1).getHeight()), 95, (OutputStream)localObject4);
          ((YtLivenessNetProtoHelper.ReflectLiveReqData)localObject6).closeEyeImage = new YtLivenessNetProtoHelper.ImageInfo(((ByteArrayOutputStream)localObject4).toByteArray(), (float[])localObject3, null);
          localObject1 = YtLivenessNetProtoHelper.makePersonLiveReq((YtLivenessNetProtoHelper.ReflectLiveReqData)localObject6);
          YtLogger.d(TAG, "begin request...uploadsize " + ((String)localObject1).length());
          CommonUtils.benchMarkEnd("reflect_request_s1");
          CommonUtils.benchMarkBegin("reflect_request_s2");
          YtFSM.getInstance().sendNetworkRequest("net_reporting", this.resultUrl, (String)localObject1, null, new YtSDKKitFramework.IYtSDKKitNetResponseParser()
          {
            public void onNetworkResponseEvent(HashMap<String, String> paramAnonymousHashMap, Exception paramAnonymousException)
            {
              AppMethodBeat.i(187199);
              CommonUtils.benchMarkEnd("reflect_request_s2");
              CommonUtils.benchMarkBegin("reflect_request_s3");
              YtLogger.i(NetLivenessReqResultState.TAG, "handle reflection response");
              NetLivenessReqResultState.access$100(NetLivenessReqResultState.this, paramAnonymousHashMap, paramAnonymousException);
              CommonUtils.benchMarkEnd("reflect_request_s3");
              NetLivenessReqResultState.access$200(NetLivenessReqResultState.this);
              AppMethodBeat.o(187199);
            }
          });
          AppMethodBeat.o(187211);
          return;
        }
        localObject1 = "";
        continue;
        localObject1 = YtLivenessNetProtoHelper.makeReflectLiveReq((YtLivenessNetProtoHelper.ReflectLiveReqData)localObject6);
        continue;
        localObject2 = null;
      }
      catch (Exception localException)
      {
        YtLogger.e(TAG, "reflection request failed" + localException.getLocalizedMessage());
        YtSDKStats.getInstance().reportInfo("reflection request failed: " + localException.getLocalizedMessage());
        YtFSM.getInstance().sendFSMEvent(new HashMap() {});
        AppMethodBeat.o(187211);
        return;
      }
      label986:
      continue;
      label991:
      Object localObject2 = null;
      continue;
      label996:
      localObject2 = null;
      continue;
      label1001:
      localObject2 = null;
      continue;
      label1006:
      int i = 0;
    }
  }
  
  private void onSilentRequest()
  {
    AppMethodBeat.i(187206);
    this.bestImage = ((YuvImage)YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE)).getStateDataBy("best_image"));
    int i = this.bestImage.getWidth();
    int j = this.bestImage.getHeight();
    Object localObject = new ByteArrayOutputStream();
    this.bestImage.compressToJpeg(new Rect(0, 0, i, j), 95, (OutputStream)localObject);
    localObject = ((ByteArrayOutputStream)localObject).toByteArray();
    YtLivenessNetProtoHelper.PictureLiveReqData localPictureLiveReqData = new YtLivenessNetProtoHelper.PictureLiveReqData();
    localPictureLiveReqData.baseInfo = new YtLivenessNetProtoHelper.NetBaseInfoData();
    localPictureLiveReqData.baseInfo.sessionId = UUID.randomUUID().toString();
    localPictureLiveReqData.baseInfo.appId = this.appId;
    localPictureLiveReqData.imageInfo = new YtLivenessNetProtoHelper.ImageInfo((byte[])localObject, null, null);
    localObject = YtLivenessNetProtoHelper.makePictureLiveReq(localPictureLiveReqData);
    YtFSM.getInstance().sendNetworkRequest("net_reporting", this.resultUrl, (String)localObject, null, new YtSDKKitFramework.IYtSDKKitNetResponseParser()
    {
      public void onNetworkResponseEvent(HashMap<String, String> paramAnonymousHashMap, Exception paramAnonymousException)
      {
        AppMethodBeat.i(187193);
        YtLogger.i(NetLivenessReqResultState.TAG, "Parse silent response");
        NetLivenessReqResultState.access$100(NetLivenessReqResultState.this, paramAnonymousHashMap, paramAnonymousException);
        NetLivenessReqResultState.access$200(NetLivenessReqResultState.this);
        AppMethodBeat.o(187193);
      }
    });
    AppMethodBeat.o(187206);
  }
  
  private void parseControlConfig()
  {
    AppMethodBeat.i(187209);
    if (!this.controlConfig.isEmpty())
    {
      String[] arrayOfString1 = this.controlConfig.split("&");
      if (arrayOfString1.length > 0)
      {
        int j = arrayOfString1.length;
        int i = 0;
        while (i < j)
        {
          String[] arrayOfString2 = arrayOfString1[i].split("=");
          if (arrayOfString2.length > 1)
          {
            if ((arrayOfString2[0].equals("need_action_video")) && (arrayOfString2[1].equals("false"))) {
              this.needVideoData = false;
            }
            if (arrayOfString2[0].equals("actref_ux_mode")) {
              this.actRefUXMode = Integer.parseInt(arrayOfString2[1]);
            }
          }
          i += 1;
        }
      }
    }
    AppMethodBeat.o(187209);
  }
  
  public void enter()
  {
    AppMethodBeat.i(187204);
    super.enter();
    YtFSM.getInstance().sendFSMEvent(new HashMap() {});
    switch (13.$SwitchMap$com$tencent$youtu$sdkkitframework$framework$YtSDKKitFramework$YtSDKKitFrameworkWorkMode[YtFSM.getInstance().getWorkMode().ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(187204);
      return;
      onActionRequest();
      AppMethodBeat.o(187204);
      return;
      onReflectRequest();
      AppMethodBeat.o(187204);
      return;
      if (this.actReflectType == 0)
      {
        onActReflectRequest();
        AppMethodBeat.o(187204);
        return;
      }
      onActReflectRequest2();
      AppMethodBeat.o(187204);
      return;
      onLipReadRequest();
    }
  }
  
  public void enterFirst() {}
  
  public void loadStateWith(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(187202);
    super.loadStateWith(paramString, paramJSONObject);
    for (;;)
    {
      try
      {
        this.appId = paramJSONObject.getString("app_id");
        this.resultUrl = paramJSONObject.getString("result_api_url");
        if (this.resultUrl == null)
        {
          YtSDKStats.getInstance().reportError(3145728, "yt_param_error");
          YtLogger.e(TAG, "parse url failed");
          AppMethodBeat.o(187202);
          return;
        }
        if (paramJSONObject.has("secret_key")) {
          this.secretKey = paramJSONObject.getString("secret_key");
        }
        if (paramJSONObject.has("secret_id")) {
          this.secretId = paramJSONObject.getString("secret_id");
        }
        if (paramJSONObject.has("user_id")) {
          this.userId = paramJSONObject.getString("user_id");
        }
        if (paramJSONObject.has("similarity_threshold")) {
          this.simiThreshold = paramJSONObject.getInt("similarity_threshold");
        }
        if (paramJSONObject.has("final_liveness_confidence_threshold"))
        {
          this.finalConfidenceThreshold = paramJSONObject.getInt("final_liveness_confidence_threshold");
          if (!paramJSONObject.has("extra_config")) {
            break label367;
          }
          this.extraConfig = paramJSONObject.getString("extra_config");
          if (paramJSONObject.has("control_config")) {
            this.controlConfig = paramJSONObject.getString("control_config");
          }
          if (paramJSONObject.has("change_point_num")) {
            this.changePointNum = paramJSONObject.getInt("change_point_num");
          }
          if (paramJSONObject.has("manual_trigger")) {
            this.needManualTrigger = paramJSONObject.getBoolean("manual_trigger");
          }
          if (!paramJSONObject.has("request_options")) {
            break;
          }
          paramString = paramJSONObject.getJSONObject("request_options");
          Iterator localIterator = paramString.keys();
          if (!localIterator.hasNext()) {
            break;
          }
          String str1 = (String)localIterator.next();
          String str2 = paramString.getString(str1);
          this.requestOptions.put(str1, str2);
          continue;
        }
        this.finalConfidenceThreshold = 85;
      }
      catch (JSONException paramString)
      {
        YtLogger.e(TAG, "Failed to parse json:" + paramString.getLocalizedMessage());
        AppMethodBeat.o(187202);
        return;
      }
      continue;
      label367:
      this.extraConfig = " version 2";
    }
    if (paramJSONObject.has("backend_proto_type")) {
      this.backendProtoType = paramJSONObject.getInt("backend_proto_type");
    }
    AppMethodBeat.o(187202);
  }
  
  public void unload()
  {
    AppMethodBeat.i(187203);
    super.unload();
    AppMethodBeat.o(187203);
  }
  
  public class ActionReflectReq2
  {
    public ArrayList<NetLivenessReqResultState.FivePoints> five_points;
    public ArrayList<String> images;
    public ActionReflectReq live_req;
    public String session_id;
    public String video;
    
    public ActionReflectReq2() {}
  }
  
  public class FivePoints
  {
    public ArrayList<NetLivenessReqResultState.Pointf> points;
    
    public FivePoints() {}
  }
  
  public class Pointf
  {
    public float x;
    public float y;
    
    public Pointf() {}
  }
  
  public class Version
  {
    public String faction_sdk_version = "";
    public String freflect_sdk_version = "";
    public String ftrack_sdk_version = "";
    public String sdk_version = "";
    
    public Version() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.NetLivenessReqResultState
 * JD-Core Version:    0.7.0.1
 */