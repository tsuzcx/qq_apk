package d.l.b.a.b.d.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.v;
import d.aa;
import d.g.a.b<-Ld.l.b.a.b.f.f;+Ljava.util.Collection<+Ld.l.b.a.b.b.am;>;>;
import d.l.b.a.b.b.ah;
import d.l.b.a.b.b.ai;
import d.l.b.a.b.b.am;
import d.l.b.a.b.b.an;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.c.ae;
import d.l.b.a.b.b.t.a;
import d.l.b.a.b.b.w;
import d.l.b.a.b.d.a.e.q;
import d.l.b.a.b.d.a.e.x;
import d.l.b.a.b.d.a.m;
import d.l.b.a.b.d.a.m.a;
import d.l.b.a.b.d.a.o;
import d.l.b.a.b.d.a.s;
import d.l.b.a.b.j.i.a;
import d.l.b.a.b.j.i.a.a;
import d.l.b.a.b.k.a.r;
import d.l.b.a.b.m.at;
import d.l.b.a.b.m.bc;
import d.l.b.a.b.o.i.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class g
  extends k
{
  private final d.l.b.a.b.d.a.e.g LnZ;
  private final d.l.b.a.b.l.f<Map<d.l.b.a.b.f.f, d.l.b.a.b.d.a.e.n>> LoA;
  private final d.l.b.a.b.l.d<d.l.b.a.b.f.f, d.l.b.a.b.b.c.g> LoB;
  final d.l.b.a.b.b.e LoC;
  private final boolean LoD;
  final d.l.b.a.b.l.f<List<d.l.b.a.b.b.d>> Loy;
  private final d.l.b.a.b.l.f<Set<d.l.b.a.b.f.f>> Loz;
  
  public g(final d.l.b.a.b.d.a.c.h paramh, d.l.b.a.b.b.e parame, d.l.b.a.b.d.a.e.g paramg, boolean paramBoolean, g paramg1)
  {
    super(paramh, (k)paramg1);
    AppMethodBeat.i(57876);
    this.LoC = parame;
    this.LnZ = paramg;
    this.LoD = paramBoolean;
    this.Loy = paramh.LnL.KZf.O((d.g.a.a)new f(this, paramh));
    this.Loz = paramh.LnL.KZf.O((d.g.a.a)new i(this));
    this.LoA = paramh.LnL.KZf.O((d.g.a.a)new g(this));
    this.LoB = paramh.LnL.KZf.J((d.g.a.b)new j(this, paramh));
    AppMethodBeat.o(57876);
  }
  
  private final am a(ah paramah, d.g.a.b<? super d.l.b.a.b.f.f, ? extends Collection<? extends am>> paramb)
  {
    AppMethodBeat.i(57850);
    Object localObject1 = paramah.fRK();
    if (localObject1 != null)
    {
      localObject1 = (ai)d.l.b.a.b.d.a.t.m((d.l.b.a.b.b.b)localObject1);
      if (localObject1 == null) {
        break label84;
      }
      localObject2 = d.l.b.a.b.d.a.e.Lll;
    }
    label84:
    for (Object localObject2 = d.l.b.a.b.d.a.e.l((d.l.b.a.b.b.b)localObject1);; localObject2 = null)
    {
      if ((localObject2 == null) || (d.l.b.a.b.d.a.t.a(this.LoC, (d.l.b.a.b.b.a)localObject1))) {
        break label90;
      }
      paramah = a(paramah, (String)localObject2, paramb);
      AppMethodBeat.o(57850);
      return paramah;
      localObject1 = null;
      break;
    }
    label90:
    localObject1 = o.aWm(paramah.fRf().rf());
    d.g.b.k.g(localObject1, "JvmAbi.getterName(name.asString())");
    paramah = a(paramah, (String)localObject1, paramb);
    AppMethodBeat.o(57850);
    return paramah;
  }
  
  private static am a(ah paramah, String paramString, d.g.a.b<? super d.l.b.a.b.f.f, ? extends Collection<? extends am>> paramb)
  {
    AppMethodBeat.i(57851);
    paramString = d.l.b.a.b.f.f.aWB(paramString);
    d.g.b.k.g(paramString, "Name.identifier(getterName)");
    paramb = ((Iterable)paramb.ay(paramString)).iterator();
    label119:
    label122:
    while (paramb.hasNext())
    {
      paramString = (am)paramb.next();
      d.l.b.a.b.m.a.g localg;
      d.l.b.a.b.m.ab localab;
      boolean bool;
      if (paramString.fQU().size() == 0)
      {
        localg = d.l.b.a.b.m.a.g.LMg;
        localab = paramString.fQS();
        if (localab == null)
        {
          bool = false;
          if (!bool) {
            break label119;
          }
        }
      }
      for (;;)
      {
        if (paramString == null) {
          break label122;
        }
        AppMethodBeat.o(57851);
        return paramString;
        bool = localg.c(localab, paramah.fRV());
        break;
        paramString = null;
      }
    }
    AppMethodBeat.o(57851);
    return null;
  }
  
  private static am a(am paramam, d.g.a.b<? super d.l.b.a.b.f.f, ? extends Collection<? extends am>> paramb)
  {
    AppMethodBeat.i(57857);
    if (!paramam.fRw())
    {
      AppMethodBeat.o(57857);
      return null;
    }
    Object localObject = paramam.fRf();
    d.g.b.k.g(localObject, "descriptor.name");
    localObject = ((Iterable)paramb.ay(localObject)).iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramb = h((am)((Iterator)localObject).next());
      if (paramb != null) {
        if (!b((d.l.b.a.b.b.a)paramb, (d.l.b.a.b.b.a)paramam)) {}
      }
      while (paramb != null)
      {
        AppMethodBeat.o(57857);
        return paramb;
        paramb = null;
        continue;
        paramb = null;
      }
    }
    AppMethodBeat.o(57857);
    return null;
  }
  
  private static am a(am paramam, d.l.b.a.b.b.a parama, Collection<? extends am> paramCollection)
  {
    AppMethodBeat.i(57858);
    paramCollection = (Iterable)paramCollection;
    if ((!(paramCollection instanceof Collection)) || (!((Collection)paramCollection).isEmpty()))
    {
      paramCollection = paramCollection.iterator();
      if (paramCollection.hasNext())
      {
        am localam = (am)paramCollection.next();
        if (((d.g.b.k.g(paramam, localam) ^ true)) && (localam.fRr() == null) && (b((d.l.b.a.b.b.a)localam, parama)))
        {
          i = 1;
          label91:
          if (i == 0) {
            break label111;
          }
        }
      }
    }
    for (int i = 0;; i = 1)
    {
      if (i == 0) {
        break label118;
      }
      AppMethodBeat.o(57858);
      return paramam;
      i = 0;
      break label91;
      label111:
      break;
    }
    label118:
    paramam = paramam.fRx().fRB().fRD();
    if (paramam == null) {
      d.g.b.k.fOy();
    }
    paramam = (am)paramam;
    AppMethodBeat.o(57858);
    return paramam;
  }
  
  private static am a(am paramam, d.l.b.a.b.f.f paramf)
  {
    AppMethodBeat.i(57847);
    paramam = paramam.fRx();
    paramam.d(paramf);
    paramam.fRy();
    paramam.fRz();
    paramam = paramam.fRD();
    if (paramam == null) {
      d.g.b.k.fOy();
    }
    paramam = (am)paramam;
    AppMethodBeat.o(57847);
    return paramam;
  }
  
  private final void a(d.l.b.a.b.f.f paramf, Collection<? extends am> paramCollection1, Collection<? extends am> paramCollection2, Collection<am> paramCollection, d.g.a.b<? super d.l.b.a.b.f.f, ? extends Collection<? extends am>> paramb)
  {
    AppMethodBeat.i(57856);
    Iterator localIterator = paramCollection2.iterator();
    if (localIterator.hasNext())
    {
      am localam = (am)localIterator.next();
      paramCollection2 = (am)d.l.b.a.b.d.a.t.m((d.l.b.a.b.b.b)localam);
      label51:
      label52:
      label54:
      Object localObject1;
      if (paramCollection2 == null)
      {
        break label149;
        paramCollection2 = null;
        d.l.b.a.b.o.a.c(paramCollection, paramCollection2);
        localObject1 = d.l.b.a.b.d.a.d.e((d.l.b.a.b.b.t)localam);
        if (localObject1 != null) {
          break label201;
        }
        paramCollection2 = null;
      }
      for (;;)
      {
        d.l.b.a.b.o.a.c(paramCollection, paramCollection2);
        d.l.b.a.b.o.a.c(paramCollection, a(localam, paramb));
        break;
        localObject1 = d.l.b.a.b.d.a.t.p((d.l.b.a.b.b.b)paramCollection2);
        if (localObject1 == null) {
          d.g.b.k.fOy();
        }
        localObject1 = d.l.b.a.b.f.f.aWB((String)localObject1);
        d.g.b.k.g(localObject1, "Name.identifier(nameInJava)");
        localObject1 = ((Collection)paramb.ay(localObject1)).iterator();
        label149:
        if (!((Iterator)localObject1).hasNext()) {
          break label52;
        }
        Object localObject2 = a((am)((Iterator)localObject1).next(), paramf);
        if (!a(paramCollection2, (d.l.b.a.b.b.t)localObject2)) {
          break label51;
        }
        paramCollection2 = a((am)localObject2, (d.l.b.a.b.b.a)paramCollection2, paramCollection1);
        break label54;
        label201:
        paramCollection2 = ((d.l.b.a.b.b.t)localObject1).fRf();
        d.g.b.k.g(paramCollection2, "overridden.name");
        localObject2 = ((Iterable)paramb.ay(paramCollection2)).iterator();
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          paramCollection2 = ((Iterator)localObject2).next();
        } while (!b((am)paramCollection2, (d.l.b.a.b.b.t)localObject1));
        for (;;)
        {
          localObject2 = (am)paramCollection2;
          if (localObject2 == null) {
            break label520;
          }
          paramCollection2 = ((am)localObject2).fRx();
          localObject3 = ((d.l.b.a.b.b.t)localObject1).fQU();
          d.g.b.k.g(localObject3, "overridden.valueParameters");
          Object localObject4 = (Iterable)localObject3;
          localObject3 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject4, 10));
          localObject4 = ((Iterable)localObject4).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            d.l.b.a.b.b.av localav = (d.l.b.a.b.b.av)((Iterator)localObject4).next();
            d.g.b.k.g(localav, "it");
            d.l.b.a.b.m.ab localab = localav.fRV();
            d.g.b.k.g(localab, "it.type");
            ((Collection)localObject3).add(new d.l.b.a.b.d.a.b.l(localab, localav.fRX()));
          }
          paramCollection2 = null;
        }
        Object localObject3 = (Collection)localObject3;
        localObject2 = ((am)localObject2).fQU();
        d.g.b.k.g(localObject2, "override.valueParameters");
        paramCollection2.iW(d.l.b.a.b.d.a.b.k.a((Collection)localObject3, (Collection)localObject2, (d.l.b.a.b.b.a)localObject1));
        paramCollection2.fRy();
        paramCollection2.fRz();
        paramCollection2 = (am)paramCollection2.fRD();
        label487:
        if (paramCollection2 != null)
        {
          if (((g)this).d(paramCollection2)) {}
          for (;;)
          {
            if (paramCollection2 == null) {
              break label530;
            }
            paramCollection2 = a(paramCollection2, (d.l.b.a.b.b.a)localObject1, paramCollection1);
            break;
            paramCollection2 = null;
            break label487;
            paramCollection2 = null;
          }
        }
        label520:
        label530:
        paramCollection2 = null;
      }
    }
    AppMethodBeat.o(57856);
  }
  
  private final void a(Collection<am> paramCollection, d.l.b.a.b.f.f paramf, Collection<? extends am> paramCollection1, boolean paramBoolean)
  {
    AppMethodBeat.i(57855);
    paramf = d.l.b.a.b.d.a.a.a.a(paramf, paramCollection1, paramCollection, this.LoC, this.LnD.LnL.Lnk, this.LnD.LnL.Lnx.gcH());
    d.g.b.k.g(paramf, "resolveOverridesForNonSt….overridingUtil\n        )");
    if (!paramBoolean)
    {
      paramCollection.addAll(paramf);
      AppMethodBeat.o(57855);
      return;
    }
    paramCollection1 = d.a.j.b(paramCollection, (Iterable)paramf);
    paramf = (Iterable)paramf;
    Collection localCollection = (Collection)new ArrayList(d.a.j.a(paramf, 10));
    Iterator localIterator = paramf.iterator();
    if (localIterator.hasNext())
    {
      paramf = (am)localIterator.next();
      am localam = (am)d.l.b.a.b.d.a.t.o((d.l.b.a.b.b.b)paramf);
      if (localam == null) {}
      for (;;)
      {
        localCollection.add(paramf);
        break;
        d.g.b.k.g(paramf, "resolvedOverride");
        paramf = a(paramf, (d.l.b.a.b.b.a)localam, (Collection)paramCollection1);
      }
    }
    paramCollection.addAll((Collection)localCollection);
    AppMethodBeat.o(57855);
  }
  
  private final void a(List<d.l.b.a.b.b.av> paramList, d.l.b.a.b.b.k paramk, int paramInt, q paramq, d.l.b.a.b.m.ab paramab1, d.l.b.a.b.m.ab paramab2)
  {
    AppMethodBeat.i(57867);
    d.l.b.a.b.b.a locala = (d.l.b.a.b.b.a)paramk;
    paramk = d.l.b.a.b.b.a.g.LeU;
    d.l.b.a.b.b.a.g localg = d.l.b.a.b.b.a.g.a.fSm();
    d.l.b.a.b.f.f localf = paramq.fRf();
    paramab1 = bc.aE(paramab1);
    d.g.b.k.g(paramab1, "TypeUtils.makeNotNullable(returnType)");
    boolean bool = paramq.fTC();
    if (paramab2 != null) {}
    for (paramk = bc.aE(paramab2);; paramk = null)
    {
      paramList.add(new d.l.b.a.b.b.c.aj(locala, null, paramInt, localg, localf, paramab1, bool, false, false, paramk, (an)this.LnD.LnL.Lno.a((d.l.b.a.b.d.a.e.l)paramq)));
      AppMethodBeat.o(57867);
      return;
    }
  }
  
  private final void a(Set<? extends ah> paramSet, Collection<ah> paramCollection, d.g.a.b<? super d.l.b.a.b.f.f, ? extends Collection<? extends am>> paramb)
  {
    AppMethodBeat.i(57861);
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      d.l.b.a.b.d.a.b.g localg = d((ah)paramSet.next(), paramb);
      if (localg != null)
      {
        paramCollection.add(localg);
        AppMethodBeat.o(57861);
        return;
      }
    }
    AppMethodBeat.o(57861);
  }
  
  private static boolean a(am paramam, d.l.b.a.b.b.t paramt)
  {
    AppMethodBeat.i(57848);
    d.l.b.a.b.d.a.c localc = d.l.b.a.b.d.a.c.LkK;
    if (d.l.b.a.b.d.a.c.c(paramam)) {
      paramt = paramt.fRq();
    }
    for (;;)
    {
      d.g.b.k.g(paramt, "if (superDescriptor.isRe…iginal else subDescriptor");
      boolean bool = b((d.l.b.a.b.b.a)paramt, (d.l.b.a.b.b.a)paramam);
      AppMethodBeat.o(57848);
      return bool;
    }
  }
  
  private static am b(ah paramah, d.g.a.b<? super d.l.b.a.b.f.f, ? extends Collection<? extends am>> paramb)
  {
    AppMethodBeat.i(57852);
    Object localObject1 = d.l.b.a.b.f.f.aWB(o.aWn(paramah.fRf().rf()));
    d.g.b.k.g(localObject1, "Name.identifier(JvmAbi.s…terName(name.asString()))");
    localObject1 = ((Iterable)paramb.ay(localObject1)).iterator();
    label172:
    while (((Iterator)localObject1).hasNext())
    {
      paramb = (am)((Iterator)localObject1).next();
      Object localObject2;
      if (paramb.fQU().size() == 1)
      {
        localObject2 = paramb.fQS();
        if (localObject2 != null) {}
      }
      else
      {
        paramb = null;
      }
      for (;;)
      {
        if (paramb == null) {
          break label172;
        }
        AppMethodBeat.o(57852);
        return paramb;
        if (!d.l.b.a.b.a.g.C((d.l.b.a.b.m.ab)localObject2)) {
          break;
        }
        localObject2 = d.l.b.a.b.m.a.g.LMg;
        Object localObject3 = paramb.fQU();
        d.g.b.k.g(localObject3, "descriptor.valueParameters");
        localObject3 = d.a.j.iS((List)localObject3);
        d.g.b.k.g(localObject3, "descriptor.valueParameters.single()");
        if (!((d.l.b.a.b.m.a.g)localObject2).d(((d.l.b.a.b.b.av)localObject3).fRV(), paramah.fRV())) {
          break;
        }
      }
    }
    AppMethodBeat.o(57852);
    return null;
  }
  
  private static boolean b(d.l.b.a.b.b.a parama1, d.l.b.a.b.b.a parama2)
  {
    AppMethodBeat.i(57849);
    Object localObject = d.l.b.a.b.j.i.LEO.b(parama2, parama1, true);
    d.g.b.k.g(localObject, "OverridingUtil.DEFAULT.i…erDescriptor, this, true)");
    localObject = ((i.a)localObject).gbv();
    d.g.b.k.g(localObject, "OverridingUtil.DEFAULT.i…iptor, this, true).result");
    if (localObject == i.a.a.LFe)
    {
      localObject = m.Llt;
      if (!m.a.a(parama2, parama1))
      {
        AppMethodBeat.o(57849);
        return true;
      }
    }
    AppMethodBeat.o(57849);
    return false;
  }
  
  private static boolean b(am paramam, d.l.b.a.b.b.t paramt)
  {
    AppMethodBeat.i(57866);
    String str = d.l.b.a.b.d.b.t.a((d.l.b.a.b.b.t)paramam, false, false, 2);
    d.l.b.a.b.b.t localt = paramt.fRq();
    d.g.b.k.g(localt, "builtinWithErasedParameters.original");
    if ((d.g.b.k.g(str, d.l.b.a.b.d.b.t.a(localt, false, false, 2))) && (!b((d.l.b.a.b.b.a)paramam, (d.l.b.a.b.b.a)paramt)))
    {
      AppMethodBeat.o(57866);
      return true;
    }
    AppMethodBeat.o(57866);
    return false;
  }
  
  private final boolean c(ah paramah, d.g.a.b<? super d.l.b.a.b.f.f, ? extends Collection<? extends am>> paramb)
  {
    AppMethodBeat.i(57853);
    if (c.e(paramah))
    {
      AppMethodBeat.o(57853);
      return false;
    }
    am localam = a(paramah, paramb);
    paramb = b(paramah, paramb);
    if (localam == null)
    {
      AppMethodBeat.o(57853);
      return false;
    }
    if (!paramah.fSc())
    {
      AppMethodBeat.o(57853);
      return true;
    }
    if ((paramb != null) && (paramb.fPZ() == localam.fPZ()))
    {
      AppMethodBeat.o(57853);
      return true;
    }
    AppMethodBeat.o(57853);
    return false;
  }
  
  private final d.l.b.a.b.d.a.b.g d(ah paramah, d.g.a.b<? super d.l.b.a.b.f.f, ? extends Collection<? extends am>> paramb)
  {
    int j = 1;
    AppMethodBeat.i(57862);
    if (!c(paramah, paramb))
    {
      AppMethodBeat.o(57862);
      return null;
    }
    am localam = a(paramah, paramb);
    if (localam == null) {
      d.g.b.k.fOy();
    }
    int i;
    if (paramah.fSc())
    {
      localObject = b(paramah, paramb);
      paramb = (d.g.a.b<? super d.l.b.a.b.f.f, ? extends Collection<? extends am>>)localObject;
      if (localObject == null)
      {
        d.g.b.k.fOy();
        paramb = (d.g.a.b<? super d.l.b.a.b.f.f, ? extends Collection<? extends am>>)localObject;
      }
      i = j;
      if (paramb != null)
      {
        if (paramb.fPZ() != localam.fPZ()) {
          break label203;
        }
        i = j;
      }
      label98:
      if ((!aa.KTq) || (i != 0)) {
        break label213;
      }
      localObject = new StringBuilder("Different accessors modalities when creating overrides for ").append(paramah).append(" in ").append(this.LoC).append("for getter is ").append(localam.fPZ()).append(", but for setter is ");
      if (paramb == null) {
        break label208;
      }
    }
    label203:
    label208:
    for (paramah = paramb.fPZ();; paramah = null)
    {
      paramah = (Throwable)new AssertionError(paramah);
      AppMethodBeat.o(57862);
      throw paramah;
      paramb = null;
      break;
      i = 0;
      break label98;
    }
    label213:
    Object localObject = new d.l.b.a.b.d.a.b.e(this.LoC, localam, paramb, paramah);
    paramah = localam.fQS();
    if (paramah == null) {
      d.g.b.k.fOy();
    }
    ((d.l.b.a.b.d.a.b.e)localObject).a(paramah, (List)v.KTF, fQQ(), null);
    d.l.b.a.b.b.c.ab localab = d.l.b.a.b.j.b.a((ah)localObject, localam.fQj(), false, localam.fQk());
    localab.Lhr = ((d.l.b.a.b.b.t)localam);
    localab.K(((d.l.b.a.b.d.a.b.e)localObject).fRV());
    d.g.b.k.g(localab, "DescriptorFactory.create…escriptor.type)\n        }");
    if (paramb != null)
    {
      paramah = paramb.fQU();
      d.g.b.k.g(paramah, "setterMethod.valueParameters");
      paramah = (d.l.b.a.b.b.av)d.a.j.iP(paramah);
      if (paramah == null)
      {
        paramah = (Throwable)new AssertionError("No parameter found for ".concat(String.valueOf(paramb)));
        AppMethodBeat.o(57862);
        throw paramah;
      }
      paramah = d.l.b.a.b.j.b.a((ah)localObject, paramb.fQj(), paramah.fQj(), false, paramb.fQb(), paramb.fQk());
      paramah.Lhr = ((d.l.b.a.b.b.t)paramb);
    }
    for (;;)
    {
      ((d.l.b.a.b.d.a.b.e)localObject).a(localab, (d.l.b.a.b.b.aj)paramah);
      paramah = (d.l.b.a.b.d.a.b.g)localObject;
      AppMethodBeat.o(57862);
      return paramah;
      paramah = null;
    }
  }
  
  private final boolean d(final am paramam)
  {
    AppMethodBeat.i(57842);
    Object localObject1 = paramam.fRf();
    d.g.b.k.g(localObject1, "function.name");
    localObject1 = (Iterable)s.i((d.l.b.a.b.f.f)localObject1);
    if ((!(localObject1 instanceof Collection)) || (!((Collection)localObject1).isEmpty()))
    {
      localObject1 = ((Iterable)localObject1).iterator();
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Iterable)m((d.l.b.a.b.f.f)((Iterator)localObject1).next());
        label181:
        label187:
        if ((!(localObject2 instanceof Collection)) || (!((Collection)localObject2).isEmpty()))
        {
          localObject2 = ((Iterable)localObject2).iterator();
          label111:
          if (((Iterator)localObject2).hasNext())
          {
            ah localah = (ah)((Iterator)localObject2).next();
            if ((c(localah, (d.g.a.b)new h(this, paramam))) && ((localah.fSc()) || (!o.aWl(paramam.fRf().rf()))))
            {
              i = 1;
              if (i == 0) {
                break label208;
              }
              i = 1;
              if (i == 0) {
                break label213;
              }
            }
          }
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label220;
      }
      AppMethodBeat.o(57842);
      return false;
      i = 0;
      break label181;
      label208:
      break label111;
      i = 0;
      break label187;
      label213:
      break;
    }
    label220:
    if ((!f(paramam)) && (!e(paramam)) && (!g(paramam)))
    {
      AppMethodBeat.o(57842);
      return true;
    }
    AppMethodBeat.o(57842);
    return false;
  }
  
  private final boolean e(am paramam)
  {
    AppMethodBeat.i(57843);
    Object localObject1 = d.l.b.a.b.d.a.d.LkT;
    localObject1 = paramam.fRf();
    d.g.b.k.g(localObject1, "name");
    if (!d.l.b.a.b.d.a.d.g((d.l.b.a.b.f.f)localObject1))
    {
      AppMethodBeat.o(57843);
      return false;
    }
    localObject1 = paramam.fRf();
    d.g.b.k.g(localObject1, "name");
    Object localObject2 = (Iterable)l((d.l.b.a.b.f.f)localObject1);
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      d.l.b.a.b.b.t localt = d.l.b.a.b.d.a.d.e((d.l.b.a.b.b.t)((Iterator)localObject2).next());
      if (localt != null) {
        ((Collection)localObject1).add(localt);
      }
    }
    localObject1 = (Iterable)localObject1;
    if (!((Collection)localObject1).isEmpty())
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        if (b(paramam, (d.l.b.a.b.b.t)((Iterator)localObject1).next()))
        {
          AppMethodBeat.o(57843);
          return true;
        }
      }
    }
    AppMethodBeat.o(57843);
    return false;
  }
  
  private final boolean f(am paramam)
  {
    AppMethodBeat.i(57844);
    Object localObject1 = d.l.b.a.b.d.a.c.LkK;
    localObject1 = paramam.fRf();
    d.g.b.k.g(localObject1, "name");
    localObject1 = (Iterable)d.l.b.a.b.d.a.c.f((d.l.b.a.b.f.f)localObject1);
    if ((!(localObject1 instanceof Collection)) || (!((Collection)localObject1).isEmpty()))
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (d.l.b.a.b.f.f)((Iterator)localObject1).next();
        Object localObject4 = (Iterable)l((d.l.b.a.b.f.f)localObject2);
        Object localObject3 = (Collection)new ArrayList();
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          Object localObject5 = ((Iterator)localObject4).next();
          if (d.l.b.a.b.d.a.t.n((d.l.b.a.b.b.b)localObject5)) {
            ((Collection)localObject3).add(localObject5);
          }
        }
        localObject3 = (List)localObject3;
        if (!((List)localObject3).isEmpty())
        {
          localObject2 = a(paramam, (d.l.b.a.b.f.f)localObject2);
          localObject3 = (Iterable)localObject3;
          if (!((Collection)localObject3).isEmpty())
          {
            localObject3 = ((Iterable)localObject3).iterator();
            do
            {
              if (!((Iterator)localObject3).hasNext()) {
                break;
              }
            } while (!a((am)((Iterator)localObject3).next(), (d.l.b.a.b.b.t)localObject2));
          }
        }
        for (int i = 1; i != 0; i = 0)
        {
          AppMethodBeat.o(57844);
          return true;
        }
      }
    }
    AppMethodBeat.o(57844);
    return false;
  }
  
  private final Collection<d.l.b.a.b.m.ab> fQp()
  {
    AppMethodBeat.i(57864);
    if (this.LoD)
    {
      localObject = this.LoC.fPW();
      d.g.b.k.g(localObject, "ownerDescriptor.typeConstructor");
      localObject = ((at)localObject).fSt();
      d.g.b.k.g(localObject, "ownerDescriptor.typeConstructor.supertypes");
      AppMethodBeat.o(57864);
      return localObject;
    }
    Object localObject = this.LnD.LnL.Lnx.gcG().D(this.LoC);
    AppMethodBeat.o(57864);
    return localObject;
  }
  
  private final boolean g(am paramam)
  {
    AppMethodBeat.i(57845);
    am localam1 = h(paramam);
    if (localam1 == null)
    {
      AppMethodBeat.o(57845);
      return false;
    }
    paramam = paramam.fRf();
    d.g.b.k.g(paramam, "name");
    paramam = (Iterable)l(paramam);
    if (!((Collection)paramam).isEmpty())
    {
      paramam = paramam.iterator();
      while (paramam.hasNext())
      {
        am localam2 = (am)paramam.next();
        if ((localam2.fRw()) && (b((d.l.b.a.b.b.a)localam1, (d.l.b.a.b.b.a)localam2))) {}
        for (int i = 1; i != 0; i = 0)
        {
          AppMethodBeat.o(57845);
          return true;
        }
      }
    }
    AppMethodBeat.o(57845);
    return false;
  }
  
  private static am h(am paramam)
  {
    AppMethodBeat.i(57846);
    Object localObject1 = paramam.fQU();
    d.g.b.k.g(localObject1, "valueParameters");
    Object localObject2 = (d.l.b.a.b.b.av)d.a.j.iR((List)localObject1);
    if (localObject2 != null)
    {
      localObject1 = ((d.l.b.a.b.b.av)localObject2).fRV().gbz().fQq();
      if (localObject1 == null) {
        break label106;
      }
      localObject1 = d.l.b.a.b.j.d.a.q((d.l.b.a.b.b.l)localObject1);
      if (localObject1 == null) {
        break label106;
      }
      if (!((d.l.b.a.b.f.c)localObject1).fZK()) {
        break label101;
      }
      if (localObject1 == null) {
        break label106;
      }
      localObject1 = ((d.l.b.a.b.f.c)localObject1).fZL();
      label79:
      if (!d.l.b.a.b.a.k.a((d.l.b.a.b.f.b)localObject1, false)) {
        break label111;
      }
    }
    label101:
    label106:
    label111:
    for (localObject1 = localObject2;; localObject1 = null)
    {
      if (localObject1 != null) {
        break label116;
      }
      AppMethodBeat.o(57846);
      return null;
      localObject1 = null;
      break;
      localObject1 = null;
      break label79;
    }
    label116:
    localObject2 = paramam.fRx();
    paramam = paramam.fQU();
    d.g.b.k.g(paramam, "valueParameters");
    paramam = (am)((t.a)localObject2).iW(d.a.j.iU(paramam)).H(((d.l.b.a.b.m.av)((d.l.b.a.b.b.av)localObject1).fRV().gbw().get(0)).fRV()).fRD();
    localObject1 = (ae)paramam;
    if (localObject1 != null) {
      ((d.l.b.a.b.b.c.p)localObject1).Lhk = true;
    }
    AppMethodBeat.o(57846);
    return paramam;
  }
  
  private final Set<am> l(d.l.b.a.b.f.f paramf)
  {
    AppMethodBeat.i(57859);
    Object localObject = (Iterable)fQp();
    Collection localCollection = (Collection)new LinkedHashSet();
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      d.a.j.a(localCollection, (Iterable)((d.l.b.a.b.m.ab)((Iterator)localObject).next()).fQN().b(paramf, (d.l.b.a.b.c.a.a)d.l.b.a.b.c.a.c.Lkg));
    }
    paramf = (Set)localCollection;
    AppMethodBeat.o(57859);
    return paramf;
  }
  
  private final Set<ah> m(d.l.b.a.b.f.f paramf)
  {
    AppMethodBeat.i(57863);
    Object localObject1 = (Iterable)fQp();
    Collection localCollection1 = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Iterable)((d.l.b.a.b.m.ab)((Iterator)localObject1).next()).fQN().a(paramf, (d.l.b.a.b.c.a.a)d.l.b.a.b.c.a.c.Lkg);
      Collection localCollection2 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        localCollection2.add((ah)((Iterator)localObject2).next());
      }
      d.a.j.a(localCollection1, (Iterable)localCollection2);
    }
    paramf = d.a.j.n((Iterable)localCollection1);
    AppMethodBeat.o(57863);
    return paramf;
  }
  
  protected final k.a a(q paramq, List<? extends as> paramList, d.l.b.a.b.m.ab paramab, List<? extends d.l.b.a.b.b.av> paramList1)
  {
    AppMethodBeat.i(57865);
    d.g.b.k.h(paramq, "method");
    d.g.b.k.h(paramList, "methodTypeParameters");
    d.g.b.k.h(paramab, "returnType");
    d.g.b.k.h(paramList1, "valueParameters");
    Object localObject = this.LnD.LnL.Lnj.a(paramq, this.LoC, paramab, paramList1, paramList);
    d.g.b.k.g(localObject, "c.components.signaturePr…dTypeParameters\n        )");
    paramq = ((d.l.b.a.b.d.a.a.k.a)localObject).Liw;
    if (paramq == null) {
      d.l.b.a.b.d.a.a.k.a.agL(4);
    }
    d.g.b.k.g(paramq, "propagated.returnType");
    paramList = ((d.l.b.a.b.d.a.a.k.a)localObject).LmH;
    paramab = ((d.l.b.a.b.d.a.a.k.a)localObject).LmI;
    if (paramab == null) {
      d.l.b.a.b.d.a.a.k.a.agL(5);
    }
    d.g.b.k.g(paramab, "propagated.valueParameters");
    paramList1 = ((d.l.b.a.b.d.a.a.k.a)localObject).LdP;
    if (paramList1 == null) {
      d.l.b.a.b.d.a.a.k.a.agL(6);
    }
    d.g.b.k.g(paramList1, "propagated.typeParameters");
    boolean bool = ((d.l.b.a.b.d.a.a.k.a)localObject).Lhl;
    localObject = ((d.l.b.a.b.d.a.a.k.a)localObject).LmJ;
    if (localObject == null) {
      d.l.b.a.b.d.a.a.k.a.agL(7);
    }
    d.g.b.k.g(localObject, "propagated.errors");
    paramq = new k.a(paramq, paramList, paramab, paramList1, bool, (List)localObject);
    AppMethodBeat.o(57865);
    return paramq;
  }
  
  public final Collection<ah> a(d.l.b.a.b.f.f paramf, d.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(57871);
    d.g.b.k.h(paramf, "name");
    d.g.b.k.h(parama, "location");
    d(paramf, parama);
    paramf = super.a(paramf, parama);
    AppMethodBeat.o(57871);
    return paramf;
  }
  
  protected final Set<d.l.b.a.b.f.f> a(d.l.b.a.b.j.f.d paramd)
  {
    AppMethodBeat.i(57873);
    d.g.b.k.h(paramd, "kindFilter");
    if (this.LnZ.fTl())
    {
      paramd = fSy();
      AppMethodBeat.o(57873);
      return paramd;
    }
    paramd = new LinkedHashSet((Collection)((b)this.LoV.invoke()).fUi());
    Object localObject = this.LoC.fPW();
    d.g.b.k.g(localObject, "ownerDescriptor.typeConstructor");
    localObject = ((at)localObject).fSt();
    d.g.b.k.g(localObject, "ownerDescriptor.typeConstructor.supertypes");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Iterable localIterable = (Iterable)((d.l.b.a.b.m.ab)((Iterator)localObject).next()).fQN().fSz();
      d.a.j.a((Collection)paramd, localIterable);
    }
    paramd = (Set)paramd;
    AppMethodBeat.o(57873);
    return paramd;
  }
  
  protected final void a(Collection<am> paramCollection, d.l.b.a.b.f.f paramf)
  {
    AppMethodBeat.i(57854);
    d.g.b.k.h(paramCollection, "result");
    d.g.b.k.h(paramf, "name");
    Object localObject1 = l(paramf);
    Object localObject2 = d.l.b.a.b.d.a.c.LkK;
    if (!d.l.b.a.b.d.a.c.e(paramf))
    {
      localObject2 = d.l.b.a.b.d.a.d.LkT;
      if (!d.l.b.a.b.d.a.d.g(paramf))
      {
        localObject2 = (Iterable)localObject1;
        int i;
        if (!((Collection)localObject2).isEmpty())
        {
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            if (((d.l.b.a.b.b.t)((Iterator)localObject2).next()).fRw()) {
              i = 0;
            }
          }
        }
        while (i != 0)
        {
          localObject2 = (Iterable)localObject1;
          localObject1 = (Collection)new ArrayList();
          localObject2 = ((Iterable)localObject2).iterator();
          for (;;)
          {
            if (((Iterator)localObject2).hasNext())
            {
              localObject3 = ((Iterator)localObject2).next();
              if (d((am)localObject3))
              {
                ((Collection)localObject1).add(localObject3);
                continue;
                i = 1;
                break;
              }
            }
          }
          a(paramCollection, paramf, (Collection)localObject1, false);
          AppMethodBeat.o(57854);
          return;
        }
      }
    }
    localObject2 = d.l.b.a.b.o.i.LPk;
    localObject2 = i.b.gcT();
    Object localObject3 = d.l.b.a.b.d.a.a.a.a(paramf, (Collection)localObject1, (Collection)v.KTF, this.LoC, r.LIg, this.LnD.LnL.Lnx.gcH());
    d.g.b.k.g(localObject3, "resolveOverridesForNonSt….overridingUtil\n        )");
    a(paramf, paramCollection, (Collection)localObject3, paramCollection, (d.g.a.b)new b((g)this));
    a(paramf, paramCollection, (Collection)localObject3, (Collection)localObject2, (d.g.a.b)new c((g)this));
    localObject3 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList();
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      Object localObject4 = ((Iterator)localObject3).next();
      if (d((am)localObject4)) {
        ((Collection)localObject1).add(localObject4);
      }
    }
    a(paramCollection, paramf, (Collection)d.a.j.b((Collection)localObject1, (Iterable)localObject2), true);
    AppMethodBeat.o(57854);
  }
  
  protected final boolean a(d.l.b.a.b.d.a.b.f paramf)
  {
    AppMethodBeat.i(57841);
    d.g.b.k.h(paramf, "$this$isVisibleAsFunction");
    if (this.LnZ.fTl())
    {
      AppMethodBeat.o(57841);
      return false;
    }
    boolean bool = d((am)paramf);
    AppMethodBeat.o(57841);
    return bool;
  }
  
  public final Collection<am> b(d.l.b.a.b.f.f paramf, d.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(57870);
    d.g.b.k.h(paramf, "name");
    d.g.b.k.h(parama, "location");
    d(paramf, parama);
    paramf = super.b(paramf, parama);
    AppMethodBeat.o(57870);
    return paramf;
  }
  
  protected final void b(d.l.b.a.b.f.f paramf, Collection<ah> paramCollection)
  {
    AppMethodBeat.i(57860);
    d.g.b.k.h(paramf, "name");
    d.g.b.k.h(paramCollection, "result");
    Object localObject1;
    if (this.LnZ.fTl())
    {
      localObject1 = (q)d.a.j.g((Iterable)((b)this.LoV.invoke()).j(paramf));
      if (localObject1 != null) {
        break label86;
      }
    }
    for (;;)
    {
      localObject1 = m(paramf);
      if (!((Set)localObject1).isEmpty()) {
        break;
      }
      AppMethodBeat.o(57860);
      return;
      label86:
      localObject2 = w.LdG;
      Object localObject3 = d.l.b.a.b.d.a.c.f.a(this.LnD, (d.l.b.a.b.d.a.e.d)localObject1);
      localObject2 = d.l.b.a.b.d.a.b.g.a((d.l.b.a.b.b.l)this.LoC, (d.l.b.a.b.b.a.g)localObject3, (w)localObject2, ((q)localObject1).fQb(), false, ((q)localObject1).fRf(), (an)this.LnD.LnL.Lno.a((d.l.b.a.b.d.a.e.l)localObject1), false);
      d.g.b.k.g(localObject2, "JavaPropertyDescriptor.c…inal = */ false\n        )");
      localObject3 = (ah)localObject2;
      d.l.b.a.b.b.a.g.a locala = d.l.b.a.b.b.a.g.LeU;
      localObject3 = d.l.b.a.b.j.b.a((ah)localObject3, d.l.b.a.b.b.a.g.a.fSm());
      d.g.b.k.g(localObject3, "DescriptorFactory.create…iptor, Annotations.EMPTY)");
      ((d.l.b.a.b.d.a.b.g)localObject2).a((d.l.b.a.b.b.c.ab)localObject3, null);
      localObject1 = a((q)localObject1, d.l.b.a.b.d.a.c.a.a(this.LnD, (d.l.b.a.b.b.l)localObject2, (x)localObject1, 0));
      ((d.l.b.a.b.d.a.b.g)localObject2).a((d.l.b.a.b.m.ab)localObject1, (List)v.KTF, fQQ(), null);
      ((d.l.b.a.b.b.c.ab)localObject3).K((d.l.b.a.b.m.ab)localObject1);
      paramCollection.add(localObject2);
    }
    Object localObject2 = d.l.b.a.b.o.i.LPk;
    localObject2 = i.b.gcT();
    a((Set)localObject1, paramCollection, (d.g.a.b)new d(this));
    a((Set)localObject1, (Collection)localObject2, (d.g.a.b)new e(this));
    paramf = d.l.b.a.b.d.a.a.a.a(paramf, (Collection)d.a.ak.a((Set)localObject1, (Iterable)localObject2), paramCollection, this.LoC, this.LnD.LnL.Lnk, this.LnD.LnL.Lnx.gcH());
    d.g.b.k.g(paramf, "resolveOverridesForNonSt…rridingUtil\n            )");
    paramCollection.addAll(paramf);
    AppMethodBeat.o(57860);
  }
  
  public final d.l.b.a.b.b.h c(d.l.b.a.b.f.f paramf, d.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(57869);
    d.g.b.k.h(paramf, "name");
    d.g.b.k.h(parama, "location");
    d(paramf, parama);
    parama = (g)this.Lpb;
    if (parama != null)
    {
      parama = parama.LoB;
      if (parama != null)
      {
        parama = (d.l.b.a.b.b.c.g)parama.ay(paramf);
        if (parama != null)
        {
          paramf = (d.l.b.a.b.b.h)parama;
          AppMethodBeat.o(57869);
          return paramf;
        }
      }
    }
    paramf = (d.l.b.a.b.b.h)this.LoB.ay(paramf);
    AppMethodBeat.o(57869);
    return paramf;
  }
  
  protected final Set<d.l.b.a.b.f.f> c(d.l.b.a.b.j.f.d paramd, d.g.a.b<? super d.l.b.a.b.f.f, Boolean> paramb)
  {
    AppMethodBeat.i(57872);
    d.g.b.k.h(paramd, "kindFilter");
    paramd = d.a.ak.a((Set)this.Loz.invoke(), (Iterable)((Map)this.LoA.invoke()).keySet());
    AppMethodBeat.o(57872);
    return paramd;
  }
  
  public final void d(d.l.b.a.b.f.f paramf, d.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(57874);
    d.g.b.k.h(paramf, "name");
    d.g.b.k.h(parama, "location");
    d.l.b.a.b.c.a.a(this.LnD.LnL.Lnr, parama, this.LoC, paramf);
    AppMethodBeat.o(57874);
  }
  
  protected final d.l.b.a.b.b.ak fQQ()
  {
    AppMethodBeat.i(57868);
    d.l.b.a.b.b.ak localak = d.l.b.a.b.j.c.l((d.l.b.a.b.b.l)this.LoC);
    AppMethodBeat.o(57868);
    return localak;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57875);
    String str = "Lazy Java member scope for " + this.LnZ.fRH();
    AppMethodBeat.o(57875);
    return str;
  }
  
  static final class a
    extends d.g.b.l
    implements d.g.a.b<d.l.b.a.b.d.a.e.p, Boolean>
  {
    public static final a LoE;
    
    static
    {
      AppMethodBeat.i(57826);
      LoE = new a();
      AppMethodBeat.o(57826);
    }
    
    a()
    {
      super();
    }
  }
  
  static final class d
    extends d.g.b.l
    implements d.g.a.b<d.l.b.a.b.f.f, Collection<? extends am>>
  {
    d(g paramg)
    {
      super();
    }
  }
  
  static final class e
    extends d.g.b.l
    implements d.g.a.b<d.l.b.a.b.f.f, Collection<? extends am>>
  {
    e(g paramg)
    {
      super();
    }
  }
  
  static final class f
    extends d.g.b.l
    implements d.g.a.a<List<? extends d.l.b.a.b.b.d>>
  {
    f(g paramg, d.l.b.a.b.d.a.c.h paramh)
    {
      super();
    }
  }
  
  static final class g
    extends d.g.b.l
    implements d.g.a.a<Map<d.l.b.a.b.f.f, ? extends d.l.b.a.b.d.a.e.n>>
  {
    g(g paramg)
    {
      super();
    }
  }
  
  static final class h
    extends d.g.b.l
    implements d.g.a.b<d.l.b.a.b.f.f, Collection<? extends am>>
  {
    h(g paramg, am paramam)
    {
      super();
    }
  }
  
  static final class i
    extends d.g.b.l
    implements d.g.a.a<Set<? extends d.l.b.a.b.f.f>>
  {
    i(g paramg)
    {
      super();
    }
  }
  
  static final class j
    extends d.g.b.l
    implements d.g.a.b<d.l.b.a.b.f.f, d.l.b.a.b.b.c.g>
  {
    j(g paramg, d.l.b.a.b.d.a.c.h paramh)
    {
      super();
    }
    
    static final class a
      extends d.g.b.l
      implements d.g.a.a<Set<? extends d.l.b.a.b.f.f>>
    {
      a(g.j paramj)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.a.c.a.g
 * JD-Core Version:    0.7.0.1
 */