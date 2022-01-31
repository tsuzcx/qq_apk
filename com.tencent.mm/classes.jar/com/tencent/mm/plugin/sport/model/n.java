package com.tencent.mm.plugin.sport.model;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.SensorManager;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.sport.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.t;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.json.JSONObject;

public final class n
{
  private static o sqb;
  private static final String[] sqc;
  private static final Uri sqd;
  
  static
  {
    AppMethodBeat.i(93722);
    sqc = new String[] { "_id", "_begin_time", "_end_time", "_mode", "_steps" };
    sqd = Uri.parse("content://com.miui.providers.steps/item");
    AppMethodBeat.o(93722);
  }
  
  public static boolean aa(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(93712);
    l2 = 3600000L;
    try
    {
      JSONObject localJSONObject = h.cyP().optJSONObject("stepCountUploadConfig");
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
      AppMethodBeat.o(93712);
      return true;
    }
    AppMethodBeat.o(93712);
    return false;
  }
  
  public static boolean ab(long paramLong1, long paramLong2)
  {
    j = 500;
    AppMethodBeat.i(93713);
    if ((paramLong1 == 0L) && (paramLong2 > 0L))
    {
      AppMethodBeat.o(93713);
      return true;
    }
    try
    {
      JSONObject localJSONObject = h.cyP().optJSONObject("stepCountUploadConfig");
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
      AppMethodBeat.o(93713);
      return true;
    }
    AppMethodBeat.o(93713);
    return false;
  }
  
  public static long[] acz(String paramString)
  {
    AppMethodBeat.i(93720);
    paramString = paramString.split(",");
    long[] arrayOfLong = new long[paramString.length];
    arrayOfLong[0] = bo.getLong(paramString[0], 0L);
    arrayOfLong[1] = bo.getLong(paramString[1], 0L);
    arrayOfLong[2] = bo.getLong(paramString[2], 0L);
    arrayOfLong[3] = bo.getLong(paramString[3], 0L);
    arrayOfLong[4] = bo.getLong(paramString[4], 0L);
    arrayOfLong[5] = bo.getLong(paramString[5], 0L);
    arrayOfLong[6] = bo.getLong(paramString[6], 0L);
    AppMethodBeat.o(93720);
    return arrayOfLong;
  }
  
  public static long cyY()
  {
    AppMethodBeat.i(93709);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    long l = localCalendar.getTimeInMillis();
    AppMethodBeat.o(93709);
    return l;
  }
  
  public static int cyZ()
  {
    AppMethodBeat.i(93710);
    TimeZone localTimeZone = TimeZone.getDefault();
    int j = localTimeZone.getRawOffset() / 1000;
    if ((localTimeZone.useDaylightTime()) && (localTimeZone.inDaylightTime(new Date(System.currentTimeMillis())))) {}
    for (int i = 1;; i = 0)
    {
      j /= 3600;
      AppMethodBeat.o(93710);
      return i + j;
    }
  }
  
  public static boolean cyu()
  {
    AppMethodBeat.i(93717);
    ad localad = ((j)g.E(j.class)).YA().arw("gh_43f2581f6fd6");
    if (localad != null) {}
    for (boolean bool = a.je(localad.field_type);; bool = false)
    {
      if (!bool) {
        ab.i("MicroMsg.Sport.SportUtil", "checkUserInstallWeSportPlugin %b", new Object[] { Boolean.valueOf(bool) });
      }
      AppMethodBeat.o(93717);
      return bool;
    }
  }
  
  public static boolean cza()
  {
    AppMethodBeat.i(93715);
    if (h.cyP().optInt("checkWeSportInstall") != 1)
    {
      ab.i("MicroMsg.Sport.SportUtil", "checkPushInstallWeSport is false");
      AppMethodBeat.o(93715);
      return false;
    }
    AppMethodBeat.o(93715);
    return true;
  }
  
  public static boolean czb()
  {
    AppMethodBeat.i(93716);
    if (h.cyP().optInt("extStepApiSwitch") != 1)
    {
      ab.i("MicroMsg.Sport.SportUtil", "Not Support extStepApiSwitch is off");
      AppMethodBeat.o(93716);
      return false;
    }
    AppMethodBeat.o(93716);
    return true;
  }
  
