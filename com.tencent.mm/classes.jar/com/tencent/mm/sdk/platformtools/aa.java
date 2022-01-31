package com.tencent.mm.sdk.platformtools;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.vfs.e;
import java.io.FileNotFoundException;
import java.io.IOException;

public final class aa
{
  public static int Zk(String paramString)
  {
    Object localObject = null;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    try
    {
      paramString = MMBitmapFactory.decodeStream(e.openRead(paramString), null, localOptions, 0);
      if (paramString != null)
      {
        y.i("MicroMsg.LongBitmapHandler", "isLongPicture bitmap recycle. %s", new Object[] { paramString });
        paramString.recycle();
      }
      float f1 = localOptions.outWidth / localOptions.outHeight;
      float f2 = localOptions.outHeight / localOptions.outWidth;
      if (f1 >= 2.0F) {
        return 1;
      }
      if (f2 >= 2.0F) {
        return 2;
      }
      return -1;
    }
    catch (FileNotFoundException paramString)
    {
      for (;;)
      {
        paramString = localObject;
      }
    }
  }
  
  public static boolean a(String paramString1, Bitmap.CompressFormat paramCompressFormat, String paramString2, int paramInt)
  {
    return a(paramString1, paramCompressFormat, paramString2, paramInt, new PInt(), new PInt());
  }
  
  private static boolean a(String paramString1, Bitmap.CompressFormat paramCompressFormat, String paramString2, int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    paramString1 = m(paramString1, paramInt, 0, 1);
    try
    {
      paramPInt1.value = paramString1.getWidth();
      paramPInt2.value = paramString1.getHeight();
      c.a(paramString1, 90, paramCompressFormat, paramString2, true);
      return true;
    }
    catch (IOException paramString1)
    {
      y.e("MicroMsg.LongBitmapHandler", "create thumbnail from orig failed: " + paramString2);
    }
    return false;
  }
  
  public static boolean bC(int paramInt1, int paramInt2)
  {
    return paramInt2 > paramInt1 * 2.0D;
  }
  
  public static boolean bD(int paramInt1, int paramInt2)
  {
    return paramInt1 > paramInt2 * 2.0D;
  }
  
