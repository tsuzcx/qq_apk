package com.tencent.mm.plugin.wallet_core.ui.view;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.a.b;

final class WalletPhoneInputView$3
  implements b
{
  WalletPhoneInputView$3(WalletPhoneInputView paramWalletPhoneInputView) {}
  
  public final boolean a(WalletFormView paramWalletFormView)
  {
    if (this.qIp.bXi()) {
      return paramWalletFormView.isPhoneNum();
    }
    return (!bk.bl(WalletPhoneInputView.a(this.qIp))) && (!bk.bl(WalletPhoneInputView.b(this.qIp))) && (!bk.bl(WalletPhoneInputView.c(this.qIp).getText()));
  }
  
  public final boolean bvo()
  {
    return false;
  }
  
  public final boolean c(WalletFormView paramWalletFormView, String paramString)
  {
    return false;
  }
  
  public final boolean d(WalletFormView paramWalletFormView, String paramString)
  {
    return false;
  }
  
  public final String e(WalletFormView paramWalletFormView, String paramString)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletPhoneInputView.3
 * JD-Core Version:    0.7.0.1
 */