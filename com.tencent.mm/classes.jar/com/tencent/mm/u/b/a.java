package com.tencent.mm.u.b;

public final class a
{
  /* Error */
  public static java.util.ArrayList<com.tencent.mm.storage.emotion.q> a(com.tencent.mm.vfs.b paramb)
  {
    // Byte code:
    //   0: new 12	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 16	java/util/ArrayList:<init>	()V
    //   7: astore 7
    //   9: invokestatic 22	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   12: astore 9
    //   14: aload_0
    //   15: invokestatic 28	com/tencent/mm/vfs/e:o	(Lcom/tencent/mm/vfs/b;)Ljava/io/InputStream;
    //   18: astore 8
    //   20: aconst_null
    //   21: astore 6
    //   23: aload 9
    //   25: invokevirtual 32	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   28: aload 8
    //   30: invokevirtual 38	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   33: astore_0
    //   34: aload_0
    //   35: invokeinterface 43 1 0
    //   40: aload_0
    //   41: invokeinterface 47 1 0
    //   46: ldc 49
    //   48: invokeinterface 55 2 0
    //   53: astore_0
    //   54: aload_0
    //   55: ifnull +640 -> 695
    //   58: aload_0
    //   59: invokeinterface 61 1 0
    //   64: ifle +631 -> 695
    //   67: aload_0
    //   68: invokeinterface 61 1 0
    //   73: istore 4
    //   75: iconst_0
    //   76: istore_1
    //   77: iload_1
    //   78: iload 4
    //   80: if_icmpge +615 -> 695
    //   83: aload_0
    //   84: iload_1
    //   85: invokeinterface 65 2 0
    //   90: invokeinterface 71 1 0
    //   95: astore 9
    //   97: aload 9
    //   99: ifnull +640 -> 739
    //   102: aload 9
    //   104: invokeinterface 61 1 0
    //   109: ifle +630 -> 739
    //   112: new 73	com/tencent/mm/storage/emotion/q
    //   115: dup
    //   116: invokespecial 74	com/tencent/mm/storage/emotion/q:<init>	()V
    //   119: astore 10
    //   121: iconst_0
    //   122: istore_2
    //   123: iload_2
    //   124: aload 9
    //   126: invokeinterface 61 1 0
    //   131: if_icmpge +516 -> 647
    //   134: aload 9
    //   136: iload_2
    //   137: invokeinterface 65 2 0
    //   142: astore 11
    //   144: aload 11
    //   146: invokeinterface 78 1 0
    //   151: astore 12
    //   153: aload 12
    //   155: ldc 80
    //   157: invokevirtual 86	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   160: ifeq +18 -> 178
    //   163: aload 10
    //   165: aload 11
    //   167: invokeinterface 89 1 0
    //   172: putfield 93	com/tencent/mm/storage/emotion/q:field_key	Ljava/lang/String;
    //   175: goto +553 -> 728
    //   178: aload 12
    //   180: ldc 95
    //   182: invokevirtual 86	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   185: ifeq +119 -> 304
    //   188: aload 11
    //   190: invokeinterface 89 1 0
    //   195: invokestatic 100	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   198: ifne +18 -> 216
    //   201: ldc 102
    //   203: aload 11
    //   205: invokeinterface 89 1 0
    //   210: invokevirtual 86	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   213: ifeq +76 -> 289
    //   216: aload 10
    //   218: aload 10
    //   220: getfield 93	com/tencent/mm/storage/emotion/q:field_key	Ljava/lang/String;
    //   223: putfield 105	com/tencent/mm/storage/emotion/q:field_cnValue	Ljava/lang/String;
    //   226: goto +502 -> 728
    //   229: astore 6
    //   231: aload 6
    //   233: athrow
    //   234: astore_0
    //   235: aload 8
    //   237: ifnull +13 -> 250
    //   240: aload 6
    //   242: ifnull +478 -> 720
    //   245: aload 8
    //   247: invokevirtual 110	java/io/InputStream:close	()V
    //   250: aload_0
    //   251: athrow
    //   252: astore_0
    //   253: ldc 112
    //   255: ldc 114
    //   257: iconst_1
    //   258: anewarray 4	java/lang/Object
    //   261: dup
    //   262: iconst_0
    //   263: aload_0
    //   264: invokevirtual 117	java/lang/Exception:toString	()Ljava/lang/String;
    //   267: aastore
    //   268: invokestatic 123	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   271: aload 7
    //   273: invokevirtual 126	java/util/ArrayList:size	()I
    //   276: ifne +10 -> 286
    //   279: ldc 112
    //   281: ldc 128
    //   283: invokestatic 132	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   286: aload 7
    //   288: areturn
    //   289: aload 10
    //   291: aload 11
    //   293: invokeinterface 89 1 0
    //   298: putfield 105	com/tencent/mm/storage/emotion/q:field_cnValue	Ljava/lang/String;
    //   301: goto +427 -> 728
    //   304: aload 12
    //   306: ldc 134
    //   308: invokevirtual 86	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   311: ifeq +59 -> 370
    //   314: aload 11
    //   316: invokeinterface 89 1 0
    //   321: invokestatic 100	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   324: ifne +18 -> 342
    //   327: ldc 102
    //   329: aload 11
    //   331: invokeinterface 89 1 0
    //   336: invokevirtual 86	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   339: ifeq +16 -> 355
    //   342: aload 10
    //   344: aload 10
    //   346: getfield 93	com/tencent/mm/storage/emotion/q:field_key	Ljava/lang/String;
    //   349: putfield 137	com/tencent/mm/storage/emotion/q:field_qqValue	Ljava/lang/String;
    //   352: goto +376 -> 728
    //   355: aload 10
    //   357: aload 11
    //   359: invokeinterface 89 1 0
    //   364: putfield 137	com/tencent/mm/storage/emotion/q:field_qqValue	Ljava/lang/String;
    //   367: goto +361 -> 728
    //   370: aload 12
    //   372: ldc 139
    //   374: invokevirtual 86	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   377: ifeq +59 -> 436
    //   380: aload 11
    //   382: invokeinterface 89 1 0
    //   387: invokestatic 100	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   390: ifne +18 -> 408
    //   393: ldc 102
    //   395: aload 11
    //   397: invokeinterface 89 1 0
    //   402: invokevirtual 86	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   405: ifeq +16 -> 421
    //   408: aload 10
    //   410: aload 10
    //   412: getfield 93	com/tencent/mm/storage/emotion/q:field_key	Ljava/lang/String;
    //   415: putfield 142	com/tencent/mm/storage/emotion/q:field_enValue	Ljava/lang/String;
    //   418: goto +310 -> 728
    //   421: aload 10
    //   423: aload 11
    //   425: invokeinterface 89 1 0
    //   430: putfield 142	com/tencent/mm/storage/emotion/q:field_enValue	Ljava/lang/String;
    //   433: goto +295 -> 728
    //   436: aload 12
    //   438: ldc 144
    //   440: invokevirtual 86	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   443: ifeq +59 -> 502
    //   446: aload 11
    //   448: invokeinterface 89 1 0
    //   453: invokestatic 100	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   456: ifne +18 -> 474
    //   459: ldc 102
    //   461: aload 11
    //   463: invokeinterface 89 1 0
    //   468: invokevirtual 86	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   471: ifeq +16 -> 487
    //   474: aload 10
    //   476: aload 10
    //   478: getfield 93	com/tencent/mm/storage/emotion/q:field_key	Ljava/lang/String;
    //   481: putfield 147	com/tencent/mm/storage/emotion/q:field_twValue	Ljava/lang/String;
    //   484: goto +244 -> 728
    //   487: aload 10
    //   489: aload 11
    //   491: invokeinterface 89 1 0
    //   496: putfield 147	com/tencent/mm/storage/emotion/q:field_twValue	Ljava/lang/String;
    //   499: goto +229 -> 728
    //   502: aload 12
    //   504: ldc 149
    //   506: invokevirtual 86	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   509: ifeq +59 -> 568
    //   512: aload 11
    //   514: invokeinterface 89 1 0
    //   519: invokestatic 100	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   522: ifne +18 -> 540
    //   525: ldc 102
    //   527: aload 11
    //   529: invokeinterface 89 1 0
    //   534: invokevirtual 86	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   537: ifeq +16 -> 553
    //   540: aload 10
    //   542: aload 10
    //   544: getfield 93	com/tencent/mm/storage/emotion/q:field_key	Ljava/lang/String;
    //   547: putfield 152	com/tencent/mm/storage/emotion/q:field_thValue	Ljava/lang/String;
    //   550: goto +178 -> 728
    //   553: aload 10
    //   555: aload 11
    //   557: invokeinterface 89 1 0
    //   562: putfield 152	com/tencent/mm/storage/emotion/q:field_thValue	Ljava/lang/String;
    //   565: goto +163 -> 728
    //   568: aload 12
    //   570: ldc 154
    //   572: invokevirtual 86	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   575: ifeq +18 -> 593
    //   578: aload 10
    //   580: aload 11
    //   582: invokeinterface 89 1 0
    //   587: putfield 157	com/tencent/mm/storage/emotion/q:field_fileName	Ljava/lang/String;
    //   590: goto +138 -> 728
    //   593: aload 12
    //   595: ldc 159
    //   597: invokevirtual 86	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   600: istore 5
    //   602: iload 5
    //   604: ifeq +124 -> 728
    //   607: aload 11
    //   609: invokeinterface 89 1 0
    //   614: invokestatic 165	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   617: invokevirtual 168	java/lang/Integer:intValue	()I
    //   620: istore_3
    //   621: aload 10
    //   623: iload_3
    //   624: putfield 172	com/tencent/mm/storage/emotion/q:field_eggIndex	I
    //   627: goto +101 -> 728
    //   630: astore 11
    //   632: ldc 112
    //   634: aload 11
    //   636: invokestatic 176	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   639: invokestatic 178	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   642: iconst_m1
    //   643: istore_3
    //   644: goto -23 -> 621
    //   647: aload 10
    //   649: iconst_m1
    //   650: putfield 181	com/tencent/mm/storage/emotion/q:field_position	I
    //   653: ldc 112
    //   655: aload 10
    //   657: invokevirtual 182	com/tencent/mm/storage/emotion/q:toString	()Ljava/lang/String;
    //   660: invokestatic 185	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   663: aload 10
    //   665: getfield 93	com/tencent/mm/storage/emotion/q:field_key	Ljava/lang/String;
    //   668: invokestatic 100	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   671: ifeq +13 -> 684
    //   674: ldc 112
    //   676: ldc 187
    //   678: invokestatic 190	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   681: goto +58 -> 739
    //   684: aload 7
    //   686: aload 10
    //   688: invokevirtual 194	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   691: pop
    //   692: goto +47 -> 739
    //   695: aload 8
    //   697: ifnull -426 -> 271
    //   700: aload 8
    //   702: invokevirtual 110	java/io/InputStream:close	()V
    //   705: goto -434 -> 271
    //   708: astore 8
    //   710: aload 6
    //   712: aload 8
    //   714: invokevirtual 198	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   717: goto -467 -> 250
    //   720: aload 8
    //   722: invokevirtual 110	java/io/InputStream:close	()V
    //   725: goto -475 -> 250
    //   728: iload_2
    //   729: iconst_1
    //   730: iadd
    //   731: istore_2
    //   732: goto -609 -> 123
    //   735: astore_0
    //   736: goto -501 -> 235
    //   739: iload_1
    //   740: iconst_1
    //   741: iadd
    //   742: istore_1
    //   743: goto -666 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	746	0	paramb	com.tencent.mm.vfs.b
    //   76	667	1	i	int
    //   122	610	2	j	int
    //   620	24	3	k	int
    //   73	8	4	m	int
    //   600	3	5	bool	boolean
    //   21	1	6	localObject1	Object
    //   229	482	6	localThrowable1	java.lang.Throwable
    //   7	678	7	localArrayList	java.util.ArrayList
    //   18	683	8	localInputStream	java.io.InputStream
    //   708	13	8	localThrowable2	java.lang.Throwable
    //   12	123	9	localObject2	Object
    //   119	568	10	localq	com.tencent.mm.storage.emotion.q
    //   142	466	11	localNode	org.w3c.dom.Node
    //   630	5	11	localException	java.lang.Exception
    //   151	443	12	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   23	54	229	java/lang/Throwable
    //   58	75	229	java/lang/Throwable
    //   83	97	229	java/lang/Throwable
    //   102	121	229	java/lang/Throwable
    //   123	175	229	java/lang/Throwable
    //   178	216	229	java/lang/Throwable
    //   216	226	229	java/lang/Throwable
    //   289	301	229	java/lang/Throwable
    //   304	342	229	java/lang/Throwable
    //   342	352	229	java/lang/Throwable
    //   355	367	229	java/lang/Throwable
    //   370	408	229	java/lang/Throwable
    //   408	418	229	java/lang/Throwable
    //   421	433	229	java/lang/Throwable
    //   436	474	229	java/lang/Throwable
    //   474	484	229	java/lang/Throwable
    //   487	499	229	java/lang/Throwable
    //   502	540	229	java/lang/Throwable
    //   540	550	229	java/lang/Throwable
    //   553	565	229	java/lang/Throwable
    //   568	590	229	java/lang/Throwable
    //   593	602	229	java/lang/Throwable
    //   607	621	229	java/lang/Throwable
    //   621	627	229	java/lang/Throwable
    //   632	642	229	java/lang/Throwable
    //   647	681	229	java/lang/Throwable
    //   684	692	229	java/lang/Throwable
    //   231	234	234	finally
    //   14	20	252	java/lang/Exception
    //   245	250	252	java/lang/Exception
    //   250	252	252	java/lang/Exception
    //   700	705	252	java/lang/Exception
    //   710	717	252	java/lang/Exception
    //   720	725	252	java/lang/Exception
    //   607	621	630	java/lang/Exception
    //   245	250	708	java/lang/Throwable
    //   23	54	735	finally
    //   58	75	735	finally
    //   83	97	735	finally
    //   102	121	735	finally
    //   123	175	735	finally
    //   178	216	735	finally
    //   216	226	735	finally
    //   289	301	735	finally
    //   304	342	735	finally
    //   342	352	735	finally
    //   355	367	735	finally
    //   370	408	735	finally
    //   408	418	735	finally
    //   421	433	735	finally
    //   436	474	735	finally
    //   474	484	735	finally
    //   487	499	735	finally
    //   502	540	735	finally
    //   540	550	735	finally
    //   553	565	735	finally
    //   568	590	735	finally
    //   593	602	735	finally
    //   607	621	735	finally
    //   621	627	735	finally
    //   632	642	735	finally
    //   647	681	735	finally
    //   684	692	735	finally
  }
  
