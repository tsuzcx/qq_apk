package com.tencent.mm.ui.conversation;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class EnterpriseConversationUI$EnterpriseConversationFmUI$4
  implements View.OnTouchListener
{
  EnterpriseConversationUI$EnterpriseConversationFmUI$4(EnterpriseConversationUI.EnterpriseConversationFmUI paramEnterpriseConversationFmUI, Point paramPoint) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(188071);
    b localb = new b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$12", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
    if (paramMotionEvent.getAction() == 0)
    {
      this.KSe.x = ((int)paramMotionEvent.getRawX());
      this.KSe.y = ((int)paramMotionEvent.getRawY());
    }
    a.a(false, this, "com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$12", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(188071);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.EnterpriseConversationUI.EnterpriseConversationFmUI.4
 * JD-Core Version:    0.7.0.1
 */