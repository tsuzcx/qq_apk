package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.j.a.a.m;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;

final class aa$2
  implements Runnable
{
  aa$2(aa paramaa) {}
  
  public final void run()
  {
    AppMethodBeat.i(232903);
    if (!bg.aAc())
    {
      AppMethodBeat.o(232903);
      return;
    }
    bg.aVF();
    if (Util.secondsToNow(Util.nullAs((Long)c.azQ().get(68108, null), 0L)) * 1000L > 21600000L)
    {
      m localm = new m(37);
      bg.azz().a(localm, 0);
      bg.aVF();
      c.azQ().set(68108, Long.valueOf(Util.nowSecond()));
    }
    AppMethodBeat.o(232903);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.aa.2
 * JD-Core Version:    0.7.0.1
 */