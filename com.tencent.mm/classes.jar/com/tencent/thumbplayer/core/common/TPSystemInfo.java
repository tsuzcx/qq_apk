package com.tencent.thumbplayer.core.common;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.content.res.Resources;
import android.media.audiofx.AudioEffect;
import android.media.audiofx.AudioEffect.Descriptor;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import android.support.v4.content.b;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.regex.Pattern;

public class TPSystemInfo
{
  public static final int CHIP_ARM_AARCH64 = 7;
  public static final int CHIP_ARM_LATER = 50;
  public static final int CHIP_ARM_V5 = 3;
  public static final int CHIP_ARM_V6 = 4;
  public static final int CHIP_ARM_V7_NENO = 6;
  public static final int CHIP_ARM_V7_NO_NENO = 5;
  public static final int CHIP_MIPS = 2;
  public static final int CHIP_UNKNOW = 0;
  public static final int CHIP_X86 = 1;
  public static final int CPU_HW_HISI = 2;
  public static final int CPU_HW_MTK = 1;
  public static final int CPU_HW_OTHER = -1;
  public static final int CPU_HW_QUALCOMM = 0;
  public static final int CPU_HW_SUMSUNG = 3;
  private static int cpuArch = -1;
  private static final String[][] cpuPerfList;
  private static long currentCpuFreq;
  private static String deviceID;
  private static String deviceIMEI;
  private static String deviceIMSI = "";
  private static String deviceMacAddr;
  private static Method getWlanMethod;
  private static long mAppInstallTime;
  private static int mCpuArchitecture;
  private static int mCpuHWProductIdx;
  private static int mCpuHWProducter;
  private static String mCpuHardware;
  private static String mFeature;
  private static int mOpenGLVersion = 0;
  private static String mProcessorName = "N/A";
  public static int mScreenHeight;
  public static int mScreenWidth;
  private static long maxCpuFreq;
  private static int numOfCores;
  
  static
  {
    mFeature = "";
    mCpuHardware = "";
    mCpuArchitecture = 0;
    mCpuHWProducter = -1;
    mCpuHWProductIdx = -1;
    cpuPerfList = new String[][] { { "MSM7227", "MSM7627", "MSM7227T", "MSM7627T", "MSM7227A", "MSM7627A", "QSD8250", "QSD8650", "MSM7230", "MSM7630", "APQ8055", "MSM8255", "MSM8655", "MSM8255T", "MSM8655T", "MSM8225", "MSM8625", "MSM8260", "MSM8660", "MSM8x25Q", "MSM8x26", "MSM8x10", "MSM8x12", "MSM8x30", "MSM8260A", "MSM8660A", "MSM8960", "MSM8208", "MSM8916", "MSM8960T", "MSM8909", "MSM8916v2", "MSM8936", "MSM8909v2", "MSM8917", "APQ8064", "APQ8064T", "MSM8920", "MSM8939", "MSM8937", "MSM8939v2", "MSM8940", "MSM8952", "MSM8974", "MSM8x74AA", "MSM8x74AB", "MSM8x74AC", "MSM8953", "APQ8084", "MSM8953Pro", "MSM8992", "MSM8956", "MSM8976", "MSM8976Pro", "MSM8994", "MSM8996", "MSM8996Pro" }, { "MT6516", "MT6513", "MT6573", "MT6515M", "MT6515", "MT6575", "MT6572", "MT6577", "MT6589", "MT6582", "MT6592", "MT6595", "MT6735", "MT6750", "MT6753", "MT6752", "MT6755", "MT6755", "MT6755T", "MT6795", "MT6757", "MT675x", "MT6797", "MT6797T" }, { "K3V2", "K3V2E", "K3V2+", "Kirin910", "Kirin920", "Kirin925", "Kirin928", "Kirin620", "Kirin650", "Kirin655", "Kirin930", "Kirin935", "Kirin950", "Kirin955", "Kirin960" }, { "S5L8900", "S5PC100", "Exynos3110", "Exynos3475", "Exynos4210", "Exynos4212", "SMDK4x12", "Exynos4412", "Exynos5250", "Exynos5260", "Exynos5410", "Exynos5420", "Exynos5422", "Exynos5430", "Exynos5800", "Exynos5433", "Exynos7580", "Exynos7870", "Exynos7870", "Exynos7420", "Exynos8890" } };
    maxCpuFreq = -1L;
    currentCpuFreq = -1L;
    numOfCores = -1;
  }
  
  private static String _getDeviceMacAddr(Context paramContext)
  {
    AppMethodBeat.i(197430);
    String str = "";
    if (hasMarshmallow()) {
      paramContext = getWlanName();
    }
    for (;;)
    {
      int i;
      try
      {
        Object localObject = NetworkInterface.getByName(paramContext);
        paramContext = str;
        if (localObject != null)
        {
          byte[] arrayOfByte = ((NetworkInterface)localObject).getHardwareAddress();
          StringBuilder localStringBuilder = new StringBuilder();
          int j = arrayOfByte.length;
          i = 0;
          if (i < j)
          {
            localObject = Integer.toHexString(arrayOfByte[i] & 0xFF);
            paramContext = (Context)localObject;
            if (((String)localObject).length() == 1) {
              paramContext = "0".concat(String.valueOf(localObject));
            }
            localStringBuilder.append(paramContext);
            if (i == j - 1) {
              break label161;
            }
            localStringBuilder.append(":");
            break label161;
          }
          paramContext = localStringBuilder.toString().toUpperCase();
        }
      }
      catch (Throwable paramContext)
      {
        TPNativeLog.printLog(4, paramContext.getMessage());
        paramContext = str;
        continue;
      }
      AppMethodBeat.o(197430);
      return paramContext;
      paramContext = getLowerMarshmallowDeviceMacAddr(paramContext);
      continue;
      label161:
      i += 1;
    }
  }
  
