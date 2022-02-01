package d.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ae;
import d.a.v;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.e;
import d.l.b.a.b.b.h;
import d.l.b.a.b.b.y;
import d.l.b.a.b.e.a.p;
import d.l.b.a.b.e.a.p.a;
import d.l.b.a.b.e.a.p.a.b;
import d.l.b.a.b.e.a.r;
import d.l.b.a.b.e.b.b.a;
import d.l.b.a.b.k.a.b.m;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.aj;
import d.l.b.a.b.m.am;
import d.l.b.a.b.m.an;
import d.l.b.a.b.m.ao;
import d.l.b.a.b.m.at;
import d.l.b.a.b.m.av;
import d.l.b.a.b.m.ax;
import d.l.b.a.b.m.u;
import d.l.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class ad
{
  private final String JSR;
  final n JUS;
  private final d.g.a.b<Integer, e> JVo;
  private final d.g.a.b<Integer, h> JVp;
  private final Map<Integer, as> JVq;
  private final ad JVr;
  private final String JVs;
  boolean JVt;
  
  private ad(n paramn, ad paramad, List<a.r> paramList, String paramString1, String paramString2)
  {
    AppMethodBeat.i(60383);
    this.JUS = paramn;
    this.JVr = paramad;
    this.JSR = paramString1;
    this.JVs = paramString2;
    this.JVt = false;
    this.JVo = ((d.g.a.b)this.JUS.JEr.JlL.B((d.g.a.b)new a(this)));
    this.JVp = ((d.g.a.b)this.JUS.JEr.JlL.B((d.g.a.b)new d(this)));
    if (paramList.isEmpty()) {}
    for (paramn = ae.emptyMap();; paramn = (Map)paramn)
    {
      this.JVq = paramn;
      AppMethodBeat.o(60383);
      return;
      paramn = new LinkedHashMap();
      paramad = ((Iterable)paramList).iterator();
      int i = 0;
      while (paramad.hasNext())
      {
        paramList = (a.r)paramad.next();
        ((Map)paramn).put(Integer.valueOf(paramList.JFL), new m(this.JUS, paramList, i));
        i += 1;
      }
    }
  }
  
  private final aj a(d.l.b.a.b.b.a.g paramg, at paramat, List<? extends av> paramList, boolean paramBoolean)
  {
    Object localObject = null;
    AppMethodBeat.i(60375);
    switch (paramat.getParameters().size() - paramList.size())
    {
    }
    for (;;)
    {
      paramg = (d.l.b.a.b.b.a.g)localObject;
      if (localObject == null)
      {
        paramg = u.M("Bad suspend function in metadata with constructor: ".concat(String.valueOf(paramat)), paramList);
        d.g.b.k.g(paramg, "ErrorUtils.createErrorTy…      arguments\n        )");
      }
      AppMethodBeat.o(60375);
      return paramg;
      localObject = b(paramg, paramat, paramList, paramBoolean);
      continue;
      int i = paramList.size() - 1;
      if (i >= 0)
      {
        localObject = paramat.fza().adS(i);
        d.g.b.k.g(localObject, "functionTypeConstructor.…getSuspendFunction(arity)");
        localObject = ((e)localObject).fxs();
        d.g.b.k.g(localObject, "functionTypeConstructor.…on(arity).typeConstructor");
        localObject = d.l.b.a.b.m.ac.c(paramg, (at)localObject, paramList, paramBoolean);
      }
    }
  }
  
  private static aj a(ab paramab1, ab paramab2)
  {
    AppMethodBeat.i(60378);
    d.l.b.a.b.a.g localg = d.l.b.a.b.m.d.a.aN(paramab1);
    d.l.b.a.b.b.a.g localg1 = paramab1.fxF();
    ab localab = d.l.b.a.b.a.f.h(paramab1);
    Object localObject = (Iterable)d.a.j.iE(d.l.b.a.b.a.f.j(paramab1));
    Collection localCollection = (Collection)new ArrayList(d.a.j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localCollection.add(((av)((Iterator)localObject).next()).fzr());
    }
    paramab1 = d.l.b.a.b.a.f.a(localg, localg1, localab, (List)localCollection, paramab2, true).xW(paramab1.fBT());
    AppMethodBeat.o(60378);
    return paramab1;
  }
  
  private final av a(as paramas, a.p.a parama)
  {
    AppMethodBeat.i(60381);
    if (parama.JIz == a.p.a.b.JIF)
    {
      if (paramas == null)
      {
        paramas = (av)new an(this.JUS.JEr.Jpd.fza());
        AppMethodBeat.o(60381);
        return paramas;
      }
      paramas = (av)new ao(paramas);
      AppMethodBeat.o(60381);
      return paramas;
    }
    paramas = aa.JVi;
    paramas = parama.JIz;
    d.g.b.k.g(paramas, "typeArgumentProto.projection");
    paramas = aa.b(paramas);
    parama = d.l.b.a.b.e.b.g.a(parama, this.JUS.Jiv);
    if (parama == null)
    {
      paramas = (av)new ax((ab)u.aQS("No type recorded"));
      AppMethodBeat.o(60381);
      return paramas;
    }
    paramas = (av)new ax(paramas, r(parama));
    AppMethodBeat.o(60381);
    return paramas;
  }
  
  private final at afS(int paramInt)
  {
    AppMethodBeat.i(60379);
    Object localObject1 = this;
    do
    {
      localObject2 = (as)((ad)localObject1).JVq.get(Integer.valueOf(paramInt));
      if (localObject2 != null)
      {
        at localat = ((as)localObject2).fxs();
        localObject2 = localat;
        if (localat != null) {
          break;
        }
      }
      localObject2 = ((ad)localObject1).JVr;
      localObject1 = localObject2;
    } while (localObject2 != null);
    Object localObject2 = null;
    AppMethodBeat.o(60379);
    return localObject2;
  }
  
  private final aj afT(int paramInt)
  {
    AppMethodBeat.i(60380);
    if (x.a(this.JUS.Jiu, paramInt).BOl)
    {
      AppMethodBeat.o(60380);
      return null;
    }
    AppMethodBeat.o(60380);
    return null;
  }
  
  private final aj aj(ab paramab)
  {
    Object localObject2 = null;
    AppMethodBeat.i(60377);
    Object localObject1 = (av)d.a.j.iB(d.l.b.a.b.a.f.j(paramab));
    if (localObject1 != null)
    {
      localObject3 = ((av)localObject1).fzr();
      if (localObject3 != null) {}
    }
    else
    {
      AppMethodBeat.o(60377);
      return null;
    }
    d.g.b.k.g(localObject3, "funType.getValueParamete…ll()?.type ?: return null");
    localObject1 = ((ab)localObject3).fIW().fxM();
    if (localObject1 != null) {}
    for (localObject1 = d.l.b.a.b.j.d.a.o((d.l.b.a.b.b.l)localObject1); (((ab)localObject3).fIT().size() != 1) || ((!d.l.b.a.b.a.k.a((d.l.b.a.b.f.b)localObject1, true)) && (!d.l.b.a.b.a.k.a((d.l.b.a.b.f.b)localObject1, false))); localObject1 = null)
    {
      paramab = (aj)paramab;
      AppMethodBeat.o(60377);
      return paramab;
    }
    ab localab = ((av)d.a.j.iC(((ab)localObject3).fIT())).fzr();
    d.g.b.k.g(localab, "continuationArgumentType.arguments.single().type");
    Object localObject3 = this.JUS.Jtl;
    localObject1 = localObject3;
    if (!(localObject3 instanceof d.l.b.a.b.b.a)) {
      localObject1 = null;
    }
    localObject3 = (d.l.b.a.b.b.a)localObject1;
    localObject1 = localObject2;
    if (localObject3 != null) {
      localObject1 = d.l.b.a.b.j.d.a.I((d.l.b.a.b.b.l)localObject3);
    }
    if (d.g.b.k.g(localObject1, ac.JVn))
    {
      paramab = a(paramab, localab);
      AppMethodBeat.o(60377);
      return paramab;
    }
    if (this.JVt) {}
    for (boolean bool = true;; bool = false)
    {
      this.JVt = bool;
      paramab = a(paramab, localab);
      AppMethodBeat.o(60377);
      return paramab;
    }
  }
  
  private final aj b(d.l.b.a.b.b.a.g paramg, at paramat, List<? extends av> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(60376);
    paramg = d.l.b.a.b.m.ac.c(paramg, paramat, paramList, paramBoolean);
    if (!d.l.b.a.b.a.f.d((ab)paramg))
    {
      AppMethodBeat.o(60376);
      return null;
    }
    paramg = aj((ab)paramg);
    AppMethodBeat.o(60376);
    return paramg;
  }
  
  private final at t(final a.p paramp)
  {
    AppMethodBeat.i(60374);
    Object localObject3 = new e(this, paramp);
    Object localObject2;
    Object localObject1;
    if (paramp.fEV())
    {
      localObject2 = (e)this.JVo.aA(Integer.valueOf(paramp.JIq));
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = ((e)localObject3).afU(paramp.JIq);
      }
      paramp = ((e)localObject1).fxs();
      d.g.b.k.g(paramp, "(classDescriptors(proto.…assName)).typeConstructor");
      AppMethodBeat.o(60374);
      return paramp;
    }
    if (paramp.fEW())
    {
      localObject2 = afS(paramp.JIr);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        paramp = u.aQU("Unknown type parameter " + paramp.JIr + ". Please try recompiling module containing \"" + this.JVs + '"');
        d.g.b.k.g(paramp, "ErrorUtils.createErrorTy…\\\"\"\n                    )");
        AppMethodBeat.o(60374);
        return paramp;
      }
    }
    else
    {
      if (paramp.fEX())
      {
        localObject2 = this.JUS.Jtl;
        localObject3 = this.JUS.Jiu.getString(paramp.JIs);
        localObject1 = ((Iterable)fJz()).iterator();
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          paramp = ((Iterator)localObject1).next();
        } while (!d.g.b.k.g(((as)paramp).fyB().qV(), localObject3));
        for (;;)
        {
          paramp = (as)paramp;
          if (paramp != null)
          {
            paramp = paramp.fxs();
            localObject1 = paramp;
            if (paramp != null) {
              break;
            }
          }
          paramp = u.aQU("Deserialized type parameter " + (String)localObject3 + " in " + localObject2);
          d.g.b.k.g(paramp, "ErrorUtils.createErrorTy…ter $name in $container\")");
          AppMethodBeat.o(60374);
          return paramp;
          paramp = null;
        }
      }
      if (paramp.fEY())
      {
        localObject2 = (h)this.JVp.aA(Integer.valueOf(paramp.JIt));
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = (h)((e)localObject3).afU(paramp.JIt);
        }
        paramp = ((h)localObject1).fxs();
        d.g.b.k.g(paramp, "(typeAliasDescriptors(pr…iasName)).typeConstructor");
        AppMethodBeat.o(60374);
        return paramp;
      }
      localObject1 = u.aQU("Unknown type");
      d.g.b.k.g(localObject1, "ErrorUtils.createErrorTy…nstructor(\"Unknown type\")");
    }
    AppMethodBeat.o(60374);
    return localObject1;
  }
  
  public final List<as> fJz()
  {
    AppMethodBeat.i(60371);
    List localList = d.a.j.m((Iterable)this.JVq.values());
    AppMethodBeat.o(60371);
    return localList;
  }
  
  public final ab r(a.p paramp)
  {
    AppMethodBeat.i(60372);
    d.g.b.k.h(paramp, "proto");
    if (paramp.fES())
    {
      String str = this.JUS.Jiu.getString(paramp.JIn);
      aj localaj = s(paramp);
      Object localObject = d.l.b.a.b.e.b.g.a(paramp, this.JUS.Jiv);
      if (localObject == null) {
        d.g.b.k.fvU();
      }
      localObject = s((a.p)localObject);
      paramp = this.JUS.JEr.JUx.a(paramp, str, localaj, (aj)localObject);
      AppMethodBeat.o(60372);
      return paramp;
    }
    paramp = (ab)s(paramp);
    AppMethodBeat.o(60372);
    return paramp;
  }
  
  public final aj s(final a.p paramp)
  {
    AppMethodBeat.i(60373);
    d.g.b.k.h(paramp, "proto");
    if (paramp.fEV()) {
      afT(paramp.JIq);
    }
    for (;;)
    {
      localObject1 = t(paramp);
      if (!u.L((d.l.b.a.b.b.l)((at)localObject1).fxM())) {
        break;
      }
      paramp = u.a(localObject1.toString(), (at)localObject1);
      d.g.b.k.g(paramp, "ErrorUtils.createErrorTy….toString(), constructor)");
      AppMethodBeat.o(60373);
      return paramp;
      if (paramp.fEY()) {
        afT(paramp.JIt);
      }
    }
    d.l.b.a.b.k.a.b.b localb = new d.l.b.a.b.k.a.b.b(this.JUS.JEr.JlL, (d.g.a.a)new c(this, paramp));
    Object localObject3 = (Iterable)new b(this).u(paramp);
    Object localObject2 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject3, 10));
    int i = 0;
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      Object localObject4 = ((Iterator)localObject3).next();
      if (i < 0) {
        d.a.j.fvx();
      }
      localObject4 = (a.p.a)localObject4;
      List localList = ((at)localObject1).getParameters();
      d.g.b.k.g(localList, "constructor.parameters");
      ((Collection)localObject2).add(a((as)d.a.j.C(localList, i), (a.p.a)localObject4));
      i += 1;
    }
    localObject2 = d.a.j.m((Iterable)localObject2);
    localObject3 = d.l.b.a.b.e.b.b.JJU.afn(paramp.JGd);
    d.g.b.k.g(localObject3, "Flags.SUSPEND_TYPE.get(proto.flags)");
    if (((Boolean)localObject3).booleanValue()) {}
    for (Object localObject1 = a((d.l.b.a.b.b.a.g)localb, (at)localObject1, (List)localObject2, paramp.JIm);; localObject1 = d.l.b.a.b.m.ac.c((d.l.b.a.b.b.a.g)localb, (at)localObject1, (List)localObject2, paramp.JIm))
    {
      paramp = d.l.b.a.b.e.b.g.c(paramp, this.JUS.Jiv);
      if (paramp != null) {
        break;
      }
      AppMethodBeat.o(60373);
      return localObject1;
    }
    paramp = am.b((aj)localObject1, s(paramp));
    AppMethodBeat.o(60373);
    return paramp;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60382);
    StringBuilder localStringBuilder = new StringBuilder().append(this.JSR);
    if (this.JVr == null) {}
    for (String str = "";; str = ". Child of " + this.JVr.JSR)
    {
      str = str;
      AppMethodBeat.o(60382);
      return str;
    }
  }
  
  static final class a
    extends d.g.b.l
    implements d.g.a.b<Integer, e>
  {
    a(ad paramad)
    {
      super();
    }
  }
  
  static final class b
    extends d.g.b.l
    implements d.g.a.b<a.p, List<? extends a.p.a>>
  {
    b(ad paramad)
    {
      super();
    }
    
    public final List<a.p.a> u(a.p paramp)
    {
      AppMethodBeat.i(60360);
      d.g.b.k.h(paramp, "$this$collectAllArguments");
      Object localObject = paramp.JFM;
      d.g.b.k.g(localObject, "argumentList");
      Collection localCollection = (Collection)localObject;
      paramp = d.l.b.a.b.e.b.g.b(paramp, this.JVu.JUS.Jiv);
      if (paramp != null) {}
      for (paramp = u(paramp);; paramp = null)
      {
        localObject = paramp;
        if (paramp == null) {
          localObject = (List)v.Jgl;
        }
        paramp = d.a.j.b(localCollection, (Iterable)localObject);
        AppMethodBeat.o(60360);
        return paramp;
      }
    }
  }
  
  static final class c
    extends d.g.b.l
    implements d.g.a.a<List<? extends d.l.b.a.b.b.a.c>>
  {
    c(ad paramad, a.p paramp)
    {
      super();
    }
  }
  
  static final class d
    extends d.g.b.l
    implements d.g.a.b<Integer, h>
  {
    d(ad paramad)
    {
      super();
    }
  }
  
  static final class e
    extends d.g.b.l
    implements d.g.a.b<Integer, e>
  {
    e(ad paramad, a.p paramp)
    {
      super();
    }
    
    public final e afU(int paramInt)
    {
      AppMethodBeat.i(60370);
      Object localObject = x.a(this.JVu.JUS.Jiu, paramInt);
      List localList = d.m.i.d(d.m.i.d(d.m.i.b(paramp, (d.g.a.b)new b(this)), (d.g.a.b)c.JVy));
      paramInt = d.m.i.e(d.m.i.b(localObject, (d.g.a.b)a.JVw));
      while (localList.size() < paramInt) {
        localList.add(Integer.valueOf(0));
      }
      localObject = this.JVu.JUS.JEr.JnP.a((d.l.b.a.b.f.a)localObject, localList);
      AppMethodBeat.o(60370);
      return localObject;
    }
    
    static final class b
      extends d.g.b.l
      implements d.g.a.b<a.p, a.p>
    {
      b(ad.e parame)
      {
        super();
      }
    }
    
    static final class c
      extends d.g.b.l
      implements d.g.a.b<a.p, Integer>
    {
      public static final c JVy;
      
      static
      {
        AppMethodBeat.i(60368);
        JVy = new c();
        AppMethodBeat.o(60368);
      }
      
      c()
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.k.a.ad
 * JD-Core Version:    0.7.0.1
 */