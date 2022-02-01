package com.tencent.tavkit.composition.resource;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.asset.URLAsset;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.List;

public class TAVAssetTrackResource
  extends TAVResource
{
  private Asset asset;
  
  public TAVAssetTrackResource(Asset paramAsset)
  {
    AppMethodBeat.i(218858);
    this.asset = paramAsset;
    this.duration = paramAsset.getDuration();
    this.sourceTimeRange = new CMTimeRange(CMTime.CMTimeZero, paramAsset.getDuration());
    AppMethodBeat.o(218858);
  }
  
  public TAVAssetTrackResource(String paramString)
  {
    this(new URLAsset(paramString));
    AppMethodBeat.i(218848);
    AppMethodBeat.o(218848);
  }
  
  public TAVResource clone()
  {
    AppMethodBeat.i(218892);
    TAVAssetTrackResource localTAVAssetTrackResource = new TAVAssetTrackResource(this.asset);
    localTAVAssetTrackResource.sourceTimeRange = this.sourceTimeRange.clone();
    localTAVAssetTrackResource.scaledDuration = this.scaledDuration.clone();
    localTAVAssetTrackResource.duration = this.duration.clone();
    AppMethodBeat.o(218892);
    return localTAVAssetTrackResource;
  }
  
  public Asset getAsset()
  {
    return this.asset;
  }
  
  public TrackInfo trackInfoForType(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(218886);
    AssetTrack localAssetTrack = (AssetTrack)tracksForType(paramInt1).get(paramInt2);
    TrackInfo localTrackInfo = new TrackInfo();
    localTrackInfo.setTrack(localAssetTrack);
    localTrackInfo.setSelectedTimeRange(getSourceTimeRange());
    localTrackInfo.setScaleToDuration(getScaledDuration());
    AppMethodBeat.o(218886);
    return localTrackInfo;
  }
  
  public List<AssetTrack> tracksForType(int paramInt)
  {
    AppMethodBeat.i(218877);
    if (this.asset != null)
    {
      localObject = this.asset.tracksWithMediaType(paramInt);
      AppMethodBeat.o(218877);
      return localObject;
    }
    Object localObject = new ArrayList();
    AppMethodBeat.o(218877);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tavkit.composition.resource.TAVAssetTrackResource
 * JD-Core Version:    0.7.0.1
 */