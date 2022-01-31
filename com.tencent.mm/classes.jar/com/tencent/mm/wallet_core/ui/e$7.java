package com.tencent.mm.wallet_core.ui;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$7
  implements Runnable
{
  e$7(View paramView1, int paramInt, View paramView2) {}
  
  public final void run()
  {
    AppMethodBeat.i(49262);
    Rect localRect = new Rect();
    this.val$view.getHitRect(localRect);
    localRect.top -= this.etV;
    localRect.bottom += this.etV;
    localRect.left -= this.etV;
    localRect.right += this.etV;
    this.AwQ.setTouchDelegate(new TouchDelegate(localRect, this.val$view));
    AppMethodBeat.o(49262);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.e.7
 * JD-Core Version:    0.7.0.1
 */