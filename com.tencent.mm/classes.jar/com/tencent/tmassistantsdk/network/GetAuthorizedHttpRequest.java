package com.tencent.tmassistantsdk.network;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.tmassistantsdk.openSDK.opensdktomsdk.TMOpenSDKAuthorizedInfo;
import com.tencent.tmassistantsdk.openSDK.opensdktomsdk.data.ActionButton;
import com.tencent.tmassistantsdk.openSDK.opensdktomsdk.data.AuthorizedResult;
import com.tencent.tmassistantsdk.openSDK.opensdktomsdk.data.TipsInfo;
import com.tencent.tmassistantsdk.util.TMLog;
import java.net.URLEncoder;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GetAuthorizedHttpRequest
  extends GetHttpRequest
{
  protected static final String TAG = "GetAuthorizedHttpRequest";
  protected IGetAuthorizedHttpRequestListenner mGetAuthorizedListener = null;
  
  private String authorizedInfoToString(TMOpenSDKAuthorizedInfo paramTMOpenSDKAuthorizedInfo)
  {
    String str = "" + "?appId=" + URLEncoder.encode(paramTMOpenSDKAuthorizedInfo.appId);
    str = str + "&userId=" + URLEncoder.encode(paramTMOpenSDKAuthorizedInfo.userId);
    str = str + "&userIdType=" + URLEncoder.encode(paramTMOpenSDKAuthorizedInfo.userIdType);
    str = str + "&identityInfo=" + URLEncoder.encode(paramTMOpenSDKAuthorizedInfo.identityInfo);
    str = str + "&identityType=" + URLEncoder.encode(paramTMOpenSDKAuthorizedInfo.identityType);
    str = str + "&gamePackageName=" + URLEncoder.encode(paramTMOpenSDKAuthorizedInfo.gamePackageName);
    str = str + "&gameVersionCode=" + URLEncoder.encode(paramTMOpenSDKAuthorizedInfo.gameVersionCode);
    str = str + "&gameChannelId=" + URLEncoder.encode(paramTMOpenSDKAuthorizedInfo.gameChannelId);
    str = str + "&actionFlag=" + URLEncoder.encode(paramTMOpenSDKAuthorizedInfo.actionFlag);
    str = str + "&verifyType=" + URLEncoder.encode(paramTMOpenSDKAuthorizedInfo.verifyType);
    str = str + "&via=" + URLEncoder.encode(paramTMOpenSDKAuthorizedInfo.via);
    return str + "&actionType=" + paramTMOpenSDKAuthorizedInfo.actionType;
  }
  
  private AuthorizedResult jsonObjectToRespData(JSONObject paramJSONObject)
  {
    AuthorizedResult localAuthorizedResult = new AuthorizedResult();
    localAuthorizedResult.hasAuthoried = paramJSONObject.getInt("hasAuthoried");
    localAuthorizedResult.errorCode = paramJSONObject.getInt("errorCode");
    localAuthorizedResult.downloadUrl = paramJSONObject.getString("downloadUrl");
    localAuthorizedResult.versionCode = paramJSONObject.getInt("versionCode");
    Object localObject = paramJSONObject.getJSONObject("tipsInfo");
    JSONArray localJSONArray = null;
    paramJSONObject = localJSONArray;
    if (localObject != null)
    {
      paramJSONObject = localJSONArray;
      if (((JSONObject)localObject).length() > 0)
      {
        paramJSONObject = new TipsInfo();
        paramJSONObject.title = ((JSONObject)localObject).getString("title");
        paramJSONObject.content = ((JSONObject)localObject).getString("content");
        localJSONArray = ((JSONObject)localObject).getJSONArray("actionButton");
        localObject = new ArrayList();
        if ((localJSONArray != null) && (localJSONArray.length() > 0))
        {
          int i = 0;
          while (i < localJSONArray.length())
          {
            ActionButton localActionButton = new ActionButton();
            localActionButton.textInstalled = localJSONArray.getJSONObject(i).getString("textInstalled");
            localActionButton.textUninstalled = localJSONArray.getJSONObject(i).getString("textUninstalled");
            localActionButton.jumpType = localJSONArray.getJSONObject(i).getInt("jumpType");
            localActionButton.jumpUrl = localJSONArray.getJSONObject(i).getString("jumpUrl");
            ((ArrayList)localObject).add(localActionButton);
            i += 1;
          }
        }
        paramJSONObject.actionButton = ((ArrayList)localObject);
      }
    }
    localAuthorizedResult.tipsInfo = paramJSONObject;
    TMLog.i("GetAuthorizedHttpRequest", "dataInfo :" + localAuthorizedResult.toString());
    return localAuthorizedResult;
  }
  
  protected void onFinished(JSONObject paramJSONObject, int paramInt)
  {
    if (this.mGetAuthorizedListener == null) {
      TMLog.i("GetAuthorizedHttpRequest", "mGetAuthorizedListener is null !");
    }
    for (;;)
    {
      return;
      if ((paramInt == 0) && (paramJSONObject != null)) {
        try
        {
          paramJSONObject = jsonObjectToRespData(paramJSONObject);
          if (paramJSONObject != null)
          {
            this.mGetAuthorizedListener.onGetAuthorizedRequestFinished(paramJSONObject, 0);
            return;
          }
        }
        catch (JSONException paramJSONObject)
        {
          this.mGetAuthorizedListener.onGetAuthorizedRequestFinished(null, 704);
          y.printErrStackTrace("GetAuthorizedHttpRequest", paramJSONObject, "", new Object[0]);
          return;
        }
      }
    }
    this.mGetAuthorizedListener.onGetAuthorizedRequestFinished(null, paramInt);
  }
  
  public void sendRequest(TMOpenSDKAuthorizedInfo paramTMOpenSDKAuthorizedInfo)
  {
    if (paramTMOpenSDKAuthorizedInfo != null) {
      super.sendData(authorizedInfoToString(paramTMOpenSDKAuthorizedInfo));
    }
  }
  
  public void setListenner(IGetAuthorizedHttpRequestListenner paramIGetAuthorizedHttpRequestListenner)
  {
    this.mGetAuthorizedListener = paramIGetAuthorizedHttpRequestListenner;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tmassistantsdk.network.GetAuthorizedHttpRequest
 * JD-Core Version:    0.7.0.1
 */