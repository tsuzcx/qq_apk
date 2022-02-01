package kotlin.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.a.ae;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.a.k;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.h;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.e.a.p;
import kotlin.l.b.a.b.e.a.p.a;
import kotlin.l.b.a.b.e.a.p.a.b;
import kotlin.l.b.a.b.e.a.r;
import kotlin.l.b.a.b.e.b.b.a;
import kotlin.l.b.a.b.k.a.b.m;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.am;
import kotlin.l.b.a.b.m.an;
import kotlin.l.b.a.b.m.ao;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.av;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.u;
import kotlin.l.d;
import kotlin.m.i;

public final class ad
{
  private final String TJl;
  private final kotlin.g.a.b<Integer, e> TLF;
  private final kotlin.g.a.b<Integer, h> TLG;
  private final Map<Integer, as> TLH;
  private final ad TLI;
  private final String TLJ;
  boolean TLK;
  final n TLm;
  
  private ad(n paramn, ad paramad, List<a.r> paramList, String paramString1, String paramString2)
  {
    AppMethodBeat.i(60383);
    this.TLm = paramn;
    this.TLI = paramad;
    this.TJl = paramString1;
    this.TLJ = paramString2;
    this.TLK = false;
    this.TLF = ((kotlin.g.a.b)this.TLm.Tvt.TcN.V((kotlin.g.a.b)new a(this)));
    this.TLG = ((kotlin.g.a.b)this.TLm.Tvt.TcN.V((kotlin.g.a.b)new d(this)));
    if (paramList.isEmpty()) {}
    for (paramn = ae.emptyMap();; paramn = (Map)paramn)
    {
      this.TLH = paramn;
      AppMethodBeat.o(60383);
      return;
      paramn = new LinkedHashMap();
      paramad = ((Iterable)paramList).iterator();
      int i = 0;
      while (paramad.hasNext())
      {
        paramList = (a.r)paramad.next();
        ((Map)paramn).put(Integer.valueOf(paramList.TwM), new m(this.TLm, paramList, i));
        i += 1;
      }
    }
  }
  
  private final aj a(kotlin.l.b.a.b.b.a.g paramg, at paramat, List<? extends av> paramList, boolean paramBoolean)
  {
    Object localObject = null;
    AppMethodBeat.i(60375);
    switch (paramat.getParameters().size() - paramList.size())
    {
    }
    for (;;)
    {
      paramg = (kotlin.l.b.a.b.b.a.g)localObject;
      if (localObject == null)
      {
        paramg = u.S("Bad suspend function in metadata with constructor: ".concat(String.valueOf(paramat)), paramList);
        p.g(paramg, "ErrorUtils.createErrorTy…      arguments\n        )");
      }
      AppMethodBeat.o(60375);
      return paramg;
      localObject = b(paramg, paramat, paramList, paramBoolean);
      continue;
      int i = paramList.size() - 1;
      if (i >= 0)
      {
        localObject = paramat.hBh().atP(i);
        p.g(localObject, "functionTypeConstructor.…getSuspendFunction(arity)");
        localObject = ((e)localObject).hzz();
        p.g(localObject, "functionTypeConstructor.…on(arity).typeConstructor");
        localObject = kotlin.l.b.a.b.m.ac.c(paramg, (at)localObject, paramList, paramBoolean);
      }
    }
  }
  
