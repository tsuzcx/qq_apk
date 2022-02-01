package com.tencent.mm.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.y;
import com.tencent.mm.modelstat.p;

public final class n
  extends y
{
  private static n pFl;
  
  private n()
  {
    super(p.class);
  }
  
  public static n bUY()
  {
    try
    {
      AppMethodBeat.i(151419);
      if (pFl == null) {
        pFl = new n();
      }
      n localn = pFl;
      AppMethodBeat.o(151419);
      return localn;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.n
 * JD-Core Version:    0.7.0.1
 */