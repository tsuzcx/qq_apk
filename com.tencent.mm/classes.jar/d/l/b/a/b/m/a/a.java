package d.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.a.h;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.at;
import d.l.b.a.b.m.ba;
import d.l.b.a.b.m.bg;
import d.l.b.a.b.m.bh;
import d.l.b.a.b.m.c.d;
import d.l.b.a.b.m.c.e;
import d.l.b.a.b.m.c.f;
import d.l.b.a.b.m.c.l;
import d.l.b.a.b.m.c.m;
import d.l.b.a.b.m.c.p.a;
import d.l.b.a.b.m.c.q;
import d.l.b.a.b.m.c.s;
import d.l.b.a.b.m.g.c.a;
import d.v;
import java.util.Collection;
import java.util.List;

public final class a
  extends d.l.b.a.b.m.g
  implements c
{
  public static final a JYL;
  private final i JRx;
  private final boolean JYJ;
  private final boolean JYK;
  
  static
  {
    AppMethodBeat.i(60923);
    JYL = new a((byte)0);
    AppMethodBeat.o(60923);
  }
  
  private a(boolean paramBoolean1, boolean paramBoolean2, i parami)
  {
    AppMethodBeat.i(60921);
    this.JYJ = paramBoolean1;
    this.JYK = paramBoolean2;
    this.JRx = parami;
    AppMethodBeat.o(60921);
  }
  
  public final int a(d.l.b.a.b.m.c.k paramk)
  {
    AppMethodBeat.i(60984);
    d.g.b.k.h(paramk, "$this$size");
    int i = c.a.a(this, paramk);
    AppMethodBeat.o(60984);
    return i;
  }
  
  public final e a(f paramf)
  {
    AppMethodBeat.i(60935);
    d.g.b.k.h(paramf, "$this$asDynamicType");
    paramf = c.a.d(paramf);
    AppMethodBeat.o(60935);
    return paramf;
  }
  
  public final d.l.b.a.b.m.c.g a(d.l.b.a.b.m.c.c paramc)
  {
    AppMethodBeat.i(60930);
    d.g.b.k.h(paramc, "$this$lowerType");
    paramc = c.a.b(paramc);
    AppMethodBeat.o(60930);
    return paramc;
  }
  
  public final d.l.b.a.b.m.c.g a(d.l.b.a.b.m.c.g paramg)
  {
    AppMethodBeat.i(60916);
    d.g.b.k.h(paramg, "type");
    if (!(paramg instanceof ab))
    {
      paramg = (Throwable)new IllegalArgumentException(b.fs(paramg).toString());
      AppMethodBeat.o(60916);
      throw paramg;
    }
    n.a locala = n.JZb;
    n.a.fKf();
    paramg = (d.l.b.a.b.m.c.g)o.c(((ab)paramg).fJW());
    AppMethodBeat.o(60916);
    return paramg;
  }
  
  public final d.l.b.a.b.m.c.g a(d.l.b.a.b.m.c.n paramn)
  {
    AppMethodBeat.i(60968);
    d.g.b.k.h(paramn, "$this$getRepresentativeUpperBound");
    paramn = c.a.d(paramn);
    AppMethodBeat.o(60968);
    return paramn;
  }
  
  public final d.l.b.a.b.m.c.i a(d.l.b.a.b.m.c.i parami, d.l.b.a.b.m.c.b paramb)
  {
    AppMethodBeat.i(60957);
    d.g.b.k.h(parami, "type");
    d.g.b.k.h(paramb, "status");
    parami = c.a.b(parami, paramb);
    AppMethodBeat.o(60957);
    return parami;
  }
  
  public final d.l.b.a.b.m.c.i a(d.l.b.a.b.m.c.i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(60927);
    d.g.b.k.h(parami, "$this$withNullability");
    parami = c.a.b(parami, paramBoolean);
    AppMethodBeat.o(60927);
    return parami;
  }
  
  public final l a(d.l.b.a.b.m.c.g paramg, int paramInt)
  {
    AppMethodBeat.i(60945);
    d.g.b.k.h(paramg, "$this$getArgument");
    paramg = c.a.b(paramg, paramInt);
    AppMethodBeat.o(60945);
    return paramg;
  }
  
  public final l a(d.l.b.a.b.m.c.i parami, int paramInt)
  {
    AppMethodBeat.i(60976);
    d.g.b.k.h(parami, "$this$getArgumentOrNull");
    d.g.b.k.h(parami, "$this$getArgumentOrNull");
    q localq = (q)this;
    d.g.b.k.h(parami, "$this$getArgumentOrNull");
    parami = p.a.a((d.l.b.a.b.m.c.p)localq, parami, paramInt);
    AppMethodBeat.o(60976);
    return parami;
  }
  
  public final l a(d.l.b.a.b.m.c.k paramk, int paramInt)
  {
    AppMethodBeat.i(60975);
    d.g.b.k.h(paramk, "$this$get");
    paramk = c.a.a(this, paramk, paramInt);
    AppMethodBeat.o(60975);
    return paramk;
  }
  
  public final d.l.b.a.b.m.c.n a(m paramm)
  {
    AppMethodBeat.i(60966);
    d.g.b.k.h(paramm, "$this$getTypeParameterClassifier");
    paramm = c.a.y(paramm);
    AppMethodBeat.o(60966);
    return paramm;
  }
  
  public final d.l.b.a.b.m.c.n a(m paramm, int paramInt)
  {
    AppMethodBeat.i(60951);
    d.g.b.k.h(paramm, "$this$getParameter");
    paramm = c.a.b(paramm, paramInt);
    AppMethodBeat.o(60951);
    return paramm;
  }
  
  public final List<d.l.b.a.b.m.c.i> a(d.l.b.a.b.m.c.i parami, m paramm)
  {
    AppMethodBeat.i(60974);
    d.g.b.k.h(parami, "$this$fastCorrespondingSupertypes");
    d.g.b.k.h(paramm, "constructor");
    d.g.b.k.h(parami, "$this$fastCorrespondingSupertypes");
    d.g.b.k.h(paramm, "constructor");
    d.g.b.k.h(parami, "$this$fastCorrespondingSupertypes");
    d.g.b.k.h(paramm, "constructor");
    parami = p.a.b(parami, paramm);
    AppMethodBeat.o(60974);
    return parami;
  }
  
  public final boolean a(d.l.b.a.b.m.c.g paramg, d.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(60965);
    d.g.b.k.h(paramg, "$this$hasAnnotation");
    d.g.b.k.h(paramb, "fqName");
    boolean bool = c.a.b(paramg, paramb);
    AppMethodBeat.o(60965);
    return bool;
  }
  
  public final boolean a(l paraml)
  {
    AppMethodBeat.i(60946);
    d.g.b.k.h(paraml, "$this$isStarProjection");
    boolean bool = c.a.d(paraml);
    AppMethodBeat.o(60946);
    return bool;
  }
  
  public final boolean a(m paramm1, m paramm2)
  {
    AppMethodBeat.i(60918);
    d.g.b.k.h(paramm1, "a");
    d.g.b.k.h(paramm2, "b");
    if (!(paramm1 instanceof at))
    {
      paramm1 = (Throwable)new IllegalArgumentException(b.fs(paramm1).toString());
      AppMethodBeat.o(60918);
      throw paramm1;
    }
    if (!(paramm2 instanceof at))
    {
      paramm1 = (Throwable)new IllegalArgumentException(b.fs(paramm2).toString());
      AppMethodBeat.o(60918);
      throw paramm1;
    }
    paramm1 = (at)paramm1;
    paramm2 = (at)paramm2;
    d.g.b.k.h(paramm1, "a");
    d.g.b.k.h(paramm2, "b");
    if ((paramm1 instanceof d.l.b.a.b.j.b.n))
    {
      bool = ((d.l.b.a.b.j.b.n)paramm1).c(paramm2);
      AppMethodBeat.o(60918);
      return bool;
    }
    if ((paramm2 instanceof d.l.b.a.b.j.b.n))
    {
      bool = ((d.l.b.a.b.j.b.n)paramm2).c(paramm1);
      AppMethodBeat.o(60918);
      return bool;
    }
    boolean bool = d.g.b.k.g(paramm1, paramm2);
    AppMethodBeat.o(60918);
    return bool;
  }
  
  public final d.l.b.a.b.m.c.g b(d.l.b.a.b.m.c.g paramg)
  {
    AppMethodBeat.i(60917);
    d.g.b.k.h(paramg, "type");
    if (!(paramg instanceof ab))
    {
      paramg = (Throwable)new IllegalArgumentException(b.fs(paramg).toString());
      AppMethodBeat.o(60917);
      throw paramg;
    }
    paramg = (d.l.b.a.b.m.c.g)this.JRx.aL((ab)paramg);
    AppMethodBeat.o(60917);
    return paramg;
  }
  
  public final d.l.b.a.b.m.c.i b(f paramf)
  {
    AppMethodBeat.i(60936);
    d.g.b.k.h(paramf, "$this$upperBound");
    paramf = c.a.e(paramf);
    AppMethodBeat.o(60936);
    return paramf;
  }
  
  public final s b(l paraml)
  {
    AppMethodBeat.i(60947);
    d.g.b.k.h(paraml, "$this$getVariance");
    paraml = c.a.e(paraml);
    AppMethodBeat.o(60947);
    return paraml;
  }
  
  public final s b(d.l.b.a.b.m.c.n paramn)
  {
    AppMethodBeat.i(60948);
    d.g.b.k.h(paramn, "$this$getVariance");
    paramn = c.a.c(paramn);
    AppMethodBeat.o(60948);
    return paramn;
  }
  
  public final boolean b(d.l.b.a.b.m.c.i parami)
  {
    AppMethodBeat.i(60978);
    d.g.b.k.h(parami, "$this$isClassType");
    d.g.b.k.h(parami, "$this$isClassType");
    q localq = (q)this;
    d.g.b.k.h(parami, "$this$isClassType");
    boolean bool = p.a.a((d.l.b.a.b.m.c.p)localq, parami);
    AppMethodBeat.o(60978);
    return bool;
  }
  
  public final boolean b(d.l.b.a.b.m.c.i parami1, d.l.b.a.b.m.c.i parami2)
  {
    AppMethodBeat.i(60932);
    d.g.b.k.h(parami1, "a");
    d.g.b.k.h(parami2, "b");
    boolean bool = c.a.c(parami1, parami2);
    AppMethodBeat.o(60932);
    return bool;
  }
  
  public final boolean b(m paramm)
  {
    AppMethodBeat.i(60967);
    d.g.b.k.h(paramm, "$this$isInlineClass");
    boolean bool = c.a.z(paramm);
    AppMethodBeat.o(60967);
    return bool;
  }
  
  public final boolean b(m paramm1, m paramm2)
  {
    AppMethodBeat.i(60953);
    d.g.b.k.h(paramm1, "c1");
    d.g.b.k.h(paramm2, "c2");
    boolean bool = c.a.c(paramm1, paramm2);
    AppMethodBeat.o(60953);
    return bool;
  }
  
  public final h c(m paramm)
  {
    AppMethodBeat.i(60970);
    d.g.b.k.h(paramm, "$this$getPrimitiveType");
    paramm = c.a.A(paramm);
    AppMethodBeat.o(60970);
    return paramm;
  }
  
  public final d.l.b.a.b.m.c.g c(l paraml)
  {
    AppMethodBeat.i(60949);
    d.g.b.k.h(paraml, "$this$getType");
    paraml = c.a.f(paraml);
    AppMethodBeat.o(60949);
    return paraml;
  }
  
  public final d.l.b.a.b.m.c.i c(f paramf)
  {
    AppMethodBeat.i(60937);
    d.g.b.k.h(paramf, "$this$lowerBound");
    paramf = c.a.f(paramf);
    AppMethodBeat.o(60937);
    return paramf;
  }
  
  public final boolean c(d.l.b.a.b.m.c.g paramg)
  {
    AppMethodBeat.i(60920);
    d.g.b.k.h(paramg, "$this$isAllowedTypeVariable");
    if (((paramg instanceof bg)) && (this.JYK) && ((((bg)paramg).fIW() instanceof p)))
    {
      AppMethodBeat.o(60920);
      return true;
    }
    AppMethodBeat.o(60920);
    return false;
  }
  
  public final boolean c(d.l.b.a.b.m.c.i parami)
  {
    AppMethodBeat.i(60981);
    d.g.b.k.h(parami, "$this$isIntegerLiteralType");
    d.g.b.k.h(parami, "$this$isIntegerLiteralType");
    q localq = (q)this;
    d.g.b.k.h(parami, "$this$isIntegerLiteralType");
    boolean bool = p.a.b((d.l.b.a.b.m.c.p)localq, parami);
    AppMethodBeat.o(60981);
    return bool;
  }
  
  public final h d(m paramm)
  {
    AppMethodBeat.i(60971);
    d.g.b.k.h(paramm, "$this$getPrimitiveArrayType");
    paramm = c.a.B(paramm);
    AppMethodBeat.o(60971);
    return paramm;
  }
  
  public final m d(d.l.b.a.b.m.c.g paramg)
  {
    AppMethodBeat.i(60943);
    d.g.b.k.h(paramg, "$this$typeConstructor");
    paramg = c.a.b(this, paramg);
    AppMethodBeat.o(60943);
    return paramg;
  }
  
  public final Collection<d.l.b.a.b.m.c.g> d(d.l.b.a.b.m.c.i parami)
  {
    AppMethodBeat.i(60926);
    d.g.b.k.h(parami, "$this$possibleIntegerTypes");
    parami = c.a.a(this, parami);
    AppMethodBeat.o(60926);
    return parami;
  }
  
  public final d.l.b.a.b.m.c.i e(d.l.b.a.b.m.c.g paramg)
  {
    AppMethodBeat.i(60983);
    d.g.b.k.h(paramg, "$this$lowerBoundIfFlexible");
    paramg = c.a.c(this, paramg);
    AppMethodBeat.o(60983);
    return paramg;
  }
  
  public final boolean e(d.l.b.a.b.m.c.i parami)
  {
    AppMethodBeat.i(60929);
    d.g.b.k.h(parami, "$this$isStubType");
    boolean bool = c.a.m(parami);
    AppMethodBeat.o(60929);
    return bool;
  }
  
  public final boolean e(m paramm)
  {
    AppMethodBeat.i(60972);
    d.g.b.k.h(paramm, "$this$isUnderKotlinPackage");
    boolean bool = c.a.C(paramm);
    AppMethodBeat.o(60972);
    return bool;
  }
  
  public final d.l.b.a.b.f.c f(m paramm)
  {
    AppMethodBeat.i(60973);
    d.g.b.k.h(paramm, "$this$getClassFqNameUnsafe");
    paramm = c.a.D(paramm);
    AppMethodBeat.o(60973);
    return paramm;
  }
  
  public final d.l.b.a.b.m.c.c f(d.l.b.a.b.m.c.i parami)
  {
    AppMethodBeat.i(60938);
    d.g.b.k.h(parami, "$this$asCapturedType");
    parami = c.a.n(parami);
    AppMethodBeat.o(60938);
    return parami;
  }
  
  public final d.l.b.a.b.m.c.i f(d.l.b.a.b.m.c.g paramg)
  {
    AppMethodBeat.i(60985);
    d.g.b.k.h(paramg, "$this$upperBoundIfFlexible");
    paramg = c.a.d(this, paramg);
    AppMethodBeat.o(60985);
    return paramg;
  }
  
  public final boolean fJO()
  {
    return this.JYJ;
  }
  
  public final d g(d.l.b.a.b.m.c.i parami)
  {
    AppMethodBeat.i(60939);
    d.g.b.k.h(parami, "$this$asDefinitelyNotNullType");
    parami = c.a.o(parami);
    AppMethodBeat.o(60939);
    return parami;
  }
  
  public final boolean g(d.l.b.a.b.m.c.g paramg)
  {
    AppMethodBeat.i(60980);
    d.g.b.k.h(paramg, "$this$isDynamic");
    d.g.b.k.h(paramg, "$this$isDynamic");
    q localq = (q)this;
    d.g.b.k.h(paramg, "$this$isDynamic");
    boolean bool = p.a.c((d.l.b.a.b.m.c.p)localq, paramg);
    AppMethodBeat.o(60980);
    return bool;
  }
  
  public final boolean g(m paramm)
  {
    AppMethodBeat.i(60924);
    d.g.b.k.h(paramm, "$this$isDenotable");
    boolean bool = c.a.p(paramm);
    AppMethodBeat.o(60924);
    return bool;
  }
  
  public final boolean h(d.l.b.a.b.m.c.g paramg)
  {
    AppMethodBeat.i(60979);
    d.g.b.k.h(paramg, "$this$isDefinitelyNotNullType");
    d.g.b.k.h(paramg, "$this$isDefinitelyNotNullType");
    q localq = (q)this;
    d.g.b.k.h(paramg, "$this$isDefinitelyNotNullType");
    boolean bool = p.a.d((d.l.b.a.b.m.c.p)localq, paramg);
    AppMethodBeat.o(60979);
    return bool;
  }
  
  public final boolean h(d.l.b.a.b.m.c.i parami)
  {
    AppMethodBeat.i(60940);
    d.g.b.k.h(parami, "$this$isMarkedNullable");
    boolean bool = c.a.p(parami);
    AppMethodBeat.o(60940);
    return bool;
  }
  
  public final boolean h(m paramm)
  {
    AppMethodBeat.i(60925);
    d.g.b.k.h(paramm, "$this$isIntegerLiteralTypeConstructor");
    boolean bool = c.a.q(paramm);
    AppMethodBeat.o(60925);
    return bool;
  }
  
  public final m i(d.l.b.a.b.m.c.i parami)
  {
    AppMethodBeat.i(60942);
    d.g.b.k.h(parami, "$this$typeConstructor");
    parami = c.a.q(parami);
    AppMethodBeat.o(60942);
    return parami;
  }
  
  public final boolean i(d.l.b.a.b.m.c.g paramg)
  {
    AppMethodBeat.i(60977);
    d.g.b.k.h(paramg, "$this$hasFlexibleNullability");
    d.g.b.k.h(paramg, "$this$hasFlexibleNullability");
    q localq = (q)this;
    d.g.b.k.h(paramg, "$this$hasFlexibleNullability");
    boolean bool = p.a.e((d.l.b.a.b.m.c.p)localq, paramg);
    AppMethodBeat.o(60977);
    return bool;
  }
  
  public final boolean i(m paramm)
  {
    AppMethodBeat.i(60931);
    d.g.b.k.h(paramm, "$this$isIntersection");
    boolean bool = c.a.r(paramm);
    AppMethodBeat.o(60931);
    return bool;
  }
  
  public final d.l.b.a.b.m.c.g iQ(List<? extends d.l.b.a.b.m.c.g> paramList)
  {
    AppMethodBeat.i(60962);
    d.g.b.k.h(paramList, "types");
    paramList = c.a.iR(paramList);
    AppMethodBeat.o(60962);
    return paramList;
  }
  
  public final int j(m paramm)
  {
    AppMethodBeat.i(60950);
    d.g.b.k.h(paramm, "$this$parametersCount");
    int i = c.a.s(paramm);
    AppMethodBeat.o(60950);
    return i;
  }
  
  public final d.l.b.a.b.m.c.k j(d.l.b.a.b.m.c.i parami)
  {
    AppMethodBeat.i(60956);
    d.g.b.k.h(parami, "$this$asArgumentList");
    parami = c.a.r(parami);
    AppMethodBeat.o(60956);
    return parami;
  }
  
  public final boolean j(d.l.b.a.b.m.c.g paramg)
  {
    AppMethodBeat.i(60982);
    d.g.b.k.h(paramg, "$this$isNothing");
    d.g.b.k.h(paramg, "$this$isNothing");
    q localq = (q)this;
    d.g.b.k.h(paramg, "$this$isNothing");
    boolean bool = p.a.g((d.l.b.a.b.m.c.p)localq, paramg);
    AppMethodBeat.o(60982);
    return bool;
  }
  
  public final d.l.b.a.b.m.c.g k(d.l.b.a.b.m.c.g paramg)
  {
    AppMethodBeat.i(60969);
    d.g.b.k.h(paramg, "$this$getSubstitutedUnderlyingType");
    paramg = c.a.z(paramg);
    AppMethodBeat.o(60969);
    return paramg;
  }
  
  public final Collection<d.l.b.a.b.m.c.g> k(m paramm)
  {
    AppMethodBeat.i(60952);
    d.g.b.k.h(paramm, "$this$supertypes");
    paramm = c.a.t(paramm);
    AppMethodBeat.o(60952);
    return paramm;
  }
  
  public final boolean k(d.l.b.a.b.m.c.i parami)
  {
    AppMethodBeat.i(60961);
    d.g.b.k.h(parami, "$this$isSingleClassifierType");
    boolean bool = c.a.s(parami);
    AppMethodBeat.o(60961);
    return bool;
  }
  
  public final boolean l(d.l.b.a.b.m.c.g paramg)
  {
    AppMethodBeat.i(60941);
    d.g.b.k.h(paramg, "$this$isMarkedNullable");
    boolean bool = c.a.a(this, paramg);
    AppMethodBeat.o(60941);
    return bool;
  }
  
  public final boolean l(d.l.b.a.b.m.c.i parami)
  {
    AppMethodBeat.i(60964);
    d.g.b.k.h(parami, "$this$isPrimitiveType");
    boolean bool = c.a.t(parami);
    AppMethodBeat.o(60964);
    return bool;
  }
  
  public final boolean l(m paramm)
  {
    AppMethodBeat.i(60954);
    d.g.b.k.h(paramm, "$this$isClassTypeConstructor");
    boolean bool = c.a.u(paramm);
    AppMethodBeat.o(60954);
    return bool;
  }
  
  public final d.l.b.a.b.m.c.g m(d.l.b.a.b.m.c.g paramg)
  {
    AppMethodBeat.i(60986);
    d.g.b.k.h(paramg, "$this$makeNullable");
    paramg = c.a.e(this, paramg);
    AppMethodBeat.o(60986);
    return paramg;
  }
  
  public final boolean m(m paramm)
  {
    AppMethodBeat.i(60955);
    d.g.b.k.h(paramm, "$this$isCommonFinalClassConstructor");
    boolean bool = c.a.v(paramm);
    AppMethodBeat.o(60955);
    return bool;
  }
  
  public final boolean n(d.l.b.a.b.m.c.g paramg)
  {
    AppMethodBeat.i(60928);
    d.g.b.k.h(paramg, "$this$isError");
    boolean bool = c.a.t(paramg);
    AppMethodBeat.o(60928);
    return bool;
  }
  
  public final boolean n(m paramm)
  {
    AppMethodBeat.i(60958);
    d.g.b.k.h(paramm, "$this$isAnyConstructor");
    boolean bool = c.a.w(paramm);
    AppMethodBeat.o(60958);
    return bool;
  }
  
  public final d.l.b.a.b.m.c.i o(d.l.b.a.b.m.c.g paramg)
  {
    AppMethodBeat.i(60933);
    d.g.b.k.h(paramg, "$this$asSimpleType");
    paramg = c.a.u(paramg);
    AppMethodBeat.o(60933);
    return paramg;
  }
  
  public final boolean o(m paramm)
  {
    AppMethodBeat.i(60959);
    d.g.b.k.h(paramm, "$this$isNothingConstructor");
    boolean bool = c.a.x(paramm);
    AppMethodBeat.o(60959);
    return bool;
  }
  
  public final f p(d.l.b.a.b.m.c.g paramg)
  {
    AppMethodBeat.i(60934);
    d.g.b.k.h(paramg, "$this$asFlexibleType");
    paramg = c.a.v(paramg);
    AppMethodBeat.o(60934);
    return paramg;
  }
  
  public final int q(d.l.b.a.b.m.c.g paramg)
  {
    AppMethodBeat.i(60944);
    d.g.b.k.h(paramg, "$this$argumentsCount");
    int i = c.a.w(paramg);
    AppMethodBeat.o(60944);
    return i;
  }
  
  public final l r(d.l.b.a.b.m.c.g paramg)
  {
    AppMethodBeat.i(60960);
    d.g.b.k.h(paramg, "$this$asTypeArgument");
    paramg = c.a.x(paramg);
    AppMethodBeat.o(60960);
    return paramg;
  }
  
  public final boolean s(d.l.b.a.b.m.c.g paramg)
  {
    AppMethodBeat.i(60963);
    d.g.b.k.h(paramg, "$this$isNullableType");
    boolean bool = c.a.y(paramg);
    AppMethodBeat.o(60963);
    return bool;
  }
  
  public static final class a
  {
    public static final class a
      extends g.c.a
    {
      a(c paramc, ba paramba) {}
      
      public final d.l.b.a.b.m.c.i b(d.l.b.a.b.m.g paramg, d.l.b.a.b.m.c.g paramg1)
      {
        AppMethodBeat.i(60915);
        d.g.b.k.h(paramg, "context");
        d.g.b.k.h(paramg1, "type");
        paramg = this.JYM;
        ba localba = this.JpR;
        paramg1 = this.JYM.e(paramg1);
        if (paramg1 == null)
        {
          paramg = new v("null cannot be cast to non-null type org.jetbrains.kotlin.types.KotlinType");
          AppMethodBeat.o(60915);
          throw paramg;
        }
        paramg1 = localba.b((ab)paramg1, bh.JYC);
        d.g.b.k.g(paramg1, "substitutor.safeSubstitu…ANT\n                    )");
        paramg = paramg.o((d.l.b.a.b.m.c.g)paramg1);
        if (paramg == null) {
          d.g.b.k.fvU();
        }
        AppMethodBeat.o(60915);
        return paramg;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.a.a
 * JD-Core Version:    0.7.0.1
 */