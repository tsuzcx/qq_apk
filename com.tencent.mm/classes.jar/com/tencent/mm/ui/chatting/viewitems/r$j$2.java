package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.res.Resources;
import android.widget.ImageView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.pluginsdk.ui.applet.e.a;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.e;
import com.tencent.mm.ui.widget.MMNeatTextView;

final class r$j$2
  implements e.a
{
  r$j$2(r.j paramj, int paramInt, r.c paramc) {}
  
  public final void onFinish()
  {
    if (this.dAU > 1)
    {
      this.vDG.vDy.npe.setTextColor(r.j.a(this.vDI).vtz.getContext().getResources().getColor(R.e.white));
      this.vDG.vDy.npe.setBackgroundResource(R.g.biz_msg_cover_gradient_mask);
    }
    this.vDG.vDy.npf.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.r.j.2
 * JD-Core Version:    0.7.0.1
 */