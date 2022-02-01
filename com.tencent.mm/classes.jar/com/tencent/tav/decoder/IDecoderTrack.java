package com.tencent.tav.decoder;

import android.view.Surface;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.report.AverageTimeReporter;
import java.util.List;

public abstract interface IDecoderTrack
{
  public abstract void asyncReadNextSample(CMTime paramCMTime);
  
  public abstract void clipRangeAndClearRange(CMTimeRange paramCMTimeRange);
  
  public abstract CMTime getCurrentSampleTime();
  
  public abstract AverageTimeReporter getDecodePerformance();
  
  public abstract CMTime getDuration();
  
  public abstract CMTime getFrameDuration();
  
  public abstract int getFrameRate();
  
  public abstract long getLaggingTime();
  
  public abstract int getTrackId();
  
  public abstract CMSampleBuffer readSample();
  
  public abstract CMSampleBuffer readSample(CMTime paramCMTime);
  
  public abstract void release();
  
  public abstract CMSampleBuffer seekTo(CMTime paramCMTime, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void setDecodeType(IDecoder.DecodeType paramDecodeType);
  
  public abstract void setFrameRate(int paramInt);
  
  public abstract void setTrackSegments(List<DecoderTrackSegment> paramList);
  
  public abstract void setVolume(float paramFloat);
  
  public abstract void start();
  
  public abstract void start(SurfaceCreator paramSurfaceCreator);
  
  public abstract void start(SurfaceCreator paramSurfaceCreator, CMTimeRange paramCMTimeRange);
  
  public static abstract interface SurfaceCreator
  {
    public abstract Surface createOutputSurface(int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void free(Surface paramSurface);
    
    public abstract void release();
    
    public abstract VideoTexture videoTextureForSurface(Surface paramSurface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.decoder.IDecoderTrack
 * JD-Core Version:    0.7.0.1
 */