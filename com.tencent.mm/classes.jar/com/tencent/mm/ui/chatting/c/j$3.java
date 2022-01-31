package com.tencent.mm.ui.chatting.c;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.m;

final class j$3
  implements View.OnClickListener
{
  j$3(j paramj) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(31309);
    if (((h)this.zET.caz.ay(h.class)).ces() == 0)
    {
      ab.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
      AppMethodBeat.o(31309);
      return;
    }
    m.a(this.zET.caz, j.c(this.zET), j.d(this.zET), this.zET, j.e(this.zET));
    AppMethodBeat.o(31309);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.j.3
 * JD-Core Version:    0.7.0.1
 */