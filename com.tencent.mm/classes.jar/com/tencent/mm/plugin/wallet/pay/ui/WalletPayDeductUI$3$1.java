package com.tencent.mm.plugin.wallet.pay.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.ui.base.h.a;
import java.util.List;

final class WalletPayDeductUI$3$1
  implements h.a
{
  WalletPayDeductUI$3$1(WalletPayDeductUI.3 param3) {}
  
  public final void Ch(int paramInt)
  {
    AppMethodBeat.i(46019);
    WalletPayDeductUI.a(this.tWy.tWw, (Bankcard)this.tWy.tWx.get(paramInt));
    WalletPayDeductUI.c(this.tWy.tWw);
    AppMethodBeat.o(46019);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayDeductUI.3.1
 * JD-Core Version:    0.7.0.1
 */