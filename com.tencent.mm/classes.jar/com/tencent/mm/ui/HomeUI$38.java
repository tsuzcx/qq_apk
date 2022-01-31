package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.ui.FacebookAuthUI;

final class HomeUI$38
  implements DialogInterface.OnClickListener
{
  HomeUI$38(HomeUI paramHomeUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(153789);
    HomeUI.i(this.yYw).startActivity(new Intent(HomeUI.i(this.yYw), FacebookAuthUI.class));
    AppMethodBeat.o(153789);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.38
 * JD-Core Version:    0.7.0.1
 */