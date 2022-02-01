package kotlin.l.b.a.b.n.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.LinkedHashSet;
import kotlin.g.b.p;

public final class a
{
  public static final <T> Collection<T> a(Collection<? extends T> paramCollection1, Collection<? extends T> paramCollection2)
  {
    AppMethodBeat.i(61341);
    p.h(paramCollection2, "collection");
    if (paramCollection2.isEmpty())
    {
      AppMethodBeat.o(61341);
      return paramCollection1;
    }
    if (paramCollection1 == null)
    {
      AppMethodBeat.o(61341);
      return paramCollection2;
    }
    if ((paramCollection1 instanceof LinkedHashSet))
    {
      ((LinkedHashSet)paramCollection1).addAll(paramCollection2);
      AppMethodBeat.o(61341);
      return paramCollection1;
    }
    paramCollection1 = new LinkedHashSet(paramCollection1);
    paramCollection1.addAll(paramCollection2);
    paramCollection1 = (Collection)paramCollection1;
    AppMethodBeat.o(61341);
    return paramCollection1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlin.l.b.a.b.n.b.a
 * JD-Core Version:    0.7.0.1
 */