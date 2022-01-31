package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class OnlineVideoView$2$1
  implements Runnable
{
  OnlineVideoView$2$1(OnlineVideoView.2 param2, boolean paramBoolean, String paramString) {}
  
  public final void run()
  {
    y.i("MicroMsg.OnlineVideoView", "%d weixin download finish[%b], go to prepare video", new Object[] { Integer.valueOf(this.oRN.oRM.hashCode()), Boolean.valueOf(this.elN) });
    if ((OnlineVideoView.e(this.oRN.oRM) != null) && (this.elN) && (bk.isEqual(OnlineVideoView.e(this.oRN.oRM).lsK, this.BF)))
    {
      aq.eL(OnlineVideoView.a(this.oRN.oRM), "");
      String str = aq.a(OnlineVideoView.a(this.oRN.oRM), OnlineVideoView.e(this.oRN.oRM));
      if (!bk.bl(str)) {
        this.oRN.oRM.bg(str, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.OnlineVideoView.2.1
 * JD-Core Version:    0.7.0.1
 */