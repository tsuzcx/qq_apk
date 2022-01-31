package com.tencent.mm.plugin.product.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;

final class MallProductSubmitUI$4
  implements View.OnClickListener
{
  MallProductSubmitUI$4(MallProductSubmitUI paramMallProductSubmitUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = MallProductSubmitUI.d(this.mUW);
    Intent localIntent = new Intent();
    localIntent.putExtra("launch_from_webview", true);
    d.a(paramView.fyk, "address", ".ui.WalletSelectAddrUI", localIntent, 1, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductSubmitUI.4
 * JD-Core Version:    0.7.0.1
 */