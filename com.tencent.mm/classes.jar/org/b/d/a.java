package org.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;

public final class a
{
  public final String Kno;
  public final String Knp;
  public final String Knq;
  public final h Kns;
  private final OutputStream Knt;
  public final String scope;
  
  public a(String paramString1, String paramString2, String paramString3, h paramh, String paramString4, OutputStream paramOutputStream)
  {
    this.Kno = paramString1;
    this.Knp = paramString2;
    this.Knq = paramString3;
    this.Kns = paramh;
    this.scope = paramString4;
    this.Knt = paramOutputStream;
  }
  
  public final boolean fNa()
  {
    return this.scope != null;
  }
  
  public final void log(String paramString)
  {
    AppMethodBeat.i(40544);
    if (this.Knt != null)
    {
      paramString = paramString + "\n";
      try
      {
        this.Knt.write(paramString.getBytes("UTF8"));
        AppMethodBeat.o(40544);
        return;
      }
      catch (Exception paramString)
      {
        paramString = new RuntimeException("there were problems while writting to the debug stream", paramString);
        AppMethodBeat.o(40544);
        throw paramString;
      }
    }
    AppMethodBeat.o(40544);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     org.b.d.a
 * JD-Core Version:    0.7.0.1
 */