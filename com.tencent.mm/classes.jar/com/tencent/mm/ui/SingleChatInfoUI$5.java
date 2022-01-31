package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.plugin.report.service.h;

final class SingleChatInfoUI$5
  implements DialogInterface.OnClickListener
{
  SingleChatInfoUI$5(SingleChatInfoUI paramSingleChatInfoUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    h.nFQ.f(14553, new Object[] { Integer.valueOf(6), Integer.valueOf(4), SingleChatInfoUI.d(this.uQS) });
    SingleChatInfoUI.mX(true);
    if (!SingleChatInfoUI.e(this.uQS))
    {
      paramDialogInterface = LauncherUI.cyX();
      if (paramDialogInterface != null) {
        paramDialogInterface.startChatting(SingleChatInfoUI.f(this.uQS).field_username, null, true);
      }
      return;
    }
    this.uQS.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.SingleChatInfoUI.5
 * JD-Core Version:    0.7.0.1
 */