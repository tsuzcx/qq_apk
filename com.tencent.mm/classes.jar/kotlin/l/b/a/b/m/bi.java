package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.p;

public final class bi
{
  public static final bk a(bk parambk, ad paramad)
  {
    AppMethodBeat.i(60904);
    s.u(parambk, "<this>");
    s.u(paramad, "origin");
    parambk = b(parambk, aC(paramad));
    AppMethodBeat.o(60904);
    return parambk;
  }
  
  public static final bk a(bk parambk, ad paramad, b<? super ad, ? extends ad> paramb)
  {
    AppMethodBeat.i(191573);
    s.u(parambk, "<this>");
    s.u(paramad, "origin");
    s.u(paramb, "transform");
    paramad = aC(paramad);
    if (paramad == null) {}
    for (paramad = null;; paramad = (ad)paramb.invoke(paramad))
    {
      parambk = b(parambk, paramad);
      AppMethodBeat.o(191573);
      return parambk;
    }
  }
  
  public static final ad aC(ad paramad)
  {
    AppMethodBeat.i(60903);
    s.u(paramad, "<this>");
    if ((paramad instanceof bh))
    {
      paramad = ((bh)paramad).kAG();
      AppMethodBeat.o(60903);
      return paramad;
    }
    AppMethodBeat.o(60903);
    return null;
  }
  
  public static final bk b(bk parambk, ad paramad)
  {
    AppMethodBeat.i(60905);
    s.u(parambk, "<this>");
    if (paramad == null)
    {
      AppMethodBeat.o(60905);
      return parambk;
    }
    if ((parambk instanceof al))
    {
      parambk = (bk)new an((al)parambk, paramad);
      AppMethodBeat.o(60905);
      return parambk;
    }
    if ((parambk instanceof x))
    {
      parambk = (bk)new z((x)parambk, paramad);
      AppMethodBeat.o(60905);
      return parambk;
    }
    parambk = new p();
    AppMethodBeat.o(60905);
    throw parambk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.bi
 * JD-Core Version:    0.7.0.1
 */