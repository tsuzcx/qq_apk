package com.tencent.xweb.xwalk.updater;

import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Timer;
import java.util.TimerTask;
import org.xwalk.core.XWalkEnvironment;

public final class o
  extends AsyncTask<a, b, c>
{
  private b aire = null;
  private a airf = null;
  private int airg = 0;
  private long airh = 0L;
  private Timer mTimer = null;
  
  /* Error */
  private c a(a... paramVarArgs)
  {
    // Byte code:
    //   0: ldc 46
    //   2: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ifnonnull +10 -> 16
    //   9: ldc 46
    //   11: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   14: aconst_null
    //   15: areturn
    //   16: aload_1
    //   17: arraylength
    //   18: iconst_1
    //   19: if_icmpeq +10 -> 29
    //   22: ldc 46
    //   24: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aconst_null
    //   28: areturn
    //   29: aload_1
    //   30: iconst_0
    //   31: aaload
    //   32: astore 16
    //   34: aload 16
    //   36: ifnonnull +10 -> 46
    //   39: ldc 46
    //   41: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: aconst_null
    //   45: areturn
    //   46: aload_0
    //   47: getfield 32	com/tencent/xweb/xwalk/updater/o:aire	Lcom/tencent/xweb/xwalk/updater/b;
    //   50: ifnull +12 -> 62
    //   53: aload_0
    //   54: getfield 32	com/tencent/xweb/xwalk/updater/o:aire	Lcom/tencent/xweb/xwalk/updater/b;
    //   57: invokeinterface 60 1 0
    //   62: new 15	com/tencent/xweb/xwalk/updater/o$c
    //   65: dup
    //   66: invokespecial 61	com/tencent/xweb/xwalk/updater/o$c:<init>	()V
    //   69: astore 15
    //   71: aload 15
    //   73: aload 16
    //   75: getfield 65	com/tencent/xweb/xwalk/updater/o$a:mUrl	Ljava/lang/String;
    //   78: putfield 66	com/tencent/xweb/xwalk/updater/o$c:mUrl	Ljava/lang/String;
    //   81: aload 15
    //   83: aload 16
    //   85: getfield 69	com/tencent/xweb/xwalk/updater/o$a:mFilePath	Ljava/lang/String;
    //   88: putfield 70	com/tencent/xweb/xwalk/updater/o$c:mFilePath	Ljava/lang/String;
    //   91: aload 15
    //   93: iconst_0
    //   94: putfield 73	com/tencent/xweb/xwalk/updater/o$c:airl	I
    //   97: aload 15
    //   99: ldc 75
    //   101: putfield 78	com/tencent/xweb/xwalk/updater/o$c:rzc	Ljava/lang/String;
    //   104: aload 15
    //   106: aload_0
    //   107: getfield 36	com/tencent/xweb/xwalk/updater/o:airg	I
    //   110: putfield 81	com/tencent/xweb/xwalk/updater/o$c:mRetryTimes	I
    //   113: aload 15
    //   115: lconst_0
    //   116: putfield 84	com/tencent/xweb/xwalk/updater/o$c:cEh	J
    //   119: aload 15
    //   121: lconst_0
    //   122: putfield 87	com/tencent/xweb/xwalk/updater/o$c:mTotalSize	J
    //   125: aload 15
    //   127: iconst_0
    //   128: putfield 90	com/tencent/xweb/xwalk/updater/o$c:airm	I
    //   131: aload 15
    //   133: invokestatic 96	org/xwalk/core/XWalkEnvironment:getApplicationContext	()Landroid/content/Context;
    //   136: invokestatic 102	org/xwalk/core/NetworkUtil:getCurrentNetWorkStatus	(Landroid/content/Context;)I
    //   139: putfield 105	com/tencent/xweb/xwalk/updater/o$c:mNetWorkType	I
    //   142: aload 16
    //   144: getfield 65	com/tencent/xweb/xwalk/updater/o$a:mUrl	Ljava/lang/String;
    //   147: ifnull +40 -> 187
    //   150: aload 16
    //   152: getfield 69	com/tencent/xweb/xwalk/updater/o$a:mFilePath	Ljava/lang/String;
    //   155: ifnull +32 -> 187
    //   158: aload 16
    //   160: getfield 65	com/tencent/xweb/xwalk/updater/o$a:mUrl	Ljava/lang/String;
    //   163: invokevirtual 111	java/lang/String:length	()I
    //   166: ifeq +21 -> 187
    //   169: aload 16
    //   171: getfield 69	com/tencent/xweb/xwalk/updater/o$a:mFilePath	Ljava/lang/String;
    //   174: invokevirtual 111	java/lang/String:length	()I
    //   177: ifeq +10 -> 187
    //   180: aload_0
    //   181: getfield 32	com/tencent/xweb/xwalk/updater/o:aire	Lcom/tencent/xweb/xwalk/updater/b;
    //   184: ifnonnull +26 -> 210
    //   187: ldc 113
    //   189: ldc 115
    //   191: invokestatic 119	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   194: aload 15
    //   196: sipush -10001
    //   199: putfield 73	com/tencent/xweb/xwalk/updater/o$c:airl	I
    //   202: ldc 46
    //   204: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   207: aload 15
    //   209: areturn
    //   210: aconst_null
    //   211: astore 12
    //   213: aconst_null
    //   214: astore 10
    //   216: aconst_null
    //   217: astore 8
    //   219: aconst_null
    //   220: astore 9
    //   222: aconst_null
    //   223: astore 14
    //   225: aconst_null
    //   226: astore_1
    //   227: aconst_null
    //   228: astore 13
    //   230: new 121	java/net/URL
    //   233: dup
    //   234: aload 16
    //   236: getfield 65	com/tencent/xweb/xwalk/updater/o$a:mUrl	Ljava/lang/String;
    //   239: invokespecial 124	java/net/URL:<init>	(Ljava/lang/String;)V
    //   242: invokevirtual 128	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   245: checkcast 130	java/net/HttpURLConnection
    //   248: astore 11
    //   250: aload 14
    //   252: astore_1
    //   253: aload 10
    //   255: astore 8
    //   257: aload 11
    //   259: ldc 132
    //   261: invokevirtual 135	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   264: aload 14
    //   266: astore_1
    //   267: aload 10
    //   269: astore 8
    //   271: new 137	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   278: astore 13
    //   280: aload 14
    //   282: astore_1
    //   283: aload 10
    //   285: astore 8
    //   287: aload 13
    //   289: new 137	java/lang/StringBuilder
    //   292: dup
    //   293: ldc 140
    //   295: invokespecial 141	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   298: invokestatic 146	com/tencent/xweb/ao:kge	()I
    //   301: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   304: ldc 152
    //   306: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: pop
    //   316: aload 14
    //   318: astore_1
    //   319: aload 10
    //   321: astore 8
    //   323: aload 13
    //   325: new 137	java/lang/StringBuilder
    //   328: dup
    //   329: ldc 161
    //   331: invokespecial 141	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   334: invokestatic 164	org/xwalk/core/XWalkEnvironment:getInstalledNewstVersionForCurAbi	()I
    //   337: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   340: ldc 152
    //   342: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: pop
    //   352: aload 14
    //   354: astore_1
    //   355: aload 10
    //   357: astore 8
    //   359: aload 13
    //   361: new 137	java/lang/StringBuilder
    //   364: dup
    //   365: ldc 166
    //   367: invokespecial 141	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   370: invokestatic 171	org/xwalk/core/XWalkGrayValueUtil:getGrayValue	()I
    //   373: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   376: ldc 152
    //   378: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   384: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: pop
    //   388: aload 14
    //   390: astore_1
    //   391: aload 10
    //   393: astore 8
    //   395: aload 13
    //   397: new 137	java/lang/StringBuilder
    //   400: dup
    //   401: ldc 173
    //   403: invokespecial 141	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   406: invokestatic 176	org/xwalk/core/XWalkGrayValueUtil:getTodayGrayValue	()I
    //   409: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   412: ldc 152
    //   414: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   420: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: pop
    //   424: aload 14
    //   426: astore_1
    //   427: aload 10
    //   429: astore 8
    //   431: aload 13
    //   433: new 137	java/lang/StringBuilder
    //   436: dup
    //   437: ldc 178
    //   439: invokespecial 141	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   442: invokestatic 181	org/xwalk/core/XWalkGrayValueUtil:getUserId	()I
    //   445: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   448: ldc 152
    //   450: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   456: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: pop
    //   460: aload 14
    //   462: astore_1
    //   463: aload 10
    //   465: astore 8
    //   467: aload 13
    //   469: new 137	java/lang/StringBuilder
    //   472: dup
    //   473: ldc 183
    //   475: invokespecial 141	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   478: invokestatic 188	com/tencent/xweb/util/b:khw	()Ljava/lang/String;
    //   481: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: ldc 152
    //   486: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   492: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: pop
    //   496: aload 14
    //   498: astore_1
    //   499: aload 10
    //   501: astore 8
    //   503: aload 13
    //   505: new 137	java/lang/StringBuilder
    //   508: dup
    //   509: ldc 190
    //   511: invokespecial 141	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   514: invokestatic 193	org/xwalk/core/XWalkEnvironment:dumpAppInfo	()Ljava/lang/String;
    //   517: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: ldc 195
    //   522: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   525: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   528: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: pop
    //   532: aload 14
    //   534: astore_1
    //   535: aload 10
    //   537: astore 8
    //   539: aload 13
    //   541: new 137	java/lang/StringBuilder
    //   544: dup
    //   545: ldc 197
    //   547: invokespecial 141	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   550: invokestatic 200	org/xwalk/core/XWalkEnvironment:getProcessName	()Ljava/lang/String;
    //   553: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: ldc 152
    //   558: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   564: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: pop
    //   568: aload 14
    //   570: astore_1
    //   571: aload 10
    //   573: astore 8
    //   575: aload 11
    //   577: ldc 202
    //   579: aload 13
    //   581: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   584: invokevirtual 205	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   587: aload 14
    //   589: astore_1
    //   590: aload 10
    //   592: astore 8
    //   594: aload 11
    //   596: sipush 8000
    //   599: invokevirtual 208	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   602: aload 14
    //   604: astore_1
    //   605: aload 10
    //   607: astore 8
    //   609: aload 11
    //   611: sipush 8000
    //   614: invokevirtual 211	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   617: aload 14
    //   619: astore_1
    //   620: aload 10
    //   622: astore 8
    //   624: aload 11
    //   626: invokevirtual 214	java/net/HttpURLConnection:getResponseCode	()I
    //   629: istore_2
    //   630: iload_2
    //   631: sipush 200
    //   634: if_icmpne +428 -> 1062
    //   637: aload 14
    //   639: astore_1
    //   640: aload 10
    //   642: astore 8
    //   644: aload 11
    //   646: invokevirtual 218	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   649: astore 9
    //   651: aload 9
    //   653: astore_1
    //   654: aload 10
    //   656: astore 8
    //   658: aload 11
    //   660: invokevirtual 221	java/net/HttpURLConnection:getContentLength	()I
    //   663: istore_2
    //   664: aload 9
    //   666: astore_1
    //   667: aload 10
    //   669: astore 8
    //   671: aload 16
    //   673: getfield 69	com/tencent/xweb/xwalk/updater/o$a:mFilePath	Ljava/lang/String;
    //   676: astore 12
    //   678: aload 9
    //   680: astore_1
    //   681: aload 10
    //   683: astore 8
    //   685: new 223	java/io/File
    //   688: dup
    //   689: aload 12
    //   691: invokespecial 224	java/io/File:<init>	(Ljava/lang/String;)V
    //   694: astore 13
    //   696: aload 9
    //   698: astore_1
    //   699: aload 10
    //   701: astore 8
    //   703: aload 13
    //   705: invokevirtual 228	java/io/File:exists	()Z
    //   708: ifeq +16 -> 724
    //   711: aload 9
    //   713: astore_1
    //   714: aload 10
    //   716: astore 8
    //   718: aload 13
    //   720: invokevirtual 231	java/io/File:delete	()Z
    //   723: pop
    //   724: aload 9
    //   726: astore_1
    //   727: aload 10
    //   729: astore 8
    //   731: new 233	java/io/FileOutputStream
    //   734: dup
    //   735: aload 12
    //   737: invokespecial 234	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   740: astore 10
    //   742: sipush 4096
    //   745: newarray byte
    //   747: astore_1
    //   748: lconst_0
    //   749: lstore 4
    //   751: new 12	com/tencent/xweb/xwalk/updater/o$b
    //   754: dup
    //   755: invokespecial 235	com/tencent/xweb/xwalk/updater/o$b:<init>	()V
    //   758: astore 8
    //   760: aload 8
    //   762: aload 16
    //   764: getfield 65	com/tencent/xweb/xwalk/updater/o$a:mUrl	Ljava/lang/String;
    //   767: putfield 236	com/tencent/xweb/xwalk/updater/o$b:mUrl	Ljava/lang/String;
    //   770: aload 8
    //   772: iload_2
    //   773: i2l
    //   774: putfield 237	com/tencent/xweb/xwalk/updater/o$b:mTotalSize	J
    //   777: aload 9
    //   779: aload_1
    //   780: invokevirtual 243	java/io/InputStream:read	([B)I
    //   783: istore_3
    //   784: iload_3
    //   785: iconst_m1
    //   786: if_icmpeq +206 -> 992
    //   789: aload_0
    //   790: invokevirtual 246	com/tencent/xweb/xwalk/updater/o:isCancelled	()Z
    //   793: ifeq +72 -> 865
    //   796: aload 9
    //   798: invokevirtual 249	java/io/InputStream:close	()V
    //   801: aload 10
    //   803: invokevirtual 252	java/io/OutputStream:close	()V
    //   806: aload 9
    //   808: ifnull +8 -> 816
    //   811: aload 9
    //   813: invokevirtual 249	java/io/InputStream:close	()V
    //   816: aload 11
    //   818: ifnull +8 -> 826
    //   821: aload 11
    //   823: invokevirtual 255	java/net/HttpURLConnection:disconnect	()V
    //   826: ldc 46
    //   828: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   831: aconst_null
    //   832: areturn
    //   833: astore_1
    //   834: ldc 113
    //   836: ldc_w 257
    //   839: aload_1
    //   840: invokestatic 261	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   843: invokevirtual 265	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   846: invokestatic 119	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   849: aload 15
    //   851: sipush -10003
    //   854: putfield 73	com/tencent/xweb/xwalk/updater/o$c:airl	I
    //   857: ldc 46
    //   859: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   862: aload 15
    //   864: areturn
    //   865: lload 4
    //   867: iload_3
    //   868: i2l
    //   869: ladd
    //   870: lstore 6
    //   872: aload 10
    //   874: aload_1
    //   875: iconst_0
    //   876: iload_3
    //   877: invokevirtual 269	java/io/OutputStream:write	([BII)V
    //   880: aload 8
    //   882: lload 6
    //   884: putfield 272	com/tencent/xweb/xwalk/updater/o$b:airk	J
    //   887: lload 6
    //   889: lstore 4
    //   891: iload_2
    //   892: ifle -115 -> 777
    //   895: aload_0
    //   896: iconst_1
    //   897: anewarray 12	com/tencent/xweb/xwalk/updater/o$b
    //   900: dup
    //   901: iconst_0
    //   902: aload 8
    //   904: aastore
    //   905: invokevirtual 276	com/tencent/xweb/xwalk/updater/o:publishProgress	([Ljava/lang/Object;)V
    //   908: lload 6
    //   910: lstore 4
    //   912: goto -135 -> 777
    //   915: astore 12
    //   917: aload 10
    //   919: astore 8
    //   921: aload 9
    //   923: astore_1
    //   924: aload 11
    //   926: astore 10
    //   928: aload 12
    //   930: astore 9
    //   932: ldc 113
    //   934: ldc_w 278
    //   937: aload 9
    //   939: invokestatic 261	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   942: invokevirtual 265	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   945: invokestatic 119	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   948: aload 15
    //   950: sipush -10002
    //   953: putfield 73	com/tencent/xweb/xwalk/updater/o$c:airl	I
    //   956: aload 8
    //   958: ifnull +8 -> 966
    //   961: aload 8
    //   963: invokevirtual 252	java/io/OutputStream:close	()V
    //   966: aload_1
    //   967: ifnull +7 -> 974
    //   970: aload_1
    //   971: invokevirtual 249	java/io/InputStream:close	()V
    //   974: aload 10
    //   976: ifnull +8 -> 984
    //   979: aload 10
    //   981: invokevirtual 255	java/net/HttpURLConnection:disconnect	()V
    //   984: ldc 46
    //   986: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   989: aload 15
    //   991: areturn
    //   992: aload 15
    //   994: lload 4
    //   996: putfield 87	com/tencent/xweb/xwalk/updater/o$c:mTotalSize	J
    //   999: aload 15
    //   1001: invokestatic 284	java/lang/System:currentTimeMillis	()J
    //   1004: aload_0
    //   1005: getfield 40	com/tencent/xweb/xwalk/updater/o:airh	J
    //   1008: lsub
    //   1009: putfield 84	com/tencent/xweb/xwalk/updater/o$c:cEh	J
    //   1012: aload 9
    //   1014: astore_1
    //   1015: aload 10
    //   1017: astore 8
    //   1019: aload 11
    //   1021: invokevirtual 255	java/net/HttpURLConnection:disconnect	()V
    //   1024: aload 10
    //   1026: ifnull +8 -> 1034
    //   1029: aload 10
    //   1031: invokevirtual 252	java/io/OutputStream:close	()V
    //   1034: aload 9
    //   1036: ifnull +8 -> 1044
    //   1039: aload 9
    //   1041: invokevirtual 249	java/io/InputStream:close	()V
    //   1044: aload 11
    //   1046: ifnull +8 -> 1054
    //   1049: aload 11
    //   1051: invokevirtual 255	java/net/HttpURLConnection:disconnect	()V
    //   1054: ldc 46
    //   1056: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1059: aload 15
    //   1061: areturn
    //   1062: aload 14
    //   1064: astore_1
    //   1065: aload 10
    //   1067: astore 8
    //   1069: aload 15
    //   1071: sipush -10005
    //   1074: putfield 73	com/tencent/xweb/xwalk/updater/o$c:airl	I
    //   1077: aload 14
    //   1079: astore_1
    //   1080: aload 10
    //   1082: astore 8
    //   1084: aload 15
    //   1086: ldc_w 286
    //   1089: iload_2
    //   1090: invokestatic 289	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1093: invokevirtual 265	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1096: putfield 78	com/tencent/xweb/xwalk/updater/o$c:rzc	Ljava/lang/String;
    //   1099: aload 12
    //   1101: astore 10
    //   1103: goto -91 -> 1012
    //   1106: astore 9
    //   1108: aload 11
    //   1110: astore 10
    //   1112: goto -180 -> 932
    //   1115: astore_1
    //   1116: ldc 113
    //   1118: ldc_w 257
    //   1121: aload_1
    //   1122: invokestatic 261	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1125: invokevirtual 265	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1128: invokestatic 119	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   1131: aload 15
    //   1133: sipush -10003
    //   1136: putfield 73	com/tencent/xweb/xwalk/updater/o$c:airl	I
    //   1139: ldc 46
    //   1141: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1144: aload 15
    //   1146: areturn
    //   1147: astore_1
    //   1148: ldc 113
    //   1150: ldc_w 257
    //   1153: aload_1
    //   1154: invokestatic 261	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1157: invokevirtual 265	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1160: invokestatic 119	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   1163: aload 15
    //   1165: sipush -10003
    //   1168: putfield 73	com/tencent/xweb/xwalk/updater/o$c:airl	I
    //   1171: ldc 46
    //   1173: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1176: aload 15
    //   1178: areturn
    //   1179: astore 9
    //   1181: aload 8
    //   1183: ifnull +8 -> 1191
    //   1186: aload 8
    //   1188: invokevirtual 252	java/io/OutputStream:close	()V
    //   1191: aload_1
    //   1192: ifnull +7 -> 1199
    //   1195: aload_1
    //   1196: invokevirtual 249	java/io/InputStream:close	()V
    //   1199: aload 10
    //   1201: ifnull +8 -> 1209
    //   1204: aload 10
    //   1206: invokevirtual 255	java/net/HttpURLConnection:disconnect	()V
    //   1209: ldc 46
    //   1211: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1214: aload 9
    //   1216: athrow
    //   1217: astore_1
    //   1218: ldc 113
    //   1220: ldc_w 257
    //   1223: aload_1
    //   1224: invokestatic 261	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1227: invokevirtual 265	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1230: invokestatic 119	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   1233: aload 15
    //   1235: sipush -10003
    //   1238: putfield 73	com/tencent/xweb/xwalk/updater/o$c:airl	I
    //   1241: ldc 46
    //   1243: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1246: aload 15
    //   1248: areturn
    //   1249: astore 9
    //   1251: aload 13
    //   1253: astore 10
    //   1255: goto -323 -> 932
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1258	0	this	o
    //   0	1258	1	paramVarArgs	a[]
    //   629	461	2	i	int
    //   783	94	3	j	int
    //   749	246	4	l1	long
    //   870	39	6	l2	long
    //   217	970	8	localObject1	Object
    //   220	820	9	localObject2	Object
    //   1106	1	9	localObject3	Object
    //   1179	36	9	localObject4	Object
    //   1249	1	9	localObject5	Object
    //   214	1040	10	localObject6	Object
    //   248	861	11	localHttpURLConnection	java.net.HttpURLConnection
    //   211	525	12	str	String
    //   915	185	12	localObject7	Object
    //   228	1024	13	localObject8	Object
    //   223	855	14	localObject9	Object
    //   69	1178	15	localc	c
    //   32	731	16	locala	a
    // Exception table:
    //   from	to	target	type
    //   801	806	833	java/io/IOException
    //   811	816	833	java/io/IOException
    //   742	748	915	finally
    //   751	777	915	finally
    //   777	784	915	finally
    //   789	801	915	finally
    //   872	887	915	finally
    //   895	908	915	finally
    //   992	1012	915	finally
    //   257	264	1106	finally
    //   271	280	1106	finally
    //   287	316	1106	finally
    //   323	352	1106	finally
    //   359	388	1106	finally
    //   395	424	1106	finally
    //   431	460	1106	finally
    //   467	496	1106	finally
    //   503	532	1106	finally
    //   539	568	1106	finally
    //   575	587	1106	finally
    //   594	602	1106	finally
    //   609	617	1106	finally
    //   624	630	1106	finally
    //   644	651	1106	finally
    //   658	664	1106	finally
    //   671	678	1106	finally
    //   685	696	1106	finally
    //   703	711	1106	finally
    //   718	724	1106	finally
    //   731	742	1106	finally
    //   1019	1024	1106	finally
    //   1069	1077	1106	finally
    //   1084	1099	1106	finally
    //   1029	1034	1115	java/io/IOException
    //   1039	1044	1115	java/io/IOException
    //   961	966	1147	java/io/IOException
    //   970	974	1147	java/io/IOException
    //   932	956	1179	finally
    //   1186	1191	1217	java/io/IOException
    //   1195	1199	1217	java/io/IOException
    //   230	250	1249	finally
  }
  
  public static void a(a parama, b paramb)
  {
    AppMethodBeat.i(154584);
    o localo = new o();
    localo.aire = paramb;
    localo.airf = parama;
    localo.airg = 0;
    localo.airh = System.currentTimeMillis();
    localo.execute(new a[] { localo.airf });
    AppMethodBeat.o(154584);
  }
  
  protected final void onPreExecute() {}
  
  public static final class a
  {
    public boolean airj;
    public String mFilePath;
    public String mUrl;
  }
  
  public static final class b
  {
    public long airk;
    public long mTotalSize;
    public String mUrl;
  }
  
  public static final class c
  {
    public int airl;
    public int airm;
    public long cEh;
    public String mFilePath;
    public int mNetWorkType;
    public int mRetryTimes;
    public long mTotalSize;
    public String mUrl;
    public String rzc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.o
 * JD-Core Version:    0.7.0.1
 */