package com.tencent.mm.plugin.websearch.api;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashMap;

public class ai
{
  private static volatile ai DUd;
  public HashMap<Integer, aj> DUc;
  
  private ai()
  {
    AppMethodBeat.i(117734);
    this.DUc = new HashMap();
    AppMethodBeat.o(117734);
  }
  
  public static ai ePW()
  {
    AppMethodBeat.i(117735);
    if (DUd == null) {}
    try
    {
      if (DUd == null) {
        DUd = new ai();
      }
      ai localai = DUd;
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
    ae.i("MicroMsg.WebSearch.WebSearchPreloadExport", "preloadWebView %s %s %s %s", new Object[] { ak.getProcessName(), paramString, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (ak.foD())
    {
      ae.i("MicroMsg.WebSearch.WebSearchPreloadExport", "current preload mgr size %s", new Object[] { Integer.valueOf(this.DUc.size()) });
      if (paramBoolean) {
        this.DUc.remove(Integer.valueOf(paramInt));
      }
      if (!this.DUc.containsKey(Integer.valueOf(paramInt)))
      {
        aj localaj = new aj(paramInt);
        localaj.aHn(paramString);
        this.DUc.put(Integer.valueOf(paramInt), localaj);
        AppMethodBeat.o(184555);
        return;
      }
      ((aj)this.DUc.get(Integer.valueOf(paramInt))).aHn(paramString);
      AppMethodBeat.o(184555);
      return;
    }
    if (ak.coh()) {
      h.MqF.aO(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(117733);
          ae.i("MicroMsg.WebSearch.WebSearchPreloadExport", "sending broadcast");
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