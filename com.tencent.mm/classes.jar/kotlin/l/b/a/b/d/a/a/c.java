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
  private static final kotlin.l.b.a.b.f.b aaSO;
  private static final kotlin.l.b.a.b.f.b aaSP;
  private static final kotlin.l.b.a.b.f.b aaSQ;
  private static final kotlin.l.b.a.b.f.b aaSR;
  private static final kotlin.l.b.a.b.f.b aaSS;
  private static final f aaST;
  private static final f aaSU;
  private static final f aaSV;
  private static final Map<kotlin.l.b.a.b.f.b, kotlin.l.b.a.b.f.b> aaSW;
  private static final Map<kotlin.l.b.a.b.f.b, kotlin.l.b.a.b.f.b> aaSX;
  public static final c aaSY;
  
  static
  {
    AppMethodBeat.i(57660);
    aaSY = new c();
    aaSO = new kotlin.l.b.a.b.f.b(Target.class.getCanonicalName());
    aaSP = new kotlin.l.b.a.b.f.b(Retention.class.getCanonicalName());
    aaSQ = new kotlin.l.b.a.b.f.b(Deprecated.class.getCanonicalName());
    aaSR = new kotlin.l.b.a.b.f.b(Documented.class.getCanonicalName());
    aaSS = new kotlin.l.b.a.b.f.b("java.lang.annotation.Repeatable");
    f localf = f.bHb("message");
    p.j(localf, "Name.identifier(\"message\")");
    aaST = localf;
    localf = f.bHb("allowedTargets");
    p.j(localf, "Name.identifier(\"allowedTargets\")");
    aaSU = localf;
    localf = f.bHb("value");
    p.j(localf, "Name.identifier(\"value\")");
    aaSV = localf;
    aaSW = ae.e(new o[] { s.M(g.aaFI.aaGp, aaSO), s.M(g.aaFI.aaGs, aaSP), s.M(g.aaFI.aaGt, aaSS), s.M(g.aaFI.aaGu, aaSR) });
    aaSX = ae.e(new o[] { s.M(aaSO, g.aaFI.aaGp), s.M(aaSP, g.aaFI.aaGs), s.M(aaSQ, g.aaFI.aaGj), s.M(aaSS, g.aaFI.aaGt), s.M(aaSR, g.aaFI.aaGu) });
    AppMethodBeat.o(57660);
  }
  
  public static kotlin.l.b.a.b.b.a.c a(kotlin.l.b.a.b.d.a.e.a parama, kotlin.l.b.a.b.d.a.c.h paramh)
  {
    AppMethodBeat.i(57658);
    p.k(parama, "annotation");
    p.k(paramh, "c");
    Object localObject = parama.iCJ();
    if (p.h(localObject, kotlin.l.b.a.b.f.a.p(aaSO)))
    {
      parama = (kotlin.l.b.a.b.b.a.c)new i(parama, paramh);
      AppMethodBeat.o(57658);
      return parama;
    }
    if (p.h(localObject, kotlin.l.b.a.b.f.a.p(aaSP)))
    {
      parama = (kotlin.l.b.a.b.b.a.c)new h(parama, paramh);
      AppMethodBeat.o(57658);
      return parama;
    }
    if (p.h(localObject, kotlin.l.b.a.b.f.a.p(aaSS)))
    {
      localObject = g.aaFI.aaGt;
      p.j(localObject, "KotlinBuiltIns.FQ_NAMES.repeatable");
      parama = (kotlin.l.b.a.b.b.a.c)new b(paramh, parama, (kotlin.l.b.a.b.f.b)localObject);
      AppMethodBeat.o(57658);
      return parama;
    }
    if (p.h(localObject, kotlin.l.b.a.b.f.a.p(aaSR)))
    {
      localObject = g.aaFI.aaGu;
      p.j(localObject, "KotlinBuiltIns.FQ_NAMES.mustBeDocumented");
      parama = (kotlin.l.b.a.b.b.a.c)new b(paramh, parama, (kotlin.l.b.a.b.f.b)localObject);
      AppMethodBeat.o(57658);
      return parama;
    }
    if (p.h(localObject, kotlin.l.b.a.b.f.a.p(aaSQ)))
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
    p.k(paramb, "kotlinName");
    p.k(paramd, "annotationOwner");
    p.k(paramh, "c");
    if (p.h(paramb, g.aaFI.aaGj))
    {
      kotlin.l.b.a.b.d.a.e.a locala = paramd.l(aaSQ);
      if (locala != null)
      {
        paramb = (kotlin.l.b.a.b.b.a.c)new e(locala, paramh);
        AppMethodBeat.o(57659);
        return paramb;
      }
    }
    paramb = (kotlin.l.b.a.b.f.b)aaSW.get(paramb);
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
  
  public static f iHZ()
  {
    return aaST;
  }
  
  public static f iIa()
  {
    return aaSU;
  }
  
  public static f iIb()
  {
    return aaSV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.a.c
 * JD-Core Version:    0.7.0.1
 */