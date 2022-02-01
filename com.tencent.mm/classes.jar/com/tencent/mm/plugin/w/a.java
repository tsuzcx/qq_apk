package com.tencent.mm.plugin.w;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.b.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import java.util.List;

public final class a
  implements b, c
{
  private static a Ciz;
  
  public static a eMS()
  {
    try
    {
      AppMethodBeat.i(90773);
      if (Ciz == null) {
        Ciz = new a();
      }
      a locala = Ciz;
      AppMethodBeat.o(90773);
      return locala;
    }
    finally {}
  }
  
  public static String eMT()
  {
    AppMethodBeat.i(90774);
    String str = g.aAh().hqG + "remark/";
    AppMethodBeat.o(90774);
    return str;
  }
  
  public final List<String> aAo()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.w.a
 * JD-Core Version:    0.7.0.1
 */