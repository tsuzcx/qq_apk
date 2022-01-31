package org.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;
import org.b.b.b;
import org.b.d.h;
import org.b.g.d;

public final class a
{
  public String CRA;
  public String CRB = "oob";
  public org.b.a.a.a CRC;
  public h CRD = h.CRS;
  public OutputStream CRE = null;
  public String CRz;
  public String scope;
  
  public static org.b.a.a.a bc(Class<? extends org.b.a.a.a> paramClass)
  {
    AppMethodBeat.i(77233);
    d.s(paramClass, "Api class cannot be null");
    try
    {
      paramClass = (org.b.a.a.a)paramClass.newInstance();
      AppMethodBeat.o(77233);
      return paramClass;
    }
    catch (Exception paramClass)
    {
      paramClass = new b("Error while creating the Api object", paramClass);
      AppMethodBeat.o(77233);
      throw paramClass;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     org.b.a.a
 * JD-Core Version:    0.7.0.1
 */