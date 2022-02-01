package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.o.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bu;

final class j$9
  implements Runnable
{
  j$9(j paramj) {}
  
  public final void run()
  {
    AppMethodBeat.i(36252);
    String str = f.dpo();
    if (!bu.isNullOrNil(str))
    {
      g.yxI.kvStat(14092, str);
      AppMethodBeat.o(36252);
      return;
    }
    g.yxI.kvStat(14092, "0");
    AppMethodBeat.o(36252);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.j.9
 * JD-Core Version:    0.7.0.1
 */