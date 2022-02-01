package d.l.b.a.b.d.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.a.v;
import d.g.b.k;
import d.g.b.l;
import d.l.b.a.b.d.a.e.g;
import d.l.b.a.b.d.a.e.n;
import d.l.b.a.b.d.a.e.p;
import d.l.b.a.b.d.a.e.q;
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
  private final d.g.a.b<q, Boolean> JAD;
  private final Map<f, List<q>> JAE;
  private final Map<f, n> JAF;
  private final g JAG;
  final d.g.a.b<p, Boolean> JAH;
  
  public a(g paramg, d.g.a.b<? super p, Boolean> paramb)
  {
    AppMethodBeat.i(57777);
    this.JAG = paramg;
    this.JAH = paramb;
    this.JAD = ((d.g.a.b)new a(this));
    paramg = i.a(j.u((Iterable)this.JAG.fAF()), this.JAD);
    Object localObject1 = (Map)new LinkedHashMap();
    Iterator localIterator = paramg.iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = localIterator.next();
      f localf = ((q)localObject2).fyB();
      paramb = ((Map)localObject1).get(localf);
      paramg = paramb;
      if (paramb == null)
      {
        paramg = new ArrayList();
        ((Map)localObject1).put(localf, paramg);
      }
      ((List)paramg).add(localObject2);
    }
    this.JAE = ((Map)localObject1);
    paramb = i.a(j.u((Iterable)this.JAG.fAG()), this.JAH);
    paramg = (Map)new LinkedHashMap();
    paramb = paramb.iterator();
    while (paramb.hasNext())
    {
      localObject1 = paramb.next();
      paramg.put(((n)localObject1).fyB(), localObject1);
    }
    this.JAF = paramg;
    AppMethodBeat.o(57777);
  }
  
  public final Set<f> fBD()
  {
    AppMethodBeat.i(57774);
    Object localObject2 = i.a(j.u((Iterable)this.JAG.fAF()), this.JAD);
    Object localObject1 = (Collection)new LinkedHashSet();
    localObject2 = ((h)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((q)((Iterator)localObject2).next()).fyB());
    }
    localObject1 = (Set)localObject1;
    AppMethodBeat.o(57774);
    return localObject1;
  }
  
  public final Set<f> fBE()
  {
    AppMethodBeat.i(57776);
    Object localObject2 = i.a(j.u((Iterable)this.JAG.fAG()), this.JAH);
    Object localObject1 = (Collection)new LinkedHashSet();
    localObject2 = ((h)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((n)((Iterator)localObject2).next()).fyB());
    }
    localObject1 = (Set)localObject1;
    AppMethodBeat.o(57776);
    return localObject1;
  }
  
  public final Collection<q> j(f paramf)
  {
    AppMethodBeat.i(57773);
    k.h(paramf, "name");
    paramf = (List)this.JAE.get(paramf);
    if (paramf != null)
    {
      paramf = (Collection)paramf;
      AppMethodBeat.o(57773);
      return paramf;
    }
    paramf = (Collection)v.Jgl;
    AppMethodBeat.o(57773);
    return paramf;
  }
  
  public final n k(f paramf)
  {
    AppMethodBeat.i(57775);
    k.h(paramf, "name");
    paramf = (n)this.JAF.get(paramf);
    AppMethodBeat.o(57775);
    return paramf;
  }
  
  static final class a
    extends l
    implements d.g.a.b<q, Boolean>
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