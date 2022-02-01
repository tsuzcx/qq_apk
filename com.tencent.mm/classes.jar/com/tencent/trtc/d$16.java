package com.tencent.trtc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.HashMap;

final class d$16
  implements Runnable
{
  d$16(WXTRTCCloud paramWXTRTCCloud, String paramString, boolean paramBoolean, WXTRTCCloud.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener) {}
  
  public final void run()
  {
    AppMethodBeat.i(14306);
    d.b localb;
    if (WXTRTCCloud.access$000(this.IIP).containsKey(this.a))
    {
      localb = (d.b)WXTRTCCloud.access$000(this.IIP).get(this.a);
      if (localb != null)
      {
        if (!this.b) {
          break label107;
        }
        localb.c = new WeakReference(this.IIQ);
      }
    }
    for (;;)
    {
      WXTRTCCloud.access$000(this.IIP).put(this.a, localb);
      AppMethodBeat.o(14306);
      return;
      localb = new d.b((byte)0);
      localb.a = 0;
      break;
      label107:
      localb.IIV = new WeakReference(this.IIQ);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.trtc.d.16
 * JD-Core Version:    0.7.0.1
 */