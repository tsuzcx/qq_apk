package com.tencent.mm.plugin.wallet_core.ui;

import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.ui.a;

final class WalletCheckPwdUI$5
  implements a
{
  WalletCheckPwdUI$5(WalletCheckPwdUI paramWalletCheckPwdUI) {}
  
  public final void onVisibleStateChange(boolean paramBoolean)
  {
    AppMethodBeat.i(47337);
    ab.d("Micromsg.WalletCheckPwdUI", "kb visibility: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    WalletCheckPwdUI.h(this.uqg).post(new WalletCheckPwdUI.5.1(this, paramBoolean));
    AppMethodBeat.o(47337);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI.5
 * JD-Core Version:    0.7.0.1
 */