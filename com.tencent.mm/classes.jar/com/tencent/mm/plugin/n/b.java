package com.tencent.mm.plugin.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.c;

public final class b
  implements c
{
  private static b txa;
  
  public static b cOx()
  {
    try
    {
      AppMethodBeat.i(151500);
      if (txa == null) {
        txa = new b();
      }
      b localb = txa;
      AppMethodBeat.o(151500);
      return localb;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.n.b
 * JD-Core Version:    0.7.0.1
 */