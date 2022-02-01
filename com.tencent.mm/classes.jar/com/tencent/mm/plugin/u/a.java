package com.tencent.mm.plugin.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.y;
import com.tencent.mm.modelcontrol.d;

public final class a
  extends y
{
  private static a AXO;
  
  private a()
  {
    super(d.class);
  }
  
  public static a eCP()
  {
    try
    {
      AppMethodBeat.i(151531);
      if (AXO == null) {
        AXO = new a();
      }
      a locala = AXO;
      AppMethodBeat.o(151531);
      return locala;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.u.a
 * JD-Core Version:    0.7.0.1
 */