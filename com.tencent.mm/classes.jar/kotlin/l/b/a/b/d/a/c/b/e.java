package kotlin.l.b.a.b.d.a.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.d.a.a.k;
import kotlin.l.b.a.b.m.aa;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.ae;
import kotlin.l.b.a.b.m.af;
import kotlin.l.b.a.b.m.al;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.az;
import kotlin.l.b.a.b.m.bb;
import kotlin.l.b.a.b.m.bc;
import kotlin.l.b.a.b.m.bk;
import kotlin.l.b.a.b.m.bl;
import kotlin.r;

public final class e
  extends bc
{
  public static final e.a aiUo;
  private static final a aiUp;
  private static final a aiUq;
  private final g aiUg;
  
  static
  {
    AppMethodBeat.i(57988);
    aiUo = new e.a((byte)0);
    aiUp = d.a(k.aiRp, false, null, 3).a(b.aiUe);
    aiUq = d.a(k.aiRp, false, null, 3).a(b.aiUd);
    AppMethodBeat.o(57988);
  }
  
  public e(g paramg)
  {
    AppMethodBeat.i(192137);
    g localg = paramg;
    if (paramg == null) {
      localg = new g(this);
    }
    this.aiUg = localg;
    AppMethodBeat.o(192137);
  }
  
  private final ad a(ad paramad, a parama)
  {
    AppMethodBeat.i(192144);
    Object localObject2;
    for (;;)
    {
      localObject2 = paramad.kzm().knA();
      if (!(localObject2 instanceof ba)) {
        break;
      }
      paramad = this.aiUg.a((ba)localObject2, true, parama);
      s.s(paramad, "typeParameterUpperBoundE…tion, isRaw = true, attr)");
    }
    if ((localObject2 instanceof kotlin.l.b.a.b.b.e))
    {
      Object localObject1 = aa.af(paramad).kzm().knA();
      if (!(localObject1 instanceof kotlin.l.b.a.b.b.e))
      {
        paramad = (Throwable)new IllegalStateException(("For some reason declaration for upper bound is not a class but \"" + localObject1 + "\" while for lower it's \"" + localObject2 + '"').toString());
        AppMethodBeat.o(192144);
        throw paramad;
      }
      localObject2 = a(aa.ae(paramad), (kotlin.l.b.a.b.b.e)localObject2, aiUp);
      parama = (al)((r)localObject2).bsC;
      boolean bool1 = ((Boolean)((r)localObject2).bsD).booleanValue();
      paramad = a(aa.af(paramad), (kotlin.l.b.a.b.b.e)localObject1, aiUq);
      localObject1 = (al)paramad.bsC;
      boolean bool2 = ((Boolean)paramad.bsD).booleanValue();
      if ((bool1) || (bool2)) {}
      for (paramad = (bk)new f(parama, (al)localObject1);; paramad = ae.a(parama, (al)localObject1))
      {
        paramad = (ad)paramad;
        AppMethodBeat.o(192144);
        return paramad;
      }
    }
    paramad = (Throwable)new IllegalStateException(s.X("Unexpected declaration kind: ", localObject2).toString());
    AppMethodBeat.o(192144);
    throw paramad;
  }
  
  public static az a(ba paramba, a parama, ad paramad)
  {
    AppMethodBeat.i(57987);
    s.u(paramba, "parameter");
    s.u(parama, "attr");
    s.u(paramad, "erasedUpperBound");
    Object localObject = parama.aiTY;
    switch (b.$EnumSwitchMapping$0[localObject.ordinal()])
    {
    default: 
      paramba = new kotlin.p();
      AppMethodBeat.o(57987);
      throw paramba;
    case 1: 
      paramba = (az)new bb(bl.ajqM, paramad);
      AppMethodBeat.o(57987);
      return paramba;
    }
    if (!paramba.kom().ajqK)
    {
      paramba = (az)new bb(bl.ajqM, (ad)kotlin.l.b.a.b.j.d.a.G((l)paramba).kmN());
      AppMethodBeat.o(57987);
      return paramba;
    }
    localObject = paramad.kzm().klq();
    s.s(localObject, "erasedUpperBound.constructor.parameters");
    if (!((Collection)localObject).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramba = (az)new bb(bl.ajqO, paramad);
      AppMethodBeat.o(57987);
      return paramba;
    }
    paramba = d.a(paramba, parama);
    AppMethodBeat.o(57987);
    return paramba;
  }
  
  private final r<al, Boolean> a(final al paramal, kotlin.l.b.a.b.b.e parame, final a parama)
  {
    AppMethodBeat.i(57986);
    if (paramal.kzm().klq().isEmpty())
    {
      paramal = kotlin.v.Y(paramal, Boolean.FALSE);
      AppMethodBeat.o(57986);
      return paramal;
    }
    if (kotlin.l.b.a.b.a.h.m((ad)paramal))
    {
      localObject1 = (az)paramal.klR().get(0);
      parame = ((az)localObject1).kAN();
      localObject1 = ((az)localObject1).koG();
      s.s(localObject1, "componentTypeProjection.type");
      parame = kotlin.a.p.listOf(new bb(parame, a((ad)localObject1, parama)));
      paramal = kotlin.v.Y(ae.c(paramal.knl(), paramal.kzm(), parame, paramal.ksB()), Boolean.FALSE);
      AppMethodBeat.o(57986);
      return paramal;
    }
    if (af.ai((ad)paramal))
    {
      paramal = kotlin.l.b.a.b.m.v.bJt(s.X("Raw error type: ", paramal.kzm()));
      s.s(paramal, "createErrorType(\"Raw err…pe: ${type.constructor}\")");
      paramal = kotlin.v.Y(paramal, Boolean.FALSE);
      AppMethodBeat.o(57986);
      return paramal;
    }
    Object localObject1 = parame.a((bc)this);
    s.s(localObject1, "declaration.getMemberScope(this)");
    kotlin.l.b.a.b.b.a.g localg = paramal.knl();
    ax localax = parame.kmZ();
    s.s(localax, "declaration.typeConstructor");
    Object localObject2 = parame.kmZ().klq();
    s.s(localObject2, "declaration.typeConstructor.parameters");
    Object localObject3 = (Iterable)localObject2;
    localObject2 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      ba localba = (ba)((Iterator)localObject3).next();
      s.s(localba, "parameter");
      ad localad = this.aiUg.a(localba, true, parama);
      s.s(localad, "fun computeProjection(\n …er, attr)\n        }\n    }");
      ((Collection)localObject2).add(a(localba, parama, localad));
    }
    paramal = kotlin.v.Y(ae.a(localg, localax, (List)localObject2, paramal.ksB(), (kotlin.l.b.a.b.j.g.h)localObject1, (kotlin.g.a.b)new c(parame, this, paramal, parama)), Boolean.TRUE);
    AppMethodBeat.o(57986);
    return paramal;
  }
  
  public final boolean isEmpty()
  {
    return false;
  }
  
  static final class c
    extends u
    implements kotlin.g.a.b<kotlin.l.b.a.b.m.a.g, al>
  {
    c(kotlin.l.b.a.b.b.e parame, e parame1, al paramal, a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.c.b.e
 * JD-Core Version:    0.7.0.1
 */