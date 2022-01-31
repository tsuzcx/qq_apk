package com.tencent.mm.plugin.product.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.sdk.platformtools.bk;

final class MallProductUI$2
  implements MenuItem.OnMenuItemClickListener
{
  MallProductUI$2(MallProductUI paramMallProductUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = MallProductUI.e(this.mVg);
    if (!bk.bl(paramMenuItem.mTL.mRR))
    {
      g.DQ();
      g.DO().dJT.a(new com.tencent.mm.plugin.product.b.f(paramMenuItem.mTL.bsd(), paramMenuItem.mTL.mRR), 0);
    }
    paramMenuItem.mTL.clear();
    this.mVg.finish();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductUI.2
 * JD-Core Version:    0.7.0.1
 */