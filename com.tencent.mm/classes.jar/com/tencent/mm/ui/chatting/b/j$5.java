package com.tencent.mm.ui.chatting.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ai.f;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.s;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.e;
import com.tencent.mm.ui.chatting.l;

final class j$5
  implements View.OnClickListener
{
  j$5(j paramj) {}
  
  public final void onClick(View paramView)
  {
    if (((g)this.vpr.byx.ac(g.class)).bug() == 0)
    {
      y.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
      return;
    }
    if (((s.hl(j.e(this.vpr).field_username)) && (!f.eW(j.e(this.vpr).field_username))) || (s.hV(j.e(this.vpr).field_username)))
    {
      j.a(this.vpr, true);
      l.a(this.vpr.byx.vtz.getContext(), j.c(this.vpr), j.d(this.vpr), j.e(this.vpr).field_username, this.vpr);
      return;
    }
    j.f(this.vpr).b(paramView, new j.5.1(this), new j.5.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.j.5
 * JD-Core Version:    0.7.0.1
 */