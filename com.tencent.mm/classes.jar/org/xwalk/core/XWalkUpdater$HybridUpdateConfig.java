package org.xwalk.core;

public class XWalkUpdater$HybridUpdateConfig
  extends XWalkUpdater.EmbededUpdateConfig
{
  public XWalkUpdater$HybridUpdateConfig(int paramInt, String paramString1, String paramString2)
  {
    super(paramInt, paramString1, paramString2);
    this.alreadyUnZiped = true;
  }
  
  /* Error */
  public boolean copyPackageToLocal(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 23
    //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 35	org/xwalk/core/XWalkEnvironment:getApplicationContext	()Landroid/content/Context;
    //   8: invokevirtual 41	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   11: astore 4
    //   13: aconst_null
    //   14: astore 5
    //   16: aload 4
    //   18: aload_1
    //   19: invokevirtual 47	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   22: astore_1
    //   23: new 49	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   30: aload_0
    //   31: invokevirtual 56	org/xwalk/core/XWalkUpdater$HybridUpdateConfig:getDownloadPath	()Ljava/lang/String;
    //   34: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc 62
    //   39: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: astore 6
    //   47: new 67	java/io/FileOutputStream
    //   50: dup
    //   51: aload 6
    //   53: invokespecial 70	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   56: astore 4
    //   58: ldc 71
    //   60: newarray byte
    //   62: astore 5
    //   64: aload_1
    //   65: aload 5
    //   67: invokevirtual 77	java/io/InputStream:read	([B)I
    //   70: istore_3
    //   71: iload_3
    //   72: iconst_m1
    //   73: if_icmpeq +74 -> 147
    //   76: aload 4
    //   78: aload 5
    //   80: iconst_0
    //   81: iload_3
    //   82: invokevirtual 83	java/io/OutputStream:write	([BII)V
    //   85: goto -21 -> 64
    //   88: astore 5
    //   90: aload_1
    //   91: astore_2
    //   92: aload 4
    //   94: astore_1
    //   95: aload 5
    //   97: astore 4
    //   99: ldc 84
    //   101: new 49	java/lang/StringBuilder
    //   104: dup
    //   105: ldc 86
    //   107: invokespecial 87	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   110: aload 4
    //   112: invokevirtual 90	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   115: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokestatic 94	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   124: aload_2
    //   125: ifnull +7 -> 132
    //   128: aload_2
    //   129: invokevirtual 97	java/io/InputStream:close	()V
    //   132: aload_1
    //   133: ifnull +7 -> 140
    //   136: aload_1
    //   137: invokevirtual 98	java/io/OutputStream:close	()V
    //   140: ldc 23
    //   142: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   145: iconst_0
    //   146: ireturn
    //   147: aload 4
    //   149: invokevirtual 104	java/io/OutputStream:flush	()V
    //   152: aload_1
    //   153: ifnull +7 -> 160
    //   156: aload_1
    //   157: invokevirtual 97	java/io/InputStream:close	()V
    //   160: aload 4
    //   162: invokevirtual 98	java/io/OutputStream:close	()V
    //   165: new 106	java/io/File
    //   168: dup
    //   169: aload 6
    //   171: invokespecial 107	java/io/File:<init>	(Ljava/lang/String;)V
    //   174: astore 4
    //   176: aload 4
    //   178: invokevirtual 110	java/io/File:getParent	()Ljava/lang/String;
    //   181: astore_1
    //   182: aload 4
    //   184: invokevirtual 113	java/io/File:getName	()Ljava/lang/String;
    //   187: astore 4
    //   189: new 49	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   196: aload 4
    //   198: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: ldc 115
    //   203: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: astore 4
    //   211: new 49	java/lang/StringBuilder
    //   214: dup
    //   215: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   218: aload_1
    //   219: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: getstatic 119	java/io/File:separator	Ljava/lang/String;
    //   225: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: aload 4
    //   230: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: astore 5
    //   238: aload 5
    //   240: invokestatic 125	com/tencent/xweb/util/c:bsB	(Ljava/lang/String;)Z
    //   243: pop
    //   244: aload 5
    //   246: aload 6
    //   248: invokestatic 130	com/tencent/xweb/xwalk/u:cg	(Ljava/lang/String;Ljava/lang/String;)Z
    //   251: ifne +59 -> 310
    //   254: ldc2_w 131
    //   257: ldc2_w 133
    //   260: lconst_1
    //   261: invokestatic 140	com/tencent/xweb/util/h:s	(JJJ)V
    //   264: ldc 142
    //   266: ldc 144
    //   268: invokestatic 94	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   271: ldc 23
    //   273: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   276: iconst_0
    //   277: ireturn
    //   278: astore_2
    //   279: aconst_null
    //   280: astore_1
    //   281: aload 5
    //   283: astore 4
    //   285: aload_1
    //   286: ifnull +7 -> 293
    //   289: aload_1
    //   290: invokevirtual 97	java/io/InputStream:close	()V
    //   293: aload 4
    //   295: ifnull +8 -> 303
    //   298: aload 4
    //   300: invokevirtual 98	java/io/OutputStream:close	()V
    //   303: ldc 23
    //   305: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   308: aload_2
    //   309: athrow
    //   310: aload 6
    //   312: invokestatic 125	com/tencent/xweb/util/c:bsB	(Ljava/lang/String;)Z
    //   315: pop
    //   316: new 49	java/lang/StringBuilder
    //   319: dup
    //   320: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   323: astore 6
    //   325: invokestatic 35	org/xwalk/core/XWalkEnvironment:getApplicationContext	()Landroid/content/Context;
    //   328: astore 7
    //   330: aload 7
    //   332: ifnonnull +121 -> 453
    //   335: ldc 146
    //   337: ldc 148
    //   339: invokestatic 153	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   342: ldc 155
    //   344: astore_1
    //   345: new 106	java/io/File
    //   348: dup
    //   349: aload 6
    //   351: aload_1
    //   352: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: getstatic 119	java/io/File:separator	Ljava/lang/String;
    //   358: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: ldc 157
    //   363: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: getstatic 119	java/io/File:separator	Ljava/lang/String;
    //   369: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: ldc 159
    //   374: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   380: invokespecial 107	java/io/File:<init>	(Ljava/lang/String;)V
    //   383: astore_1
    //   384: new 106	java/io/File
    //   387: dup
    //   388: new 49	java/lang/StringBuilder
    //   391: dup
    //   392: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   395: aload 5
    //   397: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: getstatic 119	java/io/File:separator	Ljava/lang/String;
    //   403: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: ldc 159
    //   408: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   414: invokespecial 107	java/io/File:<init>	(Ljava/lang/String;)V
    //   417: astore 4
    //   419: aload 4
    //   421: invokevirtual 163	java/io/File:exists	()Z
    //   424: ifeq +120 -> 544
    //   427: aload 4
    //   429: invokevirtual 166	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   432: aload_2
    //   433: invokestatic 171	com/tencent/xweb/util/d:oi	(Ljava/lang/String;Ljava/lang/String;)Z
    //   436: ifeq +95 -> 531
    //   439: ldc 84
    //   441: ldc 173
    //   443: invokestatic 94	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   446: ldc 23
    //   448: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   451: iconst_1
    //   452: ireturn
    //   453: aload 7
    //   455: invokevirtual 177	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   458: ifnonnull +16 -> 474
    //   461: ldc 146
    //   463: ldc 179
    //   465: invokestatic 153	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   468: ldc 155
    //   470: astore_1
    //   471: goto -126 -> 345
    //   474: aload 7
    //   476: invokevirtual 177	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   479: getfield 184	android/content/pm/ApplicationInfo:dataDir	Ljava/lang/String;
    //   482: astore 4
    //   484: aload 4
    //   486: ifnull +14 -> 500
    //   489: aload 4
    //   491: astore_1
    //   492: aload 4
    //   494: invokevirtual 189	java/lang/String:isEmpty	()Z
    //   497: ifeq -152 -> 345
    //   500: new 49	java/lang/StringBuilder
    //   503: dup
    //   504: ldc 191
    //   506: invokespecial 87	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   509: aload 7
    //   511: invokevirtual 194	android/content/Context:getPackageName	()Ljava/lang/String;
    //   514: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   520: astore_1
    //   521: ldc 146
    //   523: ldc 196
    //   525: invokestatic 153	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   528: goto -183 -> 345
    //   531: ldc 84
    //   533: ldc 198
    //   535: invokestatic 94	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   538: aload 4
    //   540: invokevirtual 201	java/io/File:delete	()Z
    //   543: pop
    //   544: aload_1
    //   545: invokevirtual 163	java/io/File:exists	()Z
    //   548: ifne +27 -> 575
    //   551: ldc2_w 131
    //   554: ldc2_w 202
    //   557: lconst_1
    //   558: invokestatic 140	com/tencent/xweb/util/h:s	(JJJ)V
    //   561: ldc 142
    //   563: ldc 205
    //   565: invokestatic 94	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   568: ldc 23
    //   570: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   573: iconst_0
    //   574: ireturn
    //   575: aload_1
    //   576: invokevirtual 166	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   579: aload_2
    //   580: invokestatic 171	com/tencent/xweb/util/d:oi	(Ljava/lang/String;Ljava/lang/String;)Z
    //   583: ifne +25 -> 608
    //   586: ldc 142
    //   588: ldc 207
    //   590: invokestatic 94	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   593: ldc2_w 131
    //   596: ldc2_w 208
    //   599: lconst_1
    //   600: invokestatic 140	com/tencent/xweb/util/h:s	(JJJ)V
    //   603: aload_0
    //   604: iconst_0
    //   605: putfield 212	org/xwalk/core/XWalkUpdater$HybridUpdateConfig:isMatchMd5	Z
    //   608: aload_1
    //   609: aload 4
    //   611: invokestatic 216	com/tencent/xweb/util/c:g	(Ljava/io/File;Ljava/io/File;)Z
    //   614: ifne +27 -> 641
    //   617: ldc 142
    //   619: ldc 218
    //   621: invokestatic 94	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   624: ldc2_w 131
    //   627: ldc2_w 219
    //   630: lconst_1
    //   631: invokestatic 140	com/tencent/xweb/util/h:s	(JJJ)V
    //   634: ldc 23
    //   636: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   639: iconst_0
    //   640: ireturn
    //   641: new 106	java/io/File
    //   644: dup
    //   645: aload 5
    //   647: invokespecial 107	java/io/File:<init>	(Ljava/lang/String;)V
    //   650: astore_1
    //   651: aload_1
    //   652: invokevirtual 223	java/io/File:isDirectory	()Z
    //   655: ifne +17 -> 672
    //   658: ldc 142
    //   660: ldc 225
    //   662: invokestatic 94	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   665: ldc 23
    //   667: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   670: iconst_0
    //   671: ireturn
    //   672: aload_1
    //   673: invokevirtual 229	java/io/File:listFiles	()[Ljava/io/File;
    //   676: aload_0
    //   677: invokevirtual 56	org/xwalk/core/XWalkUpdater$HybridUpdateConfig:getDownloadPath	()Ljava/lang/String;
    //   680: iconst_0
    //   681: invokestatic 233	com/tencent/xweb/xwalk/u:a	([Ljava/io/File;Ljava/lang/String;I)Z
    //   684: ifne +27 -> 711
    //   687: ldc2_w 131
    //   690: ldc2_w 234
    //   693: lconst_1
    //   694: invokestatic 140	com/tencent/xweb/util/h:s	(JJJ)V
    //   697: ldc 142
    //   699: ldc 237
    //   701: invokestatic 94	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   704: ldc 23
    //   706: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   709: iconst_0
    //   710: ireturn
    //   711: ldc 23
    //   713: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   716: iconst_1
    //   717: ireturn
    //   718: astore_1
    //   719: goto -559 -> 160
    //   722: astore_1
    //   723: goto -558 -> 165
    //   726: astore_2
    //   727: goto -595 -> 132
    //   730: astore_1
    //   731: goto -591 -> 140
    //   734: astore_1
    //   735: goto -442 -> 293
    //   738: astore_1
    //   739: goto -436 -> 303
    //   742: astore_2
    //   743: aload 5
    //   745: astore 4
    //   747: goto -462 -> 285
    //   750: astore_2
    //   751: goto -466 -> 285
    //   754: astore 4
    //   756: aload_2
    //   757: astore 5
    //   759: aload 4
    //   761: astore_2
    //   762: aload_1
    //   763: astore 4
    //   765: aload 5
    //   767: astore_1
    //   768: goto -483 -> 285
    //   771: astore 4
    //   773: aconst_null
    //   774: astore_1
    //   775: aconst_null
    //   776: astore_2
    //   777: goto -678 -> 99
    //   780: astore 4
    //   782: aconst_null
    //   783: astore 5
    //   785: aload_1
    //   786: astore_2
    //   787: aload 5
    //   789: astore_1
    //   790: goto -691 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	793	0	this	HybridUpdateConfig
    //   0	793	1	paramString1	String
    //   0	793	2	paramString2	String
    //   70	12	3	i	int
    //   11	735	4	localObject1	java.lang.Object
    //   754	6	4	localObject2	java.lang.Object
    //   763	1	4	str1	String
    //   771	1	4	localException1	java.lang.Exception
    //   780	1	4	localException2	java.lang.Exception
    //   14	65	5	arrayOfByte	byte[]
    //   88	8	5	localException3	java.lang.Exception
    //   236	552	5	str2	String
    //   45	305	6	localObject3	java.lang.Object
    //   328	182	7	localContext	android.content.Context
    // Exception table:
    //   from	to	target	type
    //   58	64	88	java/lang/Exception
    //   64	71	88	java/lang/Exception
    //   76	85	88	java/lang/Exception
    //   147	152	88	java/lang/Exception
    //   16	23	278	finally
    //   156	160	718	java/lang/Exception
    //   160	165	722	java/io/IOException
    //   128	132	726	java/lang/Exception
    //   136	140	730	java/io/IOException
    //   289	293	734	java/lang/Exception
    //   298	303	738	java/io/IOException
    //   23	58	742	finally
    //   58	64	750	finally
    //   64	71	750	finally
    //   76	85	750	finally
    //   147	152	750	finally
    //   99	124	754	finally
    //   16	23	771	java/lang/Exception
    //   23	58	780	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     org.xwalk.core.XWalkUpdater.HybridUpdateConfig
 * JD-Core Version:    0.7.0.1
 */