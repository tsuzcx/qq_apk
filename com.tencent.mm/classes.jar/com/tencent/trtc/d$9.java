package com.tencent.trtc;

import com.tencent.liteav.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$9
  implements Runnable
{
  d$9(WXTRTCCloud paramWXTRTCCloud) {}
  
  public final void run()
  {
    AppMethodBeat.i(14305);
    WXTRTCCloud.access$1100(this.IIK, "resumePusher");
    if (WXTRTCCloud.access$1200(this.IIK) != null) {
      WXTRTCCloud.access$1300(this.IIK).h();
    }
    AppMethodBeat.o(14305);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.trtc.d.9
 * JD-Core Version:    0.7.0.1
 */