package d.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ae;
import d.a.v;
import d.g.b.p;
import d.g.b.q;
import d.l.b.a.b.a.k;
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
import d.m.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class ad
{
  private final String NUo;
  private final d.g.a.b<Integer, e> NWM;
  private final d.g.a.b<Integer, h> NWN;
  private final Map<Integer, as> NWO;
  private final ad NWP;
  private final String NWQ;
  boolean NWR;
  final n NWq;
  
  private ad(n paramn, ad paramad, List<a.r> paramList, String paramString1, String paramString2)
  {
    AppMethodBeat.i(60383);
    this.NWq = paramn;
    this.NWP = paramad;
    this.NUo = paramString1;
    this.NWQ = paramString2;
    this.NWR = false;
    this.NWM = ((d.g.a.b)this.NWq.NFN.Nnf.M((d.g.a.b)new a(this)));
    this.NWN = ((d.g.a.b)this.NWq.NFN.Nnf.M((d.g.a.b)new d(this)));
    if (paramList.isEmpty()) {}
    for (paramn = ae.emptyMap();; paramn = (Map)paramn)
    {
      this.NWO = paramn;
      AppMethodBeat.o(60383);
      return;
      paramn = new LinkedHashMap();
      paramad = ((Iterable)paramList).iterator();
      int i = 0;
      while (paramad.hasNext())
      {
        paramList = (a.r)paramad.next();
        ((Map)paramn).put(Integer.valueOf(paramList.NHh), new m(this.NWq, paramList, i));
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
        paramg = u.L("Bad suspend function in metadata with constructor: ".concat(String.valueOf(paramat)), paramList);
        p.g(paramg, "ErrorUtils.createErrorTy…      arguments\n        )");
      }
      AppMethodBeat.o(60375);
      return paramg;
      localObject = b(paramg, paramat, paramList, paramBoolean);
      continue;
      int i = paramList.size() - 1;
      if (i >= 0)
      {
        localObject = paramat.gnF().ajZ(i);
        p.g(localObject, "functionTypeConstructor.…getSuspendFunction(arity)");
        localObject = ((e)localObject).glW();
        p.g(localObject, "functionTypeConstructor.…on(arity).typeConstructor");
        localObject = d.l.b.a.b.m.ac.c(paramg, (at)localObject, paramList, paramBoolean);
      }
    }
  }
  
  private static aj a(ab paramab1, ab paramab2)
  {
    AppMethodBeat.i(60378);
    d.l.b.a.b.a.g localg = d.l.b.a.b.m.d.a.aN(paramab1);
    d.l.b.a.b.b.a.g localg1 = paramab1.gmj();
    ab localab = d.l.b.a.b.a.f.h(paramab1);
    Object localObject = (Iterable)d.a.j.jr(d.l.b.a.b.a.f.j(paramab1));
    Collection localCollection = (Collection)new ArrayList(d.a.j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localCollection.add(((av)((Iterator)localObject).next()).gnW());
    }
    paramab1 = d.l.b.a.b.a.f.a(localg, localg1, localab, (List)localCollection, paramab2, true).Ap(paramab1.gqy());
    AppMethodBeat.o(60378);
    return paramab1;
  }
  
  private final av a(as paramas, a.p.a parama)
  {
    AppMethodBeat.i(60381);
    if (parama.NJV == a.p.a.b.NKb)
    {
      if (paramas == null)
      {
        paramas = (av)new an(this.NWq.NFN.Nqw.gnF());
        AppMethodBeat.o(60381);
        return paramas;
      }
      paramas = (av)new ao(paramas);
      AppMethodBeat.o(60381);
      return paramas;
    }
    paramas = aa.NWG;
    paramas = parama.NJV;
    p.g(paramas, "typeArgumentProto.projection");
    paramas = aa.b(paramas);
    parama = d.l.b.a.b.e.b.g.a(parama, this.NWq.Nka);
    if (parama == null)
    {
      paramas = (av)new ax((ab)u.bey("No type recorded"));
      AppMethodBeat.o(60381);
      return paramas;
    }
    paramas = (av)new ax(paramas, r(parama));
    AppMethodBeat.o(60381);
    return paramas;
  }
  
  private final aj aj(ab paramab)
  {
    Object localObject2 = null;
    AppMethodBeat.i(60377);
    Object localObject1 = (av)d.a.j.jo(d.l.b.a.b.a.f.j(paramab));
    if (localObject1 != null)
    {
      localObject3 = ((av)localObject1).gnW();
      if (localObject3 != null) {}
    }
    else
    {
      AppMethodBeat.o(60377);
      return null;
    }
    p.g(localObject3, "funType.getValueParamete…ll()?.type ?: return null");
    localObject1 = ((ab)localObject3).gxB().gmq();
    if (localObject1 != null) {}
    for (localObject1 = d.l.b.a.b.j.d.a.o((d.l.b.a.b.b.l)localObject1); (((ab)localObject3).gxy().size() != 1) || ((!k.a((d.l.b.a.b.f.b)localObject1, true)) && (!k.a((d.l.b.a.b.f.b)localObject1, false))); localObject1 = null)
    {
      paramab = (aj)paramab;
      AppMethodBeat.o(60377);
      return paramab;
    }
    ab localab = ((av)d.a.j.jp(((ab)localObject3).gxy())).gnW();
    p.g(localab, "continuationArgumentType.arguments.single().type");
    Object localObject3 = this.NWq.NuG;
    localObject1 = localObject3;
    if (!(localObject3 instanceof d.l.b.a.b.b.a)) {
      localObject1 = null;
    }
    localObject3 = (d.l.b.a.b.b.a)localObject1;
    localObject1 = localObject2;
    if (localObject3 != null) {
      localObject1 = d.l.b.a.b.j.d.a.I((d.l.b.a.b.b.l)localObject3);
    }
    if (p.i(localObject1, ac.NWL))
    {
      paramab = a(paramab, localab);
      AppMethodBeat.o(60377);
      return paramab;
    }
    if (this.NWR) {}
    for (boolean bool = true;; bool = false)
    {
      this.NWR = bool;
      paramab = a(paramab, localab);
      AppMethodBeat.o(60377);
      return paramab;
    }
  }
  
  private final at alZ(int paramInt)
  {
    AppMethodBeat.i(60379);
    Object localObject1 = this;
    do
    {
      localObject2 = (as)((ad)localObject1).NWO.get(Integer.valueOf(paramInt));
      if (localObject2 != null)
      {
        at localat = ((as)localObject2).glW();
        localObject2 = localat;
        if (localat != null) {
          break;
        }
      }
      localObject2 = ((ad)localObject1).NWP;
      localObject1 = localObject2;
    } while (localObject2 != null);
    Object localObject2 = null;
    AppMethodBeat.o(60379);
    return localObject2;
  }
  
  private final aj ama(int paramInt)
  {
    AppMethodBeat.i(60380);
    if (x.a(this.NWq.NjZ, paramInt).FdH)
    {
      AppMethodBeat.o(60380);
      return null;
    }
    AppMethodBeat.o(60380);
    return null;
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
    if (paramp.gtA())
    {
      localObject2 = (e)this.NWM.invoke(Integer.valueOf(paramp.NJM));
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = ((e)localObject3).amb(paramp.NJM);
      }
      paramp = ((e)localObject1).glW();
      p.g(paramp, "(classDescriptors(proto.…assName)).typeConstructor");
      AppMethodBeat.o(60374);
      return paramp;
    }
    if (paramp.gtB())
    {
      localObject2 = alZ(paramp.NJN);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        paramp = u.beA("Unknown type parameter " + paramp.NJN + ". Please try recompiling module containing \"" + this.NWQ + '"');
        p.g(paramp, "ErrorUtils.createErrorTy…\\\"\"\n                    )");
        AppMethodBeat.o(60374);
        return paramp;
      }
    }
    else
    {
      if (paramp.gtC())
      {
        localObject2 = this.NWq.NuG;
        localObject3 = this.NWq.NjZ.getString(paramp.NJO);
        localObject1 = ((Iterable)gyd()).iterator();
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          paramp = ((Iterator)localObject1).next();
        } while (!p.i(((as)paramp).gnf().sD(), localObject3));
        for (;;)
        {
          paramp = (as)paramp;
          if (paramp != null)
          {
            paramp = paramp.glW();
            localObject1 = paramp;
            if (paramp != null) {
              break;
            }
          }
          paramp = u.beA("Deserialized type parameter " + (String)localObject3 + " in " + localObject2);
          p.g(paramp, "ErrorUtils.createErrorTy…ter $name in $container\")");
          AppMethodBeat.o(60374);
          return paramp;
          paramp = null;
        }
      }
      if (paramp.gtD())
      {
        localObject2 = (h)this.NWN.invoke(Integer.valueOf(paramp.NJP));
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = (h)((e)localObject3).amb(paramp.NJP);
        }
        paramp = ((h)localObject1).glW();
        p.g(paramp, "(typeAliasDescriptors(pr…iasName)).typeConstructor");
        AppMethodBeat.o(60374);
        return paramp;
      }
      localObject1 = u.beA("Unknown type");
      p.g(localObject1, "ErrorUtils.createErrorTy…nstructor(\"Unknown type\")");
    }
    AppMethodBeat.o(60374);
    return localObject1;
  }
  
  public final List<as> gyd()
  {
    AppMethodBeat.i(60371);
    List localList = d.a.j.l((Iterable)this.NWO.values());
    AppMethodBeat.o(60371);
    return localList;
  }
  
  public final ab r(a.p paramp)
  {
    AppMethodBeat.i(60372);
    p.h(paramp, "proto");
    if (paramp.gtx())
    {
      String str = this.NWq.NjZ.getString(paramp.NJJ);
      aj localaj = s(paramp);
      Object localObject = d.l.b.a.b.e.b.g.a(paramp, this.NWq.Nka);
      if (localObject == null) {
        p.gkB();
      }
      localObject = s((a.p)localObject);
      paramp = this.NWq.NFN.NVV.a(paramp, str, localaj, (aj)localObject);
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
    p.h(paramp, "proto");
    if (paramp.gtA()) {
      ama(paramp.NJM);
    }
    for (;;)
    {
      localObject1 = t(paramp);
      if (!u.L((d.l.b.a.b.b.l)((at)localObject1).gmq())) {
        break;
      }
      paramp = u.a(localObject1.toString(), (at)localObject1);
      p.g(paramp, "ErrorUtils.createErrorTy….toString(), constructor)");
      AppMethodBeat.o(60373);
      return paramp;
      if (paramp.gtD()) {
        ama(paramp.NJP);
      }
    }
    d.l.b.a.b.k.a.b.b localb = new d.l.b.a.b.k.a.b.b(this.NWq.NFN.Nnf, (d.g.a.a)new c(this, paramp));
    Object localObject3 = (Iterable)new b(this).u(paramp);
    Object localObject2 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject3, 10));
    int i = 0;
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      Object localObject4 = ((Iterator)localObject3).next();
      if (i < 0) {
        d.a.j.gkd();
      }
      localObject4 = (a.p.a)localObject4;
      List localList = ((at)localObject1).getParameters();
      p.g(localList, "constructor.parameters");
      ((Collection)localObject2).add(a((as)d.a.j.F(localList, i), (a.p.a)localObject4));
      i += 1;
    }
    localObject2 = d.a.j.l((Iterable)localObject2);
    localObject3 = d.l.b.a.b.e.b.b.NLq.alu(paramp.NHz);
    p.g(localObject3, "Flags.SUSPEND_TYPE.get(proto.flags)");
    if (((Boolean)localObject3).booleanValue()) {}
    for (Object localObject1 = a((d.l.b.a.b.b.a.g)localb, (at)localObject1, (List)localObject2, paramp.NJI);; localObject1 = d.l.b.a.b.m.ac.c((d.l.b.a.b.b.a.g)localb, (at)localObject1, (List)localObject2, paramp.NJI))
    {
      paramp = d.l.b.a.b.e.b.g.c(paramp, this.NWq.Nka);
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
    StringBuilder localStringBuilder = new StringBuilder().append(this.NUo);
    if (this.NWP == null) {}
    for (String str = "";; str = ". Child of " + this.NWP.NUo)
    {
      str = str;
      AppMethodBeat.o(60382);
      return str;
    }
  }
  
  static final class a
    extends q
    implements d.g.a.b<Integer, e>
  {
    a(ad paramad)
    {
      super();
    }
  }
  
  static final class b
    extends q
    implements d.g.a.b<a.p, List<? extends a.p.a>>
  {
    b(ad paramad)
    {
      super();
    }
    
    public final List<a.p.a> u(a.p paramp)
    {
      AppMethodBeat.i(60360);
      p.h(paramp, "$this$collectAllArguments");
      Object localObject = paramp.NHi;
      p.g(localObject, "argumentList");
      Collection localCollection = (Collection)localObject;
      paramp = d.l.b.a.b.e.b.g.b(paramp, this.NWS.NWq.Nka);
      if (paramp != null) {}
      for (paramp = u(paramp);; paramp = null)
      {
        localObject = paramp;
        if (paramp == null) {
          localObject = (List)v.NhH;
        }
        paramp = d.a.j.b(localCollection, (Iterable)localObject);
        AppMethodBeat.o(60360);
        return paramp;
      }
    }
  }
  
  static final class c
    extends q
    implements d.g.a.a<List<? extends d.l.b.a.b.b.a.c>>
  {
    c(ad paramad, a.p paramp)
    {
      super();
    }
  }
  
  static final class d
    extends q
    implements d.g.a.b<Integer, h>
  {
    d(ad paramad)
    {
      super();
    }
  }
  
  static final class e
    extends q
    implements d.g.a.b<Integer, e>
  {
    e(ad paramad, a.p paramp)
    {
      super();
    }
    
    public final e amb(int paramInt)
    {
      AppMethodBeat.i(60370);
      Object localObject = x.a(this.NWS.NWq.NjZ, paramInt);
      List localList = i.d(i.d(i.b(paramp, (d.g.a.b)new b(this)), (d.g.a.b)c.NWW));
      paramInt = i.e(i.b(localObject, (d.g.a.b)a.NWU));
      while (localList.size() < paramInt) {
        localList.add(Integer.valueOf(0));
      }
      localObject = this.NWS.NWq.NFN.Npj.a((d.l.b.a.b.f.a)localObject, localList);
      AppMethodBeat.o(60370);
      return localObject;
    }
    
    static final class b
      extends q
      implements d.g.a.b<a.p, a.p>
    {
      b(ad.e parame)
      {
        super();
      }
    }
    
    static final class c
      extends q
      implements d.g.a.b<a.p, Integer>
    {
      public static final c NWW;
      
      static
      {
        AppMethodBeat.i(60368);
        NWW = new c();
        AppMethodBeat.o(60368);
      }
      
      c()
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.k.a.ad
 * JD-Core Version:    0.7.0.1
 */