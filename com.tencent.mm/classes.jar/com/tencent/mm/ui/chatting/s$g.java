package com.tencent.mm.ui.chatting;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

public final class s$g
  implements View.OnTouchListener
{
  private int[] JBQ;
  
  public s$g()
  {
    AppMethodBeat.i(34598);
    this.JBQ = new int[2];
    AppMethodBeat.o(34598);
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(34599);
    b localb = new b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/ui/chatting/ChattingListEventListener$ChattingListTouchListener", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      a.a(false, this, "com/tencent/mm/ui/chatting/ChattingListEventListener$ChattingListTouchListener", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(34599);
      return false;
      this.JBQ[0] = ((int)paramMotionEvent.getRawX());
      this.JBQ[1] = ((int)paramMotionEvent.getRawY());
      paramView.setTag(2131306044, this.JBQ);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.s.g
 * JD-Core Version:    0.7.0.1
 */