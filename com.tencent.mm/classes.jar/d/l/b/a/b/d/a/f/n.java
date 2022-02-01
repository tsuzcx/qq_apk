package d.l.b.a.b.d.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ak;
import d.a.j;
import d.g.b.k;
import java.util.Set;

public final class n
{
  public static final d a(g paramg, e parame, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(58118);
    if ((!paramBoolean2) || (paramg != g.Lql))
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
    k.h(paramSet, "$this$select");
    if (paramg == g.Lqm)
    {
      paramSet = g.Lqm;
      AppMethodBeat.o(58120);
      return paramSet;
    }
    paramSet = (g)a(paramSet, g.Lql, g.Lqk, paramg, paramBoolean);
    AppMethodBeat.o(58120);
    return paramSet;
  }
  
  public static final <T> T a(Set<? extends T> paramSet, T paramT1, T paramT2, T paramT3, boolean paramBoolean)
  {
    AppMethodBeat.i(58119);
    k.h(paramSet, "$this$select");
    k.h(paramT1, "low");
    k.h(paramT2, "high");
    if (paramBoolean)
    {
      if (paramSet.contains(paramT1)) {
        paramSet = paramT1;
      }
      while ((k.g(paramSet, paramT1)) && (k.g(paramT3, paramT2)))
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
        paramT2 = j.n((Iterable)ak.c(paramSet, paramT3));
        paramT1 = paramT2;
        if (paramT2 != null) {}
      }
      else
      {
        paramT1 = paramSet;
      }
      paramSet = j.g((Iterable)paramT1);
      AppMethodBeat.o(58119);
      return paramSet;
      label133:
      paramSet = paramT3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.a.f.n
 * JD-Core Version:    0.7.0.1
 */