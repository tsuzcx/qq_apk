package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.viewitems.aw;

public abstract class t$d
  implements View.OnClickListener
{
  public a vko;
  
  public t$d(a parama)
  {
    this.vko = parama;
  }
  
  public abstract void a(View paramView, a parama, bi parambi);
  
  public final void onClick(View paramView)
  {
    bi localbi = ((aw)paramView.getTag()).bWO;
    if (localbi == null) {
      return;
    }
    a(paramView, this.vko, localbi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.t.d
 * JD-Core Version:    0.7.0.1
 */