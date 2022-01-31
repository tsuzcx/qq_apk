package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eh
{
  public static <T> T a(T paramT)
  {
    AppMethodBeat.i(147528);
    if (paramT == null)
    {
      paramT = new NullPointerException();
      AppMethodBeat.o(147528);
      throw paramT;
    }
    AppMethodBeat.o(147528);
    return paramT;
  }
  
  public static void a(boolean paramBoolean)
  {
    AppMethodBeat.i(147529);
    if (!paramBoolean)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException();
      AppMethodBeat.o(147529);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(147529);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.eh
 * JD-Core Version:    0.7.0.1
 */