package kotlin.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.a.ae;
import kotlin.a.v;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.ak;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.ar;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.c.o;
import kotlin.l.b.a.b.e.a.c;
import kotlin.l.b.a.b.e.a.h;
import kotlin.l.b.a.b.e.a.i;
import kotlin.l.b.a.b.e.a.j;
import kotlin.l.b.a.b.e.a.m;
import kotlin.l.b.a.b.e.a.p;
import kotlin.l.b.a.b.e.a.q;
import kotlin.l.b.a.b.e.a.t;
import kotlin.l.b.a.b.e.a.w;
import kotlin.l.b.a.b.e.b.b.c;
import kotlin.l.b.a.b.e.b.h;
import kotlin.l.b.a.b.e.b.i;

public final class w
{
  private final f aaYd;
  private final n abnP;
  
  public w(n paramn)
  {
    AppMethodBeat.i(60340);
    this.abnP = paramn;
    this.aaYd = new f(this.abnP.aaYm.aaIY, this.abnP.aaYm.aaHL);
    AppMethodBeat.o(60340);
  }
  
  private final z K(kotlin.l.b.a.b.b.l paraml)
  {
    AppMethodBeat.i(60339);
    if ((paraml instanceof kotlin.l.b.a.b.b.ab))
    {
      paraml = (z)new z.b(((kotlin.l.b.a.b.b.ab)paraml).iFy(), this.abnP.aaCB, this.abnP.aaCC, (an)this.abnP.abnE);
      AppMethodBeat.o(60339);
      return paraml;
    }
    if ((paraml instanceof kotlin.l.b.a.b.k.a.b.e))
    {
      paraml = (z)((kotlin.l.b.a.b.k.a.b.e)paraml).aboF;
      AppMethodBeat.o(60339);
      return paraml;
    }
    AppMethodBeat.o(60339);
    return null;
  }
  
