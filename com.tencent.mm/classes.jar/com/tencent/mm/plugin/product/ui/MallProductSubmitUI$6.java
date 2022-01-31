package com.tencent.mm.plugin.product.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MallProductSubmitUI$6
  implements View.OnClickListener
{
  MallProductSubmitUI$6(MallProductSubmitUI paramMallProductSubmitUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(44144);
    paramView = MallProductSubmitUI.d(this.pxb);
    Intent localIntent = new Intent(paramView.gQx, MallProductReceiptUI.class);
    paramView.gQx.startActivityForResult(localIntent, 4);
    AppMethodBeat.o(44144);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductSubmitUI.6
 * JD-Core Version:    0.7.0.1
 */