package com.tencent.mm.ui.conversation;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class EnterpriseConversationUI$EnterpriseConversationFmUI$4
  implements View.OnTouchListener
{
  EnterpriseConversationUI$EnterpriseConversationFmUI$4(EnterpriseConversationUI.EnterpriseConversationFmUI paramEnterpriseConversationFmUI, Point paramPoint) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(234160);
    if (paramMotionEvent.getAction() == 0)
    {
      this.Qfk.x = ((int)paramMotionEvent.getRawX());
      this.Qfk.y = ((int)paramMotionEvent.getRawY());
    }
    AppMethodBeat.o(234160);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.EnterpriseConversationUI.EnterpriseConversationFmUI.4
 * JD-Core Version:    0.7.0.1
 */