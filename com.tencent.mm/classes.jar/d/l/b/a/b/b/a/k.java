package d.l.b.a.b.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.e;
import d.a.j;
import d.g.b.l;
import d.m.h;
import d.m.i;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class k
  implements g
{
  private final List<g> Lfc;
  
  public k(List<? extends g> paramList)
  {
    AppMethodBeat.i(56968);
    this.Lfc = paramList;
    AppMethodBeat.o(56968);
  }
  
  public k(g... paramVarArgs)
  {
    this(e.V(paramVarArgs));
    AppMethodBeat.i(56969);
    AppMethodBeat.o(56969);
  }
  
  public final c g(d.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(56966);
    d.g.b.k.h(paramb, "fqName");
    paramb = i.e(j.t((Iterable)this.Lfc), (d.g.a.b)new a(paramb));
    d.g.b.k.h(paramb, "$this$firstOrNull");
    paramb = paramb.iterator();
    if (!paramb.hasNext()) {}
    for (paramb = null;; paramb = paramb.next())
    {
      paramb = (c)paramb;
      AppMethodBeat.o(56966);
      return paramb;
    }
  }
  
  public final boolean h(d.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(56965);
    d.g.b.k.h(paramb, "fqName");
    Iterator localIterator = j.t((Iterable)this.Lfc).iterator();
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
    Object localObject = (Iterable)this.Lfc;
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
    Iterator localIterator = i.c(j.t((Iterable)this.Lfc), (d.g.a.b)b.Lfe).iterator();
    AppMethodBeat.o(56967);
    return localIterator;
  }
  
  static final class a
    extends l
    implements d.g.a.b<g, c>
  {
    a(d.l.b.a.b.f.b paramb)
    {
      super();
    }
  }
  
  static final class b
    extends l
    implements d.g.a.b<g, h<? extends c>>
  {
    public static final b Lfe;
    
    static
    {
      AppMethodBeat.i(56963);
      Lfe = new b();
      AppMethodBeat.o(56963);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.a.k
 * JD-Core Version:    0.7.0.1
 */