package com.tencent.mm.ui.chatting.c;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.y;
import com.tencent.mm.ui.chatting.c.b.p;
import com.tencent.mm.ui.chatting.d.a;

final class u$1
  implements View.OnClickListener
{
  u$1(u paramu, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(31540);
    u.a(this.zGP, 2);
    paramView = y.dZP;
    if (paramView.dZT != null) {
      paramView.dZT.eal = 2;
    }
    if (((p)this.zGP.caz.ay(p.class)).dIr())
    {
      ((p)this.zGP.caz.ay(p.class)).dIs();
      AppMethodBeat.o(31540);
      return;
    }
    u.b(this.zGP, this.gxr);
    AppMethodBeat.o(31540);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.u.1
 * JD-Core Version:    0.7.0.1
 */