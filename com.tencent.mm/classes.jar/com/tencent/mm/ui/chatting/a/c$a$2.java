package com.tencent.mm.ui.chatting.a;

import android.view.View;
import android.view.View.OnLongClickListener;

final class c$a$2
  implements View.OnLongClickListener
{
  c$a$2(c.a parama) {}
  
  public final boolean onLongClick(View paramView)
  {
    if (c.cDA() != null)
    {
      int i = ((Integer)paramView.getTag()).intValue();
      c.b localb = c.cDB().Ha(i);
      c.cDA().a(paramView, i, localb);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a.c.a.2
 * JD-Core Version:    0.7.0.1
 */