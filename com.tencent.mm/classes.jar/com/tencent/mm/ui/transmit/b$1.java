package com.tencent.mm.ui.transmit;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.ui.contact.n.a;
import java.util.ArrayList;
import java.util.List;

final class b$1
  implements com.tencent.mm.plugin.fts.a.l
{
  b$1(b paramb) {}
  
  public final void b(j paramj)
  {
    AppMethodBeat.i(35034);
    if (paramj.bpE == 0) {
      b.a(this.AyR, paramj);
    }
    for (;;)
    {
      if (paramj.mSW.size() == 0)
      {
        com.tencent.mm.plugin.fts.a.a.l locall = new com.tencent.mm.plugin.fts.a.a.l();
        locall.mRV = "no_result​";
        paramj.mSW = new ArrayList();
        paramj.mSW.add(locall);
      }
      this.AyR.clearCache();
      this.AyR.notifyDataSetChanged();
      b.a(this.AyR).w(paramj.mPi.query, paramj.mSW.size(), true);
      AppMethodBeat.o(35034);
      return;
      b.a(this.AyR, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.b.1
 * JD-Core Version:    0.7.0.1
 */