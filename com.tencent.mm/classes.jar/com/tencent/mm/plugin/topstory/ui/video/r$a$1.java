package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.a.b.a;
import com.tencent.mm.sdk.platformtools.ab;

final class r$a$1
  implements Runnable
{
  r$a$1(r.a parama, int paramInt1, int paramInt2, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(1823);
    if ((this.tkb.tjY.tjP != null) && (this.tkb.tjY.thM != null))
    {
      a locala = this.tkb.tjY.thM.cJd().tjL;
      if ((locala != null) && (locala.tfg == 0L))
      {
        locala.tfg = (System.currentTimeMillis() - locala.teT);
        locala.tfh = this.fzv;
        locala.tfi = (this.fzv + this.fzw);
        ab.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "onMoovReady %d %d %d", new Object[] { Long.valueOf(locala.tfg), Integer.valueOf(this.fzv), Integer.valueOf(this.fzw) });
      }
      this.tkb.tjY.tjP.mi(this.fzv);
    }
    AppMethodBeat.o(1823);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.r.a.1
 * JD-Core Version:    0.7.0.1
 */