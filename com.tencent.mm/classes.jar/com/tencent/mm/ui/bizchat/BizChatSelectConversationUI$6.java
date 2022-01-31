package com.tencent.mm.ui.bizchat;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BizChatSelectConversationUI$6
  implements DialogInterface.OnCancelListener
{
  BizChatSelectConversationUI$6(BizChatSelectConversationUI paramBizChatSelectConversationUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(30179);
    this.zuo.finish();
    AppMethodBeat.o(30179);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatSelectConversationUI.6
 * JD-Core Version:    0.7.0.1
 */