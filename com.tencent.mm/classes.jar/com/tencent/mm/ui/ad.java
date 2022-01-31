package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.tr;
import com.tencent.mm.sdk.b.a;

public final class ad
{
  public static void bK(int paramInt, String paramString)
  {
    AppMethodBeat.i(106131);
    if (a.ymk != null)
    {
      tr localtr = new tr();
      localtr.cKj.className = paramString;
      localtr.cKj.cKk = paramInt;
      a.ymk.l(localtr);
    }
    AppMethodBeat.o(106131);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.ad
 * JD-Core Version:    0.7.0.1
 */