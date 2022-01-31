package com.tencent.mm.wallet_core.ui.formview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class a$6
  extends a.b
{
  a$6()
  {
    super((byte)0);
  }
  
  public final boolean a(WalletFormView paramWalletFormView)
  {
    AppMethodBeat.i(49361);
    boolean bool = bo.apH(paramWalletFormView.getText());
    AppMethodBeat.o(49361);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.formview.a.6
 * JD-Core Version:    0.7.0.1
 */