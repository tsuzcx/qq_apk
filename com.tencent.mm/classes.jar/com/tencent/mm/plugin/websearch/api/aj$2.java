package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.c;
import java.util.Map;

final class aj$2
  implements Runnable
{
  aj$2(aj paramaj) {}
  
  public final void run()
  {
    AppMethodBeat.i(124178);
    Object localObject = a.b.eEW;
    localObject = a.me("100344");
    if (localObject == null)
    {
      ab.i("MicroMsg.WebSearch.WebSearchPreloadExport", "openSearchPreload item is null");
      AppMethodBeat.o(124178);
      return;
    }
    aj localaj = this.uJQ;
    if ((((c)localObject).isValid()) && ("1".equals(((c)localObject).dvN().get("isOpen")))) {}
    for (boolean bool = true;; bool = false)
    {
      aj.a(localaj, bool);
      ab.i("MicroMsg.WebSearch.WebSearchPreloadExport", "openSearchPreload :%b", new Object[] { Boolean.valueOf(aj.a(this.uJQ)) });
      localObject = a.b.eEW;
      localObject = a.me("100346");
      if (localObject != null) {
        break;
      }
      ab.i("MicroMsg.WebSearch.WebSearchPreloadExport", "openSearchPreload item is null");
      AppMethodBeat.o(124178);
      return;
    }
    localaj = this.uJQ;
    if ((((c)localObject).isValid()) && ("1".equals(((c)localObject).dvN().get("isOpen")))) {}
    for (bool = true;; bool = false)
    {
      aj.b(localaj, bool);
      ab.i("MicroMsg.WebSearch.WebSearchPreloadExport", "openRecommendPreload :%b", new Object[] { Boolean.valueOf(aj.b(this.uJQ)) });
      AppMethodBeat.o(124178);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.aj.2
 * JD-Core Version:    0.7.0.1
 */