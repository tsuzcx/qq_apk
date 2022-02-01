package kotlin.l.b.a.b.d.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.g.b.u;
import kotlin.l.b.a.b.b.a.g.a;
import kotlin.l.b.a.b.b.ab.a;
import kotlin.l.b.a.b.b.ap;
import kotlin.l.b.a.b.b.aq;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.au;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.bd;
import kotlin.l.b.a.b.b.c.af;
import kotlin.l.b.a.b.b.x;
import kotlin.l.b.a.b.b.x.a;
import kotlin.l.b.a.b.d.a.aa;
import kotlin.l.b.a.b.d.a.ad.a;
import kotlin.l.b.a.b.d.a.ae;
import kotlin.l.b.a.b.d.a.b.i;
import kotlin.l.b.a.b.d.a.e.n;
import kotlin.l.b.a.b.d.a.e.y;
import kotlin.l.b.a.b.d.a.o;
import kotlin.l.b.a.b.d.a.p.a;
import kotlin.l.b.a.b.j.j.a.a;
import kotlin.l.b.a.b.l.m;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.az;
import kotlin.l.b.a.b.m.bg;
import kotlin.l.b.a.b.o.f.b;

public final class g
  extends j
{
  private final kotlin.l.b.a.b.d.a.e.g aiSA;
  final kotlin.l.b.a.b.b.e aiTe;
  private final boolean aiTf;
  final kotlin.l.b.a.b.l.h<List<kotlin.l.b.a.b.b.d>> aiTg;
  private final kotlin.l.b.a.b.l.h<Set<kotlin.l.b.a.b.f.f>> aiTh;
  private final kotlin.l.b.a.b.l.h<Map<kotlin.l.b.a.b.f.f, n>> aiTi;
  private final kotlin.l.b.a.b.l.g<kotlin.l.b.a.b.f.f, kotlin.l.b.a.b.b.c.g> aiTj;
  
  public g(final kotlin.l.b.a.b.d.a.c.h paramh, kotlin.l.b.a.b.b.e parame, kotlin.l.b.a.b.d.a.e.g paramg, boolean paramBoolean, g paramg1)
  {
    super(paramh, (j)paramg1);
    AppMethodBeat.i(57876);
    this.aiTe = parame;
    this.aiSA = paramg;
    this.aiTf = paramBoolean;
    this.aiTg = paramh.aiSp.aiBu.cq((kotlin.g.a.a)new f(this, paramh));
    this.aiTh = paramh.aiSp.aiBu.cq((kotlin.g.a.a)new i(this));
    this.aiTi = paramh.aiSp.aiBu.cq((kotlin.g.a.a)new g(this));
    this.aiTj = paramh.aiSp.aiBu.be((kotlin.g.a.b)new j(this, paramh));
    AppMethodBeat.o(57876);
  }
  
  private static au a(ap paramap, String paramString, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, ? extends Collection<? extends au>> paramb)
  {
    AppMethodBeat.i(57851);
    paramString = kotlin.l.b.a.b.f.f.bJe(paramString);
    kotlin.g.b.s.s(paramString, "identifier(getterName)");
    paramb = ((Iterable)paramb.invoke(paramString)).iterator();
    label119:
    label122:
    while (paramb.hasNext())
    {
      paramString = (au)paramb.next();
      kotlin.l.b.a.b.m.a.e locale;
      kotlin.l.b.a.b.m.ad localad;
      boolean bool;
      if (paramString.kod().size() == 0)
      {
        locale = kotlin.l.b.a.b.m.a.e.ajqY;
        localad = paramString.kob();
        if (localad == null)
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
        bool = locale.d(localad, paramap.koG());
        break;
        paramString = null;
      }
    }
    AppMethodBeat.o(57851);
    return null;
  }
  
  private final au a(ap paramap, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, ? extends Collection<? extends au>> paramb)
  {
    AppMethodBeat.i(57850);
    Object localObject1 = paramap.kpc();
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label73;
      }
    }
    for (Object localObject2 = null;; localObject2 = kotlin.l.b.a.b.d.a.h.k((kotlin.l.b.a.b.b.b)localObject1))
    {
      if ((localObject2 == null) || (kotlin.l.b.a.b.d.a.ac.a(this.aiTe, (kotlin.l.b.a.b.b.a)localObject1))) {
        break label90;
      }
      paramap = a(paramap, (String)localObject2, paramb);
      AppMethodBeat.o(57850);
      return paramap;
      localObject1 = (aq)kotlin.l.b.a.b.d.a.ac.m((kotlin.l.b.a.b.b.b)localObject1);
      break;
      label73:
      localObject2 = kotlin.l.b.a.b.d.a.h.aiOE;
    }
    label90:
    localObject1 = paramap.kok().PF();
    kotlin.g.b.s.s(localObject1, "name.asString()");
    paramap = a(paramap, kotlin.l.b.a.b.d.a.v.bIO((String)localObject1), paramb);
    AppMethodBeat.o(57850);
    return paramap;
  }
  
  private final au a(au paramau, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, ? extends Collection<? extends au>> paramb)
  {
    AppMethodBeat.i(57857);
    if (!paramau.koN())
    {
      AppMethodBeat.o(57857);
      return null;
    }
    Object localObject = paramau.kok();
    kotlin.g.b.s.s(localObject, "descriptor.name");
    localObject = ((Iterable)paramb.invoke(localObject)).iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramb = h((au)((Iterator)localObject).next());
      if ((paramb != null) && (b((kotlin.l.b.a.b.b.a)paramb, (kotlin.l.b.a.b.b.a)paramau))) {}
      while (paramb != null)
      {
        AppMethodBeat.o(57857);
        return paramb;
        paramb = null;
      }
    }
    AppMethodBeat.o(57857);
    return null;
  }
  
  private static au a(au paramau, kotlin.l.b.a.b.b.a parama, Collection<? extends au> paramCollection)
  {
    AppMethodBeat.i(57858);
    paramCollection = (Iterable)paramCollection;
    if ((!(paramCollection instanceof Collection)) || (!((Collection)paramCollection).isEmpty()))
    {
      paramCollection = paramCollection.iterator();
      if (paramCollection.hasNext())
      {
        au localau = (au)paramCollection.next();
        if ((!kotlin.g.b.s.p(paramau, localau)) && (localau.koI() == null) && (b((kotlin.l.b.a.b.b.a)localau, parama)))
        {
          i = 1;
          label90:
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
      return paramau;
      i = 0;
      break label90;
      label111:
      break;
    }
    label118:
    paramau = paramau.koO().koS().koU();
    kotlin.g.b.s.checkNotNull(paramau);
    paramau = (au)paramau;
    AppMethodBeat.o(57858);
    return paramau;
  }
  
  private static au a(au paramau, kotlin.l.b.a.b.f.f paramf)
  {
    AppMethodBeat.i(57847);
    paramau = paramau.koO();
    paramau.d(paramf);
    paramau.koP();
    paramau.koQ();
    paramau = paramau.koU();
    kotlin.g.b.s.checkNotNull(paramau);
    paramau = (au)paramau;
    AppMethodBeat.o(57847);
    return paramau;
  }
  
  private final void a(Collection<au> paramCollection, kotlin.l.b.a.b.f.f paramf, Collection<? extends au> paramCollection1, boolean paramBoolean)
  {
    AppMethodBeat.i(57855);
    paramf = kotlin.l.b.a.b.d.a.a.a.a(paramf, paramCollection1, paramCollection, this.aiTe, this.aiSh.aiSp.aiRO, this.aiSh.aiSp.aiSb.kAU());
    kotlin.g.b.s.s(paramf, "resolveOverridesForNonSt….overridingUtil\n        )");
    if (!paramBoolean)
    {
      paramCollection.addAll(paramf);
      AppMethodBeat.o(57855);
      return;
    }
    paramCollection1 = kotlin.a.p.b(paramCollection, (Iterable)paramf);
    paramf = (Iterable)paramf;
    Collection localCollection = (Collection)new ArrayList(kotlin.a.p.a(paramf, 10));
    Iterator localIterator = paramf.iterator();
    if (localIterator.hasNext())
    {
      paramf = (au)localIterator.next();
      au localau = (au)kotlin.l.b.a.b.d.a.ac.o((kotlin.l.b.a.b.b.b)paramf);
      if (localau == null) {
        kotlin.g.b.s.s(paramf, "resolvedOverride");
      }
      for (;;)
      {
        localCollection.add(paramf);
        break;
        kotlin.g.b.s.s(paramf, "resolvedOverride");
        paramf = a(paramf, (kotlin.l.b.a.b.b.a)localau, (Collection)paramCollection1);
      }
    }
    paramCollection.addAll((Collection)localCollection);
    AppMethodBeat.o(57855);
  }
  
  private final void a(List<bd> paramList, kotlin.l.b.a.b.b.k paramk, int paramInt, kotlin.l.b.a.b.d.a.e.q paramq, kotlin.l.b.a.b.m.ad paramad1, kotlin.l.b.a.b.m.ad paramad2)
  {
    AppMethodBeat.i(57867);
    kotlin.l.b.a.b.b.a locala = (kotlin.l.b.a.b.b.a)paramk;
    paramk = kotlin.l.b.a.b.b.a.g.aiIh;
    kotlin.l.b.a.b.b.a.g localg = g.a.kpB();
    kotlin.l.b.a.b.f.f localf = paramq.kok();
    paramad1 = bg.au(paramad1);
    kotlin.g.b.s.s(paramad1, "makeNotNullable(returnType)");
    boolean bool = paramq.krg();
    if (paramad2 == null) {}
    for (paramk = null;; paramk = bg.au(paramad2))
    {
      paramList.add(new kotlin.l.b.a.b.b.c.ak(locala, null, paramInt, localg, localf, paramad1, bool, false, false, paramk, (av)this.aiSh.aiSp.aiRS.a((kotlin.l.b.a.b.d.a.e.l)paramq)));
      AppMethodBeat.o(57867);
      return;
    }
  }
  
  private final void a(Set<? extends ap> paramSet, Collection<ap> paramCollection, Set<ap> paramSet1, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, ? extends Collection<? extends au>> paramb)
  {
    AppMethodBeat.i(192179);
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      ap localap = (ap)paramSet.next();
      kotlin.l.b.a.b.d.a.b.f localf = d(localap, paramb);
      if (localf != null)
      {
        paramCollection.add(localf);
        if (paramSet1 != null) {
          paramSet1.add(localap);
        }
      }
    }
    AppMethodBeat.o(192179);
  }
  
  private final void a(kotlin.l.b.a.b.f.f paramf, Collection<? extends au> paramCollection1, Collection<? extends au> paramCollection2, Collection<au> paramCollection, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, ? extends Collection<? extends au>> paramb)
  {
    AppMethodBeat.i(57856);
    Iterator localIterator = paramCollection2.iterator();
    if (localIterator.hasNext())
    {
      au localau = (au)localIterator.next();
      paramCollection2 = (au)kotlin.l.b.a.b.d.a.ac.m((kotlin.l.b.a.b.b.b)localau);
      Object localObject1;
      Object localObject2;
      if (paramCollection2 != null)
      {
        localObject1 = kotlin.l.b.a.b.d.a.ac.p((kotlin.l.b.a.b.b.b)paramCollection2);
        kotlin.g.b.s.checkNotNull(localObject1);
        localObject1 = kotlin.l.b.a.b.f.f.bJe((String)localObject1);
        kotlin.g.b.s.s(localObject1, "identifier(nameInJava)");
        localObject1 = ((Collection)paramb.invoke(localObject1)).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = a((au)((Iterator)localObject1).next(), paramf);
          if (a(paramCollection2, (x)localObject2))
          {
            paramCollection2 = a((au)localObject2, (kotlin.l.b.a.b.b.a)paramCollection2, paramCollection1);
            label149:
            kotlin.l.b.a.b.o.a.c(paramCollection, paramCollection2);
            localObject1 = kotlin.l.b.a.b.d.a.e.e((x)localau);
            if (localObject1 != null) {
              break label199;
            }
            paramCollection2 = null;
          }
        }
      }
      for (;;)
      {
        kotlin.l.b.a.b.o.a.c(paramCollection, paramCollection2);
        kotlin.l.b.a.b.o.a.c(paramCollection, a(localau, paramb));
        break;
        paramCollection2 = null;
        break label149;
        label199:
        paramCollection2 = ((x)localObject1).kok();
        kotlin.g.b.s.s(paramCollection2, "overridden.name");
        localObject2 = ((Iterable)paramb.invoke(paramCollection2)).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          paramCollection2 = ((Iterator)localObject2).next();
          if (b((au)paramCollection2, (x)localObject1))
          {
            label262:
            localObject2 = (au)paramCollection2;
            if (localObject2 != null) {
              break label289;
            }
          }
        }
        for (paramCollection2 = null;; paramCollection2 = (au)paramCollection2.koU())
        {
          if (paramCollection2 != null) {
            break label491;
          }
          paramCollection2 = null;
          break;
          paramCollection2 = null;
          break label262;
          label289:
          paramCollection2 = ((au)localObject2).koO();
          Object localObject3 = ((x)localObject1).kod();
          kotlin.g.b.s.s(localObject3, "overridden.valueParameters");
          Object localObject4 = (Iterable)localObject3;
          localObject3 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject4, 10));
          localObject4 = ((Iterable)localObject4).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            bd localbd = (bd)((Iterator)localObject4).next();
            kotlin.l.b.a.b.m.ad localad = localbd.koG();
            kotlin.g.b.s.s(localad, "it.type");
            ((Collection)localObject3).add(new i(localad, localbd.kpp()));
          }
          localObject3 = (Collection)localObject3;
          localObject2 = ((au)localObject2).kod();
          kotlin.g.b.s.s(localObject2, "override.valueParameters");
          paramCollection2.oR(kotlin.l.b.a.b.d.a.b.h.a((Collection)localObject3, (Collection)localObject2, (kotlin.l.b.a.b.b.a)localObject1));
          paramCollection2.koP();
          paramCollection2.koQ();
        }
        label491:
        if (d(paramCollection2)) {}
        for (;;)
        {
          if (paramCollection2 != null) {
            break label513;
          }
          paramCollection2 = null;
          break;
          paramCollection2 = null;
        }
        label513:
        paramCollection2 = a(paramCollection2, (kotlin.l.b.a.b.b.a)localObject1, paramCollection1);
      }
    }
    AppMethodBeat.o(57856);
  }
  
  private static boolean a(au paramau, x paramx)
  {
    AppMethodBeat.i(57848);
    kotlin.l.b.a.b.d.a.d locald = kotlin.l.b.a.b.d.a.d.aiOu;
    if (kotlin.l.b.a.b.d.a.d.c(paramau)) {
      paramx = paramx.koH();
    }
    for (;;)
    {
      kotlin.g.b.s.s(paramx, "if (superDescriptor.isRe…iginal else subDescriptor");
      boolean bool = b((kotlin.l.b.a.b.b.a)paramx, (kotlin.l.b.a.b.b.a)paramau);
      AppMethodBeat.o(57848);
      return bool;
    }
  }
  
  private static au b(ap paramap, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, ? extends Collection<? extends au>> paramb)
  {
    AppMethodBeat.i(57852);
    Object localObject1 = paramap.kok().PF();
    kotlin.g.b.s.s(localObject1, "name.asString()");
    localObject1 = kotlin.l.b.a.b.f.f.bJe(kotlin.l.b.a.b.d.a.v.bIP((String)localObject1));
    kotlin.g.b.s.s(localObject1, "identifier(JvmAbi.setterName(name.asString()))");
    localObject1 = ((Iterable)paramb.invoke(localObject1)).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      paramb = (au)((Iterator)localObject1).next();
      if (paramb.kod().size() == 1)
      {
        Object localObject2 = paramb.kob();
        if ((localObject2 != null) && (kotlin.l.b.a.b.a.h.v((kotlin.l.b.a.b.m.ad)localObject2)))
        {
          localObject2 = kotlin.l.b.a.b.m.a.e.ajqY;
          List localList = paramb.kod();
          kotlin.g.b.s.s(localList, "descriptor.valueParameters");
          if (!((kotlin.l.b.a.b.m.a.e)localObject2).e(((bd)kotlin.a.p.oO(localList)).koG(), paramap.koG())) {}
        }
      }
      while (paramb != null)
      {
        AppMethodBeat.o(57852);
        return paramb;
        paramb = null;
      }
    }
    AppMethodBeat.o(57852);
    return null;
  }
  
  private static boolean b(kotlin.l.b.a.b.b.a parama1, kotlin.l.b.a.b.b.a parama2)
  {
    AppMethodBeat.i(57849);
    Object localObject = kotlin.l.b.a.b.j.j.ajja.b(parama2, parama1, true).kzj();
    kotlin.g.b.s.s(localObject, "DEFAULT.isOverridableByW…iptor, this, true).result");
    if (localObject == j.a.a.ajjn)
    {
      localObject = kotlin.l.b.a.b.d.a.p.aiOT;
      if (!p.a.a(parama2, parama1))
      {
        AppMethodBeat.o(57849);
        return true;
      }
    }
    AppMethodBeat.o(57849);
    return false;
  }
  
  private static boolean b(au paramau, x paramx)
  {
    AppMethodBeat.i(57866);
    String str = kotlin.l.b.a.b.d.b.t.a((x)paramau, false, false, 2);
    x localx = paramx.koH();
    kotlin.g.b.s.s(localx, "builtinWithErasedParameters.original");
    if ((kotlin.g.b.s.p(str, kotlin.l.b.a.b.d.b.t.a(localx, false, false, 2))) && (!b((kotlin.l.b.a.b.b.a)paramau, (kotlin.l.b.a.b.b.a)paramx)))
    {
      AppMethodBeat.o(57866);
      return true;
    }
    AppMethodBeat.o(57866);
    return false;
  }
  
  private final boolean c(ap paramap, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, ? extends Collection<? extends au>> paramb)
  {
    AppMethodBeat.i(57853);
    if (c.d(paramap))
    {
      AppMethodBeat.o(57853);
      return false;
    }
    au localau = a(paramap, paramb);
    paramb = b(paramap, paramb);
    if (localau == null)
    {
      AppMethodBeat.o(57853);
      return false;
    }
    if (!paramap.kpu())
    {
      AppMethodBeat.o(57853);
      return true;
    }
    if ((paramb != null) && (paramb.knb() == localau.knb()))
    {
      AppMethodBeat.o(57853);
      return true;
    }
    AppMethodBeat.o(57853);
    return false;
  }
  
  private final kotlin.l.b.a.b.d.a.b.f d(ap paramap, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, ? extends Collection<? extends au>> paramb)
  {
    int i = 1;
    AppMethodBeat.i(57862);
    if (!c(paramap, paramb))
    {
      AppMethodBeat.o(57862);
      return null;
    }
    au localau = a(paramap, paramb);
    kotlin.g.b.s.checkNotNull(localau);
    if (paramap.kpu())
    {
      paramb = b(paramap, paramb);
      kotlin.g.b.s.checkNotNull(paramb);
      if (paramb != null) {
        break label161;
      }
      label61:
      if ((!kotlin.ak.aiuY) || (i != 0)) {
        break label192;
      }
      localObject = new StringBuilder("Different accessors modalities when creating overrides for ").append(paramap).append(" in ").append(this.aiTe).append("for getter is ").append(localau.knb()).append(", but for setter is ");
      if (paramb != null) {
        break label182;
      }
    }
    label161:
    label182:
    for (paramap = null;; paramap = paramb.knb())
    {
      paramap = (Throwable)new AssertionError(paramap);
      AppMethodBeat.o(57862);
      throw paramap;
      paramb = null;
      break;
      if (paramb.knb() == localau.knb()) {
        break label61;
      }
      i = 0;
      break label61;
    }
    label192:
    Object localObject = new kotlin.l.b.a.b.d.a.b.d(this.aiTe, localau, paramb, paramap);
    paramap = localau.kob();
    kotlin.g.b.s.checkNotNull(paramap);
    ((kotlin.l.b.a.b.d.a.b.d)localObject).a(paramap, (List)kotlin.a.ab.aivy, knZ(), null);
    kotlin.l.b.a.b.b.c.ac localac = kotlin.l.b.a.b.j.c.a((ap)localObject, localau.knl(), false, localau.knm());
    localac.aiKG = ((x)localau);
    localac.C(((kotlin.l.b.a.b.d.a.b.d)localObject).koG());
    kotlin.g.b.s.s(localac, "createGetter(\n          …escriptor.type)\n        }");
    if (paramb != null)
    {
      paramap = paramb.kod();
      kotlin.g.b.s.s(paramap, "setterMethod.valueParameters");
      paramap = (bd)kotlin.a.p.oL(paramap);
      if (paramap == null)
      {
        paramap = new AssertionError(kotlin.g.b.s.X("No parameter found for ", paramb));
        AppMethodBeat.o(57862);
        throw paramap;
      }
      paramap = kotlin.l.b.a.b.j.c.a((ap)localObject, paramb.knl(), paramap.knl(), false, paramb.knc(), paramb.knm());
      paramap.aiKG = ((x)paramb);
    }
    for (;;)
    {
      ((kotlin.l.b.a.b.d.a.b.d)localObject).a(localac, (kotlin.l.b.a.b.b.ar)paramap);
      paramap = (kotlin.l.b.a.b.d.a.b.f)localObject;
      AppMethodBeat.o(57862);
      return paramap;
      paramap = null;
    }
  }
  
  private final boolean d(au paramau)
  {
    AppMethodBeat.i(57842);
    Object localObject1 = paramau.kok();
    kotlin.g.b.s.s(localObject1, "function.name");
    localObject1 = (Iterable)aa.g((kotlin.l.b.a.b.f.f)localObject1);
    if ((!(localObject1 instanceof Collection)) || (!((Collection)localObject1).isEmpty()))
    {
      localObject1 = ((Iterable)localObject1).iterator();
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Iterable)n((kotlin.l.b.a.b.f.f)((Iterator)localObject1).next());
        label193:
        label199:
        if ((!(localObject2 instanceof Collection)) || (!((Collection)localObject2).isEmpty()))
        {
          localObject2 = ((Iterable)localObject2).iterator();
          label111:
          if (((Iterator)localObject2).hasNext())
          {
            Object localObject3 = (ap)((Iterator)localObject2).next();
            if (c((ap)localObject3, (kotlin.g.a.b)new h(paramau, this))) {
              if (!((ap)localObject3).kpu())
              {
                localObject3 = paramau.kok().PF();
                kotlin.g.b.s.s(localObject3, "function.name.asString()");
                if (kotlin.l.b.a.b.d.a.v.bIN((String)localObject3)) {}
              }
              else
              {
                i = 1;
                if (i == 0) {
                  break label220;
                }
                i = 1;
                if (i == 0) {
                  break label225;
                }
              }
            }
          }
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label232;
      }
      AppMethodBeat.o(57842);
      return false;
      i = 0;
      break label193;
      label220:
      break label111;
      i = 0;
      break label199;
      label225:
      break;
    }
    label232:
    if ((!f(paramau)) && (!e(paramau)) && (!g(paramau)))
    {
      AppMethodBeat.o(57842);
      return true;
    }
    AppMethodBeat.o(57842);
    return false;
  }
  
  private final boolean e(au paramau)
  {
    AppMethodBeat.i(57843);
    Object localObject1 = kotlin.l.b.a.b.d.a.e.aiOw;
    localObject1 = paramau.kok();
    kotlin.g.b.s.s(localObject1, "name");
    if (!kotlin.l.b.a.b.d.a.e.e((kotlin.l.b.a.b.f.f)localObject1))
    {
      AppMethodBeat.o(57843);
      return false;
    }
    localObject1 = paramau.kok();
    kotlin.g.b.s.s(localObject1, "name");
    Object localObject2 = (Iterable)m((kotlin.l.b.a.b.f.f)localObject1);
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      x localx = kotlin.l.b.a.b.d.a.e.e((x)((Iterator)localObject2).next());
      if (localx != null) {
        ((Collection)localObject1).add(localx);
      }
    }
    localObject1 = (Iterable)localObject1;
    if (!((Collection)localObject1).isEmpty())
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        if (b(paramau, (x)((Iterator)localObject1).next()))
        {
          AppMethodBeat.o(57843);
          return true;
        }
      }
    }
    AppMethodBeat.o(57843);
    return false;
  }
  
  private final boolean f(au paramau)
  {
    AppMethodBeat.i(57844);
    Object localObject1 = kotlin.l.b.a.b.d.a.ad.aiQo;
    localObject1 = paramau.kok();
    kotlin.g.b.s.s(localObject1, "name");
    localObject1 = (Iterable)ad.a.h((kotlin.l.b.a.b.f.f)localObject1);
    if ((!(localObject1 instanceof Collection)) || (!((Collection)localObject1).isEmpty()))
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (kotlin.l.b.a.b.f.f)((Iterator)localObject1).next();
        Object localObject4 = (Iterable)m((kotlin.l.b.a.b.f.f)localObject2);
        Object localObject3 = (Collection)new ArrayList();
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          Object localObject5 = ((Iterator)localObject4).next();
          if (kotlin.l.b.a.b.d.a.ac.n((kotlin.l.b.a.b.b.b)localObject5)) {
            ((Collection)localObject3).add(localObject5);
          }
        }
        localObject3 = (List)localObject3;
        if (!((List)localObject3).isEmpty())
        {
          localObject2 = a(paramau, (kotlin.l.b.a.b.f.f)localObject2);
          localObject3 = (Iterable)localObject3;
          if (!((Collection)localObject3).isEmpty())
          {
            localObject3 = ((Iterable)localObject3).iterator();
            do
            {
              if (!((Iterator)localObject3).hasNext()) {
                break;
              }
            } while (!a((au)((Iterator)localObject3).next(), (x)localObject2));
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
  
  private final boolean g(au paramau)
  {
    AppMethodBeat.i(57845);
    au localau1 = h(paramau);
    if (localau1 == null)
    {
      AppMethodBeat.o(57845);
      return false;
    }
    paramau = paramau.kok();
    kotlin.g.b.s.s(paramau, "name");
    paramau = (Iterable)m(paramau);
    if ((!(paramau instanceof Collection)) || (!((Collection)paramau).isEmpty()))
    {
      paramau = paramau.iterator();
      while (paramau.hasNext())
      {
        au localau2 = (au)paramau.next();
        if ((localau2.koN()) && (b((kotlin.l.b.a.b.b.a)localau1, (kotlin.l.b.a.b.b.a)localau2))) {}
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
  
  private final au h(au paramau)
  {
    AppMethodBeat.i(57846);
    Object localObject1 = paramau.kod();
    kotlin.g.b.s.s(localObject1, "valueParameters");
    Object localObject2 = (bd)kotlin.a.p.oN((List)localObject1);
    if (localObject2 != null)
    {
      localObject1 = ((bd)localObject2).koG().kzm().knA();
      if (localObject1 == null)
      {
        localObject1 = null;
        if (!kotlin.l.b.a.b.a.l.a((kotlin.l.b.a.b.f.c)localObject1, this.aiSh.aiSp.aiSa.ksg())) {
          break label135;
        }
      }
    }
    label135:
    for (localObject1 = localObject2;; localObject1 = null)
    {
      if (localObject1 != null) {
        break label140;
      }
      AppMethodBeat.o(57846);
      return null;
      localObject1 = kotlin.l.b.a.b.j.d.a.q((kotlin.l.b.a.b.b.l)localObject1);
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      if (((kotlin.l.b.a.b.f.d)localObject1).kxW()) {}
      for (;;)
      {
        if (localObject1 != null) {
          break label127;
        }
        localObject1 = null;
        break;
        localObject1 = null;
      }
      label127:
      localObject1 = ((kotlin.l.b.a.b.f.d)localObject1).kxX();
      break;
    }
    label140:
    localObject2 = paramau.koO();
    paramau = paramau.kod();
    kotlin.g.b.s.s(paramau, "valueParameters");
    paramau = (au)((x.a)localObject2).oR(kotlin.a.p.af(paramau, 1)).z(((az)((bd)localObject1).koG().klR().get(0)).koG()).koU();
    localObject1 = (af)paramau;
    if (localObject1 != null) {
      ((kotlin.l.b.a.b.b.c.p)localObject1).aiKz = true;
    }
    AppMethodBeat.o(57846);
    return paramau;
  }
  
  private final Collection<kotlin.l.b.a.b.m.ad> knw()
  {
    AppMethodBeat.i(57864);
    if (this.aiTf)
    {
      localCollection = this.aiTe.kmZ().kpG();
      kotlin.g.b.s.s(localCollection, "ownerDescriptor.typeConstructor.supertypes");
      AppMethodBeat.o(57864);
      return localCollection;
    }
    Collection localCollection = this.aiSh.aiSp.aiSb.kAT().F(this.aiTe);
    AppMethodBeat.o(57864);
    return localCollection;
  }
  
  private final Set<au> m(kotlin.l.b.a.b.f.f paramf)
  {
    AppMethodBeat.i(57859);
    Object localObject = (Iterable)knw();
    Collection localCollection = (Collection)new LinkedHashSet();
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      kotlin.a.p.a(localCollection, (Iterable)((kotlin.l.b.a.b.m.ad)((Iterator)localObject).next()).knP().b(paramf, (kotlin.l.b.a.b.c.a.b)kotlin.l.b.a.b.c.a.d.aiNJ));
    }
    paramf = (Set)localCollection;
    AppMethodBeat.o(57859);
    return paramf;
  }
  
  private final Set<ap> n(kotlin.l.b.a.b.f.f paramf)
  {
    AppMethodBeat.i(57863);
    Object localObject1 = (Iterable)knw();
    Collection localCollection1 = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Iterable)((kotlin.l.b.a.b.m.ad)((Iterator)localObject1).next()).knP().a(paramf, (kotlin.l.b.a.b.c.a.b)kotlin.l.b.a.b.c.a.d.aiNJ);
      Collection localCollection2 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        localCollection2.add((ap)((Iterator)localObject2).next());
      }
      kotlin.a.p.a(localCollection1, (Iterable)localCollection2);
    }
    paramf = kotlin.a.p.r((Iterable)localCollection1);
    AppMethodBeat.o(57863);
    return paramf;
  }
  
  private static kotlin.l.b.a.b.b.t r(kotlin.l.b.a.b.b.e parame)
  {
    AppMethodBeat.i(192187);
    parame = parame.knc();
    kotlin.g.b.s.s(parame, "classDescriptor.visibility");
    if (kotlin.g.b.s.p(parame, o.aiOR))
    {
      parame = o.aiOS;
      kotlin.g.b.s.s(parame, "PROTECTED_AND_PACKAGE");
      AppMethodBeat.o(192187);
      return parame;
    }
    AppMethodBeat.o(192187);
    return parame;
  }
  
  public final Collection<ap> a(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.c.a.b paramb)
  {
    AppMethodBeat.i(57871);
    kotlin.g.b.s.u(paramf, "name");
    kotlin.g.b.s.u(paramb, "location");
    d(paramf, paramb);
    paramf = super.a(paramf, paramb);
    AppMethodBeat.o(57871);
    return paramf;
  }
  
  protected final Set<kotlin.l.b.a.b.f.f> a(kotlin.l.b.a.b.j.g.d paramd)
  {
    AppMethodBeat.i(57873);
    kotlin.g.b.s.u(paramd, "kindFilter");
    if (this.aiSA.kqH())
    {
      paramd = kpL();
      AppMethodBeat.o(57873);
      return paramd;
    }
    paramd = new LinkedHashSet((Collection)((b)this.aiTB.invoke()).ksl());
    Object localObject = this.aiTe.kmZ().kpG();
    kotlin.g.b.s.s(localObject, "ownerDescriptor.typeConstructor.supertypes");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Iterable localIterable = (Iterable)((kotlin.l.b.a.b.m.ad)((Iterator)localObject).next()).knP().kpN();
      kotlin.a.p.a((Collection)paramd, localIterable);
    }
    paramd = (Set)paramd;
    AppMethodBeat.o(57873);
    return paramd;
  }
  
  protected final j.a a(kotlin.l.b.a.b.d.a.e.q paramq, List<? extends ba> paramList, kotlin.l.b.a.b.m.ad paramad, List<? extends bd> paramList1)
  {
    AppMethodBeat.i(57865);
    kotlin.g.b.s.u(paramq, "method");
    kotlin.g.b.s.u(paramList, "methodTypeParameters");
    kotlin.g.b.s.u(paramad, "returnType");
    kotlin.g.b.s.u(paramList1, "valueParameters");
    Object localObject = this.aiSh.aiSp.aiRN.a(paramq, this.aiTe, paramad, paramList1, paramList);
    kotlin.g.b.s.s(localObject, "c.components.signaturePr…dTypeParameters\n        )");
    paramq = ((kotlin.l.b.a.b.d.a.a.j.a)localObject).aiLR;
    if (paramq == null) {
      kotlin.l.b.a.b.d.a.a.j.a.aKu(4);
    }
    kotlin.g.b.s.s(paramq, "propagated.returnType");
    paramList = ((kotlin.l.b.a.b.d.a.a.j.a)localObject).aiRl;
    paramad = ((kotlin.l.b.a.b.d.a.a.j.a)localObject).aiRm;
    if (paramad == null) {
      kotlin.l.b.a.b.d.a.a.j.a.aKu(5);
    }
    kotlin.g.b.s.s(paramad, "propagated.valueParameters");
    paramList1 = ((kotlin.l.b.a.b.d.a.a.j.a)localObject).aiKl;
    if (paramList1 == null) {
      kotlin.l.b.a.b.d.a.a.j.a.aKu(6);
    }
    kotlin.g.b.s.s(paramList1, "propagated.typeParameters");
    boolean bool = ((kotlin.l.b.a.b.d.a.a.j.a)localObject).aiKA;
    localObject = ((kotlin.l.b.a.b.d.a.a.j.a)localObject).aiRn;
    if (localObject == null) {
      kotlin.l.b.a.b.d.a.a.j.a.aKu(7);
    }
    kotlin.g.b.s.s(localObject, "propagated.errors");
    paramq = new j.a(paramq, paramList, paramad, paramList1, bool, (List)localObject);
    AppMethodBeat.o(57865);
    return paramq;
  }
  
  protected final void a(Collection<au> paramCollection, kotlin.l.b.a.b.f.f paramf)
  {
    AppMethodBeat.i(57854);
    kotlin.g.b.s.u(paramCollection, "result");
    kotlin.g.b.s.u(paramf, "name");
    Object localObject1 = m(paramf);
    Object localObject2 = kotlin.l.b.a.b.d.a.ad.aiQo;
    if (!ad.a.i(paramf))
    {
      localObject2 = kotlin.l.b.a.b.d.a.e.aiOw;
      if (!kotlin.l.b.a.b.d.a.e.e(paramf))
      {
        localObject2 = (Iterable)localObject1;
        int i;
        if ((!(localObject2 instanceof Collection)) || (!((Collection)localObject2).isEmpty()))
        {
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            if (((x)((Iterator)localObject2).next()).koN()) {
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
              if (d((au)localObject3))
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
    localObject2 = kotlin.l.b.a.b.o.f.ajtJ;
    localObject2 = f.b.kBe();
    Object localObject3 = kotlin.l.b.a.b.d.a.a.a.a(paramf, (Collection)localObject1, (Collection)kotlin.a.ab.aivy, this.aiTe, kotlin.l.b.a.b.k.a.q.ajmu, this.aiSh.aiSp.aiSb.kAU());
    kotlin.g.b.s.s(localObject3, "resolveOverridesForNonSt….overridingUtil\n        )");
    a(paramf, paramCollection, (Collection)localObject3, paramCollection, (kotlin.g.a.b)new b());
    a(paramf, paramCollection, (Collection)localObject3, (Collection)localObject2, (kotlin.g.a.b)new c());
    localObject3 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList();
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      Object localObject4 = ((Iterator)localObject3).next();
      if (d((au)localObject4)) {
        ((Collection)localObject1).add(localObject4);
      }
    }
    a(paramCollection, paramf, (Collection)kotlin.a.p.b((Collection)localObject1, (Iterable)localObject2), true);
    AppMethodBeat.o(57854);
  }
  
  protected final boolean a(kotlin.l.b.a.b.d.a.b.e parame)
  {
    AppMethodBeat.i(57841);
    kotlin.g.b.s.u(parame, "<this>");
    if (this.aiSA.kqH())
    {
      AppMethodBeat.o(57841);
      return false;
    }
    boolean bool = d((au)parame);
    AppMethodBeat.o(57841);
    return bool;
  }
  
  public final Collection<au> b(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.c.a.b paramb)
  {
    AppMethodBeat.i(57870);
    kotlin.g.b.s.u(paramf, "name");
    kotlin.g.b.s.u(paramb, "location");
    d(paramf, paramb);
    paramf = super.b(paramf, paramb);
    AppMethodBeat.o(57870);
    return paramf;
  }
  
  protected final Set<kotlin.l.b.a.b.f.f> b(kotlin.l.b.a.b.j.g.d paramd, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, Boolean> paramb)
  {
    AppMethodBeat.i(57872);
    kotlin.g.b.s.u(paramd, "kindFilter");
    paramd = kotlin.a.ar.b((Set)this.aiTh.invoke(), (Iterable)((Map)this.aiTi.invoke()).keySet());
    AppMethodBeat.o(57872);
    return paramd;
  }
  
  protected final void b(Collection<au> paramCollection, kotlin.l.b.a.b.f.f paramf)
  {
    AppMethodBeat.i(192230);
    kotlin.g.b.s.u(paramCollection, "result");
    kotlin.g.b.s.u(paramf, "name");
    Object localObject1;
    if ((this.aiSA.kqJ()) && (((b)this.aiTB.invoke()).l(paramf) != null))
    {
      localObject1 = (Iterable)paramCollection;
      if (((Collection)localObject1).isEmpty()) {
        break label364;
      }
      localObject1 = ((Iterable)localObject1).iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
      } while (!((au)((Iterator)localObject1).next()).kod().isEmpty());
    }
    label364:
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        localObject1 = ((b)this.aiTB.invoke()).l(paramf);
        kotlin.g.b.s.checkNotNull(localObject1);
        Object localObject2 = kotlin.l.b.a.b.d.a.c.f.a(this.aiSh, (kotlin.l.b.a.b.d.a.e.d)localObject1);
        localObject2 = kotlin.l.b.a.b.d.a.b.e.a((kotlin.l.b.a.b.b.l)this.aiTe, (kotlin.l.b.a.b.b.a.g)localObject2, ((kotlin.l.b.a.b.d.a.e.v)localObject1).kok(), (av)this.aiSh.aiSp.aiRS.a((kotlin.l.b.a.b.d.a.e.l)localObject1), true);
        kotlin.g.b.s.s(localObject2, "createJavaMethod(\n      …omponent), true\n        )");
        Object localObject3 = kotlin.l.b.a.b.d.a.c.b.d.a(kotlin.l.b.a.b.d.a.a.k.aiRp, false, null, 2);
        localObject3 = this.aiSh.aiSt.a(((kotlin.l.b.a.b.d.a.e.v)localObject1).krd(), (kotlin.l.b.a.b.d.a.c.b.a)localObject3);
        as localas = knZ();
        List localList1 = (List)kotlin.a.ab.aivy;
        List localList2 = (List)kotlin.a.ab.aivy;
        ab.a locala = kotlin.l.b.a.b.b.ab.aiGX;
        ((kotlin.l.b.a.b.d.a.b.e)localObject2).a(null, localas, localList1, localList2, (kotlin.l.b.a.b.m.ad)localObject3, ab.a.bY(false, true), kotlin.l.b.a.b.b.s.aiGG, null);
        ((kotlin.l.b.a.b.d.a.b.e)localObject2).bZ(false, false);
        this.aiSh.aiSp.aiRP.a((kotlin.l.b.a.b.d.a.e.p)localObject1, (au)localObject2);
        paramCollection.add(localObject2);
      }
      this.aiSh.aiSp.aiSd.a(this.aiTe, paramf, paramCollection);
      AppMethodBeat.o(192230);
      return;
    }
  }
  
  protected final void b(kotlin.l.b.a.b.f.f paramf, Collection<ap> paramCollection)
  {
    AppMethodBeat.i(57860);
    kotlin.g.b.s.u(paramf, "name");
    kotlin.g.b.s.u(paramCollection, "result");
    if (this.aiSA.kqH())
    {
      localObject1 = (kotlin.l.b.a.b.d.a.e.q)kotlin.a.p.j((Iterable)((b)this.aiTB.invoke()).j(paramf));
      if (localObject1 != null)
      {
        localObject2 = kotlin.l.b.a.b.b.ab.aiGY;
        localObject3 = kotlin.l.b.a.b.d.a.c.f.a(this.aiSh, (kotlin.l.b.a.b.d.a.e.d)localObject1);
        localObject2 = kotlin.l.b.a.b.d.a.b.f.a((kotlin.l.b.a.b.b.l)this.aiTe, (kotlin.l.b.a.b.b.a.g)localObject3, (kotlin.l.b.a.b.b.ab)localObject2, ae.a(((kotlin.l.b.a.b.d.a.e.q)localObject1).kqO()), false, ((kotlin.l.b.a.b.d.a.e.q)localObject1).kok(), (av)this.aiSh.aiSp.aiRS.a((kotlin.l.b.a.b.d.a.e.l)localObject1), false);
        kotlin.g.b.s.s(localObject2, "create(\n            owne…inal = */ false\n        )");
        localObject3 = (ap)localObject2;
        g.a locala = kotlin.l.b.a.b.b.a.g.aiIh;
        localObject3 = kotlin.l.b.a.b.j.c.a((ap)localObject3, g.a.kpB());
        kotlin.g.b.s.s(localObject3, "createDefaultGetter(prop…iptor, Annotations.EMPTY)");
        ((kotlin.l.b.a.b.d.a.b.f)localObject2).a((kotlin.l.b.a.b.b.c.ac)localObject3, null);
        localObject1 = a((kotlin.l.b.a.b.d.a.e.q)localObject1, kotlin.l.b.a.b.d.a.c.a.a(this.aiSh, (kotlin.l.b.a.b.b.l)localObject2, (y)localObject1, 0));
        ((kotlin.l.b.a.b.d.a.b.f)localObject2).a((kotlin.l.b.a.b.m.ad)localObject1, (List)kotlin.a.ab.aivy, knZ(), null);
        ((kotlin.l.b.a.b.b.c.ac)localObject3).C((kotlin.l.b.a.b.m.ad)localObject1);
        paramCollection.add(localObject2);
      }
    }
    Object localObject1 = n(paramf);
    if (((Set)localObject1).isEmpty())
    {
      AppMethodBeat.o(57860);
      return;
    }
    Object localObject2 = kotlin.l.b.a.b.o.f.ajtJ;
    localObject2 = f.b.kBe();
    Object localObject3 = kotlin.l.b.a.b.o.f.ajtJ;
    localObject3 = f.b.kBe();
    a((Set)localObject1, paramCollection, (Set)localObject2, (kotlin.g.a.b)new d(this));
    a(kotlin.a.ar.a((Set)localObject1, (Iterable)localObject2), (Collection)localObject3, null, (kotlin.g.a.b)new e(this));
    paramf = kotlin.l.b.a.b.d.a.a.a.a(paramf, (Collection)kotlin.a.ar.b((Set)localObject1, (Iterable)localObject3), paramCollection, this.aiTe, this.aiSh.aiSp.aiRO, this.aiSh.aiSp.aiSb.kAU());
    kotlin.g.b.s.s(paramf, "resolveOverridesForNonSt…rridingUtil\n            )");
    paramCollection.addAll(paramf);
    AppMethodBeat.o(57860);
  }
  
  public final kotlin.l.b.a.b.b.h c(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.c.a.b paramb)
  {
    AppMethodBeat.i(57869);
    kotlin.g.b.s.u(paramf, "name");
    kotlin.g.b.s.u(paramb, "location");
    d(paramf, paramb);
    paramb = (g)this.aiTA;
    if (paramb == null) {}
    for (paramb = null; paramb == null; paramb = (kotlin.l.b.a.b.b.c.g)paramb.aiTj.invoke(paramf))
    {
      paramf = (kotlin.l.b.a.b.b.h)this.aiTj.invoke(paramf);
      AppMethodBeat.o(57869);
      return paramf;
    }
    paramf = (kotlin.l.b.a.b.b.h)paramb;
    AppMethodBeat.o(57869);
    return paramf;
  }
  
  public final void d(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.c.a.b paramb)
  {
    AppMethodBeat.i(57874);
    kotlin.g.b.s.u(paramf, "name");
    kotlin.g.b.s.u(paramb, "location");
    kotlin.l.b.a.b.c.a.a(this.aiSh.aiSp.aiRV, paramb, this.aiTe, paramf);
    AppMethodBeat.o(57874);
  }
  
  protected final as knZ()
  {
    AppMethodBeat.i(57868);
    as localas = kotlin.l.b.a.b.j.d.l((kotlin.l.b.a.b.b.l)this.aiTe);
    AppMethodBeat.o(57868);
    return localas;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57875);
    String str = kotlin.g.b.s.X("Lazy Java member scope for ", this.aiSA.koY());
    AppMethodBeat.o(57875);
    return str;
  }
  
  static final class d
    extends u
    implements kotlin.g.a.b<kotlin.l.b.a.b.f.f, Collection<? extends au>>
  {
    d(g paramg)
    {
      super();
    }
  }
  
  static final class e
    extends u
    implements kotlin.g.a.b<kotlin.l.b.a.b.f.f, Collection<? extends au>>
  {
    e(g paramg)
    {
      super();
    }
  }
  
  static final class f
    extends u
    implements kotlin.g.a.a<List<? extends kotlin.l.b.a.b.b.d>>
  {
    f(g paramg, kotlin.l.b.a.b.d.a.c.h paramh)
    {
      super();
    }
  }
  
  static final class g
    extends u
    implements kotlin.g.a.a<Map<kotlin.l.b.a.b.f.f, ? extends n>>
  {
    g(g paramg)
    {
      super();
    }
  }
  
  static final class h
    extends u
    implements kotlin.g.a.b<kotlin.l.b.a.b.f.f, Collection<? extends au>>
  {
    h(au paramau, g paramg)
    {
      super();
    }
  }
  
  static final class i
    extends u
    implements kotlin.g.a.a<Set<? extends kotlin.l.b.a.b.f.f>>
  {
    i(g paramg)
    {
      super();
    }
  }
  
  static final class j
    extends u
    implements kotlin.g.a.b<kotlin.l.b.a.b.f.f, kotlin.l.b.a.b.b.c.g>
  {
    j(g paramg, kotlin.l.b.a.b.d.a.c.h paramh)
    {
      super();
    }
    
    static final class a
      extends u
      implements kotlin.g.a.a<Set<? extends kotlin.l.b.a.b.f.f>>
    {
      a(g paramg)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.c.a.g
 * JD-Core Version:    0.7.0.1
 */