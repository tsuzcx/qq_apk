package org.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;

public final class a
{
  public final h abLA;
  private final OutputStream abLB;
  public final String abLw;
  public final String abLx;
  public final String abLy;
  public final String scope;
  
  public a(String paramString1, String paramString2, String paramString3, h paramh, String paramString4, OutputStream paramOutputStream)
  {
    this.abLw = paramString1;
    this.abLx = paramString2;
    this.abLy = paramString3;
    this.abLA = paramh;
    this.scope = paramString4;
    this.abLB = paramOutputStream;
  }
  
  public final boolean iVj()
  {
    return this.scope != null;
  }
  
  public final void log(String paramString)
  {
    AppMethodBeat.i(40544);
    if (this.abLB != null)
    {
      paramString = paramString + "\n";
      try
      {
        this.abLB.write(paramString.getBytes("UTF8"));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     org.b.d.a
 * JD-Core Version:    0.7.0.1
 */