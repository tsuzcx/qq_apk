package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.e;

final class VideoSightView$1
  implements b.e
{
  VideoSightView$1(VideoSightView paramVideoSightView) {}
  
  public final void c(b paramb, int paramInt)
  {
    AppMethodBeat.i(70415);
    if (-1 == paramInt)
    {
      if (this.wfO.lxA != null)
      {
        this.wfO.lxA.onError(0, 0);
        AppMethodBeat.o(70415);
      }
    }
    else if ((paramInt == 0) && (this.wfO.lxA != null)) {
      this.wfO.lxA.Es();
    }
    AppMethodBeat.o(70415);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoSightView.1
 * JD-Core Version:    0.7.0.1
 */