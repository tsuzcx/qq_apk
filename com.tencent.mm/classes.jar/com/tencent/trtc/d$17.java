package com.tencent.trtc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

final class d$17
  implements Runnable
{
  d$17(WXTRTCCloud paramWXTRTCCloud, String paramString, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(14296);
    if (WXTRTCCloud.access$000(this.IIO).containsKey(this.a))
    {
      d.b localb = (d.b)WXTRTCCloud.access$000(this.IIO).get(this.a);
      if (localb != null)
      {
        if (this.b) {
          localb.c = null;
        }
        while ((localb.IIV == null) && (localb.c == null))
        {
          WXTRTCCloud.access$000(this.IIO).remove(this.a);
          AppMethodBeat.o(14296);
          return;
          localb.IIV = null;
        }
      }
      WXTRTCCloud.access$000(this.IIO).remove(this.a);
    }
    AppMethodBeat.o(14296);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.trtc.d.17
 * JD-Core Version:    0.7.0.1
 */