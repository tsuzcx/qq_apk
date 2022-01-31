package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.h.c.cs;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.sight.decode.ui.b;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;

final class j$3
  implements b
{
  j$3(j paramj) {}
  
  public final void akz()
  {
    if (this.vwT.vtH.cFV() != null) {
      j.a(this.vwT, this.vwT.vtH.cFV());
    }
    this.vwT.vtH.vtJ.vwp.stopTimer();
  }
  
  public final void lE(int paramInt)
  {
    localObject = null;
    try
    {
      String str = this.vwT.vtH.cFV().cGH().vxj.getVideoPath();
      localObject = str;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.Imagegallery.handler.video", localException, "", new Object[0]);
        y.e("MicroMsg.Imagegallery.handler.video", "on seek get video path error: " + localException.toString());
        continue;
        boolean bool = j.f(this.vwT).at(paramInt, true);
        continue;
        localObject = this.vwT.vtH.cFU();
        if ((localObject != null) && (((bi)localObject).aRQ())) {
          u.f(((cs)localObject).field_imgPath, paramInt * 1000, j.c(this.vwT));
        }
        this.vwT.vtH.Ho(this.vwT.vtH.vtJ.getCurrentItem());
      }
    }
    y.i("MicroMsg.Imagegallery.handler.video", "on seek to time[%d] isOnlinePlay[%b] videoPath[%s]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(j.c(this.vwT)), localObject });
    if (!bk.bl((String)localObject)) {
      if (!j.c(this.vwT))
      {
        this.vwT.X(paramInt, true);
        bool = true;
        if (bool) {
          this.vwT.ce(false);
        }
        this.vwT.vtH.vtJ.cGn();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.j.3
 * JD-Core Version:    0.7.0.1
 */