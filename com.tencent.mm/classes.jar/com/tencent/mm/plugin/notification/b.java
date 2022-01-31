package com.tencent.mm.plugin.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.provider.Settings.System;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

public final class b
{
  private static NotificationChannel a(NotificationManager paramNotificationManager, String paramString)
  {
    AppMethodBeat.i(125794);
    try
    {
      paramNotificationManager = paramNotificationManager.getNotificationChannels();
      if (paramNotificationManager == null)
      {
        AppMethodBeat.o(125794);
        return null;
      }
      int i = paramNotificationManager.size();
      if (i <= 0)
      {
        AppMethodBeat.o(125794);
        return null;
      }
      paramNotificationManager = paramNotificationManager.iterator();
      while (paramNotificationManager.hasNext())
      {
        NotificationChannel localNotificationChannel = (NotificationChannel)paramNotificationManager.next();
        if ((localNotificationChannel != null) && (localNotificationChannel.getId() != null))
        {
          boolean bool = bo.isEqual(localNotificationChannel.getId(), paramString);
          if (bool)
          {
            AppMethodBeat.o(125794);
            return localNotificationChannel;
          }
        }
      }
    }
    catch (Exception paramNotificationManager)
    {
      ab.e("MicroMsg.NotificationManufacturerCompatibility", "deleteNoNumberNotification exception:%s", new Object[] { paramNotificationManager.getMessage() });
      AppMethodBeat.o(125794);
    }
    return null;
  }
  
  private static void a(NotificationChannel paramNotificationChannel, SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(125792);
    paramSharedPreferences = paramSharedPreferences.getString("settings.ringtone", com.tencent.mm.m.a.etD);
    if (!bo.isNullOrNil(paramSharedPreferences))
    {
      ab.e("MicroMsg.NotificationManufacturerCompatibility", "sound = %s", new Object[] { Uri.parse(paramSharedPreferences) });
      paramNotificationChannel.setSound(Uri.parse(paramSharedPreferences), Notification.AUDIO_ATTRIBUTES_DEFAULT);
    }
    AppMethodBeat.o(125792);
  }
  
  private static void a(Context paramContext, NotificationManager paramNotificationManager, String paramString, boolean paramBoolean1, boolean paramBoolean2, SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(125790);
    NotificationChannel localNotificationChannel = new NotificationChannel(paramString, paramContext.getString(2131301936), 4);
    localNotificationChannel.setDescription(paramContext.getString(2131301935));
    localNotificationChannel.enableLights(true);
    localNotificationChannel.setLightColor(-16711936);
    localNotificationChannel.setVibrationPattern(bo.glS);
    localNotificationChannel.enableVibration(paramBoolean1);
    if (paramBoolean2)
    {
      paramContext = paramSharedPreferences.getString("settings.ringtone", com.tencent.mm.m.a.etD);
      if (!bo.isNullOrNil(paramContext))
      {
        ab.e("MicroMsg.NotificationManufacturerCompatibility", "sound = %s", new Object[] { Uri.parse(paramContext) });
        localNotificationChannel.setSound(Uri.parse(paramContext), Notification.AUDIO_ATTRIBUTES_DEFAULT);
      }
    }
    paramSharedPreferences.edit().putString("message_channel_id", paramString).commit();
    paramNotificationManager.createNotificationChannel(localNotificationChannel);
    AppMethodBeat.o(125790);
  }
  
  private static void a(Context paramContext, NotificationManager paramNotificationManager, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(138324);
    NotificationChannel localNotificationChannel = new NotificationChannel(paramString, paramContext.getString(2131301936), 4);
    localNotificationChannel.setDescription(paramContext.getString(2131301935));
    localNotificationChannel.enableLights(true);
    localNotificationChannel.setLightColor(-16711936);
    localNotificationChannel.setVibrationPattern(bo.glS);
    if (paramBoolean1)
    {
      localNotificationChannel.enableVibration(true);
      if (!paramBoolean1) {
        break label123;
      }
      if (paramBoolean4) {
        a(localNotificationChannel, paramSharedPreferences);
      }
    }
    for (;;)
    {
      paramSharedPreferences.edit().putString("message_channel_id", paramString).commit();
      paramNotificationManager.createNotificationChannel(localNotificationChannel);
      AppMethodBeat.o(138324);
      return;
      localNotificationChannel.enableVibration(paramBoolean3);
      break;
      label123:
      if (paramBoolean2) {
        if (paramBoolean4) {
          a(localNotificationChannel, paramSharedPreferences);
        } else {
          localNotificationChannel.setSound(Settings.System.DEFAULT_NOTIFICATION_URI, Notification.AUDIO_ATTRIBUTES_DEFAULT);
        }
      }
    }
  }
  
