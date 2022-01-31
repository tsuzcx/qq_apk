package com.tencent.mm.plugin.scanner.util;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.licence.model.LibCardRecog;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.qbar.QbarNative;

public final class g
  extends b
{
  private int mCount = 0;
  private boolean nON = false;
  public boolean nOO;
  private boolean nOP;
  public boolean[] nOQ = new boolean[4];
  private boolean nOR;
  private boolean nOS;
  private boolean nOT;
  private Bitmap nOU;
  private final Object nOV = new Object();
  
  public g(b.a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(parama);
    this.nOO = paramBoolean1;
    this.nOP = paramBoolean2;
    y.d("MicroMsg.ScanBankCardDecoder", "isPortrait:%s, needRotate:%s", new Object[] { Boolean.valueOf(false), Boolean.valueOf(paramBoolean1) });
  }
  
  /* Error */
  public final boolean a(byte[] paramArrayOfByte, android.graphics.Point paramPoint, android.graphics.Rect paramRect)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 33	com/tencent/mm/plugin/scanner/util/g:nOV	Ljava/lang/Object;
    //   4: astore 19
    //   6: aload 19
    //   8: monitorenter
    //   9: invokestatic 68	java/lang/System:currentTimeMillis	()J
    //   12: lstore 12
    //   14: ldc 43
    //   16: ldc 70
    //   18: iconst_2
    //   19: anewarray 28	java/lang/Object
    //   22: dup
    //   23: iconst_0
    //   24: aload_2
    //   25: aastore
    //   26: dup
    //   27: iconst_1
    //   28: aload_3
    //   29: aastore
    //   30: invokestatic 57	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   33: iconst_1
    //   34: aload_0
    //   35: getfield 72	com/tencent/mm/plugin/scanner/util/g:nOR	Z
    //   38: if_icmpne +15 -> 53
    //   41: ldc 43
    //   43: ldc 74
    //   45: invokestatic 77	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   48: aload 19
    //   50: monitorexit
    //   51: iconst_0
    //   52: ireturn
    //   53: aload_2
    //   54: getfield 82	android/graphics/Point:x	I
    //   57: i2f
    //   58: aload_3
    //   59: invokevirtual 88	android/graphics/Rect:width	()I
    //   62: i2f
    //   63: fdiv
    //   64: aload_2
    //   65: getfield 91	android/graphics/Point:y	I
    //   68: i2f
    //   69: aload_3
    //   70: invokevirtual 94	android/graphics/Rect:height	()I
    //   73: i2f
    //   74: fdiv
    //   75: invokestatic 100	java/lang/Math:min	(FF)F
    //   78: ldc 101
    //   80: invokestatic 100	java/lang/Math:min	(FF)F
    //   83: fstore 4
    //   85: aload_3
    //   86: invokevirtual 88	android/graphics/Rect:width	()I
    //   89: i2f
    //   90: fconst_1
    //   91: fload 4
    //   93: fconst_1
    //   94: fsub
    //   95: ldc 102
    //   97: fmul
    //   98: fadd
    //   99: fmul
    //   100: f2i
    //   101: iconst_4
    //   102: idiv
    //   103: iconst_4
    //   104: imul
    //   105: istore 5
    //   107: aload_3
    //   108: invokevirtual 94	android/graphics/Rect:height	()I
    //   111: i2f
    //   112: fload 4
    //   114: fmul
    //   115: f2i
    //   116: iconst_4
    //   117: idiv
    //   118: iconst_4
    //   119: imul
    //   120: istore 6
    //   122: ldc 43
    //   124: ldc 104
    //   126: iconst_3
    //   127: anewarray 28	java/lang/Object
    //   130: dup
    //   131: iconst_0
    //   132: fload 4
    //   134: invokestatic 109	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   137: aastore
    //   138: dup
    //   139: iconst_1
    //   140: iload 5
    //   142: invokestatic 114	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   145: aastore
    //   146: dup
    //   147: iconst_2
    //   148: iload 6
    //   150: invokestatic 114	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   153: aastore
    //   154: invokestatic 57	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   157: aload_0
    //   158: getfield 116	com/tencent/mm/plugin/scanner/util/g:nOS	Z
    //   161: ifne +92 -> 253
    //   164: invokestatic 68	java/lang/System:currentTimeMillis	()J
    //   167: lstore 14
    //   169: iload 5
    //   171: iload 6
    //   173: bipush 8
    //   175: aload_0
    //   176: getfield 37	com/tencent/mm/plugin/scanner/util/g:nON	Z
    //   179: invokestatic 122	com/tencent/qbar/QbarNative:focusedEngineForBankcardInit	(IIIZ)I
    //   182: istore 7
    //   184: ldc 43
    //   186: new 124	java/lang/StringBuilder
    //   189: dup
    //   190: ldc 126
    //   192: invokespecial 129	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   195: invokestatic 68	java/lang/System:currentTimeMillis	()J
    //   198: lload 14
    //   200: lsub
    //   201: invokevirtual 133	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   204: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokestatic 77	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   210: iload 7
    //   212: ifeq +36 -> 248
    //   215: ldc 43
    //   217: new 124	java/lang/StringBuilder
    //   220: dup
    //   221: ldc 139
    //   223: invokespecial 129	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   226: iload 7
    //   228: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   231: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: invokestatic 145	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   237: aload 19
    //   239: monitorexit
    //   240: iconst_0
    //   241: ireturn
    //   242: astore_1
    //   243: aload 19
    //   245: monitorexit
    //   246: aload_1
    //   247: athrow
    //   248: aload_0
    //   249: iconst_1
    //   250: putfield 116	com/tencent/mm/plugin/scanner/util/g:nOS	Z
    //   253: aload_0
    //   254: getfield 147	com/tencent/mm/plugin/scanner/util/g:nOT	Z
    //   257: ifne +91 -> 348
    //   260: iconst_1
    //   261: aload_0
    //   262: getfield 116	com/tencent/mm/plugin/scanner/util/g:nOS	Z
    //   265: if_icmpne +83 -> 348
    //   268: ldc 43
    //   270: ldc 149
    //   272: iconst_5
    //   273: anewarray 28	java/lang/Object
    //   276: dup
    //   277: iconst_0
    //   278: iload 5
    //   280: invokestatic 114	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   283: aastore
    //   284: dup
    //   285: iconst_1
    //   286: iload 6
    //   288: invokestatic 114	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   291: aastore
    //   292: dup
    //   293: iconst_2
    //   294: aload_3
    //   295: invokevirtual 88	android/graphics/Rect:width	()I
    //   298: invokestatic 114	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   301: aastore
    //   302: dup
    //   303: iconst_3
    //   304: aload_3
    //   305: invokevirtual 94	android/graphics/Rect:height	()I
    //   308: invokestatic 114	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   311: aastore
    //   312: dup
    //   313: iconst_4
    //   314: aload_0
    //   315: getfield 37	com/tencent/mm/plugin/scanner/util/g:nON	Z
    //   318: invokestatic 51	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   321: aastore
    //   322: invokestatic 57	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   325: iload 5
    //   327: iload 6
    //   329: aload_0
    //   330: getfield 37	com/tencent/mm/plugin/scanner/util/g:nON	Z
    //   333: invokestatic 155	com/tencent/mm/plugin/licence/model/LibCardRecog:recognizeBankCardInit	(IIZ)I
    //   336: ifne +965 -> 1301
    //   339: iconst_1
    //   340: istore 16
    //   342: aload_0
    //   343: iload 16
    //   345: putfield 147	com/tencent/mm/plugin/scanner/util/g:nOT	Z
    //   348: aload_3
    //   349: getfield 158	android/graphics/Rect:left	I
    //   352: iload 5
    //   354: aload_3
    //   355: invokevirtual 88	android/graphics/Rect:width	()I
    //   358: isub
    //   359: iconst_2
    //   360: idiv
    //   361: isub
    //   362: istore 7
    //   364: aload_3
    //   365: getfield 161	android/graphics/Rect:top	I
    //   368: iload 6
    //   370: aload_3
    //   371: invokevirtual 94	android/graphics/Rect:height	()I
    //   374: isub
    //   375: iconst_2
    //   376: idiv
    //   377: isub
    //   378: istore 8
    //   380: ldc 43
    //   382: ldc 163
    //   384: iconst_3
    //   385: anewarray 28	java/lang/Object
    //   388: dup
    //   389: iconst_0
    //   390: iload 7
    //   392: invokestatic 114	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   395: aastore
    //   396: dup
    //   397: iconst_1
    //   398: iload 8
    //   400: invokestatic 114	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   403: aastore
    //   404: dup
    //   405: iconst_2
    //   406: aload_1
    //   407: arraylength
    //   408: invokestatic 114	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   411: aastore
    //   412: invokestatic 57	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   415: invokestatic 169	com/tencent/mm/m/g:AA	()Lcom/tencent/mm/m/e;
    //   418: ldc 171
    //   420: invokevirtual 177	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   423: astore_3
    //   424: aload_3
    //   425: ifnull +184 -> 609
    //   428: aload_3
    //   429: ldc 179
    //   431: invokevirtual 185	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   434: ifeq +175 -> 609
    //   437: aload_0
    //   438: aload_0
    //   439: getfield 26	com/tencent/mm/plugin/scanner/util/g:mCount	I
    //   442: iconst_1
    //   443: iadd
    //   444: putfield 26	com/tencent/mm/plugin/scanner/util/g:mCount	I
    //   447: aload_2
    //   448: getfield 82	android/graphics/Point:x	I
    //   451: istore 9
    //   453: aload_2
    //   454: getfield 91	android/graphics/Point:y	I
    //   457: istore 10
    //   459: aload_0
    //   460: getfield 26	com/tencent/mm/plugin/scanner/util/g:mCount	I
    //   463: istore 11
    //   465: new 187	android/graphics/YuvImage
    //   468: dup
    //   469: aload_1
    //   470: bipush 17
    //   472: iload 9
    //   474: iload 10
    //   476: aconst_null
    //   477: invokespecial 190	android/graphics/YuvImage:<init>	([BIII[I)V
    //   480: astore_3
    //   481: ldc 43
    //   483: ldc 192
    //   485: invokestatic 77	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   488: new 194	java/io/ByteArrayOutputStream
    //   491: dup
    //   492: invokespecial 195	java/io/ByteArrayOutputStream:<init>	()V
    //   495: astore 20
    //   497: aload_3
    //   498: new 84	android/graphics/Rect
    //   501: dup
    //   502: iconst_0
    //   503: iconst_0
    //   504: iload 9
    //   506: iload 10
    //   508: invokespecial 198	android/graphics/Rect:<init>	(IIII)V
    //   511: bipush 100
    //   513: aload 20
    //   515: invokevirtual 202	android/graphics/YuvImage:compressToJpeg	(Landroid/graphics/Rect;ILjava/io/OutputStream;)Z
    //   518: pop
    //   519: aload 20
    //   521: invokevirtual 206	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   524: astore 18
    //   526: aconst_null
    //   527: astore_3
    //   528: new 208	java/io/FileOutputStream
    //   531: dup
    //   532: new 210	java/io/File
    //   535: dup
    //   536: new 124	java/lang/StringBuilder
    //   539: dup
    //   540: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   543: invokestatic 217	com/tencent/mm/compatible/util/h:getExternalStorageDirectory	()Ljava/io/File;
    //   546: invokevirtual 220	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   549: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: ldc 225
    //   554: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: iload 11
    //   559: invokestatic 228	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   562: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: ldc 230
    //   567: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   573: invokespecial 231	java/io/File:<init>	(Ljava/lang/String;)V
    //   576: invokespecial 234	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   579: astore 17
    //   581: aload 17
    //   583: astore_3
    //   584: aload 17
    //   586: aload 18
    //   588: invokevirtual 238	java/io/FileOutputStream:write	([B)V
    //   591: aload 17
    //   593: astore_3
    //   594: aload 17
    //   596: invokevirtual 241	java/io/FileOutputStream:flush	()V
    //   599: aload 17
    //   601: invokevirtual 244	java/io/FileOutputStream:close	()V
    //   604: aload 20
    //   606: invokevirtual 245	java/io/ByteArrayOutputStream:close	()V
    //   609: invokestatic 68	java/lang/System:currentTimeMillis	()J
    //   612: lstore 14
    //   614: new 247	com/tencent/mm/plugin/licence/model/BankCardInfo
    //   617: dup
    //   618: aload_2
    //   619: getfield 82	android/graphics/Point:x	I
    //   622: aload_2
    //   623: getfield 91	android/graphics/Point:y	I
    //   626: invokespecial 250	com/tencent/mm/plugin/licence/model/BankCardInfo:<init>	(II)V
    //   629: astore_3
    //   630: aload_1
    //   631: aload_2
    //   632: getfield 91	android/graphics/Point:y	I
    //   635: aload_2
    //   636: getfield 82	android/graphics/Point:x	I
    //   639: iload 7
    //   641: iload 8
    //   643: iload 6
    //   645: iload 5
    //   647: aload_3
    //   648: aload_0
    //   649: getfield 35	com/tencent/mm/plugin/scanner/util/g:nOQ	[Z
    //   652: invokestatic 254	com/tencent/mm/plugin/licence/model/LibCardRecog:recognizeBankCardProcess	([BIIIIIILcom/tencent/mm/plugin/licence/model/BankCardInfo;[Z)I
    //   655: istore 5
    //   657: ldc 43
    //   659: new 124	java/lang/StringBuilder
    //   662: dup
    //   663: ldc_w 256
    //   666: invokespecial 129	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   669: invokestatic 68	java/lang/System:currentTimeMillis	()J
    //   672: lload 14
    //   674: lsub
    //   675: invokevirtual 133	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   678: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   681: invokestatic 77	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   684: aload_0
    //   685: getfield 39	com/tencent/mm/plugin/scanner/util/g:nOO	Z
    //   688: ifne +59 -> 747
    //   691: aload_0
    //   692: getfield 35	com/tencent/mm/plugin/scanner/util/g:nOQ	[Z
    //   695: iconst_0
    //   696: baload
    //   697: istore 16
    //   699: aload_0
    //   700: getfield 35	com/tencent/mm/plugin/scanner/util/g:nOQ	[Z
    //   703: iconst_0
    //   704: aload_0
    //   705: getfield 35	com/tencent/mm/plugin/scanner/util/g:nOQ	[Z
    //   708: iconst_2
    //   709: baload
    //   710: bastore
    //   711: aload_0
    //   712: getfield 35	com/tencent/mm/plugin/scanner/util/g:nOQ	[Z
    //   715: iconst_2
    //   716: iload 16
    //   718: bastore
    //   719: aload_0
    //   720: getfield 35	com/tencent/mm/plugin/scanner/util/g:nOQ	[Z
    //   723: iconst_1
    //   724: baload
    //   725: istore 16
    //   727: aload_0
    //   728: getfield 35	com/tencent/mm/plugin/scanner/util/g:nOQ	[Z
    //   731: iconst_1
    //   732: aload_0
    //   733: getfield 35	com/tencent/mm/plugin/scanner/util/g:nOQ	[Z
    //   736: iconst_3
    //   737: baload
    //   738: bastore
    //   739: aload_0
    //   740: getfield 35	com/tencent/mm/plugin/scanner/util/g:nOQ	[Z
    //   743: iconst_3
    //   744: iload 16
    //   746: bastore
    //   747: ldc 43
    //   749: new 124	java/lang/StringBuilder
    //   752: dup
    //   753: ldc_w 258
    //   756: invokespecial 129	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   759: iload 5
    //   761: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   764: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   767: invokestatic 77	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   770: iload 5
    //   772: iconst_1
    //   773: if_icmpeq +214 -> 987
    //   776: ldc 43
    //   778: new 124	java/lang/StringBuilder
    //   781: dup
    //   782: ldc_w 260
    //   785: invokespecial 129	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   788: iload 5
    //   790: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   793: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   796: invokestatic 77	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   799: aload 19
    //   801: monitorexit
    //   802: iconst_0
    //   803: ireturn
    //   804: astore_3
    //   805: ldc 43
    //   807: aload_3
    //   808: ldc_w 262
    //   811: iconst_0
    //   812: anewarray 28	java/lang/Object
    //   815: invokestatic 266	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   818: goto -214 -> 604
    //   821: astore_3
    //   822: ldc 43
    //   824: aload_3
    //   825: ldc_w 262
    //   828: iconst_0
    //   829: anewarray 28	java/lang/Object
    //   832: invokestatic 266	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   835: goto -226 -> 609
    //   838: astore 18
    //   840: aconst_null
    //   841: astore 17
    //   843: aload 17
    //   845: astore_3
    //   846: ldc 43
    //   848: ldc_w 268
    //   851: iconst_1
    //   852: anewarray 28	java/lang/Object
    //   855: dup
    //   856: iconst_0
    //   857: aload 18
    //   859: invokevirtual 271	java/io/IOException:getMessage	()Ljava/lang/String;
    //   862: aastore
    //   863: invokestatic 273	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   866: aload 17
    //   868: astore_3
    //   869: ldc 43
    //   871: aload 18
    //   873: ldc_w 262
    //   876: iconst_0
    //   877: anewarray 28	java/lang/Object
    //   880: invokestatic 266	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   883: aload 17
    //   885: ifnull +8 -> 893
    //   888: aload 17
    //   890: invokevirtual 244	java/io/FileOutputStream:close	()V
    //   893: aload 20
    //   895: invokevirtual 245	java/io/ByteArrayOutputStream:close	()V
    //   898: goto -289 -> 609
    //   901: astore_3
    //   902: ldc 43
    //   904: aload_3
    //   905: ldc_w 262
    //   908: iconst_0
    //   909: anewarray 28	java/lang/Object
    //   912: invokestatic 266	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   915: goto -306 -> 609
    //   918: astore_3
    //   919: ldc 43
    //   921: aload_3
    //   922: ldc_w 262
    //   925: iconst_0
    //   926: anewarray 28	java/lang/Object
    //   929: invokestatic 266	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   932: goto -39 -> 893
    //   935: astore_1
    //   936: aload_3
    //   937: astore_2
    //   938: aload_2
    //   939: ifnull +7 -> 946
    //   942: aload_2
    //   943: invokevirtual 244	java/io/FileOutputStream:close	()V
    //   946: aload 20
    //   948: invokevirtual 245	java/io/ByteArrayOutputStream:close	()V
    //   951: aload_1
    //   952: athrow
    //   953: astore_2
    //   954: ldc 43
    //   956: aload_2
    //   957: ldc_w 262
    //   960: iconst_0
    //   961: anewarray 28	java/lang/Object
    //   964: invokestatic 266	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   967: goto -21 -> 946
    //   970: astore_2
    //   971: ldc 43
    //   973: aload_2
    //   974: ldc_w 262
    //   977: iconst_0
    //   978: anewarray 28	java/lang/Object
    //   981: invokestatic 266	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   984: goto -33 -> 951
    //   987: new 275	android/graphics/BitmapFactory$Options
    //   990: dup
    //   991: invokespecial 276	android/graphics/BitmapFactory$Options:<init>	()V
    //   994: astore_1
    //   995: aload_1
    //   996: iconst_1
    //   997: putfield 279	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1000: aload_0
    //   1001: aload_3
    //   1002: getfield 283	com/tencent/mm/plugin/licence/model/BankCardInfo:bitmapData	[B
    //   1005: iconst_0
    //   1006: aload_3
    //   1007: getfield 286	com/tencent/mm/plugin/licence/model/BankCardInfo:bitmapLen	I
    //   1010: aload_1
    //   1011: invokestatic 292	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1014: getstatic 298	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   1017: iconst_1
    //   1018: invokevirtual 304	android/graphics/Bitmap:copy	(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;
    //   1021: putfield 306	com/tencent/mm/plugin/scanner/util/g:nOU	Landroid/graphics/Bitmap;
    //   1024: aload_0
    //   1025: getfield 306	com/tencent/mm/plugin/scanner/util/g:nOU	Landroid/graphics/Bitmap;
    //   1028: ifnonnull +8 -> 1036
    //   1031: aload 19
    //   1033: monitorexit
    //   1034: iconst_0
    //   1035: ireturn
    //   1036: aload_3
    //   1037: invokevirtual 310	com/tencent/mm/plugin/licence/model/BankCardInfo:getRectX	()[I
    //   1040: astore_1
    //   1041: aload_3
    //   1042: invokevirtual 313	com/tencent/mm/plugin/licence/model/BankCardInfo:getRectY	()[I
    //   1045: astore_2
    //   1046: aload_1
    //   1047: aload_3
    //   1048: invokevirtual 316	com/tencent/mm/plugin/licence/model/BankCardInfo:getCardNumLen	()I
    //   1051: iconst_1
    //   1052: isub
    //   1053: iaload
    //   1054: aload_1
    //   1055: iconst_0
    //   1056: iaload
    //   1057: isub
    //   1058: aload_1
    //   1059: iconst_1
    //   1060: iaload
    //   1061: aload_1
    //   1062: iconst_0
    //   1063: iaload
    //   1064: isub
    //   1065: iadd
    //   1066: istore 6
    //   1068: iload 6
    //   1070: i2f
    //   1071: ldc_w 317
    //   1074: fmul
    //   1075: f2i
    //   1076: istore 9
    //   1078: aload_1
    //   1079: iconst_0
    //   1080: iaload
    //   1081: i2f
    //   1082: iload 6
    //   1084: i2f
    //   1085: ldc_w 318
    //   1088: fmul
    //   1089: fsub
    //   1090: f2i
    //   1091: istore 5
    //   1093: iload 5
    //   1095: ifle +212 -> 1307
    //   1098: iload 6
    //   1100: iconst_2
    //   1101: imul
    //   1102: i2f
    //   1103: ldc_w 318
    //   1106: fmul
    //   1107: f2i
    //   1108: iload 6
    //   1110: iadd
    //   1111: istore 8
    //   1113: aload_2
    //   1114: iconst_0
    //   1115: iaload
    //   1116: i2f
    //   1117: aload_1
    //   1118: iconst_1
    //   1119: iaload
    //   1120: aload_1
    //   1121: iconst_0
    //   1122: iaload
    //   1123: isub
    //   1124: i2f
    //   1125: ldc_w 319
    //   1128: fmul
    //   1129: fconst_2
    //   1130: fdiv
    //   1131: fadd
    //   1132: iload 9
    //   1134: iconst_2
    //   1135: idiv
    //   1136: i2f
    //   1137: fsub
    //   1138: f2i
    //   1139: istore 6
    //   1141: iload 6
    //   1143: ifle +170 -> 1313
    //   1146: iload 8
    //   1148: istore 7
    //   1150: iload 5
    //   1152: iload 8
    //   1154: iadd
    //   1155: aload_3
    //   1156: getfield 321	com/tencent/mm/plugin/licence/model/BankCardInfo:width	I
    //   1159: if_icmple +12 -> 1171
    //   1162: aload_3
    //   1163: getfield 321	com/tencent/mm/plugin/licence/model/BankCardInfo:width	I
    //   1166: iload 5
    //   1168: isub
    //   1169: istore 7
    //   1171: iload 9
    //   1173: istore 8
    //   1175: iload 6
    //   1177: iload 9
    //   1179: iadd
    //   1180: aload_3
    //   1181: getfield 323	com/tencent/mm/plugin/licence/model/BankCardInfo:height	I
    //   1184: if_icmple +12 -> 1196
    //   1187: aload_3
    //   1188: getfield 323	com/tencent/mm/plugin/licence/model/BankCardInfo:height	I
    //   1191: iload 6
    //   1193: isub
    //   1194: istore 8
    //   1196: aload_0
    //   1197: aload_0
    //   1198: getfield 306	com/tencent/mm/plugin/scanner/util/g:nOU	Landroid/graphics/Bitmap;
    //   1201: iload 5
    //   1203: iload 6
    //   1205: iload 7
    //   1207: iload 8
    //   1209: invokestatic 327	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   1212: putfield 306	com/tencent/mm/plugin/scanner/util/g:nOU	Landroid/graphics/Bitmap;
    //   1215: iconst_3
    //   1216: putstatic 330	com/tencent/mm/plugin/scanner/util/g:nOq	I
    //   1219: aload_0
    //   1220: getfield 41	com/tencent/mm/plugin/scanner/util/g:nOP	Z
    //   1223: ifeq +48 -> 1271
    //   1226: aload_0
    //   1227: aload_3
    //   1228: invokevirtual 333	com/tencent/mm/plugin/licence/model/BankCardInfo:getCardNum	()Ljava/lang/String;
    //   1231: putfield 337	com/tencent/mm/plugin/scanner/util/g:nOp	Ljava/lang/String;
    //   1234: aload_0
    //   1235: iconst_1
    //   1236: putfield 72	com/tencent/mm/plugin/scanner/util/g:nOR	Z
    //   1239: ldc 43
    //   1241: new 124	java/lang/StringBuilder
    //   1244: dup
    //   1245: ldc_w 339
    //   1248: invokespecial 129	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1251: invokestatic 68	java/lang/System:currentTimeMillis	()J
    //   1254: lload 12
    //   1256: lsub
    //   1257: invokevirtual 133	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1260: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1263: invokestatic 77	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1266: aload 19
    //   1268: monitorexit
    //   1269: iconst_1
    //   1270: ireturn
    //   1271: aload_0
    //   1272: aload_3
    //   1273: invokevirtual 333	com/tencent/mm/plugin/licence/model/BankCardInfo:getCardNum	()Ljava/lang/String;
    //   1276: aload_3
    //   1277: invokevirtual 316	com/tencent/mm/plugin/licence/model/BankCardInfo:getCardNumLen	()I
    //   1280: aload_1
    //   1281: invokestatic 343	com/tencent/mm/plugin/licence/model/LibCardRecog:recognizeBankCardSegmentNumber	(Ljava/lang/String;I[I)Ljava/lang/String;
    //   1284: putfield 337	com/tencent/mm/plugin/scanner/util/g:nOp	Ljava/lang/String;
    //   1287: goto -53 -> 1234
    //   1290: astore_1
    //   1291: aload_3
    //   1292: astore_2
    //   1293: goto -355 -> 938
    //   1296: astore 18
    //   1298: goto -455 -> 843
    //   1301: iconst_0
    //   1302: istore 16
    //   1304: goto -962 -> 342
    //   1307: iconst_0
    //   1308: istore 5
    //   1310: goto -212 -> 1098
    //   1313: iconst_0
    //   1314: istore 6
    //   1316: goto -170 -> 1146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1319	0	this	g
    //   0	1319	1	paramArrayOfByte	byte[]
    //   0	1319	2	paramPoint	android.graphics.Point
    //   0	1319	3	paramRect	android.graphics.Rect
    //   83	50	4	f	float
    //   105	1204	5	i	int
    //   120	1195	6	j	int
    //   182	1024	7	k	int
    //   378	830	8	m	int
    //   451	729	9	n	int
    //   457	50	10	i1	int
    //   463	95	11	i2	int
    //   12	1243	12	l1	long
    //   167	506	14	l2	long
    //   340	963	16	i3	int
    //   579	310	17	localFileOutputStream	java.io.FileOutputStream
    //   524	63	18	arrayOfByte	byte[]
    //   838	34	18	localIOException1	java.io.IOException
    //   1296	1	18	localIOException2	java.io.IOException
    //   4	1263	19	localObject	Object
    //   495	452	20	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   9	51	242	finally
    //   53	210	242	finally
    //   215	240	242	finally
    //   243	246	242	finally
    //   248	253	242	finally
    //   253	339	242	finally
    //   342	348	242	finally
    //   348	424	242	finally
    //   428	526	242	finally
    //   599	604	242	finally
    //   604	609	242	finally
    //   609	747	242	finally
    //   747	770	242	finally
    //   776	802	242	finally
    //   805	818	242	finally
    //   822	835	242	finally
    //   888	893	242	finally
    //   893	898	242	finally
    //   902	915	242	finally
    //   919	932	242	finally
    //   942	946	242	finally
    //   946	951	242	finally
    //   951	953	242	finally
    //   954	967	242	finally
    //   971	984	242	finally
    //   987	1034	242	finally
    //   1036	1068	242	finally
    //   1113	1141	242	finally
    //   1150	1171	242	finally
    //   1175	1196	242	finally
    //   1196	1234	242	finally
    //   1234	1269	242	finally
    //   1271	1287	242	finally
    //   599	604	804	java/io/IOException
    //   604	609	821	java/io/IOException
    //   528	581	838	java/io/IOException
    //   893	898	901	java/io/IOException
    //   888	893	918	java/io/IOException
    //   528	581	935	finally
    //   942	946	953	java/io/IOException
    //   946	951	970	java/io/IOException
    //   584	591	1290	finally
    //   594	599	1290	finally
    //   846	866	1290	finally
    //   869	883	1290	finally
    //   584	591	1296	java/io/IOException
    //   594	599	1296	java/io/IOException
  }
  
  public final void byg()
  {
    nm();
  }
  
  public final Bitmap byo()
  {
    synchronized (this.nOV)
    {
      Bitmap localBitmap = this.nOU;
      return localBitmap;
    }
  }
  
  public final void nm()
  {
    synchronized (this.nOV)
    {
      if (true == this.nOS)
      {
        QbarNative.focusedEngineRelease();
        this.nOS = false;
      }
      if (true == this.nOT)
      {
        LibCardRecog.recognizeBankCardRelease();
        this.nOT = false;
      }
      this.nOU = null;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.g
 * JD-Core Version:    0.7.0.1
 */