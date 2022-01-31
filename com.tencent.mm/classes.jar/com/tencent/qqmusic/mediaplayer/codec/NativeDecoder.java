package com.tencent.qqmusic.mediaplayer.codec;

import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.NativeLibs;
import com.tencent.qqmusic.mediaplayer.upstream.FileDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class NativeDecoder
  extends BaseDecoder
{
  private static final String TAG = "NativeDecoder";
  private long mNativePointer = 0L;
  private final ReadWriteLock mReadWriteLock = new ReentrantReadWriteLock();
  
  private native int nativeDecode(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  private native AudioInformation nativeGetAudioInformation(long paramLong);
  
  private native long nativeGetBytePositionOfTime(long paramLong1, long paramLong2);
  
  private native long nativeGetCurrentPosition(long paramLong);
  
  private native int nativeGetDetailErrorCode(long paramLong);
  
  private native String nativeGetDetailErrorDescription(long paramLong);
  
  private native long nativeGetDuration(long paramLong);
  
  private native long nativeGetMinBufferSize(long paramLong);
  
  private native long[] nativeInit(long paramLong);
  
  private native long[] nativeInit(IDataSource paramIDataSource);
  
  private native int nativeRelease(long paramLong);
  
  private native long nativeSeekTo(long paramLong1, long paramLong2);
  
  public int decodeData(int paramInt, byte[] paramArrayOfByte)
  {
    this.mReadWriteLock.readLock().lock();
    try
    {
      paramInt = nativeDecode(this.mNativePointer, paramArrayOfByte, 0, paramInt);
      return paramInt;
    }
    finally
    {
      this.mReadWriteLock.readLock().unlock();
    }
  }
  
  public AudioInformation getAudioInformation()
  {
    this.mReadWriteLock.readLock().lock();
    try
    {
      AudioInformation localAudioInformation = nativeGetAudioInformation(this.mNativePointer);
      return localAudioInformation;
    }
    finally
    {
      this.mReadWriteLock.readLock().unlock();
    }
  }
  
  public long getBytePositionOfTime(long paramLong)
  {
    this.mReadWriteLock.readLock().lock();
    try
    {
      paramLong = nativeGetBytePositionOfTime(this.mNativePointer, paramLong);
      return paramLong;
    }
    finally
    {
      this.mReadWriteLock.readLock().unlock();
    }
  }
  
  public long getCurrentTime()
  {
    this.mReadWriteLock.readLock().lock();
    try
    {
      long l = nativeGetCurrentPosition(this.mNativePointer);
      return l;
    }
    finally
    {
      this.mReadWriteLock.readLock().unlock();
    }
  }
  
  public long getDuration()
  {
    this.mReadWriteLock.readLock().lock();
    try
    {
      long l = nativeGetDuration(this.mNativePointer);
      return l;
    }
    finally
    {
      this.mReadWriteLock.readLock().unlock();
    }
  }
  
  public int getErrorCodeMask()
  {
    return -1;
  }
  
  public long getMinBufferSize()
  {
    this.mReadWriteLock.readLock().lock();
    try
    {
      long l = nativeGetMinBufferSize(this.mNativePointer);
      return l;
    }
    finally
    {
      this.mReadWriteLock.readLock().unlock();
    }
  }
  
  protected List<NativeLibs> getNativeLibs()
  {
    return Arrays.asList(new NativeLibs[] { NativeLibs.audioCommon, NativeLibs.formatDetector, NativeLibs.codecFactory, NativeLibs.decoderJni });
  }
  
  public int init(IDataSource paramIDataSource)
  {
    this.mReadWriteLock.writeLock().lock();
    try
    {
      paramIDataSource = nativeInit(paramIDataSource);
      long l2 = -1L;
      long l1 = l2;
      if (paramIDataSource != null)
      {
        l1 = l2;
        if (paramIDataSource.length >= 2)
        {
          this.mNativePointer = paramIDataSource[0];
          l1 = paramIDataSource[1];
        }
      }
      int i = (int)l1;
      return i;
    }
    finally
    {
      this.mReadWriteLock.writeLock().unlock();
    }
  }
  
  public int init(INativeDataSource paramINativeDataSource)
  {
    this.mReadWriteLock.writeLock().lock();
    long l2 = -1L;
    long l1 = l2;
    if (paramINativeDataSource != null) {}
    try
    {
      paramINativeDataSource = nativeInit(paramINativeDataSource.getNativeInstance());
      l1 = l2;
      if (paramINativeDataSource != null)
      {
        l1 = l2;
        if (paramINativeDataSource.length >= 2)
        {
          this.mNativePointer = paramINativeDataSource[0];
          l1 = paramINativeDataSource[1];
        }
      }
      int i = (int)l1;
      return i;
    }
    finally
    {
      this.mReadWriteLock.writeLock().unlock();
    }
  }
  
  public int init(String paramString, boolean paramBoolean)
  {
    return init(new FileDataSource(paramString));
  }
  
  public int release()
  {
    this.mReadWriteLock.writeLock().lock();
    try
    {
      int i = nativeRelease(this.mNativePointer);
      this.mNativePointer = 0L;
      return i;
    }
    finally
    {
      this.mReadWriteLock.writeLock().unlock();
    }
  }
  
  public int seekTo(int paramInt)
  {
    this.mReadWriteLock.readLock().lock();
    try
    {
      long l = nativeSeekTo(this.mNativePointer, paramInt);
      paramInt = (int)l;
      return paramInt;
    }
    finally
    {
      this.mReadWriteLock.readLock().unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.codec.NativeDecoder
 * JD-Core Version:    0.7.0.1
 */