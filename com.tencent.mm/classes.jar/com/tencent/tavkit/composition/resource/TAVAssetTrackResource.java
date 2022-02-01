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
    AppMethodBeat.i(192081);
    this.asset = paramAsset;
    this.duration = paramAsset.getDuration();
    this.sourceTimeRange = new CMTimeRange(CMTime.CMTimeZero, paramAsset.getDuration());
    AppMethodBeat.o(192081);
  }
  
  public TAVAssetTrackResource(String paramString)
  {
    this(new URLAsset(paramString));
    AppMethodBeat.i(192080);
    AppMethodBeat.o(192080);
  }
  
  public TAVResource clone()
  {
    AppMethodBeat.i(192084);
    TAVAssetTrackResource localTAVAssetTrackResource = new TAVAssetTrackResource(this.asset);
    localTAVAssetTrackResource.sourceTimeRange = this.sourceTimeRange.clone();
    localTAVAssetTrackResource.scaledDuration = this.scaledDuration.clone();
    localTAVAssetTrackResource.duration = this.duration.clone();
    AppMethodBeat.o(192084);
    return localTAVAssetTrackResource;
  }
  
  public Asset getAsset()
  {
    return this.asset;
  }
  
  public TrackInfo trackInfoForType(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192083);
    AssetTrack localAssetTrack = (AssetTrack)tracksForType(paramInt1).get(paramInt2);
    TrackInfo localTrackInfo = new TrackInfo();
    localTrackInfo.setTrack(localAssetTrack);
    localTrackInfo.setSelectedTimeRange(getSourceTimeRange());
    localTrackInfo.setScaleToDuration(getScaledDuration());
    AppMethodBeat.o(192083);
    return localTrackInfo;
  }
  
  public List<AssetTrack> tracksForType(int paramInt)
  {
    AppMethodBeat.i(192082);
    if (this.asset != null)
    {
      localObject = this.asset.tracksWithMediaType(paramInt);
      AppMethodBeat.o(192082);
      return localObject;
    }
    Object localObject = new ArrayList();
    AppMethodBeat.o(192082);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tavkit.composition.resource.TAVAssetTrackResource
 * JD-Core Version:    0.7.0.1
 */