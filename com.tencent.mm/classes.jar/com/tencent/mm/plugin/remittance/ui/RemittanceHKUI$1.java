package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class RemittanceHKUI$1
  implements View.OnClickListener
{
  RemittanceHKUI$1(RemittanceHKUI paramRemittanceHKUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(45073);
    ab.i("MicroMsg.RemittanceHKUI", "hy: on click banner");
    if (!bo.isNullOrNil(RemittanceHKUI.a(this.qqP)))
    {
      paramView = new Intent();
      paramView.putExtra("rawUrl", RemittanceHKUI.a(this.qqP));
      paramView.putExtra("showShare", false);
      d.b(this.qqP.getContext(), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramView);
    }
    AppMethodBeat.o(45073);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceHKUI.1
 * JD-Core Version:    0.7.0.1
 */