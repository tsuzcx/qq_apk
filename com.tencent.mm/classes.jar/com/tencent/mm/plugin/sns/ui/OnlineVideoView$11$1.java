package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class OnlineVideoView$11$1
  implements Runnable
{
  OnlineVideoView$11$1(OnlineVideoView.11 param11, boolean paramBoolean, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(292709);
    Log.i(OnlineVideoView.c(this.Ofw.KHP), "%d weixin download finish[%b], go to prepare video", new Object[] { Integer.valueOf(this.Ofw.KHP.hashCode()), Boolean.valueOf(this.lLY) });
    if ((OnlineVideoView.u(this.Ofw.KHP) != null) && (this.lLY) && (Util.isEqual(OnlineVideoView.u(this.Ofw.KHP).Id, this.acq)))
    {
      ax.kF(OnlineVideoView.s(this.Ofw.KHP), "");
      String str = ax.a(OnlineVideoView.s(this.Ofw.KHP), OnlineVideoView.u(this.Ofw.KHP));
      if (!Util.isNullOrNil(str)) {
        this.Ofw.KHP.cD(str, false);
      }
    }
    AppMethodBeat.o(292709);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OnlineVideoView.11.1
 * JD-Core Version:    0.7.0.1
 */