package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class NewBizConversationUI$13
  implements Runnable
{
  NewBizConversationUI$13(NewBizConversationUI paramNewBizConversationUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(34548);
    if ((this.AlC.activityHasDestroyed()) || (this.AlC.isFinishing()))
    {
      AppMethodBeat.o(34548);
      return;
    }
    NewBizConversationUI.a(this.AlC);
    AppMethodBeat.o(34548);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.NewBizConversationUI.13
 * JD-Core Version:    0.7.0.1
 */