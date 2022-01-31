package com.tencent.mm.plugin.qqmail.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ComposeUI$10$1
  implements DialogInterface.OnClickListener
{
  ComposeUI$10$1(ComposeUI.10 param10) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(68178);
    this.pMb.pLX.setResult(0);
    this.pMb.pLX.finish();
    AppMethodBeat.o(68178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI.10.1
 * JD-Core Version:    0.7.0.1
 */