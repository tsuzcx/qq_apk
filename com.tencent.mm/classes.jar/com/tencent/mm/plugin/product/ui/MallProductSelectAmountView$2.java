package com.tencent.mm.plugin.product.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MallProductSelectAmountView$2
  implements View.OnClickListener
{
  MallProductSelectAmountView$2(MallProductSelectAmountView paramMallProductSelectAmountView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(44096);
    if (MallProductSelectAmountView.a(this.pws) - 1 < MallProductSelectAmountView.h(this.pws))
    {
      if (MallProductSelectAmountView.c(this.pws) != null) {
        MallProductSelectAmountView.c(this.pws).fi(MallProductSelectAmountView.a(this.pws), 2);
      }
      AppMethodBeat.o(44096);
      return;
    }
    MallProductSelectAmountView.i(this.pws);
    if (MallProductSelectAmountView.f(this.pws)) {
      MallProductSelectAmountView.g(this.pws).setText(MallProductSelectAmountView.a(this.pws));
    }
    MallProductSelectAmountView.f(this.pws);
    if (MallProductSelectAmountView.c(this.pws) != null) {
      MallProductSelectAmountView.c(this.pws).gz(MallProductSelectAmountView.a(this.pws));
    }
    AppMethodBeat.o(44096);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductSelectAmountView.2
 * JD-Core Version:    0.7.0.1
 */