package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.modelvideo.s;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

final class j$5
  implements Runnable
{
  j$5(j paramj, String paramString, boolean paramBoolean) {}
  
  public final void run()
  {
    y.i("MicroMsg.Imagegallery.handler.video", "prepare video filename %s isOnlinePlay %b ", new Object[] { this.opw, Boolean.valueOf(this.vwX) });
    if (j.l(this.vwT) == null) {
      y.w("MicroMsg.Imagegallery.handler.video", "prepare video but cache map is null.");
    }
    j.a locala;
    do
    {
      return;
      locala = (j.a)j.l(this.vwT).get(this.opw);
    } while ((locala == null) || (locala.bFH == null));
    s locals = j.bz(locala.bFH);
    if (this.vwT.vtH.vtJ.getCurrentItem() == locala.pos)
    {
      j.a(this.vwT, locala.bFH, locals, locala.pos, this.vwX);
      this.vwT.adF(this.opw);
      return;
    }
    y.w("MicroMsg.Imagegallery.handler.video", "playVideo, but currentItem is not correct.[%d, %d]", new Object[] { Integer.valueOf(this.vwT.vtH.vtJ.getCurrentItem()), Integer.valueOf(locala.pos) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.j.5
 * JD-Core Version:    0.7.0.1
 */