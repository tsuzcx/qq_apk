package kotlin.l.b.a.b.n.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.g.b.s;
import kotlin.l.b.a.b.j.g.h;
import kotlin.l.b.a.b.j.g.h.c;
import kotlin.l.b.a.b.o.e;

public final class a
{
  public static final e<h> I(Iterable<? extends h> paramIterable)
  {
    AppMethodBeat.i(191506);
    s.u(paramIterable, "scopes");
    Collection localCollection = (Collection)new e();
    paramIterable = paramIterable.iterator();
    label84:
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      h localh = (h)localObject;
      if ((localh != null) && (localh != h.c.ajlm)) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label84;
        }
        localCollection.add(localObject);
        break;
      }
    }
    paramIterable = (e)localCollection;
    AppMethodBeat.o(191506);
    return paramIterable;
  }
  
  public static final <T> Collection<T> a(Collection<? extends T> paramCollection1, Collection<? extends T> paramCollection2)
  {
    AppMethodBeat.i(61341);
    s.u(paramCollection2, "collection");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.n.b.a
 * JD-Core Version:    0.7.0.1
 */