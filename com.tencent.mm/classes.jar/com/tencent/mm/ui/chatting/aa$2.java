package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.k.a.a.m;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;

final class aa$2
  implements Runnable
{
  aa$2(aa paramaa) {}
  
  public final void run()
  {
    AppMethodBeat.i(290366);
    if (!bh.aHB())
    {
      AppMethodBeat.o(290366);
      return;
    }
    bh.beI();
    if (Util.secondsToNow(Util.nullAs((Long)c.aHp().b(68108, null), 0L)) * 1000L > 21600000L)
    {
      m localm = new m(37);
      bh.aGY().a(localm, 0);
      bh.beI();
      c.aHp().i(68108, Long.valueOf(Util.nowSecond()));
    }
    AppMethodBeat.o(290366);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.aa.2
 * JD-Core Version:    0.7.0.1
 */