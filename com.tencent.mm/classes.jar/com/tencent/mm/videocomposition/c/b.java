package com.tencent.mm.videocomposition.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect.Filter;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/videocomposition/render/CompositionMixEffect;", "Lcom/tencent/tavkit/composition/video/TAVVideoMixEffect;", "filter", "Lcom/tencent/mm/videocomposition/render/BaseMultiVideoCompositionEffect;", "(Lcom/tencent/mm/videocomposition/render/BaseMultiVideoCompositionEffect;)V", "createFilter", "Lcom/tencent/tavkit/composition/video/TAVVideoMixEffect$Filter;", "effectId", "", "getFilter", "renderContext", "Landroid/opengl/EGLContext;", "updateRenderSize", "", "width", "", "height", "Companion", "video_composition_release"}, k=1, mv={1, 1, 15})
public final class b
  implements TAVVideoMixEffect
{
  public static final a agFx;
  private final a agFw;
  
  static
  {
    AppMethodBeat.i(233504);
    agFx = new a((byte)0);
    AppMethodBeat.o(233504);
  }
  
  public b(a parama)
  {
    AppMethodBeat.i(233497);
    this.agFw = parama;
    AppMethodBeat.o(233497);
  }
  
  public final TAVVideoMixEffect.Filter createFilter()
  {
    return (TAVVideoMixEffect.Filter)this.agFw;
  }
  
  public final String effectId()
  {
    AppMethodBeat.i(233510);
    String str = "CompositionMixEffect_" + hashCode();
    AppMethodBeat.o(233510);
    return str;
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/videocomposition/render/CompositionMixEffect$Companion;", "", "()V", "TAG", "", "video_composition_release"}, k=1, mv={1, 1, 15})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.videocomposition.c.b
 * JD-Core Version:    0.7.0.1
 */