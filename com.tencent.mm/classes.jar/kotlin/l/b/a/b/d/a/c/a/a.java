package kotlin.l.b.a.b.d.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.l.b.a.b.d.a.e.g;
import kotlin.l.b.a.b.d.a.e.n;
import kotlin.l.b.a.b.f.f;
import kotlin.m.h;
import kotlin.m.i;

public final class a
  implements b
{
  private final kotlin.g.a.b<kotlin.l.b.a.b.d.a.e.q, Boolean> TrG;
  private final Map<f, List<kotlin.l.b.a.b.d.a.e.q>> TrH;
  private final g TrI;
  final kotlin.g.a.b<kotlin.l.b.a.b.d.a.e.p, Boolean> TrJ;
  private final Map<f, n> bZN;
  
  public a(g paramg, kotlin.g.a.b<? super kotlin.l.b.a.b.d.a.e.p, Boolean> paramb)
  {
    AppMethodBeat.i(57777);
    this.TrI = paramg;
    this.TrJ = paramb;
    this.TrG = ((kotlin.g.a.b)new a(this));
    paramg = i.a(j.z((Iterable)this.TrI.hCM()), this.TrG);
    Object localObject1 = (Map)new LinkedHashMap();
    Iterator localIterator = paramg.iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = localIterator.next();
      f localf = ((kotlin.l.b.a.b.d.a.e.q)localObject2).hAH();
      paramb = ((Map)localObject1).get(localf);
      paramg = paramb;
      if (paramb == null)
      {
        paramg = new ArrayList();
        ((Map)localObject1).put(localf, paramg);
      }
      ((List)paramg).add(localObject2);
    }
    this.TrH = ((Map)localObject1);
    paramb = i.a(j.z((Iterable)this.TrI.hCN()), this.TrJ);
    paramg = (Map)new LinkedHashMap();
    paramb = paramb.iterator();
    while (paramb.hasNext())
    {
      localObject1 = paramb.next();
      paramg.put(((n)localObject1).hAH(), localObject1);
    }
    this.bZN = paramg;
    AppMethodBeat.o(57777);
  }
  
  public final Set<f> hDK()
  {
    AppMethodBeat.i(57774);
    Object localObject2 = i.a(j.z((Iterable)this.TrI.hCM()), this.TrG);
    Object localObject1 = (Collection)new LinkedHashSet();
    localObject2 = ((h)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((kotlin.l.b.a.b.d.a.e.q)((Iterator)localObject2).next()).hAH());
    }
    localObject1 = (Set)localObject1;
    AppMethodBeat.o(57774);
    return localObject1;
  }
  
  public final Set<f> hDL()
  {
    AppMethodBeat.i(57776);
    Object localObject2 = i.a(j.z((Iterable)this.TrI.hCN()), this.TrJ);
    Object localObject1 = (Collection)new LinkedHashSet();
    localObject2 = ((h)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((n)((Iterator)localObject2).next()).hAH());
    }
    localObject1 = (Set)localObject1;
    AppMethodBeat.o(57776);
    return localObject1;
  }
  
  public final Collection<kotlin.l.b.a.b.d.a.e.q> j(f paramf)
  {
    AppMethodBeat.i(57773);
    kotlin.g.b.p.h(paramf, "name");
    paramf = (List)this.TrH.get(paramf);
    if (paramf != null)
    {
      paramf = (Collection)paramf;
      AppMethodBeat.o(57773);
      return paramf;
    }
    paramf = (Collection)v.SXr;
    AppMethodBeat.o(57773);
    return paramf;
  }
  
  public final n k(f paramf)
  {
    AppMethodBeat.i(57775);
    kotlin.g.b.p.h(paramf, "name");
    paramf = (n)this.bZN.get(paramf);
    AppMethodBeat.o(57775);
    return paramf;
  }
  
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.b<kotlin.l.b.a.b.d.a.e.q, Boolean>
  {
    a(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.c.a.a
 * JD-Core Version:    0.7.0.1
 */