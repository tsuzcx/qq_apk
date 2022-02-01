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
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.ap;
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
  private static o zpq;
  private static final String[] zpr;
  private static final Uri zps;
  
  static
  {
    AppMethodBeat.i(149364);
    zpr = new String[] { "_id", "_begin_time", "_end_time", "_mode", "_steps" };
    zps = Uri.parse("content://com.miui.providers.steps/item");
    AppMethodBeat.o(149364);
  }
  
  public static boolean aj(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(149354);
    l2 = 3600000L;
    try
    {
      JSONObject localJSONObject = h.dUc().optJSONObject("stepCountUploadConfig");
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
  
  public static boolean ak(long paramLong1, long paramLong2)
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
      JSONObject localJSONObject = h.dUc().optJSONObject("stepCountUploadConfig");
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
  
  public static long[] awl(String paramString)
  {
    AppMethodBeat.i(149362);
    paramString = paramString.split(",");
    long[] arrayOfLong = new long[paramString.length];
    arrayOfLong[0] = bs.getLong(paramString[0], 0L);
    arrayOfLong[1] = bs.getLong(paramString[1], 0L);
    arrayOfLong[2] = bs.getLong(paramString[2], 0L);
    arrayOfLong[3] = bs.getLong(paramString[3], 0L);
    arrayOfLong[4] = bs.getLong(paramString[4], 0L);
    arrayOfLong[5] = bs.getLong(paramString[5], 0L);
    arrayOfLong[6] = bs.getLong(paramString[6], 0L);
    AppMethodBeat.o(149362);
    return arrayOfLong;
  }
  
  public static void cSx()
  {
    AppMethodBeat.i(149361);
    if (zpq != null)
    {
      zpq.dismiss();
      zpq = null;
    }
    AppMethodBeat.o(149361);
  }
  
  public static boolean dTK()
  {
    AppMethodBeat.i(149359);
    com.tencent.mm.storage.ai localai = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt("gh_43f2581f6fd6");
    if (localai != null) {}
    for (boolean bool = com.tencent.mm.n.b.ln(localai.field_type);; bool = false)
    {
      if (!bool) {
        ac.i("MicroMsg.Sport.SportUtil", "checkUserInstallWeSportPlugin %b", new Object[] { Boolean.valueOf(bool) });
      }
      AppMethodBeat.o(149359);
      return bool;
    }
  }
  
  public static long dUl()
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
  
  public static int dUm()
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
  
  public static boolean dUn()
  {
    AppMethodBeat.i(149357);
    if (h.dUc().optInt("checkWeSportInstall") != 1)
    {
      ac.i("MicroMsg.Sport.SportUtil", "checkPushInstallWeSport is false");
      AppMethodBeat.o(149357);
      return false;
    }
    AppMethodBeat.o(149357);
    return true;
  }
  
  public static boolean dUo()
  {
    AppMethodBeat.i(149358);
    if (h.dUc().optInt("extStepApiSwitch") != 1)
    {
      ac.i("MicroMsg.Sport.SportUtil", "Not Support extStepApiSwitch is off");
      AppMethodBeat.o(149358);
      return false;
    }
    AppMethodBeat.o(149358);
    return true;
  }
  
  /* Error */
  public static int dUp()
  {
    // Byte code:
    //   0: ldc 222
    //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore 5
    //   8: aconst_null
    //   9: astore 4
    //   11: invokestatic 227	com/tencent/mm/sdk/h/b:eWK	()Z
    //   14: ifeq +313 -> 327
    //   17: ldc 229
    //   19: invokestatic 235	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   22: astore 7
    //   24: aload 7
    //   26: invokevirtual 239	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   29: astore 6
    //   31: aload 7
    //   33: ldc 241
    //   35: iconst_2
    //   36: anewarray 231	java/lang/Class
    //   39: dup
    //   40: iconst_0
    //   41: ldc 23
    //   43: aastore
    //   44: dup
    //   45: iconst_1
    //   46: getstatic 245	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   49: aastore
    //   50: invokevirtual 249	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   53: astore 7
    //   55: aload 7
    //   57: iconst_1
    //   58: invokevirtual 255	java/lang/reflect/Method:setAccessible	(Z)V
    //   61: aload 7
    //   63: aload 6
    //   65: iconst_2
    //   66: anewarray 4	java/lang/Object
    //   69: dup
    //   70: iconst_0
    //   71: ldc_w 257
    //   74: aastore
    //   75: dup
    //   76: iconst_1
    //   77: getstatic 261	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   80: aastore
    //   81: invokevirtual 265	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   84: astore 6
    //   86: aload 6
    //   88: instanceof 147
    //   91: ifeq +236 -> 327
    //   94: aload 6
    //   96: checkcast 147	java/lang/Boolean
    //   99: invokevirtual 268	java/lang/Boolean:booleanValue	()Z
    //   102: ifeq +225 -> 327
    //   105: invokestatic 270	com/tencent/mm/plugin/sport/model/l:dUl	()J
    //   108: lstore_2
    //   109: invokestatic 276	com/tencent/mm/sdk/platformtools/ai:getContext	()Landroid/content/Context;
    //   112: invokevirtual 282	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   115: astore 6
    //   117: aload 6
    //   119: ifnull +208 -> 327
    //   122: aload 6
    //   124: getstatic 45	com/tencent/mm/plugin/sport/model/l:zps	Landroid/net/Uri;
    //   127: getstatic 35	com/tencent/mm/plugin/sport/model/l:zpr	[Ljava/lang/String;
    //   130: ldc_w 284
    //   133: iconst_2
    //   134: anewarray 23	java/lang/String
    //   137: dup
    //   138: iconst_0
    //   139: lload_2
    //   140: invokestatic 287	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   143: aastore
    //   144: dup
    //   145: iconst_1
    //   146: lload_2
    //   147: ldc2_w 288
    //   150: ladd
    //   151: invokestatic 287	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   154: aastore
    //   155: ldc_w 291
    //   158: invokevirtual 297	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   161: astore 4
    //   163: aload 4
    //   165: ifnull +157 -> 322
    //   168: iconst_0
    //   169: istore_0
    //   170: aload 4
    //   172: astore 5
    //   174: aload 4
    //   176: invokeinterface 302 1 0
    //   181: ifeq +23 -> 204
    //   184: aload 4
    //   186: astore 5
    //   188: aload 4
    //   190: iconst_4
    //   191: invokeinterface 306 2 0
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
    //   213: invokeinterface 309 1 0
    //   218: iload_0
    //   219: istore_1
    //   220: ldc 143
    //   222: ldc_w 311
    //   225: iconst_1
    //   226: anewarray 4	java/lang/Object
    //   229: dup
    //   230: iconst_0
    //   231: iload_1
    //   232: invokestatic 316	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   235: aastore
    //   236: invokestatic 156	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   239: ldc 222
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
    //   257: ldc 143
    //   259: aload 6
    //   261: ldc_w 318
    //   264: iconst_0
    //   265: anewarray 4	java/lang/Object
    //   268: invokestatic 322	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   271: iload_0
    //   272: istore_1
    //   273: aload 4
    //   275: ifnull -55 -> 220
    //   278: aload 4
    //   280: invokeinterface 309 1 0
    //   285: iload_0
    //   286: istore_1
    //   287: goto -67 -> 220
    //   290: astore 4
    //   292: aload 5
    //   294: ifnull +10 -> 304
    //   297: aload 5
    //   299: invokeinterface 309 1 0
    //   304: ldc 222
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
  
  public static void g(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(149360);
    if ((zpq != null) && (zpq.isShowing()))
    {
      AppMethodBeat.o(149360);
      return;
    }
    if (k.av(5, 1L) == 0L)
    {
      AppMethodBeat.o(149360);
      return;
    }
    if ((u.axw().equals(paramString)) && (!((com.tencent.mm.plugin.sport.a.b)g.ab(com.tencent.mm.plugin.sport.a.b.class)).gn(com.tencent.mm.sdk.platformtools.ai.getContext())))
    {
      int i = paramActivity.getResources().getColor(2131099803);
      Object localObject1 = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131764114);
      paramString = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(149350);
          k.aw(5, 0L);
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
      int k = ap.dT(paramActivity);
      i = j;
      if (j == 0) {
        i = ap.jL(paramActivity);
      }
      ((o)localObject1).showAtLocation(paramActivity.getWindow().getDecorView(), 48, 0, i + k);
      paramActivity = (ImageView)localView.findViewById(2131305900);
      paramActivity.setImageResource(2131690535);
      paramActivity.setOnClickListener(new h.1((o)localObject1, paramString));
      zpq = (o)localObject1;
    }
    AppMethodBeat.o(149360);
  }
  
  public static boolean gn(Context paramContext)
  {
    AppMethodBeat.i(149356);
    if (d.la(19))
    {
      ac.i("MicroMsg.Sport.SportUtil", "Not Support SDK VERSION");
      AppMethodBeat.o(149356);
      return false;
    }
    if (!paramContext.getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter"))
    {
      ac.i("MicroMsg.Sport.SportUtil", "Not Support FEATURE_SENSOR_STEP_COUNTER");
      AppMethodBeat.o(149356);
      return false;
    }
    if (((SensorManager)com.tencent.mm.sdk.platformtools.ai.getContext().getSystemService("sensor")).getDefaultSensor(19) == null)
    {
      ac.i("MicroMsg.Sport.SportUtil", "Not Support can not get sensor");
      AppMethodBeat.o(149356);
      return false;
    }
    if (h.dUc().optInt("deviceStepSwitch") != 1)
    {
      ac.i("MicroMsg.Sport.SportUtil", "Not Support deviceStepSwitch is off");
      AppMethodBeat.o(149356);
      return false;
    }
    AppMethodBeat.o(149356);
    return true;
  }
  
  public static final String qn(long paramLong)
  {
    AppMethodBeat.i(149353);
    String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(paramLong));
    AppMethodBeat.o(149353);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.l
 * JD-Core Version:    0.7.0.1
 */