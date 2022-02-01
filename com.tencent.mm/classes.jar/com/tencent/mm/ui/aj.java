package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wx;
import com.tencent.mm.sdk.b.a;

public final class aj
{
  public static void cQ(int paramInt, String paramString)
  {
    AppMethodBeat.i(141491);
    if (a.IvT != null)
    {
      wx localwx = new wx();
      localwx.dMu.className = paramString;
      localwx.dMu.dMv = paramInt;
      a.IvT.l(localwx);
    }
    AppMethodBeat.o(141491);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.aj
 * JD-Core Version:    0.7.0.1
 */