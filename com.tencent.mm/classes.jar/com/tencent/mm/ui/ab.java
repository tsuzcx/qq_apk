package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.s;
import com.tencent.mm.ui.chatting.viewitems.d.f;

public final class ab
  implements View.OnClickListener
{
  a uPh;
  
  public ab(a parama)
  {
    this.uPh = parama;
  }
  
  public final void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof d.f))
    {
      s.dH(paramView);
      this.uPh.axW();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.ab
 * JD-Core Version:    0.7.0.1
 */