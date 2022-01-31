package com.tencent.ttpic.device;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import com.tencent.ttpic.baseutils.LogUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeviceUtils
{
  public static final int COLLAGE_MATERIAL_READ_MAX_SIDE = 720;
  public static final int COLLAGE_READ_LOW_MAX_SIDE = 640;
  public static final int COLLAGE_READ_MAX_SIDE = 720;
  public static final long HIGH_END_CPU_COUNT = 4L;
  public static final long HIGH_END_MEMORY_SIZE = 256L;
  public static final long HIGH_END_SCREEN_SIZE = 1900800L;
  public static final int LAZY_HEIGHT = 854;
  public static final int LAZY_WIDTH = 640;
  public static final int[] LONG_COLLAGE_SAVE_MAX_SIDE;
  public static final long LOW_END_CPU_COUNT = 1L;
  public static final long LOW_END_MEMORY_SIZE = 64L;
  public static final long LOW_END_SCREEN_SIZE = 307200L;
  public static final int MOBILE_NETWORK_2G = 1;
  public static final int MOBILE_NETWORK_3G = 2;
  public static final int MOBILE_NETWORK_4G = 3;
  public static final int MOBILE_NETWORK_DISCONNECT = 5;
  public static final int MOBILE_NETWORK_UNKNOWN = 4;
  public static final int NET_2G = 2;
  public static final int NET_3G = 3;
  public static final int NET_4G = 4;
  public static final int NET_NONE = 0;
  public static final int NET_OTHER = 5;
  public static final int NET_WIFI = 1;
  public static final int[] STORY_COLLAGE_SAVE_MAX_SHORT_SIDE;
  private static final String TAG = DeviceUtils.class.getSimpleName();
  public static final int TOPIC_FEED_PUBLISH_MAX_SHORT_SIDE = 640;
  private static int sCpuCount = 0;
  private static long sMaxCpuFreq;
  private static int sTotalMemory;
  
  static
  {
    LONG_COLLAGE_SAVE_MAX_SIDE = new int[] { 640, 560, 480, 400, 320 };
    STORY_COLLAGE_SAVE_MAX_SHORT_SIDE = new int[] { 960, 720, 640, 560, 480, 400, 320 };
    sTotalMemory = 0;
    sMaxCpuFreq = 0L;
  }
  
  /* Error */
  private static String fetchExternalIpProviderHTML(String paramString)
  {
    // Byte code:
    //   0: new 94	java/net/URL
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 97	java/net/URL:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 101	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   11: checkcast 103	java/net/HttpURLConnection
    //   14: astore_0
    //   15: iconst_1
    //   16: invokestatic 107	java/net/HttpURLConnection:setFollowRedirects	(Z)V
    //   19: aload_0
    //   20: ldc 109
    //   22: invokevirtual 112	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   25: aload_0
    //   26: ldc 114
    //   28: ldc 116
    //   30: invokevirtual 120	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: aload_0
    //   34: invokevirtual 124	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   37: astore_3
    //   38: sipush 1024
    //   41: newarray byte
    //   43: astore 4
    //   45: iconst_0
    //   46: istore_1
    //   47: iload_1
    //   48: sipush 1024
    //   51: if_icmpge +27 -> 78
    //   54: aload_3
    //   55: aload 4
    //   57: iload_1
    //   58: sipush 1024
    //   61: iload_1
    //   62: isub
    //   63: invokevirtual 130	java/io/InputStream:read	([BII)I
    //   66: istore_2
    //   67: iload_2
    //   68: iflt +10 -> 78
    //   71: iload_1
    //   72: iload_2
    //   73: iadd
    //   74: istore_1
    //   75: goto -28 -> 47
    //   78: new 132	java/lang/String
    //   81: dup
    //   82: aload 4
    //   84: ldc 134
    //   86: invokespecial 137	java/lang/String:<init>	([BLjava/lang/String;)V
    //   89: astore 4
    //   91: aload_3
    //   92: ifnull +7 -> 99
    //   95: aload_3
    //   96: invokevirtual 140	java/io/InputStream:close	()V
    //   99: aload_0
    //   100: ifnull +7 -> 107
    //   103: aload_0
    //   104: invokevirtual 143	java/net/HttpURLConnection:disconnect	()V
    //   107: aload 4
    //   109: areturn
    //   110: astore_0
    //   111: aconst_null
    //   112: astore_3
    //   113: aconst_null
    //   114: astore_0
    //   115: aload_0
    //   116: ifnull +7 -> 123
    //   119: aload_0
    //   120: invokevirtual 140	java/io/InputStream:close	()V
    //   123: aload_3
    //   124: ifnull +7 -> 131
    //   127: aload_3
    //   128: invokevirtual 143	java/net/HttpURLConnection:disconnect	()V
    //   131: aconst_null
    //   132: areturn
    //   133: astore_0
    //   134: aconst_null
    //   135: astore_0
    //   136: aconst_null
    //   137: astore_3
    //   138: aload_3
    //   139: ifnull +7 -> 146
    //   142: aload_3
    //   143: invokevirtual 140	java/io/InputStream:close	()V
    //   146: aload_0
    //   147: ifnull -16 -> 131
    //   150: aload_0
    //   151: invokevirtual 143	java/net/HttpURLConnection:disconnect	()V
    //   154: goto -23 -> 131
    //   157: astore_0
    //   158: goto -27 -> 131
    //   161: astore_0
    //   162: aconst_null
    //   163: astore 4
    //   165: aconst_null
    //   166: astore_3
    //   167: aload_3
    //   168: ifnull +7 -> 175
    //   171: aload_3
    //   172: invokevirtual 140	java/io/InputStream:close	()V
    //   175: aload 4
    //   177: ifnull +8 -> 185
    //   180: aload 4
    //   182: invokevirtual 143	java/net/HttpURLConnection:disconnect	()V
    //   185: aload_0
    //   186: athrow
    //   187: astore_3
    //   188: goto -3 -> 185
    //   191: astore_3
    //   192: aload_0
    //   193: astore 4
    //   195: aconst_null
    //   196: astore 5
    //   198: aload_3
    //   199: astore_0
    //   200: aload 5
    //   202: astore_3
    //   203: goto -36 -> 167
    //   206: astore 5
    //   208: aload_0
    //   209: astore 4
    //   211: aload 5
    //   213: astore_0
    //   214: goto -47 -> 167
    //   217: astore_3
    //   218: aconst_null
    //   219: astore_3
    //   220: goto -82 -> 138
    //   223: astore 4
    //   225: goto -87 -> 138
    //   228: astore_0
    //   229: goto -98 -> 131
    //   232: astore_3
    //   233: aconst_null
    //   234: astore 4
    //   236: aload_0
    //   237: astore_3
    //   238: aload 4
    //   240: astore_0
    //   241: goto -126 -> 115
    //   244: astore 4
    //   246: aload_3
    //   247: astore 4
    //   249: aload_0
    //   250: astore_3
    //   251: aload 4
    //   253: astore_0
    //   254: goto -139 -> 115
    //   257: astore_0
    //   258: goto -151 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	paramString	String
    //   46	29	1	i	int
    //   66	8	2	j	int
    //   37	135	3	localInputStream	InputStream
    //   187	1	3	localException	Exception
    //   191	8	3	localObject1	Object
    //   202	1	3	localObject2	Object
    //   217	1	3	localIOException1	IOException
    //   219	1	3	localObject3	Object
    //   232	1	3	localMalformedURLException1	java.net.MalformedURLException
    //   237	14	3	str1	String
    //   43	167	4	localObject4	Object
    //   223	1	4	localIOException2	IOException
    //   234	5	4	localObject5	Object
    //   244	1	4	localMalformedURLException2	java.net.MalformedURLException
    //   247	5	4	str2	String
    //   196	5	5	localObject6	Object
    //   206	6	5	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   0	15	110	java/net/MalformedURLException
    //   0	15	133	java/io/IOException
    //   142	146	157	java/lang/Exception
    //   150	154	157	java/lang/Exception
    //   0	15	161	finally
    //   171	175	187	java/lang/Exception
    //   180	185	187	java/lang/Exception
    //   15	38	191	finally
    //   38	45	206	finally
    //   54	67	206	finally
    //   78	91	206	finally
    //   15	38	217	java/io/IOException
    //   38	45	223	java/io/IOException
    //   54	67	223	java/io/IOException
    //   78	91	223	java/io/IOException
    //   119	123	228	java/lang/Exception
    //   127	131	228	java/lang/Exception
    //   15	38	232	java/net/MalformedURLException
    //   38	45	244	java/net/MalformedURLException
    //   54	67	244	java/net/MalformedURLException
    //   78	91	244	java/net/MalformedURLException
    //   95	99	257	java/lang/Exception
    //   103	107	257	java/lang/Exception
  }
  
  public static String getBuildVersionName(Context paramContext)
  {
    paramContext = getVersionName(paramContext);
    if (TextUtils.isEmpty(paramContext)) {
      return "";
    }
    return paramContext.substring(paramContext.lastIndexOf(".") + 1);
  }
  
  /* Error */
  public static String getCpuName()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 171	java/io/BufferedReader
    //   5: dup
    //   6: new 173	java/io/FileReader
    //   9: dup
    //   10: ldc 175
    //   12: invokespecial 176	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   15: invokespecial 179	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   18: astore_0
    //   19: aload_0
    //   20: invokevirtual 182	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   23: astore_1
    //   24: aload_1
    //   25: ifnull +21 -> 46
    //   28: aload_1
    //   29: ldc 184
    //   31: iconst_2
    //   32: invokevirtual 188	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   35: iconst_1
    //   36: aaload
    //   37: astore_1
    //   38: aload_0
    //   39: invokevirtual 189	java/io/BufferedReader:close	()V
    //   42: aload_1
    //   43: astore_0
    //   44: aload_0
    //   45: areturn
    //   46: aload_0
    //   47: invokevirtual 189	java/io/BufferedReader:close	()V
    //   50: aconst_null
    //   51: areturn
    //   52: astore_0
    //   53: aconst_null
    //   54: areturn
    //   55: astore_0
    //   56: aconst_null
    //   57: astore_1
    //   58: aload_2
    //   59: astore_0
    //   60: aload_1
    //   61: ifnull -17 -> 44
    //   64: aload_1
    //   65: invokevirtual 189	java/io/BufferedReader:close	()V
    //   68: aconst_null
    //   69: areturn
    //   70: astore_0
    //   71: aconst_null
    //   72: areturn
    //   73: astore_0
    //   74: aconst_null
    //   75: astore_1
    //   76: aload_2
    //   77: astore_0
    //   78: aload_1
    //   79: ifnull -35 -> 44
    //   82: aload_1
    //   83: invokevirtual 189	java/io/BufferedReader:close	()V
    //   86: aconst_null
    //   87: areturn
    //   88: astore_0
    //   89: aconst_null
    //   90: areturn
    //   91: astore_0
    //   92: aconst_null
    //   93: astore_1
    //   94: aload_1
    //   95: ifnull +7 -> 102
    //   98: aload_1
    //   99: invokevirtual 189	java/io/BufferedReader:close	()V
    //   102: aload_0
    //   103: athrow
    //   104: astore_0
    //   105: aload_1
    //   106: areturn
    //   107: astore_1
    //   108: goto -6 -> 102
    //   111: astore_1
    //   112: aload_0
    //   113: astore_2
    //   114: aload_1
    //   115: astore_0
    //   116: aload_2
    //   117: astore_1
    //   118: goto -24 -> 94
    //   121: astore_1
    //   122: aload_0
    //   123: astore_1
    //   124: goto -48 -> 76
    //   127: astore_1
    //   128: aload_0
    //   129: astore_1
    //   130: goto -72 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   18	29	0	localObject1	Object
    //   52	1	0	localIOException1	IOException
    //   55	1	0	localFileNotFoundException1	java.io.FileNotFoundException
    //   59	1	0	localObject2	Object
    //   70	1	0	localIOException2	IOException
    //   73	1	0	localIOException3	IOException
    //   77	1	0	localObject3	Object
    //   88	1	0	localIOException4	IOException
    //   91	12	0	localObject4	Object
    //   104	9	0	localIOException5	IOException
    //   115	14	0	localObject5	Object
    //   23	83	1	str	String
    //   107	1	1	localIOException6	IOException
    //   111	4	1	localObject6	Object
    //   117	1	1	localObject7	Object
    //   121	1	1	localIOException7	IOException
    //   123	1	1	localObject8	Object
    //   127	1	1	localFileNotFoundException2	java.io.FileNotFoundException
    //   129	1	1	localObject9	Object
    //   1	116	2	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   46	50	52	java/io/IOException
    //   2	19	55	java/io/FileNotFoundException
    //   64	68	70	java/io/IOException
    //   2	19	73	java/io/IOException
    //   82	86	88	java/io/IOException
    //   2	19	91	finally
    //   38	42	104	java/io/IOException
    //   98	102	107	java/io/IOException
    //   19	24	111	finally
    //   28	38	111	finally
    //   19	24	121	java/io/IOException
    //   28	38	121	java/io/IOException
    //   19	24	127	java/io/FileNotFoundException
    //   28	38	127	java/io/FileNotFoundException
  }
  
  public static String getExternalLocalIpAddress()
  {
    String str = fetchExternalIpProviderHTML("http://checkip.dyndns.org/");
    if (str == null) {
      return null;
    }
    return parse(str);
  }
  
  public static float getHeapAllocatedPercent(Context paramContext)
  {
    long l1 = getHeapAllocatedSizeInKb();
    long l2 = getHeapMaxSizeInKb(paramContext);
    float f = (float)l1 * 1.0F / (float)l2;
    LogUtils.v(TAG, "getHeapAllocatedPercent(), percent = %f", new Object[] { Float.valueOf(f) });
    return f;
  }
  
  public static long getHeapAllocatedSizeInKb()
  {
    long l = getRuntimeTotalMemory(1) - getRuntimeFreeMemory(1);
    LogUtils.v(TAG, "getHeapAllocatedSizeInKb(), heapAllocated = " + (float)l / 1024.0F + "(Mb), " + l + "(Kb)");
    return l;
  }
  
  public static long getHeapMaxSizeInKb(Context paramContext)
  {
    long l = getRuntimeMaxMemory(1);
    try
    {
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      LogUtils.v(TAG, "getHeapMaxSizeInKb(), heap size(Mb) = " + paramContext.getMemoryClass());
      int i = paramContext.getMemoryClass();
      return i * 1024;
    }
    catch (Exception paramContext)
    {
      LogUtils.e(paramContext);
    }
    return l;
  }
  
  public static long getHeapMaxSizeInMb(Context paramContext)
  {
    long l = getRuntimeMaxMemory(2);
    try
    {
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      LogUtils.v(TAG, "getHeapMaxSizeInMb(), heap size(Mb) = " + paramContext.getMemoryClass());
      int i = paramContext.getMemoryClass();
      return i;
    }
    catch (Exception paramContext)
    {
      LogUtils.e(paramContext);
    }
    return l;
  }
  
  public static long getHeapRemainSizeInKb(Context paramContext)
  {
    long l = getHeapMaxSizeInKb(paramContext) - getHeapAllocatedSizeInKb();
    LogUtils.v(TAG, "getHeapRemainSizeInKb(), remainSize = " + (float)l / 1024.0F + "(Mb), " + l + "(Kb)");
    return l;
  }
  
  public static String getImei(Context paramContext)
  {
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
      if (!TextUtils.isEmpty(paramContext))
      {
        LogUtils.i(TAG, "[getImei] IMEI: " + paramContext);
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      LogUtils.e(paramContext);
    }
    return "";
  }
  
  public static long getLargeHeapMaxSizeInKb(Context paramContext)
  {
    long l = getRuntimeMaxMemory(1);
    try
    {
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      LogUtils.v(TAG, "getLargeHeapMaxSizeInKb(), heap size(Mb) = " + paramContext.getLargeMemoryClass());
      int i = paramContext.getLargeMemoryClass();
      return i * 1024;
    }
    catch (Exception paramContext)
    {
      LogUtils.e(paramContext);
    }
    return l;
  }
  
  public static long getLargeHeapRemainSizeInKb(Context paramContext)
  {
    long l = getLargeHeapMaxSizeInKb(paramContext) - getHeapAllocatedSizeInKb();
    LogUtils.v(TAG, "getLargeHeapRemainSizeInKb(), remainSize = " + (float)l / 1024.0F + "(Mb), " + l + "(Kb)");
    return l;
  }
  
  public static String getLocalIpAddress()
  {
    for (;;)
    {
      try
      {
        if (NetworkInterface.getNetworkInterfaces() == null) {
          break label120;
        }
        Enumeration localEnumeration = NetworkInterface.getNetworkInterfaces();
        if (!localEnumeration.hasMoreElements()) {
          break label120;
        }
        if (localEnumeration == null) {
          continue;
        }
        localObject1 = (NetworkInterface)localEnumeration.nextElement();
        if (localObject1 == null) {
          continue;
        }
        localObject1 = ((NetworkInterface)localObject1).getInetAddresses();
      }
      catch (SocketException localSocketException)
      {
        try
        {
          Object localObject1;
          if ((((InetAddress)localObject2).isLoopbackAddress()) || (!(localObject2 instanceof Inet4Address)) || (Inet4Address.getByName(((InetAddress)localObject2).getHostAddress()) == null) || (((InetAddress)localObject2).getHostAddress().equals("null")) || (((InetAddress)localObject2).getHostAddress() == null)) {
            continue;
          }
          Object localObject2 = ((InetAddress)localObject2).getHostAddress().trim();
          return localObject2;
        }
        catch (UnknownHostException localUnknownHostException) {}
        localSocketException = localSocketException;
        LogUtils.e(localSocketException);
      }
      if (((Enumeration)localObject1).hasMoreElements())
      {
        localObject2 = (InetAddress)((Enumeration)localObject1).nextElement();
        label120:
        return "";
      }
    }
  }
  
  /* Error */
  public static String getLocalRealIpAddress()
  {
    // Byte code:
    //   0: invokestatic 322	java/net/NetworkInterface:getNetworkInterfaces	()Ljava/util/Enumeration;
    //   3: astore 7
    //   5: iconst_0
    //   6: istore_0
    //   7: aconst_null
    //   8: astore 6
    //   10: aconst_null
    //   11: astore_2
    //   12: aload 6
    //   14: astore_1
    //   15: aload 7
    //   17: ifnull +209 -> 226
    //   20: aload_2
    //   21: astore 4
    //   23: aload_2
    //   24: astore 5
    //   26: aload 7
    //   28: invokeinterface 328 1 0
    //   33: ifeq +193 -> 226
    //   36: iload_0
    //   37: ifne +189 -> 226
    //   40: aload_2
    //   41: astore 4
    //   43: aload_2
    //   44: astore 5
    //   46: aload 7
    //   48: invokeinterface 332 1 0
    //   53: checkcast 318	java/net/NetworkInterface
    //   56: invokevirtual 335	java/net/NetworkInterface:getInetAddresses	()Ljava/util/Enumeration;
    //   59: astore 8
    //   61: aload_2
    //   62: astore_3
    //   63: aload_1
    //   64: astore 6
    //   66: aload_3
    //   67: astore_2
    //   68: aload_3
    //   69: astore 4
    //   71: aload_3
    //   72: astore 5
    //   74: aload 8
    //   76: invokeinterface 328 1 0
    //   81: ifeq -69 -> 12
    //   84: aload_3
    //   85: astore 4
    //   87: aload_3
    //   88: astore 5
    //   90: aload 8
    //   92: invokeinterface 332 1 0
    //   97: checkcast 337	java/net/InetAddress
    //   100: astore_2
    //   101: aload_3
    //   102: astore 4
    //   104: aload_3
    //   105: astore 5
    //   107: aload_2
    //   108: invokevirtual 362	java/net/InetAddress:isSiteLocalAddress	()Z
    //   111: ifne +55 -> 166
    //   114: aload_3
    //   115: astore 4
    //   117: aload_3
    //   118: astore 5
    //   120: aload_2
    //   121: invokevirtual 340	java/net/InetAddress:isLoopbackAddress	()Z
    //   124: ifne +42 -> 166
    //   127: aload_3
    //   128: astore 4
    //   130: aload_3
    //   131: astore 5
    //   133: aload_2
    //   134: invokevirtual 345	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   137: ldc_w 364
    //   140: invokevirtual 367	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   143: iconst_m1
    //   144: if_icmpne +22 -> 166
    //   147: aload_3
    //   148: astore 4
    //   150: aload_3
    //   151: astore 5
    //   153: aload_2
    //   154: invokevirtual 345	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   157: astore 6
    //   159: iconst_1
    //   160: istore_0
    //   161: aload_3
    //   162: astore_2
    //   163: goto -151 -> 12
    //   166: aload_3
    //   167: astore 4
    //   169: aload_3
    //   170: astore 5
    //   172: aload_2
    //   173: invokevirtual 362	java/net/InetAddress:isSiteLocalAddress	()Z
    //   176: ifeq -113 -> 63
    //   179: aload_3
    //   180: astore 4
    //   182: aload_3
    //   183: astore 5
    //   185: aload_2
    //   186: invokevirtual 340	java/net/InetAddress:isLoopbackAddress	()Z
    //   189: ifne -126 -> 63
    //   192: aload_3
    //   193: astore 4
    //   195: aload_3
    //   196: astore 5
    //   198: aload_2
    //   199: invokevirtual 345	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   202: ldc_w 364
    //   205: invokevirtual 367	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   208: iconst_m1
    //   209: if_icmpne -146 -> 63
    //   212: aload_3
    //   213: astore 4
    //   215: aload_3
    //   216: astore 5
    //   218: aload_2
    //   219: invokevirtual 345	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   222: astore_3
    //   223: goto -160 -> 63
    //   226: aload_1
    //   227: invokestatic 154	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   230: ifne +5 -> 235
    //   233: aload_1
    //   234: areturn
    //   235: invokestatic 369	com/tencent/ttpic/device/DeviceUtils:getExternalLocalIpAddress	()Ljava/lang/String;
    //   238: astore_3
    //   239: aload_3
    //   240: astore_1
    //   241: aload_3
    //   242: invokestatic 154	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   245: ifeq -12 -> 233
    //   248: aload_2
    //   249: areturn
    //   250: astore_1
    //   251: aconst_null
    //   252: astore_2
    //   253: aconst_null
    //   254: astore 5
    //   256: aload_2
    //   257: astore_1
    //   258: aload_2
    //   259: invokestatic 154	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   262: ifeq -29 -> 233
    //   265: invokestatic 369	com/tencent/ttpic/device/DeviceUtils:getExternalLocalIpAddress	()Ljava/lang/String;
    //   268: astore_2
    //   269: aload_2
    //   270: astore_1
    //   271: aload_2
    //   272: invokestatic 154	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   275: ifeq -42 -> 233
    //   278: aload 5
    //   280: areturn
    //   281: astore_1
    //   282: aconst_null
    //   283: astore_2
    //   284: aconst_null
    //   285: astore 4
    //   287: aload_2
    //   288: astore_1
    //   289: aload_2
    //   290: invokestatic 154	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   293: ifeq -60 -> 233
    //   296: invokestatic 369	com/tencent/ttpic/device/DeviceUtils:getExternalLocalIpAddress	()Ljava/lang/String;
    //   299: astore_2
    //   300: aload_2
    //   301: astore_1
    //   302: aload_2
    //   303: invokestatic 154	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   306: ifeq -73 -> 233
    //   309: aload 4
    //   311: areturn
    //   312: astore_2
    //   313: aload_1
    //   314: astore_2
    //   315: goto -28 -> 287
    //   318: astore_2
    //   319: aload_1
    //   320: astore_2
    //   321: goto -65 -> 256
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	155	0	i	int
    //   14	227	1	localObject1	Object
    //   250	1	1	localSocketException1	SocketException
    //   257	14	1	localObject2	Object
    //   281	1	1	localObject3	Object
    //   288	32	1	localObject4	Object
    //   11	292	2	localObject5	Object
    //   312	1	2	localObject6	Object
    //   314	1	2	localObject7	Object
    //   318	1	2	localSocketException2	SocketException
    //   320	1	2	localObject8	Object
    //   62	180	3	localObject9	Object
    //   21	289	4	localObject10	Object
    //   24	255	5	localObject11	Object
    //   8	150	6	localObject12	Object
    //   3	44	7	localEnumeration1	Enumeration
    //   59	32	8	localEnumeration2	Enumeration
    // Exception table:
    //   from	to	target	type
    //   0	5	250	java/net/SocketException
    //   0	5	281	finally
    //   26	36	312	finally
    //   46	61	312	finally
    //   74	84	312	finally
    //   90	101	312	finally
    //   107	114	312	finally
    //   120	127	312	finally
    //   133	147	312	finally
    //   153	159	312	finally
    //   172	179	312	finally
    //   185	192	312	finally
    //   198	212	312	finally
    //   218	223	312	finally
    //   26	36	318	java/net/SocketException
    //   46	61	318	java/net/SocketException
    //   74	84	318	java/net/SocketException
    //   90	101	318	java/net/SocketException
    //   107	114	318	java/net/SocketException
    //   120	127	318	java/net/SocketException
    //   133	147	318	java/net/SocketException
    //   153	159	318	java/net/SocketException
    //   172	179	318	java/net/SocketException
    //   185	192	318	java/net/SocketException
    //   198	212	318	java/net/SocketException
    //   218	223	318	java/net/SocketException
  }
  
  public static String getMachineInfo()
  {
    return DeviceInstance.getInstance().getDeviceName();
  }
  
  public static long getMaxCpuFreq()
  {
    if (sMaxCpuFreq > 0L) {
      return sMaxCpuFreq;
    }
    String str1 = "";
    try
    {
      InputStream localInputStream = new ProcessBuilder(new String[] { "/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq" }).start().getInputStream();
      byte[] arrayOfByte = new byte[24];
      while (localInputStream.read(arrayOfByte) != -1) {
        str1 = str1 + new String(arrayOfByte);
      }
      localInputStream.close();
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        LogUtils.e(localIOException);
        String str2 = "";
        continue;
        try
        {
          sMaxCpuFreq = Long.parseLong(str2);
        }
        catch (NumberFormatException localNumberFormatException)
        {
          sMaxCpuFreq = 1L;
        }
      }
    }
    str1 = str1.trim();
    if ((str1 == null) || (str1.length() == 0))
    {
      sMaxCpuFreq = 1L;
      LogUtils.v("DeviceUtils", "sMaxCpuFreq:" + sMaxCpuFreq);
      return sMaxCpuFreq;
    }
  }
  
  public static int getMobileNetworkType(Context paramContext)
  {
    if (paramContext == null) {
      return 4;
    }
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return 4;
    }
    paramContext = paramContext.getNetworkInfo(0);
    if ((paramContext != null) && (paramContext.isAvailable()) && (paramContext.isConnected()))
    {
      switch (paramContext.getSubtype())
      {
      case 3: 
      case 7: 
      case 11: 
      case 14: 
      default: 
        return 4;
      case 1: 
      case 2: 
      case 4: 
        return 1;
      case 5: 
      case 6: 
      case 8: 
      case 9: 
      case 10: 
      case 12: 
      case 15: 
        return 2;
      }
      return 3;
    }
    return 5;
  }
  
  public static int getNavigationBarHeight(Activity paramActivity)
  {
    if (!isNavigationBarShow(paramActivity)) {
      return 0;
    }
    paramActivity = paramActivity.getResources();
    return paramActivity.getDimensionPixelSize(paramActivity.getIdentifier("navigation_bar_height", "dimen", "android"));
  }
  
  public static int getNetworkType(Context paramContext)
  {
    try
    {
      if (!isNetworkAvailable(paramContext)) {
        return 0;
      }
      if (isWifiNetwork(paramContext)) {
        return 1;
      }
      int i = getMobileNetworkType(paramContext);
      switch (i)
      {
      default: 
        return 5;
      case 1: 
        return 2;
      case 2: 
        return 3;
      }
      return 4;
    }
    catch (Exception paramContext)
    {
      LogUtils.e(paramContext);
    }
    return 5;
  }
  
  public static String getNetworkTypeName(Context paramContext)
  {
    switch (getNetworkType(paramContext))
    {
    default: 
      return "unknow";
    case 0: 
      return "none";
    case 2: 
      return "2G";
    case 3: 
      return "3G";
    case 4: 
      return "4G";
    }
    return "wifi";
  }
  
  public static int getNumCores()
  {
    if (sCpuCount > 0) {
      return sCpuCount;
    }
    for (;;)
    {
      try
      {
        File[] arrayOfFile = new File("/sys/devices/system/cpu/").listFiles(new DeviceUtils.1CpuFilter());
        if (arrayOfFile == null) {
          continue;
        }
        sCpuCount = arrayOfFile.length;
      }
      catch (Throwable localThrowable)
      {
        LogUtils.e(localThrowable);
        sCpuCount = 1;
        continue;
      }
      LogUtils.v("DeviceUtils", "sCpuCount:" + sCpuCount);
      return sCpuCount;
      sCpuCount = 1;
    }
  }
  
  public static String getOSVersion()
  {
    return Build.VERSION.RELEASE;
  }
  
  private static long getRuntimeFreeMemory(int paramInt)
  {
    long l;
    switch (paramInt)
    {
    default: 
      l = Runtime.getRuntime().freeMemory();
    }
    for (;;)
    {
      LogUtils.v(TAG, "[getRuntimeFreeMemory] freeMemory = " + Runtime.getRuntime().freeMemory() / 1024L / 1024L + "(Mb), " + Runtime.getRuntime().freeMemory() / 1024L + "(Kb)");
      return l;
      l = Runtime.getRuntime().freeMemory();
      continue;
      l = Runtime.getRuntime().freeMemory() / 1024L;
      continue;
      l = Runtime.getRuntime().freeMemory() / 1024L / 1024L;
    }
  }
  
  private static long getRuntimeMaxMemory(int paramInt)
  {
    long l = Runtime.getRuntime().maxMemory();
    switch (paramInt)
    {
    }
    for (;;)
    {
      LogUtils.v(TAG, "[getRuntimeMaxMemory] maxMemory = " + Runtime.getRuntime().maxMemory() / 1024L / 1024L + "(Mb), " + Runtime.getRuntime().maxMemory() / 1024L + "(Kb)");
      return l;
      l = Runtime.getRuntime().maxMemory();
      continue;
      l = Runtime.getRuntime().maxMemory() / 1024L;
      continue;
      l = Runtime.getRuntime().maxMemory() / 1024L / 1024L;
    }
  }
  
  public static long getRuntimeRemainSize(int paramInt)
  {
    long l2 = Runtime.getRuntime().maxMemory() - getHeapAllocatedSizeInKb() * 1024L;
    long l1 = l2;
    switch (paramInt)
    {
    default: 
      l1 = l2;
    }
    for (;;)
    {
      LogUtils.v(TAG, "[getRuntimeRemainSize] remainMemory = " + l1 + " " + paramInt);
      return l1;
      l1 = l2 / 1024L;
      continue;
      l1 = l2 / 1048576L;
    }
  }
  
  private static long getRuntimeTotalMemory(int paramInt)
  {
    long l;
    switch (paramInt)
    {
    default: 
      l = Runtime.getRuntime().totalMemory();
    }
    for (;;)
    {
      LogUtils.v(TAG, "[getRuntimeTotalMemory] totalMemory = " + Runtime.getRuntime().totalMemory() / 1024L / 1024L + "(Mb), " + Runtime.getRuntime().totalMemory() / 1024L + "(Kb)");
      return l;
      l = Runtime.getRuntime().totalMemory();
      continue;
      l = Runtime.getRuntime().totalMemory() / 1024L;
      continue;
      l = Runtime.getRuntime().totalMemory() / 1024L / 1024L;
    }
  }
  
  public static int getScreenHeight(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().heightPixels;
  }
  
  public static int getScreenHeightWithNavigationBar(Activity paramActivity)
  {
    return getScreenHeight(paramActivity) + getNavigationBarHeight(paramActivity);
  }
  
  public static String getScreenSize(Context paramContext)
  {
    paramContext = paramContext.getResources().getDisplayMetrics();
    return paramContext.widthPixels + "*" + paramContext.heightPixels;
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  public static int getVersionCode(Context paramContext)
  {
    try
    {
      int i = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 16384).versionCode;
      return i;
    }
    catch (Exception paramContext) {}
    return -1;
  }
  
  public static String getVersionName(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public static boolean isHighEndDevice(Context paramContext)
  {
    boolean bool4 = true;
    LogUtils.i(TAG, "[isHighEndDevice] + BEGIN");
    DeviceInstance.SOC_CLASS localSOC_CLASS = DeviceInstance.getInstance().getDeviceSocClass(DeviceAttrs.getInstance().str_deviceSocInfo);
    LogUtils.i(TAG, "[isHighEndDevice] socClass = " + localSOC_CLASS);
    boolean bool1;
    if (localSOC_CLASS != DeviceInstance.SOC_CLASS.NULL)
    {
      if (localSOC_CLASS == DeviceInstance.SOC_CLASS.HIGH) {}
      for (bool1 = bool4;; bool1 = false)
      {
        LogUtils.i(TAG, "[isHighEndDevice] + END, isHighEndDevice = " + bool1);
        return bool1;
      }
    }
    int i = getScreenWidth(paramContext);
    int j = getScreenHeight(paramContext);
    label122:
    boolean bool2;
    if (i * j >= 1900800L)
    {
      bool1 = true;
      LogUtils.d(TAG, "[isHighEndDevice] isHighDisplay = " + bool1 + ", widthPixels = " + i + ", heightPixels = " + j);
      long l = getHeapMaxSizeInMb(paramContext);
      if (l < 256L) {
        break label295;
      }
      bool2 = true;
      label183:
      LogUtils.d(TAG, "[isHighEndDevice] isHighMemory = " + bool2 + ", deviceHeapSize(Mb) = " + l);
      i = getNumCores();
      if (i < 4L) {
        break label301;
      }
    }
    label295:
    label301:
    for (boolean bool3 = true;; bool3 = false)
    {
      LogUtils.d(TAG, "[isHighEndDevice] isHighCpuCount = " + bool3 + ", cpuCount = " + i);
      if ((bool1) && (bool2))
      {
        bool1 = bool4;
        if (bool3) {
          break;
        }
      }
      bool1 = false;
      break;
      bool1 = false;
      break label122;
      bool2 = false;
      break label183;
    }
  }
  
  public static boolean isLowEndDevice(Context paramContext)
  {
    boolean bool5 = true;
    LogUtils.i(TAG, "[isLowEndDevice] + BEGIN");
    DeviceInstance.SOC_CLASS localSOC_CLASS = DeviceInstance.getInstance().getDeviceSocClass(DeviceAttrs.getInstance().str_deviceSocInfo);
    LogUtils.i(TAG, "[isLowEndDevice] socClass = " + localSOC_CLASS);
    boolean bool1;
    if (localSOC_CLASS != DeviceInstance.SOC_CLASS.NULL)
    {
      if (localSOC_CLASS == DeviceInstance.SOC_CLASS.LOW) {}
      for (bool1 = bool5;; bool1 = false)
      {
        LogUtils.i(TAG, "[isLowEndDevice] + END, isLowEndDevice = " + bool1);
        return bool1;
      }
    }
    int i = getScreenWidth(paramContext);
    int j = getScreenHeight(paramContext);
    boolean bool2;
    label123:
    boolean bool3;
    if (i * j <= 307200L)
    {
      bool2 = true;
      LogUtils.d(TAG, "[isLowEndDevice] isLowEndDisplay = " + bool2 + ", widthPixels = " + i + ", heightPixels = " + j);
      long l = getHeapMaxSizeInMb(paramContext);
      if (l > 64L) {
        break label303;
      }
      bool3 = true;
      label185:
      LogUtils.d(TAG, "[isLowEndDevice] isLowMemory = " + bool3 + ", deviceHeapSize(Mb) = " + l);
      i = getNumCores();
      if (i > 1L) {
        break label309;
      }
    }
    label303:
    label309:
    for (boolean bool4 = true;; bool4 = false)
    {
      LogUtils.d(TAG, "[isLowEndDevice] isLowCpuCount = " + bool4 + ", cpuCount = " + i);
      bool1 = bool5;
      if (bool2) {
        break;
      }
      bool1 = bool5;
      if (bool3) {
        break;
      }
      bool1 = bool5;
      if (bool4) {
        break;
      }
      bool1 = false;
      break;
      bool2 = false;
      break label123;
      bool3 = false;
      break label185;
    }
  }
  
  public static boolean isMiddleEndDevice(Context paramContext)
  {
    boolean bool = true;
    LogUtils.i(TAG, "[isMiddleEndDevice] + BEGIN");
    DeviceInstance.SOC_CLASS localSOC_CLASS = DeviceInstance.getInstance().getDeviceSocClass(DeviceAttrs.getInstance().str_deviceSocInfo);
    LogUtils.i(TAG, "[isMiddleEndDevice] socClass = " + localSOC_CLASS);
    if (localSOC_CLASS != DeviceInstance.SOC_CLASS.NULL) {
      if (localSOC_CLASS != DeviceInstance.SOC_CLASS.NORMAL) {}
    }
    for (;;)
    {
      LogUtils.i(TAG, "[isMiddleEndDevice] + END, isMiddleEndDevice = " + bool);
      return bool;
      bool = false;
      continue;
      if ((isLowEndDevice(paramContext)) || (isHighEndDevice(paramContext))) {
        bool = false;
      }
    }
  }
  
  public static boolean isMobileNetwork(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.getNetworkInfo(0);
    return (paramContext != null) && (paramContext.isAvailable()) && (paramContext.isConnected());
  }
  
  public static boolean isNavigationBarShow(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramActivity = paramActivity.getWindowManager().getDefaultDisplay();
      Point localPoint1 = new Point();
      Point localPoint2 = new Point();
      paramActivity.getSize(localPoint1);
      paramActivity.getRealSize(localPoint2);
      if (localPoint2.y == localPoint1.y) {}
    }
    boolean bool1;
    boolean bool2;
    do
    {
      return true;
      return false;
      bool1 = ViewConfiguration.get(paramActivity).hasPermanentMenuKey();
      bool2 = KeyCharacterMap.deviceHasKey(4);
    } while ((!bool1) && (!bool2));
    return false;
  }
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    return (paramContext != null) && (paramContext.isConnectedOrConnecting());
  }
  
  public static boolean isVeryLowEndDevice()
  {
    boolean bool2 = false;
    LogUtils.i(TAG, "[isVeryLowEndDevice] + BEGIN");
    DeviceInstance.SOC_CLASS localSOC_CLASS = DeviceInstance.getInstance().getDeviceSocClass(DeviceAttrs.getInstance().str_deviceSocInfo);
    LogUtils.i(TAG, "[isVeryLowEndDevice] socClass = " + localSOC_CLASS);
    boolean bool1 = bool2;
    if (localSOC_CLASS != DeviceInstance.SOC_CLASS.NULL)
    {
      bool1 = bool2;
      if (localSOC_CLASS == DeviceInstance.SOC_CLASS.V_LOW) {
        bool1 = true;
      }
    }
    LogUtils.i(TAG, "[isVeryLowEndDevice] + END, isVeryLowDevice = " + bool1);
    return bool1;
  }
  
  public static boolean isWifiNetwork(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.getNetworkInfo(1);
    return (paramContext != null) && (paramContext.isAvailable()) && (paramContext.isConnected());
  }
  
  private static String parse(String paramString)
  {
    paramString = Pattern.compile("(\\d{1,3})[.](\\d{1,3})[.](\\d{1,3})[.](\\d{1,3})", 2).matcher(paramString);
    if (paramString.find()) {
      return paramString.group(0);
    }
    return null;
  }
  
  public static boolean veryLargeScreen(Context paramContext)
  {
    return getScreenHeight(paramContext) * getScreenWidth(paramContext) >= 2073600;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.device.DeviceUtils
 * JD-Core Version:    0.7.0.1
 */