package com.tencent.mm.plugin.wallet_core.id_verify;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;

final class WcPayRealnameVerifyCodeUI$5
  implements WalletFormView.a
{
  WcPayRealnameVerifyCodeUI$5(WcPayRealnameVerifyCodeUI paramWcPayRealnameVerifyCodeUI) {}
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(174461);
    Log.i("MicroMsg.WcPayRealNameVerifyCodeUI", "phone valid change: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    WcPayRealnameVerifyCodeUI.g(this.HSe);
    WcPayRealnameVerifyCodeUI.d(this.HSe);
    AppMethodBeat.o(174461);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyCodeUI.5
 * JD-Core Version:    0.7.0.1
 */