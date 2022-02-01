package com.tencent.mm.plugin.sport.model;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Rect;
import android.hardware.SensorManager;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.h.1;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.json.JSONObject;

public final class l
{
  private static o AHk;
  private static final String[] AHl;
  private static final Uri AHm;
  
  static
  {
    AppMethodBeat.i(149364);
    AHl = new String[] { "_id", "_begin_time", "_end_time", "_mode", "_steps" };
    AHm = Uri.parse("content://com.miui.providers.steps/item");
    AppMethodBeat.o(149364);
  }
  
  public static long[] aBr(String paramString)
  {
    AppMethodBeat.i(149362);
    paramString = paramString.split(",");
    long[] arrayOfLong = new long[paramString.length];
    arrayOfLong[0] = bt.getLong(paramString[0], 0L);
    arrayOfLong[1] = bt.getLong(paramString[1], 0L);
    arrayOfLong[2] = bt.getLong(paramString[2], 0L);
    arrayOfLong[3] = bt.getLong(paramString[3], 0L);
    arrayOfLong[4] = bt.getLong(paramString[4], 0L);
    arrayOfLong[5] = bt.getLong(paramString[5], 0L);
    arrayOfLong[6] = bt.getLong(paramString[6], 0L);
    AppMethodBeat.o(149362);
    return arrayOfLong;
  }
  
