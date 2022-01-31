package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.network.u;
import com.tencent.mm.sdk.platformtools.y;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class af
  extends n
{
  private u nfp;
  
  private static void a(n.b paramb, OutputStream paramOutputStream)
  {
    if (paramb.ndL == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramb.ndL.keySet().iterator();
    int i = 1;
    if (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      if (i != 0) {}
      for (String str1 = "";; str1 = "&")
      {
        localStringBuilder.append(str1).append(URLEncoder.encode(str2, "utf-8")).append('=').append(URLEncoder.encode((String)paramb.ndL.get(str2), "utf-8"));
        i = 0;
        break;
      }
    }
    paramOutputStream.write(localStringBuilder.toString().getBytes());
  }
  
  /* Error */
  public final n.c a(String paramString1, String paramString2, n.b paramb, n.a parama)
  {
    // Byte code:
    //   0: ldc 89
    //   2: new 16	java/lang/StringBuilder
    //   5: dup
    //   6: ldc 91
    //   8: invokespecial 94	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   11: aload_2
    //   12: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: ldc 96
    //   17: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: aload_3
    //   21: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   24: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: invokestatic 105	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: aconst_null
    //   31: astore 12
    //   33: aconst_null
    //   34: astore 11
    //   36: aconst_null
    //   37: astore 9
    //   39: aconst_null
    //   40: astore 14
    //   42: aconst_null
    //   43: astore 10
    //   45: aload_3
    //   46: getfield 109	com/tencent/mm/plugin/qqmail/b/n$b:ndK	I
    //   49: ifne +690 -> 739
    //   52: aload_3
    //   53: getfield 14	com/tencent/mm/plugin/qqmail/b/n$b:ndL	Ljava/util/Map;
    //   56: astore 8
    //   58: aload_0
    //   59: aload_1
    //   60: aload_2
    //   61: aload 8
    //   63: invokestatic 113	com/tencent/mm/plugin/qqmail/b/af:c	(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;
    //   66: aconst_null
    //   67: invokestatic 118	com/tencent/mm/network/b:a	(Ljava/lang/String;Lcom/tencent/mm/network/b$b;)Lcom/tencent/mm/network/u;
    //   70: putfield 120	com/tencent/mm/plugin/qqmail/b/af:nfp	Lcom/tencent/mm/network/u;
    //   73: aload_0
    //   74: getfield 120	com/tencent/mm/plugin/qqmail/b/af:nfp	Lcom/tencent/mm/network/u;
    //   77: getstatic 123	com/tencent/mm/plugin/qqmail/b/af:dEk	I
    //   80: invokevirtual 129	com/tencent/mm/network/u:setConnectTimeout	(I)V
    //   83: aload_0
    //   84: getfield 120	com/tencent/mm/plugin/qqmail/b/af:nfp	Lcom/tencent/mm/network/u;
    //   87: astore 8
    //   89: aload_3
    //   90: getfield 109	com/tencent/mm/plugin/qqmail/b/n$b:ndK	I
    //   93: ifne +652 -> 745
    //   96: ldc 131
    //   98: astore_1
    //   99: aload 8
    //   101: aload_1
    //   102: invokevirtual 134	com/tencent/mm/network/u:setRequestMethod	(Ljava/lang/String;)V
    //   105: aload_0
    //   106: getfield 120	com/tencent/mm/plugin/qqmail/b/af:nfp	Lcom/tencent/mm/network/u;
    //   109: invokevirtual 137	com/tencent/mm/network/u:Ud	()V
    //   112: aload_0
    //   113: getfield 120	com/tencent/mm/plugin/qqmail/b/af:nfp	Lcom/tencent/mm/network/u;
    //   116: invokevirtual 140	com/tencent/mm/network/u:Ue	()V
    //   119: aload_0
    //   120: getfield 120	com/tencent/mm/plugin/qqmail/b/af:nfp	Lcom/tencent/mm/network/u;
    //   123: iconst_0
    //   124: invokevirtual 144	com/tencent/mm/network/u:setUseCaches	(Z)V
    //   127: aload_0
    //   128: getfield 120	com/tencent/mm/plugin/qqmail/b/af:nfp	Lcom/tencent/mm/network/u;
    //   131: ldc 146
    //   133: getstatic 150	com/tencent/mm/plugin/qqmail/b/af:aRC	Ljava/lang/String;
    //   136: invokevirtual 153	com/tencent/mm/network/u:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: aload_0
    //   140: getfield 120	com/tencent/mm/plugin/qqmail/b/af:nfp	Lcom/tencent/mm/network/u;
    //   143: ldc 155
    //   145: getstatic 158	com/tencent/mm/plugin/qqmail/b/af:host	Ljava/lang/String;
    //   148: invokevirtual 153	com/tencent/mm/network/u:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: ldc 160
    //   153: ldc 162
    //   155: invokestatic 167	java/lang/System:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   158: pop
    //   159: aload_0
    //   160: getfield 120	com/tencent/mm/plugin/qqmail/b/af:nfp	Lcom/tencent/mm/network/u;
    //   163: ldc 169
    //   165: ldc 52
    //   167: invokevirtual 153	com/tencent/mm/network/u:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   170: aload_0
    //   171: getfield 120	com/tencent/mm/plugin/qqmail/b/af:nfp	Lcom/tencent/mm/network/u;
    //   174: ldc 171
    //   176: ldc 173
    //   178: invokevirtual 153	com/tencent/mm/network/u:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   181: aload_0
    //   182: getfield 120	com/tencent/mm/plugin/qqmail/b/af:nfp	Lcom/tencent/mm/network/u;
    //   185: ldc 175
    //   187: aload_3
    //   188: getfield 178	com/tencent/mm/plugin/qqmail/b/n$b:ndM	Ljava/util/Map;
    //   191: invokestatic 182	com/tencent/mm/plugin/qqmail/b/af:H	(Ljava/util/Map;)Ljava/lang/String;
    //   194: invokevirtual 153	com/tencent/mm/network/u:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   197: aload_0
    //   198: getfield 120	com/tencent/mm/plugin/qqmail/b/af:nfp	Lcom/tencent/mm/network/u;
    //   201: invokevirtual 185	com/tencent/mm/network/u:connect	()V
    //   204: aload_0
    //   205: getfield 120	com/tencent/mm/plugin/qqmail/b/af:nfp	Lcom/tencent/mm/network/u;
    //   208: invokevirtual 189	com/tencent/mm/network/u:getOutputStream	()Ljava/io/OutputStream;
    //   211: astore_1
    //   212: aload 14
    //   214: astore 9
    //   216: aload_1
    //   217: astore 12
    //   219: aload_3
    //   220: getfield 109	com/tencent/mm/plugin/qqmail/b/n$b:ndK	I
    //   223: iconst_1
    //   224: if_icmpne +15 -> 239
    //   227: aload 14
    //   229: astore 9
    //   231: aload_1
    //   232: astore 12
    //   234: aload_3
    //   235: aload_1
    //   236: invokestatic 191	com/tencent/mm/plugin/qqmail/b/af:a	(Lcom/tencent/mm/plugin/qqmail/b/n$b;Ljava/io/OutputStream;)V
    //   239: aload 14
    //   241: astore 9
    //   243: aload_1
    //   244: astore 12
    //   246: aload_1
    //   247: invokevirtual 194	java/io/OutputStream:flush	()V
    //   250: aload 14
    //   252: astore 9
    //   254: aload_1
    //   255: astore 12
    //   257: aload_0
    //   258: getfield 120	com/tencent/mm/plugin/qqmail/b/af:nfp	Lcom/tencent/mm/network/u;
    //   261: invokevirtual 198	com/tencent/mm/network/u:getResponseCode	()I
    //   264: istore 5
    //   266: aload 10
    //   268: astore 13
    //   270: aload 14
    //   272: astore 9
    //   274: aload_1
    //   275: astore 12
    //   277: aload_0
    //   278: getfield 120	com/tencent/mm/plugin/qqmail/b/af:nfp	Lcom/tencent/mm/network/u;
    //   281: ldc 200
    //   283: invokevirtual 204	com/tencent/mm/network/u:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   286: astore 15
    //   288: aload 10
    //   290: astore 13
    //   292: aload 14
    //   294: astore 9
    //   296: aload_1
    //   297: astore 12
    //   299: aload_0
    //   300: getfield 120	com/tencent/mm/plugin/qqmail/b/af:nfp	Lcom/tencent/mm/network/u;
    //   303: ldc 206
    //   305: invokevirtual 204	com/tencent/mm/network/u:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   308: astore 11
    //   310: aload 10
    //   312: astore 13
    //   314: aload 14
    //   316: astore 9
    //   318: aload_1
    //   319: astore 12
    //   321: aload_0
    //   322: getfield 120	com/tencent/mm/plugin/qqmail/b/af:nfp	Lcom/tencent/mm/network/u;
    //   325: ldc 208
    //   327: invokevirtual 204	com/tencent/mm/network/u:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   330: astore 8
    //   332: aload 8
    //   334: ifnull +418 -> 752
    //   337: aload 10
    //   339: astore 13
    //   341: aload 14
    //   343: astore 9
    //   345: aload_1
    //   346: astore 12
    //   348: aload 8
    //   350: ldc 210
    //   352: invokevirtual 214	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   355: ifeq +397 -> 752
    //   358: aload 10
    //   360: astore 13
    //   362: aload 14
    //   364: astore 9
    //   366: aload_1
    //   367: astore 12
    //   369: aload_2
    //   370: ldc 216
    //   372: invokevirtual 214	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   375: ifeq +377 -> 752
    //   378: iconst_1
    //   379: istore 6
    //   381: aload 10
    //   383: astore 13
    //   385: aload 14
    //   387: astore 9
    //   389: aload_1
    //   390: astore 12
    //   392: aload_0
    //   393: getfield 120	com/tencent/mm/plugin/qqmail/b/af:nfp	Lcom/tencent/mm/network/u;
    //   396: invokevirtual 220	com/tencent/mm/network/u:getInputStream	()Ljava/io/InputStream;
    //   399: astore 8
    //   401: aload 11
    //   403: ifnull +944 -> 1347
    //   406: aload 11
    //   408: ldc 222
    //   410: invokevirtual 214	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   413: ifeq +934 -> 1347
    //   416: new 224	java/util/zip/GZIPInputStream
    //   419: dup
    //   420: aload 8
    //   422: invokespecial 227	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   425: astore 9
    //   427: aload 9
    //   429: astore 8
    //   431: aconst_null
    //   432: astore 12
    //   434: aconst_null
    //   435: astore 9
    //   437: iload 6
    //   439: ifeq +345 -> 784
    //   442: aload 9
    //   444: astore 11
    //   446: aload 12
    //   448: astore 10
    //   450: getstatic 230	com/tencent/mm/plugin/qqmail/b/af:ndJ	Ljava/lang/String;
    //   453: astore 13
    //   455: aload 9
    //   457: astore 11
    //   459: aload 12
    //   461: astore 10
    //   463: new 16	java/lang/StringBuilder
    //   466: dup
    //   467: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   470: astore 14
    //   472: aload 9
    //   474: astore 11
    //   476: aload 12
    //   478: astore 10
    //   480: aload_3
    //   481: getfield 14	com/tencent/mm/plugin/qqmail/b/n$b:ndL	Ljava/util/Map;
    //   484: ldc 232
    //   486: invokeinterface 65 2 0
    //   491: ifnonnull +267 -> 758
    //   494: aload 9
    //   496: astore 11
    //   498: aload 12
    //   500: astore 10
    //   502: invokestatic 236	java/lang/System:currentTimeMillis	()J
    //   505: invokestatic 242	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   508: astore_3
    //   509: aload 9
    //   511: astore 11
    //   513: aload 12
    //   515: astore 10
    //   517: new 244	java/io/FileOutputStream
    //   520: dup
    //   521: new 246	java/io/File
    //   524: dup
    //   525: aload 13
    //   527: aload 14
    //   529: aload_3
    //   530: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   533: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   536: invokespecial 248	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   539: iconst_1
    //   540: invokespecial 251	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   543: astore_3
    //   544: aload_3
    //   545: astore 11
    //   547: aload_3
    //   548: astore 10
    //   550: sipush 1024
    //   553: newarray byte
    //   555: astore 9
    //   557: aload_3
    //   558: astore 11
    //   560: aload_3
    //   561: astore 10
    //   563: aload 8
    //   565: aload 9
    //   567: invokevirtual 257	java/io/InputStream:read	([B)I
    //   570: istore 7
    //   572: iload 7
    //   574: ifle +229 -> 803
    //   577: aload_3
    //   578: astore 11
    //   580: aload_3
    //   581: astore 10
    //   583: aload_3
    //   584: aload 9
    //   586: iconst_0
    //   587: iload 7
    //   589: invokevirtual 260	java/io/OutputStream:write	([BII)V
    //   592: aload_3
    //   593: astore 11
    //   595: aload_3
    //   596: astore 10
    //   598: aload_3
    //   599: invokevirtual 194	java/io/OutputStream:flush	()V
    //   602: aload_3
    //   603: astore 11
    //   605: aload_3
    //   606: astore 10
    //   608: aload 4
    //   610: invokeinterface 265 1 0
    //   615: goto -58 -> 557
    //   618: astore_2
    //   619: aload 11
    //   621: astore 10
    //   623: ldc 89
    //   625: aload_2
    //   626: ldc 46
    //   628: iconst_0
    //   629: anewarray 267	java/lang/Object
    //   632: invokestatic 271	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   635: iload 5
    //   637: ifne +371 -> 1008
    //   640: sipush 503
    //   643: istore 6
    //   645: aload 11
    //   647: astore 10
    //   649: new 273	com/tencent/mm/plugin/qqmail/b/n$c
    //   652: dup
    //   653: iload 6
    //   655: aconst_null
    //   656: aconst_null
    //   657: invokespecial 276	com/tencent/mm/plugin/qqmail/b/n$c:<init>	(ILjava/util/Map;Ljava/lang/String;)V
    //   660: astore_2
    //   661: aload 11
    //   663: ifnull +35 -> 698
    //   666: aload 8
    //   668: astore 13
    //   670: aload 8
    //   672: astore 9
    //   674: aload_1
    //   675: astore 12
    //   677: aload 11
    //   679: invokevirtual 194	java/io/OutputStream:flush	()V
    //   682: aload 8
    //   684: astore 13
    //   686: aload 8
    //   688: astore 9
    //   690: aload_1
    //   691: astore 12
    //   693: aload 11
    //   695: invokevirtual 279	java/io/OutputStream:close	()V
    //   698: aload_1
    //   699: ifnull +7 -> 706
    //   702: aload_1
    //   703: invokevirtual 279	java/io/OutputStream:close	()V
    //   706: aload 8
    //   708: ifnull +8 -> 716
    //   711: aload 8
    //   713: invokevirtual 280	java/io/InputStream:close	()V
    //   716: aload_2
    //   717: astore_1
    //   718: aload_0
    //   719: getfield 120	com/tencent/mm/plugin/qqmail/b/af:nfp	Lcom/tencent/mm/network/u;
    //   722: ifnull +15 -> 737
    //   725: aload_0
    //   726: getfield 120	com/tencent/mm/plugin/qqmail/b/af:nfp	Lcom/tencent/mm/network/u;
    //   729: getfield 284	com/tencent/mm/network/u:aRG	Ljava/net/HttpURLConnection;
    //   732: invokevirtual 289	java/net/HttpURLConnection:disconnect	()V
    //   735: aload_2
    //   736: astore_1
    //   737: aload_1
    //   738: areturn
    //   739: aconst_null
    //   740: astore 8
    //   742: goto -684 -> 58
    //   745: ldc_w 291
    //   748: astore_1
    //   749: goto -650 -> 99
    //   752: iconst_0
    //   753: istore 6
    //   755: goto -374 -> 381
    //   758: aload 9
    //   760: astore 11
    //   762: aload 12
    //   764: astore 10
    //   766: aload_3
    //   767: getfield 14	com/tencent/mm/plugin/qqmail/b/n$b:ndL	Ljava/util/Map;
    //   770: ldc 232
    //   772: invokeinterface 65 2 0
    //   777: checkcast 293	java/io/Serializable
    //   780: astore_3
    //   781: goto -272 -> 509
    //   784: aload 9
    //   786: astore 11
    //   788: aload 12
    //   790: astore 10
    //   792: new 295	java/io/ByteArrayOutputStream
    //   795: dup
    //   796: invokespecial 296	java/io/ByteArrayOutputStream:<init>	()V
    //   799: astore_3
    //   800: goto -256 -> 544
    //   803: aload_3
    //   804: astore 11
    //   806: aload_3
    //   807: astore 10
    //   809: aload 15
    //   811: invokestatic 300	com/tencent/mm/plugin/qqmail/b/af:Lh	(Ljava/lang/String;)Ljava/util/Map;
    //   814: astore 9
    //   816: iload 6
    //   818: ifeq +133 -> 951
    //   821: ldc 46
    //   823: astore 4
    //   825: aload_3
    //   826: astore 11
    //   828: aload_3
    //   829: astore 10
    //   831: new 273	com/tencent/mm/plugin/qqmail/b/n$c
    //   834: dup
    //   835: iload 5
    //   837: aload 9
    //   839: aload 4
    //   841: invokespecial 276	com/tencent/mm/plugin/qqmail/b/n$c:<init>	(ILjava/util/Map;Ljava/lang/String;)V
    //   844: astore 4
    //   846: aload_3
    //   847: astore 11
    //   849: aload_3
    //   850: astore 10
    //   852: ldc 89
    //   854: new 16	java/lang/StringBuilder
    //   857: dup
    //   858: ldc 91
    //   860: invokespecial 94	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   863: aload_2
    //   864: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   867: ldc 96
    //   869: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   872: aload 4
    //   874: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   877: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   880: invokestatic 105	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   883: aload 8
    //   885: astore 13
    //   887: aload 8
    //   889: astore 9
    //   891: aload_1
    //   892: astore 12
    //   894: aload_3
    //   895: invokevirtual 194	java/io/OutputStream:flush	()V
    //   898: aload 8
    //   900: astore 13
    //   902: aload 8
    //   904: astore 9
    //   906: aload_1
    //   907: astore 12
    //   909: aload_3
    //   910: invokevirtual 279	java/io/OutputStream:close	()V
    //   913: aload_1
    //   914: ifnull +7 -> 921
    //   917: aload_1
    //   918: invokevirtual 279	java/io/OutputStream:close	()V
    //   921: aload 8
    //   923: ifnull +8 -> 931
    //   926: aload 8
    //   928: invokevirtual 280	java/io/InputStream:close	()V
    //   931: aload_0
    //   932: getfield 120	com/tencent/mm/plugin/qqmail/b/af:nfp	Lcom/tencent/mm/network/u;
    //   935: ifnull +13 -> 948
    //   938: aload_0
    //   939: getfield 120	com/tencent/mm/plugin/qqmail/b/af:nfp	Lcom/tencent/mm/network/u;
    //   942: getfield 284	com/tencent/mm/network/u:aRG	Ljava/net/HttpURLConnection;
    //   945: invokevirtual 289	java/net/HttpURLConnection:disconnect	()V
    //   948: aload 4
    //   950: areturn
    //   951: aload_3
    //   952: astore 11
    //   954: aload_3
    //   955: astore 10
    //   957: new 44	java/lang/String
    //   960: dup
    //   961: aload_3
    //   962: checkcast 295	java/io/ByteArrayOutputStream
    //   965: invokevirtual 303	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   968: invokespecial 305	java/lang/String:<init>	([B)V
    //   971: astore 4
    //   973: goto -148 -> 825
    //   976: astore_1
    //   977: ldc 89
    //   979: aload_1
    //   980: ldc 46
    //   982: iconst_0
    //   983: anewarray 267	java/lang/Object
    //   986: invokestatic 271	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   989: goto -68 -> 921
    //   992: astore_1
    //   993: ldc 89
    //   995: aload_1
    //   996: ldc 46
    //   998: iconst_0
    //   999: anewarray 267	java/lang/Object
    //   1002: invokestatic 271	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1005: goto -74 -> 931
    //   1008: sipush 500
    //   1011: istore 6
    //   1013: goto -368 -> 645
    //   1016: astore_1
    //   1017: ldc 89
    //   1019: aload_1
    //   1020: ldc 46
    //   1022: iconst_0
    //   1023: anewarray 267	java/lang/Object
    //   1026: invokestatic 271	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1029: goto -323 -> 706
    //   1032: astore_1
    //   1033: ldc 89
    //   1035: aload_1
    //   1036: ldc 46
    //   1038: iconst_0
    //   1039: anewarray 267	java/lang/Object
    //   1042: invokestatic 271	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1045: goto -329 -> 716
    //   1048: astore_2
    //   1049: aload 10
    //   1051: ifnull +35 -> 1086
    //   1054: aload 8
    //   1056: astore 13
    //   1058: aload 8
    //   1060: astore 9
    //   1062: aload_1
    //   1063: astore 12
    //   1065: aload 10
    //   1067: invokevirtual 194	java/io/OutputStream:flush	()V
    //   1070: aload 8
    //   1072: astore 13
    //   1074: aload 8
    //   1076: astore 9
    //   1078: aload_1
    //   1079: astore 12
    //   1081: aload 10
    //   1083: invokevirtual 279	java/io/OutputStream:close	()V
    //   1086: aload 8
    //   1088: astore 13
    //   1090: aload 8
    //   1092: astore 9
    //   1094: aload_1
    //   1095: astore 12
    //   1097: aload_2
    //   1098: athrow
    //   1099: astore_3
    //   1100: aload 13
    //   1102: astore_2
    //   1103: aload_2
    //   1104: astore 9
    //   1106: aload_1
    //   1107: astore 12
    //   1109: ldc 89
    //   1111: aload_3
    //   1112: ldc 46
    //   1114: iconst_0
    //   1115: anewarray 267	java/lang/Object
    //   1118: invokestatic 271	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1121: iload 5
    //   1123: ifne +63 -> 1186
    //   1126: sipush 503
    //   1129: istore 5
    //   1131: aload_2
    //   1132: astore 9
    //   1134: aload_1
    //   1135: astore 12
    //   1137: new 273	com/tencent/mm/plugin/qqmail/b/n$c
    //   1140: dup
    //   1141: iload 5
    //   1143: aconst_null
    //   1144: aconst_null
    //   1145: invokespecial 276	com/tencent/mm/plugin/qqmail/b/n$c:<init>	(ILjava/util/Map;Ljava/lang/String;)V
    //   1148: astore_3
    //   1149: aload_1
    //   1150: ifnull +7 -> 1157
    //   1153: aload_1
    //   1154: invokevirtual 279	java/io/OutputStream:close	()V
    //   1157: aload_2
    //   1158: ifnull +7 -> 1165
    //   1161: aload_2
    //   1162: invokevirtual 280	java/io/InputStream:close	()V
    //   1165: aload_3
    //   1166: astore_1
    //   1167: aload_0
    //   1168: getfield 120	com/tencent/mm/plugin/qqmail/b/af:nfp	Lcom/tencent/mm/network/u;
    //   1171: ifnull -434 -> 737
    //   1174: aload_0
    //   1175: getfield 120	com/tencent/mm/plugin/qqmail/b/af:nfp	Lcom/tencent/mm/network/u;
    //   1178: getfield 284	com/tencent/mm/network/u:aRG	Ljava/net/HttpURLConnection;
    //   1181: invokevirtual 289	java/net/HttpURLConnection:disconnect	()V
    //   1184: aload_3
    //   1185: areturn
    //   1186: sipush 500
    //   1189: istore 5
    //   1191: goto -60 -> 1131
    //   1194: astore_1
    //   1195: ldc 89
    //   1197: aload_1
    //   1198: ldc 46
    //   1200: iconst_0
    //   1201: anewarray 267	java/lang/Object
    //   1204: invokestatic 271	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1207: goto -50 -> 1157
    //   1210: astore_1
    //   1211: ldc 89
    //   1213: aload_1
    //   1214: ldc 46
    //   1216: iconst_0
    //   1217: anewarray 267	java/lang/Object
    //   1220: invokestatic 271	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1223: goto -58 -> 1165
    //   1226: astore_1
    //   1227: aload 12
    //   1229: astore_2
    //   1230: aload_2
    //   1231: ifnull +7 -> 1238
    //   1234: aload_2
    //   1235: invokevirtual 279	java/io/OutputStream:close	()V
    //   1238: aload 9
    //   1240: ifnull +8 -> 1248
    //   1243: aload 9
    //   1245: invokevirtual 280	java/io/InputStream:close	()V
    //   1248: aload_0
    //   1249: getfield 120	com/tencent/mm/plugin/qqmail/b/af:nfp	Lcom/tencent/mm/network/u;
    //   1252: ifnull +13 -> 1265
    //   1255: aload_0
    //   1256: getfield 120	com/tencent/mm/plugin/qqmail/b/af:nfp	Lcom/tencent/mm/network/u;
    //   1259: getfield 284	com/tencent/mm/network/u:aRG	Ljava/net/HttpURLConnection;
    //   1262: invokevirtual 289	java/net/HttpURLConnection:disconnect	()V
    //   1265: aload_1
    //   1266: athrow
    //   1267: astore_2
    //   1268: ldc 89
    //   1270: aload_2
    //   1271: ldc 46
    //   1273: iconst_0
    //   1274: anewarray 267	java/lang/Object
    //   1277: invokestatic 271	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1280: goto -42 -> 1238
    //   1283: astore_2
    //   1284: ldc 89
    //   1286: aload_2
    //   1287: ldc 46
    //   1289: iconst_0
    //   1290: anewarray 267	java/lang/Object
    //   1293: invokestatic 271	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1296: goto -48 -> 1248
    //   1299: astore_1
    //   1300: aload 12
    //   1302: astore_2
    //   1303: goto -73 -> 1230
    //   1306: astore_3
    //   1307: aload_1
    //   1308: astore_2
    //   1309: aload_3
    //   1310: astore_1
    //   1311: aload 8
    //   1313: astore 9
    //   1315: goto -85 -> 1230
    //   1318: astore_3
    //   1319: iconst_0
    //   1320: istore 5
    //   1322: aconst_null
    //   1323: astore_1
    //   1324: aload 11
    //   1326: astore_2
    //   1327: goto -224 -> 1103
    //   1330: astore_3
    //   1331: iconst_0
    //   1332: istore 5
    //   1334: aload 11
    //   1336: astore_2
    //   1337: goto -234 -> 1103
    //   1340: astore_3
    //   1341: aload 8
    //   1343: astore_2
    //   1344: goto -241 -> 1103
    //   1347: goto -916 -> 431
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1350	0	this	af
    //   0	1350	1	paramString1	String
    //   0	1350	2	paramString2	String
    //   0	1350	3	paramb	n.b
    //   0	1350	4	parama	n.a
    //   264	1069	5	i	int
    //   379	633	6	j	int
    //   570	18	7	k	int
    //   56	1286	8	localObject1	java.lang.Object
    //   37	1277	9	localObject2	java.lang.Object
    //   43	1039	10	localObject3	java.lang.Object
    //   34	1301	11	localObject4	java.lang.Object
    //   31	1270	12	str1	String
    //   268	833	13	localObject5	java.lang.Object
    //   40	488	14	localStringBuilder	StringBuilder
    //   286	524	15	str2	String
    // Exception table:
    //   from	to	target	type
    //   450	455	618	java/lang/Exception
    //   463	472	618	java/lang/Exception
    //   480	494	618	java/lang/Exception
    //   502	509	618	java/lang/Exception
    //   517	544	618	java/lang/Exception
    //   550	557	618	java/lang/Exception
    //   563	572	618	java/lang/Exception
    //   583	592	618	java/lang/Exception
    //   598	602	618	java/lang/Exception
    //   608	615	618	java/lang/Exception
    //   766	781	618	java/lang/Exception
    //   792	800	618	java/lang/Exception
    //   809	816	618	java/lang/Exception
    //   831	846	618	java/lang/Exception
    //   852	883	618	java/lang/Exception
    //   957	973	618	java/lang/Exception
    //   917	921	976	java/io/IOException
    //   926	931	992	java/io/IOException
    //   702	706	1016	java/io/IOException
    //   711	716	1032	java/io/IOException
    //   450	455	1048	finally
    //   463	472	1048	finally
    //   480	494	1048	finally
    //   502	509	1048	finally
    //   517	544	1048	finally
    //   550	557	1048	finally
    //   563	572	1048	finally
    //   583	592	1048	finally
    //   598	602	1048	finally
    //   608	615	1048	finally
    //   623	635	1048	finally
    //   649	661	1048	finally
    //   766	781	1048	finally
    //   792	800	1048	finally
    //   809	816	1048	finally
    //   831	846	1048	finally
    //   852	883	1048	finally
    //   957	973	1048	finally
    //   277	288	1099	java/lang/Exception
    //   299	310	1099	java/lang/Exception
    //   321	332	1099	java/lang/Exception
    //   348	358	1099	java/lang/Exception
    //   369	378	1099	java/lang/Exception
    //   392	401	1099	java/lang/Exception
    //   677	682	1099	java/lang/Exception
    //   693	698	1099	java/lang/Exception
    //   894	898	1099	java/lang/Exception
    //   909	913	1099	java/lang/Exception
    //   1065	1070	1099	java/lang/Exception
    //   1081	1086	1099	java/lang/Exception
    //   1097	1099	1099	java/lang/Exception
    //   1153	1157	1194	java/io/IOException
    //   1161	1165	1210	java/io/IOException
    //   45	58	1226	finally
    //   58	96	1226	finally
    //   99	212	1226	finally
    //   1234	1238	1267	java/io/IOException
    //   1243	1248	1283	java/io/IOException
    //   219	227	1299	finally
    //   234	239	1299	finally
    //   246	250	1299	finally
    //   257	266	1299	finally
    //   277	288	1299	finally
    //   299	310	1299	finally
    //   321	332	1299	finally
    //   348	358	1299	finally
    //   369	378	1299	finally
    //   392	401	1299	finally
    //   677	682	1299	finally
    //   693	698	1299	finally
    //   894	898	1299	finally
    //   909	913	1299	finally
    //   1065	1070	1299	finally
    //   1081	1086	1299	finally
    //   1097	1099	1299	finally
    //   1109	1121	1299	finally
    //   1137	1149	1299	finally
    //   406	427	1306	finally
    //   45	58	1318	java/lang/Exception
    //   58	96	1318	java/lang/Exception
    //   99	212	1318	java/lang/Exception
    //   219	227	1330	java/lang/Exception
    //   234	239	1330	java/lang/Exception
    //   246	250	1330	java/lang/Exception
    //   257	266	1330	java/lang/Exception
    //   406	427	1340	java/lang/Exception
  }
  
  public final void cancel()
  {
    y.d("MicroMsg.URLConnectionUtil", "cancel conection.");
    if (this.nfp != null) {
      this.nfp.aRG.disconnect();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.af
 * JD-Core Version:    0.7.0.1
 */