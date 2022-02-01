package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.p;

public final class aa
{
  public static final boolean ac(ad paramad)
  {
    AppMethodBeat.i(60747);
    s.u(paramad, "<this>");
    boolean bool = paramad.kAK() instanceof x;
    AppMethodBeat.o(60747);
    return bool;
  }
  
  public static final x ad(ad paramad)
  {
    AppMethodBeat.i(60748);
    s.u(paramad, "<this>");
    paramad = (x)paramad.kAK();
    AppMethodBeat.o(60748);
    return paramad;
  }
  
  public static final al ae(ad paramad)
  {
    AppMethodBeat.i(60749);
    s.u(paramad, "<this>");
    paramad = paramad.kAK();
    if ((paramad instanceof x))
    {
      paramad = ((x)paramad).ajpE;
      AppMethodBeat.o(60749);
      return paramad;
    }
    if ((paramad instanceof al))
    {
      paramad = (al)paramad;
      AppMethodBeat.o(60749);
      return paramad;
    }
    paramad = new p();
    AppMethodBeat.o(60749);
    throw paramad;
  }
  
  public static final al af(ad paramad)
  {
    AppMethodBeat.i(60750);
    s.u(paramad, "<this>");
    paramad = paramad.kAK();
    if ((paramad instanceof x))
    {
      paramad = ((x)paramad).ajpF;
      AppMethodBeat.o(60750);
      return paramad;
    }
    if ((paramad instanceof al))
    {
      paramad = (al)paramad;
      AppMethodBeat.o(60750);
      return paramad;
    }
    paramad = new p();
    AppMethodBeat.o(60750);
    throw paramad;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.aa
 * JD-Core Version:    0.7.0.1
 */