package com.tencent.mm.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMTextInputUI$1
  implements DialogInterface.OnClickListener
{
  MMTextInputUI$1(MMTextInputUI paramMMTextInputUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(107724);
    this.Awk.hideVKB();
    this.Awk.setResult(0);
    this.Awk.finish();
    AppMethodBeat.o(107724);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MMTextInputUI.1
 * JD-Core Version:    0.7.0.1
 */