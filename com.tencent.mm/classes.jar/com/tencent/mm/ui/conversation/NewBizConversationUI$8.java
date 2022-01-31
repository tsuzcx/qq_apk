package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bf.a;

final class NewBizConversationUI$8
  implements bf.a
{
  NewBizConversationUI$8(NewBizConversationUI paramNewBizConversationUI, ProgressDialog paramProgressDialog) {}
  
  public final boolean JS()
  {
    AppMethodBeat.i(34539);
    boolean bool = NewBizConversationUI.m(this.AlC);
    AppMethodBeat.o(34539);
    return bool;
  }
  
  public final void JT()
  {
    AppMethodBeat.i(34540);
    if (this.efE != null) {
      this.efE.dismiss();
    }
    AppMethodBeat.o(34540);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.NewBizConversationUI.8
 * JD-Core Version:    0.7.0.1
 */