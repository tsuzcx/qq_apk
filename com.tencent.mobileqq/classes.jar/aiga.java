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

public class aiga
  implements CrashHandleListener
{
  public aiga(StatisticCollector paramStatisticCollector) {}
  
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
    //   535: ifnull +1013 -> 1548
    //   538: aload_3
    //   539: getfield 250	com/tencent/hotpatch/config/BasePatchConfig:jdField_a_of_type_Boolean	Z
    //   542: ifeq +1006 -> 1548
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
    //   752: getfield 12	aiga:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
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
    //   924: getfield 12	aiga:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   927: invokestatic 359	com/tencent/mobileqq/statistics/StatisticCollector:a	(Lcom/tencent/mobileqq/statistics/StatisticCollector;)Ljava/lang/String;
    //   930: ifnonnull +624 -> 1554
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
    //   1006: getstatic 376	com/tencent/common/app/BaseApplicationImpl:sPublicFragmentEscapedMsg	Ljava/lang/String;
    //   1009: invokestatic 85	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1012: ifne +23 -> 1035
    //   1015: aload 11
    //   1017: ldc_w 378
    //   1020: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1023: getstatic 376	com/tencent/common/app/BaseApplicationImpl:sPublicFragmentEscapedMsg	Ljava/lang/String;
    //   1026: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1029: ldc 148
    //   1031: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1034: pop
    //   1035: aload 11
    //   1037: aload_0
    //   1038: getfield 12	aiga:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1041: invokestatic 381	com/tencent/mobileqq/statistics/StatisticCollector:b	(Lcom/tencent/mobileqq/statistics/StatisticCollector;)Ljava/lang/StringBuilder;
    //   1044: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1047: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1050: pop
    //   1051: aload 11
    //   1053: aload_0
    //   1054: getfield 12	aiga:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1057: invokestatic 383	com/tencent/mobileqq/statistics/StatisticCollector:a	(Lcom/tencent/mobileqq/statistics/StatisticCollector;)Ljava/lang/StringBuilder;
    //   1060: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1063: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1066: pop
    //   1067: getstatic 386	cooperation/qzone/QZoneCrashHandler:lastCrashedMeasuredText	Ljava/lang/String;
    //   1070: invokestatic 85	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1073: ifne +51 -> 1124
    //   1076: getstatic 391	android/os/Build$VERSION:SDK_INT	I
    //   1079: bipush 8
    //   1081: if_icmplt +43 -> 1124
    //   1084: aload 11
    //   1086: new 28	java/lang/StringBuilder
    //   1089: dup
    //   1090: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   1093: ldc_w 393
    //   1096: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1099: getstatic 386	cooperation/qzone/QZoneCrashHandler:lastCrashedMeasuredText	Ljava/lang/String;
    //   1102: invokevirtual 397	java/lang/String:getBytes	()[B
    //   1105: iconst_0
    //   1106: invokestatic 403	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   1109: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1112: ldc 148
    //   1114: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1117: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1120: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1123: pop
    //   1124: aload 11
    //   1126: invokestatic 408	cooperation/qzone/RDMEtraMsgCollector:a	()Lcooperation/qzone/RDMEtraMsgCollector;
    //   1129: invokevirtual 409	cooperation/qzone/RDMEtraMsgCollector:a	()Ljava/lang/String;
    //   1132: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1135: pop
    //   1136: aload 11
    //   1138: ldc 148
    //   1140: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1143: pop
    //   1144: aload_0
    //   1145: getfield 12	aiga:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1148: invokestatic 412	com/tencent/mobileqq/statistics/StatisticCollector:a	(Lcom/tencent/mobileqq/statistics/StatisticCollector;)Ljava/util/LinkedList;
    //   1151: invokevirtual 415	java/util/LinkedList:size	()I
    //   1154: ifle +29 -> 1183
    //   1157: aload 11
    //   1159: aload_0
    //   1160: getfield 12	aiga:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1163: invokestatic 412	com/tencent/mobileqq/statistics/StatisticCollector:a	(Lcom/tencent/mobileqq/statistics/StatisticCollector;)Ljava/util/LinkedList;
    //   1166: invokevirtual 419	java/util/LinkedList:removeLast	()Ljava/lang/Object;
    //   1169: checkcast 421	aigd
    //   1172: invokevirtual 422	aigd:toString	()Ljava/lang/String;
    //   1175: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1178: pop
    //   1179: goto -35 -> 1144
    //   1182: astore_3
    //   1183: invokestatic 195	com/tencent/mobileqq/statistics/StatisticCollector:a	()Landroid/content/Context;
    //   1186: invokestatic 428	com/tencent/smtt/sdk/WebView:getTbsSDKVersion	(Landroid/content/Context;)I
    //   1189: istore 5
    //   1191: invokestatic 195	com/tencent/mobileqq/statistics/StatisticCollector:a	()Landroid/content/Context;
    //   1194: invokestatic 433	com/tencent/smtt/sdk/QbSdk:getTbsVersion	(Landroid/content/Context;)I
    //   1197: istore 8
    //   1199: aload 11
    //   1201: bipush 10
    //   1203: invokevirtual 436	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1206: ldc_w 438
    //   1209: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1212: astore 10
    //   1214: iload 8
    //   1216: ifne +349 -> 1565
    //   1219: ldc_w 440
    //   1222: astore_3
    //   1223: aload 10
    //   1225: aload_3
    //   1226: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1229: ldc_w 442
    //   1232: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1235: iload 5
    //   1237: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1240: ldc_w 444
    //   1243: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1246: iload 8
    //   1248: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1251: pop
    //   1252: aload 11
    //   1254: ldc_w 446
    //   1257: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1260: invokestatic 195	com/tencent/mobileqq/statistics/StatisticCollector:a	()Landroid/content/Context;
    //   1263: invokestatic 449	com/tencent/smtt/sdk/WebView:getCrashExtraMessage	(Landroid/content/Context;)Ljava/lang/String;
    //   1266: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1269: pop
    //   1270: iload_1
    //   1271: ifeq +97 -> 1368
    //   1274: aload 12
    //   1276: ldc 180
    //   1278: invokevirtual 106	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1281: ifne +23 -> 1304
    //   1284: aload 12
    //   1286: ldc 182
    //   1288: invokevirtual 106	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1291: ifne +13 -> 1304
    //   1294: aload 12
    //   1296: ldc 102
    //   1298: invokevirtual 106	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1301: ifeq +67 -> 1368
    //   1304: invokestatic 195	com/tencent/mobileqq/statistics/StatisticCollector:a	()Landroid/content/Context;
    //   1307: ldc 26
    //   1309: iconst_4
    //   1310: invokevirtual 455	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1313: ldc_w 457
    //   1316: aconst_null
    //   1317: invokeinterface 463 3 0
    //   1322: astore_3
    //   1323: aload 11
    //   1325: ldc_w 465
    //   1328: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1331: aload_3
    //   1332: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1335: pop
    //   1336: invokestatic 468	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1339: ifeq +29 -> 1368
    //   1342: ldc 26
    //   1344: iconst_2
    //   1345: new 28	java/lang/StringBuilder
    //   1348: dup
    //   1349: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   1352: ldc_w 470
    //   1355: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1358: aload_3
    //   1359: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1362: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1365: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1368: aload 11
    //   1370: ldc_w 472
    //   1373: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1376: invokestatic 476	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1379: getfield 479	com/tencent/common/app/BaseApplicationImpl:startComponentInfo	Ljava/lang/String;
    //   1382: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1385: pop
    //   1386: invokestatic 476	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1389: getfield 483	com/tencent/common/app/BaseApplicationImpl:broadcastInfoQueue	Ljava/util/Queue;
    //   1392: ifnull +180 -> 1572
    //   1395: invokestatic 476	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1398: getfield 483	com/tencent/common/app/BaseApplicationImpl:broadcastInfoQueue	Ljava/util/Queue;
    //   1401: invokeinterface 487 1 0
    //   1406: ifne +166 -> 1572
    //   1409: invokestatic 476	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1412: getfield 483	com/tencent/common/app/BaseApplicationImpl:broadcastInfoQueue	Ljava/util/Queue;
    //   1415: invokeinterface 491 1 0
    //   1420: astore_3
    //   1421: aload_3
    //   1422: invokeinterface 496 1 0
    //   1427: ifeq +145 -> 1572
    //   1430: aload_3
    //   1431: invokeinterface 499 1 0
    //   1436: checkcast 501	android/util/Pair
    //   1439: astore 10
    //   1441: aload 10
    //   1443: ifnull -22 -> 1421
    //   1446: aload 11
    //   1448: ldc_w 503
    //   1451: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1454: invokestatic 135	com/tencent/mobileqq/statistics/StatisticCollector:a	()Ljava/text/SimpleDateFormat;
    //   1457: new 137	java/util/Date
    //   1460: dup
    //   1461: aload 10
    //   1463: getfield 507	android/util/Pair:first	Ljava/lang/Object;
    //   1466: checkcast 509	java/lang/Long
    //   1469: invokevirtual 512	java/lang/Long:longValue	()J
    //   1472: invokespecial 140	java/util/Date:<init>	(J)V
    //   1475: invokevirtual 146	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   1478: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1481: ldc_w 514
    //   1484: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1487: aload 10
    //   1489: getfield 517	android/util/Pair:second	Ljava/lang/Object;
    //   1492: checkcast 75	java/lang/String
    //   1495: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1498: pop
    //   1499: goto -78 -> 1421
    //   1502: astore 12
    //   1504: aload 11
    //   1506: astore 10
    //   1508: aload 12
    //   1510: astore 11
    //   1512: aload 11
    //   1514: invokevirtual 520	java/lang/Exception:printStackTrace	()V
    //   1517: aload 10
    //   1519: ifnull -1223 -> 296
    //   1522: aload 10
    //   1524: invokevirtual 157	java/io/FileWriter:close	()V
    //   1527: goto -1231 -> 296
    //   1530: astore 10
    //   1532: goto -1236 -> 296
    //   1535: astore_2
    //   1536: aconst_null
    //   1537: astore_3
    //   1538: aload_3
    //   1539: ifnull +7 -> 1546
    //   1542: aload_3
    //   1543: invokevirtual 157	java/io/FileWriter:close	()V
    //   1546: aload_2
    //   1547: athrow
    //   1548: iconst_0
    //   1549: istore 9
    //   1551: goto -1003 -> 548
    //   1554: aload_0
    //   1555: getfield 12	aiga:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1558: invokestatic 359	com/tencent/mobileqq/statistics/StatisticCollector:a	(Lcom/tencent/mobileqq/statistics/StatisticCollector;)Ljava/lang/String;
    //   1561: astore_3
    //   1562: goto -625 -> 937
    //   1565: ldc_w 522
    //   1568: astore_3
    //   1569: goto -346 -> 1223
    //   1572: getstatic 525	com/tencent/qbar/QbarCrashCollector:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1575: astore_3
    //   1576: aload_3
    //   1577: ifnull +23 -> 1600
    //   1580: aload_3
    //   1581: invokevirtual 528	java/lang/String:length	()I
    //   1584: ifle +16 -> 1600
    //   1587: aload 11
    //   1589: ldc_w 530
    //   1592: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1595: aload_3
    //   1596: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1599: pop
    //   1600: aload_2
    //   1601: invokestatic 85	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1604: ifne +49 -> 1653
    //   1607: aload_2
    //   1608: ldc_w 532
    //   1611: invokevirtual 90	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1614: ifeq +39 -> 1653
    //   1617: aload 4
    //   1619: invokestatic 85	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1622: ifne +31 -> 1653
    //   1625: aload 4
    //   1627: ldc_w 534
    //   1630: invokevirtual 90	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1633: ifeq +20 -> 1653
    //   1636: aload 11
    //   1638: ldc_w 536
    //   1641: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1644: pop
    //   1645: invokestatic 476	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1648: aload 11
    //   1650: invokestatic 539	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;Ljava/lang/StringBuilder;)V
    //   1653: ldc 26
    //   1655: iconst_1
    //   1656: new 28	java/lang/StringBuilder
    //   1659: dup
    //   1660: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   1663: ldc_w 541
    //   1666: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1669: aload 11
    //   1671: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1674: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1677: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1680: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1683: aload 11
    //   1685: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1688: areturn
    //   1689: astore 10
    //   1691: goto -1395 -> 296
    //   1694: astore_3
    //   1695: goto -149 -> 1546
    //   1698: astore_2
    //   1699: goto -46 -> 1653
    //   1702: astore_3
    //   1703: goto -103 -> 1600
    //   1706: astore_3
    //   1707: goto -437 -> 1270
    //   1710: astore_3
    //   1711: goto -567 -> 1144
    //   1714: astore_2
    //   1715: aload 10
    //   1717: astore_3
    //   1718: goto -180 -> 1538
    //   1721: astore_2
    //   1722: aload 10
    //   1724: astore_3
    //   1725: goto -187 -> 1538
    //   1728: astore 11
    //   1730: goto -218 -> 1512
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1733	0	this	aiga
    //   0	1733	1	paramBoolean	boolean
    //   0	1733	2	paramString1	String
    //   0	1733	3	paramString2	String
    //   0	1733	4	paramString3	String
    //   0	1733	5	paramInt	int
    //   0	1733	6	paramLong	long
    //   1197	50	8	i	int
    //   546	1004	9	bool	boolean
    //   164	1359	10	localObject1	Object
    //   1530	1	10	localException1	java.lang.Exception
    //   1689	34	10	localException2	java.lang.Exception
    //   153	1531	11	localObject2	Object
    //   1728	1	11	localException3	java.lang.Exception
    //   347	948	12	str	String
    //   1502	7	12	localException4	java.lang.Exception
    //   848	62	13	arrayOfLong	long[]
    // Exception table:
    //   from	to	target	type
    //   1144	1179	1182	java/lang/Throwable
    //   155	166	1502	java/lang/Exception
    //   171	185	1502	java/lang/Exception
    //   185	219	1502	java/lang/Exception
    //   1522	1527	1530	java/lang/Exception
    //   155	166	1535	finally
    //   171	185	1535	finally
    //   185	219	1535	finally
    //   291	296	1689	java/lang/Exception
    //   1542	1546	1694	java/lang/Exception
    //   1600	1653	1698	java/lang/Throwable
    //   1572	1576	1702	java/lang/Throwable
    //   1580	1600	1702	java/lang/Throwable
    //   1183	1214	1706	java/lang/Throwable
    //   1223	1270	1706	java/lang/Throwable
    //   430	534	1710	java/lang/Throwable
    //   538	545	1710	java/lang/Throwable
    //   548	703	1710	java/lang/Throwable
    //   703	760	1710	java/lang/Throwable
    //   760	779	1710	java/lang/Throwable
    //   783	832	1710	java/lang/Throwable
    //   832	864	1710	java/lang/Throwable
    //   876	933	1710	java/lang/Throwable
    //   937	1006	1710	java/lang/Throwable
    //   1006	1035	1710	java/lang/Throwable
    //   1035	1124	1710	java/lang/Throwable
    //   1124	1144	1710	java/lang/Throwable
    //   1554	1562	1710	java/lang/Throwable
    //   219	286	1714	finally
    //   1512	1517	1721	finally
    //   219	286	1728	java/lang/Exception
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
 * Qualified Name:     aiga
 * JD-Core Version:    0.7.0.1
 */