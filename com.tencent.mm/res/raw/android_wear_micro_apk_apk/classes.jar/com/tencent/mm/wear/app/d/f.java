package com.tencent.mm.wear.app.d;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.app.at;

public final class f
{
  private static boolean agO = false;
  
  public static at i(Context paramContext, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 26) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (!agO))
      {
        agO = true;
        NotificationManager localNotificationManager = (NotificationManager)paramContext.getSystemService(NotificationManager.class);
        NotificationChannel localNotificationChannel = new NotificationChannel("message_channel_id", paramContext.getString(2131165246), 4);
        localNotificationChannel.enableLights(true);
        localNotificationChannel.setLightColor(-16711936);
        localNotificationChannel.enableVibration(true);
        localNotificationChannel.setVibrationPattern(new long[] { 0L, 150L, 100L, 400L });
        localNotificationManager.createNotificationChannel(localNotificationChannel);
      }
      return new at(paramContext, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.d.f
 * JD-Core Version:    0.7.0.1
 */