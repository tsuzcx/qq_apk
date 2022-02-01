package kotlin.l.b.a.b.d.a.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.j.f.h;
import kotlin.l.b.a.b.m.a.i;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ac;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.av;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.ay;
import kotlin.l.b.a.b.m.bg;
import kotlin.l.b.a.b.m.bh;
import kotlin.l.b.a.b.m.u;
import kotlin.l.b.a.b.m.y;
import kotlin.m;
import kotlin.o;
import kotlin.s;

public final class e
  extends ay
{
  private static final a aaWn;
  private static final a aaWo;
  public static final e aaWp;
  
  static
  {
    AppMethodBeat.i(57988);
    aaWp = new e();
    aaWn = d.a(kotlin.l.b.a.b.d.a.a.l.aaTp, false, null, 3).a(b.aaWb);
    aaWo = d.a(kotlin.l.b.a.b.d.a.a.l.aaTp, false, null, 3).a(b.aaWa);
    AppMethodBeat.o(57988);
  }
  
  private final ab O(ab paramab)
  {
    AppMethodBeat.i(57985);
    Object localObject1;
    for (;;)
    {
      localObject1 = paramab.iOU().iEf();
      if (!(localObject1 instanceof as)) {
        break;
      }
      paramab = d.b((as)localObject1);
    }
    if ((localObject1 instanceof kotlin.l.b.a.b.b.e))
    {
      Object localObject2 = y.ao(paramab).iOU().iEf();
      if (!(localObject2 instanceof kotlin.l.b.a.b.b.e))
      {
        paramab = (Throwable)new IllegalStateException(("For some reason declaration for upper bound is not a class but \"" + localObject2 + "\" while for lower it's \"" + localObject1 + '"').toString());
        AppMethodBeat.o(57985);
        throw paramab;
      }
      o localo = a(y.an(paramab), (kotlin.l.b.a.b.b.e)localObject1, aaWn);
      localObject1 = (aj)localo.Mx;
      boolean bool1 = ((Boolean)localo.My).booleanValue();
      paramab = a(y.ao(paramab), (kotlin.l.b.a.b.b.e)localObject2, aaWo);
      localObject2 = (aj)paramab.Mx;
      boolean bool2 = ((Boolean)paramab.My).booleanValue();
      if ((bool1) || (bool2)) {}
      for (paramab = (bg)new g((aj)localObject1, (aj)localObject2);; paramab = ac.a((aj)localObject1, (aj)localObject2))
      {
        paramab = (ab)paramab;
        AppMethodBeat.o(57985);
        return paramab;
      }
    }
    paramab = (Throwable)new IllegalStateException("Unexpected declaration kind: ".concat(String.valueOf(localObject1)).toString());
    AppMethodBeat.o(57985);
    throw paramab;
  }
  
  public static av a(as paramas, a parama, ab paramab)
  {
    AppMethodBeat.i(57987);
    p.k(paramas, "parameter");
    p.k(parama, "attr");
    p.k(paramab, "erasedUpperBound");
    Object localObject = parama.aaVW;
    switch (f.$EnumSwitchMapping$0[localObject.ordinal()])
    {
    default: 
      paramas = new m();
      AppMethodBeat.o(57987);
      throw paramas;
    case 1: 
      paramas = (av)new ax(bh.abrp, paramab);
      AppMethodBeat.o(57987);
      return paramas;
    }
    if (!paramas.iEW().abru)
    {
      paramas = (av)new ax(bh.abrp, (ab)kotlin.l.b.a.b.j.d.a.G((kotlin.l.b.a.b.b.l)paramas).iDt());
      AppMethodBeat.o(57987);
      return paramas;
    }
    localObject = paramab.iOU().iCb();
    p.j(localObject, "erasedUpperBound.constructor.parameters");
    if (!((Collection)localObject).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramas = (av)new ax(bh.abrr, paramab);
      AppMethodBeat.o(57987);
      return paramas;
    }
    paramas = d.a(paramas, parama);
    AppMethodBeat.o(57987);
    return paramas;
  }
  
  private final o<aj, Boolean> a(final aj paramaj, kotlin.l.b.a.b.b.e parame, final a parama)
  {
    AppMethodBeat.i(57986);
    if (paramaj.iOU().iCb().isEmpty())
    {
      paramaj = s.M(paramaj, Boolean.FALSE);
      AppMethodBeat.o(57986);
      return paramaj;
    }
    if (kotlin.l.b.a.b.a.g.m((ab)paramaj))
    {
      parama = (av)paramaj.iOR().get(0);
      parame = parama.iQa();
      parama = parama.iFN();
      p.j(parama, "componentTypeProjection.type");
      parame = j.listOf(new ax(parame, O(parama)));
      paramaj = s.M(ac.c(paramaj.iDY(), paramaj.iOU(), parame, paramaj.iIu()), Boolean.FALSE);
      AppMethodBeat.o(57986);
      return paramaj;
    }
    if (ad.ap((ab)paramaj))
    {
      paramaj = s.M(u.bHp("Raw error type: " + paramaj.iOU()), Boolean.FALSE);
      AppMethodBeat.o(57986);
      return paramaj;
    }
    h localh = parame.a((ay)aaWp);
    p.j(localh, "declaration.getMemberScope(RawSubstitution)");
    kotlin.l.b.a.b.b.a.g localg = paramaj.iDY();
    at localat = parame.iDL();
    p.j(localat, "declaration.typeConstructor");
    Object localObject1 = parame.iDL();
    p.j(localObject1, "declaration.typeConstructor");
    localObject1 = ((at)localObject1).iCb();
    p.j(localObject1, "declaration.typeConstructor.parameters");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      as localas = (as)((Iterator)localObject2).next();
      p.j(localas, "parameter");
      ((Collection)localObject1).add(a(localas, parama, d.b(localas)));
    }
    paramaj = s.M(ac.a(localg, localat, (List)localObject1, paramaj.iIu(), localh, (kotlin.g.a.b)new a(parame, paramaj, parama)), Boolean.TRUE);
    AppMethodBeat.o(57986);
    return paramaj;
  }
  
  public final boolean isEmpty()
  {
    return false;
  }
  
  static final class a
    extends q
    implements kotlin.g.a.b<i, aj>
  {
    a(kotlin.l.b.a.b.b.e parame, aj paramaj, a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.c.b.e
 * JD-Core Version:    0.7.0.1
 */