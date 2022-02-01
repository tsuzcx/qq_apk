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
  public String aicE;
  protected boolean aicU;
  public String appId;
  public String qYG;
  
  public boolean checkArgs()
  {
    return true;
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    this.transaction = paramBundle.getString("_wwapi_basereq_transaction");
    this.appId = paramBundle.getString("_wwapi_basereq_openid");
    this.qYG = paramBundle.getString("_wwapi_basereq_agentid");
    this.aicE = paramBundle.getString("_schema");
    this.appName = paramBundle.getString("_wwapi_basereq_appname");
    this.aicQ = paramBundle.getString("_wwapi_basereq_appbundle");
    this.sdkVer = paramBundle.getInt("_wwobject_sdkVer", 0);
    this.aicR = paramBundle.getString("_wwobject_sdkVername");
    this.aicU = paramBundle.getBoolean("needUpdateSession");
    if ((aicS != null) && (TextUtils.isEmpty(this.Klu))) {
      this.Klu = aicS.keJ();
    }
  }
  
  public void toBundle(Bundle paramBundle)
  {
    String str = String.valueOf(SystemClock.uptimeMillis());
    this.transaction = str;
    paramBundle.putString("_wwapi_basereq_transaction", str);
    paramBundle.putString("_wwapi_basereq_openid", this.appId);
    paramBundle.putString("_wwapi_basereq_agentid", this.qYG);
    paramBundle.putString("_schema", this.aicE);
    try
    {
      paramBundle.putString("_wwapi_basereq_appbundle", this.mContext.getPackageName());
      paramBundle.putString("_wwapi_basereq_appname", this.mContext.getString(this.mContext.getApplicationInfo().labelRes));
      label85:
      paramBundle.putInt("_wwobject_sdkVer", 4);
      paramBundle.putString("_wwobject_sdkVername", "2.0.12.7");
      paramBundle.putBoolean("needUpdateSession", this.aicU);
      if ((aicS != null) && (TextUtils.isEmpty(this.Klu))) {
        this.Klu = aicS.keJ();
      }
      return;
    }
    finally
    {
      break label85;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wework.api.model.WWBaseMessage
 * JD-Core Version:    0.7.0.1
 */