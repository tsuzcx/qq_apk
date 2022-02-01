package com.tencent.tinker.lib.c;

public final class f
  extends c
{
  /* Error */
  private static boolean a(android.content.Context paramContext, java.lang.String paramString, java.io.File paramFile1, java.io.File paramFile2, java.io.File paramFile3, com.tencent.tinker.loader.shareutil.ShareResPatchInfo paramShareResPatchInfo)
  {
    // Byte code:
    //   0: invokestatic 14	java/lang/System:currentTimeMillis	()J
    //   3: lstore 6
    //   5: aload_0
    //   6: invokestatic 20	com/tencent/tinker/lib/e/a:lk	(Landroid/content/Context;)Lcom/tencent/tinker/lib/e/a;
    //   9: astore 12
    //   11: aconst_null
    //   12: astore_0
    //   13: aconst_null
    //   14: astore 11
    //   16: new 22	java/util/zip/ZipFile
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 26	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   24: astore 10
    //   26: aload 10
    //   28: ldc 28
    //   30: invokevirtual 32	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   33: astore_0
    //   34: new 34	java/io/File
    //   37: dup
    //   38: aload_2
    //   39: ldc 28
    //   41: invokespecial 37	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   44: astore_1
    //   45: aload_0
    //   46: ifnonnull +42 -> 88
    //   49: ldc 39
    //   51: ldc 41
    //   53: iconst_0
    //   54: anewarray 43	java/lang/Object
    //   57: invokestatic 49	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   60: aload 12
    //   62: getfield 53	com/tencent/tinker/lib/e/a:MgW	Lcom/tencent/tinker/lib/d/d;
    //   65: aload 4
    //   67: aload_1
    //   68: ldc 28
    //   70: bipush 6
    //   72: invokeinterface 58 5 0
    //   77: aload 10
    //   79: invokestatic 64	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   82: aconst_null
    //   83: invokestatic 64	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   86: iconst_0
    //   87: ireturn
    //   88: aload_0
    //   89: invokevirtual 69	java/util/zip/ZipEntry:getCrc	()J
    //   92: invokestatic 75	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   95: astore_0
    //   96: aload_0
    //   97: aload 5
    //   99: getfield 81	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:arscBaseCrc	Ljava/lang/String;
    //   102: invokevirtual 85	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   105: ifne +54 -> 159
    //   108: ldc 39
    //   110: ldc 87
    //   112: iconst_2
    //   113: anewarray 43	java/lang/Object
    //   116: dup
    //   117: iconst_0
    //   118: aload 5
    //   120: getfield 81	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:arscBaseCrc	Ljava/lang/String;
    //   123: aastore
    //   124: dup
    //   125: iconst_1
    //   126: aload_0
    //   127: aastore
    //   128: invokestatic 90	com/tencent/tinker/loader/shareutil/ShareTinkerLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   131: aload 12
    //   133: getfield 53	com/tencent/tinker/lib/e/a:MgW	Lcom/tencent/tinker/lib/d/d;
    //   136: aload 4
    //   138: aload_1
    //   139: ldc 28
    //   141: bipush 6
    //   143: invokeinterface 58 5 0
    //   148: aload 10
    //   150: invokestatic 64	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   153: aconst_null
    //   154: invokestatic 64	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   157: iconst_0
    //   158: ireturn
    //   159: aload 5
    //   161: getfield 94	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:largeModRes	Ljava/util/ArrayList;
    //   164: invokevirtual 100	java/util/ArrayList:isEmpty	()Z
    //   167: ifeq +36 -> 203
    //   170: aload 5
    //   172: getfield 104	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:storeRes	Ljava/util/HashMap;
    //   175: invokevirtual 107	java/util/HashMap:isEmpty	()Z
    //   178: ifeq +25 -> 203
    //   181: ldc 39
    //   183: ldc 109
    //   185: iconst_0
    //   186: anewarray 43	java/lang/Object
    //   189: invokestatic 112	com/tencent/tinker/loader/shareutil/ShareTinkerLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   192: aload 10
    //   194: invokestatic 64	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   197: aconst_null
    //   198: invokestatic 64	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   201: iconst_1
    //   202: ireturn
    //   203: new 22	java/util/zip/ZipFile
    //   206: dup
    //   207: aload 4
    //   209: invokespecial 115	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   212: astore_1
    //   213: aload 5
    //   215: getfield 104	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:storeRes	Ljava/util/HashMap;
    //   218: invokevirtual 119	java/util/HashMap:keySet	()Ljava/util/Set;
    //   221: invokeinterface 125 1 0
    //   226: astore_0
    //   227: aload_0
    //   228: invokeinterface 130 1 0
    //   233: ifeq +314 -> 547
    //   236: aload_0
    //   237: invokeinterface 134 1 0
    //   242: checkcast 71	java/lang/String
    //   245: astore_2
    //   246: invokestatic 14	java/lang/System:currentTimeMillis	()J
    //   249: lstore 8
    //   251: new 34	java/io/File
    //   254: dup
    //   255: aload_3
    //   256: aload_2
    //   257: invokespecial 37	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   260: astore 11
    //   262: aload 11
    //   264: invokestatic 137	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:ensureFileDirectory	(Ljava/io/File;)V
    //   267: aload_1
    //   268: aload_2
    //   269: invokevirtual 32	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   272: astore 13
    //   274: aload 13
    //   276: ifnonnull +49 -> 325
    //   279: ldc 39
    //   281: ldc 139
    //   283: aload_2
    //   284: invokestatic 142	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   287: invokevirtual 146	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   290: iconst_0
    //   291: anewarray 43	java/lang/Object
    //   294: invokestatic 49	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   297: aload 12
    //   299: getfield 53	com/tencent/tinker/lib/e/a:MgW	Lcom/tencent/tinker/lib/d/d;
    //   302: aload 4
    //   304: aload 11
    //   306: aload_2
    //   307: bipush 6
    //   309: invokeinterface 58 5 0
    //   314: aload 10
    //   316: invokestatic 64	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   319: aload_1
    //   320: invokestatic 64	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   323: iconst_0
    //   324: ireturn
    //   325: aload_1
    //   326: aload 13
    //   328: aload 11
    //   330: aconst_null
    //   331: iconst_0
    //   332: invokestatic 149	com/tencent/tinker/lib/c/f:a	(Ljava/util/zip/ZipFile;Ljava/util/zip/ZipEntry;Ljava/io/File;Ljava/lang/String;Z)Z
    //   335: pop
    //   336: aload 13
    //   338: invokevirtual 152	java/util/zip/ZipEntry:getSize	()J
    //   341: aload 11
    //   343: invokevirtual 155	java/io/File:length	()J
    //   346: lcmp
    //   347: ifeq +76 -> 423
    //   350: ldc 39
    //   352: ldc 157
    //   354: iconst_4
    //   355: anewarray 43	java/lang/Object
    //   358: dup
    //   359: iconst_0
    //   360: bipush 6
    //   362: invokestatic 163	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:getTypeString	(I)Ljava/lang/String;
    //   365: aastore
    //   366: dup
    //   367: iconst_1
    //   368: aload_2
    //   369: aastore
    //   370: dup
    //   371: iconst_2
    //   372: aload 13
    //   374: invokevirtual 152	java/util/zip/ZipEntry:getSize	()J
    //   377: invokestatic 168	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   380: aastore
    //   381: dup
    //   382: iconst_3
    //   383: aload 11
    //   385: invokevirtual 155	java/io/File:length	()J
    //   388: invokestatic 168	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   391: aastore
    //   392: invokestatic 49	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   395: aload 12
    //   397: getfield 53	com/tencent/tinker/lib/e/a:MgW	Lcom/tencent/tinker/lib/d/d;
    //   400: aload 4
    //   402: bipush 6
    //   404: invokestatic 172	com/tencent/tinker/lib/c/c:ail	(I)I
    //   407: invokeinterface 175 3 0
    //   412: aload 10
    //   414: invokestatic 64	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   417: aload_1
    //   418: invokestatic 64	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   421: iconst_0
    //   422: ireturn
    //   423: aload 5
    //   425: getfield 104	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:storeRes	Ljava/util/HashMap;
    //   428: aload_2
    //   429: aload 11
    //   431: invokevirtual 179	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   434: pop
    //   435: ldc 39
    //   437: ldc 181
    //   439: iconst_3
    //   440: anewarray 43	java/lang/Object
    //   443: dup
    //   444: iconst_0
    //   445: aload 11
    //   447: invokevirtual 185	java/io/File:getPath	()Ljava/lang/String;
    //   450: aastore
    //   451: dup
    //   452: iconst_1
    //   453: aload 11
    //   455: invokevirtual 155	java/io/File:length	()J
    //   458: invokestatic 168	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   461: aastore
    //   462: dup
    //   463: iconst_2
    //   464: invokestatic 14	java/lang/System:currentTimeMillis	()J
    //   467: lload 8
    //   469: lsub
    //   470: invokestatic 168	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   473: aastore
    //   474: invokestatic 49	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   477: goto -250 -> 227
    //   480: astore_2
    //   481: aload 10
    //   483: astore_0
    //   484: new 187	com/tencent/tinker/loader/TinkerRuntimeException
    //   487: dup
    //   488: new 189	java/lang/StringBuilder
    //   491: dup
    //   492: ldc 191
    //   494: invokespecial 192	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   497: bipush 6
    //   499: invokestatic 163	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:getTypeString	(I)Ljava/lang/String;
    //   502: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: ldc 198
    //   507: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: aload_2
    //   511: invokevirtual 201	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   514: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: ldc 203
    //   519: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   525: aload_2
    //   526: invokespecial 209	com/tencent/tinker/loader/TinkerRuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   529: athrow
    //   530: astore_2
    //   531: aload_0
    //   532: astore 10
    //   534: aload_2
    //   535: astore_0
    //   536: aload 10
    //   538: invokestatic 64	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   541: aload_1
    //   542: invokestatic 64	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   545: aload_0
    //   546: athrow
    //   547: aload 5
    //   549: getfield 94	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:largeModRes	Ljava/util/ArrayList;
    //   552: invokevirtual 210	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   555: astore 13
    //   557: aload 13
    //   559: invokeinterface 130 1 0
    //   564: ifeq +504 -> 1068
    //   567: aload 13
    //   569: invokeinterface 134 1 0
    //   574: checkcast 71	java/lang/String
    //   577: astore 14
    //   579: invokestatic 14	java/lang/System:currentTimeMillis	()J
    //   582: lstore 8
    //   584: aload 5
    //   586: getfield 213	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:largeModMap	Ljava/util/HashMap;
    //   589: aload 14
    //   591: invokevirtual 217	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   594: checkcast 219	com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo
    //   597: astore 15
    //   599: aload 15
    //   601: ifnonnull +55 -> 656
    //   604: ldc 39
    //   606: ldc 221
    //   608: iconst_2
    //   609: anewarray 43	java/lang/Object
    //   612: dup
    //   613: iconst_0
    //   614: bipush 6
    //   616: invokestatic 163	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:getTypeString	(I)Ljava/lang/String;
    //   619: aastore
    //   620: dup
    //   621: iconst_1
    //   622: aload 14
    //   624: aastore
    //   625: invokestatic 49	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   628: aload 12
    //   630: getfield 53	com/tencent/tinker/lib/e/a:MgW	Lcom/tencent/tinker/lib/d/d;
    //   633: aload 4
    //   635: bipush 6
    //   637: invokestatic 172	com/tencent/tinker/lib/c/c:ail	(I)I
    //   640: invokeinterface 175 3 0
    //   645: aload 10
    //   647: invokestatic 64	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   650: aload_1
    //   651: invokestatic 64	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   654: iconst_0
    //   655: ireturn
    //   656: aload 15
    //   658: new 34	java/io/File
    //   661: dup
    //   662: aload_3
    //   663: aload 14
    //   665: invokespecial 37	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   668: putfield 225	com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo:file	Ljava/io/File;
    //   671: aload 15
    //   673: getfield 225	com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo:file	Ljava/io/File;
    //   676: invokestatic 137	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:ensureFileDirectory	(Ljava/io/File;)V
    //   679: aload 15
    //   681: getfield 228	com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo:md5	Ljava/lang/String;
    //   684: invokestatic 232	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:checkIfMd5Valid	(Ljava/lang/String;)Z
    //   687: ifne +63 -> 750
    //   690: ldc 39
    //   692: ldc 234
    //   694: iconst_3
    //   695: anewarray 43	java/lang/Object
    //   698: dup
    //   699: iconst_0
    //   700: bipush 6
    //   702: invokestatic 163	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:getTypeString	(I)Ljava/lang/String;
    //   705: aastore
    //   706: dup
    //   707: iconst_1
    //   708: aload 14
    //   710: aastore
    //   711: dup
    //   712: iconst_2
    //   713: aload 15
    //   715: getfield 228	com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo:md5	Ljava/lang/String;
    //   718: aastore
    //   719: invokestatic 49	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   722: aload 12
    //   724: getfield 53	com/tencent/tinker/lib/e/a:MgW	Lcom/tencent/tinker/lib/d/d;
    //   727: aload 4
    //   729: bipush 6
    //   731: invokestatic 172	com/tencent/tinker/lib/c/c:ail	(I)I
    //   734: invokeinterface 175 3 0
    //   739: aload 10
    //   741: invokestatic 64	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   744: aload_1
    //   745: invokestatic 64	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   748: iconst_0
    //   749: ireturn
    //   750: aload_1
    //   751: aload 14
    //   753: invokevirtual 32	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   756: astore 11
    //   758: aload 11
    //   760: ifnonnull +54 -> 814
    //   763: ldc 39
    //   765: ldc 236
    //   767: aload 14
    //   769: invokestatic 142	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   772: invokevirtual 146	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   775: iconst_0
    //   776: anewarray 43	java/lang/Object
    //   779: invokestatic 49	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   782: aload 12
    //   784: getfield 53	com/tencent/tinker/lib/e/a:MgW	Lcom/tencent/tinker/lib/d/d;
    //   787: aload 4
    //   789: aload 15
    //   791: getfield 225	com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo:file	Ljava/io/File;
    //   794: aload 14
    //   796: bipush 6
    //   798: invokeinterface 58 5 0
    //   803: aload 10
    //   805: invokestatic 64	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   808: aload_1
    //   809: invokestatic 64	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   812: iconst_0
    //   813: ireturn
    //   814: aload 10
    //   816: aload 14
    //   818: invokevirtual 32	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   821: astore_2
    //   822: aload_2
    //   823: ifnonnull +54 -> 877
    //   826: ldc 39
    //   828: ldc 238
    //   830: aload 14
    //   832: invokestatic 142	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   835: invokevirtual 146	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   838: iconst_0
    //   839: anewarray 43	java/lang/Object
    //   842: invokestatic 49	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   845: aload 12
    //   847: getfield 53	com/tencent/tinker/lib/e/a:MgW	Lcom/tencent/tinker/lib/d/d;
    //   850: aload 4
    //   852: aload 15
    //   854: getfield 225	com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo:file	Ljava/io/File;
    //   857: aload 14
    //   859: bipush 6
    //   861: invokeinterface 58 5 0
    //   866: aload 10
    //   868: invokestatic 64	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   871: aload_1
    //   872: invokestatic 64	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   875: iconst_0
    //   876: ireturn
    //   877: aconst_null
    //   878: astore_0
    //   879: aload 10
    //   881: aload_2
    //   882: invokevirtual 242	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   885: astore_2
    //   886: aload_2
    //   887: astore_0
    //   888: aload_1
    //   889: aload 11
    //   891: invokevirtual 242	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   894: astore 11
    //   896: aload_2
    //   897: aload 11
    //   899: aload 15
    //   901: getfield 225	com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo:file	Ljava/io/File;
    //   904: invokestatic 247	com/tencent/tinker/b/a:a	(Ljava/io/InputStream;Ljava/io/InputStream;Ljava/io/File;)I
    //   907: pop
    //   908: aload_2
    //   909: invokestatic 253	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   912: aload 11
    //   914: invokestatic 253	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   917: aload 15
    //   919: getfield 225	com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo:file	Ljava/io/File;
    //   922: aload 15
    //   924: getfield 228	com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo:md5	Ljava/lang/String;
    //   927: invokestatic 257	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:verifyFileMd5	(Ljava/io/File;Ljava/lang/String;)Z
    //   930: ifne +86 -> 1016
    //   933: ldc 39
    //   935: ldc_w 259
    //   938: iconst_1
    //   939: anewarray 43	java/lang/Object
    //   942: dup
    //   943: iconst_0
    //   944: aload 15
    //   946: getfield 225	com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo:file	Ljava/io/File;
    //   949: invokevirtual 185	java/io/File:getPath	()Ljava/lang/String;
    //   952: aastore
    //   953: invokestatic 49	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   956: aload 15
    //   958: getfield 225	com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo:file	Ljava/io/File;
    //   961: invokestatic 263	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:safeDeleteFile	(Ljava/io/File;)Z
    //   964: pop
    //   965: aload 12
    //   967: getfield 53	com/tencent/tinker/lib/e/a:MgW	Lcom/tencent/tinker/lib/d/d;
    //   970: aload 4
    //   972: aload 15
    //   974: getfield 225	com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo:file	Ljava/io/File;
    //   977: aload 14
    //   979: bipush 6
    //   981: invokeinterface 58 5 0
    //   986: aload 10
    //   988: invokestatic 64	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   991: aload_1
    //   992: invokestatic 64	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   995: iconst_0
    //   996: ireturn
    //   997: astore 4
    //   999: aconst_null
    //   1000: astore_3
    //   1001: aload_0
    //   1002: astore_2
    //   1003: aload 4
    //   1005: astore_0
    //   1006: aload_2
    //   1007: invokestatic 253	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   1010: aload_3
    //   1011: invokestatic 253	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   1014: aload_0
    //   1015: athrow
    //   1016: ldc 39
    //   1018: ldc_w 265
    //   1021: iconst_3
    //   1022: anewarray 43	java/lang/Object
    //   1025: dup
    //   1026: iconst_0
    //   1027: aload 15
    //   1029: getfield 225	com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo:file	Ljava/io/File;
    //   1032: invokevirtual 185	java/io/File:getPath	()Ljava/lang/String;
    //   1035: aastore
    //   1036: dup
    //   1037: iconst_1
    //   1038: aload 15
    //   1040: getfield 225	com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo:file	Ljava/io/File;
    //   1043: invokevirtual 155	java/io/File:length	()J
    //   1046: invokestatic 168	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1049: aastore
    //   1050: dup
    //   1051: iconst_2
    //   1052: invokestatic 14	java/lang/System:currentTimeMillis	()J
    //   1055: lload 8
    //   1057: lsub
    //   1058: invokestatic 168	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1061: aastore
    //   1062: invokestatic 49	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1065: goto -508 -> 557
    //   1068: ldc 39
    //   1070: ldc_w 267
    //   1073: iconst_1
    //   1074: anewarray 43	java/lang/Object
    //   1077: dup
    //   1078: iconst_0
    //   1079: invokestatic 14	java/lang/System:currentTimeMillis	()J
    //   1082: lload 6
    //   1084: lsub
    //   1085: invokestatic 168	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1088: aastore
    //   1089: invokestatic 49	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1092: aload 10
    //   1094: invokestatic 64	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   1097: aload_1
    //   1098: invokestatic 64	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   1101: iconst_1
    //   1102: ireturn
    //   1103: astore_0
    //   1104: aconst_null
    //   1105: astore_1
    //   1106: aconst_null
    //   1107: astore 10
    //   1109: goto -573 -> 536
    //   1112: astore_0
    //   1113: aconst_null
    //   1114: astore_1
    //   1115: goto -579 -> 536
    //   1118: astore_2
    //   1119: aload 11
    //   1121: astore_1
    //   1122: goto -638 -> 484
    //   1125: astore_2
    //   1126: aload 10
    //   1128: astore_0
    //   1129: aload 11
    //   1131: astore_1
    //   1132: goto -648 -> 484
    //   1135: astore_0
    //   1136: aload 11
    //   1138: astore_3
    //   1139: goto -133 -> 1006
    //   1142: astore_0
    //   1143: goto -607 -> 536
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1146	0	paramContext	android.content.Context
    //   0	1146	1	paramString	java.lang.String
    //   0	1146	2	paramFile1	java.io.File
    //   0	1146	3	paramFile2	java.io.File
    //   0	1146	4	paramFile3	java.io.File
    //   0	1146	5	paramShareResPatchInfo	com.tencent.tinker.loader.shareutil.ShareResPatchInfo
    //   3	1080	6	l1	long
    //   249	807	8	l2	long
    //   24	1103	10	localObject1	java.lang.Object
    //   14	1123	11	localObject2	java.lang.Object
    //   9	957	12	locala	com.tencent.tinker.lib.e.a
    //   272	296	13	localObject3	java.lang.Object
    //   577	401	14	str	java.lang.String
    //   597	442	15	localLargeModeInfo	com.tencent.tinker.loader.shareutil.ShareResPatchInfo.LargeModeInfo
    // Exception table:
    //   from	to	target	type
    //   213	227	480	java/lang/Throwable
    //   227	274	480	java/lang/Throwable
    //   279	314	480	java/lang/Throwable
    //   325	412	480	java/lang/Throwable
    //   423	477	480	java/lang/Throwable
    //   547	557	480	java/lang/Throwable
    //   557	599	480	java/lang/Throwable
    //   604	645	480	java/lang/Throwable
    //   656	739	480	java/lang/Throwable
    //   750	758	480	java/lang/Throwable
    //   763	803	480	java/lang/Throwable
    //   814	822	480	java/lang/Throwable
    //   826	866	480	java/lang/Throwable
    //   908	986	480	java/lang/Throwable
    //   1006	1016	480	java/lang/Throwable
    //   1016	1065	480	java/lang/Throwable
    //   1068	1092	480	java/lang/Throwable
    //   484	530	530	finally
    //   879	886	997	finally
    //   888	896	997	finally
    //   16	26	1103	finally
    //   26	45	1112	finally
    //   49	77	1112	finally
    //   88	148	1112	finally
    //   159	192	1112	finally
    //   203	213	1112	finally
    //   16	26	1118	java/lang/Throwable
    //   26	45	1125	java/lang/Throwable
    //   49	77	1125	java/lang/Throwable
    //   88	148	1125	java/lang/Throwable
    //   159	192	1125	java/lang/Throwable
    //   203	213	1125	java/lang/Throwable
    //   896	908	1135	finally
    //   213	227	1142	finally
    //   227	274	1142	finally
    //   279	314	1142	finally
    //   325	412	1142	finally
    //   423	477	1142	finally
    //   547	557	1142	finally
    //   557	599	1142	finally
    //   604	645	1142	finally
    //   656	739	1142	finally
    //   750	758	1142	finally
    //   763	803	1142	finally
    //   814	822	1142	finally
    //   826	866	1142	finally
    //   908	986	1142	finally
    //   1006	1016	1142	finally
    //   1016	1065	1142	finally
    //   1068	1092	1142	finally
  }
  
  /* Error */
  static boolean c(android.content.Context paramContext, java.lang.String paramString1, java.lang.String paramString2, java.io.File paramFile)
  {
    // Byte code:
    //   0: new 77	com/tencent/tinker/loader/shareutil/ShareResPatchInfo
    //   3: dup
    //   4: invokespecial 273	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:<init>	()V
    //   7: astore 7
    //   9: aload_2
    //   10: aload 7
    //   12: invokestatic 277	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:parseAllResPatchInfo	(Ljava/lang/String;Lcom/tencent/tinker/loader/shareutil/ShareResPatchInfo;)V
    //   15: ldc 39
    //   17: ldc_w 279
    //   20: iconst_2
    //   21: anewarray 43	java/lang/Object
    //   24: dup
    //   25: iconst_0
    //   26: aload_1
    //   27: aastore
    //   28: dup
    //   29: iconst_1
    //   30: aload 7
    //   32: invokevirtual 280	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:toString	()Ljava/lang/String;
    //   35: aastore
    //   36: invokestatic 112	com/tencent/tinker/loader/shareutil/ShareTinkerLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   39: aload_0
    //   40: invokestatic 20	com/tencent/tinker/lib/e/a:lk	(Landroid/content/Context;)Lcom/tencent/tinker/lib/e/a;
    //   43: astore_2
    //   44: aload 7
    //   46: getfield 283	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:resArscMd5	Ljava/lang/String;
    //   49: invokestatic 232	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:checkIfMd5Valid	(Ljava/lang/String;)Z
    //   52: ifne +48 -> 100
    //   55: ldc 39
    //   57: ldc_w 285
    //   60: iconst_2
    //   61: anewarray 43	java/lang/Object
    //   64: dup
    //   65: iconst_0
    //   66: bipush 6
    //   68: invokestatic 163	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:getTypeString	(I)Ljava/lang/String;
    //   71: aastore
    //   72: dup
    //   73: iconst_1
    //   74: aload 7
    //   76: getfield 283	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:resArscMd5	Ljava/lang/String;
    //   79: aastore
    //   80: invokestatic 49	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   83: aload_2
    //   84: getfield 53	com/tencent/tinker/lib/e/a:MgW	Lcom/tencent/tinker/lib/d/d;
    //   87: aload_3
    //   88: bipush 6
    //   90: invokestatic 172	com/tencent/tinker/lib/c/c:ail	(I)I
    //   93: invokeinterface 175 3 0
    //   98: iconst_0
    //   99: ireturn
    //   100: new 34	java/io/File
    //   103: dup
    //   104: aload_1
    //   105: invokespecial 286	java/io/File:<init>	(Ljava/lang/String;)V
    //   108: astore_1
    //   109: new 34	java/io/File
    //   112: dup
    //   113: aload_1
    //   114: ldc_w 288
    //   117: invokespecial 37	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   120: astore 8
    //   122: new 34	java/io/File
    //   125: dup
    //   126: aload_1
    //   127: ldc_w 290
    //   130: invokespecial 37	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   133: astore 9
    //   135: aload 9
    //   137: invokevirtual 293	java/io/File:exists	()Z
    //   140: ifeq +99 -> 239
    //   143: aload 9
    //   145: aload 7
    //   147: getfield 283	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:resArscMd5	Ljava/lang/String;
    //   150: invokestatic 296	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:checkResourceArscMd5	(Ljava/io/File;Ljava/lang/String;)Z
    //   153: ifeq +25 -> 178
    //   156: ldc 39
    //   158: ldc_w 298
    //   161: iconst_1
    //   162: anewarray 43	java/lang/Object
    //   165: dup
    //   166: iconst_0
    //   167: aload 9
    //   169: invokevirtual 185	java/io/File:getPath	()Ljava/lang/String;
    //   172: aastore
    //   173: invokestatic 49	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   176: iconst_1
    //   177: ireturn
    //   178: ldc 39
    //   180: new 189	java/lang/StringBuilder
    //   183: dup
    //   184: ldc_w 300
    //   187: invokespecial 192	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   190: aload 9
    //   192: invokevirtual 185	java/io/File:getPath	()Ljava/lang/String;
    //   195: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: iconst_0
    //   202: anewarray 43	java/lang/Object
    //   205: invokestatic 49	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   208: aload 9
    //   210: invokevirtual 303	java/io/File:delete	()Z
    //   213: pop
    //   214: aload_0
    //   215: invokevirtual 309	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   218: astore 6
    //   220: aload 6
    //   222: ifnonnull +29 -> 251
    //   225: ldc 39
    //   227: ldc_w 311
    //   230: iconst_0
    //   231: anewarray 43	java/lang/Object
    //   234: invokestatic 49	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   237: iconst_0
    //   238: ireturn
    //   239: aload 9
    //   241: invokevirtual 315	java/io/File:getParentFile	()Ljava/io/File;
    //   244: invokevirtual 318	java/io/File:mkdirs	()Z
    //   247: pop
    //   248: goto -34 -> 214
    //   251: aload 6
    //   253: getfield 323	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   256: astore 10
    //   258: aload_0
    //   259: aload 10
    //   261: aload_1
    //   262: aload 8
    //   264: aload_3
    //   265: aload 7
    //   267: invokestatic 325	com/tencent/tinker/lib/c/f:a	(Landroid/content/Context;Ljava/lang/String;Ljava/io/File;Ljava/io/File;Ljava/io/File;Lcom/tencent/tinker/loader/shareutil/ShareResPatchInfo;)Z
    //   270: istore 5
    //   272: iload 5
    //   274: ifne +5 -> 279
    //   277: iconst_0
    //   278: ireturn
    //   279: new 327	com/tencent/tinker/d/a/i
    //   282: dup
    //   283: new 329	java/io/BufferedOutputStream
    //   286: dup
    //   287: new 331	java/io/FileOutputStream
    //   290: dup
    //   291: aload 9
    //   293: invokespecial 332	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   296: invokespecial 335	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   299: invokespecial 336	com/tencent/tinker/d/a/i:<init>	(Ljava/io/OutputStream;)V
    //   302: astore 6
    //   304: new 338	com/tencent/tinker/d/a/h
    //   307: dup
    //   308: aload 10
    //   310: invokespecial 339	com/tencent/tinker/d/a/h:<init>	(Ljava/lang/String;)V
    //   313: astore_0
    //   314: new 338	com/tencent/tinker/d/a/h
    //   317: dup
    //   318: aload_3
    //   319: invokespecial 340	com/tencent/tinker/d/a/h:<init>	(Ljava/io/File;)V
    //   322: astore_1
    //   323: aload_0
    //   324: invokevirtual 344	com/tencent/tinker/d/a/h:entries	()Ljava/util/Enumeration;
    //   327: astore 10
    //   329: iconst_0
    //   330: istore 4
    //   332: aload 10
    //   334: invokeinterface 349 1 0
    //   339: ifeq +206 -> 545
    //   342: aload 10
    //   344: invokeinterface 352 1 0
    //   349: checkcast 354	com/tencent/tinker/d/a/g
    //   352: astore 11
    //   354: aload 11
    //   356: ifnonnull +91 -> 447
    //   359: new 187	com/tencent/tinker/loader/TinkerRuntimeException
    //   362: dup
    //   363: ldc_w 356
    //   366: invokespecial 357	com/tencent/tinker/loader/TinkerRuntimeException:<init>	(Ljava/lang/String;)V
    //   369: athrow
    //   370: astore 7
    //   372: aload 6
    //   374: astore_3
    //   375: aload_0
    //   376: astore_2
    //   377: aload 7
    //   379: astore_0
    //   380: aload_3
    //   381: invokestatic 253	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   384: aload_2
    //   385: invokestatic 253	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   388: aload_1
    //   389: invokestatic 253	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   392: aload 8
    //   394: invokestatic 360	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:deleteDir	(Ljava/io/File;)Z
    //   397: pop
    //   398: aload_0
    //   399: athrow
    //   400: astore_0
    //   401: new 187	com/tencent/tinker/loader/TinkerRuntimeException
    //   404: dup
    //   405: new 189	java/lang/StringBuilder
    //   408: dup
    //   409: ldc 191
    //   411: invokespecial 192	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   414: bipush 6
    //   416: invokestatic 163	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:getTypeString	(I)Ljava/lang/String;
    //   419: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: ldc 198
    //   424: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: aload_0
    //   428: invokevirtual 201	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   431: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: ldc 203
    //   436: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: aload_0
    //   443: invokespecial 209	com/tencent/tinker/loader/TinkerRuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   446: athrow
    //   447: aload 11
    //   449: getfield 363	com/tencent/tinker/d/a/g:name	Ljava/lang/String;
    //   452: astore 12
    //   454: aload 12
    //   456: ldc_w 365
    //   459: invokevirtual 369	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   462: ifne -130 -> 332
    //   465: aload 7
    //   467: getfield 373	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:patterns	Ljava/util/HashSet;
    //   470: aload 12
    //   472: invokestatic 377	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:checkFileInPattern	(Ljava/util/HashSet;Ljava/lang/String;)Z
    //   475: ifeq +821 -> 1296
    //   478: aload 7
    //   480: getfield 380	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:deleteRes	Ljava/util/ArrayList;
    //   483: aload 12
    //   485: invokevirtual 382	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   488: ifne +808 -> 1296
    //   491: aload 7
    //   493: getfield 385	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:modRes	Ljava/util/ArrayList;
    //   496: aload 12
    //   498: invokevirtual 382	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   501: ifne +795 -> 1296
    //   504: aload 7
    //   506: getfield 94	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:largeModRes	Ljava/util/ArrayList;
    //   509: aload 12
    //   511: invokevirtual 382	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   514: ifne +782 -> 1296
    //   517: aload 12
    //   519: ldc_w 387
    //   522: invokevirtual 85	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   525: ifne +771 -> 1296
    //   528: aload_0
    //   529: aload 11
    //   531: aload 6
    //   533: invokestatic 392	com/tencent/tinker/d/a/j:a	(Lcom/tencent/tinker/d/a/h;Lcom/tencent/tinker/d/a/g;Lcom/tencent/tinker/d/a/i;)V
    //   536: iload 4
    //   538: iconst_1
    //   539: iadd
    //   540: istore 4
    //   542: goto +754 -> 1296
    //   545: aload_0
    //   546: ldc_w 387
    //   549: invokevirtual 396	com/tencent/tinker/d/a/h:aZT	(Ljava/lang/String;)Lcom/tencent/tinker/d/a/g;
    //   552: astore 10
    //   554: aload 10
    //   556: ifnonnull +53 -> 609
    //   559: ldc 39
    //   561: ldc_w 398
    //   564: iconst_0
    //   565: anewarray 43	java/lang/Object
    //   568: invokestatic 49	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   571: aload_2
    //   572: getfield 53	com/tencent/tinker/lib/e/a:MgW	Lcom/tencent/tinker/lib/d/d;
    //   575: aload_3
    //   576: aload 9
    //   578: ldc_w 387
    //   581: bipush 6
    //   583: invokeinterface 58 5 0
    //   588: aload 6
    //   590: invokestatic 253	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   593: aload_0
    //   594: invokestatic 253	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   597: aload_1
    //   598: invokestatic 253	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   601: aload 8
    //   603: invokestatic 360	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:deleteDir	(Ljava/io/File;)Z
    //   606: pop
    //   607: iconst_0
    //   608: ireturn
    //   609: aload_0
    //   610: aload 10
    //   612: aload 6
    //   614: invokestatic 392	com/tencent/tinker/d/a/j:a	(Lcom/tencent/tinker/d/a/h;Lcom/tencent/tinker/d/a/g;Lcom/tencent/tinker/d/a/i;)V
    //   617: iload 4
    //   619: iconst_1
    //   620: iadd
    //   621: istore 4
    //   623: aload 7
    //   625: getfield 94	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:largeModRes	Ljava/util/ArrayList;
    //   628: invokevirtual 210	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   631: astore 10
    //   633: aload 10
    //   635: invokeinterface 130 1 0
    //   640: ifeq +126 -> 766
    //   643: aload 10
    //   645: invokeinterface 134 1 0
    //   650: checkcast 71	java/lang/String
    //   653: astore 12
    //   655: aload_0
    //   656: aload 12
    //   658: invokevirtual 396	com/tencent/tinker/d/a/h:aZT	(Ljava/lang/String;)Lcom/tencent/tinker/d/a/g;
    //   661: astore 11
    //   663: aload 11
    //   665: ifnonnull +60 -> 725
    //   668: ldc 39
    //   670: ldc_w 400
    //   673: aload 12
    //   675: invokestatic 142	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   678: invokevirtual 146	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   681: iconst_0
    //   682: anewarray 43	java/lang/Object
    //   685: invokestatic 49	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   688: aload_2
    //   689: getfield 53	com/tencent/tinker/lib/e/a:MgW	Lcom/tencent/tinker/lib/d/d;
    //   692: aload_3
    //   693: aload 9
    //   695: aload 12
    //   697: bipush 6
    //   699: invokeinterface 58 5 0
    //   704: aload 6
    //   706: invokestatic 253	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   709: aload_0
    //   710: invokestatic 253	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   713: aload_1
    //   714: invokestatic 253	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   717: aload 8
    //   719: invokestatic 360	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:deleteDir	(Ljava/io/File;)Z
    //   722: pop
    //   723: iconst_0
    //   724: ireturn
    //   725: aload 7
    //   727: getfield 213	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:largeModMap	Ljava/util/HashMap;
    //   730: aload 12
    //   732: invokevirtual 217	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   735: checkcast 219	com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo
    //   738: astore 12
    //   740: aload 11
    //   742: aload 12
    //   744: getfield 225	com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo:file	Ljava/io/File;
    //   747: aload 12
    //   749: getfield 404	com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo:crc	J
    //   752: aload 6
    //   754: invokestatic 407	com/tencent/tinker/d/a/j:a	(Lcom/tencent/tinker/d/a/g;Ljava/io/File;JLcom/tencent/tinker/d/a/i;)V
    //   757: iload 4
    //   759: iconst_1
    //   760: iadd
    //   761: istore 4
    //   763: goto -130 -> 633
    //   766: aload 7
    //   768: getfield 410	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:addRes	Ljava/util/ArrayList;
    //   771: invokevirtual 210	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   774: astore 10
    //   776: aload 10
    //   778: invokeinterface 130 1 0
    //   783: ifeq +137 -> 920
    //   786: aload 10
    //   788: invokeinterface 134 1 0
    //   793: checkcast 71	java/lang/String
    //   796: astore 11
    //   798: aload_1
    //   799: aload 11
    //   801: invokevirtual 396	com/tencent/tinker/d/a/h:aZT	(Ljava/lang/String;)Lcom/tencent/tinker/d/a/g;
    //   804: astore 12
    //   806: aload 12
    //   808: ifnonnull +60 -> 868
    //   811: ldc 39
    //   813: ldc_w 412
    //   816: aload 11
    //   818: invokestatic 142	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   821: invokevirtual 146	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   824: iconst_0
    //   825: anewarray 43	java/lang/Object
    //   828: invokestatic 49	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   831: aload_2
    //   832: getfield 53	com/tencent/tinker/lib/e/a:MgW	Lcom/tencent/tinker/lib/d/d;
    //   835: aload_3
    //   836: aload 9
    //   838: aload 11
    //   840: bipush 6
    //   842: invokeinterface 58 5 0
    //   847: aload 6
    //   849: invokestatic 253	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   852: aload_0
    //   853: invokestatic 253	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   856: aload_1
    //   857: invokestatic 253	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   860: aload 8
    //   862: invokestatic 360	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:deleteDir	(Ljava/io/File;)Z
    //   865: pop
    //   866: iconst_0
    //   867: ireturn
    //   868: aload 7
    //   870: getfield 104	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:storeRes	Ljava/util/HashMap;
    //   873: aload 11
    //   875: invokevirtual 415	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   878: ifeq +31 -> 909
    //   881: aload 12
    //   883: aload 7
    //   885: getfield 104	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:storeRes	Ljava/util/HashMap;
    //   888: aload 11
    //   890: invokevirtual 217	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   893: checkcast 34	java/io/File
    //   896: aload 12
    //   898: getfield 416	com/tencent/tinker/d/a/g:crc	J
    //   901: aload 6
    //   903: invokestatic 407	com/tencent/tinker/d/a/j:a	(Lcom/tencent/tinker/d/a/g;Ljava/io/File;JLcom/tencent/tinker/d/a/i;)V
    //   906: goto +393 -> 1299
    //   909: aload_1
    //   910: aload 12
    //   912: aload 6
    //   914: invokestatic 392	com/tencent/tinker/d/a/j:a	(Lcom/tencent/tinker/d/a/h;Lcom/tencent/tinker/d/a/g;Lcom/tencent/tinker/d/a/i;)V
    //   917: goto +382 -> 1299
    //   920: aload 7
    //   922: getfield 385	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:modRes	Ljava/util/ArrayList;
    //   925: invokevirtual 210	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   928: astore 10
    //   930: aload 10
    //   932: invokeinterface 130 1 0
    //   937: ifeq +137 -> 1074
    //   940: aload 10
    //   942: invokeinterface 134 1 0
    //   947: checkcast 71	java/lang/String
    //   950: astore 11
    //   952: aload_1
    //   953: aload 11
    //   955: invokevirtual 396	com/tencent/tinker/d/a/h:aZT	(Ljava/lang/String;)Lcom/tencent/tinker/d/a/g;
    //   958: astore 12
    //   960: aload 12
    //   962: ifnonnull +60 -> 1022
    //   965: ldc 39
    //   967: ldc_w 418
    //   970: aload 11
    //   972: invokestatic 142	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   975: invokevirtual 146	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   978: iconst_0
    //   979: anewarray 43	java/lang/Object
    //   982: invokestatic 49	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   985: aload_2
    //   986: getfield 53	com/tencent/tinker/lib/e/a:MgW	Lcom/tencent/tinker/lib/d/d;
    //   989: aload_3
    //   990: aload 9
    //   992: aload 11
    //   994: bipush 6
    //   996: invokeinterface 58 5 0
    //   1001: aload 6
    //   1003: invokestatic 253	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   1006: aload_0
    //   1007: invokestatic 253	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   1010: aload_1
    //   1011: invokestatic 253	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   1014: aload 8
    //   1016: invokestatic 360	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:deleteDir	(Ljava/io/File;)Z
    //   1019: pop
    //   1020: iconst_0
    //   1021: ireturn
    //   1022: aload 7
    //   1024: getfield 104	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:storeRes	Ljava/util/HashMap;
    //   1027: aload 11
    //   1029: invokevirtual 415	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   1032: ifeq +31 -> 1063
    //   1035: aload 12
    //   1037: aload 7
    //   1039: getfield 104	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:storeRes	Ljava/util/HashMap;
    //   1042: aload 11
    //   1044: invokevirtual 217	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1047: checkcast 34	java/io/File
    //   1050: aload 12
    //   1052: getfield 416	com/tencent/tinker/d/a/g:crc	J
    //   1055: aload 6
    //   1057: invokestatic 407	com/tencent/tinker/d/a/j:a	(Lcom/tencent/tinker/d/a/g;Ljava/io/File;JLcom/tencent/tinker/d/a/i;)V
    //   1060: goto +248 -> 1308
    //   1063: aload_1
    //   1064: aload 12
    //   1066: aload 6
    //   1068: invokestatic 392	com/tencent/tinker/d/a/j:a	(Lcom/tencent/tinker/d/a/h;Lcom/tencent/tinker/d/a/g;Lcom/tencent/tinker/d/a/i;)V
    //   1071: goto +237 -> 1308
    //   1074: aload_0
    //   1075: invokevirtual 421	com/tencent/tinker/d/a/h:nU	()V
    //   1078: aload_0
    //   1079: getfield 424	com/tencent/tinker/d/a/h:FxH	Ljava/lang/String;
    //   1082: astore 10
    //   1084: aload 10
    //   1086: ifnonnull +107 -> 1193
    //   1089: aload 6
    //   1091: getstatic 428	com/tencent/tinker/d/a/i:MhZ	[B
    //   1094: putfield 431	com/tencent/tinker/d/a/i:MhD	[B
    //   1097: aload 6
    //   1099: invokestatic 253	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   1102: aload_0
    //   1103: invokestatic 253	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   1106: aload_1
    //   1107: invokestatic 253	com/tencent/tinker/c/b/b:closeQuietly	(Ljava/lang/Object;)V
    //   1110: aload 8
    //   1112: invokestatic 360	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:deleteDir	(Ljava/io/File;)Z
    //   1115: pop
    //   1116: aload 9
    //   1118: aload 7
    //   1120: getfield 283	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:resArscMd5	Ljava/lang/String;
    //   1123: invokestatic 296	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:checkResourceArscMd5	(Ljava/io/File;Ljava/lang/String;)Z
    //   1126: ifne +95 -> 1221
    //   1129: ldc 39
    //   1131: ldc_w 433
    //   1134: iconst_3
    //   1135: anewarray 43	java/lang/Object
    //   1138: dup
    //   1139: iconst_0
    //   1140: aload 9
    //   1142: invokevirtual 436	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1145: aastore
    //   1146: dup
    //   1147: iconst_1
    //   1148: iload 4
    //   1150: invokestatic 441	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1153: aastore
    //   1154: dup
    //   1155: iconst_2
    //   1156: aload 9
    //   1158: invokevirtual 155	java/io/File:length	()J
    //   1161: invokestatic 168	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1164: aastore
    //   1165: invokestatic 112	com/tencent/tinker/loader/shareutil/ShareTinkerLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1168: aload 9
    //   1170: invokestatic 263	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:safeDeleteFile	(Ljava/io/File;)Z
    //   1173: pop
    //   1174: aload_2
    //   1175: getfield 53	com/tencent/tinker/lib/e/a:MgW	Lcom/tencent/tinker/lib/d/d;
    //   1178: aload_3
    //   1179: aload 9
    //   1181: ldc_w 290
    //   1184: bipush 6
    //   1186: invokeinterface 58 5 0
    //   1191: iconst_0
    //   1192: ireturn
    //   1193: aload 10
    //   1195: getstatic 447	com/tencent/tinker/d/a/e:UTF_8	Ljava/nio/charset/Charset;
    //   1198: invokevirtual 451	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
    //   1201: astore 10
    //   1203: ldc_w 453
    //   1206: aload 10
    //   1208: invokestatic 457	com/tencent/tinker/d/a/i:D	(Ljava/lang/String;[B)V
    //   1211: aload 6
    //   1213: aload 10
    //   1215: putfield 431	com/tencent/tinker/d/a/i:MhD	[B
    //   1218: goto -121 -> 1097
    //   1221: ldc 39
    //   1223: ldc_w 459
    //   1226: iconst_3
    //   1227: anewarray 43	java/lang/Object
    //   1230: dup
    //   1231: iconst_0
    //   1232: aload 9
    //   1234: invokevirtual 436	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1237: aastore
    //   1238: dup
    //   1239: iconst_1
    //   1240: iload 4
    //   1242: invokestatic 441	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1245: aastore
    //   1246: dup
    //   1247: iconst_2
    //   1248: aload 9
    //   1250: invokevirtual 155	java/io/File:length	()J
    //   1253: invokestatic 168	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1256: aastore
    //   1257: invokestatic 112	com/tencent/tinker/loader/shareutil/ShareTinkerLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1260: iconst_1
    //   1261: ireturn
    //   1262: astore_0
    //   1263: aconst_null
    //   1264: astore_1
    //   1265: aconst_null
    //   1266: astore_2
    //   1267: aconst_null
    //   1268: astore_3
    //   1269: goto -889 -> 380
    //   1272: astore_0
    //   1273: aconst_null
    //   1274: astore_1
    //   1275: aconst_null
    //   1276: astore_2
    //   1277: aload 6
    //   1279: astore_3
    //   1280: goto -900 -> 380
    //   1283: astore_3
    //   1284: aconst_null
    //   1285: astore_1
    //   1286: aload_0
    //   1287: astore_2
    //   1288: aload_3
    //   1289: astore_0
    //   1290: aload 6
    //   1292: astore_3
    //   1293: goto -913 -> 380
    //   1296: goto -964 -> 332
    //   1299: iload 4
    //   1301: iconst_1
    //   1302: iadd
    //   1303: istore 4
    //   1305: goto -529 -> 776
    //   1308: iload 4
    //   1310: iconst_1
    //   1311: iadd
    //   1312: istore 4
    //   1314: goto -384 -> 930
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1317	0	paramContext	android.content.Context
    //   0	1317	1	paramString1	java.lang.String
    //   0	1317	2	paramString2	java.lang.String
    //   0	1317	3	paramFile	java.io.File
    //   330	983	4	i	int
    //   270	3	5	bool	boolean
    //   218	1073	6	localObject1	java.lang.Object
    //   7	259	7	localShareResPatchInfo	com.tencent.tinker.loader.shareutil.ShareResPatchInfo
    //   370	749	7	localObject2	java.lang.Object
    //   120	991	8	localFile1	java.io.File
    //   133	1116	9	localFile2	java.io.File
    //   256	958	10	localObject3	java.lang.Object
    //   352	691	11	localObject4	java.lang.Object
    //   452	613	12	localObject5	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   323	329	370	finally
    //   332	354	370	finally
    //   359	370	370	finally
    //   447	536	370	finally
    //   545	554	370	finally
    //   559	588	370	finally
    //   609	617	370	finally
    //   623	633	370	finally
    //   633	663	370	finally
    //   668	704	370	finally
    //   725	757	370	finally
    //   766	776	370	finally
    //   776	806	370	finally
    //   811	847	370	finally
    //   868	906	370	finally
    //   909	917	370	finally
    //   920	930	370	finally
    //   930	960	370	finally
    //   965	1001	370	finally
    //   1022	1060	370	finally
    //   1063	1071	370	finally
    //   1074	1084	370	finally
    //   1089	1097	370	finally
    //   1193	1218	370	finally
    //   214	220	400	java/lang/Throwable
    //   225	237	400	java/lang/Throwable
    //   251	272	400	java/lang/Throwable
    //   380	400	400	java/lang/Throwable
    //   588	607	400	java/lang/Throwable
    //   704	723	400	java/lang/Throwable
    //   847	866	400	java/lang/Throwable
    //   1001	1020	400	java/lang/Throwable
    //   1097	1191	400	java/lang/Throwable
    //   1221	1260	400	java/lang/Throwable
    //   279	304	1262	finally
    //   304	314	1272	finally
    //   314	323	1283	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.lib.c.f
 * JD-Core Version:    0.7.0.1
 */