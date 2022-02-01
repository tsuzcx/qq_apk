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
    AppMethodBeat.i(197511);
    this.tavComposition = paramTAVComposition;
    this.mainVideoTrackInfo = new ArrayList();
    this.mainAudioTrackInfo = new ArrayList();
    this.overlayTrackInfo = new ArrayList();
    this.audioTrackInfo = new ArrayList();
    AppMethodBeat.o(197511);
  }
  
  void addAudioTrackInfo(AudioMixInfo paramAudioMixInfo)
  {
    AppMethodBeat.i(197524);
    this.audioTrackInfo.add(paramAudioMixInfo);
    AppMethodBeat.o(197524);
  }
  
  void addMainAudioTrackInfo(AudioParamsInfo paramAudioParamsInfo)
  {
    AppMethodBeat.i(197522);
    this.mainAudioTrackInfo.add(paramAudioParamsInfo);
    AppMethodBeat.o(197522);
  }
  
  void addMainVideoTrackInfo(List<VideoInfo> paramList)
  {
    AppMethodBeat.i(197521);
    this.mainVideoTrackInfo.add(paramList);
    AppMethodBeat.o(197521);
  }
  
  void addOverlayTrackInfo(VideoOverlayInfo paramVideoOverlayInfo)
  {
    AppMethodBeat.i(197523);
    this.overlayTrackInfo.add(paramVideoOverlayInfo);
    AppMethodBeat.o(197523);
  }
  
  List<List<? extends TAVTransitionableAudio>> getAudioChannels()
  {
    AppMethodBeat.i(197513);
    List localList = this.tavComposition.getAudioChannels();
    AppMethodBeat.o(197513);
    return localList;
  }
  
  List<AudioMixInfo> getAudioTrackInfo()
  {
    return this.audioTrackInfo;
  }
  
  int getBackgroundColor()
  {
    AppMethodBeat.i(197516);
    int i = this.tavComposition.getBackgroundColor();
    AppMethodBeat.o(197516);
    return i;
  }
  
  TAVVideoEffect getGlobalVideoEffect()
  {
    AppMethodBeat.i(197519);
    TAVVideoEffect localTAVVideoEffect = this.tavComposition.getGlobalVideoEffect();
    AppMethodBeat.o(197519);
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
    AppMethodBeat.i(197515);
    List localList = this.tavComposition.getAudios();
    AppMethodBeat.o(197515);
    return localList;
  }
  
  public List<VideoOverlayInfo> getOverlayTrackInfo()
  {
    return this.overlayTrackInfo;
  }
  
  List<? extends TAVVideo> getOverlays()
  {
    AppMethodBeat.i(197514);
    List localList = this.tavComposition.getOverlays();
    AppMethodBeat.o(197514);
    return localList;
  }
  
  VideoComposition.RenderLayoutMode getRenderLayoutMode()
  {
    AppMethodBeat.i(197518);
    VideoComposition.RenderLayoutMode localRenderLayoutMode = this.tavComposition.getRenderLayoutMode();
    AppMethodBeat.o(197518);
    return localRenderLayoutMode;
  }
  
  CGSize getRenderSize()
  {
    AppMethodBeat.i(197517);
    CGSize localCGSize = this.tavComposition.getRenderSize();
    AppMethodBeat.o(197517);
    return localCGSize;
  }
  
  public TAVComposition getTavComposition()
  {
    return this.tavComposition;
  }
  
  List<List<? extends TAVTransitionableVideo>> getVideoChannels()
  {
    AppMethodBeat.i(197512);
    List localList = this.tavComposition.getVideoChannels();
    AppMethodBeat.o(197512);
    return localList;
  }
  
  public TAVVideoMixEffect getVideoMixEffect()
  {
    AppMethodBeat.i(197520);
    TAVVideoMixEffect localTAVVideoMixEffect = this.tavComposition.getVideoMixEffect();
    AppMethodBeat.o(197520);
    return localTAVVideoMixEffect;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tavkit.composition.builder.BuilderModel
 * JD-Core Version:    0.7.0.1
 */