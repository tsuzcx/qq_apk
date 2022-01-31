package com.tencent.mm.sdk.platformtools;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.vfs.e;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public final class ad
{
  public static boolean a(String paramString1, Bitmap.CompressFormat paramCompressFormat, String paramString2, int paramInt)
  {
    AppMethodBeat.i(93403);
    boolean bool = a(paramString1, paramCompressFormat, paramString2, paramInt, new PInt(), new PInt());
    AppMethodBeat.o(93403);
    return bool;
  }
  
  private static boolean a(String paramString1, Bitmap.CompressFormat paramCompressFormat, String paramString2, int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(93402);
    paramString1 = aC(paramString1, paramInt, 0);
    try
    {
      paramPInt1.value = paramString1.getWidth();
      paramPInt2.value = paramString1.getHeight();
      d.a(paramString1, 90, paramCompressFormat, paramString2, true);
      AppMethodBeat.o(93402);
      return true;
    }
    catch (IOException paramString1)
    {
      ab.e("MicroMsg.LongBitmapHandler", "create thumbnail from orig failed: ".concat(String.valueOf(paramString2)));
      AppMethodBeat.o(93402);
    }
    return false;
  }
  
  /* Error */
  public static Bitmap aC(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc 74
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 53
    //   7: ldc 76
    //   9: iconst_5
    //   10: anewarray 4	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: aload_0
    //   16: aastore
    //   17: dup
    //   18: iconst_1
    //   19: bipush 56
    //   21: invokestatic 81	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   24: aastore
    //   25: dup
    //   26: iconst_2
    //   27: sipush 144
    //   30: invokestatic 81	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   33: aastore
    //   34: dup
    //   35: iconst_3
    //   36: iload_1
    //   37: invokestatic 81	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   40: aastore
    //   41: dup
    //   42: iconst_4
    //   43: iload_2
    //   44: invokestatic 81	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   47: aastore
    //   48: invokestatic 84	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   51: getstatic 90	com/tencent/mm/compatible/d/a:emy	Lcom/tencent/mm/compatible/d/a;
    //   54: astore 12
    //   56: lconst_0
    //   57: invokestatic 94	com/tencent/mm/compatible/d/a:ga	(J)V
    //   60: aload_0
    //   61: invokestatic 100	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   64: ifne +64 -> 128
    //   67: iload_1
    //   68: iconst_2
    //   69: if_icmpeq +8 -> 77
    //   72: iload_1
    //   73: iconst_1
    //   74: if_icmpne +54 -> 128
    //   77: aload_0
    //   78: invokestatic 104	com/tencent/mm/sdk/platformtools/d:aoU	(Ljava/lang/String;)Landroid/graphics/Point;
    //   81: astore 12
    //   83: aload 12
    //   85: ifnull +19 -> 104
    //   88: aload 12
    //   90: getfield 109	android/graphics/Point:x	I
    //   93: ifle +11 -> 104
    //   96: aload 12
    //   98: getfield 112	android/graphics/Point:y	I
    //   101: ifgt +49 -> 150
    //   104: ldc 53
    //   106: ldc 114
    //   108: invokestatic 117	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   111: getstatic 90	com/tencent/mm/compatible/d/a:emy	Lcom/tencent/mm/compatible/d/a;
    //   114: astore_0
    //   115: ldc2_w 118
    //   118: invokestatic 94	com/tencent/mm/compatible/d/a:ga	(J)V
    //   121: ldc 74
    //   123: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: aconst_null
    //   127: areturn
    //   128: ldc 53
    //   130: ldc 121
    //   132: invokestatic 117	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: getstatic 90	com/tencent/mm/compatible/d/a:emy	Lcom/tencent/mm/compatible/d/a;
    //   138: astore_0
    //   139: lconst_1
    //   140: invokestatic 94	com/tencent/mm/compatible/d/a:ga	(J)V
    //   143: ldc 74
    //   145: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   148: aconst_null
    //   149: areturn
    //   150: aload 12
    //   152: getfield 109	android/graphics/Point:x	I
    //   155: istore 4
    //   157: aload 12
    //   159: getfield 112	android/graphics/Point:y	I
    //   162: istore 5
    //   164: iload_1
    //   165: iconst_1
    //   166: if_icmpne +290 -> 456
    //   169: iload 4
    //   171: i2d
    //   172: iload 5
    //   174: i2d
    //   175: ddiv
    //   176: ldc2_w 122
    //   179: dcmpl
    //   180: ifle +270 -> 450
    //   183: iconst_1
    //   184: istore 11
    //   186: iload 11
    //   188: ifeq +343 -> 531
    //   191: iload_1
    //   192: iconst_1
    //   193: if_icmpne +289 -> 482
    //   196: iload 5
    //   198: i2d
    //   199: ldc2_w 122
    //   202: dmul
    //   203: d2i
    //   204: istore_1
    //   205: iload 4
    //   207: i2d
    //   208: iload 5
    //   210: i2d
    //   211: ldc2_w 122
    //   214: dmul
    //   215: dsub
    //   216: ldc2_w 124
    //   219: ddiv
    //   220: d2i
    //   221: istore 9
    //   223: iload 5
    //   225: istore 4
    //   227: iload_1
    //   228: istore 6
    //   230: iconst_0
    //   231: istore 7
    //   233: iload_1
    //   234: istore 8
    //   236: iload 9
    //   238: istore_1
    //   239: ldc 53
    //   241: ldc 127
    //   243: iconst_5
    //   244: anewarray 4	java/lang/Object
    //   247: dup
    //   248: iconst_0
    //   249: iload 11
    //   251: invokestatic 132	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   254: aastore
    //   255: dup
    //   256: iconst_1
    //   257: iload 8
    //   259: invokestatic 81	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   262: aastore
    //   263: dup
    //   264: iconst_2
    //   265: iload 4
    //   267: invokestatic 81	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   270: aastore
    //   271: dup
    //   272: iconst_3
    //   273: iload_1
    //   274: invokestatic 81	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   277: aastore
    //   278: dup
    //   279: iconst_4
    //   280: iload 7
    //   282: invokestatic 81	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   285: aastore
    //   286: invokestatic 135	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   289: iconst_1
    //   290: istore 9
    //   292: fconst_1
    //   293: fstore_3
    //   294: iload 6
    //   296: sipush 144
    //   299: if_icmple +293 -> 592
    //   302: iload 5
    //   304: iload 6
    //   306: iload 5
    //   308: sipush 144
    //   311: invokestatic 138	com/tencent/mm/sdk/platformtools/d:I	(IIII)I
    //   314: istore 5
    //   316: ldc 139
    //   318: iload 6
    //   320: iload 5
    //   322: idiv
    //   323: i2f
    //   324: fdiv
    //   325: fstore_3
    //   326: ldc 53
    //   328: ldc 141
    //   330: iconst_2
    //   331: anewarray 4	java/lang/Object
    //   334: dup
    //   335: iconst_0
    //   336: iload 5
    //   338: invokestatic 81	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   341: aastore
    //   342: dup
    //   343: iconst_1
    //   344: fload_3
    //   345: invokestatic 146	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   348: aastore
    //   349: invokestatic 135	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   352: new 148	android/graphics/BitmapFactory$Options
    //   355: dup
    //   356: invokespecial 149	android/graphics/BitmapFactory$Options:<init>	()V
    //   359: astore 12
    //   361: aload 12
    //   363: iload 5
    //   365: putfield 152	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   368: iload 11
    //   370: ifeq +324 -> 694
    //   373: aload_0
    //   374: invokestatic 158	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   377: astore_0
    //   378: aload_0
    //   379: new 160	android/graphics/Rect
    //   382: dup
    //   383: iload_1
    //   384: iload 7
    //   386: iload_1
    //   387: iload 8
    //   389: iadd
    //   390: iload 4
    //   392: iload 7
    //   394: iadd
    //   395: invokespecial 163	android/graphics/Rect:<init>	(IIII)V
    //   398: aload 12
    //   400: invokestatic 168	com/tencent/mm/graphics/a:a	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   403: astore 13
    //   405: aload 13
    //   407: astore 12
    //   409: aload_0
    //   410: ifnull +11 -> 421
    //   413: aload_0
    //   414: invokevirtual 173	java/io/InputStream:close	()V
    //   417: aload 13
    //   419: astore 12
    //   421: aload 12
    //   423: ifnonnull +282 -> 705
    //   426: ldc 53
    //   428: ldc 175
    //   430: invokestatic 71	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   433: getstatic 90	com/tencent/mm/compatible/d/a:emy	Lcom/tencent/mm/compatible/d/a;
    //   436: astore_0
    //   437: ldc2_w 176
    //   440: invokestatic 94	com/tencent/mm/compatible/d/a:ga	(J)V
    //   443: ldc 74
    //   445: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   448: aconst_null
    //   449: areturn
    //   450: iconst_0
    //   451: istore 11
    //   453: goto -267 -> 186
    //   456: iload 5
    //   458: i2d
    //   459: iload 4
    //   461: i2d
    //   462: ddiv
    //   463: ldc2_w 122
    //   466: dcmpl
    //   467: ifle +9 -> 476
    //   470: iconst_1
    //   471: istore 11
    //   473: goto -287 -> 186
    //   476: iconst_0
    //   477: istore 11
    //   479: goto -293 -> 186
    //   482: iload 4
    //   484: i2d
    //   485: ldc2_w 122
    //   488: dmul
    //   489: d2i
    //   490: istore 6
    //   492: iload 5
    //   494: i2d
    //   495: iload 4
    //   497: i2d
    //   498: ldc2_w 122
    //   501: dmul
    //   502: dsub
    //   503: ldc2_w 124
    //   506: ddiv
    //   507: d2i
    //   508: istore 7
    //   510: iconst_0
    //   511: istore_1
    //   512: iload 6
    //   514: istore 9
    //   516: iload 4
    //   518: istore 5
    //   520: iload 4
    //   522: istore 8
    //   524: iload 9
    //   526: istore 4
    //   528: goto -289 -> 239
    //   531: iload_1
    //   532: iconst_1
    //   533: if_icmpne +46 -> 579
    //   536: iload 4
    //   538: istore 6
    //   540: iload_1
    //   541: iconst_1
    //   542: if_icmpne +44 -> 586
    //   545: iload 5
    //   547: istore_1
    //   548: iconst_0
    //   549: istore 10
    //   551: iconst_0
    //   552: istore 9
    //   554: iload_1
    //   555: istore 7
    //   557: iload 4
    //   559: istore 8
    //   561: iload 10
    //   563: istore_1
    //   564: iload 5
    //   566: istore 4
    //   568: iload 7
    //   570: istore 5
    //   572: iload 9
    //   574: istore 7
    //   576: goto -337 -> 239
    //   579: iload 5
    //   581: istore 6
    //   583: goto -43 -> 540
    //   586: iload 4
    //   588: istore_1
    //   589: goto -41 -> 548
    //   592: iload 5
    //   594: bipush 56
    //   596: if_icmpge +28 -> 624
    //   599: ldc 178
    //   601: iload 5
    //   603: i2f
    //   604: fdiv
    //   605: fstore_3
    //   606: ldc 53
    //   608: ldc 180
    //   610: iconst_1
    //   611: anewarray 4	java/lang/Object
    //   614: dup
    //   615: iconst_0
    //   616: fload_3
    //   617: invokestatic 146	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   620: aastore
    //   621: invokestatic 135	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   624: iload 9
    //   626: istore 5
    //   628: goto -276 -> 352
    //   631: astore 12
    //   633: aconst_null
    //   634: astore_0
    //   635: ldc 53
    //   637: aload 12
    //   639: ldc 182
    //   641: iconst_0
    //   642: anewarray 4	java/lang/Object
    //   645: invokestatic 186	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   648: getstatic 90	com/tencent/mm/compatible/d/a:emy	Lcom/tencent/mm/compatible/d/a;
    //   651: astore 12
    //   653: ldc2_w 187
    //   656: invokestatic 94	com/tencent/mm/compatible/d/a:ga	(J)V
    //   659: aload_0
    //   660: ifnull +7 -> 667
    //   663: aload_0
    //   664: invokevirtual 173	java/io/InputStream:close	()V
    //   667: ldc 74
    //   669: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   672: aconst_null
    //   673: areturn
    //   674: astore 12
    //   676: aconst_null
    //   677: astore_0
    //   678: aload_0
    //   679: ifnull +7 -> 686
    //   682: aload_0
    //   683: invokevirtual 173	java/io/InputStream:close	()V
    //   686: ldc 74
    //   688: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   691: aload 12
    //   693: athrow
    //   694: aload_0
    //   695: aload 12
    //   697: invokestatic 194	com/tencent/mm/graphics/MMBitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   700: astore 12
    //   702: goto -281 -> 421
    //   705: getstatic 90	com/tencent/mm/compatible/d/a:emy	Lcom/tencent/mm/compatible/d/a;
    //   708: astore_0
    //   709: ldc2_w 195
    //   712: invokestatic 94	com/tencent/mm/compatible/d/a:ga	(J)V
    //   715: fload_3
    //   716: fconst_1
    //   717: fcmpl
    //   718: ifne +22 -> 740
    //   721: iload_2
    //   722: ifne +18 -> 740
    //   725: ldc 53
    //   727: ldc 198
    //   729: invokestatic 200	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   732: ldc 74
    //   734: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   737: aload 12
    //   739: areturn
    //   740: new 202	android/graphics/Matrix
    //   743: dup
    //   744: invokespecial 203	android/graphics/Matrix:<init>	()V
    //   747: astore_0
    //   748: aload_0
    //   749: fload_3
    //   750: fload_3
    //   751: invokevirtual 207	android/graphics/Matrix:preScale	(FF)Z
    //   754: pop
    //   755: aload_0
    //   756: iload_2
    //   757: i2f
    //   758: invokevirtual 211	android/graphics/Matrix:postRotate	(F)Z
    //   761: pop
    //   762: aload 12
    //   764: iconst_0
    //   765: iconst_0
    //   766: aload 12
    //   768: invokevirtual 39	android/graphics/Bitmap:getWidth	()I
    //   771: aload 12
    //   773: invokevirtual 46	android/graphics/Bitmap:getHeight	()I
    //   776: aload_0
    //   777: iconst_1
    //   778: invokestatic 215	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   781: astore_0
    //   782: aload_0
    //   783: aload 12
    //   785: if_acmpeq +27 -> 812
    //   788: ldc 53
    //   790: ldc 217
    //   792: iconst_1
    //   793: anewarray 4	java/lang/Object
    //   796: dup
    //   797: iconst_0
    //   798: aload 12
    //   800: invokevirtual 221	java/lang/Object:toString	()Ljava/lang/String;
    //   803: aastore
    //   804: invokestatic 84	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   807: aload 12
    //   809: invokevirtual 224	android/graphics/Bitmap:recycle	()V
    //   812: aload_0
    //   813: ifnull +34 -> 847
    //   816: ldc 53
    //   818: ldc 226
    //   820: iconst_2
    //   821: anewarray 4	java/lang/Object
    //   824: dup
    //   825: iconst_0
    //   826: aload_0
    //   827: invokevirtual 39	android/graphics/Bitmap:getWidth	()I
    //   830: invokestatic 81	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   833: aastore
    //   834: dup
    //   835: iconst_1
    //   836: aload_0
    //   837: invokevirtual 46	android/graphics/Bitmap:getHeight	()I
    //   840: invokestatic 81	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   843: aastore
    //   844: invokestatic 135	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   847: ldc 74
    //   849: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   852: aload_0
    //   853: areturn
    //   854: astore_0
    //   855: aload 13
    //   857: astore 12
    //   859: goto -438 -> 421
    //   862: astore_0
    //   863: goto -196 -> 667
    //   866: astore_0
    //   867: goto -181 -> 686
    //   870: astore 12
    //   872: goto -194 -> 678
    //   875: astore 12
    //   877: goto -199 -> 678
    //   880: astore 12
    //   882: goto -247 -> 635
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	885	0	paramString	String
    //   0	885	1	paramInt1	int
    //   0	885	2	paramInt2	int
    //   293	458	3	f	float
    //   155	432	4	i	int
    //   162	465	5	j	int
    //   228	354	6	k	int
    //   231	344	7	m	int
    //   234	326	8	n	int
    //   221	404	9	i1	int
    //   549	13	10	i2	int
    //   184	294	11	bool	boolean
    //   54	368	12	localObject1	Object
    //   631	7	12	localFileNotFoundException1	FileNotFoundException
    //   651	1	12	locala	com.tencent.mm.compatible.d.a
    //   674	22	12	localOptions	BitmapFactory.Options
    //   700	158	12	localObject2	Object
    //   870	1	12	localObject3	Object
    //   875	1	12	localObject4	Object
    //   880	1	12	localFileNotFoundException2	FileNotFoundException
    //   403	453	13	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   373	378	631	java/io/FileNotFoundException
    //   373	378	674	finally
    //   413	417	854	java/io/IOException
    //   663	667	862	java/io/IOException
    //   682	686	866	java/io/IOException
    //   378	405	870	finally
    //   635	659	875	finally
    //   378	405	880	java/io/FileNotFoundException
  }
  
  public static int api(String paramString)
  {
    Object localObject4 = null;
    Object localObject3 = null;
    AppMethodBeat.i(93400);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    localObject1 = localObject3;
    localObject2 = localObject4;
    try
    {
      InputStream localInputStream = e.openRead(paramString);
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
      ab.i("MicroMsg.LongBitmapHandler", "isLongPicture bitmap recycle. %s", new Object[] { paramString });
      paramString.recycle();
    }
    f1 = localOptions.outWidth / localOptions.outHeight;
    f2 = localOptions.outHeight / localOptions.outWidth;
    if (f1 >= 2.0F)
    {
      AppMethodBeat.o(93400);
      return 1;
    }
    if (f2 >= 2.0F)
    {
      AppMethodBeat.o(93400);
      return 2;
    }
    AppMethodBeat.o(93400);
    return -1;
  }
  
  public static boolean cN(int paramInt1, int paramInt2)
  {
    return paramInt2 > paramInt1 * 2.0D;
  }
  
  public static boolean cO(int paramInt1, int paramInt2)
  {
    return paramInt1 > paramInt2 * 2.0D;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ad
 * JD-Core Version:    0.7.0.1
 */