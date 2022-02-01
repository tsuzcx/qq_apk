package com.tencent.youtu.ytposedetect.jni;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytposedetect.data.YTActRefData;
import java.io.ByteArrayOutputStream;

public class YTPoseDetectJNIInterface
{
  private static IYtLoggerListener loggerListener;
  
  public static native String Checksum(byte[] paramArrayOfByte);
  
  public static native boolean canReflect();
  
  public static native void configNativeLog(boolean paramBoolean);
  
  public static byte[] encodeJpeg(Bitmap paramBitmap)
  {
    AppMethodBeat.i(62514);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 99, localByteArrayOutputStream);
    paramBitmap = localByteArrayOutputStream.toByteArray();
    AppMethodBeat.o(62514);
    return paramBitmap;
  }
  
  public static native YTActRefData getActionReflectData(int paramInt);
  
  public static native byte[] getBestImage(int paramInt);
  
  public static native String getConfigData(byte[] paramArrayOfByte, String paramString1, String paramString2, String paramString3);
  
  public static native byte[] getEyeImage(int paramInt);
  
  public static native byte[][] getFrameList();
  
  public static native String getLiveSelectDataChecksum(String paramString1, String paramString2);
  
  public static native byte[] getMouthImage(int paramInt);
  
  public static native String getVersion();
  
  public static native int initModel(String paramString);
  
  public static native boolean isRecordingDone();
  
  public static void nativeLog(int paramInt, String paramString)
  {
    AppMethodBeat.i(218143);
    if (loggerListener != null) {
      loggerListener.log("[YTPoseDetectJNIInterface.nativeLog]", paramString);
    }
    AppMethodBeat.o(218143);
  }
  
  public static void nativeLog(String paramString1, String paramString2)
  {
    AppMethodBeat.i(218137);
    if (loggerListener != null) {
      loggerListener.log(paramString1, paramString2);
    }
    AppMethodBeat.o(218137);
  }
  
  public static native int poseDetect(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt5);
  
  public static native void releaseAll();
  
  public static native void resetDetect();
  
  public static native void setColorData(String paramString1, String paramString2, String paramString3);
  
  public static void setLoggerListener(IYtLoggerListener paramIYtLoggerListener)
  {
    loggerListener = paramIYtLoggerListener;
  }
  
  public static native void setSafetyLevel(int paramInt);
  
  public static native int updateParam(String paramString1, String paramString2);
  
  public static abstract interface IYtLoggerListener
  {
    public abstract void log(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.youtu.ytposedetect.jni.YTPoseDetectJNIInterface
 * JD-Core Version:    0.7.0.1
 */