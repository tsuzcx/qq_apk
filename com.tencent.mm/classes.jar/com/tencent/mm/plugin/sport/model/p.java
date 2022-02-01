package com.tencent.mm.plugin.sport.model;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.sport.b.a;
import com.tencent.mm.plugin.sport.b.d;
import com.tencent.mm.plugin.sport.b.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.v;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.json.JSONObject;

public final class p
{
  private static v Scf;
  private static final String[] Scg;
  private static final Uri Sch;
  
  static
  {
    AppMethodBeat.i(149364);
    Scg = new String[] { "_id", "_begin_time", "_end_time", "_mode", "_steps" };
    Sch = Uri.parse("content://com.miui.providers.steps/item");
    AppMethodBeat.o(149364);
  }
  
  public static boolean bm(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(149354);
    l2 = 3600000L;
    try
    {
      JSONObject localJSONObject = k.huj().optJSONObject("stepCountUploadConfig");
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
  
  public static boolean bn(long paramLong1, long paramLong2)
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
      JSONObject localJSONObject = k.huj().optJSONObject("stepCountUploadConfig");
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
  
  public static void fJF()
  {
    AppMethodBeat.i(149361);
    if (Scf != null)
    {
      Scf.dismiss();
      Scf = null;
    }
    AppMethodBeat.o(149361);
  }
  
  public static boolean htT()
  {
    AppMethodBeat.i(149359);
    au localau = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE("gh_43f2581f6fd6");
    if (localau != null) {}
    for (boolean bool = d.rs(localau.field_type);; bool = false)
    {
      if (!bool) {
        Log.i("MicroMsg.Sport.SportUtil", "checkUserInstallWeSportPlugin %b", new Object[] { Boolean.valueOf(bool) });
      }
      AppMethodBeat.o(149359);
      return bool;
    }
  }
  
  public static long hut()
  {
    AppMethodBeat.i(149351);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(cn.bDv());
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    long l = localCalendar.getTimeInMillis();
    AppMethodBeat.o(149351);
    return l;
  }
  
  public static int huu()
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
  
  public static boolean huv()
  {
    AppMethodBeat.i(149357);
    if (k.huj().optInt("checkWeSportInstall") != 1)
    {
      Log.i("MicroMsg.Sport.SportUtil", "checkPushInstallWeSport is false");
      AppMethodBeat.o(149357);
      return false;
    }
    AppMethodBeat.o(149357);
    return true;
  }
  
  public static boolean huw()
  {
    AppMethodBeat.i(149358);
    if (k.huj().optInt("extStepApiSwitch") != 1)
    {
      Log.i("MicroMsg.Sport.SportUtil", "Not Support extStepApiSwitch is off");
      AppMethodBeat.o(149358);
      return false;
    }
    AppMethodBeat.o(149358);
    return true;
  }
  
  /* Error */
  public static int hux()
  {
    // Byte code:
    //   0: ldc 215
    //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore 5
    //   8: aconst_null
    //   9: astore 4
    //   11: invokestatic 220	com/tencent/mm/sdk/vendor/MIUI:ifMIUI	()Z
    //   14: ifeq +312 -> 326
    //   17: ldc 222
    //   19: invokestatic 228	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   22: astore 7
    //   24: aload 7
    //   26: invokevirtual 232	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   29: astore 6
    //   31: aload 7
    //   33: ldc 234
    //   35: iconst_2
    //   36: anewarray 224	java/lang/Class
    //   39: dup
    //   40: iconst_0
    //   41: ldc 23
    //   43: aastore
    //   44: dup
    //   45: iconst_1
    //   46: getstatic 238	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   49: aastore
    //   50: invokevirtual 242	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   53: astore 7
    //   55: aload 7
    //   57: iconst_1
    //   58: invokevirtual 248	java/lang/reflect/Method:setAccessible	(Z)V
    //   61: aload 7
    //   63: aload 6
    //   65: iconst_2
    //   66: anewarray 4	java/lang/Object
    //   69: dup
    //   70: iconst_0
    //   71: ldc 250
    //   73: aastore
    //   74: dup
    //   75: iconst_1
    //   76: getstatic 254	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   79: aastore
    //   80: invokevirtual 258	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   83: astore 6
    //   85: aload 6
    //   87: instanceof 132
    //   90: ifeq +236 -> 326
    //   93: aload 6
    //   95: checkcast 132	java/lang/Boolean
    //   98: invokevirtual 261	java/lang/Boolean:booleanValue	()Z
    //   101: ifeq +225 -> 326
    //   104: invokestatic 263	com/tencent/mm/plugin/sport/model/p:hut	()J
    //   107: lstore_2
    //   108: invokestatic 269	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   111: invokevirtual 275	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   114: astore 6
    //   116: aload 6
    //   118: ifnull +208 -> 326
    //   121: aload 6
    //   123: getstatic 45	com/tencent/mm/plugin/sport/model/p:Sch	Landroid/net/Uri;
    //   126: getstatic 35	com/tencent/mm/plugin/sport/model/p:Scg	[Ljava/lang/String;
    //   129: ldc_w 277
    //   132: iconst_2
    //   133: anewarray 23	java/lang/String
    //   136: dup
    //   137: iconst_0
    //   138: lload_2
    //   139: invokestatic 280	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   142: aastore
    //   143: dup
    //   144: iconst_1
    //   145: lload_2
    //   146: ldc2_w 281
    //   149: ladd
    //   150: invokestatic 280	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   153: aastore
    //   154: ldc_w 284
    //   157: invokevirtual 290	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   160: astore 4
    //   162: aload 4
    //   164: ifnull +157 -> 321
    //   167: iconst_0
    //   168: istore_0
    //   169: aload 4
    //   171: astore 5
    //   173: aload 4
    //   175: invokeinterface 295 1 0
    //   180: ifeq +23 -> 203
    //   183: aload 4
    //   185: astore 5
    //   187: aload 4
    //   189: iconst_4
    //   190: invokeinterface 299 2 0
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
    //   212: invokeinterface 302 1 0
    //   217: iload_0
    //   218: istore_1
    //   219: ldc 128
    //   221: ldc_w 304
    //   224: iconst_1
    //   225: anewarray 4	java/lang/Object
    //   228: dup
    //   229: iconst_0
    //   230: iload_1
    //   231: invokestatic 309	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   234: aastore
    //   235: invokestatic 141	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   238: ldc 215
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
    //   256: ldc 128
    //   258: aload 6
    //   260: ldc_w 311
    //   263: iconst_0
    //   264: anewarray 4	java/lang/Object
    //   267: invokestatic 315	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   270: iload_0
    //   271: istore_1
    //   272: aload 4
    //   274: ifnull -55 -> 219
    //   277: aload 4
    //   279: invokeinterface 302 1 0
    //   284: iload_0
    //   285: istore_1
    //   286: goto -67 -> 219
    //   289: astore 4
    //   291: aload 5
    //   293: ifnull +10 -> 303
    //   296: aload 5
    //   298: invokeinterface 302 1 0
    //   303: ldc 215
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
  
  public static final String iY(long paramLong)
  {
    AppMethodBeat.i(149353);
    String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(paramLong));
    AppMethodBeat.o(149353);
    return str;
  }
  
  public static boolean jX(Context paramContext)
  {
    AppMethodBeat.i(149356);
    m.a locala = m.SbZ;
    boolean bool = m.a.jX(paramContext);
    AppMethodBeat.o(149356);
    return bool;
  }
  
  public static void o(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(149360);
    if ((Scf != null) && (Scf.isShowing()))
    {
      AppMethodBeat.o(149360);
      return;
    }
    n localn = n.Scc;
    if (n.bH("KEY_SHOW_NOT_SUPPORT_DEVICE_STEP_TIPS", 1L) == 0L)
    {
      AppMethodBeat.o(149360);
      return;
    }
    if ((z.bAM().equals(paramString)) && (!((com.tencent.mm.plugin.sport.a.b)h.ax(com.tencent.mm.plugin.sport.a.b.class)).jX(MMApplicationContext.getContext()))) {
      Scf = com.tencent.mm.ui.widget.a.k.a(paramActivity, b.d.icons_filled_info, paramActivity.getResources().getColor(b.a.Red), MMApplicationContext.getContext().getString(b.e.sport_device_not_support), b.d.icons_outlined_close, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(149350);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          a.c("com/tencent/mm/plugin/sport/model/SportUtil$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          paramAnonymousView = n.Scc;
          n.bI("KEY_SHOW_NOT_SUPPORT_DEVICE_STEP_TIPS", 0L);
          a.a(this, "com/tencent/mm/plugin/sport/model/SportUtil$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(149350);
        }
      });
    }
    AppMethodBeat.o(149360);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.p
 * JD-Core Version:    0.7.0.1
 */