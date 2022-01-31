package com.tencent.mm.plugin.websearch.api;

import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.c;
import java.util.Map;

final class ak$2
  implements Runnable
{
  ak$2(ak paramak) {}
  
  public final void run()
  {
    Object localObject = a.b.dHs;
    localObject = a.fJ("100344");
    if (localObject == null)
    {
      y.i("MicroMsg.WebSearch.WebSearchPreloadExport", "openSearchPreload item is null");
      return;
    }
    ak localak = this.qUG;
    if ((((c)localObject).isValid()) && ("1".equals(((c)localObject).ctr().get("isOpen")))) {}
    for (boolean bool = true;; bool = false)
    {
      ak.a(localak, bool);
      y.i("MicroMsg.WebSearch.WebSearchPreloadExport", "openSearchPreload :%b", new Object[] { Boolean.valueOf(ak.a(this.qUG)) });
      localObject = a.b.dHs;
      localObject = a.fJ("100346");
      if (localObject != null) {
        break;
      }
      y.i("MicroMsg.WebSearch.WebSearchPreloadExport", "openSearchPreload item is null");
      return;
    }
    localak = this.qUG;
    if ((((c)localObject).isValid()) && ("1".equals(((c)localObject).ctr().get("isOpen")))) {}
    for (bool = true;; bool = false)
    {
      ak.b(localak, bool);
      y.i("MicroMsg.WebSearch.WebSearchPreloadExport", "openRecommendPreload :%b", new Object[] { Boolean.valueOf(ak.b(this.qUG)) });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ak.2
 * JD-Core Version:    0.7.0.1
 */