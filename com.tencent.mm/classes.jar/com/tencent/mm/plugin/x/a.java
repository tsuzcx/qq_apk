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
  private static a yhy;
  
  public static a dLQ()
  {
    try
    {
      AppMethodBeat.i(90773);
      if (yhy == null) {
        yhy = new a();
      }
      a locala = yhy;
      AppMethodBeat.o(90773);
      return locala;
    }
    finally {}
  }
  
  public static String dLR()
  {
    AppMethodBeat.i(90774);
    String str = g.ajR().gDT + "remark/";
    AppMethodBeat.o(90774);
    return str;
  }
  
  public final List<String> ajY()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.x.a
 * JD-Core Version:    0.7.0.1
 */