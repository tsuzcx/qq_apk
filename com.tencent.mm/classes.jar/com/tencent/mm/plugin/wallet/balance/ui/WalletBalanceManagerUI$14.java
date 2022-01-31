package com.tencent.mm.plugin.wallet.balance.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class WalletBalanceManagerUI$14
  implements View.OnClickListener
{
  WalletBalanceManagerUI$14(WalletBalanceManagerUI paramWalletBalanceManagerUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(45440);
    g.RM();
    g.RL().Ru().set(ac.a.yHk, Integer.valueOf(-1));
    paramView = new Bundle();
    paramView.putInt("real_name_verify_mode", 0);
    paramView.putString("realname_verify_process_jump_plugin", "wallet");
    paramView.putString("realname_verify_process_jump_activity", "com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI");
    paramView.putInt("entry_scene", 1009);
    com.tencent.mm.wallet_core.a.a(this.tOJ, com.tencent.mm.plugin.wallet_core.id_verify.a.class, paramView);
    AppMethodBeat.o(45440);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.14
 * JD-Core Version:    0.7.0.1
 */