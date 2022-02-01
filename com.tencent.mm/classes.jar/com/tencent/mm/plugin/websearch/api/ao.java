package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.HashMap;

public class ao
{
  private static volatile ao Wpz;
  private HashMap<Integer, ap> Wpy;
  
  private ao()
  {
    AppMethodBeat.i(117734);
    this.Wpy = new HashMap();
    AppMethodBeat.o(117734);
  }
  
  public static ao iqg()
  {
    AppMethodBeat.i(117735);
    if (Wpz == null) {}
    try
    {
      if (Wpz == null) {
        Wpz = new ao();
      }
      ao localao = Wpz;
      AppMethodBeat.o(117735);
      return localao;
    }
    finally
    {
      AppMethodBeat.o(117735);
    }
  }
  
  public final void C(final String paramString, final int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(184555);
    Log.i("MicroMsg.WebSearch.WebSearchPreloadExport", "preloadWebView %s %s %s %s", new Object[] { MMApplicationContext.getProcessName(), paramString, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (MMApplicationContext.isToolsMpProcess())
    {
      Log.i("MicroMsg.WebSearch.WebSearchPreloadExport", "current preload mgr size %s", new Object[] { Integer.valueOf(this.Wpy.size()) });
      if (paramBoolean) {
        this.Wpy.remove(Integer.valueOf(paramInt));
      }
      if (!this.Wpy.containsKey(Integer.valueOf(paramInt)))
      {
        ap localap = new ap(paramInt);
        localap.biB(paramString);
        this.Wpy.put(Integer.valueOf(paramInt), localap);
        AppMethodBeat.o(184555);
        return;
      }
      ((ap)this.Wpy.get(Integer.valueOf(paramInt))).biB(paramString);
      AppMethodBeat.o(184555);
      return;
    }
    if (MMApplicationContext.isMainProcess()) {
      h.ahAA.bm(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(117733);
          Log.i("MicroMsg.WebSearch.WebSearchPreloadExport", "sending broadcast");
          ao.b("com.tencent.mm.intent.ACTION_PRELOAD_SEARCH", paramString, paramInt, paramBoolean);
          AppMethodBeat.o(117733);
        }
      });
    }
    AppMethodBeat.o(184555);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ao
 * JD-Core Version:    0.7.0.1
 */