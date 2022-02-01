package com.tencent.mm.videocomposition;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.xeffect.effect.n.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import kotlin.a.j;
import kotlin.l;

@l(hxD={1, 1, 15}, hxE={""}, hxF={"VideoEnhancementScenes", "", "", "getVideoEnhancementScenes", "()Ljava/util/Set;", "video_composition_release"})
public final class a
{
  private static final Set<Integer> RgO;
  
  static
  {
    AppMethodBeat.i(216716);
    n.a[] arrayOfa = n.a.values();
    Collection localCollection = (Collection)new ArrayList(arrayOfa.length);
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      localCollection.add(Integer.valueOf(arrayOfa[i].ordinal()));
      i += 1;
    }
    RgO = j.r((Iterable)localCollection);
    AppMethodBeat.o(216716);
  }
  
  public static final Set<Integer> hfg()
  {
    return RgO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.videocomposition.a
 * JD-Core Version:    0.7.0.1
 */