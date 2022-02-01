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
import kotlin.a.ab;
import kotlin.a.ak;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.l.b.a.b.d.a.e.g;
import kotlin.l.b.a.b.d.a.e.n;
import kotlin.l.b.a.b.d.a.e.q;
import kotlin.l.b.a.b.d.a.e.v;
import kotlin.l.b.a.b.f.f;
import kotlin.m.h;

public final class a
  implements b
{
  private final g aiSA;
  final kotlin.g.a.b<kotlin.l.b.a.b.d.a.e.p, Boolean> aiSB;
  private final kotlin.g.a.b<q, Boolean> aiSC;
  private final Map<f, List<q>> aiSD;
  private final Map<f, v> aiSE;
  private final Map<f, n> dVR;
  
  public a(g paramg, kotlin.g.a.b<? super kotlin.l.b.a.b.d.a.e.p, Boolean> paramb)
  {
    AppMethodBeat.i(57777);
    this.aiSA = paramg;
    this.aiSB = paramb;
    this.aiSC = ((kotlin.g.a.b)new a(this));
    paramg = kotlin.m.k.a(kotlin.a.p.A((Iterable)this.aiSA.kqR()), this.aiSC);
    Object localObject1 = (Map)new LinkedHashMap();
    Object localObject2 = paramg.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      f localf = ((q)localObject3).kok();
      paramb = ((Map)localObject1).get(localf);
      paramg = paramb;
      if (paramb == null)
      {
        paramg = (List)new ArrayList();
        ((Map)localObject1).put(localf, paramg);
      }
      ((List)paramg).add(localObject3);
    }
    this.aiSD = ((Map)localObject1);
    paramb = kotlin.m.k.a(kotlin.a.p.A((Iterable)this.aiSA.kqS()), this.aiSB);
    paramg = (Map)new LinkedHashMap();
    paramb = paramb.iterator();
    while (paramb.hasNext())
    {
      localObject1 = paramb.next();
      paramg.put(((n)localObject1).kok(), localObject1);
    }
    this.dVR = paramg;
    localObject1 = (Iterable)this.aiSA.kqD();
    paramg = this.aiSB;
    paramb = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if (((Boolean)paramg.invoke(localObject2)).booleanValue()) {
        paramb.add(localObject2);
      }
    }
    paramb = (Iterable)paramb;
    paramg = (Map)new LinkedHashMap(kotlin.k.k.qu(ak.aKi(kotlin.a.p.a(paramb, 10)), 16));
    paramb = paramb.iterator();
    while (paramb.hasNext())
    {
      localObject1 = paramb.next();
      paramg.put(((v)localObject1).kok(), localObject1);
    }
    this.aiSE = paramg;
    AppMethodBeat.o(57777);
  }
  
  public final Collection<q> j(f paramf)
  {
    AppMethodBeat.i(57773);
    s.u(paramf, "name");
    paramf = (List)this.aiSD.get(paramf);
    if (paramf == null)
    {
      paramf = (Collection)ab.aivy;
      AppMethodBeat.o(57773);
      return paramf;
    }
    paramf = (Collection)paramf;
    AppMethodBeat.o(57773);
    return paramf;
  }
  
  public final n k(f paramf)
  {
    AppMethodBeat.i(57775);
    s.u(paramf, "name");
    paramf = (n)this.dVR.get(paramf);
    AppMethodBeat.o(57775);
    return paramf;
  }
  
  public final Set<f> ksk()
  {
    AppMethodBeat.i(57774);
    Object localObject2 = kotlin.m.k.a(kotlin.a.p.A((Iterable)this.aiSA.kqR()), this.aiSC);
    Object localObject1 = (Collection)new LinkedHashSet();
    localObject2 = ((h)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((q)((Iterator)localObject2).next()).kok());
    }
    localObject1 = (Set)localObject1;
    AppMethodBeat.o(57774);
    return localObject1;
  }
  
  public final Set<f> ksl()
  {
    AppMethodBeat.i(57776);
    Object localObject2 = kotlin.m.k.a(kotlin.a.p.A((Iterable)this.aiSA.kqS()), this.aiSB);
    Object localObject1 = (Collection)new LinkedHashSet();
    localObject2 = ((h)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((n)((Iterator)localObject2).next()).kok());
    }
    localObject1 = (Set)localObject1;
    AppMethodBeat.o(57776);
    return localObject1;
  }
  
  public final Set<f> ksm()
  {
    AppMethodBeat.i(192166);
    Set localSet = this.aiSE.keySet();
    AppMethodBeat.o(192166);
    return localSet;
  }
  
  public final v l(f paramf)
  {
    AppMethodBeat.i(192168);
    s.u(paramf, "name");
    paramf = (v)this.aiSE.get(paramf);
    AppMethodBeat.o(192168);
    return paramf;
  }
  
  static final class a
    extends u
    implements kotlin.g.a.b<q, Boolean>
  {
    a(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.c.a.a
 * JD-Core Version:    0.7.0.1
 */