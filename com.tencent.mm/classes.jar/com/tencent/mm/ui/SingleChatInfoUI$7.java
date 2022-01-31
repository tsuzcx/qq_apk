package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.plugin.report.service.h;

final class SingleChatInfoUI$7
  implements DialogInterface.OnClickListener
{
  SingleChatInfoUI$7(SingleChatInfoUI paramSingleChatInfoUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(29874);
    h.qsU.e(14553, new Object[] { Integer.valueOf(6), Integer.valueOf(4), SingleChatInfoUI.e(this.zfe) });
    SingleChatInfoUI.qA(true);
    if (!SingleChatInfoUI.f(this.zfe))
    {
      paramDialogInterface = LauncherUI.getInstance();
      if (paramDialogInterface != null) {
        paramDialogInterface.startChatting(SingleChatInfoUI.g(this.zfe).field_username, null, true);
      }
      AppMethodBeat.o(29874);
      return;
    }
    this.zfe.finish();
    AppMethodBeat.o(29874);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.SingleChatInfoUI.7
 * JD-Core Version:    0.7.0.1
 */