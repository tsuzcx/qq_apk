package org.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;

public final class a
{
  public final String Uib;
  public final String Uic;
  public final String Uid;
  public final h Uif;
  private final OutputStream Uig;
  public final String scope;
  
  public a(String paramString1, String paramString2, String paramString3, h paramh, String paramString4, OutputStream paramOutputStream)
  {
    this.Uib = paramString1;
    this.Uic = paramString2;
    this.Uid = paramString3;
    this.Uif = paramh;
    this.scope = paramString4;
    this.Uig = paramOutputStream;
  }
  
  public final boolean hQa()
  {
    return this.scope != null;
  }
  
  public final void log(String paramString)
  {
    AppMethodBeat.i(40544);
    if (this.Uig != null)
    {
      paramString = paramString + "\n";
      try
      {
        this.Uig.write(paramString.getBytes("UTF8"));
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