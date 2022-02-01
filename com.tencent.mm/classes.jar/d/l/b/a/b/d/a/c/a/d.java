package d.l.b.a.b.d.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.x;
import d.g.b.u;
import d.g.b.w;
import d.l.b.a.b.b.ab;
import d.l.b.a.b.b.ah;
import d.l.b.a.b.b.am;
import d.l.b.a.b.d.a.e.t;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class d
  implements d.l.b.a.b.j.f.h
{
  private final d.l.b.a.b.d.a.c.h LnD;
  final j Lod;
  private final d.l.b.a.b.l.f Loe;
  private final h Lof;
  
  static
  {
    AppMethodBeat.i(57783);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(d.class), "kotlinScopes", "getKotlinScopes()Ljava/util/List;")) };
    AppMethodBeat.o(57783);
  }
  
  public d(d.l.b.a.b.d.a.c.h paramh, t paramt, h paramh1)
  {
    AppMethodBeat.i(57792);
    this.LnD = paramh;
    this.Lof = paramh1;
    this.Lod = new j(this.LnD, paramt, this.Lof);
    this.Loe = this.LnD.LnL.KZf.O((d.g.a.a)new a(this));
    AppMethodBeat.o(57792);
  }
  
  private void d(d.l.b.a.b.f.f paramf, d.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(57791);
    d.g.b.k.h(paramf, "name");
    d.g.b.k.h(parama, "location");
    d.l.b.a.b.c.a.a(this.LnD.LnL.Lnr, parama, (ab)this.Lof, paramf);
    AppMethodBeat.o(57791);
  }
  
  private final List<d.l.b.a.b.j.f.h> fUj()
  {
    AppMethodBeat.i(57784);
    List localList = (List)d.l.b.a.b.l.h.a(this.Loe, $$delegatedProperties[0]);
    AppMethodBeat.o(57784);
    return localList;
  }
  
  public final Collection<ah> a(d.l.b.a.b.f.f paramf, d.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(57786);
    d.g.b.k.h(paramf, "name");
    d.g.b.k.h(parama, "location");
    d(paramf, parama);
    Object localObject1 = this.Lod;
    Object localObject2 = fUj();
    localObject1 = ((d.l.b.a.b.j.f.h)localObject1).a(paramf, parama);
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      localObject1 = d.l.b.a.b.n.b.a.a((Collection)localObject1, ((d.l.b.a.b.j.f.h)((Iterator)localObject2).next()).a(paramf, parama));
    }
    if (localObject1 == null) {}
    for (paramf = (Collection)x.KTH;; paramf = (d.l.b.a.b.f.f)localObject1)
    {
      AppMethodBeat.o(57786);
      return paramf;
    }
  }
  
  public final Collection<d.l.b.a.b.b.l> a(d.l.b.a.b.j.f.d paramd, d.g.a.b<? super d.l.b.a.b.f.f, Boolean> paramb)
  {
    AppMethodBeat.i(57788);
    d.g.b.k.h(paramd, "kindFilter");
    d.g.b.k.h(paramb, "nameFilter");
    Object localObject1 = this.Lod;
    Object localObject2 = fUj();
    localObject1 = ((d.l.b.a.b.j.f.h)localObject1).a(paramd, paramb);
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      localObject1 = d.l.b.a.b.n.b.a.a((Collection)localObject1, ((d.l.b.a.b.j.f.h)((Iterator)localObject2).next()).a(paramd, paramb));
    }
    if (localObject1 == null) {}
    for (paramd = (Collection)x.KTH;; paramd = (d.l.b.a.b.j.f.d)localObject1)
    {
      AppMethodBeat.o(57788);
      return paramd;
    }
  }
  
  public final Collection<am> b(d.l.b.a.b.f.f paramf, d.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(57787);
    d.g.b.k.h(paramf, "name");
    d.g.b.k.h(parama, "location");
    d(paramf, parama);
    Object localObject1 = this.Lod;
    Object localObject2 = fUj();
    localObject1 = ((d.l.b.a.b.j.f.h)localObject1).b(paramf, parama);
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      localObject1 = d.l.b.a.b.n.b.a.a((Collection)localObject1, ((d.l.b.a.b.j.f.h)((Iterator)localObject2).next()).b(paramf, parama));
    }
    if (localObject1 == null) {}
    for (paramf = (Collection)x.KTH;; paramf = (d.l.b.a.b.f.f)localObject1)
    {
      AppMethodBeat.o(57787);
      return paramf;
    }
  }
  
  public final d.l.b.a.b.b.h c(d.l.b.a.b.f.f paramf, d.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(57785);
    d.g.b.k.h(paramf, "name");
    d.g.b.k.h(parama, "location");
    d(paramf, parama);
    Object localObject = this.Lod.e(paramf, parama);
    if (localObject != null)
    {
      paramf = (d.l.b.a.b.b.h)localObject;
      AppMethodBeat.o(57785);
      return paramf;
    }
    Iterator localIterator = fUj().iterator();
    localObject = null;
    while (localIterator.hasNext())
    {
      d.l.b.a.b.b.h localh = ((d.l.b.a.b.j.f.h)localIterator.next()).c(paramf, parama);
      if (localh != null) {
        if (((localh instanceof d.l.b.a.b.b.i)) && (((d.l.b.a.b.b.i)localh).fQg()))
        {
          if (localObject == null) {
            localObject = localh;
          }
        }
        else
        {
          AppMethodBeat.o(57785);
          return localh;
        }
      }
    }
    AppMethodBeat.o(57785);
    return localObject;
  }
  
  public final Set<d.l.b.a.b.f.f> fSy()
  {
    AppMethodBeat.i(57789);
    Object localObject2 = (Iterable)fUj();
    Object localObject1 = (Collection)new LinkedHashSet();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      d.a.j.a((Collection)localObject1, (Iterable)((d.l.b.a.b.j.f.h)((Iterator)localObject2).next()).fSy());
    }
    ((Set)localObject1).addAll((Collection)this.Lod.fSy());
    localObject1 = (Set)localObject1;
    AppMethodBeat.o(57789);
    return localObject1;
  }
  
  public final Set<d.l.b.a.b.f.f> fSz()
  {
    AppMethodBeat.i(57790);
    Object localObject2 = (Iterable)fUj();
    Object localObject1 = (Collection)new LinkedHashSet();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      d.a.j.a((Collection)localObject1, (Iterable)((d.l.b.a.b.j.f.h)((Iterator)localObject2).next()).fSz());
    }
    ((Set)localObject1).addAll((Collection)this.Lod.fSz());
    localObject1 = (Set)localObject1;
    AppMethodBeat.o(57790);
    return localObject1;
  }
  
  static final class a
    extends d.g.b.l
    implements d.g.a.a<List<? extends d.l.b.a.b.j.f.h>>
  {
    a(d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.a.c.a.d
 * JD-Core Version:    0.7.0.1
 */