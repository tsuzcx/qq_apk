package com.tencent.tencentmap.mapsdk.maps.a;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public final class dd
{
  private static String a = "";
  private static String b = "";
  private static String c = "";
  private static String d = "";
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(147427);
    paramInt1 = Math.min(Math.max(paramInt1, paramInt2), paramInt3);
    AppMethodBeat.o(147427);
    return paramInt1;
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(147426);
    if (((paramInt1 < paramInt2) || (paramInt1 > paramInt3)) && (paramInt4 >= paramInt2) && (paramInt4 <= paramInt3))
    {
      AppMethodBeat.o(147426);
      return paramInt4;
    }
    paramInt1 = Math.min(Math.max(paramInt1, paramInt2), paramInt3);
    AppMethodBeat.o(147426);
    return paramInt1;
  }
  
  public static String a()
  {
    int i = 1;
    AppMethodBeat.i(147421);
    for (;;)
    {
      try
      {
        localObject = a;
        if (localObject != null) {
          continue;
        }
        if (i != 0)
        {
          localObject = (TelephonyManager)ac.a().getSystemService("phone");
          if (localObject != null)
          {
            String str = ((TelephonyManager)localObject).getDeviceId();
            localObject = str;
            if (str == null) {
              localObject = "NOIMEI";
            }
            a = (String)localObject;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        int j;
        continue;
      }
      localObject = a;
      AppMethodBeat.o(147421);
      return localObject;
      j = ((String)localObject).trim().length();
      if (j != 0) {
        i = 0;
      }
    }
  }
  
  /* Error */
  public static String a(int paramInt)
  {
    // Byte code:
    //   0: ldc 83
    //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 85	java/lang/StringBuilder
    //   8: dup
    //   9: ldc 87
    //   11: invokespecial 91	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   14: iload_0
    //   15: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   18: ldc 97
    //   20: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: astore_1
    //   27: new 105	java/io/BufferedReader
    //   30: dup
    //   31: new 107	java/io/FileReader
    //   34: dup
    //   35: aload_1
    //   36: invokespecial 108	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   39: invokespecial 111	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   42: astore_1
    //   43: aload_1
    //   44: invokevirtual 114	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   47: astore_2
    //   48: aload_2
    //   49: invokestatic 120	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   52: ifne +81 -> 133
    //   55: aload_2
    //   56: invokevirtual 73	java/lang/String:trim	()Ljava/lang/String;
    //   59: astore_2
    //   60: aload_1
    //   61: invokevirtual 123	java/io/BufferedReader:close	()V
    //   64: ldc 83
    //   66: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: aload_2
    //   70: areturn
    //   71: astore_1
    //   72: aconst_null
    //   73: astore_1
    //   74: aload_1
    //   75: ifnull +7 -> 82
    //   78: aload_1
    //   79: invokevirtual 123	java/io/BufferedReader:close	()V
    //   82: ldc 83
    //   84: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: aconst_null
    //   88: areturn
    //   89: astore_1
    //   90: aconst_null
    //   91: astore_2
    //   92: aload_2
    //   93: ifnull +7 -> 100
    //   96: aload_2
    //   97: invokevirtual 123	java/io/BufferedReader:close	()V
    //   100: ldc 83
    //   102: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: aload_1
    //   106: athrow
    //   107: astore_1
    //   108: goto -44 -> 64
    //   111: astore_1
    //   112: goto -30 -> 82
    //   115: astore_2
    //   116: goto -16 -> 100
    //   119: astore_2
    //   120: aload_1
    //   121: astore_3
    //   122: aload_2
    //   123: astore_1
    //   124: aload_3
    //   125: astore_2
    //   126: goto -34 -> 92
    //   129: astore_2
    //   130: goto -56 -> 74
    //   133: goto -73 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	paramInt	int
    //   26	35	1	localObject1	Object
    //   71	1	1	localException1	Exception
    //   73	6	1	localObject2	Object
    //   89	17	1	localObject3	Object
    //   107	1	1	localIOException1	java.io.IOException
    //   111	10	1	localIOException2	java.io.IOException
    //   123	1	1	localObject4	Object
    //   47	50	2	str	String
    //   115	1	2	localIOException3	java.io.IOException
    //   119	4	2	localObject5	Object
    //   125	1	2	localObject6	Object
    //   129	1	2	localException2	Exception
    //   121	4	3	localIOException4	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   27	43	71	java/lang/Exception
    //   27	43	89	finally
    //   60	64	107	java/io/IOException
    //   78	82	111	java/io/IOException
    //   96	100	115	java/io/IOException
    //   43	60	119	finally
    //   43	60	129	java/lang/Exception
  }
  
  public static String a(long paramLong, String paramString)
  {
    AppMethodBeat.i(147417);
    try
    {
      paramString = new SimpleDateFormat(paramString);
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(paramLong);
      paramString = paramString.format(localCalendar.getTime());
      AppMethodBeat.o(147417);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(147417);
    }
    return "";
  }
  
  public static String a(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(147424);
    paramContext = paramContext.getSystemService("activity");
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        paramContext = (ActivityManager)paramContext;
        if (paramContext != null) {
          break;
        }
        AppMethodBeat.o(147424);
        return null;
      }
      catch (Throwable paramContext) {}
      paramContext = null;
    }
    paramContext = paramContext.getRunningAppProcesses();
    int i;
    ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
    if ((paramContext != null) && (paramContext.size() > 0))
    {
      int j = paramContext.size();
      i = 0;
      if (i < j)
      {
        localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.get(i);
        if ((localRunningAppProcessInfo == null) || (localRunningAppProcessInfo.pid != paramInt)) {}
      }
    }
    for (paramContext = localRunningAppProcessInfo.processName;; paramContext = null)
    {
      AppMethodBeat.o(147424);
      return paramContext;
      i += 1;
      break;
    }
  }
  
  public static String a(Throwable paramThrowable)
  {
    AppMethodBeat.i(147416);
    paramThrowable = Log.getStackTraceString(paramThrowable);
    if (!TextUtils.isEmpty(paramThrowable))
    {
      paramThrowable = paramThrowable.split("\n");
      if (paramThrowable.length >= 2)
      {
        paramThrowable = paramThrowable[0] + paramThrowable[1];
        AppMethodBeat.o(147416);
        return paramThrowable;
      }
      if (paramThrowable.length == 1)
      {
        paramThrowable = paramThrowable[0];
        AppMethodBeat.o(147416);
        return paramThrowable;
      }
      AppMethodBeat.o(147416);
      return "";
    }
    AppMethodBeat.o(147416);
    return "";
  }
  
  private static String a(InetAddress paramInetAddress)
  {
    AppMethodBeat.i(147430);
    for (;;)
    {
      int i;
      try
      {
        paramInetAddress = paramInetAddress.getAddress();
        StringBuilder localStringBuilder1 = new StringBuilder();
        i = 0;
        if (i < paramInetAddress.length)
        {
          StringBuilder localStringBuilder2 = new StringBuilder(".");
          if (paramInetAddress[i] < 0)
          {
            j = paramInetAddress[i] + 256;
            localStringBuilder1.append(j);
            i += 1;
          }
        }
        else
        {
          paramInetAddress = localStringBuilder1.substring(1);
          AppMethodBeat.o(147430);
          return paramInetAddress;
        }
      }
      catch (Throwable paramInetAddress)
      {
        AppMethodBeat.o(147430);
        return "";
      }
      int j = paramInetAddress[i];
    }
  }
  
  public static boolean a(String paramString)
  {
    AppMethodBeat.i(147418);
    if (paramString == null)
    {
      AppMethodBeat.o(147418);
      return true;
    }
    if (paramString.trim().length() == 0)
    {
      AppMethodBeat.o(147418);
      return true;
    }
    AppMethodBeat.o(147418);
    return false;
  }
  
  public static boolean a(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte == null) || (paramArrayOfByte.length <= 0);
  }
  
  public static String b()
  {
    int i = 1;
    AppMethodBeat.i(147422);
    for (;;)
    {
      try
      {
        localObject = b;
        if (localObject != null) {
          continue;
        }
        if (i != 0)
        {
          localObject = (TelephonyManager)ac.a().getSystemService("phone");
          if (localObject != null)
          {
            String str = ((TelephonyManager)localObject).getSubscriberId();
            localObject = str;
            if (str == null) {
              localObject = "NOIMSI";
            }
            b = (String)localObject;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        int j;
        continue;
      }
      localObject = b;
      AppMethodBeat.o(147422);
      return localObject;
      j = ((String)localObject).trim().length();
      if (j != 0) {
        i = 0;
      }
    }
  }
  
  public static String b(String paramString)
  {
    AppMethodBeat.i(147420);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(147420);
      return "";
    }
    try
    {
      paramString = URLEncoder.encode(paramString, "UTF-8");
      AppMethodBeat.o(147420);
      return paramString;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(147420);
    }
    return "";
  }
  
  public static String b(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(147419);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(147419);
      return "null";
    }
    int i = paramArrayOfByte.length;
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(147419);
      return "null";
    }
    int j = Math.min(i, paramArrayOfByte.length);
    StringBuffer localStringBuffer = new StringBuffer("size:" + j + ",content:");
    i = 0;
    while (i < j)
    {
      localStringBuffer.append(Integer.toHexString(paramArrayOfByte[i] >> 4 & 0xF));
      localStringBuffer.append(Integer.toHexString(paramArrayOfByte[i] & 0xF));
      i += 1;
    }
    paramArrayOfByte = localStringBuffer.toString();
    AppMethodBeat.o(147419);
    return paramArrayOfByte;
  }
  
  public static String c()
  {
    int i = 1;
    AppMethodBeat.i(147423);
    for (;;)
    {
      try
      {
        localObject = c;
        if (localObject != null) {
          continue;
        }
        if (i != 0)
        {
          localObject = (WifiManager)ac.a().getApplicationContext().getSystemService("wifi");
          if (localObject != null)
          {
            localObject = ((WifiManager)localObject).getConnectionInfo();
            if (localObject != null)
            {
              String str = ((WifiInfo)localObject).getMacAddress();
              localObject = str;
              if (str == null) {
                localObject = "NOMAC";
              }
              c = (String)localObject;
            }
          }
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        int j;
        continue;
      }
      localObject = c;
      AppMethodBeat.o(147423);
      return localObject;
      j = ((String)localObject).trim().length();
      if (j != 0) {
        i = 0;
      }
    }
  }
  
  public static String c(String paramString)
  {
    AppMethodBeat.i(147429);
    String str = "";
    try
    {
      paramString = a(InetAddress.getByName(paramString));
      AppMethodBeat.o(147429);
      return paramString;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        paramString = str;
      }
    }
  }
  
  public static String d()
  {
    AppMethodBeat.i(147428);
    try
    {
      Object localObject = new StringBuilder("");
      ((StringBuilder)localObject).append(a());
      ((StringBuilder)localObject).append(c());
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      ((StringBuilder)localObject).append(b());
      ((StringBuilder)localObject).append((int)(Math.random() * 2147483647.0D));
      localObject = dc.a(((StringBuilder)localObject).toString());
      AppMethodBeat.o(147428);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        String str = "";
      }
    }
  }
  
  public static boolean d(String paramString)
  {
    AppMethodBeat.i(147433);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(147433);
      return false;
    }
    paramString = paramString.split("\\.");
    if (paramString.length != 4)
    {
      AppMethodBeat.o(147433);
      return false;
    }
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramString[i];
      try
      {
        int k = Integer.parseInt(str);
        if ((k < 0) || (k > 255))
        {
          AppMethodBeat.o(147433);
          return false;
        }
      }
      catch (NumberFormatException paramString)
      {
        AppMethodBeat.o(147433);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(147433);
    return true;
  }
  
  public static String e()
  {
    int i = 1;
    AppMethodBeat.i(147431);
    try
    {
      String str = d;
      if (str == null) {}
      for (;;)
      {
        if (i != 0) {
          d = Settings.Secure.getString(ac.a().getContentResolver(), "android_id");
        }
        str = d;
        AppMethodBeat.o(147431);
        return str;
        int j = str.trim().length();
        if (j != 0) {
          i = 0;
        }
      }
      return "";
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(147431);
    }
  }
  
  public static String f()
  {
    AppMethodBeat.i(147432);
    try
    {
      String str = "35" + Build.BOARD.length() % 10 + Build.BRAND.length() % 10 + Build.CPU_ABI.length() % 10 + Build.DEVICE.length() % 10 + Build.DISPLAY.length() % 10 + Build.HOST.length() % 10 + Build.ID.length() % 10 + Build.MANUFACTURER.length() % 10 + Build.MODEL.length() % 10 + Build.PRODUCT.length() % 10 + Build.TAGS.length() % 10 + Build.TYPE.length() % 10 + Build.USER.length() % 10;
      AppMethodBeat.o(147432);
      return str;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(147432);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.dd
 * JD-Core Version:    0.7.0.1
 */