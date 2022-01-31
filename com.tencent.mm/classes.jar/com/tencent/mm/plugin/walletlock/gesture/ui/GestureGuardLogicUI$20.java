package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class GestureGuardLogicUI$20
  implements DialogInterface.OnClickListener
{
  GestureGuardLogicUI$20(GestureGuardLogicUI paramGestureGuardLogicUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(51605);
    paramDialogInterface.dismiss();
    GestureGuardLogicUI.t(this.uFf);
    GestureGuardLogicUI.a(this.uFf, 0, 4, "user cancel when setting gesture");
    AppMethodBeat.o(51605);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.20
 * JD-Core Version:    0.7.0.1
 */