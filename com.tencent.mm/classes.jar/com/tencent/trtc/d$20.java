package com.tencent.trtc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

final class d$20
  implements Runnable
{
  d$20(WXTRTCCloud paramWXTRTCCloud, boolean paramBoolean, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(14309);
    if (this.a)
    {
      WXTRTCCloud.access$300(this.IIO).remove(this.b);
      AppMethodBeat.o(14309);
      return;
    }
    WXTRTCCloud.access$200(this.IIO).remove(this.b);
    AppMethodBeat.o(14309);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.trtc.d.20
 * JD-Core Version:    0.7.0.1
 */