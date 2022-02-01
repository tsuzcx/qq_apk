package kotlin.l.b.a.b.d.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a.v;
import kotlin.g.a.b<-Lkotlin.l.b.a.b.f.f;+Ljava.util.Collection<+Lkotlin.l.b.a.b.b.am;>;>;
import kotlin.l.b.a.b.b.a.g.a;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.ai;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.c.ae;
import kotlin.l.b.a.b.b.t.a;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.d.a.e.x;
import kotlin.l.b.a.b.d.a.m;
import kotlin.l.b.a.b.d.a.m.a;
import kotlin.l.b.a.b.d.a.o;
import kotlin.l.b.a.b.d.a.s;
import kotlin.l.b.a.b.j.i.a;
import kotlin.l.b.a.b.j.i.a.a;
import kotlin.l.b.a.b.k.a.r;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.bc;
import kotlin.l.b.a.b.o.i.b;
import kotlin.z;

public final class g
  extends k
{
  private final kotlin.l.b.a.b.d.a.e.g aaUC;
  final kotlin.l.b.a.b.l.f<List<kotlin.l.b.a.b.b.d>> aaVb;
  private final kotlin.l.b.a.b.l.f<Set<kotlin.l.b.a.b.f.f>> aaVc;
  private final kotlin.l.b.a.b.l.f<Map<kotlin.l.b.a.b.f.f, kotlin.l.b.a.b.d.a.e.n>> aaVd;
  private final kotlin.l.b.a.b.l.d<kotlin.l.b.a.b.f.f, kotlin.l.b.a.b.b.c.g> aaVe;
  final kotlin.l.b.a.b.b.e aaVf;
  private final boolean aaVg;
  
  public g(final kotlin.l.b.a.b.d.a.c.h paramh, kotlin.l.b.a.b.b.e parame, kotlin.l.b.a.b.d.a.e.g paramg, boolean paramBoolean, g paramg1)
  {
    super(paramh, (k)paramg1);
    AppMethodBeat.i(57876);
    this.aaVf = parame;
    this.aaUC = paramg;
    this.aaVg = paramBoolean;
    this.aaVb = paramh.aaUp.aaFH.av((kotlin.g.a.a)new f(this, paramh));
    this.aaVc = paramh.aaUp.aaFH.av((kotlin.g.a.a)new i(this));
    this.aaVd = paramh.aaUp.aaFH.av((kotlin.g.a.a)new g(this));
    this.aaVe = paramh.aaUp.aaFH.al((kotlin.g.a.b)new j(this, paramh));
    AppMethodBeat.o(57876);
  }
  
  private static am a(ah paramah, String paramString, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, ? extends Collection<? extends am>> paramb)
  {
    AppMethodBeat.i(57851);
    paramString = kotlin.l.b.a.b.f.f.bHb(paramString);
    kotlin.g.b.p.j(paramString, "Name.identifier(getterName)");
    paramb = ((Iterable)paramb.invoke(paramString)).iterator();
    label119:
    label122:
    while (paramb.hasNext())
    {
      paramString = (am)paramb.next();
      kotlin.l.b.a.b.m.a.g localg;
      kotlin.l.b.a.b.m.ab localab;
      boolean bool;
      if (paramString.iEJ().size() == 0)
      {
        localg = kotlin.l.b.a.b.m.a.g.abrB;
        localab = paramString.iEH();
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
        bool = localg.c(localab, paramah.iFN());
        break;
        paramString = null;
      }
    }
    AppMethodBeat.o(57851);
    return null;
  }
  
  private final am a(ah paramah, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, ? extends Collection<? extends am>> paramb)
  {
    AppMethodBeat.i(57850);
    Object localObject1 = paramah.iFC();
    if (localObject1 != null)
    {
      localObject1 = (ai)kotlin.l.b.a.b.d.a.t.m((kotlin.l.b.a.b.b.b)localObject1);
      if (localObject1 == null) {
        break label84;
      }
      localObject2 = kotlin.l.b.a.b.d.a.e.aaRP;
    }
    label84:
    for (Object localObject2 = kotlin.l.b.a.b.d.a.e.l((kotlin.l.b.a.b.b.b)localObject1);; localObject2 = null)
    {
      if ((localObject2 == null) || (kotlin.l.b.a.b.d.a.t.a(this.aaVf, (kotlin.l.b.a.b.b.a)localObject1))) {
        break label90;
      }
      paramah = a(paramah, (String)localObject2, paramb);
      AppMethodBeat.o(57850);
      return paramah;
      localObject1 = null;
      break;
    }
    label90:
    localObject1 = o.bGM(paramah.iEU().qu());
    kotlin.g.b.p.j(localObject1, "JvmAbi.getterName(name.asString())");
    paramah = a(paramah, (String)localObject1, paramb);
    AppMethodBeat.o(57850);
    return paramah;
  }
  
  private final am a(am paramam, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, ? extends Collection<? extends am>> paramb)
  {
    AppMethodBeat.i(57857);
    if (!paramam.iFn())
    {
      AppMethodBeat.o(57857);
      return null;
    }
    Object localObject = paramam.iEU();
    kotlin.g.b.p.j(localObject, "descriptor.name");
    localObject = ((Iterable)paramb.invoke(localObject)).iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramb = h((am)((Iterator)localObject).next());
      if (paramb != null) {
        if (!b((kotlin.l.b.a.b.b.a)paramb, (kotlin.l.b.a.b.b.a)paramam)) {}
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
  
  private static am a(am paramam, kotlin.l.b.a.b.b.a parama, Collection<? extends am> paramCollection)
  {
    AppMethodBeat.i(57858);
    paramCollection = (Iterable)paramCollection;
    if ((!(paramCollection instanceof Collection)) || (!((Collection)paramCollection).isEmpty()))
    {
      paramCollection = paramCollection.iterator();
      if (paramCollection.hasNext())
      {
        am localam = (am)paramCollection.next();
        if (((kotlin.g.b.p.h(paramam, localam) ^ true)) && (localam.iFi() == null) && (b((kotlin.l.b.a.b.b.a)localam, parama)))
        {
          i = 1;
          label92:
          if (i == 0) {
            break label113;
          }
        }
      }
    }
    for (int i = 0;; i = 1)
    {
      if (i == 0) {
        break label120;
      }
      AppMethodBeat.o(57858);
      return paramam;
      i = 0;
      break label92;
      label113:
      break;
    }
    label120:
    paramam = paramam.iFo().iFs().iFu();
    if (paramam == null) {
      kotlin.g.b.p.iCn();
    }
    paramam = (am)paramam;
    AppMethodBeat.o(57858);
    return paramam;
  }
  
  private static am a(am paramam, kotlin.l.b.a.b.f.f paramf)
  {
    AppMethodBeat.i(57847);
    paramam = paramam.iFo();
    paramam.d(paramf);
    paramam.iFp();
    paramam.iFq();
    paramam = paramam.iFu();
    if (paramam == null) {
      kotlin.g.b.p.iCn();
    }
    paramam = (am)paramam;
    AppMethodBeat.o(57847);
    return paramam;
  }
  
  private final void a(Collection<am> paramCollection, kotlin.l.b.a.b.f.f paramf, Collection<? extends am> paramCollection1, boolean paramBoolean)
  {
    AppMethodBeat.i(57855);
    paramf = kotlin.l.b.a.b.d.a.a.a.a(paramf, paramCollection1, paramCollection, this.aaVf, this.aaUh.aaUp.aaTO, this.aaUh.aaUp.aaUb.iQf());
    kotlin.g.b.p.j(paramf, "resolveOverridesForNonSt….overridingUtil\n        )");
    if (!paramBoolean)
    {
      paramCollection.addAll(paramf);
      AppMethodBeat.o(57855);
      return;
    }
    paramCollection1 = kotlin.a.j.b(paramCollection, (Iterable)paramf);
    paramf = (Iterable)paramf;
    Collection localCollection = (Collection)new ArrayList(kotlin.a.j.a(paramf, 10));
    Iterator localIterator = paramf.iterator();
    if (localIterator.hasNext())
    {
      paramf = (am)localIterator.next();
      am localam = (am)kotlin.l.b.a.b.d.a.t.o((kotlin.l.b.a.b.b.b)paramf);
      if (localam == null) {}
      for (;;)
      {
        localCollection.add(paramf);
        break;
        kotlin.g.b.p.j(paramf, "resolvedOverride");
        paramf = a(paramf, (kotlin.l.b.a.b.b.a)localam, (Collection)paramCollection1);
      }
    }
    paramCollection.addAll((Collection)localCollection);
    AppMethodBeat.o(57855);
  }
  
  private final void a(List<kotlin.l.b.a.b.b.av> paramList, kotlin.l.b.a.b.b.k paramk, int paramInt, kotlin.l.b.a.b.d.a.e.q paramq, kotlin.l.b.a.b.m.ab paramab1, kotlin.l.b.a.b.m.ab paramab2)
  {
    AppMethodBeat.i(57867);
    kotlin.l.b.a.b.b.a locala = (kotlin.l.b.a.b.b.a)paramk;
    paramk = kotlin.l.b.a.b.b.a.g.aaLw;
    kotlin.l.b.a.b.b.a.g localg = g.a.iGe();
    kotlin.l.b.a.b.f.f localf = paramq.iEU();
    paramab1 = bc.aD(paramab1);
    kotlin.g.b.p.j(paramab1, "TypeUtils.makeNotNullable(returnType)");
    boolean bool = paramq.iHz();
    if (paramab2 != null) {}
    for (paramk = bc.aD(paramab2);; paramk = null)
    {
      paramList.add(new kotlin.l.b.a.b.b.c.aj(locala, null, paramInt, localg, localf, paramab1, bool, false, false, paramk, (an)this.aaUh.aaUp.aaTS.a((kotlin.l.b.a.b.d.a.e.l)paramq)));
      AppMethodBeat.o(57867);
      return;
    }
  }
  
  private final void a(Set<? extends ah> paramSet, Collection<ah> paramCollection, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, ? extends Collection<? extends am>> paramb)
  {
    AppMethodBeat.i(57861);
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      kotlin.l.b.a.b.d.a.b.g localg = d((ah)paramSet.next(), paramb);
      if (localg != null)
      {
        paramCollection.add(localg);
        AppMethodBeat.o(57861);
        return;
      }
    }
    AppMethodBeat.o(57861);
  }
  
  private final void a(kotlin.l.b.a.b.f.f paramf, Collection<? extends am> paramCollection1, Collection<? extends am> paramCollection2, Collection<am> paramCollection, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, ? extends Collection<? extends am>> paramb)
  {
    AppMethodBeat.i(57856);
    Iterator localIterator = paramCollection2.iterator();
    if (localIterator.hasNext())
    {
      am localam = (am)localIterator.next();
      paramCollection2 = (am)kotlin.l.b.a.b.d.a.t.m((kotlin.l.b.a.b.b.b)localam);
      label51:
      label52:
      label54:
      Object localObject1;
      if (paramCollection2 == null)
      {
        break label150;
        paramCollection2 = null;
        kotlin.l.b.a.b.o.a.c(paramCollection, paramCollection2);
        localObject1 = kotlin.l.b.a.b.d.a.d.e((kotlin.l.b.a.b.b.t)localam);
        if (localObject1 != null) {
          break label202;
        }
        paramCollection2 = null;
      }
      for (;;)
      {
        kotlin.l.b.a.b.o.a.c(paramCollection, paramCollection2);
        kotlin.l.b.a.b.o.a.c(paramCollection, a(localam, paramb));
        break;
        localObject1 = kotlin.l.b.a.b.d.a.t.p((kotlin.l.b.a.b.b.b)paramCollection2);
        if (localObject1 == null) {
          kotlin.g.b.p.iCn();
        }
        localObject1 = kotlin.l.b.a.b.f.f.bHb((String)localObject1);
        kotlin.g.b.p.j(localObject1, "Name.identifier(nameInJava)");
        localObject1 = ((Collection)paramb.invoke(localObject1)).iterator();
        label150:
        if (!((Iterator)localObject1).hasNext()) {
          break label52;
        }
        Object localObject2 = a((am)((Iterator)localObject1).next(), paramf);
        if (!a(paramCollection2, (kotlin.l.b.a.b.b.t)localObject2)) {
          break label51;
        }
        paramCollection2 = a((am)localObject2, (kotlin.l.b.a.b.b.a)paramCollection2, paramCollection1);
        break label54;
        label202:
        paramCollection2 = ((kotlin.l.b.a.b.b.t)localObject1).iEU();
        kotlin.g.b.p.j(paramCollection2, "overridden.name");
        localObject2 = ((Iterable)paramb.invoke(paramCollection2)).iterator();
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          paramCollection2 = ((Iterator)localObject2).next();
        } while (!b((am)paramCollection2, (kotlin.l.b.a.b.b.t)localObject1));
        for (;;)
        {
          localObject2 = (am)paramCollection2;
          if (localObject2 == null) {
            break label521;
          }
          paramCollection2 = ((am)localObject2).iFo();
          localObject3 = ((kotlin.l.b.a.b.b.t)localObject1).iEJ();
          kotlin.g.b.p.j(localObject3, "overridden.valueParameters");
          Object localObject4 = (Iterable)localObject3;
          localObject3 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject4, 10));
          localObject4 = ((Iterable)localObject4).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            kotlin.l.b.a.b.b.av localav = (kotlin.l.b.a.b.b.av)((Iterator)localObject4).next();
            kotlin.g.b.p.j(localav, "it");
            kotlin.l.b.a.b.m.ab localab = localav.iFN();
            kotlin.g.b.p.j(localab, "it.type");
            ((Collection)localObject3).add(new kotlin.l.b.a.b.d.a.b.l(localab, localav.iFP()));
          }
          paramCollection2 = null;
        }
        Object localObject3 = (Collection)localObject3;
        localObject2 = ((am)localObject2).iEJ();
        kotlin.g.b.p.j(localObject2, "override.valueParameters");
        paramCollection2.lv(kotlin.l.b.a.b.d.a.b.k.a((Collection)localObject3, (Collection)localObject2, (kotlin.l.b.a.b.b.a)localObject1));
        paramCollection2.iFp();
        paramCollection2.iFq();
        paramCollection2 = (am)paramCollection2.iFu();
        label488:
        if (paramCollection2 != null)
        {
          if (((g)this).d(paramCollection2)) {}
          for (;;)
          {
            if (paramCollection2 == null) {
              break label531;
            }
            paramCollection2 = a(paramCollection2, (kotlin.l.b.a.b.b.a)localObject1, paramCollection1);
            break;
            paramCollection2 = null;
            break label488;
            paramCollection2 = null;
          }
        }
        label521:
        label531:
        paramCollection2 = null;
      }
    }
    AppMethodBeat.o(57856);
  }
  
  private static boolean a(am paramam, kotlin.l.b.a.b.b.t paramt)
  {
    AppMethodBeat.i(57848);
    kotlin.l.b.a.b.d.a.c localc = kotlin.l.b.a.b.d.a.c.aaRo;
    if (kotlin.l.b.a.b.d.a.c.c(paramam)) {
      paramt = paramt.iFh();
    }
    for (;;)
    {
      kotlin.g.b.p.j(paramt, "if (superDescriptor.isRe…iginal else subDescriptor");
      boolean bool = b((kotlin.l.b.a.b.b.a)paramt, (kotlin.l.b.a.b.b.a)paramam);
      AppMethodBeat.o(57848);
      return bool;
    }
  }
  
  private static am b(ah paramah, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, ? extends Collection<? extends am>> paramb)
  {
    AppMethodBeat.i(57852);
    Object localObject1 = kotlin.l.b.a.b.f.f.bHb(o.bGN(paramah.iEU().qu()));
    kotlin.g.b.p.j(localObject1, "Name.identifier(JvmAbi.s…terName(name.asString()))");
    localObject1 = ((Iterable)paramb.invoke(localObject1)).iterator();
    label172:
    while (((Iterator)localObject1).hasNext())
    {
      paramb = (am)((Iterator)localObject1).next();
      Object localObject2;
      if (paramb.iEJ().size() == 1)
      {
        localObject2 = paramb.iEH();
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
        if (!kotlin.l.b.a.b.a.g.C((kotlin.l.b.a.b.m.ab)localObject2)) {
          break;
        }
        localObject2 = kotlin.l.b.a.b.m.a.g.abrB;
        Object localObject3 = paramb.iEJ();
        kotlin.g.b.p.j(localObject3, "descriptor.valueParameters");
        localObject3 = kotlin.a.j.ls((List)localObject3);
        kotlin.g.b.p.j(localObject3, "descriptor.valueParameters.single()");
        if (!((kotlin.l.b.a.b.m.a.g)localObject2).d(((kotlin.l.b.a.b.b.av)localObject3).iFN(), paramah.iFN())) {
          break;
        }
      }
    }
    AppMethodBeat.o(57852);
    return null;
  }
  
  private static boolean b(kotlin.l.b.a.b.b.a parama1, kotlin.l.b.a.b.b.a parama2)
  {
    AppMethodBeat.i(57849);
    Object localObject = kotlin.l.b.a.b.j.i.abkt.b(parama2, parama1, true);
    kotlin.g.b.p.j(localObject, "OverridingUtil.DEFAULT.i…erDescriptor, this, true)");
    localObject = ((i.a)localObject).iOQ();
    kotlin.g.b.p.j(localObject, "OverridingUtil.DEFAULT.i…iptor, this, true).result");
    if (localObject == i.a.a.abkI)
    {
      localObject = m.aaRX;
      if (!m.a.a(parama2, parama1))
      {
        AppMethodBeat.o(57849);
        return true;
      }
    }
    AppMethodBeat.o(57849);
    return false;
  }
  
  private static boolean b(am paramam, kotlin.l.b.a.b.b.t paramt)
  {
    AppMethodBeat.i(57866);
    String str = kotlin.l.b.a.b.d.b.t.a((kotlin.l.b.a.b.b.t)paramam, false, false, 2);
    kotlin.l.b.a.b.b.t localt = paramt.iFh();
    kotlin.g.b.p.j(localt, "builtinWithErasedParameters.original");
    if ((kotlin.g.b.p.h(str, kotlin.l.b.a.b.d.b.t.a(localt, false, false, 2))) && (!b((kotlin.l.b.a.b.b.a)paramam, (kotlin.l.b.a.b.b.a)paramt)))
    {
      AppMethodBeat.o(57866);
      return true;
    }
    AppMethodBeat.o(57866);
    return false;
  }
  
  private final boolean c(ah paramah, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, ? extends Collection<? extends am>> paramb)
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
    if (!paramah.iFU())
    {
      AppMethodBeat.o(57853);
      return true;
    }
    if ((paramb != null) && (paramb.iDO() == localam.iDO()))
    {
      AppMethodBeat.o(57853);
      return true;
    }
    AppMethodBeat.o(57853);
    return false;
  }
  
  private final kotlin.l.b.a.b.d.a.b.g d(ah paramah, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, ? extends Collection<? extends am>> paramb)
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
      kotlin.g.b.p.iCn();
    }
    int i;
    if (paramah.iFU())
    {
      localObject = b(paramah, paramb);
      paramb = (kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, ? extends Collection<? extends am>>)localObject;
      if (localObject == null)
      {
        kotlin.g.b.p.iCn();
        paramb = (kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, ? extends Collection<? extends am>>)localObject;
      }
      i = j;
      if (paramb != null)
      {
        if (paramb.iDO() != localam.iDO()) {
          break label203;
        }
        i = j;
      }
      label98:
      if ((!z.aazO) || (i != 0)) {
        break label213;
      }
      localObject = new StringBuilder("Different accessors modalities when creating overrides for ").append(paramah).append(" in ").append(this.aaVf).append("for getter is ").append(localam.iDO()).append(", but for setter is ");
      if (paramb == null) {
        break label208;
      }
    }
    label203:
    label208:
    for (paramah = paramb.iDO();; paramah = null)
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
    Object localObject = new kotlin.l.b.a.b.d.a.b.e(this.aaVf, localam, paramb, paramah);
    paramah = localam.iEH();
    if (paramah == null) {
      kotlin.g.b.p.iCn();
    }
    ((kotlin.l.b.a.b.d.a.b.e)localObject).a(paramah, (List)v.aaAd, iEF(), null);
    kotlin.l.b.a.b.b.c.ab localab = kotlin.l.b.a.b.j.b.a((ah)localObject, localam.iDY(), false, localam.iDZ());
    localab.aaNV = ((kotlin.l.b.a.b.b.t)localam);
    localab.J(((kotlin.l.b.a.b.d.a.b.e)localObject).iFN());
    kotlin.g.b.p.j(localab, "DescriptorFactory.create…escriptor.type)\n        }");
    if (paramb != null)
    {
      paramah = paramb.iEJ();
      kotlin.g.b.p.j(paramah, "setterMethod.valueParameters");
      paramah = (kotlin.l.b.a.b.b.av)kotlin.a.j.lp(paramah);
      if (paramah == null)
      {
        paramah = (Throwable)new AssertionError("No parameter found for ".concat(String.valueOf(paramb)));
        AppMethodBeat.o(57862);
        throw paramah;
      }
      paramah = kotlin.l.b.a.b.j.b.a((ah)localObject, paramb.iDY(), paramah.iDY(), false, paramb.iDQ(), paramb.iDZ());
      paramah.aaNV = ((kotlin.l.b.a.b.b.t)paramb);
    }
    for (;;)
    {
      ((kotlin.l.b.a.b.d.a.b.e)localObject).a(localab, (kotlin.l.b.a.b.b.aj)paramah);
      paramah = (kotlin.l.b.a.b.d.a.b.g)localObject;
      AppMethodBeat.o(57862);
      return paramah;
      paramah = null;
    }
  }
  
  private final boolean d(final am paramam)
  {
    AppMethodBeat.i(57842);
    Object localObject1 = paramam.iEU();
    kotlin.g.b.p.j(localObject1, "function.name");
    localObject1 = (Iterable)s.i((kotlin.l.b.a.b.f.f)localObject1);
    if ((!(localObject1 instanceof Collection)) || (!((Collection)localObject1).isEmpty()))
    {
      localObject1 = ((Iterable)localObject1).iterator();
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Iterable)m((kotlin.l.b.a.b.f.f)((Iterator)localObject1).next());
        label181:
        label187:
        if ((!(localObject2 instanceof Collection)) || (!((Collection)localObject2).isEmpty()))
        {
          localObject2 = ((Iterable)localObject2).iterator();
          label111:
          if (((Iterator)localObject2).hasNext())
          {
            ah localah = (ah)((Iterator)localObject2).next();
            if ((c(localah, (kotlin.g.a.b)new h(this, paramam))) && ((localah.iFU()) || (!o.bGL(paramam.iEU().qu()))))
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
    Object localObject1 = kotlin.l.b.a.b.d.a.d.aaRx;
    localObject1 = paramam.iEU();
    kotlin.g.b.p.j(localObject1, "name");
    if (!kotlin.l.b.a.b.d.a.d.g((kotlin.l.b.a.b.f.f)localObject1))
    {
      AppMethodBeat.o(57843);
      return false;
    }
    localObject1 = paramam.iEU();
    kotlin.g.b.p.j(localObject1, "name");
    Object localObject2 = (Iterable)l((kotlin.l.b.a.b.f.f)localObject1);
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      kotlin.l.b.a.b.b.t localt = kotlin.l.b.a.b.d.a.d.e((kotlin.l.b.a.b.b.t)((Iterator)localObject2).next());
      if (localt != null) {
        ((Collection)localObject1).add(localt);
      }
    }
    localObject1 = (Iterable)localObject1;
    if (!((Collection)localObject1).isEmpty())
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        if (b(paramam, (kotlin.l.b.a.b.b.t)((Iterator)localObject1).next()))
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
    Object localObject1 = kotlin.l.b.a.b.d.a.c.aaRo;
    localObject1 = paramam.iEU();
    kotlin.g.b.p.j(localObject1, "name");
    localObject1 = (Iterable)kotlin.l.b.a.b.d.a.c.f((kotlin.l.b.a.b.f.f)localObject1);
    if ((!(localObject1 instanceof Collection)) || (!((Collection)localObject1).isEmpty()))
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (kotlin.l.b.a.b.f.f)((Iterator)localObject1).next();
        Object localObject4 = (Iterable)l((kotlin.l.b.a.b.f.f)localObject2);
        Object localObject3 = (Collection)new ArrayList();
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          Object localObject5 = ((Iterator)localObject4).next();
          if (kotlin.l.b.a.b.d.a.t.n((kotlin.l.b.a.b.b.b)localObject5)) {
            ((Collection)localObject3).add(localObject5);
          }
        }
        localObject3 = (List)localObject3;
        if (!((List)localObject3).isEmpty())
        {
          localObject2 = a(paramam, (kotlin.l.b.a.b.f.f)localObject2);
          localObject3 = (Iterable)localObject3;
          if (!((Collection)localObject3).isEmpty())
          {
            localObject3 = ((Iterable)localObject3).iterator();
            do
            {
              if (!((Iterator)localObject3).hasNext()) {
                break;
              }
            } while (!a((am)((Iterator)localObject3).next(), (kotlin.l.b.a.b.b.t)localObject2));
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
  
  private final boolean g(am paramam)
  {
    AppMethodBeat.i(57845);
    am localam1 = h(paramam);
    if (localam1 == null)
    {
      AppMethodBeat.o(57845);
      return false;
    }
    paramam = paramam.iEU();
    kotlin.g.b.p.j(paramam, "name");
    paramam = (Iterable)l(paramam);
    if (!((Collection)paramam).isEmpty())
    {
      paramam = paramam.iterator();
      while (paramam.hasNext())
      {
        am localam2 = (am)paramam.next();
        if ((localam2.iFn()) && (b((kotlin.l.b.a.b.b.a)localam1, (kotlin.l.b.a.b.b.a)localam2))) {}
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
  
  private final am h(am paramam)
  {
    AppMethodBeat.i(57846);
    Object localObject1 = paramam.iEJ();
    kotlin.g.b.p.j(localObject1, "valueParameters");
    Object localObject2 = (kotlin.l.b.a.b.b.av)kotlin.a.j.lr((List)localObject1);
    if (localObject2 != null)
    {
      localObject1 = ((kotlin.l.b.a.b.b.av)localObject2).iFN().iOU().iEf();
      if (localObject1 == null) {
        break label106;
      }
      localObject1 = kotlin.l.b.a.b.j.d.a.q((kotlin.l.b.a.b.b.l)localObject1);
      if (localObject1 == null) {
        break label106;
      }
      if (!((kotlin.l.b.a.b.f.c)localObject1).iNC()) {
        break label101;
      }
      if (localObject1 == null) {
        break label106;
      }
      localObject1 = ((kotlin.l.b.a.b.f.c)localObject1).iND();
      label79:
      if (!kotlin.l.b.a.b.a.k.a((kotlin.l.b.a.b.f.b)localObject1, false)) {
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
    localObject2 = paramam.iFo();
    paramam = paramam.iEJ();
    kotlin.g.b.p.j(paramam, "valueParameters");
    paramam = (am)((t.a)localObject2).lv(kotlin.a.j.N(paramam, 1)).G(((kotlin.l.b.a.b.m.av)((kotlin.l.b.a.b.b.av)localObject1).iFN().iOR().get(0)).iFN()).iFu();
    localObject1 = (ae)paramam;
    if (localObject1 != null) {
      ((kotlin.l.b.a.b.b.c.p)localObject1).aaNO = true;
    }
    AppMethodBeat.o(57846);
    return paramam;
  }
  
  private final Collection<kotlin.l.b.a.b.m.ab> iEe()
  {
    AppMethodBeat.i(57864);
    if (this.aaVg)
    {
      localObject = this.aaVf.iDL();
      kotlin.g.b.p.j(localObject, "ownerDescriptor.typeConstructor");
      localObject = ((at)localObject).iGk();
      kotlin.g.b.p.j(localObject, "ownerDescriptor.typeConstructor.supertypes");
      AppMethodBeat.o(57864);
      return localObject;
    }
    Object localObject = this.aaUh.aaUp.aaUb.iQe().D(this.aaVf);
    AppMethodBeat.o(57864);
    return localObject;
  }
  
  private final Set<am> l(kotlin.l.b.a.b.f.f paramf)
  {
    AppMethodBeat.i(57859);
    Object localObject = (Iterable)iEe();
    Collection localCollection = (Collection)new LinkedHashSet();
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      kotlin.a.j.a(localCollection, (Iterable)((kotlin.l.b.a.b.m.ab)((Iterator)localObject).next()).iEC().b(paramf, (kotlin.l.b.a.b.c.a.a)kotlin.l.b.a.b.c.a.c.aaQK));
    }
    paramf = (Set)localCollection;
    AppMethodBeat.o(57859);
    return paramf;
  }
  
  private final Set<ah> m(kotlin.l.b.a.b.f.f paramf)
  {
    AppMethodBeat.i(57863);
    Object localObject1 = (Iterable)iEe();
    Collection localCollection1 = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Iterable)((kotlin.l.b.a.b.m.ab)((Iterator)localObject1).next()).iEC().a(paramf, (kotlin.l.b.a.b.c.a.a)kotlin.l.b.a.b.c.a.c.aaQK);
      Collection localCollection2 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        localCollection2.add((ah)((Iterator)localObject2).next());
      }
      kotlin.a.j.a(localCollection1, (Iterable)localCollection2);
    }
    paramf = kotlin.a.j.r((Iterable)localCollection1);
    AppMethodBeat.o(57863);
    return paramf;
  }
  
  public final Collection<ah> a(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(57871);
    kotlin.g.b.p.k(paramf, "name");
    kotlin.g.b.p.k(parama, "location");
    d(paramf, parama);
    paramf = super.a(paramf, parama);
    AppMethodBeat.o(57871);
    return paramf;
  }
  
  protected final Set<kotlin.l.b.a.b.f.f> a(kotlin.l.b.a.b.j.f.d paramd)
  {
    AppMethodBeat.i(57873);
    kotlin.g.b.p.k(paramd, "kindFilter");
    if (this.aaUC.iHh())
    {
      paramd = iGp();
      AppMethodBeat.o(57873);
      return paramd;
    }
    paramd = new LinkedHashSet((Collection)((b)this.aaVy.invoke()).iIe());
    Object localObject = this.aaVf.iDL();
    kotlin.g.b.p.j(localObject, "ownerDescriptor.typeConstructor");
    localObject = ((at)localObject).iGk();
    kotlin.g.b.p.j(localObject, "ownerDescriptor.typeConstructor.supertypes");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Iterable localIterable = (Iterable)((kotlin.l.b.a.b.m.ab)((Iterator)localObject).next()).iEC().iGq();
      kotlin.a.j.a((Collection)paramd, localIterable);
    }
    paramd = (Set)paramd;
    AppMethodBeat.o(57873);
    return paramd;
  }
  
  protected final k.a a(kotlin.l.b.a.b.d.a.e.q paramq, List<? extends as> paramList, kotlin.l.b.a.b.m.ab paramab, List<? extends kotlin.l.b.a.b.b.av> paramList1)
  {
    AppMethodBeat.i(57865);
    kotlin.g.b.p.k(paramq, "method");
    kotlin.g.b.p.k(paramList, "methodTypeParameters");
    kotlin.g.b.p.k(paramab, "returnType");
    kotlin.g.b.p.k(paramList1, "valueParameters");
    Object localObject = this.aaUh.aaUp.aaTN.a(paramq, this.aaVf, paramab, paramList1, paramList);
    kotlin.g.b.p.j(localObject, "c.components.signaturePr…dTypeParameters\n        )");
    paramq = ((kotlin.l.b.a.b.d.a.a.k.a)localObject).aaPa;
    if (paramq == null) {
      kotlin.l.b.a.b.d.a.a.k.a.aDG(4);
    }
    kotlin.g.b.p.j(paramq, "propagated.returnType");
    paramList = ((kotlin.l.b.a.b.d.a.a.k.a)localObject).aaTl;
    paramab = ((kotlin.l.b.a.b.d.a.a.k.a)localObject).aaTm;
    if (paramab == null) {
      kotlin.l.b.a.b.d.a.a.k.a.aDG(5);
    }
    kotlin.g.b.p.j(paramab, "propagated.valueParameters");
    paramList1 = ((kotlin.l.b.a.b.d.a.a.k.a)localObject).aaKr;
    if (paramList1 == null) {
      kotlin.l.b.a.b.d.a.a.k.a.aDG(6);
    }
    kotlin.g.b.p.j(paramList1, "propagated.typeParameters");
    boolean bool = ((kotlin.l.b.a.b.d.a.a.k.a)localObject).aaNP;
    localObject = ((kotlin.l.b.a.b.d.a.a.k.a)localObject).aaTn;
    if (localObject == null) {
      kotlin.l.b.a.b.d.a.a.k.a.aDG(7);
    }
    kotlin.g.b.p.j(localObject, "propagated.errors");
    paramq = new k.a(paramq, paramList, paramab, paramList1, bool, (List)localObject);
    AppMethodBeat.o(57865);
    return paramq;
  }
  
  protected final void a(Collection<am> paramCollection, kotlin.l.b.a.b.f.f paramf)
  {
    AppMethodBeat.i(57854);
    kotlin.g.b.p.k(paramCollection, "result");
    kotlin.g.b.p.k(paramf, "name");
    Object localObject1 = l(paramf);
    Object localObject2 = kotlin.l.b.a.b.d.a.c.aaRo;
    if (!kotlin.l.b.a.b.d.a.c.e(paramf))
    {
      localObject2 = kotlin.l.b.a.b.d.a.d.aaRx;
      if (!kotlin.l.b.a.b.d.a.d.g(paramf))
      {
        localObject2 = (Iterable)localObject1;
        int i;
        if (!((Collection)localObject2).isEmpty())
        {
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            if (((kotlin.l.b.a.b.b.t)((Iterator)localObject2).next()).iFn()) {
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
    localObject2 = kotlin.l.b.a.b.o.i.abuE;
    localObject2 = i.b.iQq();
    Object localObject3 = kotlin.l.b.a.b.d.a.a.a.a(paramf, (Collection)localObject1, (Collection)v.aaAd, this.aaVf, r.abnK, this.aaUh.aaUp.aaUb.iQf());
    kotlin.g.b.p.j(localObject3, "resolveOverridesForNonSt….overridingUtil\n        )");
    a(paramf, paramCollection, (Collection)localObject3, paramCollection, (kotlin.g.a.b)new b((g)this));
    a(paramf, paramCollection, (Collection)localObject3, (Collection)localObject2, (kotlin.g.a.b)new c((g)this));
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
    a(paramCollection, paramf, (Collection)kotlin.a.j.b((Collection)localObject1, (Iterable)localObject2), true);
    AppMethodBeat.o(57854);
  }
  
  protected final boolean a(kotlin.l.b.a.b.d.a.b.f paramf)
  {
    AppMethodBeat.i(57841);
    kotlin.g.b.p.k(paramf, "$this$isVisibleAsFunction");
    if (this.aaUC.iHh())
    {
      AppMethodBeat.o(57841);
      return false;
    }
    boolean bool = d((am)paramf);
    AppMethodBeat.o(57841);
    return bool;
  }
  
  public final Collection<am> b(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(57870);
    kotlin.g.b.p.k(paramf, "name");
    kotlin.g.b.p.k(parama, "location");
    d(paramf, parama);
    paramf = super.b(paramf, parama);
    AppMethodBeat.o(57870);
    return paramf;
  }
  
  protected final void b(kotlin.l.b.a.b.f.f paramf, Collection<ah> paramCollection)
  {
    AppMethodBeat.i(57860);
    kotlin.g.b.p.k(paramf, "name");
    kotlin.g.b.p.k(paramCollection, "result");
    Object localObject1;
    if (this.aaUC.iHh())
    {
      localObject1 = (kotlin.l.b.a.b.d.a.e.q)kotlin.a.j.j((Iterable)((b)this.aaVy.invoke()).j(paramf));
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
      localObject2 = w.aaKi;
      Object localObject3 = kotlin.l.b.a.b.d.a.c.f.a(this.aaUh, (kotlin.l.b.a.b.d.a.e.d)localObject1);
      localObject2 = kotlin.l.b.a.b.d.a.b.g.a((kotlin.l.b.a.b.b.l)this.aaVf, (kotlin.l.b.a.b.b.a.g)localObject3, (w)localObject2, ((kotlin.l.b.a.b.d.a.e.q)localObject1).iDQ(), false, ((kotlin.l.b.a.b.d.a.e.q)localObject1).iEU(), (an)this.aaUh.aaUp.aaTS.a((kotlin.l.b.a.b.d.a.e.l)localObject1), false);
      kotlin.g.b.p.j(localObject2, "JavaPropertyDescriptor.c…inal = */ false\n        )");
      localObject3 = (ah)localObject2;
      g.a locala = kotlin.l.b.a.b.b.a.g.aaLw;
      localObject3 = kotlin.l.b.a.b.j.b.a((ah)localObject3, g.a.iGe());
      kotlin.g.b.p.j(localObject3, "DescriptorFactory.create…iptor, Annotations.EMPTY)");
      ((kotlin.l.b.a.b.d.a.b.g)localObject2).a((kotlin.l.b.a.b.b.c.ab)localObject3, null);
      localObject1 = a((kotlin.l.b.a.b.d.a.e.q)localObject1, kotlin.l.b.a.b.d.a.c.a.a(this.aaUh, (kotlin.l.b.a.b.b.l)localObject2, (x)localObject1, 0));
      ((kotlin.l.b.a.b.d.a.b.g)localObject2).a((kotlin.l.b.a.b.m.ab)localObject1, (List)v.aaAd, iEF(), null);
      ((kotlin.l.b.a.b.b.c.ab)localObject3).J((kotlin.l.b.a.b.m.ab)localObject1);
      paramCollection.add(localObject2);
    }
    Object localObject2 = kotlin.l.b.a.b.o.i.abuE;
    localObject2 = i.b.iQq();
    a((Set)localObject1, paramCollection, (kotlin.g.a.b)new d(this));
    a((Set)localObject1, (Collection)localObject2, (kotlin.g.a.b)new e(this));
    paramf = kotlin.l.b.a.b.d.a.a.a.a(paramf, (Collection)kotlin.a.ak.b((Set)localObject1, (Iterable)localObject2), paramCollection, this.aaVf, this.aaUh.aaUp.aaTO, this.aaUh.aaUp.aaUb.iQf());
    kotlin.g.b.p.j(paramf, "resolveOverridesForNonSt…rridingUtil\n            )");
    paramCollection.addAll(paramf);
    AppMethodBeat.o(57860);
  }
  
  protected final Set<kotlin.l.b.a.b.f.f> c(kotlin.l.b.a.b.j.f.d paramd, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, Boolean> paramb)
  {
    AppMethodBeat.i(57872);
    kotlin.g.b.p.k(paramd, "kindFilter");
    paramd = kotlin.a.ak.b((Set)this.aaVc.invoke(), (Iterable)((Map)this.aaVd.invoke()).keySet());
    AppMethodBeat.o(57872);
    return paramd;
  }
  
  public final kotlin.l.b.a.b.b.h c(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(57869);
    kotlin.g.b.p.k(paramf, "name");
    kotlin.g.b.p.k(parama, "location");
    d(paramf, parama);
    parama = (g)this.aaVE;
    if (parama != null)
    {
      parama = parama.aaVe;
      if (parama != null)
      {
        parama = (kotlin.l.b.a.b.b.c.g)parama.invoke(paramf);
        if (parama != null)
        {
          paramf = (kotlin.l.b.a.b.b.h)parama;
          AppMethodBeat.o(57869);
          return paramf;
        }
      }
    }
    paramf = (kotlin.l.b.a.b.b.h)this.aaVe.invoke(paramf);
    AppMethodBeat.o(57869);
    return paramf;
  }
  
  public final void d(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(57874);
    kotlin.g.b.p.k(paramf, "name");
    kotlin.g.b.p.k(parama, "location");
    kotlin.l.b.a.b.c.a.a(this.aaUh.aaUp.aaTV, parama, this.aaVf, paramf);
    AppMethodBeat.o(57874);
  }
  
  protected final kotlin.l.b.a.b.b.ak iEF()
  {
    AppMethodBeat.i(57868);
    kotlin.l.b.a.b.b.ak localak = kotlin.l.b.a.b.j.c.l((kotlin.l.b.a.b.b.l)this.aaVf);
    AppMethodBeat.o(57868);
    return localak;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57875);
    String str = "Lazy Java member scope for " + this.aaUC.iFy();
    AppMethodBeat.o(57875);
    return str;
  }
  
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.b<kotlin.l.b.a.b.f.f, Collection<? extends am>>
  {
    d(g paramg)
    {
      super();
    }
  }
  
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.b<kotlin.l.b.a.b.f.f, Collection<? extends am>>
  {
    e(g paramg)
    {
      super();
    }
  }
  
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<List<? extends kotlin.l.b.a.b.b.d>>
  {
    f(g paramg, kotlin.l.b.a.b.d.a.c.h paramh)
    {
      super();
    }
  }
  
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Map<kotlin.l.b.a.b.f.f, ? extends kotlin.l.b.a.b.d.a.e.n>>
  {
    g(g paramg)
    {
      super();
    }
  }
  
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.b<kotlin.l.b.a.b.f.f, Collection<? extends am>>
  {
    h(g paramg, am paramam)
    {
      super();
    }
  }
  
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Set<? extends kotlin.l.b.a.b.f.f>>
  {
    i(g paramg)
    {
      super();
    }
  }
  
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.b<kotlin.l.b.a.b.f.f, kotlin.l.b.a.b.b.c.g>
  {
    j(g paramg, kotlin.l.b.a.b.d.a.c.h paramh)
    {
      super();
    }
    
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<Set<? extends kotlin.l.b.a.b.f.f>>
    {
      a(g.j paramj)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.c.a.g
 * JD-Core Version:    0.7.0.1
 */