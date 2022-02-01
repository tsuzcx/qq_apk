package com.tencent.mm.plugin.wallet.pwd.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.f.c;

final class a$1
  implements f.c
{
  a$1(a parama) {}
  
  public final void g(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(69780);
    Log.i("MicroMsg.WalletRefundTimeDialog", "onDialogClick() bOk:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(69780);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.a.1
 * JD-Core Version:    0.7.0.1
 */