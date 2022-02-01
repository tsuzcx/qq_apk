package com.tencent.mm.plugin.websearch.api;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;

public class an
{
  private static volatile an Pzq;
  private HashMap<Integer, ao> Pzp;
  
  private an()
  {
    AppMethodBeat.i(117734);
    this.Pzp = new HashMap();
    AppMethodBeat.o(117734);
  }
  
  public static an gQU()
  {
    AppMethodBeat.i(117735);
    if (Pzq == null) {}
    try
    {
      if (Pzq == null) {
        Pzq = new an();
      }
      an localan = Pzq;
      AppMethodBeat.o(117735);
      return localan;
    }
    finally
    {
      AppMethodBeat.o(117735);
    }
  }
  
  public final void A(final String paramString, final int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(184555);
    Log.i("MicroMsg.WebSearch.WebSearchPreloadExport", "preloadWebView %s %s %s %s", new Object[] { MMApplicationContext.getProcessName(), paramString, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (MMApplicationContext.isToolsMpProcess())
    {
      Log.i("MicroMsg.WebSearch.WebSearchPreloadExport", "current preload mgr size %s", new Object[] { Integer.valueOf(this.Pzp.size()) });
      if (paramBoolean) {
        this.Pzp.remove(Integer.valueOf(paramInt));
      }
      if (!this.Pzp.containsKey(Integer.valueOf(paramInt)))
      {
        ao localao = new ao(paramInt);
        localao.biT(paramString);
        this.Pzp.put(Integer.valueOf(paramInt), localao);
        AppMethodBeat.o(184555);
        return;
      }
      ((ao)this.Pzp.get(Integer.valueOf(paramInt))).biT(paramString);
      AppMethodBeat.o(184555);
      return;
    }
    if (MMApplicationContext.isMainProcess()) {
      h.ZvG.be(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(117733);
          Log.i("MicroMsg.WebSearch.WebSearchPreloadExport", "sending broadcast");
          an.b("com.tencent.mm.intent.ACTION_PRELOAD_SEARCH", paramString, paramInt, paramBoolean);
          AppMethodBeat.o(117733);
        }
      });
    }
    AppMethodBeat.o(184555);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.an
 * JD-Core Version:    0.7.0.1
 */