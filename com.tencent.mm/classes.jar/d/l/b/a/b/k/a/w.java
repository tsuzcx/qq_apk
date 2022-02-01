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
import d.l.b.a.b.e.b.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class w
{
  private final f Niy;
  private final n Nzj;
  
  public w(n paramn)
  {
    AppMethodBeat.i(60340);
    this.Nzj = paramn;
    this.Niy = new f(this.Nzj.NiH.MTr, this.Nzj.NiH.MSe);
    AppMethodBeat.o(60340);
  }
  
  private final z K(d.l.b.a.b.b.l paraml)
  {
    AppMethodBeat.i(60339);
    if ((paraml instanceof d.l.b.a.b.b.ab))
    {
      paraml = (z)new z.b(((d.l.b.a.b.b.ab)paraml).gjg(), this.Nzj.MMU, this.Nzj.MMV, (an)this.Nzj.NyY);
      AppMethodBeat.o(60339);
      return paraml;
    }
    if ((paraml instanceof d.l.b.a.b.k.a.b.e))
    {
      paraml = (z)((d.l.b.a.b.k.a.b.e)paraml).NAd;
      AppMethodBeat.o(60339);
      return paraml;
    }
    AppMethodBeat.o(60339);
    return null;
  }
  
  private final d.l.b.a.b.b.a.g a(final a.m paramm, final boolean paramBoolean)
  {
    AppMethodBeat.i(60336);
    if (!d.l.b.a.b.e.b.b.Nol.akK(paramm.Nkt).booleanValue())
    {
      paramm = d.l.b.a.b.b.a.g.MVP;
      paramm = d.l.b.a.b.b.a.g.a.gjL();
      AppMethodBeat.o(60336);
      return paramm;
    }
    paramm = (d.l.b.a.b.b.a.g)new d.l.b.a.b.k.a.b.n(this.Nzj.NiH.MQa, (d.g.a.a)new b(this, paramBoolean, paramm));
    AppMethodBeat.o(60336);
    return paramm;
  }
  
  private final d.l.b.a.b.b.a.g a(final d.l.b.a.b.h.q paramq, int paramInt, final b paramb)
  {
    AppMethodBeat.i(60335);
    if (!d.l.b.a.b.e.b.b.Nol.akK(paramInt).booleanValue())
    {
      paramq = d.l.b.a.b.b.a.g.MVP;
      paramq = d.l.b.a.b.b.a.g.a.gjL();
      AppMethodBeat.o(60335);
      return paramq;
    }
    paramq = (d.l.b.a.b.b.a.g)new d.l.b.a.b.k.a.b.n(this.Nzj.NiH.MQa, (d.g.a.a)new a(this, paramq, paramb));
    AppMethodBeat.o(60335);
    return paramq;
  }
  
  private final d.l.b.a.b.b.a.g a(final d.l.b.a.b.h.q paramq, final b paramb)
  {
    AppMethodBeat.i(60337);
    paramq = (d.l.b.a.b.b.a.g)new d.l.b.a.b.k.a.b.b(this.Nzj.NiH.MQa, (d.g.a.a)new c(this, paramq, paramb));
    AppMethodBeat.o(60337);
    return paramq;
  }
  
  private final List<av> a(List<a.t> paramList, final d.l.b.a.b.h.q paramq, final b paramb)
  {
    AppMethodBeat.i(60338);
    Object localObject1 = this.Nzj.MXA;
    if (localObject1 == null)
    {
      paramList = new d.v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
      AppMethodBeat.o(60338);
      throw paramList;
    }
    final d.l.b.a.b.b.a locala = (d.l.b.a.b.b.a)localObject1;
    localObject1 = locala.ghs();
    d.g.b.p.g(localObject1, "callableDescriptor.containingDeclaration");
    final z localz = K((d.l.b.a.b.b.l)localObject1);
    paramList = (Iterable)paramList;
    Collection localCollection = (Collection)new ArrayList(d.a.j.a(paramList, 10));
    int i = 0;
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      paramList = localIterator.next();
      if (i < 0) {
        d.a.j.gfB();
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
      if (((a.t)localObject1).gmO())
      {
        j = ((a.t)localObject1).Nkt;
        if (localz == null) {
          break label429;
        }
        paramList = d.l.b.a.b.e.b.b.Nol.akK(j);
        d.g.b.p.g(paramList, "Flags.HAS_ANNOTATIONS.get(flags)");
        if (!paramList.booleanValue()) {
          break label429;
        }
        paramList = (d.l.b.a.b.b.a.g)new d.l.b.a.b.k.a.b.n(this.Nzj.NiH.MQa, (d.g.a.a)new e(i, (a.t)localObject1, this, localz, paramq, paramb, locala));
        localf = x.b(this.Nzj.MMU, ((a.t)localObject1).NlC);
        localab = this.Nzj.NyV.r(d.l.b.a.b.e.b.g.a((a.t)localObject1, this.Nzj.MMV));
        localObject2 = d.l.b.a.b.e.b.b.NoM.akK(j);
        d.g.b.p.g(localObject2, "Flags.DECLARES_DEFAULT_VALUE.get(flags)");
        bool1 = ((Boolean)localObject2).booleanValue();
        localObject2 = d.l.b.a.b.e.b.b.NoN.akK(j);
        d.g.b.p.g(localObject2, "Flags.IS_CROSSINLINE.get(flags)");
        bool2 = ((Boolean)localObject2).booleanValue();
        localObject2 = d.l.b.a.b.e.b.b.NoO.akK(j);
        d.g.b.p.g(localObject2, "Flags.IS_NOINLINE.get(flags)");
        bool3 = ((Boolean)localObject2).booleanValue();
        localObject1 = d.l.b.a.b.e.b.g.b((a.t)localObject1, this.Nzj.MMV);
        if (localObject1 == null) {
          break label440;
        }
      }
      label429:
      label440:
      for (localObject1 = this.Nzj.NyV.r((a.p)localObject1);; localObject1 = null)
      {
        localObject2 = an.MUX;
        d.g.b.p.g(localObject2, "SourceElement.NO_SOURCE");
        localCollection.add(new d.l.b.a.b.b.c.aj(locala, null, i, paramList, localf, localab, bool1, bool2, bool3, (d.l.b.a.b.m.ab)localObject1, (an)localObject2));
        i += 1;
        break;
        j = 0;
        break label148;
        paramList = d.l.b.a.b.b.a.g.MVP;
        paramList = d.l.b.a.b.b.a.g.a.gjL();
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
    paramk.a(paramak1, paramak2, paramList, paramList1, paramab, paramw, paramba, paramMap, d.l.b.a.b.k.a.b.g.a.NAp);
    AppMethodBeat.o(60330);
  }
  
  private static int alo(int paramInt)
  {
    return (paramInt & 0x3F) + (paramInt >> 8 << 6);
  }
  
  private final ak gio()
  {
    AppMethodBeat.i(60333);
    d.l.b.a.b.b.l locall = this.Nzj.MXA;
    Object localObject = locall;
    if (!(locall instanceof d.l.b.a.b.b.e)) {
      localObject = null;
    }
    localObject = (d.l.b.a.b.b.e)localObject;
    if (localObject != null)
    {
      localObject = ((d.l.b.a.b.b.e)localObject).giK();
      AppMethodBeat.o(60333);
      return localObject;
    }
    AppMethodBeat.o(60333);
    return null;
  }
  
  public final d.l.b.a.b.b.d a(a.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(60334);
    d.g.b.p.h(paramc, "proto");
    Object localObject1 = this.Nzj.MXA;
    if (localObject1 == null)
    {
      paramc = new d.v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
      AppMethodBeat.o(60334);
      throw paramc;
    }
    localObject1 = (d.l.b.a.b.b.e)localObject1;
    d.l.b.a.b.k.a.b.d locald = new d.l.b.a.b.k.a.b.d((d.l.b.a.b.b.e)localObject1, a((d.l.b.a.b.h.q)paramc, paramc.Nkt, b.Nyq), paramBoolean, d.l.b.a.b.b.b.a.MUj, paramc, this.Nzj.MMU, this.Nzj.MMV, this.Nzj.NyX, this.Nzj.NyY);
    Object localObject2 = n.a(this.Nzj, (d.l.b.a.b.b.l)locald, (List)d.a.v.MKE).NyW;
    Object localObject3 = paramc.Nll;
    d.g.b.p.g(localObject3, "proto.valueParameterList");
    localObject2 = ((w)localObject2).a((List)localObject3, (d.l.b.a.b.h.q)paramc, b.Nyq);
    localObject3 = aa.Nzz;
    locald.a((List)localObject2, aa.a((a.w)d.l.b.a.b.e.b.b.Nom.get(paramc.Nkt)));
    locald.J((d.l.b.a.b.m.ab)((d.l.b.a.b.b.e)localObject1).giC());
    d.g.b.p.g(locald.gis(), "descriptor.valueParameters");
    d.g.b.p.g(locald.gip(), "descriptor.typeParameters");
    locald.giq();
    locald.a(d.l.b.a.b.k.a.b.g.a.NAp);
    paramc = (d.l.b.a.b.b.d)locald;
    AppMethodBeat.o(60334);
    return paramc;
  }
  
  public final ar f(a.q paramq)
  {
    AppMethodBeat.i(60332);
    d.g.b.p.h(paramq, "proto");
    Object localObject1 = d.l.b.a.b.b.a.g.MVP;
    localObject1 = paramq.Nnc;
    d.g.b.p.g(localObject1, "proto.annotationList");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (d.l.b.a.b.e.a.a)((Iterator)localObject2).next();
      localObject4 = this.Niy;
      d.g.b.p.g(localObject3, "it");
      ((Collection)localObject1).add(((f)localObject4).b((d.l.b.a.b.e.a.a)localObject3, this.Nzj.MMU));
    }
    localObject1 = d.l.b.a.b.b.a.g.a.jl((List)localObject1);
    localObject2 = aa.Nzz;
    localObject2 = aa.a((a.w)d.l.b.a.b.e.b.b.Nom.get(paramq.Nkt));
    localObject2 = new d.l.b.a.b.k.a.b.l(this.Nzj.NiH.MQa, this.Nzj.MXA, (d.l.b.a.b.b.a.g)localObject1, x.b(this.Nzj.MMU, paramq.NlC), (ba)localObject2, paramq, this.Nzj.MMU, this.Nzj.MMV, this.Nzj.NyX, this.Nzj.NyY);
    localObject1 = this.Nzj;
    Object localObject3 = (d.l.b.a.b.b.l)localObject2;
    Object localObject4 = paramq.NkM;
    d.g.b.p.g(localObject4, "proto.typeParameterList");
    localObject4 = n.a((n)localObject1, (d.l.b.a.b.b.l)localObject3, (List)localObject4);
    localObject3 = ((n)localObject4).NyV.gtB();
    Object localObject5 = ((n)localObject4).NyV;
    localObject1 = this.Nzj.MMV;
    d.g.b.p.h(paramq, "$this$underlyingType");
    d.g.b.p.h(localObject1, "typeTable");
    if (paramq.gps())
    {
      localObject1 = paramq.NmY;
      d.g.b.p.g(localObject1, "underlyingType");
      localObject1 = ((ad)localObject5).s((a.p)localObject1);
      localObject4 = ((n)localObject4).NyV;
      localObject5 = this.Nzj.MMV;
      d.g.b.p.h(paramq, "$this$expandedType");
      d.g.b.p.h(localObject5, "typeTable");
      if (!paramq.gpu()) {
        break label438;
      }
      paramq = paramq.Nna;
      d.g.b.p.g(paramq, "expandedType");
    }
    for (;;)
    {
      ((d.l.b.a.b.k.a.b.l)localObject2).a((List)localObject3, (d.l.b.a.b.m.aj)localObject1, ((ad)localObject4).s(paramq), d.l.b.a.b.k.a.b.g.a.NAp);
      paramq = (ar)localObject2;
      AppMethodBeat.o(60332);
      return paramq;
      if (paramq.gpt())
      {
        localObject1 = ((h)localObject1).akO(paramq.NmZ);
        break;
      }
      paramq = (Throwable)new IllegalStateException("No underlyingType in ProtoBuf.TypeAlias".toString());
      AppMethodBeat.o(60332);
      throw paramq;
      label438:
      if (!paramq.gpv()) {
        break label458;
      }
      paramq = ((h)localObject5).akO(paramq.Nnb);
    }
    label458:
    paramq = (Throwable)new IllegalStateException("No expandedType in ProtoBuf.TypeAlias".toString());
    AppMethodBeat.o(60332);
    throw paramq;
  }
  
  public final ah g(final a.m paramm)
  {
    AppMethodBeat.i(60329);
    d.g.b.p.h(paramm, "proto");
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
    if (paramm.gmO())
    {
      i = paramm.Nkt;
      localObject1 = this.Nzj.MXA;
      localObject2 = a((d.l.b.a.b.h.q)paramm, i, b.Nyr);
      localObject3 = aa.Nzz;
      localObject3 = aa.a((a.j)d.l.b.a.b.e.b.b.Non.get(i));
      localObject4 = aa.Nzz;
      localObject4 = aa.a((a.w)d.l.b.a.b.e.b.b.Nom.get(i));
      localObject5 = d.l.b.a.b.e.b.b.NoD.akK(i);
      d.g.b.p.g(localObject5, "Flags.IS_VAR.get(flags)");
      bool1 = ((Boolean)localObject5).booleanValue();
      localObject5 = x.b(this.Nzj.MMU, paramm.NlC);
      Object localObject6 = aa.Nzz;
      localObject6 = aa.a((a.i)d.l.b.a.b.e.b.b.Nov.get(i));
      Object localObject7 = d.l.b.a.b.e.b.b.NoH.akK(i);
      d.g.b.p.g(localObject7, "Flags.IS_LATEINIT.get(flags)");
      boolean bool2 = ((Boolean)localObject7).booleanValue();
      localObject7 = d.l.b.a.b.e.b.b.NoG.akK(i);
      d.g.b.p.g(localObject7, "Flags.IS_CONST.get(flags)");
      boolean bool3 = ((Boolean)localObject7).booleanValue();
      localObject7 = d.l.b.a.b.e.b.b.NoJ.akK(i);
      d.g.b.p.g(localObject7, "Flags.IS_EXTERNAL_PROPERTY.get(flags)");
      boolean bool4 = ((Boolean)localObject7).booleanValue();
      localObject7 = d.l.b.a.b.e.b.b.NoK.akK(i);
      d.g.b.p.g(localObject7, "Flags.IS_DELEGATED.get(flags)");
      boolean bool5 = ((Boolean)localObject7).booleanValue();
      localObject7 = d.l.b.a.b.e.b.b.NoL.akK(i);
      d.g.b.p.g(localObject7, "Flags.IS_EXPECT_PROPERTY.get(flags)");
      localObject3 = new d.l.b.a.b.k.a.b.j((d.l.b.a.b.b.l)localObject1, null, (d.l.b.a.b.b.a.g)localObject2, (d.l.b.a.b.b.w)localObject3, (ba)localObject4, bool1, (d.l.b.a.b.f.f)localObject5, (d.l.b.a.b.b.b.a)localObject6, bool2, bool3, bool4, bool5, ((Boolean)localObject7).booleanValue(), paramm, this.Nzj.MMU, this.Nzj.MMV, this.Nzj.NyX, this.Nzj.NyY);
      localObject1 = this.Nzj;
      localObject2 = (d.l.b.a.b.b.l)localObject3;
      localObject4 = paramm.NkM;
      d.g.b.p.g(localObject4, "proto.typeParameterList");
      localObject4 = n.a((n)localObject1, (d.l.b.a.b.b.l)localObject2, (List)localObject4);
      localObject1 = d.l.b.a.b.e.b.b.NoE.akK(i);
      d.g.b.p.g(localObject1, "Flags.HAS_GETTER.get(flags)");
      bool1 = ((Boolean)localObject1).booleanValue();
      if ((!bool1) || (!d.l.b.a.b.e.b.g.e(paramm))) {
        break label1177;
      }
      localObject1 = a((d.l.b.a.b.h.q)paramm, b.Nys);
      localObject2 = ((n)localObject4).NyV.r(d.l.b.a.b.e.b.g.a(paramm, this.Nzj.MMV));
      localObject5 = ((n)localObject4).NyV.gtB();
      localObject6 = gio();
      localObject7 = d.l.b.a.b.e.b.g.b(paramm, this.Nzj.MMV);
      if (localObject7 == null) {
        break label1190;
      }
      localObject7 = ((n)localObject4).NyV.r((a.p)localObject7);
      if (localObject7 == null) {
        break label1190;
      }
      localObject1 = d.l.b.a.b.j.b.a((d.l.b.a.b.b.a)localObject3, (d.l.b.a.b.m.ab)localObject7, (d.l.b.a.b.b.a.g)localObject1);
      ((d.l.b.a.b.k.a.b.j)localObject3).a((d.l.b.a.b.m.ab)localObject2, (List)localObject5, (ak)localObject6, (ak)localObject1);
      localObject1 = d.l.b.a.b.e.b.b.Nol.akK(i);
      d.g.b.p.g(localObject1, "Flags.HAS_ANNOTATIONS.get(flags)");
      j = d.l.b.a.b.e.b.b.a(((Boolean)localObject1).booleanValue(), (a.w)d.l.b.a.b.e.b.b.Nom.get(i), (a.j)d.l.b.a.b.e.b.b.Non.get(i));
      if (!bool1) {
        break label1231;
      }
      if (!paramm.goy()) {
        break label1196;
      }
      k = paramm.Nmn;
      label576:
      localObject1 = d.l.b.a.b.e.b.b.NoP.akK(k);
      d.g.b.p.g(localObject1, "Flags.IS_NOT_DEFAULT.get(getterFlags)");
      bool1 = ((Boolean)localObject1).booleanValue();
      localObject1 = d.l.b.a.b.e.b.b.NoQ.akK(k);
      d.g.b.p.g(localObject1, "Flags.IS_EXTERNAL_ACCESSOR.get(getterFlags)");
      bool2 = ((Boolean)localObject1).booleanValue();
      localObject1 = d.l.b.a.b.e.b.b.NoR.akK(k);
      d.g.b.p.g(localObject1, "Flags.IS_INLINE_ACCESSOR.get(getterFlags)");
      bool3 = ((Boolean)localObject1).booleanValue();
      localObject1 = a((d.l.b.a.b.h.q)paramm, k, b.Nys);
      if (!bool1) {
        break label1208;
      }
      localObject2 = (ah)localObject3;
      localObject5 = aa.Nzz;
      localObject5 = aa.a((a.j)d.l.b.a.b.e.b.b.Non.get(k));
      localObject6 = aa.Nzz;
      localObject6 = aa.a((a.w)d.l.b.a.b.e.b.b.Nom.get(k));
      if (bool1) {
        break label1202;
      }
      bool1 = true;
      label728:
      localObject1 = new d.l.b.a.b.b.c.ab((ah)localObject2, (d.l.b.a.b.b.a.g)localObject1, (d.l.b.a.b.b.w)localObject5, (ba)localObject6, bool1, bool2, bool3, ((d.l.b.a.b.k.a.b.j)localObject3).giw(), null, an.MUX);
      label760:
      ((d.l.b.a.b.b.c.ab)localObject1).K(((d.l.b.a.b.k.a.b.j)localObject3).giq());
      localObject2 = localObject1;
      label774:
      localObject1 = d.l.b.a.b.e.b.b.NoF.akK(i);
      d.g.b.p.g(localObject1, "Flags.HAS_SETTER.get(flags)");
      if (!((Boolean)localObject1).booleanValue()) {
        break label1278;
      }
      if (paramm.goz()) {
        j = paramm.Nmo;
      }
      localObject1 = d.l.b.a.b.e.b.b.NoP.akK(j);
      d.g.b.p.g(localObject1, "Flags.IS_NOT_DEFAULT.get(setterFlags)");
      bool1 = ((Boolean)localObject1).booleanValue();
      localObject1 = d.l.b.a.b.e.b.b.NoQ.akK(j);
      d.g.b.p.g(localObject1, "Flags.IS_EXTERNAL_ACCESSOR.get(setterFlags)");
      bool2 = ((Boolean)localObject1).booleanValue();
      localObject1 = d.l.b.a.b.e.b.b.NoR.akK(j);
      d.g.b.p.g(localObject1, "Flags.IS_INLINE_ACCESSOR.get(setterFlags)");
      bool3 = ((Boolean)localObject1).booleanValue();
      localObject1 = a((d.l.b.a.b.h.q)paramm, j, b.Nyt);
      if (!bool1) {
        break label1243;
      }
      localObject5 = (ah)localObject3;
      localObject6 = aa.Nzz;
      localObject6 = aa.a((a.j)d.l.b.a.b.e.b.b.Non.get(j));
      localObject7 = aa.Nzz;
      localObject7 = aa.a((a.w)d.l.b.a.b.e.b.b.Nom.get(j));
      if (bool1) {
        break label1237;
      }
      bool1 = true;
      label957:
      localObject1 = new d.l.b.a.b.b.c.ac((ah)localObject5, (d.l.b.a.b.b.a.g)localObject1, (d.l.b.a.b.b.w)localObject6, (ba)localObject7, bool1, bool2, bool3, ((d.l.b.a.b.k.a.b.j)localObject3).giw(), null, an.MUX);
      ((d.l.b.a.b.b.c.ac)localObject1).a((av)d.a.j.jg(n.a((n)localObject4, (d.l.b.a.b.b.l)localObject1, (List)d.a.v.MKE).NyW.a(d.a.j.listOf(paramm.Nmm), (d.l.b.a.b.h.q)paramm, b.Nyt)));
    }
    for (;;)
    {
      localObject4 = d.l.b.a.b.e.b.b.NoI.akK(i);
      d.g.b.p.g(localObject4, "Flags.HAS_CONSTANT.get(flags)");
      if (((Boolean)localObject4).booleanValue()) {
        ((d.l.b.a.b.k.a.b.j)localObject3).a(this.Nzj.NiH.MQa.T((d.g.a.a)new d(this, paramm, (d.l.b.a.b.k.a.b.j)localObject3)));
      }
      ((d.l.b.a.b.k.a.b.j)localObject3).a((d.l.b.a.b.b.c.ab)localObject2, (d.l.b.a.b.b.aj)localObject1, (r)new o(a(paramm, false), (ah)localObject3), (r)new o(a(paramm, true), (ah)localObject3), d.l.b.a.b.k.a.b.g.a.NAp);
      paramm = (ah)localObject3;
      AppMethodBeat.o(60329);
      return paramm;
      i = alo(paramm.NlP);
      break;
      label1177:
      localObject1 = d.l.b.a.b.b.a.g.MVP;
      localObject1 = d.l.b.a.b.b.a.g.a.gjL();
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
      d.g.b.p.g(localObject1, "DescriptorFactory.create…er(property, annotations)");
      break label760;
      label1231:
      localObject2 = null;
      break label774;
      label1237:
      bool1 = false;
      break label957;
      label1243:
      localObject4 = (ah)localObject3;
      localObject5 = d.l.b.a.b.b.a.g.MVP;
      localObject1 = d.l.b.a.b.j.b.a((ah)localObject4, (d.l.b.a.b.b.a.g)localObject1, d.l.b.a.b.b.a.g.a.gjL());
      d.g.b.p.g(localObject1, "DescriptorFactory.create…ptor */\n                )");
      continue;
      label1278:
      localObject1 = null;
    }
  }
  
  public final am g(a.h paramh)
  {
    AppMethodBeat.i(60331);
    d.g.b.p.h(paramh, "proto");
    int i;
    Object localObject3;
    label58:
    Object localObject2;
    label104:
    Object localObject4;
    Object localObject5;
    Object localObject6;
    if (paramh.gmO())
    {
      i = paramh.Nkt;
      localObject3 = a((d.l.b.a.b.h.q)paramh, i, b.Nyq);
      if (!d.l.b.a.b.e.b.g.f(paramh)) {
        break label662;
      }
      localObject1 = a((d.l.b.a.b.h.q)paramh, b.Nyq);
      if (!d.g.b.p.i(d.l.b.a.b.j.d.a.o(this.Nzj.MXA).p(x.b(this.Nzj.MMU, paramh.NlC)), ac.NzE)) {
        break label673;
      }
      localObject2 = i.Npa;
      localObject2 = i.gqm();
      localObject4 = this.Nzj.MXA;
      localObject5 = x.b(this.Nzj.MMU, paramh.NlC);
      localObject6 = aa.Nzz;
      localObject2 = new d.l.b.a.b.k.a.b.k((d.l.b.a.b.b.l)localObject4, (d.l.b.a.b.b.a.g)localObject3, (d.l.b.a.b.f.f)localObject5, aa.a((a.i)d.l.b.a.b.e.b.b.Nov.get(i)), paramh, this.Nzj.MMU, this.Nzj.MMV, (i)localObject2, this.Nzj.NyY);
      localObject3 = this.Nzj;
      localObject4 = (d.l.b.a.b.b.l)localObject2;
      localObject5 = paramh.NkM;
      d.g.b.p.g(localObject5, "proto.typeParameterList");
      localObject5 = n.a((n)localObject3, (d.l.b.a.b.b.l)localObject4, (List)localObject5);
      localObject3 = d.l.b.a.b.e.b.g.b(paramh, this.Nzj.MMV);
      if (localObject3 == null) {
        break label685;
      }
      localObject3 = ((n)localObject5).NyV.r((a.p)localObject3);
      if (localObject3 == null) {
        break label685;
      }
    }
    label662:
    label673:
    label685:
    for (Object localObject1 = d.l.b.a.b.j.b.a((d.l.b.a.b.b.a)localObject2, (d.l.b.a.b.m.ab)localObject3, (d.l.b.a.b.b.a.g)localObject1);; localObject1 = null)
    {
      localObject3 = gio();
      localObject4 = ((n)localObject5).NyV.gtB();
      localObject6 = ((n)localObject5).NyW;
      Object localObject7 = paramh.Nll;
      d.g.b.p.g(localObject7, "proto.valueParameterList");
      localObject6 = ((w)localObject6).a((List)localObject7, (d.l.b.a.b.h.q)paramh, b.Nyq);
      localObject5 = ((n)localObject5).NyV.r(d.l.b.a.b.e.b.g.a(paramh, this.Nzj.MMV));
      localObject7 = aa.Nzz;
      localObject7 = aa.a((a.j)d.l.b.a.b.e.b.b.Non.get(i));
      Object localObject8 = aa.Nzz;
      localObject8 = aa.a((a.w)d.l.b.a.b.e.b.b.Nom.get(i));
      Map localMap = ae.emptyMap();
      Boolean localBoolean = d.l.b.a.b.e.b.b.NoB.akK(i);
      d.g.b.p.g(localBoolean, "Flags.IS_SUSPEND.get(flags)");
      localBoolean.booleanValue();
      a((d.l.b.a.b.k.a.b.k)localObject2, (ak)localObject1, (ak)localObject3, (List)localObject4, (List)localObject6, (d.l.b.a.b.m.ab)localObject5, (d.l.b.a.b.b.w)localObject7, (ba)localObject8, localMap);
      localObject1 = d.l.b.a.b.e.b.b.Now.akK(i);
      d.g.b.p.g(localObject1, "Flags.IS_OPERATOR.get(flags)");
      ((d.l.b.a.b.b.c.p)localObject2).MXY = ((Boolean)localObject1).booleanValue();
      localObject1 = d.l.b.a.b.e.b.b.Nox.akK(i);
      d.g.b.p.g(localObject1, "Flags.IS_INFIX.get(flags)");
      ((d.l.b.a.b.b.c.p)localObject2).MXZ = ((Boolean)localObject1).booleanValue();
      localObject1 = d.l.b.a.b.e.b.b.NoA.akK(i);
      d.g.b.p.g(localObject1, "Flags.IS_EXTERNAL_FUNCTION.get(flags)");
      ((d.l.b.a.b.b.c.p)localObject2).MXB = ((Boolean)localObject1).booleanValue();
      localObject1 = d.l.b.a.b.e.b.b.Noy.akK(i);
      d.g.b.p.g(localObject1, "Flags.IS_INLINE.get(flags)");
      ((d.l.b.a.b.b.c.p)localObject2).MYa = ((Boolean)localObject1).booleanValue();
      localObject1 = d.l.b.a.b.e.b.b.Noz.akK(i);
      d.g.b.p.g(localObject1, "Flags.IS_TAILREC.get(flags)");
      ((d.l.b.a.b.b.c.p)localObject2).MYb = ((Boolean)localObject1).booleanValue();
      localObject1 = d.l.b.a.b.e.b.b.NoB.akK(i);
      d.g.b.p.g(localObject1, "Flags.IS_SUSPEND.get(flags)");
      ((d.l.b.a.b.b.c.p)localObject2).MYg = ((Boolean)localObject1).booleanValue();
      localObject1 = d.l.b.a.b.e.b.b.NoC.akK(i);
      d.g.b.p.g(localObject1, "Flags.IS_EXPECT_FUNCTION.get(flags)");
      ((d.l.b.a.b.b.c.p)localObject2).MYc = ((Boolean)localObject1).booleanValue();
      this.Nzj.NiH.NyQ.a(paramh, (t)localObject2, this.Nzj.MMV, this.Nzj.NyV);
      paramh = (am)localObject2;
      AppMethodBeat.o(60331);
      return paramh;
      i = alo(paramh.NlP);
      break;
      localObject1 = d.l.b.a.b.b.a.g.MVP;
      localObject1 = d.l.b.a.b.b.a.g.a.gjL();
      break label58;
      localObject2 = this.Nzj.NyX;
      break label104;
    }
  }
  
  static final class a
    extends d.g.b.q
    implements d.g.a.a<List<? extends c>>
  {
    a(w paramw, d.l.b.a.b.h.q paramq, b paramb)
    {
      super();
    }
  }
  
  static final class b
    extends d.g.b.q
    implements d.g.a.a<List<? extends c>>
  {
    b(w paramw, boolean paramBoolean, a.m paramm)
    {
      super();
    }
  }
  
  static final class c
    extends d.g.b.q
    implements d.g.a.a<List<? extends c>>
  {
    c(w paramw, d.l.b.a.b.h.q paramq, b paramb)
    {
      super();
    }
  }
  
  static final class d
    extends d.g.b.q
    implements d.g.a.a<d.l.b.a.b.j.b.g<?>>
  {
    d(w paramw, a.m paramm, d.l.b.a.b.k.a.b.j paramj)
    {
      super();
    }
  }
  
  static final class e
    extends d.g.b.q
    implements d.g.a.a<List<? extends c>>
  {
    e(int paramInt, a.t paramt, w paramw, z paramz, d.l.b.a.b.h.q paramq, b paramb, d.l.b.a.b.b.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.k.a.w
 * JD-Core Version:    0.7.0.1
 */