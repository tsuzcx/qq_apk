package com.tencent.xweb.xwalk.b;

import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Timer;
import java.util.TimerTask;
import org.xwalk.core.XWalkInitializer;

public final class l
  extends AsyncTask<a, b, c>
{
  private b aals = null;
  private a aalt = null;
  private int aalu = 0;
  private long aalv = 0L;
  private Timer mTimer = null;
  
  /* Error */
  private c a(a... paramVarArgs)
  {
    // Byte code:
    //   0: ldc 48
    //   2: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ifnonnull +10 -> 16
    //   9: ldc 48
    //   11: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   14: aconst_null
    //   15: areturn
    //   16: aload_1
    //   17: arraylength
    //   18: iconst_1
    //   19: if_icmpeq +10 -> 29
    //   22: ldc 48
    //   24: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aconst_null
    //   28: areturn
    //   29: aload_1
    //   30: iconst_0
    //   31: aaload
    //   32: astore 22
    //   34: aload 22
    //   36: ifnonnull +10 -> 46
    //   39: ldc 48
    //   41: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: aconst_null
    //   45: areturn
    //   46: aload_0
    //   47: getfield 32	com/tencent/xweb/xwalk/b/l:aals	Lcom/tencent/xweb/xwalk/b/b;
    //   50: ifnull +12 -> 62
    //   53: aload_0
    //   54: getfield 32	com/tencent/xweb/xwalk/b/l:aals	Lcom/tencent/xweb/xwalk/b/b;
    //   57: invokeinterface 62 1 0
    //   62: new 15	com/tencent/xweb/xwalk/b/l$c
    //   65: dup
    //   66: invokespecial 63	com/tencent/xweb/xwalk/b/l$c:<init>	()V
    //   69: astore 21
    //   71: aload 21
    //   73: aload 22
    //   75: getfield 67	com/tencent/xweb/xwalk/b/l$a:mUrl	Ljava/lang/String;
    //   78: putfield 68	com/tencent/xweb/xwalk/b/l$c:mUrl	Ljava/lang/String;
    //   81: aload 21
    //   83: aload 22
    //   85: getfield 71	com/tencent/xweb/xwalk/b/l$a:mFilePath	Ljava/lang/String;
    //   88: putfield 72	com/tencent/xweb/xwalk/b/l$c:mFilePath	Ljava/lang/String;
    //   91: aload 21
    //   93: iconst_0
    //   94: putfield 75	com/tencent/xweb/xwalk/b/l$c:aalz	I
    //   97: aload 21
    //   99: ldc 77
    //   101: putfield 80	com/tencent/xweb/xwalk/b/l$c:ovI	Ljava/lang/String;
    //   104: aload 21
    //   106: aload_0
    //   107: getfield 36	com/tencent/xweb/xwalk/b/l:aalu	I
    //   110: putfield 83	com/tencent/xweb/xwalk/b/l$c:mRetryTimes	I
    //   113: aload 21
    //   115: lconst_0
    //   116: putfield 86	com/tencent/xweb/xwalk/b/l$c:aKl	J
    //   119: aload 21
    //   121: lconst_0
    //   122: putfield 89	com/tencent/xweb/xwalk/b/l$c:mTotalSize	J
    //   125: aload 21
    //   127: iconst_0
    //   128: putfield 92	com/tencent/xweb/xwalk/b/l$c:aalA	I
    //   131: aload 21
    //   133: invokestatic 98	org/xwalk/core/XWalkEnvironment:getApplicationContext	()Landroid/content/Context;
    //   136: invokestatic 104	org/xwalk/core/NetworkUtil:getCurrentNetWorkStatus	(Landroid/content/Context;)I
    //   139: putfield 107	com/tencent/xweb/xwalk/b/l$c:mNetWorkType	I
    //   142: aload 22
    //   144: getfield 67	com/tencent/xweb/xwalk/b/l$a:mUrl	Ljava/lang/String;
    //   147: ifnull +40 -> 187
    //   150: aload 22
    //   152: getfield 71	com/tencent/xweb/xwalk/b/l$a:mFilePath	Ljava/lang/String;
    //   155: ifnull +32 -> 187
    //   158: aload 22
    //   160: getfield 67	com/tencent/xweb/xwalk/b/l$a:mUrl	Ljava/lang/String;
    //   163: invokevirtual 113	java/lang/String:length	()I
    //   166: ifeq +21 -> 187
    //   169: aload 22
    //   171: getfield 71	com/tencent/xweb/xwalk/b/l$a:mFilePath	Ljava/lang/String;
    //   174: invokevirtual 113	java/lang/String:length	()I
    //   177: ifeq +10 -> 187
    //   180: aload_0
    //   181: getfield 32	com/tencent/xweb/xwalk/b/l:aals	Lcom/tencent/xweb/xwalk/b/b;
    //   184: ifnonnull +24 -> 208
    //   187: ldc 115
    //   189: invokestatic 121	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   192: aload 21
    //   194: sipush -10001
    //   197: putfield 75	com/tencent/xweb/xwalk/b/l$c:aalz	I
    //   200: ldc 48
    //   202: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   205: aload 21
    //   207: areturn
    //   208: aconst_null
    //   209: astore 16
    //   211: aconst_null
    //   212: astore 14
    //   214: aconst_null
    //   215: astore 12
    //   217: aconst_null
    //   218: astore 15
    //   220: aconst_null
    //   221: astore 17
    //   223: aconst_null
    //   224: astore_1
    //   225: aconst_null
    //   226: astore 18
    //   228: aconst_null
    //   229: astore 11
    //   231: aconst_null
    //   232: astore 19
    //   234: aconst_null
    //   235: astore 9
    //   237: aconst_null
    //   238: astore 10
    //   240: aconst_null
    //   241: astore 20
    //   243: new 123	java/net/URL
    //   246: dup
    //   247: aload 22
    //   249: getfield 67	com/tencent/xweb/xwalk/b/l$a:mUrl	Ljava/lang/String;
    //   252: invokespecial 125	java/net/URL:<init>	(Ljava/lang/String;)V
    //   255: invokevirtual 129	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   258: checkcast 131	java/net/HttpURLConnection
    //   261: astore 8
    //   263: aload 18
    //   265: astore 9
    //   267: aload 14
    //   269: astore 12
    //   271: aload 19
    //   273: astore 10
    //   275: aload 15
    //   277: astore 13
    //   279: aload 8
    //   281: ldc 133
    //   283: invokevirtual 136	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   286: aload 18
    //   288: astore 9
    //   290: aload 14
    //   292: astore 12
    //   294: aload 19
    //   296: astore 10
    //   298: aload 15
    //   300: astore 13
    //   302: new 138	java/lang/StringBuilder
    //   305: dup
    //   306: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   309: astore 11
    //   311: aload 18
    //   313: astore 9
    //   315: aload 14
    //   317: astore 12
    //   319: aload 19
    //   321: astore 10
    //   323: aload 15
    //   325: astore 13
    //   327: aload 11
    //   329: ldc 141
    //   331: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: pop
    //   335: aload 18
    //   337: astore 9
    //   339: aload 14
    //   341: astore 12
    //   343: aload 19
    //   345: astore 10
    //   347: aload 15
    //   349: astore 13
    //   351: aload 11
    //   353: new 138	java/lang/StringBuilder
    //   356: dup
    //   357: ldc 147
    //   359: invokespecial 148	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   362: invokestatic 151	org/xwalk/core/XWalkEnvironment:getInstalledNewstVersionForCurAbi	()I
    //   365: invokevirtual 154	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   368: ldc 156
    //   370: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   376: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: pop
    //   380: aload 18
    //   382: astore 9
    //   384: aload 14
    //   386: astore 12
    //   388: aload 19
    //   390: astore 10
    //   392: aload 15
    //   394: astore 13
    //   396: aload 11
    //   398: new 138	java/lang/StringBuilder
    //   401: dup
    //   402: ldc 162
    //   404: invokespecial 148	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   407: invokestatic 165	org/xwalk/core/XWalkEnvironment:getGrayValue	()I
    //   410: invokevirtual 154	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   413: ldc 156
    //   415: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   421: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: pop
    //   425: aload 18
    //   427: astore 9
    //   429: aload 14
    //   431: astore 12
    //   433: aload 19
    //   435: astore 10
    //   437: aload 15
    //   439: astore 13
    //   441: aload 11
    //   443: new 138	java/lang/StringBuilder
    //   446: dup
    //   447: ldc 167
    //   449: invokespecial 148	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   452: invokestatic 170	org/xwalk/core/XWalkEnvironment:getTodayGrayValue	()I
    //   455: invokevirtual 154	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   458: ldc 156
    //   460: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   466: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: pop
    //   470: aload 18
    //   472: astore 9
    //   474: aload 14
    //   476: astore 12
    //   478: aload 19
    //   480: astore 10
    //   482: aload 15
    //   484: astore 13
    //   486: aload 11
    //   488: new 138	java/lang/StringBuilder
    //   491: dup
    //   492: ldc 172
    //   494: invokespecial 148	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   497: invokestatic 175	org/xwalk/core/XWalkEnvironment:getUserId	()I
    //   500: invokevirtual 154	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   503: ldc 156
    //   505: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   511: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: pop
    //   515: aload 18
    //   517: astore 9
    //   519: aload 14
    //   521: astore 12
    //   523: aload 19
    //   525: astore 10
    //   527: aload 15
    //   529: astore 13
    //   531: aload 11
    //   533: new 138	java/lang/StringBuilder
    //   536: dup
    //   537: ldc 177
    //   539: invokespecial 148	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   542: invokestatic 180	org/xwalk/core/XWalkEnvironment:getRuntimeAbi	()Ljava/lang/String;
    //   545: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: ldc 156
    //   550: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   556: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   559: pop
    //   560: aload 18
    //   562: astore 9
    //   564: aload 14
    //   566: astore 12
    //   568: aload 19
    //   570: astore 10
    //   572: aload 15
    //   574: astore 13
    //   576: aload 11
    //   578: new 138	java/lang/StringBuilder
    //   581: dup
    //   582: ldc 182
    //   584: invokespecial 148	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   587: invokestatic 185	org/xwalk/core/XWalkEnvironment:dumpAppInfo	()Ljava/lang/String;
    //   590: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: ldc 187
    //   595: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   601: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: pop
    //   605: aload 18
    //   607: astore 9
    //   609: aload 14
    //   611: astore 12
    //   613: aload 19
    //   615: astore 10
    //   617: aload 15
    //   619: astore 13
    //   621: aload 11
    //   623: new 138	java/lang/StringBuilder
    //   626: dup
    //   627: ldc 189
    //   629: invokespecial 148	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   632: invokestatic 192	org/xwalk/core/XWalkEnvironment:getProcessName	()Ljava/lang/String;
    //   635: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: ldc 156
    //   640: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   643: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   646: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: pop
    //   650: aload 18
    //   652: astore 9
    //   654: aload 14
    //   656: astore 12
    //   658: aload 19
    //   660: astore 10
    //   662: aload 15
    //   664: astore 13
    //   666: aload 8
    //   668: ldc 194
    //   670: aload 11
    //   672: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   675: invokevirtual 198	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   678: aload 18
    //   680: astore 9
    //   682: aload 14
    //   684: astore 12
    //   686: aload 19
    //   688: astore 10
    //   690: aload 15
    //   692: astore 13
    //   694: aload 8
    //   696: sipush 8000
    //   699: invokevirtual 201	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   702: aload 18
    //   704: astore 9
    //   706: aload 14
    //   708: astore 12
    //   710: aload 19
    //   712: astore 10
    //   714: aload 15
    //   716: astore 13
    //   718: aload 8
    //   720: sipush 8000
    //   723: invokevirtual 204	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   726: aload 18
    //   728: astore 9
    //   730: aload 14
    //   732: astore 12
    //   734: aload 19
    //   736: astore 10
    //   738: aload 15
    //   740: astore 13
    //   742: aload 8
    //   744: invokevirtual 207	java/net/HttpURLConnection:getResponseCode	()I
    //   747: istore_2
    //   748: iload_2
    //   749: sipush 200
    //   752: if_icmpne +518 -> 1270
    //   755: aload 18
    //   757: astore 9
    //   759: aload 14
    //   761: astore 12
    //   763: aload 19
    //   765: astore 10
    //   767: aload 15
    //   769: astore 13
    //   771: aload 8
    //   773: invokevirtual 211	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   776: astore_1
    //   777: aload_1
    //   778: astore 9
    //   780: aload 14
    //   782: astore 12
    //   784: aload_1
    //   785: astore 10
    //   787: aload 15
    //   789: astore 13
    //   791: aload 8
    //   793: invokevirtual 214	java/net/HttpURLConnection:getContentLength	()I
    //   796: istore_2
    //   797: aload_1
    //   798: astore 9
    //   800: aload 14
    //   802: astore 12
    //   804: aload_1
    //   805: astore 10
    //   807: aload 15
    //   809: astore 13
    //   811: aload 22
    //   813: getfield 71	com/tencent/xweb/xwalk/b/l$a:mFilePath	Ljava/lang/String;
    //   816: astore 11
    //   818: aload_1
    //   819: astore 9
    //   821: aload 14
    //   823: astore 12
    //   825: aload_1
    //   826: astore 10
    //   828: aload 15
    //   830: astore 13
    //   832: new 216	java/io/File
    //   835: dup
    //   836: aload 11
    //   838: invokespecial 217	java/io/File:<init>	(Ljava/lang/String;)V
    //   841: astore 16
    //   843: aload_1
    //   844: astore 9
    //   846: aload 14
    //   848: astore 12
    //   850: aload_1
    //   851: astore 10
    //   853: aload 15
    //   855: astore 13
    //   857: aload 16
    //   859: invokevirtual 221	java/io/File:exists	()Z
    //   862: ifeq +23 -> 885
    //   865: aload_1
    //   866: astore 9
    //   868: aload 14
    //   870: astore 12
    //   872: aload_1
    //   873: astore 10
    //   875: aload 15
    //   877: astore 13
    //   879: aload 16
    //   881: invokevirtual 224	java/io/File:delete	()Z
    //   884: pop
    //   885: aload_1
    //   886: astore 9
    //   888: aload 14
    //   890: astore 12
    //   892: aload_1
    //   893: astore 10
    //   895: aload 15
    //   897: astore 13
    //   899: new 226	java/io/FileOutputStream
    //   902: dup
    //   903: aload 11
    //   905: invokespecial 227	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   908: astore 11
    //   910: sipush 4096
    //   913: newarray byte
    //   915: astore 9
    //   917: lconst_0
    //   918: lstore 4
    //   920: new 12	com/tencent/xweb/xwalk/b/l$b
    //   923: dup
    //   924: invokespecial 228	com/tencent/xweb/xwalk/b/l$b:<init>	()V
    //   927: astore 10
    //   929: aload 10
    //   931: aload 22
    //   933: getfield 67	com/tencent/xweb/xwalk/b/l$a:mUrl	Ljava/lang/String;
    //   936: putfield 229	com/tencent/xweb/xwalk/b/l$b:mUrl	Ljava/lang/String;
    //   939: aload 10
    //   941: iload_2
    //   942: i2l
    //   943: putfield 230	com/tencent/xweb/xwalk/b/l$b:mTotalSize	J
    //   946: aload_1
    //   947: aload 9
    //   949: invokevirtual 236	java/io/InputStream:read	([B)I
    //   952: istore_3
    //   953: iload_3
    //   954: iconst_m1
    //   955: if_icmpeq +240 -> 1195
    //   958: aload_0
    //   959: invokevirtual 239	com/tencent/xweb/xwalk/b/l:isCancelled	()Z
    //   962: ifeq +76 -> 1038
    //   965: aload_1
    //   966: invokevirtual 242	java/io/InputStream:close	()V
    //   969: aload 11
    //   971: invokevirtual 245	java/io/OutputStream:close	()V
    //   974: aload_1
    //   975: ifnull +7 -> 982
    //   978: aload_1
    //   979: invokevirtual 242	java/io/InputStream:close	()V
    //   982: aload 8
    //   984: ifnull +8 -> 992
    //   987: aload 8
    //   989: invokevirtual 248	java/net/HttpURLConnection:disconnect	()V
    //   992: ldc 48
    //   994: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   997: aconst_null
    //   998: areturn
    //   999: astore_1
    //   1000: new 138	java/lang/StringBuilder
    //   1003: dup
    //   1004: ldc 250
    //   1006: invokespecial 148	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1009: aload_1
    //   1010: invokevirtual 251	java/io/IOException:toString	()Ljava/lang/String;
    //   1013: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1016: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1019: invokestatic 121	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   1022: aload 21
    //   1024: sipush -10003
    //   1027: putfield 75	com/tencent/xweb/xwalk/b/l$c:aalz	I
    //   1030: ldc 48
    //   1032: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1035: aload 21
    //   1037: areturn
    //   1038: lload 4
    //   1040: iload_3
    //   1041: i2l
    //   1042: ladd
    //   1043: lstore 6
    //   1045: aload 11
    //   1047: aload 9
    //   1049: iconst_0
    //   1050: iload_3
    //   1051: invokevirtual 255	java/io/OutputStream:write	([BII)V
    //   1054: aload 10
    //   1056: lload 6
    //   1058: putfield 258	com/tencent/xweb/xwalk/b/l$b:aaly	J
    //   1061: lload 6
    //   1063: lstore 4
    //   1065: iload_2
    //   1066: ifle -120 -> 946
    //   1069: aload_0
    //   1070: iconst_1
    //   1071: anewarray 12	com/tencent/xweb/xwalk/b/l$b
    //   1074: dup
    //   1075: iconst_0
    //   1076: aload 10
    //   1078: aastore
    //   1079: invokevirtual 262	com/tencent/xweb/xwalk/b/l:publishProgress	([Ljava/lang/Object;)V
    //   1082: lload 6
    //   1084: lstore 4
    //   1086: goto -140 -> 946
    //   1089: astore 13
    //   1091: aload 8
    //   1093: astore 10
    //   1095: aload 11
    //   1097: astore 8
    //   1099: aload_1
    //   1100: astore 9
    //   1102: aload 10
    //   1104: astore_1
    //   1105: aload_1
    //   1106: astore 10
    //   1108: aload 9
    //   1110: astore 11
    //   1112: aload 8
    //   1114: astore 12
    //   1116: new 138	java/lang/StringBuilder
    //   1119: dup
    //   1120: ldc_w 264
    //   1123: invokespecial 148	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1126: aload 13
    //   1128: invokevirtual 265	java/lang/Exception:toString	()Ljava/lang/String;
    //   1131: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1134: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1137: invokestatic 121	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   1140: aload_1
    //   1141: astore 10
    //   1143: aload 9
    //   1145: astore 11
    //   1147: aload 8
    //   1149: astore 12
    //   1151: aload 21
    //   1153: sipush -10002
    //   1156: putfield 75	com/tencent/xweb/xwalk/b/l$c:aalz	I
    //   1159: aload 8
    //   1161: ifnull +8 -> 1169
    //   1164: aload 8
    //   1166: invokevirtual 245	java/io/OutputStream:close	()V
    //   1169: aload 9
    //   1171: ifnull +8 -> 1179
    //   1174: aload 9
    //   1176: invokevirtual 242	java/io/InputStream:close	()V
    //   1179: aload_1
    //   1180: ifnull +7 -> 1187
    //   1183: aload_1
    //   1184: invokevirtual 248	java/net/HttpURLConnection:disconnect	()V
    //   1187: ldc 48
    //   1189: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1192: aload 21
    //   1194: areturn
    //   1195: aload 21
    //   1197: lload 4
    //   1199: putfield 89	com/tencent/xweb/xwalk/b/l$c:mTotalSize	J
    //   1202: aload 21
    //   1204: invokestatic 271	java/lang/System:currentTimeMillis	()J
    //   1207: aload_0
    //   1208: getfield 40	com/tencent/xweb/xwalk/b/l:aalv	J
    //   1211: lsub
    //   1212: putfield 86	com/tencent/xweb/xwalk/b/l$c:aKl	J
    //   1215: aload_1
    //   1216: astore 9
    //   1218: aload 11
    //   1220: astore 12
    //   1222: aload_1
    //   1223: astore 10
    //   1225: aload 11
    //   1227: astore 13
    //   1229: aload 8
    //   1231: invokevirtual 248	java/net/HttpURLConnection:disconnect	()V
    //   1234: aload 11
    //   1236: ifnull +8 -> 1244
    //   1239: aload 11
    //   1241: invokevirtual 245	java/io/OutputStream:close	()V
    //   1244: aload_1
    //   1245: ifnull +7 -> 1252
    //   1248: aload_1
    //   1249: invokevirtual 242	java/io/InputStream:close	()V
    //   1252: aload 8
    //   1254: ifnull +8 -> 1262
    //   1257: aload 8
    //   1259: invokevirtual 248	java/net/HttpURLConnection:disconnect	()V
    //   1262: ldc 48
    //   1264: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1267: aload 21
    //   1269: areturn
    //   1270: aload 18
    //   1272: astore 9
    //   1274: aload 14
    //   1276: astore 12
    //   1278: aload 19
    //   1280: astore 10
    //   1282: aload 15
    //   1284: astore 13
    //   1286: aload 21
    //   1288: sipush -10005
    //   1291: putfield 75	com/tencent/xweb/xwalk/b/l$c:aalz	I
    //   1294: aload 18
    //   1296: astore 9
    //   1298: aload 14
    //   1300: astore 12
    //   1302: aload 19
    //   1304: astore 10
    //   1306: aload 15
    //   1308: astore 13
    //   1310: aload 21
    //   1312: ldc_w 273
    //   1315: iload_2
    //   1316: invokestatic 277	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1319: invokevirtual 281	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1322: putfield 80	com/tencent/xweb/xwalk/b/l$c:ovI	Ljava/lang/String;
    //   1325: aload 16
    //   1327: astore 11
    //   1329: goto -114 -> 1215
    //   1332: astore 13
    //   1334: aload 8
    //   1336: astore_1
    //   1337: aload 12
    //   1339: astore 8
    //   1341: goto -236 -> 1105
    //   1344: astore_1
    //   1345: new 138	java/lang/StringBuilder
    //   1348: dup
    //   1349: ldc 250
    //   1351: invokespecial 148	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1354: aload_1
    //   1355: invokevirtual 251	java/io/IOException:toString	()Ljava/lang/String;
    //   1358: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1361: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1364: invokestatic 121	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   1367: aload 21
    //   1369: sipush -10003
    //   1372: putfield 75	com/tencent/xweb/xwalk/b/l$c:aalz	I
    //   1375: ldc 48
    //   1377: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1380: aload 21
    //   1382: areturn
    //   1383: astore_1
    //   1384: new 138	java/lang/StringBuilder
    //   1387: dup
    //   1388: ldc 250
    //   1390: invokespecial 148	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1393: aload_1
    //   1394: invokevirtual 251	java/io/IOException:toString	()Ljava/lang/String;
    //   1397: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1400: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1403: invokestatic 121	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   1406: aload 21
    //   1408: sipush -10003
    //   1411: putfield 75	com/tencent/xweb/xwalk/b/l$c:aalz	I
    //   1414: ldc 48
    //   1416: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1419: aload 21
    //   1421: areturn
    //   1422: astore 8
    //   1424: aload 11
    //   1426: astore_1
    //   1427: aload 10
    //   1429: astore 9
    //   1431: aload 12
    //   1433: ifnull +8 -> 1441
    //   1436: aload 12
    //   1438: invokevirtual 245	java/io/OutputStream:close	()V
    //   1441: aload_1
    //   1442: ifnull +7 -> 1449
    //   1445: aload_1
    //   1446: invokevirtual 242	java/io/InputStream:close	()V
    //   1449: aload 9
    //   1451: ifnull +8 -> 1459
    //   1454: aload 9
    //   1456: invokevirtual 248	java/net/HttpURLConnection:disconnect	()V
    //   1459: ldc 48
    //   1461: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1464: aload 8
    //   1466: athrow
    //   1467: astore_1
    //   1468: new 138	java/lang/StringBuilder
    //   1471: dup
    //   1472: ldc 250
    //   1474: invokespecial 148	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1477: aload_1
    //   1478: invokevirtual 251	java/io/IOException:toString	()Ljava/lang/String;
    //   1481: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1484: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1487: invokestatic 121	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   1490: aload 21
    //   1492: sipush -10003
    //   1495: putfield 75	com/tencent/xweb/xwalk/b/l$c:aalz	I
    //   1498: ldc 48
    //   1500: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1503: aload 21
    //   1505: areturn
    //   1506: astore_1
    //   1507: aload 8
    //   1509: astore 9
    //   1511: aload_1
    //   1512: astore 8
    //   1514: aload 10
    //   1516: astore_1
    //   1517: aload 13
    //   1519: astore 12
    //   1521: goto -90 -> 1431
    //   1524: astore 10
    //   1526: aload 8
    //   1528: astore 9
    //   1530: aload 10
    //   1532: astore 8
    //   1534: aload 11
    //   1536: astore 12
    //   1538: goto -107 -> 1431
    //   1541: astore 13
    //   1543: aload 20
    //   1545: astore_1
    //   1546: aload 17
    //   1548: astore 8
    //   1550: goto -445 -> 1105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1553	0	this	l
    //   0	1553	1	paramVarArgs	a[]
    //   747	569	2	i	int
    //   952	99	3	j	int
    //   918	280	4	l1	long
    //   1043	40	6	l2	long
    //   261	1079	8	localObject1	Object
    //   1422	86	8	localObject2	Object
    //   1512	37	8	localObject3	Object
    //   235	1294	9	localObject4	Object
    //   238	1277	10	localObject5	Object
    //   1524	7	10	localObject6	Object
    //   229	1306	11	localObject7	Object
    //   215	1322	12	localObject8	Object
    //   277	621	13	localObject9	Object
    //   1089	38	13	localException1	java.lang.Exception
    //   1227	82	13	localObject10	Object
    //   1332	186	13	localException2	java.lang.Exception
    //   1541	1	13	localException3	java.lang.Exception
    //   212	1087	14	localObject11	Object
    //   218	1089	15	localObject12	Object
    //   209	1117	16	localFile	java.io.File
    //   221	1326	17	localObject13	Object
    //   226	1069	18	localObject14	Object
    //   232	1071	19	localObject15	Object
    //   241	1303	20	localObject16	Object
    //   69	1435	21	localc	c
    //   32	900	22	locala	a
    // Exception table:
    //   from	to	target	type
    //   969	974	999	java/io/IOException
    //   978	982	999	java/io/IOException
    //   910	917	1089	java/lang/Exception
    //   920	946	1089	java/lang/Exception
    //   946	953	1089	java/lang/Exception
    //   958	969	1089	java/lang/Exception
    //   1045	1061	1089	java/lang/Exception
    //   1069	1082	1089	java/lang/Exception
    //   1195	1215	1089	java/lang/Exception
    //   279	286	1332	java/lang/Exception
    //   302	311	1332	java/lang/Exception
    //   327	335	1332	java/lang/Exception
    //   351	380	1332	java/lang/Exception
    //   396	425	1332	java/lang/Exception
    //   441	470	1332	java/lang/Exception
    //   486	515	1332	java/lang/Exception
    //   531	560	1332	java/lang/Exception
    //   576	605	1332	java/lang/Exception
    //   621	650	1332	java/lang/Exception
    //   666	678	1332	java/lang/Exception
    //   694	702	1332	java/lang/Exception
    //   718	726	1332	java/lang/Exception
    //   742	748	1332	java/lang/Exception
    //   771	777	1332	java/lang/Exception
    //   791	797	1332	java/lang/Exception
    //   811	818	1332	java/lang/Exception
    //   832	843	1332	java/lang/Exception
    //   857	865	1332	java/lang/Exception
    //   879	885	1332	java/lang/Exception
    //   899	910	1332	java/lang/Exception
    //   1229	1234	1332	java/lang/Exception
    //   1286	1294	1332	java/lang/Exception
    //   1310	1325	1332	java/lang/Exception
    //   1239	1244	1344	java/io/IOException
    //   1248	1252	1344	java/io/IOException
    //   1164	1169	1383	java/io/IOException
    //   1174	1179	1383	java/io/IOException
    //   243	263	1422	finally
    //   1116	1140	1422	finally
    //   1151	1159	1422	finally
    //   1436	1441	1467	java/io/IOException
    //   1445	1449	1467	java/io/IOException
    //   279	286	1506	finally
    //   302	311	1506	finally
    //   327	335	1506	finally
    //   351	380	1506	finally
    //   396	425	1506	finally
    //   441	470	1506	finally
    //   486	515	1506	finally
    //   531	560	1506	finally
    //   576	605	1506	finally
    //   621	650	1506	finally
    //   666	678	1506	finally
    //   694	702	1506	finally
    //   718	726	1506	finally
    //   742	748	1506	finally
    //   771	777	1506	finally
    //   791	797	1506	finally
    //   811	818	1506	finally
    //   832	843	1506	finally
    //   857	865	1506	finally
    //   879	885	1506	finally
    //   899	910	1506	finally
    //   1229	1234	1506	finally
    //   1286	1294	1506	finally
    //   1310	1325	1506	finally
    //   910	917	1524	finally
    //   920	946	1524	finally
    //   946	953	1524	finally
    //   958	969	1524	finally
    //   1045	1061	1524	finally
    //   1069	1082	1524	finally
    //   1195	1215	1524	finally
    //   243	263	1541	java/lang/Exception
  }
  
  public static void a(a parama, b paramb)
  {
    AppMethodBeat.i(154584);
    l locall = new l();
    locall.aals = paramb;
    locall.aalt = parama;
    locall.aalu = 0;
    locall.aalv = System.currentTimeMillis();
    locall.execute(new a[] { locall.aalt });
    AppMethodBeat.o(154584);
  }
  
  protected final void onPreExecute() {}
  
  public static final class a
  {
    public boolean aalx;
    public String mFilePath;
    public String mUrl;
  }
  
  public static final class b
  {
    public long aaly;
    public long mTotalSize;
    public String mUrl;
  }
  
  public static final class c
  {
    public long aKl;
    public int aalA;
    public int aalz;
    public String mFilePath;
    public int mNetWorkType;
    public int mRetryTimes;
    public long mTotalSize;
    public String mUrl;
    public String ovI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.b.l
 * JD-Core Version:    0.7.0.1
 */