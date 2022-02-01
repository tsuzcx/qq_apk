package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class SystemProperty
{
  private static final HashMap<String, String> PROPERTIES;
  
  static
  {
    AppMethodBeat.i(157840);
    PROPERTIES = new HashMap();
    AppMethodBeat.o(157840);
  }
  
  public static String getProperty(String paramString)
  {
    AppMethodBeat.i(157838);
    paramString = (String)PROPERTIES.get(paramString);
    AppMethodBeat.o(157838);
    return paramString;
  }
  
  public static void setProperty(String paramString1, String paramString2)
  {
    AppMethodBeat.i(157839);
    PROPERTIES.put(paramString1, paramString2);
    AppMethodBeat.o(157839);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.SystemProperty
 * JD-Core Version:    0.7.0.1
 */