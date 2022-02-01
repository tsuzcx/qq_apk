package kotlin.l.b.a.b.d.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.a.x;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.y;
import kotlin.l.b.a.b.b.ab;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.d.a.e.t;
import kotlin.l.k;

public final class d
  implements kotlin.l.b.a.b.j.f.h
{
  final j TrM;
  private final kotlin.l.b.a.b.l.f TrN;
  private final h TrO;
  private final kotlin.l.b.a.b.d.a.c.h Trn;
  
  static
  {
    AppMethodBeat.i(57783);
    cLI = new k[] { (k)aa.a(new y(aa.bp(d.class), "kotlinScopes", "getKotlinScopes()Ljava/util/List;")) };
    AppMethodBeat.o(57783);
  }
  
  public d(kotlin.l.b.a.b.d.a.c.h paramh, t paramt, h paramh1)
  {
    AppMethodBeat.i(57792);
    this.Trn = paramh;
    this.TrO = paramh1;
    this.TrM = new j(this.Trn, paramt, this.TrO);
    this.TrN = this.Trn.Trv.TcN.al((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(57792);
  }
  
  private void d(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(57791);
    p.h(paramf, "name");
    p.h(parama, "location");
    kotlin.l.b.a.b.c.a.a(this.Trn.Trv.Trb, parama, (ab)this.TrO, paramf);
    AppMethodBeat.o(57791);
  }
  
  private final List<kotlin.l.b.a.b.j.f.h> hDM()
  {
    AppMethodBeat.i(57784);
    List localList = (List)kotlin.l.b.a.b.l.i.a(this.TrN, cLI[0]);
    AppMethodBeat.o(57784);
    return localList;
  }
  
  public final Collection<ah> a(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(57786);
    p.h(paramf, "name");
    p.h(parama, "location");
    d(paramf, parama);
    Object localObject1 = this.TrM;
    Object localObject2 = hDM();
    localObject1 = ((kotlin.l.b.a.b.j.f.h)localObject1).a(paramf, parama);
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      localObject1 = kotlin.l.b.a.b.n.b.a.a((Collection)localObject1, ((kotlin.l.b.a.b.j.f.h)((Iterator)localObject2).next()).a(paramf, parama));
    }
    if (localObject1 == null) {}
    for (paramf = (Collection)x.SXt;; paramf = (kotlin.l.b.a.b.f.f)localObject1)
    {
      AppMethodBeat.o(57786);
      return paramf;
    }
  }
  
  public final Collection<l> a(kotlin.l.b.a.b.j.f.d paramd, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, Boolean> paramb)
  {
    AppMethodBeat.i(57788);
    p.h(paramd, "kindFilter");
    p.h(paramb, "nameFilter");
    Object localObject1 = this.TrM;
    Object localObject2 = hDM();
    localObject1 = ((kotlin.l.b.a.b.j.f.h)localObject1).a(paramd, paramb);
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      localObject1 = kotlin.l.b.a.b.n.b.a.a((Collection)localObject1, ((kotlin.l.b.a.b.j.f.h)((Iterator)localObject2).next()).a(paramd, paramb));
    }
    if (localObject1 == null) {}
    for (paramd = (Collection)x.SXt;; paramd = (kotlin.l.b.a.b.j.f.d)localObject1)
    {
      AppMethodBeat.o(57788);
      return paramd;
    }
  }
  
  public final Collection<am> b(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(57787);
    p.h(paramf, "name");
    p.h(parama, "location");
    d(paramf, parama);
    Object localObject1 = this.TrM;
    Object localObject2 = hDM();
    localObject1 = ((kotlin.l.b.a.b.j.f.h)localObject1).b(paramf, parama);
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      localObject1 = kotlin.l.b.a.b.n.b.a.a((Collection)localObject1, ((kotlin.l.b.a.b.j.f.h)((Iterator)localObject2).next()).b(paramf, parama));
    }
    if (localObject1 == null) {}
    for (paramf = (Collection)x.SXt;; paramf = (kotlin.l.b.a.b.f.f)localObject1)
    {
      AppMethodBeat.o(57787);
      return paramf;
    }
  }
  
  public final kotlin.l.b.a.b.b.h c(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(57785);
    p.h(paramf, "name");
    p.h(parama, "location");
    d(paramf, parama);
    Object localObject = this.TrM.e(paramf, parama);
    if (localObject != null)
    {
      paramf = (kotlin.l.b.a.b.b.h)localObject;
      AppMethodBeat.o(57785);
      return paramf;
    }
    Iterator localIterator = hDM().iterator();
    localObject = null;
    while (localIterator.hasNext())
    {
      kotlin.l.b.a.b.b.h localh = ((kotlin.l.b.a.b.j.f.h)localIterator.next()).c(paramf, parama);
      if (localh != null) {
        if (((localh instanceof kotlin.l.b.a.b.b.i)) && (((kotlin.l.b.a.b.b.i)localh).hzJ()))
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
  
  public final Set<kotlin.l.b.a.b.f.f> hCa()
  {
    AppMethodBeat.i(57789);
    Object localObject2 = (Iterable)hDM();
    Object localObject1 = (Collection)new LinkedHashSet();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      kotlin.a.j.a((Collection)localObject1, (Iterable)((kotlin.l.b.a.b.j.f.h)((Iterator)localObject2).next()).hCa());
    }
    ((Set)localObject1).addAll((Collection)this.TrM.hCa());
    localObject1 = (Set)localObject1;
    AppMethodBeat.o(57789);
    return localObject1;
  }
  
  public final Set<kotlin.l.b.a.b.f.f> hCb()
  {
    AppMethodBeat.i(57790);
    Object localObject2 = (Iterable)hDM();
    Object localObject1 = (Collection)new LinkedHashSet();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      kotlin.a.j.a((Collection)localObject1, (Iterable)((kotlin.l.b.a.b.j.f.h)((Iterator)localObject2).next()).hCb());
    }
    ((Set)localObject1).addAll((Collection)this.TrM.hCb());
    localObject1 = (Set)localObject1;
    AppMethodBeat.o(57790);
    return localObject1;
  }
  
  static final class a
    extends q
    implements kotlin.g.a.a<List<? extends kotlin.l.b.a.b.j.f.h>>
  {
    a(d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.c.a.d
 * JD-Core Version:    0.7.0.1
 */