package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bf.a;

final class EnterpriseConversationUI$EnterpriseConversationFmUI$8
  implements bf.a
{
  EnterpriseConversationUI$EnterpriseConversationFmUI$8(EnterpriseConversationUI.EnterpriseConversationFmUI paramEnterpriseConversationFmUI, ProgressDialog paramProgressDialog) {}
  
  public final boolean JS()
  {
    AppMethodBeat.i(34425);
    boolean bool = EnterpriseConversationUI.EnterpriseConversationFmUI.k(this.AkO);
    AppMethodBeat.o(34425);
    return bool;
  }
  
  public final void JT()
  {
    AppMethodBeat.i(34426);
    if (this.efE != null) {
      this.efE.dismiss();
    }
    AppMethodBeat.o(34426);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.EnterpriseConversationUI.EnterpriseConversationFmUI.8
 * JD-Core Version:    0.7.0.1
 */