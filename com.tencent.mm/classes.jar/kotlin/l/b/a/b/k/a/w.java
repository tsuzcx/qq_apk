package kotlin.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.a.ae;
import kotlin.a.v;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.ak;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.ar;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.c.o;
import kotlin.l.b.a.b.b.r;
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
  private final n TLm;
  private final f Tvk;
  
  public w(n paramn)
  {
    AppMethodBeat.i(60340);
    this.TLm = paramn;
    this.Tvk = new f(this.TLm.Tvt.Tge, this.TLm.Tvt.TeR);
    AppMethodBeat.o(60340);
  }
  
  private final z K(kotlin.l.b.a.b.b.l paraml)
  {
    AppMethodBeat.i(60339);
    if ((paraml instanceof kotlin.l.b.a.b.b.ab))
    {
      paraml = (z)new z.b(((kotlin.l.b.a.b.b.ab)paraml).hBk(), this.TLm.SZH, this.TLm.SZI, (an)this.TLm.TLb);
      AppMethodBeat.o(60339);
      return paraml;
    }
    if ((paraml instanceof kotlin.l.b.a.b.k.a.b.e))
    {
      paraml = (z)((kotlin.l.b.a.b.k.a.b.e)paraml).TMd;
      AppMethodBeat.o(60339);
      return paraml;
    }
    AppMethodBeat.o(60339);
    return null;
  }
  
  private final List<av> a(List<a.t> paramList, final kotlin.l.b.a.b.h.q paramq, final b paramb)
  {
    AppMethodBeat.i(60338);
    Object localObject1 = this.TLm.Tko;
    if (localObject1 == null)
    {
      paramList = new kotlin.t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
      AppMethodBeat.o(60338);
      throw paramList;
    }
    final kotlin.l.b.a.b.b.a locala = (kotlin.l.b.a.b.b.a)localObject1;
    localObject1 = locala.hzx();
    kotlin.g.b.p.g(localObject1, "callableDescriptor.containingDeclaration");
    final z localz = K((kotlin.l.b.a.b.b.l)localObject1);
    paramList = (Iterable)paramList;
    Collection localCollection = (Collection)new ArrayList(kotlin.a.j.a(paramList, 10));
    int i = 0;
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      paramList = localIterator.next();
      if (i < 0) {
        kotlin.a.j.hxH();
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
      if (((a.t)localObject1).hEP())
      {
        j = ((a.t)localObject1).Txb;
        if (localz == null) {
          break label425;
        }
        paramList = kotlin.l.b.a.b.e.b.b.TAU.avk(j);
        kotlin.g.b.p.g(paramList, "Flags.HAS_ANNOTATIONS.get(flags)");
        if (!paramList.booleanValue()) {
          break label425;
        }
        paramList = (kotlin.l.b.a.b.b.a.g)new kotlin.l.b.a.b.k.a.b.n(this.TLm.Tvt.TcN, (kotlin.g.a.a)new e(i, (a.t)localObject1, this, localz, paramq, paramb, locala));
        localf = x.b(this.TLm.SZH, ((a.t)localObject1).Tyk);
        localab = this.TLm.TKY.r(kotlin.l.b.a.b.e.b.g.a((a.t)localObject1, this.TLm.SZI));
        localObject2 = kotlin.l.b.a.b.e.b.b.TBw.avk(j);
        kotlin.g.b.p.g(localObject2, "Flags.DECLARES_DEFAULT_VALUE.get(flags)");
        bool1 = ((Boolean)localObject2).booleanValue();
        localObject2 = kotlin.l.b.a.b.e.b.b.TBx.avk(j);
        kotlin.g.b.p.g(localObject2, "Flags.IS_CROSSINLINE.get(flags)");
        bool2 = ((Boolean)localObject2).booleanValue();
        localObject2 = kotlin.l.b.a.b.e.b.b.TBy.avk(j);
        kotlin.g.b.p.g(localObject2, "Flags.IS_NOINLINE.get(flags)");
        bool3 = ((Boolean)localObject2).booleanValue();
        localObject1 = kotlin.l.b.a.b.e.b.g.b((a.t)localObject1, this.TLm.SZI);
        if (localObject1 == null) {
          break label436;
        }
      }
      label425:
      label436:
      for (localObject1 = this.TLm.TKY.r((a.p)localObject1);; localObject1 = null)
      {
        localObject2 = an.ThK;
        kotlin.g.b.p.g(localObject2, "SourceElement.NO_SOURCE");
        localCollection.add(new kotlin.l.b.a.b.b.c.aj(locala, null, i, paramList, localf, localab, bool1, bool2, bool3, (kotlin.l.b.a.b.m.ab)localObject1, (an)localObject2));
        i += 1;
        break;
        j = 0;
        break label148;
        paramList = kotlin.l.b.a.b.b.a.g.TiC;
        paramList = kotlin.l.b.a.b.b.a.g.a.hBP();
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
    if (!kotlin.l.b.a.b.e.b.b.TAU.avk(paramm.Txb).booleanValue())
    {
      paramm = kotlin.l.b.a.b.b.a.g.TiC;
      paramm = kotlin.l.b.a.b.b.a.g.a.hBP();
      AppMethodBeat.o(60336);
      return paramm;
    }
    paramm = (kotlin.l.b.a.b.b.a.g)new kotlin.l.b.a.b.k.a.b.n(this.TLm.Tvt.TcN, (kotlin.g.a.a)new b(this, paramBoolean, paramm));
    AppMethodBeat.o(60336);
    return paramm;
  }
  
  private final kotlin.l.b.a.b.b.a.g a(final kotlin.l.b.a.b.h.q paramq, int paramInt, final b paramb)
  {
    AppMethodBeat.i(60335);
    if (!kotlin.l.b.a.b.e.b.b.TAU.avk(paramInt).booleanValue())
    {
      paramq = kotlin.l.b.a.b.b.a.g.TiC;
      paramq = kotlin.l.b.a.b.b.a.g.a.hBP();
      AppMethodBeat.o(60335);
      return paramq;
    }
    paramq = (kotlin.l.b.a.b.b.a.g)new kotlin.l.b.a.b.k.a.b.n(this.TLm.Tvt.TcN, (kotlin.g.a.a)new a(this, paramq, paramb));
    AppMethodBeat.o(60335);
    return paramq;
  }
  
  private final kotlin.l.b.a.b.b.a.g a(final kotlin.l.b.a.b.h.q paramq, final b paramb)
  {
    AppMethodBeat.i(60337);
    paramq = (kotlin.l.b.a.b.b.a.g)new kotlin.l.b.a.b.k.a.b.b(this.TLm.Tvt.TcN, (kotlin.g.a.a)new c(this, paramq, paramb));
    AppMethodBeat.o(60337);
    return paramq;
  }
  
  private final void a(kotlin.l.b.a.b.k.a.b.k paramk, ak paramak1, ak paramak2, List<? extends as> paramList, List<? extends av> paramList1, kotlin.l.b.a.b.m.ab paramab, kotlin.l.b.a.b.b.w paramw, ba paramba, Map<? extends kotlin.l.b.a.b.b.a.a<?>, ?> paramMap, boolean paramBoolean)
  {
    AppMethodBeat.i(186259);
    kotlin.l.b.a.b.k.a.b.c localc = (kotlin.l.b.a.b.k.a.b.c)paramk;
    paramk.a(paramak1, paramak2, paramList, paramList1, paramab, paramw, paramba, paramMap, kotlin.l.b.a.b.k.a.b.g.a.TMp);
    AppMethodBeat.o(186259);
  }
  
  private static int avH(int paramInt)
  {
    return (paramInt & 0x3F) + (paramInt >> 8 << 6);
  }
  
  private final ak hAs()
  {
    AppMethodBeat.i(60333);
    kotlin.l.b.a.b.b.l locall = this.TLm.Tko;
    Object localObject = locall;
    if (!(locall instanceof kotlin.l.b.a.b.b.e)) {
      localObject = null;
    }
    localObject = (kotlin.l.b.a.b.b.e)localObject;
    if (localObject != null)
    {
      localObject = ((kotlin.l.b.a.b.b.e)localObject).hAO();
      AppMethodBeat.o(60333);
      return localObject;
    }
    AppMethodBeat.o(60333);
    return null;
  }
  
  public final kotlin.l.b.a.b.b.d a(a.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(60334);
    kotlin.g.b.p.h(paramc, "proto");
    Object localObject1 = this.TLm.Tko;
    if (localObject1 == null)
    {
      paramc = new kotlin.t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
      AppMethodBeat.o(60334);
      throw paramc;
    }
    kotlin.l.b.a.b.b.e locale = (kotlin.l.b.a.b.b.e)localObject1;
    localObject1 = new kotlin.l.b.a.b.k.a.b.d(locale, a((kotlin.l.b.a.b.h.q)paramc, paramc.Txb, b.TKt), paramBoolean, kotlin.l.b.a.b.b.b.a.TgW, paramc, this.TLm.SZH, this.TLm.SZI, this.TLm.TLa, this.TLm.TLb);
    Object localObject2 = n.a(this.TLm, (kotlin.l.b.a.b.b.l)localObject1, (List)v.SXr).TKZ;
    Object localObject3 = paramc.TxT;
    kotlin.g.b.p.g(localObject3, "proto.valueParameterList");
    localObject2 = ((w)localObject2).a((List)localObject3, (kotlin.l.b.a.b.h.q)paramc, b.TKt);
    localObject3 = aa.TLC;
    ((kotlin.l.b.a.b.k.a.b.d)localObject1).a((List)localObject2, aa.a((a.w)kotlin.l.b.a.b.e.b.b.TAV.get(paramc.Txb)));
    ((kotlin.l.b.a.b.k.a.b.d)localObject1).I((kotlin.l.b.a.b.m.ab)locale.hAG());
    paramc = (kotlin.l.b.a.b.k.a.b.c)localObject1;
    kotlin.g.b.p.g(((kotlin.l.b.a.b.k.a.b.d)localObject1).hAw(), "descriptor.valueParameters");
    kotlin.g.b.p.g(((kotlin.l.b.a.b.k.a.b.d)localObject1).hAt(), "descriptor.typeParameters");
    ((kotlin.l.b.a.b.k.a.b.d)localObject1).hAu();
    ((kotlin.l.b.a.b.k.a.b.d)localObject1).a(kotlin.l.b.a.b.k.a.b.g.a.TMp);
    paramc = (kotlin.l.b.a.b.b.d)localObject1;
    AppMethodBeat.o(60334);
    return paramc;
  }
  
  public final ar f(a.q paramq)
  {
    AppMethodBeat.i(60332);
    kotlin.g.b.p.h(paramq, "proto");
    Object localObject1 = kotlin.l.b.a.b.b.a.g.TiC;
    localObject1 = paramq.TzK;
    kotlin.g.b.p.g(localObject1, "proto.annotationList");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (kotlin.l.b.a.b.e.a.a)((Iterator)localObject2).next();
      localObject4 = this.Tvk;
      kotlin.g.b.p.g(localObject3, "it");
      ((Collection)localObject1).add(((f)localObject4).b((kotlin.l.b.a.b.e.a.a)localObject3, this.TLm.SZH));
    }
    localObject1 = kotlin.l.b.a.b.b.a.g.a.kA((List)localObject1);
    localObject2 = aa.TLC;
    localObject2 = aa.a((a.w)kotlin.l.b.a.b.e.b.b.TAV.get(paramq.Txb));
    localObject2 = new kotlin.l.b.a.b.k.a.b.l(this.TLm.Tvt.TcN, this.TLm.Tko, (kotlin.l.b.a.b.b.a.g)localObject1, x.b(this.TLm.SZH, paramq.Tyk), (ba)localObject2, paramq, this.TLm.SZH, this.TLm.SZI, this.TLm.TLa, this.TLm.TLb);
    localObject1 = this.TLm;
    Object localObject3 = (kotlin.l.b.a.b.b.l)localObject2;
    Object localObject4 = paramq.Txu;
    kotlin.g.b.p.g(localObject4, "proto.typeParameterList");
    localObject4 = n.a((n)localObject1, (kotlin.l.b.a.b.b.l)localObject3, (List)localObject4);
    localObject3 = ((n)localObject4).TKY.hLg();
    Object localObject5 = ((n)localObject4).TKY;
    localObject1 = this.TLm.SZI;
    kotlin.g.b.p.h(paramq, "$this$underlyingType");
    kotlin.g.b.p.h(localObject1, "typeTable");
    if (paramq.hHr())
    {
      localObject1 = paramq.TzG;
      kotlin.g.b.p.g(localObject1, "underlyingType");
      localObject1 = ((ad)localObject5).s((a.p)localObject1);
      localObject4 = ((n)localObject4).TKY;
      localObject5 = this.TLm.SZI;
      kotlin.g.b.p.h(paramq, "$this$expandedType");
      kotlin.g.b.p.h(localObject5, "typeTable");
      if (!paramq.hHt()) {
        break label446;
      }
      paramq = paramq.TzI;
      kotlin.g.b.p.g(paramq, "expandedType");
    }
    for (;;)
    {
      paramq = ((ad)localObject4).s(paramq);
      localObject4 = (kotlin.l.b.a.b.k.a.b.g)localObject2;
      ((kotlin.l.b.a.b.k.a.b.l)localObject2).a((List)localObject3, (kotlin.l.b.a.b.m.aj)localObject1, paramq, kotlin.l.b.a.b.k.a.b.g.a.TMp);
      paramq = (ar)localObject2;
      AppMethodBeat.o(60332);
      return paramq;
      if (paramq.hHs())
      {
        localObject1 = ((h)localObject1).avo(paramq.TzH);
        break;
      }
      paramq = (Throwable)new IllegalStateException("No underlyingType in ProtoBuf.TypeAlias".toString());
      AppMethodBeat.o(60332);
      throw paramq;
      label446:
      if (!paramq.hHu()) {
        break label466;
      }
      paramq = ((h)localObject5).avo(paramq.TzJ);
    }
    label466:
    paramq = (Throwable)new IllegalStateException("No expandedType in ProtoBuf.TypeAlias".toString());
    AppMethodBeat.o(60332);
    throw paramq;
  }
  
  public final ah g(final a.m paramm)
  {
    AppMethodBeat.i(60329);
    kotlin.g.b.p.h(paramm, "proto");
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
    if (paramm.hEP())
    {
      i = paramm.Txb;
      localObject1 = this.TLm.Tko;
      localObject2 = a((kotlin.l.b.a.b.h.q)paramm, i, b.TKu);
      localObject3 = aa.TLC;
      localObject3 = aa.a((a.j)kotlin.l.b.a.b.e.b.b.TAW.get(i));
      localObject4 = aa.TLC;
      localObject4 = aa.a((a.w)kotlin.l.b.a.b.e.b.b.TAV.get(i));
      localObject5 = kotlin.l.b.a.b.e.b.b.TBn.avk(i);
      kotlin.g.b.p.g(localObject5, "Flags.IS_VAR.get(flags)");
      bool1 = ((Boolean)localObject5).booleanValue();
      localObject5 = x.b(this.TLm.SZH, paramm.Tyk);
      Object localObject6 = aa.TLC;
      localObject6 = aa.a((a.i)kotlin.l.b.a.b.e.b.b.TBf.get(i));
      Object localObject7 = kotlin.l.b.a.b.e.b.b.TBr.avk(i);
      kotlin.g.b.p.g(localObject7, "Flags.IS_LATEINIT.get(flags)");
      boolean bool2 = ((Boolean)localObject7).booleanValue();
      localObject7 = kotlin.l.b.a.b.e.b.b.TBq.avk(i);
      kotlin.g.b.p.g(localObject7, "Flags.IS_CONST.get(flags)");
      boolean bool3 = ((Boolean)localObject7).booleanValue();
      localObject7 = kotlin.l.b.a.b.e.b.b.TBt.avk(i);
      kotlin.g.b.p.g(localObject7, "Flags.IS_EXTERNAL_PROPERTY.get(flags)");
      boolean bool4 = ((Boolean)localObject7).booleanValue();
      localObject7 = kotlin.l.b.a.b.e.b.b.TBu.avk(i);
      kotlin.g.b.p.g(localObject7, "Flags.IS_DELEGATED.get(flags)");
      boolean bool5 = ((Boolean)localObject7).booleanValue();
      localObject7 = kotlin.l.b.a.b.e.b.b.TBv.avk(i);
      kotlin.g.b.p.g(localObject7, "Flags.IS_EXPECT_PROPERTY.get(flags)");
      localObject3 = new kotlin.l.b.a.b.k.a.b.j((kotlin.l.b.a.b.b.l)localObject1, null, (kotlin.l.b.a.b.b.a.g)localObject2, (kotlin.l.b.a.b.b.w)localObject3, (ba)localObject4, bool1, (kotlin.l.b.a.b.f.f)localObject5, (kotlin.l.b.a.b.b.b.a)localObject6, bool2, bool3, bool4, bool5, ((Boolean)localObject7).booleanValue(), paramm, this.TLm.SZH, this.TLm.SZI, this.TLm.TLa, this.TLm.TLb);
      localObject1 = this.TLm;
      localObject2 = (kotlin.l.b.a.b.b.l)localObject3;
      localObject4 = paramm.Txu;
      kotlin.g.b.p.g(localObject4, "proto.typeParameterList");
      localObject4 = n.a((n)localObject1, (kotlin.l.b.a.b.b.l)localObject2, (List)localObject4);
      localObject1 = kotlin.l.b.a.b.e.b.b.TBo.avk(i);
      kotlin.g.b.p.g(localObject1, "Flags.HAS_GETTER.get(flags)");
      bool1 = ((Boolean)localObject1).booleanValue();
      if ((!bool1) || (!kotlin.l.b.a.b.e.b.g.e(paramm))) {
        break label1194;
      }
      localObject1 = a((kotlin.l.b.a.b.h.q)paramm, b.TKv);
      localObject2 = ((n)localObject4).TKY.r(kotlin.l.b.a.b.e.b.g.a(paramm, this.TLm.SZI));
      localObject5 = ((n)localObject4).TKY.hLg();
      localObject6 = hAs();
      localObject7 = kotlin.l.b.a.b.e.b.g.b(paramm, this.TLm.SZI);
      if (localObject7 == null) {
        break label1207;
      }
      localObject7 = ((n)localObject4).TKY.r((a.p)localObject7);
      if (localObject7 == null) {
        break label1207;
      }
      localObject1 = kotlin.l.b.a.b.j.b.a((kotlin.l.b.a.b.b.a)localObject3, (kotlin.l.b.a.b.m.ab)localObject7, (kotlin.l.b.a.b.b.a.g)localObject1);
      ((kotlin.l.b.a.b.k.a.b.j)localObject3).a((kotlin.l.b.a.b.m.ab)localObject2, (List)localObject5, (ak)localObject6, (ak)localObject1);
      localObject1 = kotlin.l.b.a.b.e.b.b.TAU.avk(i);
      kotlin.g.b.p.g(localObject1, "Flags.HAS_ANNOTATIONS.get(flags)");
      j = kotlin.l.b.a.b.e.b.b.a(((Boolean)localObject1).booleanValue(), (a.w)kotlin.l.b.a.b.e.b.b.TAV.get(i), (a.j)kotlin.l.b.a.b.e.b.b.TAW.get(i));
      if (!bool1) {
        break label1248;
      }
      if (!paramm.hGx()) {
        break label1213;
      }
      k = paramm.TyV;
      label576:
      localObject1 = kotlin.l.b.a.b.e.b.b.TBz.avk(k);
      kotlin.g.b.p.g(localObject1, "Flags.IS_NOT_DEFAULT.get(getterFlags)");
      bool1 = ((Boolean)localObject1).booleanValue();
      localObject1 = kotlin.l.b.a.b.e.b.b.TBA.avk(k);
      kotlin.g.b.p.g(localObject1, "Flags.IS_EXTERNAL_ACCESSOR.get(getterFlags)");
      bool2 = ((Boolean)localObject1).booleanValue();
      localObject1 = kotlin.l.b.a.b.e.b.b.TBB.avk(k);
      kotlin.g.b.p.g(localObject1, "Flags.IS_INLINE_ACCESSOR.get(getterFlags)");
      bool3 = ((Boolean)localObject1).booleanValue();
      localObject1 = a((kotlin.l.b.a.b.h.q)paramm, k, b.TKv);
      if (!bool1) {
        break label1225;
      }
      localObject2 = (ah)localObject3;
      localObject5 = aa.TLC;
      localObject5 = aa.a((a.j)kotlin.l.b.a.b.e.b.b.TAW.get(k));
      localObject6 = aa.TLC;
      localObject6 = aa.a((a.w)kotlin.l.b.a.b.e.b.b.TAV.get(k));
      if (bool1) {
        break label1219;
      }
      bool1 = true;
      label728:
      localObject1 = new kotlin.l.b.a.b.b.c.ab((ah)localObject2, (kotlin.l.b.a.b.b.a.g)localObject1, (kotlin.l.b.a.b.b.w)localObject5, (ba)localObject6, bool1, bool2, bool3, ((kotlin.l.b.a.b.k.a.b.j)localObject3).hAA(), null, an.ThK);
      label760:
      ((kotlin.l.b.a.b.b.c.ab)localObject1).J(((kotlin.l.b.a.b.k.a.b.j)localObject3).hAu());
      localObject2 = localObject1;
      label774:
      localObject1 = kotlin.l.b.a.b.e.b.b.TBp.avk(i);
      kotlin.g.b.p.g(localObject1, "Flags.HAS_SETTER.get(flags)");
      if (!((Boolean)localObject1).booleanValue()) {
        break label1295;
      }
      if (paramm.hGy()) {
        j = paramm.TyW;
      }
      localObject1 = kotlin.l.b.a.b.e.b.b.TBz.avk(j);
      kotlin.g.b.p.g(localObject1, "Flags.IS_NOT_DEFAULT.get(setterFlags)");
      bool1 = ((Boolean)localObject1).booleanValue();
      localObject1 = kotlin.l.b.a.b.e.b.b.TBA.avk(j);
      kotlin.g.b.p.g(localObject1, "Flags.IS_EXTERNAL_ACCESSOR.get(setterFlags)");
      bool2 = ((Boolean)localObject1).booleanValue();
      localObject1 = kotlin.l.b.a.b.e.b.b.TBB.avk(j);
      kotlin.g.b.p.g(localObject1, "Flags.IS_INLINE_ACCESSOR.get(setterFlags)");
      bool3 = ((Boolean)localObject1).booleanValue();
      localObject1 = a((kotlin.l.b.a.b.h.q)paramm, j, b.TKw);
      if (!bool1) {
        break label1260;
      }
      localObject5 = (ah)localObject3;
      localObject6 = aa.TLC;
      localObject6 = aa.a((a.j)kotlin.l.b.a.b.e.b.b.TAW.get(j));
      localObject7 = aa.TLC;
      localObject7 = aa.a((a.w)kotlin.l.b.a.b.e.b.b.TAV.get(j));
      if (bool1) {
        break label1254;
      }
      bool1 = true;
      label957:
      localObject1 = new kotlin.l.b.a.b.b.c.ac((ah)localObject5, (kotlin.l.b.a.b.b.a.g)localObject1, (kotlin.l.b.a.b.b.w)localObject6, (ba)localObject7, bool1, bool2, bool3, ((kotlin.l.b.a.b.k.a.b.j)localObject3).hAA(), null, an.ThK);
      ((kotlin.l.b.a.b.b.c.ac)localObject1).a((av)kotlin.a.j.kw(n.a((n)localObject4, (kotlin.l.b.a.b.b.l)localObject1, (List)v.SXr).TKZ.a(kotlin.a.j.listOf(paramm.TyU), (kotlin.l.b.a.b.h.q)paramm, b.TKw)));
    }
    for (;;)
    {
      localObject4 = kotlin.l.b.a.b.e.b.b.TBs.avk(i);
      kotlin.g.b.p.g(localObject4, "Flags.HAS_CONSTANT.get(flags)");
      if (((Boolean)localObject4).booleanValue()) {
        ((kotlin.l.b.a.b.k.a.b.j)localObject3).a(this.TLm.Tvt.TcN.am((kotlin.g.a.a)new d(this, paramm, (kotlin.l.b.a.b.k.a.b.j)localObject3)));
      }
      localObject1 = (kotlin.l.b.a.b.b.aj)localObject1;
      localObject4 = (r)new o(a(paramm, false), (ah)localObject3);
      paramm = (r)new o(a(paramm, true), (ah)localObject3);
      localObject5 = (kotlin.l.b.a.b.k.a.b.g)localObject3;
      ((kotlin.l.b.a.b.k.a.b.j)localObject3).a((kotlin.l.b.a.b.b.c.ab)localObject2, (kotlin.l.b.a.b.b.aj)localObject1, (r)localObject4, paramm, kotlin.l.b.a.b.k.a.b.g.a.TMp);
      paramm = (ah)localObject3;
      AppMethodBeat.o(60329);
      return paramm;
      i = avH(paramm.Tyx);
      break;
      label1194:
      localObject1 = kotlin.l.b.a.b.b.a.g.TiC;
      localObject1 = kotlin.l.b.a.b.b.a.g.a.hBP();
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
      kotlin.g.b.p.g(localObject1, "DescriptorFactory.create…er(property, annotations)");
      break label760;
      label1248:
      localObject2 = null;
      break label774;
      label1254:
      bool1 = false;
      break label957;
      label1260:
      localObject4 = (ah)localObject3;
      localObject5 = kotlin.l.b.a.b.b.a.g.TiC;
      localObject1 = kotlin.l.b.a.b.j.b.a((ah)localObject4, (kotlin.l.b.a.b.b.a.g)localObject1, kotlin.l.b.a.b.b.a.g.a.hBP());
      kotlin.g.b.p.g(localObject1, "DescriptorFactory.create…ptor */\n                )");
      continue;
      label1295:
      localObject1 = null;
    }
  }
  
  public final am g(a.h paramh)
  {
    AppMethodBeat.i(60331);
    kotlin.g.b.p.h(paramh, "proto");
    int i;
    Object localObject3;
    label58:
    Object localObject2;
    label104:
    Object localObject4;
    Object localObject5;
    Object localObject6;
    if (paramh.hEP())
    {
      i = paramh.Txb;
      localObject3 = a((kotlin.l.b.a.b.h.q)paramh, i, b.TKt);
      if (!kotlin.l.b.a.b.e.b.g.f(paramh)) {
        break label662;
      }
      localObject1 = a((kotlin.l.b.a.b.h.q)paramh, b.TKt);
      if (!kotlin.g.b.p.j(kotlin.l.b.a.b.j.d.a.o(this.TLm.Tko).p(x.b(this.TLm.SZH, paramh.Tyk)), ac.TLE)) {
        break label673;
      }
      localObject2 = i.TBK;
      localObject2 = i.hIl();
      localObject4 = this.TLm.Tko;
      localObject5 = x.b(this.TLm.SZH, paramh.Tyk);
      localObject6 = aa.TLC;
      localObject2 = new kotlin.l.b.a.b.k.a.b.k((kotlin.l.b.a.b.b.l)localObject4, (kotlin.l.b.a.b.b.a.g)localObject3, (kotlin.l.b.a.b.f.f)localObject5, aa.a((a.i)kotlin.l.b.a.b.e.b.b.TBf.get(i)), paramh, this.TLm.SZH, this.TLm.SZI, (i)localObject2, this.TLm.TLb);
      localObject3 = this.TLm;
      localObject4 = (kotlin.l.b.a.b.b.l)localObject2;
      localObject5 = paramh.Txu;
      kotlin.g.b.p.g(localObject5, "proto.typeParameterList");
      localObject5 = n.a((n)localObject3, (kotlin.l.b.a.b.b.l)localObject4, (List)localObject5);
      localObject3 = kotlin.l.b.a.b.e.b.g.b(paramh, this.TLm.SZI);
      if (localObject3 == null) {
        break label685;
      }
      localObject3 = ((n)localObject5).TKY.r((a.p)localObject3);
      if (localObject3 == null) {
        break label685;
      }
    }
    label662:
    label673:
    label685:
    for (Object localObject1 = kotlin.l.b.a.b.j.b.a((kotlin.l.b.a.b.b.a)localObject2, (kotlin.l.b.a.b.m.ab)localObject3, (kotlin.l.b.a.b.b.a.g)localObject1);; localObject1 = null)
    {
      localObject3 = hAs();
      localObject4 = ((n)localObject5).TKY.hLg();
      localObject6 = ((n)localObject5).TKZ;
      Object localObject7 = paramh.TxT;
      kotlin.g.b.p.g(localObject7, "proto.valueParameterList");
      localObject6 = ((w)localObject6).a((List)localObject7, (kotlin.l.b.a.b.h.q)paramh, b.TKt);
      localObject5 = ((n)localObject5).TKY.r(kotlin.l.b.a.b.e.b.g.a(paramh, this.TLm.SZI));
      localObject7 = aa.TLC;
      localObject7 = aa.a((a.j)kotlin.l.b.a.b.e.b.b.TAW.get(i));
      Object localObject8 = aa.TLC;
      localObject8 = aa.a((a.w)kotlin.l.b.a.b.e.b.b.TAV.get(i));
      Map localMap = ae.emptyMap();
      Boolean localBoolean = kotlin.l.b.a.b.e.b.b.TBl.avk(i);
      kotlin.g.b.p.g(localBoolean, "Flags.IS_SUSPEND.get(flags)");
      a((kotlin.l.b.a.b.k.a.b.k)localObject2, (ak)localObject1, (ak)localObject3, (List)localObject4, (List)localObject6, (kotlin.l.b.a.b.m.ab)localObject5, (kotlin.l.b.a.b.b.w)localObject7, (ba)localObject8, localMap, localBoolean.booleanValue());
      localObject1 = kotlin.l.b.a.b.e.b.b.TBg.avk(i);
      kotlin.g.b.p.g(localObject1, "Flags.IS_OPERATOR.get(flags)");
      ((kotlin.l.b.a.b.b.c.p)localObject2).TkM = ((Boolean)localObject1).booleanValue();
      localObject1 = kotlin.l.b.a.b.e.b.b.TBh.avk(i);
      kotlin.g.b.p.g(localObject1, "Flags.IS_INFIX.get(flags)");
      ((kotlin.l.b.a.b.b.c.p)localObject2).TkN = ((Boolean)localObject1).booleanValue();
      localObject1 = kotlin.l.b.a.b.e.b.b.TBk.avk(i);
      kotlin.g.b.p.g(localObject1, "Flags.IS_EXTERNAL_FUNCTION.get(flags)");
      ((kotlin.l.b.a.b.b.c.p)localObject2).Tkp = ((Boolean)localObject1).booleanValue();
      localObject1 = kotlin.l.b.a.b.e.b.b.TBi.avk(i);
      kotlin.g.b.p.g(localObject1, "Flags.IS_INLINE.get(flags)");
      ((kotlin.l.b.a.b.b.c.p)localObject2).TkO = ((Boolean)localObject1).booleanValue();
      localObject1 = kotlin.l.b.a.b.e.b.b.TBj.avk(i);
      kotlin.g.b.p.g(localObject1, "Flags.IS_TAILREC.get(flags)");
      ((kotlin.l.b.a.b.b.c.p)localObject2).TkP = ((Boolean)localObject1).booleanValue();
      localObject1 = kotlin.l.b.a.b.e.b.b.TBl.avk(i);
      kotlin.g.b.p.g(localObject1, "Flags.IS_SUSPEND.get(flags)");
      ((kotlin.l.b.a.b.b.c.p)localObject2).TkU = ((Boolean)localObject1).booleanValue();
      localObject1 = kotlin.l.b.a.b.e.b.b.TBm.avk(i);
      kotlin.g.b.p.g(localObject1, "Flags.IS_EXPECT_FUNCTION.get(flags)");
      ((kotlin.l.b.a.b.b.c.p)localObject2).TkQ = ((Boolean)localObject1).booleanValue();
      this.TLm.Tvt.TKT.a(paramh, (kotlin.l.b.a.b.b.t)localObject2, this.TLm.SZI, this.TLm.TKY);
      paramh = (am)localObject2;
      AppMethodBeat.o(60331);
      return paramh;
      i = avH(paramh.Tyx);
      break;
      localObject1 = kotlin.l.b.a.b.b.a.g.TiC;
      localObject1 = kotlin.l.b.a.b.b.a.g.a.hBP();
      break label58;
      localObject2 = this.TLm.TLa;
      break label104;
    }
  }
  
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.a<List<? extends kotlin.l.b.a.b.b.a.c>>
  {
    a(w paramw, kotlin.l.b.a.b.h.q paramq, b paramb)
    {
      super();
    }
  }
  
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<List<? extends kotlin.l.b.a.b.b.a.c>>
  {
    b(w paramw, boolean paramBoolean, a.m paramm)
    {
      super();
    }
  }
  
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<List<? extends kotlin.l.b.a.b.b.a.c>>
  {
    c(w paramw, kotlin.l.b.a.b.h.q paramq, b paramb)
    {
      super();
    }
  }
  
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<kotlin.l.b.a.b.j.b.g<?>>
  {
    d(w paramw, a.m paramm, kotlin.l.b.a.b.k.a.b.j paramj)
    {
      super();
    }
  }
  
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<List<? extends kotlin.l.b.a.b.b.a.c>>
  {
    e(int paramInt, a.t paramt, w paramw, z paramz, kotlin.l.b.a.b.h.q paramq, b paramb, kotlin.l.b.a.b.b.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.w
 * JD-Core Version:    0.7.0.1
 */