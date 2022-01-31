package com.tencent.mm.plugin.scanner.util;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.licence.model.LibCardRecog;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.qbar.QbarNative;

public final class h
  extends b
{
  private int mCount;
  private boolean qCE;
  public boolean qCF;
  private boolean qCG;
  public boolean[] qCH;
  private boolean qCI;
  private boolean qCJ;
  private boolean qCK;
  private Bitmap qCL;
  private final Object qCM;
  
  public h(b.a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(parama);
    AppMethodBeat.i(81416);
    this.mCount = 0;
    this.qCM = new Object();
    this.qCH = new boolean[4];
    this.qCE = false;
    this.qCF = paramBoolean1;
    this.qCG = paramBoolean2;
    ab.d("MicroMsg.ScanBankCardDecoder", "isPortrait:%s, needRotate:%s", new Object[] { Boolean.FALSE, Boolean.valueOf(paramBoolean1) });
    AppMethodBeat.o(81416);
  }
  
  /* Error */
  public final boolean a(byte[] paramArrayOfByte, android.graphics.Point paramPoint, android.graphics.Rect paramRect)
  {
    // Byte code:
    //   0: ldc 77
    //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 40	com/tencent/mm/plugin/scanner/util/h:qCM	Ljava/lang/Object;
    //   9: astore 19
    //   11: aload 19
    //   13: monitorenter
    //   14: invokestatic 83	java/lang/System:currentTimeMillis	()J
    //   17: lstore 12
    //   19: ldc 50
    //   21: ldc 85
    //   23: iconst_2
    //   24: anewarray 35	java/lang/Object
    //   27: dup
    //   28: iconst_0
    //   29: aload_2
    //   30: aastore
    //   31: dup
    //   32: iconst_1
    //   33: aload_3
    //   34: aastore
    //   35: invokestatic 68	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   38: iconst_1
    //   39: aload_0
    //   40: getfield 87	com/tencent/mm/plugin/scanner/util/h:qCI	Z
    //   43: if_icmpne +20 -> 63
    //   46: ldc 50
    //   48: ldc 89
    //   50: invokestatic 92	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   53: aload 19
    //   55: monitorexit
    //   56: ldc 77
    //   58: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: iconst_0
    //   62: ireturn
    //   63: aload_2
    //   64: getfield 97	android/graphics/Point:x	I
    //   67: i2f
    //   68: aload_3
    //   69: invokevirtual 103	android/graphics/Rect:width	()I
    //   72: i2f
    //   73: fdiv
    //   74: aload_2
    //   75: getfield 106	android/graphics/Point:y	I
    //   78: i2f
    //   79: aload_3
    //   80: invokevirtual 109	android/graphics/Rect:height	()I
    //   83: i2f
    //   84: fdiv
    //   85: invokestatic 115	java/lang/Math:min	(FF)F
    //   88: ldc 116
    //   90: invokestatic 115	java/lang/Math:min	(FF)F
    //   93: fstore 4
    //   95: aload_3
    //   96: invokevirtual 103	android/graphics/Rect:width	()I
    //   99: i2f
    //   100: fconst_1
    //   101: fload 4
    //   103: fconst_1
    //   104: fsub
    //   105: ldc 117
    //   107: fmul
    //   108: fadd
    //   109: fmul
    //   110: f2i
    //   111: iconst_4
    //   112: idiv
    //   113: iconst_4
    //   114: imul
    //   115: istore 5
    //   117: aload_3
    //   118: invokevirtual 109	android/graphics/Rect:height	()I
    //   121: i2f
    //   122: fload 4
    //   124: fmul
    //   125: f2i
    //   126: iconst_4
    //   127: idiv
    //   128: iconst_4
    //   129: imul
    //   130: istore 6
    //   132: ldc 50
    //   134: ldc 119
    //   136: iconst_3
    //   137: anewarray 35	java/lang/Object
    //   140: dup
    //   141: iconst_0
    //   142: fload 4
    //   144: invokestatic 124	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   147: aastore
    //   148: dup
    //   149: iconst_1
    //   150: iload 5
    //   152: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   155: aastore
    //   156: dup
    //   157: iconst_2
    //   158: iload 6
    //   160: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   163: aastore
    //   164: invokestatic 68	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   167: aload_0
    //   168: getfield 131	com/tencent/mm/plugin/scanner/util/h:qCJ	Z
    //   171: ifne +84 -> 255
    //   174: invokestatic 83	java/lang/System:currentTimeMillis	()J
    //   177: lstore 14
    //   179: iload 5
    //   181: iload 6
    //   183: bipush 8
    //   185: aload_0
    //   186: getfield 44	com/tencent/mm/plugin/scanner/util/h:qCE	Z
    //   189: invokestatic 137	com/tencent/qbar/QbarNative:focusedEngineForBankcardInit	(IIIZ)I
    //   192: istore 7
    //   194: ldc 50
    //   196: new 139	java/lang/StringBuilder
    //   199: dup
    //   200: ldc 141
    //   202: invokespecial 144	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   205: invokestatic 83	java/lang/System:currentTimeMillis	()J
    //   208: lload 14
    //   210: lsub
    //   211: invokevirtual 148	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   214: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 92	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   220: iload 7
    //   222: ifeq +28 -> 250
    //   225: ldc 50
    //   227: ldc 154
    //   229: iload 7
    //   231: invokestatic 159	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   234: invokevirtual 163	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   237: invokestatic 166	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   240: aload 19
    //   242: monitorexit
    //   243: ldc 77
    //   245: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   248: iconst_0
    //   249: ireturn
    //   250: aload_0
    //   251: iconst_1
    //   252: putfield 131	com/tencent/mm/plugin/scanner/util/h:qCJ	Z
    //   255: aload_0
    //   256: getfield 168	com/tencent/mm/plugin/scanner/util/h:qCK	Z
    //   259: ifne +91 -> 350
    //   262: iconst_1
    //   263: aload_0
    //   264: getfield 131	com/tencent/mm/plugin/scanner/util/h:qCJ	Z
    //   267: if_icmpne +83 -> 350
    //   270: ldc 50
    //   272: ldc 170
    //   274: iconst_5
    //   275: anewarray 35	java/lang/Object
    //   278: dup
    //   279: iconst_0
    //   280: iload 5
    //   282: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   285: aastore
    //   286: dup
    //   287: iconst_1
    //   288: iload 6
    //   290: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   293: aastore
    //   294: dup
    //   295: iconst_2
    //   296: aload_3
    //   297: invokevirtual 103	android/graphics/Rect:width	()I
    //   300: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   303: aastore
    //   304: dup
    //   305: iconst_3
    //   306: aload_3
    //   307: invokevirtual 109	android/graphics/Rect:height	()I
    //   310: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   313: aastore
    //   314: dup
    //   315: iconst_4
    //   316: aload_0
    //   317: getfield 44	com/tencent/mm/plugin/scanner/util/h:qCE	Z
    //   320: invokestatic 62	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   323: aastore
    //   324: invokestatic 68	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   327: iload 5
    //   329: iload 6
    //   331: aload_0
    //   332: getfield 44	com/tencent/mm/plugin/scanner/util/h:qCE	Z
    //   335: invokestatic 176	com/tencent/mm/plugin/licence/model/LibCardRecog:recognizeBankCardInit	(IIZ)I
    //   338: ifne +459 -> 797
    //   341: iconst_1
    //   342: istore 16
    //   344: aload_0
    //   345: iload 16
    //   347: putfield 168	com/tencent/mm/plugin/scanner/util/h:qCK	Z
    //   350: aload_3
    //   351: getfield 179	android/graphics/Rect:left	I
    //   354: iload 5
    //   356: aload_3
    //   357: invokevirtual 103	android/graphics/Rect:width	()I
    //   360: isub
    //   361: iconst_2
    //   362: idiv
    //   363: isub
    //   364: istore 7
    //   366: aload_3
    //   367: getfield 182	android/graphics/Rect:top	I
    //   370: iload 6
    //   372: aload_3
    //   373: invokevirtual 109	android/graphics/Rect:height	()I
    //   376: isub
    //   377: iconst_2
    //   378: idiv
    //   379: isub
    //   380: istore 8
    //   382: ldc 50
    //   384: ldc 184
    //   386: iconst_3
    //   387: anewarray 35	java/lang/Object
    //   390: dup
    //   391: iconst_0
    //   392: iload 7
    //   394: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   397: aastore
    //   398: dup
    //   399: iconst_1
    //   400: iload 8
    //   402: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   405: aastore
    //   406: dup
    //   407: iconst_2
    //   408: aload_1
    //   409: arraylength
    //   410: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   413: aastore
    //   414: invokestatic 68	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   417: invokestatic 190	com/tencent/mm/m/g:Nq	()Lcom/tencent/mm/m/e;
    //   420: ldc 192
    //   422: invokevirtual 197	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   425: astore_3
    //   426: aload_3
    //   427: ifnull +184 -> 611
    //   430: aload_3
    //   431: ldc 199
    //   433: invokevirtual 203	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   436: ifeq +175 -> 611
    //   439: aload_0
    //   440: aload_0
    //   441: getfield 33	com/tencent/mm/plugin/scanner/util/h:mCount	I
    //   444: iconst_1
    //   445: iadd
    //   446: putfield 33	com/tencent/mm/plugin/scanner/util/h:mCount	I
    //   449: aload_2
    //   450: getfield 97	android/graphics/Point:x	I
    //   453: istore 9
    //   455: aload_2
    //   456: getfield 106	android/graphics/Point:y	I
    //   459: istore 10
    //   461: aload_0
    //   462: getfield 33	com/tencent/mm/plugin/scanner/util/h:mCount	I
    //   465: istore 11
    //   467: new 205	android/graphics/YuvImage
    //   470: dup
    //   471: aload_1
    //   472: bipush 17
    //   474: iload 9
    //   476: iload 10
    //   478: aconst_null
    //   479: invokespecial 208	android/graphics/YuvImage:<init>	([BIII[I)V
    //   482: astore_3
    //   483: ldc 50
    //   485: ldc 210
    //   487: invokestatic 92	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   490: new 212	java/io/ByteArrayOutputStream
    //   493: dup
    //   494: invokespecial 213	java/io/ByteArrayOutputStream:<init>	()V
    //   497: astore 20
    //   499: aload_3
    //   500: new 99	android/graphics/Rect
    //   503: dup
    //   504: iconst_0
    //   505: iconst_0
    //   506: iload 9
    //   508: iload 10
    //   510: invokespecial 216	android/graphics/Rect:<init>	(IIII)V
    //   513: bipush 100
    //   515: aload 20
    //   517: invokevirtual 220	android/graphics/YuvImage:compressToJpeg	(Landroid/graphics/Rect;ILjava/io/OutputStream;)Z
    //   520: pop
    //   521: aload 20
    //   523: invokevirtual 224	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   526: astore 18
    //   528: aconst_null
    //   529: astore_3
    //   530: new 226	java/io/FileOutputStream
    //   533: dup
    //   534: new 228	java/io/File
    //   537: dup
    //   538: new 139	java/lang/StringBuilder
    //   541: dup
    //   542: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   545: invokestatic 235	com/tencent/mm/compatible/util/h:getExternalStorageDirectory	()Ljava/io/File;
    //   548: invokevirtual 238	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   551: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: ldc 243
    //   556: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   559: iload 11
    //   561: invokestatic 159	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   564: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: ldc 245
    //   569: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   575: invokespecial 246	java/io/File:<init>	(Ljava/lang/String;)V
    //   578: invokespecial 249	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   581: astore 17
    //   583: aload 17
    //   585: astore_3
    //   586: aload 17
    //   588: aload 18
    //   590: invokevirtual 253	java/io/FileOutputStream:write	([B)V
    //   593: aload 17
    //   595: astore_3
    //   596: aload 17
    //   598: invokevirtual 256	java/io/FileOutputStream:flush	()V
    //   601: aload 17
    //   603: invokevirtual 259	java/io/FileOutputStream:close	()V
    //   606: aload 20
    //   608: invokevirtual 260	java/io/ByteArrayOutputStream:close	()V
    //   611: invokestatic 83	java/lang/System:currentTimeMillis	()J
    //   614: lstore 14
    //   616: new 262	com/tencent/mm/plugin/licence/model/BankCardInfo
    //   619: dup
    //   620: aload_2
    //   621: getfield 97	android/graphics/Point:x	I
    //   624: aload_2
    //   625: getfield 106	android/graphics/Point:y	I
    //   628: invokespecial 265	com/tencent/mm/plugin/licence/model/BankCardInfo:<init>	(II)V
    //   631: astore_3
    //   632: aload_1
    //   633: aload_2
    //   634: getfield 106	android/graphics/Point:y	I
    //   637: aload_2
    //   638: getfield 97	android/graphics/Point:x	I
    //   641: iload 7
    //   643: iload 8
    //   645: iload 6
    //   647: iload 5
    //   649: aload_3
    //   650: aload_0
    //   651: getfield 42	com/tencent/mm/plugin/scanner/util/h:qCH	[Z
    //   654: invokestatic 269	com/tencent/mm/plugin/licence/model/LibCardRecog:recognizeBankCardProcess	([BIIIIIILcom/tencent/mm/plugin/licence/model/BankCardInfo;[Z)I
    //   657: istore 5
    //   659: ldc 50
    //   661: new 139	java/lang/StringBuilder
    //   664: dup
    //   665: ldc_w 271
    //   668: invokespecial 144	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   671: invokestatic 83	java/lang/System:currentTimeMillis	()J
    //   674: lload 14
    //   676: lsub
    //   677: invokevirtual 148	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   680: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   683: invokestatic 92	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   686: aload_0
    //   687: getfield 46	com/tencent/mm/plugin/scanner/util/h:qCF	Z
    //   690: ifne +59 -> 749
    //   693: aload_0
    //   694: getfield 42	com/tencent/mm/plugin/scanner/util/h:qCH	[Z
    //   697: iconst_0
    //   698: baload
    //   699: istore 16
    //   701: aload_0
    //   702: getfield 42	com/tencent/mm/plugin/scanner/util/h:qCH	[Z
    //   705: iconst_0
    //   706: aload_0
    //   707: getfield 42	com/tencent/mm/plugin/scanner/util/h:qCH	[Z
    //   710: iconst_2
    //   711: baload
    //   712: bastore
    //   713: aload_0
    //   714: getfield 42	com/tencent/mm/plugin/scanner/util/h:qCH	[Z
    //   717: iconst_2
    //   718: iload 16
    //   720: bastore
    //   721: aload_0
    //   722: getfield 42	com/tencent/mm/plugin/scanner/util/h:qCH	[Z
    //   725: iconst_1
    //   726: baload
    //   727: istore 16
    //   729: aload_0
    //   730: getfield 42	com/tencent/mm/plugin/scanner/util/h:qCH	[Z
    //   733: iconst_1
    //   734: aload_0
    //   735: getfield 42	com/tencent/mm/plugin/scanner/util/h:qCH	[Z
    //   738: iconst_3
    //   739: baload
    //   740: bastore
    //   741: aload_0
    //   742: getfield 42	com/tencent/mm/plugin/scanner/util/h:qCH	[Z
    //   745: iconst_3
    //   746: iload 16
    //   748: bastore
    //   749: ldc 50
    //   751: ldc_w 273
    //   754: iload 5
    //   756: invokestatic 159	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   759: invokevirtual 163	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   762: invokestatic 92	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   765: iload 5
    //   767: iconst_1
    //   768: if_icmpeq +234 -> 1002
    //   771: ldc 50
    //   773: ldc_w 275
    //   776: iload 5
    //   778: invokestatic 159	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   781: invokevirtual 163	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   784: invokestatic 92	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   787: aload 19
    //   789: monitorexit
    //   790: ldc 77
    //   792: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   795: iconst_0
    //   796: ireturn
    //   797: iconst_0
    //   798: istore 16
    //   800: goto -456 -> 344
    //   803: astore_3
    //   804: ldc 50
    //   806: aload_3
    //   807: ldc_w 277
    //   810: iconst_0
    //   811: anewarray 35	java/lang/Object
    //   814: invokestatic 281	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   817: goto -211 -> 606
    //   820: astore_1
    //   821: aload 19
    //   823: monitorexit
    //   824: ldc 77
    //   826: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   829: aload_1
    //   830: athrow
    //   831: astore_3
    //   832: ldc 50
    //   834: aload_3
    //   835: ldc_w 277
    //   838: iconst_0
    //   839: anewarray 35	java/lang/Object
    //   842: invokestatic 281	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   845: goto -234 -> 611
    //   848: astore 18
    //   850: aconst_null
    //   851: astore 17
    //   853: aload 17
    //   855: astore_3
    //   856: ldc 50
    //   858: ldc_w 283
    //   861: iconst_1
    //   862: anewarray 35	java/lang/Object
    //   865: dup
    //   866: iconst_0
    //   867: aload 18
    //   869: invokevirtual 286	java/io/IOException:getMessage	()Ljava/lang/String;
    //   872: aastore
    //   873: invokestatic 288	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   876: aload 17
    //   878: astore_3
    //   879: ldc 50
    //   881: aload 18
    //   883: ldc_w 277
    //   886: iconst_0
    //   887: anewarray 35	java/lang/Object
    //   890: invokestatic 281	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   893: aload 17
    //   895: ifnull +8 -> 903
    //   898: aload 17
    //   900: invokevirtual 259	java/io/FileOutputStream:close	()V
    //   903: aload 20
    //   905: invokevirtual 260	java/io/ByteArrayOutputStream:close	()V
    //   908: goto -297 -> 611
    //   911: astore_3
    //   912: ldc 50
    //   914: aload_3
    //   915: ldc_w 277
    //   918: iconst_0
    //   919: anewarray 35	java/lang/Object
    //   922: invokestatic 281	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   925: goto -314 -> 611
    //   928: astore_3
    //   929: ldc 50
    //   931: aload_3
    //   932: ldc_w 277
    //   935: iconst_0
    //   936: anewarray 35	java/lang/Object
    //   939: invokestatic 281	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   942: goto -39 -> 903
    //   945: astore_1
    //   946: aload_3
    //   947: astore_2
    //   948: aload_2
    //   949: ifnull +7 -> 956
    //   952: aload_2
    //   953: invokevirtual 259	java/io/FileOutputStream:close	()V
    //   956: aload 20
    //   958: invokevirtual 260	java/io/ByteArrayOutputStream:close	()V
    //   961: ldc 77
    //   963: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   966: aload_1
    //   967: athrow
    //   968: astore_2
    //   969: ldc 50
    //   971: aload_2
    //   972: ldc_w 277
    //   975: iconst_0
    //   976: anewarray 35	java/lang/Object
    //   979: invokestatic 281	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   982: goto -26 -> 956
    //   985: astore_2
    //   986: ldc 50
    //   988: aload_2
    //   989: ldc_w 277
    //   992: iconst_0
    //   993: anewarray 35	java/lang/Object
    //   996: invokestatic 281	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   999: goto -38 -> 961
    //   1002: new 290	android/graphics/BitmapFactory$Options
    //   1005: dup
    //   1006: invokespecial 291	android/graphics/BitmapFactory$Options:<init>	()V
    //   1009: astore_1
    //   1010: aload_1
    //   1011: iconst_1
    //   1012: putfield 294	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1015: aload_0
    //   1016: aload_3
    //   1017: getfield 298	com/tencent/mm/plugin/licence/model/BankCardInfo:bitmapData	[B
    //   1020: iconst_0
    //   1021: aload_3
    //   1022: getfield 301	com/tencent/mm/plugin/licence/model/BankCardInfo:bitmapLen	I
    //   1025: aload_1
    //   1026: invokestatic 307	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1029: getstatic 313	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   1032: iconst_1
    //   1033: invokevirtual 319	android/graphics/Bitmap:copy	(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;
    //   1036: putfield 321	com/tencent/mm/plugin/scanner/util/h:qCL	Landroid/graphics/Bitmap;
    //   1039: aload_0
    //   1040: getfield 321	com/tencent/mm/plugin/scanner/util/h:qCL	Landroid/graphics/Bitmap;
    //   1043: ifnonnull +13 -> 1056
    //   1046: aload 19
    //   1048: monitorexit
    //   1049: ldc 77
    //   1051: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1054: iconst_0
    //   1055: ireturn
    //   1056: aload_3
    //   1057: invokevirtual 325	com/tencent/mm/plugin/licence/model/BankCardInfo:getRectX	()[I
    //   1060: astore_1
    //   1061: aload_3
    //   1062: invokevirtual 328	com/tencent/mm/plugin/licence/model/BankCardInfo:getRectY	()[I
    //   1065: astore_2
    //   1066: aload_1
    //   1067: aload_3
    //   1068: invokevirtual 331	com/tencent/mm/plugin/licence/model/BankCardInfo:getCardNumLen	()I
    //   1071: iconst_1
    //   1072: isub
    //   1073: iaload
    //   1074: aload_1
    //   1075: iconst_0
    //   1076: iaload
    //   1077: isub
    //   1078: aload_1
    //   1079: iconst_1
    //   1080: iaload
    //   1081: aload_1
    //   1082: iconst_0
    //   1083: iaload
    //   1084: isub
    //   1085: iadd
    //   1086: istore 6
    //   1088: iload 6
    //   1090: i2f
    //   1091: ldc_w 332
    //   1094: fmul
    //   1095: f2i
    //   1096: istore 9
    //   1098: aload_1
    //   1099: iconst_0
    //   1100: iaload
    //   1101: i2f
    //   1102: iload 6
    //   1104: i2f
    //   1105: ldc_w 333
    //   1108: fmul
    //   1109: fsub
    //   1110: f2i
    //   1111: istore 5
    //   1113: iload 5
    //   1115: ifle +181 -> 1296
    //   1118: iload 6
    //   1120: iconst_2
    //   1121: imul
    //   1122: i2f
    //   1123: ldc_w 333
    //   1126: fmul
    //   1127: f2i
    //   1128: iload 6
    //   1130: iadd
    //   1131: istore 8
    //   1133: aload_2
    //   1134: iconst_0
    //   1135: iaload
    //   1136: i2f
    //   1137: aload_1
    //   1138: iconst_1
    //   1139: iaload
    //   1140: aload_1
    //   1141: iconst_0
    //   1142: iaload
    //   1143: isub
    //   1144: i2f
    //   1145: ldc_w 334
    //   1148: fmul
    //   1149: fconst_2
    //   1150: fdiv
    //   1151: fadd
    //   1152: iload 9
    //   1154: iconst_2
    //   1155: idiv
    //   1156: i2f
    //   1157: fsub
    //   1158: f2i
    //   1159: istore 6
    //   1161: iload 6
    //   1163: ifle +139 -> 1302
    //   1166: iload 8
    //   1168: istore 7
    //   1170: iload 5
    //   1172: iload 8
    //   1174: iadd
    //   1175: aload_3
    //   1176: getfield 336	com/tencent/mm/plugin/licence/model/BankCardInfo:width	I
    //   1179: if_icmple +12 -> 1191
    //   1182: aload_3
    //   1183: getfield 336	com/tencent/mm/plugin/licence/model/BankCardInfo:width	I
    //   1186: iload 5
    //   1188: isub
    //   1189: istore 7
    //   1191: iload 9
    //   1193: istore 8
    //   1195: iload 6
    //   1197: iload 9
    //   1199: iadd
    //   1200: aload_3
    //   1201: getfield 338	com/tencent/mm/plugin/licence/model/BankCardInfo:height	I
    //   1204: if_icmple +12 -> 1216
    //   1207: aload_3
    //   1208: getfield 338	com/tencent/mm/plugin/licence/model/BankCardInfo:height	I
    //   1211: iload 6
    //   1213: isub
    //   1214: istore 8
    //   1216: aload_0
    //   1217: aload_0
    //   1218: getfield 321	com/tencent/mm/plugin/scanner/util/h:qCL	Landroid/graphics/Bitmap;
    //   1221: iload 5
    //   1223: iload 6
    //   1225: iload 7
    //   1227: iload 8
    //   1229: invokestatic 342	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   1232: putfield 321	com/tencent/mm/plugin/scanner/util/h:qCL	Landroid/graphics/Bitmap;
    //   1235: iconst_3
    //   1236: putstatic 345	com/tencent/mm/plugin/scanner/util/h:quq	I
    //   1239: aload_0
    //   1240: getfield 48	com/tencent/mm/plugin/scanner/util/h:qCG	Z
    //   1243: ifeq +65 -> 1308
    //   1246: aload_0
    //   1247: aload_3
    //   1248: invokevirtual 348	com/tencent/mm/plugin/licence/model/BankCardInfo:getCardNum	()Ljava/lang/String;
    //   1251: putfield 352	com/tencent/mm/plugin/scanner/util/h:qCa	Ljava/lang/String;
    //   1254: aload_0
    //   1255: iconst_1
    //   1256: putfield 87	com/tencent/mm/plugin/scanner/util/h:qCI	Z
    //   1259: ldc 50
    //   1261: new 139	java/lang/StringBuilder
    //   1264: dup
    //   1265: ldc_w 354
    //   1268: invokespecial 144	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1271: invokestatic 83	java/lang/System:currentTimeMillis	()J
    //   1274: lload 12
    //   1276: lsub
    //   1277: invokevirtual 148	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1280: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1283: invokestatic 92	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1286: aload 19
    //   1288: monitorexit
    //   1289: ldc 77
    //   1291: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1294: iconst_1
    //   1295: ireturn
    //   1296: iconst_0
    //   1297: istore 5
    //   1299: goto -181 -> 1118
    //   1302: iconst_0
    //   1303: istore 6
    //   1305: goto -139 -> 1166
    //   1308: aload_0
    //   1309: aload_3
    //   1310: invokevirtual 348	com/tencent/mm/plugin/licence/model/BankCardInfo:getCardNum	()Ljava/lang/String;
    //   1313: aload_3
    //   1314: invokevirtual 331	com/tencent/mm/plugin/licence/model/BankCardInfo:getCardNumLen	()I
    //   1317: aload_1
    //   1318: invokestatic 358	com/tencent/mm/plugin/licence/model/LibCardRecog:recognizeBankCardSegmentNumber	(Ljava/lang/String;I[I)Ljava/lang/String;
    //   1321: putfield 352	com/tencent/mm/plugin/scanner/util/h:qCa	Ljava/lang/String;
    //   1324: goto -70 -> 1254
    //   1327: astore_1
    //   1328: aload_3
    //   1329: astore_2
    //   1330: goto -382 -> 948
    //   1333: astore 18
    //   1335: goto -482 -> 853
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1338	0	this	h
    //   0	1338	1	paramArrayOfByte	byte[]
    //   0	1338	2	paramPoint	android.graphics.Point
    //   0	1338	3	paramRect	android.graphics.Rect
    //   93	50	4	f	float
    //   115	1183	5	i	int
    //   130	1174	6	j	int
    //   192	1034	7	k	int
    //   380	848	8	m	int
    //   453	747	9	n	int
    //   459	50	10	i1	int
    //   465	95	11	i2	int
    //   17	1258	12	l1	long
    //   177	498	14	l2	long
    //   342	457	16	i3	int
    //   581	318	17	localFileOutputStream	java.io.FileOutputStream
    //   526	63	18	arrayOfByte	byte[]
    //   848	34	18	localIOException1	java.io.IOException
    //   1333	1	18	localIOException2	java.io.IOException
    //   9	1278	19	localObject	Object
    //   497	460	20	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   601	606	803	java/io/IOException
    //   14	56	820	finally
    //   63	220	820	finally
    //   225	243	820	finally
    //   250	255	820	finally
    //   255	341	820	finally
    //   344	350	820	finally
    //   350	426	820	finally
    //   430	528	820	finally
    //   601	606	820	finally
    //   606	611	820	finally
    //   611	749	820	finally
    //   749	765	820	finally
    //   771	790	820	finally
    //   804	817	820	finally
    //   821	824	820	finally
    //   832	845	820	finally
    //   898	903	820	finally
    //   903	908	820	finally
    //   912	925	820	finally
    //   929	942	820	finally
    //   952	956	820	finally
    //   956	961	820	finally
    //   961	968	820	finally
    //   969	982	820	finally
    //   986	999	820	finally
    //   1002	1049	820	finally
    //   1056	1088	820	finally
    //   1133	1161	820	finally
    //   1170	1191	820	finally
    //   1195	1216	820	finally
    //   1216	1254	820	finally
    //   1254	1289	820	finally
    //   1308	1324	820	finally
    //   606	611	831	java/io/IOException
    //   530	583	848	java/io/IOException
    //   903	908	911	java/io/IOException
    //   898	903	928	java/io/IOException
    //   530	583	945	finally
    //   952	956	968	java/io/IOException
    //   956	961	985	java/io/IOException
    //   586	593	1327	finally
    //   596	601	1327	finally
    //   856	876	1327	finally
    //   879	893	1327	finally
    //   586	593	1333	java/io/IOException
    //   596	601	1333	java/io/IOException
  }
  
  public final Bitmap cju()
  {
    synchronized (this.qCM)
    {
      Bitmap localBitmap = this.qCL;
      return localBitmap;
    }
  }
  
  public final void pJ()
  {
    AppMethodBeat.i(81418);
    synchronized (this.qCM)
    {
      if (true == this.qCJ)
      {
        QbarNative.focusedEngineRelease();
        this.qCJ = false;
      }
      if (true == this.qCK)
      {
        LibCardRecog.recognizeBankCardRelease();
        this.qCK = false;
      }
      this.qCL = null;
      AppMethodBeat.o(81418);
      return;
    }
  }
  
  public final void restartDecoder()
  {
    AppMethodBeat.i(81419);
    pJ();
    AppMethodBeat.o(81419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.h
 * JD-Core Version:    0.7.0.1
 */