package com.tencent.mm.videocomposition.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect.Filter;
import d.l;

@l(gfx={1, 1, 15}, gfy={""}, gfz={"Lcom/tencent/mm/videocomposition/render/CompositionMixEffect;", "Lcom/tencent/tavkit/composition/video/TAVVideoMixEffect;", "filter", "Lcom/tencent/mm/videocomposition/render/BaseMultiVideoCompositionEffect;", "(Lcom/tencent/mm/videocomposition/render/BaseMultiVideoCompositionEffect;)V", "createFilter", "Lcom/tencent/tavkit/composition/video/TAVVideoMixEffect$Filter;", "effectId", "", "getFilter", "renderContext", "Landroid/opengl/EGLContext;", "setFrameRenderCallback", "", "callback", "Lkotlin/Function0;", "updateRenderSize", "width", "", "height", "Companion", "video_composition_release"})
public final class c
  implements TAVVideoMixEffect
{
  public static final a Lnu;
  private final a Lnt;
  
  static
  {
    AppMethodBeat.i(220905);
    Lnu = new a((byte)0);
    AppMethodBeat.o(220905);
  }
  
  public c(a parama)
  {
    AppMethodBeat.i(220904);
    this.Lnt = parama;
    AppMethodBeat.o(220904);
  }
  
  public final TAVVideoMixEffect.Filter createFilter()
  {
    return (TAVVideoMixEffect.Filter)this.Lnt;
  }
  
  public final String effectId()
  {
    AppMethodBeat.i(220903);
    String str = "CompositionMixEffect_" + hashCode();
    AppMethodBeat.o(220903);
    return str;
  }
  
  @l(gfx={1, 1, 15}, gfy={""}, gfz={"Lcom/tencent/mm/videocomposition/render/CompositionMixEffect$Companion;", "", "()V", "TAG", "", "video_composition_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.videocomposition.b.c
 * JD-Core Version:    0.7.0.1
 */