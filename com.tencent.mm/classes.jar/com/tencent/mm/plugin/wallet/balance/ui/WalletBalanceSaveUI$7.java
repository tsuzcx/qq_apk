package com.tencent.mm.plugin.wallet.balance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.ui.a;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.ui.widget.a.j;
import com.tencent.mm.ui.widget.a.j.a;
import java.util.ArrayList;
import java.util.List;

final class WalletBalanceSaveUI$7
  implements j.a
{
  WalletBalanceSaveUI$7(WalletBalanceSaveUI paramWalletBalanceSaveUI, List paramList) {}
  
  public final void onClick()
  {
    AppMethodBeat.i(316353);
    if (WalletBalanceSaveUI.j(this.Vdh) != null)
    {
      WalletBalanceSaveUI.j(this.Vdh).xcO.cyW();
      if ((WalletBalanceSaveUI.j(this.Vdh).pym >= 0) && (WalletBalanceSaveUI.j(this.Vdh).pym < this.JBV.size()))
      {
        this.Vdh.Vbu = ((Bankcard)WalletBalanceSaveUI.l(this.Vdh).get(WalletBalanceSaveUI.j(this.Vdh).pym));
        WalletBalanceSaveUI.k(this.Vdh);
        AppMethodBeat.o(316353);
        return;
      }
      this.Vdh.Vbu = null;
      WalletBalanceSaveUI.k(this.Vdh);
    }
    AppMethodBeat.o(316353);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI.7
 * JD-Core Version:    0.7.0.1
 */