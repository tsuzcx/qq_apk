package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.d.a.k;
import com.tencent.mm.plugin.shake.d.a.n;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class ShakeTvHistoryListUI$3
  implements AdapterView.OnItemClickListener
{
  ShakeTvHistoryListUI$3(ShakeTvHistoryListUI paramShakeTvHistoryListUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (n)ShakeTvHistoryListUI.a(this.odz).getItem(paramInt);
    paramView = this.odz.mController.uMN;
    if (paramAdapterView != null)
    {
      if ((bk.bl(paramAdapterView.field_username)) && (bk.bl(paramAdapterView.field_deeplink))) {
        h.nFQ.f(12108, new Object[] { bk.pm(paramAdapterView.field_username), Integer.valueOf(2), Integer.valueOf(0) });
      }
    }
    else {
      return;
    }
    k.a(paramAdapterView.field_username, paramAdapterView.field_deeplink, 2, paramView);
    y.i("Micromsg.ShakeTVLogic", "doShakeTvHistoryItemClick start do nth");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeTvHistoryListUI.3
 * JD-Core Version:    0.7.0.1
 */