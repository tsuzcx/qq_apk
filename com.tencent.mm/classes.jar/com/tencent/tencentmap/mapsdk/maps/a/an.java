package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class an
{
  private static volatile boolean a;
  private static String b;
  private static String c;
  private static volatile int d;
  private static volatile boolean e;
  private static volatile int f;
  private static Map<String, an.a> g;
  private static BroadcastReceiver h;
  private static String i;
  private static String j;
  private static String k;
  private static String l;
  private static String m;
  
  static
  {
    AppMethodBeat.i(98483);
    a = true;
    b = "";
    c = "unknown";
    d = 0;
    e = false;
    f = -1;
    g = new ConcurrentHashMap();
    h = new ao();
    i = "";
    j = "cmwap";
    k = "3gwap";
    l = "uniwap";
    m = "ctwap";
    AppMethodBeat.o(98483);
  }
  
  public static void a()
  {
    AppMethodBeat.i(147233);
    try
    {
      e();
      IntentFilter localIntentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
      ac.a().registerReceiver(h, localIntentFilter);
      AppMethodBeat.o(147233);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(147233);
    }
  }
  
  public static void a(String paramString, an.a parama)
  {
    AppMethodBeat.i(147232);
    synchronized (g)
    {
      g.put(paramString, parama);
      AppMethodBeat.o(147232);
      return;
    }
  }
  
  public static String b()
  {
    return c;
  }
  
  public static String c()
  {
    switch (d)
    {
    default: 
      return "";
    case 1: 
      return "wifi";
    case 2: 
      return "2g";
    case 3: 
      return "3g";
    }
    return "4g";
  }
  
  public static String d()
  {
    switch (d)
    {
    default: 
      return "null";
    case 1: 
      return "wifi";
    }
    return b;
  }
  
  /* Error */
  public static void e()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 126
    //   5: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 45	com/tencent/tencentmap/mapsdk/maps/a/an:d	I
    //   11: istore_0
    //   12: invokestatic 100	com/tencent/tencentmap/mapsdk/maps/a/ac:a	()Landroid/content/Context;
    //   15: ldc 128
    //   17: invokevirtual 132	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   20: checkcast 134	android/net/ConnectivityManager
    //   23: invokevirtual 138	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   26: astore_3
    //   27: aload_3
    //   28: ifnull +598 -> 626
    //   31: aload_3
    //   32: invokevirtual 144	android/net/NetworkInfo:isAvailable	()Z
    //   35: ifeq +591 -> 626
    //   38: aload_3
    //   39: invokevirtual 147	android/net/NetworkInfo:isConnected	()Z
    //   42: ifeq +584 -> 626
    //   45: iconst_1
    //   46: putstatic 35	com/tencent/tencentmap/mapsdk/maps/a/an:a	Z
    //   49: aload_3
    //   50: invokevirtual 151	android/net/NetworkInfo:getType	()I
    //   53: istore_1
    //   54: iload_1
    //   55: iconst_1
    //   56: if_icmpne +149 -> 205
    //   59: iconst_1
    //   60: putstatic 45	com/tencent/tencentmap/mapsdk/maps/a/an:d	I
    //   63: iconst_0
    //   64: putstatic 49	com/tencent/tencentmap/mapsdk/maps/a/an:f	I
    //   67: iconst_0
    //   68: putstatic 47	com/tencent/tencentmap/mapsdk/maps/a/an:e	Z
    //   71: invokestatic 100	com/tencent/tencentmap/mapsdk/maps/a/ac:a	()Landroid/content/Context;
    //   74: invokevirtual 154	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   77: ldc 117
    //   79: invokevirtual 132	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   82: checkcast 156	android/net/wifi/WifiManager
    //   85: invokevirtual 160	android/net/wifi/WifiManager:getConnectionInfo	()Landroid/net/wifi/WifiInfo;
    //   88: astore_3
    //   89: new 162	java/lang/StringBuilder
    //   92: dup
    //   93: ldc 164
    //   95: invokespecial 165	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   98: aload_3
    //   99: invokevirtual 170	android/net/wifi/WifiInfo:getSSID	()Ljava/lang/String;
    //   102: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_3
    //   106: invokevirtual 177	android/net/wifi/WifiInfo:getBSSID	()Ljava/lang/String;
    //   109: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: putstatic 43	com/tencent/tencentmap/mapsdk/maps/a/an:c	Ljava/lang/String;
    //   118: iload_0
    //   119: getstatic 45	com/tencent/tencentmap/mapsdk/maps/a/an:d	I
    //   122: if_icmpeq +564 -> 686
    //   125: getstatic 56	com/tencent/tencentmap/mapsdk/maps/a/an:g	Ljava/util/Map;
    //   128: astore_3
    //   129: aload_3
    //   130: monitorenter
    //   131: getstatic 56	com/tencent/tencentmap/mapsdk/maps/a/an:g	Ljava/util/Map;
    //   134: invokeinterface 184 1 0
    //   139: invokeinterface 190 1 0
    //   144: astore 4
    //   146: aload 4
    //   148: invokeinterface 195 1 0
    //   153: ifeq +502 -> 655
    //   156: aload 4
    //   158: invokeinterface 199 1 0
    //   163: checkcast 6	com/tencent/tencentmap/mapsdk/maps/a/an$a
    //   166: astore 5
    //   168: aload 5
    //   170: ifnull -24 -> 146
    //   173: aload 5
    //   175: getstatic 45	com/tencent/tencentmap/mapsdk/maps/a/an:d	I
    //   178: getstatic 43	com/tencent/tencentmap/mapsdk/maps/a/an:c	Ljava/lang/String;
    //   181: invokevirtual 202	com/tencent/tencentmap/mapsdk/maps/a/an$a:a	(ILjava/lang/String;)V
    //   184: goto -38 -> 146
    //   187: astore 4
    //   189: aload_3
    //   190: monitorexit
    //   191: ldc 126
    //   193: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   196: aload 4
    //   198: athrow
    //   199: astore_3
    //   200: ldc 2
    //   202: monitorexit
    //   203: aload_3
    //   204: athrow
    //   205: aload_3
    //   206: invokevirtual 205	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   209: astore 4
    //   211: aload 4
    //   213: ifnull +388 -> 601
    //   216: aload 4
    //   218: invokevirtual 210	java/lang/String:trim	()Ljava/lang/String;
    //   221: invokevirtual 213	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   224: putstatic 39	com/tencent/tencentmap/mapsdk/maps/a/an:b	Ljava/lang/String;
    //   227: iload_1
    //   228: ifne +348 -> 576
    //   231: new 162	java/lang/StringBuilder
    //   234: dup
    //   235: ldc 215
    //   237: invokespecial 165	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   240: getstatic 39	com/tencent/tencentmap/mapsdk/maps/a/an:b	Ljava/lang/String;
    //   243: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: putstatic 43	com/tencent/tencentmap/mapsdk/maps/a/an:c	Ljava/lang/String;
    //   252: aload_3
    //   253: invokevirtual 218	android/net/NetworkInfo:getSubtype	()I
    //   256: istore_1
    //   257: iload_1
    //   258: putstatic 49	com/tencent/tencentmap/mapsdk/maps/a/an:f	I
    //   261: iload_1
    //   262: iconst_1
    //   263: if_icmpeq +13 -> 276
    //   266: iload_1
    //   267: iconst_2
    //   268: if_icmpeq +8 -> 276
    //   271: iload_1
    //   272: iconst_4
    //   273: if_icmpne +126 -> 399
    //   276: iconst_2
    //   277: putstatic 45	com/tencent/tencentmap/mapsdk/maps/a/an:d	I
    //   280: getstatic 39	com/tencent/tencentmap/mapsdk/maps/a/an:b	Ljava/lang/String;
    //   283: ldc 220
    //   285: invokevirtual 224	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   288: istore_2
    //   289: iload_2
    //   290: putstatic 47	com/tencent/tencentmap/mapsdk/maps/a/an:e	Z
    //   293: iload_2
    //   294: ifeq -176 -> 118
    //   297: getstatic 39	com/tencent/tencentmap/mapsdk/maps/a/an:b	Ljava/lang/String;
    //   300: getstatic 71	com/tencent/tencentmap/mapsdk/maps/a/an:k	Ljava/lang/String;
    //   303: invokevirtual 224	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   306: ifeq +202 -> 508
    //   309: ldc 226
    //   311: putstatic 63	com/tencent/tencentmap/mapsdk/maps/a/an:i	Ljava/lang/String;
    //   314: goto -196 -> 118
    //   317: astore_3
    //   318: iload_0
    //   319: getstatic 45	com/tencent/tencentmap/mapsdk/maps/a/an:d	I
    //   322: if_icmpeq +364 -> 686
    //   325: getstatic 56	com/tencent/tencentmap/mapsdk/maps/a/an:g	Ljava/util/Map;
    //   328: astore_3
    //   329: aload_3
    //   330: monitorenter
    //   331: getstatic 56	com/tencent/tencentmap/mapsdk/maps/a/an:g	Ljava/util/Map;
    //   334: invokeinterface 184 1 0
    //   339: invokeinterface 190 1 0
    //   344: astore 4
    //   346: aload 4
    //   348: invokeinterface 195 1 0
    //   353: ifeq +313 -> 666
    //   356: aload 4
    //   358: invokeinterface 199 1 0
    //   363: checkcast 6	com/tencent/tencentmap/mapsdk/maps/a/an$a
    //   366: astore 5
    //   368: aload 5
    //   370: ifnull -24 -> 346
    //   373: aload 5
    //   375: getstatic 45	com/tencent/tencentmap/mapsdk/maps/a/an:d	I
    //   378: getstatic 43	com/tencent/tencentmap/mapsdk/maps/a/an:c	Ljava/lang/String;
    //   381: invokevirtual 202	com/tencent/tencentmap/mapsdk/maps/a/an$a:a	(ILjava/lang/String;)V
    //   384: goto -38 -> 346
    //   387: astore 4
    //   389: aload_3
    //   390: monitorexit
    //   391: ldc 126
    //   393: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   396: aload 4
    //   398: athrow
    //   399: iload_1
    //   400: bipush 13
    //   402: if_icmpeq +9 -> 411
    //   405: iload_1
    //   406: bipush 19
    //   408: if_icmpne +93 -> 501
    //   411: iconst_4
    //   412: putstatic 45	com/tencent/tencentmap/mapsdk/maps/a/an:d	I
    //   415: goto -135 -> 280
    //   418: astore 4
    //   420: iload_0
    //   421: getstatic 45	com/tencent/tencentmap/mapsdk/maps/a/an:d	I
    //   424: if_icmpeq +254 -> 678
    //   427: getstatic 56	com/tencent/tencentmap/mapsdk/maps/a/an:g	Ljava/util/Map;
    //   430: astore_3
    //   431: aload_3
    //   432: monitorenter
    //   433: getstatic 56	com/tencent/tencentmap/mapsdk/maps/a/an:g	Ljava/util/Map;
    //   436: invokeinterface 184 1 0
    //   441: invokeinterface 190 1 0
    //   446: astore 5
    //   448: aload 5
    //   450: invokeinterface 195 1 0
    //   455: ifeq +221 -> 676
    //   458: aload 5
    //   460: invokeinterface 199 1 0
    //   465: checkcast 6	com/tencent/tencentmap/mapsdk/maps/a/an$a
    //   468: astore 6
    //   470: aload 6
    //   472: ifnull -24 -> 448
    //   475: aload 6
    //   477: getstatic 45	com/tencent/tencentmap/mapsdk/maps/a/an:d	I
    //   480: getstatic 43	com/tencent/tencentmap/mapsdk/maps/a/an:c	Ljava/lang/String;
    //   483: invokevirtual 202	com/tencent/tencentmap/mapsdk/maps/a/an$a:a	(ILjava/lang/String;)V
    //   486: goto -38 -> 448
    //   489: astore 4
    //   491: aload_3
    //   492: monitorexit
    //   493: ldc 126
    //   495: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   498: aload 4
    //   500: athrow
    //   501: iconst_3
    //   502: putstatic 45	com/tencent/tencentmap/mapsdk/maps/a/an:d	I
    //   505: goto -225 -> 280
    //   508: getstatic 39	com/tencent/tencentmap/mapsdk/maps/a/an:b	Ljava/lang/String;
    //   511: getstatic 67	com/tencent/tencentmap/mapsdk/maps/a/an:j	Ljava/lang/String;
    //   514: invokevirtual 224	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   517: ifeq +11 -> 528
    //   520: ldc 226
    //   522: putstatic 63	com/tencent/tencentmap/mapsdk/maps/a/an:i	Ljava/lang/String;
    //   525: goto -407 -> 118
    //   528: getstatic 39	com/tencent/tencentmap/mapsdk/maps/a/an:b	Ljava/lang/String;
    //   531: getstatic 75	com/tencent/tencentmap/mapsdk/maps/a/an:l	Ljava/lang/String;
    //   534: invokevirtual 224	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   537: ifeq +11 -> 548
    //   540: ldc 226
    //   542: putstatic 63	com/tencent/tencentmap/mapsdk/maps/a/an:i	Ljava/lang/String;
    //   545: goto -427 -> 118
    //   548: getstatic 39	com/tencent/tencentmap/mapsdk/maps/a/an:b	Ljava/lang/String;
    //   551: getstatic 79	com/tencent/tencentmap/mapsdk/maps/a/an:m	Ljava/lang/String;
    //   554: invokevirtual 224	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   557: ifeq +11 -> 568
    //   560: ldc 228
    //   562: putstatic 63	com/tencent/tencentmap/mapsdk/maps/a/an:i	Ljava/lang/String;
    //   565: goto -447 -> 118
    //   568: ldc 37
    //   570: putstatic 63	com/tencent/tencentmap/mapsdk/maps/a/an:i	Ljava/lang/String;
    //   573: goto -455 -> 118
    //   576: ldc 41
    //   578: putstatic 39	com/tencent/tencentmap/mapsdk/maps/a/an:b	Ljava/lang/String;
    //   581: iconst_0
    //   582: putstatic 45	com/tencent/tencentmap/mapsdk/maps/a/an:d	I
    //   585: iconst_m1
    //   586: putstatic 49	com/tencent/tencentmap/mapsdk/maps/a/an:f	I
    //   589: ldc 41
    //   591: putstatic 43	com/tencent/tencentmap/mapsdk/maps/a/an:c	Ljava/lang/String;
    //   594: iconst_0
    //   595: putstatic 47	com/tencent/tencentmap/mapsdk/maps/a/an:e	Z
    //   598: goto -480 -> 118
    //   601: ldc 41
    //   603: putstatic 39	com/tencent/tencentmap/mapsdk/maps/a/an:b	Ljava/lang/String;
    //   606: iconst_0
    //   607: putstatic 45	com/tencent/tencentmap/mapsdk/maps/a/an:d	I
    //   610: iconst_m1
    //   611: putstatic 49	com/tencent/tencentmap/mapsdk/maps/a/an:f	I
    //   614: ldc 41
    //   616: putstatic 43	com/tencent/tencentmap/mapsdk/maps/a/an:c	Ljava/lang/String;
    //   619: iconst_0
    //   620: putstatic 47	com/tencent/tencentmap/mapsdk/maps/a/an:e	Z
    //   623: goto -505 -> 118
    //   626: ldc 41
    //   628: putstatic 39	com/tencent/tencentmap/mapsdk/maps/a/an:b	Ljava/lang/String;
    //   631: iconst_0
    //   632: putstatic 45	com/tencent/tencentmap/mapsdk/maps/a/an:d	I
    //   635: iconst_m1
    //   636: putstatic 49	com/tencent/tencentmap/mapsdk/maps/a/an:f	I
    //   639: ldc 41
    //   641: putstatic 43	com/tencent/tencentmap/mapsdk/maps/a/an:c	Ljava/lang/String;
    //   644: iconst_0
    //   645: putstatic 47	com/tencent/tencentmap/mapsdk/maps/a/an:e	Z
    //   648: iconst_0
    //   649: putstatic 35	com/tencent/tencentmap/mapsdk/maps/a/an:a	Z
    //   652: goto -534 -> 118
    //   655: aload_3
    //   656: monitorexit
    //   657: ldc 126
    //   659: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   662: ldc 2
    //   664: monitorexit
    //   665: return
    //   666: aload_3
    //   667: monitorexit
    //   668: ldc 126
    //   670: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   673: goto -11 -> 662
    //   676: aload_3
    //   677: monitorexit
    //   678: ldc 126
    //   680: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   683: aload 4
    //   685: athrow
    //   686: ldc 126
    //   688: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   691: goto -29 -> 662
    // Local variable table:
    //   start	length	slot	name	signature
    //   11	414	0	n	int
    //   53	356	1	i1	int
    //   288	6	2	bool	boolean
    //   199	54	3	localObject2	Object
    //   317	1	3	localThrowable	Throwable
    //   144	13	4	localIterator	java.util.Iterator
    //   187	10	4	localObject3	Object
    //   209	148	4	localObject4	Object
    //   387	10	4	localObject5	Object
    //   418	1	4	localObject6	Object
    //   489	195	4	localObject7	Object
    //   166	293	5	localObject8	Object
    //   468	8	6	locala	an.a
    // Exception table:
    //   from	to	target	type
    //   131	146	187	finally
    //   146	168	187	finally
    //   173	184	187	finally
    //   189	191	187	finally
    //   655	657	187	finally
    //   3	12	199	finally
    //   118	131	199	finally
    //   191	199	199	finally
    //   318	331	199	finally
    //   391	399	199	finally
    //   420	433	199	finally
    //   493	501	199	finally
    //   657	662	199	finally
    //   668	673	199	finally
    //   678	686	199	finally
    //   686	691	199	finally
    //   12	27	317	java/lang/Throwable
    //   31	54	317	java/lang/Throwable
    //   59	118	317	java/lang/Throwable
    //   205	211	317	java/lang/Throwable
    //   216	227	317	java/lang/Throwable
    //   231	261	317	java/lang/Throwable
    //   276	280	317	java/lang/Throwable
    //   280	293	317	java/lang/Throwable
    //   297	314	317	java/lang/Throwable
    //   411	415	317	java/lang/Throwable
    //   501	505	317	java/lang/Throwable
    //   508	525	317	java/lang/Throwable
    //   528	545	317	java/lang/Throwable
    //   548	565	317	java/lang/Throwable
    //   568	573	317	java/lang/Throwable
    //   576	598	317	java/lang/Throwable
    //   601	623	317	java/lang/Throwable
    //   626	652	317	java/lang/Throwable
    //   331	346	387	finally
    //   346	368	387	finally
    //   373	384	387	finally
    //   389	391	387	finally
    //   666	668	387	finally
    //   12	27	418	finally
    //   31	54	418	finally
    //   59	118	418	finally
    //   205	211	418	finally
    //   216	227	418	finally
    //   231	261	418	finally
    //   276	280	418	finally
    //   280	293	418	finally
    //   297	314	418	finally
    //   411	415	418	finally
    //   501	505	418	finally
    //   508	525	418	finally
    //   528	545	418	finally
    //   548	565	418	finally
    //   568	573	418	finally
    //   576	598	418	finally
    //   601	623	418	finally
    //   626	652	418	finally
    //   433	448	489	finally
    //   448	470	489	finally
    //   475	486	489	finally
    //   491	493	489	finally
    //   676	678	489	finally
  }
  
  public static String f()
  {
    if (f == -1) {
      return "unknown";
    }
    switch (f)
    {
    default: 
      return "unknown";
    case 0: 
      return "wifi";
    case 13: 
      return "LTE";
    case 1: 
      return "GPRS";
    case 2: 
      return "EDGE";
    case 4: 
      return "CDMA";
    case 3: 
      return "UMTS";
    case 8: 
      return "HSDPA";
    case 9: 
      return "HSUPA";
    case 10: 
      return "HSPA";
    case 5: 
      return "EVDO_0";
    case 6: 
      return "EVDO_A";
    case 7: 
      return "1xRTT";
    case 11: 
      return "iDen";
    case 12: 
      return "EVDO_B";
    case 14: 
      return "EHRPD";
    }
    return "HSPAP";
  }
  
  public static int g()
  {
    return d;
  }
  
  public static boolean h()
  {
    return a;
  }
  
  public static boolean i()
  {
    return e;
  }
  
  public static Integer j()
  {
    AppMethodBeat.i(147235);
    e();
    Object localObject2;
    Object localObject1;
    if ((d == 2) || (d == 3) || (d == 4))
    {
      n = 1;
      if (n == 0) {
        break label278;
      }
      localObject2 = ac.a();
      localObject1 = b;
      localObject2 = (TelephonyManager)((Context)localObject2).getSystemService("phone");
      if ((localObject2 == null) || (((TelephonyManager)localObject2).getSimState() != 5)) {
        break label161;
      }
      localObject2 = ((TelephonyManager)localObject2).getSimOperator();
      if (((String)localObject2).length() <= 0) {
        break label161;
      }
      if ((!((String)localObject2).equals("46000")) && (!((String)localObject2).equals("46002"))) {
        break label125;
      }
      localObject1 = Integer.valueOf(1);
    }
    label104:
    for (int n = ((Integer)localObject1).intValue();; n = 0)
    {
      AppMethodBeat.o(147235);
      return Integer.valueOf(n);
      n = 0;
      break;
      label125:
      if (((String)localObject2).equals("46001"))
      {
        localObject1 = Integer.valueOf(2);
        break label104;
      }
      if (((String)localObject2).equals("46003"))
      {
        localObject1 = Integer.valueOf(3);
        break label104;
      }
      if (localObject1 != null)
      {
        localObject1 = ((String)localObject1).toLowerCase();
        if ((((String)localObject1).contains("cmnet")) || (((String)localObject1).contains("cmwap")))
        {
          localObject1 = Integer.valueOf(1);
          break label104;
        }
        if ((((String)localObject1).contains("uninet")) || (((String)localObject1).contains("uniwap")) || (((String)localObject1).contains("3gnet")) || (((String)localObject1).contains("3gwap")))
        {
          localObject1 = Integer.valueOf(2);
          break label104;
        }
        if ((((String)localObject1).contains("ctnet")) || (((String)localObject1).contains("ctwap")))
        {
          localObject1 = Integer.valueOf(3);
          break label104;
        }
      }
      localObject1 = Integer.valueOf(0);
      break label104;
    }
  }
  
  public static Proxy k()
  {
    AppMethodBeat.i(147236);
    if ((e) && (!TextUtils.isEmpty(i)))
    {
      Proxy localProxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(i, 80));
      AppMethodBeat.o(147236);
      return localProxy;
    }
    AppMethodBeat.o(147236);
    return null;
  }
  
  public static boolean l()
  {
    AppMethodBeat.i(147237);
    try
    {
      PowerManager localPowerManager = (PowerManager)ac.a().getSystemService("power");
      if ((Build.VERSION.SDK_INT >= 23) && (localPowerManager != null))
      {
        boolean bool = ((Boolean)PowerManager.class.getDeclaredMethod("isDeviceIdleMode", new Class[0]).invoke(localPowerManager, new Object[0])).booleanValue();
        AppMethodBeat.o(147237);
        return bool;
      }
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(147237);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.an
 * JD-Core Version:    0.7.0.1
 */