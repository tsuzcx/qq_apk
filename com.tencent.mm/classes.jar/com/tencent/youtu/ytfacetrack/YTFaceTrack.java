package com.tencent.youtu.ytfacetrack;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytfacetrack.param.YTFaceAlignParam;
import com.tencent.youtu.ytfacetrack.param.YTFaceDetectParam;
import com.tencent.youtu.ytfacetrack.param.YTFaceTrackParam;

public class YTFaceTrack
{
  public static String Version;
  private static YTFaceTrack instance;
  public long handleId;
  private long nativePtr;
  
  static
  {
    AppMethodBeat.i(73435);
    Version = "2.2.1.2";
    instance = null;
    nativeInit();
    AppMethodBeat.o(73435);
  }
  
  public YTFaceTrack()
  {
    AppMethodBeat.i(73430);
    this.handleId = 0L;
    NativeConstructor();
    AppMethodBeat.o(73430);
  }
  
  public static int GlobalInit(String paramString)
  {
    AppMethodBeat.i(73433);
    int i = GlobalInitInner(paramString);
    if (i == 0) {
      instance = new YTFaceTrack();
    }
    AppMethodBeat.o(73433);
    return i;
  }
  
  private static native int GlobalInitInner(String paramString);
  
  private static native int GlobalInitSuccessCount();
  
  public static boolean GlobalRelease()
  {
    AppMethodBeat.i(73434);
    instance.destroy();
    instance = null;
    boolean bool = GlobalReleaseInner();
    AppMethodBeat.o(73434);
    return bool;
  }
  
  private static native boolean GlobalReleaseInner();
  
  private native void NativeConstructor();
  
  private native void NativeDestructor();
  
  public static YTFaceTrack getInstance()
  {
    try
    {
      AppMethodBeat.i(73429);
      if (instance == null) {
        instance = new YTFaceTrack();
      }
      YTFaceTrack localYTFaceTrack = instance;
      AppMethodBeat.o(73429);
      return localYTFaceTrack;
    }
    finally {}
  }
  
  private static native boolean nativeInit();
  
  public native FaceStatus[] DoDetectionProcess(YTFaceTrack.YTImage paramYTImage);
  
  public native FaceStatus[] DoDetectionProcessBitmap(Bitmap paramBitmap, int paramInt, YTFaceTrack.YTImage paramYTImage);
  
  public native FaceStatus[] DoDetectionProcessRGB(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, YTFaceTrack.YTImage paramYTImage);
  
  public native FaceStatus[] DoDetectionProcessRGBA(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, YTFaceTrack.YTImage paramYTImage);
  
  public native FaceStatus[] DoDetectionProcessYUV(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, YTFaceTrack.YTImage paramYTImage);
  
  public native YTFaceAlignParam GetFaceAlignParam();
  
  public native YTFaceDetectParam GetFaceDetectParam();
  
  public native Rect[] GetFaceRect(YTFaceTrack.YTImage paramYTImage);
  
  public native YTFaceTrackParam GetFaceTrackParam();
  
  public native YTFaceTrack.YTImage GetYTImageBitmap(Bitmap paramBitmap, int paramInt);
  
  public native int GetYTImageBitmapReuseData(Bitmap paramBitmap, int paramInt, YTFaceTrack.YTImage paramYTImage);
  
  public native YTFaceTrack.YTImage GetYTImageRGB(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public native YTFaceTrack.YTImage GetYTImageRGBA(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public native int GetYTImageRGBAReuseData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, YTFaceTrack.YTImage paramYTImage);
  
  public native int GetYTImageRGBReuseData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, YTFaceTrack.YTImage paramYTImage);
  
  public native YTFaceTrack.YTImage GetYTImageYUV(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public native int GetYTImageYUVReuseData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, YTFaceTrack.YTImage paramYTImage);
  
  public native void SaveYTImage(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public native boolean SetFaceAlignParam(YTFaceAlignParam paramYTFaceAlignParam);
  
  public native boolean SetFaceDetectParam(YTFaceDetectParam paramYTFaceDetectParam);
  
  public native boolean SetFaceTrackParam(YTFaceTrackParam paramYTFaceTrackParam);
  
  public void destroy()
  {
    AppMethodBeat.i(73431);
    NativeDestructor();
    AppMethodBeat.o(73431);
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(73432);
    NativeDestructor();
    AppMethodBeat.o(73432);
  }
  
  public static class FaceStatus
  {
    public float pitch;
    public float[] pointsVis;
    public float roll;
    public float[] xys;
    public float[] xys5p;
    public float yaw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.youtu.ytfacetrack.YTFaceTrack
 * JD-Core Version:    0.7.0.1
 */