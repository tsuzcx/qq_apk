package com.tencent.mm.ui.chatting.gallery;

import android.util.SparseArray;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.pluginsdk.ui.tools.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class j$14
  implements ap.a
{
  j$14(j paramj) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(32329);
    if (this.zNd.zJI == null)
    {
      ab.w("MicroMsg.Imagegallery.handler.video", "[onTimerExpired] null == adapter");
      AppMethodBeat.o(32329);
      return false;
    }
    k localk = this.zNd.zJI.dJY();
    if (localk == null)
    {
      AppMethodBeat.o(32329);
      return false;
    }
    if (localk.zNq == null)
    {
      AppMethodBeat.o(32329);
      return false;
    }
    if (localk.dKP().zNq.getVisibility() != 0)
    {
      AppMethodBeat.o(32329);
      return false;
    }
    int i = this.zNd.zJI.zJK.getCurrentItem();
    if ((s)this.zNd.zMN.get(i) == null)
    {
      this.zNd.Ql(i);
      AppMethodBeat.o(32329);
      return false;
    }
    if (!localk.dKP().zNt.isPlaying())
    {
      ab.i("MicroMsg.Imagegallery.handler.video", "it is not playing, stop offline timer");
      AppMethodBeat.o(32329);
      return false;
    }
    j.a(this.zNd, localk.dKP().zNt.getCurrentPosition());
    this.zNd.Qm(j.n(this.zNd) / 1000);
    AppMethodBeat.o(32329);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.j.14
 * JD-Core Version:    0.7.0.1
 */