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
  private final d.g.a.b<d.l.b.a.b.d.a.e.q, Boolean> NBY;
  private final Map<f, List<d.l.b.a.b.d.a.e.q>> NBZ;
  private final Map<f, n> NCa;
  private final g NCb;
  final d.g.a.b<d.l.b.a.b.d.a.e.p, Boolean> NCc;
  
  public a(g paramg, d.g.a.b<? super d.l.b.a.b.d.a.e.p, Boolean> paramb)
  {
    AppMethodBeat.i(57777);
    this.NCb = paramg;
    this.NCc = paramb;
    this.NBY = ((d.g.a.b)new a(this));
    paramg = i.a(j.v((Iterable)this.NCb.gpk()), this.NBY);
    Object localObject1 = (Map)new LinkedHashMap();
    Iterator localIterator = paramg.iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = localIterator.next();
      f localf = ((d.l.b.a.b.d.a.e.q)localObject2).gnf();
      paramb = ((Map)localObject1).get(localf);
      paramg = paramb;
      if (paramb == null)
      {
        paramg = new ArrayList();
        ((Map)localObject1).put(localf, paramg);
      }
      ((List)paramg).add(localObject2);
    }
    this.NBZ = ((Map)localObject1);
    paramb = i.a(j.v((Iterable)this.NCb.gpl()), this.NCc);
    paramg = (Map)new LinkedHashMap();
    paramb = paramb.iterator();
    while (paramb.hasNext())
    {
      localObject1 = paramb.next();
      paramg.put(((n)localObject1).gnf(), localObject1);
    }
    this.NCa = paramg;
    AppMethodBeat.o(57777);
  }
  
  public final Set<f> gqi()
  {
    AppMethodBeat.i(57774);
    Object localObject2 = i.a(j.v((Iterable)this.NCb.gpk()), this.NBY);
    Object localObject1 = (Collection)new LinkedHashSet();
    localObject2 = ((h)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((d.l.b.a.b.d.a.e.q)((Iterator)localObject2).next()).gnf());
    }
    localObject1 = (Set)localObject1;
    AppMethodBeat.o(57774);
    return localObject1;
  }
  
  public final Set<f> gqj()
  {
    AppMethodBeat.i(57776);
    Object localObject2 = i.a(j.v((Iterable)this.NCb.gpl()), this.NCc);
    Object localObject1 = (Collection)new LinkedHashSet();
    localObject2 = ((h)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((n)((Iterator)localObject2).next()).gnf());
    }
    localObject1 = (Set)localObject1;
    AppMethodBeat.o(57776);
    return localObject1;
  }
  
  public final Collection<d.l.b.a.b.d.a.e.q> j(f paramf)
  {
    AppMethodBeat.i(57773);
    d.g.b.p.h(paramf, "name");
    paramf = (List)this.NBZ.get(paramf);
    if (paramf != null)
    {
      paramf = (Collection)paramf;
      AppMethodBeat.o(57773);
      return paramf;
    }
    paramf = (Collection)v.NhH;
    AppMethodBeat.o(57773);
    return paramf;
  }
  
  public final n k(f paramf)
  {
    AppMethodBeat.i(57775);
    d.g.b.p.h(paramf, "name");
    paramf = (n)this.NCa.get(paramf);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.a.c.a.a
 * JD-Core Version:    0.7.0.1
 */