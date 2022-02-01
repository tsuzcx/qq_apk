package com.tencent.tav.decoder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import java.nio.ByteBuffer;

public abstract interface IDecoder
{
  public static final CMTime SAMPLE_TIME_ERROR = new CMTime(-3L);
  public static final CMTime SAMPLE_TIME_FAILED;
  public static final CMTime SAMPLE_TIME_FINISH;
  public static final CMTime SAMPLE_TIME_TIMEOUT = new CMTime(-4L);
  public static final CMTime SAMPLE_TIME_UNSTART = new CMTime(-100L);
  
  static
  {
    SAMPLE_TIME_FINISH = new CMTime(-1L);
    SAMPLE_TIME_FAILED = new CMTime(-2L);
  }
  
  public abstract String getSourcePath();
  
  public abstract boolean hasTrack();
  
  public abstract ByteBuffer outputBuffer();
  
  public abstract CMTime readSample();
  
  public abstract CMTime readSample(CMTime paramCMTime);
  
  public abstract void release();
  
  public abstract void seekTo(CMTime paramCMTime);
  
  public abstract void start(CMTimeRange paramCMTimeRange);
  
  public abstract void start(CMTimeRange paramCMTimeRange, CMTime paramCMTime);
  
  public static enum DecodeType
  {
    static
    {
      AppMethodBeat.i(201791);
      Video = new DecodeType("Video", 0);
      Audio = new DecodeType("Audio", 1);
      $VALUES = new DecodeType[] { Video, Audio };
      AppMethodBeat.o(201791);
    }
    
    private DecodeType() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tav.decoder.IDecoder
 * JD-Core Version:    0.7.0.1
 */