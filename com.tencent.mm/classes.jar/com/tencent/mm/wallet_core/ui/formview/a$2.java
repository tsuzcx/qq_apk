package com.tencent.mm.wallet_core.ui.formview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tenpay.android.wechat.TenpaySecureEditText;

final class a$2
  extends a.b
{
  a$2()
  {
    super((byte)0);
  }
  
  public final boolean a(WalletFormView paramWalletFormView)
  {
    AppMethodBeat.i(49357);
    if (paramWalletFormView.AZe == null)
    {
      AppMethodBeat.o(49357);
      return false;
    }
    boolean bool = paramWalletFormView.AZe.isMoneyAmount();
    AppMethodBeat.o(49357);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.formview.a.2
 * JD-Core Version:    0.7.0.1
 */