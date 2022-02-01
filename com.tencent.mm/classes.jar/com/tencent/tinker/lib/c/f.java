package com.tencent.tinker.lib.c;

public final class f
  extends c
{
  /* Error */
  private static boolean a(android.content.Context paramContext, java.lang.String paramString, java.io.File paramFile1, java.io.File paramFile2, java.io.File paramFile3, com.tencent.tinker.loader.shareutil.ShareResPatchInfo paramShareResPatchInfo)
  {
    // Byte code:
    //   0: invokestatic 12	java/lang/System:currentTimeMillis	()J
    //   3: lstore 6
    //   5: aload_0
    //   6: invokestatic 18	com/tencent/tinker/lib/e/a:oy	(Landroid/content/Context;)Lcom/tencent/tinker/lib/e/a;
    //   9: astore 12
    //   11: aconst_null
    //   12: astore 10
    //   14: aconst_null
    //   15: astore 11
    //   17: new 20	java/util/zip/ZipFile
    //   20: dup
    //   21: aload_1
    //   22: invokespecial 24	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   25: astore_1
    //   26: aload_1
    //   27: ldc 26
    //   29: invokevirtual 30	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   32: astore_0
    //   33: new 32	java/io/File
    //   36: dup
    //   37: aload_2
    //   38: ldc 26
    //   40: invokespecial 35	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   43: astore_2
    //   44: aload_0
    //   45: ifnonnull +41 -> 86
    //   48: ldc 37
    //   50: ldc 39
    //   52: iconst_0
    //   53: anewarray 41	java/lang/Object
    //   56: invokestatic 47	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   59: aload 12
    //   61: getfield 51	com/tencent/tinker/lib/e/a:ahRI	Lcom/tencent/tinker/lib/d/d;
    //   64: aload 4
    //   66: aload_2
    //   67: ldc 26
    //   69: bipush 6
    //   71: invokeinterface 56 5 0
    //   76: aload_1
    //   77: invokestatic 62	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   80: aconst_null
    //   81: invokestatic 62	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   84: iconst_0
    //   85: ireturn
    //   86: aload_0
    //   87: invokevirtual 67	java/util/zip/ZipEntry:getCrc	()J
    //   90: invokestatic 73	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   93: astore_0
    //   94: aload_0
    //   95: aload 5
    //   97: getfield 79	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:arscBaseCrc	Ljava/lang/String;
    //   100: invokevirtual 83	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   103: ifne +53 -> 156
    //   106: ldc 37
    //   108: ldc 85
    //   110: iconst_2
    //   111: anewarray 41	java/lang/Object
    //   114: dup
    //   115: iconst_0
    //   116: aload 5
    //   118: getfield 79	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:arscBaseCrc	Ljava/lang/String;
    //   121: aastore
    //   122: dup
    //   123: iconst_1
    //   124: aload_0
    //   125: aastore
    //   126: invokestatic 88	com/tencent/tinker/loader/shareutil/ShareTinkerLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   129: aload 12
    //   131: getfield 51	com/tencent/tinker/lib/e/a:ahRI	Lcom/tencent/tinker/lib/d/d;
    //   134: aload 4
    //   136: aload_2
    //   137: ldc 26
    //   139: bipush 6
    //   141: invokeinterface 56 5 0
    //   146: aload_1
    //   147: invokestatic 62	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   150: aconst_null
    //   151: invokestatic 62	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   154: iconst_0
    //   155: ireturn
    //   156: aload 5
    //   158: getfield 92	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:largeModRes	Ljava/util/ArrayList;
    //   161: invokevirtual 98	java/util/ArrayList:isEmpty	()Z
    //   164: ifeq +35 -> 199
    //   167: aload 5
    //   169: getfield 102	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:storeRes	Ljava/util/HashMap;
    //   172: invokevirtual 105	java/util/HashMap:isEmpty	()Z
    //   175: ifeq +24 -> 199
    //   178: ldc 37
    //   180: ldc 107
    //   182: iconst_0
    //   183: anewarray 41	java/lang/Object
    //   186: invokestatic 110	com/tencent/tinker/loader/shareutil/ShareTinkerLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   189: aload_1
    //   190: invokestatic 62	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   193: aconst_null
    //   194: invokestatic 62	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   197: iconst_1
    //   198: ireturn
    //   199: new 20	java/util/zip/ZipFile
    //   202: dup
    //   203: aload 4
    //   205: invokespecial 113	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   208: astore 10
    //   210: aload 5
    //   212: getfield 102	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:storeRes	Ljava/util/HashMap;
    //   215: invokevirtual 117	java/util/HashMap:keySet	()Ljava/util/Set;
    //   218: invokeinterface 123 1 0
    //   223: astore_0
    //   224: aload_0
    //   225: invokeinterface 128 1 0
    //   230: ifeq +310 -> 540
    //   233: aload_0
    //   234: invokeinterface 132 1 0
    //   239: checkcast 69	java/lang/String
    //   242: astore_2
    //   243: invokestatic 12	java/lang/System:currentTimeMillis	()J
    //   246: lstore 8
    //   248: new 32	java/io/File
    //   251: dup
    //   252: aload_3
    //   253: aload_2
    //   254: invokespecial 35	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   257: astore 11
    //   259: aload 11
    //   261: invokestatic 135	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:ensureFileDirectory	(Ljava/io/File;)V
    //   264: aload 10
    //   266: aload_2
    //   267: invokevirtual 30	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   270: astore 13
    //   272: aload 13
    //   274: ifnonnull +49 -> 323
    //   277: ldc 37
    //   279: ldc 137
    //   281: aload_2
    //   282: invokestatic 140	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   285: invokevirtual 144	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   288: iconst_0
    //   289: anewarray 41	java/lang/Object
    //   292: invokestatic 47	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   295: aload 12
    //   297: getfield 51	com/tencent/tinker/lib/e/a:ahRI	Lcom/tencent/tinker/lib/d/d;
    //   300: aload 4
    //   302: aload 11
    //   304: aload_2
    //   305: bipush 6
    //   307: invokeinterface 56 5 0
    //   312: aload_1
    //   313: invokestatic 62	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   316: aload 10
    //   318: invokestatic 62	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   321: iconst_0
    //   322: ireturn
    //   323: aload 10
    //   325: aload 13
    //   327: aload 11
    //   329: aconst_null
    //   330: iconst_0
    //   331: invokestatic 147	com/tencent/tinker/lib/c/f:a	(Ljava/util/zip/ZipFile;Ljava/util/zip/ZipEntry;Ljava/io/File;Ljava/lang/String;Z)Z
    //   334: pop
    //   335: aload 13
    //   337: invokevirtual 150	java/util/zip/ZipEntry:getSize	()J
    //   340: aload 11
    //   342: invokevirtual 153	java/io/File:length	()J
    //   345: lcmp
    //   346: ifeq +76 -> 422
    //   349: ldc 37
    //   351: ldc 155
    //   353: iconst_4
    //   354: anewarray 41	java/lang/Object
    //   357: dup
    //   358: iconst_0
    //   359: bipush 6
    //   361: invokestatic 161	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:getTypeString	(I)Ljava/lang/String;
    //   364: aastore
    //   365: dup
    //   366: iconst_1
    //   367: aload_2
    //   368: aastore
    //   369: dup
    //   370: iconst_2
    //   371: aload 13
    //   373: invokevirtual 150	java/util/zip/ZipEntry:getSize	()J
    //   376: invokestatic 166	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   379: aastore
    //   380: dup
    //   381: iconst_3
    //   382: aload 11
    //   384: invokevirtual 153	java/io/File:length	()J
    //   387: invokestatic 166	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   390: aastore
    //   391: invokestatic 47	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   394: aload 12
    //   396: getfield 51	com/tencent/tinker/lib/e/a:ahRI	Lcom/tencent/tinker/lib/d/d;
    //   399: aload 4
    //   401: bipush 6
    //   403: invokestatic 170	com/tencent/tinker/lib/c/c:aIW	(I)I
    //   406: invokeinterface 174 3 0
    //   411: aload_1
    //   412: invokestatic 62	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   415: aload 10
    //   417: invokestatic 62	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   420: iconst_0
    //   421: ireturn
    //   422: aload 5
    //   424: getfield 102	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:storeRes	Ljava/util/HashMap;
    //   427: aload_2
    //   428: aload 11
    //   430: invokevirtual 178	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   433: pop
    //   434: ldc 37
    //   436: ldc 180
    //   438: iconst_3
    //   439: anewarray 41	java/lang/Object
    //   442: dup
    //   443: iconst_0
    //   444: aload 11
    //   446: invokevirtual 184	java/io/File:getPath	()Ljava/lang/String;
    //   449: aastore
    //   450: dup
    //   451: iconst_1
    //   452: aload 11
    //   454: invokevirtual 153	java/io/File:length	()J
    //   457: invokestatic 166	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   460: aastore
    //   461: dup
    //   462: iconst_2
    //   463: invokestatic 12	java/lang/System:currentTimeMillis	()J
    //   466: lload 8
    //   468: lsub
    //   469: invokestatic 166	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   472: aastore
    //   473: invokestatic 47	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   476: goto -252 -> 224
    //   479: astore_0
    //   480: aload 10
    //   482: astore_2
    //   483: new 186	com/tencent/tinker/loader/TinkerRuntimeException
    //   486: dup
    //   487: new 188	java/lang/StringBuilder
    //   490: dup
    //   491: ldc 190
    //   493: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   496: bipush 6
    //   498: invokestatic 161	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:getTypeString	(I)Ljava/lang/String;
    //   501: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: ldc 197
    //   506: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: aload_0
    //   510: invokevirtual 202	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   513: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: ldc 204
    //   518: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   524: aload_0
    //   525: invokespecial 210	com/tencent/tinker/loader/TinkerRuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   528: athrow
    //   529: astore_0
    //   530: aload_1
    //   531: invokestatic 62	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   534: aload_2
    //   535: invokestatic 62	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   538: aload_0
    //   539: athrow
    //   540: aload 5
    //   542: getfield 92	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:largeModRes	Ljava/util/ArrayList;
    //   545: invokevirtual 211	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   548: astore 13
    //   550: aload 13
    //   552: invokeinterface 128 1 0
    //   557: ifeq +504 -> 1061
    //   560: aload 13
    //   562: invokeinterface 132 1 0
    //   567: checkcast 69	java/lang/String
    //   570: astore 14
    //   572: invokestatic 12	java/lang/System:currentTimeMillis	()J
    //   575: lstore 8
    //   577: aload 5
    //   579: getfield 214	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:largeModMap	Ljava/util/HashMap;
    //   582: aload 14
    //   584: invokevirtual 218	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   587: checkcast 220	com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo
    //   590: astore 15
    //   592: aload 15
    //   594: ifnonnull +55 -> 649
    //   597: ldc 37
    //   599: ldc 222
    //   601: iconst_2
    //   602: anewarray 41	java/lang/Object
    //   605: dup
    //   606: iconst_0
    //   607: bipush 6
    //   609: invokestatic 161	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:getTypeString	(I)Ljava/lang/String;
    //   612: aastore
    //   613: dup
    //   614: iconst_1
    //   615: aload 14
    //   617: aastore
    //   618: invokestatic 47	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   621: aload 12
    //   623: getfield 51	com/tencent/tinker/lib/e/a:ahRI	Lcom/tencent/tinker/lib/d/d;
    //   626: aload 4
    //   628: bipush 6
    //   630: invokestatic 170	com/tencent/tinker/lib/c/c:aIW	(I)I
    //   633: invokeinterface 174 3 0
    //   638: aload_1
    //   639: invokestatic 62	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   642: aload 10
    //   644: invokestatic 62	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   647: iconst_0
    //   648: ireturn
    //   649: aload 15
    //   651: new 32	java/io/File
    //   654: dup
    //   655: aload_3
    //   656: aload 14
    //   658: invokespecial 35	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   661: putfield 226	com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo:file	Ljava/io/File;
    //   664: aload 15
    //   666: getfield 226	com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo:file	Ljava/io/File;
    //   669: invokestatic 135	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:ensureFileDirectory	(Ljava/io/File;)V
    //   672: aload 15
    //   674: getfield 229	com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo:md5	Ljava/lang/String;
    //   677: invokestatic 233	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:checkIfMd5Valid	(Ljava/lang/String;)Z
    //   680: ifne +63 -> 743
    //   683: ldc 37
    //   685: ldc 235
    //   687: iconst_3
    //   688: anewarray 41	java/lang/Object
    //   691: dup
    //   692: iconst_0
    //   693: bipush 6
    //   695: invokestatic 161	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:getTypeString	(I)Ljava/lang/String;
    //   698: aastore
    //   699: dup
    //   700: iconst_1
    //   701: aload 14
    //   703: aastore
    //   704: dup
    //   705: iconst_2
    //   706: aload 15
    //   708: getfield 229	com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo:md5	Ljava/lang/String;
    //   711: aastore
    //   712: invokestatic 47	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   715: aload 12
    //   717: getfield 51	com/tencent/tinker/lib/e/a:ahRI	Lcom/tencent/tinker/lib/d/d;
    //   720: aload 4
    //   722: bipush 6
    //   724: invokestatic 170	com/tencent/tinker/lib/c/c:aIW	(I)I
    //   727: invokeinterface 174 3 0
    //   732: aload_1
    //   733: invokestatic 62	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   736: aload 10
    //   738: invokestatic 62	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   741: iconst_0
    //   742: ireturn
    //   743: aload 10
    //   745: aload 14
    //   747: invokevirtual 30	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   750: astore 11
    //   752: aload 11
    //   754: ifnonnull +54 -> 808
    //   757: ldc 37
    //   759: ldc 237
    //   761: aload 14
    //   763: invokestatic 140	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   766: invokevirtual 144	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   769: iconst_0
    //   770: anewarray 41	java/lang/Object
    //   773: invokestatic 47	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   776: aload 12
    //   778: getfield 51	com/tencent/tinker/lib/e/a:ahRI	Lcom/tencent/tinker/lib/d/d;
    //   781: aload 4
    //   783: aload 15
    //   785: getfield 226	com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo:file	Ljava/io/File;
    //   788: aload 14
    //   790: bipush 6
    //   792: invokeinterface 56 5 0
    //   797: aload_1
    //   798: invokestatic 62	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   801: aload 10
    //   803: invokestatic 62	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   806: iconst_0
    //   807: ireturn
    //   808: aload_1
    //   809: aload 14
    //   811: invokevirtual 30	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   814: astore_2
    //   815: aload_2
    //   816: ifnonnull +54 -> 870
    //   819: ldc 37
    //   821: ldc 239
    //   823: aload 14
    //   825: invokestatic 140	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   828: invokevirtual 144	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   831: iconst_0
    //   832: anewarray 41	java/lang/Object
    //   835: invokestatic 47	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   838: aload 12
    //   840: getfield 51	com/tencent/tinker/lib/e/a:ahRI	Lcom/tencent/tinker/lib/d/d;
    //   843: aload 4
    //   845: aload 15
    //   847: getfield 226	com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo:file	Ljava/io/File;
    //   850: aload 14
    //   852: bipush 6
    //   854: invokeinterface 56 5 0
    //   859: aload_1
    //   860: invokestatic 62	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   863: aload 10
    //   865: invokestatic 62	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   868: iconst_0
    //   869: ireturn
    //   870: aconst_null
    //   871: astore_0
    //   872: aload_1
    //   873: aload_2
    //   874: invokevirtual 243	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   877: astore_2
    //   878: aload_2
    //   879: astore_0
    //   880: aload 10
    //   882: aload 11
    //   884: invokevirtual 243	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   887: astore 11
    //   889: aload_2
    //   890: aload 11
    //   892: aload 15
    //   894: getfield 226	com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo:file	Ljava/io/File;
    //   897: invokestatic 248	com/tencent/tinker/b/a:a	(Ljava/io/InputStream;Ljava/io/InputStream;Ljava/io/File;)I
    //   900: pop
    //   901: aload_2
    //   902: invokestatic 254	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   905: aload 11
    //   907: invokestatic 254	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   910: aload 15
    //   912: getfield 226	com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo:file	Ljava/io/File;
    //   915: aload 15
    //   917: getfield 229	com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo:md5	Ljava/lang/String;
    //   920: invokestatic 258	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:verifyFileMd5	(Ljava/io/File;Ljava/lang/String;)Z
    //   923: ifne +86 -> 1009
    //   926: ldc 37
    //   928: ldc_w 260
    //   931: iconst_1
    //   932: anewarray 41	java/lang/Object
    //   935: dup
    //   936: iconst_0
    //   937: aload 15
    //   939: getfield 226	com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo:file	Ljava/io/File;
    //   942: invokevirtual 184	java/io/File:getPath	()Ljava/lang/String;
    //   945: aastore
    //   946: invokestatic 47	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   949: aload 15
    //   951: getfield 226	com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo:file	Ljava/io/File;
    //   954: invokestatic 264	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:safeDeleteFile	(Ljava/io/File;)Z
    //   957: pop
    //   958: aload 12
    //   960: getfield 51	com/tencent/tinker/lib/e/a:ahRI	Lcom/tencent/tinker/lib/d/d;
    //   963: aload 4
    //   965: aload 15
    //   967: getfield 226	com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo:file	Ljava/io/File;
    //   970: aload 14
    //   972: bipush 6
    //   974: invokeinterface 56 5 0
    //   979: aload_1
    //   980: invokestatic 62	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   983: aload 10
    //   985: invokestatic 62	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   988: iconst_0
    //   989: ireturn
    //   990: astore 4
    //   992: aconst_null
    //   993: astore_3
    //   994: aload_0
    //   995: astore_2
    //   996: aload 4
    //   998: astore_0
    //   999: aload_2
    //   1000: invokestatic 254	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   1003: aload_3
    //   1004: invokestatic 254	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   1007: aload_0
    //   1008: athrow
    //   1009: ldc 37
    //   1011: ldc_w 266
    //   1014: iconst_3
    //   1015: anewarray 41	java/lang/Object
    //   1018: dup
    //   1019: iconst_0
    //   1020: aload 15
    //   1022: getfield 226	com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo:file	Ljava/io/File;
    //   1025: invokevirtual 184	java/io/File:getPath	()Ljava/lang/String;
    //   1028: aastore
    //   1029: dup
    //   1030: iconst_1
    //   1031: aload 15
    //   1033: getfield 226	com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo:file	Ljava/io/File;
    //   1036: invokevirtual 153	java/io/File:length	()J
    //   1039: invokestatic 166	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1042: aastore
    //   1043: dup
    //   1044: iconst_2
    //   1045: invokestatic 12	java/lang/System:currentTimeMillis	()J
    //   1048: lload 8
    //   1050: lsub
    //   1051: invokestatic 166	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1054: aastore
    //   1055: invokestatic 47	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1058: goto -508 -> 550
    //   1061: ldc 37
    //   1063: ldc_w 268
    //   1066: iconst_1
    //   1067: anewarray 41	java/lang/Object
    //   1070: dup
    //   1071: iconst_0
    //   1072: invokestatic 12	java/lang/System:currentTimeMillis	()J
    //   1075: lload 6
    //   1077: lsub
    //   1078: invokestatic 166	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1081: aastore
    //   1082: invokestatic 47	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1085: aload_1
    //   1086: invokestatic 62	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   1089: aload 10
    //   1091: invokestatic 62	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   1094: iconst_1
    //   1095: ireturn
    //   1096: astore_0
    //   1097: aload 11
    //   1099: astore_2
    //   1100: aload 10
    //   1102: astore_1
    //   1103: goto -620 -> 483
    //   1106: astore_0
    //   1107: aload 11
    //   1109: astore_2
    //   1110: goto -627 -> 483
    //   1113: astore_0
    //   1114: aload 11
    //   1116: astore_3
    //   1117: goto -118 -> 999
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1120	0	paramContext	android.content.Context
    //   0	1120	1	paramString	java.lang.String
    //   0	1120	2	paramFile1	java.io.File
    //   0	1120	3	paramFile2	java.io.File
    //   0	1120	4	paramFile3	java.io.File
    //   0	1120	5	paramShareResPatchInfo	com.tencent.tinker.loader.shareutil.ShareResPatchInfo
    //   3	1073	6	l1	long
    //   246	803	8	l2	long
    //   12	1089	10	localZipFile	java.util.zip.ZipFile
    //   15	1100	11	localObject1	java.lang.Object
    //   9	950	12	locala	com.tencent.tinker.lib.e.a
    //   270	291	13	localObject2	java.lang.Object
    //   570	401	14	str	java.lang.String
    //   590	442	15	localLargeModeInfo	com.tencent.tinker.loader.shareutil.ShareResPatchInfo.LargeModeInfo
    // Exception table:
    //   from	to	target	type
    //   210	224	479	finally
    //   224	272	479	finally
    //   277	312	479	finally
    //   323	411	479	finally
    //   422	476	479	finally
    //   540	550	479	finally
    //   550	592	479	finally
    //   597	638	479	finally
    //   649	732	479	finally
    //   743	752	479	finally
    //   757	797	479	finally
    //   808	815	479	finally
    //   819	859	479	finally
    //   901	979	479	finally
    //   999	1009	479	finally
    //   1009	1058	479	finally
    //   1061	1085	479	finally
    //   483	529	529	finally
    //   872	878	990	finally
    //   880	889	990	finally
    //   17	26	1096	finally
    //   26	44	1106	finally
    //   48	76	1106	finally
    //   86	146	1106	finally
    //   156	189	1106	finally
    //   199	210	1106	finally
    //   889	901	1113	finally
  }
  
  /* Error */
  static boolean c(android.content.Context paramContext, java.lang.String paramString1, java.lang.String paramString2, java.io.File paramFile)
  {
    // Byte code:
    //   0: new 75	com/tencent/tinker/loader/shareutil/ShareResPatchInfo
    //   3: dup
    //   4: invokespecial 274	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:<init>	()V
    //   7: astore 7
    //   9: aload_2
    //   10: aload 7
    //   12: invokestatic 278	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:parseAllResPatchInfo	(Ljava/lang/String;Lcom/tencent/tinker/loader/shareutil/ShareResPatchInfo;)V
    //   15: ldc 37
    //   17: ldc_w 280
    //   20: iconst_2
    //   21: anewarray 41	java/lang/Object
    //   24: dup
    //   25: iconst_0
    //   26: aload_1
    //   27: aastore
    //   28: dup
    //   29: iconst_1
    //   30: aload 7
    //   32: invokevirtual 281	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:toString	()Ljava/lang/String;
    //   35: aastore
    //   36: invokestatic 110	com/tencent/tinker/loader/shareutil/ShareTinkerLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   39: aload_0
    //   40: invokestatic 18	com/tencent/tinker/lib/e/a:oy	(Landroid/content/Context;)Lcom/tencent/tinker/lib/e/a;
    //   43: astore_2
    //   44: aload 7
    //   46: getfield 284	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:resArscMd5	Ljava/lang/String;
    //   49: invokestatic 233	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:checkIfMd5Valid	(Ljava/lang/String;)Z
    //   52: ifne +48 -> 100
    //   55: ldc 37
    //   57: ldc_w 286
    //   60: iconst_2
    //   61: anewarray 41	java/lang/Object
    //   64: dup
    //   65: iconst_0
    //   66: bipush 6
    //   68: invokestatic 161	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:getTypeString	(I)Ljava/lang/String;
    //   71: aastore
    //   72: dup
    //   73: iconst_1
    //   74: aload 7
    //   76: getfield 284	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:resArscMd5	Ljava/lang/String;
    //   79: aastore
    //   80: invokestatic 47	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   83: aload_2
    //   84: getfield 51	com/tencent/tinker/lib/e/a:ahRI	Lcom/tencent/tinker/lib/d/d;
    //   87: aload_3
    //   88: bipush 6
    //   90: invokestatic 170	com/tencent/tinker/lib/c/c:aIW	(I)I
    //   93: invokeinterface 174 3 0
    //   98: iconst_0
    //   99: ireturn
    //   100: new 32	java/io/File
    //   103: dup
    //   104: aload_1
    //   105: invokespecial 287	java/io/File:<init>	(Ljava/lang/String;)V
    //   108: astore_1
    //   109: new 32	java/io/File
    //   112: dup
    //   113: aload_1
    //   114: ldc_w 289
    //   117: invokespecial 35	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   120: astore 8
    //   122: new 32	java/io/File
    //   125: dup
    //   126: aload_1
    //   127: ldc_w 291
    //   130: invokespecial 35	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   133: astore 9
    //   135: aload 9
    //   137: invokevirtual 294	java/io/File:exists	()Z
    //   140: ifeq +99 -> 239
    //   143: aload 9
    //   145: aload 7
    //   147: getfield 284	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:resArscMd5	Ljava/lang/String;
    //   150: invokestatic 297	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:checkResourceArscMd5	(Ljava/io/File;Ljava/lang/String;)Z
    //   153: ifeq +25 -> 178
    //   156: ldc 37
    //   158: ldc_w 299
    //   161: iconst_1
    //   162: anewarray 41	java/lang/Object
    //   165: dup
    //   166: iconst_0
    //   167: aload 9
    //   169: invokevirtual 184	java/io/File:getPath	()Ljava/lang/String;
    //   172: aastore
    //   173: invokestatic 47	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   176: iconst_1
    //   177: ireturn
    //   178: ldc 37
    //   180: new 188	java/lang/StringBuilder
    //   183: dup
    //   184: ldc_w 301
    //   187: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   190: aload 9
    //   192: invokevirtual 184	java/io/File:getPath	()Ljava/lang/String;
    //   195: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: iconst_0
    //   202: anewarray 41	java/lang/Object
    //   205: invokestatic 47	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   208: aload 9
    //   210: invokevirtual 304	java/io/File:delete	()Z
    //   213: pop
    //   214: aload_0
    //   215: invokevirtual 310	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   218: astore 6
    //   220: aload 6
    //   222: ifnonnull +29 -> 251
    //   225: ldc 37
    //   227: ldc_w 312
    //   230: iconst_0
    //   231: anewarray 41	java/lang/Object
    //   234: invokestatic 47	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   237: iconst_0
    //   238: ireturn
    //   239: aload 9
    //   241: invokevirtual 316	java/io/File:getParentFile	()Ljava/io/File;
    //   244: invokevirtual 319	java/io/File:mkdirs	()Z
    //   247: pop
    //   248: goto -34 -> 214
    //   251: aload 6
    //   253: getfield 324	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   256: astore 10
    //   258: aload_0
    //   259: aload 10
    //   261: aload_1
    //   262: aload 8
    //   264: aload_3
    //   265: aload 7
    //   267: invokestatic 326	com/tencent/tinker/lib/c/f:a	(Landroid/content/Context;Ljava/lang/String;Ljava/io/File;Ljava/io/File;Ljava/io/File;Lcom/tencent/tinker/loader/shareutil/ShareResPatchInfo;)Z
    //   270: istore 5
    //   272: iload 5
    //   274: ifne +5 -> 279
    //   277: iconst_0
    //   278: ireturn
    //   279: new 328	com/tencent/tinker/d/a/i
    //   282: dup
    //   283: new 330	java/io/BufferedOutputStream
    //   286: dup
    //   287: new 332	java/io/FileOutputStream
    //   290: dup
    //   291: aload 9
    //   293: invokespecial 333	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   296: invokespecial 336	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   299: invokespecial 337	com/tencent/tinker/d/a/i:<init>	(Ljava/io/OutputStream;)V
    //   302: astore 6
    //   304: new 339	com/tencent/tinker/d/a/h
    //   307: dup
    //   308: aload 10
    //   310: invokespecial 340	com/tencent/tinker/d/a/h:<init>	(Ljava/lang/String;)V
    //   313: astore_0
    //   314: new 339	com/tencent/tinker/d/a/h
    //   317: dup
    //   318: aload_3
    //   319: invokespecial 341	com/tencent/tinker/d/a/h:<init>	(Ljava/io/File;)V
    //   322: astore_1
    //   323: aload_0
    //   324: invokevirtual 344	com/tencent/tinker/d/a/h:kcl	()V
    //   327: new 346	com/tencent/tinker/d/a/h$1
    //   330: dup
    //   331: aload_0
    //   332: aload_0
    //   333: getfield 350	com/tencent/tinker/d/a/h:ahSB	Ljava/util/LinkedHashMap;
    //   336: invokevirtual 356	java/util/LinkedHashMap:values	()Ljava/util/Collection;
    //   339: invokeinterface 359 1 0
    //   344: invokespecial 362	com/tencent/tinker/d/a/h$1:<init>	(Lcom/tencent/tinker/d/a/h;Ljava/util/Iterator;)V
    //   347: astore 10
    //   349: iconst_0
    //   350: istore 4
    //   352: aload 10
    //   354: invokeinterface 367 1 0
    //   359: ifeq +206 -> 565
    //   362: aload 10
    //   364: invokeinterface 370 1 0
    //   369: checkcast 372	com/tencent/tinker/d/a/g
    //   372: astore 11
    //   374: aload 11
    //   376: ifnonnull +91 -> 467
    //   379: new 186	com/tencent/tinker/loader/TinkerRuntimeException
    //   382: dup
    //   383: ldc_w 374
    //   386: invokespecial 375	com/tencent/tinker/loader/TinkerRuntimeException:<init>	(Ljava/lang/String;)V
    //   389: athrow
    //   390: astore 7
    //   392: aload 6
    //   394: astore_3
    //   395: aload_0
    //   396: astore_2
    //   397: aload 7
    //   399: astore_0
    //   400: aload_3
    //   401: invokestatic 254	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   404: aload_2
    //   405: invokestatic 254	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   408: aload_1
    //   409: invokestatic 254	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   412: aload 8
    //   414: invokestatic 378	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:deleteDir	(Ljava/io/File;)Z
    //   417: pop
    //   418: aload_0
    //   419: athrow
    //   420: astore_0
    //   421: new 186	com/tencent/tinker/loader/TinkerRuntimeException
    //   424: dup
    //   425: new 188	java/lang/StringBuilder
    //   428: dup
    //   429: ldc 190
    //   431: invokespecial 191	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   434: bipush 6
    //   436: invokestatic 161	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:getTypeString	(I)Ljava/lang/String;
    //   439: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: ldc 197
    //   444: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: aload_0
    //   448: invokevirtual 202	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   451: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: ldc 204
    //   456: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   462: aload_0
    //   463: invokespecial 210	com/tencent/tinker/loader/TinkerRuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   466: athrow
    //   467: aload 11
    //   469: getfield 381	com/tencent/tinker/d/a/g:name	Ljava/lang/String;
    //   472: astore 12
    //   474: aload 12
    //   476: ldc_w 383
    //   479: invokevirtual 387	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   482: ifne -130 -> 352
    //   485: aload 7
    //   487: getfield 391	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:patterns	Ljava/util/HashSet;
    //   490: aload 12
    //   492: invokestatic 395	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:checkFileInPattern	(Ljava/util/HashSet;Ljava/lang/String;)Z
    //   495: ifeq +821 -> 1316
    //   498: aload 7
    //   500: getfield 398	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:deleteRes	Ljava/util/ArrayList;
    //   503: aload 12
    //   505: invokevirtual 400	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   508: ifne +808 -> 1316
    //   511: aload 7
    //   513: getfield 403	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:modRes	Ljava/util/ArrayList;
    //   516: aload 12
    //   518: invokevirtual 400	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   521: ifne +795 -> 1316
    //   524: aload 7
    //   526: getfield 92	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:largeModRes	Ljava/util/ArrayList;
    //   529: aload 12
    //   531: invokevirtual 400	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   534: ifne +782 -> 1316
    //   537: aload 12
    //   539: ldc_w 405
    //   542: invokevirtual 83	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   545: ifne +771 -> 1316
    //   548: aload_0
    //   549: aload 11
    //   551: aload 6
    //   553: invokestatic 410	com/tencent/tinker/d/a/j:a	(Lcom/tencent/tinker/d/a/h;Lcom/tencent/tinker/d/a/g;Lcom/tencent/tinker/d/a/i;)V
    //   556: iload 4
    //   558: iconst_1
    //   559: iadd
    //   560: istore 4
    //   562: goto +754 -> 1316
    //   565: aload_0
    //   566: ldc_w 405
    //   569: invokevirtual 414	com/tencent/tinker/d/a/h:bGp	(Ljava/lang/String;)Lcom/tencent/tinker/d/a/g;
    //   572: astore 10
    //   574: aload 10
    //   576: ifnonnull +53 -> 629
    //   579: ldc 37
    //   581: ldc_w 416
    //   584: iconst_0
    //   585: anewarray 41	java/lang/Object
    //   588: invokestatic 47	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   591: aload_2
    //   592: getfield 51	com/tencent/tinker/lib/e/a:ahRI	Lcom/tencent/tinker/lib/d/d;
    //   595: aload_3
    //   596: aload 9
    //   598: ldc_w 405
    //   601: bipush 6
    //   603: invokeinterface 56 5 0
    //   608: aload 6
    //   610: invokestatic 254	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   613: aload_0
    //   614: invokestatic 254	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   617: aload_1
    //   618: invokestatic 254	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   621: aload 8
    //   623: invokestatic 378	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:deleteDir	(Ljava/io/File;)Z
    //   626: pop
    //   627: iconst_0
    //   628: ireturn
    //   629: aload_0
    //   630: aload 10
    //   632: aload 6
    //   634: invokestatic 410	com/tencent/tinker/d/a/j:a	(Lcom/tencent/tinker/d/a/h;Lcom/tencent/tinker/d/a/g;Lcom/tencent/tinker/d/a/i;)V
    //   637: iload 4
    //   639: iconst_1
    //   640: iadd
    //   641: istore 4
    //   643: aload 7
    //   645: getfield 92	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:largeModRes	Ljava/util/ArrayList;
    //   648: invokevirtual 211	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   651: astore 10
    //   653: aload 10
    //   655: invokeinterface 128 1 0
    //   660: ifeq +126 -> 786
    //   663: aload 10
    //   665: invokeinterface 132 1 0
    //   670: checkcast 69	java/lang/String
    //   673: astore 12
    //   675: aload_0
    //   676: aload 12
    //   678: invokevirtual 414	com/tencent/tinker/d/a/h:bGp	(Ljava/lang/String;)Lcom/tencent/tinker/d/a/g;
    //   681: astore 11
    //   683: aload 11
    //   685: ifnonnull +60 -> 745
    //   688: ldc 37
    //   690: ldc_w 418
    //   693: aload 12
    //   695: invokestatic 140	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   698: invokevirtual 144	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   701: iconst_0
    //   702: anewarray 41	java/lang/Object
    //   705: invokestatic 47	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   708: aload_2
    //   709: getfield 51	com/tencent/tinker/lib/e/a:ahRI	Lcom/tencent/tinker/lib/d/d;
    //   712: aload_3
    //   713: aload 9
    //   715: aload 12
    //   717: bipush 6
    //   719: invokeinterface 56 5 0
    //   724: aload 6
    //   726: invokestatic 254	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   729: aload_0
    //   730: invokestatic 254	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   733: aload_1
    //   734: invokestatic 254	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   737: aload 8
    //   739: invokestatic 378	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:deleteDir	(Ljava/io/File;)Z
    //   742: pop
    //   743: iconst_0
    //   744: ireturn
    //   745: aload 7
    //   747: getfield 214	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:largeModMap	Ljava/util/HashMap;
    //   750: aload 12
    //   752: invokevirtual 218	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   755: checkcast 220	com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo
    //   758: astore 12
    //   760: aload 11
    //   762: aload 12
    //   764: getfield 226	com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo:file	Ljava/io/File;
    //   767: aload 12
    //   769: getfield 422	com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo:crc	J
    //   772: aload 6
    //   774: invokestatic 425	com/tencent/tinker/d/a/j:a	(Lcom/tencent/tinker/d/a/g;Ljava/io/File;JLcom/tencent/tinker/d/a/i;)V
    //   777: iload 4
    //   779: iconst_1
    //   780: iadd
    //   781: istore 4
    //   783: goto -130 -> 653
    //   786: aload 7
    //   788: getfield 428	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:addRes	Ljava/util/ArrayList;
    //   791: invokevirtual 211	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   794: astore 10
    //   796: aload 10
    //   798: invokeinterface 128 1 0
    //   803: ifeq +137 -> 940
    //   806: aload 10
    //   808: invokeinterface 132 1 0
    //   813: checkcast 69	java/lang/String
    //   816: astore 11
    //   818: aload_1
    //   819: aload 11
    //   821: invokevirtual 414	com/tencent/tinker/d/a/h:bGp	(Ljava/lang/String;)Lcom/tencent/tinker/d/a/g;
    //   824: astore 12
    //   826: aload 12
    //   828: ifnonnull +60 -> 888
    //   831: ldc 37
    //   833: ldc_w 430
    //   836: aload 11
    //   838: invokestatic 140	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   841: invokevirtual 144	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   844: iconst_0
    //   845: anewarray 41	java/lang/Object
    //   848: invokestatic 47	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   851: aload_2
    //   852: getfield 51	com/tencent/tinker/lib/e/a:ahRI	Lcom/tencent/tinker/lib/d/d;
    //   855: aload_3
    //   856: aload 9
    //   858: aload 11
    //   860: bipush 6
    //   862: invokeinterface 56 5 0
    //   867: aload 6
    //   869: invokestatic 254	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   872: aload_0
    //   873: invokestatic 254	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   876: aload_1
    //   877: invokestatic 254	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   880: aload 8
    //   882: invokestatic 378	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:deleteDir	(Ljava/io/File;)Z
    //   885: pop
    //   886: iconst_0
    //   887: ireturn
    //   888: aload 7
    //   890: getfield 102	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:storeRes	Ljava/util/HashMap;
    //   893: aload 11
    //   895: invokevirtual 433	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   898: ifeq +31 -> 929
    //   901: aload 12
    //   903: aload 7
    //   905: getfield 102	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:storeRes	Ljava/util/HashMap;
    //   908: aload 11
    //   910: invokevirtual 218	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   913: checkcast 32	java/io/File
    //   916: aload 12
    //   918: getfield 434	com/tencent/tinker/d/a/g:crc	J
    //   921: aload 6
    //   923: invokestatic 425	com/tencent/tinker/d/a/j:a	(Lcom/tencent/tinker/d/a/g;Ljava/io/File;JLcom/tencent/tinker/d/a/i;)V
    //   926: goto +393 -> 1319
    //   929: aload_1
    //   930: aload 12
    //   932: aload 6
    //   934: invokestatic 410	com/tencent/tinker/d/a/j:a	(Lcom/tencent/tinker/d/a/h;Lcom/tencent/tinker/d/a/g;Lcom/tencent/tinker/d/a/i;)V
    //   937: goto +382 -> 1319
    //   940: aload 7
    //   942: getfield 403	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:modRes	Ljava/util/ArrayList;
    //   945: invokevirtual 211	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   948: astore 10
    //   950: aload 10
    //   952: invokeinterface 128 1 0
    //   957: ifeq +137 -> 1094
    //   960: aload 10
    //   962: invokeinterface 132 1 0
    //   967: checkcast 69	java/lang/String
    //   970: astore 11
    //   972: aload_1
    //   973: aload 11
    //   975: invokevirtual 414	com/tencent/tinker/d/a/h:bGp	(Ljava/lang/String;)Lcom/tencent/tinker/d/a/g;
    //   978: astore 12
    //   980: aload 12
    //   982: ifnonnull +60 -> 1042
    //   985: ldc 37
    //   987: ldc_w 436
    //   990: aload 11
    //   992: invokestatic 140	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   995: invokevirtual 144	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   998: iconst_0
    //   999: anewarray 41	java/lang/Object
    //   1002: invokestatic 47	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1005: aload_2
    //   1006: getfield 51	com/tencent/tinker/lib/e/a:ahRI	Lcom/tencent/tinker/lib/d/d;
    //   1009: aload_3
    //   1010: aload 9
    //   1012: aload 11
    //   1014: bipush 6
    //   1016: invokeinterface 56 5 0
    //   1021: aload 6
    //   1023: invokestatic 254	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   1026: aload_0
    //   1027: invokestatic 254	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   1030: aload_1
    //   1031: invokestatic 254	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   1034: aload 8
    //   1036: invokestatic 378	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:deleteDir	(Ljava/io/File;)Z
    //   1039: pop
    //   1040: iconst_0
    //   1041: ireturn
    //   1042: aload 7
    //   1044: getfield 102	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:storeRes	Ljava/util/HashMap;
    //   1047: aload 11
    //   1049: invokevirtual 433	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   1052: ifeq +31 -> 1083
    //   1055: aload 12
    //   1057: aload 7
    //   1059: getfield 102	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:storeRes	Ljava/util/HashMap;
    //   1062: aload 11
    //   1064: invokevirtual 218	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1067: checkcast 32	java/io/File
    //   1070: aload 12
    //   1072: getfield 434	com/tencent/tinker/d/a/g:crc	J
    //   1075: aload 6
    //   1077: invokestatic 425	com/tencent/tinker/d/a/j:a	(Lcom/tencent/tinker/d/a/g;Ljava/io/File;JLcom/tencent/tinker/d/a/i;)V
    //   1080: goto +248 -> 1328
    //   1083: aload_1
    //   1084: aload 12
    //   1086: aload 6
    //   1088: invokestatic 410	com/tencent/tinker/d/a/j:a	(Lcom/tencent/tinker/d/a/h;Lcom/tencent/tinker/d/a/g;Lcom/tencent/tinker/d/a/i;)V
    //   1091: goto +237 -> 1328
    //   1094: aload_0
    //   1095: invokevirtual 344	com/tencent/tinker/d/a/h:kcl	()V
    //   1098: aload_0
    //   1099: getfield 439	com/tencent/tinker/d/a/h:comment	Ljava/lang/String;
    //   1102: astore 10
    //   1104: aload 10
    //   1106: ifnonnull +107 -> 1213
    //   1109: aload 6
    //   1111: getstatic 443	com/tencent/tinker/d/a/i:ahSG	[B
    //   1114: putfield 446	com/tencent/tinker/d/a/i:ahSl	[B
    //   1117: aload 6
    //   1119: invokestatic 254	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   1122: aload_0
    //   1123: invokestatic 254	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   1126: aload_1
    //   1127: invokestatic 254	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   1130: aload 8
    //   1132: invokestatic 378	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:deleteDir	(Ljava/io/File;)Z
    //   1135: pop
    //   1136: aload 9
    //   1138: aload 7
    //   1140: getfield 284	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:resArscMd5	Ljava/lang/String;
    //   1143: invokestatic 297	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:checkResourceArscMd5	(Ljava/io/File;Ljava/lang/String;)Z
    //   1146: ifne +95 -> 1241
    //   1149: ldc 37
    //   1151: ldc_w 448
    //   1154: iconst_3
    //   1155: anewarray 41	java/lang/Object
    //   1158: dup
    //   1159: iconst_0
    //   1160: aload 9
    //   1162: invokevirtual 451	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1165: aastore
    //   1166: dup
    //   1167: iconst_1
    //   1168: iload 4
    //   1170: invokestatic 456	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1173: aastore
    //   1174: dup
    //   1175: iconst_2
    //   1176: aload 9
    //   1178: invokevirtual 153	java/io/File:length	()J
    //   1181: invokestatic 166	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1184: aastore
    //   1185: invokestatic 110	com/tencent/tinker/loader/shareutil/ShareTinkerLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1188: aload 9
    //   1190: invokestatic 264	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:safeDeleteFile	(Ljava/io/File;)Z
    //   1193: pop
    //   1194: aload_2
    //   1195: getfield 51	com/tencent/tinker/lib/e/a:ahRI	Lcom/tencent/tinker/lib/d/d;
    //   1198: aload_3
    //   1199: aload 9
    //   1201: ldc_w 291
    //   1204: bipush 6
    //   1206: invokeinterface 56 5 0
    //   1211: iconst_0
    //   1212: ireturn
    //   1213: aload 10
    //   1215: getstatic 462	com/tencent/tinker/d/a/e:UTF_8	Ljava/nio/charset/Charset;
    //   1218: invokevirtual 466	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
    //   1221: astore 10
    //   1223: ldc_w 468
    //   1226: aload 10
    //   1228: invokestatic 472	com/tencent/tinker/d/a/i:L	(Ljava/lang/String;[B)V
    //   1231: aload 6
    //   1233: aload 10
    //   1235: putfield 446	com/tencent/tinker/d/a/i:ahSl	[B
    //   1238: goto -121 -> 1117
    //   1241: ldc 37
    //   1243: ldc_w 474
    //   1246: iconst_3
    //   1247: anewarray 41	java/lang/Object
    //   1250: dup
    //   1251: iconst_0
    //   1252: aload 9
    //   1254: invokevirtual 451	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1257: aastore
    //   1258: dup
    //   1259: iconst_1
    //   1260: iload 4
    //   1262: invokestatic 456	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1265: aastore
    //   1266: dup
    //   1267: iconst_2
    //   1268: aload 9
    //   1270: invokevirtual 153	java/io/File:length	()J
    //   1273: invokestatic 166	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1276: aastore
    //   1277: invokestatic 110	com/tencent/tinker/loader/shareutil/ShareTinkerLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1280: iconst_1
    //   1281: ireturn
    //   1282: astore_0
    //   1283: aconst_null
    //   1284: astore_1
    //   1285: aconst_null
    //   1286: astore_2
    //   1287: aconst_null
    //   1288: astore_3
    //   1289: goto -889 -> 400
    //   1292: astore_0
    //   1293: aconst_null
    //   1294: astore_1
    //   1295: aconst_null
    //   1296: astore_2
    //   1297: aload 6
    //   1299: astore_3
    //   1300: goto -900 -> 400
    //   1303: astore_3
    //   1304: aconst_null
    //   1305: astore_1
    //   1306: aload_0
    //   1307: astore_2
    //   1308: aload_3
    //   1309: astore_0
    //   1310: aload 6
    //   1312: astore_3
    //   1313: goto -913 -> 400
    //   1316: goto -964 -> 352
    //   1319: iload 4
    //   1321: iconst_1
    //   1322: iadd
    //   1323: istore 4
    //   1325: goto -529 -> 796
    //   1328: iload 4
    //   1330: iconst_1
    //   1331: iadd
    //   1332: istore 4
    //   1334: goto -384 -> 950
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1337	0	paramContext	android.content.Context
    //   0	1337	1	paramString1	java.lang.String
    //   0	1337	2	paramString2	java.lang.String
    //   0	1337	3	paramFile	java.io.File
    //   350	983	4	i	int
    //   270	3	5	bool	boolean
    //   218	1093	6	localObject1	java.lang.Object
    //   7	259	7	localShareResPatchInfo	com.tencent.tinker.loader.shareutil.ShareResPatchInfo
    //   390	749	7	localObject2	java.lang.Object
    //   120	1011	8	localFile1	java.io.File
    //   133	1136	9	localFile2	java.io.File
    //   256	978	10	localObject3	java.lang.Object
    //   372	691	11	localObject4	java.lang.Object
    //   472	613	12	localObject5	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   323	349	390	finally
    //   352	374	390	finally
    //   379	390	390	finally
    //   467	556	390	finally
    //   565	574	390	finally
    //   579	608	390	finally
    //   629	637	390	finally
    //   643	653	390	finally
    //   653	683	390	finally
    //   688	724	390	finally
    //   745	777	390	finally
    //   786	796	390	finally
    //   796	826	390	finally
    //   831	867	390	finally
    //   888	926	390	finally
    //   929	937	390	finally
    //   940	950	390	finally
    //   950	980	390	finally
    //   985	1021	390	finally
    //   1042	1080	390	finally
    //   1083	1091	390	finally
    //   1094	1104	390	finally
    //   1109	1117	390	finally
    //   1213	1238	390	finally
    //   214	220	420	finally
    //   225	237	420	finally
    //   251	272	420	finally
    //   400	420	420	finally
    //   608	627	420	finally
    //   724	743	420	finally
    //   867	886	420	finally
    //   1021	1040	420	finally
    //   1117	1211	420	finally
    //   1241	1280	420	finally
    //   279	304	1282	finally
    //   304	314	1292	finally
    //   314	323	1303	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.lib.c.f
 * JD-Core Version:    0.7.0.1
 */