package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

public final class g
  extends c
{
  private a Qdf;
  
  public g(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2, a parama)
  {
    this.url = paramString1;
    this.filePath = paramString2;
    this.QWQ = paramBoolean;
    this.QWR = paramInt1;
    this.scene = paramInt2;
    this.Qdf = parama;
  }
  
  private int getMediaType()
  {
    int i = 1;
    switch (this.QWR)
    {
    default: 
      i = 0;
    case 41: 
    case 44: 
    case 45: 
    case 133: 
    case 1000000001: 
      return i;
    case 61: 
      return 2;
    }
    return 3;
  }
  
  /* Error */
  private String hkA()
  {
    // Byte code:
    //   0: ldc 44
    //   2: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 21	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/g:filePath	Ljava/lang/String;
    //   9: invokestatic 56	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   12: ifeq +10 -> 22
    //   15: ldc 44
    //   17: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: aconst_null
    //   21: areturn
    //   22: invokestatic 65	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   25: invokestatic 71	com/tencent/mm/sdk/platformtools/NetStatusUtil:getFormatedNetType	(Landroid/content/Context;)Ljava/lang/String;
    //   28: astore 14
    //   30: ldc 73
    //   32: new 75	java/lang/StringBuilder
    //   35: dup
    //   36: ldc 77
    //   38: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   41: aload 14
    //   43: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: ldc 86
    //   48: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: aload_0
    //   52: getfield 18	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/g:url	Ljava/lang/String;
    //   55: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 94	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   64: invokestatic 100	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   67: lstore 6
    //   69: iconst_0
    //   70: istore 4
    //   72: iconst_0
    //   73: istore_2
    //   74: iconst_0
    //   75: istore_3
    //   76: iconst_0
    //   77: istore 5
    //   79: iconst_0
    //   80: istore_1
    //   81: aload_0
    //   82: getfield 21	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/g:filePath	Ljava/lang/String;
    //   85: iconst_0
    //   86: aload_0
    //   87: getfield 21	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/g:filePath	Ljava/lang/String;
    //   90: ldc 102
    //   92: invokevirtual 108	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   95: invokevirtual 112	java/lang/String:substring	(II)Ljava/lang/String;
    //   98: invokestatic 115	com/tencent/mm/vfs/y:bDX	(Ljava/lang/String;)Z
    //   101: pop
    //   102: aconst_null
    //   103: astore 13
    //   105: aconst_null
    //   106: astore 8
    //   108: aconst_null
    //   109: astore 11
    //   111: aconst_null
    //   112: astore 9
    //   114: aconst_null
    //   115: astore 12
    //   117: aload_0
    //   118: getfield 34	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/g:Qdf	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/g$a;
    //   121: invokeinterface 118 1 0
    //   126: new 120	java/net/URL
    //   129: dup
    //   130: aload_0
    //   131: getfield 18	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/g:url	Ljava/lang/String;
    //   134: invokespecial 121	java/net/URL:<init>	(Ljava/lang/String;)V
    //   137: invokevirtual 125	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   140: checkcast 127	java/net/HttpURLConnection
    //   143: astore 10
    //   145: aload 11
    //   147: astore 9
    //   149: aload 13
    //   151: astore 8
    //   153: iload 5
    //   155: istore_3
    //   156: iload 4
    //   158: istore_2
    //   159: aload 10
    //   161: sipush 10000
    //   164: invokevirtual 130	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   167: aload 11
    //   169: astore 9
    //   171: aload 13
    //   173: astore 8
    //   175: iload 5
    //   177: istore_3
    //   178: iload 4
    //   180: istore_2
    //   181: aload 10
    //   183: sipush 10000
    //   186: invokevirtual 133	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   189: aload 11
    //   191: astore 9
    //   193: aload 13
    //   195: astore 8
    //   197: iload 5
    //   199: istore_3
    //   200: iload 4
    //   202: istore_2
    //   203: aload 10
    //   205: invokevirtual 136	java/net/HttpURLConnection:connect	()V
    //   208: aload 11
    //   210: astore 9
    //   212: aload 13
    //   214: astore 8
    //   216: iload 5
    //   218: istore_3
    //   219: iload 4
    //   221: istore_2
    //   222: aload 10
    //   224: invokevirtual 139	java/net/HttpURLConnection:getResponseCode	()I
    //   227: istore 4
    //   229: iload 4
    //   231: sipush 200
    //   234: if_icmpeq +395 -> 629
    //   237: aload 11
    //   239: astore 9
    //   241: aload 13
    //   243: astore 8
    //   245: iload 5
    //   247: istore_3
    //   248: iload 4
    //   250: istore_2
    //   251: new 75	java/lang/StringBuilder
    //   254: dup
    //   255: ldc 141
    //   257: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   260: aload 10
    //   262: invokevirtual 139	java/net/HttpURLConnection:getResponseCode	()I
    //   265: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   268: ldc 146
    //   270: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: aload 14
    //   275: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: ldc 148
    //   280: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: aload 10
    //   285: invokevirtual 151	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
    //   288: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   294: astore 11
    //   296: aload 10
    //   298: invokevirtual 155	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   301: invokevirtual 160	java/io/InputStream:close	()V
    //   304: aload 10
    //   306: ifnull +8 -> 314
    //   309: aload 10
    //   311: invokevirtual 163	java/net/HttpURLConnection:disconnect	()V
    //   314: aload_0
    //   315: getfield 18	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/g:url	Ljava/lang/String;
    //   318: invokestatic 169	com/tencent/mm/sdk/platformtools/MD5Util:getMD5String	(Ljava/lang/String;)Ljava/lang/String;
    //   321: astore 9
    //   323: aload_0
    //   324: invokespecial 171	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/g:getMediaType	()I
    //   327: istore_1
    //   328: lload 6
    //   330: invokestatic 175	com/tencent/mm/sdk/platformtools/Util:milliSecondsToNow	(J)J
    //   333: l2i
    //   334: istore_2
    //   335: new 177	com/tencent/mm/modelsns/n
    //   338: dup
    //   339: invokespecial 178	com/tencent/mm/modelsns/n:<init>	()V
    //   342: astore 8
    //   344: aload 8
    //   346: ldc 180
    //   348: new 75	java/lang/StringBuilder
    //   351: dup
    //   352: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   355: aload 9
    //   357: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: ldc 183
    //   362: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   368: invokevirtual 187	com/tencent/mm/modelsns/n:s	(Ljava/lang/String;Ljava/lang/Object;)V
    //   371: aload 8
    //   373: ldc 189
    //   375: new 75	java/lang/StringBuilder
    //   378: dup
    //   379: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   382: iload_1
    //   383: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   386: ldc 183
    //   388: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   394: invokevirtual 187	com/tencent/mm/modelsns/n:s	(Ljava/lang/String;Ljava/lang/Object;)V
    //   397: new 75	java/lang/StringBuilder
    //   400: dup
    //   401: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   404: astore 9
    //   406: aload_0
    //   407: getfield 25	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/g:QWQ	Z
    //   410: ifeq +214 -> 624
    //   413: iconst_1
    //   414: istore_1
    //   415: aload 8
    //   417: ldc 191
    //   419: aload 9
    //   421: iload_1
    //   422: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   425: ldc 183
    //   427: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   433: invokevirtual 187	com/tencent/mm/modelsns/n:s	(Ljava/lang/String;Ljava/lang/Object;)V
    //   436: aload 8
    //   438: ldc 193
    //   440: new 75	java/lang/StringBuilder
    //   443: dup
    //   444: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   447: iload_2
    //   448: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   451: ldc 183
    //   453: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   459: invokevirtual 187	com/tencent/mm/modelsns/n:s	(Ljava/lang/String;Ljava/lang/Object;)V
    //   462: aload 8
    //   464: ldc 195
    //   466: new 75	java/lang/StringBuilder
    //   469: dup
    //   470: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   473: iload 4
    //   475: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   478: ldc 183
    //   480: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   486: invokevirtual 187	com/tencent/mm/modelsns/n:s	(Ljava/lang/String;Ljava/lang/Object;)V
    //   489: aload 8
    //   491: ldc 197
    //   493: new 75	java/lang/StringBuilder
    //   496: dup
    //   497: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   500: aload_0
    //   501: getfield 32	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/g:scene	I
    //   504: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   507: ldc 183
    //   509: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   515: invokevirtual 187	com/tencent/mm/modelsns/n:s	(Ljava/lang/String;Ljava/lang/Object;)V
    //   518: aload 8
    //   520: ldc 199
    //   522: ldc 201
    //   524: invokevirtual 187	com/tencent/mm/modelsns/n:s	(Ljava/lang/String;Ljava/lang/Object;)V
    //   527: aload 8
    //   529: ldc 203
    //   531: new 75	java/lang/StringBuilder
    //   534: dup
    //   535: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   538: lload 6
    //   540: ldc2_w 204
    //   543: ldiv
    //   544: invokevirtual 208	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   547: ldc 183
    //   549: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   555: invokevirtual 187	com/tencent/mm/modelsns/n:s	(Ljava/lang/String;Ljava/lang/Object;)V
    //   558: ldc 73
    //   560: new 75	java/lang/StringBuilder
    //   563: dup
    //   564: ldc 210
    //   566: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   569: aload 8
    //   571: invokevirtual 213	com/tencent/mm/modelsns/n:aIF	()Ljava/lang/String;
    //   574: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   580: invokestatic 94	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   583: getstatic 219	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   586: sipush 13572
    //   589: iconst_1
    //   590: anewarray 221	java/lang/Object
    //   593: dup
    //   594: iconst_0
    //   595: aload 8
    //   597: aastore
    //   598: invokevirtual 225	com/tencent/mm/plugin/report/service/h:b	(I[Ljava/lang/Object;)V
    //   601: ldc 44
    //   603: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   606: aload 11
    //   608: areturn
    //   609: astore 8
    //   611: ldc 73
    //   613: aload 8
    //   615: invokevirtual 228	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   618: invokestatic 231	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   621: goto -317 -> 304
    //   624: iconst_0
    //   625: istore_1
    //   626: goto -211 -> 415
    //   629: aload 11
    //   631: astore 9
    //   633: aload 13
    //   635: astore 8
    //   637: iload 5
    //   639: istore_3
    //   640: iload 4
    //   642: istore_2
    //   643: aload 10
    //   645: invokevirtual 234	java/net/HttpURLConnection:getContentLength	()I
    //   648: pop
    //   649: aload 11
    //   651: astore 9
    //   653: aload 13
    //   655: astore 8
    //   657: iload 5
    //   659: istore_3
    //   660: iload 4
    //   662: istore_2
    //   663: aload 10
    //   665: invokevirtual 155	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   668: astore 12
    //   670: aload 11
    //   672: astore 9
    //   674: aload 12
    //   676: astore 8
    //   678: iload 5
    //   680: istore_3
    //   681: iload 4
    //   683: istore_2
    //   684: aload_0
    //   685: getfield 21	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/g:filePath	Ljava/lang/String;
    //   688: iconst_0
    //   689: invokestatic 238	com/tencent/mm/vfs/y:ev	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   692: astore 11
    //   694: aload 11
    //   696: astore 9
    //   698: aload 12
    //   700: astore 8
    //   702: iload 5
    //   704: istore_3
    //   705: iload 4
    //   707: istore_2
    //   708: sipush 4096
    //   711: newarray byte
    //   713: astore 13
    //   715: aload 11
    //   717: astore 9
    //   719: aload 12
    //   721: astore 8
    //   723: iload_1
    //   724: istore_3
    //   725: iload 4
    //   727: istore_2
    //   728: aload 12
    //   730: aload 13
    //   732: invokevirtual 242	java/io/InputStream:read	([B)I
    //   735: istore 5
    //   737: iload 5
    //   739: iconst_m1
    //   740: if_icmpeq +441 -> 1181
    //   743: aload 11
    //   745: astore 9
    //   747: aload 12
    //   749: astore 8
    //   751: iload_1
    //   752: istore_3
    //   753: iload 4
    //   755: istore_2
    //   756: aload_0
    //   757: invokevirtual 246	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/g:isCancelled	()Z
    //   760: ifeq +390 -> 1150
    //   763: aload 11
    //   765: astore 9
    //   767: aload 12
    //   769: astore 8
    //   771: iload_1
    //   772: istore_3
    //   773: iload 4
    //   775: istore_2
    //   776: aload 12
    //   778: invokevirtual 160	java/io/InputStream:close	()V
    //   781: aload 11
    //   783: ifnull +8 -> 791
    //   786: aload 11
    //   788: invokevirtual 249	java/io/OutputStream:close	()V
    //   791: aload 12
    //   793: ifnull +8 -> 801
    //   796: aload 12
    //   798: invokevirtual 160	java/io/InputStream:close	()V
    //   801: aload 10
    //   803: invokevirtual 155	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   806: invokevirtual 160	java/io/InputStream:close	()V
    //   809: aload 10
    //   811: ifnull +8 -> 819
    //   814: aload 10
    //   816: invokevirtual 163	java/net/HttpURLConnection:disconnect	()V
    //   819: aload_0
    //   820: getfield 18	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/g:url	Ljava/lang/String;
    //   823: invokestatic 169	com/tencent/mm/sdk/platformtools/MD5Util:getMD5String	(Ljava/lang/String;)Ljava/lang/String;
    //   826: astore 9
    //   828: aload_0
    //   829: invokespecial 171	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/g:getMediaType	()I
    //   832: istore_2
    //   833: lload 6
    //   835: invokestatic 175	com/tencent/mm/sdk/platformtools/Util:milliSecondsToNow	(J)J
    //   838: l2i
    //   839: istore_3
    //   840: new 177	com/tencent/mm/modelsns/n
    //   843: dup
    //   844: invokespecial 178	com/tencent/mm/modelsns/n:<init>	()V
    //   847: astore 8
    //   849: aload 8
    //   851: ldc 180
    //   853: new 75	java/lang/StringBuilder
    //   856: dup
    //   857: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   860: aload 9
    //   862: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   865: ldc 183
    //   867: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   870: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   873: invokevirtual 187	com/tencent/mm/modelsns/n:s	(Ljava/lang/String;Ljava/lang/Object;)V
    //   876: aload 8
    //   878: ldc 189
    //   880: new 75	java/lang/StringBuilder
    //   883: dup
    //   884: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   887: iload_2
    //   888: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   891: ldc 183
    //   893: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   896: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   899: invokevirtual 187	com/tencent/mm/modelsns/n:s	(Ljava/lang/String;Ljava/lang/Object;)V
    //   902: new 75	java/lang/StringBuilder
    //   905: dup
    //   906: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   909: astore 9
    //   911: aload_0
    //   912: getfield 25	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/g:QWQ	Z
    //   915: ifeq +230 -> 1145
    //   918: iconst_1
    //   919: istore_2
    //   920: aload 8
    //   922: ldc 191
    //   924: aload 9
    //   926: iload_2
    //   927: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   930: ldc 183
    //   932: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   935: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   938: invokevirtual 187	com/tencent/mm/modelsns/n:s	(Ljava/lang/String;Ljava/lang/Object;)V
    //   941: aload 8
    //   943: ldc 193
    //   945: new 75	java/lang/StringBuilder
    //   948: dup
    //   949: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   952: iload_3
    //   953: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   956: ldc 183
    //   958: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   961: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   964: invokevirtual 187	com/tencent/mm/modelsns/n:s	(Ljava/lang/String;Ljava/lang/Object;)V
    //   967: aload 8
    //   969: ldc 195
    //   971: new 75	java/lang/StringBuilder
    //   974: dup
    //   975: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   978: iload 4
    //   980: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   983: ldc 183
    //   985: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   988: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   991: invokevirtual 187	com/tencent/mm/modelsns/n:s	(Ljava/lang/String;Ljava/lang/Object;)V
    //   994: aload 8
    //   996: ldc 197
    //   998: new 75	java/lang/StringBuilder
    //   1001: dup
    //   1002: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   1005: aload_0
    //   1006: getfield 32	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/g:scene	I
    //   1009: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1012: ldc 183
    //   1014: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1017: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1020: invokevirtual 187	com/tencent/mm/modelsns/n:s	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1023: aload 8
    //   1025: ldc 199
    //   1027: new 75	java/lang/StringBuilder
    //   1030: dup
    //   1031: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   1034: iload_1
    //   1035: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1038: ldc 183
    //   1040: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1043: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1046: invokevirtual 187	com/tencent/mm/modelsns/n:s	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1049: aload 8
    //   1051: ldc 203
    //   1053: new 75	java/lang/StringBuilder
    //   1056: dup
    //   1057: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   1060: lload 6
    //   1062: ldc2_w 204
    //   1065: ldiv
    //   1066: invokevirtual 208	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1069: ldc 183
    //   1071: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1074: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1077: invokevirtual 187	com/tencent/mm/modelsns/n:s	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1080: ldc 73
    //   1082: new 75	java/lang/StringBuilder
    //   1085: dup
    //   1086: ldc 210
    //   1088: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1091: aload 8
    //   1093: invokevirtual 213	com/tencent/mm/modelsns/n:aIF	()Ljava/lang/String;
    //   1096: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1099: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1102: invokestatic 94	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1105: getstatic 219	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   1108: sipush 13572
    //   1111: iconst_1
    //   1112: anewarray 221	java/lang/Object
    //   1115: dup
    //   1116: iconst_0
    //   1117: aload 8
    //   1119: aastore
    //   1120: invokevirtual 225	com/tencent/mm/plugin/report/service/h:b	(I[Ljava/lang/Object;)V
    //   1123: ldc 44
    //   1125: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1128: aconst_null
    //   1129: areturn
    //   1130: astore 8
    //   1132: ldc 73
    //   1134: aload 8
    //   1136: invokevirtual 228	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1139: invokestatic 231	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1142: goto -333 -> 809
    //   1145: iconst_0
    //   1146: istore_2
    //   1147: goto -227 -> 920
    //   1150: aload 11
    //   1152: astore 9
    //   1154: aload 12
    //   1156: astore 8
    //   1158: iload_1
    //   1159: istore_3
    //   1160: iload 4
    //   1162: istore_2
    //   1163: aload 11
    //   1165: aload 13
    //   1167: iconst_0
    //   1168: iload 5
    //   1170: invokevirtual 253	java/io/OutputStream:write	([BII)V
    //   1173: iload_1
    //   1174: iload 5
    //   1176: iadd
    //   1177: istore_1
    //   1178: goto -463 -> 715
    //   1181: aload 11
    //   1183: ifnull +8 -> 1191
    //   1186: aload 11
    //   1188: invokevirtual 249	java/io/OutputStream:close	()V
    //   1191: aload 12
    //   1193: ifnull +8 -> 1201
    //   1196: aload 12
    //   1198: invokevirtual 160	java/io/InputStream:close	()V
    //   1201: aload 10
    //   1203: invokevirtual 155	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1206: invokevirtual 160	java/io/InputStream:close	()V
    //   1209: aload 10
    //   1211: ifnull +8 -> 1219
    //   1214: aload 10
    //   1216: invokevirtual 163	java/net/HttpURLConnection:disconnect	()V
    //   1219: aload_0
    //   1220: getfield 18	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/g:url	Ljava/lang/String;
    //   1223: invokestatic 169	com/tencent/mm/sdk/platformtools/MD5Util:getMD5String	(Ljava/lang/String;)Ljava/lang/String;
    //   1226: astore 9
    //   1228: aload_0
    //   1229: invokespecial 171	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/g:getMediaType	()I
    //   1232: istore_2
    //   1233: lload 6
    //   1235: invokestatic 175	com/tencent/mm/sdk/platformtools/Util:milliSecondsToNow	(J)J
    //   1238: l2i
    //   1239: istore_3
    //   1240: new 177	com/tencent/mm/modelsns/n
    //   1243: dup
    //   1244: invokespecial 178	com/tencent/mm/modelsns/n:<init>	()V
    //   1247: astore 8
    //   1249: aload 8
    //   1251: ldc 180
    //   1253: new 75	java/lang/StringBuilder
    //   1256: dup
    //   1257: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   1260: aload 9
    //   1262: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1265: ldc 183
    //   1267: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1270: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1273: invokevirtual 187	com/tencent/mm/modelsns/n:s	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1276: aload 8
    //   1278: ldc 189
    //   1280: new 75	java/lang/StringBuilder
    //   1283: dup
    //   1284: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   1287: iload_2
    //   1288: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1291: ldc 183
    //   1293: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1296: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1299: invokevirtual 187	com/tencent/mm/modelsns/n:s	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1302: new 75	java/lang/StringBuilder
    //   1305: dup
    //   1306: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   1309: astore 9
    //   1311: aload_0
    //   1312: getfield 25	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/g:QWQ	Z
    //   1315: ifeq +230 -> 1545
    //   1318: iconst_1
    //   1319: istore_2
    //   1320: aload 8
    //   1322: ldc 191
    //   1324: aload 9
    //   1326: iload_2
    //   1327: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1330: ldc 183
    //   1332: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1335: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1338: invokevirtual 187	com/tencent/mm/modelsns/n:s	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1341: aload 8
    //   1343: ldc 193
    //   1345: new 75	java/lang/StringBuilder
    //   1348: dup
    //   1349: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   1352: iload_3
    //   1353: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1356: ldc 183
    //   1358: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1361: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1364: invokevirtual 187	com/tencent/mm/modelsns/n:s	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1367: aload 8
    //   1369: ldc 195
    //   1371: new 75	java/lang/StringBuilder
    //   1374: dup
    //   1375: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   1378: iload 4
    //   1380: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1383: ldc 183
    //   1385: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1388: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1391: invokevirtual 187	com/tencent/mm/modelsns/n:s	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1394: aload 8
    //   1396: ldc 197
    //   1398: new 75	java/lang/StringBuilder
    //   1401: dup
    //   1402: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   1405: aload_0
    //   1406: getfield 32	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/g:scene	I
    //   1409: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1412: ldc 183
    //   1414: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1417: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1420: invokevirtual 187	com/tencent/mm/modelsns/n:s	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1423: aload 8
    //   1425: ldc 199
    //   1427: new 75	java/lang/StringBuilder
    //   1430: dup
    //   1431: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   1434: iload_1
    //   1435: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1438: ldc 183
    //   1440: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1443: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1446: invokevirtual 187	com/tencent/mm/modelsns/n:s	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1449: aload 8
    //   1451: ldc 203
    //   1453: new 75	java/lang/StringBuilder
    //   1456: dup
    //   1457: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   1460: lload 6
    //   1462: ldc2_w 204
    //   1465: ldiv
    //   1466: invokevirtual 208	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1469: ldc 183
    //   1471: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1474: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1477: invokevirtual 187	com/tencent/mm/modelsns/n:s	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1480: ldc 73
    //   1482: new 75	java/lang/StringBuilder
    //   1485: dup
    //   1486: ldc 210
    //   1488: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1491: aload 8
    //   1493: invokevirtual 213	com/tencent/mm/modelsns/n:aIF	()Ljava/lang/String;
    //   1496: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1499: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1502: invokestatic 94	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1505: getstatic 219	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   1508: sipush 13572
    //   1511: iconst_1
    //   1512: anewarray 221	java/lang/Object
    //   1515: dup
    //   1516: iconst_0
    //   1517: aload 8
    //   1519: aastore
    //   1520: invokevirtual 225	com/tencent/mm/plugin/report/service/h:b	(I[Ljava/lang/Object;)V
    //   1523: ldc 44
    //   1525: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1528: aconst_null
    //   1529: areturn
    //   1530: astore 8
    //   1532: ldc 73
    //   1534: aload 8
    //   1536: invokevirtual 228	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1539: invokestatic 231	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1542: goto -333 -> 1209
    //   1545: iconst_0
    //   1546: istore_2
    //   1547: goto -227 -> 1320
    //   1550: astore 11
    //   1552: aload 12
    //   1554: astore 10
    //   1556: aload_0
    //   1557: getfield 21	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/g:filePath	Ljava/lang/String;
    //   1560: invokestatic 256	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
    //   1563: pop
    //   1564: iconst_m1
    //   1565: istore_2
    //   1566: new 75	java/lang/StringBuilder
    //   1569: dup
    //   1570: ldc_w 258
    //   1573: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1576: aload 14
    //   1578: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1581: ldc_w 260
    //   1584: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1587: aload 11
    //   1589: invokevirtual 263	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1592: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1595: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1598: astore 11
    //   1600: aload 9
    //   1602: ifnull +8 -> 1610
    //   1605: aload 9
    //   1607: invokevirtual 249	java/io/OutputStream:close	()V
    //   1610: aload 8
    //   1612: ifnull +8 -> 1620
    //   1615: aload 8
    //   1617: invokevirtual 160	java/io/InputStream:close	()V
    //   1620: aload 10
    //   1622: invokevirtual 155	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1625: invokevirtual 160	java/io/InputStream:close	()V
    //   1628: aload 10
    //   1630: ifnull +8 -> 1638
    //   1633: aload 10
    //   1635: invokevirtual 163	java/net/HttpURLConnection:disconnect	()V
    //   1638: aload_0
    //   1639: getfield 18	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/g:url	Ljava/lang/String;
    //   1642: invokestatic 169	com/tencent/mm/sdk/platformtools/MD5Util:getMD5String	(Ljava/lang/String;)Ljava/lang/String;
    //   1645: astore 9
    //   1647: aload_0
    //   1648: invokespecial 171	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/g:getMediaType	()I
    //   1651: istore_1
    //   1652: lload 6
    //   1654: invokestatic 175	com/tencent/mm/sdk/platformtools/Util:milliSecondsToNow	(J)J
    //   1657: l2i
    //   1658: istore_2
    //   1659: new 177	com/tencent/mm/modelsns/n
    //   1662: dup
    //   1663: invokespecial 178	com/tencent/mm/modelsns/n:<init>	()V
    //   1666: astore 8
    //   1668: aload 8
    //   1670: ldc 180
    //   1672: new 75	java/lang/StringBuilder
    //   1675: dup
    //   1676: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   1679: aload 9
    //   1681: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1684: ldc 183
    //   1686: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1689: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1692: invokevirtual 187	com/tencent/mm/modelsns/n:s	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1695: aload 8
    //   1697: ldc 189
    //   1699: new 75	java/lang/StringBuilder
    //   1702: dup
    //   1703: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   1706: iload_1
    //   1707: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1710: ldc 183
    //   1712: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1715: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1718: invokevirtual 187	com/tencent/mm/modelsns/n:s	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1721: new 75	java/lang/StringBuilder
    //   1724: dup
    //   1725: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   1728: astore 9
    //   1730: aload_0
    //   1731: getfield 25	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/g:QWQ	Z
    //   1734: ifeq +214 -> 1948
    //   1737: iconst_1
    //   1738: istore_1
    //   1739: aload 8
    //   1741: ldc 191
    //   1743: aload 9
    //   1745: iload_1
    //   1746: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1749: ldc 183
    //   1751: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1754: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1757: invokevirtual 187	com/tencent/mm/modelsns/n:s	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1760: aload 8
    //   1762: ldc 193
    //   1764: new 75	java/lang/StringBuilder
    //   1767: dup
    //   1768: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   1771: iload_2
    //   1772: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1775: ldc 183
    //   1777: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1780: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1783: invokevirtual 187	com/tencent/mm/modelsns/n:s	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1786: aload 8
    //   1788: ldc 195
    //   1790: ldc_w 265
    //   1793: invokevirtual 187	com/tencent/mm/modelsns/n:s	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1796: aload 8
    //   1798: ldc 197
    //   1800: new 75	java/lang/StringBuilder
    //   1803: dup
    //   1804: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   1807: aload_0
    //   1808: getfield 32	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/g:scene	I
    //   1811: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1814: ldc 183
    //   1816: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1819: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1822: invokevirtual 187	com/tencent/mm/modelsns/n:s	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1825: aload 8
    //   1827: ldc 199
    //   1829: new 75	java/lang/StringBuilder
    //   1832: dup
    //   1833: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   1836: iload_3
    //   1837: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1840: ldc 183
    //   1842: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1845: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1848: invokevirtual 187	com/tencent/mm/modelsns/n:s	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1851: aload 8
    //   1853: ldc 203
    //   1855: new 75	java/lang/StringBuilder
    //   1858: dup
    //   1859: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   1862: lload 6
    //   1864: ldc2_w 204
    //   1867: ldiv
    //   1868: invokevirtual 208	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1871: ldc 183
    //   1873: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1876: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1879: invokevirtual 187	com/tencent/mm/modelsns/n:s	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1882: ldc 73
    //   1884: new 75	java/lang/StringBuilder
    //   1887: dup
    //   1888: ldc 210
    //   1890: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1893: aload 8
    //   1895: invokevirtual 213	com/tencent/mm/modelsns/n:aIF	()Ljava/lang/String;
    //   1898: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1901: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1904: invokestatic 94	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1907: getstatic 219	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   1910: sipush 13572
    //   1913: iconst_1
    //   1914: anewarray 221	java/lang/Object
    //   1917: dup
    //   1918: iconst_0
    //   1919: aload 8
    //   1921: aastore
    //   1922: invokevirtual 225	com/tencent/mm/plugin/report/service/h:b	(I[Ljava/lang/Object;)V
    //   1925: ldc 44
    //   1927: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1930: aload 11
    //   1932: areturn
    //   1933: astore 8
    //   1935: ldc 73
    //   1937: aload 8
    //   1939: invokevirtual 228	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1942: invokestatic 231	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1945: goto -317 -> 1628
    //   1948: iconst_0
    //   1949: istore_1
    //   1950: goto -211 -> 1739
    //   1953: astore 11
    //   1955: aload 9
    //   1957: ifnull +8 -> 1965
    //   1960: aload 9
    //   1962: invokevirtual 249	java/io/OutputStream:close	()V
    //   1965: aload 8
    //   1967: ifnull +8 -> 1975
    //   1970: aload 8
    //   1972: invokevirtual 160	java/io/InputStream:close	()V
    //   1975: aload 10
    //   1977: invokevirtual 155	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1980: invokevirtual 160	java/io/InputStream:close	()V
    //   1983: aload 10
    //   1985: ifnull +8 -> 1993
    //   1988: aload 10
    //   1990: invokevirtual 163	java/net/HttpURLConnection:disconnect	()V
    //   1993: aload_0
    //   1994: getfield 18	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/g:url	Ljava/lang/String;
    //   1997: invokestatic 169	com/tencent/mm/sdk/platformtools/MD5Util:getMD5String	(Ljava/lang/String;)Ljava/lang/String;
    //   2000: astore 9
    //   2002: aload_0
    //   2003: invokespecial 171	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/g:getMediaType	()I
    //   2006: istore_1
    //   2007: lload 6
    //   2009: invokestatic 175	com/tencent/mm/sdk/platformtools/Util:milliSecondsToNow	(J)J
    //   2012: l2i
    //   2013: istore 4
    //   2015: new 177	com/tencent/mm/modelsns/n
    //   2018: dup
    //   2019: invokespecial 178	com/tencent/mm/modelsns/n:<init>	()V
    //   2022: astore 8
    //   2024: aload 8
    //   2026: ldc 180
    //   2028: new 75	java/lang/StringBuilder
    //   2031: dup
    //   2032: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   2035: aload 9
    //   2037: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2040: ldc 183
    //   2042: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2045: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2048: invokevirtual 187	com/tencent/mm/modelsns/n:s	(Ljava/lang/String;Ljava/lang/Object;)V
    //   2051: aload 8
    //   2053: ldc 189
    //   2055: new 75	java/lang/StringBuilder
    //   2058: dup
    //   2059: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   2062: iload_1
    //   2063: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2066: ldc 183
    //   2068: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2071: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2074: invokevirtual 187	com/tencent/mm/modelsns/n:s	(Ljava/lang/String;Ljava/lang/Object;)V
    //   2077: new 75	java/lang/StringBuilder
    //   2080: dup
    //   2081: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   2084: astore 9
    //   2086: aload_0
    //   2087: getfield 25	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/g:QWQ	Z
    //   2090: ifeq +231 -> 2321
    //   2093: iconst_1
    //   2094: istore_1
    //   2095: aload 8
    //   2097: ldc 191
    //   2099: aload 9
    //   2101: iload_1
    //   2102: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2105: ldc 183
    //   2107: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2110: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2113: invokevirtual 187	com/tencent/mm/modelsns/n:s	(Ljava/lang/String;Ljava/lang/Object;)V
    //   2116: aload 8
    //   2118: ldc 193
    //   2120: new 75	java/lang/StringBuilder
    //   2123: dup
    //   2124: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   2127: iload 4
    //   2129: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2132: ldc 183
    //   2134: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2137: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2140: invokevirtual 187	com/tencent/mm/modelsns/n:s	(Ljava/lang/String;Ljava/lang/Object;)V
    //   2143: aload 8
    //   2145: ldc 195
    //   2147: new 75	java/lang/StringBuilder
    //   2150: dup
    //   2151: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   2154: iload_2
    //   2155: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2158: ldc 183
    //   2160: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2163: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2166: invokevirtual 187	com/tencent/mm/modelsns/n:s	(Ljava/lang/String;Ljava/lang/Object;)V
    //   2169: aload 8
    //   2171: ldc 197
    //   2173: new 75	java/lang/StringBuilder
    //   2176: dup
    //   2177: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   2180: aload_0
    //   2181: getfield 32	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/g:scene	I
    //   2184: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2187: ldc 183
    //   2189: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2192: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2195: invokevirtual 187	com/tencent/mm/modelsns/n:s	(Ljava/lang/String;Ljava/lang/Object;)V
    //   2198: aload 8
    //   2200: ldc 199
    //   2202: new 75	java/lang/StringBuilder
    //   2205: dup
    //   2206: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   2209: iload_3
    //   2210: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2213: ldc 183
    //   2215: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2218: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2221: invokevirtual 187	com/tencent/mm/modelsns/n:s	(Ljava/lang/String;Ljava/lang/Object;)V
    //   2224: aload 8
    //   2226: ldc 203
    //   2228: new 75	java/lang/StringBuilder
    //   2231: dup
    //   2232: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   2235: lload 6
    //   2237: ldc2_w 204
    //   2240: ldiv
    //   2241: invokevirtual 208	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2244: ldc 183
    //   2246: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2249: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2252: invokevirtual 187	com/tencent/mm/modelsns/n:s	(Ljava/lang/String;Ljava/lang/Object;)V
    //   2255: ldc 73
    //   2257: new 75	java/lang/StringBuilder
    //   2260: dup
    //   2261: ldc 210
    //   2263: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2266: aload 8
    //   2268: invokevirtual 213	com/tencent/mm/modelsns/n:aIF	()Ljava/lang/String;
    //   2271: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2274: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2277: invokestatic 94	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2280: getstatic 219	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   2283: sipush 13572
    //   2286: iconst_1
    //   2287: anewarray 221	java/lang/Object
    //   2290: dup
    //   2291: iconst_0
    //   2292: aload 8
    //   2294: aastore
    //   2295: invokevirtual 225	com/tencent/mm/plugin/report/service/h:b	(I[Ljava/lang/Object;)V
    //   2298: ldc 44
    //   2300: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2303: aload 11
    //   2305: athrow
    //   2306: astore 8
    //   2308: ldc 73
    //   2310: aload 8
    //   2312: invokevirtual 228	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2315: invokestatic 231	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2318: goto -335 -> 1983
    //   2321: iconst_0
    //   2322: istore_1
    //   2323: goto -228 -> 2095
    //   2326: astore 8
    //   2328: goto -353 -> 1975
    //   2331: astore 8
    //   2333: goto -713 -> 1620
    //   2336: astore 11
    //   2338: goto -782 -> 1556
    //   2341: astore 8
    //   2343: goto -1142 -> 1201
    //   2346: astore 8
    //   2348: goto -1547 -> 801
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2351	0	this	g
    //   80	2243	1	i	int
    //   73	2082	2	j	int
    //   75	2135	3	k	int
    //   70	2058	4	m	int
    //   77	1100	5	n	int
    //   67	2169	6	l	long
    //   106	490	8	localObject1	Object
    //   609	5	8	localException1	java.lang.Exception
    //   635	483	8	localObject2	Object
    //   1130	5	8	localException2	java.lang.Exception
    //   1156	362	8	localObject3	Object
    //   1530	86	8	localException3	java.lang.Exception
    //   1666	254	8	localn1	com.tencent.mm.modelsns.n
    //   1933	38	8	localException4	java.lang.Exception
    //   2022	271	8	localn2	com.tencent.mm.modelsns.n
    //   2306	5	8	localException5	java.lang.Exception
    //   2326	1	8	localIOException1	java.io.IOException
    //   2331	1	8	localIOException2	java.io.IOException
    //   2341	1	8	localIOException3	java.io.IOException
    //   2346	1	8	localIOException4	java.io.IOException
    //   112	1988	9	localObject4	Object
    //   143	1846	10	localObject5	Object
    //   109	1078	11	localObject6	Object
    //   1550	38	11	localObject7	Object
    //   1598	333	11	str1	String
    //   1953	351	11	localObject8	Object
    //   2336	1	11	localObject9	Object
    //   115	1438	12	localInputStream	java.io.InputStream
    //   103	1063	13	arrayOfByte	byte[]
    //   28	1549	14	str2	String
    // Exception table:
    //   from	to	target	type
    //   296	304	609	java/lang/Exception
    //   801	809	1130	java/lang/Exception
    //   1201	1209	1530	java/lang/Exception
    //   126	145	1550	finally
    //   1620	1628	1933	java/lang/Exception
    //   1556	1564	1953	finally
    //   1566	1600	1953	finally
    //   1975	1983	2306	java/lang/Exception
    //   1960	1965	2326	java/io/IOException
    //   1970	1975	2326	java/io/IOException
    //   1605	1610	2331	java/io/IOException
    //   1615	1620	2331	java/io/IOException
    //   159	167	2336	finally
    //   181	189	2336	finally
    //   203	208	2336	finally
    //   222	229	2336	finally
    //   251	296	2336	finally
    //   643	649	2336	finally
    //   663	670	2336	finally
    //   684	694	2336	finally
    //   708	715	2336	finally
    //   728	737	2336	finally
    //   756	763	2336	finally
    //   776	781	2336	finally
    //   1163	1173	2336	finally
    //   1186	1191	2341	java/io/IOException
    //   1196	1201	2341	java/io/IOException
    //   786	791	2346	java/io/IOException
    //   796	801	2346	java/io/IOException
  }
  
  public static abstract interface a
  {
    public abstract void aWn(String paramString);
    
    public abstract void gZM();
    
    public abstract void gZN();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g
 * JD-Core Version:    0.7.0.1
 */