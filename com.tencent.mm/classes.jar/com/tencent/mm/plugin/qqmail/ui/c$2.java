package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bk.a;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.qqmail.a.a;
import com.tencent.mm.pluginsdk.m;

final class c$2
  implements bk.a
{
  c$2(c paramc) {}
  
  public final void a(e parame)
  {
    AppMethodBeat.i(68412);
    if (parame == null)
    {
      AppMethodBeat.o(68412);
      return;
    }
    com.tencent.mm.network.c localc = parame.adI();
    int i = parame.adI().getUin();
    localc.a(new byte[0], new byte[0], new byte[0], i);
    a.gmP.BO();
    AppMethodBeat.o(68412);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.c.2
 * JD-Core Version:    0.7.0.1
 */