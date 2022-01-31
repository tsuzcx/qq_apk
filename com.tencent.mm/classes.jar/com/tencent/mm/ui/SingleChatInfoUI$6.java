package com.tencent.mm.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.h;

final class SingleChatInfoUI$6
  implements DialogInterface.OnClickListener
{
  SingleChatInfoUI$6(SingleChatInfoUI paramSingleChatInfoUI, ProgressDialog paramProgressDialog) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    h.nFQ.f(14553, new Object[] { Integer.valueOf(6), Integer.valueOf(3), SingleChatInfoUI.d(this.uQS) });
    this.doh.show();
    SingleChatInfoUI.mX(false);
    SingleChatInfoUI.a(this.uQS, this.doh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.SingleChatInfoUI.6
 * JD-Core Version:    0.7.0.1
 */