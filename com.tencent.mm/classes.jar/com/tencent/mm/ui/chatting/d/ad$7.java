package com.tencent.mm.ui.chatting.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;

final class ad$7
  implements q.f
{
  ad$7(ad paramad, Context paramContext) {}
  
  public final void onCreateMMMenu(o paramo)
  {
    AppMethodBeat.i(284189);
    paramo.d(0, this.WAL.getString(R.l.live_debug_entrance));
    paramo.d(1, this.WAL.getString(R.l.live_debug_create));
    AppMethodBeat.o(284189);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.ad.7
 * JD-Core Version:    0.7.0.1
 */