package com.tencent.mm.ui.conversation;

import com.tencent.mm.pluginsdk.f.i;
import com.tencent.mm.protocal.c.bxs;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.a.c;

final class j$4$1
  implements Runnable
{
  j$4$1(j.4 param4) {}
  
  public final void run()
  {
    if ((j.i(this.vTp.vTn) != null) && (j.i(this.vTp.vTn).isShowing()))
    {
      y.i("MicroMsg.InitHelper", "update dialog is showing.");
      return;
    }
    com.tencent.mm.plugin.report.service.h.nFQ.a(614L, 60L, 1L, false);
    j.a(this.vTp.vTn, com.tencent.mm.ui.base.h.a(j.a(this.vTp.vTn), this.vTp.vTo.bHk, this.vTp.vTo.title, this.vTp.vTo.tNL, this.vTp.vTo.lfK, false, new j.4.1.1(this), new j.4.1.2(this)));
    i.clo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.j.4.1
 * JD-Core Version:    0.7.0.1
 */