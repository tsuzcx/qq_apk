package com.tencent.mm.plugin.websearch.api;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.HashMap;

public class ae
{
  private static volatile ae BZk;
  public HashMap<Integer, af> BZj;
  
  private ae()
  {
    AppMethodBeat.i(117734);
    this.BZj = new HashMap();
    AppMethodBeat.o(117734);
  }
  
  public static ae exw()
  {
    AppMethodBeat.i(117735);
    if (BZk == null) {}
    try
    {
      if (BZk == null) {
        BZk = new ae();
      }
      ae localae = BZk;
      AppMethodBeat.o(117735);
      return localae;
    }
    finally
    {
      AppMethodBeat.o(117735);
    }
  }
  
  public final void t(final String paramString, final int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(184555);
    ac.i("MicroMsg.WebSearch.WebSearchPreloadExport", "preloadWebView %s %s %s %s", new Object[] { ai.getProcessName(), paramString, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (ai.eVe())
    {
      ac.i("MicroMsg.WebSearch.WebSearchPreloadExport", "current preload mgr size %s", new Object[] { Integer.valueOf(this.BZj.size()) });
      if (paramBoolean) {
        this.BZj.remove(Integer.valueOf(paramInt));
      }
      if (!this.BZj.containsKey(Integer.valueOf(paramInt)))
      {
        af localaf = new af(paramInt);
        localaf.aAz(paramString);
        this.BZj.put(Integer.valueOf(paramInt), localaf);
        AppMethodBeat.o(184555);
        return;
      }
      ((af)this.BZj.get(Integer.valueOf(paramInt))).aAz(paramString);
      AppMethodBeat.o(184555);
      return;
    }
    if (ai.cin()) {
      h.JZN.aS(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(117733);
          ac.i("MicroMsg.WebSearch.WebSearchPreloadExport", "sending broadcast");
          ae.f("com.tencent.mm.intent.ACTION_PRELOAD_SEARCH", paramString, paramInt, paramBoolean);
          AppMethodBeat.o(117733);
        }
      });
    }
    AppMethodBeat.o(184555);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ae
 * JD-Core Version:    0.7.0.1
 */