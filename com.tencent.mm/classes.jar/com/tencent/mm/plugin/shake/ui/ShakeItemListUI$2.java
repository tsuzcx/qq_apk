package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import android.view.View.OnClickListener;

final class ShakeItemListUI$2
  implements View.OnClickListener
{
  ShakeItemListUI$2(ShakeItemListUI paramShakeItemListUI) {}
  
  public final void onClick(View paramView)
  {
    ShakeItemListUI.a(this.obE, ShakeItemListUI.a(this.obE) ^ 0xFFFFFFFF);
    this.obE.xq(ShakeItemListUI.a(this.obE));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeItemListUI.2
 * JD-Core Version:    0.7.0.1
 */