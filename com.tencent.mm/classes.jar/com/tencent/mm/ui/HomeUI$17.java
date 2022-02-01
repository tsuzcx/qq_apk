package com.tencent.mm.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.r.a;

final class HomeUI$17
  implements Runnable
{
  HomeUI$17(HomeUI paramHomeUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(186961);
    if (((a.n(HomeUI.b(this.Jta), true)) && (!a.cf(HomeUI.b(this.Jta)))) || (a.p(HomeUI.b(this.Jta), true)))
    {
      AppMethodBeat.o(186961);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("BaseScanUI_select_scan_mode", 1);
    localIntent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 0);
    localIntent.putExtra("key_enable_multi_code", true);
    localIntent.putExtra("key_scan_goods_enable_dynamic_wording", true);
    localIntent.setFlags(65536);
    g.yxI.f(11409, new Object[0]);
    d.b(HomeUI.b(this.Jta), "scanner", ".ui.BaseScanUI", localIntent);
    AppMethodBeat.o(186961);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.17
 * JD-Core Version:    0.7.0.1
 */