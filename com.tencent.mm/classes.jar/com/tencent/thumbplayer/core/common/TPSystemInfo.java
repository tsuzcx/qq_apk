package com.tencent.thumbplayer.core.common;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.audiofx.AudioEffect;
import android.media.audiofx.AudioEffect.Descriptor;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import android.support.v4.content.ContextCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.NetworkInterface;

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
  private static int mAudioBestFramesPerBust;
  private static int mAudioBestSampleRate;
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
    mAudioBestSampleRate = 0;
    mAudioBestFramesPerBust = 0;
    String[] arrayOfString1 = { "MT6516", "MT6513", "MT6573", "MT6515M", "MT6515", "MT6575", "MT6572", "MT6577", "MT6589", "MT6582", "MT6592", "MT6595", "MT6735", "MT6750", "MT6753", "MT6752", "MT6755", "MT6755", "MT6755T", "MT6795", "MT6757", "MT675x", "MT6797", "MT6797T" };
    String[] arrayOfString2 = { "S5L8900", "S5PC100", "Exynos3110", "Exynos3475", "Exynos4210", "Exynos4212", "SMDK4x12", "Exynos4412", "Exynos5250", "Exynos5260", "Exynos5410", "Exynos5420", "Exynos5422", "Exynos5430", "Exynos5800", "Exynos5433", "Exynos7580", "Exynos7870", "Exynos7870", "Exynos7420", "Exynos8890" };
    cpuPerfList = new String[][] { { "MSM7227", "MSM7627", "MSM7227T", "MSM7627T", "MSM7227A", "MSM7627A", "QSD8250", "QSD8650", "MSM7230", "MSM7630", "APQ8055", "MSM8255", "MSM8655", "MSM8255T", "MSM8655T", "MSM8225", "MSM8625", "MSM8260", "MSM8660", "MSM8x25Q", "MSM8x26", "MSM8x10", "MSM8x12", "MSM8x30", "MSM8260A", "MSM8660A", "MSM8960", "MSM8208", "MSM8916", "MSM8960T", "MSM8909", "MSM8916v2", "MSM8936", "MSM8909v2", "MSM8917", "APQ8064", "APQ8064T", "MSM8920", "MSM8939", "MSM8937", "MSM8939v2", "MSM8940", "MSM8952", "MSM8974", "MSM8x74AA", "MSM8x74AB", "MSM8x74AC", "MSM8953", "APQ8084", "MSM8953Pro", "MSM8992", "MSM8956", "MSM8976", "MSM8976Pro", "MSM8994", "MSM8996", "MSM8996Pro", "MSM8998", "SDM845", "SM8150", "SM8250", "SM8350" }, arrayOfString1, { "K3V2", "K3V2E", "K3V2+", "Kirin910", "Kirin920", "Kirin925", "Kirin928", "Kirin620", "Kirin650", "Kirin655", "Kirin930", "Kirin935", "Kirin950", "Kirin955", "Kirin960", "Kirin970", "Kirin980", "Kirin990" }, arrayOfString2 };
    maxCpuFreq = -1L;
    currentCpuFreq = -1L;
    numOfCores = -1;
  }
  
  private static String _getDeviceMacAddr(Context paramContext)
  {
    AppMethodBeat.i(227983);
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
      finally
      {
        TPNativeLog.printLog(4, paramContext.getMessage());
        paramContext = str;
        continue;
      }
      AppMethodBeat.o(227983);
      return paramContext;
      paramContext = getLowerMarshmallowDeviceMacAddr(paramContext);
      continue;
      label161:
      i += 1;
    }
  }
  
  private static boolean checkPermission(Context paramContext, String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(227894);
    if (!hasMarshmallow())
    {
      AppMethodBeat.o(227894);
      return true;
    }
    if ((paramContext == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(227894);
      return false;
    }
    if ("android.permission.WRITE_SETTINGS".equals(paramString)) {
      bool = Settings.System.canWrite(paramContext);
    }
    for (;;)
    {
      AppMethodBeat.o(227894);
      return bool;
      try
      {
        int i = ContextCompat.checkSelfPermission(paramContext, paramString);
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
  
  public static int getBestAudioFramesPerBust()
  {
    return mAudioBestFramesPerBust;
  }
  
  public static int getBestAudioSampleRate()
  {
    return mAudioBestSampleRate;
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
    AppMethodBeat.i(227874);
    int i;
    if (-1 != cpuArch)
    {
      i = cpuArch;
      AppMethodBeat.o(227874);
      return i;
    }
    if ((Build.CPU_ABI != null) && ((Build.CPU_ABI.contains("x86")) || (Build.CPU_ABI.contains("X86")))) {
      cpuArch = 1;
    }
    for (;;)
    {
      i = cpuArch;
      AppMethodBeat.o(227874);
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
          AppMethodBeat.o(227874);
          return 7;
        }
        if (isARMV5Whitelist())
        {
          cpuArch = 3;
          AppMethodBeat.o(227874);
          return 3;
        }
        if ((!TextUtils.isEmpty(mProcessorName)) && (mProcessorName.contains("ARMv6")))
        {
          cpuArch = 4;
          AppMethodBeat.o(227874);
          return 4;
        }
        if ((!TextUtils.isEmpty(mProcessorName)) && (mProcessorName.contains("AArch64")))
        {
          cpuArch = 7;
          AppMethodBeat.o(227874);
          return 7;
        }
        if ((mCpuArchitecture == 7) && (!TextUtils.isEmpty(mFeature)) && (!mFeature.contains("neon")))
        {
          cpuArch = 4;
          AppMethodBeat.o(227874);
          return 4;
        }
        cpuArch = getCpuArchFromId(mCpuArchitecture);
      }
    }
  }
  
  private static int getCpuHWProducer(String paramString)
  {
    AppMethodBeat.i(227756);
    if (paramString.isEmpty())
    {
      AppMethodBeat.o(227756);
      return -1;
    }
    if ((paramString.contains("Exynos")) || (paramString.contains("SMDK")) || (paramString.contains("S5L8900")) || (paramString.contains("S5PC100")))
    {
      AppMethodBeat.o(227756);
      return 3;
    }
    if ((paramString.contains("Kirin")) || (paramString.contains("K3V")))
    {
      AppMethodBeat.o(227756);
      return 2;
    }
    if ((paramString.contains("MSM")) || (paramString.contains("APQ")) || (paramString.contains("QSD")) || (paramString.contains("SDM")) || (paramString.contains("SM")))
    {
      AppMethodBeat.o(227756);
      return 0;
    }
    if (paramString.contains("MT6"))
    {
      AppMethodBeat.o(227756);
      return 1;
    }
    AppMethodBeat.o(227756);
    return -1;
  }
  
  public static int getCpuHWProductIndex(String paramString)
  {
    AppMethodBeat.i(227775);
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
    AppMethodBeat.o(227775);
    return i;
  }
  
  public static int getCpuHWProducter(String paramString)
  {
    AppMethodBeat.i(227764);
    if (mCpuHWProducter < 0) {
      mCpuHWProducter = getCpuHWProducer(paramString);
    }
    int i = mCpuHWProducter;
    AppMethodBeat.o(227764);
    return i;
  }
  
  public static String getCpuHarewareName()
  {
    AppMethodBeat.i(227828);
    if (TextUtils.isEmpty(mCpuHardware)) {
      getCpuInfo();
    }
    String str = mCpuHardware;
    AppMethodBeat.o(227828);
    return str;
  }
  
  /* Error */
  public static void getCpuInfo()
  {
    // Byte code:
    //   0: ldc_w 541
    //   3: invokestatic 356	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 543	java/io/InputStreamReader
    //   9: dup
    //   10: new 545	java/io/FileInputStream
    //   13: dup
    //   14: ldc_w 547
    //   17: invokespecial 548	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   20: ldc_w 550
    //   23: invokespecial 553	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   26: astore_1
    //   27: new 555	java/io/BufferedReader
    //   30: dup
    //   31: aload_1
    //   32: invokespecial 558	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   35: astore_0
    //   36: aload_0
    //   37: invokevirtual 561	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   40: astore_2
    //   41: aload_2
    //   42: ifnull +44 -> 86
    //   45: aload_2
    //   46: invokestatic 564	com/tencent/thumbplayer/core/common/TPSystemInfo:parseCpuInfoLine	(Ljava/lang/String;)V
    //   49: goto -13 -> 36
    //   52: astore_2
    //   53: ldc_w 566
    //   56: putstatic 67	com/tencent/thumbplayer/core/common/TPSystemInfo:mCpuHardware	Ljava/lang/String;
    //   59: iconst_0
    //   60: putstatic 69	com/tencent/thumbplayer/core/common/TPSystemInfo:mCpuArchitecture	I
    //   63: aload_1
    //   64: ifnull +7 -> 71
    //   67: aload_1
    //   68: invokevirtual 569	java/io/InputStreamReader:close	()V
    //   71: aload_0
    //   72: ifnull +7 -> 79
    //   75: aload_0
    //   76: invokevirtual 570	java/io/BufferedReader:close	()V
    //   79: ldc_w 541
    //   82: invokestatic 412	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: return
    //   86: aload_1
    //   87: invokevirtual 569	java/io/InputStreamReader:close	()V
    //   90: aload_0
    //   91: invokevirtual 570	java/io/BufferedReader:close	()V
    //   94: ldc_w 541
    //   97: invokestatic 412	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: return
    //   101: astore_0
    //   102: iconst_4
    //   103: aload_0
    //   104: invokevirtual 571	java/io/IOException:getMessage	()Ljava/lang/String;
    //   107: invokestatic 423	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   110: ldc_w 541
    //   113: invokestatic 412	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   116: return
    //   117: astore_0
    //   118: iconst_4
    //   119: aload_0
    //   120: invokevirtual 571	java/io/IOException:getMessage	()Ljava/lang/String;
    //   123: invokestatic 423	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   126: ldc_w 541
    //   129: invokestatic 412	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   132: return
    //   133: astore_2
    //   134: aload_1
    //   135: ifnull +7 -> 142
    //   138: aload_1
    //   139: invokevirtual 569	java/io/InputStreamReader:close	()V
    //   142: aload_0
    //   143: ifnull +7 -> 150
    //   146: aload_0
    //   147: invokevirtual 570	java/io/BufferedReader:close	()V
    //   150: ldc_w 541
    //   153: invokestatic 412	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: aload_2
    //   157: athrow
    //   158: astore_0
    //   159: iconst_4
    //   160: aload_0
    //   161: invokevirtual 571	java/io/IOException:getMessage	()Ljava/lang/String;
    //   164: invokestatic 423	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   167: goto -17 -> 150
    //   170: astore_0
    //   171: aconst_null
    //   172: astore_0
    //   173: aconst_null
    //   174: astore_1
    //   175: goto -122 -> 53
    //   178: astore_0
    //   179: aconst_null
    //   180: astore_0
    //   181: goto -128 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   35	56	0	localBufferedReader	java.io.BufferedReader
    //   101	3	0	localIOException1	IOException
    //   117	30	0	localIOException2	IOException
    //   158	3	0	localIOException3	IOException
    //   170	1	0	localObject1	Object
    //   172	1	0	localObject2	Object
    //   178	1	0	localObject3	Object
    //   180	1	0	localObject4	Object
    //   26	149	1	localInputStreamReader	java.io.InputStreamReader
    //   40	6	2	str	String
    //   52	1	2	localObject5	Object
    //   133	24	2	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   36	41	52	finally
    //   45	49	52	finally
    //   86	94	101	java/io/IOException
    //   67	71	117	java/io/IOException
    //   75	79	117	java/io/IOException
    //   53	63	133	finally
    //   138	142	158	java/io/IOException
    //   146	150	158	java/io/IOException
    //   6	27	170	finally
    //   27	36	178	finally
  }
  
  /* Error */
  public static long getCurrentCpuFreq()
  {
    // Byte code:
    //   0: ldc_w 576
    //   3: invokestatic 356	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 335	com/tencent/thumbplayer/core/common/TPSystemInfo:currentCpuFreq	J
    //   9: lconst_0
    //   10: lcmp
    //   11: ifle +15 -> 26
    //   14: getstatic 335	com/tencent/thumbplayer/core/common/TPSystemInfo:currentCpuFreq	J
    //   17: lstore_0
    //   18: ldc_w 576
    //   21: invokestatic 412	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: lload_0
    //   25: lreturn
    //   26: ldc2_w 577
    //   29: lstore_0
    //   30: new 543	java/io/InputStreamReader
    //   33: dup
    //   34: new 545	java/io/FileInputStream
    //   37: dup
    //   38: ldc_w 580
    //   41: invokespecial 548	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   44: ldc_w 550
    //   47: invokespecial 553	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   50: astore 12
    //   52: new 555	java/io/BufferedReader
    //   55: dup
    //   56: aload 12
    //   58: invokespecial 558	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   61: astore 13
    //   63: lload_0
    //   64: lstore 4
    //   66: lload_0
    //   67: lstore 6
    //   69: lload_0
    //   70: lstore 8
    //   72: lload_0
    //   73: lstore 10
    //   75: aload 13
    //   77: invokevirtual 561	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   80: astore 14
    //   82: aload 14
    //   84: ifnonnull +74 -> 158
    //   87: lload_0
    //   88: lstore 4
    //   90: lload_0
    //   91: lstore 6
    //   93: lload_0
    //   94: lstore 8
    //   96: lload_0
    //   97: lstore 10
    //   99: aload 12
    //   101: invokevirtual 569	java/io/InputStreamReader:close	()V
    //   104: lload_0
    //   105: lstore 4
    //   107: lload_0
    //   108: lstore 6
    //   110: lload_0
    //   111: lstore 8
    //   113: lload_0
    //   114: lstore 10
    //   116: aload 13
    //   118: invokevirtual 570	java/io/BufferedReader:close	()V
    //   121: aload 12
    //   123: invokevirtual 569	java/io/InputStreamReader:close	()V
    //   126: aload 13
    //   128: invokevirtual 570	java/io/BufferedReader:close	()V
    //   131: ldc_w 576
    //   134: invokestatic 412	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   137: lconst_0
    //   138: lreturn
    //   139: astore 12
    //   141: iconst_4
    //   142: aload 12
    //   144: invokevirtual 417	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   147: invokestatic 423	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   150: ldc_w 576
    //   153: invokestatic 412	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: lconst_0
    //   157: lreturn
    //   158: lload_0
    //   159: lstore 4
    //   161: lload_0
    //   162: lstore 6
    //   164: lload_0
    //   165: lstore 8
    //   167: lload_0
    //   168: lstore 10
    //   170: aload 14
    //   172: invokevirtual 583	java/lang/String:trim	()Ljava/lang/String;
    //   175: astore 14
    //   177: lload_0
    //   178: lstore_2
    //   179: lload_0
    //   180: lstore 4
    //   182: lload_0
    //   183: lstore 6
    //   185: lload_0
    //   186: lstore 8
    //   188: lload_0
    //   189: lstore 10
    //   191: aload 14
    //   193: invokevirtual 387	java/lang/String:length	()I
    //   196: ifle +21 -> 217
    //   199: lload_0
    //   200: lstore 4
    //   202: lload_0
    //   203: lstore 6
    //   205: lload_0
    //   206: lstore 8
    //   208: lload_0
    //   209: lstore 10
    //   211: aload 14
    //   213: invokestatic 589	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   216: lstore_2
    //   217: lload_2
    //   218: lstore 4
    //   220: lload_2
    //   221: lstore 6
    //   223: lload_2
    //   224: lstore 8
    //   226: lload_2
    //   227: lstore 10
    //   229: lload_2
    //   230: putstatic 335	com/tencent/thumbplayer/core/common/TPSystemInfo:currentCpuFreq	J
    //   233: aload 12
    //   235: invokevirtual 569	java/io/InputStreamReader:close	()V
    //   238: aload 13
    //   240: invokevirtual 570	java/io/BufferedReader:close	()V
    //   243: ldc_w 576
    //   246: invokestatic 412	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   249: lload_2
    //   250: lreturn
    //   251: astore 12
    //   253: iconst_4
    //   254: aload 12
    //   256: invokevirtual 417	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   259: invokestatic 423	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   262: ldc_w 576
    //   265: invokestatic 412	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   268: lconst_0
    //   269: lreturn
    //   270: astore 15
    //   272: aconst_null
    //   273: astore 14
    //   275: aconst_null
    //   276: astore 16
    //   278: aload 14
    //   280: astore 12
    //   282: aload 16
    //   284: astore 13
    //   286: iconst_4
    //   287: aload 15
    //   289: invokevirtual 590	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   292: invokestatic 423	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   295: aload 16
    //   297: ifnull +8 -> 305
    //   300: aload 16
    //   302: invokevirtual 569	java/io/InputStreamReader:close	()V
    //   305: lload_0
    //   306: lstore_2
    //   307: aload 14
    //   309: ifnull -66 -> 243
    //   312: aload 14
    //   314: invokevirtual 570	java/io/BufferedReader:close	()V
    //   317: lload_0
    //   318: lstore_2
    //   319: goto -76 -> 243
    //   322: astore 12
    //   324: iconst_4
    //   325: aload 12
    //   327: invokevirtual 417	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   330: invokestatic 423	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   333: ldc_w 576
    //   336: invokestatic 412	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   339: lconst_0
    //   340: lreturn
    //   341: astore 15
    //   343: aconst_null
    //   344: astore 14
    //   346: aconst_null
    //   347: astore 16
    //   349: aload 14
    //   351: astore 12
    //   353: aload 16
    //   355: astore 13
    //   357: iconst_4
    //   358: aload 15
    //   360: invokevirtual 571	java/io/IOException:getMessage	()Ljava/lang/String;
    //   363: invokestatic 423	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   366: aload 16
    //   368: ifnull +8 -> 376
    //   371: aload 16
    //   373: invokevirtual 569	java/io/InputStreamReader:close	()V
    //   376: lload_0
    //   377: lstore_2
    //   378: aload 14
    //   380: ifnull -137 -> 243
    //   383: aload 14
    //   385: invokevirtual 570	java/io/BufferedReader:close	()V
    //   388: lload_0
    //   389: lstore_2
    //   390: goto -147 -> 243
    //   393: astore 12
    //   395: iconst_4
    //   396: aload 12
    //   398: invokevirtual 417	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   401: invokestatic 423	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   404: ldc_w 576
    //   407: invokestatic 412	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   410: lconst_0
    //   411: lreturn
    //   412: astore 15
    //   414: aconst_null
    //   415: astore 14
    //   417: aconst_null
    //   418: astore 16
    //   420: aload 14
    //   422: astore 12
    //   424: aload 16
    //   426: astore 13
    //   428: iconst_4
    //   429: aload 15
    //   431: invokevirtual 591	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   434: invokestatic 423	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   437: aload 16
    //   439: ifnull +8 -> 447
    //   442: aload 16
    //   444: invokevirtual 569	java/io/InputStreamReader:close	()V
    //   447: lload_0
    //   448: lstore_2
    //   449: aload 14
    //   451: ifnull -208 -> 243
    //   454: aload 14
    //   456: invokevirtual 570	java/io/BufferedReader:close	()V
    //   459: lload_0
    //   460: lstore_2
    //   461: goto -218 -> 243
    //   464: astore 12
    //   466: iconst_4
    //   467: aload 12
    //   469: invokevirtual 417	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   472: invokestatic 423	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   475: ldc_w 576
    //   478: invokestatic 412	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   481: lconst_0
    //   482: lreturn
    //   483: astore 15
    //   485: aconst_null
    //   486: astore 14
    //   488: aconst_null
    //   489: astore 16
    //   491: aload 14
    //   493: astore 12
    //   495: aload 16
    //   497: astore 13
    //   499: iconst_4
    //   500: aload 15
    //   502: invokevirtual 417	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   505: invokestatic 423	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   508: aload 16
    //   510: ifnull +8 -> 518
    //   513: aload 16
    //   515: invokevirtual 569	java/io/InputStreamReader:close	()V
    //   518: lload_0
    //   519: lstore_2
    //   520: aload 14
    //   522: ifnull -279 -> 243
    //   525: aload 14
    //   527: invokevirtual 570	java/io/BufferedReader:close	()V
    //   530: lload_0
    //   531: lstore_2
    //   532: goto -289 -> 243
    //   535: astore 12
    //   537: iconst_4
    //   538: aload 12
    //   540: invokevirtual 417	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   543: invokestatic 423	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   546: ldc_w 576
    //   549: invokestatic 412	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   552: lconst_0
    //   553: lreturn
    //   554: astore 14
    //   556: aload 13
    //   558: ifnull +8 -> 566
    //   561: aload 13
    //   563: invokevirtual 569	java/io/InputStreamReader:close	()V
    //   566: aload 12
    //   568: ifnull +8 -> 576
    //   571: aload 12
    //   573: invokevirtual 570	java/io/BufferedReader:close	()V
    //   576: ldc_w 576
    //   579: invokestatic 412	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   582: aload 14
    //   584: athrow
    //   585: astore 12
    //   587: iconst_4
    //   588: aload 12
    //   590: invokevirtual 417	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   593: invokestatic 423	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   596: ldc_w 576
    //   599: invokestatic 412	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   602: lconst_0
    //   603: lreturn
    //   604: astore 15
    //   606: aconst_null
    //   607: astore 14
    //   609: aload 12
    //   611: astore 16
    //   613: goto -122 -> 491
    //   616: astore 15
    //   618: lload 4
    //   620: lstore_0
    //   621: aload 13
    //   623: astore 14
    //   625: aload 12
    //   627: astore 16
    //   629: goto -138 -> 491
    //   632: astore 15
    //   634: aconst_null
    //   635: astore 14
    //   637: aload 12
    //   639: astore 16
    //   641: goto -221 -> 420
    //   644: astore 15
    //   646: lload 6
    //   648: lstore_0
    //   649: aload 13
    //   651: astore 14
    //   653: aload 12
    //   655: astore 16
    //   657: goto -237 -> 420
    //   660: astore 15
    //   662: aconst_null
    //   663: astore 14
    //   665: aload 12
    //   667: astore 16
    //   669: goto -320 -> 349
    //   672: astore 15
    //   674: lload 8
    //   676: lstore_0
    //   677: aload 13
    //   679: astore 14
    //   681: aload 12
    //   683: astore 16
    //   685: goto -336 -> 349
    //   688: astore 15
    //   690: aconst_null
    //   691: astore 14
    //   693: aload 12
    //   695: astore 16
    //   697: goto -419 -> 278
    //   700: astore 15
    //   702: lload 10
    //   704: lstore_0
    //   705: aload 13
    //   707: astore 14
    //   709: aload 12
    //   711: astore 16
    //   713: goto -435 -> 278
    // Local variable table:
    //   start	length	slot	name	signature
    //   17	688	0	l1	long
    //   178	354	2	l2	long
    //   64	555	4	l3	long
    //   67	580	6	l4	long
    //   70	605	8	l5	long
    //   73	630	10	l6	long
    //   50	72	12	localInputStreamReader	java.io.InputStreamReader
    //   139	95	12	localObject1	Object
    //   251	4	12	localObject2	Object
    //   280	1	12	localObject3	Object
    //   322	4	12	localObject4	Object
    //   351	1	12	localObject5	Object
    //   393	4	12	localObject6	Object
    //   422	1	12	localObject7	Object
    //   464	4	12	localObject8	Object
    //   493	1	12	localObject9	Object
    //   535	37	12	localObject10	Object
    //   585	125	12	localObject11	Object
    //   61	645	13	localObject12	Object
    //   80	446	14	str	String
    //   554	29	14	localObject13	Object
    //   607	101	14	localObject14	Object
    //   270	18	15	localFileNotFoundException1	java.io.FileNotFoundException
    //   341	18	15	localIOException1	IOException
    //   412	18	15	localException1	Exception
    //   483	18	15	localObject15	Object
    //   604	1	15	localObject16	Object
    //   616	1	15	localObject17	Object
    //   632	1	15	localException2	Exception
    //   644	1	15	localException3	Exception
    //   660	1	15	localIOException2	IOException
    //   672	1	15	localIOException3	IOException
    //   688	1	15	localFileNotFoundException2	java.io.FileNotFoundException
    //   700	1	15	localFileNotFoundException3	java.io.FileNotFoundException
    //   276	436	16	localObject18	Object
    // Exception table:
    //   from	to	target	type
    //   121	131	139	finally
    //   233	243	251	finally
    //   30	52	270	java/io/FileNotFoundException
    //   300	305	322	finally
    //   312	317	322	finally
    //   30	52	341	java/io/IOException
    //   371	376	393	finally
    //   383	388	393	finally
    //   30	52	412	java/lang/Exception
    //   442	447	464	finally
    //   454	459	464	finally
    //   30	52	483	finally
    //   513	518	535	finally
    //   525	530	535	finally
    //   286	295	554	finally
    //   357	366	554	finally
    //   428	437	554	finally
    //   499	508	554	finally
    //   561	566	585	finally
    //   571	576	585	finally
    //   52	63	604	finally
    //   75	82	616	finally
    //   99	104	616	finally
    //   116	121	616	finally
    //   170	177	616	finally
    //   191	199	616	finally
    //   211	217	616	finally
    //   229	233	616	finally
    //   52	63	632	java/lang/Exception
    //   75	82	644	java/lang/Exception
    //   99	104	644	java/lang/Exception
    //   116	121	644	java/lang/Exception
    //   170	177	644	java/lang/Exception
    //   191	199	644	java/lang/Exception
    //   211	217	644	java/lang/Exception
    //   229	233	644	java/lang/Exception
    //   52	63	660	java/io/IOException
    //   75	82	672	java/io/IOException
    //   99	104	672	java/io/IOException
    //   116	121	672	java/io/IOException
    //   170	177	672	java/io/IOException
    //   191	199	672	java/io/IOException
    //   211	217	672	java/io/IOException
    //   229	233	672	java/io/IOException
    //   52	63	688	java/io/FileNotFoundException
    //   75	82	700	java/io/FileNotFoundException
    //   99	104	700	java/io/FileNotFoundException
    //   116	121	700	java/io/FileNotFoundException
    //   170	177	700	java/io/FileNotFoundException
    //   191	199	700	java/io/FileNotFoundException
    //   211	217	700	java/io/FileNotFoundException
    //   229	233	700	java/io/FileNotFoundException
  }
  
  public static String getDeviceID(Context paramContext)
  {
    AppMethodBeat.i(227948);
    if (!TextUtils.isEmpty(deviceID))
    {
      paramContext = deviceID;
      AppMethodBeat.o(227948);
      return paramContext;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(227948);
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
      AppMethodBeat.o(227948);
      return paramContext;
    }
    finally
    {
      for (;;)
      {
        deviceID = "NONE";
      }
    }
  }
  
  public static String getDeviceIMEI(Context paramContext)
  {
    AppMethodBeat.i(227914);
    if (!TextUtils.isEmpty(deviceIMEI))
    {
      paramContext = deviceIMEI;
      AppMethodBeat.o(227914);
      return paramContext;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(227914);
      return "";
    }
    if (!checkPermission(paramContext, "android.permission.READ_PHONE_STATE"))
    {
      deviceIMEI = "NONE";
      AppMethodBeat.o(227914);
      return "NONE";
    }
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext != null)
      {
        paramContext = (String)a.a(paramContext, "com/tencent/thumbplayer/core/common/TPSystemInfo", "getDeviceIMEI", "(Landroid/content/Context;)Ljava/lang/String;", "android/telephony/TelephonyManager", "getDeviceId", "()Ljava/lang/String;");
        deviceIMEI = paramContext;
        if (TextUtils.isEmpty(paramContext)) {
          deviceIMEI = "NONE";
        }
        paramContext = deviceIMEI;
        AppMethodBeat.o(227914);
        return paramContext;
      }
    }
    finally
    {
      deviceIMEI = "NONE";
      AppMethodBeat.o(227914);
    }
    return "NONE";
  }
  
  public static String getDeviceIMSI(Context paramContext)
  {
    AppMethodBeat.i(227931);
    if (!TextUtils.isEmpty(deviceIMSI))
    {
      paramContext = deviceIMSI;
      AppMethodBeat.o(227931);
      return paramContext;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(227931);
      return "";
    }
    if (!checkPermission(paramContext, "android.permission.READ_PHONE_STATE"))
    {
      deviceIMSI = "NONE";
      AppMethodBeat.o(227931);
      return "NONE";
    }
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext != null)
      {
        paramContext = (String)a.a(paramContext, "com/tencent/thumbplayer/core/common/TPSystemInfo", "getDeviceIMSI", "(Landroid/content/Context;)Ljava/lang/String;", "android/telephony/TelephonyManager", "getSubscriberId", "()Ljava/lang/String;");
        deviceIMSI = paramContext;
        if (paramContext == null) {
          deviceIMSI = "";
        }
        paramContext = deviceIMSI;
      }
    }
    finally
    {
      AppMethodBeat.o(227931);
      return "";
    }
    AppMethodBeat.o(227931);
    return "";
  }
  
  public static String getDeviceMacAddr(Context paramContext)
  {
    AppMethodBeat.i(227962);
    if (!TextUtils.isEmpty(deviceMacAddr))
    {
      paramContext = deviceMacAddr;
      AppMethodBeat.o(227962);
      return paramContext;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(227962);
      return "";
    }
    paramContext = _getDeviceMacAddr(paramContext);
    deviceMacAddr = paramContext;
    if (TextUtils.isEmpty(paramContext)) {
      deviceMacAddr = "NONE";
    }
    paramContext = deviceMacAddr;
    AppMethodBeat.o(227962);
    return paramContext;
  }
  
  public static String getDeviceName()
  {
    return Build.MODEL;
  }
  
  private static String getLowerMarshmallowDeviceMacAddr(Context paramContext)
  {
    AppMethodBeat.i(227997);
    try
    {
      paramContext = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
      if (paramContext == null)
      {
        AppMethodBeat.o(227997);
        return "";
      }
      paramContext = (WifiInfo)a.a(paramContext, "com/tencent/thumbplayer/core/common/TPSystemInfo", "getLowerMarshmallowDeviceMacAddr", "(Landroid/content/Context;)Ljava/lang/String;", "android/net/wifi/WifiManager", "getConnectionInfo", "()Landroid/net/wifi/WifiInfo;");
      if (paramContext != null)
      {
        paramContext = paramContext.getMacAddress();
        AppMethodBeat.o(227997);
        return paramContext;
      }
    }
    finally
    {
      TPNativeLog.printLog(4, paramContext.getMessage());
      AppMethodBeat.o(227997);
    }
    return "";
  }
  
  /* Error */
  public static long getMaxCpuFreq()
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_2
    //   2: ldc_w 675
    //   5: invokestatic 356	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc2_w 330
    //   11: getstatic 333	com/tencent/thumbplayer/core/common/TPSystemInfo:maxCpuFreq	J
    //   14: lcmp
    //   15: ifeq +15 -> 30
    //   18: getstatic 333	com/tencent/thumbplayer/core/common/TPSystemInfo:maxCpuFreq	J
    //   21: lstore_0
    //   22: ldc_w 675
    //   25: invokestatic 412	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: lload_0
    //   29: lreturn
    //   30: new 543	java/io/InputStreamReader
    //   33: dup
    //   34: new 545	java/io/FileInputStream
    //   37: dup
    //   38: ldc_w 677
    //   41: invokespecial 548	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   44: ldc_w 550
    //   47: invokespecial 553	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   50: astore 5
    //   52: new 555	java/io/BufferedReader
    //   55: dup
    //   56: aload 5
    //   58: invokespecial 558	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   61: astore 4
    //   63: aload 4
    //   65: invokevirtual 561	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   68: astore 6
    //   70: aload 6
    //   72: ifnonnull +45 -> 117
    //   75: aload 5
    //   77: invokevirtual 569	java/io/InputStreamReader:close	()V
    //   80: aload 4
    //   82: invokevirtual 570	java/io/BufferedReader:close	()V
    //   85: aload 5
    //   87: invokevirtual 569	java/io/InputStreamReader:close	()V
    //   90: aload 4
    //   92: invokevirtual 570	java/io/BufferedReader:close	()V
    //   95: ldc_w 675
    //   98: invokestatic 412	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   101: lconst_0
    //   102: lreturn
    //   103: astore 4
    //   105: iconst_4
    //   106: aload 4
    //   108: invokevirtual 571	java/io/IOException:getMessage	()Ljava/lang/String;
    //   111: invokestatic 423	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   114: goto -19 -> 95
    //   117: aload 6
    //   119: invokevirtual 583	java/lang/String:trim	()Ljava/lang/String;
    //   122: astore 6
    //   124: lload_2
    //   125: lstore_0
    //   126: aload 6
    //   128: invokevirtual 387	java/lang/String:length	()I
    //   131: ifle +9 -> 140
    //   134: aload 6
    //   136: invokestatic 589	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   139: lstore_0
    //   140: aload 5
    //   142: invokevirtual 569	java/io/InputStreamReader:close	()V
    //   145: aload 4
    //   147: invokevirtual 570	java/io/BufferedReader:close	()V
    //   150: lload_0
    //   151: putstatic 333	com/tencent/thumbplayer/core/common/TPSystemInfo:maxCpuFreq	J
    //   154: iconst_2
    //   155: new 376	java/lang/StringBuilder
    //   158: dup
    //   159: ldc_w 679
    //   162: invokespecial 491	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   165: getstatic 333	com/tencent/thumbplayer/core/common/TPSystemInfo:maxCpuFreq	J
    //   168: invokevirtual 682	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   171: invokevirtual 406	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 423	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   177: ldc_w 675
    //   180: invokestatic 412	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   183: lload_0
    //   184: lreturn
    //   185: astore 4
    //   187: iconst_4
    //   188: aload 4
    //   190: invokevirtual 571	java/io/IOException:getMessage	()Ljava/lang/String;
    //   193: invokestatic 423	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   196: goto -46 -> 150
    //   199: astore 4
    //   201: aconst_null
    //   202: astore 4
    //   204: aconst_null
    //   205: astore 5
    //   207: aload 5
    //   209: ifnull +8 -> 217
    //   212: aload 5
    //   214: invokevirtual 569	java/io/InputStreamReader:close	()V
    //   217: lload_2
    //   218: lstore_0
    //   219: aload 4
    //   221: ifnull -71 -> 150
    //   224: aload 4
    //   226: invokevirtual 570	java/io/BufferedReader:close	()V
    //   229: lload_2
    //   230: lstore_0
    //   231: goto -81 -> 150
    //   234: astore 4
    //   236: iconst_4
    //   237: aload 4
    //   239: invokevirtual 571	java/io/IOException:getMessage	()Ljava/lang/String;
    //   242: invokestatic 423	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   245: lload_2
    //   246: lstore_0
    //   247: goto -97 -> 150
    //   250: astore 4
    //   252: aconst_null
    //   253: astore 4
    //   255: aconst_null
    //   256: astore 5
    //   258: aload 5
    //   260: ifnull +8 -> 268
    //   263: aload 5
    //   265: invokevirtual 569	java/io/InputStreamReader:close	()V
    //   268: lload_2
    //   269: lstore_0
    //   270: aload 4
    //   272: ifnull -122 -> 150
    //   275: aload 4
    //   277: invokevirtual 570	java/io/BufferedReader:close	()V
    //   280: lload_2
    //   281: lstore_0
    //   282: goto -132 -> 150
    //   285: astore 4
    //   287: iconst_4
    //   288: aload 4
    //   290: invokevirtual 571	java/io/IOException:getMessage	()Ljava/lang/String;
    //   293: invokestatic 423	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   296: lload_2
    //   297: lstore_0
    //   298: goto -148 -> 150
    //   301: astore 4
    //   303: aconst_null
    //   304: astore 4
    //   306: goto -48 -> 258
    //   309: astore 6
    //   311: goto -53 -> 258
    //   314: astore 4
    //   316: aconst_null
    //   317: astore 4
    //   319: goto -112 -> 207
    //   322: astore 6
    //   324: goto -117 -> 207
    // Local variable table:
    //   start	length	slot	name	signature
    //   21	277	0	l1	long
    //   1	296	2	l2	long
    //   61	30	4	localBufferedReader	java.io.BufferedReader
    //   103	43	4	localIOException1	IOException
    //   185	4	4	localIOException2	IOException
    //   199	1	4	localIOException3	IOException
    //   202	23	4	localObject1	Object
    //   234	4	4	localIOException4	IOException
    //   250	1	4	localObject2	Object
    //   253	23	4	localObject3	Object
    //   285	4	4	localIOException5	IOException
    //   301	1	4	localObject4	Object
    //   304	1	4	localObject5	Object
    //   314	1	4	localIOException6	IOException
    //   317	1	4	localObject6	Object
    //   50	214	5	localInputStreamReader	java.io.InputStreamReader
    //   68	67	6	str	String
    //   309	1	6	localObject7	Object
    //   322	1	6	localIOException7	IOException
    // Exception table:
    //   from	to	target	type
    //   85	95	103	java/io/IOException
    //   140	150	185	java/io/IOException
    //   30	52	199	java/io/IOException
    //   212	217	234	java/io/IOException
    //   224	229	234	java/io/IOException
    //   30	52	250	finally
    //   263	268	285	java/io/IOException
    //   275	280	285	java/io/IOException
    //   52	63	301	finally
    //   63	70	309	finally
    //   75	85	309	finally
    //   117	124	309	finally
    //   126	140	309	finally
    //   52	63	314	java/io/IOException
    //   63	70	322	java/io/IOException
    //   75	85	322	java/io/IOException
    //   117	124	322	java/io/IOException
    //   126	140	322	java/io/IOException
  }
  
  public static int getNumCores()
  {
    AppMethodBeat.i(227810);
    int i;
    if (-1 != numOfCores)
    {
      i = numOfCores;
      AppMethodBeat.o(227810);
      return i;
    }
    try
    {
      File[] arrayOfFile = new File("/sys/devices/system/cpu/").listFiles(new TPSystemInfo.1CpuFilter());
      if (arrayOfFile == null)
      {
        numOfCores = 1;
        AppMethodBeat.o(227810);
        return 1;
      }
      numOfCores = arrayOfFile.length;
      TPNativeLog.printLog(2, "core num " + numOfCores);
      i = numOfCores;
      AppMethodBeat.o(227810);
      return i;
    }
    catch (Exception localException)
    {
      TPNativeLog.printLog(4, localException.getMessage());
      numOfCores = 1;
      AppMethodBeat.o(227810);
    }
    return 1;
  }
  
  public static int getOpenGLSupportVersion(Context paramContext)
  {
    AppMethodBeat.i(228147);
    if (mOpenGLVersion == 0) {}
    try
    {
      paramContext = (ActivityManager)paramContext.getApplicationContext().getSystemService("activity");
      if (paramContext == null)
      {
        i = mOpenGLVersion;
        AppMethodBeat.o(228147);
        return i;
      }
      mOpenGLVersion = paramContext.getDeviceConfigurationInfo().reqGlEsVersion;
    }
    finally
    {
      for (;;)
      {
        int i;
        TPNativeLog.printLog(4, paramContext.getMessage());
      }
    }
    i = mOpenGLVersion;
    AppMethodBeat.o(228147);
    return i;
  }
  
  public static String getOsVersion()
  {
    return Build.VERSION.RELEASE;
  }
  
  public static int getScreenHeight(Context paramContext)
  {
    AppMethodBeat.i(228065);
    if (paramContext == null)
    {
      AppMethodBeat.o(228065);
      return 0;
    }
    int i;
    if (mScreenHeight != 0)
    {
      i = mScreenHeight;
      AppMethodBeat.o(228065);
      return i;
    }
    try
    {
      mScreenHeight = paramContext.getResources().getDisplayMetrics().heightPixels;
      i = mScreenHeight;
      AppMethodBeat.o(228065);
      return i;
    }
    finally
    {
      for (;;)
      {
        mScreenHeight = 0;
      }
    }
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    AppMethodBeat.i(228055);
    if (paramContext == null)
    {
      AppMethodBeat.o(228055);
      return 0;
    }
    int i;
    if (mScreenWidth != 0)
    {
      i = mScreenWidth;
      AppMethodBeat.o(228055);
      return i;
    }
    try
    {
      mScreenWidth = paramContext.getResources().getDisplayMetrics().widthPixels;
      i = mScreenWidth;
      AppMethodBeat.o(228055);
      return i;
    }
    finally
    {
      for (;;)
      {
        mScreenWidth = 0;
      }
    }
  }
  
  public static int getSystemCpuUsage(String paramString1, String paramString2)
  {
    AppMethodBeat.i(228118);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(228118);
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
        TPNativeLog.printLog(4, paramString1.getMessage());
        float f1 = -1.0F;
      }
    }
    i = (int)f1;
    AppMethodBeat.o(228118);
    return i;
  }
  
  public static long getSystemIdleTime(String[] paramArrayOfString)
  {
    AppMethodBeat.i(228138);
    try
    {
      long l = Long.parseLong(paramArrayOfString[4]);
      return l;
    }
    finally
    {
      AppMethodBeat.o(228138);
    }
    return -1L;
  }
  
  /* Error */
  public static long getSystemUptime(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: ldc_w 764
    //   3: invokestatic 356	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: lconst_0
    //   7: lstore_2
    //   8: iconst_1
    //   9: istore_1
    //   10: iload_1
    //   11: aload_0
    //   12: arraylength
    //   13: if_icmpge +46 -> 59
    //   16: lload_2
    //   17: lstore 4
    //   19: iconst_4
    //   20: iload_1
    //   21: if_icmpeq +17 -> 38
    //   24: aload_0
    //   25: iload_1
    //   26: aaload
    //   27: invokestatic 589	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   30: lstore 4
    //   32: lload_2
    //   33: lload 4
    //   35: ladd
    //   36: lstore 4
    //   38: iload_1
    //   39: iconst_1
    //   40: iadd
    //   41: istore_1
    //   42: lload 4
    //   44: lstore_2
    //   45: goto -35 -> 10
    //   48: astore_0
    //   49: ldc_w 764
    //   52: invokestatic 412	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: ldc2_w 330
    //   58: lreturn
    //   59: ldc_w 764
    //   62: invokestatic 412	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: lload_2
    //   66: lreturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	paramArrayOfString	String[]
    //   9	33	1	i	int
    //   7	59	2	l1	long
    //   17	26	4	l2	long
    // Exception table:
    //   from	to	target	type
    //   24	32	48	finally
  }
  
  private static String getWlanName()
  {
    AppMethodBeat.i(228026);
    try
    {
      if (getWlanMethod == null) {
        getWlanMethod = Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class, String.class });
      }
      str1 = (String)getWlanMethod.invoke(null, new Object[] { "wifi.interface", "wlan0" });
    }
    finally
    {
      for (;;)
      {
        String str1;
        TPNativeLog.printLog(4, localObject.getMessage());
        String str2 = "wlan0";
      }
    }
    AppMethodBeat.o(228026);
    return str1;
  }
  
  private static boolean hasMarshmallow()
  {
    return Build.VERSION.SDK_INT >= 23;
  }
  
  public static void initAudioBestSettings(Context paramContext)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(228183);
        if ((paramContext != null) && (mAudioBestSampleRate <= 0)) {
          continue;
        }
        AppMethodBeat.o(228183);
      }
      finally
      {
        try
        {
          Object localObject;
          mAudioBestSampleRate = Integer.parseInt(paramContext);
          mAudioBestFramesPerBust = Integer.parseInt((String)localObject);
          AppMethodBeat.o(228183);
        }
        catch (NumberFormatException paramContext)
        {
          TPNativeLog.printLog(4, paramContext.getMessage());
        }
        paramContext = finally;
      }
      return;
      if (Build.VERSION.SDK_INT >= 17)
      {
        localObject = (AudioManager)paramContext.getSystemService("audio");
        paramContext = ((AudioManager)localObject).getProperty("android.media.property.OUTPUT_SAMPLE_RATE");
        localObject = ((AudioManager)localObject).getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER");
      }
      AppMethodBeat.o(228183);
    }
  }
  
  public static boolean isARMV5Whitelist()
  {
    AppMethodBeat.i(227853);
    if ((getDeviceName().equals("XT882")) || (getDeviceName().equals("ME860")) || (getDeviceName().equals("MB860")) || (getDeviceName().equals("Lenovo P70")) || (getDeviceName().equals("Lenovo A60")) || (getDeviceName().equals("Lenovo A366t")))
    {
      AppMethodBeat.o(227853);
      return true;
    }
    AppMethodBeat.o(227853);
    return false;
  }
  
  private static void parseCpuInfoLine(String paramString)
  {
    AppMethodBeat.i(227733);
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
      AppMethodBeat.o(227733);
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
            AppMethodBeat.o(227733);
            return;
          }
          if (paramString.length() > 1) {
            mCpuArchitecture = (int)Long.parseLong(paramString.substring(0, 1));
          }
        }
        AppMethodBeat.o(227733);
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
        AppMethodBeat.o(227733);
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
    AppMethodBeat.o(227733);
  }
  
  /* Error */
  private static String readStringFromFile(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: ldc_w 861
    //   8: invokestatic 356	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: new 555	java/io/BufferedReader
    //   14: dup
    //   15: new 863	java/io/FileReader
    //   18: dup
    //   19: aload_0
    //   20: invokespecial 866	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   23: invokespecial 558	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   26: astore_2
    //   27: aload 4
    //   29: astore_1
    //   30: aload_0
    //   31: invokevirtual 868	java/io/File:length	()J
    //   34: ldc2_w 869
    //   37: lcmp
    //   38: ifgt +40 -> 78
    //   41: aload_0
    //   42: invokevirtual 868	java/io/File:length	()J
    //   45: l2i
    //   46: newarray char
    //   48: astore 5
    //   50: aload 4
    //   52: astore_1
    //   53: aload_2
    //   54: aload 5
    //   56: iconst_0
    //   57: aload_0
    //   58: invokevirtual 868	java/io/File:length	()J
    //   61: l2i
    //   62: invokevirtual 874	java/io/BufferedReader:read	([CII)I
    //   65: ifle +13 -> 78
    //   68: new 79	java/lang/String
    //   71: dup
    //   72: aload 5
    //   74: invokespecial 877	java/lang/String:<init>	([C)V
    //   77: astore_1
    //   78: aload_2
    //   79: invokevirtual 570	java/io/BufferedReader:close	()V
    //   82: ldc_w 861
    //   85: invokestatic 412	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   88: aload_1
    //   89: areturn
    //   90: astore_0
    //   91: aconst_null
    //   92: astore_2
    //   93: ldc_w 861
    //   96: invokestatic 412	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: aload_0
    //   100: athrow
    //   101: astore_0
    //   102: aload_2
    //   103: ifnull +7 -> 110
    //   106: aload_2
    //   107: invokevirtual 570	java/io/BufferedReader:close	()V
    //   110: ldc_w 861
    //   113: invokestatic 412	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   116: aload_0
    //   117: athrow
    //   118: astore_0
    //   119: aconst_null
    //   120: astore_2
    //   121: aload_3
    //   122: astore_1
    //   123: aload_2
    //   124: ifnull -42 -> 82
    //   127: aload_2
    //   128: invokevirtual 570	java/io/BufferedReader:close	()V
    //   131: aload_3
    //   132: astore_1
    //   133: goto -51 -> 82
    //   136: astore_0
    //   137: aload_3
    //   138: astore_1
    //   139: goto -57 -> 82
    //   142: astore_0
    //   143: goto -61 -> 82
    //   146: astore_1
    //   147: goto -37 -> 110
    //   150: astore_0
    //   151: goto -30 -> 121
    //   154: astore_0
    //   155: goto -62 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	paramFile	File
    //   29	110	1	localObject1	Object
    //   146	1	1	localObject2	Object
    //   26	102	2	localBufferedReader	java.io.BufferedReader
    //   1	137	3	localObject3	Object
    //   3	48	4	localObject4	Object
    //   48	25	5	arrayOfChar	char[]
    // Exception table:
    //   from	to	target	type
    //   11	27	90	java/io/FileNotFoundException
    //   93	101	101	finally
    //   11	27	118	finally
    //   127	131	136	finally
    //   78	82	142	finally
    //   106	110	146	finally
    //   30	50	150	finally
    //   53	78	150	finally
    //   30	50	154	java/io/FileNotFoundException
    //   53	78	154	java/io/FileNotFoundException
  }
  
  /* Error */
  public static String readSystemStat()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc_w 879
    //   5: invokestatic 356	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 881	java/io/RandomAccessFile
    //   11: dup
    //   12: ldc_w 883
    //   15: ldc_w 885
    //   18: invokespecial 888	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: astore_1
    //   22: aload_1
    //   23: invokevirtual 889	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
    //   26: astore_0
    //   27: aload_1
    //   28: invokevirtual 890	java/io/RandomAccessFile:close	()V
    //   31: ldc_w 879
    //   34: invokestatic 412	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: aload_0
    //   38: areturn
    //   39: astore_1
    //   40: iconst_4
    //   41: aload_1
    //   42: invokevirtual 417	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   45: invokestatic 423	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   48: goto -17 -> 31
    //   51: astore_0
    //   52: aconst_null
    //   53: astore_1
    //   54: aload_2
    //   55: astore_0
    //   56: aload_1
    //   57: ifnull -26 -> 31
    //   60: aload_1
    //   61: invokevirtual 890	java/io/RandomAccessFile:close	()V
    //   64: aload_2
    //   65: astore_0
    //   66: goto -35 -> 31
    //   69: astore_0
    //   70: iconst_4
    //   71: aload_0
    //   72: invokevirtual 417	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   75: invokestatic 423	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   78: aload_2
    //   79: astore_0
    //   80: goto -49 -> 31
    //   83: astore_0
    //   84: goto -30 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   26	12	0	str	String
    //   51	1	0	localObject1	Object
    //   55	11	0	localObject2	Object
    //   69	3	0	localObject3	Object
    //   79	1	0	localObject4	Object
    //   83	1	0	localObject5	Object
    //   21	7	1	localRandomAccessFile	java.io.RandomAccessFile
    //   39	3	1	localObject6	Object
    //   53	8	1	localObject7	Object
    //   1	78	2	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   27	31	39	finally
    //   8	22	51	finally
    //   60	64	69	finally
    //   22	27	83	finally
  }
  
  public static boolean supportInDeviceDolbyAudioEffect()
  {
    AppMethodBeat.i(228168);
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
    AppMethodBeat.o(228168);
    return bool2;
  }
  
  private static void writeStringToFile(String paramString1, String paramString2)
  {
    AppMethodBeat.i(228083);
    Object localObject = null;
    try
    {
      paramString1 = new File(paramString1);
      if (!paramString1.exists())
      {
        boolean bool = paramString1.createNewFile();
        if (bool)
        {
          AppMethodBeat.o(228083);
          return;
        }
      }
      paramString1 = new FileWriter(paramString1, false);
      if (paramString1 == null) {
        break label89;
      }
    }
    finally
    {
      try
      {
        paramString1.write(paramString2);
        paramString1.flush();
        paramString1.close();
        AppMethodBeat.o(228083);
        return;
      }
      finally
      {
        break label73;
      }
      paramString1 = finally;
      paramString1 = localObject;
    }
    try
    {
      label73:
      paramString1.close();
      AppMethodBeat.o(228083);
      return;
    }
    catch (IOException paramString1) {}
    label89:
    AppMethodBeat.o(228083);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPSystemInfo
 * JD-Core Version:    0.7.0.1
 */