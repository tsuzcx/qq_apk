package com.tencent.mm.plugin.topstory.ui.video.fs;

import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.video.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

final class d$1
  implements Runnable
{
  d$1(d paramd, List paramList) {}
  
  public final void run()
  {
    com.tencent.mm.plugin.topstory.ui.video.n localn = this.pGN.pEp.bNJ();
    int i = localn.cVn();
    y.i("MicroMsg.TopStory.TopStoryFSVideoAdapter", "callbackToSuccess originSize: %d insertSize %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.pFy.size()) });
    List localList = this.pFy;
    try
    {
      if (!bk.dk(localList)) {
        localn.cnS().addAll(localList);
      }
      this.pGN.bL(this.pGN.pEn.size() + i);
      this.pGN.aj(i + this.pGN.pEn.size(), this.pFy.size());
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.d.1
 * JD-Core Version:    0.7.0.1
 */