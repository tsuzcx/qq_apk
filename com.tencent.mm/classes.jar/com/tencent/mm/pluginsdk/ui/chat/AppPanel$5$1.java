package com.tencent.mm.pluginsdk.ui.chat;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vj;
import com.tencent.mm.sdk.b.a;

final class AppPanel$5$1
  implements DialogInterface.OnClickListener
{
  AppPanel$5$1(AppPanel.5 param5) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(204869);
    vj localvj = new vj();
    localvj.dAP.dAS = true;
    a.ESL.l(localvj);
    AppPanel.n(this.Lwy.CaF).cOf();
    paramDialogInterface.dismiss();
    AppMethodBeat.o(204869);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.AppPanel.5.1
 * JD-Core Version:    0.7.0.1
 */