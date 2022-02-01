package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.a.p;
import kotlin.ak;
import kotlin.g.a.b;
import kotlin.l.b.a.b.b.a.c;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.a.i;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.j.g.h;
import kotlin.l.b.a.b.j.g.h.c;
import kotlin.l.b.a.b.m.d.a;
import kotlin.l.b.a.b.m.d.a.a;

public final class at
{
  public static final a ajqj;
  private static final at ajqm;
  private final av ajqk;
  private final boolean ajql;
  
  static
  {
    AppMethodBeat.i(191590);
    ajqj = new a((byte)0);
    ajqm = new at((av)av.a.ajqr);
    AppMethodBeat.o(191590);
  }
  
  public at(av paramav)
  {
    AppMethodBeat.i(191560);
    this.ajqk = paramav;
    this.ajql = false;
    AppMethodBeat.o(191560);
  }
  
  private static g a(ad paramad, g paramg)
  {
    AppMethodBeat.i(191575);
    if (af.ai(paramad))
    {
      paramad = paramad.knl();
      AppMethodBeat.o(191575);
      return paramad;
    }
    paramad = i.a(paramg, paramad.knl());
    AppMethodBeat.o(191575);
    return paramad;
  }
  
  private static al a(al paramal, g paramg)
  {
    AppMethodBeat.i(191571);
    if (af.ai((ad)paramal))
    {
      AppMethodBeat.o(191571);
      return paramal;
    }
    paramal = bd.a(paramal, null, a((ad)paramal, paramg), 1);
    AppMethodBeat.o(191571);
    return paramal;
  }
  
  private static al a(al paramal, ad paramad)
  {
    AppMethodBeat.i(191582);
    paramal = bg.b(paramal, paramad.ksB());
    kotlin.g.b.s.s(paramal, "makeNullableIfNeeded(thi…romType.isMarkedNullable)");
    AppMethodBeat.o(191582);
    return paramal;
  }
  
