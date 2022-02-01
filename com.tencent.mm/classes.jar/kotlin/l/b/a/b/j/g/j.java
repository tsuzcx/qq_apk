package kotlin.l.b.a.b.j.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.l.b.a.b.f.f;

public final class j
{
  public static final Set<f> H(Iterable<? extends h> paramIterable)
  {
    AppMethodBeat.i(192210);
    s.u(paramIterable, "<this>");
    Collection localCollection = (Collection)new HashSet();
    Iterator localIterator = paramIterable.iterator();
    for (;;)
    {
      paramIterable = localCollection;
      if (localIterator.hasNext())
      {
        paramIterable = (Iterable)((h)localIterator.next()).kpM();
        if (paramIterable == null) {
          paramIterable = null;
        }
      }
      else
      {
        paramIterable = (Set)paramIterable;
        AppMethodBeat.o(192210);
        return paramIterable;
      }
      p.a(localCollection, paramIterable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.j.g.j
 * JD-Core Version:    0.7.0.1
 */