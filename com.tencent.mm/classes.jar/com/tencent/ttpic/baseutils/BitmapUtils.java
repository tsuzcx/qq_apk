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
import com.tencent.ttpic.device.IOUtils;
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
  private static final String TAG = BitmapUtils.class.getSimpleName();
  
  private static boolean IsSupportImgType(String paramString)
  {
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
    return bool1;
  }
  
  public static boolean bmpIsExists(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.startsWith("assets://")) && (!new File(paramString).exists())) {
      return false;
    }
    return true;
  }
  
  public static byte[] bmpToByteArray(Bitmap paramBitmap, boolean paramBoolean)
  {
    if (!isLegal(paramBitmap)) {
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
      return paramBitmap;
    }
    catch (Exception localException)
    {
      LogUtils.e(localException);
    }
    return paramBitmap;
  }
  
  private static BitmapUtils.Size calcNewSize(BitmapUtils.Size paramSize, int paramInt1, int paramInt2)
  {
    int i;
    if (paramSize.height / paramSize.width >= 1.0D) {
      i = paramSize.height;
    }
    for (int j = paramSize.width;; j = paramSize.height)
    {
      return getNewSize(j, i, paramInt1, paramInt2);
      i = paramSize.width;
    }
  }
  
  public static int calculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2, boolean paramBoolean)
  {
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
            break label297;
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
            break label290;
          }
        }
      }
    }
    for (;;)
    {
      LogUtils.d(TAG, "[calculateInSampleSize] source size = " + n + " * " + m + ", request size = " + paramInt1 + " * " + paramInt2 + ", inSampleSize = " + i + ", preferLarge = " + paramBoolean);
      return i;
      label290:
      i = j;
      continue;
      label297:
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
    int i = paramOptions.outHeight;
    int j = paramOptions.outWidth;
    float f1 = Math.max(j, i);
    float f2 = Math.min(j, i);
    float f3 = Math.max(paramInt1, paramInt2);
    if ((Math.min(paramInt1, paramInt2) <= 0.0F) || (f1 <= f3)) {
      paramInt1 = 1;
    }
    do
    {
      do
      {
        return paramInt1;
        if (f1 / f2 <= 2.0F) {
          break;
        }
        f1 = i * j;
        f2 = paramInt1 * paramInt2;
        if (!ApiHelper.hasNougat()) {
          break label252;
        }
        paramInt2 = 1;
        while (f1 / (paramInt2 * paramInt2) >= f2) {
          paramInt2 += 1;
        }
        paramInt1 = paramInt2;
      } while (!paramBoolean);
      paramInt1 = paramInt2;
    } while (paramInt2 <= 1);
    return paramInt2 - 1;
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
        return paramInt2 / 2;
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
          return paramInt2 - 1;
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
            return paramInt2 / 2;
            paramInt2 = 1;
          }
        }
        label252:
        paramInt2 = 1;
      }
    }
  }
  
  public static String compressImage(String paramString, BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    try
    {
      paramString = compressImageFile(paramString, getScaledOpt(paramOptions, paramInt1, paramInt2), new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separatorChar + "Pitu"));
      return paramString;
    }
    catch (Exception paramString)
    {
      LogUtils.e(paramString);
    }
    return null;
  }
  
  /* Error */
  private static String compressImageFile(String paramString, BitmapFactory.Options paramOptions, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: getstatic 38	com/tencent/ttpic/baseutils/BitmapUtils:TAG	Ljava/lang/String;
    //   6: ldc 225
    //   8: iconst_3
    //   9: anewarray 4	java/lang/Object
    //   12: dup
    //   13: iconst_0
    //   14: aload_0
    //   15: aastore
    //   16: dup
    //   17: iconst_1
    //   18: aload_1
    //   19: aastore
    //   20: dup
    //   21: iconst_2
    //   22: aload_2
    //   23: invokevirtual 206	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   26: aastore
    //   27: invokestatic 228	com/tencent/ttpic/baseutils/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   30: aload_2
    //   31: invokevirtual 74	java/io/File:exists	()Z
    //   34: ifne +8 -> 42
    //   37: aload_2
    //   38: invokevirtual 231	java/io/File:mkdirs	()Z
    //   41: pop
    //   42: new 150	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   49: aload_2
    //   50: invokevirtual 206	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   53: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: getstatic 234	java/io/File:separator	Ljava/lang/String;
    //   59: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: ldc 236
    //   64: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: new 238	java/util/Date
    //   70: dup
    //   71: invokespecial 239	java/util/Date:<init>	()V
    //   74: invokevirtual 243	java/util/Date:getTime	()J
    //   77: invokevirtual 246	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   80: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: astore 5
    //   85: new 67	java/io/File
    //   88: dup
    //   89: aload 5
    //   91: invokespecial 70	java/io/File:<init>	(Ljava/lang/String;)V
    //   94: astore_2
    //   95: aload_2
    //   96: invokevirtual 74	java/io/File:exists	()Z
    //   99: ifne +8 -> 107
    //   102: aload_2
    //   103: invokevirtual 249	java/io/File:createNewFile	()Z
    //   106: pop
    //   107: new 251	java/io/FileOutputStream
    //   110: dup
    //   111: aload_2
    //   112: invokespecial 254	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   115: astore_3
    //   116: aload_3
    //   117: astore_2
    //   118: aload_1
    //   119: getfield 257	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   122: invokestatic 259	com/tencent/ttpic/baseutils/BitmapUtils:IsSupportImgType	(Ljava/lang/String;)Z
    //   125: ifne +57 -> 182
    //   128: aload_3
    //   129: astore_2
    //   130: aload_1
    //   131: getstatic 265	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   134: putfield 268	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   137: aload_3
    //   138: astore_2
    //   139: aload_1
    //   140: iconst_1
    //   141: putfield 272	android/graphics/BitmapFactory$Options:inPurgeable	Z
    //   144: aload_3
    //   145: astore_2
    //   146: aload_1
    //   147: iconst_1
    //   148: putfield 275	android/graphics/BitmapFactory$Options:inInputShareable	Z
    //   151: aload_3
    //   152: astore_2
    //   153: aload_0
    //   154: aload_1
    //   155: invokestatic 281	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   158: astore_0
    //   159: aload_0
    //   160: ifnull +49 -> 209
    //   163: aload_3
    //   164: astore_2
    //   165: aload_0
    //   166: getstatic 91	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   169: bipush 90
    //   171: aload_3
    //   172: invokevirtual 97	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   175: pop
    //   176: aload_3
    //   177: astore_2
    //   178: aload_0
    //   179: invokevirtual 100	android/graphics/Bitmap:recycle	()V
    //   182: aload_3
    //   183: astore_2
    //   184: aload_3
    //   185: invokevirtual 284	java/io/OutputStream:close	()V
    //   188: aload_3
    //   189: invokevirtual 284	java/io/OutputStream:close	()V
    //   192: aload 5
    //   194: astore_1
    //   195: aload_1
    //   196: areturn
    //   197: astore_0
    //   198: aload_3
    //   199: astore_2
    //   200: aload_0
    //   201: invokestatic 113	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   204: aconst_null
    //   205: astore_0
    //   206: goto -47 -> 159
    //   209: aload_3
    //   210: invokevirtual 284	java/io/OutputStream:close	()V
    //   213: aconst_null
    //   214: areturn
    //   215: astore_0
    //   216: aconst_null
    //   217: areturn
    //   218: astore_1
    //   219: aconst_null
    //   220: astore_0
    //   221: aload_0
    //   222: astore_2
    //   223: aload_1
    //   224: invokestatic 113	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   227: aload 4
    //   229: astore_1
    //   230: aload_0
    //   231: ifnull -36 -> 195
    //   234: aload_0
    //   235: invokevirtual 284	java/io/OutputStream:close	()V
    //   238: aconst_null
    //   239: areturn
    //   240: astore_0
    //   241: aconst_null
    //   242: areturn
    //   243: astore_0
    //   244: aconst_null
    //   245: astore_2
    //   246: aload_2
    //   247: ifnull +7 -> 254
    //   250: aload_2
    //   251: invokevirtual 284	java/io/OutputStream:close	()V
    //   254: aload_0
    //   255: athrow
    //   256: astore_0
    //   257: goto -65 -> 192
    //   260: astore_1
    //   261: goto -7 -> 254
    //   264: astore_0
    //   265: goto -19 -> 246
    //   268: astore_1
    //   269: aload_3
    //   270: astore_0
    //   271: goto -50 -> 221
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	274	0	paramString	String
    //   0	274	1	paramOptions	BitmapFactory.Options
    //   0	274	2	paramFile	File
    //   115	155	3	localFileOutputStream	java.io.FileOutputStream
    //   1	227	4	localObject	Object
    //   83	110	5	str	String
    // Exception table:
    //   from	to	target	type
    //   153	159	197	java/lang/OutOfMemoryError
    //   209	213	215	java/io/IOException
    //   95	107	218	java/lang/Exception
    //   107	116	218	java/lang/Exception
    //   234	238	240	java/io/IOException
    //   95	107	243	finally
    //   107	116	243	finally
    //   188	192	256	java/io/IOException
    //   250	254	260	java/io/IOException
    //   118	128	264	finally
    //   130	137	264	finally
    //   139	144	264	finally
    //   146	151	264	finally
    //   153	159	264	finally
    //   165	176	264	finally
    //   178	182	264	finally
    //   184	188	264	finally
    //   200	204	264	finally
    //   223	227	264	finally
    //   118	128	268	java/lang/Exception
    //   130	137	268	java/lang/Exception
    //   139	144	268	java/lang/Exception
    //   146	151	268	java/lang/Exception
    //   153	159	268	java/lang/Exception
    //   165	176	268	java/lang/Exception
    //   178	182	268	java/lang/Exception
    //   184	188	268	java/lang/Exception
    //   200	204	268	java/lang/Exception
  }
  
  public static Bitmap convertToSRGB(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), paramBitmap.getConfig());
      new Canvas(localBitmap).drawBitmap(paramBitmap, 0.0F, 0.0F, new Paint());
      paramBitmap.recycle();
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      LogUtils.e(localOutOfMemoryError);
    }
    return paramBitmap;
  }
  
  public static Bitmap copy(Bitmap paramBitmap, boolean paramBoolean)
  {
    Bitmap localBitmap = null;
    try
    {
      if (isLegal(paramBitmap)) {
        localBitmap = paramBitmap.copy(paramBitmap.getConfig(), paramBoolean);
      }
      return localBitmap;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      LogUtils.e(TAG, "bitmap copy OOM!");
    }
    return null;
  }
  
  public static Bitmap correctImageToFitIn(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    Bitmap localBitmap = null;
    int i;
    int j;
    if (paramBitmap != null)
    {
      i = paramBitmap.getWidth();
      j = paramBitmap.getHeight();
      if ((i <= paramInt1) && (j <= paramInt2)) {
        localBitmap = Bitmap.createScaledBitmap(paramBitmap, i, j, true);
      }
    }
    else
    {
      return localBitmap;
    }
    if (paramInt2 * 1.0D / j > paramInt1 * 1.0D / i)
    {
      d = paramInt1 * 1.0D / i;
      return Bitmap.createScaledBitmap(paramBitmap, paramInt1, (int)(j * d), true);
    }
    double d = paramInt2 * 1.0D / j;
    return Bitmap.createScaledBitmap(paramBitmap, (int)(i * d), paramInt2, true);
  }
  
  public static Bitmap createBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Matrix paramMatrix)
  {
    Object localObject2 = null;
    if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
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
        return localObject1;
      }
      catch (OutOfMemoryError paramBitmap)
      {
        LogUtils.e(paramBitmap);
        return null;
      }
      catch (NullPointerException paramBitmap)
      {
        LogUtils.e(paramBitmap);
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
      }
    }
    return null;
  }
  
  public static Bitmap decodeBitmapFromFileExtForShare(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject1 = null;
    LogUtils.d(TAG, "decodeBitmapFromFileExtForShare(%s, %d, %d, %d)", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (!new File(paramString).exists()) {
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
            localObject1 = localBitmap;
          } while (localOptions.inSampleSize <= paramInt3);
          if ((localBitmap != null) && (k != 0))
          {
            return rotateBitmap(localBitmap, k);
            i = localOptions.outHeight;
            continue;
            j = localOptions.outHeight;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          Object localObject2;
          for (;;)
          {
            localOptions.inSampleSize *= 2;
            LogUtils.w(TAG, "[decodeBitmapFromFileExtForShare] " + localOutOfMemoryError.getMessage());
            localObject2 = localObject1;
          }
          return localObject2;
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
    LogUtils.d(TAG, "decodeBitmapFromFileForShare(%s, %d, %d, %s)", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramArrayOfInt });
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      if (new File(paramString).exists())
      {
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
          LogUtils.v(TAG, "decodeBitmapFromFileForShare(), inSampleSize = " + i);
          localOptions.inSampleSize = i;
          paramArrayOfInt = BitmapFactory.decodeFile(paramString, localOptions);
          paramString = paramArrayOfInt;
          if (j != 0) {
            paramString = rotateBitmap(paramArrayOfInt, j);
          }
          if (paramString != null)
          {
            paramString = getFinalBitmap(paramString, paramInt1, paramInt2);
            return paramString;
          }
        }
        catch (Exception paramString)
        {
          LogUtils.e(paramString);
          return null;
        }
        catch (OutOfMemoryError paramString)
        {
          LogUtils.e(paramString);
        }
      }
    }
    return null;
  }
  
  public static Bitmap decodeSampleBitmap(Context paramContext, String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      if (paramString.startsWith("assets://")) {
        return decodeSampleBitmapFromAssets(paramContext, getRealPath(paramString), paramInt);
      }
    } while (!bmpIsExists(paramString));
    return decodeSampledBitmapFromFile(paramString, paramInt);
  }
  
  public static Bitmap decodeSampleBitmap(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      if (paramString.startsWith("assets://")) {
        return decodeSampledBitmapFromAssets(paramContext, getRealPath(paramString), paramInt1, paramInt2);
      }
    } while (!bmpIsExists(paramString));
    return decodeSampledBitmapFromFile(paramString, paramInt1, paramInt2);
  }
  
  /* Error */
  public static Bitmap decodeSampleBitmapFromAssets(Context paramContext, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_1
    //   6: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifeq +8 -> 17
    //   12: aload 4
    //   14: astore_0
    //   15: aload_0
    //   16: areturn
    //   17: aload_0
    //   18: invokevirtual 484	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   21: astore_0
    //   22: aload_0
    //   23: aload_1
    //   24: invokevirtual 490	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   27: astore 5
    //   29: new 129	android/graphics/BitmapFactory$Options
    //   32: dup
    //   33: invokespecial 411	android/graphics/BitmapFactory$Options:<init>	()V
    //   36: astore_0
    //   37: aload_0
    //   38: iconst_0
    //   39: putfield 414	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   42: aload_0
    //   43: iload_2
    //   44: putfield 417	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   47: aload 5
    //   49: aconst_null
    //   50: aload_0
    //   51: invokestatic 494	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   54: astore_1
    //   55: aload_1
    //   56: astore_0
    //   57: aload 5
    //   59: ifnull -44 -> 15
    //   62: aload 5
    //   64: invokevirtual 497	java/io/InputStream:close	()V
    //   67: aload_1
    //   68: areturn
    //   69: astore_0
    //   70: aload_1
    //   71: areturn
    //   72: astore_0
    //   73: aload_0
    //   74: invokevirtual 498	java/io/IOException:toString	()Ljava/lang/String;
    //   77: pop
    //   78: aconst_null
    //   79: areturn
    //   80: astore_0
    //   81: aload_0
    //   82: invokevirtual 499	java/lang/Exception:toString	()Ljava/lang/String;
    //   85: pop
    //   86: aload 4
    //   88: astore_0
    //   89: aload 5
    //   91: ifnull -76 -> 15
    //   94: aload 5
    //   96: invokevirtual 497	java/io/InputStream:close	()V
    //   99: aconst_null
    //   100: areturn
    //   101: astore_0
    //   102: aconst_null
    //   103: areturn
    //   104: astore_1
    //   105: aload_0
    //   106: aload_0
    //   107: getfield 417	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   110: iconst_1
    //   111: ishl
    //   112: putfield 417	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   115: aload 5
    //   117: invokevirtual 502	java/io/InputStream:reset	()V
    //   120: aload 5
    //   122: aconst_null
    //   123: aload_0
    //   124: invokestatic 494	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   127: astore_1
    //   128: aload_1
    //   129: astore_0
    //   130: aload 5
    //   132: ifnull -117 -> 15
    //   135: aload 5
    //   137: invokevirtual 497	java/io/InputStream:close	()V
    //   140: aload_1
    //   141: areturn
    //   142: astore_0
    //   143: aload_1
    //   144: areturn
    //   145: astore_0
    //   146: aload_0
    //   147: invokevirtual 505	java/lang/Throwable:toString	()Ljava/lang/String;
    //   150: pop
    //   151: aload_3
    //   152: astore_1
    //   153: goto -25 -> 128
    //   156: astore_0
    //   157: aload 5
    //   159: ifnull +8 -> 167
    //   162: aload 5
    //   164: invokevirtual 497	java/io/InputStream:close	()V
    //   167: aload_0
    //   168: athrow
    //   169: astore_1
    //   170: goto -3 -> 167
    //   173: astore_0
    //   174: goto -28 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	paramContext	Context
    //   0	177	1	paramString	String
    //   0	177	2	paramInt	int
    //   1	151	3	localObject1	Object
    //   3	84	4	localObject2	Object
    //   27	136	5	localInputStream	InputStream
    // Exception table:
    //   from	to	target	type
    //   62	67	69	java/io/IOException
    //   22	29	72	java/io/IOException
    //   47	55	80	java/lang/Exception
    //   94	99	101	java/io/IOException
    //   47	55	104	java/lang/OutOfMemoryError
    //   135	140	142	java/io/IOException
    //   115	128	145	java/lang/OutOfMemoryError
    //   47	55	156	finally
    //   81	86	156	finally
    //   105	115	156	finally
    //   115	128	156	finally
    //   146	151	156	finally
    //   162	167	169	java/io/IOException
    //   115	128	173	java/io/IOException
  }
  
  public static Bitmap decodeSampledBitmapFromAssets(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {
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
          return paramContext;
          paramContext = paramContext;
          try
          {
            paramString = ((AssetManager)localObject).open(paramString.substring(0, paramString.lastIndexOf('.') + 1) + "webp");
          }
          catch (IOException paramContext)
          {
            LogUtils.e(TAG, paramContext);
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
      label178:
      break label178;
    }
  }
  
  public static Bitmap decodeSampledBitmapFromDescriptor(FileDescriptor paramFileDescriptor, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFileDescriptor(paramFileDescriptor, null, localOptions);
    localOptions.inSampleSize = calculateInSampleSizeNew(localOptions, paramInt1, paramInt2, true);
    localOptions.inJustDecodeBounds = false;
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeFileDescriptor(paramFileDescriptor, null, localOptions);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOptions.inSampleSize <<= 1;
      try
      {
        paramFileDescriptor = BitmapFactory.decodeFileDescriptor(paramFileDescriptor, null, localOptions);
        return paramFileDescriptor;
      }
      catch (OutOfMemoryError paramFileDescriptor)
      {
        LogUtils.e(localOutOfMemoryError);
        return null;
      }
    }
    catch (Exception paramFileDescriptor) {}
    return null;
  }
  
  public static Bitmap decodeSampledBitmapFromFile(String paramString, int paramInt)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inSampleSize = paramInt;
    localOptions.inJustDecodeBounds = false;
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeFile(paramString, localOptions);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOptions.inSampleSize <<= 1;
      try
      {
        paramString = BitmapFactory.decodeFile(paramString, localOptions);
        return paramString;
      }
      catch (OutOfMemoryError paramString)
      {
        paramString.toString();
      }
    }
    return null;
  }
  
  public static Bitmap decodeSampledBitmapFromFile(String paramString, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    localOptions.inSampleSize = calculateInSampleSizeNew(localOptions, paramInt1, paramInt2, true);
    localOptions.inJustDecodeBounds = false;
    ApiHelper.hasHoneycomb();
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeFile(paramString, localOptions);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOptions.inSampleSize <<= 1;
      try
      {
        paramString = BitmapFactory.decodeFile(paramString, localOptions);
        return paramString;
      }
      catch (OutOfMemoryError paramString)
      {
        LogUtils.e(paramString);
      }
    }
    return null;
  }
  
  public static Bitmap decodeSampledBitmapFromFileCheckExif(String paramString, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    localOptions.inSampleSize = calculateInSampleSizeNew(localOptions, paramInt1, paramInt2, true);
    localOptions.inJustDecodeBounds = false;
    paramInt1 = getDegreeByExif(paramString) % 360;
    Object localObject = null;
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
          if (paramInt1 == 0) {
            continue;
          }
          localObject = paramString;
          paramString = rotateBitmap(paramString, paramInt1);
          return paramString;
        }
        catch (OutOfMemoryError paramString)
        {
          LogUtils.e(paramString);
        }
      }
    }
    return localObject;
    return localObject;
  }
  
  public static Bitmap decodeSampledBitmapFromResource(Resources paramResources, int paramInt1, int paramInt2, int paramInt3)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeResource(paramResources, paramInt1, localOptions);
    localOptions.inSampleSize = calculateInSampleSizeNew(localOptions, paramInt2, paramInt3, true);
    localOptions.inJustDecodeBounds = false;
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeResource(paramResources, paramInt1, localOptions);
      return localBitmap;
    }
    catch (Exception paramResources)
    {
      LogUtils.e(paramResources);
      return null;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      LogUtils.e(localOutOfMemoryError);
      try
      {
        localOptions.inSampleSize *= 2;
        paramResources = BitmapFactory.decodeResource(paramResources, paramInt1, localOptions);
        return paramResources;
      }
      catch (OutOfMemoryError paramResources) {}
    }
    return null;
  }
  
  public static Bitmap decodeSampledBitmapFromUri(Uri paramUri, int paramInt1, int paramInt2)
  {
    if (paramUri != null) {}
    for (;;)
    {
      try
      {
        String str = paramUri.getScheme();
        if ((str != null) && (str.toLowerCase().startsWith("file")))
        {
          paramUri = Uri.decode(paramUri.toString()).substring(7);
          LogUtils.v(TAG, "decodeSampledBitmapFromUri(), file = " + paramUri);
          paramUri = decodeSampledBitmapFromFileCheckExif(paramUri, paramInt1, paramInt2);
          if (paramUri == null) {}
        }
      }
      catch (Exception localException1)
      {
        paramUri = null;
        LogUtils.e(localException1);
        return paramUri;
      }
      finally
      {
        IOUtils.closeQuietly(null);
        IOUtils.closeQuietly(null);
      }
      try
      {
        LogUtils.v(TAG, "decodeSampledBitmapFromUri(), width = " + paramUri.getWidth() + ", height = " + paramUri.getHeight());
        IOUtils.closeQuietly(null);
        IOUtils.closeQuietly(null);
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
        LogUtils.v(TAG, "decodeSampledBitmapFromUri() in else , file = " + paramUri);
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
  }
  
  public static void fixBgRepeatY(View paramView)
  {
    paramView = paramView.getBackground();
    if ((paramView != null) && ((paramView instanceof BitmapDrawable)))
    {
      paramView = (BitmapDrawable)paramView;
      paramView.mutate();
      paramView.setTileModeY(Shader.TileMode.REPEAT);
    }
  }
  
  public static Bitmap flipBitmap(Bitmap paramBitmap, boolean paramBoolean)
  {
    Object localObject = paramBitmap;
    if (paramBitmap != null)
    {
      localObject = new Matrix();
      if (!paramBoolean) {
        break label58;
      }
      ((Matrix)localObject).setScale(1.0F, -1.0F);
    }
    for (;;)
    {
      try
      {
        Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
        localObject = paramBitmap;
        if (paramBitmap != localBitmap)
        {
          paramBitmap.recycle();
          localObject = localBitmap;
        }
        return localObject;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        label58:
        LogUtils.e(TAG, "OutOfMemoryError. " + localOutOfMemoryError);
      }
      ((Matrix)localObject).setScale(-1.0F, 1.0F);
    }
    return paramBitmap;
  }
  
  /* Error */
  public static String getBase64FromBitmap(Bitmap paramBitmap, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +16 -> 17
    //   4: getstatic 38	com/tencent/ttpic/baseutils/BitmapUtils:TAG	Ljava/lang/String;
    //   7: ldc_w 641
    //   10: invokestatic 178	com/tencent/ttpic/baseutils/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   13: ldc_w 643
    //   16: areturn
    //   17: new 84	java/io/ByteArrayOutputStream
    //   20: dup
    //   21: invokespecial 85	java/io/ByteArrayOutputStream:<init>	()V
    //   24: astore_2
    //   25: aload_0
    //   26: getstatic 91	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   29: bipush 100
    //   31: aload_2
    //   32: invokevirtual 97	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   35: pop
    //   36: aload_2
    //   37: invokevirtual 104	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   40: iload_1
    //   41: invokestatic 649	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   44: astore_0
    //   45: aload_2
    //   46: invokevirtual 107	java/io/ByteArrayOutputStream:close	()V
    //   49: aload_0
    //   50: areturn
    //   51: astore_2
    //   52: aload_2
    //   53: invokestatic 113	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   56: aload_0
    //   57: areturn
    //   58: astore_0
    //   59: aconst_null
    //   60: astore_2
    //   61: aload_2
    //   62: ifnull -49 -> 13
    //   65: aload_2
    //   66: invokevirtual 107	java/io/ByteArrayOutputStream:close	()V
    //   69: ldc_w 643
    //   72: areturn
    //   73: astore_0
    //   74: aload_0
    //   75: invokestatic 113	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   78: ldc_w 643
    //   81: areturn
    //   82: astore_0
    //   83: aconst_null
    //   84: astore_2
    //   85: aload_2
    //   86: ifnull -73 -> 13
    //   89: aload_2
    //   90: invokevirtual 107	java/io/ByteArrayOutputStream:close	()V
    //   93: ldc_w 643
    //   96: areturn
    //   97: astore_0
    //   98: aload_0
    //   99: invokestatic 113	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   102: ldc_w 643
    //   105: areturn
    //   106: astore_0
    //   107: goto -22 -> 85
    //   110: astore_0
    //   111: goto -50 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	paramBitmap	Bitmap
    //   0	114	1	paramInt	int
    //   24	22	2	localByteArrayOutputStream	ByteArrayOutputStream
    //   51	2	2	localIOException	IOException
    //   60	30	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   45	49	51	java/io/IOException
    //   17	25	58	java/lang/Exception
    //   65	69	73	java/io/IOException
    //   17	25	82	finally
    //   89	93	97	java/io/IOException
    //   25	45	106	finally
    //   25	45	110	java/lang/Exception
  }
  
  public static Bitmap getBitmapFromURL(String paramString)
  {
    try
    {
      paramString = (HttpURLConnection)new URL(paramString).openConnection();
      paramString.setDoInput(true);
      paramString.connect();
      paramString = BitmapFactory.decodeStream(paramString.getInputStream());
      return paramString;
    }
    catch (IOException paramString) {}
    return null;
  }
  
  public static BitmapFactory.Options getBitmapOptionsFromAssets(Context paramContext, String paramString)
  {
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
          break label124;
        }
        IOUtils.closeQuietly(paramContext);
      }
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
        return null;
      }
    }
  }
  
  public static BitmapFactory.Options getBitmapOptionsFromFile(String paramString)
  {
    if (paramString == null) {}
    while (!new File(paramString).exists()) {
      return null;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    return localOptions;
  }
  
  public static BitmapFactory.Options getBitmapOptionsFromResource(Resources paramResources, int paramInt)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeResource(paramResources, paramInt, localOptions);
    return localOptions;
  }
  
  public static BitmapFactory.Options getBitmapOptionsFromUri(Context paramContext, Uri paramUri)
  {
    Object localObject = null;
    if (paramUri != null) {}
    for (paramContext = paramUri.getScheme();; paramContext = null)
    {
      if ((paramContext != null) && (paramContext.toLowerCase().startsWith("file")))
      {
        paramContext = Uri.decode(paramUri.toString()).substring(7);
        LogUtils.v(TAG, "[getBitmapOptionsFromUri] file = " + paramContext);
        paramContext = getBitmapOptionsFromFile(paramContext);
      }
      do
      {
        return paramContext;
        paramContext = localObject;
      } while (paramUri == null);
      paramContext = Uri.decode(paramUri.toString());
      LogUtils.v(TAG, "[getBitmapOptionsFromUri] in else , file = " + paramContext);
      return getBitmapOptionsFromFile(paramContext);
    }
  }
  
  public static Point getBitmapSize(Context paramContext, String paramString)
  {
    if (paramString.startsWith("assets://")) {
      return getBitmapSizeFromAssets(paramContext, getRealPath(paramString));
    }
    return getBitmapSizeFromFile(paramString);
  }
  
  /* Error */
  private static Point getBitmapSizeFromAssets(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: new 698	android/graphics/Point
    //   7: dup
    //   8: iconst_0
    //   9: iconst_0
    //   10: invokespecial 699	android/graphics/Point:<init>	(II)V
    //   13: astore 4
    //   15: aload_1
    //   16: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   19: ifeq +6 -> 25
    //   22: aload 4
    //   24: areturn
    //   25: aload_0
    //   26: invokevirtual 484	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   29: astore 5
    //   31: aload_3
    //   32: astore_0
    //   33: aload 5
    //   35: aload_1
    //   36: invokevirtual 490	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   39: astore_1
    //   40: aload_1
    //   41: astore_0
    //   42: aload_1
    //   43: astore_2
    //   44: new 129	android/graphics/BitmapFactory$Options
    //   47: dup
    //   48: invokespecial 411	android/graphics/BitmapFactory$Options:<init>	()V
    //   51: astore_3
    //   52: aload_1
    //   53: astore_0
    //   54: aload_1
    //   55: astore_2
    //   56: aload_3
    //   57: iconst_1
    //   58: putfield 414	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   61: aload_1
    //   62: astore_0
    //   63: aload_1
    //   64: astore_2
    //   65: aload_1
    //   66: aconst_null
    //   67: aload_3
    //   68: invokestatic 494	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   71: pop
    //   72: aload_1
    //   73: astore_0
    //   74: aload_1
    //   75: astore_2
    //   76: new 698	android/graphics/Point
    //   79: dup
    //   80: aload_3
    //   81: getfield 135	android/graphics/BitmapFactory$Options:outWidth	I
    //   84: aload_3
    //   85: getfield 132	android/graphics/BitmapFactory$Options:outHeight	I
    //   88: invokespecial 699	android/graphics/Point:<init>	(II)V
    //   91: astore_3
    //   92: aload_1
    //   93: ifnull +7 -> 100
    //   96: aload_1
    //   97: invokevirtual 497	java/io/InputStream:close	()V
    //   100: aload_3
    //   101: areturn
    //   102: astore_1
    //   103: aload_0
    //   104: astore_2
    //   105: aload_1
    //   106: invokevirtual 498	java/io/IOException:toString	()Ljava/lang/String;
    //   109: pop
    //   110: aload_0
    //   111: ifnull -89 -> 22
    //   114: aload_0
    //   115: invokevirtual 497	java/io/InputStream:close	()V
    //   118: aload 4
    //   120: areturn
    //   121: astore_0
    //   122: aload 4
    //   124: areturn
    //   125: astore_0
    //   126: aload_2
    //   127: ifnull +7 -> 134
    //   130: aload_2
    //   131: invokevirtual 497	java/io/InputStream:close	()V
    //   134: aload_0
    //   135: athrow
    //   136: astore_0
    //   137: goto -37 -> 100
    //   140: astore_1
    //   141: goto -7 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	paramContext	Context
    //   0	144	1	paramString	String
    //   1	130	2	localObject1	Object
    //   3	98	3	localObject2	Object
    //   13	110	4	localPoint	Point
    //   29	5	5	localAssetManager	AssetManager
    // Exception table:
    //   from	to	target	type
    //   33	40	102	java/io/IOException
    //   44	52	102	java/io/IOException
    //   56	61	102	java/io/IOException
    //   65	72	102	java/io/IOException
    //   76	92	102	java/io/IOException
    //   114	118	121	java/io/IOException
    //   33	40	125	finally
    //   44	52	125	finally
    //   56	61	125	finally
    //   65	72	125	finally
    //   76	92	125	finally
    //   105	110	125	finally
    //   96	100	136	java/io/IOException
    //   130	134	140	java/io/IOException
  }
  
  private static Point getBitmapSizeFromFile(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    return new Point(localOptions.outWidth, localOptions.outHeight);
  }
  
  @SuppressLint({"NewApi"})
  public static int getBitmapSizeInBytes(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return 0;
    }
    if (Build.VERSION.SDK_INT > 19) {
      try
      {
        int i = paramBitmap.getAllocationByteCount();
        return i;
      }
      catch (NullPointerException localNullPointerException) {}
    }
    if (Build.VERSION.SDK_INT >= 12) {
      return paramBitmap.getByteCount();
    }
    return paramBitmap.getWidth() * paramBitmap.getRowBytes();
  }
  
  public static int getDegreeByExif(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    try
    {
      int i = getDegreeByOrientation(new ExifInterface(paramString).getAttributeInt("Orientation", 0));
      return i;
    }
    catch (Exception paramString) {}
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
    int i = Math.max(paramBitmap.getWidth(), paramBitmap.getHeight());
    int j = Math.min(paramBitmap.getWidth(), paramBitmap.getHeight());
    Bitmap localBitmap;
    if (i <= paramInt2)
    {
      localBitmap = paramBitmap;
      if (j <= paramInt1) {}
    }
    else
    {
      float f = Math.min(paramInt2 / i, paramInt1 / j);
      Matrix localMatrix = new Matrix();
      localMatrix.setScale(f, f);
      localBitmap = Bitmap.createBitmap((int)(paramBitmap.getWidth() * f), (int)(f * paramBitmap.getHeight()), Bitmap.Config.ARGB_8888);
      Paint localPaint = new Paint();
      localPaint.setAntiAlias(true);
      localPaint.setDither(true);
      localPaint.setFilterBitmap(true);
      new Canvas(localBitmap).drawBitmap(paramBitmap, localMatrix, localPaint);
      recycle(paramBitmap);
    }
    return localBitmap;
  }
  
  public static int[] getImageSize(String paramString, int paramInt1, int paramInt2)
  {
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
      return new int[] { paramInt2, paramInt1 };
      i = paramInt2;
      paramInt2 = paramInt1;
      paramInt1 = i;
    }
  }
  
  private static BitmapUtils.Size getNewSize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f = Math.min(paramInt3 / paramInt1, paramInt4 / paramInt2);
    if (f < 1.0D) {
      return new BitmapUtils.Size((int)(paramInt1 * f), (int)(f * paramInt2));
    }
    return new BitmapUtils.Size(paramInt1, paramInt2);
  }
  
  public static String getRealPath(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (paramString.startsWith("assets://")) {
        str = paramString.substring(9);
      }
    }
    return str;
  }
  
  private static BitmapFactory.Options getScaledOpt(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inSampleSize = calculateInSampleSizeNew(paramOptions, paramInt1, paramInt2, false);
    localOptions.inJustDecodeBounds = false;
    return localOptions;
  }
  
  public static boolean isLegal(Bitmap paramBitmap)
  {
    return (paramBitmap != null) && (!paramBitmap.isRecycled());
  }
  
  private static boolean isPowerOf2(int paramInt)
  {
    return (paramInt - 1 & paramInt) == 0;
  }
  
  public static boolean recycle(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      paramBitmap.recycle();
      return true;
    }
    return false;
  }
  
  public static Bitmap rotateBitmap(Bitmap paramBitmap, int paramInt)
  {
    Object localObject = paramBitmap;
    if (paramBitmap != null)
    {
      localObject = new Matrix();
      ((Matrix)localObject).setRotate(paramInt, paramBitmap.getWidth() / 2.0F, paramBitmap.getHeight() / 2.0F);
    }
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
      localObject = paramBitmap;
      if (paramBitmap != localBitmap)
      {
        paramBitmap.recycle();
        localObject = localBitmap;
      }
      return localObject;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
    return paramBitmap;
  }
  
  public static Bitmap roundRectBitmap(Bitmap paramBitmap, int paramInt)
  {
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
    return paramBitmap;
  }
  
  /* Error */
  public static BitmapUtils.SAVE_STATUS saveBitmap(Bitmap paramBitmap, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore_3
    //   8: aload 5
    //   10: astore_2
    //   11: new 67	java/io/File
    //   14: dup
    //   15: aload_1
    //   16: invokespecial 70	java/io/File:<init>	(Ljava/lang/String;)V
    //   19: astore 6
    //   21: aload 5
    //   23: astore_2
    //   24: aload 6
    //   26: invokevirtual 784	java/io/File:getParentFile	()Ljava/io/File;
    //   29: astore 7
    //   31: aload 5
    //   33: astore_2
    //   34: aload 7
    //   36: invokevirtual 74	java/io/File:exists	()Z
    //   39: ifne +12 -> 51
    //   42: aload 5
    //   44: astore_2
    //   45: aload 7
    //   47: invokevirtual 231	java/io/File:mkdirs	()Z
    //   50: pop
    //   51: aload 5
    //   53: astore_2
    //   54: aload 6
    //   56: invokevirtual 74	java/io/File:exists	()Z
    //   59: ifne +12 -> 71
    //   62: aload 5
    //   64: astore_2
    //   65: aload 6
    //   67: invokevirtual 249	java/io/File:createNewFile	()Z
    //   70: pop
    //   71: aload 5
    //   73: astore_2
    //   74: new 251	java/io/FileOutputStream
    //   77: dup
    //   78: aload_1
    //   79: invokespecial 785	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   82: astore_1
    //   83: aload_0
    //   84: ifnull +18 -> 102
    //   87: aload_0
    //   88: getstatic 91	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   91: bipush 99
    //   93: aload_1
    //   94: invokevirtual 97	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   97: pop
    //   98: aload_1
    //   99: invokevirtual 788	java/io/FileOutputStream:flush	()V
    //   102: aload_1
    //   103: invokestatic 791	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   106: getstatic 795	com/tencent/ttpic/baseutils/BitmapUtils$SAVE_STATUS:SAVE_SUCCESS	Lcom/tencent/ttpic/baseutils/BitmapUtils$SAVE_STATUS;
    //   109: areturn
    //   110: astore_1
    //   111: aload_3
    //   112: astore_0
    //   113: aload_0
    //   114: astore_2
    //   115: aload_1
    //   116: invokestatic 113	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   119: aload_0
    //   120: astore_2
    //   121: getstatic 798	com/tencent/ttpic/baseutils/BitmapUtils$SAVE_STATUS:SAVE_FAILED	Lcom/tencent/ttpic/baseutils/BitmapUtils$SAVE_STATUS;
    //   124: astore_1
    //   125: aload_0
    //   126: invokestatic 791	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   129: aload_1
    //   130: areturn
    //   131: astore_1
    //   132: aload 4
    //   134: astore_0
    //   135: aload_0
    //   136: astore_2
    //   137: aload_1
    //   138: invokestatic 113	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   141: aload_0
    //   142: astore_2
    //   143: getstatic 801	com/tencent/ttpic/baseutils/BitmapUtils$SAVE_STATUS:SAVE_OOM	Lcom/tencent/ttpic/baseutils/BitmapUtils$SAVE_STATUS;
    //   146: astore_1
    //   147: aload_0
    //   148: invokestatic 791	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   151: aload_1
    //   152: areturn
    //   153: astore_0
    //   154: aload_2
    //   155: invokestatic 791	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   158: aload_0
    //   159: athrow
    //   160: astore_0
    //   161: aload_1
    //   162: astore_2
    //   163: goto -9 -> 154
    //   166: astore_2
    //   167: aload_1
    //   168: astore_0
    //   169: aload_2
    //   170: astore_1
    //   171: goto -36 -> 135
    //   174: astore_2
    //   175: aload_1
    //   176: astore_0
    //   177: aload_2
    //   178: astore_1
    //   179: goto -66 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	paramBitmap	Bitmap
    //   0	182	1	paramString	String
    //   10	153	2	localObject1	Object
    //   166	4	2	localOutOfMemoryError	OutOfMemoryError
    //   174	4	2	localException	Exception
    //   7	105	3	localObject2	Object
    //   1	132	4	localObject3	Object
    //   4	68	5	localObject4	Object
    //   19	47	6	localFile1	File
    //   29	17	7	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   11	21	110	java/lang/Exception
    //   24	31	110	java/lang/Exception
    //   34	42	110	java/lang/Exception
    //   45	51	110	java/lang/Exception
    //   54	62	110	java/lang/Exception
    //   65	71	110	java/lang/Exception
    //   74	83	110	java/lang/Exception
    //   11	21	131	java/lang/OutOfMemoryError
    //   24	31	131	java/lang/OutOfMemoryError
    //   34	42	131	java/lang/OutOfMemoryError
    //   45	51	131	java/lang/OutOfMemoryError
    //   54	62	131	java/lang/OutOfMemoryError
    //   65	71	131	java/lang/OutOfMemoryError
    //   74	83	131	java/lang/OutOfMemoryError
    //   11	21	153	finally
    //   24	31	153	finally
    //   34	42	153	finally
    //   45	51	153	finally
    //   54	62	153	finally
    //   65	71	153	finally
    //   74	83	153	finally
    //   115	119	153	finally
    //   121	125	153	finally
    //   137	141	153	finally
    //   143	147	153	finally
    //   87	102	160	finally
    //   87	102	166	java/lang/OutOfMemoryError
    //   87	102	174	java/lang/Exception
  }
  
  /* Error */
  public static File saveBitmap(Context paramContext, Bitmap paramBitmap, String paramString1, String paramString2, Bitmap.CompressFormat paramCompressFormat, String paramString3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aload_2
    //   4: ifnonnull +132 -> 136
    //   7: aload_2
    //   8: astore 8
    //   10: aload_0
    //   11: ifnull +21 -> 32
    //   14: aload_0
    //   15: invokevirtual 805	android/content/Context:getCacheDir	()Ljava/io/File;
    //   18: astore_0
    //   19: aload_2
    //   20: astore 8
    //   22: aload_0
    //   23: ifnull +9 -> 32
    //   26: aload_0
    //   27: invokevirtual 206	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   30: astore 8
    //   32: iconst_0
    //   33: istore 7
    //   35: iconst_0
    //   36: istore 6
    //   38: aload 4
    //   40: getstatic 808	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   43: if_acmpne +124 -> 167
    //   46: new 150	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   53: aload_3
    //   54: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: ldc_w 810
    //   60: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: astore_0
    //   67: new 67	java/io/File
    //   70: dup
    //   71: aload 8
    //   73: aload_0
    //   74: invokespecial 812	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   77: astore_3
    //   78: new 251	java/io/FileOutputStream
    //   81: dup
    //   82: aload_3
    //   83: invokespecial 254	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   86: astore_0
    //   87: aload_0
    //   88: astore_2
    //   89: aload 4
    //   91: getstatic 91	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   94: if_acmpne +18 -> 112
    //   97: aload 5
    //   99: ifnull +13 -> 112
    //   102: aload_0
    //   103: astore_2
    //   104: aload 5
    //   106: invokevirtual 815	java/lang/String:length	()I
    //   109: ifgt +16 -> 125
    //   112: aload_0
    //   113: astore_2
    //   114: aload_1
    //   115: aload 4
    //   117: bipush 99
    //   119: aload_0
    //   120: invokevirtual 97	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   123: istore 6
    //   125: aload_0
    //   126: invokestatic 791	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   129: iload 6
    //   131: ifeq +92 -> 223
    //   134: aload_3
    //   135: areturn
    //   136: new 67	java/io/File
    //   139: dup
    //   140: aload_2
    //   141: invokespecial 70	java/io/File:<init>	(Ljava/lang/String;)V
    //   144: astore_0
    //   145: aload_2
    //   146: astore 8
    //   148: aload_0
    //   149: invokevirtual 818	java/io/File:isDirectory	()Z
    //   152: ifne -120 -> 32
    //   155: aload_2
    //   156: astore 8
    //   158: aload_0
    //   159: invokevirtual 231	java/io/File:mkdirs	()Z
    //   162: ifne -130 -> 32
    //   165: aconst_null
    //   166: areturn
    //   167: new 150	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   174: aload_3
    //   175: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: ldc_w 820
    //   181: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: astore_0
    //   188: goto -121 -> 67
    //   191: astore_1
    //   192: aconst_null
    //   193: astore_0
    //   194: aconst_null
    //   195: astore_3
    //   196: aload_0
    //   197: astore_2
    //   198: aload_1
    //   199: invokestatic 113	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   202: aload_0
    //   203: invokestatic 791	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   206: iload 7
    //   208: istore 6
    //   210: goto -81 -> 129
    //   213: astore_0
    //   214: aload 9
    //   216: astore_1
    //   217: aload_1
    //   218: invokestatic 791	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   221: aload_0
    //   222: athrow
    //   223: aconst_null
    //   224: areturn
    //   225: astore_0
    //   226: aload_2
    //   227: astore_1
    //   228: goto -11 -> 217
    //   231: astore_1
    //   232: aconst_null
    //   233: astore_0
    //   234: goto -38 -> 196
    //   237: astore_1
    //   238: goto -42 -> 196
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	paramContext	Context
    //   0	241	1	paramBitmap	Bitmap
    //   0	241	2	paramString1	String
    //   0	241	3	paramString2	String
    //   0	241	4	paramCompressFormat	Bitmap.CompressFormat
    //   0	241	5	paramString3	String
    //   36	173	6	bool1	boolean
    //   33	174	7	bool2	boolean
    //   8	149	8	str	String
    //   1	214	9	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   38	67	191	java/lang/Exception
    //   67	78	191	java/lang/Exception
    //   167	188	191	java/lang/Exception
    //   38	67	213	finally
    //   67	78	213	finally
    //   78	87	213	finally
    //   167	188	213	finally
    //   89	97	225	finally
    //   104	112	225	finally
    //   114	125	225	finally
    //   198	202	225	finally
    //   78	87	231	java/lang/Exception
    //   89	97	237	java/lang/Exception
    //   104	112	237	java/lang/Exception
    //   114	125	237	java/lang/Exception
  }
  
  /* Error */
  public static BitmapUtils.SAVE_STATUS saveBitmap2PNG(Bitmap paramBitmap, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore_3
    //   8: aload 5
    //   10: astore_2
    //   11: new 67	java/io/File
    //   14: dup
    //   15: aload_1
    //   16: invokespecial 70	java/io/File:<init>	(Ljava/lang/String;)V
    //   19: astore 6
    //   21: aload 5
    //   23: astore_2
    //   24: aload 6
    //   26: invokevirtual 784	java/io/File:getParentFile	()Ljava/io/File;
    //   29: astore 7
    //   31: aload 5
    //   33: astore_2
    //   34: aload 7
    //   36: invokevirtual 74	java/io/File:exists	()Z
    //   39: ifne +12 -> 51
    //   42: aload 5
    //   44: astore_2
    //   45: aload 7
    //   47: invokevirtual 231	java/io/File:mkdirs	()Z
    //   50: pop
    //   51: aload 5
    //   53: astore_2
    //   54: aload 6
    //   56: invokevirtual 74	java/io/File:exists	()Z
    //   59: ifne +12 -> 71
    //   62: aload 5
    //   64: astore_2
    //   65: aload 6
    //   67: invokevirtual 249	java/io/File:createNewFile	()Z
    //   70: pop
    //   71: aload 5
    //   73: astore_2
    //   74: new 251	java/io/FileOutputStream
    //   77: dup
    //   78: aload_1
    //   79: invokespecial 785	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   82: astore_1
    //   83: aload_0
    //   84: ifnull +18 -> 102
    //   87: aload_0
    //   88: getstatic 808	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   91: bipush 99
    //   93: aload_1
    //   94: invokevirtual 97	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   97: pop
    //   98: aload_1
    //   99: invokevirtual 788	java/io/FileOutputStream:flush	()V
    //   102: aload_1
    //   103: invokestatic 791	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   106: getstatic 795	com/tencent/ttpic/baseutils/BitmapUtils$SAVE_STATUS:SAVE_SUCCESS	Lcom/tencent/ttpic/baseutils/BitmapUtils$SAVE_STATUS;
    //   109: areturn
    //   110: astore_1
    //   111: aload_3
    //   112: astore_0
    //   113: aload_0
    //   114: astore_2
    //   115: aload_1
    //   116: invokestatic 113	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   119: aload_0
    //   120: astore_2
    //   121: getstatic 798	com/tencent/ttpic/baseutils/BitmapUtils$SAVE_STATUS:SAVE_FAILED	Lcom/tencent/ttpic/baseutils/BitmapUtils$SAVE_STATUS;
    //   124: astore_1
    //   125: aload_0
    //   126: invokestatic 791	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   129: aload_1
    //   130: areturn
    //   131: astore_1
    //   132: aload 4
    //   134: astore_0
    //   135: aload_0
    //   136: astore_2
    //   137: aload_1
    //   138: invokestatic 113	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   141: aload_0
    //   142: astore_2
    //   143: getstatic 801	com/tencent/ttpic/baseutils/BitmapUtils$SAVE_STATUS:SAVE_OOM	Lcom/tencent/ttpic/baseutils/BitmapUtils$SAVE_STATUS;
    //   146: astore_1
    //   147: aload_0
    //   148: invokestatic 791	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   151: aload_1
    //   152: areturn
    //   153: astore_0
    //   154: aload_2
    //   155: invokestatic 791	com/tencent/ttpic/device/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   158: aload_0
    //   159: athrow
    //   160: astore_0
    //   161: aload_1
    //   162: astore_2
    //   163: goto -9 -> 154
    //   166: astore_2
    //   167: aload_1
    //   168: astore_0
    //   169: aload_2
    //   170: astore_1
    //   171: goto -36 -> 135
    //   174: astore_2
    //   175: aload_1
    //   176: astore_0
    //   177: aload_2
    //   178: astore_1
    //   179: goto -66 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	paramBitmap	Bitmap
    //   0	182	1	paramString	String
    //   10	153	2	localObject1	Object
    //   166	4	2	localOutOfMemoryError	OutOfMemoryError
    //   174	4	2	localException	Exception
    //   7	105	3	localObject2	Object
    //   1	132	4	localObject3	Object
    //   4	68	5	localObject4	Object
    //   19	47	6	localFile1	File
    //   29	17	7	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   11	21	110	java/lang/Exception
    //   24	31	110	java/lang/Exception
    //   34	42	110	java/lang/Exception
    //   45	51	110	java/lang/Exception
    //   54	62	110	java/lang/Exception
    //   65	71	110	java/lang/Exception
    //   74	83	110	java/lang/Exception
    //   11	21	131	java/lang/OutOfMemoryError
    //   24	31	131	java/lang/OutOfMemoryError
    //   34	42	131	java/lang/OutOfMemoryError
    //   45	51	131	java/lang/OutOfMemoryError
    //   54	62	131	java/lang/OutOfMemoryError
    //   65	71	131	java/lang/OutOfMemoryError
    //   74	83	131	java/lang/OutOfMemoryError
    //   11	21	153	finally
    //   24	31	153	finally
    //   34	42	153	finally
    //   45	51	153	finally
    //   54	62	153	finally
    //   65	71	153	finally
    //   74	83	153	finally
    //   115	119	153	finally
    //   121	125	153	finally
    //   137	141	153	finally
    //   143	147	153	finally
    //   87	102	160	finally
    //   87	102	166	java/lang/OutOfMemoryError
    //   87	102	174	java/lang/Exception
  }
  
  public static Bitmap scaleBitmap(Bitmap paramBitmap, float paramFloat, boolean paramBoolean)
  {
    if (isLegal(paramBitmap))
    {
      Object localObject = new Matrix();
      ((Matrix)localObject).postScale(paramFloat, paramFloat);
      try
      {
        localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
        if ((localObject != paramBitmap) && (paramBoolean)) {
          recycle(paramBitmap);
        }
        return localObject;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        return paramBitmap;
      }
    }
    return null;
  }
  
  public static void scaleBitmap(Bitmap paramBitmap, Canvas paramCanvas, int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, Point paramPoint, Paint paramPaint)
  {
    if (!isLegal(paramBitmap)) {}
    Matrix localMatrix;
    do
    {
      return;
      localMatrix = new Matrix();
      int i = (int)(paramInt1 - paramPoint.x * paramDouble2);
      int j = (int)(paramInt2 - paramPoint.y * paramDouble2);
      localMatrix.postScale((float)paramDouble2, (float)paramDouble2);
      if ((i != 0) || (j != 0)) {
        localMatrix.postTranslate(i, j);
      }
      if (paramDouble1 != 0.0D) {
        localMatrix.postRotate((float)paramDouble1, paramInt1, paramInt2);
      }
    } while (paramPaint == null);
    paramCanvas.drawBitmap(paramBitmap, localMatrix, paramPaint);
  }
  
  public static Bitmap scaleBitmapUnderLimit(Bitmap paramBitmap, int paramInt)
  {
    int i = 0;
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
        paramBitmap = paramBitmap;
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
      finally {}
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.BitmapUtils
 * JD-Core Version:    0.7.0.1
 */