package d.l.b.a.b.d.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.a.x;
import d.l.b.a.b.b.ah;
import d.l.b.a.b.b.am;
import d.l.b.a.b.b.e;
import d.l.b.a.b.d.a.e.g;
import d.l.b.a.b.d.a.e.p;
import d.l.b.a.b.j.f.d;
import d.l.b.a.b.m.a.n;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.o.b.b;
import d.l.b.a.b.o.b.c;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class l
  extends m
{
  private final g LnZ;
  private final f Lpi;
  
  public l(d.l.b.a.b.d.a.c.h paramh, g paramg, f paramf)
  {
    super(paramh);
    AppMethodBeat.i(57944);
    this.LnZ = paramg;
    this.Lpi = paramf;
    AppMethodBeat.o(57944);
  }
  
  private static <R> Set<R> a(e parame, final Set<R> paramSet, final d.g.a.b<? super d.l.b.a.b.j.f.h, ? extends Collection<? extends R>> paramb)
  {
    AppMethodBeat.i(57942);
    d.l.b.a.b.o.b.a((Collection)j.listOf(parame), (b.b)d.Lpl, (b.c)new e(parame, paramSet, paramb));
    AppMethodBeat.o(57942);
    return paramSet;
  }
  
  private final ah f(ah paramah)
  {
    AppMethodBeat.i(57943);
    Object localObject = paramah.fQY();
    d.g.b.k.g(localObject, "this.kind");
    if (((d.l.b.a.b.b.b.a)localObject).fQZ())
    {
      AppMethodBeat.o(57943);
      return paramah;
    }
    paramah = paramah.fQW();
    d.g.b.k.g(paramah, "this.overriddenDescriptors");
    localObject = (Iterable)paramah;
    paramah = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ah localah = (ah)((Iterator)localObject).next();
      d.g.b.k.g(localah, "it");
      paramah.add(f(localah));
    }
    paramah = (ah)j.iS(j.p((Iterable)paramah));
    AppMethodBeat.o(57943);
    return paramah;
  }
  
  protected final Set<d.l.b.a.b.f.f> a(d paramd)
  {
    AppMethodBeat.i(57937);
    d.g.b.k.h(paramd, "kindFilter");
    paramd = j.q((Iterable)((b)this.LoV.invoke()).fUi());
    a((e)this.Lpi, paramd, (d.g.a.b)c.Lpk);
    AppMethodBeat.o(57937);
    return paramd;
  }
  
  protected final void a(Collection<am> paramCollection, d.l.b.a.b.f.f paramf)
  {
    AppMethodBeat.i(57940);
    d.g.b.k.h(paramCollection, "result");
    d.g.b.k.h(paramf, "name");
    Object localObject = d.l.b.a.b.d.a.b.k.s((e)this.Lpi);
    if (localObject == null) {}
    for (localObject = (Set)x.KTH;; localObject = j.n((Iterable)((l)localObject).b(paramf, (d.l.b.a.b.c.a.a)d.l.b.a.b.c.a.c.Lkg)))
    {
      localObject = d.l.b.a.b.d.a.a.a.b(paramf, (Collection)localObject, paramCollection, (e)this.Lpi, this.LnD.LnL.Lnk, this.LnD.LnL.Lnx.gcH());
      d.g.b.k.g(localObject, "resolveOverridesForStati….overridingUtil\n        )");
      paramCollection.addAll((Collection)localObject);
      if (!this.LnZ.isEnum()) {
        break label206;
      }
      if (!d.g.b.k.g(paramf, d.l.b.a.b.j.c.LEt)) {
        break;
      }
      paramf = d.l.b.a.b.j.b.x((e)this.Lpi);
      d.g.b.k.g(paramf, "createEnumValueOfMethod(ownerDescriptor)");
      paramCollection.add(paramf);
      AppMethodBeat.o(57940);
      return;
    }
    if (d.g.b.k.g(paramf, d.l.b.a.b.j.c.LEs))
    {
      paramf = d.l.b.a.b.j.b.w((e)this.Lpi);
      d.g.b.k.g(paramf, "createEnumValuesMethod(ownerDescriptor)");
      paramCollection.add(paramf);
    }
    label206:
    AppMethodBeat.o(57940);
  }
  
  protected final Set<d.l.b.a.b.f.f> b(d paramd, d.g.a.b<? super d.l.b.a.b.f.f, Boolean> paramb)
  {
    AppMethodBeat.i(57936);
    d.g.b.k.h(paramd, "kindFilter");
    Set localSet = j.q((Iterable)((b)this.LoV.invoke()).fUh());
    paramd = d.l.b.a.b.d.a.b.k.s((e)this.Lpi);
    if (paramd != null) {}
    for (paramd = paramd.fSy();; paramd = null)
    {
      paramb = paramd;
      if (paramd == null) {
        paramb = (Set)x.KTH;
      }
      localSet.addAll((Collection)paramb);
      if (this.LnZ.isEnum()) {
        localSet.addAll((Collection)j.listOf(new d.l.b.a.b.f.f[] { d.l.b.a.b.j.c.LEt, d.l.b.a.b.j.c.LEs }));
      }
      AppMethodBeat.o(57936);
      return localSet;
    }
  }
  
  protected final void b(d.l.b.a.b.f.f paramf, Collection<ah> paramCollection)
  {
    AppMethodBeat.i(57941);
    d.g.b.k.h(paramf, "name");
    d.g.b.k.h(paramCollection, "result");
    Object localObject1 = a((e)this.Lpi, (Set)new LinkedHashSet(), (d.g.a.b)new b(paramf));
    if (!paramCollection.isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramf = d.l.b.a.b.d.a.a.a.b(paramf, (Collection)localObject1, paramCollection, (e)this.Lpi, this.LnD.LnL.Lnk, this.LnD.LnL.Lnx.gcH());
      d.g.b.k.g(paramf, "resolveOverridesForStati…ingUtil\n                )");
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
      j.a((Collection)localObject1, (Iterable)d.l.b.a.b.d.a.a.a.b(paramf, (Collection)((Map.Entry)((Iterator)localObject2).next()).getValue(), paramCollection, (e)this.Lpi, this.LnD.LnL.Lnk, this.LnD.LnL.Lnx.gcH()));
    }
    paramCollection.addAll((Collection)localObject1);
    AppMethodBeat.o(57941);
  }
  
  public final d.l.b.a.b.b.h c(d.l.b.a.b.f.f paramf, d.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(57939);
    d.g.b.k.h(paramf, "name");
    d.g.b.k.h(parama, "location");
    AppMethodBeat.o(57939);
    return null;
  }
  
  protected final Set<d.l.b.a.b.f.f> c(d paramd, d.g.a.b<? super d.l.b.a.b.f.f, Boolean> paramb)
  {
    AppMethodBeat.i(57938);
    d.g.b.k.h(paramd, "kindFilter");
    paramd = (Set)x.KTH;
    AppMethodBeat.o(57938);
    return paramd;
  }
  
  static final class a
    extends d.g.b.l
    implements d.g.a.b<p, Boolean>
  {
    public static final a Lpj;
    
    static
    {
      AppMethodBeat.i(57926);
      Lpj = new a();
      AppMethodBeat.o(57926);
    }
    
    a()
    {
      super();
    }
  }
  
  static final class b
    extends d.g.b.l
    implements d.g.a.b<d.l.b.a.b.j.f.h, Collection<? extends ah>>
  {
    b(d.l.b.a.b.f.f paramf)
    {
      super();
    }
  }
  
  static final class c
    extends d.g.b.l
    implements d.g.a.b<d.l.b.a.b.j.f.h, Set<? extends d.l.b.a.b.f.f>>
  {
    public static final c Lpk;
    
    static
    {
      AppMethodBeat.i(57929);
      Lpk = new c();
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
    public static final d Lpl;
    
    static
    {
      AppMethodBeat.i(57933);
      Lpl = new d();
      AppMethodBeat.o(57933);
    }
  }
  
  public static final class e
    extends d.l.b.a.b.o.b.a<e, y>
  {
    e(e parame, Set paramSet, d.g.a.b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.a.c.a.l
 * JD-Core Version:    0.7.0.1
 */