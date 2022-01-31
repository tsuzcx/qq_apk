package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.viewitems.az;

public abstract class s$e
  implements View.OnClickListener
{
  public a zzP;
  
  public s$e(a parama)
  {
    this.zzP = parama;
  }
  
  public abstract void a(View paramView, a parama, bi parambi);
  
  public final void onClick(View paramView)
  {
    bi localbi = ((az)paramView.getTag()).cEE;
    if (localbi == null) {
      return;
    }
    a(paramView, this.zzP, localbi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.s.e
 * JD-Core Version:    0.7.0.1
 */