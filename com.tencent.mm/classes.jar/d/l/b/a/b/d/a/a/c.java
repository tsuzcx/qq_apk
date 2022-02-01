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
  private static final d.l.b.a.b.f.b Lmk;
  private static final d.l.b.a.b.f.b Lml;
  private static final d.l.b.a.b.f.b Lmm;
  private static final d.l.b.a.b.f.b Lmn;
  private static final d.l.b.a.b.f.b Lmo;
  private static final f Lmp;
  private static final f Lmq;
  private static final f Lmr;
  private static final Map<d.l.b.a.b.f.b, d.l.b.a.b.f.b> Lms;
  private static final Map<d.l.b.a.b.f.b, d.l.b.a.b.f.b> Lmt;
  public static final c Lmu;
  
  static
  {
    AppMethodBeat.i(57660);
    Lmu = new c();
    Lmk = new d.l.b.a.b.f.b(Target.class.getCanonicalName());
    Lml = new d.l.b.a.b.f.b(Retention.class.getCanonicalName());
    Lmm = new d.l.b.a.b.f.b(Deprecated.class.getCanonicalName());
    Lmn = new d.l.b.a.b.f.b(Documented.class.getCanonicalName());
    Lmo = new d.l.b.a.b.f.b("java.lang.annotation.Repeatable");
    f localf = f.aWB("message");
    k.g(localf, "Name.identifier(\"message\")");
    Lmp = localf;
    localf = f.aWB("allowedTargets");
    k.g(localf, "Name.identifier(\"allowedTargets\")");
    Lmq = localf;
    localf = f.aWB("value");
    k.g(localf, "Name.identifier(\"value\")");
    Lmr = localf;
    Lms = ae.a(new o[] { u.Q(g.KZg.KZN, Lmk), u.Q(g.KZg.KZQ, Lml), u.Q(g.KZg.KZR, Lmo), u.Q(g.KZg.KZS, Lmn) });
    Lmt = ae.a(new o[] { u.Q(Lmk, g.KZg.KZN), u.Q(Lml, g.KZg.KZQ), u.Q(Lmm, g.KZg.KZH), u.Q(Lmo, g.KZg.KZR), u.Q(Lmn, g.KZg.KZS) });
    AppMethodBeat.o(57660);
  }
  
  public static d.l.b.a.b.b.a.c a(d.l.b.a.b.d.a.e.a parama, d.l.b.a.b.d.a.c.h paramh)
  {
    AppMethodBeat.i(57658);
    k.h(parama, "annotation");
    k.h(paramh, "c");
    Object localObject = parama.fOT();
    if (k.g(localObject, d.l.b.a.b.f.a.p(Lmk)))
    {
      parama = (d.l.b.a.b.b.a.c)new i(parama, paramh);
      AppMethodBeat.o(57658);
      return parama;
    }
    if (k.g(localObject, d.l.b.a.b.f.a.p(Lml)))
    {
      parama = (d.l.b.a.b.b.a.c)new h(parama, paramh);
      AppMethodBeat.o(57658);
      return parama;
    }
    if (k.g(localObject, d.l.b.a.b.f.a.p(Lmo)))
    {
      localObject = g.KZg.KZR;
      k.g(localObject, "KotlinBuiltIns.FQ_NAMES.repeatable");
      parama = (d.l.b.a.b.b.a.c)new b(paramh, parama, (d.l.b.a.b.f.b)localObject);
      AppMethodBeat.o(57658);
      return parama;
    }
    if (k.g(localObject, d.l.b.a.b.f.a.p(Lmn)))
    {
      localObject = g.KZg.KZS;
      k.g(localObject, "KotlinBuiltIns.FQ_NAMES.mustBeDocumented");
      parama = (d.l.b.a.b.b.a.c)new b(paramh, parama, (d.l.b.a.b.f.b)localObject);
      AppMethodBeat.o(57658);
      return parama;
    }
    if (k.g(localObject, d.l.b.a.b.f.a.p(Lmm)))
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
    if (k.g(paramb, g.KZg.KZH))
    {
      d.l.b.a.b.d.a.e.a locala = paramd.l(Lmm);
      if (locala != null)
      {
        paramb = (d.l.b.a.b.b.a.c)new e(locala, paramh);
        AppMethodBeat.o(57659);
        return paramb;
      }
    }
    paramb = (d.l.b.a.b.f.b)Lms.get(paramb);
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
  
  public static f fUd()
  {
    return Lmp;
  }
  
  public static f fUe()
  {
    return Lmq;
  }
  
  public static f fUf()
  {
    return Lmr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.a.a.c
 * JD-Core Version:    0.7.0.1
 */