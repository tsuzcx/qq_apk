package com.tencent.mm.plugin.scanner.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewParent;

final class ProductFurtherInfoUI$3
  implements View.OnTouchListener
{
  ProductFurtherInfoUI$3(ProductFurtherInfoUI paramProductFurtherInfoUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramView != null) && (paramView.getParent() != null)) {
      paramView.getParent().requestDisallowInterceptTouchEvent(true);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductFurtherInfoUI.3
 * JD-Core Version:    0.7.0.1
 */