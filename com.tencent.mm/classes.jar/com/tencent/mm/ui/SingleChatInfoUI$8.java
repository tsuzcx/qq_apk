package com.tencent.mm.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

final class SingleChatInfoUI$8
  implements DialogInterface.OnClickListener
{
  SingleChatInfoUI$8(SingleChatInfoUI paramSingleChatInfoUI, ProgressDialog paramProgressDialog) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(29875);
    h.qsU.e(14553, new Object[] { Integer.valueOf(6), Integer.valueOf(3), SingleChatInfoUI.e(this.zfe) });
    this.efE.show();
    SingleChatInfoUI.qA(false);
    SingleChatInfoUI.a(this.zfe, this.efE);
    AppMethodBeat.o(29875);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.SingleChatInfoUI.8
 * JD-Core Version:    0.7.0.1
 */