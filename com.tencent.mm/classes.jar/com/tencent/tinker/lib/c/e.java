package com.tencent.tinker.lib.c;

public final class e
  extends b
{
  /* Error */
  private static boolean a(android.content.Context paramContext, java.lang.String paramString, java.io.File paramFile1, java.io.File paramFile2, java.io.File paramFile3, com.tencent.tinker.loader.shareutil.ShareResPatchInfo paramShareResPatchInfo)
  {
    // Byte code:
    //   0: invokestatic 14	java/lang/System:currentTimeMillis	()J
    //   3: lstore 6
    //   5: aload_0
    //   6: invokestatic 20	com/tencent/tinker/lib/e/a:hN	(Landroid/content/Context;)Lcom/tencent/tinker/lib/e/a;
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
    //   57: invokestatic 49	com/tencent/tinker/lib/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   60: aload 12
    //   62: getfield 53	com/tencent/tinker/lib/e/a:wWm	Lcom/tencent/tinker/lib/d/d;
    //   65: aload 4
    //   67: aload_1
    //   68: ldc 28
    //   70: bipush 6
    //   72: invokeinterface 58 5 0
    //   77: aload 10
    //   79: invokestatic 63	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   82: aconst_null
    //   83: invokestatic 63	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   86: iconst_0
    //   87: ireturn
    //   88: aload_0
    //   89: invokevirtual 68	java/util/zip/ZipEntry:getCrc	()J
    //   92: invokestatic 74	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   95: astore_0
    //   96: aload_0
    //   97: aload 5
    //   99: getfield 80	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:wZu	Ljava/lang/String;
    //   102: invokevirtual 84	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   105: ifne +54 -> 159
    //   108: ldc 39
    //   110: ldc 86
    //   112: iconst_2
    //   113: anewarray 43	java/lang/Object
    //   116: dup
    //   117: iconst_0
    //   118: aload 5
    //   120: getfield 80	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:wZu	Ljava/lang/String;
    //   123: aastore
    //   124: dup
    //   125: iconst_1
    //   126: aload_0
    //   127: aastore
    //   128: invokestatic 89	com/tencent/tinker/lib/f/a:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   131: aload 12
    //   133: getfield 53	com/tencent/tinker/lib/e/a:wWm	Lcom/tencent/tinker/lib/d/d;
    //   136: aload 4
    //   138: aload_1
    //   139: ldc 28
    //   141: bipush 6
    //   143: invokeinterface 58 5 0
    //   148: aload 10
    //   150: invokestatic 63	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   153: aconst_null
    //   154: invokestatic 63	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   157: iconst_0
    //   158: ireturn
    //   159: aload 5
    //   161: getfield 93	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:wZA	Ljava/util/ArrayList;
    //   164: invokevirtual 99	java/util/ArrayList:isEmpty	()Z
    //   167: ifeq +36 -> 203
    //   170: aload 5
    //   172: getfield 103	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:wZz	Ljava/util/HashMap;
    //   175: invokevirtual 106	java/util/HashMap:isEmpty	()Z
    //   178: ifeq +25 -> 203
    //   181: ldc 39
    //   183: ldc 108
    //   185: iconst_0
    //   186: anewarray 43	java/lang/Object
    //   189: invokestatic 111	com/tencent/tinker/lib/f/a:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   192: aload 10
    //   194: invokestatic 63	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   197: aconst_null
    //   198: invokestatic 63	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   201: iconst_1
    //   202: ireturn
    //   203: new 22	java/util/zip/ZipFile
    //   206: dup
    //   207: aload 4
    //   209: invokespecial 114	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   212: astore_1
    //   213: aload 5
    //   215: getfield 103	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:wZz	Ljava/util/HashMap;
    //   218: invokevirtual 118	java/util/HashMap:keySet	()Ljava/util/Set;
    //   221: invokeinterface 124 1 0
    //   226: astore_0
    //   227: aload_0
    //   228: invokeinterface 129 1 0
    //   233: ifeq +321 -> 554
    //   236: aload_0
    //   237: invokeinterface 133 1 0
    //   242: checkcast 70	java/lang/String
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
    //   264: invokestatic 136	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:aj	(Ljava/io/File;)V
    //   267: aload_1
    //   268: aload_2
    //   269: invokevirtual 32	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   272: astore 13
    //   274: aload 13
    //   276: ifnonnull +56 -> 332
    //   279: ldc 39
    //   281: new 138	java/lang/StringBuilder
    //   284: dup
    //   285: ldc 140
    //   287: invokespecial 141	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   290: aload_2
    //   291: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   297: iconst_0
    //   298: anewarray 43	java/lang/Object
    //   301: invokestatic 49	com/tencent/tinker/lib/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   304: aload 12
    //   306: getfield 53	com/tencent/tinker/lib/e/a:wWm	Lcom/tencent/tinker/lib/d/d;
    //   309: aload 4
    //   311: aload 11
    //   313: aload_2
    //   314: bipush 6
    //   316: invokeinterface 58 5 0
    //   321: aload 10
    //   323: invokestatic 63	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   326: aload_1
    //   327: invokestatic 63	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   330: iconst_0
    //   331: ireturn
    //   332: aload_1
    //   333: aload 13
    //   335: aload 11
    //   337: aconst_null
    //   338: iconst_0
    //   339: invokestatic 152	com/tencent/tinker/lib/c/e:a	(Ljava/util/zip/ZipFile;Ljava/util/zip/ZipEntry;Ljava/io/File;Ljava/lang/String;Z)Z
    //   342: pop
    //   343: aload 13
    //   345: invokevirtual 155	java/util/zip/ZipEntry:getSize	()J
    //   348: aload 11
    //   350: invokevirtual 158	java/io/File:length	()J
    //   353: lcmp
    //   354: ifeq +76 -> 430
    //   357: ldc 39
    //   359: ldc 160
    //   361: iconst_4
    //   362: anewarray 43	java/lang/Object
    //   365: dup
    //   366: iconst_0
    //   367: bipush 6
    //   369: invokestatic 166	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:Kn	(I)Ljava/lang/String;
    //   372: aastore
    //   373: dup
    //   374: iconst_1
    //   375: aload_2
    //   376: aastore
    //   377: dup
    //   378: iconst_2
    //   379: aload 13
    //   381: invokevirtual 155	java/util/zip/ZipEntry:getSize	()J
    //   384: invokestatic 171	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   387: aastore
    //   388: dup
    //   389: iconst_3
    //   390: aload 11
    //   392: invokevirtual 158	java/io/File:length	()J
    //   395: invokestatic 171	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   398: aastore
    //   399: invokestatic 49	com/tencent/tinker/lib/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   402: aload 12
    //   404: getfield 53	com/tencent/tinker/lib/e/a:wWm	Lcom/tencent/tinker/lib/d/d;
    //   407: aload 4
    //   409: bipush 6
    //   411: invokestatic 175	com/tencent/tinker/lib/c/b:Kj	(I)I
    //   414: invokeinterface 179 3 0
    //   419: aload 10
    //   421: invokestatic 63	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   424: aload_1
    //   425: invokestatic 63	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   428: iconst_0
    //   429: ireturn
    //   430: aload 5
    //   432: getfield 103	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:wZz	Ljava/util/HashMap;
    //   435: aload_2
    //   436: aload 11
    //   438: invokevirtual 183	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   441: pop
    //   442: ldc 39
    //   444: ldc 185
    //   446: iconst_3
    //   447: anewarray 43	java/lang/Object
    //   450: dup
    //   451: iconst_0
    //   452: aload 11
    //   454: invokevirtual 188	java/io/File:getPath	()Ljava/lang/String;
    //   457: aastore
    //   458: dup
    //   459: iconst_1
    //   460: aload 11
    //   462: invokevirtual 158	java/io/File:length	()J
    //   465: invokestatic 171	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   468: aastore
    //   469: dup
    //   470: iconst_2
    //   471: invokestatic 14	java/lang/System:currentTimeMillis	()J
    //   474: lload 8
    //   476: lsub
    //   477: invokestatic 171	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   480: aastore
    //   481: invokestatic 49	com/tencent/tinker/lib/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   484: goto -257 -> 227
    //   487: astore_2
    //   488: aload 10
    //   490: astore_0
    //   491: new 190	com/tencent/tinker/loader/TinkerRuntimeException
    //   494: dup
    //   495: new 138	java/lang/StringBuilder
    //   498: dup
    //   499: ldc 192
    //   501: invokespecial 141	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   504: bipush 6
    //   506: invokestatic 166	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:Kn	(I)Ljava/lang/String;
    //   509: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: ldc 194
    //   514: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: aload_2
    //   518: invokevirtual 197	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   521: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: ldc 199
    //   526: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   532: aload_2
    //   533: invokespecial 202	com/tencent/tinker/loader/TinkerRuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   536: athrow
    //   537: astore_2
    //   538: aload_0
    //   539: astore 10
    //   541: aload_2
    //   542: astore_0
    //   543: aload 10
    //   545: invokestatic 63	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   548: aload_1
    //   549: invokestatic 63	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   552: aload_0
    //   553: athrow
    //   554: aload 5
    //   556: getfield 93	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:wZA	Ljava/util/ArrayList;
    //   559: invokevirtual 203	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   562: astore 13
    //   564: aload 13
    //   566: invokeinterface 129 1 0
    //   571: ifeq +517 -> 1088
    //   574: aload 13
    //   576: invokeinterface 133 1 0
    //   581: checkcast 70	java/lang/String
    //   584: astore 14
    //   586: invokestatic 14	java/lang/System:currentTimeMillis	()J
    //   589: lstore 8
    //   591: aload 5
    //   593: getfield 206	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:wZB	Ljava/util/HashMap;
    //   596: aload 14
    //   598: invokevirtual 210	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   601: checkcast 212	com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo
    //   604: astore 15
    //   606: aload 15
    //   608: ifnonnull +55 -> 663
    //   611: ldc 39
    //   613: ldc 214
    //   615: iconst_2
    //   616: anewarray 43	java/lang/Object
    //   619: dup
    //   620: iconst_0
    //   621: bipush 6
    //   623: invokestatic 166	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:Kn	(I)Ljava/lang/String;
    //   626: aastore
    //   627: dup
    //   628: iconst_1
    //   629: aload 14
    //   631: aastore
    //   632: invokestatic 49	com/tencent/tinker/lib/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   635: aload 12
    //   637: getfield 53	com/tencent/tinker/lib/e/a:wWm	Lcom/tencent/tinker/lib/d/d;
    //   640: aload 4
    //   642: bipush 6
    //   644: invokestatic 175	com/tencent/tinker/lib/c/b:Kj	(I)I
    //   647: invokeinterface 179 3 0
    //   652: aload 10
    //   654: invokestatic 63	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   657: aload_1
    //   658: invokestatic 63	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   661: iconst_0
    //   662: ireturn
    //   663: aload 15
    //   665: new 34	java/io/File
    //   668: dup
    //   669: aload_3
    //   670: aload 14
    //   672: invokespecial 37	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   675: putfield 218	com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo:file	Ljava/io/File;
    //   678: aload 15
    //   680: getfield 218	com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo:file	Ljava/io/File;
    //   683: invokestatic 136	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:aj	(Ljava/io/File;)V
    //   686: aload 15
    //   688: getfield 221	com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo:bIW	Ljava/lang/String;
    //   691: invokestatic 225	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:agm	(Ljava/lang/String;)Z
    //   694: ifne +63 -> 757
    //   697: ldc 39
    //   699: ldc 227
    //   701: iconst_3
    //   702: anewarray 43	java/lang/Object
    //   705: dup
    //   706: iconst_0
    //   707: bipush 6
    //   709: invokestatic 166	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:Kn	(I)Ljava/lang/String;
    //   712: aastore
    //   713: dup
    //   714: iconst_1
    //   715: aload 14
    //   717: aastore
    //   718: dup
    //   719: iconst_2
    //   720: aload 15
    //   722: getfield 221	com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo:bIW	Ljava/lang/String;
    //   725: aastore
    //   726: invokestatic 49	com/tencent/tinker/lib/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   729: aload 12
    //   731: getfield 53	com/tencent/tinker/lib/e/a:wWm	Lcom/tencent/tinker/lib/d/d;
    //   734: aload 4
    //   736: bipush 6
    //   738: invokestatic 175	com/tencent/tinker/lib/c/b:Kj	(I)I
    //   741: invokeinterface 179 3 0
    //   746: aload 10
    //   748: invokestatic 63	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   751: aload_1
    //   752: invokestatic 63	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   755: iconst_0
    //   756: ireturn
    //   757: aload_1
    //   758: aload 14
    //   760: invokevirtual 32	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   763: astore 11
    //   765: aload 11
    //   767: ifnonnull +61 -> 828
    //   770: ldc 39
    //   772: new 138	java/lang/StringBuilder
    //   775: dup
    //   776: ldc 229
    //   778: invokespecial 141	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   781: aload 14
    //   783: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   786: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   789: iconst_0
    //   790: anewarray 43	java/lang/Object
    //   793: invokestatic 49	com/tencent/tinker/lib/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   796: aload 12
    //   798: getfield 53	com/tencent/tinker/lib/e/a:wWm	Lcom/tencent/tinker/lib/d/d;
    //   801: aload 4
    //   803: aload 15
    //   805: getfield 218	com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo:file	Ljava/io/File;
    //   808: aload 14
    //   810: bipush 6
    //   812: invokeinterface 58 5 0
    //   817: aload 10
    //   819: invokestatic 63	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   822: aload_1
    //   823: invokestatic 63	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   826: iconst_0
    //   827: ireturn
    //   828: aload 10
    //   830: aload 14
    //   832: invokevirtual 32	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   835: astore_2
    //   836: aload_2
    //   837: ifnonnull +61 -> 898
    //   840: ldc 39
    //   842: new 138	java/lang/StringBuilder
    //   845: dup
    //   846: ldc 231
    //   848: invokespecial 141	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   851: aload 14
    //   853: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   856: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   859: iconst_0
    //   860: anewarray 43	java/lang/Object
    //   863: invokestatic 49	com/tencent/tinker/lib/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   866: aload 12
    //   868: getfield 53	com/tencent/tinker/lib/e/a:wWm	Lcom/tencent/tinker/lib/d/d;
    //   871: aload 4
    //   873: aload 15
    //   875: getfield 218	com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo:file	Ljava/io/File;
    //   878: aload 14
    //   880: bipush 6
    //   882: invokeinterface 58 5 0
    //   887: aload 10
    //   889: invokestatic 63	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   892: aload_1
    //   893: invokestatic 63	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   896: iconst_0
    //   897: ireturn
    //   898: aconst_null
    //   899: astore_0
    //   900: aload 10
    //   902: aload_2
    //   903: invokevirtual 235	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   906: astore_2
    //   907: aload_2
    //   908: astore_0
    //   909: aload_1
    //   910: aload 11
    //   912: invokevirtual 235	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   915: astore 11
    //   917: aload_2
    //   918: aload 11
    //   920: aload 15
    //   922: getfield 218	com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo:file	Ljava/io/File;
    //   925: invokestatic 240	com/tencent/tinker/b/a:a	(Ljava/io/InputStream;Ljava/io/InputStream;Ljava/io/File;)I
    //   928: pop
    //   929: aload_2
    //   930: invokestatic 246	com/tencent/tinker/c/b/a:S	(Ljava/lang/Object;)V
    //   933: aload 11
    //   935: invokestatic 246	com/tencent/tinker/c/b/a:S	(Ljava/lang/Object;)V
    //   938: aload 15
    //   940: getfield 218	com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo:file	Ljava/io/File;
    //   943: aload 15
    //   945: getfield 221	com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo:bIW	Ljava/lang/String;
    //   948: invokestatic 250	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:f	(Ljava/io/File;Ljava/lang/String;)Z
    //   951: ifne +85 -> 1036
    //   954: ldc 39
    //   956: ldc 252
    //   958: iconst_1
    //   959: anewarray 43	java/lang/Object
    //   962: dup
    //   963: iconst_0
    //   964: aload 15
    //   966: getfield 218	com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo:file	Ljava/io/File;
    //   969: invokevirtual 188	java/io/File:getPath	()Ljava/lang/String;
    //   972: aastore
    //   973: invokestatic 49	com/tencent/tinker/lib/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   976: aload 15
    //   978: getfield 218	com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo:file	Ljava/io/File;
    //   981: invokestatic 256	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:ah	(Ljava/io/File;)Z
    //   984: pop
    //   985: aload 12
    //   987: getfield 53	com/tencent/tinker/lib/e/a:wWm	Lcom/tencent/tinker/lib/d/d;
    //   990: aload 4
    //   992: aload 15
    //   994: getfield 218	com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo:file	Ljava/io/File;
    //   997: aload 14
    //   999: bipush 6
    //   1001: invokeinterface 58 5 0
    //   1006: aload 10
    //   1008: invokestatic 63	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   1011: aload_1
    //   1012: invokestatic 63	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   1015: iconst_0
    //   1016: ireturn
    //   1017: astore 4
    //   1019: aconst_null
    //   1020: astore_3
    //   1021: aload_0
    //   1022: astore_2
    //   1023: aload 4
    //   1025: astore_0
    //   1026: aload_2
    //   1027: invokestatic 246	com/tencent/tinker/c/b/a:S	(Ljava/lang/Object;)V
    //   1030: aload_3
    //   1031: invokestatic 246	com/tencent/tinker/c/b/a:S	(Ljava/lang/Object;)V
    //   1034: aload_0
    //   1035: athrow
    //   1036: ldc 39
    //   1038: ldc_w 258
    //   1041: iconst_3
    //   1042: anewarray 43	java/lang/Object
    //   1045: dup
    //   1046: iconst_0
    //   1047: aload 15
    //   1049: getfield 218	com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo:file	Ljava/io/File;
    //   1052: invokevirtual 188	java/io/File:getPath	()Ljava/lang/String;
    //   1055: aastore
    //   1056: dup
    //   1057: iconst_1
    //   1058: aload 15
    //   1060: getfield 218	com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo:file	Ljava/io/File;
    //   1063: invokevirtual 158	java/io/File:length	()J
    //   1066: invokestatic 171	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1069: aastore
    //   1070: dup
    //   1071: iconst_2
    //   1072: invokestatic 14	java/lang/System:currentTimeMillis	()J
    //   1075: lload 8
    //   1077: lsub
    //   1078: invokestatic 171	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1081: aastore
    //   1082: invokestatic 49	com/tencent/tinker/lib/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1085: goto -521 -> 564
    //   1088: ldc 39
    //   1090: ldc_w 260
    //   1093: iconst_1
    //   1094: anewarray 43	java/lang/Object
    //   1097: dup
    //   1098: iconst_0
    //   1099: invokestatic 14	java/lang/System:currentTimeMillis	()J
    //   1102: lload 6
    //   1104: lsub
    //   1105: invokestatic 171	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1108: aastore
    //   1109: invokestatic 49	com/tencent/tinker/lib/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1112: aload 10
    //   1114: invokestatic 63	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   1117: aload_1
    //   1118: invokestatic 63	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   1121: iconst_1
    //   1122: ireturn
    //   1123: astore_0
    //   1124: aconst_null
    //   1125: astore_1
    //   1126: aconst_null
    //   1127: astore 10
    //   1129: goto -586 -> 543
    //   1132: astore_0
    //   1133: aconst_null
    //   1134: astore_1
    //   1135: goto -592 -> 543
    //   1138: astore_2
    //   1139: aload 11
    //   1141: astore_1
    //   1142: goto -651 -> 491
    //   1145: astore_2
    //   1146: aload 10
    //   1148: astore_0
    //   1149: aload 11
    //   1151: astore_1
    //   1152: goto -661 -> 491
    //   1155: astore_0
    //   1156: aload 11
    //   1158: astore_3
    //   1159: goto -133 -> 1026
    //   1162: astore_0
    //   1163: goto -620 -> 543
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1166	0	paramContext	android.content.Context
    //   0	1166	1	paramString	java.lang.String
    //   0	1166	2	paramFile1	java.io.File
    //   0	1166	3	paramFile2	java.io.File
    //   0	1166	4	paramFile3	java.io.File
    //   0	1166	5	paramShareResPatchInfo	com.tencent.tinker.loader.shareutil.ShareResPatchInfo
    //   3	1100	6	l1	long
    //   249	827	8	l2	long
    //   24	1123	10	localObject1	java.lang.Object
    //   14	1143	11	localObject2	java.lang.Object
    //   9	977	12	locala	com.tencent.tinker.lib.e.a
    //   272	303	13	localObject3	java.lang.Object
    //   584	414	14	str	java.lang.String
    //   604	455	15	localLargeModeInfo	com.tencent.tinker.loader.shareutil.ShareResPatchInfo.LargeModeInfo
    // Exception table:
    //   from	to	target	type
    //   213	227	487	java/lang/Throwable
    //   227	274	487	java/lang/Throwable
    //   279	321	487	java/lang/Throwable
    //   332	419	487	java/lang/Throwable
    //   430	484	487	java/lang/Throwable
    //   554	564	487	java/lang/Throwable
    //   564	606	487	java/lang/Throwable
    //   611	652	487	java/lang/Throwable
    //   663	746	487	java/lang/Throwable
    //   757	765	487	java/lang/Throwable
    //   770	817	487	java/lang/Throwable
    //   828	836	487	java/lang/Throwable
    //   840	887	487	java/lang/Throwable
    //   929	1006	487	java/lang/Throwable
    //   1026	1036	487	java/lang/Throwable
    //   1036	1085	487	java/lang/Throwable
    //   1088	1112	487	java/lang/Throwable
    //   491	537	537	finally
    //   900	907	1017	finally
    //   909	917	1017	finally
    //   16	26	1123	finally
    //   26	45	1132	finally
    //   49	77	1132	finally
    //   88	148	1132	finally
    //   159	192	1132	finally
    //   203	213	1132	finally
    //   16	26	1138	java/lang/Throwable
    //   26	45	1145	java/lang/Throwable
    //   49	77	1145	java/lang/Throwable
    //   88	148	1145	java/lang/Throwable
    //   159	192	1145	java/lang/Throwable
    //   203	213	1145	java/lang/Throwable
    //   917	929	1155	finally
    //   213	227	1162	finally
    //   227	274	1162	finally
    //   279	321	1162	finally
    //   332	419	1162	finally
    //   430	484	1162	finally
    //   554	564	1162	finally
    //   564	606	1162	finally
    //   611	652	1162	finally
    //   663	746	1162	finally
    //   757	765	1162	finally
    //   770	817	1162	finally
    //   828	836	1162	finally
    //   840	887	1162	finally
    //   929	1006	1162	finally
    //   1026	1036	1162	finally
    //   1036	1085	1162	finally
    //   1088	1112	1162	finally
  }
  
  /* Error */
  static boolean c(android.content.Context paramContext, java.lang.String paramString1, java.lang.String paramString2, java.io.File paramFile)
  {
    // Byte code:
    //   0: new 76	com/tencent/tinker/loader/shareutil/ShareResPatchInfo
    //   3: dup
    //   4: invokespecial 266	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:<init>	()V
    //   7: astore 7
    //   9: aload_2
    //   10: aload 7
    //   12: invokestatic 269	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:a	(Ljava/lang/String;Lcom/tencent/tinker/loader/shareutil/ShareResPatchInfo;)V
    //   15: ldc 39
    //   17: ldc_w 271
    //   20: iconst_2
    //   21: anewarray 43	java/lang/Object
    //   24: dup
    //   25: iconst_0
    //   26: aload_1
    //   27: aastore
    //   28: dup
    //   29: iconst_1
    //   30: aload 7
    //   32: invokevirtual 272	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:toString	()Ljava/lang/String;
    //   35: aastore
    //   36: invokestatic 111	com/tencent/tinker/lib/f/a:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   39: aload_0
    //   40: invokestatic 20	com/tencent/tinker/lib/e/a:hN	(Landroid/content/Context;)Lcom/tencent/tinker/lib/e/a;
    //   43: astore_2
    //   44: aload 7
    //   46: getfield 275	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:wZv	Ljava/lang/String;
    //   49: invokestatic 225	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:agm	(Ljava/lang/String;)Z
    //   52: ifne +48 -> 100
    //   55: ldc 39
    //   57: ldc_w 277
    //   60: iconst_2
    //   61: anewarray 43	java/lang/Object
    //   64: dup
    //   65: iconst_0
    //   66: bipush 6
    //   68: invokestatic 166	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:Kn	(I)Ljava/lang/String;
    //   71: aastore
    //   72: dup
    //   73: iconst_1
    //   74: aload 7
    //   76: getfield 275	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:wZv	Ljava/lang/String;
    //   79: aastore
    //   80: invokestatic 49	com/tencent/tinker/lib/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   83: aload_2
    //   84: getfield 53	com/tencent/tinker/lib/e/a:wWm	Lcom/tencent/tinker/lib/d/d;
    //   87: aload_3
    //   88: bipush 6
    //   90: invokestatic 175	com/tencent/tinker/lib/c/b:Kj	(I)I
    //   93: invokeinterface 179 3 0
    //   98: iconst_0
    //   99: ireturn
    //   100: new 34	java/io/File
    //   103: dup
    //   104: aload_1
    //   105: invokespecial 278	java/io/File:<init>	(Ljava/lang/String;)V
    //   108: astore_1
    //   109: new 34	java/io/File
    //   112: dup
    //   113: aload_1
    //   114: ldc_w 280
    //   117: invokespecial 37	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   120: astore 8
    //   122: new 34	java/io/File
    //   125: dup
    //   126: aload_1
    //   127: ldc_w 282
    //   130: invokespecial 37	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   133: astore 9
    //   135: aload 9
    //   137: invokevirtual 285	java/io/File:exists	()Z
    //   140: ifeq +99 -> 239
    //   143: aload 9
    //   145: aload 7
    //   147: getfield 275	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:wZv	Ljava/lang/String;
    //   150: invokestatic 288	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:h	(Ljava/io/File;Ljava/lang/String;)Z
    //   153: ifeq +25 -> 178
    //   156: ldc 39
    //   158: ldc_w 290
    //   161: iconst_1
    //   162: anewarray 43	java/lang/Object
    //   165: dup
    //   166: iconst_0
    //   167: aload 9
    //   169: invokevirtual 188	java/io/File:getPath	()Ljava/lang/String;
    //   172: aastore
    //   173: invokestatic 49	com/tencent/tinker/lib/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   176: iconst_1
    //   177: ireturn
    //   178: ldc 39
    //   180: new 138	java/lang/StringBuilder
    //   183: dup
    //   184: ldc_w 292
    //   187: invokespecial 141	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   190: aload 9
    //   192: invokevirtual 188	java/io/File:getPath	()Ljava/lang/String;
    //   195: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: iconst_0
    //   202: anewarray 43	java/lang/Object
    //   205: invokestatic 49	com/tencent/tinker/lib/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   208: aload 9
    //   210: invokevirtual 295	java/io/File:delete	()Z
    //   213: pop
    //   214: aload_0
    //   215: invokevirtual 301	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   218: astore 6
    //   220: aload 6
    //   222: ifnonnull +29 -> 251
    //   225: ldc 39
    //   227: ldc_w 303
    //   230: iconst_0
    //   231: anewarray 43	java/lang/Object
    //   234: invokestatic 49	com/tencent/tinker/lib/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   237: iconst_0
    //   238: ireturn
    //   239: aload 9
    //   241: invokevirtual 307	java/io/File:getParentFile	()Ljava/io/File;
    //   244: invokevirtual 310	java/io/File:mkdirs	()Z
    //   247: pop
    //   248: goto -34 -> 214
    //   251: aload 6
    //   253: getfield 315	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   256: astore 10
    //   258: aload_0
    //   259: aload 10
    //   261: aload_1
    //   262: aload 8
    //   264: aload_3
    //   265: aload 7
    //   267: invokestatic 317	com/tencent/tinker/lib/c/e:a	(Landroid/content/Context;Ljava/lang/String;Ljava/io/File;Ljava/io/File;Ljava/io/File;Lcom/tencent/tinker/loader/shareutil/ShareResPatchInfo;)Z
    //   270: istore 5
    //   272: iload 5
    //   274: ifne +5 -> 279
    //   277: iconst_0
    //   278: ireturn
    //   279: new 319	com/tencent/tinker/d/a/h
    //   282: dup
    //   283: new 321	java/io/BufferedOutputStream
    //   286: dup
    //   287: new 323	java/io/FileOutputStream
    //   290: dup
    //   291: aload 9
    //   293: invokespecial 324	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   296: invokespecial 327	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   299: invokespecial 328	com/tencent/tinker/d/a/h:<init>	(Ljava/io/OutputStream;)V
    //   302: astore 6
    //   304: new 330	com/tencent/tinker/d/a/g
    //   307: dup
    //   308: aload 10
    //   310: invokespecial 331	com/tencent/tinker/d/a/g:<init>	(Ljava/lang/String;)V
    //   313: astore_0
    //   314: new 330	com/tencent/tinker/d/a/g
    //   317: dup
    //   318: aload_3
    //   319: invokespecial 332	com/tencent/tinker/d/a/g:<init>	(Ljava/io/File;)V
    //   322: astore_1
    //   323: aload_0
    //   324: invokevirtual 336	com/tencent/tinker/d/a/g:entries	()Ljava/util/Enumeration;
    //   327: astore 10
    //   329: iconst_0
    //   330: istore 4
    //   332: aload 10
    //   334: invokeinterface 341 1 0
    //   339: ifeq +206 -> 545
    //   342: aload 10
    //   344: invokeinterface 344 1 0
    //   349: checkcast 346	com/tencent/tinker/d/a/f
    //   352: astore 11
    //   354: aload 11
    //   356: ifnonnull +91 -> 447
    //   359: new 190	com/tencent/tinker/loader/TinkerRuntimeException
    //   362: dup
    //   363: ldc_w 348
    //   366: invokespecial 349	com/tencent/tinker/loader/TinkerRuntimeException:<init>	(Ljava/lang/String;)V
    //   369: athrow
    //   370: astore 7
    //   372: aload 6
    //   374: astore_3
    //   375: aload_0
    //   376: astore_2
    //   377: aload 7
    //   379: astore_0
    //   380: aload_3
    //   381: invokestatic 246	com/tencent/tinker/c/b/a:S	(Ljava/lang/Object;)V
    //   384: aload_2
    //   385: invokestatic 246	com/tencent/tinker/c/b/a:S	(Ljava/lang/Object;)V
    //   388: aload_1
    //   389: invokestatic 246	com/tencent/tinker/c/b/a:S	(Ljava/lang/Object;)V
    //   392: aload 8
    //   394: invokestatic 352	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:k	(Ljava/io/File;)Z
    //   397: pop
    //   398: aload_0
    //   399: athrow
    //   400: astore_0
    //   401: new 190	com/tencent/tinker/loader/TinkerRuntimeException
    //   404: dup
    //   405: new 138	java/lang/StringBuilder
    //   408: dup
    //   409: ldc 192
    //   411: invokespecial 141	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   414: bipush 6
    //   416: invokestatic 166	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:Kn	(I)Ljava/lang/String;
    //   419: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: ldc 194
    //   424: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: aload_0
    //   428: invokevirtual 197	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   431: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: ldc 199
    //   436: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: aload_0
    //   443: invokespecial 202	com/tencent/tinker/loader/TinkerRuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   446: athrow
    //   447: aload 11
    //   449: getfield 355	com/tencent/tinker/d/a/f:name	Ljava/lang/String;
    //   452: astore 12
    //   454: aload 12
    //   456: ldc_w 357
    //   459: invokevirtual 361	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   462: ifne -130 -> 332
    //   465: aload 7
    //   467: getfield 365	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:wZC	Ljava/util/HashSet;
    //   470: aload 12
    //   472: invokestatic 368	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:a	(Ljava/util/HashSet;Ljava/lang/String;)Z
    //   475: ifeq +842 -> 1317
    //   478: aload 7
    //   480: getfield 371	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:wZx	Ljava/util/ArrayList;
    //   483: aload 12
    //   485: invokevirtual 373	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   488: ifne +829 -> 1317
    //   491: aload 7
    //   493: getfield 376	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:wZy	Ljava/util/ArrayList;
    //   496: aload 12
    //   498: invokevirtual 373	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   501: ifne +816 -> 1317
    //   504: aload 7
    //   506: getfield 93	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:wZA	Ljava/util/ArrayList;
    //   509: aload 12
    //   511: invokevirtual 373	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   514: ifne +803 -> 1317
    //   517: aload 12
    //   519: ldc_w 378
    //   522: invokevirtual 84	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   525: ifne +792 -> 1317
    //   528: aload_0
    //   529: aload 11
    //   531: aload 6
    //   533: invokestatic 383	com/tencent/tinker/d/a/i:a	(Lcom/tencent/tinker/d/a/g;Lcom/tencent/tinker/d/a/f;Lcom/tencent/tinker/d/a/h;)V
    //   536: iload 4
    //   538: iconst_1
    //   539: iadd
    //   540: istore 4
    //   542: goto +775 -> 1317
    //   545: aload_0
    //   546: ldc_w 378
    //   549: invokevirtual 387	com/tencent/tinker/d/a/g:agq	(Ljava/lang/String;)Lcom/tencent/tinker/d/a/f;
    //   552: astore 10
    //   554: aload 10
    //   556: ifnonnull +53 -> 609
    //   559: ldc 39
    //   561: ldc_w 389
    //   564: iconst_0
    //   565: anewarray 43	java/lang/Object
    //   568: invokestatic 49	com/tencent/tinker/lib/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   571: aload_2
    //   572: getfield 53	com/tencent/tinker/lib/e/a:wWm	Lcom/tencent/tinker/lib/d/d;
    //   575: aload_3
    //   576: aload 9
    //   578: ldc_w 378
    //   581: bipush 6
    //   583: invokeinterface 58 5 0
    //   588: aload 6
    //   590: invokestatic 246	com/tencent/tinker/c/b/a:S	(Ljava/lang/Object;)V
    //   593: aload_0
    //   594: invokestatic 246	com/tencent/tinker/c/b/a:S	(Ljava/lang/Object;)V
    //   597: aload_1
    //   598: invokestatic 246	com/tencent/tinker/c/b/a:S	(Ljava/lang/Object;)V
    //   601: aload 8
    //   603: invokestatic 352	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:k	(Ljava/io/File;)Z
    //   606: pop
    //   607: iconst_0
    //   608: ireturn
    //   609: aload_0
    //   610: aload 10
    //   612: aload 6
    //   614: invokestatic 383	com/tencent/tinker/d/a/i:a	(Lcom/tencent/tinker/d/a/g;Lcom/tencent/tinker/d/a/f;Lcom/tencent/tinker/d/a/h;)V
    //   617: iload 4
    //   619: iconst_1
    //   620: iadd
    //   621: istore 4
    //   623: aload 7
    //   625: getfield 93	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:wZA	Ljava/util/ArrayList;
    //   628: invokevirtual 203	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   631: astore 10
    //   633: aload 10
    //   635: invokeinterface 129 1 0
    //   640: ifeq +133 -> 773
    //   643: aload 10
    //   645: invokeinterface 133 1 0
    //   650: checkcast 70	java/lang/String
    //   653: astore 12
    //   655: aload_0
    //   656: aload 12
    //   658: invokevirtual 387	com/tencent/tinker/d/a/g:agq	(Ljava/lang/String;)Lcom/tencent/tinker/d/a/f;
    //   661: astore 11
    //   663: aload 11
    //   665: ifnonnull +67 -> 732
    //   668: ldc 39
    //   670: new 138	java/lang/StringBuilder
    //   673: dup
    //   674: ldc_w 391
    //   677: invokespecial 141	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   680: aload 12
    //   682: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   688: iconst_0
    //   689: anewarray 43	java/lang/Object
    //   692: invokestatic 49	com/tencent/tinker/lib/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   695: aload_2
    //   696: getfield 53	com/tencent/tinker/lib/e/a:wWm	Lcom/tencent/tinker/lib/d/d;
    //   699: aload_3
    //   700: aload 9
    //   702: aload 12
    //   704: bipush 6
    //   706: invokeinterface 58 5 0
    //   711: aload 6
    //   713: invokestatic 246	com/tencent/tinker/c/b/a:S	(Ljava/lang/Object;)V
    //   716: aload_0
    //   717: invokestatic 246	com/tencent/tinker/c/b/a:S	(Ljava/lang/Object;)V
    //   720: aload_1
    //   721: invokestatic 246	com/tencent/tinker/c/b/a:S	(Ljava/lang/Object;)V
    //   724: aload 8
    //   726: invokestatic 352	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:k	(Ljava/io/File;)Z
    //   729: pop
    //   730: iconst_0
    //   731: ireturn
    //   732: aload 7
    //   734: getfield 206	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:wZB	Ljava/util/HashMap;
    //   737: aload 12
    //   739: invokevirtual 210	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   742: checkcast 212	com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo
    //   745: astore 12
    //   747: aload 11
    //   749: aload 12
    //   751: getfield 218	com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo:file	Ljava/io/File;
    //   754: aload 12
    //   756: getfield 395	com/tencent/tinker/loader/shareutil/ShareResPatchInfo$LargeModeInfo:wZD	J
    //   759: aload 6
    //   761: invokestatic 398	com/tencent/tinker/d/a/i:a	(Lcom/tencent/tinker/d/a/f;Ljava/io/File;JLcom/tencent/tinker/d/a/h;)V
    //   764: iload 4
    //   766: iconst_1
    //   767: iadd
    //   768: istore 4
    //   770: goto -137 -> 633
    //   773: aload 7
    //   775: getfield 401	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:wZw	Ljava/util/ArrayList;
    //   778: invokevirtual 203	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   781: astore 10
    //   783: aload 10
    //   785: invokeinterface 129 1 0
    //   790: ifeq +144 -> 934
    //   793: aload 10
    //   795: invokeinterface 133 1 0
    //   800: checkcast 70	java/lang/String
    //   803: astore 11
    //   805: aload_1
    //   806: aload 11
    //   808: invokevirtual 387	com/tencent/tinker/d/a/g:agq	(Ljava/lang/String;)Lcom/tencent/tinker/d/a/f;
    //   811: astore 12
    //   813: aload 12
    //   815: ifnonnull +67 -> 882
    //   818: ldc 39
    //   820: new 138	java/lang/StringBuilder
    //   823: dup
    //   824: ldc_w 403
    //   827: invokespecial 141	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   830: aload 11
    //   832: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   835: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   838: iconst_0
    //   839: anewarray 43	java/lang/Object
    //   842: invokestatic 49	com/tencent/tinker/lib/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   845: aload_2
    //   846: getfield 53	com/tencent/tinker/lib/e/a:wWm	Lcom/tencent/tinker/lib/d/d;
    //   849: aload_3
    //   850: aload 9
    //   852: aload 11
    //   854: bipush 6
    //   856: invokeinterface 58 5 0
    //   861: aload 6
    //   863: invokestatic 246	com/tencent/tinker/c/b/a:S	(Ljava/lang/Object;)V
    //   866: aload_0
    //   867: invokestatic 246	com/tencent/tinker/c/b/a:S	(Ljava/lang/Object;)V
    //   870: aload_1
    //   871: invokestatic 246	com/tencent/tinker/c/b/a:S	(Ljava/lang/Object;)V
    //   874: aload 8
    //   876: invokestatic 352	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:k	(Ljava/io/File;)Z
    //   879: pop
    //   880: iconst_0
    //   881: ireturn
    //   882: aload 7
    //   884: getfield 103	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:wZz	Ljava/util/HashMap;
    //   887: aload 11
    //   889: invokevirtual 406	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   892: ifeq +31 -> 923
    //   895: aload 12
    //   897: aload 7
    //   899: getfield 103	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:wZz	Ljava/util/HashMap;
    //   902: aload 11
    //   904: invokevirtual 210	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   907: checkcast 34	java/io/File
    //   910: aload 12
    //   912: getfield 407	com/tencent/tinker/d/a/f:wZD	J
    //   915: aload 6
    //   917: invokestatic 398	com/tencent/tinker/d/a/i:a	(Lcom/tencent/tinker/d/a/f;Ljava/io/File;JLcom/tencent/tinker/d/a/h;)V
    //   920: goto +400 -> 1320
    //   923: aload_1
    //   924: aload 12
    //   926: aload 6
    //   928: invokestatic 383	com/tencent/tinker/d/a/i:a	(Lcom/tencent/tinker/d/a/g;Lcom/tencent/tinker/d/a/f;Lcom/tencent/tinker/d/a/h;)V
    //   931: goto +389 -> 1320
    //   934: aload 7
    //   936: getfield 376	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:wZy	Ljava/util/ArrayList;
    //   939: invokevirtual 203	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   942: astore 10
    //   944: aload 10
    //   946: invokeinterface 129 1 0
    //   951: ifeq +144 -> 1095
    //   954: aload 10
    //   956: invokeinterface 133 1 0
    //   961: checkcast 70	java/lang/String
    //   964: astore 11
    //   966: aload_1
    //   967: aload 11
    //   969: invokevirtual 387	com/tencent/tinker/d/a/g:agq	(Ljava/lang/String;)Lcom/tencent/tinker/d/a/f;
    //   972: astore 12
    //   974: aload 12
    //   976: ifnonnull +67 -> 1043
    //   979: ldc 39
    //   981: new 138	java/lang/StringBuilder
    //   984: dup
    //   985: ldc_w 409
    //   988: invokespecial 141	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   991: aload 11
    //   993: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   996: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   999: iconst_0
    //   1000: anewarray 43	java/lang/Object
    //   1003: invokestatic 49	com/tencent/tinker/lib/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1006: aload_2
    //   1007: getfield 53	com/tencent/tinker/lib/e/a:wWm	Lcom/tencent/tinker/lib/d/d;
    //   1010: aload_3
    //   1011: aload 9
    //   1013: aload 11
    //   1015: bipush 6
    //   1017: invokeinterface 58 5 0
    //   1022: aload 6
    //   1024: invokestatic 246	com/tencent/tinker/c/b/a:S	(Ljava/lang/Object;)V
    //   1027: aload_0
    //   1028: invokestatic 246	com/tencent/tinker/c/b/a:S	(Ljava/lang/Object;)V
    //   1031: aload_1
    //   1032: invokestatic 246	com/tencent/tinker/c/b/a:S	(Ljava/lang/Object;)V
    //   1035: aload 8
    //   1037: invokestatic 352	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:k	(Ljava/io/File;)Z
    //   1040: pop
    //   1041: iconst_0
    //   1042: ireturn
    //   1043: aload 7
    //   1045: getfield 103	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:wZz	Ljava/util/HashMap;
    //   1048: aload 11
    //   1050: invokevirtual 406	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   1053: ifeq +31 -> 1084
    //   1056: aload 12
    //   1058: aload 7
    //   1060: getfield 103	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:wZz	Ljava/util/HashMap;
    //   1063: aload 11
    //   1065: invokevirtual 210	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1068: checkcast 34	java/io/File
    //   1071: aload 12
    //   1073: getfield 407	com/tencent/tinker/d/a/f:wZD	J
    //   1076: aload 6
    //   1078: invokestatic 398	com/tencent/tinker/d/a/i:a	(Lcom/tencent/tinker/d/a/f;Ljava/io/File;JLcom/tencent/tinker/d/a/h;)V
    //   1081: goto +248 -> 1329
    //   1084: aload_1
    //   1085: aload 12
    //   1087: aload 6
    //   1089: invokestatic 383	com/tencent/tinker/d/a/i:a	(Lcom/tencent/tinker/d/a/g;Lcom/tencent/tinker/d/a/f;Lcom/tencent/tinker/d/a/h;)V
    //   1092: goto +237 -> 1329
    //   1095: aload_0
    //   1096: invokevirtual 412	com/tencent/tinker/d/a/g:cQV	()V
    //   1099: aload_0
    //   1100: getfield 415	com/tencent/tinker/d/a/g:tIg	Ljava/lang/String;
    //   1103: astore 10
    //   1105: aload 10
    //   1107: ifnonnull +107 -> 1214
    //   1110: aload 6
    //   1112: getstatic 419	com/tencent/tinker/d/a/h:wZY	[B
    //   1115: putfield 422	com/tencent/tinker/d/a/h:xac	[B
    //   1118: aload 6
    //   1120: invokestatic 246	com/tencent/tinker/c/b/a:S	(Ljava/lang/Object;)V
    //   1123: aload_0
    //   1124: invokestatic 246	com/tencent/tinker/c/b/a:S	(Ljava/lang/Object;)V
    //   1127: aload_1
    //   1128: invokestatic 246	com/tencent/tinker/c/b/a:S	(Ljava/lang/Object;)V
    //   1131: aload 8
    //   1133: invokestatic 352	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:k	(Ljava/io/File;)Z
    //   1136: pop
    //   1137: aload 9
    //   1139: aload 7
    //   1141: getfield 275	com/tencent/tinker/loader/shareutil/ShareResPatchInfo:wZv	Ljava/lang/String;
    //   1144: invokestatic 288	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:h	(Ljava/io/File;Ljava/lang/String;)Z
    //   1147: ifne +95 -> 1242
    //   1150: ldc 39
    //   1152: ldc_w 424
    //   1155: iconst_3
    //   1156: anewarray 43	java/lang/Object
    //   1159: dup
    //   1160: iconst_0
    //   1161: aload 9
    //   1163: invokevirtual 427	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1166: aastore
    //   1167: dup
    //   1168: iconst_1
    //   1169: iload 4
    //   1171: invokestatic 432	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1174: aastore
    //   1175: dup
    //   1176: iconst_2
    //   1177: aload 9
    //   1179: invokevirtual 158	java/io/File:length	()J
    //   1182: invokestatic 171	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1185: aastore
    //   1186: invokestatic 111	com/tencent/tinker/lib/f/a:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1189: aload 9
    //   1191: invokestatic 256	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:ah	(Ljava/io/File;)Z
    //   1194: pop
    //   1195: aload_2
    //   1196: getfield 53	com/tencent/tinker/lib/e/a:wWm	Lcom/tencent/tinker/lib/d/d;
    //   1199: aload_3
    //   1200: aload 9
    //   1202: ldc_w 282
    //   1205: bipush 6
    //   1207: invokeinterface 58 5 0
    //   1212: iconst_0
    //   1213: ireturn
    //   1214: aload 10
    //   1216: getstatic 438	com/tencent/tinker/d/a/d:UTF_8	Ljava/nio/charset/Charset;
    //   1219: invokevirtual 442	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
    //   1222: astore 10
    //   1224: ldc_w 444
    //   1227: aload 10
    //   1229: invokestatic 448	com/tencent/tinker/d/a/h:y	(Ljava/lang/String;[B)V
    //   1232: aload 6
    //   1234: aload 10
    //   1236: putfield 422	com/tencent/tinker/d/a/h:xac	[B
    //   1239: goto -121 -> 1118
    //   1242: ldc 39
    //   1244: ldc_w 450
    //   1247: iconst_3
    //   1248: anewarray 43	java/lang/Object
    //   1251: dup
    //   1252: iconst_0
    //   1253: aload 9
    //   1255: invokevirtual 427	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1258: aastore
    //   1259: dup
    //   1260: iconst_1
    //   1261: iload 4
    //   1263: invokestatic 432	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1266: aastore
    //   1267: dup
    //   1268: iconst_2
    //   1269: aload 9
    //   1271: invokevirtual 158	java/io/File:length	()J
    //   1274: invokestatic 171	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1277: aastore
    //   1278: invokestatic 111	com/tencent/tinker/lib/f/a:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1281: iconst_1
    //   1282: ireturn
    //   1283: astore_0
    //   1284: aconst_null
    //   1285: astore_1
    //   1286: aconst_null
    //   1287: astore_2
    //   1288: aconst_null
    //   1289: astore_3
    //   1290: goto -910 -> 380
    //   1293: astore_0
    //   1294: aconst_null
    //   1295: astore_1
    //   1296: aconst_null
    //   1297: astore_2
    //   1298: aload 6
    //   1300: astore_3
    //   1301: goto -921 -> 380
    //   1304: astore_3
    //   1305: aconst_null
    //   1306: astore_1
    //   1307: aload_0
    //   1308: astore_2
    //   1309: aload_3
    //   1310: astore_0
    //   1311: aload 6
    //   1313: astore_3
    //   1314: goto -934 -> 380
    //   1317: goto -985 -> 332
    //   1320: iload 4
    //   1322: iconst_1
    //   1323: iadd
    //   1324: istore 4
    //   1326: goto -543 -> 783
    //   1329: iload 4
    //   1331: iconst_1
    //   1332: iadd
    //   1333: istore 4
    //   1335: goto -391 -> 944
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1338	0	paramContext	android.content.Context
    //   0	1338	1	paramString1	java.lang.String
    //   0	1338	2	paramString2	java.lang.String
    //   0	1338	3	paramFile	java.io.File
    //   330	1004	4	i	int
    //   270	3	5	bool	boolean
    //   218	1094	6	localObject1	java.lang.Object
    //   7	259	7	localShareResPatchInfo	com.tencent.tinker.loader.shareutil.ShareResPatchInfo
    //   370	770	7	localObject2	java.lang.Object
    //   120	1012	8	localFile1	java.io.File
    //   133	1137	9	localFile2	java.io.File
    //   256	979	10	localObject3	java.lang.Object
    //   352	712	11	localObject4	java.lang.Object
    //   452	634	12	localObject5	java.lang.Object
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
    //   668	711	370	finally
    //   732	764	370	finally
    //   773	783	370	finally
    //   783	813	370	finally
    //   818	861	370	finally
    //   882	920	370	finally
    //   923	931	370	finally
    //   934	944	370	finally
    //   944	974	370	finally
    //   979	1022	370	finally
    //   1043	1081	370	finally
    //   1084	1092	370	finally
    //   1095	1105	370	finally
    //   1110	1118	370	finally
    //   1214	1239	370	finally
    //   214	220	400	java/lang/Throwable
    //   225	237	400	java/lang/Throwable
    //   251	272	400	java/lang/Throwable
    //   380	400	400	java/lang/Throwable
    //   588	607	400	java/lang/Throwable
    //   711	730	400	java/lang/Throwable
    //   861	880	400	java/lang/Throwable
    //   1022	1041	400	java/lang/Throwable
    //   1118	1212	400	java/lang/Throwable
    //   1242	1281	400	java/lang/Throwable
    //   279	304	1283	finally
    //   304	314	1293	finally
    //   314	323	1304	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tinker.lib.c.e
 * JD-Core Version:    0.7.0.1
 */