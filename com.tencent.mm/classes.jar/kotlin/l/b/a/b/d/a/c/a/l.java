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
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.d.a.e.g;
import kotlin.l.b.a.b.j.f.d;
import kotlin.l.b.a.b.m.a.n;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.o.b.b;
import kotlin.l.b.a.b.o.b.c;

public final class l
  extends m
{
  private final g aaUC;
  private final f aaVL;
  
  public l(kotlin.l.b.a.b.d.a.c.h paramh, g paramg, f paramf)
  {
    super(paramh);
    AppMethodBeat.i(57944);
    this.aaUC = paramg;
    this.aaVL = paramf;
    AppMethodBeat.o(57944);
  }
  
  private static <R> Set<R> a(e parame, final Set<R> paramSet, final kotlin.g.a.b<? super kotlin.l.b.a.b.j.f.h, ? extends Collection<? extends R>> paramb)
  {
    AppMethodBeat.i(57942);
    kotlin.l.b.a.b.o.b.a((Collection)j.listOf(parame), (b.b)d.aaVO, (b.c)new e(parame, paramSet, paramb));
    AppMethodBeat.o(57942);
    return paramSet;
  }
  
  private final ah f(ah paramah)
  {
    AppMethodBeat.i(57943);
    Object localObject = paramah.iEN();
    p.j(localObject, "this.kind");
    if (((kotlin.l.b.a.b.b.b.a)localObject).iEO())
    {
      AppMethodBeat.o(57943);
      return paramah;
    }
    paramah = paramah.iEL();
    p.j(paramah, "this.overriddenDescriptors");
    localObject = (Iterable)paramah;
    paramah = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ah localah = (ah)((Iterator)localObject).next();
      p.j(localah, "it");
      paramah.add(f(localah));
    }
    paramah = (ah)j.ls(j.t((Iterable)paramah));
    AppMethodBeat.o(57943);
    return paramah;
  }
  
  protected final Set<kotlin.l.b.a.b.f.f> a(d paramd)
  {
    AppMethodBeat.i(57937);
    p.k(paramd, "kindFilter");
    paramd = j.u((Iterable)((b)this.aaVy.invoke()).iIe());
    a((e)this.aaVL, paramd, (kotlin.g.a.b)c.aaVN);
    AppMethodBeat.o(57937);
    return paramd;
  }
  
  protected final void a(Collection<am> paramCollection, kotlin.l.b.a.b.f.f paramf)
  {
    AppMethodBeat.i(57940);
    p.k(paramCollection, "result");
    p.k(paramf, "name");
    Object localObject = kotlin.l.b.a.b.d.a.b.k.s((e)this.aaVL);
    if (localObject == null) {}
    for (localObject = (Set)kotlin.a.x.aaAf;; localObject = j.r((Iterable)((l)localObject).b(paramf, (kotlin.l.b.a.b.c.a.a)kotlin.l.b.a.b.c.a.c.aaQK)))
    {
      localObject = kotlin.l.b.a.b.d.a.a.a.b(paramf, (Collection)localObject, paramCollection, (e)this.aaVL, this.aaUh.aaUp.aaTO, this.aaUh.aaUp.aaUb.iQf());
      p.j(localObject, "resolveOverridesForStati….overridingUtil\n        )");
      paramCollection.addAll((Collection)localObject);
      if (!this.aaUC.iHi()) {
        break label206;
      }
      if (!p.h(paramf, kotlin.l.b.a.b.j.c.abjY)) {
        break;
      }
      paramf = kotlin.l.b.a.b.j.b.x((e)this.aaVL);
      p.j(paramf, "createEnumValueOfMethod(ownerDescriptor)");
      paramCollection.add(paramf);
      AppMethodBeat.o(57940);
      return;
    }
    if (p.h(paramf, kotlin.l.b.a.b.j.c.abjX))
    {
      paramf = kotlin.l.b.a.b.j.b.w((e)this.aaVL);
      p.j(paramf, "createEnumValuesMethod(ownerDescriptor)");
      paramCollection.add(paramf);
    }
    label206:
    AppMethodBeat.o(57940);
  }
  
  protected final Set<kotlin.l.b.a.b.f.f> b(d paramd, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, Boolean> paramb)
  {
    AppMethodBeat.i(57936);
    p.k(paramd, "kindFilter");
    Set localSet = j.u((Iterable)((b)this.aaVy.invoke()).iId());
    paramd = kotlin.l.b.a.b.d.a.b.k.s((e)this.aaVL);
    if (paramd != null) {}
    for (paramd = paramd.iGp();; paramd = null)
    {
      paramb = paramd;
      if (paramd == null) {
        paramb = (Set)kotlin.a.x.aaAf;
      }
      localSet.addAll((Collection)paramb);
      if (this.aaUC.iHi()) {
        localSet.addAll((Collection)j.listOf(new kotlin.l.b.a.b.f.f[] { kotlin.l.b.a.b.j.c.abjY, kotlin.l.b.a.b.j.c.abjX }));
      }
      AppMethodBeat.o(57936);
      return localSet;
    }
  }
  
  protected final void b(kotlin.l.b.a.b.f.f paramf, Collection<ah> paramCollection)
  {
    AppMethodBeat.i(57941);
    p.k(paramf, "name");
    p.k(paramCollection, "result");
    Object localObject1 = a((e)this.aaVL, (Set)new LinkedHashSet(), (kotlin.g.a.b)new b(paramf));
    if (!paramCollection.isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramf = kotlin.l.b.a.b.d.a.a.a.b(paramf, (Collection)localObject1, paramCollection, (e)this.aaVL, this.aaUh.aaUp.aaTO, this.aaUh.aaUp.aaUb.iQf());
      p.j(paramf, "resolveOverridesForStati…ingUtil\n                )");
      paramCollection.addAll(paramf);
      AppMethodBeat.o(57941);
      return;
    }
    localObject1 = (Iterable)localObject1;
    Map localMap = (Map)new LinkedHashMap();
    Iterator localIterator = ((Iterable)localObject1).iterator();
    while (localIterator.hasNext())
    {
      Object localObject3 = localIterator.next();
      ah localah = f((ah)localObject3);
      localObject2 = localMap.get(localah);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ArrayList();
        localMap.put(localah, localObject1);
      }
      ((List)localObject1).add(localObject3);
    }
    localObject1 = (Collection)new ArrayList();
    Object localObject2 = localMap.entrySet().iterator();
    while (((Iterator)localObject2).hasNext()) {
      j.a((Collection)localObject1, (Iterable)kotlin.l.b.a.b.d.a.a.a.b(paramf, (Collection)((Map.Entry)((Iterator)localObject2).next()).getValue(), paramCollection, (e)this.aaVL, this.aaUh.aaUp.aaTO, this.aaUh.aaUp.aaUb.iQf()));
    }
    paramCollection.addAll((Collection)localObject1);
    AppMethodBeat.o(57941);
  }
  
  protected final Set<kotlin.l.b.a.b.f.f> c(d paramd, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, Boolean> paramb)
  {
    AppMethodBeat.i(57938);
    p.k(paramd, "kindFilter");
    paramd = (Set)kotlin.a.x.aaAf;
    AppMethodBeat.o(57938);
    return paramd;
  }
  
  public final kotlin.l.b.a.b.b.h c(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(57939);
    p.k(paramf, "name");
    p.k(parama, "location");
    AppMethodBeat.o(57939);
    return null;
  }
  
  static final class b
    extends q
    implements kotlin.g.a.b<kotlin.l.b.a.b.j.f.h, Collection<? extends ah>>
  {
    b(kotlin.l.b.a.b.f.f paramf)
    {
      super();
    }
  }
  
  static final class c
    extends q
    implements kotlin.g.a.b<kotlin.l.b.a.b.j.f.h, Set<? extends kotlin.l.b.a.b.f.f>>
  {
    public static final c aaVN;
    
    static
    {
      AppMethodBeat.i(57929);
      aaVN = new c();
      AppMethodBeat.o(57929);
    }
    
    c()
    {
      super();
    }
  }
  
  static final class d<N>
    implements b.b<N>
  {
    public static final d aaVO;
    
    static
    {
      AppMethodBeat.i(57933);
      aaVO = new d();
      AppMethodBeat.o(57933);
    }
  }
  
  public static final class e
    extends kotlin.l.b.a.b.o.b.a<e, kotlin.x>
  {
    e(e parame, Set paramSet, kotlin.g.a.b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.c.a.l
 * JD-Core Version:    0.7.0.1
 */