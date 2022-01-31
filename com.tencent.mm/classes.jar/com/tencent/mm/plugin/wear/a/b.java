package com.tencent.mm.plugin.wear.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static final boolean agj(String paramString)
  {
    AppMethodBeat.i(26460);
    try
    {
      boolean bool = paramString.split("/")[2].equals("wear");
      AppMethodBeat.o(26460);
      return bool;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(26460);
    }
    return false;
  }
  
  public static final int agk(String paramString)
  {
    AppMethodBeat.i(26461);
    try
    {
      int i = Integer.valueOf(paramString.split("/")[4]).intValue();
      AppMethodBeat.o(26461);
      return i;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(26461);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.a.b
 * JD-Core Version:    0.7.0.1
 */