package com.tencent.ttpic.recorder;

import android.opengl.GLES20;
import com.tencent.util.g;
import com.tencent.vtool.SoftVideoDecoder;
import java.nio.ByteBuffer;

public class SoftwareDecoder
  implements IVideoDecoder
{
  private static final String TAG = SoftwareDecoder.class.getSimpleName();
  private final SoftVideoDecoder mDecoder;
  private boolean mNeedUpdate = false;
  private final int mTexture;
  private final Object mUpdateLock = new Object();
  private byte[][] mVideoFrameData = new byte[2][];
  private int mVideoFrameDataIndex = 0;
  
  static
  {
    System.loadLibrary("soft_decoder");
  }
  
  public SoftwareDecoder(String paramString, int paramInt)
  {
    this.mDecoder = new SoftVideoDecoder(paramString);
    this.mTexture = paramInt;
  }
  
  public void decodeFrame(long paramLong)
  {
    synchronized (this.mUpdateLock)
    {
      long l = System.currentTimeMillis();
      int i = (this.mVideoFrameDataIndex + 1) % this.mVideoFrameData.length;
      byte[] arrayOfByte2 = this.mVideoFrameData[i];
      byte[] arrayOfByte1;
      if (arrayOfByte2 != null)
      {
        arrayOfByte1 = arrayOfByte2;
        if (arrayOfByte2.length == getWidth() * getHeight() * 4) {}
      }
      else
      {
        arrayOfByte1 = new byte[getWidth() * getHeight() * 4];
      }
      this.mDecoder.e(arrayOfByte1, paramLong);
      this.mVideoFrameData[i] = arrayOfByte1;
      this.mVideoFrameDataIndex = i;
      this.mNeedUpdate = true;
      g.h(TAG, "postFrameAvailable() - Video Time: decode1Grid(" + paramLong + ") - " + (System.currentTimeMillis() - l));
      return;
    }
  }
  
  public long getDuration()
  {
    return this.mDecoder.mDuration;
  }
  
  public int getHeight()
  {
    return this.mDecoder.mHeight;
  }
  
  public int getRotation()
  {
    return this.mDecoder.dHO;
  }
  
  public int getWidth()
  {
    return this.mDecoder.mWidth;
  }
  
  public boolean isLive()
  {
    return this.mDecoder.bcj != -1L;
  }
  
  public void release()
  {
    Object localObject1 = this.mUpdateLock;
    int i = 0;
    try
    {
      while (i < this.mVideoFrameData.length)
      {
        this.mVideoFrameData[i] = null;
        i += 1;
      }
      localObject1 = this.mDecoder;
      if (((SoftVideoDecoder)localObject1).bcj != -1L) {
        SoftVideoDecoder.releaseDecoder(((SoftVideoDecoder)localObject1).bcj);
      }
      return;
    }
    finally {}
  }
  
  public void reset()
  {
    seek(0L);
  }
  
  public int seek(long paramLong)
  {
    return this.mDecoder.seek(paramLong);
  }
  
  public void updateFrame()
  {
    synchronized (this.mUpdateLock)
    {
      long l = System.currentTimeMillis();
      if ((this.mVideoFrameData[this.mVideoFrameDataIndex] != null) && (this.mVideoFrameData[this.mVideoFrameDataIndex].length == getWidth() * getHeight() * 4))
      {
        if (this.mNeedUpdate)
        {
          g.h(TAG, "postFrameAvailable() - updateFrame() - Need Update - " + this.mVideoFrameDataIndex);
          this.mNeedUpdate = false;
          GLES20.glActiveTexture(33988);
          GLES20.glBindTexture(3553, this.mTexture);
          GLES20.glTexImage2D(3553, 0, 6407, getWidth(), getHeight(), 0, 6407, 5121, ByteBuffer.wrap(this.mVideoFrameData[this.mVideoFrameDataIndex]));
          GLES20.glTexParameteri(3553, 10240, 9729);
          GLES20.glTexParameteri(3553, 10241, 9729);
          GLES20.glTexParameteri(3553, 10242, 33071);
          GLES20.glTexParameteri(3553, 10243, 33071);
          g.h(TAG, "postFrameAvailable() - Video Time: updateFrame(" + this.mVideoFrameDataIndex + ") - " + (System.currentTimeMillis() - l));
        }
        return;
      }
      g.i(TAG, "mVideoFrameData[mVideoFrameDataIndex] is null");
      g.h(TAG, "postFrameAvailable() - updateFrame() - no data");
    }
  }
  
  public void updateFrameWithoutWaiting()
  {
    synchronized (this.mUpdateLock)
    {
      long l = System.currentTimeMillis();
      if ((this.mVideoFrameData[this.mVideoFrameDataIndex] != null) && (this.mVideoFrameData[this.mVideoFrameDataIndex].length == getWidth() * getHeight() * 4))
      {
        g.h(TAG, "postFrameAvailable() - updateFrame() - Need Update - " + this.mVideoFrameDataIndex);
        this.mNeedUpdate = false;
        GLES20.glActiveTexture(33988);
        GLES20.glBindTexture(3553, this.mTexture);
        GLES20.glTexImage2D(3553, 0, 6407, getWidth(), getHeight(), 0, 6407, 5121, ByteBuffer.wrap(this.mVideoFrameData[this.mVideoFrameDataIndex]));
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        g.h(TAG, "postFrameAvailable() - Video Time: updateFrame(" + this.mVideoFrameDataIndex + ") - " + (System.currentTimeMillis() - l));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.recorder.SoftwareDecoder
 * JD-Core Version:    0.7.0.1
 */