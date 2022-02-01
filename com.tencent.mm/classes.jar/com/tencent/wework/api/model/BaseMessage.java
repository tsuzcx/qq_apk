package com.tencent.wework.api.model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.wework.api.util.ReflecterHelper;
import com.tencent.wework.api.util.SessionProvider;

public abstract class BaseMessage
{
  protected static SessionProvider aicS = null;
  protected String Klu = "";
  public String aicQ;
  public String aicR;
  protected String aicT;
  public String appName;
  protected Context mContext = null;
  public int sdkVer;
  public String transaction;
  
  public static Bundle a(BaseMessage paramBaseMessage)
  {
    if (paramBaseMessage == null) {
      return null;
    }
    Bundle localBundle = new Bundle();
    paramBaseMessage.toBundle(localBundle);
    localBundle.putString("_wwobject_identifier_", paramBaseMessage.getClass().getName());
    return localBundle;
  }
  
  public static BaseMessage ch(Bundle paramBundle)
  {
    try
    {
      Object localObject = paramBundle.getString("_wwobject_identifier_");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = (BaseMessage)ReflecterHelper.newInstance((String)localObject);
        ((BaseMessage)localObject).fromBundle(paramBundle);
        return localObject;
      }
    }
    finally {}
    return null;
  }
  
  public static BaseMessage w(Uri paramUri)
  {
    try
    {
      paramUri = paramUri.getQueryParameter("wwoid");
      if (!TextUtils.isEmpty(paramUri))
      {
        paramUri = (BaseMessage)ReflecterHelper.newInstance(paramUri);
        return paramUri;
      }
    }
    finally {}
    return null;
  }
  
  public final void bGX(String paramString)
  {
    this.Klu = paramString;
  }
  
  public void bGY(String paramString)
  {
    this.aicT = paramString;
  }
  
  public abstract boolean checkArgs();
  
  public abstract void fromBundle(Bundle paramBundle);
  
  public void setContext(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public abstract void toBundle(Bundle paramBundle);
  
  public void w(Intent paramIntent, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wework.api.model.BaseMessage
 * JD-Core Version:    0.7.0.1
 */