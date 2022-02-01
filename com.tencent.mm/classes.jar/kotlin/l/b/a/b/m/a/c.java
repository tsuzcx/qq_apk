package kotlin.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l.b.a.b.a.g.a;
import kotlin.l.b.a.b.b.ar;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.x;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.aq;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.av;
import kotlin.l.b.a.b.m.bb;
import kotlin.l.b.a.b.m.bb.a;
import kotlin.l.b.a.b.m.bc;
import kotlin.l.b.a.b.m.bg;
import kotlin.l.b.a.b.m.c.j;
import kotlin.l.b.a.b.m.c.o;
import kotlin.l.b.a.b.m.c.r.a;
import kotlin.l.b.a.b.m.v;

public abstract interface c
  extends bb, kotlin.l.b.a.b.m.c.r
{
  public abstract kotlin.l.b.a.b.m.c.n i(j paramj);
  
  public abstract j o(kotlin.l.b.a.b.m.c.h paramh);
  
  public static final class a
  {
    public static kotlin.l.b.a.b.a.h A(kotlin.l.b.a.b.m.c.n paramn)
    {
      AppMethodBeat.i(61032);
      p.h(paramn, "$this$getPrimitiveType");
      if (!(paramn instanceof at))
      {
        paramn = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramn + ", " + kotlin.g.b.aa.bp(paramn.getClass())).toString());
        AppMethodBeat.o(61032);
        throw paramn;
      }
      paramn = ((at)paramn).hzS();
      if (paramn == null)
      {
        paramn = new kotlin.t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        AppMethodBeat.o(61032);
        throw paramn;
      }
      paramn = kotlin.l.b.a.b.a.g.e((kotlin.l.b.a.b.b.l)paramn);
      AppMethodBeat.o(61032);
      return paramn;
    }
    
    public static kotlin.l.b.a.b.a.h B(kotlin.l.b.a.b.m.c.n paramn)
    {
      AppMethodBeat.i(61033);
      p.h(paramn, "$this$getPrimitiveArrayType");
      if (!(paramn instanceof at))
      {
        paramn = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramn + ", " + kotlin.g.b.aa.bp(paramn.getClass())).toString());
        AppMethodBeat.o(61033);
        throw paramn;
      }
      paramn = ((at)paramn).hzS();
      if (paramn == null)
      {
        paramn = new kotlin.t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        AppMethodBeat.o(61033);
        throw paramn;
      }
      paramn = kotlin.l.b.a.b.a.g.f((kotlin.l.b.a.b.b.l)paramn);
      AppMethodBeat.o(61033);
      return paramn;
    }
    
    public static boolean C(kotlin.l.b.a.b.m.c.n paramn)
    {
      AppMethodBeat.i(61034);
      p.h(paramn, "$this$isUnderKotlinPackage");
      if (!(paramn instanceof at))
      {
        paramn = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramn + ", " + kotlin.g.b.aa.bp(paramn.getClass())).toString());
        AppMethodBeat.o(61034);
        throw paramn;
      }
      paramn = ((at)paramn).hzS();
      if ((paramn != null) && (kotlin.l.b.a.b.a.g.d((kotlin.l.b.a.b.b.l)paramn) == true))
      {
        AppMethodBeat.o(61034);
        return true;
      }
      AppMethodBeat.o(61034);
      return false;
    }
    
    public static kotlin.l.b.a.b.f.c D(kotlin.l.b.a.b.m.c.n paramn)
    {
      AppMethodBeat.i(61035);
      p.h(paramn, "$this$getClassFqNameUnsafe");
      if (!(paramn instanceof at))
      {
        paramn = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramn + ", " + kotlin.g.b.aa.bp(paramn.getClass())).toString());
        AppMethodBeat.o(61035);
        throw paramn;
      }
      paramn = ((at)paramn).hzS();
      if (paramn == null)
      {
        paramn = new kotlin.t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        AppMethodBeat.o(61035);
        throw paramn;
      }
      paramn = kotlin.l.b.a.b.j.d.a.q((kotlin.l.b.a.b.b.l)paramn);
      AppMethodBeat.o(61035);
      return paramn;
    }
    
    public static int a(c paramc, kotlin.l.b.a.b.m.c.l paraml)
    {
      AppMethodBeat.i(61040);
      p.h(paraml, "$this$size");
      int i = r.a.a((kotlin.l.b.a.b.m.c.r)paramc, paraml);
      AppMethodBeat.o(61040);
      return i;
    }
    
    public static Collection<kotlin.l.b.a.b.m.c.h> a(c paramc, j paramj)
    {
      AppMethodBeat.i(60990);
      p.h(paramj, "$this$possibleIntegerTypes");
      paramc = paramc.i(paramj);
      if (!(paramc instanceof kotlin.l.b.a.b.j.b.n))
      {
        paramc = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramj + ", " + kotlin.g.b.aa.bp(paramj.getClass())).toString());
        AppMethodBeat.o(60990);
        throw paramc;
      }
      paramc = (Collection)((kotlin.l.b.a.b.j.b.n)paramc).TIA;
      AppMethodBeat.o(60990);
      return paramc;
    }
    
    public static kotlin.l.b.a.b.m.c.m a(c paramc, kotlin.l.b.a.b.m.c.l paraml, int paramInt)
    {
      AppMethodBeat.i(61038);
      p.h(paraml, "$this$get");
      paramc = r.a.a((kotlin.l.b.a.b.m.c.r)paramc, paraml, paramInt);
      AppMethodBeat.o(61038);
      return paramc;
    }
    
    public static boolean a(c paramc, kotlin.l.b.a.b.m.c.h paramh)
    {
      AppMethodBeat.i(61036);
      p.h(paramh, "$this$isMarkedNullable");
      boolean bool = bb.a.b((bb)paramc, paramh);
      AppMethodBeat.o(61036);
      return bool;
    }
    
    public static kotlin.l.b.a.b.m.c.h b(kotlin.l.b.a.b.m.c.d paramd)
    {
      AppMethodBeat.i(60994);
      p.h(paramd, "$this$lowerType");
      if (!(paramd instanceof k))
      {
        paramd = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramd + ", " + kotlin.g.b.aa.bp(paramd.getClass())).toString());
        AppMethodBeat.o(60994);
        throw paramd;
      }
      paramd = (kotlin.l.b.a.b.m.c.h)((k)paramd).TPj;
      AppMethodBeat.o(60994);
      return paramd;
    }
    
    public static j b(j paramj, kotlin.l.b.a.b.m.c.b paramb)
    {
      AppMethodBeat.i(61019);
      p.h(paramj, "type");
      p.h(paramb, "status");
      if (!(paramj instanceof aj))
      {
        paramj = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramj + ", " + kotlin.g.b.aa.bp(paramj.getClass())).toString());
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
        paramj = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramj + ", " + kotlin.g.b.aa.bp(paramj.getClass())).toString());
        AppMethodBeat.o(60991);
        throw paramj;
      }
      paramj = (j)((aj)paramj).EG(paramBoolean);
      AppMethodBeat.o(60991);
      return paramj;
    }
    
    public static kotlin.l.b.a.b.m.c.m b(kotlin.l.b.a.b.m.c.h paramh, int paramInt)
    {
      AppMethodBeat.i(61007);
      p.h(paramh, "$this$getArgument");
      if (!(paramh instanceof ab))
      {
        paramh = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramh + ", " + kotlin.g.b.aa.bp(paramh.getClass())).toString());
        AppMethodBeat.o(61007);
        throw paramh;
      }
      paramh = (kotlin.l.b.a.b.m.c.m)((ab)paramh).hKB().get(paramInt);
      AppMethodBeat.o(61007);
      return paramh;
    }
    
    public static kotlin.l.b.a.b.m.c.n b(c paramc, kotlin.l.b.a.b.m.c.h paramh)
    {
      AppMethodBeat.i(61037);
      p.h(paramh, "$this$typeConstructor");
      paramc = r.a.a((kotlin.l.b.a.b.m.c.r)paramc, paramh);
      AppMethodBeat.o(61037);
      return paramc;
    }
    
    public static o b(kotlin.l.b.a.b.m.c.n paramn, int paramInt)
    {
      AppMethodBeat.i(61012);
      p.h(paramn, "$this$getParameter");
      if (!(paramn instanceof at))
      {
        paramn = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramn + ", " + kotlin.g.b.aa.bp(paramn.getClass())).toString());
        AppMethodBeat.o(61012);
        throw paramn;
      }
      paramn = ((at)paramn).getParameters().get(paramInt);
      p.g(paramn, "this.parameters[index]");
      paramn = (o)paramn;
      AppMethodBeat.o(61012);
      return paramn;
    }
    
    public static boolean b(kotlin.l.b.a.b.m.c.h paramh, kotlin.l.b.a.b.f.b paramb)
    {
      AppMethodBeat.i(61027);
      p.h(paramh, "$this$hasAnnotation");
      p.h(paramb, "fqName");
      if (!(paramh instanceof ab))
      {
        paramh = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramh + ", " + kotlin.g.b.aa.bp(paramh.getClass())).toString());
        AppMethodBeat.o(61027);
        throw paramh;
      }
      boolean bool = ((ab)paramh).hzL().h(paramb);
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
        paramj1 = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramj1 + ", " + kotlin.g.b.aa.bp(paramj1.getClass())).toString());
        AppMethodBeat.o(60996);
        throw paramj1;
      }
      if (!(paramj2 instanceof aj))
      {
        paramj1 = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramj2 + ", " + kotlin.g.b.aa.bp(paramj2.getClass())).toString());
        AppMethodBeat.o(60996);
        throw paramj1;
      }
      if (((aj)paramj1).hKB() == ((aj)paramj2).hKB())
      {
        AppMethodBeat.o(60996);
        return true;
      }
      AppMethodBeat.o(60996);
      return false;
    }
    
    public static j c(c paramc, kotlin.l.b.a.b.m.c.h paramh)
    {
      AppMethodBeat.i(61039);
      p.h(paramh, "$this$lowerBoundIfFlexible");
      paramc = r.a.b((kotlin.l.b.a.b.m.c.r)paramc, paramh);
      AppMethodBeat.o(61039);
      return paramc;
    }
    
    public static kotlin.l.b.a.b.m.c.t c(o paramo)
    {
      AppMethodBeat.i(61014);
      p.h(paramo, "$this$getVariance");
      if (!(paramo instanceof as))
      {
        paramo = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramo + ", " + kotlin.g.b.aa.bp(paramo.getClass())).toString());
        AppMethodBeat.o(61014);
        throw paramo;
      }
      paramo = ((as)paramo).hAJ();
      p.g(paramo, "this.variance");
      paramo = d.a(paramo);
      AppMethodBeat.o(61014);
      return paramo;
    }
    
    public static boolean c(kotlin.l.b.a.b.m.c.n paramn1, kotlin.l.b.a.b.m.c.n paramn2)
    {
      AppMethodBeat.i(61015);
      p.h(paramn1, "c1");
      p.h(paramn2, "c2");
      if (!(paramn1 instanceof at))
      {
        paramn1 = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramn1 + ", " + kotlin.g.b.aa.bp(paramn1.getClass())).toString());
        AppMethodBeat.o(61015);
        throw paramn1;
      }
      if (!(paramn2 instanceof at))
      {
        paramn1 = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramn2 + ", " + kotlin.g.b.aa.bp(paramn2.getClass())).toString());
        AppMethodBeat.o(61015);
        throw paramn1;
      }
      boolean bool = p.j(paramn1, paramn2);
      AppMethodBeat.o(61015);
      return bool;
    }
    
    public static kotlin.l.b.a.b.m.c.f d(kotlin.l.b.a.b.m.c.g paramg)
    {
      AppMethodBeat.i(60999);
      p.h(paramg, "$this$asDynamicType");
      if (!(paramg instanceof v))
      {
        paramg = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramg + ", " + kotlin.g.b.aa.bp(paramg.getClass())).toString());
        AppMethodBeat.o(60999);
        throw paramg;
      }
      if (!(paramg instanceof kotlin.l.b.a.b.m.r)) {
        paramg = null;
      }
      for (;;)
      {
        paramg = (kotlin.l.b.a.b.m.c.f)paramg;
        AppMethodBeat.o(60999);
        return paramg;
      }
    }
    
    public static kotlin.l.b.a.b.m.c.h d(o paramo)
    {
      AppMethodBeat.i(61030);
      p.h(paramo, "$this$getRepresentativeUpperBound");
      if (!(paramo instanceof as))
      {
        paramo = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramo + ", " + kotlin.g.b.aa.bp(paramo.getClass())).toString());
        AppMethodBeat.o(61030);
        throw paramo;
      }
      paramo = (kotlin.l.b.a.b.m.c.h)kotlin.l.b.a.b.m.d.a.e((as)paramo);
      AppMethodBeat.o(61030);
      return paramo;
    }
    
    public static j d(c paramc, kotlin.l.b.a.b.m.c.h paramh)
    {
      AppMethodBeat.i(61041);
      p.h(paramh, "$this$upperBoundIfFlexible");
      paramc = r.a.c((kotlin.l.b.a.b.m.c.r)paramc, paramh);
      AppMethodBeat.o(61041);
      return paramc;
    }
    
    public static boolean d(kotlin.l.b.a.b.m.c.m paramm)
    {
      AppMethodBeat.i(61008);
      p.h(paramm, "$this$isStarProjection");
      if (!(paramm instanceof av))
      {
        paramm = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramm + ", " + kotlin.g.b.aa.bp(paramm.getClass())).toString());
        AppMethodBeat.o(61008);
        throw paramm;
      }
      boolean bool = ((av)paramm).hLH();
      AppMethodBeat.o(61008);
      return bool;
    }
    
    public static kotlin.l.b.a.b.m.c.h e(c paramc, kotlin.l.b.a.b.m.c.h paramh)
    {
      AppMethodBeat.i(61042);
      p.h(paramh, "$this$makeNullable");
      paramc = bb.a.c((bb)paramc, paramh);
      AppMethodBeat.o(61042);
      return paramc;
    }
    
    public static j e(kotlin.l.b.a.b.m.c.g paramg)
    {
      AppMethodBeat.i(61000);
      p.h(paramg, "$this$upperBound");
      if (!(paramg instanceof v))
      {
        paramg = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramg + ", " + kotlin.g.b.aa.bp(paramg.getClass())).toString());
        AppMethodBeat.o(61000);
        throw paramg;
      }
      paramg = (j)((v)paramg).TNW;
      AppMethodBeat.o(61000);
      return paramg;
    }
    
    public static kotlin.l.b.a.b.m.c.t e(kotlin.l.b.a.b.m.c.m paramm)
    {
      AppMethodBeat.i(61009);
      p.h(paramm, "$this$getVariance");
      if (!(paramm instanceof av))
      {
        paramm = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramm + ", " + kotlin.g.b.aa.bp(paramm.getClass())).toString());
        AppMethodBeat.o(61009);
        throw paramm;
      }
      paramm = ((av)paramm).hLI();
      p.g(paramm, "this.projectionKind");
      paramm = d.a(paramm);
      AppMethodBeat.o(61009);
      return paramm;
    }
    
    public static kotlin.l.b.a.b.m.c.h f(kotlin.l.b.a.b.m.c.m paramm)
    {
      AppMethodBeat.i(61010);
      p.h(paramm, "$this$getType");
      if (!(paramm instanceof av))
      {
        paramm = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramm + ", " + kotlin.g.b.aa.bp(paramm.getClass())).toString());
        AppMethodBeat.o(61010);
        throw paramm;
      }
      paramm = (kotlin.l.b.a.b.m.c.h)((av)paramm).hBy().hLF();
      AppMethodBeat.o(61010);
      return paramm;
    }
    
    public static j f(kotlin.l.b.a.b.m.c.g paramg)
    {
      AppMethodBeat.i(61001);
      p.h(paramg, "$this$lowerBound");
      if (!(paramg instanceof v))
      {
        paramg = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramg + ", " + kotlin.g.b.aa.bp(paramg.getClass())).toString());
        AppMethodBeat.o(61001);
        throw paramg;
      }
      paramg = (j)((v)paramg).TNV;
      AppMethodBeat.o(61001);
      return paramg;
    }
    
    public static kotlin.l.b.a.b.m.c.h kK(List<? extends kotlin.l.b.a.b.m.c.h> paramList)
    {
      AppMethodBeat.i(61024);
      p.h(paramList, "types");
      paramList = (kotlin.l.b.a.b.m.c.h)f.kL(paramList);
      AppMethodBeat.o(61024);
      return paramList;
    }
    
    public static boolean m(j paramj)
    {
      AppMethodBeat.i(60993);
      p.h(paramj, "$this$isStubType");
      if (!(paramj instanceof aj))
      {
        paramj = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramj + ", " + kotlin.g.b.aa.bp(paramj.getClass())).toString());
        AppMethodBeat.o(60993);
        throw paramj;
      }
      boolean bool = paramj instanceof aq;
      AppMethodBeat.o(60993);
      return bool;
    }
    
    public static kotlin.l.b.a.b.m.c.d n(j paramj)
    {
      AppMethodBeat.i(61002);
      p.h(paramj, "$this$asCapturedType");
      if (!(paramj instanceof aj))
      {
        paramj = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramj + ", " + kotlin.g.b.aa.bp(paramj.getClass())).toString());
        AppMethodBeat.o(61002);
        throw paramj;
      }
      if (!(paramj instanceof k)) {
        paramj = null;
      }
      for (;;)
      {
        paramj = (kotlin.l.b.a.b.m.c.d)paramj;
        AppMethodBeat.o(61002);
        return paramj;
      }
    }
    
    public static kotlin.l.b.a.b.m.c.e o(j paramj)
    {
      AppMethodBeat.i(61003);
      p.h(paramj, "$this$asDefinitelyNotNullType");
      if (!(paramj instanceof aj))
      {
        paramj = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramj + ", " + kotlin.g.b.aa.bp(paramj.getClass())).toString());
        AppMethodBeat.o(61003);
        throw paramj;
      }
      if (!(paramj instanceof kotlin.l.b.a.b.m.l)) {
        paramj = null;
      }
      for (;;)
      {
        paramj = (kotlin.l.b.a.b.m.c.e)paramj;
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
        paramj = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramj + ", " + kotlin.g.b.aa.bp(paramj.getClass())).toString());
        AppMethodBeat.o(61004);
        throw paramj;
      }
      boolean bool = ((aj)paramj).hEa();
      AppMethodBeat.o(61004);
      return bool;
    }
    
    public static boolean p(kotlin.l.b.a.b.m.c.n paramn)
    {
      AppMethodBeat.i(60988);
      p.h(paramn, "$this$isDenotable");
      if (!(paramn instanceof at))
      {
        paramn = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramn + ", " + kotlin.g.b.aa.bp(paramn.getClass())).toString());
        AppMethodBeat.o(60988);
        throw paramn;
      }
      boolean bool = ((at)paramn).hzU();
      AppMethodBeat.o(60988);
      return bool;
    }
    
    public static kotlin.l.b.a.b.m.c.n q(j paramj)
    {
      AppMethodBeat.i(61005);
      p.h(paramj, "$this$typeConstructor");
      if (!(paramj instanceof aj))
      {
        paramj = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramj + ", " + kotlin.g.b.aa.bp(paramj.getClass())).toString());
        AppMethodBeat.o(61005);
        throw paramj;
      }
      paramj = (kotlin.l.b.a.b.m.c.n)((aj)paramj).hKE();
      AppMethodBeat.o(61005);
      return paramj;
    }
    
    public static boolean q(kotlin.l.b.a.b.m.c.n paramn)
    {
      AppMethodBeat.i(60989);
      p.h(paramn, "$this$isIntegerLiteralTypeConstructor");
      if (!(paramn instanceof at))
      {
        paramn = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramn + ", " + kotlin.g.b.aa.bp(paramn.getClass())).toString());
        AppMethodBeat.o(60989);
        throw paramn;
      }
      boolean bool = paramn instanceof kotlin.l.b.a.b.j.b.n;
      AppMethodBeat.o(60989);
      return bool;
    }
    
    public static kotlin.l.b.a.b.m.c.l r(j paramj)
    {
      AppMethodBeat.i(61018);
      p.h(paramj, "$this$asArgumentList");
      if (!(paramj instanceof aj))
      {
        paramj = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramj + ", " + kotlin.g.b.aa.bp(paramj.getClass())).toString());
        AppMethodBeat.o(61018);
        throw paramj;
      }
      paramj = (kotlin.l.b.a.b.m.c.l)paramj;
      AppMethodBeat.o(61018);
      return paramj;
    }
    
    public static boolean r(kotlin.l.b.a.b.m.c.n paramn)
    {
      AppMethodBeat.i(60995);
      p.h(paramn, "$this$isIntersection");
      if (!(paramn instanceof at))
      {
        paramn = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramn + ", " + kotlin.g.b.aa.bp(paramn.getClass())).toString());
        AppMethodBeat.o(60995);
        throw paramn;
      }
      boolean bool = paramn instanceof kotlin.l.b.a.b.m.aa;
      AppMethodBeat.o(60995);
      return bool;
    }
    
    public static int s(kotlin.l.b.a.b.m.c.n paramn)
    {
      AppMethodBeat.i(61011);
      p.h(paramn, "$this$parametersCount");
      if (!(paramn instanceof at))
      {
        paramn = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramn + ", " + kotlin.g.b.aa.bp(paramn.getClass())).toString());
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
        paramj = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramj + ", " + kotlin.g.b.aa.bp(paramj.getClass())).toString());
        AppMethodBeat.o(61023);
        throw paramj;
      }
      if ((!ad.ap((ab)paramj)) && (!(((aj)paramj).hKE().hzS() instanceof ar)) && ((((aj)paramj).hKE().hzS() != null) || ((paramj instanceof kotlin.l.b.a.b.j.a.a.a)) || ((paramj instanceof k)) || ((paramj instanceof kotlin.l.b.a.b.m.l)) || ((((aj)paramj).hKE() instanceof kotlin.l.b.a.b.j.b.n))))
      {
        AppMethodBeat.o(61023);
        return true;
      }
      AppMethodBeat.o(61023);
      return false;
    }
    
    public static Collection<kotlin.l.b.a.b.m.c.h> t(kotlin.l.b.a.b.m.c.n paramn)
    {
      AppMethodBeat.i(61013);
      p.h(paramn, "$this$supertypes");
      if (!(paramn instanceof at))
      {
        paramn = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramn + ", " + kotlin.g.b.aa.bp(paramn.getClass())).toString());
        AppMethodBeat.o(61013);
        throw paramn;
      }
      paramn = ((at)paramn).hBV();
      p.g(paramn, "this.supertypes");
      AppMethodBeat.o(61013);
      return paramn;
    }
    
    public static boolean t(kotlin.l.b.a.b.m.c.h paramh)
    {
      AppMethodBeat.i(60992);
      p.h(paramh, "$this$isError");
      if (!(paramh instanceof ab))
      {
        paramh = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramh + ", " + kotlin.g.b.aa.bp(paramh.getClass())).toString());
        AppMethodBeat.o(60992);
        throw paramh;
      }
      boolean bool = ad.ap((ab)paramh);
      AppMethodBeat.o(60992);
      return bool;
    }
    
    public static boolean t(j paramj)
    {
      AppMethodBeat.i(61026);
      p.h(paramj, "$this$isPrimitiveType");
      if (!(paramj instanceof ab))
      {
        paramj = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramj + ", " + kotlin.g.b.aa.bp(paramj.getClass())).toString());
        AppMethodBeat.o(61026);
        throw paramj;
      }
      boolean bool = kotlin.l.b.a.b.a.g.o((ab)paramj);
      AppMethodBeat.o(61026);
      return bool;
    }
    
    public static j u(kotlin.l.b.a.b.m.c.h paramh)
    {
      AppMethodBeat.i(60997);
      p.h(paramh, "$this$asSimpleType");
      if (!(paramh instanceof ab))
      {
        paramh = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramh + ", " + kotlin.g.b.aa.bp(paramh.getClass())).toString());
        AppMethodBeat.o(60997);
        throw paramh;
      }
      bg localbg = ((ab)paramh).hLF();
      paramh = localbg;
      if (!(localbg instanceof aj)) {
        paramh = null;
      }
      paramh = (j)paramh;
      AppMethodBeat.o(60997);
      return paramh;
    }
    
    public static boolean u(kotlin.l.b.a.b.m.c.n paramn)
    {
      AppMethodBeat.i(61016);
      p.h(paramn, "$this$isClassTypeConstructor");
      if (!(paramn instanceof at))
      {
        paramn = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramn + ", " + kotlin.g.b.aa.bp(paramn.getClass())).toString());
        AppMethodBeat.o(61016);
        throw paramn;
      }
      boolean bool = ((at)paramn).hzS() instanceof kotlin.l.b.a.b.b.e;
      AppMethodBeat.o(61016);
      return bool;
    }
    
    public static kotlin.l.b.a.b.m.c.g v(kotlin.l.b.a.b.m.c.h paramh)
    {
      AppMethodBeat.i(60998);
      p.h(paramh, "$this$asFlexibleType");
      if (!(paramh instanceof ab))
      {
        paramh = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramh + ", " + kotlin.g.b.aa.bp(paramh.getClass())).toString());
        AppMethodBeat.o(60998);
        throw paramh;
      }
      bg localbg = ((ab)paramh).hLF();
      paramh = localbg;
      if (!(localbg instanceof v)) {
        paramh = null;
      }
      paramh = (kotlin.l.b.a.b.m.c.g)paramh;
      AppMethodBeat.o(60998);
      return paramh;
    }
    
    public static boolean v(kotlin.l.b.a.b.m.c.n paramn)
    {
      AppMethodBeat.i(61017);
      p.h(paramn, "$this$isCommonFinalClassConstructor");
      if (!(paramn instanceof at))
      {
        paramn = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramn + ", " + kotlin.g.b.aa.bp(paramn.getClass())).toString());
        AppMethodBeat.o(61017);
        throw paramn;
      }
      kotlin.l.b.a.b.b.h localh = ((at)paramn).hzS();
      paramn = localh;
      if (!(localh instanceof kotlin.l.b.a.b.b.e)) {
        paramn = null;
      }
      paramn = (kotlin.l.b.a.b.b.e)paramn;
      if (paramn == null)
      {
        AppMethodBeat.o(61017);
        return false;
      }
      if ((x.p(paramn)) && (paramn.hzB() != kotlin.l.b.a.b.b.f.Thh) && (paramn.hzB() != kotlin.l.b.a.b.b.f.Thi))
      {
        AppMethodBeat.o(61017);
        return true;
      }
      AppMethodBeat.o(61017);
      return false;
    }
    
    public static int w(kotlin.l.b.a.b.m.c.h paramh)
    {
      AppMethodBeat.i(61006);
      p.h(paramh, "$this$argumentsCount");
      if (!(paramh instanceof ab))
      {
        paramh = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramh + ", " + kotlin.g.b.aa.bp(paramh.getClass())).toString());
        AppMethodBeat.o(61006);
        throw paramh;
      }
      int i = ((ab)paramh).hKB().size();
      AppMethodBeat.o(61006);
      return i;
    }
    
    public static boolean w(kotlin.l.b.a.b.m.c.n paramn)
    {
      AppMethodBeat.i(61020);
      p.h(paramn, "$this$isAnyConstructor");
      if (!(paramn instanceof at))
      {
        paramn = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramn + ", " + kotlin.g.b.aa.bp(paramn.getClass())).toString());
        AppMethodBeat.o(61020);
        throw paramn;
      }
      boolean bool = kotlin.l.b.a.b.a.g.a((at)paramn, kotlin.l.b.a.b.a.g.TcO.TcS);
      AppMethodBeat.o(61020);
      return bool;
    }
    
    public static kotlin.l.b.a.b.m.c.m x(kotlin.l.b.a.b.m.c.h paramh)
    {
      AppMethodBeat.i(61022);
      p.h(paramh, "$this$asTypeArgument");
      if (!(paramh instanceof ab))
      {
        paramh = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramh + ", " + kotlin.g.b.aa.bp(paramh.getClass())).toString());
        AppMethodBeat.o(61022);
        throw paramh;
      }
      paramh = (kotlin.l.b.a.b.m.c.m)kotlin.l.b.a.b.m.d.a.aN((ab)paramh);
      AppMethodBeat.o(61022);
      return paramh;
    }
    
    public static boolean x(kotlin.l.b.a.b.m.c.n paramn)
    {
      AppMethodBeat.i(61021);
      p.h(paramn, "$this$isNothingConstructor");
      if (!(paramn instanceof at))
      {
        paramn = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramn + ", " + kotlin.g.b.aa.bp(paramn.getClass())).toString());
        AppMethodBeat.o(61021);
        throw paramn;
      }
      boolean bool = kotlin.l.b.a.b.a.g.a((at)paramn, kotlin.l.b.a.b.a.g.TcO.TcT);
      AppMethodBeat.o(61021);
      return bool;
    }
    
    public static o y(kotlin.l.b.a.b.m.c.n paramn)
    {
      AppMethodBeat.i(61028);
      p.h(paramn, "$this$getTypeParameterClassifier");
      if (!(paramn instanceof at))
      {
        paramn = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramn + ", " + kotlin.g.b.aa.bp(paramn.getClass())).toString());
        AppMethodBeat.o(61028);
        throw paramn;
      }
      kotlin.l.b.a.b.b.h localh = ((at)paramn).hzS();
      paramn = localh;
      if (!(localh instanceof as)) {
        paramn = null;
      }
      paramn = (o)paramn;
      AppMethodBeat.o(61028);
      return paramn;
    }
    
    public static boolean y(kotlin.l.b.a.b.m.c.h paramh)
    {
      AppMethodBeat.i(61025);
      p.h(paramh, "$this$isNullableType");
      if (!(paramh instanceof ab))
      {
        paramh = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramh + ", " + kotlin.g.b.aa.bp(paramh.getClass())).toString());
        AppMethodBeat.o(61025);
        throw paramh;
      }
      boolean bool = bc.aE((ab)paramh);
      AppMethodBeat.o(61025);
      return bool;
    }
    
    public static kotlin.l.b.a.b.m.c.h z(kotlin.l.b.a.b.m.c.h paramh)
    {
      AppMethodBeat.i(61031);
      p.h(paramh, "$this$getSubstitutedUnderlyingType");
      if (!(paramh instanceof ab))
      {
        paramh = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramh + ", " + kotlin.g.b.aa.bp(paramh.getClass())).toString());
        AppMethodBeat.o(61031);
        throw paramh;
      }
      paramh = (kotlin.l.b.a.b.m.c.h)kotlin.l.b.a.b.j.e.ab((ab)paramh);
      AppMethodBeat.o(61031);
      return paramh;
    }
    
    public static boolean z(kotlin.l.b.a.b.m.c.n paramn)
    {
      AppMethodBeat.i(61029);
      p.h(paramn, "$this$isInlineClass");
      if (!(paramn instanceof at))
      {
        paramn = (Throwable)new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + paramn + ", " + kotlin.g.b.aa.bp(paramn.getClass())).toString());
        AppMethodBeat.o(61029);
        throw paramn;
      }
      kotlin.l.b.a.b.b.h localh = ((at)paramn).hzS();
      paramn = localh;
      if (!(localh instanceof kotlin.l.b.a.b.b.e)) {
        paramn = null;
      }
      paramn = (kotlin.l.b.a.b.b.e)paramn;
      if ((paramn != null) && (paramn.hzI() == true))
      {
        AppMethodBeat.o(61029);
        return true;
      }
      AppMethodBeat.o(61029);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.m.a.c
 * JD-Core Version:    0.7.0.1
 */