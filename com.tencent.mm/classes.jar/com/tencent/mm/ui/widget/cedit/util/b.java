package com.tencent.mm.ui.widget.cedit.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static int bv(int paramInt)
  {
    AppMethodBeat.i(192735);
    if (paramInt < 0)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException();
      AppMethodBeat.o(192735);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(192735);
    return paramInt;
  }
  
  public static void checkArgument(boolean paramBoolean)
  {
    AppMethodBeat.i(192725);
    if (!paramBoolean)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException();
      AppMethodBeat.o(192725);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(192725);
  }
  
  public static void checkArgument(boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(192728);
    if (!paramBoolean)
    {
      paramObject = new IllegalArgumentException(String.valueOf(paramObject));
      AppMethodBeat.o(192728);
      throw paramObject;
    }
    AppMethodBeat.o(192728);
  }
  
  public static <T> T checkNotNull(T paramT, Object paramObject)
  {
    AppMethodBeat.i(192731);
    if (paramT == null)
    {
      paramT = new NullPointerException(String.valueOf(paramObject));
      AppMethodBeat.o(192731);
      throw paramT;
    }
    AppMethodBeat.o(192731);
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.util.b
 * JD-Core Version:    0.7.0.1
 */