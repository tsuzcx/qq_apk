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
import com.tencent.mm.bq.a;
import com.tencent.mm.k.h;
import com.tencent.mm.model.cr;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.vendor.Huawei;
import com.tencent.mm.sdk.vendor.MIUI;
import java.util.Iterator;
import java.util.List;

public final class e
{
  private static NotificationChannel a(NotificationManager paramNotificationManager, String paramString)
  {
    AppMethodBeat.i(149371);
    try
    {
      paramNotificationManager = paramNotificationManager.getNotificationChannels();
      if (paramNotificationManager == null)
      {
        AppMethodBeat.o(149371);
        return null;
      }
      int i = paramNotificationManager.size();
      if (i <= 0)
      {
        AppMethodBeat.o(149371);
        return null;
      }
      paramNotificationManager = paramNotificationManager.iterator();
      while (paramNotificationManager.hasNext())
      {
        NotificationChannel localNotificationChannel = (NotificationChannel)paramNotificationManager.next();
        if ((localNotificationChannel != null) && (localNotificationChannel.getId() != null))
        {
          boolean bool = Util.isEqual(localNotificationChannel.getId(), paramString);
          if (bool)
          {
            AppMethodBeat.o(149371);
            return localNotificationChannel;
          }
        }
      }
    }
    catch (Exception paramNotificationManager)
    {
      Log.e("MicroMsg.NotificationManufacturerCompatibility", "deleteNoNumberNotification exception:%s", new Object[] { paramNotificationManager.getMessage() });
      AppMethodBeat.o(149371);
    }
    return null;
  }
  
  private static void a(NotificationChannel paramNotificationChannel, SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(149369);
    paramSharedPreferences = paramSharedPreferences.getString("settings.ringtone", com.tencent.mm.k.b.lZE);
    if (aQv(paramSharedPreferences)) {
      paramNotificationChannel.setSound(Uri.parse(paramSharedPreferences), Notification.AUDIO_ATTRIBUTES_DEFAULT);
    }
    AppMethodBeat.o(149369);
  }
  
  private static void a(Context paramContext, NotificationManager paramNotificationManager, String paramString, boolean paramBoolean1, boolean paramBoolean2, SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(149367);
    NotificationChannel localNotificationChannel = new NotificationChannel(paramString, paramContext.getString(g.b.notification_message_channel_name), 4);
    localNotificationChannel.setDescription(paramContext.getString(g.b.notification_message_channel_desc));
    localNotificationChannel.enableLights(true);
    localNotificationChannel.setLightColor(-16711936);
    localNotificationChannel.setVibrationPattern(Util.VIRBRATOR_PATTERN);
    localNotificationChannel.enableVibration(paramBoolean1);
    if (paramBoolean2)
    {
      paramContext = paramSharedPreferences.getString("settings.ringtone", com.tencent.mm.k.b.lZE);
      if (aQv(paramContext))
      {
        Log.e("MicroMsg.NotificationManufacturerCompatibility", "sound = %s", new Object[] { Uri.parse(paramContext) });
        localNotificationChannel.setSound(Uri.parse(paramContext), Notification.AUDIO_ATTRIBUTES_DEFAULT);
      }
    }
    paramSharedPreferences.edit().putString("message_channel_id", paramString).commit();
    paramNotificationManager.createNotificationChannel(localNotificationChannel);
    AppMethodBeat.o(149367);
  }
  
