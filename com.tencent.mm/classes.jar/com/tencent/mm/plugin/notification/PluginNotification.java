package com.tencent.mm.plugin.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.cd;
import com.tencent.mm.autogen.a.vo;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ay;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class PluginNotification
  extends com.tencent.mm.kernel.b.f
  implements c, com.tencent.mm.plugin.notification.b.b
{
  private ay MvY;
  private IListener<cd> wZy;
  
  public PluginNotification()
  {
    AppMethodBeat.i(271921);
    this.wZy = new PluginNotification.1(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(271921);
  }
  
  public static void checkResetVoipSilentChannel()
  {
    boolean bool = false;
    AppMethodBeat.i(271927);
    label363:
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT >= 26)
        {
          Context localContext = MMApplicationContext.getContext();
          NotificationManager localNotificationManager = (NotificationManager)localContext.getSystemService(NotificationManager.class);
          NotificationChannel localNotificationChannel = localNotificationManager.getNotificationChannel(com.tencent.mm.bq.b.iGr());
          if (localNotificationChannel == null) {
            continue;
          }
          localObject1 = localNotificationChannel.getSound();
          Uri localUri = Uri.parse("android.resource://" + MMApplicationContext.getContext().getPackageName() + "/" + g.a.phonering);
          StringBuilder localStringBuilder = new StringBuilder("checkResetVoipSilentChannel originSound:");
          if (localObject1 == null) {
            continue;
          }
          localObject2 = ((Uri)localObject1).toString();
          Log.i("MicroMsg.PluginNotification", (String)localObject2);
          if ((localNotificationChannel == null) || (!localUri.equals(localObject1)))
          {
            Log.i("MicroMsg.PluginNotification", "silent channel not valid! try reset to:" + localUri.toString());
            if ((localNotificationChannel == null) || (localNotificationChannel.shouldVibrate())) {
              break label363;
            }
            localObject1 = localNotificationManager.getNotificationChannel("voip_notify_channel_new_id");
            if (localObject1 != null) {
              bool = ((NotificationChannel)localObject1).shouldVibrate();
            }
            localNotificationManager.deleteNotificationChannel("voip_channel_new_id");
            localNotificationManager.deleteNotificationChannel("voip_notify_channel_new_id");
            localNotificationManager.deleteNotificationChannel(com.tencent.mm.bq.b.iGr());
            localObject1 = com.tencent.mm.bq.b.xX(System.currentTimeMillis());
            localObject2 = new NotificationChannel((String)localObject1, localContext.getString(g.b.notification_voip_channel_name), 4);
            ((NotificationChannel)localObject2).setDescription(localContext.getString(g.b.notification_voip_channel_desc));
            ((NotificationChannel)localObject2).enableLights(true);
            ((NotificationChannel)localObject2).setLightColor(-16711936);
            ((NotificationChannel)localObject2).enableVibration(bool);
            ((NotificationChannel)localObject2).setLockscreenVisibility(0);
            ((NotificationChannel)localObject2).setSound(localUri, null);
            localNotificationManager.createNotificationChannel((NotificationChannel)localObject2);
            Log.i("MicroMsg.PluginNotification", "reset silent channel to " + (String)localObject1 + ", set vibration to " + bool);
          }
        }
        AppMethodBeat.o(271927);
        return;
        Object localObject1 = null;
        continue;
        Object localObject2 = "null";
        continue;
        bool = true;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.PluginNotification", "checkResetVoipSilentChannel error:" + localException.getLocalizedMessage());
        AppMethodBeat.o(271927);
        return;
      }
    }
  }
  
  public static void createActiveTimeNotification()
  {
    AppMethodBeat.i(149378);
    if (d.rb(26))
    {
      Context localContext = MMApplicationContext.getContext();
      NotificationManager localNotificationManager = (NotificationManager)localContext.getSystemService(NotificationManager.class);
      if (localNotificationManager.getNotificationChannel("message_dnd_mode_channel_id") == null)
      {
        NotificationChannel localNotificationChannel = new NotificationChannel("message_dnd_mode_channel_id", localContext.getString(g.b.notification_message_dnd_mode_channel_name), 4);
        localNotificationChannel.setDescription(localContext.getString(g.b.notification_message_dnd_mode_channel_desc));
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
    if (d.rb(26))
    {
      localContext = MMApplicationContext.getContext();
      localNotificationManager = (NotificationManager)localContext.getSystemService(NotificationManager.class);
      localObject = com.tencent.mm.kernel.b.aQC();
      deleteNoWeChatSetNotification(localNotificationManager);
      deleteNoNumberNotification(localNotificationManager, com.tencent.mm.bq.a.aQB(), "message_channel");
      boolean bool1 = ((SharedPreferences)localObject).getBoolean("settings_sound", true);
      boolean bool2 = ((SharedPreferences)localObject).getBoolean("settings_shake", true);
      Log.i("MicroMsg.NewMsgNotificationHelper", "isEnableMsgNotification:%s isSysEnableMsgNotification:%s sound:%s vibration:%s", new Object[] { Boolean.valueOf(com.tencent.mm.k.b.aQF()), Boolean.valueOf(com.tencent.mm.k.b.aQG()), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      boolean bool3 = e.b(localContext, localNotificationManager, bool2, bool1, (SharedPreferences)localObject);
      boolean bool4 = e.a(localContext, localNotificationManager, bool2, bool1, (SharedPreferences)localObject);
      if ((!bool3) && (!bool4))
      {
        localNotificationChannel = new NotificationChannel(com.tencent.mm.bq.a.aQB(), localContext.getString(g.b.notification_message_channel_name), 4);
        localNotificationChannel.setDescription(localContext.getString(g.b.notification_message_channel_desc));
        localNotificationChannel.enableLights(true);
        localNotificationChannel.setLightColor(-16711936);
        localNotificationChannel.setVibrationPattern(Util.VIRBRATOR_PATTERN);
        localNotificationChannel.enableVibration(bool2);
        if (!bool1) {
          break label406;
        }
        String str = ((SharedPreferences)localObject).getString("settings.ringtone", com.tencent.mm.k.b.lZE);
        if (e.aQv(str)) {
          localNotificationChannel.setSound(Uri.parse(str), Notification.AUDIO_ATTRIBUTES_DEFAULT);
        }
      }
    }
    for (;;)
    {
      ((SharedPreferences)localObject).edit().putString("message_channel_id", com.tencent.mm.bq.a.aQB()).commit();
      localNotificationManager.createNotificationChannel(localNotificationChannel);
      localObject = new NotificationChannel("reminder_channel_id", localContext.getString(g.b.notification_reminder_channel_name), 2);
      ((NotificationChannel)localObject).setDescription(localContext.getString(g.b.notification_reminder_channel_desc));
      localNotificationManager.createNotificationChannel((NotificationChannel)localObject);
      if (!com.tencent.mm.k.b.aQX())
      {
        localObject = new NotificationChannel("message_dnd_mode_channel_id", localContext.getString(g.b.notification_message_dnd_mode_channel_name), 4);
        ((NotificationChannel)localObject).setDescription(localContext.getString(g.b.notification_message_dnd_mode_channel_desc));
        ((NotificationChannel)localObject).enableLights(true);
        ((NotificationChannel)localObject).setLightColor(-16711936);
        ((NotificationChannel)localObject).enableVibration(false);
        ((NotificationChannel)localObject).setSound(null, Notification.AUDIO_ATTRIBUTES_DEFAULT);
        localNotificationManager.createNotificationChannel((NotificationChannel)localObject);
      }
      checkResetVoipSilentChannel();
      AppMethodBeat.o(149375);
      return;
      label406:
      localNotificationChannel.setSound(null, Notification.AUDIO_ATTRIBUTES_DEFAULT);
    }
  }
  
  private static void deleteNoNumberNotification(NotificationManager paramNotificationManager, String paramString1, String paramString2)
  {
    AppMethodBeat.i(149376);
    Log.i("MicroMsg.PluginNotification", "deleteNoNumberNotification channelId:" + paramString1 + " startsWith:" + paramString2);
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
        if ((localNotificationChannel != null) && (localNotificationChannel.getId() != null) && (localNotificationChannel.getId().startsWith(paramString2)) && (!Util.isEqual(localNotificationChannel.getId(), paramString1))) {
          paramNotificationManager.deleteNotificationChannel(localNotificationChannel.getId());
        }
      }
      AppMethodBeat.o(149376);
    }
    catch (Exception paramNotificationManager)
    {
      Log.e("MicroMsg.PluginNotification", "deleteNoNumberNotification exception:%s", new Object[] { paramNotificationManager.getMessage() });
      AppMethodBeat.o(149376);
      return;
    }
  }
  
  private static void deleteNoWeChatSetNotification(NotificationManager paramNotificationManager)
  {
    AppMethodBeat.i(149377);
    Log.i("MicroMsg.PluginNotification", "deleteNoWeChatSetNotification");
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
        if ((localNotificationChannel != null) && (localNotificationChannel.getId() != null) && (!Util.isEqual(localNotificationChannel.getId(), "message_dnd_mode_channel_id")) && (!Util.isEqual(localNotificationChannel.getId(), "reminder_channel_id")) && (!localNotificationChannel.getId().startsWith("message_channel")) && (!localNotificationChannel.getId().contains("voip_notify_channel_new_id")) && (!localNotificationChannel.getId().contains(com.tencent.mm.bq.b.XNh)) && (!localNotificationChannel.getId().contains(com.tencent.mm.bq.b.XNi)))
        {
          Log.i("MicroMsg.PluginNotification", "deleteNoWeChatSetNotification id:%s", new Object[] { localNotificationChannel.getId() });
          paramNotificationManager.deleteNotificationChannel(localNotificationChannel.getId());
        }
      }
      AppMethodBeat.o(149377);
    }
    catch (Exception paramNotificationManager)
    {
      Log.e("MicroMsg.PluginNotification", "deleteNoWeChatSetNotification exception:%s", new Object[] { paramNotificationManager.getMessage() });
      AppMethodBeat.o(149377);
      return;
    }
  }
  
  public static boolean handleRingtoneResUpdate(String paramString)
  {
    AppMethodBeat.i(271923);
    String str = com.tencent.mm.loader.i.b.bmr() + "newmsgringtone";
    if (!y.ZC(str)) {
      y.bDX(str);
    }
    if (y.ZC(com.tencent.mm.k.b.rg(1)))
    {
      Log.e("MicroMsg.PluginNotification", "file exits");
      AppMethodBeat.o(271923);
      return true;
    }
    int i = y.aA(paramString, str);
    if (i < 0) {
      Log.e("MicroMsg.PluginNotification", "unzip fail, ret = " + i + ", zipFilePath = " + paramString + ", unzipPath = " + str);
    }
    for (;;)
    {
      AppMethodBeat.o(271923);
      return true;
      Log.i("MicroMsg.PluginNotification", "unzip success!!");
      new vo().publish();
    }
  }
  
  public static boolean resetVoipRingtoneChannel(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, AudioAttributes paramAudioAttributes)
  {
    AppMethodBeat.i(271929);
    Log.i("MicroMsg.PluginNotification", "resetVoipRingtoneChannel toUser:" + paramString1 + " originChannelId:" + paramString2 + " newChannelId:" + paramString3 + " ringtonePath:" + paramString5);
    Context localContext;
    NotificationManager localNotificationManager;
    if (Build.VERSION.SDK_INT >= 26)
    {
      localContext = MMApplicationContext.getContext();
      localNotificationManager = (NotificationManager)localContext.getSystemService(NotificationManager.class);
      if ((localNotificationManager != null) && (paramString1 != null))
      {
        paramString4 = localNotificationManager.getNotificationChannel(paramString4);
        if (paramString4 == null) {
          break label335;
        }
      }
    }
    label335:
    for (boolean bool = paramString4.shouldVibrate();; bool = true)
    {
      if (localNotificationManager.getNotificationChannel(paramString2) != null) {
        localNotificationManager.deleteNotificationChannel(paramString2);
      }
      au localau = ((n)h.ax(n.class)).bzA().JE(paramString1);
      paramString4 = localContext.getString(g.b.notification_voip_global_channel_name);
      String str = localContext.getString(g.b.notification_voip_global_channel_desc);
      paramString1 = str;
      paramString2 = paramString4;
      if (localau != null)
      {
        paramString1 = str;
        paramString2 = paramString4;
        if (localau.aSU() != null)
        {
          paramString2 = localContext.getString(g.b.notification_voip_exclusive_channel_name, new Object[] { localau.aSU() });
          paramString1 = localContext.getString(g.b.notification_voip_exclusive_channel_desc, new Object[] { localau.aSU() });
        }
      }
      if (!paramString5.isEmpty())
      {
        paramString2 = new NotificationChannel(paramString3, paramString2, 4);
        paramString2.setDescription(paramString1);
        paramString2.enableLights(true);
        paramString2.setLightColor(-16711936);
        paramString2.enableVibration(bool);
        paramString2.setLockscreenVisibility(0);
        paramString1 = FileProviderHelper.getUriForFile(localContext, u.V(new File(paramString5)));
        MMApplicationContext.getContext().grantUriPermission("com.android.systemui", paramString1, 1);
        paramString2.setSound(paramString1, paramAudioAttributes);
        localNotificationManager.createNotificationChannel(paramString2);
      }
      AppMethodBeat.o(271929);
      return true;
      AppMethodBeat.o(271929);
      return false;
    }
  }
  
  public void dependency()
  {
    AppMethodBeat.i(271938);
    dependsOn(com.tencent.mm.plugin.expt.a.class);
    AppMethodBeat.o(271938);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(149374);
    Log.i("MicroMsg.PluginNotification", "execute");
    if (paramg.bbA()) {
      createNotificationChannel();
    }
    AppMethodBeat.o(149374);
  }
  
  public ay getNotification()
  {
    return this.MvY;
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(271943);
    this.wZy.alive();
    AppMethodBeat.o(271943);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(271944);
    this.wZy.dead();
    AppMethodBeat.o(271944);
  }
  
  public void setNotification(ay paramay)
  {
    this.MvY = paramay;
    f.MvN = paramay;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.PluginNotification
 * JD-Core Version:    0.7.0.1
 */