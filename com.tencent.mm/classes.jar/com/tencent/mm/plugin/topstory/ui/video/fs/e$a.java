package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.video.c;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.sdk.platformtools.ab;

public class e$a
  implements c
{
  private float tks;
  
  e$a(e parame)
  {
    AppMethodBeat.i(1901);
    this.tks = com.tencent.mm.cb.a.gx(parame.getContext());
    AppMethodBeat.o(1901);
  }
  
  public void GC(int paramInt)
  {
    AppMethodBeat.i(1906);
    this.tkq.tkg.cKp();
    e.T(this.tkq).setVisibility(8);
    this.tkq.seekTo(paramInt);
    AppMethodBeat.o(1906);
  }
  
  public final void aEX()
  {
    AppMethodBeat.i(1902);
    ab.d("MicroMsg.TopStory.TopStoryFSVideoContainer", "onSingleTap");
    if (e.Q(this.tkq))
    {
      if (this.tkq.tkg.Pk())
      {
        this.tkq.tkg.setVisibility(8);
        AppMethodBeat.o(1902);
        return;
      }
      this.tkq.tkg.show();
      if (this.tkq.getFSItemUIComponent() != null)
      {
        this.tkq.getFSItemUIComponent().cJa();
        this.tkq.getFSItemUIComponent().cIZ();
      }
    }
    AppMethodBeat.o(1902);
  }
  
  public final void aEY()
  {
    AppMethodBeat.i(1903);
    ab.d("MicroMsg.TopStory.TopStoryFSVideoContainer", "onDoubleTap");
    AppMethodBeat.o(1903);
  }
  
  public void aEZ()
  {
    AppMethodBeat.i(1904);
    e.R(this.tkq).setVisibility(0);
    this.tkq.tkg.cKo();
    AppMethodBeat.o(1904);
  }
  
  public int bj(float paramFloat)
  {
    AppMethodBeat.i(1905);
    paramFloat /= this.tks;
    int j = this.tkq.getFSVideoUIComponent().cJh().getVideoDurationSec();
    int i = getCurrentPosition();
    int k = (int)(paramFloat * j) + i;
    if (k < 0) {
      i = 0;
    }
    for (;;)
    {
      String str = com.tencent.mm.plugin.websearch.ui.a.ha(j * 1000L);
      e.S(this.tkq).setText(com.tencent.mm.plugin.websearch.ui.a.ha(i * 1000L) + "/" + str);
      AppMethodBeat.o(1905);
      return i;
      i = k;
      if (k > j) {
        i = j;
      }
    }
  }
  
  public final boolean cJx()
  {
    AppMethodBeat.i(1907);
    if (e.U(this.tkq))
    {
      AppMethodBeat.o(1907);
      return false;
    }
    AppMethodBeat.o(1907);
    return true;
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(1908);
    int i = this.tkq.getFSVideoUIComponent().cJh().getCurrPosSec();
    AppMethodBeat.o(1908);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.e.a
 * JD-Core Version:    0.7.0.1
 */