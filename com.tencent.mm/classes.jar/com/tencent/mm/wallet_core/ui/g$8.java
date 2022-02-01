package com.tencent.mm.wallet_core.ui;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class g$8
  implements Runnable
{
  g$8(View paramView1, int paramInt, View paramView2) {}
  
  public final void run()
  {
    AppMethodBeat.i(72988);
    Rect localRect = new Rect();
    this.val$view.getHitRect(localRect);
    localRect.top -= this.jwF;
    localRect.bottom += this.jwF;
    localRect.left -= this.jwF;
    localRect.right += this.jwF;
    this.Fxi.setTouchDelegate(new TouchDelegate(localRect, this.val$view));
    AppMethodBeat.o(72988);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.g.8
 * JD-Core Version:    0.7.0.1
 */