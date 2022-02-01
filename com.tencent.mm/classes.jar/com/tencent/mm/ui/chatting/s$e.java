package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.viewitems.bi;

public abstract class s$e
  implements View.OnClickListener
{
  public a Gob;
  
  public s$e(a parama)
  {
    this.Gob = parama;
  }
  
  public abstract void a(View paramView, a parama, bl parambl);
  
  public final void onClick(View paramView)
  {
    bl localbl = ((bi)paramView.getTag()).drF;
    if (localbl == null) {
      return;
    }
    a(paramView, this.Gob, localbl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.s.e
 * JD-Core Version:    0.7.0.1
 */