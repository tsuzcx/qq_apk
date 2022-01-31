package com.tencent.mm.plugin.subapp.ui.friend;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bi.d;
import com.tencent.mm.storage.aw;

final class b$1
  implements Runnable
{
  b$1(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(25345);
    b.a(this.sXN, d.ali().getAll());
    this.sXN.notifyDataSetChanged();
    AppMethodBeat.o(25345);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.friend.b.1
 * JD-Core Version:    0.7.0.1
 */