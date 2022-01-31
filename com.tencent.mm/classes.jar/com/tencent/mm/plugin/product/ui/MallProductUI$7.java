package com.tencent.mm.plugin.product.ui;

import android.content.res.Resources;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.wxpay.a.b;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import java.util.ArrayList;
import java.util.List;

final class MallProductUI$7
  implements MenuItem.OnMenuItemClickListener
{
  MallProductUI$7(MallProductUI paramMallProductUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = this.mVg.getResources().getStringArray(a.b.mall_product_share_opt_list);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramMenuItem.length)
    {
      localArrayList.add(paramMenuItem[i]);
      i += 1;
    }
    if ((this.mVg.mTL.brQ().mTH & 0x1) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      y.d("MicroMsg.MallProductConfig", "isShowSellerEntry, ret = " + bool);
      if (bool) {
        localArrayList.add(this.mVg.getString(a.i.mall_product_seller_opt));
      }
      h.a(this.mVg.mController.uMN, null, (String[])localArrayList.toArray(new String[localArrayList.size()]), null, false, new MallProductUI.7.1(this));
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductUI.7
 * JD-Core Version:    0.7.0.1
 */