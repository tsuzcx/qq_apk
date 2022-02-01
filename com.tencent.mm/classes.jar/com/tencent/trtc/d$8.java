package com.tencent.trtc;

import com.tencent.liteav.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$8
  implements Runnable
{
  d$8(WXTRTCCloud paramWXTRTCCloud) {}
  
  public final void run()
  {
    AppMethodBeat.i(160399);
    WXTRTCCloud.access$800(this.IIK, "pausePusher");
    if (WXTRTCCloud.access$900(this.IIK) != null) {
      WXTRTCCloud.access$1000(this.IIK).g();
    }
    AppMethodBeat.o(160399);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.trtc.d.8
 * JD-Core Version:    0.7.0.1
 */