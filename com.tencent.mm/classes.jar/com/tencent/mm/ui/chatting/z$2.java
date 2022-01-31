package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.g.a.a.m;

final class z$2
  implements Runnable
{
  z$2(z paramz) {}
  
  public final void run()
  {
    AppMethodBeat.i(30917);
    if (!aw.RG())
    {
      AppMethodBeat.o(30917);
      return;
    }
    aw.aaz();
    if (ah.gz(ah.d((Long)c.Ru().get(68108, null))) * 1000L > 21600000L)
    {
      m localm = new m(37);
      aw.Rc().a(localm, 0);
      aw.aaz();
      c.Ru().set(68108, Long.valueOf(ah.aox()));
    }
    AppMethodBeat.o(30917);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.z.2
 * JD-Core Version:    0.7.0.1
 */