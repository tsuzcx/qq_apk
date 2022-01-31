package com.tencent.mm.plugin.shake.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.applet.b;

final class ShakeItemListUI$7
  implements View.OnTouchListener
{
  ShakeItemListUI$7(ShakeItemListUI paramShakeItemListUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(24726);
    if (ShakeItemListUI.b(this.qPL) != null)
    {
      paramView = ShakeItemListUI.b(this.qPL);
      if (paramView.gxo != null) {
        paramView.gxo.onTouchEvent(paramMotionEvent);
      }
    }
    AppMethodBeat.o(24726);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeItemListUI.7
 * JD-Core Version:    0.7.0.1
 */