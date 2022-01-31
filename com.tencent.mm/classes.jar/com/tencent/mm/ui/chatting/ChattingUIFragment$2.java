package com.tencent.mm.ui.chatting;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.chatting.c.b.o;
import com.tencent.mm.ui.chatting.d.a;

final class ChattingUIFragment$2
  implements View.OnTouchListener
{
  boolean jcN = false;
  
  ChattingUIFragment$2(ChattingUIFragment paramChattingUIFragment) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(30830);
    ChattingUIFragment.h(this.zBB);
    if (paramMotionEvent.getAction() == 0)
    {
      ab.i("MicroMsg.ChattingUIFragment", "onTouch: touch down");
      this.jcN = true;
    }
    while ((!this.jcN) || (!this.zBB.zBv))
    {
      AppMethodBeat.o(30830);
      return false;
      if (paramMotionEvent.getAction() == 1)
      {
        ab.i("MicroMsg.ChattingUIFragment", "onTouch: touch up");
        this.jcN = false;
      }
    }
    paramView = (o)this.zBB.caz.ay(o.class);
    if ((paramView == null) || (paramView.dIg() == null))
    {
      AppMethodBeat.o(30830);
      return false;
    }
    paramView.dIg().aB(0, true);
    AppMethodBeat.o(30830);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingUIFragment.2
 * JD-Core Version:    0.7.0.1
 */