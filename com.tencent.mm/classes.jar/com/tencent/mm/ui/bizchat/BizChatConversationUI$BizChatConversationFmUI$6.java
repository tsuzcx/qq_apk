package com.tencent.mm.ui.bizchat;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a.h;
import com.tencent.mm.aj.a.n;
import com.tencent.mm.aj.z;

final class BizChatConversationUI$BizChatConversationFmUI$6
  implements DialogInterface.OnCancelListener
{
  BizChatConversationUI$BizChatConversationFmUI$6(BizChatConversationUI.BizChatConversationFmUI paramBizChatConversationFmUI, n paramn) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(30062);
    z.afq();
    h.d(this.ztx);
    AppMethodBeat.o(30062);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatConversationUI.BizChatConversationFmUI.6
 * JD-Core Version:    0.7.0.1
 */