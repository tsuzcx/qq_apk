package kotlin.l.b.a.b.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import kotlin.aa;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.az;
import kotlin.l.b.a.b.b.b;

public final class k
{
  public static final b z(Collection<? extends b> paramCollection)
  {
    AppMethodBeat.i(60010);
    p.h(paramCollection, "descriptors");
    if (!paramCollection.isEmpty()) {}
    for (int i = 1; (aa.SXc) && (i == 0); i = 0)
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
        Integer localInteger = az.b(paramCollection.hzE(), localb.hzE());
        if ((localInteger == null) || (localInteger.intValue() >= 0)) {
          break label143;
        }
        paramCollection = localb;
      }
    }
    label143:
    for (;;)
    {
      break;
      if (paramCollection == null) {
        p.hyc();
      }
      AppMethodBeat.o(60010);
      return paramCollection;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.j.k
 * JD-Core Version:    0.7.0.1
 */