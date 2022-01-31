package com.tencent.mm.ui.conversation;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.d;

final class BizConversationUI$BizConversationFmUI$11
  implements MessageQueue.IdleHandler
{
  BizConversationUI$BizConversationFmUI$11(BizConversationUI.BizConversationFmUI paramBizConversationFmUI) {}
  
  public final boolean queueIdle()
  {
    AppMethodBeat.i(34128);
    Looper.myQueue().removeIdleHandler(this);
    d.aNX();
    AppMethodBeat.o(34128);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BizConversationUI.BizConversationFmUI.11
 * JD-Core Version:    0.7.0.1
 */