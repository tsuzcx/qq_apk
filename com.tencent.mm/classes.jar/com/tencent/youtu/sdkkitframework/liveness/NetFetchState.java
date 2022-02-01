package com.tencent.youtu.sdkkitframework.liveness;

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
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKKitFrameworkWorkMode;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKPlatformContext;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.GetLiveStyleResult;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleRequester.LiveStyleAndroidData;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleRequester.SeleceData;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleRequester.YTLiveStyleReq;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleResponse;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NetFetchState
  extends YtFSMBaseState
{
  private static final String TAG;
  private String actionSeqData = "";
  private String appId;
  private int backendProtoType = 0;
  private int changePointNum = 2;
  private String configUrl;
  private String controlConfig = "";
  private String extraConfig = "";
  private String localColorData = "";
  private boolean needLocalConfig = false;
  private JSONObject selectData = null;
  
  static
  {
    AppMethodBeat.i(247225);
    TAG = NetFetchState.class.getSimpleName();
    AppMethodBeat.o(247225);
  }
  
  private void onReflectRequest()
  {
    AppMethodBeat.i(247212);
    YTAGReflectLiveCheckInterface.getLiveCheckType(YtFSM.getInstance().getContext().currentAppContext, new YTAGReflectLiveCheckInterface.GetLiveStyleResult()
    {
      public void onFailed(final int paramAnonymousInt, final String paramAnonymousString1, final String paramAnonymousString2)
      {
        AppMethodBeat.i(247177);
        YtLogger.e(NetFetchState.TAG, "network failed " + paramAnonymousString1 + " fix " + paramAnonymousString2);
        YtSDKStats.getInstance().reportError(paramAnonymousInt, paramAnonymousString1);
        YtFSM.getInstance().sendFSMEvent(new HashMap() {});
        AppMethodBeat.o(247177);
      }
      
      public void onSuccess(LiveStyleRequester.YTLiveStyleReq paramAnonymousYTLiveStyleReq, LiveStyleResponse paramAnonymousLiveStyleResponse)
      {
        AppMethodBeat.i(247176);
        NetFetchState.this.stateData.put("select_data", paramAnonymousYTLiveStyleReq.select_data);
        if (((!NetFetchState.this.localColorData.isEmpty()) && (NetFetchState.this.needLocalConfig)) || (NetFetchState.this.configUrl == null))
        {
          YtLogger.i(NetFetchState.TAG, "Use local data");
          NetFetchState.this.stateData.put("color_data", NetFetchState.this.localColorData);
          NetFetchState.this.stateData.put("action_data", NetFetchState.this.actionSeqData);
          YtLogger.d(NetFetchState.TAG, "select data:" + NetFetchState.this.selectData);
          if (NetFetchState.this.selectData != null) {}
          for (;;)
          {
            try
            {
              if (NetFetchState.this.selectData.has("config")) {
                NetFetchState.this.stateData.put("control_config", NetFetchState.this.selectData.getString("config"));
              }
              if (NetFetchState.this.selectData.has("reflect_param")) {
                NetFetchState.this.stateData.put("extra_config", NetFetchState.this.selectData.getString("reflect_param"));
              }
              if (NetFetchState.this.selectData.has("change_point_num")) {
                NetFetchState.this.stateData.put("cp_num", NetFetchState.this.selectData.getString("change_point_num"));
              }
            }
            catch (JSONException paramAnonymousYTLiveStyleReq)
            {
              paramAnonymousYTLiveStyleReq = "Select data parse failed " + paramAnonymousYTLiveStyleReq.getLocalizedMessage();
              YtLogger.e(NetFetchState.TAG, paramAnonymousYTLiveStyleReq);
              YtSDKStats.getInstance().reportInfo(paramAnonymousYTLiveStyleReq);
              continue;
            }
            NetFetchState.this.moveToNextState();
            AppMethodBeat.o(247176);
            return;
            YtLogger.e(NetFetchState.TAG, "select data is null");
            YtSDKStats.getInstance().reportInfo("select data is null");
          }
        }
        if ((NetFetchState.this.backendProtoType != 2) && (YtFSM.getInstance().getWorkMode() == YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_LIPREAD_TYPE))
        {
          paramAnonymousYTLiveStyleReq = new YtLivenessNetProtoHelper.GetFourLiveTypeReqData();
          paramAnonymousYTLiveStyleReq.baseInfo = new YtLivenessNetProtoHelper.NetBaseInfoData();
          paramAnonymousYTLiveStyleReq.baseInfo.appId = NetFetchState.this.appId;
        }
        for (paramAnonymousYTLiveStyleReq = YtLivenessNetProtoHelper.makeGetFourLiveReq(paramAnonymousYTLiveStyleReq);; paramAnonymousYTLiveStyleReq = YtLivenessNetProtoHelper.makeGetLiveTypeReq(paramAnonymousLiveStyleResponse))
        {
          YtLogger.i(NetFetchState.TAG, "Use online data ---> on get config info: ".concat(String.valueOf(paramAnonymousYTLiveStyleReq)));
          YtFSM.getInstance().sendNetworkRequest("net_fetch_data", NetFetchState.this.configUrl, paramAnonymousYTLiveStyleReq, null, new YtSDKKitFramework.IYtSDKKitNetResponseParser()
          {
            public void onNetworkResponseEvent(HashMap<String, String> paramAnonymous2HashMap, final Exception paramAnonymous2Exception)
            {
              int k = 0;
              AppMethodBeat.i(247154);
              Object localObject2;
              if (paramAnonymous2Exception != null)
              {
                YtSDKStats.getInstance().reportError(2097153, paramAnonymous2Exception.getMessage());
                localObject2 = paramAnonymous2Exception.getLocalizedMessage();
                localObject1 = localObject2;
                if (paramAnonymous2HashMap != null)
                {
                  localObject1 = localObject2;
                  if (paramAnonymous2HashMap.containsKey("response")) {
                    localObject1 = (String)paramAnonymous2HashMap.get("response");
                  }
                }
                YtFSM.getInstance().sendFSMEvent(new HashMap() {});
                AppMethodBeat.o(247154);
                return;
              }
              YtLogger.d(NetFetchState.TAG, "response : " + (String)paramAnonymous2HashMap.get("response"));
              j = 1;
              if ((NetFetchState.this.backendProtoType != 2) && (YtFSM.getInstance().getWorkMode() == YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_LIPREAD_TYPE)) {}
              try
              {
                paramAnonymous2Exception = new JSONObject((String)paramAnonymous2HashMap.get("response"));
                if ((!paramAnonymous2Exception.has("errorcode")) || (paramAnonymous2Exception.getInt("errorcode") != 0)) {
                  break label883;
                }
                localObject2 = paramAnonymous2Exception.getString("validate_data");
                if (localObject2 == null) {
                  break label883;
                }
                paramAnonymous2Exception = "";
                i = 0;
              }
              catch (JSONException paramAnonymous2Exception)
              {
                for (;;)
                {
                  label815:
                  int i = j;
                  continue;
                  localObject1 = null;
                  continue;
                  paramAnonymous2Exception = null;
                  continue;
                  i = 1;
                  break label895;
                  i = 1;
                  continue;
                  i += 1;
                }
              }
              if (i < ((String)localObject2).length())
              {
                localObject1 = paramAnonymous2Exception + ((String)localObject2).charAt(i);
                paramAnonymous2Exception = (Exception)localObject1;
                if (i != ((String)localObject2).length() - 1) {
                  paramAnonymous2Exception = (String)localObject1 + ",";
                }
              }
              else
              {
                NetFetchState.this.stateData.put("action_data", paramAnonymous2Exception);
                YtFSM.getInstance().sendFSMEvent(new HashMap() {});
                NetFetchState.this.moveToNextState();
                i = 0;
                for (;;)
                {
                  if (i != 0)
                  {
                    YtLogger.e(NetFetchState.TAG, "parse response failed");
                    YtSDKStats.getInstance().reportError(2097153, "server return failed");
                    localObject1 = "server return failed";
                    paramAnonymous2Exception = (Exception)localObject1;
                    if (paramAnonymous2HashMap != null)
                    {
                      paramAnonymous2Exception = (Exception)localObject1;
                      if (paramAnonymous2HashMap.containsKey("response")) {
                        paramAnonymous2Exception = (String)paramAnonymous2HashMap.get("response");
                      }
                    }
                    YtFSM.getInstance().sendFSMEvent(new HashMap() {});
                  }
                  AppMethodBeat.o(247154);
                  return;
                  try
                  {
                    localObject2 = new JSONObject((String)paramAnonymous2HashMap.get("response"));
                    i = -1;
                    if (((JSONObject)localObject2).has("error_code"))
                    {
                      i = ((JSONObject)localObject2).getInt("error_code");
                      if (i != 0) {
                        break label878;
                      }
                      if (!((JSONObject)localObject2).has("color_data")) {
                        break label873;
                      }
                      paramAnonymous2Exception = ((JSONObject)localObject2).getString("color_data");
                      if (!((JSONObject)localObject2).has("action_data")) {
                        break label867;
                      }
                      localObject1 = ((JSONObject)localObject2).getString("action_data");
                      YtLogger.d(NetFetchState.TAG, "color_data : ".concat(String.valueOf(paramAnonymous2Exception)));
                      NetFetchState.this.stateData.put("color_data", paramAnonymous2Exception);
                      NetFetchState.this.stateData.put("action_data", localObject1);
                      if (!((JSONObject)localObject2).has("select_data")) {
                        break label815;
                      }
                      if (((JSONObject)localObject2).getJSONObject("select_data").has("config")) {
                        NetFetchState.this.stateData.put("control_config", ((JSONObject)localObject2).getJSONObject("select_data").getString("config"));
                      }
                      if (((JSONObject)localObject2).getJSONObject("select_data").has("reflect_param")) {
                        NetFetchState.this.stateData.put("extra_config", ((JSONObject)localObject2).getJSONObject("select_data").getString("reflect_param"));
                      }
                      if (((JSONObject)localObject2).getJSONObject("select_data").has("change_point_num")) {
                        NetFetchState.this.stateData.put("cp_num", ((JSONObject)localObject2).getJSONObject("select_data").getString("change_point_num"));
                      }
                    }
                    for (;;)
                    {
                      if (((JSONObject)localObject2).has("video_config"))
                      {
                        paramAnonymous2Exception = ((JSONObject)localObject2).getJSONObject("video_config");
                        if (paramAnonymous2Exception.has("video_bitrate")) {
                          NetFetchState.this.stateData.put("video_bitrate", Integer.valueOf(paramAnonymous2Exception.getInt("video_bitrate")));
                        }
                        if (paramAnonymous2Exception.has("video_framerate")) {
                          NetFetchState.this.stateData.put("video_framerate", Integer.valueOf(paramAnonymous2Exception.getInt("video_framerate")));
                        }
                        if (paramAnonymous2Exception.has("video_iframeinterval")) {
                          NetFetchState.this.stateData.put("video_iframeinterval", Integer.valueOf(paramAnonymous2Exception.getInt("video_iframeinterval")));
                        }
                      }
                      NetFetchState.this.moveToNextState();
                      i = k;
                      break label895;
                      if (!((JSONObject)localObject2).has("errorcode")) {
                        break;
                      }
                      i = ((JSONObject)localObject2).getInt("errorcode");
                      break;
                      YtLogger.e(NetFetchState.TAG, "select_data not found or select_data.config not found");
                    }
                  }
                  catch (JSONException paramAnonymous2Exception)
                  {
                    YtLogger.e(NetFetchState.TAG, "parse response json other object failed:" + paramAnonymous2Exception.getLocalizedMessage());
                    i = j;
                  }
                }
              }
            }
          });
          AppMethodBeat.o(247176);
          return;
          paramAnonymousLiveStyleResponse = new YtLivenessNetProtoHelper.GetLiveTypeReqData();
          paramAnonymousLiveStyleResponse.baseInfo = new YtLivenessNetProtoHelper.NetBaseInfoData();
          paramAnonymousLiveStyleResponse.baseInfo.appId = NetFetchState.this.appId;
          paramAnonymousLiveStyleResponse.baseInfo.businessId = "wx_default";
          paramAnonymousLiveStyleResponse.baseInfo.lux = paramAnonymousYTLiveStyleReq.select_data.android_data.lux;
          paramAnonymousLiveStyleResponse.reflectConfig = NetFetchState.this.extraConfig;
          paramAnonymousLiveStyleResponse.controlConfig = NetFetchState.this.controlConfig;
          paramAnonymousLiveStyleResponse.colorNum = NetFetchState.this.changePointNum;
        }
      }
    });
    AppMethodBeat.o(247212);
  }
  
  public void enter()
  {
    AppMethodBeat.i(247204);
    super.enter();
    YtFSM.getInstance().sendFSMEvent(new HashMap() {});
    switch (4.$SwitchMap$com$tencent$youtu$sdkkitframework$framework$YtSDKKitFramework$YtSDKKitFrameworkWorkMode[YtFSM.getInstance().getWorkMode().ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(247204);
      return;
      AppMethodBeat.o(247204);
      return;
      onReflectRequest();
    }
  }
  
  public void enterFirst() {}
  
  public void exit()
  {
    AppMethodBeat.i(247208);
    super.exit();
    AppMethodBeat.o(247208);
  }
  
  public void loadStateWith(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(247200);
    super.loadStateWith(paramString, paramJSONObject);
    label366:
    for (;;)
    {
      try
      {
        this.appId = paramJSONObject.getString("app_id");
        if (this.appId == null) {
          YtSDKStats.getInstance().reportError(3145728, "yt_param_error");
        }
        if (paramJSONObject.has("config_api_url")) {
          this.configUrl = paramJSONObject.getString("config_api_url");
        }
        if (paramJSONObject.has("color_data")) {
          this.localColorData = paramJSONObject.getString("color_data");
        }
        if (paramJSONObject.has("local_config_flag")) {
          this.needLocalConfig = paramJSONObject.getBoolean("local_config_flag");
        }
        int i;
        if (paramJSONObject.has("action_default_seq"))
        {
          paramString = paramJSONObject.getJSONArray("action_default_seq");
          i = 0;
          if (i < paramString.length())
          {
            this.actionSeqData += paramString.getString(i);
            if (i >= paramString.length() - 1) {
              break label366;
            }
            this.actionSeqData += ",";
            break label366;
          }
        }
        else
        {
          this.actionSeqData = "0";
        }
        if (paramJSONObject.has("extra_config"))
        {
          this.extraConfig = paramJSONObject.getString("extra_config");
          if (paramJSONObject.has("control_config")) {
            this.controlConfig = paramJSONObject.getString("control_config");
          }
          if (paramJSONObject.has("change_point_num")) {
            this.changePointNum = paramJSONObject.getInt("change_point_num");
          }
          if (paramJSONObject.has("select_data")) {
            this.selectData = paramJSONObject.getJSONObject("select_data");
          }
          if (paramJSONObject.has("backend_proto_type")) {
            this.backendProtoType = paramJSONObject.getInt("backend_proto_type");
          }
          if (paramJSONObject.has("net_request_timeout_ms")) {
            YtSDKKitFramework.getInstance().setNetworkRequestTimeoutMS(paramJSONObject.getInt("net_request_timeout_ms"));
          }
          AppMethodBeat.o(247200);
          return;
        }
        this.extraConfig = " version 2";
        continue;
        i += 1;
      }
      catch (JSONException paramString)
      {
        YtLogger.e(TAG, "Failed to parse json:" + paramString.getLocalizedMessage());
        AppMethodBeat.o(247200);
        return;
      }
    }
  }
  
  public void moveToNextState()
  {
    AppMethodBeat.i(247210);
    super.moveToNextState();
    for (;;)
    {
      try
      {
        switch (4.$SwitchMap$com$tencent$youtu$sdkkitframework$framework$YtSDKKitFramework$YtSDKKitFrameworkWorkMode[YtFSM.getInstance().getWorkMode().ordinal()])
        {
        case 2: 
          final String str = "Unknown work mode " + YtFSM.getInstance().getWorkMode();
          YtSDKStats.getInstance().reportError(4194304, str);
          YtFSM.getInstance().sendFSMEvent(new HashMap() {});
          AppMethodBeat.o(247210);
          return;
        }
      }
      catch (Exception localException)
      {
        YtLogger.e(TAG, "move to next stat failed " + localException.getLocalizedMessage());
        AppMethodBeat.o(247210);
        return;
      }
      YtFSM.getInstance().transitNextRound(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE));
      AppMethodBeat.o(247210);
      return;
    }
  }
  
  public void reset()
  {
    AppMethodBeat.i(247206);
    super.reset();
    AppMethodBeat.o(247206);
  }
  
  public void unload()
  {
    AppMethodBeat.i(247202);
    super.unload();
    AppMethodBeat.o(247202);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.NetFetchState
 * JD-Core Version:    0.7.0.1
 */