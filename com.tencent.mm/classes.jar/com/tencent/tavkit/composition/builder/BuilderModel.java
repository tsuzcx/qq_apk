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
    AppMethodBeat.i(192013);
    this.tavComposition = paramTAVComposition;
    this.mainVideoTrackInfo = new ArrayList();
    this.mainAudioTrackInfo = new ArrayList();
    this.overlayTrackInfo = new ArrayList();
    this.audioTrackInfo = new ArrayList();
    AppMethodBeat.o(192013);
  }
  
  void addAudioTrackInfo(AudioMixInfo paramAudioMixInfo)
  {
    AppMethodBeat.i(192026);
    this.audioTrackInfo.add(paramAudioMixInfo);
    AppMethodBeat.o(192026);
  }
  
  void addMainAudioTrackInfo(AudioParamsInfo paramAudioParamsInfo)
  {
    AppMethodBeat.i(192024);
    this.mainAudioTrackInfo.add(paramAudioParamsInfo);
    AppMethodBeat.o(192024);
  }
  
  void addMainVideoTrackInfo(List<VideoInfo> paramList)
  {
    AppMethodBeat.i(192023);
    this.mainVideoTrackInfo.add(paramList);
    AppMethodBeat.o(192023);
  }
  
  void addOverlayTrackInfo(VideoOverlayInfo paramVideoOverlayInfo)
  {
    AppMethodBeat.i(192025);
    this.overlayTrackInfo.add(paramVideoOverlayInfo);
    AppMethodBeat.o(192025);
  }
  
  List<List<? extends TAVTransitionableAudio>> getAudioChannels()
  {
    AppMethodBeat.i(192015);
    List localList = this.tavComposition.getAudioChannels();
    AppMethodBeat.o(192015);
    return localList;
  }
  
  List<AudioMixInfo> getAudioTrackInfo()
  {
    return this.audioTrackInfo;
  }
  
  int getBackgroundColor()
  {
    AppMethodBeat.i(192018);
    int i = this.tavComposition.getBackgroundColor();
    AppMethodBeat.o(192018);
    return i;
  }
  
  TAVVideoEffect getGlobalVideoEffect()
  {
    AppMethodBeat.i(192021);
    TAVVideoEffect localTAVVideoEffect = this.tavComposition.getGlobalVideoEffect();
    AppMethodBeat.o(192021);
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
    AppMethodBeat.i(192017);
    List localList = this.tavComposition.getAudios();
    AppMethodBeat.o(192017);
    return localList;
  }
  
  public List<VideoOverlayInfo> getOverlayTrackInfo()
  {
    return this.overlayTrackInfo;
  }
  
  List<? extends TAVVideo> getOverlays()
  {
    AppMethodBeat.i(192016);
    List localList = this.tavComposition.getOverlays();
    AppMethodBeat.o(192016);
    return localList;
  }
  
  VideoComposition.RenderLayoutMode getRenderLayoutMode()
  {
    AppMethodBeat.i(192020);
    VideoComposition.RenderLayoutMode localRenderLayoutMode = this.tavComposition.getRenderLayoutMode();
    AppMethodBeat.o(192020);
    return localRenderLayoutMode;
  }
  
  CGSize getRenderSize()
  {
    AppMethodBeat.i(192019);
    CGSize localCGSize = this.tavComposition.getRenderSize();
    AppMethodBeat.o(192019);
    return localCGSize;
  }
  
  public TAVComposition getTavComposition()
  {
    return this.tavComposition;
  }
  
  List<List<? extends TAVTransitionableVideo>> getVideoChannels()
  {
    AppMethodBeat.i(192014);
    List localList = this.tavComposition.getVideoChannels();
    AppMethodBeat.o(192014);
    return localList;
  }
  
  public TAVVideoMixEffect getVideoMixEffect()
  {
    AppMethodBeat.i(192022);
    TAVVideoMixEffect localTAVVideoMixEffect = this.tavComposition.getVideoMixEffect();
    AppMethodBeat.o(192022);
    return localTAVVideoMixEffect;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tavkit.composition.builder.BuilderModel
 * JD-Core Version:    0.7.0.1
 */