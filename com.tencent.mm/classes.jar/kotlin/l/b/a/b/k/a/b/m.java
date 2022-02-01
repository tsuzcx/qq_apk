package kotlin.l.b.a.b.k.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.b.a.c;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.aq;
import kotlin.l.b.a.b.b.aq.a;
import kotlin.l.b.a.b.e.a.p;
import kotlin.l.b.a.b.e.a.r;
import kotlin.l.b.a.b.e.a.r.b;
import kotlin.l.b.a.b.e.b.h;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.k.a.aa;
import kotlin.l.b.a.b.k.a.ad;
import kotlin.l.b.a.b.k.a.n;
import kotlin.l.b.a.b.m.ab;

public final class m
  extends kotlin.l.b.a.b.b.c.b
{
  final n TLm;
  private final b TMK;
  final a.r TML;
  
  public m(n paramn, a.r paramr, int paramInt)
  {
    super(localj, locall, localf, aa.b((a.r.b)localObject), paramr.TzM, paramInt, an.ThK, (aq)aq.a.ThM);
    AppMethodBeat.i(60492);
    this.TLm = paramn;
    this.TML = paramr;
    this.TMK = new b(this.TLm.Tvt.TcN, (kotlin.g.a.a)new a(this));
    AppMethodBeat.o(60492);
  }
  
  public final List<ab> hBW()
  {
    AppMethodBeat.i(60490);
    Object localObject4 = this.TML;
    Object localObject3 = this.TLm.SZI;
    p.h(localObject4, "$this$upperBounds");
    p.h(localObject3, "typeTable");
    Object localObject1 = ((a.r)localObject4).TzO;
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
      localObject1 = ((a.r)localObject4).TzP;
      p.g(localObject1, "upperBoundIdList");
      localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (Integer)((Iterator)localObject2).next();
        p.g(localObject4, "it");
        ((Collection)localObject1).add(((h)localObject3).avo(((Integer)localObject4).intValue()));
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
      localObject1 = kotlin.a.j.listOf(kotlin.l.b.a.b.j.d.a.G((kotlin.l.b.a.b.b.l)this).hzk());
      AppMethodBeat.o(60490);
      return localObject1;
    }
    localObject3 = (Iterable)localObject2;
    localObject1 = this.TLm.TKY;
    localObject2 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject3, 10));
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
    implements kotlin.g.a.a<List<? extends c>>
  {
    a(m paramm)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.b.m
 * JD-Core Version:    0.7.0.1
 */