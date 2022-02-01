package com.tencent.mm.ui.n.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.n.b.a;

final class g$10
  implements h
{
  g$10(g paramg) {}
  
  public final void A(String paramString1, String paramString2)
  {
    AppMethodBeat.i(274419);
    Log.w("MicroMsg.MagicEmojiService", "hy: js exception: %s, %s", new Object[] { paramString1, paramString2 });
    a.bAw(String.format("magic emoji js exception: %s, %s", new Object[] { paramString1, paramString2 }));
    AppMethodBeat.o(274419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.n.a.g.10
 * JD-Core Version:    0.7.0.1
 */