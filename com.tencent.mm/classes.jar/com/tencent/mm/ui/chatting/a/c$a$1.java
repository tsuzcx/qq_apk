package com.tencent.mm.ui.chatting.a;

import android.view.View;
import android.view.View.OnClickListener;

final class c$a$1
  implements View.OnClickListener
{
  c$a$1(c.a parama) {}
  
  public final void onClick(View paramView)
  {
    if (c.cDA() != null)
    {
      int i = ((Integer)paramView.getTag()).intValue();
      paramView = c.cDB().Ha(i);
      c.cDA().a(i, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a.c.a.1
 * JD-Core Version:    0.7.0.1
 */