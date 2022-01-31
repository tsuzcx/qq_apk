package com.tencent.mm.plugin.shake.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.b.f;
import com.tencent.mm.sdk.platformtools.bo;

final class ShakeMsgListUI$4
  implements AdapterView.OnItemClickListener
{
  ShakeMsgListUI$4(ShakeMsgListUI paramShakeMsgListUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(24755);
    paramAdapterView = (f)ShakeMsgListUI.b(this.qQa).getItem(paramInt);
    if (!bo.isNullOrNil(paramAdapterView.field_tag))
    {
      h.qsU.kvStat(11316, ShakeMsgListUI.g(this.qQa) + "," + paramAdapterView.field_tag);
      paramView = new Intent();
      paramView.putExtra("rawUrl", paramAdapterView.field_tag);
      com.tencent.mm.bq.d.b(this.qQa.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
    }
    AppMethodBeat.o(24755);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeMsgListUI.4
 * JD-Core Version:    0.7.0.1
 */