package com.tencent.mm.ui.bizchat;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class BizChatConversationUI$a$16
  implements View.OnTouchListener
{
  BizChatConversationUI$a$16(BizChatConversationUI.a parama) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      BizChatConversationUI.a.a(this.veW, (int)paramMotionEvent.getRawX());
      BizChatConversationUI.a.b(this.veW, (int)paramMotionEvent.getRawY());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatConversationUI.a.16
 * JD-Core Version:    0.7.0.1
 */