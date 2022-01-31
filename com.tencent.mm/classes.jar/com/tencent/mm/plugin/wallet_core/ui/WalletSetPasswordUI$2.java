package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;

final class WalletSetPasswordUI$2
  implements EditHintPasswdView.a
{
  WalletSetPasswordUI$2(WalletSetPasswordUI paramWalletSetPasswordUI) {}
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(47665);
    if (paramBoolean)
    {
      String str = this.utK.nID.getMd5Value();
      Bundle localBundle = new Bundle();
      localBundle.putString("key_new_pwd1", str);
      this.utK.nID.cfK();
      a.j(this.utK, localBundle);
    }
    AppMethodBeat.o(47665);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI.2
 * JD-Core Version:    0.7.0.1
 */