package d.l.b.a.b.d.a.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.b.p;
import d.g.b.q;
import d.l.b.a.b.b.as;
import d.l.b.a.b.j.f.h;
import d.l.b.a.b.m.a.i;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.ac;
import d.l.b.a.b.m.ad;
import d.l.b.a.b.m.aj;
import d.l.b.a.b.m.at;
import d.l.b.a.b.m.av;
import d.l.b.a.b.m.ax;
import d.l.b.a.b.m.ay;
import d.l.b.a.b.m.bg;
import d.l.b.a.b.m.bh;
import d.l.b.a.b.m.y;
import d.m;
import d.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class e
  extends ay
{
  private static final a NgH;
  private static final a NgI;
  public static final e NgJ;
  
  static
  {
    AppMethodBeat.i(57988);
    NgJ = new e();
    NgH = d.a(d.l.b.a.b.d.a.a.l.NdI, false, null, 3).a(b.Ngv);
    NgI = d.a(d.l.b.a.b.d.a.a.l.NdI, false, null, 3).a(b.Ngu);
    AppMethodBeat.o(57988);
  }
  
  private final ab P(ab paramab)
  {
    AppMethodBeat.i(57985);
    Object localObject1;
    for (;;)
    {
      localObject1 = paramab.gsZ().ghO();
      if (!(localObject1 instanceof as)) {
        break;
      }
      paramab = d.b((as)localObject1);
    }
    if ((localObject1 instanceof d.l.b.a.b.b.e))
    {
      Object localObject2 = y.ap(paramab).gsZ().ghO();
      if (!(localObject2 instanceof d.l.b.a.b.b.e))
      {
        paramab = (Throwable)new IllegalStateException(("For some reason declaration for upper bound is not a class but \"" + localObject2 + "\" while for lower it's \"" + localObject1 + '"').toString());
        AppMethodBeat.o(57985);
        throw paramab;
      }
      o localo = a(y.ao(paramab), (d.l.b.a.b.b.e)localObject1, NgH);
      localObject1 = (aj)localo.first;
      boolean bool1 = ((Boolean)localo.second).booleanValue();
      paramab = a(y.ap(paramab), (d.l.b.a.b.b.e)localObject2, NgI);
      localObject2 = (aj)paramab.first;
      boolean bool2 = ((Boolean)paramab.second).booleanValue();
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
    p.h(paramas, "parameter");
    p.h(parama, "attr");
    p.h(paramab, "erasedUpperBound");
    Object localObject = parama.Ngq;
    switch (f.cpQ[localObject.ordinal()])
    {
    default: 
      paramas = new m();
      AppMethodBeat.o(57987);
      throw paramas;
    case 1: 
      paramas = (av)new ax(bh.NCP, paramab);
      AppMethodBeat.o(57987);
      return paramas;
    }
    if (!paramas.giF().NCU)
    {
      paramas = (av)new ax(bh.NCP, (ab)d.l.b.a.b.j.d.a.G((d.l.b.a.b.b.l)paramas).ghc());
      AppMethodBeat.o(57987);
      return paramas;
    }
    localObject = paramab.gsZ().getParameters();
    p.g(localObject, "erasedUpperBound.constructor.parameters");
    if (!((Collection)localObject).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramas = (av)new ax(bh.NCR, paramab);
      AppMethodBeat.o(57987);
      return paramas;
    }
    paramas = d.a(paramas, parama);
    AppMethodBeat.o(57987);
    return paramas;
  }
  
  private final o<aj, Boolean> a(final aj paramaj, d.l.b.a.b.b.e parame, final a parama)
  {
    AppMethodBeat.i(57986);
    if (paramaj.gsZ().getParameters().isEmpty())
    {
      paramaj = d.u.S(paramaj, Boolean.FALSE);
      AppMethodBeat.o(57986);
      return paramaj;
    }
    if (d.l.b.a.b.a.g.m((ab)paramaj))
    {
      parama = (av)paramaj.gsW().get(0);
      parame = parama.gud();
      parama = parama.gju();
      p.g(parama, "componentTypeProjection.type");
      parame = j.listOf(new ax(parame, P(parama)));
      paramaj = d.u.S(ac.c(paramaj.ghH(), paramaj.gsZ(), parame, paramaj.glW()), Boolean.FALSE);
      AppMethodBeat.o(57986);
      return paramaj;
    }
    if (ad.aq((ab)paramaj))
    {
      paramaj = d.u.S(d.l.b.a.b.m.u.bcU("Raw error type: " + paramaj.gsZ()), Boolean.FALSE);
      AppMethodBeat.o(57986);
      return paramaj;
    }
    h localh = parame.a((ay)NgJ);
    p.g(localh, "declaration.getMemberScope(RawSubstitution)");
    d.l.b.a.b.b.a.g localg = paramaj.ghH();
    at localat = parame.ghu();
    p.g(localat, "declaration.typeConstructor");
    Object localObject1 = parame.ghu();
    p.g(localObject1, "declaration.typeConstructor");
    localObject1 = ((at)localObject1).getParameters();
    p.g(localObject1, "declaration.typeConstructor.parameters");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      as localas = (as)((Iterator)localObject2).next();
      p.g(localas, "parameter");
      ((Collection)localObject1).add(a(localas, parama, d.b(localas)));
    }
    paramaj = d.u.S(ac.a(localg, localat, (List)localObject1, paramaj.glW(), localh, (d.g.a.b)new a(parame, paramaj, parama)), Boolean.TRUE);
    AppMethodBeat.o(57986);
    return paramaj;
  }
  
  public final boolean isEmpty()
  {
    return false;
  }
  
  static final class a
    extends q
    implements d.g.a.b<i, aj>
  {
    a(d.l.b.a.b.b.e parame, aj paramaj, a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.d.a.c.b.e
 * JD-Core Version:    0.7.0.1
 */