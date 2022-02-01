package com.tencent.mm.plugin.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.c;

public final class b
  implements c
{
  private static b ETT;
  
  public static b eRU()
  {
    try
    {
      AppMethodBeat.i(151500);
      if (ETT == null) {
        ETT = new b();
      }
      b localb = ETT;
      AppMethodBeat.o(151500);
      return localb;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.s.b
 * JD-Core Version:    0.7.0.1
 */