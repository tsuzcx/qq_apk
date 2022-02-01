package com.tencent.mm.ui.conversation;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cq.d;

final class BizConversationUI$BizConversationFmUI$11
  implements MessageQueue.IdleHandler
{
  BizConversationUI$BizConversationFmUI$11(BizConversationUI.BizConversationFmUI paramBizConversationFmUI) {}
  
  public final boolean queueIdle()
  {
    AppMethodBeat.i(38246);
    Looper.myQueue().removeIdleHandler(this);
    d.fSu();
    AppMethodBeat.o(38246);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BizConversationUI.BizConversationFmUI.11
 * JD-Core Version:    0.7.0.1
 */