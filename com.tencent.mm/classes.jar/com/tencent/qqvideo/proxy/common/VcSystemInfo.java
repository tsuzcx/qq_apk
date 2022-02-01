package com.tencent.qqvideo.proxy.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;

public class VcSystemInfo
{
  public static final int CHIP_ARM_LATER = 50;
  public static final int CHIP_ARM_V5 = 3;
  public static final int CHIP_ARM_V6 = 4;
  public static final int CHIP_ARM_V7_NENO = 6;
  public static final int CHIP_ARM_V7_NO_NENO = 5;
  public static final int CHIP_MIPS = 2;
  public static final int CHIP_UNKNOW = 0;
  public static final int CHIP_X86 = 1;
  public static final int NETWORK_AP_3G = 2;
  public static final int NETWORK_AP_GPRS = 3;
  public static final int NETWORK_AP_LINE = 4;
  public static final int NETWORK_AP_WIFI = 1;
  public static final int NETWORK_CLASS_2_G = 2;
  public static final int NETWORK_CLASS_3_G = 3;
  public static final int NETWORK_CLASS_4_G = 4;
  public static final int NETWORK_CLASS_UNKNOWN = 0;
  public static final int NETWORK_NONE = 0;
  private static final int NETWORK_TYPE_1xRTT = 7;
  private static final int NETWORK_TYPE_CDMA = 4;
  private static final int NETWORK_TYPE_EDGE = 2;
  private static final int NETWORK_TYPE_EHRPD = 14;
  private static final int NETWORK_TYPE_EVDO_0 = 5;
  private static final int NETWORK_TYPE_EVDO_A = 6;
  private static final int NETWORK_TYPE_EVDO_B = 12;
  private static final int NETWORK_TYPE_GPRS = 1;
  private static final int NETWORK_TYPE_HSDPA = 8;
  private static final int NETWORK_TYPE_HSPA = 10;
  private static final int NETWORK_TYPE_HSPAP = 15;
  private static final int NETWORK_TYPE_HSUPA = 9;
  private static final int NETWORK_TYPE_IDEN = 11;
  private static final int NETWORK_TYPE_LTE = 13;
  private static final int NETWORK_TYPE_UMTS = 3;
  public static final int PLAYER_LEVEL_1 = 1;
  public static final int PLAYER_LEVEL_11 = 11;
  public static final int PLAYER_LEVEL_16 = 16;
  public static final int PLAYER_LEVEL_21 = 21;
  public static final int PLAYER_LEVEL_26 = 26;
  public static final int PLAYER_LEVEL_6 = 6;
  private static final String TAG = "VcSystemInfo";
  public static final int TYPE_CMNET = 2;
  public static final int TYPE_CMWAP = 3;
  public static final int TYPE_NONE = 0;
  public static final int TYPE_OTHER = 4;
  public static final int TYPE_WIFI = 1;
  private static int appVersionCode = 0;
  private static String appVersionName;
  private static String deviceID;
  private static String deviceIMEI;
  private static String deviceIMSI;
  private static String deviceMacAddr;
  public static int mCpuArchitecture;
  public static String mCpuHardware;
  private static int mDeviceLevel;
  public static String mFeature;
  private static int mMCC;
  private static int mMNC;
  public static String mProcessorName = "N/A";
  public static int mScreenHeight;
  public static int mScreenWidth;
  public int mCoreNumber = 1;
  public long mCurrCpuFreq = 0L;
  private long mLastCpu;
  private long mLastIdle;
  public long mMaxCpuFreq = 0L;
  public int mdispHeight;
  public int mdispWidth;
  
  static
  {
    mFeature = "";
    mCpuHardware = "";
    mCpuArchitecture = 0;
    mMCC = 0;
    mMNC = 0;
    mDeviceLevel = 0;
    deviceID = "";
  }
  
  public VcSystemInfo()
  {
    mScreenWidth = 320;
    mScreenHeight = 480;
    this.mdispWidth = 320;
    this.mdispHeight = 240;
    this.mLastCpu = 0L;
    this.mLastIdle = 0L;
  }
  
