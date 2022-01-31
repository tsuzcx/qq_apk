package com.tencent.mm.ui.bizchat;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.aj.a.x;
import com.tencent.mm.model.aw;

final class BizChatroomInfoUI$6
  implements DialogInterface.OnCancelListener
{
  BizChatroomInfoUI$6(BizChatroomInfoUI paramBizChatroomInfoUI, x paramx) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(30202);
    aw.Rc().a(this.zuw);
    AppMethodBeat.o(30202);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatroomInfoUI.6
 * JD-Core Version:    0.7.0.1
 */