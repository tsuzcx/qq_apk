package kotlinx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"elementDescriptors", "", "Lkotlinx/serialization/SerialDescriptor;", "elementNames", "", "getElementIndexOrThrow", "", "name", "kotlinx-serialization-runtime"})
public final class r
{
  public static final List<n> d(n paramn)
  {
    AppMethodBeat.i(191485);
    p.h(paramn, "$this$elementDescriptors");
    int j = paramn.gwT();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramn.alK(i));
      i += 1;
    }
    paramn = (List)localArrayList;
    AppMethodBeat.o(191485);
    return paramn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.r
 * JD-Core Version:    0.7.0.1
 */