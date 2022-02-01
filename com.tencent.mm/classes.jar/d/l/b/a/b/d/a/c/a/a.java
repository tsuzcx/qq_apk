package d.l.b.a.b.d.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.a.v;
import d.l.b.a.b.d.a.e.g;
import d.l.b.a.b.d.a.e.n;
import d.l.b.a.b.f.f;
import d.m.h;
import d.m.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class a
  implements b
{
  private final d.g.a.b<d.l.b.a.b.d.a.e.q, Boolean> NeT;
  private final Map<f, List<d.l.b.a.b.d.a.e.q>> NeU;
  private final Map<f, n> NeV;
  private final g NeW;
  final d.g.a.b<d.l.b.a.b.d.a.e.p, Boolean> NeX;
  
  public a(g paramg, d.g.a.b<? super d.l.b.a.b.d.a.e.p, Boolean> paramb)
  {
    AppMethodBeat.i(57777);
    this.NeW = paramg;
    this.NeX = paramb;
    this.NeT = ((d.g.a.b)new a(this));
    paramg = i.a(j.v((Iterable)this.NeW.gkI()), this.NeT);
    Object localObject1 = (Map)new LinkedHashMap();
    Iterator localIterator = paramg.iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = localIterator.next();
      f localf = ((d.l.b.a.b.d.a.e.q)localObject2).giD();
      paramb = ((Map)localObject1).get(localf);
      paramg = paramb;
      if (paramb == null)
      {
        paramg = new ArrayList();
        ((Map)localObject1).put(localf, paramg);
      }
      ((List)paramg).add(localObject2);
    }
    this.NeU = ((Map)localObject1);
    paramb = i.a(j.v((Iterable)this.NeW.gkJ()), this.NeX);
    paramg = (Map)new LinkedHashMap();
    paramb = paramb.iterator();
    while (paramb.hasNext())
    {
      localObject1 = paramb.next();
      paramg.put(((n)localObject1).giD(), localObject1);
    }
    this.NeV = paramg;
    AppMethodBeat.o(57777);
  }
  
  public final Set<f> glG()
  {
    AppMethodBeat.i(57774);
    Object localObject2 = i.a(j.v((Iterable)this.NeW.gkI()), this.NeT);
    Object localObject1 = (Collection)new LinkedHashSet();
    localObject2 = ((h)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((d.l.b.a.b.d.a.e.q)((Iterator)localObject2).next()).giD());
    }
    localObject1 = (Set)localObject1;
    AppMethodBeat.o(57774);
    return localObject1;
  }
  
  public final Set<f> glH()
  {
    AppMethodBeat.i(57776);
    Object localObject2 = i.a(j.v((Iterable)this.NeW.gkJ()), this.NeX);
    Object localObject1 = (Collection)new LinkedHashSet();
    localObject2 = ((h)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((n)((Iterator)localObject2).next()).giD());
    }
    localObject1 = (Set)localObject1;
    AppMethodBeat.o(57776);
    return localObject1;
  }
  
  public final Collection<d.l.b.a.b.d.a.e.q> j(f paramf)
  {
    AppMethodBeat.i(57773);
    d.g.b.p.h(paramf, "name");
    paramf = (List)this.NeU.get(paramf);
    if (paramf != null)
    {
      paramf = (Collection)paramf;
      AppMethodBeat.o(57773);
      return paramf;
    }
    paramf = (Collection)v.MKE;
    AppMethodBeat.o(57773);
    return paramf;
  }
  
  public final n k(f paramf)
  {
    AppMethodBeat.i(57775);
    d.g.b.p.h(paramf, "name");
    paramf = (n)this.NeV.get(paramf);
    AppMethodBeat.o(57775);
    return paramf;
  }
  
  static final class a
    extends d.g.b.q
    implements d.g.a.b<d.l.b.a.b.d.a.e.q, Boolean>
  {
    a(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.d.a.c.a.a
 * JD-Core Version:    0.7.0.1
 */