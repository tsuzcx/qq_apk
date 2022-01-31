package com.tencent.mm.sdk.platformtools;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.b;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.vfs.e;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d
{
  private static DisplayMetrics gjH = null;
  
  private static BitmapFactory.Options E(InputStream paramInputStream)
  {
    AppMethodBeat.i(93317);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    if (paramInputStream == null)
    {
      ab.e("MicroMsg.BitmapUtil", "getImageOptions decode stream is null!!");
      AppMethodBeat.o(93317);
      return localOptions;
    }
    for (;;)
    {
      try
      {
        Bitmap localBitmap = MMBitmapFactory.decodeStream(paramInputStream, null, localOptions);
        if (localBitmap != null)
        {
          ab.i("MicroMsg.BitmapUtil", "getImageOptions bitmap recycle. %s", new Object[] { localBitmap });
          localBitmap.recycle();
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localOutOfMemoryError = localOutOfMemoryError;
        ab.printErrStackTrace("MicroMsg.BitmapUtil", localOutOfMemoryError, "Decode bitmap failed.", new Object[0]);
        try
        {
          paramInputStream.close();
        }
        catch (IOException paramInputStream)
        {
          ab.printErrStackTrace("MicroMsg.BitmapUtil", paramInputStream, "hy: stream close failed ", new Object[0]);
        }
        continue;
      }
      finally {}
      try
      {
        paramInputStream.close();
        AppMethodBeat.o(93317);
        return localOptions;
      }
      catch (IOException paramInputStream)
      {
        ab.printErrStackTrace("MicroMsg.BitmapUtil", paramInputStream, "hy: stream close failed ", new Object[0]);
      }
    }
    try
    {
      paramInputStream.close();
      AppMethodBeat.o(93317);
      throw localObject;
    }
    catch (IOException paramInputStream)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.BitmapUtil", paramInputStream, "hy: stream close failed ", new Object[0]);
      }
    }
  }
  
  public static int I(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(139726);
    int j = 1;
    if ((paramInt1 > paramInt4) || (paramInt2 > paramInt3))
    {
      if (paramInt2 > paramInt1) {}
      for (int i = Math.round(paramInt1 / paramInt4 + 0.5F);; i = Math.round(paramInt2 / paramInt3 + 0.5F))
      {
        float f1 = paramInt2 * paramInt1;
        float f2 = paramInt3 * paramInt4 * 2;
        for (;;)
        {
          j = i;
          if (f1 / (i * i) <= f2) {
            break;
          }
          i += 1;
        }
      }
    }
    AppMethodBeat.o(139726);
    return j;
  }
  
  public static Bitmap Na(int paramInt)
  {
    AppMethodBeat.i(93334);
    Bitmap localBitmap = a(paramInt, null, null, null, false, 0.0F, 0, 0);
    AppMethodBeat.o(93334);
    return localBitmap;
  }
  
  public static int a(boolean paramBoolean, String paramString1, int paramInt1, int paramInt2, Bitmap.CompressFormat paramCompressFormat, int paramInt3, String paramString2, b paramb)
  {
    AppMethodBeat.i(93329);
    Bitmap localBitmap = d(paramString1, paramInt1, paramInt2, false);
    if (localBitmap == null)
    {
      AppMethodBeat.o(93329);
      return -1;
    }
    paramString1 = b(localBitmap, Exif.fromFile(paramString1).getOrientationInDegree());
    if (paramb != null) {
      paramb.getFile();
    }
    if (paramBoolean) {}
    try
    {
      paramInt1 = q.b(paramString1, paramInt3, paramString2);
      ab.i("MicroMsg.BitmapUtil", "dkimgopt compressByQualityOptim ret:%d  [%d,%d,%d] path:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramString1.getWidth()), Integer.valueOf(paramString1.getHeight()), paramString2 });
      AppMethodBeat.o(93329);
      return paramInt1;
    }
    catch (IOException paramString1)
    {
      ab.e("MicroMsg.BitmapUtil", "create thumbnail from orig failed: ".concat(String.valueOf(paramString2)));
      AppMethodBeat.o(93329);
    }
    a(paramString1, paramInt3, paramCompressFormat, paramString2, true);
    AppMethodBeat.o(93329);
    return 1;
    return -2;
  }
  
  private static Bitmap a(int paramInt1, String paramString, byte[] paramArrayOfByte, Uri paramUri, boolean paramBoolean, float paramFloat, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(93350);
    paramString = b(paramInt1, paramString, paramArrayOfByte, paramUri, paramBoolean, paramFloat, paramInt2, paramInt3);
    AppMethodBeat.o(93350);
    return paramString;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(93378);
    if ((paramBitmap == null) || (paramInt1 < 0) || (paramInt2 < 0) || (paramInt3 < 0))
    {
      AppMethodBeat.o(93378);
      return null;
    }
    long l = System.currentTimeMillis();
    Bitmap localBitmap = c.ag(createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888, false));
    Canvas localCanvas = new Canvas(localBitmap);
    ab.d("MicroMsg.BitmapUtil", "bm size w %d h %d target w %d h %d", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    localCanvas.drawBitmap(paramBitmap, null, new Rect(0, 0, paramInt2, paramInt3), new Paint());
    ab.d("MicroMsg.BitmapUtil", "create nine patch bitmap " + (System.currentTimeMillis() - l));
    paramBitmap = f(localBitmap, paramInt1);
    AppMethodBeat.o(93378);
    return paramBitmap;
  }
  
  /* Error */
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: ldc 223
    //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnonnull +17 -> 23
    //   9: ldc 36
    //   11: ldc 225
    //   13: invokestatic 44	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: ldc 223
    //   18: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aconst_null
    //   22: areturn
    //   23: iload_1
    //   24: ifle +7 -> 31
    //   27: iload_2
    //   28: ifgt +44 -> 72
    //   31: ldc 36
    //   33: new 202	java/lang/StringBuilder
    //   36: dup
    //   37: ldc 227
    //   39: invokespecial 207	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   42: iload_1
    //   43: invokevirtual 230	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   46: ldc 232
    //   48: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: iload_2
    //   52: invokevirtual 230	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   55: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokestatic 44	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: aload_0
    //   62: invokestatic 238	com/tencent/mm/sdk/platformtools/d:am	(Landroid/graphics/Bitmap;)V
    //   65: ldc 223
    //   67: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: aconst_null
    //   71: areturn
    //   72: new 29	android/graphics/BitmapFactory$Options
    //   75: dup
    //   76: invokespecial 30	android/graphics/BitmapFactory$Options:<init>	()V
    //   79: astore 13
    //   81: aload 13
    //   83: aload_0
    //   84: invokevirtual 138	android/graphics/Bitmap:getHeight	()I
    //   87: putfield 241	android/graphics/BitmapFactory$Options:outHeight	I
    //   90: aload 13
    //   92: aload_0
    //   93: invokevirtual 135	android/graphics/Bitmap:getWidth	()I
    //   96: putfield 244	android/graphics/BitmapFactory$Options:outWidth	I
    //   99: ldc 36
    //   101: new 202	java/lang/StringBuilder
    //   104: dup
    //   105: ldc 246
    //   107: invokespecial 207	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   110: iload_2
    //   111: invokevirtual 230	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   114: ldc 248
    //   116: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: iload_1
    //   120: invokevirtual 230	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   123: ldc 250
    //   125: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: iload_3
    //   129: invokevirtual 253	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   132: ldc 255
    //   134: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: iload 4
    //   139: invokevirtual 253	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   142: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokestatic 257	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: aload 13
    //   150: getfield 241	android/graphics/BitmapFactory$Options:outHeight	I
    //   153: i2d
    //   154: dconst_1
    //   155: dmul
    //   156: iload_1
    //   157: i2d
    //   158: ddiv
    //   159: dstore 7
    //   161: aload 13
    //   163: getfield 244	android/graphics/BitmapFactory$Options:outWidth	I
    //   166: i2d
    //   167: dconst_1
    //   168: dmul
    //   169: iload_2
    //   170: i2d
    //   171: ddiv
    //   172: dstore 9
    //   174: ldc 36
    //   176: new 202	java/lang/StringBuilder
    //   179: dup
    //   180: ldc_w 259
    //   183: invokespecial 207	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   186: dload 9
    //   188: invokevirtual 262	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   191: ldc_w 264
    //   194: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: dload 7
    //   199: invokevirtual 262	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   202: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokestatic 217	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   208: iload_3
    //   209: ifeq +109 -> 318
    //   212: dload 7
    //   214: dload 9
    //   216: dcmpl
    //   217: ifle +94 -> 311
    //   220: dload 9
    //   222: dstore 5
    //   224: aload 13
    //   226: dload 5
    //   228: d2i
    //   229: putfield 267	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   232: aload 13
    //   234: getfield 267	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   237: iconst_1
    //   238: if_icmpgt +9 -> 247
    //   241: aload 13
    //   243: iconst_1
    //   244: putfield 267	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   247: aload 13
    //   249: getfield 241	android/graphics/BitmapFactory$Options:outHeight	I
    //   252: aload 13
    //   254: getfield 244	android/graphics/BitmapFactory$Options:outWidth	I
    //   257: imul
    //   258: aload 13
    //   260: getfield 267	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   263: idiv
    //   264: aload 13
    //   266: getfield 267	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   269: idiv
    //   270: ldc_w 268
    //   273: if_icmple +67 -> 340
    //   276: aload 13
    //   278: aload 13
    //   280: getfield 267	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   283: iconst_1
    //   284: iadd
    //   285: putfield 267	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   288: goto -41 -> 247
    //   291: astore 14
    //   293: aload_0
    //   294: astore 13
    //   296: aload 14
    //   298: astore_0
    //   299: aload 13
    //   301: invokestatic 238	com/tencent/mm/sdk/platformtools/d:am	(Landroid/graphics/Bitmap;)V
    //   304: ldc 223
    //   306: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   309: aload_0
    //   310: athrow
    //   311: dload 7
    //   313: dstore 5
    //   315: goto -91 -> 224
    //   318: dload 7
    //   320: dload 9
    //   322: dcmpg
    //   323: ifge +10 -> 333
    //   326: dload 9
    //   328: dstore 5
    //   330: goto -106 -> 224
    //   333: dload 7
    //   335: dstore 5
    //   337: goto -113 -> 224
    //   340: iload_3
    //   341: ifeq +360 -> 701
    //   344: dload 7
    //   346: dload 9
    //   348: dcmpl
    //   349: ifle +318 -> 667
    //   352: iload_2
    //   353: i2d
    //   354: dstore 5
    //   356: dload 5
    //   358: dconst_1
    //   359: dmul
    //   360: aload 13
    //   362: getfield 241	android/graphics/BitmapFactory$Options:outHeight	I
    //   365: i2d
    //   366: dmul
    //   367: aload 13
    //   369: getfield 244	android/graphics/BitmapFactory$Options:outWidth	I
    //   372: i2d
    //   373: ddiv
    //   374: invokestatic 272	java/lang/Math:ceil	(D)D
    //   377: d2i
    //   378: istore 12
    //   380: iload_2
    //   381: istore 11
    //   383: aload 13
    //   385: iconst_0
    //   386: putfield 34	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   389: ldc 36
    //   391: new 202	java/lang/StringBuilder
    //   394: dup
    //   395: ldc_w 274
    //   398: invokespecial 207	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   401: iload 11
    //   403: invokevirtual 230	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   406: ldc 248
    //   408: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: iload 12
    //   413: invokevirtual 230	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   416: ldc_w 276
    //   419: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: aload 13
    //   424: getfield 244	android/graphics/BitmapFactory$Options:outWidth	I
    //   427: invokevirtual 230	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   430: ldc 248
    //   432: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: aload 13
    //   437: getfield 241	android/graphics/BitmapFactory$Options:outHeight	I
    //   440: invokevirtual 230	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   443: ldc_w 278
    //   446: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: aload 13
    //   451: getfield 267	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   454: invokevirtual 230	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   457: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   460: invokestatic 257	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   463: aload_0
    //   464: iload 11
    //   466: iload 12
    //   468: iconst_1
    //   469: invokestatic 282	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   472: astore 14
    //   474: aload 14
    //   476: ifnull +403 -> 879
    //   479: aload 14
    //   481: astore 13
    //   483: iload 4
    //   485: ifeq +37 -> 522
    //   488: aload 14
    //   490: astore 13
    //   492: aload_0
    //   493: aload 14
    //   495: if_acmpeq +27 -> 522
    //   498: ldc 36
    //   500: ldc_w 284
    //   503: iconst_1
    //   504: anewarray 4	java/lang/Object
    //   507: dup
    //   508: iconst_0
    //   509: aload_0
    //   510: aastore
    //   511: invokestatic 58	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   514: aload_0
    //   515: invokevirtual 63	android/graphics/Bitmap:recycle	()V
    //   518: aload 14
    //   520: astore 13
    //   522: iload_3
    //   523: ifeq +350 -> 873
    //   526: iload_2
    //   527: istore 11
    //   529: aload 13
    //   531: invokevirtual 135	android/graphics/Bitmap:getWidth	()I
    //   534: iload_2
    //   535: if_icmpge +40 -> 575
    //   538: ldc 36
    //   540: ldc_w 286
    //   543: iconst_2
    //   544: anewarray 4	java/lang/Object
    //   547: dup
    //   548: iconst_0
    //   549: aload 13
    //   551: invokevirtual 135	android/graphics/Bitmap:getWidth	()I
    //   554: invokestatic 132	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   557: aastore
    //   558: dup
    //   559: iconst_1
    //   560: iload_2
    //   561: invokestatic 132	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   564: aastore
    //   565: invokestatic 288	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   568: aload 13
    //   570: invokevirtual 135	android/graphics/Bitmap:getWidth	()I
    //   573: istore 11
    //   575: iload_1
    //   576: istore_2
    //   577: aload 13
    //   579: invokevirtual 138	android/graphics/Bitmap:getHeight	()I
    //   582: iload_1
    //   583: if_icmpge +39 -> 622
    //   586: ldc 36
    //   588: ldc_w 290
    //   591: iconst_2
    //   592: anewarray 4	java/lang/Object
    //   595: dup
    //   596: iconst_0
    //   597: aload 13
    //   599: invokevirtual 138	android/graphics/Bitmap:getHeight	()I
    //   602: invokestatic 132	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   605: aastore
    //   606: dup
    //   607: iconst_1
    //   608: iload_1
    //   609: invokestatic 132	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   612: aastore
    //   613: invokestatic 288	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   616: aload 13
    //   618: invokevirtual 138	android/graphics/Bitmap:getHeight	()I
    //   621: istore_2
    //   622: aload 13
    //   624: aload 13
    //   626: invokevirtual 135	android/graphics/Bitmap:getWidth	()I
    //   629: iload 11
    //   631: isub
    //   632: iconst_1
    //   633: ishr
    //   634: aload 13
    //   636: invokevirtual 138	android/graphics/Bitmap:getHeight	()I
    //   639: iload_2
    //   640: isub
    //   641: iconst_1
    //   642: ishr
    //   643: iload 11
    //   645: iload_2
    //   646: invokestatic 293	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   649: astore_0
    //   650: aload_0
    //   651: ifnonnull +122 -> 773
    //   654: aload 13
    //   656: invokestatic 238	com/tencent/mm/sdk/platformtools/d:am	(Landroid/graphics/Bitmap;)V
    //   659: ldc 223
    //   661: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   664: aload 13
    //   666: areturn
    //   667: iload_1
    //   668: i2d
    //   669: dstore 5
    //   671: dload 5
    //   673: dconst_1
    //   674: dmul
    //   675: aload 13
    //   677: getfield 244	android/graphics/BitmapFactory$Options:outWidth	I
    //   680: i2d
    //   681: dmul
    //   682: aload 13
    //   684: getfield 241	android/graphics/BitmapFactory$Options:outHeight	I
    //   687: i2d
    //   688: ddiv
    //   689: invokestatic 272	java/lang/Math:ceil	(D)D
    //   692: d2i
    //   693: istore 11
    //   695: iload_1
    //   696: istore 12
    //   698: goto -315 -> 383
    //   701: dload 7
    //   703: dload 9
    //   705: dcmpg
    //   706: ifge +33 -> 739
    //   709: iload_2
    //   710: i2d
    //   711: dconst_1
    //   712: dmul
    //   713: aload 13
    //   715: getfield 241	android/graphics/BitmapFactory$Options:outHeight	I
    //   718: i2d
    //   719: dmul
    //   720: aload 13
    //   722: getfield 244	android/graphics/BitmapFactory$Options:outWidth	I
    //   725: i2d
    //   726: ddiv
    //   727: invokestatic 272	java/lang/Math:ceil	(D)D
    //   730: d2i
    //   731: istore 12
    //   733: iload_2
    //   734: istore 11
    //   736: goto -353 -> 383
    //   739: iload_1
    //   740: i2d
    //   741: dconst_1
    //   742: dmul
    //   743: aload 13
    //   745: getfield 244	android/graphics/BitmapFactory$Options:outWidth	I
    //   748: i2d
    //   749: dmul
    //   750: aload 13
    //   752: getfield 241	android/graphics/BitmapFactory$Options:outHeight	I
    //   755: i2d
    //   756: ddiv
    //   757: invokestatic 272	java/lang/Math:ceil	(D)D
    //   760: dstore 5
    //   762: dload 5
    //   764: d2i
    //   765: istore 11
    //   767: iload_1
    //   768: istore 12
    //   770: goto -387 -> 383
    //   773: iload 4
    //   775: ifeq +31 -> 806
    //   778: aload 13
    //   780: aload_0
    //   781: if_acmpeq +25 -> 806
    //   784: ldc 36
    //   786: ldc_w 295
    //   789: iconst_1
    //   790: anewarray 4	java/lang/Object
    //   793: dup
    //   794: iconst_0
    //   795: aload 13
    //   797: aastore
    //   798: invokestatic 58	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   801: aload 13
    //   803: invokevirtual 63	android/graphics/Bitmap:recycle	()V
    //   806: ldc 36
    //   808: new 202	java/lang/StringBuilder
    //   811: dup
    //   812: ldc_w 297
    //   815: invokespecial 207	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   818: aload_0
    //   819: invokevirtual 135	android/graphics/Bitmap:getWidth	()I
    //   822: invokevirtual 230	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   825: ldc 248
    //   827: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   830: aload_0
    //   831: invokevirtual 138	android/graphics/Bitmap:getHeight	()I
    //   834: invokevirtual 230	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   837: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   840: invokestatic 217	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   843: aload_0
    //   844: invokestatic 238	com/tencent/mm/sdk/platformtools/d:am	(Landroid/graphics/Bitmap;)V
    //   847: ldc 223
    //   849: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   852: aload_0
    //   853: areturn
    //   854: astore_0
    //   855: goto -556 -> 299
    //   858: astore 13
    //   860: aload_0
    //   861: astore 14
    //   863: aload 13
    //   865: astore_0
    //   866: aload 14
    //   868: astore 13
    //   870: goto -571 -> 299
    //   873: aload 13
    //   875: astore_0
    //   876: goto -33 -> 843
    //   879: aload_0
    //   880: astore 13
    //   882: goto -360 -> 522
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	885	0	paramBitmap	Bitmap
    //   0	885	1	paramInt1	int
    //   0	885	2	paramInt2	int
    //   0	885	3	paramBoolean1	boolean
    //   0	885	4	paramBoolean2	boolean
    //   222	541	5	d1	double
    //   159	543	7	d2	double
    //   172	532	9	d3	double
    //   381	385	11	i	int
    //   378	391	12	j	int
    //   79	723	13	localObject1	Object
    //   858	6	13	localObject2	Object
    //   868	13	13	localObject3	Object
    //   291	6	14	localObject4	Object
    //   472	395	14	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   31	61	291	finally
    //   72	208	291	finally
    //   224	247	291	finally
    //   247	288	291	finally
    //   356	380	291	finally
    //   383	474	291	finally
    //   498	518	291	finally
    //   671	695	291	finally
    //   709	733	291	finally
    //   739	762	291	finally
    //   529	575	854	finally
    //   577	622	854	finally
    //   622	650	854	finally
    //   784	806	854	finally
    //   806	843	858	finally
  }
  
  public static Bitmap a(Bitmap paramBitmap, boolean paramBoolean, float paramFloat)
  {
    AppMethodBeat.i(93365);
    paramBitmap = a(paramBitmap, paramBoolean, paramFloat, false);
    AppMethodBeat.o(93365);
    return paramBitmap;
  }
  
  public static Bitmap a(Bitmap paramBitmap, boolean paramBoolean1, float paramFloat, boolean paramBoolean2)
  {
    AppMethodBeat.i(93364);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      ab.e("MicroMsg.BitmapUtil", "getRoundedCornerBitmap in bitmap is null");
      AppMethodBeat.o(93364);
      return null;
    }
    am(paramBitmap);
    Bitmap localBitmap = createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888, paramBoolean2);
    if (localBitmap == null)
    {
      AppMethodBeat.o(93364);
      return null;
    }
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    Rect localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    RectF localRectF = new RectF(localRect);
    localPaint.setAntiAlias(true);
    localPaint.setDither(true);
    localPaint.setFilterBitmap(true);
    localCanvas.drawARGB(0, 0, 0, 0);
    localPaint.setColor(-4144960);
    localCanvas.drawRoundRect(localRectF, paramFloat, paramFloat, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(paramBitmap, localRect, localRect, localPaint);
    if (paramBoolean1)
    {
      ab.i("MicroMsg.BitmapUtil", "getRoundedCornerBitmap bitmap recycle %s", new Object[] { paramBitmap });
      paramBitmap.recycle();
    }
    am(localBitmap);
    paramBitmap = c.ag(localBitmap);
    AppMethodBeat.o(93364);
    return paramBitmap;
  }
  
  public static Bitmap a(Bitmap paramBitmap, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(139729);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      ab.e("MicroMsg.BitmapUtil", "getRoundedCornerBitmap in bitmap is null");
      AppMethodBeat.o(139729);
      return null;
    }
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length != 4))
    {
      ab.e("MicroMsg.BitmapUtil", "getRoundedCornerBitmap roundPxArray invalid");
      AppMethodBeat.o(139729);
      return null;
    }
    am(paramBitmap);
    Bitmap localBitmap = createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888, true);
    if (localBitmap == null)
    {
      AppMethodBeat.o(139729);
      return null;
    }
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    Rect localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    RectF localRectF = new RectF(localRect);
    localPaint.setAntiAlias(true);
    localPaint.setDither(true);
    localPaint.setFilterBitmap(true);
    localPaint.setStyle(Paint.Style.FILL);
    localCanvas.drawARGB(0, 0, 0, 0);
    localPaint.setColor(-4144960);
    float f2 = paramArrayOfFloat[0];
    float f3 = paramArrayOfFloat[1];
    float f5 = paramArrayOfFloat[2];
    float f4 = paramArrayOfFloat[3];
    paramArrayOfFloat = new Path();
    float f1 = f2;
    if (f2 < 0.0F) {
      f1 = 0.0F;
    }
    f2 = f3;
    if (f3 < 0.0F) {
      f2 = 0.0F;
    }
    f3 = f4;
    if (f4 < 0.0F) {
      f3 = 0.0F;
    }
    f4 = f5;
    if (f5 < 0.0F) {
      f4 = 0.0F;
    }
    paramArrayOfFloat.moveTo(localRectF.left + f1, localRectF.top);
    paramArrayOfFloat.lineTo(localRectF.right - f2, localRectF.top);
    paramArrayOfFloat.quadTo(localRectF.right, localRectF.top, localRectF.right, f2 + localRectF.top);
    paramArrayOfFloat.lineTo(localRectF.right, localRectF.bottom - f4);
    paramArrayOfFloat.quadTo(localRectF.right, localRectF.bottom, localRectF.right - f4, localRectF.bottom);
    paramArrayOfFloat.lineTo(localRectF.left + f3, localRectF.bottom);
    paramArrayOfFloat.quadTo(localRectF.left, localRectF.bottom, localRectF.left, localRectF.bottom - f3);
    paramArrayOfFloat.lineTo(localRectF.left, localRectF.top + f1);
    paramArrayOfFloat.quadTo(localRectF.left, localRectF.top, localRectF.left + f1, localRectF.top);
    paramArrayOfFloat.close();
    localCanvas.drawPath(paramArrayOfFloat, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(paramBitmap, localRect, localRect, localPaint);
    ab.i("MicroMsg.BitmapUtil", "getRoundedCornerBitmap bitmap recycle %s", new Object[] { paramBitmap });
    paramBitmap.recycle();
    am(localBitmap);
    paramBitmap = c.ag(localBitmap);
    AppMethodBeat.o(139729);
    return paramBitmap;
  }
  
  /* Error */
  private static Bitmap a(BitmapFactory.Options paramOptions, byte[] paramArrayOfByte, String paramString, Uri paramUri, boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: aconst_null
    //   4: astore 9
    //   6: ldc_w 400
    //   9: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: aload 9
    //   14: astore 8
    //   16: aload_1
    //   17: invokestatic 406	com/tencent/mm/sdk/platformtools/bo:ce	([B)Z
    //   20: ifeq +39 -> 59
    //   23: aload 9
    //   25: astore 8
    //   27: aload_2
    //   28: invokestatic 410	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   31: istore 7
    //   33: iload 7
    //   35: ifeq +24 -> 59
    //   38: aload_3
    //   39: ifnonnull +20 -> 59
    //   42: iload 5
    //   44: ifgt +15 -> 59
    //   47: aconst_null
    //   48: invokestatic 238	com/tencent/mm/sdk/platformtools/d:am	(Landroid/graphics/Bitmap;)V
    //   51: ldc_w 400
    //   54: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: aconst_null
    //   58: areturn
    //   59: aload 9
    //   61: astore 8
    //   63: aload_1
    //   64: invokestatic 406	com/tencent/mm/sdk/platformtools/bo:ce	([B)Z
    //   67: ifne +6 -> 73
    //   70: iconst_1
    //   71: istore 6
    //   73: iload 6
    //   75: ifeq +33 -> 108
    //   78: aload 9
    //   80: astore 8
    //   82: aload_1
    //   83: iconst_0
    //   84: aload_1
    //   85: arraylength
    //   86: aload_0
    //   87: invokestatic 414	com/tencent/mm/graphics/MMBitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   90: astore_2
    //   91: aload_2
    //   92: invokestatic 238	com/tencent/mm/sdk/platformtools/d:am	(Landroid/graphics/Bitmap;)V
    //   95: aload_2
    //   96: invokestatic 179	com/tencent/mm/sdk/platformtools/c:ag	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   99: astore_0
    //   100: ldc_w 400
    //   103: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: aload_0
    //   107: areturn
    //   108: iload 5
    //   110: ifle +23 -> 133
    //   113: aload 9
    //   115: astore 8
    //   117: invokestatic 420	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   120: invokevirtual 426	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   123: iload 5
    //   125: aload_0
    //   126: invokestatic 432	com/tencent/mm/compatible/g/a:decodeResource	(Landroid/content/res/Resources;ILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   129: astore_2
    //   130: goto -39 -> 91
    //   133: iload 4
    //   135: ifeq +68 -> 203
    //   138: aload_2
    //   139: invokestatic 410	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   142: istore 4
    //   144: iload 4
    //   146: ifeq +15 -> 161
    //   149: aconst_null
    //   150: invokestatic 238	com/tencent/mm/sdk/platformtools/d:am	(Landroid/graphics/Bitmap;)V
    //   153: ldc_w 400
    //   156: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   159: aconst_null
    //   160: areturn
    //   161: invokestatic 420	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   164: invokevirtual 436	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   167: aload_2
    //   168: invokevirtual 442	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   171: astore_1
    //   172: aload_1
    //   173: aconst_null
    //   174: aload_0
    //   175: invokestatic 53	com/tencent/mm/graphics/MMBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   178: astore_0
    //   179: aload_0
    //   180: astore_2
    //   181: aload_1
    //   182: ifnull -91 -> 91
    //   185: aload_0
    //   186: astore 8
    //   188: aload_1
    //   189: invokevirtual 68	java/io/InputStream:close	()V
    //   192: aload_0
    //   193: astore_2
    //   194: goto -103 -> 91
    //   197: astore_1
    //   198: aload_0
    //   199: astore_2
    //   200: goto -109 -> 91
    //   203: aload_3
    //   204: ifnull +17 -> 221
    //   207: invokestatic 420	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   210: invokevirtual 446	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   213: aload_3
    //   214: invokevirtual 452	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   217: astore_1
    //   218: goto -46 -> 172
    //   221: aload_2
    //   222: invokestatic 457	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   225: astore_1
    //   226: goto -54 -> 172
    //   229: astore_0
    //   230: aconst_null
    //   231: astore_1
    //   232: aload_1
    //   233: ifnull +11 -> 244
    //   236: aload 9
    //   238: astore 8
    //   240: aload_1
    //   241: invokevirtual 68	java/io/InputStream:close	()V
    //   244: aload 9
    //   246: astore 8
    //   248: ldc_w 400
    //   251: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   254: aload 9
    //   256: astore 8
    //   258: aload_0
    //   259: athrow
    //   260: astore_0
    //   261: aload 8
    //   263: invokestatic 238	com/tencent/mm/sdk/platformtools/d:am	(Landroid/graphics/Bitmap;)V
    //   266: ldc_w 400
    //   269: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   272: aload_0
    //   273: athrow
    //   274: astore_1
    //   275: goto -31 -> 244
    //   278: astore_0
    //   279: goto -47 -> 232
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	282	0	paramOptions	BitmapFactory.Options
    //   0	282	1	paramArrayOfByte	byte[]
    //   0	282	2	paramString	String
    //   0	282	3	paramUri	Uri
    //   0	282	4	paramBoolean	boolean
    //   0	282	5	paramInt	int
    //   1	73	6	i	int
    //   31	3	7	bool	boolean
    //   14	248	8	localObject1	Object
    //   4	251	9	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   188	192	197	java/io/IOException
    //   138	144	229	finally
    //   161	172	229	finally
    //   207	218	229	finally
    //   221	226	229	finally
    //   16	23	260	finally
    //   27	33	260	finally
    //   63	70	260	finally
    //   82	91	260	finally
    //   117	130	260	finally
    //   188	192	260	finally
    //   240	244	260	finally
    //   248	254	260	finally
    //   258	260	260	finally
    //   240	244	274	java/io/IOException
    //   172	179	278	finally
  }
  
  public static Bitmap a(InputStream paramInputStream, float paramFloat)
  {
    AppMethodBeat.i(93347);
    paramInputStream = a(paramInputStream, paramFloat, 0, 0);
    AppMethodBeat.o(93347);
    return paramInputStream;
  }
  
  public static Bitmap a(InputStream paramInputStream, float paramFloat, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93346);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    if (paramFloat != 0.0F) {
      localOptions.inDensity = ((int)(160.0F * paramFloat));
    }
    Object localObject;
    int i;
    int j;
    if (paramInt1 == 0)
    {
      localObject = paramInputStream;
      if (paramInt2 == 0) {}
    }
    else
    {
      i = paramInt1;
      if (paramInt1 == 0) {
        i = 2147483647;
      }
      paramInt1 = paramInt2;
      if (paramInt2 == 0) {
        paramInt1 = 2147483647;
      }
      if (!(paramInputStream instanceof FileInputStream)) {
        break label214;
      }
      localObject = new l((FileInputStream)paramInputStream);
      ((InputStream)localObject).mark(25165824);
      localOptions.inJustDecodeBounds = true;
      MMBitmapFactory.decodeStream((InputStream)localObject, null, localOptions);
      paramInt2 = localOptions.outWidth;
      j = localOptions.outHeight;
      if (((i <= paramInt1) || (paramInt2 >= j)) && ((i >= paramInt1) || (paramInt2 <= j))) {
        break label292;
      }
    }
    for (;;)
    {
      for (;;)
      {
        if ((j > i) || (paramInt2 > paramInt1)) {
          localOptions.inSampleSize = ((int)Math.max(j / i, paramInt2 / paramInt1));
        }
        localOptions.inJustDecodeBounds = false;
        try
        {
          ((InputStream)localObject).reset();
          localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
        }
        catch (IOException paramInputStream)
        {
          try
          {
            paramInputStream = MMBitmapFactory.decodeStream((InputStream)localObject, null, localOptions);
            AppMethodBeat.o(93346);
            return paramInputStream;
            label214:
            localObject = paramInputStream;
            if (paramInputStream.markSupported()) {
              break;
            }
            localObject = new BufferedInputStream(paramInputStream, 65536);
            break;
            paramInputStream = paramInputStream;
            ab.printErrStackTrace("MicroMsg.BitmapUtil", paramInputStream, "Failed seeking InputStream.", new Object[0]);
          }
          catch (OutOfMemoryError paramInputStream)
          {
            for (;;)
            {
              localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
              try
              {
                paramInputStream = MMBitmapFactory.decodeStream((InputStream)localObject, null, localOptions);
              }
              catch (OutOfMemoryError paramInputStream)
              {
                ab.e("MicroMsg.BitmapUtil", "decodeStream OutOfMemoryError return null");
                paramInputStream = null;
              }
            }
          }
        }
      }
      label292:
      int k = paramInt2;
      paramInt2 = j;
      j = k;
    }
  }
  
  @TargetApi(11)
  private static Bitmap a(InputStream paramInputStream, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    AppMethodBeat.i(138277);
    if ((paramInt3 <= 0) || (paramInt4 <= 0))
    {
      ab.e("MicroMsg.BitmapUtil", "extractThumbNail height:" + paramInt4 + " width:" + paramInt3);
      AppMethodBeat.o(138277);
      return null;
    }
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      ab.e("MicroMsg.BitmapUtil", "decode[%s] error, outHeight[%d] outWidth[%d]", new Object[] { paramInputStream, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(138277);
      return null;
    }
    double d2;
    double d3;
    double d1;
    for (;;)
    {
      try
      {
        localObject = new BitmapFactory.Options();
        ab.i("MicroMsg.BitmapUtil", "extractThumbNail: round=" + paramInt3 + "x" + paramInt4 + ", crop=" + paramBoolean);
        d2 = paramInt2 * 1.0D / paramInt4;
        d3 = paramInt1 * 1.0D / paramInt3;
        ab.d("MicroMsg.BitmapUtil", "extractThumbNail: extract beX = " + d3 + ", beY = " + d2);
        if (!paramBoolean) {
          break label320;
        }
        if (d2 > d3)
        {
          d1 = d3;
          ((BitmapFactory.Options)localObject).inSampleSize = ((int)d1);
          if (((BitmapFactory.Options)localObject).inSampleSize <= 1) {
            ((BitmapFactory.Options)localObject).inSampleSize = 1;
          }
          if (paramInt2 * paramInt1 / ((BitmapFactory.Options)localObject).inSampleSize / ((BitmapFactory.Options)localObject).inSampleSize <= 2764800) {
            break;
          }
          ((BitmapFactory.Options)localObject).inSampleSize += 1;
          continue;
        }
        d1 = d2;
      }
      catch (OutOfMemoryError paramInputStream)
      {
        ab.e("MicroMsg.BitmapUtil", "decode bitmap failed: " + paramInputStream.getMessage());
        AppMethodBeat.o(138277);
        return null;
      }
      continue;
      label320:
      if (d2 < d3) {
        d1 = d3;
      } else {
        d1 = d2;
      }
    }
    int j;
    int i;
    if (paramBoolean)
    {
      if (d2 > d3)
      {
        d1 = paramInt3 * 1.0D * paramInt2 / paramInt1;
        j = (int)Math.ceil(d1);
        i = paramInt3;
        break label968;
        if (Build.VERSION.SDK_INT >= 11) {
          ((BitmapFactory.Options)localObject).inMutable = true;
        }
        ab.i("MicroMsg.BitmapUtil", "bitmap required size=" + i + "x" + j + ", orig=" + paramInt1 + "x" + paramInt2 + ", sample=" + ((BitmapFactory.Options)localObject).inSampleSize);
        paramInputStream = MMBitmapFactory.decodeStream(paramInputStream, null, (BitmapFactory.Options)localObject);
        if (paramInputStream == null)
        {
          ab.e("MicroMsg.BitmapUtil", "bitmap decode failed");
          AppMethodBeat.o(138277);
          return null;
        }
      }
      else
      {
        d1 = paramInt4 * 1.0D * paramInt1 / paramInt2;
        i = (int)Math.ceil(d1);
        j = paramInt4;
        break label968;
      }
    }
    else
    {
      if (d2 < d3)
      {
        j = (int)Math.ceil(paramInt3 * 1.0D * paramInt2 / paramInt1);
        i = paramInt3;
        break label968;
      }
      i = (int)Math.ceil(paramInt4 * 1.0D * paramInt1 / paramInt2);
      j = paramInt4;
      break label968;
    }
    ab.d("MicroMsg.BitmapUtil", "bitmap decoded size=" + paramInputStream.getWidth() + "x" + paramInputStream.getHeight());
    Object localObject = Bitmap.createScaledBitmap(paramInputStream, i, j, true);
    label653:
    int k;
    if ((paramInputStream != localObject) && (localObject != null))
    {
      ab.i("MicroMsg.BitmapUtil", "extractThumbNail bitmap recycle adsfad. %s", new Object[] { paramInputStream });
      paramInputStream.recycle();
      paramInputStream = (InputStream)localObject;
      localObject = paramInputStream;
      if (paramBoolean)
      {
        paramInt2 = paramInt3;
        if (paramInputStream.getWidth() < paramInt3)
        {
          ab.e("MicroMsg.BitmapUtil", "bmw < width %d %d", new Object[] { Integer.valueOf(paramInputStream.getWidth()), Integer.valueOf(paramInt3) });
          paramInt2 = paramInputStream.getWidth();
        }
        paramInt3 = paramInt4;
        if (paramInputStream.getHeight() < paramInt4)
        {
          ab.e("MicroMsg.BitmapUtil", "bmh < height %d %d", new Object[] { Integer.valueOf(paramInputStream.getHeight()), Integer.valueOf(paramInt4) });
          paramInt3 = paramInputStream.getHeight();
        }
        paramInt4 = paramInputStream.getWidth() - paramInt2 >> 1;
        k = paramInputStream.getHeight() - paramInt3 >> 1;
        if (paramInt4 >= 0)
        {
          i = k;
          j = paramInt4;
          if (k >= 0) {}
        }
        else
        {
          ab.e("MicroMsg.BitmapUtil", "fix crop image error %d %d %d %d", new Object[] { Integer.valueOf(paramInputStream.getWidth()), Integer.valueOf(paramInputStream.getHeight()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
          paramInt1 = paramInt4;
          if (paramInt4 >= 0) {
            break label993;
          }
          paramInt1 = 0;
          break label993;
        }
      }
    }
    for (;;)
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInputStream, j, i, paramInt2, paramInt3);
      if (localBitmap == null)
      {
        AppMethodBeat.o(138277);
        return paramInputStream;
      }
      localObject = paramInputStream;
      if (localBitmap != paramInputStream)
      {
        ab.i("MicroMsg.BitmapUtil", "extractThumbNail bitmap recycle adsfaasdfad. %s", new Object[] { paramInputStream });
        paramInputStream.recycle();
        localObject = localBitmap;
      }
      ab.d("MicroMsg.BitmapUtil", "bitmap croped size=" + ((Bitmap)localObject).getWidth() + "x" + ((Bitmap)localObject).getHeight());
      am((Bitmap)localObject);
      paramInputStream = c.ag((Bitmap)localObject);
      AppMethodBeat.o(138277);
      return paramInputStream;
      break label653;
      label968:
      if (j > 0) {}
      for (;;)
      {
        if (i <= 0) {
          break label987;
        }
        break;
        j = 1;
      }
      label987:
      i = 1;
      break;
      label993:
      i = k;
      j = paramInt1;
      if (k < 0)
      {
        i = 0;
        j = paramInt1;
      }
    }
  }
  
  public static Bitmap a(String paramString, int paramInt1, int paramInt2, float paramFloat)
  {
    AppMethodBeat.i(93339);
    paramString = a(0, paramString, null, null, false, paramFloat, paramInt1, paramInt2);
    AppMethodBeat.o(93339);
    return paramString;
  }
  
  public static Bitmap a(int[] paramArrayOfInt, int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    AppMethodBeat.i(93379);
    paramConfig = createBitmap(paramInt1, paramInt2, paramConfig, false);
    if (paramConfig != null)
    {
      if ((paramInt1 == paramConfig.getWidth()) && (paramInt2 == paramConfig.getHeight())) {
        paramConfig.setPixels(paramArrayOfInt, 0, paramInt1, 0, 0, paramInt1, paramInt2);
      }
    }
    else
    {
      am(paramConfig);
      paramArrayOfInt = c.ag(paramConfig);
      AppMethodBeat.o(93379);
      return paramArrayOfInt;
    }
    AppMethodBeat.o(93379);
    return null;
  }
  
  public static void a(Bitmap paramBitmap, int paramInt, Bitmap.CompressFormat paramCompressFormat, OutputStream paramOutputStream, boolean paramBoolean)
  {
    AppMethodBeat.i(93361);
    a(paramBitmap, paramCompressFormat, paramInt, paramOutputStream);
    if (paramBoolean)
    {
      ab.i("MicroMsg.BitmapUtil", "saveBitmapToStream bitmap recycle. %s", new Object[] { paramBitmap });
      paramBitmap.recycle();
    }
    AppMethodBeat.o(93361);
  }
  
  public static void a(Bitmap paramBitmap, int paramInt, Bitmap.CompressFormat paramCompressFormat, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(93362);
    if (bo.isNullOrNil(paramString))
    {
      paramBitmap = new IOException("saveBitmapToImage pathName null or nil");
      AppMethodBeat.o(93362);
      throw paramBitmap;
    }
    ab.d("MicroMsg.BitmapUtil", "saving to ".concat(String.valueOf(paramString)));
    localObject2 = null;
    Object localObject1 = null;
    e.um(e.avK(paramString));
    try
    {
      OutputStream localOutputStream = e.M(paramString, false);
      localObject1 = localOutputStream;
      localObject2 = localOutputStream;
      a(paramBitmap, paramInt, paramCompressFormat, localOutputStream, paramBoolean);
      if (paramBoolean)
      {
        ab.i("MicroMsg.BitmapUtil", "bitmap recycle %s", new Object[] { paramBitmap.toString() });
        paramBitmap.recycle();
      }
      if (localOutputStream != null) {
        try
        {
          localOutputStream.close();
          AppMethodBeat.o(93362);
          return;
        }
        catch (IOException paramBitmap)
        {
          AppMethodBeat.o(93362);
          return;
        }
      }
      try
      {
        localObject2.close();
        AppMethodBeat.o(93362);
        throw paramCompressFormat;
        AppMethodBeat.o(93362);
        return;
      }
      catch (IOException paramBitmap)
      {
        break label229;
      }
    }
    catch (Exception paramCompressFormat)
    {
      localObject2 = localObject1;
      ab.printErrStackTrace("MicroMsg.BitmapUtil", paramCompressFormat, "saveBitmapToImage failed: %s", new Object[] { paramString });
      localObject2 = localObject1;
      paramCompressFormat = new IOException(paramCompressFormat);
      localObject2 = localObject1;
      AppMethodBeat.o(93362);
      localObject2 = localObject1;
      throw paramCompressFormat;
    }
    finally
    {
      if (paramBoolean)
      {
        ab.i("MicroMsg.BitmapUtil", "bitmap recycle %s", new Object[] { paramBitmap.toString() });
        paramBitmap.recycle();
      }
      if (localObject2 == null) {}
    }
  }
  
  public static void a(Canvas paramCanvas, View paramView)
  {
    AppMethodBeat.i(93373);
    paramView.draw(paramCanvas);
    paramView = w(paramView, (int)paramView.getX(), (int)paramView.getY());
    if (paramView.size() > 0)
    {
      paramView = paramView.iterator();
      while (paramView.hasNext())
      {
        v localv = (v)paramView.next();
        if ((localv != null) && (localv.yna != null))
        {
          Object localObject = localv.yna;
          localObject = ((TextureView)localObject).getBitmap(((TextureView)localObject).getWidth(), ((TextureView)localObject).getHeight());
          if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
            ab.e("MicroMsg.BitmapUtil", "get thumb bitmap null or is recycled");
          } else {
            paramCanvas.drawBitmap((Bitmap)localObject, localv.left, localv.top, null);
          }
        }
      }
    }
    AppMethodBeat.o(93373);
  }
  
  public static boolean a(Bitmap paramBitmap, Bitmap.CompressFormat paramCompressFormat, int paramInt, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(93385);
    if (paramBitmap == null)
    {
      ab.e("MicroMsg.BitmapUtil", "bitmap error %s", new Object[] { paramBitmap });
      AppMethodBeat.o(93385);
      return false;
    }
    boolean bool = paramBitmap.compress(paramCompressFormat, paramInt, paramOutputStream);
    if (!bool) {
      ab.e("MicroMsg.BitmapUtil", "compress error %s", new Object[] { bo.dtY().toString() });
    }
    AppMethodBeat.o(93385);
    return bool;
  }
  
  public static boolean a(String paramString1, int paramInt1, int paramInt2, Bitmap.CompressFormat paramCompressFormat, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(93321);
    boolean bool = b(paramString1, paramInt1, paramInt2, paramCompressFormat, paramInt3, paramString2);
    AppMethodBeat.o(93321);
    return bool;
  }
  
  public static boolean a(String paramString1, int paramInt1, int paramInt2, Bitmap.CompressFormat paramCompressFormat, int paramInt3, String paramString2, String paramString3)
  {
    AppMethodBeat.i(93320);
    boolean bool = b(paramString1, paramInt1, paramInt2, paramCompressFormat, paramInt3, paramString2 + paramString3);
    AppMethodBeat.o(93320);
    return bool;
  }
  
  private static boolean a(String paramString1, int paramInt1, int paramInt2, Bitmap.CompressFormat paramCompressFormat, int paramInt3, String paramString2, boolean paramBoolean, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(93326);
    paramBoolean = a(paramString1, paramInt1, paramInt2, paramCompressFormat, paramInt3, paramString2, paramBoolean, paramPInt1, paramPInt2, false);
    AppMethodBeat.o(93326);
    return paramBoolean;
  }
  
  private static boolean a(String paramString1, int paramInt1, int paramInt2, Bitmap.CompressFormat paramCompressFormat, int paramInt3, String paramString2, boolean paramBoolean1, PInt paramPInt1, PInt paramPInt2, boolean paramBoolean2)
  {
    AppMethodBeat.i(93328);
    try
    {
      Bitmap localBitmap1 = d(paramString1, paramInt1, paramInt2, paramBoolean2);
      if (localBitmap1 == null)
      {
        AppMethodBeat.o(93328);
        return false;
      }
      Bitmap localBitmap2 = localBitmap1;
      if (paramBoolean1) {
        localBitmap2 = b(localBitmap1, Exif.fromFile(paramString1).getOrientationInDegree());
      }
      paramPInt1.value = localBitmap2.getWidth();
      paramPInt2.value = localBitmap2.getHeight();
      a(localBitmap2, paramInt3, paramCompressFormat, paramString2, true);
      AppMethodBeat.o(93328);
      return true;
    }
    catch (Throwable paramString1)
    {
      ab.e("MicroMsg.BitmapUtil", "create thumbnail from orig failed: ".concat(String.valueOf(paramString2)));
      AppMethodBeat.o(93328);
    }
    return false;
  }
  
  public static boolean a(String paramString1, int paramInt1, int paramInt2, Bitmap.CompressFormat paramCompressFormat, String paramString2, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(93327);
    boolean bool = a(paramString1, paramInt1, paramInt2, paramCompressFormat, 80, paramString2, true, paramPInt1, paramPInt2, true);
    AppMethodBeat.o(93327);
    return bool;
  }
  
  public static boolean a(String paramString1, int paramInt1, Bitmap.CompressFormat paramCompressFormat, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(93359);
    paramString1 = a(paramString1, 0, 0, 0.0F);
    if (paramString1 == null)
    {
      ab.e("MicroMsg.BitmapUtil", "rotate: create bitmap fialed");
      AppMethodBeat.o(93359);
      return false;
    }
    float f1 = paramString1.getWidth();
    float f2 = paramString1.getHeight();
    Object localObject = new Matrix();
    ((Matrix)localObject).setRotate(paramInt1, f1 / 2.0F, f2 / 2.0F);
    localObject = Bitmap.createBitmap(paramString1, 0, 0, (int)f1, (int)f2, (Matrix)localObject, true);
    if (paramString1 != localObject)
    {
      ab.i("MicroMsg.BitmapUtil", "rotate bitmap recycle adjfjads fadsj fsadjf dsa. %s", new Object[] { paramString1.toString() });
      paramString1.recycle();
    }
    try
    {
      a((Bitmap)localObject, paramInt2, paramCompressFormat, paramString2, true);
      AppMethodBeat.o(93359);
      return true;
    }
    catch (IOException paramString1)
    {
      ab.printErrStackTrace("MicroMsg.BitmapUtil", paramString1, "create thumbnail from orig failed: ".concat(String.valueOf(paramString2)), new Object[0]);
      AppMethodBeat.o(93359);
    }
    return false;
  }
  
  public static boolean a(String paramString1, int paramInt, Bitmap.CompressFormat paramCompressFormat, String paramString2, String paramString3)
  {
    AppMethodBeat.i(93360);
    boolean bool = a(paramString1, paramInt, paramCompressFormat, 90, paramString2 + paramString3);
    AppMethodBeat.o(93360);
    return bool;
  }
  
  public static Bitmap aA(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93338);
    paramString = a(paramString, paramInt1, paramInt2, 0.0F);
    AppMethodBeat.o(93338);
    return paramString;
  }
  
  public static Bitmap aB(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93356);
    paramString = a(0, paramString, null, null, true, 0.0F, paramInt1, paramInt2);
    AppMethodBeat.o(93356);
    return paramString;
  }
  
  public static Bitmap ah(Bitmap paramBitmap)
  {
    float f1 = 2.5F;
    AppMethodBeat.i(93332);
    int j = 120;
    float f2;
    int i;
    if (paramBitmap.getHeight() >= paramBitmap.getWidth())
    {
      f2 = paramBitmap.getHeight() / paramBitmap.getWidth();
      if (f2 <= 2.0F)
      {
        i = (int)(paramBitmap.getWidth() * 120.0D / paramBitmap.getHeight());
        ab.d("MicroMsg.BitmapUtil", "bitmap decoded size=" + paramBitmap.getWidth() + "x" + paramBitmap.getHeight());
        Bitmap localBitmap2 = Bitmap.createScaledBitmap(paramBitmap, i, j, true);
        Bitmap localBitmap1 = paramBitmap;
        if (localBitmap2 != null)
        {
          localBitmap1 = paramBitmap;
          if (paramBitmap != localBitmap2)
          {
            ab.i("MicroMsg.BitmapUtil", "extractThumeNail bitmap recycle. %s", new Object[] { paramBitmap });
            paramBitmap.recycle();
            localBitmap1 = localBitmap2;
          }
        }
        AppMethodBeat.o(93332);
        return localBitmap1;
      }
      if (f2 <= 2.5D) {
        break label324;
      }
      paramBitmap = Bitmap.createBitmap(paramBitmap, 0, (paramBitmap.getHeight() - (int)(paramBitmap.getWidth() * 2.5F)) / 2, paramBitmap.getWidth(), (int)(paramBitmap.getWidth() * 2.5F));
    }
    for (;;)
    {
      j = (int)(f1 * 56.0F);
      i = 56;
      break;
      f2 = paramBitmap.getWidth() / paramBitmap.getHeight();
      if (f2 <= 2.0F)
      {
        j = (int)(paramBitmap.getHeight() * 120.0D / paramBitmap.getWidth());
        i = 120;
        break;
      }
      if (f2 > 2.5D) {
        paramBitmap = Bitmap.createBitmap(paramBitmap, (paramBitmap.getWidth() - (int)(paramBitmap.getHeight() * 2.5F)) / 2, 0, (int)(paramBitmap.getHeight() * 2.5F), paramBitmap.getHeight());
      }
      for (;;)
      {
        i = (int)(f1 * 56.0F);
        j = 56;
        break;
        f1 = f2;
      }
      label324:
      f1 = f2;
    }
  }
  
  public static byte[] ai(Bitmap paramBitmap)
  {
    AppMethodBeat.i(93367);
    paramBitmap = e(paramBitmap, 100);
    AppMethodBeat.o(93367);
    return paramBitmap;
  }
  
  public static byte[] aj(Bitmap paramBitmap)
  {
    AppMethodBeat.i(93369);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(93369);
      return new byte[0];
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    a(paramBitmap, Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    paramBitmap = localByteArrayOutputStream.toByteArray();
    try
    {
      localByteArrayOutputStream.close();
      AppMethodBeat.o(93369);
      return paramBitmap;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.BitmapUtil", localException, "", new Object[0]);
      }
    }
  }
  
  public static Bitmap ak(Bitmap paramBitmap)
  {
    AppMethodBeat.i(93382);
    int i = paramBitmap.getHeight();
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), i, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    ColorMatrix localColorMatrix = new ColorMatrix();
    localColorMatrix.setSaturation(0.0F);
    localPaint.setColorFilter(new ColorMatrixColorFilter(localColorMatrix));
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
    am(localBitmap);
    paramBitmap = c.ag(localBitmap);
    AppMethodBeat.o(93382);
    return paramBitmap;
  }
  
  public static Bitmap al(Bitmap paramBitmap)
  {
    AppMethodBeat.i(93383);
    int i = paramBitmap.getHeight();
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), i, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    ColorMatrix localColorMatrix = new ColorMatrix();
    localColorMatrix.set(new float[] { 0.9F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.9F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.9F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F });
    localPaint.setColorFilter(new ColorMatrixColorFilter(localColorMatrix));
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
    am(localBitmap);
    paramBitmap = c.ag(localBitmap);
    AppMethodBeat.o(93383);
    return paramBitmap;
  }
  
  private static void am(Bitmap paramBitmap)
  {
    AppMethodBeat.i(93386);
    if (paramBitmap != null)
    {
      paramBitmap.setDensity(ah.getContext().getResources().getDisplayMetrics().densityDpi);
      try
      {
        paramBitmap = Bitmap.class.getDeclaredMethod("setDefaultDensity", new Class[] { Integer.TYPE });
        paramBitmap.setAccessible(true);
        paramBitmap.invoke(null, new Object[] { Integer.valueOf(ah.getContext().getResources().getDisplayMetrics().densityDpi) });
        AppMethodBeat.o(93386);
        return;
      }
      catch (Exception paramBitmap)
      {
        ab.e("MicroMsg.BitmapUtil", "Exception:%s", new Object[] { paramBitmap });
      }
    }
    AppMethodBeat.o(93386);
  }
  
  public static BitmapFactory.Options aoT(String paramString)
  {
    AppMethodBeat.i(93318);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.BitmapUtil", "getImageOptions invalid path");
      AppMethodBeat.o(93318);
      return null;
    }
    try
    {
      paramString = e.openRead(paramString);
      paramString = E(paramString);
      AppMethodBeat.o(93318);
      return paramString;
    }
    catch (FileNotFoundException paramString)
    {
      ab.printErrStackTrace("MicroMsg.BitmapUtil", paramString, "Decode bitmap failed.", new Object[0]);
      paramString = new BitmapFactory.Options();
      AppMethodBeat.o(93318);
    }
    return paramString;
  }
  
  public static Point aoU(String paramString)
  {
    AppMethodBeat.i(93323);
    paramString = aoT(paramString);
    if (paramString != null)
    {
      paramString = new Point(paramString.outWidth, paramString.outHeight);
      AppMethodBeat.o(93323);
      return paramString;
    }
    AppMethodBeat.o(93323);
    return null;
  }
  
  public static Bitmap aoV(String paramString)
  {
    AppMethodBeat.i(93333);
    paramString = a(paramString, 0, 0, 0.0F);
    AppMethodBeat.o(93333);
    return paramString;
  }
  
  public static DisplayMetrics aow()
  {
    AppMethodBeat.i(93349);
    if (gjH == null) {
      gjH = ah.getContext().getResources().getDisplayMetrics();
    }
    DisplayMetrics localDisplayMetrics = gjH;
    AppMethodBeat.o(93349);
    return localDisplayMetrics;
  }
  
  public static Bitmap au(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(93319);
    try
    {
      Bitmap localBitmap = createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888, false);
      new Canvas(localBitmap).drawColor(paramInt1);
      localBitmap = c.ag(localBitmap);
      AppMethodBeat.o(93319);
      return localBitmap;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.BitmapUtil", localException, "", new Object[0]);
      AppMethodBeat.o(93319);
    }
    return null;
  }
  
  public static Bitmap av(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(93336);
    Bitmap localBitmap = a(paramInt1, null, null, null, false, 0.0F, paramInt2, paramInt3);
    AppMethodBeat.o(93336);
    return localBitmap;
  }
  
  public static Bitmap az(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93330);
    Bitmap localBitmap = d(paramString, paramInt1, paramInt2, false);
    if (localBitmap == null)
    {
      AppMethodBeat.o(93330);
      return null;
    }
    paramInt1 = Exif.fromFile(paramString).getOrientationInDegree();
    ab.d("MicroMsg.BitmapUtil", "degress:%d", new Object[] { Integer.valueOf(paramInt1) });
    paramString = b(localBitmap, paramInt1);
    AppMethodBeat.o(93330);
    return paramString;
  }
  
  private static Bitmap b(int paramInt1, String paramString, byte[] paramArrayOfByte, Uri paramUri, boolean paramBoolean, float paramFloat, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(93351);
    int i1 = 0;
    int n = 0;
    if ((paramInt2 == 0) && (paramInt3 == 0)) {}
    for (int j = 1; (paramInt2 < 0) || (paramInt3 < 0); j = 0)
    {
      AppMethodBeat.o(93351);
      return null;
    }
    int i = i1;
    for (;;)
    {
      BitmapFactory.Options localOptions2;
      int k;
      int m;
      try
      {
        localOptions2 = new BitmapFactory.Options();
        if (paramFloat != 0.0F)
        {
          i = i1;
          localOptions2.inDensity = ((int)(160.0F * paramFloat));
        }
        Object localObject = localOptions2;
        i = n;
        if (j == 0)
        {
          i = i1;
          localOptions2.inJustDecodeBounds = true;
          i = i1;
          a(localOptions2, paramArrayOfByte, paramString, paramUri, paramBoolean, paramInt1);
          i = i1;
          k = localOptions2.outWidth;
          i = i1;
          m = localOptions2.outHeight;
          i = i1;
          localOptions2 = new BitmapFactory.Options();
          i = i1;
          localOptions2.inPreferredConfig = Bitmap.Config.ARGB_8888;
          if (paramInt2 <= paramInt3) {
            break label398;
          }
          if (k < m) {
            break label412;
          }
          break label398;
          i = i1;
          localOptions2.inSampleSize = ((int)Math.max(m / paramInt2, k / paramInt3));
          i = i1;
          paramInt2 = localOptions2.inSampleSize;
          i = paramInt2;
          localObject = localOptions2;
        }
        localObject = a((BitmapFactory.Options)localObject, paramArrayOfByte, paramString, paramUri, paramBoolean, paramInt1);
        paramString = (String)localObject;
      }
      catch (Throwable localThrowable)
      {
        ab.printErrStackTrace("MicroMsg.BitmapUtil", localThrowable, "", new Object[0]);
        localOptions1 = new BitmapFactory.Options();
        if (paramFloat == 0.0F) {
          continue;
        }
        localOptions1.inDensity = ((int)(160.0F * paramFloat));
        localOptions1.inPreferredConfig = Bitmap.Config.RGB_565;
        if ((j != 0) || (i == 0)) {
          continue;
        }
        localOptions1.inSampleSize = i;
        try
        {
          paramString = a(localOptions1, paramArrayOfByte, paramString, paramUri, paramBoolean, paramInt1);
        }
        catch (Throwable paramString)
        {
          ab.printErrStackTrace("MicroMsg.BitmapUtil", paramString, "", new Object[0]);
          paramString = null;
        }
        continue;
      }
      finally
      {
        am(null);
        AppMethodBeat.o(93351);
      }
      am(paramString);
      paramString = c.ag(paramString);
      AppMethodBeat.o(93351);
      return paramString;
      BitmapFactory.Options localOptions1;
      label398:
      while ((paramInt2 >= paramInt3) || (k <= m))
      {
        i = k;
        k = m;
        m = i;
        break;
      }
      label412:
      if (m <= paramInt2)
      {
        localOptions1 = localOptions2;
        i = n;
        if (k <= paramInt3) {}
      }
    }
  }
  
  /* Error */
  public static Bitmap b(Bitmap paramBitmap, float paramFloat)
  {
    // Byte code:
    //   0: ldc_w 846
    //   3: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnull +13 -> 20
    //   10: fload_1
    //   11: ldc_w 847
    //   14: frem
    //   15: fconst_0
    //   16: fcmpl
    //   17: ifne +11 -> 28
    //   20: ldc_w 846
    //   23: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: aload_0
    //   27: areturn
    //   28: new 687	android/graphics/Matrix
    //   31: dup
    //   32: invokespecial 688	android/graphics/Matrix:<init>	()V
    //   35: astore_3
    //   36: aload_3
    //   37: invokevirtual 848	android/graphics/Matrix:reset	()V
    //   40: aload_3
    //   41: fload_1
    //   42: aload_0
    //   43: invokevirtual 135	android/graphics/Bitmap:getWidth	()I
    //   46: iconst_2
    //   47: idiv
    //   48: i2f
    //   49: aload_0
    //   50: invokevirtual 138	android/graphics/Bitmap:getHeight	()I
    //   53: iconst_2
    //   54: idiv
    //   55: i2f
    //   56: invokevirtual 692	android/graphics/Matrix:setRotate	(FFF)V
    //   59: aload_0
    //   60: iconst_0
    //   61: iconst_0
    //   62: aload_0
    //   63: invokevirtual 135	android/graphics/Bitmap:getWidth	()I
    //   66: aload_0
    //   67: invokevirtual 138	android/graphics/Bitmap:getHeight	()I
    //   70: aload_3
    //   71: iconst_1
    //   72: invokestatic 695	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   75: astore_3
    //   76: aload_3
    //   77: invokestatic 238	com/tencent/mm/sdk/platformtools/d:am	(Landroid/graphics/Bitmap;)V
    //   80: new 202	java/lang/StringBuilder
    //   83: dup
    //   84: ldc_w 850
    //   87: invokespecial 207	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   90: astore 4
    //   92: aload_3
    //   93: ifnonnull +101 -> 194
    //   96: iconst_1
    //   97: istore_2
    //   98: ldc 36
    //   100: aload 4
    //   102: iload_2
    //   103: invokevirtual 253	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   106: ldc_w 852
    //   109: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: fload_1
    //   113: invokevirtual 855	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   116: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 217	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: aload_0
    //   123: aload_3
    //   124: if_acmpeq +23 -> 147
    //   127: ldc 36
    //   129: ldc_w 857
    //   132: iconst_1
    //   133: anewarray 4	java/lang/Object
    //   136: dup
    //   137: iconst_0
    //   138: aload_0
    //   139: aastore
    //   140: invokestatic 58	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   143: aload_0
    //   144: invokevirtual 63	android/graphics/Bitmap:recycle	()V
    //   147: aload_3
    //   148: invokestatic 179	com/tencent/mm/sdk/platformtools/c:ag	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   151: astore_0
    //   152: ldc_w 846
    //   155: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   158: aload_0
    //   159: areturn
    //   160: astore 4
    //   162: aload_0
    //   163: astore_3
    //   164: aload 4
    //   166: astore_0
    //   167: ldc 36
    //   169: ldc_w 859
    //   172: iconst_1
    //   173: anewarray 4	java/lang/Object
    //   176: dup
    //   177: iconst_0
    //   178: aload_0
    //   179: invokestatic 863	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   182: aastore
    //   183: invokestatic 188	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   186: ldc_w 846
    //   189: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   192: aload_3
    //   193: areturn
    //   194: iconst_0
    //   195: istore_2
    //   196: goto -98 -> 98
    //   199: astore_0
    //   200: goto -33 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	paramBitmap	Bitmap
    //   0	203	1	paramFloat	float
    //   97	99	2	bool	boolean
    //   35	158	3	localObject	Object
    //   90	11	4	localStringBuilder	StringBuilder
    //   160	5	4	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   59	76	160	java/lang/Throwable
    //   76	80	199	java/lang/Throwable
  }
  
  public static Bitmap b(Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(139728);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(139728);
      return null;
    }
    if ((paramFloat1 == 0.0F) && (paramFloat2 > 0.999D) && (paramFloat2 < 1.001D) && (paramFloat3 > 0.999D) && (paramFloat3 < 1.001D))
    {
      AppMethodBeat.o(139728);
      return paramBitmap;
    }
    Object localObject = new Matrix();
    ((Matrix)localObject).reset();
    if (paramFloat1 != 0.0F) {
      ((Matrix)localObject).setRotate(paramFloat1, paramBitmap.getWidth() / 2, paramBitmap.getHeight() / 2);
    }
    if ((paramFloat2 < 0.999D) || (paramFloat2 > 1.001D) || (paramFloat3 < 0.999D) || (paramFloat3 > 1.001D)) {
      ((Matrix)localObject).postScale(paramFloat2, paramFloat3);
    }
    localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
    am((Bitmap)localObject);
    StringBuilder localStringBuilder = new StringBuilder("resultBmp is null: ");
    if (localObject == null) {}
    for (boolean bool = true;; bool = false)
    {
      ab.d("MicroMsg.BitmapUtil", bool + "  degree:" + paramFloat1);
      if (paramBitmap != localObject)
      {
        ab.i("MicroMsg.BitmapUtil", "rotateAndScale bitmap recycle asdfasdjfjasdfjsadfjdsa. %s", new Object[] { paramBitmap });
        paramBitmap.recycle();
      }
      paramBitmap = c.ag((Bitmap)localObject);
      AppMethodBeat.o(139728);
      return paramBitmap;
    }
  }
  
  public static Bitmap b(Bitmap paramBitmap, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(93363);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(93363);
      return null;
    }
    am(paramBitmap);
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f2 = Math.max(paramInt1 / i, paramInt2 / j);
    float f1 = i * f2;
    f2 = j * f2;
    float f3 = (paramInt1 - f1) / 2.0F;
    float f4 = (paramInt2 - f2) / 2.0F;
    RectF localRectF = new RectF(f3, f4, f1 + f3, f2 + f4);
    Bitmap.Config localConfig = paramBitmap.getConfig();
    Object localObject = localConfig;
    if (localConfig == null)
    {
      ab.w("MicroMsg.BitmapUtil", "get center crop bitmap, config is null");
      localObject = Bitmap.Config.ARGB_8888;
    }
    try
    {
      localObject = Bitmap.createBitmap(paramInt1, paramInt2, (Bitmap.Config)localObject);
      new Canvas((Bitmap)localObject).drawBitmap(paramBitmap, null, localRectF, null);
      if (paramBoolean)
      {
        ab.i("MicroMsg.BitmapUtil", "getCenterCropBitmap bitmap recycle %s", new Object[] { paramBitmap });
        paramBitmap.recycle();
      }
      am((Bitmap)localObject);
      paramBitmap = c.ag((Bitmap)localObject);
      AppMethodBeat.o(93363);
      return paramBitmap;
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.RGB_565);
      }
      catch (Throwable localThrowable2)
      {
        ab.e("MicroMsg.BitmapUtil", "BitmapUtil decode getCenterCropBitmap fail");
        AppMethodBeat.o(93363);
      }
    }
    return paramBitmap;
  }
  
  private static boolean b(String paramString1, int paramInt1, int paramInt2, Bitmap.CompressFormat paramCompressFormat, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(93324);
    boolean bool = a(paramString1, paramInt1, paramInt2, paramCompressFormat, paramInt3, paramString2, false, new PInt(), new PInt());
    AppMethodBeat.o(93324);
    return bool;
  }
  
  public static boolean b(String paramString1, int paramInt1, int paramInt2, Bitmap.CompressFormat paramCompressFormat, String paramString2, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(93331);
    if (bo.isNullOrNil(paramString1))
    {
      ab.w("MicroMsg.BitmapUtil", "file path is null.");
      AppMethodBeat.o(93331);
      return false;
    }
    if (!e.cN(paramString1))
    {
      ab.w("MicroMsg.BitmapUtil", "file did not exists.");
      AppMethodBeat.o(93331);
      return false;
    }
    int i = Exif.fromFile(paramString1).getOrientationInDegree();
    ab.d("MicroMsg.BitmapUtil", "degress:%d", new Object[] { Integer.valueOf(i) });
    if ((i == 90) || (i == 270)) {}
    for (paramString1 = b(d(paramString1, paramInt2, paramInt1, true), i); paramString1 == null; paramString1 = b(d(paramString1, paramInt1, paramInt2, true), i))
    {
      AppMethodBeat.o(93331);
      return false;
    }
    try
    {
      paramPInt1.value = paramString1.getWidth();
      paramPInt2.value = paramString1.getHeight();
      a(paramString1, 80, paramCompressFormat, paramString2, true);
      AppMethodBeat.o(93331);
      return true;
    }
    catch (IOException paramString1)
    {
      ab.e("MicroMsg.BitmapUtil", "create thumbnail from orig failed: ".concat(String.valueOf(paramString2)));
      AppMethodBeat.o(93331);
    }
    return false;
  }
  
  public static Bitmap bT(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(93344);
    paramArrayOfByte = decodeByteArray(paramArrayOfByte, 0, 0);
    AppMethodBeat.o(93344);
    return paramArrayOfByte;
  }
  
  public static String bU(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(93384);
    int i = 0;
    if (i < paramArrayOfByte.length - 1)
    {
      if ((paramArrayOfByte[i] & 0xFF) != 255) {
        break label159;
      }
      j = paramArrayOfByte[(i + 1)];
      if (((j & 0xFF) < 192) || ((j & 0xFF) > 207)) {
        break label159;
      }
      ab.d("MicroMsg.BitmapUtil", "match 0xff-" + Integer.toHexString(j & 0xFF) + "  at:" + i);
      if (i + 1 + 17 >= paramArrayOfByte.length) {
        ab.d("MicroMsg.BitmapUtil", "not engouht len at ".concat(String.valueOf(i)));
      }
    }
    else
    {
      AppMethodBeat.o(93384);
      return null;
    }
    int j = i + 2;
    if (paramArrayOfByte[(j + 7)] != 3) {
      ab.d("MicroMsg.BitmapUtil", "num != 3 at ".concat(String.valueOf(i)));
    }
    label159:
    int k;
    int m;
    label224:
    int i1;
    do
    {
      int n;
      int i2;
      do
      {
        do
        {
          for (;;)
          {
            i += 1;
            break;
            k = paramArrayOfByte[(j + 8)];
            m = paramArrayOfByte[(j + 11)];
            n = paramArrayOfByte[(j + 14)];
            if ((k == 1) || (m == 2) || (n == 3)) {
              break label224;
            }
            ab.d("MicroMsg.BitmapUtil", "Y/Cb/Cr Tag is not right at ".concat(String.valueOf(i)));
          }
          m = paramArrayOfByte[(j + 9)];
          i1 = paramArrayOfByte[(j + 12)];
          k = paramArrayOfByte[(j + 15)];
        } while ((m == 0) || (i1 == 0) || (k == 0));
        if ((m == i1) && (m == k))
        {
          AppMethodBeat.o(93384);
          return "YUV444";
        }
        j = (m & 0xFF) >> 4 & 0xF;
        m &= 0xF;
        n = (i1 & 0xFF) >> 4 & 0xF;
        i1 &= 0xF;
        i2 = (k & 0xFF) >> 4 & 0xF;
        k &= 0xF;
      } while ((n == 0) || (i2 == 0) || (i1 == 0) || (k == 0) || (j / n != 2) || (j / i2 != 2));
      if ((m / i1 == 2) && (m / k == 2))
      {
        AppMethodBeat.o(93384);
        return "YUV420";
      }
    } while ((m != i1) || (m != k));
    AppMethodBeat.o(93384);
    return "YUV422";
  }
  
  public static Bitmap c(Bitmap paramBitmap, float paramFloat)
  {
    AppMethodBeat.i(93381);
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawARGB(0, 0, 0, 0);
    Paint localPaint = new Paint();
    localPaint.setAlpha((int)(255.0F * paramFloat));
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
    am(localBitmap);
    paramBitmap = c.ag(localBitmap);
    AppMethodBeat.o(93381);
    return paramBitmap;
  }
  
  /* Error */
  public static void c(String paramString, PInt paramPInt1, PInt paramPInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc_w 944
    //   6: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: new 29	android/graphics/BitmapFactory$Options
    //   12: dup
    //   13: invokespecial 30	android/graphics/BitmapFactory$Options:<init>	()V
    //   16: astore 5
    //   18: aload 5
    //   20: iconst_1
    //   21: putfield 34	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   24: aload_0
    //   25: invokestatic 457	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   28: astore_0
    //   29: aload_0
    //   30: aconst_null
    //   31: aload 5
    //   33: invokestatic 53	com/tencent/mm/graphics/MMBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   36: astore_3
    //   37: aload_3
    //   38: astore 4
    //   40: aload 4
    //   42: astore_3
    //   43: aload_0
    //   44: ifnull +10 -> 54
    //   47: aload_0
    //   48: invokevirtual 68	java/io/InputStream:close	()V
    //   51: aload 4
    //   53: astore_3
    //   54: aload_3
    //   55: ifnull +23 -> 78
    //   58: ldc 36
    //   60: ldc_w 946
    //   63: iconst_1
    //   64: anewarray 4	java/lang/Object
    //   67: dup
    //   68: iconst_0
    //   69: aload_3
    //   70: aastore
    //   71: invokestatic 58	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   74: aload_3
    //   75: invokevirtual 63	android/graphics/Bitmap:recycle	()V
    //   78: aload_1
    //   79: aload 5
    //   81: getfield 244	android/graphics/BitmapFactory$Options:outWidth	I
    //   84: putfield 677	com/tencent/mm/pointers/PInt:value	I
    //   87: aload_2
    //   88: aload 5
    //   90: getfield 241	android/graphics/BitmapFactory$Options:outHeight	I
    //   93: putfield 677	com/tencent/mm/pointers/PInt:value	I
    //   96: ldc_w 944
    //   99: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: return
    //   103: astore_0
    //   104: ldc 36
    //   106: aload_0
    //   107: ldc_w 740
    //   110: iconst_0
    //   111: anewarray 4	java/lang/Object
    //   114: invokestatic 74	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   117: aload 4
    //   119: astore_3
    //   120: goto -66 -> 54
    //   123: astore_0
    //   124: aconst_null
    //   125: astore_0
    //   126: aload 4
    //   128: astore_3
    //   129: aload_0
    //   130: ifnull -76 -> 54
    //   133: aload_0
    //   134: invokevirtual 68	java/io/InputStream:close	()V
    //   137: aload 4
    //   139: astore_3
    //   140: goto -86 -> 54
    //   143: astore_0
    //   144: ldc 36
    //   146: aload_0
    //   147: ldc_w 740
    //   150: iconst_0
    //   151: anewarray 4	java/lang/Object
    //   154: invokestatic 74	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   157: aload 4
    //   159: astore_3
    //   160: goto -106 -> 54
    //   163: astore_0
    //   164: aconst_null
    //   165: astore_1
    //   166: aload_1
    //   167: ifnull +7 -> 174
    //   170: aload_1
    //   171: invokevirtual 68	java/io/InputStream:close	()V
    //   174: ldc_w 944
    //   177: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   180: aload_0
    //   181: athrow
    //   182: astore_1
    //   183: ldc 36
    //   185: aload_1
    //   186: ldc_w 740
    //   189: iconst_0
    //   190: anewarray 4	java/lang/Object
    //   193: invokestatic 74	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   196: goto -22 -> 174
    //   199: astore_1
    //   200: aload_0
    //   201: astore_2
    //   202: aload_1
    //   203: astore_0
    //   204: aload_2
    //   205: astore_1
    //   206: goto -40 -> 166
    //   209: astore_3
    //   210: goto -84 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	paramString	String
    //   0	213	1	paramPInt1	PInt
    //   0	213	2	paramPInt2	PInt
    //   36	124	3	localObject1	Object
    //   209	1	3	localFileNotFoundException	FileNotFoundException
    //   1	157	4	localObject2	Object
    //   16	73	5	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   47	51	103	java/io/IOException
    //   24	29	123	java/io/FileNotFoundException
    //   133	137	143	java/io/IOException
    //   24	29	163	finally
    //   170	174	182	java/io/IOException
    //   29	37	199	finally
    //   29	37	209	java/io/FileNotFoundException
  }
  
  public static boolean c(String paramString1, int paramInt1, int paramInt2, Bitmap.CompressFormat paramCompressFormat, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(93325);
    boolean bool = a(paramString1, paramInt1, paramInt2, paramCompressFormat, paramInt3, paramString2, true, new PInt(), new PInt());
    AppMethodBeat.o(93325);
    return bool;
  }
  
  public static Bitmap createBitmap(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    AppMethodBeat.i(156799);
    paramConfig = createBitmap(paramInt1, paramInt2, paramConfig, false);
    AppMethodBeat.o(156799);
    return paramConfig;
  }
  
  private static Bitmap createBitmap(int paramInt1, int paramInt2, Bitmap.Config paramConfig, boolean paramBoolean)
  {
    Object localObject = null;
    AppMethodBeat.i(93341);
    try
    {
      paramConfig = Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
      am(paramConfig);
      paramConfig = c.ag(paramConfig);
      AppMethodBeat.o(93341);
      return paramConfig;
    }
    catch (Throwable paramConfig)
    {
      for (;;)
      {
        if (paramBoolean)
        {
          AppMethodBeat.o(93341);
          return null;
        }
        try
        {
          paramConfig = aow();
          int j = paramInt1;
          int i = paramInt2;
          if (paramInt1 > paramConfig.widthPixels)
          {
            j = paramInt1;
            i = paramInt2;
            if (paramInt2 > paramConfig.heightPixels)
            {
              j = paramConfig.widthPixels;
              i = paramConfig.heightPixels;
            }
          }
          paramConfig = Bitmap.createBitmap(j, i, Bitmap.Config.RGB_565);
        }
        catch (Throwable paramConfig)
        {
          paramConfig = localObject;
        }
      }
    }
  }
  
  /* Error */
  public static Bitmap d(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 958
    //   3: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 410	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifeq +19 -> 29
    //   13: ldc 36
    //   15: ldc_w 960
    //   18: invokestatic 44	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: ldc_w 958
    //   24: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aconst_null
    //   28: areturn
    //   29: aload_0
    //   30: invokestatic 820	com/tencent/mm/sdk/platformtools/d:aoT	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   33: astore 4
    //   35: aload_0
    //   36: invokestatic 457	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   39: astore_0
    //   40: aload_0
    //   41: aload 4
    //   43: getfield 244	android/graphics/BitmapFactory$Options:outWidth	I
    //   46: aload 4
    //   48: getfield 241	android/graphics/BitmapFactory$Options:outHeight	I
    //   51: iload_2
    //   52: iload_1
    //   53: iload_3
    //   54: invokestatic 962	com/tencent/mm/sdk/platformtools/d:a	(Ljava/io/InputStream;IIIIZ)Landroid/graphics/Bitmap;
    //   57: astore 4
    //   59: aload_0
    //   60: ifnull +7 -> 67
    //   63: aload_0
    //   64: invokevirtual 68	java/io/InputStream:close	()V
    //   67: ldc_w 958
    //   70: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: aload 4
    //   75: areturn
    //   76: astore 4
    //   78: aconst_null
    //   79: astore_0
    //   80: ldc 36
    //   82: aload 4
    //   84: ldc_w 964
    //   87: iconst_0
    //   88: anewarray 4	java/lang/Object
    //   91: invokestatic 74	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   94: aload_0
    //   95: ifnull +7 -> 102
    //   98: aload_0
    //   99: invokevirtual 68	java/io/InputStream:close	()V
    //   102: ldc_w 958
    //   105: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   108: aconst_null
    //   109: areturn
    //   110: astore 4
    //   112: aconst_null
    //   113: astore_0
    //   114: aload_0
    //   115: ifnull +7 -> 122
    //   118: aload_0
    //   119: invokevirtual 68	java/io/InputStream:close	()V
    //   122: ldc_w 958
    //   125: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: aload 4
    //   130: athrow
    //   131: astore_0
    //   132: goto -65 -> 67
    //   135: astore_0
    //   136: goto -34 -> 102
    //   139: astore_0
    //   140: goto -18 -> 122
    //   143: astore 4
    //   145: goto -31 -> 114
    //   148: astore 4
    //   150: goto -36 -> 114
    //   153: astore 4
    //   155: goto -75 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	paramString	String
    //   0	158	1	paramInt1	int
    //   0	158	2	paramInt2	int
    //   0	158	3	paramBoolean	boolean
    //   33	41	4	localObject1	Object
    //   76	7	4	localFileNotFoundException1	FileNotFoundException
    //   110	19	4	localObject2	Object
    //   143	1	4	localObject3	Object
    //   148	1	4	localObject4	Object
    //   153	1	4	localFileNotFoundException2	FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   29	40	76	java/io/FileNotFoundException
    //   29	40	110	finally
    //   63	67	131	java/io/IOException
    //   98	102	135	java/io/IOException
    //   118	122	139	java/io/IOException
    //   40	59	143	finally
    //   80	94	148	finally
    //   40	59	153	java/io/FileNotFoundException
  }
  
  public static Bitmap decodeByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93343);
    if (bo.ce(paramArrayOfByte))
    {
      ab.w("MicroMsg.BitmapUtil", "error input: data is null");
      AppMethodBeat.o(93343);
      return null;
    }
    if ((paramInt1 < 0) || (paramInt2 < 0))
    {
      ab.w("MicroMsg.BitmapUtil", "error input: targetWidth %d, targetHeight %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(93343);
      return null;
    }
    paramArrayOfByte = a(0, null, paramArrayOfByte, null, false, 0.0F, paramInt1, paramInt2);
    AppMethodBeat.o(93343);
    return paramArrayOfByte;
  }
  
  /* Error */
  public static Bitmap decodeFile(String paramString, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: ldc_w 974
    //   3: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: astore_3
    //   8: aload_1
    //   9: ifnonnull +11 -> 20
    //   12: new 29	android/graphics/BitmapFactory$Options
    //   15: dup
    //   16: invokespecial 30	android/graphics/BitmapFactory$Options:<init>	()V
    //   19: astore_3
    //   20: aload_0
    //   21: invokestatic 457	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   24: astore_2
    //   25: aload_2
    //   26: astore_1
    //   27: aload_2
    //   28: aconst_null
    //   29: aload_3
    //   30: invokestatic 53	com/tencent/mm/graphics/MMBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   33: astore_3
    //   34: aload_2
    //   35: ifnull +7 -> 42
    //   38: aload_2
    //   39: invokevirtual 68	java/io/InputStream:close	()V
    //   42: ldc_w 974
    //   45: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: aload_3
    //   49: areturn
    //   50: astore_3
    //   51: aconst_null
    //   52: astore_2
    //   53: aload_2
    //   54: astore_1
    //   55: ldc 36
    //   57: ldc_w 976
    //   60: iconst_2
    //   61: anewarray 4	java/lang/Object
    //   64: dup
    //   65: iconst_0
    //   66: aload_0
    //   67: aastore
    //   68: dup
    //   69: iconst_1
    //   70: aload_3
    //   71: invokevirtual 977	java/io/IOException:getMessage	()Ljava/lang/String;
    //   74: aastore
    //   75: invokestatic 288	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   78: aload_2
    //   79: ifnull +7 -> 86
    //   82: aload_2
    //   83: invokevirtual 68	java/io/InputStream:close	()V
    //   86: ldc_w 974
    //   89: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: aconst_null
    //   93: areturn
    //   94: astore_0
    //   95: aconst_null
    //   96: astore_1
    //   97: aload_1
    //   98: ifnull +7 -> 105
    //   101: aload_1
    //   102: invokevirtual 68	java/io/InputStream:close	()V
    //   105: ldc_w 974
    //   108: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: aload_0
    //   112: athrow
    //   113: astore_0
    //   114: goto -72 -> 42
    //   117: astore_0
    //   118: goto -32 -> 86
    //   121: astore_1
    //   122: goto -17 -> 105
    //   125: astore_0
    //   126: goto -29 -> 97
    //   129: astore_3
    //   130: goto -77 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	paramString	String
    //   0	133	1	paramOptions	BitmapFactory.Options
    //   24	59	2	localInputStream	InputStream
    //   7	42	3	localObject	Object
    //   50	21	3	localIOException1	IOException
    //   129	1	3	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   20	25	50	java/io/IOException
    //   20	25	94	finally
    //   38	42	113	java/io/IOException
    //   82	86	117	java/io/IOException
    //   101	105	121	java/io/IOException
    //   27	34	125	finally
    //   55	78	125	finally
    //   27	34	129	java/io/IOException
  }
  
  public static Bitmap decodeStream(InputStream paramInputStream)
  {
    AppMethodBeat.i(93348);
    paramInputStream = a(paramInputStream, 0.0F, 0, 0);
    AppMethodBeat.o(93348);
    return paramInputStream;
  }
  
  public static void dsm() {}
  
  public static byte[] e(Bitmap paramBitmap, int paramInt)
  {
    AppMethodBeat.i(93368);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(93368);
      return new byte[0];
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    a(paramBitmap, Bitmap.CompressFormat.JPEG, paramInt, localByteArrayOutputStream);
    paramBitmap = localByteArrayOutputStream.toByteArray();
    try
    {
      localByteArrayOutputStream.close();
      AppMethodBeat.o(93368);
      return paramBitmap;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.BitmapUtil", localException, "", new Object[0]);
      }
    }
  }
  
  public static Bitmap eH(View paramView)
  {
    AppMethodBeat.i(93371);
    if (paramView == null)
    {
      AppMethodBeat.o(93371);
      return null;
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Drawable localDrawable = paramView.getBackground();
    if (localDrawable != null) {
      localDrawable.draw(localCanvas);
    }
    paramView.draw(localCanvas);
    am(localBitmap);
    paramView = c.ag(localBitmap);
    AppMethodBeat.o(93371);
    return paramView;
  }
  
  public static Bitmap eI(View paramView)
  {
    AppMethodBeat.i(93372);
    if (paramView == null)
    {
      AppMethodBeat.o(93372);
      return null;
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Drawable localDrawable = paramView.getBackground();
    if (localDrawable != null) {
      localDrawable.draw(localCanvas);
    }
    a(localCanvas, paramView);
    am(localBitmap);
    paramView = c.ag(localBitmap);
    AppMethodBeat.o(93372);
    return paramView;
  }
  
  public static Bitmap f(Bitmap paramBitmap, int paramInt)
  {
    AppMethodBeat.i(93375);
    ab.d("MicroMsg.BitmapUtil", "begin createChattingImage");
    long l1 = System.currentTimeMillis();
    if (paramBitmap == null)
    {
      ab.w("MicroMsg.BitmapUtil", "sourceBitmap is null .");
      AppMethodBeat.o(93375);
      return null;
    }
    am(paramBitmap);
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    if ((i <= 0) || (j <= 0))
    {
      ab.w("MicroMsg.BitmapUtil", "sourceBitmap width or height is 0.");
      AppMethodBeat.o(93375);
      return null;
    }
    long l2 = System.currentTimeMillis();
    Bitmap localBitmap;
    try
    {
      localBitmap = createBitmap(i, j, Bitmap.Config.ARGB_8888, false);
      localObject = (NinePatchDrawable)ah.getContext().getResources().getDrawable(paramInt);
      ((NinePatchDrawable)localObject).setBounds(0, 0, i, j);
      ((NinePatchDrawable)localObject).draw(new Canvas(localBitmap));
      ab.d("MicroMsg.BitmapUtil", "create nine patch bitmap " + (System.currentTimeMillis() - l2));
      if (localBitmap == null)
      {
        ab.e("MicroMsg.BitmapUtil", "[createChattingImage] maskBitmap is null.");
        AppMethodBeat.o(93375);
        return null;
      }
    }
    catch (Exception paramBitmap)
    {
      ab.e("MicroMsg.BitmapUtil", "[createChattingImage] create nine pathc bitmap faild.");
      AppMethodBeat.o(93375);
      return null;
    }
    paramInt = localBitmap.getWidth();
    int k = localBitmap.getHeight();
    if ((paramInt <= 0) || (k <= 0))
    {
      ab.w("MicroMsg.BitmapUtil", "maskBitmap width or height is 0.");
      AppMethodBeat.o(93375);
      return null;
    }
    if ((k != j) || (paramInt != i))
    {
      ab.e("MicroMsg.BitmapUtil", "maskHeiht maskWidth != height width.");
      AppMethodBeat.o(93375);
      return null;
    }
    Object localObject = new int[i * j];
    int[] arrayOfInt = new int[paramInt * k];
    paramBitmap.getPixels((int[])localObject, 0, i, 0, 0, i, j);
    localBitmap.getPixels(arrayOfInt, 0, i, 0, 0, i, j);
    l2 = System.currentTimeMillis();
    paramInt = 0;
    for (;;)
    {
      try
      {
        if (paramInt < arrayOfInt.length)
        {
          if (arrayOfInt[paramInt] == -16777216) {
            break label491;
          }
          if (arrayOfInt[paramInt] == 0) {
            localObject[paramInt] = 0;
          } else if (arrayOfInt[paramInt] != -1) {
            localObject[paramInt] &= arrayOfInt[paramInt];
          }
        }
      }
      catch (Exception paramBitmap)
      {
        ab.e("MicroMsg.BitmapUtil", paramBitmap.toString());
        ab.d("MicroMsg.BitmapUtil", "meger pixels  " + (System.currentTimeMillis() - l2));
        l2 = System.currentTimeMillis();
        localBitmap.setPixels((int[])localObject, 0, i, 0, 0, i, j);
        ab.d("MicroMsg.BitmapUtil", "setPixels " + (System.currentTimeMillis() - l2));
        ab.d("MicroMsg.BitmapUtil", "createTime" + (System.currentTimeMillis() - l1));
        am(localBitmap);
        paramBitmap = c.ag(localBitmap);
        AppMethodBeat.o(93375);
        return paramBitmap;
      }
      label491:
      paramInt += 1;
    }
  }
  
  public static Bitmap g(Bitmap paramBitmap, int paramInt)
  {
    AppMethodBeat.i(93380);
    if (paramBitmap == null)
    {
      ab.w("MicroMsg.BitmapUtil", "fastblur: but sentBitmap is null");
      AppMethodBeat.o(93380);
      return null;
    }
    paramBitmap = paramBitmap.copy(paramBitmap.getConfig(), true);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(93380);
      return null;
    }
    int i13 = paramBitmap.getWidth();
    int i14 = paramBitmap.getHeight();
    int[] arrayOfInt1 = new int[i13 * i14];
    ab.e("pix", i13 + " " + i14 + " " + arrayOfInt1.length);
    paramBitmap.getPixels(arrayOfInt1, 0, i13, 0, 0, i13, i14);
    int i19 = i13 - 1;
    int i15 = i14 - 1;
    int i16 = i13 * i14;
    int i17 = paramInt + paramInt + 1;
    int[] arrayOfInt2 = new int[i16];
    int[] arrayOfInt3 = new int[i16];
    int[] arrayOfInt4 = new int[i16];
    int[] arrayOfInt5 = new int[Math.max(i13, i14)];
    int i = i17 + 1 >> 1;
    int j = i * i;
    int[] arrayOfInt6 = new int[j * 256];
    i = 0;
    while (i < j * 256)
    {
      arrayOfInt6[i] = (i / j);
      i += 1;
    }
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { i17, 3 });
    int i18 = paramInt + 1;
    int i6 = 0;
    int i5 = 0;
    int i7 = 0;
    int i8;
    int i4;
    int i2;
    int m;
    int i3;
    int n;
    int k;
    int i1;
    int i9;
    int[] arrayOfInt7;
    int i12;
    int i10;
    int i11;
    while (i6 < i14)
    {
      i8 = -paramInt;
      i4 = 0;
      i2 = 0;
      m = 0;
      i3 = 0;
      n = 0;
      k = 0;
      i = 0;
      j = 0;
      i1 = 0;
      if (i8 <= paramInt)
      {
        i9 = arrayOfInt1[(Math.min(i19, Math.max(i8, 0)) + i7)];
        arrayOfInt7 = arrayOfInt[(i8 + paramInt)];
        arrayOfInt7[0] = ((0xFF0000 & i9) >> 16);
        arrayOfInt7[1] = ((0xFF00 & i9) >> 8);
        arrayOfInt7[2] = (i9 & 0xFF);
        i9 = i18 - Math.abs(i8);
        i1 += arrayOfInt7[0] * i9;
        i += arrayOfInt7[1] * i9;
        j += i9 * arrayOfInt7[2];
        if (i8 > 0)
        {
          i4 += arrayOfInt7[0];
          i2 += arrayOfInt7[1];
          m += arrayOfInt7[2];
        }
        for (;;)
        {
          i8 += 1;
          break;
          i3 += arrayOfInt7[0];
          n += arrayOfInt7[1];
          k += arrayOfInt7[2];
        }
      }
      i12 = 0;
      i9 = i4;
      i8 = i2;
      i4 = m;
      i10 = i3;
      i11 = n;
      n = paramInt;
      i3 = i1;
      i1 = j;
      i2 = i;
      m = k;
      i = i11;
      j = i10;
      k = i12;
      while (k < i13)
      {
        arrayOfInt2[i7] = arrayOfInt6[i3];
        arrayOfInt3[i7] = arrayOfInt6[i2];
        arrayOfInt4[i7] = arrayOfInt6[i1];
        arrayOfInt7 = arrayOfInt[((n - paramInt + i17) % i17)];
        i11 = arrayOfInt7[0];
        i10 = arrayOfInt7[1];
        int i21 = arrayOfInt7[2];
        if (i6 == 0) {
          arrayOfInt5[k] = Math.min(k + paramInt + 1, i19);
        }
        i12 = arrayOfInt1[(arrayOfInt5[k] + i5)];
        arrayOfInt7[0] = ((0xFF0000 & i12) >> 16);
        arrayOfInt7[1] = ((0xFF00 & i12) >> 8);
        arrayOfInt7[2] = (i12 & 0xFF);
        i9 += arrayOfInt7[0];
        i8 += arrayOfInt7[1];
        i4 = arrayOfInt7[2] + i4;
        i3 = i3 - j + i9;
        i2 = i2 - i + i8;
        i1 = i1 - m + i4;
        n = (n + 1) % i17;
        arrayOfInt7 = arrayOfInt[(n % i17)];
        int i20 = arrayOfInt7[0];
        i12 = arrayOfInt7[1];
        m = m - i21 + arrayOfInt7[2];
        int i23 = arrayOfInt7[0];
        int i22 = arrayOfInt7[1];
        i21 = arrayOfInt7[2];
        i7 += 1;
        k += 1;
        i9 -= i23;
        i8 -= i22;
        i4 -= i21;
        j = j - i11 + i20;
        i = i - i10 + i12;
      }
      i6 += 1;
      i5 += i13;
    }
    i = 0;
    while (i < i13)
    {
      i7 = -paramInt * i13;
      i6 = -paramInt;
      i4 = 0;
      k = 0;
      j = 0;
      m = 0;
      n = 0;
      i1 = 0;
      i2 = 0;
      i3 = 0;
      i5 = 0;
      if (i6 <= paramInt)
      {
        i9 = Math.max(0, i7) + i;
        arrayOfInt7 = arrayOfInt[(i6 + paramInt)];
        arrayOfInt7[0] = arrayOfInt2[i9];
        arrayOfInt7[1] = arrayOfInt3[i9];
        arrayOfInt7[2] = arrayOfInt4[i9];
        i10 = i18 - Math.abs(i6);
        i5 += arrayOfInt2[i9] * i10;
        i8 = i2 + arrayOfInt3[i9] * i10;
        i3 += arrayOfInt4[i9] * i10;
        if (i6 > 0)
        {
          i4 += arrayOfInt7[0];
          k += arrayOfInt7[1];
          j += arrayOfInt7[2];
        }
        for (;;)
        {
          i2 = i7;
          if (i6 < i15) {
            i2 = i7 + i13;
          }
          i6 += 1;
          i7 = i2;
          i2 = i8;
          break;
          m += arrayOfInt7[0];
          n += arrayOfInt7[1];
          i1 += arrayOfInt7[2];
        }
      }
      i9 = 0;
      i8 = i4;
      i4 = i;
      i6 = paramInt;
      i7 = i5;
      i5 = i4;
      i4 = i9;
      while (i4 < i14)
      {
        arrayOfInt1[i5] = (0xFF000000 & arrayOfInt1[i5] | arrayOfInt6[i7] << 16 | arrayOfInt6[i2] << 8 | arrayOfInt6[i3]);
        arrayOfInt7 = arrayOfInt[((i6 - paramInt + i17) % i17)];
        i11 = arrayOfInt7[0];
        i10 = arrayOfInt7[1];
        i9 = arrayOfInt7[2];
        if (i == 0) {
          arrayOfInt5[i4] = (Math.min(i4 + i18, i15) * i13);
        }
        i12 = arrayOfInt5[i4] + i;
        arrayOfInt7[0] = arrayOfInt2[i12];
        arrayOfInt7[1] = arrayOfInt3[i12];
        arrayOfInt7[2] = arrayOfInt4[i12];
        i8 += arrayOfInt7[0];
        k += arrayOfInt7[1];
        j += arrayOfInt7[2];
        i7 = i7 - m + i8;
        i2 = i2 - n + k;
        i3 = i3 - i1 + j;
        i6 = (i6 + 1) % i17;
        arrayOfInt7 = arrayOfInt[i6];
        m = m - i11 + arrayOfInt7[0];
        n = n - i10 + arrayOfInt7[1];
        i1 = i1 - i9 + arrayOfInt7[2];
        i8 -= arrayOfInt7[0];
        i9 = arrayOfInt7[1];
        j -= arrayOfInt7[2];
        i5 += i13;
        i4 += 1;
        k -= i9;
      }
      i += 1;
    }
    ab.e("pix", i13 + " " + i14 + " " + i16);
    paramBitmap.setPixels(arrayOfInt1, 0, i13, 0, 0, i13, i14);
    am(paramBitmap);
    paramBitmap = c.ag(paramBitmap);
    AppMethodBeat.o(93380);
    return paramBitmap;
  }
  
  public static Bitmap hj(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93376);
    if ((paramInt1 < 0) || (paramInt2 < 0))
    {
      ab.w("MicroMsg.BitmapUtil", "createLocation fail. srcResId or maskResId is null,or width/height <0");
      AppMethodBeat.o(93376);
      return null;
    }
    long l = System.currentTimeMillis();
    Bitmap localBitmap = c.ag(createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888, false));
    am(localBitmap);
    NinePatchDrawable localNinePatchDrawable = (NinePatchDrawable)ah.getContext().getResources().getDrawable(2130839294);
    localNinePatchDrawable.setBounds(0, 0, paramInt1, paramInt2);
    localNinePatchDrawable.draw(new Canvas(localBitmap));
    ab.d("MicroMsg.BitmapUtil", "create nine patch bitmap " + (System.currentTimeMillis() - l));
    localBitmap = f(localBitmap, 2130839603);
    AppMethodBeat.o(93376);
    return localBitmap;
  }
  
  public static Bitmap l(String paramString, float paramFloat)
  {
    AppMethodBeat.i(93337);
    paramString = a(paramString, 0, 0, paramFloat);
    AppMethodBeat.o(93337);
    return paramString;
  }
  
  public static Bitmap n(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(93335);
    Bitmap localBitmap = a(paramInt, null, null, null, false, paramFloat, 0, 0);
    AppMethodBeat.o(93335);
    return localBitmap;
  }
  
  public static Bitmap n(Uri paramUri)
  {
    AppMethodBeat.i(93340);
    paramUri = a(0, null, null, paramUri, false, 0.0F, 0, 0);
    AppMethodBeat.o(93340);
    return paramUri;
  }
  
  public static Bitmap p(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(93377);
    if ((paramString == null) || (paramString.equals("")) || (paramInt1 < 0) || (paramInt2 < 0) || (paramInt3 < 0))
    {
      ab.w("MicroMsg.BitmapUtil", "createLocation fail. srcResId or maskResId is null,or width/height <0");
      AppMethodBeat.o(93377);
      return null;
    }
    paramString = c.h(decodeByteArray(e.i(paramString, 0, -1), 0, 0), paramString);
    if ((paramString == null) || (paramString.isRecycled()))
    {
      AppMethodBeat.o(93377);
      return null;
    }
    long l = System.currentTimeMillis();
    Bitmap localBitmap = c.ag(createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888, false));
    am(localBitmap);
    Canvas localCanvas = new Canvas(localBitmap);
    ab.d("MicroMsg.BitmapUtil", "bm size w %d h %d target w %d h %d", new Object[] { Integer.valueOf(paramString.getWidth()), Integer.valueOf(paramString.getHeight()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    localCanvas.drawBitmap(paramString, null, new Rect(0, 0, paramInt2, paramInt3), new Paint());
    ab.d("MicroMsg.BitmapUtil", "create nine patch bitmap " + (System.currentTimeMillis() - l));
    paramString = f(localBitmap, paramInt1);
    AppMethodBeat.o(93377);
    return paramString;
  }
  
  public static Bitmap u(Drawable paramDrawable)
  {
    AppMethodBeat.i(93366);
    if ((paramDrawable instanceof BitmapDrawable))
    {
      paramDrawable = ((BitmapDrawable)paramDrawable).getBitmap();
      AppMethodBeat.o(93366);
      return paramDrawable;
    }
    Bitmap localBitmap = createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888, false);
    Canvas localCanvas = new Canvas(localBitmap);
    paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
    paramDrawable.draw(localCanvas);
    am(localBitmap);
    paramDrawable = c.ag(localBitmap);
    AppMethodBeat.o(93366);
    return paramDrawable;
  }
  
  private static List<v> w(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93374);
    ArrayList localArrayList = new ArrayList();
    if ((paramView instanceof TextureView))
    {
      v localv = new v();
      localv.yna = ((TextureView)paramView);
      localv.left = paramInt1;
      localv.top = paramInt2;
      localArrayList.add(localv);
    }
    for (;;)
    {
      AppMethodBeat.o(93374);
      return localArrayList;
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        int i = 0;
        while (i < paramView.getChildCount())
        {
          localArrayList.addAll(w(paramView.getChildAt(i), (int)(paramView.getX() + paramInt1), (int)(paramView.getY() + paramInt2)));
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.d
 * JD-Core Version:    0.7.0.1
 */