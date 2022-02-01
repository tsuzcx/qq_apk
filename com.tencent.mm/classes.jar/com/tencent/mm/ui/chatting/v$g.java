package com.tencent.mm.ui.chatting;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

public final class v$g
  implements View.OnTouchListener
{
  private int[] JoC;
  
  public v$g()
  {
    AppMethodBeat.i(34598);
    this.JoC = new int[2];
    AppMethodBeat.o(34598);
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(34599);
    b localb = new b();
    localb.cH(paramView);
    localb.cH(paramMotionEvent);
    a.c("com/tencent/mm/ui/chatting/ChattingListEventListener$ChattingListTouchListener", "com/tencent/mm/ui/chatting/ChattingListEventListener$ChattingListTouchListenerandroid/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.aYj());
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      a.a(false, this, "com/tencent/mm/ui/chatting/ChattingListEventListener$ChattingListTouchListener", "com/tencent/mm/ui/chatting/ChattingListEventListener$ChattingListTouchListenerandroid/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(34599);
      return false;
      this.JoC[0] = ((int)paramMotionEvent.getRawX());
      this.JoC[1] = ((int)paramMotionEvent.getRawY());
      paramView.setTag(R.h.touch_loc, this.JoC);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.v.g
 * JD-Core Version:    0.7.0.1
 */