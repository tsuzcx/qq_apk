package kotlin.l.b.a.b.j.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.ak;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.l.b.a.b.b.ae;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.ao;
import kotlin.l.b.a.b.b.bd;
import kotlin.l.b.a.b.b.i;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.m.a.g.a;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.o.b.a;
import kotlin.l.b.a.b.o.b.b;
import kotlin.m.k;

public final class a
{
  private static final f ajjV;
  
  static
  {
    AppMethodBeat.i(60159);
    f localf = f.bJe("value");
    s.s(localf, "identifier(\"value\")");
    ajjV = localf;
    AppMethodBeat.o(60159);
  }
  
  public static final kotlin.l.b.a.b.b.e C(kotlin.l.b.a.b.b.e parame)
  {
    AppMethodBeat.i(60147);
    s.u(parame, "<this>");
    parame = parame.koj().kzm().kpG().iterator();
    while (parame.hasNext())
    {
      Object localObject = (ad)parame.next();
      if (!kotlin.l.b.a.b.a.h.s((ad)localObject))
      {
        localObject = ((ad)localObject).kzm().knA();
        if (kotlin.l.b.a.b.j.d.B((l)localObject))
        {
          if (localObject == null)
          {
            parame = new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            AppMethodBeat.o(60147);
            throw parame;
          }
          parame = (kotlin.l.b.a.b.b.e)localObject;
          AppMethodBeat.o(60147);
          return parame;
        }
      }
    }
    AppMethodBeat.o(60147);
    return null;
  }
  
  public static final ae F(l paraml)
  {
    AppMethodBeat.i(60144);
    s.u(paraml, "<this>");
    paraml = kotlin.l.b.a.b.j.d.s(paraml);
    s.s(paraml, "getContainingModule(this)");
    AppMethodBeat.o(60144);
    return paraml;
  }
  
  public static final kotlin.l.b.a.b.a.h G(l paraml)
  {
    AppMethodBeat.i(60148);
    s.u(paraml, "<this>");
    paraml = F(paraml).koV();
    AppMethodBeat.o(60148);
    return paraml;
  }
  
  public static final kotlin.m.h<l> H(l paraml)
  {
    AppMethodBeat.i(60150);
    s.u(paraml, "<this>");
    s.u(paraml, "<this>");
    paraml = k.b(paraml, (kotlin.g.a.b)e.ajka);
    s.u(paraml, "$this$drop");
    if ((paraml instanceof kotlin.m.c))
    {
      paraml = ((kotlin.m.c)paraml).kBi();
      AppMethodBeat.o(60150);
      return paraml;
    }
    paraml = (kotlin.m.h)new kotlin.m.b(paraml, 1);
    AppMethodBeat.o(60150);
    return paraml;
  }
  
  public static final kotlin.l.b.a.b.f.c I(l paraml)
  {
    AppMethodBeat.i(60152);
    s.u(paraml, "<this>");
    paraml = q(paraml);
    if (paraml.kxW()) {}
    while (paraml == null)
    {
      AppMethodBeat.o(60152);
      return null;
      paraml = null;
    }
    paraml = paraml.kxX();
    AppMethodBeat.o(60152);
    return paraml;
  }
  
  public static final kotlin.l.b.a.b.b.e b(ae paramae, kotlin.l.b.a.b.f.c paramc, kotlin.l.b.a.b.c.a.b paramb)
  {
    AppMethodBeat.i(60145);
    s.u(paramae, "<this>");
    s.u(paramc, "topLevelClassFqName");
    s.u(paramb, "location");
    if (!paramc.isRoot()) {}
    for (int i = 1; (ak.aiuY) && (i == 0); i = 0)
    {
      paramae = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(60145);
      throw paramae;
    }
    kotlin.l.b.a.b.f.c localc = paramc.kxS();
    s.s(localc, "topLevelClassFqName.parent()");
    paramae = paramae.e(localc).knP();
    paramc = paramc.kxT();
    s.s(paramc, "topLevelClassFqName.shortName()");
    paramae = paramae.c(paramc, paramb);
    if ((paramae instanceof kotlin.l.b.a.b.b.e))
    {
      paramae = (kotlin.l.b.a.b.b.e)paramae;
      AppMethodBeat.o(60145);
      return paramae;
    }
    AppMethodBeat.o(60145);
    return null;
  }
  
  public static final boolean b(bd parambd)
  {
    AppMethodBeat.i(60149);
    s.u(parambd, "<this>");
    parambd = kotlin.l.b.a.b.o.b.a((Collection)kotlin.a.p.listOf(parambd), (b.b)a.ajjW, (kotlin.g.a.b)b.ajjX);
    s.s(parambd, "ifAny(\n        listOf(th…eclaresDefaultValue\n    )");
    boolean bool = parambd.booleanValue();
    AppMethodBeat.o(60149);
    return bool;
  }
  
