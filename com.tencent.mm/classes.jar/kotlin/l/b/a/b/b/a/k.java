package kotlin.l.b.a.b.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.p;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.m.h;

public final class k
  implements g
{
  private final List<g> aiIp;
  
  public k(List<? extends g> paramList)
  {
    AppMethodBeat.i(56968);
    this.aiIp = paramList;
    AppMethodBeat.o(56968);
  }
  
  public k(g... paramVarArgs)
  {
    this(kotlin.a.k.ae(paramVarArgs));
    AppMethodBeat.i(56969);
    AppMethodBeat.o(56969);
  }
  
  public final c h(kotlin.l.b.a.b.f.c paramc)
  {
    AppMethodBeat.i(56966);
    s.u(paramc, "fqName");
    paramc = kotlin.m.k.e(p.A((Iterable)this.aiIp), (b)new a(paramc));
    s.u(paramc, "$this$firstOrNull");
    paramc = paramc.iterator();
    if (!paramc.hasNext()) {}
    for (paramc = null;; paramc = paramc.next())
    {
      paramc = (c)paramc;
      AppMethodBeat.o(56966);
      return paramc;
    }
  }
  
  public final boolean i(kotlin.l.b.a.b.f.c paramc)
  {
    AppMethodBeat.i(56965);
    s.u(paramc, "fqName");
    Iterator localIterator = p.A((Iterable)this.aiIp).iterator();
    while (localIterator.hasNext()) {
      if (((g)localIterator.next()).i(paramc))
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
    Object localObject = (Iterable)this.aiIp;
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
    Iterator localIterator = kotlin.m.k.c(p.A((Iterable)this.aiIp), (b)k.b.aiIr).iterator();
    AppMethodBeat.o(56967);
    return localIterator;
  }
  
  static final class a
    extends u
    implements b<g, c>
  {
    a(kotlin.l.b.a.b.f.c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.a.k
 * JD-Core Version:    0.7.0.1
 */