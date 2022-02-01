package com.tencent.xweb.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.io.OutputStream;

public final class i
{
  static e MPF;
  
  static
  {
    AppMethodBeat.i(183528);
    MPF = g.ggb().gga();
    AppMethodBeat.o(183528);
  }
  
  public static OutputStream Db(String paramString)
  {
    AppMethodBeat.i(183527);
    paramString = MPF.Db(paramString);
    AppMethodBeat.o(183527);
    return paramString;
  }
  
  public static String aRh(String paramString)
  {
    AppMethodBeat.i(183524);
    paramString = MPF.aRh(paramString);
    AppMethodBeat.o(183524);
    return paramString;
  }
  
  public static boolean lS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(183525);
    boolean bool = MPF.lS(paramString1, paramString2);
    AppMethodBeat.o(183525);
    return bool;
  }
  
  public static InputStream openRead(String paramString)
  {
    AppMethodBeat.i(183526);
    paramString = MPF.openRead(paramString);
    AppMethodBeat.o(183526);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.b.i
 * JD-Core Version:    0.7.0.1
 */