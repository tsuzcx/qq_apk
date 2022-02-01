package kotlin.l.b.a.b.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.a.ar;
import kotlin.a.p;
import kotlin.g.b.af;
import kotlin.g.b.ah.f;
import kotlin.g.b.ai;
import kotlin.g.b.u;
import kotlin.l.b.a.b.b.ac;
import kotlin.l.b.a.b.b.ae;
import kotlin.l.b.a.b.b.au;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.bd;
import kotlin.l.b.a.b.b.bi;
import kotlin.l.b.a.b.b.c.y;
import kotlin.l.b.a.b.b.k;
import kotlin.l.b.a.b.b.r;
import kotlin.l.b.a.b.b.x;
import kotlin.l.b.a.b.b.x.a;
import kotlin.l.b.a.b.d.b.v;
import kotlin.l.b.a.b.e.a.b;
import kotlin.l.b.a.b.e.a.h;
import kotlin.l.b.a.b.j.g.h.c;
import kotlin.l.b.a.b.j.j.a.a;
import kotlin.l.b.a.b.k.a.w;
import kotlin.l.b.a.b.l.m;
import kotlin.l.b.a.b.m.al;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.ay;
import kotlin.l.b.a.b.m.be;
import kotlin.l.b.a.b.o.b.b;
import kotlin.l.b.a.b.o.b.c;
import kotlin.l.o;

