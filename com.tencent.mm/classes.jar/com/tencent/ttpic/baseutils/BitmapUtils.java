package com.tencent.ttpic.baseutils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@SuppressLint({"NewApi"})
public class BitmapUtils
{
  public static final int JPEG_QUALITY = 99;
  public static final String RES_PREFIX_ASSETS = "assets://";
  public static final String RES_PREFIX_HTTP = "http://";
  public static final String RES_PREFIX_HTTPS = "https://";
  public static final String RES_PREFIX_STORAGE = "/";
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(49652);
    TAG = BitmapUtils.class.getSimpleName();
    AppMethodBeat.o(49652);
  }
  
  private static boolean IsSupportImgType(String paramString)
  {
    AppMethodBeat.i(49645);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null) {
      if ((!paramString.equalsIgnoreCase("image/jpeg")) && (!paramString.equalsIgnoreCase("image/png")))
      {
        bool1 = bool2;
        if (!paramString.equalsIgnoreCase("image/gif")) {}
      }
      else
      {
        bool1 = true;
      }
    }
    AppMethodBeat.o(49645);
    return bool1;
  }
  
  public static boolean bmpIsExists(String paramString)
  {
    AppMethodBeat.i(49600);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(49600);
      return false;
    }
    if ((paramString.startsWith("assets://")) || (new File(paramString).exists()))
    {
      AppMethodBeat.o(49600);
      return true;
    }
    AppMethodBeat.o(49600);
    return false;
  }
  
  public static byte[] bmpToByteArray(Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(49605);
    if (!isLegal(paramBitmap))
    {
      AppMethodBeat.o(49605);
      return null;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 80, localByteArrayOutputStream);
    if (paramBoolean) {
      paramBitmap.recycle();
    }
    paramBitmap = localByteArrayOutputStream.toByteArray();
    try
    {
      localByteArrayOutputStream.close();
      AppMethodBeat.o(49605);
      return paramBitmap;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        LogUtils.e(localException);
      }
    }
  }
  
  private static BitmapUtils.Size calcNewSize(BitmapUtils.Size paramSize, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49646);
    int i;
    if (paramSize.height / paramSize.width >= 1.0D) {
      i = paramSize.height;
    }
    for (int j = paramSize.width;; j = paramSize.height)
    {
      paramSize = getNewSize(j, i, paramInt1, paramInt2);
      AppMethodBeat.o(49646);
      return paramSize;
      i = paramSize.width;
    }
  }
  
  public static int calculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(49650);
    int m = paramOptions.outHeight;
    int n = paramOptions.outWidth;
    int j = 1;
    int i;
    float f1;
    float f2;
    if ((paramInt2 <= 0) || (m <= paramInt2))
    {
      i = j;
      if (paramInt1 > 0)
      {
        i = j;
        if (n <= paramInt1) {}
      }
    }
    else
    {
      i = Math.round(m / paramInt2);
      j = Math.round(n / paramInt1);
      if (paramBoolean)
      {
        if (i < j) {}
        for (;;)
        {
          f1 = n * m;
          f2 = paramInt1 * paramInt2 * 2;
          j = i;
          if (!ApiHelper.hasNougat()) {
            break label307;
          }
          j = i;
          while (f1 / (j * j) >= f2) {
            j += 1;
          }
          i = j;
        }
      }
      if (i < j) {
        i = j;
      }
      for (;;)
      {
        break;
      }
      i = j;
      if (paramBoolean) {
        if (n / j <= paramInt1 * 1.5D)
        {
          i = j;
          if (m / j <= paramInt2 * 1.5D) {}
        }
        else
        {
          i = n / paramInt1;
          j = m / paramInt2;
          if (i <= j) {
            break label300;
          }
        }
      }
    }
    for (;;)
    {
      LogUtils.d(TAG, "[calculateInSampleSize] source size = " + n + " * " + m + ", request size = " + paramInt1 + " * " + paramInt2 + ", inSampleSize = " + i + ", preferLarge = " + paramBoolean);
      AppMethodBeat.o(49650);
      return i;
      label300:
      i = j;
      continue;
      label307:
      while (f1 / (j * j) > f2) {
        j += 1;
      }
      if (!isPowerOf2(j))
      {
        i = j;
        for (;;)
        {
          k = i;
          if (i <= 2) {
            break;
          }
          k = i;
          if (isPowerOf2(i)) {
            break;
          }
          i -= 1;
        }
      }
      int k = j;
      i = j;
      if (paramBoolean) {
        if (n / k <= paramInt1 * 1.5D)
        {
          i = j;
          if (m / k <= paramInt2 * 1.5D) {}
        }
        else
        {
          i = k * 2;
        }
      }
    }
  }
  
  public static int calculateInSampleSizeNew(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(49651);
    int i = paramOptions.outHeight;
    int j = paramOptions.outWidth;
    float f1 = Math.max(j, i);
    float f2 = Math.min(j, i);
    float f3 = Math.max(paramInt1, paramInt2);
    if ((Math.min(paramInt1, paramInt2) <= 0.0F) || (f1 <= f3))
    {
      AppMethodBeat.o(49651);
      return 1;
    }
    if (f1 / f2 > 2.0F)
    {
      f1 = i * j;
      f2 = paramInt1 * paramInt2;
      if (!ApiHelper.hasNougat()) {
        break label276;
      }
      paramInt2 = 1;
      while (f1 / (paramInt2 * paramInt2) >= f2) {
        paramInt2 += 1;
      }
      paramInt1 = paramInt2;
      if (paramBoolean)
      {
        paramInt1 = paramInt2;
        if (paramInt2 > 1) {
          paramInt1 = paramInt2 - 1;
        }
      }
      AppMethodBeat.o(49651);
      return paramInt1;
    }
    for (;;)
    {
      if (f1 / (paramInt2 * paramInt2) >= f2)
      {
        paramInt2 *= 2;
      }
      else
      {
        paramInt1 = paramInt2;
        if (!paramBoolean) {
          break;
        }
        paramInt1 = paramInt2;
        if (paramInt2 <= 1) {
          break;
        }
        paramInt1 = paramInt2 / 2;
        break;
        if (ApiHelper.hasNougat())
        {
          paramInt2 = 1;
          while (f1 / paramInt2 >= f3) {
            paramInt2 += 1;
          }
          paramInt1 = paramInt2;
          if (!paramBoolean) {
            break;
          }
          paramInt1 = paramInt2;
          if (paramInt2 <= 1) {
            break;
          }
          paramInt1 = paramInt2 - 1;
          break;
        }
        for (;;)
        {
          if (f1 / paramInt2 >= f3)
          {
            paramInt2 *= 2;
          }
          else
          {
            paramInt1 = paramInt2;
            if (!paramBoolean) {
              break;
            }
            paramInt1 = paramInt2;
            if (paramInt2 <= 1) {
              break;
            }
            paramInt1 = paramInt2 / 2;
            break;
            paramInt2 = 1;
          }
        }
        label276:
        paramInt2 = 1;
      }
    }
  }
  
  public static String compressImage(String paramString, BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49642);
    try
    {
      paramString = compressImageFile(paramString, getScaledOpt(paramOptions, paramInt1, paramInt2), new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separatorChar + "Pitu"));
      AppMethodBeat.o(49642);
      return paramString;
    }
    catch (Exception paramString)
    {
      LogUtils.e(paramString);
      AppMethodBeat.o(49642);
    }
    return null;
  }
  
  /* Error */
  private static String compressImageFile(String paramString, BitmapFactory.Options paramOptions, File paramFile)
  {
    // Byte code:
    //   0: ldc 241
    //   2: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 45	com/tencent/ttpic/baseutils/BitmapUtils:TAG	Ljava/lang/String;
    //   8: ldc 243
    //   10: iconst_3
    //   11: anewarray 4	java/lang/Object
    //   14: dup
    //   15: iconst_0
    //   16: aload_0
    //   17: aastore
    //   18: dup
    //   19: iconst_1
    //   20: aload_1
    //   21: aastore
    //   22: dup
    //   23: iconst_2
    //   24: aload_2
    //   25: invokevirtual 223	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   28: aastore
    //   29: invokestatic 246	com/tencent/ttpic/baseutils/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   32: aload_2
    //   33: invokevirtual 86	java/io/File:exists	()Z
    //   36: ifne +8 -> 44
    //   39: aload_2
    //   40: invokevirtual 249	java/io/File:mkdirs	()Z
    //   43: pop
    //   44: new 165	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   51: aload_2
    //   52: invokevirtual 223	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   55: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: getstatic 252	java/io/File:separator	Ljava/lang/String;
    //   61: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: ldc 254
    //   66: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: new 256	java/util/Date
    //   72: dup
    //   73: invokespecial 257	java/util/Date:<init>	()V
    //   76: invokevirtual 261	java/util/Date:getTime	()J
    //   79: invokevirtual 264	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   82: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: astore 4
    //   87: new 79	java/io/File
    //   90: dup
    //   91: aload 4
    //   93: invokespecial 82	java/io/File:<init>	(Ljava/lang/String;)V
    //   96: astore_2
    //   97: aload_2
    //   98: invokevirtual 86	java/io/File:exists	()Z
    //   101: ifne +8 -> 109
    //   104: aload_2
    //   105: invokevirtual 267	java/io/File:createNewFile	()Z
    //   108: pop
    //   109: new 269	java/io/FileOutputStream
    //   112: dup
    //   113: aload_2
    //   114: invokespecial 272	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   117: astore_3
    //   118: aload_3
    //   119: astore_2
    //   120: aload_1
    //   121: getfield 275	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   124: invokestatic 277	com/tencent/ttpic/baseutils/BitmapUtils:IsSupportImgType	(Ljava/lang/String;)Z
    //   127: ifne +57 -> 184
    //   130: aload_3
    //   131: astore_2
    //   132: aload_1
    //   133: getstatic 283	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   136: putfield 286	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   139: aload_3
    //   140: astore_2
    //   141: aload_1
    //   142: iconst_1
    //   143: putfield 290	android/graphics/BitmapFactory$Options:inPurgeable	Z
    //   146: aload_3
    //   147: astore_2
    //   148: aload_1
    //   149: iconst_1
    //   150: putfield 293	android/graphics/BitmapFactory$Options:inInputShareable	Z
    //   153: aload_3
    //   154: astore_2
    //   155: aload_0
    //   156: aload_1
    //   157: invokestatic 299	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   160: astore_0
    //   161: aload_0
    //   162: ifnull +52 -> 214
    //   165: aload_3
    //   166: astore_2
    //   167: aload_0
    //   168: getstatic 104	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   171: bipush 90
    //   173: aload_3
    //   174: invokevirtual 110	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   177: pop
    //   178: aload_3
    //   179: astore_2
    //   180: aload_0
    //   181: invokevirtual 113	android/graphics/Bitmap:recycle	()V
    //   184: aload_3
    //   185: astore_2
    //   186: aload_3
    //   187: invokevirtual 302	java/io/OutputStream:close	()V
    //   190: aload_3
    //   191: invokevirtual 302	java/io/OutputStream:close	()V
    //   194: ldc 241
    //   196: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   199: aload 4
    //   201: areturn
    //   202: astore_0
    //   203: aload_3
    //   204: astore_2
    //   205: aload_0
    //   206: invokestatic 126	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   209: aconst_null
    //   210: astore_0
    //   211: goto -50 -> 161
    //   214: aload_3
    //   215: invokevirtual 302	java/io/OutputStream:close	()V
    //   218: ldc 241
    //   220: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   223: aconst_null
    //   224: areturn
    //   225: astore_1
    //   226: aconst_null
    //   227: astore_0
    //   228: aload_0
    //   229: astore_2
    //   230: aload_1
    //   231: invokestatic 126	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   234: aload_0
    //   235: ifnull +7 -> 242
    //   238: aload_0
    //   239: invokevirtual 302	java/io/OutputStream:close	()V
    //   242: ldc 241
    //   244: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   247: aconst_null
    //   248: areturn
    //   249: astore_0
    //   250: aconst_null
    //   251: astore_2
    //   252: aload_2
    //   253: ifnull +7 -> 260
    //   256: aload_2
    //   257: invokevirtual 302	java/io/OutputStream:close	()V
    //   260: ldc 241
    //   262: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   265: aload_0
    //   266: athrow
    //   267: astore_0
    //   268: goto -50 -> 218
    //   271: astore_0
    //   272: goto -78 -> 194
    //   275: astore_0
    //   276: goto -34 -> 242
    //   279: astore_1
    //   280: goto -20 -> 260
    //   283: astore_0
    //   284: goto -32 -> 252
    //   287: astore_1
    //   288: aload_3
    //   289: astore_0
    //   290: goto -62 -> 228
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	paramString	String
    //   0	293	1	paramOptions	BitmapFactory.Options
    //   0	293	2	paramFile	File
    //   117	172	3	localFileOutputStream	java.io.FileOutputStream
    //   85	115	4	str	String
    // Exception table:
    //   from	to	target	type
    //   155	161	202	java/lang/OutOfMemoryError
    //   97	109	225	java/lang/Exception
    //   109	118	225	java/lang/Exception
    //   97	109	249	finally
    //   109	118	249	finally
    //   214	218	267	java/io/IOException
    //   190	194	271	java/io/IOException
    //   238	242	275	java/io/IOException
    //   256	260	279	java/io/IOException
    //   120	130	283	finally
    //   132	139	283	finally
    //   141	146	283	finally
    //   148	153	283	finally
    //   155	161	283	finally
    //   167	178	283	finally
    //   180	184	283	finally
    //   186	190	283	finally
    //   205	209	283	finally
    //   230	234	283	finally
    //   120	130	287	java/lang/Exception
    //   132	139	287	java/lang/Exception
    //   141	146	287	java/lang/Exception
    //   148	153	287	java/lang/Exception
    //   155	161	287	java/lang/Exception
    //   167	178	287	java/lang/Exception
    //   180	184	287	java/lang/Exception
    //   186	190	287	java/lang/Exception
    //   205	209	287	java/lang/Exception
  }
  
  public static Bitmap convertToSRGB(Bitmap paramBitmap)
  {
    AppMethodBeat.i(49604);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(49604);
      return null;
    }
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), paramBitmap.getConfig());
      new Canvas(localBitmap).drawBitmap(paramBitmap, 0.0F, 0.0F, new Paint());
      paramBitmap.recycle();
      AppMethodBeat.o(49604);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      LogUtils.e(localOutOfMemoryError);
      AppMethodBeat.o(49604);
    }
    return paramBitmap;
  }
  
  public static Bitmap copy(Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(49603);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    try
    {
      if (isLegal(paramBitmap)) {
        localObject1 = paramBitmap.copy(paramBitmap.getConfig(), paramBoolean);
      }
      AppMethodBeat.o(49603);
      return localObject1;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      for (;;)
      {
        LogUtils.e(TAG, "bitmap copy OOM!");
        localObject1 = localObject2;
      }
    }
  }
  
  public static Bitmap correctImageToFitIn(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49638);
    Bitmap localBitmap = null;
    int i;
    int j;
    if (paramBitmap != null)
    {
      i = paramBitmap.getWidth();
      j = paramBitmap.getHeight();
      if ((i > paramInt1) || (j > paramInt2)) {
        break label57;
      }
      localBitmap = Bitmap.createScaledBitmap(paramBitmap, i, j, true);
    }
    for (;;)
    {
      AppMethodBeat.o(49638);
      return localBitmap;
      label57:
      double d;
      if (paramInt2 * 1.0D / j > paramInt1 * 1.0D / i)
      {
        d = paramInt1 * 1.0D / i;
        localBitmap = Bitmap.createScaledBitmap(paramBitmap, paramInt1, (int)(j * d), true);
      }
      else
      {
        d = paramInt2 * 1.0D / j;
        localBitmap = Bitmap.createScaledBitmap(paramBitmap, (int)(i * d), paramInt2, true);
      }
    }
  }
  
  public static Bitmap createBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Matrix paramMatrix)
  {
    Object localObject2 = null;
    AppMethodBeat.i(49617);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(49617);
      return null;
    }
    Canvas localCanvas = new Canvas();
    if ((paramMatrix == null) || (paramMatrix.isIdentity())) {}
    for (;;)
    {
      try
      {
        localObject1 = Bitmap.createBitmap(paramInt3, paramInt4, paramBitmap.getConfig());
        ((Bitmap)localObject1).setDensity(paramBitmap.getDensity());
        localCanvas.setBitmap((Bitmap)localObject1);
        localCanvas.drawBitmap(paramBitmap, new Rect(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4), new RectF(0.0F, 0.0F, paramInt3, paramInt4), (Paint)localObject2);
        AppMethodBeat.o(49617);
        return localObject1;
      }
      catch (OutOfMemoryError paramBitmap)
      {
        LogUtils.e(paramBitmap);
        AppMethodBeat.o(49617);
        return null;
      }
      catch (NullPointerException paramBitmap)
      {
        LogUtils.e(paramBitmap);
        AppMethodBeat.o(49617);
        return null;
      }
      Object localObject1 = new RectF(0.0F, 0.0F, paramInt3, paramInt4);
      paramMatrix.mapRect((RectF)localObject1);
      try
      {
        Bitmap localBitmap = Bitmap.createBitmap(Math.round(((RectF)localObject1).width()), Math.round(((RectF)localObject1).height()), paramBitmap.getConfig());
        localCanvas.translate(-((RectF)localObject1).left, -((RectF)localObject1).top);
        localCanvas.concat(paramMatrix);
        Paint localPaint = new Paint(2);
        localObject2 = localPaint;
        localObject1 = localBitmap;
        if (!paramMatrix.rectStaysRect())
        {
          localPaint.setAntiAlias(true);
          localObject2 = localPaint;
          localObject1 = localBitmap;
        }
      }
      catch (OutOfMemoryError paramBitmap)
      {
        LogUtils.e(paramBitmap);
        AppMethodBeat.o(49617);
      }
    }
    return null;
  }
  
  public static Bitmap decodeBitmapFromFileExtForShare(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject2 = null;
    AppMethodBeat.i(49641);
    LogUtils.d(TAG, "decodeBitmapFromFileExtForShare(%s, %d, %d, %d)", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(49641);
      return null;
    }
    if (!new File(paramString).exists())
    {
      AppMethodBeat.o(49641);
      return null;
    }
    int k = getDegreeByExif(paramString);
    if (paramInt1 < paramInt2) {}
    for (;;)
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, localOptions);
      if (localOptions.outWidth > localOptions.outHeight) {
        i = localOptions.outWidth;
      }
      for (;;)
      {
        int j;
        if (localOptions.outWidth < localOptions.outHeight)
        {
          j = localOptions.outWidth;
          localOptions.inJustDecodeBounds = false;
          localOptions.inSampleSize = 1;
        }
        try
        {
          Bitmap localBitmap;
          do
          {
            localBitmap = BitmapFactory.decodeFile(paramString, localOptions);
            if ((localBitmap != null) || ((i / localOptions.inSampleSize < paramInt2) && (j / localOptions.inSampleSize < paramInt1))) {
              break;
            }
            localObject2 = localBitmap;
          } while (localOptions.inSampleSize <= paramInt3);
          if ((localBitmap != null) && (k != 0))
          {
            paramString = rotateBitmap(localBitmap, k);
            AppMethodBeat.o(49641);
            return paramString;
            i = localOptions.outHeight;
            continue;
            j = localOptions.outHeight;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            localOptions.inSampleSize *= 2;
            LogUtils.w(TAG, "[decodeBitmapFromFileExtForShare] " + localOutOfMemoryError.getMessage());
            Object localObject1 = localObject2;
            continue;
            paramString = localObject1;
          }
        }
      }
      int i = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = i;
    }
  }
  
  public static Bitmap decodeBitmapFromFileForShare(String paramString, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    int i = 1;
    AppMethodBeat.i(49640);
    LogUtils.d(TAG, "decodeBitmapFromFileForShare(%s, %d, %d, %s)", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramArrayOfInt });
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(49640);
      return null;
    }
    if (!new File(paramString).exists())
    {
      AppMethodBeat.o(49640);
      return null;
    }
    int j = getDegreeByExif(paramString);
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, localOptions);
      BitmapUtils.Size localSize = new BitmapUtils.Size(localOptions.outWidth, localOptions.outHeight);
      LogUtils.v(TAG, "decodeBitmapFromFileForShare(), outer width = " + localOptions.outWidth + ", height = " + localOptions.outHeight);
      if ((paramArrayOfInt != null) && (paramArrayOfInt.length == 2))
      {
        paramArrayOfInt[0] = localOptions.outWidth;
        paramArrayOfInt[1] = localOptions.outHeight;
      }
      boolean bool = shouldResize(localSize, paramInt1, paramInt2);
      paramArrayOfInt = localSize;
      if (bool) {
        paramArrayOfInt = calcNewSize(localSize, paramInt1, paramInt2);
      }
      localOptions.inJustDecodeBounds = false;
      if (bool) {
        i = calculateInSampleSizeNew(localOptions, paramArrayOfInt.width, paramArrayOfInt.height, true);
      }
      LogUtils.v(TAG, "decodeBitmapFromFileForShare(), inSampleSize = ".concat(String.valueOf(i)));
      localOptions.inSampleSize = i;
      paramArrayOfInt = BitmapFactory.decodeFile(paramString, localOptions);
      paramString = paramArrayOfInt;
      if (j != 0) {
        paramString = rotateBitmap(paramArrayOfInt, j);
      }
      if (paramString != null)
      {
        paramString = getFinalBitmap(paramString, paramInt1, paramInt2);
        AppMethodBeat.o(49640);
        return paramString;
      }
      AppMethodBeat.o(49640);
      return null;
    }
    catch (Exception paramString)
    {
      LogUtils.e(paramString);
      AppMethodBeat.o(49640);
      return null;
    }
    catch (OutOfMemoryError paramString)
    {
      LogUtils.e(paramString);
      AppMethodBeat.o(49640);
    }
    return null;
  }
  
  public static Bitmap decodeSampleBitmap(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(49624);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(49624);
      return null;
    }
    if (paramString.startsWith("assets://"))
    {
      paramContext = decodeSampleBitmapFromAssets(paramContext, getRealPath(paramString), paramInt);
      AppMethodBeat.o(49624);
      return paramContext;
    }
    if (bmpIsExists(paramString))
    {
      paramContext = decodeSampledBitmapFromFile(paramString, paramInt);
      AppMethodBeat.o(49624);
      return paramContext;
    }
    AppMethodBeat.o(49624);
    return null;
  }
  
  public static Bitmap decodeSampleBitmap(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49623);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(49623);
      return null;
    }
    if (paramString.startsWith("assets://"))
    {
      paramContext = decodeSampledBitmapFromAssets(paramContext, getRealPath(paramString), paramInt1, paramInt2);
      AppMethodBeat.o(49623);
      return paramContext;
    }
    if (bmpIsExists(paramString))
    {
      paramContext = decodeSampledBitmapFromFile(paramString, paramInt1, paramInt2);
      AppMethodBeat.o(49623);
      return paramContext;
    }
    AppMethodBeat.o(49623);
    return null;
  }
  
  /* Error */
  public static Bitmap decodeSampleBitmapFromAssets(Context paramContext, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: ldc_w 509
    //   8: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_1
    //   12: invokestatic 74	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15: ifeq +11 -> 26
    //   18: ldc_w 509
    //   21: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aconst_null
    //   25: areturn
    //   26: aload_0
    //   27: invokevirtual 515	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   30: astore_0
    //   31: aload_0
    //   32: aload_1
    //   33: invokevirtual 521	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   36: astore 5
    //   38: new 144	android/graphics/BitmapFactory$Options
    //   41: dup
    //   42: invokespecial 433	android/graphics/BitmapFactory$Options:<init>	()V
    //   45: astore_0
    //   46: aload_0
    //   47: iconst_0
    //   48: putfield 436	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   51: aload_0
    //   52: iload_2
    //   53: putfield 439	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   56: aload 5
    //   58: aconst_null
    //   59: aload_0
    //   60: invokestatic 525	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   63: astore_1
    //   64: aload_1
    //   65: astore_0
    //   66: aload 5
    //   68: ifnull +10 -> 78
    //   71: aload 5
    //   73: invokevirtual 528	java/io/InputStream:close	()V
    //   76: aload_1
    //   77: astore_0
    //   78: ldc_w 509
    //   81: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: aload_0
    //   85: areturn
    //   86: astore_0
    //   87: ldc_w 509
    //   90: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: aconst_null
    //   94: areturn
    //   95: astore_0
    //   96: aload 4
    //   98: astore_0
    //   99: aload 5
    //   101: ifnull -23 -> 78
    //   104: aload 5
    //   106: invokevirtual 528	java/io/InputStream:close	()V
    //   109: aload 4
    //   111: astore_0
    //   112: goto -34 -> 78
    //   115: astore_0
    //   116: aload 4
    //   118: astore_0
    //   119: goto -41 -> 78
    //   122: astore_1
    //   123: aload_0
    //   124: aload_0
    //   125: getfield 439	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   128: iconst_1
    //   129: ishl
    //   130: putfield 439	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   133: aload 5
    //   135: invokevirtual 531	java/io/InputStream:reset	()V
    //   138: aload 5
    //   140: aconst_null
    //   141: aload_0
    //   142: invokestatic 525	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   145: astore_1
    //   146: aload_1
    //   147: astore_0
    //   148: aload 5
    //   150: ifnull -72 -> 78
    //   153: aload 5
    //   155: invokevirtual 528	java/io/InputStream:close	()V
    //   158: aload_1
    //   159: astore_0
    //   160: goto -82 -> 78
    //   163: astore_0
    //   164: aload_1
    //   165: astore_0
    //   166: goto -88 -> 78
    //   169: astore_0
    //   170: aload 5
    //   172: ifnull +8 -> 180
    //   175: aload 5
    //   177: invokevirtual 528	java/io/InputStream:close	()V
    //   180: ldc_w 509
    //   183: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   186: aload_0
    //   187: athrow
    //   188: astore_0
    //   189: aload_1
    //   190: astore_0
    //   191: goto -113 -> 78
    //   194: astore_1
    //   195: goto -15 -> 180
    //   198: astore_0
    //   199: aload_3
    //   200: astore_1
    //   201: goto -55 -> 146
    //   204: astore_0
    //   205: aload_3
    //   206: astore_1
    //   207: goto -61 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	210	0	paramContext	Context
    //   0	210	1	paramString	String
    //   0	210	2	paramInt	int
    //   1	205	3	localObject1	Object
    //   3	114	4	localObject2	Object
    //   36	140	5	localInputStream	InputStream
    // Exception table:
    //   from	to	target	type
    //   31	38	86	java/io/IOException
    //   56	64	95	java/lang/Exception
    //   104	109	115	java/io/IOException
    //   56	64	122	java/lang/OutOfMemoryError
    //   153	158	163	java/io/IOException
    //   56	64	169	finally
    //   123	133	169	finally
    //   133	146	169	finally
    //   71	76	188	java/io/IOException
    //   175	180	194	java/io/IOException
    //   133	146	198	java/lang/OutOfMemoryError
    //   133	146	204	java/io/IOException
  }
  
  public static Bitmap decodeSampledBitmapFromAssets(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49631);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(49631);
      return null;
    }
    Object localObject = paramContext.getAssets();
    try
    {
      paramContext = ((AssetManager)localObject).open(paramString);
      paramString = paramContext;
    }
    catch (IOException paramContext)
    {
      try
      {
        for (;;)
        {
          paramString.reset();
          paramContext = BitmapFactory.decodeStream(paramString, null, (BitmapFactory.Options)localObject);
          IOUtils.closeQuietly(paramString);
          AppMethodBeat.o(49631);
          return paramContext;
          paramContext = paramContext;
          try
          {
            paramString = ((AssetManager)localObject).open(paramString.substring(0, paramString.lastIndexOf('.') + 1) + "webp");
          }
          catch (IOException paramContext)
          {
            LogUtils.e(TAG, paramContext);
            AppMethodBeat.o(49631);
            return null;
          }
        }
      }
      catch (IOException paramContext)
      {
        for (;;)
        {
          LogUtils.e(TAG, paramContext);
          paramContext = null;
        }
      }
      catch (OutOfMemoryError paramContext)
      {
        ((BitmapFactory.Options)localObject).inSampleSize <<= 1;
      }
    }
    localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeStream(paramString, null, (BitmapFactory.Options)localObject);
    ((BitmapFactory.Options)localObject).inSampleSize = calculateInSampleSizeNew((BitmapFactory.Options)localObject, paramInt1, paramInt2, true);
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    try
    {
      paramString.reset();
      paramContext = BitmapFactory.decodeStream(paramString, null, (BitmapFactory.Options)localObject);
    }
    catch (OutOfMemoryError paramContext)
    {
      LogUtils.e(TAG, paramContext);
      paramContext = null;
    }
    catch (IOException paramContext)
    {
      label202:
      break label202;
    }
  }
  
  public static Bitmap decodeSampledBitmapFromDescriptor(FileDescriptor paramFileDescriptor, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    localObject = null;
    AppMethodBeat.i(49630);
    localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFileDescriptor(paramFileDescriptor, null, localOptions);
    localOptions.inSampleSize = calculateInSampleSizeNew(localOptions, paramInt1, paramInt2, true);
    localOptions.inJustDecodeBounds = false;
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeFileDescriptor(paramFileDescriptor, null, localOptions);
      paramFileDescriptor = localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        localOptions.inSampleSize <<= 1;
        try
        {
          paramFileDescriptor = BitmapFactory.decodeFileDescriptor(paramFileDescriptor, null, localOptions);
        }
        catch (OutOfMemoryError paramFileDescriptor)
        {
          LogUtils.e(localOutOfMemoryError);
          paramFileDescriptor = localObject;
        }
      }
    }
    catch (Exception paramFileDescriptor)
    {
      for (;;)
      {
        paramFileDescriptor = localObject;
      }
    }
    AppMethodBeat.o(49630);
    return paramFileDescriptor;
  }
  
  public static Bitmap decodeSampledBitmapFromFile(String paramString, int paramInt)
  {
    AppMethodBeat.i(49626);
    localOptions = new BitmapFactory.Options();
    localOptions.inSampleSize = paramInt;
    localOptions.inJustDecodeBounds = false;
    localObject = null;
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeFile(paramString, localOptions);
      paramString = localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        localOptions.inSampleSize <<= 1;
        try
        {
          paramString = BitmapFactory.decodeFile(paramString, localOptions);
        }
        catch (OutOfMemoryError paramString)
        {
          paramString = localObject;
        }
      }
    }
    AppMethodBeat.o(49626);
    return paramString;
  }
  
  public static Bitmap decodeSampledBitmapFromFile(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49625);
    localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    localOptions.inSampleSize = calculateInSampleSizeNew(localOptions, paramInt1, paramInt2, true);
    localOptions.inJustDecodeBounds = false;
    ApiHelper.hasHoneycomb();
    localObject = null;
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeFile(paramString, localOptions);
      paramString = localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        localOptions.inSampleSize <<= 1;
        try
        {
          paramString = BitmapFactory.decodeFile(paramString, localOptions);
        }
        catch (OutOfMemoryError paramString)
        {
          LogUtils.e(paramString);
          paramString = localObject;
        }
      }
    }
    AppMethodBeat.o(49625);
    return paramString;
  }
  
  public static Bitmap decodeSampledBitmapFromFileCheckExif(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49627);
    localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    localOptions.inSampleSize = calculateInSampleSizeNew(localOptions, paramInt1, paramInt2, true);
    localOptions.inJustDecodeBounds = false;
    paramInt1 = getDegreeByExif(paramString) % 360;
    localObject = null;
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeFile(paramString, localOptions);
      localObject = localBitmap;
      if (paramInt1 != 0)
      {
        localObject = localBitmap;
        localBitmap = rotateBitmap(localBitmap, paramInt1);
        localObject = localBitmap;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        localOptions.inSampleSize <<= 1;
        try
        {
          paramString = BitmapFactory.decodeFile(paramString, localOptions);
          localObject = paramString;
          if (paramInt1 != 0)
          {
            localObject = paramString;
            paramString = rotateBitmap(paramString, paramInt1);
            localObject = paramString;
          }
        }
        catch (OutOfMemoryError paramString)
        {
          LogUtils.e(paramString);
        }
      }
    }
    AppMethodBeat.o(49627);
    return localObject;
  }
  
  public static Bitmap decodeSampledBitmapFromResource(Resources paramResources, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(49629);
    localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeResource(paramResources, paramInt1, localOptions);
    localOptions.inSampleSize = calculateInSampleSizeNew(localOptions, paramInt2, paramInt3, true);
    localOptions.inJustDecodeBounds = false;
    localObject = null;
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeResource(paramResources, paramInt1, localOptions);
      paramResources = localBitmap;
    }
    catch (Exception paramResources)
    {
      for (;;)
      {
        LogUtils.e(paramResources);
        paramResources = localObject;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        LogUtils.e(localOutOfMemoryError);
        try
        {
          localOptions.inSampleSize *= 2;
          paramResources = BitmapFactory.decodeResource(paramResources, paramInt1, localOptions);
        }
        catch (OutOfMemoryError paramResources)
        {
          paramResources = localObject;
        }
      }
    }
    AppMethodBeat.o(49629);
    return paramResources;
  }
  
  public static Bitmap decodeSampledBitmapFromUri(Uri paramUri, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49633);
    if (paramUri != null) {}
    for (;;)
    {
      try
      {
        String str = paramUri.getScheme();
        if ((str != null) && (str.toLowerCase().startsWith("file")))
        {
          paramUri = Uri.decode(paramUri.toString()).substring(7);
          LogUtils.v(TAG, "decodeSampledBitmapFromUri(), file = ".concat(String.valueOf(paramUri)));
          paramUri = decodeSampledBitmapFromFileCheckExif(paramUri, paramInt1, paramInt2);
          if (paramUri == null) {}
        }
      }
      catch (Exception localException1)
      {
        paramUri = null;
        LogUtils.e(localException1);
        IOUtils.closeQuietly(null);
        IOUtils.closeQuietly(null);
        continue;
      }
      finally
      {
        IOUtils.closeQuietly(null);
        IOUtils.closeQuietly(null);
        AppMethodBeat.o(49633);
      }
      try
      {
        LogUtils.v(TAG, "decodeSampledBitmapFromUri(), width = " + paramUri.getWidth() + ", height = " + paramUri.getHeight());
        IOUtils.closeQuietly(null);
        IOUtils.closeQuietly(null);
        AppMethodBeat.o(49633);
        return paramUri;
      }
      catch (Exception localException2)
      {
        continue;
        paramUri = null;
      }
      if (paramUri != null)
      {
        paramUri = Uri.decode(paramUri.toString());
        LogUtils.v(TAG, "decodeSampledBitmapFromUri() in else , file = ".concat(String.valueOf(paramUri)));
        paramUri = decodeSampledBitmapFromFileCheckExif(paramUri, paramInt1, paramInt2);
      }
      else
      {
        continue;
        Object localObject = null;
      }
    }
  }
  
  public static void drawRepeatBitmap(Bitmap paramBitmap, Rect paramRect1, Rect paramRect2, Canvas paramCanvas, float paramFloat, Paint paramPaint)
  {
    AppMethodBeat.i(49649);
    int k = paramRect2.top;
    int m = paramRect2.bottom;
    int n = paramRect2.left;
    int i1 = paramRect2.right;
    int i2 = (int)(paramRect2.width() / paramFloat / paramRect1.width() + 1.0F);
    int i3 = (int)(paramRect2.height() / paramFloat / paramRect1.height() + 1.0F);
    paramCanvas.save();
    paramCanvas.clipRect(paramRect2);
    int i = 0;
    while (i < i3)
    {
      int j = 0;
      while (j < i2)
      {
        paramRect2.set((int)(n + paramRect1.width() * j * paramFloat), (int)(k + paramRect1.height() * i * paramFloat), (int)(n + paramRect1.width() * j * paramFloat + paramRect1.width() * paramFloat), (int)(k + paramRect1.height() * i * paramFloat + paramRect1.height() * paramFloat));
        paramCanvas.drawBitmap(paramBitmap, paramRect1, paramRect2, paramPaint);
        j += 1;
      }
      i += 1;
    }
    paramCanvas.restore();
    paramRect2.set(n, k, i1, m);
    AppMethodBeat.o(49649);
  }
  
  public static void fixBgRepeatY(View paramView)
  {
    AppMethodBeat.i(49606);
    paramView = paramView.getBackground();
    if ((paramView != null) && ((paramView instanceof BitmapDrawable)))
    {
      paramView = (BitmapDrawable)paramView;
      paramView.mutate();
      paramView.setTileModeY(Shader.TileMode.REPEAT);
    }
    AppMethodBeat.o(49606);
  }
  
  public static Bitmap flipBitmap(Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(49621);
    Object localObject = paramBitmap;
    if (paramBitmap != null)
    {
      localObject = new Matrix();
      if (!paramBoolean) {
        break label70;
      }
      ((Matrix)localObject).setScale(1.0F, -1.0F);
    }
    for (;;)
    {
      try
      {
        Bitmap localBitmap2 = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
        localObject = paramBitmap;
        if (paramBitmap != localBitmap2)
        {
          paramBitmap.recycle();
          localObject = localBitmap2;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        label70:
        LogUtils.e(TAG, "OutOfMemoryError. ".concat(String.valueOf(localOutOfMemoryError)));
        Bitmap localBitmap1 = paramBitmap;
        continue;
      }
      AppMethodBeat.o(49621);
      return localObject;
      ((Matrix)localObject).setScale(-1.0F, 1.0F);
    }
  }
  
  /* Error */
  public static String getBase64FromBitmap(Bitmap paramBitmap, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 674
    //   3: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnonnull +22 -> 29
    //   10: getstatic 45	com/tencent/ttpic/baseutils/BitmapUtils:TAG	Ljava/lang/String;
    //   13: ldc_w 676
    //   16: invokestatic 193	com/tencent/ttpic/baseutils/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: ldc_w 674
    //   22: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: ldc_w 678
    //   28: areturn
    //   29: new 97	java/io/ByteArrayOutputStream
    //   32: dup
    //   33: invokespecial 98	java/io/ByteArrayOutputStream:<init>	()V
    //   36: astore_2
    //   37: aload_0
    //   38: getstatic 104	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   41: bipush 100
    //   43: aload_2
    //   44: invokevirtual 110	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   47: pop
    //   48: aload_2
    //   49: invokevirtual 117	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   52: iload_1
    //   53: invokestatic 684	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   56: astore_0
    //   57: aload_2
    //   58: invokevirtual 120	java/io/ByteArrayOutputStream:close	()V
    //   61: ldc_w 674
    //   64: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: aload_0
    //   68: areturn
    //   69: astore_2
    //   70: aload_2
    //   71: invokestatic 126	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   74: goto -13 -> 61
    //   77: astore_0
    //   78: aconst_null
    //   79: astore_2
    //   80: aload_2
    //   81: ifnull +7 -> 88
    //   84: aload_2
    //   85: invokevirtual 120	java/io/ByteArrayOutputStream:close	()V
    //   88: ldc_w 674
    //   91: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: ldc_w 678
    //   97: areturn
    //   98: astore_0
    //   99: aload_0
    //   100: invokestatic 126	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   103: goto -15 -> 88
    //   106: astore_0
    //   107: aconst_null
    //   108: astore_2
    //   109: aload_2
    //   110: ifnull +7 -> 117
    //   113: aload_2
    //   114: invokevirtual 120	java/io/ByteArrayOutputStream:close	()V
    //   117: ldc_w 674
    //   120: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   123: ldc_w 678
    //   126: areturn
    //   127: astore_0
    //   128: aload_0
    //   129: invokestatic 126	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   132: goto -15 -> 117
    //   135: astore_0
    //   136: goto -27 -> 109
    //   139: astore_0
    //   140: goto -60 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	paramBitmap	Bitmap
    //   0	143	1	paramInt	int
    //   36	22	2	localByteArrayOutputStream	ByteArrayOutputStream
    //   69	2	2	localIOException	IOException
    //   79	35	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   57	61	69	java/io/IOException
    //   29	37	77	java/lang/Exception
    //   84	88	98	java/io/IOException
    //   29	37	106	finally
    //   113	117	127	java/io/IOException
    //   37	57	135	finally
    //   37	57	139	java/lang/Exception
  }
  
  public static Bitmap getBitmapFromURL(String paramString)
  {
    AppMethodBeat.i(49634);
    try
    {
      paramString = (HttpURLConnection)new URL(paramString).openConnection();
      paramString.setDoInput(true);
      paramString.connect();
      paramString = BitmapFactory.decodeStream(paramString.getInputStream());
      AppMethodBeat.o(49634);
      return paramString;
    }
    catch (IOException paramString)
    {
      AppMethodBeat.o(49634);
    }
    return null;
  }
  
  public static BitmapFactory.Options getBitmapOptionsFromAssets(Context paramContext, String paramString)
  {
    AppMethodBeat.i(49615);
    AssetManager localAssetManager = paramContext.getAssets();
    try
    {
      paramContext = localAssetManager.open(paramString);
      paramString = new BitmapFactory.Options();
      paramString.inJustDecodeBounds = true;
      BitmapFactory.decodeStream(paramContext, null, paramString);
      try
      {
        paramContext.reset();
        if (paramContext != null) {
          IOUtils.closeQuietly(paramContext);
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          LogUtils.e(TAG, localIOException);
          if (paramContext != null) {
            IOUtils.closeQuietly(paramContext);
          }
        }
      }
      finally
      {
        if (paramContext == null) {
          break label142;
        }
        IOUtils.closeQuietly(paramContext);
        AppMethodBeat.o(49615);
      }
      AppMethodBeat.o(49615);
      return paramString;
    }
    catch (IOException paramContext)
    {
      try
      {
        paramContext = localAssetManager.open(paramString.substring(0, paramString.lastIndexOf('.') + 1) + "webp");
      }
      catch (IOException paramContext)
      {
        LogUtils.e(TAG, paramContext);
        AppMethodBeat.o(49615);
        return null;
      }
    }
  }
  
  public static BitmapFactory.Options getBitmapOptionsFromFile(String paramString)
  {
    AppMethodBeat.i(49613);
    if (paramString == null)
    {
      AppMethodBeat.o(49613);
      return null;
    }
    if (!new File(paramString).exists())
    {
      AppMethodBeat.o(49613);
      return null;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    AppMethodBeat.o(49613);
    return localOptions;
  }
  
  public static BitmapFactory.Options getBitmapOptionsFromResource(Resources paramResources, int paramInt)
  {
    AppMethodBeat.i(49614);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeResource(paramResources, paramInt, localOptions);
    AppMethodBeat.o(49614);
    return localOptions;
  }
  
  public static BitmapFactory.Options getBitmapOptionsFromUri(Context paramContext, Uri paramUri)
  {
    AppMethodBeat.i(49616);
    if (paramUri != null) {}
    for (paramContext = paramUri.getScheme();; paramContext = null)
    {
      if ((paramContext != null) && (paramContext.toLowerCase().startsWith("file")))
      {
        paramContext = Uri.decode(paramUri.toString()).substring(7);
        LogUtils.v(TAG, "[getBitmapOptionsFromUri] file = ".concat(String.valueOf(paramContext)));
        paramContext = getBitmapOptionsFromFile(paramContext);
        AppMethodBeat.o(49616);
        return paramContext;
      }
      if (paramUri == null)
      {
        AppMethodBeat.o(49616);
        return null;
      }
      paramContext = Uri.decode(paramUri.toString());
      LogUtils.v(TAG, "[getBitmapOptionsFromUri] in else , file = ".concat(String.valueOf(paramContext)));
      paramContext = getBitmapOptionsFromFile(paramContext);
      AppMethodBeat.o(49616);
      return paramContext;
    }
  }
  
  public static Point getBitmapSize(Context paramContext, String paramString)
  {
    AppMethodBeat.i(49609);
    if (paramString.startsWith("assets://"))
    {
      paramContext = getBitmapSizeFromAssets(paramContext, getRealPath(paramString));
      AppMethodBeat.o(49609);
      return paramContext;
    }
    paramContext = getBitmapSizeFromFile(paramString);
    AppMethodBeat.o(49609);
    return paramContext;
  }
  
  /* Error */
  private static Point getBitmapSizeFromAssets(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc_w 738
    //   5: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 740	android/graphics/Point
    //   11: dup
    //   12: iconst_0
    //   13: iconst_0
    //   14: invokespecial 741	android/graphics/Point:<init>	(II)V
    //   17: astore_3
    //   18: aload_1
    //   19: invokestatic 74	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   22: ifeq +11 -> 33
    //   25: ldc_w 738
    //   28: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aload_3
    //   32: areturn
    //   33: aload_0
    //   34: invokevirtual 515	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   37: astore_0
    //   38: aload_0
    //   39: aload_1
    //   40: invokevirtual 521	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   43: astore_0
    //   44: new 144	android/graphics/BitmapFactory$Options
    //   47: dup
    //   48: invokespecial 433	android/graphics/BitmapFactory$Options:<init>	()V
    //   51: astore_1
    //   52: aload_1
    //   53: iconst_1
    //   54: putfield 436	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   57: aload_0
    //   58: aconst_null
    //   59: aload_1
    //   60: invokestatic 525	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   63: pop
    //   64: new 740	android/graphics/Point
    //   67: dup
    //   68: aload_1
    //   69: getfield 150	android/graphics/BitmapFactory$Options:outWidth	I
    //   72: aload_1
    //   73: getfield 147	android/graphics/BitmapFactory$Options:outHeight	I
    //   76: invokespecial 741	android/graphics/Point:<init>	(II)V
    //   79: astore_1
    //   80: aload_0
    //   81: ifnull +7 -> 88
    //   84: aload_0
    //   85: invokevirtual 528	java/io/InputStream:close	()V
    //   88: ldc_w 738
    //   91: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: aload_1
    //   95: areturn
    //   96: astore_0
    //   97: aload_2
    //   98: astore_0
    //   99: aload_0
    //   100: ifnull +7 -> 107
    //   103: aload_0
    //   104: invokevirtual 528	java/io/InputStream:close	()V
    //   107: ldc_w 738
    //   110: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: aload_3
    //   114: areturn
    //   115: astore_1
    //   116: aconst_null
    //   117: astore_0
    //   118: aload_0
    //   119: ifnull +7 -> 126
    //   122: aload_0
    //   123: invokevirtual 528	java/io/InputStream:close	()V
    //   126: ldc_w 738
    //   129: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   132: aload_1
    //   133: athrow
    //   134: astore_0
    //   135: goto -47 -> 88
    //   138: astore_0
    //   139: goto -32 -> 107
    //   142: astore_0
    //   143: goto -17 -> 126
    //   146: astore_1
    //   147: goto -29 -> 118
    //   150: astore_1
    //   151: goto -52 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	paramContext	Context
    //   0	154	1	paramString	String
    //   1	97	2	localObject	Object
    //   17	97	3	localPoint	Point
    // Exception table:
    //   from	to	target	type
    //   38	44	96	java/io/IOException
    //   38	44	115	finally
    //   84	88	134	java/io/IOException
    //   103	107	138	java/io/IOException
    //   122	126	142	java/io/IOException
    //   44	80	146	finally
    //   44	80	150	java/io/IOException
  }
  
  private static Point getBitmapSizeFromFile(String paramString)
  {
    AppMethodBeat.i(49610);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    paramString = new Point(localOptions.outWidth, localOptions.outHeight);
    AppMethodBeat.o(49610);
    return paramString;
  }
  
  @SuppressLint({"NewApi"})
  public static int getBitmapSizeInBytes(Bitmap paramBitmap)
  {
    AppMethodBeat.i(49608);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(49608);
      return 0;
    }
    if (Build.VERSION.SDK_INT > 19) {
      try
      {
        i = paramBitmap.getAllocationByteCount();
        AppMethodBeat.o(49608);
        return i;
      }
      catch (NullPointerException localNullPointerException) {}
    }
    if (Build.VERSION.SDK_INT >= 12)
    {
      i = paramBitmap.getByteCount();
      AppMethodBeat.o(49608);
      return i;
    }
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getRowBytes();
    AppMethodBeat.o(49608);
    return i * j;
  }
  
  public static int getDegreeByExif(String paramString)
  {
    AppMethodBeat.i(49628);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(49628);
      return 0;
    }
    try
    {
      int i = getDegreeByOrientation(new ExifInterface(paramString).getAttributeInt("Orientation", 0));
      AppMethodBeat.o(49628);
      return i;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(49628);
    }
    return 0;
  }
  
  public static int getDegreeByOrientation(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 7: 
    default: 
      return 0;
    case 6: 
      return 90;
    case 3: 
      return 180;
    }
    return 270;
  }
  
  private static Bitmap getFinalBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49648);
    int i = Math.max(paramBitmap.getWidth(), paramBitmap.getHeight());
    int j = Math.min(paramBitmap.getWidth(), paramBitmap.getHeight());
    if ((i > paramInt2) || (j > paramInt1))
    {
      float f = Math.min(paramInt2 / i, paramInt1 / j);
      Matrix localMatrix = new Matrix();
      localMatrix.setScale(f, f);
      Bitmap localBitmap = Bitmap.createBitmap((int)(paramBitmap.getWidth() * f), (int)(f * paramBitmap.getHeight()), Bitmap.Config.ARGB_8888);
      Paint localPaint = new Paint();
      localPaint.setAntiAlias(true);
      localPaint.setDither(true);
      localPaint.setFilterBitmap(true);
      new Canvas(localBitmap).drawBitmap(paramBitmap, localMatrix, localPaint);
      recycle(paramBitmap);
      AppMethodBeat.o(49648);
      return localBitmap;
    }
    AppMethodBeat.o(49648);
    return paramBitmap;
  }
  
  public static int[] getImageSize(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49612);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    paramInt2 = calculateInSampleSize(localOptions, paramInt1, paramInt2, true);
    paramInt1 = 1;
    while (Math.pow(2.0D, paramInt1) < paramInt2) {
      paramInt1 += 1;
    }
    paramInt2 = (int)Math.pow(2.0D, paramInt1 - 1);
    paramInt1 = localOptions.outWidth / paramInt2;
    paramInt2 = localOptions.outHeight / paramInt2;
    int i = getDegreeByExif(paramString);
    if ((i == 90) || (i == 270)) {}
    for (;;)
    {
      AppMethodBeat.o(49612);
      return new int[] { paramInt2, paramInt1 };
      i = paramInt2;
      paramInt2 = paramInt1;
      paramInt1 = i;
    }
  }
  
  private static BitmapUtils.Size getNewSize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(49647);
    float f = Math.min(paramInt3 / paramInt1, paramInt4 / paramInt2);
    if (f < 1.0D)
    {
      localSize = new BitmapUtils.Size((int)(paramInt1 * f), (int)(f * paramInt2));
      AppMethodBeat.o(49647);
      return localSize;
    }
    BitmapUtils.Size localSize = new BitmapUtils.Size(paramInt1, paramInt2);
    AppMethodBeat.o(49647);
    return localSize;
  }
  
  public static String getRealPath(String paramString)
  {
    AppMethodBeat.i(49599);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("assets://")))
    {
      paramString = paramString.substring(9);
      AppMethodBeat.o(49599);
      return paramString;
    }
    AppMethodBeat.o(49599);
    return paramString;
  }
  
  private static BitmapFactory.Options getScaledOpt(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49644);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inSampleSize = calculateInSampleSizeNew(paramOptions, paramInt1, paramInt2, false);
    localOptions.inJustDecodeBounds = false;
    AppMethodBeat.o(49644);
    return localOptions;
  }
  
  public static boolean isLegal(Bitmap paramBitmap)
  {
    AppMethodBeat.i(49601);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(49601);
      return true;
    }
    AppMethodBeat.o(49601);
    return false;
  }
  
  private static boolean isPowerOf2(int paramInt)
  {
    return (paramInt - 1 & paramInt) == 0;
  }
  
  public static boolean recycle(Bitmap paramBitmap)
  {
    AppMethodBeat.i(49602);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      paramBitmap.recycle();
      AppMethodBeat.o(49602);
      return true;
    }
    AppMethodBeat.o(49602);
    return false;
  }
  
  public static Bitmap rotateBitmap(Bitmap paramBitmap, int paramInt)
  {
    AppMethodBeat.i(49620);
    Object localObject = paramBitmap;
    if (paramBitmap != null)
    {
      localObject = new Matrix();
      ((Matrix)localObject).setRotate(paramInt, paramBitmap.getWidth() / 2.0F, paramBitmap.getHeight() / 2.0F);
    }
    try
    {
      Bitmap localBitmap2 = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
      localObject = paramBitmap;
      if (paramBitmap != localBitmap2)
      {
        paramBitmap.recycle();
        localObject = localBitmap2;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        Bitmap localBitmap1 = paramBitmap;
      }
    }
    AppMethodBeat.o(49620);
    return localObject;
  }
  
  public static Bitmap roundRectBitmap(Bitmap paramBitmap, int paramInt)
  {
    AppMethodBeat.i(49622);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setFilterBitmap(true);
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    RectF localRectF = new RectF(0.0F, 0.0F, i, j);
    Rect localRect = new Rect(0, 0, i, j);
    Canvas localCanvas = new Canvas(paramBitmap);
    localPaint.setXfermode(null);
    localCanvas.drawRoundRect(localRectF, paramInt, paramInt, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(paramBitmap, localRect, localRectF, localPaint);
    AppMethodBeat.o(49622);
    return paramBitmap;
  }
  
  /* Error */
  public static BitmapUtils.SAVE_STATUS saveBitmap(Bitmap paramBitmap, String paramString)
  {
    // Byte code:
    //   0: ldc_w 836
    //   3: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore 4
    //   9: aconst_null
    //   10: astore 5
    //   12: aconst_null
    //   13: astore_3
    //   14: aload 5
    //   16: astore_2
    //   17: new 79	java/io/File
    //   20: dup
    //   21: aload_1
    //   22: invokespecial 82	java/io/File:<init>	(Ljava/lang/String;)V
    //   25: astore 6
    //   27: aload 5
    //   29: astore_2
    //   30: aload 6
    //   32: invokevirtual 839	java/io/File:getParentFile	()Ljava/io/File;
    //   35: astore 7
    //   37: aload 5
    //   39: astore_2
    //   40: aload 7
    //   42: invokevirtual 86	java/io/File:exists	()Z
    //   45: ifne +12 -> 57
    //   48: aload 5
    //   50: astore_2
    //   51: aload 7
    //   53: invokevirtual 249	java/io/File:mkdirs	()Z
    //   56: pop
    //   57: aload 5
    //   59: astore_2
    //   60: aload 6
    //   62: invokevirtual 86	java/io/File:exists	()Z
    //   65: ifne +12 -> 77
    //   68: aload 5
    //   70: astore_2
    //   71: aload 6
    //   73: invokevirtual 267	java/io/File:createNewFile	()Z
    //   76: pop
    //   77: aload 5
    //   79: astore_2
    //   80: new 269	java/io/FileOutputStream
    //   83: dup
    //   84: aload_1
    //   85: invokespecial 840	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   88: astore_1
    //   89: aload_0
    //   90: ifnull +18 -> 108
    //   93: aload_0
    //   94: getstatic 104	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   97: bipush 99
    //   99: aload_1
    //   100: invokevirtual 110	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   103: pop
    //   104: aload_1
    //   105: invokevirtual 843	java/io/FileOutputStream:flush	()V
    //   108: aload_1
    //   109: invokestatic 846	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   112: getstatic 850	com/tencent/ttpic/baseutils/BitmapUtils$SAVE_STATUS:SAVE_SUCCESS	Lcom/tencent/ttpic/baseutils/BitmapUtils$SAVE_STATUS;
    //   115: astore_0
    //   116: ldc_w 836
    //   119: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: aload_0
    //   123: areturn
    //   124: astore_1
    //   125: aload_3
    //   126: astore_0
    //   127: aload_0
    //   128: astore_2
    //   129: aload_1
    //   130: invokestatic 126	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   133: aload_0
    //   134: astore_2
    //   135: getstatic 853	com/tencent/ttpic/baseutils/BitmapUtils$SAVE_STATUS:SAVE_FAILED	Lcom/tencent/ttpic/baseutils/BitmapUtils$SAVE_STATUS;
    //   138: astore_1
    //   139: aload_0
    //   140: invokestatic 846	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   143: ldc_w 836
    //   146: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: aload_1
    //   150: areturn
    //   151: astore_1
    //   152: aload 4
    //   154: astore_0
    //   155: aload_0
    //   156: astore_2
    //   157: aload_1
    //   158: invokestatic 126	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   161: aload_0
    //   162: astore_2
    //   163: getstatic 856	com/tencent/ttpic/baseutils/BitmapUtils$SAVE_STATUS:SAVE_OOM	Lcom/tencent/ttpic/baseutils/BitmapUtils$SAVE_STATUS;
    //   166: astore_1
    //   167: aload_0
    //   168: invokestatic 846	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   171: ldc_w 836
    //   174: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   177: aload_1
    //   178: areturn
    //   179: astore_0
    //   180: aload_2
    //   181: invokestatic 846	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   184: ldc_w 836
    //   187: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   190: aload_0
    //   191: athrow
    //   192: astore_0
    //   193: aload_1
    //   194: astore_2
    //   195: goto -15 -> 180
    //   198: astore_2
    //   199: aload_1
    //   200: astore_0
    //   201: aload_2
    //   202: astore_1
    //   203: goto -48 -> 155
    //   206: astore_2
    //   207: aload_1
    //   208: astore_0
    //   209: aload_2
    //   210: astore_1
    //   211: goto -84 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	paramBitmap	Bitmap
    //   0	214	1	paramString	String
    //   16	179	2	localObject1	Object
    //   198	4	2	localOutOfMemoryError	OutOfMemoryError
    //   206	4	2	localException	Exception
    //   13	113	3	localObject2	Object
    //   7	146	4	localObject3	Object
    //   10	68	5	localObject4	Object
    //   25	47	6	localFile1	File
    //   35	17	7	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   17	27	124	java/lang/Exception
    //   30	37	124	java/lang/Exception
    //   40	48	124	java/lang/Exception
    //   51	57	124	java/lang/Exception
    //   60	68	124	java/lang/Exception
    //   71	77	124	java/lang/Exception
    //   80	89	124	java/lang/Exception
    //   17	27	151	java/lang/OutOfMemoryError
    //   30	37	151	java/lang/OutOfMemoryError
    //   40	48	151	java/lang/OutOfMemoryError
    //   51	57	151	java/lang/OutOfMemoryError
    //   60	68	151	java/lang/OutOfMemoryError
    //   71	77	151	java/lang/OutOfMemoryError
    //   80	89	151	java/lang/OutOfMemoryError
    //   17	27	179	finally
    //   30	37	179	finally
    //   40	48	179	finally
    //   51	57	179	finally
    //   60	68	179	finally
    //   71	77	179	finally
    //   80	89	179	finally
    //   129	133	179	finally
    //   135	139	179	finally
    //   157	161	179	finally
    //   163	167	179	finally
    //   93	108	192	finally
    //   93	108	198	java/lang/OutOfMemoryError
    //   93	108	206	java/lang/Exception
  }
  
  /* Error */
  public static File saveBitmap(Context paramContext, Bitmap paramBitmap, String paramString1, String paramString2, Bitmap.CompressFormat paramCompressFormat, String paramString3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: ldc_w 858
    //   6: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_2
    //   10: ifnonnull +138 -> 148
    //   13: aload_2
    //   14: astore 8
    //   16: aload_0
    //   17: ifnull +21 -> 38
    //   20: aload_0
    //   21: invokevirtual 861	android/content/Context:getCacheDir	()Ljava/io/File;
    //   24: astore_0
    //   25: aload_2
    //   26: astore 8
    //   28: aload_0
    //   29: ifnull +9 -> 38
    //   32: aload_0
    //   33: invokevirtual 223	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   36: astore 8
    //   38: iconst_0
    //   39: istore 7
    //   41: iconst_0
    //   42: istore 6
    //   44: aload 4
    //   46: getstatic 864	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   49: if_acmpne +136 -> 185
    //   52: new 165	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   59: aload_3
    //   60: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: ldc_w 866
    //   66: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: astore_0
    //   73: new 79	java/io/File
    //   76: dup
    //   77: aload 8
    //   79: aload_0
    //   80: invokespecial 868	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: astore_3
    //   84: new 269	java/io/FileOutputStream
    //   87: dup
    //   88: aload_3
    //   89: invokespecial 272	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   92: astore_0
    //   93: aload_0
    //   94: astore_2
    //   95: aload 4
    //   97: getstatic 104	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   100: if_acmpne +18 -> 118
    //   103: aload 5
    //   105: ifnull +13 -> 118
    //   108: aload_0
    //   109: astore_2
    //   110: aload 5
    //   112: invokevirtual 871	java/lang/String:length	()I
    //   115: ifgt +16 -> 131
    //   118: aload_0
    //   119: astore_2
    //   120: aload_1
    //   121: aload 4
    //   123: bipush 99
    //   125: aload_0
    //   126: invokevirtual 110	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   129: istore 6
    //   131: aload_0
    //   132: invokestatic 846	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   135: iload 6
    //   137: ifeq +110 -> 247
    //   140: ldc_w 858
    //   143: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: aload_3
    //   147: areturn
    //   148: new 79	java/io/File
    //   151: dup
    //   152: aload_2
    //   153: invokespecial 82	java/io/File:<init>	(Ljava/lang/String;)V
    //   156: astore_0
    //   157: aload_2
    //   158: astore 8
    //   160: aload_0
    //   161: invokevirtual 874	java/io/File:isDirectory	()Z
    //   164: ifne -126 -> 38
    //   167: aload_2
    //   168: astore 8
    //   170: aload_0
    //   171: invokevirtual 249	java/io/File:mkdirs	()Z
    //   174: ifne -136 -> 38
    //   177: ldc_w 858
    //   180: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   183: aconst_null
    //   184: areturn
    //   185: new 165	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   192: aload_3
    //   193: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: ldc_w 876
    //   199: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: astore_0
    //   206: goto -133 -> 73
    //   209: astore_1
    //   210: aconst_null
    //   211: astore_0
    //   212: aconst_null
    //   213: astore_3
    //   214: aload_0
    //   215: astore_2
    //   216: aload_1
    //   217: invokestatic 126	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   220: aload_0
    //   221: invokestatic 846	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   224: iload 7
    //   226: istore 6
    //   228: goto -93 -> 135
    //   231: astore_0
    //   232: aload 9
    //   234: astore_1
    //   235: aload_1
    //   236: invokestatic 846	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   239: ldc_w 858
    //   242: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   245: aload_0
    //   246: athrow
    //   247: ldc_w 858
    //   250: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   253: aconst_null
    //   254: areturn
    //   255: astore_0
    //   256: aload_2
    //   257: astore_1
    //   258: goto -23 -> 235
    //   261: astore_1
    //   262: aconst_null
    //   263: astore_0
    //   264: goto -50 -> 214
    //   267: astore_1
    //   268: goto -54 -> 214
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	271	0	paramContext	Context
    //   0	271	1	paramBitmap	Bitmap
    //   0	271	2	paramString1	String
    //   0	271	3	paramString2	String
    //   0	271	4	paramCompressFormat	Bitmap.CompressFormat
    //   0	271	5	paramString3	String
    //   42	185	6	bool1	boolean
    //   39	186	7	bool2	boolean
    //   14	155	8	str	String
    //   1	232	9	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   44	73	209	java/lang/Exception
    //   73	84	209	java/lang/Exception
    //   185	206	209	java/lang/Exception
    //   44	73	231	finally
    //   73	84	231	finally
    //   84	93	231	finally
    //   185	206	231	finally
    //   95	103	255	finally
    //   110	118	255	finally
    //   120	131	255	finally
    //   216	220	255	finally
    //   84	93	261	java/lang/Exception
    //   95	103	267	java/lang/Exception
    //   110	118	267	java/lang/Exception
    //   120	131	267	java/lang/Exception
  }
  
  /* Error */
  public static BitmapUtils.SAVE_STATUS saveBitmap2PNG(Bitmap paramBitmap, String paramString)
  {
    // Byte code:
    //   0: ldc_w 878
    //   3: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore 4
    //   9: aconst_null
    //   10: astore 5
    //   12: aconst_null
    //   13: astore_3
    //   14: aload 5
    //   16: astore_2
    //   17: new 79	java/io/File
    //   20: dup
    //   21: aload_1
    //   22: invokespecial 82	java/io/File:<init>	(Ljava/lang/String;)V
    //   25: astore 6
    //   27: aload 5
    //   29: astore_2
    //   30: aload 6
    //   32: invokevirtual 839	java/io/File:getParentFile	()Ljava/io/File;
    //   35: astore 7
    //   37: aload 5
    //   39: astore_2
    //   40: aload 7
    //   42: invokevirtual 86	java/io/File:exists	()Z
    //   45: ifne +12 -> 57
    //   48: aload 5
    //   50: astore_2
    //   51: aload 7
    //   53: invokevirtual 249	java/io/File:mkdirs	()Z
    //   56: pop
    //   57: aload 5
    //   59: astore_2
    //   60: aload 6
    //   62: invokevirtual 86	java/io/File:exists	()Z
    //   65: ifne +12 -> 77
    //   68: aload 5
    //   70: astore_2
    //   71: aload 6
    //   73: invokevirtual 267	java/io/File:createNewFile	()Z
    //   76: pop
    //   77: aload 5
    //   79: astore_2
    //   80: new 269	java/io/FileOutputStream
    //   83: dup
    //   84: aload_1
    //   85: invokespecial 840	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   88: astore_1
    //   89: aload_0
    //   90: ifnull +18 -> 108
    //   93: aload_0
    //   94: getstatic 864	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   97: bipush 99
    //   99: aload_1
    //   100: invokevirtual 110	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   103: pop
    //   104: aload_1
    //   105: invokevirtual 843	java/io/FileOutputStream:flush	()V
    //   108: aload_1
    //   109: invokestatic 846	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   112: getstatic 850	com/tencent/ttpic/baseutils/BitmapUtils$SAVE_STATUS:SAVE_SUCCESS	Lcom/tencent/ttpic/baseutils/BitmapUtils$SAVE_STATUS;
    //   115: astore_0
    //   116: ldc_w 878
    //   119: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: aload_0
    //   123: areturn
    //   124: astore_1
    //   125: aload_3
    //   126: astore_0
    //   127: aload_0
    //   128: astore_2
    //   129: aload_1
    //   130: invokestatic 126	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   133: aload_0
    //   134: astore_2
    //   135: getstatic 853	com/tencent/ttpic/baseutils/BitmapUtils$SAVE_STATUS:SAVE_FAILED	Lcom/tencent/ttpic/baseutils/BitmapUtils$SAVE_STATUS;
    //   138: astore_1
    //   139: aload_0
    //   140: invokestatic 846	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   143: ldc_w 878
    //   146: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: aload_1
    //   150: areturn
    //   151: astore_1
    //   152: aload 4
    //   154: astore_0
    //   155: aload_0
    //   156: astore_2
    //   157: aload_1
    //   158: invokestatic 126	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   161: aload_0
    //   162: astore_2
    //   163: getstatic 856	com/tencent/ttpic/baseutils/BitmapUtils$SAVE_STATUS:SAVE_OOM	Lcom/tencent/ttpic/baseutils/BitmapUtils$SAVE_STATUS;
    //   166: astore_1
    //   167: aload_0
    //   168: invokestatic 846	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   171: ldc_w 878
    //   174: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   177: aload_1
    //   178: areturn
    //   179: astore_0
    //   180: aload_2
    //   181: invokestatic 846	com/tencent/ttpic/baseutils/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   184: ldc_w 878
    //   187: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   190: aload_0
    //   191: athrow
    //   192: astore_0
    //   193: aload_1
    //   194: astore_2
    //   195: goto -15 -> 180
    //   198: astore_2
    //   199: aload_1
    //   200: astore_0
    //   201: aload_2
    //   202: astore_1
    //   203: goto -48 -> 155
    //   206: astore_2
    //   207: aload_1
    //   208: astore_0
    //   209: aload_2
    //   210: astore_1
    //   211: goto -84 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	paramBitmap	Bitmap
    //   0	214	1	paramString	String
    //   16	179	2	localObject1	Object
    //   198	4	2	localOutOfMemoryError	OutOfMemoryError
    //   206	4	2	localException	Exception
    //   13	113	3	localObject2	Object
    //   7	146	4	localObject3	Object
    //   10	68	5	localObject4	Object
    //   25	47	6	localFile1	File
    //   35	17	7	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   17	27	124	java/lang/Exception
    //   30	37	124	java/lang/Exception
    //   40	48	124	java/lang/Exception
    //   51	57	124	java/lang/Exception
    //   60	68	124	java/lang/Exception
    //   71	77	124	java/lang/Exception
    //   80	89	124	java/lang/Exception
    //   17	27	151	java/lang/OutOfMemoryError
    //   30	37	151	java/lang/OutOfMemoryError
    //   40	48	151	java/lang/OutOfMemoryError
    //   51	57	151	java/lang/OutOfMemoryError
    //   60	68	151	java/lang/OutOfMemoryError
    //   71	77	151	java/lang/OutOfMemoryError
    //   80	89	151	java/lang/OutOfMemoryError
    //   17	27	179	finally
    //   30	37	179	finally
    //   40	48	179	finally
    //   51	57	179	finally
    //   60	68	179	finally
    //   71	77	179	finally
    //   80	89	179	finally
    //   129	133	179	finally
    //   135	139	179	finally
    //   157	161	179	finally
    //   163	167	179	finally
    //   93	108	192	finally
    //   93	108	198	java/lang/OutOfMemoryError
    //   93	108	206	java/lang/Exception
  }
  
  public static Bitmap scaleBitmap(Bitmap paramBitmap, float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(49618);
    Object localObject;
    if (isLegal(paramBitmap))
    {
      localObject = new Matrix();
      ((Matrix)localObject).postScale(paramFloat, paramFloat);
    }
    for (;;)
    {
      try
      {
        localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
        if ((localObject != paramBitmap) && (paramBoolean)) {
          recycle(paramBitmap);
        }
        paramBitmap = (Bitmap)localObject;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        continue;
      }
      AppMethodBeat.o(49618);
      return paramBitmap;
      paramBitmap = null;
    }
  }
  
  public static void scaleBitmap(Bitmap paramBitmap, Canvas paramCanvas, int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, Point paramPoint, Paint paramPaint)
  {
    AppMethodBeat.i(49619);
    if (!isLegal(paramBitmap))
    {
      AppMethodBeat.o(49619);
      return;
    }
    Matrix localMatrix = new Matrix();
    int i = (int)(paramInt1 - paramPoint.x * paramDouble2);
    int j = (int)(paramInt2 - paramPoint.y * paramDouble2);
    localMatrix.postScale((float)paramDouble2, (float)paramDouble2);
    if ((i != 0) || (j != 0)) {
      localMatrix.postTranslate(i, j);
    }
    if (paramDouble1 != 0.0D) {
      localMatrix.postRotate((float)paramDouble1, paramInt1, paramInt2);
    }
    if (paramPaint == null)
    {
      AppMethodBeat.o(49619);
      return;
    }
    paramCanvas.drawBitmap(paramBitmap, localMatrix, paramPaint);
    AppMethodBeat.o(49619);
  }
  
  public static Bitmap scaleBitmapUnderLimit(Bitmap paramBitmap, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(49639);
    float f = 1.0F;
    while (i == 0)
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      Bitmap localBitmap = paramBitmap;
      try
      {
        paramBitmap = scaleBitmap(paramBitmap, f, false);
        localBitmap = paramBitmap;
        paramBitmap.compress(Bitmap.CompressFormat.JPEG, 85, localByteArrayOutputStream);
        localBitmap = paramBitmap;
        j = localByteArrayOutputStream.toByteArray().length;
        if (j <= paramInt) {
          i = 1;
        }
        f *= 0.7F;
      }
      catch (OutOfMemoryError paramBitmap)
      {
        int j;
        if (localBitmap.getHeight() >= 10)
        {
          j = localBitmap.getWidth();
          if (j >= 10) {}
        }
        else
        {
          i = 1;
        }
        f *= 0.7F;
        paramBitmap = localBitmap;
      }
      finally
      {
        AppMethodBeat.o(49639);
      }
    }
    AppMethodBeat.o(49639);
    return paramBitmap;
  }
  
  private static boolean shouldResize(BitmapUtils.Size paramSize, int paramInt1, int paramInt2)
  {
    int i;
    if (paramSize.height / paramSize.width >= 1.0D) {
      i = paramSize.height;
    }
    for (int j = paramSize.width; (j < paramInt1) && (i < paramInt2); j = paramSize.height)
    {
      return false;
      i = paramSize.width;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.BitmapUtils
 * JD-Core Version:    0.7.0.1
 */