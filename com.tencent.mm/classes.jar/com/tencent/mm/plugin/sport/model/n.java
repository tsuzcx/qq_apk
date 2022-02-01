package com.tencent.mm.plugin.sport.model;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.sport.b.a;
import com.tencent.mm.plugin.sport.b.d;
import com.tencent.mm.plugin.sport.b.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.r;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.json.JSONObject;

public final class n
{
  private static r Lyp;
  private static final String[] Lyq;
  private static final Uri Lyr;
  
  static
  {
    AppMethodBeat.i(149364);
    Lyq = new String[] { "_id", "_begin_time", "_end_time", "_mode", "_steps" };
    Lyr = Uri.parse("content://com.miui.providers.steps/item");
    AppMethodBeat.o(149364);
  }
  
  public static final String GN(long paramLong)
  {
    AppMethodBeat.i(149353);
    String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(paramLong));
    AppMethodBeat.o(149353);
    return str;
  }
  
  public static boolean aC(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(149354);
    l2 = 3600000L;
    try
    {
      JSONObject localJSONObject = k.gaS().optJSONObject("stepCountUploadConfig");
      l1 = l2;
      if (localJSONObject != null)
      {
        int i = localJSONObject.optInt("backgroundTimeInterval", 60);
        l1 = i * 60 * 1000L;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l1 = l2;
      }
    }
    if (paramLong2 - paramLong1 >= l1)
    {
      AppMethodBeat.o(149354);
      return true;
    }
    AppMethodBeat.o(149354);
    return false;
  }
  
  public static boolean aD(long paramLong1, long paramLong2)
  {
    j = 500;
    AppMethodBeat.i(149355);
    if ((paramLong1 == 0L) && (paramLong2 > 0L))
    {
      AppMethodBeat.o(149355);
      return true;
    }
    try
    {
      JSONObject localJSONObject = k.gaS().optJSONObject("stepCountUploadConfig");
      i = j;
      if (localJSONObject != null) {
        i = localJSONObject.optInt("backgroundStepCountInterval", 500);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = j;
      }
    }
    if (paramLong2 - paramLong1 >= i)
    {
      AppMethodBeat.o(149355);
      return true;
    }
    AppMethodBeat.o(149355);
    return false;
  }
  
  public static void eBD()
  {
    AppMethodBeat.i(149361);
    if (Lyp != null)
    {
      Lyp.dismiss();
      Lyp = null;
    }
    AppMethodBeat.o(149361);
  }
  
  public static boolean gaC()
  {
    AppMethodBeat.i(149359);
    as localas = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG("gh_43f2581f6fd6");
    if (localas != null) {}
    for (boolean bool = com.tencent.mm.contact.d.rk(localas.field_type);; bool = false)
    {
      if (!bool) {
        Log.i("MicroMsg.Sport.SportUtil", "checkUserInstallWeSportPlugin %b", new Object[] { Boolean.valueOf(bool) });
      }
      AppMethodBeat.o(149359);
      return bool;
    }
  }
  
  public static long gba()
  {
    AppMethodBeat.i(149351);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    long l = localCalendar.getTimeInMillis();
    AppMethodBeat.o(149351);
    return l;
  }
  
  public static int gbb()
  {
    AppMethodBeat.i(149352);
    TimeZone localTimeZone = TimeZone.getDefault();
    int j = localTimeZone.getRawOffset() / 1000;
    if ((localTimeZone.useDaylightTime()) && (localTimeZone.inDaylightTime(new Date(System.currentTimeMillis())))) {}
    for (int i = 1;; i = 0)
    {
      j /= 3600;
      AppMethodBeat.o(149352);
      return i + j;
    }
  }
  
  public static boolean gbc()
  {
    AppMethodBeat.i(149357);
    if (k.gaS().optInt("checkWeSportInstall") != 1)
    {
      Log.i("MicroMsg.Sport.SportUtil", "checkPushInstallWeSport is false");
      AppMethodBeat.o(149357);
      return false;
    }
    AppMethodBeat.o(149357);
    return true;
  }
  
  public static boolean gbd()
  {
    AppMethodBeat.i(149358);
    if (k.gaS().optInt("extStepApiSwitch") != 1)
    {
      Log.i("MicroMsg.Sport.SportUtil", "Not Support extStepApiSwitch is off");
      AppMethodBeat.o(149358);
      return false;
    }
    AppMethodBeat.o(149358);
    return true;
  }
  
  /* Error */
  public static int gbe()
  {
    // Byte code:
    //   0: ldc 221
    //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore 5
    //   8: aconst_null
    //   9: astore 4
    //   11: invokestatic 226	com/tencent/mm/sdk/vendor/MIUI:ifMIUI	()Z
    //   14: ifeq +313 -> 327
    //   17: ldc 228
    //   19: invokestatic 234	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   22: astore 7
    //   24: aload 7
    //   26: invokevirtual 238	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   29: astore 6
    //   31: aload 7
    //   33: ldc 240
    //   35: iconst_2
    //   36: anewarray 230	java/lang/Class
    //   39: dup
    //   40: iconst_0
    //   41: ldc 23
    //   43: aastore
    //   44: dup
    //   45: iconst_1
    //   46: getstatic 244	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   49: aastore
    //   50: invokevirtual 248	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   53: astore 7
    //   55: aload 7
    //   57: iconst_1
    //   58: invokevirtual 254	java/lang/reflect/Method:setAccessible	(Z)V
    //   61: aload 7
    //   63: aload 6
    //   65: iconst_2
    //   66: anewarray 4	java/lang/Object
    //   69: dup
    //   70: iconst_0
    //   71: ldc_w 256
    //   74: aastore
    //   75: dup
    //   76: iconst_1
    //   77: getstatic 260	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   80: aastore
    //   81: invokevirtual 264	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   84: astore 6
    //   86: aload 6
    //   88: instanceof 152
    //   91: ifeq +236 -> 327
    //   94: aload 6
    //   96: checkcast 152	java/lang/Boolean
    //   99: invokevirtual 267	java/lang/Boolean:booleanValue	()Z
    //   102: ifeq +225 -> 327
    //   105: invokestatic 269	com/tencent/mm/plugin/sport/model/n:gba	()J
    //   108: lstore_2
    //   109: invokestatic 275	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   112: invokevirtual 281	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   115: astore 6
    //   117: aload 6
    //   119: ifnull +208 -> 327
    //   122: aload 6
    //   124: getstatic 45	com/tencent/mm/plugin/sport/model/n:Lyr	Landroid/net/Uri;
    //   127: getstatic 35	com/tencent/mm/plugin/sport/model/n:Lyq	[Ljava/lang/String;
    //   130: ldc_w 283
    //   133: iconst_2
    //   134: anewarray 23	java/lang/String
    //   137: dup
    //   138: iconst_0
    //   139: lload_2
    //   140: invokestatic 285	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   143: aastore
    //   144: dup
    //   145: iconst_1
    //   146: lload_2
    //   147: ldc2_w 286
    //   150: ladd
    //   151: invokestatic 285	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   154: aastore
    //   155: ldc_w 289
    //   158: invokevirtual 295	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   161: astore 4
    //   163: aload 4
    //   165: ifnull +157 -> 322
    //   168: iconst_0
    //   169: istore_0
    //   170: aload 4
    //   172: astore 5
    //   174: aload 4
    //   176: invokeinterface 300 1 0
    //   181: ifeq +23 -> 204
    //   184: aload 4
    //   186: astore 5
    //   188: aload 4
    //   190: iconst_4
    //   191: invokeinterface 304 2 0
    //   196: istore_1
    //   197: iload_0
    //   198: iload_1
    //   199: iadd
    //   200: istore_0
    //   201: goto -31 -> 170
    //   204: iload_0
    //   205: istore_1
    //   206: aload 4
    //   208: ifnull +12 -> 220
    //   211: aload 4
    //   213: invokeinterface 307 1 0
    //   218: iload_0
    //   219: istore_1
    //   220: ldc 148
    //   222: ldc_w 309
    //   225: iconst_1
    //   226: anewarray 4	java/lang/Object
    //   229: dup
    //   230: iconst_0
    //   231: iload_1
    //   232: invokestatic 314	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   235: aastore
    //   236: invokestatic 161	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   239: ldc 221
    //   241: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   244: iload_1
    //   245: ireturn
    //   246: astore 6
    //   248: aconst_null
    //   249: astore 4
    //   251: iconst_0
    //   252: istore_0
    //   253: aload 4
    //   255: astore 5
    //   257: ldc 148
    //   259: aload 6
    //   261: ldc_w 316
    //   264: iconst_0
    //   265: anewarray 4	java/lang/Object
    //   268: invokestatic 320	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   271: iload_0
    //   272: istore_1
    //   273: aload 4
    //   275: ifnull -55 -> 220
    //   278: aload 4
    //   280: invokeinterface 307 1 0
    //   285: iload_0
    //   286: istore_1
    //   287: goto -67 -> 220
    //   290: astore 4
    //   292: aload 5
    //   294: ifnull +10 -> 304
    //   297: aload 5
    //   299: invokeinterface 307 1 0
    //   304: ldc 221
    //   306: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   309: aload 4
    //   311: athrow
    //   312: astore 4
    //   314: goto -22 -> 292
    //   317: astore 6
    //   319: goto -66 -> 253
    //   322: iconst_0
    //   323: istore_0
    //   324: goto -120 -> 204
    //   327: iconst_0
    //   328: istore_0
    //   329: goto -125 -> 204
    // Local variable table:
    //   start	length	slot	name	signature
    //   169	160	0	i	int
    //   196	91	1	j	int
    //   108	39	2	l	long
    //   9	270	4	localCursor	android.database.Cursor
    //   290	20	4	localObject1	Object
    //   312	1	4	localObject2	Object
    //   6	292	5	localObject3	Object
    //   29	94	6	localObject4	Object
    //   246	14	6	localException1	Exception
    //   317	1	6	localException2	Exception
    //   22	40	7	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   11	117	246	java/lang/Exception
    //   122	163	246	java/lang/Exception
    //   11	117	290	finally
    //   122	163	290	finally
    //   174	184	312	finally
    //   188	197	312	finally
    //   257	271	312	finally
    //   174	184	317	java/lang/Exception
    //   188	197	317	java/lang/Exception
  }
  
  public static boolean ih(Context paramContext)
  {
    AppMethodBeat.i(149356);
    if (com.tencent.mm.compatible.util.d.qW(19))
    {
      Log.i("MicroMsg.Sport.SportUtil", "Not Support SDK VERSION");
      AppMethodBeat.o(149356);
      return false;
    }
    if (!paramContext.getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter"))
    {
      Log.i("MicroMsg.Sport.SportUtil", "Not Support FEATURE_SENSOR_STEP_COUNTER");
      AppMethodBeat.o(149356);
      return false;
    }
    try
    {
      if (((SensorManager)MMApplicationContext.getContext().getSystemService("sensor")).getDefaultSensor(19) == null)
      {
        Log.i("MicroMsg.Sport.SportUtil", "Not Support can not get sensor");
        AppMethodBeat.o(149356);
        return false;
      }
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(149356);
      return false;
    }
    if (k.gaS().optInt("deviceStepSwitch") != 1)
    {
      Log.i("MicroMsg.Sport.SportUtil", "Not Support deviceStepSwitch is off");
      AppMethodBeat.o(149356);
      return false;
    }
    AppMethodBeat.o(149356);
    return true;
  }
  
  public static void l(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(149360);
    if ((Lyp != null) && (Lyp.isShowing()))
    {
      AppMethodBeat.o(149360);
      return;
    }
    m localm = m.Lyn;
    if (m.bv("KEY_SHOW_NOT_SUPPORT_DEVICE_STEP_TIPS", 1L) == 0L)
    {
      AppMethodBeat.o(149360);
      return;
    }
    if ((z.bcZ().equals(paramString)) && (!((com.tencent.mm.plugin.sport.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.sport.a.b.class)).ih(MMApplicationContext.getContext()))) {
      Lyp = com.tencent.mm.ui.widget.a.h.a(paramActivity, b.d.icons_filled_info, paramActivity.getResources().getColor(b.a.Red), MMApplicationContext.getContext().getString(b.e.sport_device_not_support), b.d.icons_outlined_close, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(149350);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          a.c("com/tencent/mm/plugin/sport/model/SportUtil$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramAnonymousView = m.Lyn;
          m.bw("KEY_SHOW_NOT_SUPPORT_DEVICE_STEP_TIPS", 0L);
          a.a(this, "com/tencent/mm/plugin/sport/model/SportUtil$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(149350);
        }
      });
    }
    AppMethodBeat.o(149360);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.n
 * JD-Core Version:    0.7.0.1
 */