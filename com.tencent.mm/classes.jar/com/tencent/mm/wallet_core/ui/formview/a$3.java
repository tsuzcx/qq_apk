package com.tencent.mm.wallet_core.ui.formview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class a$3
  extends a.b
{
  a$3()
  {
    super((byte)0);
  }
  
  public final boolean cfH()
  {
    return true;
  }
  
  public final String e(WalletFormView paramWalletFormView, String paramString)
  {
    AppMethodBeat.i(49358);
    paramWalletFormView = bo.bf((String)paramWalletFormView.getTag(), "").replace("/", "");
    AppMethodBeat.o(49358);
    return paramWalletFormView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.formview.a.3
 * JD-Core Version:    0.7.0.1
 */