  public static int GetNetAP(Context paramContext)
  {
    AppMethodBeat.i(89708);
    if (paramContext == null)
    {
      AppMethodBeat.o(89708);
      return 0;
    }
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null)
    {
      AppMethodBeat.o(89708);
      return 0;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if (paramContext == null)
    {
      AppMethodBeat.o(89708);
      return 0;
    }
    if ("wifi".equalsIgnoreCase(paramContext.getTypeName()))
    {
      AppMethodBeat.o(89708);
      return 1;
    }
    AppMethodBeat.o(89708);
    return 2;
  }
  
  /* Error */
  public static String PrintStack(java.lang.Throwable paramThrowable)
  {
    // Byte code:
    //   0: ldc 186
    //   2: invokestatic 150	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnonnull +10 -> 16
    //   9: ldc 186
    //   11: invokestatic 153	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   14: aconst_null
    //   15: areturn
    //   16: new 188	java/io/ByteArrayOutputStream
    //   19: dup
    //   20: invokespecial 189	java/io/ByteArrayOutputStream:<init>	()V
    //   23: astore_1
    //   24: aload_0
    //   25: new 191	java/io/PrintStream
    //   28: dup
    //   29: aload_1
    //   30: invokespecial 194	java/io/PrintStream:<init>	(Ljava/io/OutputStream;)V
    //   33: invokevirtual 200	java/lang/Throwable:printStackTrace	(Ljava/io/PrintStream;)V
    //   36: aload_1
    //   37: invokevirtual 203	java/io/ByteArrayOutputStream:close	()V
    //   40: aload_1
    //   41: invokevirtual 206	java/io/ByteArrayOutputStream:toString	()Ljava/lang/String;
    //   44: astore_0
    //   45: ldc 186
    //   47: invokestatic 153	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: aload_0
    //   51: areturn
    //   52: astore_0
    //   53: aload_1
    //   54: invokevirtual 203	java/io/ByteArrayOutputStream:close	()V
    //   57: ldc 186
    //   59: invokestatic 153	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: aload_0
    //   63: athrow
    //   64: astore_0
    //   65: goto -25 -> 40
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	paramThrowable	java.lang.Throwable
    //   23	31	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   24	36	52	finally
    //   36	40	64	java/io/IOException
    //   53	64	64	java/io/IOException
  }
  
  /* Error */
  public static long getAppInstallTime(Context paramContext)
  {
    // Byte code:
    //   0: ldc 211
    //   2: invokestatic 150	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnonnull +10 -> 16
    //   9: ldc 211
    //   11: invokestatic 153	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   14: lconst_0
    //   15: lreturn
    //   16: aload_0
    //   17: invokevirtual 215	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   20: astore_3
    //   21: new 217	java/io/File
    //   24: dup
    //   25: aload_3
    //   26: aload_0
    //   27: invokevirtual 220	android/content/Context:getPackageName	()Ljava/lang/String;
    //   30: iconst_0
    //   31: invokevirtual 226	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   34: getfield 231	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   37: invokespecial 234	java/io/File:<init>	(Ljava/lang/String;)V
    //   40: invokevirtual 238	java/io/File:lastModified	()J
    //   43: ldc2_w 239
    //   46: ldiv
    //   47: lstore_1
    //   48: ldc 211
    //   50: invokestatic 153	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: lload_1
    //   54: lreturn
    //   55: astore_0
    //   56: ldc 211
    //   58: invokestatic 153	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: lconst_0
    //   62: lreturn
    //   63: astore_0
    //   64: ldc 211
    //   66: invokestatic 153	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: lconst_0
    //   70: lreturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	paramContext	Context
    //   47	7	1	l	long
    //   20	6	3	localPackageManager	PackageManager
    // Exception table:
    //   from	to	target	type
    //   21	48	55	android/content/pm/PackageManager$NameNotFoundException
    //   21	48	63	finally
  }
  
