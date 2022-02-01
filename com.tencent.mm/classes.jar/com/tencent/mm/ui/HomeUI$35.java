package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.permission.b;

final class HomeUI$35
  implements DialogInterface.OnClickListener
{
  HomeUI$35(HomeUI paramHomeUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(249081);
    paramDialogInterface.dismiss();
    b.lx(HomeUI.c(this.adBf));
    AppMethodBeat.o(249081);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.35
 * JD-Core Version:    0.7.0.1
 */