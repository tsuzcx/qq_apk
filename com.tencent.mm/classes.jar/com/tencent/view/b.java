package com.tencent.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.util.c;
import com.tencent.util.e;
import com.tencent.util.g;
import com.tencent.view.raw.FilterRawGet;
import java.io.InputStream;

public final class b
{
  public static Context xcZ;
  private static FilterRawGet xda = new FilterRawGet();
  public static boolean xdb = false;
  public static boolean xdc = false;
  public static boolean xdd = true;
  public static int xde = -1;
  public static boolean xdf = false;
  
  /* Error */
  public static Bitmap a(String paramString, Bitmap.Config paramConfig, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 43	com/tencent/view/b:agt	(Ljava/lang/String;)Ljava/io/InputStream;
    //   4: astore 4
    //   6: aload 4
    //   8: invokestatic 49	com/tencent/util/c:decryptFile	(Ljava/io/InputStream;)[B
    //   11: astore_0
    //   12: aload 4
    //   14: invokestatic 55	com/tencent/util/e:closeQuietly	(Ljava/io/InputStream;)V
    //   17: aload_0
    //   18: ifnonnull +5 -> 23
    //   21: aconst_null
    //   22: areturn
    //   23: new 57	android/graphics/BitmapFactory$Options
    //   26: dup
    //   27: invokespecial 58	android/graphics/BitmapFactory$Options:<init>	()V
    //   30: astore 4
    //   32: aload 4
    //   34: aload_1
    //   35: putfield 62	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   38: aload_0
    //   39: iconst_0
    //   40: aload_0
    //   41: arraylength
    //   42: aload 4
    //   44: invokestatic 68	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   47: astore_0
    //   48: iload_2
    //   49: iload_3
    //   50: getstatic 73	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   53: invokestatic 79	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   56: astore_1
    //   57: new 81	android/graphics/Canvas
    //   60: dup
    //   61: aload_1
    //   62: invokespecial 84	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   65: astore 4
    //   67: new 86	android/graphics/Paint
    //   70: dup
    //   71: bipush 6
    //   73: invokespecial 89	android/graphics/Paint:<init>	(I)V
    //   76: astore 5
    //   78: aload 4
    //   80: aload_0
    //   81: new 91	android/graphics/Rect
    //   84: dup
    //   85: iconst_0
    //   86: iconst_0
    //   87: aload_0
    //   88: invokevirtual 95	android/graphics/Bitmap:getWidth	()I
    //   91: aload_0
    //   92: invokevirtual 98	android/graphics/Bitmap:getHeight	()I
    //   95: invokespecial 101	android/graphics/Rect:<init>	(IIII)V
    //   98: new 91	android/graphics/Rect
    //   101: dup
    //   102: iconst_0
    //   103: iconst_0
    //   104: iload_2
    //   105: iload_3
    //   106: invokespecial 101	android/graphics/Rect:<init>	(IIII)V
    //   109: aload 5
    //   111: invokevirtual 105	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   114: aload_0
    //   115: invokevirtual 108	android/graphics/Bitmap:recycle	()V
    //   118: aload_1
    //   119: areturn
    //   120: astore_0
    //   121: aconst_null
    //   122: astore_0
    //   123: goto -106 -> 17
    //   126: astore 4
    //   128: goto -111 -> 17
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	paramString	String
    //   0	131	1	paramConfig	Bitmap.Config
    //   0	131	2	paramInt1	int
    //   0	131	3	paramInt2	int
    //   4	75	4	localObject	Object
    //   126	1	4	localException	Exception
    //   76	34	5	localPaint	android.graphics.Paint
    // Exception table:
    //   from	to	target	type
    //   0	12	120	java/lang/Exception
    //   12	17	126	java/lang/Exception
  }
  
  /* Error */
  public static InputStream agt(String paramString)
  {
    // Byte code:
    //   0: getstatic 26	com/tencent/view/b:xdb	Z
    //   3: ifeq +24 -> 27
    //   6: getstatic 112	com/tencent/view/b:xcZ	Landroid/content/Context;
    //   9: invokevirtual 118	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   12: astore_1
    //   13: aload_1
    //   14: aload_0
    //   15: invokevirtual 123	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   18: astore_0
    //   19: aload_0
    //   20: areturn
    //   21: astore_0
    //   22: aconst_null
    //   23: areturn
    //   24: astore_0
    //   25: aload_0
    //   26: athrow
    //   27: getstatic 24	com/tencent/view/b:xda	Lcom/tencent/view/raw/FilterRawGet;
    //   30: aload_0
    //   31: invokevirtual 126	com/tencent/view/raw/FilterRawGet:getInpuStream	(Ljava/lang/String;)Ljava/io/InputStream;
    //   34: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	paramString	String
    //   12	2	1	localAssetManager	android.content.res.AssetManager
    // Exception table:
    //   from	to	target	type
    //   13	19	21	java/io/IOException
    //   13	19	24	finally
  }
  
  public static Bitmap pe(String paramString)
  {
    label54:
    for (;;)
    {
      try
      {
        InputStream localInputStream = agt(paramString);
        if (localInputStream == null) {
          g.i("FilterDefault", "decodeBitmap  getStream " + paramString + " not exist");
        }
        paramString = c.decryptFile(localInputStream);
        g.a("FilterDefault", "decodeBitmap  getStream", localException1);
      }
      catch (Exception localException1)
      {
        try
        {
          e.closeQuietly(localInputStream);
          if (paramString != null) {
            break;
          }
          return null;
        }
        catch (Exception localException2)
        {
          BitmapFactory.Options localOptions;
          break label54;
        }
        localException1 = localException1;
        paramString = null;
      }
    }
    localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
    try
    {
      paramString = BitmapFactory.decodeByteArray(paramString, 0, paramString.length, localOptions);
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      g.a("FilterDefault", "decodeByteArray", paramString);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.view.b
 * JD-Core Version:    0.7.0.1
 */