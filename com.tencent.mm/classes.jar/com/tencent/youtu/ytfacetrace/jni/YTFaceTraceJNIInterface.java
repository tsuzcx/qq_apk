package com.tencent.youtu.ytfacetrace.jni;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class YTFaceTraceJNIInterface
{
  private long nativePtr;
  
  static
  {
    AppMethodBeat.i(117807);
    nativeInit();
    AppMethodBeat.o(117807);
  }
  
  public YTFaceTraceJNIInterface()
  {
    AppMethodBeat.i(117804);
    NativeConstructor();
    AppMethodBeat.o(117804);
  }
  
  public static native boolean Init(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  private native void NativeConstructor();
  
  private native void NativeDestructor();
  
  public static native void Release();
  
  private static native boolean nativeInit();
  
  public native int DoDetectionInit();
  
  public native YTFaceTraceJNIInterface.FaceStatus DoDetectionProcess(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean);
  
  public native YTFaceTraceJNIInterface.FaceStatus DoDetectionProcessRGBA(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public native YTFaceTraceJNIInterface.FaceStatus DoDetectionProcessWithRotation(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3);
  
  public native void EndLiveCheck();
  
  public native Bitmap GetResultImage();
  
  public native Bitmap GetResultLiveCheckImage();
  
  public native void StartLiveCheck();
  
  public void destroy()
  {
    AppMethodBeat.i(117805);
    NativeDestructor();
    AppMethodBeat.o(117805);
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(117806);
    NativeDestructor();
    AppMethodBeat.o(117806);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.youtu.ytfacetrace.jni.YTFaceTraceJNIInterface
 * JD-Core Version:    0.7.0.1
 */