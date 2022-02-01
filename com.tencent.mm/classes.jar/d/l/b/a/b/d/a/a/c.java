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
  private static final d.l.b.a.b.f.b Ndh;
  private static final d.l.b.a.b.f.b Ndi;
  private static final d.l.b.a.b.f.b Ndj;
  private static final d.l.b.a.b.f.b Ndk;
  private static final d.l.b.a.b.f.b Ndl;
  private static final f Ndm;
  private static final f Ndn;
  private static final f Ndo;
  private static final Map<d.l.b.a.b.f.b, d.l.b.a.b.f.b> Ndp;
  private static final Map<d.l.b.a.b.f.b, d.l.b.a.b.f.b> Ndq;
  public static final c Ndr;
  
  static
  {
    AppMethodBeat.i(57660);
    Ndr = new c();
    Ndh = new d.l.b.a.b.f.b(Target.class.getCanonicalName());
    Ndi = new d.l.b.a.b.f.b(Retention.class.getCanonicalName());
    Ndj = new d.l.b.a.b.f.b(Deprecated.class.getCanonicalName());
    Ndk = new d.l.b.a.b.f.b(Documented.class.getCanonicalName());
    Ndl = new d.l.b.a.b.f.b("java.lang.annotation.Repeatable");
    f localf = f.bcE("message");
    p.g(localf, "Name.identifier(\"message\")");
    Ndm = localf;
    localf = f.bcE("allowedTargets");
    p.g(localf, "Name.identifier(\"allowedTargets\")");
    Ndn = localf;
    localf = f.bcE("value");
    p.g(localf, "Name.identifier(\"value\")");
    Ndo = localf;
    Ndp = ae.a(new o[] { u.S(g.MQb.MQI, Ndh), u.S(g.MQb.MQL, Ndi), u.S(g.MQb.MQM, Ndl), u.S(g.MQb.MQN, Ndk) });
    Ndq = ae.a(new o[] { u.S(Ndh, g.MQb.MQI), u.S(Ndi, g.MQb.MQL), u.S(Ndj, g.MQb.MQC), u.S(Ndl, g.MQb.MQM), u.S(Ndk, g.MQb.MQN) });
    AppMethodBeat.o(57660);
  }
  
  public static d.l.b.a.b.b.a.c a(d.l.b.a.b.d.a.e.a parama, d.l.b.a.b.d.a.c.h paramh)
  {
    AppMethodBeat.i(57658);
    p.h(parama, "annotation");
    p.h(paramh, "c");
    Object localObject = parama.ggt();
    if (p.i(localObject, d.l.b.a.b.f.a.p(Ndh)))
    {
      parama = (d.l.b.a.b.b.a.c)new i(parama, paramh);
      AppMethodBeat.o(57658);
      return parama;
    }
    if (p.i(localObject, d.l.b.a.b.f.a.p(Ndi)))
    {
      parama = (d.l.b.a.b.b.a.c)new h(parama, paramh);
      AppMethodBeat.o(57658);
      return parama;
    }
    if (p.i(localObject, d.l.b.a.b.f.a.p(Ndl)))
    {
      localObject = g.MQb.MQM;
      p.g(localObject, "KotlinBuiltIns.FQ_NAMES.repeatable");
      parama = (d.l.b.a.b.b.a.c)new b(paramh, parama, (d.l.b.a.b.f.b)localObject);
      AppMethodBeat.o(57658);
      return parama;
    }
    if (p.i(localObject, d.l.b.a.b.f.a.p(Ndk)))
    {
      localObject = g.MQb.MQN;
      p.g(localObject, "KotlinBuiltIns.FQ_NAMES.mustBeDocumented");
      parama = (d.l.b.a.b.b.a.c)new b(paramh, parama, (d.l.b.a.b.f.b)localObject);
      AppMethodBeat.o(57658);
      return parama;
    }
    if (p.i(localObject, d.l.b.a.b.f.a.p(Ndj)))
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
    if (p.i(paramb, g.MQb.MQC))
    {
      d.l.b.a.b.d.a.e.a locala = paramd.l(Ndj);
      if (locala != null)
      {
        paramb = (d.l.b.a.b.b.a.c)new e(locala, paramh);
        AppMethodBeat.o(57659);
        return paramb;
      }
    }
    paramb = (d.l.b.a.b.f.b)Ndp.get(paramb);
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
  
  public static f glC()
  {
    return Ndm;
  }
  
  public static f glD()
  {
    return Ndn;
  }
  
  public static f glE()
  {
    return Ndo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.d.a.a.c
 * JD-Core Version:    0.7.0.1
 */