package com.tencent.tavkit.composition;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.CompositionTrack;
import com.tencent.tav.asset.MutableComposition;
import com.tencent.tav.asset.MutableCompositionTrack;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.audio.TAVAudioTransition;
import com.tencent.tavkit.composition.model.TAVAudioConfiguration;
import com.tencent.tavkit.composition.model.TAVTransition;
import com.tencent.tavkit.composition.model.TAVTransitionableAudio;
import com.tencent.tavkit.composition.model.TAVTransitionableVideo;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration;
import com.tencent.tavkit.composition.resource.TAVAssetTrackResource;
import com.tencent.tavkit.composition.resource.TAVEmptyResource;
import com.tencent.tavkit.composition.resource.TAVImageResource;
import com.tencent.tavkit.composition.resource.TAVResource;
import com.tencent.tavkit.composition.resource.TrackInfo;
import com.tencent.tavkit.composition.video.TAVVideoTransition;
import com.tencent.tavkit.utils.CompositionUtils;
import java.util.HashMap;
import java.util.List;

public class TAVClip
  implements TAVTransitionableAudio, TAVTransitionableVideo, Cloneable
{
  private final String TAG;
  private TAVAudioConfiguration audioConfiguration;
  private HashMap<String, Object> extraTrackInfoMap;
  private TAVResource resource;
  private CMTime startTime;
  private TAVTransition transition;
  private TAVVideoConfiguration videoConfiguration;
  
  public TAVClip()
  {
    AppMethodBeat.i(191967);
    this.TAG = ("TAVClip@" + Integer.toHexString(hashCode()));
    this.extraTrackInfoMap = new HashMap();
    this.startTime = CMTime.CMTimeZero;
    this.audioConfiguration = new TAVAudioConfiguration();
    this.videoConfiguration = new TAVVideoConfiguration();
    AppMethodBeat.o(191967);
  }
  
  public TAVClip(Asset paramAsset)
  {
    this(new TAVAssetTrackResource(paramAsset));
    AppMethodBeat.i(191968);
    AppMethodBeat.o(191968);
  }
  
  public TAVClip(CMTime paramCMTime)
  {
    this(paramCMTime, false);
  }
  
  public TAVClip(CMTime paramCMTime, boolean paramBoolean)
  {
    this(new TAVEmptyResource(paramCMTime, paramBoolean));
    AppMethodBeat.i(191970);
    AppMethodBeat.o(191970);
  }
  
  public TAVClip(CIImage paramCIImage, CMTime paramCMTime)
  {
    this(new TAVImageResource(paramCIImage, paramCMTime));
    AppMethodBeat.i(191969);
    AppMethodBeat.o(191969);
  }
  
  public TAVClip(TAVResource paramTAVResource)
  {
    this();
    this.resource = paramTAVResource;
  }
  
  public CompositionTrack audioCompositionTrackForComposition(MutableComposition paramMutableComposition, int paramInt, boolean paramBoolean)
  {
    MutableCompositionTrack localMutableCompositionTrack = null;
    AppMethodBeat.i(191979);
    TrackInfo localTrackInfo = this.resource.trackInfoForType(2, paramInt);
    if (localTrackInfo == null)
    {
      AppMethodBeat.o(191979);
      return null;
    }
    CMTimeRange localCMTimeRange = new CMTimeRange(this.startTime, localTrackInfo.getScaleToDuration());
    if (paramBoolean) {
      localMutableCompositionTrack = CompositionUtils.mutableTrackCompatibleWithTimeRange(paramMutableComposition, localCMTimeRange, 2);
    }
    if ((localMutableCompositionTrack == null) && (localTrackInfo.getMediaType() != 0)) {
      localMutableCompositionTrack = paramMutableComposition.addMutableTrackWithMediaType(localTrackInfo.getMediaType(), 0);
    }
    for (;;)
    {
      if (localMutableCompositionTrack != null) {
        CompositionUtils.insertTimeRangeToTrack(localTrackInfo, localMutableCompositionTrack, localCMTimeRange);
      }
      AppMethodBeat.o(191979);
      return localMutableCompositionTrack;
      Logger.e(this.TAG, "audioCompositionTrackForComposition: compositionTrack == null || info.getMediaType() == 0");
    }
  }
  
  public TAVClip clone()
  {
    AppMethodBeat.i(191976);
    TAVClip localTAVClip = new TAVClip();
    localTAVClip.resource = this.resource.clone();
    localTAVClip.videoConfiguration = this.videoConfiguration.clone();
    localTAVClip.audioConfiguration = this.audioConfiguration.clone();
    if (this.transition != null) {
      localTAVClip.transition = this.transition;
    }
    localTAVClip.extraTrackInfoMap = new HashMap(this.extraTrackInfoMap);
    AppMethodBeat.o(191976);
    return localTAVClip;
  }
  
  public void fitToSpeed(float paramFloat)
  {
    AppMethodBeat.i(191982);
    if (paramFloat == 0.0F)
    {
      AppMethodBeat.o(191982);
      return;
    }
    CMTime localCMTime = this.resource.getSourceTimeRange().getDuration();
    this.resource.setScaledDuration(localCMTime.multi(1.0F / paramFloat));
    AppMethodBeat.o(191982);
  }
  
  public TAVAudioConfiguration getAudioConfiguration()
  {
    return this.audioConfiguration;
  }
  
  public TAVAudioTransition getAudioTransition()
  {
    AppMethodBeat.i(191972);
    if (this.transition != null)
    {
      TAVAudioTransition localTAVAudioTransition = this.transition.getAudioTransition();
      AppMethodBeat.o(191972);
      return localTAVAudioTransition;
    }
    AppMethodBeat.o(191972);
    return null;
  }
  
  public CMTime getDuration()
  {
    AppMethodBeat.i(191984);
    CMTime localCMTime = this.resource.getScaledDuration();
    AppMethodBeat.o(191984);
    return localCMTime;
  }
  
  public Object getExtraTrackInfo(String paramString)
  {
    AppMethodBeat.i(191974);
    paramString = this.extraTrackInfoMap.get(paramString);
    AppMethodBeat.o(191974);
    return paramString;
  }
  
  public TAVResource getResource()
  {
    return this.resource;
  }
  
  public CMTime getStartTime()
  {
    return this.startTime;
  }
  
  public CMTimeRange getTargetTimeRange()
  {
    AppMethodBeat.i(191987);
    CMTimeRange localCMTimeRange = new CMTimeRange(this.startTime, getDuration());
    AppMethodBeat.o(191987);
    return localCMTimeRange;
  }
  
  public CMTimeRange getTimeRange()
  {
    AppMethodBeat.i(191986);
    CMTimeRange localCMTimeRange = getTargetTimeRange();
    AppMethodBeat.o(191986);
    return localCMTimeRange;
  }
  
  public TAVTransition getTransition()
  {
    return this.transition;
  }
  
  public TAVVideoConfiguration getVideoConfiguration()
  {
    return this.videoConfiguration;
  }
  
  public TAVVideoTransition getVideoTransition()
  {
    AppMethodBeat.i(191973);
    if (this.transition != null)
    {
      TAVVideoTransition localTAVVideoTransition = this.transition.getVideoTransition();
      AppMethodBeat.o(191973);
      return localTAVVideoTransition;
    }
    AppMethodBeat.o(191973);
    return null;
  }
  
  public int numberOfAudioTracks()
  {
    AppMethodBeat.i(191978);
    int i = this.resource.tracksForType(2).size();
    AppMethodBeat.o(191978);
    return i;
  }
  
  public int numberOfVideoTracks()
  {
    AppMethodBeat.i(191980);
    int i = this.resource.tracksForType(1).size();
    AppMethodBeat.o(191980);
    return i;
  }
  
  public void putExtraTrackInfo(String paramString, Object paramObject)
  {
    AppMethodBeat.i(191975);
    this.extraTrackInfoMap.put(paramString, paramObject);
    AppMethodBeat.o(191975);
  }
  
  public void setAudioConfiguration(TAVAudioConfiguration paramTAVAudioConfiguration)
  {
    this.audioConfiguration = paramTAVAudioConfiguration;
  }
  
  public void setDuration(CMTime paramCMTime)
  {
    AppMethodBeat.i(191985);
    this.resource.setScaledDuration(paramCMTime);
    AppMethodBeat.o(191985);
  }
  
  public void setResource(TAVResource paramTAVResource)
  {
    this.resource = paramTAVResource;
  }
  
  public void setStartTime(CMTime paramCMTime)
  {
    AppMethodBeat.i(191971);
    this.startTime = paramCMTime;
    if (this.videoConfiguration != null) {
      this.videoConfiguration.updateTimeRange(getTimeRange());
    }
    AppMethodBeat.o(191971);
  }
  
  public void setTransition(TAVTransition paramTAVTransition)
  {
    this.transition = paramTAVTransition;
  }
  
  public void setVideoConfiguration(TAVVideoConfiguration paramTAVVideoConfiguration)
  {
    this.videoConfiguration = paramTAVVideoConfiguration;
  }
  
  public CIImage sourceImageAtTime(CMTime paramCMTime, CGSize paramCGSize)
  {
    AppMethodBeat.i(191983);
    paramCMTime = this.resource.imageAtTime(paramCMTime, paramCGSize);
    AppMethodBeat.o(191983);
    return paramCMTime;
  }
  
  public String toString()
  {
    AppMethodBeat.i(191977);
    String str = "TAVClip{resource=" + this.resource + ", videoConfiguration=" + this.videoConfiguration + ", startTime=" + this.startTime + ", transition=" + this.transition + ", extraTrackInfoMap=" + this.extraTrackInfoMap + '}';
    AppMethodBeat.o(191977);
    return str;
  }
  
  public CompositionTrack videoCompositionTrackForComposition(MutableComposition paramMutableComposition, int paramInt, boolean paramBoolean)
  {
    MutableCompositionTrack localMutableCompositionTrack = null;
    AppMethodBeat.i(191981);
    TrackInfo localTrackInfo = this.resource.trackInfoForType(1, paramInt);
    if (localTrackInfo == null)
    {
      AppMethodBeat.o(191981);
      return null;
    }
    CMTimeRange localCMTimeRange = new CMTimeRange(this.startTime, localTrackInfo.getScaleToDuration());
    if (paramBoolean) {
      localMutableCompositionTrack = CompositionUtils.mutableTrackCompatibleWithTimeRange(paramMutableComposition, localCMTimeRange, 1);
    }
    if ((localMutableCompositionTrack == null) && (localTrackInfo.getMediaType() != 0)) {
      localMutableCompositionTrack = paramMutableComposition.addMutableTrackWithMediaType(localTrackInfo.getMediaType(), -1);
    }
    for (;;)
    {
      if (localMutableCompositionTrack != null) {
        CompositionUtils.insertTimeRangeToTrack(localTrackInfo, localMutableCompositionTrack, localCMTimeRange);
      }
      AppMethodBeat.o(191981);
      return localMutableCompositionTrack;
      Logger.e(this.TAG, "videoCompositionTrackForComposition: compositionTrack == null || info.getMediaType() == 0");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tavkit.composition.TAVClip
 * JD-Core Version:    0.7.0.1
 */