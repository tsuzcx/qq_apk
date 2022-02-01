package d.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b;
import d.l.d;
import d.l.h;
import d.l.m;

public class x
{
  public d.l.e a(j paramj)
  {
    return paramj;
  }
  
  public h a(n paramn)
  {
    return paramn;
  }
  
  public d.l.l a(r paramr)
  {
    return paramr;
  }
  
  public m a(t paramt)
  {
    return paramt;
  }
  
  public String a(i parami)
  {
    AppMethodBeat.i(128961);
    parami = parami.getClass().getGenericInterfaces()[0].toString();
    if (parami.startsWith("kotlin.jvm.functions."))
    {
      parami = parami.substring(21);
      AppMethodBeat.o(128961);
      return parami;
    }
    AppMethodBeat.o(128961);
    return parami;
  }
  
  public String a(l paraml)
  {
    AppMethodBeat.i(128960);
    paraml = a(paraml);
    AppMethodBeat.o(128960);
    return paraml;
  }
  
  public b bk(Class paramClass)
  {
    AppMethodBeat.i(128959);
    paramClass = new e(paramClass);
    AppMethodBeat.o(128959);
    return paramClass;
  }
  
  public d g(Class paramClass, String paramString)
  {
    AppMethodBeat.i(128958);
    paramClass = new p(paramClass, paramString);
    AppMethodBeat.o(128958);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.g.b.x
 * JD-Core Version:    0.7.0.1
 */