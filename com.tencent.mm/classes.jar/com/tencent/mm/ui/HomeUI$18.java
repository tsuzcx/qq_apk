package com.tencent.mm.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.report.service.h;

final class HomeUI$18
  implements Runnable
{
  HomeUI$18(HomeUI paramHomeUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(33198);
    if (((a.p(HomeUI.c(this.adBf), true)) && (!a.dl(HomeUI.c(this.adBf)))) || (a.u(HomeUI.c(this.adBf), true)))
    {
      AppMethodBeat.o(33198);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("BaseScanUI_select_scan_mode", 1);
    localIntent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 0);
    localIntent.putExtra("key_enable_multi_code", true);
    localIntent.putExtra("key_scan_goods_enable_dynamic_wording", true);
    localIntent.putExtra("key_enable_scan_code_product_merge", true);
    localIntent.putExtra("key_scan_entry_scene", 5);
    localIntent.setFlags(65536);
    h.OAn.b(11409, new Object[0]);
    c.b(HomeUI.c(this.adBf), "scanner", ".ui.BaseScanUI", localIntent);
    AppMethodBeat.o(33198);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.18
 * JD-Core Version:    0.7.0.1
 */