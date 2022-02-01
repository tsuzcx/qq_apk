package kotlinx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"elementDescriptors", "", "Lkotlinx/serialization/SerialDescriptor;", "elementNames", "", "getElementIndexOrThrow", "", "name", "kotlinx-serialization-runtime"})
public final class r
{
  public static final List<n> d(n paramn)
  {
    AppMethodBeat.i(225847);
    p.h(paramn, "$this$elementDescriptors");
    int j = paramn.hOC();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramn.awd(i));
      i += 1;
    }
    paramn = (List)localArrayList;
    AppMethodBeat.o(225847);
    return paramn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     kotlinx.a.r
 * JD-Core Version:    0.7.0.1
 */