  /* Error */
  public static Bitmap m(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: ldc 32
    //   2: ldc 108
    //   4: bipush 6
    //   6: anewarray 4	java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: aload_0
    //   12: aastore
    //   13: dup
    //   14: iconst_1
    //   15: bipush 56
    //   17: invokestatic 114	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   20: aastore
    //   21: dup
    //   22: iconst_2
    //   23: sipush 144
    //   26: invokestatic 114	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   29: aastore
    //   30: dup
    //   31: iconst_3
    //   32: iload_1
    //   33: invokestatic 114	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   36: aastore
    //   37: dup
    //   38: iconst_4
    //   39: iload_2
    //   40: invokestatic 114	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   43: aastore
    //   44: dup
    //   45: iconst_5
    //   46: iload_3
    //   47: invokestatic 114	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   50: aastore
    //   51: invokestatic 40	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   54: getstatic 120	com/tencent/mm/compatible/d/a:duI	Lcom/tencent/mm/compatible/d/a;
    //   57: astore 13
    //   59: lconst_0
    //   60: invokestatic 124	com/tencent/mm/compatible/d/a:bq	(J)V
    //   63: aload_0
    //   64: invokestatic 130	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   67: ifne +59 -> 126
    //   70: iload_1
    //   71: iconst_2
    //   72: if_icmpeq +8 -> 80
    //   75: iload_1
    //   76: iconst_1
    //   77: if_icmpne +49 -> 126
    //   80: aload_0
    //   81: invokestatic 134	com/tencent/mm/sdk/platformtools/c:YV	(Ljava/lang/String;)Landroid/graphics/Point;
    //   84: astore 13
    //   86: aload 13
    //   88: ifnull +19 -> 107
    //   91: aload 13
    //   93: getfield 139	android/graphics/Point:x	I
    //   96: ifle +11 -> 107
    //   99: aload 13
    //   101: getfield 142	android/graphics/Point:y	I
    //   104: ifgt +39 -> 143
    //   107: ldc 32
    //   109: ldc 144
    //   111: invokestatic 147	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   114: getstatic 120	com/tencent/mm/compatible/d/a:duI	Lcom/tencent/mm/compatible/d/a;
    //   117: astore_0
    //   118: ldc2_w 148
    //   121: invokestatic 124	com/tencent/mm/compatible/d/a:bq	(J)V
    //   124: aconst_null
    //   125: areturn
    //   126: ldc 32
    //   128: ldc 151
    //   130: invokestatic 147	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   133: getstatic 120	com/tencent/mm/compatible/d/a:duI	Lcom/tencent/mm/compatible/d/a;
    //   136: astore_0
    //   137: lconst_1
    //   138: invokestatic 124	com/tencent/mm/compatible/d/a:bq	(J)V
    //   141: aconst_null
    //   142: areturn
    //   143: aload 13
    //   145: getfield 139	android/graphics/Point:x	I
    //   148: istore 5
    //   150: aload 13
    //   152: getfield 142	android/graphics/Point:y	I
    //   155: istore 6
    //   157: iload_1
    //   158: iconst_1
    //   159: if_icmpne +294 -> 453
    //   162: iload 5
    //   164: i2d
    //   165: iload 6
    //   167: i2d
    //   168: ddiv
    //   169: ldc2_w 152
    //   172: dcmpl
    //   173: ifle +274 -> 447
    //   176: iconst_1
    //   177: istore 12
    //   179: iload 12
    //   181: ifeq +351 -> 532
    //   184: iload_1
    //   185: iconst_1
    //   186: if_icmpne +293 -> 479
    //   189: iload 6
    //   191: i2d
    //   192: ldc2_w 152
    //   195: dmul
    //   196: d2i
    //   197: istore 7
    //   199: iload 5
    //   201: i2d
    //   202: iload 6
    //   204: i2d
    //   205: ldc2_w 152
    //   208: dmul
    //   209: dsub
    //   210: ldc2_w 104
    //   213: ddiv
    //   214: d2i
    //   215: istore 10
    //   217: iconst_0
    //   218: istore 8
    //   220: iload 6
    //   222: istore_1
    //   223: iload 7
    //   225: istore 5
    //   227: iload 7
    //   229: istore 9
    //   231: iload 6
    //   233: istore 7
    //   235: iload 10
    //   237: istore 6
    //   239: ldc 32
    //   241: ldc 155
    //   243: iconst_5
    //   244: anewarray 4	java/lang/Object
    //   247: dup
    //   248: iconst_0
    //   249: iload 12
    //   251: invokestatic 160	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   254: aastore
    //   255: dup
    //   256: iconst_1
    //   257: iload 9
    //   259: invokestatic 114	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   262: aastore
    //   263: dup
    //   264: iconst_2
    //   265: iload 7
    //   267: invokestatic 114	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   270: aastore
    //   271: dup
    //   272: iconst_3
    //   273: iload 6
    //   275: invokestatic 114	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   278: aastore
    //   279: dup
    //   280: iconst_4
    //   281: iload 8
    //   283: invokestatic 114	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   286: aastore
    //   287: invokestatic 163	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   290: iconst_1
    //   291: istore 10
    //   293: fconst_1
    //   294: fstore 4
    //   296: iload 5
    //   298: sipush 144
    //   301: if_icmple +294 -> 595
    //   304: iload_1
    //   305: iload 5
    //   307: iload_1
    //   308: invokestatic 167	com/tencent/mm/sdk/platformtools/c:ai	(III)I
    //   311: istore_1
    //   312: ldc 168
    //   314: iload 5
    //   316: iload_1
    //   317: idiv
    //   318: i2f
    //   319: fdiv
    //   320: fstore 4
    //   322: ldc 32
    //   324: ldc 170
    //   326: iconst_2
    //   327: anewarray 4	java/lang/Object
    //   330: dup
    //   331: iconst_0
    //   332: iload_1
    //   333: invokestatic 114	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   336: aastore
    //   337: dup
    //   338: iconst_1
    //   339: fload 4
    //   341: invokestatic 175	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   344: aastore
    //   345: invokestatic 163	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   348: iload_1
    //   349: istore 5
    //   351: new 10	android/graphics/BitmapFactory$Options
    //   354: dup
    //   355: invokespecial 14	android/graphics/BitmapFactory$Options:<init>	()V
    //   358: astore 13
    //   360: aload 13
    //   362: iload 5
    //   364: putfield 178	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   367: iload 12
    //   369: ifeq +322 -> 691
    //   372: aload_0
    //   373: invokestatic 24	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   376: astore_0
    //   377: aload_0
    //   378: new 180	android/graphics/Rect
    //   381: dup
    //   382: iload 6
    //   384: iload 8
    //   386: iload 6
    //   388: iload 9
    //   390: iadd
    //   391: iload 7
    //   393: iload 8
    //   395: iadd
    //   396: invokespecial 183	android/graphics/Rect:<init>	(IIII)V
    //   399: aload 13
    //   401: aconst_null
    //   402: invokestatic 187	com/tencent/mm/sdk/platformtools/MMBitmapFactory:decodeRegion	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;Lcom/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger;)Landroid/graphics/Bitmap;
    //   405: astore 14
    //   407: aload 14
    //   409: astore 13
    //   411: aload_0
    //   412: ifnull +11 -> 423
    //   415: aload_0
    //   416: invokevirtual 192	java/io/InputStream:close	()V
    //   419: aload 14
    //   421: astore 13
    //   423: aload 13
    //   425: ifnonnull +282 -> 707
    //   428: ldc 32
    //   430: ldc 194
    //   432: invokestatic 101	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   435: getstatic 120	com/tencent/mm/compatible/d/a:duI	Lcom/tencent/mm/compatible/d/a;
    //   438: astore_0
    //   439: ldc2_w 195
    //   442: invokestatic 124	com/tencent/mm/compatible/d/a:bq	(J)V
    //   445: aconst_null
    //   446: areturn
    //   447: iconst_0
    //   448: istore 12
    //   450: goto -271 -> 179
    //   453: iload 6
    //   455: i2d
    //   456: iload 5
    //   458: i2d
    //   459: ddiv
    //   460: ldc2_w 152
    //   463: dcmpl
    //   464: ifle +9 -> 473
    //   467: iconst_1
    //   468: istore 12
    //   470: goto -291 -> 179
    //   473: iconst_0
    //   474: istore 12
    //   476: goto -297 -> 179
    //   479: iload 5
    //   481: i2d
    //   482: ldc2_w 152
    //   485: dmul
    //   486: d2i
    //   487: istore 7
    //   489: iconst_0
    //   490: istore 10
    //   492: iload 6
    //   494: i2d
    //   495: iload 5
    //   497: i2d
    //   498: ldc2_w 152
    //   501: dmul
    //   502: dsub
    //   503: ldc2_w 104
    //   506: ddiv
    //   507: d2i
    //   508: istore 8
    //   510: iload 5
    //   512: istore_1
    //   513: iload 7
    //   515: istore 6
    //   517: iload 5
    //   519: istore 9
    //   521: iload 6
    //   523: istore 5
    //   525: iload 10
    //   527: istore 6
    //   529: goto -290 -> 239
    //   532: iload_1
    //   533: iconst_1
    //   534: if_icmpne +48 -> 582
    //   537: iload 5
    //   539: istore 7
    //   541: iload_1
    //   542: iconst_1
    //   543: if_icmpne +46 -> 589
    //   546: iload 6
    //   548: istore_1
    //   549: iconst_0
    //   550: istore 10
    //   552: iconst_0
    //   553: istore 11
    //   555: iload 6
    //   557: istore 8
    //   559: iload 5
    //   561: istore 9
    //   563: iload 7
    //   565: istore 5
    //   567: iload 11
    //   569: istore 6
    //   571: iload 8
    //   573: istore 7
    //   575: iload 10
    //   577: istore 8
    //   579: goto -340 -> 239
    //   582: iload 6
    //   584: istore 7
    //   586: goto -45 -> 541
    //   589: iload 5
    //   591: istore_1
    //   592: goto -43 -> 549
    //   595: iload 10
    //   597: istore 5
    //   599: iload_1
    //   600: bipush 56
    //   602: if_icmpge -251 -> 351
    //   605: ldc 197
    //   607: iload_1
    //   608: i2f
    //   609: fdiv
    //   610: fstore 4
    //   612: ldc 32
    //   614: ldc 199
    //   616: iconst_1
    //   617: anewarray 4	java/lang/Object
    //   620: dup
    //   621: iconst_0
    //   622: fload 4
    //   624: invokestatic 175	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   627: aastore
    //   628: invokestatic 163	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   631: iload 10
    //   633: istore 5
    //   635: goto -284 -> 351
    //   638: astore 13
    //   640: aconst_null
    //   641: astore_0
    //   642: ldc 32
    //   644: aload 13
    //   646: ldc 201
    //   648: iconst_0
    //   649: anewarray 4	java/lang/Object
    //   652: invokestatic 205	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   655: getstatic 120	com/tencent/mm/compatible/d/a:duI	Lcom/tencent/mm/compatible/d/a;
    //   658: astore 13
    //   660: ldc2_w 206
    //   663: invokestatic 124	com/tencent/mm/compatible/d/a:bq	(J)V
    //   666: aload_0
    //   667: ifnull +7 -> 674
    //   670: aload_0
    //   671: invokevirtual 192	java/io/InputStream:close	()V
    //   674: aconst_null
    //   675: areturn
    //   676: astore 13
    //   678: aconst_null
    //   679: astore_0
    //   680: aload_0
    //   681: ifnull +7 -> 688
    //   684: aload_0
    //   685: invokevirtual 192	java/io/InputStream:close	()V
    //   688: aload 13
    //   690: athrow
    //   691: aload_0
    //   692: aload 13
    //   694: aconst_null
    //   695: iload_3
    //   696: iconst_0
    //   697: newarray int
    //   699: invokestatic 211	com/tencent/mm/sdk/platformtools/MMBitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Lcom/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger;I[I)Landroid/graphics/Bitmap;
    //   702: astore 13
    //   704: goto -281 -> 423
    //   707: getstatic 120	com/tencent/mm/compatible/d/a:duI	Lcom/tencent/mm/compatible/d/a;
    //   710: astore_0
    //   711: ldc2_w 212
    //   714: invokestatic 124	com/tencent/mm/compatible/d/a:bq	(J)V
    //   717: fload 4
    //   719: fconst_1
    //   720: fcmpl
    //   721: ifne +17 -> 738
    //   724: iload_2
    //   725: ifne +13 -> 738
    //   728: ldc 32
    //   730: ldc 215
    //   732: invokestatic 217	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   735: aload 13
    //   737: areturn
    //   738: new 219	android/graphics/Matrix
    //   741: dup
    //   742: invokespecial 220	android/graphics/Matrix:<init>	()V
    //   745: astore_0
    //   746: aload_0
    //   747: fload 4
    //   749: fload 4
    //   751: invokevirtual 224	android/graphics/Matrix:preScale	(FF)Z
    //   754: pop
    //   755: aload_0
    //   756: iload_2
    //   757: i2f
    //   758: invokevirtual 228	android/graphics/Matrix:postRotate	(F)Z
    //   761: pop
    //   762: aload 13
    //   764: iconst_0
    //   765: iconst_0
    //   766: aload 13
    //   768: invokevirtual 71	android/graphics/Bitmap:getWidth	()I
    //   771: aload 13
    //   773: invokevirtual 77	android/graphics/Bitmap:getHeight	()I
    //   776: aload_0
    //   777: iconst_1
    //   778: invokestatic 232	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   781: astore_0
    //   782: aload_0
    //   783: aload 13
    //   785: if_acmpeq +8 -> 793
    //   788: aload 13
    //   790: invokevirtual 45	android/graphics/Bitmap:recycle	()V
    //   793: aload_0
    //   794: ifnull +34 -> 828
    //   797: ldc 32
    //   799: ldc 234
    //   801: iconst_2
    //   802: anewarray 4	java/lang/Object
    //   805: dup
    //   806: iconst_0
    //   807: aload_0
    //   808: invokevirtual 71	android/graphics/Bitmap:getWidth	()I
    //   811: invokestatic 114	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   814: aastore
    //   815: dup
    //   816: iconst_1
    //   817: aload_0
    //   818: invokevirtual 77	android/graphics/Bitmap:getHeight	()I
    //   821: invokestatic 114	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   824: aastore
    //   825: invokestatic 163	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   828: aload_0
    //   829: areturn
    //   830: astore_0
    //   831: aload 14
    //   833: astore 13
    //   835: goto -412 -> 423
    //   838: astore_0
    //   839: goto -165 -> 674
    //   842: astore_0
    //   843: goto -155 -> 688
    //   846: astore 13
    //   848: goto -168 -> 680
    //   851: astore 13
    //   853: goto -173 -> 680
    //   856: astore 13
    //   858: goto -216 -> 642
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	861	0	paramString	String
    //   0	861	1	paramInt1	int
    //   0	861	2	paramInt2	int
    //   0	861	3	paramInt3	int
    //   294	456	4	f	float
    //   148	486	5	i	int
    //   155	428	6	j	int
    //   197	388	7	k	int
    //   218	360	8	m	int
    //   229	333	9	n	int
    //   215	417	10	i1	int
    //   553	15	11	i2	int
    //   177	298	12	bool	boolean
    //   57	367	13	localObject1	Object
    //   638	7	13	localFileNotFoundException1	FileNotFoundException
    //   658	1	13	locala	com.tencent.mm.compatible.d.a
    //   676	17	13	localOptions	BitmapFactory.Options
    //   702	132	13	localObject2	Object
    //   846	1	13	localObject3	Object
    //   851	1	13	localObject4	Object
    //   856	1	13	localFileNotFoundException2	FileNotFoundException
    //   405	427	14	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   372	377	638	java/io/FileNotFoundException
    //   372	377	676	finally
    //   415	419	830	java/io/IOException
    //   670	674	838	java/io/IOException
    //   684	688	842	java/io/IOException
    //   377	407	846	finally
    //   642	666	851	finally
    //   377	407	856	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.aa
 * JD-Core Version:    0.7.0.1
 */