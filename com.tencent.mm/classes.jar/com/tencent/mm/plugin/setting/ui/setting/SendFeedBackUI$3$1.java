package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.model.j;

final class SendFeedBackUI$3$1
  implements DialogInterface.OnCancelListener
{
  SendFeedBackUI$3$1(SendFeedBackUI.3 param3, j paramj) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(127045);
    g.Rc().a(this.qGH);
    AppMethodBeat.o(127045);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SendFeedBackUI.3.1
 * JD-Core Version:    0.7.0.1
 */