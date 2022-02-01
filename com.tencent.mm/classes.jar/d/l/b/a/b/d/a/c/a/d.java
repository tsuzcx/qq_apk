package d.l.b.a.b.d.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.g.b.q;
import d.g.b.z;
import d.l.b.a.b.b.ab;
import d.l.b.a.b.b.ah;
import d.l.b.a.b.b.am;
import d.l.b.a.b.b.l;
import d.l.b.a.b.d.a.e.t;
import d.l.k;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class d
  implements d.l.b.a.b.j.f.h
{
  private final d.l.b.a.b.d.a.c.h NBF;
  final j NCf;
  private final d.l.b.a.b.l.f NCg;
  private final h NCh;
  
  static
  {
    AppMethodBeat.i(57783);
    cxA = new k[] { (k)z.a(new d.g.b.x(z.bp(d.class), "kotlinScopes", "getKotlinScopes()Ljava/util/List;")) };
    AppMethodBeat.o(57783);
  }
  
  public d(d.l.b.a.b.d.a.c.h paramh, t paramt, h paramh1)
  {
    AppMethodBeat.i(57792);
    this.NBF = paramh;
    this.NCh = paramh1;
    this.NCf = new j(this.NBF, paramt, this.NCh);
    this.NCg = this.NBF.NBN.Nnf.S((d.g.a.a)new a(this));
    AppMethodBeat.o(57792);
  }
  
  private void d(d.l.b.a.b.f.f paramf, d.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(57791);
    p.h(paramf, "name");
    p.h(parama, "location");
    d.l.b.a.b.c.a.a(this.NBF.NBN.NBt, parama, (ab)this.NCh, paramf);
    AppMethodBeat.o(57791);
  }
  
  private final List<d.l.b.a.b.j.f.h> gqk()
  {
    AppMethodBeat.i(57784);
    List localList = (List)d.l.b.a.b.l.i.a(this.NCg, cxA[0]);
    AppMethodBeat.o(57784);
    return localList;
  }
  
  public final Collection<ah> a(d.l.b.a.b.f.f paramf, d.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(57786);
    p.h(paramf, "name");
    p.h(parama, "location");
    d(paramf, parama);
    Object localObject1 = this.NCf;
    Object localObject2 = gqk();
    localObject1 = ((d.l.b.a.b.j.f.h)localObject1).a(paramf, parama);
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      localObject1 = d.l.b.a.b.n.b.a.a((Collection)localObject1, ((d.l.b.a.b.j.f.h)((Iterator)localObject2).next()).a(paramf, parama));
    }
    if (localObject1 == null) {}
    for (paramf = (Collection)d.a.x.NhJ;; paramf = (d.l.b.a.b.f.f)localObject1)
    {
      AppMethodBeat.o(57786);
      return paramf;
    }
  }
  
  public final Collection<l> a(d.l.b.a.b.j.f.d paramd, d.g.a.b<? super d.l.b.a.b.f.f, Boolean> paramb)
  {
    AppMethodBeat.i(57788);
    p.h(paramd, "kindFilter");
    p.h(paramb, "nameFilter");
    Object localObject1 = this.NCf;
    Object localObject2 = gqk();
    localObject1 = ((d.l.b.a.b.j.f.h)localObject1).a(paramd, paramb);
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      localObject1 = d.l.b.a.b.n.b.a.a((Collection)localObject1, ((d.l.b.a.b.j.f.h)((Iterator)localObject2).next()).a(paramd, paramb));
    }
    if (localObject1 == null) {}
    for (paramd = (Collection)d.a.x.NhJ;; paramd = (d.l.b.a.b.j.f.d)localObject1)
    {
      AppMethodBeat.o(57788);
      return paramd;
    }
  }
  
  public final Collection<am> b(d.l.b.a.b.f.f paramf, d.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(57787);
    p.h(paramf, "name");
    p.h(parama, "location");
    d(paramf, parama);
    Object localObject1 = this.NCf;
    Object localObject2 = gqk();
    localObject1 = ((d.l.b.a.b.j.f.h)localObject1).b(paramf, parama);
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      localObject1 = d.l.b.a.b.n.b.a.a((Collection)localObject1, ((d.l.b.a.b.j.f.h)((Iterator)localObject2).next()).b(paramf, parama));
    }
    if (localObject1 == null) {}
    for (paramf = (Collection)d.a.x.NhJ;; paramf = (d.l.b.a.b.f.f)localObject1)
    {
      AppMethodBeat.o(57787);
      return paramf;
    }
  }
  
  public final d.l.b.a.b.b.h c(d.l.b.a.b.f.f paramf, d.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(57785);
    p.h(paramf, "name");
    p.h(parama, "location");
    d(paramf, parama);
    Object localObject = this.NCf.e(paramf, parama);
    if (localObject != null)
    {
      paramf = (d.l.b.a.b.b.h)localObject;
      AppMethodBeat.o(57785);
      return paramf;
    }
    Iterator localIterator = gqk().iterator();
    localObject = null;
    while (localIterator.hasNext())
    {
      d.l.b.a.b.b.h localh = ((d.l.b.a.b.j.f.h)localIterator.next()).c(paramf, parama);
      if (localh != null) {
        if (((localh instanceof d.l.b.a.b.b.i)) && (((d.l.b.a.b.b.i)localh).gmg()))
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
  
  public final Set<d.l.b.a.b.f.f> goy()
  {
    AppMethodBeat.i(57789);
    Object localObject2 = (Iterable)gqk();
    Object localObject1 = (Collection)new LinkedHashSet();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      d.a.j.a((Collection)localObject1, (Iterable)((d.l.b.a.b.j.f.h)((Iterator)localObject2).next()).goy());
    }
    ((Set)localObject1).addAll((Collection)this.NCf.goy());
    localObject1 = (Set)localObject1;
    AppMethodBeat.o(57789);
    return localObject1;
  }
  
  public final Set<d.l.b.a.b.f.f> goz()
  {
    AppMethodBeat.i(57790);
    Object localObject2 = (Iterable)gqk();
    Object localObject1 = (Collection)new LinkedHashSet();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      d.a.j.a((Collection)localObject1, (Iterable)((d.l.b.a.b.j.f.h)((Iterator)localObject2).next()).goz());
    }
    ((Set)localObject1).addAll((Collection)this.NCf.goz());
    localObject1 = (Set)localObject1;
    AppMethodBeat.o(57790);
    return localObject1;
  }
  
  static final class a
    extends q
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