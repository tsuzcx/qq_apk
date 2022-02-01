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
    AppMethodBeat.i(212467);
    this.asset = paramAsset;
    this.duration = paramAsset.getDuration();
    this.sourceTimeRange = new CMTimeRange(CMTime.CMTimeZero, paramAsset.getDuration());
    AppMethodBeat.o(212467);
  }
  
  public TAVAssetTrackResource(String paramString)
  {
    this(new URLAsset(paramString));
    AppMethodBeat.i(212466);
    AppMethodBeat.o(212466);
  }
  
  public TAVResource clone()
  {
    AppMethodBeat.i(212478);
    TAVAssetTrackResource localTAVAssetTrackResource = new TAVAssetTrackResource(this.asset);
    localTAVAssetTrackResource.sourceTimeRange = this.sourceTimeRange.clone();
    localTAVAssetTrackResource.scaledDuration = this.scaledDuration.clone();
    localTAVAssetTrackResource.duration = this.duration.clone();
    AppMethodBeat.o(212478);
    return localTAVAssetTrackResource;
  }
  
  public Asset getAsset()
  {
    return this.asset;
  }
  
  public TrackInfo trackInfoForType(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(212474);
    AssetTrack localAssetTrack = (AssetTrack)tracksForType(paramInt1).get(paramInt2);
    TrackInfo localTrackInfo = new TrackInfo();
    localTrackInfo.setTrack(localAssetTrack);
    localTrackInfo.setSelectedTimeRange(getSourceTimeRange());
    localTrackInfo.setScaleToDuration(getScaledDuration());
    AppMethodBeat.o(212474);
    return localTrackInfo;
  }
  
  public List<AssetTrack> tracksForType(int paramInt)
  {
    AppMethodBeat.i(212471);
    if (this.asset != null)
    {
      localObject = this.asset.tracksWithMediaType(paramInt);
      AppMethodBeat.o(212471);
      return localObject;
    }
    Object localObject = new ArrayList();
    AppMethodBeat.o(212471);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tavkit.composition.resource.TAVAssetTrackResource
 * JD-Core Version:    0.7.0.1
 */