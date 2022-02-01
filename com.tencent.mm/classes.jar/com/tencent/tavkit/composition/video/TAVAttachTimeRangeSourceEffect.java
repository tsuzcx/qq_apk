package com.tencent.tavkit.composition.video;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;

public abstract interface TAVAttachTimeRangeSourceEffect
{
  public abstract void attachTimeRange(CMTimeRange paramCMTimeRange);
  
  public static abstract interface TimeAttachFilter
  {
    public abstract void attachPositionTime(CMTime paramCMTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tavkit.composition.video.TAVAttachTimeRangeSourceEffect
 * JD-Core Version:    0.7.0.1
 */