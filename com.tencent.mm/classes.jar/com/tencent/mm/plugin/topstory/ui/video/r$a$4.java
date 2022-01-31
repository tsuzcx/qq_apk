package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class r$a$4
  implements Runnable
{
  r$a$4(r.a parama, String paramString, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(1826);
    if ((this.tkb.tjY.tjP != null) && (this.tkb.tjY.thM != null))
    {
      com.tencent.mm.plugin.topstory.a.b.a locala = this.tkb.tjY.thM.cJd().tjL;
      if ((locala != null) && (locala.tff == 0L)) {
        locala.tff = (System.currentTimeMillis() - locala.teT);
      }
      this.tkb.tjY.tjP.ad(this.Cq, this.qac);
      if (this.qac != 0)
      {
        com.tencent.mm.plugin.websearch.api.a.a.kS(9);
        AppMethodBeat.o(1826);
        return;
      }
      com.tencent.mm.plugin.websearch.api.a.a.kS(27);
    }
    AppMethodBeat.o(1826);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.r.a.4
 * JD-Core Version:    0.7.0.1
 */