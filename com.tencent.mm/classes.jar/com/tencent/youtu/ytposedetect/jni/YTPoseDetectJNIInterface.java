package com.tencent.youtu.ytposedetect.jni;

public class YTPoseDetectJNIInterface
{
  public static native byte[] getBestImage();
  
  public static native byte[][] getFrameList();
  
  public static native int getFrameNum();
  
  public static native int initModel(String paramString);
  
  public static native boolean isRecordingDone();
  
  public static native int poseDetect(float[] paramArrayOfFloat, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2, float paramFloat3);
  
  public static native void releaseAll();
  
  public static native void setFrameNum(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.youtu.ytposedetect.jni.YTPoseDetectJNIInterface
 * JD-Core Version:    0.7.0.1
 */