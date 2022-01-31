package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class GestureGuardLogicUI$17
  implements DialogInterface.OnClickListener
{
  GestureGuardLogicUI$17(GestureGuardLogicUI paramGestureGuardLogicUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    GestureGuardLogicUI.t(this.qPX);
    this.qPX.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.17
 * JD-Core Version:    0.7.0.1
 */