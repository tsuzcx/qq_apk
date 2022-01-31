package com.tencent.mm.plugin.websearch.api;

import com.tencent.mm.sdk.platformtools.y;

final class ak$1
  implements Runnable
{
  ak$1(ak paramak, int paramInt, String paramString) {}
  
  public final void run()
  {
    ak localak = this.qUG;
    int i = this.qUF;
    boolean bool;
    switch (i)
    {
    case 3: 
    default: 
      y.w("MicroMsg.WebSearch.WebSearchPreloadExport", "unknown preload biz %d", new Object[] { Integer.valueOf(i) });
      bool = false;
    }
    while (!bool)
    {
      y.i("MicroMsg.WebSearch.WebSearchPreloadExport", "preload switch close , biz %d, url %s", new Object[] { Integer.valueOf(this.qUF), this.val$url });
      return;
      bool = localak.bZH();
      continue;
      bool = localak.bZG();
      continue;
      bool = localak.bZG();
    }
    y.i("MicroMsg.WebSearch.WebSearchPreloadExport", "sending broadcast");
    ak.G("com.tencent.mm.intent.ACTION_PRELOAD_SEARCH", this.val$url, this.qUF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ak.1
 * JD-Core Version:    0.7.0.1
 */