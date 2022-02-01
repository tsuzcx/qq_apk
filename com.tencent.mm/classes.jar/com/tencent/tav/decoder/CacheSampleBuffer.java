package com.tencent.tav.decoder;

import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.TextureInfo;
import java.nio.ByteBuffer;

public class CacheSampleBuffer
  extends CMSampleBuffer
{
  private VideoTexture texture;
  
  public CacheSampleBuffer(CMSampleState paramCMSampleState)
  {
    super(paramCMSampleState);
  }
  
  public CacheSampleBuffer(CMSampleState paramCMSampleState, TextureInfo paramTextureInfo)
  {
    super(paramCMSampleState, paramTextureInfo);
  }
  
  public CacheSampleBuffer(CMSampleState paramCMSampleState, TextureInfo paramTextureInfo, boolean paramBoolean)
  {
    super(paramCMSampleState, paramTextureInfo, paramBoolean);
  }
  
  public CacheSampleBuffer(CMSampleState paramCMSampleState, ByteBuffer paramByteBuffer)
  {
    super(paramCMSampleState, paramByteBuffer);
  }
  
  public CacheSampleBuffer(CMSampleState paramCMSampleState, ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    super(paramCMSampleState, paramByteBuffer, paramBoolean);
  }
  
  public CacheSampleBuffer(CMTime paramCMTime)
  {
    super(paramCMTime);
  }
  
  public CacheSampleBuffer(CMTime paramCMTime, TextureInfo paramTextureInfo)
  {
    super(paramCMTime, paramTextureInfo);
  }
  
  public CacheSampleBuffer(CMTime paramCMTime, TextureInfo paramTextureInfo, boolean paramBoolean)
  {
    super(paramCMTime, paramTextureInfo, paramBoolean);
  }
  
  public CacheSampleBuffer(CMTime paramCMTime, ByteBuffer paramByteBuffer)
  {
    super(paramCMTime, paramByteBuffer);
  }
  
  public CacheSampleBuffer(CMTime paramCMTime, ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    super(paramCMTime, paramByteBuffer, paramBoolean);
  }
  
  public VideoTexture getTexture()
  {
    return this.texture;
  }
  
  public void setTexture(VideoTexture paramVideoTexture)
  {
    this.texture = paramVideoTexture;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tav.decoder.CacheSampleBuffer
 * JD-Core Version:    0.7.0.1
 */