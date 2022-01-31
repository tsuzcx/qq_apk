package com.tencent.mm.plugin.v;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.b.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import java.util.List;

public final class a
  implements b, c
{
  private static a qfB;
  
  public static a cgF()
  {
    try
    {
      AppMethodBeat.i(136942);
      if (qfB == null) {
        qfB = new a();
      }
      a locala = qfB;
      AppMethodBeat.o(136942);
      return locala;
    }
    finally {}
  }
  
  public static String cgG()
  {
    AppMethodBeat.i(136943);
    String str = g.RL().eHR + "remark/";
    AppMethodBeat.o(136943);
    return str;
  }
  
  public final List<String> RR()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.v.a
 * JD-Core Version:    0.7.0.1
 */