  /* Error */
  public static java.util.ArrayList<com.tencent.mm.storage.emotion.s> b(com.tencent.mm.vfs.b paramb)
  {
    // Byte code:
    //   0: new 12	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 16	java/util/ArrayList:<init>	()V
    //   7: astore 8
    //   9: invokestatic 22	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   12: astore 7
    //   14: aconst_null
    //   15: astore 5
    //   17: aconst_null
    //   18: astore 4
    //   20: aload_0
    //   21: invokestatic 28	com/tencent/mm/vfs/e:o	(Lcom/tencent/mm/vfs/b;)Ljava/io/InputStream;
    //   24: astore 6
    //   26: aload 6
    //   28: astore 4
    //   30: aload 6
    //   32: astore 5
    //   34: aload 7
    //   36: invokevirtual 32	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   39: aload 6
    //   41: invokevirtual 38	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   44: astore_0
    //   45: aload 6
    //   47: astore 4
    //   49: aload 6
    //   51: astore 5
    //   53: aload_0
    //   54: invokeinterface 43 1 0
    //   59: aload 6
    //   61: astore 4
    //   63: aload 6
    //   65: astore 5
    //   67: aload_0
    //   68: invokeinterface 47 1 0
    //   73: ldc 205
    //   75: invokeinterface 55 2 0
    //   80: astore 9
    //   82: aload 9
    //   84: ifnull +339 -> 423
    //   87: aload 6
    //   89: astore 4
    //   91: aload 6
    //   93: astore 5
    //   95: aload 9
    //   97: invokeinterface 61 1 0
    //   102: ifle +321 -> 423
    //   105: aload 6
    //   107: astore 4
    //   109: aload 6
    //   111: astore 5
    //   113: aload 9
    //   115: invokeinterface 61 1 0
    //   120: istore_3
    //   121: iconst_0
    //   122: istore_1
    //   123: iload_1
    //   124: iload_3
    //   125: if_icmpge +298 -> 423
    //   128: aload 6
    //   130: astore 4
    //   132: aload 6
    //   134: astore 5
    //   136: aload 9
    //   138: iload_1
    //   139: invokeinterface 65 2 0
    //   144: astore_0
    //   145: aload_0
    //   146: ifnull +316 -> 462
    //   149: aload 6
    //   151: astore 4
    //   153: aload 6
    //   155: astore 5
    //   157: aload_0
    //   158: invokeinterface 89 1 0
    //   163: invokestatic 100	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   166: ifne +296 -> 462
    //   169: aload 6
    //   171: astore 4
    //   173: aload 6
    //   175: astore 5
    //   177: aload_0
    //   178: invokeinterface 89 1 0
    //   183: ldc 207
    //   185: ldc 209
    //   187: invokevirtual 213	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   190: astore_0
    //   191: aload_0
    //   192: astore 7
    //   194: aload 6
    //   196: astore 4
    //   198: aload 6
    //   200: astore 5
    //   202: aload_0
    //   203: ldc 215
    //   205: invokevirtual 218	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   208: ifeq +89 -> 297
    //   211: aload 6
    //   213: astore 4
    //   215: aload 6
    //   217: astore 5
    //   219: aload_0
    //   220: iconst_3
    //   221: invokevirtual 222	java/lang/String:substring	(I)Ljava/lang/String;
    //   224: bipush 16
    //   226: invokestatic 226	java/lang/Integer:parseInt	(Ljava/lang/String;I)I
    //   229: invokestatic 232	java/lang/Character:toChars	(I)[C
    //   232: astore 10
    //   234: ldc 209
    //   236: astore_0
    //   237: iconst_0
    //   238: istore_2
    //   239: aload_0
    //   240: astore 7
    //   242: aload 6
    //   244: astore 4
    //   246: aload 6
    //   248: astore 5
    //   250: iload_2
    //   251: aload 10
    //   253: arraylength
    //   254: if_icmpge +43 -> 297
    //   257: aload 6
    //   259: astore 4
    //   261: aload 6
    //   263: astore 5
    //   265: new 234	java/lang/StringBuilder
    //   268: dup
    //   269: invokespecial 235	java/lang/StringBuilder:<init>	()V
    //   272: aload_0
    //   273: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: aload 10
    //   278: iload_2
    //   279: caload
    //   280: invokestatic 242	java/lang/String:valueOf	(C)Ljava/lang/String;
    //   283: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   289: astore_0
    //   290: iload_2
    //   291: iconst_1
    //   292: iadd
    //   293: istore_2
    //   294: goto -55 -> 239
    //   297: aload 6
    //   299: astore 4
    //   301: aload 6
    //   303: astore 5
    //   305: new 245	com/tencent/mm/storage/emotion/s
    //   308: dup
    //   309: iload_1
    //   310: aload 7
    //   312: invokespecial 248	com/tencent/mm/storage/emotion/s:<init>	(ILjava/lang/String;)V
    //   315: astore_0
    //   316: aload 6
    //   318: astore 4
    //   320: aload 6
    //   322: astore 5
    //   324: aload_0
    //   325: getfield 249	com/tencent/mm/storage/emotion/s:field_key	Ljava/lang/String;
    //   328: invokestatic 100	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   331: ifeq +38 -> 369
    //   334: aload 6
    //   336: astore 4
    //   338: aload 6
    //   340: astore 5
    //   342: ldc 112
    //   344: ldc 251
    //   346: invokestatic 190	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   349: aload 6
    //   351: astore 4
    //   353: aload 6
    //   355: astore 5
    //   357: ldc 112
    //   359: aload_0
    //   360: invokevirtual 252	com/tencent/mm/storage/emotion/s:toString	()Ljava/lang/String;
    //   363: invokestatic 185	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   366: goto +96 -> 462
    //   369: aload 6
    //   371: astore 4
    //   373: aload 6
    //   375: astore 5
    //   377: aload 8
    //   379: aload_0
    //   380: invokevirtual 194	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   383: pop
    //   384: goto -35 -> 349
    //   387: astore_0
    //   388: aload 4
    //   390: astore 5
    //   392: ldc 112
    //   394: ldc 254
    //   396: iconst_1
    //   397: anewarray 4	java/lang/Object
    //   400: dup
    //   401: iconst_0
    //   402: aload_0
    //   403: invokevirtual 117	java/lang/Exception:toString	()Ljava/lang/String;
    //   406: aastore
    //   407: invokestatic 123	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   410: aload 4
    //   412: ifnull +8 -> 420
    //   415: aload 4
    //   417: invokevirtual 110	java/io/InputStream:close	()V
    //   420: aload 8
    //   422: areturn
    //   423: aload 6
    //   425: ifnull -5 -> 420
    //   428: aload 6
    //   430: invokevirtual 110	java/io/InputStream:close	()V
    //   433: aload 8
    //   435: areturn
    //   436: astore_0
    //   437: aload 8
    //   439: areturn
    //   440: astore_0
    //   441: aload 5
    //   443: ifnull +8 -> 451
    //   446: aload 5
    //   448: invokevirtual 110	java/io/InputStream:close	()V
    //   451: aload_0
    //   452: athrow
    //   453: astore_0
    //   454: aload 8
    //   456: areturn
    //   457: astore 4
    //   459: goto -8 -> 451
    //   462: iload_1
    //   463: iconst_1
    //   464: iadd
    //   465: istore_1
    //   466: goto -343 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	469	0	paramb	com.tencent.mm.vfs.b
    //   122	344	1	i	int
    //   238	56	2	j	int
    //   120	6	3	k	int
    //   18	398	4	localObject1	Object
    //   457	1	4	localIOException	java.io.IOException
    //   15	432	5	localObject2	Object
    //   24	405	6	localInputStream	java.io.InputStream
    //   12	299	7	localObject3	Object
    //   7	448	8	localArrayList	java.util.ArrayList
    //   80	57	9	localNodeList	org.w3c.dom.NodeList
    //   232	45	10	arrayOfChar	char[]
    // Exception table:
    //   from	to	target	type
    //   20	26	387	java/lang/Exception
    //   34	45	387	java/lang/Exception
    //   53	59	387	java/lang/Exception
    //   67	82	387	java/lang/Exception
    //   95	105	387	java/lang/Exception
    //   113	121	387	java/lang/Exception
    //   136	145	387	java/lang/Exception
    //   157	169	387	java/lang/Exception
    //   177	191	387	java/lang/Exception
    //   202	211	387	java/lang/Exception
    //   219	234	387	java/lang/Exception
    //   250	257	387	java/lang/Exception
    //   265	290	387	java/lang/Exception
    //   305	316	387	java/lang/Exception
    //   324	334	387	java/lang/Exception
    //   342	349	387	java/lang/Exception
    //   357	366	387	java/lang/Exception
    //   377	384	387	java/lang/Exception
    //   428	433	436	java/io/IOException
    //   20	26	440	finally
    //   34	45	440	finally
    //   53	59	440	finally
    //   67	82	440	finally
    //   95	105	440	finally
    //   113	121	440	finally
    //   136	145	440	finally
    //   157	169	440	finally
    //   177	191	440	finally
    //   202	211	440	finally
    //   219	234	440	finally
    //   250	257	440	finally
    //   265	290	440	finally
    //   305	316	440	finally
    //   324	334	440	finally
    //   342	349	440	finally
    //   357	366	440	finally
    //   377	384	440	finally
    //   392	410	440	finally
    //   415	420	453	java/io/IOException
    //   446	451	457	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.u.b.a
 * JD-Core Version:    0.7.0.1
 */