  public static void czc()
  {
    AppMethodBeat.i(93719);
    if (sqb != null)
    {
      sqb.dismiss();
      sqb = null;
    }
    AppMethodBeat.o(93719);
  }
  
  /* Error */
  public static int czd()
  {
    // Byte code:
    //   0: ldc 220
    //   2: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore 5
    //   8: aconst_null
    //   9: astore 4
    //   11: invokestatic 225	com/tencent/mm/sdk/h/b:duO	()Z
    //   14: ifeq +312 -> 326
    //   17: ldc 227
    //   19: invokestatic 233	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   22: astore 7
    //   24: aload 7
    //   26: invokevirtual 237	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   29: astore 6
    //   31: aload 7
    //   33: ldc 239
    //   35: iconst_2
    //   36: anewarray 229	java/lang/Class
    //   39: dup
    //   40: iconst_0
    //   41: ldc 21
    //   43: aastore
    //   44: dup
    //   45: iconst_1
    //   46: getstatic 243	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   49: aastore
    //   50: invokevirtual 247	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   53: astore 7
    //   55: aload 7
    //   57: iconst_1
    //   58: invokevirtual 253	java/lang/reflect/Method:setAccessible	(Z)V
    //   61: aload 7
    //   63: aload 6
    //   65: iconst_2
    //   66: anewarray 4	java/lang/Object
    //   69: dup
    //   70: iconst_0
    //   71: ldc 255
    //   73: aastore
    //   74: dup
    //   75: iconst_1
    //   76: getstatic 259	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   79: aastore
    //   80: invokevirtual 263	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   83: astore 6
    //   85: aload 6
    //   87: instanceof 182
    //   90: ifeq +236 -> 326
    //   93: aload 6
    //   95: checkcast 182	java/lang/Boolean
    //   98: invokevirtual 266	java/lang/Boolean:booleanValue	()Z
    //   101: ifeq +225 -> 326
    //   104: invokestatic 268	com/tencent/mm/plugin/sport/model/n:cyY	()J
    //   107: lstore_2
    //   108: invokestatic 274	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   111: invokevirtual 280	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   114: astore 6
    //   116: aload 6
    //   118: ifnull +208 -> 326
    //   121: aload 6
    //   123: getstatic 43	com/tencent/mm/plugin/sport/model/n:sqd	Landroid/net/Uri;
    //   126: getstatic 33	com/tencent/mm/plugin/sport/model/n:sqc	[Ljava/lang/String;
    //   129: ldc_w 282
    //   132: iconst_2
    //   133: anewarray 21	java/lang/String
    //   136: dup
    //   137: iconst_0
    //   138: lload_2
    //   139: invokestatic 285	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   142: aastore
    //   143: dup
    //   144: iconst_1
    //   145: lload_2
    //   146: ldc2_w 286
    //   149: ladd
    //   150: invokestatic 285	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   153: aastore
    //   154: ldc_w 289
    //   157: invokevirtual 295	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   160: astore 4
    //   162: aload 4
    //   164: ifnull +157 -> 321
    //   167: iconst_0
    //   168: istore_0
    //   169: aload 4
    //   171: astore 5
    //   173: aload 4
    //   175: invokeinterface 300 1 0
    //   180: ifeq +23 -> 203
    //   183: aload 4
    //   185: astore 5
    //   187: aload 4
    //   189: iconst_4
    //   190: invokeinterface 304 2 0
    //   195: istore_1
    //   196: iload_0
    //   197: iload_1
    //   198: iadd
    //   199: istore_0
    //   200: goto -31 -> 169
    //   203: iload_0
    //   204: istore_1
    //   205: aload 4
    //   207: ifnull +12 -> 219
    //   210: aload 4
    //   212: invokeinterface 307 1 0
    //   217: iload_0
    //   218: istore_1
    //   219: ldc 178
    //   221: ldc_w 309
    //   224: iconst_1
    //   225: anewarray 4	java/lang/Object
    //   228: dup
    //   229: iconst_0
    //   230: iload_1
    //   231: invokestatic 314	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   234: aastore
    //   235: invokestatic 191	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   238: ldc 220
    //   240: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   243: iload_1
    //   244: ireturn
    //   245: astore 6
    //   247: aconst_null
    //   248: astore 4
    //   250: iconst_0
    //   251: istore_0
    //   252: aload 4
    //   254: astore 5
    //   256: ldc 178
    //   258: aload 6
    //   260: ldc_w 316
    //   263: iconst_0
    //   264: anewarray 4	java/lang/Object
    //   267: invokestatic 320	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   270: iload_0
    //   271: istore_1
    //   272: aload 4
    //   274: ifnull -55 -> 219
    //   277: aload 4
    //   279: invokeinterface 307 1 0
    //   284: iload_0
    //   285: istore_1
    //   286: goto -67 -> 219
    //   289: astore 4
    //   291: aload 5
    //   293: ifnull +10 -> 303
    //   296: aload 5
    //   298: invokeinterface 307 1 0
    //   303: ldc 220
    //   305: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   308: aload 4
    //   310: athrow
    //   311: astore 4
    //   313: goto -22 -> 291
    //   316: astore 6
    //   318: goto -66 -> 252
    //   321: iconst_0
    //   322: istore_0
    //   323: goto -120 -> 203
    //   326: iconst_0
    //   327: istore_0
    //   328: goto -125 -> 203
    // Local variable table:
    //   start	length	slot	name	signature
    //   168	160	0	i	int
    //   195	91	1	j	int
    //   107	39	2	l	long
    //   9	269	4	localCursor	android.database.Cursor
    //   289	20	4	localObject1	Object
    //   311	1	4	localObject2	Object
    //   6	291	5	localObject3	Object
    //   29	93	6	localObject4	Object
    //   245	14	6	localException1	Exception
    //   316	1	6	localException2	Exception
    //   22	40	7	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   11	116	245	java/lang/Exception
    //   121	162	245	java/lang/Exception
    //   11	116	289	finally
    //   121	162	289	finally
    //   173	183	311	finally
    //   187	196	311	finally
    //   256	270	311	finally
    //   173	183	316	java/lang/Exception
    //   187	196	316	java/lang/Exception
  }
  
