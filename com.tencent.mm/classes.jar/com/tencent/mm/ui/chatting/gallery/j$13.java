package com.tencent.mm.ui.chatting.gallery;

import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.e;
import com.tencent.mm.sdk.platformtools.ap.a;

final class j$13
  implements ap.a
{
  j$13(j paramj) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(32328);
    if (!j.f(this.zNd).isStreaming())
    {
      AppMethodBeat.o(32328);
      return false;
    }
    k localk = this.zNd.zJI.dJY();
    if (localk == null)
    {
      AppMethodBeat.o(32328);
      return false;
    }
    if (localk.zNq == null)
    {
      AppMethodBeat.o(32328);
      return false;
    }
    if (localk.dKP().zNq.getVisibility() != 0)
    {
      AppMethodBeat.o(32328);
      return false;
    }
    boolean bool = true;
    if (localk.dKP().zNt.isPlaying()) {
      bool = j.b(this.zNd, localk);
    }
    if (bool)
    {
      int i = localk.dKP().zNt.getCurrentPosition() / 1000;
      bool = j.f(this.zNd).mj(i);
      AppMethodBeat.o(32328);
      return bool;
    }
    AppMethodBeat.o(32328);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.j.13
 * JD-Core Version:    0.7.0.1
 */