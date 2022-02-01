package com.tencent.mm.videocomposition.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tavkit.composition.audio.TAVAudioProcessorNode;
import com.tencent.tavkit.composition.audio.TAVAudioProcessorNode.TAVAudioProcessorEffect;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/videocomposition/audio/AudioResampleProcessor;", "Lcom/tencent/mm/videocomposition/audio/IAudioProcessorFactory;", "resampleFactory", "Lcom/tencent/mm/videocomposition/audio/IAudioResampleFactory;", "(Lcom/tencent/mm/videocomposition/audio/IAudioResampleFactory;)V", "getResampleFactory", "()Lcom/tencent/mm/videocomposition/audio/IAudioResampleFactory;", "createAudioProcessorNode", "Lcom/tencent/tavkit/composition/audio/TAVAudioProcessorNode;", "track", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "video_composition_release"}, k=1, mv={1, 1, 15})
public final class a
  implements b
{
  final c agEe;
  
  public a(c paramc)
  {
    AppMethodBeat.i(233479);
    this.agEe = paramc;
    AppMethodBeat.o(233479);
  }
  
  public final TAVAudioProcessorNode h(final com.tencent.mm.videocomposition.b paramb)
  {
    AppMethodBeat.i(233485);
    s.t(paramb, "track");
    paramb = (TAVAudioProcessorNode)new a(this, paramb);
    AppMethodBeat.o(233485);
    return paramb;
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/videocomposition/audio/AudioResampleProcessor$createAudioProcessorNode$1", "Lcom/tencent/tavkit/composition/audio/TAVAudioProcessorNode;", "createAudioProcessor", "Lcom/tencent/tavkit/composition/audio/TAVAudioProcessorNode$TAVAudioProcessorEffect;", "getIdentifier", "", "video_composition_release"}, k=1, mv={1, 1, 15})
  public static final class a
    implements TAVAudioProcessorNode
  {
    a(com.tencent.mm.videocomposition.b paramb) {}
    
    public final TAVAudioProcessorNode.TAVAudioProcessorEffect createAudioProcessor()
    {
      AppMethodBeat.i(233496);
      TAVAudioProcessorNode.TAVAudioProcessorEffect localTAVAudioProcessorEffect = this.agEf.agEe.b(paramb);
      AppMethodBeat.o(233496);
      return localTAVAudioProcessorEffect;
    }
    
    public final String getIdentifier()
    {
      return paramb.path;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.videocomposition.a.a
 * JD-Core Version:    0.7.0.1
 */