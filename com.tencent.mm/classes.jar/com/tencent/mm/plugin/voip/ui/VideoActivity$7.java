package com.tencent.mm.plugin.voip.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.a.b;

final class VideoActivity$7
  implements Runnable
{
  VideoActivity$7(VideoActivity paramVideoActivity) {}
  
  public final void run()
  {
    AppMethodBeat.i(4793);
    if ((b.HS(VideoActivity.b(this.tCq))) && (!VideoActivity.c(this.tCq)) && (VideoActivity.d(this.tCq) != null)) {
      VideoActivity.d(this.tCq).gm(2131304636, 10000);
    }
    AppMethodBeat.o(4793);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VideoActivity.7
 * JD-Core Version:    0.7.0.1
 */