  private static void a(Context paramContext, NotificationManager paramNotificationManager, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(149368);
    NotificationChannel localNotificationChannel = new NotificationChannel(paramString, paramContext.getString(g.b.notification_message_channel_name), 4);
    localNotificationChannel.setDescription(paramContext.getString(g.b.notification_message_channel_desc));
    localNotificationChannel.enableLights(true);
    localNotificationChannel.setLightColor(-16711936);
    localNotificationChannel.setVibrationPattern(Util.VIRBRATOR_PATTERN);
    if (paramBoolean1)
    {
      localNotificationChannel.enableVibration(true);
      if (!paramBoolean1) {
        break label125;
      }
      if (paramBoolean4) {
        a(localNotificationChannel, paramSharedPreferences);
      }
    }
    for (;;)
    {
      paramSharedPreferences.edit().putString("message_channel_id", paramString).commit();
      paramNotificationManager.createNotificationChannel(localNotificationChannel);
      AppMethodBeat.o(149368);
      return;
      localNotificationChannel.enableVibration(paramBoolean3);
      break;
      label125:
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
    AppMethodBeat.i(149365);
    if (!MIUI.ifMIUI())
    {
      AppMethodBeat.o(149365);
      return false;
    }
    String str1 = a.aQB();
    NotificationChannel localNotificationChannel = a(paramNotificationManager, str1);
    if (localNotificationChannel == null) {
      a(paramContext, paramNotificationManager, str1, paramBoolean1, paramBoolean2, paramSharedPreferences);
    }
    for (;;)
    {
      AppMethodBeat.o(149365);
      return true;
      cr.Kg(com.tencent.mm.loader.i.b.bmr());
      String str2 = cr.vq(2);
      String[] arrayOfString = str2.split(";");
      Log.i("MicroMsg.NotificationManufacturerCompatibility", "xiaomiNotificationCompatibility() lastVersion:%s curVersion:%s", new Object[] { str2, Integer.valueOf(d.Yxh) });
      if ((arrayOfString != null) && (arrayOfString.length == 2))
      {
        int i = Integer.parseInt(arrayOfString[0], 16);
        Log.i("MicroMsg.NotificationManufacturerCompatibility", "xiaomiNotificationCompatibility() lastVersion:%s", new Object[] { Integer.valueOf(i) });
        if ((654311424 <= i) && (i <= 654312247) && (!Util.isEqual(localNotificationChannel.getId(), "message_channel_compatibility_id"))) {
          if (localNotificationChannel.getSound() == null) {
            try
            {
              paramNotificationManager.deleteNotificationChannel(localNotificationChannel.getId());
              a(paramContext, paramNotificationManager, "message_channel_compatibility_id", paramBoolean1, paramBoolean2, paramSharedPreferences);
              a.DG("message_channel_compatibility_id");
            }
            catch (Exception paramContext)
            {
              Log.e("MicroMsg.NotificationManufacturerCompatibility", "huaweiNotificationCompatibility exception:%s", new Object[] { paramContext.getMessage() });
            }
          } else {
            a(paramContext, paramNotificationManager, str1, paramBoolean1, paramBoolean2, paramSharedPreferences);
          }
        }
      }
    }
  }
  
  public static boolean aQv(String paramString)
  {
    AppMethodBeat.i(149372);
    if (!Util.isNullOrNil(paramString)) {}
    for (boolean bool = m(Uri.parse(paramString));; bool = false)
    {
      Log.e("MicroMsg.NotificationManufacturerCompatibility", "sound = %s result = %s", new Object[] { Util.nullAs(paramString, "null"), Boolean.valueOf(bool) });
      AppMethodBeat.o(149372);
      return bool;
    }
  }
  
  public static boolean b(Context paramContext, NotificationManager paramNotificationManager, boolean paramBoolean1, boolean paramBoolean2, SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(149366);
    boolean bool1 = Huawei.isEMUI8();
    boolean bool2 = Huawei.isEMUI9();
    if ((!bool1) && (!bool2))
    {
      AppMethodBeat.o(149366);
      return false;
    }
    String str = a.aQB();
    NotificationChannel localNotificationChannel = a(paramNotificationManager, str);
    if (localNotificationChannel == null)
    {
      a(paramContext, paramNotificationManager, str, bool1, bool2, paramBoolean1, paramBoolean2, paramSharedPreferences);
      AppMethodBeat.o(149366);
      return true;
    }
    if ((bool1) && ((!localNotificationChannel.shouldVibrate()) || (localNotificationChannel.getSound() == null))) {}
    for (int i = 1;; i = 0)
    {
      for (;;)
      {
        if (i == 0) {
          break label177;
        }
        try
        {
          if (localNotificationChannel.getSound() != null) {
            h.DJ(localNotificationChannel.getSound().toString());
          }
          paramNotificationManager.deleteNotificationChannel(localNotificationChannel.getId());
          a(paramContext, paramNotificationManager, "message_channel_compatibility_id", bool1, bool2, paramBoolean1, paramBoolean2, paramSharedPreferences);
          a.DG("message_channel_compatibility_id");
        }
        catch (Exception paramContext)
        {
          Log.e("MicroMsg.NotificationManufacturerCompatibility", "huaweiNotificationCompatibility exception:%s", new Object[] { paramContext.getMessage() });
        }
      }
      break;
      label177:
      a(paramContext, paramNotificationManager, str, bool1, bool2, paramBoolean1, paramBoolean2, paramSharedPreferences);
      break;
    }
  }
  
  /* Error */
  private static boolean m(Uri paramUri)
  {
    // Byte code:
    //   0: ldc_w 304
    //   3: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 310	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   9: invokevirtual 314	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   12: aload_0
    //   13: ldc_w 316
    //   16: invokevirtual 322	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   19: astore_2
    //   20: new 324	com/tencent/mm/compatible/b/k
    //   23: dup
    //   24: invokespecial 327	com/tencent/mm/compatible/b/k:<init>	()V
    //   27: aload_2
    //   28: invokevirtual 333	android/media/MediaPlayer:setDataSource	(Landroid/content/res/AssetFileDescriptor;)V
    //   31: aload_2
    //   32: ifnull +7 -> 39
    //   35: aload_2
    //   36: invokevirtual 338	android/content/res/AssetFileDescriptor:close	()V
    //   39: ldc_w 304
    //   42: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: iconst_1
    //   46: ireturn
    //   47: astore_1
    //   48: aload_2
    //   49: ifnull +7 -> 56
    //   52: aload_2
    //   53: invokevirtual 338	android/content/res/AssetFileDescriptor:close	()V
    //   56: ldc_w 304
    //   59: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: aload_1
    //   63: athrow
    //   64: astore_1
    //   65: ldc 58
    //   67: new 340	java/lang/StringBuilder
    //   70: dup
    //   71: ldc_w 342
    //   74: invokespecial 344	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   77: aload_0
    //   78: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   81: ldc_w 350
    //   84: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload_1
    //   88: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 354	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokestatic 358	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: ldc_w 304
    //   100: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: iconst_0
    //   104: ireturn
    //   105: astore_2
    //   106: aload_1
    //   107: aload_2
    //   108: invokevirtual 364	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   111: goto -55 -> 56
    //   114: astore_1
    //   115: goto -50 -> 65
    //   118: astore_0
    //   119: ldc_w 304
    //   122: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   125: aload_0
    //   126: athrow
    //   127: astore_1
    //   128: goto -63 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	paramUri	Uri
    //   47	16	1	localObject	Object
    //   64	43	1	localNullPointerException	java.lang.NullPointerException
    //   114	1	1	localSecurityException	java.lang.SecurityException
    //   127	1	1	localIOException	java.io.IOException
    //   19	34	2	localAssetFileDescriptor	android.content.res.AssetFileDescriptor
    //   105	3	2	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   20	31	47	finally
    //   6	20	64	java/lang/NullPointerException
    //   35	39	64	java/lang/NullPointerException
    //   56	64	64	java/lang/NullPointerException
    //   106	111	64	java/lang/NullPointerException
    //   52	56	105	finally
    //   6	20	114	java/lang/SecurityException
    //   35	39	114	java/lang/SecurityException
    //   56	64	114	java/lang/SecurityException
    //   106	111	114	java/lang/SecurityException
    //   6	20	118	finally
    //   35	39	118	finally
    //   56	64	118	finally
    //   65	97	118	finally
    //   106	111	118	finally
    //   6	20	127	java/io/IOException
    //   35	39	127	java/io/IOException
    //   56	64	127	java/io/IOException
    //   106	111	127	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.e
 * JD-Core Version:    0.7.0.1
 */