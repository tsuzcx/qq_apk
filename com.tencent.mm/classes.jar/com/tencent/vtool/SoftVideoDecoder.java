package com.tencent.vtool;

import android.util.AndroidRuntimeException;

public class SoftVideoDecoder
{
  private static final String TAG = SoftVideoDecoder.class.getSimpleName();
  public long bcj;
  public int dHO;
  public long mDuration;
  public int mHeight;
  private long mLastTime;
  public int mWidth;
  
  static
  {
    System.loadLibrary("ijkffmpeg");
    System.loadLibrary("soft_decoder");
  }
  
  public SoftVideoDecoder(String paramString)
  {
    int[] arrayOfInt = new int[2];
    this.bcj = initDecoder(paramString, arrayOfInt);
    this.mWidth = arrayOfInt[0];
    this.mHeight = arrayOfInt[1];
    if (this.bcj != -1L)
    {
      this.mDuration = getDuration(this.bcj);
      this.dHO = getRotation(this.bcj);
    }
  }
  
  private static native long getDuration(long paramLong);
  
  private static native int getFrameAtTime(long paramLong1, byte[] paramArrayOfByte, long paramLong2);
  
  private static native int getRotation(long paramLong);
  
  private static native long initDecoder(String paramString, int[] paramArrayOfInt);
  
  public static native int releaseDecoder(long paramLong);
  
  private static native int seek(long paramLong1, long paramLong2);
  
  public final int e(byte[] paramArrayOfByte, long paramLong)
  {
    try
    {
      if (paramArrayOfByte.length != this.mWidth * this.mHeight * 4) {
        throw new AndroidRuntimeException("rgb buffer size wrong exception");
      }
    }
    finally {}
    int i;
    if (paramLong < 0L)
    {
      i = -1;
      return i;
    }
    if (paramLong < this.mDuration) {}
    for (;;)
    {
      if (paramLong < this.mLastTime) {
        seek(paramLong);
      }
      this.mLastTime = paramLong;
      i = getFrameAtTime(this.bcj, paramArrayOfByte, paramLong);
      break;
      paramLong = this.mDuration;
      paramLong -= 1L;
    }
  }
  
  public final int seek(long paramLong)
  {
    try
    {
      this.mLastTime = paramLong;
      int i = seek(this.bcj, paramLong);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.vtool.SoftVideoDecoder
 * JD-Core Version:    0.7.0.1
 */