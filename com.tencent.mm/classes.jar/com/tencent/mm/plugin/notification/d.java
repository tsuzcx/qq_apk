package com.tencent.mm.plugin.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/notification/NotificationChannelFactory;", "", "()V", "TAG", "", "createLoginChannel", "", "plugin-notification_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d MvM;
  
  static
  {
    AppMethodBeat.i(271948);
    MvM = new d();
    AppMethodBeat.o(271948);
  }
  
  public static void aKX()
  {
    AppMethodBeat.i(271946);
    Log.i("MicroMsg.NotificationChannelFactory", "createLoginChannel");
    try
    {
      if (com.tencent.mm.compatible.util.d.rb(26))
      {
        SharedPreferences localSharedPreferences = b.aQC();
        Context localContext = MMApplicationContext.getContext();
        NotificationManager localNotificationManager = (NotificationManager)localContext.getSystemService(NotificationManager.class);
        NotificationChannel localNotificationChannel = new NotificationChannel("login_channel_id", (CharSequence)localContext.getString(g.b.notification_login_channel_name), 4);
        localNotificationChannel.setDescription(localContext.getString(g.b.notification_login_channel_desc));
        localNotificationChannel.enableLights(true);
        localNotificationChannel.setLightColor(-16711936);
        localNotificationChannel.setVibrationPattern(Util.VIRBRATOR_PATTERN);
        localNotificationChannel.enableVibration(true);
        if (Build.VERSION.SDK_INT >= 29) {
          localNotificationChannel.setAllowBubbles(true);
        }
        localNotificationChannel.setLockscreenVisibility(-1);
        localNotificationChannel.setSound(Settings.System.DEFAULT_NOTIFICATION_URI, Notification.AUDIO_ATTRIBUTES_DEFAULT);
        localNotificationManager.createNotificationChannel(localNotificationChannel);
        localSharedPreferences.edit().putString("login_channel_id", "login_channel_id").commit();
        a.boM("login_channel_id");
        AppMethodBeat.o(271946);
        return;
      }
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.NotificationChannelFactory", "createLoginChannel " + localException.getClass().getSimpleName() + ", " + localException.getMessage());
      AppMethodBeat.o(271946);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.d
 * JD-Core Version:    0.7.0.1
 */