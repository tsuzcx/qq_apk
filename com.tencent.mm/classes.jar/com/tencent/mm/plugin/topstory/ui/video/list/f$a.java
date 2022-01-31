package com.tencent.mm.plugin.topstory.ui.video.list;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.video.c;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.sdk.platformtools.ab;

final class f$a
  implements c
{
  private float tks;
  
  f$a(f paramf)
  {
    AppMethodBeat.i(2053);
    this.tks = com.tencent.mm.cb.a.gx(paramf.getContext());
    AppMethodBeat.o(2053);
  }
  
  public final void GC(int paramInt)
  {
    AppMethodBeat.i(2058);
    f.g(this.tlr).cKp();
    f.T(this.tlr).setVisibility(8);
    this.tlr.seekTo(paramInt);
    AppMethodBeat.o(2058);
  }
  
  public final void aEX()
  {
    AppMethodBeat.i(2054);
    ab.d("MicroMsg.TopStory.TopStoryListVideoContainer", "onSingleTap");
    if (f.Q(this.tlr))
    {
      if (f.g(this.tlr).Pk())
      {
        f.g(this.tlr).setVisibility(8);
        AppMethodBeat.o(2054);
        return;
      }
      f.g(this.tlr).show();
      if (this.tlr.getListItemUIComponent() != null)
      {
        this.tlr.getListItemUIComponent().cJa();
        this.tlr.getListItemUIComponent().cIZ();
      }
    }
    AppMethodBeat.o(2054);
  }
  
  public final void aEY()
  {
    AppMethodBeat.i(2055);
    ab.d("MicroMsg.TopStory.TopStoryListVideoContainer", "onDoubleTap");
    AppMethodBeat.o(2055);
  }
  
  public final void aEZ()
  {
    AppMethodBeat.i(2056);
    f.R(this.tlr).setVisibility(0);
    f.g(this.tlr).cKo();
    AppMethodBeat.o(2056);
  }
  
  public final int bj(float paramFloat)
  {
    AppMethodBeat.i(2057);
    paramFloat /= this.tks;
    int j = this.tlr.getListVideoUIComponent().cJh().getVideoDurationSec();
    int i = getCurrentPosition();
    int k = (int)(paramFloat * j) + i;
    if (k < 0) {
      i = 0;
    }
    for (;;)
    {
      String str = com.tencent.mm.plugin.websearch.ui.a.ha(j * 1000L);
      f.S(this.tlr).setText(com.tencent.mm.plugin.websearch.ui.a.ha(i * 1000L) + "/" + str);
      AppMethodBeat.o(2057);
      return i;
      i = k;
      if (k > j) {
        i = j;
      }
    }
  }
  
  public final boolean cJx()
  {
    AppMethodBeat.i(2059);
    if (f.U(this.tlr))
    {
      AppMethodBeat.o(2059);
      return false;
    }
    AppMethodBeat.o(2059);
    return true;
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(2060);
    int i = this.tlr.getListVideoUIComponent().cJh().getCurrPosSec();
    AppMethodBeat.o(2060);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.f.a
 * JD-Core Version:    0.7.0.1
 */