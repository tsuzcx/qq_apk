package com.tencent.tavkit.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;

public class TAVTimeEffect
{
  private boolean freeze = false;
  private int loopCount = 1;
  private boolean reverse = false;
  private CMTime scaledDuration = CMTime.CMTimeInvalid;
  private CMTimeRange timeRange;
  
  public int getLoopCount()
  {
    AppMethodBeat.i(197425);
    int i = Math.abs(this.loopCount);
    AppMethodBeat.o(197425);
    return i;
  }
  
  public CMTime getScaledDuration()
  {
    return this.scaledDuration;
  }
  
  public CMTimeRange getTimeRange()
  {
    return this.timeRange;
  }
  
  public boolean isFreeze()
  {
    return this.freeze;
  }
  
  public boolean isReverse()
  {
    return this.reverse;
  }
  
  public void setFreeze(boolean paramBoolean)
  {
    this.freeze = paramBoolean;
  }
  
  public void setLoopCount(int paramInt)
  {
    this.loopCount = paramInt;
  }
  
  public void setReverse(boolean paramBoolean)
  {
    this.reverse = paramBoolean;
  }
  
  public void setScaledDuration(CMTime paramCMTime)
  {
    this.scaledDuration = paramCMTime;
  }
  
  public void setTimeRange(CMTimeRange paramCMTimeRange)
  {
    this.timeRange = paramCMTimeRange;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tavkit.component.TAVTimeEffect
 * JD-Core Version:    0.7.0.1
 */