  public static String getAppName(Context paramContext, String paramString)
  {
    AppMethodBeat.i(89709);
    if (paramContext == null)
    {
      AppMethodBeat.o(89709);
      return "";
    }
    try
    {
      paramContext = paramContext.getPackageManager();
      paramContext = paramContext.getApplicationLabel(paramContext.getApplicationInfo(paramString, 0)).toString();
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(89709);
    }
    return "";
  }
  
  public static int getAppVersionCode(Context paramContext, String paramString)
  {
    AppMethodBeat.i(89711);
    int i;
    if (appVersionCode != 0)
    {
      i = appVersionCode;
      AppMethodBeat.o(89711);
      return i;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(89711);
      return 0;
    }
    try
    {
      i = paramContext.getPackageManager().getPackageInfo(paramString, 0).versionCode;
      appVersionCode = i;
      return i;
    }
    finally
    {
      AppMethodBeat.o(89711);
    }
    return 0;
  }
  
  public static String getAppVersionName(Context paramContext)
  {
    AppMethodBeat.i(89710);
    if (!TextUtils.isEmpty(appVersionName))
    {
      paramContext = appVersionName;
      AppMethodBeat.o(89710);
      return paramContext;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(89710);
      return "";
    }
    try
    {
      String str = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      appVersionName = str;
      paramContext = str;
      if (str == null) {
        paramContext = "";
      }
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(89710);
    }
    return "";
  }
  
  public static String getDeviceID(Context paramContext)
  {
    AppMethodBeat.i(89705);
    if (!TextUtils.isEmpty(deviceID))
    {
      paramContext = deviceID;
      AppMethodBeat.o(89705);
      return paramContext;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(89705);
      return "";
    }
    try
    {
      paramContext = Settings.System.getString(paramContext.getContentResolver(), "android_id");
      deviceID = paramContext;
      if (paramContext == null) {
        deviceID = "";
      }
    }
    finally
    {
      for (;;)
      {
        deviceID = "";
      }
    }
    paramContext = deviceID;
    AppMethodBeat.o(89705);
    return paramContext;
  }
  
