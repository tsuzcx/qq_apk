package com.tencent.mm.plugin.wallet_core.ui;

import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletCheckPwdUI$5$1
  implements Runnable
{
  WalletCheckPwdUI$5$1(WalletCheckPwdUI.5 param5, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(47336);
    if (this.uqh)
    {
      WalletCheckPwdUI.h(this.uqi.uqg).fullScroll(130);
      AppMethodBeat.o(47336);
      return;
    }
    WalletCheckPwdUI.h(this.uqi.uqg).fullScroll(33);
    AppMethodBeat.o(47336);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI.5.1
 * JD-Core Version:    0.7.0.1
 */