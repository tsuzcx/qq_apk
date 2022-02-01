package com.tencent.mm.ui.chatting;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

public final class t$g
  implements View.OnTouchListener
{
  private int[] PhV;
  
  public t$g()
  {
    AppMethodBeat.i(34598);
    this.PhV = new int[2];
    AppMethodBeat.o(34598);
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(34599);
    b localb = new b();
    localb.bm(paramView);
    localb.bm(paramMotionEvent);
    a.b("com/tencent/mm/ui/chatting/ChattingListEventListener$ChattingListTouchListener", "com/tencent/mm/ui/chatting/ChattingListEventListener$ChattingListTouchListenerandroid/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.axR());
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      a.a(false, this, "com/tencent/mm/ui/chatting/ChattingListEventListener$ChattingListTouchListener", "com/tencent/mm/ui/chatting/ChattingListEventListener$ChattingListTouchListenerandroid/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(34599);
      return false;
      this.PhV[0] = ((int)paramMotionEvent.getRawX());
      this.PhV[1] = ((int)paramMotionEvent.getRawY());
      paramView.setTag(2131309367, this.PhV);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.t.g
 * JD-Core Version:    0.7.0.1
 */