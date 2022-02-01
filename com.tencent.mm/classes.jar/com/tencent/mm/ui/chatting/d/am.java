package com.tencent.mm.ui.chatting.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;

public class am
  extends a
  implements ag
{
  public final void hGW()
  {
    AppMethodBeat.i(276138);
    if (!ab.Qg(this.fgR.getTalkerUserName())) {
      ((com.tencent.mm.plugin.wxpay.a.a)h.ag(com.tencent.mm.plugin.wxpay.a.a.class)).unMarkLuckyMoneyRedFlag(this.fgR.getTalkerUserName());
    }
    AppMethodBeat.o(276138);
  }
  
  public final void hHa()
  {
    AppMethodBeat.i(276139);
    if (!ab.Qg(this.fgR.getTalkerUserName())) {
      ((com.tencent.mm.plugin.wxpay.a.a)h.ag(com.tencent.mm.plugin.wxpay.a.a.class)).unMarkLuckyMoneyRedFlag(this.fgR.getTalkerUserName());
    }
    AppMethodBeat.o(276139);
  }
  
  public final void hNZ()
  {
    AppMethodBeat.i(276141);
    super.hNZ();
    if (!ab.Qg(this.fgR.getTalkerUserName())) {
      ((com.tencent.mm.plugin.wxpay.a.a)h.ag(com.tencent.mm.plugin.wxpay.a.a.class)).unMarkLuckyMoneyRedFlag(this.fgR.getTalkerUserName());
    }
    AppMethodBeat.o(276141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.am
 * JD-Core Version:    0.7.0.1
 */