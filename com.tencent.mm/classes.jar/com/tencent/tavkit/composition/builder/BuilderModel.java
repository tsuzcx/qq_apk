package com.tencent.tavkit.composition.builder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.core.composition.VideoComposition.RenderLayoutMode;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.model.TAVAudio;
import com.tencent.tavkit.composition.model.TAVTransitionableAudio;
import com.tencent.tavkit.composition.model.TAVTransitionableVideo;
import com.tencent.tavkit.composition.model.TAVVideo;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import java.util.ArrayList;
import java.util.List;

class BuilderModel
{
  private final List<AudioMixInfo> audioTrackInfo;
  private final List<AudioParamsInfo> mainAudioTrackInfo;
  private final List<List<VideoInfo>> mainVideoTrackInfo;
  private final List<VideoOverlayInfo> overlayTrackInfo;
  private final TAVComposition tavComposition;
  
  BuilderModel(TAVComposition paramTAVComposition)
  {
    AppMethodBeat.i(219810);
    this.tavComposition = paramTAVComposition;
    this.mainVideoTrackInfo = new ArrayList();
    this.mainAudioTrackInfo = new ArrayList();
    this.overlayTrackInfo = new ArrayList();
    this.audioTrackInfo = new ArrayList();
    AppMethodBeat.o(219810);
  }
  
  void addAudioTrackInfo(AudioMixInfo paramAudioMixInfo)
  {
    AppMethodBeat.i(219823);
    this.audioTrackInfo.add(paramAudioMixInfo);
    AppMethodBeat.o(219823);
  }
  
  void addMainAudioTrackInfo(AudioParamsInfo paramAudioParamsInfo)
  {
    AppMethodBeat.i(219821);
    this.mainAudioTrackInfo.add(paramAudioParamsInfo);
    AppMethodBeat.o(219821);
  }
  
  void addMainVideoTrackInfo(List<VideoInfo> paramList)
  {
    AppMethodBeat.i(219820);
    this.mainVideoTrackInfo.add(paramList);
    AppMethodBeat.o(219820);
  }
  
  void addOverlayTrackInfo(VideoOverlayInfo paramVideoOverlayInfo)
  {
    AppMethodBeat.i(219822);
    this.overlayTrackInfo.add(paramVideoOverlayInfo);
    AppMethodBeat.o(219822);
  }
  
  List<List<? extends TAVTransitionableAudio>> getAudioChannels()
  {
    AppMethodBeat.i(219812);
    List localList = this.tavComposition.getAudioChannels();
    AppMethodBeat.o(219812);
    return localList;
  }
  
  List<AudioMixInfo> getAudioTrackInfo()
  {
    return this.audioTrackInfo;
  }
  
  int getBackgroundColor()
  {
    AppMethodBeat.i(219815);
    int i = this.tavComposition.getBackgroundColor();
    AppMethodBeat.o(219815);
    return i;
  }
  
  TAVVideoEffect getGlobalVideoEffect()
  {
    AppMethodBeat.i(219818);
    TAVVideoEffect localTAVVideoEffect = this.tavComposition.getGlobalVideoEffect();
    AppMethodBeat.o(219818);
    return localTAVVideoEffect;
  }
  
  List<AudioParamsInfo> getMainAudioTrackInfo()
  {
    return this.mainAudioTrackInfo;
  }
  
  public List<List<VideoInfo>> getMainVideoTrackInfo()
  {
    return this.mainVideoTrackInfo;
  }
  
  List<? extends TAVAudio> getMixAudios()
  {
    AppMethodBeat.i(219814);
    List localList = this.tavComposition.getAudios();
    AppMethodBeat.o(219814);
    return localList;
  }
  
  public List<VideoOverlayInfo> getOverlayTrackInfo()
  {
    return this.overlayTrackInfo;
  }
  
  List<? extends TAVVideo> getOverlays()
  {
    AppMethodBeat.i(219813);
    List localList = this.tavComposition.getOverlays();
    AppMethodBeat.o(219813);
    return localList;
  }
  
  VideoComposition.RenderLayoutMode getRenderLayoutMode()
  {
    AppMethodBeat.i(219817);
    VideoComposition.RenderLayoutMode localRenderLayoutMode = this.tavComposition.getRenderLayoutMode();
    AppMethodBeat.o(219817);
    return localRenderLayoutMode;
  }
  
  CGSize getRenderSize()
  {
    AppMethodBeat.i(219816);
    CGSize localCGSize = this.tavComposition.getRenderSize();
    AppMethodBeat.o(219816);
    return localCGSize;
  }
  
  public TAVComposition getTavComposition()
  {
    return this.tavComposition;
  }
  
  List<List<? extends TAVTransitionableVideo>> getVideoChannels()
  {
    AppMethodBeat.i(219811);
    List localList = this.tavComposition.getVideoChannels();
    AppMethodBeat.o(219811);
    return localList;
  }
  
  public TAVVideoMixEffect getVideoMixEffect()
  {
    AppMethodBeat.i(219819);
    TAVVideoMixEffect localTAVVideoMixEffect = this.tavComposition.getVideoMixEffect();
    AppMethodBeat.o(219819);
    return localTAVVideoMixEffect;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tavkit.composition.builder.BuilderModel
 * JD-Core Version:    0.7.0.1
 */