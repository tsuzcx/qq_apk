package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class GestureGuardLogicUI$18
  implements DialogInterface.OnClickListener
{
  GestureGuardLogicUI$18(GestureGuardLogicUI paramGestureGuardLogicUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(51603);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(51603);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.18
 * JD-Core Version:    0.7.0.1
 */