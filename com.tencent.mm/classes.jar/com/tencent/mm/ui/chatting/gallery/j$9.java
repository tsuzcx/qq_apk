package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.n.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Util;

final class j$9
  implements Runnable
{
  j$9(j paramj) {}
  
  public final void run()
  {
    AppMethodBeat.i(36252);
    String str = f.ejd();
    if (!Util.isNullOrNil(str))
    {
      h.CyF.kvStat(14092, str);
      AppMethodBeat.o(36252);
      return;
    }
    h.CyF.kvStat(14092, "0");
    AppMethodBeat.o(36252);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.j.9
 * JD-Core Version:    0.7.0.1
 */