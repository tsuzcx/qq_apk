package com.tencent.mm.wallet_core.ui;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class i$11
  implements Runnable
{
  i$11(View paramView1, int paramInt, View paramView2) {}
  
  public final void run()
  {
    AppMethodBeat.i(72988);
    Rect localRect = new Rect();
    this.val$view.getHitRect(localRect);
    localRect.top -= this.lZX;
    localRect.bottom += this.lZX;
    localRect.left -= this.lZX;
    localRect.right += this.lZX;
    this.Lts.setTouchDelegate(new TouchDelegate(localRect, this.val$view));
    AppMethodBeat.o(72988);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.i.11
 * JD-Core Version:    0.7.0.1
 */