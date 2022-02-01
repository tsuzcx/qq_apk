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
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.XWebCoreContentProvider;
import com.tencent.xweb.a;
import com.tencent.xweb.s;
import com.tencent.xweb.util.BSpatch;
import com.tencent.xweb.util.d;
import com.tencent.xweb.util.h;
import com.tencent.xweb.util.i;
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
    //   0: ldc 139
    //   2: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 141	java/io/File
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 144	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_3
    //   14: aload_3
    //   15: invokevirtual 148	java/io/File:exists	()Z
    //   18: ifne +106 -> 124
    //   21: iload_2
    //   22: invokestatic 154	org/xwalk/core/XWalkEnvironment:isTestVersion	(I)Z
    //   25: ifne +750 -> 775
    //   28: iload_2
    //   29: sipush 362
    //   32: if_icmpge +31 -> 63
    //   35: goto +740 -> 775
    //   38: iload_2
    //   39: ifeq +29 -> 68
    //   42: ldc 79
    //   44: ldc 156
    //   46: aload_0
    //   47: invokestatic 162	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   50: invokevirtual 166	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   53: invokestatic 172	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: ldc 139
    //   58: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: iconst_1
    //   62: ireturn
    //   63: iconst_0
    //   64: istore_2
    //   65: goto -27 -> 38
    //   68: ldc2_w 173
    //   71: invokestatic 180	com/tencent/xweb/util/h:OQ	(J)V
    //   74: ldc 79
    //   76: ldc 182
    //   78: aload_0
    //   79: invokestatic 162	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   82: invokevirtual 166	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   85: invokestatic 172	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: ldc 184
    //   90: ldc 186
    //   92: ldc 188
    //   94: invokestatic 194	com/tencent/xweb/a:nS	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   97: invokevirtual 198	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   100: ifeq +17 -> 117
    //   103: ldc 79
    //   105: ldc 200
    //   107: invokestatic 172	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: ldc 139
    //   112: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: iconst_1
    //   116: ireturn
    //   117: ldc 139
    //   119: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: iconst_0
    //   123: ireturn
    //   124: new 202	java/io/FileInputStream
    //   127: dup
    //   128: aload_3
    //   129: invokespecial 205	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   132: astore 4
    //   134: new 207	java/io/InputStreamReader
    //   137: dup
    //   138: aload 4
    //   140: invokespecial 210	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   143: astore_3
    //   144: new 212	java/io/BufferedReader
    //   147: dup
    //   148: aload_3
    //   149: invokespecial 215	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   152: astore_0
    //   153: aload_0
    //   154: astore 7
    //   156: aload_3
    //   157: astore 6
    //   159: aload 4
    //   161: astore 5
    //   163: aload_0
    //   164: invokevirtual 219	java/io/BufferedReader:readLine	()Ljava/lang/String;
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
    //   191: invokevirtual 222	java/lang/String:isEmpty	()Z
    //   194: ifne -41 -> 153
    //   197: aload_0
    //   198: astore 7
    //   200: aload_3
    //   201: astore 6
    //   203: aload 4
    //   205: astore 5
    //   207: aload 8
    //   209: ldc 224
    //   211: invokevirtual 228	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
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
    //   259: invokevirtual 222	java/lang/String:isEmpty	()Z
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
    //   286: invokevirtual 222	java/lang/String:isEmpty	()Z
    //   289: ifne -136 -> 153
    //   292: aload_0
    //   293: astore 7
    //   295: aload_3
    //   296: astore 6
    //   298: aload 4
    //   300: astore 5
    //   302: new 141	java/io/File
    //   305: dup
    //   306: aload_1
    //   307: aload 8
    //   309: iconst_0
    //   310: aaload
    //   311: invokespecial 230	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   314: astore 9
    //   316: aload_0
    //   317: astore 7
    //   319: aload_3
    //   320: astore 6
    //   322: aload 4
    //   324: astore 5
    //   326: aload 9
    //   328: invokestatic 236	com/tencent/xweb/util/d:C	(Ljava/io/File;)Ljava/lang/String;
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
    //   349: invokevirtual 198	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   352: ifne -199 -> 153
    //   355: aload_0
    //   356: astore 7
    //   358: aload_3
    //   359: astore 6
    //   361: aload 4
    //   363: astore 5
    //   365: ldc 79
    //   367: new 238	java/lang/StringBuilder
    //   370: dup
    //   371: ldc 240
    //   373: invokespecial 241	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   376: aload 8
    //   378: iconst_0
    //   379: aaload
    //   380: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: ldc 247
    //   385: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: aload 8
    //   390: iconst_1
    //   391: aaload
    //   392: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: ldc 249
    //   397: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: aload 10
    //   402: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   408: invokestatic 172	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   411: aload_0
    //   412: astore 7
    //   414: aload_3
    //   415: astore 6
    //   417: aload 4
    //   419: astore 5
    //   421: aload 9
    //   423: invokevirtual 255	java/io/File:delete	()Z
    //   426: pop
    //   427: aload 4
    //   429: invokevirtual 258	java/io/FileInputStream:close	()V
    //   432: aload_3
    //   433: invokevirtual 259	java/io/InputStreamReader:close	()V
    //   436: aload_0
    //   437: invokevirtual 260	java/io/BufferedReader:close	()V
    //   440: ldc 139
    //   442: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   445: iconst_0
    //   446: ireturn
    //   447: astore_1
    //   448: ldc 79
    //   450: ldc_w 262
    //   453: invokestatic 267	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   456: goto -24 -> 432
    //   459: astore_1
    //   460: ldc 79
    //   462: ldc_w 269
    //   465: invokestatic 267	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   468: goto -32 -> 436
    //   471: astore_0
    //   472: ldc 79
    //   474: ldc_w 271
    //   477: invokestatic 267	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   480: goto -40 -> 440
    //   483: aload 4
    //   485: invokevirtual 258	java/io/FileInputStream:close	()V
    //   488: aload_3
    //   489: invokevirtual 259	java/io/InputStreamReader:close	()V
    //   492: aload_0
    //   493: invokevirtual 260	java/io/BufferedReader:close	()V
    //   496: ldc 139
    //   498: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   501: iconst_1
    //   502: ireturn
    //   503: astore_1
    //   504: ldc 79
    //   506: ldc_w 262
    //   509: invokestatic 267	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   512: goto -24 -> 488
    //   515: astore_1
    //   516: ldc 79
    //   518: ldc_w 269
    //   521: invokestatic 267	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   524: goto -32 -> 492
    //   527: astore_0
    //   528: ldc 79
    //   530: ldc_w 271
    //   533: invokestatic 267	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   557: ldc 79
    //   559: new 238	java/lang/StringBuilder
    //   562: dup
    //   563: ldc_w 273
    //   566: invokespecial 241	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   569: aload_1
    //   570: invokevirtual 276	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   573: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   579: invokestatic 267	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   582: aload 4
    //   584: ifnull +8 -> 592
    //   587: aload 4
    //   589: invokevirtual 258	java/io/FileInputStream:close	()V
    //   592: aload_3
    //   593: ifnull +7 -> 600
    //   596: aload_3
    //   597: invokevirtual 259	java/io/InputStreamReader:close	()V
    //   600: aload_0
    //   601: ifnull +7 -> 608
    //   604: aload_0
    //   605: invokevirtual 260	java/io/BufferedReader:close	()V
    //   608: ldc 139
    //   610: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   613: iconst_0
    //   614: ireturn
    //   615: astore_1
    //   616: ldc 79
    //   618: ldc_w 262
    //   621: invokestatic 267	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   624: goto -32 -> 592
    //   627: astore_1
    //   628: ldc 79
    //   630: ldc_w 269
    //   633: invokestatic 267	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   636: goto -36 -> 600
    //   639: astore_0
    //   640: ldc 79
    //   642: ldc_w 271
    //   645: invokestatic 267	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   666: invokevirtual 258	java/io/FileInputStream:close	()V
    //   669: aload_3
    //   670: ifnull +7 -> 677
    //   673: aload_3
    //   674: invokevirtual 259	java/io/InputStreamReader:close	()V
    //   677: aload_1
    //   678: ifnull +7 -> 685
    //   681: aload_1
    //   682: invokevirtual 260	java/io/BufferedReader:close	()V
    //   685: ldc 139
    //   687: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   690: aload_0
    //   691: athrow
    //   692: astore 4
    //   694: ldc 79
    //   696: ldc_w 262
    //   699: invokestatic 267	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   702: goto -33 -> 669
    //   705: astore_3
    //   706: ldc 79
    //   708: ldc_w 269
    //   711: invokestatic 267	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   714: goto -37 -> 677
    //   717: astore_1
    //   718: ldc 79
    //   720: ldc_w 271
    //   723: invokestatic 267	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    AppMethodBeat.i(207401);
    getSpForEmbedInstall("armeabi-v7a").edit().putInt("INSTALLED_EMBED_VERSION", -1).commit();
    getSpForEmbedInstall("arm64-v8a").edit().putInt("INSTALLED_EMBED_VERSION", -1).commit();
    XWalkEnvironment.addXWalkInitializeLog("EMBED_INSTALLER", "do clearLastTryEmebedVersion");
    AppMethodBeat.o(207401);
  }
  
  public static void doInstallFromEmebed()
  {
    i = -1;
    AppMethodBeat.i(207404);
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
        XWalkUpdater.LibUpdateConfig localLibUpdateConfig;
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
          AppMethodBeat.o(207404);
          return;
        }
        if (j == 0)
        {
          XWalkEnvironment.addXWalkInitializeLog("EMBED_INSTALLER", "install skip ,this version was tried");
          AppMethodBeat.o(207404);
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
          AppMethodBeat.o(207404);
          return;
        }
      }
      catch (Exception localException1)
      {
        i = 0;
        h.s(903L, 128L, 1L);
        XWalkEnvironment.addXWalkInitializeLog("EMBEDED_INSTALLER", "install failed " + localException1.getMessage());
        localSharedPreferences.edit().putInt("INSTALLED_EMBED_VERSION", i).commit();
        AppMethodBeat.o(207404);
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
      localLibUpdateConfig = new XWalkUpdater.LibUpdateConfig(0, "libxwebfullpack.so", "1");
    }
    for (;;)
    {
      Object localObject1 = new XWalkUpdater.AssetsUpdateConfig(0, "libxwebfullpack.so", "1");
      break;
      localObject1 = new XWalkUpdater.HybridUpdateConfig(0, "libxwebfullpack.so", "1");
      break;
      if (!((EmbededUpdateConfig)localObject1).copySuc())
      {
        h.s(903L, 126L, 1L);
        XWalkEnvironment.addXWalkInitializeLog("EMBED_INSTALLER", "copy failed");
        AppMethodBeat.o(207404);
        return;
      }
      ((EmbededUpdateConfig)localObject1).getDownloadPath();
      ((EmbededUpdateConfig)localObject1).versionDetail = "1.0.0_from_lib";
      localObject1 = onHandleFile((UpdateConfig)localObject1);
      if (((Integer)localObject1).intValue() == 0)
      {
        h.s(903L, 127L, 1L);
        s.init();
        p.hQ("finished", 0);
        XWalkEnvironment.refreshAvailableVersion();
      }
      XWalkEnvironment.addXWalkInitializeLog("EMBEDED_INSTALLER", "install from embed ret code =  ".concat(String.valueOf(localObject1)));
      i = 0;
    }
  }
  
  private static Integer extractResource(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(207408);
    for (;;)
    {
      String str = XWalkEnvironment.getExtractedCoreDir(paramInt);
      if (!XWalkDecompressor.extractResource(XWalkEnvironment.getDownloadApkPath(paramInt), str, getResFileList(paramInt)))
      {
        XWalkInitializer.addXWalkInitializeLog("XWalkLib", "extract faield");
        AppMethodBeat.o(207408);
        return Integer.valueOf(-5);
      }
      if (checkExtractResFileLengtgAndMd5(XWalkEnvironment.getDownloadResFileListConfig(paramInt), str, paramInt) == true)
      {
        XWalkInitializer.addXWalkInitializeLog("XWalkLib", "checkExtractResFileLengtgAndMd5 success!!!!");
        try_generate_jar_for_dex_in_dir(str, true);
        if (generateOptDex(paramInt)) {
          break label178;
        }
        h.OQ(251L);
        if (!"true".equalsIgnoreCase(a.nS("update_need_check_dex", "tools"))) {
          break label178;
        }
        AppMethodBeat.o(207408);
        return Integer.valueOf(-101);
      }
      if (mCurrentTimeForRetryRes > 0) {
        break;
      }
      XWalkInitializer.addXWalkInitializeLog("XWalkLib", "checkExtractResFileLengtgAndMd5 failed retry extractResource");
      mCurrentTimeForRetryRes += 1;
    }
    XWalkInitializer.addXWalkInitializeLog("XWalkLib", "checkResourceLengthAndMd5 failed can not retry!!!!!!!!!! mCurrentTimeForRetryRes = " + mCurrentTimeForRetryRes);
    AppMethodBeat.o(207408);
    return Integer.valueOf(-12);
    label178:
    boolean bool = XWebCoreInfo.setVersionForAbi(paramInt, paramString2, paramString1);
    XWalkInitializer.addXWalkInitializeLog("XWalkLib", "do update sucsess");
    h.htW();
    com.tencent.xweb.internal.c.bsw("CHECK_FILES_MD5_TIME_KEY");
    if (!bool)
    {
      XWalkInitializer.addXWalkInitializeLog("XWalkLib", "set version failed");
      AppMethodBeat.o(207408);
      return Integer.valueOf(-101);
    }
    AppMethodBeat.o(207408);
    return Integer.valueOf(0);
  }
  
  private static Integer extractResource(UpdateConfig paramUpdateConfig)
  {
    AppMethodBeat.i(155031);
    paramUpdateConfig = extractResource(paramUpdateConfig.apkVer, paramUpdateConfig.abi, paramUpdateConfig.versionDetail);
    AppMethodBeat.o(155031);
    return paramUpdateConfig;
  }
  
  private static boolean generateOptDex(int paramInt)
  {
    AppMethodBeat.i(155032);
    try
    {
      i.asW(paramInt);
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
    AppMethodBeat.i(207407);
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
          AppMethodBeat.o(207407);
          return;
        }
        localFile.delete();
      }
      paramBoolean = u.j(paramFile, str2);
      Log.i("XWalkLib", "generate .jar from " + str1 + " ret =  " + paramBoolean);
      AppMethodBeat.o(207407);
      return;
    }
    catch (Exception paramFile)
    {
      Log.e("XWalkLib", "generate .jar from " + str1 + " failed. error is " + paramFile.getMessage());
      AppMethodBeat.o(207407);
    }
  }
  
  static void generate_jar_for_dex_in_dir(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(207406);
    paramString = new File(paramString);
    if (!paramString.isDirectory())
    {
      AppMethodBeat.o(207406);
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
    AppMethodBeat.o(207406);
  }
  
  public static int getLastTryInstallVer(String paramString)
  {
    AppMethodBeat.i(207403);
    int i = getSpForEmbedInstall(paramString).getInt("INSTALLED_EMBED_VERSION", -1);
    AppMethodBeat.o(207403);
    return i;
  }
  
  /* Error */
  public static String[] getResFileList(int paramInt)
  {
    // Byte code:
    //   0: ldc_w 553
    //   3: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 557	com/tencent/xweb/a:hsb	()Lcom/tencent/xweb/a;
    //   9: ldc_w 559
    //   12: ldc 188
    //   14: invokevirtual 563	com/tencent/xweb/a:nT	(Ljava/lang/String;Ljava/lang/String;)Z
    //   17: ifeq +23 -> 40
    //   20: ldc 79
    //   22: ldc_w 565
    //   25: invokestatic 172	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: getstatic 569	org/xwalk/core/XWalkEnvironment:DEFAULT_MANDATORY_RESOURCES	[Ljava/lang/String;
    //   31: astore_1
    //   32: ldc_w 553
    //   35: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: aload_1
    //   39: areturn
    //   40: iload_0
    //   41: invokestatic 437	org/xwalk/core/XWalkEnvironment:getDownloadResFileListConfig	(I)Ljava/lang/String;
    //   44: astore_1
    //   45: new 141	java/io/File
    //   48: dup
    //   49: aload_1
    //   50: invokespecial 144	java/io/File:<init>	(Ljava/lang/String;)V
    //   53: astore_2
    //   54: aload_2
    //   55: invokevirtual 148	java/io/File:exists	()Z
    //   58: ifne +35 -> 93
    //   61: ldc 79
    //   63: ldc 182
    //   65: aload_1
    //   66: invokestatic 162	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   69: invokevirtual 166	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   72: invokestatic 172	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   75: ldc2_w 173
    //   78: invokestatic 180	com/tencent/xweb/util/h:OQ	(J)V
    //   81: getstatic 569	org/xwalk/core/XWalkEnvironment:DEFAULT_MANDATORY_RESOURCES	[Ljava/lang/String;
    //   84: astore_1
    //   85: ldc_w 553
    //   88: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: aload_1
    //   92: areturn
    //   93: new 202	java/io/FileInputStream
    //   96: dup
    //   97: aload_2
    //   98: invokespecial 205	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   101: astore 4
    //   103: new 207	java/io/InputStreamReader
    //   106: dup
    //   107: aload 4
    //   109: invokespecial 210	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   112: astore_3
    //   113: new 212	java/io/BufferedReader
    //   116: dup
    //   117: aload_3
    //   118: invokespecial 215	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   121: astore_1
    //   122: aload_1
    //   123: astore 7
    //   125: aload_3
    //   126: astore 6
    //   128: aload 4
    //   130: astore 5
    //   132: new 571	java/util/ArrayList
    //   135: dup
    //   136: invokespecial 572	java/util/ArrayList:<init>	()V
    //   139: astore_2
    //   140: aload_1
    //   141: astore 7
    //   143: aload_3
    //   144: astore 6
    //   146: aload 4
    //   148: astore 5
    //   150: aload_1
    //   151: invokevirtual 219	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   154: astore 8
    //   156: aload 8
    //   158: ifnull +216 -> 374
    //   161: aload 8
    //   163: ifnull -23 -> 140
    //   166: aload_1
    //   167: astore 7
    //   169: aload_3
    //   170: astore 6
    //   172: aload 4
    //   174: astore 5
    //   176: aload 8
    //   178: invokevirtual 222	java/lang/String:isEmpty	()Z
    //   181: ifne -41 -> 140
    //   184: aload_1
    //   185: astore 7
    //   187: aload_3
    //   188: astore 6
    //   190: aload 4
    //   192: astore 5
    //   194: aload 8
    //   196: ldc 224
    //   198: invokevirtual 228	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   201: astore 8
    //   203: aload 8
    //   205: ifnull -65 -> 140
    //   208: aload_1
    //   209: astore 7
    //   211: aload_3
    //   212: astore 6
    //   214: aload 4
    //   216: astore 5
    //   218: aload 8
    //   220: arraylength
    //   221: iconst_2
    //   222: if_icmpne -82 -> 140
    //   225: aload 8
    //   227: iconst_0
    //   228: aaload
    //   229: ifnull -89 -> 140
    //   232: aload_1
    //   233: astore 7
    //   235: aload_3
    //   236: astore 6
    //   238: aload 4
    //   240: astore 5
    //   242: aload 8
    //   244: iconst_0
    //   245: aaload
    //   246: invokevirtual 222	java/lang/String:isEmpty	()Z
    //   249: ifne -109 -> 140
    //   252: aload_1
    //   253: astore 7
    //   255: aload_3
    //   256: astore 6
    //   258: aload 4
    //   260: astore 5
    //   262: aload_2
    //   263: aload 8
    //   265: iconst_0
    //   266: aaload
    //   267: invokevirtual 575	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   270: pop
    //   271: goto -131 -> 140
    //   274: astore_2
    //   275: aload_1
    //   276: astore 7
    //   278: aload_3
    //   279: astore 6
    //   281: aload 4
    //   283: astore 5
    //   285: ldc 79
    //   287: new 238	java/lang/StringBuilder
    //   290: dup
    //   291: ldc_w 273
    //   294: invokespecial 241	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   297: aload_2
    //   298: invokevirtual 276	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   301: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   307: invokestatic 267	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   310: aload_1
    //   311: astore 7
    //   313: aload_3
    //   314: astore 6
    //   316: aload 4
    //   318: astore 5
    //   320: ldc2_w 173
    //   323: invokestatic 180	com/tencent/xweb/util/h:OQ	(J)V
    //   326: aload_1
    //   327: astore 7
    //   329: aload_3
    //   330: astore 6
    //   332: aload 4
    //   334: astore 5
    //   336: getstatic 569	org/xwalk/core/XWalkEnvironment:DEFAULT_MANDATORY_RESOURCES	[Ljava/lang/String;
    //   339: astore_2
    //   340: aload 4
    //   342: ifnull +8 -> 350
    //   345: aload 4
    //   347: invokevirtual 258	java/io/FileInputStream:close	()V
    //   350: aload_3
    //   351: ifnull +7 -> 358
    //   354: aload_3
    //   355: invokevirtual 259	java/io/InputStreamReader:close	()V
    //   358: aload_1
    //   359: ifnull +7 -> 366
    //   362: aload_1
    //   363: invokevirtual 260	java/io/BufferedReader:close	()V
    //   366: ldc_w 553
    //   369: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   372: aload_2
    //   373: areturn
    //   374: aload_1
    //   375: astore 7
    //   377: aload_3
    //   378: astore 6
    //   380: aload 4
    //   382: astore 5
    //   384: aload_2
    //   385: iconst_1
    //   386: anewarray 158	java/lang/String
    //   389: invokevirtual 579	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   392: checkcast 580	[Ljava/lang/String;
    //   395: astore_2
    //   396: aload_2
    //   397: ifnonnull +91 -> 488
    //   400: aload_1
    //   401: astore 7
    //   403: aload_3
    //   404: astore 6
    //   406: aload 4
    //   408: astore 5
    //   410: ldc2_w 173
    //   413: invokestatic 180	com/tencent/xweb/util/h:OQ	(J)V
    //   416: aload_1
    //   417: astore 7
    //   419: aload_3
    //   420: astore 6
    //   422: aload 4
    //   424: astore 5
    //   426: getstatic 569	org/xwalk/core/XWalkEnvironment:DEFAULT_MANDATORY_RESOURCES	[Ljava/lang/String;
    //   429: astore_2
    //   430: aload 4
    //   432: invokevirtual 258	java/io/FileInputStream:close	()V
    //   435: aload_3
    //   436: invokevirtual 259	java/io/InputStreamReader:close	()V
    //   439: aload_1
    //   440: invokevirtual 260	java/io/BufferedReader:close	()V
    //   443: ldc_w 553
    //   446: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   449: aload_2
    //   450: areturn
    //   451: astore 4
    //   453: ldc 79
    //   455: ldc_w 262
    //   458: invokestatic 267	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   461: goto -26 -> 435
    //   464: astore_3
    //   465: ldc 79
    //   467: ldc_w 269
    //   470: invokestatic 267	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   473: goto -34 -> 439
    //   476: astore_1
    //   477: ldc 79
    //   479: ldc_w 271
    //   482: invokestatic 267	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   485: goto -42 -> 443
    //   488: aload 4
    //   490: invokevirtual 258	java/io/FileInputStream:close	()V
    //   493: aload_3
    //   494: invokevirtual 259	java/io/InputStreamReader:close	()V
    //   497: aload_1
    //   498: invokevirtual 260	java/io/BufferedReader:close	()V
    //   501: ldc_w 553
    //   504: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   507: aload_2
    //   508: areturn
    //   509: astore 4
    //   511: ldc 79
    //   513: ldc_w 262
    //   516: invokestatic 267	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   519: goto -26 -> 493
    //   522: astore_3
    //   523: ldc 79
    //   525: ldc_w 269
    //   528: invokestatic 267	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   531: goto -34 -> 497
    //   534: astore_1
    //   535: ldc 79
    //   537: ldc_w 271
    //   540: invokestatic 267	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   543: goto -42 -> 501
    //   546: astore 4
    //   548: ldc 79
    //   550: ldc_w 262
    //   553: invokestatic 267	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   556: goto -206 -> 350
    //   559: astore_3
    //   560: ldc 79
    //   562: ldc_w 269
    //   565: invokestatic 267	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   568: goto -210 -> 358
    //   571: astore_1
    //   572: ldc 79
    //   574: ldc_w 271
    //   577: invokestatic 267	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   580: goto -214 -> 366
    //   583: astore_1
    //   584: aconst_null
    //   585: astore_2
    //   586: aconst_null
    //   587: astore_3
    //   588: aconst_null
    //   589: astore 4
    //   591: aload 4
    //   593: ifnull +8 -> 601
    //   596: aload 4
    //   598: invokevirtual 258	java/io/FileInputStream:close	()V
    //   601: aload_3
    //   602: ifnull +7 -> 609
    //   605: aload_3
    //   606: invokevirtual 259	java/io/InputStreamReader:close	()V
    //   609: aload_2
    //   610: ifnull +7 -> 617
    //   613: aload_2
    //   614: invokevirtual 260	java/io/BufferedReader:close	()V
    //   617: ldc_w 553
    //   620: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   623: aload_1
    //   624: athrow
    //   625: astore 4
    //   627: ldc 79
    //   629: ldc_w 262
    //   632: invokestatic 267	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   635: goto -34 -> 601
    //   638: astore_3
    //   639: ldc 79
    //   641: ldc_w 269
    //   644: invokestatic 267	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   647: goto -38 -> 609
    //   650: astore_2
    //   651: ldc 79
    //   653: ldc_w 271
    //   656: invokestatic 267	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   659: goto -42 -> 617
    //   662: astore_1
    //   663: aconst_null
    //   664: astore_2
    //   665: aconst_null
    //   666: astore_3
    //   667: goto -76 -> 591
    //   670: astore_1
    //   671: aconst_null
    //   672: astore_2
    //   673: goto -82 -> 591
    //   676: astore_1
    //   677: aload 7
    //   679: astore_2
    //   680: aload 6
    //   682: astore_3
    //   683: aload 5
    //   685: astore 4
    //   687: goto -96 -> 591
    //   690: astore_2
    //   691: aconst_null
    //   692: astore_1
    //   693: aconst_null
    //   694: astore_3
    //   695: aconst_null
    //   696: astore 4
    //   698: goto -423 -> 275
    //   701: astore_2
    //   702: aconst_null
    //   703: astore_1
    //   704: aconst_null
    //   705: astore_3
    //   706: goto -431 -> 275
    //   709: astore_2
    //   710: aconst_null
    //   711: astore_1
    //   712: goto -437 -> 275
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	715	0	paramInt	int
    //   31	409	1	localObject1	Object
    //   476	22	1	localException1	Exception
    //   534	1	1	localException2	Exception
    //   571	1	1	localException3	Exception
    //   583	41	1	localObject2	Object
    //   662	1	1	localObject3	Object
    //   670	1	1	localObject4	Object
    //   676	1	1	localObject5	Object
    //   692	20	1	localObject6	Object
    //   53	210	2	localObject7	Object
    //   274	24	2	localException4	Exception
    //   339	275	2	arrayOfString	String[]
    //   650	1	2	localException5	Exception
    //   664	16	2	localObject8	Object
    //   690	1	2	localException6	Exception
    //   701	1	2	localException7	Exception
    //   709	1	2	localException8	Exception
    //   112	324	3	localInputStreamReader1	java.io.InputStreamReader
    //   464	30	3	localException9	Exception
    //   522	1	3	localException10	Exception
    //   559	1	3	localException11	Exception
    //   587	19	3	localObject9	Object
    //   638	1	3	localException12	Exception
    //   666	40	3	localObject10	Object
    //   101	330	4	localFileInputStream1	java.io.FileInputStream
    //   451	38	4	localException13	Exception
    //   509	1	4	localException14	Exception
    //   546	1	4	localException15	Exception
    //   589	8	4	localObject11	Object
    //   625	1	4	localException16	Exception
    //   685	12	4	localObject12	Object
    //   130	554	5	localFileInputStream2	java.io.FileInputStream
    //   126	555	6	localInputStreamReader2	java.io.InputStreamReader
    //   123	555	7	localObject13	Object
    //   154	110	8	localObject14	Object
    // Exception table:
    //   from	to	target	type
    //   132	140	274	java/lang/Exception
    //   150	156	274	java/lang/Exception
    //   176	184	274	java/lang/Exception
    //   194	203	274	java/lang/Exception
    //   218	225	274	java/lang/Exception
    //   242	252	274	java/lang/Exception
    //   262	271	274	java/lang/Exception
    //   384	396	274	java/lang/Exception
    //   410	416	274	java/lang/Exception
    //   426	430	274	java/lang/Exception
    //   430	435	451	java/lang/Exception
    //   435	439	464	java/lang/Exception
    //   439	443	476	java/lang/Exception
    //   488	493	509	java/lang/Exception
    //   493	497	522	java/lang/Exception
    //   497	501	534	java/lang/Exception
    //   345	350	546	java/lang/Exception
    //   354	358	559	java/lang/Exception
    //   362	366	571	java/lang/Exception
    //   45	85	583	finally
    //   93	103	583	finally
    //   596	601	625	java/lang/Exception
    //   605	609	638	java/lang/Exception
    //   613	617	650	java/lang/Exception
    //   103	113	662	finally
    //   113	122	670	finally
    //   132	140	676	finally
    //   150	156	676	finally
    //   176	184	676	finally
    //   194	203	676	finally
    //   218	225	676	finally
    //   242	252	676	finally
    //   262	271	676	finally
    //   285	310	676	finally
    //   320	326	676	finally
    //   336	340	676	finally
    //   384	396	676	finally
    //   410	416	676	finally
    //   426	430	676	finally
    //   45	85	690	java/lang/Exception
    //   93	103	690	java/lang/Exception
    //   103	113	701	java/lang/Exception
    //   113	122	709	java/lang/Exception
  }
  
  static SharedPreferences getSpForEmbedInstall(String paramString)
  {
    AppMethodBeat.i(207402);
    paramString = XWalkEnvironment.getMMKVSharedPreferences("XWEB_EMBED_INSTALL_".concat(String.valueOf(paramString)));
    AppMethodBeat.o(207402);
    return paramString;
  }
  
  /* Error */
  private static boolean isProviderExist(ContentResolver paramContentResolver, String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: ldc_w 589
    //   5: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: ifnull +14 -> 23
    //   12: aload_1
    //   13: ifnull +10 -> 23
    //   16: aload_1
    //   17: invokevirtual 222	java/lang/String:isEmpty	()Z
    //   20: ifeq +11 -> 31
    //   23: ldc_w 589
    //   26: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: iconst_0
    //   30: ireturn
    //   31: aload_0
    //   32: aload_1
    //   33: invokestatic 592	org/xwalk/core/XWalkEnvironment:getPackageName	()Ljava/lang/String;
    //   36: iconst_1
    //   37: iconst_0
    //   38: ldc_w 594
    //   41: invokestatic 600	com/tencent/xweb/XWebCoreContentProvider:d	(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)Landroid/net/Uri;
    //   44: ldc_w 594
    //   47: invokevirtual 606	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   50: astore_0
    //   51: aload_0
    //   52: invokestatic 612	com/tencent/xweb/util/c:a	(Landroid/content/res/AssetFileDescriptor;)V
    //   55: ldc_w 589
    //   58: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: iload_2
    //   62: ireturn
    //   63: astore_0
    //   64: aconst_null
    //   65: invokestatic 612	com/tencent/xweb/util/c:a	(Landroid/content/res/AssetFileDescriptor;)V
    //   68: iconst_0
    //   69: istore_2
    //   70: goto -15 -> 55
    //   73: astore_0
    //   74: aconst_null
    //   75: invokestatic 612	com/tencent/xweb/util/c:a	(Landroid/content/res/AssetFileDescriptor;)V
    //   78: ldc_w 589
    //   81: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
      h.OQ(37L);
      AppMethodBeat.o(155034);
      return false;
    }
    paramString = XWalkUpdater.PatchFileConfigParser.getPatchFileConfigList(paramInt2);
    if (paramString == null)
    {
      Log.e("XWalkLib", "onDoPatch patchFileConfigList = null");
      h.OQ(38L);
      AppMethodBeat.o(155034);
      return false;
    }
    if (!com.tencent.xweb.util.c.og(XWalkEnvironment.getExtractedCoreDir(paramInt1), XWalkEnvironment.getExtractedCoreDir(paramInt2)))
    {
      Log.e("XWalkLib", "onDoPatch copy all extraced file error");
      h.OQ(39L);
      AppMethodBeat.o(155034);
      return false;
    }
    Log.i("XWalkLib", "onDoPatch copy all extraced file finished");
    Object localObject1 = new ArrayList();
    Object localObject2 = paramString.iterator();
    XWalkUpdater.PatchFileConfig localPatchFileConfig;
    while (((Iterator)localObject2).hasNext())
    {
      localPatchFileConfig = (XWalkUpdater.PatchFileConfig)((Iterator)localObject2).next();
      if (localPatchFileConfig.isTypeAdd()) {
        ((ArrayList)localObject1).add(localPatchFileConfig);
      }
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (XWalkUpdater.PatchFileConfig)((Iterator)localObject1).next();
      if (!com.tencent.xweb.util.c.copyFile(XWalkEnvironment.getPatchZipTempDecompressFilePath(paramInt2, ((XWalkUpdater.PatchFileConfig)localObject2).originalFileName), XWalkEnvironment.getExtractedCoreFile(paramInt2, ((XWalkUpdater.PatchFileConfig)localObject2).originalFileName)))
      {
        Log.e("XWalkLib", "onDoPatch add file error:".concat(String.valueOf(localObject2)));
        h.OQ(40L);
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
      localPatchFileConfig = (XWalkUpdater.PatchFileConfig)((Iterator)localObject2).next();
      if (localPatchFileConfig.isTypeRemove()) {
        ((ArrayList)localObject1).add(localPatchFileConfig);
      }
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (XWalkUpdater.PatchFileConfig)((Iterator)localObject1).next();
      if (!com.tencent.xweb.util.c.deleteFile(XWalkEnvironment.getExtractedCoreFile(paramInt2, ((XWalkUpdater.PatchFileConfig)localObject2).originalFileName)))
      {
        Log.e("XWalkLib", "onDoPatch delete file error:".concat(String.valueOf(localObject2)));
        h.OQ(41L);
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
      localObject2 = (XWalkUpdater.PatchFileConfig)paramString.next();
      if (((XWalkUpdater.PatchFileConfig)localObject2).isTypeModify()) {
        ((ArrayList)localObject1).add(localObject2);
      }
    }
    paramString = ((ArrayList)localObject1).iterator();
    while (paramString.hasNext())
    {
      localObject2 = (XWalkUpdater.PatchFileConfig)paramString.next();
      if (((XWalkUpdater.PatchFileConfig)localObject2).isExtractedFile())
      {
        if (BSpatch.bv(XWalkEnvironment.getExtractedCoreFile(paramInt2, ((XWalkUpdater.PatchFileConfig)localObject2).originalFileName), XWalkEnvironment.getPatchZipTempDecompressFilePath(paramInt2, ((XWalkUpdater.PatchFileConfig)localObject2).patchFileName), XWalkEnvironment.getExtractedCoreFile(paramInt2, ((XWalkUpdater.PatchFileConfig)localObject2).originalFileName)) < 0)
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
      localObject1 = (XWalkUpdater.PatchFileConfig)paramString.next();
      if (((XWalkUpdater.PatchFileConfig)localObject1).isOriginalFileTypeApk()) {
        if (BSpatch.bv(XWalkEnvironment.getDownloadApkPath(paramInt1), XWalkEnvironment.getPatchZipTempDecompressFilePath(paramInt2, ((XWalkUpdater.PatchFileConfig)localObject1).patchFileName), XWalkEnvironment.getDownloadApkPath(paramInt2)) < 0)
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
    if ((paramUpdateConfig.isMatchMd5) && (!d.oi(str, paramUpdateConfig.downloadFileMd5)))
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
      if ((paramUpdateConfig.isMatchMd5) && (!XWalkUpdater.FileListMD5Checker.checkFileListMd5(paramUpdateConfig.apkVer, XWalkEnvironment.getPatchFileListConfig(paramUpdateConfig.apkVer))))
      {
        XWalkInitializer.addXWalkInitializeLog("XWalkLib", "patch update mode, but md5 not match");
        h.OQ(36L);
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
        h.OQ(32L);
        AppMethodBeat.o(155030);
        return Integer.valueOf(-5);
      }
    } while ((!paramUpdateConfig.isMatchMd5) || (XWalkUpdater.FileListMD5Checker.checkFileListMd5(paramUpdateConfig.apkVer, XWalkEnvironment.getDownloadZipFileListConfig(paramUpdateConfig.apkVer))));
    XWalkInitializer.addXWalkInitializeLog("XWalkLib", "patch update mode, but md5 not match");
    h.OQ(33L);
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
      } while (d.oi(paramMap.getAbsolutePath(), str2));
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
    //   0: ldc_w 826
    //   3: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 828	java/util/HashMap
    //   9: dup
    //   10: invokespecial 829	java/util/HashMap:<init>	()V
    //   13: astore_3
    //   14: aload_0
    //   15: aload_1
    //   16: invokestatic 592	org/xwalk/core/XWalkEnvironment:getPackageName	()Ljava/lang/String;
    //   19: iconst_2
    //   20: iload_2
    //   21: ldc_w 831
    //   24: invokestatic 600	com/tencent/xweb/XWebCoreContentProvider:d	(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)Landroid/net/Uri;
    //   27: ldc_w 594
    //   30: invokevirtual 606	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   33: astore_1
    //   34: aload_1
    //   35: ifnonnull +29 -> 64
    //   38: ldc_w 833
    //   41: invokestatic 807	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   44: aconst_null
    //   45: invokestatic 837	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   48: aconst_null
    //   49: invokestatic 837	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   52: aload_1
    //   53: invokestatic 612	com/tencent/xweb/util/c:a	(Landroid/content/res/AssetFileDescriptor;)V
    //   56: ldc_w 826
    //   59: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: aload_3
    //   63: areturn
    //   64: new 141	java/io/File
    //   67: dup
    //   68: iload_2
    //   69: ldc_w 831
    //   72: invokestatic 676	org/xwalk/core/XWalkEnvironment:getExtractedCoreFile	(ILjava/lang/String;)Ljava/lang/String;
    //   75: invokespecial 144	java/io/File:<init>	(Ljava/lang/String;)V
    //   78: astore_0
    //   79: aload_0
    //   80: invokevirtual 148	java/io/File:exists	()Z
    //   83: ifeq +8 -> 91
    //   86: aload_0
    //   87: invokevirtual 255	java/io/File:delete	()Z
    //   90: pop
    //   91: new 839	java/io/PrintWriter
    //   94: dup
    //   95: aload_0
    //   96: invokespecial 840	java/io/PrintWriter:<init>	(Ljava/io/File;)V
    //   99: astore 4
    //   101: new 212	java/io/BufferedReader
    //   104: dup
    //   105: new 207	java/io/InputStreamReader
    //   108: dup
    //   109: aload_1
    //   110: invokevirtual 846	android/content/res/AssetFileDescriptor:createInputStream	()Ljava/io/FileInputStream;
    //   113: invokespecial 210	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   116: invokespecial 215	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   119: astore_0
    //   120: aload 4
    //   122: astore 7
    //   124: aload_0
    //   125: astore 6
    //   127: aload_1
    //   128: astore 5
    //   130: aload_0
    //   131: invokevirtual 219	java/io/BufferedReader:readLine	()Ljava/lang/String;
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
    //   155: invokevirtual 849	java/io/PrintWriter:println	(Ljava/lang/String;)V
    //   158: aload 4
    //   160: astore 7
    //   162: aload_0
    //   163: astore 6
    //   165: aload_1
    //   166: astore 5
    //   168: aload 8
    //   170: invokevirtual 222	java/lang/String:isEmpty	()Z
    //   173: ifne -53 -> 120
    //   176: aload 4
    //   178: astore 7
    //   180: aload_0
    //   181: astore 6
    //   183: aload_1
    //   184: astore 5
    //   186: aload 8
    //   188: ldc 224
    //   190: invokevirtual 228	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
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
    //   233: invokevirtual 222	java/lang/String:isEmpty	()Z
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
    //   260: invokevirtual 222	java/lang/String:isEmpty	()Z
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
    //   285: invokeinterface 853 3 0
    //   290: pop
    //   291: goto -171 -> 120
    //   294: astore_3
    //   295: aload 4
    //   297: astore 7
    //   299: aload_0
    //   300: astore 6
    //   302: aload_1
    //   303: astore 5
    //   305: new 238	java/lang/StringBuilder
    //   308: dup
    //   309: ldc_w 855
    //   312: invokespecial 241	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   315: aload_3
    //   316: invokevirtual 276	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   319: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: invokestatic 807	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   328: aload 4
    //   330: invokestatic 837	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   333: aload_0
    //   334: invokestatic 837	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   337: aload_1
    //   338: invokestatic 612	com/tencent/xweb/util/c:a	(Landroid/content/res/AssetFileDescriptor;)V
    //   341: ldc_w 826
    //   344: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   347: aconst_null
    //   348: areturn
    //   349: aload 4
    //   351: astore 7
    //   353: aload_0
    //   354: astore 6
    //   356: aload_1
    //   357: astore 5
    //   359: aload 4
    //   361: invokevirtual 858	java/io/PrintWriter:flush	()V
    //   364: aload 4
    //   366: invokestatic 837	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   369: aload_0
    //   370: invokestatic 837	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   373: aload_1
    //   374: invokestatic 612	com/tencent/xweb/util/c:a	(Landroid/content/res/AssetFileDescriptor;)V
    //   377: ldc_w 826
    //   380: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   394: invokestatic 837	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   397: aload 4
    //   399: invokestatic 837	com/tencent/xweb/util/c:tryClose	(Ljava/io/Closeable;)V
    //   402: aload_1
    //   403: invokestatic 612	com/tencent/xweb/util/c:a	(Landroid/content/res/AssetFileDescriptor;)V
    //   406: ldc_w 826
    //   409: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(207405);
    if ((Build.VERSION.SDK_INT < 29) || ("true".equalsIgnoreCase(a.nS("NOT_USE_JAR_REPLACE_DEX", "tools"))))
    {
      AppMethodBeat.o(207405);
      return;
    }
    generate_jar_for_dex_in_dir(paramString, paramBoolean);
    AppMethodBeat.o(207405);
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
    com.tencent.xweb.xwalk.updater.c localc;
    ErrorInfo localErrorInfo;
    ContentResolver localContentResolver;
    UpdateConfig localUpdateConfig;
    int j;
    String str;
    ArrayList localArrayList;
    int k;
    int m;
    try
    {
      AppMethodBeat.i(207400);
      localc = paramXWebCoreScheduler.hvJ();
      XWalkInitializer.addXWalkInitializeLog("updateFromProvider target ver " + localc.version);
      localErrorInfo = new ErrorInfo();
      localErrorInfo.targetVer = localc.version;
      if (!localc.bTryUseSharedCore)
      {
        XWalkInitializer.addXWalkInitializeLog("updateFromProvider force download");
        localErrorInfo.errorCode = -6;
        AppMethodBeat.o(207400);
      }
      for (;;)
      {
        return localErrorInfo;
        if (localc.SJi >= 2)
        {
          XWalkInitializer.addXWalkInitializeLog("updateFromProvider exceed max count");
          localErrorInfo.errorCode = -7;
          AppMethodBeat.o(207400);
        }
        else
        {
          localContentResolver = XWalkEnvironment.getContentResolver();
          if (localContentResolver != null) {
            break;
          }
          XWalkInitializer.addXWalkInitializeLog("updateFromProvider content resolver null");
          localErrorInfo.errorCode = -8;
          AppMethodBeat.o(207400);
        }
      }
      localUpdateConfig = paramXWebCoreScheduler.f(localc);
      i = 0;
      String[] arrayOfString = XWalkEnvironment.XWALK_CORE_PROVIDER_LIST;
      int n = arrayOfString.length;
      j = 0;
      if (j >= n) {
        break label669;
      }
      str = arrayOfString[j];
      if (!isProviderExist(localContentResolver, str)) {
        break label766;
      }
      XWalkInitializer.addXWalkInitializeLog("updateFromProvider find ".concat(String.valueOf(str)));
      paramXWebCoreScheduler = a.nS("SHARE_CORE_LIST", "tools");
      Log.i("XWalkLib", "dump SHARE_CORE_LIST: ".concat(String.valueOf(paramXWebCoreScheduler)));
      localArrayList = new ArrayList();
      localArrayList.add(Integer.valueOf(localUpdateConfig.apkVer));
      if ((!TextUtils.isEmpty(paramXWebCoreScheduler)) && (!XWalkEnvironment.hasInstalledAvailableVersion()))
      {
        paramXWebCoreScheduler = paramXWebCoreScheduler.split(";");
        if (paramXWebCoreScheduler != null)
        {
          k = paramXWebCoreScheduler.length;
          i = 0;
          for (;;)
          {
            if (i < k)
            {
              CharSequence localCharSequence = paramXWebCoreScheduler[i];
              if (!TextUtils.isEmpty(localCharSequence))
              {
                boolean bool = TextUtils.isEmpty(localCharSequence.trim());
                if (bool) {}
              }
              try
              {
                m = Integer.parseInt(localCharSequence);
                if (localUpdateConfig.apkVer != m) {
                  localArrayList.add(Integer.valueOf(m));
                }
                i += 1;
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  Log.e("XWalkLib", "parse SHARE_CORE_LIST failed " + localException.getMessage());
                }
              }
            }
          }
        }
      }
      paramXWebCoreScheduler = null;
    }
    finally {}
    int i = 0;
    label397:
    XWebCoreScheduler localXWebCoreScheduler;
    if (i < localArrayList.size())
    {
      m = ((Integer)localArrayList.get(i)).intValue();
      paramXWebCoreScheduler = tryGetFileList(localContentResolver, str, m);
      if (paramXWebCoreScheduler == null)
      {
        XWalkInitializer.addXWalkInitializeLog("updateFromProvider read fileList failed ver = ".concat(String.valueOf(m)));
        localErrorInfo.readFileListFailedCount += 1;
      }
      else
      {
        k = m;
        localXWebCoreScheduler = paramXWebCoreScheduler;
        if (paramXWebCoreScheduler.size() == 0) {
          XWalkInitializer.addXWalkInitializeLog("updateFromProvider no matched version ver = ".concat(String.valueOf(m)));
        }
      }
    }
    for (;;)
    {
      if (k < 0)
      {
        localErrorInfo.noMatchedVersionCount += 1;
        i = 1;
        break label766;
      }
      XWalkInitializer.addXWalkInitializeLog("find share available ver = ".concat(String.valueOf(k)));
      if (!tryCopyVersion(localContentResolver, str, k, localXWebCoreScheduler, localErrorInfo)) {
        break label773;
      }
      i = extractResource(k, localUpdateConfig.abi, k + "_install_from_share_mode").intValue();
      if (i == 0)
      {
        localErrorInfo.errorCode = 0;
        AppMethodBeat.o(207400);
        break;
      }
      if (i == -5)
      {
        localErrorInfo.extractFailedCount += 1;
        i = 1;
        break label766;
      }
      if (i == -12)
      {
        localErrorInfo.extractRetryFailedCount += 1;
        i = 1;
        break label766;
      }
      if (i != -101) {
        break label773;
      }
      localErrorInfo.setVersionFailedCount += 1;
      break label773;
      label669:
      if (i == 0)
      {
        XWalkInitializer.addXWalkInitializeLog("updateFromProvider no provider");
        localErrorInfo.errorCode = -9;
        AppMethodBeat.o(207400);
        break;
      }
      if ((XWalkEnvironment.hasAvailableVersion()) && (localc.SJi + 1 < 2)) {
        XWalkInitializer.addXWalkInitializeLog("updateFromProvider failed, can try again");
      }
      for (localErrorInfo.errorCode = -10;; localErrorInfo.errorCode = -11)
      {
        AppMethodBeat.o(207400);
        break;
        XWalkInitializer.addXWalkInitializeLog("updateFromProvider failed, do not try again");
      }
      i += 1;
      break label397;
      k = -1;
      localXWebCoreScheduler = paramXWebCoreScheduler;
    }
    for (;;)
    {
      label766:
      j += 1;
      break;
      label773:
      i = 1;
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
        h.huo();
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
        h.dz(15124, i + "," + k + "," + m + ",201201," + paramDownloadInfo.mErrorCode + "," + paramDownloadInfo.mNetWorkType + "," + paramDownloadInfo.mRetryTimes + "," + (l1 - l2) + "," + paramDownloadInfo.mFileTotalSize + "," + paramDownloadInfo.mDownloadType + "," + j);
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
        h.OW(System.currentTimeMillis() - paramDownloadInfo.mStartTimestamp);
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
        h.OU(System.currentTimeMillis() - paramDownloadInfo.mStartTimestamp);
      }
    }
    
    public void onDownloadFailed(XWalkLibraryLoader.DownloadInfo paramDownloadInfo)
    {
      AppMethodBeat.i(155007);
      XWalkInitializer.addXWalkInitializeLog("XWalkLib", "download apk failed");
      if (this.mConfig.isPatchUpdate) {
        h.hus();
      }
      for (;;)
      {
        reportKV(paramDownloadInfo);
        if ((this.mConfig != null) && (this.mConfig.scheduler != null)) {
          this.mConfig.scheduler.atj(-1);
        }
        XWalkUpdater.this.mBackgroundUpdateListener.onXWalkUpdateFailed(-1, this.mConfig.scheduler);
        AppMethodBeat.o(155007);
        return;
        h.hun();
      }
    }
    
    public void onDownloadStarted(int paramInt)
    {
      AppMethodBeat.i(155004);
      Log.d("XWalkLib", "DownloadTask started, type:" + paramInt + " config:" + this.mConfig.getLogSelf());
      if (this.mConfig.isPatchUpdate) {
        h.hur();
      }
      for (;;)
      {
        XWalkUpdater.this.mBackgroundUpdateListener.onXWalkUpdateStarted();
        AppMethodBeat.o(155004);
        return;
        h.hum();
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
    
    private UpdateConfig(int paramInt, String paramString1, String paramString2)
    {
      this.apkVer = -1;
      this.apkVer = paramInt;
      this.abi = paramString1;
      this.versionDetail = paramString2;
    }
    
    public UpdateConfig(String paramString1, boolean paramBoolean, int paramInt1, String paramString2, int paramInt2)
    {
      AppMethodBeat.i(207398);
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
        AppMethodBeat.o(207398);
        throw paramString1;
      }
      AppMethodBeat.o(207398);
    }
    
    public UpdateConfig(String paramString1, boolean paramBoolean, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2)
    {
      AppMethodBeat.i(207399);
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
        AppMethodBeat.o(207399);
        throw paramString1;
      }
      AppMethodBeat.o(207399);
    }
    
    public static UpdateConfig createTempConfig(int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(207397);
      paramString1 = new UpdateConfig(paramInt, paramString1, paramString2);
      AppMethodBeat.o(207397);
      return paramString1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     org.xwalk.core.XWalkUpdater
 * JD-Core Version:    0.7.0.1
 */