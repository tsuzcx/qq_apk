package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.sdk.platformtools.ab;

final class VideoSightCenterView$1
  implements b.e
{
  VideoSightCenterView$1(VideoSightCenterView paramVideoSightCenterView) {}
  
  public final void c(b paramb, int paramInt)
  {
    AppMethodBeat.i(70397);
    if (-1 == paramInt)
    {
      ab.i("MicroMsg.VideoSightCenterView", "error stop, isCompletion: %s", new Object[] { Boolean.valueOf(VideoSightCenterView.a(this.wfK)) });
      if ((this.wfK.lxA != null) && (!VideoSightCenterView.a(this.wfK)))
      {
        this.wfK.lxA.onError(0, 0);
        AppMethodBeat.o(70397);
      }
    }
    else if (paramInt == 0)
    {
      ab.i("MicroMsg.VideoSightCenterView", "normal stop");
      VideoSightCenterView.b(this.wfK);
      if (this.wfK.lxA != null) {
        this.wfK.lxA.Es();
      }
    }
    AppMethodBeat.o(70397);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoSightCenterView.1
 * JD-Core Version:    0.7.0.1
 */