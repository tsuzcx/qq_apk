package com.tencent.mm.ui.widget.cedit.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static void checkArgument(boolean paramBoolean)
  {
    AppMethodBeat.i(252120);
    if (!paramBoolean)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException();
      AppMethodBeat.o(252120);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(252120);
  }
  
  public static void checkArgument(boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(252128);
    if (!paramBoolean)
    {
      paramObject = new IllegalArgumentException(String.valueOf(paramObject));
      AppMethodBeat.o(252128);
      throw paramObject;
    }
    AppMethodBeat.o(252128);
  }
  
  public static <T> T checkNotNull(T paramT, Object paramObject)
  {
    AppMethodBeat.i(252135);
    if (paramT == null)
    {
      paramT = new NullPointerException(String.valueOf(paramObject));
      AppMethodBeat.o(252135);
      throw paramT;
    }
    AppMethodBeat.o(252135);
    return paramT;
  }
  
  public static int el(int paramInt)
  {
    AppMethodBeat.i(252143);
    if (paramInt < 0)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException();
      AppMethodBeat.o(252143);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(252143);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.util.b
 * JD-Core Version:    0.7.0.1
 */