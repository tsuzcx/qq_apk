package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;

final class MMTagPanel$4
  implements View.OnClickListener
{
  MMTagPanel$4(MMTagPanel paramMMTagPanel) {}
  
  public final void onClick(View paramView)
  {
    y.d("MicroMsg.MMTagPanel", "on edittext click");
    this.uYn.cBd();
    if (MMTagPanel.e(this.uYn) != null) {
      MMTagPanel.e(this.uYn).aJI();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMTagPanel.4
 * JD-Core Version:    0.7.0.1
 */