  private static aj a(ab paramab1, ab paramab2)
  {
    AppMethodBeat.i(60378);
    kotlin.l.b.a.b.a.g localg = kotlin.l.b.a.b.m.d.a.aM(paramab1);
    kotlin.l.b.a.b.b.a.g localg1 = paramab1.hzL();
    ab localab = kotlin.l.b.a.b.a.f.h(paramab1);
    Object localObject = (Iterable)kotlin.a.j.M(kotlin.l.b.a.b.a.f.j(paramab1), 1);
    Collection localCollection = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localCollection.add(((av)((Iterator)localObject).next()).hBy());
    }
    paramab1 = kotlin.l.b.a.b.a.f.a(localg, localg1, localab, (List)localCollection, paramab2, true).EG(paramab1.hEa());
    AppMethodBeat.o(60378);
    return paramab1;
  }
  
  private final av a(as paramas, a.p.a parama)
  {
    AppMethodBeat.i(60381);
    if (parama.Tzx == a.p.a.b.TzD)
    {
      if (paramas == null)
      {
        paramas = (av)new an(this.TLm.Tvt.Tge.hBh());
        AppMethodBeat.o(60381);
        return paramas;
      }
      paramas = (av)new ao(paramas);
      AppMethodBeat.o(60381);
      return paramas;
    }
    paramas = aa.TLC;
    paramas = parama.Tzx;
    p.g(paramas, "typeArgumentProto.projection");
    paramas = aa.b(paramas);
    parama = kotlin.l.b.a.b.e.b.g.a(parama, this.TLm.SZI);
    if (parama == null)
    {
      paramas = (av)new ax((ab)u.bun("No type recorded"));
      AppMethodBeat.o(60381);
      return paramas;
    }
    paramas = (av)new ax(paramas, r(parama));
    AppMethodBeat.o(60381);
    return paramas;
  }
  
  private final aj ai(ab paramab)
  {
    Object localObject2 = null;
    AppMethodBeat.i(60377);
    Object localObject1 = (av)kotlin.a.j.kv(kotlin.l.b.a.b.a.f.j(paramab));
    if (localObject1 != null)
    {
      localObject3 = ((av)localObject1).hBy();
      if (localObject3 != null) {}
    }
    else
    {
      AppMethodBeat.o(60377);
      return null;
    }
    p.g(localObject3, "funType.getValueParamete…ll()?.type ?: return null");
    localObject1 = ((ab)localObject3).hKE().hzS();
    if (localObject1 != null) {}
    for (localObject1 = kotlin.l.b.a.b.j.d.a.o((kotlin.l.b.a.b.b.l)localObject1); (((ab)localObject3).hKB().size() != 1) || ((!k.a((kotlin.l.b.a.b.f.b)localObject1, true)) && (!k.a((kotlin.l.b.a.b.f.b)localObject1, false))); localObject1 = null)
    {
      paramab = (aj)paramab;
      AppMethodBeat.o(60377);
      return paramab;
    }
    ab localab = ((av)kotlin.a.j.kw(((ab)localObject3).hKB())).hBy();
    p.g(localab, "continuationArgumentType.arguments.single().type");
    Object localObject3 = this.TLm.Tko;
    localObject1 = localObject3;
    if (!(localObject3 instanceof kotlin.l.b.a.b.b.a)) {
      localObject1 = null;
    }
    localObject3 = (kotlin.l.b.a.b.b.a)localObject1;
    localObject1 = localObject2;
    if (localObject3 != null) {
      localObject1 = kotlin.l.b.a.b.j.d.a.I((kotlin.l.b.a.b.b.l)localObject3);
    }
    if (p.j(localObject1, ac.TLE))
    {
      paramab = a(paramab, localab);
      AppMethodBeat.o(60377);
      return paramab;
    }
    if (this.TLK) {}
    for (boolean bool = true;; bool = false)
    {
      this.TLK = bool;
      paramab = a(paramab, localab);
      AppMethodBeat.o(60377);
      return paramab;
    }
  }
  
  private final at avI(int paramInt)
  {
    AppMethodBeat.i(60379);
    Object localObject1 = this;
    do
    {
      localObject2 = (as)((ad)localObject1).TLH.get(Integer.valueOf(paramInt));
      if (localObject2 != null)
      {
        at localat = ((as)localObject2).hzz();
        localObject2 = localat;
        if (localat != null) {
          break;
        }
      }
      localObject2 = ((ad)localObject1).TLI;
      localObject1 = localObject2;
    } while (localObject2 != null);
    Object localObject2 = null;
    AppMethodBeat.o(60379);
    return localObject2;
  }
  
  private final aj avJ(int paramInt)
  {
    AppMethodBeat.i(60380);
    if (x.a(this.TLm.SZH, paramInt).BPb)
    {
      AppMethodBeat.o(60380);
      return null;
    }
    AppMethodBeat.o(60380);
    return null;
  }
  
  private final aj b(kotlin.l.b.a.b.b.a.g paramg, at paramat, List<? extends av> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(60376);
    paramg = kotlin.l.b.a.b.m.ac.c(paramg, paramat, paramList, paramBoolean);
    if (!kotlin.l.b.a.b.a.f.d((ab)paramg))
    {
      AppMethodBeat.o(60376);
      return null;
    }
    paramg = ai((ab)paramg);
    AppMethodBeat.o(60376);
    return paramg;
  }
  
  private final at t(final a.p paramp)
  {
    AppMethodBeat.i(60374);
    Object localObject3 = new e(this, paramp);
    Object localObject2;
    Object localObject1;
    if (paramp.hGX())
    {
      localObject2 = (e)this.TLF.invoke(Integer.valueOf(paramp.Tzo));
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = ((e)localObject3).avK(paramp.Tzo);
      }
      paramp = ((e)localObject1).hzz();
      p.g(paramp, "(classDescriptors(proto.…assName)).typeConstructor");
      AppMethodBeat.o(60374);
      return paramp;
    }
    if (paramp.hGY())
    {
      localObject2 = avI(paramp.Tzp);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        paramp = u.bup("Unknown type parameter " + paramp.Tzp + ". Please try recompiling module containing \"" + this.TLJ + '"');
        p.g(paramp, "ErrorUtils.createErrorTy…\\\"\"\n                    )");
        AppMethodBeat.o(60374);
        return paramp;
      }
    }
    else
    {
      if (paramp.hGZ())
      {
        localObject2 = this.TLm.Tko;
        localObject3 = this.TLm.SZH.getString(paramp.Tzq);
        localObject1 = ((Iterable)hLg()).iterator();
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          paramp = ((Iterator)localObject1).next();
        } while (!p.j(((as)paramp).hAH().sG(), localObject3));
        for (;;)
        {
          paramp = (as)paramp;
          if (paramp != null)
          {
            paramp = paramp.hzz();
            localObject1 = paramp;
            if (paramp != null) {
              break;
            }
          }
          paramp = u.bup("Deserialized type parameter " + (String)localObject3 + " in " + localObject2);
          p.g(paramp, "ErrorUtils.createErrorTy…ter $name in $container\")");
          AppMethodBeat.o(60374);
          return paramp;
          paramp = null;
        }
      }
      if (paramp.hHa())
      {
        localObject2 = (h)this.TLG.invoke(Integer.valueOf(paramp.Tzr));
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = (h)((e)localObject3).avK(paramp.Tzr);
        }
        paramp = ((h)localObject1).hzz();
        p.g(paramp, "(typeAliasDescriptors(pr…iasName)).typeConstructor");
        AppMethodBeat.o(60374);
        return paramp;
      }
      localObject1 = u.bup("Unknown type");
      p.g(localObject1, "ErrorUtils.createErrorTy…nstructor(\"Unknown type\")");
    }
    AppMethodBeat.o(60374);
    return localObject1;
  }
  
  public final List<as> hLg()
  {
    AppMethodBeat.i(60371);
    List localList = kotlin.a.j.p((Iterable)this.TLH.values());
    AppMethodBeat.o(60371);
    return localList;
  }
  
  public final ab r(a.p paramp)
  {
    AppMethodBeat.i(60372);
    p.h(paramp, "proto");
    if (paramp.hGU())
    {
      String str = this.TLm.SZH.getString(paramp.Tzl);
      aj localaj = s(paramp);
      Object localObject = kotlin.l.b.a.b.e.b.g.a(paramp, this.TLm.SZI);
      if (localObject == null) {
        p.hyc();
      }
      localObject = s((a.p)localObject);
      paramp = this.TLm.Tvt.TKR.a(paramp, str, localaj, (aj)localObject);
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
    if (paramp.hGX()) {
      avJ(paramp.Tzo);
    }
    for (;;)
    {
      localObject1 = t(paramp);
      if (!u.L((kotlin.l.b.a.b.b.l)((at)localObject1).hzS())) {
        break;
      }
      paramp = u.a(localObject1.toString(), (at)localObject1);
      p.g(paramp, "ErrorUtils.createErrorTy….toString(), constructor)");
      AppMethodBeat.o(60373);
      return paramp;
      if (paramp.hHa()) {
        avJ(paramp.Tzr);
      }
    }
    kotlin.l.b.a.b.k.a.b.b localb = new kotlin.l.b.a.b.k.a.b.b(this.TLm.Tvt.TcN, (kotlin.g.a.a)new c(this, paramp));
    Object localObject3 = (Iterable)new b(this).u(paramp);
    Object localObject2 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject3, 10));
    int i = 0;
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      Object localObject4 = ((Iterator)localObject3).next();
      if (i < 0) {
        kotlin.a.j.hxH();
      }
      localObject4 = (a.p.a)localObject4;
      List localList = ((at)localObject1).getParameters();
      p.g(localList, "constructor.parameters");
      ((Collection)localObject2).add(a((as)kotlin.a.j.L(localList, i), (a.p.a)localObject4));
      i += 1;
    }
    localObject2 = kotlin.a.j.p((Iterable)localObject2);
    localObject3 = kotlin.l.b.a.b.e.b.b.TAT.avk(paramp.Txb);
    p.g(localObject3, "Flags.SUSPEND_TYPE.get(proto.flags)");
    if (((Boolean)localObject3).booleanValue()) {}
    for (Object localObject1 = a((kotlin.l.b.a.b.b.a.g)localb, (at)localObject1, (List)localObject2, paramp.Tzk);; localObject1 = kotlin.l.b.a.b.m.ac.c((kotlin.l.b.a.b.b.a.g)localb, (at)localObject1, (List)localObject2, paramp.Tzk))
    {
      paramp = kotlin.l.b.a.b.e.b.g.c(paramp, this.TLm.SZI);
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
    StringBuilder localStringBuilder = new StringBuilder().append(this.TJl);
    if (this.TLI == null) {}
    for (String str = "";; str = ". Child of " + this.TLI.TJl)
    {
      str = str;
      AppMethodBeat.o(60382);
      return str;
    }
  }
  
  static final class a
    extends q
    implements kotlin.g.a.b<Integer, e>
  {
    a(ad paramad)
    {
      super();
    }
  }
  
  static final class b
    extends q
    implements kotlin.g.a.b<a.p, List<? extends a.p.a>>
  {
    b(ad paramad)
    {
      super();
    }
    
    public final List<a.p.a> u(a.p paramp)
    {
      AppMethodBeat.i(60360);
      p.h(paramp, "$this$collectAllArguments");
      Object localObject = paramp.TwN;
      p.g(localObject, "argumentList");
      Collection localCollection = (Collection)localObject;
      paramp = kotlin.l.b.a.b.e.b.g.b(paramp, this.TLL.TLm.SZI);
      if (paramp != null) {}
      for (paramp = u(paramp);; paramp = null)
      {
        localObject = paramp;
        if (paramp == null) {
          localObject = (List)v.SXr;
        }
        paramp = kotlin.a.j.b(localCollection, (Iterable)localObject);
        AppMethodBeat.o(60360);
        return paramp;
      }
    }
  }
  
  static final class c
    extends q
    implements kotlin.g.a.a<List<? extends kotlin.l.b.a.b.b.a.c>>
  {
    c(ad paramad, a.p paramp)
    {
      super();
    }
  }
  
  static final class d
    extends q
    implements kotlin.g.a.b<Integer, h>
  {
    d(ad paramad)
    {
      super();
    }
  }
  
  static final class e
    extends q
    implements kotlin.g.a.b<Integer, e>
  {
    e(ad paramad, a.p paramp)
    {
      super();
    }
    
    public final e avK(int paramInt)
    {
      AppMethodBeat.i(60370);
      Object localObject = x.a(this.TLL.TLm.SZH, paramInt);
      List localList = i.d(i.d(i.b(paramp, (kotlin.g.a.b)new b(this)), (kotlin.g.a.b)c.TLP));
      paramInt = i.e(i.b(localObject, (kotlin.g.a.b)a.TLN));
      while (localList.size() < paramInt) {
        localList.add(Integer.valueOf(0));
      }
      localObject = this.TLL.TLm.Tvt.TeR.a((kotlin.l.b.a.b.f.a)localObject, localList);
      AppMethodBeat.o(60370);
      return localObject;
    }
    
    static final class b
      extends q
      implements kotlin.g.a.b<a.p, a.p>
    {
      b(ad.e parame)
      {
        super();
      }
    }
    
    static final class c
      extends q
      implements kotlin.g.a.b<a.p, Integer>
    {
      public static final c TLP;
      
      static
      {
        AppMethodBeat.i(60368);
        TLP = new c();
        AppMethodBeat.o(60368);
      }
      
      c()
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.ad
 * JD-Core Version:    0.7.0.1
 */