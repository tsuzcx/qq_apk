package org.libpag;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.extra.tools.b;

public class PAGImage
{
  long nativeContext = 0L;
  
  static
  {
    AppMethodBeat.i(195067);
    b.loadLibrary("pag");
    nativeInit();
    AppMethodBeat.o(195067);
  }
  
  PAGImage(long paramLong)
  {
    this.nativeContext = paramLong;
  }
  
  public static PAGImage FromAssets(AssetManager paramAssetManager, String paramString)
  {
    AppMethodBeat.i(195030);
    long l = LoadFromAssets(paramAssetManager, paramString);
    if (l == 0L)
    {
      AppMethodBeat.o(195030);
      return null;
    }
    paramAssetManager = new PAGImage(l);
    AppMethodBeat.o(195030);
    return paramAssetManager;
  }
  
  public static PAGImage FromBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(195018);
    long l = LoadFromBitmap(paramBitmap);
    if (l == 0L)
    {
      AppMethodBeat.o(195018);
      return null;
    }
    paramBitmap = new PAGImage(l);
    AppMethodBeat.o(195018);
    return paramBitmap;
  }
  
  public static PAGImage FromBytes(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(195027);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(195027);
      return null;
    }
    long l = LoadFromBytes(paramArrayOfByte, paramArrayOfByte.length);
    if (l == 0L)
    {
      AppMethodBeat.o(195027);
      return null;
    }
    paramArrayOfByte = new PAGImage(l);
    AppMethodBeat.o(195027);
    return paramArrayOfByte;
  }
  
  public static PAGImage FromPath(String paramString)
  {
    AppMethodBeat.i(195023);
    long l = LoadFromPath(paramString);
    if (l == 0L)
    {
      AppMethodBeat.o(195023);
      return null;
    }
    paramString = new PAGImage(l);
    AppMethodBeat.o(195023);
    return paramString;
  }
  
  public static PAGImage FromTexture(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(195032);
    PAGImage localPAGImage = FromTexture(paramInt1, paramInt2, paramInt3, paramInt4, false);
    AppMethodBeat.o(195032);
    return localPAGImage;
  }
  
  public static PAGImage FromTexture(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    AppMethodBeat.i(195034);
    long l = LoadFromTexture(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean);
    if (l == 0L)
    {
      AppMethodBeat.o(195034);
      return null;
    }
    PAGImage localPAGImage = new PAGImage(l);
    AppMethodBeat.o(195034);
    return localPAGImage;
  }
  
  private static native long LoadFromAssets(AssetManager paramAssetManager, String paramString);
  
  private static native long LoadFromBitmap(Bitmap paramBitmap);
  
  private static native long LoadFromBytes(byte[] paramArrayOfByte, int paramInt);
  
  private static native long LoadFromPath(String paramString);
  
  private static native long LoadFromTexture(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean);
  
  private native void nativeFinalize();
  
  private native void nativeGetMatrix(float[] paramArrayOfFloat);
  
  private static final native void nativeInit();
  
  private final native void nativeRelease();
  
  private native void nativeSetMatrix(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6);
  
  protected void finalize()
  {
    AppMethodBeat.i(195063);
    nativeFinalize();
    AppMethodBeat.o(195063);
  }
  
  public native int height();
  
  public Matrix matrix()
  {
    AppMethodBeat.i(195050);
    float[] arrayOfFloat = new float[9];
    nativeGetMatrix(arrayOfFloat);
    Matrix localMatrix = new Matrix();
    localMatrix.setValues(arrayOfFloat);
    AppMethodBeat.o(195050);
    return localMatrix;
  }
  
  public void release()
  {
    AppMethodBeat.i(195060);
    nativeRelease();
    AppMethodBeat.o(195060);
  }
  
  public native int scaleMode();
  
  public void setMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(195054);
    float[] arrayOfFloat = new float[9];
    paramMatrix.getValues(arrayOfFloat);
    nativeSetMatrix(arrayOfFloat[0], arrayOfFloat[3], arrayOfFloat[1], arrayOfFloat[4], arrayOfFloat[2], arrayOfFloat[5]);
    AppMethodBeat.o(195054);
  }
  
  public native void setScaleMode(int paramInt);
  
  public native int width();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     org.libpag.PAGImage
 * JD-Core Version:    0.7.0.1
 */