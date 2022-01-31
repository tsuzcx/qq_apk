package org.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;

public final class a
{
  public final String CRA;
  public final String CRB;
  public final h CRD;
  private final OutputStream CRE;
  public final String CRz;
  public final String scope;
  
  public a(String paramString1, String paramString2, String paramString3, h paramh, String paramString4, OutputStream paramOutputStream)
  {
    this.CRz = paramString1;
    this.CRA = paramString2;
    this.CRB = paramString3;
    this.CRD = paramh;
    this.scope = paramString4;
    this.CRE = paramOutputStream;
  }
  
  public final boolean ery()
  {
    return this.scope != null;
  }
  
  public final void log(String paramString)
  {
    AppMethodBeat.i(77275);
    if (this.CRE != null)
    {
      paramString = paramString + "\n";
      try
      {
        this.CRE.write(paramString.getBytes("UTF8"));
        AppMethodBeat.o(77275);
        return;
      }
      catch (Exception paramString)
      {
        paramString = new RuntimeException("there were problems while writting to the debug stream", paramString);
        AppMethodBeat.o(77275);
        throw paramString;
      }
    }
    AppMethodBeat.o(77275);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.b.d.a
 * JD-Core Version:    0.7.0.1
 */