package com.tencent.tav.codec;

import android.graphics.SurfaceTexture;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import java.nio.ByteBuffer;

public abstract interface IMediaCodec
{
  public abstract void bindSurfaceTexture(SurfaceTexture paramSurfaceTexture);
  
  public abstract void configure(MediaFormat paramMediaFormat, Surface paramSurface, MediaCrypto paramMediaCrypto, int paramInt);
  
  public abstract Surface createInputSurface();
  
  public abstract int dequeueInputBuffer(long paramLong);
  
  public abstract int dequeueOutputBuffer(MediaCodec.BufferInfo paramBufferInfo, long paramLong);
  
  public abstract void flush();
  
  public abstract ByteBuffer getInputBuffer(int paramInt);
  
  public abstract ByteBuffer getOutputBuffer(int paramInt);
  
  public abstract MediaFormat getOutputFormat();
  
  public abstract void queueInputBuffer(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4);
  
  public abstract void release();
  
  public abstract void releaseOutputBuffer(int paramInt, boolean paramBoolean);
  
  public abstract void reset();
  
  public abstract void setDataSource(String paramString);
  
  public abstract void signalEndOfInputStream();
  
  public abstract void start();
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.codec.IMediaCodec
 * JD-Core Version:    0.7.0.1
 */