  /* Error */
  private static String _readStringFromFile(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: ldc_w 412
    //   9: invokestatic 339	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: new 414	java/io/BufferedReader
    //   15: dup
    //   16: new 416	java/io/FileReader
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 419	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   24: invokespecial 422	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   27: astore_1
    //   28: aload 5
    //   30: astore_3
    //   31: aload_1
    //   32: astore_2
    //   33: aload_0
    //   34: invokevirtual 427	java/io/File:length	()J
    //   37: ldc2_w 428
    //   40: lcmp
    //   41: ifgt +46 -> 87
    //   44: aload_1
    //   45: astore_2
    //   46: aload_0
    //   47: invokevirtual 427	java/io/File:length	()J
    //   50: l2i
    //   51: newarray char
    //   53: astore 6
    //   55: aload 5
    //   57: astore_3
    //   58: aload_1
    //   59: astore_2
    //   60: aload_1
    //   61: aload 6
    //   63: iconst_0
    //   64: aload_0
    //   65: invokevirtual 427	java/io/File:length	()J
    //   68: l2i
    //   69: invokevirtual 433	java/io/BufferedReader:read	([CII)I
    //   72: ifle +15 -> 87
    //   75: aload_1
    //   76: astore_2
    //   77: new 78	java/lang/String
    //   80: dup
    //   81: aload 6
    //   83: invokespecial 436	java/lang/String:<init>	([C)V
    //   86: astore_3
    //   87: aload_1
    //   88: invokevirtual 439	java/io/BufferedReader:close	()V
    //   91: ldc_w 412
    //   94: invokestatic 395	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: aload_3
    //   98: areturn
    //   99: astore_0
    //   100: aconst_null
    //   101: astore_1
    //   102: aload_1
    //   103: astore_2
    //   104: ldc_w 412
    //   107: invokestatic 395	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: aload_1
    //   111: astore_2
    //   112: aload_0
    //   113: athrow
    //   114: astore_0
    //   115: aload_2
    //   116: ifnull +7 -> 123
    //   119: aload_2
    //   120: invokevirtual 439	java/io/BufferedReader:close	()V
    //   123: ldc_w 412
    //   126: invokestatic 395	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   129: aload_0
    //   130: athrow
    //   131: astore_0
    //   132: aconst_null
    //   133: astore_1
    //   134: aload 4
    //   136: astore_3
    //   137: aload_1
    //   138: ifnull -47 -> 91
    //   141: aload_1
    //   142: invokevirtual 439	java/io/BufferedReader:close	()V
    //   145: aload 4
    //   147: astore_3
    //   148: goto -57 -> 91
    //   151: astore_0
    //   152: aload 4
    //   154: astore_3
    //   155: goto -64 -> 91
    //   158: astore_0
    //   159: goto -68 -> 91
    //   162: astore_1
    //   163: goto -40 -> 123
    //   166: astore_0
    //   167: aconst_null
    //   168: astore_2
    //   169: goto -54 -> 115
    //   172: astore_0
    //   173: goto -39 -> 134
    //   176: astore_0
    //   177: goto -75 -> 102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	paramFile	File
    //   27	115	1	localBufferedReader1	java.io.BufferedReader
    //   162	1	1	localThrowable	Throwable
    //   32	137	2	localBufferedReader2	java.io.BufferedReader
    //   30	125	3	localObject1	Object
    //   1	152	4	localObject2	Object
    //   4	52	5	localObject3	Object
    //   53	29	6	arrayOfChar	char[]
    // Exception table:
    //   from	to	target	type
    //   12	28	99	java/io/FileNotFoundException
    //   33	44	114	finally
    //   46	55	114	finally
    //   60	75	114	finally
    //   77	87	114	finally
    //   104	110	114	finally
    //   112	114	114	finally
    //   12	28	131	java/lang/Throwable
    //   141	145	151	java/lang/Throwable
    //   87	91	158	java/lang/Throwable
    //   119	123	162	java/lang/Throwable
    //   12	28	166	finally
    //   33	44	172	java/lang/Throwable
    //   46	55	172	java/lang/Throwable
    //   60	75	172	java/lang/Throwable
    //   77	87	172	java/lang/Throwable
    //   33	44	176	java/io/FileNotFoundException
    //   46	55	176	java/io/FileNotFoundException
    //   60	75	176	java/io/FileNotFoundException
    //   77	87	176	java/io/FileNotFoundException
  }
  
  private static boolean checkPermission(Context paramContext, String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(197425);
    if (!hasMarshmallow())
    {
      AppMethodBeat.o(197425);
      return true;
    }
    if ((paramContext == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(197425);
      return false;
    }
    if ("android.permission.WRITE_SETTINGS".equals(paramString)) {
      bool = Settings.System.canWrite(paramContext);
    }
    for (;;)
    {
      AppMethodBeat.o(197425);
      return bool;
      try
      {
        int i = b.checkSelfPermission(paramContext, paramString);
        if (i != 0) {
          bool = false;
        }
      }
      catch (Exception paramContext)
      {
        bool = false;
      }
    }
  }
  
  public static int getApiLevel()
  {
    return Build.VERSION.SDK_INT;
  }
  
  public static int getCpuArchFromId(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 5: 
      return 3;
    case 6: 
      return 4;
    case 7: 
      return 6;
    case 8: 
    case 9: 
    case 10: 
      return 50;
    }
    return 7;
  }
  
  public static int getCpuArchitecture()
  {
    AppMethodBeat.i(197424);
    int i;
    if (-1 != cpuArch)
    {
      i = cpuArch;
      AppMethodBeat.o(197424);
      return i;
    }
    if ((Build.CPU_ABI != null) && ((Build.CPU_ABI.contains("x86")) || (Build.CPU_ABI.contains("X86")))) {
      cpuArch = 1;
    }
    for (;;)
    {
      i = cpuArch;
      AppMethodBeat.o(197424);
      return i;
      if ((Build.CPU_ABI != null) && ((Build.CPU_ABI.contains("mips")) || (Build.CPU_ABI.contains("Mips"))))
      {
        cpuArch = 2;
      }
      else
      {
        if (mCpuArchitecture == 0) {
          getCpuInfo();
        }
        TPNativeLog.printLog(2, "getCpuArchitecture mCpuArchitecture:" + mCpuArchitecture);
        if ((!TextUtils.isEmpty(mCpuHardware)) && (mCpuHardware.contains("MSM8994")))
        {
          cpuArch = 7;
          AppMethodBeat.o(197424);
          return 7;
        }
        if (isARMV5Whitelist())
        {
          cpuArch = 3;
          AppMethodBeat.o(197424);
          return 3;
        }
        if ((!TextUtils.isEmpty(mProcessorName)) && (mProcessorName.contains("ARMv6")))
        {
          cpuArch = 4;
          AppMethodBeat.o(197424);
          return 4;
        }
        if ((!TextUtils.isEmpty(mProcessorName)) && (mProcessorName.contains("AArch64")))
        {
          cpuArch = 7;
          AppMethodBeat.o(197424);
          return 7;
        }
        if ((mCpuArchitecture == 7) && (!TextUtils.isEmpty(mFeature)) && (!mFeature.contains("neon")))
        {
          cpuArch = 4;
          AppMethodBeat.o(197424);
          return 4;
        }
        cpuArch = getCpuArchFromId(mCpuArchitecture);
      }
    }
  }
  
  private static int getCpuHWProducer(String paramString)
  {
    AppMethodBeat.i(197416);
    if (paramString.isEmpty())
    {
      AppMethodBeat.o(197416);
      return -1;
    }
    if ((paramString.contains("Exynos")) || (paramString.contains("SMDK")) || (paramString.contains("S5L8900")) || (paramString.contains("S5PC100")))
    {
      AppMethodBeat.o(197416);
      return 3;
    }
    if ((paramString.contains("Kirin")) || (paramString.contains("K3V")))
    {
      AppMethodBeat.o(197416);
      return 2;
    }
    if ((paramString.contains("MSM")) || (paramString.contains("APQ")) || (paramString.contains("QSD")) || (paramString.contains("SDM")))
    {
      AppMethodBeat.o(197416);
      return 0;
    }
    if (paramString.contains("MT6"))
    {
      AppMethodBeat.o(197416);
      return 1;
    }
    AppMethodBeat.o(197416);
    return -1;
  }
  
  public static int getCpuHWProductIndex(String paramString)
  {
    AppMethodBeat.i(197418);
    if (mCpuHWProducter < 0) {
      mCpuHWProducter = getCpuHWProducer(paramString);
    }
    if ((mCpuHWProducter >= 0) && (mCpuHWProductIdx < 0))
    {
      String[] arrayOfString = cpuPerfList[mCpuHWProducter];
      i = 0;
      int k = -1;
      if (i < arrayOfString.length)
      {
        int j = k;
        if (paramString.contains(arrayOfString[i]))
        {
          if (-1 != k) {
            break label80;
          }
          j = i;
        }
        for (;;)
        {
          i += 1;
          k = j;
          break;
          label80:
          j = k;
          if (arrayOfString[i].length() > arrayOfString[k].length()) {
            j = i;
          }
        }
      }
      mCpuHWProductIdx = k;
    }
    int i = mCpuHWProductIdx;
    AppMethodBeat.o(197418);
    return i;
  }
  
  public static int getCpuHWProducter(String paramString)
  {
    AppMethodBeat.i(197417);
    if (mCpuHWProducter < 0) {
      mCpuHWProducter = getCpuHWProducer(paramString);
    }
    int i = mCpuHWProducter;
    AppMethodBeat.o(197417);
    return i;
  }
  
  public static String getCpuHarewareName()
  {
    AppMethodBeat.i(197422);
    if (TextUtils.isEmpty(mCpuHardware)) {
      getCpuInfo();
    }
    String str = mCpuHardware;
    AppMethodBeat.o(197422);
    return str;
  }
  
