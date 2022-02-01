package com.tencent.mm.plugin.websearch.api;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;

public class ai
{
  private static volatile ai DCg;
  public HashMap<Integer, aj> DCf;
  
  private ai()
  {
    AppMethodBeat.i(117734);
    this.DCf = new HashMap();
    AppMethodBeat.o(117734);
  }
  
  public static ai eMn()
  {
    AppMethodBeat.i(117735);
    if (DCg == null) {}
    try
    {
      if (DCg == null) {
        DCg = new ai();
      }
      ai localai = DCg;
      AppMethodBeat.o(117735);
      return localai;
    }
    finally
    {
      AppMethodBeat.o(117735);
    }
  }
  
  public final void t(final String paramString, final int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(184555);
    ad.i("MicroMsg.WebSearch.WebSearchPreloadExport", "preloadWebView %s %s %s %s", new Object[] { com.tencent.mm.sdk.platformtools.aj.getProcessName(), paramString, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (com.tencent.mm.sdk.platformtools.aj.fkJ())
    {
      ad.i("MicroMsg.WebSearch.WebSearchPreloadExport", "current preload mgr size %s", new Object[] { Integer.valueOf(this.DCf.size()) });
      if (paramBoolean) {
        this.DCf.remove(Integer.valueOf(paramInt));
      }
      if (!this.DCf.containsKey(Integer.valueOf(paramInt)))
      {
        aj localaj = new aj(paramInt);
        localaj.aFT(paramString);
        this.DCf.put(Integer.valueOf(paramInt), localaj);
        AppMethodBeat.o(184555);
        return;
      }
      ((aj)this.DCf.get(Integer.valueOf(paramInt))).aFT(paramString);
      AppMethodBeat.o(184555);
      return;
    }
    if (com.tencent.mm.sdk.platformtools.aj.cmR()) {
      h.LTJ.aR(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(117733);
          ad.i("MicroMsg.WebSearch.WebSearchPreloadExport", "sending broadcast");
          ai.f("com.tencent.mm.intent.ACTION_PRELOAD_SEARCH", paramString, paramInt, paramBoolean);
          AppMethodBeat.o(117733);
        }
      });
    }
    AppMethodBeat.o(184555);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ai
 * JD-Core Version:    0.7.0.1
 */