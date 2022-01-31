package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class l$1
  extends n.a
{
  l$1(l paraml) {}
  
  public final void onNetworkChange(int paramInt)
  {
    AppMethodBeat.i(1742);
    paramInt = this.tjm.qCf;
    this.tjm.qCf = l.cvE();
    if (this.tjm.qCf != paramInt)
    {
      ab.i("MicroMsg.TopStory.TopStoryNetworkMgr", "network change current:%d change:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.tjm.qCf) });
      al.d(new l.1.1(this, paramInt));
    }
    AppMethodBeat.o(1742);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.l.1
 * JD-Core Version:    0.7.0.1
 */