package kotlin.l.b.a.b.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import kotlin.ak;
import kotlin.l.b.a.b.b.b;

public final class p
{
  public static final b O(Collection<? extends b> paramCollection)
  {
    AppMethodBeat.i(60010);
    kotlin.g.b.s.u(paramCollection, "descriptors");
    if (!paramCollection.isEmpty()) {}
    for (int i = 1; (ak.aiuY) && (i == 0); i = 0)
    {
      paramCollection = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(60010);
      throw paramCollection;
    }
    Iterator localIterator = paramCollection.iterator();
    paramCollection = null;
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (paramCollection == null)
      {
        paramCollection = localb;
      }
      else
      {
        Integer localInteger = kotlin.l.b.a.b.b.s.a(paramCollection.knc(), localb.knc());
        if ((localInteger != null) && (localInteger.intValue() < 0)) {
          paramCollection = localb;
        }
      }
    }
    kotlin.g.b.s.checkNotNull(paramCollection);
    AppMethodBeat.o(60010);
    return paramCollection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.j.p
 * JD-Core Version:    0.7.0.1
 */