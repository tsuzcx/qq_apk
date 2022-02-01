package kotlin.l.b.a.b.m.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.ah;
import kotlin.ak;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.l.b.a.b.a.h;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.i.c.a;
import kotlin.l.b.a.b.i.f;
import kotlin.l.b.a.b.j.a.a.d;
import kotlin.l.b.a.b.m.aa;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.ae;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.ay;
import kotlin.l.b.a.b.m.az;
import kotlin.l.b.a.b.m.bb;
import kotlin.l.b.a.b.m.bc;
import kotlin.l.b.a.b.m.bd;
import kotlin.l.b.a.b.m.be;
import kotlin.l.b.a.b.m.bg;
import kotlin.l.b.a.b.m.bi;
import kotlin.l.b.a.b.m.bk;
import kotlin.l.b.a.b.m.bl;
import kotlin.r;

public final class b
{
  private static final ad a(ad paramad, List<c> paramList)
  {
    AppMethodBeat.i(61274);
    if (paramad.klR().size() == paramList.size()) {}
    for (int i = 1; (ak.aiuY) && (i == 0); i = 0)
    {
      paramad = (Throwable)new AssertionError(s.X("Incorrect type arguments ", paramList));
      AppMethodBeat.o(61274);
      throw paramad;
    }
    paramList = (Iterable)paramList;
    Collection localCollection = (Collection)new ArrayList(kotlin.a.p.a(paramList, 10));
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      paramList = (c)localIterator.next();
      boolean bool = paramList.kAX();
      if ((ak.aiuY) && (!bool))
      {
        paramad = kotlin.l.b.a.b.i.c.ajgs;
        paramad = c.a.bc((kotlin.g.a.b)d.ajrR);
        paramad = (Throwable)new AssertionError("Only consistent enhanced type projection can be converted to type projection, but [" + paramad.k((l)paramList.aiUy) + ": <" + paramad.b(paramList.ajrS) + ", " + paramad.b(paramList.ajrT) + ">] was found");
        AppMethodBeat.o(61274);
        throw paramad;
      }
      if ((s.p(paramList.ajrS, paramList.ajrT)) || (paramList.aiUy.kom() == bl.ajqN)) {
        paramList = (az)new bb(paramList.ajrS);
      }
      for (;;)
      {
        localCollection.add(paramList);
        break;
        if ((h.r(paramList.ajrS)) && (paramList.aiUy.kom() != bl.ajqN)) {
          paramList = (az)new bb(a(paramList, bl.ajqO), paramList.ajrT);
        } else if (h.t(paramList.ajrT)) {
          paramList = (az)new bb(a(paramList, bl.ajqN), paramList.ajrS);
        } else {
          paramList = (az)new bb(a(paramList, bl.ajqO), paramList.ajrT);
        }
      }
    }
    paramad = bd.a(paramad, (List)localCollection, null, null, 6);
    AppMethodBeat.o(61274);
    return paramad;
  }
  
  public static final az a(az paramaz, boolean paramBoolean)
  {
    AppMethodBeat.i(61271);
    if (paramaz == null)
    {
      AppMethodBeat.o(61271);
      return null;
    }
    if (paramaz.kAM())
    {
      AppMethodBeat.o(61271);
      return paramaz;
    }
    ad localad = paramaz.koG();
    s.s(localad, "typeProjection.type");
    if (!bg.a(localad, (kotlin.g.a.b)b.ajrQ))
    {
      AppMethodBeat.o(61271);
      return paramaz;
    }
    bl localbl = paramaz.kAN();
    s.s(localbl, "typeProjection.projectionKind");
    if (localbl == bl.ajqO)
    {
      paramaz = (az)new bb(localbl, (ad)aI(localad).ajrP);
      AppMethodBeat.o(61271);
      return paramaz;
    }
    if (paramBoolean)
    {
      paramaz = (az)new bb(localbl, (ad)aI(localad).ajrO);
      AppMethodBeat.o(61271);
      return paramaz;
    }
    paramaz = e(paramaz);
    AppMethodBeat.o(61271);
    return paramaz;
  }
  
  private static final bl a(c paramc, bl parambl)
  {
    AppMethodBeat.i(191682);
    if (parambl == paramc.aiUy.kom())
    {
      paramc = bl.ajqM;
      AppMethodBeat.o(191682);
      return paramc;
    }
    AppMethodBeat.o(191682);
    return parambl;
  }
  
  private static final a<c> a(c paramc)
  {
    AppMethodBeat.i(61275);
    Object localObject1 = aI(paramc.ajrS);
    ad localad1 = (ad)((a)localObject1).ajrO;
    localObject1 = (ad)((a)localObject1).ajrP;
    Object localObject2 = aI(paramc.ajrT);
    ad localad2 = (ad)((a)localObject2).ajrO;
    localObject2 = (ad)((a)localObject2).ajrP;
    paramc = new a(new c(paramc.aiUy, (ad)localObject1, localad2), new c(paramc.aiUy, localad1, (ad)localObject2));
    AppMethodBeat.o(61275);
    return paramc;
  }
  
  public static final a<ad> aI(ad paramad)
  {
    AppMethodBeat.i(61273);
    s.u(paramad, "type");
    if (aa.ac(paramad))
    {
      localObject1 = aI((ad)aa.ae(paramad));
      localObject2 = aI((ad)aa.af(paramad));
      paramad = new a(bi.a(ae.a(aa.ae((ad)((a)localObject1).ajrO), aa.af((ad)((a)localObject2).ajrO)), paramad), bi.a(ae.a(aa.ae((ad)((a)localObject1).ajrP), aa.af((ad)((a)localObject2).ajrP)), paramad));
      AppMethodBeat.o(61273);
      return paramad;
    }
    Object localObject4 = paramad.kzm();
    if (d.T(paramad))
    {
      localObject2 = ((kotlin.l.b.a.b.j.a.a.b)localObject4).kzn();
      localObject1 = ((az)localObject2).koG();
      s.s(localObject1, "typeProjection.type");
      localObject1 = h((ad)localObject1, paramad);
      localObject3 = ((az)localObject2).kAN();
      switch (a.$EnumSwitchMapping$0[localObject3.ordinal()])
      {
      default: 
        paramad = new AssertionError(s.X("Only nontrivial projections should have been captured, not: ", localObject2));
        AppMethodBeat.o(61273);
        throw paramad;
      case 2: 
        paramad = kotlin.l.b.a.b.m.d.a.aE(paramad).kmP();
        s.s(paramad, "type.builtIns.nullableAnyType");
        paramad = new a(localObject1, paramad);
        AppMethodBeat.o(61273);
        return paramad;
      }
      localObject2 = kotlin.l.b.a.b.m.d.a.aE(paramad).kmN();
      s.s(localObject2, "type.builtIns.nothingType");
      paramad = new a(h((ad)localObject2, paramad), localObject1);
      AppMethodBeat.o(61273);
      return paramad;
    }
    if ((paramad.klR().isEmpty()) || (paramad.klR().size() != ((ax)localObject4).klq().size()))
    {
      paramad = new a(paramad, paramad);
      AppMethodBeat.o(61273);
      return paramad;
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = new ArrayList();
    Object localObject3 = (Iterable)paramad.klR();
    localObject4 = ((ax)localObject4).klq();
    s.s(localObject4, "typeConstructor.parameters");
    localObject3 = kotlin.a.p.d((Iterable)localObject3, (Iterable)localObject4).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      Object localObject5 = (r)((Iterator)localObject3).next();
      localObject4 = (az)((r)localObject5).bsC;
      localObject5 = (ba)((r)localObject5).bsD;
      s.s(localObject5, "typeParameter");
      localObject5 = b((az)localObject4, (ba)localObject5);
      if (((az)localObject4).kAM())
      {
        ((ArrayList)localObject1).add(localObject5);
        ((ArrayList)localObject2).add(localObject5);
      }
      else
      {
        localObject5 = a((c)localObject5);
        localObject4 = (c)((a)localObject5).ajrO;
        localObject5 = (c)((a)localObject5).ajrP;
        ((ArrayList)localObject1).add(localObject4);
        ((ArrayList)localObject2).add(localObject5);
      }
    }
    localObject3 = (Iterable)localObject1;
    int i;
    if (!((Collection)localObject3).isEmpty())
    {
      localObject3 = ((Iterable)localObject3).iterator();
      if (((Iterator)localObject3).hasNext()) {
        if (!((c)((Iterator)localObject3).next()).kAX())
        {
          i = 1;
          label591:
          if (i == 0) {
            break label649;
          }
          i = 1;
          label597:
          if (i == 0) {
            break label656;
          }
          localObject1 = kotlin.l.b.a.b.m.d.a.aE(paramad).kmN();
          s.s(localObject1, "type.builtIns.nothingType");
        }
      }
    }
    label649:
    label656:
    for (localObject1 = (ad)localObject1;; localObject1 = a(paramad, (List)localObject1))
    {
      paramad = new a(localObject1, a(paramad, (List)localObject2));
      AppMethodBeat.o(61273);
      return paramad;
      i = 0;
      break label591;
      break;
      i = 0;
      break label597;
    }
  }
  
  private static final c b(az paramaz, ba paramba)
  {
    AppMethodBeat.i(61270);
    Object localObject = be.a(paramba.kom(), paramaz);
    switch (a.$EnumSwitchMapping$0[localObject.ordinal()])
    {
    default: 
      paramaz = new kotlin.p();
      AppMethodBeat.o(61270);
      throw paramaz;
    case 1: 
      localObject = paramaz.koG();
      s.s(localObject, "type");
      paramaz = paramaz.koG();
      s.s(paramaz, "type");
      paramaz = new c(paramba, (ad)localObject, paramaz);
      AppMethodBeat.o(61270);
      return paramaz;
    case 2: 
      paramaz = paramaz.koG();
      s.s(paramaz, "type");
      localObject = kotlin.l.b.a.b.j.d.a.G((l)paramba).kmP();
      s.s(localObject, "typeParameter.builtIns.nullableAnyType");
      paramaz = new c(paramba, paramaz, (ad)localObject);
      AppMethodBeat.o(61270);
      return paramaz;
    }
    localObject = kotlin.l.b.a.b.j.d.a.G((l)paramba).kmN();
    s.s(localObject, "typeParameter.builtIns.nothingType");
    localObject = (ad)localObject;
    paramaz = paramaz.koG();
    s.s(paramaz, "type");
    paramaz = new c(paramba, (ad)localObject, paramaz);
    AppMethodBeat.o(61270);
    return paramaz;
  }
  
  private static final az e(az paramaz)
  {
    AppMethodBeat.i(61272);
    be localbe = be.d((bc)new c());
    s.s(localbe, "create(object : TypeCons…ojection\n        }\n    })");
    paramaz = localbe.d(paramaz);
    AppMethodBeat.o(61272);
    return paramaz;
  }
  
  private static final ad h(ad paramad1, ad paramad2)
  {
    AppMethodBeat.i(191686);
    paramad1 = bg.c(paramad1, paramad2.ksB());
    s.s(paramad1, "makeNullableIfNeeded(this, type.isMarkedNullable)");
    AppMethodBeat.o(191686);
    return paramad1;
  }
  
  static final class b
    extends u
    implements kotlin.g.a.b<bk, Boolean>
  {
    public static final b ajrQ;
    
    static
    {
      AppMethodBeat.i(61264);
      ajrQ = new b();
      AppMethodBeat.o(61264);
    }
    
    b()
    {
      super();
    }
  }
  
  public static final class c
    extends ay
  {
    public final az c(ax paramax)
    {
      AppMethodBeat.i(61265);
      s.u(paramax, "key");
      if ((paramax instanceof kotlin.l.b.a.b.j.a.a.b)) {}
      for (paramax = (kotlin.l.b.a.b.j.a.a.b)paramax; paramax == null; paramax = null)
      {
        AppMethodBeat.o(61265);
        return null;
      }
      if (paramax.kzn().kAM())
      {
        paramax = (az)new bb(bl.ajqO, paramax.kzn().koG());
        AppMethodBeat.o(61265);
        return paramax;
      }
      paramax = paramax.kzn();
      AppMethodBeat.o(61265);
      return paramax;
    }
  }
  
  static final class d
    extends u
    implements kotlin.g.a.b<f, ah>
  {
    public static final d ajrR;
    
    static
    {
      AppMethodBeat.i(61267);
      ajrR = new d();
      AppMethodBeat.o(61267);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.e.b
 * JD-Core Version:    0.7.0.1
 */