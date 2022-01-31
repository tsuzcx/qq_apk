package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class bk
{
  private static final HashMap<String, String> yqy;
  
  static
  {
    AppMethodBeat.i(52280);
    yqy = new HashMap();
    AppMethodBeat.o(52280);
  }
  
  public static String getProperty(String paramString)
  {
    AppMethodBeat.i(52278);
    paramString = (String)yqy.get(paramString);
    AppMethodBeat.o(52278);
    return paramString;
  }
  
  public static void setProperty(String paramString1, String paramString2)
  {
    AppMethodBeat.i(52279);
    yqy.put(paramString1, paramString2);
    AppMethodBeat.o(52279);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bk
 * JD-Core Version:    0.7.0.1
 */