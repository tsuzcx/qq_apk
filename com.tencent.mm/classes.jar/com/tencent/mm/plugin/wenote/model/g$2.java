package com.tencent.mm.plugin.wenote.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.a.m;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.protocal.protobuf.acq;
import java.util.HashMap;

final class g$2
  implements Runnable
{
  g$2(g paramg, acq paramacq) {}
  
  public final void run()
  {
    AppMethodBeat.i(26618);
    if (this.vwu != null)
    {
      com.tencent.mm.plugin.fav.a.g localg = new com.tencent.mm.plugin.fav.a.g();
      localg.field_localId = g.a(this.vwv);
      localg.field_favProto = this.vwu;
      this.vwv.vwc = localg.field_favProto;
      this.vwv.vvT = localg;
      g.a(this.vwv, localg);
    }
    if (g.bGj().containsKey(g.b(this.vwv))) {
      this.vwv.vvS = ((m)g.bGj().get(g.b(this.vwv)));
    }
    for (;;)
    {
      this.vwv.el(this.vwv.vvS.pZa);
      if (k.diU() != null) {
        k.diY();
      }
      AppMethodBeat.o(26618);
      return;
      g.c(this.vwv);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(26619);
    String str = super.toString() + "|dealWNoteInfo";
    AppMethodBeat.o(26619);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.g.2
 * JD-Core Version:    0.7.0.1
 */