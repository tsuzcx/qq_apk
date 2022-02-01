package com.tencent.tavkit.composition.resource;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.asset.CompositionTrackSegment;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeMapping;
import com.tencent.tav.coremedia.CMTimeRange;

public class TrackInfo
{
  private CompositionTrackSegment compositionTrackSegment;
  private CMTime scaleToDuration;
  private CMTimeRange selectedTimeRange;
  private AssetTrack track;
  
  public CompositionTrackSegment getCompositionTrackSegment(CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(212541);
    paramCMTimeRange = new CompositionTrackSegment(this.compositionTrackSegment.getSourcePath(), this.compositionTrackSegment.getSourceTrackID(), this.compositionTrackSegment.getTimeMapping().getSource(), paramCMTimeRange, this.compositionTrackSegment.getSourceType());
    AppMethodBeat.o(212541);
    return paramCMTimeRange;
  }
  
  public int getMediaType()
  {
    AppMethodBeat.i(212543);
    int i;
    if (this.track != null)
    {
      i = this.track.getMediaType();
      AppMethodBeat.o(212543);
      return i;
    }
    if (this.compositionTrackSegment != null)
    {
      int j = this.compositionTrackSegment.getSourceType();
      i = j;
      if (j == 3) {
        i = 1;
      }
      AppMethodBeat.o(212543);
      return i;
    }
    AppMethodBeat.o(212543);
    return 0;
  }
  
  public CMTime getScaleToDuration()
  {
    return this.scaleToDuration;
  }
  
  public CMTimeRange getSelectedTimeRange()
  {
    return this.selectedTimeRange;
  }
  
  public AssetTrack getTrack()
  {
    return this.track;
  }
  
  public void setCompositionTrackSegment(CompositionTrackSegment paramCompositionTrackSegment)
  {
    this.compositionTrackSegment = paramCompositionTrackSegment;
  }
  
  public void setScaleToDuration(CMTime paramCMTime)
  {
    this.scaleToDuration = paramCMTime;
  }
  
  public void setSelectedTimeRange(CMTimeRange paramCMTimeRange)
  {
    this.selectedTimeRange = paramCMTimeRange;
  }
  
  public void setTrack(AssetTrack paramAssetTrack)
  {
    this.track = paramAssetTrack;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tavkit.composition.resource.TrackInfo
 * JD-Core Version:    0.7.0.1
 */