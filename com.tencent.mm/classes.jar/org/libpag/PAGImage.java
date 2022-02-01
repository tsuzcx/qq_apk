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
    AppMethodBeat.i(187550);
    b.loadLibrary("pag");
    nativeInit();
    AppMethodBeat.o(187550);
  }
  
  PAGImage(long paramLong)
  {
    this.nativeContext = paramLong;
  }
  
  public static PAGImage FromAssets(AssetManager paramAssetManager, String paramString)
  {
    AppMethodBeat.i(187483);
    long l = LoadFromAssets(paramAssetManager, paramString);
    if (l == 0L)
    {
      AppMethodBeat.o(187483);
      return null;
    }
    paramAssetManager = new PAGImage(l);
    AppMethodBeat.o(187483);
    return paramAssetManager;
  }
  
  public static PAGImage FromBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(187461);
    long l = LoadFromBitmap(paramBitmap);
    if (l == 0L)
    {
      AppMethodBeat.o(187461);
      return null;
    }
    paramBitmap = new PAGImage(l);
    AppMethodBeat.o(187461);
    return paramBitmap;
  }
  
  public static PAGImage FromBytes(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(187475);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      AppMethodBeat.o(187475);
      return null;
    }
    long l = LoadFromBytes(paramArrayOfByte, paramArrayOfByte.length);
    if (l == 0L)
    {
      AppMethodBeat.o(187475);
      return null;
    }
    paramArrayOfByte = new PAGImage(l);
    AppMethodBeat.o(187475);
    return paramArrayOfByte;
  }
  
  public static PAGImage FromPath(String paramString)
  {
    AppMethodBeat.i(187468);
    long l = LoadFromPath(paramString);
    if (l == 0L)
    {
      AppMethodBeat.o(187468);
      return null;
    }
    paramString = new PAGImage(l);
    AppMethodBeat.o(187468);
    return paramString;
  }
  
  public static PAGImage FromTexture(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(187490);
    PAGImage localPAGImage = FromTexture(paramInt1, paramInt2, paramInt3, paramInt4, false);
    AppMethodBeat.o(187490);
    return localPAGImage;
  }
  
  public static PAGImage FromTexture(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    AppMethodBeat.i(187496);
    long l = LoadFromTexture(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean);
    if (l == 0L)
    {
      AppMethodBeat.o(187496);
      return null;
    }
    PAGImage localPAGImage = new PAGImage(l);
    AppMethodBeat.o(187496);
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
    AppMethodBeat.i(187584);
    nativeFinalize();
    AppMethodBeat.o(187584);
  }
  
  public native int height();
  
  public Matrix matrix()
  {
    AppMethodBeat.i(187573);
    float[] arrayOfFloat = new float[9];
    nativeGetMatrix(arrayOfFloat);
    Matrix localMatrix = new Matrix();
    localMatrix.setValues(arrayOfFloat);
    AppMethodBeat.o(187573);
    return localMatrix;
  }
  
  public void release()
  {
    AppMethodBeat.i(187581);
    nativeRelease();
    AppMethodBeat.o(187581);
  }
  
  public native int scaleMode();
  
  public void setMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(187576);
    float[] arrayOfFloat = new float[9];
    paramMatrix.getValues(arrayOfFloat);
    nativeSetMatrix(arrayOfFloat[0], arrayOfFloat[3], arrayOfFloat[1], arrayOfFloat[4], arrayOfFloat[2], arrayOfFloat[5]);
    AppMethodBeat.o(187576);
  }
  
  public native void setScaleMode(int paramInt);
  
  public native int width();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.libpag.PAGImage
 * JD-Core Version:    0.7.0.1
 */