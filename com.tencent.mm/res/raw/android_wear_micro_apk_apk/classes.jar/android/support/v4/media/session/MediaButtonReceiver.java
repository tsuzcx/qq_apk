package android.support.v4.media.session;

import android.content.BroadcastReceiver;
import android.content.BroadcastReceiver.PendingResult;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build.VERSION;
import android.support.v4.media.MediaBrowserCompat;
import android.util.Log;
import java.util.List;

public class MediaButtonReceiver
  extends BroadcastReceiver
{
  private static ComponentName d(Context paramContext, String paramString)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    Intent localIntent = new Intent(paramString);
    localIntent.setPackage(paramContext.getPackageName());
    paramContext = localPackageManager.queryIntentServices(localIntent, 0);
    if (paramContext.size() == 1)
    {
      paramContext = (ResolveInfo)paramContext.get(0);
      return new ComponentName(paramContext.serviceInfo.packageName, paramContext.serviceInfo.name);
    }
    if (paramContext.isEmpty()) {
      return null;
    }
    throw new IllegalStateException("Expected 1 service that handles " + paramString + ", found " + paramContext.size());
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (!"android.intent.action.MEDIA_BUTTON".equals(paramIntent.getAction())) || (!paramIntent.hasExtra("android.intent.extra.KEY_EVENT")))
    {
      Log.d("MediaButtonReceiver", "Ignore unsupported intent: ".concat(String.valueOf(paramIntent)));
      return;
    }
    ComponentName localComponentName = d(paramContext, "android.intent.action.MEDIA_BUTTON");
    if (localComponentName != null)
    {
      paramIntent.setComponent(localComponentName);
      if (Build.VERSION.SDK_INT >= 26)
      {
        paramContext.startForegroundService(paramIntent);
        return;
      }
      paramContext.startService(paramIntent);
      return;
    }
    localComponentName = d(paramContext, "android.media.browse.MediaBrowserService");
    if (localComponentName != null)
    {
      BroadcastReceiver.PendingResult localPendingResult = goAsync();
      paramContext = paramContext.getApplicationContext();
      paramIntent = new g(paramContext, paramIntent, localPendingResult);
      paramContext = new MediaBrowserCompat(paramContext, localComponentName, paramIntent);
      paramIntent.a(paramContext);
      paramContext.connect();
      return;
    }
    throw new IllegalStateException("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or implements a media browser service.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.session.MediaButtonReceiver
 * JD-Core Version:    0.7.0.1
 */