package com.tencent.xweb.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.io.OutputStream;

public final class i
{
  static e MsB;
  
  static
  {
    AppMethodBeat.i(183528);
    MsB = g.gbz().gby();
    AppMethodBeat.o(183528);
  }
  
  public static OutputStream Cz(String paramString)
  {
    AppMethodBeat.i(183527);
    paramString = MsB.Cz(paramString);
    AppMethodBeat.o(183527);
    return paramString;
  }
  
  public static String aPK(String paramString)
  {
    AppMethodBeat.i(183524);
    paramString = MsB.aPK(paramString);
    AppMethodBeat.o(183524);
    return paramString;
  }
  
  public static boolean lL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(183525);
    boolean bool = MsB.lL(paramString1, paramString2);
    AppMethodBeat.o(183525);
    return bool;
  }
  
  public static InputStream openRead(String paramString)
  {
    AppMethodBeat.i(183526);
    paramString = MsB.openRead(paramString);
    AppMethodBeat.o(183526);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.b.i
 * JD-Core Version:    0.7.0.1
 */