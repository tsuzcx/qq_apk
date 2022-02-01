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
    AppMethodBeat.i(204641);
    this.tavComposition = paramTAVComposition;
    this.mainVideoTrackInfo = new ArrayList();
    this.mainAudioTrackInfo = new ArrayList();
    this.overlayTrackInfo = new ArrayList();
    this.audioTrackInfo = new ArrayList();
    AppMethodBeat.o(204641);
  }
  
  void addAudioTrackInfo(AudioMixInfo paramAudioMixInfo)
  {
    AppMethodBeat.i(204654);
    this.audioTrackInfo.add(paramAudioMixInfo);
    AppMethodBeat.o(204654);
  }
  
  void addMainAudioTrackInfo(AudioParamsInfo paramAudioParamsInfo)
  {
    AppMethodBeat.i(204652);
    this.mainAudioTrackInfo.add(paramAudioParamsInfo);
    AppMethodBeat.o(204652);
  }
  
  void addMainVideoTrackInfo(List<VideoInfo> paramList)
  {
    AppMethodBeat.i(204651);
    this.mainVideoTrackInfo.add(paramList);
    AppMethodBeat.o(204651);
  }
  
  void addOverlayTrackInfo(VideoOverlayInfo paramVideoOverlayInfo)
  {
    AppMethodBeat.i(204653);
    this.overlayTrackInfo.add(paramVideoOverlayInfo);
    AppMethodBeat.o(204653);
  }
  
  List<List<? extends TAVTransitionableAudio>> getAudioChannels()
  {
    AppMethodBeat.i(204643);
    List localList = this.tavComposition.getAudioChannels();
    AppMethodBeat.o(204643);
    return localList;
  }
  
  List<AudioMixInfo> getAudioTrackInfo()
  {
    return this.audioTrackInfo;
  }
  
  int getBackgroundColor()
  {
    AppMethodBeat.i(204646);
    int i = this.tavComposition.getBackgroundColor();
    AppMethodBeat.o(204646);
    return i;
  }
  
  TAVVideoEffect getGlobalVideoEffect()
  {
    AppMethodBeat.i(204649);
    TAVVideoEffect localTAVVideoEffect = this.tavComposition.getGlobalVideoEffect();
    AppMethodBeat.o(204649);
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
    AppMethodBeat.i(204645);
    List localList = this.tavComposition.getAudios();
    AppMethodBeat.o(204645);
    return localList;
  }
  
  public List<VideoOverlayInfo> getOverlayTrackInfo()
  {
    return this.overlayTrackInfo;
  }
  
  List<? extends TAVVideo> getOverlays()
  {
    AppMethodBeat.i(204644);
    List localList = this.tavComposition.getOverlays();
    AppMethodBeat.o(204644);
    return localList;
  }
  
  VideoComposition.RenderLayoutMode getRenderLayoutMode()
  {
    AppMethodBeat.i(204648);
    VideoComposition.RenderLayoutMode localRenderLayoutMode = this.tavComposition.getRenderLayoutMode();
    AppMethodBeat.o(204648);
    return localRenderLayoutMode;
  }
  
  CGSize getRenderSize()
  {
    AppMethodBeat.i(204647);
    CGSize localCGSize = this.tavComposition.getRenderSize();
    AppMethodBeat.o(204647);
    return localCGSize;
  }
  
  public TAVComposition getTavComposition()
  {
    return this.tavComposition;
  }
  
  List<List<? extends TAVTransitionableVideo>> getVideoChannels()
  {
    AppMethodBeat.i(204642);
    List localList = this.tavComposition.getVideoChannels();
    AppMethodBeat.o(204642);
    return localList;
  }
  
  public TAVVideoMixEffect getVideoMixEffect()
  {
    AppMethodBeat.i(204650);
    TAVVideoMixEffect localTAVVideoMixEffect = this.tavComposition.getVideoMixEffect();
    AppMethodBeat.o(204650);
    return localTAVVideoMixEffect;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tavkit.composition.builder.BuilderModel
 * JD-Core Version:    0.7.0.1
 */