  public static boolean am(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(149354);
    l2 = 3600000L;
    try
    {
      JSONObject localJSONObject = h.egq().optJSONObject("stepCountUploadConfig");
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
  
  public static boolean an(long paramLong1, long paramLong2)
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
      JSONObject localJSONObject = h.egq().optJSONObject("stepCountUploadConfig");
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
  
  public static void dbE()
  {
    AppMethodBeat.i(149361);
    if (AHk != null)
    {
      AHk.dismiss();
      AHk = null;
    }
    AppMethodBeat.o(149361);
  }
  
  public static boolean efY()
  {
    AppMethodBeat.i(149359);
    am localam = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf("gh_43f2581f6fd6");
    if (localam != null) {}
    for (boolean bool = com.tencent.mm.o.b.lM(localam.field_type);; bool = false)
    {
      if (!bool) {
        ad.i("MicroMsg.Sport.SportUtil", "checkUserInstallWeSportPlugin %b", new Object[] { Boolean.valueOf(bool) });
      }
      AppMethodBeat.o(149359);
      return bool;
    }
  }
  
  public static int egA()
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
  
  public static boolean egB()
  {
    AppMethodBeat.i(149357);
    if (h.egq().optInt("checkWeSportInstall") != 1)
    {
      ad.i("MicroMsg.Sport.SportUtil", "checkPushInstallWeSport is false");
      AppMethodBeat.o(149357);
      return false;
    }
    AppMethodBeat.o(149357);
    return true;
  }
  
  public static boolean egC()
  {
    AppMethodBeat.i(149358);
    if (h.egq().optInt("extStepApiSwitch") != 1)
    {
      ad.i("MicroMsg.Sport.SportUtil", "Not Support extStepApiSwitch is off");
      AppMethodBeat.o(149358);
      return false;
    }
    AppMethodBeat.o(149358);
    return true;
  }
  
  /* Error */
  public static int egD()
  {
    // Byte code:
    //   0: ldc 207
    //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore 5
    //   8: aconst_null
    //   9: astore 4
    //   11: invokestatic 212	com/tencent/mm/sdk/h/b:fmu	()Z
    //   14: ifeq +312 -> 326
    //   17: ldc 214
    //   19: invokestatic 220	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   22: astore 7
    //   24: aload 7
    //   26: invokevirtual 224	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   29: astore 6
    //   31: aload 7
    //   33: ldc 226
    //   35: iconst_2
    //   36: anewarray 216	java/lang/Class
    //   39: dup
    //   40: iconst_0
    //   41: ldc 23
    //   43: aastore
    //   44: dup
    //   45: iconst_1
    //   46: getstatic 230	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   49: aastore
    //   50: invokevirtual 234	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   53: astore 7
    //   55: aload 7
    //   57: iconst_1
    //   58: invokevirtual 240	java/lang/reflect/Method:setAccessible	(Z)V
    //   61: aload 7
    //   63: aload 6
    //   65: iconst_2
    //   66: anewarray 4	java/lang/Object
    //   69: dup
    //   70: iconst_0
    //   71: ldc 242
    //   73: aastore
    //   74: dup
    //   75: iconst_1
    //   76: getstatic 246	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   79: aastore
    //   80: invokevirtual 250	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   83: astore 6
    //   85: aload 6
    //   87: instanceof 147
    //   90: ifeq +236 -> 326
    //   93: aload 6
    //   95: checkcast 147	java/lang/Boolean
    //   98: invokevirtual 253	java/lang/Boolean:booleanValue	()Z
    //   101: ifeq +225 -> 326
    //   104: invokestatic 256	com/tencent/mm/plugin/sport/model/l:egz	()J
    //   107: lstore_2
    //   108: invokestatic 262	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   111: invokevirtual 268	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   114: astore 6
    //   116: aload 6
    //   118: ifnull +208 -> 326
    //   121: aload 6
    //   123: getstatic 45	com/tencent/mm/plugin/sport/model/l:AHm	Landroid/net/Uri;
    //   126: getstatic 35	com/tencent/mm/plugin/sport/model/l:AHl	[Ljava/lang/String;
    //   129: ldc_w 270
    //   132: iconst_2
    //   133: anewarray 23	java/lang/String
    //   136: dup
    //   137: iconst_0
    //   138: lload_2
    //   139: invokestatic 273	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   142: aastore
    //   143: dup
    //   144: iconst_1
    //   145: lload_2
    //   146: ldc2_w 274
    //   149: ladd
    //   150: invokestatic 273	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   153: aastore
    //   154: ldc_w 277
    //   157: invokevirtual 283	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   160: astore 4
    //   162: aload 4
    //   164: ifnull +157 -> 321
    //   167: iconst_0
    //   168: istore_0
    //   169: aload 4
    //   171: astore 5
    //   173: aload 4
    //   175: invokeinterface 288 1 0
    //   180: ifeq +23 -> 203
    //   183: aload 4
    //   185: astore 5
    //   187: aload 4
    //   189: iconst_4
    //   190: invokeinterface 292 2 0
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
    //   212: invokeinterface 295 1 0
    //   217: iload_0
    //   218: istore_1
    //   219: ldc 143
    //   221: ldc_w 297
    //   224: iconst_1
    //   225: anewarray 4	java/lang/Object
    //   228: dup
    //   229: iconst_0
    //   230: iload_1
    //   231: invokestatic 302	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   234: aastore
    //   235: invokestatic 156	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   238: ldc 207
    //   240: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   243: iload_1
    //   244: ireturn
    //   245: astore 6
    //   247: aconst_null
    //   248: astore 4
    //   250: iconst_0
    //   251: istore_0
    //   252: aload 4
    //   254: astore 5
    //   256: ldc 143
    //   258: aload 6
    //   260: ldc_w 304
    //   263: iconst_0
    //   264: anewarray 4	java/lang/Object
    //   267: invokestatic 308	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   270: iload_0
    //   271: istore_1
    //   272: aload 4
    //   274: ifnull -55 -> 219
    //   277: aload 4
    //   279: invokeinterface 295 1 0
    //   284: iload_0
    //   285: istore_1
    //   286: goto -67 -> 219
    //   289: astore 4
    //   291: aload 5
    //   293: ifnull +10 -> 303
    //   296: aload 5
    //   298: invokeinterface 295 1 0
    //   303: ldc 207
    //   305: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static long egz()
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
  
  public static void g(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(149360);
    if ((AHk != null) && (AHk.isShowing()))
    {
      AppMethodBeat.o(149360);
      return;
    }
    if (k.aC(5, 1L) == 0L)
    {
      AppMethodBeat.o(149360);
      return;
    }
    if ((u.aAm().equals(paramString)) && (!((com.tencent.mm.plugin.sport.a.b)g.ab(com.tencent.mm.plugin.sport.a.b.class)).gq(aj.getContext())))
    {
      int i = paramActivity.getResources().getColor(2131099803);
      Object localObject1 = aj.getContext().getString(2131764114);
      paramString = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(149350);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/plugin/sport/model/SportUtil$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          k.aD(5, 0L);
          a.a(this, "com/tencent/mm/plugin/sport/model/SportUtil$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(149350);
        }
      };
      View localView = View.inflate(paramActivity, 2131495761, null);
      ((LinearLayout)localView.findViewById(2131307152)).setBackgroundResource(2131234388);
      Object localObject2 = (TextView)localView.findViewById(2131305901);
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((TextView)localObject2).setOnClickListener(null);
      localObject1 = (WeImageView)localView.findViewById(2131305899);
      ((WeImageView)localObject1).setImageResource(2131690416);
      ((WeImageView)localObject1).setIconColor(i);
      localObject1 = new o(localView);
      ((o)localObject1).setWidth(-1);
      ((o)localObject1).setHeight(-2);
      localObject2 = new Rect();
      paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject2);
      int j = ((Rect)localObject2).top;
      int k = ar.dT(paramActivity);
      i = j;
      if (j == 0) {
        i = ar.jW(paramActivity);
      }
      ((o)localObject1).showAtLocation(paramActivity.getWindow().getDecorView(), 48, 0, i + k);
      paramActivity = (ImageView)localView.findViewById(2131305900);
      paramActivity.setImageResource(2131690535);
      paramActivity.setOnClickListener(new h.1((o)localObject1, paramString));
      AHk = (o)localObject1;
    }
    AppMethodBeat.o(149360);
  }
  
  public static boolean gq(Context paramContext)
  {
    AppMethodBeat.i(149356);
    if (d.lz(19))
    {
      ad.i("MicroMsg.Sport.SportUtil", "Not Support SDK VERSION");
      AppMethodBeat.o(149356);
      return false;
    }
    if (!paramContext.getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter"))
    {
      ad.i("MicroMsg.Sport.SportUtil", "Not Support FEATURE_SENSOR_STEP_COUNTER");
      AppMethodBeat.o(149356);
      return false;
    }
    if (((SensorManager)aj.getContext().getSystemService("sensor")).getDefaultSensor(19) == null)
    {
      ad.i("MicroMsg.Sport.SportUtil", "Not Support can not get sensor");
      AppMethodBeat.o(149356);
      return false;
    }
    if (h.egq().optInt("deviceStepSwitch") != 1)
    {
      ad.i("MicroMsg.Sport.SportUtil", "Not Support deviceStepSwitch is off");
      AppMethodBeat.o(149356);
      return false;
    }
    AppMethodBeat.o(149356);
    return true;
  }
  
  public static final String sm(long paramLong)
  {
    AppMethodBeat.i(149353);
    String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(paramLong));
    AppMethodBeat.o(149353);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.l
 * JD-Core Version:    0.7.0.1
 */