package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wa;
import com.tencent.mm.sdk.b.a;

public final class ah
{
  public static void cJ(int paramInt, String paramString)
  {
    AppMethodBeat.i(141491);
    if (a.GpY != null)
    {
      wa localwa = new wa();
      localwa.dyT.className = paramString;
      localwa.dyT.dyU = paramInt;
      a.GpY.l(localwa);
    }
    AppMethodBeat.o(141491);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.ah
 * JD-Core Version:    0.7.0.1
 */