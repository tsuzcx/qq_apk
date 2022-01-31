package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.h.a.qe;
import com.tencent.mm.h.a.qe.a;
import com.tencent.mm.sdk.platformtools.bk;

final class OnlineVideoView$4$1
  implements Runnable
{
  OnlineVideoView$4$1(OnlineVideoView.4 param4, qe paramqe) {}
  
  public final void run()
  {
    if (bk.isEqual(this.oRO.bZC.bMB, OnlineVideoView.a(this.oRP.oRM)))
    {
      if (!OnlineVideoView.q(this.oRP.oRM))
      {
        OnlineVideoView.a(this.oRP.oRM, true);
        this.oRP.oRM.onResume();
        return;
      }
      this.oRP.oRM.requestLayout();
      return;
    }
    OnlineVideoView.a(this.oRP.oRM, false);
    this.oRP.oRM.bHM();
    this.oRP.oRM.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OnlineVideoView.4.1
 * JD-Core Version:    0.7.0.1
 */