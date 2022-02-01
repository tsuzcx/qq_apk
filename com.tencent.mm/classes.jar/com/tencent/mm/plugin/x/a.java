package com.tencent.mm.plugin.x;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.b.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import java.util.List;

public final class a
  implements b, c
{
  private static a xRF;
  
  public static String dIA()
  {
    AppMethodBeat.i(90774);
    String str = g.ajC().gBm + "remark/";
    AppMethodBeat.o(90774);
    return str;
  }
  
  public static a dIz()
  {
    try
    {
      AppMethodBeat.i(90773);
      if (xRF == null) {
        xRF = new a();
      }
      a locala = xRF;
      AppMethodBeat.o(90773);
      return locala;
    }
    finally {}
  }
  
  public final List<String> ajJ()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.x.a
 * JD-Core Version:    0.7.0.1
 */