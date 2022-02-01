package com.tencent.trtc;

import com.tencent.liteav.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$7
  implements Runnable
{
  d$7(WXTRTCCloud paramWXTRTCCloud, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(14308);
    WXTRTCCloud.access$600(this.IIO, "setLocalSurfaceSize: " + this.a + "," + this.b);
    WXTRTCCloud.access$700(this.IIO).a(this.a, this.b);
    AppMethodBeat.o(14308);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.trtc.d.7
 * JD-Core Version:    0.7.0.1
 */