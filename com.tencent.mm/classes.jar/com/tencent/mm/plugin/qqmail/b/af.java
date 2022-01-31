package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.v;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class af
  extends n
{
  private v pKE;
  
  private static void a(n.b paramb, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(68072);
    if (paramb.pJb == null)
    {
      AppMethodBeat.o(68072);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramb.pJb.keySet().iterator();
    int i = 1;
    if (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      if (i != 0) {}
      for (String str1 = "";; str1 = "&")
      {
        localStringBuilder.append(str1).append(URLEncoder.encode(str2, "utf-8")).append('=').append(URLEncoder.encode((String)paramb.pJb.get(str2), "utf-8"));
        i = 0;
        break;
      }
    }
    paramOutputStream.write(localStringBuilder.toString().getBytes());
    AppMethodBeat.o(68072);
  }
  
  /* Error */
  public final n.c a(String paramString1, String paramString2, n.b paramb, n.a parama)
  {
    // Byte code:
    //   0: ldc 98
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 100
    //   7: new 26	java/lang/StringBuilder
    //   10: dup
    //   11: ldc 102
    //   13: invokespecial 105	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   16: aload_2
    //   17: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: ldc 107
    //   22: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_3
    //   26: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 116	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: aconst_null
    //   36: astore 12
    //   38: aconst_null
    //   39: astore 11
    //   41: aconst_null
    //   42: astore 9
    //   44: aconst_null
    //   45: astore 14
    //   47: aconst_null
    //   48: astore 10
    //   50: aload_3
    //   51: getfield 120	com/tencent/mm/plugin/qqmail/b/n$b:pJa	I
    //   54: ifne +688 -> 742
    //   57: aload_3
    //   58: getfield 21	com/tencent/mm/plugin/qqmail/b/n$b:pJb	Ljava/util/Map;
    //   61: astore 8
    //   63: aload_0
    //   64: aload_1
    //   65: aload_2
    //   66: aload 8
    //   68: invokestatic 124	com/tencent/mm/plugin/qqmail/b/af:f	(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;
    //   71: aconst_null
    //   72: invokestatic 129	com/tencent/mm/network/b:a	(Ljava/lang/String;Lcom/tencent/mm/network/b$b;)Lcom/tencent/mm/network/v;
    //   75: putfield 131	com/tencent/mm/plugin/qqmail/b/af:pKE	Lcom/tencent/mm/network/v;
    //   78: aload_0
    //   79: getfield 131	com/tencent/mm/plugin/qqmail/b/af:pKE	Lcom/tencent/mm/network/v;
    //   82: getstatic 134	com/tencent/mm/plugin/qqmail/b/af:eBM	I
    //   85: invokevirtual 139	com/tencent/mm/network/v:setConnectTimeout	(I)V
    //   88: aload_0
    //   89: getfield 131	com/tencent/mm/plugin/qqmail/b/af:pKE	Lcom/tencent/mm/network/v;
    //   92: astore 8
    //   94: aload_3
    //   95: getfield 120	com/tencent/mm/plugin/qqmail/b/n$b:pJa	I
    //   98: ifne +650 -> 748
    //   101: ldc 141
    //   103: astore_1
    //   104: aload 8
    //   106: aload_1
    //   107: invokevirtual 144	com/tencent/mm/network/v:setRequestMethod	(Ljava/lang/String;)V
    //   110: aload_0
    //   111: getfield 131	com/tencent/mm/plugin/qqmail/b/af:pKE	Lcom/tencent/mm/network/v;
    //   114: invokevirtual 147	com/tencent/mm/network/v:anq	()V
    //   117: aload_0
    //   118: getfield 131	com/tencent/mm/plugin/qqmail/b/af:pKE	Lcom/tencent/mm/network/v;
    //   121: invokevirtual 150	com/tencent/mm/network/v:anr	()V
    //   124: aload_0
    //   125: getfield 131	com/tencent/mm/plugin/qqmail/b/af:pKE	Lcom/tencent/mm/network/v;
    //   128: iconst_0
    //   129: invokevirtual 154	com/tencent/mm/network/v:setUseCaches	(Z)V
    //   132: aload_0
    //   133: getfield 131	com/tencent/mm/plugin/qqmail/b/af:pKE	Lcom/tencent/mm/network/v;
    //   136: ldc 156
    //   138: getstatic 160	com/tencent/mm/plugin/qqmail/b/af:userAgent	Ljava/lang/String;
    //   141: invokevirtual 163	com/tencent/mm/network/v:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   144: aload_0
    //   145: getfield 131	com/tencent/mm/plugin/qqmail/b/af:pKE	Lcom/tencent/mm/network/v;
    //   148: ldc 165
    //   150: getstatic 168	com/tencent/mm/plugin/qqmail/b/af:host	Ljava/lang/String;
    //   153: invokevirtual 163	com/tencent/mm/network/v:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: ldc 170
    //   158: ldc 172
    //   160: invokestatic 177	java/lang/System:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   163: pop
    //   164: aload_0
    //   165: getfield 131	com/tencent/mm/plugin/qqmail/b/af:pKE	Lcom/tencent/mm/network/v;
    //   168: ldc 179
    //   170: ldc 62
    //   172: invokevirtual 163	com/tencent/mm/network/v:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   175: aload_0
    //   176: getfield 131	com/tencent/mm/plugin/qqmail/b/af:pKE	Lcom/tencent/mm/network/v;
    //   179: ldc 181
    //   181: ldc 183
    //   183: invokevirtual 163	com/tencent/mm/network/v:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   186: aload_0
    //   187: getfield 131	com/tencent/mm/plugin/qqmail/b/af:pKE	Lcom/tencent/mm/network/v;
    //   190: ldc 185
    //   192: aload_3
    //   193: getfield 188	com/tencent/mm/plugin/qqmail/b/n$b:pJc	Ljava/util/Map;
    //   196: invokestatic 192	com/tencent/mm/plugin/qqmail/b/af:W	(Ljava/util/Map;)Ljava/lang/String;
    //   199: invokevirtual 163	com/tencent/mm/network/v:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   202: aload_0
    //   203: getfield 131	com/tencent/mm/plugin/qqmail/b/af:pKE	Lcom/tencent/mm/network/v;
    //   206: invokevirtual 195	com/tencent/mm/network/v:connect	()V
    //   209: aload_0
    //   210: getfield 131	com/tencent/mm/plugin/qqmail/b/af:pKE	Lcom/tencent/mm/network/v;
    //   213: invokevirtual 199	com/tencent/mm/network/v:getOutputStream	()Ljava/io/OutputStream;
    //   216: astore_1
    //   217: aload 14
    //   219: astore 9
    //   221: aload_1
    //   222: astore 12
    //   224: aload_3
    //   225: getfield 120	com/tencent/mm/plugin/qqmail/b/n$b:pJa	I
    //   228: iconst_1
    //   229: if_icmpne +15 -> 244
    //   232: aload 14
    //   234: astore 9
    //   236: aload_1
    //   237: astore 12
    //   239: aload_3
    //   240: aload_1
    //   241: invokestatic 201	com/tencent/mm/plugin/qqmail/b/af:a	(Lcom/tencent/mm/plugin/qqmail/b/n$b;Ljava/io/OutputStream;)V
    //   244: aload 14
    //   246: astore 9
    //   248: aload_1
    //   249: astore 12
    //   251: aload_1
    //   252: invokevirtual 204	java/io/OutputStream:flush	()V
    //   255: aload 14
    //   257: astore 9
    //   259: aload_1
    //   260: astore 12
    //   262: aload_0
    //   263: getfield 131	com/tencent/mm/plugin/qqmail/b/af:pKE	Lcom/tencent/mm/network/v;
    //   266: invokevirtual 208	com/tencent/mm/network/v:getResponseCode	()I
    //   269: istore 5
    //   271: aload 10
    //   273: astore 13
    //   275: aload 14
    //   277: astore 9
    //   279: aload_1
    //   280: astore 12
    //   282: aload_0
    //   283: getfield 131	com/tencent/mm/plugin/qqmail/b/af:pKE	Lcom/tencent/mm/network/v;
    //   286: ldc 210
    //   288: invokevirtual 214	com/tencent/mm/network/v:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   291: astore 15
    //   293: aload 10
    //   295: astore 13
    //   297: aload 14
    //   299: astore 9
    //   301: aload_1
    //   302: astore 12
    //   304: aload_0
    //   305: getfield 131	com/tencent/mm/plugin/qqmail/b/af:pKE	Lcom/tencent/mm/network/v;
    //   308: ldc 216
    //   310: invokevirtual 214	com/tencent/mm/network/v:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   313: astore 11
    //   315: aload 10
    //   317: astore 13
    //   319: aload 14
    //   321: astore 9
    //   323: aload_1
    //   324: astore 12
    //   326: aload_0
    //   327: getfield 131	com/tencent/mm/plugin/qqmail/b/af:pKE	Lcom/tencent/mm/network/v;
    //   330: ldc 218
    //   332: invokevirtual 214	com/tencent/mm/network/v:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   335: astore 8
    //   337: aload 8
    //   339: ifnull +416 -> 755
    //   342: aload 10
    //   344: astore 13
    //   346: aload 14
    //   348: astore 9
    //   350: aload_1
    //   351: astore 12
    //   353: aload 8
    //   355: ldc 220
    //   357: invokevirtual 224	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   360: ifeq +395 -> 755
    //   363: aload 10
    //   365: astore 13
    //   367: aload 14
    //   369: astore 9
    //   371: aload_1
    //   372: astore 12
    //   374: aload_2
    //   375: ldc 226
    //   377: invokevirtual 224	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   380: ifeq +375 -> 755
    //   383: iconst_1
    //   384: istore 6
    //   386: aload 10
    //   388: astore 13
    //   390: aload 14
    //   392: astore 9
    //   394: aload_1
    //   395: astore 12
    //   397: aload_0
    //   398: getfield 131	com/tencent/mm/plugin/qqmail/b/af:pKE	Lcom/tencent/mm/network/v;
    //   401: invokevirtual 230	com/tencent/mm/network/v:getInputStream	()Ljava/io/InputStream;
    //   404: astore 8
    //   406: aload 11
    //   408: ifnull +962 -> 1370
    //   411: aload 11
    //   413: ldc 232
    //   415: invokevirtual 224	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   418: ifeq +952 -> 1370
    //   421: new 234	java/util/zip/GZIPInputStream
    //   424: dup
    //   425: aload 8
    //   427: invokespecial 237	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   430: astore 9
    //   432: aload 9
    //   434: astore 8
    //   436: aconst_null
    //   437: astore 12
    //   439: aconst_null
    //   440: astore 9
    //   442: iload 6
    //   444: ifeq +343 -> 787
    //   447: aload 9
    //   449: astore 11
    //   451: aload 12
    //   453: astore 10
    //   455: getstatic 240	com/tencent/mm/plugin/qqmail/b/af:pIZ	Ljava/lang/String;
    //   458: astore 13
    //   460: aload 9
    //   462: astore 11
    //   464: aload 12
    //   466: astore 10
    //   468: new 26	java/lang/StringBuilder
    //   471: dup
    //   472: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   475: astore 14
    //   477: aload 9
    //   479: astore 11
    //   481: aload 12
    //   483: astore 10
    //   485: aload_3
    //   486: getfield 21	com/tencent/mm/plugin/qqmail/b/n$b:pJb	Ljava/util/Map;
    //   489: ldc 242
    //   491: invokeinterface 75 2 0
    //   496: ifnonnull +265 -> 761
    //   499: aload 9
    //   501: astore 11
    //   503: aload 12
    //   505: astore 10
    //   507: invokestatic 246	java/lang/System:currentTimeMillis	()J
    //   510: invokestatic 252	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   513: astore_3
    //   514: aload 9
    //   516: astore 11
    //   518: aload 12
    //   520: astore 10
    //   522: new 254	java/io/FileOutputStream
    //   525: dup
    //   526: new 256	java/io/File
    //   529: dup
    //   530: aload 13
    //   532: aload 14
    //   534: aload_3
    //   535: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   538: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   541: invokespecial 258	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   544: iconst_1
    //   545: invokespecial 261	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   548: astore_3
    //   549: aload_3
    //   550: astore 11
    //   552: aload_3
    //   553: astore 10
    //   555: sipush 1024
    //   558: newarray byte
    //   560: astore 9
    //   562: aload_3
    //   563: astore 11
    //   565: aload_3
    //   566: astore 10
    //   568: aload 8
    //   570: aload 9
    //   572: invokevirtual 267	java/io/InputStream:read	([B)I
    //   575: istore 7
    //   577: iload 7
    //   579: ifle +227 -> 806
    //   582: aload_3
    //   583: astore 11
    //   585: aload_3
    //   586: astore 10
    //   588: aload_3
    //   589: aload 9
    //   591: iconst_0
    //   592: iload 7
    //   594: invokevirtual 270	java/io/OutputStream:write	([BII)V
    //   597: aload_3
    //   598: astore 11
    //   600: aload_3
    //   601: astore 10
    //   603: aload_3
    //   604: invokevirtual 204	java/io/OutputStream:flush	()V
    //   607: aload_3
    //   608: astore 11
    //   610: aload_3
    //   611: astore 10
    //   613: aload 4
    //   615: invokeinterface 275 1 0
    //   620: goto -58 -> 562
    //   623: astore_2
    //   624: aload 11
    //   626: astore 10
    //   628: ldc 100
    //   630: aload_2
    //   631: ldc 56
    //   633: iconst_0
    //   634: anewarray 277	java/lang/Object
    //   637: invokestatic 281	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   640: iload 5
    //   642: ifne +371 -> 1013
    //   645: sipush 503
    //   648: istore 6
    //   650: aload 11
    //   652: astore 10
    //   654: new 283	com/tencent/mm/plugin/qqmail/b/n$c
    //   657: dup
    //   658: iload 6
    //   660: aconst_null
    //   661: aconst_null
    //   662: invokespecial 286	com/tencent/mm/plugin/qqmail/b/n$c:<init>	(ILjava/util/Map;Ljava/lang/String;)V
    //   665: astore_2
    //   666: aload 11
    //   668: ifnull +35 -> 703
    //   671: aload 8
    //   673: astore 13
    //   675: aload 8
    //   677: astore 9
    //   679: aload_1
    //   680: astore 12
    //   682: aload 11
    //   684: invokevirtual 204	java/io/OutputStream:flush	()V
    //   687: aload 8
    //   689: astore 13
    //   691: aload 8
    //   693: astore 9
    //   695: aload_1
    //   696: astore 12
    //   698: aload 11
    //   700: invokevirtual 289	java/io/OutputStream:close	()V
    //   703: aload_1
    //   704: ifnull +7 -> 711
    //   707: aload_1
    //   708: invokevirtual 289	java/io/OutputStream:close	()V
    //   711: aload 8
    //   713: ifnull +8 -> 721
    //   716: aload 8
    //   718: invokevirtual 290	java/io/InputStream:close	()V
    //   721: aload_0
    //   722: getfield 131	com/tencent/mm/plugin/qqmail/b/af:pKE	Lcom/tencent/mm/network/v;
    //   725: ifnull +10 -> 735
    //   728: aload_0
    //   729: getfield 131	com/tencent/mm/plugin/qqmail/b/af:pKE	Lcom/tencent/mm/network/v;
    //   732: invokevirtual 293	com/tencent/mm/network/v:disconnect	()V
    //   735: ldc 98
    //   737: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   740: aload_2
    //   741: areturn
    //   742: aconst_null
    //   743: astore 8
    //   745: goto -682 -> 63
    //   748: ldc_w 295
    //   751: astore_1
    //   752: goto -648 -> 104
    //   755: iconst_0
    //   756: istore 6
    //   758: goto -372 -> 386
    //   761: aload 9
    //   763: astore 11
    //   765: aload 12
    //   767: astore 10
    //   769: aload_3
    //   770: getfield 21	com/tencent/mm/plugin/qqmail/b/n$b:pJb	Ljava/util/Map;
    //   773: ldc 242
    //   775: invokeinterface 75 2 0
    //   780: checkcast 297	java/io/Serializable
    //   783: astore_3
    //   784: goto -270 -> 514
    //   787: aload 9
    //   789: astore 11
    //   791: aload 12
    //   793: astore 10
    //   795: new 299	java/io/ByteArrayOutputStream
    //   798: dup
    //   799: invokespecial 300	java/io/ByteArrayOutputStream:<init>	()V
    //   802: astore_3
    //   803: goto -254 -> 549
    //   806: aload_3
    //   807: astore 11
    //   809: aload_3
    //   810: astore 10
    //   812: aload 15
    //   814: invokestatic 304	com/tencent/mm/plugin/qqmail/b/af:Xr	(Ljava/lang/String;)Ljava/util/Map;
    //   817: astore 9
    //   819: iload 6
    //   821: ifeq +135 -> 956
    //   824: ldc 56
    //   826: astore 4
    //   828: aload_3
    //   829: astore 11
    //   831: aload_3
    //   832: astore 10
    //   834: new 283	com/tencent/mm/plugin/qqmail/b/n$c
    //   837: dup
    //   838: iload 5
    //   840: aload 9
    //   842: aload 4
    //   844: invokespecial 286	com/tencent/mm/plugin/qqmail/b/n$c:<init>	(ILjava/util/Map;Ljava/lang/String;)V
    //   847: astore 4
    //   849: aload_3
    //   850: astore 11
    //   852: aload_3
    //   853: astore 10
    //   855: ldc 100
    //   857: new 26	java/lang/StringBuilder
    //   860: dup
    //   861: ldc 102
    //   863: invokespecial 105	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   866: aload_2
    //   867: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   870: ldc 107
    //   872: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   875: aload 4
    //   877: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   880: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   883: invokestatic 116	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   886: aload 8
    //   888: astore 13
    //   890: aload 8
    //   892: astore 9
    //   894: aload_1
    //   895: astore 12
    //   897: aload_3
    //   898: invokevirtual 204	java/io/OutputStream:flush	()V
    //   901: aload 8
    //   903: astore 13
    //   905: aload 8
    //   907: astore 9
    //   909: aload_1
    //   910: astore 12
    //   912: aload_3
    //   913: invokevirtual 289	java/io/OutputStream:close	()V
    //   916: aload_1
    //   917: ifnull +7 -> 924
    //   920: aload_1
    //   921: invokevirtual 289	java/io/OutputStream:close	()V
    //   924: aload 8
    //   926: ifnull +8 -> 934
    //   929: aload 8
    //   931: invokevirtual 290	java/io/InputStream:close	()V
    //   934: aload_0
    //   935: getfield 131	com/tencent/mm/plugin/qqmail/b/af:pKE	Lcom/tencent/mm/network/v;
    //   938: ifnull +10 -> 948
    //   941: aload_0
    //   942: getfield 131	com/tencent/mm/plugin/qqmail/b/af:pKE	Lcom/tencent/mm/network/v;
    //   945: invokevirtual 293	com/tencent/mm/network/v:disconnect	()V
    //   948: ldc 98
    //   950: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   953: aload 4
    //   955: areturn
    //   956: aload_3
    //   957: astore 11
    //   959: aload_3
    //   960: astore 10
    //   962: new 54	java/lang/String
    //   965: dup
    //   966: aload_3
    //   967: checkcast 299	java/io/ByteArrayOutputStream
    //   970: invokevirtual 307	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   973: invokespecial 309	java/lang/String:<init>	([B)V
    //   976: astore 4
    //   978: goto -150 -> 828
    //   981: astore_1
    //   982: ldc 100
    //   984: aload_1
    //   985: ldc 56
    //   987: iconst_0
    //   988: anewarray 277	java/lang/Object
    //   991: invokestatic 281	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   994: goto -70 -> 924
    //   997: astore_1
    //   998: ldc 100
    //   1000: aload_1
    //   1001: ldc 56
    //   1003: iconst_0
    //   1004: anewarray 277	java/lang/Object
    //   1007: invokestatic 281	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1010: goto -76 -> 934
    //   1013: sipush 500
    //   1016: istore 6
    //   1018: goto -368 -> 650
    //   1021: astore_1
    //   1022: ldc 100
    //   1024: aload_1
    //   1025: ldc 56
    //   1027: iconst_0
    //   1028: anewarray 277	java/lang/Object
    //   1031: invokestatic 281	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1034: goto -323 -> 711
    //   1037: astore_1
    //   1038: ldc 100
    //   1040: aload_1
    //   1041: ldc 56
    //   1043: iconst_0
    //   1044: anewarray 277	java/lang/Object
    //   1047: invokestatic 281	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1050: goto -329 -> 721
    //   1053: astore_2
    //   1054: aload 10
    //   1056: ifnull +35 -> 1091
    //   1059: aload 8
    //   1061: astore 13
    //   1063: aload 8
    //   1065: astore 9
    //   1067: aload_1
    //   1068: astore 12
    //   1070: aload 10
    //   1072: invokevirtual 204	java/io/OutputStream:flush	()V
    //   1075: aload 8
    //   1077: astore 13
    //   1079: aload 8
    //   1081: astore 9
    //   1083: aload_1
    //   1084: astore 12
    //   1086: aload 10
    //   1088: invokevirtual 289	java/io/OutputStream:close	()V
    //   1091: aload 8
    //   1093: astore 13
    //   1095: aload 8
    //   1097: astore 9
    //   1099: aload_1
    //   1100: astore 12
    //   1102: ldc 98
    //   1104: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1107: aload 8
    //   1109: astore 13
    //   1111: aload 8
    //   1113: astore 9
    //   1115: aload_1
    //   1116: astore 12
    //   1118: aload_2
    //   1119: athrow
    //   1120: astore_3
    //   1121: aload 13
    //   1123: astore_2
    //   1124: aload_2
    //   1125: astore 9
    //   1127: aload_1
    //   1128: astore 12
    //   1130: ldc 100
    //   1132: aload_3
    //   1133: ldc 56
    //   1135: iconst_0
    //   1136: anewarray 277	java/lang/Object
    //   1139: invokestatic 281	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1142: iload 5
    //   1144: ifne +63 -> 1207
    //   1147: sipush 503
    //   1150: istore 5
    //   1152: aload_2
    //   1153: astore 9
    //   1155: aload_1
    //   1156: astore 12
    //   1158: new 283	com/tencent/mm/plugin/qqmail/b/n$c
    //   1161: dup
    //   1162: iload 5
    //   1164: aconst_null
    //   1165: aconst_null
    //   1166: invokespecial 286	com/tencent/mm/plugin/qqmail/b/n$c:<init>	(ILjava/util/Map;Ljava/lang/String;)V
    //   1169: astore_3
    //   1170: aload_1
    //   1171: ifnull +7 -> 1178
    //   1174: aload_1
    //   1175: invokevirtual 289	java/io/OutputStream:close	()V
    //   1178: aload_2
    //   1179: ifnull +7 -> 1186
    //   1182: aload_2
    //   1183: invokevirtual 290	java/io/InputStream:close	()V
    //   1186: aload_0
    //   1187: getfield 131	com/tencent/mm/plugin/qqmail/b/af:pKE	Lcom/tencent/mm/network/v;
    //   1190: ifnull +10 -> 1200
    //   1193: aload_0
    //   1194: getfield 131	com/tencent/mm/plugin/qqmail/b/af:pKE	Lcom/tencent/mm/network/v;
    //   1197: invokevirtual 293	com/tencent/mm/network/v:disconnect	()V
    //   1200: ldc 98
    //   1202: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1205: aload_3
    //   1206: areturn
    //   1207: sipush 500
    //   1210: istore 5
    //   1212: goto -60 -> 1152
    //   1215: astore_1
    //   1216: ldc 100
    //   1218: aload_1
    //   1219: ldc 56
    //   1221: iconst_0
    //   1222: anewarray 277	java/lang/Object
    //   1225: invokestatic 281	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1228: goto -50 -> 1178
    //   1231: astore_1
    //   1232: ldc 100
    //   1234: aload_1
    //   1235: ldc 56
    //   1237: iconst_0
    //   1238: anewarray 277	java/lang/Object
    //   1241: invokestatic 281	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1244: goto -58 -> 1186
    //   1247: astore_1
    //   1248: aload 12
    //   1250: astore_2
    //   1251: aload_2
    //   1252: ifnull +7 -> 1259
    //   1255: aload_2
    //   1256: invokevirtual 289	java/io/OutputStream:close	()V
    //   1259: aload 9
    //   1261: ifnull +8 -> 1269
    //   1264: aload 9
    //   1266: invokevirtual 290	java/io/InputStream:close	()V
    //   1269: aload_0
    //   1270: getfield 131	com/tencent/mm/plugin/qqmail/b/af:pKE	Lcom/tencent/mm/network/v;
    //   1273: ifnull +10 -> 1283
    //   1276: aload_0
    //   1277: getfield 131	com/tencent/mm/plugin/qqmail/b/af:pKE	Lcom/tencent/mm/network/v;
    //   1280: invokevirtual 293	com/tencent/mm/network/v:disconnect	()V
    //   1283: ldc 98
    //   1285: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1288: aload_1
    //   1289: athrow
    //   1290: astore_2
    //   1291: ldc 100
    //   1293: aload_2
    //   1294: ldc 56
    //   1296: iconst_0
    //   1297: anewarray 277	java/lang/Object
    //   1300: invokestatic 281	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1303: goto -44 -> 1259
    //   1306: astore_2
    //   1307: ldc 100
    //   1309: aload_2
    //   1310: ldc 56
    //   1312: iconst_0
    //   1313: anewarray 277	java/lang/Object
    //   1316: invokestatic 281	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1319: goto -50 -> 1269
    //   1322: astore_1
    //   1323: aload 12
    //   1325: astore_2
    //   1326: goto -75 -> 1251
    //   1329: astore_3
    //   1330: aload_1
    //   1331: astore_2
    //   1332: aload_3
    //   1333: astore_1
    //   1334: aload 8
    //   1336: astore 9
    //   1338: goto -87 -> 1251
    //   1341: astore_3
    //   1342: iconst_0
    //   1343: istore 5
    //   1345: aconst_null
    //   1346: astore_1
    //   1347: aload 11
    //   1349: astore_2
    //   1350: goto -226 -> 1124
    //   1353: astore_3
    //   1354: iconst_0
    //   1355: istore 5
    //   1357: aload 11
    //   1359: astore_2
    //   1360: goto -236 -> 1124
    //   1363: astore_3
    //   1364: aload 8
    //   1366: astore_2
    //   1367: goto -243 -> 1124
    //   1370: goto -934 -> 436
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1373	0	this	af
    //   0	1373	1	paramString1	String
    //   0	1373	2	paramString2	String
    //   0	1373	3	paramb	n.b
    //   0	1373	4	parama	n.a
    //   269	1087	5	i	int
    //   384	633	6	j	int
    //   575	18	7	k	int
    //   61	1304	8	localObject1	java.lang.Object
    //   42	1295	9	localObject2	java.lang.Object
    //   48	1039	10	localObject3	java.lang.Object
    //   39	1319	11	localObject4	java.lang.Object
    //   36	1288	12	str1	String
    //   273	849	13	localObject5	java.lang.Object
    //   45	488	14	localStringBuilder	StringBuilder
    //   291	522	15	str2	String
    // Exception table:
    //   from	to	target	type
    //   455	460	623	java/lang/Exception
    //   468	477	623	java/lang/Exception
    //   485	499	623	java/lang/Exception
    //   507	514	623	java/lang/Exception
    //   522	549	623	java/lang/Exception
    //   555	562	623	java/lang/Exception
    //   568	577	623	java/lang/Exception
    //   588	597	623	java/lang/Exception
    //   603	607	623	java/lang/Exception
    //   613	620	623	java/lang/Exception
    //   769	784	623	java/lang/Exception
    //   795	803	623	java/lang/Exception
    //   812	819	623	java/lang/Exception
    //   834	849	623	java/lang/Exception
    //   855	886	623	java/lang/Exception
    //   962	978	623	java/lang/Exception
    //   920	924	981	java/io/IOException
    //   929	934	997	java/io/IOException
    //   707	711	1021	java/io/IOException
    //   716	721	1037	java/io/IOException
    //   455	460	1053	finally
    //   468	477	1053	finally
    //   485	499	1053	finally
    //   507	514	1053	finally
    //   522	549	1053	finally
    //   555	562	1053	finally
    //   568	577	1053	finally
    //   588	597	1053	finally
    //   603	607	1053	finally
    //   613	620	1053	finally
    //   628	640	1053	finally
    //   654	666	1053	finally
    //   769	784	1053	finally
    //   795	803	1053	finally
    //   812	819	1053	finally
    //   834	849	1053	finally
    //   855	886	1053	finally
    //   962	978	1053	finally
    //   282	293	1120	java/lang/Exception
    //   304	315	1120	java/lang/Exception
    //   326	337	1120	java/lang/Exception
    //   353	363	1120	java/lang/Exception
    //   374	383	1120	java/lang/Exception
    //   397	406	1120	java/lang/Exception
    //   682	687	1120	java/lang/Exception
    //   698	703	1120	java/lang/Exception
    //   897	901	1120	java/lang/Exception
    //   912	916	1120	java/lang/Exception
    //   1070	1075	1120	java/lang/Exception
    //   1086	1091	1120	java/lang/Exception
    //   1102	1107	1120	java/lang/Exception
    //   1118	1120	1120	java/lang/Exception
    //   1174	1178	1215	java/io/IOException
    //   1182	1186	1231	java/io/IOException
    //   50	63	1247	finally
    //   63	101	1247	finally
    //   104	217	1247	finally
    //   1255	1259	1290	java/io/IOException
    //   1264	1269	1306	java/io/IOException
    //   224	232	1322	finally
    //   239	244	1322	finally
    //   251	255	1322	finally
    //   262	271	1322	finally
    //   282	293	1322	finally
    //   304	315	1322	finally
    //   326	337	1322	finally
    //   353	363	1322	finally
    //   374	383	1322	finally
    //   397	406	1322	finally
    //   682	687	1322	finally
    //   698	703	1322	finally
    //   897	901	1322	finally
    //   912	916	1322	finally
    //   1070	1075	1322	finally
    //   1086	1091	1322	finally
    //   1102	1107	1322	finally
    //   1118	1120	1322	finally
    //   1130	1142	1322	finally
    //   1158	1170	1322	finally
    //   411	432	1329	finally
    //   50	63	1341	java/lang/Exception
    //   63	101	1341	java/lang/Exception
    //   104	217	1341	java/lang/Exception
    //   224	232	1353	java/lang/Exception
    //   239	244	1353	java/lang/Exception
    //   251	255	1353	java/lang/Exception
    //   262	271	1353	java/lang/Exception
    //   411	432	1363	java/lang/Exception
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(68071);
    ab.d("MicroMsg.URLConnectionUtil", "cancel conection.");
    if (this.pKE != null) {
      this.pKE.disconnect();
    }
    AppMethodBeat.o(68071);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.af
 * JD-Core Version:    0.7.0.1
 */