package com.tencent.mm.plugin.product.ui;

import android.support.v4.view.ViewPager.e;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class MallGalleryUI$1
  implements ViewPager.e
{
  MallGalleryUI$1(MallGalleryUI paramMallGalleryUI) {}
  
  public final void Q(int paramInt) {}
  
  public final void R(int paramInt)
  {
    y.d("MicroMsg.MallGalleryUI", "Page Selected postion: %d", new Object[] { Integer.valueOf(paramInt) });
    MallGalleryUI.a(this.mTy, paramInt);
    if (MallGalleryUI.a(this.mTy))
    {
      this.mTy.mController.hideTitleView();
      MallGalleryUI.b(this.mTy);
    }
  }
  
  public final void a(int paramInt1, float paramFloat, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallGalleryUI.1
 * JD-Core Version:    0.7.0.1
 */