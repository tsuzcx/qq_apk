package com.tencent.mm.plugin.sns.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

final class SnsTimelineVideoView$2
  implements Runnable
{
  SnsTimelineVideoView$2(SnsTimelineVideoView paramSnsTimelineVideoView, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(100384);
    try
    {
      SnsTimelineVideoView.a(this.ASz).PR(this.ASA);
      SnsTimelineVideoView.b(this.ASz);
      AppMethodBeat.o(100384);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.Sns.SnsOnlineVideoView", localException, "doUICallback", new Object[0]);
      AppMethodBeat.o(100384);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView.2
 * JD-Core Version:    0.7.0.1
 */