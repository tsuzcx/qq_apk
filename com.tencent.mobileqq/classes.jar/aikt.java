import android.os.Process;
import android.text.TextUtils;
import com.tencent.feedback.eup.CrashHandleListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.GifSoLoader;
import com.tencent.mobileqq.util.WebpSoLoader;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Stack;

public class aikt
  implements CrashHandleListener
{
  public aikt(StatisticCollector paramStatisticCollector) {}
  
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
    //   59: invokestatic 58	com/tencent/mobileqq/statistics/StatisticCollector:a	()Ljava/text/SimpleDateFormat;
    //   62: new 60	java/util/Date
    //   65: dup
    //   66: lload 6
    //   68: invokespecial 63	java/util/Date:<init>	(J)V
    //   71: invokevirtual 69	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   74: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   83: getstatic 82	com/tencent/mobileqq/statistics/StatisticCollector:jdField_a_of_type_ComTencentMobileqqStatisticsStatisticCollector$StatisticCallback	Lcom/tencent/mobileqq/statistics/StatisticCollector$StatisticCallback;
    //   86: ifnull +41 -> 127
    //   89: iload_1
    //   90: ifne +37 -> 127
    //   93: ldc 84
    //   95: aload_2
    //   96: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   99: ifeq +28 -> 127
    //   102: aload_3
    //   103: invokestatic 96	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   106: ifne +21 -> 127
    //   109: aload_3
    //   110: ldc 98
    //   112: invokevirtual 101	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   115: ifeq +12 -> 127
    //   118: getstatic 82	com/tencent/mobileqq/statistics/StatisticCollector:jdField_a_of_type_ComTencentMobileqqStatisticsStatisticCollector$StatisticCallback	Lcom/tencent/mobileqq/statistics/StatisticCollector$StatisticCallback;
    //   121: aload_2
    //   122: invokeinterface 105 2 0
    //   127: getstatic 111	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   130: ldc 113
    //   132: invokevirtual 117	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   135: ifeq +30 -> 165
    //   138: new 28	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   145: ldc 120
    //   147: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload_2
    //   151: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: aload 4
    //   156: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 123	com/tencent/mobileqq/activity/qwallet/utils/QWalletCrashUtils:a	(Ljava/lang/String;)V
    //   165: aconst_null
    //   166: astore 11
    //   168: new 125	java/io/File
    //   171: dup
    //   172: ldc 127
    //   174: invokespecial 128	java/io/File:<init>	(Ljava/lang/String;)V
    //   177: astore 10
    //   179: aload 10
    //   181: ifnull +17 -> 198
    //   184: aload 10
    //   186: invokevirtual 132	java/io/File:exists	()Z
    //   189: ifne +9 -> 198
    //   192: aload 10
    //   194: invokevirtual 135	java/io/File:mkdirs	()Z
    //   197: pop
    //   198: new 137	java/io/FileWriter
    //   201: dup
    //   202: new 28	java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   209: ldc 127
    //   211: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: lload 6
    //   216: invokevirtual 140	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   219: ldc 142
    //   221: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: invokespecial 143	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   230: astore 10
    //   232: new 28	java/lang/StringBuilder
    //   235: dup
    //   236: sipush 128
    //   239: invokespecial 146	java/lang/StringBuilder:<init>	(I)V
    //   242: astore 11
    //   244: aload 11
    //   246: invokestatic 58	com/tencent/mobileqq/statistics/StatisticCollector:a	()Ljava/text/SimpleDateFormat;
    //   249: new 60	java/util/Date
    //   252: dup
    //   253: lload 6
    //   255: invokespecial 63	java/util/Date:<init>	(J)V
    //   258: invokevirtual 69	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   261: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: ldc 148
    //   266: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: aload_2
    //   270: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: ldc 148
    //   275: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: aload 4
    //   280: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: pop
    //   284: aload 10
    //   286: aload 11
    //   288: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: invokevirtual 151	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   294: aload 10
    //   296: invokevirtual 154	java/io/FileWriter:flush	()V
    //   299: aload 10
    //   301: ifnull +8 -> 309
    //   304: aload 10
    //   306: invokevirtual 157	java/io/FileWriter:close	()V
    //   309: aload_2
    //   310: invokestatic 96	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   313: ifne +44 -> 357
    //   316: aload_2
    //   317: ldc 159
    //   319: invokevirtual 101	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   322: ifeq +35 -> 357
    //   325: invokestatic 164	com/tencent/mobileqq/app/MemoryManager:a	()Lcom/tencent/mobileqq/app/MemoryManager;
    //   328: invokevirtual 166	com/tencent/mobileqq/app/MemoryManager:a	()V
    //   331: aload 4
    //   333: ldc 168
    //   335: invokevirtual 101	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   338: ifne +19 -> 357
    //   341: aload 4
    //   343: ldc 170
    //   345: invokevirtual 101	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   348: ifne +9 -> 357
    //   351: invokestatic 175	com/tencent/common/cache/MemoryClearManagerNew:a	()Lcom/tencent/common/cache/MemoryClearManagerNew;
    //   354: invokevirtual 178	com/tencent/common/cache/MemoryClearManagerNew:b	()V
    //   357: getstatic 111	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   360: astore 12
    //   362: iload_1
    //   363: ifeq +36 -> 399
    //   366: aload 12
    //   368: ldc 180
    //   370: invokevirtual 117	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   373: ifne +13 -> 386
    //   376: aload 12
    //   378: ldc 182
    //   380: invokevirtual 117	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   383: ifeq +16 -> 399
    //   386: ldc 184
    //   388: iconst_1
    //   389: aload 4
    //   391: invokestatic 187	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   394: aload 4
    //   396: invokestatic 192	cooperation/qzone/QZoneCrashHandler:saveLastCrashInf	(Ljava/lang/String;)V
    //   399: invokestatic 195	com/tencent/mobileqq/statistics/StatisticCollector:a	()Landroid/content/Context;
    //   402: aload 12
    //   404: new 28	java/lang/StringBuilder
    //   407: dup
    //   408: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   411: aload_2
    //   412: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: aload_3
    //   416: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: invokestatic 200	com/tencent/hotpatch/PatchSecurityMode:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   425: invokestatic 195	com/tencent/mobileqq/statistics/StatisticCollector:a	()Landroid/content/Context;
    //   428: invokestatic 205	com/tencent/common/app/QFixApplicationImpl:b	(Landroid/content/Context;)V
    //   431: new 28	java/lang/StringBuilder
    //   434: dup
    //   435: sipush 128
    //   438: invokespecial 146	java/lang/StringBuilder:<init>	(I)V
    //   441: astore 11
    //   443: invokestatic 195	com/tencent/mobileqq/statistics/StatisticCollector:a	()Landroid/content/Context;
    //   446: ldc 207
    //   448: invokestatic 212	com/tencent/hotpatch/config/PatchConfigManager:a	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/hotpatch/config/PatchConfig;
    //   451: astore_3
    //   452: aload 11
    //   454: ldc 214
    //   456: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: pop
    //   460: aload 11
    //   462: ldc 216
    //   464: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: pop
    //   468: aload 11
    //   470: ldc 218
    //   472: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: getstatic 221	com/tencent/common/app/BaseApplicationImpl:sInjectResult	Ljava/lang/String;
    //   478: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: pop
    //   482: aload 11
    //   484: ldc 223
    //   486: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: getstatic 226	com/tencent/common/app/BaseApplicationImpl:sQQAppInterfaceEscapedMsg	Ljava/lang/String;
    //   492: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: pop
    //   496: aload 11
    //   498: ldc 228
    //   500: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: getstatic 231	com/tencent/common/app/BaseApplicationImpl:sSplashActivityEscapedMsg	Ljava/lang/String;
    //   506: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: pop
    //   510: aload 11
    //   512: ldc 233
    //   514: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: getstatic 236	com/tencent/common/app/BaseApplicationImpl:sImmersiveUtilsEscapedMsg	Ljava/lang/String;
    //   520: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: pop
    //   524: aload 11
    //   526: ldc 238
    //   528: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: getstatic 243	com/tencent/mobileqq/startup/director/StartupDirector:b	I
    //   534: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   537: pop
    //   538: aload 11
    //   540: ldc 245
    //   542: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: astore 10
    //   547: aload_3
    //   548: ifnull +1042 -> 1590
    //   551: aload_3
    //   552: invokevirtual 249	com/tencent/hotpatch/config/PatchConfig:a	()Z
    //   555: ifeq +1035 -> 1590
    //   558: iconst_1
    //   559: istore 9
    //   561: aload 10
    //   563: iload 9
    //   565: invokevirtual 37	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   568: ldc 251
    //   570: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: getstatic 255	com/tencent/hotpatch/DexPatchInstaller:jdField_a_of_type_Int	I
    //   576: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   579: ldc_w 257
    //   582: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: getstatic 260	com/tencent/hotpatch/PatchResolveForDalvik:jdField_a_of_type_Int	I
    //   588: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   591: ldc_w 262
    //   594: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: getstatic 264	com/tencent/hotpatch/DexPatchInstaller:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   600: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: pop
    //   604: aload 11
    //   606: ldc_w 266
    //   609: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: invokestatic 272	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   615: invokevirtual 276	java/lang/Runtime:maxMemory	()J
    //   618: invokevirtual 140	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   621: ldc_w 278
    //   624: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: invokestatic 272	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   630: invokevirtual 281	java/lang/Runtime:totalMemory	()J
    //   633: invokestatic 272	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   636: invokevirtual 284	java/lang/Runtime:freeMemory	()J
    //   639: lsub
    //   640: invokevirtual 140	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   643: pop
    //   644: aload 11
    //   646: ldc_w 286
    //   649: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   652: invokestatic 164	com/tencent/mobileqq/app/MemoryManager:a	()Lcom/tencent/mobileqq/app/MemoryManager;
    //   655: invokevirtual 289	com/tencent/mobileqq/app/MemoryManager:a	()I
    //   658: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   661: ldc_w 291
    //   664: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: invokestatic 164	com/tencent/mobileqq/app/MemoryManager:a	()Lcom/tencent/mobileqq/app/MemoryManager;
    //   670: invokevirtual 293	com/tencent/mobileqq/app/MemoryManager:b	()I
    //   673: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   676: ldc_w 295
    //   679: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: invokestatic 164	com/tencent/mobileqq/app/MemoryManager:a	()Lcom/tencent/mobileqq/app/MemoryManager;
    //   685: invokevirtual 298	com/tencent/mobileqq/app/MemoryManager:c	()I
    //   688: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   691: pop
    //   692: getstatic 302	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   695: ifnull +21 -> 716
    //   698: aload 11
    //   700: ldc_w 304
    //   703: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   706: getstatic 302	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   709: invokevirtual 309	android/support/v4/util/MQLruCache:size	()I
    //   712: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   715: pop
    //   716: invokestatic 272	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   719: invokevirtual 276	java/lang/Runtime:maxMemory	()J
    //   722: invokestatic 272	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   725: invokevirtual 281	java/lang/Runtime:totalMemory	()J
    //   728: lsub
    //   729: l2f
    //   730: fconst_1
    //   731: fmul
    //   732: invokestatic 272	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   735: invokevirtual 276	java/lang/Runtime:maxMemory	()J
    //   738: l2f
    //   739: fdiv
    //   740: f2d
    //   741: ldc2_w 310
    //   744: dcmpl
    //   745: iflt +28 -> 773
    //   748: aload_2
    //   749: invokestatic 96	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   752: ifne +21 -> 773
    //   755: aload_2
    //   756: ldc 159
    //   758: invokevirtual 101	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   761: ifeq +12 -> 773
    //   764: aload_0
    //   765: getfield 12	aikt:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   768: aload 11
    //   770: invokevirtual 314	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/StringBuilder;)V
    //   773: aload 11
    //   775: ldc_w 316
    //   778: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   781: getstatic 321	com/tencent/mqq/shared_file_accessor/SharedPreferencesProxyManager:sSystemSpExceptionMsg	Ljava/lang/String;
    //   784: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: pop
    //   788: getstatic 326	com/tencent/mobileqq/util/WebpSoLoader:a	[I
    //   791: astore_3
    //   792: aload_3
    //   793: ifnull +52 -> 845
    //   796: aload_3
    //   797: arraylength
    //   798: iconst_3
    //   799: if_icmplt +46 -> 845
    //   802: aload 11
    //   804: ldc_w 328
    //   807: iconst_3
    //   808: anewarray 4	java/lang/Object
    //   811: dup
    //   812: iconst_0
    //   813: aload_3
    //   814: iconst_0
    //   815: iaload
    //   816: invokestatic 334	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   819: aastore
    //   820: dup
    //   821: iconst_1
    //   822: aload_3
    //   823: iconst_1
    //   824: iaload
    //   825: invokestatic 334	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   828: aastore
    //   829: dup
    //   830: iconst_2
    //   831: aload_3
    //   832: iconst_2
    //   833: iaload
    //   834: invokestatic 334	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   837: aastore
    //   838: invokestatic 337	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   841: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   844: pop
    //   845: aload 11
    //   847: ldc 148
    //   849: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   852: pop
    //   853: invokestatic 339	com/tencent/mobileqq/statistics/StatisticCollector:a	()Ljava/lang/String;
    //   856: astore 10
    //   858: invokestatic 344	com/tencent/mobileqq/utils/DeviceInfoUtil:a	()[J
    //   861: astore 13
    //   863: aload 11
    //   865: invokestatic 347	com/tencent/mobileqq/utils/DeviceInfoUtil:m	()Ljava/lang/String;
    //   868: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   871: ldc 148
    //   873: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   876: pop
    //   877: aload 10
    //   879: astore_3
    //   880: aload 10
    //   882: ifnonnull +7 -> 889
    //   885: ldc_w 349
    //   888: astore_3
    //   889: aload 11
    //   891: aload_3
    //   892: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   895: ldc 148
    //   897: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   900: pop
    //   901: aload 11
    //   903: ldc_w 351
    //   906: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   909: aload 13
    //   911: iconst_0
    //   912: laload
    //   913: invokevirtual 140	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   916: ldc_w 353
    //   919: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   922: aload 13
    //   924: iconst_1
    //   925: laload
    //   926: invokevirtual 140	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   929: ldc_w 355
    //   932: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   935: pop
    //   936: aload_0
    //   937: getfield 12	aikt:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   940: invokestatic 358	com/tencent/mobileqq/statistics/StatisticCollector:a	(Lcom/tencent/mobileqq/statistics/StatisticCollector;)Ljava/lang/String;
    //   943: ifnonnull +653 -> 1596
    //   946: ldc_w 349
    //   949: astore_3
    //   950: aload 11
    //   952: aload_3
    //   953: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   956: ldc 148
    //   958: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   961: pop
    //   962: aload 11
    //   964: ldc_w 360
    //   967: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   970: getstatic 363	com/tencent/mobileqq/activity/SplashActivity:jdField_a_of_type_Int	I
    //   973: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   976: ldc 148
    //   978: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   981: pop
    //   982: getstatic 369	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   985: astore_3
    //   986: aload_3
    //   987: instanceof 362
    //   990: ifeq +29 -> 1019
    //   993: aload_3
    //   994: checkcast 362	com/tencent/mobileqq/activity/SplashActivity
    //   997: astore_3
    //   998: aload 11
    //   1000: ldc_w 371
    //   1003: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1006: aload_3
    //   1007: invokevirtual 372	com/tencent/mobileqq/activity/SplashActivity:a	()I
    //   1010: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1013: ldc 148
    //   1015: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1018: pop
    //   1019: getstatic 375	com/tencent/common/app/BaseApplicationImpl:sPublicFragmentEscapedMsg	Ljava/lang/String;
    //   1022: invokestatic 96	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1025: ifne +23 -> 1048
    //   1028: aload 11
    //   1030: ldc_w 377
    //   1033: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1036: getstatic 375	com/tencent/common/app/BaseApplicationImpl:sPublicFragmentEscapedMsg	Ljava/lang/String;
    //   1039: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1042: ldc 148
    //   1044: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1047: pop
    //   1048: getstatic 380	com/tencent/common/app/BaseApplicationImpl:sNativeMonitorEscapedMsg	Ljava/lang/String;
    //   1051: invokestatic 96	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1054: ifne +23 -> 1077
    //   1057: aload 11
    //   1059: ldc_w 382
    //   1062: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1065: getstatic 380	com/tencent/common/app/BaseApplicationImpl:sNativeMonitorEscapedMsg	Ljava/lang/String;
    //   1068: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1071: ldc 148
    //   1073: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1076: pop
    //   1077: aload 11
    //   1079: aload_0
    //   1080: getfield 12	aikt:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1083: invokestatic 385	com/tencent/mobileqq/statistics/StatisticCollector:b	(Lcom/tencent/mobileqq/statistics/StatisticCollector;)Ljava/lang/StringBuilder;
    //   1086: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1089: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1092: pop
    //   1093: aload 11
    //   1095: aload_0
    //   1096: getfield 12	aikt:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1099: invokestatic 387	com/tencent/mobileqq/statistics/StatisticCollector:a	(Lcom/tencent/mobileqq/statistics/StatisticCollector;)Ljava/lang/StringBuilder;
    //   1102: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1105: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1108: pop
    //   1109: getstatic 390	cooperation/qzone/QZoneCrashHandler:lastCrashedMeasuredText	Ljava/lang/String;
    //   1112: invokestatic 96	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1115: ifne +51 -> 1166
    //   1118: getstatic 395	android/os/Build$VERSION:SDK_INT	I
    //   1121: bipush 8
    //   1123: if_icmplt +43 -> 1166
    //   1126: aload 11
    //   1128: new 28	java/lang/StringBuilder
    //   1131: dup
    //   1132: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   1135: ldc_w 397
    //   1138: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1141: getstatic 390	cooperation/qzone/QZoneCrashHandler:lastCrashedMeasuredText	Ljava/lang/String;
    //   1144: invokevirtual 401	java/lang/String:getBytes	()[B
    //   1147: iconst_0
    //   1148: invokestatic 407	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   1151: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1154: ldc 148
    //   1156: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1159: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1162: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1165: pop
    //   1166: aload 11
    //   1168: invokestatic 412	cooperation/qzone/RDMEtraMsgCollector:a	()Lcooperation/qzone/RDMEtraMsgCollector;
    //   1171: invokevirtual 413	cooperation/qzone/RDMEtraMsgCollector:a	()Ljava/lang/String;
    //   1174: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1177: pop
    //   1178: aload 11
    //   1180: ldc 148
    //   1182: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1185: pop
    //   1186: aload_0
    //   1187: getfield 12	aikt:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1190: invokestatic 416	com/tencent/mobileqq/statistics/StatisticCollector:a	(Lcom/tencent/mobileqq/statistics/StatisticCollector;)Ljava/util/LinkedList;
    //   1193: invokevirtual 419	java/util/LinkedList:size	()I
    //   1196: ifle +29 -> 1225
    //   1199: aload 11
    //   1201: aload_0
    //   1202: getfield 12	aikt:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1205: invokestatic 416	com/tencent/mobileqq/statistics/StatisticCollector:a	(Lcom/tencent/mobileqq/statistics/StatisticCollector;)Ljava/util/LinkedList;
    //   1208: invokevirtual 423	java/util/LinkedList:removeLast	()Ljava/lang/Object;
    //   1211: checkcast 425	aikw
    //   1214: invokevirtual 426	aikw:toString	()Ljava/lang/String;
    //   1217: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1220: pop
    //   1221: goto -35 -> 1186
    //   1224: astore_3
    //   1225: invokestatic 195	com/tencent/mobileqq/statistics/StatisticCollector:a	()Landroid/content/Context;
    //   1228: invokestatic 432	com/tencent/smtt/sdk/WebView:getTbsSDKVersion	(Landroid/content/Context;)I
    //   1231: istore 5
    //   1233: invokestatic 195	com/tencent/mobileqq/statistics/StatisticCollector:a	()Landroid/content/Context;
    //   1236: invokestatic 437	com/tencent/smtt/sdk/QbSdk:getTbsVersion	(Landroid/content/Context;)I
    //   1239: istore 8
    //   1241: aload 11
    //   1243: bipush 10
    //   1245: invokevirtual 440	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1248: ldc_w 442
    //   1251: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1254: astore 10
    //   1256: iload 8
    //   1258: ifne +349 -> 1607
    //   1261: ldc_w 444
    //   1264: astore_3
    //   1265: aload 10
    //   1267: aload_3
    //   1268: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1271: ldc_w 446
    //   1274: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1277: iload 5
    //   1279: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1282: ldc_w 448
    //   1285: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1288: iload 8
    //   1290: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1293: pop
    //   1294: aload 11
    //   1296: ldc_w 450
    //   1299: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1302: invokestatic 195	com/tencent/mobileqq/statistics/StatisticCollector:a	()Landroid/content/Context;
    //   1305: invokestatic 453	com/tencent/smtt/sdk/WebView:getCrashExtraMessage	(Landroid/content/Context;)Ljava/lang/String;
    //   1308: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1311: pop
    //   1312: iload_1
    //   1313: ifeq +97 -> 1410
    //   1316: aload 12
    //   1318: ldc 180
    //   1320: invokevirtual 117	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1323: ifne +23 -> 1346
    //   1326: aload 12
    //   1328: ldc 182
    //   1330: invokevirtual 117	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1333: ifne +13 -> 1346
    //   1336: aload 12
    //   1338: ldc 113
    //   1340: invokevirtual 117	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1343: ifeq +67 -> 1410
    //   1346: invokestatic 195	com/tencent/mobileqq/statistics/StatisticCollector:a	()Landroid/content/Context;
    //   1349: ldc 26
    //   1351: iconst_4
    //   1352: invokevirtual 459	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1355: ldc_w 461
    //   1358: aconst_null
    //   1359: invokeinterface 467 3 0
    //   1364: astore_3
    //   1365: aload 11
    //   1367: ldc_w 469
    //   1370: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1373: aload_3
    //   1374: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1377: pop
    //   1378: invokestatic 472	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1381: ifeq +29 -> 1410
    //   1384: ldc 26
    //   1386: iconst_2
    //   1387: new 28	java/lang/StringBuilder
    //   1390: dup
    //   1391: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   1394: ldc_w 474
    //   1397: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1400: aload_3
    //   1401: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1404: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1407: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1410: aload 11
    //   1412: ldc_w 476
    //   1415: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1418: invokestatic 480	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1421: getfield 483	com/tencent/common/app/BaseApplicationImpl:startComponentInfo	Ljava/lang/String;
    //   1424: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1427: pop
    //   1428: invokestatic 480	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1431: getfield 487	com/tencent/common/app/BaseApplicationImpl:broadcastInfoQueue	Ljava/util/Queue;
    //   1434: ifnull +180 -> 1614
    //   1437: invokestatic 480	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1440: getfield 487	com/tencent/common/app/BaseApplicationImpl:broadcastInfoQueue	Ljava/util/Queue;
    //   1443: invokeinterface 491 1 0
    //   1448: ifne +166 -> 1614
    //   1451: invokestatic 480	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1454: getfield 487	com/tencent/common/app/BaseApplicationImpl:broadcastInfoQueue	Ljava/util/Queue;
    //   1457: invokeinterface 495 1 0
    //   1462: astore_3
    //   1463: aload_3
    //   1464: invokeinterface 500 1 0
    //   1469: ifeq +145 -> 1614
    //   1472: aload_3
    //   1473: invokeinterface 503 1 0
    //   1478: checkcast 505	android/util/Pair
    //   1481: astore 10
    //   1483: aload 10
    //   1485: ifnull -22 -> 1463
    //   1488: aload 11
    //   1490: ldc_w 507
    //   1493: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1496: invokestatic 58	com/tencent/mobileqq/statistics/StatisticCollector:a	()Ljava/text/SimpleDateFormat;
    //   1499: new 60	java/util/Date
    //   1502: dup
    //   1503: aload 10
    //   1505: getfield 511	android/util/Pair:first	Ljava/lang/Object;
    //   1508: checkcast 513	java/lang/Long
    //   1511: invokevirtual 516	java/lang/Long:longValue	()J
    //   1514: invokespecial 63	java/util/Date:<init>	(J)V
    //   1517: invokevirtual 69	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   1520: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1523: ldc_w 518
    //   1526: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1529: aload 10
    //   1531: getfield 521	android/util/Pair:second	Ljava/lang/Object;
    //   1534: checkcast 86	java/lang/String
    //   1537: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1540: pop
    //   1541: goto -78 -> 1463
    //   1544: astore 12
    //   1546: aload 11
    //   1548: astore 10
    //   1550: aload 12
    //   1552: astore 11
    //   1554: aload 11
    //   1556: invokevirtual 524	java/lang/Exception:printStackTrace	()V
    //   1559: aload 10
    //   1561: ifnull -1252 -> 309
    //   1564: aload 10
    //   1566: invokevirtual 157	java/io/FileWriter:close	()V
    //   1569: goto -1260 -> 309
    //   1572: astore 10
    //   1574: goto -1265 -> 309
    //   1577: astore_2
    //   1578: aconst_null
    //   1579: astore_3
    //   1580: aload_3
    //   1581: ifnull +7 -> 1588
    //   1584: aload_3
    //   1585: invokevirtual 157	java/io/FileWriter:close	()V
    //   1588: aload_2
    //   1589: athrow
    //   1590: iconst_0
    //   1591: istore 9
    //   1593: goto -1032 -> 561
    //   1596: aload_0
    //   1597: getfield 12	aikt:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1600: invokestatic 358	com/tencent/mobileqq/statistics/StatisticCollector:a	(Lcom/tencent/mobileqq/statistics/StatisticCollector;)Ljava/lang/String;
    //   1603: astore_3
    //   1604: goto -654 -> 950
    //   1607: ldc_w 526
    //   1610: astore_3
    //   1611: goto -346 -> 1265
    //   1614: getstatic 529	com/tencent/qbar/QbarCrashCollector:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1617: astore_3
    //   1618: aload_3
    //   1619: ifnull +23 -> 1642
    //   1622: aload_3
    //   1623: invokevirtual 532	java/lang/String:length	()I
    //   1626: ifle +16 -> 1642
    //   1629: aload 11
    //   1631: ldc_w 534
    //   1634: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1637: aload_3
    //   1638: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1641: pop
    //   1642: aload_2
    //   1643: invokestatic 96	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1646: ifne +49 -> 1695
    //   1649: aload_2
    //   1650: ldc_w 536
    //   1653: invokevirtual 101	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1656: ifeq +39 -> 1695
    //   1659: aload 4
    //   1661: invokestatic 96	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1664: ifne +31 -> 1695
    //   1667: aload 4
    //   1669: ldc_w 538
    //   1672: invokevirtual 101	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1675: ifeq +20 -> 1695
    //   1678: aload 11
    //   1680: ldc_w 540
    //   1683: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1686: pop
    //   1687: invokestatic 480	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1690: aload 11
    //   1692: invokestatic 543	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;Ljava/lang/StringBuilder;)V
    //   1695: ldc 26
    //   1697: iconst_1
    //   1698: new 28	java/lang/StringBuilder
    //   1701: dup
    //   1702: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   1705: ldc_w 545
    //   1708: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1711: aload 11
    //   1713: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1716: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1719: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1722: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1725: aload 11
    //   1727: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1730: areturn
    //   1731: astore 10
    //   1733: goto -1424 -> 309
    //   1736: astore_3
    //   1737: goto -149 -> 1588
    //   1740: astore_2
    //   1741: goto -46 -> 1695
    //   1744: astore_3
    //   1745: goto -103 -> 1642
    //   1748: astore_3
    //   1749: goto -437 -> 1312
    //   1752: astore_3
    //   1753: goto -567 -> 1186
    //   1756: astore_2
    //   1757: aload 10
    //   1759: astore_3
    //   1760: goto -180 -> 1580
    //   1763: astore_2
    //   1764: aload 10
    //   1766: astore_3
    //   1767: goto -187 -> 1580
    //   1770: astore 11
    //   1772: goto -218 -> 1554
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1775	0	this	aikt
    //   0	1775	1	paramBoolean	boolean
    //   0	1775	2	paramString1	String
    //   0	1775	3	paramString2	String
    //   0	1775	4	paramString3	String
    //   0	1775	5	paramInt	int
    //   0	1775	6	paramLong	long
    //   1239	50	8	i	int
    //   559	1033	9	bool	boolean
    //   177	1388	10	localObject1	Object
    //   1572	1	10	localException1	java.lang.Exception
    //   1731	34	10	localException2	java.lang.Exception
    //   166	1560	11	localObject2	Object
    //   1770	1	11	localException3	java.lang.Exception
    //   360	977	12	str	String
    //   1544	7	12	localException4	java.lang.Exception
    //   861	62	13	arrayOfLong	long[]
    // Exception table:
    //   from	to	target	type
    //   1186	1221	1224	java/lang/Throwable
    //   168	179	1544	java/lang/Exception
    //   184	198	1544	java/lang/Exception
    //   198	232	1544	java/lang/Exception
    //   1564	1569	1572	java/lang/Exception
    //   168	179	1577	finally
    //   184	198	1577	finally
    //   198	232	1577	finally
    //   304	309	1731	java/lang/Exception
    //   1584	1588	1736	java/lang/Exception
    //   1642	1695	1740	java/lang/Throwable
    //   1614	1618	1744	java/lang/Throwable
    //   1622	1642	1744	java/lang/Throwable
    //   1225	1256	1748	java/lang/Throwable
    //   1265	1312	1748	java/lang/Throwable
    //   443	547	1752	java/lang/Throwable
    //   551	558	1752	java/lang/Throwable
    //   561	716	1752	java/lang/Throwable
    //   716	773	1752	java/lang/Throwable
    //   773	792	1752	java/lang/Throwable
    //   796	845	1752	java/lang/Throwable
    //   845	877	1752	java/lang/Throwable
    //   889	946	1752	java/lang/Throwable
    //   950	1019	1752	java/lang/Throwable
    //   1019	1048	1752	java/lang/Throwable
    //   1048	1077	1752	java/lang/Throwable
    //   1077	1166	1752	java/lang/Throwable
    //   1166	1186	1752	java/lang/Throwable
    //   1596	1604	1752	java/lang/Throwable
    //   232	299	1756	finally
    //   1554	1559	1763	finally
    //   232	299	1770	java/lang/Exception
  }
  
  /* Error */
  public boolean onCrashHandleEnd(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 26
    //   2: iconst_1
    //   3: new 28	java/lang/StringBuilder
    //   6: dup
    //   7: ldc_w 549
    //   10: invokespecial 33	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   13: iload_1
    //   14: invokevirtual 37	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   17: ldc_w 551
    //   20: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokestatic 553	com/tencent/mobileqq/statistics/StatisticCollector:b	()Z
    //   26: invokevirtual 37	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   29: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: invokestatic 553	com/tencent/mobileqq/statistics/StatisticCollector:b	()Z
    //   38: ifeq +10 -> 48
    //   41: iconst_0
    //   42: invokestatic 555	com/tencent/mobileqq/statistics/StatisticCollector:a	(Z)Z
    //   45: pop
    //   46: iconst_1
    //   47: ireturn
    //   48: getstatic 111	com/tencent/common/app/BaseApplicationImpl:processName	Ljava/lang/String;
    //   51: astore_2
    //   52: invokestatic 480	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   55: invokevirtual 558	com/tencent/common/app/BaseApplicationImpl:closeAllActivitys	()V
    //   58: aload_0
    //   59: getfield 12	aikt:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   62: invokestatic 195	com/tencent/mobileqq/statistics/StatisticCollector:a	()Landroid/content/Context;
    //   65: aload_2
    //   66: invokestatic 561	com/tencent/mobileqq/statistics/StatisticCollector:a	(Lcom/tencent/mobileqq/statistics/StatisticCollector;Landroid/content/Context;Ljava/lang/String;)V
    //   69: aload_2
    //   70: ldc_w 563
    //   73: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   76: ifeq +17 -> 93
    //   79: aload_0
    //   80: getfield 12	aikt:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   83: invokevirtual 564	com/tencent/mobileqq/statistics/StatisticCollector:a	()V
    //   86: aload_0
    //   87: getfield 12	aikt:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   90: invokevirtual 565	com/tencent/mobileqq/statistics/StatisticCollector:b	()V
    //   93: aload_2
    //   94: ldc 180
    //   96: invokevirtual 117	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   99: ifne +22 -> 121
    //   102: aload_2
    //   103: ldc 113
    //   105: invokevirtual 117	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   108: ifne +13 -> 121
    //   111: aload_2
    //   112: ldc_w 567
    //   115: invokevirtual 117	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   118: ifeq +18 -> 136
    //   121: aload_0
    //   122: getfield 12	aikt:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   125: invokevirtual 564	com/tencent/mobileqq/statistics/StatisticCollector:a	()V
    //   128: aload_0
    //   129: getfield 12	aikt:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   132: aload_2
    //   133: invokevirtual 569	com/tencent/mobileqq/statistics/StatisticCollector:b	(Ljava/lang/String;)V
    //   136: aload_2
    //   137: ldc 180
    //   139: invokevirtual 117	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   142: ifne +41 -> 183
    //   145: aload_2
    //   146: ldc 113
    //   148: invokevirtual 117	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   151: ifne +32 -> 183
    //   154: aload_2
    //   155: ldc_w 567
    //   158: invokevirtual 117	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   161: ifne +22 -> 183
    //   164: aload_2
    //   165: ldc_w 571
    //   168: invokevirtual 117	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   171: ifne +12 -> 183
    //   174: aload_2
    //   175: ldc 182
    //   177: invokevirtual 117	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   180: ifeq +88 -> 268
    //   183: ldc_w 573
    //   186: iconst_0
    //   187: invokestatic 579	cooperation/qzone/LocalMultiProcConfig:getBool	(Ljava/lang/String;Z)Z
    //   190: ifeq +78 -> 268
    //   193: ldc 26
    //   195: iconst_1
    //   196: new 28	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   203: ldc_w 581
    //   206: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: invokestatic 586	java/lang/System:currentTimeMillis	()J
    //   212: ldc2_w 587
    //   215: ldiv
    //   216: invokevirtual 140	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   219: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   225: new 28	java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   232: ldc_w 590
    //   235: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: aload_0
    //   239: getfield 12	aikt:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   242: getfield 591	com/tencent/mobileqq/statistics/StatisticCollector:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   245: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: invokestatic 586	java/lang/System:currentTimeMillis	()J
    //   254: ldc2_w 587
    //   257: ldiv
    //   258: invokestatic 595	cooperation/qzone/LocalMultiProcConfig:putLong	(Ljava/lang/String;J)V
    //   261: ldc_w 573
    //   264: iconst_0
    //   265: invokestatic 599	cooperation/qzone/LocalMultiProcConfig:putBool	(Ljava/lang/String;Z)V
    //   268: invokestatic 603	com/tencent/mqq/shared_file_accessor/SharedPreferencesProxyManager:getInstance	()Lcom/tencent/mqq/shared_file_accessor/SharedPreferencesProxyManager;
    //   271: invokevirtual 606	com/tencent/mqq/shared_file_accessor/SharedPreferencesProxyManager:trySave	()V
    //   274: aload_2
    //   275: ldc_w 563
    //   278: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   281: ifeq +356 -> 637
    //   284: new 608	android/content/Intent
    //   287: dup
    //   288: ldc_w 610
    //   291: invokespecial 611	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   294: astore_3
    //   295: invokestatic 195	com/tencent/mobileqq/statistics/StatisticCollector:a	()Landroid/content/Context;
    //   298: ldc_w 613
    //   301: invokevirtual 617	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   304: checkcast 619	android/app/ActivityManager
    //   307: invokevirtual 623	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   310: astore 5
    //   312: new 625	java/util/ArrayList
    //   315: dup
    //   316: invokespecial 626	java/util/ArrayList:<init>	()V
    //   319: astore 4
    //   321: aload 5
    //   323: ifnull +274 -> 597
    //   326: aload 5
    //   328: invokeinterface 629 1 0
    //   333: ifle +264 -> 597
    //   336: aload 5
    //   338: invokeinterface 630 1 0
    //   343: astore 5
    //   345: aload 5
    //   347: invokeinterface 500 1 0
    //   352: ifeq +245 -> 597
    //   355: aload 5
    //   357: invokeinterface 503 1 0
    //   362: checkcast 632	android/app/ActivityManager$RunningAppProcessInfo
    //   365: getfield 633	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   368: astore 6
    //   370: aload 6
    //   372: ifnull -27 -> 345
    //   375: aload 6
    //   377: ldc_w 635
    //   380: invokevirtual 638	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   383: ifeq -38 -> 345
    //   386: aload 6
    //   388: ldc_w 640
    //   391: invokevirtual 117	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   394: ifne -49 -> 345
    //   397: aload 4
    //   399: aload 6
    //   401: invokevirtual 643	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   404: pop
    //   405: goto -60 -> 345
    //   408: astore_3
    //   409: aload_3
    //   410: invokevirtual 644	java/lang/Throwable:printStackTrace	()V
    //   413: aload_2
    //   414: ldc_w 563
    //   417: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   420: ifeq +343 -> 763
    //   423: aload_0
    //   424: getfield 12	aikt:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   427: getfield 647	com/tencent/mobileqq/statistics/StatisticCollector:jdField_a_of_type_Boolean	Z
    //   430: ifeq +324 -> 754
    //   433: ldc 26
    //   435: iconst_1
    //   436: new 28	java/lang/StringBuilder
    //   439: dup
    //   440: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   443: ldc_w 649
    //   446: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: aload_0
    //   450: getfield 12	aikt:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   453: getfield 647	com/tencent/mobileqq/statistics/StatisticCollector:jdField_a_of_type_Boolean	Z
    //   456: invokevirtual 37	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   459: ldc_w 651
    //   462: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   468: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   471: invokestatic 195	com/tencent/mobileqq/statistics/StatisticCollector:a	()Landroid/content/Context;
    //   474: ldc_w 613
    //   477: invokevirtual 617	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   480: checkcast 619	android/app/ActivityManager
    //   483: invokevirtual 623	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   486: astore_2
    //   487: aload_2
    //   488: ifnull +253 -> 741
    //   491: aload_2
    //   492: invokeinterface 629 1 0
    //   497: ifle +244 -> 741
    //   500: aload_2
    //   501: invokeinterface 630 1 0
    //   506: astore_2
    //   507: aload_2
    //   508: invokeinterface 500 1 0
    //   513: ifeq +228 -> 741
    //   516: aload_2
    //   517: invokeinterface 503 1 0
    //   522: checkcast 632	android/app/ActivityManager$RunningAppProcessInfo
    //   525: astore_3
    //   526: aload_3
    //   527: getfield 633	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   530: astore 4
    //   532: aload 4
    //   534: ifnull -27 -> 507
    //   537: aload 4
    //   539: ldc_w 635
    //   542: invokevirtual 638	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   545: ifeq -38 -> 507
    //   548: aload 4
    //   550: ldc_w 640
    //   553: invokevirtual 117	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   556: ifne -49 -> 507
    //   559: aload_3
    //   560: getfield 654	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   563: invokestatic 659	android/os/Process:killProcess	(I)V
    //   566: goto -59 -> 507
    //   569: astore_2
    //   570: aload_2
    //   571: invokevirtual 644	java/lang/Throwable:printStackTrace	()V
    //   574: iconst_1
    //   575: ireturn
    //   576: astore_3
    //   577: aload_3
    //   578: invokevirtual 644	java/lang/Throwable:printStackTrace	()V
    //   581: goto -512 -> 69
    //   584: astore_3
    //   585: ldc 26
    //   587: iconst_1
    //   588: ldc_w 661
    //   591: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   594: goto -326 -> 268
    //   597: aload_3
    //   598: ldc_w 663
    //   601: aload 4
    //   603: invokevirtual 667	android/content/Intent:putStringArrayListExtra	(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;
    //   606: pop
    //   607: aload_3
    //   608: ldc_w 669
    //   611: aload 4
    //   613: iconst_0
    //   614: invokestatic 673	com/tencent/common/app/BaseApplicationImpl:getLocalVerify	(Ljava/util/ArrayList;Z)Ljava/lang/String;
    //   617: invokevirtual 677	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   620: pop
    //   621: invokestatic 195	com/tencent/mobileqq/statistics/StatisticCollector:a	()Landroid/content/Context;
    //   624: aload_3
    //   625: invokevirtual 681	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   628: invokestatic 480	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   631: invokevirtual 684	com/tencent/common/app/BaseApplicationImpl:crashed	()V
    //   634: goto -221 -> 413
    //   637: aload_2
    //   638: ldc 180
    //   640: invokevirtual 117	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   643: ifeq +69 -> 712
    //   646: invokestatic 195	com/tencent/mobileqq/statistics/StatisticCollector:a	()Landroid/content/Context;
    //   649: ldc_w 613
    //   652: invokevirtual 617	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   655: checkcast 619	android/app/ActivityManager
    //   658: invokevirtual 623	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   661: invokeinterface 630 1 0
    //   666: astore_3
    //   667: aload_3
    //   668: invokeinterface 500 1 0
    //   673: ifeq -260 -> 413
    //   676: aload_3
    //   677: invokeinterface 503 1 0
    //   682: checkcast 632	android/app/ActivityManager$RunningAppProcessInfo
    //   685: astore 4
    //   687: aload 4
    //   689: getfield 633	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   692: ldc_w 686
    //   695: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   698: ifeq -31 -> 667
    //   701: aload 4
    //   703: getfield 654	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   706: invokestatic 659	android/os/Process:killProcess	(I)V
    //   709: goto -42 -> 667
    //   712: aload_2
    //   713: ldc_w 688
    //   716: invokevirtual 117	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   719: ifne -306 -> 413
    //   722: aload_2
    //   723: ldc_w 690
    //   726: invokevirtual 117	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   729: ifeq -316 -> 413
    //   732: invokestatic 195	com/tencent/mobileqq/statistics/StatisticCollector:a	()Landroid/content/Context;
    //   735: invokestatic 695	com/tencent/tmdownloader/TMAssistantDownloadManager:closeAllService	(Landroid/content/Context;)V
    //   738: goto -325 -> 413
    //   741: invokestatic 480	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   744: iconst_1
    //   745: invokevirtual 699	com/tencent/common/app/BaseApplicationImpl:stopMsfOnCrash	(Z)V
    //   748: invokestatic 702	android/os/Process:myPid	()I
    //   751: invokestatic 659	android/os/Process:killProcess	(I)V
    //   754: invokestatic 480	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   757: iconst_1
    //   758: invokevirtual 705	com/tencent/common/app/BaseApplicationImpl:QQProcessExit	(Z)V
    //   761: iconst_1
    //   762: ireturn
    //   763: aload_2
    //   764: ldc 180
    //   766: invokevirtual 117	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   769: ifne +25 -> 794
    //   772: aload_2
    //   773: ldc_w 707
    //   776: invokevirtual 117	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   779: ifeq +6 -> 785
    //   782: goto +12 -> 794
    //   785: invokestatic 480	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   788: iconst_0
    //   789: invokevirtual 710	com/tencent/common/app/BaseApplicationImpl:otherProcessExit	(Z)V
    //   792: iconst_1
    //   793: ireturn
    //   794: iload_1
    //   795: ifeq -749 -> 46
    //   798: goto -13 -> 785
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	801	0	this	aikt
    //   0	801	1	paramBoolean	boolean
    //   51	466	2	localObject1	Object
    //   569	204	2	localThrowable1	Throwable
    //   294	1	3	localIntent	android.content.Intent
    //   408	2	3	localThrowable2	Throwable
    //   525	35	3	localRunningAppProcessInfo	android.app.ActivityManager.RunningAppProcessInfo
    //   576	2	3	localThrowable3	Throwable
    //   584	41	3	localThrowable4	Throwable
    //   666	11	3	localIterator	java.util.Iterator
    //   319	383	4	localObject2	Object
    //   310	46	5	localObject3	Object
    //   368	32	6	str	String
    // Exception table:
    //   from	to	target	type
    //   268	321	408	java/lang/Throwable
    //   326	345	408	java/lang/Throwable
    //   345	370	408	java/lang/Throwable
    //   375	405	408	java/lang/Throwable
    //   597	634	408	java/lang/Throwable
    //   637	667	408	java/lang/Throwable
    //   667	709	408	java/lang/Throwable
    //   712	738	408	java/lang/Throwable
    //   413	487	569	java/lang/Throwable
    //   491	507	569	java/lang/Throwable
    //   507	532	569	java/lang/Throwable
    //   537	566	569	java/lang/Throwable
    //   741	754	569	java/lang/Throwable
    //   754	761	569	java/lang/Throwable
    //   763	782	569	java/lang/Throwable
    //   785	792	569	java/lang/Throwable
    //   52	69	576	java/lang/Throwable
    //   69	93	584	java/lang/Throwable
    //   93	121	584	java/lang/Throwable
    //   121	136	584	java/lang/Throwable
    //   136	183	584	java/lang/Throwable
    //   183	268	584	java/lang/Throwable
  }
  
  public void onCrashHandleStart(boolean paramBoolean)
  {
    QLog.d("StatisticCollector", 1, "onCrashHandleStart isNativeCrashed=" + paramBoolean);
    try
    {
      StringBuilder localStringBuilder1 = new StringBuilder(128);
      StringBuilder localStringBuilder2 = new StringBuilder().append("topActivity:");
      if (BaseActivity.sTopActivity == null) {}
      int j;
      for (String str1 = "null";; str1 = BaseActivity.sTopActivity.toString())
      {
        str1 = str1;
        localStringBuilder2 = new StringBuilder(128);
        j = StatisticCollector.a(this.a).size();
        int i = Math.min(j, 5);
        while (i > 0)
        {
          String str2 = (String)StatisticCollector.a(this.a).pop();
          if (localStringBuilder2.length() > 0) {
            localStringBuilder2.append("\n--->");
          }
          localStringBuilder2.append(str2);
          i -= 1;
        }
      }
      StatisticCollector.a(this.a).clear();
      localStringBuilder1.append(str1).append("\n");
      localStringBuilder1.append("ActivityInfoStack:size=").append(j).append(",top five were:↓\n--->");
      localStringBuilder1.append(localStringBuilder2).append("\n");
      localStringBuilder1.append("Current mapEvent content is:\n");
      localStringBuilder1.append(StatisticCollector.a(this.a).toString());
      StatisticCollector.a(this.a, localStringBuilder1.toString());
      StatisticCollector.a(this.a).append("Current thread Id=").append(Process.myTid()).append(", Name=").append(Thread.currentThread().getName()).append("\n");
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public boolean onCrashSaving(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    QLog.d("StatisticCollector", 1, "onCrashSaving isNativeCrashed=" + paramBoolean + ", crashType=" + paramString1 + ", crashAddress=" + paramString2 + ", crashTime=" + StatisticCollector.a().format(new Date(paramLong)) + ", curTime=" + StatisticCollector.a().format(new Date(System.currentTimeMillis())));
    if ((!paramBoolean) && ("java.util.concurrent.TimeoutException".equals(paramString1)) && (!TextUtils.isEmpty(paramString3)) && (paramString3.contains("java.lang.Daemons$FinalizerDaemon"))) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      StatisticCollector.a(paramBoolean);
      if (!StatisticCollector.b()) {
        break;
      }
      return false;
    }
    WebpSoLoader.a(paramString3);
    GifSoLoader.a(paramString3);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aikt
 * JD-Core Version:    0.7.0.1
 */