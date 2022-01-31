package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mm.sdk.platformtools.y;

final class MMTagPanel$3
  implements View.OnFocusChangeListener
{
  MMTagPanel$3(MMTagPanel paramMMTagPanel) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    y.d("MicroMsg.MMTagPanel", "on edittext focus changed %B", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((paramBoolean) && (MMTagPanel.e(this.uYn) != null)) {
      MMTagPanel.e(this.uYn).aJI();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMTagPanel.3
 * JD-Core Version:    0.7.0.1
 */