package kotlin.l.b.a.b.j.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import kotlin.a.v;
import kotlin.aa;
import kotlin.g.a.m;
import kotlin.g.b.n;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z.f;
import kotlin.l.b.a.b.b.ad;
import kotlin.l.b.a.b.b.ag;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.f.j.a;
import kotlin.l.b.a.b.m.a.i.a;
import kotlin.l.b.a.b.m.a.r;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.o.b.a;
import kotlin.l.b.a.b.o.b.b;
import kotlin.t;
import kotlin.x;

public final class a
{
  private static final f TIM;
  
  static
  {
    AppMethodBeat.i(60159);
    f localf = f.btY("value");
    p.g(localf, "Name.identifier(\"value\")");
    TIM = localf;
    AppMethodBeat.o(60159);
  }
  
  public static final e B(e parame)
  {
    AppMethodBeat.i(60147);
    p.h(parame, "$this$getSuperClassNotAny");
    parame = parame.hAG().hKE().hBV().iterator();
    while (parame.hasNext())
    {
      Object localObject = (kotlin.l.b.a.b.m.ab)parame.next();
      if (!kotlin.l.b.a.b.a.g.z((kotlin.l.b.a.b.m.ab)localObject))
      {
        localObject = ((kotlin.l.b.a.b.m.ab)localObject).hKE().hzS();
        if (kotlin.l.b.a.b.j.c.B((l)localObject))
        {
          if (localObject == null)
          {
            parame = new t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            AppMethodBeat.o(60147);
            throw parame;
          }
          parame = (e)localObject;
          AppMethodBeat.o(60147);
          return parame;
        }
      }
    }
    AppMethodBeat.o(60147);
    return null;
  }
  
  public static final Collection<e> C(e parame)
  {
    AppMethodBeat.i(60154);
    p.h(parame, "sealedClass");
    if (parame.hzC() != w.Thp)
    {
      parame = (Collection)v.SXr;
      AppMethodBeat.o(60154);
      return parame;
    }
    final LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    a locala = new a(parame, localLinkedHashSet);
    l locall = parame.hzx();
    p.g(locall, "sealedClass.containingDeclaration");
    if ((locall instanceof kotlin.l.b.a.b.b.ab)) {
      locala.a(((kotlin.l.b.a.b.b.ab)locall).hAp(), false);
    }
    parame = parame.hAN();
    p.g(parame, "sealedClass.unsubstitutedInnerClassesScope");
    locala.a(parame, true);
    parame = (Collection)localLinkedHashSet;
    AppMethodBeat.o(60154);
    return parame;
  }
  
  public static final y F(l paraml)
  {
    AppMethodBeat.i(60144);
    p.h(paraml, "$this$module");
    paraml = kotlin.l.b.a.b.j.c.s(paraml);
    p.g(paraml, "DescriptorUtils.getContainingModule(this)");
    AppMethodBeat.o(60144);
    return paraml;
  }
  
  public static final kotlin.l.b.a.b.a.g G(l paraml)
  {
    AppMethodBeat.i(60148);
    p.h(paraml, "$this$builtIns");
    paraml = F(paraml).hBh();
    AppMethodBeat.o(60148);
    return paraml;
  }
  
  public static final kotlin.m.h<l> H(l paraml)
  {
    AppMethodBeat.i(60150);
    p.h(paraml, "$this$parents");
    p.h(paraml, "$this$parentsWithSelf");
    paraml = kotlin.m.i.b(paraml, (kotlin.g.a.b)f.TIU);
    p.h(paraml, "$this$drop");
    if ((paraml instanceof kotlin.m.c))
    {
      paraml = ((kotlin.m.c)paraml).hMd();
      AppMethodBeat.o(60150);
      return paraml;
    }
    paraml = (kotlin.m.h)new kotlin.m.b(paraml, 1);
    AppMethodBeat.o(60150);
    return paraml;
  }
  
  public static final kotlin.l.b.a.b.f.b I(l paraml)
  {
    AppMethodBeat.i(60152);
    p.h(paraml, "$this$fqNameOrNull");
    paraml = q(paraml);
    if (paraml.hJi()) {}
    while (paraml != null)
    {
      paraml = paraml.hJj();
      AppMethodBeat.o(60152);
      return paraml;
      paraml = null;
    }
    AppMethodBeat.o(60152);
    return null;
  }
  
