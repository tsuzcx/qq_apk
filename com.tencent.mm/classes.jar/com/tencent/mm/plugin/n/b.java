package com.tencent.mm.plugin.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.c;

public final class b
  implements c
{
  private static b vUw;
  
  public static b doA()
  {
    try
    {
      AppMethodBeat.i(151500);
      if (vUw == null) {
        vUw = new b();
      }
      b localb = vUw;
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