package com.tencent.mm.wallet_core.ui;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$8
  implements Runnable
{
  e$8(View paramView1, int paramInt, View paramView2) {}
  
  public final void run()
  {
    AppMethodBeat.i(72988);
    Rect localRect = new Rect();
    this.val$view.getHitRect(localRect);
    localRect.top -= this.fHu;
    localRect.bottom += this.fHu;
    localRect.left -= this.fHu;
    localRect.right += this.fHu;
    this.tRp.setTouchDelegate(new TouchDelegate(localRect, this.val$view));
    AppMethodBeat.o(72988);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.e.8
 * JD-Core Version:    0.7.0.1
 */