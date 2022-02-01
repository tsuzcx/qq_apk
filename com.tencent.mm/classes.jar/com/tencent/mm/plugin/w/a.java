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
  private static a vtT;
  
  public static a djh()
  {
    try
    {
      AppMethodBeat.i(90773);
      if (vtT == null) {
        vtT = new a();
      }
      a locala = vtT;
      AppMethodBeat.o(90773);
      return locala;
    }
    finally {}
  }
  
  public static String dji()
  {
    AppMethodBeat.i(90774);
    String str = g.afB().gcW + "remark/";
    AppMethodBeat.o(90774);
    return str;
  }
  
  public final List<String> afI()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.w.a
 * JD-Core Version:    0.7.0.1
 */