public final class g
  implements kotlin.l.b.a.b.b.b.a, kotlin.l.b.a.b.b.b.c
{
  private final d aiFM;
  private final kotlin.l.b.a.b.l.h aiFN;
  private final kotlin.l.b.a.b.m.ad aiFO;
  private final kotlin.l.b.a.b.l.h aiFP;
  private final kotlin.l.b.a.b.l.a<kotlin.l.b.a.b.f.c, kotlin.l.b.a.b.b.e> aiFQ;
  private final kotlin.l.b.a.b.l.h aiFR;
  private final ae aiFr;
  
  static
  {
    AppMethodBeat.i(191488);
    aYe = new o[] { (o)ai.a((af)new kotlin.g.b.ag((kotlin.l.e)ai.cz(g.class), "settings", "getSettings()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltIns$Settings;")), (o)ai.a((af)new kotlin.g.b.ag((kotlin.l.e)ai.cz(g.class), "cloneableType", "getCloneableType()Lorg/jetbrains/kotlin/types/SimpleType;")), (o)ai.a((af)new kotlin.g.b.ag((kotlin.l.e)ai.cz(g.class), "notConsideredDeprecation", "getNotConsideredDeprecation()Lorg/jetbrains/kotlin/descriptors/annotations/Annotations;")) };
    AppMethodBeat.o(191488);
  }
  
  public g(ae paramae, final m paramm, kotlin.g.a.a<f.b> parama)
  {
    AppMethodBeat.i(191447);
    this.aiFr = paramae;
    this.aiFM = d.aiFp;
    this.aiFN = paramm.cq(parama);
    paramae = new d(this.aiFr, new kotlin.l.b.a.b.f.c("java.io"));
    parama = p.listOf(new kotlin.l.b.a.b.m.ag(paramm, (kotlin.g.a.a)new e(this)));
    paramae = new kotlin.l.b.a.b.b.c.h((kotlin.l.b.a.b.b.l)paramae, kotlin.l.b.a.b.f.f.bJe("Serializable"), kotlin.l.b.a.b.b.ab.aiHb, kotlin.l.b.a.b.b.f.aiGu, (Collection)parama, av.aiHu, paramm);
    paramae.a((kotlin.l.b.a.b.j.g.h)h.c.ajlm, (Set)kotlin.a.ad.aivA, null);
    paramae = paramae.koj();
    kotlin.g.b.s.s(paramae, "mockSerializableClass.defaultType");
    this.aiFO = ((kotlin.l.b.a.b.m.ad)paramae);
    this.aiFP = paramm.cq((kotlin.g.a.a)new c(this, paramm));
    this.aiFQ = paramm.kAu();
    this.aiFR = paramm.cq((kotlin.g.a.a)new l(this));
    AppMethodBeat.o(191447);
  }
  
  private final f.b knM()
  {
    AppMethodBeat.i(191452);
    f.b localb = (f.b)kotlin.l.b.a.b.l.l.a(this.aiFN, aYe[0]);
    AppMethodBeat.o(191452);
    return localb;
  }
  
  private final al knN()
  {
    AppMethodBeat.i(191454);
    al localal = (al)kotlin.l.b.a.b.l.l.a(this.aiFP, aYe[1]);
    AppMethodBeat.o(191454);
    return localal;
  }
  
  private final kotlin.l.b.a.b.b.a.g knO()
  {
    AppMethodBeat.i(191460);
    kotlin.l.b.a.b.b.a.g localg = (kotlin.l.b.a.b.b.a.g)kotlin.l.b.a.b.l.l.a(this.aiFR, aYe[2]);
    AppMethodBeat.o(191460);
    return localg;
  }
  
  private final kotlin.l.b.a.b.d.a.c.a.f l(kotlin.l.b.a.b.b.e parame)
  {
    AppMethodBeat.i(191465);
    if (kotlin.l.b.a.b.a.h.f(parame))
    {
      AppMethodBeat.o(191465);
      return null;
    }
    if (!kotlin.l.b.a.b.a.h.d((kotlin.l.b.a.b.b.l)parame))
    {
      AppMethodBeat.o(191465);
      return null;
    }
    parame = kotlin.l.b.a.b.j.d.a.q((kotlin.l.b.a.b.b.l)parame);
    if (!parame.kxW())
    {
      AppMethodBeat.o(191465);
      return null;
    }
    c localc = c.aiEX;
    parame = c.c(parame);
    if (parame == null) {}
    for (parame = null; parame == null; parame = parame.kxQ())
    {
      AppMethodBeat.o(191465);
      return null;
    }
    parame = r.a(knM().aiFH, parame, (kotlin.l.b.a.b.c.a.b)kotlin.l.b.a.b.c.a.d.aiNy);
    if ((parame instanceof kotlin.l.b.a.b.d.a.c.a.f))
    {
      parame = (kotlin.l.b.a.b.d.a.c.a.f)parame;
      AppMethodBeat.o(191465);
      return parame;
    }
    AppMethodBeat.o(191465);
    return null;
  }
  
  public final Collection<au> a(kotlin.l.b.a.b.f.f paramf, kotlin.l.b.a.b.b.e parame)
  {
    AppMethodBeat.i(191497);
    kotlin.g.b.s.u(paramf, "name");
    kotlin.g.b.s.u(parame, "classDescriptor");
    Object localObject1 = a.aiET;
    int i;
    if ((kotlin.g.b.s.p(paramf, a.knD())) && ((parame instanceof kotlin.l.b.a.b.k.a.b.e)) && (kotlin.l.b.a.b.a.h.c(parame)))
    {
      localObject1 = ((kotlin.l.b.a.b.k.a.b.e)parame).ajlM.aiYQ;
      kotlin.g.b.s.s(localObject1, "classDescriptor.classProto.functionList");
      localObject1 = (Iterable)localObject1;
      if ((!(localObject1 instanceof Collection)) || (!((Collection)localObject1).isEmpty()))
      {
        localObject1 = ((Iterable)localObject1).iterator();
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (a.h)((Iterator)localObject1).next();
          localObject2 = w.b(((kotlin.l.b.a.b.k.a.b.e)parame).ajmz.aiyk, ((a.h)localObject2).aiZC);
          localObject3 = a.aiET;
        } while (!kotlin.g.b.s.p(localObject2, a.knD()));
      }
      for (i = 1; i != 0; i = 0)
      {
        paramf = (Collection)kotlin.a.ab.aivy;
        AppMethodBeat.o(191497);
        return paramf;
      }
      parame = (kotlin.l.b.a.b.k.a.b.e)parame;
      paramf = ((au)p.i((Iterable)knN().knP().b(paramf, (kotlin.l.b.a.b.c.a.b)kotlin.l.b.a.b.c.a.d.aiNy))).koO();
      paramf.h((kotlin.l.b.a.b.b.l)parame);
      paramf.d(kotlin.l.b.a.b.b.s.aiGG);
      paramf.z((kotlin.l.b.a.b.m.ad)parame.koj());
      paramf.b(parame.kov());
      paramf = paramf.koU();
      kotlin.g.b.s.checkNotNull(paramf);
      paramf = (Collection)p.listOf((au)paramf);
      AppMethodBeat.o(191497);
      return paramf;
    }
    if (!knM().aiFI)
    {
      paramf = (Collection)kotlin.a.ab.aivy;
      AppMethodBeat.o(191497);
      return paramf;
    }
    localObject1 = (kotlin.g.a.b)new g(paramf);
    Object localObject2 = l(parame);
    if (localObject2 == null) {
      paramf = (Collection)kotlin.a.ab.aivy;
    }
    for (;;)
    {
      paramf = (Iterable)paramf;
      localObject1 = (Collection)new ArrayList();
      localObject2 = paramf.iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label1377;
      }
      localObject3 = (au)((Iterator)localObject2).next();
      paramf = ((au)localObject3).c(j.a((kotlin.l.b.a.b.b.e)((au)localObject3).knp(), parame).kAO());
      if (paramf != null) {
        break;
      }
      paramf = new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.SimpleFunctionDescriptor");
      AppMethodBeat.o(191497);
      throw paramf;
      localObject3 = kotlin.l.b.a.b.j.d.a.o((kotlin.l.b.a.b.b.l)localObject2);
      paramf = b.aiEV;
      paramf = b.knE();
      kotlin.g.b.s.u(localObject3, "fqName");
      kotlin.g.b.s.u(paramf, "builtIns");
      localObject3 = d.a((kotlin.l.b.a.b.f.c)localObject3, paramf);
      if (localObject3 == null) {
        paramf = (Collection)kotlin.a.ad.aivA;
      }
      for (;;)
      {
        localObject3 = (kotlin.l.b.a.b.b.e)p.h((Iterable)paramf);
        if (localObject3 != null) {
          break label624;
        }
        paramf = (Collection)kotlin.a.ab.aivy;
        break;
        localObject4 = c.aiEX;
        localObject4 = c.e(kotlin.l.b.a.b.j.d.a.q((kotlin.l.b.a.b.b.l)localObject3));
        if (localObject4 == null)
        {
          paramf = (Collection)ar.setOf(localObject3);
        }
        else
        {
          paramf = paramf.a((kotlin.l.b.a.b.f.c)localObject4);
          kotlin.g.b.s.s(paramf, "builtIns.getBuiltInClass…otlinMutableAnalogFqName)");
          paramf = (Collection)p.listOf(new kotlin.l.b.a.b.b.e[] { localObject3, paramf });
        }
      }
      label624:
      localObject4 = kotlin.l.b.a.b.o.f.ajtJ;
      localObject4 = (Iterable)paramf;
      paramf = (Collection)new ArrayList(p.a((Iterable)localObject4, 10));
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext()) {
        paramf.add(kotlin.l.b.a.b.j.d.a.o((kotlin.l.b.a.b.b.l)((Iterator)localObject4).next()));
      }
      localObject4 = (Collection)paramf;
      kotlin.g.b.s.u(localObject4, "set");
      paramf = new kotlin.l.b.a.b.o.f((byte)0);
      paramf.addAll((Collection)localObject4);
      boolean bool2 = d.h(parame);
      localObject2 = ((kotlin.l.b.a.b.b.e)this.aiFQ.e(kotlin.l.b.a.b.j.d.a.o((kotlin.l.b.a.b.b.l)localObject2), (kotlin.g.a.a)new f((kotlin.l.b.a.b.d.a.c.a.f)localObject2, (kotlin.l.b.a.b.b.e)localObject3))).kot();
      kotlin.g.b.s.s(localObject2, "fakeJavaClassDescriptor.unsubstitutedMemberScope");
      localObject2 = (Iterable)((kotlin.g.a.b)localObject1).invoke(localObject2);
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      label982:
      label1120:
      label1123:
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        localObject4 = (au)localObject3;
        boolean bool1;
        if ((((au)localObject4).koh() == kotlin.l.b.a.b.b.b.a.aiGl) && (((au)localObject4).knc().koB().aiHL) && (!kotlin.l.b.a.b.a.h.g((kotlin.l.b.a.b.b.l)localObject4)))
        {
          localObject5 = ((au)localObject4).kof();
          kotlin.g.b.s.s(localObject5, "analogueMember.overriddenDescriptors");
          localObject5 = (Iterable)localObject5;
          if (!((Collection)localObject5).isEmpty())
          {
            localObject5 = ((Iterable)localObject5).iterator();
            while (((Iterator)localObject5).hasNext())
            {
              Object localObject6 = ((x)((Iterator)localObject5).next()).knp();
              kotlin.g.b.s.s(localObject6, "it.containingDeclaration");
              if (paramf.contains(kotlin.l.b.a.b.j.d.a.o((kotlin.l.b.a.b.b.l)localObject6)))
              {
                i = 1;
                if (i != 0) {
                  break label1120;
                }
                localObject5 = (kotlin.l.b.a.b.b.e)((au)localObject4).knp();
                localObject6 = kotlin.l.b.a.b.d.b.t.a((x)localObject4, false, false, 3);
                i locali = i.aiGe;
                if (!(i.knU().contains(kotlin.l.b.a.b.d.b.s.a(v.aiXe, (kotlin.l.b.a.b.b.e)localObject5, (String)localObject6)) ^ bool2)) {
                  break label1072;
                }
                bool1 = true;
                if (bool1) {
                  break label1120;
                }
              }
            }
          }
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label1123;
          }
          ((Collection)localObject1).add(localObject3);
          break;
          i = 0;
          break label982;
          localObject4 = kotlin.l.b.a.b.o.b.a((Collection)p.listOf(localObject4), (b.b)j.aiGc, (kotlin.g.a.b)new k(this));
          kotlin.g.b.s.s(localObject4, "private fun SimpleFuncti…scriptor)\n        }\n    }");
          bool1 = ((Boolean)localObject4).booleanValue();
          break label1043;
        }
      }
      label1043:
      label1072:
      paramf = (Collection)localObject1;
    }
    paramf = ((au)paramf).koO();
    paramf.h((kotlin.l.b.a.b.b.l)parame);
    paramf.b(parame.kov());
    paramf.koQ();
    Object localObject4 = (x)localObject3;
    Object localObject3 = (kotlin.l.b.a.b.b.e)((x)localObject4).knp();
    localObject4 = kotlin.l.b.a.b.d.b.t.a((x)localObject4, false, false, 3);
    Object localObject5 = new ah.f();
    localObject3 = kotlin.l.b.a.b.o.b.a((Collection)p.listOf(localObject3), (b.b)new h(this), (b.c)new i((String)localObject4, (ah.f)localObject5));
    kotlin.g.b.s.s(localObject3, "private fun FunctionDesc…ERED\n            })\n    }");
    localObject3 = (a)localObject3;
    switch (b.$EnumSwitchMapping$0[localObject3.ordinal()])
    {
    default: 
      label1304:
      paramf = paramf.koU();
      kotlin.g.b.s.checkNotNull(paramf);
      paramf = (au)paramf;
    }
    while (paramf != null)
    {
      ((Collection)localObject1).add(paramf);
      break;
      if (ac.o(parame))
      {
        paramf = null;
      }
      else
      {
        paramf.koT();
        break label1304;
        paramf.a(knO());
        break label1304;
        paramf = null;
      }
    }
    label1377:
    paramf = (Collection)localObject1;
    AppMethodBeat.o(191497);
    return paramf;
  }
  
  public final boolean a(kotlin.l.b.a.b.b.e parame, au paramau)
  {
    AppMethodBeat.i(191504);
    kotlin.g.b.s.u(parame, "classDescriptor");
    kotlin.g.b.s.u(paramau, "functionDescriptor");
    Object localObject = l(parame);
    if (localObject == null)
    {
      AppMethodBeat.o(191504);
      return true;
    }
    if (!paramau.knl().i(kotlin.l.b.a.b.b.b.d.kpC()))
    {
      AppMethodBeat.o(191504);
      return true;
    }
    if (!knM().aiFI)
    {
      AppMethodBeat.o(191504);
      return false;
    }
    parame = kotlin.l.b.a.b.d.b.t.a((x)paramau, false, false, 3);
    localObject = ((kotlin.l.b.a.b.d.a.c.a.f)localObject).ksp();
    paramau = paramau.kok();
    kotlin.g.b.s.s(paramau, "functionDescriptor.name");
    paramau = (Iterable)((kotlin.l.b.a.b.d.a.c.a.g)localObject).b(paramau, (kotlin.l.b.a.b.c.a.b)kotlin.l.b.a.b.c.a.d.aiNy);
    if ((!(paramau instanceof Collection)) || (!((Collection)paramau).isEmpty()))
    {
      paramau = paramau.iterator();
      while (paramau.hasNext()) {
        if (kotlin.g.b.s.p(kotlin.l.b.a.b.d.b.t.a((x)paramau.next(), false, false, 3), parame))
        {
          AppMethodBeat.o(191504);
          return true;
        }
      }
    }
    AppMethodBeat.o(191504);
    return false;
  }
  
  public final Collection<kotlin.l.b.a.b.m.ad> k(kotlin.l.b.a.b.b.e parame)
  {
    AppMethodBeat.i(191492);
    kotlin.g.b.s.u(parame, "classDescriptor");
    parame = kotlin.l.b.a.b.j.d.a.q((kotlin.l.b.a.b.b.l)parame);
    i locali = i.aiGe;
    if (i.i(parame))
    {
      parame = knN();
      kotlin.g.b.s.s(parame, "cloneableType");
      parame = (Collection)p.listOf(new kotlin.l.b.a.b.m.ad[] { (kotlin.l.b.a.b.m.ad)parame, this.aiFO });
      AppMethodBeat.o(191492);
      return parame;
    }
    locali = i.aiGe;
    if (i.h(parame))
    {
      parame = (Collection)p.listOf(this.aiFO);
      AppMethodBeat.o(191492);
      return parame;
    }
    parame = (Collection)kotlin.a.ab.aivy;
    AppMethodBeat.o(191492);
    return parame;
  }
  
  public final Collection<kotlin.l.b.a.b.b.d> m(kotlin.l.b.a.b.b.e parame)
  {
    AppMethodBeat.i(191500);
    kotlin.g.b.s.u(parame, "classDescriptor");
    if ((parame.kna() != kotlin.l.b.a.b.b.f.aiGt) || (!knM().aiFI))
    {
      parame = (Collection)kotlin.a.ab.aivy;
      AppMethodBeat.o(191500);
      return parame;
    }
    kotlin.l.b.a.b.d.a.c.a.f localf = l(parame);
    if (localf == null)
    {
      parame = (Collection)kotlin.a.ab.aivy;
      AppMethodBeat.o(191500);
      return parame;
    }
    Object localObject1 = kotlin.l.b.a.b.j.d.a.o((kotlin.l.b.a.b.b.l)localf);
    Object localObject2 = b.aiEV;
    Object localObject3 = d.a((kotlin.l.b.a.b.f.c)localObject1, b.knE());
    if (localObject3 == null)
    {
      parame = (Collection)kotlin.a.ab.aivy;
      AppMethodBeat.o(191500);
      return parame;
    }
    localObject2 = j.a((kotlin.l.b.a.b.b.e)localObject3, (kotlin.l.b.a.b.b.e)localf).kAO();
    localObject1 = (Iterable)localf.ksq();
    Object localObject4 = (Collection)new ArrayList();
    Object localObject5 = ((Iterable)localObject1).iterator();
    Object localObject6;
    label512:
    while (((Iterator)localObject5).hasNext())
    {
      localObject6 = ((Iterator)localObject5).next();
      kotlin.l.b.a.b.b.d locald = (kotlin.l.b.a.b.b.d)localObject6;
      label396:
      label412:
      if (locald.knc().koB().aiHL)
      {
        localObject1 = ((kotlin.l.b.a.b.b.e)localObject3).klv();
        kotlin.g.b.s.s(localObject1, "defaultKotlinVersion.constructors");
        localObject1 = (Iterable)localObject1;
        label324:
        label330:
        if (!((Collection)localObject1).isEmpty())
        {
          localObject1 = ((Iterable)localObject1).iterator();
          label254:
          if (((Iterator)localObject1).hasNext())
          {
            Object localObject7 = (kotlin.l.b.a.b.b.d)((Iterator)localObject1).next();
            kotlin.g.b.s.s(localObject7, "it");
            localObject7 = (k)localObject7;
            k localk = (k)locald;
            if (kotlin.l.b.a.b.j.j.f((kotlin.l.b.a.b.b.a)localObject7, (kotlin.l.b.a.b.b.a)localk.b((be)localObject2)) == j.a.a.ajjn)
            {
              i = 1;
              if (i == 0) {
                break label486;
              }
              i = 0;
              if (i == 0) {
                break label509;
              }
              localObject1 = (k)locald;
              if (((k)localObject1).kod().size() != 1) {
                break label504;
              }
              localObject1 = ((k)localObject1).kod();
              kotlin.g.b.s.s(localObject1, "valueParameters");
              localObject1 = ((bd)p.oO((List)localObject1)).koG().kzm().knA();
              if (localObject1 != null) {
                break label493;
              }
              localObject1 = null;
              if (!kotlin.g.b.s.p(localObject1, kotlin.l.b.a.b.j.d.a.q((kotlin.l.b.a.b.b.l)parame))) {
                break label504;
              }
              i = 1;
              if ((i != 0) || (kotlin.l.b.a.b.a.h.g((kotlin.l.b.a.b.b.l)locald))) {
                break label509;
              }
              localObject1 = i.aiGe;
              if (i.knV().contains(kotlin.l.b.a.b.d.b.s.a(v.aiXe, (kotlin.l.b.a.b.b.e)localf, kotlin.l.b.a.b.d.b.t.a((x)locald, false, false, 3)))) {
                break label509;
              }
            }
          }
        }
      }
      label486:
      label493:
      label504:
      label509:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label512;
        }
        ((Collection)localObject4).add(localObject6);
        break;
        i = 0;
        break label324;
        break label254;
        i = 1;
        break label330;
        localObject1 = kotlin.l.b.a.b.j.d.a.q((kotlin.l.b.a.b.b.l)localObject1);
        break label396;
        i = 0;
        break label412;
      }
    }
    localObject3 = (Iterable)localObject4;
    localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (kotlin.l.b.a.b.b.d)((Iterator)localObject3).next();
      localObject5 = ((kotlin.l.b.a.b.b.d)localObject4).koO();
      ((x.a)localObject5).h((kotlin.l.b.a.b.b.l)parame);
      ((x.a)localObject5).z((kotlin.l.b.a.b.m.ad)parame.koj());
      ((x.a)localObject5).koQ();
      ((x.a)localObject5).b(((be)localObject2).kAR());
      localObject6 = i.aiGe;
      if (!i.knW().contains(kotlin.l.b.a.b.d.b.s.a(v.aiXe, (kotlin.l.b.a.b.b.e)localf, kotlin.l.b.a.b.d.b.t.a((x)localObject4, false, false, 3)))) {
        ((x.a)localObject5).a(knO());
      }
      localObject4 = ((x.a)localObject5).koU();
      if (localObject4 == null)
      {
        parame = new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor");
        AppMethodBeat.o(191500);
        throw parame;
      }
      ((Collection)localObject1).add((kotlin.l.b.a.b.b.d)localObject4);
    }
    parame = (Collection)localObject1;
    AppMethodBeat.o(191500);
    return parame;
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(191498);
      aiFS = new a("HIDDEN", 0);
      aiFT = new a("VISIBLE", 1);
      aiFU = new a("NOT_CONSIDERED", 2);
      aiFV = new a("DROP", 3);
      aiFW = new a[] { aiFS, aiFT, aiFU, aiFV };
      AppMethodBeat.o(191498);
    }
    
    private a() {}
  }
  
  static final class c
    extends u
    implements kotlin.g.a.a<al>
  {
    c(g paramg, m paramm)
    {
      super();
    }
  }
  
  public static final class d
    extends y
  {
    d(ae paramae, kotlin.l.b.a.b.f.c paramc)
    {
      super(paramc);
    }
  }
  
  static final class e
    extends u
    implements kotlin.g.a.a<kotlin.l.b.a.b.m.ad>
  {
    e(g paramg)
    {
      super();
    }
  }
  
  static final class f
    extends u
    implements kotlin.g.a.a<kotlin.l.b.a.b.b.e>
  {
    f(kotlin.l.b.a.b.d.a.c.a.f paramf, kotlin.l.b.a.b.b.e parame)
    {
      super();
    }
  }
  
  static final class g
    extends u
    implements kotlin.g.a.b<kotlin.l.b.a.b.j.g.h, Collection<? extends au>>
  {
    g(kotlin.l.b.a.b.f.f paramf)
    {
      super();
    }
  }
  
  static final class h<N>
    implements b.b
  {
    h(g paramg) {}
  }
  
  public static final class i
    extends kotlin.l.b.a.b.o.b.a<kotlin.l.b.a.b.b.e, g.a>
  {
    i(String paramString, ah.f<g.a> paramf) {}
  }
  
  static final class j<N>
    implements b.b
  {
    public static final j<N> aiGc;
    
    static
    {
      AppMethodBeat.i(191478);
      aiGc = new j();
      AppMethodBeat.o(191478);
    }
  }
  
  static final class k
    extends u
    implements kotlin.g.a.b<kotlin.l.b.a.b.b.b, Boolean>
  {
    k(g paramg)
    {
      super();
    }
  }
  
  static final class l
    extends u
    implements kotlin.g.a.a<kotlin.l.b.a.b.b.a.g>
  {
    l(g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.a.b.g
 * JD-Core Version:    0.7.0.1
 */