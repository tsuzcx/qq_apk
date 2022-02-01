package com.tencent.trtc;

import android.view.Surface;
import com.tencent.liteav.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$4
  implements Runnable
{
  d$4(WXTRTCCloud paramWXTRTCCloud, Surface paramSurface) {}
  
  public final void run()
  {
    AppMethodBeat.i(14302);
    WXTRTCCloud.access$400(this.IIM, "setLocalSurface " + this.a);
    WXTRTCCloud.access$500(this.IIM).a(this.a);
    AppMethodBeat.o(14302);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.trtc.d.4
 * JD-Core Version:    0.7.0.1
 */