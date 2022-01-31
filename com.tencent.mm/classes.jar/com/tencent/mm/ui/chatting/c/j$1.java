package com.tencent.mm.ui.chatting.c;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.chatting.ChattingFooterMoreBtnBar;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.c.b.z;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.tools.q;

final class j$1
  implements View.OnClickListener
{
  j$1(j paramj) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(31306);
    h localh = (h)this.zET.caz.ay(h.class);
    if (localh.oC(((Long)paramView.getTag()).longValue()))
    {
      int i = localh.ces();
      ((z)this.zET.caz.ay(z.class)).dIY();
      j.a(this.zET).dNV();
      j.b(this.zET).setVisibility(0);
      j.b(this.zET).Pr(i);
    }
    AppMethodBeat.o(31306);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.j.1
 * JD-Core Version:    0.7.0.1
 */