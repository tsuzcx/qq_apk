package com.tencent.mm.ui.conversation;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class BizConversationUI$BizConversationFmUI$2
  implements View.OnTouchListener
{
  BizConversationUI$BizConversationFmUI$2(BizConversationUI.BizConversationFmUI paramBizConversationFmUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(38236);
    b localb = new b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/ui/conversation/BizConversationUI$BizConversationFmUI$10", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      a.a(false, this, "com/tencent/mm/ui/conversation/BizConversationUI$BizConversationFmUI$10", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(38236);
      return false;
      BizConversationUI.BizConversationFmUI.b(this.Ksc, (int)paramMotionEvent.getRawX());
      BizConversationUI.BizConversationFmUI.c(this.Ksc, (int)paramMotionEvent.getRawY());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BizConversationUI.BizConversationFmUI.2
 * JD-Core Version:    0.7.0.1
 */