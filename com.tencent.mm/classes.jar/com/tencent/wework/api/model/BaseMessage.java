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
  protected static SessionProvider MLn = null;
  protected Context mContext = null;
  protected String vuG = "";
  
  public static BaseMessage C(Uri paramUri)
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
    catch (Throwable paramUri) {}
    return null;
  }
  
  public static Bundle b(BaseMessage paramBaseMessage)
  {
    if (paramBaseMessage == null) {
      return null;
    }
    Bundle localBundle = new Bundle();
    paramBaseMessage.toBundle(localBundle);
    localBundle.putString("_wwobject_identifier_", paramBaseMessage.getClass().getName());
    return localBundle;
  }
  
  public static BaseMessage bo(Bundle paramBundle)
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
    catch (Throwable paramBundle) {}
    return null;
  }
  
  public final void bbT(String paramString)
  {
    this.vuG = paramString;
  }
  
  public abstract boolean checkArgs();
  
  public abstract void fromBundle(Bundle paramBundle);
  
  public final void setContext(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public abstract void toBundle(Bundle paramBundle);
  
  public void x(Intent paramIntent, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.wework.api.model.BaseMessage
 * JD-Core Version:    0.7.0.1
 */