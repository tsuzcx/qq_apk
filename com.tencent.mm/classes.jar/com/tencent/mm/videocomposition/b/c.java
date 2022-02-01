package com.tencent.mm.videocomposition.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect.Filter;
import d.l;

@l(gjZ={1, 1, 15}, gka={""}, gkb={"Lcom/tencent/mm/videocomposition/render/CompositionMixEffect;", "Lcom/tencent/tavkit/composition/video/TAVVideoMixEffect;", "filter", "Lcom/tencent/mm/videocomposition/render/BaseMultiVideoCompositionEffect;", "(Lcom/tencent/mm/videocomposition/render/BaseMultiVideoCompositionEffect;)V", "createFilter", "Lcom/tencent/tavkit/composition/video/TAVVideoMixEffect$Filter;", "effectId", "", "getFilter", "renderContext", "Landroid/opengl/EGLContext;", "setFrameRenderCallback", "", "callback", "Lkotlin/Function0;", "updateRenderSize", "width", "", "height", "Companion", "video_composition_release"})
public final class c
  implements TAVVideoMixEffect
{
  public static final a LKf;
  private final a LKe;
  
  static
  {
    AppMethodBeat.i(195040);
    LKf = new a((byte)0);
    AppMethodBeat.o(195040);
  }
  
  public c(a parama)
  {
    AppMethodBeat.i(195039);
    this.LKe = parama;
    AppMethodBeat.o(195039);
  }
  
  public final TAVVideoMixEffect.Filter createFilter()
  {
    return (TAVVideoMixEffect.Filter)this.LKe;
  }
  
  public final String effectId()
  {
    AppMethodBeat.i(195038);
    String str = "CompositionMixEffect_" + hashCode();
    AppMethodBeat.o(195038);
    return str;
  }
  
  @l(gjZ={1, 1, 15}, gka={""}, gkb={"Lcom/tencent/mm/videocomposition/render/CompositionMixEffect$Companion;", "", "()V", "TAG", "", "video_composition_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.videocomposition.b.c
 * JD-Core Version:    0.7.0.1
 */