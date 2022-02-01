package d.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ae;
import d.l.b.a.b.b.a.c;
import d.l.b.a.b.b.ah;
import d.l.b.a.b.b.ak;
import d.l.b.a.b.b.am;
import d.l.b.a.b.b.an;
import d.l.b.a.b.b.ar;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.av;
import d.l.b.a.b.b.ba;
import d.l.b.a.b.b.c.o;
import d.l.b.a.b.b.c.p;
import d.l.b.a.b.b.r;
import d.l.b.a.b.b.t;
import d.l.b.a.b.e.a.c;
import d.l.b.a.b.e.a.h;
import d.l.b.a.b.e.a.i;
import d.l.b.a.b.e.a.j;
import d.l.b.a.b.e.a.m;
import d.l.b.a.b.e.a.p;
import d.l.b.a.b.e.a.q;
import d.l.b.a.b.e.a.t;
import d.l.b.a.b.e.a.w;
import d.l.b.a.b.e.b.b.c;
import d.l.b.a.b.e.b.h;
import d.l.b.a.b.h.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class w
{
  private final n LIl;
  private final f LrB;
  
  public w(n paramn)
  {
    AppMethodBeat.i(60340);
    this.LIl = paramn;
    this.LrB = new f(this.LIl.LrK.Lcw, this.LIl.LrK.Lbj);
    AppMethodBeat.o(60340);
  }
  
  private final z K(d.l.b.a.b.b.l paraml)
  {
    AppMethodBeat.i(60339);
    if ((paraml instanceof d.l.b.a.b.b.ab))
    {
      paraml = (z)new z.b(((d.l.b.a.b.b.ab)paraml).fRH(), this.LIl.KVO, this.LIl.KVP, (an)this.LIl.LIa);
      AppMethodBeat.o(60339);
      return paraml;
    }
    if ((paraml instanceof d.l.b.a.b.k.a.b.e))
    {
      paraml = (z)((d.l.b.a.b.k.a.b.e)paraml).LJf;
      AppMethodBeat.o(60339);
      return paraml;
    }
    AppMethodBeat.o(60339);
    return null;
  }
  
  private final d.l.b.a.b.b.a.g a(final a.m paramm, final boolean paramBoolean)
  {
    AppMethodBeat.i(60336);
    if (!d.l.b.a.b.e.b.b.Lxo.aij(paramm.Ltw).booleanValue())
    {
      paramm = d.l.b.a.b.b.a.g.LeU;
      paramm = d.l.b.a.b.b.a.g.a.fSm();
      AppMethodBeat.o(60336);
      return paramm;
    }
    paramm = (d.l.b.a.b.b.a.g)new d.l.b.a.b.k.a.b.n(this.LIl.LrK.KZf, (d.g.a.a)new b(this, paramBoolean, paramm));
    AppMethodBeat.o(60336);
    return paramm;
  }
  
  private final d.l.b.a.b.b.a.g a(final q paramq, int paramInt, final b paramb)
  {
    AppMethodBeat.i(60335);
    if (!d.l.b.a.b.e.b.b.Lxo.aij(paramInt).booleanValue())
    {
      paramq = d.l.b.a.b.b.a.g.LeU;
      paramq = d.l.b.a.b.b.a.g.a.fSm();
      AppMethodBeat.o(60335);
      return paramq;
    }
    paramq = (d.l.b.a.b.b.a.g)new d.l.b.a.b.k.a.b.n(this.LIl.LrK.KZf, (d.g.a.a)new a(this, paramq, paramb));
    AppMethodBeat.o(60335);
    return paramq;
  }
  
  private final d.l.b.a.b.b.a.g a(final q paramq, final b paramb)
  {
    AppMethodBeat.i(60337);
    paramq = (d.l.b.a.b.b.a.g)new d.l.b.a.b.k.a.b.b(this.LIl.LrK.KZf, (d.g.a.a)new c(this, paramq, paramb));
    AppMethodBeat.o(60337);
    return paramq;
  }
  
  private final List<av> a(List<a.t> paramList, final q paramq, final b paramb)
  {
    AppMethodBeat.i(60338);
    Object localObject1 = this.LIl.LgE;
    if (localObject1 == null)
    {
      paramList = new d.v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
      AppMethodBeat.o(60338);
      throw paramList;
    }
    final d.l.b.a.b.b.a locala = (d.l.b.a.b.b.a)localObject1;
    localObject1 = locala.fPU();
    d.g.b.k.g(localObject1, "callableDescriptor.containingDeclaration");
    final z localz = K((d.l.b.a.b.b.l)localObject1);
    paramList = (Iterable)paramList;
    Collection localCollection = (Collection)new ArrayList(d.a.j.a(paramList, 10));
    int i = 0;
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      paramList = localIterator.next();
      if (i < 0) {
        d.a.j.fOc();
      }
      localObject1 = (a.t)paramList;
      int j;
      label148:
      label217:
      d.l.b.a.b.f.f localf;
      d.l.b.a.b.m.ab localab;
      Object localObject2;
      boolean bool1;
      boolean bool2;
      boolean bool3;
      if (((a.t)localObject1).fVp())
      {
        j = ((a.t)localObject1).Ltw;
        if (localz == null) {
          break label429;
        }
        paramList = d.l.b.a.b.e.b.b.Lxo.aij(j);
        d.g.b.k.g(paramList, "Flags.HAS_ANNOTATIONS.get(flags)");
        if (!paramList.booleanValue()) {
          break label429;
        }
        paramList = (d.l.b.a.b.b.a.g)new d.l.b.a.b.k.a.b.n(this.LIl.LrK.KZf, (d.g.a.a)new e(i, (a.t)localObject1, this, localz, paramq, paramb, locala));
        localf = x.b(this.LIl.KVO, ((a.t)localObject1).LuF);
        localab = this.LIl.LHX.r(d.l.b.a.b.e.b.g.a((a.t)localObject1, this.LIl.KVP));
        localObject2 = d.l.b.a.b.e.b.b.LxP.aij(j);
        d.g.b.k.g(localObject2, "Flags.DECLARES_DEFAULT_VALUE.get(flags)");
        bool1 = ((Boolean)localObject2).booleanValue();
        localObject2 = d.l.b.a.b.e.b.b.LxQ.aij(j);
        d.g.b.k.g(localObject2, "Flags.IS_CROSSINLINE.get(flags)");
        bool2 = ((Boolean)localObject2).booleanValue();
        localObject2 = d.l.b.a.b.e.b.b.LxR.aij(j);
        d.g.b.k.g(localObject2, "Flags.IS_NOINLINE.get(flags)");
        bool3 = ((Boolean)localObject2).booleanValue();
        localObject1 = d.l.b.a.b.e.b.g.b((a.t)localObject1, this.LIl.KVP);
        if (localObject1 == null) {
          break label440;
        }
      }
      label429:
      label440:
      for (localObject1 = this.LIl.LHX.r((a.p)localObject1);; localObject1 = null)
      {
        localObject2 = an.Lec;
        d.g.b.k.g(localObject2, "SourceElement.NO_SOURCE");
        localCollection.add(new d.l.b.a.b.b.c.aj(locala, null, i, paramList, localf, localab, bool1, bool2, bool3, (d.l.b.a.b.m.ab)localObject1, (an)localObject2));
        i += 1;
        break;
        j = 0;
        break label148;
        paramList = d.l.b.a.b.b.a.g.LeU;
        paramList = d.l.b.a.b.b.a.g.a.fSm();
        break label217;
      }
    }
    paramList = d.a.j.l((Iterable)localCollection);
    AppMethodBeat.o(60338);
    return paramList;
  }
  
  private static void a(d.l.b.a.b.k.a.b.k paramk, ak paramak1, ak paramak2, List<? extends as> paramList, List<? extends av> paramList1, d.l.b.a.b.m.ab paramab, d.l.b.a.b.b.w paramw, ba paramba, Map<? extends d.l.b.a.b.b.a.a<?>, ?> paramMap)
  {
    AppMethodBeat.i(60330);
    paramk.a(paramak1, paramak2, paramList, paramList1, paramab, paramw, paramba, paramMap, d.l.b.a.b.k.a.b.g.a.LJr);
    AppMethodBeat.o(60330);
  }
  
  private static int aiN(int paramInt)
  {
    return (paramInt & 0x3F) + (paramInt >> 8 << 6);
  }
  
  private final ak fQQ()
  {
    AppMethodBeat.i(60333);
    d.l.b.a.b.b.l locall = this.LIl.LgE;
    Object localObject = locall;
    if (!(locall instanceof d.l.b.a.b.b.e)) {
      localObject = null;
    }
    localObject = (d.l.b.a.b.b.e)localObject;
    if (localObject != null)
    {
      localObject = ((d.l.b.a.b.b.e)localObject).fRl();
      AppMethodBeat.o(60333);
      return localObject;
    }
    AppMethodBeat.o(60333);
    return null;
  }
  
  public final d.l.b.a.b.b.d a(a.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(60334);
    d.g.b.k.h(paramc, "proto");
    Object localObject1 = this.LIl.LgE;
    if (localObject1 == null)
    {
      paramc = new d.v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
      AppMethodBeat.o(60334);
      throw paramc;
    }
    localObject1 = (d.l.b.a.b.b.e)localObject1;
    d.l.b.a.b.k.a.b.d locald = new d.l.b.a.b.k.a.b.d((d.l.b.a.b.b.e)localObject1, a((q)paramc, paramc.Ltw, b.LHs), paramBoolean, d.l.b.a.b.b.b.a.Ldo, paramc, this.LIl.KVO, this.LIl.KVP, this.LIl.LHZ, this.LIl.LIa);
    Object localObject2 = n.a(this.LIl, (d.l.b.a.b.b.l)locald, (List)d.a.v.KTF).LHY;
    Object localObject3 = paramc.Luo;
    d.g.b.k.g(localObject3, "proto.valueParameterList");
    localObject2 = ((w)localObject2).a((List)localObject3, (q)paramc, b.LHs);
    localObject3 = aa.LIB;
    locald.a((List)localObject2, aa.a((a.w)d.l.b.a.b.e.b.b.Lxp.get(paramc.Ltw)));
    locald.J((d.l.b.a.b.m.ab)((d.l.b.a.b.b.e)localObject1).fRe());
    d.g.b.k.g(locald.fQU(), "descriptor.valueParameters");
    d.g.b.k.g(locald.fQR(), "descriptor.typeParameters");
    locald.fQS();
    locald.a(d.l.b.a.b.k.a.b.g.a.LJr);
    paramc = (d.l.b.a.b.b.d)locald;
    AppMethodBeat.o(60334);
    return paramc;
  }
  
  public final ar f(a.q paramq)
  {
    AppMethodBeat.i(60332);
    d.g.b.k.h(paramq, "proto");
    Object localObject1 = d.l.b.a.b.b.a.g.LeU;
    localObject1 = paramq.Lwf;
    d.g.b.k.g(localObject1, "proto.annotationList");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (d.l.b.a.b.e.a.a)((Iterator)localObject2).next();
      localObject4 = this.LrB;
      d.g.b.k.g(localObject3, "it");
      ((Collection)localObject1).add(((f)localObject4).b((d.l.b.a.b.e.a.a)localObject3, this.LIl.KVO));
    }
    localObject1 = d.l.b.a.b.b.a.g.a.iX((List)localObject1);
    localObject2 = aa.LIB;
    localObject2 = aa.a((a.w)d.l.b.a.b.e.b.b.Lxp.get(paramq.Ltw));
    localObject2 = new d.l.b.a.b.k.a.b.l(this.LIl.LrK.KZf, this.LIl.LgE, (d.l.b.a.b.b.a.g)localObject1, x.b(this.LIl.KVO, paramq.LuF), (ba)localObject2, paramq, this.LIl.KVO, this.LIl.KVP, this.LIl.LHZ, this.LIl.LIa);
    localObject1 = this.LIl;
    Object localObject3 = (d.l.b.a.b.b.l)localObject2;
    Object localObject4 = paramq.LtP;
    d.g.b.k.g(localObject4, "proto.typeParameterList");
    localObject4 = n.a((n)localObject1, (d.l.b.a.b.b.l)localObject3, (List)localObject4);
    localObject3 = ((n)localObject4).LHX.gcc();
    Object localObject5 = ((n)localObject4).LHX;
    localObject1 = this.LIl.KVP;
    d.g.b.k.h(paramq, "$this$underlyingType");
    d.g.b.k.h(localObject1, "typeTable");
    if (paramq.fXT())
    {
      localObject1 = paramq.Lwb;
      d.g.b.k.g(localObject1, "underlyingType");
      localObject1 = ((ad)localObject5).s((a.p)localObject1);
      localObject4 = ((n)localObject4).LHX;
      localObject5 = this.LIl.KVP;
      d.g.b.k.h(paramq, "$this$expandedType");
      d.g.b.k.h(localObject5, "typeTable");
      if (!paramq.fXV()) {
        break label438;
      }
      paramq = paramq.Lwd;
      d.g.b.k.g(paramq, "expandedType");
    }
    for (;;)
    {
      ((d.l.b.a.b.k.a.b.l)localObject2).a((List)localObject3, (d.l.b.a.b.m.aj)localObject1, ((ad)localObject4).s(paramq), d.l.b.a.b.k.a.b.g.a.LJr);
      paramq = (ar)localObject2;
      AppMethodBeat.o(60332);
      return paramq;
      if (paramq.fXU())
      {
        localObject1 = ((h)localObject1).ain(paramq.Lwc);
        break;
      }
      paramq = (Throwable)new IllegalStateException("No underlyingType in ProtoBuf.TypeAlias".toString());
      AppMethodBeat.o(60332);
      throw paramq;
      label438:
      if (!paramq.fXW()) {
        break label458;
      }
      paramq = ((h)localObject5).ain(paramq.Lwe);
    }
    label458:
    paramq = (Throwable)new IllegalStateException("No expandedType in ProtoBuf.TypeAlias".toString());
    AppMethodBeat.o(60332);
    throw paramq;
  }
  
  public final ah g(final a.m paramm)
  {
    AppMethodBeat.i(60329);
    d.g.b.k.h(paramm, "proto");
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
    if (paramm.fVp())
    {
      i = paramm.Ltw;
      localObject1 = this.LIl.LgE;
      localObject2 = a((q)paramm, i, b.LHt);
      localObject3 = aa.LIB;
      localObject3 = aa.a((a.j)d.l.b.a.b.e.b.b.Lxq.get(i));
      localObject4 = aa.LIB;
      localObject4 = aa.a((a.w)d.l.b.a.b.e.b.b.Lxp.get(i));
      localObject5 = d.l.b.a.b.e.b.b.LxG.aij(i);
      d.g.b.k.g(localObject5, "Flags.IS_VAR.get(flags)");
      bool1 = ((Boolean)localObject5).booleanValue();
      localObject5 = x.b(this.LIl.KVO, paramm.LuF);
      Object localObject6 = aa.LIB;
      localObject6 = aa.a((a.i)d.l.b.a.b.e.b.b.Lxy.get(i));
      Object localObject7 = d.l.b.a.b.e.b.b.LxK.aij(i);
      d.g.b.k.g(localObject7, "Flags.IS_LATEINIT.get(flags)");
      boolean bool2 = ((Boolean)localObject7).booleanValue();
      localObject7 = d.l.b.a.b.e.b.b.LxJ.aij(i);
      d.g.b.k.g(localObject7, "Flags.IS_CONST.get(flags)");
      boolean bool3 = ((Boolean)localObject7).booleanValue();
      localObject7 = d.l.b.a.b.e.b.b.LxM.aij(i);
      d.g.b.k.g(localObject7, "Flags.IS_EXTERNAL_PROPERTY.get(flags)");
      boolean bool4 = ((Boolean)localObject7).booleanValue();
      localObject7 = d.l.b.a.b.e.b.b.LxN.aij(i);
      d.g.b.k.g(localObject7, "Flags.IS_DELEGATED.get(flags)");
      boolean bool5 = ((Boolean)localObject7).booleanValue();
      localObject7 = d.l.b.a.b.e.b.b.LxO.aij(i);
      d.g.b.k.g(localObject7, "Flags.IS_EXPECT_PROPERTY.get(flags)");
      localObject3 = new d.l.b.a.b.k.a.b.j((d.l.b.a.b.b.l)localObject1, null, (d.l.b.a.b.b.a.g)localObject2, (d.l.b.a.b.b.w)localObject3, (ba)localObject4, bool1, (d.l.b.a.b.f.f)localObject5, (d.l.b.a.b.b.b.a)localObject6, bool2, bool3, bool4, bool5, ((Boolean)localObject7).booleanValue(), paramm, this.LIl.KVO, this.LIl.KVP, this.LIl.LHZ, this.LIl.LIa);
      localObject1 = this.LIl;
      localObject2 = (d.l.b.a.b.b.l)localObject3;
      localObject4 = paramm.LtP;
      d.g.b.k.g(localObject4, "proto.typeParameterList");
      localObject4 = n.a((n)localObject1, (d.l.b.a.b.b.l)localObject2, (List)localObject4);
      localObject1 = d.l.b.a.b.e.b.b.LxH.aij(i);
      d.g.b.k.g(localObject1, "Flags.HAS_GETTER.get(flags)");
      bool1 = ((Boolean)localObject1).booleanValue();
      if ((!bool1) || (!d.l.b.a.b.e.b.g.e(paramm))) {
        break label1177;
      }
      localObject1 = a((q)paramm, b.LHu);
      localObject2 = ((n)localObject4).LHX.r(d.l.b.a.b.e.b.g.a(paramm, this.LIl.KVP));
      localObject5 = ((n)localObject4).LHX.gcc();
      localObject6 = fQQ();
      localObject7 = d.l.b.a.b.e.b.g.b(paramm, this.LIl.KVP);
      if (localObject7 == null) {
        break label1190;
      }
      localObject7 = ((n)localObject4).LHX.r((a.p)localObject7);
      if (localObject7 == null) {
        break label1190;
      }
      localObject1 = d.l.b.a.b.j.b.a((d.l.b.a.b.b.a)localObject3, (d.l.b.a.b.m.ab)localObject7, (d.l.b.a.b.b.a.g)localObject1);
      ((d.l.b.a.b.k.a.b.j)localObject3).a((d.l.b.a.b.m.ab)localObject2, (List)localObject5, (ak)localObject6, (ak)localObject1);
      localObject1 = d.l.b.a.b.e.b.b.Lxo.aij(i);
      d.g.b.k.g(localObject1, "Flags.HAS_ANNOTATIONS.get(flags)");
      j = d.l.b.a.b.e.b.b.a(((Boolean)localObject1).booleanValue(), (a.w)d.l.b.a.b.e.b.b.Lxp.get(i), (a.j)d.l.b.a.b.e.b.b.Lxq.get(i));
      if (!bool1) {
        break label1231;
      }
      if (!paramm.fWZ()) {
        break label1196;
      }
      k = paramm.Lvq;
      label576:
      localObject1 = d.l.b.a.b.e.b.b.LxS.aij(k);
      d.g.b.k.g(localObject1, "Flags.IS_NOT_DEFAULT.get(getterFlags)");
      bool1 = ((Boolean)localObject1).booleanValue();
      localObject1 = d.l.b.a.b.e.b.b.LxT.aij(k);
      d.g.b.k.g(localObject1, "Flags.IS_EXTERNAL_ACCESSOR.get(getterFlags)");
      bool2 = ((Boolean)localObject1).booleanValue();
      localObject1 = d.l.b.a.b.e.b.b.LxU.aij(k);
      d.g.b.k.g(localObject1, "Flags.IS_INLINE_ACCESSOR.get(getterFlags)");
      bool3 = ((Boolean)localObject1).booleanValue();
      localObject1 = a((q)paramm, k, b.LHu);
      if (!bool1) {
        break label1208;
      }
      localObject2 = (ah)localObject3;
      localObject5 = aa.LIB;
      localObject5 = aa.a((a.j)d.l.b.a.b.e.b.b.Lxq.get(k));
      localObject6 = aa.LIB;
      localObject6 = aa.a((a.w)d.l.b.a.b.e.b.b.Lxp.get(k));
      if (bool1) {
        break label1202;
      }
      bool1 = true;
      label728:
      localObject1 = new d.l.b.a.b.b.c.ab((ah)localObject2, (d.l.b.a.b.b.a.g)localObject1, (d.l.b.a.b.b.w)localObject5, (ba)localObject6, bool1, bool2, bool3, ((d.l.b.a.b.k.a.b.j)localObject3).fQY(), null, an.Lec);
      label760:
      ((d.l.b.a.b.b.c.ab)localObject1).K(((d.l.b.a.b.k.a.b.j)localObject3).fQS());
      localObject2 = localObject1;
      label774:
      localObject1 = d.l.b.a.b.e.b.b.LxI.aij(i);
      d.g.b.k.g(localObject1, "Flags.HAS_SETTER.get(flags)");
      if (!((Boolean)localObject1).booleanValue()) {
        break label1278;
      }
      if (paramm.fXa()) {
        j = paramm.Lvr;
      }
      localObject1 = d.l.b.a.b.e.b.b.LxS.aij(j);
      d.g.b.k.g(localObject1, "Flags.IS_NOT_DEFAULT.get(setterFlags)");
      bool1 = ((Boolean)localObject1).booleanValue();
      localObject1 = d.l.b.a.b.e.b.b.LxT.aij(j);
      d.g.b.k.g(localObject1, "Flags.IS_EXTERNAL_ACCESSOR.get(setterFlags)");
      bool2 = ((Boolean)localObject1).booleanValue();
      localObject1 = d.l.b.a.b.e.b.b.LxU.aij(j);
      d.g.b.k.g(localObject1, "Flags.IS_INLINE_ACCESSOR.get(setterFlags)");
      bool3 = ((Boolean)localObject1).booleanValue();
      localObject1 = a((q)paramm, j, b.LHv);
      if (!bool1) {
        break label1243;
      }
      localObject5 = (ah)localObject3;
      localObject6 = aa.LIB;
      localObject6 = aa.a((a.j)d.l.b.a.b.e.b.b.Lxq.get(j));
      localObject7 = aa.LIB;
      localObject7 = aa.a((a.w)d.l.b.a.b.e.b.b.Lxp.get(j));
      if (bool1) {
        break label1237;
      }
      bool1 = true;
      label957:
      localObject1 = new d.l.b.a.b.b.c.ac((ah)localObject5, (d.l.b.a.b.b.a.g)localObject1, (d.l.b.a.b.b.w)localObject6, (ba)localObject7, bool1, bool2, bool3, ((d.l.b.a.b.k.a.b.j)localObject3).fQY(), null, an.Lec);
      ((d.l.b.a.b.b.c.ac)localObject1).a((av)d.a.j.iS(n.a((n)localObject4, (d.l.b.a.b.b.l)localObject1, (List)d.a.v.KTF).LHY.a(d.a.j.listOf(paramm.Lvp), (q)paramm, b.LHv)));
    }
    for (;;)
    {
      localObject4 = d.l.b.a.b.e.b.b.LxL.aij(i);
      d.g.b.k.g(localObject4, "Flags.HAS_CONSTANT.get(flags)");
      if (((Boolean)localObject4).booleanValue()) {
        ((d.l.b.a.b.k.a.b.j)localObject3).a(this.LIl.LrK.KZf.P((d.g.a.a)new d(this, paramm, (d.l.b.a.b.k.a.b.j)localObject3)));
      }
      ((d.l.b.a.b.k.a.b.j)localObject3).a((d.l.b.a.b.b.c.ab)localObject2, (d.l.b.a.b.b.aj)localObject1, (r)new o(a(paramm, false), (ah)localObject3), (r)new o(a(paramm, true), (ah)localObject3), d.l.b.a.b.k.a.b.g.a.LJr);
      paramm = (ah)localObject3;
      AppMethodBeat.o(60329);
      return paramm;
      i = aiN(paramm.LuS);
      break;
      label1177:
      localObject1 = d.l.b.a.b.b.a.g.LeU;
      localObject1 = d.l.b.a.b.b.a.g.a.fSm();
      break label414;
      label1190:
      localObject1 = null;
      break label500;
      label1196:
      k = j;
      break label576;
      label1202:
      bool1 = false;
      break label728;
      label1208:
      localObject1 = d.l.b.a.b.j.b.a((ah)localObject3, (d.l.b.a.b.b.a.g)localObject1);
      d.g.b.k.g(localObject1, "DescriptorFactory.create…er(property, annotations)");
      break label760;
      label1231:
      localObject2 = null;
      break label774;
      label1237:
      bool1 = false;
      break label957;
      label1243:
      localObject4 = (ah)localObject3;
      localObject5 = d.l.b.a.b.b.a.g.LeU;
      localObject1 = d.l.b.a.b.j.b.a((ah)localObject4, (d.l.b.a.b.b.a.g)localObject1, d.l.b.a.b.b.a.g.a.fSm());
      d.g.b.k.g(localObject1, "DescriptorFactory.create…ptor */\n                )");
      continue;
      label1278:
      localObject1 = null;
    }
  }
  
  public final am g(a.h paramh)
  {
    AppMethodBeat.i(60331);
    d.g.b.k.h(paramh, "proto");
    int i;
    Object localObject3;
    label58:
    Object localObject2;
    label104:
    Object localObject4;
    Object localObject5;
    Object localObject6;
    if (paramh.fVp())
    {
      i = paramh.Ltw;
      localObject3 = a((q)paramh, i, b.LHs);
      if (!d.l.b.a.b.e.b.g.f(paramh)) {
        break label662;
      }
      localObject1 = a((q)paramh, b.LHs);
      if (!d.g.b.k.g(d.l.b.a.b.j.d.a.o(this.LIl.LgE).p(x.b(this.LIl.KVO, paramh.LuF)), ac.LIG)) {
        break label673;
      }
      localObject2 = d.l.b.a.b.e.b.i.Lyd;
      localObject2 = d.l.b.a.b.e.b.i.fYN();
      localObject4 = this.LIl.LgE;
      localObject5 = x.b(this.LIl.KVO, paramh.LuF);
      localObject6 = aa.LIB;
      localObject2 = new d.l.b.a.b.k.a.b.k((d.l.b.a.b.b.l)localObject4, (d.l.b.a.b.b.a.g)localObject3, (d.l.b.a.b.f.f)localObject5, aa.a((a.i)d.l.b.a.b.e.b.b.Lxy.get(i)), paramh, this.LIl.KVO, this.LIl.KVP, (d.l.b.a.b.e.b.i)localObject2, this.LIl.LIa);
      localObject3 = this.LIl;
      localObject4 = (d.l.b.a.b.b.l)localObject2;
      localObject5 = paramh.LtP;
      d.g.b.k.g(localObject5, "proto.typeParameterList");
      localObject5 = n.a((n)localObject3, (d.l.b.a.b.b.l)localObject4, (List)localObject5);
      localObject3 = d.l.b.a.b.e.b.g.b(paramh, this.LIl.KVP);
      if (localObject3 == null) {
        break label685;
      }
      localObject3 = ((n)localObject5).LHX.r((a.p)localObject3);
      if (localObject3 == null) {
        break label685;
      }
    }
    label662:
    label673:
    label685:
    for (Object localObject1 = d.l.b.a.b.j.b.a((d.l.b.a.b.b.a)localObject2, (d.l.b.a.b.m.ab)localObject3, (d.l.b.a.b.b.a.g)localObject1);; localObject1 = null)
    {
      localObject3 = fQQ();
      localObject4 = ((n)localObject5).LHX.gcc();
      localObject6 = ((n)localObject5).LHY;
      Object localObject7 = paramh.Luo;
      d.g.b.k.g(localObject7, "proto.valueParameterList");
      localObject6 = ((w)localObject6).a((List)localObject7, (q)paramh, b.LHs);
      localObject5 = ((n)localObject5).LHX.r(d.l.b.a.b.e.b.g.a(paramh, this.LIl.KVP));
      localObject7 = aa.LIB;
      localObject7 = aa.a((a.j)d.l.b.a.b.e.b.b.Lxq.get(i));
      Object localObject8 = aa.LIB;
      localObject8 = aa.a((a.w)d.l.b.a.b.e.b.b.Lxp.get(i));
      Map localMap = ae.emptyMap();
      Boolean localBoolean = d.l.b.a.b.e.b.b.LxE.aij(i);
      d.g.b.k.g(localBoolean, "Flags.IS_SUSPEND.get(flags)");
      localBoolean.booleanValue();
      a((d.l.b.a.b.k.a.b.k)localObject2, (ak)localObject1, (ak)localObject3, (List)localObject4, (List)localObject6, (d.l.b.a.b.m.ab)localObject5, (d.l.b.a.b.b.w)localObject7, (ba)localObject8, localMap);
      localObject1 = d.l.b.a.b.e.b.b.Lxz.aij(i);
      d.g.b.k.g(localObject1, "Flags.IS_OPERATOR.get(flags)");
      ((p)localObject2).Lhc = ((Boolean)localObject1).booleanValue();
      localObject1 = d.l.b.a.b.e.b.b.LxA.aij(i);
      d.g.b.k.g(localObject1, "Flags.IS_INFIX.get(flags)");
      ((p)localObject2).Lhd = ((Boolean)localObject1).booleanValue();
      localObject1 = d.l.b.a.b.e.b.b.LxD.aij(i);
      d.g.b.k.g(localObject1, "Flags.IS_EXTERNAL_FUNCTION.get(flags)");
      ((p)localObject2).LgF = ((Boolean)localObject1).booleanValue();
      localObject1 = d.l.b.a.b.e.b.b.LxB.aij(i);
      d.g.b.k.g(localObject1, "Flags.IS_INLINE.get(flags)");
      ((p)localObject2).Lhe = ((Boolean)localObject1).booleanValue();
      localObject1 = d.l.b.a.b.e.b.b.LxC.aij(i);
      d.g.b.k.g(localObject1, "Flags.IS_TAILREC.get(flags)");
      ((p)localObject2).Lhf = ((Boolean)localObject1).booleanValue();
      localObject1 = d.l.b.a.b.e.b.b.LxE.aij(i);
      d.g.b.k.g(localObject1, "Flags.IS_SUSPEND.get(flags)");
      ((p)localObject2).Lhk = ((Boolean)localObject1).booleanValue();
      localObject1 = d.l.b.a.b.e.b.b.LxF.aij(i);
      d.g.b.k.g(localObject1, "Flags.IS_EXPECT_FUNCTION.get(flags)");
      ((p)localObject2).Lhg = ((Boolean)localObject1).booleanValue();
      this.LIl.LrK.LHS.a(paramh, (t)localObject2, this.LIl.KVP, this.LIl.LHX);
      paramh = (am)localObject2;
      AppMethodBeat.o(60331);
      return paramh;
      i = aiN(paramh.LuS);
      break;
      localObject1 = d.l.b.a.b.b.a.g.LeU;
      localObject1 = d.l.b.a.b.b.a.g.a.fSm();
      break label58;
      localObject2 = this.LIl.LHZ;
      break label104;
    }
  }
  
  static final class a
    extends d.g.b.l
    implements d.g.a.a<List<? extends c>>
  {
    a(w paramw, q paramq, b paramb)
    {
      super();
    }
  }
  
  static final class b
    extends d.g.b.l
    implements d.g.a.a<List<? extends c>>
  {
    b(w paramw, boolean paramBoolean, a.m paramm)
    {
      super();
    }
  }
  
  static final class c
    extends d.g.b.l
    implements d.g.a.a<List<? extends c>>
  {
    c(w paramw, q paramq, b paramb)
    {
      super();
    }
  }
  
  static final class d
    extends d.g.b.l
    implements d.g.a.a<d.l.b.a.b.j.b.g<?>>
  {
    d(w paramw, a.m paramm, d.l.b.a.b.k.a.b.j paramj)
    {
      super();
    }
  }
  
  static final class e
    extends d.g.b.l
    implements d.g.a.a<List<? extends c>>
  {
    e(int paramInt, a.t paramt, w paramw, z paramz, q paramq, b paramb, d.l.b.a.b.b.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.k.a.w
 * JD-Core Version:    0.7.0.1
 */