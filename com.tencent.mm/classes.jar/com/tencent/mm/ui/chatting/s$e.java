package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.viewitems.bj;

public abstract class s$e
  implements View.OnClickListener
{
  public a HNS;
  
  public s$e(a parama)
  {
    this.HNS = parama;
  }
  
  public abstract void a(View paramView, a parama, bo parambo);
  
  public final void onClick(View paramView)
  {
    bo localbo = ((bj)paramView.getTag()).dpq;
    if (localbo == null) {
      return;
    }
    a(paramView, this.HNS, localbo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.s.e
 * JD-Core Version:    0.7.0.1
 */