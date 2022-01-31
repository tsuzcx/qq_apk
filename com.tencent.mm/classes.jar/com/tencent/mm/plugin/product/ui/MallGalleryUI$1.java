package com.tencent.mm.plugin.product.ui;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class MallGalleryUI$1
  implements ViewPager.OnPageChangeListener
{
  MallGalleryUI$1(MallGalleryUI paramMallGalleryUI) {}
  
  public final void onPageScrollStateChanged(int paramInt) {}
  
  public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public final void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(44035);
    ab.d("MicroMsg.MallGalleryUI", "Page Selected postion: %d", new Object[] { Integer.valueOf(paramInt) });
    MallGalleryUI.a(this.pvE, paramInt);
    if (MallGalleryUI.a(this.pvE))
    {
      this.pvE.hideTitleView();
      MallGalleryUI.b(this.pvE);
    }
    AppMethodBeat.o(44035);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallGalleryUI.1
 * JD-Core Version:    0.7.0.1
 */