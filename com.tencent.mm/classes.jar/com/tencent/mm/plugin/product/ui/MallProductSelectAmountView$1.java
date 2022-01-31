package com.tencent.mm.plugin.product.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MallProductSelectAmountView$1
  implements View.OnClickListener
{
  MallProductSelectAmountView$1(MallProductSelectAmountView paramMallProductSelectAmountView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(44095);
    if (MallProductSelectAmountView.a(this.pws) + 1 > MallProductSelectAmountView.b(this.pws))
    {
      if (MallProductSelectAmountView.c(this.pws) != null) {
        MallProductSelectAmountView.c(this.pws).fi(MallProductSelectAmountView.a(this.pws), MallProductSelectAmountView.d(this.pws));
      }
      AppMethodBeat.o(44095);
      return;
    }
    MallProductSelectAmountView.e(this.pws);
    if (MallProductSelectAmountView.f(this.pws)) {
      MallProductSelectAmountView.g(this.pws).setText(MallProductSelectAmountView.a(this.pws));
    }
    if (MallProductSelectAmountView.c(this.pws) != null) {
      MallProductSelectAmountView.c(this.pws).gz(MallProductSelectAmountView.a(this.pws));
    }
    AppMethodBeat.o(44095);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductSelectAmountView.1
 * JD-Core Version:    0.7.0.1
 */