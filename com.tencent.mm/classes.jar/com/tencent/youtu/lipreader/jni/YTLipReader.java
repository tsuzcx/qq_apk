package com.tencent.youtu.lipreader.jni;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;

public class YTLipReader
{
  private static final String TAG;
  private long nativePtr;
  
  static
  {
    AppMethodBeat.i(218041);
    TAG = YTLipReader.class.getSimpleName();
    AppMethodBeat.o(218041);
  }
  
  public YTLipReader()
  {
    AppMethodBeat.i(218034);
    NativeConstructor();
    AppMethodBeat.o(218034);
  }
  
  private native void NativeConstructor();
  
  private native void NativeDestructor();
  
  public static byte[] encodeJpeg(Bitmap paramBitmap, int paramInt)
  {
    AppMethodBeat.i(218038);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, paramInt, localByteArrayOutputStream);
    paramBitmap = localByteArrayOutputStream.toByteArray();
    AppMethodBeat.o(218038);
    return paramBitmap;
  }
  
  public static byte[] encodePng(Bitmap paramBitmap, int paramInt)
  {
    AppMethodBeat.i(218040);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.PNG, paramInt, localByteArrayOutputStream);
    paramBitmap = localByteArrayOutputStream.toByteArray();
    AppMethodBeat.o(218040);
    return paramBitmap;
  }
  
  public void destroy()
  {
    AppMethodBeat.i(218042);
    NativeDestructor();
    AppMethodBeat.o(218042);
  }
  
  public native String feature();
  
  public native void feed(float[] paramArrayOfFloat, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3);
  
  protected void finalize()
  {
    AppMethodBeat.i(218043);
    super.finalize();
    NativeDestructor();
    AppMethodBeat.o(218043);
  }
  
  public native String getImageListJsonStr();
  
  public native String getVersion();
  
  public native void init();
  
  public native String lipReadingFeature();
  
  public native void reset();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.youtu.lipreader.jni.YTLipReader
 * JD-Core Version:    0.7.0.1
 */