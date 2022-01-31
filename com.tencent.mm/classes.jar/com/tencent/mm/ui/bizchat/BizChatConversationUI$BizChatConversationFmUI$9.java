package com.tencent.mm.ui.bizchat;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BizChatConversationUI$BizChatConversationFmUI$9
  implements DialogInterface.OnCancelListener
{
  BizChatConversationUI$BizChatConversationFmUI$9(BizChatConversationUI.BizChatConversationFmUI paramBizChatConversationFmUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(30066);
    this.ztv.finish();
    AppMethodBeat.o(30066);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatConversationUI.BizChatConversationFmUI.9
 * JD-Core Version:    0.7.0.1
 */