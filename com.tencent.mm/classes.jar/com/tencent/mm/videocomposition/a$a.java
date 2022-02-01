package com.tencent.mm.videocomposition;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tavkit.composition.TAVSource;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/videocomposition/CompositionThumbGenerator$Companion;", "", "()V", "DefaultMaxImageSize", "", "TAG", "", "thumbCache", "Landroid/util/LruCache;", "Landroid/graphics/Bitmap;", "getThumbCache", "()Landroid/util/LruCache;", "clearCache", "", "fromCompositionTrack", "Lcom/tencent/mm/videocomposition/CompositionThumbGenerator;", "track", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "fromVideoComposition", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "video_composition_release"})
public final class a$a
{
  public static a d(b paramb)
  {
    AppMethodBeat.i(247846);
    p.k(paramb, "track");
    paramb = new a(paramb.igB(), paramb.path, (byte)0);
    AppMethodBeat.o(247846);
    return paramb;
  }
  
  public static a e(j paramj)
  {
    AppMethodBeat.i(247848);
    p.k(paramj, "composition");
    paramj = new a((kotlin.g.a.a)new a(paramj), String.valueOf(paramj.hashCode()), (byte)0);
    AppMethodBeat.o(247848);
    return paramj;
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/tavkit/composition/TAVSource;", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<TAVSource>
  {
    a(j paramj)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.videocomposition.a.a
 * JD-Core Version:    0.7.0.1
 */