  /* Error */
  public static void getCpuInfo()
  {
    // Byte code:
    //   0: ldc_w 550
    //   3: invokestatic 339	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 552	java/io/InputStreamReader
    //   9: dup
    //   10: new 554	java/io/FileInputStream
    //   13: dup
    //   14: ldc_w 556
    //   17: invokespecial 557	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   20: ldc_w 559
    //   23: invokespecial 562	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   26: astore_1
    //   27: new 414	java/io/BufferedReader
    //   30: dup
    //   31: aload_1
    //   32: invokespecial 422	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   35: astore_0
    //   36: aload_0
    //   37: astore_3
    //   38: aload_1
    //   39: astore_2
    //   40: aload_0
    //   41: invokevirtual 565	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   44: astore 4
    //   46: aload 4
    //   48: ifnull +57 -> 105
    //   51: aload_0
    //   52: astore_3
    //   53: aload_1
    //   54: astore_2
    //   55: aload 4
    //   57: invokestatic 568	com/tencent/thumbplayer/core/common/TPSystemInfo:parseCpuInfoLine	(Ljava/lang/String;)V
    //   60: goto -24 -> 36
    //   63: astore_2
    //   64: aload_0
    //   65: astore_3
    //   66: aload_1
    //   67: astore_2
    //   68: ldc_w 570
    //   71: putstatic 68	com/tencent/thumbplayer/core/common/TPSystemInfo:mCpuHardware	Ljava/lang/String;
    //   74: aload_0
    //   75: astore_3
    //   76: aload_1
    //   77: astore_2
    //   78: iconst_0
    //   79: putstatic 70	com/tencent/thumbplayer/core/common/TPSystemInfo:mCpuArchitecture	I
    //   82: aload_1
    //   83: ifnull +7 -> 90
    //   86: aload_1
    //   87: invokevirtual 571	java/io/InputStreamReader:close	()V
    //   90: aload_0
    //   91: ifnull +7 -> 98
    //   94: aload_0
    //   95: invokevirtual 439	java/io/BufferedReader:close	()V
    //   98: ldc_w 550
    //   101: invokestatic 395	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   104: return
    //   105: aload_1
    //   106: invokevirtual 571	java/io/InputStreamReader:close	()V
    //   109: aload_0
    //   110: invokevirtual 439	java/io/BufferedReader:close	()V
    //   113: ldc_w 550
    //   116: invokestatic 395	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   119: return
    //   120: astore_0
    //   121: iconst_4
    //   122: aload_0
    //   123: invokevirtual 572	java/io/IOException:getMessage	()Ljava/lang/String;
    //   126: invokestatic 404	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   129: ldc_w 550
    //   132: invokestatic 395	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: return
    //   136: astore_0
    //   137: iconst_4
    //   138: aload_0
    //   139: invokevirtual 572	java/io/IOException:getMessage	()Ljava/lang/String;
    //   142: invokestatic 404	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   145: ldc_w 550
    //   148: invokestatic 395	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   151: return
    //   152: astore_0
    //   153: aconst_null
    //   154: astore_2
    //   155: aconst_null
    //   156: astore_1
    //   157: aload_1
    //   158: ifnull +7 -> 165
    //   161: aload_1
    //   162: invokevirtual 571	java/io/InputStreamReader:close	()V
    //   165: aload_2
    //   166: ifnull +7 -> 173
    //   169: aload_2
    //   170: invokevirtual 439	java/io/BufferedReader:close	()V
    //   173: ldc_w 550
    //   176: invokestatic 395	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   179: aload_0
    //   180: athrow
    //   181: astore_1
    //   182: iconst_4
    //   183: aload_1
    //   184: invokevirtual 572	java/io/IOException:getMessage	()Ljava/lang/String;
    //   187: invokestatic 404	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   190: goto -17 -> 173
    //   193: astore_0
    //   194: aconst_null
    //   195: astore_2
    //   196: goto -39 -> 157
    //   199: astore_0
    //   200: aload_2
    //   201: astore_1
    //   202: aload_3
    //   203: astore_2
    //   204: goto -47 -> 157
    //   207: astore_0
    //   208: aconst_null
    //   209: astore_0
    //   210: aconst_null
    //   211: astore_1
    //   212: goto -148 -> 64
    //   215: astore_0
    //   216: aconst_null
    //   217: astore_0
    //   218: goto -154 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   35	75	0	localBufferedReader1	java.io.BufferedReader
    //   120	3	0	localIOException1	IOException
    //   136	3	0	localIOException2	IOException
    //   152	28	0	localObject1	Object
    //   193	1	0	localObject2	Object
    //   199	1	0	localObject3	Object
    //   207	1	0	localThrowable1	Throwable
    //   209	1	0	localObject4	Object
    //   215	1	0	localThrowable2	Throwable
    //   217	1	0	localObject5	Object
    //   26	136	1	localInputStreamReader1	java.io.InputStreamReader
    //   181	3	1	localIOException3	IOException
    //   201	11	1	localObject6	Object
    //   39	16	2	localInputStreamReader2	java.io.InputStreamReader
    //   63	1	2	localThrowable3	Throwable
    //   67	137	2	localObject7	Object
    //   37	166	3	localBufferedReader2	java.io.BufferedReader
    //   44	12	4	str	String
    // Exception table:
    //   from	to	target	type
    //   40	46	63	java/lang/Throwable
    //   55	60	63	java/lang/Throwable
    //   105	113	120	java/io/IOException
    //   86	90	136	java/io/IOException
    //   94	98	136	java/io/IOException
    //   6	27	152	finally
    //   161	165	181	java/io/IOException
    //   169	173	181	java/io/IOException
    //   27	36	193	finally
    //   40	46	199	finally
    //   55	60	199	finally
    //   68	74	199	finally
    //   78	82	199	finally
    //   6	27	207	java/lang/Throwable
    //   27	36	215	java/lang/Throwable
  }
  
