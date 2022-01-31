package com.tencent.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.util.e;
import com.tencent.util.g;
import com.tencent.util.i;
import com.tencent.view.raw.FilterRawGet;
import java.io.FileInputStream;

public final class b
{
  public static Context BzH;
  private static FilterRawGet BzI;
  public static boolean BzJ;
  public static boolean BzK;
  public static int BzL;
  public static boolean BzM;
  public static boolean BzN;
  public static boolean ENABLE_DEBUG;
  
  static
  {
    AppMethodBeat.i(86630);
    BzI = new FilterRawGet();
    BzJ = false;
    ENABLE_DEBUG = false;
    BzK = true;
    BzL = -1;
    BzM = false;
    BzN = false;
    AppMethodBeat.o(86630);
  }
  
  /* Error */
  public static Bitmap a(String paramString, Bitmap.Config paramConfig, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc 53
    //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 57	com/tencent/view/b:axl	(Ljava/lang/String;)Ljava/io/InputStream;
    //   9: astore 4
    //   11: aload 4
    //   13: invokestatic 63	com/tencent/util/e:L	(Ljava/io/InputStream;)[B
    //   16: astore_0
    //   17: aload 4
    //   19: invokestatic 69	com/tencent/util/g:closeQuietly	(Ljava/io/InputStream;)V
    //   22: aload_0
    //   23: ifnonnull +10 -> 33
    //   26: ldc 53
    //   28: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aconst_null
    //   32: areturn
    //   33: new 71	android/graphics/BitmapFactory$Options
    //   36: dup
    //   37: invokespecial 72	android/graphics/BitmapFactory$Options:<init>	()V
    //   40: astore 4
    //   42: aload 4
    //   44: aload_1
    //   45: putfield 76	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   48: aload_0
    //   49: iconst_0
    //   50: aload_0
    //   51: arraylength
    //   52: aload 4
    //   54: invokestatic 82	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   57: astore_0
    //   58: iload_2
    //   59: iload_3
    //   60: getstatic 87	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   63: invokestatic 93	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   66: astore_1
    //   67: new 95	android/graphics/Canvas
    //   70: dup
    //   71: aload_1
    //   72: invokespecial 98	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   75: astore 4
    //   77: new 100	android/graphics/Paint
    //   80: dup
    //   81: bipush 6
    //   83: invokespecial 102	android/graphics/Paint:<init>	(I)V
    //   86: astore 5
    //   88: aload 4
    //   90: aload_0
    //   91: new 104	android/graphics/Rect
    //   94: dup
    //   95: iconst_0
    //   96: iconst_0
    //   97: aload_0
    //   98: invokevirtual 108	android/graphics/Bitmap:getWidth	()I
    //   101: aload_0
    //   102: invokevirtual 111	android/graphics/Bitmap:getHeight	()I
    //   105: invokespecial 114	android/graphics/Rect:<init>	(IIII)V
    //   108: new 104	android/graphics/Rect
    //   111: dup
    //   112: iconst_0
    //   113: iconst_0
    //   114: iload_2
    //   115: iload_3
    //   116: invokespecial 114	android/graphics/Rect:<init>	(IIII)V
    //   119: aload 5
    //   121: invokevirtual 118	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   124: aload_0
    //   125: invokevirtual 121	android/graphics/Bitmap:recycle	()V
    //   128: ldc 53
    //   130: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   133: aload_1
    //   134: areturn
    //   135: astore_0
    //   136: aconst_null
    //   137: astore_0
    //   138: goto -116 -> 22
    //   141: astore 4
    //   143: goto -121 -> 22
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	paramString	String
    //   0	146	1	paramConfig	Bitmap.Config
    //   0	146	2	paramInt1	int
    //   0	146	3	paramInt2	int
    //   9	80	4	localObject	Object
    //   141	1	4	localException	Exception
    //   86	34	5	localPaint	android.graphics.Paint
    // Exception table:
    //   from	to	target	type
    //   5	17	135	java/lang/Exception
    //   17	22	141	java/lang/Exception
  }
  
