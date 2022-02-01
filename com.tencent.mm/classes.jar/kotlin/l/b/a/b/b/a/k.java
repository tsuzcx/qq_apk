package kotlin.l.b.a.b.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.e;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.m.h;
import kotlin.m.i;

public final class k
  implements g
{
  private final List<g> TiL;
  
  public k(List<? extends g> paramList)
  {
    AppMethodBeat.i(56968);
    this.TiL = paramList;
    AppMethodBeat.o(56968);
  }
  
  public k(g... paramVarArgs)
  {
    this(e.W(paramVarArgs));
    AppMethodBeat.i(56969);
    AppMethodBeat.o(56969);
  }
  
  public final c g(kotlin.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(56966);
    p.h(paramb, "fqName");
    paramb = i.e(j.z((Iterable)this.TiL), (kotlin.g.a.b)new a(paramb));
    p.h(paramb, "$this$firstOrNull");
    paramb = paramb.iterator();
    if (!paramb.hasNext()) {}
    for (paramb = null;; paramb = paramb.next())
    {
      paramb = (c)paramb;
      AppMethodBeat.o(56966);
      return paramb;
    }
  }
  
  public final boolean h(kotlin.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(56965);
    p.h(paramb, "fqName");
    Iterator localIterator = j.z((Iterable)this.TiL).iterator();
    while (localIterator.hasNext()) {
      if (((g)localIterator.next()).h(paramb))
      {
        AppMethodBeat.o(56965);
        return true;
      }
    }
    AppMethodBeat.o(56965);
    return false;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(56964);
    Object localObject = (Iterable)this.TiL;
    if ((!(localObject instanceof Collection)) || (!((Collection)localObject).isEmpty()))
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (!((g)((Iterator)localObject).next()).isEmpty())
        {
          AppMethodBeat.o(56964);
          return false;
        }
      }
    }
    AppMethodBeat.o(56964);
    return true;
  }
  
  public final Iterator<c> iterator()
  {
    AppMethodBeat.i(56967);
    Iterator localIterator = i.c(j.z((Iterable)this.TiL), (kotlin.g.a.b)k.b.TiN).iterator();
    AppMethodBeat.o(56967);
    return localIterator;
  }
  
  static final class a
    extends q
    implements kotlin.g.a.b<g, c>
  {
    a(kotlin.l.b.a.b.f.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.b.a.k
 * JD-Core Version:    0.7.0.1
 */