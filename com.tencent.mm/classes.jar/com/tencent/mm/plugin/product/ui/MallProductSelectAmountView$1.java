package com.tencent.mm.plugin.product.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

final class MallProductSelectAmountView$1
  implements View.OnClickListener
{
  MallProductSelectAmountView$1(MallProductSelectAmountView paramMallProductSelectAmountView) {}
  
  public final void onClick(View paramView)
  {
    if (MallProductSelectAmountView.a(this.mUm) + 1 > MallProductSelectAmountView.b(this.mUm)) {
      if (MallProductSelectAmountView.c(this.mUm) != null) {
        MallProductSelectAmountView.c(this.mUm).dC(MallProductSelectAmountView.a(this.mUm), MallProductSelectAmountView.d(this.mUm));
      }
    }
    do
    {
      return;
      MallProductSelectAmountView.e(this.mUm);
      if (MallProductSelectAmountView.f(this.mUm)) {
        MallProductSelectAmountView.g(this.mUm).setText(MallProductSelectAmountView.a(this.mUm));
      }
    } while (MallProductSelectAmountView.c(this.mUm) == null);
    MallProductSelectAmountView.c(this.mUm).ex(MallProductSelectAmountView.a(this.mUm));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductSelectAmountView.1
 * JD-Core Version:    0.7.0.1
 */