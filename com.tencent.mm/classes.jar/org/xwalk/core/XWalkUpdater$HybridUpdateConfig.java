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
    //   236: astore_1
    //   237: aload_1
    //   238: invokestatic 125	com/tencent/xweb/util/c:aPq	(Ljava/lang/String;)Z
    //   241: pop
    //   242: aload_1
    //   243: aload 6
    //   245: invokestatic 130	com/tencent/xweb/xwalk/s:mk	(Ljava/lang/String;Ljava/lang/String;)Z
    //   248: ifne +59 -> 307
    //   251: ldc2_w 131
    //   254: ldc2_w 133
    //   257: lconst_1
    //   258: invokestatic 140	com/tencent/xweb/util/g:r	(JJJ)V
    //   261: ldc 142
    //   263: ldc 144
    //   265: invokestatic 94	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   268: ldc 23
    //   270: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   273: iconst_0
    //   274: ireturn
    //   275: astore_2
    //   276: aconst_null
    //   277: astore_1
    //   278: aload 5
    //   280: astore 4
    //   282: aload_1
    //   283: ifnull +7 -> 290
    //   286: aload_1
    //   287: invokevirtual 97	java/io/InputStream:close	()V
    //   290: aload 4
    //   292: ifnull +8 -> 300
    //   295: aload 4
    //   297: invokevirtual 98	java/io/OutputStream:close	()V
    //   300: ldc 23
    //   302: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   305: aload_2
    //   306: athrow
    //   307: aload 6
    //   309: invokestatic 125	com/tencent/xweb/util/c:aPq	(Ljava/lang/String;)Z
    //   312: pop
    //   313: new 106	java/io/File
    //   316: dup
    //   317: new 49	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   324: invokestatic 35	org/xwalk/core/XWalkEnvironment:getApplicationContext	()Landroid/content/Context;
    //   327: invokestatic 148	com/tencent/xweb/util/c:kY	(Landroid/content/Context;)Ljava/lang/String;
    //   330: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: getstatic 119	java/io/File:separator	Ljava/lang/String;
    //   336: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: ldc 150
    //   341: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: getstatic 119	java/io/File:separator	Ljava/lang/String;
    //   347: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: ldc 152
    //   352: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: invokespecial 107	java/io/File:<init>	(Ljava/lang/String;)V
    //   361: astore 4
    //   363: new 106	java/io/File
    //   366: dup
    //   367: new 49	java/lang/StringBuilder
    //   370: dup
    //   371: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   374: aload_1
    //   375: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: getstatic 119	java/io/File:separator	Ljava/lang/String;
    //   381: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: ldc 152
    //   386: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: invokespecial 107	java/io/File:<init>	(Ljava/lang/String;)V
    //   395: astore 5
    //   397: aload 5
    //   399: invokevirtual 156	java/io/File:exists	()Z
    //   402: ifeq +42 -> 444
    //   405: aload 5
    //   407: invokevirtual 159	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   410: aload_2
    //   411: invokestatic 164	com/tencent/xweb/util/d:mi	(Ljava/lang/String;Ljava/lang/String;)Z
    //   414: ifeq +17 -> 431
    //   417: ldc 84
    //   419: ldc 166
    //   421: invokestatic 94	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   424: ldc 23
    //   426: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   429: iconst_1
    //   430: ireturn
    //   431: ldc 84
    //   433: ldc 168
    //   435: invokestatic 94	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   438: aload 5
    //   440: invokevirtual 171	java/io/File:delete	()Z
    //   443: pop
    //   444: aload 4
    //   446: invokevirtual 156	java/io/File:exists	()Z
    //   449: ifne +27 -> 476
    //   452: ldc2_w 131
    //   455: ldc2_w 172
    //   458: lconst_1
    //   459: invokestatic 140	com/tencent/xweb/util/g:r	(JJJ)V
    //   462: ldc 142
    //   464: ldc 175
    //   466: invokestatic 94	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   469: ldc 23
    //   471: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   474: iconst_0
    //   475: ireturn
    //   476: aload 4
    //   478: invokevirtual 159	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   481: aload_2
    //   482: invokestatic 164	com/tencent/xweb/util/d:mi	(Ljava/lang/String;Ljava/lang/String;)Z
    //   485: ifne +25 -> 510
    //   488: ldc 142
    //   490: ldc 177
    //   492: invokestatic 94	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   495: ldc2_w 131
    //   498: ldc2_w 178
    //   501: lconst_1
    //   502: invokestatic 140	com/tencent/xweb/util/g:r	(JJJ)V
    //   505: aload_0
    //   506: iconst_0
    //   507: putfield 182	org/xwalk/core/XWalkUpdater$HybridUpdateConfig:isMatchMd5	Z
    //   510: aload 4
    //   512: aload 5
    //   514: invokestatic 186	com/tencent/xweb/util/c:f	(Ljava/io/File;Ljava/io/File;)Z
    //   517: ifne +27 -> 544
    //   520: ldc 142
    //   522: ldc 188
    //   524: invokestatic 94	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   527: ldc2_w 131
    //   530: ldc2_w 189
    //   533: lconst_1
    //   534: invokestatic 140	com/tencent/xweb/util/g:r	(JJJ)V
    //   537: ldc 23
    //   539: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   542: iconst_0
    //   543: ireturn
    //   544: new 106	java/io/File
    //   547: dup
    //   548: aload_1
    //   549: invokespecial 107	java/io/File:<init>	(Ljava/lang/String;)V
    //   552: astore_1
    //   553: aload_1
    //   554: invokevirtual 193	java/io/File:isDirectory	()Z
    //   557: ifne +17 -> 574
    //   560: ldc 142
    //   562: ldc 195
    //   564: invokestatic 94	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   567: ldc 23
    //   569: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   572: iconst_0
    //   573: ireturn
    //   574: aload_1
    //   575: invokevirtual 199	java/io/File:listFiles	()[Ljava/io/File;
    //   578: aload_0
    //   579: invokevirtual 56	org/xwalk/core/XWalkUpdater$HybridUpdateConfig:getDownloadPath	()Ljava/lang/String;
    //   582: iconst_0
    //   583: invokestatic 203	com/tencent/xweb/xwalk/s:a	([Ljava/io/File;Ljava/lang/String;I)Z
    //   586: ifne +27 -> 613
    //   589: ldc2_w 131
    //   592: ldc2_w 204
    //   595: lconst_1
    //   596: invokestatic 140	com/tencent/xweb/util/g:r	(JJJ)V
    //   599: ldc 142
    //   601: ldc 207
    //   603: invokestatic 94	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   606: ldc 23
    //   608: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   611: iconst_0
    //   612: ireturn
    //   613: ldc 23
    //   615: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   618: iconst_1
    //   619: ireturn
    //   620: astore_1
    //   621: goto -461 -> 160
    //   624: astore_1
    //   625: goto -460 -> 165
    //   628: astore_2
    //   629: goto -497 -> 132
    //   632: astore_1
    //   633: goto -493 -> 140
    //   636: astore_1
    //   637: goto -347 -> 290
    //   640: astore_1
    //   641: goto -341 -> 300
    //   644: astore_2
    //   645: aload 5
    //   647: astore 4
    //   649: goto -367 -> 282
    //   652: astore_2
    //   653: goto -371 -> 282
    //   656: astore 4
    //   658: aload_2
    //   659: astore 5
    //   661: aload 4
    //   663: astore_2
    //   664: aload_1
    //   665: astore 4
    //   667: aload 5
    //   669: astore_1
    //   670: goto -388 -> 282
    //   673: astore 4
    //   675: aconst_null
    //   676: astore_1
    //   677: aconst_null
    //   678: astore_2
    //   679: goto -580 -> 99
    //   682: astore 4
    //   684: aconst_null
    //   685: astore 5
    //   687: aload_1
    //   688: astore_2
    //   689: aload 5
    //   691: astore_1
    //   692: goto -593 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	695	0	this	HybridUpdateConfig
    //   0	695	1	paramString1	String
    //   0	695	2	paramString2	String
    //   70	12	3	i	int
    //   11	637	4	localObject1	java.lang.Object
    //   656	6	4	localObject2	java.lang.Object
    //   665	1	4	str1	String
    //   673	1	4	localException1	java.lang.Exception
    //   682	1	4	localException2	java.lang.Exception
    //   14	65	5	arrayOfByte	byte[]
    //   88	191	5	localException3	java.lang.Exception
    //   395	295	5	localObject3	java.lang.Object
    //   45	263	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   58	64	88	java/lang/Exception
    //   64	71	88	java/lang/Exception
    //   76	85	88	java/lang/Exception
    //   147	152	88	java/lang/Exception
    //   16	23	275	finally
    //   156	160	620	java/lang/Exception
    //   160	165	624	java/io/IOException
    //   128	132	628	java/lang/Exception
    //   136	140	632	java/io/IOException
    //   286	290	636	java/lang/Exception
    //   295	300	640	java/io/IOException
    //   23	58	644	finally
    //   58	64	652	finally
    //   64	71	652	finally
    //   76	85	652	finally
    //   147	152	652	finally
    //   99	124	656	finally
    //   16	23	673	java/lang/Exception
    //   23	58	682	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     org.xwalk.core.XWalkUpdater.HybridUpdateConfig
 * JD-Core Version:    0.7.0.1
 */