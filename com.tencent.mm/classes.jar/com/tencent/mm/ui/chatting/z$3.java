package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.pluginsdk.h.a.a.m;
import com.tencent.mm.storage.ab;

final class z$3
  implements Runnable
{
  z$3(z paramz) {}
  
  public final void run()
  {
    AppMethodBeat.i(34792);
    if (!az.afw())
    {
      AppMethodBeat.o(34792);
      return;
    }
    az.arV();
    if (ae.lZ(ae.c((Long)c.afk().get(68108, null))) * 1000L > 21600000L)
    {
      m localm = new m(37);
      az.aeS().a(localm, 0);
      az.arV();
      c.afk().set(68108, Long.valueOf(ae.aGK()));
    }
    AppMethodBeat.o(34792);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.z.3
 * JD-Core Version:    0.7.0.1
 */