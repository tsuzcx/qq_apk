package com.tencent.tbs.one.impl.common.statistic;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.b.a;
import com.tencent.tbs.one.impl.a.f;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class c
{
  private static String a = "";
  private static String b = "";
  private static String c = "";
  
  public static int a(Context paramContext)
  {
    AppMethodBeat.i(174217);
    for (;;)
    {
      try
      {
        ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
        if (!a(paramContext, "android.permission.ACCESS_NETWORK_STATE")) {
          continue;
        }
        paramContext = localConnectivityManager.getActiveNetworkInfo();
        if ((paramContext != null) && (paramContext.isConnectedOrConnecting())) {
          i = paramContext.getType();
        }
        switch (i)
        {
        default: 
          i = 0;
        }
      }
      catch (Exception paramContext)
      {
        int i = 0;
        continue;
      }
      AppMethodBeat.o(174217);
      return i;
      f.b("Require \"ACCESS_NETWORK_STATE\" permission for reading apn type!", new Object[0]);
      AppMethodBeat.o(174217);
      return 0;
      i = 3;
      continue;
      i = paramContext.getSubtype();
      switch (i)
      {
      default: 
        i = 0;
        break;
      case 1: 
      case 2: 
      case 4: 
      case 7: 
      case 11: 
        i = 1;
        break;
      case 3: 
      case 5: 
      case 6: 
      case 8: 
      case 9: 
      case 10: 
      case 12: 
      case 14: 
      case 15: 
        i = 2;
        break;
      case 13: 
        i = 4;
      }
    }
  }
  
  /* Error */
  public static String a()
  {
    // Byte code:
    //   0: ldc 77
    //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 16	com/tencent/tbs/one/impl/common/statistic/c:b	Ljava/lang/String;
    //   8: invokestatic 83	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifne +14 -> 25
    //   14: getstatic 16	com/tencent/tbs/one/impl/common/statistic/c:b	Ljava/lang/String;
    //   17: astore_0
    //   18: ldc 77
    //   20: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aload_0
    //   24: areturn
    //   25: new 85	java/io/InputStreamReader
    //   28: dup
    //   29: invokestatic 91	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   32: ldc 93
    //   34: invokevirtual 97	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   37: invokevirtual 103	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   40: invokespecial 107	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   43: astore_1
    //   44: new 109	java/io/BufferedReader
    //   47: dup
    //   48: aload_1
    //   49: invokespecial 112	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   52: astore 4
    //   54: aload 4
    //   56: astore_3
    //   57: aload_1
    //   58: astore_2
    //   59: aload 4
    //   61: invokevirtual 115	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   64: ldc 117
    //   66: invokevirtual 122	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   69: ifeq +30 -> 99
    //   72: aload 4
    //   74: astore_3
    //   75: aload_1
    //   76: astore_2
    //   77: ldc 124
    //   79: invokestatic 127	com/tencent/tbs/one/impl/common/statistic/c:a	(Ljava/lang/String;)Ljava/lang/String;
    //   82: astore_0
    //   83: aload 4
    //   85: invokevirtual 130	java/io/BufferedReader:close	()V
    //   88: aload_1
    //   89: invokevirtual 131	java/io/InputStreamReader:close	()V
    //   92: ldc 77
    //   94: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: aload_0
    //   98: areturn
    //   99: aload 4
    //   101: astore_3
    //   102: aload_1
    //   103: astore_2
    //   104: ldc 133
    //   106: invokestatic 138	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   109: invokestatic 127	com/tencent/tbs/one/impl/common/statistic/c:a	(Ljava/lang/String;)Ljava/lang/String;
    //   112: astore_0
    //   113: goto -30 -> 83
    //   116: astore_0
    //   117: aconst_null
    //   118: astore_0
    //   119: aconst_null
    //   120: astore_1
    //   121: aload_0
    //   122: astore_3
    //   123: aload_1
    //   124: astore_2
    //   125: ldc 133
    //   127: invokestatic 138	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   130: invokestatic 127	com/tencent/tbs/one/impl/common/statistic/c:a	(Ljava/lang/String;)Ljava/lang/String;
    //   133: astore 4
    //   135: aload 4
    //   137: astore_2
    //   138: aload_0
    //   139: ifnull +7 -> 146
    //   142: aload_0
    //   143: invokevirtual 130	java/io/BufferedReader:close	()V
    //   146: aload_2
    //   147: astore_0
    //   148: aload_1
    //   149: ifnull -57 -> 92
    //   152: aload_1
    //   153: invokevirtual 131	java/io/InputStreamReader:close	()V
    //   156: aload_2
    //   157: astore_0
    //   158: goto -66 -> 92
    //   161: astore_0
    //   162: aload_2
    //   163: astore_0
    //   164: goto -72 -> 92
    //   167: astore_0
    //   168: aconst_null
    //   169: astore_2
    //   170: aconst_null
    //   171: astore_1
    //   172: aload_2
    //   173: ifnull +7 -> 180
    //   176: aload_2
    //   177: invokevirtual 130	java/io/BufferedReader:close	()V
    //   180: aload_1
    //   181: ifnull +7 -> 188
    //   184: aload_1
    //   185: invokevirtual 131	java/io/InputStreamReader:close	()V
    //   188: ldc 77
    //   190: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   193: aload_0
    //   194: athrow
    //   195: astore_2
    //   196: goto -108 -> 88
    //   199: astore_1
    //   200: goto -108 -> 92
    //   203: astore_0
    //   204: goto -58 -> 146
    //   207: astore_2
    //   208: goto -28 -> 180
    //   211: astore_1
    //   212: goto -24 -> 188
    //   215: astore_0
    //   216: aconst_null
    //   217: astore_2
    //   218: goto -46 -> 172
    //   221: astore_0
    //   222: aload_2
    //   223: astore_1
    //   224: aload_3
    //   225: astore_2
    //   226: goto -54 -> 172
    //   229: astore_0
    //   230: aconst_null
    //   231: astore_0
    //   232: goto -111 -> 121
    //   235: astore_0
    //   236: aload 4
    //   238: astore_0
    //   239: goto -118 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   17	96	0	str	String
    //   116	1	0	localThrowable1	Throwable
    //   118	40	0	localObject1	Object
    //   161	1	0	localIOException1	java.io.IOException
    //   163	1	0	localObject2	Object
    //   167	27	0	localObject3	Object
    //   203	1	0	localIOException2	java.io.IOException
    //   215	1	0	localObject4	Object
    //   221	1	0	localObject5	Object
    //   229	1	0	localThrowable2	Throwable
    //   231	1	0	localObject6	Object
    //   235	1	0	localThrowable3	Throwable
    //   238	1	0	localObject7	Object
    //   43	142	1	localInputStreamReader	java.io.InputStreamReader
    //   199	1	1	localIOException3	java.io.IOException
    //   211	1	1	localIOException4	java.io.IOException
    //   223	1	1	localObject8	Object
    //   58	119	2	localObject9	Object
    //   195	1	2	localIOException5	java.io.IOException
    //   207	1	2	localIOException6	java.io.IOException
    //   217	9	2	localObject10	Object
    //   56	169	3	localObject11	Object
    //   52	185	4	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   25	44	116	java/lang/Throwable
    //   152	156	161	java/io/IOException
    //   25	44	167	finally
    //   83	88	195	java/io/IOException
    //   88	92	199	java/io/IOException
    //   142	146	203	java/io/IOException
    //   176	180	207	java/io/IOException
    //   184	188	211	java/io/IOException
    //   44	54	215	finally
    //   59	72	221	finally
    //   77	83	221	finally
    //   104	113	221	finally
    //   125	135	221	finally
    //   44	54	229	java/lang/Throwable
    //   59	72	235	java/lang/Throwable
    //   77	83	235	java/lang/Throwable
    //   104	113	235	java/lang/Throwable
  }
  
  private static String a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private static boolean a(Context paramContext, String paramString)
  {
    AppMethodBeat.i(174216);
    if (paramContext.getPackageManager().checkPermission(paramString, paramContext.getPackageName()) == 0)
    {
      AppMethodBeat.o(174216);
      return true;
    }
    AppMethodBeat.o(174216);
    return false;
  }
  
  public static String b()
  {
    AppMethodBeat.i(174223);
    try
    {
      String str1 = new String(Build.MODEL.getBytes("UTF-8"), "ISO8859-1");
      AppMethodBeat.o(174223);
      return str1;
    }
    catch (Exception localException)
    {
      String str2 = Build.MODEL;
      AppMethodBeat.o(174223);
      return str2;
    }
  }
  
  public static String b(Context paramContext)
  {
    AppMethodBeat.i(174218);
    Object localObject = null;
    try
    {
      String str = paramContext.getPackageName();
      paramContext = paramContext.getPackageManager().getPackageInfo(str, 0).versionName;
      AppMethodBeat.o(174218);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        f.c("Get app version name exception!", new Object[] { paramContext });
        paramContext = localObject;
      }
    }
  }
  
  public static int c(Context paramContext)
  {
    int i = 0;
    AppMethodBeat.i(174219);
    try
    {
      String str = paramContext.getPackageName();
      int j = paramContext.getPackageManager().getPackageInfo(str, 0).versionCode;
      i = j;
    }
    catch (Exception paramContext)
    {
      label27:
      break label27;
    }
    AppMethodBeat.o(174219);
    return i;
  }
  
  public static String c()
  {
    AppMethodBeat.i(174225);
    try
    {
      Map localMap = a.MpS;
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = localMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        localStringBuilder.append(str2).append(":").append(localMap.get(str2)).append(";");
      }
      str1 = localStringBuilder.toString();
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(174225);
      return "";
    }
    String str1;
    AppMethodBeat.o(174225);
    return str1;
  }
  
  public static String d(Context paramContext)
  {
    AppMethodBeat.i(174220);
    String str = e(paramContext);
    if (!TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(174220);
      return str;
    }
    paramContext = f(paramContext);
    if (!TextUtils.isEmpty(paramContext))
    {
      AppMethodBeat.o(174220);
      return paramContext;
    }
    AppMethodBeat.o(174220);
    return "unknown";
  }
  
  public static String e(Context paramContext)
  {
    AppMethodBeat.i(174221);
    if (!TextUtils.isEmpty(a)) {
      paramContext = a;
    }
    for (;;)
    {
      AppMethodBeat.o(174221);
      return paramContext;
      try
      {
        TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
        if (a(paramContext, "android.permission.READ_PHONE_STATE"))
        {
          paramContext = localTelephonyManager.getDeviceId();
        }
        else
        {
          f.b("Require \"READ_PHONE_STATE\" permission for reading imei!", new Object[0]);
          paramContext = "";
        }
      }
      catch (Exception paramContext)
      {
        paramContext = "";
      }
    }
  }
  
  public static String f(Context paramContext)
  {
    AppMethodBeat.i(174224);
    if (!TextUtils.isEmpty(c))
    {
      paramContext = c;
      AppMethodBeat.o(174224);
      return paramContext;
    }
    try
    {
      c = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      label40:
      paramContext = c;
      AppMethodBeat.o(174224);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      break label40;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tbs.one.impl.common.statistic.c
 * JD-Core Version:    0.7.0.1
 */