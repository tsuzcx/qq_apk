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
import com.tencent.mm.model.cl;
import com.tencent.mm.n.f;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.List;

public final class c
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
          boolean bool = bu.lX(localNotificationChannel.getId(), paramString);
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
      ae.e("MicroMsg.NotificationManufacturerCompatibility", "deleteNoNumberNotification exception:%s", new Object[] { paramNotificationManager.getMessage() });
      AppMethodBeat.o(149371);
    }
    return null;
  }
  
  private static void a(NotificationChannel paramNotificationChannel, SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(149369);
    paramSharedPreferences = paramSharedPreferences.getString("settings.ringtone", com.tencent.mm.n.a.ggs);
    if (auM(paramSharedPreferences)) {
      paramNotificationChannel.setSound(Uri.parse(paramSharedPreferences), Notification.AUDIO_ATTRIBUTES_DEFAULT);
    }
    AppMethodBeat.o(149369);
  }
  
  private static void a(Context paramContext, NotificationManager paramNotificationManager, String paramString, boolean paramBoolean1, boolean paramBoolean2, SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(149367);
    NotificationChannel localNotificationChannel = new NotificationChannel(paramString, paramContext.getString(2131761698), 4);
    localNotificationChannel.setDescription(paramContext.getString(2131761697));
    localNotificationChannel.enableLights(true);
    localNotificationChannel.setLightColor(-16711936);
    localNotificationChannel.setVibrationPattern(bu.iSV);
    localNotificationChannel.enableVibration(paramBoolean1);
    if (paramBoolean2)
    {
      paramContext = paramSharedPreferences.getString("settings.ringtone", com.tencent.mm.n.a.ggs);
      if (auM(paramContext))
      {
        ae.e("MicroMsg.NotificationManufacturerCompatibility", "sound = %s", new Object[] { Uri.parse(paramContext) });
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
    NotificationChannel localNotificationChannel = new NotificationChannel(paramString, paramContext.getString(2131761698), 4);
    localNotificationChannel.setDescription(paramContext.getString(2131761697));
    localNotificationChannel.enableLights(true);
    localNotificationChannel.setLightColor(-16711936);
    localNotificationChannel.setVibrationPattern(bu.iSV);
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
      AppMethodBeat.o(149368);
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
    AppMethodBeat.i(149365);
    if (!com.tencent.mm.sdk.h.b.fqp())
    {
      AppMethodBeat.o(149365);
      return false;
    }
    String str1 = com.tencent.mm.bq.a.abK();
    NotificationChannel localNotificationChannel = a(paramNotificationManager, str1);
    if (localNotificationChannel == null) {
      a(paramContext, paramNotificationManager, str1, paramBoolean1, paramBoolean2, paramSharedPreferences);
    }
    for (;;)
    {
      AppMethodBeat.o(149365);
      return true;
      cl.Cf(com.tencent.mm.loader.j.b.asb());
      String str2 = cl.oI(2);
      String[] arrayOfString = str2.split(";");
      ae.i("MicroMsg.NotificationManufacturerCompatibility", "xiaomiNotificationCompatibility() lastVersion:%s curVersion:%s", new Object[] { str2, Integer.valueOf(d.FFH) });
      if ((arrayOfString != null) && (arrayOfString.length == 2))
      {
        int i = Integer.parseInt(arrayOfString[0], 16);
        ae.i("MicroMsg.NotificationManufacturerCompatibility", "xiaomiNotificationCompatibility() lastVersion:%s", new Object[] { Integer.valueOf(i) });
        if ((654311424 <= i) && (i <= 654312247) && (!bu.lX(localNotificationChannel.getId(), "message_channel_compatibility_id"))) {
          if (localNotificationChannel.getSound() == null) {
            try
            {
              paramNotificationManager.deleteNotificationChannel(localNotificationChannel.getId());
              a(paramContext, paramNotificationManager, "message_channel_compatibility_id", paramBoolean1, paramBoolean2, paramSharedPreferences);
              com.tencent.mm.bq.a.aMz("message_channel_compatibility_id");
            }
            catch (Exception paramContext)
            {
              ae.e("MicroMsg.NotificationManufacturerCompatibility", "huaweiNotificationCompatibility exception:%s", new Object[] { paramContext.getMessage() });
            }
          } else {
            a(paramContext, paramNotificationManager, str1, paramBoolean1, paramBoolean2, paramSharedPreferences);
          }
        }
      }
    }
  }
  
  public static boolean auM(String paramString)
  {
    AppMethodBeat.i(149372);
    if (!bu.isNullOrNil(paramString)) {}
    for (boolean bool = s(Uri.parse(paramString));; bool = false)
    {
      ae.e("MicroMsg.NotificationManufacturerCompatibility", "sound = %s result = %s", new Object[] { bu.bI(paramString, "null"), Boolean.valueOf(bool) });
      AppMethodBeat.o(149372);
      return bool;
    }
  }
  
  public static boolean b(Context paramContext, NotificationManager paramNotificationManager, boolean paramBoolean1, boolean paramBoolean2, SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(149366);
    boolean bool1 = com.tencent.mm.sdk.h.a.fqk();
    boolean bool2 = com.tencent.mm.sdk.h.a.fql();
    if ((!bool1) && (!bool2))
    {
      AppMethodBeat.o(149366);
      return false;
    }
    String str = com.tencent.mm.bq.a.abK();
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
            f.vU(localNotificationChannel.getSound().toString());
          }
          paramNotificationManager.deleteNotificationChannel(localNotificationChannel.getId());
          a(paramContext, paramNotificationManager, "message_channel_compatibility_id", bool1, bool2, paramBoolean1, paramBoolean2, paramSharedPreferences);
          com.tencent.mm.bq.a.aMz("message_channel_compatibility_id");
        }
        catch (Exception paramContext)
        {
          ae.e("MicroMsg.NotificationManufacturerCompatibility", "huaweiNotificationCompatibility exception:%s", new Object[] { paramContext.getMessage() });
        }
      }
      break;
      label177:
      a(paramContext, paramNotificationManager, str, bool1, bool2, paramBoolean1, paramBoolean2, paramSharedPreferences);
      break;
    }
  }
  
  /* Error */
  private static boolean s(Uri paramUri)
  {
    // Byte code:
    //   0: ldc_w 300
    //   3: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 306	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   9: invokevirtual 310	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   12: aload_0
    //   13: ldc_w 312
    //   16: invokevirtual 318	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   19: astore_3
    //   20: aconst_null
    //   21: astore_2
    //   22: new 320	com/tencent/mm/compatible/b/k
    //   25: dup
    //   26: invokespecial 323	com/tencent/mm/compatible/b/k:<init>	()V
    //   29: aload_3
    //   30: invokevirtual 329	android/media/MediaPlayer:setDataSource	(Landroid/content/res/AssetFileDescriptor;)V
    //   33: aload_3
    //   34: ifnull +7 -> 41
    //   37: aload_3
    //   38: invokevirtual 334	android/content/res/AssetFileDescriptor:close	()V
    //   41: ldc_w 300
    //   44: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: iconst_1
    //   48: ireturn
    //   49: astore_2
    //   50: ldc_w 300
    //   53: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: aload_2
    //   57: athrow
    //   58: astore_1
    //   59: aload_3
    //   60: ifnull +11 -> 71
    //   63: aload_2
    //   64: ifnull +65 -> 129
    //   67: aload_3
    //   68: invokevirtual 334	android/content/res/AssetFileDescriptor:close	()V
    //   71: ldc_w 300
    //   74: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: aload_1
    //   78: athrow
    //   79: astore_1
    //   80: ldc 58
    //   82: new 336	java/lang/StringBuilder
    //   85: dup
    //   86: ldc_w 338
    //   89: invokespecial 340	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   92: aload_0
    //   93: invokevirtual 344	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   96: ldc_w 346
    //   99: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_1
    //   103: invokevirtual 344	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 350	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokestatic 354	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   112: ldc_w 300
    //   115: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: iconst_0
    //   119: ireturn
    //   120: astore_3
    //   121: aload_2
    //   122: aload_3
    //   123: invokevirtual 358	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   126: goto -55 -> 71
    //   129: aload_3
    //   130: invokevirtual 334	android/content/res/AssetFileDescriptor:close	()V
    //   133: goto -62 -> 71
    //   136: astore_1
    //   137: goto -57 -> 80
    //   140: astore_0
    //   141: ldc_w 300
    //   144: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   147: aload_0
    //   148: athrow
    //   149: astore_1
    //   150: goto -91 -> 59
    //   153: astore_1
    //   154: goto -74 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	paramUri	Uri
    //   58	20	1	localObject1	Object
    //   79	24	1	localNullPointerException	java.lang.NullPointerException
    //   136	1	1	localIOException	java.io.IOException
    //   149	1	1	localObject2	Object
    //   153	1	1	localSecurityException	java.lang.SecurityException
    //   21	1	2	localObject3	Object
    //   49	73	2	localThrowable1	java.lang.Throwable
    //   19	49	3	localAssetFileDescriptor	android.content.res.AssetFileDescriptor
    //   120	10	3	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   22	33	49	java/lang/Throwable
    //   50	58	58	finally
    //   6	20	79	java/lang/NullPointerException
    //   37	41	79	java/lang/NullPointerException
    //   67	71	79	java/lang/NullPointerException
    //   71	79	79	java/lang/NullPointerException
    //   121	126	79	java/lang/NullPointerException
    //   129	133	79	java/lang/NullPointerException
    //   67	71	120	java/lang/Throwable
    //   6	20	136	java/io/IOException
    //   37	41	136	java/io/IOException
    //   67	71	136	java/io/IOException
    //   71	79	136	java/io/IOException
    //   121	126	136	java/io/IOException
    //   129	133	136	java/io/IOException
    //   6	20	140	finally
    //   37	41	140	finally
    //   67	71	140	finally
    //   71	79	140	finally
    //   80	112	140	finally
    //   121	126	140	finally
    //   129	133	140	finally
    //   22	33	149	finally
    //   6	20	153	java/lang/SecurityException
    //   37	41	153	java/lang/SecurityException
    //   67	71	153	java/lang/SecurityException
    //   71	79	153	java/lang/SecurityException
    //   121	126	153	java/lang/SecurityException
    //   129	133	153	java/lang/SecurityException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.c
 * JD-Core Version:    0.7.0.1
 */