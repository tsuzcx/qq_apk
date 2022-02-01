package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.h.a.a.m;

final class z$3
  implements Runnable
{
  z$3(z paramz) {}
  
  public final void run()
  {
    AppMethodBeat.i(34792);
    if (!az.agM())
    {
      AppMethodBeat.o(34792);
      return;
    }
    az.ayM();
    if (com.tencent.mm.platformtools.ae.pN(com.tencent.mm.platformtools.ae.d((Long)c.agA().get(68108, null))) * 1000L > 21600000L)
    {
      m localm = new m(37);
      az.agi().a(localm, 0);
      az.ayM();
      c.agA().set(68108, Long.valueOf(com.tencent.mm.platformtools.ae.aNx()));
    }
    AppMethodBeat.o(34792);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.z.3
 * JD-Core Version:    0.7.0.1
 */