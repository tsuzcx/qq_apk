package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsMsgUI$7
  implements DialogInterface.OnClickListener
{
  SnsMsgUI$7(SnsMsgUI paramSnsMsgUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(39071);
    SnsMsgUI.a(this.rSU, true);
    AppMethodBeat.o(39071);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI.7
 * JD-Core Version:    0.7.0.1
 */