package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.b.b.ai;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.d;
import com.tencent.mm.ui.chatting.e;
import com.tencent.mm.ui.chatting.t.d;

final class ao$a
  extends t.d
{
  public ao$a(ao paramao, a parama)
  {
    super(parama);
  }
  
  public final void a(View paramView, a parama, bi parambi)
  {
    paramView = (aw)paramView.getTag();
    au.Hx();
    if (!c.isSDCardAvailable())
    {
      s.gM(this.vko.vtz.getContext());
      return;
    }
    ((ai)this.vko.ac(ai.class)).cFx().a(paramView.position, paramView.bWO);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ao.a
 * JD-Core Version:    0.7.0.1
 */