package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.modelvideo.u;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class j$14
  implements Runnable
{
  j$14(j paramj) {}
  
  public final void run()
  {
    for (;;)
    {
      try
      {
        if (!bk.bl(this.vwT.vtH.cFV().cGH().vxj.getVideoPath())) {
          continue;
        }
        i = u.u(j.f(this.vwT).eFu, j.a(this.vwT));
        j.f(this.vwT).jr(i);
      }
      catch (Exception localException)
      {
        int i;
        y.printErrStackTrace("MicroMsg.Imagegallery.handler.video", localException, "start timer error[%s]", new Object[] { localException.toString() });
        continue;
      }
      j.m(this.vwT).S(500L, 500L);
      return;
      i = this.vwT.vtH.cFV().cGH().vxj.getCurrentPosition() / 1000;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.j.14
 * JD-Core Version:    0.7.0.1
 */