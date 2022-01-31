package com.tencent.mm.ui.chatting.gallery;

import android.util.SparseArray;
import android.widget.RelativeLayout;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

final class j$16
  implements am.a
{
  j$16(j paramj) {}
  
  public final boolean tC()
  {
    k localk = this.vwT.vtH.cFV();
    if (localk == null) {
      return false;
    }
    if (localk.vxg == null) {
      return false;
    }
    if (localk.cGH().vxg.getVisibility() != 0) {
      return false;
    }
    int i = this.vwT.vtH.vtJ.getCurrentItem();
    if ((s)this.vwT.vwC.get(i) == null)
    {
      this.vwT.HE(i);
      return false;
    }
    if (!localk.cGH().vxj.isPlaying())
    {
      y.i("MicroMsg.Imagegallery.handler.video", "it is not playing, stop offline timer");
      return false;
    }
    j.a(this.vwT, localk.cGH().vxj.getCurrentPosition());
    this.vwT.HF(j.n(this.vwT) / 1000);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.j.16
 * JD-Core Version:    0.7.0.1
 */