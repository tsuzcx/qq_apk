package kotlin.l.b.a.b.d.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.b.aa;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.d.a.c.b.d;
import kotlin.l.b.a.b.d.a.e.m;
import kotlin.l.b.a.b.d.a.e.o;
import kotlin.l.b.a.b.j.b.r;
import kotlin.l.b.a.b.j.b.r.a;
import kotlin.l.b.a.b.j.b.t;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.bh;
import kotlin.l.b.a.b.m.u;
import kotlin.l.k;

public final class e
  implements kotlin.l.b.a.b.b.a.c, kotlin.l.b.a.b.d.a.b.i
{
  private final kotlin.l.b.a.b.l.f TpP;
  private final boolean TpR;
  private final kotlin.l.b.a.b.l.f Tqj;
  private final kotlin.l.b.a.b.l.g TrQ;
  private final kotlin.l.b.a.b.d.a.d.a TrR;
  private final kotlin.l.b.a.b.d.a.e.a TrS;
  private final kotlin.l.b.a.b.d.a.c.h Trn;
  
  static
  {
    AppMethodBeat.i(57796);
    cLI = new k[] { (k)aa.a(new kotlin.g.b.y(aa.bp(e.class), "fqName", "getFqName()Lorg/jetbrains/kotlin/name/FqName;")), (k)aa.a(new kotlin.g.b.y(aa.bp(e.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;")), (k)aa.a(new kotlin.g.b.y(aa.bp(e.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;")) };
    AppMethodBeat.o(57796);
  }
  
  public e(kotlin.l.b.a.b.d.a.c.h paramh, kotlin.l.b.a.b.d.a.e.a parama)
  {
    AppMethodBeat.i(57803);
    this.Trn = paramh;
    this.TrS = parama;
    this.TrQ = this.Trn.Trv.TcN.am((kotlin.g.a.a)new b(this));
    this.TpP = this.Trn.Trv.TcN.al((kotlin.g.a.a)new c(this));
    this.TrR = this.Trn.Trv.TqY.a((kotlin.l.b.a.b.d.a.e.l)this.TrS);
    this.Tqj = this.Trn.Trv.TcN.al((kotlin.g.a.a)new a(this));
    this.TpR = false;
    AppMethodBeat.o(57803);
  }
  
  private final kotlin.l.b.a.b.j.b.g<?> b(kotlin.l.b.a.b.d.a.e.b paramb)
  {
    AppMethodBeat.i(57801);
    if ((paramb instanceof o))
    {
      paramb = kotlin.l.b.a.b.j.b.h.TIu.fz(((o)paramb).getValue());
      AppMethodBeat.o(57801);
      return paramb;
    }
    Object localObject1;
    if ((paramb instanceof m))
    {
      localObject1 = ((m)paramb).hCY();
      paramb = ((m)paramb).hCZ();
      if ((localObject1 == null) || (paramb == null))
      {
        AppMethodBeat.o(57801);
        return null;
      }
      paramb = (kotlin.l.b.a.b.j.b.g)new kotlin.l.b.a.b.j.b.j((kotlin.l.b.a.b.f.a)localObject1, paramb);
      AppMethodBeat.o(57801);
      return paramb;
    }
    Object localObject2;
    if ((paramb instanceof kotlin.l.b.a.b.d.a.e.e))
    {
      localObject2 = paramb.hAH();
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = kotlin.l.b.a.b.d.a.p.Tpl;
        kotlin.g.b.p.g(localObject1, "DEFAULT_ANNOTATION_MEMBER_NAME");
      }
      localObject2 = ((kotlin.l.b.a.b.d.a.e.e)paramb).hCH();
      paramb = hDN();
      kotlin.g.b.p.g(paramb, "type");
      if (ad.ap((ab)paramb)) {
        break label445;
      }
      paramb = kotlin.l.b.a.b.j.d.a.l(this);
      if (paramb == null) {
        kotlin.g.b.p.hyc();
      }
      paramb = kotlin.l.b.a.b.d.a.a.a.b((kotlin.l.b.a.b.f.f)localObject1, paramb);
      if (paramb != null)
      {
        paramb = paramb.hBy();
        if (paramb != null) {
          break label452;
        }
      }
      paramb = (ab)this.Trn.Trv.Tfp.hBh().a(bh.TOQ, (ab)u.bun("Unknown array element type"));
    }
    label445:
    label452:
    for (;;)
    {
      kotlin.g.b.p.g(paramb, "DescriptorResolverUtils.… type\")\n                )");
      localObject1 = (Iterable)localObject2;
      Collection localCollection = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject1, 10));
      Iterator localIterator = ((Iterable)localObject1).iterator();
      while (localIterator.hasNext())
      {
        localObject2 = b((kotlin.l.b.a.b.d.a.e.b)localIterator.next());
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = (kotlin.l.b.a.b.j.b.g)new t();
        }
        localCollection.add(localObject1);
      }
      localObject1 = (List)localCollection;
      localObject2 = kotlin.l.b.a.b.j.b.h.TIu;
      paramb = (kotlin.l.b.a.b.j.b.g)kotlin.l.b.a.b.j.b.h.a((List)localObject1, paramb);
      AppMethodBeat.o(57801);
      return paramb;
      if ((paramb instanceof kotlin.l.b.a.b.d.a.e.c))
      {
        paramb = ((kotlin.l.b.a.b.d.a.e.c)paramb).hCF();
        paramb = (kotlin.l.b.a.b.j.b.g)new kotlin.l.b.a.b.j.b.a((kotlin.l.b.a.b.b.a.c)new e(this.Trn, paramb));
        AppMethodBeat.o(57801);
        return paramb;
      }
      if ((paramb instanceof kotlin.l.b.a.b.d.a.e.h))
      {
        paramb = ((kotlin.l.b.a.b.d.a.e.h)paramb).hCS();
        localObject1 = r.TIJ;
        paramb = r.a.ae(this.Trn.Tru.a(paramb, d.a(kotlin.l.b.a.b.d.a.a.l.Tqv, false, null, 3)));
        AppMethodBeat.o(57801);
        return paramb;
      }
      AppMethodBeat.o(57801);
      return null;
    }
  }
  
  private aj hDN()
  {
    AppMethodBeat.i(57798);
    aj localaj = (aj)kotlin.l.b.a.b.l.i.a(this.TpP, cLI[1]);
    AppMethodBeat.o(57798);
    return localaj;
  }
  
  public final Map<kotlin.l.b.a.b.f.f, kotlin.l.b.a.b.j.b.g<?>> hBO()
  {
    AppMethodBeat.i(57800);
    Map localMap = (Map)kotlin.l.b.a.b.l.i.a(this.Tqj, cLI[2]);
    AppMethodBeat.o(57800);
    return localMap;
  }
  
  public final kotlin.l.b.a.b.f.b hBk()
  {
    AppMethodBeat.i(57797);
    Object localObject = this.TrQ;
    k localk = cLI[0];
    kotlin.g.b.p.h(localObject, "$this$getValue");
    kotlin.g.b.p.h(localk, "p");
    localObject = (kotlin.l.b.a.b.f.b)((kotlin.l.b.a.b.l.g)localObject).invoke();
    AppMethodBeat.o(57797);
    return localObject;
  }
  
  public final boolean hDF()
  {
    return this.TpR;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57802);
    String str = kotlin.l.b.a.b.i.c.a(kotlin.l.b.a.b.i.c.TFg, (kotlin.l.b.a.b.b.a.c)this);
    AppMethodBeat.o(57802);
    return str;
  }
  
  static final class a
    extends q
    implements kotlin.g.a.a<Map<kotlin.l.b.a.b.f.f, ? extends kotlin.l.b.a.b.j.b.g<?>>>
  {
    a(e parame)
    {
      super();
    }
  }
  
  static final class b
    extends q
    implements kotlin.g.a.a<kotlin.l.b.a.b.f.b>
  {
    b(e parame)
    {
      super();
    }
  }
  
  static final class c
    extends q
    implements kotlin.g.a.a<aj>
  {
    c(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.c.a.e
 * JD-Core Version:    0.7.0.1
 */