package com.tencent.mm.plugin.product.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.bjm;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.s;

final class MallProductReceiptUI$1
  implements MenuItem.OnMenuItemClickListener
{
  MallProductReceiptUI$1(MallProductReceiptUI paramMallProductReceiptUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    int i = 0;
    paramMenuItem = MallProductReceiptUI.a(this.mUe).getText().toString();
    if (!bk.bl(paramMenuItem))
    {
      c localc = MallProductReceiptUI.b(this.mUe);
      localc.mRW = new bjm();
      bjm localbjm = localc.mRW;
      if (bk.bl(paramMenuItem)) {}
      for (;;)
      {
        localbjm.tDr = i;
        localc.mRW.kSY = paramMenuItem;
        this.mUe.finish();
        return true;
        i = 1;
      }
    }
    s.makeText(this.mUe, a.i.mall_product_receipt_empty_tips, 0).show();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductReceiptUI.1
 * JD-Core Version:    0.7.0.1
 */