  public static final kotlin.l.b.a.b.f.b d(kotlin.l.b.a.b.b.h paramh)
  {
    AppMethodBeat.i(60146);
    if (paramh != null)
    {
      Object localObject = paramh.knp();
      if (localObject != null)
      {
        if ((localObject instanceof ah))
        {
          paramh = new kotlin.l.b.a.b.f.b(((ah)localObject).koY(), paramh.kok());
          AppMethodBeat.o(60146);
          return paramh;
        }
        if ((localObject instanceof i))
        {
          localObject = d((kotlin.l.b.a.b.b.h)localObject);
          if (localObject != null)
          {
            paramh = ((kotlin.l.b.a.b.f.b)localObject).p(paramh.kok());
            AppMethodBeat.o(60146);
            return paramh;
          }
        }
      }
    }
    AppMethodBeat.o(60146);
    return null;
  }
  
  public static final kotlin.l.b.a.b.m.a.g e(ae paramae)
  {
    AppMethodBeat.i(60157);
    s.u(paramae, "<this>");
    paramae = (kotlin.l.b.a.b.m.a.p)paramae.a(kotlin.l.b.a.b.m.a.h.kAS());
    if (paramae == null) {}
    for (paramae = null; paramae == null; paramae = (kotlin.l.b.a.b.m.a.g)paramae.value)
    {
      paramae = (kotlin.l.b.a.b.m.a.g)g.a.ajra;
      AppMethodBeat.o(60157);
      return paramae;
    }
    AppMethodBeat.o(60157);
    return paramae;
  }
  
  public static final boolean f(ae paramae)
  {
    AppMethodBeat.i(60158);
    s.u(paramae, "<this>");
    paramae = (kotlin.l.b.a.b.m.a.p)paramae.a(kotlin.l.b.a.b.m.a.h.kAS());
    if (paramae == null) {}
    for (paramae = null; paramae != null; paramae = (kotlin.l.b.a.b.m.a.g)paramae.value)
    {
      AppMethodBeat.o(60158);
      return true;
    }
    AppMethodBeat.o(60158);
    return false;
  }
  
  public static final kotlin.l.b.a.b.b.e j(kotlin.l.b.a.b.b.a.c paramc)
  {
    AppMethodBeat.i(60155);
    s.u(paramc, "<this>");
    paramc = paramc.koG().kzm().knA();
    if ((paramc instanceof kotlin.l.b.a.b.b.e))
    {
      paramc = (kotlin.l.b.a.b.b.e)paramc;
      AppMethodBeat.o(60155);
      return paramc;
    }
    AppMethodBeat.o(60155);
    return null;
  }
  
  public static final kotlin.l.b.a.b.j.b.g<?> k(kotlin.l.b.a.b.b.a.c paramc)
  {
    AppMethodBeat.i(60156);
    s.u(paramc, "<this>");
    paramc = (kotlin.l.b.a.b.j.b.g)kotlin.a.p.f((Iterable)paramc.kpA().values());
    AppMethodBeat.o(60156);
    return paramc;
  }
  
  public static final kotlin.l.b.a.b.f.c o(l paraml)
  {
    AppMethodBeat.i(60143);
    s.u(paraml, "<this>");
    paraml = kotlin.l.b.a.b.j.d.o(paraml);
    s.s(paraml, "getFqNameSafe(this)");
    AppMethodBeat.o(60143);
    return paraml;
  }
  
  public static final kotlin.l.b.a.b.f.d q(l paraml)
  {
    AppMethodBeat.i(60142);
    s.u(paraml, "<this>");
    paraml = kotlin.l.b.a.b.j.d.n(paraml);
    s.s(paraml, "getFqName(this)");
    AppMethodBeat.o(60142);
    return paraml;
  }
  
  public static final kotlin.l.b.a.b.b.b v(kotlin.l.b.a.b.b.b paramb)
  {
    AppMethodBeat.i(60151);
    s.u(paramb, "<this>");
    if ((paramb instanceof ao))
    {
      paramb = ((ao)paramb).kpb();
      s.s(paramb, "correspondingProperty");
      paramb = (kotlin.l.b.a.b.b.b)paramb;
      AppMethodBeat.o(60151);
      return paramb;
    }
    AppMethodBeat.o(60151);
    return paramb;
  }
  
  static final class a<N>
    implements b.b
  {
    public static final a<N> ajjW;
    
    static
    {
      AppMethodBeat.i(60133);
      ajjW = new a();
      AppMethodBeat.o(60133);
    }
  }
  
  static final class c<N>
    implements b.b
  {}
  
  public static final class d
    extends b.a<kotlin.l.b.a.b.b.b, kotlin.l.b.a.b.b.b>
  {
    d(ah.f<kotlin.l.b.a.b.b.b> paramf, kotlin.g.a.b<? super kotlin.l.b.a.b.b.b, Boolean> paramb) {}
  }
  
  static final class e
    extends u
    implements kotlin.g.a.b<l, l>
  {
    public static final e ajka;
    
    static
    {
      AppMethodBeat.i(60141);
      ajka = new e();
      AppMethodBeat.o(60141);
    }
    
    e()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.j.d.a
 * JD-Core Version:    0.7.0.1
 */