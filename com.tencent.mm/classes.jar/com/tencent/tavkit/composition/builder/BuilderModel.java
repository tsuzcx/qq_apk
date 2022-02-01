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
    AppMethodBeat.i(200841);
    this.tavComposition = paramTAVComposition;
    this.mainVideoTrackInfo = new ArrayList();
    this.mainAudioTrackInfo = new ArrayList();
    this.overlayTrackInfo = new ArrayList();
    this.audioTrackInfo = new ArrayList();
    AppMethodBeat.o(200841);
  }
  
  void addAudioTrackInfo(AudioMixInfo paramAudioMixInfo)
  {
    AppMethodBeat.i(200854);
    this.audioTrackInfo.add(paramAudioMixInfo);
    AppMethodBeat.o(200854);
  }
  
  void addMainAudioTrackInfo(AudioParamsInfo paramAudioParamsInfo)
  {
    AppMethodBeat.i(200852);
    this.mainAudioTrackInfo.add(paramAudioParamsInfo);
    AppMethodBeat.o(200852);
  }
  
  void addMainVideoTrackInfo(List<VideoInfo> paramList)
  {
    AppMethodBeat.i(200851);
    this.mainVideoTrackInfo.add(paramList);
    AppMethodBeat.o(200851);
  }
  
  void addOverlayTrackInfo(VideoOverlayInfo paramVideoOverlayInfo)
  {
    AppMethodBeat.i(200853);
    this.overlayTrackInfo.add(paramVideoOverlayInfo);
    AppMethodBeat.o(200853);
  }
  
  List<List<? extends TAVTransitionableAudio>> getAudioChannels()
  {
    AppMethodBeat.i(200843);
    List localList = this.tavComposition.getAudioChannels();
    AppMethodBeat.o(200843);
    return localList;
  }
  
  List<AudioMixInfo> getAudioTrackInfo()
  {
    return this.audioTrackInfo;
  }
  
  int getBackgroundColor()
  {
    AppMethodBeat.i(200846);
    int i = this.tavComposition.getBackgroundColor();
    AppMethodBeat.o(200846);
    return i;
  }
  
  TAVVideoEffect getGlobalVideoEffect()
  {
    AppMethodBeat.i(200849);
    TAVVideoEffect localTAVVideoEffect = this.tavComposition.getGlobalVideoEffect();
    AppMethodBeat.o(200849);
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
    AppMethodBeat.i(200845);
    List localList = this.tavComposition.getAudios();
    AppMethodBeat.o(200845);
    return localList;
  }
  
  public List<VideoOverlayInfo> getOverlayTrackInfo()
  {
    return this.overlayTrackInfo;
  }
  
  List<? extends TAVVideo> getOverlays()
  {
    AppMethodBeat.i(200844);
    List localList = this.tavComposition.getOverlays();
    AppMethodBeat.o(200844);
    return localList;
  }
  
  VideoComposition.RenderLayoutMode getRenderLayoutMode()
  {
    AppMethodBeat.i(200848);
    VideoComposition.RenderLayoutMode localRenderLayoutMode = this.tavComposition.getRenderLayoutMode();
    AppMethodBeat.o(200848);
    return localRenderLayoutMode;
  }
  
  CGSize getRenderSize()
  {
    AppMethodBeat.i(200847);
    CGSize localCGSize = this.tavComposition.getRenderSize();
    AppMethodBeat.o(200847);
    return localCGSize;
  }
  
  public TAVComposition getTavComposition()
  {
    return this.tavComposition;
  }
  
  List<List<? extends TAVTransitionableVideo>> getVideoChannels()
  {
    AppMethodBeat.i(200842);
    List localList = this.tavComposition.getVideoChannels();
    AppMethodBeat.o(200842);
    return localList;
  }
  
  public TAVVideoMixEffect getVideoMixEffect()
  {
    AppMethodBeat.i(200850);
    TAVVideoMixEffect localTAVVideoMixEffect = this.tavComposition.getVideoMixEffect();
    AppMethodBeat.o(200850);
    return localTAVVideoMixEffect;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tavkit.composition.builder.BuilderModel
 * JD-Core Version:    0.7.0.1
 */