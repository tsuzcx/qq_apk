package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.ui.view.SwitchPhoneItemGroupView.a;
import com.tencent.mm.protocal.protobuf.hc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.d.g;
import java.util.List;

final class WalletSwitchVerifyPhoneUI$1
  implements SwitchPhoneItemGroupView.a
{
  WalletSwitchVerifyPhoneUI$1(WalletSwitchVerifyPhoneUI paramWalletSwitchVerifyPhoneUI) {}
  
  public final void eu(View paramView)
  {
    AppMethodBeat.i(47670);
    if (paramView.getTag() != null)
    {
      int i = ((Integer)paramView.getTag()).intValue();
      ab.d("MicroMsg.WalletSwitchVerifyPhoneUI", "index: %d", new Object[] { Integer.valueOf(i) });
      if (i == -1)
      {
        ab.i("MicroMsg.WalletSwitchVerifyPhoneUI", "do bind new card");
        WalletSwitchVerifyPhoneUI.a(this.utO);
        AppMethodBeat.o(47670);
        return;
      }
      if (i == -2)
      {
        ab.i("MicroMsg.WalletSwitchVerifyPhoneUI", "do verify idcard tail");
        this.utO.getInput().putBoolean("key_forward_to_id_verify", true);
        a.j(this.utO, this.utO.getInput());
        AppMethodBeat.o(47670);
        return;
      }
      paramView = (hc)WalletSwitchVerifyPhoneUI.b(this.utO).get(i);
      this.utO.getInput().putBoolean("key_balance_change_phone_need_confirm_phone", false);
      this.utO.getInput().putBoolean("key_forward_to_id_verify", false);
      ab.i("MicroMsg.WalletSwitchVerifyPhoneUI", "select wx phone: %s", new Object[] { Boolean.valueOf(paramView.wtO.equals("wx")) });
      this.utO.getNetController().p(new Object[] { paramView });
    }
    AppMethodBeat.o(47670);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletSwitchVerifyPhoneUI.1
 * JD-Core Version:    0.7.0.1
 */