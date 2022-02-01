package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.widget.a.e;

final class e$5
  implements o.f
{
  e$5(e parame, View paramView) {}
  
  public final void onCreateMMMenu(m paramm)
  {
    AppMethodBeat.i(233590);
    paramm.clear();
    this.gwC.setFooterView(null);
    this.gwC.setFooterView(this.PHH);
    AppMethodBeat.o(233590);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.e.5
 * JD-Core Version:    0.7.0.1
 */