  public static String getDeviceIMEI(Context paramContext)
  {
    AppMethodBeat.i(89703);
    if (!TextUtils.isEmpty(deviceIMEI))
    {
      paramContext = deviceIMEI;
      AppMethodBeat.o(89703);
      return paramContext;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(89703);
      return "";
    }
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext != null)
      {
        paramContext = (String)a.a(paramContext, "com/tencent/qqvideo/proxy/common/VcSystemInfo", "getDeviceIMEI", "(Landroid/content/Context;)Ljava/lang/String;", "android/telephony/TelephonyManager", "getDeviceId", "()Ljava/lang/String;");
        deviceIMEI = paramContext;
        if (paramContext == null) {
          deviceIMEI = "";
        }
        paramContext = deviceIMEI;
        return paramContext;
      }
    }
    finally
    {
      AppMethodBeat.o(89703);
    }
    return "";
  }
  
  public static String getDeviceIMSI(Context paramContext)
  {
    AppMethodBeat.i(89704);
    if (!TextUtils.isEmpty(deviceIMSI))
    {
      paramContext = deviceIMSI;
      AppMethodBeat.o(89704);
      return paramContext;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(89704);
      return "";
    }
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext != null)
      {
        paramContext = (String)a.a(paramContext, "com/tencent/qqvideo/proxy/common/VcSystemInfo", "getDeviceIMSI", "(Landroid/content/Context;)Ljava/lang/String;", "android/telephony/TelephonyManager", "getSubscriberId", "()Ljava/lang/String;");
        deviceIMSI = paramContext;
        if (paramContext == null) {
          deviceIMSI = "";
        }
        paramContext = deviceIMSI;
        return paramContext;
      }
    }
    finally
    {
      AppMethodBeat.o(89704);
    }
    return "";
  }
  
  public static String getDeviceMacAddr(Context paramContext)
  {
    AppMethodBeat.i(89706);
    if (!TextUtils.isEmpty(deviceMacAddr))
    {
      paramContext = deviceMacAddr;
      AppMethodBeat.o(89706);
      return paramContext;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(89706);
      return "";
    }
    try
    {
      paramContext = (WifiManager)paramContext.getSystemService("wifi");
      if (paramContext != null)
      {
        paramContext = (WifiInfo)a.a(paramContext, "com/tencent/qqvideo/proxy/common/VcSystemInfo", "getDeviceMacAddr", "(Landroid/content/Context;)Ljava/lang/String;", "android/net/wifi/WifiManager", "getConnectionInfo", "()Landroid/net/wifi/WifiInfo;");
        if (paramContext != null)
        {
          paramContext = paramContext.getMacAddress();
          deviceMacAddr = paramContext;
          if (paramContext == null) {
            deviceMacAddr = "";
          }
          paramContext = deviceMacAddr;
          return paramContext;
        }
      }
    }
    finally
    {
      AppMethodBeat.o(89706);
    }
    return "";
  }
  
  public static int getMCC(Context paramContext)
  {
    AppMethodBeat.i(89721);
    int i;
    if (mMCC != 0)
    {
      i = mMCC;
      AppMethodBeat.o(89721);
      return i;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(89721);
      return 0;
    }
    try
    {
      paramContext = paramContext.getResources().getConfiguration();
      if (paramContext != null) {
        mMCC = paramContext.mcc;
      }
      i = mMCC;
      return i;
    }
    finally
    {
      AppMethodBeat.o(89721);
    }
    return 0;
  }
  
  public static int getMNC(Context paramContext)
  {
    AppMethodBeat.i(89722);
    int i;
    if (mMNC != 0)
    {
      i = mMNC;
      AppMethodBeat.o(89722);
      return i;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(89722);
      return 0;
    }
    try
    {
      paramContext = paramContext.getResources().getConfiguration();
      if (paramContext != null) {
        mMNC = paramContext.mnc;
      }
      i = mMNC;
      return i;
    }
    finally
    {
      AppMethodBeat.o(89722);
    }
    return 0;
  }
  
  /* Error */
  public static int getMarketId(Context paramContext)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_2
    //   2: ldc_w 359
    //   5: invokestatic 150	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: ifnonnull +11 -> 20
    //   12: ldc_w 359
    //   15: invokestatic 153	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   18: iconst_m1
    //   19: ireturn
    //   20: aload_0
    //   21: invokevirtual 363	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   24: invokevirtual 367	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   27: ldc_w 369
    //   30: invokevirtual 375	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   33: astore_3
    //   34: new 377	java/io/BufferedReader
    //   37: dup
    //   38: new 379	java/io/InputStreamReader
    //   41: dup
    //   42: aload_3
    //   43: invokespecial 382	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   46: invokespecial 385	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   49: astore_0
    //   50: aload_0
    //   51: invokevirtual 388	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   54: astore 4
    //   56: iload_2
    //   57: istore_1
    //   58: aload 4
    //   60: invokestatic 273	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   63: ifne +52 -> 115
    //   66: iload_2
    //   67: istore_1
    //   68: aload 4
    //   70: ldc_w 390
    //   73: invokevirtual 393	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   76: ifeq +39 -> 115
    //   79: aload 4
    //   81: aload 4
    //   83: ldc_w 395
    //   86: invokevirtual 399	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   89: iconst_1
    //   90: iadd
    //   91: invokevirtual 403	java/lang/String:substring	(I)Ljava/lang/String;
    //   94: astore 4
    //   96: iload_2
    //   97: istore_1
    //   98: aload 4
    //   100: invokestatic 273	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   103: ifne +12 -> 115
    //   106: aload 4
    //   108: invokevirtual 406	java/lang/String:trim	()Ljava/lang/String;
    //   111: invokestatic 411	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   114: istore_1
    //   115: aload_3
    //   116: ifnull +7 -> 123
    //   119: aload_3
    //   120: invokevirtual 414	java/io/InputStream:close	()V
    //   123: aload_0
    //   124: invokevirtual 415	java/io/BufferedReader:close	()V
    //   127: ldc_w 359
    //   130: invokestatic 153	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   133: iload_1
    //   134: ireturn
    //   135: astore_0
    //   136: aconst_null
    //   137: astore_0
    //   138: aconst_null
    //   139: astore_3
    //   140: aload_3
    //   141: ifnull +7 -> 148
    //   144: aload_3
    //   145: invokevirtual 414	java/io/InputStream:close	()V
    //   148: iload_2
    //   149: istore_1
    //   150: aload_0
    //   151: ifnull -24 -> 127
    //   154: aload_0
    //   155: invokevirtual 415	java/io/BufferedReader:close	()V
    //   158: iload_2
    //   159: istore_1
    //   160: goto -33 -> 127
    //   163: astore_0
    //   164: iload_2
    //   165: istore_1
    //   166: goto -39 -> 127
    //   169: astore_0
    //   170: goto -43 -> 127
    //   173: astore_0
    //   174: aconst_null
    //   175: astore_0
    //   176: goto -36 -> 140
    //   179: astore 4
    //   181: goto -41 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	paramContext	Context
    //   57	109	1	i	int
    //   1	164	2	j	int
    //   33	112	3	localInputStream	java.io.InputStream
    //   54	53	4	str	String
    //   179	1	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   20	34	135	finally
    //   144	148	163	finally
    //   154	158	163	finally
    //   119	123	169	finally
    //   123	127	169	finally
    //   34	50	173	finally
    //   50	56	179	finally
    //   58	66	179	finally
    //   68	96	179	finally
    //   98	115	179	finally
  }
  
  public static int getNetWorkType(Context paramContext)
  {
    AppMethodBeat.i(89713);
    if (paramContext == null)
    {
      AppMethodBeat.o(89713);
      return 0;
    }
    for (;;)
    {
      try
      {
        paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
        if (paramContext == null) {
          continue;
        }
        paramContext = paramContext.getActiveNetworkInfo();
        if (paramContext == null) {
          continue;
        }
        i = paramContext.getType();
        switch (i)
        {
        default: 
          i = 4;
        }
      }
      catch (Exception paramContext)
      {
        try
        {
          if (paramContext.getExtraInfo() == null) {
            continue;
          }
          boolean bool = "cmnet".equalsIgnoreCase(paramContext.getExtraInfo());
          i = j;
          if (bool) {
            continue;
          }
          i = 3;
        }
        catch (Exception paramContext)
        {
          int j;
          i = j;
        }
        paramContext = paramContext;
        int i = 0;
        continue;
        continue;
        i = 0;
        continue;
      }
      AppMethodBeat.o(89713);
      return i;
      i = 1;
    }
    j = 2;
    i = j;
  }
  
  private static int getNetworkClass(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
    case 2: 
    case 4: 
    case 7: 
    case 11: 
      return 2;
    case 3: 
    case 5: 
    case 6: 
    case 8: 
    case 9: 
    case 10: 
    case 12: 
    case 14: 
    case 15: 
      return 3;
    }
    return 4;
  }
  
  public static int getNetworkClass(Context paramContext)
  {
    AppMethodBeat.i(89728);
    if (paramContext == null)
    {
      AppMethodBeat.o(89728);
      return 0;
    }
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    int i;
    if (paramContext != null)
    {
      paramContext = paramContext.getActiveNetworkInfo();
      if ((paramContext != null) && (paramContext.isConnected())) {
        switch (paramContext.getType())
        {
        default: 
          i = 0;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(89728);
      return i;
      i = getNetworkClass(paramContext.getSubtype());
      continue;
      i = 0;
    }
  }
  
  public static int getOsVerInt()
  {
    switch (Build.VERSION.SDK_INT)
    {
    case 11: 
    case 12: 
    case 13: 
    default: 
      return 0;
    case 9: 
    case 10: 
      return 9;
    case 14: 
    case 15: 
      return 14;
    case 16: 
      return 16;
    case 17: 
      return 17;
    case 18: 
      return 18;
    }
    return 19;
  }
  
  public static int getOsVerIntFromVerStr()
  {
    AppMethodBeat.i(89707);
    String str = getOsVersion();
    j = getOsVerInt();
    i = j;
    if (str.length() >= 3) {}
    for (;;)
    {
      try
      {
        k = Integer.parseInt(str.substring(0, 1));
        m = Integer.parseInt(str.substring(2, 3));
        if (k != 2) {
          continue;
        }
        i = j;
        if (m == 3) {
          i = 9;
        }
      }
      catch (Exception localException)
      {
        int k;
        int m;
        i = j;
        continue;
      }
      AppMethodBeat.o(89707);
      return i;
      i = j;
      if (k == 4) {
        switch (m)
        {
        default: 
          i = j;
          break;
        case 0: 
          i = 14;
          break;
        case 1: 
          i = 16;
          break;
        case 2: 
          i = 17;
          break;
        case 3: 
          i = 18;
          break;
        case 4: 
          i = 19;
        }
      }
    }
  }
  
  public static String getOsVersion()
  {
    return Build.VERSION.RELEASE;
  }
  
  public static String getRomInfo()
  {
    return Build.VERSION.INCREMENTAL;
  }
  
  /* Error */
  public static long getRxBytesFromNetwork(Context paramContext)
  {
    // Byte code:
    //   0: ldc2_w 470
    //   3: lstore_1
    //   4: ldc_w 472
    //   7: invokestatic 150	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: ifnonnull +13 -> 24
    //   14: ldc_w 472
    //   17: invokestatic 153	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: ldc2_w 470
    //   23: lreturn
    //   24: aload_0
    //   25: invokevirtual 476	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   28: ldc_w 478
    //   31: invokevirtual 484	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   34: pop
    //   35: ldc2_w 470
    //   38: ldc2_w 470
    //   41: lcmp
    //   42: ifne +7 -> 49
    //   45: invokestatic 489	android/net/TrafficStats:getTotalRxBytes	()J
    //   48: lstore_1
    //   49: ldc_w 472
    //   52: invokestatic 153	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: lload_1
    //   56: lreturn
    //   57: astore_0
    //   58: ldc_w 472
    //   61: invokestatic 153	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: lconst_0
    //   65: lreturn
    //   66: astore_0
    //   67: ldc_w 472
    //   70: invokestatic 153	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: lconst_0
    //   74: lreturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	paramContext	Context
    //   3	53	1	l	long
    // Exception table:
    //   from	to	target	type
    //   24	35	57	java/lang/ClassNotFoundException
    //   24	35	66	finally
  }
  
  public static int getScreenHeight(Context paramContext)
  {
    AppMethodBeat.i(89718);
    if (paramContext == null)
    {
      AppMethodBeat.o(89718);
      return 0;
    }
    int i;
    if (mScreenHeight != 0)
    {
      i = mScreenHeight;
      AppMethodBeat.o(89718);
      return i;
    }
    try
    {
      mScreenHeight = paramContext.getResources().getDisplayMetrics().heightPixels;
      label49:
      i = mScreenHeight;
      AppMethodBeat.o(89718);
      return i;
    }
    finally
    {
      break label49;
    }
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    AppMethodBeat.i(89717);
    if (paramContext == null)
    {
      AppMethodBeat.o(89717);
      return 0;
    }
    int i;
    if (mScreenWidth != 0)
    {
      i = mScreenWidth;
      AppMethodBeat.o(89717);
      return i;
    }
    try
    {
      mScreenWidth = paramContext.getResources().getDisplayMetrics().widthPixels;
      label49:
      i = mScreenWidth;
      AppMethodBeat.o(89717);
      return i;
    }
    finally
    {
      break label49;
    }
  }
  
  public static int getSystemCpuUsage(String paramString1, String paramString2)
  {
    AppMethodBeat.i(89725);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(89725);
      return -1;
    }
    float f2 = -1.0F;
    try
    {
      paramString1 = paramString1.trim().split("\\s+");
      long l1 = getSystemIdleTime(paramString1);
      long l2 = getSystemUptime(paramString1);
      paramString1 = paramString2.trim().split("\\s+");
      long l3 = getSystemIdleTime(paramString1);
      long l4 = getSystemUptime(paramString1);
      f1 = f2;
      if (l1 >= 0L)
      {
        f1 = f2;
        if (l2 >= 0L)
        {
          f1 = f2;
          if (l3 >= 0L)
          {
            f1 = f2;
            if (l4 >= 0L)
            {
              f1 = f2;
              if (l4 + l3 > l2 + l1)
              {
                f1 = f2;
                if (l4 >= l2) {
                  f1 = (float)(l4 - l2) / (float)(l3 + l4 - (l1 + l2)) * 100.0F;
                }
              }
            }
          }
        }
      }
    }
    finally
    {
      for (;;)
      {
        int i;
        float f1 = -1.0F;
      }
    }
    i = (int)f1;
    AppMethodBeat.o(89725);
    return i;
  }
  
  public static long getSystemIdleTime(String[] paramArrayOfString)
  {
    AppMethodBeat.i(89727);
    try
    {
      long l = Long.parseLong(paramArrayOfString[4]);
      return l;
    }
    finally
    {
      AppMethodBeat.o(89727);
    }
    return -1L;
  }
  
  /* Error */
  public static long getSystemUptime(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: ldc_w 531
    //   3: invokestatic 150	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: lconst_0
    //   7: lstore_2
    //   8: iconst_1
    //   9: istore_1
    //   10: iload_1
    //   11: aload_0
    //   12: arraylength
    //   13: if_icmplt +11 -> 24
    //   16: ldc_w 531
    //   19: invokestatic 153	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   22: lload_2
    //   23: lreturn
    //   24: lload_2
    //   25: lstore 4
    //   27: iconst_4
    //   28: iload_1
    //   29: if_icmpeq +17 -> 46
    //   32: aload_0
    //   33: iload_1
    //   34: aaload
    //   35: invokestatic 530	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   38: lstore 4
    //   40: lload_2
    //   41: lload 4
    //   43: ladd
    //   44: lstore 4
    //   46: iload_1
    //   47: iconst_1
    //   48: iadd
    //   49: istore_1
    //   50: lload 4
    //   52: lstore_2
    //   53: goto -43 -> 10
    //   56: astore_0
    //   57: ldc_w 531
    //   60: invokestatic 153	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: ldc2_w 470
    //   66: lreturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	paramArrayOfString	String[]
    //   9	41	1	i	int
    //   7	46	2	l1	long
    //   25	26	4	l2	long
    // Exception table:
    //   from	to	target	type
    //   32	40	56	finally
  }
  
  public static String getWiFiMacAddress(Context paramContext)
  {
    AppMethodBeat.i(89729);
    try
    {
      paramContext = ((WifiInfo)a.a((WifiManager)paramContext.getSystemService("wifi"), "com/tencent/qqvideo/proxy/common/VcSystemInfo", "getWiFiMacAddress", "(Landroid/content/Context;)Ljava/lang/String;", "android/net/wifi/WifiManager", "getConnectionInfo", "()Landroid/net/wifi/WifiInfo;")).getMacAddress();
      AppMethodBeat.o(89729);
      return paramContext;
    }
    finally
    {
      for (;;)
      {
        paramContext = "";
      }
    }
  }
  
  public static int getWifiNetStrength(Context paramContext)
  {
    AppMethodBeat.i(89714);
    if (paramContext == null)
    {
      AppMethodBeat.o(89714);
      return 0;
    }
    try
    {
      paramContext = (WifiInfo)a.a((WifiManager)paramContext.getSystemService("wifi"), "com/tencent/qqvideo/proxy/common/VcSystemInfo", "getWifiNetStrength", "(Landroid/content/Context;)I", "android/net/wifi/WifiManager", "getConnectionInfo", "()Landroid/net/wifi/WifiInfo;");
      if (paramContext != null) {}
    }
    finally
    {
      AppMethodBeat.o(89714);
      return 0;
    }
    int i = paramContext.getRssi();
    if (Build.VERSION.SDK_INT >= 14)
    {
      i = WifiManager.calculateSignalLevel(paramContext.getRssi(), 101);
      AppMethodBeat.o(89714);
      return i;
    }
    if (i <= -100)
    {
      AppMethodBeat.o(89714);
      return 0;
    }
    if (i >= -55)
    {
      AppMethodBeat.o(89714);
      return 100;
    }
    i = (int)((i + 100) * 100.0F / 45.0F);
    AppMethodBeat.o(89714);
    return i;
  }
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    AppMethodBeat.i(89712);
    if (paramContext != null)
    {
      paramContext = (ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity");
      if (paramContext == null)
      {
        AppMethodBeat.o(89712);
        return false;
      }
      paramContext = paramContext.getActiveNetworkInfo();
      if ((paramContext == null) || (!paramContext.isAvailable()))
      {
        AppMethodBeat.o(89712);
        return false;
      }
      if (paramContext.getState() == NetworkInfo.State.CONNECTED)
      {
        AppMethodBeat.o(89712);
        return true;
      }
      AppMethodBeat.o(89712);
      return false;
    }
    AppMethodBeat.o(89712);
    return false;
  }
  
  public static boolean isNetworkTypeMobile(Context paramContext)
  {
    AppMethodBeat.i(89719);
    if (paramContext == null)
    {
      AppMethodBeat.o(89719);
      return true;
    }
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext != null)
    {
      paramContext = paramContext.getActiveNetworkInfo();
      if (paramContext != null)
      {
        switch (paramContext.getType())
        {
        case 1: 
        default: 
          AppMethodBeat.o(89719);
          return false;
        }
        AppMethodBeat.o(89719);
        return true;
      }
    }
    AppMethodBeat.o(89719);
    return true;
  }
  
  /* Error */
  public static String readSystemStat()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc_w 566
    //   5: invokestatic 150	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 568	java/io/RandomAccessFile
    //   11: dup
    //   12: ldc_w 570
    //   15: ldc_w 572
    //   18: invokespecial 575	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: astore_1
    //   22: aload_1
    //   23: invokevirtual 576	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
    //   26: astore_0
    //   27: aload_1
    //   28: invokevirtual 577	java/io/RandomAccessFile:close	()V
    //   31: ldc_w 566
    //   34: invokestatic 153	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: aload_0
    //   38: areturn
    //   39: astore_0
    //   40: aconst_null
    //   41: astore_1
    //   42: aload_2
    //   43: astore_0
    //   44: aload_1
    //   45: ifnull -14 -> 31
    //   48: aload_1
    //   49: invokevirtual 577	java/io/RandomAccessFile:close	()V
    //   52: aload_2
    //   53: astore_0
    //   54: goto -23 -> 31
    //   57: astore_0
    //   58: aload_2
    //   59: astore_0
    //   60: goto -29 -> 31
    //   63: astore_1
    //   64: goto -33 -> 31
    //   67: astore_0
    //   68: goto -26 -> 42
    // Local variable table:
    //   start	length	slot	name	signature
    //   26	12	0	str	String
    //   39	1	0	localObject1	Object
    //   43	11	0	localObject2	Object
    //   57	1	0	localObject3	Object
    //   59	1	0	localObject4	Object
    //   67	1	0	localObject5	Object
    //   21	28	1	localRandomAccessFile	java.io.RandomAccessFile
    //   63	1	1	localObject6	Object
    //   1	58	2	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   8	22	39	finally
    //   48	52	57	finally
    //   27	31	63	finally
    //   22	27	67	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqvideo.proxy.common.VcSystemInfo
 * JD-Core Version:    0.7.0.1
 */