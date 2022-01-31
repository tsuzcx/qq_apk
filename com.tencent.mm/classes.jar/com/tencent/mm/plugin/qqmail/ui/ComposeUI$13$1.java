package com.tencent.mm.plugin.qqmail.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ComposeUI$13$1
  implements DialogInterface.OnCancelListener
{
  ComposeUI$13$1(ComposeUI.13 param13) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(68185);
    ComposeUI.E(this.pMd.pLX).ceo();
    ComposeUI.E(this.pMd.pLX).pMT = null;
    AppMethodBeat.o(68185);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI.13.1
 * JD-Core Version:    0.7.0.1
 */