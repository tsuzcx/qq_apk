import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.feedback.eup.CrashHandleListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.GifSoLoader;
import com.tencent.mobileqq.util.WebpSoLoader;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class ahrx
  implements CrashHandleListener
{
  public ahrx(StatisticCollector paramStatisticCollector) {}
  
  public byte[] getCrashExtraData(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong)
  {
    return null;
  }
  
  /* Error */
  public String getCrashExtraMessage(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong)
  {
    // Byte code:
    //   0: ldc 26
    //   2: iconst_1
    //   3: new 28	java/lang/StringBuilder
    //   6: dup
    //   7: ldc 30
    //   9: invokespecial 33	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   12: iload_1
    //   13: invokevirtual 37	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   16: ldc 39
    //   18: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_2
    //   22: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: ldc 44
    //   27: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_3
    //   31: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: ldc 46
    //   36: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload 4
    //   41: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: ldc 48
    //   46: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: iload 5
    //   51: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   54: ldc 53
    //   56: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: lload 6
    //   61: invokevirtual 56	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   64: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   70: getstatic 71	com/tencent/mobileqq/statistics/StatisticCollector:jdField_a_of_type_ComTencentMobileqqStatisticsStatisticCollector$StatisticCallback	Lcom/tencent/mobileqq/statistics/StatisticCollector$StatisticCallback;
    //   73: ifnull +41 -> 114
    //   76: iload_1
    //   77: ifne +37 -> 114
    //   80: ldc 73
    //   82: aload_2
    //   83: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   86: ifeq +28 -> 114
    //   89: aload_3
    //   90: invokestatic 85	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   93: ifne +21 -> 114
    //   96: aload_3
    //   97: ldc 87
    //   99: invokevirtual 90	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   102: ifeq +12 -> 114
    //   105: getstatic 71	com/tencent/mobileqq/statistics/StatisticCollector:jdField_a_of_type_ComTencentMobileqqStatisticsStatisticCollector$StatisticCallback	Lcom/tencent/mobileqq/statistics/StatisticCollector$StatisticCallback;
    //   108: aload_2
    //   109: invokeinterface 94 2 0
    //   114: getstatic 100	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   117: ldc 102
    //   119: invokevirtual 106	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   122: ifeq +30 -> 152
    //   125: new 28	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   132: ldc 109
    //   134: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload_2
    //   138: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload 4
    //   143: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 112	com/tencent/mobileqq/activity/qwallet/utils/QWalletCrashUtils:a	(Ljava/lang/String;)V
    //   152: aconst_null
    //   153: astore 11
    //   155: new 114	java/io/File
    //   158: dup
    //   159: ldc 116
    //   161: invokespecial 117	java/io/File:<init>	(Ljava/lang/String;)V
    //   164: astore 10
    //   166: aload 10
    //   168: ifnull +17 -> 185
    //   171: aload 10
    //   173: invokevirtual 121	java/io/File:exists	()Z
    //   176: ifne +9 -> 185
    //   179: aload 10
    //   181: invokevirtual 124	java/io/File:mkdirs	()Z
    //   184: pop
    //   185: new 126	java/io/FileWriter
    //   188: dup
    //   189: new 28	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   196: ldc 116
    //   198: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: lload 6
    //   203: invokevirtual 56	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   206: ldc 128
    //   208: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokespecial 129	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   217: astore 10
    //   219: new 28	java/lang/StringBuilder
    //   222: dup
    //   223: sipush 128
    //   226: invokespecial 132	java/lang/StringBuilder:<init>	(I)V
    //   229: astore 11
    //   231: aload 11
    //   233: invokestatic 135	com/tencent/mobileqq/statistics/StatisticCollector:a	()Ljava/text/SimpleDateFormat;
    //   236: new 137	java/util/Date
    //   239: dup
    //   240: lload 6
    //   242: invokespecial 140	java/util/Date:<init>	(J)V
    //   245: invokevirtual 146	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   248: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: ldc 148
    //   253: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: aload_2
    //   257: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: ldc 148
    //   262: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: aload 4
    //   267: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload 10
    //   273: aload 11
    //   275: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: invokevirtual 151	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   281: aload 10
    //   283: invokevirtual 154	java/io/FileWriter:flush	()V
    //   286: aload 10
    //   288: ifnull +8 -> 296
    //   291: aload 10
    //   293: invokevirtual 157	java/io/FileWriter:close	()V
    //   296: aload_2
    //   297: invokestatic 85	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   300: ifne +44 -> 344
    //   303: aload_2
    //   304: ldc 159
    //   306: invokevirtual 90	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   309: ifeq +35 -> 344
    //   312: invokestatic 164	com/tencent/mobileqq/app/MemoryManager:a	()Lcom/tencent/mobileqq/app/MemoryManager;
    //   315: invokevirtual 166	com/tencent/mobileqq/app/MemoryManager:a	()V
    //   318: aload 4
    //   320: ldc 168
    //   322: invokevirtual 90	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   325: ifne +19 -> 344
    //   328: aload 4
    //   330: ldc 170
    //   332: invokevirtual 90	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   335: ifne +9 -> 344
    //   338: invokestatic 175	com/tencent/common/cache/MemoryClearManagerNew:a	()Lcom/tencent/common/cache/MemoryClearManagerNew;
    //   341: invokevirtual 178	com/tencent/common/cache/MemoryClearManagerNew:b	()V
    //   344: getstatic 100	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   347: astore 12
    //   349: iload_1
    //   350: ifeq +36 -> 386
    //   353: aload 12
    //   355: ldc 180
    //   357: invokevirtual 106	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   360: ifne +13 -> 373
    //   363: aload 12
    //   365: ldc 182
    //   367: invokevirtual 106	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   370: ifeq +16 -> 386
    //   373: ldc 184
    //   375: iconst_1
    //   376: aload 4
    //   378: invokestatic 187	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   381: aload 4
    //   383: invokestatic 192	cooperation/qzone/QZoneCrashHandler:saveLastCrashInf	(Ljava/lang/String;)V
    //   386: invokestatic 195	com/tencent/mobileqq/statistics/StatisticCollector:a	()Landroid/content/Context;
    //   389: aload 12
    //   391: new 28	java/lang/StringBuilder
    //   394: dup
    //   395: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   398: aload_2
    //   399: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: aload_3
    //   403: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   409: invokestatic 200	com/tencent/hotpatch/PatchSecurityMode:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   412: invokestatic 195	com/tencent/mobileqq/statistics/StatisticCollector:a	()Landroid/content/Context;
    //   415: invokestatic 205	com/tencent/common/app/QFixApplicationImpl:b	(Landroid/content/Context;)V
    //   418: new 28	java/lang/StringBuilder
    //   421: dup
    //   422: sipush 128
    //   425: invokespecial 132	java/lang/StringBuilder:<init>	(I)V
    //   428: astore 11
    //   430: invokestatic 195	com/tencent/mobileqq/statistics/StatisticCollector:a	()Landroid/content/Context;
    //   433: ldc 207
    //   435: invokestatic 212	com/tencent/hotpatch/config/PatchConfigManager:a	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/hotpatch/config/BasePatchConfig;
    //   438: astore_3
    //   439: aload 11
    //   441: ldc 214
    //   443: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: pop
    //   447: aload 11
    //   449: ldc 216
    //   451: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: pop
    //   455: aload 11
    //   457: ldc 218
    //   459: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: getstatic 221	com/tencent/common/app/BaseApplicationImpl:sInjectResult	Ljava/lang/String;
    //   465: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: pop
    //   469: aload 11
    //   471: ldc 223
    //   473: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: getstatic 226	com/tencent/common/app/BaseApplicationImpl:sQQAppInterfaceEscapedMsg	Ljava/lang/String;
    //   479: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: pop
    //   483: aload 11
    //   485: ldc 228
    //   487: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: getstatic 231	com/tencent/common/app/BaseApplicationImpl:sSplashActivityEscapedMsg	Ljava/lang/String;
    //   493: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: pop
    //   497: aload 11
    //   499: ldc 233
    //   501: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: getstatic 236	com/tencent/common/app/BaseApplicationImpl:sImmersiveUtilsEscapedMsg	Ljava/lang/String;
    //   507: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: pop
    //   511: aload 11
    //   513: ldc 238
    //   515: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: getstatic 243	com/tencent/mobileqq/startup/director/StartupDirector:b	I
    //   521: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   524: pop
    //   525: aload 11
    //   527: ldc 245
    //   529: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: astore 10
    //   534: aload_3
    //   535: ifnull +984 -> 1519
    //   538: aload_3
    //   539: getfield 250	com/tencent/hotpatch/config/BasePatchConfig:jdField_a_of_type_Boolean	Z
    //   542: ifeq +977 -> 1519
    //   545: iconst_1
    //   546: istore 9
    //   548: aload 10
    //   550: iload 9
    //   552: invokevirtual 37	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   555: ldc 252
    //   557: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: getstatic 256	com/tencent/hotpatch/DexPatchInstaller:jdField_a_of_type_Int	I
    //   563: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   566: ldc_w 258
    //   569: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: getstatic 261	com/tencent/hotpatch/PatchResolveForDalvik:jdField_a_of_type_Int	I
    //   575: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   578: ldc_w 263
    //   581: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: getstatic 265	com/tencent/hotpatch/DexPatchInstaller:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   587: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: pop
    //   591: aload 11
    //   593: ldc_w 267
    //   596: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: invokestatic 273	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   602: invokevirtual 277	java/lang/Runtime:maxMemory	()J
    //   605: invokevirtual 56	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   608: ldc_w 279
    //   611: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: invokestatic 273	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   617: invokevirtual 282	java/lang/Runtime:totalMemory	()J
    //   620: invokestatic 273	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   623: invokevirtual 285	java/lang/Runtime:freeMemory	()J
    //   626: lsub
    //   627: invokevirtual 56	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   630: pop
    //   631: aload 11
    //   633: ldc_w 287
    //   636: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   639: invokestatic 164	com/tencent/mobileqq/app/MemoryManager:a	()Lcom/tencent/mobileqq/app/MemoryManager;
    //   642: invokevirtual 290	com/tencent/mobileqq/app/MemoryManager:a	()I
    //   645: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   648: ldc_w 292
    //   651: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: invokestatic 164	com/tencent/mobileqq/app/MemoryManager:a	()Lcom/tencent/mobileqq/app/MemoryManager;
    //   657: invokevirtual 294	com/tencent/mobileqq/app/MemoryManager:b	()I
    //   660: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   663: ldc_w 296
    //   666: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   669: invokestatic 164	com/tencent/mobileqq/app/MemoryManager:a	()Lcom/tencent/mobileqq/app/MemoryManager;
    //   672: invokevirtual 299	com/tencent/mobileqq/app/MemoryManager:c	()I
    //   675: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   678: pop
    //   679: getstatic 303	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   682: ifnull +21 -> 703
    //   685: aload 11
    //   687: ldc_w 305
    //   690: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: getstatic 303	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   696: invokevirtual 310	android/support/v4/util/MQLruCache:size	()I
    //   699: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   702: pop
    //   703: invokestatic 273	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   706: invokevirtual 277	java/lang/Runtime:maxMemory	()J
    //   709: invokestatic 273	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   712: invokevirtual 282	java/lang/Runtime:totalMemory	()J
    //   715: lsub
    //   716: l2f
    //   717: fconst_1
    //   718: fmul
    //   719: invokestatic 273	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   722: invokevirtual 277	java/lang/Runtime:maxMemory	()J
    //   725: l2f
    //   726: fdiv
    //   727: f2d
    //   728: ldc2_w 311
    //   731: dcmpl
    //   732: iflt +28 -> 760
    //   735: aload_2
    //   736: invokestatic 85	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   739: ifne +21 -> 760
    //   742: aload_2
    //   743: ldc 159
    //   745: invokevirtual 90	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   748: ifeq +12 -> 760
    //   751: aload_0
    //   752: getfield 12	ahrx:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   755: aload 11
    //   757: invokevirtual 315	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/StringBuilder;)V
    //   760: aload 11
    //   762: ldc_w 317
    //   765: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   768: getstatic 322	com/tencent/mqq/shared_file_accessor/SharedPreferencesProxyManager:sSystemSpExceptionMsg	Ljava/lang/String;
    //   771: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   774: pop
    //   775: getstatic 327	com/tencent/mobileqq/util/WebpSoLoader:a	[I
    //   778: astore_3
    //   779: aload_3
    //   780: ifnull +52 -> 832
    //   783: aload_3
    //   784: arraylength
    //   785: iconst_3
    //   786: if_icmplt +46 -> 832
    //   789: aload 11
    //   791: ldc_w 329
    //   794: iconst_3
    //   795: anewarray 4	java/lang/Object
    //   798: dup
    //   799: iconst_0
    //   800: aload_3
    //   801: iconst_0
    //   802: iaload
    //   803: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   806: aastore
    //   807: dup
    //   808: iconst_1
    //   809: aload_3
    //   810: iconst_1
    //   811: iaload
    //   812: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   815: aastore
    //   816: dup
    //   817: iconst_2
    //   818: aload_3
    //   819: iconst_2
    //   820: iaload
    //   821: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   824: aastore
    //   825: invokestatic 338	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   828: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   831: pop
    //   832: aload 11
    //   834: ldc 148
    //   836: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   839: pop
    //   840: invokestatic 340	com/tencent/mobileqq/statistics/StatisticCollector:a	()Ljava/lang/String;
    //   843: astore 10
    //   845: invokestatic 345	com/tencent/mobileqq/utils/DeviceInfoUtil:a	()[J
    //   848: astore 13
    //   850: aload 11
    //   852: invokestatic 348	com/tencent/mobileqq/utils/DeviceInfoUtil:m	()Ljava/lang/String;
    //   855: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   858: ldc 148
    //   860: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   863: pop
    //   864: aload 10
    //   866: astore_3
    //   867: aload 10
    //   869: ifnonnull +7 -> 876
    //   872: ldc_w 350
    //   875: astore_3
    //   876: aload 11
    //   878: aload_3
    //   879: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   882: ldc 148
    //   884: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   887: pop
    //   888: aload 11
    //   890: ldc_w 352
    //   893: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   896: aload 13
    //   898: iconst_0
    //   899: laload
    //   900: invokevirtual 56	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   903: ldc_w 354
    //   906: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   909: aload 13
    //   911: iconst_1
    //   912: laload
    //   913: invokevirtual 56	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   916: ldc_w 356
    //   919: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   922: pop
    //   923: aload_0
    //   924: getfield 12	ahrx:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   927: invokestatic 359	com/tencent/mobileqq/statistics/StatisticCollector:a	(Lcom/tencent/mobileqq/statistics/StatisticCollector;)Ljava/lang/String;
    //   930: ifnonnull +595 -> 1525
    //   933: ldc_w 350
    //   936: astore_3
    //   937: aload 11
    //   939: aload_3
    //   940: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   943: ldc 148
    //   945: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   948: pop
    //   949: aload 11
    //   951: ldc_w 361
    //   954: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   957: getstatic 364	com/tencent/mobileqq/activity/SplashActivity:jdField_a_of_type_Int	I
    //   960: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   963: ldc 148
    //   965: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   968: pop
    //   969: getstatic 370	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   972: astore_3
    //   973: aload_3
    //   974: instanceof 363
    //   977: ifeq +29 -> 1006
    //   980: aload_3
    //   981: checkcast 363	com/tencent/mobileqq/activity/SplashActivity
    //   984: astore_3
    //   985: aload 11
    //   987: ldc_w 372
    //   990: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   993: aload_3
    //   994: invokevirtual 373	com/tencent/mobileqq/activity/SplashActivity:a	()I
    //   997: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1000: ldc 148
    //   1002: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1005: pop
    //   1006: aload 11
    //   1008: aload_0
    //   1009: getfield 12	ahrx:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1012: invokestatic 376	com/tencent/mobileqq/statistics/StatisticCollector:b	(Lcom/tencent/mobileqq/statistics/StatisticCollector;)Ljava/lang/StringBuilder;
    //   1015: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1018: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1021: pop
    //   1022: aload 11
    //   1024: aload_0
    //   1025: getfield 12	ahrx:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1028: invokestatic 378	com/tencent/mobileqq/statistics/StatisticCollector:a	(Lcom/tencent/mobileqq/statistics/StatisticCollector;)Ljava/lang/StringBuilder;
    //   1031: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1034: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1037: pop
    //   1038: getstatic 381	cooperation/qzone/QZoneCrashHandler:lastCrashedMeasuredText	Ljava/lang/String;
    //   1041: invokestatic 85	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1044: ifne +51 -> 1095
    //   1047: getstatic 386	android/os/Build$VERSION:SDK_INT	I
    //   1050: bipush 8
    //   1052: if_icmplt +43 -> 1095
    //   1055: aload 11
    //   1057: new 28	java/lang/StringBuilder
    //   1060: dup
    //   1061: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   1064: ldc_w 388
    //   1067: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1070: getstatic 381	cooperation/qzone/QZoneCrashHandler:lastCrashedMeasuredText	Ljava/lang/String;
    //   1073: invokevirtual 392	java/lang/String:getBytes	()[B
    //   1076: iconst_0
    //   1077: invokestatic 398	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   1080: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1083: ldc 148
    //   1085: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1088: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1091: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1094: pop
    //   1095: aload 11
    //   1097: invokestatic 403	cooperation/qzone/RDMEtraMsgCollector:a	()Lcooperation/qzone/RDMEtraMsgCollector;
    //   1100: invokevirtual 404	cooperation/qzone/RDMEtraMsgCollector:a	()Ljava/lang/String;
    //   1103: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1106: pop
    //   1107: aload 11
    //   1109: ldc 148
    //   1111: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1114: pop
    //   1115: aload_0
    //   1116: getfield 12	ahrx:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1119: invokestatic 407	com/tencent/mobileqq/statistics/StatisticCollector:a	(Lcom/tencent/mobileqq/statistics/StatisticCollector;)Ljava/util/LinkedList;
    //   1122: invokevirtual 410	java/util/LinkedList:size	()I
    //   1125: ifle +29 -> 1154
    //   1128: aload 11
    //   1130: aload_0
    //   1131: getfield 12	ahrx:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1134: invokestatic 407	com/tencent/mobileqq/statistics/StatisticCollector:a	(Lcom/tencent/mobileqq/statistics/StatisticCollector;)Ljava/util/LinkedList;
    //   1137: invokevirtual 414	java/util/LinkedList:removeLast	()Ljava/lang/Object;
    //   1140: checkcast 416	ahsa
    //   1143: invokevirtual 417	ahsa:toString	()Ljava/lang/String;
    //   1146: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1149: pop
    //   1150: goto -35 -> 1115
    //   1153: astore_3
    //   1154: invokestatic 195	com/tencent/mobileqq/statistics/StatisticCollector:a	()Landroid/content/Context;
    //   1157: invokestatic 423	com/tencent/smtt/sdk/WebView:getTbsSDKVersion	(Landroid/content/Context;)I
    //   1160: istore 5
    //   1162: invokestatic 195	com/tencent/mobileqq/statistics/StatisticCollector:a	()Landroid/content/Context;
    //   1165: invokestatic 428	com/tencent/smtt/sdk/QbSdk:getTbsVersion	(Landroid/content/Context;)I
    //   1168: istore 8
    //   1170: aload 11
    //   1172: bipush 10
    //   1174: invokevirtual 431	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1177: ldc_w 433
    //   1180: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1183: astore 10
    //   1185: iload 8
    //   1187: ifne +349 -> 1536
    //   1190: ldc_w 435
    //   1193: astore_3
    //   1194: aload 10
    //   1196: aload_3
    //   1197: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1200: ldc_w 437
    //   1203: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1206: iload 5
    //   1208: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1211: ldc_w 439
    //   1214: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1217: iload 8
    //   1219: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1222: pop
    //   1223: aload 11
    //   1225: ldc_w 441
    //   1228: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1231: invokestatic 195	com/tencent/mobileqq/statistics/StatisticCollector:a	()Landroid/content/Context;
    //   1234: invokestatic 444	com/tencent/smtt/sdk/WebView:getCrashExtraMessage	(Landroid/content/Context;)Ljava/lang/String;
    //   1237: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1240: pop
    //   1241: iload_1
    //   1242: ifeq +97 -> 1339
    //   1245: aload 12
    //   1247: ldc 180
    //   1249: invokevirtual 106	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1252: ifne +23 -> 1275
    //   1255: aload 12
    //   1257: ldc 182
    //   1259: invokevirtual 106	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1262: ifne +13 -> 1275
    //   1265: aload 12
    //   1267: ldc 102
    //   1269: invokevirtual 106	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1272: ifeq +67 -> 1339
    //   1275: invokestatic 195	com/tencent/mobileqq/statistics/StatisticCollector:a	()Landroid/content/Context;
    //   1278: ldc 26
    //   1280: iconst_4
    //   1281: invokevirtual 450	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1284: ldc_w 452
    //   1287: aconst_null
    //   1288: invokeinterface 458 3 0
    //   1293: astore_3
    //   1294: aload 11
    //   1296: ldc_w 460
    //   1299: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1302: aload_3
    //   1303: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1306: pop
    //   1307: invokestatic 463	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1310: ifeq +29 -> 1339
    //   1313: ldc 26
    //   1315: iconst_2
    //   1316: new 28	java/lang/StringBuilder
    //   1319: dup
    //   1320: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   1323: ldc_w 465
    //   1326: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1329: aload_3
    //   1330: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1333: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1336: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1339: aload 11
    //   1341: ldc_w 467
    //   1344: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1347: invokestatic 471	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1350: getfield 474	com/tencent/common/app/BaseApplicationImpl:startComponentInfo	Ljava/lang/String;
    //   1353: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1356: pop
    //   1357: invokestatic 471	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1360: getfield 478	com/tencent/common/app/BaseApplicationImpl:broadcastInfoQueue	Ljava/util/Queue;
    //   1363: ifnull +180 -> 1543
    //   1366: invokestatic 471	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1369: getfield 478	com/tencent/common/app/BaseApplicationImpl:broadcastInfoQueue	Ljava/util/Queue;
    //   1372: invokeinterface 482 1 0
    //   1377: ifne +166 -> 1543
    //   1380: invokestatic 471	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1383: getfield 478	com/tencent/common/app/BaseApplicationImpl:broadcastInfoQueue	Ljava/util/Queue;
    //   1386: invokeinterface 486 1 0
    //   1391: astore_3
    //   1392: aload_3
    //   1393: invokeinterface 491 1 0
    //   1398: ifeq +145 -> 1543
    //   1401: aload_3
    //   1402: invokeinterface 494 1 0
    //   1407: checkcast 496	android/util/Pair
    //   1410: astore 10
    //   1412: aload 10
    //   1414: ifnull -22 -> 1392
    //   1417: aload 11
    //   1419: ldc_w 498
    //   1422: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1425: invokestatic 135	com/tencent/mobileqq/statistics/StatisticCollector:a	()Ljava/text/SimpleDateFormat;
    //   1428: new 137	java/util/Date
    //   1431: dup
    //   1432: aload 10
    //   1434: getfield 502	android/util/Pair:first	Ljava/lang/Object;
    //   1437: checkcast 504	java/lang/Long
    //   1440: invokevirtual 507	java/lang/Long:longValue	()J
    //   1443: invokespecial 140	java/util/Date:<init>	(J)V
    //   1446: invokevirtual 146	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   1449: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1452: ldc_w 509
    //   1455: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1458: aload 10
    //   1460: getfield 512	android/util/Pair:second	Ljava/lang/Object;
    //   1463: checkcast 75	java/lang/String
    //   1466: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1469: pop
    //   1470: goto -78 -> 1392
    //   1473: astore 12
    //   1475: aload 11
    //   1477: astore 10
    //   1479: aload 12
    //   1481: astore 11
    //   1483: aload 11
    //   1485: invokevirtual 515	java/lang/Exception:printStackTrace	()V
    //   1488: aload 10
    //   1490: ifnull -1194 -> 296
    //   1493: aload 10
    //   1495: invokevirtual 157	java/io/FileWriter:close	()V
    //   1498: goto -1202 -> 296
    //   1501: astore 10
    //   1503: goto -1207 -> 296
    //   1506: astore_2
    //   1507: aconst_null
    //   1508: astore_3
    //   1509: aload_3
    //   1510: ifnull +7 -> 1517
    //   1513: aload_3
    //   1514: invokevirtual 157	java/io/FileWriter:close	()V
    //   1517: aload_2
    //   1518: athrow
    //   1519: iconst_0
    //   1520: istore 9
    //   1522: goto -974 -> 548
    //   1525: aload_0
    //   1526: getfield 12	ahrx:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1529: invokestatic 359	com/tencent/mobileqq/statistics/StatisticCollector:a	(Lcom/tencent/mobileqq/statistics/StatisticCollector;)Ljava/lang/String;
    //   1532: astore_3
    //   1533: goto -596 -> 937
    //   1536: ldc_w 517
    //   1539: astore_3
    //   1540: goto -346 -> 1194
    //   1543: getstatic 520	com/tencent/qbar/QbarCrashCollector:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1546: astore_3
    //   1547: aload_3
    //   1548: ifnull +23 -> 1571
    //   1551: aload_3
    //   1552: invokevirtual 523	java/lang/String:length	()I
    //   1555: ifle +16 -> 1571
    //   1558: aload 11
    //   1560: ldc_w 525
    //   1563: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1566: aload_3
    //   1567: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1570: pop
    //   1571: aload_2
    //   1572: invokestatic 85	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1575: ifne +49 -> 1624
    //   1578: aload_2
    //   1579: ldc_w 527
    //   1582: invokevirtual 90	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1585: ifeq +39 -> 1624
    //   1588: aload 4
    //   1590: invokestatic 85	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1593: ifne +31 -> 1624
    //   1596: aload 4
    //   1598: ldc_w 529
    //   1601: invokevirtual 90	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1604: ifeq +20 -> 1624
    //   1607: aload 11
    //   1609: ldc_w 531
    //   1612: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1615: pop
    //   1616: invokestatic 471	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1619: aload 11
    //   1621: invokestatic 534	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;Ljava/lang/StringBuilder;)V
    //   1624: ldc 26
    //   1626: iconst_1
    //   1627: new 28	java/lang/StringBuilder
    //   1630: dup
    //   1631: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   1634: ldc_w 536
    //   1637: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1640: aload 11
    //   1642: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1645: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1648: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1651: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1654: aload 11
    //   1656: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1659: areturn
    //   1660: astore 10
    //   1662: goto -1366 -> 296
    //   1665: astore_3
    //   1666: goto -149 -> 1517
    //   1669: astore_2
    //   1670: goto -46 -> 1624
    //   1673: astore_3
    //   1674: goto -103 -> 1571
    //   1677: astore_3
    //   1678: goto -437 -> 1241
    //   1681: astore_3
    //   1682: goto -567 -> 1115
    //   1685: astore_2
    //   1686: aload 10
    //   1688: astore_3
    //   1689: goto -180 -> 1509
    //   1692: astore_2
    //   1693: aload 10
    //   1695: astore_3
    //   1696: goto -187 -> 1509
    //   1699: astore 11
    //   1701: goto -218 -> 1483
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1704	0	this	ahrx
    //   0	1704	1	paramBoolean	boolean
    //   0	1704	2	paramString1	String
    //   0	1704	3	paramString2	String
    //   0	1704	4	paramString3	String
    //   0	1704	5	paramInt	int
    //   0	1704	6	paramLong	long
    //   1168	50	8	i	int
    //   546	975	9	bool	boolean
    //   164	1330	10	localObject1	Object
    //   1501	1	10	localException1	java.lang.Exception
    //   1660	34	10	localException2	java.lang.Exception
    //   153	1502	11	localObject2	Object
    //   1699	1	11	localException3	java.lang.Exception
    //   347	919	12	str	String
    //   1473	7	12	localException4	java.lang.Exception
    //   848	62	13	arrayOfLong	long[]
    // Exception table:
    //   from	to	target	type
    //   1115	1150	1153	java/lang/Throwable
    //   155	166	1473	java/lang/Exception
    //   171	185	1473	java/lang/Exception
    //   185	219	1473	java/lang/Exception
    //   1493	1498	1501	java/lang/Exception
    //   155	166	1506	finally
    //   171	185	1506	finally
    //   185	219	1506	finally
    //   291	296	1660	java/lang/Exception
    //   1513	1517	1665	java/lang/Exception
    //   1571	1624	1669	java/lang/Throwable
    //   1543	1547	1673	java/lang/Throwable
    //   1551	1571	1673	java/lang/Throwable
    //   1154	1185	1677	java/lang/Throwable
    //   1194	1241	1677	java/lang/Throwable
    //   430	534	1681	java/lang/Throwable
    //   538	545	1681	java/lang/Throwable
    //   548	703	1681	java/lang/Throwable
    //   703	760	1681	java/lang/Throwable
    //   760	779	1681	java/lang/Throwable
    //   783	832	1681	java/lang/Throwable
    //   832	864	1681	java/lang/Throwable
    //   876	933	1681	java/lang/Throwable
    //   937	1006	1681	java/lang/Throwable
    //   1006	1095	1681	java/lang/Throwable
    //   1095	1115	1681	java/lang/Throwable
    //   1525	1533	1681	java/lang/Throwable
    //   219	286	1685	finally
    //   1483	1488	1692	finally
    //   219	286	1699	java/lang/Exception
  }
  
  public boolean onCrashHandleEnd(boolean paramBoolean)
  {
    QLog.d("StatisticCollector", 1, "onCrashHandleEnd isNativeCrashed=" + paramBoolean);
    Object localObject = BaseApplicationImpl.processName;
    try
    {
      if (!((String)localObject).equals("com.tencent.mobileqq")) {
        break label215;
      }
      if (!this.a.jdField_a_of_type_Boolean) {
        break label206;
      }
      QLog.d("StatisticCollector", 1, "onCrashHandleEnd shouldStopMsf=" + this.a.jdField_a_of_type_Boolean + ", kill package processes.");
      localObject = ((ActivityManager)StatisticCollector.a().getSystemService("activity")).getRunningAppProcesses();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
          String str = localRunningAppProcessInfo.processName;
          if ((str != null) && (str.startsWith("com.tencent.mobileqq:")) && (!str.endsWith(":MSF")))
          {
            Process.killProcess(localRunningAppProcessInfo.pid);
            continue;
            return true;
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    BaseApplicationImpl.getApplication().stopMsfOnCrash(true);
    Process.killProcess(Process.myPid());
    label206:
    BaseApplicationImpl.getApplication().QQProcessExit(true);
    return true;
    label215:
    if ((!localThrowable.endsWith(":qzone")) && (!localThrowable.endsWith(":buscard"))) {}
    for (;;)
    {
      BaseApplicationImpl.getApplication().otherProcessExit(false);
      return true;
      if (!paramBoolean) {
        break;
      }
    }
  }
  
  public void onCrashHandleStart(boolean paramBoolean)
  {
    QLog.d("StatisticCollector", 1, "onCrashHandleStart isNativeCrashed=" + paramBoolean + ", hasCrashed=" + StatisticCollector.a(this.a));
    Object localObject2 = BaseApplicationImpl.processName;
    if ((StatisticCollector.a(this.a)) && (!((String)localObject2).endsWith(":buscard"))) {
      Process.killProcess(Process.myPid());
    }
    label809:
    do
    {
      for (;;)
      {
        try
        {
          Object localObject3 = new StringBuilder(128);
          Object localObject4 = new StringBuilder().append("topActivity:");
          Object localObject1;
          int j;
          if (BaseActivity.sTopActivity == null)
          {
            localObject1 = "null";
            localObject1 = (String)localObject1;
            localObject4 = new StringBuilder(128);
            j = StatisticCollector.a(this.a).size();
            int i = Math.min(j, 5);
            if (i > 0)
            {
              String str = (String)StatisticCollector.a(this.a).pop();
              if (((StringBuilder)localObject4).length() > 0) {
                ((StringBuilder)localObject4).append("\n--->");
              }
              ((StringBuilder)localObject4).append(str);
              i -= 1;
              continue;
              StatisticCollector.a(this.a, true);
            }
          }
          else
          {
            localObject1 = BaseActivity.sTopActivity.toString();
            continue;
          }
          StatisticCollector.a(this.a).clear();
          ((StringBuilder)localObject3).append((String)localObject1).append("\n");
          ((StringBuilder)localObject3).append("ActivityInfoStack:size=").append(j).append(",top five were:↓\n--->");
          ((StringBuilder)localObject3).append((CharSequence)localObject4).append("\n");
          ((StringBuilder)localObject3).append("Current mapEvent content is:\n");
          ((StringBuilder)localObject3).append(StatisticCollector.a(this.a).toString());
          StatisticCollector.a(this.a, ((StringBuilder)localObject3).toString());
          if (!((String)localObject2).endsWith(":qzone")) {
            break;
          }
        }
        catch (Throwable localThrowable2)
        {
          try
          {
            BaseApplicationImpl.getApplication().closeAllActivitys();
            StatisticCollector.a(this.a, StatisticCollector.a(), (String)localObject2);
            for (;;)
            {
              try
              {
                if (((String)localObject2).equals("com.tencent.mobileqq"))
                {
                  this.a.a();
                  this.a.b();
                }
                if ((((String)localObject2).endsWith(":qzone")) || (((String)localObject2).endsWith(":tool")) || (((String)localObject2).endsWith(":peak")))
                {
                  this.a.a();
                  this.a.b((String)localObject2);
                }
                if (((((String)localObject2).endsWith(":qzone")) || (((String)localObject2).endsWith(":tool")) || (((String)localObject2).endsWith(":peak")) || (((String)localObject2).endsWith(":qzonevideo")) || (((String)localObject2).endsWith(":picture"))) && (LocalMultiProcConfig.getBool("key_sp_qzone_isforeground", false)))
                {
                  QLog.d("StatisticCollector", 1, "qzone crash | crash time:" + System.currentTimeMillis() / 1000L);
                  LocalMultiProcConfig.putLong("key_sp_qzone_crash_time_" + this.a.jdField_a_of_type_JavaLangString, System.currentTimeMillis() / 1000L);
                  LocalMultiProcConfig.putBool("key_sp_qzone_isforeground", false);
                }
              }
              catch (Throwable localThrowable4)
              {
                QLog.d("StatisticCollector", 1, "init and update crashcontrol exception happen.");
                continue;
                localThrowable4.putStringArrayListExtra("procNameList", (ArrayList)localObject2);
                localThrowable4.putExtra("verify", BaseApplicationImpl.getLocalVerify((ArrayList)localObject2, false));
                StatisticCollector.a().sendBroadcast(localThrowable4);
                BaseApplicationImpl.getApplication().crashed();
                return;
              }
              try
              {
                StatisticCollector.a(this.a).append("Current thread Id=").append(Process.myTid()).append(", Name=").append(Thread.currentThread().getName()).append("\n");
                SharedPreferencesProxyManager.getInstance().trySave();
                if (!((String)localObject2).equals("com.tencent.mobileqq")) {
                  break label809;
                }
                localObject1 = new Intent("com.tencent.process.exit");
                localObject3 = ((ActivityManager)StatisticCollector.a().getSystemService("activity")).getRunningAppProcesses();
                localObject2 = new ArrayList();
                if ((localObject3 == null) || (((List)localObject3).size() <= 0)) {
                  continue;
                }
                localObject3 = ((List)localObject3).iterator();
                if (!((Iterator)localObject3).hasNext()) {
                  continue;
                }
                localObject4 = ((ActivityManager.RunningAppProcessInfo)((Iterator)localObject3).next()).processName;
                if ((localObject4 != null) && (((String)localObject4).startsWith("com.tencent.mobileqq:")) && (!((String)localObject4).endsWith(":MSF")))
                {
                  ((ArrayList)localObject2).add(localObject4);
                  continue;
                  localThrowable2 = localThrowable2;
                }
              }
              catch (Throwable localThrowable1)
              {
                localThrowable1.printStackTrace();
                return;
              }
            }
            localThrowable2.printStackTrace();
            continue;
          }
          catch (Throwable localThrowable3)
          {
            localThrowable3.printStackTrace();
            continue;
          }
        }
        Iterator localIterator = ((ActivityManager)StatisticCollector.a().getSystemService("activity")).getRunningAppProcesses().iterator();
        while (localIterator.hasNext())
        {
          localObject2 = (ActivityManager.RunningAppProcessInfo)localIterator.next();
          if (((ActivityManager.RunningAppProcessInfo)localObject2).processName.equals("com.tencent.mobileqq:qzonevideo")) {
            Process.killProcess(((ActivityManager.RunningAppProcessInfo)localObject2).pid);
          }
        }
      }
    } while ((((String)localObject2).endsWith(":video")) || (!((String)localObject2).endsWith(":TMAssistantDownloadSDKService")));
    TMAssistantDownloadManager.closeAllService(StatisticCollector.a());
  }
  
  public boolean onCrashSaving(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    WebpSoLoader.a(paramString3);
    GifSoLoader.a(paramString3);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ahrx
 * JD-Core Version:    0.7.0.1
 */