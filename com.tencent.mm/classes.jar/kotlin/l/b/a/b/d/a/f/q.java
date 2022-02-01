package kotlin.l.b.a.b.d.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;
import kotlin.a.ar;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.l.b.a.b.d.a.w;
import kotlin.l.b.a.b.f.c;
import kotlin.l.b.a.b.m.bf;
import kotlin.l.b.a.b.m.c.i;

public final class q
{
  public static final <T> T a(Set<? extends T> paramSet, T paramT1, T paramT2, T paramT3, boolean paramBoolean)
  {
    AppMethodBeat.i(192092);
    s.u(paramSet, "<this>");
    s.u(paramT1, "low");
    s.u(paramT2, "high");
    if (paramBoolean)
    {
      if (paramSet.contains(paramT1)) {
        paramSet = paramT1;
      }
      while ((s.p(paramSet, paramT1)) && (s.p(paramT3, paramT2)))
      {
        AppMethodBeat.o(192092);
        return null;
        if (paramSet.contains(paramT2)) {
          paramSet = paramT2;
        } else {
          paramSet = null;
        }
      }
      if (paramT3 == null)
      {
        AppMethodBeat.o(192092);
        return paramSet;
      }
      AppMethodBeat.o(192092);
      return paramT3;
    }
    if (paramT3 == null) {
      paramT1 = paramSet;
    }
    for (;;)
    {
      paramSet = p.j((Iterable)paramT1);
      AppMethodBeat.o(192092);
      return paramSet;
      paramT2 = p.r((Iterable)ar.c(paramSet, paramT3));
      paramT1 = paramT2;
      if (paramT2 == null) {
        paramT1 = paramSet;
      }
    }
  }
  
  public static final e a(h paramh, f paramf, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(192088);
    if ((!paramBoolean2) || (paramh != h.aiUX))
    {
      paramh = new e(paramh, paramf, false, paramBoolean1);
      AppMethodBeat.o(192088);
      return paramh;
    }
    paramh = new e(paramh, paramf, true, paramBoolean1);
    AppMethodBeat.o(192088);
    return paramh;
  }
  
  public static final h a(Set<? extends h> paramSet, h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(192095);
    s.u(paramSet, "<this>");
    if (paramh == h.aiUY)
    {
      paramSet = h.aiUY;
      AppMethodBeat.o(192095);
      return paramSet;
    }
    paramSet = (h)a(paramSet, h.aiUX, h.aiUW, paramh, paramBoolean);
    AppMethodBeat.o(192095);
    return paramSet;
  }
  
  public static final boolean a(bf parambf, i parami)
  {
    AppMethodBeat.i(192100);
    s.u(parambf, "<this>");
    s.u(parami, "type");
    c localc = w.aiPJ;
    s.s(localc, "ENHANCED_NULLABILITY_ANNOTATION");
    boolean bool = parambf.a(parami, localc);
    AppMethodBeat.o(192100);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.f.q
 * JD-Core Version:    0.7.0.1
 */