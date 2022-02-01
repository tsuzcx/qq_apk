package d.l.b.a.b.k.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.g.b.q;
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
import d.l.b.a.b.m.ab;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class m
  extends d.l.b.a.b.b.c.b
{
  private final b NAK;
  final a.r NAL;
  final n Nzj;
  
  public m(n paramn, a.r paramr, int paramInt)
  {
    super(localj, locall, localf, aa.b((a.r.b)localObject), paramr.Nne, paramInt, an.MUX, (aq)aq.a.MUZ);
    AppMethodBeat.i(60492);
    this.Nzj = paramn;
    this.NAL = paramr;
    this.NAK = new b(this.Nzj.NiH.MQa, (d.g.a.a)new a(this));
    AppMethodBeat.o(60492);
  }
  
  public final List<ab> gjS()
  {
    AppMethodBeat.i(60490);
    Object localObject4 = this.NAL;
    Object localObject3 = this.Nzj.MMV;
    p.h(localObject4, "$this$upperBounds");
    p.h(localObject3, "typeTable");
    Object localObject1 = ((a.r)localObject4).Nng;
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
      localObject1 = ((a.r)localObject4).Nnh;
      p.g(localObject1, "upperBoundIdList");
      localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (Integer)((Iterator)localObject2).next();
        p.g(localObject4, "it");
        ((Collection)localObject1).add(((h)localObject3).akO(((Integer)localObject4).intValue()));
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
      localObject1 = d.a.j.listOf(d.l.b.a.b.j.d.a.G((d.l.b.a.b.b.l)this).ghf());
      AppMethodBeat.o(60490);
      return localObject1;
    }
    localObject3 = (Iterable)localObject2;
    localObject1 = this.Nzj.NyV;
    localObject2 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((Collection)localObject2).add(((ad)localObject1).r((a.p)((Iterator)localObject3).next()));
    }
    localObject1 = (List)localObject2;
    AppMethodBeat.o(60490);
    return localObject1;
  }
  
  static final class a
    extends q
    implements d.g.a.a<List<? extends c>>
  {
    a(m paramm)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.k.a.b.m
 * JD-Core Version:    0.7.0.1
 */