  private final List<av> a(List<a.t> paramList, final kotlin.l.b.a.b.h.r paramr, final b paramb)
  {
    AppMethodBeat.i(60338);
    Object localObject1 = this.abnP.aaNi;
    if (localObject1 == null)
    {
      paramList = new kotlin.t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
      AppMethodBeat.o(60338);
      throw paramList;
    }
    final kotlin.l.b.a.b.b.a locala = (kotlin.l.b.a.b.b.a)localObject1;
    localObject1 = locala.iDJ();
    kotlin.g.b.p.j(localObject1, "callableDescriptor.containingDeclaration");
    final z localz = K((kotlin.l.b.a.b.b.l)localObject1);
    paramList = (Iterable)paramList;
    Collection localCollection = (Collection)new ArrayList(kotlin.a.j.a(paramList, 10));
    int i = 0;
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      paramList = localIterator.next();
      if (i < 0) {
        kotlin.a.j.iBO();
      }
      localObject1 = (a.t)paramList;
      int j;
      label148:
      label217:
      kotlin.l.b.a.b.f.f localf;
      kotlin.l.b.a.b.m.ab localab;
      Object localObject2;
      boolean bool1;
      boolean bool2;
      boolean bool3;
      if (((a.t)localObject1).iJj())
      {
        j = ((a.t)localObject1).aaZS;
        if (localz == null) {
          break label425;
        }
        paramList = kotlin.l.b.a.b.e.b.b.abdJ.aFe(j);
        kotlin.g.b.p.j(paramList, "Flags.HAS_ANNOTATIONS.get(flags)");
        if (!paramList.booleanValue()) {
          break label425;
        }
        paramList = (kotlin.l.b.a.b.b.a.g)new kotlin.l.b.a.b.k.a.b.n(this.abnP.aaYm.aaFH, (kotlin.g.a.a)new e(i, (a.t)localObject1, this, localz, paramr, paramb, locala));
        localf = x.b(this.abnP.aaCB, ((a.t)localObject1).abbb);
        localab = this.abnP.abnB.r(kotlin.l.b.a.b.e.b.g.a((a.t)localObject1, this.abnP.aaCC));
        localObject2 = kotlin.l.b.a.b.e.b.b.abek.aFe(j);
        kotlin.g.b.p.j(localObject2, "Flags.DECLARES_DEFAULT_VALUE.get(flags)");
        bool1 = ((Boolean)localObject2).booleanValue();
        localObject2 = kotlin.l.b.a.b.e.b.b.abel.aFe(j);
        kotlin.g.b.p.j(localObject2, "Flags.IS_CROSSINLINE.get(flags)");
        bool2 = ((Boolean)localObject2).booleanValue();
        localObject2 = kotlin.l.b.a.b.e.b.b.abem.aFe(j);
        kotlin.g.b.p.j(localObject2, "Flags.IS_NOINLINE.get(flags)");
        bool3 = ((Boolean)localObject2).booleanValue();
        localObject1 = kotlin.l.b.a.b.e.b.g.b((a.t)localObject1, this.abnP.aaCC);
        if (localObject1 == null) {
          break label436;
        }
      }
      label425:
      label436:
      for (localObject1 = this.abnP.abnB.r((a.p)localObject1);; localObject1 = null)
      {
        localObject2 = an.aaKE;
        kotlin.g.b.p.j(localObject2, "SourceElement.NO_SOURCE");
        localCollection.add(new kotlin.l.b.a.b.b.c.aj(locala, null, i, paramList, localf, localab, bool1, bool2, bool3, (kotlin.l.b.a.b.m.ab)localObject1, (an)localObject2));
        i += 1;
        break;
        j = 0;
        break label148;
        paramList = kotlin.l.b.a.b.b.a.g.aaLw;
        paramList = kotlin.l.b.a.b.b.a.g.a.iGe();
        break label217;
      }
    }
    paramList = kotlin.a.j.p((Iterable)localCollection);
    AppMethodBeat.o(60338);
    return paramList;
  }
  
  private final kotlin.l.b.a.b.b.a.g a(final a.m paramm, final boolean paramBoolean)
  {
    AppMethodBeat.i(60336);
    if (!kotlin.l.b.a.b.e.b.b.abdJ.aFe(paramm.aaZS).booleanValue())
    {
      paramm = kotlin.l.b.a.b.b.a.g.aaLw;
      paramm = kotlin.l.b.a.b.b.a.g.a.iGe();
      AppMethodBeat.o(60336);
      return paramm;
    }
    paramm = (kotlin.l.b.a.b.b.a.g)new kotlin.l.b.a.b.k.a.b.n(this.abnP.aaYm.aaFH, (kotlin.g.a.a)new b(this, paramBoolean, paramm));
    AppMethodBeat.o(60336);
    return paramm;
  }
  
  private final kotlin.l.b.a.b.b.a.g a(final kotlin.l.b.a.b.h.r paramr, int paramInt, final b paramb)
  {
    AppMethodBeat.i(60335);
    if (!kotlin.l.b.a.b.e.b.b.abdJ.aFe(paramInt).booleanValue())
    {
      paramr = kotlin.l.b.a.b.b.a.g.aaLw;
      paramr = kotlin.l.b.a.b.b.a.g.a.iGe();
      AppMethodBeat.o(60335);
      return paramr;
    }
    paramr = (kotlin.l.b.a.b.b.a.g)new kotlin.l.b.a.b.k.a.b.n(this.abnP.aaYm.aaFH, (kotlin.g.a.a)new a(this, paramr, paramb));
    AppMethodBeat.o(60335);
    return paramr;
  }
  
  private final kotlin.l.b.a.b.b.a.g a(final kotlin.l.b.a.b.h.r paramr, final b paramb)
  {
    AppMethodBeat.i(60337);
    paramr = (kotlin.l.b.a.b.b.a.g)new kotlin.l.b.a.b.k.a.b.b(this.abnP.aaYm.aaFH, (kotlin.g.a.a)new c(this, paramr, paramb));
    AppMethodBeat.o(60337);
    return paramr;
  }
  
  private final void a(kotlin.l.b.a.b.k.a.b.k paramk, ak paramak1, ak paramak2, List<? extends as> paramList, List<? extends av> paramList1, kotlin.l.b.a.b.m.ab paramab, kotlin.l.b.a.b.b.w paramw, ba paramba, Map<? extends kotlin.l.b.a.b.b.a.a<?>, ?> paramMap, boolean paramBoolean)
  {
    AppMethodBeat.i(269281);
    kotlin.l.b.a.b.k.a.b.c localc = (kotlin.l.b.a.b.k.a.b.c)paramk;
    paramk.a(paramak1, paramak2, paramList, paramList1, paramab, paramw, paramba, paramMap, kotlin.l.b.a.b.k.a.b.g.a.aboR);
    AppMethodBeat.o(269281);
  }
  
  private static int aFB(int paramInt)
  {
    return (paramInt & 0x3F) + (paramInt >> 8 << 6);
  }
  
  private final ak iEF()
  {
    AppMethodBeat.i(60333);
    kotlin.l.b.a.b.b.l locall = this.abnP.aaNi;
    Object localObject = locall;
    if (!(locall instanceof kotlin.l.b.a.b.b.e)) {
      localObject = null;
    }
    localObject = (kotlin.l.b.a.b.b.e)localObject;
    if (localObject != null)
    {
      localObject = ((kotlin.l.b.a.b.b.e)localObject).iFb();
      AppMethodBeat.o(60333);
      return localObject;
    }
    AppMethodBeat.o(60333);
    return null;
  }
  
  public final kotlin.l.b.a.b.b.d a(a.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(60334);
    kotlin.g.b.p.k(paramc, "proto");
    Object localObject1 = this.abnP.aaNi;
    if (localObject1 == null)
    {
      paramc = new kotlin.t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
      AppMethodBeat.o(60334);
      throw paramc;
    }
    kotlin.l.b.a.b.b.e locale = (kotlin.l.b.a.b.b.e)localObject1;
    localObject1 = new kotlin.l.b.a.b.k.a.b.d(locale, a((kotlin.l.b.a.b.h.r)paramc, paramc.aaZS, b.abmW), paramBoolean, kotlin.l.b.a.b.b.b.a.aaJQ, paramc, this.abnP.aaCB, this.abnP.aaCC, this.abnP.abnD, this.abnP.abnE);
    Object localObject2 = n.a(this.abnP, (kotlin.l.b.a.b.b.l)localObject1, (List)v.aaAd).abnC;
    Object localObject3 = paramc.abaK;
    kotlin.g.b.p.j(localObject3, "proto.valueParameterList");
    localObject2 = ((w)localObject2).a((List)localObject3, (kotlin.l.b.a.b.h.r)paramc, b.abmW);
    localObject3 = aa.abof;
    ((kotlin.l.b.a.b.k.a.b.d)localObject1).a((List)localObject2, aa.a((a.w)kotlin.l.b.a.b.e.b.b.abdK.get(paramc.aaZS)));
    ((kotlin.l.b.a.b.k.a.b.d)localObject1).I((kotlin.l.b.a.b.m.ab)locale.iET());
    paramc = (kotlin.l.b.a.b.k.a.b.c)localObject1;
    kotlin.g.b.p.j(((kotlin.l.b.a.b.k.a.b.d)localObject1).iEJ(), "descriptor.valueParameters");
    kotlin.g.b.p.j(((kotlin.l.b.a.b.k.a.b.d)localObject1).iEG(), "descriptor.typeParameters");
    ((kotlin.l.b.a.b.k.a.b.d)localObject1).iEH();
    ((kotlin.l.b.a.b.k.a.b.d)localObject1).a(kotlin.l.b.a.b.k.a.b.g.a.aboR);
    paramc = (kotlin.l.b.a.b.b.d)localObject1;
    AppMethodBeat.o(60334);
    return paramc;
  }
  
  public final ar f(a.q paramq)
  {
    AppMethodBeat.i(60332);
    kotlin.g.b.p.k(paramq, "proto");
    Object localObject1 = kotlin.l.b.a.b.b.a.g.aaLw;
    localObject1 = paramq.abcB;
    kotlin.g.b.p.j(localObject1, "proto.annotationList");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (kotlin.l.b.a.b.e.a.a)((Iterator)localObject2).next();
      localObject4 = this.aaYd;
      kotlin.g.b.p.j(localObject3, "it");
      ((Collection)localObject1).add(((f)localObject4).b((kotlin.l.b.a.b.e.a.a)localObject3, this.abnP.aaCB));
    }
    localObject1 = kotlin.l.b.a.b.b.a.g.a.lw((List)localObject1);
    localObject2 = aa.abof;
    localObject2 = aa.a((a.w)kotlin.l.b.a.b.e.b.b.abdK.get(paramq.aaZS));
    localObject2 = new kotlin.l.b.a.b.k.a.b.l(this.abnP.aaYm.aaFH, this.abnP.aaNi, (kotlin.l.b.a.b.b.a.g)localObject1, x.b(this.abnP.aaCB, paramq.abbb), (ba)localObject2, paramq, this.abnP.aaCB, this.abnP.aaCC, this.abnP.abnD, this.abnP.abnE);
    localObject1 = this.abnP;
    Object localObject3 = (kotlin.l.b.a.b.b.l)localObject2;
    Object localObject4 = paramq.abal;
    kotlin.g.b.p.j(localObject4, "proto.typeParameterList");
    localObject4 = n.a((n)localObject1, (kotlin.l.b.a.b.b.l)localObject3, (List)localObject4);
    localObject3 = ((n)localObject4).abnB.iPy();
    Object localObject5 = ((n)localObject4).abnB;
    localObject1 = this.abnP.aaCC;
    kotlin.g.b.p.k(paramq, "$this$underlyingType");
    kotlin.g.b.p.k(localObject1, "typeTable");
    if (paramq.iLL())
    {
      localObject1 = paramq.abcx;
      kotlin.g.b.p.j(localObject1, "underlyingType");
      localObject1 = ((ad)localObject5).s((a.p)localObject1);
      localObject4 = ((n)localObject4).abnB;
      localObject5 = this.abnP.aaCC;
      kotlin.g.b.p.k(paramq, "$this$expandedType");
      kotlin.g.b.p.k(localObject5, "typeTable");
      if (!paramq.iLN()) {
        break label446;
      }
      paramq = paramq.abcz;
      kotlin.g.b.p.j(paramq, "expandedType");
    }
    for (;;)
    {
      paramq = ((ad)localObject4).s(paramq);
      localObject4 = (kotlin.l.b.a.b.k.a.b.g)localObject2;
      ((kotlin.l.b.a.b.k.a.b.l)localObject2).a((List)localObject3, (kotlin.l.b.a.b.m.aj)localObject1, paramq, kotlin.l.b.a.b.k.a.b.g.a.aboR);
      paramq = (ar)localObject2;
      AppMethodBeat.o(60332);
      return paramq;
      if (paramq.iLM())
      {
        localObject1 = ((h)localObject1).aFi(paramq.abcy);
        break;
      }
      paramq = (Throwable)new IllegalStateException("No underlyingType in ProtoBuf.TypeAlias".toString());
      AppMethodBeat.o(60332);
      throw paramq;
      label446:
      if (!paramq.iLO()) {
        break label466;
      }
      paramq = ((h)localObject5).aFi(paramq.abcA);
    }
    label466:
    paramq = (Throwable)new IllegalStateException("No expandedType in ProtoBuf.TypeAlias".toString());
    AppMethodBeat.o(60332);
    throw paramq;
  }
  
  public final ah g(final a.m paramm)
  {
    AppMethodBeat.i(60329);
    kotlin.g.b.p.k(paramm, "proto");
    int i;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    boolean bool1;
    label414:
    label500:
    int j;
    int k;
    if (paramm.iJj())
    {
      i = paramm.aaZS;
      localObject1 = this.abnP.aaNi;
      localObject2 = a((kotlin.l.b.a.b.h.r)paramm, i, b.abmX);
      localObject3 = aa.abof;
      localObject3 = aa.a((a.j)kotlin.l.b.a.b.e.b.b.abdL.get(i));
      localObject4 = aa.abof;
      localObject4 = aa.a((a.w)kotlin.l.b.a.b.e.b.b.abdK.get(i));
      localObject5 = kotlin.l.b.a.b.e.b.b.abeb.aFe(i);
      kotlin.g.b.p.j(localObject5, "Flags.IS_VAR.get(flags)");
      bool1 = ((Boolean)localObject5).booleanValue();
      localObject5 = x.b(this.abnP.aaCB, paramm.abbb);
      Object localObject6 = aa.abof;
      localObject6 = aa.a((a.i)kotlin.l.b.a.b.e.b.b.abdT.get(i));
      Object localObject7 = kotlin.l.b.a.b.e.b.b.abef.aFe(i);
      kotlin.g.b.p.j(localObject7, "Flags.IS_LATEINIT.get(flags)");
      boolean bool2 = ((Boolean)localObject7).booleanValue();
      localObject7 = kotlin.l.b.a.b.e.b.b.abee.aFe(i);
      kotlin.g.b.p.j(localObject7, "Flags.IS_CONST.get(flags)");
      boolean bool3 = ((Boolean)localObject7).booleanValue();
      localObject7 = kotlin.l.b.a.b.e.b.b.abeh.aFe(i);
      kotlin.g.b.p.j(localObject7, "Flags.IS_EXTERNAL_PROPERTY.get(flags)");
      boolean bool4 = ((Boolean)localObject7).booleanValue();
      localObject7 = kotlin.l.b.a.b.e.b.b.abei.aFe(i);
      kotlin.g.b.p.j(localObject7, "Flags.IS_DELEGATED.get(flags)");
      boolean bool5 = ((Boolean)localObject7).booleanValue();
      localObject7 = kotlin.l.b.a.b.e.b.b.abej.aFe(i);
      kotlin.g.b.p.j(localObject7, "Flags.IS_EXPECT_PROPERTY.get(flags)");
      localObject3 = new kotlin.l.b.a.b.k.a.b.j((kotlin.l.b.a.b.b.l)localObject1, null, (kotlin.l.b.a.b.b.a.g)localObject2, (kotlin.l.b.a.b.b.w)localObject3, (ba)localObject4, bool1, (kotlin.l.b.a.b.f.f)localObject5, (kotlin.l.b.a.b.b.b.a)localObject6, bool2, bool3, bool4, bool5, ((Boolean)localObject7).booleanValue(), paramm, this.abnP.aaCB, this.abnP.aaCC, this.abnP.abnD, this.abnP.abnE);
      localObject1 = this.abnP;
      localObject2 = (kotlin.l.b.a.b.b.l)localObject3;
      localObject4 = paramm.abal;
      kotlin.g.b.p.j(localObject4, "proto.typeParameterList");
      localObject4 = n.a((n)localObject1, (kotlin.l.b.a.b.b.l)localObject2, (List)localObject4);
      localObject1 = kotlin.l.b.a.b.e.b.b.abec.aFe(i);
      kotlin.g.b.p.j(localObject1, "Flags.HAS_GETTER.get(flags)");
      bool1 = ((Boolean)localObject1).booleanValue();
      if ((!bool1) || (!kotlin.l.b.a.b.e.b.g.e(paramm))) {
        break label1194;
      }
      localObject1 = a((kotlin.l.b.a.b.h.r)paramm, b.abmY);
      localObject2 = ((n)localObject4).abnB.r(kotlin.l.b.a.b.e.b.g.a(paramm, this.abnP.aaCC));
      localObject5 = ((n)localObject4).abnB.iPy();
      localObject6 = iEF();
      localObject7 = kotlin.l.b.a.b.e.b.g.b(paramm, this.abnP.aaCC);
      if (localObject7 == null) {
        break label1207;
      }
      localObject7 = ((n)localObject4).abnB.r((a.p)localObject7);
      if (localObject7 == null) {
        break label1207;
      }
      localObject1 = kotlin.l.b.a.b.j.b.a((kotlin.l.b.a.b.b.a)localObject3, (kotlin.l.b.a.b.m.ab)localObject7, (kotlin.l.b.a.b.b.a.g)localObject1);
      ((kotlin.l.b.a.b.k.a.b.j)localObject3).a((kotlin.l.b.a.b.m.ab)localObject2, (List)localObject5, (ak)localObject6, (ak)localObject1);
      localObject1 = kotlin.l.b.a.b.e.b.b.abdJ.aFe(i);
      kotlin.g.b.p.j(localObject1, "Flags.HAS_ANNOTATIONS.get(flags)");
      j = kotlin.l.b.a.b.e.b.b.a(((Boolean)localObject1).booleanValue(), (a.w)kotlin.l.b.a.b.e.b.b.abdK.get(i), (a.j)kotlin.l.b.a.b.e.b.b.abdL.get(i));
      if (!bool1) {
        break label1248;
      }
      if (!paramm.iKR()) {
        break label1213;
      }
      k = paramm.abbM;
      label576:
      localObject1 = kotlin.l.b.a.b.e.b.b.aben.aFe(k);
      kotlin.g.b.p.j(localObject1, "Flags.IS_NOT_DEFAULT.get(getterFlags)");
      bool1 = ((Boolean)localObject1).booleanValue();
      localObject1 = kotlin.l.b.a.b.e.b.b.abeo.aFe(k);
      kotlin.g.b.p.j(localObject1, "Flags.IS_EXTERNAL_ACCESSOR.get(getterFlags)");
      bool2 = ((Boolean)localObject1).booleanValue();
      localObject1 = kotlin.l.b.a.b.e.b.b.abep.aFe(k);
      kotlin.g.b.p.j(localObject1, "Flags.IS_INLINE_ACCESSOR.get(getterFlags)");
      bool3 = ((Boolean)localObject1).booleanValue();
      localObject1 = a((kotlin.l.b.a.b.h.r)paramm, k, b.abmY);
      if (!bool1) {
        break label1225;
      }
      localObject2 = (ah)localObject3;
      localObject5 = aa.abof;
      localObject5 = aa.a((a.j)kotlin.l.b.a.b.e.b.b.abdL.get(k));
      localObject6 = aa.abof;
      localObject6 = aa.a((a.w)kotlin.l.b.a.b.e.b.b.abdK.get(k));
      if (bool1) {
        break label1219;
      }
      bool1 = true;
      label728:
      localObject1 = new kotlin.l.b.a.b.b.c.ab((ah)localObject2, (kotlin.l.b.a.b.b.a.g)localObject1, (kotlin.l.b.a.b.b.w)localObject5, (ba)localObject6, bool1, bool2, bool3, ((kotlin.l.b.a.b.k.a.b.j)localObject3).iEN(), null, an.aaKE);
      label760:
      ((kotlin.l.b.a.b.b.c.ab)localObject1).J(((kotlin.l.b.a.b.k.a.b.j)localObject3).iEH());
      localObject2 = localObject1;
      label774:
      localObject1 = kotlin.l.b.a.b.e.b.b.abed.aFe(i);
      kotlin.g.b.p.j(localObject1, "Flags.HAS_SETTER.get(flags)");
      if (!((Boolean)localObject1).booleanValue()) {
        break label1295;
      }
      if (paramm.iKS()) {
        j = paramm.abbN;
      }
      localObject1 = kotlin.l.b.a.b.e.b.b.aben.aFe(j);
      kotlin.g.b.p.j(localObject1, "Flags.IS_NOT_DEFAULT.get(setterFlags)");
      bool1 = ((Boolean)localObject1).booleanValue();
      localObject1 = kotlin.l.b.a.b.e.b.b.abeo.aFe(j);
      kotlin.g.b.p.j(localObject1, "Flags.IS_EXTERNAL_ACCESSOR.get(setterFlags)");
      bool2 = ((Boolean)localObject1).booleanValue();
      localObject1 = kotlin.l.b.a.b.e.b.b.abep.aFe(j);
      kotlin.g.b.p.j(localObject1, "Flags.IS_INLINE_ACCESSOR.get(setterFlags)");
      bool3 = ((Boolean)localObject1).booleanValue();
      localObject1 = a((kotlin.l.b.a.b.h.r)paramm, j, b.abmZ);
      if (!bool1) {
        break label1260;
      }
      localObject5 = (ah)localObject3;
      localObject6 = aa.abof;
      localObject6 = aa.a((a.j)kotlin.l.b.a.b.e.b.b.abdL.get(j));
      localObject7 = aa.abof;
      localObject7 = aa.a((a.w)kotlin.l.b.a.b.e.b.b.abdK.get(j));
      if (bool1) {
        break label1254;
      }
      bool1 = true;
      label957:
      localObject1 = new kotlin.l.b.a.b.b.c.ac((ah)localObject5, (kotlin.l.b.a.b.b.a.g)localObject1, (kotlin.l.b.a.b.b.w)localObject6, (ba)localObject7, bool1, bool2, bool3, ((kotlin.l.b.a.b.k.a.b.j)localObject3).iEN(), null, an.aaKE);
      ((kotlin.l.b.a.b.b.c.ac)localObject1).a((av)kotlin.a.j.ls(n.a((n)localObject4, (kotlin.l.b.a.b.b.l)localObject1, (List)v.aaAd).abnC.a(kotlin.a.j.listOf(paramm.abbL), (kotlin.l.b.a.b.h.r)paramm, b.abmZ)));
    }
    for (;;)
    {
      localObject4 = kotlin.l.b.a.b.e.b.b.abeg.aFe(i);
      kotlin.g.b.p.j(localObject4, "Flags.HAS_CONSTANT.get(flags)");
      if (((Boolean)localObject4).booleanValue()) {
        ((kotlin.l.b.a.b.k.a.b.j)localObject3).a(this.abnP.aaYm.aaFH.aw((kotlin.g.a.a)new d(this, paramm, (kotlin.l.b.a.b.k.a.b.j)localObject3)));
      }
      localObject1 = (kotlin.l.b.a.b.b.aj)localObject1;
      localObject4 = (kotlin.l.b.a.b.b.r)new o(a(paramm, false), (ah)localObject3);
      paramm = (kotlin.l.b.a.b.b.r)new o(a(paramm, true), (ah)localObject3);
      localObject5 = (kotlin.l.b.a.b.k.a.b.g)localObject3;
      ((kotlin.l.b.a.b.k.a.b.j)localObject3).a((kotlin.l.b.a.b.b.c.ab)localObject2, (kotlin.l.b.a.b.b.aj)localObject1, (kotlin.l.b.a.b.b.r)localObject4, paramm, kotlin.l.b.a.b.k.a.b.g.a.aboR);
      paramm = (ah)localObject3;
      AppMethodBeat.o(60329);
      return paramm;
      i = aFB(paramm.abbo);
      break;
      label1194:
      localObject1 = kotlin.l.b.a.b.b.a.g.aaLw;
      localObject1 = kotlin.l.b.a.b.b.a.g.a.iGe();
      break label414;
      label1207:
      localObject1 = null;
      break label500;
      label1213:
      k = j;
      break label576;
      label1219:
      bool1 = false;
      break label728;
      label1225:
      localObject1 = kotlin.l.b.a.b.j.b.a((ah)localObject3, (kotlin.l.b.a.b.b.a.g)localObject1);
      kotlin.g.b.p.j(localObject1, "DescriptorFactory.create…er(property, annotations)");
      break label760;
      label1248:
      localObject2 = null;
      break label774;
      label1254:
      bool1 = false;
      break label957;
      label1260:
      localObject4 = (ah)localObject3;
      localObject5 = kotlin.l.b.a.b.b.a.g.aaLw;
      localObject1 = kotlin.l.b.a.b.j.b.a((ah)localObject4, (kotlin.l.b.a.b.b.a.g)localObject1, kotlin.l.b.a.b.b.a.g.a.iGe());
      kotlin.g.b.p.j(localObject1, "DescriptorFactory.create…ptor */\n                )");
      continue;
      label1295:
      localObject1 = null;
    }
  }
  
  public final am g(a.h paramh)
  {
    AppMethodBeat.i(60331);
    kotlin.g.b.p.k(paramh, "proto");
    int i;
    Object localObject3;
    label58:
    Object localObject2;
    label104:
    Object localObject4;
    Object localObject5;
    Object localObject6;
    if (paramh.iJj())
    {
      i = paramh.aaZS;
      localObject3 = a((kotlin.l.b.a.b.h.r)paramh, i, b.abmW);
      if (!kotlin.l.b.a.b.e.b.g.f(paramh)) {
        break label662;
      }
      localObject1 = a((kotlin.l.b.a.b.h.r)paramh, b.abmW);
      if (!kotlin.g.b.p.h(kotlin.l.b.a.b.j.d.a.o(this.abnP.aaNi).p(x.b(this.abnP.aaCB, paramh.abbb)), ac.abog)) {
        break label673;
      }
      localObject2 = i.abey;
      localObject2 = i.iMF();
      localObject4 = this.abnP.aaNi;
      localObject5 = x.b(this.abnP.aaCB, paramh.abbb);
      localObject6 = aa.abof;
      localObject2 = new kotlin.l.b.a.b.k.a.b.k((kotlin.l.b.a.b.b.l)localObject4, (kotlin.l.b.a.b.b.a.g)localObject3, (kotlin.l.b.a.b.f.f)localObject5, aa.a((a.i)kotlin.l.b.a.b.e.b.b.abdT.get(i)), paramh, this.abnP.aaCB, this.abnP.aaCC, (i)localObject2, this.abnP.abnE);
      localObject3 = this.abnP;
      localObject4 = (kotlin.l.b.a.b.b.l)localObject2;
      localObject5 = paramh.abal;
      kotlin.g.b.p.j(localObject5, "proto.typeParameterList");
      localObject5 = n.a((n)localObject3, (kotlin.l.b.a.b.b.l)localObject4, (List)localObject5);
      localObject3 = kotlin.l.b.a.b.e.b.g.b(paramh, this.abnP.aaCC);
      if (localObject3 == null) {
        break label685;
      }
      localObject3 = ((n)localObject5).abnB.r((a.p)localObject3);
      if (localObject3 == null) {
        break label685;
      }
    }
    label662:
    label673:
    label685:
    for (Object localObject1 = kotlin.l.b.a.b.j.b.a((kotlin.l.b.a.b.b.a)localObject2, (kotlin.l.b.a.b.m.ab)localObject3, (kotlin.l.b.a.b.b.a.g)localObject1);; localObject1 = null)
    {
      localObject3 = iEF();
      localObject4 = ((n)localObject5).abnB.iPy();
      localObject6 = ((n)localObject5).abnC;
      Object localObject7 = paramh.abaK;
      kotlin.g.b.p.j(localObject7, "proto.valueParameterList");
      localObject6 = ((w)localObject6).a((List)localObject7, (kotlin.l.b.a.b.h.r)paramh, b.abmW);
      localObject5 = ((n)localObject5).abnB.r(kotlin.l.b.a.b.e.b.g.a(paramh, this.abnP.aaCC));
      localObject7 = aa.abof;
      localObject7 = aa.a((a.j)kotlin.l.b.a.b.e.b.b.abdL.get(i));
      Object localObject8 = aa.abof;
      localObject8 = aa.a((a.w)kotlin.l.b.a.b.e.b.b.abdK.get(i));
      Map localMap = ae.iBR();
      Boolean localBoolean = kotlin.l.b.a.b.e.b.b.abdZ.aFe(i);
      kotlin.g.b.p.j(localBoolean, "Flags.IS_SUSPEND.get(flags)");
      a((kotlin.l.b.a.b.k.a.b.k)localObject2, (ak)localObject1, (ak)localObject3, (List)localObject4, (List)localObject6, (kotlin.l.b.a.b.m.ab)localObject5, (kotlin.l.b.a.b.b.w)localObject7, (ba)localObject8, localMap, localBoolean.booleanValue());
      localObject1 = kotlin.l.b.a.b.e.b.b.abdU.aFe(i);
      kotlin.g.b.p.j(localObject1, "Flags.IS_OPERATOR.get(flags)");
      ((kotlin.l.b.a.b.b.c.p)localObject2).aaNG = ((Boolean)localObject1).booleanValue();
      localObject1 = kotlin.l.b.a.b.e.b.b.abdV.aFe(i);
      kotlin.g.b.p.j(localObject1, "Flags.IS_INFIX.get(flags)");
      ((kotlin.l.b.a.b.b.c.p)localObject2).aaNH = ((Boolean)localObject1).booleanValue();
      localObject1 = kotlin.l.b.a.b.e.b.b.abdY.aFe(i);
      kotlin.g.b.p.j(localObject1, "Flags.IS_EXTERNAL_FUNCTION.get(flags)");
      ((kotlin.l.b.a.b.b.c.p)localObject2).aaNj = ((Boolean)localObject1).booleanValue();
      localObject1 = kotlin.l.b.a.b.e.b.b.abdW.aFe(i);
      kotlin.g.b.p.j(localObject1, "Flags.IS_INLINE.get(flags)");
      ((kotlin.l.b.a.b.b.c.p)localObject2).aaNI = ((Boolean)localObject1).booleanValue();
      localObject1 = kotlin.l.b.a.b.e.b.b.abdX.aFe(i);
      kotlin.g.b.p.j(localObject1, "Flags.IS_TAILREC.get(flags)");
      ((kotlin.l.b.a.b.b.c.p)localObject2).aaNJ = ((Boolean)localObject1).booleanValue();
      localObject1 = kotlin.l.b.a.b.e.b.b.abdZ.aFe(i);
      kotlin.g.b.p.j(localObject1, "Flags.IS_SUSPEND.get(flags)");
      ((kotlin.l.b.a.b.b.c.p)localObject2).aaNO = ((Boolean)localObject1).booleanValue();
      localObject1 = kotlin.l.b.a.b.e.b.b.abea.aFe(i);
      kotlin.g.b.p.j(localObject1, "Flags.IS_EXPECT_FUNCTION.get(flags)");
      ((kotlin.l.b.a.b.b.c.p)localObject2).aaNK = ((Boolean)localObject1).booleanValue();
      this.abnP.aaYm.abnw.a(paramh, (kotlin.l.b.a.b.b.t)localObject2, this.abnP.aaCC, this.abnP.abnB);
      paramh = (am)localObject2;
      AppMethodBeat.o(60331);
      return paramh;
      i = aFB(paramh.abbo);
      break;
      localObject1 = kotlin.l.b.a.b.b.a.g.aaLw;
      localObject1 = kotlin.l.b.a.b.b.a.g.a.iGe();
      break label58;
      localObject2 = this.abnP.abnD;
      break label104;
    }
  }
  
  static final class a
    extends q
    implements kotlin.g.a.a<List<? extends kotlin.l.b.a.b.b.a.c>>
  {
    a(w paramw, kotlin.l.b.a.b.h.r paramr, b paramb)
    {
      super();
    }
  }
  
  static final class b
    extends q
    implements kotlin.g.a.a<List<? extends kotlin.l.b.a.b.b.a.c>>
  {
    b(w paramw, boolean paramBoolean, a.m paramm)
    {
      super();
    }
  }
  
  static final class c
    extends q
    implements kotlin.g.a.a<List<? extends kotlin.l.b.a.b.b.a.c>>
  {
    c(w paramw, kotlin.l.b.a.b.h.r paramr, b paramb)
    {
      super();
    }
  }
  
  static final class d
    extends q
    implements kotlin.g.a.a<kotlin.l.b.a.b.j.b.g<?>>
  {
    d(w paramw, a.m paramm, kotlin.l.b.a.b.k.a.b.j paramj)
    {
      super();
    }
  }
  
  static final class e
    extends q
    implements kotlin.g.a.a<List<? extends kotlin.l.b.a.b.b.a.c>>
  {
    e(int paramInt, a.t paramt, w paramw, z paramz, kotlin.l.b.a.b.h.r paramr, b paramb, kotlin.l.b.a.b.b.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.w
 * JD-Core Version:    0.7.0.1
 */