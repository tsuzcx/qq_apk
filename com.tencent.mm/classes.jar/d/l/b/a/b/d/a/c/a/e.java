package d.l.b.a.b.d.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.q;
import d.g.b.x;
import d.g.b.z;
import d.l.b.a.b.b.av;
import d.l.b.a.b.b.y;
import d.l.b.a.b.d.a.c.b.d;
import d.l.b.a.b.d.a.e.m;
import d.l.b.a.b.d.a.e.o;
import d.l.b.a.b.j.b.r;
import d.l.b.a.b.j.b.r.a;
import d.l.b.a.b.j.b.t;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.ad;
import d.l.b.a.b.m.aj;
import d.l.b.a.b.m.bh;
import d.l.b.a.b.m.u;
import d.l.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class e
  implements d.l.b.a.b.b.a.c, d.l.b.a.b.d.a.b.i
{
  private final d.l.b.a.b.l.f Ndc;
  private final boolean Nde;
  private final d.l.b.a.b.l.f Ndw;
  private final d.l.b.a.b.d.a.c.h NeA;
  private final d.l.b.a.b.l.g Nfe;
  private final d.l.b.a.b.d.a.d.a Nff;
  private final d.l.b.a.b.d.a.e.a Nfg;
  
  static
  {
    AppMethodBeat.i(57796);
    cwV = new k[] { (k)z.a(new x(z.bp(e.class), "fqName", "getFqName()Lorg/jetbrains/kotlin/name/FqName;")), (k)z.a(new x(z.bp(e.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;")), (k)z.a(new x(z.bp(e.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;")) };
    AppMethodBeat.o(57796);
  }
  
  public e(d.l.b.a.b.d.a.c.h paramh, d.l.b.a.b.d.a.e.a parama)
  {
    AppMethodBeat.i(57803);
    this.NeA = paramh;
    this.Nfg = parama;
    this.Nfe = this.NeA.NeI.MQa.T((d.g.a.a)new b(this));
    this.Ndc = this.NeA.NeI.MQa.S((d.g.a.a)new c(this));
    this.Nff = this.NeA.NeI.Nel.a((d.l.b.a.b.d.a.e.l)this.Nfg);
    this.Ndw = this.NeA.NeI.MQa.S((d.g.a.a)new a(this));
    this.Nde = false;
    AppMethodBeat.o(57803);
  }
  
  private final d.l.b.a.b.j.b.g<?> b(d.l.b.a.b.d.a.e.b paramb)
  {
    AppMethodBeat.i(57801);
    if ((paramb instanceof o))
    {
      paramb = d.l.b.a.b.j.b.h.Nws.fs(((o)paramb).getValue());
      AppMethodBeat.o(57801);
      return paramb;
    }
    Object localObject1;
    if ((paramb instanceof m))
    {
      localObject1 = ((m)paramb).gkU();
      paramb = ((m)paramb).gkV();
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
      localObject2 = paramb.giD();
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = d.l.b.a.b.d.a.p.Ncy;
        d.g.b.p.g(localObject1, "DEFAULT_ANNOTATION_MEMBER_NAME");
      }
      localObject2 = ((d.l.b.a.b.d.a.e.e)paramb).gkD();
      paramb = glJ();
      d.g.b.p.g(paramb, "type");
      if (ad.aq((ab)paramb)) {
        break label445;
      }
      paramb = d.l.b.a.b.j.d.a.l(this);
      if (paramb == null) {
        d.g.b.p.gfZ();
      }
      paramb = d.l.b.a.b.d.a.a.a.b((d.l.b.a.b.f.f)localObject1, paramb);
      if (paramb != null)
      {
        paramb = paramb.gju();
        if (paramb != null) {
          break label452;
        }
      }
      paramb = (ab)this.NeA.NeI.MSC.gjd().a(bh.NCP, (ab)u.bcU("Unknown array element type"));
    }
    label445:
    label452:
    for (;;)
    {
      d.g.b.p.g(paramb, "DescriptorResolverUtils.… type\")\n                )");
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
      localObject2 = d.l.b.a.b.j.b.h.Nws;
      paramb = (d.l.b.a.b.j.b.g)d.l.b.a.b.j.b.h.a((List)localObject1, paramb);
      AppMethodBeat.o(57801);
      return paramb;
      if ((paramb instanceof d.l.b.a.b.d.a.e.c))
      {
        paramb = ((d.l.b.a.b.d.a.e.c)paramb).gkB();
        paramb = (d.l.b.a.b.j.b.g)new d.l.b.a.b.j.b.a((d.l.b.a.b.b.a.c)new e(this.NeA, paramb));
        AppMethodBeat.o(57801);
        return paramb;
      }
      if ((paramb instanceof d.l.b.a.b.d.a.e.h))
      {
        paramb = ((d.l.b.a.b.d.a.e.h)paramb).gkO();
        localObject1 = r.NwH;
        paramb = r.a.af(this.NeA.NeH.a(paramb, d.a(d.l.b.a.b.d.a.a.l.NdI, false, null, 3)));
        AppMethodBeat.o(57801);
        return paramb;
      }
      AppMethodBeat.o(57801);
      return null;
    }
  }
  
  private aj glJ()
  {
    AppMethodBeat.i(57798);
    aj localaj = (aj)d.l.b.a.b.l.i.a(this.Ndc, cwV[1]);
    AppMethodBeat.o(57798);
    return localaj;
  }
  
  public final Map<d.l.b.a.b.f.f, d.l.b.a.b.j.b.g<?>> gjK()
  {
    AppMethodBeat.i(57800);
    Map localMap = (Map)d.l.b.a.b.l.i.a(this.Ndw, cwV[2]);
    AppMethodBeat.o(57800);
    return localMap;
  }
  
  public final d.l.b.a.b.f.b gjg()
  {
    AppMethodBeat.i(57797);
    Object localObject = this.Nfe;
    k localk = cwV[0];
    d.g.b.p.h(localObject, "$this$getValue");
    d.g.b.p.h(localk, "p");
    localObject = (d.l.b.a.b.f.b)((d.l.b.a.b.l.g)localObject).invoke();
    AppMethodBeat.o(57797);
    return localObject;
  }
  
  public final boolean glB()
  {
    return this.Nde;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57802);
    String str = d.l.b.a.b.i.c.a(d.l.b.a.b.i.c.Ntc, (d.l.b.a.b.b.a.c)this);
    AppMethodBeat.o(57802);
    return str;
  }
  
  static final class a
    extends q
    implements d.g.a.a<Map<d.l.b.a.b.f.f, ? extends d.l.b.a.b.j.b.g<?>>>
  {
    a(e parame)
    {
      super();
    }
  }
  
  static final class b
    extends q
    implements d.g.a.a<d.l.b.a.b.f.b>
  {
    b(e parame)
    {
      super();
    }
  }
  
  static final class c
    extends q
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