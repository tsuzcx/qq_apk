package org.libpag;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import org.extra.tools.b;

public class PAGImage
{
  private static final int AlphaType_Opaque = 1;
  private static final int AlphaType_Premul = 2;
  private static final int AlphaType_Unpremul = 3;
  private static final int ColorType_ARGB_4444 = 3;
  private static final int ColorType_Alpha_8 = 1;
  private static final int ColorType_BGRA_8888 = 5;
  private static final int ColorType_Gray_8 = 7;
  private static final int ColorType_Index_8 = 6;
  private static final int ColorType_RGBA_8888 = 4;
  private static final int ColorType_RGBA_F16 = 8;
  private static final int ColorType_RGB_565 = 2;
  long nativeContext = 0L;
  private byte[] pixels = null;
  
  static
  {
    AppMethodBeat.i(220166);
    b.loadLibrary("libpag");
    nativeInit();
    PAGFont.loadSystemFonts();
    AppMethodBeat.o(220166);
  }
  
  PAGImage(long paramLong)
  {
    this.nativeContext = paramLong;
  }
  
  /* Error */
  public static PAGImage FromAssets(AssetManager paramAssetManager, String paramString)
  {
    // Byte code:
    //   0: ldc 72
    //   2: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnull +10 -> 16
    //   9: aload_1
    //   10: invokestatic 78	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifeq +10 -> 23
    //   16: ldc 72
    //   18: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aconst_null
    //   22: areturn
    //   23: aload_0
    //   24: aload_1
    //   25: invokevirtual 84	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   28: astore_1
    //   29: aload_1
    //   30: invokestatic 90	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   33: astore_0
    //   34: aload_1
    //   35: ifnull +7 -> 42
    //   38: aload_1
    //   39: invokevirtual 95	java/io/InputStream:close	()V
    //   42: aload_0
    //   43: ifnonnull +18 -> 61
    //   46: ldc 72
    //   48: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: aconst_null
    //   52: areturn
    //   53: astore_0
    //   54: ldc 72
    //   56: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: aconst_null
    //   60: areturn
    //   61: aload_0
    //   62: invokestatic 99	org/libpag/PAGImage:FromBitmap	(Landroid/graphics/Bitmap;)Lorg/libpag/PAGImage;
    //   65: astore_0
    //   66: ldc 72
    //   68: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: aload_0
    //   72: areturn
    //   73: astore_1
    //   74: goto -32 -> 42
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	paramAssetManager	AssetManager
    //   0	77	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   23	29	53	java/io/IOException
    //   38	42	73	java/io/IOException
  }
  
  public static PAGImage FromBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(220156);
    if ((Build.VERSION.SDK_INT >= 26) && (paramBitmap.getConfig() == Bitmap.Config.HARDWARE))
    {
      AppMethodBeat.o(220156);
      return null;
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramBitmap.getHeight() * paramBitmap.getRowBytes());
    paramBitmap.copyPixelsToBuffer(localByteBuffer);
    Bitmap.Config localConfig2 = paramBitmap.getConfig();
    Bitmap.Config localConfig1 = localConfig2;
    if (localConfig2 == null) {
      localConfig1 = Bitmap.Config.ARGB_8888;
    }
    int i;
    int k;
    int j;
    if (paramBitmap.isPremultiplied())
    {
      i = 2;
      switch (1.$SwitchMap$android$graphics$Bitmap$Config[localConfig1.ordinal()])
      {
      default: 
        k = 4;
        j = i;
        i = k;
      }
    }
    long l;
    for (;;)
    {
      l = LoadFromPixels(localByteBuffer.array(), paramBitmap.getWidth(), paramBitmap.getHeight(), paramBitmap.getRowBytes(), i, j);
      if (l != 0L) {
        break label200;
      }
      AppMethodBeat.o(220156);
      return null;
      i = 3;
      break;
      j = i;
      i = 1;
      continue;
      j = 1;
      i = 2;
      continue;
      j = i;
      i = 3;
      continue;
      k = 8;
      j = i;
      i = k;
    }
    label200:
    paramBitmap = new PAGImage(l);
    paramBitmap.pixels = localByteBuffer.array();
    AppMethodBeat.o(220156);
    return paramBitmap;
  }
  
  public static PAGImage FromBytes(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(220158);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(220158);
      return null;
    }
    paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(220158);
      return null;
    }
    paramArrayOfByte = FromBitmap(paramArrayOfByte);
    AppMethodBeat.o(220158);
    return paramArrayOfByte;
  }
  
  public static PAGImage FromPath(String paramString)
  {
    AppMethodBeat.i(220157);
    paramString = BitmapFactory.decodeFile(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(220157);
      return null;
    }
    paramString = FromBitmap(paramString);
    AppMethodBeat.o(220157);
    return paramString;
  }
  
  public static PAGImage FromTexture(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(220160);
    PAGImage localPAGImage = FromTexture(paramInt1, paramInt2, paramInt3, paramInt4, false);
    AppMethodBeat.o(220160);
    return localPAGImage;
  }
  
  public static PAGImage FromTexture(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    AppMethodBeat.i(220161);
    long l = LoadFromTexture(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean);
    if (l == 0L)
    {
      AppMethodBeat.o(220161);
      return null;
    }
    PAGImage localPAGImage = new PAGImage(l);
    AppMethodBeat.o(220161);
    return localPAGImage;
  }
  
  private static native long LoadFromAssets(AssetManager paramAssetManager, String paramString);
  
  private static native long LoadFromBytes(byte[] paramArrayOfByte, int paramInt);
  
  private static native long LoadFromPath(String paramString);
  
  private static native long LoadFromPixels(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  private static native long LoadFromTexture(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean);
  
  private native void nativeFinalize();
  
  private native void nativeGetMatrix(float[] paramArrayOfFloat);
  
  private static final native void nativeInit();
  
  private final native void nativeRelease();
  
  private native void nativeSetMatrix(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6);
  
  protected void finalize()
  {
    AppMethodBeat.i(220165);
    nativeFinalize();
    AppMethodBeat.o(220165);
  }
  
  public native int height();
  
  public Matrix matrix()
  {
    AppMethodBeat.i(220162);
    float[] arrayOfFloat = new float[9];
    nativeGetMatrix(arrayOfFloat);
    Matrix localMatrix = new Matrix();
    localMatrix.setValues(arrayOfFloat);
    AppMethodBeat.o(220162);
    return localMatrix;
  }
  
  public void release()
  {
    AppMethodBeat.i(220164);
    nativeRelease();
    AppMethodBeat.o(220164);
  }
  
  public native int scaleMode();
  
  public void setMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(220163);
    float[] arrayOfFloat = new float[9];
    paramMatrix.getValues(arrayOfFloat);
    nativeSetMatrix(arrayOfFloat[0], arrayOfFloat[3], arrayOfFloat[1], arrayOfFloat[4], arrayOfFloat[2], arrayOfFloat[5]);
    AppMethodBeat.o(220163);
  }
  
  public native void setScaleMode(int paramInt);
  
  public native int width();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.libpag.PAGImage
 * JD-Core Version:    0.7.0.1
 */