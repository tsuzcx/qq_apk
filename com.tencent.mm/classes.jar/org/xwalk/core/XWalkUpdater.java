package org.xwalk.core;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.content.res.AssetFileDescriptor;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.XWebCoreContentProvider;
import com.tencent.xweb.a;
import com.tencent.xweb.ai;
import com.tencent.xweb.s;
import com.tencent.xweb.util.BSpatch;
import com.tencent.xweb.util.d;
import com.tencent.xweb.util.g;
import com.tencent.xweb.util.h;
import com.tencent.xweb.xwalk.p;
import com.tencent.xweb.xwalk.u;
import com.tencent.xweb.xwalk.updater.Scheduler;
import com.tencent.xweb.xwalk.updater.XWebCoreScheduler;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class XWalkUpdater
{
  private static final String ANDROID_MARKET_DETAILS = "market://details?id=";
  public static final int ERROR_DOPATCH_FAILED = -3;
  public static final int ERROR_DOPATCH_MD5_FAILED = -4;
  public static final int ERROR_DOWNLOAD_FAILED = -1;
  public static final int ERROR_DOWNLOAD_MD5_FAILED = -2;
  public static final int ERROR_EXTRACT_RESOURCE_FAILED = -5;
  public static final int ERROR_EXTRACT_RESOURCE_FAILED_FOR_RETRY = -12;
  public static final int ERROR_NONE = 0;
  public static final int ERROR_SET_VERNUM = -101;
  public static final int ERROR_SHARED_MODE_EXCEED_MAX_COUNT = -7;
  public static final int ERROR_SHARED_MODE_FORCE_DOWNLOAD = -6;
  public static final int ERROR_SHARED_MODE_NO_CONTENT_RESOLVER = -8;
  public static final int ERROR_SHARED_MODE_NO_PROVIDER = -9;
  public static final int ERROR_SHARED_MODE_OTHER = -11;
  public static final int ERROR_SHARED_MODE_TRY_AGAIN = -10;
  private static final String GOOGLE_PLAY_PACKAGE = "com.android.vending";
  static final String INSTALLED_EMBED_VERSION = "INSTALLED_EMBED_VERSION";
  private static final int RES_EXTRACTOR_MAXTIMES = 1;
  private static final String TAG = "XWalkLib";
  public static final int UPDATE_BIZ_TYPE_RUNTIME_PACKAGE = 1;
  public static final int UPDATE_BIZ_TYPE_RUNTIME_PATCH = 2;
  private static int mCurrentTimeForRetryRes = 0;
  static boolean sBTryedInstallFromEmbed = false;
  private XWalkBackgroundUpdateListener mBackgroundUpdateListener;
  private Runnable mCancelCommand;
  private Context mContext;
  private XWalkDialogManager mDialogManager;
  private Runnable mDownloadCommand;
  private XWalkUpdateListener mUpdateListener;
  
  public XWalkUpdater(XWalkBackgroundUpdateListener paramXWalkBackgroundUpdateListener, Context paramContext)
  {
    this.mBackgroundUpdateListener = paramXWalkBackgroundUpdateListener;
    this.mContext = paramContext;
  }
  
  public XWalkUpdater(XWalkUpdateListener paramXWalkUpdateListener, Context paramContext)
  {
    AppMethodBeat.i(155020);
    this.mUpdateListener = paramXWalkUpdateListener;
    this.mContext = paramContext;
    this.mDialogManager = new XWalkDialogManager(paramContext);
    AppMethodBeat.o(155020);
  }
  
  public XWalkUpdater(XWalkUpdateListener paramXWalkUpdateListener, Context paramContext, XWalkDialogManager paramXWalkDialogManager)
  {
    this.mUpdateListener = paramXWalkUpdateListener;
    this.mContext = paramContext;
    this.mDialogManager = paramXWalkDialogManager;
  }
  
  /* Error */
  public static boolean checkExtractResFileLengtgAndMd5(String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: ldc 145
    //   2: invokestatic 125	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 147	java/io/File
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 150	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_3
    //   14: aload_3
    //   15: invokevirtual 154	java/io/File:exists	()Z
    //   18: ifne +106 -> 124
    //   21: iload_2
    //   22: invokestatic 160	org/xwalk/core/XWalkEnvironment:isTestVersion	(I)Z
    //   25: ifne +750 -> 775
    //   28: iload_2
    //   29: sipush 362
    //   32: if_icmpge +31 -> 63
    //   35: goto +740 -> 775
    //   38: iload_2
    //   39: ifeq +29 -> 68
    //   42: ldc 85
    //   44: ldc 162
    //   46: aload_0
    //   47: invokestatic 168	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   50: invokevirtual 172	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   53: invokestatic 178	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: ldc 145
    //   58: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: iconst_1
    //   62: ireturn
    //   63: iconst_0
    //   64: istore_2
    //   65: goto -27 -> 38
    //   68: ldc2_w 179
    //   71: invokestatic 186	com/tencent/xweb/util/g:FJ	(J)V
    //   74: ldc 85
    //   76: ldc 188
    //   78: aload_0
    //   79: invokestatic 168	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   82: invokevirtual 172	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   85: invokestatic 178	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: ldc 190
    //   90: ldc 192
    //   92: ldc 194
    //   94: invokestatic 200	com/tencent/xweb/a:nb	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   97: invokevirtual 204	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   100: ifeq +17 -> 117
    //   103: ldc 85
    //   105: ldc 206
    //   107: invokestatic 178	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: ldc 145
    //   112: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: iconst_1
    //   116: ireturn
    //   117: ldc 145
    //   119: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: iconst_0
    //   123: ireturn
    //   124: new 208	java/io/FileInputStream
    //   127: dup
    //   128: aload_3
    //   129: invokespecial 211	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   132: astore 4
    //   134: new 213	java/io/InputStreamReader
    //   137: dup
    //   138: aload 4
    //   140: invokespecial 216	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   143: astore_3
    //   144: new 218	java/io/BufferedReader
    //   147: dup
    //   148: aload_3
    //   149: invokespecial 221	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   152: astore_0
    //   153: aload_0
    //   154: astore 7
    //   156: aload_3
    //   157: astore 6
    //   159: aload 4
    //   161: astore 5
    //   163: aload_0
    //   164: invokevirtual 225	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   167: astore 8
    //   169: aload 8
    //   171: ifnull +312 -> 483
    //   174: aload 8
    //   176: ifnull -23 -> 153
    //   179: aload_0
    //   180: astore 7
    //   182: aload_3
    //   183: astore 6
    //   185: aload 4
    //   187: astore 5
    //   189: aload 8
    //   191: invokevirtual 228	java/lang/String:isEmpty	()Z
    //   194: ifne -41 -> 153
    //   197: aload_0
    //   198: astore 7
    //   200: aload_3
    //   201: astore 6
    //   203: aload 4
    //   205: astore 5
    //   207: aload 8
    //   209: ldc 230
    //   211: invokevirtual 234	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   214: astore 8
    //   216: aload 8
    //   218: ifnull -65 -> 153
    //   221: aload_0
    //   222: astore 7
    //   224: aload_3
    //   225: astore 6
    //   227: aload 4
    //   229: astore 5
    //   231: aload 8
    //   233: arraylength
    //   234: iconst_2
    //   235: if_icmpne -82 -> 153
    //   238: aload 8
    //   240: iconst_0
    //   241: aaload
    //   242: ifnull -89 -> 153
    //   245: aload_0
    //   246: astore 7
    //   248: aload_3
    //   249: astore 6
    //   251: aload 4
    //   253: astore 5
    //   255: aload 8
    //   257: iconst_0
    //   258: aaload
    //   259: invokevirtual 228	java/lang/String:isEmpty	()Z
    //   262: ifne -109 -> 153
    //   265: aload 8
    //   267: iconst_1
    //   268: aaload
    //   269: ifnull -116 -> 153
    //   272: aload_0
    //   273: astore 7
    //   275: aload_3
    //   276: astore 6
    //   278: aload 4
    //   280: astore 5
    //   282: aload 8
    //   284: iconst_1
    //   285: aaload
    //   286: invokevirtual 228	java/lang/String:isEmpty	()Z
    //   289: ifne -136 -> 153
    //   292: aload_0
    //   293: astore 7
    //   295: aload_3
    //   296: astore 6
    //   298: aload 4
    //   300: astore 5
    //   302: new 147	java/io/File
    //   305: dup
    //   306: aload_1
    //   307: aload 8
    //   309: iconst_0
    //   310: aaload
    //   311: invokespecial 236	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   314: astore 9
    //   316: aload_0
    //   317: astore 7
    //   319: aload_3
    //   320: astore 6
    //   322: aload 4
    //   324: astore 5
    //   326: aload 9
    //   328: invokestatic 242	com/tencent/xweb/util/d:C	(Ljava/io/File;)Ljava/lang/String;
    //   331: astore 10
    //   333: aload_0
    //   334: astore 7
    //   336: aload_3
    //   337: astore 6
    //   339: aload 4
    //   341: astore 5
    //   343: aload 10
    //   345: aload 8
    //   347: iconst_1
    //   348: aaload
    //   349: invokevirtual 204	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   352: ifne -199 -> 153
    //   355: aload_0
    //   356: astore 7
    //   358: aload_3
    //   359: astore 6
    //   361: aload 4
    //   363: astore 5
    //   365: ldc 85
    //   367: new 244	java/lang/StringBuilder
    //   370: dup
    //   371: ldc 246
    //   373: invokespecial 247	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   376: aload 8
    //   378: iconst_0
    //   379: aaload
    //   380: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: ldc 253
    //   385: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: aload 8
    //   390: iconst_1
    //   391: aaload
    //   392: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: ldc 255
    //   397: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: aload 10
    //   402: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   408: invokestatic 178	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   411: aload_0
    //   412: astore 7
    //   414: aload_3
    //   415: astore 6
    //   417: aload 4
    //   419: astore 5
    //   421: aload 9
    //   423: invokevirtual 261	java/io/File:delete	()Z
    //   426: pop
    //   427: aload 4
    //   429: invokevirtual 264	java/io/FileInputStream:close	()V
    //   432: aload_3
    //   433: invokevirtual 265	java/io/InputStreamReader:close	()V
    //   436: aload_0
    //   437: invokevirtual 266	java/io/BufferedReader:close	()V
    //   440: ldc 145
    //   442: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   445: iconst_0
    //   446: ireturn
    //   447: astore_1
    //   448: ldc 85
    //   450: ldc_w 268
    //   453: invokestatic 273	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   456: goto -24 -> 432
    //   459: astore_1
    //   460: ldc 85
    //   462: ldc_w 275
    //   465: invokestatic 273	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   468: goto -32 -> 436
    //   471: astore_0
    //   472: ldc 85
    //   474: ldc_w 277
    //   477: invokestatic 273	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   480: goto -40 -> 440
    //   483: aload 4
    //   485: invokevirtual 264	java/io/FileInputStream:close	()V
    //   488: aload_3
    //   489: invokevirtual 265	java/io/InputStreamReader:close	()V
    //   492: aload_0
    //   493: invokevirtual 266	java/io/BufferedReader:close	()V
    //   496: ldc 145
    //   498: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   501: iconst_1
    //   502: ireturn
    //   503: astore_1
    //   504: ldc 85
    //   506: ldc_w 268
    //   509: invokestatic 273	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   512: goto -24 -> 488
    //   515: astore_1
    //   516: ldc 85
    //   518: ldc_w 275
    //   521: invokestatic 273	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   524: goto -32 -> 492
    //   527: astore_0
    //   528: ldc 85
    //   530: ldc_w 277
    //   533: invokestatic 273	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   536: goto -40 -> 496
    //   539: astore_1
    //   540: aconst_null
    //   541: astore_0
    //   542: aconst_null
    //   543: astore_3
    //   544: aconst_null
    //   545: astore 4
    //   547: aload_0
    //   548: astore 7
    //   550: aload_3
    //   551: astore 6
    //   553: aload 4
    //   555: astore 5
    //   557: ldc 85
    //   559: new 244	java/lang/StringBuilder
    //   562: dup
    //   563: ldc_w 279
    //   566: invokespecial 247	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   569: aload_1
    //   570: invokevirtual 282	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   573: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   579: invokestatic 273	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   582: aload 4
    //   584: ifnull +8 -> 592
    //   587: aload 4
    //   589: invokevirtual 264	java/io/FileInputStream:close	()V
    //   592: aload_3
    //   593: ifnull +7 -> 600
    //   596: aload_3
    //   597: invokevirtual 265	java/io/InputStreamReader:close	()V
    //   600: aload_0
    //   601: ifnull +7 -> 608
    //   604: aload_0
    //   605: invokevirtual 266	java/io/BufferedReader:close	()V
    //   608: ldc 145
    //   610: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   613: iconst_0
    //   614: ireturn
    //   615: astore_1
    //   616: ldc 85
    //   618: ldc_w 268
    //   621: invokestatic 273	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   624: goto -32 -> 592
    //   627: astore_1
    //   628: ldc 85
    //   630: ldc_w 275
    //   633: invokestatic 273	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   636: goto -36 -> 600
    //   639: astore_0
    //   640: ldc 85
    //   642: ldc_w 277
    //   645: invokestatic 273	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   648: goto -40 -> 608
    //   651: astore_0
    //   652: aconst_null
    //   653: astore_1
    //   654: aconst_null
    //   655: astore_3
    //   656: aconst_null
    //   657: astore 4
    //   659: aload 4
    //   661: ifnull +8 -> 669
    //   664: aload 4
    //   666: invokevirtual 264	java/io/FileInputStream:close	()V
    //   669: aload_3
    //   670: ifnull +7 -> 677
    //   673: aload_3
    //   674: invokevirtual 265	java/io/InputStreamReader:close	()V
    //   677: aload_1
    //   678: ifnull +7 -> 685
    //   681: aload_1
    //   682: invokevirtual 266	java/io/BufferedReader:close	()V
    //   685: ldc 145
    //   687: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   690: aload_0
    //   691: athrow
    //   692: astore 4
    //   694: ldc 85
    //   696: ldc_w 268
    //   699: invokestatic 273	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   702: goto -33 -> 669
    //   705: astore_3
    //   706: ldc 85
    //   708: ldc_w 275
    //   711: invokestatic 273	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   714: goto -37 -> 677
    //   717: astore_1
    //   718: ldc 85
    //   720: ldc_w 277
    //   723: invokestatic 273	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   726: goto -41 -> 685
    //   729: astore_0
    //   730: aconst_null
    //   731: astore_1
    //   732: aconst_null
    //   733: astore_3
    //   734: goto -75 -> 659
    //   737: astore_0
    //   738: aconst_null
    //   739: astore_1
    //   740: goto -81 -> 659
    //   743: astore_0
    //   744: aload 7
    //   746: astore_1
    //   747: aload 6
    //   749: astore_3
    //   750: aload 5
    //   752: astore 4
    //   754: goto -95 -> 659
    //   757: astore_1
    //   758: aconst_null
    //   759: astore_0
    //   760: aconst_null
    //   761: astore_3
    //   762: goto -215 -> 547
    //   765: astore_1
    //   766: aconst_null
    //   767: astore_0
    //   768: goto -221 -> 547
    //   771: astore_1
    //   772: goto -225 -> 547
    //   775: iconst_1
    //   776: istore_2
    //   777: goto -739 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	780	0	paramString1	String
    //   0	780	1	paramString2	String
    //   0	780	2	paramInt	int
    //   13	661	3	localObject1	Object
    //   705	1	3	localException1	Exception
    //   733	29	3	localObject2	Object
    //   132	533	4	localFileInputStream1	java.io.FileInputStream
    //   692	1	4	localException2	Exception
    //   752	1	4	localObject3	Object
    //   161	590	5	localFileInputStream2	java.io.FileInputStream
    //   157	591	6	localObject4	Object
    //   154	591	7	str1	String
    //   167	222	8	localObject5	Object
    //   314	108	9	localFile	File
    //   331	70	10	str2	String
    // Exception table:
    //   from	to	target	type
    //   427	432	447	java/lang/Exception
    //   432	436	459	java/lang/Exception
    //   436	440	471	java/lang/Exception
    //   483	488	503	java/lang/Exception
    //   488	492	515	java/lang/Exception
    //   492	496	527	java/lang/Exception
    //   5	28	539	java/lang/Exception
    //   42	56	539	java/lang/Exception
    //   68	110	539	java/lang/Exception
    //   124	134	539	java/lang/Exception
    //   587	592	615	java/lang/Exception
    //   596	600	627	java/lang/Exception
    //   604	608	639	java/lang/Exception
    //   5	28	651	finally
    //   42	56	651	finally
    //   68	110	651	finally
    //   124	134	651	finally
    //   664	669	692	java/lang/Exception
    //   673	677	705	java/lang/Exception
    //   681	685	717	java/lang/Exception
    //   134	144	729	finally
    //   144	153	737	finally
    //   163	169	743	finally
    //   189	197	743	finally
    //   207	216	743	finally
    //   231	238	743	finally
    //   255	265	743	finally
    //   282	292	743	finally
    //   302	316	743	finally
    //   326	333	743	finally
    //   343	355	743	finally
    //   365	411	743	finally
    //   421	427	743	finally
    //   557	582	743	finally
    //   134	144	757	java/lang/Exception
    //   144	153	765	java/lang/Exception
    //   163	169	771	java/lang/Exception
    //   189	197	771	java/lang/Exception
    //   207	216	771	java/lang/Exception
    //   231	238	771	java/lang/Exception
    //   255	265	771	java/lang/Exception
    //   282	292	771	java/lang/Exception
    //   302	316	771	java/lang/Exception
    //   326	333	771	java/lang/Exception
    //   343	355	771	java/lang/Exception
    //   365	411	771	java/lang/Exception
    //   421	427	771	java/lang/Exception
  }
  
  public static void clearLastTryEmebedVersion()
  {
    AppMethodBeat.i(207655);
    getSpForEmbedInstall("armeabi-v7a").edit().putInt("INSTALLED_EMBED_VERSION", -1).commit();
    getSpForEmbedInstall("arm64-v8a").edit().putInt("INSTALLED_EMBED_VERSION", -1).commit();
    XWalkEnvironment.addXWalkInitializeLog("EMBED_INSTALLER", "do clearLastTryEmebedVersion");
    AppMethodBeat.o(207655);
  }
  
  public static void doInstallFromEmebed()
  {
    i = -1;
    AppMethodBeat.i(207658);
    int j = getLastTryInstallVer(XWalkEnvironment.getRuntimeAbi());
    SharedPreferences localSharedPreferences = getSpForEmbedInstall(XWalkEnvironment.getRuntimeAbi());
    for (;;)
    {
      try
      {
        XWalkEnvironment.is64BitRuntime();
      }
      catch (Exception localException2)
      {
        LibUpdateConfig localLibUpdateConfig;
        continue;
        switch (i)
        {
        }
        Object localObject2 = null;
        continue;
      }
      try
      {
        if (XWalkEnvironment.getInstalledNewstVersion(XWalkEnvironment.getRuntimeAbi()) >= 0)
        {
          XWalkEnvironment.addXWalkInitializeLog("EMBED_INSTALLER", "install stopped this version too old ");
          localSharedPreferences.edit().putInt("INSTALLED_EMBED_VERSION", 0).commit();
          AppMethodBeat.o(207658);
          return;
        }
        if (j == 0)
        {
          XWalkEnvironment.addXWalkInitializeLog("EMBED_INSTALLER", "install skip ,this version was tried");
          AppMethodBeat.o(207658);
          return;
        }
        XWalkEnvironment.addXWalkInitializeLog("EMBED_INSTALLER", "type:LIBabi:LIBversion:0verstion des:" + "1.0.0_from_lib" + "filename:" + "libxwebfullpack.so");
        switch ("LIB".hashCode())
        {
        case 75365: 
          if (localLibUpdateConfig != null) {
            continue;
          }
          XWalkEnvironment.addXWalkInitializeLog("EMBED_INSTALLER", "not recongniezed install type");
          AppMethodBeat.o(207658);
          return;
        }
      }
      catch (Exception localException1)
      {
        i = 0;
        g.t(903L, 128L, 1L);
        XWalkEnvironment.addXWalkInitializeLog("EMBEDED_INSTALLER", "install failed " + localException1.getMessage());
        localSharedPreferences.edit().putInt("INSTALLED_EMBED_VERSION", i).commit();
        AppMethodBeat.o(207658);
        return;
      }
      if (!"LIB".equals("LIB")) {
        continue;
      }
      i = 0;
      continue;
      if (!"LIB".equals("ASSET")) {
        continue;
      }
      i = 1;
      continue;
      if (!"LIB".equals("HYBRID")) {
        continue;
      }
      i = 2;
      continue;
      localLibUpdateConfig = new LibUpdateConfig(0, "libxwebfullpack.so", "1");
    }
    for (;;)
    {
      Object localObject1 = new AssetsUpdateConfig(0, "libxwebfullpack.so", "1");
      break;
      localObject1 = new HybridUpdateConfig(0, "libxwebfullpack.so", "1");
      break;
      if (!((EmbededUpdateConfig)localObject1).copySuc())
      {
        g.t(903L, 126L, 1L);
        XWalkEnvironment.addXWalkInitializeLog("EMBED_INSTALLER", "copy failed");
        AppMethodBeat.o(207658);
        return;
      }
      ((EmbededUpdateConfig)localObject1).getDownloadPath();
      ((EmbededUpdateConfig)localObject1).versionDetail = "1.0.0_from_lib";
      localObject1 = onHandleFile((UpdateConfig)localObject1);
      if (((Integer)localObject1).intValue() == 0)
      {
        g.t(903L, 127L, 1L);
        s.init();
        p.hu("finished", 0);
        XWalkEnvironment.refreshAvailableVersion();
      }
      XWalkEnvironment.addXWalkInitializeLog("EMBEDED_INSTALLER", "install from embed ret code =  ".concat(String.valueOf(localObject1)));
      i = 0;
    }
  }
  
  private static Integer extractResource(UpdateConfig paramUpdateConfig)
  {
    AppMethodBeat.i(155031);
    for (;;)
    {
      String str = XWalkEnvironment.getExtractedCoreDir(paramUpdateConfig.apkVer);
      if (!XWalkDecompressor.extractResource(XWalkEnvironment.getDownloadApkPath(paramUpdateConfig.apkVer), str))
      {
        XWalkInitializer.addXWalkInitializeLog("XWalkLib", "extract faield");
        AppMethodBeat.o(155031);
        return Integer.valueOf(-5);
      }
      if (checkExtractResFileLengtgAndMd5(XWalkEnvironment.getDownloadResFileListConfig(paramUpdateConfig.apkVer), str, paramUpdateConfig.apkVer) == true)
      {
        XWalkInitializer.addXWalkInitializeLog("XWalkLib", "checkExtractResFileLengtgAndMd5 success!!!!");
        try_generate_jar_for_dex_in_dir(str, true);
        if (generateOptDex(paramUpdateConfig.apkVer)) {
          break label185;
        }
        g.FJ(251L);
        if (!"true".equalsIgnoreCase(a.nb("update_need_check_dex", "tools"))) {
          break label185;
        }
        AppMethodBeat.o(155031);
        return Integer.valueOf(-101);
      }
      if (mCurrentTimeForRetryRes > 0) {
        break;
      }
      XWalkInitializer.addXWalkInitializeLog("XWalkLib", "checkExtractResFileLengtgAndMd5 failed retry extractResource");
      mCurrentTimeForRetryRes += 1;
    }
    XWalkInitializer.addXWalkInitializeLog("XWalkLib", "checkResourceLengthAndMd5 failed can not retry!!!!!!!!!! mCurrentTimeForRetryRes = " + mCurrentTimeForRetryRes);
    AppMethodBeat.o(155031);
    return Integer.valueOf(-12);
    label185:
    boolean bool = XWebCoreInfo.setVersionForAbi(paramUpdateConfig.apkVer, paramUpdateConfig.versionDetail, paramUpdateConfig.abi);
    XWalkInitializer.addXWalkInitializeLog("XWalkLib", "do update sucsess");
    g.ggD();
    com.tencent.xweb.internal.c.bcM("CHECK_FILES_MD5_TIME_KEY");
    if (!bool)
    {
      XWalkInitializer.addXWalkInitializeLog("XWalkLib", "set version failed");
      AppMethodBeat.o(155031);
      return Integer.valueOf(-101);
    }
    AppMethodBeat.o(155031);
    return Integer.valueOf(0);
  }
  
  private static boolean generateOptDex(int paramInt)
  {
    AppMethodBeat.i(155032);
    try
    {
      String str = XWalkEnvironment.getExtractedCoreDir(paramInt);
      h.bp(XWalkEnvironment.getClassDexFilePath(paramInt), XWalkEnvironment.getOptimizedDexDir(paramInt), str);
      AppMethodBeat.o(155032);
      return true;
    }
    catch (Exception localException)
    {
      XWalkInitializer.addXWalkInitializeLog("XWalkLib", "dex output error");
      AppMethodBeat.o(155032);
    }
    return false;
  }
  
  static void generate_jar_for_dex(File paramFile, boolean paramBoolean)
  {
    AppMethodBeat.i(207661);
    String str1 = paramFile.getName();
    try
    {
      String str2 = paramFile.getAbsolutePath() + ".jar";
      File localFile = new File(str2);
      if (localFile.exists())
      {
        Log.i("XWalkLib", "generate .jar from " + str1 + " , but jar file exists , need remove =  " + paramBoolean);
        if (!paramBoolean)
        {
          AppMethodBeat.o(207661);
          return;
        }
        localFile.delete();
      }
      paramBoolean = u.i(paramFile, str2);
      Log.i("XWalkLib", "generate .jar from " + str1 + " ret =  " + paramBoolean);
      AppMethodBeat.o(207661);
      return;
    }
    catch (Exception paramFile)
    {
      Log.e("XWalkLib", "generate .jar from " + str1 + " failed. error is " + paramFile.getMessage());
      AppMethodBeat.o(207661);
    }
  }
  
  static void generate_jar_for_dex_in_dir(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(207660);
    paramString = new File(paramString);
    if (!paramString.isDirectory())
    {
      AppMethodBeat.o(207660);
      return;
    }
    paramString = paramString.listFiles();
    int j = paramString.length;
    int i = 0;
    if (i < j)
    {
      File localFile = paramString[i];
      if (localFile != null)
      {
        if (!localFile.isDirectory()) {
          break label78;
        }
        generate_jar_for_dex_in_dir(localFile.getAbsolutePath(), paramBoolean);
      }
      for (;;)
      {
        i += 1;
        break;
        label78:
        if (localFile.getName().endsWith(".dex")) {
          generate_jar_for_dex(localFile, paramBoolean);
        }
      }
    }
    AppMethodBeat.o(207660);
  }
  
  public static int getLastTryInstallVer(String paramString)
  {
    AppMethodBeat.i(207657);
    int i = getSpForEmbedInstall(paramString).getInt("INSTALLED_EMBED_VERSION", -1);
    AppMethodBeat.o(207657);
    return i;
  }
  
  static SharedPreferences getSpForEmbedInstall(String paramString)
  {
    AppMethodBeat.i(207656);
    paramString = XWalkEnvironment.getMMKVSharedPreferences("XWEB_EMBED_INSTALL_".concat(String.valueOf(paramString)));
    AppMethodBeat.o(207656);
    return paramString;
  }
  
  /* Error */
  private static boolean isProviderExist(ContentResolver paramContentResolver, String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: ldc_w 564
    //   5: invokestatic 125	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: ifnull +14 -> 23
    //   12: aload_1
    //   13: ifnull +10 -> 23
    //   16: aload_1
    //   17: invokevirtual 228	java/lang/String:isEmpty	()Z
    //   20: ifeq +11 -> 31
    //   23: ldc_w 564
    //   26: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: iconst_0
    //   30: ireturn
    //   31: aload_0
    //   32: aload_1
    //   33: invokestatic 567	org/xwalk/core/XWalkEnvironment:getPackageName	()Ljava/lang/String;
    //   36: iconst_1
    //   37: iconst_0
    //   38: ldc_w 569
    //   41: invokestatic 575	com/tencent/xweb/XWebCoreContentProvider:d	(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)Landroid/net/Uri;
    //   44: ldc_w 569
    //   47: invokevirtual 581	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   50: astore_0
    //   51: aload_0
    //   52: invokestatic 587	com/tencent/xweb/util/c:a	(Landroid/content/res/AssetFileDescriptor;)V
    //   55: ldc_w 564
    //   58: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: iload_2
    //   62: ireturn
    //   63: astore_0
    //   64: aconst_null
    //   65: invokestatic 587	com/tencent/xweb/util/c:a	(Landroid/content/res/AssetFileDescriptor;)V
    //   68: iconst_0
    //   69: istore_2
    //   70: goto -15 -> 55
    //   73: astore_0
    //   74: aconst_null
    //   75: invokestatic 587	com/tencent/xweb/util/c:a	(Landroid/content/res/AssetFileDescriptor;)V
    //   78: ldc_w 564
    //   81: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: aload_0
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	paramContentResolver	ContentResolver
    //   0	86	1	paramString	String
    //   1	69	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   31	51	63	java/lang/Exception
    //   31	51	73	finally
  }
  
  public static boolean onDoPatch(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(155034);
    Log.i("XWalkLib", "onDoPatch:" + paramString + ",currentVersion:" + paramInt1 + ",newVersion:" + paramInt2);
    if (!new File(paramString).exists())
    {
      Log.e("XWalkLib", "onDoPatch no patch zip file");
      AppMethodBeat.o(155034);
      return false;
    }
    if (!XWalkDecompressor.decompressDownloadPatchZip(paramString, XWalkEnvironment.getPatchZipTempDecompressPath(paramInt2)))
    {
      Log.e("XWalkLib", "onDoPatch decompress zip error");
      g.FJ(37L);
      AppMethodBeat.o(155034);
      return false;
    }
    paramString = PatchFileConfigParser.getPatchFileConfigList(paramInt2);
    if (paramString == null)
    {
      Log.e("XWalkLib", "onDoPatch patchFileConfigList = null");
      g.FJ(38L);
      AppMethodBeat.o(155034);
      return false;
    }
    if (!com.tencent.xweb.util.c.nl(XWalkEnvironment.getExtractedCoreDir(paramInt1), XWalkEnvironment.getExtractedCoreDir(paramInt2)))
    {
      Log.e("XWalkLib", "onDoPatch copy all extraced file error");
      g.FJ(39L);
      AppMethodBeat.o(155034);
      return false;
    }
    Log.i("XWalkLib", "onDoPatch copy all extraced file finished");
    Object localObject1 = new ArrayList();
    Object localObject2 = paramString.iterator();
    PatchFileConfig localPatchFileConfig;
    while (((Iterator)localObject2).hasNext())
    {
      localPatchFileConfig = (PatchFileConfig)((Iterator)localObject2).next();
      if (localPatchFileConfig.isTypeAdd()) {
        ((ArrayList)localObject1).add(localPatchFileConfig);
      }
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (PatchFileConfig)((Iterator)localObject1).next();
      if (!com.tencent.xweb.util.c.lS(XWalkEnvironment.getPatchZipTempDecompressFilePath(paramInt2, ((PatchFileConfig)localObject2).originalFileName), XWalkEnvironment.getExtractedCoreFile(paramInt2, ((PatchFileConfig)localObject2).originalFileName)))
      {
        Log.e("XWalkLib", "onDoPatch add file error:".concat(String.valueOf(localObject2)));
        g.FJ(40L);
        AppMethodBeat.o(155034);
        return false;
      }
      Log.i("XWalkLib", "onDoPatch add file:".concat(String.valueOf(localObject2)));
    }
    Log.i("XWalkLib", "onDoPatch add file finished");
    localObject1 = new ArrayList();
    localObject2 = paramString.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localPatchFileConfig = (PatchFileConfig)((Iterator)localObject2).next();
      if (localPatchFileConfig.isTypeRemove()) {
        ((ArrayList)localObject1).add(localPatchFileConfig);
      }
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (PatchFileConfig)((Iterator)localObject1).next();
      if (!com.tencent.xweb.util.c.deleteFile(XWalkEnvironment.getExtractedCoreFile(paramInt2, ((PatchFileConfig)localObject2).originalFileName)))
      {
        Log.e("XWalkLib", "onDoPatch delete file error:".concat(String.valueOf(localObject2)));
        g.FJ(41L);
      }
      else
      {
        Log.i("XWalkLib", "onDoPatch delete file:".concat(String.valueOf(localObject2)));
      }
    }
    Log.i("XWalkLib", "onDoPatch remove file finished");
    localObject1 = new ArrayList();
    paramString = paramString.iterator();
    while (paramString.hasNext())
    {
      localObject2 = (PatchFileConfig)paramString.next();
      if (((PatchFileConfig)localObject2).isTypeModify()) {
        ((ArrayList)localObject1).add(localObject2);
      }
    }
    paramString = ((ArrayList)localObject1).iterator();
    while (paramString.hasNext())
    {
      localObject2 = (PatchFileConfig)paramString.next();
      if (((PatchFileConfig)localObject2).isExtractedFile())
      {
        if (BSpatch.bn(XWalkEnvironment.getExtractedCoreFile(paramInt2, ((PatchFileConfig)localObject2).originalFileName), XWalkEnvironment.getPatchZipTempDecompressFilePath(paramInt2, ((PatchFileConfig)localObject2).patchFileName), XWalkEnvironment.getExtractedCoreFile(paramInt2, ((PatchFileConfig)localObject2).originalFileName)) < 0)
        {
          Log.e("XWalkLib", "onDoPatch patch error file:".concat(String.valueOf(localObject2)));
          AppMethodBeat.o(155034);
          return false;
        }
        Log.i("XWalkLib", "onDoPatch patch file finished");
      }
    }
    Log.i("XWalkLib", "onDoPatch patch file finished");
    paramString = ((ArrayList)localObject1).iterator();
    while (paramString.hasNext())
    {
      localObject1 = (PatchFileConfig)paramString.next();
      if (((PatchFileConfig)localObject1).isOriginalFileTypeApk()) {
        if (BSpatch.bn(XWalkEnvironment.getDownloadApkPath(paramInt1), XWalkEnvironment.getPatchZipTempDecompressFilePath(paramInt2, ((PatchFileConfig)localObject1).patchFileName), XWalkEnvironment.getDownloadApkPath(paramInt2)) < 0)
        {
          Log.e("XWalkLib", "onDoPatch apk patch error file:".concat(String.valueOf(localObject1)));
          AppMethodBeat.o(155034);
          return false;
        }
      }
    }
    Log.i("XWalkLib", "onDoPatch apk patch finished");
    AppMethodBeat.o(155034);
    return true;
  }
  
  public static Integer onHandleFile(UpdateConfig paramUpdateConfig)
  {
    AppMethodBeat.i(155030);
    String str = paramUpdateConfig.getDownloadPath();
    Log.d("XWalkLib", "Download mode extract dir: ".concat(String.valueOf(XWalkEnvironment.getExtractedCoreDir(paramUpdateConfig.apkVer))));
    if ((paramUpdateConfig.isMatchMd5) && (!d.nn(str, paramUpdateConfig.downloadFileMd5)))
    {
      XWalkInitializer.addXWalkInitializeLog("XWalkLib", "downloaded apk md5 check failed");
      AppMethodBeat.o(155030);
      return Integer.valueOf(-2);
    }
    if (paramUpdateConfig.isPatchUpdate)
    {
      if (!onDoPatch(str, paramUpdateConfig.nPatchTargetVersion, paramUpdateConfig.apkVer))
      {
        XWalkInitializer.addXWalkInitializeLog("XWalkLib", "patch update mode ,but patch error");
        AppMethodBeat.o(155030);
        return Integer.valueOf(-3);
      }
      if ((paramUpdateConfig.isMatchMd5) && (!FileListMD5Checker.checkFileListMd5(paramUpdateConfig.apkVer, XWalkEnvironment.getPatchFileListConfig(paramUpdateConfig.apkVer))))
      {
        XWalkInitializer.addXWalkInitializeLog("XWalkLib", "patch update mode, but md5 not match");
        g.FJ(36L);
        AppMethodBeat.o(155030);
        return Integer.valueOf(-4);
      }
      XWalkInitializer.addXWalkInitializeLog("XWalkLib", "do patch sucsess");
    }
    do
    {
      paramUpdateConfig = extractResource(paramUpdateConfig);
      AppMethodBeat.o(155030);
      return paramUpdateConfig;
      if (!XWalkDecompressor.decompressDownloadFullZip(str, paramUpdateConfig.apkVer))
      {
        g.FJ(32L);
        AppMethodBeat.o(155030);
        return Integer.valueOf(-5);
      }
    } while ((!paramUpdateConfig.isMatchMd5) || (FileListMD5Checker.checkFileListMd5(paramUpdateConfig.apkVer, XWalkEnvironment.getDownloadZipFileListConfig(paramUpdateConfig.apkVer))));
    XWalkInitializer.addXWalkInitializeLog("XWalkLib", "patch update mode, but md5 not match");
    g.FJ(33L);
    AppMethodBeat.o(155030);
    return Integer.valueOf(-4);
  }
  
  private static boolean tryCopyVersion(ContentResolver paramContentResolver, String paramString, int paramInt, Map<String, String> paramMap, ErrorInfo paramErrorInfo)
  {
    AppMethodBeat.i(155025);
    String str1;
    try
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      String str2;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        paramMap = (Map.Entry)localIterator.next();
        str1 = (String)paramMap.getKey();
        str2 = (String)paramMap.getValue();
        AssetFileDescriptor localAssetFileDescriptor = paramContentResolver.openAssetFileDescriptor(XWebCoreContentProvider.d(paramString, XWalkEnvironment.getPackageName(), 2, paramInt, str1), "");
        if (localAssetFileDescriptor == null)
        {
          paramErrorInfo.copyFailedCount += 1;
          XWalkInitializer.addXWalkInitializeLog("tryCopyVersion no file ".concat(String.valueOf(str1)));
          AppMethodBeat.o(155025);
          return false;
        }
        if ("base.apk".equals(str1)) {}
        for (paramMap = new File(XWalkEnvironment.getDownloadApkPath(paramInt)); !com.tencent.xweb.util.c.a(localAssetFileDescriptor, paramMap); paramMap = new File(XWalkEnvironment.getExtractedCoreFile(paramInt, str1)))
        {
          paramErrorInfo.copyFailedCount += 1;
          XWalkInitializer.addXWalkInitializeLog("tryCopyVersion copy error");
          AppMethodBeat.o(155025);
          return false;
        }
      } while (d.nn(paramMap.getAbsolutePath(), str2));
    }
    catch (Exception paramContentResolver)
    {
      XWalkInitializer.addXWalkInitializeLog("tryCopyVersion copy error:" + paramContentResolver.getMessage());
      paramErrorInfo.copyFailedCount += 1;
      AppMethodBeat.o(155025);
      return false;
    }
    XWalkInitializer.addXWalkInitializeLog("tryCopyVersion md5 error ".concat(String.valueOf(str1)));
    paramErrorInfo.md5FailedCount += 1;
    if (paramMap.exists()) {
      paramMap.delete();
    }
    AppMethodBeat.o(155025);
    return false;
    AppMethodBeat.o(155025);
    return true;
  }
  
  /* Error */
  private static Map<String, String> tryGetFileList(ContentResolver paramContentResolver, String paramString, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 807
    //   3: invokestatic 125	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 809	java/util/HashMap
    //   9: dup
    //   10: invokespecial 810	java/util/HashMap:<init>	()V
    //   13: astore_3
    //   14: aload_0
    //   15: aload_1
    //   16: invokestatic 567	org/xwalk/core/XWalkEnvironment:getPackageName	()Ljava/lang/String;
    //   19: iconst_2
    //   20: iload_2
    //   21: ldc_w 812
    //   24: invokestatic 575	com/tencent/xweb/XWebCoreContentProvider:d	(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)Landroid/net/Uri;
    //   27: ldc_w 569
    //   30: invokevirtual 581	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   33: astore_1
    //   34: aload_1
    //   35: ifnonnull +29 -> 64
    //   38: ldc_w 814
    //   41: invokestatic 788	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   44: aconst_null
    //   45: invokestatic 818	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   48: aconst_null
    //   49: invokestatic 818	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   52: aload_1
    //   53: invokestatic 587	com/tencent/xweb/util/c:a	(Landroid/content/res/AssetFileDescriptor;)V
    //   56: ldc_w 807
    //   59: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: aload_3
    //   63: areturn
    //   64: new 147	java/io/File
    //   67: dup
    //   68: iload_2
    //   69: ldc_w 812
    //   72: invokestatic 657	org/xwalk/core/XWalkEnvironment:getExtractedCoreFile	(ILjava/lang/String;)Ljava/lang/String;
    //   75: invokespecial 150	java/io/File:<init>	(Ljava/lang/String;)V
    //   78: astore_0
    //   79: aload_0
    //   80: invokevirtual 154	java/io/File:exists	()Z
    //   83: ifeq +8 -> 91
    //   86: aload_0
    //   87: invokevirtual 261	java/io/File:delete	()Z
    //   90: pop
    //   91: new 820	java/io/PrintWriter
    //   94: dup
    //   95: aload_0
    //   96: invokespecial 821	java/io/PrintWriter:<init>	(Ljava/io/File;)V
    //   99: astore 4
    //   101: new 218	java/io/BufferedReader
    //   104: dup
    //   105: new 213	java/io/InputStreamReader
    //   108: dup
    //   109: aload_1
    //   110: invokevirtual 827	android/content/res/AssetFileDescriptor:createInputStream	()Ljava/io/FileInputStream;
    //   113: invokespecial 216	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   116: invokespecial 221	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   119: astore_0
    //   120: aload 4
    //   122: astore 7
    //   124: aload_0
    //   125: astore 6
    //   127: aload_1
    //   128: astore 5
    //   130: aload_0
    //   131: invokevirtual 225	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   134: astore 8
    //   136: aload 8
    //   138: ifnull +211 -> 349
    //   141: aload 4
    //   143: astore 7
    //   145: aload_0
    //   146: astore 6
    //   148: aload_1
    //   149: astore 5
    //   151: aload 4
    //   153: aload 8
    //   155: invokevirtual 830	java/io/PrintWriter:println	(Ljava/lang/String;)V
    //   158: aload 4
    //   160: astore 7
    //   162: aload_0
    //   163: astore 6
    //   165: aload_1
    //   166: astore 5
    //   168: aload 8
    //   170: invokevirtual 228	java/lang/String:isEmpty	()Z
    //   173: ifne -53 -> 120
    //   176: aload 4
    //   178: astore 7
    //   180: aload_0
    //   181: astore 6
    //   183: aload_1
    //   184: astore 5
    //   186: aload 8
    //   188: ldc 230
    //   190: invokevirtual 234	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   193: astore 8
    //   195: aload 4
    //   197: astore 7
    //   199: aload_0
    //   200: astore 6
    //   202: aload_1
    //   203: astore 5
    //   205: aload 8
    //   207: arraylength
    //   208: iconst_2
    //   209: if_icmpne -89 -> 120
    //   212: aload 8
    //   214: iconst_0
    //   215: aaload
    //   216: ifnull -96 -> 120
    //   219: aload 4
    //   221: astore 7
    //   223: aload_0
    //   224: astore 6
    //   226: aload_1
    //   227: astore 5
    //   229: aload 8
    //   231: iconst_0
    //   232: aaload
    //   233: invokevirtual 228	java/lang/String:isEmpty	()Z
    //   236: ifne -116 -> 120
    //   239: aload 8
    //   241: iconst_1
    //   242: aaload
    //   243: ifnull -123 -> 120
    //   246: aload 4
    //   248: astore 7
    //   250: aload_0
    //   251: astore 6
    //   253: aload_1
    //   254: astore 5
    //   256: aload 8
    //   258: iconst_1
    //   259: aaload
    //   260: invokevirtual 228	java/lang/String:isEmpty	()Z
    //   263: ifne -143 -> 120
    //   266: aload 4
    //   268: astore 7
    //   270: aload_0
    //   271: astore 6
    //   273: aload_1
    //   274: astore 5
    //   276: aload_3
    //   277: aload 8
    //   279: iconst_0
    //   280: aaload
    //   281: aload 8
    //   283: iconst_1
    //   284: aaload
    //   285: invokeinterface 834 3 0
    //   290: pop
    //   291: goto -171 -> 120
    //   294: astore_3
    //   295: aload 4
    //   297: astore 7
    //   299: aload_0
    //   300: astore 6
    //   302: aload_1
    //   303: astore 5
    //   305: new 244	java/lang/StringBuilder
    //   308: dup
    //   309: ldc_w 836
    //   312: invokespecial 247	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   315: aload_3
    //   316: invokevirtual 282	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   319: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: invokestatic 788	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   328: aload 4
    //   330: invokestatic 818	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   333: aload_0
    //   334: invokestatic 818	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   337: aload_1
    //   338: invokestatic 587	com/tencent/xweb/util/c:a	(Landroid/content/res/AssetFileDescriptor;)V
    //   341: ldc_w 807
    //   344: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   347: aconst_null
    //   348: areturn
    //   349: aload 4
    //   351: astore 7
    //   353: aload_0
    //   354: astore 6
    //   356: aload_1
    //   357: astore 5
    //   359: aload 4
    //   361: invokevirtual 839	java/io/PrintWriter:flush	()V
    //   364: aload 4
    //   366: invokestatic 818	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   369: aload_0
    //   370: invokestatic 818	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   373: aload_1
    //   374: invokestatic 587	com/tencent/xweb/util/c:a	(Landroid/content/res/AssetFileDescriptor;)V
    //   377: ldc_w 807
    //   380: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   383: aload_3
    //   384: areturn
    //   385: astore_0
    //   386: aconst_null
    //   387: astore_3
    //   388: aconst_null
    //   389: astore 4
    //   391: aconst_null
    //   392: astore_1
    //   393: aload_3
    //   394: invokestatic 818	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   397: aload 4
    //   399: invokestatic 818	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   402: aload_1
    //   403: invokestatic 587	com/tencent/xweb/util/c:a	(Landroid/content/res/AssetFileDescriptor;)V
    //   406: ldc_w 807
    //   409: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   412: aload_0
    //   413: athrow
    //   414: astore_0
    //   415: aconst_null
    //   416: astore_3
    //   417: aconst_null
    //   418: astore 4
    //   420: goto -27 -> 393
    //   423: astore_0
    //   424: aconst_null
    //   425: astore 5
    //   427: aload 4
    //   429: astore_3
    //   430: aload 5
    //   432: astore 4
    //   434: goto -41 -> 393
    //   437: astore_0
    //   438: aload 7
    //   440: astore_3
    //   441: aload 6
    //   443: astore 4
    //   445: aload 5
    //   447: astore_1
    //   448: goto -55 -> 393
    //   451: astore_3
    //   452: aconst_null
    //   453: astore 4
    //   455: aconst_null
    //   456: astore_0
    //   457: aconst_null
    //   458: astore_1
    //   459: goto -164 -> 295
    //   462: astore_3
    //   463: aconst_null
    //   464: astore 4
    //   466: aconst_null
    //   467: astore_0
    //   468: goto -173 -> 295
    //   471: astore_3
    //   472: aconst_null
    //   473: astore_0
    //   474: goto -179 -> 295
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	477	0	paramContentResolver	ContentResolver
    //   0	477	1	paramString	String
    //   0	477	2	paramInt	int
    //   13	264	3	localHashMap	java.util.HashMap
    //   294	90	3	localException1	Exception
    //   387	54	3	localObject1	Object
    //   451	1	3	localException2	Exception
    //   462	1	3	localException3	Exception
    //   471	1	3	localException4	Exception
    //   99	366	4	localObject2	Object
    //   128	318	5	str	String
    //   125	317	6	localContentResolver	ContentResolver
    //   122	317	7	localObject3	Object
    //   134	148	8	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   130	136	294	java/lang/Exception
    //   151	158	294	java/lang/Exception
    //   168	176	294	java/lang/Exception
    //   186	195	294	java/lang/Exception
    //   205	212	294	java/lang/Exception
    //   229	239	294	java/lang/Exception
    //   256	266	294	java/lang/Exception
    //   276	291	294	java/lang/Exception
    //   359	364	294	java/lang/Exception
    //   14	34	385	finally
    //   38	44	414	finally
    //   64	91	414	finally
    //   91	101	414	finally
    //   101	120	423	finally
    //   130	136	437	finally
    //   151	158	437	finally
    //   168	176	437	finally
    //   186	195	437	finally
    //   205	212	437	finally
    //   229	239	437	finally
    //   256	266	437	finally
    //   276	291	437	finally
    //   305	328	437	finally
    //   359	364	437	finally
    //   14	34	451	java/lang/Exception
    //   38	44	462	java/lang/Exception
    //   64	91	462	java/lang/Exception
    //   91	101	462	java/lang/Exception
    //   101	120	471	java/lang/Exception
  }
  
  public static void tryInstallFromEmebed() {}
  
  public static void try_generate_jar_for_dex_in_dir(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(207659);
    if ((Build.VERSION.SDK_INT < 29) || ("true".equalsIgnoreCase(a.nb("NOT_USE_JAR_REPLACE_DEX", "tools"))))
    {
      AppMethodBeat.o(207659);
      return;
    }
    generate_jar_for_dex_in_dir(paramString, paramBoolean);
    AppMethodBeat.o(207659);
  }
  
  public static void updateLocalXWalkRuntime()
  {
    AppMethodBeat.i(155026);
    onHandleFile(new UpdateConfig("runtime_package.zip", false, 100000000, XWalkEnvironment.getRuntimeAbi(), 0));
    AppMethodBeat.o(155026);
  }
  
  private boolean verifyDownloadedXWalkRuntime(String paramString)
  {
    AppMethodBeat.i(155035);
    paramString = this.mContext.getPackageManager().getPackageArchiveInfo(paramString, 64);
    if (paramString == null)
    {
      Log.e("XWalkLib", "The downloaded XWalkRuntimeLib.apk is invalid!");
      AppMethodBeat.o(155035);
      return false;
    }
    PackageInfo localPackageInfo;
    try
    {
      localPackageInfo = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 64);
      if ((paramString.signatures == null) || (localPackageInfo.signatures == null))
      {
        Log.e("XWalkLib", "No signature in package info");
        AppMethodBeat.o(155035);
        return false;
      }
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      AppMethodBeat.o(155035);
      return false;
    }
    if (paramString.signatures.length != localPackageInfo.signatures.length)
    {
      Log.e("XWalkLib", "signatures length not equal");
      AppMethodBeat.o(155035);
      return false;
    }
    int i = 0;
    while (i < paramString.signatures.length)
    {
      Log.d("XWalkLib", "Checking signature ".concat(String.valueOf(i)));
      if (!localPackageInfo.signatures[i].equals(paramString.signatures[i]))
      {
        Log.e("XWalkLib", "signatures do not match");
        AppMethodBeat.o(155035);
        return false;
      }
      i += 1;
    }
    Log.d("XWalkLib", "Signature check passed");
    AppMethodBeat.o(155035);
    return true;
  }
  
  public boolean cancelBackgroundDownload()
  {
    AppMethodBeat.i(155029);
    boolean bool = XWalkLibraryLoader.cancelHttpDownload();
    AppMethodBeat.o(155029);
    return bool;
  }
  
  public void cancelXWalkRuntimeDownload()
  {
    AppMethodBeat.i(155027);
    if (XWalkLibraryLoader.isDownloading())
    {
      XWalkInitializer.addXWalkInitializeLog("XWalkLib", "canceled download apk");
      XWalkLibraryLoader.cancelHttpDownload();
    }
    AppMethodBeat.o(155027);
  }
  
  public boolean dismissDialog()
  {
    AppMethodBeat.i(155028);
    if ((this.mDialogManager == null) || (!this.mDialogManager.isShowingDialog()))
    {
      AppMethodBeat.o(155028);
      return false;
    }
    this.mDialogManager.dismissDialog();
    AppMethodBeat.o(155028);
    return true;
  }
  
  public ErrorInfo updateRuntimeFromProvider(XWebCoreScheduler paramXWebCoreScheduler)
  {
    for (;;)
    {
      com.tencent.xweb.xwalk.updater.c localc;
      ErrorInfo localErrorInfo;
      ContentResolver localContentResolver;
      int i;
      String str;
      int k;
      Map localMap;
      try
      {
        AppMethodBeat.i(207654);
        localc = paramXWebCoreScheduler.gij();
        XWalkInitializer.addXWalkInitializeLog("updateFromProvider target ver " + localc.version);
        localErrorInfo = new ErrorInfo();
        localErrorInfo.targetVer = localc.version;
        if (!localc.bTryUseSharedCore)
        {
          XWalkInitializer.addXWalkInitializeLog("updateFromProvider force download");
          localErrorInfo.errorCode = -6;
          AppMethodBeat.o(207654);
          return localErrorInfo;
        }
        if (localc.MWe >= 2)
        {
          XWalkInitializer.addXWalkInitializeLog("updateFromProvider exceed max count");
          localErrorInfo.errorCode = -7;
          AppMethodBeat.o(207654);
          continue;
        }
        localContentResolver = XWalkEnvironment.getContentResolver();
        if (localContentResolver == null)
        {
          XWalkInitializer.addXWalkInitializeLog("updateFromProvider content resolver null");
          localErrorInfo.errorCode = -8;
          AppMethodBeat.o(207654);
          continue;
        }
        paramXWebCoreScheduler = paramXWebCoreScheduler.f(localc);
        String[] arrayOfString = XWalkEnvironment.XWALK_CORE_PROVIDER_LIST;
        int m = arrayOfString.length;
        i = 0;
        j = 0;
        if (i >= m) {
          break label421;
        }
        str = arrayOfString[i];
        if (!isProviderExist(localContentResolver, str)) {
          break label502;
        }
        k = 1;
        XWalkInitializer.addXWalkInitializeLog("updateFromProvider find ".concat(String.valueOf(str)));
        localMap = tryGetFileList(localContentResolver, str, paramXWebCoreScheduler.apkVer);
        if (localMap == null)
        {
          XWalkInitializer.addXWalkInitializeLog("updateFromProvider read fileList failed");
          localErrorInfo.readFileListFailedCount += 1;
          j = k;
        }
        else if (localMap.size() == 0)
        {
          XWalkInitializer.addXWalkInitializeLog("updateFromProvider no matched version");
          localErrorInfo.noMatchedVersionCount += 1;
          j = k;
        }
      }
      finally {}
      int j = k;
      if (tryCopyVersion(localContentResolver, str, paramXWebCoreScheduler.apkVer, localMap, localErrorInfo))
      {
        int n = extractResource(paramXWebCoreScheduler).intValue();
        if (n == 0)
        {
          localErrorInfo.errorCode = 0;
          AppMethodBeat.o(207654);
          continue;
        }
        if (n == -5)
        {
          localErrorInfo.extractFailedCount += 1;
          j = k;
        }
        else if (n == -12)
        {
          localErrorInfo.extractRetryFailedCount += 1;
          j = k;
        }
        else
        {
          j = k;
          if (n == -101)
          {
            localErrorInfo.setVersionFailedCount += 1;
            j = k;
            break label502;
            label421:
            if (j == 0)
            {
              XWalkInitializer.addXWalkInitializeLog("updateFromProvider no provider");
              localErrorInfo.errorCode = -9;
              AppMethodBeat.o(207654);
              continue;
            }
            if ((XWalkEnvironment.hasAvailableVersion()) && (localc.MWe + 1 < 2)) {
              XWalkInitializer.addXWalkInitializeLog("updateFromProvider failed, can try again");
            }
            for (localErrorInfo.errorCode = -10;; localErrorInfo.errorCode = -11)
            {
              AppMethodBeat.o(207654);
              break;
              XWalkInitializer.addXWalkInitializeLog("updateFromProvider failed, do not try again");
            }
          }
        }
      }
      label502:
      i += 1;
    }
  }
  
  public boolean updateXWalkRuntime(UpdateConfig paramUpdateConfig)
  {
    AppMethodBeat.i(155021);
    if (XWalkLibraryLoader.isDownloading())
    {
      XWalkInitializer.addXWalkInitializeLog("XWalkLib", "Other initialization or download is proceeding");
      AppMethodBeat.o(155021);
      return false;
    }
    if (this.mBackgroundUpdateListener != null)
    {
      if ((paramUpdateConfig == null) || (!paramUpdateConfig.checkValid()))
      {
        XWalkInitializer.addXWalkInitializeLog("XWalkLib", "royle:XWalkUpdater updateXWalkRuntime updateConfig is not valid");
        g.ggV();
        AppMethodBeat.o(155021);
        return false;
      }
      XWalkInitializer.addXWalkInitializeLog("XWalkLib", "start download apk");
      XWalkLibraryLoader.startHttpDownload(new BackgroundListener(paramUpdateConfig), this.mContext, paramUpdateConfig);
      AppMethodBeat.o(155021);
      return true;
    }
    XWalkInitializer.addXWalkInitializeLog("XWalkLib", "Update listener is null");
    AppMethodBeat.o(155021);
    return false;
  }
  
  public static class AssetsUpdateConfig
    extends XWalkUpdater.EmbededUpdateConfig
  {
    public AssetsUpdateConfig(int paramInt, String paramString1, String paramString2)
    {
      super(paramString1, paramString2);
    }
    
    /* Error */
    public boolean copyPackageToLocal(String paramString1, String paramString2)
    {
      // Byte code:
      //   0: ldc 19
      //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: invokestatic 31	org/xwalk/core/XWalkEnvironment:getApplicationContext	()Landroid/content/Context;
      //   8: invokevirtual 37	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
      //   11: astore_2
      //   12: aload_2
      //   13: aload_1
      //   14: invokevirtual 43	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
      //   17: astore_1
      //   18: new 45	java/io/FileOutputStream
      //   21: dup
      //   22: aload_0
      //   23: invokevirtual 49	org/xwalk/core/XWalkUpdater$AssetsUpdateConfig:getDownloadPath	()Ljava/lang/String;
      //   26: invokespecial 52	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
      //   29: astore_2
      //   30: aload_2
      //   31: astore 5
      //   33: aload_1
      //   34: astore 4
      //   36: ldc 53
      //   38: newarray byte
      //   40: astore 6
      //   42: aload_2
      //   43: astore 5
      //   45: aload_1
      //   46: astore 4
      //   48: aload_1
      //   49: aload 6
      //   51: invokevirtual 59	java/io/InputStream:read	([B)I
      //   54: istore_3
      //   55: iload_3
      //   56: iconst_m1
      //   57: if_icmpeq +76 -> 133
      //   60: aload_2
      //   61: astore 5
      //   63: aload_1
      //   64: astore 4
      //   66: aload_2
      //   67: aload 6
      //   69: iconst_0
      //   70: iload_3
      //   71: invokevirtual 65	java/io/OutputStream:write	([BII)V
      //   74: goto -32 -> 42
      //   77: astore 6
      //   79: aload_2
      //   80: astore 5
      //   82: aload_1
      //   83: astore 4
      //   85: ldc 67
      //   87: new 69	java/lang/StringBuilder
      //   90: dup
      //   91: ldc 71
      //   93: invokespecial 72	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   96: aload 6
      //   98: invokevirtual 75	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   101: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   104: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   107: invokestatic 86	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
      //   110: aload_1
      //   111: ifnull +7 -> 118
      //   114: aload_1
      //   115: invokevirtual 90	java/io/InputStream:close	()V
      //   118: aload_2
      //   119: ifnull +7 -> 126
      //   122: aload_2
      //   123: invokevirtual 91	java/io/OutputStream:close	()V
      //   126: ldc 19
      //   128: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   131: iconst_0
      //   132: ireturn
      //   133: aload_2
      //   134: astore 5
      //   136: aload_1
      //   137: astore 4
      //   139: aload_2
      //   140: invokevirtual 97	java/io/OutputStream:flush	()V
      //   143: aload_1
      //   144: ifnull +7 -> 151
      //   147: aload_1
      //   148: invokevirtual 90	java/io/InputStream:close	()V
      //   151: aload_2
      //   152: invokevirtual 91	java/io/OutputStream:close	()V
      //   155: ldc 19
      //   157: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   160: iconst_1
      //   161: ireturn
      //   162: astore_2
      //   163: aconst_null
      //   164: astore 5
      //   166: aconst_null
      //   167: astore_1
      //   168: aload_1
      //   169: ifnull +7 -> 176
      //   172: aload_1
      //   173: invokevirtual 90	java/io/InputStream:close	()V
      //   176: aload 5
      //   178: ifnull +8 -> 186
      //   181: aload 5
      //   183: invokevirtual 91	java/io/OutputStream:close	()V
      //   186: ldc 19
      //   188: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   191: aload_2
      //   192: athrow
      //   193: astore_1
      //   194: goto -43 -> 151
      //   197: astore_1
      //   198: goto -43 -> 155
      //   201: astore_1
      //   202: goto -84 -> 118
      //   205: astore_1
      //   206: goto -80 -> 126
      //   209: astore_1
      //   210: goto -34 -> 176
      //   213: astore_1
      //   214: goto -28 -> 186
      //   217: astore_2
      //   218: aconst_null
      //   219: astore 5
      //   221: goto -53 -> 168
      //   224: astore_2
      //   225: aload 4
      //   227: astore_1
      //   228: goto -60 -> 168
      //   231: astore 6
      //   233: aconst_null
      //   234: astore_2
      //   235: aconst_null
      //   236: astore_1
      //   237: goto -158 -> 79
      //   240: astore 6
      //   242: aconst_null
      //   243: astore_2
      //   244: goto -165 -> 79
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	247	0	this	AssetsUpdateConfig
      //   0	247	1	paramString1	String
      //   0	247	2	paramString2	String
      //   54	17	3	i	int
      //   34	192	4	str1	String
      //   31	189	5	str2	String
      //   40	28	6	arrayOfByte	byte[]
      //   77	20	6	localException1	Exception
      //   231	1	6	localException2	Exception
      //   240	1	6	localException3	Exception
      // Exception table:
      //   from	to	target	type
      //   36	42	77	java/lang/Exception
      //   48	55	77	java/lang/Exception
      //   66	74	77	java/lang/Exception
      //   139	143	77	java/lang/Exception
      //   12	18	162	finally
      //   147	151	193	java/lang/Exception
      //   151	155	197	java/io/IOException
      //   114	118	201	java/lang/Exception
      //   122	126	205	java/io/IOException
      //   172	176	209	java/lang/Exception
      //   181	186	213	java/io/IOException
      //   18	30	217	finally
      //   36	42	224	finally
      //   48	55	224	finally
      //   66	74	224	finally
      //   85	110	224	finally
      //   139	143	224	finally
      //   12	18	231	java/lang/Exception
      //   18	30	240	java/lang/Exception
    }
  }
  
  class BackgroundListener
    implements XWalkLibraryLoader.DownloadListener
  {
    private XWalkUpdater.UpdateConfig mConfig;
    
    public BackgroundListener(XWalkUpdater.UpdateConfig paramUpdateConfig)
    {
      this.mConfig = paramUpdateConfig;
    }
    
    private void reportKV(XWalkLibraryLoader.DownloadInfo paramDownloadInfo)
    {
      int j = 1;
      AppMethodBeat.i(155009);
      int i;
      int k;
      int m;
      long l1;
      long l2;
      if (this.mConfig.isPatchUpdate)
      {
        i = 2;
        k = XWalkEnvironment.getInstalledNewstVersionForCurAbi();
        m = this.mConfig.apkVer;
        l1 = System.currentTimeMillis();
        l2 = paramDownloadInfo.mStartTimestamp;
        if (!paramDownloadInfo.mIsDownloadResume) {
          break label184;
        }
      }
      for (;;)
      {
        g.dc(15124, i + "," + k + "," + m + ",200901," + paramDownloadInfo.mErrorCode + "," + paramDownloadInfo.mNetWorkType + "," + paramDownloadInfo.mRetryTimes + "," + (l1 - l2) + "," + paramDownloadInfo.mFileTotalSize + "," + paramDownloadInfo.mDownloadType + "," + j);
        AppMethodBeat.o(155009);
        return;
        i = 1;
        break;
        label184:
        j = 0;
      }
    }
    
    public void onDownloadCancelled()
    {
      AppMethodBeat.i(155006);
      XWalkUpdater.this.mBackgroundUpdateListener.onXWalkUpdateCancelled();
      AppMethodBeat.o(155006);
    }
    
    public void onDownloadCompleted(XWalkLibraryLoader.DownloadInfo paramDownloadInfo)
    {
      AppMethodBeat.i(155008);
      XWalkInitializer.addXWalkInitializeLog("XWalkLib", "download apk completed, apkver = " + this.mConfig.apkVer);
      if (this.mConfig.isPatchUpdate) {
        g.FP(System.currentTimeMillis() - paramDownloadInfo.mStartTimestamp);
      }
      for (;;)
      {
        reportKV(paramDownloadInfo);
        new AsyncTask()
        {
          protected Integer doInBackground(Void... paramAnonymousVarArgs)
          {
            AppMethodBeat.i(155000);
            paramAnonymousVarArgs = XWalkUpdater.onHandleFile(XWalkUpdater.BackgroundListener.this.mConfig);
            AppMethodBeat.o(155000);
            return paramAnonymousVarArgs;
          }
          
          protected void onPostExecute(Integer paramAnonymousInteger)
          {
            AppMethodBeat.i(155001);
            if (paramAnonymousInteger.intValue() != 0)
            {
              XWalkUpdater.this.mBackgroundUpdateListener.onXWalkUpdateFailed(paramAnonymousInteger.intValue(), XWalkUpdater.BackgroundListener.this.mConfig.scheduler);
              AppMethodBeat.o(155001);
              return;
            }
            XWalkUpdater.this.mBackgroundUpdateListener.onXWalkUpdateCompleted(XWalkUpdater.BackgroundListener.this.mConfig.scheduler);
            AppMethodBeat.o(155001);
          }
        }.execute(new Void[0]);
        AppMethodBeat.o(155008);
        return;
        g.FN(System.currentTimeMillis() - paramDownloadInfo.mStartTimestamp);
      }
    }
    
    public void onDownloadFailed(XWalkLibraryLoader.DownloadInfo paramDownloadInfo)
    {
      AppMethodBeat.i(155007);
      XWalkInitializer.addXWalkInitializeLog("XWalkLib", "download apk failed");
      if (this.mConfig.isPatchUpdate) {
        g.ggY();
      }
      for (;;)
      {
        reportKV(paramDownloadInfo);
        if ((this.mConfig != null) && (this.mConfig.scheduler != null)) {
          this.mConfig.scheduler.ajB(-1);
        }
        XWalkUpdater.this.mBackgroundUpdateListener.onXWalkUpdateFailed(-1, this.mConfig.scheduler);
        AppMethodBeat.o(155007);
        return;
        g.ggU();
      }
    }
    
    public void onDownloadStarted(int paramInt)
    {
      AppMethodBeat.i(155004);
      Log.d("XWalkLib", "DownloadTask started, type:" + paramInt + " config:" + this.mConfig.getLogSelf());
      if (this.mConfig.isPatchUpdate) {
        g.brU();
      }
      for (;;)
      {
        XWalkUpdater.this.mBackgroundUpdateListener.onXWalkUpdateStarted();
        AppMethodBeat.o(155004);
        return;
        g.ggT();
      }
    }
    
    public void onDownloadUpdated(int paramInt)
    {
      AppMethodBeat.i(155005);
      XWalkUpdater.this.mBackgroundUpdateListener.onXWalkUpdateProgress(paramInt);
      AppMethodBeat.o(155005);
    }
  }
  
  public static abstract class EmbededUpdateConfig
    extends XWalkUpdater.UpdateConfig
  {
    boolean isCopySuc = false;
    
    public EmbededUpdateConfig(int paramInt, String paramString1, String paramString2)
    {
      super(false, paramInt, XWalkEnvironment.getRuntimeAbi(), 0);
    }
    
    public boolean checkValid()
    {
      return this.apkVer > 0;
    }
    
    public abstract boolean copyPackageToLocal(String paramString1, String paramString2);
    
    public boolean copySuc()
    {
      return this.isCopySuc;
    }
    
    public String getDownloadPath()
    {
      return super.getDownloadPath();
    }
  }
  
  public static class ErrorInfo
  {
    public int copyFailedCount = 0;
    public int errorCode = -11;
    public int extractFailedCount = 0;
    public int extractRetryFailedCount = 0;
    public int md5FailedCount = 0;
    public int noMatchedVersionCount = 0;
    public int readFileListFailedCount = 0;
    public int setVersionFailedCount = 0;
    public int targetVer = -1;
  }
  
  public static class FileListMD5Checker
  {
    /* Error */
    public static boolean checkFileListMd5(int paramInt, File paramFile)
    {
      // Byte code:
      //   0: ldc 17
      //   2: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_1
      //   6: ifnonnull +10 -> 16
      //   9: ldc 17
      //   11: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   14: iconst_0
      //   15: ireturn
      //   16: new 28	java/io/FileInputStream
      //   19: dup
      //   20: aload_1
      //   21: invokespecial 31	java/io/FileInputStream:<init>	(Ljava/io/File;)V
      //   24: astore 4
      //   26: new 33	java/io/InputStreamReader
      //   29: dup
      //   30: aload 4
      //   32: invokespecial 36	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
      //   35: astore_3
      //   36: new 38	java/io/BufferedReader
      //   39: dup
      //   40: aload_3
      //   41: invokespecial 41	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
      //   44: astore_1
      //   45: aload_1
      //   46: astore 7
      //   48: aload_3
      //   49: astore 6
      //   51: aload 4
      //   53: astore 5
      //   55: aload_1
      //   56: invokevirtual 45	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   59: astore_2
      //   60: aload_2
      //   61: ifnull +231 -> 292
      //   64: aload_2
      //   65: ifnull -20 -> 45
      //   68: aload_1
      //   69: astore 7
      //   71: aload_3
      //   72: astore 6
      //   74: aload 4
      //   76: astore 5
      //   78: aload_2
      //   79: invokevirtual 51	java/lang/String:isEmpty	()Z
      //   82: ifne -37 -> 45
      //   85: aload_1
      //   86: astore 7
      //   88: aload_3
      //   89: astore 6
      //   91: aload 4
      //   93: astore 5
      //   95: aload_2
      //   96: ldc 53
      //   98: invokevirtual 57	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
      //   101: astore_2
      //   102: aload_2
      //   103: ifnull -58 -> 45
      //   106: aload_1
      //   107: astore 7
      //   109: aload_3
      //   110: astore 6
      //   112: aload 4
      //   114: astore 5
      //   116: aload_2
      //   117: arraylength
      //   118: iconst_2
      //   119: if_icmpne -74 -> 45
      //   122: aload_2
      //   123: iconst_0
      //   124: aaload
      //   125: ifnull -80 -> 45
      //   128: aload_1
      //   129: astore 7
      //   131: aload_3
      //   132: astore 6
      //   134: aload 4
      //   136: astore 5
      //   138: aload_2
      //   139: iconst_0
      //   140: aaload
      //   141: invokevirtual 51	java/lang/String:isEmpty	()Z
      //   144: ifne -99 -> 45
      //   147: aload_2
      //   148: iconst_1
      //   149: aaload
      //   150: ifnull -105 -> 45
      //   153: aload_1
      //   154: astore 7
      //   156: aload_3
      //   157: astore 6
      //   159: aload 4
      //   161: astore 5
      //   163: aload_2
      //   164: iconst_1
      //   165: aaload
      //   166: invokevirtual 51	java/lang/String:isEmpty	()Z
      //   169: ifne -124 -> 45
      //   172: aload_1
      //   173: astore 7
      //   175: aload_3
      //   176: astore 6
      //   178: aload 4
      //   180: astore 5
      //   182: iload_0
      //   183: aload_2
      //   184: iconst_0
      //   185: aaload
      //   186: aload_2
      //   187: iconst_1
      //   188: aaload
      //   189: invokestatic 61	org/xwalk/core/XWalkUpdater$FileListMD5Checker:checkFileMd5	(ILjava/lang/String;Ljava/lang/String;)Z
      //   192: ifne -147 -> 45
      //   195: aload_1
      //   196: astore 7
      //   198: aload_3
      //   199: astore 6
      //   201: aload 4
      //   203: astore 5
      //   205: ldc 63
      //   207: new 65	java/lang/StringBuilder
      //   210: dup
      //   211: ldc 67
      //   213: invokespecial 70	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   216: aload_2
      //   217: iconst_0
      //   218: aaload
      //   219: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   222: ldc 76
      //   224: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   227: aload_2
      //   228: iconst_1
      //   229: aaload
      //   230: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   233: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   236: invokestatic 85	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   239: aload 4
      //   241: invokevirtual 88	java/io/FileInputStream:close	()V
      //   244: aload_3
      //   245: invokevirtual 89	java/io/InputStreamReader:close	()V
      //   248: aload_1
      //   249: invokevirtual 90	java/io/BufferedReader:close	()V
      //   252: ldc 17
      //   254: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   257: iconst_0
      //   258: ireturn
      //   259: astore_2
      //   260: ldc 63
      //   262: ldc 92
      //   264: invokestatic 85	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   267: goto -23 -> 244
      //   270: astore_2
      //   271: ldc 63
      //   273: ldc 94
      //   275: invokestatic 85	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   278: goto -30 -> 248
      //   281: astore_1
      //   282: ldc 63
      //   284: ldc 96
      //   286: invokestatic 85	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   289: goto -37 -> 252
      //   292: aload 4
      //   294: invokevirtual 88	java/io/FileInputStream:close	()V
      //   297: aload_3
      //   298: invokevirtual 89	java/io/InputStreamReader:close	()V
      //   301: aload_1
      //   302: invokevirtual 90	java/io/BufferedReader:close	()V
      //   305: ldc 17
      //   307: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   310: iconst_1
      //   311: ireturn
      //   312: astore_2
      //   313: ldc 63
      //   315: ldc 92
      //   317: invokestatic 85	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   320: goto -23 -> 297
      //   323: astore_2
      //   324: ldc 63
      //   326: ldc 94
      //   328: invokestatic 85	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   331: goto -30 -> 301
      //   334: astore_1
      //   335: ldc 63
      //   337: ldc 96
      //   339: invokestatic 85	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   342: goto -37 -> 305
      //   345: astore_2
      //   346: aconst_null
      //   347: astore_1
      //   348: aconst_null
      //   349: astore_3
      //   350: aconst_null
      //   351: astore 4
      //   353: aload_1
      //   354: astore 7
      //   356: aload_3
      //   357: astore 6
      //   359: aload 4
      //   361: astore 5
      //   363: ldc 63
      //   365: new 65	java/lang/StringBuilder
      //   368: dup
      //   369: ldc 98
      //   371: invokespecial 70	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   374: aload_2
      //   375: invokevirtual 101	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   378: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   381: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   384: invokestatic 85	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   387: aload 4
      //   389: ifnull +8 -> 397
      //   392: aload 4
      //   394: invokevirtual 88	java/io/FileInputStream:close	()V
      //   397: aload_3
      //   398: ifnull +7 -> 405
      //   401: aload_3
      //   402: invokevirtual 89	java/io/InputStreamReader:close	()V
      //   405: aload_1
      //   406: ifnull +7 -> 413
      //   409: aload_1
      //   410: invokevirtual 90	java/io/BufferedReader:close	()V
      //   413: ldc 17
      //   415: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   418: iconst_0
      //   419: ireturn
      //   420: astore_2
      //   421: ldc 63
      //   423: ldc 92
      //   425: invokestatic 85	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   428: goto -31 -> 397
      //   431: astore_2
      //   432: ldc 63
      //   434: ldc 94
      //   436: invokestatic 85	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   439: goto -34 -> 405
      //   442: astore_1
      //   443: ldc 63
      //   445: ldc 96
      //   447: invokestatic 85	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   450: goto -37 -> 413
      //   453: astore_1
      //   454: aconst_null
      //   455: astore_2
      //   456: aconst_null
      //   457: astore_3
      //   458: aconst_null
      //   459: astore 4
      //   461: aload 4
      //   463: ifnull +8 -> 471
      //   466: aload 4
      //   468: invokevirtual 88	java/io/FileInputStream:close	()V
      //   471: aload_3
      //   472: ifnull +7 -> 479
      //   475: aload_3
      //   476: invokevirtual 89	java/io/InputStreamReader:close	()V
      //   479: aload_2
      //   480: ifnull +7 -> 487
      //   483: aload_2
      //   484: invokevirtual 90	java/io/BufferedReader:close	()V
      //   487: ldc 17
      //   489: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   492: aload_1
      //   493: athrow
      //   494: astore 4
      //   496: ldc 63
      //   498: ldc 92
      //   500: invokestatic 85	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   503: goto -32 -> 471
      //   506: astore_3
      //   507: ldc 63
      //   509: ldc 94
      //   511: invokestatic 85	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   514: goto -35 -> 479
      //   517: astore_2
      //   518: ldc 63
      //   520: ldc 96
      //   522: invokestatic 85	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   525: goto -38 -> 487
      //   528: astore_1
      //   529: aconst_null
      //   530: astore_2
      //   531: aconst_null
      //   532: astore_3
      //   533: goto -72 -> 461
      //   536: astore_1
      //   537: aconst_null
      //   538: astore_2
      //   539: goto -78 -> 461
      //   542: astore_1
      //   543: aload 7
      //   545: astore_2
      //   546: aload 6
      //   548: astore_3
      //   549: aload 5
      //   551: astore 4
      //   553: goto -92 -> 461
      //   556: astore_2
      //   557: aconst_null
      //   558: astore_1
      //   559: aconst_null
      //   560: astore_3
      //   561: goto -208 -> 353
      //   564: astore_2
      //   565: aconst_null
      //   566: astore_1
      //   567: goto -214 -> 353
      //   570: astore_2
      //   571: goto -218 -> 353
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	574	0	paramInt	int
      //   0	574	1	paramFile	File
      //   59	169	2	localObject1	Object
      //   259	1	2	localException1	Exception
      //   270	1	2	localException2	Exception
      //   312	1	2	localException3	Exception
      //   323	1	2	localException4	Exception
      //   345	30	2	localException5	Exception
      //   420	1	2	localException6	Exception
      //   431	1	2	localException7	Exception
      //   455	29	2	localObject2	Object
      //   517	1	2	localException8	Exception
      //   530	16	2	localFile1	File
      //   556	1	2	localException9	Exception
      //   564	1	2	localException10	Exception
      //   570	1	2	localException11	Exception
      //   35	441	3	localInputStreamReader1	java.io.InputStreamReader
      //   506	1	3	localException12	Exception
      //   532	29	3	localObject3	Object
      //   24	443	4	localFileInputStream1	java.io.FileInputStream
      //   494	1	4	localException13	Exception
      //   551	1	4	localObject4	Object
      //   53	497	5	localFileInputStream2	java.io.FileInputStream
      //   49	498	6	localInputStreamReader2	java.io.InputStreamReader
      //   46	498	7	localFile2	File
      // Exception table:
      //   from	to	target	type
      //   239	244	259	java/lang/Exception
      //   244	248	270	java/lang/Exception
      //   248	252	281	java/lang/Exception
      //   292	297	312	java/lang/Exception
      //   297	301	323	java/lang/Exception
      //   301	305	334	java/lang/Exception
      //   16	26	345	java/lang/Exception
      //   392	397	420	java/lang/Exception
      //   401	405	431	java/lang/Exception
      //   409	413	442	java/lang/Exception
      //   16	26	453	finally
      //   466	471	494	java/lang/Exception
      //   475	479	506	java/lang/Exception
      //   483	487	517	java/lang/Exception
      //   26	36	528	finally
      //   36	45	536	finally
      //   55	60	542	finally
      //   78	85	542	finally
      //   95	102	542	finally
      //   116	122	542	finally
      //   138	147	542	finally
      //   163	172	542	finally
      //   182	195	542	finally
      //   205	239	542	finally
      //   363	387	542	finally
      //   26	36	556	java/lang/Exception
      //   36	45	564	java/lang/Exception
      //   55	60	570	java/lang/Exception
      //   78	85	570	java/lang/Exception
      //   95	102	570	java/lang/Exception
      //   116	122	570	java/lang/Exception
      //   138	147	570	java/lang/Exception
      //   163	172	570	java/lang/Exception
      //   182	195	570	java/lang/Exception
      //   205	239	570	java/lang/Exception
    }
    
    public static boolean checkFileListMd5(int paramInt, String paramString)
    {
      AppMethodBeat.i(155011);
      try
      {
        boolean bool = checkFileListMd5(paramInt, new File(paramString));
        AppMethodBeat.o(155011);
        return bool;
      }
      catch (Exception paramString)
      {
        Log.e("XWalkLib", "checkFileListMd5 error:" + paramString.getMessage());
        AppMethodBeat.o(155011);
      }
      return false;
    }
    
    private static boolean checkFileMd5(int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(155012);
      if ("base.apk".equals(paramString1)) {}
      for (paramString1 = XWalkEnvironment.getDownloadApkPath(paramInt); d.nn(paramString1, paramString2); paramString1 = XWalkEnvironment.getExtractedCoreFile(paramInt, paramString1))
      {
        Log.i("XWalkLib", "checkFileMd5 successful path:".concat(String.valueOf(paramString1)));
        AppMethodBeat.o(155012);
        return true;
      }
      Log.e("XWalkLib", "checkFileMd5 error path:".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(155012);
      return false;
    }
  }
  
  public static class HybridUpdateConfig
    extends XWalkUpdater.EmbededUpdateConfig
  {
    public HybridUpdateConfig(int paramInt, String paramString1, String paramString2)
    {
      super(paramString1, paramString2);
      this.alreadyUnZiped = true;
    }
    
    /* Error */
    public boolean copyPackageToLocal(String paramString1, String paramString2)
    {
      // Byte code:
      //   0: ldc 23
      //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: invokestatic 35	org/xwalk/core/XWalkEnvironment:getApplicationContext	()Landroid/content/Context;
      //   8: invokevirtual 41	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
      //   11: astore 4
      //   13: aconst_null
      //   14: astore 5
      //   16: aload 4
      //   18: aload_1
      //   19: invokevirtual 47	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
      //   22: astore_1
      //   23: new 49	java/lang/StringBuilder
      //   26: dup
      //   27: invokespecial 52	java/lang/StringBuilder:<init>	()V
      //   30: aload_0
      //   31: invokevirtual 56	org/xwalk/core/XWalkUpdater$HybridUpdateConfig:getDownloadPath	()Ljava/lang/String;
      //   34: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   37: ldc 62
      //   39: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   42: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   45: astore 6
      //   47: new 67	java/io/FileOutputStream
      //   50: dup
      //   51: aload 6
      //   53: invokespecial 70	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
      //   56: astore 4
      //   58: ldc 71
      //   60: newarray byte
      //   62: astore 5
      //   64: aload_1
      //   65: aload 5
      //   67: invokevirtual 77	java/io/InputStream:read	([B)I
      //   70: istore_3
      //   71: iload_3
      //   72: iconst_m1
      //   73: if_icmpeq +74 -> 147
      //   76: aload 4
      //   78: aload 5
      //   80: iconst_0
      //   81: iload_3
      //   82: invokevirtual 83	java/io/OutputStream:write	([BII)V
      //   85: goto -21 -> 64
      //   88: astore 5
      //   90: aload_1
      //   91: astore_2
      //   92: aload 4
      //   94: astore_1
      //   95: aload 5
      //   97: astore 4
      //   99: ldc 84
      //   101: new 49	java/lang/StringBuilder
      //   104: dup
      //   105: ldc 86
      //   107: invokespecial 87	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   110: aload 4
      //   112: invokevirtual 90	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   115: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   118: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   121: invokestatic 94	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
      //   124: aload_2
      //   125: ifnull +7 -> 132
      //   128: aload_2
      //   129: invokevirtual 97	java/io/InputStream:close	()V
      //   132: aload_1
      //   133: ifnull +7 -> 140
      //   136: aload_1
      //   137: invokevirtual 98	java/io/OutputStream:close	()V
      //   140: ldc 23
      //   142: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   145: iconst_0
      //   146: ireturn
      //   147: aload 4
      //   149: invokevirtual 104	java/io/OutputStream:flush	()V
      //   152: aload_1
      //   153: ifnull +7 -> 160
      //   156: aload_1
      //   157: invokevirtual 97	java/io/InputStream:close	()V
      //   160: aload 4
      //   162: invokevirtual 98	java/io/OutputStream:close	()V
      //   165: new 106	java/io/File
      //   168: dup
      //   169: aload 6
      //   171: invokespecial 107	java/io/File:<init>	(Ljava/lang/String;)V
      //   174: astore 4
      //   176: aload 4
      //   178: invokevirtual 110	java/io/File:getParent	()Ljava/lang/String;
      //   181: astore_1
      //   182: aload 4
      //   184: invokevirtual 113	java/io/File:getName	()Ljava/lang/String;
      //   187: astore 4
      //   189: new 49	java/lang/StringBuilder
      //   192: dup
      //   193: invokespecial 52	java/lang/StringBuilder:<init>	()V
      //   196: aload 4
      //   198: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   201: ldc 115
      //   203: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   206: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   209: astore 4
      //   211: new 49	java/lang/StringBuilder
      //   214: dup
      //   215: invokespecial 52	java/lang/StringBuilder:<init>	()V
      //   218: aload_1
      //   219: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   222: getstatic 119	java/io/File:separator	Ljava/lang/String;
      //   225: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   228: aload 4
      //   230: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   233: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   236: astore 5
      //   238: aload 5
      //   240: invokestatic 125	com/tencent/xweb/util/c:bcQ	(Ljava/lang/String;)Z
      //   243: pop
      //   244: aload 5
      //   246: aload 6
      //   248: invokestatic 130	com/tencent/xweb/xwalk/u:np	(Ljava/lang/String;Ljava/lang/String;)Z
      //   251: ifne +59 -> 310
      //   254: ldc2_w 131
      //   257: ldc2_w 133
      //   260: lconst_1
      //   261: invokestatic 140	com/tencent/xweb/util/g:t	(JJJ)V
      //   264: ldc 142
      //   266: ldc 144
      //   268: invokestatic 94	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
      //   271: ldc 23
      //   273: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   276: iconst_0
      //   277: ireturn
      //   278: astore_2
      //   279: aconst_null
      //   280: astore_1
      //   281: aload 5
      //   283: astore 4
      //   285: aload_1
      //   286: ifnull +7 -> 293
      //   289: aload_1
      //   290: invokevirtual 97	java/io/InputStream:close	()V
      //   293: aload 4
      //   295: ifnull +8 -> 303
      //   298: aload 4
      //   300: invokevirtual 98	java/io/OutputStream:close	()V
      //   303: ldc 23
      //   305: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   308: aload_2
      //   309: athrow
      //   310: aload 6
      //   312: invokestatic 125	com/tencent/xweb/util/c:bcQ	(Ljava/lang/String;)Z
      //   315: pop
      //   316: new 49	java/lang/StringBuilder
      //   319: dup
      //   320: invokespecial 52	java/lang/StringBuilder:<init>	()V
      //   323: astore 6
      //   325: invokestatic 35	org/xwalk/core/XWalkEnvironment:getApplicationContext	()Landroid/content/Context;
      //   328: astore 7
      //   330: aload 7
      //   332: ifnonnull +121 -> 453
      //   335: ldc 146
      //   337: ldc 148
      //   339: invokestatic 153	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   342: ldc 155
      //   344: astore_1
      //   345: new 106	java/io/File
      //   348: dup
      //   349: aload 6
      //   351: aload_1
      //   352: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   355: getstatic 119	java/io/File:separator	Ljava/lang/String;
      //   358: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   361: ldc 157
      //   363: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   366: getstatic 119	java/io/File:separator	Ljava/lang/String;
      //   369: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   372: ldc 159
      //   374: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   377: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   380: invokespecial 107	java/io/File:<init>	(Ljava/lang/String;)V
      //   383: astore_1
      //   384: new 106	java/io/File
      //   387: dup
      //   388: new 49	java/lang/StringBuilder
      //   391: dup
      //   392: invokespecial 52	java/lang/StringBuilder:<init>	()V
      //   395: aload 5
      //   397: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   400: getstatic 119	java/io/File:separator	Ljava/lang/String;
      //   403: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   406: ldc 159
      //   408: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   411: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   414: invokespecial 107	java/io/File:<init>	(Ljava/lang/String;)V
      //   417: astore 4
      //   419: aload 4
      //   421: invokevirtual 163	java/io/File:exists	()Z
      //   424: ifeq +120 -> 544
      //   427: aload 4
      //   429: invokevirtual 166	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   432: aload_2
      //   433: invokestatic 171	com/tencent/xweb/util/d:nn	(Ljava/lang/String;Ljava/lang/String;)Z
      //   436: ifeq +95 -> 531
      //   439: ldc 84
      //   441: ldc 173
      //   443: invokestatic 94	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
      //   446: ldc 23
      //   448: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   451: iconst_1
      //   452: ireturn
      //   453: aload 7
      //   455: invokevirtual 177	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
      //   458: ifnonnull +16 -> 474
      //   461: ldc 146
      //   463: ldc 179
      //   465: invokestatic 153	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   468: ldc 155
      //   470: astore_1
      //   471: goto -126 -> 345
      //   474: aload 7
      //   476: invokevirtual 177	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
      //   479: getfield 184	android/content/pm/ApplicationInfo:dataDir	Ljava/lang/String;
      //   482: astore 4
      //   484: aload 4
      //   486: ifnull +14 -> 500
      //   489: aload 4
      //   491: astore_1
      //   492: aload 4
      //   494: invokevirtual 189	java/lang/String:isEmpty	()Z
      //   497: ifeq -152 -> 345
      //   500: new 49	java/lang/StringBuilder
      //   503: dup
      //   504: ldc 191
      //   506: invokespecial 87	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   509: aload 7
      //   511: invokevirtual 194	android/content/Context:getPackageName	()Ljava/lang/String;
      //   514: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   517: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   520: astore_1
      //   521: ldc 146
      //   523: ldc 196
      //   525: invokestatic 153	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   528: goto -183 -> 345
      //   531: ldc 84
      //   533: ldc 198
      //   535: invokestatic 94	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
      //   538: aload 4
      //   540: invokevirtual 201	java/io/File:delete	()Z
      //   543: pop
      //   544: aload_1
      //   545: invokevirtual 163	java/io/File:exists	()Z
      //   548: ifne +27 -> 575
      //   551: ldc2_w 131
      //   554: ldc2_w 202
      //   557: lconst_1
      //   558: invokestatic 140	com/tencent/xweb/util/g:t	(JJJ)V
      //   561: ldc 142
      //   563: ldc 205
      //   565: invokestatic 94	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
      //   568: ldc 23
      //   570: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   573: iconst_0
      //   574: ireturn
      //   575: aload_1
      //   576: invokevirtual 166	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   579: aload_2
      //   580: invokestatic 171	com/tencent/xweb/util/d:nn	(Ljava/lang/String;Ljava/lang/String;)Z
      //   583: ifne +25 -> 608
      //   586: ldc 142
      //   588: ldc 207
      //   590: invokestatic 94	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
      //   593: ldc2_w 131
      //   596: ldc2_w 208
      //   599: lconst_1
      //   600: invokestatic 140	com/tencent/xweb/util/g:t	(JJJ)V
      //   603: aload_0
      //   604: iconst_0
      //   605: putfield 212	org/xwalk/core/XWalkUpdater$HybridUpdateConfig:isMatchMd5	Z
      //   608: aload_1
      //   609: aload 4
      //   611: invokestatic 216	com/tencent/xweb/util/c:g	(Ljava/io/File;Ljava/io/File;)Z
      //   614: ifne +27 -> 641
      //   617: ldc 142
      //   619: ldc 218
      //   621: invokestatic 94	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
      //   624: ldc2_w 131
      //   627: ldc2_w 219
      //   630: lconst_1
      //   631: invokestatic 140	com/tencent/xweb/util/g:t	(JJJ)V
      //   634: ldc 23
      //   636: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   639: iconst_0
      //   640: ireturn
      //   641: new 106	java/io/File
      //   644: dup
      //   645: aload 5
      //   647: invokespecial 107	java/io/File:<init>	(Ljava/lang/String;)V
      //   650: astore_1
      //   651: aload_1
      //   652: invokevirtual 223	java/io/File:isDirectory	()Z
      //   655: ifne +17 -> 672
      //   658: ldc 142
      //   660: ldc 225
      //   662: invokestatic 94	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
      //   665: ldc 23
      //   667: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   670: iconst_0
      //   671: ireturn
      //   672: aload_1
      //   673: invokevirtual 229	java/io/File:listFiles	()[Ljava/io/File;
      //   676: aload_0
      //   677: invokevirtual 56	org/xwalk/core/XWalkUpdater$HybridUpdateConfig:getDownloadPath	()Ljava/lang/String;
      //   680: iconst_0
      //   681: invokestatic 233	com/tencent/xweb/xwalk/u:a	([Ljava/io/File;Ljava/lang/String;I)Z
      //   684: ifne +27 -> 711
      //   687: ldc2_w 131
      //   690: ldc2_w 234
      //   693: lconst_1
      //   694: invokestatic 140	com/tencent/xweb/util/g:t	(JJJ)V
      //   697: ldc 142
      //   699: ldc 237
      //   701: invokestatic 94	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
      //   704: ldc 23
      //   706: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   709: iconst_0
      //   710: ireturn
      //   711: ldc 23
      //   713: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   716: iconst_1
      //   717: ireturn
      //   718: astore_1
      //   719: goto -559 -> 160
      //   722: astore_1
      //   723: goto -558 -> 165
      //   726: astore_2
      //   727: goto -595 -> 132
      //   730: astore_1
      //   731: goto -591 -> 140
      //   734: astore_1
      //   735: goto -442 -> 293
      //   738: astore_1
      //   739: goto -436 -> 303
      //   742: astore_2
      //   743: aload 5
      //   745: astore 4
      //   747: goto -462 -> 285
      //   750: astore_2
      //   751: goto -466 -> 285
      //   754: astore 4
      //   756: aload_2
      //   757: astore 5
      //   759: aload 4
      //   761: astore_2
      //   762: aload_1
      //   763: astore 4
      //   765: aload 5
      //   767: astore_1
      //   768: goto -483 -> 285
      //   771: astore 4
      //   773: aconst_null
      //   774: astore_1
      //   775: aconst_null
      //   776: astore_2
      //   777: goto -678 -> 99
      //   780: astore 4
      //   782: aconst_null
      //   783: astore 5
      //   785: aload_1
      //   786: astore_2
      //   787: aload 5
      //   789: astore_1
      //   790: goto -691 -> 99
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	793	0	this	HybridUpdateConfig
      //   0	793	1	paramString1	String
      //   0	793	2	paramString2	String
      //   70	12	3	i	int
      //   11	735	4	localObject1	Object
      //   754	6	4	localObject2	Object
      //   763	1	4	str1	String
      //   771	1	4	localException1	Exception
      //   780	1	4	localException2	Exception
      //   14	65	5	arrayOfByte	byte[]
      //   88	8	5	localException3	Exception
      //   236	552	5	str2	String
      //   45	305	6	localObject3	Object
      //   328	182	7	localContext	Context
      // Exception table:
      //   from	to	target	type
      //   58	64	88	java/lang/Exception
      //   64	71	88	java/lang/Exception
      //   76	85	88	java/lang/Exception
      //   147	152	88	java/lang/Exception
      //   16	23	278	finally
      //   156	160	718	java/lang/Exception
      //   160	165	722	java/io/IOException
      //   128	132	726	java/lang/Exception
      //   136	140	730	java/io/IOException
      //   289	293	734	java/lang/Exception
      //   298	303	738	java/io/IOException
      //   23	58	742	finally
      //   58	64	750	finally
      //   64	71	750	finally
      //   76	85	750	finally
      //   147	152	750	finally
      //   99	124	754	finally
      //   16	23	771	java/lang/Exception
      //   23	58	780	java/lang/Exception
    }
  }
  
  public static class LibUpdateConfig
    extends XWalkUpdater.EmbededUpdateConfig
  {
    public LibUpdateConfig(int paramInt, String paramString1, String paramString2)
    {
      super(paramString1, paramString2);
    }
    
    public boolean copyPackageToLocal(String paramString1, String paramString2)
    {
      AppMethodBeat.i(207651);
      Object localObject = ai.gfQ();
      paramString1 = (String)localObject + File.separator + paramString1;
      localObject = new File(paramString1);
      File localFile = new File(getDownloadPath());
      if (localFile.exists())
      {
        if (d.nn(localFile.getAbsolutePath(), paramString2))
        {
          XWalkEnvironment.addXWalkInitializeLog("lib_installer", " already have file and md5 matched");
          AppMethodBeat.o(207651);
          return true;
        }
        XWalkEnvironment.addXWalkInitializeLog("lib_installer", " already have file but md5 not matched");
        localFile.delete();
      }
      if (!((File)localObject).exists())
      {
        g.t(903L, 129L, 1L);
        XWalkEnvironment.addXWalkInitializeLog("lib_installer", " src file not find:".concat(String.valueOf(paramString1)));
        AppMethodBeat.o(207651);
        return false;
      }
      if (!d.nn(((File)localObject).getAbsolutePath(), paramString2))
      {
        g.t(903L, 130L, 1L);
        XWalkEnvironment.addXWalkInitializeLog("lib_installer", " src file MD5 not match");
      }
      if (!com.tencent.xweb.util.c.g((File)localObject, localFile))
      {
        g.t(903L, 131L, 1L);
        XWalkEnvironment.addXWalkInitializeLog("lib_installer", " copy file failed");
        AppMethodBeat.o(207651);
        return false;
      }
      AppMethodBeat.o(207651);
      return true;
    }
  }
  
  public static class PatchFileConfig
  {
    public String originalFileName;
    public int originalFileType;
    public String patchEndFileMd5;
    public String patchFileName;
    public int type;
    
    public boolean isExtractedFile()
    {
      return this.originalFileType == 2;
    }
    
    public boolean isOriginalFileTypeApk()
    {
      return this.originalFileType == 1;
    }
    
    public boolean isTypeAdd()
    {
      return this.type == 1;
    }
    
    public boolean isTypeModify()
    {
      return this.type == 2;
    }
    
    public boolean isTypeRemove()
    {
      return this.type == 3;
    }
    
    public String toString()
    {
      AppMethodBeat.i(155013);
      String str = "PatchFileConfig type:" + this.type + ",originalFileType:" + this.originalFileType + ",originalFileName:" + this.originalFileName + ",patchFileName:" + this.patchFileName + ",patchEndFileMd5:" + this.patchEndFileMd5;
      AppMethodBeat.o(155013);
      return str;
    }
  }
  
  public static class PatchFileConfigParser
  {
    private static final String ADD_FLAG = "ADD:";
    private static final int ADD_TYPE = 1;
    private static final int APK_FILE_TYPE = 1;
    private static final String DEL_FLAG = "DEL:";
    private static final int DEL_TYPE = 3;
    private static final int EXTRACTED_FILE_TYPE = 2;
    private static final String MOD_FLAG = "MOD:";
    private static final int MOD_TYPE = 2;
    private static final String PATCH_SUFFIX = ".patch";
    
    /* Error */
    public static ArrayList<XWalkUpdater.PatchFileConfig> getPatchFileConfigList(int paramInt)
    {
      // Byte code:
      //   0: ldc 39
      //   2: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: new 47	java/io/FileInputStream
      //   8: dup
      //   9: new 49	java/io/File
      //   12: dup
      //   13: iload_0
      //   14: invokestatic 55	org/xwalk/core/XWalkEnvironment:getPatchConfig	(I)Ljava/lang/String;
      //   17: invokespecial 58	java/io/File:<init>	(Ljava/lang/String;)V
      //   20: invokespecial 61	java/io/FileInputStream:<init>	(Ljava/io/File;)V
      //   23: astore 6
      //   25: new 63	java/io/InputStreamReader
      //   28: dup
      //   29: aload 6
      //   31: invokespecial 66	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
      //   34: astore 5
      //   36: new 68	java/io/BufferedReader
      //   39: dup
      //   40: aload 5
      //   42: invokespecial 71	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
      //   45: astore 4
      //   47: aload 4
      //   49: astore 9
      //   51: aload 5
      //   53: astore 8
      //   55: aload 6
      //   57: astore 7
      //   59: new 73	java/util/ArrayList
      //   62: dup
      //   63: invokespecial 74	java/util/ArrayList:<init>	()V
      //   66: astore 10
      //   68: aload 4
      //   70: astore 9
      //   72: aload 5
      //   74: astore 8
      //   76: aload 6
      //   78: astore 7
      //   80: aload 4
      //   82: invokevirtual 78	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   85: astore_3
      //   86: aload_3
      //   87: ifnull +524 -> 611
      //   90: aload_3
      //   91: ifnull -23 -> 68
      //   94: aload 4
      //   96: astore 9
      //   98: aload 5
      //   100: astore 8
      //   102: aload 6
      //   104: astore 7
      //   106: aload_3
      //   107: invokevirtual 84	java/lang/String:isEmpty	()Z
      //   110: ifne -42 -> 68
      //   113: aload 4
      //   115: astore 9
      //   117: aload 5
      //   119: astore 8
      //   121: aload 6
      //   123: astore 7
      //   125: aload_3
      //   126: ldc 11
      //   128: invokevirtual 88	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   131: ifeq +305 -> 436
      //   134: aload 4
      //   136: astore 9
      //   138: aload 5
      //   140: astore 8
      //   142: aload 6
      //   144: astore 7
      //   146: aload_3
      //   147: iconst_4
      //   148: invokevirtual 91	java/lang/String:substring	(I)Ljava/lang/String;
      //   151: astore_3
      //   152: iconst_1
      //   153: istore_0
      //   154: aload 4
      //   156: astore 9
      //   158: aload 5
      //   160: astore 8
      //   162: aload 6
      //   164: astore 7
      //   166: aload_3
      //   167: ldc 93
      //   169: invokevirtual 97	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
      //   172: astore_3
      //   173: aload 4
      //   175: astore 9
      //   177: aload 5
      //   179: astore 8
      //   181: aload 6
      //   183: astore 7
      //   185: aload_3
      //   186: arraylength
      //   187: istore_2
      //   188: iconst_0
      //   189: istore_1
      //   190: iload_1
      //   191: iload_2
      //   192: if_icmpge -124 -> 68
      //   195: aload_3
      //   196: iload_1
      //   197: aaload
      //   198: astore 11
      //   200: aload 11
      //   202: ifnull +532 -> 734
      //   205: aload 4
      //   207: astore 9
      //   209: aload 5
      //   211: astore 8
      //   213: aload 6
      //   215: astore 7
      //   217: aload 11
      //   219: invokevirtual 84	java/lang/String:isEmpty	()Z
      //   222: ifne +512 -> 734
      //   225: aload 4
      //   227: astore 9
      //   229: aload 5
      //   231: astore 8
      //   233: aload 6
      //   235: astore 7
      //   237: new 99	org/xwalk/core/XWalkUpdater$PatchFileConfig
      //   240: dup
      //   241: invokespecial 100	org/xwalk/core/XWalkUpdater$PatchFileConfig:<init>	()V
      //   244: astore 12
      //   246: aload 4
      //   248: astore 9
      //   250: aload 5
      //   252: astore 8
      //   254: aload 6
      //   256: astore 7
      //   258: aload 12
      //   260: aload 11
      //   262: putfield 103	org/xwalk/core/XWalkUpdater$PatchFileConfig:originalFileName	Ljava/lang/String;
      //   265: aload 4
      //   267: astore 9
      //   269: aload 5
      //   271: astore 8
      //   273: aload 6
      //   275: astore 7
      //   277: aload 12
      //   279: iload_0
      //   280: putfield 106	org/xwalk/core/XWalkUpdater$PatchFileConfig:type	I
      //   283: iload_0
      //   284: iconst_2
      //   285: if_icmpne +43 -> 328
      //   288: aload 4
      //   290: astore 9
      //   292: aload 5
      //   294: astore 8
      //   296: aload 6
      //   298: astore 7
      //   300: aload 12
      //   302: new 108	java/lang/StringBuilder
      //   305: dup
      //   306: invokespecial 109	java/lang/StringBuilder:<init>	()V
      //   309: aload 12
      //   311: getfield 103	org/xwalk/core/XWalkUpdater$PatchFileConfig:originalFileName	Ljava/lang/String;
      //   314: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   317: ldc 29
      //   319: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   322: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   325: putfield 119	org/xwalk/core/XWalkUpdater$PatchFileConfig:patchFileName	Ljava/lang/String;
      //   328: iload_0
      //   329: iconst_2
      //   330: if_icmpne +194 -> 524
      //   333: aload 4
      //   335: astore 9
      //   337: aload 5
      //   339: astore 8
      //   341: aload 6
      //   343: astore 7
      //   345: aload 12
      //   347: getfield 103	org/xwalk/core/XWalkUpdater$PatchFileConfig:originalFileName	Ljava/lang/String;
      //   350: ldc 121
      //   352: invokevirtual 125	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   355: ifeq +169 -> 524
      //   358: aload 4
      //   360: astore 9
      //   362: aload 5
      //   364: astore 8
      //   366: aload 6
      //   368: astore 7
      //   370: aload 12
      //   372: iconst_1
      //   373: putfield 128	org/xwalk/core/XWalkUpdater$PatchFileConfig:originalFileType	I
      //   376: aload 4
      //   378: astore 9
      //   380: aload 5
      //   382: astore 8
      //   384: aload 6
      //   386: astore 7
      //   388: ldc 130
      //   390: new 108	java/lang/StringBuilder
      //   393: dup
      //   394: ldc 132
      //   396: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   399: aload 12
      //   401: invokevirtual 134	org/xwalk/core/XWalkUpdater$PatchFileConfig:toString	()Ljava/lang/String;
      //   404: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   407: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   410: invokestatic 140	org/xwalk/core/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   413: aload 4
      //   415: astore 9
      //   417: aload 5
      //   419: astore 8
      //   421: aload 6
      //   423: astore 7
      //   425: aload 10
      //   427: aload 12
      //   429: invokevirtual 143	java/util/ArrayList:add	(Ljava/lang/Object;)Z
      //   432: pop
      //   433: goto +301 -> 734
      //   436: aload 4
      //   438: astore 9
      //   440: aload 5
      //   442: astore 8
      //   444: aload 6
      //   446: astore 7
      //   448: aload_3
      //   449: ldc 25
      //   451: invokevirtual 88	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   454: ifeq +26 -> 480
      //   457: aload 4
      //   459: astore 9
      //   461: aload 5
      //   463: astore 8
      //   465: aload 6
      //   467: astore 7
      //   469: aload_3
      //   470: iconst_4
      //   471: invokevirtual 91	java/lang/String:substring	(I)Ljava/lang/String;
      //   474: astore_3
      //   475: iconst_2
      //   476: istore_0
      //   477: goto -323 -> 154
      //   480: aload 4
      //   482: astore 9
      //   484: aload 5
      //   486: astore 8
      //   488: aload 6
      //   490: astore 7
      //   492: aload_3
      //   493: ldc 18
      //   495: invokevirtual 88	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   498: ifeq +231 -> 729
      //   501: aload 4
      //   503: astore 9
      //   505: aload 5
      //   507: astore 8
      //   509: aload 6
      //   511: astore 7
      //   513: aload_3
      //   514: iconst_4
      //   515: invokevirtual 91	java/lang/String:substring	(I)Ljava/lang/String;
      //   518: astore_3
      //   519: iconst_3
      //   520: istore_0
      //   521: goto -367 -> 154
      //   524: aload 4
      //   526: astore 9
      //   528: aload 5
      //   530: astore 8
      //   532: aload 6
      //   534: astore 7
      //   536: aload 12
      //   538: iconst_2
      //   539: putfield 128	org/xwalk/core/XWalkUpdater$PatchFileConfig:originalFileType	I
      //   542: goto -166 -> 376
      //   545: astore 7
      //   547: aload 4
      //   549: astore_3
      //   550: aload 7
      //   552: astore 4
      //   554: aload_3
      //   555: astore 9
      //   557: aload 5
      //   559: astore 8
      //   561: aload 6
      //   563: astore 7
      //   565: ldc 130
      //   567: new 108	java/lang/StringBuilder
      //   570: dup
      //   571: ldc 145
      //   573: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   576: aload 4
      //   578: invokevirtual 148	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   581: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   584: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   587: invokestatic 151	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   590: aload 6
      //   592: invokestatic 157	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
      //   595: aload 5
      //   597: invokestatic 157	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
      //   600: aload_3
      //   601: invokestatic 157	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
      //   604: ldc 39
      //   606: invokestatic 160	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   609: aconst_null
      //   610: areturn
      //   611: aload 6
      //   613: invokestatic 157	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
      //   616: aload 5
      //   618: invokestatic 157	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
      //   621: aload 4
      //   623: invokestatic 157	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
      //   626: ldc 39
      //   628: invokestatic 160	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   631: aload 10
      //   633: areturn
      //   634: astore_3
      //   635: aconst_null
      //   636: astore 4
      //   638: aconst_null
      //   639: astore 5
      //   641: aconst_null
      //   642: astore 6
      //   644: aload 6
      //   646: invokestatic 157	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
      //   649: aload 5
      //   651: invokestatic 157	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
      //   654: aload 4
      //   656: invokestatic 157	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
      //   659: ldc 39
      //   661: invokestatic 160	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   664: aload_3
      //   665: athrow
      //   666: astore_3
      //   667: aconst_null
      //   668: astore 4
      //   670: aconst_null
      //   671: astore 5
      //   673: goto -29 -> 644
      //   676: astore_3
      //   677: aconst_null
      //   678: astore 4
      //   680: goto -36 -> 644
      //   683: astore_3
      //   684: aload 9
      //   686: astore 4
      //   688: aload 8
      //   690: astore 5
      //   692: aload 7
      //   694: astore 6
      //   696: goto -52 -> 644
      //   699: astore 4
      //   701: aconst_null
      //   702: astore_3
      //   703: aconst_null
      //   704: astore 5
      //   706: aconst_null
      //   707: astore 6
      //   709: goto -155 -> 554
      //   712: astore 4
      //   714: aconst_null
      //   715: astore_3
      //   716: aconst_null
      //   717: astore 5
      //   719: goto -165 -> 554
      //   722: astore 4
      //   724: aconst_null
      //   725: astore_3
      //   726: goto -172 -> 554
      //   729: iconst_0
      //   730: istore_0
      //   731: goto -577 -> 154
      //   734: iload_1
      //   735: iconst_1
      //   736: iadd
      //   737: istore_1
      //   738: goto -548 -> 190
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	741	0	paramInt	int
      //   189	549	1	i	int
      //   187	6	2	j	int
      //   85	516	3	localObject1	Object
      //   634	31	3	localObject2	Object
      //   666	1	3	localObject3	Object
      //   676	1	3	localObject4	Object
      //   683	1	3	localObject5	Object
      //   702	24	3	localObject6	Object
      //   45	642	4	localObject7	Object
      //   699	1	4	localException1	Exception
      //   712	1	4	localException2	Exception
      //   722	1	4	localException3	Exception
      //   34	684	5	localObject8	Object
      //   23	685	6	localObject9	Object
      //   57	478	7	localObject10	Object
      //   545	6	7	localException4	Exception
      //   563	130	7	localObject11	Object
      //   53	636	8	localObject12	Object
      //   49	636	9	localObject13	Object
      //   66	566	10	localArrayList	ArrayList
      //   198	63	11	localObject14	Object
      //   244	293	12	localPatchFileConfig	XWalkUpdater.PatchFileConfig
      // Exception table:
      //   from	to	target	type
      //   59	68	545	java/lang/Exception
      //   80	86	545	java/lang/Exception
      //   106	113	545	java/lang/Exception
      //   125	134	545	java/lang/Exception
      //   146	152	545	java/lang/Exception
      //   166	173	545	java/lang/Exception
      //   185	188	545	java/lang/Exception
      //   217	225	545	java/lang/Exception
      //   237	246	545	java/lang/Exception
      //   258	265	545	java/lang/Exception
      //   277	283	545	java/lang/Exception
      //   300	328	545	java/lang/Exception
      //   345	358	545	java/lang/Exception
      //   370	376	545	java/lang/Exception
      //   388	413	545	java/lang/Exception
      //   425	433	545	java/lang/Exception
      //   448	457	545	java/lang/Exception
      //   469	475	545	java/lang/Exception
      //   492	501	545	java/lang/Exception
      //   513	519	545	java/lang/Exception
      //   536	542	545	java/lang/Exception
      //   5	25	634	finally
      //   25	36	666	finally
      //   36	47	676	finally
      //   59	68	683	finally
      //   80	86	683	finally
      //   106	113	683	finally
      //   125	134	683	finally
      //   146	152	683	finally
      //   166	173	683	finally
      //   185	188	683	finally
      //   217	225	683	finally
      //   237	246	683	finally
      //   258	265	683	finally
      //   277	283	683	finally
      //   300	328	683	finally
      //   345	358	683	finally
      //   370	376	683	finally
      //   388	413	683	finally
      //   425	433	683	finally
      //   448	457	683	finally
      //   469	475	683	finally
      //   492	501	683	finally
      //   513	519	683	finally
      //   536	542	683	finally
      //   565	590	683	finally
      //   5	25	699	java/lang/Exception
      //   25	36	712	java/lang/Exception
      //   36	47	722	java/lang/Exception
    }
  }
  
  public static class UpdateConfig
  {
    public String abi;
    public boolean alreadyUnZiped;
    public int apkVer;
    public boolean bTryUseSharedCore;
    public boolean bUseCdn;
    public String downUrl;
    public String downloadFileMd5;
    public boolean isMatchMd5;
    public boolean isPatchUpdate;
    public int nPatchTargetVersion;
    public String patchEndFileMd5;
    public Scheduler scheduler;
    public String versionDetail;
    
    public UpdateConfig(String paramString1, boolean paramBoolean, int paramInt1, String paramString2, int paramInt2)
    {
      AppMethodBeat.i(207652);
      this.apkVer = -1;
      this.isMatchMd5 = false;
      this.isPatchUpdate = paramBoolean;
      this.downUrl = paramString1;
      this.apkVer = paramInt1;
      this.abi = paramString2;
      this.nPatchTargetVersion = paramInt2;
      if (!checkValid())
      {
        paramString1 = new RuntimeException("royle:UpdateConfig is not valid");
        AppMethodBeat.o(207652);
        throw paramString1;
      }
      AppMethodBeat.o(207652);
    }
    
    public UpdateConfig(String paramString1, boolean paramBoolean, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2)
    {
      AppMethodBeat.i(207653);
      this.apkVer = -1;
      this.isMatchMd5 = true;
      this.downloadFileMd5 = paramString1;
      this.isPatchUpdate = paramBoolean;
      this.patchEndFileMd5 = paramString2;
      this.downUrl = paramString3;
      this.apkVer = paramInt1;
      this.abi = paramString4;
      this.nPatchTargetVersion = paramInt2;
      if (!checkValid())
      {
        paramString1 = new RuntimeException("royle:UpdateConfig is not valid");
        AppMethodBeat.o(207653);
        throw paramString1;
      }
      AppMethodBeat.o(207653);
    }
    
    public boolean checkValid()
    {
      AppMethodBeat.i(155018);
      if ((this.isMatchMd5) && ((this.downloadFileMd5 == null) || (this.downloadFileMd5.isEmpty())))
      {
        AppMethodBeat.o(155018);
        return false;
      }
      if ((this.downUrl == null) || (this.downUrl.isEmpty()))
      {
        AppMethodBeat.o(155018);
        return false;
      }
      if (this.apkVer == -1)
      {
        AppMethodBeat.o(155018);
        return false;
      }
      if ((this.isMatchMd5) && (this.isPatchUpdate) && ((this.patchEndFileMd5 == null) || (this.patchEndFileMd5.isEmpty())))
      {
        AppMethodBeat.o(155018);
        return false;
      }
      AppMethodBeat.o(155018);
      return true;
    }
    
    public String getDownloadPath()
    {
      AppMethodBeat.i(155017);
      if (checkValid())
      {
        if (this.isPatchUpdate)
        {
          localObject = XWalkEnvironment.getDownloadPatchPath(this.apkVer);
          AppMethodBeat.o(155017);
          return localObject;
        }
        localObject = XWalkEnvironment.getDownloadZipDir(this.apkVer);
        AppMethodBeat.o(155017);
        return localObject;
      }
      Object localObject = new RuntimeException("royle:UpdateConfig is not valid");
      AppMethodBeat.o(155017);
      throw ((Throwable)localObject);
    }
    
    public String getLogSelf()
    {
      AppMethodBeat.i(155019);
      if (checkValid())
      {
        String str = "UpdateConfig isMatchMd5:" + this.isMatchMd5 + " downloadFileMd5:" + this.downloadFileMd5 + ",isPatchUpdate:" + this.isPatchUpdate + ",downUrl:" + this.downUrl + ",apkVer:" + this.apkVer + ",useCDN:" + this.bUseCdn + ",downloadPath:" + getDownloadPath() + ".";
        AppMethodBeat.o(155019);
        return str;
      }
      AppMethodBeat.o(155019);
      return "UpdateConfig is not valid";
    }
    
    public int getUpdateBizType()
    {
      if (this.isPatchUpdate) {
        return 2;
      }
      return 1;
    }
  }
  
  public static abstract interface XWalkBackgroundUpdateListener
  {
    public abstract void onXWalkUpdateCancelled();
    
    public abstract void onXWalkUpdateCompleted(Scheduler paramScheduler);
    
    public abstract void onXWalkUpdateFailed(int paramInt, Scheduler paramScheduler);
    
    public abstract void onXWalkUpdateProgress(int paramInt);
    
    public abstract void onXWalkUpdateStarted();
  }
  
  public static abstract interface XWalkUpdateListener
  {
    public abstract void onXWalkUpdateCancelled();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.xwalk.core.XWalkUpdater
 * JD-Core Version:    0.7.0.1
 */