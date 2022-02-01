package com.tencent.mm.videocomposition.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect.Filter;
import kotlin.l;

@l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/videocomposition/render/CompositionMixEffect;", "Lcom/tencent/tavkit/composition/video/TAVVideoMixEffect;", "filter", "Lcom/tencent/mm/videocomposition/render/BaseMultiVideoCompositionEffect;", "(Lcom/tencent/mm/videocomposition/render/BaseMultiVideoCompositionEffect;)V", "createFilter", "Lcom/tencent/tavkit/composition/video/TAVVideoMixEffect$Filter;", "effectId", "", "getFilter", "renderContext", "Landroid/opengl/EGLContext;", "updateRenderSize", "", "width", "", "height", "Companion", "video_composition_release"})
public final class b
  implements TAVVideoMixEffect
{
  public static final a YJF;
  private final a YJE;
  
  static
  {
    AppMethodBeat.i(248540);
    YJF = new a((byte)0);
    AppMethodBeat.o(248540);
  }
  
  public b(a parama)
  {
    AppMethodBeat.i(248538);
    this.YJE = parama;
    AppMethodBeat.o(248538);
  }
  
  public final TAVVideoMixEffect.Filter createFilter()
  {
    return (TAVVideoMixEffect.Filter)this.YJE;
  }
  
  public final String effectId()
  {
    AppMethodBeat.i(248537);
    String str = "CompositionMixEffect_" + hashCode();
    AppMethodBeat.o(248537);
    return str;
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/videocomposition/render/CompositionMixEffect$Companion;", "", "()V", "TAG", "", "video_composition_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.videocomposition.b.b
 * JD-Core Version:    0.7.0.1
 */