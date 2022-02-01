package d.l.b.a.b.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ae;
import d.g.b.p;
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
  private static final d.l.b.a.b.f.b NAm;
  private static final d.l.b.a.b.f.b NAn;
  private static final d.l.b.a.b.f.b NAo;
  private static final d.l.b.a.b.f.b NAp;
  private static final d.l.b.a.b.f.b NAq;
  private static final f NAr;
  private static final f NAs;
  private static final f NAt;
  private static final Map<d.l.b.a.b.f.b, d.l.b.a.b.f.b> NAu;
  private static final Map<d.l.b.a.b.f.b, d.l.b.a.b.f.b> NAv;
  public static final c NAw;
  
  static
  {
    AppMethodBeat.i(57660);
    NAw = new c();
    NAm = new d.l.b.a.b.f.b(Target.class.getCanonicalName());
    NAn = new d.l.b.a.b.f.b(Retention.class.getCanonicalName());
    NAo = new d.l.b.a.b.f.b(Deprecated.class.getCanonicalName());
    NAp = new d.l.b.a.b.f.b(Documented.class.getCanonicalName());
    NAq = new d.l.b.a.b.f.b("java.lang.annotation.Repeatable");
    f localf = f.bei("message");
    p.g(localf, "Name.identifier(\"message\")");
    NAr = localf;
    localf = f.bei("allowedTargets");
    p.g(localf, "Name.identifier(\"allowedTargets\")");
    NAs = localf;
    localf = f.bei("value");
    p.g(localf, "Name.identifier(\"value\")");
    NAt = localf;
    NAu = ae.a(new o[] { u.R(g.Nng.NnN, NAm), u.R(g.Nng.NnQ, NAn), u.R(g.Nng.NnR, NAq), u.R(g.Nng.NnS, NAp) });
    NAv = ae.a(new o[] { u.R(NAm, g.Nng.NnN), u.R(NAn, g.Nng.NnQ), u.R(NAo, g.Nng.NnH), u.R(NAq, g.Nng.NnR), u.R(NAp, g.Nng.NnS) });
    AppMethodBeat.o(57660);
  }
  
  public static d.l.b.a.b.b.a.c a(d.l.b.a.b.d.a.e.a parama, d.l.b.a.b.d.a.c.h paramh)
  {
    AppMethodBeat.i(57658);
    p.h(parama, "annotation");
    p.h(paramh, "c");
    Object localObject = parama.gkV();
    if (p.i(localObject, d.l.b.a.b.f.a.p(NAm)))
    {
      parama = (d.l.b.a.b.b.a.c)new i(parama, paramh);
      AppMethodBeat.o(57658);
      return parama;
    }
    if (p.i(localObject, d.l.b.a.b.f.a.p(NAn)))
    {
      parama = (d.l.b.a.b.b.a.c)new h(parama, paramh);
      AppMethodBeat.o(57658);
      return parama;
    }
    if (p.i(localObject, d.l.b.a.b.f.a.p(NAq)))
    {
      localObject = g.Nng.NnR;
      p.g(localObject, "KotlinBuiltIns.FQ_NAMES.repeatable");
      parama = (d.l.b.a.b.b.a.c)new b(paramh, parama, (d.l.b.a.b.f.b)localObject);
      AppMethodBeat.o(57658);
      return parama;
    }
    if (p.i(localObject, d.l.b.a.b.f.a.p(NAp)))
    {
      localObject = g.Nng.NnS;
      p.g(localObject, "KotlinBuiltIns.FQ_NAMES.mustBeDocumented");
      parama = (d.l.b.a.b.b.a.c)new b(paramh, parama, (d.l.b.a.b.f.b)localObject);
      AppMethodBeat.o(57658);
      return parama;
    }
    if (p.i(localObject, d.l.b.a.b.f.a.p(NAo)))
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
    p.h(paramb, "kotlinName");
    p.h(paramd, "annotationOwner");
    p.h(paramh, "c");
    if (p.i(paramb, g.Nng.NnH))
    {
      d.l.b.a.b.d.a.e.a locala = paramd.l(NAo);
      if (locala != null)
      {
        paramb = (d.l.b.a.b.b.a.c)new e(locala, paramh);
        AppMethodBeat.o(57659);
        return paramb;
      }
    }
    paramb = (d.l.b.a.b.f.b)NAu.get(paramb);
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
  
  public static f gqe()
  {
    return NAr;
  }
  
  public static f gqf()
  {
    return NAs;
  }
  
  public static f gqg()
  {
    return NAt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.a.a.c
 * JD-Core Version:    0.7.0.1
 */