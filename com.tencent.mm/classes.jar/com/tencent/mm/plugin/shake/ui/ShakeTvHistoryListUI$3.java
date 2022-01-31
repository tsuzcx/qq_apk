package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.d.a.k;
import com.tencent.mm.plugin.shake.d.a.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class ShakeTvHistoryListUI$3
  implements AdapterView.OnItemClickListener
{
  ShakeTvHistoryListUI$3(ShakeTvHistoryListUI paramShakeTvHistoryListUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(24895);
    paramAdapterView = (n)ShakeTvHistoryListUI.a(this.qRG).getItem(paramInt);
    paramView = this.qRG.getContext();
    if (paramAdapterView != null)
    {
      if ((bo.isNullOrNil(paramAdapterView.field_username)) && (bo.isNullOrNil(paramAdapterView.field_deeplink)))
      {
        h.qsU.e(12108, new Object[] { bo.nullAsNil(paramAdapterView.field_username), Integer.valueOf(2), Integer.valueOf(0) });
        AppMethodBeat.o(24895);
        return;
      }
      k.a(paramAdapterView.field_username, paramAdapterView.field_deeplink, 2, paramView);
      ab.i("Micromsg.ShakeTVLogic", "doShakeTvHistoryItemClick start do nth");
    }
    AppMethodBeat.o(24895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeTvHistoryListUI.3
 * JD-Core Version:    0.7.0.1
 */