  public static boolean a(Context paramContext, NotificationManager paramNotificationManager, boolean paramBoolean1, boolean paramBoolean2, SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(125788);
    if (!com.tencent.mm.sdk.h.b.duO())
    {
      AppMethodBeat.o(125788);
      return false;
    }
    String str = com.tencent.mm.bp.a.Mt();
    NotificationChannel localNotificationChannel = a(paramNotificationManager, str);
    if (localNotificationChannel == null) {
      a(paramContext, paramNotificationManager, str, paramBoolean1, paramBoolean2, paramSharedPreferences);
    }
    for (;;)
    {
      AppMethodBeat.o(125788);
      return true;
      if (localNotificationChannel.getSound() == null) {
        try
        {
          paramNotificationManager.deleteNotificationChannel(localNotificationChannel.getId());
          a(paramContext, paramNotificationManager, "message_channel_compatibility_id", paramBoolean1, paramBoolean2, paramSharedPreferences);
          com.tencent.mm.bp.a.akR("message_channel_compatibility_id");
        }
        catch (Exception paramContext)
        {
          ab.e("MicroMsg.NotificationManufacturerCompatibility", "huaweiNotificationCompatibility exception:%s", new Object[] { paramContext.getMessage() });
        }
      } else {
        a(paramContext, paramNotificationManager, str, paramBoolean1, paramBoolean2, paramSharedPreferences);
      }
    }
  }
  
  public static boolean b(Context paramContext, NotificationManager paramNotificationManager, boolean paramBoolean1, boolean paramBoolean2, SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(138323);
    String str = getProperty("ro.build.version.emui").toLowerCase();
    boolean bool2;
    boolean bool1;
    if (str.startsWith("EmotionUI_8".toLowerCase()))
    {
      bool2 = false;
      bool1 = true;
    }
    for (;;)
    {
      if ((!bool1) && (!bool2))
      {
        AppMethodBeat.o(138323);
        return false;
        if (str.startsWith("EmotionUI_9".toLowerCase()))
        {
          bool2 = true;
          bool1 = false;
        }
      }
      else
      {
        str = com.tencent.mm.bp.a.Mt();
        NotificationChannel localNotificationChannel = a(paramNotificationManager, str);
        if (localNotificationChannel == null)
        {
          a(paramContext, paramNotificationManager, str, bool1, bool2, paramBoolean1, paramBoolean2, paramSharedPreferences);
          AppMethodBeat.o(138323);
          return true;
        }
        if ((bool1) && ((!localNotificationChannel.shouldVibrate()) || (localNotificationChannel.getSound() == null))) {}
        for (int i = 1;; i = 0)
        {
          for (;;)
          {
            if (i == 0) {
              break label226;
            }
            try
            {
              if (localNotificationChannel.getSound() != null) {
                f.lt(localNotificationChannel.getSound().toString());
              }
              paramNotificationManager.deleteNotificationChannel(localNotificationChannel.getId());
              a(paramContext, paramNotificationManager, "message_channel_compatibility_id", true, false, paramBoolean1, paramBoolean2, paramSharedPreferences);
              com.tencent.mm.bp.a.akR("message_channel_compatibility_id");
            }
            catch (Exception paramContext)
            {
              ab.e("MicroMsg.NotificationManufacturerCompatibility", "huaweiNotificationCompatibility exception:%s", new Object[] { paramContext.getMessage() });
            }
          }
          break;
          label226:
          a(paramContext, paramNotificationManager, str, bool1, bool2, paramBoolean1, paramBoolean2, paramSharedPreferences);
          break;
        }
      }
      bool2 = false;
      bool1 = false;
    }
  }
  
  private static String getProperty(String paramString)
  {
    AppMethodBeat.i(125793);
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
      paramString = (String)localClass.getMethod("get", new Class[] { String.class, String.class }).invoke(localClass, new Object[] { paramString, "unknown" });
      AppMethodBeat.o(125793);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ab.e("MicroMsg.NotificationManufacturerCompatibility", "getProperty() Exception:%s", new Object[] { paramString.getMessage() });
        paramString = "unknown";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.b
 * JD-Core Version:    0.7.0.1
 */