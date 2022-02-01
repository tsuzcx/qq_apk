package com.tencent.mm.plugin.wallet.balance.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

final class WalletBalanceManagerUI$15
  implements View.OnClickListener
{
  WalletBalanceManagerUI$15(WalletBalanceManagerUI paramWalletBalanceManagerUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68661);
    b localb = new b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    g.aAi();
    g.aAh().azQ().set(ar.a.OcP, Integer.valueOf(-1));
    paramView = new Bundle();
    paramView.putInt("real_name_verify_mode", 0);
    paramView.putString("realname_verify_process_jump_plugin", "wallet");
    paramView.putString("realname_verify_process_jump_activity", "com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI");
    paramView.putInt("entry_scene", 1009);
    com.tencent.mm.wallet_core.a.a(this.Hwm, com.tencent.mm.plugin.wallet_core.id_verify.a.class, paramView);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceManagerUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(68661);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.15
 * JD-Core Version:    0.7.0.1
 */