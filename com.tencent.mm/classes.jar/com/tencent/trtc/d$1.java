package com.tencent.trtc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

final class d$1
  implements Runnable
{
  d$1(WXTRTCCloud paramWXTRTCCloud) {}
  
  public final void run()
  {
    AppMethodBeat.i(14310);
    WXTRTCCloud.access$000(this.IIK).clear();
    WXTRTCCloud.access$100(this.IIK).clear();
    WXTRTCCloud.access$200(this.IIK).clear();
    WXTRTCCloud.access$300(this.IIK).clear();
    AppMethodBeat.o(14310);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.trtc.d.1
 * JD-Core Version:    0.7.0.1
 */