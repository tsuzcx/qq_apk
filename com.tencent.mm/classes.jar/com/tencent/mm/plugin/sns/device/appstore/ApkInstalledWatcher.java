package com.tencent.mm.plugin.sns.device.appstore;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

public abstract class ApkInstalledWatcher
  extends BroadcastReceiver
{
  private static String aG(Intent paramIntent)
  {
    try
    {
      paramIntent = paramIntent.getData().getSchemeSpecificPart();
      return paramIntent;
    }
    catch (Throwable paramIntent) {}
    return "";
  }
  
  protected abstract boolean ati(String paramString);
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null) {
      try
      {
        paramContext = paramIntent.getAction();
        if ("android.intent.action.PACKAGE_ADDED".equals(paramContext))
        {
          paramContext = aG(paramIntent);
          if (!TextUtils.isEmpty(paramContext)) {
            ati(paramContext);
          }
        }
        else if ("android.intent.action.PACKAGE_REMOVED".equals(paramContext))
        {
          TextUtils.isEmpty(aG(paramIntent));
          return;
        }
      }
      catch (Throwable paramContext) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.device.appstore.ApkInstalledWatcher
 * JD-Core Version:    0.7.0.1
 */