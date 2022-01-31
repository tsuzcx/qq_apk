package com.tencent.ttpic.device;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.ApiHelper;
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
  private static final int MIN_OPENGL_ES_VERSION = 131072;
  public static final int MIN_STORAGE_SIZE = 52428800;
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
  private static final String TAG;
  public static final int TOPIC_FEED_PUBLISH_MAX_SHORT_SIDE = 640;
  private static boolean mIsAllUnusable;
  private static boolean mIsOpenGlEsValid;
  private static int sCpuCount;
  private static long sMaxCpuFreq;
  private static int sTotalMemory;
  
  static
  {
    AppMethodBeat.i(49928);
    TAG = DeviceUtils.class.getSimpleName();
    LONG_COLLAGE_SAVE_MAX_SIDE = new int[] { 640, 560, 480, 400, 320 };
    STORY_COLLAGE_SAVE_MAX_SHORT_SIDE = new int[] { 960, 720, 640, 560, 480, 400, 320 };
    sTotalMemory = 0;
    sMaxCpuFreq = 0L;
    sCpuCount = 0;
    mIsAllUnusable = false;
    mIsOpenGlEsValid = true;
    AppMethodBeat.o(49928);
  }
  
  public static boolean canWriteFile(String paramString)
  {
    AppMethodBeat.i(49921);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(49921);
      return false;
    }
    String str = paramString;
    if (!paramString.endsWith(File.separator)) {
      str = paramString.substring(0, paramString.lastIndexOf(File.separator));
    }
    paramString = new File(str + File.separator + "test_temp.txt");
    try
    {
      if (paramString.exists()) {
        paramString.delete();
      }
      paramString.createNewFile();
      paramString.delete();
      AppMethodBeat.o(49921);
      return true;
    }
    catch (Exception localException)
    {
      paramString.delete();
      AppMethodBeat.o(49921);
    }
    return false;
  }
  
  /* Error */
  private static String fetchExternalIpProviderHTML(String paramString)
  {
    // Byte code:
    //   0: ldc 166
    //   2: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 168	java/net/URL
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 169	java/net/URL:<init>	(Ljava/lang/String;)V
    //   13: invokevirtual 173	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   16: checkcast 175	java/net/HttpURLConnection
    //   19: astore_0
    //   20: iconst_1
    //   21: invokestatic 179	java/net/HttpURLConnection:setFollowRedirects	(Z)V
    //   24: aload_0
    //   25: ldc 181
    //   27: invokevirtual 184	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   30: aload_0
    //   31: ldc 186
    //   33: ldc 188
    //   35: invokevirtual 192	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: aload_0
    //   39: invokevirtual 196	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   42: astore_3
    //   43: sipush 1024
    //   46: newarray byte
    //   48: astore 4
    //   50: iconst_0
    //   51: istore_1
    //   52: iload_1
    //   53: sipush 1024
    //   56: if_icmpge +27 -> 83
    //   59: aload_3
    //   60: aload 4
    //   62: iload_1
    //   63: sipush 1024
    //   66: iload_1
    //   67: isub
    //   68: invokevirtual 202	java/io/InputStream:read	([BII)I
    //   71: istore_2
    //   72: iload_2
    //   73: iflt +10 -> 83
    //   76: iload_1
    //   77: iload_2
    //   78: iadd
    //   79: istore_1
    //   80: goto -28 -> 52
    //   83: new 123	java/lang/String
    //   86: dup
    //   87: aload 4
    //   89: ldc 204
    //   91: invokespecial 207	java/lang/String:<init>	([BLjava/lang/String;)V
    //   94: astore 4
    //   96: aload_3
    //   97: ifnull +7 -> 104
    //   100: aload_3
    //   101: invokevirtual 210	java/io/InputStream:close	()V
    //   104: aload_0
    //   105: ifnull +7 -> 112
    //   108: aload_0
    //   109: invokevirtual 213	java/net/HttpURLConnection:disconnect	()V
    //   112: ldc 166
    //   114: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: aload 4
    //   119: areturn
    //   120: astore_0
    //   121: aconst_null
    //   122: astore_3
    //   123: aconst_null
    //   124: astore_0
    //   125: aload_0
    //   126: ifnull +7 -> 133
    //   129: aload_0
    //   130: invokevirtual 210	java/io/InputStream:close	()V
    //   133: aload_3
    //   134: ifnull +7 -> 141
    //   137: aload_3
    //   138: invokevirtual 213	java/net/HttpURLConnection:disconnect	()V
    //   141: ldc 166
    //   143: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: aconst_null
    //   147: areturn
    //   148: astore_0
    //   149: aconst_null
    //   150: astore_0
    //   151: aconst_null
    //   152: astore_3
    //   153: aload_3
    //   154: ifnull +7 -> 161
    //   157: aload_3
    //   158: invokevirtual 210	java/io/InputStream:close	()V
    //   161: aload_0
    //   162: ifnull -21 -> 141
    //   165: aload_0
    //   166: invokevirtual 213	java/net/HttpURLConnection:disconnect	()V
    //   169: goto -28 -> 141
    //   172: astore_0
    //   173: goto -32 -> 141
    //   176: astore_0
    //   177: aconst_null
    //   178: astore 4
    //   180: aconst_null
    //   181: astore_3
    //   182: aload_3
    //   183: ifnull +7 -> 190
    //   186: aload_3
    //   187: invokevirtual 210	java/io/InputStream:close	()V
    //   190: aload 4
    //   192: ifnull +8 -> 200
    //   195: aload 4
    //   197: invokevirtual 213	java/net/HttpURLConnection:disconnect	()V
    //   200: ldc 166
    //   202: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   205: aload_0
    //   206: athrow
    //   207: astore_3
    //   208: goto -8 -> 200
    //   211: astore_3
    //   212: aload_0
    //   213: astore 4
    //   215: aconst_null
    //   216: astore 5
    //   218: aload_3
    //   219: astore_0
    //   220: aload 5
    //   222: astore_3
    //   223: goto -41 -> 182
    //   226: astore 5
    //   228: aload_0
    //   229: astore 4
    //   231: aload 5
    //   233: astore_0
    //   234: goto -52 -> 182
    //   237: astore_3
    //   238: aconst_null
    //   239: astore_3
    //   240: goto -87 -> 153
    //   243: astore 4
    //   245: goto -92 -> 153
    //   248: astore_0
    //   249: goto -108 -> 141
    //   252: astore_3
    //   253: aconst_null
    //   254: astore 4
    //   256: aload_0
    //   257: astore_3
    //   258: aload 4
    //   260: astore_0
    //   261: goto -136 -> 125
    //   264: astore 4
    //   266: aload_3
    //   267: astore 4
    //   269: aload_0
    //   270: astore_3
    //   271: aload 4
    //   273: astore_0
    //   274: goto -149 -> 125
    //   277: astore_0
    //   278: goto -166 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	281	0	paramString	String
    //   51	29	1	i	int
    //   71	8	2	j	int
    //   42	145	3	localInputStream	InputStream
    //   207	1	3	localException	Exception
    //   211	8	3	localObject1	Object
    //   222	1	3	localObject2	Object
    //   237	1	3	localIOException1	IOException
    //   239	1	3	localObject3	Object
    //   252	1	3	localMalformedURLException1	java.net.MalformedURLException
    //   257	14	3	str1	String
    //   48	182	4	localObject4	Object
    //   243	1	4	localIOException2	IOException
    //   254	5	4	localObject5	Object
    //   264	1	4	localMalformedURLException2	java.net.MalformedURLException
    //   267	5	4	str2	String
    //   216	5	5	localObject6	Object
    //   226	6	5	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   5	20	120	java/net/MalformedURLException
    //   5	20	148	java/io/IOException
    //   157	161	172	java/lang/Exception
    //   165	169	172	java/lang/Exception
    //   5	20	176	finally
    //   186	190	207	java/lang/Exception
    //   195	200	207	java/lang/Exception
    //   20	43	211	finally
    //   43	50	226	finally
    //   59	72	226	finally
    //   83	96	226	finally
    //   20	43	237	java/io/IOException
    //   43	50	243	java/io/IOException
    //   59	72	243	java/io/IOException
    //   83	96	243	java/io/IOException
    //   129	133	248	java/lang/Exception
    //   137	141	248	java/lang/Exception
    //   20	43	252	java/net/MalformedURLException
    //   43	50	264	java/net/MalformedURLException
    //   59	72	264	java/net/MalformedURLException
    //   83	96	264	java/net/MalformedURLException
    //   100	104	277	java/lang/Exception
    //   108	112	277	java/lang/Exception
  }
  
  @TargetApi(18)
  public static long getAvailableSize(StatFs paramStatFs)
  {
    AppMethodBeat.i(49893);
    if (ApiHelper.hasJellyBeanMR2()) {}
    for (long l = paramStatFs.getAvailableBytes();; l = paramStatFs.getAvailableBlocks() * paramStatFs.getBlockSize())
    {
      AppMethodBeat.o(49893);
      return l;
    }
  }
  
  public static String getBuildVersionName(Context paramContext)
  {
    AppMethodBeat.i(49901);
    paramContext = getVersionName(paramContext);
    if (TextUtils.isEmpty(paramContext))
    {
      AppMethodBeat.o(49901);
      return "";
    }
    paramContext = paramContext.substring(paramContext.lastIndexOf(".") + 1);
    AppMethodBeat.o(49901);
    return paramContext;
  }
  
  /* Error */
  public static String getCpuName()
  {
    // Byte code:
    //   0: ldc 255
    //   2: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 257	java/io/BufferedReader
    //   8: dup
    //   9: new 259	java/io/FileReader
    //   12: dup
    //   13: ldc_w 261
    //   16: invokespecial 262	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   19: invokespecial 265	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   22: astore_0
    //   23: aload_0
    //   24: invokevirtual 268	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   27: astore_1
    //   28: aload_1
    //   29: ifnull +25 -> 54
    //   32: aload_1
    //   33: ldc_w 270
    //   36: iconst_2
    //   37: invokevirtual 274	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   40: iconst_1
    //   41: aaload
    //   42: astore_1
    //   43: aload_0
    //   44: invokevirtual 275	java/io/BufferedReader:close	()V
    //   47: ldc 255
    //   49: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: aload_1
    //   53: areturn
    //   54: aload_0
    //   55: invokevirtual 275	java/io/BufferedReader:close	()V
    //   58: ldc 255
    //   60: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: aconst_null
    //   64: areturn
    //   65: astore_0
    //   66: aconst_null
    //   67: astore_0
    //   68: aload_0
    //   69: ifnull -11 -> 58
    //   72: aload_0
    //   73: invokevirtual 275	java/io/BufferedReader:close	()V
    //   76: goto -18 -> 58
    //   79: astore_0
    //   80: goto -22 -> 58
    //   83: astore_0
    //   84: aconst_null
    //   85: astore_0
    //   86: aload_0
    //   87: ifnull -29 -> 58
    //   90: aload_0
    //   91: invokevirtual 275	java/io/BufferedReader:close	()V
    //   94: goto -36 -> 58
    //   97: astore_0
    //   98: goto -40 -> 58
    //   101: astore_0
    //   102: aconst_null
    //   103: astore_1
    //   104: aload_1
    //   105: ifnull +7 -> 112
    //   108: aload_1
    //   109: invokevirtual 275	java/io/BufferedReader:close	()V
    //   112: ldc 255
    //   114: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: aload_0
    //   118: athrow
    //   119: astore_0
    //   120: goto -73 -> 47
    //   123: astore_0
    //   124: goto -66 -> 58
    //   127: astore_1
    //   128: goto -16 -> 112
    //   131: astore_1
    //   132: aload_0
    //   133: astore_2
    //   134: aload_1
    //   135: astore_0
    //   136: aload_2
    //   137: astore_1
    //   138: goto -34 -> 104
    //   141: astore_1
    //   142: goto -56 -> 86
    //   145: astore_1
    //   146: goto -78 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   22	33	0	localBufferedReader	java.io.BufferedReader
    //   65	1	0	localFileNotFoundException1	java.io.FileNotFoundException
    //   67	6	0	localObject1	Object
    //   79	1	0	localIOException1	IOException
    //   83	1	0	localIOException2	IOException
    //   85	6	0	localObject2	Object
    //   97	1	0	localIOException3	IOException
    //   101	17	0	localObject3	Object
    //   119	1	0	localIOException4	IOException
    //   123	10	0	localIOException5	IOException
    //   135	1	0	localObject4	Object
    //   27	82	1	str	String
    //   127	1	1	localIOException6	IOException
    //   131	4	1	localObject5	Object
    //   137	1	1	localObject6	Object
    //   141	1	1	localIOException7	IOException
    //   145	1	1	localFileNotFoundException2	java.io.FileNotFoundException
    //   133	4	2	localIOException8	IOException
    // Exception table:
    //   from	to	target	type
    //   5	23	65	java/io/FileNotFoundException
    //   72	76	79	java/io/IOException
    //   5	23	83	java/io/IOException
    //   90	94	97	java/io/IOException
    //   5	23	101	finally
    //   43	47	119	java/io/IOException
    //   54	58	123	java/io/IOException
    //   108	112	127	java/io/IOException
    //   23	28	131	finally
    //   32	43	131	finally
    //   23	28	141	java/io/IOException
    //   32	43	141	java/io/IOException
    //   23	28	145	java/io/FileNotFoundException
    //   32	43	145	java/io/FileNotFoundException
  }
  
  public static File getExternalFilesDir(Context paramContext)
  {
    AppMethodBeat.i(49896);
    File localFile2 = paramContext.getExternalFilesDir(null);
    File localFile1 = localFile2;
    if (localFile2 == null)
    {
      paramContext = "/Android/data/" + paramContext.getPackageName() + "/files/";
      localFile1 = new File(Environment.getExternalStorageDirectory().getPath() + paramContext);
    }
    AppMethodBeat.o(49896);
    return localFile1;
  }
  
  public static File getExternalFilesDir(Context paramContext, String paramString)
  {
    AppMethodBeat.i(49897);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (isExternalStorageAvailable())
    {
      localObject1 = localObject2;
      if (isExternalStorageSpaceEnough(52428800L)) {
        localObject1 = getExternalFilesDir(paramContext).getPath();
      }
    }
    paramContext = new File((String)localObject1 + File.separator + paramString);
    try
    {
      if ((paramContext.exists()) && (paramContext.isFile())) {
        paramContext.delete();
      }
      if (!paramContext.exists()) {
        paramContext.mkdirs();
      }
    }
    catch (Exception paramString)
    {
      label98:
      break label98;
    }
    AppMethodBeat.o(49897);
    return paramContext;
  }
  
  public static String getExternalLocalIpAddress()
  {
    AppMethodBeat.i(49918);
    String str = fetchExternalIpProviderHTML("http://checkip.dyndns.org/");
    if (str == null)
    {
      AppMethodBeat.o(49918);
      return null;
    }
    str = parse(str);
    AppMethodBeat.o(49918);
    return str;
  }
  
  public static float getHeapAllocatedPercent(Context paramContext)
  {
    AppMethodBeat.i(49883);
    long l1 = getHeapAllocatedSizeInKb();
    long l2 = getHeapMaxSizeInKb(paramContext);
    float f = (float)l1 * 1.0F / (float)l2;
    LogUtils.v(TAG, "getHeapAllocatedPercent(), percent = %f", new Object[] { Float.valueOf(f) });
    AppMethodBeat.o(49883);
    return f;
  }
  
  public static long getHeapAllocatedSizeInKb()
  {
    AppMethodBeat.i(49882);
    long l = getRuntimeTotalMemory(1) - getRuntimeFreeMemory(1);
    LogUtils.v(TAG, "getHeapAllocatedSizeInKb(), heapAllocated = " + (float)l / 1024.0F + "(Mb), " + l + "(Kb)");
    AppMethodBeat.o(49882);
    return l;
  }
  
  public static long getHeapMaxSizeInKb(Context paramContext)
  {
    AppMethodBeat.i(49878);
    long l = getRuntimeMaxMemory(1);
    try
    {
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      LogUtils.v(TAG, "getHeapMaxSizeInKb(), heap size(Mb) = " + paramContext.getMemoryClass());
      int i = paramContext.getMemoryClass();
      l = i * 1024;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        LogUtils.e(paramContext);
      }
    }
    AppMethodBeat.o(49878);
    return l;
  }
  
  public static long getHeapMaxSizeInMb(Context paramContext)
  {
    AppMethodBeat.i(49877);
    long l = getRuntimeMaxMemory(2);
    try
    {
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      LogUtils.v(TAG, "getHeapMaxSizeInMb(), heap size(Mb) = " + paramContext.getMemoryClass());
      int i = paramContext.getMemoryClass();
      l = i;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        LogUtils.e(paramContext);
      }
    }
    AppMethodBeat.o(49877);
    return l;
  }
  
  public static long getHeapRemainSizeInKb(Context paramContext)
  {
    AppMethodBeat.i(49880);
    long l = getHeapMaxSizeInKb(paramContext) - getHeapAllocatedSizeInKb();
    LogUtils.v(TAG, "getHeapRemainSizeInKb(), remainSize = " + (float)l / 1024.0F + "(Mb), " + l + "(Kb)");
    AppMethodBeat.o(49880);
    return l;
  }
  
  public static String getImei(Context paramContext)
  {
    AppMethodBeat.i(49891);
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
      if (!TextUtils.isEmpty(paramContext))
      {
        LogUtils.i(TAG, "[getImei] IMEI: ".concat(String.valueOf(paramContext)));
        AppMethodBeat.o(49891);
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      LogUtils.e(paramContext);
      AppMethodBeat.o(49891);
    }
    return "";
  }
  
  public static long getLargeHeapMaxSizeInKb(Context paramContext)
  {
    AppMethodBeat.i(49879);
    long l = getRuntimeMaxMemory(1);
    try
    {
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      LogUtils.v(TAG, "getLargeHeapMaxSizeInKb(), heap size(Mb) = " + paramContext.getLargeMemoryClass());
      int i = paramContext.getLargeMemoryClass();
      l = i * 1024;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        LogUtils.e(paramContext);
      }
    }
    AppMethodBeat.o(49879);
    return l;
  }
  
  public static long getLargeHeapRemainSizeInKb(Context paramContext)
  {
    AppMethodBeat.i(49881);
    long l = getLargeHeapMaxSizeInKb(paramContext) - getHeapAllocatedSizeInKb();
    LogUtils.v(TAG, "getLargeHeapRemainSizeInKb(), remainSize = " + (float)l / 1024.0F + "(Mb), " + l + "(Kb)");
    AppMethodBeat.o(49881);
    return l;
  }
  
  public static String getLocalIpAddress()
  {
    AppMethodBeat.i(49911);
    for (;;)
    {
      try
      {
        if (NetworkInterface.getNetworkInterfaces() == null) {
          continue;
        }
        Enumeration localEnumeration = NetworkInterface.getNetworkInterfaces();
        if (!localEnumeration.hasMoreElements()) {
          continue;
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
          AppMethodBeat.o(49911);
          return localObject2;
        }
        catch (UnknownHostException localUnknownHostException) {}
        localSocketException = localSocketException;
        LogUtils.e(localSocketException);
        AppMethodBeat.o(49911);
        return "";
      }
      if (((Enumeration)localObject1).hasMoreElements()) {
        localObject2 = (InetAddress)((Enumeration)localObject1).nextElement();
      }
    }
  }
  
  /* Error */
  public static String getLocalRealIpAddress()
  {
    // Byte code:
    //   0: ldc_w 490
    //   3: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 453	java/net/NetworkInterface:getNetworkInterfaces	()Ljava/util/Enumeration;
    //   9: astore 7
    //   11: iconst_0
    //   12: istore_0
    //   13: aconst_null
    //   14: astore 6
    //   16: aconst_null
    //   17: astore_1
    //   18: aload 6
    //   20: astore_3
    //   21: aload 7
    //   23: ifnull +209 -> 232
    //   26: aload_1
    //   27: astore 4
    //   29: aload_1
    //   30: astore 5
    //   32: aload 7
    //   34: invokeinterface 458 1 0
    //   39: ifeq +193 -> 232
    //   42: iload_0
    //   43: ifne +189 -> 232
    //   46: aload_1
    //   47: astore 4
    //   49: aload_1
    //   50: astore 5
    //   52: aload 7
    //   54: invokeinterface 462 1 0
    //   59: checkcast 449	java/net/NetworkInterface
    //   62: invokevirtual 465	java/net/NetworkInterface:getInetAddresses	()Ljava/util/Enumeration;
    //   65: astore 8
    //   67: aload_1
    //   68: astore_2
    //   69: aload_3
    //   70: astore 6
    //   72: aload_2
    //   73: astore_1
    //   74: aload_2
    //   75: astore 4
    //   77: aload_2
    //   78: astore 5
    //   80: aload 8
    //   82: invokeinterface 458 1 0
    //   87: ifeq -69 -> 18
    //   90: aload_2
    //   91: astore 4
    //   93: aload_2
    //   94: astore 5
    //   96: aload 8
    //   98: invokeinterface 462 1 0
    //   103: checkcast 467	java/net/InetAddress
    //   106: astore_1
    //   107: aload_2
    //   108: astore 4
    //   110: aload_2
    //   111: astore 5
    //   113: aload_1
    //   114: invokevirtual 493	java/net/InetAddress:isSiteLocalAddress	()Z
    //   117: ifne +55 -> 172
    //   120: aload_2
    //   121: astore 4
    //   123: aload_2
    //   124: astore 5
    //   126: aload_1
    //   127: invokevirtual 470	java/net/InetAddress:isLoopbackAddress	()Z
    //   130: ifne +42 -> 172
    //   133: aload_2
    //   134: astore 4
    //   136: aload_2
    //   137: astore 5
    //   139: aload_1
    //   140: invokevirtual 475	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   143: ldc_w 495
    //   146: invokevirtual 498	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   149: iconst_m1
    //   150: if_icmpne +22 -> 172
    //   153: aload_2
    //   154: astore 4
    //   156: aload_2
    //   157: astore 5
    //   159: aload_1
    //   160: invokevirtual 475	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   163: astore 6
    //   165: iconst_1
    //   166: istore_0
    //   167: aload_2
    //   168: astore_1
    //   169: goto -151 -> 18
    //   172: aload_2
    //   173: astore 4
    //   175: aload_2
    //   176: astore 5
    //   178: aload_1
    //   179: invokevirtual 493	java/net/InetAddress:isSiteLocalAddress	()Z
    //   182: ifeq -113 -> 69
    //   185: aload_2
    //   186: astore 4
    //   188: aload_2
    //   189: astore 5
    //   191: aload_1
    //   192: invokevirtual 470	java/net/InetAddress:isLoopbackAddress	()Z
    //   195: ifne -126 -> 69
    //   198: aload_2
    //   199: astore 4
    //   201: aload_2
    //   202: astore 5
    //   204: aload_1
    //   205: invokevirtual 475	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   208: ldc_w 495
    //   211: invokevirtual 498	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   214: iconst_m1
    //   215: if_icmpne -146 -> 69
    //   218: aload_2
    //   219: astore 4
    //   221: aload_2
    //   222: astore 5
    //   224: aload_1
    //   225: invokevirtual 475	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   228: astore_2
    //   229: goto -160 -> 69
    //   232: aload_3
    //   233: invokestatic 116	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   236: ifne +11 -> 247
    //   239: ldc_w 490
    //   242: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   245: aload_3
    //   246: areturn
    //   247: invokestatic 500	com/tencent/ttpic/device/DeviceUtils:getExternalLocalIpAddress	()Ljava/lang/String;
    //   250: astore_2
    //   251: aload_2
    //   252: invokestatic 116	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   255: ifne +11 -> 266
    //   258: ldc_w 490
    //   261: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   264: aload_2
    //   265: areturn
    //   266: ldc_w 490
    //   269: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   272: aload_1
    //   273: areturn
    //   274: astore_1
    //   275: aconst_null
    //   276: astore_1
    //   277: aconst_null
    //   278: astore 5
    //   280: aload_1
    //   281: invokestatic 116	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   284: ifne +11 -> 295
    //   287: ldc_w 490
    //   290: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   293: aload_1
    //   294: areturn
    //   295: invokestatic 500	com/tencent/ttpic/device/DeviceUtils:getExternalLocalIpAddress	()Ljava/lang/String;
    //   298: astore_1
    //   299: aload_1
    //   300: invokestatic 116	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   303: ifne +11 -> 314
    //   306: ldc_w 490
    //   309: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   312: aload_1
    //   313: areturn
    //   314: ldc_w 490
    //   317: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   320: aload 5
    //   322: areturn
    //   323: astore_1
    //   324: aconst_null
    //   325: astore_1
    //   326: aconst_null
    //   327: astore 4
    //   329: aload_1
    //   330: invokestatic 116	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   333: ifne +11 -> 344
    //   336: ldc_w 490
    //   339: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   342: aload_1
    //   343: areturn
    //   344: invokestatic 500	com/tencent/ttpic/device/DeviceUtils:getExternalLocalIpAddress	()Ljava/lang/String;
    //   347: astore_1
    //   348: aload_1
    //   349: invokestatic 116	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   352: ifne +11 -> 363
    //   355: ldc_w 490
    //   358: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   361: aload_1
    //   362: areturn
    //   363: ldc_w 490
    //   366: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   369: aload 4
    //   371: areturn
    //   372: astore_1
    //   373: aload_3
    //   374: astore_1
    //   375: goto -46 -> 329
    //   378: astore_1
    //   379: aload_3
    //   380: astore_1
    //   381: goto -101 -> 280
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	155	0	i	int
    //   17	256	1	localObject1	Object
    //   274	1	1	localSocketException1	SocketException
    //   276	37	1	localObject2	Object
    //   323	1	1	localObject3	Object
    //   325	37	1	localObject4	Object
    //   372	1	1	localObject5	Object
    //   374	1	1	localObject6	Object
    //   378	1	1	localSocketException2	SocketException
    //   380	1	1	localObject7	Object
    //   68	197	2	localObject8	Object
    //   20	360	3	localObject9	Object
    //   27	343	4	localObject10	Object
    //   30	291	5	localObject11	Object
    //   14	150	6	localObject12	Object
    //   9	44	7	localEnumeration1	Enumeration
    //   65	32	8	localEnumeration2	Enumeration
    // Exception table:
    //   from	to	target	type
    //   6	11	274	java/net/SocketException
    //   6	11	323	finally
    //   32	42	372	finally
    //   52	67	372	finally
    //   80	90	372	finally
    //   96	107	372	finally
    //   113	120	372	finally
    //   126	133	372	finally
    //   139	153	372	finally
    //   159	165	372	finally
    //   178	185	372	finally
    //   191	198	372	finally
    //   204	218	372	finally
    //   224	229	372	finally
    //   32	42	378	java/net/SocketException
    //   52	67	378	java/net/SocketException
    //   80	90	378	java/net/SocketException
    //   96	107	378	java/net/SocketException
    //   113	120	378	java/net/SocketException
    //   126	133	378	java/net/SocketException
    //   139	153	378	java/net/SocketException
    //   159	165	378	java/net/SocketException
    //   178	185	378	java/net/SocketException
    //   191	198	378	java/net/SocketException
    //   204	218	378	java/net/SocketException
    //   224	229	378	java/net/SocketException
  }
  
  public static String getMachineInfo()
  {
    AppMethodBeat.i(49902);
    String str = DeviceInstance.getInstance().getDeviceName();
    AppMethodBeat.o(49902);
    return str;
  }
  
  public static long getMaxCpuFreq()
  {
    AppMethodBeat.i(49889);
    long l;
    if (sMaxCpuFreq > 0L)
    {
      l = sMaxCpuFreq;
      AppMethodBeat.o(49889);
      return l;
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
      l = sMaxCpuFreq;
      AppMethodBeat.o(49889);
      return l;
    }
  }
  
  public static int getMobileNetworkType(Context paramContext)
  {
    AppMethodBeat.i(49916);
    if (paramContext == null)
    {
      AppMethodBeat.o(49916);
      return 4;
    }
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null)
    {
      AppMethodBeat.o(49916);
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
        AppMethodBeat.o(49916);
        return 4;
      case 1: 
      case 2: 
      case 4: 
        AppMethodBeat.o(49916);
        return 1;
      case 5: 
      case 6: 
      case 8: 
      case 9: 
      case 10: 
      case 12: 
      case 15: 
        AppMethodBeat.o(49916);
        return 2;
      }
      AppMethodBeat.o(49916);
      return 3;
    }
    AppMethodBeat.o(49916);
    return 5;
  }
  
  public static int getNavigationBarHeight(Activity paramActivity)
  {
    AppMethodBeat.i(49907);
    if (!isNavigationBarShow(paramActivity))
    {
      AppMethodBeat.o(49907);
      return 0;
    }
    paramActivity = paramActivity.getResources();
    int i = paramActivity.getDimensionPixelSize(paramActivity.getIdentifier("navigation_bar_height", "dimen", "android"));
    AppMethodBeat.o(49907);
    return i;
  }
  
  public static int getNetworkType(Context paramContext)
  {
    AppMethodBeat.i(49915);
    int i = 5;
    for (;;)
    {
      try
      {
        boolean bool = isNetworkAvailable(paramContext);
        if (bool) {
          continue;
        }
        i = 0;
      }
      catch (Exception paramContext)
      {
        int j;
        LogUtils.e(paramContext);
        continue;
      }
      AppMethodBeat.o(49915);
      return i;
      if (isWifiNetwork(paramContext))
      {
        i = 1;
      }
      else
      {
        j = getMobileNetworkType(paramContext);
        switch (j)
        {
        default: 
          break;
        case 1: 
          i = 2;
          break;
        case 2: 
          i = 3;
          break;
        case 3: 
          i = 4;
        }
      }
    }
  }
  
  public static String getNetworkTypeName(Context paramContext)
  {
    AppMethodBeat.i(49917);
    switch (getNetworkType(paramContext))
    {
    default: 
      AppMethodBeat.o(49917);
      return "unknow";
    case 0: 
      AppMethodBeat.o(49917);
      return "none";
    case 2: 
      AppMethodBeat.o(49917);
      return "2G";
    case 3: 
      AppMethodBeat.o(49917);
      return "3G";
    case 4: 
      AppMethodBeat.o(49917);
      return "4G";
    }
    AppMethodBeat.o(49917);
    return "wifi";
  }
  
  public static int getNumCores()
  {
    AppMethodBeat.i(49888);
    int i;
    if (sCpuCount > 0)
    {
      i = sCpuCount;
      AppMethodBeat.o(49888);
      return i;
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
      i = sCpuCount;
      AppMethodBeat.o(49888);
      return i;
      sCpuCount = 1;
    }
  }
  
  public static String getOSVersion()
  {
    return Build.VERSION.RELEASE;
  }
  
  public static int getOpenGlEsVersion(Context paramContext)
  {
    AppMethodBeat.i(49905);
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getDeviceConfigurationInfo();
    if (paramContext != null)
    {
      int i = paramContext.reqGlEsVersion;
      AppMethodBeat.o(49905);
      return i;
    }
    AppMethodBeat.o(49905);
    return 65536;
  }
  
  private static long getRuntimeFreeMemory(int paramInt)
  {
    AppMethodBeat.i(49887);
    long l;
    switch (paramInt)
    {
    default: 
      l = Runtime.getRuntime().freeMemory();
    }
    for (;;)
    {
      LogUtils.v(TAG, "[getRuntimeFreeMemory] freeMemory = " + Runtime.getRuntime().freeMemory() / 1024L / 1024L + "(Mb), " + Runtime.getRuntime().freeMemory() / 1024L + "(Kb)");
      AppMethodBeat.o(49887);
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
    AppMethodBeat.i(49884);
    long l = Runtime.getRuntime().maxMemory();
    switch (paramInt)
    {
    }
    for (;;)
    {
      LogUtils.v(TAG, "[getRuntimeMaxMemory] maxMemory = " + Runtime.getRuntime().maxMemory() / 1024L / 1024L + "(Mb), " + Runtime.getRuntime().maxMemory() / 1024L + "(Kb)");
      AppMethodBeat.o(49884);
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
    AppMethodBeat.i(49885);
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
      AppMethodBeat.o(49885);
      return l1;
      l1 = l2 / 1024L;
      continue;
      l1 = l2 / 1048576L;
    }
  }
  
  private static long getRuntimeTotalMemory(int paramInt)
  {
    AppMethodBeat.i(49886);
    long l;
    switch (paramInt)
    {
    default: 
      l = Runtime.getRuntime().totalMemory();
    }
    for (;;)
    {
      LogUtils.v(TAG, "[getRuntimeTotalMemory] totalMemory = " + Runtime.getRuntime().totalMemory() / 1024L / 1024L + "(Mb), " + Runtime.getRuntime().totalMemory() / 1024L + "(Kb)");
      AppMethodBeat.o(49886);
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
    AppMethodBeat.i(49875);
    int i = paramContext.getResources().getDisplayMetrics().heightPixels;
    AppMethodBeat.o(49875);
    return i;
  }
  
  public static int getScreenHeightWithNavigationBar(Activity paramActivity)
  {
    AppMethodBeat.i(49906);
    int i = getScreenHeight(paramActivity);
    int j = getNavigationBarHeight(paramActivity);
    AppMethodBeat.o(49906);
    return i + j;
  }
  
  public static float getScreenRatio(Context paramContext)
  {
    AppMethodBeat.i(49876);
    int i = getScreenWidth(paramContext);
    int k = getScreenHeight(paramContext);
    int j = Math.max(i, k);
    k = Math.min(i, k);
    i = j;
    if (NotchInScreenUtils.hasNotchInScreenHw(paramContext)) {
      i = j - NotchInScreenUtils.getNotchHeightHw(paramContext);
    }
    float f = k * 1.0F / i;
    AppMethodBeat.o(49876);
    return f;
  }
  
  public static String getScreenSize(Context paramContext)
  {
    AppMethodBeat.i(49909);
    paramContext = paramContext.getResources().getDisplayMetrics();
    paramContext = paramContext.widthPixels + "*" + paramContext.heightPixels;
    AppMethodBeat.o(49909);
    return paramContext;
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    AppMethodBeat.i(49874);
    int i = paramContext.getResources().getDisplayMetrics().widthPixels;
    AppMethodBeat.o(49874);
    return i;
  }
  
  public static int getSystemScreenBrightness(ContentResolver paramContentResolver)
  {
    AppMethodBeat.i(49924);
    int i = 0;
    try
    {
      int j = Settings.System.getInt(paramContentResolver, "screen_brightness");
      i = j;
    }
    catch (Exception paramContentResolver)
    {
      for (;;)
      {
        LogUtils.e(paramContentResolver);
      }
    }
    AppMethodBeat.o(49924);
    return i;
  }
  
  public static int getSystemScreenMode(ContentResolver paramContentResolver)
  {
    AppMethodBeat.i(49925);
    int i = -1;
    try
    {
      int j = Settings.System.getInt(paramContentResolver, "screen_brightness_mode");
      i = j;
    }
    catch (Exception paramContentResolver)
    {
      for (;;)
      {
        LogUtils.e(paramContentResolver);
      }
    }
    AppMethodBeat.o(49925);
    return i;
  }
  
  @TargetApi(18)
  public static long getTotalSize(StatFs paramStatFs)
  {
    AppMethodBeat.i(49892);
    if (ApiHelper.hasJellyBeanMR2()) {}
    for (long l = paramStatFs.getTotalBytes();; l = paramStatFs.getBlockCount() * paramStatFs.getBlockSize())
    {
      AppMethodBeat.o(49892);
      return l;
    }
  }
  
  public static int getVersionCode(Context paramContext)
  {
    AppMethodBeat.i(49898);
    try
    {
      int i = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 16384).versionCode;
      AppMethodBeat.o(49898);
      return i;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(49898);
    }
    return -1;
  }
  
  public static String getVersionName(Context paramContext)
  {
    AppMethodBeat.i(49900);
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      AppMethodBeat.o(49900);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(49900);
    }
    return null;
  }
  
  public static int getVersionNameCode(Context paramContext)
  {
    AppMethodBeat.i(49899);
    String[] arrayOfString = getVersionName(paramContext).split("\\.");
    paramContext = "";
    if (arrayOfString.length >= 3) {
      paramContext = arrayOfString[0] + arrayOfString[1] + arrayOfString[2];
    }
    try
    {
      int i = Integer.parseInt(paramContext);
      AppMethodBeat.o(49899);
      return i;
    }
    catch (Throwable paramContext)
    {
      LogUtils.e(paramContext);
      AppMethodBeat.o(49899);
    }
    return 0;
  }
  
  public static float getWindowScreenBrightness(Window paramWindow)
  {
    AppMethodBeat.i(49922);
    float f = paramWindow.getAttributes().screenBrightness;
    AppMethodBeat.o(49922);
    return f;
  }
  
  public static boolean isExternalStorageAvailable()
  {
    AppMethodBeat.i(49894);
    try
    {
      if (("mounted".equals(Environment.getExternalStorageState())) || (!Environment.isExternalStorageRemovable()))
      {
        new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
        AppMethodBeat.o(49894);
        return true;
      }
      AppMethodBeat.o(49894);
      return false;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(49894);
    }
    return false;
  }
  
  public static boolean isExternalStorageSpaceEnough(long paramLong)
  {
    AppMethodBeat.i(49895);
    File localFile = Environment.getExternalStorageDirectory();
    try
    {
      if (getAvailableSize(new StatFs(localFile.getAbsolutePath())) > paramLong)
      {
        AppMethodBeat.o(49895);
        return true;
      }
      AppMethodBeat.o(49895);
      return false;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      AppMethodBeat.o(49895);
    }
    return false;
  }
  
  public static boolean isHighEndDevice(Context paramContext)
  {
    boolean bool4 = true;
    AppMethodBeat.i(49872);
    LogUtils.i(TAG, "[isHighEndDevice] + BEGIN");
    DeviceInstance.SOC_CLASS localSOC_CLASS = DeviceInstance.getInstance().getDeviceSocClass(DeviceAttrs.getInstance().str_deviceSocInfo);
    LogUtils.i(TAG, "[isHighEndDevice] socClass = ".concat(String.valueOf(localSOC_CLASS)));
    boolean bool1;
    if (localSOC_CLASS != DeviceInstance.SOC_CLASS.NULL)
    {
      if (localSOC_CLASS == DeviceInstance.SOC_CLASS.HIGH) {}
      for (bool1 = bool4;; bool1 = false)
      {
        LogUtils.i(TAG, "[isHighEndDevice] + END, isHighEndDevice = ".concat(String.valueOf(bool1)));
        AppMethodBeat.o(49872);
        return bool1;
      }
    }
    int i = getScreenWidth(paramContext);
    int j = getScreenHeight(paramContext);
    label120:
    boolean bool2;
    if (i * j >= 1900800L)
    {
      bool1 = true;
      LogUtils.d(TAG, "[isHighEndDevice] isHighDisplay = " + bool1 + ", widthPixels = " + i + ", heightPixels = " + j);
      long l = getHeapMaxSizeInMb(paramContext);
      if (l < 256L) {
        break label293;
      }
      bool2 = true;
      label181:
      LogUtils.d(TAG, "[isHighEndDevice] isHighMemory = " + bool2 + ", deviceHeapSize(Mb) = " + l);
      i = getNumCores();
      if (i < 4L) {
        break label299;
      }
    }
    label293:
    label299:
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
      break label120;
      bool2 = false;
      break label181;
    }
  }
  
  public static boolean isLowEndDevice(Context paramContext)
  {
    boolean bool5 = true;
    AppMethodBeat.i(49871);
    LogUtils.i(TAG, "[isLowEndDevice] + BEGIN");
    DeviceInstance.SOC_CLASS localSOC_CLASS = DeviceInstance.getInstance().getDeviceSocClass(DeviceAttrs.getInstance().str_deviceSocInfo);
    LogUtils.i(TAG, "[isLowEndDevice] socClass = ".concat(String.valueOf(localSOC_CLASS)));
    boolean bool1;
    if (localSOC_CLASS != DeviceInstance.SOC_CLASS.NULL)
    {
      if (localSOC_CLASS == DeviceInstance.SOC_CLASS.LOW) {}
      for (bool1 = bool5;; bool1 = false)
      {
        LogUtils.i(TAG, "[isLowEndDevice] + END, isLowEndDevice = ".concat(String.valueOf(bool1)));
        AppMethodBeat.o(49871);
        return bool1;
      }
    }
    int i = getScreenWidth(paramContext);
    int j = getScreenHeight(paramContext);
    boolean bool2;
    label121:
    boolean bool3;
    if (i * j <= 307200L)
    {
      bool2 = true;
      LogUtils.d(TAG, "[isLowEndDevice] isLowEndDisplay = " + bool2 + ", widthPixels = " + i + ", heightPixels = " + j);
      long l = getHeapMaxSizeInMb(paramContext);
      if (l > 64L) {
        break label301;
      }
      bool3 = true;
      label183:
      LogUtils.d(TAG, "[isLowEndDevice] isLowMemory = " + bool3 + ", deviceHeapSize(Mb) = " + l);
      i = getNumCores();
      if (i > 1L) {
        break label307;
      }
    }
    label301:
    label307:
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
      break label121;
      bool3 = false;
      break label183;
    }
  }
  
  public static boolean isMiddleEndDevice(Context paramContext)
  {
    boolean bool = true;
    AppMethodBeat.i(49873);
    LogUtils.i(TAG, "[isMiddleEndDevice] + BEGIN");
    DeviceInstance.SOC_CLASS localSOC_CLASS = DeviceInstance.getInstance().getDeviceSocClass(DeviceAttrs.getInstance().str_deviceSocInfo);
    LogUtils.i(TAG, "[isMiddleEndDevice] socClass = ".concat(String.valueOf(localSOC_CLASS)));
    if (localSOC_CLASS != DeviceInstance.SOC_CLASS.NULL) {
      if (localSOC_CLASS != DeviceInstance.SOC_CLASS.NORMAL) {}
    }
    for (;;)
    {
      LogUtils.i(TAG, "[isMiddleEndDevice] + END, isMiddleEndDevice = ".concat(String.valueOf(bool)));
      AppMethodBeat.o(49873);
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
    AppMethodBeat.i(49913);
    if (paramContext == null)
    {
      AppMethodBeat.o(49913);
      return false;
    }
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null)
    {
      AppMethodBeat.o(49913);
      return false;
    }
    paramContext = paramContext.getNetworkInfo(0);
    if ((paramContext != null) && (paramContext.isAvailable()) && (paramContext.isConnected()))
    {
      AppMethodBeat.o(49913);
      return true;
    }
    AppMethodBeat.o(49913);
    return false;
  }
  
  public static boolean isNavigationBarShow(Activity paramActivity)
  {
    AppMethodBeat.i(49908);
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramActivity = paramActivity.getWindowManager().getDefaultDisplay();
      Point localPoint1 = new Point();
      Point localPoint2 = new Point();
      paramActivity.getSize(localPoint1);
      paramActivity.getRealSize(localPoint2);
      if (localPoint2.y != localPoint1.y)
      {
        AppMethodBeat.o(49908);
        return true;
      }
      AppMethodBeat.o(49908);
      return false;
    }
    boolean bool1 = ViewConfiguration.get(paramActivity).hasPermanentMenuKey();
    boolean bool2 = KeyCharacterMap.deviceHasKey(4);
    if ((bool1) || (bool2))
    {
      AppMethodBeat.o(49908);
      return false;
    }
    AppMethodBeat.o(49908);
    return true;
  }
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    AppMethodBeat.i(49903);
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null)
    {
      AppMethodBeat.o(49903);
      return false;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if ((paramContext != null) && (paramContext.isConnectedOrConnecting()))
    {
      AppMethodBeat.o(49903);
      return true;
    }
    AppMethodBeat.o(49903);
    return false;
  }
  
  public static boolean isSmoothHidden(Context paramContext)
  {
    AppMethodBeat.i(49870);
    if ((isLowEndDevice(paramContext)) || (isVeryLowEndDevice()))
    {
      AppMethodBeat.o(49870);
      return true;
    }
    AppMethodBeat.o(49870);
    return false;
  }
  
  public static boolean isValid(Context paramContext)
  {
    AppMethodBeat.i(49904);
    if (getOpenGlEsVersion(paramContext) >= 131072) {}
    for (boolean bool = true;; bool = false)
    {
      mIsOpenGlEsValid = bool;
      mIsAllUnusable = false;
      if (mIsOpenGlEsValid) {
        break;
      }
      AppMethodBeat.o(49904);
      return false;
    }
    AppMethodBeat.o(49904);
    return true;
  }
  
  public static boolean isVeryLowEndDevice()
  {
    boolean bool2 = false;
    AppMethodBeat.i(49869);
    LogUtils.i(TAG, "[isVeryLowEndDevice] + BEGIN");
    DeviceInstance.SOC_CLASS localSOC_CLASS = DeviceInstance.getInstance().getDeviceSocClass(DeviceAttrs.getInstance().str_deviceSocInfo);
    LogUtils.i(TAG, "[isVeryLowEndDevice] socClass = ".concat(String.valueOf(localSOC_CLASS)));
    boolean bool1 = bool2;
    if (localSOC_CLASS != DeviceInstance.SOC_CLASS.NULL)
    {
      bool1 = bool2;
      if (localSOC_CLASS == DeviceInstance.SOC_CLASS.V_LOW) {
        bool1 = true;
      }
    }
    LogUtils.i(TAG, "[isVeryLowEndDevice] + END, isVeryLowDevice = ".concat(String.valueOf(bool1)));
    AppMethodBeat.o(49869);
    return bool1;
  }
  
  public static boolean isWifiNetwork(Context paramContext)
  {
    AppMethodBeat.i(49914);
    if (paramContext == null)
    {
      AppMethodBeat.o(49914);
      return false;
    }
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null)
    {
      AppMethodBeat.o(49914);
      return false;
    }
    paramContext = paramContext.getNetworkInfo(1);
    if ((paramContext != null) && (paramContext.isAvailable()) && (paramContext.isConnected()))
    {
      AppMethodBeat.o(49914);
      return true;
    }
    AppMethodBeat.o(49914);
    return false;
  }
  
  private static String parse(String paramString)
  {
    AppMethodBeat.i(49920);
    paramString = Pattern.compile("(\\d{1,3})[.](\\d{1,3})[.](\\d{1,3})[.](\\d{1,3})", 2).matcher(paramString);
    if (paramString.find())
    {
      paramString = paramString.group(0);
      AppMethodBeat.o(49920);
      return paramString;
    }
    AppMethodBeat.o(49920);
    return null;
  }
  
  public static void setSystemScreenBrightness(ContentResolver paramContentResolver, int paramInt)
  {
    AppMethodBeat.i(49927);
    try
    {
      Settings.System.putInt(paramContentResolver, "screen_brightness", paramInt);
      AppMethodBeat.o(49927);
      return;
    }
    catch (Exception paramContentResolver)
    {
      LogUtils.e(paramContentResolver);
      AppMethodBeat.o(49927);
    }
  }
  
  public static void setSystemScreenMode(ContentResolver paramContentResolver, int paramInt)
  {
    AppMethodBeat.i(49926);
    try
    {
      Settings.System.putInt(paramContentResolver, "screen_brightness_mode", paramInt);
      paramContentResolver.notifyChange(Settings.System.getUriFor("screen_brightness_mode"), null);
      AppMethodBeat.o(49926);
      return;
    }
    catch (Exception paramContentResolver)
    {
      LogUtils.e(paramContentResolver);
      AppMethodBeat.o(49926);
    }
  }
  
  public static void setWindowScreenBrightness(Window paramWindow, float paramFloat)
  {
    AppMethodBeat.i(49923);
    WindowManager.LayoutParams localLayoutParams = paramWindow.getAttributes();
    localLayoutParams.screenBrightness = paramFloat;
    paramWindow.setAttributes(localLayoutParams);
    AppMethodBeat.o(49923);
  }
  
  public static boolean veryLargeScreen(Context paramContext)
  {
    AppMethodBeat.i(49910);
    if (getScreenHeight(paramContext) * getScreenWidth(paramContext) >= 2073600)
    {
      AppMethodBeat.o(49910);
      return true;
    }
    AppMethodBeat.o(49910);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.device.DeviceUtils
 * JD-Core Version:    0.7.0.1
 */