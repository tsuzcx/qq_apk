package com.tencent.youtu.ytfacetrace.jni;

import android.graphics.Bitmap;

public class YTFaceTraceJNIInterface
{
  private long nativePtr;
  
  static
  {
    nativeInit();
  }
  
  public YTFaceTraceJNIInterface()
  {
    NativeConstructor();
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
    NativeDestructor();
  }
  
  protected void finalize()
  {
    NativeDestructor();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.youtu.ytfacetrace.jni.YTFaceTraceJNIInterface
 * JD-Core Version:    0.7.0.1
 */