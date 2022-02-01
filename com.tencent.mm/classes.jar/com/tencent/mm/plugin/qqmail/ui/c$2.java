package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.qqmail.a.a;
import com.tencent.mm.pluginsdk.l;

final class c$2
  implements bw.a
{
  c$2(c paramc) {}
  
  public final void b(g paramg)
  {
    AppMethodBeat.i(123140);
    if (paramg == null)
    {
      AppMethodBeat.o(123140);
      return;
    }
    e locale = paramg.bGg();
    int i = paramg.bGg().getUin();
    locale.a(new byte[0], new byte[0], new byte[0], i);
    a.pFo.aDx();
    AppMethodBeat.o(123140);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.c.2
 * JD-Core Version:    0.7.0.1
 */