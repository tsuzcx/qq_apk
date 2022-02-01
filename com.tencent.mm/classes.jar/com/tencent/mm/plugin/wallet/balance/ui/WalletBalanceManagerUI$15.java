package com.tencent.mm.plugin.wallet.balance.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;

final class WalletBalanceManagerUI$15
  implements View.OnClickListener
{
  WalletBalanceManagerUI$15(WalletBalanceManagerUI paramWalletBalanceManagerUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(68661);
    g.agS();
    g.agR().agA().set(ah.a.GNL, Integer.valueOf(-1));
    paramView = new Bundle();
    paramView.putInt("real_name_verify_mode", 0);
    paramView.putString("realname_verify_process_jump_plugin", "wallet");
    paramView.putString("realname_verify_process_jump_activity", "com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI");
    paramView.putInt("entry_scene", 1009);
    com.tencent.mm.wallet_core.a.a(this.AZz, com.tencent.mm.plugin.wallet_core.id_verify.a.class, paramView);
    AppMethodBeat.o(68661);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.15
 * JD-Core Version:    0.7.0.1
 */