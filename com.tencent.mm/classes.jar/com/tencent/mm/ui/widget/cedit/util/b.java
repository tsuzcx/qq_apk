package com.tencent.mm.ui.widget.cedit.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static int aL(int paramInt)
  {
    AppMethodBeat.i(206128);
    if (paramInt < 0)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException();
      AppMethodBeat.o(206128);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(206128);
    return paramInt;
  }
  
  public static void checkArgument(boolean paramBoolean)
  {
    AppMethodBeat.i(206125);
    if (!paramBoolean)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException();
      AppMethodBeat.o(206125);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(206125);
  }
  
  public static void checkArgument(boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(206126);
    if (!paramBoolean)
    {
      paramObject = new IllegalArgumentException(String.valueOf(paramObject));
      AppMethodBeat.o(206126);
      throw paramObject;
    }
    AppMethodBeat.o(206126);
  }
  
  public static <T> T checkNotNull(T paramT, Object paramObject)
  {
    AppMethodBeat.i(206127);
    if (paramT == null)
    {
      paramT = new NullPointerException(String.valueOf(paramObject));
      AppMethodBeat.o(206127);
      throw paramT;
    }
    AppMethodBeat.o(206127);
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.util.b
 * JD-Core Version:    0.7.0.1
 */