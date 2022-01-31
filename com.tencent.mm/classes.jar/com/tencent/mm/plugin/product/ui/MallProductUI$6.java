package com.tencent.mm.plugin.product.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.s;

final class MallProductUI$6
  implements View.OnClickListener
{
  MallProductUI$6(MallProductUI paramMallProductUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = MallProductUI.e(this.mVg);
    if (paramView.mTL.bsa())
    {
      paramView.fyk.startActivity(new Intent(paramView.fyk, MallProductSelectSkuUI.class));
      h.nFQ.f(11008, new Object[] { paramView.mTL.brW(), paramView.mTL.mRP.mSq, Integer.valueOf(f.fzn), Integer.valueOf(1) });
      return;
    }
    s.makeText(paramView.fyk, a.i.mall_product_data_loading, 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductUI.6
 * JD-Core Version:    0.7.0.1
 */