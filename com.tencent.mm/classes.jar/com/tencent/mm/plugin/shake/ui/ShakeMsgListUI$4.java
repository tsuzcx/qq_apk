package com.tencent.mm.plugin.shake.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.b.f;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class ShakeMsgListUI$4
  implements AdapterView.OnItemClickListener
{
  ShakeMsgListUI$4(ShakeMsgListUI paramShakeMsgListUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (f)ShakeMsgListUI.b(this.obT).getItem(paramInt);
    if (!bk.bl(paramAdapterView.field_tag))
    {
      h.nFQ.aC(11316, ShakeMsgListUI.g(this.obT) + "," + paramAdapterView.field_tag);
      paramView = new Intent();
      paramView.putExtra("rawUrl", paramAdapterView.field_tag);
      com.tencent.mm.br.d.b(this.obT.mController.uMN, "webview", ".ui.tools.WebViewUI", paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeMsgListUI.4
 * JD-Core Version:    0.7.0.1
 */