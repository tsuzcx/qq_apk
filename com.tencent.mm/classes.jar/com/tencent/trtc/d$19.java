package com.tencent.trtc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.ITXLivePlayListener;
import java.lang.ref.WeakReference;
import java.util.HashMap;

final class d$19
  implements Runnable
{
  d$19(WXTRTCCloud paramWXTRTCCloud, boolean paramBoolean, String paramString, ITXLivePlayListener paramITXLivePlayListener) {}
  
  public final void run()
  {
    AppMethodBeat.i(14293);
    if (this.a)
    {
      WXTRTCCloud.access$300(this.IIP).put(this.b, new WeakReference(this.IIT));
      AppMethodBeat.o(14293);
      return;
    }
    WXTRTCCloud.access$200(this.IIP).put(this.b, new WeakReference(this.IIT));
    AppMethodBeat.o(14293);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.trtc.d.19
 * JD-Core Version:    0.7.0.1
 */