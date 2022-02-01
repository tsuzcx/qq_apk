package com.tencent.mm.plugin.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.aq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.List;

public class PluginNotification
  extends f
  implements com.tencent.mm.plugin.notification.b.a
{
  private aq uhd;
  
  public static void createActiveTimeNotification()
  {
    AppMethodBeat.i(149378);
    if (d.lf(26))
    {
      Context localContext = aj.getContext();
      NotificationManager localNotificationManager = (NotificationManager)localContext.getSystemService(NotificationManager.class);
      if (localNotificationManager.getNotificationChannel("message_dnd_mode_channel_id") == null)
      {
        NotificationChannel localNotificationChannel = new NotificationChannel("message_dnd_mode_channel_id", localContext.getString(2131761700), 4);
        localNotificationChannel.setDescription(localContext.getString(2131761699));
        localNotificationChannel.enableLights(true);
        localNotificationChannel.setLightColor(-16711936);
        localNotificationChannel.enableVibration(false);
        localNotificationChannel.setSound(null, Notification.AUDIO_ATTRIBUTES_DEFAULT);
        localNotificationManager.createNotificationChannel(localNotificationChannel);
      }
    }
    AppMethodBeat.o(149378);
  }
  
  private static void createNotificationChannel()
  {
    AppMethodBeat.i(149375);
    Context localContext;
    NotificationManager localNotificationManager;
    Object localObject;
    NotificationChannel localNotificationChannel;
    if (d.lf(26))
    {
      localContext = aj.getContext();
      localNotificationManager = (NotificationManager)localContext.getSystemService(NotificationManager.class);
      localObject = com.tencent.mm.kernel.a.Yf();
      boolean bool1 = ((SharedPreferences)localObject).getBoolean("settings_sound", true);
      boolean bool2 = ((SharedPreferences)localObject).getBoolean("settings_shake", true);
      deleteNoWeChatSetNotification(localNotificationManager);
      deleteNoNumberNotification(localNotificationManager, com.tencent.mm.br.a.Ye(), "message_channel");
      ad.i("MicroMsg.PluginNotification", "isEnableMsgNotification:%s isSysEnableMsgNotification:%s sound:%s vibration:%s", new Object[] { Boolean.valueOf(com.tencent.mm.m.a.Yi()), Boolean.valueOf(com.tencent.mm.m.a.Yj()), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      boolean bool3 = b.b(localContext, localNotificationManager, bool2, bool1, (SharedPreferences)localObject);
      boolean bool4 = b.a(localContext, localNotificationManager, bool2, bool1, (SharedPreferences)localObject);
      if ((!bool3) && (!bool4))
      {
        localNotificationChannel = new NotificationChannel(com.tencent.mm.br.a.Ye(), localContext.getString(2131761698), 4);
        localNotificationChannel.setDescription(localContext.getString(2131761697));
        localNotificationChannel.enableLights(true);
        localNotificationChannel.setLightColor(-16711936);
        localNotificationChannel.setVibrationPattern(bt.hWP);
        localNotificationChannel.enableVibration(bool2);
        if (!bool1) {
          break label523;
        }
        String str = ((SharedPreferences)localObject).getString("settings.ringtone", com.tencent.mm.m.a.fHc);
        if (b.ajz(str)) {
          localNotificationChannel.setSound(Uri.parse(str), Notification.AUDIO_ATTRIBUTES_DEFAULT);
        }
        ((SharedPreferences)localObject).edit().putString("message_channel_id", com.tencent.mm.br.a.Ye()).commit();
        localNotificationManager.createNotificationChannel(localNotificationChannel);
      }
      localObject = new NotificationChannel("reminder_channel_id", localContext.getString(2131761709), 2);
      ((NotificationChannel)localObject).setDescription(localContext.getString(2131761708));
      localNotificationManager.createNotificationChannel((NotificationChannel)localObject);
      if (!com.tencent.mm.m.a.Yz())
      {
        localObject = new NotificationChannel("message_dnd_mode_channel_id", localContext.getString(2131761700), 4);
        ((NotificationChannel)localObject).setDescription(localContext.getString(2131761699));
        ((NotificationChannel)localObject).enableLights(true);
        ((NotificationChannel)localObject).setLightColor(-16711936);
        ((NotificationChannel)localObject).enableVibration(false);
        ((NotificationChannel)localObject).setSound(null, Notification.AUDIO_ATTRIBUTES_DEFAULT);
        localNotificationManager.createNotificationChannel((NotificationChannel)localObject);
      }
      if ((!d.lh(28)) && (!Build.VERSION.CODENAME.equals("Q"))) {
        break label535;
      }
    }
    label523:
    label535:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localNotificationManager.deleteNotificationChannel("voip_channel_new_id");
        localObject = new NotificationChannel("voip_notify_channel_new_id", localContext.getString(2131761731), 4);
        ((NotificationChannel)localObject).setDescription(localContext.getString(2131761730));
        ((NotificationChannel)localObject).enableLights(true);
        ((NotificationChannel)localObject).setLightColor(-16711936);
        ((NotificationChannel)localObject).enableVibration(true);
        ((NotificationChannel)localObject).setLockscreenVisibility(0);
        ((NotificationChannel)localObject).setSound(Uri.parse("android.resource://" + aj.getContext().getPackageName() + "/raw/phonering"), null);
        localNotificationManager.createNotificationChannel((NotificationChannel)localObject);
      }
      AppMethodBeat.o(149375);
      return;
      localNotificationChannel.setSound(null, Notification.AUDIO_ATTRIBUTES_DEFAULT);
      break;
    }
  }
  
  private static void deleteNoNumberNotification(NotificationManager paramNotificationManager, String paramString1, String paramString2)
  {
    AppMethodBeat.i(149376);
    try
    {
      Object localObject = paramNotificationManager.getNotificationChannels();
      if (localObject == null)
      {
        AppMethodBeat.o(149376);
        return;
      }
      int i = ((List)localObject).size();
      if (i <= 0)
      {
        AppMethodBeat.o(149376);
        return;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        NotificationChannel localNotificationChannel = (NotificationChannel)((Iterator)localObject).next();
        if ((localNotificationChannel != null) && (localNotificationChannel.getId() != null) && (localNotificationChannel.getId().startsWith(paramString2)) && (!bt.kU(localNotificationChannel.getId(), paramString1))) {
          paramNotificationManager.deleteNotificationChannel(localNotificationChannel.getId());
        }
      }
      AppMethodBeat.o(149376);
    }
    catch (Exception paramNotificationManager)
    {
      ad.e("MicroMsg.PluginNotification", "deleteNoNumberNotification exception:%s", new Object[] { paramNotificationManager.getMessage() });
      AppMethodBeat.o(149376);
      return;
    }
  }
  
  private static void deleteNoWeChatSetNotification(NotificationManager paramNotificationManager)
  {
    AppMethodBeat.i(149377);
    try
    {
      Object localObject = paramNotificationManager.getNotificationChannels();
      if (localObject == null)
      {
        AppMethodBeat.o(149377);
        return;
      }
      int i = ((List)localObject).size();
      if (i <= 0)
      {
        AppMethodBeat.o(149377);
        return;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        NotificationChannel localNotificationChannel = (NotificationChannel)((Iterator)localObject).next();
        if ((localNotificationChannel != null) && (localNotificationChannel.getId() != null) && (!bt.kU(localNotificationChannel.getId(), "message_dnd_mode_channel_id")) && (!bt.kU(localNotificationChannel.getId(), "reminder_channel_id")) && (!localNotificationChannel.getId().startsWith("message_channel")))
        {
          ad.i("MicroMsg.PluginNotification", "deleteNoWeChatSetNotification id:%s", new Object[] { localNotificationChannel.getId() });
          paramNotificationManager.deleteNotificationChannel(localNotificationChannel.getId());
        }
      }
      AppMethodBeat.o(149377);
    }
    catch (Exception paramNotificationManager)
    {
      ad.e("MicroMsg.PluginNotification", "deleteNoWeChatSetNotification exception:%s", new Object[] { paramNotificationManager.getMessage() });
      AppMethodBeat.o(149377);
      return;
    }
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(149374);
    ad.i("MicroMsg.PluginNotification", "execute");
    if (paramg.agu()) {
      createNotificationChannel();
    }
    AppMethodBeat.o(149374);
  }
  
  public aq getNotification()
  {
    return this.uhd;
  }
  
  public void setNotification(aq paramaq)
  {
    this.uhd = paramaq;
    c.ugT = paramaq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.PluginNotification
 * JD-Core Version:    0.7.0.1
 */