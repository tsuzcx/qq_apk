package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kiss.layout.b;

final class y$16
  implements View.OnAttachStateChangeListener
{
  y$16(y paramy) {}
  
  public final void onViewAttachedToWindow(View paramView) {}
  
  public final void onViewDetachedFromWindow(View paramView)
  {
    AppMethodBeat.i(141345);
    y.e(this.adEy).removeOnAttachStateChangeListener(this);
    b.bbH();
    AppMethodBeat.o(141345);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.y.16
 * JD-Core Version:    0.7.0.1
 */