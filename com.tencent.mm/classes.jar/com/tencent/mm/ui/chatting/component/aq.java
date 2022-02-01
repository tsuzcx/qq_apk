package com.tencent.mm.ui.chatting.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;

public class aq
  extends a
  implements aj
{
  public final void jjh()
  {
    AppMethodBeat.i(255777);
    if (!ab.IN(this.hlc.getTalkerUserName())) {
      ((com.tencent.mm.plugin.wxpay.a.a)h.az(com.tencent.mm.plugin.wxpay.a.a.class)).unMarkLuckyMoneyRedFlag(this.hlc.getTalkerUserName());
    }
    AppMethodBeat.o(255777);
  }
  
  public final void jjl()
  {
    AppMethodBeat.i(255779);
    if (!ab.IN(this.hlc.getTalkerUserName())) {
      ((com.tencent.mm.plugin.wxpay.a.a)h.az(com.tencent.mm.plugin.wxpay.a.a.class)).unMarkLuckyMoneyRedFlag(this.hlc.getTalkerUserName());
    }
    AppMethodBeat.o(255779);
  }
  
  public final void jqF()
  {
    AppMethodBeat.i(255782);
    super.jqF();
    if (!ab.IN(this.hlc.getTalkerUserName())) {
      ((com.tencent.mm.plugin.wxpay.a.a)h.az(com.tencent.mm.plugin.wxpay.a.a.class)).unMarkLuckyMoneyRedFlag(this.hlc.getTalkerUserName());
    }
    AppMethodBeat.o(255782);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.aq
 * JD-Core Version:    0.7.0.1
 */