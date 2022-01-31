package com.tencent.mm.plugin.product.ui;

import android.widget.Button;
import android.widget.LinearLayout;

final class MallProductUI$1
  implements f.a
{
  MallProductUI$1(MallProductUI paramMallProductUI) {}
  
  public final void q(int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.mVg.aZ();
      if (MallProductUI.a(this.mVg) != null) {
        MallProductUI.a(this.mVg).postDelayed(new MallProductUI.1.1(this), 200L);
      }
      return;
    }
    if (paramInt2 == -10010003)
    {
      this.mVg.vN(0);
      MallProductUI.b(this.mVg).setVisibility(8);
      MallProductUI.c(this.mVg).setVisibility(0);
      MallProductUI.d(this.mVg);
      return;
    }
    this.mVg.KQ(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductUI.1
 * JD-Core Version:    0.7.0.1
 */