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
  private static IYtLoggerListener loggerListener;
  public long handleId;
  private long nativePtr;
  
  static
  {
    AppMethodBeat.i(73435);
    Version = "2.3.3.6";
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
    if (instance != null)
    {
      instance.NativeDestructor();
      instance = null;
    }
    boolean bool = GlobalReleaseInner();
    AppMethodBeat.o(73434);
    return bool;
  }
  
  private static native boolean GlobalReleaseInner();
  
  public static boolean IsInstanceExist()
  {
    return instance != null;
  }
  
  private native void NativeConstructor();
  
  private native void NativeDestructor();
  
  public static YTFaceTrack getInstance()
  {
    try
    {
      AppMethodBeat.i(73429);
      YTFaceTrack localYTFaceTrack = instance;
      AppMethodBeat.o(73429);
      return localYTFaceTrack;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static native boolean nativeInit();
  
  public static void nativeLog(int paramInt, String paramString)
  {
    AppMethodBeat.i(192714);
    if (loggerListener != null) {
      loggerListener.log("[YTFaceTrack.nativeLog]", paramString);
    }
    AppMethodBeat.o(192714);
  }
  
  public static void setLoggerListener(IYtLoggerListener paramIYtLoggerListener)
  {
    loggerListener = paramIYtLoggerListener;
  }
  
  public native FaceStatus[] DoDetectionProcess(YTImage paramYTImage);
  
  public native FaceStatus[] DoDetectionProcessBitmap(Bitmap paramBitmap, int paramInt, YTImage paramYTImage);
  
  public native FaceStatus[] DoDetectionProcessRGB(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, YTImage paramYTImage);
  
  public native FaceStatus[] DoDetectionProcessRGBA(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, YTImage paramYTImage);
  
  public native FaceStatus[] DoDetectionProcessYUV(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, YTImage paramYTImage);
  
  public native FaceStatus[] DoDetectionProcessYUVWithBlur(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, float[] paramArrayOfFloat, YTImage paramYTImage);
  
  public native YTFaceAlignParam GetFaceAlignParam();
  
  public native YTFaceDetectParam GetFaceDetectParam();
  
  public native Rect[] GetFaceRect(YTImage paramYTImage);
  
  public native YTFaceTrackParam GetFaceTrackParam();
  
  public native YTImage GetYTImageBitmap(Bitmap paramBitmap, int paramInt);
  
  public native int GetYTImageBitmapReuseData(Bitmap paramBitmap, int paramInt, YTImage paramYTImage);
  
  public native YTImage GetYTImageRGB(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public native YTImage GetYTImageRGBA(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public native int GetYTImageRGBAReuseData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, YTImage paramYTImage);
  
  public native int GetYTImageRGBReuseData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, YTImage paramYTImage);
  
  public native YTImage GetYTImageYUV(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public native int GetYTImageYUVReuseData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, YTImage paramYTImage);
  
  public native byte[] RotateYUV(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public native void SaveYTImage(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public native boolean SetFaceAlignParam(YTFaceAlignParam paramYTFaceAlignParam);
  
  public native boolean SetFaceDetectParam(YTFaceDetectParam paramYTFaceDetectParam);
  
  public native boolean SetFaceTrackParam(YTFaceTrackParam paramYTFaceTrackParam);
  
  public static class FaceStatus
  {
    public float pitch;
    public float[] pointsVis;
    public float roll;
    public float[] xys;
    public float[] xys5p;
    public float yaw;
  }
  
  public static abstract interface IYtLoggerListener
  {
    public abstract void log(String paramString1, String paramString2);
  }
  
  public static class YTImage
  {
    public byte[] data;
    public int height;
    public int width;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.youtu.ytfacetrack.YTFaceTrack
 * JD-Core Version:    0.7.0.1
 */