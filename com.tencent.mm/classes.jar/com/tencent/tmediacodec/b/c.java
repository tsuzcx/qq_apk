package com.tencent.tmediacodec.b;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.tmediacodec.a.a;
import com.tencent.tmediacodec.e.a.b;

public abstract interface c
{
  public abstract int EX(long paramLong);
  
  public abstract int a(MediaCodec.BufferInfo paramBufferInfo, long paramLong);
  
  public abstract void a(int paramInt1, int paramInt2, long paramLong, int paramInt3);
  
  public abstract void a(MediaFormat paramMediaFormat, Surface paramSurface, MediaCrypto paramMediaCrypto, int paramInt);
  
  public abstract void a(a parama);
  
  public abstract a.b b(e parame);
  
  public abstract void flush();
  
  public abstract MediaCodec isY();
  
  public abstract void isZ();
  
  public abstract void ita();
  
  @TargetApi(23)
  public abstract void q(Surface paramSurface);
  
  public abstract void release();
  
  public abstract void releaseOutputBuffer(int paramInt, boolean paramBoolean);
  
  public abstract void start();
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tmediacodec.b.c
 * JD-Core Version:    0.7.0.1
 */