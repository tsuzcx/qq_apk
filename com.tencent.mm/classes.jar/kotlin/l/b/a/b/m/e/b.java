package kotlin.l.b.a.b.m.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.i.c;
import kotlin.l.b.a.b.i.c.a;
import kotlin.l.b.a.b.i.i;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ac;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.au;
import kotlin.l.b.a.b.m.av;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.ay;
import kotlin.l.b.a.b.m.az;
import kotlin.l.b.a.b.m.ba;
import kotlin.l.b.a.b.m.bc;
import kotlin.l.b.a.b.m.be;
import kotlin.l.b.a.b.m.bg;
import kotlin.l.b.a.b.m.bh;
import kotlin.l.b.a.b.m.y;
import kotlin.m;
import kotlin.o;
import kotlin.t;
import kotlin.x;
import kotlin.z;

public final class b
{
  private static final ab a(ab paramab, List<d> paramList)
  {
    AppMethodBeat.i(61274);
    if (paramab.iOR().size() == paramList.size()) {}
    for (int i = 1; (z.aazO) && (i == 0); i = 0)
    {
      paramab = (Throwable)new AssertionError("Incorrect type arguments ".concat(String.valueOf(paramList)));
      AppMethodBeat.o(61274);
      throw paramab;
    }
    paramList = (Iterable)paramList;
    Collection localCollection = (Collection)new ArrayList(j.a(paramList, 10));
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      paramList = (d)localIterator.next();
      boolean bool = paramList.iQh();
      if ((z.aazO) && (!bool))
      {
        paramab = c.abhP;
        paramab = c.a.aj((kotlin.g.a.b)d.absA);
        paramab = (Throwable)new AssertionError("Only consistent enhanced type projection can be converted to type projection, but [" + paramab.k((l)paramList.abqV) + ": <" + paramab.b(paramList.absC) + ", " + paramab.b(paramList.absD) + ">] was found");
        AppMethodBeat.o(61274);
        throw paramab;
      }
      e locale = new e(paramList);
      if (p.h(paramList.absC, paramList.absD)) {
        paramList = (av)new ax(paramList.absC);
      }
      for (;;)
      {
        localCollection.add(paramList);
        break;
        if ((g.x(paramList.absC)) && (paramList.abqV.iEW() != bh.abrq)) {
          paramList = (av)new ax(locale.c(bh.abrr), paramList.absD);
        } else if (g.A(paramList.absD)) {
          paramList = (av)new ax(locale.c(bh.abrq), paramList.absC);
        } else {
          paramList = (av)new ax(locale.c(bh.abrr), paramList.absD);
        }
      }
    }
    paramab = az.a(paramab, (List)localCollection, paramab.iDY());
    AppMethodBeat.o(61274);
    return paramab;
  }
  
  public static final av a(av paramav, boolean paramBoolean)
  {
    AppMethodBeat.i(61271);
    if (paramav == null)
    {
      AppMethodBeat.o(61271);
      return null;
    }
    if (paramav.iPZ())
    {
      AppMethodBeat.o(61271);
      return paramav;
    }
    ab localab = paramav.iFN();
    p.j(localab, "typeProjection.type");
    if (!bc.b(localab, (kotlin.g.a.b)b.absz))
    {
      AppMethodBeat.o(61271);
      return paramav;
    }
    bh localbh = paramav.iQa();
    p.j(localbh, "typeProjection.projectionKind");
    if (localbh == bh.abrr)
    {
      paramav = (av)new ax(localbh, (ab)aP(localab).absy);
      AppMethodBeat.o(61271);
      return paramav;
    }
    if (paramBoolean)
    {
      paramav = (av)new ax(localbh, (ab)aP(localab).absx);
      AppMethodBeat.o(61271);
      return paramav;
    }
    paramav = e(paramav);
    AppMethodBeat.o(61271);
    return paramav;
  }
  
  private static final a<d> a(d paramd)
  {
    AppMethodBeat.i(61275);
    Object localObject1 = aP(paramd.absC);
    ab localab1 = (ab)((a)localObject1).absx;
    localObject1 = (ab)((a)localObject1).absy;
    Object localObject2 = aP(paramd.absD);
    ab localab2 = (ab)((a)localObject2).absx;
    localObject2 = (ab)((a)localObject2).absy;
    paramd = new a(new d(paramd.abqV, (ab)localObject1, localab2), new d(paramd.abqV, localab1, (ab)localObject2));
    AppMethodBeat.o(61275);
    return paramd;
  }
  
  public static final a<ab> aP(ab paramab)
  {
    AppMethodBeat.i(61273);
    p.k(paramab, "type");
    if (y.al(paramab))
    {
      localObject1 = aP((ab)y.an(paramab));
      localObject2 = aP((ab)y.ao(paramab));
      paramab = new a(be.a(ac.a(y.an((ab)((a)localObject1).absx), y.ao((ab)((a)localObject2).absx)), paramab), be.a(ac.a(y.an((ab)((a)localObject1).absy), y.ao((ab)((a)localObject2).absy)), paramab));
      AppMethodBeat.o(61273);
      return paramab;
    }
    Object localObject4 = paramab.iOU();
    if (kotlin.l.b.a.b.j.a.a.d.ad(paramab))
    {
      if (localObject4 == null)
      {
        paramab = new t("null cannot be cast to non-null type org.jetbrains.kotlin.resolve.calls.inference.CapturedTypeConstructor");
        AppMethodBeat.o(61273);
        throw paramab;
      }
      localObject3 = ((kotlin.l.b.a.b.j.a.a.b)localObject4).iOV();
      localObject1 = new a(paramab);
      localObject2 = ((av)localObject3).iFN();
      p.j(localObject2, "typeProjection.type");
      localObject2 = ((a)localObject1).aQ((ab)localObject2);
      localObject4 = ((av)localObject3).iQa();
      switch (c.jLJ[localObject4.ordinal()])
      {
      default: 
        paramab = (Throwable)new AssertionError("Only nontrivial projections should have been captured, not: ".concat(String.valueOf(localObject3)));
        AppMethodBeat.o(61273);
        throw paramab;
      case 1: 
        paramab = kotlin.l.b.a.b.m.d.a.aM(paramab).iDv();
        p.j(paramab, "type.builtIns.nullableAnyType");
        paramab = new a(localObject2, paramab);
        AppMethodBeat.o(61273);
        return paramab;
      }
      paramab = kotlin.l.b.a.b.m.d.a.aM(paramab).iDt();
      p.j(paramab, "type.builtIns.nothingType");
      paramab = new a(((a)localObject1).aQ((ab)paramab), localObject2);
      AppMethodBeat.o(61273);
      return paramab;
    }
    if ((paramab.iOR().isEmpty()) || (paramab.iOR().size() != ((at)localObject4).iCb().size()))
    {
      paramab = new a(paramab, paramab);
      AppMethodBeat.o(61273);
      return paramab;
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = new ArrayList();
    Object localObject3 = (Iterable)paramab.iOR();
    localObject4 = ((at)localObject4).iCb();
    p.j(localObject4, "typeConstructor.parameters");
    localObject3 = j.c((Iterable)localObject3, (Iterable)localObject4).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      Object localObject5 = (o)((Iterator)localObject3).next();
      localObject4 = (av)((o)localObject5).Mx;
      localObject5 = (as)((o)localObject5).My;
      p.j(localObject5, "typeParameter");
      localObject5 = b((av)localObject4, (as)localObject5);
      if (((av)localObject4).iPZ())
      {
        ((ArrayList)localObject1).add(localObject5);
        ((ArrayList)localObject2).add(localObject5);
      }
      else
      {
        localObject5 = a((d)localObject5);
        localObject4 = (d)((a)localObject5).absx;
        localObject5 = (d)((a)localObject5).absy;
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
        if (!((d)((Iterator)localObject3).next()).iQh())
        {
          i = 1;
          label634:
          if (i == 0) {
            break label692;
          }
          i = 1;
          label640:
          if (i == 0) {
            break label699;
          }
          localObject1 = kotlin.l.b.a.b.m.d.a.aM(paramab).iDt();
          p.j(localObject1, "type.builtIns.nothingType");
        }
      }
    }
    label692:
    label699:
    for (localObject1 = (ab)localObject1;; localObject1 = a(paramab, (List)localObject1))
    {
      paramab = new a(localObject1, a(paramab, (List)localObject2));
      AppMethodBeat.o(61273);
      return paramab;
      i = 0;
      break label634;
      break;
      i = 0;
      break label640;
    }
  }
  
  private static final d b(av paramav, as paramas)
  {
    AppMethodBeat.i(61270);
    Object localObject = ba.a(paramas.iEW(), paramav);
    switch (c.$EnumSwitchMapping$0[localObject.ordinal()])
    {
    default: 
      paramav = new m();
      AppMethodBeat.o(61270);
      throw paramav;
    case 1: 
      localObject = paramav.iFN();
      p.j(localObject, "type");
      paramav = paramav.iFN();
      p.j(paramav, "type");
      paramav = new d(paramas, (ab)localObject, paramav);
      AppMethodBeat.o(61270);
      return paramav;
    case 2: 
      paramav = paramav.iFN();
      p.j(paramav, "type");
      localObject = kotlin.l.b.a.b.j.d.a.G((l)paramas).iDv();
      p.j(localObject, "typeParameter.builtIns.nullableAnyType");
      paramav = new d(paramas, paramav, (ab)localObject);
      AppMethodBeat.o(61270);
      return paramav;
    }
    localObject = kotlin.l.b.a.b.j.d.a.G((l)paramas).iDt();
    p.j(localObject, "typeParameter.builtIns.nothingType");
    localObject = (ab)localObject;
    paramav = paramav.iFN();
    p.j(paramav, "type");
    paramav = new d(paramas, (ab)localObject, paramav);
    AppMethodBeat.o(61270);
    return paramav;
  }
  
  private static final av e(av paramav)
  {
    AppMethodBeat.i(61272);
    ba localba = ba.d((ay)new c());
    p.j(localba, "TypeSubstitutor.create(o…ojection\n        }\n    })");
    paramav = localba.d(paramav);
    AppMethodBeat.o(61272);
    return paramav;
  }
  
  static final class a
    extends q
    implements kotlin.g.a.b<ab, ab>
  {
    a(ab paramab)
    {
      super();
    }
    
    public final ab aQ(ab paramab)
    {
      AppMethodBeat.i(61262);
      p.k(paramab, "$this$makeNullableIfNeeded");
      paramab = bc.c(paramab, this.abkZ.iIu());
      p.j(paramab, "TypeUtils.makeNullableIf…s, type.isMarkedNullable)");
      AppMethodBeat.o(61262);
      return paramab;
    }
  }
  
  static final class b
    extends q
    implements kotlin.g.a.b<bg, Boolean>
  {
    public static final b absz;
    
    static
    {
      AppMethodBeat.i(61264);
      absz = new b();
      AppMethodBeat.o(61264);
    }
    
    b()
    {
      super();
    }
  }
  
  public static final class c
    extends au
  {
    public final av d(at paramat)
    {
      AppMethodBeat.i(61265);
      p.k(paramat, "key");
      if (!(paramat instanceof kotlin.l.b.a.b.j.a.a.b)) {
        paramat = null;
      }
      for (;;)
      {
        paramat = (kotlin.l.b.a.b.j.a.a.b)paramat;
        if (paramat == null)
        {
          AppMethodBeat.o(61265);
          return null;
        }
        if (paramat.iOV().iPZ())
        {
          paramat = (av)new ax(bh.abrr, paramat.iOV().iFN());
          AppMethodBeat.o(61265);
          return paramat;
        }
        paramat = paramat.iOV();
        AppMethodBeat.o(61265);
        return paramat;
      }
    }
  }
  
  static final class d
    extends q
    implements kotlin.g.a.b<i, x>
  {
    public static final d absA;
    
    static
    {
      AppMethodBeat.i(61267);
      absA = new d();
      AppMethodBeat.o(61267);
    }
    
    d()
    {
      super();
    }
  }
  
  static final class e
    extends q
    implements kotlin.g.a.b<bh, bh>
  {
    e(d paramd)
    {
      super();
    }
    
    public final bh c(bh parambh)
    {
      AppMethodBeat.i(61269);
      p.k(parambh, "variance");
      if (parambh == this.absB.abqV.iEW())
      {
        parambh = bh.abrp;
        AppMethodBeat.o(61269);
        return parambh;
      }
      AppMethodBeat.o(61269);
      return parambh;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.m.e.b
 * JD-Core Version:    0.7.0.1
 */