package kotlin.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.ba;
import kotlin.l.b.a.b.m.bg;
import kotlin.l.b.a.b.m.bh;
import kotlin.l.b.a.b.m.c.d;
import kotlin.l.b.a.b.m.c.e;
import kotlin.l.b.a.b.m.c.f;
import kotlin.l.b.a.b.m.c.j;
import kotlin.l.b.a.b.m.c.l;
import kotlin.l.b.a.b.m.c.m;
import kotlin.l.b.a.b.m.c.q;
import kotlin.l.b.a.b.m.c.q.a;
import kotlin.l.b.a.b.m.c.r;
import kotlin.l.b.a.b.m.g.b.a;

public final class a
  extends kotlin.l.b.a.b.m.g
  implements c
{
  public static final a abrz;
  private final i abkv;
  private final boolean abrw;
  private final boolean abrx;
  private final boolean abry;
  
  static
  {
    AppMethodBeat.i(60923);
    abrz = new a((byte)0);
    AppMethodBeat.o(60923);
  }
  
  private a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, i parami)
  {
    AppMethodBeat.i(270244);
    this.abrw = paramBoolean1;
    this.abrx = paramBoolean2;
    this.abry = paramBoolean3;
    this.abkv = parami;
    AppMethodBeat.o(270244);
  }
  
  public final int a(l paraml)
  {
    AppMethodBeat.i(60984);
    kotlin.g.b.p.k(paraml, "$this$size");
    int i = c.a.a(this, paraml);
    AppMethodBeat.o(60984);
    return i;
  }
  
  public final List<j> a(j paramj, kotlin.l.b.a.b.m.c.n paramn)
  {
    AppMethodBeat.i(60974);
    kotlin.g.b.p.k(paramj, "$this$fastCorrespondingSupertypes");
    kotlin.g.b.p.k(paramn, "constructor");
    kotlin.g.b.p.k(paramj, "$this$fastCorrespondingSupertypes");
    kotlin.g.b.p.k(paramn, "constructor");
    kotlin.g.b.p.k(paramj, "$this$fastCorrespondingSupertypes");
    kotlin.g.b.p.k(paramn, "constructor");
    paramj = q.a.b(paramj, paramn);
    AppMethodBeat.o(60974);
    return paramj;
  }
  
  public final f a(kotlin.l.b.a.b.m.c.g paramg)
  {
    AppMethodBeat.i(60935);
    kotlin.g.b.p.k(paramg, "$this$asDynamicType");
    paramg = c.a.d(paramg);
    AppMethodBeat.o(60935);
    return paramg;
  }
  
  public final kotlin.l.b.a.b.m.c.h a(d paramd)
  {
    AppMethodBeat.i(60930);
    kotlin.g.b.p.k(paramd, "$this$lowerType");
    paramd = c.a.b(paramd);
    AppMethodBeat.o(60930);
    return paramd;
  }
  
  public final kotlin.l.b.a.b.m.c.h a(kotlin.l.b.a.b.m.c.h paramh)
  {
    AppMethodBeat.i(60916);
    kotlin.g.b.p.k(paramh, "type");
    if (!(paramh instanceof ab))
    {
      paramh = (Throwable)new IllegalArgumentException(b.fL(paramh).toString());
      AppMethodBeat.o(60916);
      throw paramh;
    }
    n.a locala = n.abrP;
    n.a.iQg();
    paramh = (kotlin.l.b.a.b.m.c.h)o.c(((ab)paramh).iPX());
    AppMethodBeat.o(60916);
    return paramh;
  }
  
  public final kotlin.l.b.a.b.m.c.h a(kotlin.l.b.a.b.m.c.o paramo)
  {
    AppMethodBeat.i(60968);
    kotlin.g.b.p.k(paramo, "$this$getRepresentativeUpperBound");
    paramo = c.a.d(paramo);
    AppMethodBeat.o(60968);
    return paramo;
  }
  
  public final j a(j paramj, kotlin.l.b.a.b.m.c.b paramb)
  {
    AppMethodBeat.i(60957);
    kotlin.g.b.p.k(paramj, "type");
    kotlin.g.b.p.k(paramb, "status");
    paramj = c.a.b(paramj, paramb);
    AppMethodBeat.o(60957);
    return paramj;
  }
  
  public final j a(j paramj, boolean paramBoolean)
  {
    AppMethodBeat.i(60927);
    kotlin.g.b.p.k(paramj, "$this$withNullability");
    paramj = c.a.b(paramj, paramBoolean);
    AppMethodBeat.o(60927);
    return paramj;
  }
  
  public final m a(kotlin.l.b.a.b.m.c.h paramh, int paramInt)
  {
    AppMethodBeat.i(60945);
    kotlin.g.b.p.k(paramh, "$this$getArgument");
    paramh = c.a.b(paramh, paramInt);
    AppMethodBeat.o(60945);
    return paramh;
  }
  
  public final m a(j paramj, int paramInt)
  {
    AppMethodBeat.i(60976);
    kotlin.g.b.p.k(paramj, "$this$getArgumentOrNull");
    kotlin.g.b.p.k(paramj, "$this$getArgumentOrNull");
    r localr = (r)this;
    kotlin.g.b.p.k(paramj, "$this$getArgumentOrNull");
    paramj = q.a.a((q)localr, paramj, paramInt);
    AppMethodBeat.o(60976);
    return paramj;
  }
  
  public final m a(l paraml, int paramInt)
  {
    AppMethodBeat.i(60975);
    kotlin.g.b.p.k(paraml, "$this$get");
    paraml = c.a.a(this, paraml, paramInt);
    AppMethodBeat.o(60975);
    return paraml;
  }
  
  public final kotlin.l.b.a.b.m.c.o a(kotlin.l.b.a.b.m.c.n paramn)
  {
    AppMethodBeat.i(60966);
    kotlin.g.b.p.k(paramn, "$this$getTypeParameterClassifier");
    paramn = c.a.y(paramn);
    AppMethodBeat.o(60966);
    return paramn;
  }
  
  public final kotlin.l.b.a.b.m.c.o a(kotlin.l.b.a.b.m.c.n paramn, int paramInt)
  {
    AppMethodBeat.i(60951);
    kotlin.g.b.p.k(paramn, "$this$getParameter");
    paramn = c.a.b(paramn, paramInt);
    AppMethodBeat.o(60951);
    return paramn;
  }
  
  public final boolean a(kotlin.l.b.a.b.m.c.h paramh, kotlin.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(60965);
    kotlin.g.b.p.k(paramh, "$this$hasAnnotation");
    kotlin.g.b.p.k(paramb, "fqName");
    boolean bool = c.a.b(paramh, paramb);
    AppMethodBeat.o(60965);
    return bool;
  }
  
  public final boolean a(j paramj1, j paramj2)
  {
    AppMethodBeat.i(60932);
    kotlin.g.b.p.k(paramj1, "a");
    kotlin.g.b.p.k(paramj2, "b");
    boolean bool = c.a.b(paramj1, paramj2);
    AppMethodBeat.o(60932);
    return bool;
  }
  
  public final boolean a(m paramm)
  {
    AppMethodBeat.i(60946);
    kotlin.g.b.p.k(paramm, "$this$isStarProjection");
    boolean bool = c.a.d(paramm);
    AppMethodBeat.o(60946);
    return bool;
  }
  
  public final boolean a(kotlin.l.b.a.b.m.c.n paramn1, kotlin.l.b.a.b.m.c.n paramn2)
  {
    AppMethodBeat.i(60918);
    kotlin.g.b.p.k(paramn1, "a");
    kotlin.g.b.p.k(paramn2, "b");
    if (!(paramn1 instanceof at))
    {
      paramn1 = (Throwable)new IllegalArgumentException(b.fL(paramn1).toString());
      AppMethodBeat.o(60918);
      throw paramn1;
    }
    if (!(paramn2 instanceof at))
    {
      paramn1 = (Throwable)new IllegalArgumentException(b.fL(paramn2).toString());
      AppMethodBeat.o(60918);
      throw paramn1;
    }
    paramn1 = (at)paramn1;
    paramn2 = (at)paramn2;
    kotlin.g.b.p.k(paramn1, "a");
    kotlin.g.b.p.k(paramn2, "b");
    if ((paramn1 instanceof kotlin.l.b.a.b.j.b.n))
    {
      bool = ((kotlin.l.b.a.b.j.b.n)paramn1).c(paramn2);
      AppMethodBeat.o(60918);
      return bool;
    }
    if ((paramn2 instanceof kotlin.l.b.a.b.j.b.n))
    {
      bool = ((kotlin.l.b.a.b.j.b.n)paramn2).c(paramn1);
      AppMethodBeat.o(60918);
      return bool;
    }
    boolean bool = kotlin.g.b.p.h(paramn1, paramn2);
    AppMethodBeat.o(60918);
    return bool;
  }
  
  public final kotlin.l.b.a.b.m.c.h b(kotlin.l.b.a.b.m.c.h paramh)
  {
    AppMethodBeat.i(60917);
    kotlin.g.b.p.k(paramh, "type");
    if (!(paramh instanceof ab))
    {
      paramh = (Throwable)new IllegalArgumentException(b.fL(paramh).toString());
      AppMethodBeat.o(60917);
      throw paramh;
    }
    paramh = (kotlin.l.b.a.b.m.c.h)this.abkv.aK((ab)paramh);
    AppMethodBeat.o(60917);
    return paramh;
  }
  
  public final j b(kotlin.l.b.a.b.m.c.g paramg)
  {
    AppMethodBeat.i(60936);
    kotlin.g.b.p.k(paramg, "$this$upperBound");
    paramg = c.a.e(paramg);
    AppMethodBeat.o(60936);
    return paramg;
  }
  
  public final kotlin.l.b.a.b.m.c.t b(m paramm)
  {
    AppMethodBeat.i(60947);
    kotlin.g.b.p.k(paramm, "$this$getVariance");
    paramm = c.a.e(paramm);
    AppMethodBeat.o(60947);
    return paramm;
  }
  
  public final kotlin.l.b.a.b.m.c.t b(kotlin.l.b.a.b.m.c.o paramo)
  {
    AppMethodBeat.i(60948);
    kotlin.g.b.p.k(paramo, "$this$getVariance");
    paramo = c.a.c(paramo);
    AppMethodBeat.o(60948);
    return paramo;
  }
  
  public final boolean b(j paramj)
  {
    AppMethodBeat.i(60978);
    kotlin.g.b.p.k(paramj, "$this$isClassType");
    kotlin.g.b.p.k(paramj, "$this$isClassType");
    r localr = (r)this;
    kotlin.g.b.p.k(paramj, "$this$isClassType");
    boolean bool = q.a.a((q)localr, paramj);
    AppMethodBeat.o(60978);
    return bool;
  }
  
  public final boolean b(kotlin.l.b.a.b.m.c.n paramn)
  {
    AppMethodBeat.i(60967);
    kotlin.g.b.p.k(paramn, "$this$isInlineClass");
    boolean bool = c.a.z(paramn);
    AppMethodBeat.o(60967);
    return bool;
  }
  
  public final boolean b(kotlin.l.b.a.b.m.c.n paramn1, kotlin.l.b.a.b.m.c.n paramn2)
  {
    AppMethodBeat.i(60953);
    kotlin.g.b.p.k(paramn1, "c1");
    kotlin.g.b.p.k(paramn2, "c2");
    boolean bool = c.a.c(paramn1, paramn2);
    AppMethodBeat.o(60953);
    return bool;
  }
  
  public final kotlin.l.b.a.b.a.h c(kotlin.l.b.a.b.m.c.n paramn)
  {
    AppMethodBeat.i(60970);
    kotlin.g.b.p.k(paramn, "$this$getPrimitiveType");
    paramn = c.a.A(paramn);
    AppMethodBeat.o(60970);
    return paramn;
  }
  
  public final kotlin.l.b.a.b.m.c.h c(m paramm)
  {
    AppMethodBeat.i(60949);
    kotlin.g.b.p.k(paramm, "$this$getType");
    paramm = c.a.f(paramm);
    AppMethodBeat.o(60949);
    return paramm;
  }
  
  public final j c(kotlin.l.b.a.b.m.c.g paramg)
  {
    AppMethodBeat.i(60937);
    kotlin.g.b.p.k(paramg, "$this$lowerBound");
    paramg = c.a.f(paramg);
    AppMethodBeat.o(60937);
    return paramg;
  }
  
  public final boolean c(kotlin.l.b.a.b.m.c.h paramh)
  {
    AppMethodBeat.i(60920);
    kotlin.g.b.p.k(paramh, "$this$isAllowedTypeVariable");
    if (((paramh instanceof bg)) && (this.abry) && ((((bg)paramh).iOU() instanceof p)))
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
    kotlin.g.b.p.k(paramj, "$this$isIntegerLiteralType");
    kotlin.g.b.p.k(paramj, "$this$isIntegerLiteralType");
    r localr = (r)this;
    kotlin.g.b.p.k(paramj, "$this$isIntegerLiteralType");
    boolean bool = q.a.b((q)localr, paramj);
    AppMethodBeat.o(60981);
    return bool;
  }
  
  public final Collection<kotlin.l.b.a.b.m.c.h> d(j paramj)
  {
    AppMethodBeat.i(60926);
    kotlin.g.b.p.k(paramj, "$this$possibleIntegerTypes");
    paramj = c.a.a(this, paramj);
    AppMethodBeat.o(60926);
    return paramj;
  }
  
  public final kotlin.l.b.a.b.a.h d(kotlin.l.b.a.b.m.c.n paramn)
  {
    AppMethodBeat.i(60971);
    kotlin.g.b.p.k(paramn, "$this$getPrimitiveArrayType");
    paramn = c.a.B(paramn);
    AppMethodBeat.o(60971);
    return paramn;
  }
  
  public final kotlin.l.b.a.b.m.c.n d(kotlin.l.b.a.b.m.c.h paramh)
  {
    AppMethodBeat.i(60943);
    kotlin.g.b.p.k(paramh, "$this$typeConstructor");
    paramh = c.a.b(this, paramh);
    AppMethodBeat.o(60943);
    return paramh;
  }
  
  public final j e(kotlin.l.b.a.b.m.c.h paramh)
  {
    AppMethodBeat.i(60983);
    kotlin.g.b.p.k(paramh, "$this$lowerBoundIfFlexible");
    paramh = c.a.c(this, paramh);
    AppMethodBeat.o(60983);
    return paramh;
  }
  
  public final boolean e(j paramj)
  {
    AppMethodBeat.i(60929);
    kotlin.g.b.p.k(paramj, "$this$isStubType");
    boolean bool = c.a.m(paramj);
    AppMethodBeat.o(60929);
    return bool;
  }
  
  public final boolean e(kotlin.l.b.a.b.m.c.n paramn)
  {
    AppMethodBeat.i(60972);
    kotlin.g.b.p.k(paramn, "$this$isUnderKotlinPackage");
    boolean bool = c.a.C(paramn);
    AppMethodBeat.o(60972);
    return bool;
  }
  
  public final kotlin.l.b.a.b.f.c f(kotlin.l.b.a.b.m.c.n paramn)
  {
    AppMethodBeat.i(60973);
    kotlin.g.b.p.k(paramn, "$this$getClassFqNameUnsafe");
    paramn = c.a.D(paramn);
    AppMethodBeat.o(60973);
    return paramn;
  }
  
  public final d f(j paramj)
  {
    AppMethodBeat.i(60938);
    kotlin.g.b.p.k(paramj, "$this$asCapturedType");
    paramj = c.a.n(paramj);
    AppMethodBeat.o(60938);
    return paramj;
  }
  
  public final j f(kotlin.l.b.a.b.m.c.h paramh)
  {
    AppMethodBeat.i(60985);
    kotlin.g.b.p.k(paramh, "$this$upperBoundIfFlexible");
    paramh = c.a.d(this, paramh);
    AppMethodBeat.o(60985);
    return paramh;
  }
  
  public final e g(j paramj)
  {
    AppMethodBeat.i(60939);
    kotlin.g.b.p.k(paramj, "$this$asDefinitelyNotNullType");
    paramj = c.a.o(paramj);
    AppMethodBeat.o(60939);
    return paramj;
  }
  
  public final boolean g(kotlin.l.b.a.b.m.c.h paramh)
  {
    AppMethodBeat.i(60980);
    kotlin.g.b.p.k(paramh, "$this$isDynamic");
    kotlin.g.b.p.k(paramh, "$this$isDynamic");
    r localr = (r)this;
    kotlin.g.b.p.k(paramh, "$this$isDynamic");
    boolean bool = q.a.c((q)localr, paramh);
    AppMethodBeat.o(60980);
    return bool;
  }
  
  public final boolean g(kotlin.l.b.a.b.m.c.n paramn)
  {
    AppMethodBeat.i(60924);
    kotlin.g.b.p.k(paramn, "$this$isDenotable");
    boolean bool = c.a.p(paramn);
    AppMethodBeat.o(60924);
    return bool;
  }
  
  public final boolean h(kotlin.l.b.a.b.m.c.h paramh)
  {
    AppMethodBeat.i(60979);
    kotlin.g.b.p.k(paramh, "$this$isDefinitelyNotNullType");
    kotlin.g.b.p.k(paramh, "$this$isDefinitelyNotNullType");
    r localr = (r)this;
    kotlin.g.b.p.k(paramh, "$this$isDefinitelyNotNullType");
    boolean bool = q.a.d((q)localr, paramh);
    AppMethodBeat.o(60979);
    return bool;
  }
  
  public final boolean h(j paramj)
  {
    AppMethodBeat.i(60940);
    kotlin.g.b.p.k(paramj, "$this$isMarkedNullable");
    boolean bool = c.a.p(paramj);
    AppMethodBeat.o(60940);
    return bool;
  }
  
  public final boolean h(kotlin.l.b.a.b.m.c.n paramn)
  {
    AppMethodBeat.i(60925);
    kotlin.g.b.p.k(paramn, "$this$isIntegerLiteralTypeConstructor");
    boolean bool = c.a.q(paramn);
    AppMethodBeat.o(60925);
    return bool;
  }
  
  public final kotlin.l.b.a.b.m.c.n i(j paramj)
  {
    AppMethodBeat.i(60942);
    kotlin.g.b.p.k(paramj, "$this$typeConstructor");
    paramj = c.a.q(paramj);
    AppMethodBeat.o(60942);
    return paramj;
  }
  
  public final boolean i(kotlin.l.b.a.b.m.c.h paramh)
  {
    AppMethodBeat.i(60977);
    kotlin.g.b.p.k(paramh, "$this$hasFlexibleNullability");
    kotlin.g.b.p.k(paramh, "$this$hasFlexibleNullability");
    r localr = (r)this;
    kotlin.g.b.p.k(paramh, "$this$hasFlexibleNullability");
    boolean bool = q.a.e((q)localr, paramh);
    AppMethodBeat.o(60977);
    return bool;
  }
  
  public final boolean i(kotlin.l.b.a.b.m.c.n paramn)
  {
    AppMethodBeat.i(60931);
    kotlin.g.b.p.k(paramn, "$this$isIntersection");
    boolean bool = c.a.r(paramn);
    AppMethodBeat.o(60931);
    return bool;
  }
  
  public final boolean iPO()
  {
    return this.abrw;
  }
  
  public final boolean iPP()
  {
    return this.abrx;
  }
  
  public final int j(kotlin.l.b.a.b.m.c.n paramn)
  {
    AppMethodBeat.i(60950);
    kotlin.g.b.p.k(paramn, "$this$parametersCount");
    int i = c.a.s(paramn);
    AppMethodBeat.o(60950);
    return i;
  }
  
  public final l j(j paramj)
  {
    AppMethodBeat.i(60956);
    kotlin.g.b.p.k(paramj, "$this$asArgumentList");
    paramj = c.a.r(paramj);
    AppMethodBeat.o(60956);
    return paramj;
  }
  
  public final boolean j(kotlin.l.b.a.b.m.c.h paramh)
  {
    AppMethodBeat.i(60982);
    kotlin.g.b.p.k(paramh, "$this$isNothing");
    kotlin.g.b.p.k(paramh, "$this$isNothing");
    r localr = (r)this;
    kotlin.g.b.p.k(paramh, "$this$isNothing");
    boolean bool = q.a.g((q)localr, paramh);
    AppMethodBeat.o(60982);
    return bool;
  }
  
  public final Collection<kotlin.l.b.a.b.m.c.h> k(kotlin.l.b.a.b.m.c.n paramn)
  {
    AppMethodBeat.i(60952);
    kotlin.g.b.p.k(paramn, "$this$supertypes");
    paramn = c.a.t(paramn);
    AppMethodBeat.o(60952);
    return paramn;
  }
  
  public final kotlin.l.b.a.b.m.c.h k(kotlin.l.b.a.b.m.c.h paramh)
  {
    AppMethodBeat.i(60969);
    kotlin.g.b.p.k(paramh, "$this$getSubstitutedUnderlyingType");
    paramh = c.a.z(paramh);
    AppMethodBeat.o(60969);
    return paramh;
  }
  
  public final boolean k(j paramj)
  {
    AppMethodBeat.i(60961);
    kotlin.g.b.p.k(paramj, "$this$isSingleClassifierType");
    boolean bool = c.a.s(paramj);
    AppMethodBeat.o(60961);
    return bool;
  }
  
  public final boolean l(kotlin.l.b.a.b.m.c.h paramh)
  {
    AppMethodBeat.i(60941);
    kotlin.g.b.p.k(paramh, "$this$isMarkedNullable");
    boolean bool = c.a.a(this, paramh);
    AppMethodBeat.o(60941);
    return bool;
  }
  
  public final boolean l(j paramj)
  {
    AppMethodBeat.i(60964);
    kotlin.g.b.p.k(paramj, "$this$isPrimitiveType");
    boolean bool = c.a.t(paramj);
    AppMethodBeat.o(60964);
    return bool;
  }
  
  public final boolean l(kotlin.l.b.a.b.m.c.n paramn)
  {
    AppMethodBeat.i(60954);
    kotlin.g.b.p.k(paramn, "$this$isClassTypeConstructor");
    boolean bool = c.a.u(paramn);
    AppMethodBeat.o(60954);
    return bool;
  }
  
  public final kotlin.l.b.a.b.m.c.h lG(List<? extends kotlin.l.b.a.b.m.c.h> paramList)
  {
    AppMethodBeat.i(60962);
    kotlin.g.b.p.k(paramList, "types");
    paramList = c.a.lH(paramList);
    AppMethodBeat.o(60962);
    return paramList;
  }
  
  public final kotlin.l.b.a.b.m.c.h m(kotlin.l.b.a.b.m.c.h paramh)
  {
    AppMethodBeat.i(60986);
    kotlin.g.b.p.k(paramh, "$this$makeNullable");
    paramh = c.a.e(this, paramh);
    AppMethodBeat.o(60986);
    return paramh;
  }
  
  public final boolean m(kotlin.l.b.a.b.m.c.n paramn)
  {
    AppMethodBeat.i(60955);
    kotlin.g.b.p.k(paramn, "$this$isCommonFinalClassConstructor");
    boolean bool = c.a.v(paramn);
    AppMethodBeat.o(60955);
    return bool;
  }
  
  public final boolean n(kotlin.l.b.a.b.m.c.h paramh)
  {
    AppMethodBeat.i(60928);
    kotlin.g.b.p.k(paramh, "$this$isError");
    boolean bool = c.a.t(paramh);
    AppMethodBeat.o(60928);
    return bool;
  }
  
  public final boolean n(kotlin.l.b.a.b.m.c.n paramn)
  {
    AppMethodBeat.i(60958);
    kotlin.g.b.p.k(paramn, "$this$isAnyConstructor");
    boolean bool = c.a.w(paramn);
    AppMethodBeat.o(60958);
    return bool;
  }
  
  public final j o(kotlin.l.b.a.b.m.c.h paramh)
  {
    AppMethodBeat.i(60933);
    kotlin.g.b.p.k(paramh, "$this$asSimpleType");
    paramh = c.a.u(paramh);
    AppMethodBeat.o(60933);
    return paramh;
  }
  
  public final boolean o(kotlin.l.b.a.b.m.c.n paramn)
  {
    AppMethodBeat.i(60959);
    kotlin.g.b.p.k(paramn, "$this$isNothingConstructor");
    boolean bool = c.a.x(paramn);
    AppMethodBeat.o(60959);
    return bool;
  }
  
  public final kotlin.l.b.a.b.m.c.g p(kotlin.l.b.a.b.m.c.h paramh)
  {
    AppMethodBeat.i(60934);
    kotlin.g.b.p.k(paramh, "$this$asFlexibleType");
    paramh = c.a.v(paramh);
    AppMethodBeat.o(60934);
    return paramh;
  }
  
  public final int q(kotlin.l.b.a.b.m.c.h paramh)
  {
    AppMethodBeat.i(60944);
    kotlin.g.b.p.k(paramh, "$this$argumentsCount");
    int i = c.a.w(paramh);
    AppMethodBeat.o(60944);
    return i;
  }
  
  public final m r(kotlin.l.b.a.b.m.c.h paramh)
  {
    AppMethodBeat.i(60960);
    kotlin.g.b.p.k(paramh, "$this$asTypeArgument");
    paramh = c.a.x(paramh);
    AppMethodBeat.o(60960);
    return paramh;
  }
  
  public final boolean s(kotlin.l.b.a.b.m.c.h paramh)
  {
    AppMethodBeat.i(60963);
    kotlin.g.b.p.k(paramh, "$this$isNullableType");
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
      
      public final j b(kotlin.l.b.a.b.m.g paramg, kotlin.l.b.a.b.m.c.h paramh)
      {
        AppMethodBeat.i(60915);
        kotlin.g.b.p.k(paramg, "context");
        kotlin.g.b.p.k(paramh, "type");
        paramg = this.abrA;
        ba localba = this.aaJM;
        paramh = this.abrA.e(paramh);
        if (paramh == null)
        {
          paramg = new kotlin.t("null cannot be cast to non-null type org.jetbrains.kotlin.types.KotlinType");
          AppMethodBeat.o(60915);
          throw paramg;
        }
        paramh = localba.b((ab)paramh, bh.abrp);
        kotlin.g.b.p.j(paramh, "substitutor.safeSubstitu…ANT\n                    )");
        paramg = paramg.o((kotlin.l.b.a.b.m.c.h)paramh);
        if (paramg == null) {
          kotlin.g.b.p.iCn();
        }
        AppMethodBeat.o(60915);
        return paramg;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.m.a.a
 * JD-Core Version:    0.7.0.1
 */