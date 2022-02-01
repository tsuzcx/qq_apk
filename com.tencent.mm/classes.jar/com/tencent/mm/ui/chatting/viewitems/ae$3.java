package com.tencent.mm.ui.chatting.viewitems;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.a;

final class ae$3
  implements u.g
{
  ae$3(ae paramae, a parama) {}
  
  public final void onCreateMMMenu(s params)
  {
    AppMethodBeat.i(254929);
    params.a(291, this.XSz.aezO.getMMResources().getColor(R.e.red_text_color), this.XSz.aezO.getMMResources().getString(R.l.gyA));
    AppMethodBeat.o(254929);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ae.3
 * JD-Core Version:    0.7.0.1
 */