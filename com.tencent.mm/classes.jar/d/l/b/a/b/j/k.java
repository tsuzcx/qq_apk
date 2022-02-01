package d.l.b.a.b.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.ac;
import d.g.b.p;
import d.l.b.a.b.b.az;
import d.l.b.a.b.b.b;
import java.util.Collection;
import java.util.Iterator;

public final class k
{
  public static final b w(Collection<? extends b> paramCollection)
  {
    AppMethodBeat.i(60010);
    p.h(paramCollection, "descriptors");
    if (!paramCollection.isEmpty()) {}
    for (int i = 1; (ac.Nhs) && (i == 0); i = 0)
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
        Integer localInteger = az.b(paramCollection.gmb(), localb.gmb());
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
        p.gkB();
      }
      AppMethodBeat.o(60010);
      return paramCollection;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.j.k
 * JD-Core Version:    0.7.0.1
 */