  public static final e b(y paramy, kotlin.l.b.a.b.f.b paramb, kotlin.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(60145);
    p.h(paramy, "$this$resolveTopLevelClass");
    p.h(paramb, "topLevelClassFqName");
    p.h(parama, "location");
    if (!paramb.isRoot()) {}
    for (int i = 1; (aa.SXc) && (i == 0); i = 0)
    {
      paramy = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(60145);
      throw paramy;
    }
    kotlin.l.b.a.b.f.b localb = paramb.hJf();
    p.g(localb, "topLevelClassFqName.parent()");
    paramy = paramy.e(localb).hAp();
    paramb = paramb.hJg();
    p.g(paramb, "topLevelClassFqName.shortName()");
    paramb = paramy.c(paramb, parama);
    paramy = paramb;
    if (!(paramb instanceof e)) {
      paramy = null;
    }
    paramy = (e)paramy;
    AppMethodBeat.o(60145);
    return paramy;
  }
  
  public static final boolean b(av paramav)
  {
    AppMethodBeat.i(60149);
    p.h(paramav, "$this$declaresOrInheritsDefaultValue");
    paramav = kotlin.l.b.a.b.o.b.a((Collection)kotlin.a.j.listOf(paramav), (b.b)b.TIQ, (kotlin.g.a.b)c.TIR);
    p.g(paramav, "DFS.ifAny(\n        listO…eclaresDefaultValue\n    )");
    boolean bool = paramav.booleanValue();
    AppMethodBeat.o(60149);
    return bool;
  }
  
  public static final kotlin.l.b.a.b.f.a c(kotlin.l.b.a.b.b.h paramh)
  {
    AppMethodBeat.i(60146);
    if (paramh != null)
    {
      Object localObject = paramh.hzx();
      if (localObject != null)
      {
        if ((localObject instanceof kotlin.l.b.a.b.b.ab))
        {
          paramh = new kotlin.l.b.a.b.f.a(((kotlin.l.b.a.b.b.ab)localObject).hBk(), paramh.hAH());
          AppMethodBeat.o(60146);
          return paramh;
        }
        if ((localObject instanceof kotlin.l.b.a.b.b.i))
        {
          localObject = c((kotlin.l.b.a.b.b.h)localObject);
          if (localObject != null)
          {
            paramh = ((kotlin.l.b.a.b.f.a)localObject).o(paramh.hAH());
            AppMethodBeat.o(60146);
            return paramh;
          }
        }
        AppMethodBeat.o(60146);
        return null;
      }
    }
    AppMethodBeat.o(60146);
    return null;
  }
  
  public static final kotlin.l.b.a.b.m.a.i d(y paramy)
  {
    AppMethodBeat.i(60157);
    p.h(paramy, "$this$getKotlinTypeRefiner");
    paramy = (r)paramy.a(kotlin.l.b.a.b.m.a.j.hLL());
    if (paramy != null)
    {
      kotlin.l.b.a.b.m.a.i locali = (kotlin.l.b.a.b.m.a.i)paramy.value;
      paramy = locali;
      if (locali != null) {}
    }
    else
    {
      paramy = (kotlin.l.b.a.b.m.a.i)i.a.TPf;
    }
    AppMethodBeat.o(60157);
    return paramy;
  }
  
  public static final boolean e(y paramy)
  {
    AppMethodBeat.i(60158);
    p.h(paramy, "$this$isTypeRefinementEnabled");
    paramy = (r)paramy.a(kotlin.l.b.a.b.m.a.j.hLL());
    if (paramy != null) {}
    for (paramy = (kotlin.l.b.a.b.m.a.i)paramy.value; paramy != null; paramy = null)
    {
      AppMethodBeat.o(60158);
      return true;
    }
    AppMethodBeat.o(60158);
    return false;
  }
  
