package com.tencent.mm.ui.conversation;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BizConversationUI$BizConversationFmUI$2
  implements View.OnTouchListener
{
  BizConversationUI$BizConversationFmUI$2(BizConversationUI.BizConversationFmUI paramBizConversationFmUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(34117);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(34117);
      return false;
      BizConversationUI.BizConversationFmUI.b(this.Ahf, (int)paramMotionEvent.getRawX());
      BizConversationUI.BizConversationFmUI.c(this.Ahf, (int)paramMotionEvent.getRawY());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BizConversationUI.BizConversationFmUI.2
 * JD-Core Version:    0.7.0.1
 */