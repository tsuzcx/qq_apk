package com.tencent.mm.ui.contact;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ChatroomContactUI$13
  implements View.OnTouchListener
{
  ChatroomContactUI$13(ChatroomContactUI paramChatroomContactUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(33585);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      if (ChatroomContactUI.f(this.AbH) != null)
      {
        paramView = ChatroomContactUI.f(this.AbH);
        if (paramView.gxo != null) {
          paramView.gxo.onTouchEvent(paramMotionEvent);
        }
      }
      if (ChatroomContactUI.d(this.AbH) != null)
      {
        paramView = ChatroomContactUI.d(this.AbH);
        if (paramView.gxo != null) {
          paramView.gxo.onTouchEvent(paramMotionEvent);
        }
      }
      AppMethodBeat.o(33585);
      return false;
      this.AbH.hideVKB();
      ChatroomContactUI.a(this.AbH, (int)paramMotionEvent.getRawX());
      ChatroomContactUI.b(this.AbH, (int)paramMotionEvent.getRawY());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ChatroomContactUI.13
 * JD-Core Version:    0.7.0.1
 */