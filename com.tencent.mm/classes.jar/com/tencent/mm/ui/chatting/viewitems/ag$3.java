package com.tencent.mm.ui.chatting.viewitems;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.e.a;

final class ag$3
  implements q.f
{
  ag$3(ag paramag, a parama) {}
  
  public final void onCreateMMMenu(o paramo)
  {
    AppMethodBeat.i(255293);
    paramo.a(291, this.QWD.WQv.getMMResources().getColor(R.e.red_text_color), this.QWD.WQv.getMMResources().getString(R.l.ewa));
    AppMethodBeat.o(255293);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ag.3
 * JD-Core Version:    0.7.0.1
 */