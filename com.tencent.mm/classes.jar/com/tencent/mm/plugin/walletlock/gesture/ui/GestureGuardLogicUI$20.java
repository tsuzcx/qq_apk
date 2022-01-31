package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class GestureGuardLogicUI$20
  implements DialogInterface.OnClickListener
{
  GestureGuardLogicUI$20(GestureGuardLogicUI paramGestureGuardLogicUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    GestureGuardLogicUI.t(this.qPX);
    GestureGuardLogicUI.a(this.qPX, 0, 4, "user cancel when setting gesture");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.20
 * JD-Core Version:    0.7.0.1
 */