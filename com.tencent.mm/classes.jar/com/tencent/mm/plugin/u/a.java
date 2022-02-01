package com.tencent.mm.plugin.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.t;
import com.tencent.mm.modelcontrol.c;

public final class a
  extends t
{
  private static a vDs;
  
  private a()
  {
    super(c.class);
  }
  
  public static a doE()
  {
    try
    {
      AppMethodBeat.i(151531);
      if (vDs == null) {
        vDs = new a();
      }
      a locala = vDs;
      AppMethodBeat.o(151531);
      return locala;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.u.a
 * JD-Core Version:    0.7.0.1
 */