package com.tencent.mm.plugin.multitalk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.kernel.h;

final class ad$1
  extends o.a
{
  ad$1(ad paramad) {}
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(114621);
    if ((h.aHB()) && (h.aHE().kbT))
    {
      h.aHE();
      com.tencent.mm.kernel.b.aGE();
    }
    AppMethodBeat.o(114621);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(114620);
    if ((h.aHB()) && (h.aHE().kbT))
    {
      h.aHE();
      if (!com.tencent.mm.kernel.b.aGE()) {
        com.tencent.mm.blink.b.aqa().arrange(new ad.1.1(this));
      }
    }
    AppMethodBeat.o(114620);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.ad.1
 * JD-Core Version:    0.7.0.1
 */