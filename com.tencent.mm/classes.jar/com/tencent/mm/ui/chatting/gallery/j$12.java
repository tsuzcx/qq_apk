package com.tencent.mm.ui.chatting.gallery;

import android.widget.ProgressBar;
import com.tencent.mm.model.d;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.HashMap;

final class j$12
  implements Runnable
{
  j$12(j paramj) {}
  
  public final void run()
  {
    j.h(this.vwT);
    j.a(this.vwT, j.i(this.vwT));
    j.d(this.vwT).bH(false);
    j.j(this.vwT);
    if (j.c(this.vwT))
    {
      j.b(this.vwT, bk.UY());
      j.f(this.vwT).cGJ();
      j.f(this.vwT).reset();
      j.a(this.vwT, false);
      j.k(this.vwT);
    }
    u.f(j.a(this.vwT), 0, j.c(this.vwT));
    if (j.l(this.vwT) != null)
    {
      j.a locala = (j.a)j.l(this.vwT).get(j.a(this.vwT));
      if (locala != null)
      {
        k localk = this.vwT.vtH.cFV();
        localk.cGH().vxj.stop();
        j.a(this.vwT, 0);
        this.vwT.a(localk, locala.bFH, locala.pos);
        this.vwT.HF(0);
        if (localk.cGH().vxr.getVisibility() != 8) {
          localk.cGH().vxr.setVisibility(8);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.j.12
 * JD-Core Version:    0.7.0.1
 */