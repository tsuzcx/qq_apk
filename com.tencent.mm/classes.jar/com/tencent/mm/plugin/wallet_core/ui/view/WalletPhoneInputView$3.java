package com.tencent.mm.plugin.wallet_core.ui.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.a.b;

final class WalletPhoneInputView$3
  implements b
{
  WalletPhoneInputView$3(WalletPhoneInputView paramWalletPhoneInputView) {}
  
  public final boolean a(WalletFormView paramWalletFormView)
  {
    AppMethodBeat.i(47910);
    if (this.uwX.cWJ())
    {
      boolean bool = paramWalletFormView.isPhoneNum();
      AppMethodBeat.o(47910);
      return bool;
    }
    if ((!bo.isNullOrNil(WalletPhoneInputView.a(this.uwX))) && (!bo.isNullOrNil(WalletPhoneInputView.b(this.uwX))) && (!bo.isNullOrNil(WalletPhoneInputView.c(this.uwX).getText())))
    {
      AppMethodBeat.o(47910);
      return true;
    }
    AppMethodBeat.o(47910);
    return false;
  }
  
  public final boolean c(WalletFormView paramWalletFormView, String paramString)
  {
    return false;
  }
  
  public final boolean cfH()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletPhoneInputView.3
 * JD-Core Version:    0.7.0.1
 */