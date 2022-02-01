package com.tencent.xweb.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.io.OutputStream;

public final class i
{
  static e SCD;
  
  static
  {
    AppMethodBeat.i(183528);
    SCD = g.htt().hts();
    AppMethodBeat.o(183528);
  }
  
  public static OutputStream LM(String paramString)
  {
    AppMethodBeat.i(183527);
    paramString = SCD.LM(paramString);
    AppMethodBeat.o(183527);
    return paramString;
  }
  
  public static String bhK(String paramString)
  {
    AppMethodBeat.i(183524);
    paramString = SCD.bhK(paramString);
    AppMethodBeat.o(183524);
    return paramString;
  }
  
  public static boolean copyFile(String paramString1, String paramString2)
  {
    AppMethodBeat.i(183525);
    boolean bool = SCD.copyFile(paramString1, paramString2);
    AppMethodBeat.o(183525);
    return bool;
  }
  
  public static InputStream openRead(String paramString)
  {
    AppMethodBeat.i(183526);
    paramString = SCD.openRead(paramString);
    AppMethodBeat.o(183526);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.b.i
 * JD-Core Version:    0.7.0.1
 */