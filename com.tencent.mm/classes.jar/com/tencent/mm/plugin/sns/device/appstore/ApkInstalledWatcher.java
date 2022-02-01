package com.tencent.mm.plugin.sns.device.appstore;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

public abstract class ApkInstalledWatcher
  extends BroadcastReceiver
{
  private static String aM(Intent paramIntent)
  {
    try
    {
      paramIntent = paramIntent.getData().getSchemeSpecificPart();
      return paramIntent;
    }
    catch (Throwable paramIntent) {}
    return "";
  }
  
  protected abstract boolean azE(String paramString);
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null) {
      try
      {
        paramContext = paramIntent.getAction();
        if ("android.intent.action.PACKAGE_ADDED".equals(paramContext))
        {
          paramContext = aM(paramIntent);
          if (!TextUtils.isEmpty(paramContext)) {
            azE(paramContext);
          }
        }
        else if ("android.intent.action.PACKAGE_REMOVED".equals(paramContext))
        {
          TextUtils.isEmpty(aM(paramIntent));
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