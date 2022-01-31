package com.tencent.mm.plugin.wallet_core.ui;

import android.widget.ScrollView;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.ui.a;

final class WalletCheckPwdUI$5
  implements a
{
  WalletCheckPwdUI$5(WalletCheckPwdUI paramWalletCheckPwdUI) {}
  
  public final void gK(boolean paramBoolean)
  {
    y.d("Micromsg.WalletCheckPwdUI", "kb visibility: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    WalletCheckPwdUI.h(this.qDk).post(new WalletCheckPwdUI.5.1(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI.5
 * JD-Core Version:    0.7.0.1
 */