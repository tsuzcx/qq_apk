package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class aj$1
  implements Runnable
{
  aj$1(aj paramaj, int paramInt, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(124177);
    aj localaj = this.uJQ;
    int i = this.uJP;
    boolean bool;
    switch (i)
    {
    case 3: 
    default: 
      ab.w("MicroMsg.WebSearch.WebSearchPreloadExport", "unknown preload biz %d", new Object[] { Integer.valueOf(i) });
      bool = false;
    }
    while (!bool)
    {
      ab.i("MicroMsg.WebSearch.WebSearchPreloadExport", "preload switch close , biz %d, url %s", new Object[] { Integer.valueOf(this.uJP), this.val$url });
      AppMethodBeat.o(124177);
      return;
      bool = localaj.cZE();
      continue;
      bool = localaj.cZD();
      continue;
      bool = localaj.cZD();
      continue;
      bool = true;
    }
    ab.i("MicroMsg.WebSearch.WebSearchPreloadExport", "sending broadcast");
    aj.O("com.tencent.mm.intent.ACTION_PRELOAD_SEARCH", this.val$url, this.uJP);
    AppMethodBeat.o(124177);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.aj.1
 * JD-Core Version:    0.7.0.1
 */