package com.tencent.mm.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.base.preference.IconPreference;

final class FindMoreFriendsUI$15$2
  implements Runnable
{
  FindMoreFriendsUI$15$2(FindMoreFriendsUI.15 param15, Bitmap paramBitmap, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(29228);
    FindMoreFriendsUI.a(this.yWS.yWI, true);
    this.yWS.yWQ.ap(this.kCo);
    if (this.yWS.yWR == 3) {
      FindMoreFriendsUI.b(this.yWS.yWQ, 8, 8, false, 0, 0, 0);
    }
    for (;;)
    {
      FindMoreFriendsUI.c(this.yWS.val$appId, this.yWS.uls, this.yWS.tgD, this.yWS.fkN, this.yWS.yWR);
      if (this.jiC == 2) {
        h.qsU.idkeyStat(858L, 13L, 1L, false);
      }
      AppMethodBeat.o(29228);
      return;
      if (this.yWS.yWR == 4) {
        FindMoreFriendsUI.b(this.yWS.yWQ, 8, 0, false, 0, 0, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.FindMoreFriendsUI.15.2
 * JD-Core Version:    0.7.0.1
 */