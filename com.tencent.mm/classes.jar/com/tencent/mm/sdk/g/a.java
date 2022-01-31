package com.tencent.mm.sdk.g;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  static final ThreadLocal<String> yse;
  
  static
  {
    AppMethodBeat.i(52522);
    yse = new ThreadLocal();
    AppMethodBeat.o(52522);
  }
  
  public static String getTag()
  {
    AppMethodBeat.i(52521);
    String str = (String)yse.get();
    AppMethodBeat.o(52521);
    return str;
  }
  
  protected static void setTag(String paramString)
  {
    AppMethodBeat.i(52520);
    yse.set(paramString);
    AppMethodBeat.o(52520);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.g.a
 * JD-Core Version:    0.7.0.1
 */