  /* Error */
  public static java.io.InputStream axl(String paramString)
  {
    // Byte code:
    //   0: ldc 124
    //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 34	com/tencent/view/b:BzJ	Z
    //   8: ifeq +39 -> 47
    //   11: getstatic 126	com/tencent/view/b:BzH	Landroid/content/Context;
    //   14: invokevirtual 132	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   17: astore_1
    //   18: aload_1
    //   19: aload_0
    //   20: invokevirtual 137	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   23: astore_0
    //   24: ldc 124
    //   26: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: areturn
    //   31: astore_0
    //   32: ldc 124
    //   34: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: aconst_null
    //   38: areturn
    //   39: astore_0
    //   40: ldc 124
    //   42: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: aload_0
    //   46: athrow
    //   47: getstatic 32	com/tencent/view/b:BzI	Lcom/tencent/view/raw/FilterRawGet;
    //   50: aload_0
    //   51: invokevirtual 140	com/tencent/view/raw/FilterRawGet:getInpuStream	(Ljava/lang/String;)Ljava/io/InputStream;
    //   54: astore_0
    //   55: ldc 124
    //   57: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: aload_0
    //   61: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	paramString	String
    //   17	2	1	localAssetManager	android.content.res.AssetManager
    // Exception table:
    //   from	to	target	type
    //   18	24	31	java/io/IOException
    //   18	24	39	finally
  }
  
  public static Bitmap axm(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(86628);
    label39:
    for (;;)
    {
      try
      {
        FileInputStream localFileInputStream = new FileInputStream(paramString);
        paramString = e.L(localFileInputStream);
        i.a("FilterDefault", "decodeBitmap  getStream", localException1);
      }
      catch (Exception localException1)
      {
        try
        {
          g.closeQuietly(localFileInputStream);
          if (paramString != null) {
            break;
          }
          AppMethodBeat.o(86628);
          return null;
        }
        catch (Exception localException2)
        {
          BitmapFactory.Options localOptions;
          break label39;
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
      AppMethodBeat.o(86628);
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        i.a("FilterDefault", "decodeByteArray", paramString);
        paramString = localObject;
      }
    }
  }
  
  /* Error */
  public static Bitmap wv(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 162
    //   4: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: invokestatic 57	com/tencent/view/b:axl	(Ljava/lang/String;)Ljava/io/InputStream;
    //   11: astore_1
    //   12: aload_1
    //   13: ifnonnull +30 -> 43
    //   16: ldc 152
    //   18: new 164	java/lang/StringBuilder
    //   21: dup
    //   22: ldc 166
    //   24: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   27: aload_0
    //   28: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: ldc 173
    //   33: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 181	com/tencent/util/i:n	(Ljava/lang/Object;Ljava/lang/String;)I
    //   42: pop
    //   43: aload_1
    //   44: invokestatic 63	com/tencent/util/e:L	(Ljava/io/InputStream;)[B
    //   47: astore_0
    //   48: aload_1
    //   49: invokestatic 69	com/tencent/util/g:closeQuietly	(Ljava/io/InputStream;)V
    //   52: aload_0
    //   53: ifnonnull +25 -> 78
    //   56: ldc 162
    //   58: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: aconst_null
    //   62: areturn
    //   63: astore_1
    //   64: aconst_null
    //   65: astore_0
    //   66: ldc 152
    //   68: ldc 154
    //   70: aload_1
    //   71: invokestatic 159	com/tencent/util/i:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   74: pop
    //   75: goto -23 -> 52
    //   78: new 71	android/graphics/BitmapFactory$Options
    //   81: dup
    //   82: invokespecial 72	android/graphics/BitmapFactory$Options:<init>	()V
    //   85: astore_1
    //   86: aload_1
    //   87: getstatic 87	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   90: putfield 76	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   93: aload_0
    //   94: iconst_0
    //   95: aload_0
    //   96: arraylength
    //   97: aload_1
    //   98: invokestatic 82	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   101: astore_0
    //   102: ldc 162
    //   104: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload_0
    //   108: areturn
    //   109: astore_0
    //   110: ldc 152
    //   112: ldc 160
    //   114: aload_0
    //   115: invokestatic 159	com/tencent/util/i:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   118: pop
    //   119: aload_2
    //   120: astore_0
    //   121: goto -19 -> 102
    //   124: astore_1
    //   125: goto -59 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	paramString	String
    //   11	38	1	localInputStream	java.io.InputStream
    //   63	8	1	localException1	Exception
    //   85	13	1	localOptions	BitmapFactory.Options
    //   124	1	1	localException2	Exception
    //   1	119	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	12	63	java/lang/Exception
    //   16	43	63	java/lang/Exception
    //   43	48	63	java/lang/Exception
    //   93	102	109	java/lang/OutOfMemoryError
    //   48	52	124	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.view.b
 * JD-Core Version:    0.7.0.1
 */