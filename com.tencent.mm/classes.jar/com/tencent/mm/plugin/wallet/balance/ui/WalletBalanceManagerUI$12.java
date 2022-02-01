package com.tencent.mm.plugin.wallet.balance.ui;

import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.wallet_core.ui.k;

final class WalletBalanceManagerUI$12
  extends k
{
  WalletBalanceManagerUI$12(WalletBalanceManagerUI paramWalletBalanceManagerUI) {}
  
  public final void dr(View paramView)
  {
    AppMethodBeat.i(316289);
    h.baF();
    h.baE().ban().set(at.a.acSy, Integer.valueOf(-1));
    paramView = new Bundle();
    paramView.putInt("real_name_verify_mode", 0);
    paramView.putString("realname_verify_process_jump_plugin", "wallet");
    paramView.putString("realname_verify_process_jump_activity", "com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI");
    paramView.putInt("entry_scene", 1009);
    com.tencent.mm.wallet_core.a.a(this.VcP, com.tencent.mm.plugin.wallet_core.id_verify.a.class, paramView);
    AppMethodBeat.o(316289);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.12
 * JD-Core Version:    0.7.0.1
 */