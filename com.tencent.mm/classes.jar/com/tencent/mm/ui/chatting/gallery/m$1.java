package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.u;

final class m$1
  implements Runnable
{
  m$1(m paramm) {}
  
  public final void run()
  {
    AppMethodBeat.i(32452);
    if (this.zOd.zOb != null)
    {
      int i = u.D(this.zOd.fVl, this.zOd.filename);
      if (this.zOd.mj(i))
      {
        if ((this.zOd.rJL == 0) && (this.zOd.rJN == 0L)) {
          this.zOd.cuk();
        }
        this.zOd.zOb.bw(this.zOd.filename, true);
        this.zOd.fVr = true;
      }
    }
    AppMethodBeat.o(32452);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.m.1
 * JD-Core Version:    0.7.0.1
 */