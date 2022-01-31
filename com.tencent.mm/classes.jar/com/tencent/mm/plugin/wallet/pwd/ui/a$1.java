package com.tencent.mm.plugin.wallet.pwd.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.b.e.c;

final class a$1
  implements e.c
{
  a$1(a parama) {}
  
  public final void d(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(142388);
    ab.i("MicroMsg.WalletRefundTimeDialog", "onDialogClick() bOk:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(142388);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.a.1
 * JD-Core Version:    0.7.0.1
 */