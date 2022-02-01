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
  private final d.l.b.a.b.l.f NAB;
  private final d.l.b.a.b.l.f NAh;
  private final boolean NAj;
  private final d.l.b.a.b.d.a.c.h NBF;
  private final d.l.b.a.b.l.g NCj;
  private final d.l.b.a.b.d.a.d.a NCk;
  private final d.l.b.a.b.d.a.e.a NCl;
  
  static
  {
    AppMethodBeat.i(57796);
    cxA = new k[] { (k)z.a(new x(z.bp(e.class), "fqName", "getFqName()Lorg/jetbrains/kotlin/name/FqName;")), (k)z.a(new x(z.bp(e.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;")), (k)z.a(new x(z.bp(e.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;")) };
    AppMethodBeat.o(57796);
  }
  
  public e(d.l.b.a.b.d.a.c.h paramh, d.l.b.a.b.d.a.e.a parama)
  {
    AppMethodBeat.i(57803);
    this.NBF = paramh;
    this.NCl = parama;
    this.NCj = this.NBF.NBN.Nnf.T((d.g.a.a)new b(this));
    this.NAh = this.NBF.NBN.Nnf.S((d.g.a.a)new c(this));
    this.NCk = this.NBF.NBN.NBq.a((d.l.b.a.b.d.a.e.l)this.NCl);
    this.NAB = this.NBF.NBN.Nnf.S((d.g.a.a)new a(this));
    this.NAj = false;
    AppMethodBeat.o(57803);
  }
  
  private final d.l.b.a.b.j.b.g<?> b(d.l.b.a.b.d.a.e.b paramb)
  {
    AppMethodBeat.i(57801);
    if ((paramb instanceof o))
    {
      paramb = d.l.b.a.b.j.b.h.NTy.fv(((o)paramb).getValue());
      AppMethodBeat.o(57801);
      return paramb;
    }
    Object localObject1;
    if ((paramb instanceof m))
    {
      localObject1 = ((m)paramb).gpw();
      paramb = ((m)paramb).gpx();
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
      localObject2 = paramb.gnf();
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = d.l.b.a.b.d.a.p.NzD;
        d.g.b.p.g(localObject1, "DEFAULT_ANNOTATION_MEMBER_NAME");
      }
      localObject2 = ((d.l.b.a.b.d.a.e.e)paramb).gpf();
      paramb = gql();
      d.g.b.p.g(paramb, "type");
      if (ad.aq((ab)paramb)) {
        break label445;
      }
      paramb = d.l.b.a.b.j.d.a.l(this);
      if (paramb == null) {
        d.g.b.p.gkB();
      }
      paramb = d.l.b.a.b.d.a.a.a.b((d.l.b.a.b.f.f)localObject1, paramb);
      if (paramb != null)
      {
        paramb = paramb.gnW();
        if (paramb != null) {
          break label452;
        }
      }
      paramb = (ab)this.NBF.NBN.NpH.gnF().a(bh.NZW, (ab)u.bey("Unknown array element type"));
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
      localObject2 = d.l.b.a.b.j.b.h.NTy;
      paramb = (d.l.b.a.b.j.b.g)d.l.b.a.b.j.b.h.a((List)localObject1, paramb);
      AppMethodBeat.o(57801);
      return paramb;
      if ((paramb instanceof d.l.b.a.b.d.a.e.c))
      {
        paramb = ((d.l.b.a.b.d.a.e.c)paramb).gpd();
        paramb = (d.l.b.a.b.j.b.g)new d.l.b.a.b.j.b.a((d.l.b.a.b.b.a.c)new e(this.NBF, paramb));
        AppMethodBeat.o(57801);
        return paramb;
      }
      if ((paramb instanceof d.l.b.a.b.d.a.e.h))
      {
        paramb = ((d.l.b.a.b.d.a.e.h)paramb).gpq();
        localObject1 = r.NTN;
        paramb = r.a.af(this.NBF.NBM.a(paramb, d.a(d.l.b.a.b.d.a.a.l.NAN, false, null, 3)));
        AppMethodBeat.o(57801);
        return paramb;
      }
      AppMethodBeat.o(57801);
      return null;
    }
  }
  
  private aj gql()
  {
    AppMethodBeat.i(57798);
    aj localaj = (aj)d.l.b.a.b.l.i.a(this.NAh, cxA[1]);
    AppMethodBeat.o(57798);
    return localaj;
  }
  
  public final d.l.b.a.b.f.b gnI()
  {
    AppMethodBeat.i(57797);
    Object localObject = this.NCj;
    k localk = cxA[0];
    d.g.b.p.h(localObject, "$this$getValue");
    d.g.b.p.h(localk, "p");
    localObject = (d.l.b.a.b.f.b)((d.l.b.a.b.l.g)localObject).invoke();
    AppMethodBeat.o(57797);
    return localObject;
  }
  
  public final Map<d.l.b.a.b.f.f, d.l.b.a.b.j.b.g<?>> gom()
  {
    AppMethodBeat.i(57800);
    Map localMap = (Map)d.l.b.a.b.l.i.a(this.NAB, cxA[2]);
    AppMethodBeat.o(57800);
    return localMap;
  }
  
  public final boolean gqd()
  {
    return this.NAj;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57802);
    String str = d.l.b.a.b.i.c.a(d.l.b.a.b.i.c.NQi, (d.l.b.a.b.b.a.c)this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.a.c.a.e
 * JD-Core Version:    0.7.0.1
 */