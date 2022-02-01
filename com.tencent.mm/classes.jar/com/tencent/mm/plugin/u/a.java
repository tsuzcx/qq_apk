package com.tencent.mm.plugin.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.t;
import com.tencent.mm.modelcontrol.c;

public final class a
  extends t
{
  private static a uuz;
  
  private a()
  {
    super(c.class);
  }
  
  public static a daW()
  {
    try
    {
      AppMethodBeat.i(151531);
      if (uuz == null) {
        uuz = new a();
      }
      a locala = uuz;
      AppMethodBeat.o(151531);
      return locala;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.u.a
 * JD-Core Version:    0.7.0.1
 */