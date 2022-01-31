package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.sight.decode.ui.b;
import com.tencent.mm.pluginsdk.ui.tools.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;

final class j$2
  implements b
{
  j$2(j paramj) {}
  
  public final void aFf()
  {
    AppMethodBeat.i(32314);
    if (this.zNd.zJI.dJY() != null) {
      j.a(this.zNd, this.zNd.zJI.dJY());
    }
    this.zNd.zJI.zJK.zMx.stopTimer();
    AppMethodBeat.o(32314);
  }
  
  public final void on(int paramInt)
  {
    AppMethodBeat.i(32315);
    localObject = null;
    try
    {
      String str = this.zNd.zJI.dJY().dKP().zNt.getVideoPath();
      localObject = str;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.Imagegallery.handler.video", localException, "", new Object[0]);
        ab.e("MicroMsg.Imagegallery.handler.video", "on seek get video path error: " + localException.toString());
        continue;
        boolean bool = j.f(this.zNd).aJ(paramInt, true);
        continue;
        localObject = this.zNd.zJI.dJX();
        if ((localObject != null) && (((bi)localObject).byj())) {
          u.f(((dd)localObject).field_imgPath, paramInt * 1000, j.c(this.zNd));
        }
        this.zNd.zJI.PV(this.zNd.zJI.zJK.getCurrentItem());
      }
    }
    ab.i("MicroMsg.Imagegallery.handler.video", "on seek to time[%d] isOnlinePlay[%b] videoPath[%s]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(j.c(this.zNd)), localObject });
    if (!bo.isNullOrNil((String)localObject)) {
      if (!j.c(this.zNd))
      {
        this.zNd.ag(paramInt, true);
        bool = true;
        if (bool) {
          this.zNd.dh(false);
        }
        this.zNd.zJI.zJK.dKs();
        AppMethodBeat.o(32315);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.j.2
 * JD-Core Version:    0.7.0.1
 */