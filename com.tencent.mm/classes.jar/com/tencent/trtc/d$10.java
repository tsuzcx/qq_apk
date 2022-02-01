package com.tencent.trtc;

import com.tencent.liteav.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$10
  implements Runnable
{
  d$10(WXTRTCCloud paramWXTRTCCloud, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(14375);
    WXTRTCCloud.access$1400(this.IIM, "enableBlackStream " + this.a);
    if (WXTRTCCloud.access$1500(this.IIM) != null) {
      WXTRTCCloud.access$1600(this.IIM).b(this.a);
    }
    AppMethodBeat.o(14375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.trtc.d.10
 * JD-Core Version:    0.7.0.1
 */