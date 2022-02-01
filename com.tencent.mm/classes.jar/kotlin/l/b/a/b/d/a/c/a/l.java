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
  private final g TrI;
  private final f TsR;
  
  public l(kotlin.l.b.a.b.d.a.c.h paramh, g paramg, f paramf)
  {
    super(paramh);
    AppMethodBeat.i(57944);
    this.TrI = paramg;
    this.TsR = paramf;
    AppMethodBeat.o(57944);
  }
  
  private static <R> Set<R> a(e parame, final Set<R> paramSet, final kotlin.g.a.b<? super kotlin.l.b.a.b.j.f.h, ? extends Collection<? extends R>> paramb)
  {
    AppMethodBeat.i(57942);
    kotlin.l.b.a.b.o.b.a((Collection)j.listOf(parame), (b.b)d.TsU, (b.c)new e(parame, paramSet, paramb));
    AppMethodBeat.o(57942);
    return paramSet;
  }
  
  private final ah f(ah paramah)
  {
    AppMethodBeat.i(57943);
    Object localObject = paramah.hAA();
    p.g(localObject, "this.kind");
    if (((kotlin.l.b.a.b.b.b.a)localObject).hAB())
    {
      AppMethodBeat.o(57943);
      return paramah;
    }
    paramah = paramah.hAy();
    p.g(paramah, "this.overriddenDescriptors");
    localObject = (Iterable)paramah;
    paramah = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ah localah = (ah)((Iterator)localObject).next();
      p.g(localah, "it");
      paramah.add(f(localah));
    }
    paramah = (ah)j.kw(j.t((Iterable)paramah));
    AppMethodBeat.o(57943);
    return paramah;
  }
  
  protected final Set<kotlin.l.b.a.b.f.f> a(d paramd)
  {
    AppMethodBeat.i(57937);
    p.h(paramd, "kindFilter");
    paramd = j.u((Iterable)((b)this.TsE.invoke()).hDL());
    a((e)this.TsR, paramd, (kotlin.g.a.b)c.TsT);
    AppMethodBeat.o(57937);
    return paramd;
  }
  
  protected final void a(Collection<am> paramCollection, kotlin.l.b.a.b.f.f paramf)
  {
    AppMethodBeat.i(57940);
    p.h(paramCollection, "result");
    p.h(paramf, "name");
    Object localObject = kotlin.l.b.a.b.d.a.b.k.s((e)this.TsR);
    if (localObject == null) {}
    for (localObject = (Set)kotlin.a.x.SXt;; localObject = j.r((Iterable)((l)localObject).b(paramf, (kotlin.l.b.a.b.c.a.a)kotlin.l.b.a.b.c.a.c.TnQ)))
    {
      localObject = kotlin.l.b.a.b.d.a.a.a.b(paramf, (Collection)localObject, paramCollection, (e)this.TsR, this.Trn.Trv.TqU, this.Trn.Trv.Trh.hLN());
      p.g(localObject, "resolveOverridesForStati….overridingUtil\n        )");
      paramCollection.addAll((Collection)localObject);
      if (!this.TrI.isEnum()) {
        break label206;
      }
      if (!p.j(paramf, kotlin.l.b.a.b.j.c.THu)) {
        break;
      }
      paramf = kotlin.l.b.a.b.j.b.x((e)this.TsR);
      p.g(paramf, "createEnumValueOfMethod(ownerDescriptor)");
      paramCollection.add(paramf);
      AppMethodBeat.o(57940);
      return;
    }
    if (p.j(paramf, kotlin.l.b.a.b.j.c.THt))
    {
      paramf = kotlin.l.b.a.b.j.b.w((e)this.TsR);
      p.g(paramf, "createEnumValuesMethod(ownerDescriptor)");
      paramCollection.add(paramf);
    }
    label206:
    AppMethodBeat.o(57940);
  }
  
  protected final Set<kotlin.l.b.a.b.f.f> b(d paramd, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, Boolean> paramb)
  {
    AppMethodBeat.i(57936);
    p.h(paramd, "kindFilter");
    Set localSet = j.u((Iterable)((b)this.TsE.invoke()).hDK());
    paramd = kotlin.l.b.a.b.d.a.b.k.s((e)this.TsR);
    if (paramd != null) {}
    for (paramd = paramd.hCa();; paramd = null)
    {
      paramb = paramd;
      if (paramd == null) {
        paramb = (Set)kotlin.a.x.SXt;
      }
      localSet.addAll((Collection)paramb);
      if (this.TrI.isEnum()) {
        localSet.addAll((Collection)j.listOf(new kotlin.l.b.a.b.f.f[] { kotlin.l.b.a.b.j.c.THu, kotlin.l.b.a.b.j.c.THt }));
      }
      AppMethodBeat.o(57936);
      return localSet;
    }
  }
  
  protected final void b(kotlin.l.b.a.b.f.f paramf, Collection<ah> paramCollection)
  {
    AppMethodBeat.i(57941);
    p.h(paramf, "name");
    p.h(paramCollection, "result");
    Object localObject1 = a((e)this.TsR, (Set)new LinkedHashSet(), (kotlin.g.a.b)new b(paramf));
    if (!paramCollection.isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramf = kotlin.l.b.a.b.d.a.a.a.b(paramf, (Collection)localObject1, paramCollection, (e)this.TsR, this.Trn.Trv.TqU, this.Trn.Trv.Trh.hLN());
      p.g(paramf, "resolveOverridesForStati…ingUtil\n                )");
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
      j.a((Collection)localObject1, (Iterable)kotlin.l.b.a.b.d.a.a.a.b(paramf, (Collection)((Map.Entry)((Iterator)localObject2).next()).getValue(), paramCollection, (e)this.TsR, this.Trn.Trv.TqU, this.Trn.Trv.Trh.hLN()));
    }
    paramCollection.addAll((Collection)localObject1);
    AppMethodBeat.o(57941);
  }
  
  protected final Set<kotlin.l.b.a.b.f.f> c(d paramd, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, Boolean> paramb)
  {
    AppMethodBeat.i(57938);
    p.h(paramd, "kindFilter");
    paramd = (Set)kotlin.a.x.SXt;
    AppMethodBeat.o(57938);
    return paramd;
  }
  
  public final kotlin.l.b.a.b.b.h c(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(57939);
    p.h(paramf, "name");
    p.h(parama, "location");
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
    public static final c TsT;
    
    static
    {
      AppMethodBeat.i(57929);
      TsT = new c();
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
    public static final d TsU;
    
    static
    {
      AppMethodBeat.i(57933);
      TsU = new d();
      AppMethodBeat.o(57933);
    }
  }
  
  public static final class e
    extends kotlin.l.b.a.b.o.b.a<e, kotlin.x>
  {
    e(e parame, Set paramSet, kotlin.g.a.b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.c.a.l
 * JD-Core Version:    0.7.0.1
 */