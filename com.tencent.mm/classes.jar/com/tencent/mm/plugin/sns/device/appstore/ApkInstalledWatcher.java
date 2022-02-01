package com.tencent.mm.plugin.sns.device.appstore;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

public abstract class ApkInstalledWatcher
  extends BroadcastReceiver
{
  private static String bw(Intent paramIntent)
  {
    try
    {
      paramIntent = paramIntent.getData().getSchemeSpecificPart();
      return paramIntent;
    }
    finally {}
    return "";
  }
  
  protected abstract boolean aXI(String paramString);
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null) {
      try
      {
        paramContext = paramIntent.getAction();
        if ("android.intent.action.PACKAGE_ADDED".equals(paramContext))
        {
          paramContext = bw(paramIntent);
          if (!TextUtils.isEmpty(paramContext)) {
            aXI(paramContext);
          }
        }
        else if ("android.intent.action.PACKAGE_REMOVED".equals(paramContext))
        {
          TextUtils.isEmpty(bw(paramIntent));
          return;
        }
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.device.appstore.ApkInstalledWatcher
 * JD-Core Version:    0.7.0.1
 */