  public static final e l(kotlin.l.b.a.b.b.a.c paramc)
  {
    AppMethodBeat.i(60155);
    p.h(paramc, "$this$annotationClass");
    kotlin.l.b.a.b.b.h localh = paramc.hBy().hKE().hzS();
    paramc = localh;
    if (!(localh instanceof e)) {
      paramc = null;
    }
    paramc = (e)paramc;
    AppMethodBeat.o(60155);
    return paramc;
  }
  
  public static final kotlin.l.b.a.b.j.b.g<?> m(kotlin.l.b.a.b.b.a.c paramc)
  {
    AppMethodBeat.i(60156);
    p.h(paramc, "$this$firstArgument");
    paramc = (kotlin.l.b.a.b.j.b.g)kotlin.a.j.f((Iterable)paramc.hBO().values());
    AppMethodBeat.o(60156);
    return paramc;
  }
  
  public static final kotlin.l.b.a.b.f.b o(l paraml)
  {
    AppMethodBeat.i(60143);
    p.h(paraml, "$this$fqNameSafe");
    paraml = kotlin.l.b.a.b.j.c.o(paraml);
    p.g(paraml, "DescriptorUtils.getFqNameSafe(this)");
    AppMethodBeat.o(60143);
    return paraml;
  }
  
  public static final kotlin.l.b.a.b.f.c q(l paraml)
  {
    AppMethodBeat.i(60142);
    p.h(paraml, "$this$fqNameUnsafe");
    paraml = kotlin.l.b.a.b.j.c.n(paraml);
    p.g(paraml, "DescriptorUtils.getFqName(this)");
    AppMethodBeat.o(60142);
    return paraml;
  }
  
  public static final kotlin.l.b.a.b.b.b v(kotlin.l.b.a.b.b.b paramb)
  {
    AppMethodBeat.i(60151);
    p.h(paramb, "$this$propertyIfAccessor");
    if ((paramb instanceof ag))
    {
      paramb = ((ag)paramb).hBm();
      p.g(paramb, "correspondingProperty");
      paramb = (kotlin.l.b.a.b.b.b)paramb;
      AppMethodBeat.o(60151);
      return paramb;
    }
    AppMethodBeat.o(60151);
    return paramb;
  }
  
  static final class a
    extends q
    implements m<kotlin.l.b.a.b.j.f.h, Boolean, x>
  {
    a(e parame, LinkedHashSet paramLinkedHashSet)
    {
      super();
    }
    
    public final void a(kotlin.l.b.a.b.j.f.h paramh, boolean paramBoolean)
    {
      AppMethodBeat.i(60131);
      p.h(paramh, "scope");
      paramh = j.a.a(paramh, kotlin.l.b.a.b.j.f.d.TJJ, null, 2).iterator();
      while (paramh.hasNext())
      {
        Object localObject = (l)paramh.next();
        if ((localObject instanceof e))
        {
          if (kotlin.l.b.a.b.j.c.b((e)localObject, this.TIN)) {
            localLinkedHashSet.add(localObject);
          }
          if (paramBoolean)
          {
            a locala = (a)this;
            localObject = ((e)localObject).hAN();
            p.g(localObject, "descriptor.unsubstitutedInnerClassesScope");
            locala.a((kotlin.l.b.a.b.j.f.h)localObject, paramBoolean);
          }
        }
      }
      AppMethodBeat.o(60131);
    }
  }
  
  static final class b<N>
    implements b.b<N>
  {
    public static final b TIQ;
    
    static
    {
      AppMethodBeat.i(60133);
      TIQ = new b();
      AppMethodBeat.o(60133);
    }
  }
  
  static final class d<N>
    implements b.b<N>
  {}
  
  public static final class e
    extends b.a<kotlin.l.b.a.b.b.b, kotlin.l.b.a.b.b.b>
  {
    e(z.f paramf, kotlin.g.a.b paramb) {}
  }
  
  static final class f
    extends q
    implements kotlin.g.a.b<l, l>
  {
    public static final f TIU;
    
    static
    {
      AppMethodBeat.i(60141);
      TIU = new f();
      AppMethodBeat.o(60141);
    }
    
    f()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.j.d.a
 * JD-Core Version:    0.7.0.1
 */