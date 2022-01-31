package com.tencent.mm.plugin.profile.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.ui.contact.n.a;
import java.util.List;

final class b$1
  implements l
{
  b$1(b paramb) {}
  
  public final void b(j paramj)
  {
    AppMethodBeat.i(23334);
    if (paramj.bpE == 0)
    {
      b.a(this.pyn, paramj.mSW);
      if (b.a(this.pyn) != null) {
        b.c(this.pyn).w(paramj.mPi.query, b.b(this.pyn).size(), true);
      }
    }
    this.pyn.clearCache();
    this.pyn.notifyDataSetChanged();
    AppMethodBeat.o(23334);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.b.1
 * JD-Core Version:    0.7.0.1
 */