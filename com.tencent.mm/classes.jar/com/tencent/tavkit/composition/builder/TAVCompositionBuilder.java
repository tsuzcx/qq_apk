package com.tencent.tavkit.composition.builder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.MutableComposition;
import com.tencent.tav.core.AudioMix;
import com.tencent.tav.core.AudioMixInputParameters;
import com.tencent.tav.core.MutableAudioMix;
import com.tencent.tav.core.composition.MutableVideoComposition;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavkit.composition.video.TAVVideoCompositing;
import com.tencent.tavkit.utils.CompositionUtils;
import java.util.Iterator;
import java.util.List;

public class TAVCompositionBuilder
{
  private static final String TAG = "TAVCompositionBuilder";
  private final BuilderModel builderModel;
  private boolean isAudioTracksMerge;
  private boolean isReloadChannels;
  private boolean isVideoTracksMerge;
  
  public TAVCompositionBuilder(TAVComposition paramTAVComposition)
  {
    AppMethodBeat.i(218802);
    this.isVideoTracksMerge = true;
    this.isAudioTracksMerge = true;
    this.isReloadChannels = true;
    this.builderModel = new BuilderModel(paramTAVComposition);
    AppMethodBeat.o(218802);
  }
  
  private AudioMix<? extends AudioMixInputParameters> buildAudioMix()
  {
    AppMethodBeat.i(218826);
    Object localObject = new AudioParamsBuilder(this.builderModel).build();
    if (((List)localObject).size() == 0)
    {
      AppMethodBeat.o(218826);
      return null;
    }
    localObject = new MutableAudioMix((List)localObject);
    AppMethodBeat.o(218826);
    return localObject;
  }
  
  private Asset buildComposition()
  {
    AppMethodBeat.i(218806);
    if (this.isReloadChannels) {
      reloadChannels();
    }
    MutableComposition localMutableComposition = new CompositionBuilder(this.builderModel, this.isVideoTracksMerge, this.isAudioTracksMerge).build();
    AppMethodBeat.o(218806);
    return localMutableComposition;
  }
  
  private VideoComposition buildVideoComposition()
  {
    AppMethodBeat.i(218820);
    MutableVideoComposition localMutableVideoComposition = new MutableVideoComposition();
    localMutableVideoComposition.setFrameDuration(new CMTime(1L, 30));
    localMutableVideoComposition.setRenderSize(this.builderModel.getRenderSize());
    localMutableVideoComposition.setRenderLayoutMode(this.builderModel.getRenderLayoutMode());
    localMutableVideoComposition.setCustomVideoCompositorClass(TAVVideoCompositing.class);
    localMutableVideoComposition.setInstructions(new VideoInstructionsBuilder(this.builderModel).build());
    AppMethodBeat.o(218820);
    return localMutableVideoComposition;
  }
  
  private void reloadChannels()
  {
    AppMethodBeat.i(218813);
    Iterator localIterator = this.builderModel.getVideoChannels().iterator();
    while (localIterator.hasNext()) {
      CompositionUtils.reloadVideoStartTimeWithTransitionableVideo((List)localIterator.next());
    }
    Logger.d("TAVCompositionBuilder", "buildComposition: reloadVideoChannels = " + this.builderModel.getVideoChannels());
    localIterator = this.builderModel.getAudioChannels().iterator();
    while (localIterator.hasNext()) {
      CompositionUtils.reloadAudioStartTimeWithTransitionableAudio((List)localIterator.next());
    }
    Logger.d("TAVCompositionBuilder", "buildComposition: reloadAudioChannels = " + this.builderModel.getAudioChannels());
    AppMethodBeat.o(218813);
  }
  
  public TAVSource buildSource()
  {
    AppMethodBeat.i(218847);
    Logger.i("TAVCompositionBuilder", "buildSource: begin, tavComposition = " + this.builderModel.getTavComposition());
    TAVSource localTAVSource = new TAVSource();
    localTAVSource.setAsset(buildComposition());
    localTAVSource.setVideoComposition(buildVideoComposition());
    localTAVSource.setAudioMix(buildAudioMix());
    Logger.i("TAVCompositionBuilder", "buildSource: end, return source = ".concat(String.valueOf(localTAVSource)));
    AppMethodBeat.o(218847);
    return localTAVSource;
  }
  
  public void setAudioTracksMerge(boolean paramBoolean)
  {
    this.isAudioTracksMerge = paramBoolean;
  }
  
  public void setReloadChannels(boolean paramBoolean)
  {
    this.isReloadChannels = paramBoolean;
  }
  
  public void setVideoTracksMerge(boolean paramBoolean)
  {
    this.isVideoTracksMerge = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tavkit.composition.builder.TAVCompositionBuilder
 * JD-Core Version:    0.7.0.1
 */