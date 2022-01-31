package com.tencent.mm.plugin.wallet.balance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vf;
import com.tencent.mm.g.a.vf.b;
import com.tencent.mm.plugin.wallet_core.model.a.a;

final class WalletBalanceManagerUI$9
  implements a.a
{
  WalletBalanceManagerUI$9(WalletBalanceManagerUI paramWalletBalanceManagerUI) {}
  
  public final void r(Object... paramVarArgs)
  {
    AppMethodBeat.i(142285);
    if ((this.tOJ.isFinishing()) || (this.tOJ.hasFinish()) || (this.tOJ.isDestroyed()))
    {
      AppMethodBeat.o(142285);
      return;
    }
    if ((paramVarArgs[0] instanceof vf))
    {
      paramVarArgs = (vf)paramVarArgs[0];
      if ((paramVarArgs.cLK.cMo) && (paramVarArgs.cLK.errCode == 0))
      {
        WalletBalanceManagerUI.a(this.tOJ, paramVarArgs.cLK.cMn);
        WalletBalanceManagerUI.c(this.tOJ);
        this.tOJ.bJ();
        this.tOJ.cfA();
      }
    }
    AppMethodBeat.o(142285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.9
 * JD-Core Version:    0.7.0.1
 */