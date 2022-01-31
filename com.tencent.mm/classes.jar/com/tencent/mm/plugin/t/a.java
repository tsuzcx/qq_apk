package com.tencent.mm.plugin.t;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.q;
import com.tencent.mm.modelcontrol.c;

public final class a
  extends q
{
  private static a ptc;
  
  private a()
  {
    super(c.class);
  }
  
  public static a caK()
  {
    try
    {
      AppMethodBeat.i(79145);
      if (ptc == null) {
        ptc = new a();
      }
      a locala = ptc;
      AppMethodBeat.o(79145);
      return locala;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.t.a
 * JD-Core Version:    0.7.0.1
 */