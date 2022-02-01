package kotlin.l.b.a.b.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import kotlin.a.ak;
import kotlin.g.b.s;
import kotlin.l.b.a.b.a.k.a;
import kotlin.l.b.a.b.d.a.e.a;
import kotlin.l.b.a.b.d.a.e.d;
import kotlin.l.b.a.b.d.a.w;
import kotlin.l.b.a.b.f.f;
import kotlin.r;
import kotlin.v;

public final class c
{
  public static final c aiQU;
  private static final f aiQV;
  private static final f aiQW;
  private static final f aiQX;
  private static final Map<kotlin.l.b.a.b.f.c, kotlin.l.b.a.b.f.c> aiQY;
  private static final Map<kotlin.l.b.a.b.f.c, kotlin.l.b.a.b.f.c> aiQZ;
  
  static
  {
    AppMethodBeat.i(57660);
    aiQU = new c();
    f localf = f.bJe("message");
    s.s(localf, "identifier(\"message\")");
    aiQV = localf;
    localf = f.bJe("allowedTargets");
    s.s(localf, "identifier(\"allowedTargets\")");
    aiQW = localf;
    localf = f.bJe("value");
    s.s(localf, "identifier(\"value\")");
    aiQX = localf;
    aiQY = ak.e(new r[] { v.Y(k.a.aiDc, w.aiPw), v.Y(k.a.aiDf, w.aiPx), v.Y(k.a.aiDg, w.aiPA), v.Y(k.a.aiDh, w.aiPz) });
    aiQZ = ak.e(new r[] { v.Y(w.aiPw, k.a.aiDc), v.Y(w.aiPx, k.a.aiDf), v.Y(w.aiPy, k.a.aiCV), v.Y(w.aiPA, k.a.aiDg), v.Y(w.aiPz, k.a.aiDh) });
    AppMethodBeat.o(57660);
  }
  
  public static kotlin.l.b.a.b.b.a.c a(a parama, kotlin.l.b.a.b.d.a.c.h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(192130);
    s.u(parama, "annotation");
    s.u(paramh, "c");
    kotlin.l.b.a.b.f.b localb = parama.kmb();
    if (s.p(localb, kotlin.l.b.a.b.f.b.s(w.aiPw)))
    {
      parama = (kotlin.l.b.a.b.b.a.c)new i(parama, paramh);
      AppMethodBeat.o(192130);
      return parama;
    }
    if (s.p(localb, kotlin.l.b.a.b.f.b.s(w.aiPx)))
    {
      parama = (kotlin.l.b.a.b.b.a.c)new h(parama, paramh);
      AppMethodBeat.o(192130);
      return parama;
    }
    if (s.p(localb, kotlin.l.b.a.b.f.b.s(w.aiPA)))
    {
      parama = (kotlin.l.b.a.b.b.a.c)new b(paramh, parama, k.a.aiDg);
      AppMethodBeat.o(192130);
      return parama;
    }
    if (s.p(localb, kotlin.l.b.a.b.f.b.s(w.aiPz)))
    {
      parama = (kotlin.l.b.a.b.b.a.c)new b(paramh, parama, k.a.aiDh);
      AppMethodBeat.o(192130);
      return parama;
    }
    if (s.p(localb, kotlin.l.b.a.b.f.b.s(w.aiPy)))
    {
      AppMethodBeat.o(192130);
      return null;
    }
    parama = (kotlin.l.b.a.b.b.a.c)new kotlin.l.b.a.b.d.a.c.a.e(paramh, parama, paramBoolean);
    AppMethodBeat.o(192130);
    return parama;
  }
  
  public static kotlin.l.b.a.b.b.a.c a(kotlin.l.b.a.b.f.c paramc, d paramd, kotlin.l.b.a.b.d.a.c.h paramh)
  {
    AppMethodBeat.i(57659);
    s.u(paramc, "kotlinName");
    s.u(paramd, "annotationOwner");
    s.u(paramh, "c");
    if (s.p(paramc, k.a.aiCV))
    {
      Object localObject = w.aiPy;
      s.s(localObject, "DEPRECATED_ANNOTATION");
      localObject = paramd.m((kotlin.l.b.a.b.f.c)localObject);
      if ((localObject != null) || (paramd.kqA()))
      {
        paramc = (kotlin.l.b.a.b.b.a.c)new e((a)localObject, paramh);
        AppMethodBeat.o(57659);
        return paramc;
      }
    }
    paramc = (kotlin.l.b.a.b.f.c)aiQY.get(paramc);
    if (paramc == null)
    {
      AppMethodBeat.o(57659);
      return null;
    }
    paramc = paramd.m(paramc);
    if (paramc == null)
    {
      AppMethodBeat.o(57659);
      return null;
    }
    paramc = a(paramc, paramh, false);
    AppMethodBeat.o(57659);
    return paramc;
  }
  
  public static f ksd()
  {
    return aiQV;
  }
  
  public static f kse()
  {
    return aiQW;
  }
  
  public static f ksf()
  {
    return aiQX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.a.c
 * JD-Core Version:    0.7.0.1
 */