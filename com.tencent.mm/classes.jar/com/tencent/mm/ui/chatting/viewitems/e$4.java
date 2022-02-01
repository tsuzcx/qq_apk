package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.widget.a.f;

final class e$4
  implements u.g
{
  e$4(f paramf, View paramView) {}
  
  public final void onCreateMMMenu(s params)
  {
    AppMethodBeat.i(255211);
    params.clear();
    this.lCP.setFooterView(null);
    this.lCP.setFooterView(this.aeMY);
    AppMethodBeat.o(255211);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.e.4
 * JD-Core Version:    0.7.0.1
 */