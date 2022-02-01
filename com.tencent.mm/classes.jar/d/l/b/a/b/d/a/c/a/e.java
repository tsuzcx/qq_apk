package d.l.b.a.b.d.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.w;
import d.l.b.a.b.b.av;
import d.l.b.a.b.b.y;
import d.l.b.a.b.d.a.c.b.d;
import d.l.b.a.b.d.a.e.m;
import d.l.b.a.b.d.a.e.o;
import d.l.b.a.b.d.a.p;
import d.l.b.a.b.j.b.r;
import d.l.b.a.b.j.b.r.a;
import d.l.b.a.b.j.b.t;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.ad;
import d.l.b.a.b.m.aj;
import d.l.b.a.b.m.bh;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class e
  implements d.l.b.a.b.b.a.c, d.l.b.a.b.d.a.b.i
{
  private final d.l.b.a.b.l.f Lmf;
  private final boolean Lmh;
  private final d.l.b.a.b.l.f Lmz;
  private final d.l.b.a.b.d.a.c.h LnD;
  private final d.l.b.a.b.l.g Loh;
  private final d.l.b.a.b.d.a.d.a Loi;
  private final d.l.b.a.b.d.a.e.a Loj;
  
  static
  {
    AppMethodBeat.i(57796);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new d.g.b.u(w.bn(e.class), "fqName", "getFqName()Lorg/jetbrains/kotlin/name/FqName;")), (d.l.k)w.a(new d.g.b.u(w.bn(e.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;")), (d.l.k)w.a(new d.g.b.u(w.bn(e.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;")) };
    AppMethodBeat.o(57796);
  }
  
  public e(d.l.b.a.b.d.a.c.h paramh, d.l.b.a.b.d.a.e.a parama)
  {
    AppMethodBeat.i(57803);
    this.LnD = paramh;
    this.Loj = parama;
    this.Loh = this.LnD.LnL.KZf.P((d.g.a.a)new b(this));
    this.Lmf = this.LnD.LnL.KZf.O((d.g.a.a)new c(this));
    this.Loi = this.LnD.LnL.Lno.a((d.l.b.a.b.d.a.e.l)this.Loj);
    this.Lmz = this.LnD.LnL.KZf.O((d.g.a.a)new a(this));
    this.Lmh = false;
    AppMethodBeat.o(57803);
  }
  
  private final d.l.b.a.b.j.b.g<?> b(d.l.b.a.b.d.a.e.b paramb)
  {
    AppMethodBeat.i(57801);
    if ((paramb instanceof o))
    {
      paramb = d.l.b.a.b.j.b.h.LFu.fq(((o)paramb).getValue());
      AppMethodBeat.o(57801);
      return paramb;
    }
    Object localObject1;
    if ((paramb instanceof m))
    {
      localObject1 = ((m)paramb).fTv();
      paramb = ((m)paramb).fTw();
      if ((localObject1 == null) || (paramb == null))
      {
        AppMethodBeat.o(57801);
        return null;
      }
      paramb = (d.l.b.a.b.j.b.g)new d.l.b.a.b.j.b.j((d.l.b.a.b.f.a)localObject1, paramb);
      AppMethodBeat.o(57801);
      return paramb;
    }
    Object localObject2;
    if ((paramb instanceof d.l.b.a.b.d.a.e.e))
    {
      localObject2 = paramb.fRf();
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = p.LlB;
        d.g.b.k.g(localObject1, "DEFAULT_ANNOTATION_MEMBER_NAME");
      }
      localObject2 = ((d.l.b.a.b.d.a.e.e)paramb).fTe();
      paramb = fUk();
      d.g.b.k.g(paramb, "type");
      if (ad.aq((ab)paramb)) {
        break label445;
      }
      paramb = d.l.b.a.b.j.d.a.l(this);
      if (paramb == null) {
        d.g.b.k.fOy();
      }
      paramb = d.l.b.a.b.d.a.a.a.b((d.l.b.a.b.f.f)localObject1, paramb);
      if (paramb != null)
      {
        paramb = paramb.fRV();
        if (paramb != null) {
          break label452;
        }
      }
      paramb = (ab)this.LnD.LnL.LbH.fRE().a(bh.LLV, (ab)d.l.b.a.b.m.u.aWR("Unknown array element type"));
    }
    label445:
    label452:
    for (;;)
    {
      d.g.b.k.g(paramb, "DescriptorResolverUtils.… type\")\n                )");
      localObject1 = (Iterable)localObject2;
      Collection localCollection = (Collection)new ArrayList(d.a.j.a((Iterable)localObject1, 10));
      Iterator localIterator = ((Iterable)localObject1).iterator();
      while (localIterator.hasNext())
      {
        localObject2 = b((d.l.b.a.b.d.a.e.b)localIterator.next());
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = (d.l.b.a.b.j.b.g)new t();
        }
        localCollection.add(localObject1);
      }
      localObject1 = (List)localCollection;
      localObject2 = d.l.b.a.b.j.b.h.LFu;
      paramb = (d.l.b.a.b.j.b.g)d.l.b.a.b.j.b.h.a((List)localObject1, paramb);
      AppMethodBeat.o(57801);
      return paramb;
      if ((paramb instanceof d.l.b.a.b.d.a.e.c))
      {
        paramb = ((d.l.b.a.b.d.a.e.c)paramb).fTc();
        paramb = (d.l.b.a.b.j.b.g)new d.l.b.a.b.j.b.a((d.l.b.a.b.b.a.c)new e(this.LnD, paramb));
        AppMethodBeat.o(57801);
        return paramb;
      }
      if ((paramb instanceof d.l.b.a.b.d.a.e.h))
      {
        paramb = ((d.l.b.a.b.d.a.e.h)paramb).fTp();
        localObject1 = r.LFJ;
        paramb = r.a.af(this.LnD.LnK.a(paramb, d.a(d.l.b.a.b.d.a.a.l.LmL, false, null, 3)));
        AppMethodBeat.o(57801);
        return paramb;
      }
      AppMethodBeat.o(57801);
      return null;
    }
  }
  
  private aj fUk()
  {
    AppMethodBeat.i(57798);
    aj localaj = (aj)d.l.b.a.b.l.h.a(this.Lmf, $$delegatedProperties[1]);
    AppMethodBeat.o(57798);
    return localaj;
  }
  
  public final d.l.b.a.b.f.b fRH()
  {
    AppMethodBeat.i(57797);
    Object localObject = this.Loh;
    d.l.k localk = $$delegatedProperties[0];
    d.g.b.k.h(localObject, "$this$getValue");
    d.g.b.k.h(localk, "p");
    localObject = (d.l.b.a.b.f.b)((d.l.b.a.b.l.g)localObject).invoke();
    AppMethodBeat.o(57797);
    return localObject;
  }
  
  public final Map<d.l.b.a.b.f.f, d.l.b.a.b.j.b.g<?>> fSl()
  {
    AppMethodBeat.i(57800);
    Map localMap = (Map)d.l.b.a.b.l.h.a(this.Lmz, $$delegatedProperties[2]);
    AppMethodBeat.o(57800);
    return localMap;
  }
  
  public final boolean fUc()
  {
    return this.Lmh;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57802);
    String str = d.l.b.a.b.i.c.a(d.l.b.a.b.i.c.LCg, (d.l.b.a.b.b.a.c)this);
    AppMethodBeat.o(57802);
    return str;
  }
  
  static final class a
    extends d.g.b.l
    implements d.g.a.a<Map<d.l.b.a.b.f.f, ? extends d.l.b.a.b.j.b.g<?>>>
  {
    a(e parame)
    {
      super();
    }
  }
  
  static final class b
    extends d.g.b.l
    implements d.g.a.a<d.l.b.a.b.f.b>
  {
    b(e parame)
    {
      super();
    }
  }
  
  static final class c
    extends d.g.b.l
    implements d.g.a.a<aj>
  {
    c(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.a.c.a.e
 * JD-Core Version:    0.7.0.1
 */