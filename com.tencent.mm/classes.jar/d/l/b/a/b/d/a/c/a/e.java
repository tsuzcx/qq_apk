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
  private final d.l.b.a.b.l.g JAO;
  private final d.l.b.a.b.d.a.d.a JAP;
  private final d.l.b.a.b.d.a.e.a JAQ;
  private final d.l.b.a.b.d.a.c.h JAk;
  private final d.l.b.a.b.l.f JyM;
  private final boolean JyO;
  private final d.l.b.a.b.l.f Jzg;
  
  static
  {
    AppMethodBeat.i(57796);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new d.g.b.u(w.bk(e.class), "fqName", "getFqName()Lorg/jetbrains/kotlin/name/FqName;")), (d.l.k)w.a(new d.g.b.u(w.bk(e.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;")), (d.l.k)w.a(new d.g.b.u(w.bk(e.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;")) };
    AppMethodBeat.o(57796);
  }
  
  public e(d.l.b.a.b.d.a.c.h paramh, d.l.b.a.b.d.a.e.a parama)
  {
    AppMethodBeat.i(57803);
    this.JAk = paramh;
    this.JAQ = parama;
    this.JAO = this.JAk.JAs.JlL.I((d.g.a.a)new b(this));
    this.JyM = this.JAk.JAs.JlL.H((d.g.a.a)new c(this));
    this.JAP = this.JAk.JAs.JzV.a((d.l.b.a.b.d.a.e.l)this.JAQ);
    this.Jzg = this.JAk.JAs.JlL.H((d.g.a.a)new a(this));
    this.JyO = false;
    AppMethodBeat.o(57803);
  }
  
  private final d.l.b.a.b.j.b.g<?> b(d.l.b.a.b.d.a.e.b paramb)
  {
    AppMethodBeat.i(57801);
    if ((paramb instanceof o))
    {
      paramb = d.l.b.a.b.j.b.h.JSb.fn(((o)paramb).getValue());
      AppMethodBeat.o(57801);
      return paramb;
    }
    Object localObject1;
    if ((paramb instanceof m))
    {
      localObject1 = ((m)paramb).fAR();
      paramb = ((m)paramb).fAS();
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
      localObject2 = paramb.fyB();
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = p.Jyi;
        d.g.b.k.g(localObject1, "DEFAULT_ANNOTATION_MEMBER_NAME");
      }
      localObject2 = ((d.l.b.a.b.d.a.e.e)paramb).fAA();
      paramb = fBG();
      d.g.b.k.g(paramb, "type");
      if (ad.aq((ab)paramb)) {
        break label445;
      }
      paramb = d.l.b.a.b.j.d.a.l(this);
      if (paramb == null) {
        d.g.b.k.fvU();
      }
      paramb = d.l.b.a.b.d.a.a.a.b((d.l.b.a.b.f.f)localObject1, paramb);
      if (paramb != null)
      {
        paramb = paramb.fzr();
        if (paramb != null) {
          break label452;
        }
      }
      paramb = (ab)this.JAk.JAs.Jon.fza().a(bh.JYC, (ab)d.l.b.a.b.m.u.aQS("Unknown array element type"));
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
      localObject2 = d.l.b.a.b.j.b.h.JSb;
      paramb = (d.l.b.a.b.j.b.g)d.l.b.a.b.j.b.h.a((List)localObject1, paramb);
      AppMethodBeat.o(57801);
      return paramb;
      if ((paramb instanceof d.l.b.a.b.d.a.e.c))
      {
        paramb = ((d.l.b.a.b.d.a.e.c)paramb).fAy();
        paramb = (d.l.b.a.b.j.b.g)new d.l.b.a.b.j.b.a((d.l.b.a.b.b.a.c)new e(this.JAk, paramb));
        AppMethodBeat.o(57801);
        return paramb;
      }
      if ((paramb instanceof d.l.b.a.b.d.a.e.h))
      {
        paramb = ((d.l.b.a.b.d.a.e.h)paramb).fAL();
        localObject1 = r.JSq;
        paramb = r.a.af(this.JAk.JAr.a(paramb, d.a(d.l.b.a.b.d.a.a.l.Jzs, false, null, 3)));
        AppMethodBeat.o(57801);
        return paramb;
      }
      AppMethodBeat.o(57801);
      return null;
    }
  }
  
  private aj fBG()
  {
    AppMethodBeat.i(57798);
    aj localaj = (aj)d.l.b.a.b.l.h.a(this.JyM, $$delegatedProperties[1]);
    AppMethodBeat.o(57798);
    return localaj;
  }
  
  public final boolean fBy()
  {
    return this.JyO;
  }
  
  public final Map<d.l.b.a.b.f.f, d.l.b.a.b.j.b.g<?>> fzH()
  {
    AppMethodBeat.i(57800);
    Map localMap = (Map)d.l.b.a.b.l.h.a(this.Jzg, $$delegatedProperties[2]);
    AppMethodBeat.o(57800);
    return localMap;
  }
  
  public final d.l.b.a.b.f.b fzd()
  {
    AppMethodBeat.i(57797);
    Object localObject = this.JAO;
    d.l.k localk = $$delegatedProperties[0];
    d.g.b.k.h(localObject, "$this$getValue");
    d.g.b.k.h(localk, "p");
    localObject = (d.l.b.a.b.f.b)((d.l.b.a.b.l.g)localObject).invoke();
    AppMethodBeat.o(57797);
    return localObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57802);
    String str = d.l.b.a.b.i.c.a(d.l.b.a.b.i.c.JOM, (d.l.b.a.b.b.a.c)this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.d.a.c.a.e
 * JD-Core Version:    0.7.0.1
 */