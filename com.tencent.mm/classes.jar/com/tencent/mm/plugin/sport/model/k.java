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
import com.tencent.mm.contact.c;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.a.h.2;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.json.JSONObject;

public final class k
{
  private static p FjK;
  private static final String[] FjL;
  private static final Uri FjM;
  
  static
  {
    AppMethodBeat.i(149364);
    FjL = new String[] { "_id", "_begin_time", "_end_time", "_mode", "_steps" };
    FjM = Uri.parse("content://com.miui.providers.steps/item");
    AppMethodBeat.o(149364);
  }
  
  public static final String AF(long paramLong)
  {
    AppMethodBeat.i(149353);
    String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(paramLong));
    AppMethodBeat.o(149353);
    return str;
  }
  
  public static long[] aRG(String paramString)
  {
    AppMethodBeat.i(149362);
    paramString = paramString.split(",");
    long[] arrayOfLong = new long[paramString.length];
    arrayOfLong[0] = Util.getLong(paramString[0], 0L);
    arrayOfLong[1] = Util.getLong(paramString[1], 0L);
    arrayOfLong[2] = Util.getLong(paramString[2], 0L);
    arrayOfLong[3] = Util.getLong(paramString[3], 0L);
    arrayOfLong[4] = Util.getLong(paramString[4], 0L);
    arrayOfLong[5] = Util.getLong(paramString[5], 0L);
    arrayOfLong[6] = Util.getLong(paramString[6], 0L);
    AppMethodBeat.o(149362);
    return arrayOfLong;
  }
  
  public static boolean ar(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(149354);
    l2 = 3600000L;
    try
    {
      JSONObject localJSONObject = g.fmy().optJSONObject("stepCountUploadConfig");
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
  
  public static boolean as(long paramLong1, long paramLong2)
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
      JSONObject localJSONObject = g.fmy().optJSONObject("stepCountUploadConfig");
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
  
  public static void dYf()
  {
    AppMethodBeat.i(149361);
    if (FjK != null)
    {
      FjK.dismiss();
      FjK = null;
    }
    AppMethodBeat.o(149361);
  }
  
  public static long fmH()
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
  
  public static int fmI()
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
  
  public static boolean fmJ()
  {
    AppMethodBeat.i(149357);
    if (g.fmy().optInt("checkWeSportInstall") != 1)
    {
      Log.i("MicroMsg.Sport.SportUtil", "checkPushInstallWeSport is false");
      AppMethodBeat.o(149357);
      return false;
    }
    AppMethodBeat.o(149357);
    return true;
  }
  
  public static boolean fmK()
  {
    AppMethodBeat.i(149358);
    if (g.fmy().optInt("extStepApiSwitch") != 1)
    {
      Log.i("MicroMsg.Sport.SportUtil", "Not Support extStepApiSwitch is off");
      AppMethodBeat.o(149358);
      return false;
    }
    AppMethodBeat.o(149358);
    return true;
  }
  
  /* Error */
  public static int fmL()
  {
    // Byte code:
    //   0: ldc 191
    //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore 5
    //   8: aconst_null
    //   9: astore 4
    //   11: invokestatic 196	com/tencent/mm/sdk/vendor/MIUI:ifMIUI	()Z
    //   14: ifeq +311 -> 325
    //   17: ldc 198
    //   19: invokestatic 204	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   22: astore 7
    //   24: aload 7
    //   26: invokevirtual 208	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   29: astore 6
    //   31: aload 7
    //   33: ldc 210
    //   35: iconst_2
    //   36: anewarray 200	java/lang/Class
    //   39: dup
    //   40: iconst_0
    //   41: ldc 23
    //   43: aastore
    //   44: dup
    //   45: iconst_1
    //   46: getstatic 216	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   49: aastore
    //   50: invokevirtual 220	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   53: astore 7
    //   55: aload 7
    //   57: iconst_1
    //   58: invokevirtual 226	java/lang/reflect/Method:setAccessible	(Z)V
    //   61: aload 7
    //   63: aload 6
    //   65: iconst_2
    //   66: anewarray 4	java/lang/Object
    //   69: dup
    //   70: iconst_0
    //   71: ldc 228
    //   73: aastore
    //   74: dup
    //   75: iconst_1
    //   76: getstatic 232	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   79: aastore
    //   80: invokevirtual 236	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   83: astore 6
    //   85: aload 6
    //   87: instanceof 212
    //   90: ifeq +235 -> 325
    //   93: aload 6
    //   95: checkcast 212	java/lang/Boolean
    //   98: invokevirtual 239	java/lang/Boolean:booleanValue	()Z
    //   101: ifeq +224 -> 325
    //   104: invokestatic 241	com/tencent/mm/plugin/sport/model/k:fmH	()J
    //   107: lstore_2
    //   108: invokestatic 247	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   111: invokevirtual 253	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   114: astore 6
    //   116: aload 6
    //   118: ifnull +207 -> 325
    //   121: aload 6
    //   123: getstatic 45	com/tencent/mm/plugin/sport/model/k:FjM	Landroid/net/Uri;
    //   126: getstatic 35	com/tencent/mm/plugin/sport/model/k:FjL	[Ljava/lang/String;
    //   129: ldc 255
    //   131: iconst_2
    //   132: anewarray 23	java/lang/String
    //   135: dup
    //   136: iconst_0
    //   137: lload_2
    //   138: invokestatic 258	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   141: aastore
    //   142: dup
    //   143: iconst_1
    //   144: lload_2
    //   145: ldc2_w 259
    //   148: ladd
    //   149: invokestatic 258	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   152: aastore
    //   153: ldc_w 262
    //   156: invokevirtual 268	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   159: astore 4
    //   161: aload 4
    //   163: ifnull +157 -> 320
    //   166: iconst_0
    //   167: istore_0
    //   168: aload 4
    //   170: astore 5
    //   172: aload 4
    //   174: invokeinterface 273 1 0
    //   179: ifeq +23 -> 202
    //   182: aload 4
    //   184: astore 5
    //   186: aload 4
    //   188: iconst_4
    //   189: invokeinterface 277 2 0
    //   194: istore_1
    //   195: iload_0
    //   196: iload_1
    //   197: iadd
    //   198: istore_0
    //   199: goto -31 -> 168
    //   202: iload_0
    //   203: istore_1
    //   204: aload 4
    //   206: ifnull +12 -> 218
    //   209: aload 4
    //   211: invokeinterface 280 1 0
    //   216: iload_0
    //   217: istore_1
    //   218: ldc 176
    //   220: ldc_w 282
    //   223: iconst_1
    //   224: anewarray 4	java/lang/Object
    //   227: dup
    //   228: iconst_0
    //   229: iload_1
    //   230: invokestatic 287	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   233: aastore
    //   234: invokestatic 290	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   237: ldc 191
    //   239: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   242: iload_1
    //   243: ireturn
    //   244: astore 6
    //   246: aconst_null
    //   247: astore 4
    //   249: iconst_0
    //   250: istore_0
    //   251: aload 4
    //   253: astore 5
    //   255: ldc 176
    //   257: aload 6
    //   259: ldc_w 292
    //   262: iconst_0
    //   263: anewarray 4	java/lang/Object
    //   266: invokestatic 296	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   269: iload_0
    //   270: istore_1
    //   271: aload 4
    //   273: ifnull -55 -> 218
    //   276: aload 4
    //   278: invokeinterface 280 1 0
    //   283: iload_0
    //   284: istore_1
    //   285: goto -67 -> 218
    //   288: astore 4
    //   290: aload 5
    //   292: ifnull +10 -> 302
    //   295: aload 5
    //   297: invokeinterface 280 1 0
    //   302: ldc 191
    //   304: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   307: aload 4
    //   309: athrow
    //   310: astore 4
    //   312: goto -22 -> 290
    //   315: astore 6
    //   317: goto -66 -> 251
    //   320: iconst_0
    //   321: istore_0
    //   322: goto -120 -> 202
    //   325: iconst_0
    //   326: istore_0
    //   327: goto -125 -> 202
    // Local variable table:
    //   start	length	slot	name	signature
    //   167	160	0	i	int
    //   194	91	1	j	int
    //   107	38	2	l	long
    //   9	268	4	localCursor	android.database.Cursor
    //   288	20	4	localObject1	Object
    //   310	1	4	localObject2	Object
    //   6	290	5	localObject3	Object
    //   29	93	6	localObject4	Object
    //   244	14	6	localException1	Exception
    //   315	1	6	localException2	Exception
    //   22	40	7	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   11	116	244	java/lang/Exception
    //   121	161	244	java/lang/Exception
    //   11	116	288	finally
    //   121	161	288	finally
    //   172	182	310	finally
    //   186	195	310	finally
    //   255	269	310	finally
    //   172	182	315	java/lang/Exception
    //   186	195	315	java/lang/Exception
  }
  
  public static boolean fmg()
  {
    AppMethodBeat.i(149359);
    as localas = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn("gh_43f2581f6fd6");
    if (localas != null) {}
    for (boolean bool = c.oR(localas.field_type);; bool = false)
    {
      if (!bool) {
        Log.i("MicroMsg.Sport.SportUtil", "checkUserInstallWeSportPlugin %b", new Object[] { Boolean.valueOf(bool) });
      }
      AppMethodBeat.o(149359);
      return bool;
    }
  }
  
  public static boolean hg(Context paramContext)
  {
    AppMethodBeat.i(149356);
    if (d.oE(19))
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
    if (g.fmy().optInt("deviceStepSwitch") != 1)
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
    if ((FjK != null) && (FjK.isShowing()))
    {
      AppMethodBeat.o(149360);
      return;
    }
    if (j.aJ(5, 1L) == 0L)
    {
      AppMethodBeat.o(149360);
      return;
    }
    if ((z.aTY().equals(paramString)) && (!((com.tencent.mm.plugin.sport.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.sport.a.b.class)).hg(MMApplicationContext.getContext())))
    {
      int i = paramActivity.getResources().getColor(2131099818);
      Object localObject1 = MMApplicationContext.getContext().getString(2131766362);
      paramString = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(149350);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/plugin/sport/model/SportUtil$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          j.aK(5, 0L);
          a.a(this, "com/tencent/mm/plugin/sport/model/SportUtil$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(149350);
        }
      };
      View localView = View.inflate(paramActivity, 2131496719, null);
      ((LinearLayout)localView.findViewById(2131297331)).setBackgroundResource(2131235311);
      Object localObject2 = (TextView)localView.findViewById(2131309194);
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((TextView)localObject2).setOnClickListener(null);
      localObject1 = (WeImageView)localView.findViewById(2131309192);
      ((WeImageView)localObject1).setImageResource(2131690574);
      ((WeImageView)localObject1).setIconColor(i);
      localObject1 = new p(localView);
      ((p)localObject1).setWidth(-1);
      ((p)localObject1).setHeight(-2);
      localObject2 = new Rect();
      paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject2);
      int j = ((Rect)localObject2).top;
      int k = au.eu(paramActivity);
      i = j;
      if (j == 0) {
        i = au.ay(paramActivity);
      }
      ((p)localObject1).showAtLocation(paramActivity.getWindow().getDecorView(), 48, 0, i + k);
      paramActivity = (ImageView)localView.findViewById(2131309193);
      paramActivity.setImageResource(2131690761);
      paramActivity.setOnClickListener(new h.2((p)localObject1, paramString));
      FjK = (p)localObject1;
    }
    AppMethodBeat.o(149360);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.k
 * JD-Core Version:    0.7.0.1
 */