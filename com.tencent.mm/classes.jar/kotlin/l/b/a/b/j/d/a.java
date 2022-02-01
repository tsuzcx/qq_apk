package kotlin.l.b.a.b.j.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import kotlin.a.v;
import kotlin.g.a.m;
import kotlin.g.b.aa.f;
import kotlin.g.b.n;
import kotlin.g.b.p;
import kotlin.g.b.q;
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
import kotlin.z;

public final class a
{
  private static final f ablp;
  
  static
  {
    AppMethodBeat.i(60159);
    f localf = f.bHb("value");
    p.j(localf, "Name.identifier(\"value\")");
    ablp = localf;
    AppMethodBeat.o(60159);
  }
  
  public static final e B(e parame)
  {
    AppMethodBeat.i(60147);
    p.k(parame, "$this$getSuperClassNotAny");
    parame = parame.iET().iOU().iGk().iterator();
    while (parame.hasNext())
    {
      Object localObject = (kotlin.l.b.a.b.m.ab)parame.next();
      if (!kotlin.l.b.a.b.a.g.z((kotlin.l.b.a.b.m.ab)localObject))
      {
        localObject = ((kotlin.l.b.a.b.m.ab)localObject).iOU().iEf();
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
    p.k(parame, "sealedClass");
    if (parame.iDO() != w.aaKj)
    {
      parame = (Collection)v.aaAd;
      AppMethodBeat.o(60154);
      return parame;
    }
    final LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    a locala = new a(parame, localLinkedHashSet);
    l locall = parame.iDJ();
    p.j(locall, "sealedClass.containingDeclaration");
    if ((locall instanceof kotlin.l.b.a.b.b.ab)) {
      locala.a(((kotlin.l.b.a.b.b.ab)locall).iEC(), false);
    }
    parame = parame.iFa();
    p.j(parame, "sealedClass.unsubstitutedInnerClassesScope");
    locala.a(parame, true);
    parame = (Collection)localLinkedHashSet;
    AppMethodBeat.o(60154);
    return parame;
  }
  
  public static final y F(l paraml)
  {
    AppMethodBeat.i(60144);
    p.k(paraml, "$this$module");
    paraml = kotlin.l.b.a.b.j.c.s(paraml);
    p.j(paraml, "DescriptorUtils.getContainingModule(this)");
    AppMethodBeat.o(60144);
    return paraml;
  }
  
  public static final kotlin.l.b.a.b.a.g G(l paraml)
  {
    AppMethodBeat.i(60148);
    p.k(paraml, "$this$builtIns");
    paraml = F(paraml).iFv();
    AppMethodBeat.o(60148);
    return paraml;
  }
  
  public static final kotlin.m.h<l> H(l paraml)
  {
    AppMethodBeat.i(60150);
    p.k(paraml, "$this$parents");
    p.k(paraml, "$this$parentsWithSelf");
    paraml = kotlin.m.i.b(paraml, (kotlin.g.a.b)f.ablw);
    p.k(paraml, "$this$drop");
    if ((paraml instanceof kotlin.m.c))
    {
      paraml = ((kotlin.m.c)paraml).iQu();
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
    p.k(paraml, "$this$fqNameOrNull");
    paraml = q(paraml);
    if (paraml.iNC()) {}
    while (paraml != null)
    {
      paraml = paraml.iND();
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
    p.k(paramy, "$this$resolveTopLevelClass");
    p.k(paramb, "topLevelClassFqName");
    p.k(parama, "location");
    if (!paramb.isRoot()) {}
    for (int i = 1; (z.aazO) && (i == 0); i = 0)
    {
      paramy = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(60145);
      throw paramy;
    }
    kotlin.l.b.a.b.f.b localb = paramb.iNz();
    p.j(localb, "topLevelClassFqName.parent()");
    paramy = paramy.e(localb).iEC();
    paramb = paramb.iNA();
    p.j(paramb, "topLevelClassFqName.shortName()");
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
    p.k(paramav, "$this$declaresOrInheritsDefaultValue");
    paramav = kotlin.l.b.a.b.o.b.a((Collection)kotlin.a.j.listOf(paramav), (b.b)b.abls, (kotlin.g.a.b)c.ablt);
    p.j(paramav, "DFS.ifAny(\n        listO…eclaresDefaultValue\n    )");
    boolean bool = paramav.booleanValue();
    AppMethodBeat.o(60149);
    return bool;
  }
  
  public static final kotlin.l.b.a.b.f.a c(kotlin.l.b.a.b.b.h paramh)
  {
    AppMethodBeat.i(60146);
    if (paramh != null)
    {
      Object localObject = paramh.iDJ();
      if (localObject != null)
      {
        if ((localObject instanceof kotlin.l.b.a.b.b.ab))
        {
          paramh = new kotlin.l.b.a.b.f.a(((kotlin.l.b.a.b.b.ab)localObject).iFy(), paramh.iEU());
          AppMethodBeat.o(60146);
          return paramh;
        }
        if ((localObject instanceof kotlin.l.b.a.b.b.i))
        {
          localObject = c((kotlin.l.b.a.b.b.h)localObject);
          if (localObject != null)
          {
            paramh = ((kotlin.l.b.a.b.f.a)localObject).o(paramh.iEU());
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
    p.k(paramy, "$this$getKotlinTypeRefiner");
    paramy = (r)paramy.a(kotlin.l.b.a.b.m.a.j.iQd());
    if (paramy != null)
    {
      kotlin.l.b.a.b.m.a.i locali = (kotlin.l.b.a.b.m.a.i)paramy.value;
      paramy = locali;
      if (locali != null) {}
    }
    else
    {
      paramy = (kotlin.l.b.a.b.m.a.i)i.a.abrE;
    }
    AppMethodBeat.o(60157);
    return paramy;
  }
  
  public static final boolean e(y paramy)
  {
    AppMethodBeat.i(60158);
    p.k(paramy, "$this$isTypeRefinementEnabled");
    paramy = (r)paramy.a(kotlin.l.b.a.b.m.a.j.iQd());
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
    p.k(paramc, "$this$annotationClass");
    kotlin.l.b.a.b.b.h localh = paramc.iFN().iOU().iEf();
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
    p.k(paramc, "$this$firstArgument");
    paramc = (kotlin.l.b.a.b.j.b.g)kotlin.a.j.f((Iterable)paramc.iGd().values());
    AppMethodBeat.o(60156);
    return paramc;
  }
  
  public static final kotlin.l.b.a.b.f.b o(l paraml)
  {
    AppMethodBeat.i(60143);
    p.k(paraml, "$this$fqNameSafe");
    paraml = kotlin.l.b.a.b.j.c.o(paraml);
    p.j(paraml, "DescriptorUtils.getFqNameSafe(this)");
    AppMethodBeat.o(60143);
    return paraml;
  }
  
  public static final kotlin.l.b.a.b.f.c q(l paraml)
  {
    AppMethodBeat.i(60142);
    p.k(paraml, "$this$fqNameUnsafe");
    paraml = kotlin.l.b.a.b.j.c.n(paraml);
    p.j(paraml, "DescriptorUtils.getFqName(this)");
    AppMethodBeat.o(60142);
    return paraml;
  }
  
  public static final kotlin.l.b.a.b.b.b v(kotlin.l.b.a.b.b.b paramb)
  {
    AppMethodBeat.i(60151);
    p.k(paramb, "$this$propertyIfAccessor");
    if ((paramb instanceof ag))
    {
      paramb = ((ag)paramb).iFB();
      p.j(paramb, "correspondingProperty");
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
      p.k(paramh, "scope");
      paramh = j.a.a(paramh, kotlin.l.b.a.b.j.f.d.abml, null, 2).iterator();
      while (paramh.hasNext())
      {
        Object localObject = (l)paramh.next();
        if ((localObject instanceof e))
        {
          if (kotlin.l.b.a.b.j.c.b((e)localObject, this.ablq)) {
            localLinkedHashSet.add(localObject);
          }
          if (paramBoolean)
          {
            a locala = (a)this;
            localObject = ((e)localObject).iFa();
            p.j(localObject, "descriptor.unsubstitutedInnerClassesScope");
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
    public static final b abls;
    
    static
    {
      AppMethodBeat.i(60133);
      abls = new b();
      AppMethodBeat.o(60133);
    }
  }
  
  static final class d<N>
    implements b.b<N>
  {}
  
  public static final class e
    extends b.a<kotlin.l.b.a.b.b.b, kotlin.l.b.a.b.b.b>
  {
    e(aa.f paramf, kotlin.g.a.b paramb) {}
  }
  
  static final class f
    extends q
    implements kotlin.g.a.b<l, l>
  {
    public static final f ablw;
    
    static
    {
      AppMethodBeat.i(60141);
      ablw = new f();
      AppMethodBeat.o(60141);
    }
    
    f()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.j.d.a
 * JD-Core Version:    0.7.0.1
 */