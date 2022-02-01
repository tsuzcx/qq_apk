package org.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;

public final class a
{
  public final String MaX;
  public final String MaY;
  public final String MaZ;
  public final h Mbb;
  private final OutputStream Mbc;
  public final String scope;
  
  public a(String paramString1, String paramString2, String paramString3, h paramh, String paramString4, OutputStream paramOutputStream)
  {
    this.MaX = paramString1;
    this.MaY = paramString2;
    this.MaZ = paramString3;
    this.Mbb = paramh;
    this.scope = paramString4;
    this.Mbc = paramOutputStream;
  }
  
  public final boolean gfQ()
  {
    return this.scope != null;
  }
  
  public final void log(String paramString)
  {
    AppMethodBeat.i(40544);
    if (this.Mbc != null)
    {
      paramString = paramString + "\n";
      try
      {
        this.Mbc.write(paramString.getBytes("UTF8"));
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