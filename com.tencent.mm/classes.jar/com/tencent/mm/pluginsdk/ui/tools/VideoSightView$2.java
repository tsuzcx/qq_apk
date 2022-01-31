package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.sdk.platformtools.ab;

final class VideoSightView$2
  implements b.f
{
  VideoSightView$2(VideoSightView paramVideoSightView) {}
  
  public final void b(b paramb, long paramLong)
  {
    AppMethodBeat.i(70416);
    if (this.wfO.duration == 0) {
      this.wfO.duration = this.wfO.getDuration();
    }
    if (this.wfO.lxA != null)
    {
      ab.v("MicroMsg.VideoSightView", "onPlayTime, currentTime: %s, duration: %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(this.wfO.duration) });
      this.wfO.lxA.dP((int)paramLong, this.wfO.duration);
    }
    AppMethodBeat.o(70416);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoSightView.2
 * JD-Core Version:    0.7.0.1
 */