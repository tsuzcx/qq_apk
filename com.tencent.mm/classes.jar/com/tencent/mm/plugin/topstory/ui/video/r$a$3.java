package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class r$a$3
  implements Runnable
{
  r$a$3(r.a parama, String paramString, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(1825);
    if (this.tkb.tjY.tjP != null) {
      this.tkb.tjY.tjP.n(this.Cq, this.fzv, this.fFB);
    }
    if (r.ad(this.fzv * 100 / this.fFB, this.fzv)) {
      this.tkb.cKk();
    }
    AppMethodBeat.o(1825);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.r.a.3
 * JD-Core Version:    0.7.0.1
 */