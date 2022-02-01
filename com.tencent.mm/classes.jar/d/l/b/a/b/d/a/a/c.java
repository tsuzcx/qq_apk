package d.l.b.a.b.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ae;
import d.g.b.k;
import d.l.b.a.b.a.g;
import d.l.b.a.b.a.g.a;
import d.l.b.a.b.d.a.e.d;
import d.l.b.a.b.f.f;
import d.o;
import d.u;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.Map;

public final class c
{
  private static final d.l.b.a.b.f.b JyR;
  private static final d.l.b.a.b.f.b JyS;
  private static final d.l.b.a.b.f.b JyT;
  private static final d.l.b.a.b.f.b JyU;
  private static final d.l.b.a.b.f.b JyV;
  private static final f JyW;
  private static final f JyX;
  private static final f JyY;
  private static final Map<d.l.b.a.b.f.b, d.l.b.a.b.f.b> JyZ;
  private static final Map<d.l.b.a.b.f.b, d.l.b.a.b.f.b> Jza;
  public static final c Jzb;
  
  static
  {
    AppMethodBeat.i(57660);
    Jzb = new c();
    JyR = new d.l.b.a.b.f.b(Target.class.getCanonicalName());
    JyS = new d.l.b.a.b.f.b(Retention.class.getCanonicalName());
    JyT = new d.l.b.a.b.f.b(Deprecated.class.getCanonicalName());
    JyU = new d.l.b.a.b.f.b(Documented.class.getCanonicalName());
    JyV = new d.l.b.a.b.f.b("java.lang.annotation.Repeatable");
    f localf = f.aQC("message");
    k.g(localf, "Name.identifier(\"message\")");
    JyW = localf;
    localf = f.aQC("allowedTargets");
    k.g(localf, "Name.identifier(\"allowedTargets\")");
    JyX = localf;
    localf = f.aQC("value");
    k.g(localf, "Name.identifier(\"value\")");
    JyY = localf;
    JyZ = ae.a(new o[] { u.P(g.JlM.Jmt, JyR), u.P(g.JlM.Jmw, JyS), u.P(g.JlM.Jmx, JyV), u.P(g.JlM.Jmy, JyU) });
    Jza = ae.a(new o[] { u.P(JyR, g.JlM.Jmt), u.P(JyS, g.JlM.Jmw), u.P(JyT, g.JlM.Jmn), u.P(JyV, g.JlM.Jmx), u.P(JyU, g.JlM.Jmy) });
    AppMethodBeat.o(57660);
  }
  
  public static d.l.b.a.b.b.a.c a(d.l.b.a.b.d.a.e.a parama, d.l.b.a.b.d.a.c.h paramh)
  {
    AppMethodBeat.i(57658);
    k.h(parama, "annotation");
    k.h(paramh, "c");
    Object localObject = parama.fwp();
    if (k.g(localObject, d.l.b.a.b.f.a.p(JyR)))
    {
      parama = (d.l.b.a.b.b.a.c)new i(parama, paramh);
      AppMethodBeat.o(57658);
      return parama;
    }
    if (k.g(localObject, d.l.b.a.b.f.a.p(JyS)))
    {
      parama = (d.l.b.a.b.b.a.c)new h(parama, paramh);
      AppMethodBeat.o(57658);
      return parama;
    }
    if (k.g(localObject, d.l.b.a.b.f.a.p(JyV)))
    {
      localObject = g.JlM.Jmx;
      k.g(localObject, "KotlinBuiltIns.FQ_NAMES.repeatable");
      parama = (d.l.b.a.b.b.a.c)new b(paramh, parama, (d.l.b.a.b.f.b)localObject);
      AppMethodBeat.o(57658);
      return parama;
    }
    if (k.g(localObject, d.l.b.a.b.f.a.p(JyU)))
    {
      localObject = g.JlM.Jmy;
      k.g(localObject, "KotlinBuiltIns.FQ_NAMES.mustBeDocumented");
      parama = (d.l.b.a.b.b.a.c)new b(paramh, parama, (d.l.b.a.b.f.b)localObject);
      AppMethodBeat.o(57658);
      return parama;
    }
    if (k.g(localObject, d.l.b.a.b.f.a.p(JyT)))
    {
      AppMethodBeat.o(57658);
      return null;
    }
    parama = (d.l.b.a.b.b.a.c)new d.l.b.a.b.d.a.c.a.e(paramh, parama);
    AppMethodBeat.o(57658);
    return parama;
  }
  
  public static d.l.b.a.b.b.a.c a(d.l.b.a.b.f.b paramb, d paramd, d.l.b.a.b.d.a.c.h paramh)
  {
    AppMethodBeat.i(57659);
    k.h(paramb, "kotlinName");
    k.h(paramd, "annotationOwner");
    k.h(paramh, "c");
    if (k.g(paramb, g.JlM.Jmn))
    {
      d.l.b.a.b.d.a.e.a locala = paramd.l(JyT);
      if (locala != null)
      {
        paramb = (d.l.b.a.b.b.a.c)new e(locala, paramh);
        AppMethodBeat.o(57659);
        return paramb;
      }
    }
    paramb = (d.l.b.a.b.f.b)JyZ.get(paramb);
    if (paramb != null)
    {
      paramb = paramd.l(paramb);
      if (paramb != null)
      {
        paramb = a(paramb, paramh);
        AppMethodBeat.o(57659);
        return paramb;
      }
      AppMethodBeat.o(57659);
      return null;
    }
    AppMethodBeat.o(57659);
    return null;
  }
  
  public static f fBA()
  {
    return JyX;
  }
  
  public static f fBB()
  {
    return JyY;
  }
  
  public static f fBz()
  {
    return JyW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.d.a.a.c
 * JD-Core Version:    0.7.0.1
 */