package com.tencent.mm.pluginsdk.ui.chat;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.tl;
import com.tencent.mm.sdk.b.a;

final class AppPanel$4$3
  implements DialogInterface.OnClickListener
{
  AppPanel$4$3(AppPanel.4 param4) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(27746);
    tl localtl = new tl();
    localtl.cJT.cJW = true;
    a.ymk.l(localtl);
    AppPanel.k(this.vVt.vVs).bPp();
    paramDialogInterface.dismiss();
    AppMethodBeat.o(27746);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.AppPanel.4.3
 * JD-Core Version:    0.7.0.1
 */