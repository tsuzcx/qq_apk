package com.tencent.mm.ui.chatting.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.chatting.ChattingFooterMoreBtnBar;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.b.b.y;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.tools.n;

final class j$1
  implements View.OnClickListener
{
  j$1(j paramj) {}
  
  public final void onClick(View paramView)
  {
    g localg = (g)this.vpr.byx.ac(g.class);
    if (localg.hQ(((Long)paramView.getTag()).longValue()))
    {
      int i = localg.bug();
      ((y)this.vpr.byx.ac(y.class)).cFg();
      j.a(this.vpr).cJg();
      j.b(this.vpr).setVisibility(0);
      j.b(this.vpr).GQ(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.j.1
 * JD-Core Version:    0.7.0.1
 */