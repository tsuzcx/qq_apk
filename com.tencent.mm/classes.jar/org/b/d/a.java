package org.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;

public final class a
{
  public final String NVZ;
  public final String NWa;
  public final String NWb;
  public final h NWd;
  private final OutputStream NWe;
  public final String scope;
  
  public a(String paramString1, String paramString2, String paramString3, h paramh, String paramString4, OutputStream paramOutputStream)
  {
    this.NVZ = paramString1;
    this.NWa = paramString2;
    this.NWb = paramString3;
    this.NWd = paramh;
    this.scope = paramString4;
    this.NWe = paramOutputStream;
  }
  
  public final boolean gyu()
  {
    return this.scope != null;
  }
  
  public final void log(String paramString)
  {
    AppMethodBeat.i(40544);
    if (this.NWe != null)
    {
      paramString = paramString + "\n";
      try
      {
        this.NWe.write(paramString.getBytes("UTF8"));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.b.d.a
 * JD-Core Version:    0.7.0.1
 */