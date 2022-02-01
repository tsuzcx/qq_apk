package com.tencent.mm.plugin.v;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.modelcontrol.c;

public final class a
  extends u
{
  private static a xam;
  
  private a()
  {
    super(c.class);
  }
  
  public static a dCx()
  {
    try
    {
      AppMethodBeat.i(151531);
      if (xam == null) {
        xam = new a();
      }
      a locala = xam;
      AppMethodBeat.o(151531);
      return locala;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.v.a
 * JD-Core Version:    0.7.0.1
 */