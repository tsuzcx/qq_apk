package com.tencent.mm.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.r.a;

final class HomeUI$17
  implements Runnable
{
  HomeUI$17(HomeUI paramHomeUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(153778);
    if ((a.bN(HomeUI.b(this.yYw))) && (!a.bM(HomeUI.b(this.yYw))))
    {
      AppMethodBeat.o(153778);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("BaseScanUI_select_scan_mode", 1);
    localIntent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 0);
    localIntent.setFlags(65536);
    h.qsU.e(11409, new Object[0]);
    d.b(HomeUI.b(this.yYw), "scanner", ".ui.BaseScanUI", localIntent);
    AppMethodBeat.o(153778);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.17
 * JD-Core Version:    0.7.0.1
 */