package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.n;

final class j$4
  implements View.OnClickListener
{
  j$4(j paramj) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(31310);
    paramView = (com.tencent.mm.ui.chatting.c.b.h)this.zET.caz.ay(com.tencent.mm.ui.chatting.c.b.h.class);
    if ((paramView == null) || (paramView.ces() == 0))
    {
      ab.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
      AppMethodBeat.o(31310);
      return;
    }
    paramView = j.c(this.zET);
    if (com.tencent.mm.ui.chatting.j.fa(paramView))
    {
      com.tencent.mm.ui.base.h.a(this.zET.caz.zJz.getContext(), this.zET.caz.zJz.getContext().getString(2131298859), "", this.zET.caz.zJz.getContext().getString(2131296332), new j.4.1(this));
      AppMethodBeat.o(31310);
      return;
    }
    if (com.tencent.mm.ui.chatting.j.fb(paramView))
    {
      com.tencent.mm.ui.base.h.a(this.zET.caz.zJz.getContext(), this.zET.caz.zJz.getContext().getString(2131298860), "", this.zET.caz.zJz.getContext().getString(2131296332), new j.4.2(this));
      AppMethodBeat.o(31310);
      return;
    }
    if (com.tencent.mm.ui.chatting.j.eZ(paramView))
    {
      com.tencent.mm.ui.base.h.a(this.zET.caz.zJz.getContext(), this.zET.caz.zJz.getContext().getString(2131298861), "", new j.4.3(this), null);
      AppMethodBeat.o(31310);
      return;
    }
    if (n.a(this.zET.caz, paramView, j.e(this.zET))) {
      this.zET.dHU();
    }
    AppMethodBeat.o(31310);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.j.4
 * JD-Core Version:    0.7.0.1
 */