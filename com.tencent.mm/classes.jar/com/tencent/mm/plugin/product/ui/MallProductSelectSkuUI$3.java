package com.tencent.mm.plugin.product.ui;

import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.i;

final class MallProductSelectSkuUI$3
  implements MallProductSelectAmountView.a
{
  MallProductSelectSkuUI$3(MallProductSelectSkuUI paramMallProductSelectSkuUI) {}
  
  public final void dC(int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    case 2: 
    default: 
      return;
    case 1: 
      MallProductSelectSkuUI.c(this.mUv).setText(a.i.mall_product_select_sku_amount_err);
      MallProductSelectSkuUI.c(this.mUv).setVisibility(0);
      return;
    }
    MallProductSelectSkuUI.c(this.mUv).setText(this.mUv.getString(a.i.mall_product_select_sku_amount_limit_err, new Object[] { Integer.valueOf(paramInt1) }));
    MallProductSelectSkuUI.c(this.mUv).setVisibility(0);
  }
  
  public final void ex(int paramInt)
  {
    MallProductSelectSkuUI.b(this.mUv).mCount = paramInt;
    MallProductSelectSkuUI.c(this.mUv).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductSelectSkuUI.3
 * JD-Core Version:    0.7.0.1
 */