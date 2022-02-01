package d.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.g.b.z;
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
import d.l.b.a.b.m.c.j;
import d.l.b.a.b.m.c.o;
import d.l.b.a.b.m.c.r.a;
import d.l.b.a.b.m.c.t;
import java.util.Collection;
import java.util.List;

public abstract interface c
  extends bb, d.l.b.a.b.m.c.r
{
  public abstract d.l.b.a.b.m.c.n i(j paramj);
  
  public abstract j o(d.l.b.a.b.m.c.h paramh);
  
  public static final class a
  {
    public static d.l.b.a.b.a.h A(d.l.b.a.b.m.c.n paramn)
    {
      AppMethodBeat.i(61032);
      p.h(paramn, "$this$getPrimitiveType");
      if (!(paramn instanceof at))
      {
        paramn = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramn + ", " + z.bp(paramn.getClass())).toString());
        AppMethodBeat.o(61032);
        throw paramn;
      }
      paramn = ((at)paramn).gmq();
      if (paramn == null)
      {
        paramn = new d.v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        AppMethodBeat.o(61032);
        throw paramn;
      }
      paramn = d.l.b.a.b.a.g.e((d.l.b.a.b.b.l)paramn);
      AppMethodBeat.o(61032);
      return paramn;
    }
    
    public static d.l.b.a.b.a.h B(d.l.b.a.b.m.c.n paramn)
    {
      AppMethodBeat.i(61033);
      p.h(paramn, "$this$getPrimitiveArrayType");
      if (!(paramn instanceof at))
      {
        paramn = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramn + ", " + z.bp(paramn.getClass())).toString());
        AppMethodBeat.o(61033);
        throw paramn;
      }
      paramn = ((at)paramn).gmq();
      if (paramn == null)
      {
        paramn = new d.v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        AppMethodBeat.o(61033);
        throw paramn;
      }
      paramn = d.l.b.a.b.a.g.f((d.l.b.a.b.b.l)paramn);
      AppMethodBeat.o(61033);
      return paramn;
    }
    
    public static boolean C(d.l.b.a.b.m.c.n paramn)
    {
      AppMethodBeat.i(61034);
      p.h(paramn, "$this$isUnderKotlinPackage");
      if (!(paramn instanceof at))
      {
        paramn = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramn + ", " + z.bp(paramn.getClass())).toString());
        AppMethodBeat.o(61034);
        throw paramn;
      }
      paramn = ((at)paramn).gmq();
      if ((paramn != null) && (d.l.b.a.b.a.g.d((d.l.b.a.b.b.l)paramn) == true))
      {
        AppMethodBeat.o(61034);
        return true;
      }
      AppMethodBeat.o(61034);
      return false;
    }
    
    public static d.l.b.a.b.f.c D(d.l.b.a.b.m.c.n paramn)
    {
      AppMethodBeat.i(61035);
      p.h(paramn, "$this$getClassFqNameUnsafe");
      if (!(paramn instanceof at))
      {
        paramn = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramn + ", " + z.bp(paramn.getClass())).toString());
        AppMethodBeat.o(61035);
        throw paramn;
      }
      paramn = ((at)paramn).gmq();
      if (paramn == null)
      {
        paramn = new d.v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        AppMethodBeat.o(61035);
        throw paramn;
      }
      paramn = d.l.b.a.b.j.d.a.q((d.l.b.a.b.b.l)paramn);
      AppMethodBeat.o(61035);
      return paramn;
    }
    
    public static int a(c paramc, d.l.b.a.b.m.c.l paraml)
    {
      AppMethodBeat.i(61040);
      p.h(paraml, "$this$size");
      int i = r.a.a((d.l.b.a.b.m.c.r)paramc, paraml);
      AppMethodBeat.o(61040);
      return i;
    }
    
    public static d.l.b.a.b.m.c.m a(c paramc, d.l.b.a.b.m.c.l paraml, int paramInt)
    {
      AppMethodBeat.i(61038);
      p.h(paraml, "$this$get");
      paramc = r.a.a((d.l.b.a.b.m.c.r)paramc, paraml, paramInt);
      AppMethodBeat.o(61038);
      return paramc;
    }
    
    public static Collection<d.l.b.a.b.m.c.h> a(c paramc, j paramj)
    {
      AppMethodBeat.i(60990);
      p.h(paramj, "$this$possibleIntegerTypes");
      paramc = paramc.i(paramj);
      if (!(paramc instanceof d.l.b.a.b.j.b.n))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramj + ", " + z.bp(paramj.getClass())).toString());
        AppMethodBeat.o(60990);
        throw paramc;
      }
      paramc = (Collection)((d.l.b.a.b.j.b.n)paramc).NTE;
      AppMethodBeat.o(60990);
      return paramc;
    }
    
    public static boolean a(c paramc, d.l.b.a.b.m.c.h paramh)
    {
      AppMethodBeat.i(61036);
      p.h(paramh, "$this$isMarkedNullable");
      boolean bool = bb.a.b((bb)paramc, paramh);
      AppMethodBeat.o(61036);
      return bool;
    }
    
    public static d.l.b.a.b.m.c.h b(d.l.b.a.b.m.c.d paramd)
    {
      AppMethodBeat.i(60994);
      p.h(paramd, "$this$lowerType");
      if (!(paramd instanceof k))
      {
        paramd = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramd + ", " + z.bp(paramd.getClass())).toString());
        AppMethodBeat.o(60994);
        throw paramd;
      }
      paramd = (d.l.b.a.b.m.c.h)((k)paramd).Oap;
      AppMethodBeat.o(60994);
      return paramd;
    }
    
    public static j b(j paramj, d.l.b.a.b.m.c.b paramb)
    {
      AppMethodBeat.i(61019);
      p.h(paramj, "type");
      p.h(paramb, "status");
      if (!(paramj instanceof aj))
      {
        paramj = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramj + ", " + z.bp(paramj.getClass())).toString());
        AppMethodBeat.o(61019);
        throw paramj;
      }
      paramj = (j)m.a((aj)paramj, paramb);
      AppMethodBeat.o(61019);
      return paramj;
    }
    
    public static j b(j paramj, boolean paramBoolean)
    {
      AppMethodBeat.i(60991);
      p.h(paramj, "$this$withNullability");
      if (!(paramj instanceof aj))
      {
        paramj = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramj + ", " + z.bp(paramj.getClass())).toString());
        AppMethodBeat.o(60991);
        throw paramj;
      }
      paramj = (j)((aj)paramj).Ap(paramBoolean);
      AppMethodBeat.o(60991);
      return paramj;
    }
    
    public static d.l.b.a.b.m.c.m b(d.l.b.a.b.m.c.h paramh, int paramInt)
    {
      AppMethodBeat.i(61007);
      p.h(paramh, "$this$getArgument");
      if (!(paramh instanceof ab))
      {
        paramh = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramh + ", " + z.bp(paramh.getClass())).toString());
        AppMethodBeat.o(61007);
        throw paramh;
      }
      paramh = (d.l.b.a.b.m.c.m)((ab)paramh).gxy().get(paramInt);
      AppMethodBeat.o(61007);
      return paramh;
    }
    
    public static d.l.b.a.b.m.c.n b(c paramc, d.l.b.a.b.m.c.h paramh)
    {
      AppMethodBeat.i(61037);
      p.h(paramh, "$this$typeConstructor");
      paramc = r.a.a((d.l.b.a.b.m.c.r)paramc, paramh);
      AppMethodBeat.o(61037);
      return paramc;
    }
    
    public static o b(d.l.b.a.b.m.c.n paramn, int paramInt)
    {
      AppMethodBeat.i(61012);
      p.h(paramn, "$this$getParameter");
      if (!(paramn instanceof at))
      {
        paramn = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramn + ", " + z.bp(paramn.getClass())).toString());
        AppMethodBeat.o(61012);
        throw paramn;
      }
      paramn = ((at)paramn).getParameters().get(paramInt);
      p.g(paramn, "this.parameters[index]");
      paramn = (o)paramn;
      AppMethodBeat.o(61012);
      return paramn;
    }
    
    public static boolean b(d.l.b.a.b.m.c.h paramh, d.l.b.a.b.f.b paramb)
    {
      AppMethodBeat.i(61027);
      p.h(paramh, "$this$hasAnnotation");
      p.h(paramb, "fqName");
      if (!(paramh instanceof ab))
      {
        paramh = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramh + ", " + z.bp(paramh.getClass())).toString());
        AppMethodBeat.o(61027);
        throw paramh;
      }
      boolean bool = ((ab)paramh).gmj().h(paramb);
      AppMethodBeat.o(61027);
      return bool;
    }
    
    public static boolean b(j paramj1, j paramj2)
    {
      AppMethodBeat.i(60996);
      p.h(paramj1, "a");
      p.h(paramj2, "b");
      if (!(paramj1 instanceof aj))
      {
        paramj1 = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramj1 + ", " + z.bp(paramj1.getClass())).toString());
        AppMethodBeat.o(60996);
        throw paramj1;
      }
      if (!(paramj2 instanceof aj))
      {
        paramj1 = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramj2 + ", " + z.bp(paramj2.getClass())).toString());
        AppMethodBeat.o(60996);
        throw paramj1;
      }
      if (((aj)paramj1).gxy() == ((aj)paramj2).gxy())
      {
        AppMethodBeat.o(60996);
        return true;
      }
      AppMethodBeat.o(60996);
      return false;
    }
    
    public static j c(c paramc, d.l.b.a.b.m.c.h paramh)
    {
      AppMethodBeat.i(61039);
      p.h(paramh, "$this$lowerBoundIfFlexible");
      paramc = r.a.b((d.l.b.a.b.m.c.r)paramc, paramh);
      AppMethodBeat.o(61039);
      return paramc;
    }
    
    public static t c(o paramo)
    {
      AppMethodBeat.i(61014);
      p.h(paramo, "$this$getVariance");
      if (!(paramo instanceof as))
      {
        paramo = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramo + ", " + z.bp(paramo.getClass())).toString());
        AppMethodBeat.o(61014);
        throw paramo;
      }
      paramo = ((as)paramo).gnh();
      p.g(paramo, "this.variance");
      paramo = d.a(paramo);
      AppMethodBeat.o(61014);
      return paramo;
    }
    
    public static boolean c(d.l.b.a.b.m.c.n paramn1, d.l.b.a.b.m.c.n paramn2)
    {
      AppMethodBeat.i(61015);
      p.h(paramn1, "c1");
      p.h(paramn2, "c2");
      if (!(paramn1 instanceof at))
      {
        paramn1 = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramn1 + ", " + z.bp(paramn1.getClass())).toString());
        AppMethodBeat.o(61015);
        throw paramn1;
      }
      if (!(paramn2 instanceof at))
      {
        paramn1 = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramn2 + ", " + z.bp(paramn2.getClass())).toString());
        AppMethodBeat.o(61015);
        throw paramn1;
      }
      boolean bool = p.i(paramn1, paramn2);
      AppMethodBeat.o(61015);
      return bool;
    }
    
    public static d.l.b.a.b.m.c.f d(d.l.b.a.b.m.c.g paramg)
    {
      AppMethodBeat.i(60999);
      p.h(paramg, "$this$asDynamicType");
      if (!(paramg instanceof d.l.b.a.b.m.v))
      {
        paramg = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramg + ", " + z.bp(paramg.getClass())).toString());
        AppMethodBeat.o(60999);
        throw paramg;
      }
      if (!(paramg instanceof d.l.b.a.b.m.r)) {
        paramg = null;
      }
      for (;;)
      {
        paramg = (d.l.b.a.b.m.c.f)paramg;
        AppMethodBeat.o(60999);
        return paramg;
      }
    }
    
    public static d.l.b.a.b.m.c.h d(o paramo)
    {
      AppMethodBeat.i(61030);
      p.h(paramo, "$this$getRepresentativeUpperBound");
      if (!(paramo instanceof as))
      {
        paramo = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramo + ", " + z.bp(paramo.getClass())).toString());
        AppMethodBeat.o(61030);
        throw paramo;
      }
      paramo = (d.l.b.a.b.m.c.h)d.l.b.a.b.m.d.a.e((as)paramo);
      AppMethodBeat.o(61030);
      return paramo;
    }
    
    public static j d(c paramc, d.l.b.a.b.m.c.h paramh)
    {
      AppMethodBeat.i(61041);
      p.h(paramh, "$this$upperBoundIfFlexible");
      paramc = r.a.c((d.l.b.a.b.m.c.r)paramc, paramh);
      AppMethodBeat.o(61041);
      return paramc;
    }
    
    public static boolean d(d.l.b.a.b.m.c.m paramm)
    {
      AppMethodBeat.i(61008);
      p.h(paramm, "$this$isStarProjection");
      if (!(paramm instanceof av))
      {
        paramm = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramm + ", " + z.bp(paramm.getClass())).toString());
        AppMethodBeat.o(61008);
        throw paramm;
      }
      boolean bool = ((av)paramm).gyE();
      AppMethodBeat.o(61008);
      return bool;
    }
    
    public static d.l.b.a.b.m.c.h e(c paramc, d.l.b.a.b.m.c.h paramh)
    {
      AppMethodBeat.i(61042);
      p.h(paramh, "$this$makeNullable");
      paramc = bb.a.c((bb)paramc, paramh);
      AppMethodBeat.o(61042);
      return paramc;
    }
    
    public static j e(d.l.b.a.b.m.c.g paramg)
    {
      AppMethodBeat.i(61000);
      p.h(paramg, "$this$upperBound");
      if (!(paramg instanceof d.l.b.a.b.m.v))
      {
        paramg = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramg + ", " + z.bp(paramg.getClass())).toString());
        AppMethodBeat.o(61000);
        throw paramg;
      }
      paramg = (j)((d.l.b.a.b.m.v)paramg).NZd;
      AppMethodBeat.o(61000);
      return paramg;
    }
    
    public static t e(d.l.b.a.b.m.c.m paramm)
    {
      AppMethodBeat.i(61009);
      p.h(paramm, "$this$getVariance");
      if (!(paramm instanceof av))
      {
        paramm = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramm + ", " + z.bp(paramm.getClass())).toString());
        AppMethodBeat.o(61009);
        throw paramm;
      }
      paramm = ((av)paramm).gyF();
      p.g(paramm, "this.projectionKind");
      paramm = d.a(paramm);
      AppMethodBeat.o(61009);
      return paramm;
    }
    
    public static d.l.b.a.b.m.c.h f(d.l.b.a.b.m.c.m paramm)
    {
      AppMethodBeat.i(61010);
      p.h(paramm, "$this$getType");
      if (!(paramm instanceof av))
      {
        paramm = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramm + ", " + z.bp(paramm.getClass())).toString());
        AppMethodBeat.o(61010);
        throw paramm;
      }
      paramm = (d.l.b.a.b.m.c.h)((av)paramm).gnW().gyC();
      AppMethodBeat.o(61010);
      return paramm;
    }
    
    public static j f(d.l.b.a.b.m.c.g paramg)
    {
      AppMethodBeat.i(61001);
      p.h(paramg, "$this$lowerBound");
      if (!(paramg instanceof d.l.b.a.b.m.v))
      {
        paramg = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramg + ", " + z.bp(paramg.getClass())).toString());
        AppMethodBeat.o(61001);
        throw paramg;
      }
      paramg = (j)((d.l.b.a.b.m.v)paramg).NZc;
      AppMethodBeat.o(61001);
      return paramg;
    }
    
    public static d.l.b.a.b.m.c.h jE(List<? extends d.l.b.a.b.m.c.h> paramList)
    {
      AppMethodBeat.i(61024);
      p.h(paramList, "types");
      paramList = (d.l.b.a.b.m.c.h)f.jF(paramList);
      AppMethodBeat.o(61024);
      return paramList;
    }
    
    public static boolean m(j paramj)
    {
      AppMethodBeat.i(60993);
      p.h(paramj, "$this$isStubType");
      if (!(paramj instanceof aj))
      {
        paramj = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramj + ", " + z.bp(paramj.getClass())).toString());
        AppMethodBeat.o(60993);
        throw paramj;
      }
      boolean bool = paramj instanceof aq;
      AppMethodBeat.o(60993);
      return bool;
    }
    
    public static d.l.b.a.b.m.c.d n(j paramj)
    {
      AppMethodBeat.i(61002);
      p.h(paramj, "$this$asCapturedType");
      if (!(paramj instanceof aj))
      {
        paramj = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramj + ", " + z.bp(paramj.getClass())).toString());
        AppMethodBeat.o(61002);
        throw paramj;
      }
      if (!(paramj instanceof k)) {
        paramj = null;
      }
      for (;;)
      {
        paramj = (d.l.b.a.b.m.c.d)paramj;
        AppMethodBeat.o(61002);
        return paramj;
      }
    }
    
    public static d.l.b.a.b.m.c.e o(j paramj)
    {
      AppMethodBeat.i(61003);
      p.h(paramj, "$this$asDefinitelyNotNullType");
      if (!(paramj instanceof aj))
      {
        paramj = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramj + ", " + z.bp(paramj.getClass())).toString());
        AppMethodBeat.o(61003);
        throw paramj;
      }
      if (!(paramj instanceof d.l.b.a.b.m.l)) {
        paramj = null;
      }
      for (;;)
      {
        paramj = (d.l.b.a.b.m.c.e)paramj;
        AppMethodBeat.o(61003);
        return paramj;
      }
    }
    
    public static boolean p(j paramj)
    {
      AppMethodBeat.i(61004);
      p.h(paramj, "$this$isMarkedNullable");
      if (!(paramj instanceof aj))
      {
        paramj = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramj + ", " + z.bp(paramj.getClass())).toString());
        AppMethodBeat.o(61004);
        throw paramj;
      }
      boolean bool = ((aj)paramj).gqy();
      AppMethodBeat.o(61004);
      return bool;
    }
    
    public static boolean p(d.l.b.a.b.m.c.n paramn)
    {
      AppMethodBeat.i(60988);
      p.h(paramn, "$this$isDenotable");
      if (!(paramn instanceof at))
      {
        paramn = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramn + ", " + z.bp(paramn.getClass())).toString());
        AppMethodBeat.o(60988);
        throw paramn;
      }
      boolean bool = ((at)paramn).gms();
      AppMethodBeat.o(60988);
      return bool;
    }
    
    public static d.l.b.a.b.m.c.n q(j paramj)
    {
      AppMethodBeat.i(61005);
      p.h(paramj, "$this$typeConstructor");
      if (!(paramj instanceof aj))
      {
        paramj = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramj + ", " + z.bp(paramj.getClass())).toString());
        AppMethodBeat.o(61005);
        throw paramj;
      }
      paramj = (d.l.b.a.b.m.c.n)((aj)paramj).gxB();
      AppMethodBeat.o(61005);
      return paramj;
    }
    
    public static boolean q(d.l.b.a.b.m.c.n paramn)
    {
      AppMethodBeat.i(60989);
      p.h(paramn, "$this$isIntegerLiteralTypeConstructor");
      if (!(paramn instanceof at))
      {
        paramn = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramn + ", " + z.bp(paramn.getClass())).toString());
        AppMethodBeat.o(60989);
        throw paramn;
      }
      boolean bool = paramn instanceof d.l.b.a.b.j.b.n;
      AppMethodBeat.o(60989);
      return bool;
    }
    
    public static d.l.b.a.b.m.c.l r(j paramj)
    {
      AppMethodBeat.i(61018);
      p.h(paramj, "$this$asArgumentList");
      if (!(paramj instanceof aj))
      {
        paramj = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramj + ", " + z.bp(paramj.getClass())).toString());
        AppMethodBeat.o(61018);
        throw paramj;
      }
      paramj = (d.l.b.a.b.m.c.l)paramj;
      AppMethodBeat.o(61018);
      return paramj;
    }
    
    public static boolean r(d.l.b.a.b.m.c.n paramn)
    {
      AppMethodBeat.i(60995);
      p.h(paramn, "$this$isIntersection");
      if (!(paramn instanceof at))
      {
        paramn = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramn + ", " + z.bp(paramn.getClass())).toString());
        AppMethodBeat.o(60995);
        throw paramn;
      }
      boolean bool = paramn instanceof aa;
      AppMethodBeat.o(60995);
      return bool;
    }
    
    public static int s(d.l.b.a.b.m.c.n paramn)
    {
      AppMethodBeat.i(61011);
      p.h(paramn, "$this$parametersCount");
      if (!(paramn instanceof at))
      {
        paramn = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramn + ", " + z.bp(paramn.getClass())).toString());
        AppMethodBeat.o(61011);
        throw paramn;
      }
      int i = ((at)paramn).getParameters().size();
      AppMethodBeat.o(61011);
      return i;
    }
    
    public static boolean s(j paramj)
    {
      AppMethodBeat.i(61023);
      p.h(paramj, "$this$isSingleClassifierType");
      if (!(paramj instanceof aj))
      {
        paramj = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramj + ", " + z.bp(paramj.getClass())).toString());
        AppMethodBeat.o(61023);
        throw paramj;
      }
      if ((!ad.aq((ab)paramj)) && (!(((aj)paramj).gxB().gmq() instanceof ar)) && ((((aj)paramj).gxB().gmq() != null) || ((paramj instanceof d.l.b.a.b.j.a.a.a)) || ((paramj instanceof k)) || ((paramj instanceof d.l.b.a.b.m.l)) || ((((aj)paramj).gxB() instanceof d.l.b.a.b.j.b.n))))
      {
        AppMethodBeat.o(61023);
        return true;
      }
      AppMethodBeat.o(61023);
      return false;
    }
    
    public static Collection<d.l.b.a.b.m.c.h> t(d.l.b.a.b.m.c.n paramn)
    {
      AppMethodBeat.i(61013);
      p.h(paramn, "$this$supertypes");
      if (!(paramn instanceof at))
      {
        paramn = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramn + ", " + z.bp(paramn.getClass())).toString());
        AppMethodBeat.o(61013);
        throw paramn;
      }
      paramn = ((at)paramn).got();
      p.g(paramn, "this.supertypes");
      AppMethodBeat.o(61013);
      return paramn;
    }
    
    public static boolean t(d.l.b.a.b.m.c.h paramh)
    {
      AppMethodBeat.i(60992);
      p.h(paramh, "$this$isError");
      if (!(paramh instanceof ab))
      {
        paramh = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramh + ", " + z.bp(paramh.getClass())).toString());
        AppMethodBeat.o(60992);
        throw paramh;
      }
      boolean bool = ad.aq((ab)paramh);
      AppMethodBeat.o(60992);
      return bool;
    }
    
    public static boolean t(j paramj)
    {
      AppMethodBeat.i(61026);
      p.h(paramj, "$this$isPrimitiveType");
      if (!(paramj instanceof ab))
      {
        paramj = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramj + ", " + z.bp(paramj.getClass())).toString());
        AppMethodBeat.o(61026);
        throw paramj;
      }
      boolean bool = d.l.b.a.b.a.g.o((ab)paramj);
      AppMethodBeat.o(61026);
      return bool;
    }
    
    public static j u(d.l.b.a.b.m.c.h paramh)
    {
      AppMethodBeat.i(60997);
      p.h(paramh, "$this$asSimpleType");
      if (!(paramh instanceof ab))
      {
        paramh = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramh + ", " + z.bp(paramh.getClass())).toString());
        AppMethodBeat.o(60997);
        throw paramh;
      }
      bg localbg = ((ab)paramh).gyC();
      paramh = localbg;
      if (!(localbg instanceof aj)) {
        paramh = null;
      }
      paramh = (j)paramh;
      AppMethodBeat.o(60997);
      return paramh;
    }
    
    public static boolean u(d.l.b.a.b.m.c.n paramn)
    {
      AppMethodBeat.i(61016);
      p.h(paramn, "$this$isClassTypeConstructor");
      if (!(paramn instanceof at))
      {
        paramn = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramn + ", " + z.bp(paramn.getClass())).toString());
        AppMethodBeat.o(61016);
        throw paramn;
      }
      boolean bool = ((at)paramn).gmq() instanceof d.l.b.a.b.b.e;
      AppMethodBeat.o(61016);
      return bool;
    }
    
    public static d.l.b.a.b.m.c.g v(d.l.b.a.b.m.c.h paramh)
    {
      AppMethodBeat.i(60998);
      p.h(paramh, "$this$asFlexibleType");
      if (!(paramh instanceof ab))
      {
        paramh = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramh + ", " + z.bp(paramh.getClass())).toString());
        AppMethodBeat.o(60998);
        throw paramh;
      }
      bg localbg = ((ab)paramh).gyC();
      paramh = localbg;
      if (!(localbg instanceof d.l.b.a.b.m.v)) {
        paramh = null;
      }
      paramh = (d.l.b.a.b.m.c.g)paramh;
      AppMethodBeat.o(60998);
      return paramh;
    }
    
    public static boolean v(d.l.b.a.b.m.c.n paramn)
    {
      AppMethodBeat.i(61017);
      p.h(paramn, "$this$isCommonFinalClassConstructor");
      if (!(paramn instanceof at))
      {
        paramn = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramn + ", " + z.bp(paramn.getClass())).toString());
        AppMethodBeat.o(61017);
        throw paramn;
      }
      d.l.b.a.b.b.h localh = ((at)paramn).gmq();
      paramn = localh;
      if (!(localh instanceof d.l.b.a.b.b.e)) {
        paramn = null;
      }
      paramn = (d.l.b.a.b.b.e)paramn;
      if (paramn == null)
      {
        AppMethodBeat.o(61017);
        return false;
      }
      if ((x.p(paramn)) && (paramn.glY() != d.l.b.a.b.b.f.Nrz) && (paramn.glY() != d.l.b.a.b.b.f.NrA))
      {
        AppMethodBeat.o(61017);
        return true;
      }
      AppMethodBeat.o(61017);
      return false;
    }
    
    public static int w(d.l.b.a.b.m.c.h paramh)
    {
      AppMethodBeat.i(61006);
      p.h(paramh, "$this$argumentsCount");
      if (!(paramh instanceof ab))
      {
        paramh = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramh + ", " + z.bp(paramh.getClass())).toString());
        AppMethodBeat.o(61006);
        throw paramh;
      }
      int i = ((ab)paramh).gxy().size();
      AppMethodBeat.o(61006);
      return i;
    }
    
    public static boolean w(d.l.b.a.b.m.c.n paramn)
    {
      AppMethodBeat.i(61020);
      p.h(paramn, "$this$isAnyConstructor");
      if (!(paramn instanceof at))
      {
        paramn = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramn + ", " + z.bp(paramn.getClass())).toString());
        AppMethodBeat.o(61020);
        throw paramn;
      }
      boolean bool = d.l.b.a.b.a.g.a((at)paramn, d.l.b.a.b.a.g.Nng.Nnk);
      AppMethodBeat.o(61020);
      return bool;
    }
    
    public static d.l.b.a.b.m.c.m x(d.l.b.a.b.m.c.h paramh)
    {
      AppMethodBeat.i(61022);
      p.h(paramh, "$this$asTypeArgument");
      if (!(paramh instanceof ab))
      {
        paramh = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramh + ", " + z.bp(paramh.getClass())).toString());
        AppMethodBeat.o(61022);
        throw paramh;
      }
      paramh = (d.l.b.a.b.m.c.m)d.l.b.a.b.m.d.a.aO((ab)paramh);
      AppMethodBeat.o(61022);
      return paramh;
    }
    
    public static boolean x(d.l.b.a.b.m.c.n paramn)
    {
      AppMethodBeat.i(61021);
      p.h(paramn, "$this$isNothingConstructor");
      if (!(paramn instanceof at))
      {
        paramn = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramn + ", " + z.bp(paramn.getClass())).toString());
        AppMethodBeat.o(61021);
        throw paramn;
      }
      boolean bool = d.l.b.a.b.a.g.a((at)paramn, d.l.b.a.b.a.g.Nng.Nnl);
      AppMethodBeat.o(61021);
      return bool;
    }
    
    public static o y(d.l.b.a.b.m.c.n paramn)
    {
      AppMethodBeat.i(61028);
      p.h(paramn, "$this$getTypeParameterClassifier");
      if (!(paramn instanceof at))
      {
        paramn = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramn + ", " + z.bp(paramn.getClass())).toString());
        AppMethodBeat.o(61028);
        throw paramn;
      }
      d.l.b.a.b.b.h localh = ((at)paramn).gmq();
      paramn = localh;
      if (!(localh instanceof as)) {
        paramn = null;
      }
      paramn = (o)paramn;
      AppMethodBeat.o(61028);
      return paramn;
    }
    
    public static boolean y(d.l.b.a.b.m.c.h paramh)
    {
      AppMethodBeat.i(61025);
      p.h(paramh, "$this$isNullableType");
      if (!(paramh instanceof ab))
      {
        paramh = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramh + ", " + z.bp(paramh.getClass())).toString());
        AppMethodBeat.o(61025);
        throw paramh;
      }
      boolean bool = bc.aF((ab)paramh);
      AppMethodBeat.o(61025);
      return bool;
    }
    
    public static d.l.b.a.b.m.c.h z(d.l.b.a.b.m.c.h paramh)
    {
      AppMethodBeat.i(61031);
      p.h(paramh, "$this$getSubstitutedUnderlyingType");
      if (!(paramh instanceof ab))
      {
        paramh = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramh + ", " + z.bp(paramh.getClass())).toString());
        AppMethodBeat.o(61031);
        throw paramh;
      }
      paramh = (d.l.b.a.b.m.c.h)d.l.b.a.b.j.e.ac((ab)paramh);
      AppMethodBeat.o(61031);
      return paramh;
    }
    
    public static boolean z(d.l.b.a.b.m.c.n paramn)
    {
      AppMethodBeat.i(61029);
      p.h(paramn, "$this$isInlineClass");
      if (!(paramn instanceof at))
      {
        paramn = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramn + ", " + z.bp(paramn.getClass())).toString());
        AppMethodBeat.o(61029);
        throw paramn;
      }
      d.l.b.a.b.b.h localh = ((at)paramn).gmq();
      paramn = localh;
      if (!(localh instanceof d.l.b.a.b.b.e)) {
        paramn = null;
      }
      paramn = (d.l.b.a.b.b.e)paramn;
      if ((paramn != null) && (paramn.gmf() == true))
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