package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class OnlineVideoView$2$1
  implements Runnable
{
  OnlineVideoView$2$1(OnlineVideoView.2 param2, boolean paramBoolean, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(38385);
    ab.i("MicroMsg.OnlineVideoView", "%d weixin download finish[%b], go to prepare video", new Object[] { Integer.valueOf(this.rJE.rJD.hashCode()), Boolean.valueOf(this.fCf) });
    if ((OnlineVideoView.c(this.rJE.rJD) != null) && (this.fCf) && (bo.isEqual(OnlineVideoView.c(this.rJE.rJD).Id, this.Cq)))
    {
      ar.gn(OnlineVideoView.a(this.rJE.rJD), "");
      String str = ar.a(OnlineVideoView.a(this.rJE.rJD), OnlineVideoView.c(this.rJE.rJD));
      if (!bo.isNullOrNil(str)) {
        this.rJE.rJD.bw(str, false);
      }
    }
    AppMethodBeat.o(38385);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OnlineVideoView.2.1
 * JD-Core Version:    0.7.0.1
 */