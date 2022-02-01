package com.tencent.mm.plugin.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.c;

public final class b
  implements c
{
  private static b uFs;
  
  public static b dcg()
  {
    try
    {
      AppMethodBeat.i(151500);
      if (uFs == null) {
        uFs = new b();
      }
      b localb = uFs;
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