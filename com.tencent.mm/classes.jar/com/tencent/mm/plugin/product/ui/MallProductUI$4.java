package com.tencent.mm.plugin.product.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.wallet_core.ui.e;

final class MallProductUI$4
  implements View.OnClickListener
{
  MallProductUI$4(MallProductUI paramMallProductUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(44160);
    paramView = MallProductUI.e(this.pxl);
    e.ae(paramView.gQx, paramView.pvR.cbc());
    AppMethodBeat.o(44160);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductUI.4
 * JD-Core Version:    0.7.0.1
 */