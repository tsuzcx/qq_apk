package com.tencent.mm.plugin.shake.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.ui.applet.b;

final class ShakeItemListUI$7
  implements View.OnTouchListener
{
  ShakeItemListUI$7(ShakeItemListUI paramShakeItemListUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (ShakeItemListUI.b(this.obE) != null)
    {
      paramView = ShakeItemListUI.b(this.obE);
      if (paramView.ffG != null) {
        paramView.ffG.onTouchEvent(paramMotionEvent);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeItemListUI.7
 * JD-Core Version:    0.7.0.1
 */