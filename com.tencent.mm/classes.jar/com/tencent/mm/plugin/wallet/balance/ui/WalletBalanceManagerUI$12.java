package com.tencent.mm.plugin.wallet.balance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.ui.f;
import java.util.ArrayList;

final class WalletBalanceManagerUI$12
  implements View.OnClickListener
{
  WalletBalanceManagerUI$12(WalletBalanceManagerUI paramWalletBalanceManagerUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68658);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    s.fOg();
    paramView = s.fOh().fRG();
    if ((paramView == null) || (paramView.size() == 0))
    {
      Log.i("MicroMsg.WalletBalanceManagerUI", "mBankcardList is empty, do bind card to fetch");
      WalletBalanceManagerUI.d(this.Hwm);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(68658);
      return;
      Log.i("MicroMsg.WalletBalanceManagerUI", "mBankcardList is valid, to do fetch");
      com.tencent.mm.wallet_core.a.a(this.Hwm, com.tencent.mm.plugin.wallet.balance.b.class, null, null);
      f.aqm(15);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.12
 * JD-Core Version:    0.7.0.1
 */