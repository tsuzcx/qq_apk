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
    AppMethodBeat.i(215852);
    this.segments = new ArrayList();
    AppMethodBeat.o(215852);
  }
  
  CompositionTrack(Asset paramAsset, int paramInt1, int paramInt2, CMTimeRange paramCMTimeRange)
  {
    super(paramAsset, paramInt1, paramInt2, paramCMTimeRange);
    AppMethodBeat.i(215859);
    this.segments = new ArrayList();
    AppMethodBeat.o(215859);
  }
  
  public List<CompositionTrackSegment> getSegments()
  {
    return this.segments;
  }
  
  public CompositionTrackSegment segmentForTrackTime(CMTime paramCMTime)
  {
    AppMethodBeat.i(215866);
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
            AppMethodBeat.o(215866);
            return paramCMTime;
          }
        }
      }
    }
    AppMethodBeat.o(215866);
    return null;
  }
  
  public String toString()
  {
    AppMethodBeat.i(215883);
    String str = "CompositionTrack{segments=" + this.segments + ", trackID=" + this.trackID + ", mediaType=" + this.mediaType + '}';
    AppMethodBeat.o(215883);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.asset.CompositionTrack
 * JD-Core Version:    0.7.0.1
 */