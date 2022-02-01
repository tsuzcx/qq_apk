package io.flutter.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     io.flutter.b.b
 * JD-Core Version:    0.7.0.1
 */