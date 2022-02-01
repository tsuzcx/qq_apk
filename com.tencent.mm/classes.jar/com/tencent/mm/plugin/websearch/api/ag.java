package com.tencent.mm.plugin.websearch.api;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.HashMap;
import java.util.Map;

public class ag
{
  private static volatile ag AGT;
  private h AGR;
  private Map<Integer, ah> AGS;
  
  private ag()
  {
    AppMethodBeat.i(117734);
    this.AGR = new ad();
    this.AGS = new HashMap();
    AppMethodBeat.o(117734);
  }
  
  public static ag eic()
  {
    AppMethodBeat.i(117735);
    if (AGT == null) {}
    try
    {
      if (AGT == null) {
        AGT = new ag();
      }
      ag localag = AGT;
      AppMethodBeat.o(117735);
      return localag;
    }
    finally
    {
      AppMethodBeat.o(117735);
    }
  }
  
  public final h Sg(int paramInt)
  {
    AppMethodBeat.i(117736);
    if (paramInt <= 0)
    {
      localObject = this.AGR;
      AppMethodBeat.o(117736);
      return localObject;
    }
    ah localah = (ah)this.AGS.get(Integer.valueOf(paramInt));
    Object localObject = localah;
    if (localah == null)
    {
      localObject = new ah(paramInt);
      this.AGS.put(Integer.valueOf(paramInt), localObject);
    }
    AppMethodBeat.o(117736);
    return localObject;
  }
  
  public final void t(final String paramString, final int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(184555);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.WebSearchPreloadExport", "preloadWebview %s", new Object[] { aj.getProcessName() });
    if (aj.eFK())
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.WebSearchPreloadExport", "current preload mgr size %s", new Object[] { Integer.valueOf(this.AGS.size()) });
      Sg(paramInt).bY(paramString, paramBoolean);
      AppMethodBeat.o(184555);
      return;
    }
    if (aj.cbe()) {
      com.tencent.e.h.Iye.aP(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(117733);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WebSearch.WebSearchPreloadExport", "sending broadcast");
          ag.f("com.tencent.mm.intent.ACTION_PRELOAD_SEARCH", paramString, paramInt, paramBoolean);
          AppMethodBeat.o(117733);
        }
      });
    }
    AppMethodBeat.o(184555);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ag
 * JD-Core Version:    0.7.0.1
 */