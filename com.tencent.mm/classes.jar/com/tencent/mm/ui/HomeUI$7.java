package com.tencent.mm.ui;

import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.r.a;

final class HomeUI$7
  implements Runnable
{
  HomeUI$7(HomeUI paramHomeUI) {}
  
  public final void run()
  {
    if ((a.bj(HomeUI.d(this.uKu))) && (!a.bi(HomeUI.d(this.uKu)))) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("BaseScanUI_select_scan_mode", 1);
    localIntent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 0);
    localIntent.setFlags(65536);
    h.nFQ.f(11409, new Object[0]);
    d.b(HomeUI.d(this.uKu), "scanner", ".ui.BaseScanUI", localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.7
 * JD-Core Version:    0.7.0.1
 */