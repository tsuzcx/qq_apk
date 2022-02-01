package com.tencent.mm.plugin.wear.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static final boolean aWr(String paramString)
  {
    AppMethodBeat.i(131330);
    try
    {
      boolean bool = paramString.split("/")[2].equals("wear");
      AppMethodBeat.o(131330);
      return bool;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(131330);
    }
    return false;
  }
  
  public static final int aWs(String paramString)
  {
    AppMethodBeat.i(131331);
    try
    {
      int i = Integer.valueOf(paramString.split("/")[4]).intValue();
      AppMethodBeat.o(131331);
      return i;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(131331);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.a.b
 * JD-Core Version:    0.7.0.1
 */