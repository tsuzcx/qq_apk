package d.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.g.b.q;
import d.l.b.a.b.a.g;
import d.l.b.a.b.b.ag;
import d.l.b.a.b.b.ah;
import d.l.b.a.b.b.am;
import d.l.b.a.b.b.l;
import d.l.b.a.b.f.f;
import d.l.b.a.b.m.a.w;
import d.l.b.a.b.m.ab;
import java.util.List;
import java.util.Set;

public final class t
{
  static final r B(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(57634);
    f localf = f.bei(paramString2);
    p.g(localf, "Name.identifier(name)");
    d.l.b.a.b.d.b.v localv = d.l.b.a.b.d.b.v.NGm;
    paramString1 = new r(localf, d.l.b.a.b.d.b.v.nB(paramString1, paramString2 + '(' + paramString3 + ')' + paramString4));
    AppMethodBeat.o(57634);
    return paramString1;
  }
  
  static final d.l.b.a.b.f.b a(d.l.b.a.b.f.b paramb, String paramString)
  {
    AppMethodBeat.i(57632);
    paramb = paramb.p(f.bei(paramString));
    p.g(paramb, "child(Name.identifier(name))");
    AppMethodBeat.o(57632);
    return paramb;
  }
  
  public static final boolean a(d.l.b.a.b.b.e parame, d.l.b.a.b.b.a parama)
  {
    AppMethodBeat.i(57640);
    p.h(parame, "$this$hasRealKotlinSuperClassWithOverrideOf");
    p.h(parama, "specialCallableDescriptor");
    parama = parama.glU();
    if (parama == null)
    {
      parame = new d.v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
      AppMethodBeat.o(57640);
      throw parame;
    }
    parama = ((d.l.b.a.b.b.e)parama).gne();
    p.g(parama, "(specialCallableDescript…ssDescriptor).defaultType");
    for (parame = d.l.b.a.b.j.c.y(parame); parame != null; parame = d.l.b.a.b.j.c.y(parame)) {
      if (!(parame instanceof d.l.b.a.b.d.a.b.d))
      {
        int i;
        if (w.f((ab)parame.gne(), (ab)parama) != null) {
          i = 1;
        }
        while (i != 0) {
          if (!g.c((l)parame))
          {
            AppMethodBeat.o(57640);
            return true;
            i = 0;
          }
          else
          {
            AppMethodBeat.o(57640);
            return false;
          }
        }
      }
    }
    AppMethodBeat.o(57640);
    return false;
  }
  
  static final d.l.b.a.b.f.b b(d.l.b.a.b.f.c paramc, String paramString)
  {
    AppMethodBeat.i(57633);
    paramc = paramc.s(f.bei(paramString)).gvM();
    p.g(paramc, "child(Name.identifier(name)).toSafe()");
    AppMethodBeat.o(57633);
    return paramc;
  }
  
  public static final <T extends d.l.b.a.b.b.b> T m(T paramT)
  {
    AppMethodBeat.i(57635);
    p.h(paramT, "$this$getOverriddenBuiltinWithDifferentJvmName");
    Object localObject = c.NyM;
    if (!c.gpP().contains(paramT.gnf()))
    {
      localObject = e.Nzn;
      if (!e.gpR().contains(d.l.b.a.b.j.d.a.v(paramT).gnf()))
      {
        AppMethodBeat.o(57635);
        return null;
      }
    }
    if (((paramT instanceof ah)) || ((paramT instanceof ag)))
    {
      paramT = d.l.b.a.b.j.d.a.b(paramT, (d.g.a.b)a.NAb);
      AppMethodBeat.o(57635);
      return paramT;
    }
    if ((paramT instanceof am))
    {
      paramT = d.l.b.a.b.j.d.a.b(paramT, (d.g.a.b)b.NAc);
      AppMethodBeat.o(57635);
      return paramT;
    }
    AppMethodBeat.o(57635);
    return null;
  }
  
