package com.tencent.mm.ui.chatting.b;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.e;
import com.tencent.mm.ui.chatting.k;
import com.tencent.mm.ui.chatting.o;

final class j$4
  implements View.OnClickListener
{
  j$4(j paramj) {}
  
  public final void onClick(View paramView)
  {
    if (((g)this.vpr.byx.ac(g.class)).bug() == 0) {
      y.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
    }
    do
    {
      return;
      paramView = j.c(this.vpr);
      if (k.dR(paramView))
      {
        h.a(this.vpr.byx.vtz.getContext(), this.vpr.byx.vtz.getContext().getString(R.l.contain_remuxing_msg), "", this.vpr.byx.vtz.getContext().getString(R.l.I_known), new j.4.1(this));
        return;
      }
      if (k.dS(paramView))
      {
        h.a(this.vpr.byx.vtz.getContext(), this.vpr.byx.vtz.getContext().getString(R.l.contain_shortvideo_msg), "", this.vpr.byx.vtz.getContext().getString(R.l.I_known), new j.4.2(this));
        return;
      }
      if (k.dQ(paramView))
      {
        h.a(this.vpr.byx.vtz.getContext(), this.vpr.byx.vtz.getContext().getString(R.l.contain_undownload_msg), "", new j.4.3(this), null);
        return;
      }
    } while (!o.a(this.vpr.byx, paramView, j.e(this.vpr)));
    this.vpr.cEf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.j.4
 * JD-Core Version:    0.7.0.1
 */