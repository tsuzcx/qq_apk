package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ro;
import com.tencent.mm.g.a.ro.a;
import com.tencent.mm.sdk.platformtools.bo;

final class OnlineVideoView$4$1
  implements Runnable
{
  OnlineVideoView$4$1(OnlineVideoView.4 param4, ro paramro) {}
  
  public final void run()
  {
    AppMethodBeat.i(38389);
    if (bo.isEqual(this.rJF.cHU.ctV, OnlineVideoView.a(this.rJG.rJD)))
    {
      if (!OnlineVideoView.o(this.rJG.rJD))
      {
        OnlineVideoView.a(this.rJG.rJD, true);
        this.rJG.rJD.onResume();
        AppMethodBeat.o(38389);
        return;
      }
      this.rJG.rJD.requestLayout();
      AppMethodBeat.o(38389);
      return;
    }
    OnlineVideoView.a(this.rJG.rJD, false);
    this.rJG.rJD.ctS();
    this.rJG.rJD.onDestroy();
    AppMethodBeat.o(38389);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OnlineVideoView.4.1
 * JD-Core Version:    0.7.0.1
 */