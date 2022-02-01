package kotlin.l.b.a.b.d.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.d.a.c.b.d;
import kotlin.l.b.a.b.d.a.e.m;
import kotlin.l.b.a.b.d.a.e.o;
import kotlin.l.b.a.b.j.b.r;
import kotlin.l.b.a.b.j.b.r.a;
import kotlin.l.b.a.b.j.b.t;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.bh;
import kotlin.l.b.a.b.m.u;
import kotlin.l.n;

public final class e
  implements kotlin.l.b.a.b.d.a.b.i
{
  private final kotlin.l.b.a.b.l.f aaSJ;
  private final boolean aaSL;
  private final kotlin.l.b.a.b.l.f aaTd;
  private final kotlin.l.b.a.b.l.g aaUK;
  private final kotlin.l.b.a.b.d.a.d.a aaUL;
  private final kotlin.l.b.a.b.d.a.e.a aaUM;
  private final kotlin.l.b.a.b.d.a.c.h aaUh;
  
  static
  {
    AppMethodBeat.i(57796);
    cMt = new n[] { (n)kotlin.g.b.ab.a(new z(kotlin.g.b.ab.bO(e.class), "fqName", "getFqName()Lorg/jetbrains/kotlin/name/FqName;")), (n)kotlin.g.b.ab.a(new z(kotlin.g.b.ab.bO(e.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;")), (n)kotlin.g.b.ab.a(new z(kotlin.g.b.ab.bO(e.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;")) };
    AppMethodBeat.o(57796);
  }
  
  public e(kotlin.l.b.a.b.d.a.c.h paramh, kotlin.l.b.a.b.d.a.e.a parama)
  {
    AppMethodBeat.i(57803);
    this.aaUh = paramh;
    this.aaUM = parama;
    this.aaUK = this.aaUh.aaUp.aaFH.aw((kotlin.g.a.a)new b(this));
    this.aaSJ = this.aaUh.aaUp.aaFH.av((kotlin.g.a.a)new c(this));
    this.aaUL = this.aaUh.aaUp.aaTS.a((kotlin.l.b.a.b.d.a.e.l)this.aaUM);
    this.aaTd = this.aaUh.aaUp.aaFH.av((kotlin.g.a.a)new a(this));
    this.aaSL = false;
    AppMethodBeat.o(57803);
  }
  
  private final kotlin.l.b.a.b.j.b.g<?> b(kotlin.l.b.a.b.d.a.e.b paramb)
  {
    AppMethodBeat.i(57801);
    if ((paramb instanceof o))
    {
      paramb = kotlin.l.b.a.b.j.b.h.abkY.fF(((o)paramb).getValue());
      AppMethodBeat.o(57801);
      return paramb;
    }
    Object localObject1;
    if ((paramb instanceof m))
    {
      localObject1 = ((m)paramb).iHs();
      paramb = ((m)paramb).iHt();
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
      localObject2 = paramb.iEU();
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = kotlin.l.b.a.b.d.a.p.aaSf;
        kotlin.g.b.p.j(localObject1, "DEFAULT_ANNOTATION_MEMBER_NAME");
      }
      localObject2 = ((kotlin.l.b.a.b.d.a.e.e)paramb).iGY();
      paramb = iIg();
      kotlin.g.b.p.j(paramb, "type");
      if (ad.ap((kotlin.l.b.a.b.m.ab)paramb)) {
        break label445;
      }
      paramb = kotlin.l.b.a.b.j.d.a.l(this);
      if (paramb == null) {
        kotlin.g.b.p.iCn();
      }
      paramb = kotlin.l.b.a.b.d.a.a.a.b((kotlin.l.b.a.b.f.f)localObject1, paramb);
      if (paramb != null)
      {
        paramb = paramb.iFN();
        if (paramb != null) {
          break label452;
        }
      }
      paramb = (kotlin.l.b.a.b.m.ab)this.aaUh.aaUp.aaIj.iFv().a(bh.abrp, (kotlin.l.b.a.b.m.ab)u.bHp("Unknown array element type"));
    }
    label445:
    label452:
    for (;;)
    {
      kotlin.g.b.p.j(paramb, "DescriptorResolverUtils.… type\")\n                )");
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
      localObject2 = kotlin.l.b.a.b.j.b.h.abkY;
      paramb = (kotlin.l.b.a.b.j.b.g)kotlin.l.b.a.b.j.b.h.a((List)localObject1, paramb);
      AppMethodBeat.o(57801);
      return paramb;
      if ((paramb instanceof kotlin.l.b.a.b.d.a.e.c))
      {
        paramb = ((kotlin.l.b.a.b.d.a.e.c)paramb).iGW();
        paramb = (kotlin.l.b.a.b.j.b.g)new kotlin.l.b.a.b.j.b.a((kotlin.l.b.a.b.b.a.c)new e(this.aaUh, paramb));
        AppMethodBeat.o(57801);
        return paramb;
      }
      if ((paramb instanceof kotlin.l.b.a.b.d.a.e.h))
      {
        paramb = ((kotlin.l.b.a.b.d.a.e.h)paramb).iHm();
        localObject1 = r.ablm;
        paramb = r.a.ae(this.aaUh.aaUo.a(paramb, d.a(kotlin.l.b.a.b.d.a.a.l.aaTp, false, null, 3)));
        AppMethodBeat.o(57801);
        return paramb;
      }
      AppMethodBeat.o(57801);
      return null;
    }
  }
  
  private aj iIg()
  {
    AppMethodBeat.i(57798);
    aj localaj = (aj)kotlin.l.b.a.b.l.i.a(this.aaSJ, cMt[1]);
    AppMethodBeat.o(57798);
    return localaj;
  }
  
  public final kotlin.l.b.a.b.f.b iFy()
  {
    AppMethodBeat.i(57797);
    Object localObject = this.aaUK;
    n localn = cMt[0];
    kotlin.g.b.p.k(localObject, "$this$getValue");
    kotlin.g.b.p.k(localn, "p");
    localObject = (kotlin.l.b.a.b.f.b)((kotlin.l.b.a.b.l.g)localObject).invoke();
    AppMethodBeat.o(57797);
    return localObject;
  }
  
  public final Map<kotlin.l.b.a.b.f.f, kotlin.l.b.a.b.j.b.g<?>> iGd()
  {
    AppMethodBeat.i(57800);
    Map localMap = (Map)kotlin.l.b.a.b.l.i.a(this.aaTd, cMt[2]);
    AppMethodBeat.o(57800);
    return localMap;
  }
  
  public final boolean iHY()
  {
    return this.aaSL;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57802);
    String str = kotlin.l.b.a.b.i.c.a(kotlin.l.b.a.b.i.c.abhK, (kotlin.l.b.a.b.b.a.c)this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.c.a.e
 * JD-Core Version:    0.7.0.1
 */