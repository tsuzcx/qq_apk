package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class l$1
  extends n.a
{
  l$1(l paraml) {}
  
  public final void et(int paramInt)
  {
    paramInt = this.pFO.pFN;
    this.pFO.pFN = l.bOn();
    if (this.pFO.pFN != paramInt)
    {
      y.i("MicroMsg.TopStory.TopStoryNetworkMgr", "network change current:%d change:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.pFO.pFN) });
      ai.d(new l.1.1(this, paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.l.1
 * JD-Core Version:    0.7.0.1
 */