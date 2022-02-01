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
  public String Mos;
  public String appId;
  public String appName;
  public String jXT;
  public int sdkVer;
  public String transaction;
  
  public boolean checkArgs()
  {
    return true;
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    this.transaction = paramBundle.getString("_wwapi_basereq_transaction");
    this.appId = paramBundle.getString("_wwapi_basereq_openid");
    this.jXT = paramBundle.getString("_wwapi_basereq_agentid");
    this.appName = paramBundle.getString("_wwapi_basereq_appname");
    this.Mos = paramBundle.getString("_wwapi_basereq_appbundle");
    this.sdkVer = paramBundle.getInt("_wwobject_sdkVer", 0);
    if ((Mor != null) && (TextUtils.isEmpty(this.viB))) {
      this.viB = Mor.gae();
    }
  }
  
  public void toBundle(Bundle paramBundle)
  {
    String str = String.valueOf(SystemClock.uptimeMillis());
    this.transaction = str;
    paramBundle.putString("_wwapi_basereq_transaction", str);
    paramBundle.putString("_wwapi_basereq_openid", this.appId);
    paramBundle.putString("_wwapi_basereq_agentid", this.jXT);
    try
    {
      paramBundle.putString("_wwapi_basereq_appbundle", this.mContext.getPackageName());
      paramBundle.putString("_wwapi_basereq_appname", this.mContext.getString(this.mContext.getApplicationInfo().labelRes));
      label75:
      paramBundle.putInt("_wwobject_sdkVer", 2);
      if ((Mor != null) && (TextUtils.isEmpty(this.viB))) {
        this.viB = Mor.gae();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      break label75;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.wework.api.model.WWBaseMessage
 * JD-Core Version:    0.7.0.1
 */