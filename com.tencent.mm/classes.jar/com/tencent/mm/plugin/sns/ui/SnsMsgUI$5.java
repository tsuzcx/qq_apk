package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.p;

final class SnsMsgUI$5
  implements DialogInterface.OnCancelListener
{
  SnsMsgUI$5(SnsMsgUI paramSnsMsgUI, p paramp) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(198364);
    g.ajD();
    g.ajB().gAO.a(this.AfG);
    AppMethodBeat.o(198364);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI.5
 * JD-Core Version:    0.7.0.1
 */