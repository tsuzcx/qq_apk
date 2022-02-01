package kotlin.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.b.ag;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.d.b.v;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.m.a.w;
import kotlin.l.b.a.b.m.ab;

public final class t
{
  static final r O(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(57634);
    f localf = f.bHb(paramString2);
    p.j(localf, "Name.identifier(name)");
    v localv = v.aaYI;
    paramString1 = new r(localf, v.pq(paramString1, paramString2 + '(' + paramString3 + ')' + paramString4));
    AppMethodBeat.o(57634);
    return paramString1;
  }
  
  static final kotlin.l.b.a.b.f.b a(kotlin.l.b.a.b.f.b paramb, String paramString)
  {
    AppMethodBeat.i(57632);
    paramb = paramb.p(f.bHb(paramString));
    p.j(paramb, "child(Name.identifier(name))");
    AppMethodBeat.o(57632);
    return paramb;
  }
  
  public static final boolean a(kotlin.l.b.a.b.b.e parame, kotlin.l.b.a.b.b.a parama)
  {
    AppMethodBeat.i(57640);
    p.k(parame, "$this$hasRealKotlinSuperClassWithOverrideOf");
    p.k(parama, "specialCallableDescriptor");
    parama = parama.iDJ();
    if (parama == null)
    {
      parame = new kotlin.t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
      AppMethodBeat.o(57640);
      throw parame;
    }
    parama = ((kotlin.l.b.a.b.b.e)parama).iET();
    p.j(parama, "(specialCallableDescript…ssDescriptor).defaultType");
    for (parame = kotlin.l.b.a.b.j.c.y(parame); parame != null; parame = kotlin.l.b.a.b.j.c.y(parame)) {
      if (!(parame instanceof kotlin.l.b.a.b.d.a.b.d))
      {
        int i;
        if (w.f((ab)parame.iET(), (ab)parama) != null) {
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
  
  static final kotlin.l.b.a.b.f.b b(kotlin.l.b.a.b.f.c paramc, String paramString)
  {
    AppMethodBeat.i(57633);
    paramc = paramc.s(f.bHb(paramString)).iND();
    p.j(paramc, "child(Name.identifier(name)).toSafe()");
    AppMethodBeat.o(57633);
    return paramc;
  }
  
  public static final <T extends kotlin.l.b.a.b.b.b> T m(T paramT)
  {
    AppMethodBeat.i(57635);
    p.k(paramT, "$this$getOverriddenBuiltinWithDifferentJvmName");
    Object localObject = c.aaRo;
    if (!c.iHK().contains(paramT.iEU()))
    {
      localObject = e.aaRP;
      if (!e.iHM().contains(kotlin.l.b.a.b.j.d.a.v(paramT).iEU()))
      {
        AppMethodBeat.o(57635);
        return null;
      }
    }
    if (((paramT instanceof ah)) || ((paramT instanceof ag)))
    {
      paramT = kotlin.l.b.a.b.j.d.a.b(paramT, (kotlin.g.a.b)a.aaSD);
      AppMethodBeat.o(57635);
      return paramT;
    }
    if ((paramT instanceof am))
    {
      paramT = kotlin.l.b.a.b.j.d.a.b(paramT, (kotlin.g.a.b)b.aaSE);
      AppMethodBeat.o(57635);
      return paramT;
    }
    AppMethodBeat.o(57635);
    return null;
  }
  
  public static final boolean n(kotlin.l.b.a.b.b.b paramb)
  {
    AppMethodBeat.i(57636);
    p.k(paramb, "$this$doesOverrideBuiltinWithDifferentJvmName");
    if (m(paramb) != null)
    {
      AppMethodBeat.o(57636);
      return true;
    }
    AppMethodBeat.o(57636);
    return false;
  }
  
  public static final <T extends kotlin.l.b.a.b.b.b> T o(T paramT)
  {
    AppMethodBeat.i(57637);
    p.k(paramT, "$this$getOverriddenSpecialBuiltin");
    Object localObject = m(paramT);
    if (localObject != null)
    {
      AppMethodBeat.o(57637);
      return localObject;
    }
    localObject = d.aaRx;
    localObject = paramT.iEU();
    p.j(localObject, "name");
    if (!d.g((f)localObject))
    {
      AppMethodBeat.o(57637);
      return null;
    }
    paramT = kotlin.l.b.a.b.j.d.a.b(paramT, (kotlin.g.a.b)c.aaSF);
    AppMethodBeat.o(57637);
    return paramT;
  }
  
  public static final String p(kotlin.l.b.a.b.b.b paramb)
  {
    AppMethodBeat.i(57638);
    p.k(paramb, "callableMemberDescriptor");
    paramb = q(paramb);
    if (paramb != null)
    {
      paramb = kotlin.l.b.a.b.j.d.a.v(paramb);
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
      localObject = e.aaRP;
      paramb = e.l(paramb);
      AppMethodBeat.o(57638);
      return paramb;
    }
    if ((paramb instanceof am))
    {
      localObject = c.aaRo;
      paramb = c.a((am)paramb);
      if (paramb != null)
      {
        paramb = paramb.qu();
        AppMethodBeat.o(57638);
        return paramb;
      }
    }
    AppMethodBeat.o(57638);
    return null;
  }
  
  private static final kotlin.l.b.a.b.b.b q(kotlin.l.b.a.b.b.b paramb)
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
  
  public static final boolean r(kotlin.l.b.a.b.b.b paramb)
  {
    AppMethodBeat.i(57641);
    p.k(paramb, "$this$isFromJavaOrBuiltins");
    p.k(paramb, "$this$isFromJava");
    if (((kotlin.l.b.a.b.j.d.a.v(paramb).iDJ() instanceof kotlin.l.b.a.b.d.a.b.d)) || (g.c((l)paramb)))
    {
      AppMethodBeat.o(57641);
      return true;
    }
    AppMethodBeat.o(57641);
    return false;
  }
  
  static final class a
    extends q
    implements kotlin.g.a.b<kotlin.l.b.a.b.b.b, Boolean>
  {
    public static final a aaSD;
    
    static
    {
      AppMethodBeat.i(57627);
      aaSD = new a();
      AppMethodBeat.o(57627);
    }
    
    a()
    {
      super();
    }
  }
  
  static final class b
    extends q
    implements kotlin.g.a.b<kotlin.l.b.a.b.b.b, Boolean>
  {
    public static final b aaSE;
    
    static
    {
      AppMethodBeat.i(57629);
      aaSE = new b();
      AppMethodBeat.o(57629);
    }
    
    b()
    {
      super();
    }
  }
  
  static final class c
    extends q
    implements kotlin.g.a.b<kotlin.l.b.a.b.b.b, Boolean>
  {
    public static final c aaSF;
    
    static
    {
      AppMethodBeat.i(57631);
      aaSF = new c();
      AppMethodBeat.o(57631);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.t
 * JD-Core Version:    0.7.0.1
 */