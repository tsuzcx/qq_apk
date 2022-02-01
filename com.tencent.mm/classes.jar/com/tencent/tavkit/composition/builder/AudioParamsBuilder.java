package com.tencent.tavkit.composition.builder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.CompositionTrack;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.audio.TAVAudioMixInputParameters;
import com.tencent.tavkit.composition.audio.TAVAudioTapProcessor;
import com.tencent.tavkit.composition.model.TAVAudio;
import com.tencent.tavkit.composition.model.TAVTransitionableAudio;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class AudioParamsBuilder
{
  private final BuilderModel builderModel;
  private final List<TAVAudioMixInputParameters> outputParams;
  
  AudioParamsBuilder(BuilderModel paramBuilderModel)
  {
    AppMethodBeat.i(192008);
    this.builderModel = paramBuilderModel;
    this.outputParams = new ArrayList();
    AppMethodBeat.o(192008);
  }
  
  private void buildAudioParametersByTrackInfo(AudioParamsInfo paramAudioParamsInfo)
  {
    AppMethodBeat.i(192012);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramAudioParamsInfo.audioInfos.iterator();
    while (localIterator.hasNext())
    {
      AudioInfo localAudioInfo = (AudioInfo)localIterator.next();
      int i = localAudioInfo.compositionTrack.getTrackID();
      TAVAudioMixInputParameters localTAVAudioMixInputParameters = (TAVAudioMixInputParameters)localHashMap.get(Integer.valueOf(i));
      paramAudioParamsInfo = localTAVAudioMixInputParameters;
      if (localTAVAudioMixInputParameters == null)
      {
        paramAudioParamsInfo = new TAVAudioMixInputParameters(localAudioInfo.compositionTrack);
        localHashMap.put(Integer.valueOf(i), paramAudioParamsInfo);
      }
      paramAudioParamsInfo.addAudioConfiguration(new CMTimeRange(localAudioInfo.audio.getStartTime(), localAudioInfo.audio.getDuration()), localAudioInfo.audio.getAudioConfiguration());
      paramAudioParamsInfo.setAudioTapProcessor(new TAVAudioTapProcessor(paramAudioParamsInfo.getAudioConfigurationSegmentList()));
    }
    this.outputParams.addAll(localHashMap.values());
    AppMethodBeat.o(192012);
  }
  
  private void buildBgAudioInputParameters()
  {
    AppMethodBeat.i(192010);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.builderModel.getAudioTrackInfo().iterator();
    while (localIterator.hasNext())
    {
      AudioMixInfo localAudioMixInfo = (AudioMixInfo)localIterator.next();
      int i = localAudioMixInfo.track.getTrackID();
      TAVAudioMixInputParameters localTAVAudioMixInputParameters2 = (TAVAudioMixInputParameters)localHashMap.get(Integer.valueOf(i));
      TAVAudioMixInputParameters localTAVAudioMixInputParameters1 = localTAVAudioMixInputParameters2;
      if (localTAVAudioMixInputParameters2 == null)
      {
        localTAVAudioMixInputParameters1 = new TAVAudioMixInputParameters(localAudioMixInfo.track);
        localHashMap.put(Integer.valueOf(i), localTAVAudioMixInputParameters1);
      }
      localTAVAudioMixInputParameters1.addAudioConfiguration(new CMTimeRange(localAudioMixInfo.audio.getStartTime(), localAudioMixInfo.audio.getDuration()), localAudioMixInfo.audio.getAudioConfiguration());
      localTAVAudioMixInputParameters1.setAudioTapProcessor(new TAVAudioTapProcessor(localTAVAudioMixInputParameters1.getAudioConfigurationSegmentList()));
    }
    this.outputParams.addAll(localHashMap.values());
    AppMethodBeat.o(192010);
  }
  
  private void buildMainAudioInputParameters()
  {
    AppMethodBeat.i(192011);
    List localList = this.builderModel.getMainAudioTrackInfo();
    int i = 0;
    while (i < localList.size())
    {
      buildAudioParametersByTrackInfo((AudioParamsInfo)localList.get(i));
      i += 1;
    }
    AppMethodBeat.o(192011);
  }
  
  List<TAVAudioMixInputParameters> build()
  {
    AppMethodBeat.i(192009);
    buildMainAudioInputParameters();
    buildBgAudioInputParameters();
    List localList = this.outputParams;
    AppMethodBeat.o(192009);
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tavkit.composition.builder.AudioParamsBuilder
 * JD-Core Version:    0.7.0.1
 */