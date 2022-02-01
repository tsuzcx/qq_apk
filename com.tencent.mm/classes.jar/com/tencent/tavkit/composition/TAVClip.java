package com.tencent.tavkit.composition;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.CompositionTrack;
import com.tencent.tav.asset.MutableComposition;
import com.tencent.tav.asset.MutableCompositionTrack;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
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
    AppMethodBeat.i(218758);
    this.TAG = ("TAVClip@" + Integer.toHexString(hashCode()));
    this.extraTrackInfoMap = new HashMap();
    this.startTime = CMTime.CMTimeZero;
    this.audioConfiguration = new TAVAudioConfiguration();
    this.videoConfiguration = new TAVVideoConfiguration();
    AppMethodBeat.o(218758);
  }
  
  public TAVClip(Asset paramAsset)
  {
    this(new TAVAssetTrackResource(paramAsset));
    AppMethodBeat.i(218777);
    AppMethodBeat.o(218777);
  }
  
  public TAVClip(CMTime paramCMTime)
  {
    this(paramCMTime, false);
  }
  
  public TAVClip(CMTime paramCMTime, boolean paramBoolean)
  {
    this(new TAVEmptyResource(paramCMTime, paramBoolean));
    AppMethodBeat.i(218795);
    AppMethodBeat.o(218795);
  }
  
  public TAVClip(CIImage paramCIImage, CMTime paramCMTime)
  {
    this(new TAVImageResource(paramCIImage, paramCMTime));
    AppMethodBeat.i(218786);
    AppMethodBeat.o(218786);
  }
  
  public TAVClip(TAVResource paramTAVResource)
  {
    this();
    this.resource = paramTAVResource;
  }
  
  public CompositionTrack audioCompositionTrackForComposition(MutableComposition paramMutableComposition, int paramInt, boolean paramBoolean)
  {
    MutableCompositionTrack localMutableCompositionTrack1 = null;
    AppMethodBeat.i(218910);
    TrackInfo localTrackInfo = this.resource.trackInfoForType(2, paramInt);
    if (localTrackInfo == null)
    {
      AppMethodBeat.o(218910);
      return null;
    }
    CMTimeRange localCMTimeRange = new CMTimeRange(this.startTime, localTrackInfo.getScaleToDuration());
    if (paramBoolean) {
      localMutableCompositionTrack1 = CompositionUtils.mutableTrackCompatibleWithTimeRange(paramMutableComposition, localCMTimeRange, 2);
    }
    MutableCompositionTrack localMutableCompositionTrack2 = localMutableCompositionTrack1;
    if (localMutableCompositionTrack1 == null)
    {
      localMutableCompositionTrack2 = localMutableCompositionTrack1;
      if (localTrackInfo.getMediaType() != 0) {
        localMutableCompositionTrack2 = paramMutableComposition.addMutableTrackWithMediaType(localTrackInfo.getMediaType(), 0);
      }
    }
    if (localMutableCompositionTrack2 != null) {
      CompositionUtils.insertTimeRangeToTrack(localTrackInfo, localMutableCompositionTrack2, localCMTimeRange);
    }
    AppMethodBeat.o(218910);
    return localMutableCompositionTrack2;
  }
  
  public TAVClip clone()
  {
    AppMethodBeat.i(218881);
    TAVClip localTAVClip = new TAVClip();
    localTAVClip.resource = this.resource.clone();
    localTAVClip.videoConfiguration = this.videoConfiguration.clone();
    localTAVClip.audioConfiguration = this.audioConfiguration.clone();
    if (this.transition != null) {
      localTAVClip.transition = this.transition;
    }
    localTAVClip.extraTrackInfoMap = new HashMap(this.extraTrackInfoMap);
    AppMethodBeat.o(218881);
    return localTAVClip;
  }
  
  public void fitToSpeed(float paramFloat)
  {
    AppMethodBeat.i(218933);
    if (paramFloat == 0.0F)
    {
      AppMethodBeat.o(218933);
      return;
    }
    CMTime localCMTime = this.resource.getSourceTimeRange().getDuration();
    this.resource.setScaledDuration(localCMTime.multi(1.0F / paramFloat));
    AppMethodBeat.o(218933);
  }
  
  public TAVAudioConfiguration getAudioConfiguration()
  {
    return this.audioConfiguration;
  }
  
  public TAVAudioTransition getAudioTransition()
  {
    AppMethodBeat.i(218849);
    if (this.transition != null)
    {
      TAVAudioTransition localTAVAudioTransition = this.transition.getAudioTransition();
      AppMethodBeat.o(218849);
      return localTAVAudioTransition;
    }
    AppMethodBeat.o(218849);
    return null;
  }
  
  public CMTime getDuration()
  {
    AppMethodBeat.i(218945);
    CMTime localCMTime = this.resource.getScaledDuration();
    AppMethodBeat.o(218945);
    return localCMTime;
  }
  
  public Object getExtraTrackInfo(String paramString)
  {
    AppMethodBeat.i(218863);
    paramString = this.extraTrackInfoMap.get(paramString);
    AppMethodBeat.o(218863);
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
    AppMethodBeat.i(218963);
    CMTimeRange localCMTimeRange = new CMTimeRange(this.startTime, getDuration());
    AppMethodBeat.o(218963);
    return localCMTimeRange;
  }
  
  public CMTimeRange getTimeRange()
  {
    AppMethodBeat.i(218958);
    CMTimeRange localCMTimeRange = getTargetTimeRange();
    AppMethodBeat.o(218958);
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
    AppMethodBeat.i(218854);
    if (this.transition != null)
    {
      TAVVideoTransition localTAVVideoTransition = this.transition.getVideoTransition();
      AppMethodBeat.o(218854);
      return localTAVVideoTransition;
    }
    AppMethodBeat.o(218854);
    return null;
  }
  
  public int numberOfAudioTracks()
  {
    AppMethodBeat.i(218899);
    int i = this.resource.tracksForType(2).size();
    AppMethodBeat.o(218899);
    return i;
  }
  
  public int numberOfVideoTracks()
  {
    AppMethodBeat.i(218916);
    int i = this.resource.tracksForType(1).size();
    AppMethodBeat.o(218916);
    return i;
  }
  
  public void putExtraTrackInfo(String paramString, Object paramObject)
  {
    AppMethodBeat.i(218870);
    this.extraTrackInfoMap.put(paramString, paramObject);
    AppMethodBeat.o(218870);
  }
  
  public void setAudioConfiguration(TAVAudioConfiguration paramTAVAudioConfiguration)
  {
    this.audioConfiguration = paramTAVAudioConfiguration;
  }
  
  public void setDuration(CMTime paramCMTime)
  {
    AppMethodBeat.i(218952);
    this.resource.setScaledDuration(paramCMTime);
    AppMethodBeat.o(218952);
  }
  
  public void setResource(TAVResource paramTAVResource)
  {
    this.resource = paramTAVResource;
  }
  
  public void setStartTime(CMTime paramCMTime)
  {
    AppMethodBeat.i(218835);
    this.startTime = paramCMTime;
    if (this.videoConfiguration != null) {
      this.videoConfiguration.updateTimeRange(getTimeRange());
    }
    AppMethodBeat.o(218835);
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
    AppMethodBeat.i(218940);
    paramCMTime = this.resource.imageAtTime(paramCMTime, paramCGSize);
    AppMethodBeat.o(218940);
    return paramCMTime;
  }
  
  public String toString()
  {
    AppMethodBeat.i(218890);
    String str = "TAVClip{resource=" + this.resource + ", videoConfiguration=" + this.videoConfiguration + ", startTime=" + this.startTime + ", transition=" + this.transition + ", extraTrackInfoMap=" + this.extraTrackInfoMap + '}';
    AppMethodBeat.o(218890);
    return str;
  }
  
  public CompositionTrack videoCompositionTrackForComposition(MutableComposition paramMutableComposition, int paramInt, boolean paramBoolean)
  {
    MutableCompositionTrack localMutableCompositionTrack1 = null;
    AppMethodBeat.i(218925);
    TrackInfo localTrackInfo = this.resource.trackInfoForType(1, paramInt);
    if (localTrackInfo == null)
    {
      AppMethodBeat.o(218925);
      return null;
    }
    CMTimeRange localCMTimeRange = new CMTimeRange(this.startTime, localTrackInfo.getScaleToDuration());
    if (paramBoolean) {
      localMutableCompositionTrack1 = CompositionUtils.mutableTrackCompatibleWithTimeRange(paramMutableComposition, localCMTimeRange, 1);
    }
    MutableCompositionTrack localMutableCompositionTrack2 = localMutableCompositionTrack1;
    if (localMutableCompositionTrack1 == null)
    {
      localMutableCompositionTrack2 = localMutableCompositionTrack1;
      if (localTrackInfo.getMediaType() != 0) {
        localMutableCompositionTrack2 = paramMutableComposition.addMutableTrackWithMediaType(localTrackInfo.getMediaType(), -1);
      }
    }
    if (localMutableCompositionTrack2 != null) {
      CompositionUtils.insertTimeRangeToTrack(localTrackInfo, localMutableCompositionTrack2, localCMTimeRange);
    }
    AppMethodBeat.o(218925);
    return localMutableCompositionTrack2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tavkit.composition.TAVClip
 * JD-Core Version:    0.7.0.1
 */