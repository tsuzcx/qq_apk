package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import android.view.View;
import com.tencent.mm.plugin.wallet_core.ui.view.SwitchPhoneItemGroupView.a;
import com.tencent.mm.protocal.c.ft;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.List;

final class WalletSwitchVerifyPhoneUI$1
  implements SwitchPhoneItemGroupView.a
{
  WalletSwitchVerifyPhoneUI$1(WalletSwitchVerifyPhoneUI paramWalletSwitchVerifyPhoneUI) {}
  
  public final void dp(View paramView)
  {
    int i;
    if (paramView.getTag() != null)
    {
      i = ((Integer)paramView.getTag()).intValue();
      y.d("MicroMsg.WalletSwitchVerifyPhoneUI", "index: %d", new Object[] { Integer.valueOf(i) });
      if (i == -1)
      {
        y.i("MicroMsg.WalletSwitchVerifyPhoneUI", "do bind new card");
        WalletSwitchVerifyPhoneUI.a(this.qGI);
      }
    }
    else
    {
      return;
    }
    if (i == -2)
    {
      y.i("MicroMsg.WalletSwitchVerifyPhoneUI", "do verify idcard tail");
      this.qGI.BX.putBoolean("key_forward_to_id_verify", true);
      a.j(this.qGI, this.qGI.BX);
      return;
    }
    paramView = (ft)WalletSwitchVerifyPhoneUI.b(this.qGI).get(i);
    this.qGI.BX.putBoolean("key_balance_change_phone_need_confirm_phone", false);
    this.qGI.BX.putBoolean("key_forward_to_id_verify", false);
    y.i("MicroMsg.WalletSwitchVerifyPhoneUI", "select wx phone: %s", new Object[] { Boolean.valueOf(paramView.szN.equals("wx")) });
    this.qGI.cNk().m(new Object[] { paramView });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletSwitchVerifyPhoneUI.1
 * JD-Core Version:    0.7.0.1
 */