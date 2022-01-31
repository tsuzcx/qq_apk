package com.tencent.mm.ui.conversation;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class NewBizConversationUI$2
  implements View.OnTouchListener
{
  NewBizConversationUI$2(NewBizConversationUI paramNewBizConversationUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(34533);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(34533);
      return false;
      NewBizConversationUI.b(this.AlC, (int)paramMotionEvent.getRawX());
      NewBizConversationUI.c(this.AlC, (int)paramMotionEvent.getRawY());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.NewBizConversationUI.2
 * JD-Core Version:    0.7.0.1
 */