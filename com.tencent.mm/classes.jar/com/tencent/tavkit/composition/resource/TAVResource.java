package com.tencent.tavkit.composition.resource;

import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.asset.MutableComposition;
import com.tencent.tav.asset.MutableCompositionTrack;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.ciimage.CIImage;
import java.util.ArrayList;
import java.util.List;

public abstract class TAVResource
  implements Cloneable
{
  protected CMTime duration = CMTime.CMTimeZero;
  protected CMTime scaledDuration;
  protected CMTimeRange sourceTimeRange;
  
  public TAVResource()
  {
    CMTime localCMTime = CMTime.CMTimeZero;
    this.sourceTimeRange = new CMTimeRange(localCMTime, localCMTime);
    this.scaledDuration = CMTime.CMTimeInvalid;
  }
  
  public abstract TAVResource clone();
  
  public CMTime getDuration()
  {
    return this.duration;
  }
  
  public CMTime getScaledDuration()
  {
    if (this.scaledDuration.equals(CMTime.CMTimeInvalid)) {
      return this.sourceTimeRange.getDuration();
    }
    return this.scaledDuration;
  }
  
  public CMTimeRange getSourceTimeRange()
  {
    return this.sourceTimeRange;
  }
  
  public CIImage imageAtTime(CMTime paramCMTime, CGSize paramCGSize)
  {
    return null;
  }
  
  public void setDuration(CMTime paramCMTime)
  {
    this.duration = paramCMTime;
  }
  
  public void setScaledDuration(CMTime paramCMTime)
  {
    this.scaledDuration = paramCMTime;
  }
  
  public void setSourceTimeRange(CMTimeRange paramCMTimeRange)
  {
    this.sourceTimeRange = paramCMTimeRange.clone();
  }
  
  public String toString()
  {
    return "TAVResource{durationUs=" + this.duration.getTimeUs() + ", sourceTimeRange=" + this.sourceTimeRange.toSimpleString() + ", scaledDurationUs=" + this.scaledDuration.getTimeUs() + '}';
  }
  
  public TrackInfo trackInfoForType(int paramInt1, int paramInt2)
  {
    Object localObject = (AssetTrack)tracksForType(paramInt1).get(paramInt2);
    TrackInfo localTrackInfo = new TrackInfo();
    localTrackInfo.setTrack((AssetTrack)localObject);
    localObject = new CMTime(1L, 30);
    localTrackInfo.setSelectedTimeRange(new CMTimeRange(CMTime.CMTimeZero, (CMTime)localObject));
    localTrackInfo.setScaleToDuration(getScaledDuration());
    return localTrackInfo;
  }
  
  public List<AssetTrack> tracksForType(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    MutableCompositionTrack localMutableCompositionTrack = new MutableComposition().addMutableTrackWithMediaType(paramInt, 0);
    localMutableCompositionTrack.insertEmptyTimeRange(new CMTimeRange(CMTime.CMTimeZero, this.duration));
    localArrayList.add(localMutableCompositionTrack);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tavkit.composition.resource.TAVResource
 * JD-Core Version:    0.7.0.1
 */