package com.tencent.mm.plugin.voip.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class VideoActivity$14
  implements Runnable
{
  VideoActivity$14(VideoActivity paramVideoActivity, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(4801);
    if (VideoActivity.d(this.tCq) != null) {
      VideoActivity.d(this.tCq).aeH(this.tCs);
    }
    AppMethodBeat.o(4801);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VideoActivity.14
 * JD-Core Version:    0.7.0.1
 */