package com.tencent.mm.plugin.multitalk.ui.widget;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class CollapseView$2
  implements Runnable
{
  CollapseView$2(View paramView1, int paramInt, View paramView2) {}
  
  public final void run()
  {
    AppMethodBeat.i(178906);
    Rect localRect = new Rect();
    this.val$view.getHitRect(localRect);
    localRect.top -= this.fLb;
    localRect.bottom += this.fLb;
    localRect.left -= this.fLb;
    localRect.right += this.fLb;
    this.uZX.setTouchDelegate(new TouchDelegate(localRect, this.val$view));
    AppMethodBeat.o(178906);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.CollapseView.2
 * JD-Core Version:    0.7.0.1
 */