package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.n.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bo;

final class j$8
  implements Runnable
{
  j$8(j paramj) {}
  
  public final void run()
  {
    AppMethodBeat.i(32323);
    String str = e.bQs();
    if (!bo.isNullOrNil(str))
    {
      h.qsU.kvStat(14092, str);
      AppMethodBeat.o(32323);
      return;
    }
    h.qsU.kvStat(14092, "0");
    AppMethodBeat.o(32323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.j.8
 * JD-Core Version:    0.7.0.1
 */