package org.xwalk.core;

import android.content.Context;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public class XWalkLibraryLoader$HttpDownloadTask
  extends AsyncTask<Void, Integer, Integer>
{
  private static final int DOWNLOAD_FAILED = -1;
  private static final int DOWNLOAD_SUCCESS = 0;
  private static final int UPDATE_INTERVAL_MS = 500;
  private static final String XWALK_DOWNLOAD_DIR = "xwalk_download";
  private XWalkLibraryLoader.DownloadInfo mDownloadInfo;
  private File mDownloadedFile;
  private XWalkLibraryLoader.DownloadListener mListener;
  private long mProgressUpdateTime;
  
  public XWalkLibraryLoader$HttpDownloadTask(boolean paramBoolean, XWalkLibraryLoader.DownloadListener paramDownloadListener, String paramString1, String paramString2)
  {
    AppMethodBeat.i(85671);
    this.mListener = paramDownloadListener;
    this.mDownloadInfo = new XWalkLibraryLoader.DownloadInfo();
    this.mDownloadInfo.mErrorType = 0;
    this.mDownloadInfo.mErrorCode = 0;
    this.mDownloadInfo.mDownloadType = 1;
    this.mDownloadInfo.mUrl = paramString1;
    this.mDownloadInfo.mSavePath = paramString2;
    this.mDownloadInfo.mIsRuntime = paramBoolean;
    AppMethodBeat.o(85671);
  }
  
  /* Error */
  protected Integer doInBackground(Void... paramVarArgs)
  {
    // Byte code:
    //   0: ldc 76
    //   2: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore 14
    //   8: aconst_null
    //   9: astore 16
    //   11: aconst_null
    //   12: astore 17
    //   14: aconst_null
    //   15: astore_1
    //   16: aload_1
    //   17: astore 12
    //   19: new 78	java/net/URL
    //   22: dup
    //   23: aload_0
    //   24: getfield 46	org/xwalk/core/XWalkLibraryLoader$HttpDownloadTask:mDownloadInfo	Lorg/xwalk/core/XWalkLibraryLoader$DownloadInfo;
    //   27: getfield 58	org/xwalk/core/XWalkLibraryLoader$DownloadInfo:mUrl	Ljava/lang/String;
    //   30: invokespecial 81	java/net/URL:<init>	(Ljava/lang/String;)V
    //   33: astore 15
    //   35: aload_1
    //   36: astore 12
    //   38: aload 15
    //   40: invokevirtual 85	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   43: checkcast 87	java/net/HttpURLConnection
    //   46: astore 13
    //   48: aload 13
    //   50: astore_1
    //   51: aload 13
    //   53: astore 12
    //   55: aload 13
    //   57: sipush 30000
    //   60: invokevirtual 90	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   63: aload 13
    //   65: astore_1
    //   66: aload 13
    //   68: astore 12
    //   70: aload 13
    //   72: sipush 30000
    //   75: invokevirtual 93	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   78: aload 13
    //   80: astore_1
    //   81: aload 13
    //   83: astore 12
    //   85: aload 13
    //   87: invokevirtual 96	java/net/HttpURLConnection:connect	()V
    //   90: aload 13
    //   92: astore_1
    //   93: aload 13
    //   95: astore 12
    //   97: aload 13
    //   99: invokevirtual 100	java/net/HttpURLConnection:getResponseCode	()I
    //   102: sipush 200
    //   105: if_icmpeq +86 -> 191
    //   108: aload 13
    //   110: astore_1
    //   111: aload 13
    //   113: astore 12
    //   115: aload 13
    //   117: invokevirtual 100	java/net/HttpURLConnection:getResponseCode	()I
    //   120: sipush 206
    //   123: if_icmpeq +68 -> 191
    //   126: aload 13
    //   128: astore_1
    //   129: aload 13
    //   131: astore 12
    //   133: ldc 102
    //   135: new 104	java/lang/StringBuilder
    //   138: dup
    //   139: ldc 106
    //   141: invokespecial 107	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   144: aload 13
    //   146: invokevirtual 100	java/net/HttpURLConnection:getResponseCode	()I
    //   149: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   152: ldc 113
    //   154: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload 13
    //   159: invokevirtual 120	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
    //   162: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokestatic 129	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   171: aload 13
    //   173: ifnull +8 -> 181
    //   176: aload 13
    //   178: invokevirtual 132	java/net/HttpURLConnection:disconnect	()V
    //   181: ldc 76
    //   183: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   186: iconst_m1
    //   187: invokestatic 138	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   190: areturn
    //   191: aload 13
    //   193: astore_1
    //   194: aload 13
    //   196: astore 12
    //   198: aload 13
    //   200: invokevirtual 141	java/net/HttpURLConnection:getContentLength	()I
    //   203: istore_2
    //   204: aload 13
    //   206: astore_1
    //   207: aload 13
    //   209: astore 12
    //   211: aload_0
    //   212: getfield 143	org/xwalk/core/XWalkLibraryLoader$HttpDownloadTask:mDownloadedFile	Ljava/io/File;
    //   215: invokevirtual 149	java/io/File:exists	()Z
    //   218: ifeq +778 -> 996
    //   221: aload 13
    //   223: astore_1
    //   224: aload 13
    //   226: astore 12
    //   228: aload_0
    //   229: getfield 143	org/xwalk/core/XWalkLibraryLoader$HttpDownloadTask:mDownloadedFile	Ljava/io/File;
    //   232: invokevirtual 153	java/io/File:length	()J
    //   235: lstore 4
    //   237: iload_2
    //   238: i2l
    //   239: lload 4
    //   241: lcmp
    //   242: ifne +37 -> 279
    //   245: aload 13
    //   247: astore_1
    //   248: aload 13
    //   250: astore 12
    //   252: ldc 102
    //   254: ldc 155
    //   256: invokestatic 157	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   259: aload 13
    //   261: ifnull +8 -> 269
    //   264: aload 13
    //   266: invokevirtual 132	java/net/HttpURLConnection:disconnect	()V
    //   269: ldc 76
    //   271: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   274: iconst_0
    //   275: invokestatic 138	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   278: areturn
    //   279: lload 4
    //   281: lconst_0
    //   282: lcmp
    //   283: ifle +32 -> 315
    //   286: aload 13
    //   288: astore_1
    //   289: aload 13
    //   291: astore 12
    //   293: aload_0
    //   294: getfield 46	org/xwalk/core/XWalkLibraryLoader$HttpDownloadTask:mDownloadInfo	Lorg/xwalk/core/XWalkLibraryLoader$DownloadInfo;
    //   297: iconst_1
    //   298: putfield 160	org/xwalk/core/XWalkLibraryLoader$DownloadInfo:mIsDownloadResume	Z
    //   301: aload 13
    //   303: astore_1
    //   304: aload 13
    //   306: astore 12
    //   308: ldc 102
    //   310: ldc 162
    //   312: invokestatic 157	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   315: aload 13
    //   317: astore_1
    //   318: aload 13
    //   320: astore 12
    //   322: aload 13
    //   324: invokevirtual 132	java/net/HttpURLConnection:disconnect	()V
    //   327: aload 13
    //   329: astore_1
    //   330: aload 13
    //   332: astore 12
    //   334: aload 15
    //   336: invokevirtual 85	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   339: checkcast 87	java/net/HttpURLConnection
    //   342: astore 13
    //   344: aload 13
    //   346: astore_1
    //   347: aload 13
    //   349: astore 12
    //   351: aload 13
    //   353: sipush 30000
    //   356: invokevirtual 90	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   359: aload 13
    //   361: astore_1
    //   362: aload 13
    //   364: astore 12
    //   366: aload 13
    //   368: sipush 30000
    //   371: invokevirtual 93	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   374: aload 13
    //   376: astore_1
    //   377: aload 13
    //   379: astore 12
    //   381: aload 13
    //   383: ldc 164
    //   385: new 104	java/lang/StringBuilder
    //   388: dup
    //   389: ldc 166
    //   391: invokespecial 107	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   394: lload 4
    //   396: invokevirtual 169	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   399: ldc 171
    //   401: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   407: invokevirtual 174	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   410: aload 13
    //   412: astore_1
    //   413: aload 13
    //   415: astore 12
    //   417: ldc 102
    //   419: ldc 176
    //   421: lload 4
    //   423: invokestatic 181	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   426: invokevirtual 185	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   429: invokestatic 157	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   432: aload 13
    //   434: astore_1
    //   435: aload 13
    //   437: astore 12
    //   439: aload 13
    //   441: invokevirtual 96	java/net/HttpURLConnection:connect	()V
    //   444: aload 13
    //   446: astore_1
    //   447: aload 13
    //   449: astore 12
    //   451: aload 13
    //   453: invokevirtual 100	java/net/HttpURLConnection:getResponseCode	()I
    //   456: sipush 200
    //   459: if_icmpeq +86 -> 545
    //   462: aload 13
    //   464: astore_1
    //   465: aload 13
    //   467: astore 12
    //   469: aload 13
    //   471: invokevirtual 100	java/net/HttpURLConnection:getResponseCode	()I
    //   474: sipush 206
    //   477: if_icmpeq +68 -> 545
    //   480: aload 13
    //   482: astore_1
    //   483: aload 13
    //   485: astore 12
    //   487: ldc 102
    //   489: new 104	java/lang/StringBuilder
    //   492: dup
    //   493: ldc 106
    //   495: invokespecial 107	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   498: aload 13
    //   500: invokevirtual 100	java/net/HttpURLConnection:getResponseCode	()I
    //   503: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   506: ldc 113
    //   508: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: aload 13
    //   513: invokevirtual 120	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
    //   516: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   522: invokestatic 129	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   525: aload 13
    //   527: ifnull +8 -> 535
    //   530: aload 13
    //   532: invokevirtual 132	java/net/HttpURLConnection:disconnect	()V
    //   535: ldc 76
    //   537: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   540: iconst_m1
    //   541: invokestatic 138	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   544: areturn
    //   545: aload 13
    //   547: astore_1
    //   548: aload 13
    //   550: astore 12
    //   552: aload 13
    //   554: invokevirtual 141	java/net/HttpURLConnection:getContentLength	()I
    //   557: istore_2
    //   558: aload 13
    //   560: astore_1
    //   561: aload_1
    //   562: astore 12
    //   564: aload_1
    //   565: invokevirtual 189	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   568: astore 13
    //   570: aload 13
    //   572: astore 12
    //   574: aload_1
    //   575: astore 14
    //   577: aload 12
    //   579: astore 15
    //   581: new 191	java/io/FileOutputStream
    //   584: dup
    //   585: aload_0
    //   586: getfield 143	org/xwalk/core/XWalkLibraryLoader$HttpDownloadTask:mDownloadedFile	Ljava/io/File;
    //   589: iconst_1
    //   590: invokespecial 194	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   593: astore 13
    //   595: sipush 4096
    //   598: newarray byte
    //   600: astore 14
    //   602: lconst_0
    //   603: lstore 6
    //   605: aload 12
    //   607: aload 14
    //   609: invokevirtual 200	java/io/InputStream:read	([B)I
    //   612: istore_3
    //   613: iload_3
    //   614: iconst_m1
    //   615: if_icmpeq +167 -> 782
    //   618: aload_0
    //   619: invokevirtual 203	org/xwalk/core/XWalkLibraryLoader$HttpDownloadTask:isCancelled	()Z
    //   622: ifeq +36 -> 658
    //   625: aload 13
    //   627: invokevirtual 208	java/io/OutputStream:close	()V
    //   630: aload 12
    //   632: ifnull +8 -> 640
    //   635: aload 12
    //   637: invokevirtual 209	java/io/InputStream:close	()V
    //   640: aload_1
    //   641: ifnull +7 -> 648
    //   644: aload_1
    //   645: invokevirtual 132	java/net/HttpURLConnection:disconnect	()V
    //   648: ldc 76
    //   650: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   653: iconst_m1
    //   654: invokestatic 138	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   657: areturn
    //   658: lload 6
    //   660: iload_3
    //   661: i2l
    //   662: ladd
    //   663: lstore 8
    //   665: aload 13
    //   667: aload 14
    //   669: iconst_0
    //   670: iload_3
    //   671: invokevirtual 213	java/io/OutputStream:write	([BII)V
    //   674: invokestatic 218	android/os/SystemClock:uptimeMillis	()J
    //   677: lstore 10
    //   679: lload 8
    //   681: lstore 6
    //   683: lload 10
    //   685: aload_0
    //   686: getfield 220	org/xwalk/core/XWalkLibraryLoader$HttpDownloadTask:mProgressUpdateTime	J
    //   689: lsub
    //   690: ldc2_w 221
    //   693: lcmp
    //   694: ifle -89 -> 605
    //   697: aload_0
    //   698: lload 10
    //   700: putfield 220	org/xwalk/core/XWalkLibraryLoader$HttpDownloadTask:mProgressUpdateTime	J
    //   703: aload_0
    //   704: iconst_2
    //   705: anewarray 134	java/lang/Integer
    //   708: dup
    //   709: iconst_0
    //   710: lload 8
    //   712: lload 4
    //   714: ladd
    //   715: l2i
    //   716: invokestatic 138	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   719: aastore
    //   720: dup
    //   721: iconst_1
    //   722: iload_2
    //   723: i2l
    //   724: lload 4
    //   726: ladd
    //   727: l2i
    //   728: invokestatic 138	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   731: aastore
    //   732: invokevirtual 226	org/xwalk/core/XWalkLibraryLoader$HttpDownloadTask:publishProgress	([Ljava/lang/Object;)V
    //   735: lload 8
    //   737: lstore 6
    //   739: goto -134 -> 605
    //   742: astore 14
    //   744: aload 13
    //   746: ifnull +8 -> 754
    //   749: aload 13
    //   751: invokevirtual 208	java/io/OutputStream:close	()V
    //   754: aload 12
    //   756: ifnull +8 -> 764
    //   759: aload 12
    //   761: invokevirtual 209	java/io/InputStream:close	()V
    //   764: aload_1
    //   765: ifnull +7 -> 772
    //   768: aload_1
    //   769: invokevirtual 132	java/net/HttpURLConnection:disconnect	()V
    //   772: ldc 76
    //   774: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   777: iconst_m1
    //   778: invokestatic 138	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   781: areturn
    //   782: aload 13
    //   784: invokevirtual 229	java/io/OutputStream:flush	()V
    //   787: aload 13
    //   789: invokevirtual 208	java/io/OutputStream:close	()V
    //   792: aload 12
    //   794: ifnull +8 -> 802
    //   797: aload 12
    //   799: invokevirtual 209	java/io/InputStream:close	()V
    //   802: aload_1
    //   803: ifnull +7 -> 810
    //   806: aload_1
    //   807: invokevirtual 132	java/net/HttpURLConnection:disconnect	()V
    //   810: aload_0
    //   811: getfield 46	org/xwalk/core/XWalkLibraryLoader$HttpDownloadTask:mDownloadInfo	Lorg/xwalk/core/XWalkLibraryLoader$DownloadInfo;
    //   814: aload_0
    //   815: getfield 143	org/xwalk/core/XWalkLibraryLoader$HttpDownloadTask:mDownloadedFile	Ljava/io/File;
    //   818: invokevirtual 153	java/io/File:length	()J
    //   821: putfield 232	org/xwalk/core/XWalkLibraryLoader$DownloadInfo:mFileTotalSize	J
    //   824: ldc 76
    //   826: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   829: iconst_0
    //   830: invokestatic 138	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   833: areturn
    //   834: astore 12
    //   836: aconst_null
    //   837: astore 13
    //   839: aconst_null
    //   840: astore_1
    //   841: aload 14
    //   843: ifnull +8 -> 851
    //   846: aload 14
    //   848: invokevirtual 208	java/io/OutputStream:close	()V
    //   851: aload_1
    //   852: ifnull +7 -> 859
    //   855: aload_1
    //   856: invokevirtual 209	java/io/InputStream:close	()V
    //   859: aload 13
    //   861: ifnull +8 -> 869
    //   864: aload 13
    //   866: invokevirtual 132	java/net/HttpURLConnection:disconnect	()V
    //   869: ldc 76
    //   871: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   874: aload 12
    //   876: athrow
    //   877: astore_1
    //   878: goto -19 -> 859
    //   881: astore 12
    //   883: aload_1
    //   884: astore 13
    //   886: aconst_null
    //   887: astore_1
    //   888: goto -47 -> 841
    //   891: astore 12
    //   893: aload_1
    //   894: astore 13
    //   896: aconst_null
    //   897: astore_1
    //   898: goto -57 -> 841
    //   901: astore 12
    //   903: aload 14
    //   905: astore 13
    //   907: aload 16
    //   909: astore 14
    //   911: aload 15
    //   913: astore_1
    //   914: goto -73 -> 841
    //   917: astore 15
    //   919: aload_1
    //   920: astore 16
    //   922: aload 13
    //   924: astore 14
    //   926: aload 12
    //   928: astore_1
    //   929: aload 15
    //   931: astore 12
    //   933: aload 16
    //   935: astore 13
    //   937: goto -96 -> 841
    //   940: astore 12
    //   942: goto -178 -> 764
    //   945: astore_1
    //   946: aconst_null
    //   947: astore 14
    //   949: aload 12
    //   951: astore_1
    //   952: aload 17
    //   954: astore 13
    //   956: aload 14
    //   958: astore 12
    //   960: goto -216 -> 744
    //   963: astore_1
    //   964: aload 12
    //   966: astore_1
    //   967: aconst_null
    //   968: astore 12
    //   970: aload 17
    //   972: astore 13
    //   974: goto -230 -> 744
    //   977: astore 13
    //   979: aload 17
    //   981: astore 13
    //   983: goto -239 -> 744
    //   986: astore 12
    //   988: goto -186 -> 802
    //   991: astore 12
    //   993: goto -353 -> 640
    //   996: lconst_0
    //   997: lstore 4
    //   999: aload 13
    //   1001: astore_1
    //   1002: goto -441 -> 561
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1005	0	this	HttpDownloadTask
    //   0	1005	1	paramVarArgs	Void[]
    //   203	520	2	i	int
    //   612	59	3	j	int
    //   235	763	4	l1	long
    //   603	135	6	l2	long
    //   663	73	8	l3	long
    //   677	22	10	l4	long
    //   17	781	12	localObject1	java.lang.Object
    //   834	41	12	localObject2	java.lang.Object
    //   881	1	12	localObject3	java.lang.Object
    //   891	1	12	localObject4	java.lang.Object
    //   901	26	12	localObject5	java.lang.Object
    //   931	1	12	localObject6	java.lang.Object
    //   940	10	12	localIOException1	java.io.IOException
    //   958	11	12	localObject7	java.lang.Object
    //   986	1	12	localIOException2	java.io.IOException
    //   991	1	12	localIOException3	java.io.IOException
    //   46	927	13	localObject8	java.lang.Object
    //   977	1	13	localException1	java.lang.Exception
    //   981	19	13	localObject9	java.lang.Object
    //   6	662	14	localObject10	java.lang.Object
    //   742	162	14	localException2	java.lang.Exception
    //   909	48	14	localObject11	java.lang.Object
    //   33	879	15	localObject12	java.lang.Object
    //   917	13	15	localObject13	java.lang.Object
    //   9	925	16	arrayOfVoid	Void[]
    //   12	968	17	localObject14	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   595	602	742	java/lang/Exception
    //   605	613	742	java/lang/Exception
    //   618	625	742	java/lang/Exception
    //   665	679	742	java/lang/Exception
    //   683	735	742	java/lang/Exception
    //   782	787	742	java/lang/Exception
    //   19	35	834	finally
    //   38	48	834	finally
    //   846	851	877	java/io/IOException
    //   855	859	877	java/io/IOException
    //   55	63	881	finally
    //   70	78	881	finally
    //   85	90	881	finally
    //   97	108	881	finally
    //   115	126	881	finally
    //   133	171	881	finally
    //   198	204	881	finally
    //   211	221	881	finally
    //   228	237	881	finally
    //   252	259	881	finally
    //   293	301	881	finally
    //   308	315	881	finally
    //   322	327	881	finally
    //   334	344	881	finally
    //   351	359	881	finally
    //   366	374	881	finally
    //   381	410	881	finally
    //   417	432	881	finally
    //   439	444	881	finally
    //   451	462	881	finally
    //   469	480	881	finally
    //   487	525	881	finally
    //   552	558	881	finally
    //   564	570	891	finally
    //   581	595	901	finally
    //   595	602	917	finally
    //   605	613	917	finally
    //   618	625	917	finally
    //   665	679	917	finally
    //   683	735	917	finally
    //   782	787	917	finally
    //   749	754	940	java/io/IOException
    //   759	764	940	java/io/IOException
    //   19	35	945	java/lang/Exception
    //   38	48	945	java/lang/Exception
    //   564	570	945	java/lang/Exception
    //   55	63	963	java/lang/Exception
    //   70	78	963	java/lang/Exception
    //   85	90	963	java/lang/Exception
    //   97	108	963	java/lang/Exception
    //   115	126	963	java/lang/Exception
    //   133	171	963	java/lang/Exception
    //   198	204	963	java/lang/Exception
    //   211	221	963	java/lang/Exception
    //   228	237	963	java/lang/Exception
    //   252	259	963	java/lang/Exception
    //   293	301	963	java/lang/Exception
    //   308	315	963	java/lang/Exception
    //   322	327	963	java/lang/Exception
    //   334	344	963	java/lang/Exception
    //   351	359	963	java/lang/Exception
    //   366	374	963	java/lang/Exception
    //   381	410	963	java/lang/Exception
    //   417	432	963	java/lang/Exception
    //   439	444	963	java/lang/Exception
    //   451	462	963	java/lang/Exception
    //   469	480	963	java/lang/Exception
    //   487	525	963	java/lang/Exception
    //   552	558	963	java/lang/Exception
    //   581	595	977	java/lang/Exception
    //   787	792	986	java/io/IOException
    //   797	802	986	java/io/IOException
    //   625	630	991	java/io/IOException
    //   635	640	991	java/io/IOException
  }
  
  protected void onCancelled(Integer paramInteger)
  {
    AppMethodBeat.i(85675);
    if (this.mDownloadInfo.mIsRuntime)
    {
      XWalkLibraryLoader.access$002(null);
      Log.i("XWalkLib", "HttpDownloadTask runtime onCancelled: " + this.mDownloadInfo.mSavePath);
    }
    for (;;)
    {
      this.mListener.onDownloadCancelled();
      AppMethodBeat.o(85675);
      return;
      Log.i("XWalkLib", "HttpDownloadTask other onCancelled: " + this.mDownloadInfo.mSavePath);
    }
  }
  
  protected void onPostExecute(Integer paramInteger)
  {
    AppMethodBeat.i(85676);
    if (this.mDownloadInfo.mIsRuntime)
    {
      XWalkLibraryLoader.access$002(null);
      Log.i("XWalkLib", "HttpDownloadTask runtime onPostExecute result " + paramInteger + " " + this.mDownloadInfo.mSavePath);
    }
    while (paramInteger.intValue() == 0)
    {
      this.mDownloadInfo.mErrorCode = 0;
      this.mListener.onDownloadCompleted(this.mDownloadInfo);
      AppMethodBeat.o(85676);
      return;
      Log.i("XWalkLib", "HttpDownloadTask other onPostExecute result " + paramInteger + " " + this.mDownloadInfo.mSavePath);
    }
    this.mDownloadInfo.mErrorCode = -1;
    this.mListener.onDownloadFailed(this.mDownloadInfo);
    AppMethodBeat.o(85676);
  }
  
  protected void onPreExecute()
  {
    AppMethodBeat.i(85672);
    if (this.mDownloadInfo.mIsRuntime)
    {
      XWalkLibraryLoader.access$002(this);
      Log.i("XWalkLib", "HttpDownloadTask runtime onPreExecute: " + this.mDownloadInfo.mSavePath);
    }
    for (;;)
    {
      this.mDownloadedFile = new File(this.mDownloadInfo.mSavePath);
      this.mListener.onDownloadStarted(this.mDownloadInfo.mDownloadType);
      this.mDownloadInfo.mStartTimestamp = System.currentTimeMillis();
      Context localContext = XWalkEnvironment.getApplicationContext();
      this.mDownloadInfo.mNetWorkType = NetworkUtil.getCurrentNetWorkStatus(localContext);
      AppMethodBeat.o(85672);
      return;
      Log.i("XWalkLib", "HttpDownloadTask other onPreExecute: " + this.mDownloadInfo.mSavePath);
    }
  }
  
  protected void onProgressUpdate(Integer... paramVarArgs)
  {
    int i = 0;
    AppMethodBeat.i(85674);
    Log.d("XWalkLib", "HttpDownloadTask updated: " + paramVarArgs[0] + "/" + paramVarArgs[1]);
    if (paramVarArgs[1].intValue() > 0) {
      i = (int)(paramVarArgs[0].intValue() * 100.0D / paramVarArgs[1].intValue());
    }
    this.mListener.onDownloadUpdated(i);
    AppMethodBeat.o(85674);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.xwalk.core.XWalkLibraryLoader.HttpDownloadTask
 * JD-Core Version:    0.7.0.1
 */