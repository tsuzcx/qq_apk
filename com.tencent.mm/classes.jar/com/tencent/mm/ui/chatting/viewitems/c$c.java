package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import com.tencent.mm.R.h;
import com.tencent.mm.ui.chatting.e;

public final class c$c
  implements View.OnLongClickListener
{
  private int idy;
  private int idz;
  private View.OnCreateContextMenuListener npl;
  private c.c.a vBe;
  private View vBf;
  private com.tencent.mm.ui.chatting.c.a vko;
  
  public c$c(c paramc, com.tencent.mm.ui.chatting.c.a parama)
  {
    this.vko = parama;
    this.npl = new c.c.1(this, paramc);
    this.vBe = new c.c.a(this);
  }
  
  private void k(View paramView, int paramInt1, int paramInt2)
  {
    aw localaw = (aw)paramView.getTag();
    if (localaw == null) {
      return;
    }
    this.vBe.bFH = localaw.bWO;
    new com.tencent.mm.ui.widget.b.a(this.vko.vtz.getContext()).a(paramView, this.npl, this.vBe, paramInt1, paramInt2);
  }
  
  public final boolean onLongClick(View paramView)
  {
    if ((paramView.getTag(R.h.touch_loc) instanceof int[]))
    {
      int[] arrayOfInt = (int[])paramView.getTag(R.h.touch_loc);
      k(paramView, arrayOfInt[0], arrayOfInt[1]);
      return true;
    }
    if (((this.idy == 0) && (this.idz == 0)) || (!this.vBf.equals(paramView)))
    {
      paramView.setOnTouchListener(new c.c.2(this));
      return true;
    }
    k(paramView, this.idy, this.idz);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.c.c
 * JD-Core Version:    0.7.0.1
 */