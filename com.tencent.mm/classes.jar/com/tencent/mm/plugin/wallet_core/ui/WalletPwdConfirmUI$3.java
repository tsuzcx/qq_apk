package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;

final class WalletPwdConfirmUI$3
  implements EditHintPasswdView.a
{
  WalletPwdConfirmUI$3(WalletPwdConfirmUI paramWalletPwdConfirmUI) {}
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(47540);
    if (paramBoolean)
    {
      String str1 = this.usw.getInput().getString("key_new_pwd1");
      String str2 = this.usw.nID.getMd5Value();
      if ((str1 == null) || (!str1.equals(str2)))
      {
        a.q(this.usw, -1002);
        AppMethodBeat.o(47540);
        return;
      }
      WalletPwdConfirmUI.b(this.usw).setEnabled(paramBoolean);
      WalletPwdConfirmUI.b(this.usw).setClickable(paramBoolean);
      AppMethodBeat.o(47540);
      return;
    }
    WalletPwdConfirmUI.b(this.usw).setEnabled(paramBoolean);
    WalletPwdConfirmUI.b(this.usw).setClickable(paramBoolean);
    AppMethodBeat.o(47540);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI.3
 * JD-Core Version:    0.7.0.1
 */