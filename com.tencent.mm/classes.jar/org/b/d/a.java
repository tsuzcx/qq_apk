package org.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;

public final class a
{
  public final String Ote;
  public final String Otf;
  public final String Otg;
  public final h Oti;
  private final OutputStream Otj;
  public final String scope;
  
  public a(String paramString1, String paramString2, String paramString3, h paramh, String paramString4, OutputStream paramOutputStream)
  {
    this.Ote = paramString1;
    this.Otf = paramString2;
    this.Otg = paramString3;
    this.Oti = paramh;
    this.scope = paramString4;
    this.Otj = paramOutputStream;
  }
  
  public final boolean gCW()
  {
    return this.scope != null;
  }
  
  public final void log(String paramString)
  {
    AppMethodBeat.i(40544);
    if (this.Otj != null)
    {
      paramString = paramString + "\n";
      try
      {
        this.Otj.write(paramString.getBytes("UTF8"));
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