package com.tencent.mm.ui.chatting.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.n;

final class j$3
  implements View.OnClickListener
{
  j$3(j paramj) {}
  
  public final void onClick(View paramView)
  {
    if (((g)this.vpr.byx.ac(g.class)).bug() == 0)
    {
      y.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
      return;
    }
    n.a(this.vpr.byx, j.c(this.vpr), j.d(this.vpr), this.vpr, j.e(this.vpr));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.j.3
 * JD-Core Version:    0.7.0.1
 */