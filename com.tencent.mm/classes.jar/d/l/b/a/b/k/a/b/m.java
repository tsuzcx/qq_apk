package d.l.b.a.b.k.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.b.k;
import d.l.b.a.b.a.g;
import d.l.b.a.b.b.a.c;
import d.l.b.a.b.b.an;
import d.l.b.a.b.b.aq;
import d.l.b.a.b.b.aq.a;
import d.l.b.a.b.e.a.p;
import d.l.b.a.b.e.a.r;
import d.l.b.a.b.e.a.r.b;
import d.l.b.a.b.e.b.h;
import d.l.b.a.b.f.f;
import d.l.b.a.b.k.a.aa;
import d.l.b.a.b.k.a.ad;
import d.l.b.a.b.k.a.n;
import d.l.b.a.b.l.i;
import d.l.b.a.b.m.ab;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class m
  extends d.l.b.a.b.b.c.b
{
  final n LIl;
  private final b LJM;
  final a.r LJN;
  
  public m(n paramn, a.r paramr, int paramInt)
  {
    super(locali, locall, localf, aa.b((a.r.b)localObject), paramr.Lwh, paramInt, an.Lec, (aq)aq.a.Lee);
    AppMethodBeat.i(60492);
    this.LIl = paramn;
    this.LJN = paramr;
    this.LJM = new b(this.LIl.LrK.KZf, (d.g.a.a)new a(this));
    AppMethodBeat.o(60492);
  }
  
  public final List<ab> fSu()
  {
    AppMethodBeat.i(60490);
    Object localObject4 = this.LJN;
    Object localObject3 = this.LIl.KVP;
    k.h(localObject4, "$this$upperBounds");
    k.h(localObject3, "typeTable");
    Object localObject1 = ((a.r)localObject4).Lwj;
    int i;
    if (!((Collection)localObject1).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label157;
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 != null) {
        break label167;
      }
      localObject1 = ((a.r)localObject4).Lwk;
      k.g(localObject1, "upperBoundIdList");
      localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (Integer)((Iterator)localObject2).next();
        k.g(localObject4, "it");
        ((Collection)localObject1).add(((h)localObject3).ain(((Integer)localObject4).intValue()));
      }
      i = 0;
      break;
      label157:
      localObject1 = null;
    }
    Object localObject2 = (List)localObject1;
    label167:
    if (((List)localObject2).isEmpty())
    {
      localObject1 = j.listOf(d.l.b.a.b.j.d.a.G((d.l.b.a.b.b.l)this).fPH());
      AppMethodBeat.o(60490);
      return localObject1;
    }
    localObject3 = (Iterable)localObject2;
    localObject1 = this.LIl.LHX;
    localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((Collection)localObject2).add(((ad)localObject1).r((a.p)((Iterator)localObject3).next()));
    }
    localObject1 = (List)localObject2;
    AppMethodBeat.o(60490);
    return localObject1;
  }
  
  static final class a
    extends d.g.b.l
    implements d.g.a.a<List<? extends c>>
  {
    a(m paramm)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.k.a.b.m
 * JD-Core Version:    0.7.0.1
 */