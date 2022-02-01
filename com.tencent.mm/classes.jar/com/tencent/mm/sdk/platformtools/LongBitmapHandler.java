package com.tencent.mm.sdk.platformtools;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.vfs.y;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class LongBitmapHandler
{
  private static final long IDKEY_LONG_BITMAP = 853L;
  public static final double SCALE_THRESHOLD = 2.0D;
  private static final String TAG = "MicroMsg.LongBitmapHandler";
  private static final double THRES_CROP_SCALE = 2.5D;
  public static final int THUMB_MAX_LIMIT_SIZE_IN_DP = 144;
  public static final int THUMB_MIN_LIMITE_SIZE_IN_DP = 56;
  public static final int TYPE_HW = 2;
  public static final int TYPE_WH = 1;
  
  public static Bitmap createLongPictureBitmap(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(243895);
    paramString = createLongPictureBitmap(paramString, paramInt1, 56, 144, 2.5D, paramInt2);
    AppMethodBeat.o(243895);
    return paramString;
  }
  
  /* Error */
  public static Bitmap createLongPictureBitmap(String paramString, int paramInt1, int paramInt2, int paramInt3, double paramDouble, int paramInt4)
  {
    // Byte code:
    //   0: ldc 53
    //   2: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 16
    //   7: ldc 55
    //   9: iconst_5
    //   10: anewarray 4	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: aload_0
    //   16: aastore
    //   17: dup
    //   18: iconst_1
    //   19: iload_2
    //   20: invokestatic 61	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   23: aastore
    //   24: dup
    //   25: iconst_2
    //   26: iload_3
    //   27: invokestatic 61	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   30: aastore
    //   31: dup
    //   32: iconst_3
    //   33: iload_1
    //   34: invokestatic 61	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   37: aastore
    //   38: dup
    //   39: iconst_4
    //   40: iload 6
    //   42: invokestatic 61	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   45: aastore
    //   46: invokestatic 66	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   49: getstatic 72	com/tencent/mm/compatible/d/a:lQN	Lcom/tencent/mm/compatible/d/a;
    //   52: astore 16
    //   54: lconst_0
    //   55: invokestatic 76	com/tencent/mm/compatible/d/a:ho	(J)V
    //   58: aload_0
    //   59: invokestatic 82	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   62: ifne +26 -> 88
    //   65: iload_2
    //   66: iflt +22 -> 88
    //   69: iload_3
    //   70: iflt +18 -> 88
    //   73: iload_1
    //   74: iconst_2
    //   75: if_icmpeq +8 -> 83
    //   78: iload_1
    //   79: iconst_1
    //   80: if_icmpne +8 -> 88
    //   83: iload_2
    //   84: iload_3
    //   85: if_icmple +25 -> 110
    //   88: ldc 16
    //   90: ldc 84
    //   92: invokestatic 88	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   95: getstatic 72	com/tencent/mm/compatible/d/a:lQN	Lcom/tencent/mm/compatible/d/a;
    //   98: astore_0
    //   99: lconst_1
    //   100: invokestatic 76	com/tencent/mm/compatible/d/a:ho	(J)V
    //   103: ldc 53
    //   105: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   108: aconst_null
    //   109: areturn
    //   110: iload_2
    //   111: i2d
    //   112: dload 4
    //   114: dmul
    //   115: iload_3
    //   116: i2d
    //   117: dcmpl
    //   118: iflt +39 -> 157
    //   121: ldc 16
    //   123: ldc 90
    //   125: iconst_1
    //   126: anewarray 4	java/lang/Object
    //   129: dup
    //   130: iconst_0
    //   131: dload 4
    //   133: invokestatic 95	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   136: aastore
    //   137: invokestatic 97	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   140: getstatic 72	com/tencent/mm/compatible/d/a:lQN	Lcom/tencent/mm/compatible/d/a;
    //   143: astore_0
    //   144: ldc2_w 98
    //   147: invokestatic 76	com/tencent/mm/compatible/d/a:ho	(J)V
    //   150: ldc 53
    //   152: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   155: aconst_null
    //   156: areturn
    //   157: aload_0
    //   158: invokestatic 105	com/tencent/mm/sdk/platformtools/BitmapUtil:getPictureSize	(Ljava/lang/String;)Landroid/graphics/Point;
    //   161: astore 16
    //   163: aload 16
    //   165: ifnull +19 -> 184
    //   168: aload 16
    //   170: getfield 110	android/graphics/Point:x	I
    //   173: ifle +11 -> 184
    //   176: aload 16
    //   178: getfield 113	android/graphics/Point:y	I
    //   181: ifgt +27 -> 208
    //   184: ldc 16
    //   186: ldc 115
    //   188: invokestatic 88	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   191: getstatic 72	com/tencent/mm/compatible/d/a:lQN	Lcom/tencent/mm/compatible/d/a;
    //   194: astore_0
    //   195: ldc2_w 116
    //   198: invokestatic 76	com/tencent/mm/compatible/d/a:ho	(J)V
    //   201: ldc 53
    //   203: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   206: aconst_null
    //   207: areturn
    //   208: aload 16
    //   210: getfield 110	android/graphics/Point:x	I
    //   213: istore 8
    //   215: aload 16
    //   217: getfield 113	android/graphics/Point:y	I
    //   220: istore 9
    //   222: iload_1
    //   223: iconst_1
    //   224: if_icmpne +290 -> 514
    //   227: iload 8
    //   229: i2d
    //   230: iload 9
    //   232: i2d
    //   233: ddiv
    //   234: dload 4
    //   236: dcmpl
    //   237: ifle +271 -> 508
    //   240: iconst_1
    //   241: istore 15
    //   243: iload 15
    //   245: ifeq +349 -> 594
    //   248: iload_1
    //   249: iconst_1
    //   250: if_icmpne +289 -> 539
    //   253: iload 9
    //   255: i2d
    //   256: dload 4
    //   258: dmul
    //   259: d2i
    //   260: istore 10
    //   262: iload 8
    //   264: i2d
    //   265: iload 9
    //   267: i2d
    //   268: dload 4
    //   270: dmul
    //   271: dsub
    //   272: ldc2_w 11
    //   275: ddiv
    //   276: d2i
    //   277: istore 13
    //   279: iconst_0
    //   280: istore 11
    //   282: iload 9
    //   284: istore_1
    //   285: iload 9
    //   287: istore 8
    //   289: iload 10
    //   291: istore 9
    //   293: iload 10
    //   295: istore 12
    //   297: iload 13
    //   299: istore 10
    //   301: ldc 16
    //   303: ldc 119
    //   305: iconst_5
    //   306: anewarray 4	java/lang/Object
    //   309: dup
    //   310: iconst_0
    //   311: iload 15
    //   313: invokestatic 124	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   316: aastore
    //   317: dup
    //   318: iconst_1
    //   319: iload 12
    //   321: invokestatic 61	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   324: aastore
    //   325: dup
    //   326: iconst_2
    //   327: iload_1
    //   328: invokestatic 61	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   331: aastore
    //   332: dup
    //   333: iconst_3
    //   334: iload 10
    //   336: invokestatic 61	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   339: aastore
    //   340: dup
    //   341: iconst_4
    //   342: iload 11
    //   344: invokestatic 61	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   347: aastore
    //   348: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   351: iconst_1
    //   352: istore 13
    //   354: fconst_1
    //   355: fstore 7
    //   357: iload 9
    //   359: iload_3
    //   360: if_icmple +299 -> 659
    //   363: iload 8
    //   365: iload 9
    //   367: iload 8
    //   369: iload_3
    //   370: invokestatic 131	com/tencent/mm/sdk/platformtools/BitmapUtil:calculateInSampleSize	(IIII)I
    //   373: istore_2
    //   374: iload_3
    //   375: i2f
    //   376: iload 9
    //   378: iload_2
    //   379: idiv
    //   380: i2f
    //   381: fdiv
    //   382: fstore 7
    //   384: ldc 16
    //   386: ldc 133
    //   388: iconst_2
    //   389: anewarray 4	java/lang/Object
    //   392: dup
    //   393: iconst_0
    //   394: iload_2
    //   395: invokestatic 61	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   398: aastore
    //   399: dup
    //   400: iconst_1
    //   401: fload 7
    //   403: invokestatic 138	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   406: aastore
    //   407: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   410: new 140	android/graphics/BitmapFactory$Options
    //   413: dup
    //   414: invokespecial 141	android/graphics/BitmapFactory$Options:<init>	()V
    //   417: astore 16
    //   419: aload 16
    //   421: iload_2
    //   422: putfield 144	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   425: iload 15
    //   427: ifeq +334 -> 761
    //   430: aload_0
    //   431: invokestatic 150	com/tencent/mm/vfs/y:Lh	(Ljava/lang/String;)Ljava/io/InputStream;
    //   434: astore_0
    //   435: aload_0
    //   436: new 152	android/graphics/Rect
    //   439: dup
    //   440: iload 10
    //   442: iload 11
    //   444: iload 10
    //   446: iload 12
    //   448: iadd
    //   449: iload_1
    //   450: iload 11
    //   452: iadd
    //   453: invokespecial 155	android/graphics/Rect:<init>	(IIII)V
    //   456: aload 16
    //   458: invokestatic 161	com/tencent/mm/graphics/b:a	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   461: astore 17
    //   463: aload 17
    //   465: astore 16
    //   467: aload_0
    //   468: ifnull +11 -> 479
    //   471: aload_0
    //   472: invokevirtual 166	java/io/InputStream:close	()V
    //   475: aload 17
    //   477: astore 16
    //   479: aload 16
    //   481: ifnonnull +291 -> 772
    //   484: ldc 16
    //   486: ldc 168
    //   488: invokestatic 171	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   491: getstatic 72	com/tencent/mm/compatible/d/a:lQN	Lcom/tencent/mm/compatible/d/a;
    //   494: astore_0
    //   495: ldc2_w 172
    //   498: invokestatic 76	com/tencent/mm/compatible/d/a:ho	(J)V
    //   501: ldc 53
    //   503: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   506: aconst_null
    //   507: areturn
    //   508: iconst_0
    //   509: istore 15
    //   511: goto -268 -> 243
    //   514: iload 9
    //   516: i2d
    //   517: iload 8
    //   519: i2d
    //   520: ddiv
    //   521: dload 4
    //   523: dcmpl
    //   524: ifle +9 -> 533
    //   527: iconst_1
    //   528: istore 15
    //   530: goto -287 -> 243
    //   533: iconst_0
    //   534: istore 15
    //   536: goto -293 -> 243
    //   539: iload 8
    //   541: i2d
    //   542: dload 4
    //   544: dmul
    //   545: d2i
    //   546: istore 10
    //   548: iconst_0
    //   549: istore 13
    //   551: iload 9
    //   553: i2d
    //   554: iload 8
    //   556: i2d
    //   557: dload 4
    //   559: dmul
    //   560: dsub
    //   561: ldc2_w 11
    //   564: ddiv
    //   565: d2i
    //   566: istore 11
    //   568: iload 10
    //   570: istore_1
    //   571: iload 8
    //   573: istore 9
    //   575: iload 8
    //   577: istore 12
    //   579: iload 9
    //   581: istore 8
    //   583: iload 10
    //   585: istore 9
    //   587: iload 13
    //   589: istore 10
    //   591: goto -290 -> 301
    //   594: iload_1
    //   595: iconst_1
    //   596: if_icmpne +50 -> 646
    //   599: iload 8
    //   601: istore 10
    //   603: iload_1
    //   604: iconst_1
    //   605: if_icmpne +48 -> 653
    //   608: iload 9
    //   610: istore_1
    //   611: iconst_0
    //   612: istore 14
    //   614: iconst_0
    //   615: istore 13
    //   617: iload_1
    //   618: istore 11
    //   620: iload 8
    //   622: istore 12
    //   624: iload 9
    //   626: istore_1
    //   627: iload 11
    //   629: istore 8
    //   631: iload 10
    //   633: istore 9
    //   635: iload 14
    //   637: istore 10
    //   639: iload 13
    //   641: istore 11
    //   643: goto -342 -> 301
    //   646: iload 9
    //   648: istore 10
    //   650: goto -47 -> 603
    //   653: iload 8
    //   655: istore_1
    //   656: goto -45 -> 611
    //   659: iload 8
    //   661: iload_2
    //   662: if_icmpge +30 -> 692
    //   665: iload_2
    //   666: i2f
    //   667: iload 8
    //   669: i2f
    //   670: fdiv
    //   671: fstore 7
    //   673: ldc 16
    //   675: ldc 175
    //   677: iconst_1
    //   678: anewarray 4	java/lang/Object
    //   681: dup
    //   682: iconst_0
    //   683: fload 7
    //   685: invokestatic 138	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   688: aastore
    //   689: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   692: iload 13
    //   694: istore_2
    //   695: goto -285 -> 410
    //   698: astore 16
    //   700: aconst_null
    //   701: astore_0
    //   702: ldc 16
    //   704: aload 16
    //   706: ldc 177
    //   708: iconst_0
    //   709: anewarray 4	java/lang/Object
    //   712: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   715: getstatic 72	com/tencent/mm/compatible/d/a:lQN	Lcom/tencent/mm/compatible/d/a;
    //   718: astore 16
    //   720: ldc2_w 182
    //   723: invokestatic 76	com/tencent/mm/compatible/d/a:ho	(J)V
    //   726: aload_0
    //   727: ifnull +7 -> 734
    //   730: aload_0
    //   731: invokevirtual 166	java/io/InputStream:close	()V
    //   734: ldc 53
    //   736: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   739: aconst_null
    //   740: areturn
    //   741: astore 16
    //   743: aconst_null
    //   744: astore_0
    //   745: aload_0
    //   746: ifnull +7 -> 753
    //   749: aload_0
    //   750: invokevirtual 166	java/io/InputStream:close	()V
    //   753: ldc 53
    //   755: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   758: aload 16
    //   760: athrow
    //   761: aload_0
    //   762: aload 16
    //   764: invokestatic 189	com/tencent/mm/graphics/MMBitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   767: astore 16
    //   769: goto -290 -> 479
    //   772: getstatic 72	com/tencent/mm/compatible/d/a:lQN	Lcom/tencent/mm/compatible/d/a;
    //   775: astore_0
    //   776: ldc2_w 190
    //   779: invokestatic 76	com/tencent/mm/compatible/d/a:ho	(J)V
    //   782: fload 7
    //   784: fconst_1
    //   785: fcmpl
    //   786: ifne +23 -> 809
    //   789: iload 6
    //   791: ifne +18 -> 809
    //   794: ldc 16
    //   796: ldc 193
    //   798: invokestatic 195	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   801: ldc 53
    //   803: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   806: aload 16
    //   808: areturn
    //   809: new 197	android/graphics/Matrix
    //   812: dup
    //   813: invokespecial 198	android/graphics/Matrix:<init>	()V
    //   816: astore_0
    //   817: aload_0
    //   818: fload 7
    //   820: fload 7
    //   822: invokevirtual 202	android/graphics/Matrix:preScale	(FF)Z
    //   825: pop
    //   826: aload_0
    //   827: iload 6
    //   829: i2f
    //   830: invokevirtual 206	android/graphics/Matrix:postRotate	(F)Z
    //   833: pop
    //   834: aload 16
    //   836: iconst_0
    //   837: iconst_0
    //   838: aload 16
    //   840: invokevirtual 212	android/graphics/Bitmap:getWidth	()I
    //   843: aload 16
    //   845: invokevirtual 215	android/graphics/Bitmap:getHeight	()I
    //   848: aload_0
    //   849: iconst_1
    //   850: invokestatic 219	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   853: astore_0
    //   854: aload_0
    //   855: aload 16
    //   857: if_acmpeq +27 -> 884
    //   860: ldc 16
    //   862: ldc 221
    //   864: iconst_1
    //   865: anewarray 4	java/lang/Object
    //   868: dup
    //   869: iconst_0
    //   870: aload 16
    //   872: invokevirtual 225	java/lang/Object:toString	()Ljava/lang/String;
    //   875: aastore
    //   876: invokestatic 66	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   879: aload 16
    //   881: invokevirtual 228	android/graphics/Bitmap:recycle	()V
    //   884: aload_0
    //   885: ifnull +34 -> 919
    //   888: ldc 16
    //   890: ldc 230
    //   892: iconst_2
    //   893: anewarray 4	java/lang/Object
    //   896: dup
    //   897: iconst_0
    //   898: aload_0
    //   899: invokevirtual 212	android/graphics/Bitmap:getWidth	()I
    //   902: invokestatic 61	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   905: aastore
    //   906: dup
    //   907: iconst_1
    //   908: aload_0
    //   909: invokevirtual 215	android/graphics/Bitmap:getHeight	()I
    //   912: invokestatic 61	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   915: aastore
    //   916: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   919: ldc 53
    //   921: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   924: aload_0
    //   925: areturn
    //   926: astore_0
    //   927: aload 17
    //   929: astore 16
    //   931: goto -452 -> 479
    //   934: astore_0
    //   935: goto -201 -> 734
    //   938: astore_0
    //   939: goto -186 -> 753
    //   942: astore 16
    //   944: goto -199 -> 745
    //   947: astore 16
    //   949: goto -204 -> 745
    //   952: astore 16
    //   954: goto -252 -> 702
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	957	0	paramString	String
    //   0	957	1	paramInt1	int
    //   0	957	2	paramInt2	int
    //   0	957	3	paramInt3	int
    //   0	957	4	paramDouble	double
    //   0	957	6	paramInt4	int
    //   355	466	7	f	float
    //   213	455	8	i	int
    //   220	427	9	j	int
    //   260	389	10	k	int
    //   280	362	11	m	int
    //   295	328	12	n	int
    //   277	416	13	i1	int
    //   612	24	14	i2	int
    //   241	294	15	bool	boolean
    //   52	428	16	localObject1	Object
    //   698	7	16	localFileNotFoundException1	FileNotFoundException
    //   718	1	16	locala	com.tencent.mm.compatible.d.a
    //   741	22	16	localOptions	BitmapFactory.Options
    //   767	163	16	localObject2	Object
    //   942	1	16	localObject3	Object
    //   947	1	16	localObject4	Object
    //   952	1	16	localFileNotFoundException2	FileNotFoundException
    //   461	467	17	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   430	435	698	java/io/FileNotFoundException
    //   430	435	741	finally
    //   471	475	926	java/io/IOException
    //   730	734	934	java/io/IOException
    //   749	753	938	java/io/IOException
    //   435	463	942	finally
    //   702	726	947	finally
    //   435	463	952	java/io/FileNotFoundException
  }
  
  public static boolean createLongPictureThumbNail(String paramString1, Bitmap.CompressFormat paramCompressFormat, int paramInt1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(243929);
    boolean bool = createLongPictureThumbNail(paramString1, paramCompressFormat, paramInt1, paramString2, paramInt2, 0, new PInt(), new PInt());
    AppMethodBeat.o(243929);
    return bool;
  }
  
  public static boolean createLongPictureThumbNail(String paramString1, Bitmap.CompressFormat paramCompressFormat, int paramInt1, String paramString2, int paramInt2, int paramInt3, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(243920);
    paramString1 = createLongPictureBitmap(paramString1, paramInt2, paramInt3);
    try
    {
      paramPInt1.value = paramString1.getWidth();
      paramPInt2.value = paramString1.getHeight();
      BitmapUtil.saveBitmapToImage(paramString1, paramInt1, paramCompressFormat, paramString2, true);
      AppMethodBeat.o(243920);
      return true;
    }
    catch (IOException paramString1)
    {
      Log.e("MicroMsg.LongBitmapHandler", "create thumbnail from orig failed: ".concat(String.valueOf(paramString2)));
      AppMethodBeat.o(243920);
    }
    return false;
  }
  
  public static boolean isLongHorizontal(int paramInt1, int paramInt2)
  {
    return paramInt1 > paramInt2 * 2.0D;
  }
  
  public static int isLongPicture(Bitmap paramBitmap)
  {
    AppMethodBeat.i(243887);
    float f1 = paramBitmap.getWidth() / paramBitmap.getHeight();
    float f2 = paramBitmap.getHeight() / paramBitmap.getWidth();
    if (f1 >= 2.0F)
    {
      AppMethodBeat.o(243887);
      return 1;
    }
    if (f2 >= 2.0F)
    {
      AppMethodBeat.o(243887);
      return 2;
    }
    AppMethodBeat.o(243887);
    return -1;
  }
  
  public static int isLongPicture(String paramString)
  {
    Object localObject4 = null;
    Object localObject3 = null;
    AppMethodBeat.i(156189);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    localObject1 = localObject3;
    localObject2 = localObject4;
    try
    {
      InputStream localInputStream = y.Lh(paramString);
      localObject1 = localObject3;
      localObject2 = localObject4;
      paramString = MMBitmapFactory.decodeStream(localInputStream, null, localOptions);
      localObject1 = paramString;
      localObject2 = paramString;
      localInputStream.close();
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        float f1;
        float f2;
        paramString = (String)localObject1;
      }
    }
    catch (FileNotFoundException paramString)
    {
      for (;;)
      {
        paramString = (String)localObject2;
      }
    }
    if (paramString != null)
    {
      Log.i("MicroMsg.LongBitmapHandler", "isLongPicture bitmap recycle. %s", new Object[] { paramString });
      paramString.recycle();
    }
    f1 = localOptions.outWidth / localOptions.outHeight;
    f2 = localOptions.outHeight / localOptions.outWidth;
    if (f1 >= 2.0F)
    {
      AppMethodBeat.o(156189);
      return 1;
    }
    if (f2 >= 2.0F)
    {
      AppMethodBeat.o(156189);
      return 2;
    }
    AppMethodBeat.o(156189);
    return -1;
  }
  
  public static boolean isLongVertical(int paramInt1, int paramInt2)
  {
    return paramInt2 > paramInt1 * 2.0D;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.LongBitmapHandler
 * JD-Core Version:    0.7.0.1
 */