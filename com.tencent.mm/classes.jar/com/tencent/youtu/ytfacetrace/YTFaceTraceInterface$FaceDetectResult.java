package com.tencent.youtu.ytfacetrace;

public abstract interface YTFaceTraceInterface$FaceDetectResult
{
  public static final int ERROR_AUTH_FAILED = 1;
  public static final int ERROR_NOT_INIT_MODEL = 2;
  public static final int SUCCESS = 0;
  
  public abstract void onFailed(int paramInt, String paramString1, String paramString2);
  
  public abstract void onSuccess();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.youtu.ytfacetrace.YTFaceTraceInterface.FaceDetectResult
 * JD-Core Version:    0.7.0.1
 */