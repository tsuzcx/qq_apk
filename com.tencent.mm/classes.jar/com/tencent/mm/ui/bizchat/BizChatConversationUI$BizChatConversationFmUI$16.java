package com.tencent.mm.ui.bizchat;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BizChatConversationUI$BizChatConversationFmUI$16
  implements View.OnTouchListener
{
  BizChatConversationUI$BizChatConversationFmUI$16(BizChatConversationUI.BizChatConversationFmUI paramBizChatConversationFmUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(30073);
    if (paramMotionEvent.getAction() == 0)
    {
      BizChatConversationUI.BizChatConversationFmUI.a(this.ztv, (int)paramMotionEvent.getRawX());
      BizChatConversationUI.BizChatConversationFmUI.b(this.ztv, (int)paramMotionEvent.getRawY());
    }
    AppMethodBeat.o(30073);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatConversationUI.BizChatConversationFmUI.16
 * JD-Core Version:    0.7.0.1
 */