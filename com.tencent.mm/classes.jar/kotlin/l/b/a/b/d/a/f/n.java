package kotlin.l.b.a.b.d.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;
import kotlin.a.ak;
import kotlin.a.j;
import kotlin.g.b.p;

public final class n
{
  public static final <T> T a(Set<? extends T> paramSet, T paramT1, T paramT2, T paramT3, boolean paramBoolean)
  {
    AppMethodBeat.i(58119);
    p.k(paramSet, "$this$select");
    p.k(paramT1, "low");
    p.k(paramT2, "high");
    if (paramBoolean)
    {
      if (paramSet.contains(paramT1)) {
        paramSet = paramT1;
      }
      while ((p.h(paramSet, paramT1)) && (p.h(paramT3, paramT2)))
      {
        AppMethodBeat.o(58119);
        return null;
        if (paramSet.contains(paramT2)) {
          paramSet = paramT2;
        } else {
          paramSet = null;
        }
      }
      if (paramT3 != null) {
        break label133;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(58119);
      return paramSet;
      if (paramT3 != null)
      {
        paramT2 = j.r((Iterable)ak.c(paramSet, paramT3));
        paramT1 = paramT2;
        if (paramT2 != null) {}
      }
      else
      {
        paramT1 = paramSet;
      }
      paramSet = j.j((Iterable)paramT1);
      AppMethodBeat.o(58119);
      return paramSet;
      label133:
      paramSet = paramT3;
    }
  }
  
  public static final d a(g paramg, e parame, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(58118);
    if ((!paramBoolean2) || (paramg != g.aaWO))
    {
      paramg = new d(paramg, parame, false, paramBoolean1);
      AppMethodBeat.o(58118);
      return paramg;
    }
    paramg = new d(paramg, parame, true, paramBoolean1);
    AppMethodBeat.o(58118);
    return paramg;
  }
  
  public static final g a(Set<? extends g> paramSet, g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(58120);
    p.k(paramSet, "$this$select");
    if (paramg == g.aaWP)
    {
      paramSet = g.aaWP;
      AppMethodBeat.o(58120);
      return paramSet;
    }
    paramSet = (g)a(paramSet, g.aaWO, g.aaWN, paramg, paramBoolean);
    AppMethodBeat.o(58120);
    return paramSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.f.n
 * JD-Core Version:    0.7.0.1
 */