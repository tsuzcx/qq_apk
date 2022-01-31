import android.content.Context;
import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hotpatch.DexPatchInstaller.1;
import com.tencent.hotpatch.PatchResolveForDalvik;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.net.patch.PatchCommonUtil;
import com.tencent.mobileqq.msf.core.net.patch.PatchReporter;
import com.tencent.mobileqq.msf.core.net.patch.PatchSharedPreUtil;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aarg
{
  public static int a;
  public static String a;
  
  static
  {
    jdField_a_of_type_Int = 0;
    jdField_a_of_type_JavaLangString = "";
  }
  
  /* Error */
  @android.annotation.SuppressLint({"UnsafeDynamicallyLoadedCode"})
  private static int a(aarp paramaarp)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 30	aarp:b	()Ljava/lang/String;
    //   4: invokestatic 36	com/tencent/mobileqq/msf/core/net/patch/PatchCommonUtil:getPatchPath	(Ljava/lang/String;)Ljava/lang/String;
    //   7: astore 4
    //   9: new 38	java/io/File
    //   12: dup
    //   13: aload 4
    //   15: invokespecial 42	java/io/File:<init>	(Ljava/lang/String;)V
    //   18: invokevirtual 45	java/io/File:getParent	()Ljava/lang/String;
    //   21: astore 5
    //   23: new 47	com/tencent/commonsdk/zip/QZipFile
    //   26: dup
    //   27: aload 4
    //   29: invokespecial 48	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/lang/String;)V
    //   32: astore 6
    //   34: aload 6
    //   36: astore 4
    //   38: aload 6
    //   40: ldc 50
    //   42: invokevirtual 54	com/tencent/commonsdk/zip/QZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   45: astore 7
    //   47: aload 7
    //   49: ifnull +906 -> 955
    //   52: aload 6
    //   54: astore 4
    //   56: new 38	java/io/File
    //   59: dup
    //   60: aload 5
    //   62: ldc 50
    //   64: invokespecial 57	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: astore 8
    //   69: aload 6
    //   71: astore 4
    //   73: aload 8
    //   75: invokestatic 63	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   78: aload 7
    //   80: invokevirtual 69	java/util/zip/ZipEntry:getCrc	()J
    //   83: lcmp
    //   84: ifne +338 -> 422
    //   87: aload 6
    //   89: astore 4
    //   91: ldc 71
    //   93: iconst_1
    //   94: ldc 73
    //   96: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   99: aload 6
    //   101: astore 4
    //   103: aload 8
    //   105: invokevirtual 82	java/io/File:getPath	()Ljava/lang/String;
    //   108: invokestatic 87	java/lang/System:load	(Ljava/lang/String;)V
    //   111: aload 6
    //   113: astore 4
    //   115: ldc 71
    //   117: iconst_1
    //   118: ldc 89
    //   120: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   123: iconst_1
    //   124: istore_3
    //   125: aload 6
    //   127: astore 4
    //   129: aload 6
    //   131: ldc 91
    //   133: invokevirtual 54	com/tencent/commonsdk/zip/QZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   136: astore 10
    //   138: aload 6
    //   140: astore 4
    //   142: aload 6
    //   144: ldc 93
    //   146: invokevirtual 54	com/tencent/commonsdk/zip/QZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   149: astore 8
    //   151: aload 6
    //   153: astore 4
    //   155: aload 6
    //   157: ldc 95
    //   159: invokevirtual 54	com/tencent/commonsdk/zip/QZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   162: astore 7
    //   164: aload 10
    //   166: ifnull +739 -> 905
    //   169: aload 8
    //   171: ifnull +734 -> 905
    //   174: aload 7
    //   176: ifnull +729 -> 905
    //   179: aload 6
    //   181: astore 4
    //   183: new 38	java/io/File
    //   186: dup
    //   187: aload 5
    //   189: ldc 91
    //   191: invokespecial 57	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   194: astore 11
    //   196: aload 6
    //   198: astore 4
    //   200: new 38	java/io/File
    //   203: dup
    //   204: aload 5
    //   206: ldc 93
    //   208: invokespecial 57	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   211: astore 9
    //   213: aload 6
    //   215: astore 4
    //   217: new 38	java/io/File
    //   220: dup
    //   221: aload 5
    //   223: ldc 95
    //   225: invokespecial 57	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   228: astore 5
    //   230: aload 6
    //   232: astore 4
    //   234: aload_0
    //   235: invokevirtual 99	aarp:c	()Z
    //   238: ifne +722 -> 960
    //   241: aload 6
    //   243: astore 4
    //   245: aload 11
    //   247: invokestatic 63	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   250: aload 10
    //   252: invokevirtual 69	java/util/zip/ZipEntry:getCrc	()J
    //   255: lcmp
    //   256: ifne +445 -> 701
    //   259: aload 6
    //   261: astore 4
    //   263: new 101	java/io/FileInputStream
    //   266: dup
    //   267: aload 11
    //   269: invokespecial 104	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   272: astore_0
    //   273: aload 6
    //   275: astore 4
    //   277: aload 5
    //   279: invokestatic 63	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   282: aload 7
    //   284: invokevirtual 69	java/util/zip/ZipEntry:getCrc	()J
    //   287: lcmp
    //   288: ifne +440 -> 728
    //   291: aload 6
    //   293: astore 4
    //   295: new 101	java/io/FileInputStream
    //   298: dup
    //   299: aload 5
    //   301: invokespecial 104	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   304: astore 5
    //   306: aload 5
    //   308: astore 4
    //   310: aload_0
    //   311: astore 5
    //   313: aload 4
    //   315: astore_0
    //   316: aload 6
    //   318: astore 4
    //   320: aload 9
    //   322: invokestatic 63	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   325: aload 8
    //   327: invokevirtual 69	java/util/zip/ZipEntry:getCrc	()J
    //   330: lcmp
    //   331: ifne +431 -> 762
    //   334: aload 6
    //   336: astore 4
    //   338: new 101	java/io/FileInputStream
    //   341: dup
    //   342: aload 9
    //   344: invokespecial 104	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   347: astore 7
    //   349: aload 6
    //   351: astore 4
    //   353: aload 5
    //   355: aload_0
    //   356: aload 7
    //   358: iload_3
    //   359: invokestatic 110	com/tencent/mobileqq/qfix/Relax:apply	(Ljava/io/InputStream;Ljava/io/InputStream;Ljava/io/InputStream;Z)I
    //   362: istore_1
    //   363: iload_1
    //   364: tableswitch	default:+36 -> 400, 0:+426->790, 1:+449->813, 2:+472->836, 3:+495->859, 4:+518->882
    //   401: sipush 10000
    //   404: iadd
    //   405: istore_2
    //   406: iload_2
    //   407: istore_1
    //   408: aload 6
    //   410: ifnull +10 -> 420
    //   413: aload 6
    //   415: invokevirtual 113	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   418: iload_2
    //   419: istore_1
    //   420: iload_1
    //   421: ireturn
    //   422: aload 6
    //   424: astore 4
    //   426: new 38	java/io/File
    //   429: dup
    //   430: aload 5
    //   432: ldc 115
    //   434: invokespecial 57	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   437: astore 9
    //   439: aload 6
    //   441: astore 4
    //   443: aload 9
    //   445: invokevirtual 118	java/io/File:exists	()Z
    //   448: ifeq +91 -> 539
    //   451: aload 6
    //   453: astore 4
    //   455: aload 9
    //   457: aload 8
    //   459: invokevirtual 122	java/io/File:renameTo	(Ljava/io/File;)Z
    //   462: ifeq +77 -> 539
    //   465: aload 6
    //   467: astore 4
    //   469: aload 8
    //   471: invokestatic 63	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   474: aload 7
    //   476: invokevirtual 69	java/util/zip/ZipEntry:getCrc	()J
    //   479: lcmp
    //   480: ifne +59 -> 539
    //   483: aload 6
    //   485: astore 4
    //   487: ldc 71
    //   489: iconst_1
    //   490: ldc 124
    //   492: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   495: goto -396 -> 99
    //   498: astore 5
    //   500: aload 6
    //   502: astore_0
    //   503: aload_0
    //   504: astore 4
    //   506: ldc 71
    //   508: iconst_1
    //   509: aload 5
    //   511: iconst_0
    //   512: anewarray 4	java/lang/Object
    //   515: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   518: sipush 802
    //   521: istore_1
    //   522: aload_0
    //   523: ifnull -103 -> 420
    //   526: aload_0
    //   527: invokevirtual 113	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   530: sipush 802
    //   533: ireturn
    //   534: astore_0
    //   535: sipush 802
    //   538: ireturn
    //   539: iconst_0
    //   540: istore_1
    //   541: iload_1
    //   542: iconst_3
    //   543: if_icmpge +407 -> 950
    //   546: aload 6
    //   548: astore 4
    //   550: aload 6
    //   552: aload 7
    //   554: invokevirtual 131	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   557: aload 8
    //   559: invokestatic 134	aarg:a	(Ljava/io/InputStream;Ljava/io/File;)V
    //   562: aload 6
    //   564: astore 4
    //   566: aload 8
    //   568: invokestatic 63	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   571: aload 7
    //   573: invokevirtual 69	java/util/zip/ZipEntry:getCrc	()J
    //   576: lcmp
    //   577: ifne +78 -> 655
    //   580: iconst_1
    //   581: istore_1
    //   582: aload 6
    //   584: astore 4
    //   586: ldc 71
    //   588: iconst_1
    //   589: ldc 136
    //   591: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   594: iload_1
    //   595: ifne -496 -> 99
    //   598: sipush 802
    //   601: istore_1
    //   602: aload 6
    //   604: ifnull -184 -> 420
    //   607: aload 6
    //   609: invokevirtual 113	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   612: sipush 802
    //   615: ireturn
    //   616: astore_0
    //   617: sipush 802
    //   620: ireturn
    //   621: astore 9
    //   623: aload 6
    //   625: astore 4
    //   627: ldc 71
    //   629: iconst_1
    //   630: aload 9
    //   632: iconst_0
    //   633: anewarray 4	java/lang/Object
    //   636: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   639: goto -77 -> 562
    //   642: astore_0
    //   643: aload 4
    //   645: ifnull +8 -> 653
    //   648: aload 4
    //   650: invokevirtual 113	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   653: aload_0
    //   654: athrow
    //   655: iload_1
    //   656: iconst_1
    //   657: iadd
    //   658: istore_1
    //   659: goto -118 -> 541
    //   662: astore_0
    //   663: aload 6
    //   665: astore 4
    //   667: ldc 71
    //   669: iconst_1
    //   670: aload_0
    //   671: iconst_0
    //   672: anewarray 4	java/lang/Object
    //   675: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   678: sipush 806
    //   681: istore_1
    //   682: aload 6
    //   684: ifnull -264 -> 420
    //   687: aload 6
    //   689: invokevirtual 113	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   692: sipush 806
    //   695: ireturn
    //   696: astore_0
    //   697: sipush 806
    //   700: ireturn
    //   701: aload 6
    //   703: astore 4
    //   705: ldc 71
    //   707: iconst_1
    //   708: ldc 138
    //   710: invokestatic 141	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   713: aload 6
    //   715: astore 4
    //   717: aload 6
    //   719: aload 10
    //   721: invokevirtual 131	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   724: astore_0
    //   725: goto -452 -> 273
    //   728: aload 6
    //   730: astore 4
    //   732: ldc 71
    //   734: iconst_1
    //   735: ldc 143
    //   737: invokestatic 141	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   740: aload 6
    //   742: astore 4
    //   744: aload 6
    //   746: aload 7
    //   748: invokevirtual 131	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   751: astore 7
    //   753: aload_0
    //   754: astore 5
    //   756: aload 7
    //   758: astore_0
    //   759: goto -443 -> 316
    //   762: aload 6
    //   764: astore 4
    //   766: ldc 71
    //   768: iconst_1
    //   769: ldc 145
    //   771: invokestatic 141	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   774: aload 6
    //   776: astore 4
    //   778: aload 6
    //   780: aload 8
    //   782: invokevirtual 131	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   785: astore 7
    //   787: goto -438 -> 349
    //   790: sipush 800
    //   793: istore_1
    //   794: aload 6
    //   796: ifnull -376 -> 420
    //   799: aload 6
    //   801: invokevirtual 113	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   804: sipush 800
    //   807: ireturn
    //   808: astore_0
    //   809: sipush 800
    //   812: ireturn
    //   813: sipush 803
    //   816: istore_1
    //   817: aload 6
    //   819: ifnull -399 -> 420
    //   822: aload 6
    //   824: invokevirtual 113	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   827: sipush 803
    //   830: ireturn
    //   831: astore_0
    //   832: sipush 803
    //   835: ireturn
    //   836: sipush 805
    //   839: istore_1
    //   840: aload 6
    //   842: ifnull -422 -> 420
    //   845: aload 6
    //   847: invokevirtual 113	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   850: sipush 805
    //   853: ireturn
    //   854: astore_0
    //   855: sipush 805
    //   858: ireturn
    //   859: sipush 801
    //   862: istore_1
    //   863: aload 6
    //   865: ifnull -445 -> 420
    //   868: aload 6
    //   870: invokevirtual 113	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   873: sipush 801
    //   876: ireturn
    //   877: astore_0
    //   878: sipush 801
    //   881: ireturn
    //   882: sipush 802
    //   885: istore_1
    //   886: aload 6
    //   888: ifnull -468 -> 420
    //   891: aload 6
    //   893: invokevirtual 113	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   896: sipush 802
    //   899: ireturn
    //   900: astore_0
    //   901: sipush 802
    //   904: ireturn
    //   905: sipush 804
    //   908: istore_1
    //   909: aload 6
    //   911: ifnull -491 -> 420
    //   914: aload 6
    //   916: invokevirtual 113	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   919: sipush 804
    //   922: ireturn
    //   923: astore_0
    //   924: sipush 804
    //   927: ireturn
    //   928: astore_0
    //   929: iload_2
    //   930: ireturn
    //   931: astore 4
    //   933: goto -280 -> 653
    //   936: astore_0
    //   937: aconst_null
    //   938: astore 4
    //   940: goto -297 -> 643
    //   943: astore 5
    //   945: aconst_null
    //   946: astore_0
    //   947: goto -444 -> 503
    //   950: iconst_0
    //   951: istore_1
    //   952: goto -358 -> 594
    //   955: iconst_0
    //   956: istore_3
    //   957: goto -832 -> 125
    //   960: aconst_null
    //   961: astore 5
    //   963: aconst_null
    //   964: astore_0
    //   965: goto -649 -> 316
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	968	0	paramaarp	aarp
    //   362	590	1	i	int
    //   405	525	2	j	int
    //   124	833	3	bool	boolean
    //   7	770	4	localObject1	Object
    //   931	1	4	localIOException	java.io.IOException
    //   938	1	4	localObject2	Object
    //   21	410	5	localObject3	Object
    //   498	12	5	localThrowable1	Throwable
    //   754	1	5	localaarp	aarp
    //   943	1	5	localThrowable2	Throwable
    //   961	1	5	localObject4	Object
    //   32	883	6	localQZipFile	com.tencent.commonsdk.zip.QZipFile
    //   45	741	7	localObject5	Object
    //   67	714	8	localObject6	Object
    //   211	245	9	localFile1	File
    //   621	10	9	localThrowable3	Throwable
    //   136	584	10	localZipEntry	java.util.zip.ZipEntry
    //   194	74	11	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   38	47	498	java/lang/Throwable
    //   56	69	498	java/lang/Throwable
    //   73	87	498	java/lang/Throwable
    //   91	99	498	java/lang/Throwable
    //   129	138	498	java/lang/Throwable
    //   142	151	498	java/lang/Throwable
    //   155	164	498	java/lang/Throwable
    //   183	196	498	java/lang/Throwable
    //   200	213	498	java/lang/Throwable
    //   217	230	498	java/lang/Throwable
    //   234	241	498	java/lang/Throwable
    //   245	259	498	java/lang/Throwable
    //   263	273	498	java/lang/Throwable
    //   277	291	498	java/lang/Throwable
    //   295	306	498	java/lang/Throwable
    //   320	334	498	java/lang/Throwable
    //   338	349	498	java/lang/Throwable
    //   353	363	498	java/lang/Throwable
    //   426	439	498	java/lang/Throwable
    //   443	451	498	java/lang/Throwable
    //   455	465	498	java/lang/Throwable
    //   469	483	498	java/lang/Throwable
    //   487	495	498	java/lang/Throwable
    //   566	580	498	java/lang/Throwable
    //   586	594	498	java/lang/Throwable
    //   627	639	498	java/lang/Throwable
    //   667	678	498	java/lang/Throwable
    //   705	713	498	java/lang/Throwable
    //   717	725	498	java/lang/Throwable
    //   732	740	498	java/lang/Throwable
    //   744	753	498	java/lang/Throwable
    //   766	774	498	java/lang/Throwable
    //   778	787	498	java/lang/Throwable
    //   526	530	534	java/io/IOException
    //   607	612	616	java/io/IOException
    //   550	562	621	java/lang/Throwable
    //   38	47	642	finally
    //   56	69	642	finally
    //   73	87	642	finally
    //   91	99	642	finally
    //   103	111	642	finally
    //   115	123	642	finally
    //   129	138	642	finally
    //   142	151	642	finally
    //   155	164	642	finally
    //   183	196	642	finally
    //   200	213	642	finally
    //   217	230	642	finally
    //   234	241	642	finally
    //   245	259	642	finally
    //   263	273	642	finally
    //   277	291	642	finally
    //   295	306	642	finally
    //   320	334	642	finally
    //   338	349	642	finally
    //   353	363	642	finally
    //   426	439	642	finally
    //   443	451	642	finally
    //   455	465	642	finally
    //   469	483	642	finally
    //   487	495	642	finally
    //   506	518	642	finally
    //   550	562	642	finally
    //   566	580	642	finally
    //   586	594	642	finally
    //   627	639	642	finally
    //   667	678	642	finally
    //   705	713	642	finally
    //   717	725	642	finally
    //   732	740	642	finally
    //   744	753	642	finally
    //   766	774	642	finally
    //   778	787	642	finally
    //   103	111	662	java/lang/Throwable
    //   115	123	662	java/lang/Throwable
    //   687	692	696	java/io/IOException
    //   799	804	808	java/io/IOException
    //   822	827	831	java/io/IOException
    //   845	850	854	java/io/IOException
    //   868	873	877	java/io/IOException
    //   891	896	900	java/io/IOException
    //   914	919	923	java/io/IOException
    //   413	418	928	java/io/IOException
    //   648	653	931	java/io/IOException
    //   0	34	936	finally
    //   0	34	943	java/lang/Throwable
  }
  
  private static void a(aarp paramaarp)
  {
    long l = System.currentTimeMillis();
    try
    {
      paramaarp = paramaarp.b();
      String str = PatchCommonUtil.getPatchPath(paramaarp);
      if ("Success".equals(alys.a(BaseApplicationImpl.sApplication, str, null, false)))
      {
        jdField_a_of_type_Int = 500;
        jdField_a_of_type_JavaLangString = paramaarp;
      }
      for (;;)
      {
        QLog.d("PatchLogTag", 1, "DexPatchInstaller injectDexPatch result=" + jdField_a_of_type_Int + ", inject cost time=" + (System.currentTimeMillis() - l) + " ms.");
        return;
        jdField_a_of_type_Int = 501;
      }
    }
    catch (Throwable paramaarp)
    {
      for (;;)
      {
        jdField_a_of_type_Int = 502;
        QLog.d("PatchLogTag", 1, "DexPatchInstaller injectDexPatch throwable=" + paramaarp);
      }
    }
  }
  
  public static void a(Context paramContext)
  {
    long l = System.currentTimeMillis();
    aarp localaarp = aarq.a(paramContext, "dex");
    if ((jdField_a_of_type_Int == 0) && (a(paramContext, localaarp)))
    {
      a(localaarp);
      int j;
      if (jdField_a_of_type_Int == 500) {
        if ((localaarp.b()) && (PatchCommonUtil.isArtGeN()) && (!SoLoadUtil.a()))
        {
          j = a(localaarp);
          i = j;
          if (j != 800)
          {
            String str = alys.a(BaseApplicationImpl.sApplication, 0);
            QLog.d("PatchLogTag", 1, "applyRelaxPatch failed, unloadResult=" + str);
            i = j;
            if ("Success".equals(str))
            {
              jdField_a_of_type_Int = 0;
              jdField_a_of_type_JavaLangString = "";
            }
          }
        }
      }
      for (int i = j;; i = 0)
      {
        a(paramContext, localaarp);
        PatchReporter.reportPatchEvent(paramContext, "", "actPatchInstall", jdField_a_of_type_Int, localaarp.b(), i);
        QLog.d("PatchLogTag", 1, "DexPatchInstaller installDexPatch total cost time=" + (System.currentTimeMillis() - l) + " ms.");
        return;
        if (PatchCommonUtil.isDalvik()) {
          PatchResolveForDalvik.a(paramContext, localaarp);
        }
      }
    }
    QLog.d("PatchLogTag", 1, "DexPatchInstaller installDexPatch Not inject patch, status=" + jdField_a_of_type_Int);
  }
  
  private static void a(Context paramContext, aarp paramaarp)
  {
    paramContext = new DexPatchInstaller.1(paramaarp, paramContext);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      ThreadManager.post(paramContext, 5, null, true);
      return;
    }
    paramContext.run();
  }
  
  /* Error */
  public static void a(java.io.InputStream paramInputStream, File paramFile)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 282	java/io/File:getParentFile	()Ljava/io/File;
    //   4: invokevirtual 285	java/io/File:mkdirs	()Z
    //   7: pop
    //   8: new 287	java/io/FileOutputStream
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 288	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   16: astore_3
    //   17: sipush 4096
    //   20: newarray byte
    //   22: astore_1
    //   23: aload_0
    //   24: aload_1
    //   25: invokevirtual 294	java/io/InputStream:read	([B)I
    //   28: istore_2
    //   29: iload_2
    //   30: ifle +32 -> 62
    //   33: aload_3
    //   34: aload_1
    //   35: iconst_0
    //   36: iload_2
    //   37: invokevirtual 300	java/io/OutputStream:write	([BII)V
    //   40: goto -17 -> 23
    //   43: astore_1
    //   44: aload_0
    //   45: ifnull +7 -> 52
    //   48: aload_0
    //   49: invokevirtual 301	java/io/InputStream:close	()V
    //   52: aload_3
    //   53: ifnull +7 -> 60
    //   56: aload_3
    //   57: invokevirtual 302	java/io/OutputStream:close	()V
    //   60: aload_1
    //   61: athrow
    //   62: aload_0
    //   63: ifnull +7 -> 70
    //   66: aload_0
    //   67: invokevirtual 301	java/io/InputStream:close	()V
    //   70: aload_3
    //   71: ifnull +7 -> 78
    //   74: aload_3
    //   75: invokevirtual 302	java/io/OutputStream:close	()V
    //   78: return
    //   79: astore_0
    //   80: goto -10 -> 70
    //   83: astore_0
    //   84: return
    //   85: astore_0
    //   86: goto -34 -> 52
    //   89: astore_0
    //   90: goto -30 -> 60
    //   93: astore_1
    //   94: aconst_null
    //   95: astore_3
    //   96: goto -52 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	paramInputStream	java.io.InputStream
    //   0	99	1	paramFile	File
    //   28	9	2	i	int
    //   16	80	3	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   17	23	43	finally
    //   23	29	43	finally
    //   33	40	43	finally
    //   66	70	79	java/io/IOException
    //   74	78	83	java/io/IOException
    //   48	52	85	java/io/IOException
    //   56	60	89	java/io/IOException
    //   8	17	93	finally
  }
  
  private static boolean a(Context paramContext, aarp paramaarp)
  {
    if (paramaarp == null) {
      QLog.d("PatchLogTag", 1, "DexPatchInstaller checkDexPatchConfigAndStatus patch config is null");
    }
    while (!paramaarp.a(paramContext, true)) {
      return false;
    }
    String str = paramaarp.b();
    File localFile = new File(PatchCommonUtil.getPatchPath(str));
    if (!localFile.exists())
    {
      QLog.d("PatchLogTag", 1, "DexPatchInstaller checkDexPatchConfigAndStatus patch file not exist");
      return false;
    }
    if (localFile.length() != paramaarp.b())
    {
      QLog.d("PatchLogTag", 1, "DexPatchInstaller checkDexPatchConfigAndStatus patch file length not match");
      return false;
    }
    if (!PatchSharedPreUtil.getPatchVerifyStatus(paramContext, str))
    {
      QLog.d("PatchLogTag", 1, "DexPatchInstaller checkDexPatchConfigAndStatus verify failed");
      return false;
    }
    if (PatchSharedPreUtil.getCountFailInstallPatch(paramContext, BaseApplicationImpl.processName, str) >= 3)
    {
      QLog.d("PatchLogTag", 1, "DexPatchInstaller checkDexPatchConfigAndStatus install patch failed max count");
      return false;
    }
    if (PatchSharedPreUtil.getCountFailStartupPatch(paramContext, BaseApplicationImpl.processName, str) > 5)
    {
      jdField_a_of_type_Int = 503;
      PatchReporter.reportPatchEvent(paramContext, "", "actPatchInstall", 503, str);
      QLog.d("PatchLogTag", 1, "DexPatchInstaller checkDexPatchConfigAndStatus start failed max count as install patch");
      return false;
    }
    QLog.d("PatchLogTag", 1, "DexPatchInstaller checkDexPatchConfigAndStatus return true");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aarg
 * JD-Core Version:    0.7.0.1
 */