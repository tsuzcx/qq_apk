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
import com.tencent.mm.b.b;
import com.tencent.mm.b.q;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.vfs.i;
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

public final class g
{
  private static DisplayMetrics iNB = null;
  
  public static Bitmap A(Drawable paramDrawable)
  {
    AppMethodBeat.i(156152);
    if ((paramDrawable instanceof BitmapDrawable))
    {
      paramDrawable = ((BitmapDrawable)paramDrawable).getBitmap();
      AppMethodBeat.o(156152);
      return paramDrawable;
    }
    Bitmap localBitmap = createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888, false);
    Canvas localCanvas = new Canvas(localBitmap);
    paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
    paramDrawable.draw(localCanvas);
    aE(localBitmap);
    paramDrawable = f.ay(localBitmap);
    AppMethodBeat.o(156152);
    return paramDrawable;
  }
  
  public static byte[] Bitmap2Bytes(Bitmap paramBitmap)
  {
    AppMethodBeat.i(156153);
    paramBitmap = j(paramBitmap, 100);
    AppMethodBeat.o(156153);
    return paramBitmap;
  }
  
  private static boolean CU(long paramLong)
  {
    AppMethodBeat.i(156168);
    if (200L != -1L)
    {
      if (System.currentTimeMillis() - paramLong > 200L)
      {
        AppMethodBeat.o(156168);
        return true;
      }
      AppMethodBeat.o(156168);
      return false;
    }
    AppMethodBeat.o(156168);
    return false;
  }
  
  public static int O(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(156103);
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
    AppMethodBeat.o(156103);
    return j;
  }
  
  public static Bitmap R(InputStream paramInputStream)
  {
    AppMethodBeat.i(156115);
    paramInputStream = a(0, null, null, null, paramInputStream, false, 0.0F, 0, 0);
    AppMethodBeat.o(156115);
    return paramInputStream;
  }
  
  public static int a(boolean paramBoolean, String paramString1, int paramInt1, int paramInt2, Bitmap.CompressFormat paramCompressFormat, int paramInt3, String paramString2, b paramb)
  {
    int i = -1;
    AppMethodBeat.i(156110);
    Bitmap localBitmap = d(paramString1, paramInt1, paramInt2, false);
    if (localBitmap == null)
    {
      AppMethodBeat.o(156110);
      return -1;
    }
    paramString1 = a(localBitmap, Exif.fromFile(paramString1).getOrientationInDegree());
    if (paramb != null) {
      paramb.Ka();
    }
    if (paramBoolean)
    {
      paramInt1 = i;
      if (paramString1 == null) {}
    }
    try
    {
      if (paramString1.isRecycled()) {}
      for (paramInt1 = i;; paramInt1 = MMJpegOptim.compressByQualityOptim(paramString1, paramInt3, false, q.k(paramString2, false)))
      {
        ad.i("MicroMsg.BitmapUtil", "dkimgopt compressByQualityOptim ret:%d  [%d,%d,%d] path:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramString1.getWidth()), Integer.valueOf(paramString1.getHeight()), paramString2 });
        AppMethodBeat.o(156110);
        return paramInt1;
      }
      a(paramString1, paramInt3, paramCompressFormat, paramString2, true);
      AppMethodBeat.o(156110);
      return 1;
    }
    catch (IOException paramString1)
    {
      ad.e("MicroMsg.BitmapUtil", "create thumbnail from orig failed: ".concat(String.valueOf(paramString2)));
      AppMethodBeat.o(156110);
    }
    return -2;
  }
  
  private static Bitmap a(int paramInt1, String paramString, byte[] paramArrayOfByte, Uri paramUri, InputStream paramInputStream, boolean paramBoolean, float paramFloat, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(156136);
    int i1 = 0;
    int n = 0;
    if ((paramInt2 == 0) && (paramInt3 == 0)) {}
    for (int j = 1; (paramInt2 < 0) || (paramInt3 < 0); j = 0)
    {
      AppMethodBeat.o(156136);
      return null;
    }
    if (paramInputStream != null) {}
    for (;;)
    {
      int i;
      BitmapFactory.Options localOptions2;
      int k;
      int m;
      try
      {
        if (paramInputStream.markSupported()) {
          break label473;
        }
        if ((paramInputStream instanceof FileInputStream))
        {
          localObject1 = new o((FileInputStream)paramInputStream);
          paramInputStream = (InputStream)localObject1;
          i = i1;
        }
      }
      catch (Throwable localThrowable1)
      {
        Object localObject1;
        paramInt2 = 0;
        ad.printErrStackTrace("MicroMsg.BitmapUtil", localThrowable1, "", new Object[0]);
        BitmapFactory.Options localOptions1 = new BitmapFactory.Options();
        if (paramFloat != 0.0F) {
          localOptions1.inDensity = ((int)(160.0F * paramFloat));
        }
        localOptions1.inPreferredConfig = Bitmap.Config.RGB_565;
        if ((j == 0) && (paramInt2 != 0)) {
          localOptions1.inSampleSize = paramInt2;
        }
        try
        {
          paramString = a(localOptions1, paramArrayOfByte, paramString, paramUri, paramInputStream, paramBoolean, paramInt1);
        }
        catch (Throwable paramString)
        {
          ad.printErrStackTrace("MicroMsg.BitmapUtil", paramString, "", new Object[0]);
          paramString = null;
        }
        continue;
      }
      finally
      {
        aE(null);
        AppMethodBeat.o(156136);
      }
      try
      {
        localOptions2 = new BitmapFactory.Options();
        if (paramFloat != 0.0F)
        {
          i = i1;
          localOptions2.inDensity = ((int)(160.0F * paramFloat));
        }
        localObject1 = localOptions2;
        i = n;
        if (j == 0)
        {
          i = i1;
          localOptions2.inJustDecodeBounds = true;
          i = i1;
          a(localOptions2, paramArrayOfByte, paramString, paramUri, paramInputStream, paramBoolean, paramInt1);
          i = i1;
          k = localOptions2.outWidth;
          i = i1;
          m = localOptions2.outHeight;
          i = i1;
          localOptions2 = new BitmapFactory.Options();
          i = i1;
          localOptions2.inPreferredConfig = Bitmap.Config.ARGB_8888;
          if (paramInt2 <= paramInt3) {
            break label476;
          }
          if (k < m) {
            break label490;
          }
          break label476;
          i = i1;
          localOptions2.inSampleSize = ((int)Math.max(m / paramInt2, k / paramInt3));
          i = i1;
          paramInt2 = localOptions2.inSampleSize;
          i = paramInt2;
          localObject1 = localOptions2;
        }
        localObject1 = a((BitmapFactory.Options)localObject1, paramArrayOfByte, paramString, paramUri, paramInputStream, paramBoolean, paramInt1);
        paramString = (String)localObject1;
        aE(paramString);
        paramString = f.ay(paramString);
        AppMethodBeat.o(156136);
        return paramString;
      }
      catch (Throwable localThrowable2)
      {
        paramInt2 = i;
        continue;
      }
      if (!paramInputStream.markSupported())
      {
        localObject1 = new BufferedInputStream(paramInputStream);
        paramInputStream = (InputStream)localObject1;
      }
      else
      {
        label473:
        label476:
        while ((paramInt2 >= paramInt3) || (k <= m))
        {
          i = k;
          k = m;
          m = i;
          break label490;
          break;
        }
        label490:
        if (m <= paramInt2)
        {
          Object localObject2 = localOptions2;
          i = n;
          if (k <= paramInt3) {}
        }
      }
    }
  }
  
  private static Bitmap a(int paramInt1, String paramString, byte[] paramArrayOfByte, Uri paramUri, boolean paramBoolean, float paramFloat, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(156135);
    paramString = a(paramInt1, paramString, paramArrayOfByte, paramUri, null, paramBoolean, paramFloat, paramInt2, paramInt3);
    AppMethodBeat.o(156135);
    return paramString;
  }
  
  /* Error */
  public static Bitmap a(Bitmap paramBitmap, float paramFloat)
  {
    // Byte code:
    //   0: ldc_w 258
    //   3: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnull +13 -> 20
    //   10: fload_1
    //   11: ldc_w 259
    //   14: frem
    //   15: fconst_0
    //   16: fcmpl
    //   17: ifne +11 -> 28
    //   20: ldc_w 258
    //   23: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: aload_0
    //   27: areturn
    //   28: new 261	android/graphics/Matrix
    //   31: dup
    //   32: invokespecial 262	android/graphics/Matrix:<init>	()V
    //   35: astore_3
    //   36: aload_3
    //   37: invokevirtual 265	android/graphics/Matrix:reset	()V
    //   40: aload_3
    //   41: fload_1
    //   42: aload_0
    //   43: invokevirtual 159	android/graphics/Bitmap:getWidth	()I
    //   46: iconst_2
    //   47: idiv
    //   48: i2f
    //   49: aload_0
    //   50: invokevirtual 160	android/graphics/Bitmap:getHeight	()I
    //   53: iconst_2
    //   54: idiv
    //   55: i2f
    //   56: invokevirtual 269	android/graphics/Matrix:setRotate	(FFF)V
    //   59: aload_0
    //   60: iconst_0
    //   61: iconst_0
    //   62: aload_0
    //   63: invokevirtual 159	android/graphics/Bitmap:getWidth	()I
    //   66: aload_0
    //   67: invokevirtual 160	android/graphics/Bitmap:getHeight	()I
    //   70: aload_3
    //   71: iconst_1
    //   72: invokestatic 272	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   75: astore_3
    //   76: aload_3
    //   77: invokestatic 73	com/tencent/mm/sdk/platformtools/g:aE	(Landroid/graphics/Bitmap;)V
    //   80: new 274	java/lang/StringBuilder
    //   83: dup
    //   84: ldc_w 276
    //   87: invokespecial 279	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   90: astore 4
    //   92: aload_3
    //   93: ifnonnull +101 -> 194
    //   96: iconst_1
    //   97: istore_2
    //   98: ldc 150
    //   100: aload 4
    //   102: iload_2
    //   103: invokevirtual 283	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   106: ldc_w 285
    //   109: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: fload_1
    //   113: invokevirtual 291	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   116: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 297	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: aload_0
    //   123: aload_3
    //   124: if_acmpeq +23 -> 147
    //   127: ldc 150
    //   129: ldc_w 299
    //   132: iconst_1
    //   133: anewarray 4	java/lang/Object
    //   136: dup
    //   137: iconst_0
    //   138: aload_0
    //   139: aastore
    //   140: invokestatic 165	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   143: aload_0
    //   144: invokevirtual 302	android/graphics/Bitmap:recycle	()V
    //   147: aload_3
    //   148: invokestatic 79	com/tencent/mm/sdk/platformtools/f:ay	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   151: astore_0
    //   152: ldc_w 258
    //   155: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   158: aload_0
    //   159: areturn
    //   160: astore 4
    //   162: aload_0
    //   163: astore_3
    //   164: aload 4
    //   166: astore_0
    //   167: ldc 150
    //   169: ldc_w 304
    //   172: iconst_1
    //   173: anewarray 4	java/lang/Object
    //   176: dup
    //   177: iconst_0
    //   178: aload_0
    //   179: invokestatic 310	com/tencent/mm/sdk/platformtools/bt:n	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   182: aastore
    //   183: invokestatic 312	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   186: ldc_w 258
    //   189: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  /* Error */
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: ldc_w 314
    //   3: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnonnull +19 -> 26
    //   10: ldc 150
    //   12: ldc_w 316
    //   15: invokestatic 195	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   18: ldc_w 314
    //   21: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aconst_null
    //   25: areturn
    //   26: iload_1
    //   27: ifle +7 -> 34
    //   30: iload_2
    //   31: ifgt +47 -> 78
    //   34: ldc 150
    //   36: new 274	java/lang/StringBuilder
    //   39: dup
    //   40: ldc_w 318
    //   43: invokespecial 279	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   46: iload_1
    //   47: invokevirtual 321	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   50: ldc_w 323
    //   53: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: iload_2
    //   57: invokevirtual 321	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   60: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 195	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: aload_0
    //   67: invokestatic 73	com/tencent/mm/sdk/platformtools/g:aE	(Landroid/graphics/Bitmap;)V
    //   70: ldc_w 314
    //   73: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: aconst_null
    //   77: areturn
    //   78: new 212	android/graphics/BitmapFactory$Options
    //   81: dup
    //   82: invokespecial 213	android/graphics/BitmapFactory$Options:<init>	()V
    //   85: astore 13
    //   87: aload 13
    //   89: aload_0
    //   90: invokevirtual 160	android/graphics/Bitmap:getHeight	()I
    //   93: putfield 231	android/graphics/BitmapFactory$Options:outHeight	I
    //   96: aload 13
    //   98: aload_0
    //   99: invokevirtual 159	android/graphics/Bitmap:getWidth	()I
    //   102: putfield 228	android/graphics/BitmapFactory$Options:outWidth	I
    //   105: ldc 150
    //   107: new 274	java/lang/StringBuilder
    //   110: dup
    //   111: ldc_w 325
    //   114: invokespecial 279	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   117: iload_2
    //   118: invokevirtual 321	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   121: ldc_w 327
    //   124: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: iload_1
    //   128: invokevirtual 321	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   131: ldc_w 329
    //   134: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: iload_3
    //   138: invokevirtual 283	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   141: ldc_w 331
    //   144: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: iload 4
    //   149: invokevirtual 283	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   152: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokestatic 333	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   158: aload 13
    //   160: getfield 231	android/graphics/BitmapFactory$Options:outHeight	I
    //   163: i2d
    //   164: dconst_1
    //   165: dmul
    //   166: iload_1
    //   167: i2d
    //   168: ddiv
    //   169: dstore 7
    //   171: aload 13
    //   173: getfield 228	android/graphics/BitmapFactory$Options:outWidth	I
    //   176: i2d
    //   177: dconst_1
    //   178: dmul
    //   179: iload_2
    //   180: i2d
    //   181: ddiv
    //   182: dstore 9
    //   184: ldc 150
    //   186: new 274	java/lang/StringBuilder
    //   189: dup
    //   190: ldc_w 335
    //   193: invokespecial 279	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   196: dload 9
    //   198: invokevirtual 338	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   201: ldc_w 340
    //   204: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: dload 7
    //   209: invokevirtual 338	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   212: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokestatic 297	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   218: iload_3
    //   219: ifeq +110 -> 329
    //   222: dload 7
    //   224: dload 9
    //   226: dcmpl
    //   227: ifle +95 -> 322
    //   230: dload 9
    //   232: dstore 5
    //   234: aload 13
    //   236: dload 5
    //   238: d2i
    //   239: putfield 241	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   242: aload 13
    //   244: getfield 241	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   247: iconst_1
    //   248: if_icmpgt +9 -> 257
    //   251: aload 13
    //   253: iconst_1
    //   254: putfield 241	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   257: aload 13
    //   259: getfield 231	android/graphics/BitmapFactory$Options:outHeight	I
    //   262: aload 13
    //   264: getfield 228	android/graphics/BitmapFactory$Options:outWidth	I
    //   267: imul
    //   268: aload 13
    //   270: getfield 241	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   273: idiv
    //   274: aload 13
    //   276: getfield 241	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   279: idiv
    //   280: ldc_w 341
    //   283: if_icmple +68 -> 351
    //   286: aload 13
    //   288: aload 13
    //   290: getfield 241	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   293: iconst_1
    //   294: iadd
    //   295: putfield 241	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   298: goto -41 -> 257
    //   301: astore 14
    //   303: aload_0
    //   304: astore 13
    //   306: aload 14
    //   308: astore_0
    //   309: aload 13
    //   311: invokestatic 73	com/tencent/mm/sdk/platformtools/g:aE	(Landroid/graphics/Bitmap;)V
    //   314: ldc_w 314
    //   317: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   320: aload_0
    //   321: athrow
    //   322: dload 7
    //   324: dstore 5
    //   326: goto -92 -> 234
    //   329: dload 7
    //   331: dload 9
    //   333: dcmpg
    //   334: ifge +10 -> 344
    //   337: dload 9
    //   339: dstore 5
    //   341: goto -107 -> 234
    //   344: dload 7
    //   346: dstore 5
    //   348: goto -114 -> 234
    //   351: iload_3
    //   352: ifeq +363 -> 715
    //   355: dload 7
    //   357: dload 9
    //   359: dcmpl
    //   360: ifle +321 -> 681
    //   363: iload_2
    //   364: i2d
    //   365: dstore 5
    //   367: dload 5
    //   369: dconst_1
    //   370: dmul
    //   371: aload 13
    //   373: getfield 231	android/graphics/BitmapFactory$Options:outHeight	I
    //   376: i2d
    //   377: dmul
    //   378: aload 13
    //   380: getfield 228	android/graphics/BitmapFactory$Options:outWidth	I
    //   383: i2d
    //   384: ddiv
    //   385: invokestatic 345	java/lang/Math:ceil	(D)D
    //   388: d2i
    //   389: istore 12
    //   391: iload_2
    //   392: istore 11
    //   394: aload 13
    //   396: iconst_0
    //   397: putfield 222	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   400: ldc 150
    //   402: new 274	java/lang/StringBuilder
    //   405: dup
    //   406: ldc_w 347
    //   409: invokespecial 279	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   412: iload 11
    //   414: invokevirtual 321	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   417: ldc_w 327
    //   420: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: iload 12
    //   425: invokevirtual 321	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   428: ldc_w 349
    //   431: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: aload 13
    //   436: getfield 228	android/graphics/BitmapFactory$Options:outWidth	I
    //   439: invokevirtual 321	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   442: ldc_w 327
    //   445: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: aload 13
    //   450: getfield 231	android/graphics/BitmapFactory$Options:outHeight	I
    //   453: invokevirtual 321	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   456: ldc_w 351
    //   459: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: aload 13
    //   464: getfield 241	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   467: invokevirtual 321	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   470: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   473: invokestatic 333	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   476: aload_0
    //   477: iload 11
    //   479: iload 12
    //   481: iconst_1
    //   482: invokestatic 355	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   485: astore 14
    //   487: aload 14
    //   489: ifnull +406 -> 895
    //   492: aload 14
    //   494: astore 13
    //   496: iload 4
    //   498: ifeq +37 -> 535
    //   501: aload 14
    //   503: astore 13
    //   505: aload_0
    //   506: aload 14
    //   508: if_acmpeq +27 -> 535
    //   511: ldc 150
    //   513: ldc_w 357
    //   516: iconst_1
    //   517: anewarray 4	java/lang/Object
    //   520: dup
    //   521: iconst_0
    //   522: aload_0
    //   523: aastore
    //   524: invokestatic 165	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   527: aload_0
    //   528: invokevirtual 302	android/graphics/Bitmap:recycle	()V
    //   531: aload 14
    //   533: astore 13
    //   535: iload_3
    //   536: ifeq +353 -> 889
    //   539: iload_2
    //   540: istore 11
    //   542: aload 13
    //   544: invokevirtual 159	android/graphics/Bitmap:getWidth	()I
    //   547: iload_2
    //   548: if_icmpge +40 -> 588
    //   551: ldc 150
    //   553: ldc_w 359
    //   556: iconst_2
    //   557: anewarray 4	java/lang/Object
    //   560: dup
    //   561: iconst_0
    //   562: aload 13
    //   564: invokevirtual 159	android/graphics/Bitmap:getWidth	()I
    //   567: invokestatic 158	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   570: aastore
    //   571: dup
    //   572: iconst_1
    //   573: iload_2
    //   574: invokestatic 158	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   577: aastore
    //   578: invokestatic 361	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   581: aload 13
    //   583: invokevirtual 159	android/graphics/Bitmap:getWidth	()I
    //   586: istore 11
    //   588: iload_1
    //   589: istore_2
    //   590: aload 13
    //   592: invokevirtual 160	android/graphics/Bitmap:getHeight	()I
    //   595: iload_1
    //   596: if_icmpge +39 -> 635
    //   599: ldc 150
    //   601: ldc_w 363
    //   604: iconst_2
    //   605: anewarray 4	java/lang/Object
    //   608: dup
    //   609: iconst_0
    //   610: aload 13
    //   612: invokevirtual 160	android/graphics/Bitmap:getHeight	()I
    //   615: invokestatic 158	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   618: aastore
    //   619: dup
    //   620: iconst_1
    //   621: iload_1
    //   622: invokestatic 158	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   625: aastore
    //   626: invokestatic 361	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   629: aload 13
    //   631: invokevirtual 160	android/graphics/Bitmap:getHeight	()I
    //   634: istore_2
    //   635: aload 13
    //   637: aload 13
    //   639: invokevirtual 159	android/graphics/Bitmap:getWidth	()I
    //   642: iload 11
    //   644: isub
    //   645: iconst_1
    //   646: ishr
    //   647: aload 13
    //   649: invokevirtual 160	android/graphics/Bitmap:getHeight	()I
    //   652: iload_2
    //   653: isub
    //   654: iconst_1
    //   655: ishr
    //   656: iload 11
    //   658: iload_2
    //   659: invokestatic 366	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   662: astore_0
    //   663: aload_0
    //   664: ifnonnull +123 -> 787
    //   667: aload 13
    //   669: invokestatic 73	com/tencent/mm/sdk/platformtools/g:aE	(Landroid/graphics/Bitmap;)V
    //   672: ldc_w 314
    //   675: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   678: aload 13
    //   680: areturn
    //   681: iload_1
    //   682: i2d
    //   683: dstore 5
    //   685: dload 5
    //   687: dconst_1
    //   688: dmul
    //   689: aload 13
    //   691: getfield 228	android/graphics/BitmapFactory$Options:outWidth	I
    //   694: i2d
    //   695: dmul
    //   696: aload 13
    //   698: getfield 231	android/graphics/BitmapFactory$Options:outHeight	I
    //   701: i2d
    //   702: ddiv
    //   703: invokestatic 345	java/lang/Math:ceil	(D)D
    //   706: d2i
    //   707: istore 11
    //   709: iload_1
    //   710: istore 12
    //   712: goto -318 -> 394
    //   715: dload 7
    //   717: dload 9
    //   719: dcmpg
    //   720: ifge +33 -> 753
    //   723: iload_2
    //   724: i2d
    //   725: dconst_1
    //   726: dmul
    //   727: aload 13
    //   729: getfield 231	android/graphics/BitmapFactory$Options:outHeight	I
    //   732: i2d
    //   733: dmul
    //   734: aload 13
    //   736: getfield 228	android/graphics/BitmapFactory$Options:outWidth	I
    //   739: i2d
    //   740: ddiv
    //   741: invokestatic 345	java/lang/Math:ceil	(D)D
    //   744: d2i
    //   745: istore 12
    //   747: iload_2
    //   748: istore 11
    //   750: goto -356 -> 394
    //   753: iload_1
    //   754: i2d
    //   755: dconst_1
    //   756: dmul
    //   757: aload 13
    //   759: getfield 228	android/graphics/BitmapFactory$Options:outWidth	I
    //   762: i2d
    //   763: dmul
    //   764: aload 13
    //   766: getfield 231	android/graphics/BitmapFactory$Options:outHeight	I
    //   769: i2d
    //   770: ddiv
    //   771: invokestatic 345	java/lang/Math:ceil	(D)D
    //   774: dstore 5
    //   776: dload 5
    //   778: d2i
    //   779: istore 11
    //   781: iload_1
    //   782: istore 12
    //   784: goto -390 -> 394
    //   787: iload 4
    //   789: ifeq +31 -> 820
    //   792: aload 13
    //   794: aload_0
    //   795: if_acmpeq +25 -> 820
    //   798: ldc 150
    //   800: ldc_w 368
    //   803: iconst_1
    //   804: anewarray 4	java/lang/Object
    //   807: dup
    //   808: iconst_0
    //   809: aload 13
    //   811: aastore
    //   812: invokestatic 165	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   815: aload 13
    //   817: invokevirtual 302	android/graphics/Bitmap:recycle	()V
    //   820: ldc 150
    //   822: new 274	java/lang/StringBuilder
    //   825: dup
    //   826: ldc_w 370
    //   829: invokespecial 279	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   832: aload_0
    //   833: invokevirtual 159	android/graphics/Bitmap:getWidth	()I
    //   836: invokevirtual 321	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   839: ldc_w 327
    //   842: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   845: aload_0
    //   846: invokevirtual 160	android/graphics/Bitmap:getHeight	()I
    //   849: invokevirtual 321	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   852: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   855: invokestatic 297	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   858: aload_0
    //   859: invokestatic 73	com/tencent/mm/sdk/platformtools/g:aE	(Landroid/graphics/Bitmap;)V
    //   862: ldc_w 314
    //   865: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   868: aload_0
    //   869: areturn
    //   870: astore_0
    //   871: goto -562 -> 309
    //   874: astore 13
    //   876: aload_0
    //   877: astore 14
    //   879: aload 13
    //   881: astore_0
    //   882: aload 14
    //   884: astore 13
    //   886: goto -577 -> 309
    //   889: aload 13
    //   891: astore_0
    //   892: goto -34 -> 858
    //   895: aload_0
    //   896: astore 13
    //   898: goto -363 -> 535
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	901	0	paramBitmap	Bitmap
    //   0	901	1	paramInt1	int
    //   0	901	2	paramInt2	int
    //   0	901	3	paramBoolean1	boolean
    //   0	901	4	paramBoolean2	boolean
    //   232	545	5	d1	double
    //   169	547	7	d2	double
    //   182	536	9	d3	double
    //   392	388	11	i	int
    //   389	394	12	j	int
    //   85	731	13	localObject1	Object
    //   874	6	13	localObject2	Object
    //   884	13	13	localObject3	Object
    //   301	6	14	localObject4	Object
    //   485	398	14	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   34	66	301	finally
    //   78	218	301	finally
    //   234	257	301	finally
    //   257	298	301	finally
    //   367	391	301	finally
    //   394	487	301	finally
    //   511	531	301	finally
    //   685	709	301	finally
    //   723	747	301	finally
    //   753	776	301	finally
    //   542	588	870	finally
    //   590	635	870	finally
    //   635	663	870	finally
    //   798	820	870	finally
    //   820	858	874	finally
  }
  
  public static Bitmap a(Bitmap paramBitmap1, Bitmap paramBitmap2, RectF paramRectF)
  {
    AppMethodBeat.i(195172);
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap1.getWidth(), paramBitmap1.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawBitmap(paramBitmap1, null, new Rect(0, 0, paramBitmap1.getWidth(), paramBitmap1.getHeight()), null);
    Rect localRect = new Rect();
    paramRectF.round(localRect);
    localCanvas.drawBitmap(paramBitmap2, localRect, new Rect(0, 0, paramBitmap1.getWidth(), paramBitmap1.getHeight()), null);
    AppMethodBeat.o(195172);
    return localBitmap;
  }
  
  public static Bitmap a(Bitmap paramBitmap, boolean paramBoolean, float paramFloat)
  {
    AppMethodBeat.i(156150);
    paramBitmap = b(paramBitmap, paramBoolean, paramFloat, false);
    AppMethodBeat.o(156150);
    return paramBitmap;
  }
  
  public static Bitmap a(Bitmap paramBitmap, boolean paramBoolean1, float paramFloat, boolean paramBoolean2)
  {
    AppMethodBeat.i(156149);
    paramBitmap = b(paramBitmap, paramBoolean1, paramFloat, paramBoolean2);
    AppMethodBeat.o(156149);
    return paramBitmap;
  }
  
  public static Bitmap a(Bitmap paramBitmap, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(156151);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      ad.e("MicroMsg.BitmapUtil", "getRoundedCornerBitmap in bitmap is null");
      AppMethodBeat.o(156151);
      return null;
    }
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length != 4))
    {
      ad.e("MicroMsg.BitmapUtil", "getRoundedCornerBitmap roundPxArray invalid");
      AppMethodBeat.o(156151);
      return null;
    }
    aE(paramBitmap);
    Bitmap localBitmap = createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888, true);
    if (localBitmap == null)
    {
      AppMethodBeat.o(156151);
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
    ad.i("MicroMsg.BitmapUtil", "getRoundedCornerBitmap bitmap recycle %s", new Object[] { paramBitmap });
    paramBitmap.recycle();
    aE(localBitmap);
    paramBitmap = f.ay(localBitmap);
    AppMethodBeat.o(156151);
    return paramBitmap;
  }
  
  /* Error */
  private static Bitmap a(BitmapFactory.Options paramOptions, byte[] paramArrayOfByte, String paramString, Uri paramUri, InputStream paramInputStream, boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: aconst_null
    //   4: astore 10
    //   6: ldc_w 486
    //   9: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: aload 10
    //   14: astore 9
    //   16: aload_1
    //   17: invokestatic 490	com/tencent/mm/sdk/platformtools/bt:cC	([B)Z
    //   20: ifeq +44 -> 64
    //   23: aload 10
    //   25: astore 9
    //   27: aload_2
    //   28: invokestatic 494	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   31: istore 8
    //   33: iload 8
    //   35: ifeq +29 -> 64
    //   38: aload_3
    //   39: ifnonnull +25 -> 64
    //   42: iload 6
    //   44: ifgt +20 -> 64
    //   47: aload 4
    //   49: ifnonnull +15 -> 64
    //   52: aconst_null
    //   53: invokestatic 73	com/tencent/mm/sdk/platformtools/g:aE	(Landroid/graphics/Bitmap;)V
    //   56: ldc_w 486
    //   59: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: aconst_null
    //   63: areturn
    //   64: aload 10
    //   66: astore 9
    //   68: aload_1
    //   69: invokestatic 490	com/tencent/mm/sdk/platformtools/bt:cC	([B)Z
    //   72: ifne +6 -> 78
    //   75: iconst_1
    //   76: istore 7
    //   78: iload 7
    //   80: ifeq +33 -> 113
    //   83: aload 10
    //   85: astore 9
    //   87: aload_1
    //   88: iconst_0
    //   89: aload_1
    //   90: arraylength
    //   91: aload_0
    //   92: invokestatic 500	com/tencent/mm/graphics/MMBitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   95: astore_0
    //   96: aload_0
    //   97: invokestatic 73	com/tencent/mm/sdk/platformtools/g:aE	(Landroid/graphics/Bitmap;)V
    //   100: aload_0
    //   101: invokestatic 79	com/tencent/mm/sdk/platformtools/f:ay	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   104: astore_0
    //   105: ldc_w 486
    //   108: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: aload_0
    //   112: areturn
    //   113: iload 6
    //   115: ifle +23 -> 138
    //   118: aload 10
    //   120: astore 9
    //   122: invokestatic 506	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   125: invokevirtual 512	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   128: iload 6
    //   130: aload_0
    //   131: invokestatic 518	com/tencent/mm/compatible/e/a:decodeResource	(Landroid/content/res/Resources;ILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   134: astore_0
    //   135: goto -39 -> 96
    //   138: aload 4
    //   140: ifnull +18 -> 158
    //   143: aload 10
    //   145: astore 9
    //   147: aload 4
    //   149: aconst_null
    //   150: aload_0
    //   151: invokestatic 522	com/tencent/mm/graphics/MMBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   154: astore_0
    //   155: goto -59 -> 96
    //   158: iload 5
    //   160: ifeq +68 -> 228
    //   163: aload_2
    //   164: invokestatic 494	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   167: istore 5
    //   169: iload 5
    //   171: ifeq +15 -> 186
    //   174: aconst_null
    //   175: invokestatic 73	com/tencent/mm/sdk/platformtools/g:aE	(Landroid/graphics/Bitmap;)V
    //   178: ldc_w 486
    //   181: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   184: aconst_null
    //   185: areturn
    //   186: invokestatic 506	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   189: invokevirtual 526	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   192: aload_2
    //   193: invokevirtual 532	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   196: astore_1
    //   197: aload_1
    //   198: aconst_null
    //   199: aload_0
    //   200: invokestatic 522	com/tencent/mm/graphics/MMBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   203: astore_2
    //   204: aload_2
    //   205: astore_0
    //   206: aload_1
    //   207: ifnull -111 -> 96
    //   210: aload_2
    //   211: astore 9
    //   213: aload_1
    //   214: invokevirtual 533	java/io/InputStream:close	()V
    //   217: aload_2
    //   218: astore_0
    //   219: goto -123 -> 96
    //   222: astore_0
    //   223: aload_2
    //   224: astore_0
    //   225: goto -129 -> 96
    //   228: aload_3
    //   229: ifnull +17 -> 246
    //   232: invokestatic 506	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   235: invokevirtual 537	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   238: aload_3
    //   239: invokevirtual 543	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   242: astore_1
    //   243: goto -46 -> 197
    //   246: aload_2
    //   247: invokestatic 548	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   250: astore_1
    //   251: goto -54 -> 197
    //   254: astore_0
    //   255: aconst_null
    //   256: astore_1
    //   257: aload_1
    //   258: ifnull +11 -> 269
    //   261: aload 10
    //   263: astore 9
    //   265: aload_1
    //   266: invokevirtual 533	java/io/InputStream:close	()V
    //   269: aload 10
    //   271: astore 9
    //   273: ldc_w 486
    //   276: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   279: aload 10
    //   281: astore 9
    //   283: aload_0
    //   284: athrow
    //   285: astore_0
    //   286: aload 9
    //   288: invokestatic 73	com/tencent/mm/sdk/platformtools/g:aE	(Landroid/graphics/Bitmap;)V
    //   291: ldc_w 486
    //   294: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   297: aload_0
    //   298: athrow
    //   299: astore_1
    //   300: goto -31 -> 269
    //   303: astore_0
    //   304: goto -47 -> 257
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	307	0	paramOptions	BitmapFactory.Options
    //   0	307	1	paramArrayOfByte	byte[]
    //   0	307	2	paramString	String
    //   0	307	3	paramUri	Uri
    //   0	307	4	paramInputStream	InputStream
    //   0	307	5	paramBoolean	boolean
    //   0	307	6	paramInt	int
    //   1	78	7	i	int
    //   31	3	8	bool	boolean
    //   14	273	9	localObject1	Object
    //   4	276	10	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   213	217	222	java/io/IOException
    //   163	169	254	finally
    //   186	197	254	finally
    //   232	243	254	finally
    //   246	251	254	finally
    //   16	23	285	finally
    //   27	33	285	finally
    //   68	75	285	finally
    //   87	96	285	finally
    //   122	135	285	finally
    //   147	155	285	finally
    //   213	217	285	finally
    //   265	269	285	finally
    //   273	279	285	finally
    //   283	285	285	finally
    //   265	269	299	java/io/IOException
    //   197	204	303	finally
  }
  
  public static Bitmap a(InputStream paramInputStream, float paramFloat, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(156131);
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
        break label213;
      }
      localObject = new o((FileInputStream)paramInputStream);
      ((InputStream)localObject).mark(25165824);
      localOptions.inJustDecodeBounds = true;
      MMBitmapFactory.decodeStream((InputStream)localObject, null, localOptions);
      paramInt2 = localOptions.outWidth;
      j = localOptions.outHeight;
      if (((i <= paramInt1) || (paramInt2 >= j)) && ((i >= paramInt1) || (paramInt2 <= j))) {
        break label291;
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
            AppMethodBeat.o(156131);
            return paramInputStream;
            label213:
            localObject = paramInputStream;
            if (paramInputStream.markSupported()) {
              break;
            }
            localObject = new BufferedInputStream(paramInputStream, 65536);
            break;
            paramInputStream = paramInputStream;
            ad.printErrStackTrace("MicroMsg.BitmapUtil", paramInputStream, "Failed seeking InputStream.", new Object[0]);
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
                ad.e("MicroMsg.BitmapUtil", "decodeStream OutOfMemoryError return null");
                paramInputStream = null;
              }
            }
          }
        }
      }
      label291:
      int k = paramInt2;
      paramInt2 = j;
      j = k;
    }
  }
  
  @TargetApi(11)
  private static Bitmap a(InputStream paramInputStream, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    AppMethodBeat.i(156138);
    if ((paramInt3 <= 0) || (paramInt4 <= 0))
    {
      ad.e("MicroMsg.BitmapUtil", "extractThumbNail height:" + paramInt4 + " width:" + paramInt3);
      AppMethodBeat.o(156138);
      return null;
    }
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      ad.e("MicroMsg.BitmapUtil", "decode[%s] error, outHeight[%d] outWidth[%d]", new Object[] { paramInputStream, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(156138);
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
        ad.i("MicroMsg.BitmapUtil", "extractThumbNail: round=" + paramInt3 + "x" + paramInt4 + ", crop=" + paramBoolean);
        d2 = paramInt2 * 1.0D / paramInt4;
        d3 = paramInt1 * 1.0D / paramInt3;
        ad.d("MicroMsg.BitmapUtil", "extractThumbNail: extract beX = " + d3 + ", beY = " + d2);
        if (!paramBoolean) {
          break label325;
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
        ad.e("MicroMsg.BitmapUtil", "decode bitmap failed: " + paramInputStream.getMessage());
        AppMethodBeat.o(156138);
        return null;
      }
      continue;
      label325:
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
        break label977;
        if (Build.VERSION.SDK_INT >= 11) {
          ((BitmapFactory.Options)localObject).inMutable = true;
        }
        ad.i("MicroMsg.BitmapUtil", "bitmap required size=" + i + "x" + j + ", orig=" + paramInt1 + "x" + paramInt2 + ", sample=" + ((BitmapFactory.Options)localObject).inSampleSize);
        paramInputStream = MMBitmapFactory.decodeStream(paramInputStream, null, (BitmapFactory.Options)localObject);
        if (paramInputStream == null)
        {
          ad.e("MicroMsg.BitmapUtil", "bitmap decode failed");
          AppMethodBeat.o(156138);
          return null;
        }
      }
      else
      {
        d1 = paramInt4 * 1.0D * paramInt1 / paramInt2;
        i = (int)Math.ceil(d1);
        j = paramInt4;
        break label977;
      }
    }
    else
    {
      if (d2 < d3)
      {
        j = (int)Math.ceil(paramInt3 * 1.0D * paramInt2 / paramInt1);
        i = paramInt3;
        break label977;
      }
      i = (int)Math.ceil(paramInt4 * 1.0D * paramInt1 / paramInt2);
      j = paramInt4;
      break label977;
    }
    ad.d("MicroMsg.BitmapUtil", "bitmap decoded size=" + paramInputStream.getWidth() + "x" + paramInputStream.getHeight());
    Object localObject = Bitmap.createScaledBitmap(paramInputStream, i, j, true);
    label661:
    int k;
    if ((paramInputStream != localObject) && (localObject != null))
    {
      ad.i("MicroMsg.BitmapUtil", "extractThumbNail bitmap recycle adsfad. %s", new Object[] { paramInputStream });
      paramInputStream.recycle();
      paramInputStream = (InputStream)localObject;
      localObject = paramInputStream;
      if (paramBoolean)
      {
        paramInt2 = paramInt3;
        if (paramInputStream.getWidth() < paramInt3)
        {
          ad.e("MicroMsg.BitmapUtil", "bmw < width %d %d", new Object[] { Integer.valueOf(paramInputStream.getWidth()), Integer.valueOf(paramInt3) });
          paramInt2 = paramInputStream.getWidth();
        }
        paramInt3 = paramInt4;
        if (paramInputStream.getHeight() < paramInt4)
        {
          ad.e("MicroMsg.BitmapUtil", "bmh < height %d %d", new Object[] { Integer.valueOf(paramInputStream.getHeight()), Integer.valueOf(paramInt4) });
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
          ad.e("MicroMsg.BitmapUtil", "fix crop image error %d %d %d %d", new Object[] { Integer.valueOf(paramInputStream.getWidth()), Integer.valueOf(paramInputStream.getHeight()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
          paramInt1 = paramInt4;
          if (paramInt4 >= 0) {
            break label1002;
          }
          paramInt1 = 0;
          break label1002;
        }
      }
    }
    for (;;)
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInputStream, j, i, paramInt2, paramInt3);
      if (localBitmap == null)
      {
        AppMethodBeat.o(156138);
        return paramInputStream;
      }
      localObject = paramInputStream;
      if (localBitmap != paramInputStream)
      {
        ad.i("MicroMsg.BitmapUtil", "extractThumbNail bitmap recycle adsfaasdfad. %s", new Object[] { paramInputStream });
        paramInputStream.recycle();
        localObject = localBitmap;
      }
      ad.d("MicroMsg.BitmapUtil", "bitmap croped size=" + ((Bitmap)localObject).getWidth() + "x" + ((Bitmap)localObject).getHeight());
      aE((Bitmap)localObject);
      paramInputStream = f.ay((Bitmap)localObject);
      AppMethodBeat.o(156138);
      return paramInputStream;
      break label661;
      label977:
      if (j > 0) {}
      for (;;)
      {
        if (i <= 0) {
          break label996;
        }
        break;
        j = 1;
      }
      label996:
      i = 1;
      break;
      label1002:
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
    AppMethodBeat.i(156122);
    paramString = a(0, paramString, null, null, false, paramFloat, paramInt1, paramInt2);
    AppMethodBeat.o(156122);
    return paramString;
  }
  
  public static Bitmap a(int[] paramArrayOfInt, int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    AppMethodBeat.i(156165);
    paramConfig = createBitmap(paramInt1, paramInt2, paramConfig, false);
    if (paramConfig != null)
    {
      if ((paramInt1 == paramConfig.getWidth()) && (paramInt2 == paramConfig.getHeight())) {
        paramConfig.setPixels(paramArrayOfInt, 0, paramInt1, 0, 0, paramInt1, paramInt2);
      }
    }
    else
    {
      aE(paramConfig);
      paramArrayOfInt = f.ay(paramConfig);
      AppMethodBeat.o(156165);
      return paramArrayOfInt;
    }
    AppMethodBeat.o(156165);
    return null;
  }
  
  public static void a(Canvas paramCanvas, View paramView)
  {
    AppMethodBeat.i(156159);
    paramView.draw(paramCanvas);
    paramView = z(paramView, (int)paramView.getX(), (int)paramView.getY());
    if (paramView.size() > 0)
    {
      paramView = paramView.iterator();
      while (paramView.hasNext())
      {
        x localx = (x)paramView.next();
        if ((localx != null) && (localx.IcR != null))
        {
          Object localObject = localx.IcR;
          localObject = ((TextureView)localObject).getBitmap(((TextureView)localObject).getWidth(), ((TextureView)localObject).getHeight());
          if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
            ad.e("MicroMsg.BitmapUtil", "get thumb bitmap null or is recycled");
          } else {
            paramCanvas.drawBitmap((Bitmap)localObject, localx.left, localx.top, null);
          }
        }
      }
    }
    AppMethodBeat.o(156159);
  }
  
  public static boolean a(Bitmap paramBitmap, int paramInt, Bitmap.CompressFormat paramCompressFormat, OutputStream paramOutputStream, boolean paramBoolean)
  {
    AppMethodBeat.i(169235);
    boolean bool = a(paramBitmap, paramCompressFormat, paramInt, paramOutputStream);
    if (paramBoolean)
    {
      ad.i("MicroMsg.BitmapUtil", "saveBitmapToStream bitmap recycle. %s", new Object[] { paramBitmap });
      paramBitmap.recycle();
    }
    AppMethodBeat.o(169235);
    return bool;
  }
  
  /* Error */
  public static boolean a(Bitmap paramBitmap, int paramInt, Bitmap.CompressFormat paramCompressFormat, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 673
    //   3: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_3
    //   7: invokestatic 494	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifeq +22 -> 32
    //   13: new 119	java/io/IOException
    //   16: dup
    //   17: ldc_w 675
    //   20: invokespecial 676	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   23: astore_0
    //   24: ldc_w 673
    //   27: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: aload_0
    //   31: athrow
    //   32: ldc 150
    //   34: ldc_w 678
    //   37: aload_3
    //   38: invokestatic 187	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   41: invokevirtual 191	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   44: invokestatic 333	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: aconst_null
    //   48: astore 7
    //   50: aconst_null
    //   51: astore 6
    //   53: aload_3
    //   54: invokestatic 681	com/tencent/mm/vfs/i:aYr	(Ljava/lang/String;)Ljava/lang/String;
    //   57: invokestatic 684	com/tencent/mm/vfs/i:aYg	(Ljava/lang/String;)Z
    //   60: pop
    //   61: aload_3
    //   62: iconst_0
    //   63: invokestatic 688	com/tencent/mm/vfs/i:cX	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   66: astore 8
    //   68: aload 8
    //   70: astore 6
    //   72: aload 8
    //   74: astore 7
    //   76: aload_0
    //   77: iload_1
    //   78: aload_2
    //   79: aload 8
    //   81: iload 4
    //   83: invokestatic 690	com/tencent/mm/sdk/platformtools/g:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/io/OutputStream;Z)Z
    //   86: istore 5
    //   88: iload 4
    //   90: ifeq +26 -> 116
    //   93: ldc 150
    //   95: ldc_w 692
    //   98: iconst_1
    //   99: anewarray 4	java/lang/Object
    //   102: dup
    //   103: iconst_0
    //   104: aload_0
    //   105: invokevirtual 693	java/lang/Object:toString	()Ljava/lang/String;
    //   108: aastore
    //   109: invokestatic 165	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   112: aload_0
    //   113: invokevirtual 302	android/graphics/Bitmap:recycle	()V
    //   116: aload 8
    //   118: ifnull +8 -> 126
    //   121: aload 8
    //   123: invokevirtual 696	java/io/OutputStream:close	()V
    //   126: ldc_w 673
    //   129: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   132: iload 5
    //   134: ireturn
    //   135: astore_2
    //   136: aload 6
    //   138: astore 7
    //   140: ldc 150
    //   142: aload_2
    //   143: ldc_w 698
    //   146: iconst_1
    //   147: anewarray 4	java/lang/Object
    //   150: dup
    //   151: iconst_0
    //   152: aload_3
    //   153: aastore
    //   154: invokestatic 252	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   157: aload 6
    //   159: astore 7
    //   161: new 119	java/io/IOException
    //   164: dup
    //   165: aload_2
    //   166: invokespecial 701	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   169: astore_2
    //   170: aload 6
    //   172: astore 7
    //   174: ldc_w 673
    //   177: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   180: aload 6
    //   182: astore 7
    //   184: aload_2
    //   185: athrow
    //   186: astore_2
    //   187: iload 4
    //   189: ifeq +26 -> 215
    //   192: ldc 150
    //   194: ldc_w 692
    //   197: iconst_1
    //   198: anewarray 4	java/lang/Object
    //   201: dup
    //   202: iconst_0
    //   203: aload_0
    //   204: invokevirtual 693	java/lang/Object:toString	()Ljava/lang/String;
    //   207: aastore
    //   208: invokestatic 165	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   211: aload_0
    //   212: invokevirtual 302	android/graphics/Bitmap:recycle	()V
    //   215: aload 7
    //   217: ifnull +8 -> 225
    //   220: aload 7
    //   222: invokevirtual 696	java/io/OutputStream:close	()V
    //   225: ldc_w 673
    //   228: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   231: aload_2
    //   232: athrow
    //   233: astore_0
    //   234: goto -108 -> 126
    //   237: astore_0
    //   238: goto -13 -> 225
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	paramBitmap	Bitmap
    //   0	241	1	paramInt	int
    //   0	241	2	paramCompressFormat	Bitmap.CompressFormat
    //   0	241	3	paramString	String
    //   0	241	4	paramBoolean	boolean
    //   86	47	5	bool	boolean
    //   51	130	6	localObject1	Object
    //   48	173	7	localObject2	Object
    //   66	56	8	localOutputStream	OutputStream
    // Exception table:
    //   from	to	target	type
    //   61	68	135	java/lang/Exception
    //   76	88	135	java/lang/Exception
    //   61	68	186	finally
    //   76	88	186	finally
    //   140	157	186	finally
    //   161	170	186	finally
    //   174	180	186	finally
    //   184	186	186	finally
    //   121	126	233	java/io/IOException
    //   220	225	237	java/io/IOException
  }
  
  public static boolean a(Bitmap paramBitmap, Bitmap.CompressFormat paramCompressFormat, int paramInt, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(156173);
    if (paramBitmap == null)
    {
      ad.e("MicroMsg.BitmapUtil", "bitmap error %s", new Object[] { paramBitmap });
      AppMethodBeat.o(156173);
      return false;
    }
    boolean bool = paramBitmap.compress(paramCompressFormat, paramInt, paramOutputStream);
    if (!bool) {
      ad.e("MicroMsg.BitmapUtil", "compress error %s", new Object[] { bt.flS().toString() });
    }
    AppMethodBeat.o(156173);
    return bool;
  }
  
  public static boolean a(String paramString1, int paramInt1, int paramInt2, Bitmap.CompressFormat paramCompressFormat, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(156102);
    boolean bool = b(paramString1, paramInt1, paramInt2, paramCompressFormat, paramInt3, paramString2);
    AppMethodBeat.o(156102);
    return bool;
  }
  
  public static boolean a(String paramString1, int paramInt1, int paramInt2, Bitmap.CompressFormat paramCompressFormat, int paramInt3, String paramString2, String paramString3)
  {
    AppMethodBeat.i(156101);
    boolean bool = b(paramString1, paramInt1, paramInt2, paramCompressFormat, paramInt3, paramString2 + paramString3);
    AppMethodBeat.o(156101);
    return bool;
  }
  
  private static boolean a(String paramString1, int paramInt1, int paramInt2, Bitmap.CompressFormat paramCompressFormat, int paramInt3, String paramString2, boolean paramBoolean, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(156107);
    paramBoolean = a(paramString1, paramInt1, paramInt2, paramCompressFormat, paramInt3, paramString2, paramBoolean, paramPInt1, paramPInt2, false);
    AppMethodBeat.o(156107);
    return paramBoolean;
  }
  
  private static boolean a(String paramString1, int paramInt1, int paramInt2, Bitmap.CompressFormat paramCompressFormat, int paramInt3, String paramString2, boolean paramBoolean1, PInt paramPInt1, PInt paramPInt2, boolean paramBoolean2)
  {
    AppMethodBeat.i(156109);
    try
    {
      Bitmap localBitmap1 = d(paramString1, paramInt1, paramInt2, paramBoolean2);
      if (localBitmap1 == null)
      {
        AppMethodBeat.o(156109);
        return false;
      }
      Bitmap localBitmap2 = localBitmap1;
      if (paramBoolean1) {
        localBitmap2 = a(localBitmap1, Exif.fromFile(paramString1).getOrientationInDegree());
      }
      paramPInt1.value = localBitmap2.getWidth();
      paramPInt2.value = localBitmap2.getHeight();
      a(localBitmap2, paramInt3, paramCompressFormat, paramString2, true);
      AppMethodBeat.o(156109);
      return true;
    }
    catch (Throwable paramString1)
    {
      ad.e("MicroMsg.BitmapUtil", "create thumbnail from orig failed: ".concat(String.valueOf(paramString2)));
      AppMethodBeat.o(156109);
    }
    return false;
  }
  
  public static boolean a(String paramString1, int paramInt1, int paramInt2, Bitmap.CompressFormat paramCompressFormat, String paramString2, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(156108);
    boolean bool = a(paramString1, paramInt1, paramInt2, paramCompressFormat, 80, paramString2, true, paramPInt1, paramPInt2, true);
    AppMethodBeat.o(156108);
    return bool;
  }
  
  public static boolean a(String paramString1, int paramInt1, Bitmap.CompressFormat paramCompressFormat, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(156144);
    paramString1 = a(paramString1, 0, 0, 0.0F);
    if (paramString1 == null)
    {
      ad.e("MicroMsg.BitmapUtil", "rotate: create bitmap fialed");
      AppMethodBeat.o(156144);
      return false;
    }
    float f1 = paramString1.getWidth();
    float f2 = paramString1.getHeight();
    Object localObject = new Matrix();
    ((Matrix)localObject).setRotate(paramInt1, f1 / 2.0F, f2 / 2.0F);
    localObject = Bitmap.createBitmap(paramString1, 0, 0, (int)f1, (int)f2, (Matrix)localObject, true);
    if (paramString1 != localObject)
    {
      ad.i("MicroMsg.BitmapUtil", "rotate bitmap recycle adjfjads fadsj fsadjf dsa. %s", new Object[] { paramString1.toString() });
      paramString1.recycle();
    }
    try
    {
      a((Bitmap)localObject, paramInt2, paramCompressFormat, paramString2, true);
      AppMethodBeat.o(156144);
      return true;
    }
    catch (IOException paramString1)
    {
      ad.printErrStackTrace("MicroMsg.BitmapUtil", paramString1, "create %s from orig failed: ".concat(String.valueOf(paramString2)), new Object[0]);
      AppMethodBeat.o(156144);
    }
    return false;
  }
  
  public static boolean a(String paramString1, int paramInt, Bitmap.CompressFormat paramCompressFormat, String paramString2, String paramString3)
  {
    AppMethodBeat.i(156145);
    boolean bool = a(paramString1, paramInt, paramCompressFormat, 90, paramString2 + paramString3);
    AppMethodBeat.o(156145);
    return bool;
  }
  
  public static byte[] aA(Bitmap paramBitmap)
  {
    AppMethodBeat.i(156155);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(156155);
      return new byte[0];
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    a(paramBitmap, Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    paramBitmap = localByteArrayOutputStream.toByteArray();
    try
    {
      localByteArrayOutputStream.close();
      AppMethodBeat.o(156155);
      return paramBitmap;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.BitmapUtil", localException, "", new Object[0]);
      }
    }
  }
  
  public static Bitmap aB(Bitmap paramBitmap)
  {
    AppMethodBeat.i(156167);
    long l = System.currentTimeMillis();
    int j = Math.round(paramBitmap.getWidth() * 0.1F);
    int k = Math.round(paramBitmap.getHeight() * 0.1F);
    if (j > 10)
    {
      i = k;
      if (k > 10) {}
    }
    else
    {
      j = paramBitmap.getWidth();
      i = paramBitmap.getHeight();
    }
    paramBitmap = Bitmap.createScaledBitmap(paramBitmap, j, i, false);
    paramBitmap = paramBitmap.copy(paramBitmap.getConfig(), true);
    int i14 = paramBitmap.getWidth();
    int i15 = paramBitmap.getHeight();
    int[] arrayOfInt1 = new int[i14 * i15];
    ad.d("MicroMsg.BitmapUtil", "alvinluo fastBlurBitmap w: %d, h: %d, length: %d", new Object[] { Integer.valueOf(i14), Integer.valueOf(i15), Integer.valueOf(arrayOfInt1.length) });
    paramBitmap.getPixels(arrayOfInt1, 0, i14, 0, 0, i14, i15);
    int i17 = i14 - 1;
    int i16 = i15 - 1;
    if ((i17 <= 0) || (i16 <= 0))
    {
      AppMethodBeat.o(156167);
      return null;
    }
    int i = i14 * i15;
    int[] arrayOfInt2 = new int[i];
    int[] arrayOfInt3 = new int[i];
    int[] arrayOfInt4 = new int[i];
    int[] arrayOfInt5 = new int[Math.max(i14, i15)];
    int[] arrayOfInt6 = new int[30976];
    i = 0;
    while (i < 30976)
    {
      arrayOfInt6[i] = (i / 121);
      i += 1;
    }
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { 21, 3 });
    int i6 = 0;
    int i5 = 0;
    int i7 = 0;
    int i8;
    int i4;
    int i2;
    int n;
    int i3;
    int i1;
    int m;
    int i9;
    int[] arrayOfInt7;
    int i12;
    int i10;
    int i11;
    while (i6 < i15)
    {
      if (CU(l))
      {
        ad.e("MicroMsg.BitmapUtil", "alvinluo fastBlurBitmap timeOut and return null");
        AppMethodBeat.o(156167);
        return null;
      }
      i8 = -10;
      i4 = 0;
      i2 = 0;
      n = 0;
      i3 = 0;
      i1 = 0;
      i = 0;
      j = 0;
      k = 0;
      m = 0;
      if (i8 <= 10)
      {
        i9 = arrayOfInt1[(Math.min(i17, Math.max(i8, 0)) + i7)];
        arrayOfInt7 = arrayOfInt[(i8 + 10)];
        arrayOfInt7[0] = ((0xFF0000 & i9) >> 16);
        arrayOfInt7[1] = ((0xFF00 & i9) >> 8);
        arrayOfInt7[2] = (i9 & 0xFF);
        i9 = 11 - Math.abs(i8);
        j += arrayOfInt7[0] * i9;
        k += arrayOfInt7[1] * i9;
        m += i9 * arrayOfInt7[2];
        if (i8 > 0)
        {
          i4 += arrayOfInt7[0];
          i2 += arrayOfInt7[1];
          n += arrayOfInt7[2];
        }
        for (;;)
        {
          i8 += 1;
          break;
          i3 += arrayOfInt7[0];
          i1 += arrayOfInt7[1];
          i += arrayOfInt7[2];
        }
      }
      int i13 = 10;
      if (CU(l))
      {
        ad.e("MicroMsg.BitmapUtil", "alvinluo fastBlurBitmap timeOut and return null");
        AppMethodBeat.o(156167);
        return null;
      }
      i12 = 0;
      i9 = i4;
      i8 = i2;
      i4 = n;
      i10 = i3;
      i11 = i1;
      n = i13;
      i1 = m;
      i2 = k;
      i3 = j;
      m = i;
      i = i11;
      j = i10;
      k = i12;
      while (k < i14)
      {
        arrayOfInt2[i7] = arrayOfInt6[i3];
        arrayOfInt3[i7] = arrayOfInt6[i2];
        arrayOfInt4[i7] = arrayOfInt6[i1];
        arrayOfInt7 = arrayOfInt[((n - 10 + 21) % 21)];
        i11 = arrayOfInt7[0];
        i10 = arrayOfInt7[1];
        int i18 = arrayOfInt7[2];
        if (i6 == 0) {
          arrayOfInt5[k] = Math.min(k + 10 + 1, i17);
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
        n = (n + 1) % 21;
        arrayOfInt7 = arrayOfInt[(n % 21)];
        i13 = arrayOfInt7[0];
        i12 = arrayOfInt7[1];
        m = m - i18 + arrayOfInt7[2];
        int i20 = arrayOfInt7[0];
        int i19 = arrayOfInt7[1];
        i18 = arrayOfInt7[2];
        i7 += 1;
        k += 1;
        i9 -= i20;
        i8 -= i19;
        i4 -= i18;
        j = j - i11 + i13;
        i = i - i10 + i12;
      }
      i6 += 1;
      i5 += i14;
    }
    i = 0;
    while (i < i14)
    {
      i7 = i14 * -10;
      if (CU(l))
      {
        ad.e("MicroMsg.BitmapUtil", "alvinluo fastBlurBitmap timeOut and return null");
        AppMethodBeat.o(156167);
        return null;
      }
      i6 = -10;
      i5 = 0;
      k = 0;
      j = 0;
      m = 0;
      n = 0;
      i1 = 0;
      i2 = 0;
      i3 = 0;
      i4 = 0;
      if (i6 <= 10)
      {
        i9 = Math.max(0, i7) + i;
        arrayOfInt7 = arrayOfInt[(i6 + 10)];
        arrayOfInt7[0] = arrayOfInt2[i9];
        arrayOfInt7[1] = arrayOfInt3[i9];
        arrayOfInt7[2] = arrayOfInt4[i9];
        i10 = 11 - Math.abs(i6);
        i8 = i2 + arrayOfInt2[i9] * i10;
        i3 += arrayOfInt3[i9] * i10;
        i4 += arrayOfInt4[i9] * i10;
        if (i6 > 0)
        {
          i5 += arrayOfInt7[0];
          k += arrayOfInt7[1];
          j += arrayOfInt7[2];
        }
        for (;;)
        {
          i2 = i7;
          if (i6 < i16) {
            i2 = i7 + i14;
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
      i7 = 10;
      if (CU(l))
      {
        ad.e("MicroMsg.BitmapUtil", "alvinluo fastBlurBitmap timeOut and return null");
        AppMethodBeat.o(156167);
        return null;
      }
      i9 = 0;
      i8 = i5;
      i6 = i;
      i5 = i9;
      while (i5 < i15)
      {
        arrayOfInt1[i6] = (0xFF000000 & arrayOfInt1[i6] | arrayOfInt6[i2] << 16 | arrayOfInt6[i3] << 8 | arrayOfInt6[i4]);
        arrayOfInt7 = arrayOfInt[((i7 - 10 + 21) % 21)];
        i11 = arrayOfInt7[0];
        i10 = arrayOfInt7[1];
        i9 = arrayOfInt7[2];
        if (i == 0) {
          arrayOfInt5[i5] = (Math.min(i5 + 11, i16) * i14);
        }
        i12 = arrayOfInt5[i5] + i;
        arrayOfInt7[0] = arrayOfInt2[i12];
        arrayOfInt7[1] = arrayOfInt3[i12];
        arrayOfInt7[2] = arrayOfInt4[i12];
        i8 += arrayOfInt7[0];
        k += arrayOfInt7[1];
        j += arrayOfInt7[2];
        i2 = i2 - m + i8;
        i3 = i3 - n + k;
        i4 = i4 - i1 + j;
        i7 = (i7 + 1) % 21;
        arrayOfInt7 = arrayOfInt[i7];
        m = m - i11 + arrayOfInt7[0];
        n = n - i10 + arrayOfInt7[1];
        i1 = i1 - i9 + arrayOfInt7[2];
        i8 -= arrayOfInt7[0];
        i9 = arrayOfInt7[1];
        j -= arrayOfInt7[2];
        i6 += i14;
        i5 += 1;
        k -= i9;
      }
      i += 1;
    }
    paramBitmap.setPixels(arrayOfInt1, 0, i14, 0, 0, i14, i15);
    AppMethodBeat.o(156167);
    return paramBitmap;
  }
  
  public static Bitmap aC(Bitmap paramBitmap)
  {
    AppMethodBeat.i(156170);
    int i = paramBitmap.getHeight();
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), i, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    ColorMatrix localColorMatrix = new ColorMatrix();
    localColorMatrix.setSaturation(0.0F);
    localPaint.setColorFilter(new ColorMatrixColorFilter(localColorMatrix));
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
    aE(localBitmap);
    paramBitmap = f.ay(localBitmap);
    AppMethodBeat.o(156170);
    return paramBitmap;
  }
  
  public static Bitmap aD(Bitmap paramBitmap)
  {
    AppMethodBeat.i(156171);
    int i = paramBitmap.getHeight();
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), i, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    ColorMatrix localColorMatrix = new ColorMatrix();
    localColorMatrix.set(new float[] { 0.9F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.9F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.9F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F });
    localPaint.setColorFilter(new ColorMatrixColorFilter(localColorMatrix));
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
    aE(localBitmap);
    paramBitmap = f.ay(localBitmap);
    AppMethodBeat.o(156171);
    return paramBitmap;
  }
  
  private static void aE(Bitmap paramBitmap)
  {
    AppMethodBeat.i(156174);
    if (paramBitmap != null)
    {
      paramBitmap.setDensity(aj.getContext().getResources().getDisplayMetrics().densityDpi);
      try
      {
        paramBitmap = Bitmap.class.getDeclaredMethod("setDefaultDensity", new Class[] { Integer.TYPE });
        paramBitmap.setAccessible(true);
        paramBitmap.invoke(null, new Object[] { Integer.valueOf(aj.getContext().getResources().getDisplayMetrics().densityDpi) });
        AppMethodBeat.o(156174);
        return;
      }
      catch (Exception paramBitmap)
      {
        ad.e("MicroMsg.BitmapUtil", "Exception:%s", new Object[] { paramBitmap });
      }
    }
    AppMethodBeat.o(156174);
  }
  
  public static Bitmap aJ(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(156100);
    try
    {
      Bitmap localBitmap = createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888, false);
      new Canvas(localBitmap).drawColor(paramInt1);
      localBitmap = f.ay(localBitmap);
      AppMethodBeat.o(156100);
      return localBitmap;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.BitmapUtil", localException, "", new Object[0]);
      AppMethodBeat.o(156100);
    }
    return null;
  }
  
  public static Bitmap aK(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(156118);
    Bitmap localBitmap = a(paramInt1, null, null, null, false, 0.0F, paramInt2, paramInt3);
    AppMethodBeat.o(156118);
    return localBitmap;
  }
  
  public static Bitmap aK(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(156111);
    Bitmap localBitmap = d(paramString, paramInt1, paramInt2, false);
    if (localBitmap == null)
    {
      AppMethodBeat.o(156111);
      return null;
    }
    paramInt1 = Exif.fromFile(paramString).getOrientationInDegree();
    ad.d("MicroMsg.BitmapUtil", "degress:%d", new Object[] { Integer.valueOf(paramInt1) });
    paramString = a(localBitmap, paramInt1);
    AppMethodBeat.o(156111);
    return paramString;
  }
  
  public static Bitmap aL(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(169232);
    Bitmap localBitmap = decodeFile(paramString, null);
    if (localBitmap == null)
    {
      AppMethodBeat.o(169232);
      return null;
    }
    int i = Exif.fromFile(paramString).getOrientationInDegree();
    ad.d("MicroMsg.BitmapUtil", "degress:%d", new Object[] { Integer.valueOf(i) });
    paramString = a(a(localBitmap, i), paramInt2, paramInt1, true, true);
    AppMethodBeat.o(169232);
    return paramString;
  }
  
  public static Bitmap aM(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(156120);
    paramString = a(paramString, paramInt1, paramInt2, 0.0F);
    AppMethodBeat.o(156120);
    return paramString;
  }
  
  public static Bitmap aN(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(156141);
    paramString = a(0, paramString, null, null, true, 0.0F, paramInt1, paramInt2);
    AppMethodBeat.o(156141);
    return paramString;
  }
  
  public static DisplayMetrics aQF()
  {
    AppMethodBeat.i(156134);
    if (iNB == null) {
      iNB = aj.getContext().getResources().getDisplayMetrics();
    }
    DisplayMetrics localDisplayMetrics = iNB;
    AppMethodBeat.o(156134);
    return localDisplayMetrics;
  }
  
  public static BitmapFactory.Options aQc(String paramString)
  {
    AppMethodBeat.i(156099);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.BitmapUtil", "getImageOptions invalid path");
      AppMethodBeat.o(156099);
      return null;
    }
    try
    {
      paramString = i.openRead(paramString);
      paramString = c(paramString, true);
      AppMethodBeat.o(156099);
      return paramString;
    }
    catch (FileNotFoundException paramString)
    {
      ad.printErrStackTrace("MicroMsg.BitmapUtil", paramString, "Decode bitmap failed.", new Object[0]);
      paramString = new BitmapFactory.Options();
      AppMethodBeat.o(156099);
    }
    return paramString;
  }
  
  public static Point aQd(String paramString)
  {
    AppMethodBeat.i(156104);
    paramString = aQc(paramString);
    if (paramString != null)
    {
      paramString = new Point(paramString.outWidth, paramString.outHeight);
      AppMethodBeat.o(156104);
      return paramString;
    }
    AppMethodBeat.o(156104);
    return null;
  }
  
  public static int aQe(String paramString)
  {
    AppMethodBeat.i(169231);
    int i = Exif.fromFile(paramString).getOrientationInDegree();
    AppMethodBeat.o(169231);
    return i;
  }
  
  public static Bitmap aQf(String paramString)
  {
    AppMethodBeat.i(156114);
    paramString = a(paramString, 0, 0, 0.0F);
    AppMethodBeat.o(156114);
    return paramString;
  }
  
  public static Bitmap aQg(String paramString)
  {
    AppMethodBeat.i(156129);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    decodeFile(paramString, localOptions);
    localOptions.inSampleSize = O(localOptions.outWidth, localOptions.outHeight, 2500, 2500);
    localOptions.inJustDecodeBounds = false;
    paramString = decodeFile(paramString, localOptions);
    AppMethodBeat.o(156129);
    return paramString;
  }
  
  public static Bitmap aat(int paramInt)
  {
    AppMethodBeat.i(156116);
    Bitmap localBitmap = a(paramInt, null, null, null, false, 0.0F, 0, 0);
    AppMethodBeat.o(156116);
    return localBitmap;
  }
  
  public static Bitmap az(Bitmap paramBitmap)
  {
    float f1 = 2.5F;
    AppMethodBeat.i(156113);
    int j = 120;
    float f2;
    int i;
    if (paramBitmap.getHeight() >= paramBitmap.getWidth())
    {
      f2 = paramBitmap.getHeight() / paramBitmap.getWidth();
      if (f2 <= 2.0F)
      {
        i = (int)(paramBitmap.getWidth() * 120.0D / paramBitmap.getHeight());
        ad.d("MicroMsg.BitmapUtil", "bitmap decoded size=" + paramBitmap.getWidth() + "x" + paramBitmap.getHeight());
        Bitmap localBitmap2 = Bitmap.createScaledBitmap(paramBitmap, i, j, true);
        Bitmap localBitmap1 = paramBitmap;
        if (localBitmap2 != null)
        {
          localBitmap1 = paramBitmap;
          if (paramBitmap != localBitmap2)
          {
            ad.i("MicroMsg.BitmapUtil", "extractThumeNail bitmap recycle. %s", new Object[] { paramBitmap });
            paramBitmap.recycle();
            localBitmap1 = localBitmap2;
          }
        }
        AppMethodBeat.o(156113);
        return localBitmap1;
      }
      if (f2 <= 2.5D) {
        break label325;
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
      label325:
      f1 = f2;
    }
  }
  
  public static Bitmap b(Bitmap paramBitmap, float paramFloat)
  {
    AppMethodBeat.i(156169);
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawARGB(0, 0, 0, 0);
    Paint localPaint = new Paint();
    localPaint.setAlpha((int)(255.0F * paramFloat));
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
    aE(localBitmap);
    paramBitmap = f.ay(localBitmap);
    AppMethodBeat.o(156169);
    return paramBitmap;
  }
  
  public static Bitmap b(Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(156142);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(156142);
      return null;
    }
    if ((paramFloat1 == 0.0F) && (paramFloat2 > 0.999D) && (paramFloat2 < 1.001D) && (paramFloat3 > 0.999D) && (paramFloat3 < 1.001D))
    {
      AppMethodBeat.o(156142);
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
    aE((Bitmap)localObject);
    StringBuilder localStringBuilder = new StringBuilder("resultBmp is null: ");
    if (localObject == null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.BitmapUtil", bool + "  degree:" + paramFloat1);
      if (paramBitmap != localObject)
      {
        ad.i("MicroMsg.BitmapUtil", "rotateAndScale bitmap recycle asdfasdjfjasdfjsadfjdsa. %s", new Object[] { paramBitmap });
        paramBitmap.recycle();
      }
      paramBitmap = f.ay((Bitmap)localObject);
      AppMethodBeat.o(156142);
      return paramBitmap;
    }
  }
  
  public static Bitmap b(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(156164);
    if ((paramBitmap == null) || (paramInt1 < 0) || (paramInt2 < 0) || (paramInt3 < 0))
    {
      AppMethodBeat.o(156164);
      return null;
    }
    long l = System.currentTimeMillis();
    Bitmap localBitmap = f.ay(createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888, false));
    Canvas localCanvas = new Canvas(localBitmap);
    ad.d("MicroMsg.BitmapUtil", "bm size w %d h %d target w %d h %d", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    localCanvas.drawBitmap(paramBitmap, null, new Rect(0, 0, paramInt2, paramInt3), new Paint());
    ad.d("MicroMsg.BitmapUtil", "create nine patch bitmap " + (System.currentTimeMillis() - l));
    paramBitmap = k(localBitmap, paramInt1);
    AppMethodBeat.o(156164);
    return paramBitmap;
  }
  
  public static Bitmap b(Bitmap paramBitmap, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(156148);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(156148);
      return null;
    }
    aE(paramBitmap);
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
      ad.w("MicroMsg.BitmapUtil", "get center crop bitmap, config is null");
      localObject = Bitmap.Config.ARGB_8888;
    }
    try
    {
      localObject = Bitmap.createBitmap(paramInt1, paramInt2, (Bitmap.Config)localObject);
      new Canvas((Bitmap)localObject).drawBitmap(paramBitmap, null, localRectF, null);
      if (paramBoolean)
      {
        ad.i("MicroMsg.BitmapUtil", "getCenterCropBitmap bitmap recycle %s", new Object[] { paramBitmap });
        paramBitmap.recycle();
      }
      aE((Bitmap)localObject);
      paramBitmap = f.ay((Bitmap)localObject);
      AppMethodBeat.o(156148);
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
        ad.e("MicroMsg.BitmapUtil", "BitmapUtil decode getCenterCropBitmap fail");
        AppMethodBeat.o(156148);
      }
    }
    return paramBitmap;
  }
  
  public static Bitmap b(Bitmap paramBitmap, Rect paramRect)
  {
    AppMethodBeat.i(195171);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(195171);
      return null;
    }
    aE(paramBitmap);
    try
    {
      paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramRect.width(), paramRect.height(), null, false);
      aE(paramBitmap);
      paramBitmap = f.ay(paramBitmap);
      AppMethodBeat.o(195171);
      return paramBitmap;
    }
    catch (Throwable paramBitmap)
    {
      ad.printErrStackTrace("MicroMsg.BitmapUtil", paramBitmap, "getBitmapFromRect exception", new Object[0]);
      AppMethodBeat.o(195171);
    }
    return null;
  }
  
  private static Bitmap b(Bitmap paramBitmap, boolean paramBoolean1, float paramFloat, boolean paramBoolean2)
  {
    AppMethodBeat.i(169237);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      ad.e("MicroMsg.BitmapUtil", "getRoundedCornerBitmap in bitmap is null");
      AppMethodBeat.o(169237);
      return null;
    }
    aE(paramBitmap);
    Object localObject = new int[2];
    localObject[0] = paramBitmap.getWidth();
    localObject[1] = paramBitmap.getHeight();
    localObject = createBitmap(localObject[0], localObject[1], Bitmap.Config.ARGB_8888, paramBoolean2);
    if (localObject == null)
    {
      AppMethodBeat.o(169237);
      return null;
    }
    Canvas localCanvas = new Canvas((Bitmap)localObject);
    Paint localPaint = new Paint();
    Rect localRect1 = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    Rect localRect2 = new Rect(0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
    RectF localRectF = new RectF(localRect2);
    localPaint.setAntiAlias(true);
    localPaint.setDither(true);
    localPaint.setFilterBitmap(true);
    localCanvas.drawARGB(0, 0, 0, 0);
    localPaint.setColor(-4144960);
    localCanvas.drawRoundRect(localRectF, paramFloat, paramFloat, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(paramBitmap, localRect1, localRect2, localPaint);
    if (paramBoolean1)
    {
      ad.i("MicroMsg.BitmapUtil", "getRoundedCornerBitmap bitmap recycle %s", new Object[] { paramBitmap });
      paramBitmap.recycle();
    }
    aE((Bitmap)localObject);
    paramBitmap = f.ay((Bitmap)localObject);
    AppMethodBeat.o(169237);
    return paramBitmap;
  }
  
  public static Bitmap b(InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(156121);
    paramInputStream = a(0, null, null, null, paramInputStream, false, 0.0F, paramInt1, paramInt2);
    AppMethodBeat.o(156121);
    return paramInputStream;
  }
  
  private static boolean b(String paramString1, int paramInt1, int paramInt2, Bitmap.CompressFormat paramCompressFormat, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(156105);
    boolean bool = a(paramString1, paramInt1, paramInt2, paramCompressFormat, paramInt3, paramString2, false, new PInt(), new PInt());
    AppMethodBeat.o(156105);
    return bool;
  }
  
  public static boolean b(String paramString1, int paramInt1, int paramInt2, Bitmap.CompressFormat paramCompressFormat, String paramString2, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(156112);
    if (bt.isNullOrNil(paramString1))
    {
      ad.w("MicroMsg.BitmapUtil", "file path is null.");
      AppMethodBeat.o(156112);
      return false;
    }
    if (!i.fv(paramString1))
    {
      ad.w("MicroMsg.BitmapUtil", "file did not exists.");
      AppMethodBeat.o(156112);
      return false;
    }
    int i = Exif.fromFile(paramString1).getOrientationInDegree();
    ad.d("MicroMsg.BitmapUtil", "degress:%d", new Object[] { Integer.valueOf(i) });
    if ((i == 90) || (i == 270)) {}
    for (paramString1 = a(d(paramString1, paramInt2, paramInt1, true), i); paramString1 == null; paramString1 = a(d(paramString1, paramInt1, paramInt2, true), i))
    {
      AppMethodBeat.o(156112);
      return false;
    }
    try
    {
      paramPInt1.value = paramString1.getWidth();
      paramPInt2.value = paramString1.getHeight();
      a(paramString1, 80, paramCompressFormat, paramString2, true);
      AppMethodBeat.o(156112);
      return true;
    }
    catch (IOException paramString1)
    {
      ad.e("MicroMsg.BitmapUtil", "create thumbnail from orig failed: ".concat(String.valueOf(paramString2)));
      AppMethodBeat.o(156112);
    }
    return false;
  }
  
  public static Bitmap c(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    AppMethodBeat.i(169238);
    label18:
    int k;
    if (paramBitmap1 == null)
    {
      i = 0;
      if (paramBitmap1 != null) {
        break label98;
      }
      j = 0;
      if (paramBitmap2 != null) {
        break label106;
      }
      k = 0;
      label25:
      if (paramBitmap2 != null) {
        break label115;
      }
    }
    label98:
    label106:
    label115:
    for (int m = 0;; m = paramBitmap2.getHeight())
    {
      ad.i("MicroMsg.BitmapUtil", "src(%d,%d) background(%d,%d)", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) });
      if ((paramBitmap1 != null) && (paramBitmap2 != null)) {
        break label124;
      }
      AppMethodBeat.o(169238);
      return null;
      i = paramBitmap1.getWidth();
      break;
      j = paramBitmap1.getHeight();
      break label18;
      k = paramBitmap2.getWidth();
      break label25;
    }
    label124:
    int i = Math.max(paramBitmap1.getWidth(), paramBitmap2.getWidth());
    int j = Math.max(paramBitmap1.getHeight(), paramBitmap2.getHeight());
    Bitmap localBitmap = f.ay(createBitmap(i, j, Bitmap.Config.ARGB_8888, false));
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawBitmap(paramBitmap2, (i - paramBitmap2.getWidth()) / 2.0F, (j - paramBitmap2.getHeight()) / 2.0F, new Paint());
    localCanvas.drawBitmap(paramBitmap1, (i - paramBitmap1.getWidth()) / 2.0F, (j - paramBitmap1.getHeight()) / 2.0F, new Paint());
    paramBitmap2.recycle();
    paramBitmap1.recycle();
    AppMethodBeat.o(169238);
    return localBitmap;
  }
  
  public static BitmapFactory.Options c(InputStream paramInputStream, boolean paramBoolean)
  {
    AppMethodBeat.i(169229);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    if (paramInputStream == null)
    {
      ad.e("MicroMsg.BitmapUtil", "getImageOptions decode stream is null!!");
      AppMethodBeat.o(169229);
      return localOptions;
    }
    Object localObject = paramInputStream;
    if (!paramBoolean)
    {
      localObject = paramInputStream;
      if (!paramInputStream.markSupported())
      {
        if (!(paramInputStream instanceof FileInputStream)) {
          break label127;
        }
        localObject = new o((FileInputStream)paramInputStream);
      }
      ((InputStream)localObject).mark(8388608);
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          paramInputStream = MMBitmapFactory.decodeStream((InputStream)localObject, null, localOptions);
          if (paramInputStream != null)
          {
            ad.i("MicroMsg.BitmapUtil", "getImageOptions bitmap recycle. %s", new Object[] { paramInputStream });
            paramInputStream.recycle();
          }
        }
        catch (OutOfMemoryError paramInputStream)
        {
          label127:
          ad.printErrStackTrace("MicroMsg.BitmapUtil", paramInputStream, "Decode bitmap failed.", new Object[0]);
          if (!paramBoolean) {
            continue;
          }
          try
          {
            ((InputStream)localObject).close();
          }
          catch (IOException paramInputStream)
          {
            ad.printErrStackTrace("MicroMsg.BitmapUtil", paramInputStream, "hy: stream close failed ", new Object[0]);
          }
          continue;
          ad.w("MicroMsg.BitmapUtil", "hy: not auto close. reset for invoker");
          try
          {
            ((InputStream)localObject).reset();
          }
          catch (Exception paramInputStream)
          {
            ad.printErrStackTrace("MicroMsg.BitmapUtil", paramInputStream, "hy: stream reset failed", new Object[0]);
          }
          continue;
        }
        finally
        {
          if (!paramBoolean) {
            break label296;
          }
        }
        try
        {
          ((InputStream)localObject).close();
          AppMethodBeat.o(169229);
          return localOptions;
          localObject = new BufferedInputStream(paramInputStream);
        }
        catch (IOException paramInputStream)
        {
          ad.printErrStackTrace("MicroMsg.BitmapUtil", paramInputStream, "hy: stream close failed ", new Object[0]);
        }
      }
      ad.w("MicroMsg.BitmapUtil", "hy: not auto close. reset for invoker");
      try
      {
        ((InputStream)localObject).reset();
      }
      catch (Exception paramInputStream)
      {
        ad.printErrStackTrace("MicroMsg.BitmapUtil", paramInputStream, "hy: stream reset failed", new Object[0]);
      }
    }
    for (;;)
    {
      try
      {
        ((InputStream)localObject).close();
        AppMethodBeat.o(169229);
        throw paramInputStream;
      }
      catch (IOException localIOException)
      {
        ad.printErrStackTrace("MicroMsg.BitmapUtil", localIOException, "hy: stream close failed ", new Object[0]);
        continue;
      }
      label296:
      ad.w("MicroMsg.BitmapUtil", "hy: not auto close. reset for invoker");
      try
      {
        localIOException.reset();
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.BitmapUtil", localException, "hy: stream reset failed", new Object[0]);
      }
    }
  }
  
  /* Error */
  public static void c(String paramString, PInt paramPInt1, PInt paramPInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc_w 1033
    //   6: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: new 212	android/graphics/BitmapFactory$Options
    //   12: dup
    //   13: invokespecial 213	android/graphics/BitmapFactory$Options:<init>	()V
    //   16: astore 5
    //   18: aload 5
    //   20: iconst_1
    //   21: putfield 222	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   24: aload_0
    //   25: invokestatic 548	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   28: astore_0
    //   29: aload_0
    //   30: aconst_null
    //   31: aload 5
    //   33: invokestatic 522	com/tencent/mm/graphics/MMBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   36: astore_3
    //   37: aload_3
    //   38: astore 4
    //   40: aload 4
    //   42: astore_3
    //   43: aload_0
    //   44: ifnull +10 -> 54
    //   47: aload_0
    //   48: invokevirtual 533	java/io/InputStream:close	()V
    //   51: aload 4
    //   53: astore_3
    //   54: aload_3
    //   55: ifnull +23 -> 78
    //   58: ldc 150
    //   60: ldc_w 1035
    //   63: iconst_1
    //   64: anewarray 4	java/lang/Object
    //   67: dup
    //   68: iconst_0
    //   69: aload_3
    //   70: aastore
    //   71: invokestatic 165	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   74: aload_3
    //   75: invokevirtual 302	android/graphics/Bitmap:recycle	()V
    //   78: aload_1
    //   79: aload 5
    //   81: getfield 228	android/graphics/BitmapFactory$Options:outWidth	I
    //   84: putfield 734	com/tencent/mm/pointers/PInt:value	I
    //   87: aload_2
    //   88: aload 5
    //   90: getfield 231	android/graphics/BitmapFactory$Options:outHeight	I
    //   93: putfield 734	com/tencent/mm/pointers/PInt:value	I
    //   96: ldc_w 1033
    //   99: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: return
    //   103: astore_0
    //   104: ldc 150
    //   106: aload_0
    //   107: ldc 248
    //   109: iconst_0
    //   110: anewarray 4	java/lang/Object
    //   113: invokestatic 252	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   116: aload 4
    //   118: astore_3
    //   119: goto -65 -> 54
    //   122: astore_0
    //   123: aconst_null
    //   124: astore_0
    //   125: aload 4
    //   127: astore_3
    //   128: aload_0
    //   129: ifnull -75 -> 54
    //   132: aload_0
    //   133: invokevirtual 533	java/io/InputStream:close	()V
    //   136: aload 4
    //   138: astore_3
    //   139: goto -85 -> 54
    //   142: astore_0
    //   143: ldc 150
    //   145: aload_0
    //   146: ldc 248
    //   148: iconst_0
    //   149: anewarray 4	java/lang/Object
    //   152: invokestatic 252	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   155: aload 4
    //   157: astore_3
    //   158: goto -104 -> 54
    //   161: astore_0
    //   162: aconst_null
    //   163: astore_1
    //   164: aload_1
    //   165: ifnull +7 -> 172
    //   168: aload_1
    //   169: invokevirtual 533	java/io/InputStream:close	()V
    //   172: ldc_w 1033
    //   175: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   178: aload_0
    //   179: athrow
    //   180: astore_1
    //   181: ldc 150
    //   183: aload_1
    //   184: ldc 248
    //   186: iconst_0
    //   187: anewarray 4	java/lang/Object
    //   190: invokestatic 252	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   193: goto -21 -> 172
    //   196: astore_1
    //   197: aload_0
    //   198: astore_2
    //   199: aload_1
    //   200: astore_0
    //   201: aload_2
    //   202: astore_1
    //   203: goto -39 -> 164
    //   206: astore_3
    //   207: goto -82 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	210	0	paramString	String
    //   0	210	1	paramPInt1	PInt
    //   0	210	2	paramPInt2	PInt
    //   36	122	3	localObject1	Object
    //   206	1	3	localFileNotFoundException	FileNotFoundException
    //   1	155	4	localObject2	Object
    //   16	73	5	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   47	51	103	java/io/IOException
    //   24	29	122	java/io/FileNotFoundException
    //   132	136	142	java/io/IOException
    //   24	29	161	finally
    //   168	172	180	java/io/IOException
    //   29	37	196	finally
    //   29	37	206	java/io/FileNotFoundException
  }
  
  public static boolean c(String paramString1, int paramInt1, int paramInt2, Bitmap.CompressFormat paramCompressFormat, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(156106);
    boolean bool = a(paramString1, paramInt1, paramInt2, paramCompressFormat, paramInt3, paramString2, true, new PInt(), new PInt());
    AppMethodBeat.o(156106);
    return bool;
  }
  
  public static Bitmap cr(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(156127);
    paramArrayOfByte = decodeByteArray(paramArrayOfByte, 0, 0);
    AppMethodBeat.o(156127);
    return paramArrayOfByte;
  }
  
  public static Bitmap createBitmap(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    AppMethodBeat.i(221322);
    paramConfig = createBitmap(paramInt1, paramInt2, paramConfig, false);
    AppMethodBeat.o(221322);
    return paramConfig;
  }
  
  private static Bitmap createBitmap(int paramInt1, int paramInt2, Bitmap.Config paramConfig, boolean paramBoolean)
  {
    Object localObject = null;
    AppMethodBeat.i(156124);
    try
    {
      paramConfig = Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
      aE(paramConfig);
      paramConfig = f.ay(paramConfig);
      AppMethodBeat.o(156124);
      return paramConfig;
    }
    catch (Throwable paramConfig)
    {
      for (;;)
      {
        if (paramBoolean)
        {
          AppMethodBeat.o(156124);
          return null;
        }
        try
        {
          paramConfig = aQF();
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
  public static Bitmap createVideoThumbnail(String paramString, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 1059
    //   3: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 1061	com/tencent/mm/compatible/h/d
    //   9: dup
    //   10: invokespecial 1062	com/tencent/mm/compatible/h/d:<init>	()V
    //   13: astore 5
    //   15: aload 5
    //   17: aload_0
    //   18: invokevirtual 1065	com/tencent/mm/compatible/h/d:setDataSource	(Ljava/lang/String;)V
    //   21: aload 5
    //   23: ldc2_w 92
    //   26: invokevirtual 1069	com/tencent/mm/compatible/h/d:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   29: astore_0
    //   30: aload 5
    //   32: invokevirtual 1072	com/tencent/mm/compatible/h/d:release	()V
    //   35: aload_0
    //   36: ifnonnull +59 -> 95
    //   39: ldc_w 1059
    //   42: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: aconst_null
    //   46: areturn
    //   47: astore_0
    //   48: aload 5
    //   50: invokevirtual 1072	com/tencent/mm/compatible/h/d:release	()V
    //   53: aconst_null
    //   54: astore_0
    //   55: goto -20 -> 35
    //   58: astore_0
    //   59: aconst_null
    //   60: astore_0
    //   61: goto -26 -> 35
    //   64: astore_0
    //   65: aload 5
    //   67: invokevirtual 1072	com/tencent/mm/compatible/h/d:release	()V
    //   70: aconst_null
    //   71: astore_0
    //   72: goto -37 -> 35
    //   75: astore_0
    //   76: aconst_null
    //   77: astore_0
    //   78: goto -43 -> 35
    //   81: astore_0
    //   82: aload 5
    //   84: invokevirtual 1072	com/tencent/mm/compatible/h/d:release	()V
    //   87: ldc_w 1059
    //   90: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: aload_0
    //   94: athrow
    //   95: iload_1
    //   96: iconst_1
    //   97: if_icmpne +69 -> 166
    //   100: aload_0
    //   101: invokevirtual 159	android/graphics/Bitmap:getWidth	()I
    //   104: istore_1
    //   105: aload_0
    //   106: invokevirtual 160	android/graphics/Bitmap:getHeight	()I
    //   109: istore_3
    //   110: iload_1
    //   111: iload_3
    //   112: invokestatic 785	java/lang/Math:max	(II)I
    //   115: istore 4
    //   117: aload_0
    //   118: astore 5
    //   120: iload 4
    //   122: sipush 512
    //   125: if_icmple +32 -> 157
    //   128: ldc_w 1073
    //   131: iload 4
    //   133: i2f
    //   134: fdiv
    //   135: fstore_2
    //   136: aload_0
    //   137: iload_1
    //   138: i2f
    //   139: fload_2
    //   140: fmul
    //   141: invokestatic 109	java/lang/Math:round	(F)I
    //   144: iload_3
    //   145: i2f
    //   146: fload_2
    //   147: fmul
    //   148: invokestatic 109	java/lang/Math:round	(F)I
    //   151: iconst_1
    //   152: invokestatic 355	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   155: astore 5
    //   157: ldc_w 1059
    //   160: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   163: aload 5
    //   165: areturn
    //   166: aload_0
    //   167: astore 5
    //   169: iload_1
    //   170: iconst_3
    //   171: if_icmpne -14 -> 157
    //   174: aload_0
    //   175: bipush 96
    //   177: bipush 96
    //   179: iconst_2
    //   180: invokestatic 1078	android/media/ThumbnailUtils:extractThumbnail	(Landroid/graphics/Bitmap;III)Landroid/graphics/Bitmap;
    //   183: astore 5
    //   185: goto -28 -> 157
    //   188: astore 5
    //   190: goto -155 -> 35
    //   193: astore 5
    //   195: goto -108 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	paramString	String
    //   0	198	1	paramInt	int
    //   135	12	2	f	float
    //   109	36	3	i	int
    //   115	17	4	j	int
    //   13	171	5	localObject	Object
    //   188	1	5	localRuntimeException1	java.lang.RuntimeException
    //   193	1	5	localRuntimeException2	java.lang.RuntimeException
    // Exception table:
    //   from	to	target	type
    //   15	30	47	java/lang/IllegalArgumentException
    //   48	53	58	java/lang/RuntimeException
    //   15	30	64	java/lang/RuntimeException
    //   65	70	75	java/lang/RuntimeException
    //   15	30	81	finally
    //   30	35	188	java/lang/RuntimeException
    //   82	87	193	java/lang/RuntimeException
  }
  
  public static String cs(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(156172);
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
      ad.d("MicroMsg.BitmapUtil", "match 0xff-" + Integer.toHexString(j & 0xFF) + "  at:" + i);
      if (i + 1 + 17 >= paramArrayOfByte.length) {
        ad.d("MicroMsg.BitmapUtil", "not engouht len at ".concat(String.valueOf(i)));
      }
    }
    else
    {
      AppMethodBeat.o(156172);
      return null;
    }
    int j = i + 2;
    if (paramArrayOfByte[(j + 7)] != 3) {
      ad.d("MicroMsg.BitmapUtil", "num != 3 at ".concat(String.valueOf(i)));
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
            ad.d("MicroMsg.BitmapUtil", "Y/Cb/Cr Tag is not right at ".concat(String.valueOf(i)));
          }
          m = paramArrayOfByte[(j + 9)];
          i1 = paramArrayOfByte[(j + 12)];
          k = paramArrayOfByte[(j + 15)];
        } while ((m == 0) || (i1 == 0) || (k == 0));
        if ((m == i1) && (m == k))
        {
          AppMethodBeat.o(156172);
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
        AppMethodBeat.o(156172);
        return "YUV420";
      }
    } while ((m != i1) || (m != k));
    AppMethodBeat.o(156172);
    return "YUV422";
  }
  
  public static Bitmap d(int paramInt, Bitmap paramBitmap)
  {
    AppMethodBeat.i(169230);
    paramBitmap = a(paramBitmap, paramInt);
    AppMethodBeat.o(169230);
    return paramBitmap;
  }
  
  /* Error */
  public static Bitmap d(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 1106
    //   3: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 494	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifeq +19 -> 29
    //   13: ldc 150
    //   15: ldc_w 1108
    //   18: invokestatic 195	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: ldc_w 1106
    //   24: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aconst_null
    //   28: areturn
    //   29: aload_0
    //   30: invokestatic 914	com/tencent/mm/sdk/platformtools/g:aQc	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   33: astore 4
    //   35: aload_0
    //   36: invokestatic 548	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   39: astore_0
    //   40: aload_0
    //   41: aload 4
    //   43: getfield 228	android/graphics/BitmapFactory$Options:outWidth	I
    //   46: aload 4
    //   48: getfield 231	android/graphics/BitmapFactory$Options:outHeight	I
    //   51: iload_2
    //   52: iload_1
    //   53: iload_3
    //   54: invokestatic 1110	com/tencent/mm/sdk/platformtools/g:a	(Ljava/io/InputStream;IIIIZ)Landroid/graphics/Bitmap;
    //   57: astore 4
    //   59: aload_0
    //   60: ifnull +7 -> 67
    //   63: aload_0
    //   64: invokevirtual 533	java/io/InputStream:close	()V
    //   67: ldc_w 1106
    //   70: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: aload 4
    //   75: areturn
    //   76: astore 4
    //   78: aconst_null
    //   79: astore_0
    //   80: ldc 150
    //   82: aload 4
    //   84: ldc_w 1112
    //   87: iconst_0
    //   88: anewarray 4	java/lang/Object
    //   91: invokestatic 252	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   94: aload_0
    //   95: ifnull +7 -> 102
    //   98: aload_0
    //   99: invokevirtual 533	java/io/InputStream:close	()V
    //   102: ldc_w 1106
    //   105: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   108: aconst_null
    //   109: areturn
    //   110: astore 4
    //   112: aconst_null
    //   113: astore_0
    //   114: aload_0
    //   115: ifnull +7 -> 122
    //   118: aload_0
    //   119: invokevirtual 533	java/io/InputStream:close	()V
    //   122: ldc_w 1106
    //   125: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(156126);
    if (bt.cC(paramArrayOfByte))
    {
      ad.w("MicroMsg.BitmapUtil", "error input: data is null");
      AppMethodBeat.o(156126);
      return null;
    }
    if ((paramInt1 < 0) || (paramInt2 < 0))
    {
      ad.w("MicroMsg.BitmapUtil", "error input: targetWidth %d, targetHeight %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(156126);
      return null;
    }
    paramArrayOfByte = a(0, null, paramArrayOfByte, null, false, 0.0F, paramInt1, paramInt2);
    AppMethodBeat.o(156126);
    return paramArrayOfByte;
  }
  
  @Deprecated
  public static Bitmap decodeFile(String paramString)
  {
    AppMethodBeat.i(221323);
    paramString = decodeFile(paramString, null);
    AppMethodBeat.o(221323);
    return paramString;
  }
  
  /* Error */
  public static Bitmap decodeFile(String paramString, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: ldc_w 1123
    //   3: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: astore_3
    //   8: aload_1
    //   9: ifnonnull +11 -> 20
    //   12: new 212	android/graphics/BitmapFactory$Options
    //   15: dup
    //   16: invokespecial 213	android/graphics/BitmapFactory$Options:<init>	()V
    //   19: astore_3
    //   20: aload_0
    //   21: invokestatic 548	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   24: astore_2
    //   25: aload_2
    //   26: astore_1
    //   27: aload_2
    //   28: aconst_null
    //   29: aload_3
    //   30: invokestatic 522	com/tencent/mm/graphics/MMBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   33: astore_3
    //   34: aload_2
    //   35: ifnull +7 -> 42
    //   38: aload_2
    //   39: invokevirtual 533	java/io/InputStream:close	()V
    //   42: ldc_w 1123
    //   45: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: aload_3
    //   49: areturn
    //   50: astore_3
    //   51: aconst_null
    //   52: astore_2
    //   53: aload_2
    //   54: astore_1
    //   55: ldc 150
    //   57: ldc_w 1125
    //   60: iconst_2
    //   61: anewarray 4	java/lang/Object
    //   64: dup
    //   65: iconst_0
    //   66: aload_0
    //   67: aastore
    //   68: dup
    //   69: iconst_1
    //   70: aload_3
    //   71: invokevirtual 1126	java/io/IOException:getMessage	()Ljava/lang/String;
    //   74: aastore
    //   75: invokestatic 361	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   78: aload_2
    //   79: ifnull +7 -> 86
    //   82: aload_2
    //   83: invokevirtual 533	java/io/InputStream:close	()V
    //   86: ldc_w 1123
    //   89: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: aconst_null
    //   93: areturn
    //   94: astore_0
    //   95: aconst_null
    //   96: astore_1
    //   97: aload_1
    //   98: ifnull +7 -> 105
    //   101: aload_1
    //   102: invokevirtual 533	java/io/InputStream:close	()V
    //   105: ldc_w 1123
    //   108: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(156133);
    paramInputStream = a(paramInputStream, 0.0F, 0, 0);
    AppMethodBeat.o(156133);
    return paramInputStream;
  }
  
  public static Bitmap f(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195169);
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramInt1, paramInt2);
      paramBitmap.recycle();
      AppMethodBeat.o(195169);
      return localBitmap;
    }
    catch (Throwable localThrowable)
    {
      if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
        paramBitmap.recycle();
      }
      AppMethodBeat.o(195169);
    }
    return null;
  }
  
  public static void fjY() {}
  
  public static Bitmap ga(View paramView)
  {
    AppMethodBeat.i(156157);
    if (paramView == null)
    {
      AppMethodBeat.o(156157);
      return null;
    }
    if ((paramView.getWidth() == 0) || (paramView.getHeight() == 0))
    {
      AppMethodBeat.o(156157);
      return null;
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Drawable localDrawable = paramView.getBackground();
    if (localDrawable != null) {
      localDrawable.draw(localCanvas);
    }
    paramView.draw(localCanvas);
    aE(localBitmap);
    paramView = f.ay(localBitmap);
    AppMethodBeat.o(156157);
    return paramView;
  }
  
  public static Bitmap gb(View paramView)
  {
    AppMethodBeat.i(156158);
    if (paramView == null)
    {
      AppMethodBeat.o(156158);
      return null;
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Drawable localDrawable = paramView.getBackground();
    if (localDrawable != null) {
      localDrawable.draw(localCanvas);
    }
    a(localCanvas, paramView);
    aE(localBitmap);
    paramView = f.ay(localBitmap);
    AppMethodBeat.o(156158);
    return paramView;
  }
  
  public static byte[] j(Bitmap paramBitmap, int paramInt)
  {
    AppMethodBeat.i(156154);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(156154);
      return new byte[0];
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    a(paramBitmap, Bitmap.CompressFormat.JPEG, paramInt, localByteArrayOutputStream);
    paramBitmap = localByteArrayOutputStream.toByteArray();
    try
    {
      localByteArrayOutputStream.close();
      AppMethodBeat.o(156154);
      return paramBitmap;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.BitmapUtil", localException, "", new Object[0]);
      }
    }
  }
  
  public static Bitmap ju(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(156162);
    if ((paramInt1 < 0) || (paramInt2 < 0))
    {
      ad.w("MicroMsg.BitmapUtil", "createLocation fail. srcResId or maskResId is null,or width/height <0");
      AppMethodBeat.o(156162);
      return null;
    }
    long l = System.currentTimeMillis();
    Bitmap localBitmap = f.ay(createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888, false));
    aE(localBitmap);
    NinePatchDrawable localNinePatchDrawable = (NinePatchDrawable)aj.getContext().getResources().getDrawable(2131232890);
    localNinePatchDrawable.setBounds(0, 0, paramInt1, paramInt2);
    localNinePatchDrawable.draw(new Canvas(localBitmap));
    ad.d("MicroMsg.BitmapUtil", "create nine patch bitmap " + (System.currentTimeMillis() - l));
    localBitmap = k(localBitmap, 2131233224);
    AppMethodBeat.o(156162);
    return localBitmap;
  }
  
  public static Bitmap k(Bitmap paramBitmap, int paramInt)
  {
    AppMethodBeat.i(156161);
    ad.d("MicroMsg.BitmapUtil", "begin createChattingImage");
    long l1 = System.currentTimeMillis();
    if (paramBitmap == null)
    {
      ad.w("MicroMsg.BitmapUtil", "sourceBitmap is null .");
      AppMethodBeat.o(156161);
      return null;
    }
    aE(paramBitmap);
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    if ((i <= 0) || (j <= 0))
    {
      ad.w("MicroMsg.BitmapUtil", "sourceBitmap width or height is 0.");
      AppMethodBeat.o(156161);
      return null;
    }
    long l2 = System.currentTimeMillis();
    Bitmap localBitmap;
    try
    {
      localBitmap = createBitmap(i, j, Bitmap.Config.ARGB_8888, false);
      localObject = (NinePatchDrawable)aj.getContext().getResources().getDrawable(paramInt);
      ((NinePatchDrawable)localObject).setBounds(0, 0, i, j);
      ((NinePatchDrawable)localObject).draw(new Canvas(localBitmap));
      ad.d("MicroMsg.BitmapUtil", "create nine patch bitmap " + (System.currentTimeMillis() - l2));
      if (localBitmap == null)
      {
        ad.e("MicroMsg.BitmapUtil", "[createChattingImage] maskBitmap is null.");
        AppMethodBeat.o(156161);
        return null;
      }
    }
    catch (Exception paramBitmap)
    {
      ad.e("MicroMsg.BitmapUtil", "[createChattingImage] create nine pathc bitmap faild.");
      AppMethodBeat.o(156161);
      return null;
    }
    paramInt = localBitmap.getWidth();
    int k = localBitmap.getHeight();
    if ((paramInt <= 0) || (k <= 0))
    {
      ad.w("MicroMsg.BitmapUtil", "maskBitmap width or height is 0.");
      AppMethodBeat.o(156161);
      return null;
    }
    if ((k != j) || (paramInt != i))
    {
      ad.e("MicroMsg.BitmapUtil", "maskHeiht maskWidth != height width.");
      AppMethodBeat.o(156161);
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
            break label492;
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
        ad.e("MicroMsg.BitmapUtil", paramBitmap.toString());
        ad.d("MicroMsg.BitmapUtil", "meger pixels  " + (System.currentTimeMillis() - l2));
        l2 = System.currentTimeMillis();
        localBitmap.setPixels((int[])localObject, 0, i, 0, 0, i, j);
        ad.d("MicroMsg.BitmapUtil", "setPixels " + (System.currentTimeMillis() - l2));
        ad.d("MicroMsg.BitmapUtil", "createTime" + (System.currentTimeMillis() - l1));
        aE(localBitmap);
        paramBitmap = f.ay(localBitmap);
        AppMethodBeat.o(156161);
        return paramBitmap;
      }
      label492:
      paramInt += 1;
    }
  }
  
  public static Bitmap l(Bitmap paramBitmap, int paramInt)
  {
    AppMethodBeat.i(156166);
    if (paramBitmap == null)
    {
      ad.w("MicroMsg.BitmapUtil", "fastblur: but sentBitmap is null");
      AppMethodBeat.o(156166);
      return null;
    }
    paramBitmap = paramBitmap.copy(paramBitmap.getConfig(), true);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(156166);
      return null;
    }
    int i13 = paramBitmap.getWidth();
    int i14 = paramBitmap.getHeight();
    int[] arrayOfInt1 = new int[i13 * i14];
    ad.e("pix", i13 + " " + i14 + " " + arrayOfInt1.length);
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
    ad.e("pix", i13 + " " + i14 + " " + i16);
    paramBitmap.setPixels(arrayOfInt1, 0, i13, 0, 0, i13, i14);
    aE(paramBitmap);
    paramBitmap = f.ay(paramBitmap);
    AppMethodBeat.o(156166);
    return paramBitmap;
  }
  
  public static Bitmap p(String paramString, float paramFloat)
  {
    AppMethodBeat.i(156119);
    paramString = a(paramString, 0, 0, paramFloat);
    AppMethodBeat.o(156119);
    return paramString;
  }
  
  public static Bitmap s(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(156163);
    if ((paramString == null) || (paramString.equals("")) || (paramInt1 < 0) || (paramInt2 < 0) || (paramInt3 < 0))
    {
      ad.w("MicroMsg.BitmapUtil", "createLocation fail. srcResId or maskResId is null,or width/height <0");
      AppMethodBeat.o(156163);
      return null;
    }
    paramString = f.i(decodeByteArray(i.aY(paramString, 0, -1), 0, 0), paramString);
    if ((paramString == null) || (paramString.isRecycled()))
    {
      AppMethodBeat.o(156163);
      return null;
    }
    long l = System.currentTimeMillis();
    Bitmap localBitmap = f.ay(createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888, false));
    aE(localBitmap);
    Canvas localCanvas = new Canvas(localBitmap);
    ad.d("MicroMsg.BitmapUtil", "bm size w %d h %d target w %d h %d", new Object[] { Integer.valueOf(paramString.getWidth()), Integer.valueOf(paramString.getHeight()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    localCanvas.drawBitmap(paramString, null, new Rect(0, 0, paramInt2, paramInt3), new Paint());
    ad.d("MicroMsg.BitmapUtil", "create nine patch bitmap " + (System.currentTimeMillis() - l));
    paramString = k(localBitmap, paramInt1);
    AppMethodBeat.o(156163);
    return paramString;
  }
  
  public static Bitmap v(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(156117);
    Bitmap localBitmap = a(paramInt, null, null, null, false, paramFloat, 0, 0);
    AppMethodBeat.o(156117);
    return localBitmap;
  }
  
  public static Bitmap y(Uri paramUri)
  {
    AppMethodBeat.i(156123);
    paramUri = a(0, null, null, paramUri, false, 0.0F, 0, 0);
    AppMethodBeat.o(156123);
    return paramUri;
  }
  
  private static List<x> z(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(156160);
    ArrayList localArrayList = new ArrayList();
    if ((paramView instanceof TextureView))
    {
      x localx = new x();
      localx.IcR = ((TextureView)paramView);
      localx.left = paramInt1;
      localx.top = paramInt2;
      localArrayList.add(localx);
    }
    for (;;)
    {
      AppMethodBeat.o(156160);
      return localArrayList;
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        int i = 0;
        while (i < paramView.getChildCount())
        {
          localArrayList.addAll(z(paramView.getChildAt(i), (int)(paramView.getX() + paramInt1), (int)(paramView.getY() + paramInt2)));
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.g
 * JD-Core Version:    0.7.0.1
 */