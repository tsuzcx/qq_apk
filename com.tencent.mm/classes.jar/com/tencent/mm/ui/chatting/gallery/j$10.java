package com.tencent.mm.ui.chatting.gallery;

import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.d;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.pluginsdk.ui.tools.e;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

final class j$10
  implements Runnable
{
  j$10(j paramj) {}
  
  public final void run()
  {
    AppMethodBeat.i(32325);
    j.h(this.zNd);
    j.a(this.zNd, j.i(this.zNd));
    j.d(this.zNd).cJ(false);
    j.j(this.zNd);
    if (j.c(this.zNd))
    {
      j.b(this.zNd, bo.aoy());
      j.f(this.zNd).dKR();
      j.f(this.zNd).reset();
      j.a(this.zNd, false);
      j.k(this.zNd);
    }
    u.f(j.a(this.zNd), 0, j.c(this.zNd));
    if (j.l(this.zNd) != null)
    {
      j.a locala = (j.a)j.l(this.zNd).get(j.a(this.zNd));
      if (locala != null)
      {
        k localk = this.zNd.zJI.dJY();
        localk.dKP().zNt.stop();
        j.a(this.zNd, 0);
        this.zNd.a(localk, locala.cmQ, locala.pos);
        this.zNd.Qm(0);
        if (localk.dKP().zNB.getVisibility() != 8) {
          localk.dKP().zNB.setVisibility(8);
        }
      }
    }
    AppMethodBeat.o(32325);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.j.10
 * JD-Core Version:    0.7.0.1
 */