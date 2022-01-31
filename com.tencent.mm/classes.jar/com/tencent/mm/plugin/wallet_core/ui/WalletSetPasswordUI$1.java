package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletSetPasswordUI$1
  implements View.OnClickListener
{
  WalletSetPasswordUI$1(WalletSetPasswordUI paramWalletSetPasswordUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47664);
    if (this.utK.needConfirmFinish())
    {
      this.utK.hideVKB();
      this.utK.showDialog(1000);
      AppMethodBeat.o(47664);
      return;
    }
    this.utK.finish();
    AppMethodBeat.o(47664);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI.1
 * JD-Core Version:    0.7.0.1
 */