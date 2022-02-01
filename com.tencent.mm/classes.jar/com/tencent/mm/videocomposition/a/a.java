package com.tencent.mm.videocomposition.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.videocomposition.d;
import com.tencent.tavkit.composition.audio.TAVAudioProcessorNode;
import com.tencent.tavkit.composition.audio.TAVAudioProcessorNode.TAVAudioProcessorEffect;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 15}, hxE={""}, hxF={"Lcom/tencent/mm/videocomposition/audio/AudioResampleProcessor;", "Lcom/tencent/mm/videocomposition/audio/IAudioProcessorFactory;", "resampleFactory", "Lcom/tencent/mm/videocomposition/audio/IAudioResampleFactory;", "(Lcom/tencent/mm/videocomposition/audio/IAudioResampleFactory;)V", "getResampleFactory", "()Lcom/tencent/mm/videocomposition/audio/IAudioResampleFactory;", "createAudioProcessorNode", "Lcom/tencent/tavkit/composition/audio/TAVAudioProcessorNode;", "track", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "video_composition_release"})
public final class a
  implements b
{
  final c RhA;
  
  public a(c paramc)
  {
    AppMethodBeat.i(216795);
    this.RhA = paramc;
    AppMethodBeat.o(216795);
  }
  
  public final TAVAudioProcessorNode f(final d paramd)
  {
    AppMethodBeat.i(216794);
    p.h(paramd, "track");
    paramd = (TAVAudioProcessorNode)new a(this, paramd);
    AppMethodBeat.o(216794);
    return paramd;
  }
  
  @l(hxD={1, 1, 15}, hxE={""}, hxF={"com/tencent/mm/videocomposition/audio/AudioResampleProcessor$createAudioProcessorNode$1", "Lcom/tencent/tavkit/composition/audio/TAVAudioProcessorNode;", "createAudioProcessor", "Lcom/tencent/tavkit/composition/audio/TAVAudioProcessorNode$TAVAudioProcessorEffect;", "getIdentifier", "", "video_composition_release"})
  public static final class a
    implements TAVAudioProcessorNode
  {
    a(d paramd) {}
    
    public final TAVAudioProcessorNode.TAVAudioProcessorEffect createAudioProcessor()
    {
      AppMethodBeat.i(216793);
      TAVAudioProcessorNode.TAVAudioProcessorEffect localTAVAudioProcessorEffect = this.RhB.RhA.a(paramd);
      AppMethodBeat.o(216793);
      return localTAVAudioProcessorEffect;
    }
    
    public final String getIdentifier()
    {
      return paramd.path;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.videocomposition.a.a
 * JD-Core Version:    0.7.0.1
 */