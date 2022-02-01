package io.flutter.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class Preconditions
{
  public static <T> T checkNotNull(T paramT)
  {
    AppMethodBeat.i(9592);
    if (paramT == null)
    {
      paramT = new NullPointerException();
      AppMethodBeat.o(9592);
      throw paramT;
    }
    AppMethodBeat.o(9592);
    return paramT;
  }
  
  public static void checkState(boolean paramBoolean)
  {
    AppMethodBeat.i(189554);
    if (!paramBoolean)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException();
      AppMethodBeat.o(189554);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(189554);
  }
  
  public static void checkState(boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(189561);
    if (!paramBoolean)
    {
      paramObject = new IllegalStateException(String.valueOf(paramObject));
      AppMethodBeat.o(189561);
      throw paramObject;
    }
    AppMethodBeat.o(189561);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     io.flutter.util.Preconditions
 * JD-Core Version:    0.7.0.1
 */