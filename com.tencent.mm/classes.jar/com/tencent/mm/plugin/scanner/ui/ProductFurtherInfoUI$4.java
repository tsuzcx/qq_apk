package com.tencent.mm.plugin.scanner.ui;

import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.e;
import android.view.ViewParent;
import com.tencent.mm.ui.base.MMPageControlView;

final class ProductFurtherInfoUI$4
  implements ViewPager.e
{
  ProductFurtherInfoUI$4(ProductFurtherInfoUI paramProductFurtherInfoUI) {}
  
  public final void Q(int paramInt) {}
  
  public final void R(int paramInt)
  {
    if (ProductFurtherInfoUI.b(this.nJQ).getParent() != null) {
      ProductFurtherInfoUI.b(this.nJQ).getParent().requestDisallowInterceptTouchEvent(true);
    }
    ProductFurtherInfoUI.c(this.nJQ).setPage(paramInt);
  }
  
  public final void a(int paramInt1, float paramFloat, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductFurtherInfoUI.4
 * JD-Core Version:    0.7.0.1
 */