  public static void f(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(93718);
    if ((sqb != null) && (sqb.isShowing()))
    {
      AppMethodBeat.o(93718);
      return;
    }
    if (k.ae(5, 1L) == 0L)
    {
      AppMethodBeat.o(93718);
      return;
    }
    if ((r.Zn().equals(paramString)) && (!((b)g.E(b.class)).fa(ah.getContext()))) {
      sqb = t.a(paramActivity, ah.getContext().getString(2131304082), new n.1());
    }
    AppMethodBeat.o(93718);
  }
  
  public static boolean fa(Context paramContext)
  {
    AppMethodBeat.i(93714);
    if (d.fw(19))
    {
      ab.i("MicroMsg.Sport.SportUtil", "Not Support SDK VERSION");
      AppMethodBeat.o(93714);
      return false;
    }
    if (!paramContext.getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter"))
    {
      ab.i("MicroMsg.Sport.SportUtil", "Not Support FEATURE_SENSOR_STEP_COUNTER");
      AppMethodBeat.o(93714);
      return false;
    }
    if (((SensorManager)ah.getContext().getSystemService("sensor")).getDefaultSensor(19) == null)
    {
      ab.i("MicroMsg.Sport.SportUtil", "Not Support can not get sensor");
      AppMethodBeat.o(93714);
      return false;
    }
    if (h.cyP().optInt("deviceStepSwitch") != 1)
    {
      ab.i("MicroMsg.Sport.SportUtil", "Not Support deviceStepSwitch is off");
      AppMethodBeat.o(93714);
      return false;
    }
    AppMethodBeat.o(93714);
    return true;
  }
  
  public static final String ha(long paramLong)
  {
    AppMethodBeat.i(93711);
    String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(paramLong));
    AppMethodBeat.o(93711);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.n
 * JD-Core Version:    0.7.0.1
 */