package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.wr;
import com.tencent.mm.f.a.wr.a;
import com.tencent.mm.sdk.platformtools.Util;

final class OnlineVideoView$14$1
  implements Runnable
{
  OnlineVideoView$14$1(OnlineVideoView.14 param14, wr paramwr) {}
  
  public final void run()
  {
    AppMethodBeat.i(292893);
    if (Util.isEqual(this.OfY.fVL.fCM, OnlineVideoView.s(this.OfZ.KHP)))
    {
      if (!OnlineVideoView.I(this.OfZ.KHP))
      {
        OnlineVideoView.a(this.OfZ.KHP, true);
        this.OfZ.KHP.onResume();
        AppMethodBeat.o(292893);
        return;
      }
      this.OfZ.KHP.requestLayout();
      AppMethodBeat.o(292893);
      return;
    }
    OnlineVideoView.a(this.OfZ.KHP, false);
    this.OfZ.KHP.fUg();
    this.OfZ.KHP.onDestroy();
    AppMethodBeat.o(292893);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OnlineVideoView.14.1
 * JD-Core Version:    0.7.0.1
 */