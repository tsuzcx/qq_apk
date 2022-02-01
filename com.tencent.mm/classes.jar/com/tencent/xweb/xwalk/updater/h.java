package com.tencent.xweb.xwalk.updater;

import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Timer;
import java.util.TimerTask;
import org.xwalk.core.XWalkInitializer;

public final class h
  extends AsyncTask<a, b, c>
{
  private b KIF = null;
  private a KIG = null;
  private int KIH = 0;
  private long KII = 0L;
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
    //   47: getfield 32	com/tencent/xweb/xwalk/updater/h:KIF	Lcom/tencent/xweb/xwalk/updater/b;
    //   50: ifnull +12 -> 62
    //   53: aload_0
    //   54: getfield 32	com/tencent/xweb/xwalk/updater/h:KIF	Lcom/tencent/xweb/xwalk/updater/b;
    //   57: invokeinterface 62 1 0
    //   62: new 15	com/tencent/xweb/xwalk/updater/h$c
    //   65: dup
    //   66: invokespecial 63	com/tencent/xweb/xwalk/updater/h$c:<init>	()V
    //   69: astore 21
    //   71: aload 21
    //   73: aload 22
    //   75: getfield 67	com/tencent/xweb/xwalk/updater/h$a:mUrl	Ljava/lang/String;
    //   78: putfield 68	com/tencent/xweb/xwalk/updater/h$c:mUrl	Ljava/lang/String;
    //   81: aload 21
    //   83: aload 22
    //   85: getfield 71	com/tencent/xweb/xwalk/updater/h$a:mFilePath	Ljava/lang/String;
    //   88: putfield 72	com/tencent/xweb/xwalk/updater/h$c:mFilePath	Ljava/lang/String;
    //   91: aload 21
    //   93: iconst_0
    //   94: putfield 75	com/tencent/xweb/xwalk/updater/h$c:KIM	I
    //   97: aload 21
    //   99: ldc 77
    //   101: putfield 80	com/tencent/xweb/xwalk/updater/h$c:jYB	Ljava/lang/String;
    //   104: aload 21
    //   106: aload_0
    //   107: getfield 36	com/tencent/xweb/xwalk/updater/h:KIH	I
    //   110: putfield 83	com/tencent/xweb/xwalk/updater/h$c:mRetryTimes	I
    //   113: aload 21
    //   115: lconst_0
    //   116: putfield 86	com/tencent/xweb/xwalk/updater/h$c:aQx	J
    //   119: aload 21
    //   121: lconst_0
    //   122: putfield 89	com/tencent/xweb/xwalk/updater/h$c:mTotalSize	J
    //   125: aload 21
    //   127: iconst_0
    //   128: putfield 92	com/tencent/xweb/xwalk/updater/h$c:KIN	I
    //   131: aload 21
    //   133: invokestatic 98	org/xwalk/core/XWalkEnvironment:getApplicationContext	()Landroid/content/Context;
    //   136: invokestatic 104	org/xwalk/core/NetworkUtil:getCurrentNetWorkStatus	(Landroid/content/Context;)I
    //   139: putfield 107	com/tencent/xweb/xwalk/updater/h$c:mNetWorkType	I
    //   142: aload 22
    //   144: getfield 67	com/tencent/xweb/xwalk/updater/h$a:mUrl	Ljava/lang/String;
    //   147: ifnull +40 -> 187
    //   150: aload 22
    //   152: getfield 71	com/tencent/xweb/xwalk/updater/h$a:mFilePath	Ljava/lang/String;
    //   155: ifnull +32 -> 187
    //   158: aload 22
    //   160: getfield 67	com/tencent/xweb/xwalk/updater/h$a:mUrl	Ljava/lang/String;
    //   163: invokevirtual 113	java/lang/String:length	()I
    //   166: ifeq +21 -> 187
    //   169: aload 22
    //   171: getfield 71	com/tencent/xweb/xwalk/updater/h$a:mFilePath	Ljava/lang/String;
    //   174: invokevirtual 113	java/lang/String:length	()I
    //   177: ifeq +10 -> 187
    //   180: aload_0
    //   181: getfield 32	com/tencent/xweb/xwalk/updater/h:KIF	Lcom/tencent/xweb/xwalk/updater/b;
    //   184: ifnonnull +24 -> 208
    //   187: ldc 115
    //   189: invokestatic 121	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   192: aload 21
    //   194: sipush -10001
    //   197: putfield 75	com/tencent/xweb/xwalk/updater/h$c:KIM	I
    //   200: ldc 48
    //   202: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   205: aload 21
    //   207: areturn
    //   208: aconst_null
    //   209: astore 17
    //   211: aconst_null
    //   212: astore 14
    //   214: aconst_null
    //   215: astore 12
    //   217: aconst_null
    //   218: astore 15
    //   220: aconst_null
    //   221: astore 16
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
    //   249: getfield 67	com/tencent/xweb/xwalk/updater/h$a:mUrl	Ljava/lang/String;
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
    //   302: aload 8
    //   304: sipush 8000
    //   307: invokevirtual 139	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   310: aload 18
    //   312: astore 9
    //   314: aload 14
    //   316: astore 12
    //   318: aload 19
    //   320: astore 10
    //   322: aload 15
    //   324: astore 13
    //   326: aload 8
    //   328: sipush 8000
    //   331: invokevirtual 142	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   334: aload 18
    //   336: astore 9
    //   338: aload 14
    //   340: astore 12
    //   342: aload 19
    //   344: astore 10
    //   346: aload 15
    //   348: astore 13
    //   350: aload 8
    //   352: invokevirtual 145	java/net/HttpURLConnection:getResponseCode	()I
    //   355: istore_2
    //   356: iload_2
    //   357: sipush 200
    //   360: if_icmpne +517 -> 877
    //   363: aload 18
    //   365: astore 9
    //   367: aload 14
    //   369: astore 12
    //   371: aload 19
    //   373: astore 10
    //   375: aload 15
    //   377: astore 13
    //   379: aload 8
    //   381: invokevirtual 149	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   384: astore_1
    //   385: aload_1
    //   386: astore 9
    //   388: aload 14
    //   390: astore 12
    //   392: aload_1
    //   393: astore 10
    //   395: aload 15
    //   397: astore 13
    //   399: aload 8
    //   401: invokevirtual 152	java/net/HttpURLConnection:getContentLength	()I
    //   404: istore_2
    //   405: aload_1
    //   406: astore 9
    //   408: aload 14
    //   410: astore 12
    //   412: aload_1
    //   413: astore 10
    //   415: aload 15
    //   417: astore 13
    //   419: aload 22
    //   421: getfield 71	com/tencent/xweb/xwalk/updater/h$a:mFilePath	Ljava/lang/String;
    //   424: astore 11
    //   426: aload_1
    //   427: astore 9
    //   429: aload 14
    //   431: astore 12
    //   433: aload_1
    //   434: astore 10
    //   436: aload 15
    //   438: astore 13
    //   440: new 154	java/io/File
    //   443: dup
    //   444: aload 11
    //   446: invokespecial 155	java/io/File:<init>	(Ljava/lang/String;)V
    //   449: astore 16
    //   451: aload_1
    //   452: astore 9
    //   454: aload 14
    //   456: astore 12
    //   458: aload_1
    //   459: astore 10
    //   461: aload 15
    //   463: astore 13
    //   465: aload 16
    //   467: invokevirtual 159	java/io/File:exists	()Z
    //   470: ifeq +23 -> 493
    //   473: aload_1
    //   474: astore 9
    //   476: aload 14
    //   478: astore 12
    //   480: aload_1
    //   481: astore 10
    //   483: aload 15
    //   485: astore 13
    //   487: aload 16
    //   489: invokevirtual 162	java/io/File:delete	()Z
    //   492: pop
    //   493: aload_1
    //   494: astore 9
    //   496: aload 14
    //   498: astore 12
    //   500: aload_1
    //   501: astore 10
    //   503: aload 15
    //   505: astore 13
    //   507: new 164	java/io/FileOutputStream
    //   510: dup
    //   511: aload 11
    //   513: invokespecial 165	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   516: astore 11
    //   518: sipush 4096
    //   521: newarray byte
    //   523: astore 9
    //   525: lconst_0
    //   526: lstore 4
    //   528: new 12	com/tencent/xweb/xwalk/updater/h$b
    //   531: dup
    //   532: invokespecial 166	com/tencent/xweb/xwalk/updater/h$b:<init>	()V
    //   535: astore 10
    //   537: aload 10
    //   539: aload 22
    //   541: getfield 67	com/tencent/xweb/xwalk/updater/h$a:mUrl	Ljava/lang/String;
    //   544: putfield 167	com/tencent/xweb/xwalk/updater/h$b:mUrl	Ljava/lang/String;
    //   547: aload 10
    //   549: iload_2
    //   550: i2l
    //   551: putfield 168	com/tencent/xweb/xwalk/updater/h$b:mTotalSize	J
    //   554: aload_1
    //   555: aload 9
    //   557: invokevirtual 174	java/io/InputStream:read	([B)I
    //   560: istore_3
    //   561: iload_3
    //   562: iconst_m1
    //   563: if_icmpeq +239 -> 802
    //   566: aload_0
    //   567: invokevirtual 177	com/tencent/xweb/xwalk/updater/h:isCancelled	()Z
    //   570: ifeq +76 -> 646
    //   573: aload_1
    //   574: invokevirtual 180	java/io/InputStream:close	()V
    //   577: aload 11
    //   579: invokevirtual 183	java/io/OutputStream:close	()V
    //   582: aload_1
    //   583: ifnull +7 -> 590
    //   586: aload_1
    //   587: invokevirtual 180	java/io/InputStream:close	()V
    //   590: aload 8
    //   592: ifnull +8 -> 600
    //   595: aload 8
    //   597: invokevirtual 186	java/net/HttpURLConnection:disconnect	()V
    //   600: ldc 48
    //   602: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   605: aconst_null
    //   606: areturn
    //   607: astore_1
    //   608: new 188	java/lang/StringBuilder
    //   611: dup
    //   612: ldc 190
    //   614: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   617: aload_1
    //   618: invokevirtual 195	java/io/IOException:toString	()Ljava/lang/String;
    //   621: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   627: invokestatic 121	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   630: aload 21
    //   632: sipush -10003
    //   635: putfield 75	com/tencent/xweb/xwalk/updater/h$c:KIM	I
    //   638: ldc 48
    //   640: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   643: aload 21
    //   645: areturn
    //   646: lload 4
    //   648: iload_3
    //   649: i2l
    //   650: ladd
    //   651: lstore 6
    //   653: aload 11
    //   655: aload 9
    //   657: iconst_0
    //   658: iload_3
    //   659: invokevirtual 204	java/io/OutputStream:write	([BII)V
    //   662: aload 10
    //   664: lload 6
    //   666: putfield 207	com/tencent/xweb/xwalk/updater/h$b:KIL	J
    //   669: lload 6
    //   671: lstore 4
    //   673: iload_2
    //   674: ifle -120 -> 554
    //   677: aload_0
    //   678: iconst_1
    //   679: anewarray 12	com/tencent/xweb/xwalk/updater/h$b
    //   682: dup
    //   683: iconst_0
    //   684: aload 10
    //   686: aastore
    //   687: invokevirtual 211	com/tencent/xweb/xwalk/updater/h:publishProgress	([Ljava/lang/Object;)V
    //   690: lload 6
    //   692: lstore 4
    //   694: goto -140 -> 554
    //   697: astore 13
    //   699: aload 8
    //   701: astore 10
    //   703: aload 11
    //   705: astore 8
    //   707: aload_1
    //   708: astore 9
    //   710: aload 10
    //   712: astore_1
    //   713: aload_1
    //   714: astore 10
    //   716: aload 9
    //   718: astore 11
    //   720: aload 8
    //   722: astore 12
    //   724: new 188	java/lang/StringBuilder
    //   727: dup
    //   728: ldc 213
    //   730: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   733: aload 13
    //   735: invokevirtual 214	java/lang/Exception:toString	()Ljava/lang/String;
    //   738: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   741: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   744: invokestatic 121	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   747: aload_1
    //   748: astore 10
    //   750: aload 9
    //   752: astore 11
    //   754: aload 8
    //   756: astore 12
    //   758: aload 21
    //   760: sipush -10002
    //   763: putfield 75	com/tencent/xweb/xwalk/updater/h$c:KIM	I
    //   766: aload 8
    //   768: ifnull +8 -> 776
    //   771: aload 8
    //   773: invokevirtual 183	java/io/OutputStream:close	()V
    //   776: aload 9
    //   778: ifnull +8 -> 786
    //   781: aload 9
    //   783: invokevirtual 180	java/io/InputStream:close	()V
    //   786: aload_1
    //   787: ifnull +7 -> 794
    //   790: aload_1
    //   791: invokevirtual 186	java/net/HttpURLConnection:disconnect	()V
    //   794: ldc 48
    //   796: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   799: aload 21
    //   801: areturn
    //   802: aload 21
    //   804: lload 4
    //   806: putfield 89	com/tencent/xweb/xwalk/updater/h$c:mTotalSize	J
    //   809: aload 21
    //   811: invokestatic 220	java/lang/System:currentTimeMillis	()J
    //   814: aload_0
    //   815: getfield 40	com/tencent/xweb/xwalk/updater/h:KII	J
    //   818: lsub
    //   819: putfield 86	com/tencent/xweb/xwalk/updater/h$c:aQx	J
    //   822: aload_1
    //   823: astore 9
    //   825: aload 11
    //   827: astore 12
    //   829: aload_1
    //   830: astore 10
    //   832: aload 11
    //   834: astore 13
    //   836: aload 8
    //   838: invokevirtual 186	java/net/HttpURLConnection:disconnect	()V
    //   841: aload 11
    //   843: ifnull +8 -> 851
    //   846: aload 11
    //   848: invokevirtual 183	java/io/OutputStream:close	()V
    //   851: aload_1
    //   852: ifnull +7 -> 859
    //   855: aload_1
    //   856: invokevirtual 180	java/io/InputStream:close	()V
    //   859: aload 8
    //   861: ifnull +8 -> 869
    //   864: aload 8
    //   866: invokevirtual 186	java/net/HttpURLConnection:disconnect	()V
    //   869: ldc 48
    //   871: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   874: aload 21
    //   876: areturn
    //   877: aload 18
    //   879: astore 9
    //   881: aload 14
    //   883: astore 12
    //   885: aload 19
    //   887: astore 10
    //   889: aload 15
    //   891: astore 13
    //   893: aload 21
    //   895: sipush -10005
    //   898: putfield 75	com/tencent/xweb/xwalk/updater/h$c:KIM	I
    //   901: aload 18
    //   903: astore 9
    //   905: aload 14
    //   907: astore 12
    //   909: aload 19
    //   911: astore 10
    //   913: aload 15
    //   915: astore 13
    //   917: aload 21
    //   919: ldc 222
    //   921: iload_2
    //   922: invokestatic 226	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   925: invokevirtual 230	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   928: putfield 80	com/tencent/xweb/xwalk/updater/h$c:jYB	Ljava/lang/String;
    //   931: aload 17
    //   933: astore 11
    //   935: goto -113 -> 822
    //   938: astore 13
    //   940: aload 8
    //   942: astore_1
    //   943: aload 12
    //   945: astore 8
    //   947: goto -234 -> 713
    //   950: astore_1
    //   951: new 188	java/lang/StringBuilder
    //   954: dup
    //   955: ldc 190
    //   957: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   960: aload_1
    //   961: invokevirtual 195	java/io/IOException:toString	()Ljava/lang/String;
    //   964: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   967: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   970: invokestatic 121	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   973: aload 21
    //   975: sipush -10003
    //   978: putfield 75	com/tencent/xweb/xwalk/updater/h$c:KIM	I
    //   981: ldc 48
    //   983: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   986: aload 21
    //   988: areturn
    //   989: astore_1
    //   990: new 188	java/lang/StringBuilder
    //   993: dup
    //   994: ldc 190
    //   996: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   999: aload_1
    //   1000: invokevirtual 195	java/io/IOException:toString	()Ljava/lang/String;
    //   1003: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1006: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1009: invokestatic 121	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   1012: aload 21
    //   1014: sipush -10003
    //   1017: putfield 75	com/tencent/xweb/xwalk/updater/h$c:KIM	I
    //   1020: ldc 48
    //   1022: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1025: aload 21
    //   1027: areturn
    //   1028: astore 8
    //   1030: aload 11
    //   1032: astore_1
    //   1033: aload 10
    //   1035: astore 9
    //   1037: aload 12
    //   1039: ifnull +8 -> 1047
    //   1042: aload 12
    //   1044: invokevirtual 183	java/io/OutputStream:close	()V
    //   1047: aload_1
    //   1048: ifnull +7 -> 1055
    //   1051: aload_1
    //   1052: invokevirtual 180	java/io/InputStream:close	()V
    //   1055: aload 9
    //   1057: ifnull +8 -> 1065
    //   1060: aload 9
    //   1062: invokevirtual 186	java/net/HttpURLConnection:disconnect	()V
    //   1065: ldc 48
    //   1067: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1070: aload 8
    //   1072: athrow
    //   1073: astore_1
    //   1074: new 188	java/lang/StringBuilder
    //   1077: dup
    //   1078: ldc 190
    //   1080: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1083: aload_1
    //   1084: invokevirtual 195	java/io/IOException:toString	()Ljava/lang/String;
    //   1087: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1090: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1093: invokestatic 121	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   1096: aload 21
    //   1098: sipush -10003
    //   1101: putfield 75	com/tencent/xweb/xwalk/updater/h$c:KIM	I
    //   1104: ldc 48
    //   1106: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1109: aload 21
    //   1111: areturn
    //   1112: astore_1
    //   1113: aload 8
    //   1115: astore 9
    //   1117: aload_1
    //   1118: astore 8
    //   1120: aload 10
    //   1122: astore_1
    //   1123: aload 13
    //   1125: astore 12
    //   1127: goto -90 -> 1037
    //   1130: astore 10
    //   1132: aload 8
    //   1134: astore 9
    //   1136: aload 10
    //   1138: astore 8
    //   1140: aload 11
    //   1142: astore 12
    //   1144: goto -107 -> 1037
    //   1147: astore 13
    //   1149: aload 20
    //   1151: astore_1
    //   1152: aload 16
    //   1154: astore 8
    //   1156: goto -443 -> 713
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1159	0	this	h
    //   0	1159	1	paramVarArgs	a[]
    //   355	567	2	i	int
    //   560	99	3	j	int
    //   526	279	4	l1	long
    //   651	40	6	l2	long
    //   261	685	8	localObject1	Object
    //   1028	86	8	localObject2	Object
    //   1118	37	8	localObject3	Object
    //   235	900	9	localObject4	Object
    //   238	883	10	localObject5	Object
    //   1130	7	10	localObject6	Object
    //   229	912	11	localObject7	Object
    //   215	928	12	localObject8	Object
    //   277	229	13	localObject9	Object
    //   697	37	13	localException1	java.lang.Exception
    //   834	82	13	localObject10	Object
    //   938	186	13	localException2	java.lang.Exception
    //   1147	1	13	localException3	java.lang.Exception
    //   212	694	14	localObject11	Object
    //   218	696	15	localObject12	Object
    //   221	932	16	localFile	java.io.File
    //   209	723	17	localObject13	Object
    //   226	676	18	localObject14	Object
    //   232	678	19	localObject15	Object
    //   241	909	20	localObject16	Object
    //   69	1041	21	localc	c
    //   32	508	22	locala	a
    // Exception table:
    //   from	to	target	type
    //   577	582	607	java/io/IOException
    //   586	590	607	java/io/IOException
    //   518	525	697	java/lang/Exception
    //   528	554	697	java/lang/Exception
    //   554	561	697	java/lang/Exception
    //   566	577	697	java/lang/Exception
    //   653	669	697	java/lang/Exception
    //   677	690	697	java/lang/Exception
    //   802	822	697	java/lang/Exception
    //   279	286	938	java/lang/Exception
    //   302	310	938	java/lang/Exception
    //   326	334	938	java/lang/Exception
    //   350	356	938	java/lang/Exception
    //   379	385	938	java/lang/Exception
    //   399	405	938	java/lang/Exception
    //   419	426	938	java/lang/Exception
    //   440	451	938	java/lang/Exception
    //   465	473	938	java/lang/Exception
    //   487	493	938	java/lang/Exception
    //   507	518	938	java/lang/Exception
    //   836	841	938	java/lang/Exception
    //   893	901	938	java/lang/Exception
    //   917	931	938	java/lang/Exception
    //   846	851	950	java/io/IOException
    //   855	859	950	java/io/IOException
    //   771	776	989	java/io/IOException
    //   781	786	989	java/io/IOException
    //   243	263	1028	finally
    //   724	747	1028	finally
    //   758	766	1028	finally
    //   1042	1047	1073	java/io/IOException
    //   1051	1055	1073	java/io/IOException
    //   279	286	1112	finally
    //   302	310	1112	finally
    //   326	334	1112	finally
    //   350	356	1112	finally
    //   379	385	1112	finally
    //   399	405	1112	finally
    //   419	426	1112	finally
    //   440	451	1112	finally
    //   465	473	1112	finally
    //   487	493	1112	finally
    //   507	518	1112	finally
    //   836	841	1112	finally
    //   893	901	1112	finally
    //   917	931	1112	finally
    //   518	525	1130	finally
    //   528	554	1130	finally
    //   554	561	1130	finally
    //   566	577	1130	finally
    //   653	669	1130	finally
    //   677	690	1130	finally
    //   802	822	1130	finally
    //   243	263	1147	java/lang/Exception
  }
  
  public static void a(a parama, b paramb)
  {
    AppMethodBeat.i(154584);
    h localh = new h();
    localh.KIF = paramb;
    localh.KIG = parama;
    localh.KIH = 0;
    localh.KII = System.currentTimeMillis();
    localh.execute(new a[] { localh.KIG });
    AppMethodBeat.o(154584);
  }
  
  protected final void onPreExecute() {}
  
  public static final class a
  {
    public boolean KIK;
    public String mFilePath;
    public String mUrl;
  }
  
  public static final class b
  {
    public long KIL;
    public long mTotalSize;
    public String mUrl;
  }
  
  public static final class c
  {
    public int KIM;
    public int KIN;
    public long aQx;
    public String jYB;
    public String mFilePath;
    public int mNetWorkType;
    public int mRetryTimes;
    public long mTotalSize;
    public String mUrl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.h
 * JD-Core Version:    0.7.0.1
 */