  /* Error */
  public static long getCurrentCpuFreq()
  {
    // Byte code:
    //   0: ldc_w 574
    //   3: invokestatic 339	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 316	com/tencent/thumbplayer/core/common/TPSystemInfo:currentCpuFreq	J
    //   9: lconst_0
    //   10: lcmp
    //   11: ifle +15 -> 26
    //   14: getstatic 316	com/tencent/thumbplayer/core/common/TPSystemInfo:currentCpuFreq	J
    //   17: lstore_0
    //   18: ldc_w 574
    //   21: invokestatic 395	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: lload_0
    //   25: lreturn
    //   26: ldc2_w 575
    //   29: lstore_0
    //   30: new 552	java/io/InputStreamReader
    //   33: dup
    //   34: new 554	java/io/FileInputStream
    //   37: dup
    //   38: ldc_w 578
    //   41: invokespecial 557	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   44: ldc_w 559
    //   47: invokespecial 562	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   50: astore 12
    //   52: new 414	java/io/BufferedReader
    //   55: dup
    //   56: aload 12
    //   58: invokespecial 422	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   61: astore 15
    //   63: aload 15
    //   65: astore 14
    //   67: aload 12
    //   69: astore 13
    //   71: lload_0
    //   72: lstore 4
    //   74: lload_0
    //   75: lstore 6
    //   77: lload_0
    //   78: lstore 8
    //   80: lload_0
    //   81: lstore 10
    //   83: aload 15
    //   85: invokevirtual 565	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   88: astore 16
    //   90: aload 16
    //   92: ifnonnull +90 -> 182
    //   95: aload 15
    //   97: astore 14
    //   99: aload 12
    //   101: astore 13
    //   103: lload_0
    //   104: lstore 4
    //   106: lload_0
    //   107: lstore 6
    //   109: lload_0
    //   110: lstore 8
    //   112: lload_0
    //   113: lstore 10
    //   115: aload 12
    //   117: invokevirtual 571	java/io/InputStreamReader:close	()V
    //   120: aload 15
    //   122: astore 14
    //   124: aload 12
    //   126: astore 13
    //   128: lload_0
    //   129: lstore 4
    //   131: lload_0
    //   132: lstore 6
    //   134: lload_0
    //   135: lstore 8
    //   137: lload_0
    //   138: lstore 10
    //   140: aload 15
    //   142: invokevirtual 439	java/io/BufferedReader:close	()V
    //   145: aload 12
    //   147: invokevirtual 571	java/io/InputStreamReader:close	()V
    //   150: aload 15
    //   152: invokevirtual 439	java/io/BufferedReader:close	()V
    //   155: ldc_w 574
    //   158: invokestatic 395	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   161: lconst_0
    //   162: lreturn
    //   163: astore 12
    //   165: iconst_4
    //   166: aload 12
    //   168: invokevirtual 398	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   171: invokestatic 404	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   174: ldc_w 574
    //   177: invokestatic 395	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   180: lconst_0
    //   181: lreturn
    //   182: aload 15
    //   184: astore 14
    //   186: aload 12
    //   188: astore 13
    //   190: lload_0
    //   191: lstore 4
    //   193: lload_0
    //   194: lstore 6
    //   196: lload_0
    //   197: lstore 8
    //   199: lload_0
    //   200: lstore 10
    //   202: aload 16
    //   204: invokevirtual 581	java/lang/String:trim	()Ljava/lang/String;
    //   207: astore 16
    //   209: lload_0
    //   210: lstore_2
    //   211: aload 15
    //   213: astore 14
    //   215: aload 12
    //   217: astore 13
    //   219: lload_0
    //   220: lstore 4
    //   222: lload_0
    //   223: lstore 6
    //   225: lload_0
    //   226: lstore 8
    //   228: lload_0
    //   229: lstore 10
    //   231: aload 16
    //   233: invokevirtual 370	java/lang/String:length	()I
    //   236: ifle +29 -> 265
    //   239: aload 15
    //   241: astore 14
    //   243: aload 12
    //   245: astore 13
    //   247: lload_0
    //   248: lstore 4
    //   250: lload_0
    //   251: lstore 6
    //   253: lload_0
    //   254: lstore 8
    //   256: lload_0
    //   257: lstore 10
    //   259: aload 16
    //   261: invokestatic 587	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   264: lstore_2
    //   265: aload 15
    //   267: astore 14
    //   269: aload 12
    //   271: astore 13
    //   273: lload_2
    //   274: lstore 4
    //   276: lload_2
    //   277: lstore 6
    //   279: lload_2
    //   280: lstore 8
    //   282: lload_2
    //   283: lstore 10
    //   285: lload_2
    //   286: putstatic 316	com/tencent/thumbplayer/core/common/TPSystemInfo:currentCpuFreq	J
    //   289: aload 12
    //   291: invokevirtual 571	java/io/InputStreamReader:close	()V
    //   294: aload 15
    //   296: invokevirtual 439	java/io/BufferedReader:close	()V
    //   299: ldc_w 574
    //   302: invokestatic 395	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   305: lload_2
    //   306: lreturn
    //   307: astore 12
    //   309: iconst_4
    //   310: aload 12
    //   312: invokevirtual 398	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   315: invokestatic 404	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   318: ldc_w 574
    //   321: invokestatic 395	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   324: lconst_0
    //   325: lreturn
    //   326: astore 16
    //   328: aconst_null
    //   329: astore 15
    //   331: aconst_null
    //   332: astore 12
    //   334: aload 15
    //   336: astore 14
    //   338: aload 12
    //   340: astore 13
    //   342: iconst_4
    //   343: aload 16
    //   345: invokevirtual 588	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   348: invokestatic 404	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   351: aload 12
    //   353: ifnull +8 -> 361
    //   356: aload 12
    //   358: invokevirtual 571	java/io/InputStreamReader:close	()V
    //   361: lload_0
    //   362: lstore_2
    //   363: aload 15
    //   365: ifnull -66 -> 299
    //   368: aload 15
    //   370: invokevirtual 439	java/io/BufferedReader:close	()V
    //   373: lload_0
    //   374: lstore_2
    //   375: goto -76 -> 299
    //   378: astore 12
    //   380: iconst_4
    //   381: aload 12
    //   383: invokevirtual 398	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   386: invokestatic 404	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   389: ldc_w 574
    //   392: invokestatic 395	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   395: lconst_0
    //   396: lreturn
    //   397: astore 16
    //   399: aconst_null
    //   400: astore 15
    //   402: aconst_null
    //   403: astore 12
    //   405: aload 15
    //   407: astore 14
    //   409: aload 12
    //   411: astore 13
    //   413: iconst_4
    //   414: aload 16
    //   416: invokevirtual 572	java/io/IOException:getMessage	()Ljava/lang/String;
    //   419: invokestatic 404	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   422: aload 12
    //   424: ifnull +8 -> 432
    //   427: aload 12
    //   429: invokevirtual 571	java/io/InputStreamReader:close	()V
    //   432: lload_0
    //   433: lstore_2
    //   434: aload 15
    //   436: ifnull -137 -> 299
    //   439: aload 15
    //   441: invokevirtual 439	java/io/BufferedReader:close	()V
    //   444: lload_0
    //   445: lstore_2
    //   446: goto -147 -> 299
    //   449: astore 12
    //   451: iconst_4
    //   452: aload 12
    //   454: invokevirtual 398	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   457: invokestatic 404	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   460: ldc_w 574
    //   463: invokestatic 395	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   466: lconst_0
    //   467: lreturn
    //   468: astore 16
    //   470: aconst_null
    //   471: astore 15
    //   473: aconst_null
    //   474: astore 12
    //   476: aload 15
    //   478: astore 14
    //   480: aload 12
    //   482: astore 13
    //   484: iconst_4
    //   485: aload 16
    //   487: invokevirtual 589	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   490: invokestatic 404	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   493: aload 12
    //   495: ifnull +8 -> 503
    //   498: aload 12
    //   500: invokevirtual 571	java/io/InputStreamReader:close	()V
    //   503: lload_0
    //   504: lstore_2
    //   505: aload 15
    //   507: ifnull -208 -> 299
    //   510: aload 15
    //   512: invokevirtual 439	java/io/BufferedReader:close	()V
    //   515: lload_0
    //   516: lstore_2
    //   517: goto -218 -> 299
    //   520: astore 12
    //   522: iconst_4
    //   523: aload 12
    //   525: invokevirtual 398	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   528: invokestatic 404	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   531: ldc_w 574
    //   534: invokestatic 395	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   537: lconst_0
    //   538: lreturn
    //   539: astore 16
    //   541: aconst_null
    //   542: astore 15
    //   544: aconst_null
    //   545: astore 12
    //   547: aload 15
    //   549: astore 14
    //   551: aload 12
    //   553: astore 13
    //   555: iconst_4
    //   556: aload 16
    //   558: invokevirtual 398	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   561: invokestatic 404	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   564: aload 12
    //   566: ifnull +8 -> 574
    //   569: aload 12
    //   571: invokevirtual 571	java/io/InputStreamReader:close	()V
    //   574: lload_0
    //   575: lstore_2
    //   576: aload 15
    //   578: ifnull -279 -> 299
    //   581: aload 15
    //   583: invokevirtual 439	java/io/BufferedReader:close	()V
    //   586: lload_0
    //   587: lstore_2
    //   588: goto -289 -> 299
    //   591: astore 12
    //   593: iconst_4
    //   594: aload 12
    //   596: invokevirtual 398	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   599: invokestatic 404	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   602: ldc_w 574
    //   605: invokestatic 395	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   608: lconst_0
    //   609: lreturn
    //   610: astore 15
    //   612: aconst_null
    //   613: astore 14
    //   615: aconst_null
    //   616: astore 12
    //   618: aload 12
    //   620: ifnull +8 -> 628
    //   623: aload 12
    //   625: invokevirtual 571	java/io/InputStreamReader:close	()V
    //   628: aload 14
    //   630: ifnull +8 -> 638
    //   633: aload 14
    //   635: invokevirtual 439	java/io/BufferedReader:close	()V
    //   638: ldc_w 574
    //   641: invokestatic 395	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   644: aload 15
    //   646: athrow
    //   647: astore 12
    //   649: iconst_4
    //   650: aload 12
    //   652: invokevirtual 398	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   655: invokestatic 404	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   658: ldc_w 574
    //   661: invokestatic 395	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   664: lconst_0
    //   665: lreturn
    //   666: astore 15
    //   668: aconst_null
    //   669: astore 14
    //   671: goto -53 -> 618
    //   674: astore 15
    //   676: aload 13
    //   678: astore 12
    //   680: goto -62 -> 618
    //   683: astore 16
    //   685: aconst_null
    //   686: astore 15
    //   688: goto -141 -> 547
    //   691: astore 16
    //   693: lload 4
    //   695: lstore_0
    //   696: goto -149 -> 547
    //   699: astore 16
    //   701: aconst_null
    //   702: astore 15
    //   704: goto -228 -> 476
    //   707: astore 16
    //   709: lload 6
    //   711: lstore_0
    //   712: goto -236 -> 476
    //   715: astore 16
    //   717: aconst_null
    //   718: astore 15
    //   720: goto -315 -> 405
    //   723: astore 16
    //   725: lload 8
    //   727: lstore_0
    //   728: goto -323 -> 405
    //   731: astore 16
    //   733: aconst_null
    //   734: astore 15
    //   736: goto -402 -> 334
    //   739: astore 16
    //   741: lload 10
    //   743: lstore_0
    //   744: goto -410 -> 334
    // Local variable table:
    //   start	length	slot	name	signature
    //   17	727	0	l1	long
    //   210	378	2	l2	long
    //   72	622	4	l3	long
    //   75	635	6	l4	long
    //   78	648	8	l5	long
    //   81	661	10	l6	long
    //   50	96	12	localInputStreamReader	java.io.InputStreamReader
    //   163	127	12	localThrowable1	Throwable
    //   307	4	12	localThrowable2	Throwable
    //   332	25	12	localObject1	Object
    //   378	4	12	localThrowable3	Throwable
    //   403	25	12	localObject2	Object
    //   449	4	12	localThrowable4	Throwable
    //   474	25	12	localObject3	Object
    //   520	4	12	localThrowable5	Throwable
    //   545	25	12	localObject4	Object
    //   591	4	12	localThrowable6	Throwable
    //   616	8	12	localObject5	Object
    //   647	4	12	localThrowable7	Throwable
    //   678	1	12	localObject6	Object
    //   69	608	13	localObject7	Object
    //   65	605	14	localBufferedReader1	java.io.BufferedReader
    //   61	521	15	localBufferedReader2	java.io.BufferedReader
    //   610	35	15	localObject8	Object
    //   666	1	15	localObject9	Object
    //   674	1	15	localObject10	Object
    //   686	49	15	localObject11	Object
    //   88	172	16	str	String
    //   326	18	16	localFileNotFoundException1	java.io.FileNotFoundException
    //   397	18	16	localIOException1	IOException
    //   468	18	16	localException1	Exception
    //   539	18	16	localThrowable8	Throwable
    //   683	1	16	localThrowable9	Throwable
    //   691	1	16	localThrowable10	Throwable
    //   699	1	16	localException2	Exception
    //   707	1	16	localException3	Exception
    //   715	1	16	localIOException2	IOException
    //   723	1	16	localIOException3	IOException
    //   731	1	16	localFileNotFoundException2	java.io.FileNotFoundException
    //   739	1	16	localFileNotFoundException3	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   145	155	163	java/lang/Throwable
    //   289	299	307	java/lang/Throwable
    //   30	52	326	java/io/FileNotFoundException
    //   356	361	378	java/lang/Throwable
    //   368	373	378	java/lang/Throwable
    //   30	52	397	java/io/IOException
    //   427	432	449	java/lang/Throwable
    //   439	444	449	java/lang/Throwable
    //   30	52	468	java/lang/Exception
    //   498	503	520	java/lang/Throwable
    //   510	515	520	java/lang/Throwable
    //   30	52	539	java/lang/Throwable
    //   569	574	591	java/lang/Throwable
    //   581	586	591	java/lang/Throwable
    //   30	52	610	finally
    //   623	628	647	java/lang/Throwable
    //   633	638	647	java/lang/Throwable
    //   52	63	666	finally
    //   83	90	674	finally
    //   115	120	674	finally
    //   140	145	674	finally
    //   202	209	674	finally
    //   231	239	674	finally
    //   259	265	674	finally
    //   285	289	674	finally
    //   342	351	674	finally
    //   413	422	674	finally
    //   484	493	674	finally
    //   555	564	674	finally
    //   52	63	683	java/lang/Throwable
    //   83	90	691	java/lang/Throwable
    //   115	120	691	java/lang/Throwable
    //   140	145	691	java/lang/Throwable
    //   202	209	691	java/lang/Throwable
    //   231	239	691	java/lang/Throwable
    //   259	265	691	java/lang/Throwable
    //   285	289	691	java/lang/Throwable
    //   52	63	699	java/lang/Exception
    //   83	90	707	java/lang/Exception
    //   115	120	707	java/lang/Exception
    //   140	145	707	java/lang/Exception
    //   202	209	707	java/lang/Exception
    //   231	239	707	java/lang/Exception
    //   259	265	707	java/lang/Exception
    //   285	289	707	java/lang/Exception
    //   52	63	715	java/io/IOException
    //   83	90	723	java/io/IOException
    //   115	120	723	java/io/IOException
    //   140	145	723	java/io/IOException
    //   202	209	723	java/io/IOException
    //   231	239	723	java/io/IOException
    //   259	265	723	java/io/IOException
    //   285	289	723	java/io/IOException
    //   52	63	731	java/io/FileNotFoundException
    //   83	90	739	java/io/FileNotFoundException
    //   115	120	739	java/io/FileNotFoundException
    //   140	145	739	java/io/FileNotFoundException
    //   202	209	739	java/io/FileNotFoundException
    //   231	239	739	java/io/FileNotFoundException
    //   259	265	739	java/io/FileNotFoundException
    //   285	289	739	java/io/FileNotFoundException
  }
  
