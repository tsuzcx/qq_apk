package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class fd$4
  extends eb<Character>
{
  public final Character a(ff paramff)
  {
    AppMethodBeat.i(147831);
    if (paramff.f() == fg.i)
    {
      paramff.j();
      AppMethodBeat.o(147831);
      return null;
    }
    paramff = paramff.h();
    if (paramff.length() != 1)
    {
      paramff = new dy("Expecting character, got: ".concat(String.valueOf(paramff)));
      AppMethodBeat.o(147831);
      throw paramff;
    }
    char c = paramff.charAt(0);
    AppMethodBeat.o(147831);
    return Character.valueOf(c);
  }
  
  public final void a(fh paramfh, Character paramCharacter)
  {
    AppMethodBeat.i(147832);
    if (paramCharacter == null) {}
    for (paramCharacter = null;; paramCharacter = String.valueOf(paramCharacter))
    {
      paramfh.b(paramCharacter);
      AppMethodBeat.o(147832);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.fd.4
 * JD-Core Version:    0.7.0.1
 */