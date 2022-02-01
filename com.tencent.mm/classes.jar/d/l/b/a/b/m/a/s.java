package d.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.a.h;
import d.l.b.a.b.m.c.d;
import d.l.b.a.b.m.c.e;
import d.l.b.a.b.m.c.f;
import d.l.b.a.b.m.c.g;
import d.l.b.a.b.m.c.i;
import d.l.b.a.b.m.c.l;
import d.l.b.a.b.m.c.m;
import d.l.b.a.b.m.c.n;
import java.util.Collection;
import java.util.List;

public final class s
  implements c
{
  public static final s JZg;
  
  static
  {
    AppMethodBeat.i(61092);
    JZg = new s();
    AppMethodBeat.o(61092);
  }
  
  public final int a(d.l.b.a.b.m.c.k paramk)
  {
    AppMethodBeat.i(61145);
    d.g.b.k.h(paramk, "$this$size");
    int i = c.a.a(this, paramk);
    AppMethodBeat.o(61145);
    return i;
  }
  
  public final e a(f paramf)
  {
    AppMethodBeat.i(61104);
    d.g.b.k.h(paramf, "$this$asDynamicType");
    paramf = c.a.d(paramf);
    AppMethodBeat.o(61104);
    return paramf;
  }
  
  public final g a(d.l.b.a.b.m.c.c paramc)
  {
    AppMethodBeat.i(61099);
    d.g.b.k.h(paramc, "$this$lowerType");
    paramc = c.a.b(paramc);
    AppMethodBeat.o(61099);
    return paramc;
  }
  
  public final g a(n paramn)
  {
    AppMethodBeat.i(61137);
    d.g.b.k.h(paramn, "$this$getRepresentativeUpperBound");
    paramn = c.a.d(paramn);
    AppMethodBeat.o(61137);
    return paramn;
  }
  
  public final i a(i parami, d.l.b.a.b.m.c.b paramb)
  {
    AppMethodBeat.i(61126);
    d.g.b.k.h(parami, "type");
    d.g.b.k.h(paramb, "status");
    parami = c.a.b(parami, paramb);
    AppMethodBeat.o(61126);
    return parami;
  }
  
  public final i a(i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(61096);
    d.g.b.k.h(parami, "$this$withNullability");
    parami = c.a.b(parami, paramBoolean);
    AppMethodBeat.o(61096);
    return parami;
  }
  
  public final l a(g paramg, int paramInt)
  {
    AppMethodBeat.i(61114);
    d.g.b.k.h(paramg, "$this$getArgument");
    paramg = c.a.b(paramg, paramInt);
    AppMethodBeat.o(61114);
    return paramg;
  }
  
  public final l a(d.l.b.a.b.m.c.k paramk, int paramInt)
  {
    AppMethodBeat.i(61143);
    d.g.b.k.h(paramk, "$this$get");
    paramk = c.a.a(this, paramk, paramInt);
    AppMethodBeat.o(61143);
    return paramk;
  }
  
  public final n a(m paramm)
  {
    AppMethodBeat.i(61135);
    d.g.b.k.h(paramm, "$this$getTypeParameterClassifier");
    paramm = c.a.y(paramm);
    AppMethodBeat.o(61135);
    return paramm;
  }
  
  public final n a(m paramm, int paramInt)
  {
    AppMethodBeat.i(61120);
    d.g.b.k.h(paramm, "$this$getParameter");
    paramm = c.a.b(paramm, paramInt);
    AppMethodBeat.o(61120);
    return paramm;
  }
  
  public final boolean a(g paramg, d.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(61134);
    d.g.b.k.h(paramg, "$this$hasAnnotation");
    d.g.b.k.h(paramb, "fqName");
    boolean bool = c.a.b(paramg, paramb);
    AppMethodBeat.o(61134);
    return bool;
  }
  
  public final boolean a(l paraml)
  {
    AppMethodBeat.i(61115);
    d.g.b.k.h(paraml, "$this$isStarProjection");
    boolean bool = c.a.d(paraml);
    AppMethodBeat.o(61115);
    return bool;
  }
  
  public final i b(f paramf)
  {
    AppMethodBeat.i(61105);
    d.g.b.k.h(paramf, "$this$upperBound");
    paramf = c.a.e(paramf);
    AppMethodBeat.o(61105);
    return paramf;
  }
  
  public final d.l.b.a.b.m.c.s b(l paraml)
  {
    AppMethodBeat.i(61116);
    d.g.b.k.h(paraml, "$this$getVariance");
    paraml = c.a.e(paraml);
    AppMethodBeat.o(61116);
    return paraml;
  }
  
  public final d.l.b.a.b.m.c.s b(n paramn)
  {
    AppMethodBeat.i(61117);
    d.g.b.k.h(paramn, "$this$getVariance");
    paramn = c.a.c(paramn);
    AppMethodBeat.o(61117);
    return paramn;
  }
  
  public final boolean b(i parami1, i parami2)
  {
    AppMethodBeat.i(61101);
    d.g.b.k.h(parami1, "a");
    d.g.b.k.h(parami2, "b");
    boolean bool = c.a.c(parami1, parami2);
    AppMethodBeat.o(61101);
    return bool;
  }
  
  public final boolean b(m paramm)
  {
    AppMethodBeat.i(61136);
    d.g.b.k.h(paramm, "$this$isInlineClass");
    boolean bool = c.a.z(paramm);
    AppMethodBeat.o(61136);
    return bool;
  }
  
  public final boolean b(m paramm1, m paramm2)
  {
    AppMethodBeat.i(61122);
    d.g.b.k.h(paramm1, "c1");
    d.g.b.k.h(paramm2, "c2");
    boolean bool = c.a.c(paramm1, paramm2);
    AppMethodBeat.o(61122);
    return bool;
  }
  
  public final h c(m paramm)
  {
    AppMethodBeat.i(61139);
    d.g.b.k.h(paramm, "$this$getPrimitiveType");
    paramm = c.a.A(paramm);
    AppMethodBeat.o(61139);
    return paramm;
  }
  
  public final g c(l paraml)
  {
    AppMethodBeat.i(61118);
    d.g.b.k.h(paraml, "$this$getType");
    paraml = c.a.f(paraml);
    AppMethodBeat.o(61118);
    return paraml;
  }
  
  public final i c(f paramf)
  {
    AppMethodBeat.i(61106);
    d.g.b.k.h(paramf, "$this$lowerBound");
    paramf = c.a.f(paramf);
    AppMethodBeat.o(61106);
    return paramf;
  }
  
  public final h d(m paramm)
  {
    AppMethodBeat.i(61140);
    d.g.b.k.h(paramm, "$this$getPrimitiveArrayType");
    paramm = c.a.B(paramm);
    AppMethodBeat.o(61140);
    return paramm;
  }
  
  public final m d(g paramg)
  {
    AppMethodBeat.i(61112);
    d.g.b.k.h(paramg, "$this$typeConstructor");
    paramg = c.a.b(this, paramg);
    AppMethodBeat.o(61112);
    return paramg;
  }
  
  public final Collection<g> d(i parami)
  {
    AppMethodBeat.i(61095);
    d.g.b.k.h(parami, "$this$possibleIntegerTypes");
    parami = c.a.a(this, parami);
    AppMethodBeat.o(61095);
    return parami;
  }
  
  public final i e(g paramg)
  {
    AppMethodBeat.i(61144);
    d.g.b.k.h(paramg, "$this$lowerBoundIfFlexible");
    paramg = c.a.c(this, paramg);
    AppMethodBeat.o(61144);
    return paramg;
  }
  
  public final boolean e(i parami)
  {
    AppMethodBeat.i(61098);
    d.g.b.k.h(parami, "$this$isStubType");
    boolean bool = c.a.m(parami);
    AppMethodBeat.o(61098);
    return bool;
  }
  
  public final boolean e(m paramm)
  {
    AppMethodBeat.i(61141);
    d.g.b.k.h(paramm, "$this$isUnderKotlinPackage");
    boolean bool = c.a.C(paramm);
    AppMethodBeat.o(61141);
    return bool;
  }
  
  public final d.l.b.a.b.f.c f(m paramm)
  {
    AppMethodBeat.i(61142);
    d.g.b.k.h(paramm, "$this$getClassFqNameUnsafe");
    paramm = c.a.D(paramm);
    AppMethodBeat.o(61142);
    return paramm;
  }
  
  public final d.l.b.a.b.m.c.c f(i parami)
  {
    AppMethodBeat.i(61107);
    d.g.b.k.h(parami, "$this$asCapturedType");
    parami = c.a.n(parami);
    AppMethodBeat.o(61107);
    return parami;
  }
  
  public final i f(g paramg)
  {
    AppMethodBeat.i(61146);
    d.g.b.k.h(paramg, "$this$upperBoundIfFlexible");
    paramg = c.a.d(this, paramg);
    AppMethodBeat.o(61146);
    return paramg;
  }
  
  public final d g(i parami)
  {
    AppMethodBeat.i(61108);
    d.g.b.k.h(parami, "$this$asDefinitelyNotNullType");
    parami = c.a.o(parami);
    AppMethodBeat.o(61108);
    return parami;
  }
  
  public final boolean g(m paramm)
  {
    AppMethodBeat.i(61093);
    d.g.b.k.h(paramm, "$this$isDenotable");
    boolean bool = c.a.p(paramm);
    AppMethodBeat.o(61093);
    return bool;
  }
  
  public final boolean h(i parami)
  {
    AppMethodBeat.i(61109);
    d.g.b.k.h(parami, "$this$isMarkedNullable");
    boolean bool = c.a.p(parami);
    AppMethodBeat.o(61109);
    return bool;
  }
  
  public final boolean h(m paramm)
  {
    AppMethodBeat.i(61094);
    d.g.b.k.h(paramm, "$this$isIntegerLiteralTypeConstructor");
    boolean bool = c.a.q(paramm);
    AppMethodBeat.o(61094);
    return bool;
  }
  
  public final m i(i parami)
  {
    AppMethodBeat.i(61111);
    d.g.b.k.h(parami, "$this$typeConstructor");
    parami = c.a.q(parami);
    AppMethodBeat.o(61111);
    return parami;
  }
  
  public final boolean i(m paramm)
  {
    AppMethodBeat.i(61100);
    d.g.b.k.h(paramm, "$this$isIntersection");
    boolean bool = c.a.r(paramm);
    AppMethodBeat.o(61100);
    return bool;
  }
  
  public final g iQ(List<? extends g> paramList)
  {
    AppMethodBeat.i(61131);
    d.g.b.k.h(paramList, "types");
    paramList = c.a.iR(paramList);
    AppMethodBeat.o(61131);
    return paramList;
  }
  
  public final int j(m paramm)
  {
    AppMethodBeat.i(61119);
    d.g.b.k.h(paramm, "$this$parametersCount");
    int i = c.a.s(paramm);
    AppMethodBeat.o(61119);
    return i;
  }
  
  public final d.l.b.a.b.m.c.k j(i parami)
  {
    AppMethodBeat.i(61125);
    d.g.b.k.h(parami, "$this$asArgumentList");
    parami = c.a.r(parami);
    AppMethodBeat.o(61125);
    return parami;
  }
  
  public final g k(g paramg)
  {
    AppMethodBeat.i(61138);
    d.g.b.k.h(paramg, "$this$getSubstitutedUnderlyingType");
    paramg = c.a.z(paramg);
    AppMethodBeat.o(61138);
    return paramg;
  }
  
  public final Collection<g> k(m paramm)
  {
    AppMethodBeat.i(61121);
    d.g.b.k.h(paramm, "$this$supertypes");
    paramm = c.a.t(paramm);
    AppMethodBeat.o(61121);
    return paramm;
  }
  
  public final boolean k(i parami)
  {
    AppMethodBeat.i(61130);
    d.g.b.k.h(parami, "$this$isSingleClassifierType");
    boolean bool = c.a.s(parami);
    AppMethodBeat.o(61130);
    return bool;
  }
  
  public final boolean l(g paramg)
  {
    AppMethodBeat.i(61110);
    d.g.b.k.h(paramg, "$this$isMarkedNullable");
    boolean bool = c.a.a(this, paramg);
    AppMethodBeat.o(61110);
    return bool;
  }
  
  public final boolean l(i parami)
  {
    AppMethodBeat.i(61133);
    d.g.b.k.h(parami, "$this$isPrimitiveType");
    boolean bool = c.a.t(parami);
    AppMethodBeat.o(61133);
    return bool;
  }
  
  public final boolean l(m paramm)
  {
    AppMethodBeat.i(61123);
    d.g.b.k.h(paramm, "$this$isClassTypeConstructor");
    boolean bool = c.a.u(paramm);
    AppMethodBeat.o(61123);
    return bool;
  }
  
  public final g m(g paramg)
  {
    AppMethodBeat.i(61147);
    d.g.b.k.h(paramg, "$this$makeNullable");
    paramg = c.a.e(this, paramg);
    AppMethodBeat.o(61147);
    return paramg;
  }
  
  public final boolean m(m paramm)
  {
    AppMethodBeat.i(61124);
    d.g.b.k.h(paramm, "$this$isCommonFinalClassConstructor");
    boolean bool = c.a.v(paramm);
    AppMethodBeat.o(61124);
    return bool;
  }
  
  public final boolean n(g paramg)
  {
    AppMethodBeat.i(61097);
    d.g.b.k.h(paramg, "$this$isError");
    boolean bool = c.a.t(paramg);
    AppMethodBeat.o(61097);
    return bool;
  }
  
  public final boolean n(m paramm)
  {
    AppMethodBeat.i(61127);
    d.g.b.k.h(paramm, "$this$isAnyConstructor");
    boolean bool = c.a.w(paramm);
    AppMethodBeat.o(61127);
    return bool;
  }
  
  public final i o(g paramg)
  {
    AppMethodBeat.i(61102);
    d.g.b.k.h(paramg, "$this$asSimpleType");
    paramg = c.a.u(paramg);
    AppMethodBeat.o(61102);
    return paramg;
  }
  
  public final boolean o(m paramm)
  {
    AppMethodBeat.i(61128);
    d.g.b.k.h(paramm, "$this$isNothingConstructor");
    boolean bool = c.a.x(paramm);
    AppMethodBeat.o(61128);
    return bool;
  }
  
  public final f p(g paramg)
  {
    AppMethodBeat.i(61103);
    d.g.b.k.h(paramg, "$this$asFlexibleType");
    paramg = c.a.v(paramg);
    AppMethodBeat.o(61103);
    return paramg;
  }
  
  public final int q(g paramg)
  {
    AppMethodBeat.i(61113);
    d.g.b.k.h(paramg, "$this$argumentsCount");
    int i = c.a.w(paramg);
    AppMethodBeat.o(61113);
    return i;
  }
  
  public final l r(g paramg)
  {
    AppMethodBeat.i(61129);
    d.g.b.k.h(paramg, "$this$asTypeArgument");
    paramg = c.a.x(paramg);
    AppMethodBeat.o(61129);
    return paramg;
  }
  
  public final boolean s(g paramg)
  {
    AppMethodBeat.i(61132);
    d.g.b.k.h(paramg, "$this$isNullableType");
    boolean bool = c.a.y(paramg);
    AppMethodBeat.o(61132);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.a.s
 * JD-Core Version:    0.7.0.1
 */