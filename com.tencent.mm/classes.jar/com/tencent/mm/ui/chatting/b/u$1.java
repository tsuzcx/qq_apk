package com.tencent.mm.ui.chatting.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.booter.z;
import com.tencent.mm.ui.chatting.b.b.o;
import com.tencent.mm.ui.chatting.c.a;

final class u$1
  implements View.OnClickListener
{
  u$1(u paramu, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    u.a(this.vrk, 2);
    paramView = z.diw;
    if (paramView.diA != null) {
      paramView.diA.diS = 2;
    }
    if (((o)this.vrk.byx.ac(o.class)).cEB())
    {
      ((o)this.vrk.byx.ac(o.class)).cEC();
      return;
    }
    u.b(this.vrk, this.ffJ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.u.1
 * JD-Core Version:    0.7.0.1
 */