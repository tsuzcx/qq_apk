package com.tencent.xweb.xwalk.b;

import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Timer;

public final class g
  extends AsyncTask<g.a, g.b, g.c>
{
  private b BLm = null;
  private g.a BLn = null;
  private int BLo = 0;
  private long BLp = 0L;
  private Timer mTimer = null;
  
  /* Error */
  private g.c a(g.a... paramVarArgs)
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
    //   32: astore 22
    //   34: aload 22
    //   36: ifnonnull +10 -> 46
    //   39: ldc 46
    //   41: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: aconst_null
    //   45: areturn
    //   46: new 11	com/tencent/xweb/xwalk/b/g$c
    //   49: dup
    //   50: invokespecial 56	com/tencent/xweb/xwalk/b/g$c:<init>	()V
    //   53: astore 21
    //   55: aload 21
    //   57: aload 22
    //   59: getfield 60	com/tencent/xweb/xwalk/b/g$a:mUrl	Ljava/lang/String;
    //   62: putfield 61	com/tencent/xweb/xwalk/b/g$c:mUrl	Ljava/lang/String;
    //   65: aload 21
    //   67: aload 22
    //   69: getfield 64	com/tencent/xweb/xwalk/b/g$a:mFilePath	Ljava/lang/String;
    //   72: putfield 65	com/tencent/xweb/xwalk/b/g$c:mFilePath	Ljava/lang/String;
    //   75: aload 21
    //   77: iconst_0
    //   78: putfield 68	com/tencent/xweb/xwalk/b/g$c:BLt	I
    //   81: aload 21
    //   83: ldc 70
    //   85: putfield 73	com/tencent/xweb/xwalk/b/g$c:hyJ	Ljava/lang/String;
    //   88: aload 21
    //   90: aload_0
    //   91: getfield 33	com/tencent/xweb/xwalk/b/g:BLo	I
    //   94: putfield 76	com/tencent/xweb/xwalk/b/g$c:mRetryTimes	I
    //   97: aload 21
    //   99: lconst_0
    //   100: putfield 79	com/tencent/xweb/xwalk/b/g$c:BLu	J
    //   103: aload 21
    //   105: lconst_0
    //   106: putfield 82	com/tencent/xweb/xwalk/b/g$c:mTotalSize	J
    //   109: aload 21
    //   111: iconst_0
    //   112: putfield 85	com/tencent/xweb/xwalk/b/g$c:BLv	I
    //   115: aload 21
    //   117: invokestatic 91	org/xwalk/core/XWalkEnvironment:getApplicationContext	()Landroid/content/Context;
    //   120: invokestatic 97	org/xwalk/core/NetworkUtil:getCurrentNetWorkStatus	(Landroid/content/Context;)I
    //   123: putfield 100	com/tencent/xweb/xwalk/b/g$c:mNetWorkType	I
    //   126: aload 22
    //   128: getfield 60	com/tencent/xweb/xwalk/b/g$a:mUrl	Ljava/lang/String;
    //   131: ifnull +40 -> 171
    //   134: aload 22
    //   136: getfield 64	com/tencent/xweb/xwalk/b/g$a:mFilePath	Ljava/lang/String;
    //   139: ifnull +32 -> 171
    //   142: aload 22
    //   144: getfield 60	com/tencent/xweb/xwalk/b/g$a:mUrl	Ljava/lang/String;
    //   147: invokevirtual 106	java/lang/String:length	()I
    //   150: ifeq +21 -> 171
    //   153: aload 22
    //   155: getfield 64	com/tencent/xweb/xwalk/b/g$a:mFilePath	Ljava/lang/String;
    //   158: invokevirtual 106	java/lang/String:length	()I
    //   161: ifeq +10 -> 171
    //   164: aload_0
    //   165: getfield 29	com/tencent/xweb/xwalk/b/g:BLm	Lcom/tencent/xweb/xwalk/b/b;
    //   168: ifnonnull +24 -> 192
    //   171: ldc 108
    //   173: invokestatic 114	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   176: aload 21
    //   178: sipush -10001
    //   181: putfield 68	com/tencent/xweb/xwalk/b/g$c:BLt	I
    //   184: ldc 46
    //   186: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   189: aload 21
    //   191: areturn
    //   192: aconst_null
    //   193: astore 17
    //   195: aconst_null
    //   196: astore 14
    //   198: aconst_null
    //   199: astore 12
    //   201: aconst_null
    //   202: astore 15
    //   204: aconst_null
    //   205: astore 16
    //   207: aconst_null
    //   208: astore_1
    //   209: aconst_null
    //   210: astore 18
    //   212: aconst_null
    //   213: astore 11
    //   215: aconst_null
    //   216: astore 19
    //   218: aconst_null
    //   219: astore 9
    //   221: aconst_null
    //   222: astore 10
    //   224: aconst_null
    //   225: astore 20
    //   227: new 116	java/net/URL
    //   230: dup
    //   231: aload 22
    //   233: getfield 60	com/tencent/xweb/xwalk/b/g$a:mUrl	Ljava/lang/String;
    //   236: invokespecial 118	java/net/URL:<init>	(Ljava/lang/String;)V
    //   239: invokevirtual 122	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   242: checkcast 124	java/net/HttpURLConnection
    //   245: astore 8
    //   247: aload 18
    //   249: astore 9
    //   251: aload 14
    //   253: astore 12
    //   255: aload 19
    //   257: astore 10
    //   259: aload 15
    //   261: astore 13
    //   263: aload 8
    //   265: ldc 126
    //   267: invokevirtual 129	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   270: aload 18
    //   272: astore 9
    //   274: aload 14
    //   276: astore 12
    //   278: aload 19
    //   280: astore 10
    //   282: aload 15
    //   284: astore 13
    //   286: aload 22
    //   288: getfield 133	com/tencent/xweb/xwalk/b/g$a:BLr	Z
    //   291: ifeq +54 -> 345
    //   294: aload 18
    //   296: astore 9
    //   298: aload 14
    //   300: astore 12
    //   302: aload 19
    //   304: astore 10
    //   306: aload 15
    //   308: astore 13
    //   310: aload 8
    //   312: instanceof 135
    //   315: ifeq +30 -> 345
    //   318: aload 18
    //   320: astore 9
    //   322: aload 14
    //   324: astore 12
    //   326: aload 19
    //   328: astore 10
    //   330: aload 15
    //   332: astore 13
    //   334: aload 8
    //   336: checkcast 135	javax/net/ssl/HttpsURLConnection
    //   339: getstatic 139	com/tencent/xweb/xwalk/b/g$d:BLw	Ljavax/net/ssl/HostnameVerifier;
    //   342: invokevirtual 143	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
    //   345: aload 18
    //   347: astore 9
    //   349: aload 14
    //   351: astore 12
    //   353: aload 19
    //   355: astore 10
    //   357: aload 15
    //   359: astore 13
    //   361: aload 8
    //   363: sipush 8000
    //   366: invokevirtual 146	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   369: aload 18
    //   371: astore 9
    //   373: aload 14
    //   375: astore 12
    //   377: aload 19
    //   379: astore 10
    //   381: aload 15
    //   383: astore 13
    //   385: aload 8
    //   387: sipush 8000
    //   390: invokevirtual 149	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   393: aload 18
    //   395: astore 9
    //   397: aload 14
    //   399: astore 12
    //   401: aload 19
    //   403: astore 10
    //   405: aload 15
    //   407: astore 13
    //   409: aload 8
    //   411: invokevirtual 152	java/net/HttpURLConnection:getResponseCode	()I
    //   414: istore_2
    //   415: iload_2
    //   416: sipush 200
    //   419: if_icmpne +517 -> 936
    //   422: aload 18
    //   424: astore 9
    //   426: aload 14
    //   428: astore 12
    //   430: aload 19
    //   432: astore 10
    //   434: aload 15
    //   436: astore 13
    //   438: aload 8
    //   440: invokevirtual 156	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   443: astore_1
    //   444: aload_1
    //   445: astore 9
    //   447: aload 14
    //   449: astore 12
    //   451: aload_1
    //   452: astore 10
    //   454: aload 15
    //   456: astore 13
    //   458: aload 8
    //   460: invokevirtual 159	java/net/HttpURLConnection:getContentLength	()I
    //   463: istore_2
    //   464: aload_1
    //   465: astore 9
    //   467: aload 14
    //   469: astore 12
    //   471: aload_1
    //   472: astore 10
    //   474: aload 15
    //   476: astore 13
    //   478: aload 22
    //   480: getfield 64	com/tencent/xweb/xwalk/b/g$a:mFilePath	Ljava/lang/String;
    //   483: astore 11
    //   485: aload_1
    //   486: astore 9
    //   488: aload 14
    //   490: astore 12
    //   492: aload_1
    //   493: astore 10
    //   495: aload 15
    //   497: astore 13
    //   499: new 161	java/io/File
    //   502: dup
    //   503: aload 11
    //   505: invokespecial 162	java/io/File:<init>	(Ljava/lang/String;)V
    //   508: astore 16
    //   510: aload_1
    //   511: astore 9
    //   513: aload 14
    //   515: astore 12
    //   517: aload_1
    //   518: astore 10
    //   520: aload 15
    //   522: astore 13
    //   524: aload 16
    //   526: invokevirtual 166	java/io/File:exists	()Z
    //   529: ifeq +23 -> 552
    //   532: aload_1
    //   533: astore 9
    //   535: aload 14
    //   537: astore 12
    //   539: aload_1
    //   540: astore 10
    //   542: aload 15
    //   544: astore 13
    //   546: aload 16
    //   548: invokevirtual 169	java/io/File:delete	()Z
    //   551: pop
    //   552: aload_1
    //   553: astore 9
    //   555: aload 14
    //   557: astore 12
    //   559: aload_1
    //   560: astore 10
    //   562: aload 15
    //   564: astore 13
    //   566: new 171	java/io/FileOutputStream
    //   569: dup
    //   570: aload 11
    //   572: invokespecial 172	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   575: astore 11
    //   577: sipush 4096
    //   580: newarray byte
    //   582: astore 9
    //   584: lconst_0
    //   585: lstore 4
    //   587: new 9	com/tencent/xweb/xwalk/b/g$b
    //   590: dup
    //   591: invokespecial 173	com/tencent/xweb/xwalk/b/g$b:<init>	()V
    //   594: astore 10
    //   596: aload 10
    //   598: aload 22
    //   600: getfield 60	com/tencent/xweb/xwalk/b/g$a:mUrl	Ljava/lang/String;
    //   603: putfield 174	com/tencent/xweb/xwalk/b/g$b:mUrl	Ljava/lang/String;
    //   606: aload 10
    //   608: iload_2
    //   609: i2l
    //   610: putfield 175	com/tencent/xweb/xwalk/b/g$b:mTotalSize	J
    //   613: aload_1
    //   614: aload 9
    //   616: invokevirtual 181	java/io/InputStream:read	([B)I
    //   619: istore_3
    //   620: iload_3
    //   621: iconst_m1
    //   622: if_icmpeq +239 -> 861
    //   625: aload_0
    //   626: invokevirtual 184	com/tencent/xweb/xwalk/b/g:isCancelled	()Z
    //   629: ifeq +76 -> 705
    //   632: aload_1
    //   633: invokevirtual 187	java/io/InputStream:close	()V
    //   636: aload 11
    //   638: invokevirtual 190	java/io/OutputStream:close	()V
    //   641: aload_1
    //   642: ifnull +7 -> 649
    //   645: aload_1
    //   646: invokevirtual 187	java/io/InputStream:close	()V
    //   649: aload 8
    //   651: ifnull +8 -> 659
    //   654: aload 8
    //   656: invokevirtual 193	java/net/HttpURLConnection:disconnect	()V
    //   659: ldc 46
    //   661: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   664: aconst_null
    //   665: areturn
    //   666: astore_1
    //   667: new 195	java/lang/StringBuilder
    //   670: dup
    //   671: ldc 197
    //   673: invokespecial 198	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   676: aload_1
    //   677: invokevirtual 202	java/io/IOException:toString	()Ljava/lang/String;
    //   680: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   683: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   686: invokestatic 114	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   689: aload 21
    //   691: sipush -10003
    //   694: putfield 68	com/tencent/xweb/xwalk/b/g$c:BLt	I
    //   697: ldc 46
    //   699: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   702: aload 21
    //   704: areturn
    //   705: lload 4
    //   707: iload_3
    //   708: i2l
    //   709: ladd
    //   710: lstore 6
    //   712: aload 11
    //   714: aload 9
    //   716: iconst_0
    //   717: iload_3
    //   718: invokevirtual 211	java/io/OutputStream:write	([BII)V
    //   721: aload 10
    //   723: lload 6
    //   725: putfield 214	com/tencent/xweb/xwalk/b/g$b:BLs	J
    //   728: lload 6
    //   730: lstore 4
    //   732: iload_2
    //   733: ifle -120 -> 613
    //   736: aload_0
    //   737: iconst_1
    //   738: anewarray 9	com/tencent/xweb/xwalk/b/g$b
    //   741: dup
    //   742: iconst_0
    //   743: aload 10
    //   745: aastore
    //   746: invokevirtual 218	com/tencent/xweb/xwalk/b/g:publishProgress	([Ljava/lang/Object;)V
    //   749: lload 6
    //   751: lstore 4
    //   753: goto -140 -> 613
    //   756: astore 13
    //   758: aload 8
    //   760: astore 10
    //   762: aload 11
    //   764: astore 8
    //   766: aload_1
    //   767: astore 9
    //   769: aload 10
    //   771: astore_1
    //   772: aload_1
    //   773: astore 10
    //   775: aload 9
    //   777: astore 11
    //   779: aload 8
    //   781: astore 12
    //   783: new 195	java/lang/StringBuilder
    //   786: dup
    //   787: ldc 220
    //   789: invokespecial 198	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   792: aload 13
    //   794: invokevirtual 221	java/lang/Exception:toString	()Ljava/lang/String;
    //   797: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   800: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   803: invokestatic 114	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   806: aload_1
    //   807: astore 10
    //   809: aload 9
    //   811: astore 11
    //   813: aload 8
    //   815: astore 12
    //   817: aload 21
    //   819: sipush -10002
    //   822: putfield 68	com/tencent/xweb/xwalk/b/g$c:BLt	I
    //   825: aload 8
    //   827: ifnull +8 -> 835
    //   830: aload 8
    //   832: invokevirtual 190	java/io/OutputStream:close	()V
    //   835: aload 9
    //   837: ifnull +8 -> 845
    //   840: aload 9
    //   842: invokevirtual 187	java/io/InputStream:close	()V
    //   845: aload_1
    //   846: ifnull +7 -> 853
    //   849: aload_1
    //   850: invokevirtual 193	java/net/HttpURLConnection:disconnect	()V
    //   853: ldc 46
    //   855: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   858: aload 21
    //   860: areturn
    //   861: aload 21
    //   863: lload 4
    //   865: putfield 82	com/tencent/xweb/xwalk/b/g$c:mTotalSize	J
    //   868: aload 21
    //   870: invokestatic 227	java/lang/System:currentTimeMillis	()J
    //   873: aload_0
    //   874: getfield 37	com/tencent/xweb/xwalk/b/g:BLp	J
    //   877: lsub
    //   878: putfield 79	com/tencent/xweb/xwalk/b/g$c:BLu	J
    //   881: aload_1
    //   882: astore 9
    //   884: aload 11
    //   886: astore 12
    //   888: aload_1
    //   889: astore 10
    //   891: aload 11
    //   893: astore 13
    //   895: aload 8
    //   897: invokevirtual 193	java/net/HttpURLConnection:disconnect	()V
    //   900: aload 11
    //   902: ifnull +8 -> 910
    //   905: aload 11
    //   907: invokevirtual 190	java/io/OutputStream:close	()V
    //   910: aload_1
    //   911: ifnull +7 -> 918
    //   914: aload_1
    //   915: invokevirtual 187	java/io/InputStream:close	()V
    //   918: aload 8
    //   920: ifnull +8 -> 928
    //   923: aload 8
    //   925: invokevirtual 193	java/net/HttpURLConnection:disconnect	()V
    //   928: ldc 46
    //   930: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   933: aload 21
    //   935: areturn
    //   936: aload 18
    //   938: astore 9
    //   940: aload 14
    //   942: astore 12
    //   944: aload 19
    //   946: astore 10
    //   948: aload 15
    //   950: astore 13
    //   952: aload 21
    //   954: sipush -10005
    //   957: putfield 68	com/tencent/xweb/xwalk/b/g$c:BLt	I
    //   960: aload 18
    //   962: astore 9
    //   964: aload 14
    //   966: astore 12
    //   968: aload 19
    //   970: astore 10
    //   972: aload 15
    //   974: astore 13
    //   976: aload 21
    //   978: ldc 229
    //   980: iload_2
    //   981: invokestatic 233	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   984: invokevirtual 237	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   987: putfield 73	com/tencent/xweb/xwalk/b/g$c:hyJ	Ljava/lang/String;
    //   990: aload 17
    //   992: astore 11
    //   994: goto -113 -> 881
    //   997: astore 13
    //   999: aload 8
    //   1001: astore_1
    //   1002: aload 12
    //   1004: astore 8
    //   1006: goto -234 -> 772
    //   1009: astore_1
    //   1010: new 195	java/lang/StringBuilder
    //   1013: dup
    //   1014: ldc 197
    //   1016: invokespecial 198	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1019: aload_1
    //   1020: invokevirtual 202	java/io/IOException:toString	()Ljava/lang/String;
    //   1023: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1026: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1029: invokestatic 114	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   1032: aload 21
    //   1034: sipush -10003
    //   1037: putfield 68	com/tencent/xweb/xwalk/b/g$c:BLt	I
    //   1040: ldc 46
    //   1042: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1045: aload 21
    //   1047: areturn
    //   1048: astore_1
    //   1049: new 195	java/lang/StringBuilder
    //   1052: dup
    //   1053: ldc 197
    //   1055: invokespecial 198	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1058: aload_1
    //   1059: invokevirtual 202	java/io/IOException:toString	()Ljava/lang/String;
    //   1062: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1065: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1068: invokestatic 114	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   1071: aload 21
    //   1073: sipush -10003
    //   1076: putfield 68	com/tencent/xweb/xwalk/b/g$c:BLt	I
    //   1079: ldc 46
    //   1081: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1084: aload 21
    //   1086: areturn
    //   1087: astore 8
    //   1089: aload 11
    //   1091: astore_1
    //   1092: aload 10
    //   1094: astore 9
    //   1096: aload 12
    //   1098: ifnull +8 -> 1106
    //   1101: aload 12
    //   1103: invokevirtual 190	java/io/OutputStream:close	()V
    //   1106: aload_1
    //   1107: ifnull +7 -> 1114
    //   1110: aload_1
    //   1111: invokevirtual 187	java/io/InputStream:close	()V
    //   1114: aload 9
    //   1116: ifnull +8 -> 1124
    //   1119: aload 9
    //   1121: invokevirtual 193	java/net/HttpURLConnection:disconnect	()V
    //   1124: ldc 46
    //   1126: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1129: aload 8
    //   1131: athrow
    //   1132: astore_1
    //   1133: new 195	java/lang/StringBuilder
    //   1136: dup
    //   1137: ldc 197
    //   1139: invokespecial 198	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1142: aload_1
    //   1143: invokevirtual 202	java/io/IOException:toString	()Ljava/lang/String;
    //   1146: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1149: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1152: invokestatic 114	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   1155: aload 21
    //   1157: sipush -10003
    //   1160: putfield 68	com/tencent/xweb/xwalk/b/g$c:BLt	I
    //   1163: ldc 46
    //   1165: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1168: aload 21
    //   1170: areturn
    //   1171: astore_1
    //   1172: aload 8
    //   1174: astore 9
    //   1176: aload_1
    //   1177: astore 8
    //   1179: aload 10
    //   1181: astore_1
    //   1182: aload 13
    //   1184: astore 12
    //   1186: goto -90 -> 1096
    //   1189: astore 10
    //   1191: aload 8
    //   1193: astore 9
    //   1195: aload 10
    //   1197: astore 8
    //   1199: aload 11
    //   1201: astore 12
    //   1203: goto -107 -> 1096
    //   1206: astore 13
    //   1208: aload 20
    //   1210: astore_1
    //   1211: aload 16
    //   1213: astore 8
    //   1215: goto -443 -> 772
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1218	0	this	g
    //   0	1218	1	paramVarArgs	g.a[]
    //   414	567	2	i	int
    //   619	99	3	j	int
    //   585	279	4	l1	long
    //   710	40	6	l2	long
    //   245	760	8	localObject1	java.lang.Object
    //   1087	86	8	localObject2	java.lang.Object
    //   1177	37	8	localObject3	java.lang.Object
    //   219	975	9	localObject4	java.lang.Object
    //   222	958	10	localObject5	java.lang.Object
    //   1189	7	10	localObject6	java.lang.Object
    //   213	987	11	localObject7	java.lang.Object
    //   199	1003	12	localObject8	java.lang.Object
    //   261	304	13	localObject9	java.lang.Object
    //   756	37	13	localException1	java.lang.Exception
    //   893	82	13	localObject10	java.lang.Object
    //   997	186	13	localException2	java.lang.Exception
    //   1206	1	13	localException3	java.lang.Exception
    //   196	769	14	localObject11	java.lang.Object
    //   202	771	15	localObject12	java.lang.Object
    //   205	1007	16	localFile	java.io.File
    //   193	798	17	localObject13	java.lang.Object
    //   210	751	18	localObject14	java.lang.Object
    //   216	753	19	localObject15	java.lang.Object
    //   225	984	20	localObject16	java.lang.Object
    //   53	1116	21	localc	g.c
    //   32	567	22	locala	g.a
    // Exception table:
    //   from	to	target	type
    //   636	641	666	java/io/IOException
    //   645	649	666	java/io/IOException
    //   577	584	756	java/lang/Exception
    //   587	613	756	java/lang/Exception
    //   613	620	756	java/lang/Exception
    //   625	636	756	java/lang/Exception
    //   712	728	756	java/lang/Exception
    //   736	749	756	java/lang/Exception
    //   861	881	756	java/lang/Exception
    //   263	270	997	java/lang/Exception
    //   286	294	997	java/lang/Exception
    //   310	318	997	java/lang/Exception
    //   334	345	997	java/lang/Exception
    //   361	369	997	java/lang/Exception
    //   385	393	997	java/lang/Exception
    //   409	415	997	java/lang/Exception
    //   438	444	997	java/lang/Exception
    //   458	464	997	java/lang/Exception
    //   478	485	997	java/lang/Exception
    //   499	510	997	java/lang/Exception
    //   524	532	997	java/lang/Exception
    //   546	552	997	java/lang/Exception
    //   566	577	997	java/lang/Exception
    //   895	900	997	java/lang/Exception
    //   952	960	997	java/lang/Exception
    //   976	990	997	java/lang/Exception
    //   905	910	1009	java/io/IOException
    //   914	918	1009	java/io/IOException
    //   830	835	1048	java/io/IOException
    //   840	845	1048	java/io/IOException
    //   227	247	1087	finally
    //   783	806	1087	finally
    //   817	825	1087	finally
    //   1101	1106	1132	java/io/IOException
    //   1110	1114	1132	java/io/IOException
    //   263	270	1171	finally
    //   286	294	1171	finally
    //   310	318	1171	finally
    //   334	345	1171	finally
    //   361	369	1171	finally
    //   385	393	1171	finally
    //   409	415	1171	finally
    //   438	444	1171	finally
    //   458	464	1171	finally
    //   478	485	1171	finally
    //   499	510	1171	finally
    //   524	532	1171	finally
    //   546	552	1171	finally
    //   566	577	1171	finally
    //   895	900	1171	finally
    //   952	960	1171	finally
    //   976	990	1171	finally
    //   577	584	1189	finally
    //   587	613	1189	finally
    //   613	620	1189	finally
    //   625	636	1189	finally
    //   712	728	1189	finally
    //   736	749	1189	finally
    //   861	881	1189	finally
    //   227	247	1206	java/lang/Exception
  }
  
  public static void a(g.a parama, b paramb)
  {
    AppMethodBeat.i(85494);
    g localg = new g();
    localg.BLm = paramb;
    localg.BLn = parama;
    localg.BLo = 0;
    localg.BLp = System.currentTimeMillis();
    localg.execute(new g.a[] { localg.BLn });
    AppMethodBeat.o(85494);
  }
  
  protected final void onPreExecute() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.xwalk.b.g
 * JD-Core Version:    0.7.0.1
 */