  private final al a(al paramal, au paramau, int paramInt)
  {
    AppMethodBeat.i(191586);
    ax localax = paramal.kzm();
    Object localObject = (Iterable)paramal.klR();
    Collection localCollection = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
    int i = 0;
    Iterator localIterator = ((Iterable)localObject).iterator();
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (i < 0) {
        p.kkW();
      }
      az localaz = (az)localObject;
      localObject = a(localaz, paramau, (ba)localax.klq().get(i), paramInt + 1);
      if (((az)localObject).kAM()) {}
      for (;;)
      {
        localCollection.add(localObject);
        i += 1;
        break;
        localObject = (az)new bb(((az)localObject).kAN(), bg.c(((az)localObject).koG(), localaz.koG().ksB()));
      }
    }
    paramal = bd.a(paramal, (List)localCollection, null, 2);
    AppMethodBeat.o(191586);
    return paramal;
  }
  
  private static al a(au paramau, g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(191562);
    ax localax = paramau.ajqp.kmZ();
    kotlin.g.b.s.s(localax, "descriptor.typeConstructor");
    paramau = ae.a(paramg, localax, paramau.aiHl, paramBoolean, (h)h.c.ajlm);
    AppMethodBeat.o(191562);
    return paramau;
  }
  
  private final az a(az paramaz, au paramau, int paramInt)
  {
    AppMethodBeat.i(191585);
    Object localObject1 = paramaz.koG().kAK();
    if (t.aa((ad)localObject1))
    {
      AppMethodBeat.o(191585);
      return paramaz;
    }
    al localal = bd.ap((ad)localObject1);
    if ((af.ai((ad)localal)) || (!a.aH((ad)localal)))
    {
      AppMethodBeat.o(191585);
      return paramaz;
    }
    Object localObject2 = localal.kzm();
    localObject1 = ((ax)localObject2).knA();
    if (((ax)localObject2).klq().size() == localal.klR().size()) {}
    for (int i = 1; (ak.aiuY) && (i == 0); i = 0)
    {
      paramaz = (Throwable)new AssertionError(kotlin.g.b.s.X("Unexpected malformed type: ", localal));
      AppMethodBeat.o(191585);
      throw paramaz;
    }
    if ((localObject1 instanceof ba))
    {
      AppMethodBeat.o(191585);
      return paramaz;
    }
    if ((localObject1 instanceof kotlin.l.b.a.b.b.az))
    {
      if (paramau.b((kotlin.l.b.a.b.b.az)localObject1))
      {
        this.ajqk.c((kotlin.l.b.a.b.b.az)localObject1);
        paramaz = (az)new bb(bl.ajqM, (ad)v.bJt(kotlin.g.b.s.X("Recursive type alias: ", ((kotlin.l.b.a.b.b.az)localObject1).kok())));
        AppMethodBeat.o(191585);
        return paramaz;
      }
      Object localObject4 = (Iterable)localal.klR();
      Object localObject3 = (Collection)new ArrayList(p.a((Iterable)localObject4, 10));
      localObject4 = ((Iterable)localObject4).iterator();
      i = 0;
      while (((Iterator)localObject4).hasNext())
      {
        Object localObject5 = ((Iterator)localObject4).next();
        if (i < 0) {
          p.kkW();
        }
        ((Collection)localObject3).add(a((az)localObject5, paramau, (ba)((ax)localObject2).klq().get(i), paramInt + 1));
        i += 1;
      }
      localObject2 = (List)localObject3;
      localObject3 = au.ajqn;
      localObject1 = a(au.a.a(paramau, (kotlin.l.b.a.b.b.az)localObject1, (List)localObject2), localal.knl(), localal.ksB(), paramInt + 1, false);
      paramau = a(localal, paramau, paramInt);
      if (t.aa((ad)localObject1)) {}
      for (paramau = (au)localObject1;; paramau = ao.b((al)localObject1, paramau))
      {
        paramaz = (az)new bb(paramaz.kAN(), (ad)paramau);
        AppMethodBeat.o(191585);
        return paramaz;
      }
    }
    paramau = a(localal, paramau, paramInt);
    c((ad)localal, (ad)paramau);
    paramaz = (az)new bb(paramaz.kAN(), (ad)paramau);
    AppMethodBeat.o(191585);
    return paramaz;
  }
  
  private final az a(az paramaz, au paramau, ba paramba, int paramInt)
  {
    AppMethodBeat.i(191566);
    a.a(paramInt, paramau.ajqp);
    if (paramaz.kAM())
    {
      kotlin.g.b.s.checkNotNull(paramba);
      paramaz = bg.c(paramba);
      kotlin.g.b.s.s(paramaz, "makeStarProjection(typeParameterDescriptor!!)");
      AppMethodBeat.o(191566);
      return paramaz;
    }
    ad localad = paramaz.koG();
    kotlin.g.b.s.s(localad, "underlyingProjection.type");
    Object localObject = paramau.d(localad.kzm());
    if (localObject == null)
    {
      paramaz = a(paramaz, paramau, paramInt);
      AppMethodBeat.o(191566);
      return paramaz;
    }
    if (((az)localObject).kAM())
    {
      kotlin.g.b.s.checkNotNull(paramba);
      paramaz = bg.c(paramba);
      kotlin.g.b.s.s(paramaz, "makeStarProjection(typeParameterDescriptor!!)");
      AppMethodBeat.o(191566);
      return paramaz;
    }
    bk localbk = ((az)localObject).koG().kAK();
    at localat = (at)this;
    localObject = ((az)localObject).kAN();
    kotlin.g.b.s.s(localObject, "argument.projectionKind");
    bl localbl = paramaz.kAN();
    kotlin.g.b.s.s(localbl, "underlyingProjection.projectionKind");
    if (localbl == localObject)
    {
      paramaz = (az)localObject;
      if (paramba != null) {
        break label339;
      }
      paramba = null;
      label198:
      localObject = paramba;
      if (paramba == null) {
        localObject = bl.ajqM;
      }
      kotlin.g.b.s.s(localObject, "typeParameterDescriptor?…nce ?: Variance.INVARIANT");
      if (localObject != paramaz) {
        break label349;
      }
      paramba = paramaz;
      label226:
      b(localad.knl(), localbk.knl());
      if (!(localbk instanceof s)) {
        break label397;
      }
    }
    label397:
    for (paramaz = (bk)a((s)localbk, localad.knl());; paramaz = (bk)b(bd.ap((ad)localbk), localad))
    {
      paramaz = (az)new bb(paramba, (ad)paramaz);
      AppMethodBeat.o(191566);
      return paramaz;
      paramaz = (az)localObject;
      if (localbl == bl.ajqM) {
        break;
      }
      if (localObject == bl.ajqM)
      {
        paramaz = localbl;
        break;
      }
      localat.ajqk.a(paramau.ajqp, (ad)localbk);
      paramaz = (az)localObject;
      break;
      label339:
      paramba = paramba.kom();
      break label198;
      label349:
      paramba = paramaz;
      if (localObject == bl.ajqM) {
        break label226;
      }
      if (paramaz == bl.ajqM)
      {
        paramba = bl.ajqM;
        break label226;
      }
      localat.ajqk.a(paramau.ajqp, (ad)localbk);
      paramba = paramaz;
      break label226;
    }
  }
  
  private static s a(s params, g paramg)
  {
    AppMethodBeat.i(191568);
    params = params.j(a((ad)params, paramg));
    AppMethodBeat.o(191568);
    return params;
  }
  
  private static al b(al paramal, ad paramad)
  {
    AppMethodBeat.i(191584);
    paramal = a(a(paramal, paramad), paramad.knl());
    AppMethodBeat.o(191584);
    return paramal;
  }
  
  private final void b(g paramg1, g paramg2)
  {
    AppMethodBeat.i(191578);
    Object localObject = (Iterable)paramg1;
    paramg1 = (Collection)new HashSet();
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramg1.add(((c)((Iterator)localObject).next()).koY());
    }
    paramg1 = (HashSet)paramg1;
    paramg2 = paramg2.iterator();
    while (paramg2.hasNext())
    {
      localObject = (c)paramg2.next();
      if (paramg1.contains(((c)localObject).koY())) {
        this.ajqk.l((c)localObject);
      }
    }
    AppMethodBeat.o(191578);
  }
  
  private final void c(ad paramad1, ad paramad2)
  {
    AppMethodBeat.i(191588);
    be localbe = be.aq(paramad2);
    kotlin.g.b.s.s(localbe, "create(substitutedType)");
    paramad2 = ((Iterable)paramad2.klR()).iterator();
    int i = 0;
    while (paramad2.hasNext())
    {
      Object localObject1 = paramad2.next();
      if (i < 0) {
        p.kkW();
      }
      localObject1 = (az)localObject1;
      if (!((az)localObject1).kAM())
      {
        Object localObject2 = ((az)localObject1).koG();
        kotlin.g.b.s.s(localObject2, "substitutedArgument.type");
        kotlin.g.b.s.u(localObject2, "<this>");
        if (!a.a((ad)localObject2, (b)a.a.ajrL))
        {
          Object localObject3 = (az)paramad1.klR().get(i);
          localObject2 = (ba)paramad1.kzm().klq().get(i);
          if (this.ajql)
          {
            av localav = this.ajqk;
            localObject3 = ((az)localObject3).koG();
            kotlin.g.b.s.s(localObject3, "unsubstitutedArgument.type");
            localObject1 = ((az)localObject1).koG();
            kotlin.g.b.s.s(localObject1, "substitutedArgument.type");
            kotlin.g.b.s.s(localObject2, "typeParameter");
            localav.a(localbe, (ad)localObject3, (ad)localObject1, (ba)localObject2);
          }
        }
      }
      i += 1;
    }
    AppMethodBeat.o(191588);
  }
  
  final al a(au paramau, g paramg, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    AppMethodBeat.i(191591);
    Object localObject1 = a((az)new bb(bl.ajqM, (ad)paramau.ajqp.kpl()), paramau, null, paramInt);
    Object localObject2 = ((az)localObject1).koG();
    kotlin.g.b.s.s(localObject2, "expandedProjection.type");
    localObject2 = bd.ap((ad)localObject2);
    if (af.ai((ad)localObject2))
    {
      AppMethodBeat.o(191591);
      return localObject2;
    }
    if (((az)localObject1).kAN() == bl.ajqM) {}
    for (paramInt = 1; (ak.aiuY) && (paramInt == 0); paramInt = 0)
    {
      paramau = (Throwable)new AssertionError("Type alias expansion: result for " + paramau.ajqp + " is " + ((az)localObject1).kAN() + ", should be invariant");
      AppMethodBeat.o(191591);
      throw paramau;
    }
    b(((al)localObject2).knl(), paramg);
    localObject1 = bg.b(a((al)localObject2, paramg), paramBoolean1);
    kotlin.g.b.s.s(localObject1, "expandedType.combineAnno…fNeeded(it, isNullable) }");
    if (paramBoolean2)
    {
      paramau = ao.b((al)localObject1, a(paramau, paramg, paramBoolean1));
      AppMethodBeat.o(191591);
      return paramau;
    }
    AppMethodBeat.o(191591);
    return localObject1;
  }
  
  public static final class a
  {
    static void a(int paramInt, kotlin.l.b.a.b.b.az paramaz)
    {
      AppMethodBeat.i(191640);
      if (paramInt > 100)
      {
        paramaz = new AssertionError(kotlin.g.b.s.X("Too deep recursion while expanding type alias ", paramaz.kok()));
        AppMethodBeat.o(191640);
        throw paramaz;
      }
      AppMethodBeat.o(191640);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.at
 * JD-Core Version:    0.7.0.1
 */