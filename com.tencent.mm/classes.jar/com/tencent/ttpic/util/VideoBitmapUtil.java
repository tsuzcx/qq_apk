package com.tencent.ttpic.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.Point;
import android.media.ExifInterface;
import android.text.TextUtils;
import com.tencent.ttpic.baseutils.LogUtils;
import com.tencent.util.c;
import com.tencent.util.e;
import java.io.FileInputStream;

public class VideoBitmapUtil
{
  private static final int SAVE_FAILED = -1;
  private static final int SAVE_OOM = -2;
  private static final int SAVE_SUCCESS = 0;
  private static final String TAG = VideoBitmapUtil.class.getSimpleName();
  
  public static int calculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int k = paramOptions.outHeight;
    int m = paramOptions.outWidth;
    int i = 1;
    int j;
    if ((paramInt2 <= 0) || (k <= paramInt2))
    {
      j = i;
      if (paramInt1 > 0)
      {
        j = i;
        if (m <= paramInt1) {}
      }
    }
    else
    {
      i = Math.round(k / paramInt2);
      j = Math.round(m / paramInt1);
      if (i < j) {}
      for (;;)
      {
        float f1 = m * k;
        float f2 = paramInt1 * paramInt2 * 2;
        for (;;)
        {
          j = i;
          if (f1 / (i * i) <= f2) {
            break;
          }
          i += 1;
        }
        i = j;
      }
    }
    return j;
  }
  
  public static Bitmap decodeSampleBitmap(Context paramContext, String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      if (paramString.startsWith("assets://")) {
        return decodeSampleBitmapFromAssets(paramContext, VideoUtil.getRealPath(paramString), paramInt);
      }
    } while (!VideoFileUtil.exists(paramString));
    return decodeSampledBitmapFromFile(paramString, paramInt);
  }
  
  public static Bitmap decodeSampleBitmap(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      if (paramString.startsWith("assets://")) {
        return decodeSampleBitmapFromAssets(paramContext, VideoUtil.getRealPath(paramString), paramInt1, paramInt2);
      }
    } while (!VideoFileUtil.exists(paramString));
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
    //   6: invokestatic 51	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifeq +8 -> 17
    //   12: aload 4
    //   14: astore_0
    //   15: aload_0
    //   16: areturn
    //   17: aload_0
    //   18: invokevirtual 93	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   21: astore_0
    //   22: aload_0
    //   23: aload_1
    //   24: invokevirtual 99	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   27: astore 5
    //   29: new 31	android/graphics/BitmapFactory$Options
    //   32: dup
    //   33: invokespecial 100	android/graphics/BitmapFactory$Options:<init>	()V
    //   36: astore_0
    //   37: aload_0
    //   38: iconst_1
    //   39: putfield 104	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   42: aload 5
    //   44: aconst_null
    //   45: aload_0
    //   46: invokestatic 110	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   49: pop
    //   50: aload_0
    //   51: sipush 540
    //   54: sipush 540
    //   57: invokestatic 112	com/tencent/ttpic/util/VideoBitmapUtil:calculateInSampleSize	(Landroid/graphics/BitmapFactory$Options;II)I
    //   60: iload_2
    //   61: invokestatic 116	java/lang/Math:min	(II)I
    //   64: istore_2
    //   65: aload_0
    //   66: iconst_0
    //   67: putfield 104	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   70: aload_0
    //   71: iload_2
    //   72: putfield 119	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   75: aload_0
    //   76: iconst_1
    //   77: putfield 122	android/graphics/BitmapFactory$Options:inPreferQualityOverSpeed	Z
    //   80: aload 5
    //   82: invokevirtual 127	java/io/InputStream:reset	()V
    //   85: aload 5
    //   87: aconst_null
    //   88: aload_0
    //   89: invokestatic 110	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   92: astore_1
    //   93: aload_1
    //   94: astore_0
    //   95: aload 5
    //   97: ifnull -82 -> 15
    //   100: aload 5
    //   102: invokevirtual 130	java/io/InputStream:close	()V
    //   105: aload_1
    //   106: areturn
    //   107: astore_0
    //   108: aload_1
    //   109: areturn
    //   110: astore_0
    //   111: aload_0
    //   112: invokevirtual 133	java/io/IOException:toString	()Ljava/lang/String;
    //   115: pop
    //   116: aconst_null
    //   117: areturn
    //   118: astore_0
    //   119: aload_0
    //   120: invokevirtual 133	java/io/IOException:toString	()Ljava/lang/String;
    //   123: pop
    //   124: aload 4
    //   126: astore_0
    //   127: aload 5
    //   129: ifnull -114 -> 15
    //   132: aload 5
    //   134: invokevirtual 130	java/io/InputStream:close	()V
    //   137: aconst_null
    //   138: areturn
    //   139: astore_0
    //   140: aconst_null
    //   141: areturn
    //   142: astore_1
    //   143: aload_0
    //   144: aload_0
    //   145: getfield 119	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   148: iconst_1
    //   149: ishl
    //   150: putfield 119	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   153: aload 5
    //   155: invokevirtual 127	java/io/InputStream:reset	()V
    //   158: aload 5
    //   160: aconst_null
    //   161: aload_0
    //   162: invokestatic 110	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   165: astore_1
    //   166: aload_1
    //   167: astore_0
    //   168: aload 5
    //   170: ifnull -155 -> 15
    //   173: aload 5
    //   175: invokevirtual 130	java/io/InputStream:close	()V
    //   178: aload_1
    //   179: areturn
    //   180: astore_0
    //   181: aload_1
    //   182: areturn
    //   183: astore_0
    //   184: aload_0
    //   185: invokevirtual 136	java/lang/Throwable:toString	()Ljava/lang/String;
    //   188: pop
    //   189: aload_3
    //   190: astore_1
    //   191: goto -25 -> 166
    //   194: astore_0
    //   195: aload 5
    //   197: ifnull +8 -> 205
    //   200: aload 5
    //   202: invokevirtual 130	java/io/InputStream:close	()V
    //   205: aload_0
    //   206: athrow
    //   207: astore_1
    //   208: goto -3 -> 205
    //   211: astore_0
    //   212: goto -28 -> 184
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	paramContext	Context
    //   0	215	1	paramString	String
    //   0	215	2	paramInt	int
    //   1	189	3	localObject1	Object
    //   3	122	4	localObject2	Object
    //   27	174	5	localInputStream	java.io.InputStream
    // Exception table:
    //   from	to	target	type
    //   100	105	107	java/io/IOException
    //   22	29	110	java/io/IOException
    //   80	93	118	java/io/IOException
    //   132	137	139	java/io/IOException
    //   80	93	142	java/lang/OutOfMemoryError
    //   173	178	180	java/io/IOException
    //   153	166	183	java/lang/OutOfMemoryError
    //   80	93	194	finally
    //   119	124	194	finally
    //   143	153	194	finally
    //   153	166	194	finally
    //   184	189	194	finally
    //   200	205	207	java/io/IOException
    //   153	166	211	java/io/IOException
  }
  
  /* Error */
  public static Bitmap decodeSampleBitmapFromAssets(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_1
    //   4: invokestatic 51	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifeq +5 -> 12
    //   10: aconst_null
    //   11: areturn
    //   12: aload_0
    //   13: invokevirtual 93	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   16: astore 5
    //   18: aload 5
    //   20: aload_1
    //   21: invokevirtual 99	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   24: astore_0
    //   25: aload_0
    //   26: astore_1
    //   27: new 31	android/graphics/BitmapFactory$Options
    //   30: dup
    //   31: invokespecial 100	android/graphics/BitmapFactory$Options:<init>	()V
    //   34: astore 5
    //   36: aload 5
    //   38: iconst_1
    //   39: putfield 104	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   42: aload_1
    //   43: aconst_null
    //   44: aload 5
    //   46: invokestatic 110	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   49: pop
    //   50: aload 5
    //   52: iconst_0
    //   53: putfield 104	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   56: aload 5
    //   58: aload 5
    //   60: iload_2
    //   61: iload_3
    //   62: invokestatic 112	com/tencent/ttpic/util/VideoBitmapUtil:calculateInSampleSize	(Landroid/graphics/BitmapFactory$Options;II)I
    //   65: putfield 119	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   68: aload 5
    //   70: iconst_1
    //   71: putfield 122	android/graphics/BitmapFactory$Options:inPreferQualityOverSpeed	Z
    //   74: aload_1
    //   75: invokevirtual 127	java/io/InputStream:reset	()V
    //   78: aload_1
    //   79: aconst_null
    //   80: aload 5
    //   82: invokestatic 110	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   85: astore_0
    //   86: aload_1
    //   87: ifnull +7 -> 94
    //   90: aload_1
    //   91: invokevirtual 130	java/io/InputStream:close	()V
    //   94: aload_0
    //   95: areturn
    //   96: astore_0
    //   97: aload 5
    //   99: new 138	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   106: aload_1
    //   107: iconst_0
    //   108: aload_1
    //   109: bipush 46
    //   111: invokevirtual 143	java/lang/String:lastIndexOf	(I)I
    //   114: iconst_1
    //   115: iadd
    //   116: invokevirtual 147	java/lang/String:substring	(II)Ljava/lang/String;
    //   119: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: ldc 153
    //   124: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokevirtual 99	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   133: astore_1
    //   134: goto -107 -> 27
    //   137: astore_0
    //   138: aload_0
    //   139: invokevirtual 133	java/io/IOException:toString	()Ljava/lang/String;
    //   142: pop
    //   143: aconst_null
    //   144: areturn
    //   145: astore_1
    //   146: goto -52 -> 94
    //   149: astore_0
    //   150: aload_0
    //   151: invokevirtual 133	java/io/IOException:toString	()Ljava/lang/String;
    //   154: pop
    //   155: aload_1
    //   156: ifnull +7 -> 163
    //   159: aload_1
    //   160: invokevirtual 130	java/io/InputStream:close	()V
    //   163: aconst_null
    //   164: astore_0
    //   165: goto -71 -> 94
    //   168: astore_0
    //   169: aconst_null
    //   170: astore_0
    //   171: goto -77 -> 94
    //   174: astore_0
    //   175: aload 5
    //   177: aload 5
    //   179: getfield 119	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   182: iconst_1
    //   183: ishl
    //   184: putfield 119	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   187: aload_1
    //   188: invokevirtual 127	java/io/InputStream:reset	()V
    //   191: aload_1
    //   192: aconst_null
    //   193: aload 5
    //   195: invokestatic 110	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   198: astore_0
    //   199: aload_1
    //   200: ifnull +7 -> 207
    //   203: aload_1
    //   204: invokevirtual 130	java/io/InputStream:close	()V
    //   207: goto -113 -> 94
    //   210: astore_0
    //   211: aload_0
    //   212: invokevirtual 136	java/lang/Throwable:toString	()Ljava/lang/String;
    //   215: pop
    //   216: aload 4
    //   218: astore_0
    //   219: goto -20 -> 199
    //   222: astore_0
    //   223: aload_1
    //   224: ifnull +7 -> 231
    //   227: aload_1
    //   228: invokevirtual 130	java/io/InputStream:close	()V
    //   231: aload_0
    //   232: athrow
    //   233: astore_1
    //   234: goto -140 -> 94
    //   237: astore_1
    //   238: goto -7 -> 231
    //   241: astore_0
    //   242: goto -31 -> 211
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	paramContext	Context
    //   0	245	1	paramString	String
    //   0	245	2	paramInt1	int
    //   0	245	3	paramInt2	int
    //   1	216	4	localObject1	Object
    //   16	178	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   18	25	96	java/io/IOException
    //   97	134	137	java/io/IOException
    //   90	94	145	java/io/IOException
    //   74	86	149	java/io/IOException
    //   159	163	168	java/io/IOException
    //   74	86	174	java/lang/OutOfMemoryError
    //   187	199	210	java/lang/OutOfMemoryError
    //   74	86	222	finally
    //   150	155	222	finally
    //   175	187	222	finally
    //   187	199	222	finally
    //   211	216	222	finally
    //   203	207	233	java/io/IOException
    //   227	231	237	java/io/IOException
    //   187	199	241	java/io/IOException
  }
  
  public static Bitmap decodeSampledBitmapFromFile(String paramString, int paramInt)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    localOptions.inSampleSize = Math.min(calculateInSampleSize(localOptions, 540, 540), paramInt);
    localOptions.inJustDecodeBounds = false;
    localOptions.inPreferQualityOverSpeed = true;
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
    if (!VideoFileUtil.exists(paramString)) {
      return null;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    localOptions.inSampleSize = calculateInSampleSize(localOptions, paramInt1, paramInt2);
    localOptions.inJustDecodeBounds = false;
    localOptions.inPreferQualityOverSpeed = true;
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
  
  public static Bitmap decodeSampledBitmapFromResource(Resources paramResources, int paramInt1, int paramInt2, int paramInt3)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeResource(paramResources, paramInt1, localOptions);
    localOptions.inSampleSize = calculateInSampleSize(localOptions, paramInt2, paramInt3);
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
  
  public static Bitmap getBitmapFromEncryptedFile(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      try
      {
        if (paramString.startsWith("assets://"))
        {
          paramString = VideoGlobalContext.getContext().getAssets().open(VideoUtil.getRealPath(paramString));
          label32:
          arrayOfByte = c.decryptFile(paramString);
        }
      }
      catch (Exception paramString)
      {
        try
        {
          byte[] arrayOfByte;
          e.closeQuietly(paramString);
          label41:
          while (arrayOfByte != null)
          {
            paramString = new BitmapFactory.Options();
            paramString.inPreferredConfig = Bitmap.Config.ARGB_8888;
            try
            {
              paramString = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, paramString);
              return paramString;
            }
            catch (OutOfMemoryError paramString)
            {
              return null;
            }
            paramString = new FileInputStream(paramString);
            break label32;
            paramString = paramString;
            arrayOfByte = null;
          }
        }
        catch (Exception paramString)
        {
          break label41;
        }
      }
    }
  }
  
  public static Point getBitmapSize(Context paramContext, String paramString)
  {
    if (paramString.startsWith("assets://")) {
      return getBitmapSizeFromAssets(paramContext, VideoUtil.getRealPath(paramString));
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
    //   4: new 222	android/graphics/Point
    //   7: dup
    //   8: iconst_0
    //   9: iconst_0
    //   10: invokespecial 225	android/graphics/Point:<init>	(II)V
    //   13: astore 4
    //   15: aload_1
    //   16: invokestatic 51	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   19: ifeq +6 -> 25
    //   22: aload 4
    //   24: areturn
    //   25: aload_0
    //   26: invokevirtual 93	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   29: astore 5
    //   31: aload_3
    //   32: astore_0
    //   33: aload 5
    //   35: aload_1
    //   36: invokevirtual 99	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   39: astore_1
    //   40: aload_1
    //   41: astore_0
    //   42: aload_1
    //   43: astore_2
    //   44: new 31	android/graphics/BitmapFactory$Options
    //   47: dup
    //   48: invokespecial 100	android/graphics/BitmapFactory$Options:<init>	()V
    //   51: astore_3
    //   52: aload_1
    //   53: astore_0
    //   54: aload_1
    //   55: astore_2
    //   56: aload_3
    //   57: iconst_1
    //   58: putfield 104	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   61: aload_1
    //   62: astore_0
    //   63: aload_1
    //   64: astore_2
    //   65: aload_1
    //   66: aconst_null
    //   67: aload_3
    //   68: invokestatic 110	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   71: pop
    //   72: aload_1
    //   73: astore_0
    //   74: aload_1
    //   75: astore_2
    //   76: new 222	android/graphics/Point
    //   79: dup
    //   80: aload_3
    //   81: getfield 37	android/graphics/BitmapFactory$Options:outWidth	I
    //   84: aload_3
    //   85: getfield 34	android/graphics/BitmapFactory$Options:outHeight	I
    //   88: invokespecial 225	android/graphics/Point:<init>	(II)V
    //   91: astore_3
    //   92: aload_1
    //   93: ifnull +7 -> 100
    //   96: aload_1
    //   97: invokevirtual 130	java/io/InputStream:close	()V
    //   100: aload_3
    //   101: areturn
    //   102: astore_1
    //   103: aload_0
    //   104: astore_2
    //   105: aload_1
    //   106: invokevirtual 133	java/io/IOException:toString	()Ljava/lang/String;
    //   109: pop
    //   110: aload_0
    //   111: ifnull -89 -> 22
    //   114: aload_0
    //   115: invokevirtual 130	java/io/InputStream:close	()V
    //   118: aload 4
    //   120: areturn
    //   121: astore_0
    //   122: aload 4
    //   124: areturn
    //   125: astore_0
    //   126: aload_2
    //   127: ifnull +7 -> 134
    //   130: aload_2
    //   131: invokevirtual 130	java/io/InputStream:close	()V
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
  
  public static int getDegree(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    try
    {
      int i = getDegreeFromOrientation(new ExifInterface(paramString).getAttributeInt("Orientation", 0));
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  public static int getDegreeFromOrientation(int paramInt)
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
  
  public static boolean isKtxPath(String paramString)
  {
    return paramString.endsWith(".ktx");
  }
  
  public static boolean isLegal(Bitmap paramBitmap)
  {
    return (paramBitmap != null) && (!paramBitmap.isRecycled());
  }
  
  public static boolean isPngPath(String paramString)
  {
    return paramString.endsWith(".png");
  }
  
  public static Bitmap rotate(Bitmap paramBitmap, int paramInt)
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
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      new StringBuilder("OutOfMemoryError. ").append(localOutOfMemoryError);
    }
    return paramBitmap;
  }
  
  /* Error */
  public static int saveBitmap2PNG(Bitmap paramBitmap, String paramString)
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
    //   11: new 289	java/io/File
    //   14: dup
    //   15: aload_1
    //   16: invokespecial 290	java/io/File:<init>	(Ljava/lang/String;)V
    //   19: astore 6
    //   21: aload 5
    //   23: astore_2
    //   24: aload 6
    //   26: invokevirtual 294	java/io/File:getParentFile	()Ljava/io/File;
    //   29: astore 7
    //   31: aload 5
    //   33: astore_2
    //   34: aload 7
    //   36: invokevirtual 296	java/io/File:exists	()Z
    //   39: ifne +12 -> 51
    //   42: aload 5
    //   44: astore_2
    //   45: aload 7
    //   47: invokevirtual 299	java/io/File:mkdirs	()Z
    //   50: pop
    //   51: aload 5
    //   53: astore_2
    //   54: aload 6
    //   56: invokevirtual 296	java/io/File:exists	()Z
    //   59: ifne +12 -> 71
    //   62: aload 5
    //   64: astore_2
    //   65: aload 6
    //   67: invokevirtual 302	java/io/File:createNewFile	()Z
    //   70: pop
    //   71: aload 5
    //   73: astore_2
    //   74: new 304	java/io/FileOutputStream
    //   77: dup
    //   78: aload_1
    //   79: invokespecial 305	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   82: astore_1
    //   83: aload_0
    //   84: ifnull +18 -> 102
    //   87: aload_0
    //   88: getstatic 311	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   91: bipush 95
    //   93: aload_1
    //   94: invokevirtual 315	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   97: pop
    //   98: aload_1
    //   99: invokevirtual 318	java/io/FileOutputStream:flush	()V
    //   102: aload_1
    //   103: invokestatic 321	com/tencent/util/e:closeQuietly	(Ljava/io/OutputStream;)V
    //   106: iconst_0
    //   107: ireturn
    //   108: astore_1
    //   109: aload_3
    //   110: astore_0
    //   111: aload_0
    //   112: astore_2
    //   113: aload_1
    //   114: invokevirtual 322	java/lang/Exception:toString	()Ljava/lang/String;
    //   117: pop
    //   118: aload_0
    //   119: invokestatic 321	com/tencent/util/e:closeQuietly	(Ljava/io/OutputStream;)V
    //   122: iconst_m1
    //   123: ireturn
    //   124: astore_1
    //   125: aload 4
    //   127: astore_0
    //   128: aload_0
    //   129: astore_2
    //   130: aload_1
    //   131: invokevirtual 159	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   134: pop
    //   135: aload_0
    //   136: invokestatic 321	com/tencent/util/e:closeQuietly	(Ljava/io/OutputStream;)V
    //   139: bipush 254
    //   141: ireturn
    //   142: astore_0
    //   143: aload_2
    //   144: invokestatic 321	com/tencent/util/e:closeQuietly	(Ljava/io/OutputStream;)V
    //   147: aload_0
    //   148: athrow
    //   149: astore_0
    //   150: aload_1
    //   151: astore_2
    //   152: goto -9 -> 143
    //   155: astore_2
    //   156: aload_1
    //   157: astore_0
    //   158: aload_2
    //   159: astore_1
    //   160: goto -32 -> 128
    //   163: astore_2
    //   164: aload_1
    //   165: astore_0
    //   166: aload_2
    //   167: astore_1
    //   168: goto -57 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	paramBitmap	Bitmap
    //   0	171	1	paramString	String
    //   10	142	2	localObject1	Object
    //   155	4	2	localOutOfMemoryError	OutOfMemoryError
    //   163	4	2	localException	Exception
    //   7	103	3	localObject2	Object
    //   1	125	4	localObject3	Object
    //   4	68	5	localObject4	Object
    //   19	47	6	localFile1	java.io.File
    //   29	17	7	localFile2	java.io.File
    // Exception table:
    //   from	to	target	type
    //   11	21	108	java/lang/Exception
    //   24	31	108	java/lang/Exception
    //   34	42	108	java/lang/Exception
    //   45	51	108	java/lang/Exception
    //   54	62	108	java/lang/Exception
    //   65	71	108	java/lang/Exception
    //   74	83	108	java/lang/Exception
    //   11	21	124	java/lang/OutOfMemoryError
    //   24	31	124	java/lang/OutOfMemoryError
    //   34	42	124	java/lang/OutOfMemoryError
    //   45	51	124	java/lang/OutOfMemoryError
    //   54	62	124	java/lang/OutOfMemoryError
    //   65	71	124	java/lang/OutOfMemoryError
    //   74	83	124	java/lang/OutOfMemoryError
    //   11	21	142	finally
    //   24	31	142	finally
    //   34	42	142	finally
    //   45	51	142	finally
    //   54	62	142	finally
    //   65	71	142	finally
    //   74	83	142	finally
    //   113	118	142	finally
    //   130	135	142	finally
    //   87	102	149	finally
    //   87	102	155	java/lang/OutOfMemoryError
    //   87	102	163	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoBitmapUtil
 * JD-Core Version:    0.7.0.1
 */