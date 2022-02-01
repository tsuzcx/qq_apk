package com.tencent.tavkit.composition.model;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;

public abstract interface TAVCompositionTimeRange
{
  public abstract CMTime getDuration();
  
  public abstract CMTime getStartTime();
  
  public abstract CMTimeRange getTimeRange();
  
  public abstract void setDuration(CMTime paramCMTime);
  
  public abstract void setStartTime(CMTime paramCMTime);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tavkit.composition.model.TAVCompositionTimeRange
 * JD-Core Version:    0.7.0.1
 */