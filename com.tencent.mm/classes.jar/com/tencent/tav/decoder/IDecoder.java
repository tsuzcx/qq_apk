package com.tencent.tav.decoder;

import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import java.nio.ByteBuffer;

public abstract interface IDecoder
{
  public static final long SAMPLE_STATE_ERROR = -3L;
  public static final long SAMPLE_STATE_FAILED = -2L;
  public static final long SAMPLE_STATE_FINISH = -1L;
  public static final long SAMPLE_STATE_TIMEOUT = -4L;
  public static final long SAMPLE_STATE_UN_START = -100L;
  
  public abstract String getSourcePath();
  
  public abstract boolean hasTrack();
  
  public abstract ByteBuffer outputBuffer();
  
  public abstract CMSampleState readSample();
  
  public abstract CMSampleState readSample(CMTime paramCMTime);
  
  public abstract void release();
  
  public abstract void seekTo(CMTime paramCMTime);
  
  public abstract void start(CMTimeRange paramCMTimeRange);
  
  public abstract void start(CMTimeRange paramCMTimeRange, CMTime paramCMTime);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tav.decoder.IDecoder
 * JD-Core Version:    0.7.0.1
 */