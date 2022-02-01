package com.tencent.tbs.one.impl.common.statistic;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
    //   0: ldc 75
    //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 16	com/tencent/tbs/one/impl/common/statistic/c:b	Ljava/lang/String;
    //   8: invokestatic 81	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifne +14 -> 25
    //   14: getstatic 16	com/tencent/tbs/one/impl/common/statistic/c:b	Ljava/lang/String;
    //   17: astore_0
    //   18: ldc 75
    //   20: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aload_0
    //   24: areturn
    //   25: new 83	java/io/InputStreamReader
    //   28: dup
    //   29: invokestatic 89	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   32: ldc 91
    //   34: invokevirtual 95	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   37: invokevirtual 101	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   40: invokespecial 105	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   43: astore_1
    //   44: new 107	java/io/BufferedReader
    //   47: dup
    //   48: aload_1
    //   49: invokespecial 110	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   52: astore_2
    //   53: aload_2
    //   54: invokevirtual 113	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   57: ldc 115
    //   59: invokevirtual 120	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   62: ifeq +24 -> 86
    //   65: ldc 122
    //   67: invokestatic 125	com/tencent/tbs/one/impl/common/statistic/c:a	(Ljava/lang/String;)Ljava/lang/String;
    //   70: astore_0
    //   71: aload_2
    //   72: invokevirtual 128	java/io/BufferedReader:close	()V
    //   75: aload_1
    //   76: invokevirtual 129	java/io/InputStreamReader:close	()V
    //   79: ldc 75
    //   81: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: aload_0
    //   85: areturn
    //   86: ldc 131
    //   88: invokestatic 136	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   91: invokestatic 125	com/tencent/tbs/one/impl/common/statistic/c:a	(Ljava/lang/String;)Ljava/lang/String;
    //   94: astore_0
    //   95: goto -24 -> 71
    //   98: astore_0
    //   99: aconst_null
    //   100: astore_0
    //   101: aconst_null
    //   102: astore_1
    //   103: ldc 131
    //   105: invokestatic 136	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   108: invokestatic 125	com/tencent/tbs/one/impl/common/statistic/c:a	(Ljava/lang/String;)Ljava/lang/String;
    //   111: astore_2
    //   112: aload_0
    //   113: ifnull +7 -> 120
    //   116: aload_0
    //   117: invokevirtual 128	java/io/BufferedReader:close	()V
    //   120: aload_2
    //   121: astore_0
    //   122: aload_1
    //   123: ifnull -44 -> 79
    //   126: aload_1
    //   127: invokevirtual 129	java/io/InputStreamReader:close	()V
    //   130: aload_2
    //   131: astore_0
    //   132: goto -53 -> 79
    //   135: astore_0
    //   136: aload_2
    //   137: astore_0
    //   138: goto -59 -> 79
    //   141: astore_2
    //   142: aload_0
    //   143: ifnull +7 -> 150
    //   146: aload_0
    //   147: invokevirtual 128	java/io/BufferedReader:close	()V
    //   150: aload_1
    //   151: ifnull +7 -> 158
    //   154: aload_1
    //   155: invokevirtual 129	java/io/InputStreamReader:close	()V
    //   158: ldc 75
    //   160: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   163: aload_2
    //   164: athrow
    //   165: astore_2
    //   166: goto -91 -> 75
    //   169: astore_1
    //   170: goto -91 -> 79
    //   173: astore_0
    //   174: goto -54 -> 120
    //   177: astore_0
    //   178: goto -28 -> 150
    //   181: astore_0
    //   182: goto -24 -> 158
    //   185: astore_0
    //   186: aconst_null
    //   187: astore_0
    //   188: goto -85 -> 103
    //   191: astore_0
    //   192: aload_2
    //   193: astore_0
    //   194: goto -91 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   17	78	0	str	String
    //   98	1	0	localObject1	Object
    //   100	32	0	localObject2	Object
    //   135	1	0	localIOException1	java.io.IOException
    //   137	10	0	localObject3	Object
    //   173	1	0	localIOException2	java.io.IOException
    //   177	1	0	localIOException3	java.io.IOException
    //   181	1	0	localIOException4	java.io.IOException
    //   185	1	0	localObject4	Object
    //   187	1	0	localObject5	Object
    //   191	1	0	localObject6	Object
    //   193	1	0	localObject7	Object
    //   43	112	1	localInputStreamReader	java.io.InputStreamReader
    //   169	1	1	localIOException5	java.io.IOException
    //   52	85	2	localObject8	Object
    //   141	23	2	localObject9	Object
    //   165	28	2	localIOException6	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   25	44	98	finally
    //   126	130	135	java/io/IOException
    //   103	112	141	finally
    //   71	75	165	java/io/IOException
    //   75	79	169	java/io/IOException
    //   116	120	173	java/io/IOException
    //   146	150	177	java/io/IOException
    //   154	158	181	java/io/IOException
    //   44	53	185	finally
    //   53	71	191	finally
    //   86	95	191	finally
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
      Map localMap = com.tencent.tbs.b.a.ahzM;
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = localMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        localStringBuilder.append(str2).append(":").append(localMap.get(str2)).append(";");
      }
      str1 = localStringBuilder.toString();
    }
    finally
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
          paramContext = (String)com.tencent.mm.hellhoundlib.a.a.a(localTelephonyManager, "com/tencent/tbs/one/impl/common/statistic/c", "e", "(Landroid/content/Context;)Ljava/lang/String;", "android/telephony/TelephonyManager", "getDeviceId", "()Ljava/lang/String;");
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
      paramContext = paramContext.getContentResolver();
      paramContext = new com.tencent.mm.hellhoundlib.b.a().cG("android_id").cG(paramContext);
      c = (String)com.tencent.mm.hellhoundlib.a.a.a(new Object(), paramContext.aYi(), "com/tencent/tbs/one/impl/common/statistic/c", "f", "(Landroid/content/Context;)Ljava/lang/String;", "android/provider/Settings$Secure", "getString", "(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;");
      label87:
      paramContext = c;
      AppMethodBeat.o(174224);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      break label87;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tbs.one.impl.common.statistic.c
 * JD-Core Version:    0.7.0.1
 */