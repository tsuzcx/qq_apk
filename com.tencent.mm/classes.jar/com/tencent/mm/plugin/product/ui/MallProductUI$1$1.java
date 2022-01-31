package com.tencent.mm.plugin.product.ui;

import android.widget.ScrollView;
import com.tencent.mm.plugin.wxpay.a.f;

final class MallProductUI$1$1
  implements Runnable
{
  MallProductUI$1$1(MallProductUI.1 param1) {}
  
  public final void run()
  {
    ScrollView localScrollView = (ScrollView)this.mVh.mVg.findViewById(a.f.mall_product_sv);
    if (localScrollView != null) {
      localScrollView.pageScroll(33);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductUI.1.1
 * JD-Core Version:    0.7.0.1
 */