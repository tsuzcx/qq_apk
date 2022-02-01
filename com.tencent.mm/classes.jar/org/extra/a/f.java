package org.extra.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class f
{
  public static boolean isEmpty(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(216824);
    if ((paramCharSequence == null) || (paramCharSequence.length() == 0))
    {
      AppMethodBeat.o(216824);
      return true;
    }
    AppMethodBeat.o(216824);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     org.extra.a.f
 * JD-Core Version:    0.7.0.1
 */