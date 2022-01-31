package com.tencent.mm.plugin.remittance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.b.e.c;

final class SelectRemittanceContactUI$1
  implements e.c
{
  SelectRemittanceContactUI$1(SelectRemittanceContactUI paramSelectRemittanceContactUI) {}
  
  public final void d(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(142267);
    ab.i("MicroMsg.SelectRemittanceContactUI", "onDialogClick() bOk:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(142267);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.SelectRemittanceContactUI.1
 * JD-Core Version:    0.7.0.1
 */