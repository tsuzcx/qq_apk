package com.tencent.mm.plugin.qqmail.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.qqmail.b.ac;
import com.tencent.mm.plugin.qqmail.b.v;

final class ComposeUI$11$1
  implements DialogInterface.OnCancelListener
{
  ComposeUI$11$1(ComposeUI.11 param11) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(68180);
    ComposeUI.E(this.pMc.pLX).ceo();
    ComposeUI.E(this.pMc.pLX).pMT = null;
    ac.cdQ().cancel(ComposeUI.F(this.pMc.pLX));
    AppMethodBeat.o(68180);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI.11.1
 * JD-Core Version:    0.7.0.1
 */