package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

final class j$4
  implements Runnable
{
  j$4(j paramj, String paramString, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(32319);
    ab.i("MicroMsg.Imagegallery.handler.video", "prepare video filename %s isOnlinePlay %b ", new Object[] { this.rdZ, Boolean.valueOf(this.zNe) });
    if (j.l(this.zNd) == null)
    {
      ab.w("MicroMsg.Imagegallery.handler.video", "prepare video but cache map is null.");
      AppMethodBeat.o(32319);
      return;
    }
    j.a locala = (j.a)j.l(this.zNd).get(this.rdZ);
    if ((locala == null) || (locala.cmQ == null))
    {
      AppMethodBeat.o(32319);
      return;
    }
    s locals = j.bH(locala.cmQ);
    if (this.zNd.zJI.zJK.getCurrentItem() == locala.pos)
    {
      j.a(this.zNd, locala.cmQ, locals, locala.pos, this.zNe);
      this.zNd.aui(this.rdZ);
      AppMethodBeat.o(32319);
      return;
    }
    ab.w("MicroMsg.Imagegallery.handler.video", "playVideo, but currentItem is not correct.[%d, %d]", new Object[] { Integer.valueOf(this.zNd.zJI.zJK.getCurrentItem()), Integer.valueOf(locala.pos) });
    AppMethodBeat.o(32319);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.j.4
 * JD-Core Version:    0.7.0.1
 */