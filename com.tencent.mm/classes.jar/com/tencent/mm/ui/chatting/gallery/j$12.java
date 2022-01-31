package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.pluginsdk.ui.tools.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;

final class j$12
  implements Runnable
{
  j$12(j paramj) {}
  
  public final void run()
  {
    AppMethodBeat.i(32327);
    for (;;)
    {
      try
      {
        if (!bo.isNullOrNil(this.zNd.zJI.dJY().dKP().zNt.getVideoPath())) {
          continue;
        }
        i = u.D(j.f(this.zNd).fVl, j.a(this.zNd));
        j.f(this.zNd).mj(i);
      }
      catch (Exception localException)
      {
        int i;
        ab.printErrStackTrace("MicroMsg.Imagegallery.handler.video", localException, "start timer error[%s]", new Object[] { localException.toString() });
        continue;
      }
      j.m(this.zNd).ag(500L, 500L);
      AppMethodBeat.o(32327);
      return;
      i = this.zNd.zJI.dJY().dKP().zNt.getCurrentPosition() / 1000;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.j.12
 * JD-Core Version:    0.7.0.1
 */