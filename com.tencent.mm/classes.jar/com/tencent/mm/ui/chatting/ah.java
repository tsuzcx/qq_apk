package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kw;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;

public final class ah
{
  private static ah zBX;
  int zBY = 0;
  
  public static ah dGU()
  {
    AppMethodBeat.i(153833);
    if (zBX == null) {
      zBX = new ah();
    }
    ah localah = zBX;
    AppMethodBeat.o(153833);
    return localah;
  }
  
  public final void Pw(int paramInt)
  {
    AppMethodBeat.i(153834);
    if (this.zBY > 0)
    {
      this.zBY -= 1;
      AppMethodBeat.o(153834);
      return;
    }
    ab.i("MicroMsg.OrzChattingLifecycle", "notifyChattingStatus [%d]", new Object[] { Integer.valueOf(paramInt) });
    kw localkw = new kw();
    localkw.cBa.cBb = paramInt;
    a.ymk.l(localkw);
    AppMethodBeat.o(153834);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ah
 * JD-Core Version:    0.7.0.1
 */