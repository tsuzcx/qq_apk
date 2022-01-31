package com.tencent.mm.ui.bizchat;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.aj.a.n;
import com.tencent.mm.model.aw;

final class BizChatSelectConversationUI$5
  implements DialogInterface.OnCancelListener
{
  BizChatSelectConversationUI$5(BizChatSelectConversationUI paramBizChatSelectConversationUI, n paramn) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(30178);
    aw.Rc().a(this.zup);
    AppMethodBeat.o(30178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatSelectConversationUI.5
 * JD-Core Version:    0.7.0.1
 */