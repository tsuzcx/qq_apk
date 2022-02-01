package org.extra.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class f
{
  public static boolean isEmpty(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(236789);
    if ((paramCharSequence == null) || (paramCharSequence.length() == 0))
    {
      AppMethodBeat.o(236789);
      return true;
    }
    AppMethodBeat.o(236789);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     org.extra.a.f
 * JD-Core Version:    0.7.0.1
 */