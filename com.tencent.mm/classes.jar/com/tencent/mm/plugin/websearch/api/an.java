package com.tencent.mm.plugin.websearch.api;

import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;

public class an
{
  private static volatile an IEY;
  private HashMap<Integer, ao> IEX;
  
  private an()
  {
    AppMethodBeat.i(117734);
    this.IEX = new HashMap();
    AppMethodBeat.o(117734);
  }
  
  public static an fYj()
  {
    AppMethodBeat.i(117735);
    if (IEY == null) {}
    try
    {
      if (IEY == null) {
        IEY = new an();
      }
      an localan = IEY;
      AppMethodBeat.o(117735);
      return localan;
    }
    finally
    {
      AppMethodBeat.o(117735);
    }
  }
  
  public final void w(final String paramString, final int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(184555);
    Log.i("MicroMsg.WebSearch.WebSearchPreloadExport", "preloadWebView %s %s %s %s", new Object[] { MMApplicationContext.getProcessName(), paramString, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (MMApplicationContext.isToolsMpProcess())
    {
      Log.i("MicroMsg.WebSearch.WebSearchPreloadExport", "current preload mgr size %s", new Object[] { Integer.valueOf(this.IEX.size()) });
      if (paramBoolean) {
        this.IEX.remove(Integer.valueOf(paramInt));
      }
      if (!this.IEX.containsKey(Integer.valueOf(paramInt)))
      {
        ao localao = new ao(paramInt);
        localao.aXi(paramString);
        this.IEX.put(Integer.valueOf(paramInt), localao);
        AppMethodBeat.o(184555);
        return;
      }
      ((ao)this.IEX.get(Integer.valueOf(paramInt))).aXi(paramString);
      AppMethodBeat.o(184555);
      return;
    }
    if (MMApplicationContext.isMainProcess()) {
      h.RTc.aX(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(117733);
          Log.i("MicroMsg.WebSearch.WebSearchPreloadExport", "sending broadcast");
          an.e("com.tencent.mm.intent.ACTION_PRELOAD_SEARCH", paramString, paramInt, paramBoolean);
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