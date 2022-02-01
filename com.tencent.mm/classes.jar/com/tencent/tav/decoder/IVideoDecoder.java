package com.tencent.tav.decoder;

import android.view.Surface;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.TextureInfo;

public abstract interface IVideoDecoder
  extends IDecoder
{
  public abstract TextureInfo getTextureInfo();
  
  public abstract void init(String paramString, CGSize paramCGSize, IDecoderTrack.SurfaceCreator paramSurfaceCreator);
  
  public abstract boolean isLastFrameValid();
  
  public abstract CMTime nextFrameTime(CMTime paramCMTime);
  
  public abstract Surface outputSurface();
  
  public abstract void release(boolean paramBoolean);
  
  public abstract void seekTo(CMTime paramCMTime, boolean paramBoolean);
  
  public abstract void switchFrame();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tav.decoder.IVideoDecoder
 * JD-Core Version:    0.7.0.1
 */