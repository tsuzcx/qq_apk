package com.tencent.mm.ui.chatting;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

public final class t
{
  public static final class g
    implements View.OnTouchListener
  {
    private int[] Dvf;
    
    public g()
    {
      AppMethodBeat.i(34598);
      this.Dvf = new int[2];
      AppMethodBeat.o(34598);
    }
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(34599);
      b localb = new b();
      localb.bn(paramView);
      localb.bn(paramMotionEvent);
      a.c("com/tencent/mm/ui/chatting/ChattingListEventListener$ChattingListTouchListener", "com/tencent/mm/ui/chatting/ChattingListEventListener$ChattingListTouchListenerandroid/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.aFi());
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      }
      for (;;)
      {
        a.a(false, this, "com/tencent/mm/ui/chatting/ChattingListEventListener$ChattingListTouchListener", "com/tencent/mm/ui/chatting/ChattingListEventListener$ChattingListTouchListenerandroid/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(34599);
        return false;
        this.Dvf[0] = ((int)paramMotionEvent.getRawX());
        this.Dvf[1] = ((int)paramMotionEvent.getRawY());
        paramView.setTag(R.h.touch_loc, this.Dvf);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.t
 * JD-Core Version:    0.7.0.1
 */