package com.tencent.mm.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.q.a;

final class HomeUI$19
  implements Runnable
{
  HomeUI$19(HomeUI paramHomeUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(276970);
    if (((a.p(HomeUI.c(this.VWJ), true)) && (!a.cw(HomeUI.c(this.VWJ)))) || (a.t(HomeUI.c(this.VWJ), true)))
    {
      AppMethodBeat.o(276970);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("BaseScanUI_select_scan_mode", 1);
    localIntent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 0);
    localIntent.putExtra("key_enable_multi_code", true);
    localIntent.putExtra("key_scan_goods_enable_dynamic_wording", true);
    localIntent.putExtra("key_scan_entry_scene", 5);
    localIntent.setFlags(65536);
    h.IzE.a(11409, new Object[0]);
    c.b(HomeUI.c(this.VWJ), "scanner", ".ui.BaseScanUI", localIntent);
    AppMethodBeat.o(276970);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.19
 * JD-Core Version:    0.7.0.1
 */