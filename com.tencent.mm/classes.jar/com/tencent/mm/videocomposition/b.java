package com.tencent.mm.videocomposition;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 15}, hxE={""}, hxF={"Lcom/tencent/mm/videocomposition/CompositionLabelRetrieverFactoryProxy;", "Lcom/tencent/mm/videocomposition/ICompositionLabelRetrieverFactory;", "()V", "factory", "getLabelRetriever", "Lcom/tencent/mm/videocomposition/ICompositionLabelRetriever;", "setImpl", "", "factoryImpl", "video_composition_release"})
public final class b
  implements f
{
  private static f RgP;
  public static final b RgQ;
  
  static
  {
    AppMethodBeat.i(216718);
    RgQ = new b();
    AppMethodBeat.o(216718);
  }
  
  public static void a(f paramf)
  {
    RgP = paramf;
  }
  
  public final e fEd()
  {
    AppMethodBeat.i(216717);
    Object localObject = RgP;
    if (localObject != null)
    {
      localObject = ((f)localObject).fEd();
      AppMethodBeat.o(216717);
      return localObject;
    }
    AppMethodBeat.o(216717);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.videocomposition.b
 * JD-Core Version:    0.7.0.1
 */