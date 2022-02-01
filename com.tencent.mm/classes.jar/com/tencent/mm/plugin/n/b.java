package com.tencent.mm.plugin.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.c;

public final class b
  implements c
{
  private static b vIs;
  
  public static b dlB()
  {
    try
    {
      AppMethodBeat.i(151500);
      if (vIs == null) {
        vIs = new b();
      }
      b localb = vIs;
      AppMethodBeat.o(151500);
      return localb;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.n.b
 * JD-Core Version:    0.7.0.1
 */