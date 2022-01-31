package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class RemittanceHKUI$1
  implements View.OnClickListener
{
  RemittanceHKUI$1(RemittanceHKUI paramRemittanceHKUI) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.RemittanceHKUI", "hy: on click banner");
    if (!bk.bl(RemittanceHKUI.a(this.nDW)))
    {
      paramView = new Intent();
      paramView.putExtra("rawUrl", RemittanceHKUI.a(this.nDW));
      paramView.putExtra("showShare", false);
      d.b(this.nDW.mController.uMN, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceHKUI.1
 * JD-Core Version:    0.7.0.1
 */