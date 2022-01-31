package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.model.al;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.ui.chatting.c.a;

final class aq$1$1
  implements DialogInterface.OnClickListener
{
  aq$1$1(aq.1 param1, long paramLong) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    au.Hx();
    int i;
    if (c.Fy().V(au.getNotification().wo(), this.vtt))
    {
      i = ((com.tencent.mm.ui.chatting.b.b.g)this.vtu.vts.byx.ac(com.tencent.mm.ui.chatting.b.b.g.class)).cDk();
      paramInt = ((com.tencent.mm.ui.chatting.b.b.g)this.vtu.vts.byx.ac(com.tencent.mm.ui.chatting.b.b.g.class)).getCount();
      au.Hx();
      i = c.Fy().d(au.getNotification().wo(), this.vtt, i - paramInt);
      if (i >= 0) {
        break label108;
      }
    }
    label108:
    while (paramInt <= i) {
      return;
    }
    this.vtu.vts.byx.GT(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.aq.1.1
 * JD-Core Version:    0.7.0.1
 */