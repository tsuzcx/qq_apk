package com.tencent.qqvideo.proxy.pi;

public class IRefObject
{
  private long mNativePtr;
  
  public IRefObject(long paramLong)
  {
    this.mNativePtr = paramLong;
  }
  
  private static native void freeNativePtr(long paramLong);
  
  private long getNativePtr()
  {
    try
    {
      long l = this.mNativePtr;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public native void finalize();
  
  public synchronized native void release();
  
  public synchronized native void retain();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.qqvideo.proxy.pi.IRefObject
 * JD-Core Version:    0.7.0.1
 */