package com.tencent.mm.plugin.v;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.t;
import com.tencent.mm.modelcontrol.c;

public final class a
  extends t
{
  private static a wKy;
  
  private a()
  {
    super(c.class);
  }
  
  public static a dzg()
  {
    try
    {
      AppMethodBeat.i(151531);
      if (wKy == null) {
        wKy = new a();
      }
      a locala = wKy;
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