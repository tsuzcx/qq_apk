package com.tencent.mm.videocomposition.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect.Filter;
import kotlin.l;

@l(hxD={1, 1, 15}, hxE={""}, hxF={"Lcom/tencent/mm/videocomposition/render/CompositionMixEffect;", "Lcom/tencent/tavkit/composition/video/TAVVideoMixEffect;", "filter", "Lcom/tencent/mm/videocomposition/render/BaseMultiVideoCompositionEffect;", "(Lcom/tencent/mm/videocomposition/render/BaseMultiVideoCompositionEffect;)V", "createFilter", "Lcom/tencent/tavkit/composition/video/TAVVideoMixEffect$Filter;", "effectId", "", "getFilter", "renderContext", "Landroid/opengl/EGLContext;", "updateRenderSize", "", "width", "", "height", "Companion", "video_composition_release"})
public final class b
  implements TAVVideoMixEffect
{
  public static final a RhX;
  private final a RhW;
  
  static
  {
    AppMethodBeat.i(216845);
    RhX = new a((byte)0);
    AppMethodBeat.o(216845);
  }
  
  public b(a parama)
  {
    AppMethodBeat.i(216844);
    this.RhW = parama;
    AppMethodBeat.o(216844);
  }
  
  public final TAVVideoMixEffect.Filter createFilter()
  {
    return (TAVVideoMixEffect.Filter)this.RhW;
  }
  
  public final String effectId()
  {
    AppMethodBeat.i(216843);
    String str = "CompositionMixEffect_" + hashCode();
    AppMethodBeat.o(216843);
    return str;
  }
  
  @l(hxD={1, 1, 15}, hxE={""}, hxF={"Lcom/tencent/mm/videocomposition/render/CompositionMixEffect$Companion;", "", "()V", "TAG", "", "video_composition_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.videocomposition.b.b
 * JD-Core Version:    0.7.0.1
 */