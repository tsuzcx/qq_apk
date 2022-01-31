package com.tencent.qqvideo.proxy.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.TrafficStats;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

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
    AppMethodBeat.i(124434);
    if (paramContext == null)
    {
      AppMethodBeat.o(124434);
      return 0;
    }
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null)
    {
      AppMethodBeat.o(124434);
      return 0;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if (paramContext == null)
    {
      AppMethodBeat.o(124434);
      return 0;
    }
    if ("wifi".equalsIgnoreCase(paramContext.getTypeName()))
    {
      AppMethodBeat.o(124434);
      return 1;
    }
    AppMethodBeat.o(124434);
    return 2;
  }
  
  /* Error */
  public static String PrintStack(Throwable paramThrowable)
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
    //   0	68	0	paramThrowable	Throwable
    //   23	31	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   24	36	52	finally
    //   36	40	64	java/io/IOException
    //   53	64	64	java/io/IOException
  }
  
  public static long getAppInstallTime(Context paramContext)
  {
    AppMethodBeat.i(124442);
    if (paramContext == null)
    {
      AppMethodBeat.o(124442);
      return 0L;
    }
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      long l = new File(localPackageManager.getApplicationInfo(paramContext.getPackageName(), 0).sourceDir).lastModified() / 1000L;
      AppMethodBeat.o(124442);
      return l;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      AppMethodBeat.o(124442);
      return 0L;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(124442);
    }
    return 0L;
  }
  
  public static String getAppName(Context paramContext, String paramString)
  {
    AppMethodBeat.i(124435);
    if (paramContext == null)
    {
      AppMethodBeat.o(124435);
      return "";
    }
    try
    {
      paramContext = paramContext.getPackageManager();
      paramContext = paramContext.getApplicationLabel(paramContext.getApplicationInfo(paramString, 0)).toString();
      AppMethodBeat.o(124435);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(124435);
    }
    return "";
  }
  
  public static int getAppVersionCode(Context paramContext, String paramString)
  {
    AppMethodBeat.i(124437);
    int i;
    if (appVersionCode != 0)
    {
      i = appVersionCode;
      AppMethodBeat.o(124437);
      return i;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(124437);
      return 0;
    }
    try
    {
      i = paramContext.getPackageManager().getPackageInfo(paramString, 0).versionCode;
      appVersionCode = i;
      AppMethodBeat.o(124437);
      return i;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(124437);
    }
    return 0;
  }
  
  public static String getAppVersionName(Context paramContext)
  {
    AppMethodBeat.i(124436);
    if (!TextUtils.isEmpty(appVersionName))
    {
      paramContext = appVersionName;
      AppMethodBeat.o(124436);
      return paramContext;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(124436);
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
      AppMethodBeat.o(124436);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(124436);
    }
    return "";
  }
  
  public static String getDeviceID(Context paramContext)
  {
    AppMethodBeat.i(124431);
    if (!TextUtils.isEmpty(deviceID))
    {
      paramContext = deviceID;
      AppMethodBeat.o(124431);
      return paramContext;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(124431);
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
    catch (Throwable paramContext)
    {
      for (;;)
      {
        deviceID = "";
      }
    }
    paramContext = deviceID;
    AppMethodBeat.o(124431);
    return paramContext;
  }
  
  public static String getDeviceIMEI(Context paramContext)
  {
    AppMethodBeat.i(124429);
    if (!TextUtils.isEmpty(deviceIMEI))
    {
      paramContext = deviceIMEI;
      AppMethodBeat.o(124429);
      return paramContext;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(124429);
      return "";
    }
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext != null)
      {
        paramContext = paramContext.getDeviceId();
        deviceIMEI = paramContext;
        if (paramContext == null) {
          deviceIMEI = "";
        }
        paramContext = deviceIMEI;
        AppMethodBeat.o(124429);
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(124429);
    }
    return "";
  }
  
  public static String getDeviceIMSI(Context paramContext)
  {
    AppMethodBeat.i(124430);
    if (!TextUtils.isEmpty(deviceIMSI))
    {
      paramContext = deviceIMSI;
      AppMethodBeat.o(124430);
      return paramContext;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(124430);
      return "";
    }
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext != null)
      {
        paramContext = paramContext.getSubscriberId();
        deviceIMSI = paramContext;
        if (paramContext == null) {
          deviceIMSI = "";
        }
        paramContext = deviceIMSI;
        AppMethodBeat.o(124430);
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(124430);
    }
    return "";
  }
  
  public static String getDeviceMacAddr(Context paramContext)
  {
    AppMethodBeat.i(124432);
    if (!TextUtils.isEmpty(deviceMacAddr))
    {
      paramContext = deviceMacAddr;
      AppMethodBeat.o(124432);
      return paramContext;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(124432);
      return "";
    }
    try
    {
      paramContext = (WifiManager)paramContext.getSystemService("wifi");
      if (paramContext != null)
      {
        paramContext = paramContext.getConnectionInfo();
        if (paramContext != null)
        {
          paramContext = paramContext.getMacAddress();
          deviceMacAddr = paramContext;
          if (paramContext == null) {
            deviceMacAddr = "";
          }
          paramContext = deviceMacAddr;
          AppMethodBeat.o(124432);
          return paramContext;
        }
      }
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(124432);
    }
    return "";
  }
  
  public static int getMCC(Context paramContext)
  {
    AppMethodBeat.i(124447);
    int i;
    if (mMCC != 0)
    {
      i = mMCC;
      AppMethodBeat.o(124447);
      return i;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(124447);
      return 0;
    }
    try
    {
      paramContext = paramContext.getResources().getConfiguration();
      if (paramContext != null) {
        mMCC = paramContext.mcc;
      }
      i = mMCC;
      AppMethodBeat.o(124447);
      return i;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(124447);
    }
    return 0;
  }
  
  public static int getMNC(Context paramContext)
  {
    AppMethodBeat.i(124448);
    int i;
    if (mMNC != 0)
    {
      i = mMNC;
      AppMethodBeat.o(124448);
      return i;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(124448);
      return 0;
    }
    try
    {
      paramContext = paramContext.getResources().getConfiguration();
      if (paramContext != null) {
        mMNC = paramContext.mnc;
      }
      i = mMNC;
      AppMethodBeat.o(124448);
      return i;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(124448);
    }
    return 0;
  }
  
  /* Error */
  public static int getMarketId(Context paramContext)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_2
    //   2: ldc_w 347
    //   5: invokestatic 150	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: ifnonnull +11 -> 20
    //   12: ldc_w 347
    //   15: invokestatic 153	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   18: iconst_m1
    //   19: ireturn
    //   20: aload_0
    //   21: invokevirtual 351	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   24: invokevirtual 355	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   27: ldc_w 357
    //   30: invokevirtual 363	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   33: astore_0
    //   34: new 365	java/io/BufferedReader
    //   37: dup
    //   38: new 367	java/io/InputStreamReader
    //   41: dup
    //   42: aload_0
    //   43: invokespecial 370	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   46: invokespecial 373	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   49: astore 4
    //   51: aload 4
    //   53: invokevirtual 376	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   56: astore_3
    //   57: iload_2
    //   58: istore_1
    //   59: aload_3
    //   60: invokestatic 273	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   63: ifne +46 -> 109
    //   66: iload_2
    //   67: istore_1
    //   68: aload_3
    //   69: ldc_w 378
    //   72: invokevirtual 381	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   75: ifeq +34 -> 109
    //   78: aload_3
    //   79: aload_3
    //   80: ldc_w 383
    //   83: invokevirtual 387	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   86: iconst_1
    //   87: iadd
    //   88: invokevirtual 391	java/lang/String:substring	(I)Ljava/lang/String;
    //   91: astore_3
    //   92: iload_2
    //   93: istore_1
    //   94: aload_3
    //   95: invokestatic 273	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   98: ifne +11 -> 109
    //   101: aload_3
    //   102: invokevirtual 394	java/lang/String:trim	()Ljava/lang/String;
    //   105: invokestatic 399	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   108: istore_1
    //   109: aload_0
    //   110: ifnull +7 -> 117
    //   113: aload_0
    //   114: invokevirtual 402	java/io/InputStream:close	()V
    //   117: aload 4
    //   119: invokevirtual 403	java/io/BufferedReader:close	()V
    //   122: ldc_w 347
    //   125: invokestatic 153	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: iload_1
    //   129: ireturn
    //   130: astore_0
    //   131: aconst_null
    //   132: astore_3
    //   133: aconst_null
    //   134: astore_0
    //   135: aload_0
    //   136: ifnull +7 -> 143
    //   139: aload_0
    //   140: invokevirtual 402	java/io/InputStream:close	()V
    //   143: iload_2
    //   144: istore_1
    //   145: aload_3
    //   146: ifnull -24 -> 122
    //   149: aload_3
    //   150: invokevirtual 403	java/io/BufferedReader:close	()V
    //   153: iload_2
    //   154: istore_1
    //   155: goto -33 -> 122
    //   158: astore_0
    //   159: iload_2
    //   160: istore_1
    //   161: goto -39 -> 122
    //   164: astore_3
    //   165: aconst_null
    //   166: astore 4
    //   168: aconst_null
    //   169: astore_0
    //   170: aload_0
    //   171: ifnull +7 -> 178
    //   174: aload_0
    //   175: invokevirtual 402	java/io/InputStream:close	()V
    //   178: aload 4
    //   180: ifnull +8 -> 188
    //   183: aload 4
    //   185: invokevirtual 403	java/io/BufferedReader:close	()V
    //   188: ldc_w 347
    //   191: invokestatic 153	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   194: aload_3
    //   195: athrow
    //   196: astore_0
    //   197: goto -75 -> 122
    //   200: astore_0
    //   201: goto -13 -> 188
    //   204: astore_3
    //   205: aconst_null
    //   206: astore 4
    //   208: goto -38 -> 170
    //   211: astore_3
    //   212: goto -42 -> 170
    //   215: astore_3
    //   216: aconst_null
    //   217: astore_3
    //   218: goto -83 -> 135
    //   221: astore_3
    //   222: aload 4
    //   224: astore_3
    //   225: goto -90 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	228	0	paramContext	Context
    //   58	103	1	i	int
    //   1	159	2	j	int
    //   56	94	3	str	String
    //   164	31	3	localObject1	Object
    //   204	1	3	localObject2	Object
    //   211	1	3	localObject3	Object
    //   215	1	3	localThrowable1	Throwable
    //   217	1	3	localObject4	Object
    //   221	1	3	localThrowable2	Throwable
    //   224	1	3	localBufferedReader1	java.io.BufferedReader
    //   49	174	4	localBufferedReader2	java.io.BufferedReader
    // Exception table:
    //   from	to	target	type
    //   20	34	130	java/lang/Throwable
    //   139	143	158	java/lang/Throwable
    //   149	153	158	java/lang/Throwable
    //   20	34	164	finally
    //   113	117	196	java/lang/Throwable
    //   117	122	196	java/lang/Throwable
    //   174	178	200	java/lang/Throwable
    //   183	188	200	java/lang/Throwable
    //   34	51	204	finally
    //   51	57	211	finally
    //   59	66	211	finally
    //   68	92	211	finally
    //   94	109	211	finally
    //   34	51	215	java/lang/Throwable
    //   51	57	221	java/lang/Throwable
    //   59	66	221	java/lang/Throwable
    //   68	92	221	java/lang/Throwable
    //   94	109	221	java/lang/Throwable
  }
  
  public static int getNetWorkType(Context paramContext)
  {
    AppMethodBeat.i(124439);
    if (paramContext == null)
    {
      AppMethodBeat.o(124439);
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
      AppMethodBeat.o(124439);
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
    AppMethodBeat.i(124454);
    if (paramContext == null)
    {
      AppMethodBeat.o(124454);
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
      AppMethodBeat.o(124454);
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
    AppMethodBeat.i(124433);
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
      AppMethodBeat.o(124433);
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
  
  public static long getRxBytesFromNetwork(Context paramContext)
  {
    long l = -1L;
    AppMethodBeat.i(124441);
    if (paramContext == null)
    {
      AppMethodBeat.o(124441);
      return -1L;
    }
    try
    {
      paramContext.getClassLoader().loadClass("android.net.TrafficStats");
      if (-1L == -1L) {
        l = TrafficStats.getTotalRxBytes();
      }
      AppMethodBeat.o(124441);
      return l;
    }
    catch (ClassNotFoundException paramContext)
    {
      AppMethodBeat.o(124441);
      return 0L;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(124441);
    }
    return 0L;
  }
  
  public static int getScreenHeight(Context paramContext)
  {
    AppMethodBeat.i(124444);
    if (paramContext == null)
    {
      AppMethodBeat.o(124444);
      return 0;
    }
    int i;
    if (mScreenHeight != 0)
    {
      i = mScreenHeight;
      AppMethodBeat.o(124444);
      return i;
    }
    try
    {
      mScreenHeight = paramContext.getResources().getDisplayMetrics().heightPixels;
      label49:
      i = mScreenHeight;
      AppMethodBeat.o(124444);
      return i;
    }
    catch (Throwable paramContext)
    {
      break label49;
    }
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    AppMethodBeat.i(124443);
    if (paramContext == null)
    {
      AppMethodBeat.o(124443);
      return 0;
    }
    int i;
    if (mScreenWidth != 0)
    {
      i = mScreenWidth;
      AppMethodBeat.o(124443);
      return i;
    }
    try
    {
      mScreenWidth = paramContext.getResources().getDisplayMetrics().widthPixels;
      label49:
      i = mScreenWidth;
      AppMethodBeat.o(124443);
      return i;
    }
    catch (Throwable paramContext)
    {
      break label49;
    }
  }
  
  public static int getSystemCpuUsage(String paramString1, String paramString2)
  {
    AppMethodBeat.i(124451);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(124451);
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
    catch (Throwable paramString1)
    {
      for (;;)
      {
        int i;
        float f1 = -1.0F;
      }
    }
    i = (int)f1;
    AppMethodBeat.o(124451);
    return i;
  }
  
  public static long getSystemIdleTime(String[] paramArrayOfString)
  {
    AppMethodBeat.i(124453);
    try
    {
      long l = Long.parseLong(paramArrayOfString[4]);
      AppMethodBeat.o(124453);
      return l;
    }
    catch (Throwable paramArrayOfString)
    {
      AppMethodBeat.o(124453);
    }
    return -1L;
  }
  
  public static long getSystemUptime(String[] paramArrayOfString)
  {
    AppMethodBeat.i(124452);
    long l1 = 0L;
    int i = 1;
    for (;;)
    {
      if (i >= paramArrayOfString.length)
      {
        AppMethodBeat.o(124452);
        return l1;
      }
      long l2 = l1;
      if (4 != i) {}
      try
      {
        l2 = Long.parseLong(paramArrayOfString[i]);
        l2 = l1 + l2;
        i += 1;
        l1 = l2;
      }
      catch (Throwable paramArrayOfString)
      {
        AppMethodBeat.o(124452);
      }
    }
    return -1L;
  }
  
  public static String getWiFiMacAddress(Context paramContext)
  {
    AppMethodBeat.i(124455);
    try
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();
      AppMethodBeat.o(124455);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext = "";
      }
    }
  }
  
  public static int getWifiNetStrength(Context paramContext)
  {
    AppMethodBeat.i(124440);
    if (paramContext == null)
    {
      AppMethodBeat.o(124440);
      return 0;
    }
    try
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
      if (paramContext == null)
      {
        AppMethodBeat.o(124440);
        return 0;
      }
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(124440);
      return 0;
    }
    int i = paramContext.getRssi();
    if (Build.VERSION.SDK_INT >= 14)
    {
      i = WifiManager.calculateSignalLevel(paramContext.getRssi(), 101);
      AppMethodBeat.o(124440);
      return i;
    }
    if (i <= -100)
    {
      AppMethodBeat.o(124440);
      return 0;
    }
    if (i >= -55)
    {
      AppMethodBeat.o(124440);
      return 100;
    }
    i = (int)((i + 100) * 100.0F / 45.0F);
    AppMethodBeat.o(124440);
    return i;
  }
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    AppMethodBeat.i(124438);
    if (paramContext != null)
    {
      paramContext = (ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity");
      if (paramContext == null)
      {
        AppMethodBeat.o(124438);
        return false;
      }
      paramContext = paramContext.getActiveNetworkInfo();
      if ((paramContext == null) || (!paramContext.isAvailable()))
      {
        AppMethodBeat.o(124438);
        return false;
      }
      if (paramContext.getState() == NetworkInfo.State.CONNECTED)
      {
        AppMethodBeat.o(124438);
        return true;
      }
      AppMethodBeat.o(124438);
      return false;
    }
    AppMethodBeat.o(124438);
    return false;
  }
  
  public static boolean isNetworkTypeMobile(Context paramContext)
  {
    AppMethodBeat.i(124445);
    if (paramContext == null)
    {
      AppMethodBeat.o(124445);
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
          AppMethodBeat.o(124445);
          return false;
        }
        AppMethodBeat.o(124445);
        return true;
      }
    }
    AppMethodBeat.o(124445);
    return true;
  }
  
  /* Error */
  public static String readSystemStat()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc_w 551
    //   5: invokestatic 150	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 553	java/io/RandomAccessFile
    //   11: dup
    //   12: ldc_w 555
    //   15: ldc_w 557
    //   18: invokespecial 560	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: astore_0
    //   22: aload_0
    //   23: invokevirtual 561	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
    //   26: astore_1
    //   27: aload_0
    //   28: invokevirtual 562	java/io/RandomAccessFile:close	()V
    //   31: ldc_w 551
    //   34: invokestatic 153	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: aload_1
    //   38: areturn
    //   39: astore_0
    //   40: aconst_null
    //   41: astore_0
    //   42: aload_2
    //   43: astore_1
    //   44: aload_0
    //   45: ifnull -14 -> 31
    //   48: aload_0
    //   49: invokevirtual 562	java/io/RandomAccessFile:close	()V
    //   52: aload_2
    //   53: astore_1
    //   54: goto -23 -> 31
    //   57: astore_0
    //   58: aload_2
    //   59: astore_1
    //   60: goto -29 -> 31
    //   63: astore_0
    //   64: aconst_null
    //   65: astore_1
    //   66: aload_1
    //   67: ifnull +7 -> 74
    //   70: aload_1
    //   71: invokevirtual 562	java/io/RandomAccessFile:close	()V
    //   74: ldc_w 551
    //   77: invokestatic 153	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: aload_0
    //   81: athrow
    //   82: astore_1
    //   83: goto -9 -> 74
    //   86: astore_0
    //   87: goto -56 -> 31
    //   90: astore_1
    //   91: aload_0
    //   92: astore_2
    //   93: aload_1
    //   94: astore_0
    //   95: aload_2
    //   96: astore_1
    //   97: goto -31 -> 66
    //   100: astore_1
    //   101: goto -59 -> 42
    // Local variable table:
    //   start	length	slot	name	signature
    //   21	7	0	localRandomAccessFile	java.io.RandomAccessFile
    //   39	1	0	localThrowable1	Throwable
    //   41	8	0	localObject1	Object
    //   57	1	0	localThrowable2	Throwable
    //   63	18	0	localObject2	Object
    //   86	6	0	localThrowable3	Throwable
    //   94	1	0	localObject3	Object
    //   26	45	1	localObject4	Object
    //   82	1	1	localThrowable4	Throwable
    //   90	4	1	localObject5	Object
    //   96	1	1	localObject6	Object
    //   100	1	1	localThrowable5	Throwable
    //   1	95	2	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   8	22	39	java/lang/Throwable
    //   48	52	57	java/lang/Throwable
    //   8	22	63	finally
    //   70	74	82	java/lang/Throwable
    //   27	31	86	java/lang/Throwable
    //   22	27	90	finally
    //   22	27	100	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qqvideo.proxy.common.VcSystemInfo
 * JD-Core Version:    0.7.0.1
 */