package d.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.w;
import d.l.b.a.b.a.g.a;
import d.l.b.a.b.b.ar;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.x;
import d.l.b.a.b.m.aa;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.ad;
import d.l.b.a.b.m.aj;
import d.l.b.a.b.m.aq;
import d.l.b.a.b.m.at;
import d.l.b.a.b.m.av;
import d.l.b.a.b.m.bb;
import d.l.b.a.b.m.bb.a;
import d.l.b.a.b.m.bc;
import d.l.b.a.b.m.bg;
import d.l.b.a.b.m.c.i;
import d.l.b.a.b.m.c.q;
import d.l.b.a.b.m.c.q.a;
import d.l.b.a.b.m.c.s;
import d.l.b.a.b.m.r;
import java.util.Collection;
import java.util.List;

public abstract interface c
  extends bb, q
{
  public abstract d.l.b.a.b.m.c.m i(i parami);
  
  public abstract i o(d.l.b.a.b.m.c.g paramg);
  
  public static final class a
  {
    public static d.l.b.a.b.a.h A(d.l.b.a.b.m.c.m paramm)
    {
      AppMethodBeat.i(61032);
      d.g.b.k.h(paramm, "$this$getPrimitiveType");
      if (!(paramm instanceof at))
      {
        paramm = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramm + ", " + w.bn(paramm.getClass())).toString());
        AppMethodBeat.o(61032);
        throw paramm;
      }
      paramm = ((at)paramm).fQq();
      if (paramm == null)
      {
        paramm = new d.v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        AppMethodBeat.o(61032);
        throw paramm;
      }
      paramm = d.l.b.a.b.a.g.e((d.l.b.a.b.b.l)paramm);
      AppMethodBeat.o(61032);
      return paramm;
    }
    
    public static d.l.b.a.b.a.h B(d.l.b.a.b.m.c.m paramm)
    {
      AppMethodBeat.i(61033);
      d.g.b.k.h(paramm, "$this$getPrimitiveArrayType");
      if (!(paramm instanceof at))
      {
        paramm = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramm + ", " + w.bn(paramm.getClass())).toString());
        AppMethodBeat.o(61033);
        throw paramm;
      }
      paramm = ((at)paramm).fQq();
      if (paramm == null)
      {
        paramm = new d.v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        AppMethodBeat.o(61033);
        throw paramm;
      }
      paramm = d.l.b.a.b.a.g.f((d.l.b.a.b.b.l)paramm);
      AppMethodBeat.o(61033);
      return paramm;
    }
    
    public static boolean C(d.l.b.a.b.m.c.m paramm)
    {
      AppMethodBeat.i(61034);
      d.g.b.k.h(paramm, "$this$isUnderKotlinPackage");
      if (!(paramm instanceof at))
      {
        paramm = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramm + ", " + w.bn(paramm.getClass())).toString());
        AppMethodBeat.o(61034);
        throw paramm;
      }
      paramm = ((at)paramm).fQq();
      if ((paramm != null) && (d.l.b.a.b.a.g.d((d.l.b.a.b.b.l)paramm) == true))
      {
        AppMethodBeat.o(61034);
        return true;
      }
      AppMethodBeat.o(61034);
      return false;
    }
    
    public static d.l.b.a.b.f.c D(d.l.b.a.b.m.c.m paramm)
    {
      AppMethodBeat.i(61035);
      d.g.b.k.h(paramm, "$this$getClassFqNameUnsafe");
      if (!(paramm instanceof at))
      {
        paramm = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramm + ", " + w.bn(paramm.getClass())).toString());
        AppMethodBeat.o(61035);
        throw paramm;
      }
      paramm = ((at)paramm).fQq();
      if (paramm == null)
      {
        paramm = new d.v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        AppMethodBeat.o(61035);
        throw paramm;
      }
      paramm = d.l.b.a.b.j.d.a.q((d.l.b.a.b.b.l)paramm);
      AppMethodBeat.o(61035);
      return paramm;
    }
    
    public static int a(c paramc, d.l.b.a.b.m.c.k paramk)
    {
      AppMethodBeat.i(61040);
      d.g.b.k.h(paramk, "$this$size");
      int i = q.a.a((q)paramc, paramk);
      AppMethodBeat.o(61040);
      return i;
    }
    
    public static d.l.b.a.b.m.c.l a(c paramc, d.l.b.a.b.m.c.k paramk, int paramInt)
    {
      AppMethodBeat.i(61038);
      d.g.b.k.h(paramk, "$this$get");
      paramc = q.a.a((q)paramc, paramk, paramInt);
      AppMethodBeat.o(61038);
      return paramc;
    }
    
    public static Collection<d.l.b.a.b.m.c.g> a(c paramc, i parami)
    {
      AppMethodBeat.i(60990);
      d.g.b.k.h(parami, "$this$possibleIntegerTypes");
      paramc = paramc.i(parami);
      if (!(paramc instanceof d.l.b.a.b.j.b.n))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + parami + ", " + w.bn(parami.getClass())).toString());
        AppMethodBeat.o(60990);
        throw paramc;
      }
      paramc = (Collection)((d.l.b.a.b.j.b.n)paramc).LFA;
      AppMethodBeat.o(60990);
      return paramc;
    }
    
    public static boolean a(c paramc, d.l.b.a.b.m.c.g paramg)
    {
      AppMethodBeat.i(61036);
      d.g.b.k.h(paramg, "$this$isMarkedNullable");
      boolean bool = bb.a.b((bb)paramc, paramg);
      AppMethodBeat.o(61036);
      return bool;
    }
    
    public static d.l.b.a.b.m.c.g b(d.l.b.a.b.m.c.c paramc)
    {
      AppMethodBeat.i(60994);
      d.g.b.k.h(paramc, "$this$lowerType");
      if (!(paramc instanceof k))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramc + ", " + w.bn(paramc.getClass())).toString());
        AppMethodBeat.o(60994);
        throw paramc;
      }
      paramc = (d.l.b.a.b.m.c.g)((k)paramc).LMn;
      AppMethodBeat.o(60994);
      return paramc;
    }
    
    public static i b(i parami, d.l.b.a.b.m.c.b paramb)
    {
      AppMethodBeat.i(61019);
      d.g.b.k.h(parami, "type");
      d.g.b.k.h(paramb, "status");
      if (!(parami instanceof aj))
      {
        parami = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + parami + ", " + w.bn(parami.getClass())).toString());
        AppMethodBeat.o(61019);
        throw parami;
      }
      parami = (i)m.a((aj)parami, paramb);
      AppMethodBeat.o(61019);
      return parami;
    }
    
    public static i b(i parami, boolean paramBoolean)
    {
      AppMethodBeat.i(60991);
      d.g.b.k.h(parami, "$this$withNullability");
      if (!(parami instanceof aj))
      {
        parami = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + parami + ", " + w.bn(parami.getClass())).toString());
        AppMethodBeat.o(60991);
        throw parami;
      }
      parami = (i)((aj)parami).zo(paramBoolean);
      AppMethodBeat.o(60991);
      return parami;
    }
    
    public static d.l.b.a.b.m.c.l b(d.l.b.a.b.m.c.g paramg, int paramInt)
    {
      AppMethodBeat.i(61007);
      d.g.b.k.h(paramg, "$this$getArgument");
      if (!(paramg instanceof ab))
      {
        paramg = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramg + ", " + w.bn(paramg.getClass())).toString());
        AppMethodBeat.o(61007);
        throw paramg;
      }
      paramg = (d.l.b.a.b.m.c.l)((ab)paramg).gbw().get(paramInt);
      AppMethodBeat.o(61007);
      return paramg;
    }
    
    public static d.l.b.a.b.m.c.m b(c paramc, d.l.b.a.b.m.c.g paramg)
    {
      AppMethodBeat.i(61037);
      d.g.b.k.h(paramg, "$this$typeConstructor");
      paramc = q.a.a((q)paramc, paramg);
      AppMethodBeat.o(61037);
      return paramc;
    }
    
    public static d.l.b.a.b.m.c.n b(d.l.b.a.b.m.c.m paramm, int paramInt)
    {
      AppMethodBeat.i(61012);
      d.g.b.k.h(paramm, "$this$getParameter");
      if (!(paramm instanceof at))
      {
        paramm = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramm + ", " + w.bn(paramm.getClass())).toString());
        AppMethodBeat.o(61012);
        throw paramm;
      }
      paramm = ((at)paramm).getParameters().get(paramInt);
      d.g.b.k.g(paramm, "this.parameters[index]");
      paramm = (d.l.b.a.b.m.c.n)paramm;
      AppMethodBeat.o(61012);
      return paramm;
    }
    
    public static boolean b(d.l.b.a.b.m.c.g paramg, d.l.b.a.b.f.b paramb)
    {
      AppMethodBeat.i(61027);
      d.g.b.k.h(paramg, "$this$hasAnnotation");
      d.g.b.k.h(paramb, "fqName");
      if (!(paramg instanceof ab))
      {
        paramg = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramg + ", " + w.bn(paramg.getClass())).toString());
        AppMethodBeat.o(61027);
        throw paramg;
      }
      boolean bool = ((ab)paramg).fQj().h(paramb);
      AppMethodBeat.o(61027);
      return bool;
    }
    
    public static i c(c paramc, d.l.b.a.b.m.c.g paramg)
    {
      AppMethodBeat.i(61039);
      d.g.b.k.h(paramg, "$this$lowerBoundIfFlexible");
      paramc = q.a.b((q)paramc, paramg);
      AppMethodBeat.o(61039);
      return paramc;
    }
    
    public static s c(d.l.b.a.b.m.c.n paramn)
    {
      AppMethodBeat.i(61014);
      d.g.b.k.h(paramn, "$this$getVariance");
      if (!(paramn instanceof as))
      {
        paramn = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramn + ", " + w.bn(paramn.getClass())).toString());
        AppMethodBeat.o(61014);
        throw paramn;
      }
      paramn = ((as)paramn).fRg();
      d.g.b.k.g(paramn, "this.variance");
      paramn = d.a(paramn);
      AppMethodBeat.o(61014);
      return paramn;
    }
    
    public static boolean c(i parami1, i parami2)
    {
      AppMethodBeat.i(60996);
      d.g.b.k.h(parami1, "a");
      d.g.b.k.h(parami2, "b");
      if (!(parami1 instanceof aj))
      {
        parami1 = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + parami1 + ", " + w.bn(parami1.getClass())).toString());
        AppMethodBeat.o(60996);
        throw parami1;
      }
      if (!(parami2 instanceof aj))
      {
        parami1 = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + parami2 + ", " + w.bn(parami2.getClass())).toString());
        AppMethodBeat.o(60996);
        throw parami1;
      }
      if (((aj)parami1).gbw() == ((aj)parami2).gbw())
      {
        AppMethodBeat.o(60996);
        return true;
      }
      AppMethodBeat.o(60996);
      return false;
    }
    
    public static boolean c(d.l.b.a.b.m.c.m paramm1, d.l.b.a.b.m.c.m paramm2)
    {
      AppMethodBeat.i(61015);
      d.g.b.k.h(paramm1, "c1");
      d.g.b.k.h(paramm2, "c2");
      if (!(paramm1 instanceof at))
      {
        paramm1 = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramm1 + ", " + w.bn(paramm1.getClass())).toString());
        AppMethodBeat.o(61015);
        throw paramm1;
      }
      if (!(paramm2 instanceof at))
      {
        paramm1 = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramm2 + ", " + w.bn(paramm2.getClass())).toString());
        AppMethodBeat.o(61015);
        throw paramm1;
      }
      boolean bool = d.g.b.k.g(paramm1, paramm2);
      AppMethodBeat.o(61015);
      return bool;
    }
    
    public static d.l.b.a.b.m.c.e d(d.l.b.a.b.m.c.f paramf)
    {
      AppMethodBeat.i(60999);
      d.g.b.k.h(paramf, "$this$asDynamicType");
      if (!(paramf instanceof d.l.b.a.b.m.v))
      {
        paramf = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramf + ", " + w.bn(paramf.getClass())).toString());
        AppMethodBeat.o(60999);
        throw paramf;
      }
      if (!(paramf instanceof r)) {
        paramf = null;
      }
      for (;;)
      {
        paramf = (d.l.b.a.b.m.c.e)paramf;
        AppMethodBeat.o(60999);
        return paramf;
      }
    }
    
    public static d.l.b.a.b.m.c.g d(d.l.b.a.b.m.c.n paramn)
    {
      AppMethodBeat.i(61030);
      d.g.b.k.h(paramn, "$this$getRepresentativeUpperBound");
      if (!(paramn instanceof as))
      {
        paramn = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramn + ", " + w.bn(paramn.getClass())).toString());
        AppMethodBeat.o(61030);
        throw paramn;
      }
      paramn = (d.l.b.a.b.m.c.g)d.l.b.a.b.m.d.a.e((as)paramn);
      AppMethodBeat.o(61030);
      return paramn;
    }
    
    public static i d(c paramc, d.l.b.a.b.m.c.g paramg)
    {
      AppMethodBeat.i(61041);
      d.g.b.k.h(paramg, "$this$upperBoundIfFlexible");
      paramc = q.a.c((q)paramc, paramg);
      AppMethodBeat.o(61041);
      return paramc;
    }
    
    public static boolean d(d.l.b.a.b.m.c.l paraml)
    {
      AppMethodBeat.i(61008);
      d.g.b.k.h(paraml, "$this$isStarProjection");
      if (!(paraml instanceof av))
      {
        paraml = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paraml + ", " + w.bn(paraml.getClass())).toString());
        AppMethodBeat.o(61008);
        throw paraml;
      }
      boolean bool = ((av)paraml).gcB();
      AppMethodBeat.o(61008);
      return bool;
    }
    
    public static d.l.b.a.b.m.c.g e(c paramc, d.l.b.a.b.m.c.g paramg)
    {
      AppMethodBeat.i(61042);
      d.g.b.k.h(paramg, "$this$makeNullable");
      paramc = bb.a.c((bb)paramc, paramg);
      AppMethodBeat.o(61042);
      return paramc;
    }
    
    public static i e(d.l.b.a.b.m.c.f paramf)
    {
      AppMethodBeat.i(61000);
      d.g.b.k.h(paramf, "$this$upperBound");
      if (!(paramf instanceof d.l.b.a.b.m.v))
      {
        paramf = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramf + ", " + w.bn(paramf.getClass())).toString());
        AppMethodBeat.o(61000);
        throw paramf;
      }
      paramf = (i)((d.l.b.a.b.m.v)paramf).LLb;
      AppMethodBeat.o(61000);
      return paramf;
    }
    
    public static s e(d.l.b.a.b.m.c.l paraml)
    {
      AppMethodBeat.i(61009);
      d.g.b.k.h(paraml, "$this$getVariance");
      if (!(paraml instanceof av))
      {
        paraml = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paraml + ", " + w.bn(paraml.getClass())).toString());
        AppMethodBeat.o(61009);
        throw paraml;
      }
      paraml = ((av)paraml).gcC();
      d.g.b.k.g(paraml, "this.projectionKind");
      paraml = d.a(paraml);
      AppMethodBeat.o(61009);
      return paraml;
    }
    
    public static d.l.b.a.b.m.c.g f(d.l.b.a.b.m.c.l paraml)
    {
      AppMethodBeat.i(61010);
      d.g.b.k.h(paraml, "$this$getType");
      if (!(paraml instanceof av))
      {
        paraml = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paraml + ", " + w.bn(paraml.getClass())).toString());
        AppMethodBeat.o(61010);
        throw paraml;
      }
      paraml = (d.l.b.a.b.m.c.g)((av)paraml).fRV().gcz();
      AppMethodBeat.o(61010);
      return paraml;
    }
    
    public static i f(d.l.b.a.b.m.c.f paramf)
    {
      AppMethodBeat.i(61001);
      d.g.b.k.h(paramf, "$this$lowerBound");
      if (!(paramf instanceof d.l.b.a.b.m.v))
      {
        paramf = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramf + ", " + w.bn(paramf.getClass())).toString());
        AppMethodBeat.o(61001);
        throw paramf;
      }
      paramf = (i)((d.l.b.a.b.m.v)paramf).LLa;
      AppMethodBeat.o(61001);
      return paramf;
    }
    
    public static d.l.b.a.b.m.c.g jh(List<? extends d.l.b.a.b.m.c.g> paramList)
    {
      AppMethodBeat.i(61024);
      d.g.b.k.h(paramList, "types");
      paramList = (d.l.b.a.b.m.c.g)f.ji(paramList);
      AppMethodBeat.o(61024);
      return paramList;
    }
    
    public static boolean m(i parami)
    {
      AppMethodBeat.i(60993);
      d.g.b.k.h(parami, "$this$isStubType");
      if (!(parami instanceof aj))
      {
        parami = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + parami + ", " + w.bn(parami.getClass())).toString());
        AppMethodBeat.o(60993);
        throw parami;
      }
      boolean bool = parami instanceof aq;
      AppMethodBeat.o(60993);
      return bool;
    }
    
    public static d.l.b.a.b.m.c.c n(i parami)
    {
      AppMethodBeat.i(61002);
      d.g.b.k.h(parami, "$this$asCapturedType");
      if (!(parami instanceof aj))
      {
        parami = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + parami + ", " + w.bn(parami.getClass())).toString());
        AppMethodBeat.o(61002);
        throw parami;
      }
      if (!(parami instanceof k)) {
        parami = null;
      }
      for (;;)
      {
        parami = (d.l.b.a.b.m.c.c)parami;
        AppMethodBeat.o(61002);
        return parami;
      }
    }
    
    public static d.l.b.a.b.m.c.d o(i parami)
    {
      AppMethodBeat.i(61003);
      d.g.b.k.h(parami, "$this$asDefinitelyNotNullType");
      if (!(parami instanceof aj))
      {
        parami = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + parami + ", " + w.bn(parami.getClass())).toString());
        AppMethodBeat.o(61003);
        throw parami;
      }
      if (!(parami instanceof d.l.b.a.b.m.l)) {
        parami = null;
      }
      for (;;)
      {
        parami = (d.l.b.a.b.m.c.d)parami;
        AppMethodBeat.o(61003);
        return parami;
      }
    }
    
    public static boolean p(i parami)
    {
      AppMethodBeat.i(61004);
      d.g.b.k.h(parami, "$this$isMarkedNullable");
      if (!(parami instanceof aj))
      {
        parami = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + parami + ", " + w.bn(parami.getClass())).toString());
        AppMethodBeat.o(61004);
        throw parami;
      }
      boolean bool = ((aj)parami).fUx();
      AppMethodBeat.o(61004);
      return bool;
    }
    
    public static boolean p(d.l.b.a.b.m.c.m paramm)
    {
      AppMethodBeat.i(60988);
      d.g.b.k.h(paramm, "$this$isDenotable");
      if (!(paramm instanceof at))
      {
        paramm = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramm + ", " + w.bn(paramm.getClass())).toString());
        AppMethodBeat.o(60988);
        throw paramm;
      }
      boolean bool = ((at)paramm).fQs();
      AppMethodBeat.o(60988);
      return bool;
    }
    
    public static d.l.b.a.b.m.c.m q(i parami)
    {
      AppMethodBeat.i(61005);
      d.g.b.k.h(parami, "$this$typeConstructor");
      if (!(parami instanceof aj))
      {
        parami = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + parami + ", " + w.bn(parami.getClass())).toString());
        AppMethodBeat.o(61005);
        throw parami;
      }
      parami = (d.l.b.a.b.m.c.m)((aj)parami).gbz();
      AppMethodBeat.o(61005);
      return parami;
    }
    
    public static boolean q(d.l.b.a.b.m.c.m paramm)
    {
      AppMethodBeat.i(60989);
      d.g.b.k.h(paramm, "$this$isIntegerLiteralTypeConstructor");
      if (!(paramm instanceof at))
      {
        paramm = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramm + ", " + w.bn(paramm.getClass())).toString());
        AppMethodBeat.o(60989);
        throw paramm;
      }
      boolean bool = paramm instanceof d.l.b.a.b.j.b.n;
      AppMethodBeat.o(60989);
      return bool;
    }
    
    public static d.l.b.a.b.m.c.k r(i parami)
    {
      AppMethodBeat.i(61018);
      d.g.b.k.h(parami, "$this$asArgumentList");
      if (!(parami instanceof aj))
      {
        parami = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + parami + ", " + w.bn(parami.getClass())).toString());
        AppMethodBeat.o(61018);
        throw parami;
      }
      parami = (d.l.b.a.b.m.c.k)parami;
      AppMethodBeat.o(61018);
      return parami;
    }
    
    public static boolean r(d.l.b.a.b.m.c.m paramm)
    {
      AppMethodBeat.i(60995);
      d.g.b.k.h(paramm, "$this$isIntersection");
      if (!(paramm instanceof at))
      {
        paramm = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramm + ", " + w.bn(paramm.getClass())).toString());
        AppMethodBeat.o(60995);
        throw paramm;
      }
      boolean bool = paramm instanceof aa;
      AppMethodBeat.o(60995);
      return bool;
    }
    
    public static int s(d.l.b.a.b.m.c.m paramm)
    {
      AppMethodBeat.i(61011);
      d.g.b.k.h(paramm, "$this$parametersCount");
      if (!(paramm instanceof at))
      {
        paramm = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramm + ", " + w.bn(paramm.getClass())).toString());
        AppMethodBeat.o(61011);
        throw paramm;
      }
      int i = ((at)paramm).getParameters().size();
      AppMethodBeat.o(61011);
      return i;
    }
    
    public static boolean s(i parami)
    {
      AppMethodBeat.i(61023);
      d.g.b.k.h(parami, "$this$isSingleClassifierType");
      if (!(parami instanceof aj))
      {
        parami = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + parami + ", " + w.bn(parami.getClass())).toString());
        AppMethodBeat.o(61023);
        throw parami;
      }
      if ((!ad.aq((ab)parami)) && (!(((aj)parami).gbz().fQq() instanceof ar)) && ((((aj)parami).gbz().fQq() != null) || ((parami instanceof d.l.b.a.b.j.a.a.a)) || ((parami instanceof k)) || ((parami instanceof d.l.b.a.b.m.l)) || ((((aj)parami).gbz() instanceof d.l.b.a.b.j.b.n))))
      {
        AppMethodBeat.o(61023);
        return true;
      }
      AppMethodBeat.o(61023);
      return false;
    }
    
    public static Collection<d.l.b.a.b.m.c.g> t(d.l.b.a.b.m.c.m paramm)
    {
      AppMethodBeat.i(61013);
      d.g.b.k.h(paramm, "$this$supertypes");
      if (!(paramm instanceof at))
      {
        paramm = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramm + ", " + w.bn(paramm.getClass())).toString());
        AppMethodBeat.o(61013);
        throw paramm;
      }
      paramm = ((at)paramm).fSt();
      d.g.b.k.g(paramm, "this.supertypes");
      AppMethodBeat.o(61013);
      return paramm;
    }
    
    public static boolean t(d.l.b.a.b.m.c.g paramg)
    {
      AppMethodBeat.i(60992);
      d.g.b.k.h(paramg, "$this$isError");
      if (!(paramg instanceof ab))
      {
        paramg = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramg + ", " + w.bn(paramg.getClass())).toString());
        AppMethodBeat.o(60992);
        throw paramg;
      }
      boolean bool = ad.aq((ab)paramg);
      AppMethodBeat.o(60992);
      return bool;
    }
    
    public static boolean t(i parami)
    {
      AppMethodBeat.i(61026);
      d.g.b.k.h(parami, "$this$isPrimitiveType");
      if (!(parami instanceof ab))
      {
        parami = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + parami + ", " + w.bn(parami.getClass())).toString());
        AppMethodBeat.o(61026);
        throw parami;
      }
      boolean bool = d.l.b.a.b.a.g.o((ab)parami);
      AppMethodBeat.o(61026);
      return bool;
    }
    
    public static i u(d.l.b.a.b.m.c.g paramg)
    {
      AppMethodBeat.i(60997);
      d.g.b.k.h(paramg, "$this$asSimpleType");
      if (!(paramg instanceof ab))
      {
        paramg = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramg + ", " + w.bn(paramg.getClass())).toString());
        AppMethodBeat.o(60997);
        throw paramg;
      }
      bg localbg = ((ab)paramg).gcz();
      paramg = localbg;
      if (!(localbg instanceof aj)) {
        paramg = null;
      }
      paramg = (i)paramg;
      AppMethodBeat.o(60997);
      return paramg;
    }
    
    public static boolean u(d.l.b.a.b.m.c.m paramm)
    {
      AppMethodBeat.i(61016);
      d.g.b.k.h(paramm, "$this$isClassTypeConstructor");
      if (!(paramm instanceof at))
      {
        paramm = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramm + ", " + w.bn(paramm.getClass())).toString());
        AppMethodBeat.o(61016);
        throw paramm;
      }
      boolean bool = ((at)paramm).fQq() instanceof d.l.b.a.b.b.e;
      AppMethodBeat.o(61016);
      return bool;
    }
    
    public static d.l.b.a.b.m.c.f v(d.l.b.a.b.m.c.g paramg)
    {
      AppMethodBeat.i(60998);
      d.g.b.k.h(paramg, "$this$asFlexibleType");
      if (!(paramg instanceof ab))
      {
        paramg = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramg + ", " + w.bn(paramg.getClass())).toString());
        AppMethodBeat.o(60998);
        throw paramg;
      }
      bg localbg = ((ab)paramg).gcz();
      paramg = localbg;
      if (!(localbg instanceof d.l.b.a.b.m.v)) {
        paramg = null;
      }
      paramg = (d.l.b.a.b.m.c.f)paramg;
      AppMethodBeat.o(60998);
      return paramg;
    }
    
    public static boolean v(d.l.b.a.b.m.c.m paramm)
    {
      AppMethodBeat.i(61017);
      d.g.b.k.h(paramm, "$this$isCommonFinalClassConstructor");
      if (!(paramm instanceof at))
      {
        paramm = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramm + ", " + w.bn(paramm.getClass())).toString());
        AppMethodBeat.o(61017);
        throw paramm;
      }
      d.l.b.a.b.b.h localh = ((at)paramm).fQq();
      paramm = localh;
      if (!(localh instanceof d.l.b.a.b.b.e)) {
        paramm = null;
      }
      paramm = (d.l.b.a.b.b.e)paramm;
      if (paramm == null)
      {
        AppMethodBeat.o(61017);
        return false;
      }
      if ((x.p(paramm)) && (paramm.fPY() != d.l.b.a.b.b.f.Ldz) && (paramm.fPY() != d.l.b.a.b.b.f.LdA))
      {
        AppMethodBeat.o(61017);
        return true;
      }
      AppMethodBeat.o(61017);
      return false;
    }
    
    public static int w(d.l.b.a.b.m.c.g paramg)
    {
      AppMethodBeat.i(61006);
      d.g.b.k.h(paramg, "$this$argumentsCount");
      if (!(paramg instanceof ab))
      {
        paramg = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramg + ", " + w.bn(paramg.getClass())).toString());
        AppMethodBeat.o(61006);
        throw paramg;
      }
      int i = ((ab)paramg).gbw().size();
      AppMethodBeat.o(61006);
      return i;
    }
    
    public static boolean w(d.l.b.a.b.m.c.m paramm)
    {
      AppMethodBeat.i(61020);
      d.g.b.k.h(paramm, "$this$isAnyConstructor");
      if (!(paramm instanceof at))
      {
        paramm = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramm + ", " + w.bn(paramm.getClass())).toString());
        AppMethodBeat.o(61020);
        throw paramm;
      }
      boolean bool = d.l.b.a.b.a.g.a((at)paramm, d.l.b.a.b.a.g.KZg.KZk);
      AppMethodBeat.o(61020);
      return bool;
    }
    
    public static d.l.b.a.b.m.c.l x(d.l.b.a.b.m.c.g paramg)
    {
      AppMethodBeat.i(61022);
      d.g.b.k.h(paramg, "$this$asTypeArgument");
      if (!(paramg instanceof ab))
      {
        paramg = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramg + ", " + w.bn(paramg.getClass())).toString());
        AppMethodBeat.o(61022);
        throw paramg;
      }
      paramg = (d.l.b.a.b.m.c.l)d.l.b.a.b.m.d.a.aO((ab)paramg);
      AppMethodBeat.o(61022);
      return paramg;
    }
    
    public static boolean x(d.l.b.a.b.m.c.m paramm)
    {
      AppMethodBeat.i(61021);
      d.g.b.k.h(paramm, "$this$isNothingConstructor");
      if (!(paramm instanceof at))
      {
        paramm = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramm + ", " + w.bn(paramm.getClass())).toString());
        AppMethodBeat.o(61021);
        throw paramm;
      }
      boolean bool = d.l.b.a.b.a.g.a((at)paramm, d.l.b.a.b.a.g.KZg.KZl);
      AppMethodBeat.o(61021);
      return bool;
    }
    
    public static d.l.b.a.b.m.c.n y(d.l.b.a.b.m.c.m paramm)
    {
      AppMethodBeat.i(61028);
      d.g.b.k.h(paramm, "$this$getTypeParameterClassifier");
      if (!(paramm instanceof at))
      {
        paramm = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramm + ", " + w.bn(paramm.getClass())).toString());
        AppMethodBeat.o(61028);
        throw paramm;
      }
      d.l.b.a.b.b.h localh = ((at)paramm).fQq();
      paramm = localh;
      if (!(localh instanceof as)) {
        paramm = null;
      }
      paramm = (d.l.b.a.b.m.c.n)paramm;
      AppMethodBeat.o(61028);
      return paramm;
    }
    
    public static boolean y(d.l.b.a.b.m.c.g paramg)
    {
      AppMethodBeat.i(61025);
      d.g.b.k.h(paramg, "$this$isNullableType");
      if (!(paramg instanceof ab))
      {
        paramg = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramg + ", " + w.bn(paramg.getClass())).toString());
        AppMethodBeat.o(61025);
        throw paramg;
      }
      boolean bool = bc.aF((ab)paramg);
      AppMethodBeat.o(61025);
      return bool;
    }
    
    public static d.l.b.a.b.m.c.g z(d.l.b.a.b.m.c.g paramg)
    {
      AppMethodBeat.i(61031);
      d.g.b.k.h(paramg, "$this$getSubstitutedUnderlyingType");
      if (!(paramg instanceof ab))
      {
        paramg = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramg + ", " + w.bn(paramg.getClass())).toString());
        AppMethodBeat.o(61031);
        throw paramg;
      }
      paramg = (d.l.b.a.b.m.c.g)d.l.b.a.b.j.e.ac((ab)paramg);
      AppMethodBeat.o(61031);
      return paramg;
    }
    
    public static boolean z(d.l.b.a.b.m.c.m paramm)
    {
      AppMethodBeat.i(61029);
      d.g.b.k.h(paramm, "$this$isInlineClass");
      if (!(paramm instanceof at))
      {
        paramm = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramm + ", " + w.bn(paramm.getClass())).toString());
        AppMethodBeat.o(61029);
        throw paramm;
      }
      d.l.b.a.b.b.h localh = ((at)paramm).fQq();
      paramm = localh;
      if (!(localh instanceof d.l.b.a.b.b.e)) {
        paramm = null;
      }
      paramm = (d.l.b.a.b.b.e)paramm;
      if ((paramm != null) && (paramm.fQf() == true))
      {
        AppMethodBeat.o(61029);
        return true;
      }
      AppMethodBeat.o(61029);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.a.c
 * JD-Core Version:    0.7.0.1
 */