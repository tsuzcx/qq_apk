package kotlin.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b;
import kotlin.l.e;
import kotlin.l.g;

public class ab
{
  public String a(m paramm)
  {
    AppMethodBeat.i(128961);
    paramm = paramm.getClass().getGenericInterfaces()[0].toString();
    if (paramm.startsWith("kotlin.jvm.functions."))
    {
      paramm = paramm.substring(21);
      AppMethodBeat.o(128961);
      return paramm;
    }
    AppMethodBeat.o(128961);
    return paramm;
  }
  
  public String a(q paramq)
  {
    AppMethodBeat.i(128960);
    paramq = a(paramq);
    AppMethodBeat.o(128960);
    return paramq;
  }
  
  public e a(n paramn)
  {
    return paramn;
  }
  
  public g a(t paramt)
  {
    return paramt;
  }
  
  public kotlin.l.h a(u paramu)
  {
    return paramu;
  }
  
  public kotlin.l.m a(x paramx)
  {
    return paramx;
  }
  
  public b bp(Class paramClass)
  {
    AppMethodBeat.i(128959);
    paramClass = new h(paramClass);
    AppMethodBeat.o(128959);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.g.b.ab
 * JD-Core Version:    0.7.0.1
 */