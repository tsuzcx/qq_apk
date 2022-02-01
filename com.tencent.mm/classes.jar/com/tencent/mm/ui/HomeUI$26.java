package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class HomeUI$26
  implements DialogInterface.OnClickListener
{
  HomeUI$26(HomeUI paramHomeUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(33204);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(33204);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.26
 * JD-Core Version:    0.7.0.1
 */