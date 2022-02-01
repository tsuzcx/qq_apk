package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.v;
import com.tencent.mm.sdk.platformtools.ac;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class ag
  extends n
{
  private v vVJ;
  
  private static void a(n.b paramb, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(122798);
    if (paramb.vUl == null)
    {
      AppMethodBeat.o(122798);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramb.vUl.keySet().iterator();
    int i = 1;
    if (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      if (i != 0) {}
      for (String str1 = "";; str1 = "&")
      {
        localStringBuilder.append(str1).append(URLEncoder.encode(str2, "utf-8")).append('=').append(URLEncoder.encode((String)paramb.vUl.get(str2), "utf-8"));
        i = 0;
        break;
      }
    }
    paramOutputStream.write(localStringBuilder.toString().getBytes());
    AppMethodBeat.o(122798);
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
    //   32: invokestatic 116	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   51: getfield 120	com/tencent/mm/plugin/qqmail/b/n$b:vUk	I
    //   54: ifne +684 -> 738
    //   57: aload_3
    //   58: getfield 21	com/tencent/mm/plugin/qqmail/b/n$b:vUl	Ljava/util/Map;
    //   61: astore 8
    //   63: aload_0
    //   64: aload_1
    //   65: aload_2
    //   66: aload 8
    //   68: invokestatic 124	com/tencent/mm/plugin/qqmail/b/ag:f	(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;
    //   71: aconst_null
    //   72: invokestatic 129	com/tencent/mm/network/b:a	(Ljava/lang/String;Lcom/tencent/mm/network/b$b;)Lcom/tencent/mm/network/v;
    //   75: putfield 131	com/tencent/mm/plugin/qqmail/b/ag:vVJ	Lcom/tencent/mm/network/v;
    //   78: aload_0
    //   79: getfield 131	com/tencent/mm/plugin/qqmail/b/ag:vVJ	Lcom/tencent/mm/network/v;
    //   82: getstatic 134	com/tencent/mm/plugin/qqmail/b/ag:timeout	I
    //   85: invokevirtual 139	com/tencent/mm/network/v:setConnectTimeout	(I)V
    //   88: aload_0
    //   89: getfield 131	com/tencent/mm/plugin/qqmail/b/ag:vVJ	Lcom/tencent/mm/network/v;
    //   92: astore 8
    //   94: aload_3
    //   95: getfield 120	com/tencent/mm/plugin/qqmail/b/n$b:vUk	I
    //   98: ifne +646 -> 744
    //   101: ldc 141
    //   103: astore_1
    //   104: aload 8
    //   106: aload_1
    //   107: invokevirtual 144	com/tencent/mm/network/v:setRequestMethod	(Ljava/lang/String;)V
    //   110: aload_0
    //   111: getfield 131	com/tencent/mm/plugin/qqmail/b/ag:vVJ	Lcom/tencent/mm/network/v;
    //   114: invokevirtual 147	com/tencent/mm/network/v:aLH	()V
    //   117: aload_0
    //   118: getfield 131	com/tencent/mm/plugin/qqmail/b/ag:vVJ	Lcom/tencent/mm/network/v;
    //   121: invokevirtual 150	com/tencent/mm/network/v:aLI	()V
    //   124: aload_0
    //   125: getfield 131	com/tencent/mm/plugin/qqmail/b/ag:vVJ	Lcom/tencent/mm/network/v;
    //   128: iconst_0
    //   129: invokevirtual 154	com/tencent/mm/network/v:setUseCaches	(Z)V
    //   132: aload_0
    //   133: getfield 131	com/tencent/mm/plugin/qqmail/b/ag:vVJ	Lcom/tencent/mm/network/v;
    //   136: ldc 156
    //   138: getstatic 160	com/tencent/mm/plugin/qqmail/b/ag:userAgent	Ljava/lang/String;
    //   141: invokevirtual 163	com/tencent/mm/network/v:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   144: aload_0
    //   145: getfield 131	com/tencent/mm/plugin/qqmail/b/ag:vVJ	Lcom/tencent/mm/network/v;
    //   148: ldc 165
    //   150: getstatic 168	com/tencent/mm/plugin/qqmail/b/ag:host	Ljava/lang/String;
    //   153: invokevirtual 163	com/tencent/mm/network/v:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: ldc 170
    //   158: ldc 172
    //   160: invokestatic 177	java/lang/System:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   163: pop
    //   164: aload_0
    //   165: getfield 131	com/tencent/mm/plugin/qqmail/b/ag:vVJ	Lcom/tencent/mm/network/v;
    //   168: ldc 179
    //   170: ldc 62
    //   172: invokevirtual 163	com/tencent/mm/network/v:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   175: aload_0
    //   176: getfield 131	com/tencent/mm/plugin/qqmail/b/ag:vVJ	Lcom/tencent/mm/network/v;
    //   179: ldc 181
    //   181: ldc 183
    //   183: invokevirtual 163	com/tencent/mm/network/v:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   186: aload_0
    //   187: getfield 131	com/tencent/mm/plugin/qqmail/b/ag:vVJ	Lcom/tencent/mm/network/v;
    //   190: ldc 185
    //   192: aload_3
    //   193: getfield 188	com/tencent/mm/plugin/qqmail/b/n$b:vUm	Ljava/util/Map;
    //   196: invokestatic 192	com/tencent/mm/plugin/qqmail/b/ag:au	(Ljava/util/Map;)Ljava/lang/String;
    //   199: invokevirtual 163	com/tencent/mm/network/v:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   202: aload_0
    //   203: getfield 131	com/tencent/mm/plugin/qqmail/b/ag:vVJ	Lcom/tencent/mm/network/v;
    //   206: invokevirtual 195	com/tencent/mm/network/v:connect	()V
    //   209: aload_0
    //   210: getfield 131	com/tencent/mm/plugin/qqmail/b/ag:vVJ	Lcom/tencent/mm/network/v;
    //   213: invokevirtual 199	com/tencent/mm/network/v:getOutputStream	()Ljava/io/OutputStream;
    //   216: astore_1
    //   217: aload 14
    //   219: astore 9
    //   221: aload_1
    //   222: astore 12
    //   224: aload_3
    //   225: getfield 120	com/tencent/mm/plugin/qqmail/b/n$b:vUk	I
    //   228: iconst_1
    //   229: if_icmpne +15 -> 244
    //   232: aload 14
    //   234: astore 9
    //   236: aload_1
    //   237: astore 12
    //   239: aload_3
    //   240: aload_1
    //   241: invokestatic 201	com/tencent/mm/plugin/qqmail/b/ag:a	(Lcom/tencent/mm/plugin/qqmail/b/n$b;Ljava/io/OutputStream;)V
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
    //   263: getfield 131	com/tencent/mm/plugin/qqmail/b/ag:vVJ	Lcom/tencent/mm/network/v;
    //   266: invokevirtual 208	com/tencent/mm/network/v:getResponseCode	()I
    //   269: istore 5
    //   271: aload 10
    //   273: astore 13
    //   275: aload 14
    //   277: astore 9
    //   279: aload_1
    //   280: astore 12
    //   282: aload_0
    //   283: getfield 131	com/tencent/mm/plugin/qqmail/b/ag:vVJ	Lcom/tencent/mm/network/v;
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
    //   305: getfield 131	com/tencent/mm/plugin/qqmail/b/ag:vVJ	Lcom/tencent/mm/network/v;
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
    //   327: getfield 131	com/tencent/mm/plugin/qqmail/b/ag:vVJ	Lcom/tencent/mm/network/v;
    //   330: ldc 218
    //   332: invokevirtual 214	com/tencent/mm/network/v:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   335: astore 8
    //   337: aload 8
    //   339: ifnull +412 -> 751
    //   342: aload 10
    //   344: astore 13
    //   346: aload 14
    //   348: astore 9
    //   350: aload_1
    //   351: astore 12
    //   353: aload 8
    //   355: ldc 220
    //   357: invokevirtual 224	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   360: ifeq +391 -> 751
    //   363: aload 10
    //   365: astore 13
    //   367: aload 14
    //   369: astore 9
    //   371: aload_1
    //   372: astore 12
    //   374: aload_2
    //   375: ldc 226
    //   377: invokevirtual 224	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   380: ifeq +371 -> 751
    //   383: iconst_1
    //   384: istore 6
    //   386: aload 10
    //   388: astore 13
    //   390: aload 14
    //   392: astore 9
    //   394: aload_1
    //   395: astore 12
    //   397: aload_0
    //   398: getfield 131	com/tencent/mm/plugin/qqmail/b/ag:vVJ	Lcom/tencent/mm/network/v;
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
    //   444: ifeq +339 -> 783
    //   447: aload 9
    //   449: astore 11
    //   451: aload 12
    //   453: astore 10
    //   455: getstatic 240	com/tencent/mm/plugin/qqmail/b/ag:vUj	Ljava/lang/String;
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
    //   486: getfield 21	com/tencent/mm/plugin/qqmail/b/n$b:vUl	Ljava/util/Map;
    //   489: ldc 242
    //   491: invokeinterface 75 2 0
    //   496: ifnonnull +261 -> 757
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
    //   522: new 254	com/tencent/mm/vfs/e
    //   525: dup
    //   526: aload 13
    //   528: aload 14
    //   530: aload_3
    //   531: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   534: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   537: invokespecial 256	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   540: iconst_1
    //   541: invokestatic 261	com/tencent/mm/vfs/i:d	(Lcom/tencent/mm/vfs/e;Z)Ljava/io/OutputStream;
    //   544: astore_3
    //   545: aload_3
    //   546: astore 11
    //   548: aload_3
    //   549: astore 10
    //   551: sipush 1024
    //   554: newarray byte
    //   556: astore 9
    //   558: aload_3
    //   559: astore 11
    //   561: aload_3
    //   562: astore 10
    //   564: aload 8
    //   566: aload 9
    //   568: invokevirtual 267	java/io/InputStream:read	([B)I
    //   571: istore 7
    //   573: iload 7
    //   575: ifle +227 -> 802
    //   578: aload_3
    //   579: astore 11
    //   581: aload_3
    //   582: astore 10
    //   584: aload_3
    //   585: aload 9
    //   587: iconst_0
    //   588: iload 7
    //   590: invokevirtual 270	java/io/OutputStream:write	([BII)V
    //   593: aload_3
    //   594: astore 11
    //   596: aload_3
    //   597: astore 10
    //   599: aload_3
    //   600: invokevirtual 204	java/io/OutputStream:flush	()V
    //   603: aload_3
    //   604: astore 11
    //   606: aload_3
    //   607: astore 10
    //   609: aload 4
    //   611: invokeinterface 275 1 0
    //   616: goto -58 -> 558
    //   619: astore_2
    //   620: aload 11
    //   622: astore 10
    //   624: ldc 100
    //   626: aload_2
    //   627: ldc 56
    //   629: iconst_0
    //   630: anewarray 277	java/lang/Object
    //   633: invokestatic 281	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   636: iload 5
    //   638: ifne +375 -> 1013
    //   641: sipush 503
    //   644: istore 6
    //   646: aload 11
    //   648: astore 10
    //   650: new 283	com/tencent/mm/plugin/qqmail/b/n$c
    //   653: dup
    //   654: iload 6
    //   656: aconst_null
    //   657: aconst_null
    //   658: invokespecial 286	com/tencent/mm/plugin/qqmail/b/n$c:<init>	(ILjava/util/Map;Ljava/lang/String;)V
    //   661: astore_2
    //   662: aload 11
    //   664: ifnull +35 -> 699
    //   667: aload 8
    //   669: astore 13
    //   671: aload 8
    //   673: astore 9
    //   675: aload_1
    //   676: astore 12
    //   678: aload 11
    //   680: invokevirtual 204	java/io/OutputStream:flush	()V
    //   683: aload 8
    //   685: astore 13
    //   687: aload 8
    //   689: astore 9
    //   691: aload_1
    //   692: astore 12
    //   694: aload 11
    //   696: invokevirtual 289	java/io/OutputStream:close	()V
    //   699: aload_1
    //   700: ifnull +7 -> 707
    //   703: aload_1
    //   704: invokevirtual 289	java/io/OutputStream:close	()V
    //   707: aload 8
    //   709: ifnull +8 -> 717
    //   712: aload 8
    //   714: invokevirtual 290	java/io/InputStream:close	()V
    //   717: aload_0
    //   718: getfield 131	com/tencent/mm/plugin/qqmail/b/ag:vVJ	Lcom/tencent/mm/network/v;
    //   721: ifnull +10 -> 731
    //   724: aload_0
    //   725: getfield 131	com/tencent/mm/plugin/qqmail/b/ag:vVJ	Lcom/tencent/mm/network/v;
    //   728: invokevirtual 293	com/tencent/mm/network/v:disconnect	()V
    //   731: ldc 98
    //   733: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   736: aload_2
    //   737: areturn
    //   738: aconst_null
    //   739: astore 8
    //   741: goto -678 -> 63
    //   744: ldc_w 295
    //   747: astore_1
    //   748: goto -644 -> 104
    //   751: iconst_0
    //   752: istore 6
    //   754: goto -368 -> 386
    //   757: aload 9
    //   759: astore 11
    //   761: aload 12
    //   763: astore 10
    //   765: aload_3
    //   766: getfield 21	com/tencent/mm/plugin/qqmail/b/n$b:vUl	Ljava/util/Map;
    //   769: ldc 242
    //   771: invokeinterface 75 2 0
    //   776: checkcast 297	java/io/Serializable
    //   779: astore_3
    //   780: goto -266 -> 514
    //   783: aload 9
    //   785: astore 11
    //   787: aload 12
    //   789: astore 10
    //   791: new 299	java/io/ByteArrayOutputStream
    //   794: dup
    //   795: invokespecial 300	java/io/ByteArrayOutputStream:<init>	()V
    //   798: astore_3
    //   799: goto -254 -> 545
    //   802: aload_3
    //   803: astore 11
    //   805: aload_3
    //   806: astore 10
    //   808: aload 15
    //   810: invokestatic 304	com/tencent/mm/plugin/qqmail/b/ag:apT	(Ljava/lang/String;)Ljava/util/Map;
    //   813: astore 9
    //   815: iload 6
    //   817: ifeq +139 -> 956
    //   820: ldc 56
    //   822: astore 4
    //   824: aload_3
    //   825: astore 11
    //   827: aload_3
    //   828: astore 10
    //   830: new 283	com/tencent/mm/plugin/qqmail/b/n$c
    //   833: dup
    //   834: iload 5
    //   836: aload 9
    //   838: aload 4
    //   840: invokespecial 286	com/tencent/mm/plugin/qqmail/b/n$c:<init>	(ILjava/util/Map;Ljava/lang/String;)V
    //   843: astore 4
    //   845: aload_3
    //   846: astore 11
    //   848: aload_3
    //   849: astore 10
    //   851: ldc 100
    //   853: new 26	java/lang/StringBuilder
    //   856: dup
    //   857: ldc 102
    //   859: invokespecial 105	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   862: aload_2
    //   863: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   866: ldc 107
    //   868: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   871: aload 4
    //   873: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   876: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   879: invokestatic 116	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   882: aload_3
    //   883: ifnull +33 -> 916
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
    //   935: getfield 131	com/tencent/mm/plugin/qqmail/b/ag:vVJ	Lcom/tencent/mm/network/v;
    //   938: ifnull +10 -> 948
    //   941: aload_0
    //   942: getfield 131	com/tencent/mm/plugin/qqmail/b/ag:vVJ	Lcom/tencent/mm/network/v;
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
    //   978: goto -154 -> 824
    //   981: astore_1
    //   982: ldc 100
    //   984: aload_1
    //   985: ldc 56
    //   987: iconst_0
    //   988: anewarray 277	java/lang/Object
    //   991: invokestatic 281	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   994: goto -70 -> 924
    //   997: astore_1
    //   998: ldc 100
    //   1000: aload_1
    //   1001: ldc 56
    //   1003: iconst_0
    //   1004: anewarray 277	java/lang/Object
    //   1007: invokestatic 281	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1010: goto -76 -> 934
    //   1013: sipush 500
    //   1016: istore 6
    //   1018: goto -372 -> 646
    //   1021: astore_1
    //   1022: ldc 100
    //   1024: aload_1
    //   1025: ldc 56
    //   1027: iconst_0
    //   1028: anewarray 277	java/lang/Object
    //   1031: invokestatic 281	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1034: goto -327 -> 707
    //   1037: astore_1
    //   1038: ldc 100
    //   1040: aload_1
    //   1041: ldc 56
    //   1043: iconst_0
    //   1044: anewarray 277	java/lang/Object
    //   1047: invokestatic 281	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1050: goto -333 -> 717
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
    //   1139: invokestatic 281	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   1187: getfield 131	com/tencent/mm/plugin/qqmail/b/ag:vVJ	Lcom/tencent/mm/network/v;
    //   1190: ifnull +10 -> 1200
    //   1193: aload_0
    //   1194: getfield 131	com/tencent/mm/plugin/qqmail/b/ag:vVJ	Lcom/tencent/mm/network/v;
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
    //   1225: invokestatic 281	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1228: goto -50 -> 1178
    //   1231: astore_1
    //   1232: ldc 100
    //   1234: aload_1
    //   1235: ldc 56
    //   1237: iconst_0
    //   1238: anewarray 277	java/lang/Object
    //   1241: invokestatic 281	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   1270: getfield 131	com/tencent/mm/plugin/qqmail/b/ag:vVJ	Lcom/tencent/mm/network/v;
    //   1273: ifnull +10 -> 1283
    //   1276: aload_0
    //   1277: getfield 131	com/tencent/mm/plugin/qqmail/b/ag:vVJ	Lcom/tencent/mm/network/v;
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
    //   1300: invokestatic 281	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1303: goto -44 -> 1259
    //   1306: astore_2
    //   1307: ldc 100
    //   1309: aload_2
    //   1310: ldc 56
    //   1312: iconst_0
    //   1313: anewarray 277	java/lang/Object
    //   1316: invokestatic 281	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   0	1373	0	this	ag
    //   0	1373	1	paramString1	String
    //   0	1373	2	paramString2	String
    //   0	1373	3	paramb	n.b
    //   0	1373	4	parama	n.a
    //   269	1087	5	i	int
    //   384	633	6	j	int
    //   571	18	7	k	int
    //   61	1304	8	localObject1	java.lang.Object
    //   42	1295	9	localObject2	java.lang.Object
    //   48	1039	10	localObject3	java.lang.Object
    //   39	1319	11	localObject4	java.lang.Object
    //   36	1288	12	str1	String
    //   273	849	13	localObject5	java.lang.Object
    //   45	484	14	localStringBuilder	StringBuilder
    //   291	518	15	str2	String
    // Exception table:
    //   from	to	target	type
    //   455	460	619	java/lang/Exception
    //   468	477	619	java/lang/Exception
    //   485	499	619	java/lang/Exception
    //   507	514	619	java/lang/Exception
    //   522	545	619	java/lang/Exception
    //   551	558	619	java/lang/Exception
    //   564	573	619	java/lang/Exception
    //   584	593	619	java/lang/Exception
    //   599	603	619	java/lang/Exception
    //   609	616	619	java/lang/Exception
    //   765	780	619	java/lang/Exception
    //   791	799	619	java/lang/Exception
    //   808	815	619	java/lang/Exception
    //   830	845	619	java/lang/Exception
    //   851	882	619	java/lang/Exception
    //   962	978	619	java/lang/Exception
    //   920	924	981	java/io/IOException
    //   929	934	997	java/io/IOException
    //   703	707	1021	java/io/IOException
    //   712	717	1037	java/io/IOException
    //   455	460	1053	finally
    //   468	477	1053	finally
    //   485	499	1053	finally
    //   507	514	1053	finally
    //   522	545	1053	finally
    //   551	558	1053	finally
    //   564	573	1053	finally
    //   584	593	1053	finally
    //   599	603	1053	finally
    //   609	616	1053	finally
    //   624	636	1053	finally
    //   650	662	1053	finally
    //   765	780	1053	finally
    //   791	799	1053	finally
    //   808	815	1053	finally
    //   830	845	1053	finally
    //   851	882	1053	finally
    //   962	978	1053	finally
    //   282	293	1120	java/lang/Exception
    //   304	315	1120	java/lang/Exception
    //   326	337	1120	java/lang/Exception
    //   353	363	1120	java/lang/Exception
    //   374	383	1120	java/lang/Exception
    //   397	406	1120	java/lang/Exception
    //   678	683	1120	java/lang/Exception
    //   694	699	1120	java/lang/Exception
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
    //   678	683	1322	finally
    //   694	699	1322	finally
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
    AppMethodBeat.i(122797);
    ac.d("MicroMsg.URLConnectionUtil", "cancel conection.");
    if (this.vVJ != null) {
      this.vVJ.disconnect();
    }
    AppMethodBeat.o(122797);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.ag
 * JD-Core Version:    0.7.0.1
 */