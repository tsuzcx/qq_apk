package com.tencent.mm.plugin.u.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;

public final class b
{
  private static a wGd;
  
  static
  {
    AppMethodBeat.i(195630);
    wGd = new a() {};
    AppMethodBeat.o(195630);
  }
  
  public static a dyr()
  {
    AppMethodBeat.i(195629);
    a locala = (a)g.ab(a.class);
    if (locala != null)
    {
      AppMethodBeat.o(195629);
      return locala;
    }
    locala = wGd;
    AppMethodBeat.o(195629);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.u.a.b
 * JD-Core Version:    0.7.0.1
 */