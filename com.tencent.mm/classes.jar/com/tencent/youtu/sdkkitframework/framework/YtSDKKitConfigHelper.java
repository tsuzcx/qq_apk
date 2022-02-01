package com.tencent.youtu.sdkkitframework.framework;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.common.YtSDKStats;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class YtSDKKitConfigHelper
{
  private static final HashMap<YtSDKKitFramework.YtSDKKitFrameworkWorkMode, String> SDK_SETTINGS;
  private static final String TAG;
  private static final HashMap<YtSDKKitFramework.YtSDKKitFrameworkWorkMode, String> UI_SETTINGS;
  
  static
  {
    AppMethodBeat.i(218126);
    TAG = YtSDKKitConfigHelper.class.getSimpleName();
    SDK_SETTINGS = new HashMap() {};
    UI_SETTINGS = new HashMap() {};
    AppMethodBeat.o(218126);
  }
  
  public static String getConfigStringBy(JSONObject paramJSONObject, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(218122);
    HashMap localHashMap = null;
    try
    {
      paramJSONObject = paramJSONObject.getString(paramString);
      if ((paramBoolean) && ((paramJSONObject == null) || (paramJSONObject.equals(""))))
      {
        YtLogger.e(TAG, "Parse json object failed " + paramString + "参数解析失败, 不存在或者不能为空");
        YtSDKStats.getInstance().reportError(3145729, "msg_param_error");
        localHashMap = new HashMap();
        localHashMap.put("process_action", "failed");
        localHashMap.put("error_code", Integer.valueOf(3145729));
        localHashMap.put("message", CommonUtils.makeMessageJson(3145729, "msg_param_error", paramString + "参数解析失败, 不存在或者不能为空"));
        YtFSM.getInstance().sendFSMEvent(localHashMap);
      }
      AppMethodBeat.o(218122);
      return paramJSONObject;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        YtLogger.e(TAG, "Parse json object failed " + paramJSONObject.getLocalizedMessage());
        paramJSONObject = localHashMap;
      }
    }
  }
  
  public static ArrayList<String> getPipleStateNames(YtSDKKitFramework.YtSDKKitFrameworkWorkMode paramYtSDKKitFrameworkWorkMode)
  {
    AppMethodBeat.i(218114);
    Object localObject = null;
    switch (10.$SwitchMap$com$tencent$youtu$sdkkitframework$framework$YtSDKKitFramework$YtSDKKitFrameworkWorkMode[paramYtSDKKitFrameworkWorkMode.ordinal()])
    {
    default: 
      paramYtSDKKitFrameworkWorkMode = localObject;
    }
    for (;;)
    {
      AppMethodBeat.o(218114);
      return paramYtSDKKitFrameworkWorkMode;
      paramYtSDKKitFrameworkWorkMode = new ArrayList() {};
      continue;
      paramYtSDKKitFrameworkWorkMode = new ArrayList() {};
      continue;
      paramYtSDKKitFrameworkWorkMode = new ArrayList() {};
      continue;
      paramYtSDKKitFrameworkWorkMode = new ArrayList() {};
      continue;
      paramYtSDKKitFrameworkWorkMode = new ArrayList() {};
      continue;
      paramYtSDKKitFrameworkWorkMode = new ArrayList() {};
      continue;
      paramYtSDKKitFrameworkWorkMode = new ArrayList() {};
    }
  }
  
  public static JSONObject getSDKConfig(YtSDKKitFramework.YtSDKKitFrameworkWorkMode paramYtSDKKitFrameworkWorkMode, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(218085);
    try
    {
      paramYtSDKKitFrameworkWorkMode = paramJSONObject.getJSONObject((String)SDK_SETTINGS.get(paramYtSDKKitFrameworkWorkMode));
      AppMethodBeat.o(218085);
      return paramYtSDKKitFrameworkWorkMode;
    }
    catch (JSONException paramYtSDKKitFrameworkWorkMode)
    {
      for (;;)
      {
        YtLogger.e(TAG, paramYtSDKKitFrameworkWorkMode.getMessage());
        paramYtSDKKitFrameworkWorkMode = null;
      }
    }
  }
  
  public static JSONObject getUIConfig(YtSDKKitFramework.YtSDKKitFrameworkWorkMode paramYtSDKKitFrameworkWorkMode, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(218106);
    try
    {
      paramYtSDKKitFrameworkWorkMode = paramJSONObject.getJSONObject((String)UI_SETTINGS.get(paramYtSDKKitFrameworkWorkMode));
      AppMethodBeat.o(218106);
      return paramYtSDKKitFrameworkWorkMode;
    }
    catch (JSONException paramYtSDKKitFrameworkWorkMode)
    {
      for (;;)
      {
        YtLogger.e(TAG, paramYtSDKKitFrameworkWorkMode.getMessage());
        paramYtSDKKitFrameworkWorkMode = null;
      }
    }
  }
  
  public static void setSDKConfig(YtSDKKitFramework.YtSDKKitFrameworkWorkMode paramYtSDKKitFrameworkWorkMode, JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    AppMethodBeat.i(218090);
    try
    {
      paramJSONObject1.put((String)SDK_SETTINGS.get(paramYtSDKKitFrameworkWorkMode), paramJSONObject2);
      AppMethodBeat.o(218090);
      return;
    }
    catch (JSONException paramYtSDKKitFrameworkWorkMode)
    {
      YtLogger.e(TAG, paramYtSDKKitFrameworkWorkMode.getMessage());
      AppMethodBeat.o(218090);
    }
  }
  
  public static void setUIConfig(YtSDKKitFramework.YtSDKKitFrameworkWorkMode paramYtSDKKitFrameworkWorkMode, JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    AppMethodBeat.i(218098);
    try
    {
      paramJSONObject1.put((String)UI_SETTINGS.get(paramYtSDKKitFrameworkWorkMode), paramJSONObject2);
      AppMethodBeat.o(218098);
      return;
    }
    catch (JSONException paramYtSDKKitFrameworkWorkMode)
    {
      YtLogger.e(TAG, paramYtSDKKitFrameworkWorkMode.getMessage());
      AppMethodBeat.o(218098);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.framework.YtSDKKitConfigHelper
 * JD-Core Version:    0.7.0.1
 */