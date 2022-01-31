package com.tencent.mm.plugin.product.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;

final class MallProductSubmitUI$4
  implements View.OnClickListener
{
  MallProductSubmitUI$4(MallProductSubmitUI paramMallProductSubmitUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(44142);
    paramView = MallProductSubmitUI.d(this.pxb);
    Intent localIntent = new Intent();
    localIntent.putExtra("launch_from_webview", true);
    d.a(paramView.gQx, "address", ".ui.WalletSelectAddrUI", localIntent, 1, false);
    AppMethodBeat.o(44142);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductSubmitUI.4
 * JD-Core Version:    0.7.0.1
 */