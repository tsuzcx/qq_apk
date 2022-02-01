package d.l.b.a.b.m.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.aa;
import d.g.b.k;
import d.l.b.a.b.a.g;
import d.l.b.a.b.b.as;
import d.l.b.a.b.i.c;
import d.l.b.a.b.i.c.a;
import d.l.b.a.b.i.i;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.ac;
import d.l.b.a.b.m.at;
import d.l.b.a.b.m.au;
import d.l.b.a.b.m.av;
import d.l.b.a.b.m.ax;
import d.l.b.a.b.m.ay;
import d.l.b.a.b.m.az;
import d.l.b.a.b.m.ba;
import d.l.b.a.b.m.bc;
import d.l.b.a.b.m.be;
import d.l.b.a.b.m.bg;
import d.l.b.a.b.m.bh;
import d.m;
import d.o;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class b
{
  private static final ab a(ab paramab, List<d> paramList)
  {
    AppMethodBeat.i(61274);
    if (paramab.fIT().size() == paramList.size()) {}
    for (int i = 1; (aa.JfW) && (i == 0); i = 0)
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
      boolean bool = paramList.fKg();
      if ((aa.JfW) && (!bool))
      {
        paramab = c.JOQ;
        paramab = c.a.z((d.g.a.b)d.JZM);
        paramab = (Throwable)new AssertionError("Only consistent enhanced type projection can be converted to type projection, but [" + paramab.k((d.l.b.a.b.b.l)paramList.JYh) + ": <" + paramab.b(paramList.JZO) + ", " + paramab.b(paramList.JZP) + ">] was found");
        AppMethodBeat.o(61274);
        throw paramab;
      }
      e locale = new e(paramList);
      if (k.g(paramList.JZO, paramList.JZP)) {
        paramList = (av)new ax(paramList.JZO);
      }
      for (;;)
      {
        localCollection.add(paramList);
        break;
        if ((g.x(paramList.JZO)) && (paramList.JYh.fyC() != bh.JYD)) {
          paramList = (av)new ax(locale.c(bh.JYE), paramList.JZP);
        } else if (g.A(paramList.JZP)) {
          paramList = (av)new ax(locale.c(bh.JYD), paramList.JZO);
        } else {
          paramList = (av)new ax(locale.c(bh.JYE), paramList.JZP);
        }
      }
    }
    paramab = az.a(paramab, (List)localCollection, paramab.fxF());
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
    if (paramav.fJY())
    {
      AppMethodBeat.o(61271);
      return paramav;
    }
    ab localab = paramav.fzr();
    k.g(localab, "typeProjection.type");
    if (!bc.b(localab, (d.g.a.b)b.JZL))
    {
      AppMethodBeat.o(61271);
      return paramav;
    }
    bh localbh = paramav.fJZ();
    k.g(localbh, "typeProjection.projectionKind");
    if (localbh == bh.JYE)
    {
      paramav = (av)new ax(localbh, (ab)aQ(localab).JZK);
      AppMethodBeat.o(61271);
      return paramav;
    }
    if (paramBoolean)
    {
      paramav = (av)new ax(localbh, (ab)aQ(localab).JZJ);
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
    Object localObject1 = aQ(paramd.JZO);
    ab localab1 = (ab)((a)localObject1).JZJ;
    localObject1 = (ab)((a)localObject1).JZK;
    Object localObject2 = aQ(paramd.JZP);
    ab localab2 = (ab)((a)localObject2).JZJ;
    localObject2 = (ab)((a)localObject2).JZK;
    paramd = new a(new d(paramd.JYh, (ab)localObject1, localab2), new d(paramd.JYh, localab1, (ab)localObject2));
    AppMethodBeat.o(61275);
    return paramd;
  }
  
  public static final a<ab> aQ(ab paramab)
  {
    AppMethodBeat.i(61273);
    k.h(paramab, "type");
    if (d.l.b.a.b.m.y.am(paramab))
    {
      localObject1 = aQ((ab)d.l.b.a.b.m.y.ao(paramab));
      localObject2 = aQ((ab)d.l.b.a.b.m.y.ap(paramab));
      paramab = new a(be.a(ac.a(d.l.b.a.b.m.y.ao((ab)((a)localObject1).JZJ), d.l.b.a.b.m.y.ap((ab)((a)localObject2).JZJ)), paramab), be.a(ac.a(d.l.b.a.b.m.y.ao((ab)((a)localObject1).JZK), d.l.b.a.b.m.y.ap((ab)((a)localObject2).JZK)), paramab));
      AppMethodBeat.o(61273);
      return paramab;
    }
    Object localObject4 = paramab.fIW();
    if (d.l.b.a.b.j.a.a.d.ae(paramab))
    {
      if (localObject4 == null)
      {
        paramab = new v("null cannot be cast to non-null type org.jetbrains.kotlin.resolve.calls.inference.CapturedTypeConstructor");
        AppMethodBeat.o(61273);
        throw paramab;
      }
      localObject3 = ((d.l.b.a.b.j.a.a.b)localObject4).fIX();
      localObject1 = new a(paramab);
      localObject2 = ((av)localObject3).fzr();
      k.g(localObject2, "typeProjection.type");
      localObject2 = ((a)localObject1).aR((ab)localObject2);
      localObject4 = ((av)localObject3).fJZ();
      switch (c.fPQ[localObject4.ordinal()])
      {
      default: 
        paramab = (Throwable)new AssertionError("Only nontrivial projections should have been captured, not: ".concat(String.valueOf(localObject3)));
        AppMethodBeat.o(61273);
        throw paramab;
      case 1: 
        paramab = d.l.b.a.b.m.d.a.aN(paramab).fxc();
        k.g(paramab, "type.builtIns.nullableAnyType");
        paramab = new a(localObject2, paramab);
        AppMethodBeat.o(61273);
        return paramab;
      }
      paramab = d.l.b.a.b.m.d.a.aN(paramab).fxa();
      k.g(paramab, "type.builtIns.nothingType");
      paramab = new a(((a)localObject1).aR((ab)paramab), localObject2);
      AppMethodBeat.o(61273);
      return paramab;
    }
    if ((paramab.fIT().isEmpty()) || (paramab.fIT().size() != ((at)localObject4).getParameters().size()))
    {
      paramab = new a(paramab, paramab);
      AppMethodBeat.o(61273);
      return paramab;
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = new ArrayList();
    Object localObject3 = (Iterable)paramab.fIT();
    localObject4 = ((at)localObject4).getParameters();
    k.g(localObject4, "typeConstructor.parameters");
    localObject3 = j.b((Iterable)localObject3, (Iterable)localObject4).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      Object localObject5 = (o)((Iterator)localObject3).next();
      localObject4 = (av)((o)localObject5).first;
      localObject5 = (as)((o)localObject5).second;
      k.g(localObject5, "typeParameter");
      localObject5 = b((av)localObject4, (as)localObject5);
      if (((av)localObject4).fJY())
      {
        ((ArrayList)localObject1).add(localObject5);
        ((ArrayList)localObject2).add(localObject5);
      }
      else
      {
        localObject5 = a((d)localObject5);
        localObject4 = (d)((a)localObject5).JZJ;
        localObject5 = (d)((a)localObject5).JZK;
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
        if (!((d)((Iterator)localObject3).next()).fKg())
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
          localObject1 = d.l.b.a.b.m.d.a.aN(paramab).fxa();
          k.g(localObject1, "type.builtIns.nothingType");
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
    Object localObject = ba.a(paramas.fyC(), paramav);
    switch (c.ciE[localObject.ordinal()])
    {
    default: 
      paramav = new m();
      AppMethodBeat.o(61270);
      throw paramav;
    case 1: 
      localObject = paramav.fzr();
      k.g(localObject, "type");
      paramav = paramav.fzr();
      k.g(paramav, "type");
      paramav = new d(paramas, (ab)localObject, paramav);
      AppMethodBeat.o(61270);
      return paramav;
    case 2: 
      paramav = paramav.fzr();
      k.g(paramav, "type");
      localObject = d.l.b.a.b.j.d.a.G((d.l.b.a.b.b.l)paramas).fxc();
      k.g(localObject, "typeParameter.builtIns.nullableAnyType");
      paramav = new d(paramas, paramav, (ab)localObject);
      AppMethodBeat.o(61270);
      return paramav;
    }
    localObject = d.l.b.a.b.j.d.a.G((d.l.b.a.b.b.l)paramas).fxa();
    k.g(localObject, "typeParameter.builtIns.nothingType");
    localObject = (ab)localObject;
    paramav = paramav.fzr();
    k.g(paramav, "type");
    paramav = new d(paramas, (ab)localObject, paramav);
    AppMethodBeat.o(61270);
    return paramav;
  }
  
  private static final av e(av paramav)
  {
    AppMethodBeat.i(61272);
    ba localba = ba.d((ay)new c());
    k.g(localba, "TypeSubstitutor.create(o…ojection\n        }\n    })");
    paramav = localba.d(paramav);
    AppMethodBeat.o(61272);
    return paramav;
  }
  
  static final class a
    extends d.g.b.l
    implements d.g.a.b<ab, ab>
  {
    a(ab paramab)
    {
      super();
    }
    
    public final ab aR(ab paramab)
    {
      AppMethodBeat.i(61262);
      k.h(paramab, "$this$makeNullableIfNeeded");
      paramab = bc.b(paramab, this.JSc.fBT());
      k.g(paramab, "TypeUtils.makeNullableIf…s, type.isMarkedNullable)");
      AppMethodBeat.o(61262);
      return paramab;
    }
  }
  
  static final class b
    extends d.g.b.l
    implements d.g.a.b<bg, Boolean>
  {
    public static final b JZL;
    
    static
    {
      AppMethodBeat.i(61264);
      JZL = new b();
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
      k.h(paramat, "key");
      if (!(paramat instanceof d.l.b.a.b.j.a.a.b)) {
        paramat = null;
      }
      for (;;)
      {
        paramat = (d.l.b.a.b.j.a.a.b)paramat;
        if (paramat == null)
        {
          AppMethodBeat.o(61265);
          return null;
        }
        if (paramat.fIX().fJY())
        {
          paramat = (av)new ax(bh.JYE, paramat.fIX().fzr());
          AppMethodBeat.o(61265);
          return paramat;
        }
        paramat = paramat.fIX();
        AppMethodBeat.o(61265);
        return paramat;
      }
    }
  }
  
  static final class d
    extends d.g.b.l
    implements d.g.a.b<i, d.y>
  {
    public static final d JZM;
    
    static
    {
      AppMethodBeat.i(61267);
      JZM = new d();
      AppMethodBeat.o(61267);
    }
    
    d()
    {
      super();
    }
  }
  
  static final class e
    extends d.g.b.l
    implements d.g.a.b<bh, bh>
  {
    e(d paramd)
    {
      super();
    }
    
    public final bh c(bh parambh)
    {
      AppMethodBeat.i(61269);
      k.h(parambh, "variance");
      if (parambh == this.JZN.JYh.fyC())
      {
        parambh = bh.JYC;
        AppMethodBeat.o(61269);
        return parambh;
      }
      AppMethodBeat.o(61269);
      return parambh;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.e.b
 * JD-Core Version:    0.7.0.1
 */