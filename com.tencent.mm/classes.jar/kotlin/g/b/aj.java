package kotlin.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.c;
import kotlin.l.e;
import kotlin.l.f;
import kotlin.l.k;
import kotlin.l.q;
import kotlin.l.r;

public class aj
{
  public String a(o paramo)
  {
    AppMethodBeat.i(128961);
    paramo = paramo.getClass().getGenericInterfaces()[0].toString();
    if (paramo.startsWith("kotlin.jvm.functions."))
    {
      paramo = paramo.substring(21);
      AppMethodBeat.o(128961);
      return paramo;
    }
    AppMethodBeat.o(128961);
    return paramo;
  }
  
  public String a(u paramu)
  {
    AppMethodBeat.i(128960);
    paramu = a(paramu);
    AppMethodBeat.o(128960);
    return paramu;
  }
  
  public f a(p paramp)
  {
    return paramp;
  }
  
  public kotlin.l.i a(x paramx)
  {
    return paramx;
  }
  
  public k a(z paramz)
  {
    return paramz;
  }
  
  public q a(ad paramad)
  {
    return paramad;
  }
  
  public r a(af paramaf)
  {
    return paramaf;
  }
  
  public c cz(Class paramClass)
  {
    AppMethodBeat.i(128959);
    paramClass = new i(paramClass);
    AppMethodBeat.o(128959);
    return paramClass;
  }
  
  public e p(Class paramClass, String paramString)
  {
    AppMethodBeat.i(128958);
    paramClass = new ab(paramClass, paramString);
    AppMethodBeat.o(128958);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.g.b.aj
 * JD-Core Version:    0.7.0.1
 */