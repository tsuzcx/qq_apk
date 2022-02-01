package com.tencent.mm.videocomposition.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tavkit.composition.audio.TAVAudioProcessorNode;
import com.tencent.tavkit.composition.audio.TAVAudioProcessorNode.TAVAudioProcessorEffect;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/videocomposition/audio/AudioResampleProcessor;", "Lcom/tencent/mm/videocomposition/audio/IAudioProcessorFactory;", "resampleFactory", "Lcom/tencent/mm/videocomposition/audio/IAudioResampleFactory;", "(Lcom/tencent/mm/videocomposition/audio/IAudioResampleFactory;)V", "getResampleFactory", "()Lcom/tencent/mm/videocomposition/audio/IAudioResampleFactory;", "createAudioProcessorNode", "Lcom/tencent/tavkit/composition/audio/TAVAudioProcessorNode;", "track", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "video_composition_release"})
public final class a
  implements b
{
  final c YIw;
  
  public a(c paramc)
  {
    AppMethodBeat.i(248059);
    this.YIw = paramc;
    AppMethodBeat.o(248059);
  }
  
  public final TAVAudioProcessorNode h(final com.tencent.mm.videocomposition.b paramb)
  {
    AppMethodBeat.i(248055);
    p.k(paramb, "track");
    paramb = (TAVAudioProcessorNode)new a(this, paramb);
    AppMethodBeat.o(248055);
    return paramb;
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"com/tencent/mm/videocomposition/audio/AudioResampleProcessor$createAudioProcessorNode$1", "Lcom/tencent/tavkit/composition/audio/TAVAudioProcessorNode;", "createAudioProcessor", "Lcom/tencent/tavkit/composition/audio/TAVAudioProcessorNode$TAVAudioProcessorEffect;", "getIdentifier", "", "video_composition_release"})
  public static final class a
    implements TAVAudioProcessorNode
  {
    a(com.tencent.mm.videocomposition.b paramb) {}
    
    public final TAVAudioProcessorNode.TAVAudioProcessorEffect createAudioProcessor()
    {
      AppMethodBeat.i(248052);
      TAVAudioProcessorNode.TAVAudioProcessorEffect localTAVAudioProcessorEffect = this.YIx.YIw.a(paramb);
      AppMethodBeat.o(248052);
      return localTAVAudioProcessorEffect;
    }
    
    public final String getIdentifier()
    {
      return paramb.path;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.videocomposition.a.a
 * JD-Core Version:    0.7.0.1
 */