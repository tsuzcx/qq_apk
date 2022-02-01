package kotlin.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.b.af;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.l.b.a.b.b.a.g.a;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.ap;
import kotlin.l.b.a.b.b.ar;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.au;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.bd;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.b.x;
import kotlin.l.b.a.b.e.a.c;
import kotlin.l.b.a.b.e.a.h;
import kotlin.l.b.a.b.e.a.i;
import kotlin.l.b.a.b.e.a.j;
import kotlin.l.b.a.b.e.a.m;
import kotlin.l.b.a.b.e.a.p;
import kotlin.l.b.a.b.e.a.q;
import kotlin.l.b.a.b.e.a.t;
import kotlin.l.b.a.b.e.a.u.c;
import kotlin.l.b.a.b.e.a.w;
import kotlin.l.b.a.b.e.b.b.c;
import kotlin.l.b.a.b.e.b.h.b;
import kotlin.l.b.a.b.k.a.b.h.a;
import kotlin.l.b.a.b.m.al;

public final class v
{
  private final e aiWm;
  private final l ajmz;
  
  public v(l paraml)
  {
    AppMethodBeat.i(60340);
    this.ajmz = paraml;
    this.aiWm = new e(this.ajmz.aiWx.aiFr, this.ajmz.aiWx.aiBS);
    AppMethodBeat.o(60340);
  }
  
  private final y K(kotlin.l.b.a.b.b.l paraml)
  {
    AppMethodBeat.i(60339);
    if ((paraml instanceof ah))
    {
      paraml = (y)new y.b(((ah)paraml).koY(), this.ajmz.aiyk, this.ajmz.aiyl, (av)this.ajmz.ajmm);
      AppMethodBeat.o(60339);
      return paraml;
    }
    if ((paraml instanceof kotlin.l.b.a.b.k.a.b.e))
    {
      paraml = (y)((kotlin.l.b.a.b.k.a.b.e)paraml).ajnp;
      AppMethodBeat.o(60339);
      return paraml;
    }
    AppMethodBeat.o(60339);
    return null;
  }
  
  private static boolean Y(kotlin.l.b.a.b.m.ad paramad)
  {
    AppMethodBeat.i(192304);
    boolean bool = kotlin.l.b.a.b.m.d.a.a(paramad, (kotlin.g.a.b)a.ajmA);
    AppMethodBeat.o(192304);
    return bool;
  }
  
