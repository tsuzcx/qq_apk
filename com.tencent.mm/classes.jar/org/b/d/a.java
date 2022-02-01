package org.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;

public final class a
{
  public final String ajYp;
  public final String ajYq;
  public final String ajYr;
  public final h ajYt;
  private final OutputStream ajYu;
  public final String scope;
  
  public a(String paramString1, String paramString2, String paramString3, h paramh, String paramString4, OutputStream paramOutputStream)
  {
    this.ajYp = paramString1;
    this.ajYq = paramString2;
    this.ajYr = paramString3;
    this.ajYt = paramh;
    this.scope = paramString4;
    this.ajYu = paramOutputStream;
  }
  
  public final boolean kJH()
  {
    return this.scope != null;
  }
  
  public final void log(String paramString)
  {
    AppMethodBeat.i(40544);
    if (this.ajYu != null)
    {
      paramString = paramString + "\n";
      try
      {
        this.ajYu.write(paramString.getBytes("UTF8"));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.b.d.a
 * JD-Core Version:    0.7.0.1
 */