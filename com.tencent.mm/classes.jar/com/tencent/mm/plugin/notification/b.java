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
import com.tencent.mm.model.cn;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.io.File;

public final class b
{
  public static void aQu(String paramString)
  {
    AppMethodBeat.i(271951);
    Log.i("MicroMsg.NewMsgNotificationHelper", "reCreateNewMsgNotificationChannel ringtonePath:%s", new Object[] { Util.nullAs(paramString, "") });
    try
    {
      SharedPreferences localSharedPreferences;
      Context localContext;
      NotificationManager localNotificationManager;
      String str;
      NotificationChannel localNotificationChannel1;
      if (Build.VERSION.SDK_INT >= 26)
      {
        localSharedPreferences = com.tencent.mm.kernel.b.aQC();
        localContext = MMApplicationContext.getContext();
        localNotificationManager = null;
        if (Build.VERSION.SDK_INT >= 23) {
          localNotificationManager = (NotificationManager)localContext.getSystemService(NotificationManager.class);
        }
        NotificationChannel localNotificationChannel2 = localNotificationManager.getNotificationChannel(a.aQB());
        str = "message_channel_" + cn.bDu();
        localNotificationChannel1 = new NotificationChannel(str, localContext.getString(g.b.notification_message_channel_name), localNotificationChannel2.getImportance());
        localNotificationChannel1.setDescription(localContext.getString(g.b.notification_message_channel_desc));
        localNotificationChannel1.enableLights(true);
        localNotificationChannel1.setLightColor(-16711936);
        localNotificationChannel1.setVibrationPattern(Util.VIRBRATOR_PATTERN);
        localNotificationChannel1.enableVibration(localNotificationChannel2.shouldVibrate());
        if (Build.VERSION.SDK_INT >= 29) {
          localNotificationChannel1.setAllowBubbles(localNotificationChannel2.canBubble());
        }
        localNotificationChannel1.setBypassDnd(localNotificationChannel2.canBypassDnd());
        localNotificationChannel1.setLockscreenVisibility(localNotificationChannel2.getLockscreenVisibility());
        localNotificationChannel1.setShowBadge(localNotificationChannel2.canShowBadge());
        if (!Util.isNullOrNil(paramString)) {
          break label267;
        }
        localNotificationChannel1.setSound(Settings.System.DEFAULT_NOTIFICATION_URI, Notification.AUDIO_ATTRIBUTES_DEFAULT);
      }
      for (;;)
      {
        localNotificationManager.deleteNotificationChannel(a.aQB());
        localNotificationManager.createNotificationChannel(localNotificationChannel1);
        localSharedPreferences.edit().putString("message_channel_id", str).commit();
        a.DG(str);
        AppMethodBeat.o(271951);
        return;
        label267:
        paramString = FileProviderHelper.getUriForFile(localContext, u.V(new File(paramString)));
        localContext.grantUriPermission("com.android.systemui", paramString, 1);
        localNotificationChannel1.setSound(paramString, Notification.AUDIO_ATTRIBUTES_DEFAULT);
      }
      return;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.NewMsgNotificationHelper", "reCreateNewMsgNotificationChannel %s, %s", new Object[] { paramString.getClass().getSimpleName(), paramString.getMessage() });
      AppMethodBeat.o(271951);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.b
 * JD-Core Version:    0.7.0.1
 */