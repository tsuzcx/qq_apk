package d.l.b.a.b.j.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.ac;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.g.b.y.f;
import d.l.b.a.b.b.ad;
import d.l.b.a.b.b.ag;
import d.l.b.a.b.b.av;
import d.l.b.a.b.b.e;
import d.l.b.a.b.b.l;
import d.l.b.a.b.b.w;
import d.l.b.a.b.b.y;
import d.l.b.a.b.f.f;
import d.l.b.a.b.j.f.d;
import d.l.b.a.b.j.f.j.a;
import d.l.b.a.b.m.a.i.a;
import d.l.b.a.b.m.a.r;
import d.l.b.a.b.m.aj;
import d.l.b.a.b.m.at;
import d.l.b.a.b.o.b.a;
import d.l.b.a.b.o.b.b;
import d.z;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;

public final class a
{
  private static final f NwK;
  
  static
  {
    AppMethodBeat.i(60159);
    f localf = f.bcE("value");
    p.g(localf, "Name.identifier(\"value\")");
    NwK = localf;
    AppMethodBeat.o(60159);
  }
  
  public static final e B(e parame)
  {
    AppMethodBeat.i(60147);
    p.h(parame, "$this$getSuperClassNotAny");
    parame = parame.giC().gsZ().gjR().iterator();
    while (parame.hasNext())
    {
      Object localObject = (d.l.b.a.b.m.ab)parame.next();
      if (!d.l.b.a.b.a.g.z((d.l.b.a.b.m.ab)localObject))
      {
        localObject = ((d.l.b.a.b.m.ab)localObject).gsZ().ghO();
        if (d.l.b.a.b.j.c.B((l)localObject))
        {
          if (localObject == null)
          {
            parame = new d.v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
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
    if (parame.ghx() != w.MUC)
    {
      parame = (Collection)d.a.v.MKE;
      AppMethodBeat.o(60154);
      return parame;
    }
    final LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    a locala = new a(parame, localLinkedHashSet);
    l locall = parame.ghs();
    p.g(locall, "sealedClass.containingDeclaration");
    if ((locall instanceof d.l.b.a.b.b.ab)) {
      locala.a(((d.l.b.a.b.b.ab)locall).gil(), false);
    }
    parame = parame.giJ();
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
    paraml = d.l.b.a.b.j.c.s(paraml);
    p.g(paraml, "DescriptorUtils.getContainingModule(this)");
    AppMethodBeat.o(60144);
    return paraml;
  }
  
  public static final d.l.b.a.b.a.g G(l paraml)
  {
    AppMethodBeat.i(60148);
    p.h(paraml, "$this$builtIns");
    paraml = F(paraml).gjd();
    AppMethodBeat.o(60148);
    return paraml;
  }
  
  public static final d.m.h<l> H(l paraml)
  {
    AppMethodBeat.i(60150);
    p.h(paraml, "$this$parents");
    p.h(paraml, "$this$parentsWithSelf");
    paraml = d.m.i.b(paraml, (d.g.a.b)f.NwR);
    p.h(paraml, "$this$drop");
    if ((paraml instanceof d.m.c))
    {
      paraml = ((d.m.c)paraml).guy();
      AppMethodBeat.o(60150);
      return paraml;
    }
    paraml = (d.m.h)new d.m.b(paraml, 1);
    AppMethodBeat.o(60150);
    return paraml;
  }
  
  public static final d.l.b.a.b.f.b I(l paraml)
  {
    AppMethodBeat.i(60152);
    p.h(paraml, "$this$fqNameOrNull");
    paraml = q(paraml);
    if (paraml.grj()) {}
    while (paraml != null)
    {
      paraml = paraml.grk();
      AppMethodBeat.o(60152);
      return paraml;
      paraml = null;
    }
    AppMethodBeat.o(60152);
    return null;
  }
  
  public static final e b(y paramy, d.l.b.a.b.f.b paramb, d.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(60145);
    p.h(paramy, "$this$resolveTopLevelClass");
    p.h(paramb, "topLevelClassFqName");
    p.h(parama, "location");
    if (!paramb.isRoot()) {}
    for (int i = 1; (ac.MKp) && (i == 0); i = 0)
    {
      paramy = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(60145);
      throw paramy;
    }
    d.l.b.a.b.f.b localb = paramb.grg();
    p.g(localb, "topLevelClassFqName.parent()");
    paramy = paramy.e(localb).gil();
    paramb = paramb.grh();
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
    paramav = d.l.b.a.b.o.b.a((Collection)d.a.j.listOf(paramav), (b.b)b.NwN, (d.g.a.b)a.c.NwO);
    p.g(paramav, "DFS.ifAny(\n        listO…eclaresDefaultValue\n    )");
    boolean bool = paramav.booleanValue();
    AppMethodBeat.o(60149);
    return bool;
  }
  
  public static final d.l.b.a.b.f.a c(d.l.b.a.b.b.h paramh)
  {
    AppMethodBeat.i(60146);
    if (paramh != null)
    {
      Object localObject = paramh.ghs();
      if (localObject != null)
      {
        if ((localObject instanceof d.l.b.a.b.b.ab))
        {
          paramh = new d.l.b.a.b.f.a(((d.l.b.a.b.b.ab)localObject).gjg(), paramh.giD());
          AppMethodBeat.o(60146);
          return paramh;
        }
        if ((localObject instanceof d.l.b.a.b.b.i))
        {
          localObject = c((d.l.b.a.b.b.h)localObject);
          if (localObject != null)
          {
            paramh = ((d.l.b.a.b.f.a)localObject).o(paramh.giD());
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
  
  public static final d.l.b.a.b.m.a.i d(y paramy)
  {
    AppMethodBeat.i(60157);
    p.h(paramy, "$this$getKotlinTypeRefiner");
    paramy = (r)paramy.a(d.l.b.a.b.m.a.j.gug());
    if (paramy != null)
    {
      d.l.b.a.b.m.a.i locali = (d.l.b.a.b.m.a.i)paramy.value;
      paramy = locali;
      if (locali != null) {}
    }
    else
    {
      paramy = (d.l.b.a.b.m.a.i)i.a.NDe;
    }
    AppMethodBeat.o(60157);
    return paramy;
  }
  
  public static final boolean e(y paramy)
  {
    AppMethodBeat.i(60158);
    p.h(paramy, "$this$isTypeRefinementEnabled");
    paramy = (r)paramy.a(d.l.b.a.b.m.a.j.gug());
    if (paramy != null) {}
    for (paramy = (d.l.b.a.b.m.a.i)paramy.value; paramy != null; paramy = null)
    {
      AppMethodBeat.o(60158);
      return true;
    }
    AppMethodBeat.o(60158);
    return false;
  }
  
  public static final e l(d.l.b.a.b.b.a.c paramc)
  {
    AppMethodBeat.i(60155);
    p.h(paramc, "$this$annotationClass");
    d.l.b.a.b.b.h localh = paramc.gju().gsZ().ghO();
    paramc = localh;
    if (!(localh instanceof e)) {
      paramc = null;
    }
    paramc = (e)paramc;
    AppMethodBeat.o(60155);
    return paramc;
  }
  
  public static final d.l.b.a.b.j.b.g<?> m(d.l.b.a.b.b.a.c paramc)
  {
    AppMethodBeat.i(60156);
    p.h(paramc, "$this$firstArgument");
    paramc = (d.l.b.a.b.j.b.g)d.a.j.d((Iterable)paramc.gjK().values());
    AppMethodBeat.o(60156);
    return paramc;
  }
  
  public static final d.l.b.a.b.f.b o(l paraml)
  {
    AppMethodBeat.i(60143);
    p.h(paraml, "$this$fqNameSafe");
    paraml = d.l.b.a.b.j.c.o(paraml);
    p.g(paraml, "DescriptorUtils.getFqNameSafe(this)");
    AppMethodBeat.o(60143);
    return paraml;
  }
  
  public static final d.l.b.a.b.f.c q(l paraml)
  {
    AppMethodBeat.i(60142);
    p.h(paraml, "$this$fqNameUnsafe");
    paraml = d.l.b.a.b.j.c.n(paraml);
    p.g(paraml, "DescriptorUtils.getFqName(this)");
    AppMethodBeat.o(60142);
    return paraml;
  }
  
  public static final d.l.b.a.b.b.b v(d.l.b.a.b.b.b paramb)
  {
    AppMethodBeat.i(60151);
    p.h(paramb, "$this$propertyIfAccessor");
    if ((paramb instanceof ag))
    {
      paramb = ((ag)paramb).gji();
      p.g(paramb, "correspondingProperty");
      paramb = (d.l.b.a.b.b.b)paramb;
      AppMethodBeat.o(60151);
      return paramb;
    }
    AppMethodBeat.o(60151);
    return paramb;
  }
  
  static final class a
    extends q
    implements m<d.l.b.a.b.j.f.h, Boolean, z>
  {
    a(e parame, LinkedHashSet paramLinkedHashSet)
    {
      super();
    }
    
    public final void a(d.l.b.a.b.j.f.h paramh, boolean paramBoolean)
    {
      AppMethodBeat.i(60131);
      p.h(paramh, "scope");
      paramh = j.a.a(paramh, d.NxG, null, 2).iterator();
      while (paramh.hasNext())
      {
        Object localObject = (l)paramh.next();
        if ((localObject instanceof e))
        {
          if (d.l.b.a.b.j.c.b((e)localObject, this.NwL)) {
            localLinkedHashSet.add(localObject);
          }
          if (paramBoolean)
          {
            a locala = (a)this;
            localObject = ((e)localObject).giJ();
            p.g(localObject, "descriptor.unsubstitutedInnerClassesScope");
            locala.a((d.l.b.a.b.j.f.h)localObject, paramBoolean);
          }
        }
      }
      AppMethodBeat.o(60131);
    }
  }
  
  static final class b<N>
    implements b.b<N>
  {
    public static final b NwN;
    
    static
    {
      AppMethodBeat.i(60133);
      NwN = new b();
      AppMethodBeat.o(60133);
    }
  }
  
  static final class d<N>
    implements b.b<N>
  {}
  
  public static final class e
    extends b.a<d.l.b.a.b.b.b, d.l.b.a.b.b.b>
  {
    e(y.f paramf, d.g.a.b paramb) {}
  }
  
  static final class f
    extends q
    implements d.g.a.b<l, l>
  {
    public static final f NwR;
    
    static
    {
      AppMethodBeat.i(60141);
      NwR = new f();
      AppMethodBeat.o(60141);
    }
    
    f()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.j.d.a
 * JD-Core Version:    0.7.0.1
 */