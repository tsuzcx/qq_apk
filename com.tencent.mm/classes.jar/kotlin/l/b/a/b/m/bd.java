package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.a.g;

public final class bd
{
  public static final ad a(ad paramad, List<? extends az> paramList, g paramg)
  {
    AppMethodBeat.i(60843);
    s.u(paramad, "<this>");
    s.u(paramList, "newArguments");
    s.u(paramg, "newAnnotations");
    paramad = a(paramad, paramList, paramg, null, 4);
    AppMethodBeat.o(60843);
    return paramad;
  }
  
  private static al a(al paramal, List<? extends az> paramList, g paramg)
  {
    AppMethodBeat.i(60844);
    s.u(paramal, "<this>");
    s.u(paramList, "newArguments");
    s.u(paramg, "newAnnotations");
    if ((paramList.isEmpty()) && (paramg == paramal.knl()))
    {
      AppMethodBeat.o(60844);
      return paramal;
    }
    if (paramList.isEmpty())
    {
      paramal = paramal.d(paramg);
      AppMethodBeat.o(60844);
      return paramal;
    }
    paramal = ae.c(paramg, paramal.kzm(), paramList, paramal.ksB());
    AppMethodBeat.o(60844);
    return paramal;
  }
  
  public static final al ap(ad paramad)
  {
    AppMethodBeat.i(60846);
    s.u(paramad, "<this>");
    Object localObject = paramad.kAK();
    if ((localObject instanceof al)) {}
    for (localObject = (al)localObject; localObject == null; localObject = null)
    {
      paramad = (Throwable)new IllegalStateException(s.X("This is should be simple type: ", paramad).toString());
      AppMethodBeat.o(60846);
      throw paramad;
    }
    AppMethodBeat.o(60846);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.bd
 * JD-Core Version:    0.7.0.1
 */