  private final List<bd> a(List<a.t> paramList, final kotlin.l.b.a.b.h.r paramr, final b paramb)
  {
    AppMethodBeat.i(60338);
    kotlin.l.b.a.b.b.a locala = (kotlin.l.b.a.b.b.a)this.ajmz.aiJT;
    Object localObject1 = locala.knp();
    s.s(localObject1, "callableDescriptor.containingDeclaration");
    final y localy = K((kotlin.l.b.a.b.b.l)localObject1);
    paramList = (Iterable)paramList;
    Collection localCollection = (Collection)new ArrayList(kotlin.a.p.a(paramList, 10));
    final int i = 0;
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      paramList = localIterator.next();
      if (i < 0) {
        kotlin.a.p.kkW();
      }
      localObject1 = (a.t)paramList;
      int j;
      label122:
      kotlin.l.b.a.b.f.f localf;
      label189:
      kotlin.l.b.a.b.m.ad localad;
      Object localObject2;
      boolean bool1;
      boolean bool2;
      boolean bool3;
      if (((a.t)localObject1).ktB())
      {
        j = ((a.t)localObject1).aiYq;
        if (localy == null) {
          break label387;
        }
        paramList = kotlin.l.b.a.b.e.b.b.ajcl.aLV(j);
        s.s(paramList, "HAS_ANNOTATIONS.get(flags)");
        if (!paramList.booleanValue()) {
          break label387;
        }
        paramList = (kotlin.l.b.a.b.b.a.g)new kotlin.l.b.a.b.k.a.b.o(this.ajmz.aiWx.aiBu, (kotlin.g.a.a)new f(this, localy, paramr, paramb, i, (a.t)localObject1));
        localf = w.b(this.ajmz.aiyk, ((a.t)localObject1).aiZC);
        localad = this.ajmz.ajmn.s(kotlin.l.b.a.b.e.b.f.a((a.t)localObject1, this.ajmz.aiyl));
        localObject2 = kotlin.l.b.a.b.e.b.b.ajcP.aLV(j);
        s.s(localObject2, "DECLARES_DEFAULT_VALUE.get(flags)");
        bool1 = ((Boolean)localObject2).booleanValue();
        localObject2 = kotlin.l.b.a.b.e.b.b.ajcQ.aLV(j);
        s.s(localObject2, "IS_CROSSINLINE.get(flags)");
        bool2 = ((Boolean)localObject2).booleanValue();
        localObject2 = kotlin.l.b.a.b.e.b.b.ajcR.aLV(j);
        s.s(localObject2, "IS_NOINLINE.get(flags)");
        bool3 = ((Boolean)localObject2).booleanValue();
        localObject1 = kotlin.l.b.a.b.e.b.f.b((a.t)localObject1, this.ajmz.aiyl);
        if (localObject1 != null) {
          break label398;
        }
      }
      label387:
      label398:
      for (localObject1 = null;; localObject1 = this.ajmz.ajmn.s((a.p)localObject1))
      {
        localObject2 = av.aiHu;
        s.s(localObject2, "NO_SOURCE");
        localCollection.add(new kotlin.l.b.a.b.b.c.ak(locala, null, i, paramList, localf, localad, bool1, bool2, bool3, (kotlin.l.b.a.b.m.ad)localObject1, (av)localObject2));
        i += 1;
        break;
        j = 0;
        break label122;
        paramList = kotlin.l.b.a.b.b.a.g.aiIh;
        paramList = g.a.kpB();
        break label189;
      }
    }
    paramList = kotlin.a.p.p((Iterable)localCollection);
    AppMethodBeat.o(60338);
    return paramList;
  }
  
  private final kotlin.l.b.a.b.b.a.g a(final a.m paramm, final boolean paramBoolean)
  {
    AppMethodBeat.i(60336);
    if (!kotlin.l.b.a.b.e.b.b.ajcl.aLV(paramm.aiYq).booleanValue())
    {
      paramm = kotlin.l.b.a.b.b.a.g.aiIh;
      paramm = g.a.kpB();
      AppMethodBeat.o(60336);
      return paramm;
    }
    paramm = (kotlin.l.b.a.b.b.a.g)new kotlin.l.b.a.b.k.a.b.o(this.ajmz.aiWx.aiBu, (kotlin.g.a.a)new c(this, paramBoolean, paramm));
    AppMethodBeat.o(60336);
    return paramm;
  }
  
  private final kotlin.l.b.a.b.b.a.g a(final kotlin.l.b.a.b.h.r paramr, int paramInt, final b paramb)
  {
    AppMethodBeat.i(60335);
    if (!kotlin.l.b.a.b.e.b.b.ajcl.aLV(paramInt).booleanValue())
    {
      paramr = kotlin.l.b.a.b.b.a.g.aiIh;
      paramr = g.a.kpB();
      AppMethodBeat.o(60335);
      return paramr;
    }
    paramr = (kotlin.l.b.a.b.b.a.g)new kotlin.l.b.a.b.k.a.b.o(this.ajmz.aiWx.aiBu, (kotlin.g.a.a)new b(this, paramr, paramb));
    AppMethodBeat.o(60335);
    return paramr;
  }
  
  private final kotlin.l.b.a.b.b.a.g a(final kotlin.l.b.a.b.h.r paramr, final b paramb)
  {
    AppMethodBeat.i(60337);
    paramr = (kotlin.l.b.a.b.b.a.g)new kotlin.l.b.a.b.k.a.b.b(this.ajmz.aiWx.aiBu, (kotlin.g.a.a)new d(this, paramr, paramb));
    AppMethodBeat.o(60337);
    return paramr;
  }
  
  private final h.a a(kotlin.l.b.a.b.k.a.b.c paramc, as paramas, Collection<? extends bd> paramCollection, Collection<? extends ba> paramCollection1, kotlin.l.b.a.b.m.ad paramad, boolean paramBoolean)
  {
    AppMethodBeat.i(192301);
    if (!a((kotlin.l.b.a.b.k.a.b.h)paramc))
    {
      paramc = h.a.ajnC;
      AppMethodBeat.o(192301);
      return paramc;
    }
    if (s.p(kotlin.l.b.a.b.j.d.a.I((kotlin.l.b.a.b.b.l)paramc), ab.ajmP))
    {
      paramc = h.a.ajnC;
      AppMethodBeat.o(192301);
      return paramc;
    }
    paramCollection = (Iterable)paramCollection;
    paramc = (Collection)new ArrayList(kotlin.a.p.a(paramCollection, 10));
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      paramc.add(((bd)paramCollection.next()).koG());
    }
    paramCollection = (Collection)paramc;
    if (paramas == null)
    {
      paramc = null;
      paramc = kotlin.a.p.b(paramCollection, (Iterable)kotlin.a.p.hs(paramc));
      if ((paramad == null) || (Y(paramad) != true)) {
        break label189;
      }
    }
    label189:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label195;
      }
      paramc = h.a.ajnE;
      AppMethodBeat.o(192301);
      return paramc;
      paramc = paramas.koG();
      break;
    }
    label195:
    paramas = (Iterable)paramCollection1;
    if ((!(paramas instanceof Collection)) || (!((Collection)paramas).isEmpty()))
    {
      paramas = paramas.iterator();
      if (paramas.hasNext())
      {
        paramCollection = ((ba)paramas.next()).klF();
        s.s(paramCollection, "typeParameter.upperBounds");
        paramCollection = (Iterable)paramCollection;
        if ((!(paramCollection instanceof Collection)) || (!((Collection)paramCollection).isEmpty()))
        {
          paramCollection = paramCollection.iterator();
          while (paramCollection.hasNext())
          {
            paramCollection1 = (kotlin.l.b.a.b.m.ad)paramCollection.next();
            s.s(paramCollection1, "it");
            if (Y(paramCollection1))
            {
              i = 1;
              label328:
              if (i == 0) {
                break label357;
              }
            }
          }
        }
      }
    }
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label365;
      }
      paramc = h.a.ajnE;
      AppMethodBeat.o(192301);
      return paramc;
      i = 0;
      break label328;
      label357:
      break;
    }
    label365:
    paramc = (Iterable)paramc;
    paramas = (Collection)new ArrayList(kotlin.a.p.a(paramc, 10));
    paramCollection = paramc.iterator();
    if (paramCollection.hasNext())
    {
      paramc = (kotlin.l.b.a.b.m.ad)paramCollection.next();
      s.s(paramc, "type");
      if ((kotlin.l.b.a.b.a.g.e(paramc)) && (paramc.klR().size() <= 3))
      {
        paramc = (Iterable)paramc.klR();
        if ((!(paramc instanceof Collection)) || (!((Collection)paramc).isEmpty()))
        {
          paramc = paramc.iterator();
          while (paramc.hasNext())
          {
            paramCollection1 = ((kotlin.l.b.a.b.m.az)paramc.next()).koG();
            s.s(paramCollection1, "it.type");
            if (Y(paramCollection1))
            {
              i = 1;
              label518:
              if (i == 0) {
                break label544;
              }
              paramc = h.a.ajnE;
            }
          }
        }
      }
      for (;;)
      {
        paramas.add(paramc);
        break;
        i = 0;
        break label518;
        label544:
        paramc = h.a.ajnD;
        continue;
        if (Y(paramc)) {
          paramc = h.a.ajnE;
        } else {
          paramc = h.a.ajnC;
        }
      }
    }
    paramc = (h.a)kotlin.a.p.x((Iterable)paramas);
    if (paramc == null)
    {
      paramc = h.a.ajnC;
      if (!paramBoolean) {
        break label629;
      }
    }
    label629:
    for (paramas = h.a.ajnD;; paramas = h.a.ajnC)
    {
      paramc = (h.a)kotlin.b.a.c((Comparable)paramas, (Comparable)paramc);
      AppMethodBeat.o(192301);
      return paramc;
      break;
    }
  }
  
  private final h.a a(kotlin.l.b.a.b.k.a.b.h paramh, ac paramac)
  {
    AppMethodBeat.i(192287);
    if (!a(paramh))
    {
      paramh = h.a.ajnC;
      AppMethodBeat.o(192287);
      return paramh;
    }
    a(paramac);
    if (paramac.ajmT)
    {
      paramh = h.a.ajnE;
      AppMethodBeat.o(192287);
      return paramh;
    }
    paramh = h.a.ajnC;
    AppMethodBeat.o(192287);
    return paramh;
  }
  
  private static void a(ac paramac)
  {
    AppMethodBeat.i(192292);
    paramac = ((Iterable)paramac.kAa()).iterator();
    while (paramac.hasNext()) {
      ((ba)paramac.next()).klF();
    }
    AppMethodBeat.o(192292);
  }
  
  private final void a(kotlin.l.b.a.b.k.a.b.l paraml, as paramas1, as paramas2, List<? extends ba> paramList, List<? extends bd> paramList1, kotlin.l.b.a.b.m.ad paramad, kotlin.l.b.a.b.b.ab paramab, t paramt, Map<? extends kotlin.l.b.a.b.b.a.a<?>, ?> paramMap, boolean paramBoolean)
  {
    AppMethodBeat.i(192296);
    paraml.a(paramas1, paramas2, paramList, paramList1, paramad, paramab, paramt, paramMap, a((kotlin.l.b.a.b.k.a.b.c)paraml, paramas1, (Collection)paramList1, (Collection)paramList, paramad, paramBoolean));
    AppMethodBeat.o(192296);
  }
  
  private final boolean a(kotlin.l.b.a.b.k.a.b.h paramh)
  {
    AppMethodBeat.i(192306);
    if (this.ajmz.aiWx.ajlX.kzV())
    {
      paramh = (Iterable)paramh.kAg();
      if ((!(paramh instanceof Collection)) || (!((Collection)paramh).isEmpty()))
      {
        paramh = paramh.iterator();
        if (paramh.hasNext())
        {
          kotlin.l.b.a.b.e.b.h localh = (kotlin.l.b.a.b.e.b.h)paramh.next();
          if ((s.p(localh.ajdd, new h.b())) && (localh.ajde == a.u.c.ajbE))
          {
            i = 1;
            label108:
            if (i == 0) {
              break label129;
            }
          }
        }
      }
      for (int i = 0;; i = 1)
      {
        if (i == 0) {
          break label136;
        }
        AppMethodBeat.o(192306);
        return true;
        i = 0;
        break label108;
        label129:
        break;
      }
    }
    label136:
    AppMethodBeat.o(192306);
    return false;
  }
  
  private static int aMp(int paramInt)
  {
    return (paramInt & 0x3F) + (paramInt >> 8 << 6);
  }
  
  private final as knZ()
  {
    AppMethodBeat.i(60333);
    Object localObject = this.ajmz.aiJT;
    if ((localObject instanceof kotlin.l.b.a.b.b.e)) {}
    for (localObject = (kotlin.l.b.a.b.b.e)localObject; localObject == null; localObject = null)
    {
      AppMethodBeat.o(60333);
      return null;
    }
    localObject = ((kotlin.l.b.a.b.b.e)localObject).kov();
    AppMethodBeat.o(60333);
    return localObject;
  }
  
  public final kotlin.l.b.a.b.b.d a(a.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(60334);
    s.u(paramc, "proto");
    Object localObject1 = (kotlin.l.b.a.b.b.e)this.ajmz.aiJT;
    kotlin.l.b.a.b.k.a.b.d locald = new kotlin.l.b.a.b.k.a.b.d((kotlin.l.b.a.b.b.e)localObject1, a((kotlin.l.b.a.b.h.r)paramc, paramc.aiYq, b.ajlF), paramBoolean, kotlin.l.b.a.b.b.b.a.aiGl, paramc, this.ajmz.aiyk, this.ajmz.aiyl, this.ajmz.ajml, this.ajmz.ajmm);
    Object localObject2 = l.a(this.ajmz, (kotlin.l.b.a.b.b.l)locald, (List)kotlin.a.ab.aivy).ajmo;
    List localList = paramc.aiZl;
    s.s(localList, "proto.valueParameterList");
    locald.a(((v)localObject2).a(localList, (kotlin.l.b.a.b.h.r)paramc, b.ajlF), aa.a(z.ajmO, (a.w)kotlin.l.b.a.b.e.b.b.ajcm.get(paramc.aiYq)));
    locald.B((kotlin.l.b.a.b.m.ad)((kotlin.l.b.a.b.b.e)localObject1).koj());
    label219:
    int i;
    if (!kotlin.l.b.a.b.e.b.b.ajcw.aLV(paramc.aiYq).booleanValue())
    {
      paramBoolean = true;
      locald.Pl(paramBoolean);
      paramc = this.ajmz.aiJT;
      if (!(paramc instanceof kotlin.l.b.a.b.k.a.b.e)) {
        break label302;
      }
      paramc = (kotlin.l.b.a.b.k.a.b.e)paramc;
      if (paramc == null) {
        break label307;
      }
      paramc = paramc.ajmz;
      if (paramc == null) {
        break label307;
      }
      paramc = paramc.ajmn;
      if ((paramc == null) || (paramc.ajmT != true)) {
        break label307;
      }
      i = 1;
      label251:
      if ((i == 0) || (!a((kotlin.l.b.a.b.k.a.b.h)locald))) {
        break label312;
      }
      i = 1;
      label269:
      if (i == 0) {
        break label317;
      }
    }
    for (paramc = h.a.ajnE;; paramc = a(paramc, null, (Collection)localObject1, (Collection)localObject2, locald.kob(), false))
    {
      locald.a(paramc);
      paramc = (kotlin.l.b.a.b.b.d)locald;
      AppMethodBeat.o(60334);
      return paramc;
      paramBoolean = false;
      break;
      label302:
      paramc = null;
      break label219;
      label307:
      i = 0;
      break label251;
      label312:
      i = 0;
      break label269;
      label317:
      paramc = (kotlin.l.b.a.b.k.a.b.c)locald;
      localObject1 = locald.kod();
      s.s(localObject1, "descriptor.valueParameters");
      localObject1 = (Collection)localObject1;
      localObject2 = locald.koa();
      s.s(localObject2, "descriptor.typeParameters");
    }
  }
  
  public final kotlin.l.b.a.b.b.az f(a.q paramq)
  {
    AppMethodBeat.i(60332);
    s.u(paramq, "proto");
    Object localObject1 = kotlin.l.b.a.b.b.a.g.aiIh;
    localObject1 = paramq.ajbc;
    s.s(localObject1, "proto.annotationList");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (kotlin.l.b.a.b.e.a.a)((Iterator)localObject2).next();
      localObject4 = this.aiWm;
      s.s(localObject3, "it");
      ((Collection)localObject1).add(((e)localObject4).b((kotlin.l.b.a.b.e.a.a)localObject3, this.ajmz.aiyk));
    }
    localObject1 = g.a.oS((List)localObject1);
    localObject2 = aa.a(z.ajmO, (a.w)kotlin.l.b.a.b.e.b.b.ajcm.get(paramq.aiYq));
    localObject2 = new kotlin.l.b.a.b.k.a.b.m(this.ajmz.aiWx.aiBu, this.ajmz.aiJT, (kotlin.l.b.a.b.b.a.g)localObject1, w.b(this.ajmz.aiyk, paramq.aiZC), (t)localObject2, paramq, this.ajmz.aiyk, this.ajmz.aiyl, this.ajmz.ajml, this.ajmz.ajmm);
    localObject1 = this.ajmz;
    Object localObject3 = (kotlin.l.b.a.b.b.l)localObject2;
    Object localObject4 = paramq.aiYJ;
    s.s(localObject4, "proto.typeParameterList");
    localObject3 = l.a((l)localObject1, (kotlin.l.b.a.b.b.l)localObject3, (List)localObject4);
    localObject4 = ((l)localObject3).ajmn.kAa();
    ac localac = ((l)localObject3).ajmn;
    localObject1 = this.ajmz.aiyl;
    s.u(paramq, "<this>");
    s.u(localObject1, "typeTable");
    kotlin.l.b.a.b.e.b.g localg;
    if (paramq.kwg())
    {
      localObject1 = paramq.ajaY;
      s.s(localObject1, "underlyingType");
      localObject1 = localac.b((a.p)localObject1, false);
      localac = ((l)localObject3).ajmn;
      localg = this.ajmz.aiyl;
      s.u(paramq, "<this>");
      s.u(localg, "typeTable");
      if (!paramq.kwi()) {
        break label449;
      }
      paramq = paramq.ajba;
      s.s(paramq, "expandedType");
    }
    for (;;)
    {
      ((kotlin.l.b.a.b.k.a.b.m)localObject2).a((List)localObject4, (al)localObject1, localac.b(paramq, false), a((kotlin.l.b.a.b.k.a.b.h)localObject2, ((l)localObject3).ajmn));
      paramq = (kotlin.l.b.a.b.b.az)localObject2;
      AppMethodBeat.o(60332);
      return paramq;
      if (paramq.kwh())
      {
        localObject1 = ((kotlin.l.b.a.b.e.b.g)localObject1).aLZ(paramq.ajaZ);
        break;
      }
      paramq = (Throwable)new IllegalStateException("No underlyingType in ProtoBuf.TypeAlias".toString());
      AppMethodBeat.o(60332);
      throw paramq;
      label449:
      if (!paramq.kwj()) {
        break label469;
      }
      paramq = localg.aLZ(paramq.ajbb);
    }
    label469:
    paramq = (Throwable)new IllegalStateException("No expandedType in ProtoBuf.TypeAlias".toString());
    AppMethodBeat.o(60332);
    throw paramq;
  }
  
  public final ap g(final a.m paramm)
  {
    AppMethodBeat.i(60329);
    s.u(paramm, "proto");
    int i;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    boolean bool1;
    Object localObject6;
    Object localObject7;
    label410:
    label468:
    int j;
    int k;
    if (paramm.ktB())
    {
      i = paramm.aiYq;
      localObject1 = this.ajmz.aiJT;
      localObject2 = a((kotlin.l.b.a.b.h.r)paramm, i, b.ajlG);
      localObject3 = z.ajmO;
      localObject3 = z.a((a.j)kotlin.l.b.a.b.e.b.b.ajcn.get(i));
      localObject4 = aa.a(z.ajmO, (a.w)kotlin.l.b.a.b.e.b.b.ajcm.get(i));
      localObject5 = kotlin.l.b.a.b.e.b.b.ajcG.aLV(i);
      s.s(localObject5, "IS_VAR.get(flags)");
      bool1 = ((Boolean)localObject5).booleanValue();
      localObject5 = w.b(this.ajmz.aiyk, paramm.aiZC);
      localObject6 = aa.a(z.ajmO, (a.i)kotlin.l.b.a.b.e.b.b.ajcx.get(i));
      localObject7 = kotlin.l.b.a.b.e.b.b.ajcK.aLV(i);
      s.s(localObject7, "IS_LATEINIT.get(flags)");
      boolean bool2 = ((Boolean)localObject7).booleanValue();
      localObject7 = kotlin.l.b.a.b.e.b.b.ajcJ.aLV(i);
      s.s(localObject7, "IS_CONST.get(flags)");
      boolean bool3 = ((Boolean)localObject7).booleanValue();
      localObject7 = kotlin.l.b.a.b.e.b.b.ajcM.aLV(i);
      s.s(localObject7, "IS_EXTERNAL_PROPERTY.get(flags)");
      boolean bool4 = ((Boolean)localObject7).booleanValue();
      localObject7 = kotlin.l.b.a.b.e.b.b.ajcN.aLV(i);
      s.s(localObject7, "IS_DELEGATED.get(flags)");
      boolean bool5 = ((Boolean)localObject7).booleanValue();
      localObject7 = kotlin.l.b.a.b.e.b.b.ajcO.aLV(i);
      s.s(localObject7, "IS_EXPECT_PROPERTY.get(flags)");
      localObject3 = new kotlin.l.b.a.b.k.a.b.k((kotlin.l.b.a.b.b.l)localObject1, null, (kotlin.l.b.a.b.b.a.g)localObject2, (kotlin.l.b.a.b.b.ab)localObject3, (t)localObject4, bool1, (kotlin.l.b.a.b.f.f)localObject5, (kotlin.l.b.a.b.b.b.a)localObject6, bool2, bool3, bool4, bool5, ((Boolean)localObject7).booleanValue(), paramm, this.ajmz.aiyk, this.ajmz.aiyl, this.ajmz.ajml, this.ajmz.ajmm);
      localObject1 = this.ajmz;
      localObject2 = (kotlin.l.b.a.b.b.l)localObject3;
      localObject4 = paramm.aiYJ;
      s.s(localObject4, "proto.typeParameterList");
      localObject4 = l.a((l)localObject1, (kotlin.l.b.a.b.b.l)localObject2, (List)localObject4);
      localObject1 = kotlin.l.b.a.b.e.b.b.ajcH.aLV(i);
      s.s(localObject1, "HAS_GETTER.get(flags)");
      bool1 = ((Boolean)localObject1).booleanValue();
      if ((!bool1) || (!kotlin.l.b.a.b.e.b.f.e(paramm))) {
        break label1152;
      }
      localObject1 = a((kotlin.l.b.a.b.h.r)paramm, b.ajlH);
      localObject2 = ((l)localObject4).ajmn.s(kotlin.l.b.a.b.e.b.f.a(paramm, this.ajmz.aiyl));
      localObject5 = ((l)localObject4).ajmn.kAa();
      localObject6 = knZ();
      localObject7 = kotlin.l.b.a.b.e.b.f.b(paramm, this.ajmz.aiyl);
      if (localObject7 != null) {
        break label1165;
      }
      localObject1 = null;
      ((kotlin.l.b.a.b.k.a.b.k)localObject3).a((kotlin.l.b.a.b.m.ad)localObject2, (List)localObject5, (as)localObject6, (as)localObject1);
      localObject1 = kotlin.l.b.a.b.e.b.b.ajcl.aLV(i);
      s.s(localObject1, "HAS_ANNOTATIONS.get(flags)");
      j = kotlin.l.b.a.b.e.b.b.a(((Boolean)localObject1).booleanValue(), (a.w)kotlin.l.b.a.b.e.b.b.ajcm.get(i), (a.j)kotlin.l.b.a.b.e.b.b.ajcn.get(i));
      if (!bool1) {
        break label1240;
      }
      if (!paramm.kvm()) {
        break label1205;
      }
      k = paramm.ajan;
      label544:
      localObject1 = kotlin.l.b.a.b.e.b.b.ajcS.aLV(k);
      s.s(localObject1, "IS_NOT_DEFAULT.get(getterFlags)");
      bool1 = ((Boolean)localObject1).booleanValue();
      localObject1 = kotlin.l.b.a.b.e.b.b.ajcT.aLV(k);
      s.s(localObject1, "IS_EXTERNAL_ACCESSOR.get(getterFlags)");
      bool2 = ((Boolean)localObject1).booleanValue();
      localObject1 = kotlin.l.b.a.b.e.b.b.ajcU.aLV(k);
      s.s(localObject1, "IS_INLINE_ACCESSOR.get(getterFlags)");
      bool3 = ((Boolean)localObject1).booleanValue();
      localObject1 = a((kotlin.l.b.a.b.h.r)paramm, k, b.ajlH);
      if (!bool1) {
        break label1217;
      }
      localObject2 = (ap)localObject3;
      localObject5 = z.ajmO;
      localObject5 = z.a((a.j)kotlin.l.b.a.b.e.b.b.ajcn.get(k));
      localObject6 = aa.a(z.ajmO, (a.w)kotlin.l.b.a.b.e.b.b.ajcm.get(k));
      if (bool1) {
        break label1211;
      }
      bool1 = true;
      label694:
      localObject1 = new kotlin.l.b.a.b.b.c.ac((ap)localObject2, (kotlin.l.b.a.b.b.a.g)localObject1, (kotlin.l.b.a.b.b.ab)localObject5, (t)localObject6, bool1, bool2, bool3, ((kotlin.l.b.a.b.k.a.b.k)localObject3).koh(), null, av.aiHu);
      label726:
      ((kotlin.l.b.a.b.b.c.ac)localObject1).C(((kotlin.l.b.a.b.k.a.b.k)localObject3).kob());
      localObject2 = localObject1;
      label740:
      localObject1 = kotlin.l.b.a.b.e.b.b.ajcI.aLV(i);
      s.s(localObject1, "HAS_SETTER.get(flags)");
      if (!((Boolean)localObject1).booleanValue()) {
        break label1287;
      }
      if (paramm.kvn()) {
        j = paramm.ajao;
      }
      localObject1 = kotlin.l.b.a.b.e.b.b.ajcS.aLV(j);
      s.s(localObject1, "IS_NOT_DEFAULT.get(setterFlags)");
      bool1 = ((Boolean)localObject1).booleanValue();
      localObject1 = kotlin.l.b.a.b.e.b.b.ajcT.aLV(j);
      s.s(localObject1, "IS_EXTERNAL_ACCESSOR.get(setterFlags)");
      bool2 = ((Boolean)localObject1).booleanValue();
      localObject1 = kotlin.l.b.a.b.e.b.b.ajcU.aLV(j);
      s.s(localObject1, "IS_INLINE_ACCESSOR.get(setterFlags)");
      bool3 = ((Boolean)localObject1).booleanValue();
      localObject1 = a((kotlin.l.b.a.b.h.r)paramm, j, b.ajlI);
      if (!bool1) {
        break label1252;
      }
      localObject5 = (ap)localObject3;
      localObject6 = z.ajmO;
      localObject6 = z.a((a.j)kotlin.l.b.a.b.e.b.b.ajcn.get(j));
      localObject7 = aa.a(z.ajmO, (a.w)kotlin.l.b.a.b.e.b.b.ajcm.get(j));
      if (bool1) {
        break label1246;
      }
      bool1 = true;
      label921:
      localObject1 = new kotlin.l.b.a.b.b.c.ad((ap)localObject5, (kotlin.l.b.a.b.b.a.g)localObject1, (kotlin.l.b.a.b.b.ab)localObject6, (t)localObject7, bool1, bool2, bool3, ((kotlin.l.b.a.b.k.a.b.k)localObject3).koh(), null, av.aiHu);
      ((kotlin.l.b.a.b.b.c.ad)localObject1).a((bd)kotlin.a.p.oO(l.a((l)localObject4, (kotlin.l.b.a.b.b.l)localObject1, (List)kotlin.a.ab.aivy).ajmo.a(kotlin.a.p.listOf(paramm.ajam), (kotlin.l.b.a.b.h.r)paramm, b.ajlI)));
    }
    for (;;)
    {
      localObject5 = kotlin.l.b.a.b.e.b.b.ajcL.aLV(i);
      s.s(localObject5, "HAS_CONSTANT.get(flags)");
      if (((Boolean)localObject5).booleanValue()) {
        ((kotlin.l.b.a.b.k.a.b.k)localObject3).a(this.ajmz.aiWx.aiBu.cr((kotlin.g.a.a)new e(this, paramm, (kotlin.l.b.a.b.k.a.b.k)localObject3)));
      }
      ((kotlin.l.b.a.b.k.a.b.k)localObject3).a((kotlin.l.b.a.b.b.c.ac)localObject2, (ar)localObject1, (kotlin.l.b.a.b.b.v)new kotlin.l.b.a.b.b.c.o(a(paramm, false), (ap)localObject3), (kotlin.l.b.a.b.b.v)new kotlin.l.b.a.b.b.c.o(a(paramm, true), (ap)localObject3), a((kotlin.l.b.a.b.k.a.b.h)localObject3, ((l)localObject4).ajmn));
      paramm = (ap)localObject3;
      AppMethodBeat.o(60329);
      return paramm;
      i = aMp(paramm.aiZP);
      break;
      label1152:
      localObject1 = kotlin.l.b.a.b.b.a.g.aiIh;
      localObject1 = g.a.kpB();
      break label410;
      label1165:
      localObject7 = ((l)localObject4).ajmn.s((a.p)localObject7);
      if (localObject7 == null)
      {
        localObject1 = null;
        break label468;
      }
      localObject1 = kotlin.l.b.a.b.j.c.a((kotlin.l.b.a.b.b.a)localObject3, (kotlin.l.b.a.b.m.ad)localObject7, (kotlin.l.b.a.b.b.a.g)localObject1);
      break label468;
      label1205:
      k = j;
      break label544;
      label1211:
      bool1 = false;
      break label694;
      label1217:
      localObject1 = kotlin.l.b.a.b.j.c.a((ap)localObject3, (kotlin.l.b.a.b.b.a.g)localObject1);
      s.s(localObject1, "{\n                Descri…nnotations)\n            }");
      break label726;
      label1240:
      localObject2 = null;
      break label740;
      label1246:
      bool1 = false;
      break label921;
      label1252:
      localObject5 = (ap)localObject3;
      localObject6 = kotlin.l.b.a.b.b.a.g.aiIh;
      localObject1 = kotlin.l.b.a.b.j.c.a((ap)localObject5, (kotlin.l.b.a.b.b.a.g)localObject1, g.a.kpB());
      s.s(localObject1, "{\n                Descri…          )\n            }");
      continue;
      label1287:
      localObject1 = null;
    }
  }
  
  public final au g(a.h paramh)
  {
    AppMethodBeat.i(60331);
    s.u(paramh, "proto");
    int i;
    Object localObject3;
    Object localObject1;
    label59:
    Object localObject2;
    label105:
    Object localObject4;
    if (paramh.ktB())
    {
      i = paramh.aiYq;
      localObject3 = a((kotlin.l.b.a.b.h.r)paramh, i, b.ajlF);
      if (!kotlin.l.b.a.b.e.b.f.f(paramh)) {
        break label686;
      }
      localObject1 = a((kotlin.l.b.a.b.h.r)paramh, b.ajlF);
      if (!s.p(kotlin.l.b.a.b.j.d.a.o(this.ajmz.aiJT).q(w.b(this.ajmz.aiyk, paramh.aiZC)), ab.ajmP)) {
        break label699;
      }
      localObject2 = kotlin.l.b.a.b.e.b.i.ajdj;
      localObject2 = kotlin.l.b.a.b.e.b.i.kwY();
      localObject2 = new kotlin.l.b.a.b.k.a.b.l(this.ajmz.aiJT, (kotlin.l.b.a.b.b.a.g)localObject3, w.b(this.ajmz.aiyk, paramh.aiZC), aa.a(z.ajmO, (a.i)kotlin.l.b.a.b.e.b.b.ajcx.get(i)), paramh, this.ajmz.aiyk, this.ajmz.aiyl, (kotlin.l.b.a.b.e.b.i)localObject2, this.ajmz.ajmm);
      localObject3 = this.ajmz;
      localObject4 = (kotlin.l.b.a.b.b.l)localObject2;
      List localList = paramh.aiYJ;
      s.s(localList, "proto.typeParameterList");
      localObject3 = l.a((l)localObject3, (kotlin.l.b.a.b.b.l)localObject4, localList);
      localObject4 = kotlin.l.b.a.b.e.b.f.b(paramh, this.ajmz.aiyl);
      if (localObject4 != null) {
        break label711;
      }
      localObject1 = null;
      label236:
      localObject4 = knZ();
      localList = ((l)localObject3).ajmn.kAa();
      Object localObject5 = ((l)localObject3).ajmo;
      Object localObject6 = paramh.aiZl;
      s.s(localObject6, "proto.valueParameterList");
      localObject5 = ((v)localObject5).a((List)localObject6, (kotlin.l.b.a.b.h.r)paramh, b.ajlF);
      localObject6 = ((l)localObject3).ajmn.s(kotlin.l.b.a.b.e.b.f.a(paramh, this.ajmz.aiyl));
      Object localObject7 = z.ajmO;
      localObject7 = z.a((a.j)kotlin.l.b.a.b.e.b.b.ajcn.get(i));
      t localt = aa.a(z.ajmO, (a.w)kotlin.l.b.a.b.e.b.b.ajcm.get(i));
      Map localMap = kotlin.a.ak.kkZ();
      Boolean localBoolean = kotlin.l.b.a.b.e.b.b.ajcD.aLV(i);
      s.s(localBoolean, "IS_SUSPEND.get(flags)");
      a((kotlin.l.b.a.b.k.a.b.l)localObject2, (as)localObject1, (as)localObject4, localList, (List)localObject5, (kotlin.l.b.a.b.m.ad)localObject6, (kotlin.l.b.a.b.b.ab)localObject7, localt, localMap, localBoolean.booleanValue());
      localObject1 = kotlin.l.b.a.b.e.b.b.ajcy.aLV(i);
      s.s(localObject1, "IS_OPERATOR.get(flags)");
      ((kotlin.l.b.a.b.b.c.p)localObject2).aiKr = ((Boolean)localObject1).booleanValue();
      localObject1 = kotlin.l.b.a.b.e.b.b.ajcz.aLV(i);
      s.s(localObject1, "IS_INFIX.get(flags)");
      ((kotlin.l.b.a.b.b.c.p)localObject2).aiKs = ((Boolean)localObject1).booleanValue();
      localObject1 = kotlin.l.b.a.b.e.b.b.ajcC.aLV(i);
      s.s(localObject1, "IS_EXTERNAL_FUNCTION.get(flags)");
      ((kotlin.l.b.a.b.b.c.p)localObject2).aiJU = ((Boolean)localObject1).booleanValue();
      localObject1 = kotlin.l.b.a.b.e.b.b.ajcA.aLV(i);
      s.s(localObject1, "IS_INLINE.get(flags)");
      ((kotlin.l.b.a.b.b.c.p)localObject2).aiKt = ((Boolean)localObject1).booleanValue();
      localObject1 = kotlin.l.b.a.b.e.b.b.ajcB.aLV(i);
      s.s(localObject1, "IS_TAILREC.get(flags)");
      ((kotlin.l.b.a.b.b.c.p)localObject2).aiKu = ((Boolean)localObject1).booleanValue();
      localObject1 = kotlin.l.b.a.b.e.b.b.ajcD.aLV(i);
      s.s(localObject1, "IS_SUSPEND.get(flags)");
      ((kotlin.l.b.a.b.b.c.p)localObject2).aiKz = ((Boolean)localObject1).booleanValue();
      localObject1 = kotlin.l.b.a.b.e.b.b.ajcE.aLV(i);
      s.s(localObject1, "IS_EXPECT_FUNCTION.get(flags)");
      ((kotlin.l.b.a.b.b.c.p)localObject2).aiKv = ((Boolean)localObject1).booleanValue();
      if (kotlin.l.b.a.b.e.b.b.ajcF.aLV(i).booleanValue()) {
        break label751;
      }
    }
    label686:
    label699:
    label711:
    label751:
    for (boolean bool = true;; bool = false)
    {
      ((kotlin.l.b.a.b.k.a.b.l)localObject2).Pl(bool);
      paramh = this.ajmz.aiWx.ajme.a(paramh, (x)localObject2, this.ajmz.aiyl, ((l)localObject3).ajmn);
      if (paramh != null) {
        ((kotlin.l.b.a.b.k.a.b.l)localObject2).a((kotlin.l.b.a.b.b.a.a)paramh.bsC, paramh.bsD);
      }
      paramh = (au)localObject2;
      AppMethodBeat.o(60331);
      return paramh;
      i = aMp(paramh.aiZP);
      break;
      localObject1 = kotlin.l.b.a.b.b.a.g.aiIh;
      localObject1 = g.a.kpB();
      break label59;
      localObject2 = this.ajmz.ajml;
      break label105;
      localObject4 = ((l)localObject3).ajmn.s((a.p)localObject4);
      if (localObject4 == null)
      {
        localObject1 = null;
        break label236;
      }
      localObject1 = kotlin.l.b.a.b.j.c.a((kotlin.l.b.a.b.b.a)localObject2, (kotlin.l.b.a.b.m.ad)localObject4, (kotlin.l.b.a.b.b.a.g)localObject1);
      break label236;
    }
  }
  
  static final class b
    extends u
    implements kotlin.g.a.a<List<? extends kotlin.l.b.a.b.b.a.c>>
  {
    b(v paramv, kotlin.l.b.a.b.h.r paramr, b paramb)
    {
      super();
    }
  }
  
  static final class c
    extends u
    implements kotlin.g.a.a<List<? extends kotlin.l.b.a.b.b.a.c>>
  {
    c(v paramv, boolean paramBoolean, a.m paramm)
    {
      super();
    }
  }
  
  static final class d
    extends u
    implements kotlin.g.a.a<List<? extends kotlin.l.b.a.b.b.a.c>>
  {
    d(v paramv, kotlin.l.b.a.b.h.r paramr, b paramb)
    {
      super();
    }
  }
  
  static final class e
    extends u
    implements kotlin.g.a.a<kotlin.l.b.a.b.j.b.g<?>>
  {
    e(v paramv, a.m paramm, kotlin.l.b.a.b.k.a.b.k paramk)
    {
      super();
    }
  }
  
  static final class f
    extends u
    implements kotlin.g.a.a<List<? extends kotlin.l.b.a.b.b.a.c>>
  {
    f(v paramv, y paramy, kotlin.l.b.a.b.h.r paramr, b paramb, int paramInt, a.t paramt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.v
 * JD-Core Version:    0.7.0.1
 */