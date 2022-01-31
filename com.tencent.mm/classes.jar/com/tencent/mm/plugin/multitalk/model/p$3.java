package com.tencent.mm.plugin.multitalk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.sdk.platformtools.ab;

final class p$3
  implements cc.a
{
  p$3(p paramp) {}
  
  public final boolean abs()
  {
    AppMethodBeat.i(54088);
    ab.w("MicroMsg.SubCoreMultiTalk", "HERE UninitForUEH is called! multitalk");
    if (p.a(this.oUR) != null)
    {
      p.a(this.oUR).bIQ();
      if (p.a(this.oUR).oTs != null) {
        ab.i("MicroMsg.SubCoreMultiTalk", "dump multiTalkGroup: %s", new Object[] { j.h(p.a(this.oUR).oTs) });
      }
    }
    AppMethodBeat.o(54088);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.p.3
 * JD-Core Version:    0.7.0.1
 */