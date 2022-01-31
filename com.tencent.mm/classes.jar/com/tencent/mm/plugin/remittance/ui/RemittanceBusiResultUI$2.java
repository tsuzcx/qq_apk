package com.tencent.mm.plugin.remittance.ui;

import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.mm.plugin.wxpay.a.f;

final class RemittanceBusiResultUI$2
  implements Runnable
{
  RemittanceBusiResultUI$2(RemittanceBusiResultUI paramRemittanceBusiResultUI, ImageView paramImageView) {}
  
  public final void run()
  {
    ViewGroup localViewGroup = (ViewGroup)this.nBx.findViewById(a.f.scrollview_layout);
    ViewGroup.LayoutParams localLayoutParams = this.nBy.getLayoutParams();
    localLayoutParams.width = localViewGroup.getWidth();
    localLayoutParams.height = localViewGroup.getHeight();
    this.nBy.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiResultUI.2
 * JD-Core Version:    0.7.0.1
 */