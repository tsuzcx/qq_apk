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
    AppMethodBeat.i(192713);
    TAG = YTLipReader.class.getSimpleName();
    AppMethodBeat.o(192713);
  }
  
  public YTLipReader()
  {
    AppMethodBeat.i(192708);
    NativeConstructor();
    AppMethodBeat.o(192708);
  }
  
  private native void NativeConstructor();
  
  private native void NativeDestructor();
  
  public static byte[] encodeJpeg(Bitmap paramBitmap, int paramInt)
  {
    AppMethodBeat.i(192711);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, paramInt, localByteArrayOutputStream);
    paramBitmap = localByteArrayOutputStream.toByteArray();
    AppMethodBeat.o(192711);
    return paramBitmap;
  }
  
  public static byte[] encodePng(Bitmap paramBitmap, int paramInt)
  {
    AppMethodBeat.i(192712);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.PNG, paramInt, localByteArrayOutputStream);
    paramBitmap = localByteArrayOutputStream.toByteArray();
    AppMethodBeat.o(192712);
    return paramBitmap;
  }
  
  public void destroy()
  {
    AppMethodBeat.i(192709);
    NativeDestructor();
    AppMethodBeat.o(192709);
  }
  
  public native String feature();
  
  public native void feed(float[] paramArrayOfFloat, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3);
  
  protected void finalize()
  {
    AppMethodBeat.i(192710);
    super.finalize();
    NativeDestructor();
    AppMethodBeat.o(192710);
  }
  
  public native String getImageListJsonStr();
  
  public native String getVersion();
  
  public native void init();
  
  public native String lipReadingFeature();
  
  public native void reset();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.youtu.lipreader.jni.YTLipReader
 * JD-Core Version:    0.7.0.1
 */