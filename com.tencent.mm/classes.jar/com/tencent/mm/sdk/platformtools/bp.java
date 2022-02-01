package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class bp
{
  private static final HashMap<String, String> EXf;
  
  static
  {
    AppMethodBeat.i(157840);
    EXf = new HashMap();
    AppMethodBeat.o(157840);
  }
  
  public static String getProperty(String paramString)
  {
    AppMethodBeat.i(157838);
    paramString = (String)EXf.get(paramString);
    AppMethodBeat.o(157838);
    return paramString;
  }
  
  public static void setProperty(String paramString1, String paramString2)
  {
    AppMethodBeat.i(157839);
    EXf.put(paramString1, paramString2);
    AppMethodBeat.o(157839);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bp
 * JD-Core Version:    0.7.0.1
 */