package com.tencent.mm.ui.bizchat;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BizChatConversationUI$BizChatConversationFmUI$7
  implements DialogInterface.OnCancelListener
{
  BizChatConversationUI$BizChatConversationFmUI$7(BizChatConversationUI.BizChatConversationFmUI paramBizChatConversationFmUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(30063);
    BizChatConversationUI.BizChatConversationFmUI.n(this.ztv);
    AppMethodBeat.o(30063);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatConversationUI.BizChatConversationFmUI.7
 * JD-Core Version:    0.7.0.1
 */