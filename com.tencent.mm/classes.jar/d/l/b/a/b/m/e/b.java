package d.l.b.a.b.m.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.b.p;
import d.g.b.q;
import d.l.b.a.b.a.g;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.l;
import d.l.b.a.b.i.c;
import d.l.b.a.b.i.c.a;
import d.l.b.a.b.i.i;
import d.l.b.a.b.m.ab;
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
import d.l.b.a.b.m.y;
import d.m;
import d.o;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class b
{
  private static final ab a(ab paramab, List<d> paramList)
  {
    AppMethodBeat.i(61274);
    if (paramab.gxy().size() == paramList.size()) {}
    for (int i = 1; (d.ac.Nhs) && (i == 0); i = 0)
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
      boolean bool = paramList.gyM();
      if ((d.ac.Nhs) && (!bool))
      {
        paramab = c.NQn;
        paramab = c.a.K((d.g.a.b)d.Obh);
        paramab = (Throwable)new AssertionError("Only consistent enhanced type projection can be converted to type projection, but [" + paramab.k((l)paramList.NZC) + ": <" + paramab.b(paramList.Obj) + ", " + paramab.b(paramList.Obk) + ">] was found");
        AppMethodBeat.o(61274);
        throw paramab;
      }
      e locale = new e(paramList);
      if (p.i(paramList.Obj, paramList.Obk)) {
        paramList = (av)new ax(paramList.Obj);
      }
      for (;;)
      {
        localCollection.add(paramList);
        break;
        if ((g.x(paramList.Obj)) && (paramList.NZC.gnh() != bh.NZX)) {
          paramList = (av)new ax(locale.c(bh.NZY), paramList.Obk);
        } else if (g.A(paramList.Obk)) {
          paramList = (av)new ax(locale.c(bh.NZX), paramList.Obj);
        } else {
          paramList = (av)new ax(locale.c(bh.NZY), paramList.Obk);
        }
      }
    }
    paramab = az.a(paramab, (List)localCollection, paramab.gmj());
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
    if (paramav.gyE())
    {
      AppMethodBeat.o(61271);
      return paramav;
    }
    ab localab = paramav.gnW();
    p.g(localab, "typeProjection.type");
    if (!bc.b(localab, (d.g.a.b)b.Obg))
    {
      AppMethodBeat.o(61271);
      return paramav;
    }
    bh localbh = paramav.gyF();
    p.g(localbh, "typeProjection.projectionKind");
    if (localbh == bh.NZY)
    {
      paramav = (av)new ax(localbh, (ab)aQ(localab).Obf);
      AppMethodBeat.o(61271);
      return paramav;
    }
    if (paramBoolean)
    {
      paramav = (av)new ax(localbh, (ab)aQ(localab).Obe);
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
    Object localObject1 = aQ(paramd.Obj);
    ab localab1 = (ab)((a)localObject1).Obe;
    localObject1 = (ab)((a)localObject1).Obf;
    Object localObject2 = aQ(paramd.Obk);
    ab localab2 = (ab)((a)localObject2).Obe;
    localObject2 = (ab)((a)localObject2).Obf;
    paramd = new a(new d(paramd.NZC, (ab)localObject1, localab2), new d(paramd.NZC, localab1, (ab)localObject2));
    AppMethodBeat.o(61275);
    return paramd;
  }
  
  public static final a<ab> aQ(ab paramab)
  {
    AppMethodBeat.i(61273);
    p.h(paramab, "type");
    if (y.am(paramab))
    {
      localObject1 = aQ((ab)y.ao(paramab));
      localObject2 = aQ((ab)y.ap(paramab));
      paramab = new a(be.a(d.l.b.a.b.m.ac.a(y.ao((ab)((a)localObject1).Obe), y.ap((ab)((a)localObject2).Obe)), paramab), be.a(d.l.b.a.b.m.ac.a(y.ao((ab)((a)localObject1).Obf), y.ap((ab)((a)localObject2).Obf)), paramab));
      AppMethodBeat.o(61273);
      return paramab;
    }
    Object localObject4 = paramab.gxB();
    if (d.l.b.a.b.j.a.a.d.ae(paramab))
    {
      if (localObject4 == null)
      {
        paramab = new v("null cannot be cast to non-null type org.jetbrains.kotlin.resolve.calls.inference.CapturedTypeConstructor");
        AppMethodBeat.o(61273);
        throw paramab;
      }
      localObject3 = ((d.l.b.a.b.j.a.a.b)localObject4).gxC();
      localObject1 = new a(paramab);
      localObject2 = ((av)localObject3).gnW();
      p.g(localObject2, "typeProjection.type");
      localObject2 = ((a)localObject1).aR((ab)localObject2);
      localObject4 = ((av)localObject3).gyF();
      switch (c.gpL[localObject4.ordinal()])
      {
      default: 
        paramab = (Throwable)new AssertionError("Only nontrivial projections should have been captured, not: ".concat(String.valueOf(localObject3)));
        AppMethodBeat.o(61273);
        throw paramab;
      case 1: 
        paramab = d.l.b.a.b.m.d.a.aN(paramab).glG();
        p.g(paramab, "type.builtIns.nullableAnyType");
        paramab = new a(localObject2, paramab);
        AppMethodBeat.o(61273);
        return paramab;
      }
      paramab = d.l.b.a.b.m.d.a.aN(paramab).glE();
      p.g(paramab, "type.builtIns.nothingType");
      paramab = new a(((a)localObject1).aR((ab)paramab), localObject2);
      AppMethodBeat.o(61273);
      return paramab;
    }
    if ((paramab.gxy().isEmpty()) || (paramab.gxy().size() != ((at)localObject4).getParameters().size()))
    {
      paramab = new a(paramab, paramab);
      AppMethodBeat.o(61273);
      return paramab;
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = new ArrayList();
    Object localObject3 = (Iterable)paramab.gxy();
    localObject4 = ((at)localObject4).getParameters();
    p.g(localObject4, "typeConstructor.parameters");
    localObject3 = j.c((Iterable)localObject3, (Iterable)localObject4).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      Object localObject5 = (o)((Iterator)localObject3).next();
      localObject4 = (av)((o)localObject5).first;
      localObject5 = (as)((o)localObject5).second;
      p.g(localObject5, "typeParameter");
      localObject5 = b((av)localObject4, (as)localObject5);
      if (((av)localObject4).gyE())
      {
        ((ArrayList)localObject1).add(localObject5);
        ((ArrayList)localObject2).add(localObject5);
      }
      else
      {
        localObject5 = a((d)localObject5);
        localObject4 = (d)((a)localObject5).Obe;
        localObject5 = (d)((a)localObject5).Obf;
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
        if (!((d)((Iterator)localObject3).next()).gyM())
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
          localObject1 = d.l.b.a.b.m.d.a.aN(paramab).glE();
          p.g(localObject1, "type.builtIns.nothingType");
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
    Object localObject = ba.a(paramas.gnh(), paramav);
    switch (c.cqt[localObject.ordinal()])
    {
    default: 
      paramav = new m();
      AppMethodBeat.o(61270);
      throw paramav;
    case 1: 
      localObject = paramav.gnW();
      p.g(localObject, "type");
      paramav = paramav.gnW();
      p.g(paramav, "type");
      paramav = new d(paramas, (ab)localObject, paramav);
      AppMethodBeat.o(61270);
      return paramav;
    case 2: 
      paramav = paramav.gnW();
      p.g(paramav, "type");
      localObject = d.l.b.a.b.j.d.a.G((l)paramas).glG();
      p.g(localObject, "typeParameter.builtIns.nullableAnyType");
      paramav = new d(paramas, paramav, (ab)localObject);
      AppMethodBeat.o(61270);
      return paramav;
    }
    localObject = d.l.b.a.b.j.d.a.G((l)paramas).glE();
    p.g(localObject, "typeParameter.builtIns.nothingType");
    localObject = (ab)localObject;
    paramav = paramav.gnW();
    p.g(paramav, "type");
    paramav = new d(paramas, (ab)localObject, paramav);
    AppMethodBeat.o(61270);
    return paramav;
  }
  
  private static final av e(av paramav)
  {
    AppMethodBeat.i(61272);
    ba localba = ba.d((ay)new c());
    p.g(localba, "TypeSubstitutor.create(o…ojection\n        }\n    })");
    paramav = localba.d(paramav);
    AppMethodBeat.o(61272);
    return paramav;
  }
  
  static final class a
    extends q
    implements d.g.a.b<ab, ab>
  {
    a(ab paramab)
    {
      super();
    }
    
    public final ab aR(ab paramab)
    {
      AppMethodBeat.i(61262);
      p.h(paramab, "$this$makeNullableIfNeeded");
      paramab = bc.b(paramab, this.NTz.gqy());
      p.g(paramab, "TypeUtils.makeNullableIf…s, type.isMarkedNullable)");
      AppMethodBeat.o(61262);
      return paramab;
    }
  }
  
  static final class b
    extends q
    implements d.g.a.b<bg, Boolean>
  {
    public static final b Obg;
    
    static
    {
      AppMethodBeat.i(61264);
      Obg = new b();
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
      p.h(paramat, "key");
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
        if (paramat.gxC().gyE())
        {
          paramat = (av)new ax(bh.NZY, paramat.gxC().gnW());
          AppMethodBeat.o(61265);
          return paramat;
        }
        paramat = paramat.gxC();
        AppMethodBeat.o(61265);
        return paramat;
      }
    }
  }
  
  static final class d
    extends q
    implements d.g.a.b<i, z>
  {
    public static final d Obh;
    
    static
    {
      AppMethodBeat.i(61267);
      Obh = new d();
      AppMethodBeat.o(61267);
    }
    
    d()
    {
      super();
    }
  }
  
  static final class e
    extends q
    implements d.g.a.b<bh, bh>
  {
    e(d paramd)
    {
      super();
    }
    
    public final bh c(bh parambh)
    {
      AppMethodBeat.i(61269);
      p.h(parambh, "variance");
      if (parambh == this.Obi.NZC.gnh())
      {
        parambh = bh.NZW;
        AppMethodBeat.o(61269);
        return parambh;
      }
      AppMethodBeat.o(61269);
      return parambh;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.e.b
 * JD-Core Version:    0.7.0.1
 */