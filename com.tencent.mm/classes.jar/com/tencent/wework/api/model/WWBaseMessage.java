package com.tencent.wework.api.model;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.wework.api.util.SessionProvider;

public abstract class WWBaseMessage
  extends BaseMessage
{
  public String appId;
  public String nYD;
  
  public boolean checkArgs()
  {
    return true;
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    this.transaction = paramBundle.getString("_wwapi_basereq_transaction");
    this.appId = paramBundle.getString("_wwapi_basereq_openid");
    this.nYD = paramBundle.getString("_wwapi_basereq_agentid");
    this.appName = paramBundle.getString("_wwapi_basereq_appname");
    this.ZYp = paramBundle.getString("_wwapi_basereq_appbundle");
    this.sdkVer = paramBundle.getInt("_wwobject_sdkVer", 0);
    this.ZYq = paramBundle.getString("_wwobject_sdkVername");
    if ((ZYr != null) && (TextUtils.isEmpty(this.EsO))) {
      this.EsO = ZYr.ivn();
    }
  }
  
  public void toBundle(Bundle paramBundle)
  {
    String str = String.valueOf(SystemClock.uptimeMillis());
    this.transaction = str;
    paramBundle.putString("_wwapi_basereq_transaction", str);
    paramBundle.putString("_wwapi_basereq_openid", this.appId);
    paramBundle.putString("_wwapi_basereq_agentid", this.nYD);
    try
    {
      paramBundle.putString("_wwapi_basereq_appbundle", this.mContext.getPackageName());
      paramBundle.putString("_wwapi_basereq_appname", this.mContext.getString(this.mContext.getApplicationInfo().labelRes));
      label75:
      paramBundle.putInt("_wwobject_sdkVer", 4);
      paramBundle.putString("_wwobject_sdkVername", "2.0.11.21");
      if ((ZYr != null) && (TextUtils.isEmpty(this.EsO))) {
        this.EsO = ZYr.ivn();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      break label75;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wework.api.model.WWBaseMessage
 * JD-Core Version:    0.7.0.1
 */