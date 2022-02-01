package org.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;
import org.b.b.b;
import org.b.d.h;
import org.b.g.d;

public final class a
{
  public String Ote;
  public String Otf;
  public String Otg = "oob";
  public org.b.a.a.a Oth;
  public h Oti = h.Otx;
  public OutputStream Otj = null;
  public String scope;
  
  public static org.b.a.a.a bH(Class<? extends org.b.a.a.a> paramClass)
  {
    AppMethodBeat.i(40502);
    d.j(paramClass, "Api class cannot be null");
    try
    {
      paramClass = (org.b.a.a.a)paramClass.newInstance();
      AppMethodBeat.o(40502);
      return paramClass;
    }
    catch (Exception paramClass)
    {
      paramClass = new b("Error while creating the Api object", paramClass);
      AppMethodBeat.o(40502);
      throw paramClass;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.b.a.a
 * JD-Core Version:    0.7.0.1
 */