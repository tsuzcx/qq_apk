package com.tencent.mm.plugin.product.ui;

import android.content.res.Resources;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.wxpay.a.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;

final class MallGalleryUI$4
  implements MenuItem.OnMenuItemClickListener
{
  MallGalleryUI$4(MallGalleryUI paramMallGalleryUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if (d.SP("favorite")) {}
    for (paramMenuItem = this.mTy.getResources().getStringArray(a.b.mall_product_gallery_ui_opt_list_with_fav);; paramMenuItem = this.mTy.getResources().getStringArray(a.b.mall_product_gallery_ui_opt_list_without_fav))
    {
      h.a(this.mTy.mController.uMN, null, paramMenuItem, null, false, new MallGalleryUI.4.1(this));
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallGalleryUI.4
 * JD-Core Version:    0.7.0.1
 */