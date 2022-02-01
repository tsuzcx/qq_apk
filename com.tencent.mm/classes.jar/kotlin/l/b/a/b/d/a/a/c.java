package kotlin.l.b.a.b.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.b.p;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.a.g.a;
import kotlin.l.b.a.b.d.a.e.d;
import kotlin.l.b.a.b.f.f;
import kotlin.o;
import kotlin.s;

public final class c
{
  private static final kotlin.l.b.a.b.f.b TpU;
  private static final kotlin.l.b.a.b.f.b TpV;
  private static final kotlin.l.b.a.b.f.b TpW;
  private static final kotlin.l.b.a.b.f.b TpX;
  private static final kotlin.l.b.a.b.f.b TpY;
  private static final f TpZ;
  private static final f Tqa;
  private static final f Tqb;
  private static final Map<kotlin.l.b.a.b.f.b, kotlin.l.b.a.b.f.b> Tqc;
  private static final Map<kotlin.l.b.a.b.f.b, kotlin.l.b.a.b.f.b> Tqd;
  public static final c Tqe;
  
  static
  {
    AppMethodBeat.i(57660);
    Tqe = new c();
    TpU = new kotlin.l.b.a.b.f.b(Target.class.getCanonicalName());
    TpV = new kotlin.l.b.a.b.f.b(Retention.class.getCanonicalName());
    TpW = new kotlin.l.b.a.b.f.b(Deprecated.class.getCanonicalName());
    TpX = new kotlin.l.b.a.b.f.b(Documented.class.getCanonicalName());
    TpY = new kotlin.l.b.a.b.f.b("java.lang.annotation.Repeatable");
    f localf = f.btY("message");
    p.g(localf, "Name.identifier(\"message\")");
    TpZ = localf;
    localf = f.btY("allowedTargets");
    p.g(localf, "Name.identifier(\"allowedTargets\")");
    Tqa = localf;
    localf = f.btY("value");
    p.g(localf, "Name.identifier(\"value\")");
    Tqb = localf;
    Tqc = ae.e(new o[] { s.U(g.TcO.Tdv, TpU), s.U(g.TcO.Tdy, TpV), s.U(g.TcO.Tdz, TpY), s.U(g.TcO.TdA, TpX) });
    Tqd = ae.e(new o[] { s.U(TpU, g.TcO.Tdv), s.U(TpV, g.TcO.Tdy), s.U(TpW, g.TcO.Tdp), s.U(TpY, g.TcO.Tdz), s.U(TpX, g.TcO.TdA) });
    AppMethodBeat.o(57660);
  }
  
  public static kotlin.l.b.a.b.b.a.c a(kotlin.l.b.a.b.d.a.e.a parama, kotlin.l.b.a.b.d.a.c.h paramh)
  {
    AppMethodBeat.i(57658);
    p.h(parama, "annotation");
    p.h(paramh, "c");
    Object localObject = parama.hyy();
    if (p.j(localObject, kotlin.l.b.a.b.f.a.p(TpU)))
    {
      parama = (kotlin.l.b.a.b.b.a.c)new i(parama, paramh);
      AppMethodBeat.o(57658);
      return parama;
    }
    if (p.j(localObject, kotlin.l.b.a.b.f.a.p(TpV)))
    {
      parama = (kotlin.l.b.a.b.b.a.c)new h(parama, paramh);
      AppMethodBeat.o(57658);
      return parama;
    }
    if (p.j(localObject, kotlin.l.b.a.b.f.a.p(TpY)))
    {
      localObject = g.TcO.Tdz;
      p.g(localObject, "KotlinBuiltIns.FQ_NAMES.repeatable");
      parama = (kotlin.l.b.a.b.b.a.c)new b(paramh, parama, (kotlin.l.b.a.b.f.b)localObject);
      AppMethodBeat.o(57658);
      return parama;
    }
    if (p.j(localObject, kotlin.l.b.a.b.f.a.p(TpX)))
    {
      localObject = g.TcO.TdA;
      p.g(localObject, "KotlinBuiltIns.FQ_NAMES.mustBeDocumented");
      parama = (kotlin.l.b.a.b.b.a.c)new b(paramh, parama, (kotlin.l.b.a.b.f.b)localObject);
      AppMethodBeat.o(57658);
      return parama;
    }
    if (p.j(localObject, kotlin.l.b.a.b.f.a.p(TpW)))
    {
      AppMethodBeat.o(57658);
      return null;
    }
    parama = (kotlin.l.b.a.b.b.a.c)new kotlin.l.b.a.b.d.a.c.a.e(paramh, parama);
    AppMethodBeat.o(57658);
    return parama;
  }
  
  public static kotlin.l.b.a.b.b.a.c a(kotlin.l.b.a.b.f.b paramb, d paramd, kotlin.l.b.a.b.d.a.c.h paramh)
  {
    AppMethodBeat.i(57659);
    p.h(paramb, "kotlinName");
    p.h(paramd, "annotationOwner");
    p.h(paramh, "c");
    if (p.j(paramb, g.TcO.Tdp))
    {
      kotlin.l.b.a.b.d.a.e.a locala = paramd.l(TpW);
      if (locala != null)
      {
        paramb = (kotlin.l.b.a.b.b.a.c)new e(locala, paramh);
        AppMethodBeat.o(57659);
        return paramb;
      }
    }
    paramb = (kotlin.l.b.a.b.f.b)Tqc.get(paramb);
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
  
  public static f hDG()
  {
    return TpZ;
  }
  
  public static f hDH()
  {
    return Tqa;
  }
  
  public static f hDI()
  {
    return Tqb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.a.c
 * JD-Core Version:    0.7.0.1
 */