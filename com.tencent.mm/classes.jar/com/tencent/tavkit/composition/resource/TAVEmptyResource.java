package com.tencent.tavkit.composition.resource;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;

public class TAVEmptyResource
  extends TAVResource
{
  private boolean insertTimeRange;
  
  public TAVEmptyResource(CMTime paramCMTime)
  {
    this(paramCMTime, true);
  }
  
  public TAVEmptyResource(CMTime paramCMTime, boolean paramBoolean)
  {
    AppMethodBeat.i(192086);
    this.insertTimeRange = paramBoolean;
    this.duration = paramCMTime;
    this.sourceTimeRange = new CMTimeRange(CMTime.CMTimeZero, paramCMTime);
    AppMethodBeat.o(192086);
  }
  
  public TAVResource clone()
  {
    AppMethodBeat.i(192088);
    TAVEmptyResource localTAVEmptyResource = new TAVEmptyResource(this.duration.clone());
    localTAVEmptyResource.sourceTimeRange = this.sourceTimeRange.clone();
    localTAVEmptyResource.scaledDuration = this.scaledDuration.clone();
    AppMethodBeat.o(192088);
    return localTAVEmptyResource;
  }
  
  public void setInsertTimeRange(boolean paramBoolean)
  {
    this.insertTimeRange = paramBoolean;
  }
  
  public TrackInfo trackInfoForType(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192087);
    if (this.insertTimeRange)
    {
      TrackInfo localTrackInfo = super.trackInfoForType(paramInt1, paramInt2);
      AppMethodBeat.o(192087);
      return localTrackInfo;
    }
    AppMethodBeat.o(192087);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tavkit.composition.resource.TAVEmptyResource
 * JD-Core Version:    0.7.0.1
 */