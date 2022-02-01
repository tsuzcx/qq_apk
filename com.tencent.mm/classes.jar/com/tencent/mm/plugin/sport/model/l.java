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
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.h.2;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.json.JSONObject;

public final class l
{
  private static o ycq;
  private static final String[] ycr;
  private static final Uri ycs;
  
  static
  {
    AppMethodBeat.i(149364);
    ycr = new String[] { "_id", "_begin_time", "_end_time", "_mode", "_steps" };
    ycs = Uri.parse("content://com.miui.providers.steps/item");
    AppMethodBeat.o(149364);
  }
  
  public static boolean am(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(149354);
    l2 = 3600000L;
    try
    {
      JSONObject localJSONObject = h.dFB().optJSONObject("stepCountUploadConfig");
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
      JSONObject localJSONObject = h.dFB().optJSONObject("stepCountUploadConfig");
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
  
  public static long[] arc(String paramString)
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
  
  public static void cFn()
  {
    AppMethodBeat.i(149361);
    if (ycq != null)
    {
      ycq.dismiss();
      ycq = null;
    }
    AppMethodBeat.o(149361);
  }
  
  public static long dFK()
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
  
  public static int dFL()
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
  
  public static boolean dFM()
  {
    AppMethodBeat.i(149357);
    if (h.dFB().optInt("checkWeSportInstall") != 1)
    {
      ad.i("MicroMsg.Sport.SportUtil", "checkPushInstallWeSport is false");
      AppMethodBeat.o(149357);
      return false;
    }
    AppMethodBeat.o(149357);
    return true;
  }
  
  public static boolean dFN()
  {
    AppMethodBeat.i(149358);
    if (h.dFB().optInt("extStepApiSwitch") != 1)
    {
      ad.i("MicroMsg.Sport.SportUtil", "Not Support extStepApiSwitch is off");
      AppMethodBeat.o(149358);
      return false;
    }
    AppMethodBeat.o(149358);
    return true;
  }
  
  /* Error */
  public static int dFO()
  {
    // Byte code:
    //   0: ldc 177
    //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore 5
    //   8: aconst_null
    //   9: astore 4
    //   11: invokestatic 182	com/tencent/mm/sdk/h/b:eHp	()Z
    //   14: ifeq +310 -> 324
    //   17: ldc 184
    //   19: invokestatic 190	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   22: astore 7
    //   24: aload 7
    //   26: invokevirtual 194	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   29: astore 6
    //   31: aload 7
    //   33: ldc 196
    //   35: iconst_2
    //   36: anewarray 186	java/lang/Class
    //   39: dup
    //   40: iconst_0
    //   41: ldc 23
    //   43: aastore
    //   44: dup
    //   45: iconst_1
    //   46: getstatic 202	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   49: aastore
    //   50: invokevirtual 206	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   53: astore 7
    //   55: aload 7
    //   57: iconst_1
    //   58: invokevirtual 212	java/lang/reflect/Method:setAccessible	(Z)V
    //   61: aload 7
    //   63: aload 6
    //   65: iconst_2
    //   66: anewarray 4	java/lang/Object
    //   69: dup
    //   70: iconst_0
    //   71: ldc 214
    //   73: aastore
    //   74: dup
    //   75: iconst_1
    //   76: getstatic 218	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   79: aastore
    //   80: invokevirtual 222	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   83: astore 6
    //   85: aload 6
    //   87: instanceof 198
    //   90: ifeq +234 -> 324
    //   93: aload 6
    //   95: checkcast 198	java/lang/Boolean
    //   98: invokevirtual 225	java/lang/Boolean:booleanValue	()Z
    //   101: ifeq +223 -> 324
    //   104: invokestatic 227	com/tencent/mm/plugin/sport/model/l:dFK	()J
    //   107: lstore_2
    //   108: invokestatic 233	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   111: invokevirtual 239	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   114: astore 6
    //   116: aload 6
    //   118: ifnull +206 -> 324
    //   121: aload 6
    //   123: getstatic 45	com/tencent/mm/plugin/sport/model/l:ycs	Landroid/net/Uri;
    //   126: getstatic 35	com/tencent/mm/plugin/sport/model/l:ycr	[Ljava/lang/String;
    //   129: ldc 241
    //   131: iconst_2
    //   132: anewarray 23	java/lang/String
    //   135: dup
    //   136: iconst_0
    //   137: lload_2
    //   138: invokestatic 245	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   141: aastore
    //   142: dup
    //   143: iconst_1
    //   144: lload_2
    //   145: ldc2_w 246
    //   148: ladd
    //   149: invokestatic 245	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   152: aastore
    //   153: ldc 249
    //   155: invokevirtual 255	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   158: astore 4
    //   160: aload 4
    //   162: ifnull +157 -> 319
    //   165: iconst_0
    //   166: istore_0
    //   167: aload 4
    //   169: astore 5
    //   171: aload 4
    //   173: invokeinterface 260 1 0
    //   178: ifeq +23 -> 201
    //   181: aload 4
    //   183: astore 5
    //   185: aload 4
    //   187: iconst_4
    //   188: invokeinterface 264 2 0
    //   193: istore_1
    //   194: iload_0
    //   195: iload_1
    //   196: iadd
    //   197: istore_0
    //   198: goto -31 -> 167
    //   201: iload_0
    //   202: istore_1
    //   203: aload 4
    //   205: ifnull +12 -> 217
    //   208: aload 4
    //   210: invokeinterface 267 1 0
    //   215: iload_0
    //   216: istore_1
    //   217: ldc 162
    //   219: ldc_w 269
    //   222: iconst_1
    //   223: anewarray 4	java/lang/Object
    //   226: dup
    //   227: iconst_0
    //   228: iload_1
    //   229: invokestatic 274	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   232: aastore
    //   233: invokestatic 277	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   236: ldc 177
    //   238: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   241: iload_1
    //   242: ireturn
    //   243: astore 6
    //   245: aconst_null
    //   246: astore 4
    //   248: iconst_0
    //   249: istore_0
    //   250: aload 4
    //   252: astore 5
    //   254: ldc 162
    //   256: aload 6
    //   258: ldc_w 279
    //   261: iconst_0
    //   262: anewarray 4	java/lang/Object
    //   265: invokestatic 283	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   268: iload_0
    //   269: istore_1
    //   270: aload 4
    //   272: ifnull -55 -> 217
    //   275: aload 4
    //   277: invokeinterface 267 1 0
    //   282: iload_0
    //   283: istore_1
    //   284: goto -67 -> 217
    //   287: astore 4
    //   289: aload 5
    //   291: ifnull +10 -> 301
    //   294: aload 5
    //   296: invokeinterface 267 1 0
    //   301: ldc 177
    //   303: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   306: aload 4
    //   308: athrow
    //   309: astore 4
    //   311: goto -22 -> 289
    //   314: astore 6
    //   316: goto -66 -> 250
    //   319: iconst_0
    //   320: istore_0
    //   321: goto -120 -> 201
    //   324: iconst_0
    //   325: istore_0
    //   326: goto -125 -> 201
    // Local variable table:
    //   start	length	slot	name	signature
    //   166	160	0	i	int
    //   193	91	1	j	int
    //   107	38	2	l	long
    //   9	267	4	localCursor	android.database.Cursor
    //   287	20	4	localObject1	Object
    //   309	1	4	localObject2	Object
    //   6	289	5	localObject3	Object
    //   29	93	6	localObject4	Object
    //   243	14	6	localException1	Exception
    //   314	1	6	localException2	Exception
    //   22	40	7	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   11	116	243	java/lang/Exception
    //   121	160	243	java/lang/Exception
    //   11	116	287	finally
    //   121	160	287	finally
    //   171	181	309	finally
    //   185	194	309	finally
    //   254	268	309	finally
    //   171	181	314	java/lang/Exception
    //   185	194	314	java/lang/Exception
  }
  
  public static boolean dFj()
  {
    AppMethodBeat.i(149359);
    af localaf = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY("gh_43f2581f6fd6");
    if (localaf != null) {}
    for (boolean bool = com.tencent.mm.n.b.ls(localaf.field_type);; bool = false)
    {
      if (!bool) {
        ad.i("MicroMsg.Sport.SportUtil", "checkUserInstallWeSportPlugin %b", new Object[] { Boolean.valueOf(bool) });
      }
      AppMethodBeat.o(149359);
      return bool;
    }
  }
  
  public static void g(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(149360);
    if ((ycq != null) && (ycq.isShowing()))
    {
      AppMethodBeat.o(149360);
      return;
    }
    if (k.aw(5, 1L) == 0L)
    {
      AppMethodBeat.o(149360);
      return;
    }
    if ((u.aqG().equals(paramString)) && (!((com.tencent.mm.plugin.sport.a.b)g.ab(com.tencent.mm.plugin.sport.a.b.class)).gb(aj.getContext())))
    {
      int i = paramActivity.getResources().getColor(2131099803);
      Object localObject1 = aj.getContext().getString(2131764114);
      paramString = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(149350);
          k.ax(5, 0L);
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
      int k = ap.dL(paramActivity);
      i = j;
      if (j == 0) {
        i = ap.jA(paramActivity);
      }
      ((o)localObject1).showAtLocation(paramActivity.getWindow().getDecorView(), 48, 0, i + k);
      paramActivity = (ImageView)localView.findViewById(2131305900);
      paramActivity.setImageResource(2131690535);
      paramActivity.setOnClickListener(new h.2((o)localObject1, paramString));
      ycq = (o)localObject1;
    }
    AppMethodBeat.o(149360);
  }
  
  public static boolean gb(Context paramContext)
  {
    AppMethodBeat.i(149356);
    if (d.lg(19))
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
    if (h.dFB().optInt("deviceStepSwitch") != 1)
    {
      ad.i("MicroMsg.Sport.SportUtil", "Not Support deviceStepSwitch is off");
      AppMethodBeat.o(149356);
      return false;
    }
    AppMethodBeat.o(149356);
    return true;
  }
  
  public static final String mz(long paramLong)
  {
    AppMethodBeat.i(149353);
    String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(paramLong));
    AppMethodBeat.o(149353);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.l
 * JD-Core Version:    0.7.0.1
 */