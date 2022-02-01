package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class HomeUI$30
  implements DialogInterface.OnClickListener
{
  HomeUI$30(HomeUI paramHomeUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(163263);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(163263);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.30
 * JD-Core Version:    0.7.0.1
 */