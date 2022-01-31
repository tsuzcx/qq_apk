package org.xwalk.core;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.content.res.AssetFileDescriptor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.XWebCoreContentProvider;
import com.tencent.xweb.a;
import com.tencent.xweb.util.BSpatch;
import com.tencent.xweb.util.b;
import com.tencent.xweb.util.d;
import com.tencent.xweb.util.f;
import com.tencent.xweb.xwalk.b.c.a;
import dalvik.system.DexClassLoader;
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
  private static final int RES_EXTRACTOR_MAXTIMES = 1;
  private static final String TAG = "XWalkLib";
  public static final int UPDATE_BIZ_TYPE_RUNTIME_PACKAGE = 1;
  public static final int UPDATE_BIZ_TYPE_RUNTIME_PATCH = 2;
  private static int mCurrentTimeForRetryRes = 0;
  private XWalkUpdater.XWalkBackgroundUpdateListener mBackgroundUpdateListener;
  private Runnable mCancelCommand;
  private Context mContext;
  private XWalkDialogManager mDialogManager;
  private Runnable mDownloadCommand;
  private XWalkUpdater.XWalkUpdateListener mUpdateListener;
  
  public XWalkUpdater(XWalkUpdater.XWalkBackgroundUpdateListener paramXWalkBackgroundUpdateListener, Context paramContext)
  {
    this.mBackgroundUpdateListener = paramXWalkBackgroundUpdateListener;
    this.mContext = paramContext;
  }
  
  public XWalkUpdater(XWalkUpdater.XWalkUpdateListener paramXWalkUpdateListener, Context paramContext)
  {
    AppMethodBeat.i(85916);
    this.mUpdateListener = paramXWalkUpdateListener;
    this.mContext = paramContext;
    this.mDialogManager = new XWalkDialogManager(paramContext);
    AppMethodBeat.o(85916);
  }
  
  public XWalkUpdater(XWalkUpdater.XWalkUpdateListener paramXWalkUpdateListener, Context paramContext, XWalkDialogManager paramXWalkDialogManager)
  {
    this.mUpdateListener = paramXWalkUpdateListener;
    this.mContext = paramContext;
    this.mDialogManager = paramXWalkDialogManager;
  }
  
  /* Error */
  public static boolean checkExtractResFileLengtgAndMd5(String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: ldc 119
    //   2: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 121	java/io/File
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 124	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_3
    //   14: aload_3
    //   15: invokevirtual 128	java/io/File:exists	()Z
    //   18: ifne +106 -> 124
    //   21: iload_2
    //   22: invokestatic 134	org/xwalk/core/XWalkEnvironment:isTestVersion	(I)Z
    //   25: ifne +737 -> 762
    //   28: iload_2
    //   29: sipush 362
    //   32: if_icmpge +31 -> 63
    //   35: goto +727 -> 762
    //   38: iload_2
    //   39: ifeq +29 -> 68
    //   42: ldc 63
    //   44: ldc 136
    //   46: aload_0
    //   47: invokestatic 142	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   50: invokevirtual 146	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   53: invokestatic 152	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: ldc 119
    //   58: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: iconst_1
    //   62: ireturn
    //   63: iconst_0
    //   64: istore_2
    //   65: goto -27 -> 38
    //   68: ldc2_w 153
    //   71: invokestatic 160	com/tencent/xweb/util/f:pf	(J)V
    //   74: ldc 63
    //   76: ldc 162
    //   78: aload_0
    //   79: invokestatic 142	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   82: invokevirtual 146	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   85: invokestatic 152	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: ldc 164
    //   90: ldc 166
    //   92: ldc 168
    //   94: invokestatic 174	com/tencent/xweb/a:iW	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   97: invokevirtual 178	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   100: ifeq +17 -> 117
    //   103: ldc 63
    //   105: ldc 180
    //   107: invokestatic 152	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: ldc 119
    //   112: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: iconst_1
    //   116: ireturn
    //   117: ldc 119
    //   119: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: iconst_0
    //   123: ireturn
    //   124: new 182	java/io/FileInputStream
    //   127: dup
    //   128: aload_3
    //   129: invokespecial 185	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   132: astore 4
    //   134: new 187	java/io/InputStreamReader
    //   137: dup
    //   138: aload 4
    //   140: invokespecial 190	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   143: astore_3
    //   144: new 192	java/io/BufferedReader
    //   147: dup
    //   148: aload_3
    //   149: invokespecial 195	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   152: astore_0
    //   153: aload_0
    //   154: astore 7
    //   156: aload_3
    //   157: astore 6
    //   159: aload 4
    //   161: astore 5
    //   163: aload_0
    //   164: invokevirtual 199	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   167: astore 8
    //   169: aload 8
    //   171: ifnull +309 -> 480
    //   174: aload 8
    //   176: ifnull -23 -> 153
    //   179: aload_0
    //   180: astore 7
    //   182: aload_3
    //   183: astore 6
    //   185: aload 4
    //   187: astore 5
    //   189: aload 8
    //   191: invokevirtual 202	java/lang/String:isEmpty	()Z
    //   194: ifne -41 -> 153
    //   197: aload_0
    //   198: astore 7
    //   200: aload_3
    //   201: astore 6
    //   203: aload 4
    //   205: astore 5
    //   207: aload 8
    //   209: ldc 204
    //   211: invokevirtual 208	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
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
    //   259: invokevirtual 202	java/lang/String:isEmpty	()Z
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
    //   286: invokevirtual 202	java/lang/String:isEmpty	()Z
    //   289: ifne -136 -> 153
    //   292: aload_0
    //   293: astore 7
    //   295: aload_3
    //   296: astore 6
    //   298: aload 4
    //   300: astore 5
    //   302: new 121	java/io/File
    //   305: dup
    //   306: aload_1
    //   307: aload 8
    //   309: iconst_0
    //   310: aaload
    //   311: invokespecial 210	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   314: astore 9
    //   316: aload_0
    //   317: astore 7
    //   319: aload_3
    //   320: astore 6
    //   322: aload 4
    //   324: astore 5
    //   326: aload 9
    //   328: invokestatic 216	com/tencent/xweb/util/d:r	(Ljava/io/File;)Ljava/lang/String;
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
    //   349: invokevirtual 178	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   352: ifne -199 -> 153
    //   355: aload_0
    //   356: astore 7
    //   358: aload_3
    //   359: astore 6
    //   361: aload 4
    //   363: astore 5
    //   365: ldc 63
    //   367: new 218	java/lang/StringBuilder
    //   370: dup
    //   371: ldc 220
    //   373: invokespecial 221	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   376: aload 8
    //   378: iconst_0
    //   379: aaload
    //   380: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: ldc 227
    //   385: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: aload 8
    //   390: iconst_1
    //   391: aaload
    //   392: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: ldc 229
    //   397: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: aload 10
    //   402: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   408: invokestatic 152	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   411: aload_0
    //   412: astore 7
    //   414: aload_3
    //   415: astore 6
    //   417: aload 4
    //   419: astore 5
    //   421: aload 9
    //   423: invokevirtual 235	java/io/File:delete	()Z
    //   426: pop
    //   427: aload 4
    //   429: invokevirtual 238	java/io/FileInputStream:close	()V
    //   432: aload_3
    //   433: invokevirtual 239	java/io/InputStreamReader:close	()V
    //   436: aload_0
    //   437: invokevirtual 240	java/io/BufferedReader:close	()V
    //   440: ldc 119
    //   442: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   445: iconst_0
    //   446: ireturn
    //   447: astore_1
    //   448: ldc 63
    //   450: ldc 242
    //   452: invokestatic 247	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   455: goto -23 -> 432
    //   458: astore_1
    //   459: ldc 63
    //   461: ldc 249
    //   463: invokestatic 247	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   466: goto -30 -> 436
    //   469: astore_0
    //   470: ldc 63
    //   472: ldc 251
    //   474: invokestatic 247	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   477: goto -37 -> 440
    //   480: aload 4
    //   482: invokevirtual 238	java/io/FileInputStream:close	()V
    //   485: aload_3
    //   486: invokevirtual 239	java/io/InputStreamReader:close	()V
    //   489: aload_0
    //   490: invokevirtual 240	java/io/BufferedReader:close	()V
    //   493: ldc 119
    //   495: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   498: iconst_1
    //   499: ireturn
    //   500: astore_1
    //   501: ldc 63
    //   503: ldc 242
    //   505: invokestatic 247	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   508: goto -23 -> 485
    //   511: astore_1
    //   512: ldc 63
    //   514: ldc 249
    //   516: invokestatic 247	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   519: goto -30 -> 489
    //   522: astore_0
    //   523: ldc 63
    //   525: ldc 251
    //   527: invokestatic 247	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   530: goto -37 -> 493
    //   533: astore_1
    //   534: aconst_null
    //   535: astore_0
    //   536: aconst_null
    //   537: astore_3
    //   538: aconst_null
    //   539: astore 4
    //   541: aload_0
    //   542: astore 7
    //   544: aload_3
    //   545: astore 6
    //   547: aload 4
    //   549: astore 5
    //   551: ldc 63
    //   553: new 218	java/lang/StringBuilder
    //   556: dup
    //   557: ldc 253
    //   559: invokespecial 221	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   562: aload_1
    //   563: invokevirtual 256	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   566: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   572: invokestatic 247	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   575: aload 4
    //   577: ifnull +8 -> 585
    //   580: aload 4
    //   582: invokevirtual 238	java/io/FileInputStream:close	()V
    //   585: aload_3
    //   586: ifnull +7 -> 593
    //   589: aload_3
    //   590: invokevirtual 239	java/io/InputStreamReader:close	()V
    //   593: aload_0
    //   594: ifnull +7 -> 601
    //   597: aload_0
    //   598: invokevirtual 240	java/io/BufferedReader:close	()V
    //   601: ldc 119
    //   603: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   606: iconst_0
    //   607: ireturn
    //   608: astore_1
    //   609: ldc 63
    //   611: ldc 242
    //   613: invokestatic 247	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   616: goto -31 -> 585
    //   619: astore_1
    //   620: ldc 63
    //   622: ldc 249
    //   624: invokestatic 247	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   627: goto -34 -> 593
    //   630: astore_0
    //   631: ldc 63
    //   633: ldc 251
    //   635: invokestatic 247	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   638: goto -37 -> 601
    //   641: astore_0
    //   642: aconst_null
    //   643: astore_1
    //   644: aconst_null
    //   645: astore_3
    //   646: aconst_null
    //   647: astore 4
    //   649: aload 4
    //   651: ifnull +8 -> 659
    //   654: aload 4
    //   656: invokevirtual 238	java/io/FileInputStream:close	()V
    //   659: aload_3
    //   660: ifnull +7 -> 667
    //   663: aload_3
    //   664: invokevirtual 239	java/io/InputStreamReader:close	()V
    //   667: aload_1
    //   668: ifnull +7 -> 675
    //   671: aload_1
    //   672: invokevirtual 240	java/io/BufferedReader:close	()V
    //   675: ldc 119
    //   677: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   680: aload_0
    //   681: athrow
    //   682: astore 4
    //   684: ldc 63
    //   686: ldc 242
    //   688: invokestatic 247	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   691: goto -32 -> 659
    //   694: astore_3
    //   695: ldc 63
    //   697: ldc 249
    //   699: invokestatic 247	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   702: goto -35 -> 667
    //   705: astore_1
    //   706: ldc 63
    //   708: ldc 251
    //   710: invokestatic 247	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   713: goto -38 -> 675
    //   716: astore_0
    //   717: aconst_null
    //   718: astore_1
    //   719: aconst_null
    //   720: astore_3
    //   721: goto -72 -> 649
    //   724: astore_0
    //   725: aconst_null
    //   726: astore_1
    //   727: goto -78 -> 649
    //   730: astore_0
    //   731: aload 7
    //   733: astore_1
    //   734: aload 6
    //   736: astore_3
    //   737: aload 5
    //   739: astore 4
    //   741: goto -92 -> 649
    //   744: astore_1
    //   745: aconst_null
    //   746: astore_0
    //   747: aconst_null
    //   748: astore_3
    //   749: goto -208 -> 541
    //   752: astore_1
    //   753: aconst_null
    //   754: astore_0
    //   755: goto -214 -> 541
    //   758: astore_1
    //   759: goto -218 -> 541
    //   762: iconst_1
    //   763: istore_2
    //   764: goto -726 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	767	0	paramString1	String
    //   0	767	1	paramString2	String
    //   0	767	2	paramInt	int
    //   13	651	3	localObject1	Object
    //   694	1	3	localException1	Exception
    //   720	29	3	localObject2	Object
    //   132	523	4	localFileInputStream1	java.io.FileInputStream
    //   682	1	4	localException2	Exception
    //   739	1	4	localObject3	Object
    //   161	577	5	localFileInputStream2	java.io.FileInputStream
    //   157	578	6	localObject4	Object
    //   154	578	7	str1	String
    //   167	222	8	localObject5	Object
    //   314	108	9	localFile	File
    //   331	70	10	str2	String
    // Exception table:
    //   from	to	target	type
    //   427	432	447	java/lang/Exception
    //   432	436	458	java/lang/Exception
    //   436	440	469	java/lang/Exception
    //   480	485	500	java/lang/Exception
    //   485	489	511	java/lang/Exception
    //   489	493	522	java/lang/Exception
    //   5	28	533	java/lang/Exception
    //   42	56	533	java/lang/Exception
    //   68	110	533	java/lang/Exception
    //   124	134	533	java/lang/Exception
    //   580	585	608	java/lang/Exception
    //   589	593	619	java/lang/Exception
    //   597	601	630	java/lang/Exception
    //   5	28	641	finally
    //   42	56	641	finally
    //   68	110	641	finally
    //   124	134	641	finally
    //   654	659	682	java/lang/Exception
    //   663	667	694	java/lang/Exception
    //   671	675	705	java/lang/Exception
    //   134	144	716	finally
    //   144	153	724	finally
    //   163	169	730	finally
    //   189	197	730	finally
    //   207	216	730	finally
    //   231	238	730	finally
    //   255	265	730	finally
    //   282	292	730	finally
    //   302	316	730	finally
    //   326	333	730	finally
    //   343	355	730	finally
    //   365	411	730	finally
    //   421	427	730	finally
    //   551	575	730	finally
    //   134	144	744	java/lang/Exception
    //   144	153	752	java/lang/Exception
    //   163	169	758	java/lang/Exception
    //   189	197	758	java/lang/Exception
    //   207	216	758	java/lang/Exception
    //   231	238	758	java/lang/Exception
    //   255	265	758	java/lang/Exception
    //   282	292	758	java/lang/Exception
    //   302	316	758	java/lang/Exception
    //   326	333	758	java/lang/Exception
    //   343	355	758	java/lang/Exception
    //   365	411	758	java/lang/Exception
    //   421	427	758	java/lang/Exception
  }
  
  private static Integer extractResource(UpdateConfig paramUpdateConfig)
  {
    AppMethodBeat.i(85927);
    for (;;)
    {
      String str = XWalkEnvironment.getExtractedCoreDir(paramUpdateConfig.apkVer);
      if (!XWalkDecompressor.extractResource(XWalkEnvironment.getDownloadApkPath(paramUpdateConfig.apkVer), str))
      {
        XWalkInitializer.addXWalkInitializeLog("XWalkLib", "extract faield");
        AppMethodBeat.o(85927);
        return Integer.valueOf(-5);
      }
      if (checkExtractResFileLengtgAndMd5(XWalkEnvironment.getDownloadResFileListConfig(paramUpdateConfig.apkVer), str, paramUpdateConfig.apkVer) == true)
      {
        XWalkInitializer.addXWalkInitializeLog("XWalkLib", "checkExtractResFileLengtgAndMd5 success!!!!");
        if (generateOptDex(paramUpdateConfig.apkVer)) {
          break label180;
        }
        f.pf(251L);
        if (!"true".equalsIgnoreCase(a.iW("update_need_check_dex", "tools"))) {
          break label180;
        }
        AppMethodBeat.o(85927);
        return Integer.valueOf(-101);
      }
      if (mCurrentTimeForRetryRes > 0) {
        break;
      }
      XWalkInitializer.addXWalkInitializeLog("XWalkLib", "checkExtractResFileLengtgAndMd5 failed retry extractResource");
      mCurrentTimeForRetryRes += 1;
    }
    XWalkInitializer.addXWalkInitializeLog("XWalkLib", "checkResourceLengthAndMd5 failed can not retry!!!!!!!!!! mCurrentTimeForRetryRes = " + mCurrentTimeForRetryRes);
    AppMethodBeat.o(85927);
    return Integer.valueOf(-12);
    label180:
    boolean bool = XWalkEnvironment.setAvailableVersion(paramUpdateConfig.apkVer, paramUpdateConfig.versionDetail);
    XWalkInitializer.addXWalkInitializeLog("XWalkLib", "do update sucsess");
    if (!bool)
    {
      XWalkInitializer.addXWalkInitializeLog("XWalkLib", "set version failed");
      AppMethodBeat.o(85927);
      return Integer.valueOf(-101);
    }
    AppMethodBeat.o(85927);
    return Integer.valueOf(0);
  }
  
  private static boolean generateOptDex(int paramInt)
  {
    AppMethodBeat.i(85928);
    try
    {
      String str = XWalkEnvironment.getExtractedCoreDir(paramInt);
      new DexClassLoader(XWalkEnvironment.getClassDexFilePath(paramInt), XWalkEnvironment.getOptimizedDexDir(paramInt), str, ClassLoader.getSystemClassLoader());
      AppMethodBeat.o(85928);
      return true;
    }
    catch (Exception localException)
    {
      XWalkInitializer.addXWalkInitializeLog("XWalkLib", "dex output error");
      AppMethodBeat.o(85928);
    }
    return false;
  }
  
  /* Error */
  private static boolean isProviderExist(ContentResolver paramContentResolver, String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: ldc_w 336
    //   5: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: ifnull +14 -> 23
    //   12: aload_1
    //   13: ifnull +10 -> 23
    //   16: aload_1
    //   17: invokevirtual 202	java/lang/String:isEmpty	()Z
    //   20: ifeq +11 -> 31
    //   23: ldc_w 336
    //   26: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: iconst_0
    //   30: ireturn
    //   31: aload_0
    //   32: aload_1
    //   33: invokestatic 339	org/xwalk/core/XWalkEnvironment:getPackageName	()Ljava/lang/String;
    //   36: iconst_1
    //   37: iconst_0
    //   38: ldc_w 341
    //   41: invokestatic 347	com/tencent/xweb/XWebCoreContentProvider:b	(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)Landroid/net/Uri;
    //   44: ldc_w 341
    //   47: invokevirtual 353	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   50: astore_0
    //   51: aload_0
    //   52: invokestatic 359	com/tencent/xweb/util/b:a	(Landroid/content/res/AssetFileDescriptor;)V
    //   55: ldc_w 336
    //   58: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: iload_2
    //   62: ireturn
    //   63: astore_0
    //   64: aconst_null
    //   65: invokestatic 359	com/tencent/xweb/util/b:a	(Landroid/content/res/AssetFileDescriptor;)V
    //   68: iconst_0
    //   69: istore_2
    //   70: goto -15 -> 55
    //   73: astore_0
    //   74: aconst_null
    //   75: invokestatic 359	com/tencent/xweb/util/b:a	(Landroid/content/res/AssetFileDescriptor;)V
    //   78: ldc_w 336
    //   81: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(85930);
    Log.i("XWalkLib", "onDoPatch:" + paramString + ",currentVersion:" + paramInt1 + ",newVersion:" + paramInt2);
    if (!new File(paramString).exists())
    {
      Log.e("XWalkLib", "onDoPatch no patch zip file");
      AppMethodBeat.o(85930);
      return false;
    }
    if (!XWalkDecompressor.decompressDownloadPatchZip(paramString, XWalkEnvironment.getPatchZipTempDecompressPath(paramInt2)))
    {
      Log.e("XWalkLib", "onDoPatch decompress zip error");
      f.pf(37L);
      AppMethodBeat.o(85930);
      return false;
    }
    paramString = XWalkUpdater.PatchFileConfigParser.getPatchFileConfigList(paramInt2);
    if (paramString == null)
    {
      Log.e("XWalkLib", "onDoPatch patchFileConfigList = null");
      f.pf(38L);
      AppMethodBeat.o(85930);
      return false;
    }
    if (!b.jd(XWalkEnvironment.getExtractedCoreDir(paramInt1), XWalkEnvironment.getExtractedCoreDir(paramInt2)))
    {
      Log.e("XWalkLib", "onDoPatch copy all extraced file error");
      f.pf(39L);
      AppMethodBeat.o(85930);
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
      if (!b.copyFile(XWalkEnvironment.getPatchZipTempDecompressFilePath(paramInt2, ((XWalkUpdater.PatchFileConfig)localObject2).originalFileName), XWalkEnvironment.getExtractedCoreFile(paramInt2, ((XWalkUpdater.PatchFileConfig)localObject2).originalFileName)))
      {
        Log.e("XWalkLib", "onDoPatch add file error:".concat(String.valueOf(localObject2)));
        f.pf(40L);
        AppMethodBeat.o(85930);
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
      if (!b.deleteFile(XWalkEnvironment.getExtractedCoreFile(paramInt2, ((XWalkUpdater.PatchFileConfig)localObject2).originalFileName)))
      {
        Log.e("XWalkLib", "onDoPatch delete file error:".concat(String.valueOf(localObject2)));
        f.pf(41L);
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
        if (BSpatch.aK(XWalkEnvironment.getExtractedCoreFile(paramInt2, ((XWalkUpdater.PatchFileConfig)localObject2).originalFileName), XWalkEnvironment.getPatchZipTempDecompressFilePath(paramInt2, ((XWalkUpdater.PatchFileConfig)localObject2).patchFileName), XWalkEnvironment.getExtractedCoreFile(paramInt2, ((XWalkUpdater.PatchFileConfig)localObject2).originalFileName)) < 0)
        {
          Log.e("XWalkLib", "onDoPatch patch error file:".concat(String.valueOf(localObject2)));
          AppMethodBeat.o(85930);
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
        if (BSpatch.aK(XWalkEnvironment.getDownloadApkPath(paramInt1), XWalkEnvironment.getPatchZipTempDecompressFilePath(paramInt2, ((XWalkUpdater.PatchFileConfig)localObject1).patchFileName), XWalkEnvironment.getDownloadApkPath(paramInt2)) < 0)
        {
          Log.e("XWalkLib", "onDoPatch apk patch error file:".concat(String.valueOf(localObject1)));
          AppMethodBeat.o(85930);
          return false;
        }
      }
    }
    Log.i("XWalkLib", "onDoPatch apk patch finished");
    AppMethodBeat.o(85930);
    return true;
  }
  
  public static Integer onHandleFile(UpdateConfig paramUpdateConfig)
  {
    AppMethodBeat.i(85926);
    String str = paramUpdateConfig.getDownloadPath();
    Log.d("XWalkLib", "Download mode extract dir: ".concat(String.valueOf(XWalkEnvironment.getExtractedCoreDir(paramUpdateConfig.apkVer))));
    if ((paramUpdateConfig.isMatchMd5) && (!d.gP(str, paramUpdateConfig.downloadFileMd5)))
    {
      XWalkInitializer.addXWalkInitializeLog("XWalkLib", "downloaded apk md5 check failed");
      AppMethodBeat.o(85926);
      return Integer.valueOf(-2);
    }
    if (paramUpdateConfig.isPatchUpdate)
    {
      if (!onDoPatch(str, XWalkEnvironment.getInstalledNewstVersion(), paramUpdateConfig.apkVer))
      {
        XWalkInitializer.addXWalkInitializeLog("XWalkLib", "patch update mode ,but patch error");
        AppMethodBeat.o(85926);
        return Integer.valueOf(-3);
      }
      if ((paramUpdateConfig.isMatchMd5) && (!FileListMD5Checker.checkFileListMd5(paramUpdateConfig.apkVer, XWalkEnvironment.getPatchFileListConfig(paramUpdateConfig.apkVer))))
      {
        XWalkInitializer.addXWalkInitializeLog("XWalkLib", "patch update mode, but md5 not match");
        f.pf(36L);
        AppMethodBeat.o(85926);
        return Integer.valueOf(-4);
      }
      XWalkInitializer.addXWalkInitializeLog("XWalkLib", "do patch sucsess");
    }
    do
    {
      paramUpdateConfig = extractResource(paramUpdateConfig);
      AppMethodBeat.o(85926);
      return paramUpdateConfig;
      if (!XWalkDecompressor.decompressDownloadFullZip(str, paramUpdateConfig.apkVer))
      {
        f.pf(32L);
        AppMethodBeat.o(85926);
        return Integer.valueOf(-5);
      }
    } while ((!paramUpdateConfig.isMatchMd5) || (FileListMD5Checker.checkFileListMd5(paramUpdateConfig.apkVer, XWalkEnvironment.getDownloadZipFileListConfig(paramUpdateConfig.apkVer))));
    XWalkInitializer.addXWalkInitializeLog("XWalkLib", "patch update mode, but md5 not match");
    f.pf(33L);
    AppMethodBeat.o(85926);
    return Integer.valueOf(-4);
  }
  
  private static boolean tryCopyVersion(ContentResolver paramContentResolver, String paramString, int paramInt, Map<String, String> paramMap, XWalkUpdater.ErrorInfo paramErrorInfo)
  {
    AppMethodBeat.i(85921);
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
        AssetFileDescriptor localAssetFileDescriptor = paramContentResolver.openAssetFileDescriptor(XWebCoreContentProvider.b(paramString, XWalkEnvironment.getPackageName(), 2, paramInt, str1), "");
        if (localAssetFileDescriptor == null)
        {
          paramErrorInfo.copyFailedCount += 1;
          XWalkInitializer.addXWalkInitializeLog("tryCopyVersion no file ".concat(String.valueOf(str1)));
          AppMethodBeat.o(85921);
          return false;
        }
        if ("base.apk".equals(str1)) {}
        for (paramMap = new File(XWalkEnvironment.getDownloadApkPath(paramInt)); !b.a(localAssetFileDescriptor, paramMap); paramMap = new File(XWalkEnvironment.getExtractedCoreFile(paramInt, str1)))
        {
          paramErrorInfo.copyFailedCount += 1;
          XWalkInitializer.addXWalkInitializeLog("tryCopyVersion copy error");
          AppMethodBeat.o(85921);
          return false;
        }
      } while (d.gP(paramMap.getAbsolutePath(), str2));
    }
    catch (Exception paramContentResolver)
    {
      XWalkInitializer.addXWalkInitializeLog("tryCopyVersion copy error:" + paramContentResolver.getMessage());
      paramErrorInfo.copyFailedCount += 1;
      AppMethodBeat.o(85921);
      return false;
    }
    XWalkInitializer.addXWalkInitializeLog("tryCopyVersion md5 error ".concat(String.valueOf(str1)));
    paramErrorInfo.md5FailedCount += 1;
    if (paramMap.exists()) {
      paramMap.delete();
    }
    AppMethodBeat.o(85921);
    return false;
    AppMethodBeat.o(85921);
    return true;
  }
  
  /* Error */
  private static Map<String, String> tryGetFileList(ContentResolver paramContentResolver, String paramString, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 593
    //   3: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 595	java/util/HashMap
    //   9: dup
    //   10: invokespecial 596	java/util/HashMap:<init>	()V
    //   13: astore_3
    //   14: aload_0
    //   15: aload_1
    //   16: invokestatic 339	org/xwalk/core/XWalkEnvironment:getPackageName	()Ljava/lang/String;
    //   19: iconst_2
    //   20: iload_2
    //   21: ldc_w 598
    //   24: invokestatic 347	com/tencent/xweb/XWebCoreContentProvider:b	(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)Landroid/net/Uri;
    //   27: ldc_w 341
    //   30: invokevirtual 353	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   33: astore_1
    //   34: aload_1
    //   35: ifnonnull +29 -> 64
    //   38: ldc_w 600
    //   41: invokestatic 568	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   44: aconst_null
    //   45: invokestatic 604	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   48: aconst_null
    //   49: invokestatic 604	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   52: aload_1
    //   53: invokestatic 359	com/tencent/xweb/util/b:a	(Landroid/content/res/AssetFileDescriptor;)V
    //   56: ldc_w 593
    //   59: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: aload_3
    //   63: areturn
    //   64: new 121	java/io/File
    //   67: dup
    //   68: iload_2
    //   69: ldc_w 598
    //   72: invokestatic 432	org/xwalk/core/XWalkEnvironment:getExtractedCoreFile	(ILjava/lang/String;)Ljava/lang/String;
    //   75: invokespecial 124	java/io/File:<init>	(Ljava/lang/String;)V
    //   78: astore_0
    //   79: aload_0
    //   80: invokevirtual 128	java/io/File:exists	()Z
    //   83: ifeq +8 -> 91
    //   86: aload_0
    //   87: invokevirtual 235	java/io/File:delete	()Z
    //   90: pop
    //   91: new 606	java/io/PrintWriter
    //   94: dup
    //   95: aload_0
    //   96: invokespecial 607	java/io/PrintWriter:<init>	(Ljava/io/File;)V
    //   99: astore 4
    //   101: new 192	java/io/BufferedReader
    //   104: dup
    //   105: new 187	java/io/InputStreamReader
    //   108: dup
    //   109: aload_1
    //   110: invokevirtual 613	android/content/res/AssetFileDescriptor:createInputStream	()Ljava/io/FileInputStream;
    //   113: invokespecial 190	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   116: invokespecial 195	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   119: astore_0
    //   120: aload 4
    //   122: astore 7
    //   124: aload_0
    //   125: astore 6
    //   127: aload_1
    //   128: astore 5
    //   130: aload_0
    //   131: invokevirtual 199	java/io/BufferedReader:readLine	()Ljava/lang/String;
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
    //   155: invokevirtual 616	java/io/PrintWriter:println	(Ljava/lang/String;)V
    //   158: aload 4
    //   160: astore 7
    //   162: aload_0
    //   163: astore 6
    //   165: aload_1
    //   166: astore 5
    //   168: aload 8
    //   170: invokevirtual 202	java/lang/String:isEmpty	()Z
    //   173: ifne -53 -> 120
    //   176: aload 4
    //   178: astore 7
    //   180: aload_0
    //   181: astore 6
    //   183: aload_1
    //   184: astore 5
    //   186: aload 8
    //   188: ldc 204
    //   190: invokevirtual 208	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
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
    //   233: invokevirtual 202	java/lang/String:isEmpty	()Z
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
    //   260: invokevirtual 202	java/lang/String:isEmpty	()Z
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
    //   285: invokeinterface 620 3 0
    //   290: pop
    //   291: goto -171 -> 120
    //   294: astore_3
    //   295: aload 4
    //   297: astore 7
    //   299: aload_0
    //   300: astore 6
    //   302: aload_1
    //   303: astore 5
    //   305: new 218	java/lang/StringBuilder
    //   308: dup
    //   309: ldc_w 622
    //   312: invokespecial 221	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   315: aload_3
    //   316: invokevirtual 256	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   319: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: invokestatic 568	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   328: aload 4
    //   330: invokestatic 604	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   333: aload_0
    //   334: invokestatic 604	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   337: aload_1
    //   338: invokestatic 359	com/tencent/xweb/util/b:a	(Landroid/content/res/AssetFileDescriptor;)V
    //   341: ldc_w 593
    //   344: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   347: aconst_null
    //   348: areturn
    //   349: aload 4
    //   351: astore 7
    //   353: aload_0
    //   354: astore 6
    //   356: aload_1
    //   357: astore 5
    //   359: aload 4
    //   361: invokevirtual 625	java/io/PrintWriter:flush	()V
    //   364: aload 4
    //   366: invokestatic 604	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   369: aload_0
    //   370: invokestatic 604	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   373: aload_1
    //   374: invokestatic 359	com/tencent/xweb/util/b:a	(Landroid/content/res/AssetFileDescriptor;)V
    //   377: ldc_w 593
    //   380: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   394: invokestatic 604	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   397: aload 4
    //   399: invokestatic 604	com/tencent/xweb/util/b:tryClose	(Ljava/io/Closeable;)V
    //   402: aload_1
    //   403: invokestatic 359	com/tencent/xweb/util/b:a	(Landroid/content/res/AssetFileDescriptor;)V
    //   406: ldc_w 593
    //   409: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static void updateLocalXWalkRuntime()
  {
    AppMethodBeat.i(85922);
    onHandleFile(new UpdateConfig("runtime_package.zip", false, 100000));
    AppMethodBeat.o(85922);
  }
  
  private boolean verifyDownloadedXWalkRuntime(String paramString)
  {
    AppMethodBeat.i(85931);
    paramString = this.mContext.getPackageManager().getPackageArchiveInfo(paramString, 64);
    if (paramString == null)
    {
      Log.e("XWalkLib", "The downloaded XWalkRuntimeLib.apk is invalid!");
      AppMethodBeat.o(85931);
      return false;
    }
    PackageInfo localPackageInfo;
    try
    {
      localPackageInfo = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 64);
      if ((paramString.signatures == null) || (localPackageInfo.signatures == null))
      {
        Log.e("XWalkLib", "No signature in package info");
        AppMethodBeat.o(85931);
        return false;
      }
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      AppMethodBeat.o(85931);
      return false;
    }
    if (paramString.signatures.length != localPackageInfo.signatures.length)
    {
      Log.e("XWalkLib", "signatures length not equal");
      AppMethodBeat.o(85931);
      return false;
    }
    int i = 0;
    while (i < paramString.signatures.length)
    {
      Log.d("XWalkLib", "Checking signature ".concat(String.valueOf(i)));
      if (!localPackageInfo.signatures[i].equals(paramString.signatures[i]))
      {
        Log.e("XWalkLib", "signatures do not match");
        AppMethodBeat.o(85931);
        return false;
      }
      i += 1;
    }
    Log.d("XWalkLib", "Signature check passed");
    AppMethodBeat.o(85931);
    return true;
  }
  
  public boolean cancelBackgroundDownload()
  {
    AppMethodBeat.i(85925);
    boolean bool = XWalkLibraryLoader.cancelHttpDownload();
    AppMethodBeat.o(85925);
    return bool;
  }
  
  public void cancelXWalkRuntimeDownload()
  {
    AppMethodBeat.i(85923);
    if (XWalkLibraryLoader.isDownloading())
    {
      XWalkInitializer.addXWalkInitializeLog("XWalkLib", "canceled download apk");
      XWalkLibraryLoader.cancelHttpDownload();
    }
    AppMethodBeat.o(85923);
  }
  
  public boolean dismissDialog()
  {
    AppMethodBeat.i(85924);
    if ((this.mDialogManager == null) || (!this.mDialogManager.isShowingDialog()))
    {
      AppMethodBeat.o(85924);
      return false;
    }
    this.mDialogManager.dismissDialog();
    AppMethodBeat.o(85924);
    return true;
  }
  
  public XWalkUpdater.ErrorInfo updateRuntimeFromProvider(c.a parama)
  {
    for (;;)
    {
      XWalkUpdater.ErrorInfo localErrorInfo;
      ContentResolver localContentResolver;
      UpdateConfig localUpdateConfig;
      int i;
      String str;
      int k;
      Map localMap;
      try
      {
        AppMethodBeat.i(85918);
        XWalkInitializer.addXWalkInitializeLog("updateFromProvider target ver " + parama.BKV);
        localErrorInfo = new XWalkUpdater.ErrorInfo();
        localErrorInfo.targetVer = parama.BKV;
        if (!parama.bTryUseSharedCore)
        {
          XWalkInitializer.addXWalkInitializeLog("updateFromProvider force download");
          localErrorInfo.errorCode = -6;
          AppMethodBeat.o(85918);
          return localErrorInfo;
        }
        if (parama.BLg >= 2)
        {
          XWalkInitializer.addXWalkInitializeLog("updateFromProvider exceed max count");
          localErrorInfo.errorCode = -7;
          AppMethodBeat.o(85918);
          continue;
        }
        localContentResolver = XWalkEnvironment.getContentResolver();
        if (localContentResolver == null)
        {
          XWalkInitializer.addXWalkInitializeLog("updateFromProvider content resolver null");
          localErrorInfo.errorCode = -8;
          AppMethodBeat.o(85918);
          continue;
        }
        localUpdateConfig = parama.eaE();
        String[] arrayOfString = XWalkEnvironment.XWALK_CORE_PROVIDER_LIST;
        int m = arrayOfString.length;
        i = 0;
        j = 0;
        if (i >= m) {
          break label413;
        }
        str = arrayOfString[i];
        if (!isProviderExist(localContentResolver, str)) {
          break label493;
        }
        k = 1;
        XWalkInitializer.addXWalkInitializeLog("updateFromProvider find ".concat(String.valueOf(str)));
        localMap = tryGetFileList(localContentResolver, str, localUpdateConfig.apkVer);
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
      if (tryCopyVersion(localContentResolver, str, localUpdateConfig.apkVer, localMap, localErrorInfo))
      {
        int n = extractResource(localUpdateConfig).intValue();
        if (n == 0)
        {
          localErrorInfo.errorCode = 0;
          AppMethodBeat.o(85918);
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
            break label493;
            label413:
            if (j == 0)
            {
              XWalkInitializer.addXWalkInitializeLog("updateFromProvider no provider");
              localErrorInfo.errorCode = -9;
              AppMethodBeat.o(85918);
              continue;
            }
            if ((XWalkEnvironment.hasAvailableVersion()) && (parama.BLg + 1 < 2)) {
              XWalkInitializer.addXWalkInitializeLog("updateFromProvider failed, can try again");
            }
            for (localErrorInfo.errorCode = -10;; localErrorInfo.errorCode = -11)
            {
              AppMethodBeat.o(85918);
              break;
              XWalkInitializer.addXWalkInitializeLog("updateFromProvider failed, do not try again");
            }
          }
        }
      }
      label493:
      i += 1;
    }
  }
  
  public boolean updateXWalkRuntime(UpdateConfig paramUpdateConfig)
  {
    AppMethodBeat.i(85917);
    if (XWalkLibraryLoader.isDownloading())
    {
      XWalkInitializer.addXWalkInitializeLog("XWalkLib", "Other initialization or download is proceeding");
      AppMethodBeat.o(85917);
      return false;
    }
    if (this.mBackgroundUpdateListener != null)
    {
      if ((paramUpdateConfig == null) || (!paramUpdateConfig.checkValid()))
      {
        XWalkInitializer.addXWalkInitializeLog("XWalkLib", "royle:XWalkUpdater updateXWalkRuntime updateConfig is not valid");
        f.dZs();
        AppMethodBeat.o(85917);
        return false;
      }
      XWalkInitializer.addXWalkInitializeLog("XWalkLib", "start download apk");
      XWalkLibraryLoader.startHttpDownload(new XWalkUpdater.BackgroundListener(this, paramUpdateConfig), this.mContext, paramUpdateConfig);
      AppMethodBeat.o(85917);
      return true;
    }
    XWalkInitializer.addXWalkInitializeLog("XWalkLib", "Update listener is null");
    AppMethodBeat.o(85917);
    return false;
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
      AppMethodBeat.i(85907);
      try
      {
        boolean bool = checkFileListMd5(paramInt, new File(paramString));
        AppMethodBeat.o(85907);
        return bool;
      }
      catch (Exception paramString)
      {
        Log.e("XWalkLib", "checkFileListMd5 error:" + paramString.getMessage());
        AppMethodBeat.o(85907);
      }
      return false;
    }
    
    private static boolean checkFileMd5(int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(85908);
      if ("base.apk".equals(paramString1)) {}
      for (paramString1 = XWalkEnvironment.getDownloadApkPath(paramInt); d.gP(paramString1, paramString2); paramString1 = XWalkEnvironment.getExtractedCoreFile(paramInt, paramString1))
      {
        Log.i("XWalkLib", "checkFileMd5 successful path:".concat(String.valueOf(paramString1)));
        AppMethodBeat.o(85908);
        return true;
      }
      Log.e("XWalkLib", "checkFileMd5 error path:".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(85908);
      return false;
    }
  }
  
  public static class UpdateConfig
  {
    public int apkVer;
    public boolean bTryUseSharedCore;
    public boolean bUseCdn;
    public String downUrl;
    public String downloadFileMd5;
    public boolean isMatchMd5;
    public boolean isPatchUpdate;
    public String patchEndFileMd5;
    public String versionDetail;
    
    public UpdateConfig(String paramString, boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(85911);
      this.apkVer = -1;
      this.isMatchMd5 = false;
      this.isPatchUpdate = paramBoolean;
      this.downUrl = paramString;
      this.apkVer = paramInt;
      if (!checkValid())
      {
        paramString = new RuntimeException("royle:UpdateConfig is not valid");
        AppMethodBeat.o(85911);
        throw paramString;
      }
      AppMethodBeat.o(85911);
    }
    
    public UpdateConfig(String paramString1, boolean paramBoolean, String paramString2, String paramString3, int paramInt)
    {
      AppMethodBeat.i(85912);
      this.apkVer = -1;
      this.isMatchMd5 = true;
      this.downloadFileMd5 = paramString1;
      this.isPatchUpdate = paramBoolean;
      this.patchEndFileMd5 = paramString2;
      this.downUrl = paramString3;
      this.apkVer = paramInt;
      if (!checkValid())
      {
        paramString1 = new RuntimeException("royle:UpdateConfig is not valid");
        AppMethodBeat.o(85912);
        throw paramString1;
      }
      AppMethodBeat.o(85912);
    }
    
    public boolean checkValid()
    {
      AppMethodBeat.i(85914);
      if ((this.isMatchMd5) && ((this.downloadFileMd5 == null) || (this.downloadFileMd5.isEmpty())))
      {
        AppMethodBeat.o(85914);
        return false;
      }
      if ((this.downUrl == null) || (this.downUrl.isEmpty()))
      {
        AppMethodBeat.o(85914);
        return false;
      }
      if (this.apkVer == -1)
      {
        AppMethodBeat.o(85914);
        return false;
      }
      if ((this.isMatchMd5) && (this.isPatchUpdate) && ((this.patchEndFileMd5 == null) || (this.patchEndFileMd5.isEmpty())))
      {
        AppMethodBeat.o(85914);
        return false;
      }
      AppMethodBeat.o(85914);
      return true;
    }
    
    public String getDownloadPath()
    {
      AppMethodBeat.i(85913);
      if (checkValid())
      {
        if (this.isPatchUpdate)
        {
          localObject = XWalkEnvironment.getDownloadPatchPath(this.apkVer);
          AppMethodBeat.o(85913);
          return localObject;
        }
        localObject = XWalkEnvironment.getDownloadZipDir(this.apkVer);
        AppMethodBeat.o(85913);
        return localObject;
      }
      Object localObject = new RuntimeException("royle:UpdateConfig is not valid");
      AppMethodBeat.o(85913);
      throw ((Throwable)localObject);
    }
    
    public String getLogSelf()
    {
      AppMethodBeat.i(85915);
      if (checkValid())
      {
        String str = "UpdateConfig isMatchMd5:" + this.isMatchMd5 + " downloadFileMd5:" + this.downloadFileMd5 + ",isPatchUpdate:" + this.isPatchUpdate + ",downUrl:" + this.downUrl + ",apkVer:" + this.apkVer + ",useCDN:" + this.bUseCdn + ",downloadPath:" + getDownloadPath() + ".";
        AppMethodBeat.o(85915);
        return str;
      }
      AppMethodBeat.o(85915);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.xwalk.core.XWalkUpdater
 * JD-Core Version:    0.7.0.1
 */