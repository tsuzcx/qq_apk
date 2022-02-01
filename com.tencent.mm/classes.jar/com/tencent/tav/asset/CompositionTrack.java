package com.tencent.tav.asset;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeMapping;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompositionTrack
  extends AssetTrack<CompositionTrackSegment>
{
  protected List<CompositionTrackSegment> segments;
  
  CompositionTrack()
  {
    AppMethodBeat.i(197397);
    this.segments = new ArrayList();
    AppMethodBeat.o(197397);
  }
  
  CompositionTrack(Asset paramAsset, int paramInt1, int paramInt2, CMTimeRange paramCMTimeRange)
  {
    super(paramAsset, paramInt1, paramInt2, paramCMTimeRange);
    AppMethodBeat.i(197398);
    this.segments = new ArrayList();
    AppMethodBeat.o(197398);
  }
  
  public List<CompositionTrackSegment> getSegments()
  {
    return this.segments;
  }
  
  public CompositionTrackSegment segmentForTrackTime(CMTime paramCMTime)
  {
    AppMethodBeat.i(197399);
    if (this.segments != null)
    {
      Iterator localIterator = this.segments.iterator();
      while (localIterator.hasNext())
      {
        AssetTrackSegment localAssetTrackSegment = (AssetTrackSegment)localIterator.next();
        if (localAssetTrackSegment != null)
        {
          CMTimeRange localCMTimeRange = localAssetTrackSegment.getTimeMapping().getTarget();
          if ((localCMTimeRange != null) && (localCMTimeRange.containsTime(paramCMTime)) && ((localAssetTrackSegment instanceof CompositionTrackSegment)))
          {
            paramCMTime = (CompositionTrackSegment)localAssetTrackSegment;
            AppMethodBeat.o(197399);
            return paramCMTime;
          }
        }
      }
    }
    AppMethodBeat.o(197399);
    return null;
  }
  
  public String toString()
  {
    AppMethodBeat.i(197400);
    String str = "CompositionTrack{segments=" + this.segments + ", trackID=" + this.trackID + ", mediaType=" + this.mediaType + '}';
    AppMethodBeat.o(197400);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tav.asset.CompositionTrack
 * JD-Core Version:    0.7.0.1
 */