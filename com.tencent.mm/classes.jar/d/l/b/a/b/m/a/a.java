package d.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.at;
import d.l.b.a.b.m.ba;
import d.l.b.a.b.m.bg;
import d.l.b.a.b.m.bh;
import d.l.b.a.b.m.c.d;
import d.l.b.a.b.m.c.e;
import d.l.b.a.b.m.c.f;
import d.l.b.a.b.m.c.j;
import d.l.b.a.b.m.c.l;
import d.l.b.a.b.m.c.m;
import d.l.b.a.b.m.c.q;
import d.l.b.a.b.m.c.q.a;
import d.l.b.a.b.m.c.r;
import d.l.b.a.b.m.c.t;
import d.l.b.a.b.m.g.b.a;
import d.v;
import java.util.Collection;
import java.util.List;

public final class a
  extends d.l.b.a.b.m.g
  implements c
{
  public static final a Oag;
  private final i NSV;
  private final boolean Oad;
  private final boolean Oae;
  private final boolean Oaf;
  
  static
  {
    AppMethodBeat.i(60923);
    Oag = new a((byte)0);
    AppMethodBeat.o(60923);
  }
  
  private a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, i parami)
  {
    AppMethodBeat.i(193318);
    this.Oad = paramBoolean1;
    this.Oae = paramBoolean2;
    this.Oaf = paramBoolean3;
    this.NSV = parami;
    AppMethodBeat.o(193318);
  }
  
  public final int a(l paraml)
  {
    AppMethodBeat.i(60984);
    d.g.b.p.h(paraml, "$this$size");
    int i = c.a.a(this, paraml);
    AppMethodBeat.o(60984);
    return i;
  }
  
  public final f a(d.l.b.a.b.m.c.g paramg)
  {
    AppMethodBeat.i(60935);
    d.g.b.p.h(paramg, "$this$asDynamicType");
    paramg = c.a.d(paramg);
    AppMethodBeat.o(60935);
    return paramg;
  }
  
  public final d.l.b.a.b.m.c.h a(d paramd)
  {
    AppMethodBeat.i(60930);
    d.g.b.p.h(paramd, "$this$lowerType");
    paramd = c.a.b(paramd);
    AppMethodBeat.o(60930);
    return paramd;
  }
  
  public final d.l.b.a.b.m.c.h a(d.l.b.a.b.m.c.h paramh)
  {
    AppMethodBeat.i(60916);
    d.g.b.p.h(paramh, "type");
    if (!(paramh instanceof ab))
    {
      paramh = (Throwable)new IllegalArgumentException(b.fB(paramh).toString());
      AppMethodBeat.o(60916);
      throw paramh;
    }
    n.a locala = n.Oaw;
    n.a.gyL();
    paramh = (d.l.b.a.b.m.c.h)o.c(((ab)paramh).gyC());
    AppMethodBeat.o(60916);
    return paramh;
  }
  
  public final d.l.b.a.b.m.c.h a(d.l.b.a.b.m.c.o paramo)
  {
    AppMethodBeat.i(60968);
    d.g.b.p.h(paramo, "$this$getRepresentativeUpperBound");
    paramo = c.a.d(paramo);
    AppMethodBeat.o(60968);
    return paramo;
  }
  
  public final j a(j paramj, d.l.b.a.b.m.c.b paramb)
  {
    AppMethodBeat.i(60957);
    d.g.b.p.h(paramj, "type");
    d.g.b.p.h(paramb, "status");
    paramj = c.a.b(paramj, paramb);
    AppMethodBeat.o(60957);
    return paramj;
  }
  
  public final j a(j paramj, boolean paramBoolean)
  {
    AppMethodBeat.i(60927);
    d.g.b.p.h(paramj, "$this$withNullability");
    paramj = c.a.b(paramj, paramBoolean);
    AppMethodBeat.o(60927);
    return paramj;
  }
  
  public final m a(d.l.b.a.b.m.c.h paramh, int paramInt)
  {
    AppMethodBeat.i(60945);
    d.g.b.p.h(paramh, "$this$getArgument");
    paramh = c.a.b(paramh, paramInt);
    AppMethodBeat.o(60945);
    return paramh;
  }
  
  public final m a(j paramj, int paramInt)
  {
    AppMethodBeat.i(60976);
    d.g.b.p.h(paramj, "$this$getArgumentOrNull");
    d.g.b.p.h(paramj, "$this$getArgumentOrNull");
    r localr = (r)this;
    d.g.b.p.h(paramj, "$this$getArgumentOrNull");
    paramj = q.a.a((q)localr, paramj, paramInt);
    AppMethodBeat.o(60976);
    return paramj;
  }
  
  public final m a(l paraml, int paramInt)
  {
    AppMethodBeat.i(60975);
    d.g.b.p.h(paraml, "$this$get");
    paraml = c.a.a(this, paraml, paramInt);
    AppMethodBeat.o(60975);
    return paraml;
  }
  
  public final d.l.b.a.b.m.c.o a(d.l.b.a.b.m.c.n paramn)
  {
    AppMethodBeat.i(60966);
    d.g.b.p.h(paramn, "$this$getTypeParameterClassifier");
    paramn = c.a.y(paramn);
    AppMethodBeat.o(60966);
    return paramn;
  }
  
  public final d.l.b.a.b.m.c.o a(d.l.b.a.b.m.c.n paramn, int paramInt)
  {
    AppMethodBeat.i(60951);
    d.g.b.p.h(paramn, "$this$getParameter");
    paramn = c.a.b(paramn, paramInt);
    AppMethodBeat.o(60951);
    return paramn;
  }
  
  public final List<j> a(j paramj, d.l.b.a.b.m.c.n paramn)
  {
    AppMethodBeat.i(60974);
    d.g.b.p.h(paramj, "$this$fastCorrespondingSupertypes");
    d.g.b.p.h(paramn, "constructor");
    d.g.b.p.h(paramj, "$this$fastCorrespondingSupertypes");
    d.g.b.p.h(paramn, "constructor");
    d.g.b.p.h(paramj, "$this$fastCorrespondingSupertypes");
    d.g.b.p.h(paramn, "constructor");
    paramj = q.a.b(paramj, paramn);
    AppMethodBeat.o(60974);
    return paramj;
  }
  
  public final boolean a(d.l.b.a.b.m.c.h paramh, d.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(60965);
    d.g.b.p.h(paramh, "$this$hasAnnotation");
    d.g.b.p.h(paramb, "fqName");
    boolean bool = c.a.b(paramh, paramb);
    AppMethodBeat.o(60965);
    return bool;
  }
  
  public final boolean a(j paramj1, j paramj2)
  {
    AppMethodBeat.i(60932);
    d.g.b.p.h(paramj1, "a");
    d.g.b.p.h(paramj2, "b");
    boolean bool = c.a.b(paramj1, paramj2);
    AppMethodBeat.o(60932);
    return bool;
  }
  
  public final boolean a(m paramm)
  {
    AppMethodBeat.i(60946);
    d.g.b.p.h(paramm, "$this$isStarProjection");
    boolean bool = c.a.d(paramm);
    AppMethodBeat.o(60946);
    return bool;
  }
  
  public final boolean a(d.l.b.a.b.m.c.n paramn1, d.l.b.a.b.m.c.n paramn2)
  {
    AppMethodBeat.i(60918);
    d.g.b.p.h(paramn1, "a");
    d.g.b.p.h(paramn2, "b");
    if (!(paramn1 instanceof at))
    {
      paramn1 = (Throwable)new IllegalArgumentException(b.fB(paramn1).toString());
      AppMethodBeat.o(60918);
      throw paramn1;
    }
    if (!(paramn2 instanceof at))
    {
      paramn1 = (Throwable)new IllegalArgumentException(b.fB(paramn2).toString());
      AppMethodBeat.o(60918);
      throw paramn1;
    }
    paramn1 = (at)paramn1;
    paramn2 = (at)paramn2;
    d.g.b.p.h(paramn1, "a");
    d.g.b.p.h(paramn2, "b");
    if ((paramn1 instanceof d.l.b.a.b.j.b.n))
    {
      bool = ((d.l.b.a.b.j.b.n)paramn1).c(paramn2);
      AppMethodBeat.o(60918);
      return bool;
    }
    if ((paramn2 instanceof d.l.b.a.b.j.b.n))
    {
      bool = ((d.l.b.a.b.j.b.n)paramn2).c(paramn1);
      AppMethodBeat.o(60918);
      return bool;
    }
    boolean bool = d.g.b.p.i(paramn1, paramn2);
    AppMethodBeat.o(60918);
    return bool;
  }
  
  public final d.l.b.a.b.m.c.h b(d.l.b.a.b.m.c.h paramh)
  {
    AppMethodBeat.i(60917);
    d.g.b.p.h(paramh, "type");
    if (!(paramh instanceof ab))
    {
      paramh = (Throwable)new IllegalArgumentException(b.fB(paramh).toString());
      AppMethodBeat.o(60917);
      throw paramh;
    }
    paramh = (d.l.b.a.b.m.c.h)this.NSV.aL((ab)paramh);
    AppMethodBeat.o(60917);
    return paramh;
  }
  
  public final j b(d.l.b.a.b.m.c.g paramg)
  {
    AppMethodBeat.i(60936);
    d.g.b.p.h(paramg, "$this$upperBound");
    paramg = c.a.e(paramg);
    AppMethodBeat.o(60936);
    return paramg;
  }
  
  public final t b(m paramm)
  {
    AppMethodBeat.i(60947);
    d.g.b.p.h(paramm, "$this$getVariance");
    paramm = c.a.e(paramm);
    AppMethodBeat.o(60947);
    return paramm;
  }
  
  public final t b(d.l.b.a.b.m.c.o paramo)
  {
    AppMethodBeat.i(60948);
    d.g.b.p.h(paramo, "$this$getVariance");
    paramo = c.a.c(paramo);
    AppMethodBeat.o(60948);
    return paramo;
  }
  
  public final boolean b(j paramj)
  {
    AppMethodBeat.i(60978);
    d.g.b.p.h(paramj, "$this$isClassType");
    d.g.b.p.h(paramj, "$this$isClassType");
    r localr = (r)this;
    d.g.b.p.h(paramj, "$this$isClassType");
    boolean bool = q.a.a((q)localr, paramj);
    AppMethodBeat.o(60978);
    return bool;
  }
  
  public final boolean b(d.l.b.a.b.m.c.n paramn)
  {
    AppMethodBeat.i(60967);
    d.g.b.p.h(paramn, "$this$isInlineClass");
    boolean bool = c.a.z(paramn);
    AppMethodBeat.o(60967);
    return bool;
  }
  
  public final boolean b(d.l.b.a.b.m.c.n paramn1, d.l.b.a.b.m.c.n paramn2)
  {
    AppMethodBeat.i(60953);
    d.g.b.p.h(paramn1, "c1");
    d.g.b.p.h(paramn2, "c2");
    boolean bool = c.a.c(paramn1, paramn2);
    AppMethodBeat.o(60953);
    return bool;
  }
  
  public final d.l.b.a.b.a.h c(d.l.b.a.b.m.c.n paramn)
  {
    AppMethodBeat.i(60970);
    d.g.b.p.h(paramn, "$this$getPrimitiveType");
    paramn = c.a.A(paramn);
    AppMethodBeat.o(60970);
    return paramn;
  }
  
  public final d.l.b.a.b.m.c.h c(m paramm)
  {
    AppMethodBeat.i(60949);
    d.g.b.p.h(paramm, "$this$getType");
    paramm = c.a.f(paramm);
    AppMethodBeat.o(60949);
    return paramm;
  }
  
  public final j c(d.l.b.a.b.m.c.g paramg)
  {
    AppMethodBeat.i(60937);
    d.g.b.p.h(paramg, "$this$lowerBound");
    paramg = c.a.f(paramg);
    AppMethodBeat.o(60937);
    return paramg;
  }
  
  public final boolean c(d.l.b.a.b.m.c.h paramh)
  {
    AppMethodBeat.i(60920);
    d.g.b.p.h(paramh, "$this$isAllowedTypeVariable");
    if (((paramh instanceof bg)) && (this.Oaf) && ((((bg)paramh).gxB() instanceof p)))
    {
      AppMethodBeat.o(60920);
      return true;
    }
    AppMethodBeat.o(60920);
    return false;
  }
  
  public final boolean c(j paramj)
  {
    AppMethodBeat.i(60981);
    d.g.b.p.h(paramj, "$this$isIntegerLiteralType");
    d.g.b.p.h(paramj, "$this$isIntegerLiteralType");
    r localr = (r)this;
    d.g.b.p.h(paramj, "$this$isIntegerLiteralType");
    boolean bool = q.a.b((q)localr, paramj);
    AppMethodBeat.o(60981);
    return bool;
  }
  
  public final d.l.b.a.b.a.h d(d.l.b.a.b.m.c.n paramn)
  {
    AppMethodBeat.i(60971);
    d.g.b.p.h(paramn, "$this$getPrimitiveArrayType");
    paramn = c.a.B(paramn);
    AppMethodBeat.o(60971);
    return paramn;
  }
  
  public final d.l.b.a.b.m.c.n d(d.l.b.a.b.m.c.h paramh)
  {
    AppMethodBeat.i(60943);
    d.g.b.p.h(paramh, "$this$typeConstructor");
    paramh = c.a.b(this, paramh);
    AppMethodBeat.o(60943);
    return paramh;
  }
  
  public final Collection<d.l.b.a.b.m.c.h> d(j paramj)
  {
    AppMethodBeat.i(60926);
    d.g.b.p.h(paramj, "$this$possibleIntegerTypes");
    paramj = c.a.a(this, paramj);
    AppMethodBeat.o(60926);
    return paramj;
  }
  
  public final j e(d.l.b.a.b.m.c.h paramh)
  {
    AppMethodBeat.i(60983);
    d.g.b.p.h(paramh, "$this$lowerBoundIfFlexible");
    paramh = c.a.c(this, paramh);
    AppMethodBeat.o(60983);
    return paramh;
  }
  
  public final boolean e(j paramj)
  {
    AppMethodBeat.i(60929);
    d.g.b.p.h(paramj, "$this$isStubType");
    boolean bool = c.a.m(paramj);
    AppMethodBeat.o(60929);
    return bool;
  }
  
  public final boolean e(d.l.b.a.b.m.c.n paramn)
  {
    AppMethodBeat.i(60972);
    d.g.b.p.h(paramn, "$this$isUnderKotlinPackage");
    boolean bool = c.a.C(paramn);
    AppMethodBeat.o(60972);
    return bool;
  }
  
  public final d.l.b.a.b.f.c f(d.l.b.a.b.m.c.n paramn)
  {
    AppMethodBeat.i(60973);
    d.g.b.p.h(paramn, "$this$getClassFqNameUnsafe");
    paramn = c.a.D(paramn);
    AppMethodBeat.o(60973);
    return paramn;
  }
  
  public final d f(j paramj)
  {
    AppMethodBeat.i(60938);
    d.g.b.p.h(paramj, "$this$asCapturedType");
    paramj = c.a.n(paramj);
    AppMethodBeat.o(60938);
    return paramj;
  }
  
  public final j f(d.l.b.a.b.m.c.h paramh)
  {
    AppMethodBeat.i(60985);
    d.g.b.p.h(paramh, "$this$upperBoundIfFlexible");
    paramh = c.a.d(this, paramh);
    AppMethodBeat.o(60985);
    return paramh;
  }
  
  public final e g(j paramj)
  {
    AppMethodBeat.i(60939);
    d.g.b.p.h(paramj, "$this$asDefinitelyNotNullType");
    paramj = c.a.o(paramj);
    AppMethodBeat.o(60939);
    return paramj;
  }
  
  public final boolean g(d.l.b.a.b.m.c.h paramh)
  {
    AppMethodBeat.i(60980);
    d.g.b.p.h(paramh, "$this$isDynamic");
    d.g.b.p.h(paramh, "$this$isDynamic");
    r localr = (r)this;
    d.g.b.p.h(paramh, "$this$isDynamic");
    boolean bool = q.a.c((q)localr, paramh);
    AppMethodBeat.o(60980);
    return bool;
  }
  
  public final boolean g(d.l.b.a.b.m.c.n paramn)
  {
    AppMethodBeat.i(60924);
    d.g.b.p.h(paramn, "$this$isDenotable");
    boolean bool = c.a.p(paramn);
    AppMethodBeat.o(60924);
    return bool;
  }
  
  public final boolean gys()
  {
    return this.Oad;
  }
  
  public final boolean gyt()
  {
    return this.Oae;
  }
  
  public final boolean h(d.l.b.a.b.m.c.h paramh)
  {
    AppMethodBeat.i(60979);
    d.g.b.p.h(paramh, "$this$isDefinitelyNotNullType");
    d.g.b.p.h(paramh, "$this$isDefinitelyNotNullType");
    r localr = (r)this;
    d.g.b.p.h(paramh, "$this$isDefinitelyNotNullType");
    boolean bool = q.a.d((q)localr, paramh);
    AppMethodBeat.o(60979);
    return bool;
  }
  
  public final boolean h(j paramj)
  {
    AppMethodBeat.i(60940);
    d.g.b.p.h(paramj, "$this$isMarkedNullable");
    boolean bool = c.a.p(paramj);
    AppMethodBeat.o(60940);
    return bool;
  }
  
  public final boolean h(d.l.b.a.b.m.c.n paramn)
  {
    AppMethodBeat.i(60925);
    d.g.b.p.h(paramn, "$this$isIntegerLiteralTypeConstructor");
    boolean bool = c.a.q(paramn);
    AppMethodBeat.o(60925);
    return bool;
  }
  
  public final d.l.b.a.b.m.c.n i(j paramj)
  {
    AppMethodBeat.i(60942);
    d.g.b.p.h(paramj, "$this$typeConstructor");
    paramj = c.a.q(paramj);
    AppMethodBeat.o(60942);
    return paramj;
  }
  
  public final boolean i(d.l.b.a.b.m.c.h paramh)
  {
    AppMethodBeat.i(60977);
    d.g.b.p.h(paramh, "$this$hasFlexibleNullability");
    d.g.b.p.h(paramh, "$this$hasFlexibleNullability");
    r localr = (r)this;
    d.g.b.p.h(paramh, "$this$hasFlexibleNullability");
    boolean bool = q.a.e((q)localr, paramh);
    AppMethodBeat.o(60977);
    return bool;
  }
  
  public final boolean i(d.l.b.a.b.m.c.n paramn)
  {
    AppMethodBeat.i(60931);
    d.g.b.p.h(paramn, "$this$isIntersection");
    boolean bool = c.a.r(paramn);
    AppMethodBeat.o(60931);
    return bool;
  }
  
  public final int j(d.l.b.a.b.m.c.n paramn)
  {
    AppMethodBeat.i(60950);
    d.g.b.p.h(paramn, "$this$parametersCount");
    int i = c.a.s(paramn);
    AppMethodBeat.o(60950);
    return i;
  }
  
  public final l j(j paramj)
  {
    AppMethodBeat.i(60956);
    d.g.b.p.h(paramj, "$this$asArgumentList");
    paramj = c.a.r(paramj);
    AppMethodBeat.o(60956);
    return paramj;
  }
  
  public final boolean j(d.l.b.a.b.m.c.h paramh)
  {
    AppMethodBeat.i(60982);
    d.g.b.p.h(paramh, "$this$isNothing");
    d.g.b.p.h(paramh, "$this$isNothing");
    r localr = (r)this;
    d.g.b.p.h(paramh, "$this$isNothing");
    boolean bool = q.a.g((q)localr, paramh);
    AppMethodBeat.o(60982);
    return bool;
  }
  
  public final d.l.b.a.b.m.c.h jD(List<? extends d.l.b.a.b.m.c.h> paramList)
  {
    AppMethodBeat.i(60962);
    d.g.b.p.h(paramList, "types");
    paramList = c.a.jE(paramList);
    AppMethodBeat.o(60962);
    return paramList;
  }
  
  public final d.l.b.a.b.m.c.h k(d.l.b.a.b.m.c.h paramh)
  {
    AppMethodBeat.i(60969);
    d.g.b.p.h(paramh, "$this$getSubstitutedUnderlyingType");
    paramh = c.a.z(paramh);
    AppMethodBeat.o(60969);
    return paramh;
  }
  
  public final Collection<d.l.b.a.b.m.c.h> k(d.l.b.a.b.m.c.n paramn)
  {
    AppMethodBeat.i(60952);
    d.g.b.p.h(paramn, "$this$supertypes");
    paramn = c.a.t(paramn);
    AppMethodBeat.o(60952);
    return paramn;
  }
  
  public final boolean k(j paramj)
  {
    AppMethodBeat.i(60961);
    d.g.b.p.h(paramj, "$this$isSingleClassifierType");
    boolean bool = c.a.s(paramj);
    AppMethodBeat.o(60961);
    return bool;
  }
  
  public final boolean l(d.l.b.a.b.m.c.h paramh)
  {
    AppMethodBeat.i(60941);
    d.g.b.p.h(paramh, "$this$isMarkedNullable");
    boolean bool = c.a.a(this, paramh);
    AppMethodBeat.o(60941);
    return bool;
  }
  
  public final boolean l(j paramj)
  {
    AppMethodBeat.i(60964);
    d.g.b.p.h(paramj, "$this$isPrimitiveType");
    boolean bool = c.a.t(paramj);
    AppMethodBeat.o(60964);
    return bool;
  }
  
  public final boolean l(d.l.b.a.b.m.c.n paramn)
  {
    AppMethodBeat.i(60954);
    d.g.b.p.h(paramn, "$this$isClassTypeConstructor");
    boolean bool = c.a.u(paramn);
    AppMethodBeat.o(60954);
    return bool;
  }
  
  public final d.l.b.a.b.m.c.h m(d.l.b.a.b.m.c.h paramh)
  {
    AppMethodBeat.i(60986);
    d.g.b.p.h(paramh, "$this$makeNullable");
    paramh = c.a.e(this, paramh);
    AppMethodBeat.o(60986);
    return paramh;
  }
  
  public final boolean m(d.l.b.a.b.m.c.n paramn)
  {
    AppMethodBeat.i(60955);
    d.g.b.p.h(paramn, "$this$isCommonFinalClassConstructor");
    boolean bool = c.a.v(paramn);
    AppMethodBeat.o(60955);
    return bool;
  }
  
  public final boolean n(d.l.b.a.b.m.c.h paramh)
  {
    AppMethodBeat.i(60928);
    d.g.b.p.h(paramh, "$this$isError");
    boolean bool = c.a.t(paramh);
    AppMethodBeat.o(60928);
    return bool;
  }
  
  public final boolean n(d.l.b.a.b.m.c.n paramn)
  {
    AppMethodBeat.i(60958);
    d.g.b.p.h(paramn, "$this$isAnyConstructor");
    boolean bool = c.a.w(paramn);
    AppMethodBeat.o(60958);
    return bool;
  }
  
  public final j o(d.l.b.a.b.m.c.h paramh)
  {
    AppMethodBeat.i(60933);
    d.g.b.p.h(paramh, "$this$asSimpleType");
    paramh = c.a.u(paramh);
    AppMethodBeat.o(60933);
    return paramh;
  }
  
  public final boolean o(d.l.b.a.b.m.c.n paramn)
  {
    AppMethodBeat.i(60959);
    d.g.b.p.h(paramn, "$this$isNothingConstructor");
    boolean bool = c.a.x(paramn);
    AppMethodBeat.o(60959);
    return bool;
  }
  
  public final d.l.b.a.b.m.c.g p(d.l.b.a.b.m.c.h paramh)
  {
    AppMethodBeat.i(60934);
    d.g.b.p.h(paramh, "$this$asFlexibleType");
    paramh = c.a.v(paramh);
    AppMethodBeat.o(60934);
    return paramh;
  }
  
  public final int q(d.l.b.a.b.m.c.h paramh)
  {
    AppMethodBeat.i(60944);
    d.g.b.p.h(paramh, "$this$argumentsCount");
    int i = c.a.w(paramh);
    AppMethodBeat.o(60944);
    return i;
  }
  
  public final m r(d.l.b.a.b.m.c.h paramh)
  {
    AppMethodBeat.i(60960);
    d.g.b.p.h(paramh, "$this$asTypeArgument");
    paramh = c.a.x(paramh);
    AppMethodBeat.o(60960);
    return paramh;
  }
  
  public final boolean s(d.l.b.a.b.m.c.h paramh)
  {
    AppMethodBeat.i(60963);
    d.g.b.p.h(paramh, "$this$isNullableType");
    boolean bool = c.a.y(paramh);
    AppMethodBeat.o(60963);
    return bool;
  }
  
  public static final class a
  {
    public static final class a
      extends g.b.a
    {
      a(c paramc, ba paramba) {}
      
      public final j b(d.l.b.a.b.m.g paramg, d.l.b.a.b.m.c.h paramh)
      {
        AppMethodBeat.i(60915);
        d.g.b.p.h(paramg, "context");
        d.g.b.p.h(paramh, "type");
        paramg = this.Oah;
        ba localba = this.Nrk;
        paramh = this.Oah.e(paramh);
        if (paramh == null)
        {
          paramg = new v("null cannot be cast to non-null type org.jetbrains.kotlin.types.KotlinType");
          AppMethodBeat.o(60915);
          throw paramg;
        }
        paramh = localba.b((ab)paramh, bh.NZW);
        d.g.b.p.g(paramh, "substitutor.safeSubstitu…ANT\n                    )");
        paramg = paramg.o((d.l.b.a.b.m.c.h)paramh);
        if (paramg == null) {
          d.g.b.p.gkB();
        }
        AppMethodBeat.o(60915);
        return paramg;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.a.a
 * JD-Core Version:    0.7.0.1
 */