  public static final boolean n(d.l.b.a.b.b.b paramb)
  {
    AppMethodBeat.i(57636);
    p.h(paramb, "$this$doesOverrideBuiltinWithDifferentJvmName");
    if (m(paramb) != null)
    {
      AppMethodBeat.o(57636);
      return true;
    }
    AppMethodBeat.o(57636);
    return false;
  }
  
  public static final <T extends d.l.b.a.b.b.b> T o(T paramT)
  {
    AppMethodBeat.i(57637);
    p.h(paramT, "$this$getOverriddenSpecialBuiltin");
    Object localObject = m(paramT);
    if (localObject != null)
    {
      AppMethodBeat.o(57637);
      return localObject;
    }
    localObject = d.NyV;
    localObject = paramT.gnf();
    p.g(localObject, "name");
    if (!d.g((f)localObject))
    {
      AppMethodBeat.o(57637);
      return null;
    }
    paramT = d.l.b.a.b.j.d.a.b(paramT, (d.g.a.b)c.NAd);
    AppMethodBeat.o(57637);
    return paramT;
  }
  
  public static final String p(d.l.b.a.b.b.b paramb)
  {
    AppMethodBeat.i(57638);
    p.h(paramb, "callableMemberDescriptor");
    paramb = q(paramb);
    if (paramb != null)
    {
      paramb = d.l.b.a.b.j.d.a.v(paramb);
      if (paramb != null) {}
    }
    else
    {
      AppMethodBeat.o(57638);
      return null;
    }
    Object localObject;
    if ((paramb instanceof ah))
    {
      localObject = e.Nzn;
      paramb = e.l(paramb);
      AppMethodBeat.o(57638);
      return paramb;
    }
    if ((paramb instanceof am))
    {
      localObject = c.NyM;
      paramb = c.a((am)paramb);
      if (paramb != null)
      {
        paramb = paramb.sD();
        AppMethodBeat.o(57638);
        return paramb;
      }
    }
    AppMethodBeat.o(57638);
    return null;
  }
  
  private static final d.l.b.a.b.b.b q(d.l.b.a.b.b.b paramb)
  {
    AppMethodBeat.i(57639);
    if (g.c((l)paramb))
    {
      paramb = m(paramb);
      AppMethodBeat.o(57639);
      return paramb;
    }
    AppMethodBeat.o(57639);
    return null;
  }
  
  public static final boolean r(d.l.b.a.b.b.b paramb)
  {
    AppMethodBeat.i(57641);
    p.h(paramb, "$this$isFromJavaOrBuiltins");
    p.h(paramb, "$this$isFromJava");
    if (((d.l.b.a.b.j.d.a.v(paramb).glU() instanceof d.l.b.a.b.d.a.b.d)) || (g.c((l)paramb)))
    {
      AppMethodBeat.o(57641);
      return true;
    }
    AppMethodBeat.o(57641);
    return false;
  }
  
  static final class a
    extends q
    implements d.g.a.b<d.l.b.a.b.b.b, Boolean>
  {
    public static final a NAb;
    
    static
    {
      AppMethodBeat.i(57627);
      NAb = new a();
      AppMethodBeat.o(57627);
    }
    
    a()
    {
      super();
    }
  }
  
  static final class b
    extends q
    implements d.g.a.b<d.l.b.a.b.b.b, Boolean>
  {
    public static final b NAc;
    
    static
    {
      AppMethodBeat.i(57629);
      NAc = new b();
      AppMethodBeat.o(57629);
    }
    
    b()
    {
      super();
    }
  }
  
  static final class c
    extends q
    implements d.g.a.b<d.l.b.a.b.b.b, Boolean>
  {
    public static final c NAd;
    
    static
    {
      AppMethodBeat.i(57631);
      NAd = new c();
      AppMethodBeat.o(57631);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.a.t
 * JD-Core Version:    0.7.0.1
 */