  public static String getDeviceID(Context paramContext)
  {
    AppMethodBeat.i(197428);
    if (!TextUtils.isEmpty(deviceID))
    {
      paramContext = deviceID;
      AppMethodBeat.o(197428);
      return paramContext;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(197428);
      return "";
    }
    try
    {
      paramContext = Settings.System.getString(paramContext.getContentResolver(), "android_id");
      deviceID = paramContext;
      if (TextUtils.isEmpty(paramContext)) {
        deviceID = "NONE";
      }
      paramContext = deviceID;
      AppMethodBeat.o(197428);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        deviceID = "NONE";
      }
    }
  }
  
  public static String getDeviceIMEI(Context paramContext)
  {
    AppMethodBeat.i(197426);
    if (!TextUtils.isEmpty(deviceIMEI))
    {
      paramContext = deviceIMEI;
      AppMethodBeat.o(197426);
      return paramContext;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(197426);
      return "";
    }
    if (!checkPermission(paramContext, "android.permission.READ_PHONE_STATE"))
    {
      deviceIMEI = "NONE";
      AppMethodBeat.o(197426);
      return "NONE";
    }
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext != null)
      {
        paramContext = paramContext.getDeviceId();
        deviceIMEI = paramContext;
        if (TextUtils.isEmpty(paramContext)) {
          deviceIMEI = "NONE";
        }
        paramContext = deviceIMEI;
        AppMethodBeat.o(197426);
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      deviceIMEI = "NONE";
      AppMethodBeat.o(197426);
    }
    return "NONE";
  }
  
  public static String getDeviceIMSI(Context paramContext)
  {
    AppMethodBeat.i(197427);
    if (!TextUtils.isEmpty(deviceIMSI))
    {
      paramContext = deviceIMSI;
      AppMethodBeat.o(197427);
      return paramContext;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(197427);
      return "";
    }
    if (!checkPermission(paramContext, "android.permission.READ_PHONE_STATE"))
    {
      deviceIMSI = "NONE";
      AppMethodBeat.o(197427);
      return "NONE";
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
        AppMethodBeat.o(197427);
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(197427);
      return "";
    }
    AppMethodBeat.o(197427);
    return "";
  }
  
  public static String getDeviceMacAddr(Context paramContext)
  {
    AppMethodBeat.i(197429);
    if (!TextUtils.isEmpty(deviceMacAddr))
    {
      paramContext = deviceMacAddr;
      AppMethodBeat.o(197429);
      return paramContext;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(197429);
      return "";
    }
    paramContext = _getDeviceMacAddr(paramContext);
    deviceMacAddr = paramContext;
    if (TextUtils.isEmpty(paramContext)) {
      deviceMacAddr = "NONE";
    }
    paramContext = deviceMacAddr;
    AppMethodBeat.o(197429);
    return paramContext;
  }
  
  public static String getDeviceName()
  {
    return Build.MODEL;
  }
  
  private static String getLowerMarshmallowDeviceMacAddr(Context paramContext)
  {
    AppMethodBeat.i(197431);
    try
    {
      paramContext = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
      if (paramContext == null)
      {
        AppMethodBeat.o(197431);
        return "";
      }
      paramContext = paramContext.getConnectionInfo();
      if (paramContext != null)
      {
        paramContext = paramContext.getMacAddress();
        AppMethodBeat.o(197431);
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      TPNativeLog.printLog(4, paramContext.getMessage());
      AppMethodBeat.o(197431);
    }
    return "";
  }
  
  /* Error */
  public static long getMaxCpuFreq()
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_2
    //   2: ldc_w 661
    //   5: invokestatic 339	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc2_w 311
    //   11: getstatic 314	com/tencent/thumbplayer/core/common/TPSystemInfo:maxCpuFreq	J
    //   14: lcmp
    //   15: ifeq +15 -> 30
    //   18: getstatic 314	com/tencent/thumbplayer/core/common/TPSystemInfo:maxCpuFreq	J
    //   21: lstore_0
    //   22: ldc_w 661
    //   25: invokestatic 395	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: lload_0
    //   29: lreturn
    //   30: new 552	java/io/InputStreamReader
    //   33: dup
    //   34: new 554	java/io/FileInputStream
    //   37: dup
    //   38: ldc_w 663
    //   41: invokespecial 557	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   44: ldc_w 559
    //   47: invokespecial 562	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   50: astore 4
    //   52: new 414	java/io/BufferedReader
    //   55: dup
    //   56: aload 4
    //   58: invokespecial 422	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   61: astore 5
    //   63: aload 5
    //   65: invokevirtual 565	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   68: astore 6
    //   70: aload 6
    //   72: ifnonnull +45 -> 117
    //   75: aload 4
    //   77: invokevirtual 571	java/io/InputStreamReader:close	()V
    //   80: aload 5
    //   82: invokevirtual 439	java/io/BufferedReader:close	()V
    //   85: aload 4
    //   87: invokevirtual 571	java/io/InputStreamReader:close	()V
    //   90: aload 5
    //   92: invokevirtual 439	java/io/BufferedReader:close	()V
    //   95: ldc_w 661
    //   98: invokestatic 395	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   101: lconst_0
    //   102: lreturn
    //   103: astore 4
    //   105: iconst_4
    //   106: aload 4
    //   108: invokevirtual 572	java/io/IOException:getMessage	()Ljava/lang/String;
    //   111: invokestatic 404	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   114: goto -19 -> 95
    //   117: aload 6
    //   119: invokevirtual 581	java/lang/String:trim	()Ljava/lang/String;
    //   122: astore 6
    //   124: lload_2
    //   125: lstore_0
    //   126: aload 6
    //   128: invokevirtual 370	java/lang/String:length	()I
    //   131: ifle +9 -> 140
    //   134: aload 6
    //   136: invokestatic 587	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   139: lstore_0
    //   140: aload 4
    //   142: invokevirtual 571	java/io/InputStreamReader:close	()V
    //   145: aload 5
    //   147: invokevirtual 439	java/io/BufferedReader:close	()V
    //   150: lload_0
    //   151: putstatic 314	com/tencent/thumbplayer/core/common/TPSystemInfo:maxCpuFreq	J
    //   154: iconst_2
    //   155: new 359	java/lang/StringBuilder
    //   158: dup
    //   159: ldc_w 665
    //   162: invokespecial 502	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   165: getstatic 314	com/tencent/thumbplayer/core/common/TPSystemInfo:maxCpuFreq	J
    //   168: invokevirtual 668	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   171: invokevirtual 389	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 404	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   177: ldc_w 661
    //   180: invokestatic 395	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   183: lload_0
    //   184: lreturn
    //   185: astore 4
    //   187: iconst_4
    //   188: aload 4
    //   190: invokevirtual 572	java/io/IOException:getMessage	()Ljava/lang/String;
    //   193: invokestatic 404	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   196: goto -46 -> 150
    //   199: astore 4
    //   201: aconst_null
    //   202: astore 5
    //   204: aconst_null
    //   205: astore 4
    //   207: aload 4
    //   209: ifnull +8 -> 217
    //   212: aload 4
    //   214: invokevirtual 571	java/io/InputStreamReader:close	()V
    //   217: lload_2
    //   218: lstore_0
    //   219: aload 5
    //   221: ifnull -71 -> 150
    //   224: aload 5
    //   226: invokevirtual 439	java/io/BufferedReader:close	()V
    //   229: lload_2
    //   230: lstore_0
    //   231: goto -81 -> 150
    //   234: astore 4
    //   236: iconst_4
    //   237: aload 4
    //   239: invokevirtual 572	java/io/IOException:getMessage	()Ljava/lang/String;
    //   242: invokestatic 404	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   245: lload_2
    //   246: lstore_0
    //   247: goto -97 -> 150
    //   250: astore 4
    //   252: aconst_null
    //   253: astore 5
    //   255: aconst_null
    //   256: astore 4
    //   258: aload 4
    //   260: ifnull +8 -> 268
    //   263: aload 4
    //   265: invokevirtual 571	java/io/InputStreamReader:close	()V
    //   268: lload_2
    //   269: lstore_0
    //   270: aload 5
    //   272: ifnull -122 -> 150
    //   275: aload 5
    //   277: invokevirtual 439	java/io/BufferedReader:close	()V
    //   280: lload_2
    //   281: lstore_0
    //   282: goto -132 -> 150
    //   285: astore 4
    //   287: iconst_4
    //   288: aload 4
    //   290: invokevirtual 572	java/io/IOException:getMessage	()Ljava/lang/String;
    //   293: invokestatic 404	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   296: lload_2
    //   297: lstore_0
    //   298: goto -148 -> 150
    //   301: astore 6
    //   303: aconst_null
    //   304: astore 5
    //   306: aconst_null
    //   307: astore 4
    //   309: aload 4
    //   311: ifnull +8 -> 319
    //   314: aload 4
    //   316: invokevirtual 571	java/io/InputStreamReader:close	()V
    //   319: aload 5
    //   321: ifnull +8 -> 329
    //   324: aload 5
    //   326: invokevirtual 439	java/io/BufferedReader:close	()V
    //   329: ldc_w 661
    //   332: invokestatic 395	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   335: aload 6
    //   337: athrow
    //   338: astore 4
    //   340: iconst_4
    //   341: aload 4
    //   343: invokevirtual 572	java/io/IOException:getMessage	()Ljava/lang/String;
    //   346: invokestatic 404	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   349: goto -20 -> 329
    //   352: astore 6
    //   354: aconst_null
    //   355: astore 5
    //   357: goto -48 -> 309
    //   360: astore 6
    //   362: goto -53 -> 309
    //   365: astore 5
    //   367: aconst_null
    //   368: astore 5
    //   370: goto -112 -> 258
    //   373: astore 6
    //   375: goto -117 -> 258
    //   378: astore 5
    //   380: aconst_null
    //   381: astore 5
    //   383: goto -176 -> 207
    //   386: astore 6
    //   388: goto -181 -> 207
    // Local variable table:
    //   start	length	slot	name	signature
    //   21	277	0	l1	long
    //   1	296	2	l2	long
    //   50	36	4	localInputStreamReader	java.io.InputStreamReader
    //   103	38	4	localIOException1	IOException
    //   185	4	4	localIOException2	IOException
    //   199	1	4	localIOException3	IOException
    //   205	8	4	localObject1	Object
    //   234	4	4	localIOException4	IOException
    //   250	1	4	localThrowable1	Throwable
    //   256	8	4	localObject2	Object
    //   285	4	4	localIOException5	IOException
    //   307	8	4	localObject3	Object
    //   338	4	4	localIOException6	IOException
    //   61	295	5	localBufferedReader	java.io.BufferedReader
    //   365	1	5	localThrowable2	Throwable
    //   368	1	5	localObject4	Object
    //   378	1	5	localIOException7	IOException
    //   381	1	5	localObject5	Object
    //   68	67	6	str	String
    //   301	35	6	localObject6	Object
    //   352	1	6	localObject7	Object
    //   360	1	6	localObject8	Object
    //   373	1	6	localThrowable3	Throwable
    //   386	1	6	localIOException8	IOException
    // Exception table:
    //   from	to	target	type
    //   85	95	103	java/io/IOException
    //   140	150	185	java/io/IOException
    //   30	52	199	java/io/IOException
    //   212	217	234	java/io/IOException
    //   224	229	234	java/io/IOException
    //   30	52	250	java/lang/Throwable
    //   263	268	285	java/io/IOException
    //   275	280	285	java/io/IOException
    //   30	52	301	finally
    //   314	319	338	java/io/IOException
    //   324	329	338	java/io/IOException
    //   52	63	352	finally
    //   63	70	360	finally
    //   75	85	360	finally
    //   117	124	360	finally
    //   126	140	360	finally
    //   52	63	365	java/lang/Throwable
    //   63	70	373	java/lang/Throwable
    //   75	85	373	java/lang/Throwable
    //   117	124	373	java/lang/Throwable
    //   126	140	373	java/lang/Throwable
    //   52	63	378	java/io/IOException
    //   63	70	386	java/io/IOException
    //   75	85	386	java/io/IOException
    //   117	124	386	java/io/IOException
    //   126	140	386	java/io/IOException
  }
  
  public static int getNumCores()
  {
    AppMethodBeat.i(197421);
    int i;
    if (-1 != numOfCores)
    {
      i = numOfCores;
      AppMethodBeat.o(197421);
      return i;
    }
    try
    {
      File[] arrayOfFile = new File("/sys/devices/system/cpu/").listFiles(new FileFilter()
      {
        public boolean accept(File paramAnonymousFile)
        {
          AppMethodBeat.i(197413);
          boolean bool = Pattern.matches("cpu[0-9]", paramAnonymousFile.getName());
          AppMethodBeat.o(197413);
          return bool;
        }
      });
      if (arrayOfFile == null)
      {
        numOfCores = 1;
        AppMethodBeat.o(197421);
        return 1;
      }
      numOfCores = arrayOfFile.length;
      TPNativeLog.printLog(2, "core num " + numOfCores);
      i = numOfCores;
      AppMethodBeat.o(197421);
      return i;
    }
    catch (Exception localException)
    {
      TPNativeLog.printLog(4, localException.getMessage());
      numOfCores = 1;
      AppMethodBeat.o(197421);
    }
    return 1;
  }
  
  public static int getOpenGLSupportVersion(Context paramContext)
  {
    AppMethodBeat.i(197441);
    if (mOpenGLVersion == 0) {}
    try
    {
      paramContext = (ActivityManager)paramContext.getApplicationContext().getSystemService("activity");
      if (paramContext == null)
      {
        i = mOpenGLVersion;
        AppMethodBeat.o(197441);
        return i;
      }
      mOpenGLVersion = paramContext.getDeviceConfigurationInfo().reqGlEsVersion;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        int i;
        TPNativeLog.printLog(4, paramContext.getMessage());
      }
    }
    i = mOpenGLVersion;
    AppMethodBeat.o(197441);
    return i;
  }
  
  public static String getOsVersion()
  {
    return Build.VERSION.RELEASE;
  }
  
  public static int getScreenHeight(Context paramContext)
  {
    AppMethodBeat.i(197434);
    if (paramContext == null)
    {
      AppMethodBeat.o(197434);
      return 0;
    }
    int i;
    if (mScreenHeight != 0)
    {
      i = mScreenHeight;
      AppMethodBeat.o(197434);
      return i;
    }
    try
    {
      mScreenHeight = paramContext.getResources().getDisplayMetrics().heightPixels;
      i = mScreenHeight;
      AppMethodBeat.o(197434);
      return i;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        mScreenHeight = 0;
      }
    }
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    AppMethodBeat.i(197433);
    if (paramContext == null)
    {
      AppMethodBeat.o(197433);
      return 0;
    }
    int i;
    if (mScreenWidth != 0)
    {
      i = mScreenWidth;
      AppMethodBeat.o(197433);
      return i;
    }
    try
    {
      mScreenWidth = paramContext.getResources().getDisplayMetrics().widthPixels;
      i = mScreenWidth;
      AppMethodBeat.o(197433);
      return i;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        mScreenWidth = 0;
      }
    }
  }
  
  public static int getSystemCpuUsage(String paramString1, String paramString2)
  {
    AppMethodBeat.i(197438);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(197438);
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
        TPNativeLog.printLog(4, paramString1.getMessage());
        float f1 = -1.0F;
      }
    }
    i = (int)f1;
    AppMethodBeat.o(197438);
    return i;
  }
  
  public static long getSystemIdleTime(String[] paramArrayOfString)
  {
    AppMethodBeat.i(197440);
    try
    {
      long l = Long.parseLong(paramArrayOfString[4]);
      AppMethodBeat.o(197440);
      return l;
    }
    catch (Throwable paramArrayOfString)
    {
      AppMethodBeat.o(197440);
    }
    return -1L;
  }
  
  public static long getSystemUptime(String[] paramArrayOfString)
  {
    AppMethodBeat.i(197439);
    long l1 = 0L;
    int i = 1;
    while (i < paramArrayOfString.length)
    {
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
        AppMethodBeat.o(197439);
        return -1L;
      }
    }
    AppMethodBeat.o(197439);
    return l1;
  }
  
  private static String getWlanName()
  {
    AppMethodBeat.i(197432);
    try
    {
      if (getWlanMethod == null) {
        getWlanMethod = Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class, String.class });
      }
      str1 = (String)getWlanMethod.invoke(null, new Object[] { "wifi.interface", "wlan0" });
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        String str1;
        TPNativeLog.printLog(4, localThrowable.getMessage());
        String str2 = "wlan0";
      }
    }
    AppMethodBeat.o(197432);
    return str1;
  }
  
  private static boolean hasMarshmallow()
  {
    return Build.VERSION.SDK_INT >= 23;
  }
  
  public static boolean isARMV5Whitelist()
  {
    AppMethodBeat.i(197423);
    if ((getDeviceName().equals("XT882")) || (getDeviceName().equals("ME860")) || (getDeviceName().equals("MB860")) || (getDeviceName().equals("Lenovo P70")) || (getDeviceName().equals("Lenovo A60")) || (getDeviceName().equals("Lenovo A366t")))
    {
      AppMethodBeat.o(197423);
      return true;
    }
    AppMethodBeat.o(197423);
    return false;
  }
  
  private static void parseCpuInfoLine(String paramString)
  {
    AppMethodBeat.i(197414);
    if ((paramString.contains("aarch64")) || (paramString.contains("AArch64"))) {
      mCpuArchitecture = 64;
    }
    int i;
    if (paramString.startsWith("Processor"))
    {
      i = paramString.indexOf(':');
      if (i > 1)
      {
        paramString = paramString.substring(i + 1, paramString.length());
        mProcessorName = paramString;
        mProcessorName = paramString.trim();
      }
      AppMethodBeat.o(197414);
      return;
    }
    if (paramString.startsWith("CPU architecture"))
    {
      if (mCpuArchitecture == 0)
      {
        i = paramString.indexOf(':');
        if (i > 1)
        {
          paramString = paramString.substring(i + 1, paramString.length()).trim();
          if ((paramString.length() > 0) && (paramString.length() < 2))
          {
            mCpuArchitecture = (int)Long.parseLong(paramString);
            AppMethodBeat.o(197414);
            return;
          }
          if (paramString.length() > 1) {
            mCpuArchitecture = (int)Long.parseLong(paramString.substring(0, 1));
          }
        }
        AppMethodBeat.o(197414);
      }
    }
    else
    {
      if (paramString.startsWith("Features"))
      {
        i = paramString.indexOf(':');
        if (i > 1) {
          mFeature = paramString.substring(i + 1, paramString.length()).trim();
        }
        AppMethodBeat.o(197414);
        return;
      }
      if (paramString.startsWith("Hardware"))
      {
        i = paramString.indexOf(':');
        if (i > 1)
        {
          mCpuHardware = paramString.substring(i + 1, paramString.length()).trim().replace(" ", "");
          TPNativeLog.printLog(2, "hardware " + mCpuHardware);
          getCpuHWProductIndex(mCpuHardware);
        }
      }
    }
    AppMethodBeat.o(197414);
  }
  
  /* Error */
  public static String readSystemStat()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc_w 822
    //   5: invokestatic 339	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 824	java/io/RandomAccessFile
    //   11: dup
    //   12: ldc_w 826
    //   15: ldc_w 828
    //   18: invokespecial 831	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: astore_0
    //   22: aload_0
    //   23: invokevirtual 832	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
    //   26: astore_1
    //   27: aload_0
    //   28: invokevirtual 833	java/io/RandomAccessFile:close	()V
    //   31: ldc_w 822
    //   34: invokestatic 395	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: aload_1
    //   38: areturn
    //   39: astore_0
    //   40: iconst_4
    //   41: aload_0
    //   42: invokevirtual 398	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   45: invokestatic 404	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   48: goto -17 -> 31
    //   51: astore_0
    //   52: aconst_null
    //   53: astore_0
    //   54: aload_2
    //   55: astore_1
    //   56: aload_0
    //   57: ifnull -26 -> 31
    //   60: aload_0
    //   61: invokevirtual 833	java/io/RandomAccessFile:close	()V
    //   64: aload_2
    //   65: astore_1
    //   66: goto -35 -> 31
    //   69: astore_0
    //   70: iconst_4
    //   71: aload_0
    //   72: invokevirtual 398	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   75: invokestatic 404	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   78: aload_2
    //   79: astore_1
    //   80: goto -49 -> 31
    //   83: astore_0
    //   84: aconst_null
    //   85: astore_1
    //   86: aload_1
    //   87: ifnull +7 -> 94
    //   90: aload_1
    //   91: invokevirtual 833	java/io/RandomAccessFile:close	()V
    //   94: ldc_w 822
    //   97: invokestatic 395	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: aload_0
    //   101: athrow
    //   102: astore_1
    //   103: iconst_4
    //   104: aload_1
    //   105: invokevirtual 398	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   108: invokestatic 404	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   111: goto -17 -> 94
    //   114: astore_1
    //   115: aload_0
    //   116: astore_2
    //   117: aload_1
    //   118: astore_0
    //   119: aload_2
    //   120: astore_1
    //   121: goto -35 -> 86
    //   124: astore_1
    //   125: goto -71 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   21	7	0	localRandomAccessFile	java.io.RandomAccessFile
    //   39	3	0	localThrowable1	Throwable
    //   51	1	0	localThrowable2	Throwable
    //   53	8	0	localObject1	Object
    //   69	3	0	localThrowable3	Throwable
    //   83	33	0	localObject2	Object
    //   118	1	0	localObject3	Object
    //   26	65	1	localObject4	Object
    //   102	3	1	localThrowable4	Throwable
    //   114	4	1	localObject5	Object
    //   120	1	1	localObject6	Object
    //   124	1	1	localThrowable5	Throwable
    //   1	119	2	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   27	31	39	java/lang/Throwable
    //   8	22	51	java/lang/Throwable
    //   60	64	69	java/lang/Throwable
    //   8	22	83	finally
    //   90	94	102	java/lang/Throwable
    //   22	27	114	finally
    //   22	27	124	java/lang/Throwable
  }
  
  public static boolean supportInDeviceDolbyAudioEffect()
  {
    AppMethodBeat.i(197442);
    try
    {
      arrayOfDescriptor = AudioEffect.queryEffects();
      j = arrayOfDescriptor.length;
      i = 0;
      bool1 = false;
    }
    catch (Exception localException1)
    {
      try
      {
        AudioEffect.Descriptor[] arrayOfDescriptor;
        int j;
        int i;
        bool2 = arrayOfDescriptor[i].implementor.contains("Dolby Laboratories");
        if (bool2) {
          bool1 = true;
        }
        i += 1;
      }
      catch (Exception localException2)
      {
        boolean bool1;
        boolean bool2;
        break label57;
      }
      localException1 = localException1;
      bool1 = false;
    }
    bool2 = bool1;
    if (i < j)
    {
      label57:
      TPNativeLog.printLog(4, localException1.getMessage());
      bool2 = bool1;
    }
    AppMethodBeat.o(197442);
    return bool2;
  }
  
  private static void writeStringToFile(String paramString1, String paramString2)
  {
    AppMethodBeat.i(197435);
    Object localObject = null;
    try
    {
      paramString1 = new File(paramString1);
      if (!paramString1.exists())
      {
        boolean bool = paramString1.createNewFile();
        if (bool)
        {
          AppMethodBeat.o(197435);
          return;
        }
      }
      paramString1 = new FileWriter(paramString1, false);
      if (paramString1 == null) {
        break label89;
      }
    }
    catch (Throwable paramString1)
    {
      try
      {
        paramString1.write(paramString2);
        paramString1.flush();
        paramString1.close();
        AppMethodBeat.o(197435);
        return;
      }
      catch (Throwable paramString2)
      {
        break label73;
      }
      paramString1 = paramString1;
      paramString1 = localObject;
    }
    try
    {
      label73:
      paramString1.close();
      AppMethodBeat.o(197435);
      return;
    }
    catch (IOException paramString1) {}
    label89:
    AppMethodBeat.o(197435);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPSystemInfo
 * JD-Core Version:    0.7.0.1
 */