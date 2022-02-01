package kotlin.l.b.a.b.d.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.l.b.a.b.b.ap;
import kotlin.l.b.a.b.b.au;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.d.a.a.a;
import kotlin.l.b.a.b.d.a.e.g;
import kotlin.l.b.a.b.o.b.b;
import kotlin.l.b.a.b.o.b.c;

public final class k
  extends l
{
  private final g aiSA;
  private final f aiTO;
  
  public k(kotlin.l.b.a.b.d.a.c.h paramh, g paramg, f paramf)
  {
    super(paramh);
    AppMethodBeat.i(57944);
    this.aiSA = paramg;
    this.aiTO = paramf;
    AppMethodBeat.o(57944);
  }
  
  private static <R> Set<R> a(e parame, final Set<R> paramSet, final kotlin.g.a.b<? super kotlin.l.b.a.b.j.g.h, ? extends Collection<? extends R>> paramb)
  {
    AppMethodBeat.i(57942);
    kotlin.l.b.a.b.o.b.a((Collection)p.listOf(parame), (b.b)d.aiTR, (b.c)new e(parame, paramSet, paramb));
    AppMethodBeat.o(57942);
    return paramSet;
  }
  
  private final ap e(ap paramap)
  {
    AppMethodBeat.i(57943);
    if (paramap.koh().koi())
    {
      AppMethodBeat.o(57943);
      return paramap;
    }
    paramap = paramap.kof();
    s.s(paramap, "this.overriddenDescriptors");
    Object localObject = (Iterable)paramap;
    paramap = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ap localap = (ap)((Iterator)localObject).next();
      s.s(localap, "it");
      paramap.add(e(localap));
    }
    paramap = (ap)p.oO(p.t((Iterable)paramap));
    AppMethodBeat.o(57943);
    return paramap;
  }
  
  protected final Set<kotlin.l.b.a.b.f.f> a(kotlin.l.b.a.b.j.g.d paramd)
  {
    AppMethodBeat.i(57937);
    s.u(paramd, "kindFilter");
    paramd = p.u((Iterable)((b)this.aiTB.invoke()).ksl());
    a((e)this.aiTO, paramd, (kotlin.g.a.b)c.aiTQ);
    AppMethodBeat.o(57937);
    return paramd;
  }
  
  protected final void a(Collection<au> paramCollection, kotlin.l.b.a.b.f.f paramf)
  {
    AppMethodBeat.i(57940);
    s.u(paramCollection, "result");
    s.u(paramf, "name");
    Object localObject = kotlin.l.b.a.b.d.a.b.h.q((e)this.aiTO);
    if (localObject == null) {}
    for (localObject = (Set)kotlin.a.ad.aivA;; localObject = p.r((Iterable)((k)localObject).b(paramf, (kotlin.l.b.a.b.c.a.b)kotlin.l.b.a.b.c.a.d.aiNJ)))
    {
      localObject = a.b(paramf, (Collection)localObject, paramCollection, (e)this.aiTO, this.aiSh.aiSp.aiRO, this.aiSh.aiSp.aiSb.kAU());
      s.s(localObject, "resolveOverridesForStati….overridingUtil\n        )");
      paramCollection.addAll((Collection)localObject);
      if (!this.aiSA.kqI()) {
        break label206;
      }
      if (!s.p(paramf, kotlin.l.b.a.b.a.k.aiCg)) {
        break;
      }
      paramf = kotlin.l.b.a.b.j.c.z((e)this.aiTO);
      s.s(paramf, "createEnumValueOfMethod(ownerDescriptor)");
      paramCollection.add(paramf);
      AppMethodBeat.o(57940);
      return;
    }
    if (s.p(paramf, kotlin.l.b.a.b.a.k.aiCf))
    {
      paramf = kotlin.l.b.a.b.j.c.y((e)this.aiTO);
      s.s(paramf, "createEnumValuesMethod(ownerDescriptor)");
      paramCollection.add(paramf);
    }
    label206:
    AppMethodBeat.o(57940);
  }
  
  protected final Set<kotlin.l.b.a.b.f.f> b(kotlin.l.b.a.b.j.g.d paramd, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, Boolean> paramb)
  {
    AppMethodBeat.i(57938);
    s.u(paramd, "kindFilter");
    paramd = (Set)kotlin.a.ad.aivA;
    AppMethodBeat.o(57938);
    return paramd;
  }
  
  protected final void b(Collection<au> paramCollection, kotlin.l.b.a.b.f.f paramf)
  {
    AppMethodBeat.i(192167);
    s.u(paramCollection, "result");
    s.u(paramf, "name");
    this.aiSh.aiSp.aiSd.b((e)this.aiTO, paramf, paramCollection);
    AppMethodBeat.o(192167);
  }
  
  protected final void b(kotlin.l.b.a.b.f.f paramf, Collection<ap> paramCollection)
  {
    AppMethodBeat.i(57941);
    s.u(paramf, "name");
    s.u(paramCollection, "result");
    Object localObject1 = a((e)this.aiTO, (Set)new LinkedHashSet(), (kotlin.g.a.b)new b(paramf));
    if (!paramCollection.isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramf = a.b(paramf, (Collection)localObject1, paramCollection, (e)this.aiTO, this.aiSh.aiSp.aiRO, this.aiSh.aiSp.aiSb.kAU());
      s.s(paramf, "resolveOverridesForStati…ingUtil\n                )");
      paramCollection.addAll(paramf);
      AppMethodBeat.o(57941);
      return;
    }
    localObject1 = (Iterable)localObject1;
    Object localObject3 = (Map)new LinkedHashMap();
    Iterator localIterator = ((Iterable)localObject1).iterator();
    while (localIterator.hasNext())
    {
      Object localObject4 = localIterator.next();
      ap localap = e((ap)localObject4);
      localObject2 = ((Map)localObject3).get(localap);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = (List)new ArrayList();
        ((Map)localObject3).put(localap, localObject1);
      }
      ((List)localObject1).add(localObject4);
    }
    localObject1 = (Collection)new ArrayList();
    Object localObject2 = ((Map)localObject3).entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = a.b(paramf, (Collection)((Map.Entry)((Iterator)localObject2).next()).getValue(), paramCollection, (e)this.aiTO, this.aiSh.aiSp.aiRO, this.aiSh.aiSp.aiSb.kAU());
      s.s(localObject3, "resolveOverridesForStati…ingUtil\n                )");
      p.a((Collection)localObject1, (Iterable)localObject3);
    }
    paramCollection.addAll((Collection)localObject1);
    AppMethodBeat.o(57941);
  }
  
  protected final Set<kotlin.l.b.a.b.f.f> c(kotlin.l.b.a.b.j.g.d paramd, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, Boolean> paramb)
  {
    AppMethodBeat.i(57936);
    s.u(paramd, "kindFilter");
    Set localSet = p.u((Iterable)((b)this.aiTB.invoke()).ksk());
    paramd = kotlin.l.b.a.b.d.a.b.h.q((e)this.aiTO);
    if (paramd == null) {}
    for (paramd = null;; paramd = paramd.kpL())
    {
      paramb = paramd;
      if (paramd == null) {
        paramb = (Set)kotlin.a.ad.aivA;
      }
      localSet.addAll((Collection)paramb);
      if (this.aiSA.kqI()) {
        localSet.addAll((Collection)p.listOf(new kotlin.l.b.a.b.f.f[] { kotlin.l.b.a.b.a.k.aiCg, kotlin.l.b.a.b.a.k.aiCf }));
      }
      localSet.addAll((Collection)this.aiSh.aiSp.aiSd.E((e)this.aiTO));
      AppMethodBeat.o(57936);
      return localSet;
    }
  }
  
  public final kotlin.l.b.a.b.b.h c(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.c.a.b paramb)
  {
    AppMethodBeat.i(57939);
    s.u(paramf, "name");
    s.u(paramb, "location");
    AppMethodBeat.o(57939);
    return null;
  }
  
  static final class b
    extends u
    implements kotlin.g.a.b<kotlin.l.b.a.b.j.g.h, Collection<? extends ap>>
  {
    b(kotlin.l.b.a.b.f.f paramf)
    {
      super();
    }
  }
  
  static final class c
    extends u
    implements kotlin.g.a.b<kotlin.l.b.a.b.j.g.h, Collection<? extends kotlin.l.b.a.b.f.f>>
  {
    public static final c aiTQ;
    
    static
    {
      AppMethodBeat.i(57929);
      aiTQ = new c();
      AppMethodBeat.o(57929);
    }
    
    c()
    {
      super();
    }
  }
  
  static final class d<N>
    implements b.b
  {
    public static final d<N> aiTR;
    
    static
    {
      AppMethodBeat.i(57933);
      aiTR = new d();
      AppMethodBeat.o(57933);
    }
  }
  
  public static final class e
    extends kotlin.l.b.a.b.o.b.a<e, ah>
  {
    e(e parame, Set<R> paramSet, kotlin.g.a.b<? super kotlin.l.b.a.b.j.g.h, ? extends Collection<? extends R>> paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.c.a.k
 * JD-Core Version:    0.7.0.1
 */